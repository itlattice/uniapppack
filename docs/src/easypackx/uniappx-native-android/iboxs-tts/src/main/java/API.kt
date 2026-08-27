package uts.sdk.modules.iboxsTts

import android.content.Context
import io.dcloud.uts.console

object API {
	fun ttsInit(context:Context,success:()->Unit={},error:()->Unit={}){
		TTSManager.init(context,"tts_model",2,"gpu",callback=object:TTSManager.InitCallback{
			override fun onSuccess() {
				success()
			}
			override fun onError(error: Throwable) {
				console.error("ttsInit Error",error)
				error()
			}
		})
	}
	
	fun speak(text:String,speed: Number,onStart:()->Unit={},onComplete:()->Unit={},onError:()->Unit={}){
		TTSManager.speak(text,0,speed.toFloat(),callback=object:TTSManager.SpeakCallback{
			override fun onStart() {
				onStart()
			}
			override fun onComplete() {
				onComplete()
			}
			override fun onError(error: Throwable) {
				console.error("speak Error",error)
				onError()
			}
		})
	}
}