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
open class GenPagesAPICreateSelectorQueryNodesInfoChild : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var data: DataType__100
        get() {
            return unref(this.`$exposed`["data"]) as DataType__100
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPICreateSelectorQueryNodesInfoChild, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPICreateSelectorQueryNodesInfoChild
            val _cache = __ins.renderCache
            val instance = getCurrentInstance()!!.proxy!!
            val data = reactive(DataType__100(top = 0))
            onMounted(fun(){
                uni_createSelectorQuery().`in`(instance).select(".selector-query-child-view").boundingClientRect().exec(fun(ret){
                    if (ret.length == 1) {
                        val nodeInfo = ret[0] as NodeInfo
                        data.top = nodeInfo.top!!
                    }
                }
                )
            }
            )
            __expose(_uM("data" to data))
            return fun(): Any? {
                return _cE("view", _uM("class" to "selector-query-child-view"), _uA(
                    _cE("text", _uM("class" to "selector-query-child-text"), "selector-query-child")
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
                return _uM("selector-query-child-view" to _pS(_uM("marginTop" to 15)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
