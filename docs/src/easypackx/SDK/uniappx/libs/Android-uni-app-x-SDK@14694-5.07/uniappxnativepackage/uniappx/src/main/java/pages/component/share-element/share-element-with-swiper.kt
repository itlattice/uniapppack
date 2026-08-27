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
open class GenPagesComponentShareElementShareElementWithSwiper : BasePage {
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
        var setup: (__props: GenPagesComponentShareElementShareElementWithSwiper) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentShareElementShareElementWithSwiper
            val _cache = __ins.renderCache
            val transitionOnGesture = ref(true)
            val shuttleOnPopType = ref("to" as ShuttleOnType__1)
            val shuttleOnPushType = ref("to" as ShuttleOnType__1)
            val shuttleOnTypeList = ref(_uA(
                "from",
                "to"
            ))
            val openAnimationType = ref("slide-in-right" as ShareElementOpenAnimationType__1)
            val openAnimationTypeList = ref(_uA(
                "auto",
                "none",
                "slide-in-right",
                "slide-in-left",
                "slide-in-top",
                "slide-in-bottom",
                "fade-in",
                "pop-in",
                "zoom-out",
                "zoom-fade-out"
            ))
            val easingFunctionType = ref("ease" as ShareElementEasingFunctionType__1)
            val easingFunctionTypeList = ref(_uA(
                "ease",
                "ease-in",
                "ease-out",
                "ease-in-out",
                "linear"
            ))
            fun gen_openPage_fn() {
                uni_navigateTo(NavigateToOptions(animationType = openAnimationType.value, url = "/pages/component/share-element/share-element-to?shuttleOnPush=" + shuttleOnPushType.value + "&transitionOnGesture=" + transitionOnGesture.value))
            }
            val openPage = ::gen_openPage_fn
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE(Fragment, null, _uA(
                    _cV(_component_page_head, _uM("title" to "share-element")),
                    _cE("view", _uM("class" to "main"), _uA(
                        _cE("swiper", _uM("circular" to "true"), _uA(
                            _cE("swiper-item", null, _uA(
                                _cE("share-element", _uM("class" to "share-element", "share-key" to "left", "shuttle-on-pop" to unref(shuttleOnPopType), "transition-on-gesture" to unref(transitionOnGesture), "shuttle-on-push" to unref(shuttleOnPushType), "easing-function" to unref(easingFunctionType), "onClick" to fun(){
                                    openPage()
                                }
                                ), _uA(
                                    _cE("image", _uM("style" to _nS(_uM("width" to "100px", "height" to "150px")), "src" to "https://web-ext-storage.dcloud.net.cn/hello-uni-app-x/drop-card-1.jpg"), null, 4)
                                ), 8, _uA(
                                    "shuttle-on-pop",
                                    "transition-on-gesture",
                                    "shuttle-on-push",
                                    "easing-function",
                                    "onClick"
                                ))
                            ))
                        ))
                    )),
                    _cE("button", _uM("type" to "primary", "onClick" to openPage, "class" to "button"), " 打开share-element页面 ")
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
                return _uM("ml-10" to _pS(_uM("marginLeft" to 10)), "choose-property-title" to _pS(_uM("fontWeight" to "bold")), "choose-property-type-radio-group" to _pS(_uM("flexDirection" to "row", "flexWrap" to "wrap")), "bottomWrap" to _pS(_uM("width" to "100%", "bottom" to 0, "height" to 80, "position" to "fixed")), "bottom" to _pS(_uM("width" to "100%", "height" to "100%", "alignItems" to "center", "justifyContent" to "center", "backgroundColor" to "#007aff")), "main" to _pS(_uM("paddingTop" to 5, "paddingRight" to 0, "paddingBottom" to 5, "paddingLeft" to 0, "alignItems" to "center", "justifyContent" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
