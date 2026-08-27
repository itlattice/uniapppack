@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.iboxsBiometric
import android.app.Application
import android.content.Context
import androidx.fragment.app.FragmentActivity
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
typealias InitBiometric = (application: Application) -> Boolean
typealias CheckBiometricSupport = () -> supportResult
open class supportResult (
    @JsonNotNull
    open var isSupported: Boolean = false,
    @JsonNotNull
    open var supportedTypes: UTSArray<String>,
    @JsonNotNull
    open var biometricWeak: Boolean = false,
    @JsonNotNull
    open var biometricStrong: Boolean = false,
    @JsonNotNull
    open var deviceCredential: Boolean = false,
) : UTSObject()
typealias CheckBiometricEnrolled = (authType: AuthType) -> Boolean
typealias Authenticate = (authType: AuthType, title: String, subtitle: String, description: String, onSuccess: () -> Unit, onError: (errorCode: Int, errorMessage: String) -> Unit, onFailed: () -> Unit) -> Unit
typealias OpenBiometricSettings = (authType: AuthType) -> Unit
typealias AuthType = String
val initBiometric: InitBiometric = fun(application: Application): Boolean {
    console.log("初始化")
    return AppBiometricManager.init(application) as Boolean
}
val checkBiometricSupport: CheckBiometricSupport = fun(): supportResult {
    var res = AppBiometricManager.checkBiometricSupport()
    var result = JSON.parseObject(res) as UTSJSONObject
    var biometricWeak = result["biometricWeak"] as UTSJSONObject
    var biometricStrong = result["biometricStrong"] as UTSJSONObject
    var deviceCredential = result["deviceCredential"] as UTSJSONObject
    var r = supportResult(isSupported = result["isSupported"] as Boolean, supportedTypes = result["supportedTypes"] as UTSArray<String>, biometricWeak = biometricWeak["supported"] as Boolean, biometricStrong = biometricStrong["supported"] as Boolean, deviceCredential = deviceCredential["supported"] as Boolean)
    return r
}
val authenticate: Authenticate = fun(authType: AuthType, title: String, subtitle: String, description: String, onSuccess: () -> Unit, onError: (errorCode: Int, errorMessage: String) -> Unit, onFailed: () -> Unit): Unit {
    var activity: FragmentActivity = UTSAndroid.getUniActivity() as FragmentActivity
    AppBiometricManager.authenticate(activity, title, subtitle, description, authType, onSuccess, onError, onFailed)
}
val checkBiometricEnrolled: CheckBiometricEnrolled = fun(authType: AuthType): Boolean {
    var r = AppBiometricManager.checkBiometricEnrolled(authType)
    return r
}
val openBiometricSettings: OpenBiometricSettings = fun(authType: AuthType): Unit {
    var activity: FragmentActivity = UTSAndroid.getUniActivity() as FragmentActivity
    AppBiometricManager.openBiometricSettings(activity, authType)
}
