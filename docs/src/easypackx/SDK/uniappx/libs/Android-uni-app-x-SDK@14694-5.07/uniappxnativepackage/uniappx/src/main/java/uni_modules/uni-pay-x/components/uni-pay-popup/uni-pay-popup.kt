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
open class GenUniModulesUniPayXComponentsUniPayPopupUniPayPopup : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var maskClick: Boolean by `$props`
    open var type: String by `$props`
    open var open: () -> Unit
        get() {
            return unref(this.`$exposed`["open"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "open", value)
        }
    open var close: () -> Unit
        get() {
            return unref(this.`$exposed`["close"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "close", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesUniPayXComponentsUniPayPopupUniPayPopup, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesUniPayXComponentsUniPayPopupUniPayPopup
            val _cache = __ins.renderCache
            val props = __props
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val isOpen = ref(false)
            fun gen_open_fn() {
                isOpen.value = true
            }
            val open = ::gen_open_fn
            fun gen_close_fn(): Unit {
                isOpen.value = false
                emit("close")
            }
            val close = ::gen_close_fn
            fun gen_clickMask_fn() {
                if (props.maskClick == true) {
                    emit("clickMask")
                    close()
                }
            }
            val clickMask = ::gen_clickMask_fn
            __expose(_uM("open" to open, "close" to close))
            return fun(): Any? {
                return _cE("view", _uM("class" to _nC(_uA(
                    "popup-root",
                    _uA(
                        "popup-" + _ctx.type,
                        if (unref(isOpen)) {
                            "open"
                        } else {
                            "close"
                        }
                    )
                )), "onClick" to clickMask), _uA(
                    _cE("view", _uM("onClick" to withModifiers(fun(){}, _uA(
                        "stop"
                    )), "class" to "popup-box"), _uA(
                        renderSlot(_ctx.`$slots`, "default")
                    ), 8, _uA(
                        "onClick"
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
                return _uM("popup-root" to _uM("" to _uM("position" to "fixed", "top" to 0, "left" to 0, "width" to "100%", "height" to "100%", "flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "backgroundColor" to "rgba(0,0,0,0.4)", "justifyContent" to "center", "alignItems" to "center", "zIndex" to 99, "display" to "none"), ".open" to _uM("display" to "flex")), "popup-bottom" to _pS(_uM("justifyContent" to "flex-end", "alignItems" to "center")), "popup-box" to _pS(_uM("width" to "100%", "justifyContent" to "center", "alignItems" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("close" to null, "clickMask" to null)
        var props = _nP(_uM("maskClick" to _uM("type" to "Boolean", "required" to false, "default" to true), "type" to _uM("type" to "String", "required" to false, "default" to "center")))
        var propsNeedCastKeys = _uA(
            "maskClick",
            "type"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
