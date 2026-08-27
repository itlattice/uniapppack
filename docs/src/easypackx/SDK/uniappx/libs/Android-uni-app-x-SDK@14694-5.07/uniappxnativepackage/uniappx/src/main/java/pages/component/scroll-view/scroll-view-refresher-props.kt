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
open class GenPagesComponentScrollViewScrollViewRefresherProps : BasePage {
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
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentScrollViewScrollViewRefresherProps) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentScrollViewScrollViewRefresherProps
            val _cache = __ins.renderCache
            val items = ref(_uA<Item__1>())
            val refresherEnabled = ref(true)
            val refresherTriggered = ref(false)
            val refresherThreshold = ref(45)
            val refresherDefaultStyle = ref("black")
            val refresherBackground = ref("transparent")
            onLoad(fun(_options){
                run {
                    var i: Number = 0
                    while(i < 10){
                        val item = Item__1(id = "item" + i, label = "item" + i)
                        items.value.push(item)
                        i++
                    }
                }
            }
            )
            fun gen_handleTrunOnRefresher_fn() {
                refresherTriggered.value = false
                setTimeout(fun(){
                    refresherEnabled.value = !refresherEnabled.value
                }
                , 0)
            }
            val handleTrunOnRefresher = ::gen_handleTrunOnRefresher_fn
            fun gen_handleRefresherThresholdInput_fn(e: InputEvent) {
                val value = e.detail.value
                if (value == "") {
                    refresherThreshold.value = 45
                } else {
                    refresherThreshold.value = parseInt(e.detail.value)
                }
            }
            val handleRefresherThresholdInput = ::gen_handleRefresherThresholdInput_fn
            fun gen_handleRefresherBackground_fn(e: InputEvent) {
                val value = e.detail.value
                refresherBackground.value = value
            }
            val handleRefresherBackground = ::gen_handleRefresherBackground_fn
            fun gen_refresherpulling_fn() {
                console.log("下拉刷新控件被下拉")
            }
            val refresherpulling = ::gen_refresherpulling_fn
            fun gen_refresherrefresh_fn() {
                console.log("下拉刷新被触发")
                refresherTriggered.value = true
                setTimeout(fun(){
                    refresherTriggered.value = false
                }
                , 1500)
            }
            val refresherrefresh = ::gen_refresherrefresh_fn
            fun gen_refresherrestore_fn() {
                console.log("下拉刷新被复位")
            }
            val refresherrestore = ::gen_refresherrestore_fn
            fun gen_refresherabort_fn() {
                console.log("下拉刷新被中止")
            }
            val refresherabort = ::gen_refresherabort_fn
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                val _component_switch = resolveComponent("switch")
                return _cE("view", _uM("class" to "page-scroll-view"), _uA(
                    _cV(_component_page_head, _uM("title" to "下拉刷新的scroll-view属性示例")),
                    _cE("view", _uM("class" to "uni-margin-wrap"), _uA(
                        _cE("scroll-view", _uM("direction" to "vertical", "refresher-enabled" to unref(refresherEnabled), "refresher-threshold" to unref(refresherThreshold), "refresher-default-style" to unref(refresherDefaultStyle), "refresher-background" to unref(refresherBackground), "refresher-triggered" to unref(refresherTriggered), "onRefresherpulling" to refresherpulling, "onRefresherrefresh" to refresherrefresh, "onRefresherrestore" to refresherrestore, "onRefresherabort" to refresherabort, "style" to _nS(_uM("width" to "100%", "height" to "100%"))), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(unref(items), fun(item, _, __index, _cached): Any {
                                return _cE("view", _uM("class" to "item", "id" to item.id), _uA(
                                    _cE("text", _uM("class" to "uni-text"), _tD(item.label), 1)
                                ), 8, _uA(
                                    "id"
                                ))
                            }
                            ), 256)
                        ), 44, _uA(
                            "refresher-enabled",
                            "refresher-threshold",
                            "refresher-default-style",
                            "refresher-background",
                            "refresher-triggered"
                        ))
                    )),
                    _cE("scroll-view", _uM("class" to "uni-list", "style" to _nS(_uM("padding-top" to "16px"))), _uA(
                        _cE("view", _uM("class" to "uni-list-cell-padding"), _uA(
                            _cE("text", _uM("class" to "refresher-tips"), "**下拉刷新的属性设置需要先打开下拉刷新开关**")
                        )),
                        _cE("view", _uM("class" to "uni-list-cell uni-list-cell-padding"), _uA(
                            _cE("text", null, "是否开启下拉刷新"),
                            _cV(_component_switch, _uM("checked" to unref(refresherEnabled), "onChange" to handleTrunOnRefresher), null, 8, _uA(
                                "checked"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-list-cell uni-list-cell-padding"), _uA(
                            _cE("text", null, "设置下拉刷新状态"),
                            _cV(_component_switch, _uM("disabled" to !unref(refresherEnabled), "checked" to unref(refresherTriggered), "onChange" to fun(){
                                refresherTriggered.value = !unref(refresherTriggered)
                            }
                            ), null, 8, _uA(
                                "disabled",
                                "checked",
                                "onChange"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-list-cell uni-list-cell-padding"), _uA(
                            _cE("text", null, "设置下拉刷新阈值"),
                            _cE("input", _uM("class" to "uni-list-cell-input", "disabled" to !unref(refresherEnabled), "value" to unref(refresherThreshold), "type" to "number", "onInput" to handleRefresherThresholdInput), null, 40, _uA(
                                "disabled",
                                "value"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-list-cell uni-list-cell-padding"), _uA(
                            _cE("text", null, "设置下拉刷新区域背景颜色"),
                            _cE("input", _uM("class" to "uni-list-cell-input", "disabled" to !unref(refresherEnabled), "value" to unref(refresherBackground), "onInput" to handleRefresherBackground), null, 40, _uA(
                                "disabled",
                                "value"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-list-cell-padding"), _uA(
                            _cE("text", null, "设置下拉刷新默认样式"),
                            _cE("view", _uM("class" to "switch-refresher-group"), _uA(
                                _cE("button", _uM("class" to "switch-refresher-style", "type" to "primary", "size" to "mini", "onClick" to fun(){
                                    refresherDefaultStyle.value = "none"
                                }
                                ), "none", 8, _uA(
                                    "onClick"
                                )),
                                _cE("button", _uM("class" to "switch-refresher-style", "type" to "primary", "size" to "mini", "onClick" to fun(){
                                    refresherDefaultStyle.value = "black"
                                }
                                ), "black", 8, _uA(
                                    "onClick"
                                )),
                                _cE("button", _uM("class" to "switch-refresher-style", "type" to "primary", "size" to "mini", "onClick" to fun(){
                                    refresherDefaultStyle.value = "white"
                                }
                                ), "white", 8, _uA(
                                    "onClick"
                                ))
                            ))
                        ))
                    ), 4)
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
                return _uM("uni-margin-wrap" to _pS(_uM("height" to 200, "marginTop" to 0, "marginRight" to 25, "marginBottom" to 25, "marginLeft" to 25)), "item" to _pS(_uM("justifyContent" to "center", "alignItems" to "center", "height" to 200, "width" to "100%", "backgroundColor" to "#F0FFFF", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#D2691E", "borderRightColor" to "#D2691E", "borderBottomColor" to "#D2691E", "borderLeftColor" to "#D2691E")), "refresher-tips" to _pS(_uM("fontSize" to 12, "textAlign" to "center", "color" to "#FF0000")), "uni-text" to _pS(_uM("color" to "#000000", "fontSize" to 50)), "uni-list" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "uni-list-cell-input" to _pS(_uM("maxWidth" to 100, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#cccccc", "borderRightColor" to "#cccccc", "borderBottomColor" to "#cccccc", "borderLeftColor" to "#cccccc", "textAlign" to "center")), "switch-refresher-group" to _pS(_uM("flexDirection" to "row", "marginTop" to 5)), "switch-refresher-style" to _pS(_uM("paddingTop" to 2, "paddingRight" to 10, "paddingBottom" to 2, "paddingLeft" to 10, "marginRight" to 5)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
