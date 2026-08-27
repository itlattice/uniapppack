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
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
import io.dcloud.uniapp.extapi.setNavigationBarColor as uni_setNavigationBarColor
open class GenPagesAPISetNavigationBarColorSetNavigationBarColor : BasePage {
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
    open var setNavigationBarColor1: () -> Unit
        get() {
            return unref(this.`$exposed`["setNavigationBarColor1"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setNavigationBarColor1", value)
        }
    open var setNavigationBarColor2: () -> Unit
        get() {
            return unref(this.`$exposed`["setNavigationBarColor2"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setNavigationBarColor2", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPISetNavigationBarColorSetNavigationBarColor, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPISetNavigationBarColorSetNavigationBarColor
            val _cache = __ins.renderCache
            val getLifeCycleNum = fun(): Number {
                return state.lifeCycleNum
            }
            val setLifeCycleNumFunc = fun(num: Number){
                uni.UNIHelloUniAppX.setLifeCycleNum(num)
            }
            val setNavigationBarColor1 = fun(){
                uni_setNavigationBarColor(SetNavigationBarColorOptions(frontColor = "#ffffff", backgroundColor = "#00ff00", success = fun(_){
                    console.log("setNavigationBarColor success")
                    setLifeCycleNumFunc(state.lifeCycleNum + 1)
                }
                , fail = fun(_){
                    console.log("setNavigationBarColor fail")
                    setLifeCycleNumFunc(state.lifeCycleNum - 1)
                }
                , complete = fun(_){
                    console.log("setNavigationBarColor complete")
                    setLifeCycleNumFunc(state.lifeCycleNum + 1)
                }
                ))
            }
            val setNavigationBarColor2 = fun(){
                uni_setNavigationBarColor(SetNavigationBarColorOptions(frontColor = "#000000", backgroundColor = "#ff0000", success = fun(_){
                    console.log("setNavigationBarColor success")
                    setLifeCycleNumFunc(state.lifeCycleNum + 1)
                }
                , fail = fun(_){
                    console.log("setNavigationBarColor fail")
                    setLifeCycleNumFunc(state.lifeCycleNum - 1)
                }
                , complete = fun(_){
                    console.log("setNavigationBarColor complete")
                    setLifeCycleNumFunc(state.lifeCycleNum + 1)
                }
                ))
            }
            val goNavbarLite = fun(){
                uni_navigateTo(NavigateToOptions(url = "/pages/template/navbar-lite/navbar-lite"))
            }
            __expose(_uM("getLifeCycleNum" to getLifeCycleNum, "setLifeCycleNum" to setLifeCycleNumFunc, "setNavigationBarColor1" to setNavigationBarColor1, "setNavigationBarColor2" to setNavigationBarColor2))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE(Fragment, null, _uA(
                    _cV(_component_page_head, _uM("title" to "setNavigationBarColor")),
                    _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt"), _uA(
                        _cE("button", _uM("onClick" to setNavigationBarColor1, "class" to "uni-btn"), " 设置导航条背景绿色，标题白色 "),
                        _cE("button", _uM("onClick" to setNavigationBarColor2, "class" to "uni-btn"), " 设置导航条背景红色，标题黑色 "),
                        _cE("button", _uM("onClick" to goNavbarLite, "class" to "uni-btn"), " 跳转自定义导航栏页面 ")
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
