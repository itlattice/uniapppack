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
import io.dcloud.uniapp.extapi.navigateBack as uni_navigateBack
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
import io.dcloud.uniapp.extapi.reLaunch as uni_reLaunch
import io.dcloud.uniapp.extapi.redirectTo as uni_redirectTo
import io.dcloud.uniapp.extapi.showToast as uni_showToast
import io.dcloud.uniapp.extapi.switchTab as uni_switchTab
open class GenPagesAPINavigatorNavigator : BasePage {
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
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPINavigatorNavigator) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPINavigatorNavigator
            val _cache = __ins.renderCache
            val data = reactive(DataType__56(onLoadTime = 0, onShowTime = 0, onReadyTime = 0, onHideTime = 0, shareElementKey = "", animationTypeList = _uA(
                "slide-in-right",
                "slide-in-left",
                "slide-in-top",
                "slide-in-bottom",
                "pop-in",
                "fade-in",
                "zoom-out",
                "zoom-fade-out",
                "none"
            )))
            onLoad(fun(_options){
                data.onLoadTime = Date.now()
                console.log("onLoad", data.onLoadTime)
            }
            )
            onPageShow(fun(){
                data.onShowTime = Date.now()
                console.log("onShow", data.onShowTime)
            }
            )
            onReady(fun(){
                data.onReadyTime = Date.now()
                console.log("onReady", data.onReadyTime)
            }
            )
            onPageHide(fun(){
                data.onHideTime = Date.now()
                console.log("onHide", data.onHideTime)
            }
            )
            onBackPress(fun(options: OnBackPressOptions): Boolean? {
                console.log("onBackPress", Date.now())
                console.log("onBackPress from", options.from)
                return null
            }
            )
            onUnload(fun(){
                console.log("onUnload", Date.now())
            }
            )
            val reLaunch = fun(){
                uni_reLaunch(ReLaunchOptions(url = "/pages/tabBar/component", success = fun(result) {
                    console.log("reLaunch success", result.errMsg)
                    setLifeCycleNum(state.lifeCycleNum + 1)
                }
                , fail = fun(error) {
                    console.log("reLaunch fail", error.errMsg)
                    setLifeCycleNum(state.lifeCycleNum - 1)
                }
                , complete = fun(result) {
                    console.log("reLaunch complete", result.errMsg)
                    setLifeCycleNum(state.lifeCycleNum + 1)
                }
                ))
            }
            val navigateTo = fun(){
                uni_navigateTo(NavigateToOptions(url = "/pages/API/navigator/new-page/new-page-1?data=Hello", success = fun(result) {
                    console.log("navigateTo success", result.errMsg)
                    setLifeCycleNum(state.lifeCycleNum + 1)
                }
                , fail = fun(error) {
                    console.log("navigateTo fail", error.errMsg)
                    setLifeCycleNum(state.lifeCycleNum - 1)
                }
                , complete = fun(result) {
                    console.log("navigateTo complete", result.errMsg)
                    setLifeCycleNum(state.lifeCycleNum + 1)
                }
                ))
            }
            val navigateToAnimationType = fun(animationType: AnimationType){
                uni_navigateTo(NavigateToOptions(url = "/pages/API/navigator/new-page/new-page-1?data=Hello", animationType = animationType, success = fun(result) {
                    console.log("navigateTo success", result.errMsg)
                    setLifeCycleNum(state.lifeCycleNum + 1)
                }
                , fail = fun(error) {
                    console.log("navigateTo fail", error.errMsg)
                    setLifeCycleNum(state.lifeCycleNum - 1)
                }
                , complete = fun(result) {
                    console.log("navigateTo complete", result.errMsg)
                    setLifeCycleNum(state.lifeCycleNum + 1)
                }
                ))
            }
            val navigateToErrorPage = fun(){
                uni_navigateTo(NavigateToOptions(url = "/pages/error-page/error-page", success = fun(result) {
                    console.log("navigateTo success", result.errMsg)
                    setLifeCycleNum(state.lifeCycleNum - 1)
                }
                , fail = fun(error) {
                    console.log("navigateTo fail", error.errMsg)
                    uni_showToast(ShowToastOptions(title = error.errMsg, icon = "none"))
                    setLifeCycleNum(state.lifeCycleNum + 1)
                }
                , complete = fun(result) {
                    console.log("navigateTo complete", result.errMsg)
                    setLifeCycleNum(state.lifeCycleNum + 1)
                }
                ))
            }
            val navigateBack = fun(){
                uni_navigateBack(NavigateBackOptions(success = fun(result) {
                    console.log("navigateBack success", result.errMsg)
                    setLifeCycleNum(state.lifeCycleNum + 1)
                }
                , fail = fun(error) {
                    console.log("navigateBack fail", error.errMsg)
                    setLifeCycleNum(state.lifeCycleNum - 1)
                }
                , complete = fun(result) {
                    console.log("navigateBack complete", result.errMsg)
                    setLifeCycleNum(state.lifeCycleNum + 1)
                }
                ))
            }
            val redirectTo = fun(){
                uni_redirectTo(RedirectToOptions(url = "/pages/API/navigator/new-page/new-page-1?data=Hello", success = fun(result) {
                    console.log("redirectTo success", result.errMsg)
                    setLifeCycleNum(state.lifeCycleNum + 1)
                }
                , fail = fun(error) {
                    console.log("redirectTo fail", error.errMsg)
                    setLifeCycleNum(state.lifeCycleNum - 1)
                }
                , complete = fun(result) {
                    console.log("redirectTo complete", result.errMsg)
                    setLifeCycleNum(state.lifeCycleNum + 1)
                }
                ))
            }
            val switchTab = fun(){
                uni_switchTab(SwitchTabOptions(url = "/pages/tabBar/template", success = fun(result) {
                    console.log("switchTab success", result.errMsg)
                    setLifeCycleNum(state.lifeCycleNum + 1)
                }
                , fail = fun(error) {
                    console.log("switchTab fail", error.errMsg)
                    setLifeCycleNum(state.lifeCycleNum - 1)
                }
                , complete = fun(result) {
                    console.log("switchTab complete", result.errMsg)
                    setLifeCycleNum(state.lifeCycleNum + 1)
                }
                ))
            }
            val onChange = fun(event: UniSwitchChangeEvent){
                if (event.detail.value) {
                    data.shareElementKey = "test-share-element-key"
                } else {
                    data.shareElementKey = ""
                }
            }
            val goOnLoadCallAPI = fun(){
                uni_navigateTo(NavigateToOptions(url = "/pages/API/navigator/new-page/onLoad-call-api"))
            }
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                val _component_page_intro = resolveEasyComponent("page-intro", GenComponentsPageIntroPageIntroClass)
                val _component_switch = resolveComponent("switch")
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", null, _uA(
                        _cV(_component_page_head, _uM("title" to "navigate")),
                        _cV(_component_page_intro, _uM("content" to "本页演示页面路由：开关控制共享元素动画，展示 onLoad/onShow/onReady 等生命周期时间戳；通过按钮跳转新页、返回、redirect 等，可传递参数。")),
                        _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row"))), _uA(
                            _cV(_component_switch, _uM("onChange" to onChange)),
                            _cE("view", _uM("class" to "uni-title"), "是否启用共享元素动画")
                        ), 4),
                        _cE("share-element", _uM("share-key" to unref(data).shareElementKey), _uA(
                            _cE("image", _uM("style" to _nS(_uM("width" to "250px", "height" to "176px")), "src" to "/static/shuijiao.jpg", "mode" to "scaleToFill"), null, 4)
                        ), 8, _uA(
                            "share-key"
                        )),
                        _cE("text", _uM("style" to _nS(_uM("font-size" to "13px"))), "注意：开启共享元素动画后仅支持slide-in-right和fade-in动画效果", 4),
                        _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt uni-common-mb"), _uA(
                            _cE("view", _uM("class" to "direction-row"), _uA(
                                _cE("text", _uM("class" to "label"), "onLoad触发时间戳:"),
                                _cE("text", null, _tD(unref(data).onLoadTime), 1)
                            )),
                            _cE("view", _uM("class" to "direction-row"), _uA(
                                _cE("text", _uM("class" to "label"), "onShow触发时间戳:"),
                                _cE("text", null, _tD(unref(data).onShowTime), 1)
                            )),
                            _cE("view", _uM("class" to "direction-row"), _uA(
                                _cE("text", _uM("class" to "label"), "onReady触发时间戳:"),
                                _cE("text", null, _tD(unref(data).onReadyTime), 1)
                            )),
                            _cE("view", _uM("class" to "direction-row"), _uA(
                                _cE("text", _uM("class" to "label"), "onHide触发时间戳:"),
                                _cE("text", null, _tD(unref(data).onHideTime), 1)
                            )),
                            _cE("view", _uM("class" to "direction-row"), _uA(
                                _cE("text", _uM("class" to "label"), "onBackPress触发时间戳:"),
                                _cE("text", null, "见控制台")
                            )),
                            _cE("view", _uM("class" to "direction-row"), _uA(
                                _cE("text", _uM("class" to "label"), "onUnload触发时间戳:"),
                                _cE("text", null, "见控制台")
                            )),
                            _cE("view", _uM("class" to "uni-btn-v"), _uA(
                                _cE("button", _uM("onClick" to navigateTo, "class" to "uni-btn"), " 跳转新页面，并传递数据 "),
                                _cE("button", _uM("onClick" to navigateBack, "class" to "uni-btn"), "返回上一页"),
                                _cE("button", _uM("onClick" to redirectTo, "class" to "uni-btn"), "在当前页面打开"),
                                _cE("button", _uM("onClick" to switchTab, "class" to "uni-btn"), "切换到模板选项卡"),
                                _cE("button", _uM("onClick" to reLaunch, "class" to "uni-btn"), " 关闭所有页面，打开首页 "),
                                _cE("button", _uM("onClick" to navigateToErrorPage, "class" to "uni-btn"), " 打开不存在的页面 "),
                                _cE(Fragment, null, RenderHelpers.renderList(unref(data).animationTypeList, fun(item, _, __index, _cached): Any {
                                    return _cE("button", _uM("onClick" to fun(){
                                        navigateToAnimationType(item)
                                    }
                                    , "class" to "uni-btn"), "navigateTo动画(" + _tD(item) + ")", 9, _uA(
                                        "onClick"
                                    ))
                                }
                                ), 256),
                                _cE("button", _uM("class" to "uni-btn", "onClick" to goOnLoadCallAPI), "测试 onLoad 调用 API")
                            ))
                        ))
                    ))
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
                return _uM("direction-row" to _pS(_uM("flexDirection" to "row")), "label" to _pS(_uM("width" to 190)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
