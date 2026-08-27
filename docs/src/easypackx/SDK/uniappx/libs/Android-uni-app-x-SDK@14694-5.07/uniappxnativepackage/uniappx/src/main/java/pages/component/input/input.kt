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
open class GenPagesComponentInputInput : BasePage {
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
    open var data: DataType__26
        get() {
            return unref(this.`$exposed`["data"]) as DataType__26
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var triggerFocusOrBlur: () -> Unit
        get() {
            return unref(this.`$exposed`["triggerFocusOrBlur"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "triggerFocusOrBlur", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentInputInput, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentInputInput
            val _cache = __ins.renderCache
            val data = reactive(DataType__26(title = "input", firstInputFocus = false, showClearIcon = false, inputClearValue = "", showPassword = true, cursor = -1, cursorInputFocus = false, cursor_color = "#3393E2", cursorColorInputFocus = false, selectionStart = -1, selectionEnd = -1, selectionInputFocus = false, inputEventDetail = "", focusAndBlurEventDetail = "", confirmEventDetail = "", changeEventDetail = "", keyboardHeightChangeEventDetail = "", focus = true, inputPassword = true, inputTypeTel = "tel", inputPlaceHolderStyle = "color:red", placeholderStyle = "font-family: AlimamaDaoLiTiOTF;font-weight: bold;text-align: right", inputPlaceHolderClass = "uni-input-placeholder-class", inputMaxLengthValue = "", onMaxLengthInputValue = "", inputMaxLengthFocus = false, inputPasswordValue = "cipher", inputFocusKeyBoardChangeValue = true, holdKeyboard = false, keyboardHeight = 0, focusedForKeyboardHeightChangeTest = false, demoValue = "123", demoValue2 = "123", adjustPosition = false, syncDisplayValue = "", triggerFocus = false, triggerBlur = false, showTypeNoneAndFocusCase = false))
            val inputFocusKeyBoardChange = fun(e: UniInputKeyboardHeightChangeEvent){
                data.inputFocusKeyBoardChangeValue = e.detail.height > 50
            }
            val onMaxLengthInput = fun(event: UniInputEvent){
                data.onMaxLengthInputValue = event.detail.value
            }
            val setCursor = fun(cursor: Number){
                data.cursorInputFocus = true
                data.cursor = cursor
            }
            val onCursorBlurChange = fun(){
                data.cursor = 0
                data.cursorInputFocus = false
            }
            val setSelection = fun(selectionStart: Number, selectionEnd: Number){
                data.selectionInputFocus = true
                data.selectionStart = selectionStart
                data.selectionEnd = selectionEnd
            }
            val onSelectionBlurChange = fun(){
                data.selectionEnd = 0
                data.selectionInputFocus = false
            }
            val clearInput = fun(event: UniInputEvent){
                data.inputClearValue = event.detail.value
                if (event.detail.value.length > 0) {
                    data.showClearIcon = true
                } else {
                    data.showClearIcon = false
                }
            }
            val clearIcon = fun(){
                data.inputClearValue = ""
                data.showClearIcon = false
            }
            val changePassword = fun(){
                data.showPassword = !data.showPassword
            }
            val onInput = fun(event: UniInputEvent){
                console.log("键盘输入", JSON.stringify(event.detail))
                data.inputEventDetail = JSON.stringify(event.detail)
            }
            val onFocus = fun(event: UniInputFocusEvent){
                data.triggerFocus = true
                console.log("输入框聚焦", JSON.stringify(event.detail))
                data.focusAndBlurEventDetail = JSON.stringify(event.detail)
            }
            val onBlur = fun(event: UniInputBlurEvent){
                data.triggerBlur = true
                console.log("输入框失去焦点", JSON.stringify(event.detail))
                data.focusAndBlurEventDetail = JSON.stringify(event.detail)
            }
            val onConfirm = fun(event: UniInputConfirmEvent){
                console.log("点击完成按钮", JSON.stringify(event.detail))
                data.confirmEventDetail = JSON.stringify(event.detail)
            }
            val onChange = fun(event: UniInputChangeEvent){
                console.log("输入内容变化", JSON.stringify(event.detail))
                data.changeEventDetail = JSON.stringify(event.detail)
            }
            val onKeyboardHeightChange = fun(event: UniInputKeyboardHeightChangeEvent){
                console.log("键盘高度发生变化", JSON.stringify(event.detail))
                data.keyboardHeightChangeEventDetail = JSON.stringify(event.detail)
                data.keyboardHeight = event.detail.height
            }
            val changeCursorColor = fun(event: UniSwitchChangeEvent){
                val checked = event.detail.value
                if (checked) {
                    data.cursor_color = "#FF0000"
                } else {
                    data.cursor_color = "#3393E2"
                }
                data.cursorColorInputFocus = true
            }
            val cursorColorInputBlur = fun(event: UniInputBlurEvent){
                data.cursorColorInputFocus = false
            }
            val changeHoldKeyboard = fun(event: UniSwitchChangeEvent){
                val checked = event.detail.value
                data.holdKeyboard = checked
            }
            val changeAdjustPosition = fun(event: UniSwitchChangeEvent){
                val checked = event.detail.value
                data.adjustPosition = checked
            }
            val triggerFocusOrBlur = fun(){
                val input = uni_getElementById("trigger-focus-blur-input")!!
                if (data.triggerFocus) {
                    data.triggerFocus = false
                    input.blur()
                } else {
                    data.triggerBlur = false
                    input.focus()
                }
            }
            val changeCheckedTypeNoneAndFocusCase = fun(checked: Boolean){
                data.showTypeNoneAndFocusCase = checked
            }
            __expose(_uM("data" to data, "triggerFocusOrBlur" to triggerFocusOrBlur))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                val _component_switch = resolveComponent("switch")
                val _component_boolean_data = resolveEasyComponent("boolean-data", GenComponentsBooleanDataBooleanDataClass)
                val _component_navigator = resolveComponent("navigator")
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cV(_component_page_head, _uM("title" to unref(data).title), null, 8, _uA(
                        "title"
                    )),
                    _cE("view", _uM("class" to "uni-common-mt uni-padding-wrap", "style" to _nS(_uM("padding-bottom" to "30px"))), _uA(
                        _cE("view", null, _uA(
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "设置输入框的初始内容")
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("id" to "uni-input-default", "focus" to unref(data).firstInputFocus, "class" to "uni-input", "value" to "hello uni-app x"), null, 8, _uA(
                                    "focus"
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "type取值（不同输入法表现可能不一致）")
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("id" to "uni-input-type-text", "class" to "uni-input", "type" to "text", "placeholder" to "文本输入键盘"))
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("id" to "uni-input-type-number", "class" to "uni-input", "type" to "number", "placeholder" to "数字输入键盘"))
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("id" to "uni-input-type-digit", "class" to "uni-input", "type" to "digit", "placeholder" to "带小数点的数字输入键盘"))
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("id" to "uni-input-type-tel", "class" to "uni-input", "type" to unref(data).inputTypeTel, "placeholder" to "电话输入键盘"), null, 8, _uA(
                                    "type"
                                ))
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("id" to "uni-input-type-search", "class" to "uni-input", "type" to "search", "placeholder" to "搜索输入键盘"))
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("id" to "uni-input-type-email", "class" to "uni-input", "type" to "email", "placeholder" to "邮箱输入键盘"))
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("id" to "uni-input-type-url", "class" to "uni-input", "type" to "url", "placeholder" to "url输入键盘"))
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("id" to "uni-input-type-none", "class" to "uni-input", "type" to "none", "placeholder" to "聚焦但不弹出键盘"))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "密码输入框")
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("id" to "uni-input-password", "class" to "uni-input", "password" to unref(data).inputPassword, "type" to "text", "value" to unref(data).inputPasswordValue), null, 8, _uA(
                                    "password",
                                    "value"
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "无value设置的密码输入框")
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("class" to "uni-input", "password" to true, "type" to "text"))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "占位符样式")
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("id" to "uni-input-placeholder1", "class" to "uni-input", "placeholder-style" to unref(data).inputPlaceHolderStyle, "placeholder" to "占位符文字颜色为红色"), null, 8, _uA(
                                    "placeholder-style"
                                ))
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("id" to "uni-input-placeholder2", "class" to "uni-input", "placeholder-class" to unref(data).inputPlaceHolderClass, "placeholder" to "占位符字体大小为10px"), null, 8, _uA(
                                    "placeholder-class"
                                ))
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("id" to "uni-input-placeholder3", "class" to "uni-input", "placeholder-class" to "", "placeholder" to "placeholder-class 传入空字符串"))
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("class" to "uni-input", "placeholder-style" to unref(data).inputPlaceHolderStyle, "value" to "不设置placeholder只设置placeholder-style"), null, 8, _uA(
                                    "placeholder-style"
                                ))
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("id" to "uni-input-placeholder2", "style" to _nS(_uM("font-family" to "AlimamaDaoLiTiOTF", "font-weight" to "bold", "text-align" to "right")), "class" to "uni-input", "placeholder-style" to unref(data).placeholderStyle, "placeholder" to "占位符以及内容右对齐"), null, 12, _uA(
                                    "placeholder-style"
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "设置禁用输入框")
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("id" to "uni-input-disable", "class" to "uni-input", "disabled" to true, "value" to "禁用状态 input"))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "设置最大输入长度")
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("id" to "uni-input-maxlength", "class" to "uni-input", "maxlength" to 10, "placeholder" to "最大输入长度为10", "value" to unref(data).inputMaxLengthValue, "onInput" to onMaxLengthInput, "focus" to unref(data).inputMaxLengthFocus), null, 40, _uA(
                                    "value",
                                    "focus"
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "设置光标与键盘的距离")
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("class" to "uni-input", "cursor-spacing" to 1000, "placeholder" to "光标与键盘的距离为1000px"))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "自动获取焦点")
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("id" to "uni-input-focus", "class" to "uni-input", "focus" to unref(data).focus, "onKeyboardheightchange" to inputFocusKeyBoardChange), null, 40, _uA(
                                    "focus"
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "confirm-type取值（不同输入法表现可能不一致）")
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("id" to "uni-input-confirm-send", "class" to "uni-input", "confirmType" to "send", "placeholder" to "键盘右下角按钮显示为发送"))
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("id" to "uni-input-confirm-search", "class" to "uni-input", "confirmType" to "search", "placeholder" to "键盘右下角按钮显示为搜索"))
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("id" to "uni-input-confirm-next", "class" to "uni-input", "confirmType" to "next", "placeholder" to "键盘右下角按钮显示为下一个"))
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("id" to "uni-input-confirm-go", "class" to "uni-input", "confirmType" to "go", "placeholder" to "键盘右下角按钮显示为前往"))
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("id" to "uni-input-confirm-done", "class" to "uni-input", "confirmType" to "done", "placeholder" to "键盘右下角按钮显示为完成"))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "点击键盘右下角按钮时保持键盘不收起")
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("class" to "uni-input", "confirm-hold" to true))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("view", _uM("class" to "uni-title", "onClick" to fun(){
                                setCursor(4)
                            }
                            ), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "设置输入框聚焦时光标的位置（点这里）")
                            ), 8, _uA(
                                "onClick"
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("ref" to "input", "class" to "uni-input", "value" to "0123456789", "focus" to unref(data).cursorInputFocus, "cursor" to unref(data).cursor, "onBlur" to onCursorBlurChange), null, 40, _uA(
                                    "focus",
                                    "cursor"
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("view", _uM("class" to "uni-title", "onClick" to fun(){
                                setSelection(0, 4)
                            }
                            ), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "设置输入框聚焦时光标的起始位置和结束位置（点这里）")
                            ), 8, _uA(
                                "onClick"
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("ref" to "input2", "class" to "uni-input", "value" to "0123456789", "selection-start" to unref(data).selectionStart, "selection-end" to unref(data).selectionEnd, "focus" to unref(data).selectionInputFocus, "onBlur" to onSelectionBlurChange), null, 40, _uA(
                                    "selection-start",
                                    "selection-end",
                                    "focus"
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("view", _uM("class" to "uni-title", "style" to _nS(_uM("flex-direction" to "row", "align-items" to "center"))), _uA(
                                _cE("text", _uM("class" to "uni-title-text", "style" to _nS(_uM("flex-shrink" to "1"))), "设置光标颜色为红色（Android的微信小程序非skyline下仅支持黑和绿）", 4),
                                _cV(_component_switch, _uM("style" to _nS(_uM("margin-left" to "10px")), "onChange" to changeCursorColor, "checked" to (unref(data).cursor_color == "#FF0000")), null, 8, _uA(
                                    "style",
                                    "checked"
                                ))
                            ), 4),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("id" to "uni-input-cursor-color", "class" to "uni-input", "cursor-color" to unref(data).cursor_color, "focus" to unref(data).cursorColorInputFocus, "onBlur" to cursorColorInputBlur, "value" to "光标颜色"), null, 40, _uA(
                                    "cursor-color",
                                    "focus"
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "键盘弹起时，自动上推页面")
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("class" to "uni-input", "adjust-position" to true))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("view", _uM("class" to "uni-title", "style" to _nS(_uM("flex-direction" to "row", "align-items" to "center"))), _uA(
                                _cE("text", _uM("class" to "uni-title-text", "style" to _nS(_uM("flex-shrink" to "1"))), "设置hold-keyboard", 4),
                                _cV(_component_switch, _uM("style" to _nS(_uM("margin-left" to "10px")), "onChange" to changeHoldKeyboard, "checked" to unref(data).holdKeyboard), null, 8, _uA(
                                    "style",
                                    "checked"
                                ))
                            ), 4),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("class" to "uni-input", "hold-keyboard" to unref(data).holdKeyboard, "value" to "hold keyboard "), null, 8, _uA(
                                    "hold-keyboard"
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "通过 style 设置 padding")
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("class" to "uni-input", "style" to _nS(_uM("height" to "60px", "padding" to "20px")), "value" to "style padding:20px", "placeholder" to "style padding:20px"), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "input事件"),
                                if (isTrue(unref(data).inputEventDetail)) {
                                    _cE("text", _uM("key" to 0, "class" to "uni-subtitle-text"), _tD(unref(data).inputEventDetail), 1)
                                } else {
                                    _cC("v-if", true)
                                }
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("class" to "uni-input", "onInput" to onInput), null, 32)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-title-text", "onClick" to triggerFocusOrBlur), "点击触发focus事件或blur事件"),
                                if (isTrue(unref(data).focusAndBlurEventDetail)) {
                                    _cE("text", _uM("key" to 0, "class" to "uni-subtitle-text"), _tD(unref(data).focusAndBlurEventDetail), 1)
                                } else {
                                    _cC("v-if", true)
                                }
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("id" to "trigger-focus-blur-input", "class" to "uni-input", "onFocus" to onFocus, "onBlur" to onBlur), null, 32)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "confirm事件"),
                                if (isTrue(unref(data).confirmEventDetail)) {
                                    _cE("text", _uM("key" to 0, "class" to "uni-subtitle-text"), _tD(unref(data).confirmEventDetail), 1)
                                } else {
                                    _cC("v-if", true)
                                }
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("class" to "uni-input", "onConfirm" to onConfirm), null, 32)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "change事件"),
                                if (isTrue(unref(data).changeEventDetail)) {
                                    _cE("text", _uM("key" to 0, "class" to "uni-subtitle-text"), _tD(unref(data).changeEventDetail), 1)
                                } else {
                                    _cC("v-if", true)
                                }
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("class" to "uni-input", "onChange" to onChange), null, 32)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "带清除按钮的输入框")
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("class" to "uni-input", "placeholder" to "带清除按钮的输入框", "value" to unref(data).inputClearValue, "onInput" to clearInput), null, 40, _uA(
                                    "value"
                                )),
                                if (isTrue(unref(data).showClearIcon)) {
                                    _cE("image", _uM("key" to 0, "class" to "uni-icon", "src" to "/static/icons/clear.png", "onClick" to clearIcon))
                                } else {
                                    _cC("v-if", true)
                                }
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "可查看密码的输入框")
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("class" to "uni-input", "placeholder" to "请输入密码", "password" to unref(data).showPassword), null, 8, _uA(
                                    "password"
                                )),
                                _cE("image", _uM("class" to "uni-icon", "src" to if (!unref(data).showPassword) {
                                    "/static/icons/eye-active.png"
                                } else {
                                    "/static/icons/eye.png"
                                }
                                , "onClick" to changePassword), null, 8, _uA(
                                    "src"
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "同时存在 v-model 和 value")
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("id" to "both-model-value", "class" to "uni-input", "modelValue" to unref(data).demoValue, "onInput" to fun(`$event`: UniInputEvent){
                                    unref(data).demoValue = `$event`.detail.value
                                }
                                , "value" to "456"), null, 40, _uA(
                                    "modelValue",
                                    "onInput"
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "同时存在 v-model 和 change事件")
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("class" to "uni-input", "modelValue" to unref(data).demoValue2, "onInput" to fun(`$event`: UniInputEvent){
                                    unref(data).demoValue2 = `$event`.detail.value
                                }
                                , "value" to "123", "onChange" to onChange), null, 40, _uA(
                                    "modelValue",
                                    "onInput"
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("view", _uM("class" to "uni-title", "style" to _nS(_uM("flex-direction" to "row", "align-items" to "center"))), _uA(
                                _cE("text", _uM("class" to "uni-title-text", "style" to _nS(_uM("flex-shrink" to "1"))), "设置adjust-position", 4),
                                _cV(_component_switch, _uM("style" to _nS(_uM("margin-left" to "10px")), "onChange" to changeAdjustPosition, "checked" to unref(data).adjustPosition), null, 8, _uA(
                                    "style",
                                    "checked"
                                ))
                            ), 4),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("class" to "uni-input", "adjust-position" to unref(data).adjustPosition), null, 8, _uA(
                                    "adjust-position"
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "输入内容的同步更新UI")
                            )),
                            _cE("text", null, _tD(unref(data).syncDisplayValue), 1),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("class" to "uni-input", "modelValue" to unref(data).syncDisplayValue, "onInput" to fun(`$event`: UniInputEvent){
                                    unref(data).syncDisplayValue = `$event`.detail.value
                                }
                                ), null, 40, _uA(
                                    "modelValue",
                                    "onInput"
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "maxlength初始化生效")
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("class" to "uni-input", "maxlength" to 5, "value" to "123456789"))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "focus时type是none，键盘是否弹出"),
                                _cV(_component_boolean_data, _uM("defaultValue" to false, "title" to "显示<input />示例", "onChange" to changeCheckedTypeNoneAndFocusCase))
                            )),
                            if (isTrue(unref(data).showTypeNoneAndFocusCase)) {
                                _cE("view", _uM("key" to 0, "class" to "input-wrapper"), _uA(
                                    _cE("input", _uM("class" to "uni-input", "focus" to "true", "type" to "none"))
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                        )),
                        _cE("view", null, _uA(
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "style 设置 font-size:20px")
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("class" to "uni-input", "style" to _nS(_uM("font-size" to "20px")), "placeholder" to "placeholder"), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "style 设置 font-size:20px"),
                                _cE("text", _uM("class" to "uni-title-text"), "placeholder-class 设置 30px")
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("class" to "uni-input", "style" to _nS(_uM("font-size" to "20px")), "placeholder-class" to "placeholder-class", "placeholder" to "placeholder"), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "style 设置 font-size:20px"),
                                _cE("text", _uM("class" to "uni-title-text"), "placeholder-class 设置 30px"),
                                _cE("text", _uM("class" to "uni-title-text"), "placeholder-style 设置 40px")
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("class" to "uni-input", "style" to _nS(_uM("font-size" to "20px")), "placeholder-class" to "placeholder-class", "placeholder-style" to "font-size:40px", "placeholder" to "placeholder"), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "keyboardheightchange事件"),
                                if (isTrue(unref(data).keyboardHeightChangeEventDetail)) {
                                    _cE("text", _uM("key" to 0, "class" to "uni-subtitle-text"), _tD(unref(data).keyboardHeightChangeEventDetail), 1)
                                } else {
                                    _cC("v-if", true)
                                }
                            )),
                            _cE("view", _uM("class" to "input-wrapper"), _uA(
                                _cE("input", _uM("class" to "uni-input", "onKeyboardheightchange" to onKeyboardHeightChange, "focus" to unref(data).focusedForKeyboardHeightChangeTest), null, 40, _uA(
                                    "focus"
                                ))
                            ))
                        )),
                        _cE("text", _uM("class" to "uni-title-text"), "input样式大合集"),
                        _cE("view", _uM("class" to "input-wrap"), _uA(
                            _cE("input", _uM("class" to "input-all-styles", "value" to "样式效果：文本颜色深蓝色、字号16px、字重400、文本居左对齐；外边距10px、内边距10px；圆角8px；浅蓝色渐变背景、蓝色边框、透明度70%、阴影效果。"))
                        )),
                        _cV(_component_navigator, _uM("url" to "/pages/component/input/input-performance", "style" to _nS(_uM("margin-top" to "10px"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("button", _uM("type" to "primary"), " input 性能测试 ")
                            )
                        }
                        ), "_" to 1), 8, _uA(
                            "style"
                        ))
                    ), 4)
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
                return _uM("input-wrapper" to _pS(_uM("display" to "flex", "paddingTop" to 8, "paddingRight" to 13, "paddingBottom" to 8, "paddingLeft" to 13, "marginTop" to 5, "marginRight" to 0, "marginBottom" to 5, "marginLeft" to 0, "flexDirection" to "row", "flexWrap" to "nowrap", "backgroundColor" to "#ffffff")), "uni-input" to _pS(_uM("height" to 28, "fontSize" to 15, "paddingTop" to 0, "paddingRight" to 0, "paddingBottom" to 0, "paddingLeft" to 0, "flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "backgroundColor" to "#ffffff")), "uni-icon" to _pS(_uM("width" to 24, "height" to 24)), "uni-input-placeholder-class" to _pS(_uM("fontSize" to 10)), "placeholder-class" to _pS(_uM("fontSize" to 30)), "input-wrap" to _pS(_uM("flexDirection" to "row", "justifyContent" to "center")), "input-all-styles" to _pS(_uM("color" to "#0008a7", "fontFamily" to "Arial, sans-serif", "fontSize" to 16, "fontWeight" to "400", "textAlign" to "left", "width" to "90%", "height" to 40, "minWidth" to 200, "marginTop" to 10, "marginRight" to 10, "marginBottom" to 10, "marginLeft" to 10, "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "borderTopLeftRadius" to 8, "borderTopRightRadius" to 8, "borderBottomRightRadius" to 8, "borderBottomLeftRadius" to 8, "backgroundColor" to "#e3f2fd", "backgroundImage" to "linear-gradient(to right, #e3f2fd, #a9d5fa)", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#007aff", "borderRightColor" to "#007aff", "borderBottomColor" to "#007aff", "borderLeftColor" to "#007aff", "opacity" to 0.7, "boxShadow" to "0 2px 4px rgba(0, 0, 0, 0.1)")), "@FONT-FACE" to _uM("0" to _uM("fontFamily" to "AlimamaDaoLiTiOTF", "src" to "url('/static/font/AlimamaDaoLiTi.otf')")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
