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
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesComponentScrollViewScrollView : BasePage {
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
    open var data: DataType__2
        get() {
            return unref(this.`$exposed`["data"]) as DataType__2
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var setVerticalScrollBy: (y: Number) -> Unit
        get() {
            return unref(this.`$exposed`["setVerticalScrollBy"]) as (y: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setVerticalScrollBy", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentScrollViewScrollView, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentScrollViewScrollView
            val _cache = __ins.renderCache
            val data = reactive(DataType__2(scrollTop = 0, oldScrollTop = 0, scrollLeft = 120, showScrollbar = true, scrollDirection = "vertical", isScrollTest = "", isScrolltolowerTest = "", isScrolltoupperTest = "", scrollDetailTest = null as UniScrollEventDetail?, scrollEndDetailTest = null as UniScrollEventDetail?))
            val checkEventTest = fun(e: ScrollEventTest, eventName: String){
                val isPass = e.type === eventName && e.target is UniElement && e.currentTarget is UniElement
                val result = if (isPass) {
                    "" + eventName + ":Success"
                } else {
                    "" + eventName + ":Fail"
                }
                when (eventName) {
                    "scroll" -> 
                        data.isScrollTest = result
                    "scrolltolower" -> 
                        data.isScrolltolowerTest = result + ("-" + e.direction)
                    "scrolltoupper" -> 
                        data.isScrolltoupperTest = result + ("-" + e.direction)
                    else -> 
                        {}
                }
            }
            val upper = fun(e: UniScrollToUpperEvent){
                console.log("滚动到顶部/左边", e)
                checkEventTest(ScrollEventTest(type = e.type, target = e.target, currentTarget = e.currentTarget, direction = e.detail.direction), "scrolltoupper")
            }
            val lower = fun(e: UniScrollToLowerEvent){
                console.log("滚动到底部/右边", e)
                checkEventTest(ScrollEventTest(type = e.type, target = e.target, currentTarget = e.currentTarget, direction = e.detail.direction), "scrolltolower")
            }
            val scroll = fun(e: UniScrollEvent){
                data.scrollDetailTest = e.detail
                checkEventTest(ScrollEventTest(type = e.type, target = e.target, currentTarget = e.currentTarget), "scroll")
                data.oldScrollTop = e.detail.scrollTop
            }
            val end = fun(e: UniScrollEvent){
                console.log("滚动结束时触发", e)
                data.scrollEndDetailTest = e.detail
                checkEventTest(ScrollEventTest(type = e.type, target = e.target, currentTarget = e.currentTarget), "scrollend")
            }
            val goTop = fun(){
                data.scrollTop = data.oldScrollTop
                nextTick(fun(){
                    data.scrollTop = 0
                }
                )
                uni_showToast(ShowToastOptions(icon = "none", title = "纵向滚动 scrollTop 值已被修改为 0"))
            }
            val setVerticalScrollBy = fun(y: Number){
                val element = uni_getElementById("verticalScrollView")
                if (element != null) {
                    element.scrollBy(0, y)
                }
            }
            __expose(_uM("data" to data, "setVerticalScrollBy" to setVerticalScrollBy))
            val change_disabled_boolean = fun(disabled: Boolean){
                if (disabled) {
                    data.scrollDirection = "none"
                } else {
                    data.scrollDirection = "vertical"
                }
            }
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                val _component_boolean_data = resolveEasyComponent("boolean-data", GenComponentsBooleanDataBooleanDataClass)
                val _component_navigator = resolveComponent("navigator")
                return _cE("scroll-view", _uM("class" to "page-scroll-view", "direction" to unref(data).scrollDirection), _uA(
                    _cE("view", null, _uA(
                        _cV(_component_page_head, _uM("title" to "scroll-view,区域滚动视图")),
                        _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt"), _uA(
                            _cE("view", _uM("class" to "uni-title uni-common-mt"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "Vertical Scroll"),
                                _cE("text", _uM("class" to "uni-subtitle-text"), "纵向滚动")
                            )),
                            _cE("view", null, _uA(
                                _cE("scroll-view", _uM("scroll-top" to unref(data).scrollTop, "direction" to "vertical", "class" to "scroll-Y", "scroll-with-animation" to "true", "onScrolltoupper" to upper, "onScrolltolower" to lower, "onScroll" to scroll, "onScrollend" to end, "show-scrollbar" to unref(data).showScrollbar, "id" to "verticalScrollView"), _uA(
                                    _cE("view", _uM("class" to "scroll-view-item uni-bg-red"), _uA(
                                        _cE("text", _uM("class" to "text"), "A")
                                    )),
                                    _cE("view", _uM("class" to "scroll-view-item uni-bg-green"), _uA(
                                        _cE("text", _uM("class" to "text"), "B")
                                    )),
                                    _cE("view", _uM("class" to "scroll-view-item uni-bg-blue"), _uA(
                                        _cE("text", _uM("class" to "text"), "C")
                                    ))
                                ), 40, _uA(
                                    "scroll-top",
                                    "show-scrollbar"
                                ))
                            )),
                            _cE("view", _uM("onClick" to goTop, "class" to "uni-center uni-common-mt"), _uA(
                                _cE("text", _uM("class" to "uni-link"), "点击这里返回顶部")
                            )),
                            _cE("view", _uM("class" to "uni-title uni-common-mt"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "Horizontal Scroll"),
                                _cE("text", _uM("class" to "uni-subtitle-text"), "横向滚动")
                            )),
                            _cE("view", null, _uA(
                                _cE("scroll-view", _uM("class" to "scroll-view_H", "direction" to "horizontal", "onScroll" to scroll, "onScrollend" to end, "scroll-left" to unref(data).scrollLeft, "show-scrollbar" to unref(data).showScrollbar), _uA(
                                    _cE("view", _uM("class" to "scroll-view-item_H uni-bg-red"), _uA(
                                        _cE("text", _uM("class" to "text"), "A")
                                    )),
                                    _cE("view", _uM("class" to "scroll-view-item_H uni-bg-green"), _uA(
                                        _cE("text", _uM("class" to "text"), "B")
                                    )),
                                    _cE("view", _uM("class" to "scroll-view-item_H uni-bg-blue"), _uA(
                                        _cE("text", _uM("class" to "text"), "C")
                                    ))
                                ), 40, _uA(
                                    "scroll-left",
                                    "show-scrollbar"
                                ))
                            )),
                            _cV(_component_boolean_data, _uM("defaultValue" to false, "title" to "是否禁用外层scroll-view滚动", "onChange" to change_disabled_boolean)),
                            _cE("text", _uM("class" to "uni-title-text"), "scroll-view样式大合集"),
                            _cE("scroll-view", _uM("class" to "scroll-view-style-demo", "direction" to "vertical"), _uA(
                                _cE("view", _uM("class" to "style-demo-item uni-bg-red"), _uA(
                                    _cE("text", _uM("class" to "text"), "1")
                                )),
                                _cE("view", _uM("class" to "style-demo-item uni-bg-green"), _uA(
                                    _cE("text", _uM("class" to "text"), "2")
                                )),
                                _cE("view", _uM("class" to "style-demo-item uni-bg-blue"), _uA(
                                    _cE("text", _uM("class" to "text"), "3")
                                ))
                            )),
                            _cV(_component_navigator, _uM("url" to "/pages/component/scroll-view/scroll-view-props", "hover-class" to "none"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("button", _uM("type" to "primary", "class" to "button"), " 非下拉刷新的属性示例 ")
                                )
                            }
                            ), "_" to 1)),
                            _cE("view", _uM("class" to "uni-common-pb")),
                            _cV(_component_navigator, _uM("url" to "/pages/component/scroll-view/scroll-view-refresher-props", "hover-class" to "none"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("button", _uM("type" to "primary", "class" to "button"), " 下拉刷新的属性示例 ")
                                )
                            }
                            ), "_" to 1)),
                            _cE("view", _uM("class" to "uni-common-pb")),
                            _cV(_component_navigator, _uM("url" to "/pages/component/scroll-view/scroll-view-refresher", "hover-class" to "none"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("button", _uM("type" to "primary", "class" to "button"), " 默认下拉刷新示例 ")
                                )
                            }
                            ), "_" to 1)),
                            _cE("view", _uM("class" to "uni-common-pb")),
                            _cV(_component_navigator, _uM("url" to "/pages/component/scroll-view/scroll-view-custom-refresher-props", "hover-class" to "none"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("button", _uM("type" to "primary", "class" to "button"), " 自定义下拉刷新示例 ")
                                )
                            }
                            ), "_" to 1)),
                            _cE("view", _uM("class" to "uni-common-pb"))
                        ))
                    ))
                ), 8, _uA(
                    "direction"
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
                return _uM("scroll-Y" to _pS(_uM("height" to 150)), "scroll-view_H" to _pS(_uM("width" to "100%", "flexDirection" to "row")), "scroll-view-item" to _pS(_uM("height" to 150, "justifyContent" to "center", "alignItems" to "center")), "scroll-view-item_H" to _pS(_uM("width" to "100%", "height" to 150, "justifyContent" to "center", "alignItems" to "center")), "text" to _pS(_uM("fontSize" to 18, "color" to "#ffffff")), "button" to _pS(_uM("marginTop" to 15)), "scroll-view-style-demo" to _pS(_uM("flexDirection" to "column", "justifyContent" to "flex-start", "flexWrap" to "nowrap", "alignItems" to "center", "width" to "90%", "height" to 80, "backgroundColor" to "#e3f2fd", "backgroundImage" to "linear-gradient(to right, #e3f2fd, #a9d5fa)", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#007aff", "borderRightColor" to "#007aff", "borderBottomColor" to "#007aff", "borderLeftColor" to "#007aff", "borderTopLeftRadius" to 4, "borderTopRightRadius" to 4, "borderBottomRightRadius" to 4, "borderBottomLeftRadius" to 4, "marginTop" to 10, "marginRight" to 10, "marginBottom" to 10, "marginLeft" to 10, "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "display" to "flex", "opacity" to 0.95, "boxShadow" to "0 2px 8px rgba(0, 0, 0, 0.15)")), "style-demo-item" to _pS(_uM("width" to 100, "height" to 80)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
