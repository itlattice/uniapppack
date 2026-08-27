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
open class GenUniModulesUniRateComponentsUniRateUniRate : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var value: Number? by `$props`
    open var modelValue: Number? by `$props`
    open var full: Boolean? by `$props`
    open var readonly: Boolean? by `$props`
    open var plain: Boolean? by `$props`
    open var starClass: Any? by `$props`
    open var starStyle: String? by `$props`
    open var starActiveClass: Any? by `$props`
    open var starActiveStyle: String? by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesUniRateComponentsUniRateUniRate) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesUniRateComponentsUniRateUniRate
            val _cache = __ins.renderCache
            val props = __props
            val stars = computed(fun(): String {
                if (props.full != true) {
                    val value = Math.max(0, Math.min(5, props.value ?: 0))
                    return "★".repeat(Math.round(value))
                } else {
                    return if (props.plain == true) {
                        "☆".repeat(5)
                    } else {
                        "★".repeat(5)
                    }
                }
            }
            )
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val currentValue = ref<Number>(0)
            currentValue.value = props.modelValue ?: props.value ?: 0
            watch(fun(): Number? {
                return props.modelValue ?: props.value ?: null
            }
            , fun(newValue: Number?){
                if (newValue != null && UTSAndroid.`typeof`(newValue) === "number" && !isNaN(newValue as Number)) {
                    currentValue.value = newValue as Number
                }
            }
            , WatchOptions(immediate = true))
            val calculatedWidth = computed(fun(): String {
                val value = currentValue.value
                val rate = Math.max(0, Math.min(5, value))
                return "" + (rate / 5) * 100 + "%"
            }
            )
            fun gen_onTap_fn(event: UniPointerEvent): Unit {
                if (props.readonly == true) {
                    return
                }
                var clickX = event.x
                var containerWidth: Number = 0
                try {
                    if (event.currentTarget?.offsetWidth != null && (event.currentTarget as UniElement).offsetWidth > 0) {
                        containerWidth = (event.currentTarget as UniElement).offsetWidth
                    }
                }
                 catch (e: Throwable) {
                    console.log("e: ", e)
                }
                val finalValue = Math.round(clickX / containerWidth * 5)
                currentValue.value = finalValue
                emit("change", finalValue)
                emit("update:modelValue", finalValue)
            }
            val onTap = ::gen_onTap_fn
            return fun(): Any? {
                return if (props.full != true) {
                    _cE("text", _uM("key" to 0, "class" to _nC(_uA(
                        "active-color",
                        props.starActiveClass ?: ""
                    )), "style" to _nS(props.starActiveStyle ?: "")), _tD(unref(stars)), 7)
                } else {
                    _cE("view", _uM("key" to 1, "style" to _nS(_uM("position" to "relative", "align-self" to "flex-start")), "onClick" to onTap), _uA(
                        _cE("text", _uM("class" to _nC(_uA(
                            "stars-pos gray-stars",
                            props.starClass ?: ""
                        )), "style" to _nS(props.starStyle ?: "")), _tD(unref(stars)), 7),
                        _cE("view", _uM("class" to "stars-pos active-init-width", "style" to _nS("width:" + unref(calculatedWidth))), _uA(
                            if (isTrue(props.full)) {
                                _cE("text", _uM("key" to 0, "class" to _nC(_uA(
                                    "active-color",
                                    props.starActiveClass ?: ""
                                )), "style" to _nS("white-space: nowrap; align-self: flex-start;" + props.starStyle + ";" + props.starActiveStyle)), "★★★★★", 6)
                            } else {
                                _cC("v-if", true)
                            }
                        ), 4)
                    ), 4)
                }
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("stars-pos" to _pS(_uM("position" to "absolute", "top" to 0, "left" to 0, "whiteSpace" to "nowrap", "overflow" to "hidden")), "gray-stars" to _pS(_uM("color" to "#cccccc", "position" to "relative")), "active-init-width" to _pS(_uM("width" to "0%")), "active-color" to _pS(_uM("color" to "#ffca3e")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("change" to null, "update:modelValue" to null)
        var props = _nP(_uM("value" to _uM("type" to "Number", "required" to false), "modelValue" to _uM("type" to "Number", "required" to false), "full" to _uM("type" to "Boolean", "required" to false), "readonly" to _uM("type" to "Boolean", "required" to false), "plain" to _uM("type" to "Boolean", "required" to false), "starClass" to _uM("required" to false), "starStyle" to _uM("type" to "String", "required" to false), "starActiveClass" to _uM("required" to false), "starActiveStyle" to _uM("type" to "String", "required" to false)))
        var propsNeedCastKeys = _uA(
            "full",
            "readonly",
            "plain"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
