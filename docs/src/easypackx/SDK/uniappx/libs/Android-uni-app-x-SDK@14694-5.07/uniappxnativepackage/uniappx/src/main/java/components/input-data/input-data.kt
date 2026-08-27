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
open class GenComponentsInputDataInputData : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var title: String by `$props`
    open var type: String by `$props`
    open var defaultValue: String by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsInputDataInputData) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsInputDataInputData
            val _cache = __ins.renderCache
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val props = __props
            val inputClearValue = ref<InputValue>("")
            val showClearIcon = ref(false)
            val inputType = ref("text")
            fun _getValue(value: Any): InputValue {
                when (props.type) {
                    "number" -> 
                        return parseFloat(value as String)
                }
                return value
            }
            onMounted(fun(){
                when (props.type) {
                    "number" -> 
                        inputType.value = "number"
                }
                inputClearValue.value = _getValue(props.defaultValue)
            }
            )
            fun gen_input_fn(event: InputEvent) {
                inputClearValue.value = event.detail.value
                if ((inputClearValue.value as String).length > 0) {
                    showClearIcon.value = true
                } else {
                    showClearIcon.value = false
                }
                emit("confirm", _getValue(inputClearValue.value as String))
            }
            val input = ::gen_input_fn
            fun gen_clearIcon_fn() {
                inputClearValue.value = ""
                showClearIcon.value = false
                emit("confirm", _getValue(inputClearValue.value as String))
            }
            val clearIcon = ::gen_clearIcon_fn
            fun gen_blur_fn() {
                showClearIcon.value = false
            }
            val blur = ::gen_blur_fn
            fun gen_focus_fn() {
                var inputValue = inputClearValue.value
                if (UTSAndroid.`typeof`(inputValue) !== "string") {
                    inputValue = (inputValue as Number).toString()
                }
                if ((inputValue as String).length > 0) {
                    showClearIcon.value = true
                } else {
                    showClearIcon.value = false
                }
            }
            val focus = ::gen_focus_fn
            return fun(): Any? {
                return _cE(Fragment, null, _uA(
                    _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                        _cE("view", _uM("class" to "uni-title uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), _tD(_ctx.title), 1)
                        ))
                    )),
                    _cE("view", _uM("class" to "input-wrapper"), _uA(
                        _cE("input", _uM("class" to "uni-input", "type" to unref(inputType), "value" to unref(inputClearValue), "placeholder" to _ctx.title, "maxlength" to -1, "onInput" to input, "onBlur" to blur, "onFocus" to focus), null, 40, _uA(
                            "type",
                            "value",
                            "placeholder"
                        )),
                        if (isTrue(unref(showClearIcon))) {
                            _cE("image", _uM("key" to 0, "class" to "input-wrapper_image", "src" to "/static/icons/clear.png", "onTouchstart" to clearIcon), null, 32)
                        } else {
                            _cC("v-if", true)
                        }
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
                return _uM("input-wrapper" to _pS(_uM("borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "rgba(0,0,0,0.08)", "borderRightColor" to "rgba(0,0,0,0.08)", "borderBottomColor" to "rgba(0,0,0,0.08)", "borderLeftColor" to "rgba(0,0,0,0.08)", "flexDirection" to "row", "justifyContent" to "center", "paddingTop" to 0, "paddingRight" to 0, "paddingBottom" to 0, "paddingLeft" to 0, "marginTop" to 0, "marginRight" to 10, "marginBottom" to 0, "marginLeft" to 10, "flexWrap" to "nowrap", "backgroundColor" to "#ffffff")), "input-wrapper_image" to _pS(_uM("width" to 22, "height" to 22, "alignSelf" to "center", "marginRight" to 5)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("confirm" to null)
        var props = _nP(_uM("title" to _uM("type" to "String", "required" to true), "type" to _uM("type" to "String", "required" to true), "defaultValue" to _uM("type" to "String", "required" to true, "default" to "")))
        var propsNeedCastKeys = _uA(
            "defaultValue"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
