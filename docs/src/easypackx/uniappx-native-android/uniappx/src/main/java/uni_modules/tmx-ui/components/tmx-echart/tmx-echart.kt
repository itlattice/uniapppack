@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNI2971F61
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
import uts.sdk.modules.iboxsChooseMedia.MediaScanner
import io.dcloud.uniapp.extapi.`$off` as uni__off
import io.dcloud.uniapp.extapi.`$on` as uni__on
import io.dcloud.uniapp.extapi.createSelectorQuery as uni_createSelectorQuery
import io.dcloud.uniapp.extapi.createWebviewContext as uni_createWebviewContext
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenUniModulesTmxUiComponentsTmxEchartTmxEchart : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var width: String by `$props`
    open var height: String by `$props`
    open var opts: String by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    open var setOptions: (opts: Any) -> Unit
        get() {
            return unref(this.`$exposed`["setOptions"]) as (opts: Any) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setOptions", value)
        }
    open var getImg: () -> Unit
        get() {
            return unref(this.`$exposed`["getImg"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "getImg", value)
        }
    open var eventJsCall: (callfun: String, str: String) -> Unit
        get() {
            return unref(this.`$exposed`["eventJsCall"]) as (callfun: String, str: String) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "eventJsCall", value)
        }
    open var cahrtActions: (kFun: String, opts: String, evt: eventsType?) -> Unit
        get() {
            return unref(this.`$exposed`["cahrtActions"]) as (kFun: String, opts: String, evt: eventsType?) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "cahrtActions", value)
        }
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesTmxUiComponentsTmxEchartTmxEchart, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesTmxUiComponentsTmxEchartTmxEchart
            val _cache = __ins.renderCache
            val proxy = getCurrentInstance()?.proxy ?: null
            val props = __props
            fun emits(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val id = ref<String>("xEchart-" + getUid())
            val webviewContext = ref<WebviewContext?>(null)
            val isLoaded = ref<Boolean>(false)
            val boxWidth = ref<Number>(10)
            val boxHeight = ref<Number>(10)
            val tid = ref<Number>(0)
            val tid2 = ref<Number>(0)
            val realLoaded = ref<Boolean>(false)
            val dipcatchEvents = ref<Map<String, eventsType>>(Map())
            val _width = computed(fun(): String {
                return checkIsCssUnit(props.width, xConfig.unit)
            }
            )
            val _height = computed(fun(): String {
                return checkIsCssUnit(props.height, xConfig.unit)
            }
            )
            val _options = computed(fun(): String {
                return props.opts
            }
            )
            fun gen_cahrtActions_fn(kFun: String, opts: String, evt: eventsType?) {
                var filterevents = _uA(
                    "click"
                )
                var eventsid = ("x-" + getUid()) as String
                if (evt != null && filterevents.includes(kFun)) {
                    dipcatchEvents.value.set(eventsid, evt!!)
                }
                var wb = webviewContext.value!!
                wb.evalJS("chart_call('" + kFun + "','" + opts + "','" + eventsid + "')")
            }
            val cahrtActions = ::gen_cahrtActions_fn
            fun gen_eventJsCall_fn(callfun: String, str: String) {
                var wb = webviewContext.value!!
                wb.evalJS("" + callfun + "(" + str + ")")
            }
            val eventJsCall = ::gen_eventJsCall_fn
            fun gen_drawer_fn() {
                if (!realLoaded.value) {
                    uni_showToast(ShowToastOptions(title = "未初始化完成", icon = "none"))
                    return
                }
                eventJsCall("chart_setOption", "'" + _options.value + "'")
            }
            val drawer = ::gen_drawer_fn
            fun gen_onResizeChart_fn() {
                if (realLoaded.value) {
                    cahrtActions("resize", "", null)
                }
            }
            val onResizeChart = ::gen_onResizeChart_fn
            fun gen_getNodeInfo_fn() {
                uni_createSelectorQuery().`in`(proxy as Any).select(".xEchart").boundingClientRect().exec(fun(ret){
                    var nodeinfo = ret[0] as NodeInfo
                    boxWidth.value = nodeinfo.width!!
                    boxHeight.value = nodeinfo.height!!
                    if (webviewContext.value != null) {
                        return
                    }
                    isLoaded.value = true
                    tid.value = setTimeout(fun() {
                        webviewContext.value = uni_createWebviewContext(id.value, proxy)
                    }
                    , 50)
                }
                )
            }
            val getNodeInfo = ::gen_getNodeInfo_fn
            fun gen_onAddlisentMesage_fn() {}
            val onAddlisentMesage = ::gen_onAddlisentMesage_fn
            fun gen_onMessage_fn(event: WebViewMessageEvent) {
                var msgdatas = event.detail.data
                if (msgdatas.length > 0) {
                    var msg = msgdatas[0]!! as UTSJSONObject
                    var ac = msg!!.getString("action") as String
                    if (ac == "img") {
                        var imgbase64 = msg!!.getString("url") as String
                        console.log(imgbase64)
                    } else if (ac == "onJSBridgeReady") {} else if (ac == "click") {
                        var eventId = msg!!.getString("eventId") as String
                        var filterEvents = dipcatchEvents.value.get(eventId)
                        if (filterEvents != null) {
                            var handler = filterEvents!! as eventsType
                            var datas = msg!!.getString("data")
                            if (datas == null || datas == "") {
                                handler(_uO())
                            } else {
                                var eventData = JSON.parse(datas!!)!! as UTSJSONObject
                                handler(eventData)
                            }
                        }
                    }
                }
            }
            val onMessage = ::gen_onMessage_fn
            fun gen_setOptions_fn(opts: Any) {
                if (!realLoaded.value) {
                    uni_showToast(ShowToastOptions(title = "未初始化完成", icon = "none"))
                    return
                }
                var str: String = ""
                str = optsJsonToStr(opts as Any)
                eventJsCall("chart_setOption", "'" + str + "'")
            }
            val setOptions = ::gen_setOptions_fn
            fun gen_getImg_fn() {
                eventJsCall("EchartImg", "")
            }
            val getImg = ::gen_getImg_fn
            fun gen_appWebViewLoaded_fn() {
                realLoaded.value = true
                drawer()
                emits("init", null)
            }
            val appWebViewLoaded = ::gen_appWebViewLoaded_fn
            watch(fun(): String {
                return props.opts
            }
            , fun(){
                drawer()
            }
            )
            onMounted(fun(){
                getNodeInfo()
                onAddlisentMesage()
                uni__on("onResize", onResizeChart)
            }
            )
            onBeforeUnmount(fun(){
                clearTimeout(tid.value)
                uni__off("onResize", onResizeChart)
            }
            )
            __expose(_uM("setOptions" to setOptions, "getImg" to getImg, "eventJsCall" to eventJsCall, "cahrtActions" to cahrtActions))
            return fun(): Any? {
                val _component_tmx_icon = resolveEasyComponent("tmx-icon", GenUniModulesTmxUiComponentsTmxIconTmxIconClass)
                val _component_web_view = resolveComponent("web-view")
                return _cE("view", _uM("class" to "xEchart", "style" to _nS(_uM("width" to _width.value, "height" to _height.value))), _uA(
                    if (isTrue(!isLoaded.value)) {
                        _cE("view", _uM("key" to 0, "style" to _nS(_uM("width" to "100%", "height" to "100%", "display" to "flex", "justify-content" to "center", "align-items" to "center", "flex-direction" to "row"))), _uA(
                            _cV(_component_tmx_icon, _uM("color" to "primary", "spin" to true, "name" to "loader-4-line"))
                        ), 4)
                    } else {
                        _cV(_component_web_view, _uM("key" to 1, "onLoad" to appWebViewLoaded, "id" to id.value, "src" to ("/hybrid/html/local.html?id=" + id.value), "style" to _nS(_uM("width" to "100%", "height" to "100%", "opacity" to if (isLoaded.value) {
                            1
                        } else {
                            0
                        }
                        )), "onMessage" to onMessage), null, 8, _uA(
                            "id",
                            "src",
                            "style"
                        ))
                    }
                ), 4)
            }
        }
        var name = "xEchart"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("init" to null)
        var props = _nP(_uM("width" to _uM("type" to "String", "required" to true, "default" to "auto"), "height" to _uM("type" to "String", "required" to true, "default" to "250px"), "opts" to _uM("type" to "String", "required" to true, "default" to "")))
        var propsNeedCastKeys = _uA(
            "width",
            "height",
            "opts"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
