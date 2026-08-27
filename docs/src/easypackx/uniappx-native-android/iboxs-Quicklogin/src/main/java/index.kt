@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.iboxsQuicklogin
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
import org.json.JSONObject
import uts.sdk.modules.iboxsQuicklogin.R
typealias InitQuickLogin = (complete: (code: Number, msg: String) -> Unit) -> Unit
typealias InitSuccess = () -> Boolean
typealias GetOperatorType = () -> String
typealias CheckVerifyEnable = () -> Boolean
typealias CheckSmsEnable = () -> Boolean
typealias IsValidePreloginCache = () -> Boolean
typealias PreLogin = (timeOut: Number, complete: (code: Number, content: String) -> Unit) -> Unit
typealias LoginAuth = (event: (cmd: Int, msg: String) -> Unit, result: (code: Int, msg: String, reson: String, json: UTSJSONObject) -> Unit) -> Unit
typealias CloseAuth = (needCloseAnim: Boolean, complete: (code: Int, msg: String) -> Unit) -> Unit
typealias AuthToken = (timeOut: Number, result: (code: Int, msg: String, reson: String, json: UTSJSONObject) -> Unit) -> Unit
val initQuickLogin: InitQuickLogin = fun(complete: (code: Number, msg: String) -> Unit) {
    IBoxsQuickLogin.init(UTSAndroid.getAppContext() as Context, fun(code: Int, msg: String) {
        complete(code, msg)
    }
    )
}
val initSuccess: InitSuccess = fun(): Boolean {
    var isSuccess = IBoxsQuickLogin.initSuccess()
    return isSuccess
}
val getOperatorType: GetOperatorType = fun(): String {
    var operatorType = IBoxsQuickLogin.getOperatorType(UTSAndroid.getAppContext() as Context)
    return operatorType
}
val checkVerifyEnable: CheckVerifyEnable = fun(): Boolean {
    var isSuccess = IBoxsQuickLogin.checkVerifyEnable(UTSAndroid.getAppContext() as Context)
    return isSuccess
}
val checkSmsEnable: CheckSmsEnable = fun(): Boolean {
    var isSuccess = IBoxsQuickLogin.checkSmsEnable(UTSAndroid.getAppContext() as Context)
    return isSuccess
}
val isValidePreloginCache: IsValidePreloginCache = fun(): Boolean {
    var isSuccess = IBoxsQuickLogin.isValidePreloginCache(UTSAndroid.getAppContext() as Context)
    return isSuccess
}
val preLogin: PreLogin = fun(timeOut: Number, complete: (code: Number, content: String) -> Unit) {
    console.log("开始预取号")
    IBoxsQuickLogin.preLogin(UTSAndroid.getAppContext() as Context, timeOut.toInt(), fun(code: Int, content: String) {
        complete(code, content)
    }
    )
}
val loginAuth: LoginAuth = fun(event: (cmd: Int, msg: String) -> Unit, result: (code: Int, token: String, oprationType: String, json: UTSJSONObject) -> Unit) {
    IBoxsQuickLogin.loginAuth(UTSAndroid.getAppContext() as Context, fun(cmd: Int, msg: String) {
        event(cmd, msg)
    }
    , fun(code: Int, token: String, oprationType: String, json: String) {
        result(code, token, oprationType, JSON.parseObject(json) as UTSJSONObject)
    }
    )
}
val closeAuth: CloseAuth = fun(needCloseAnim: Boolean, complete: (code: Int, msg: String) -> Unit) {
    IBoxsQuickLogin.dismissLoginAuthActivity(needCloseAnim, fun(code: Int, msg: String) {
        complete(code, msg)
    }
    )
}
val authToken: AuthToken = fun(timeOut: Number, result: (code: Int, token: String, oprationType: String, json: UTSJSONObject) -> Unit) {
    IBoxsQuickLogin.authToken(UTSAndroid.getAppContext() as Context, timeOut.toInt(), fun(code: Int, token: String, oprationType: String, json: String) {
        result(code, token, oprationType, JSON.parseObject(json) as UTSJSONObject)
    }
    )
}
