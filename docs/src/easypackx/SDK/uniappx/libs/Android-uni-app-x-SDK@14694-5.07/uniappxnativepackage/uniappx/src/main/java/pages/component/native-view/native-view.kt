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
import uts.sdk.modules.nativeButton.createNativeButtonContext
import io.dcloud.uniapp.extapi.openDialogPage as uni_openDialogPage
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesComponentNativeViewNativeView : BasePage {
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
    open var getIsLoadTest: () -> Boolean
        get() {
            return unref(this.`$exposed`["getIsLoadTest"]) as () -> Boolean
        }
        set(value) {
            setRefValue(this.`$exposed`, "getIsLoadTest", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentNativeViewNativeView, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentNativeViewNativeView
            val _cache = __ins.renderCache
            val buttonText = ref("native-button")
            var isLoad = false
            var clickCount: Number = 0
            fun gen_ontap_fn(e: UniNativeViewEvent) {
                uni_showToast(ShowToastOptions(title = "按钮被点击了"))
                clickCount++
                buttonText.value = "native-button" + clickCount
            }
            val ontap = ::gen_ontap_fn
            fun gen_onload_fn() {
                isLoad = true
            }
            val onload = ::gen_onload_fn
            fun gen_getIsLoadTest_fn(): Boolean {
                return isLoad
            }
            val getIsLoadTest = ::gen_getIsLoadTest_fn
            fun gen_testCallMethod_fn() {
                var context = createNativeButtonContext("helloView")
                context?.updateText("test code")
            }
            val testCallMethod = ::gen_testCallMethod_fn
            fun gen_gotoTimePicker_fn() {
                uni_openDialogPage(OpenDialogPageOptions(url = "/pages/component/native-view/native-view-time-picker-dialog", animationType = "fade-in"))
            }
            val gotoTimePicker = ::gen_gotoTimePicker_fn
            __expose(_uM("getIsLoadTest" to getIsLoadTest))
            return fun(): Any? {
                val _component_page_intro = resolveEasyComponent("page-intro", GenComponentsPageIntroPageIntroClass)
                val _component_native_button = resolveEasyComponent("native-button", GenUniModulesNativeButtonComponentsNativeButtonNativeButtonClass)
                val _component_native_button_container = resolveEasyComponent("native-button-container", GenComponentsNativeButtonContainerNativeButtonContainerClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cV(_component_page_intro, _uM("content" to "本页演示 native-view 原生视图与 UTS 插件组件：调用组件方法、native-button 与容器、native-view 样式；可跳转 native-time-picker 等原生能力。")),
                    _cE("view", _uM("style" to _nS(_uM("padding-bottom" to "50px"))), _uA(
                        _cE("text", _uM("class" to "tips"), "说明：如果本地无 uts 插件编译环境请提交打包自定义基座查看效果"),
                        _cE("button", _uM("type" to "primary", "onClick" to testCallMethod), "调用组件方法"),
                        _cV(_component_native_button, _uM("id" to "helloView", "class" to "native-button", "style" to _nS(_uM("width" to "200px", "height" to "100px")), "text" to unref(buttonText), "onButtonTap" to ontap, "onLoad" to onload), null, 8, _uA(
                            "style",
                            "text"
                        )),
                        _cV(_component_native_button_container),
                        _cE("button", _uM("type" to "primary", "onClick" to gotoTimePicker), "调用native-time-picker"),
                        _cE("text", _uM("class" to "uni-title-text"), "native-view样式大合集"),
                        _cE("native-view", _uM("class" to "styled-native-view"))
                    ), 4)
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
                return _uM("tips" to _pS(_uM("fontSize" to 14, "color" to "#BEBEBE", "marginTop" to 25, "marginRight" to "auto", "marginBottom" to 25, "marginLeft" to "auto", "textAlign" to "center")), "native-button" to _pS(_uM("height" to 100, "width" to 100, "marginTop" to 25, "marginRight" to "auto", "marginBottom" to 25, "marginLeft" to "auto")), "styled-native-view" to _pS(_uM("width" to 80, "height" to 80, "marginTop" to 20, "marginRight" to 30, "marginBottom" to 20, "marginLeft" to 30, "paddingTop" to 5, "paddingRight" to 5, "paddingBottom" to 5, "paddingLeft" to 5, "borderTopWidth" to 2, "borderRightWidth" to 2, "borderBottomWidth" to 2, "borderLeftWidth" to 2, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#007aff", "borderRightColor" to "#007aff", "borderBottomColor" to "#007aff", "borderLeftColor" to "#007aff", "borderTopLeftRadius" to 8, "borderTopRightRadius" to 8, "borderBottomRightRadius" to 8, "borderBottomLeftRadius" to 8, "backgroundColor" to "#f0f8ff", "boxShadow" to "0 4px 8px rgba(0, 0, 0, 0.3)", "opacity" to 0.95, "position" to "relative", "transform" to "rotate(45deg)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
