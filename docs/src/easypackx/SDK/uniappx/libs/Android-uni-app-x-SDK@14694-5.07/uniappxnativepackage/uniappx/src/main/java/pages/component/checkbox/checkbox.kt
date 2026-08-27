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
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesComponentCheckboxCheckbox : BasePage {
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
    open var data: DataType__25
        get() {
            return unref(this.`$exposed`["data"]) as DataType__25
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentCheckboxCheckbox, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentCheckboxCheckbox
            val _cache = __ins.renderCache
            val data = reactive(DataType__25(items = _uA(
                ItemType__2(value = "CHN", name = "中国", checked = true),
                ItemType__2(value = "USA", name = "美国", checked = false),
                ItemType__2(value = "BRA", name = "巴西", checked = false),
                ItemType__2(value = "JPN", name = "日本", checked = false),
                ItemType__2(value = "ENG", name = "英国", checked = false),
                ItemType__2(value = "FRA", name = "法国", checked = false)
            ), testEvent = false, text = "未选中", wrapText = "uni-app x，终极跨平台方案\nuts，大一统语言", value = _uA(), disabled = true, checked = true, color = "#007aff", iconColor = "#211cfe", foreColor = "#ff0000", checked_boolean = false, disabled_boolean = false, color_input = "#007aff", backgroundColor_input = "#ffffff", borderColor_input = "#d1d1d1", activeBackgroundColor_input = "#ffffff", activeBorderColor_input = "#d1d1d1", iconColor_input = "#007aff", foreColor_input = "#ff0000"))
            val checkboxChange = fun(e: UniCheckboxGroupChangeEvent){
                if ((e.target?.tagName ?: "") == "CHECKBOX-GROUP" && e.type === "change") {
                    data.testEvent = true
                }
                val selectedNames: UTSArray<String> = _uA()
                data.items.forEach(fun(item){
                    if (e.detail.value.includes(item.value)) {
                        selectedNames.push(item.name)
                    }
                }
                )
                uni_showToast(ShowToastOptions(icon = "none", title = "当前选中:" + selectedNames.join(",")))
            }
            val testChange = fun(e: UniCheckboxGroupChangeEvent){
                data.value = e.detail.value
            }
            val checkbox_click = fun(){
                console.log("组件被点击时触发")
            }
            val checkbox_touchstart = fun(){
                console.log("手指触摸动作开始")
            }
            val checkbox_touchmove = fun(){
                console.log("手指触摸后移动")
            }
            val checkbox_touchcancel = fun(){
                console.log("手指触摸动作被打断，如来电提醒，弹窗")
            }
            val checkbox_touchend = fun(){
                console.log("手指触摸动作结束")
            }
            val checkbox_tap = fun(){
                console.log("手指触摸后马上离开")
            }
            val checkbox_longpress = fun(){
                console.log("如果一个组件被绑定了 longpress 事件，那么当用户长按这个组件时，该事件将会被触发。")
            }
            val change_checked_boolean = fun(checked: Boolean){
                data.checked_boolean = checked
            }
            val change_disabled_boolean = fun(checked: Boolean){
                data.disabled_boolean = checked
            }
            val confirm_color_input = fun(value: String){
                data.color_input = value
            }
            val confirm_backgroundColor_input = fun(value: String){
                data.backgroundColor_input = value
            }
            val confirm_borderColor_input = fun(value: String){
                data.borderColor_input = value
            }
            val confirm_activeBackgroundColor_input = fun(value: String){
                data.activeBackgroundColor_input = value
            }
            val confirm_activeBorderColor_input = fun(value: String){
                data.activeBorderColor_input = value
            }
            val confirm_iconColor_input = fun(value: String){
                data.iconColor_input = value
            }
            val confirm_foreColor_input = fun(value: String){
                data.foreColor_input = value
            }
            __expose(_uM("data" to data))
            return fun(): Any? {
                val _component_checkbox = resolveComponent("checkbox")
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                val _component_boolean_data = resolveEasyComponent("boolean-data", GenComponentsBooleanDataBooleanDataClass)
                val _component_checkbox_group = resolveComponent("checkbox-group")
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                val _component_navigator = resolveComponent("navigator")
                return _cE(Fragment, null, _uA(
                    _cE("view", _uM("class" to "main"), _uA(
                        _cV(_component_checkbox, _uM("disabled" to unref(data).disabled_boolean, "checked" to unref(data).checked_boolean, "color" to unref(data).color_input, "iconColor" to unref(data).iconColor_input, "foreColor" to unref(data).foreColor_input, "backgroundColor" to unref(data).backgroundColor_input, "borderColor" to unref(data).borderColor_input, "activeBackgroundColor" to unref(data).activeBackgroundColor_input, "activeBorderColor" to unref(data).activeBorderColor_input, "onClick" to _uA(
                            checkbox_click,
                            checkbox_tap
                        ), "onTouchstart" to checkbox_touchstart, "onTouchmove" to checkbox_touchmove, "onTouchcancel" to checkbox_touchcancel, "onTouchend" to checkbox_touchend, "onLongpress" to checkbox_longpress), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("text", null, "uni-app-x")
                            )
                        }
                        ), "_" to 1), 8, _uA(
                            "disabled",
                            "checked",
                            "color",
                            "iconColor",
                            "foreColor",
                            "backgroundColor",
                            "borderColor",
                            "activeBackgroundColor",
                            "activeBorderColor"
                        ))
                    )),
                    _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                        _cE("view", _uM("class" to "content"), _uA(
                            _cV(_component_page_head, _uM("title" to "组件属性")),
                            _cV(_component_boolean_data, _uM("defaultValue" to false, "title" to "当前是否选中，可用来设置默认选中", "onChange" to change_checked_boolean)),
                            _cV(_component_boolean_data, _uM("defaultValue" to false, "title" to "是否禁用", "onChange" to change_disabled_boolean))
                        )),
                        _cE("view", null, _uA(
                            _cV(_component_page_head, _uM("title" to "默认及使用")),
                            _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt"), _uA(
                                _cE("view", _uM("class" to "uni-title uni-common-mt"), _uA(
                                    _cE("text", _uM("class" to "uni-title-text"), " 默认样式 ")
                                )),
                                _cE("view", null, _uA(
                                    _cV(_component_checkbox_group, _uM("class" to "uni-flex uni-row checkbox-group", "onChange" to testChange, "style" to _nS(_uM("flex-wrap" to "wrap"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_checkbox, _uM("value" to "cb", "checked" to unref(data).checked, "color" to unref(data).color, "iconColor" to unref(data).iconColor, "foreColor" to unref(data).foreColor, "style" to _nS(_uM("margin-right" to "15px")), "class" to "checkbox cb"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    "选中 "
                                                )
                                            }
                                            ), "_" to 1), 8, _uA(
                                                "checked",
                                                "color",
                                                "iconColor",
                                                "foreColor",
                                                "style"
                                            )),
                                            _cV(_component_checkbox, _uM("value" to "cb1", "style" to _nS(_uM("margin-right" to "15px")), "class" to "checkbox cb1"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _tD(unref(data).text)
                                                )
                                            }
                                            ), "_" to 1), 8, _uA(
                                                "style"
                                            )),
                                            _cV(_component_checkbox, _uM("value" to "cb2", "disabled" to unref(data).disabled, "class" to "checkbox cb2"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    "禁用"
                                                )
                                            }
                                            ), "_" to 1), 8, _uA(
                                                "disabled"
                                            )),
                                            _cV(_component_checkbox, _uM("value" to "cb3", "style" to _nS(_uM("margin-top" to "10px")), "class" to "checkbox cb3"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _tD(unref(data).wrapText)
                                                )
                                            }
                                            ), "_" to 1), 8, _uA(
                                                "style"
                                            ))
                                        )
                                    }
                                    ), "_" to 1), 8, _uA(
                                        "style"
                                    ))
                                )),
                                _cE("view", _uM("class" to "uni-title uni-common-mt"), _uA(
                                    _cE("text", _uM("class" to "uni-title-text"), " 不同颜色和尺寸的checkbox ")
                                )),
                                _cE("view", null, _uA(
                                    _cV(_component_checkbox_group, _uM("class" to "uni-flex uni-row checkbox-group"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_checkbox, _uM("value" to "cb1", "checked" to true, "color" to "#FFCC33", "style" to _nS(_uM("transform" to "scale(0.7)", "margin-right" to "15px")), "class" to "checkbox"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    "选中 "
                                                )
                                            }
                                            ), "_" to 1), 8, _uA(
                                                "style"
                                            )),
                                            _cV(_component_checkbox, _uM("value" to "cb", "color" to "#FFCC33", "style" to _nS(_uM("transform" to "scale(0.7)")), "class" to "checkbox"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    "未选中"
                                                )
                                            }
                                            ), "_" to 1), 8, _uA(
                                                "style"
                                            ))
                                        )
                                    }
                                    ), "_" to 1))
                                )),
                                _cE("view", _uM("class" to "uni-title uni-common-mt"), _uA(
                                    _cE("text", _uM("class" to "uni-title-text"), " 两端对齐样式测试 ")
                                )),
                                _cE("view", null, _uA(
                                    _cV(_component_checkbox_group, _uM("class" to "uni-flex uni-row checkbox-group"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_checkbox, _uM("class" to "justify-test"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    "justify-content样式测试"
                                                )
                                            }
                                            ), "_" to 1))
                                        )
                                    }
                                    ), "_" to 1))
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                                _cE("view", _uM("class" to "uni-title uni-common-mt"), _uA(
                                    _cE("text", _uM("class" to "uni-title-text"), " 推荐展示样式 ")
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-list uni-common-pl"), _uA(
                                _cV(_component_checkbox_group, _uM("onChange" to checkboxChange, "class" to "checkbox-group", "id" to "trigger-change"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cE(Fragment, null, RenderHelpers.renderList(unref(data).items, fun(item, index, __index, _cached): Any {
                                            return _cV(_component_checkbox, _uM("class" to _nC(_uA(
                                                "uni-list-cell uni-list-cell-pd checkbox",
                                                _uA(
                                                    if (index < unref(data).items.length - 1) {
                                                        "uni-list-cell-line"
                                                    } else {
                                                        ""
                                                    }
                                                    ,
                                                    "checkbox-item-" + index
                                                )
                                            )), "key" to item.value, "value" to item.value, "checked" to item.checked), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _tD(item.name)
                                                )
                                            }
                                            ), "_" to 2), 1032, _uA(
                                                "value",
                                                "checked",
                                                "class"
                                            ))
                                        }
                                        ), 128)
                                    )
                                }
                                ), "_" to 1))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cV(_component_input_data, _uM("defaultValue" to "#007aff", "title" to "checkbox的颜色", "type" to "text", "onConfirm" to confirm_color_input)),
                            _cV(_component_input_data, _uM("defaultValue" to "#ffffff", "title" to "checkbox默认的背景颜色", "type" to "text", "onConfirm" to confirm_backgroundColor_input)),
                            _cV(_component_input_data, _uM("defaultValue" to "#d1d1d1", "title" to "checkbox默认的边框颜色", "type" to "text", "onConfirm" to confirm_borderColor_input)),
                            _cV(_component_input_data, _uM("defaultValue" to "#ffffff", "title" to "checkbox选中时的背景颜色", "type" to "text", "onConfirm" to confirm_activeBackgroundColor_input)),
                            _cV(_component_input_data, _uM("defaultValue" to "#d1d1d1", "title" to "checkbox选中时的边框颜色", "type" to "text", "onConfirm" to confirm_activeBorderColor_input)),
                            _cV(_component_input_data, _uM("defaultValue" to "#007aff", "title" to "iconColor: checkbox的图标颜色，优先级大于color属性", "type" to "text", "onConfirm" to confirm_iconColor_input)),
                            _cV(_component_input_data, _uM("defaultValue" to "#ff0000", "title" to "foreColor: checkbox的图标颜色，优先级大于color属性", "type" to "text", "onConfirm" to confirm_foreColor_input))
                        )),
                        _cV(_component_navigator, _uM("class" to "uni-common-mb", "url" to "/pages/template/checkbox-200/checkbox-200"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("button", _uM("class" to "uni-common-mt"), "组件性能测试")
                            )
                        }
                        ), "_" to 1))
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
                return _uM("main" to _pS(_uM("maxHeight" to 250, "paddingTop" to 5, "paddingRight" to 0, "paddingBottom" to 5, "paddingLeft" to 0, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "rgba(0,0,0,0.06)", "flexDirection" to "row", "justifyContent" to "center")), "uni-list-cell" to _pS(_uM("justifyContent" to "flex-start")), "justify-test" to _pS(_uM("width" to "100%", "justifyContent" to "space-between")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
