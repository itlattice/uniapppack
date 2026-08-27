package uts.sdk.modules.iboxsOcr

import android.content.Context
import io.dcloud.uts.UTSAndroid

object API {
	fun init(){
		OCRManager.init(UTSAndroid.getAppContext())
	}
	
	fun recognizeImage(imagePath: String,includeImageLabels: Boolean = false,onSuccess:(OCRManager.OCRResult)->Unit={},onError:(String)->Unit={}){
		OCRManager.init(UTSAndroid.getAppContext())
		OCRManager.recognizeImage(imagePath,includeImageLabels,callback=object:OCRManager.OCRCallback{
			override fun onSuccess(result: OCRManager.OCRResult) {
				onSuccess(result)
			}
			override fun onError(message: String) {
				onError(message)
			}
		})
	}
}