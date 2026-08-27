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
import io.dcloud.uniapp.extapi.startPullDownRefresh as uni_startPullDownRefresh
import io.dcloud.uniapp.extapi.stopPullDownRefresh as uni_stopPullDownRefresh
open class GenPagesAPIGetCurrentPagesSetPageStyleDisablePullDownRefresh : BasePage {
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
    open var data: DataType__52
        get() {
            return unref(this.`$exposed`["data"]) as DataType__52
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var getPageStyle: () -> Unit
        get() {
            return unref(this.`$exposed`["getPageStyle"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "getPageStyle", value)
        }
    open var setPageStyle: (enable: Boolean) -> Unit
        get() {
            return unref(this.`$exposed`["setPageStyle"]) as (enable: Boolean) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setPageStyle", value)
        }
    open var startPullDownRefresh: () -> Unit
        get() {
            return unref(this.`$exposed`["startPullDownRefresh"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "startPullDownRefresh", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIGetCurrentPagesSetPageStyleDisablePullDownRefresh, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIGetCurrentPagesSetPageStyleDisablePullDownRefresh
            val _cache = __ins.renderCache
            open class Page {
                open var route: String by Delegates.notNull()
                constructor(route: String){
                    this.route = route
                }
            }
            val checked = ref(false)
            val pages = ref(_uA<Page>())
            val data = reactive(DataType__52(currentPageStyle = _uO(), enablePullDownRefreshStatus = true))
            val pageStyleText = computed(fun(): String {
                return JSON.stringify(data.currentPageStyle)
            }
            )
            fun gen_getPageStyle_fn() {
                val pages = getCurrentPages()
                val currentPage = pages[pages.length - 1]
                data.currentPageStyle = currentPage.getPageStyle()
            }
            val getPageStyle = ::gen_getPageStyle_fn
            fun gen_setPageStyle_fn(enable: Boolean) {
                val pages = getCurrentPages()
                val currentPage = pages[pages.length - 1]
                currentPage.setPageStyle(_uO("enablePullDownRefresh" to enable))
                data.enablePullDownRefreshStatus = enable
            }
            val setPageStyle = ::gen_setPageStyle_fn
            fun gen_startPullDownRefresh_fn() {
                uni_startPullDownRefresh(null)
            }
            val startPullDownRefresh = ::gen_startPullDownRefresh_fn
            onLoad(fun(_options){
                val pages = getCurrentPages()
                val currentPage = pages[pages.length - 1]
                data.currentPageStyle = currentPage.getPageStyle()
                data.enablePullDownRefreshStatus = data.currentPageStyle["enablePullDownRefresh"] as Boolean
            }
            )
            __expose(_uM("data" to data, "getPageStyle" to getPageStyle, "setPageStyle" to setPageStyle, "startPullDownRefresh" to startPullDownRefresh))
            onPullDownRefresh(fun(){
                setTimeout(fun(){
                    uni_stopPullDownRefresh()
                }
                , 3000)
            }
            )
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE(Fragment, null, _uA(
                    _cV(_component_page_head, _uM("title" to "getCurrentPages")),
                    _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                        _cE("button", _uM("class" to "btn btn-get-page-style", "type" to "default", "onClick" to getPageStyle), "getPageStyle"),
                        _cE("button", _uM("class" to "btn btn-set-page-style-1", "type" to "default", "onClick" to fun(){
                            setPageStyle(true)
                        }
                        ), "setPageStyle(true)", 8, _uA(
                            "onClick"
                        )),
                        _cE("button", _uM("class" to "btn btn-set-page-style-0", "type" to "default", "onClick" to fun(){
                            setPageStyle(false)
                        }
                        ), "setPageStyle(false)", 8, _uA(
                            "onClick"
                        )),
                        _cE("text", _uM("class" to "page-style"), "当前 PageStyle"),
                        _cE("text", _uM("class" to "page-style-value"), _tD(unref(pageStyleText)), 1),
                        _cE("text", _uM("class" to "status"), "状态："),
                        _cE("view", _uM("class" to "status-list"), _uA(
                            _cE("text", null, "enablePullDownRefresh: " + _tD(unref(data).enablePullDownRefreshStatus), 1)
                        )),
                        _cE("text", _uM("class" to "tips"), "当前版本仅支持设置属性 enablePullDownRefresh")
                    ))
                ), 64)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("btn" to _pS(_uM("marginTop" to 10)), "page-style" to _pS(_uM("marginTop" to 15)), "page-style-value" to _pS(_uM("marginTop" to 5, "paddingTop" to 5, "paddingRight" to 5, "paddingBottom" to 5, "paddingLeft" to 5, "backgroundColor" to "#ffffff", "width" to "100%")), "status" to _pS(_uM("marginTop" to 20)), "status-list" to _pS(_uM("marginTop" to 5)), "tips" to _pS(_uM("fontSize" to 12, "marginTop" to 15, "opacity" to 0.8)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
