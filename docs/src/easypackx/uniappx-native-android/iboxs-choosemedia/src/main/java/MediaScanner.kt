package uts.sdk.modules.iboxsChooseMedia

import android.Manifest
import android.content.ContentUris
import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.util.Size
import org.json.JSONArray
import org.json.JSONObject
import java.io.File
import java.io.FileOutputStream
import java.util.*
import java.util.concurrent.ConcurrentHashMap
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import io.dcloud.uts.console

object MediaScanner {

    private const val TAG = "MediaScanner"
    private val cache = ConcurrentHashMap<String, JSONObject>()
    private const val THUMBNAIL_CACHE_DIR = "video_thumbnails"
    private const val THUMBNAIL_EXPIRY_TIME = 7 * 24 * 60 * 60 * 1000L // 7 days in milliseconds

    fun scanMedia(
        context: Context,
        mediaType: String,
        folderId: Long,
        page: Int,
        pageSize: Int,
        onMediaFound: (String) -> Unit,
        onError: (String) -> Unit,
        onComplete: () -> Unit
    ) {
        if (!checkPermissions(context)) {
            onError("Permission denied")
            return
        }
    
        val selectionArgs = mutableListOf<String>()
        var selection = ""
    
        when (mediaType) {
            "video" -> {
                selection = "${MediaStore.Files.FileColumns.MEDIA_TYPE}=?"
                selectionArgs.add(MediaStore.Files.FileColumns.MEDIA_TYPE_VIDEO.toString())
            }
            "image" -> {
                selection = "${MediaStore.Files.FileColumns.MEDIA_TYPE}=?"
                selectionArgs.add(MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE.toString())
            }
            "all" -> {
                selection = "${MediaStore.Files.FileColumns.MEDIA_TYPE}=? OR ${MediaStore.Files.FileColumns.MEDIA_TYPE}=?"
                selectionArgs.add(MediaStore.Files.FileColumns.MEDIA_TYPE_VIDEO.toString())
                selectionArgs.add(MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE.toString())
            }
            else -> {
                onError("Invalid media type["+mediaType+"]")
                return
            }
        }
    
        if (folderId != 0L) {
            selection += " AND ${MediaStore.Files.FileColumns.BUCKET_ID}=?"
            selectionArgs.add(folderId.toString())
        }
    
        // Define projection
        val projection = arrayOf(
            MediaStore.Files.FileColumns._ID,
            MediaStore.Files.FileColumns.SIZE,
            MediaStore.Files.FileColumns.DISPLAY_NAME,
            MediaStore.Files.FileColumns.MIME_TYPE,
            MediaStore.Files.FileColumns.PARENT,
            MediaStore.Files.FileColumns.BUCKET_DISPLAY_NAME,
            MediaStore.Files.FileColumns.BUCKET_ID,
            MediaStore.Video.VideoColumns.DURATION // Only for video
        )
    
        val sortOrder = "${MediaStore.Files.FileColumns.DATE_ADDED} DESC"
    
        val cursor = try {
            context.contentResolver.query(
                MediaStore.Files.getContentUri("external"),
                projection,
                selection,
                selectionArgs.toTypedArray(),
                sortOrder
            )
        } catch (e: Exception) {
            onError(e.message ?: "Unknown error")
            null
        }
    
        if (cursor == null || cursor.count == 0) {
            onError("No media files found or cursor count is zero")
            cursor?.close()
            onComplete()
            return
        }
    
        // Calculate the range for pagination
        val start = (page - 1) * pageSize
        val end = start + pageSize
    
        val mediaList = mutableListOf<JSONObject>()
        try {
            var count = 0
            while (cursor.moveToNext()) {
                if (count < start) {
                    count++
                    continue // Skip items before the current page
                }
                if (count >= end) {
                    break // Stop after reaching the end of the current page
                }
    
                val id = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Files.FileColumns._ID))
                val fileSize = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Files.FileColumns.SIZE))
                val fileName = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Files.FileColumns.DISPLAY_NAME))
                val mimeType = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Files.FileColumns.MIME_TYPE))
                val fileType = if (mimeType.startsWith("video")) "video" else "image"
                val duration = if (fileType == "video") {
                    cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Video.VideoColumns.DURATION)) / 1000
                } else {
                    0
                }
                val actualFolderId = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Files.FileColumns.BUCKET_ID))
                val folderName = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Files.FileColumns.BUCKET_DISPLAY_NAME))
    
                // 获取文件扩展名
                val ext = fileName.substringAfterLast('.', "")
    
                // Build file URI
                val contentUri = ContentUris.withAppendedId(
                    MediaStore.Files.getContentUri("external"),
                    id
                )
    
                val uri = if (fileType == "video") {
                    getVideoThumbnailUri(context, contentUri)
                } else {
                    contentUri.toString()
                }
    
                // 检查文件大小是否为 0
                if (fileSize > 0) {
                    val jsonObject = JSONObject().apply {
                        put("path", folderName)
                        put("file", contentUri.toString())
                        put("size", fileSize)
                        put("duration", duration)
                        put("type", fileType)
                        put("fileId", id)
                        put("folderId", actualFolderId)
                        put("uri", uri)
                        put("ext", ext)
                    }
    
                    cache["$contentUri-$id"] = jsonObject
                    mediaList.add(jsonObject)
    
                    if (mediaList.size == 5) {
                        val jsonArray = JSONArray(mediaList)
                        onMediaFound(jsonArray.toString())
                        mediaList.clear()
                    }
                }
    
                count++
            }
    
            // 处理剩余的文件
            if (mediaList.isNotEmpty()) {
                val jsonArray = JSONArray(mediaList)
                onMediaFound(jsonArray.toString())
            }
        } finally {
            cursor.close()
        }
    
        clearExpiredThumbnails(context)
        onComplete()
    }

    /**
     * 获取指定条件下的媒体文件总数
     * @param context 上下文
     * @param mediaType 媒体类型，如 "video", "image", "all"
     * @param folderId 文件夹ID，为 0 时获取所有文件夹
     * @return 媒体文件总数
     */
    fun getTotalMediaCount(context: Context, mediaType: String, folderId: Long): Int {
        if (!checkPermissions(context)) {
            console.log("'无权限'");
            return 0
        }

        val selectionArgs = mutableListOf<String>()
        var selection = ""

        when (mediaType) {
            "video" -> {
                selection = "${MediaStore.Files.FileColumns.MEDIA_TYPE}=?"
                selectionArgs.add(MediaStore.Files.FileColumns.MEDIA_TYPE_VIDEO.toString())
            }
            "image" -> {
                selection = "${MediaStore.Files.FileColumns.MEDIA_TYPE}=?"
                selectionArgs.add(MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE.toString())
            }
            "all" -> {
                selection = "${MediaStore.Files.FileColumns.MEDIA_TYPE}=? OR ${MediaStore.Files.FileColumns.MEDIA_TYPE}=?"
                selectionArgs.add(MediaStore.Files.FileColumns.MEDIA_TYPE_VIDEO.toString())
                selectionArgs.add(MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE.toString())
            }
            else -> {
                console.log("'leix'");
                return 0
            }
        }

        if (folderId != 0L) {
            selection += " AND ${MediaStore.Files.FileColumns.BUCKET_ID}=?"
            selectionArgs.add(folderId.toString())
        }

        val projection = arrayOf(
            MediaStore.Files.FileColumns._ID
        )

        val cursor = try {
            context.contentResolver.query(
                MediaStore.Files.getContentUri("external"),
                projection,
                selection,
                selectionArgs.toTypedArray(),
                null
            )
        } catch (e: Exception) {
            console.log("Query error: ${e.message}")
            null
        }

        val count = cursor?.count ?: 0
        cursor?.close()
        return count
    }

    private fun checkPermissions(context: Context): Boolean {
        val readExternalStoragePermission = Manifest.permission.READ_MEDIA_IMAGES
        val images = ContextCompat.checkSelfPermission(context, readExternalStoragePermission) == PackageManager.PERMISSION_GRANTED
		val readVideo=Manifest.permission.READ_MEDIA_VIDEO
		val video=ContextCompat.checkSelfPermission(context, readVideo) == PackageManager.PERMISSION_GRANTED
		return images && video
    }

    private fun getVideoThumbnailUri(context: Context, videoUri: Uri): String {
        val cacheDir = File(context.cacheDir, THUMBNAIL_CACHE_DIR)
        if (!cacheDir.exists()) {
            cacheDir.mkdirs()
        }
        val thumbnailFile = File(cacheDir, "${videoUri.lastPathSegment}.jpg")
        if (thumbnailFile.exists() && isThumbnailValid(thumbnailFile)) {
            return Uri.fromFile(thumbnailFile).toString()
        }
        val thumbnail = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            context.contentResolver.loadThumbnail(videoUri, Size(200, 200), null)
        } else {
            MediaStore.Video.Thumbnails.getThumbnail(
                context.contentResolver,
                ContentUris.parseId(videoUri),
                MediaStore.Video.Thumbnails.MINI_KIND,
                null
            )
        }
        if (thumbnail != null) {
            try {
                val fos = FileOutputStream(thumbnailFile)
                thumbnail.compress(Bitmap.CompressFormat.JPEG, 100, fos)
                fos.close()
                thumbnail.recycle()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return if (thumbnailFile.exists()) {
            Uri.fromFile(thumbnailFile).toString()
        } else {
            videoUri.toString()
        }
    }

    private fun isThumbnailValid(file: File): Boolean {
        return System.currentTimeMillis() - file.lastModified() < THUMBNAIL_EXPIRY_TIME
    }

    private fun clearExpiredThumbnails(context: Context) {
        val cacheDir = File(context.cacheDir, THUMBNAIL_CACHE_DIR)
        if (cacheDir.exists() && cacheDir.isDirectory) {
            val files = cacheDir.listFiles()
            if (files != null) {
                for (file in files) {
                    if (!isThumbnailValid(file)) {
                        file.delete()
                    }
                }
            }
        }
    }
}