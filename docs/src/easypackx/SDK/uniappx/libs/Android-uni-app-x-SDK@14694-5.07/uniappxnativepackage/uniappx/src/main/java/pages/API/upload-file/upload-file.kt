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
import io.dcloud.uniapp.extapi.chooseImage as uni_chooseImage
import io.dcloud.uniapp.extapi.downloadFile as uni_downloadFile
import io.dcloud.uniapp.extapi.env as uni_env
import io.dcloud.uniapp.extapi.hideLoading as uni_hideLoading
import io.dcloud.uniapp.extapi.request as uni_request
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading
import io.dcloud.uniapp.extapi.showModal as uni_showModal
import io.dcloud.uniapp.extapi.showToast as uni_showToast
import uts.sdk.modules.testInvokeNetworkApi.testInovkeRequest
import uts.sdk.modules.testInvokeNetworkApi.CommonOptions
import uts.sdk.modules.testInvokeNetworkApi.testInovkeUploadFile
import io.dcloud.uniapp.extapi.uploadFile as uni_uploadFile
open class GenPagesAPIUploadFileUploadFile : BasePage {
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
    open var data: DataType__73
        get() {
            return unref(this.`$exposed`["data"]) as DataType__73
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var jest_uploadFile: () -> Unit
        get() {
            return unref(this.`$exposed`["jest_uploadFile"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_uploadFile", value)
        }
    open var jest_uploadFile_with_uni_env: () -> Unit
        get() {
            return unref(this.`$exposed`["jest_uploadFile_with_uni_env"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_uploadFile_with_uni_env", value)
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
    open var jest_files_upload: () -> Unit
        get() {
            return unref(this.`$exposed`["jest_files_upload"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_files_upload", value)
        }
    open var jest_uts_module_invoked: () -> Unit
        get() {
            return unref(this.`$exposed`["jest_uts_module_invoked"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_uts_module_invoked", value)
        }
    open var jest_uploadFileWithoutFile: () -> Unit
        get() {
            return unref(this.`$exposed`["jest_uploadFileWithoutFile"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_uploadFileWithoutFile", value)
        }
    open var jest_uploadFileVerifyUA: () -> Unit
        get() {
            return unref(this.`$exposed`["jest_uploadFileVerifyUA"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_uploadFileVerifyUA", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIUploadFileUploadFile, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIUploadFileUploadFile
            val _cache = __ins.renderCache
            val data = reactive(DataType__73(title = "uploadFile", imageSrc = "", task = null, jest_result = false))
            onUnload(fun(){
                data.imageSrc = ""
                uni_hideLoading(null)
                data.task?.abort()
            }
            )
            val chooseImage = fun(){
                uni_chooseImage(ChooseImageOptions(count = 1, sizeType = _uA(
                    "compressed"
                ), sourceType = _uA(
                    "album"
                ), success = fun(res){
                    console.log("chooseImage success, temp path is", res.tempFilePaths[0])
                    var imageSrc = res.tempFilePaths[0]
                    uni_showLoading(ShowLoadingOptions(title = "上传中"))
                    data.task = uni_uploadFile(UploadFileOptions(url = "https://unidemo.dcloud.net.cn/upload", filePath = imageSrc, name = "file", formData = _uO("user" to "test"), success = fun(res){
                        console.log("uploadImage success, res is:", res)
                        uni_showToast(ShowToastOptions(title = "上传成功", icon = "success", duration = 1000))
                        data.imageSrc = imageSrc
                    }
                    , fail = fun(err){
                        console.log("uploadImage fail", err)
                        uni_showModal(ShowModalOptions(content = err.errMsg, showCancel = false))
                    }
                    , complete = fun(res){
                        uni_hideLoading(null)
                        data.task = null
                    }
                    ))
                }
                , fail = fun(err){
                    console.log("chooseImage fail", err)
                }
                ))
            }
            val jest_uploadFile = fun(){
                val imageSrc = "/static/test-image/logo.png"
                uni_uploadFile(UploadFileOptions(url = "https://unidemo.dcloud.net.cn/upload", filePath = imageSrc, name = "file", formData = _uO("user" to "test"), success = fun(_){
                    data.jest_result = true
                }
                , fail = fun(_){
                    data.jest_result = false
                }
                ))
            }
            val jest_uploadFile_with_uni_env = fun(){
                val filePath = "" + uni_env.USER_DATA_PATH + "/uni-app.png"
                uni_downloadFile(DownloadFileOptions(url = "https://qiniu-web-assets.dcloud.net.cn/unidoc/zh/uni-app.png", filePath = filePath, success = fun(_){
                    uni_uploadFile(UploadFileOptions(url = "https://unidemo.dcloud.net.cn/upload", filePath = filePath, name = "file", success = fun(_){
                        data.jest_result = true
                    }
                    , fail = fun(_){
                        data.jest_result = false
                    }
                    ))
                }
                , fail = fun(_){
                    data.jest_result = false
                }
                ))
            }
            val jest_cookie_upload = fun(needCookie: Boolean){
                val imageSrc = "/static/test-image/logo.png"
                uni_uploadFile(UploadFileOptions(url = "https://request.dcloud.net.cn/api/http/header/upload", filePath = imageSrc, name = "file", success = fun(res: UploadFileSuccess){
                    val responseData = JSON.parseObject(res.data)
                    val errCode = responseData?.getNumber("errCode")
                    if (errCode != null && errCode == 1000) {
                        data.jest_result = if (needCookie) {
                            false
                        } else {
                            true
                        }
                    } else {
                        data.jest_result = if (needCookie) {
                            true
                        } else {
                            false
                        }
                    }
                }
                , fail = fun(_){
                    data.jest_result = false
                }
                ))
            }
            val jest_set_cookie = fun(){
                uni_request<Any>(RequestOptions(url = "https://request.dcloud.net.cn/api/http/header/setCookie", method = "GET", timeout = 6000, sslVerify = false, withCredentials = false, firstIpv4 = false, success = fun(_){
                    jest_cookie_upload(true)
                }
                , fail = fun(_){
                    data.jest_result = false
                }
                ))
            }
            val jest_delete_cookie = fun(){
                uni_request<Any>(RequestOptions(url = "https://request.dcloud.net.cn/api/http/header/deleteCookie", method = "GET", timeout = 6000, sslVerify = false, withCredentials = false, firstIpv4 = false, success = fun(_){
                    jest_cookie_upload(false)
                }
                , fail = fun(_){
                    data.jest_result = false
                }
                ))
            }
            val jest_files_upload = fun(){
                val imageSrc = "/static/test-image/logo.png"
                uni_uploadFile(UploadFileOptions(url = "https://unidemo.dcloud.net.cn/upload", files = _uA(
                    UploadFileOptionFiles(name = "file1", uri = imageSrc),
                    UploadFileOptionFiles(name = "file2", uri = imageSrc)
                ), success = fun(res: UploadFileSuccess){
                    if (res.statusCode == 200) {
                        data.jest_result = true
                    }
                }
                , fail = fun(_){
                    data.jest_result = false
                }
                ))
            }
            val jest_uts_module_invoked = fun(){
                testInovkeUploadFile(CommonOptions(success = fun(res: Any){
                    data.jest_result = true
                }
                , fail = fun(err: Any){
                    data.jest_result = false
                }
                ))
            }
            val jest_uploadFileWithoutFile = fun(){
                uni_uploadFile(UploadFileOptions(url = "https://unidemo.dcloud.net.cn/upload", formData = _uO("user" to "test"), success = fun(res){
                    console.log("success: ", res)
                    data.jest_result = true
                }
                , fail = fun(err){
                    console.log("fail: ", err)
                    data.jest_result = false
                }
                ))
            }
            val jest_uploadFileVerifyUA = fun(){
                uni_uploadFile(UploadFileOptions(url = "https://request.dcloud.net.cn/api/http/header/upload", header = _uO("User-Agent" to "custom"), formData = _uO("user" to "test"), success = fun(res: UploadFileSuccess){
                    val responseData = JSON.parseObject(res.data)
                    val innerData = responseData?.getJSON("data")
                    val header = innerData?.getJSON("requestHeaders")
                    val uas = header?.getArray("user-agent")
                    if (uas != null) {
                        data.jest_result = (uas.length == 1)
                    }
                }
                , fail = fun(_){
                    data.jest_result = false
                }
                ))
            }
            __expose(_uM("data" to data, "jest_uploadFile" to jest_uploadFile, "jest_uploadFile_with_uni_env" to jest_uploadFile_with_uni_env, "jest_set_cookie" to jest_set_cookie, "jest_delete_cookie" to jest_delete_cookie, "jest_files_upload" to jest_files_upload, "jest_uts_module_invoked" to jest_uts_module_invoked, "jest_uploadFileWithoutFile" to jest_uploadFileWithoutFile, "jest_uploadFileVerifyUA" to jest_uploadFileVerifyUA))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE("scroll-view", _uM("class" to "page-scroll-view"), _uA(
                    _cE("view", null, _uA(
                        _cV(_component_page_head, _uM("title" to unref(data).title), null, 8, _uA(
                            "title"
                        )),
                        _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt"), _uA(
                            _cE("view", _uM("class" to "demo"), _uA(
                                if (isTrue(unref(data).imageSrc)) {
                                    _cE("image", _uM("key" to 0, "src" to unref(data).imageSrc, "class" to "image", "mode" to "widthFix"), null, 8, _uA(
                                        "src"
                                    ))
                                } else {
                                    _cE("text", _uM("key" to 1, "class" to "uni-hello-addfile", "onClick" to chooseImage), "+ 选择图片")
                                }
                            ))
                        ))
                    ))
                ))
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("image" to _pS(_uM("width" to "100%")), "demo" to _pS(_uM("backgroundImage" to "none", "backgroundColor" to "#ffffff", "paddingTop" to 25, "paddingRight" to 25, "paddingBottom" to 25, "paddingLeft" to 25, "justifyContent" to "center", "alignItems" to "center")), "uni-hello-addfile" to _pS(_uM("textAlign" to "center", "backgroundImage" to "none", "backgroundColor" to "#ffffff", "paddingTop" to 25, "paddingRight" to 25, "paddingBottom" to 25, "paddingLeft" to 25, "marginTop" to 10, "fontSize" to 19, "color" to "#808080")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
