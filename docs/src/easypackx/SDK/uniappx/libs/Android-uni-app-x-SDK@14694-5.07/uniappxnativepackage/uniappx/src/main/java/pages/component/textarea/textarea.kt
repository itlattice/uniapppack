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
import io.dcloud.uniapp.extapi.getSystemInfoSync as uni_getSystemInfoSync
open class GenPagesComponentTextareaTextarea : BasePage {
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
    open var data: DataType__27
        get() {
            return unref(this.`$exposed`["data"]) as DataType__27
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var radio_change_inputmode_enum: (checked: Number) -> Unit
        get() {
            return unref(this.`$exposed`["radio_change_inputmode_enum"]) as (checked: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "radio_change_inputmode_enum", value)
        }
    open var getBoundingClientRectForTest: () -> DOMRect?
        get() {
            return unref(this.`$exposed`["getBoundingClientRectForTest"]) as () -> DOMRect?
        }
        set(value) {
            setRefValue(this.`$exposed`, "getBoundingClientRectForTest", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentTextareaTextarea, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentTextareaTextarea
            val _cache = __ins.renderCache
            val data = reactive(DataType__27(value2 = "第一行\n第二行\n第三行\n第四行\n第五行\n第六行\n第七行\n第八行\n第九行\n第十行\n十一行", adjust_position_boolean = false, show_confirm_bar_boolean = false, fixed_boolean = false, auto_height_boolean = false, confirm_hold_boolean = false, focus_boolean = true, auto_focus_boolean = false, default_value = "1\n2\n3\n4\n5\n6", inputmode_enum = _uA(
                ItemType(value = 1, name = "text"),
                ItemType(value = 2, name = "decimal"),
                ItemType(value = 3, name = "numeric"),
                ItemType(value = 4, name = "tel"),
                ItemType(value = 5, name = "search"),
                ItemType(value = 6, name = "email"),
                ItemType(value = 7, name = "url"),
                ItemType(value = 0, name = "none")
            ), confirm_type_list = _uA(
                ItemType(value = 0, name = "return"),
                ItemType(value = 1, name = "done"),
                ItemType(value = 2, name = "send"),
                ItemType(value = 3, name = "search"),
                ItemType(value = 4, name = "next"),
                ItemType(value = 5, name = "go")
            ), cursor_color = "#3393E2", cursor = 0, inputmode_enum_current = 0, confirm_type_current = 0, placeholder_value = "请输入", defaultModel = "123", textareaMaxLengthValue = "", isSelectionFocus = false, selectionStart = -1, selectionEnd = -1, hold_keyboard = false, adjust_position = false, disabled = false, jest_result = false, isAutoTest = false, changeValue = "", textareaRect = null))
            onReady(fun(){
                val textarea = uni_getElementById("uni-textarea")
                data.textareaRect = textarea?.getBoundingClientRect()
                data.textareaRect!!.y += uni_getSystemInfoSync().safeArea.top + 44
            }
            )
            val textarea_click = fun(){
                console.log("组件被点击时触发")
            }
            val textarea_touchstart = fun(){
                console.log("手指触摸动作开始")
            }
            val textarea_touchmove = fun(){
                console.log("手指触摸后移动")
            }
            val textarea_touchcancel = fun(){
                console.log("手指触摸动作被打断，如来电提醒，弹窗")
            }
            val textarea_touchend = fun(){
                console.log("手指触摸动作结束")
            }
            val textarea_tap = fun(){
                console.log("手指触摸后马上离开")
            }
            val textarea_longpress = fun(){
                console.log("如果一个组件被绑定了 longpress 事件，那么当用户长按这个组件时，该事件将会被触发。")
            }
            val textarea_confirm = fun(){
                console.log("点击完成时， 触发 confirm 事件，event.detail = {value: value}")
            }
            val textarea_input = fun(e: UniInputEvent){
                console.log("当键盘输入时，触发 input 事件，event.detail = {value, cursor}， @input 处理函数的返回值并不会反映到 textarea 上")
                data.jest_result = e.detail.value == "1\n2\n3\n4\n5\n61"
            }
            val textarea_linechange = fun(){
                console.log("输入框行数变化时调用，event.detail = {height: 0, height: 0, lineCount: 0}")
            }
            val textarea_blur = fun(){
                console.log("输入框失去焦点时触发，event.detail = {value, cursor}")
            }
            val textarea_keyboardheightchange = fun(){
                console.log("键盘高度发生变化的时候触发此事件，event.detail = {height: height, duration: duration}")
            }
            val textarea_focus = fun(event: UniTextareaFocusEvent){
                data.jest_result = event.detail.height >= 0
            }
            val textarea_change = fun(event: UniInputChangeEvent){
                console.log("textarea_change", event.detail.value)
                data.changeValue = event.detail.value
            }
            val change_adjust_position_boolean = fun(checked: Boolean){
                data.adjust_position_boolean = checked
            }
            val change_show_confirm_bar_boolean = fun(checked: Boolean){
                data.show_confirm_bar_boolean = checked
            }
            val change_fixed_boolean = fun(checked: Boolean){
                data.fixed_boolean = checked
            }
            val change_auto_height_boolean = fun(checked: Boolean){
                data.auto_height_boolean = checked
            }
            val change_confirm_hold_boolean = fun(checked: Boolean){
                data.confirm_hold_boolean = checked
            }
            val change_focus_boolean = fun(checked: Boolean){
                data.focus_boolean = checked
            }
            val change_auto_focus_boolean = fun(checked: Boolean){
                data.auto_focus_boolean = checked
            }
            val change_cursor_color_boolean = fun(checked: Boolean){
                if (checked) {
                    data.cursor_color = "transparent"
                } else {
                    data.cursor_color = "#3393E2"
                }
            }
            val radio_change_inputmode_enum = fun(checked: Number){
                data.inputmode_enum_current = checked
            }
            val radio_change_confirm_type = fun(checked: Number){
                data.confirm_type_current = checked
            }
            val setSelection = fun(selectionStart: Number, selectionEnd: Number){
                data.isSelectionFocus = true
                data.selectionStart = selectionStart
                data.selectionEnd = selectionEnd
            }
            val onSelectionBlurChange = fun(){
                data.isSelectionFocus = false
                data.selectionEnd = 0
            }
            val changeHoldKeyboard = fun(event: UniSwitchChangeEvent){
                val checked = event.detail.value
                data.hold_keyboard = checked
            }
            val changeAdjustPosition = fun(event: UniSwitchChangeEvent){
                val checked = event.detail.value
                data.adjust_position = checked
            }
            val change_disabled_boolean = fun(checked: Boolean){
                data.disabled = checked
            }
            val getBoundingClientRectForTest = fun(): DOMRect? {
                return uni_getElementById("test-width")?.getBoundingClientRect()
            }
            __expose(_uM("data" to data, "radio_change_inputmode_enum" to radio_change_inputmode_enum, "getBoundingClientRectForTest" to getBoundingClientRectForTest))
            return fun(): Any? {
                val _component_boolean_data = resolveEasyComponent("boolean-data", GenComponentsBooleanDataBooleanDataClass)
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_switch = resolveComponent("switch")
                val _component_navigator = resolveComponent("navigator")
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("class" to "main"), _uA(
                        _cE("textarea", _uM("value" to unref(data).default_value, "id" to "uni-textarea", "class" to "uni-textarea", "auto-focus" to true, "focus" to unref(data).focus_boolean, "confirm-hold" to unref(data).confirm_hold_boolean, "auto-height" to unref(data).auto_height_boolean, "fixed" to unref(data).fixed_boolean, "show-confirm-bar" to unref(data).show_confirm_bar_boolean, "adjust-position" to unref(data).adjust_position_boolean, "cursor-color" to unref(data).cursor_color, "cursor" to unref(data).cursor, "placeholder" to unref(data).placeholder_value, "inputmode" to unref(data).inputmode_enum[unref(data).inputmode_enum_current].name, "confirm-type" to unref(data).confirm_type_list[unref(data).confirm_type_current].name, "disabled" to unref(data).disabled, "onClick" to _uA<Any?>(textarea_click, textarea_tap), "onTouchstart" to textarea_touchstart, "onTouchmove" to textarea_touchmove, "onTouchcancel" to textarea_touchcancel, "onTouchend" to textarea_touchend, "onLongpress" to textarea_longpress, "onConfirm" to textarea_confirm, "onInput" to textarea_input, "onLinechange" to textarea_linechange, "onBlur" to textarea_blur, "onKeyboardheightchange" to textarea_keyboardheightchange, "onFocus" to textarea_focus, "onChange" to textarea_change, "style" to _nS(_uM("padding" to "10px", "border" to "1px solid #666", "height" to "200px"))), null, 44, _uA(
                            "value",
                            "focus",
                            "confirm-hold",
                            "auto-height",
                            "fixed",
                            "show-confirm-bar",
                            "adjust-position",
                            "cursor-color",
                            "cursor",
                            "placeholder",
                            "inputmode",
                            "confirm-type",
                            "disabled"
                        ))
                    )),
                    _cE("view", _uM("style" to _nS(_uM("margin-bottom" to "40px"))), _uA(
                        _cV(_component_boolean_data, _uM("defaultValue" to false, "title" to "键盘弹起时，是否自动上推页面（限非 Web 平台）", "onChange" to change_adjust_position_boolean)),
                        _cV(_component_boolean_data, _uM("defaultValue" to false, "title" to "是否自动增高，设置auto-height时，style.height不生效", "onChange" to change_auto_height_boolean)),
                        _cV(_component_boolean_data, _uM("defaultValue" to unref(data).focus_boolean, "title" to "获取焦点", "onChange" to change_focus_boolean), null, 8, _uA(
                            "defaultValue"
                        )),
                        _cV(_component_boolean_data, _uM("defaultValue" to true, "title" to "首次自动获取焦点", "onChange" to change_auto_focus_boolean)),
                        _cV(_component_boolean_data, _uM("defaultValue" to false, "title" to "改变光标颜色为透明", "onChange" to change_cursor_color_boolean)),
                        _cV(_component_boolean_data, _uM("defaultValue" to false, "title" to "设置禁用输入框", "onChange" to change_disabled_boolean)),
                        _cV(_component_enum_data, _uM("items" to unref(data).confirm_type_list, "title" to "confirm-type，设置键盘右下角按钮。", "onChange" to radio_change_confirm_type), null, 8, _uA(
                            "items"
                        )),
                        _cV(_component_boolean_data, _uM("defaultValue" to false, "title" to "点击软键盘右下角按钮时是否保持键盘不收起(confirm-type为return时必然不收起)", "onChange" to change_confirm_hold_boolean)),
                        _cV(_component_enum_data, _uM("items" to unref(data).inputmode_enum, "title" to "input-mode，控制软键盘类型。（仅限 Web 平台符合条件的高版本浏览器或webview）。", "onChange" to radio_change_inputmode_enum), null, 8, _uA(
                            "items"
                        )),
                        _cV(_component_boolean_data, _uM("defaultValue" to false, "title" to "是否显示键盘上方带有“完成”按钮那一栏（仅限小程序平台）", "onChange" to change_show_confirm_bar_boolean)),
                        _cV(_component_boolean_data, _uM("defaultValue" to false, "title" to "如果 textarea 是在一个 position:fixed 的区域，需要显示指定属性 fixed 为 true（仅限小程序平台）", "onChange" to change_fixed_boolean)),
                        _cE("view", _uM("class" to "title-wrap"), _uA(
                            _cE("view", null, "maxlength 输入最大长度为10")
                        )),
                        _cE("view", _uM("class" to "textarea-wrap"), _uA(
                            _cE("textarea", _uM("id" to "textarea-instance-maxlength", "class" to "textarea-instance", "value" to unref(data).textareaMaxLengthValue, "maxlength" to 10), null, 8, _uA(
                                "value"
                            ))
                        )),
                        _cE("view", _uM("class" to "title-wrap"), _uA(
                            _cE("view", null, "cursor-spacing、placeholder-class、placeholder-style例子(harmony 不支持设置 placeholder backgroundColor)")
                        )),
                        _cE("view", _uM("class" to "textarea-wrap"), _uA(
                            _cE("textarea", _uM("id" to "textarea-height-exception", "class" to "textarea-instance", "placeholder" to "底部textarea测试键盘遮挡", "placeholder-class" to "placeholder", "placeholder-style" to "background-color:red", "cursor-spacing" to 300))
                        )),
                        _cE("view", _uM("class" to "title-wrap"), _uA(
                            _cE("view", _uM("onClick" to fun(){
                                setSelection(2, 5)
                            }
                            ), "设置输入框聚焦时光标的起始位置和结束位置（点击生效）", 8, _uA(
                                "onClick"
                            ))
                        )),
                        _cE("view", _uM("class" to "textarea-wrap"), _uA(
                            _cE("textarea", _uM("id" to "textarea-instance-2", "class" to "textarea-instance", "value" to "Hello UniApp X Textarea TestCase", "focus" to unref(data).isSelectionFocus, "selection-start" to unref(data).selectionStart, "selection-end" to unref(data).selectionEnd, "onBlur" to onSelectionBlurChange), null, 40, _uA(
                                "focus",
                                "selection-start",
                                "selection-end"
                            ))
                        )),
                        _cE("view", _uM("class" to "title-wrap"), _uA(
                            _cE("view", null, "设置hold-keyboard"),
                            _cV(_component_switch, _uM("style" to _nS(_uM("margin-left" to "10px")), "onChange" to changeHoldKeyboard, "checked" to unref(data).hold_keyboard), null, 8, _uA(
                                "style",
                                "checked"
                            ))
                        )),
                        _cE("view", _uM("class" to "textarea-wrap"), _uA(
                            _cE("textarea", _uM("class" to "textarea-instance", "hold-keyboard" to unref(data).hold_keyboard), null, 8, _uA(
                                "hold-keyboard"
                            ))
                        )),
                        _cE("view", _uM("class" to "title-wrap"), _uA(
                            _cE("view", null, "同时存在 v-model 和 value")
                        )),
                        _cE("view", _uM("class" to "textarea-wrap"), _uA(
                            _cE("textarea", _uM("id" to "both-model-value", "class" to "textarea-instance", "modelValue" to unref(data).defaultModel, "onInput" to fun(`$event`: UniInputEvent){
                                unref(data).defaultModel = `$event`.detail.value
                            }
                            , "value" to "456"), null, 40, _uA(
                                "modelValue",
                                "onInput"
                            ))
                        )),
                        _cE("view", _uM("class" to "title-wrap"), _uA(
                            _cE("view", null, "设置adjust-position"),
                            _cV(_component_switch, _uM("style" to _nS(_uM("margin-left" to "10px")), "onChange" to changeAdjustPosition, "checked" to unref(data).adjust_position), null, 8, _uA(
                                "style",
                                "checked"
                            ))
                        )),
                        _cE("view", _uM("class" to "textarea-wrap"), _uA(
                            _cE("textarea", _uM("class" to "textarea-instance", "adjust-position" to unref(data).adjust_position), null, 8, _uA(
                                "adjust-position"
                            ))
                        )),
                        if (isTrue(unref(data).isAutoTest)) {
                            _cE("view", _uM("key" to 0, "class" to "textarea-wrap"), _uA(
                                _cE("textarea", _uM("id" to "test-width", "class" to "test-width", "value" to "123456", "placeholder" to ""))
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        _cE("view", _uM("class" to "title-wrap"), _uA(
                            _cE("view", null, "设置line-height")
                        )),
                        _cE("view", _uM("class" to "textarea-wrap"), _uA(
                            _cE("textarea", _uM("class" to "textarea-instance", "style" to _nS(_uM("line-height" to "1.2em")), "value" to "设置line-height为1.2em"), null, 4)
                        )),
                        _cE("view", _uM("class" to "title-wrap"), _uA(
                            _cE("view", null, "设置min-height")
                        )),
                        _cE("view", _uM("class" to "textarea-wrap"), _uA(
                            _cE("textarea", _uM("class" to "textarea-instance", "style" to _nS(_uM("min-height" to "100px")), "value" to unref(data).default_value), null, 12, _uA(
                                "value"
                            ))
                        )),
                        _cE("view", _uM("class" to "title-wrap"), _uA(
                            _cE("view", null, "设置max-height")
                        )),
                        _cE("view", _uM("class" to "textarea-wrap"), _uA(
                            _cE("textarea", _uM("class" to "textarea-instance", "style" to _nS(_uM("max-height" to "50px")), "value" to unref(data).default_value), null, 12, _uA(
                                "value"
                            ))
                        )),
                        _cE("view", _uM("class" to "title-wrap"), _uA(
                            _cE("view", null, "设置min-height与auto-height")
                        )),
                        _cE("view", _uM("class" to "textarea-wrap"), _uA(
                            _cE("textarea", _uM("class" to "textarea-instance", "style" to _nS(_uM("min-height" to "100px")), "auto-height" to "true", "value" to unref(data).default_value), null, 12, _uA(
                                "value"
                            ))
                        )),
                        _cE("view", _uM("class" to "title-wrap"), _uA(
                            _cE("view", null, "设置max-height与auto-height")
                        )),
                        _cE("view", _uM("class" to "textarea-wrap"), _uA(
                            _cE("textarea", _uM("class" to "textarea-instance", "style" to _nS(_uM("max-height" to "50px")), "auto-height" to "true", "value" to unref(data).default_value), null, 12, _uA(
                                "value"
                            ))
                        )),
                        _cE("view", _uM("class" to "title-wrap"), _uA(
                            _cE("view", null, "同时设置value与text-align")
                        )),
                        _cE("view", _uM("class" to "textarea-wrap"), _uA(
                            _cE("textarea", _uM("class" to "textarea-instance", "style" to _nS(_uM("height" to "50px", "text-align" to "right")), "value" to "同时设置value与text-align"), null, 4)
                        )),
                        _cE("view", _uM("class" to "title-wrap"), _uA(
                            _cE("view", null, "scroll-view嵌套textarea滚动")
                        )),
                        _cE("scroll-view", _uM("style" to _nS(_uM("height" to "150px")), "direction" to "vertical"), _uA(
                            _cE("textarea", _uM("class" to "textarea-instance", "adjust-position" to false, "auto-height" to true, "value" to unref(data).value2), null, 8, _uA(
                                "value"
                            ))
                        ), 4),
                        _cE("view", _uM("class" to "textarea-wrap"), _uA(
                            _cE("textarea", _uM("class" to "textarea-instance", "style" to _nS(_uM("height" to "60px", "padding" to "20px")), "value" to "style padding:20px"), null, 4)
                        )),
                        _cE("view", _uM("class" to "title-wrap"), _uA(
                            _cE("view", null, "注册confirm事件，点击换行效果")
                        )),
                        _cE("view", _uM("class" to "textarea-wrap"), _uA(
                            _cE("textarea", _uM("class" to "textarea-instance", "onConfirm" to fun(){}), null, 32)
                        )),
                        _cE("view", _uM("class" to "title-wrap"), _uA(
                            _cE("text", null, "style 设置 font-size:20px")
                        )),
                        _cE("view", _uM("class" to "textarea-wrap"), _uA(
                            _cE("textarea", _uM("class" to "textarea-instance", "style" to _nS(_uM("height" to "60px", "font-size" to "20px")), "placeholder" to "placeholder"), null, 4)
                        )),
                        _cE("view", _uM("style" to _nS(_uM("padding-left" to "10px", "flex-direction" to "column"))), _uA(
                            _cE("text", null, "style 设置 font-size:20px"),
                            _cE("text", null, "placeholder-class 设置 30px")
                        ), 4),
                        _cE("view", _uM("class" to "textarea-wrap"), _uA(
                            _cE("textarea", _uM("class" to "textarea-instance", "style" to _nS(_uM("height" to "60px", "font-size" to "20px")), "placeholder-class" to "placeholder-class", "placeholder" to "placeholder"), null, 4)
                        )),
                        _cE("view", _uM("style" to _nS(_uM("padding-left" to "10px", "flex-direction" to "column"))), _uA(
                            _cE("text", null, "style 设置 font-size:20px"),
                            _cE("text", null, "placeholder-class 设置 30px"),
                            _cE("text", null, "placeholder-style 设置 40px")
                        ), 4),
                        _cE("view", _uM("class" to "textarea-wrap"), _uA(
                            _cE("textarea", _uM("class" to "textarea-instance", "style" to _nS(_uM("height" to "60px", "font-size" to "20px")), "placeholder-class" to "placeholder-class", "placeholder-style" to "font-size:40px", "placeholder" to "placeholder"), null, 4)
                        )),
                        _cE("text", _uM("class" to "uni-title-text"), "textarea样式大合集"),
                        _cE("view", _uM("class" to "textarea-wrap"), _uA(
                            _cE("textarea", _uM("class" to "textarea-all-styles", "value" to "样式效果：文本颜色深蓝色、字号16px、字重400、行高1.5、文本居左对齐；外边距10px、内边距10px；圆角8px；浅蓝色渐变背景、蓝色边框、透明度70%、阴影效果。"))
                        )),
                        _cV(_component_navigator, _uM("url" to "/pages/component/textarea/textarea-performance", "style" to _nS(_uM("margin" to "10px"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("button", _uM("type" to "primary"), " textarea 性能测试 ")
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
                return _uM("main" to _pS(_uM("minHeight" to 100, "paddingTop" to 5, "paddingRight" to 0, "paddingBottom" to 5, "paddingLeft" to 0, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "rgba(0,0,0,0.06)", "flexDirection" to "row", "justifyContent" to "center")), "test-width" to _pS(_uM("width" to 100, "height" to 100, "backgroundColor" to "#00FFFF")), "textarea-wrap" to _pS(_uM("flexDirection" to "row", "justifyContent" to "center")), "title-wrap" to _pS(_uM("flexDirection" to "row", "alignItems" to "center", "marginLeft" to 10)), "textarea-instance" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#666666", "borderRightColor" to "#666666", "borderBottomColor" to "#666666", "borderLeftColor" to "#666666", "marginTop" to 10, "marginRight" to 10, "marginBottom" to 10, "marginLeft" to 10)), "placeholder" to _pS(_uM("backgroundColor" to "#FFFF00")), "placeholder-class" to _pS(_uM("fontSize" to 30)), "textarea-all-styles" to _pS(_uM("color" to "#0008a7", "fontFamily" to "Arial, sans-serif", "fontSize" to 16, "fontWeight" to "400", "lineHeight" to 1.5, "textAlign" to "left", "width" to "90%", "height" to 150, "minWidth" to 200, "minHeight" to 100, "maxHeight" to 300, "marginTop" to 10, "marginRight" to 10, "marginBottom" to 10, "marginLeft" to 10, "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "borderTopLeftRadius" to 8, "borderTopRightRadius" to 8, "borderBottomRightRadius" to 8, "borderBottomLeftRadius" to 8, "backgroundColor" to "#e3f2fd", "backgroundImage" to "linear-gradient(to right, #e3f2fd, #a9d5fa)", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#007aff", "borderRightColor" to "#007aff", "borderBottomColor" to "#007aff", "borderLeftColor" to "#007aff", "opacity" to 0.7, "boxShadow" to "0 2px 4px rgba(0, 0, 0, 0.1)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
