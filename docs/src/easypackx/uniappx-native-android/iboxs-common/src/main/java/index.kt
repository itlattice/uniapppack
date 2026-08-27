@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.iboxsCommon
import android.app.Activity
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
val vibrate = fun(millis: Number): Boolean {
    return VibrationUtils.vibrate(UTSAndroid.getAppContext() as Context, millis.toLong())
}
val vibratePattern = fun(pattern: UTSArray<Number>, repeat: Number): Boolean {
    var pat = null as LongArray?
    run {
        var i: Number = 0
        while(i < pattern.length){
            pat?.set(i.toInt(), pattern[i].toLong() as Long)
            i++
        }
    }
    return VibrationUtils.vibratePattern(UTSAndroid.getAppContext() as Context, pat as LongArray, repeat.toInt())
}
val cancelVibration = fun() {
    return VibrationUtils.cancelVibration(UTSAndroid.getAppContext() as Context)
}
val binaryStringToDecimal = fun(binaryStr: String): String {
    var big = Helper.binaryStringToDecimal(binaryStr).toString()
    return big
}
val setKeyListener = fun(downCallback: () -> Boolean, upCallback: () -> Boolean) {
    return VolumeKeyMonitor.setListener(UTSAndroid.getUniActivity() as Activity, fun(): Boolean {
        return downCallback()
    }
    , fun(): Boolean {
        return upCallback()
    }
    )
}
val removeListener = fun() {
    return VolumeKeyMonitor.removeListener()
}
val evalFun = fun(code: String): Any {
    return Helper.evalFun(code) as Any
}
val keepScreenOn = fun() {
    Helper.keepScreenOn(UTSAndroid.getUniActivity() as Activity)
}
val clearKeepScreenOn = fun() {
    Helper.clearKeepScreenOn(UTSAndroid.getUniActivity() as Activity)
}
val encryptByPublicKey = fun(data: String, publicKey: String): String {
    return RsaUtils.encryptByPublicKey(data, publicKey)
}
val decryptByPublicKey = fun(data: String, publicKey: String): String {
    return RsaUtils.decryptByPublicKey(data, publicKey)
}
val encryptByPrivateKey = fun(data: String, publicKey: String): String {
    return RsaUtils.encryptByPrivateKey(data, publicKey)
}
val decryptByPrivateKey = fun(data: String, publicKey: String): String {
    return RsaUtils.decryptByPrivateKey(data, publicKey)
}
val decryptEncryptedPublicKey = fun(encryptedFileBase64: String, password: String): String {
    return OpenSslAesDecrypt.decryptEncryptedPublicKey(encryptedFileBase64, password)
}
val aes256CbcEncrypt = fun(data: String, key: String, iv: String): String {
    return Aes256CbcUtil.encrypt(data, key, iv)
}
val aes256CbcDecrypt = fun(data: String, key: String, iv: String): String {
    return Aes256CbcUtil.decrypt(data, key, iv)
}
