@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.iboxsZimfacade
import android.content.Context
import com.alipay.face.api.ZIMCallback
import com.alipay.face.api.ZIMFacade
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
val initZimfacafe = fun(): Int {
    return Auth.install(UTSAndroid.getAppContext() as Context)
}
val getMetaInfo = fun(): String {
    return Auth.getMetaInfos(UTSAndroid.getAppContext() as Context)
}
val faceVerify = fun(certifyId: String, params: String?, callback: (success: Boolean, code: Int?, reason: String?) -> Unit) {
    return Auth.verify(UTSAndroid.getAppContext() as Context, certifyId, params, fun(success: Boolean, code: Int?, reason: String?) {
        callback(success, code, reason)
    }
    )
}
val setUI = fun(json: String): String {
    return Auth.setUI(UTSAndroid.getAppContext() as Context, json)
}
