@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.iboxsTts
import android.content.Context
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
import kotlin.properties.Delegates
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
open class InitTTSOptions (
    open var success: () -> Unit,
    open var error: () -> Unit,
) : UTSObject()
open class TTSOptions (
    @JsonNotNull
    open var text: String,
    open var speed: Number? = null,
    open var start: () -> Unit,
    open var complete: () -> Unit,
    open var error: () -> Unit,
) : UTSObject()
val initTTS = fun(options: InitTTSOptions){
    API.ttsInit(UTSAndroid.getAppContext() as Context, fun() {
        options.success()
    }
    , fun() {
        options.error()
    }
    )
}
val speak = fun(options: TTSOptions){
    var speed = if (options.speed == null) {
        1.0
    } else {
        options.speed!!
    }
    API.speak(options.text, speed as Number, fun() {
        options.start()
    }
    , fun() {
        options.complete()
    }
    , fun() {
        options.error()
    }
    )
}
