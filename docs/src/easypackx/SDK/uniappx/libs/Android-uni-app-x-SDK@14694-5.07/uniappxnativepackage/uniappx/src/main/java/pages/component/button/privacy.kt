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
import io.dcloud.uniapp.extapi.closeDialogPage as uni_closeDialogPage
import io.dcloud.uniapp.extapi.offPrivacyAuthorizationChange as uni_offPrivacyAuthorizationChange
import io.dcloud.uniapp.extapi.onPrivacyAuthorizationChange as uni_onPrivacyAuthorizationChange
import uts.sdk.modules.utsOpenSchema.openSchema
import io.dcloud.uniapp.extapi.resetPrivacyAuthorization as uni_resetPrivacyAuthorization
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesComponentButtonPrivacy : BasePage {
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
        var setup: (__props: GenPagesComponentButtonPrivacy) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentButtonPrivacy
            val _cache = __ins.renderCache
            val currentPage = getCurrentInstance()?.proxy?.`$page`
            var number: Number = 0
            val hrefLicense = "https://dcloud.io/license/DCloud.html"
            val hrefPrivacy = "https://dcloud.io/license/hello-uni-app-x.html"
            fun gen_agree_fn() {
                if (currentPage != null) {
                    uni_closeDialogPage(CloseDialogPageOptions(dialogPage = currentPage))
                }
            }
            val agree = ::gen_agree_fn
            fun gen_reject_fn() {
                uni_resetPrivacyAuthorization()
                if (currentPage != null) {
                    uni_closeDialogPage(CloseDialogPageOptions(dialogPage = currentPage))
                }
            }
            val reject = ::gen_reject_fn
            fun gen_hrefClick_fn(href: String) {
                openSchema(href)
            }
            val hrefClick = ::gen_hrefClick_fn
            onLoad(fun(_){
                number = uni_onPrivacyAuthorizationChange(fun(callback){
                    uni_showToast(ShowToastOptions(title = "isPrivacyAgree:" + !callback.needAuthorization))
                }
                )
            }
            )
            onUnmounted(fun(){
                uni_offPrivacyAuthorizationChange(number)
            }
            )
            return fun(): Any? {
                return _cE("view", _uM("class" to "dialog-container"), _uA(
                    _cE("view", _uM("class" to "dialog-content"), _uA(
                        _cE("view", _uM("style" to _nS(_uM("width" to "100%", "justify-content" to "center", "align-items" to "center", "background-color" to "#fff"))), _uA(
                            _cE("image", _uM("src" to default__3, "style" to _nS(_uM("margin-top" to "25px", "width" to "60px", "height" to "60px"))), null, 4)
                        ), 4),
                        _cE("text", _uM("style" to _nS(_uM("text-align" to "center", "padding-top" to "20px", "font-size" to "20px", "color" to "black", "background-color" to "#fff"))), "个人信息保护指引", 4),
                        _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1", "align-content" to "center", "padding-top" to "10px", "padding-left" to "25px", "padding-right" to "25px", "background-color" to "#fff")), "show-scrollbar" to "false"), _uA(
                            _cE("text", null, _uA(
                                _cE("text", _uM("class" to "privacy-text"), "欢迎使用 Hello uni-app x 应用，我们将通过"),
                                _cE("text", _uM("class" to "privacy-href", "onClick" to fun(){
                                    hrefClick(hrefLicense)
                                }
                                ), "《用户服务协议》", 8, _uA(
                                    "onClick"
                                )),
                                _cE("text", _uM("class" to "privacy-text"), "及"),
                                _cE("text", _uM("class" to "privacy-text"), "相关个人信息处理规则帮助你了解我们如何收集、处理个人信息。根据《常见类型移动互联网应用程序必要个人信息范围规定》，应用在演示 uni-app x 能力时仅收集、处理相关必要个人信息及数据。我们通过"),
                                _cE("text", _uM("class" to "privacy-href", "onClick" to fun(){
                                    hrefClick(hrefPrivacy)
                                }
                                ), "《隐私政策》", 8, _uA(
                                    "onClick"
                                )),
                                _cE("text", _uM("class" to "privacy-text"), "帮助你全面了解我们的服务及收集、处理个人信息的详细情况。")
                            )),
                            _cE("text", _uM("class" to "privacy-text"), "如你同意请点击“同意”按钮接受我们的服务。")
                        ), 4),
                        _cE("button", _uM("class" to "button", "onClick" to reject), "不同意"),
                        _cE("button", _uM("class" to "button", "type" to "primary", "open-type" to "agreePrivacyAuthorization", "onClick" to agree), "同意")
                    ))
                ))
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("dialog-container" to _pS(_uM("width" to "100%", "height" to "100%", "backgroundColor" to "rgba(0,0,0,0.3)", "display" to "flex", "justifyContent" to "center", "alignItems" to "center")), "dialog-content" to _pS(_uM("height" to "60%", "width" to "80%", "borderTopLeftRadius" to 12, "borderTopRightRadius" to 12, "borderBottomRightRadius" to 12, "borderBottomLeftRadius" to 12)), "button" to _pS(_uM("borderTopLeftRadius" to 0, "borderTopRightRadius" to 0, "borderBottomRightRadius" to 0, "borderBottomLeftRadius" to 0, "borderTopWidth" to 0, "borderRightWidth" to 0, "borderBottomWidth" to 0, "borderLeftWidth" to 0, "borderTopStyle" to "none", "borderRightStyle" to "none", "borderBottomStyle" to "none", "borderLeftStyle" to "none", "borderTopColor" to "#000000", "borderRightColor" to "#000000", "borderBottomColor" to "#000000", "borderLeftColor" to "#000000", "fontSize" to 15, "color" to "#D3D3D3", "textAlign" to "center", "lineHeight" to "40px")), "button-hover1" to _pS(_uM("color" to "#000000", "backgroundColor" to "#ffffff")), "button-hover2" to _pS(_uM("color" to "#000000", "backgroundColor" to "#4169E1")), "privacy-text" to _pS(_uM("color" to "#808080")), "privacy-href" to _pS(_uM("color" to "#5F9EA0", "fontWeight" to "bold", "textDecorationLine" to "underline")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
