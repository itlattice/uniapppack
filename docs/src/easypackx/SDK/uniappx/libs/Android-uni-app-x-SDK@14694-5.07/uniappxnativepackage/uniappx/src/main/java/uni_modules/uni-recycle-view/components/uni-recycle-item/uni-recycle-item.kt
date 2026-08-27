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
open class GenUniModulesUniRecycleViewComponentsUniRecycleItemUniRecycleItem : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var offset: Number by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesUniRecycleViewComponentsUniRecycleItemUniRecycleItem) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesUniRecycleViewComponentsUniRecycleItemUniRecycleItem
            val _cache = __ins.renderCache
            val props = __props
            return fun(): Any? {
                return _cE("view", _uM("class" to "recycle-item", "style" to _nS(_uM("transform" to ("translateY(" + props.offset + "px)")))), _uA(
                    renderSlot(_ctx.`$slots`, "default")
                ), 4)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("recycle-item" to _pS(_uM("position" to "absolute", "left" to 0, "top" to 0, "width" to "100%", "height" to "auto")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("offset" to _uM("type" to "Number", "default" to 0)))
        var propsNeedCastKeys = _uA(
            "offset"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
