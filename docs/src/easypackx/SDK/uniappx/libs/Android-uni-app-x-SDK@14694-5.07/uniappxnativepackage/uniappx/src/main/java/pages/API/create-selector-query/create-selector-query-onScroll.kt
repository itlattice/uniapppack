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
open class GenPagesAPICreateSelectorQueryCreateSelectorQueryOnScroll : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onLoad(fun(_: OnLoadOptions) {
            stat_instance.onLoad(this)
        }
        , __ins)
        onPageShow(fun() {
            stat_instance.onShow(this)
        }
        , __ins)
        onPageHide(fun() {
            stat_instance.onHide(this)
        }
        , __ins)
        onUnload(fun() {
            stat_instance.onUnload(this)
        }
        , __ins)
    }
    open var data: DataType__102
        get() {
            return unref(this.`$exposed`["data"]) as DataType__102
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPICreateSelectorQueryCreateSelectorQueryOnScroll, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPICreateSelectorQueryCreateSelectorQueryOnScroll
            val _cache = __ins.renderCache
            val instance = getCurrentInstance()!!.proxy!!
            val count = ref(0)
            val data = reactive(DataType__102(ret = true))
            fun gen_onScroll_fn() {
                count.value++
                console.log("scroll: ", count.value)
                uni_createSelectorQuery().`in`(instance).selectAll("content-item").boundingClientRect().exec(fun(result){
                    count.value--
                }
                )
                console.log("scroll: ", count.value)
                if (count.value > 0) {
                    data.ret = false
                }
            }
            val onScroll = ::gen_onScroll_fn
            onLoad(fun(_options){})
            __expose(_uM("data" to data))
            return fun(): Any? {
                return _cE("scroll-view", _uM("onScroll" to onScroll, "style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE(Fragment, null, RenderHelpers.renderList(60, fun(i, __key, __index, _cached): Any {
                        return _cE("view", _uM("class" to "content-item"), _uA(
                            _cE("text", _uM("class" to "text"), "item-" + _tD(i), 1)
                        ))
                    }
                    ), 64)
                ), 36)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
