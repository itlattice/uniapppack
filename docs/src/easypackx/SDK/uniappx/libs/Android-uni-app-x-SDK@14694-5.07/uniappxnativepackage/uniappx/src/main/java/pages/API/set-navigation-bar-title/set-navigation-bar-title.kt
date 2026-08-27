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
import io.dcloud.uniapp.extapi.setNavigationBarTitle as uni_setNavigationBarTitle
open class GenPagesAPISetNavigationBarTitleSetNavigationBarTitle : BasePage {
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
    open var getLifeCycleNum: () -> Number
        get() {
            return unref(this.`$exposed`["getLifeCycleNum"]) as () -> Number
        }
        set(value) {
            setRefValue(this.`$exposed`, "getLifeCycleNum", value)
        }
    open var setLifeCycleNum: (num: Number) -> Unit
        get() {
            return unref(this.`$exposed`["setLifeCycleNum"]) as (num: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setLifeCycleNum", value)
        }
    open var setNavigationBarNewTitle: () -> Unit
        get() {
            return unref(this.`$exposed`["setNavigationBarNewTitle"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setNavigationBarNewTitle", value)
        }
    open var setNavigationBarLongTitle: () -> Unit
        get() {
            return unref(this.`$exposed`["setNavigationBarLongTitle"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setNavigationBarLongTitle", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPISetNavigationBarTitleSetNavigationBarTitle, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPISetNavigationBarTitleSetNavigationBarTitle
            val _cache = __ins.renderCache
            val newTitle = ref("new title")
            val longTitle = ref("long title long title long title long title long title long title long title long title long title long title")
            val getLifeCycleNum = fun(): Number {
                return state.lifeCycleNum
            }
            val setLifeCycleNumFunc = fun(num: Number){
                uni.UNIHelloUniAppX.setLifeCycleNum(num)
            }
            val setNavigationBarNewTitle = fun(){
                uni_setNavigationBarTitle(SetNavigationBarTitleOptions(title = newTitle.value, success = fun(_){
                    console.log("setNavigationBarTitle success")
                    setLifeCycleNumFunc(state.lifeCycleNum + 1)
                }
                , fail = fun(_){
                    console.log("setNavigationBarTitle fail")
                    setLifeCycleNumFunc(state.lifeCycleNum - 1)
                }
                , complete = fun(_){
                    console.log("setNavigationBarTitle complete")
                    setLifeCycleNumFunc(state.lifeCycleNum + 1)
                }
                ))
            }
            val setNavigationBarLongTitle = fun(){
                uni_setNavigationBarTitle(SetNavigationBarTitleOptions(title = longTitle.value, success = fun(_) {
                    console.log("setNavigationBarTitle success")
                }
                , fail = fun(_) {
                    console.log("setNavigationBarTitle fail")
                }
                , complete = fun(_) {
                    console.log("setNavigationBarTitle complete")
                }
                ))
            }
            __expose(_uM("getLifeCycleNum" to getLifeCycleNum, "setLifeCycleNum" to setLifeCycleNumFunc, "setNavigationBarNewTitle" to setNavigationBarNewTitle, "setNavigationBarLongTitle" to setNavigationBarLongTitle))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE(Fragment, null, _uA(
                    _cV(_component_page_head, _uM("title" to "setNavigationBarTitle")),
                    _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt"), _uA(
                        _cE("button", _uM("onClick" to setNavigationBarNewTitle, "class" to "uni-btn"), " 设置当前页面标题为: " + _tD(unref(newTitle)), 1),
                        _cE("button", _uM("onClick" to setNavigationBarLongTitle, "class" to "uni-btn"), " 设置超长标题 ")
                    ))
                ), 64)
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
