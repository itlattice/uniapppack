package uts.sdk.modules.iboxsQcloudCos

import android.content.ContentUris
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.os.Environment
import android.provider.DocumentsContract
import android.provider.MediaStore
import com.tencent.cos.xml.CosXmlService
import com.tencent.cos.xml.CosXmlServiceConfig
import com.tencent.cos.xml.exception.CosXmlClientException
import com.tencent.cos.xml.exception.CosXmlServiceException
import com.tencent.cos.xml.listener.CosXmlProgressListener
import com.tencent.cos.xml.model.CosXmlRequest
import com.tencent.cos.xml.model.CosXmlResult
import com.tencent.cos.xml.transfer.TransferConfig
import com.tencent.cos.xml.transfer.TransferManager
import com.tencent.cos.xml.transfer.COSXMLUploadTask
import com.tencent.qcloud.core.auth.QCloudCredentialProvider
import com.tencent.qcloud.core.auth.SessionQCloudCredentials
import java.io.ByteArrayOutputStream
import java.io.FileInputStream
import java.io.InputStream
import java.io.File
import io.dcloud.uts.console

object TencentCOS {

    private lateinit var cosXmlService: CosXmlService
    private lateinit var transferManager: TransferManager

    /**
     * 初始化 COS 客户端
     */
    fun init(
        context: Context,
        secretId: String,
        secretKey: String,
        sessionToken: String?,
		host: String,
        region: String,
        startTime: Long,
        expiredTime: Long,
		isHttps:Boolean
    ) {
        val serviceConfig = CosXmlServiceConfig.Builder()
            .setRegion(region)
			.setHost(host)
            .isHttps(isHttps) // 是否使用 HTTPS
            .builder()

        // 使用临时密钥初始化
        val credentialProvider = object : QCloudCredentialProvider {
            override fun getCredentials(): SessionQCloudCredentials {
                return SessionQCloudCredentials(secretId, secretKey, sessionToken, startTime, expiredTime)
            }

            override fun refresh() {
                // 在这里可以添加刷新凭证的逻辑
                // 如果不需要刷新，可以留空
            }
        }

        cosXmlService = CosXmlService(context, serviceConfig, credentialProvider)
        val transferConfig = TransferConfig.Builder().build()
        transferManager = TransferManager(cosXmlService, transferConfig)
    }

    /**
     * 将 Content URI 或文件路径字符串转换为本地文件路径
     */
    private fun getPathFromUri(context: Context, uriStr: String): String? {
        val uri = Uri.parse(uriStr)
        return if ("content".equals(uri.scheme, ignoreCase = true)) {
            getDataColumn(context, uri, null, null)
        } else if ("file".equals(uri.scheme, ignoreCase = true)) {
            uri.path
        } else if (DocumentsContract.isDocumentUri(context, uri)) {
            when {
                isExternalStorageDocument(uri) -> {
                    val docId = DocumentsContract.getDocumentId(uri)
                    val split = docId.split(":").toTypedArray()
                    val type = split[0]

                    if ("primary".equals(type, ignoreCase = true)) {
                        "${Environment.getExternalStorageDirectory()}/${split[1]}"
                    } else {
                        null
                    }
                }
                isDownloadsDocument(uri) -> {
                    val id = DocumentsContract.getDocumentId(uri)
                    val contentUri = ContentUris.withAppendedId(
                        Uri.parse("content://downloads/public_downloads"), java.lang.Long.valueOf(id)
                    )
                    getDataColumn(context, contentUri, null, null)
                }
                isMediaDocument(uri) -> {
                    val docId = DocumentsContract.getDocumentId(uri)
                    val split = docId.split(":").toTypedArray()
                    val type = split[0]

                    val contentUri: Uri? = when (type) {
                        "image" -> MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                        "video" -> MediaStore.Video.Media.EXTERNAL_CONTENT_URI
                        "audio" -> MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
                        else -> null
                    }

                    val selection = "_id=?"
                    val selectionArgs = arrayOf(split[1])

                    getDataColumn(context, contentUri!!, selection, selectionArgs)
                }
                else -> null
            }
        } else {
            null
        }
    }

