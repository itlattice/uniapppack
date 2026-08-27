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
open class GenComponentsBooleanDataBooleanData : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var title: String by `$props`
    open var disabled: Boolean by `$props`
    open var defaultValue: Boolean by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsBooleanDataBooleanData) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsBooleanDataBooleanData
            val _cache = __ins.renderCache
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val props = __props
            val isDarkMode = computed(fun(): Boolean {
                return state.isDarkMode
            }
            )
            val _checked = ref(false)
            onMounted(fun(){
                _checked.value = props.defaultValue
            }
            )
            fun gen__change_fn(e: UniSwitchChangeEvent) {
                _checked.value = e.detail.value
                emit("change", _checked.value)
            }
            val _change = ::gen__change_fn
            return fun(): Any? {
                val _component_switch = resolveComponent("switch")
                return _cE("view", _uM("class" to _nC(_uA(
                    "button-data-main uni-flex",
                    if (unref(isDarkMode)) {
                        "theme-dark"
                    } else {
                        "theme-light"
                    }
                ))), _uA(
                    _cE("text", _uM("class" to "uni-title", "style" to _nS(_uM("width" to "80%"))), _tD(_ctx.title), 5),
                    _cV(_component_switch, _uM("checked" to unref(_checked), "disabled" to _ctx.disabled, "color" to if (unref(isDarkMode)) {
                        "#a8a8b7"
                    } else {
                        "#007AFF"
                    }
                    , "onChange" to _change), null, 8, _uA(
                        "checked",
                        "disabled",
                        "color"
                    ))
                ), 2)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("button-data-main" to _pS(_uM("justifyContent" to "space-between", "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "var(--border-color, rgba(0, 0, 0, .06))", "alignItems" to "center")), "uni-title" to _pS(_uM("color" to "var(--text-color, #333333)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("change" to null)
        var props = _nP(_uM("title" to _uM("type" to "String", "default" to ""), "disabled" to _uM("type" to "Boolean", "default" to false), "defaultValue" to _uM("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = _uA(
            "title",
            "disabled",
            "defaultValue"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
