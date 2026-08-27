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
import io.dcloud.uniapp.extapi.getElementById as uni_getElementById
open class GenPagesComponentScrollViewScrollViewCustomRefresherProps : BasePage {
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
    open var data: DataType__5
        get() {
            return unref(this.`$exposed`["data"]) as DataType__5
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var getBoundingClientRectForRefreshing: (elementId: String) -> DOMRect
        get() {
            return unref(this.`$exposed`["getBoundingClientRectForRefreshing"]) as (elementId: String) -> DOMRect
        }
        set(value) {
            setRefValue(this.`$exposed`, "getBoundingClientRectForRefreshing", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentScrollViewScrollViewCustomRefresherProps, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentScrollViewScrollViewCustomRefresherProps
            val _cache = __ins.renderCache
            val data = reactive(DataType__5(listCount1 = 3, refreshing1 = false, pullingDistance1 = 0, listCount2 = 3, refreshing2 = false, pullingDistance2 = 0, listCount3 = 3, refreshing3 = false, pullingDistance3 = 0, listCount4 = 3, refreshing4 = false, pullingDistance4 = 0))
            fun gen_onRefresherpulling1_fn(e: RefresherEvent) {
                data.pullingDistance1 = e.detail.dy
            }
            val onRefresherpulling1 = ::gen_onRefresherpulling1_fn
            fun gen_onRefresherrefresh1_fn() {
                data.refreshing1 = true
                console.log("列表1 触发刷新")
                setTimeout(fun(){
                    data.listCount1 += 5
                    data.refreshing1 = false
                    console.log("列表1 刷新完成")
                }
                , 1500)
            }
            val onRefresherrefresh1 = ::gen_onRefresherrefresh1_fn
            fun gen_onRefresherrestore1_fn() {
                data.pullingDistance1 = 0
            }
            val onRefresherrestore1 = ::gen_onRefresherrestore1_fn
            fun gen_onRefresherabort1_fn() {
                data.pullingDistance1 = 0
            }
            val onRefresherabort1 = ::gen_onRefresherabort1_fn
            fun gen_onRefresherpulling2_fn(e: RefresherEvent) {
                data.pullingDistance2 = e.detail.dy
            }
            val onRefresherpulling2 = ::gen_onRefresherpulling2_fn
            fun gen_onRefresherrefresh2_fn() {
                data.refreshing2 = true
                console.log("列表2 触发刷新")
                setTimeout(fun(){
                    data.listCount2 += 5
                    data.refreshing2 = false
                    console.log("列表2 刷新完成")
                }
                , 1500)
            }
            val onRefresherrefresh2 = ::gen_onRefresherrefresh2_fn
            fun gen_onRefresherrestore2_fn() {
                data.pullingDistance2 = 0
            }
            val onRefresherrestore2 = ::gen_onRefresherrestore2_fn
            fun gen_onRefresherabort2_fn() {
                data.pullingDistance2 = 0
            }
            val onRefresherabort2 = ::gen_onRefresherabort2_fn
            fun gen_onRefresherpulling3_fn(e: RefresherEvent) {
                data.pullingDistance3 = e.detail.dy
            }
            val onRefresherpulling3 = ::gen_onRefresherpulling3_fn
            fun gen_onRefresherrefresh3_fn() {
                data.refreshing3 = true
                console.log("列表3 触发刷新")
                setTimeout(fun(){
                    data.listCount3 += 5
                    data.refreshing3 = false
                    console.log("列表3 刷新完成")
                }
                , 1500)
            }
            val onRefresherrefresh3 = ::gen_onRefresherrefresh3_fn
            fun gen_onRefresherrestore3_fn() {
                data.pullingDistance3 = 0
            }
            val onRefresherrestore3 = ::gen_onRefresherrestore3_fn
            fun gen_onRefresherabort3_fn() {
                data.pullingDistance3 = 0
            }
            val onRefresherabort3 = ::gen_onRefresherabort3_fn
            fun gen_onRefresherpulling4_fn(e: RefresherEvent) {
                data.pullingDistance4 = e.detail.dy
            }
            val onRefresherpulling4 = ::gen_onRefresherpulling4_fn
            fun gen_onRefresherrefresh4_fn() {
                data.refreshing4 = true
                console.log("列表4 触发刷新")
                setTimeout(fun(){
                    data.listCount4 += 5
                    data.refreshing4 = false
                    console.log("列表4 刷新完成")
                }
                , 1500)
            }
            val onRefresherrefresh4 = ::gen_onRefresherrefresh4_fn
            fun gen_onRefresherrestore4_fn() {
                data.pullingDistance4 = 0
            }
            val onRefresherrestore4 = ::gen_onRefresherrestore4_fn
            fun gen_onRefresherabort4_fn() {
                data.pullingDistance4 = 0
            }
            val onRefresherabort4 = ::gen_onRefresherabort4_fn
            val getBoundingClientRectForRefreshing = fun(elementId: String): DOMRect {
                return uni_getElementById(elementId)?.getBoundingClientRect()!!
            }
            __expose(_uM("data" to data, "getBoundingClientRectForRefreshing" to getBoundingClientRectForRefreshing))
            return fun(): Any? {
                val _component_page_intro = resolveEasyComponent("page-intro", GenComponentsPageIntroPageIntroClass)
                val _component_uni_refresh_box = resolveEasyComponent("uni-refresh-box", GenUniModulesUniRefreshBoxComponentsUniRefreshBoxUniRefreshBoxClass)
                return _cE("view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cV(_component_page_intro, _uM("content" to "本页演示 scroll-view 自定义下拉刷新属性：refresher 插槽、pulling/refresh/restore/abort 事件、竖排暗黑样式。")),
                    _cE("scroll-view", _uM("id" to "refreshing1", "style" to _nS(_uM("flex" to "1")), "refresher-enabled" to true, "refresher-triggered" to unref(data).refreshing1, "refresher-default-style" to "none", "refresher-threshold" to 45, "refresher-max-drag-distance" to "200px", "onRefresherpulling" to onRefresherpulling1, "onRefresherrefresh" to onRefresherrefresh1, "onRefresherrestore" to onRefresherrestore1, "onRefresherabort" to onRefresherabort1), _uA(
                        _cE(Fragment, null, RenderHelpers.renderList(unref(data).listCount1, fun(i, __key, __index, _cached): Any {
                            return _cE("view", _uM("key" to i, "class" to "content-item"), _uA(
                                _cE("text", _uM("class" to "text"), "item-" + _tD(i), 1)
                            ))
                        }
                        ), 128),
                        _cV(_component_uni_refresh_box, _uM("slot" to "refresher", "pulling-distance" to unref(data).pullingDistance1, "refreshing" to unref(data).refreshing1), null, 8, _uA(
                            "pulling-distance",
                            "refreshing"
                        ))
                    ), 44, _uA(
                        "refresher-triggered"
                    )),
                    _cE("text", _uM("style" to _nS(_uM("margin" to "5px"))), "竖排暗黑自定义文字的下拉设置", 4),
                    _cE("scroll-view", _uM("id" to "refreshing2", "style" to _nS(_uM("flex" to "1", "background-color" to "black")), "refresher-enabled" to true, "refresher-triggered" to unref(data).refreshing2, "refresher-default-style" to "none", "refresher-threshold" to 45, "refresher-max-drag-distance" to "200px", "onRefresherpulling" to onRefresherpulling2, "onRefresherrefresh" to onRefresherrefresh2, "onRefresherrestore" to onRefresherrestore2, "onRefresherabort" to onRefresherabort2), _uA(
                        _cE(Fragment, null, RenderHelpers.renderList(unref(data).listCount2, fun(i, __key, __index, _cached): Any {
                            return _cE("view", _uM("key" to i, "class" to "content-item"), _uA(
                                _cE("text", _uM("class" to "text"), "item-" + _tD(i), 1)
                            ))
                        }
                        ), 128),
                        _cV(_component_uni_refresh_box, _uM("slot" to "refresher", "pulling-distance" to unref(data).pullingDistance2, "refreshing" to unref(data).refreshing2, "loading-class" to "loading-dark", "text-class" to "text-dark", "style" to _nS(_uM("flex-direction" to "column", "height" to "46px", "padding-top" to "6px")), "pulling-text" to "继续下拉可刷新", "loosing-text" to "释放后会刷新", "loading-text" to "奋力加载中..."), null, 8, _uA(
                            "pulling-distance",
                            "refreshing",
                            "style"
                        ))
                    ), 44, _uA(
                        "refresher-triggered"
                    )),
                    _cE("text", _uM("style" to _nS(_uM("margin" to "5px"))), "slot自定义下拉图标", 4),
                    _cE("scroll-view", _uM("id" to "refreshing3", "style" to _nS(_uM("flex" to "1")), "refresher-enabled" to true, "refresher-triggered" to unref(data).refreshing3, "refresher-default-style" to "none", "refresher-threshold" to 45, "refresher-max-drag-distance" to "200px", "onRefresherpulling" to onRefresherpulling3, "onRefresherrefresh" to onRefresherrefresh3, "onRefresherrestore" to onRefresherrestore3, "onRefresherabort" to onRefresherabort3), _uA(
                        _cE(Fragment, null, RenderHelpers.renderList(unref(data).listCount3, fun(i, __key, __index, _cached): Any {
                            return _cE("view", _uM("key" to i, "class" to "content-item"), _uA(
                                _cE("text", _uM("class" to "text"), "item-" + _tD(i), 1)
                            ))
                        }
                        ), 128),
                        _cV(_component_uni_refresh_box, _uM("slot" to "refresher", "pulling-distance" to unref(data).pullingDistance3, "refreshing" to unref(data).refreshing3), _uM("loading" to withScopedSlotCtx(fun(slotProps: Record<String, Any?>): UTSArray<Any> {
                            val state = slotProps["state"]
                            return _uA(
                                if (state == 2) {
                                    _cE("image", _uM("key" to 0, "src" to "https://web-ext-storage.dcloud.net.cn/hello-uni-app-x/refresh-box-run.gif", "style" to _nS(_uM("width" to "20px", "height" to "20px"))), null, 4)
                                } else {
                                    _cE("image", _uM("key" to 1, "src" to "https://web-ext-storage.dcloud.net.cn/hello-uni-app-x/refresh-box-run.gif", "style" to _nS(_uM("width" to "20px", "height" to "20px"))), null, 4)
                                }
                            )
                        }
                        ), "_" to 1), 8, _uA(
                            "pulling-distance",
                            "refreshing"
                        ))
                    ), 44, _uA(
                        "refresher-triggered"
                    )),
                    _cE("text", _uM("style" to _nS(_uM("margin" to "5px"))), "无文字，纯loading", 4),
                    _cE("scroll-view", _uM("id" to "refreshing4", "style" to _nS(_uM("flex" to "1")), "refresher-enabled" to true, "refresher-triggered" to unref(data).refreshing4, "refresher-default-style" to "none", "refresher-threshold" to 45, "refresher-max-drag-distance" to "200px", "onRefresherpulling" to onRefresherpulling4, "onRefresherrefresh" to onRefresherrefresh4, "onRefresherrestore" to onRefresherrestore4, "onRefresherabort" to onRefresherabort4), _uA(
                        _cE(Fragment, null, RenderHelpers.renderList(unref(data).listCount4, fun(i, __key, __index, _cached): Any {
                            return _cE("view", _uM("key" to i, "class" to "content-item"), _uA(
                                _cE("text", _uM("class" to "text"), "item-" + _tD(i), 1)
                            ))
                        }
                        ), 128),
                        _cV(_component_uni_refresh_box, _uM("slot" to "refresher", "pulling-distance" to unref(data).pullingDistance4, "refreshing" to unref(data).refreshing4, "pulling-text" to "", "loosing-text" to "", "loading-text" to "", "loading-class" to "loading-big-font"), null, 8, _uA(
                            "pulling-distance",
                            "refreshing"
                        ))
                    ), 44, _uA(
                        "refresher-triggered"
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
                return _uM("content-item" to _pS(_uM("marginTop" to 5, "marginRight" to 10, "marginBottom" to 5, "marginLeft" to 10)), "text" to _pS(_uM("color" to "#666666", "fontSize" to 14)), "loading-dark" to _pS(_uM("borderTopColor" to "#FFFFFF", "borderRightColor" to "#FFFFFF", "borderBottomColor" to "#FFFFFF", "borderLeftColor" to "#FFFFFF", "width" to 20, "height" to 20)), "text-dark" to _pS(_uM("color" to "#FFFFFF", "marginTop" to 5)), "loading-big-font" to _pS(_uM("width" to 24, "height" to 24)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
