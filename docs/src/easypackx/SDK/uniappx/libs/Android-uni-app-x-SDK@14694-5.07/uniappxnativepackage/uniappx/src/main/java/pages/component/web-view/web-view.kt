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
import uts.sdk.modules.utsGetNativeView.canWebViewGoBack
import uts.sdk.modules.utsGetNativeView.canWebViewGoForward
import uts.sdk.modules.utsGetNativeView.hasNativeView
import io.dcloud.uniapp.extapi.getElementById as uni_getElementById
import io.dcloud.uniapp.extapi.showModal as uni_showModal
open class GenPagesComponentWebViewWebView : BasePage {
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
    open var data: DataType__34
        get() {
            return unref(this.`$exposed`["data"]) as DataType__34
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var reload: () -> Unit
        get() {
            return unref(this.`$exposed`["reload"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "reload", value)
        }
    open var checkNativeWebView: () -> Boolean
        get() {
            return unref(this.`$exposed`["checkNativeWebView"]) as () -> Boolean
        }
        set(value) {
            setRefValue(this.`$exposed`, "checkNativeWebView", value)
        }
    open var checkLoadingCount: () -> Unit
        get() {
            return unref(this.`$exposed`["checkLoadingCount"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "checkLoadingCount", value)
        }
    open var getContentHeight: () -> Number
        get() {
            return unref(this.`$exposed`["getContentHeight"]) as () -> Number
        }
        set(value) {
            setRefValue(this.`$exposed`, "getContentHeight", value)
        }
    open var loadData: () -> Unit
        get() {
            return unref(this.`$exposed`["loadData"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "loadData", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentWebViewWebView, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentWebViewWebView
            val _cache = __ins.renderCache
            val data = reactive(DataType__34(src = "https://www.dcloud.io", webview_progress_color = "#FF3333", halfWindowMode = false, webviewContext = null as WebviewContext?, loadError = false, horizontalScrollBarAccess = true, verticalScrollBarAccess = true, bounces = true, disableUserSelectMenu = false, canGoBack = false, canGoForward = false, autoTest = false, eventLoading = null as UTSJSONObject?, eventLoad = null as UTSJSONObject?, eventError = null as UTSJSONObject?, eventContentHeightChange = null as UTSJSONObject?, pointerEvents = "auto", isTouchEnable = false, loadingCount = 0))
            var webviewElement = null as UniWebViewElement?
            val fullScreen = computed(fun(): Boolean {
                return !data.halfWindowMode
            }
            )
            val webViewStyle = computed(fun(): UTSJSONObject {
                return _uO("width" to if (data.halfWindowMode) {
                    "50%"
                } else {
                    "100%"
                }
                , "pointer-events" to data.pointerEvents)
            }
            )
            val setHalfScreen = fun(){
                data.halfWindowMode = !data.halfWindowMode
            }
            val back = fun(){
                webviewElement?.back()
            }
            val forward = fun(){
                webviewElement?.forward()
            }
            val reload = fun(){
                data.loadingCount = 0
                webviewElement?.reload()
            }
            val stop = fun(){
                webviewElement?.stop()
            }
            val nativeToWeb = fun(){
                webviewElement?.evalJS("alert('hello uni-app x')")
            }
            val getContentHeight = fun(): Number {
                val height = webviewElement?.getContentHeight() ?: 0
                console.log("contentHeight", height)
                if (!data.autoTest) {
                    uni_showModal(ShowModalOptions(content = " 当前内容高度: " + height, showCancel = false))
                }
                return height
            }
            val loadData = fun(){
                webviewElement?.loadData(UniWebViewElementLoadDataOptions(data = "<p><a href=\"https://www.dcloud.io/hbuilderx.html\">HBuilderX</a><br/><img src=\"/unidoc/zh/uni@2x.png\"></img><h1>HBuilderX，轻巧、极速，极客编辑器</h1><p style=\"color:red;\"><small>HBuilderX，轻巧、极速，极客编辑器 </small><big>HBuilderX，轻巧、极速，极客编辑器</big><strong>HBuilderX，轻巧、极速，极客编辑器</strong><i>HBuilderX，轻巧、极速，极客编辑器 </i><u>HBuilderX，轻巧、极速，极客编辑器</u><del>HBuilderX，轻巧、极速，极客编辑器</del></p><h2>uni-app x，终极跨平台方案</h2>、<p style=\"background-color: yellow;\"><small>uni-app x，终极跨平台方案 </small><big>uni-app x，终极跨平台方案</big><strong>uni-appx，终极跨平台方案 </strong><i>uni-app x，终极跨平台方案 </i><u>uni-app x，终极跨平台方案 </u><del>uni-appx，终极跨平台方案</del></p><h3>uniCloud，js serverless云服务</h3><p style=\"text-decoration: line-through;\"><small>uniCloud，js serverless云服务 </small><big>uniCloud，jsserverless云服务</big><strong>uniCloud，js serverless云服务 </strong><i>uniCloud，js serverless云服务 </i><u>uniCloud，jsserverless云服务</u><del>uniCloud，js serverless云服务</del></p><h4>uts，大一统语言</h4><p style=\"text-align: center;\"><small>uts，大一统语言 </small><big>uts，大一统语言 </big><strong>uts，大一统语言</strong><i>uts，大一统语言</i><u>uts，大一统语言 </u><del>uts，大一统语言</del></p><h5>uniMPSdk，让你的App具备小程序能力</h5><h6>uni-admin，开源、现成的全端管理后台</h6><ul><li style=\"color: red; text-align: left;\">uni-app x，终极跨平台方案</li><li style=\"color: green; text-align: center;\">uni-app x，终极跨平台方案</li><li style=\"color: blue; text-align: right;\">uni-app x，终极跨平台方案</li></ul><a href=\"https://uniapp.dcloud.net.cn\">uni-app</a><br/><img src=\"/unidoc/zh/uni@2x.png\"></img></p>", baseURL = "https://qiniu-web-assets.dcloud.net.cn"))
            }
            val message = fun(event: UniWebViewMessageEvent){
                console.log(JSON.stringify(event.detail))
            }
            val error = fun(event: UniWebViewErrorEvent){
                data.loadError = true
                console.log(JSON.stringify(event.detail))
                if (data.autoTest) {
                    data.eventError = _uO("tagName" to event.target?.tagName, "type" to event.type, "errCode" to event.detail.errCode, "errMsg" to event.detail.errMsg, "url" to event.detail.url, "fullUrl" to event.detail.fullUrl, "src" to event.detail.src)
                }
            }
            val loading = fun(event: UniWebViewLoadingEvent){
                data.loadingCount++
                if (data.autoTest) {
                    data.eventLoading = _uO("tagName" to event.target?.tagName, "type" to event.type, "src" to event.detail.src)
                }
            }
            val load = fun(event: UniWebViewLoadEvent){
                console.log(JSON.stringify(event.detail))
                data.canGoBack = canWebViewGoBack("web-view")
                data.canGoForward = canWebViewGoForward("web-view")
                if (data.autoTest) {
                    data.eventLoad = _uO("tagName" to event.target?.tagName, "type" to event.type, "src" to event.detail.src, "url" to event.detail.url)
                }
            }
            val download = fun(event: UniWebViewDownloadEvent){
                console.log(JSON.stringify(event.detail))
                uni_showModal(ShowModalOptions(content = "下载链接: " + event.detail.url + "\n文件大小: " + event.detail.contentLength / 1024 + "KB", showCancel = false))
            }
            val contentheightchange = fun(event: UniWebViewContentHeightChangeEvent){
                console.log(JSON.stringify(event.detail))
                data.eventContentHeightChange = _uO("tagName" to event.target?.tagName, "type" to event.type, "isValidHeight" to (event.detail.height > 0))
            }
            val confirm = fun(event: UniInputConfirmEvent){
                var url = event.detail.value
                if (!url.startsWith("https://") && !url.startsWith("http://")) {
                    url = "https://" + url
                }
                data.src = url
            }
            val changeHorizontalScrollBarAccess = fun(event: UniSwitchChangeEvent){
                data.horizontalScrollBarAccess = event.detail.value
            }
            val changeVerticalScrollBarAccess = fun(event: UniSwitchChangeEvent){
                data.verticalScrollBarAccess = event.detail.value
            }
            val changeBounces = fun(event: UniSwitchChangeEvent){
                data.bounces = event.detail.value
            }
            val changeDisableUserSelectMenu = fun(event: UniSwitchChangeEvent){
                data.disableUserSelectMenu = event.detail.value
            }
            val touchstart = fun(event: UniTouchEvent){
                if (data.autoTest) {
                    data.isTouchEnable = event.touches[0].clientX > 0 && event.touches[0].clientY > 0
                }
            }
            val tap = fun(event: UniPointerEvent){
                if (data.autoTest) {
                    data.isTouchEnable = event.clientX > 0 && event.clientY > 0
                }
            }
            val checkNativeWebView = fun(): Boolean {
                return hasNativeView("web-view")
            }
            val checkLoadingCount = fun(){
                data.loadingCount = 0
                webviewElement?.reload()
            }
            onReady(fun(){
                webviewElement = uni_getElementById("web-view") as UniWebViewElement
            }
            )
            onUnload(fun(){
                webviewElement = null
            }
            )
            __expose(_uM("data" to data, "reload" to reload, "checkNativeWebView" to checkNativeWebView, "checkLoadingCount" to checkLoadingCount, "getContentHeight" to getContentHeight, "loadData" to loadData))
            return fun(): Any? {
                val _component_web_view = resolveComponent("web-view")
                val _component_navigator = resolveComponent("navigator")
                val _component_switch = resolveComponent("switch")
                return _cE("view", _uM("class" to "uni-flex-item"), _uA(
                    _cV(_component_web_view, _uM("id" to "web-view", "class" to "uni-flex-item", "style" to _nS(unref(webViewStyle)), "src" to unref(data).src, "webview-styles" to _uO("progress" to _uO("color" to unref(data).webview_progress_color)), "horizontalScrollBarAccess" to unref(data).horizontalScrollBarAccess, "verticalScrollBarAccess" to unref(data).verticalScrollBarAccess, "bounces" to unref(data).bounces, "disable-user-select-menu" to unref(data).disableUserSelectMenu, "onMessage" to message, "onError" to error, "onLoading" to loading, "onLoad" to load, "onDownload" to download, "onContentheightchange" to contentheightchange, "onTouchstart" to touchstart, "onClick" to tap), null, 8, _uA(
                        "style",
                        "src",
                        "webview-styles",
                        "horizontalScrollBarAccess",
                        "verticalScrollBarAccess",
                        "bounces",
                        "disable-user-select-menu"
                    )),
                    _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt"), _uA(
                        _cE("view", _uM("class" to "uni-btn-v"), _uA(
                            _cE("input", _uM("class" to "uni-input", "confirmType" to "go", "placeholder" to "输入网址跳转", "onConfirm" to confirm, "maxlength" to -1), null, 32)
                        )),
                        _cE("view", _uM("class" to "uni-row uni-btn-v"), _uA(
                            _cE("button", _uM("class" to "uni-flex-item", "type" to "primary", "disabled" to !unref(data).canGoBack, "onClick" to back), "后退", 8, _uA(
                                "disabled"
                            )),
                            _cE("button", _uM("class" to "margin-left-5 uni-flex-item", "type" to "primary", "disabled" to !unref(data).canGoForward, "onClick" to forward), "前进", 8, _uA(
                                "disabled"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-row uni-btn-v"), _uA(
                            _cE("button", _uM("class" to "uni-flex-item", "type" to "primary", "onClick" to reload), "重新加载"),
                            _cE("button", _uM("class" to "margin-left-5 uni-flex-item", "type" to "primary", "onClick" to stop), "停止加载")
                        )),
                        _cE("view", _uM("class" to "uni-row uni-btn-v"), _uA(
                            _cE("button", _uM("class" to "uni-flex-item", "type" to "primary", "onClick" to nativeToWeb), "原生和Web通信"),
                            _cE("button", _uM("class" to "margin-left-5 uni-flex-item", "type" to "primary", "onClick" to getContentHeight), "获取内容高度")
                        )),
                        _cE("view", _uM("class" to "uni-row uni-btn-v"), _uA(
                            _cE("button", _uM("class" to "uni-flex-item", "type" to "primary", "onClick" to loadData), "加载页面内容"),
                            _cE("button", _uM("id" to "half-screen-toggle", "class" to "margin-left-5 uni-flex-item", "type" to "primary", "onClick" to setHalfScreen), "宽窄屏切换")
                        )),
                        _cE("view", _uM("class" to "uni-btn-v"), _uA(
                            _cV(_component_navigator, _uM("url" to "/pages/component/web-view/web-view-scroll"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("button", _uM("type" to "primary"), "scroll-view嵌套web-view")
                                )
                            }
                            ), "_" to 1))
                        )),
                        _cE("view", _uM("class" to "uni-row uni-btn-v"), _uA(
                            _cE("view", _uM("class" to "uni-row uni-flex-item align-items-center"), _uA(
                                _cE("text", null, "显示横向滚动条"),
                                _cV(_component_switch, _uM("checked" to true, "onChange" to changeHorizontalScrollBarAccess))
                            )),
                            _cE("view", _uM("class" to "uni-row uni-flex-item align-items-center"), _uA(
                                _cE("text", null, "显示竖向滚动条"),
                                _cV(_component_switch, _uM("checked" to true, "onChange" to changeVerticalScrollBarAccess))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-row uni-btn-v"), _uA(
                            _cE("view", _uM("class" to "uni-row uni-flex-item align-items-center"), _uA(
                                _cE("text", null, "开启bounces"),
                                _cV(_component_switch, _uM("checked" to true, "onChange" to changeBounces)),
                                _cE("text", null, "禁用选择菜单"),
                                _cV(_component_switch, _uM("checked" to false, "onChange" to changeDisableUserSelectMenu))
                            ))
                        ))
                    )),
                    _cE("view", _uM("class" to "safe-area-inset-bottom"))
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
                return _uM("margin-left-5" to _pS(_uM("marginLeft" to 5)), "align-items-center" to _pS(_uM("alignItems" to "center")), "safe-area-inset-bottom" to _pS(_uM("height" to "var(--uni-safe-area-inset-bottom)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
