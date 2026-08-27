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
open class GenPagesComponentLoadingLoading : BasePage {
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
        var setup: (__props: GenPagesComponentLoadingLoading) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentLoadingLoading
            val _cache = __ins.renderCache
            val widthPx = ref(100)
            val heightPx = ref(100)
            val borderColor = ref("blue")
            val isBold = ref(false)
            val colors = _uA(
                "blue",
                "red",
                "green",
                "yellow"
            )
            val colorIndex = ref(0)
            val paused = ref(false)
            val iosSpinner = ref(false)
            val dynamicStyle = computed(fun(): UTSJSONObject {
                return _uO("width" to (widthPx.value + "px"), "height" to (heightPx.value + "px"), "borderColor" to borderColor.value, "borderWidth" to if (isBold.value) {
                    "thick"
                } else {
                    "medium"
                }
                )
            }
            )
            val increaseSize = fun(){
                widthPx.value += 10
                heightPx.value += 10
            }
            val decreaseSize = fun(){
                widthPx.value = Math.max(20, widthPx.value - 10)
                heightPx.value = Math.max(20, heightPx.value - 10)
            }
            val toggleBold = fun(){
                isBold.value = !isBold.value
            }
            val nextColor = fun(){
                colorIndex.value = (colorIndex.value + 1) % colors.length
                borderColor.value = colors[colorIndex.value]
            }
            val reset = fun(){
                widthPx.value = 100
                heightPx.value = 100
                borderColor.value = "blue"
                isBold.value = false
                iosSpinner.value = false
                colorIndex.value = 0
                paused.value = false
            }
            val setPaused = fun(){
                paused.value = !paused.value
            }
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                val _component_loading = resolveComponent("loading")
                val _component_navigator = resolveComponent("navigator")
                return _cE("scroll-view", _uM("class" to "container"), _uA(
                    _cV(_component_page_head, _uM("title" to "loading组件")),
                    _cE("view", _uM("class" to "section"), _uA(
                        _cE("view", _uM("class" to "row"), _uA(
                            _cE("view", _uM("class" to "item"), _uA(
                                _cE("text", _uM("class" to "label"), "默认样式"),
                                _cV(_component_loading)
                            )),
                            _cE("view", _uM("class" to "item"), _uA(
                                _cE("text", _uM("class" to "label"), "paused为true"),
                                _cV(_component_loading, _uM("paused" to ""))
                            )),
                            _cE("view", _uM("class" to "item"), _uA(
                                _cE("text", _uM("class" to "label"), "bold为true"),
                                _cV(_component_loading, _uM("bold" to ""))
                            )),
                            _cE("view", _uM("class" to "item"), _uA(
                                _cE("text", _uM("class" to "label"), "背景圈黑色，前景白色"),
                                _cE("view", _uM("style" to _nS(_uM("width" to "17px", "height" to "17px", "border-radius" to "8.5px", "border" to "black 2px solid", "align-items" to "center", "justify-content" to "center", "overflow" to "visible"))), _uA(
                                    _cV(_component_loading, _uM("style" to _nS(_uM("border-color" to "white")), "bold" to ""), null, 8, _uA(
                                        "style"
                                    ))
                                ), 4)
                            ))
                        ))
                    )),
                    _cE("view", _uM("class" to "section"), _uA(
                        _cE("text", _uM("class" to "section-title"), "动态 style"),
                        _cE("view", _uM("class" to "controls"), _uA(
                            _cE("button", _uM("size" to "mini", "onClick" to decreaseSize), "-10px"),
                            _cE("button", _uM("size" to "mini", "onClick" to increaseSize), "+10px"),
                            _cE("button", _uM("size" to "mini", "onClick" to toggleBold), "bold 属性: " + _tD(unref(isBold)), 1),
                            _cE("button", _uM("size" to "mini", "onClick" to nextColor), "color style: " + _tD(unref(borderColor)), 1),
                            _cE("button", _uM("size" to "mini", "onClick" to setPaused), "paused 属性：" + _tD(unref(paused)), 1),
                            _cE("button", _uM("size" to "mini", "onClick" to reset), "reset")
                        )),
                        _cE("view", _uM("class" to "row"), _uA(
                            _cE("view", _uM("class" to "item"), _uA(
                                _cE("text", _uM("class" to "label"), _tD(unref(widthPx)) + "×" + _tD(unref(heightPx)) + " / " + _tD(unref(borderColor)) + " / bold: " + _tD(unref(isBold)) + " / paused: " + _tD(unref(paused)) + " / ios-spinner: " + _tD(unref(iosSpinner)), 1),
                                _cE("view", _uM("class" to "box"), _uA(
                                    _cV(_component_loading, _uM("bold" to unref(isBold), "paused" to unref(paused), "ios-spinner" to unref(iosSpinner), "style" to _nS(unref(dynamicStyle))), null, 8, _uA(
                                        "bold",
                                        "paused",
                                        "ios-spinner",
                                        "style"
                                    ))
                                ))
                            ))
                        ))
                    )),
                    _cE("view", _uM("class" to "section"), _uA(
                        _cE("text", _uM("class" to "section-title"), "Class 自定义样式"),
                        _cE("view", _uM("class" to "row"), _uA(
                            _cE("view", _uM("class" to "item"), _uA(
                                _cE("text", _uM("class" to "label"), "100×100 / blue / bold=false"),
                                _cE("view", _uM("class" to "box"), _uA(
                                    _cV(_component_loading, _uM("bold" to false, "class" to "size-100 bc-blue"))
                                ))
                            )),
                            _cE("view", _uM("class" to "item"), _uA(
                                _cE("text", _uM("class" to "label"), "100×100 / red / bold=true"),
                                _cE("view", _uM("class" to "box"), _uA(
                                    _cV(_component_loading, _uM("bold" to true, "class" to "size-100 bc-red"))
                                ))
                            )),
                            _cE("view", _uM("class" to "item"), _uA(
                                _cE("text", _uM("class" to "label"), "80×80 / green / bold=false"),
                                _cE("view", _uM("class" to "box"), _uA(
                                    _cV(_component_loading, _uM("bold" to false, "class" to "size-80 bc-green"))
                                ))
                            )),
                            _cE("view", _uM("class" to "item"), _uA(
                                _cE("text", _uM("class" to "label"), "140×140 / yellow / bold=true"),
                                _cE("view", _uM("class" to "box"), _uA(
                                    _cV(_component_loading, _uM("bold" to true, "class" to "size-140 bc-yellow"))
                                ))
                            )),
                            _cE("view", _uM("class" to "item"), _uA(
                                _cE("text", _uM("class" to "label"), "140×140 / yellow / bold=true, 默认paused属性=true"),
                                _cE("view", _uM("class" to "box"), _uA(
                                    _cV(_component_loading, _uM("bold" to true, "paused" to true, "class" to "size-140 bc-yellow"))
                                ))
                            ))
                        ))
                    )),
                    _cE("view", _uM("class" to "section"), _uA(
                        _cE("text", _uM("class" to "section-title"), "Style 自定义样式"),
                        _cE("view", _uM("class" to "row"), _uA(
                            _cE("view", _uM("class" to "item"), _uA(
                                _cE("text", _uM("class" to "label"), "80×80 / red / bold=true"),
                                _cE("view", _uM("class" to "box"), _uA(
                                    _cV(_component_loading, _uM("bold" to true, "style" to _nS(_uM("width" to "80px", "height" to "80px", "borderColor" to "red"))), null, 8, _uA(
                                        "style"
                                    ))
                                ))
                            )),
                            _cE("view", _uM("class" to "item"), _uA(
                                _cE("text", _uM("class" to "label"), "120×120 / green / bold=false"),
                                _cE("view", _uM("class" to "box"), _uA(
                                    _cV(_component_loading, _uM("bold" to false, "style" to _nS(_uM("width" to "120px", "height" to "120px", "borderColor" to "green"))), null, 8, _uA(
                                        "style"
                                    ))
                                ))
                            ))
                        ))
                    )),
                    _cV(_component_navigator, _uM("class" to "uni-common-mb", "url" to "/pages/template/loading-100/loading-100"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("button", null, "组件性能测试")
                        )
                    }
                    ), "_" to 1))
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
                return _uM("container" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "paddingTop" to 8, "paddingRight" to 8, "paddingBottom" to 8, "paddingLeft" to 8, "backgroundColor" to "#f8f8f8")), "header" to _pS(_uM("marginBottom" to 16, "alignItems" to "center")), "title" to _pS(_uM("fontSize" to 22, "fontWeight" to "bold", "color" to "#333333", "textAlign" to "center")), "subtitle" to _pS(_uM("fontSize" to 14, "color" to "#666666", "marginTop" to 6, "textAlign" to "center")), "section" to _pS(_uM("marginBottom" to 18, "backgroundColor" to "#ffffff", "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "borderBottomRightRadius" to 10, "borderBottomLeftRadius" to 10, "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "boxShadow" to "0 2px 8px rgba(0,0,0,0.05)")), "section-title" to _pS(_uM("fontSize" to 16, "fontWeight" to "bold", "color" to "#444444", "marginBottom" to 10, "textAlign" to "center", "backgroundColor" to "#f0f0f0", "paddingTop" to 6, "paddingRight" to 6, "paddingBottom" to 6, "paddingLeft" to 6, "borderTopLeftRadius" to 6, "borderTopRightRadius" to 6, "borderBottomRightRadius" to 6, "borderBottomLeftRadius" to 6)), "row" to _pS(_uM("flexDirection" to "row", "flexWrap" to "wrap", "justifyContent" to "space-around")), "item" to _pS(_uM("alignItems" to "center", "marginTop" to 8, "marginRight" to 4, "marginBottom" to 8, "marginLeft" to 4)), "label" to _pS(_uM("fontSize" to 12, "color" to "#666666", "marginBottom" to 8, "textAlign" to "center")), "box" to _pS(_uM("borderTopStyle" to "none", "borderRightStyle" to "none", "borderBottomStyle" to "none", "borderLeftStyle" to "none")), "size-80" to _pS(_uM("width" to 80, "height" to 80)), "size-100" to _pS(_uM("width" to 100, "height" to 100)), "size-140" to _pS(_uM("width" to 140, "height" to 140)), "bc-blue" to _pS(_uM("borderTopColor" to "#0000FF", "borderRightColor" to "#0000FF", "borderBottomColor" to "#0000FF", "borderLeftColor" to "#0000FF")), "bc-red" to _pS(_uM("borderTopColor" to "#FF0000", "borderRightColor" to "#FF0000", "borderBottomColor" to "#FF0000", "borderLeftColor" to "#FF0000")), "bc-green" to _pS(_uM("borderTopColor" to "#008000", "borderRightColor" to "#008000", "borderBottomColor" to "#008000", "borderLeftColor" to "#008000")), "bc-yellow" to _pS(_uM("borderTopColor" to "#FFFF00", "borderRightColor" to "#FFFF00", "borderBottomColor" to "#FFFF00", "borderLeftColor" to "#FFFF00")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
