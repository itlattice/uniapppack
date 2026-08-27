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
import uts.sdk.modules.uniStat.ReportOptions as ReportOptions
import io.dcloud.uniapp.extapi.getLaunchOptionsSync as uni_getLaunchOptionsSync
import uts.sdk.modules.uniStat.report as uni_report
open class GenPagesAPIReportReport : BasePage {
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
    open var msg: MsgType
        get() {
            return unref(this.`$exposed`["msg"]) as MsgType
        }
        set(value) {
            setRefValue(this.`$exposed`, "msg", value)
        }
    open var handleAppLaunch: () -> Unit
        get() {
            return unref(this.`$exposed`["handleAppLaunch"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "handleAppLaunch", value)
        }
    open var handleAppHide: () -> Unit
        get() {
            return unref(this.`$exposed`["handleAppHide"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "handleAppHide", value)
        }
    open var handleAppShow: () -> Unit
        get() {
            return unref(this.`$exposed`["handleAppShow"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "handleAppShow", value)
        }
    open var handleAppError: () -> Unit
        get() {
            return unref(this.`$exposed`["handleAppError"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "handleAppError", value)
        }
    open var handleEvent: () -> Unit
        get() {
            return unref(this.`$exposed`["handleEvent"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "handleEvent", value)
        }
    open var handleTitle: () -> Unit
        get() {
            return unref(this.`$exposed`["handleTitle"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "handleTitle", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIReportReport, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIReportReport
            val _cache = __ins.renderCache
            val msg = reactive(MsgType(value = "点击按钮，测试上报"))
            onLoad(fun(_options){
                uni_report(ReportOptions(name = "自定义上报-report页面打开", options = "1"))
            }
            )
            onUnmounted(fun(){
                uni_report(ReportOptions(name = "自定义上报-report页面关闭", options = "1"))
            }
            )
            val handleAppLaunch = fun(){
                val options = uni_getLaunchOptionsSync()
                uni_report(ReportOptions(name = "uni-app-launch", options = options, success = fun(res){
                    msg.value = "onLaunch --> " + res.errMsg
                    console.log(res)
                }
                , fail = fun(err){
                    msg.value = "onLaunch --> " + err.errMsg
                    console.log(err)
                }
                ))
            }
            val handleAppHide = fun(){
                uni_report(ReportOptions(name = "uni-app-hide", success = fun(res){
                    msg.value = "onAppHide --> " + res.errMsg
                    console.log(res)
                }
                , fail = fun(err){
                    msg.value = "onAppHide --> " + err.errMsg
                    console.log(err)
                }
                ))
            }
            val handleAppShow = fun(){
                uni_report(ReportOptions(name = "uni-app-show", success = fun(res){
                    msg.value = "onAppShow --> " + res.errMsg
                    console.log(res)
                }
                , fail = fun(err){
                    msg.value = "onAppShow --> " + err.errMsg
                    console.log(err)
                }
                ))
            }
            val handleAppError = fun(){
                val errmsg = "测试错误"
                uni_report(ReportOptions(name = "uni-app-error", options = errmsg, success = fun(res){
                    msg.value = "onAppError --> " + res.errMsg
                    console.log(res)
                }
                , fail = fun(err){
                    msg.value = "onAppError --> " + err.errMsg
                    console.log(err)
                }
                ))
            }
            val handleEvent = fun(){
                uni_report(ReportOptions(name = "custom-event", options = _uO("title" to "自定义事件", "total" to 1), success = fun(res){
                    msg.value = "自定义事件 --> " + res.errMsg
                    console.log(res)
                }
                , fail = fun(err){
                    msg.value = "自定义事件 --> " + err.errMsg
                    console.log(err)
                }
                ))
            }
            val handleTitle = fun(){
                uni_report(ReportOptions(name = "title", options = "自定义title测试上报", success = fun(res){
                    msg.value = "自定义title --> " + res.errMsg
                    console.log(res)
                }
                , fail = fun(err){
                    msg.value = "自定义title --> " + err.errMsg
                    console.log(err)
                }
                ))
            }
            __expose(_uM("msg" to msg, "handleAppLaunch" to handleAppLaunch, "handleAppHide" to handleAppHide, "handleAppShow" to handleAppShow, "handleAppError" to handleAppError, "handleEvent" to handleEvent, "handleTitle" to handleTitle))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cV(_component_page_head, _uM("title" to "report")),
                    _cE("view", _uM("class" to "tips"), _uA(
                        _cE("view", _uM("class" to "tips-title"), "调用信息："),
                        _cE("view", _uM("class" to "tips-content"), _tD(unref(msg).value), 1)
                    )),
                    _cE("view", _uM("class" to "page"), _uA(
                        _cE("button", _uM("class" to "normal-button", "type" to "default", "onClick" to handleAppLaunch), " 模拟应用启动 "),
                        _cE("button", _uM("class" to "normal-button", "type" to "default", "onClick" to handleAppHide), " 模拟应用切入后台 "),
                        _cE("button", _uM("class" to "normal-button", "type" to "default", "onClick" to handleAppShow), " 模拟应用切入前台 "),
                        _cE("button", _uM("class" to "normal-button", "type" to "default", "onClick" to handleAppError), " 模拟应用错误 "),
                        _cE("button", _uM("class" to "normal-button", "type" to "default", "onClick" to handleTitle), " 模拟自定义title "),
                        _cE("button", _uM("class" to "normal-button", "type" to "default", "onClick" to handleEvent), " 模拟自定义事件 "),
                        _cE("text", _uM("class" to "instructions"), " 当前页面调用API均为模拟，请查看文档，在特定场景下使用以上 API。请在main.uts中设置统计debug配置为true，并点击按钮查控制台输出。 ")
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
                return _uM("page" to _pS(_uM("paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15)), "tips" to _pS(_uM("marginTop" to 15, "marginRight" to 15, "marginBottom" to 15, "marginLeft" to 15, "paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15, "backgroundColor" to "#f5f5f5", "fontSize" to 14, "textAlign" to "center")), "tips-title" to _pS(_uM("fontSize" to 16, "color" to "#333333", "marginBottom" to 10)), "tips-content" to _pS(_uM("fontSize" to 14, "color" to "#999999")), "normal-button" to _pS(_uM("width" to "100%", "marginBottom" to 10)), "instructions" to _pS(_uM("marginTop" to 10, "marginLeft" to 10, "marginRight" to 10, "backgroundColor" to "#eeeeee", "fontSize" to 12, "color" to "#999999")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
