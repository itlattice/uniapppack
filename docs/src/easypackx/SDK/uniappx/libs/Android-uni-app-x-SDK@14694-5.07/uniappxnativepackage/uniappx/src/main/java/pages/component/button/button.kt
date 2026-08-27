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
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
import io.dcloud.uniapp.extapi.openDialogPage as uni_openDialogPage
open class GenPagesComponentButtonButton : BasePage {
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
    open var data: DataType__23
        get() {
            return unref(this.`$exposed`["data"]) as DataType__23
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var checkUniButtonElement: () -> Boolean
        get() {
            return unref(this.`$exposed`["checkUniButtonElement"]) as () -> Boolean
        }
        set(value) {
            setRefValue(this.`$exposed`, "checkUniButtonElement", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentButtonButton, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentButtonButton
            val _cache = __ins.renderCache
            val data = reactive(DataType__23(plain_boolean = false, disabled_boolean = false, default_style = false, size_enum = _uA(
                ItemType(value = 0, name = "default"),
                ItemType(value = 1, name = "mini")
            ), size_enum_current = 0, type_enum = _uA(
                ItemType(value = 0, name = "default"),
                ItemType(value = 1, name = "primary"),
                ItemType(value = 2, name = "warn")
            ), type_enum_current = 0, count = 0, text = "", loading = false))
            onReady(fun(){
                data.text = "uni-app-x"
            }
            )
            val button_click = fun(){
                console.log("组件被点击时触发")
                data.count++
            }
            val button_touchstart = fun(){
                console.log("手指触摸动作开始")
            }
            val button_touchmove = fun(){
                console.log("手指触摸后移动")
            }
            val button_touchcancel = fun(){
                console.log("手指触摸动作被打断，如来电提醒，弹窗")
            }
            val button_touchend = fun(){
                console.log("手指触摸动作结束")
            }
            val button_tap = fun(){
                console.log("手指触摸后马上离开")
            }
            val button_longpress = fun(){
                console.log("如果一个组件被绑定了 longpress 事件，那么当用户长按这个组件时，该事件将会被触发。")
            }
            val change_plain_boolean = fun(checked: Boolean){
                data.plain_boolean = checked
            }
            val change_loading = fun(checked: Boolean){
                data.loading = checked
            }
            val change_disabled_boolean = fun(checked: Boolean){
                data.disabled_boolean = checked
            }
            val change_default_style = fun(checked: Boolean){
                data.default_style = checked
            }
            val radio_change_size_enum = fun(checked: Number){
                data.size_enum_current = checked
            }
            val radio_change_type_enum = fun(checked: Number){
                data.type_enum_current = checked
            }
            val confirm_text_input = fun(value: String){
                data.text = value
            }
            val navigateToChild = fun(){
                uni_navigateTo(NavigateToOptions(url = "buttonstatus"))
            }
            val openPrivacyDialog = fun(){
                uni_openDialogPage(OpenDialogPageOptions(url = "/pages/component/button/privacy"))
            }
            val checkUniButtonElement = fun(): Boolean {
                val button = uni_getElementById("testButton")
                if (button != null && button is UniButtonElement) {
                    return true
                }
                return false
            }
            __expose(_uM("data" to data, "checkUniButtonElement" to checkUniButtonElement))
            return fun(): Any? {
                val _component_boolean_data = resolveEasyComponent("boolean-data", GenComponentsBooleanDataBooleanDataClass)
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                val _component_navigator = resolveComponent("navigator")
                return _cE(Fragment, null, _uA(
                    _cE("view", _uM("class" to "main"), _uA(
                        _cE("button", _uM("id" to "testButton", "loading" to unref(data).loading, "disabled" to unref(data).disabled_boolean, "size" to unref(data).size_enum[unref(data).size_enum_current].name, "type" to unref(data).type_enum[unref(data).type_enum_current].name, "plain" to unref(data).plain_boolean, "onTouchstart" to button_touchstart, "onTouchmove" to button_touchmove, "onTouchcancel" to button_touchcancel, "onTouchend" to button_touchend, "onClick" to _uA<Any?>(button_tap, button_click), "onLongpress" to button_longpress, "class" to _nC(_uA(
                            "btn",
                            if (unref(data).default_style) {
                                if (unref(data).disabled_boolean) {
                                    "custom-btn-disable"
                                } else {
                                    "custom-btn"
                                }
                            } else {
                                ""
                            }
                        )), "hover-class" to if (unref(data).default_style) {
                            "is-hover"
                        } else {
                            "button-hover"
                        }
                        ), _tD(unref(data).text), 43, _uA(
                            "loading",
                            "disabled",
                            "size",
                            "type",
                            "plain",
                            "hover-class"
                        ))
                    )),
                    _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                        _cE("view", _uM("class" to "content"), _uA(
                            _cV(_component_boolean_data, _uM("defaultValue" to false, "title" to "按钮是否镂空，背景色透明", "onChange" to change_plain_boolean)),
                            _cV(_component_boolean_data, _uM("defaultValue" to false, "title" to "是否禁用", "onChange" to change_disabled_boolean)),
                            _cV(_component_boolean_data, _uM("defaultValue" to false, "title" to "修改默认样式和点击效果(高优先)", "onChange" to change_default_style)),
                            _cV(_component_boolean_data, _uM("defaultValue" to false, "title" to "显示loading（限小程序和蒸汽模式的App）", "onChange" to change_loading)),
                            _cV(_component_enum_data, _uM("items" to unref(data).size_enum, "title" to "按钮的大小", "onChange" to radio_change_size_enum), null, 8, _uA(
                                "items"
                            )),
                            _cV(_component_enum_data, _uM("items" to unref(data).type_enum, "title" to "按钮的类型", "onChange" to radio_change_type_enum), null, 8, _uA(
                                "items"
                            )),
                            _cV(_component_input_data, _uM("defaultValue" to unref(data).text, "title" to "按钮的文案", "type" to "text", "onConfirm" to confirm_text_input), null, 8, _uA(
                                "defaultValue"
                            )),
                            _cE("view", _uM("style" to _nS(_uM("height" to "10px"))), null, 4),
                            _cE("button", _uM("onClick" to navigateToChild), "更多button示例"),
                            _cE("view", _uM("style" to _nS(_uM("height" to "10px"))), null, 4),
                            _cE("button", _uM("onClick" to openPrivacyDialog), "open-type实现App隐私政策弹框"),
                            _cE("view", _uM("style" to _nS(_uM("height" to "10px"))), null, 4)
                        )),
                        _cV(_component_navigator, _uM("url" to "/pages/template/button-100/button-100"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("button", null, "组件性能测试")
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
                return _uM("main" to _pS(_uM("paddingTop" to 5, "paddingRight" to 0, "paddingBottom" to 5, "paddingLeft" to 0, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "rgba(0,0,0,0.06)", "flexDirection" to "row", "justifyContent" to "center")), "custom-btn" to _pS(_uM("color" to "#ffffff", "backgroundColor" to "#1AAD19", "borderTopColor" to "#1AAD19", "borderRightColor" to "#1AAD19", "borderBottomColor" to "#1AAD19", "borderLeftColor" to "#1AAD19")), "custom-btn-disable" to _pS(_uM("color" to "rgba(255,255,255,0.7)", "backgroundColor" to "rgba(26,173,25,0.7)", "borderTopColor" to "rgba(26,173,25,0.7)", "borderRightColor" to "rgba(26,173,25,0.7)", "borderBottomColor" to "rgba(26,173,25,0.7)", "borderLeftColor" to "rgba(26,173,25,0.7)")), "is-hover" to _pS(_uM("color" to "rgba(255,255,255,0.6)", "backgroundColor" to "#179b16", "borderTopColor" to "#179b16", "borderRightColor" to "#179b16", "borderBottomColor" to "#179b16", "borderLeftColor" to "#179b16")), "button-hover" to _pS(_uM("color" to "rgba(0,0,0,0.6)", "backgroundColor" to "#dedede")), "default-button" to _pS(_uM("color" to "#000000", "backgroundColor" to "#f8f8f8", "borderTopColor" to "rgba(0,0,0,0.2)", "borderRightColor" to "rgba(0,0,0,0.2)", "borderBottomColor" to "rgba(0,0,0,0.2)", "borderLeftColor" to "rgba(0,0,0,0.2)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
