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
open class GenPagesComponentScrollViewScrollViewRefresher : BasePage {
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
    open var data: DataType__3
        get() {
            return unref(this.`$exposed`["data"]) as DataType__3
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var setPageStyle: (pageStyle: UTSJSONObject) -> Unit
        get() {
            return unref(this.`$exposed`["setPageStyle"]) as (pageStyle: UTSJSONObject) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setPageStyle", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentScrollViewScrollViewRefresher, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentScrollViewScrollViewRefresher
            val _cache = __ins.renderCache
            val scrollData = ref(_uA<String>())
            val refresherrefresh = ref(false)
            val data = reactive(DataType__3(refresherTriggered = false, refresherrefreshTimes = 0, showScrollbar = false, refresherrefreshTest = "", onRefresherabortTest = "", onRefresherrestoreTest = "", onRefresherpullingTest = ""))
            fun gen_checkEventTest_fn(e: RefresherEventTest, eventName: String) {
                val isPass = e.type === eventName && e.target is UniElement && e.currentTarget is UniElement && e.dy > 0
                val result = if (isPass) {
                    "" + eventName + ":Success"
                } else {
                    "" + eventName + ":Fail"
                }
                when (eventName) {
                    "refresherrefresh" -> 
                        data.refresherrefreshTest = result
                    "refresherpulling" -> 
                        data.onRefresherpullingTest = result
                    "refresherrestore" -> 
                        data.onRefresherrestoreTest = result
                    "refresherabort" -> 
                        data.onRefresherabortTest = result
                    else -> 
                        {}
                }
            }
            val checkEventTest = ::gen_checkEventTest_fn
            fun gen_onRefresherrefresh_fn(e: UniRefresherEvent) {
                refresherrefresh.value = true
                console.log("onRefresherrefresh------下拉刷新触发")
                checkEventTest(RefresherEventTest(type = e.type, target = e.target, currentTarget = e.currentTarget, dy = e.detail.dy), "refresherrefresh")
                data.refresherTriggered = true
                data.refresherrefreshTimes++
                setTimeout(fun(){
                    data.refresherTriggered = false
                }
                , 1500)
            }
            val onRefresherrefresh = ::gen_onRefresherrefresh_fn
            fun gen_onRefresherabort_fn(e: UniRefresherEvent) {
                console.log("onRefresherabort------下拉刷新被中止")
                checkEventTest(RefresherEventTest(type = e.type, target = e.target, currentTarget = e.currentTarget, dy = e.detail.dy), "refresherabort")
            }
            val onRefresherabort = ::gen_onRefresherabort_fn
            fun gen_onRefresherrestore_fn(e: UniRefresherEvent) {
                refresherrefresh.value = false
                console.log("onRefresherrestore------下拉刷新被复位")
                checkEventTest(RefresherEventTest(type = e.type, target = e.target, currentTarget = e.currentTarget, dy = e.detail.dy), "refresherrestore")
            }
            val onRefresherrestore = ::gen_onRefresherrestore_fn
            fun gen_onRefresherpulling_fn(e: UniRefresherEvent) {
                console.log("onRefresherpulling------下拉刷新控件被下拉-dy=" + e.detail.dy)
                checkEventTest(RefresherEventTest(type = e.type, target = e.target, currentTarget = e.currentTarget, dy = e.detail.dy), "refresherpulling")
            }
            val onRefresherpulling = ::gen_onRefresherpulling_fn
            fun gen_onScrolltolower_fn(e: UniScrollToLowerEvent) {
                console.log("onScrolltolower 滚动到底部-----" + e.detail.direction)
            }
            val onScrolltolower = ::gen_onScrolltolower_fn
            fun gen_setPageStyle_fn(pageStyle: UTSJSONObject) {
                val pages = getCurrentPages()
                val currentPage = pages[pages.length - 1]
                currentPage.setPageStyle(pageStyle)
            }
            val setPageStyle = ::gen_setPageStyle_fn
            onLoad(fun(_options){
                var lists: UTSArray<String> = _uA()
                run {
                    var i: Number = 0
                    while(i < 20){
                        lists.push("item---" + i)
                        i++
                    }
                }
                scrollData.value = lists
            }
            )
            __expose(_uM("data" to data, "setPageStyle" to setPageStyle))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE("view", _uM("class" to "container"), _uA(
                    _cV(_component_page_head, _uM("title" to "scroll-view 默认下拉刷新")),
                    _cE("scroll-view", _uM("class" to "scroll", "refresher-enabled" to "true", "refresher-triggered" to unref(data).refresherTriggered, "onRefresherrefresh" to onRefresherrefresh, "onRefresherabort" to onRefresherabort, "onRefresherrestore" to onRefresherrestore, "onRefresherpulling" to onRefresherpulling, "onScrolltolower" to onScrolltolower, "show-scrollbar" to unref(data).showScrollbar), _uA(
                        _cE(Fragment, null, RenderHelpers.renderList(unref(scrollData), fun(key, __key, __index, _cached): Any {
                            return _cE("view", _uM("key" to key), _uA(
                                _cE("view", _uM("class" to "scroll-item"), _uA(
                                    _cE("text", _uM("class" to "scroll-item-title"), _tD(key), 1)
                                ))
                            ))
                        }
                        ), 128)
                    ), 40, _uA(
                        "refresher-triggered",
                        "show-scrollbar"
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
                return _uM("container" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "scroll" to _pS(_uM("backgroundColor" to "#eeeeee", "width" to "100%", "flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "scroll-item" to _pS(_uM("marginLeft" to 6, "marginRight" to 6, "marginTop" to 6, "backgroundColor" to "#ffffff")), "scroll-item-title" to _pS(_uM("width" to "100%", "height" to 60, "lineHeight" to "60px", "textAlign" to "center", "color" to "#555555")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
