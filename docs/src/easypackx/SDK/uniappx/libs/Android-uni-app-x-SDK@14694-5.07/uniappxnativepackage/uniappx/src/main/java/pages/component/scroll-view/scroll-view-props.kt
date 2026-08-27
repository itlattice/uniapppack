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
open class GenPagesComponentScrollViewScrollViewProps : BasePage {
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
    open var data: DataType__4
        get() {
            return unref(this.`$exposed`["data"]) as DataType__4
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var checkScrollHeight: () -> Boolean
        get() {
            return unref(this.`$exposed`["checkScrollHeight"]) as () -> Boolean
        }
        set(value) {
            setRefValue(this.`$exposed`, "checkScrollHeight", value)
        }
    open var checkScrollWidth: () -> Boolean
        get() {
            return unref(this.`$exposed`["checkScrollWidth"]) as () -> Boolean
        }
        set(value) {
            setRefValue(this.`$exposed`, "checkScrollWidth", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentScrollViewScrollViewProps, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentScrollViewScrollViewProps
            val _cache = __ins.renderCache
            val data = reactive(DataType__4(items = _uA<Item>(), scrollX = false, scrollY = true, bounces = false, scrollTop = 0, scrollLeft = 0, scrollChangeTop = 0, scrollIntoView = "", enableBackToTop = false, scrollWithAnimation = false, showScrollbar = true, upperThreshold = 50, lowerThreshold = 50))
            val scrollViewXRef = ref<UniScrollViewElement?>(null)
            val scrollViewYRef = ref<UniScrollViewElement?>(null)
            fun gen_handleChangeScrollLeft_fn(e: UniSliderChangeEvent) {
                data.scrollLeft = e.detail.value
            }
            val handleChangeScrollLeft = ::gen_handleChangeScrollLeft_fn
            fun gen_handleChangeScrollTop_fn(e: UniSliderChangeEvent) {
                data.scrollTop = e.detail.value
            }
            val handleChangeScrollTop = ::gen_handleChangeScrollTop_fn
            fun gen_changeDirectionX_fn() {
                data.scrollX = !data.scrollX
                if (data.scrollX) {
                    data.scrollY = false
                }
                data.scrollTop = 0
                data.scrollLeft = 0
            }
            val changeDirectionX = ::gen_changeDirectionX_fn
            fun gen_changeDirectionY_fn() {
                data.scrollY = !data.scrollY
                if (data.scrollY) {
                    data.scrollX = false
                }
                data.scrollTop = 0
                data.scrollLeft = 0
            }
            val changeDirectionY = ::gen_changeDirectionY_fn
            fun gen_handleScrollIntoView_fn() {
                if (data.scrollX) {
                    data.scrollIntoView = "horizontal_item3"
                } else {
                    data.scrollIntoView = "item3"
                }
                setTimeout(fun(){
                    data.scrollIntoView = ""
                }
                , 0)
            }
            val handleScrollIntoView = ::gen_handleScrollIntoView_fn
            fun gen_handleUpperThresholdInput_fn(e: InputEvent) {
                val value = e.detail.value
                if (value == "") {
                    data.upperThreshold = 50
                } else {
                    data.upperThreshold = parseInt(e.detail.value)
                }
            }
            val handleUpperThresholdInput = ::gen_handleUpperThresholdInput_fn
            fun gen_handleLowerThresholdInput_fn(e: InputEvent) {
                val value = e.detail.value
                if (value == "") {
                    data.lowerThreshold = 50
                } else {
                    data.lowerThreshold = parseInt(e.detail.value)
                }
            }
            val handleLowerThresholdInput = ::gen_handleLowerThresholdInput_fn
            fun gen_scrolltoupper_fn() {
                console.log("滚动到顶部")
            }
            val scrolltoupper = ::gen_scrolltoupper_fn
            fun gen_scrolltolower_fn() {
                console.log("滚动到底部")
            }
            val scrolltolower = ::gen_scrolltolower_fn
            fun gen_scroll_fn(e: ScrollEvent) {
                data.scrollChangeTop = e.detail.scrollTop
                console.log("scroll-top : " + e.detail.scrollTop + " scroll-left : " + e.detail.scrollLeft)
            }
            val scroll = ::gen_scroll_fn
            fun gen_scrollend_fn() {
                console.log("滚动停止")
            }
            val scrollend = ::gen_scrollend_fn
            fun gen_onTouchMove_fn() {
                console.log("TouchMove")
            }
            val onTouchMove = ::gen_onTouchMove_fn
            fun gen_checkScrollHeight_fn(): Boolean {
                var element = scrollViewYRef.value
                if (element != null) {
                    var scrollHeight = element.scrollHeight
                    console.log("checkScrollHeight" + scrollHeight)
                    if (scrollHeight > 1900) {
                        return true
                    }
                }
                return false
            }
            val checkScrollHeight = ::gen_checkScrollHeight_fn
            fun gen_checkScrollWidth_fn(): Boolean {
                var element = scrollViewXRef.value
                if (element != null) {
                    var scrollWidth = element.scrollWidth
                    console.log("checkScrollWidth---" + scrollWidth)
                    if (scrollWidth > 1900) {
                        return true
                    }
                }
                return false
            }
            val checkScrollWidth = ::gen_checkScrollWidth_fn
            onLoad(fun(options: OnLoadOptions){
                run {
                    var i: Number = 0
                    while(i < 10){
                        val item = Item(id = "item" + i, label = "item" + i)
                        data.items.push(item)
                        i++
                    }
                }
            }
            )
            __expose(_uM("data" to data, "checkScrollHeight" to checkScrollHeight, "checkScrollWidth" to checkScrollWidth))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                val _component_switch = resolveComponent("switch")
                val _component_slider = resolveComponent("slider")
                return _cE(Fragment, null, _uA(
                    _cV(_component_page_head, _uM("title" to "非下拉刷新的scroll-view属性示例")),
                    if (isTrue(unref(data).scrollX)) {
                        _cE("scroll-view", _uM("key" to 0, "direction" to "horizontal", "scroll-top" to unref(data).scrollTop, "scroll-left" to unref(data).scrollLeft, "upper-threshold" to unref(data).upperThreshold, "lower-threshold" to unref(data).lowerThreshold, "scroll-into-view" to unref(data).scrollIntoView, "enable-back-to-top" to unref(data).enableBackToTop, "scroll-with-animation" to unref(data).scrollWithAnimation, "style" to _nS(_uM("flex-direction" to "row")), "class" to "uni-margin-wrap", "show-scrollbar" to unref(data).showScrollbar, "bounces" to unref(data).bounces, "onScrolltoupper" to scrolltoupper, "onScrolltolower" to scrolltolower, "onScroll" to scroll, "onScrollend" to scrollend, "ref_key" to "scrollViewXRef", "ref" to scrollViewXRef, "id" to "scrollViewX"), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(unref(data).items, fun(item, index, __index, _cached): Any {
                                return _cE("view", _uM("class" to _nC(_uA(
                                    "item",
                                    if (index == 9) {
                                        "h-margin-right"
                                    } else {
                                        ""
                                    }
                                )), "id" to ("horizontal_" + item.id)), _uA(
                                    _cE("text", _uM("class" to "uni-text"), _tD(item.label), 1)
                                ), 10, _uA(
                                    "id"
                                ))
                            }), 256)
                        ), 44, _uA(
                            "scroll-top",
                            "scroll-left",
                            "upper-threshold",
                            "lower-threshold",
                            "scroll-into-view",
                            "enable-back-to-top",
                            "scroll-with-animation",
                            "show-scrollbar",
                            "bounces"
                        ))
                    } else {
                        _cE("scroll-view", _uM("key" to 1, "direction" to "vertical", "scroll-top" to unref(data).scrollTop, "scroll-left" to unref(data).scrollLeft, "upper-threshold" to unref(data).upperThreshold, "lower-threshold" to unref(data).lowerThreshold, "scroll-into-view" to unref(data).scrollIntoView, "enable-back-to-top" to unref(data).enableBackToTop, "scroll-with-animation" to unref(data).scrollWithAnimation, "show-scrollbar" to unref(data).showScrollbar, "bounces" to unref(data).bounces, "onScrolltoupper" to scrolltoupper, "onTouchmove" to onTouchMove, "onScrolltolower" to scrolltolower, "onScroll" to scroll, "onScrollend" to scrollend, "ref_key" to "scrollViewYRef", "ref" to scrollViewYRef, "id" to "scrollViewY", "class" to "uni-margin-wrap"), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(unref(data).items, fun(item, index, __index, _cached): Any {
                                return _cE("view", _uM("class" to _nC(_uA(
                                    "item",
                                    if (index == 9) {
                                        "v-margin-bottom"
                                    } else {
                                        ""
                                    }
                                )), "id" to item.id), _uA(
                                    _cE("text", _uM("class" to "uni-text"), _tD(item.label), 1)
                                ), 10, _uA(
                                    "id"
                                ))
                            }
                            ), 256)
                        ), 40, _uA(
                            "scroll-top",
                            "scroll-left",
                            "upper-threshold",
                            "lower-threshold",
                            "scroll-into-view",
                            "enable-back-to-top",
                            "scroll-with-animation",
                            "show-scrollbar",
                            "bounces"
                        ))
                    }
                    ,
                    _cE("scroll-view", _uM("class" to "uni-list"), _uA(
                        _cE("view", _uM("class" to "uni-list-cell uni-list-cell-padding"), _uA(
                            _cE("text", null, "点击状态栏回到顶部（仅iOS）"),
                            _cV(_component_switch, _uM("checked" to unref(data).enableBackToTop, "onChange" to fun(){
                                unref(data).enableBackToTop = !unref(data).enableBackToTop
                            }
                            ), null, 8, _uA(
                                "checked",
                                "onChange"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-list-cell uni-list-cell-padding"), _uA(
                            _cE("text", null, "是否显示滚动条"),
                            _cV(_component_switch, _uM("checked" to unref(data).showScrollbar, "onChange" to fun(){
                                unref(data).showScrollbar = !unref(data).showScrollbar
                            }
                            ), null, 8, _uA(
                                "checked",
                                "onChange"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-list-cell uni-list-cell-padding"), _uA(
                            _cE("text", null, "是否有反弹效果"),
                            _cV(_component_switch, _uM("checked" to unref(data).bounces, "onChange" to fun(){
                                unref(data).bounces = !unref(data).bounces
                            }
                            ), null, 8, _uA(
                                "checked",
                                "onChange"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-list-cell uni-list-cell-padding"), _uA(
                            _cE("text", null, "是否开启滚动时使用动画过渡"),
                            _cV(_component_switch, _uM("checked" to unref(data).scrollWithAnimation, "onChange" to fun(){
                                unref(data).scrollWithAnimation = !unref(data).scrollWithAnimation
                            }
                            ), null, 8, _uA(
                                "checked",
                                "onChange"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-list-cell uni-list-cell-padding"), _uA(
                            _cE("text", null, "是否横向滚动"),
                            _cV(_component_switch, _uM("checked" to unref(data).scrollX, "onChange" to changeDirectionX), null, 8, _uA(
                                "checked"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-list-cell uni-list-cell-padding"), _uA(
                            _cE("text", null, "是否竖向滚动"),
                            _cV(_component_switch, _uM("checked" to unref(data).scrollY, "onChange" to changeDirectionY), null, 8, _uA(
                                "checked"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-slider uni-list-cell-padding"), _uA(
                            _cE("text", null, "拖动设置scroll-top")
                        )),
                        _cE("view", _uM("class" to "uni-slider uni-list-cell-padding"), _uA(
                            _cV(_component_slider, _uM("max" to 1000, "min" to 0, "step" to 10, "value" to unref(data).scrollTop, "show-value" to true, "onChange" to handleChangeScrollTop), null, 8, _uA(
                                "value"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-slider uni-list-cell-padding"), _uA(
                            _cE("text", null, "拖动设置scroll-left")
                        )),
                        _cE("view", _uM("class" to "uni-slider uni-list-cell-padding"), _uA(
                            _cV(_component_slider, _uM("max" to 1000, "min" to 0, "step" to 10, "value" to unref(data).scrollLeft, "show-value" to true, "onChange" to handleChangeScrollLeft), null, 8, _uA(
                                "value"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-list-cell uni-list-cell-padding"), _uA(
                            _cE("text", null, "设置触发scrolltoupper的距离"),
                            _cE("input", _uM("class" to "uni-list-cell-input", "type" to "number", "value" to unref(data).upperThreshold, "onInput" to handleUpperThresholdInput), null, 40, _uA(
                                "value"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-list-cell uni-list-cell-padding"), _uA(
                            _cE("text", null, "设置触发scrolltolower的距离"),
                            _cE("input", _uM("class" to "uni-list-cell-input", "type" to "number", "value" to unref(data).lowerThreshold, "onInput" to handleLowerThresholdInput), null, 40, _uA(
                                "value"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-list-cell uni-list-cell-padding"), _uA(
                            _cE("button", _uM("type" to "primary", "class" to "button", "onClick" to handleScrollIntoView), " 滚动到id为`item3`的子视图 ")
                        )),
                        _cE("view", _uM("class" to "uni-list-cell uni-list-cell-padding"))
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
                return _uM("uni-margin-wrap" to _pS(_uM("height" to 250, "marginTop" to 0, "marginRight" to 25, "marginBottom" to 25, "marginLeft" to 25)), "item" to _pS(_uM("justifyContent" to "center", "alignItems" to "center", "height" to 250, "width" to "100%", "backgroundColor" to "#F0FFFF", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#D2691E", "borderRightColor" to "#D2691E", "borderBottomColor" to "#D2691E", "borderLeftColor" to "#D2691E")), "uni-list" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "uni-text" to _pS(_uM("color" to "#000000", "fontSize" to 50)), "uni-slider" to _pS(_uM("justifyContent" to "center")), "uni-list-cell-input" to _pS(_uM("width" to 50, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#cccccc", "borderRightColor" to "#cccccc", "borderBottomColor" to "#cccccc", "borderLeftColor" to "#cccccc", "textAlign" to "center")), "button" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "v-margin-bottom" to _pS(_uM("marginBottom" to 50)), "h-margin-right" to _pS(_uM("marginRight" to 50)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