    private fun getDataColumn(context: Context, uri: Uri?, selection: String?, selectionArgs: Array<String>?): String? {
        uri ?: return null

        val projection = arrayOf(MediaStore.Images.Media.DATA)
        return try {
            context.contentResolver.query(uri, projection, selection, selectionArgs, null)?.use { cursor ->
                val columnIndex: Int = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
                if (cursor.moveToFirst()) {
                    cursor.getString(columnIndex)
                } else {
                    null
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    private fun isExternalStorageDocument(uri: Uri): Boolean {
        return "com.android.externalstorage.documents" == uri.authority
    }

    private fun isDownloadsDocument(uri: Uri): Boolean {
        return "com.android.providers.downloads.documents" == uri.authority
    }

    private fun isMediaDocument(uri: Uri): Boolean {
        return "com.android.providers.media.documents" == uri.authority
    }

    /**
     * 通过流的方式上传大文件到 COS，并提供进度和结果回调
     */
    private fun uploadLargeFile(
        context: Context,
        bucket: String,
        cosPath: String,
        inputStream: InputStream,
        fileSize: Long,
        onProgress: (Float) -> Unit,
        onSuccess: (String?) -> Unit,
        onFailure: (String?) -> Unit
    ) {
        val uploadTask = transferManager.upload(bucket, cosPath, inputStream)

        uploadTask.setCosXmlProgressListener(object : CosXmlProgressListener {
            override fun onProgress(bytesCurrent: Long, bytesTotal: Long) {
                val progress = (bytesCurrent.toFloat() / fileSize.toFloat()) * 100
                onProgress(progress)
            }
        })

        uploadTask.setCosXmlResultListener(object : com.tencent.cos.xml.listener.CosXmlResultListener {
            override fun onSuccess(request: CosXmlRequest?, result: CosXmlResult?) {
                onSuccess(result?.accessUrl)
            }

            override fun onFail(
                request: CosXmlRequest?,
                clientException: CosXmlClientException?,
                serviceException: CosXmlServiceException?
            ) {
                clientException?.let { ex ->
                    ex.printStackTrace()
                    onFailure(ex.message)
                } ?: run {
                    serviceException?.let { ex ->
                        ex.printStackTrace()
                        onFailure(ex.message)
                    }
                }
            }
        })
    }

    /**
     * 读取 Content URI 的内容为字节数组
     */
    private fun readBytesFromUri(context: Context, uri: Uri): ByteArray? {
        return try {
            val inputStream: InputStream? = context.contentResolver.openInputStream(uri)
            inputStream?.use { stream ->
                val outputStream = ByteArrayOutputStream()
                val buffer = ByteArray(4096)
                var bytesRead: Int
                while (stream.read(buffer).also { bytesRead = it } != -1) {
                    outputStream.write(buffer, 0, bytesRead)
                }
                outputStream.toByteArray()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    /**
     * 获取 Content URI 的文件大小
     */
    private fun getFileSizeFromUri(context: Context, uri: Uri): Long? {
        return try {
            context.contentResolver.query(uri, null, null, null, null)?.use { cursor ->
                val sizeIndex = cursor.getColumnIndex(MediaStore.Files.FileColumns.SIZE)
                if (sizeIndex >= 0 && cursor.moveToFirst()) {
                    cursor.getLong(sizeIndex)
                } else {
                    null
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    /**
     * 上传文件到 COS，并提供进度和结果回调
     */
    fun cosUploadFile(
        context: Context,
        bucket: String,
        cosPath: String,
        srcUriStr: String,
        onProgress: (Float) -> Unit,
        onSuccess: (String?) -> Unit,
        onFailure: (String?) -> Unit
    ) {
        val uri = Uri.parse(srcUriStr)
        if ("file".equals(uri.scheme, ignoreCase = true)) {
            val filePath = uri.path
            if (filePath != null) {
                val file = File(filePath)
                val fileSize = file.length()
                val inputStream = FileInputStream(file)

                uploadLargeFile(context, bucket, cosPath, inputStream, fileSize, onProgress, onSuccess, onFailure)
            } else {
                onFailure("Invalid file path")
            }
        } else if ("content".equals(uri.scheme, ignoreCase = true)) {
            val fileSize = getFileSizeFromUri(context, uri) ?: run {
                onFailure("Failed to determine file size from URI")
                return
            }
            val inputStream = context.contentResolver.openInputStream(uri) ?: run {
                onFailure("Failed to open input stream from URI")
                return
            }

            uploadLargeFile(context, bucket, cosPath, inputStream, fileSize, onProgress, onSuccess, onFailure)
        } else {
            onFailure("Unsupported URI scheme")
        }
    }
}