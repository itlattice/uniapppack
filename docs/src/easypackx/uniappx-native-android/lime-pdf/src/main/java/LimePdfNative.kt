package uts.sdk.modules.limePdf

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.pdf.PdfRenderer
import android.os.Handler
import android.os.Looper
import android.os.ParcelFileDescriptor
import android.util.Base64
import io.dcloud.uts.UTSAndroid
import io.dcloud.uts.UTSArray
import io.dcloud.uts.UTSJSONObject
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.net.HttpURLConnection
import java.net.URL

object LimePdfNative {

    // 下载缓存
    private val downloadCache = mutableMapOf<String, String>()

    /**
     * 解析路径：如果是网络地址则下载到本地，否则直接返回（本地路径已由 UTS 层解析）
     */
    private fun resolvePath(path: String, callback: (String?) -> Unit) {
        // 网络地址：下载
        if (path.startsWith("http") || path.startsWith("ftp")) {
            // 检查缓存
            downloadCache[path]?.let { cachedPath ->
                if (File(cachedPath).exists()) {
                    callback(cachedPath)
                    return
                }
                downloadCache.remove(path)
            }
            Thread {
                try {
                    val url = URL(path)
                    val conn = url.openConnection() as HttpURLConnection
                    conn.connectTimeout = 30000
                    conn.readTimeout = 30000
                    conn.requestMethod = "GET"
                    conn.doInput = true
                    conn.connect()

                    val cacheDir = File(UTSAndroid.getAppCachePath(), "lime-pdf-download")
                    if (!cacheDir.exists()) cacheDir.mkdirs()
                    val fileName = "dl_${System.currentTimeMillis()}.pdf"
                    val tempFile = File(cacheDir, fileName)

                    conn.inputStream.use { input ->
                        FileOutputStream(tempFile).use { output ->
                            val buffer = ByteArray(8192)
                            var len: Int
                            while (input.read(buffer).also { len = it } != -1) {
                                output.write(buffer, 0, len)
                            }
                            output.flush()
                        }
                    }

                    val localPath = tempFile.absolutePath
                    downloadCache[path] = localPath
                    Handler(Looper.getMainLooper()).post {
                        callback(localPath)
                    }
                } catch (e: Exception) {
                    Handler(Looper.getMainLooper()).post {
                        callback(null)
                    }
                }
            }.start()
            return
        }

        // 本地路径：UTS 层已解析为绝对路径，直接使用
        callback(path)
    }

