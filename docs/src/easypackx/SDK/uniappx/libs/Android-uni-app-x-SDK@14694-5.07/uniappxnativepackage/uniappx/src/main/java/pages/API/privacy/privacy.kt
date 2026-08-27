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
import io.dcloud.uniapp.extapi.getPrivacySetting as uni_getPrivacySetting
import io.dcloud.uniapp.extapi.offPrivacyAuthorizationChange as uni_offPrivacyAuthorizationChange
import io.dcloud.uniapp.extapi.onPrivacyAuthorizationChange as uni_onPrivacyAuthorizationChange
import io.dcloud.uniapp.extapi.openDialogPage as uni_openDialogPage
import io.dcloud.uniapp.extapi.resetPrivacyAuthorization as uni_resetPrivacyAuthorization
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesAPIPrivacyPrivacy : BasePage {
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
        var setup: (__props: GenPagesAPIPrivacyPrivacy) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIPrivacyPrivacy
            val _cache = __ins.renderCache
            val title = ref("隐私信息授权")
            val appPrivacy = ref("未获取")
            val privacyContractName = ref("")
            val listenId = ref(0)
            val getPrivacySetting = fun(){
                uni_getPrivacySetting(GetPrivacySettingOptions(success = fun(res){
                    appPrivacy.value = if (res.needAuthorization) {
                        "未同意"
                    } else {
                        "已同意"
                    }
                }
                ))
            }
            val resetPrivacyAuthorization = fun(){
                uni_resetPrivacyAuthorization()
            }
            val openPrivacyDialog = fun(){
                uni_openDialogPage(OpenDialogPageOptions(url = "/pages/component/button/privacy"))
            }
            onReady(fun(){
                val id = uni_onPrivacyAuthorizationChange(fun(res){
                    appPrivacy.value = if (res.needAuthorization) {
                        "未同意"
                    } else {
                        "已同意"
                    }
                    val privacyState = "监听到隐私协议状态已变更为 " + appPrivacy.value
                    uni_showToast(ShowToastOptions(position = "bottom", title = privacyState))
                }
                )
                listenId.value = id
                uni_showToast(ShowToastOptions(position = "bottom", title = "开启监听隐私协议状态"))
            }
            )
            onUnload(fun(){
                uni_offPrivacyAuthorizationChange(listenId.value)
                listenId.value = 0
                uni_showToast(ShowToastOptions(position = "bottom", title = "已停止监听隐私协议状态"))
            }
            )
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                    _cV(_component_page_head, _uM("title" to unref(title)), null, 8, _uA(
                        "title"
                    )),
                    _cE("view", _uM("class" to "item-box"), _uA(
                        _cE("text", null, "当前应用隐私授权状态:"),
                        _cE("text", null, _tD(unref(appPrivacy)), 1)
                    )),
                    _cE("view", null, _uA(
                        _cE("button", _uM("class" to "privacy-button", "type" to "primary", "onClick" to getPrivacySetting), " 获取隐私协议授权状态 "),
                        _cE("button", _uM("class" to "privacy-button", "type" to "primary", "open-type" to "agreePrivacyAuthorization"), " 同意隐私协议专用按钮 "),
                        _cE("button", _uM("class" to "privacy-button", "type" to "primary", "onClick" to resetPrivacyAuthorization), " 重置隐私协议授权状态 "),
                        _cE("button", _uM("class" to "privacy-button", "onClick" to openPrivacyDialog), " 显示隐私政策弹框 ")
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
                return _uM("item-box" to _pS(_uM("marginBottom" to 10, "display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between")), "privacy-button" to _pS(_uM("marginTop" to 5, "marginBottom" to 5)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
