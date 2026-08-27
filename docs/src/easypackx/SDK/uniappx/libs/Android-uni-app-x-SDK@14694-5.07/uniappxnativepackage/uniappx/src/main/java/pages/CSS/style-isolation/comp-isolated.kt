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
open class GenPagesCSSStyleIsolationCompIsolated : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesCSSStyleIsolationCompIsolated) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSStyleIsolationCompIsolated
            val _cache = __ins.renderCache
            return fun(): Any? {
                return _cE("view", _uM("class" to "component-container"), _uA(
                    _cE("view", _uM("class" to "global-box page-box com-box"), _uA(
                        _cE("text", _uM("class" to "com-text"), "多样式，只显示组件自身样式（紫色）")
                    )),
                    _cE("view", _uM("class" to "global-box"), _uA(
                        _cE("text", _uM("class" to "com-text global-text"), "全局样式(预期默认字体大小16px)")
                    )),
                    _cE("view", _uM("class" to "page-box"), _uA(
                        _cE("text", _uM("class" to "com-text page-text"), "页面样式(预期默认字体大小16px)")
                    )),
                    _cE("view", _uM("class" to "com-box"), _uA(
                        _cE("text", _uM("class" to "com-text"), "组件样式")
                    ))
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
                return _uM("com-box" to _pS(_uM("backgroundColor" to "#d9d1ff", "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "marginTop" to 10, "marginRight" to 10, "marginBottom" to 10, "marginLeft" to 10, "borderTopLeftRadius" to 8, "borderTopRightRadius" to 8, "borderBottomRightRadius" to 8, "borderBottomLeftRadius" to 8, "borderTopWidth" to 2, "borderRightWidth" to 2, "borderBottomWidth" to 2, "borderLeftWidth" to 2, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#9e4ef7", "borderRightColor" to "#9e4ef7", "borderBottomColor" to "#9e4ef7", "borderLeftColor" to "#9e4ef7")), "com-text" to _pS(_uM("color" to "#9e4ef7", "fontSize" to 16)), "component-container" to _pS(_uM("marginTop" to 10, "marginRight" to 10, "marginBottom" to 10, "marginLeft" to 10)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
