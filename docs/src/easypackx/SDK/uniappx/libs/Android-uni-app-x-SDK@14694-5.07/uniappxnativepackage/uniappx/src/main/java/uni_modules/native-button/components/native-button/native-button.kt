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
import uts.sdk.modules.nativeButton.NativeButton
open class GenUniModulesNativeButtonComponentsNativeButtonNativeButton : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var text: String by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesNativeButtonComponentsNativeButtonNativeButton) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesNativeButtonComponentsNativeButtonNativeButton
            val _cache = __ins.renderCache
            var button: NativeButton? = null
            val props = __props
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            fun gen_updateText_fn(value: String) {
                button?.updateText(value)
            }
            val updateText = ::gen_updateText_fn
            watchEffect(fun(){
                val text = props.text
                updateText(text)
            }
            )
            fun gen_onviewinit_fn(e: UniNativeViewInitEvent) {
                button = NativeButton(e.detail.element)
                updateText(props.text)
                emit("load")
            }
            val onviewinit = ::gen_onviewinit_fn
            fun gen_ontap_fn(e: UniNativeViewEvent) {
                emit("buttonTap", e)
            }
            val ontap = ::gen_ontap_fn
            fun gen_onUnmounted_fn() {
                button?.destroy()
            }
            val onUnmounted__1 = ::gen_onUnmounted_fn
            return fun(): Any? {
                return _cE("view", null, _uA(
                    _cE("native-view", _uM("style" to _nS(_uM("height" to "100px")), "onInit" to onviewinit, "on:customClick" to ontap), null, 36),
                    _cE("view", _uM("style" to _nS(_uM("width" to "50%", "height" to "100px"))), _uA(
                        _cE("button", null, "测试按钮")
                    ), 4)
                ))
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("load" to null, "buttonTap" to null)
        var props = _nP(_uM("text" to _uM("type" to "String", "required" to true)))
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
