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
import io.dcloud.uniapp.extapi.getUniVerifyManager as uni_getUniVerifyManager
import io.dcloud.uniapp.extapi.openDialogPage as uni_openDialogPage
import io.dcloud.uniapp.extapi.showModal as uni_showModal
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesAPIGetUniVerifyManagerUniVerifyCustomPage : BasePage {
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
        var setup: (__props: GenPagesAPIGetUniVerifyManagerUniVerifyCustomPage) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIGetUniVerifyManagerUniVerifyCustomPage
            val _cache = __ins.renderCache
            val instance = getCurrentInstance()!!.proxy!!
            val uniVerifyManager = ref(null as UniVerifyManager?)
            val phone = ref("")
            val slogan = ref("")
            val privacyName = ref("")
            val privacyUrl = ref("")
            val closeIcon = ref("\uE650")
            val isLoading = ref(false)
            fun gen_closePage_fn() {
                uni_closeDialogPage(CloseDialogPageOptions(dialogPage = instance.`$page`, animationType = "slide-out-bottom", success = fun(res) {
                    console.log("closeThisDialog success", res)
                }
                , fail = fun(err) {
                    console.log("closeThisDialog fail", err)
                }
                ))
            }
            val closePage = ::gen_closePage_fn
            fun gen_openLink_fn() {
                var url = "/pages/API/get-uni-verify-manager/full-webview-page?url=" + privacyUrl.value + "&title=" + privacyName.value + "&animationType=slide-out-bottom"
                uni_openDialogPage(OpenDialogPageOptions(url = url, animationType = "slide-in-bottom", success = fun(res) {
                    console.log("打开隐私协议")
                }
                , fail = fun(err) {
                    console.log(err)
                }
                ))
            }
            val openLink = ::gen_openLink_fn
            fun gen_takePhoneNumber_fn(token: String, openId: String) {
                uniCloud.callFunction(UniCloudCallFunctionOptions(name = "univerify", data = _uO("access_token" to token, "openid" to openId))).then(fun(res){
                    closePage()
                    setTimeout(fun(){
                        uni_showModal(ShowModalOptions(title = "取号成功", content = res.result.getJSON("res")?.getString("phoneNumber"), showCancel = false))
                    }
                    , 100)
                }
                ).`catch`(fun(err){
                    console.error(JSON.stringify(err))
                    closePage()
                    setTimeout(fun(){
                        uni_showModal(ShowModalOptions(title = "取号失败", content = (err as UTSError).message, showCancel = false))
                    }
                    , 100)
                }
                )
            }
            val takePhoneNumber = ::gen_takePhoneNumber_fn
            fun gen_loginIn_fn() {
                if (isLoading.value) {
                    uni_showToast(ShowToastOptions(title = "正在登录中，请稍后", position = "bottom", duration = 2000))
                    return
                } else {
                    isLoading.value = true
                }
                val numberTextElement = instance.`$page`.getElementById("number-text")
                val sloganTextElement = instance.`$page`.getElementById("slogan-text")
                val loginButtonElement = instance.`$page`.getElementById("login-button")
                val privacyCheckBoxElement = instance.`$page`.getElementById("privacy-checkbox")
                val privacyTextElement = instance.`$page`.getElementById("privacy-text")
                if (numberTextElement != null && sloganTextElement != null && loginButtonElement != null && privacyCheckBoxElement != null && privacyTextElement != null) {
                    uniVerifyManager.value?.customLogin(UniVerifyManagerCustomLoginOptions(numberTextElement = numberTextElement, sloganTextElement = sloganTextElement, loginButtonElement = loginButtonElement, privacyCheckBoxElement = privacyCheckBoxElement, privacyTextElement = privacyTextElement, success = fun(res){
                        console.log(res)
                        takePhoneNumber(res.accessToken, res.openId)
                    }, fail = fun(error){
                        if (error.errCode == 40001) {
                            uni_showToast(ShowToastOptions(title = "请同意服务条款", position = "bottom", duration = 2000))
                        } else if (error.errCode == 40002) {
                            uni_showToast(ShowToastOptions(title = "授权页不符合规范", position = "bottom", duration = 2000))
                        } else {
                            val errorMsg = JSON.parseObject(error.cause?.cause?.message ?: "")?.getString("errorDesc") ?: error.errMsg
                            uni_showToast(ShowToastOptions(title = errorMsg, position = "bottom", duration = 2000))
                        }
                    }, complete = fun(_res){
                        isLoading.value = false
                    }))
                } else {
                    uni_showToast(ShowToastOptions(title = "未获取到页面元素", position = "bottom", duration = 2000))
                    isLoading.value = false
                }
            }
            val loginIn = ::gen_loginIn_fn
            fun gen_otherLogin_fn() {
                uni_showToast(ShowToastOptions(title = "使用其他方式登录", position = "bottom"))
            }
            val otherLogin = ::gen_otherLogin_fn
            onLoad(fun(options: OnLoadOptions){
                uniVerifyManager.value = uni_getUniVerifyManager()
                phone.value = options["phone"] as String
                slogan.value = options["slogan"] as String
                privacyName.value = options["name"] as String
                privacyUrl.value = options["link"] as String
            }
            )
            return fun(): Any? {
                val _component_page_intro = resolveEasyComponent("page-intro", GenComponentsPageIntroPageIntroClass)
                val _component_checkbox = resolveComponent("checkbox")
                return _cE("view", _uM("class" to "container"), _uA(
                    _cV(_component_page_intro, _uM("content" to "本页为一键登录自定义 uvue 页面：展示号码与 slogan、本机一键登录、隐私协议与其他登录方式。")),
                    _cE("view", _uM("class" to "safe_content"), _uA(
                        _cE("text", _uM("class" to "close_icon", "onClick" to closePage), _tD(unref(closeIcon)), 1),
                        _cE("text", _uM("class" to "title"), "这是一个普通uvue的dialogPage页面"),
                        _cE("view", _uM("class" to "number"), _uA(
                            _cE("text", _uM("id" to "number-text", "class" to "number-text", "ref" to "number-text"), _tD(unref(phone)), 513),
                            _cE("text", _uM("id" to "slogan-text", "class" to "slogan-text"), _tD(unref(slogan)), 1)
                        )),
                        _cE("button", _uM("id" to "login-button", "class" to "login-button", "onClick" to loginIn), "本机号码一键登录"),
                        _cE("view", _uM("class" to "privacy"), _uA(
                            _cV(_component_checkbox, _uM("id" to "privacy-checkbox", "class" to "privacy-checkbox", "ref" to "privacy-checkbox", "checked" to false), null, 512),
                            _cE("text", _uM("class" to "privacy-normal-text"), "登录即同意"),
                            _cE("text", _uM("id" to "privacy-text", "class" to "privacy-text", "onClick" to openLink), _tD(unref(privacyName)), 1)
                        )),
                        _cE("text", _uM("class" to "other", "onClick" to otherLogin), "其他登录方式")
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
                return _uM("container" to _pS(_uM("backgroundColor" to "#FFFFFF", "flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "width" to "100%")), "safe_content" to _pS(_uM("paddingTop" to CSS_VAR_STATUS_BAR_HEIGHT, "width" to "100%", "height" to "100%")), "close_icon" to _pS(_uM("left" to "90%", "top" to 15, "fontFamily" to "uni-icon", "fontSize" to 24)), "title" to _pS(_uM("alignSelf" to "center", "top" to 20)), "number" to _pS(_uM("width" to "100%", "top" to "25%", "position" to "absolute", "height" to 120)), "number-text" to _pS(_uM("width" to "100%", "textAlign" to "center", "fontSize" to 28, "fontWeight" to "bold", "alignSelf" to "center", "height" to 30)), "slogan-text" to _pS(_uM("marginTop" to 10, "width" to "100%", "fontSize" to 13, "textAlign" to "center", "alignSelf" to "center", "color" to "#808080", "height" to 20)), "login-button" to _pS(_uM("width" to "80%", "top" to "40%", "position" to "absolute", "alignSelf" to "center", "backgroundColor" to "#FF4500", "fontSize" to 16, "color" to "#FFFFFF")), "privacy" to _pS(_uM("marginTop" to 10, "flexDirection" to "row", "flexWrap" to "wrap", "top" to "45%", "width" to "100%", "justifyContent" to "center", "alignSelf" to "center", "position" to "absolute")), "privacy-checkbox" to _pS(_uM("transform" to "scale(0.65)")), "privacy-text" to _pS(_uM("marginTop" to 4, "color" to "#007aff", "fontSize" to 14)), "privacy-normal-text" to _pS(_uM("marginTop" to 4, "color" to "#808080", "fontSize" to 14)), "other" to _pS(_uM("bottom" to "7%", "transform" to "translateY(50%)", "position" to "absolute", "alignSelf" to "center", "fontSize" to 14)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
