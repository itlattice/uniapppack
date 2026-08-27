@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.testInvokeNetworkApi
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
import io.dcloud.uniapp.extapi.downloadFile as uni_downloadFile
import io.dcloud.uniapp.extapi.env as uni_env
import io.dcloud.uniapp.extapi.request as uni_request
import io.dcloud.uniapp.extapi.uploadFile as uni_uploadFile
open class CommonOptions (
    open var success: ((res: Any) -> Unit)? = null,
    open var fail: ((res: Any) -> Unit)? = null,
) : UTSObject()
fun testInovkeRequest(options: CommonOptions): Unit {
    uni_request<Any>(RequestOptions(url = "https://request.dcloud.net.cn/api/http/method/post", method = "POST", header = _uO("Cookie" to "token11222"), timeout = 6000, sslVerify = false, withCredentials = false, data = _uO("platform" to _uO("abc" to "xyq")), firstIpv4 = false, success = fun(res: RequestSuccess<Any>){
        options.success?.invoke(res)
    }
    , fail = fun(e: RequestFail) {
        options.fail?.invoke(e)
    }
    ))
}
fun testInovkeUploadFile(options: CommonOptions): Unit {
    val imageSrc = "/static/test-image/logo.png"
    uni_uploadFile(UploadFileOptions(url = "https://unidemo.dcloud.net.cn/upload", files = _uA(
        UploadFileOptionFiles(name = "file1", uri = imageSrc),
        UploadFileOptionFiles(name = "file2", uri = imageSrc)
    ), success = fun(res: UploadFileSuccess){
        options.success?.invoke(res)
    }
    , fail = fun(err: UploadFileFail){
        options.fail?.invoke(err)
    }
    ))
}
fun testInovkeDownloadFile(options: CommonOptions): Unit {
    uni_downloadFile(DownloadFileOptions(url = "https://qiniu-web-assets.dcloud.net.cn/unidoc/zh/uni-app.png", filePath = "" + uni_env.CACHE_PATH + "/halo/world/", success = fun(res: DownloadFileSuccess) {
        options.success?.invoke(res)
    }
    , fail = fun(e: DownloadFileFail) {
        options.fail?.invoke(e)
    }
    ))
}
