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
open class GenPagesTemplateIssue14765Issue14765 : BasePage {
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
    open var data: DataType__115
        get() {
            return unref(this.`$exposed`["data"]) as DataType__115
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesTemplateIssue14765Issue14765, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesTemplateIssue14765Issue14765
            val _cache = __ins.renderCache
            val instance = getCurrentInstance()!!.proxy!!
            val id1 = ref("page-id-1")
            val id2 = ref("page-id-2")
            val data = reactive(DataType__115(testNode1 = false, testNode2 = false))
            fun gen_onComp1Ready_fn(testNode1Val: Boolean) {
                data.testNode1 = testNode1Val
            }
            val onComp1Ready = ::gen_onComp1Ready_fn
            onReady(fun(){
                uni_createSelectorQuery().`in`(instance).select("#page-id-2").boundingClientRect().exec(fun(ret){
                    console.log(ret)
                    data.testNode2 = ret.length > 0
                    if (data.testNode2) {
                        console.log("Comp2测试符合预期")
                    } else {
                        console.error("Comp2测试不符合预期")
                    }
                }
                )
            }
            )
            __expose(_uM("data" to data))
            return fun(): Any? {
                val _component_page_intro = resolveEasyComponent("page-intro", GenComponentsPageIntroPageIntroClass)
                return _cE("view", null, _uA(
                    _cV(_component_page_intro, _uM("content" to "本页为 issue-14765 示例：Comp1、Comp2 子组件与 getElementById 等测试。")),
                    _cV(unref(GenPagesTemplateIssue14765Comp1Class), _uM("id" to unref(id1), "onReady" to onComp1Ready), null, 8, _uA(
                        "id"
                    )),
                    _cV(unref(GenPagesTemplateIssue14765Comp2Class), _uM("id" to unref(id2)), null, 8, _uA(
                        "id"
                    ))
                ))
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
