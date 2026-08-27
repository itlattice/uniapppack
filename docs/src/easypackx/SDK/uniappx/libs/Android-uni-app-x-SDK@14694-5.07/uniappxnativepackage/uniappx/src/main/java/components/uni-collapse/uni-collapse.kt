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
open class GenComponentsUniCollapseUniCollapse : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var accordion: Boolean by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsUniCollapseUniCollapse) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsUniCollapseUniCollapse
            val _cache = __ins.renderCache
            val props = __props
            var child_nodes = _uA<ItemChildType>()
            fun gen_registerChild_fn(child: ItemChildType) {
                child_nodes.push(child)
            }
            val registerChild = ::gen_registerChild_fn
            fun gen_toggle_fn(elId: String) {
                if (props.accordion && child_nodes.length > 0) {
                    child_nodes.forEach(fun(item: ItemChildType){
                        val is_open = item.is_open.value as Boolean
                        if (is_open && item.elId != elId) {
                            item.is_open.value = false
                            item.openOrClose(false)
                        }
                    }
                    )
                }
            }
            val toggle = ::gen_toggle_fn
            provide("uni-collapse-register-child", registerChild)
            provide("k-collapse-child-toggle", toggle)
            return fun(): Any? {
                return _cE("view", null, _uA(
                    renderSlot(_ctx.`$slots`, "default")
                ))
            }
        }
        var name = "UniCollapse"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("accordion" to _uM("type" to "Boolean", "default" to true)))
        var propsNeedCastKeys = _uA(
            "accordion"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
