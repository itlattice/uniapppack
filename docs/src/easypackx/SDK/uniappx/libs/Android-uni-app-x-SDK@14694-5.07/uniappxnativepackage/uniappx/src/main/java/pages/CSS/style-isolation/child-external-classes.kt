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
open class GenPagesCSSStyleIsolationChildExternalClasses : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var text: String by `$props`
    open var childClass: Any? by `$props`
    open var boxClass: Any? by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesCSSStyleIsolationChildExternalClasses) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSStyleIsolationChildExternalClasses
            val _cache = __ins.renderCache
            val props = __props
            return fun(): Any? {
                return _cE("view", _uM("class" to _nC(_uA(
                    "single-root-box",
                    props.childClass
                ))), _uA(
                    _cE("text", _uM("class" to "single-root-text"), _tD(props.text), 1),
                    _cE("view", _uM("class" to _nC(_uA(
                        "box",
                        props.boxClass
                    ))), null, 2)
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
                return _uM("single-root-box" to _pS(_uM("backgroundColor" to "#FFF3E0", "paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15, "borderTopLeftRadius" to 8, "borderTopRightRadius" to 8, "borderBottomRightRadius" to 8, "borderBottomLeftRadius" to 8, "borderTopWidth" to 2, "borderRightWidth" to 2, "borderBottomWidth" to 2, "borderLeftWidth" to 2, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#FF9800", "borderRightColor" to "#FF9800", "borderBottomColor" to "#FF9800", "borderLeftColor" to "#FF9800", "marginTop" to 5, "marginRight" to 5, "marginBottom" to 5, "marginLeft" to 5)), "single-root-text" to _pS(_uM("color" to "#E65100", "fontSize" to 14)), "box" to _pS(_uM("width" to 150, "height" to 30, "backgroundColor" to "#d9d1ff", "borderTopWidth" to 2, "borderRightWidth" to 2, "borderBottomWidth" to 2, "borderLeftWidth" to 2, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#9e4ef7", "borderRightColor" to "#9e4ef7", "borderBottomColor" to "#9e4ef7", "borderLeftColor" to "#9e4ef7")))
            }
        var inheritAttrs = false
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("text" to _uM("type" to "String", "required" to false, "default" to "单根节点组件:绿色背景红色描边"), "childClass" to _uM("required" to false, "default" to "", "externalClasses" to true, "skipCheck" to true), "boxClass" to _uM("required" to false, "default" to "", "externalClasses" to true, "skipCheck" to true)))
        var propsNeedCastKeys = _uA(
            "text",
            "childClass",
            "boxClass"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
