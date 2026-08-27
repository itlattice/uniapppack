@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.iboxsQcloudCos
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
typealias Init = (secretId: String, secretKey: String, sessionToken: String, host: String, region: String, startTime: Long, expiredTime: Long, isHttps: Boolean) -> Unit
typealias CosUploadFile = (bucket: String, cosPath: String, srcUri: String, onProgress: (process: Float) -> Unit, onSuccess: (res: String?) -> Unit, onFailure: (res: String?) -> Unit) -> Unit
val init: Init = fun(secretId: String, secretKey: String, sessionToken: String, host: String, region: String, startTime: Long, expiredTime: Long, isHttps: Boolean): Unit {
    TencentCOS.init(UTSAndroid.getAppContext() as Context, secretId, secretKey, sessionToken, host, region, startTime, expiredTime, isHttps)
}
val cosUploadFile: CosUploadFile = fun(bucket: String, cosPath: String, srcUri: String, onProgress: (process: Float) -> Unit, onSuccess: (res: String?) -> Unit, onFailure: (res: String?) -> Unit): Unit {
    TencentCOS.cosUploadFile(UTSAndroid.getAppContext() as Context, bucket, cosPath, srcUri, onProgress, onSuccess, onFailure)
}
