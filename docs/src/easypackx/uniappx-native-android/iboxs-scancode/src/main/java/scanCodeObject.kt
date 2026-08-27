package uts.sdk.modules.iboxsScancode

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Rect
import android.net.Uri
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.camera.core.ImageProxy
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.common.InputImage
import java.io.IOException
import com.itgz8.scancode.ResponseStateConfig
import com.itgz8.scancode.QRCodeData
import com.itgz8.scancode.CodeInfo
import com.itgz8.scancode.ResponseStateCode
import io.dcloud.uts.console
import android.content.ContentResolver
import android.os.Build
import androidx.core.content.contentValuesOf
import java.io.File
import android.content.ContentValues

object scanCodeObject{
	fun startScanCode(context: Context, uri: Uri?, callback:(ResponseStateConfig?)->Unit){
		try {
			// 将选中的图片转换为Bitmap
			val bitmap = MediaStore.Images.Media.getBitmap(context.contentResolver, uri)
			// 解析图片中的二维码
			scanBarcodes(uri,bitmap,context,callback)
		} catch (e: IOException) {
			e.printStackTrace()
		}
	}

	private fun scanBarcodes(uri: Uri?,bitmap: Bitmap?,context: Context, callback:(ResponseStateConfig?)->Unit) {
		if(bitmap==null){
			callback(null);
			return;
		}
		val image = InputImage.fromBitmap(bitmap, 0)
		val scanner = BarcodeScanning.getClient()
		val barcodesList = ArrayList<Barcode>()
		val analyzerList: ArrayList<QRCodeData> = ArrayList()
		// 初始化扫描结果矩形
		val list = ArrayList<Rect>()
		var responseData = Any()
		scanner.process(image)
			.addOnSuccessListener { barcodes ->
				if (barcodes.isNotEmpty()) {
					console.log(barcodes)
					// 将扫描结果添加到集合中
					barcodesList.addAll(barcodes)
					// 遍历所有扫描到的二维码
					for (barcode in barcodes) {
						// 获取扫描结果值
						var rawValue = barcode.rawValue
						CodeInfo.rawValue=rawValue
						CodeInfo.bitmap=uri.toString()
						CodeInfo.proxy=null
						CodeInfo.barcode=barcode
						// 根据扫描结果类型，进行相应的操作
						when (barcode.valueType) {
							// 扫描结果为 URL
							Barcode.TYPE_URL -> {
								// 打印扫码结果
//                                    Log.d(TAG, "扫码结果：$rawValue")
								// 构建二维码数据
								val qrCodeData = QRCodeData.Url(rawValue,CodeInfo)
								analyzerList.add(qrCodeData)
							}
							// 扫描结果为 WIFI 信息
							Barcode.TYPE_WIFI -> {
								// 打印扫码结果
//                                    Log.d(TAG, "扫码结果：$rawValue")
								// 获取 WIFI 名称
								val ssid = barcode.wifi?.ssid
								// 获取 WIFI 密码
								val password = barcode.wifi?.password
								// 获取 WIFI 加密类型
								val type = barcode.wifi?.encryptionType
								// 构建二维码数据
								val qrCodeData = QRCodeData.Wifi(ssid, password, type.toString(),CodeInfo)
								analyzerList.add(qrCodeData)
							}
							// 扫描结果为联系人信息
							Barcode.TYPE_CONTACT_INFO -> {
								// 打印扫码结果
//                                    Log.d(TAG, "扫码结果：$rawValue")
								// 获取联系人姓名
								val name = barcode.contactInfo?.name
								// 获取联系人地址
								val address = barcode.contactInfo?.addresses?.get(0)?.addressLines?.get(0)
								// 获取联系人邮箱
								val email = barcode.contactInfo?.emails?.get(0)?.address
								// 获取联系人电话
								val tel = barcode.contactInfo?.phones?.get(0)?.number
								// 构建二维码数据
								val qrCodeData = QRCodeData.Contact(name, address, tel, email,CodeInfo)
								analyzerList.add(qrCodeData)
							}
							// 扫描结果为短信
							Barcode.TYPE_SMS -> {
								// 打印
//                                    Log.d(TAG, "扫码结果：$rawValue")
								// 获取短信号码
								val number = barcode.sms?.phoneNumber
								// 获取短信内容
								val content = barcode.sms?.message
								// 构建二维码数据
								val qrCodeData = QRCodeData.Sms(number, content,CodeInfo)
								analyzerList.add(qrCodeData)
							}
							// 扫描结果为电话号码
							Barcode.TYPE_PHONE -> {
								// 打印扫码结果
//                                    Log.d(TAG, "扫码结果：$rawValue")
								// 获取电话号码
								val number = barcode.phone?.number
								// 构建二维码数据
								val qrCodeData = QRCodeData.Phone(number,CodeInfo)
								analyzerList.add(qrCodeData)
							}
							// 扫描结果为电子邮件
							Barcode.TYPE_EMAIL -> {
								// 打印扫码结果
//                                    Log.d(TAG, "扫码结果：$rawValue")
								// 获取邮件地址
								val address = barcode.email?.address
								// 获取邮件主题
								val subject = barcode.email?.subject
								// 获取邮件内容
								val body = barcode.email?.body
								// 构建二维码数据
								val qrCodeData = QRCodeData.Email(address, subject, body,CodeInfo)
								analyzerList.add(qrCodeData)
							}
							// 扫描结果为日历事件
							Barcode.TYPE_CALENDAR_EVENT -> {
								// 打印扫码结果
//                                    Log.d(TAG, "扫码结果：$rawValue")
								// 获取事件名称
								val name = barcode.calendarEvent?.summary
								// 获取事件开始时间
								val start = barcode.calendarEvent?.start
								// 获取事件结束时间
								val end = barcode.calendarEvent?.end
								// 获取事件地点
								val location = barcode.calendarEvent?.location
								// 获取事件描述
								val description = barcode.calendarEvent?.description
								// 构建二维码数据
								val qrCodeData = QRCodeData.Calendar(name, location, description, start, end,CodeInfo)
								analyzerList.add(qrCodeData)
							}
							// 扫描结果为地理位置
							Barcode.TYPE_GEO -> {
								// 打印扫码结果
//                                    Log.d(TAG, "扫码结果：$rawValue")
								// 获取纬度
								val latitude = barcode.geoPoint?.lat
								// 获取经度
								val longitude = barcode.geoPoint?.lng
								// 构建二维码数据
								val qrCodeData = QRCodeData.Geo(latitude, longitude,CodeInfo)
								analyzerList.add(qrCodeData)
							}
							// 扫描结果为文本
							Barcode.TYPE_TEXT -> {
								// 打印扫码结果
//                                    Log.d(TAG, "扫码结果：$rawValue")
								// 构建二维码数据
								val qrCodeData = QRCodeData.Text(rawValue!!,CodeInfo)
								analyzerList.add(qrCodeData)
							}
							// 扫描结果为驾驶证信息
							Barcode.TYPE_DRIVER_LICENSE -> {
								// 打印扫码结果
//                                    Log.d(TAG, "扫码结果：$rawValue")
								// 获取驾驶证姓
								val firstName = barcode.driverLicense?.firstName
								// 获取驾驶证名
								val lastName = barcode.driverLicense?.lastName
								// 获取驾驶证中间名
								val middleName = barcode.driverLicense?.middleName
								// 获取驾驶证地址州
								val addressState = barcode.driverLicense?.addressState
								// 获取驾驶证地址城市
								val addressCity = barcode.driverLicense?.addressCity
								// 获取驾驶证地址街道
								val addressStreet = barcode.driverLicense?.addressStreet
								// 获取驾驶证地址邮编
								val addressZip = barcode.driverLicense?.addressZip
								// 获取驾驶证性别
								val gender = barcode.driverLicense?.gender
								// 获取驾驶证号码
								val licenseNumber = barcode.driverLicense?.licenseNumber
								// 获取驾驶证发行国家
								val issuingCountry = barcode.driverLicense?.issuingCountry
								// 获取驾驶证出生日期
								val birthDate = barcode.driverLicense?.birthDate
								// 获取驾驶证发行日期
								val issueDate = barcode.driverLicense?.issueDate
								// 获取驾驶证到期日期
								val expiryDate = barcode.driverLicense?.expiryDate
								// 获取驾驶证文件类型
								val documentType = barcode.driverLicense?.documentType
								// 构建二维码数据
								val qrCodeData = QRCodeData.DriverLicense(
									firstName,
									lastName,
									middleName,
									addressState,
									addressCity,
									addressStreet,
									addressZip,
									birthDate,
									documentType,
									expiryDate,
									gender,
									issueDate,
									licenseNumber,
									issuingCountry,
									CodeInfo
								)
								analyzerList.add(qrCodeData)
							}
							// 扫描结果为未知类型
							Barcode.TYPE_UNKNOWN -> {
								// 打印扫码结果
//                                    Log.d(TAG, "扫码结果：$rawValue")
								// 构建二维码数据
								val qrCodeData = QRCodeData.Text(rawValue!!,CodeInfo)
								analyzerList.add(qrCodeData)
							}
							// 否则为默认的文本类型数据构建
							else -> {
								val qrCodeData = QRCodeData.Text(rawValue!!,CodeInfo)
								analyzerList.add(qrCodeData)
							}
						}
						// 获取扫描结果类型
						barcode.boundingBox?.let {//扫描二维码的外边框矩形
							// 相册选取图片的预览界面不需要转换坐标
//                            val rect = translateRect(it)
							list.add(it)
//                                Log.i(
//                                    TAG,
//                                    "scanBarcodes: left:${it.left} right:${it.right} top:${it.top} bottom:${it.bottom}"
//                                )
						}
					}
					// 关闭解析器
					scanner.close()
					// 初始化回调结果
					ResponseStateConfig.statusCode = ResponseStateCode.SUCCESS
					ResponseStateConfig.message = "扫码成功"
					responseData = analyzerList
					ResponseStateConfig.data = responseData
					callback(ResponseStateConfig)
				}
			}
			.addOnFailureListener {
				// 设置失败回调
				// 初始化回调结果
				ResponseStateConfig.statusCode = ResponseStateCode.FAILURE
				ResponseStateConfig.message = "扫码失败"
				responseData = it
				ResponseStateConfig.data = responseData
				callback(ResponseStateConfig)
			}
			.addOnCompleteListener {
				// 初始化回调结果
				ResponseStateConfig.statusCode = ResponseStateCode.SUCCESS
				ResponseStateConfig.message = "扫码完成"
				ResponseStateConfig.data = responseData
			}
	}
	
