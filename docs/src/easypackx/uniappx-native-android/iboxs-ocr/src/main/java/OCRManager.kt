package uts.sdk.modules.iboxsOcr

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Log
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.label.ImageLabeling
import com.google.mlkit.vision.label.defaults.ImageLabelerOptions
import com.google.mlkit.vision.text.chinese.ChineseTextRecognizerOptions
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.TextRecognizer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File

/**
 * OCR 文字识别管理器 (单例)
 * 基于 Google ML Kit 中文识别，模型打包在 App 内
 */
object OCRManager {
	private const val TAG = "OCRManager"
	private var scope = CoroutineScope(SupervisorJob() + Dispatchers.Main)
	private var appContext: Context? = null
	private var textRecognizer: TextRecognizer? = null
	private var imageLabeler = ImageLabeling.getClient(ImageLabelerOptions.DEFAULT_OPTIONS)

	/**
	 * OCR 文本块结果。
	 *
	 * @param text 当前文本块识别出的文字
	 * @param left 文本块左边界
	 * @param top 文本块上边界
	 * @param right 文本块右边界
	 * @param bottom 文本块下边界
	 */
	data class OCRTextBlock(
		val text: String,
		val left: Int,
		val top: Int,
		val right: Int,
		val bottom: Int
	)

	/**
	 * 图像标签结果。
	 *
	 * @param text 标签文本
	 * @param confidence 置信度，范围 0 到 1
	 * @param index 标签索引
	 */
	data class ImageLabelResult(
		val text: String,
		val confidence: Float,
		val index: Int
	)

	/**
	 * OCR 综合结果。
	 *
	 * @param text 整张图片识别后的完整文本
	 * @param blocks 按文本块拆分的识别结果
	 * @param labels 图片标签识别结果，未启用时为空
	 */
	data class OCRResult(
		val text: String,
		val blocks: List<OCRTextBlock>,
		val labels: List<ImageLabelResult>
	)

	/**
	 * OCR 识别回调。
	 */
	interface OCRCallback {
		fun onSuccess(result: OCRResult) {}
		fun onError(message: String) {}
	}

	/**
	 * 初始化 OCR 组件。
	 *
	 * ML Kit 客户端默认按需初始化，这里提供一个显式入口用于预热实例。
	 */
	fun init(context: Context? = null) {
		if (context != null) {
			appContext = context.applicationContext
		}
		ensureScope()
		ensureTextRecognizer()
	}

	/**
	 * 识别本地图片中的文字。
	 *
	 * @param imagePath 本地图片完整路径
	 * @param includeImageLabels 是否同时进行图像标签识别
	 * @param callback 本次识别任务回调
	 */
	fun recognizeImage(
		imagePath: String,
		includeImageLabels: Boolean = false,
		callback: OCRCallback
	) {
		if (imagePath.isBlank()) {
			callback.onError("imagePath 不能为空")
			return
		}

		ensureScope().launch {
			val bitmap = withContext(Dispatchers.IO) {
				decodeBitmap(imagePath)
			}

			if (bitmap == null) {
				callback.onError("图片加载失败或文件不存在")
				return@launch
			}

			recognizeBitmap(bitmap, includeImageLabels, callback)
		}
	}

	/**
	 * 识别 Bitmap 中的文字。
	 *
	 * @param bitmap 已加载好的图片对象
	 * @param includeImageLabels 是否同时进行图像标签识别
	 * @param callback 本次识别任务回调
	 */
	fun recognizeBitmap(
		bitmap: Bitmap,
		includeImageLabels: Boolean = false,
		callback: OCRCallback
	) {
		val recognizer = ensureTextRecognizer()
		val inputImage = InputImage.fromBitmap(bitmap, 0)

		recognizer.process(inputImage)
			.addOnSuccessListener { visionText ->
				val textBlocks = visionText.textBlocks.mapNotNull { block ->
					block.boundingBox?.let { rect ->
						OCRTextBlock(
							text = block.text,
							left = rect.left,
							top = rect.top,
							right = rect.right,
							bottom = rect.bottom
						)
					}
				}

				if (!includeImageLabels) {
					callback.onSuccess(
						OCRResult(
							text = visionText.text,
							blocks = textBlocks,
							labels = emptyList()
						)
					)
					return@addOnSuccessListener
				}

				labelImage(inputImage) { labels ->
					callback.onSuccess(
						OCRResult(
							text = visionText.text,
							blocks = textBlocks,
							labels = labels
						)
					)
				}
			}
			.addOnFailureListener { error ->
				Log.e(TAG, "OCR 识别失败", error)
				callback.onError(error.message ?: "OCR 识别失败")
			}
	}

