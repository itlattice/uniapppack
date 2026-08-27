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
import io.dcloud.uniapp.extapi.`$emit` as uni__emit
import io.dcloud.uniapp.extapi.createSelectorQuery as uni_createSelectorQuery
open class GenPagesAPICreateSelectorQuerySelectorQueryChildMulti : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var selectCount: Number
        get() {
            return unref(this.`$exposed`["selectCount"]) as Number
        }
        set(value) {
            setRefValue(this.`$exposed`, "selectCount", value)
        }
    open var selectAllCount: Number
        get() {
            return unref(this.`$exposed`["selectAllCount"]) as Number
        }
        set(value) {
            setRefValue(this.`$exposed`, "selectAllCount", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPICreateSelectorQuerySelectorQueryChildMulti, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPICreateSelectorQuerySelectorQueryChildMulti
            val _cache = __ins.renderCache
            val instance = getCurrentInstance()!!.proxy!!
            val text1 = ref("")
            val text2 = ref("")
            val text3 = ref("test-text-node")
            val viewCount = ref(0)
            val selectCount = ref(0)
            val selectAllCount = ref(0)
            val show = ref(false)
            val testCounter = ref(0)
            fun gen__dispatchEvent_fn() {
                if (testCounter.value == 2) {
                    uni__emit("childDataReady", selectCount.value, selectAllCount.value)
                }
            }
            val _dispatchEvent = ::gen__dispatchEvent_fn
            onMounted(fun(){
                uni_createSelectorQuery().`in`(instance).select(".selector-query-view").boundingClientRect().exec(fun(ret){
                    text1.value = JSON.stringify(ret, null, 2)
                    if (ret.length == 1) {
                        selectCount.value = ret.length
                    }
                    testCounter.value++
                    _dispatchEvent()
                }
                )
                uni_createSelectorQuery().`in`(instance).selectAll(".selector-query-view").boundingClientRect().exec(fun(ret){
                    text2.value = JSON.stringify(ret, null, 2)
                    if (ret.length == 1) {
                        selectAllCount.value = (ret[0] as UTSArray<NodeInfo>).length
                    }
                    testCounter.value++
                    _dispatchEvent()
                }
                )
            }
            )
            __expose(_uM("selectCount" to selectCount, "selectAllCount" to selectAllCount))
            return fun(): Any? {
                return _cE(Fragment, null, _uA(
                    _cE("view", _uM("class" to "selector-query-view"), _uA(
                        _cE("text", null, "selector-query"),
                        _cE("text", _uM("class" to "text red"), _tD(unref(text1)), 1)
                    )),
                    _cE("view", _uM("class" to "selector-query-view"), _uA(
                        _cE("text", null, "selector-query"),
                        _cE("text", _uM("class" to "text green"), _tD(unref(text2)), 1)
                    )),
                    if (unref(text1).length > 0) {
                        _cE("view", _uM("key" to 0), "1")
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    _cE("text", null, _tD(unref(text3)), 1)
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
                return _uM("green" to _pS(_uM("borderTopWidth" to 3, "borderRightWidth" to 3, "borderBottomWidth" to 3, "borderLeftWidth" to 3, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#008000", "borderRightColor" to "#008000", "borderBottomColor" to "#008000", "borderLeftColor" to "#008000")), "red" to _pS(_uM("borderTopWidth" to 3, "borderRightWidth" to 3, "borderBottomWidth" to 3, "borderLeftWidth" to 3, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#FF0000", "borderRightColor" to "#FF0000", "borderBottomColor" to "#FF0000", "borderLeftColor" to "#FF0000")), "view" to _pS(_uM("borderTopWidth" to 3, "borderRightWidth" to 3, "borderBottomWidth" to 3, "borderLeftWidth" to 3, "borderTopStyle" to "dashed", "borderRightStyle" to "dashed", "borderBottomStyle" to "dashed", "borderLeftStyle" to "dashed", "borderTopColor" to "#00FF00", "borderRightColor" to "#00FF00", "borderBottomColor" to "#00FF00", "borderLeftColor" to "#00FF00", "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10)), "text" to _pS(_uM("marginTop" to 20, "paddingTop" to 5, "paddingRight" to 5, "paddingBottom" to 5, "paddingLeft" to 5)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