	/**
	 * 根据 URI 删除文件，支持 content:// 和 file:// 类型的 URI
	 * @param context 应用上下文
	 * @param fileUri 文件 URI
	 * @return 删除成功返回 true，失败返回 false
	 */
	fun deleteFileByUri(context: Context, fileUri: Uri): Boolean {
	    return try {
	        when {
	            // 处理 content:// URI
	            fileUri.scheme == "content" -> {
	                val contentResolver = context.contentResolver
	
	                // 检查权限
	                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
	                    // 对于 Android 11+，使用 MediaStore API 删除
	                    val contentValues = ContentValues().apply {
	                        put(MediaStore.MediaColumns.IS_PENDING, 1)
	                    }
	
	                    // 更新文件状态为待处理
	                    contentResolver.update(fileUri, contentValues, null, null)
	
	                    // 删除文件
	                    val rowsDeleted = contentResolver.delete(fileUri, null, null)
	                    val success = rowsDeleted > 0
	
	                    // 如果删除成功，清除待处理状态
	                    if (success) {
	                        contentValues.clear()
	                        contentValues.put(MediaStore.MediaColumns.IS_PENDING, 0)
	                        contentResolver.update(fileUri, contentValues, null, null)
	                    }
	
	                    success
	                } else {
	                    // Android 10 及以下版本可以直接删除
	                    val rowsDeleted = contentResolver.delete(fileUri, null, null)
	                    rowsDeleted > 0
	                }
	            }
	
	            // 处理 file:// URI（内部存储文件）
	            fileUri.scheme == "file" -> {
	                val filePath = fileUri.path ?: return false
	                val file = File(filePath)
	
	                // 检查文件是否存在并属于应用内部或外部存储
	                if (file.exists() && isAppInternalFile(context, file)) {
	                    file.delete()
	                } else {
	                    console.log("FileUtils", "无法删除文件：不存在或非应用内部文件",filePath)
	                    false
	                }
	            }
	
	            else -> {
	                console.log("FileUtils", "不支持的 URI 方案：${fileUri.scheme}")
	                false
	            }
	        }
	    } catch (e: Exception) {
	        console.log("FileUtils", "删除文件失败：${e.message}")
	        e.printStackTrace()
	        false
	    }
	}
	
	/**
	 * 检查文件是否位于应用的内部或外部存储目录
	 */
	private fun isAppInternalFile(context: Context, file: File): Boolean {
	    val internalDirPath = context.filesDir.absolutePath
	    val cacheDirPath = context.cacheDir.absolutePath
	    val externalFilesDirPath = context.getExternalFilesDir(null)?.absolutePath
	    val externalCacheDirPath = context.externalCacheDir?.absolutePath
	
	    return file.absolutePath.startsWith(internalDirPath) ||
	            file.absolutePath.startsWith(cacheDirPath) ||
	            (externalFilesDirPath != null && file.absolutePath.startsWith(externalFilesDirPath)) ||
	            (externalCacheDirPath != null && file.absolutePath.startsWith(externalCacheDirPath))
	}
}