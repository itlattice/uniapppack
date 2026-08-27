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
import io.dcloud.uniapp.extapi.addInterceptor as uni_addInterceptor
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
import io.dcloud.uniapp.extapi.removeInterceptor as uni_removeInterceptor
import io.dcloud.uniapp.extapi.showToast as uni_showToast
import io.dcloud.uniapp.extapi.switchTab as uni_switchTab
open class GenPagesAPIInterceptorInterceptor : BasePage {
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
    open var addInterceptor: () -> Unit
        get() {
            return unref(this.`$exposed`["addInterceptor"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "addInterceptor", value)
        }
    open var removeInterceptor: () -> Unit
        get() {
            return unref(this.`$exposed`["removeInterceptor"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "removeInterceptor", value)
        }
    open var addSwitchTabInterceptor: () -> Unit
        get() {
            return unref(this.`$exposed`["addSwitchTabInterceptor"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "addSwitchTabInterceptor", value)
        }
    open var removeSwitchTabInterceptor: () -> Unit
        get() {
            return unref(this.`$exposed`["removeSwitchTabInterceptor"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "removeSwitchTabInterceptor", value)
        }
    open var navigateTo: () -> Unit
        get() {
            return unref(this.`$exposed`["navigateTo"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "navigateTo", value)
        }
    open var switchTab: () -> Unit
        get() {
            return unref(this.`$exposed`["switchTab"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "switchTab", value)
        }
    open var preventNavigateTo: () -> Unit
        get() {
            return unref(this.`$exposed`["preventNavigateTo"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "preventNavigateTo", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIInterceptorInterceptor, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIInterceptorInterceptor
            val _cache = __ins.renderCache
            val navigateToInterceptor = AddInterceptorOptions(invoke = fun(options: NavigateToOptions) {
                console.log("拦截 navigateTo 接口传入参数为：", options)
                val url = "./page2"
                uni_showToast(ShowToastOptions(title = "重定向到页面:" + url))
                options.url = url
            }
            , success = fun(res: NavigateToSuccess) {
                console.log("拦截 navigateTo 接口 success 返回参数为：", res)
            }
            , fail = fun(err: NavigateToFail) {
                console.log("拦截 navigateTo 接口 fail 返回参数为：", err)
            }
            , complete = fun(res: NavigateToComplete) {
                console.log("拦截 navigateTo 接口 complete 返回参数为：", res)
            }
            )
            val switchTabInterceptor = AddInterceptorOptions(invoke = fun(options: SwitchTabOptions) {
                console.log("拦截 switchTab 接口传入参数为：", options)
                options.url = "/pages/tabBar/API"
            }
            , success = fun(res: SwitchTabSuccess) {
                console.log("拦截 switchTab 接口 success 返回参数为：", res)
            }
            , fail = fun(err: SwitchTabFail) {
                console.log("拦截 switchTab 接口 fail 返回参数为：", err)
            }
            , complete = fun(res: SwitchTabComplete) {
                console.log("拦截 switchTab 接口 complete 返回参数为：", res)
            }
            )
            val msg = ref("会跳转到测试页面1")
            val addInterceptor = fun(){
                uni_addInterceptor("navigateTo", navigateToInterceptor)
                uni_showToast(ShowToastOptions(title = "页面跳转/切换tabbar已拦截"))
                msg.value = "，路由被劫持到测试页面2"
            }
            val removeInterceptor = fun(){
                uni_removeInterceptor("navigateTo", navigateToInterceptor)
                uni_showToast(ShowToastOptions(title = "拦截器已移除"))
                msg.value = "会跳转到测试页面1"
            }
            val addSwitchTabInterceptor = fun(){
                uni_addInterceptor("switchTab", switchTabInterceptor)
            }
            val removeSwitchTabInterceptor = fun(){
                uni_removeInterceptor("switchTab", switchTabInterceptor)
            }
            val navigateTo = fun(){
                uni_navigateTo(NavigateToOptions(url = "./page1", success = fun(res) {
                    console.log("res:", res)
                }
                , fail = fun(err) {
                    console.error("err:", err)
                }
                , complete = fun(res) {
                    console.log("res:", res)
                }
                ))
            }
            val preventNavigateTo = fun(){
                val preventNavigateToInterceptor = AddInterceptorOptions(invoke = fun(options: NavigateToOptions): Boolean {
                    console.log("通过 return false 方式阻止 navigateTo 执行，传入参数为：", options)
                    uni_showToast(ShowToastOptions(title = "拦截器已阻止跳转"))
                    return false
                }
                )
                uni_addInterceptor("navigateTo", preventNavigateToInterceptor)
                navigateTo()
                uni_removeInterceptor("navigateTo", preventNavigateToInterceptor)
            }
            val switchTab = fun(){
                uni_switchTab(SwitchTabOptions(url = "/pages/tabBar/component", success = fun(res) {
                    console.log("res:", res)
                }
                , fail = fun(err) {
                    console.error("err:", err)
                }
                , complete = fun(res) {
                    console.log("res:", res)
                }
                ))
            }
            onUnload(fun(){
                uni_removeInterceptor("navigateTo", null)
                uni_removeInterceptor("switchTab", null)
            }
            )
            __expose(_uM("addInterceptor" to addInterceptor, "removeInterceptor" to removeInterceptor, "addSwitchTabInterceptor" to addSwitchTabInterceptor, "removeSwitchTabInterceptor" to removeSwitchTabInterceptor, "navigateTo" to navigateTo, "switchTab" to switchTab, "preventNavigateTo" to preventNavigateTo))
            return fun(): Any? {
                val _component_navigator = resolveComponent("navigator")
                return _cE("view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("button", _uM("onClick" to addInterceptor), "添加路由拦截器"),
                    _cE("button", _uM("onClick" to removeInterceptor), "移除路由拦截器"),
                    _cE("text", null, "点击下方按钮" + _tD(unref(msg)), 1),
                    _cE("button", _uM("onClick" to navigateTo), "navigatorTo API跳转到测试页面"),
                    _cE("button", _uM("onClick" to preventNavigateTo), "拦截器阻止 navigatorTo 执行"),
                    _cV(_component_navigator, _uM("url" to "./page1"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("button", _uM("class" to "navigatorButton"), "navigator组件跳转到测试页面")
                        )
                    }
                    ), "_" to 1)),
                    _cE("button", _uM("onClick" to addSwitchTabInterceptor), "添加switchTab拦截器"),
                    _cE("button", _uM("onClick" to removeSwitchTabInterceptor), "移除switchTab拦截器"),
                    _cE("button", _uM("onClick" to switchTab), "switchTab API")
                ), 4)
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
