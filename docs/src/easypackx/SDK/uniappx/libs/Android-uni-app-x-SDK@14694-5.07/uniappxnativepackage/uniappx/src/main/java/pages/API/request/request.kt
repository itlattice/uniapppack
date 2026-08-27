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
import io.dcloud.uniapp.extapi.getFileSystemManager as uni_getFileSystemManager
import io.dcloud.uniapp.extapi.hideLoading as uni_hideLoading
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
import io.dcloud.uniapp.extapi.request as uni_request
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading
import io.dcloud.uniapp.extapi.showModal as uni_showModal
import io.dcloud.uniapp.extapi.showToast as uni_showToast
import uts.sdk.modules.testInvokeNetworkApi.testInovkeRequest
import uts.sdk.modules.testInvokeNetworkApi.CommonOptions
open class GenPagesAPIRequestRequest : BasePage {
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
    open var data: DataType__72
        get() {
            return unref(this.`$exposed`["data"]) as DataType__72
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var sendArrayBuffer: (onlyResponse: Boolean) -> Unit
        get() {
            return unref(this.`$exposed`["sendArrayBuffer"]) as (onlyResponse: Boolean) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "sendArrayBuffer", value)
        }
    open var jest_request: () -> Unit
        get() {
            return unref(this.`$exposed`["jest_request"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_request", value)
        }
    open var jest_set_cookie: () -> Unit
        get() {
            return unref(this.`$exposed`["jest_set_cookie"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_set_cookie", value)
        }
    open var jest_set_cookie_expires: () -> Unit
        get() {
            return unref(this.`$exposed`["jest_set_cookie_expires"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_set_cookie_expires", value)
        }
    open var jest_delete_cookie: () -> Unit
        get() {
            return unref(this.`$exposed`["jest_delete_cookie"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_delete_cookie", value)
        }
    open var jest_cookie_request: (needCookie: Boolean) -> Unit
        get() {
            return unref(this.`$exposed`["jest_cookie_request"]) as (needCookie: Boolean) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_cookie_request", value)
        }
    open var jest_timeout_null: () -> Unit
        get() {
            return unref(this.`$exposed`["jest_timeout_null"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_timeout_null", value)
        }
    open var jest_get_with_data: () -> Unit
        get() {
            return unref(this.`$exposed`["jest_get_with_data"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_get_with_data", value)
        }
    open var jest_get_with_generics: () -> Unit
        get() {
            return unref(this.`$exposed`["jest_get_with_generics"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_get_with_generics", value)
        }
    open var jest_get_array: () -> Unit
        get() {
            return unref(this.`$exposed`["jest_get_array"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_get_array", value)
        }
    open var jest_uts_module_invoked: () -> Unit
        get() {
            return unref(this.`$exposed`["jest_uts_module_invoked"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_uts_module_invoked", value)
        }
    open var jest_respone_json_string: () -> Unit
        get() {
            return unref(this.`$exposed`["jest_respone_json_string"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_respone_json_string", value)
        }
    open var jest_respone_with_string_generics: () -> Unit
        get() {
            return unref(this.`$exposed`["jest_respone_with_string_generics"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_respone_with_string_generics", value)
        }
    open var jest_respone_with_404_and_string_generics: () -> Unit
        get() {
            return unref(this.`$exposed`["jest_respone_with_404_and_string_generics"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_respone_with_404_and_string_generics", value)
        }
    open var jest_issue_19687: () -> Unit
        get() {
            return unref(this.`$exposed`["jest_issue_19687"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_issue_19687", value)
        }
    open var jest_test_issue21823_crash: () -> Unit
        get() {
            return unref(this.`$exposed`["jest_test_issue21823_crash"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_test_issue21823_crash", value)
        }
    open var sendGzipRequest: () -> Unit
        get() {
            return unref(this.`$exposed`["sendGzipRequest"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "sendGzipRequest", value)
        }
    open var checkQuery: () -> Unit
        get() {
            return unref(this.`$exposed`["checkQuery"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "checkQuery", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIRequestRequest, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIRequestRequest
            val _cache = __ins.renderCache
            open class GETDataType {
                open var data: UTSJSONObject? = null
            }
            val duration: Number = 2000
            val methodMap: UTSJSONObject = _uO("GET" to "/api/http/method/get", "POST" to "/api/http/method/post", "PUT" to "/api/http/method/put", "DELETE" to "/api/http/method/delete", "PATCH" to "/api/http/method/patch", "OPTIONS" to "/api/http/method/options", "HEAD" to "/api/http/method/head")
            val h3url = "https://request-h3.dcloud.net.cn/api/http/protocol"
            val data = reactive(DataType__72(title = "request", res = "", task = null, host = "https://request.dcloud.net.cn", url = "/api/http/method/get", method = "GET", data = null, header = null, errorCodeUrls = _uA(
                "/api/http/statusCode/200",
                "/api/http/statusCode/204",
                "/api/http/statusCode/301",
                "/api/http/statusCode/302",
                "/api/http/statusCode/307",
                "/api/http/statusCode/400",
                "/api/http/statusCode/401",
                "/api/http/statusCode/403",
                "/api/http/statusCode/404",
                "/api/http/statusCode/405",
                "/api/http/statusCode/500",
                "/api/http/statusCode/502",
                "/api/http/statusCode/503",
                "/api/http/statusCode/504"
            ), headerUrls = _uA(
                "/api/http/header/ua",
                "/api/http/header/referer",
                "/api/http/header/requestCookie",
                "/api/http/header/setCookie",
                "/api/http/header/deleteCookie"
            ), contentTypeUrls = _uA(
                "/api/http/contentType/text/plain",
                "/api/http/contentType/text/html",
                "/api/http/contentType/text/xml",
                "/api/http/contentType/image/gif",
                "/api/http/contentType/image/jpeg",
                "/api/http/contentType/image/png",
                "/api/http/contentType/application/json",
                "/api/http/contentType/application/octetStream"
            ), postUrls = _uA(
                "/api/http/contentType/json",
                "/api/http/contentType/xWwwFormUrlencoded"
            ), jest_requestTask_result = false, jest_result = false, jest_complete = false, jest_result_data = ""))
            onUnload(fun(){
                uni_hideLoading(null)
                data.task?.abort()
            }
            )
            val sendChunkRequest = fun(){
                uni_navigateTo(NavigateToOptions(url = "/pages/API/request/requestTask"))
            }
            val sendH3Request = fun(){
                uni_showLoading(ShowLoadingOptions(title = "请求中..."))
                uni_request<String>(RequestOptions(url = h3url, enableQuic = true, dataType = "text", success = fun(res){
                    data.res = JSON.stringify(res)
                    uni_hideLoading(null)
                    uni_showToast(ShowToastOptions(title = "请求成功", icon = "success", duration = duration))
                    console.log("res: ", res)
                }
                , fail = fun(e){
                    data.res = e.errMsg
                    uni_hideLoading(null)
                    uni_showToast(ShowToastOptions(title = "请求失败", icon = "error", duration = duration))
                    console.log("error: ", e)
                }
                ))
            }
            val sendGzipRequest = fun(){
                uni_request<Any>(RequestOptions(url = data.host + methodMap["POST"], header = _uO("Accept-Encoding" to "gzip"), method = "POST", data = _uO("hello" to "world"), success = fun(res){
                    console.log("res: ", res)
                    data.jest_result = true
                }
                , fail = fun(e){
                    console.log("error: ", e)
                    data.jest_result = false
                }
                ))
            }
            val checkQuery = fun(){
                uni_request<String>(RequestOptions(url = "https://request.dcloud.net.cn/api/http/echo/text?Signature=whpMFJg%2B%2Fc0tqdNXxo4330muVdc%3D", success = fun(res){
                    data.jest_result = res.data == "Signature=whpMFJg%2B%2Fc0tqdNXxo4330muVdc%3D\n"
                    console.log("res: ", res)
                }
                , fail = fun(e){
                    console.log("error: ", e)
                    data.jest_result = false
                }
                ))
            }
            val changeMethod = fun(e: RequestMethod){
                data.method = e
                data.url = methodMap[e] as String
                data.data = null
                data.header = null
            }
            val changeUrl = fun(e: String){
                data.method = "GET"
                data.url = e
                data.data = null
                data.header = null
            }
            val changeUrlFromPost = fun(e: String){
                data.method = "POST"
                data.url = e
                when (e) {
                    "/api/http/contentType/json" -> 
                        {
                            data.header = _uO("Content-Type" to "application/json")
                            data.data = _uO("hello" to "world")
                        }
                    "/api/http/contentType/xWwwFormUrlencoded" -> 
                        {
                            data.header = _uO("Content-Type" to "application/x-www-form-urlencoded")
                            data.data = "hello=world"
                        }
                }
            }
            val sendArrayBuffer = fun(onlyResponse: Boolean){
                data.method = "POST"
                data.url = "/api/http/contentType/arrayBuffer/post"
                if (onlyResponse) {
                    data.header = _uO("Content-Type" to "application/json")
                    data.data = _uO("hello" to "world")
                    uni_showLoading(ShowLoadingOptions(title = "请求中..."))
                    data.task = uni_request<ArrayBuffer>(RequestOptions(url = data.host + data.url, method = data.method, data = data.data, header = data.header, timeout = 60000, sslVerify = false, withCredentials = false, responseType = "arraybuffer", firstIpv4 = false, success = fun(res){
                        if (res.data != null) {
                            var uint8 = Uint8Array(res.data as ArrayBuffer)
                            console.log("request success", uint8.toString())
                            data.res = "请求结果 : " + uint8.toString()
                            console.log("request success header is :", JSON.stringify(res.header))
                            uni_showToast(ShowToastOptions(title = "请求成功", icon = "success", mask = true, duration = duration))
                        } else {
                            uni_showModal(ShowModalOptions(content = "error", showCancel = false))
                        }
                    }, fail = fun(err){
                        console.log("request fail", err)
                        uni_showModal(ShowModalOptions(content = err.errMsg, showCancel = false))
                    }, complete = fun(_){
                        uni_hideLoading(null)
                        data.task = null
                    }))
                } else {
                    uni_chooseImage(ChooseImageOptions(count = 1, albumMode = "system", sizeType = _uA(
                        "original"
                    ), sourceType = _uA(
                        "album"
                    ), success = fun(e){
                        console.log(e.tempFilePaths[0])
                        uni_getFileSystemManager().readFile(ReadFileOptions(filePath = e.tempFilePaths[0], success = fun(res){
                            data.data = res.data as ArrayBuffer
                            data.header = _uO("Content-Type" to "application/octet-stream")
                            uni_showLoading(ShowLoadingOptions(title = "请求中..."))
                            data.task = uni_request<ArrayBuffer>(RequestOptions(url = data.host + data.url, method = data.method, data = data.data, header = data.header, timeout = 60000, sslVerify = false, withCredentials = false, firstIpv4 = false, responseType = "arraybuffer", success = fun(res){
                                console.log()
                                if (res.data != null) {
                                    uni_showToast(ShowToastOptions(title = "请求成功", icon = "success", mask = true, duration = duration))
                                    data.res = "请求结果 : byteLength=" + (res.data as ArrayBuffer).byteLength
                                    console.log("request success header is :", JSON.stringify(res.header))
                                } else {
                                    uni_showModal(ShowModalOptions(content = "error", showCancel = false))
                                }
                            }
                            , fail = fun(err){
                                console.log("request fail", err)
                                uni_showModal(ShowModalOptions(content = err.errMsg, showCancel = false))
                            }
                            , complete = fun(_){
                                uni_hideLoading(null)
                                data.task = null
                            }
                            ))
                        }
                        ))
                    }
                    ))
                }
            }
            val sendRequest = fun(){
                uni_showLoading(ShowLoadingOptions(title = "请求中..."))
                data.task = uni_request<Any>(RequestOptions(url = data.host + data.url, method = data.method, data = data.data, header = data.header, timeout = 6000, sslVerify = false, withCredentials = false, firstIpv4 = false, success = fun(res){
                    console.log("request success", JSON.stringify(res.data))
                    console.log("request success header is :", JSON.stringify(res.header))
                    uni_showToast(ShowToastOptions(title = "请求成功", icon = "success", mask = true, duration = duration))
                    data.res = "请求结果 : " + JSON.stringify(res)
                }
                , fail = fun(err){
                    console.log("request fail", err)
                    uni_showModal(ShowModalOptions(content = err.errMsg, showCancel = false))
                }
                , complete = fun(_){
                    uni_hideLoading(null)
                    data.task = null
                }
                ))
            }
            val jest_request = fun(){
                uni_request<Any>(RequestOptions(url = data.host + data.url, method = data.method, data = data.data, header = data.header, timeout = 6000, sslVerify = false, withCredentials = false, firstIpv4 = false, success = fun(_){
                    data.jest_result = true
                }
                , fail = fun(_){
                    data.jest_result = false
                }
                ))
            }
            val jest_cookie_request = fun(needCookie: Boolean){
                uni_request<Any>(RequestOptions(url = data.host + "/api/http/header/requestCookie", method = "GET", timeout = 6000, sslVerify = false, withCredentials = false, firstIpv4 = false, success = fun(res){
                    val requestCookie = (res.data as UTSJSONObject).getJSON("data")?.getAny("requestCookie")
                    data.jest_result_data = JSON.stringify(requestCookie)
                    if (requestCookie is UTSArray<*>) {
                        data.jest_result = if (needCookie) {
                            (requestCookie as UTSArray<Any>).length > 0
                        } else {
                            (requestCookie as UTSArray<Any>).length == 0
                        }
                    } else {
                        data.jest_result = if (needCookie) {
                            (requestCookie as UTSJSONObject).toMap().size > 0
                        } else {
                            (requestCookie as UTSJSONObject).toMap().size == 0
                        }
                    }
                }
                , fail = fun(_){
                    data.jest_result = false
                }
                ))
            }
            val jest_set_cookie = fun(){
                uni_request<Any>(RequestOptions(url = data.host + "/api/http/header/setCookie", method = "GET", timeout = 6000, sslVerify = false, withCredentials = false, firstIpv4 = false, success = fun(_){
                    jest_cookie_request(true)
                }
                , fail = fun(_){
                    data.jest_result = false
                }
                ))
            }
            val jest_set_cookie_expires = fun(){
                uni_request<Any>(RequestOptions(url = data.host + "/api/http/header/setCookie?expires=5", method = "GET", timeout = 6000, sslVerify = false, withCredentials = false, firstIpv4 = false, success = fun(_){
                    jest_cookie_request(true)
                }
                , fail = fun(_){
                    data.jest_result = false
                }
                ))
            }
            val jest_delete_cookie = fun(){
                uni_request<Any>(RequestOptions(url = data.host + "/api/http/header/deleteCookie", method = "GET", timeout = 6000, sslVerify = false, withCredentials = false, firstIpv4 = false, success = fun(_){
                    jest_cookie_request(false)
                }
                , fail = fun(_){
                    data.jest_result = false
                }
                ))
            }
            val jest_timeout_null = fun(){
                uni_request<Any>(RequestOptions(url = data.host + (methodMap["GET"] as String), method = "GET", timeout = null, sslVerify = false, withCredentials = false, firstIpv4 = false, success = fun(_){
                    data.jest_result = true
                }
                , fail = fun(_){
                    data.jest_result = false
                }
                ))
            }
            val jest_get_with_data = fun(){
                uni_request<Any>(RequestOptions(url = "https://unidemo.dcloud.net.cn/api/banner/36kr", method = "GET", data = _uO("column" to "id,post_id,title,author_name,cover,published_at"), timeout = 6000, sslVerify = false, withCredentials = false, firstIpv4 = false, success = fun(_){
                    data.jest_result = true
                }
                , fail = fun(_){
                    data.jest_result = false
                }
                ))
            }
            val jest_get_with_generics = fun(){
                uni_request<GETDataType>(RequestOptions(url = data.host + (methodMap["GET"] as String), method = "GET", timeout = null, sslVerify = false, withCredentials = false, firstIpv4 = false, success = fun(res: RequestSuccess<GETDataType>){
                    data.jest_result = true
                }
                , fail = fun(_){
                    data.jest_result = false
                }
                ))
            }
            val jest_get_array = fun(){
                uni_request<UTSArray<UTSJSONObject>>(RequestOptions(url = "https://unidemo.dcloud.net.cn/api/news?column=title,author_name,cover,published_at", method = "GET", success = fun(res: RequestSuccess<UTSArray<UTSJSONObject>>){
                    if (res.statusCode == 200 && UTSArray.isArray(res.data)) {
                        data.jest_result = true
                    } else {
                        data.jest_result = false
                    }
                }
                , fail = fun(_){
                    data.jest_result = false
                }
                ))
            }
            val jest_uts_module_invoked = fun(){
                data.jest_result = false
                testInovkeRequest(CommonOptions(success = fun(res: Any){
                    data.jest_result = true
                }
                , fail = fun(err: Any){
                    data.jest_result = false
                }
                ))
            }
            val jest_respone_json_string = fun(){
                uni_request<Any>(RequestOptions(url = "https://request.dcloud.net.cn/api/http/contentType/text/json", success = fun(res: RequestSuccess<Any>){
                    data.jest_result = UTSAndroid.`typeof`(res.data) == "object"
                }
                , fail = fun(e: RequestFail){
                    data.jest_result = false
                }
                ))
            }
            val jest_respone_with_string_generics = fun(){
                uni_request<String>(RequestOptions(url = data.host + (methodMap["GET"] as String), method = "GET", timeout = null, sslVerify = false, withCredentials = false, firstIpv4 = false, success = fun(res: RequestSuccess<String>){
                    data.jest_result = true
                }
                , fail = fun(_){
                    data.jest_result = false
                }
                ))
            }
            val jest_respone_with_404_and_string_generics = fun(){
                uni_request<String>(RequestOptions(url = data.host + "/api/http/statusCode/404", method = "GET", timeout = null, sslVerify = false, withCredentials = false, firstIpv4 = false, success = fun(res: RequestSuccess<String>){
                    data.jest_result = true
                }
                , fail = fun(_){
                    data.jest_result = false
                }
                ))
            }
            val jest_issue_19687 = fun(){
                uni_request<Any>(RequestOptions(url = data.host + "/api/http/statusCode/404", method = "GET", success = fun(res){
                    data.jest_result = UTSAndroid.`typeof`(res.data) === "string"
                }
                , fail = fun(_){
                    data.jest_result = false
                }
                ))
            }
            val jest_test_issue21823_crash = fun(){
                uni_request<String>(RequestOptions(url = "http://www.kld20s.cn:88/Appfile/App/Tcrysta/kld/TcnAppUpgrade.json", method = "GET", timeout = null, complete = fun(_){
                    data.jest_complete = true
                }
                ))
            }
            __expose(_uM("data" to data, "sendArrayBuffer" to sendArrayBuffer, "jest_request" to jest_request, "jest_set_cookie" to jest_set_cookie, "jest_set_cookie_expires" to jest_set_cookie_expires, "jest_delete_cookie" to jest_delete_cookie, "jest_cookie_request" to jest_cookie_request, "jest_timeout_null" to jest_timeout_null, "jest_get_with_data" to jest_get_with_data, "jest_get_with_generics" to jest_get_with_generics, "jest_get_array" to jest_get_array, "jest_uts_module_invoked" to jest_uts_module_invoked, "jest_respone_json_string" to jest_respone_json_string, "jest_respone_with_string_generics" to jest_respone_with_string_generics, "jest_respone_with_404_and_string_generics" to jest_respone_with_404_and_string_generics, "jest_issue_19687" to jest_issue_19687, "jest_test_issue21823_crash" to jest_test_issue21823_crash, "sendGzipRequest" to sendGzipRequest, "checkQuery" to checkQuery))
            return fun(): Any? {
                val _component_page_intro = resolveEasyComponent("page-intro", GenComponentsPageIntroPageIntroClass)
                return _cE("view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cV(_component_page_intro, _uM("content" to "本页演示 uni.request：设置请求方式（GET/POST/PUT 等）、请求地址与参数，发起请求后在上方查看返回内容；可切换错误码接口、不同 header、超时等，并展示请求任务与拦截器用法。")),
                    _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt"), _uA(
                        _cE("view", _uM("class" to "uni-common-mt", "style" to _nS(_uM("border-width" to "2px", "border-style" to "solid", "border-radius" to "4px"))), _uA(
                            _cE("textarea", _uM("value" to unref(data).res, "class" to "uni-textarea", "style" to _nS(_uM("width" to "100%"))), null, 12, _uA(
                                "value"
                            ))
                        ), 4),
                        _cE("view", null, _uA(
                            _cE("text", null, "地址 : " + _tD(unref(data).host + unref(data).url), 1),
                            _cE("text", null, "请求方式 : " + _tD(unref(data).method), 1)
                        )),
                        _cE("view", _uM("class" to "uni-btn-v uni-common-mt"), _uA(
                            _cE("button", _uM("type" to "primary", "onClick" to sendRequest), "发起请求")
                        ))
                    )),
                    _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1")), "show-scrollbar" to "true"), _uA(
                        _cE("view", _uM("style" to _nS(_uM("padding" to "20px"))), _uA(
                            _cE("text", null, "设置请求方式"),
                            _cE("view", _uM("class" to "uni-common-pb")),
                            _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row", "flex-wrap" to "wrap"))), _uA(
                                _cE("button", _uM("style" to _nS(_uM("padding" to "5px", "margin-right" to "10px")), "type" to "primary", "size" to "mini", "onClick" to fun(){
                                    changeMethod("GET")
                                }
                                ), "GET", 12, _uA(
                                    "onClick"
                                )),
                                _cE("button", _uM("style" to _nS(_uM("padding" to "5px", "margin-right" to "10px")), "type" to "primary", "size" to "mini", "onClick" to fun(){
                                    changeMethod("POST")
                                }
                                ), "POST", 12, _uA(
                                    "onClick"
                                )),
                                _cE("button", _uM("style" to _nS(_uM("padding" to "5px", "margin-right" to "10px")), "type" to "primary", "size" to "mini", "onClick" to fun(){
                                    changeMethod("PUT")
                                }
                                ), "PUT", 12, _uA(
                                    "onClick"
                                )),
                                _cE("button", _uM("style" to _nS(_uM("padding" to "5px", "margin-right" to "10px")), "type" to "primary", "size" to "mini", "onClick" to fun(){
                                    changeMethod("DELETE")
                                }
                                ), "DELETE", 12, _uA(
                                    "onClick"
                                )),
                                _cE("button", _uM("style" to _nS(_uM("padding" to "5px", "margin-right" to "10px")), "type" to "primary", "size" to "mini", "onClick" to fun(){
                                    changeMethod("PATCH")
                                }
                                ), "PATCH", 12, _uA(
                                    "onClick"
                                )),
                                _cE("button", _uM("style" to _nS(_uM("padding" to "5px", "margin-right" to "10px")), "type" to "primary", "size" to "mini", "onClick" to fun(){
                                    changeMethod("OPTIONS")
                                }
                                ), "OPTIONS", 12, _uA(
                                    "onClick"
                                )),
                                _cE("button", _uM("style" to _nS(_uM("padding" to "5px")), "type" to "primary", "size" to "mini", "onClick" to fun(){
                                    changeMethod("HEAD")
                                }
                                ), "HEAD", 12, _uA(
                                    "onClick"
                                ))
                            ), 4)
                        ), 4),
                        _cE("view", _uM("style" to _nS(_uM("padding" to "20px"))), _uA(
                            _cE("text", null, "请求返回错误码的接口（默认为GET）"),
                            _cE("view", _uM("class" to "uni-common-pb")),
                            _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row", "flex-wrap" to "wrap"))), _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(unref(data).errorCodeUrls, fun(item, index, __index, _cached): Any {
                                    return _cE("button", _uM("style" to _nS(_uM("padding" to "5px")), "type" to "primary", "size" to "mini", "key" to index, "onClick" to fun(){
                                        changeUrl(item)
                                    }
                                    ), _tD(item), 13, _uA(
                                        "onClick"
                                    ))
                                }
                                ), 128)
                            ), 4)
                        ), 4),
                        _cE("view", _uM("style" to _nS(_uM("padding" to "20px"))), _uA(
                            _cE("text", null, "请求不同header的接口（默认为GET）"),
                            _cE("view", _uM("class" to "uni-common-pb")),
                            _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row", "flex-wrap" to "wrap"))), _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(unref(data).headerUrls, fun(item, index, __index, _cached): Any {
                                    return _cE("button", _uM("style" to _nS(_uM("padding" to "5px")), "type" to "primary", "size" to "mini", "key" to index, "onClick" to fun(){
                                        changeUrl(item)
                                    }
                                    ), _tD(item), 13, _uA(
                                        "onClick"
                                    ))
                                }
                                ), 128)
                            ), 4)
                        ), 4),
                        _cE("view", _uM("style" to _nS(_uM("padding" to "20px"))), _uA(
                            _cE("text", null, "请求不同content-type的接口（默认为GET）"),
                            _cE("view", _uM("class" to "uni-common-pb")),
                            _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row", "flex-wrap" to "wrap"))), _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(unref(data).contentTypeUrls, fun(item, index, __index, _cached): Any {
                                    return _cE("button", _uM("style" to _nS(_uM("padding" to "5px")), "type" to "primary", "size" to "mini", "key" to index, "onClick" to fun(){
                                        changeUrl(item)
                                    }
                                    ), _tD(item), 13, _uA(
                                        "onClick"
                                    ))
                                }
                                ), 128)
                            ), 4)
                        ), 4),
                        _cE("view", _uM("style" to _nS(_uM("padding" to "20px"))), _uA(
                            _cE("text", null, "POST请求(有body)"),
                            _cE("view", _uM("class" to "uni-common-pb")),
                            _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row", "flex-wrap" to "wrap"))), _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(unref(data).postUrls, fun(item, index, __index, _cached): Any {
                                    return _cE("button", _uM("style" to _nS(_uM("padding" to "5px")), "type" to "primary", "size" to "mini", "key" to index, "onClick" to fun(){
                                        changeUrlFromPost(item)
                                    }
                                    ), _tD(item), 13, _uA(
                                        "onClick"
                                    ))
                                }
                                ), 128)
                            ), 4)
                        ), 4),
                        _cE("view", _uM("style" to _nS(_uM("padding" to "20px"))), _uA(
                            _cE("text", null, "ArrayBuffer 测试"),
                            _cE("view", _uM("class" to "uni-common-pb")),
                            _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row", "flex-wrap" to "wrap"))), _uA(
                                _cE("button", _uM("style" to _nS(_uM("padding" to "5px")), "type" to "primary", "size" to "mini", "onClick" to fun(){
                                    sendArrayBuffer(false)
                                }
                                ), "请求body为ArrayBuffer，response也为ArrayBuffer", 12, _uA(
                                    "onClick"
                                )),
                                _cE("button", _uM("style" to _nS(_uM("padding" to "5px")), "type" to "primary", "size" to "mini", "onClick" to fun(){
                                    sendArrayBuffer(true)
                                }
                                ), "请求response为ArrayBuffer", 12, _uA(
                                    "onClick"
                                ))
                            ), 4)
                        ), 4),
                        _cE("view", _uM("style" to _nS(_uM("padding" to "20px"))), _uA(
                            _cE("text", null, "RequestTask 测试"),
                            _cE("view", _uM("class" to "uni-common-pb")),
                            _cE("button", _uM("type" to "primary", "onClick" to sendChunkRequest), "流式请求")
                        ), 4),
                        _cE("view", _uM("style" to _nS(_uM("padding" to "20px"))), _uA(
                            _cE("text", null, "enableQuic 测试"),
                            _cE("view", _uM("class" to "uni-common-pb")),
                            _cE("button", _uM("type" to "primary", "onClick" to sendH3Request), "http3请求")
                        ), 4),
                        _cE("view", _uM("style" to _nS(_uM("padding" to "20px"))), _uA(
                            _cE("text", null, "Accept-Encoding:'gzip'测试"),
                            _cE("view", _uM("class" to "uni-common-pb")),
                            _cE("button", _uM("type" to "primary", "onClick" to sendGzipRequest), "Accept-Encoding:'gzip'请求")
                        ), 4),
                        _cE("view", _uM("style" to _nS(_uM("padding" to "20px"))), _uA(
                            _cE("text", null, "检测query"),
                            _cE("view", _uM("class" to "uni-common-pb")),
                            _cE("button", _uM("type" to "primary", "onClick" to checkQuery), "检测query")
                        ), 4),
                        _cE("view", _uM("class" to "uni-common-pb")),
                        _cE("view", _uM("class" to "uni-common-pb"))
                    ), 4)
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
                return _uM("uni-textarea" to _pS(_uM("paddingTop" to 9, "paddingRight" to 9, "paddingBottom" to 9, "paddingLeft" to 9, "fontSize" to 14)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
