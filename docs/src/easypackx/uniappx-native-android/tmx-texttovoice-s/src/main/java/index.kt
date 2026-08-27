@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.tmxTexttovoiceS
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.OnInitListener
import android.speech.tts.UtteranceProgressListener
import io.dcloud.uniapp.*
import io.dcloud.uniapp.extapi.*
import io.dcloud.uniapp.framework.*
import io.dcloud.uniapp.runtime.*
import io.dcloud.uniapp.vue.*
import io.dcloud.uniapp.vue.shared.*
import io.dcloud.uts.*
import io.dcloud.uts.Map
import io.dcloud.uts.Set
import io.dcloud.uts.UTSAndroid
import java.util.Locale
import kotlin.properties.Delegates
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
open class XuiTextToVoiceResult : UTSObject() {
}
interface XuiTextToVoiceFail : IUniError {
    override var errCode: Number
}
open class XuiTextToVoiceOpts (
    open var onStart: (() -> Unit)? = null,
    open var onStop: (() -> Unit)? = null,
    open var onError: ((res: XuiTextToVoiceFail) -> Unit)? = null,
    open var onDone: (() -> Unit)? = null,
    open var success: ((res: XTTSImpl) -> Unit)? = null,
    open var fail: ((res: XuiTextToVoiceFail) -> Unit)? = null,
    open var complete: ((res: XuiTextToVoiceResult?) -> Unit)? = null,
) : UTSObject()
interface XTTSImpl {
    fun isPlaying(): Boolean
    fun play(c: String)
    fun stop()
}
val XuiErrors: Map<Number, String> = Map(_uA(
    _uA(
        1000,
        "没有相关权限"
    ),
    _uA(
        1001,
        "初始化失败"
    ),
    _uA(
        1002,
        "设置的语文包在系统中缺失"
    ),
    _uA(
        1003,
        "初始化中或者还在报播中"
    ),
    _uA(
        1004,
        "播放中出现错误"
    )
))
open class XuiTextToVoiceFailImpl : UniError, XuiTextToVoiceFail {
    constructor(errCode: Number) : super() {
        this.errSubject = "x-chinesetopinyin-s"
        this.errCode = errCode
        this.errMsg = XuiErrors.get(errCode) ?: ""
    }
}
var tts: TextToSpeech? = null
fun checkPermissions(call: (isAuth: Boolean) -> Unit) {
    var cehckPerMissionsArs = _uA<String>()
    if (UTSAndroid.checkSystemPermissionGranted(UTSAndroid.getUniActivity()!!, cehckPerMissionsArs)) {
        call(true)
    } else {
        UTSAndroid.requestSystemPermission(UTSAndroid.getUniActivity()!!, cehckPerMissionsArs, fun(_A: Boolean, _B: UTSArray<String>) {
            call(true)
        }
        , fun(_B: Boolean, _A: UTSArray<String>) {
            call(false)
        }
        )
    }
}
open class TtsObj : XTTSImpl {
    open lateinit var config: XuiTextToVoiceOpts
    constructor(opts: XuiTextToVoiceOpts){
        this.config = opts
    }
    override fun isPlaying(): Boolean {
        var isplay = tts?.isSpeaking
        return if (isplay == null) {
            false
        } else {
            isplay
        }
    }
    override fun play(c: String) {
        val params = Bundle()
        tts?.speak(c, TextToSpeech.QUEUE_FLUSH, params, Math.random().toString(16).substring(4))
    }
    override fun stop() {
        tts?.stop()
        tts?.shutdown()
        this.config.onStop?.invoke()
    }
}
var TtsObjIml: TtsObj? = null
open class xTtsImplIns {
    companion object {
        public fun play(c: String) {
            TtsObjIml?.play(c)
        }
        public fun isPlaying(): Boolean {
            return TtsObjIml?.isPlaying() ?: false
        }
        public fun stop() {
            TtsObjIml?.stop()
        }
    }
}
fun XTtsSpeek(opts: XuiTextToVoiceOpts) {
    fun initTTS() {
        open class Listen : OnInitListener {
            override fun onInit(status: Int) {
                if (status != TextToSpeech.SUCCESS) {
                    tts = null
                    console.error("TMUI Error:", status)
                    opts.fail?.invoke(XuiTextToVoiceFailImpl(1001))
                    opts.complete?.invoke(null)
                    return
                }
                var ttsObj = tts!!
                val result = ttsObj.setLanguage(Locale.CHINESE)
                if (result == TextToSpeech.LANG_MISSING_DATA) {
                    tts = null
                    opts.fail?.invoke(XuiTextToVoiceFailImpl(1002))
                    opts.complete?.invoke(null)
                    return
                }
                TtsObjIml = TtsObj(opts)
                opts.success?.invoke(TtsObjIml!!)
                opts.complete?.invoke(null)
            }
        }
        open class ProgressListen : UtteranceProgressListener {
            constructor() : super() {}
            public override fun onError(param: String?) {
                opts.onError?.invoke(XuiTextToVoiceFailImpl(1004))
            }
            public override fun onStart(param: String?) {
                opts.onStart?.invoke()
            }
            public override fun onDone(param: String?) {
                opts.onDone?.invoke()
            }
        }
        tts = TextToSpeech(UTSAndroid.getAppContext()!!, Listen())
        tts!!.setOnUtteranceProgressListener(ProgressListen())
    }
    if (tts != null) {
        tts?.stop()
        tts?.shutdown()
        tts = null
    }
    initTTS()
}
