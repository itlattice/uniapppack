package uts.sdk.modules.iboxsScancode
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import java.io.File
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Executor

object CameraUtils {
    // 相机执行器
    private val cameraExecutor: ExecutorService = Executors.newSingleThreadExecutor()
    
    // 图像捕获用例
    private var imageCapture: ImageCapture? = null
    // 相机提供者
    private var cameraProvider: ProcessCameraProvider? = null

    /**
     * 直接拍摄照片（无需预览）
     * @param context 上下文
     * @param lifecycleOwner 生命周期所有者
     * @param onImageSaved 照片保存成功的回调
     * @param onError 错误回调
     * @param onCaptureStarted 拍照开始的回调（可选）
     */
    fun takePhotoInBackground(
        context: Context,
        lifecycleOwner: LifecycleOwner,
        onImageSaved: (Uri) -> Unit,
        onError: (Exception) -> Unit,
        onCaptureStarted: () -> Unit = {}
    ) {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(context)

        cameraProviderFuture.addListener({
            try {
                // 获取CameraProvider
                cameraProvider = cameraProviderFuture.get()
                
                // 配置图像捕获用例
                imageCapture = ImageCapture.Builder()
                    .build()

                // 选择前置摄像头
                val cameraSelector = CameraSelector.DEFAULT_FRONT_CAMERA

                // 解绑所有先前绑定的用例
                cameraProvider?.unbindAll()

                // 仅绑定图像捕获用例，无需预览
                cameraProvider?.bindToLifecycle(
                    lifecycleOwner,
                    cameraSelector,
                    imageCapture
                )

                // 绑定成功后立即拍照，并触发拍照开始回调
                onCaptureStarted.invoke()
                capturePhoto(context, onImageSaved, onError, onCaptureStarted)

            } catch (exc: Exception) {
                onError(exc)
                exc.printStackTrace()
            }

        }, ContextCompat.getMainExecutor(context))
    }

    /**
     * 执行拍照操作，使用反射创建回调以兼容不同版本
     */
    private fun capturePhoto(
        context: Context,
        onImageSaved: (Uri) -> Unit,
        onError: (Exception) -> Unit,
        onCaptureStarted: () -> Unit
    ) {
        // 获取ImageCapture实例
        val imageCapture = imageCapture ?: run {
            onError(Exception("相机未初始化"))
            releaseResources()
            return
        }

        // 创建保存照片的文件
        val photoFile = createImageFile(context)

        // 创建输出选项对象
        val outputOptions = ImageCapture.OutputFileOptions.Builder(photoFile).build()

        // 使用反射创建回调，避免版本冲突
        val callback = createOnImageSavedCallbackProxy(
            onImageSaved = { uri ->
                onImageSaved(uri)
                releaseResources()
            },
            onError = { e ->
                onError(e)
                releaseResources()
            },
            onCaptureStarted = onCaptureStarted
        )

        // 执行拍照
        try {
            val takePictureMethod = ImageCapture::class.java.getMethod(
                "takePicture",
                ImageCapture.OutputFileOptions::class.java,
                Executor::class.java,
                ImageCapture.OnImageSavedCallback::class.java
            )
            takePictureMethod.invoke(
                imageCapture,
                outputOptions,
                ContextCompat.getMainExecutor(context),
                callback
            )
        } catch (e: Exception) {
            onError(e)
            releaseResources()
        }
    }

    /**
     * 使用动态代理创建OnImageSavedCallback，兼容有无onCaptureStarted()方法的版本
     */
    private fun createOnImageSavedCallbackProxy(
        onImageSaved: (Uri) -> Unit,
        onError: (Exception) -> Unit,
        onCaptureStarted: () -> Unit
    ): ImageCapture.OnImageSavedCallback {
        val callbackInterface = ImageCapture.OnImageSavedCallback::class.java
        
        return Proxy.newProxyInstance(
            callbackInterface.classLoader,
            arrayOf(callbackInterface),
            object : InvocationHandler {
                override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any? {
                    return when (method?.name) {
                        "onImageSaved" -> {
                            val outputFileResults = args?.get(0) as ImageCapture.OutputFileResults
                            val photoFile = outputFileResults.savedUri ?: run {
                                // 尝试通过反射获取文件路径
                                val uriField = outputFileResults.javaClass.getDeclaredField("savedUri")
                                uriField.isAccessible = true
                                uriField.get(outputFileResults) as? Uri
                            }
                            photoFile?.let { onImageSaved(it) }
                            null
                        }
                        "onError" -> {
                            val exception = args?.get(0) as Exception
                            onError(exception)
                            null
                        }
                        "onCaptureStarted" -> {
                            // 处理存在此方法的版本
                            onCaptureStarted()
                            null
                        }
                        // 处理toString等其他方法
                        "toString" -> "ImageSavedCallbackProxy"
                        else -> null
                    }
                }
            }
        ) as ImageCapture.OnImageSavedCallback
    }

    /**
     * 创建保存照片的文件
     */
    private fun createImageFile(context: Context): File {
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        val storageDir: File? = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        
        return File.createTempFile(
            "JPEG_${timeStamp}_",
            ".jpg",
            storageDir
        )
    }

    /**
     * 将照片添加到媒体库
     */
    private fun galleryAddPic(context: Context, uri: Uri) {
        val mediaScanIntent = Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE)
        mediaScanIntent.data = uri
        context.sendBroadcast(mediaScanIntent)
    }

    /**
     * 释放相机资源
     */
    private fun releaseResources() {
        cameraProvider?.unbindAll()
        cameraProvider = null
        imageCapture = null
    }

    /**
     * 关闭相机执行器
     */
    fun shutdown() {
        cameraExecutor.shutdown()
    }
}
    