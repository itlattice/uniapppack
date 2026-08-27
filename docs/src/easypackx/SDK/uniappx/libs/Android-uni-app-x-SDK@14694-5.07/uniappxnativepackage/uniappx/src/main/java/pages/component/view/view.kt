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
open class GenPagesComponentViewView : BasePage {
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
    open var data: DataType
        get() {
            return unref(this.`$exposed`["data"]) as DataType
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentViewView, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentViewView
            val _cache = __ins.renderCache
            val data = reactive(DataType(hover_class = false, stop_propagation = false, start_time = 50, stay_time = 400, start_time_enum = _uA(
                ItemType(value = 50, name = "50毫秒"),
                ItemType(value = 200, name = "200毫秒")
            ), stay_time_enum = _uA(
                ItemType(value = 400, name = "400毫秒"),
                ItemType(value = 200, name = "200毫秒")
            )))
            val isDarkMode = computed(fun(): Boolean {
                return state.isDarkMode
            }
            )
            val change_hover_class_boolean = fun(checked: Boolean){
                data.hover_class = checked
            }
            val change_stop_propagation_boolean = fun(checked: Boolean){
                data.stop_propagation = checked
            }
            val radio_change_start_time_enum = fun(time: Number){
                data.start_time = time
            }
            val radio_change_stay_time_enum = fun(time: Number){
                data.stay_time = time
            }
            __expose(_uM("data" to data))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                val _component_boolean_data = resolveEasyComponent("boolean-data", GenComponentsBooleanDataBooleanDataClass)
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                return _cE(Fragment, null, _uA(
                    _cV(_component_page_head, _uM("title" to "view")),
                    _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                        _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "view样式大合集"),
                            _cE("view", _uM("class" to "styled-view-row"), _uA(
                                _cE("view", _uM("class" to "styled-view"), _uA(
                                    _cE("text", _uM("class" to "demo-text"), "普通view")
                                )),
                                _cE("view", _uM("class" to "styled-view", "flatten" to ""), _uA(
                                    _cE("text", _uM("class" to "demo-text", "flatten" to ""), "拍平view")
                                ))
                            )),
                            _cE("text", _uM("class" to "uni-title-text"), "自定义组件：右边拍平"),
                            _cE("view", _uM("class" to "styled-view-row"), _uA(
                                _cV(unref(GenPagesComponentViewChildClass)),
                                _cV(unref(GenPagesComponentViewChildClass), _uM("flatten" to ""))
                            )),
                            _cE("text", _uM("class" to "uni-title-text uni-common-mt"), "Hover 点击态效果"),
                            _cE("view", _uM("id" to "view", "class" to "main", "hover-class" to if (unref(data).hover_class) {
                                "is-parent-hover"
                            } else {
                                "none"
                            }
                            ), _uA(
                                _cE("view", _uM("id" to "view-child1", "class" to _nC(_uA(
                                    "test-view",
                                    if (unref(isDarkMode)) {
                                        "theme-dark"
                                    } else {
                                        "theme-light"
                                    }
                                )), "hover-class" to if (unref(data).hover_class) {
                                    "is-hover"
                                } else {
                                    "none"
                                }
                                , "hover-stop-propagation" to unref(data).stop_propagation, "hover-start-time" to unref(data).start_time, "hover-stay-time" to unref(data).stay_time), null, 10, _uA(
                                    "hover-class",
                                    "hover-stop-propagation",
                                    "hover-start-time",
                                    "hover-stay-time"
                                ))
                            ), 8, _uA(
                                "hover-class"
                            )),
                            _cE("view", _uM("class" to "content"), _uA(
                                _cV(_component_boolean_data, _uM("defaultValue" to false, "title" to "是否指定按下去的样式类", "onChange" to change_hover_class_boolean)),
                                _cV(_component_boolean_data, _uM("defaultValue" to false, "title" to "是否阻止本节点的祖先节点出现点击态", "onChange" to change_stop_propagation_boolean)),
                                _cV(_component_enum_data, _uM("items" to unref(data).start_time_enum, "title" to "按住后多久出现点击态", "onChange" to radio_change_start_time_enum), null, 8, _uA(
                                    "items"
                                )),
                                _cV(_component_enum_data, _uM("items" to unref(data).stay_time_enum, "title" to "手指松开后点击态保留时间", "onChange" to radio_change_stay_time_enum), null, 8, _uA(
                                    "items"
                                ))
                            ))
                        ))
                    ), 4)
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
                return _uM("styled-view-row" to _pS(_uM("flexDirection" to "row", "backgroundImage" to "none", "backgroundColor" to "#ffffff", "justifyContent" to "space-around", "height" to 120, "alignItems" to "center")), "styled-view" to _pS(_uM("width" to 80, "height" to 80, "marginTop" to 5, "marginRight" to 5, "marginBottom" to 5, "marginLeft" to 5, "paddingTop" to 5, "paddingRight" to 5, "paddingBottom" to 5, "paddingLeft" to 5, "borderTopWidth" to 2, "borderRightWidth" to 2, "borderBottomWidth" to 2, "borderLeftWidth" to 2, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#007aff", "borderRightColor" to "#007aff", "borderBottomColor" to "#007aff", "borderLeftColor" to "#007aff", "borderTopLeftRadius" to 8, "borderTopRightRadius" to 8, "borderBottomRightRadius" to 8, "borderBottomLeftRadius" to 8, "backgroundColor" to "#f0f8ff", "boxShadow" to "0 2px 4px rgba(0, 122, 255, 0.2)", "display" to "flex", "flexDirection" to "column", "justifyContent" to "center", "alignItems" to "center", "opacity" to 0.95, "position" to "relative", "transform" to "rotate(45deg)")), "demo-text" to _pS(_uM("fontSize" to 12, "color" to "#007aff", "fontWeight" to "500")), "main" to _pS(_uM("paddingTop" to 5, "paddingRight" to 0, "paddingBottom" to 5, "paddingLeft" to 0, "flexDirection" to "row", "justifyContent" to "center")), "test-view" to _pS(_uM("height" to 200, "width" to 200, "backgroundColor" to "var(--list-background-color,#ffffff)")), "is-hover" to _pS(_uM("backgroundColor" to "#179b16")), "is-parent-hover" to _pS(_uM("backgroundColor" to "#aa0000")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