    /**
     * 获取 PDF 页数（支持网络路径）
     */
    fun getPageCount(path: String, callback: (Boolean, Int, String) -> Unit) {
        resolvePath(path) { localPath ->
            if (localPath == null) {
                callback(false, 9020002, "文件不存在或下载失败")
                return@resolvePath
            }
            try {
                val file = File(localPath)
                if (!file.exists()) {
                    callback(false, 9020002, "文件不存在")
                    return@resolvePath
                }
                val fd = ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_ONLY)
                val renderer = PdfRenderer(fd)
                val pageCount = renderer.pageCount
                renderer.close()
                fd.close()
                callback(true, pageCount, "")
            } catch (e: Exception) {
                callback(false, 9020003, e.message ?: "读取PDF失败")
            }
        }
    }

    /**
     * 渲染 PDF 单页为图片（支持网络路径）
     * callback: (success, pathOrBase64, width, height, page, pageCount, errCode, errMsg)
     */
    fun renderPage(
        path: String,
        page: Int,
        dpi: Int,
        format: String,
        quality: Int,
        asBase64: Boolean,
        callback: (Boolean, String, Int, Int, Int, Int, Int, String) -> Unit
    ) {
        resolvePath(path) { localPath ->
            if (localPath == null) {
                callback(false, "", 0, 0, 0, 0, 9020002, "文件不存在或下载失败")
                return@resolvePath
            }
            Thread {
                try {
                    val file = File(localPath)
                    if (!file.exists()) {
                        Handler(Looper.getMainLooper()).post {
                            callback(false, "", 0, 0, 0, 0, 9020002, "文件不存在")
                        }
                        return@Thread
                    }

                    val fd = ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_ONLY)
                    val renderer = PdfRenderer(fd)
                    val totalPages = renderer.pageCount

                    if (page < 0 || page >= totalPages) {
                        renderer.close()
                        fd.close()
                        Handler(Looper.getMainLooper()).post {
                            callback(false, "", 0, 0, 0, 0, 9020004, "页码超出范围，共${totalPages}页")
                        }
                        return@Thread
                    }

                    val pdfPage = renderer.openPage(page)
                    val scale = dpi.toFloat() / 72f
                    val width = (pdfPage.width * scale).toInt()
                    val height = (pdfPage.height * scale).toInt()

                    val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
                    bitmap.eraseColor(Color.WHITE)
                    pdfPage.render(bitmap, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY)

                    pdfPage.close()
                    renderer.close()
                    fd.close()

                    val cacheDir = File(UTSAndroid.getAppCachePath(), "lime-pdf")
                    if (!cacheDir.exists()) cacheDir.mkdirs()

                    val ext = if (format == "jpg") "jpg" else "png"
                    val compressFormat = if (format == "jpg") Bitmap.CompressFormat.JPEG else Bitmap.CompressFormat.PNG
                    val outputFile = File(cacheDir, "page_${page}_${System.currentTimeMillis()}.$ext")

                    FileOutputStream(outputFile).use { fos ->
                        bitmap.compress(compressFormat, quality, fos)
                        fos.flush()
                    }

                    val imagePath = outputFile.absolutePath

                    val base64Data = if (asBase64) {
                        val baos = ByteArrayOutputStream()
                        bitmap.compress(compressFormat, quality, baos)
                        val base64Str = Base64.encodeToString(baos.toByteArray(), Base64.NO_WRAP)
                        val mimeType = if (format == "jpg") "image/jpeg" else "image/png"
                        "data:$mimeType;base64,$base64Str"
                    } else {
                        ""
                    }

                    bitmap.recycle()

                    val finalPath = imagePath
                    val finalBase64 = base64Data
                    val finalWidth = width
                    val finalHeight = height

                    Handler(Looper.getMainLooper()).post {
                        callback(true, finalPath, finalWidth, finalHeight, page, totalPages, if (asBase64) 1 else 0, finalBase64)
                    }
                } catch (e: Exception) {
                    Handler(Looper.getMainLooper()).post {
                        callback(false, "", 0, 0, 0, 0, 9020003, e.message ?: "渲染失败")
                    }
                }
            }.start()
        }
    }

    /**
     * 渲染 PDF 多页为图片（支持网络路径）
     * callback: (success, results, pageCount, errCode, errMsg)
     */
    fun renderPages(
        path: String,
        pages: IntArray?,
        dpi: Int,
        format: String,
        quality: Int,
        asBase64: Boolean,
        callback: (Boolean, UTSArray<UTSJSONObject>, Int, Int, String) -> Unit
    ) {
        resolvePath(path) { localPath ->
            if (localPath == null) {
                callback(false, UTSArray(), 0, 9020002, "文件不存在或下载失败")
                return@resolvePath
            }
            Thread {
                try {
                    val file = File(localPath)
                    if (!file.exists()) {
                        Handler(Looper.getMainLooper()).post {
                            callback(false, UTSArray(), 0, 9020002, "文件不存在")
                        }
                        return@Thread
                    }

                    val fd = ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_ONLY)
                    val renderer = PdfRenderer(fd)
                    val totalPages = renderer.pageCount

                    val pageIndices: List<Int> = if (pages != null && pages.isNotEmpty()) {
                        pages.toList()
                    } else {
                        (0 until totalPages).toList()
                    }

                    val cacheDir = File(UTSAndroid.getAppCachePath(), "lime-pdf")
                    if (!cacheDir.exists()) cacheDir.mkdirs()

                    val ext = if (format == "jpg") "jpg" else "png"
                    val compressFormat = if (format == "jpg") Bitmap.CompressFormat.JPEG else Bitmap.CompressFormat.PNG

                    val results = UTSArray<UTSJSONObject>()

                    for (pageIndex in pageIndices) {
                        if (pageIndex < 0 || pageIndex >= totalPages) continue

                        val pdfPage = renderer.openPage(pageIndex)
                        val scale = dpi.toFloat() / 72f
                        val width = (pdfPage.width * scale).toInt()
                        val height = (pdfPage.height * scale).toInt()

                        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
                        bitmap.eraseColor(Color.WHITE)
                        pdfPage.render(bitmap, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY)
                        pdfPage.close()

                        val outputFile = File(cacheDir, "page_${pageIndex}_${System.currentTimeMillis()}.$ext")
                        FileOutputStream(outputFile).use { fos ->
                            bitmap.compress(compressFormat, quality, fos)
                            fos.flush()
                        }

                        val item = UTSJSONObject()
                        item["path"] = outputFile.absolutePath
                        item["width"] = width
                        item["height"] = height
                        item["page"] = pageIndex

                        if (asBase64) {
                            val baos = ByteArrayOutputStream()
                            bitmap.compress(compressFormat, quality, baos)
                            val base64Str = Base64.encodeToString(baos.toByteArray(), Base64.NO_WRAP)
                            val mimeType = if (format == "jpg") "image/jpeg" else "image/png"
                            item["base64"] = "data:$mimeType;base64,$base64Str"
                            baos.close()
                        }

                        results.add(item)
                        bitmap.recycle()
                    }

                    renderer.close()
                    fd.close()

                    val total = totalPages

                    Handler(Looper.getMainLooper()).post {
                        callback(true, results, total, 0, "")
                    }
                } catch (e: Exception) {
                    Handler(Looper.getMainLooper()).post {
                        callback(false, UTSArray(), 0, 9020003, e.message ?: "渲染失败")
                    }
                }
            }.start()
        }
    }
}