	/**
	 * 仅执行图像标签识别。
	 *
	 * @param imagePath 本地图片完整路径
	 * @param callback 返回标签结果或错误信息
	 */
	fun labelImage(imagePath: String, callback: OCRCallback) {
		if (imagePath.isBlank()) {
			callback.onError("imagePath 不能为空")
			return
		}

		ensureScope().launch {
			val bitmap = withContext(Dispatchers.IO) {
				decodeBitmap(imagePath)
			}

			if (bitmap == null) {
				callback.onError("图片加载失败或文件不存在")
				return@launch
			}

			val inputImage = InputImage.fromBitmap(bitmap, 0)
			labelImage(inputImage) { labels ->
				callback.onSuccess(
					OCRResult(
						text = "",
						blocks = emptyList(),
						labels = labels
					)
				)
			}
		}
	}

	/**
	 * 将图片路径转换为 Bitmap。
	 *
	 * @param imagePath 本地文件路径或 content Uri
	 * @return 成功时返回 Bitmap，失败时返回 null
	 */
	fun pathToBitmap(imagePath: String): Bitmap? {
		if (imagePath.isBlank()) {
			return null
		}

		return decodeBitmap(imagePath)
	}

	/**
	 * 释放 OCR 与图像标签识别相关资源。
	 */
	fun release() {
		textRecognizer?.close()
		imageLabeler.close()
		textRecognizer = null
		imageLabeler = ImageLabeling.getClient(ImageLabelerOptions.DEFAULT_OPTIONS)
		scope.cancel()
		scope = CoroutineScope(SupervisorJob() + Dispatchers.Main)
	}

	private fun ensureScope(): CoroutineScope {
		return scope
	}

	private fun ensureTextRecognizer(): TextRecognizer {
		val recognizer = textRecognizer
		if (recognizer != null) {
			return recognizer
		}

		return TextRecognition.getClient(ChineseTextRecognizerOptions.Builder().build()).also {
			textRecognizer = it
		}
	}

	private fun decodeBitmap(imagePath: String): Bitmap? {
		if (imagePath.startsWith("content://")) {
			return decodeBitmapFromContentUri(imagePath)
		}

		val imageFile = File(imagePath)
		if (!imageFile.exists() || !imageFile.isFile) {
			return null
		}

		return BitmapFactory.decodeFile(imageFile.absolutePath)
	}

	private fun decodeBitmapFromContentUri(imagePath: String): Bitmap? {
		val context = appContext ?: return null
		val uri = runCatching {
			Uri.parse(imagePath)
		}.getOrNull() ?: return null

		return runCatching {
			context.contentResolver.openInputStream(uri)?.use { inputStream ->
				BitmapFactory.decodeStream(inputStream)
			}
		}.getOrElse { error ->
			Log.e(TAG, "内容 Uri 图片加载失败", error)
			null
		}
	}

	private fun labelImage(inputImage: InputImage, onSuccess: (List<ImageLabelResult>) -> Unit) {
		imageLabeler.process(inputImage)
			.addOnSuccessListener { labels ->
				onSuccess(
					labels.map { label ->
						ImageLabelResult(
							text = label.text,
							confidence = label.confidence,
							index = label.index
						)
					}
				)
			}
			.addOnFailureListener { error ->
				Log.e(TAG, "图像标签识别失败", error)
				onSuccess(emptyList())
			}
	}
}