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
import io.dcloud.uniapp.extapi.hideActionSheet as uni_hideActionSheet
import io.dcloud.uniapp.extapi.hideLoading as uni_hideLoading
import io.dcloud.uniapp.extapi.navigateBack as uni_navigateBack
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
import io.dcloud.uniapp.extapi.reLaunch as uni_reLaunch
import io.dcloud.uniapp.extapi.redirectTo as uni_redirectTo
import io.dcloud.uniapp.extapi.showActionSheet as uni_showActionSheet
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading
import io.dcloud.uniapp.extapi.showModal as uni_showModal
import io.dcloud.uniapp.extapi.showToast as uni_showToast
import io.dcloud.uniapp.extapi.switchTab as uni_switchTab
open class GenPagesAPINavigatorNewPageOnLoad : BasePage {
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
    open var hideActionSheet: () -> Unit
        get() {
            return unref(this.`$exposed`["hideActionSheet"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "hideActionSheet", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPINavigatorNewPageOnLoad, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPINavigatorNewPageOnLoad
            val _cache = __ins.renderCache
            val isTrueValue = ref(false)
            val isFalseValue = ref(true)
            val msg = ref("default msg")
            fun gen_adjustData_fn() {
                isTrueValue.value = true
                isFalseValue.value = false
                msg.value = "new msg"
            }
            val adjustData = ::gen_adjustData_fn
            fun gen_navigateTo_fn() {
                uni_navigateTo(NavigateToOptions(url = "/pages/API/navigator/new-page/new-page-3"))
            }
            val navigateTo = ::gen_navigateTo_fn
            fun gen_navigateBack_fn() {
                uni_navigateBack(null)
            }
            val navigateBack = ::gen_navigateBack_fn
            fun gen_redirectTo_fn() {
                uni_redirectTo(RedirectToOptions(url = "/pages/API/navigator/new-page/new-page-3"))
            }
            val redirectTo = ::gen_redirectTo_fn
            fun gen_reLaunch_fn() {
                uni_reLaunch(ReLaunchOptions(url = "/pages/API/navigator/new-page/new-page-3"))
            }
            val reLaunch = ::gen_reLaunch_fn
            fun gen_switchTab_fn() {
                uni_switchTab(SwitchTabOptions(url = "/pages/tabBar/component"))
            }
            val switchTab = ::gen_switchTab_fn
            fun gen_showToast_fn() {
                uni_showToast(ShowToastOptions(title = "test title", icon = "success", duration = 2000))
            }
            val showToast = ::gen_showToast_fn
            fun gen_showLoading_fn() {
                uni_showLoading(ShowLoadingOptions(title = "test title"))
                setTimeout(fun(){
                    uni_hideLoading(null)
                }
                , 2000)
            }
            val showLoading = ::gen_showLoading_fn
            fun gen_showModal_fn() {
                uni_showModal(ShowModalOptions(title = "test title", content = "test content"))
            }
            val showModal = ::gen_showModal_fn
            fun gen_showActionSheet_fn() {
                uni_showActionSheet(ShowActionSheetOptions(title = "test title", itemList = _uA(
                    "1",
                    "2",
                    "3"
                )))
            }
            val showActionSheet = ::gen_showActionSheet_fn
            fun gen_hideActionSheet_fn() {
                uni_hideActionSheet()
            }
            val hideActionSheet = ::gen_hideActionSheet_fn
            onLoad(fun(options: OnLoadOptions){
                val type = options["type"]
                when (type) {
                    "adjustData" -> 
                        adjustData()
                    "navigateTo" -> 
                        navigateTo()
                    "navigateBack" -> 
                        navigateBack()
                    "redirectTo" -> 
                        redirectTo()
                    "reLaunch" -> 
                        reLaunch()
                    "switchTab" -> 
                        switchTab()
                    "showToast" -> 
                        showToast()
                    "showLoading" -> 
                        showLoading()
                    "showModal" -> 
                        showModal()
                    "showActionSheet" -> 
                        showActionSheet()
                }
            }
            )
            __expose(_uM("hideActionSheet" to hideActionSheet))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                        _cV(_component_page_head, _uM("title" to "onLoad 生命周期调用 uni api 测试")),
                        if (isTrue(unref(isTrueValue))) {
                            _cE("text", _uM("key" to 0), "v-if with true")
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        if (isTrue(unref(isFalseValue))) {
                            _cE("text", _uM("key" to 1), "v-if with false")
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        withDirectives(_cE("text", null, "v-show with true", 512), _uA(
                            _uA(
                                vShow,
                                unref(isTrueValue)
                            )
                        )),
                        withDirectives(_cE("text", null, "v-show with false", 512), _uA(
                            _uA(
                                vShow,
                                unref(isFalseValue)
                            )
                        )),
                        _cE("text", null, "msg: " + _tD(unref(msg)), 1)
                    ))
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
