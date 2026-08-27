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
open class GenPagesCSSStyleIsolationChildMultiTag : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var text: String by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesCSSStyleIsolationChildMultiTag) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSStyleIsolationChildMultiTag
            val _cache = __ins.renderCache
            val attrs = useAttrs()
            val hasClassAttr = computed(fun(): Boolean {
                return attrs["class"] != null
            }
            )
            val hasStyleAttr = computed(fun(): Boolean {
                return attrs["style"] != null
            }
            )
            return fun(): Any? {
                return _cE(Fragment, null, _uA(
                    _cE("view", _uM("class" to _nC(_uA(
                        "multi-root-box",
                        _ctx.`$attrs`["class"]
                    ))), _uA(
                        _cE("text", _uM("class" to "multi-root-text"), "hasClassAttr"),
                        _cE("text", _uM("class" to "multi-root-text"), _tD(unref(hasClassAttr)), 1)
                    ), 2),
                    _cE("view", _uM("class" to "multi-root-box", "style" to _nS(_ctx.`$attrs`["style"] ?: "")), _uA(
                        _cE("text", _uM("class" to "multi-root-text"), "hasStyleAttr"),
                        _cE("text", _uM("class" to "multi-root-text"), _tD(unref(hasStyleAttr)), 1)
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
                return _uM("multi-root-box" to _pS(_uM("backgroundColor" to "#FFF3E0", "paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15, "borderTopLeftRadius" to 8, "borderTopRightRadius" to 8, "borderBottomRightRadius" to 8, "borderBottomLeftRadius" to 8, "borderTopWidth" to 2, "borderRightWidth" to 2, "borderBottomWidth" to 2, "borderLeftWidth" to 2, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#FF9800", "borderRightColor" to "#FF9800", "borderBottomColor" to "#FF9800", "borderLeftColor" to "#FF9800", "marginTop" to 5, "marginRight" to 5, "marginBottom" to 5, "marginLeft" to 5, "flexDirection" to "row")), "multi-root-text" to _pS(_uM("color" to "#E65100", "fontSize" to 14, "marginTop" to 0, "marginRight" to 20, "marginBottom" to 0, "marginLeft" to 20)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("text" to _uM("type" to "String", "required" to true)))
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
