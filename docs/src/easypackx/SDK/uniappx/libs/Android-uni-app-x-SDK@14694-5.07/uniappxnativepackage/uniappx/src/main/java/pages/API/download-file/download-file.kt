@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNIHelloUniAppX
import io.dcloud.uniapp.*
import io.dcloud.uniapp.extapi.*
import io.dcloud.uniapp.framework.*
import io.dcloud.uniapp.runtime.*
import io.dcloud.uniapp.vue.*
import io.dcloud.uniapp.vue.shared.*
import io.dcloud.unicloud.*
import io.dcloud.uts.*
import io.dcloud.uts.Map
import io.dcloud.uts.Set
import io.dcloud.uts.UTSAndroid
import kotlin.properties.Delegates
import io.dcloud.uniapp.extapi.downloadFile as uni_downloadFile
import io.dcloud.uniapp.extapi.env as uni_env
import io.dcloud.uniapp.extapi.hideLoading as uni_hideLoading
import io.dcloud.uniapp.extapi.request as uni_request
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading
import uts.sdk.modules.testInvokeNetworkApi.testInovkeDownloadFile
import uts.sdk.modules.testInvokeNetworkApi.testInovkeRequest
import uts.sdk.modules.testInvokeNetworkApi.CommonOptions
open class GenPagesAPIDownloadFileDownloadFile : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onLoad(fun(_: OnLoadOptions) {
            stat_instance.onLoad(this)
        }
        , __ins)
        onPageShow(fun() {
            stat_instance.onShow(this)
        }
        , __ins)
        onPageHide(fun() {
            stat_instance.onHide(this)
        }
        , __ins)
        onUnload(fun() {
            stat_instance.onUnload(this)
        }
        , __ins)
    }
    open var data: DataType__74
        get() {
            return unref(this.`$exposed`["data"]) as DataType__74
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var jest_downloadFile: () -> Unit
        get() {
            return unref(this.`$exposed`["jest_downloadFile"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_downloadFile", value)
        }
    open var jest_downloadFile_with_uni_env: () -> Unit
        get() {
            return unref(this.`$exposed`["jest_downloadFile_with_uni_env"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_downloadFile_with_uni_env", value)
        }
    open var jest_set_cookie: () -> Unit
        get() {
            return unref(this.`$exposed`["jest_set_cookie"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_set_cookie", value)
        }
    open var jest_delete_cookie: () -> Unit
        get() {
            return unref(this.`$exposed`["jest_delete_cookie"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_delete_cookie", value)
        }
    open var jest_uts_module_invoked: () -> Unit
        get() {
            return unref(this.`$exposed`["jest_uts_module_invoked"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_uts_module_invoked", value)
        }
    open var jest_special_characters_download: () -> Unit
        get() {
            return unref(this.`$exposed`["jest_special_characters_download"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_special_characters_download", value)
        }
    open var jest_download_call_timeout: () -> Unit
        get() {
            return unref(this.`$exposed`["jest_download_call_timeout"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_download_call_timeout", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIDownloadFileDownloadFile, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIDownloadFileDownloadFile
            val _cache = __ins.renderCache
            val data = reactive(DataType__74(title = "downloadFile", imageSrc = "", task = null, jest_result = false, jest_callback_triggred = false))
            onUnload(fun(){
                uni_hideLoading(null)
                data.task?.abort()
            }
            )
            val downloadImage = fun(){
                uni_showLoading(ShowLoadingOptions(title = "下载中"))
                data.task = uni_downloadFile(DownloadFileOptions(url = "https://web-assets.dcloud.net.cn/hello-uni-app-x/uni-app.png", success = fun(res){
                    console.log("downloadFile success, res is", res.tempFilePath)
                    data.imageSrc = res.tempFilePath
                }
                , fail = fun(err){
                    console.log("downloadFile fail, err is:", err)
                }
                , complete = fun(res){
                    uni_hideLoading(null)
                    data.task = null
                }
                ))
                data.task?.onProgressUpdate(fun(update){
                    console.log("progress : ", update.progress)
                }
                )
            }
            val downloadErrorFilename = fun(){
                data.task = uni_downloadFile(DownloadFileOptions(url = "https://qiniu-web-assets.dcloud.net.cn/uni-app-x/static/file/test9.txt", success = fun(res){
                    console.log("downloadFile success, res is", res.tempFilePath)
                }
                , fail = fun(err){
                    console.log("downloadFile fail, err is:", err)
                }
                ))
            }
            val jest_downloadFile = fun(){
                data.task = uni_downloadFile(DownloadFileOptions(url = "https://web-assets.dcloud.net.cn/hello-uni-app-x/uni-app.png", success = fun(_){
                    data.jest_result = true
                    data.jest_callback_triggred = true
                }
                , fail = fun(_){
                    data.jest_result = false
                    data.jest_callback_triggred = true
                }
                ))
            }
            val jest_downloadFile_with_uni_env = fun(){
                data.task = uni_downloadFile(DownloadFileOptions(url = "https://web-assets.dcloud.net.cn/hello-uni-app-x/uni-app.png", filePath = "" + uni_env.CACHE_PATH + "/a/b/", success = fun(_){
                    data.jest_result = true
                    data.jest_callback_triggred = true
                }
                , fail = fun(_){
                    data.jest_result = false
                    data.jest_callback_triggred = true
                }
                ))
            }
            val jest_cookie_download = fun(needCookie: Boolean){
                data.task = uni_downloadFile(DownloadFileOptions(url = "https://request.dcloud.net.cn/api/http/header/download", success = fun(_){
                    data.jest_result = if (needCookie) {
                        true
                    } else {
                        false
                    }
                    data.jest_callback_triggred = true
                }
                , fail = fun(_){
                    data.jest_result = if (needCookie) {
                        false
                    } else {
                        true
                    }
                }
                ))
            }
            val jest_set_cookie = fun(){
                uni_request<Any>(RequestOptions(url = "https://request.dcloud.net.cn/api/http/header/setCookie", method = "GET", timeout = 6000, sslVerify = false, withCredentials = true, firstIpv4 = false, success = fun(_){
                    jest_cookie_download(true)
                }
                , fail = fun(_){
                    data.jest_result = false
                    data.jest_callback_triggred = true
                }
                ))
            }
            val jest_delete_cookie = fun(){
                uni_request<Any>(RequestOptions(url = "https://request.dcloud.net.cn/api/http/header/deleteCookie", method = "GET", timeout = 6000, sslVerify = false, withCredentials = true, firstIpv4 = false, success = fun(_){
                    jest_cookie_download(false)
                }
                , fail = fun(_){
                    data.jest_result = false
                    data.jest_callback_triggred = true
                }
                ))
            }
            val jest_uts_module_invoked = fun(){
                testInovkeDownloadFile(CommonOptions(success = fun(res: Any){
                    data.jest_result = true
                    data.jest_callback_triggred = true
                }
                , fail = fun(err: Any){
                    data.jest_result = false
                    data.jest_callback_triggred = true
                }
                ))
            }
            val jest_special_characters_download = fun(){
                data.task = uni_downloadFile(DownloadFileOptions(url = "https://web-assets.dcloud.net.cn/hello-uni-app-x/1789834995055525889-你好%23你好.png", success = fun(_){
                    data.jest_result = true
                    data.jest_callback_triggred = true
                }
                , fail = fun(_){
                    data.jest_result = false
                    data.jest_callback_triggred = true
                }
                ))
            }
            val jest_download_call_timeout = fun(){
                data.task = uni_downloadFile(DownloadFileOptions(url = "https://web-assets.dcloud.net.cn/video/sample/2minute-demo-10k.mp4", timeout = 3000, fail = fun(_){
                    data.jest_result = false
                }
                ))
                setTimeout(fun(){
                    data.jest_result = true
                }
                , 4000)
            }
            __expose(_uM("data" to data, "jest_downloadFile" to jest_downloadFile, "jest_downloadFile_with_uni_env" to jest_downloadFile_with_uni_env, "jest_set_cookie" to jest_set_cookie, "jest_delete_cookie" to jest_delete_cookie, "jest_uts_module_invoked" to jest_uts_module_invoked, "jest_special_characters_download" to jest_special_characters_download, "jest_download_call_timeout" to jest_download_call_timeout))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", null, _uA(
                        _cV(_component_page_head, _uM("title" to unref(data).title), null, 8, _uA(
                            "title"
                        )),
                        _cE("view", null, _uA(
                            if (isTrue(unref(data).imageSrc)) {
                                _cE("view", _uM("key" to 0), _uA(
                                    _cE("image", _uM("class" to "img", "src" to unref(data).imageSrc, "mode" to "aspectFit"), null, 8, _uA(
                                        "src"
                                    ))
                                ))
                            } else {
                                _cE("view", _uM("key" to 1, "style" to _nS(_uM("margin" to "10px"))), _uA(
                                    _cE("text", _uM("class" to "uni-hello-text"), "点击按钮下载服务端示例图片（下载网络文件到本地临时目录）"),
                                    _cE("button", _uM("type" to "primary", "onClick" to downloadImage), "下载")
                                ), 4)
                            }
                            ,
                            _cE("view", _uM("style" to _nS(_uM("margin" to "10px"))), _uA(
                                _cE("text", _uM("class" to "uni-hello-text"), "下载接口的Content-Disposition中的filename非法值例子"),
                                _cE("button", _uM("type" to "primary", "onClick" to downloadErrorFilename), "下载")
                            ), 4)
                        ))
                    ))
                ), 4)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("img" to _pS(_uM("marginTop" to 0, "marginRight" to "auto", "marginBottom" to 0, "marginLeft" to "auto")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
