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
import io.dcloud.uniapp.extapi.navigateBack as uni_navigateBack
open class GenComponentsUniBackArrowCircleUniBackArrowCircle : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var arrowClass: Any? by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsUniBackArrowCircleUniBackArrowCircle) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsUniBackArrowCircleUniBackArrowCircle
            val _cache = __ins.renderCache
            val props = __props
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val handleClick = fun(){
                emit("click")
                uni_navigateBack(NavigateBackOptions())
            }
            return fun(): Any? {
                return _cE("view", _uM("class" to "back-circle", "onClick" to handleClick), _uA(
                    _cE("view", _uM("class" to _nC(_uA(
                        "back-arrow",
                        props.arrowClass
                    ))), null, 2)
                ))
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("back-circle" to _pS(_uM("width" to 28, "height" to 28, "borderTopLeftRadius" to 14, "borderTopRightRadius" to 14, "borderBottomRightRadius" to 14, "borderBottomLeftRadius" to 14, "backgroundColor" to "rgba(220,220,220,0.3)", "justifyContent" to "center", "alignItems" to "center", "marginTop" to 6, "marginRight" to 6, "marginBottom" to 6, "marginLeft" to 6, "paddingLeft" to 4)), "back-arrow" to _pS(_uM("width" to 12, "height" to 12, "transform" to "rotate(45deg)", "borderLeftWidth" to 2, "borderLeftStyle" to "solid", "borderLeftColor" to "#000000", "borderBottomWidth" to 2, "borderBottomStyle" to "solid", "borderBottomColor" to "#000000")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("click" to null)
        var props = _nP(_uM("arrowClass" to _uM("required" to false, "default" to "", "externalClasses" to true, "skipCheck" to true)))
        var propsNeedCastKeys = _uA(
            "arrowClass"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
