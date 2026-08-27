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
import io.dcloud.uniapp.extapi.createSelectorQuery as uni_createSelectorQuery
open class GenPagesTemplateIssue14765Comp1 : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var id: String by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesTemplateIssue14765Comp1) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesTemplateIssue14765Comp1
            val _cache = __ins.renderCache
            val instance = getCurrentInstance()!!.proxy!!
            val compId = ref("comp1-id")
            val testNode1 = ref(false)
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            onMounted(fun(){
                uni_createSelectorQuery().`in`(instance).select("#comp1-id").boundingClientRect().exec(fun(ret){
                    console.log(ret)
                    testNode1.value = ret.length > 0
                    if (testNode1.value) {
                        console.log("Comp1测试符合预期")
                    } else {
                        console.error("Comp1测试不符合预期")
                    }
                    emit("ready", testNode1.value)
                }
                )
            }
            )
            return fun(): Any? {
                return _cE("view", _uM("id" to unref(compId), "ref" to "uxToastItemRef"), _uA(
                    _cE("text", null, "hello"),
                    renderSlot(_ctx.`$slots`, "default")
                ), 8, _uA(
                    "id"
                ))
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("ready" to null)
        var props = _nP(_uM("id" to _uM("type" to "String", "default" to "")))
        var propsNeedCastKeys = _uA(
            "id"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
