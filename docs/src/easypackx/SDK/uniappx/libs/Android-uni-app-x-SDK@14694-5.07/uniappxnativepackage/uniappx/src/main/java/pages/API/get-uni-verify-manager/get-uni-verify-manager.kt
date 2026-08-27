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
import io.dcloud.uniapp.extapi.getAppBaseInfo as uni_getAppBaseInfo
import io.dcloud.uniapp.extapi.getUniVerifyManager as uni_getUniVerifyManager
import io.dcloud.uniapp.extapi.openDialogPage as uni_openDialogPage
import io.dcloud.uniapp.extapi.showModal as uni_showModal
open class GenPagesAPIGetUniVerifyManagerGetUniVerifyManager : BasePage {
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
        var setup: (__props: GenPagesAPIGetUniVerifyManagerGetUniVerifyManager) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIGetUniVerifyManagerGetUniVerifyManager
            val _cache = __ins.renderCache
            val title = ref("一键登录")
            val uniVerifyManager = ref(null as UniVerifyManager?)
            val phone = ref("")
            val slogan = ref("")
            val privacyName = ref("")
            val privacyUrl = ref("")
            val preLogin = fun(callback: (() -> Unit)){
                uniVerifyManager.value?.preLogin(UniVerifyManagerPreLoginOptions(success = fun(res){
                    phone.value = res.number
                    slogan.value = res.slogan
                    privacyName.value = res.privacyName
                    privacyUrl.value = res.privacyUrl
                    console.log("pre login success")
                    callback()
                }
                , fail = fun(err){
                    console.error("pre login fail => " + JSON.stringify(err))
                    val hasCauseMessage = (err.cause?.cause?.message ?: "").length > 0
                    uni_showModal(ShowModalOptions(title = "预登录失败", content = if (hasCauseMessage) {
                        JSON.parseObject(err.cause?.cause?.message ?: "")?.getString("errorDesc")
                    } else {
                        err.errMsg
                    }
                    , showCancel = false))
                }
                ))
            }
            val pushCustomPage = fun(){
                val url = "/pages/API/get-uni-verify-manager/uni-verify-custom-page?phone=" + phone.value + "&slogan=" + slogan.value + "&name=" + privacyName.value + "&link=" + privacyUrl.value
                uni_openDialogPage(OpenDialogPageOptions(url = url, animationType = "slide-in-bottom", success = fun(res) {
                    console.log("成功打开自定义登录页面")
                }
                , fail = fun(err) {
                    console.log(err)
                }
                ))
            }
            val customLoginIn = fun(){
                if ("production" === "production" && "__UNI__HelloUniAppX" === uni_getAppBaseInfo(null).appId) {
                    uni_showModal(ShowModalOptions(title = "提示", content = "一键登录为收费功能，当前环境暂不支持。请在HBuilderX中新建Hello uni-app x项目真机运行体验！", showCancel = false))
                    return
                }
                val isPreLoginValid = uniVerifyManager.value?.isPreLoginValid() ?: false
                if (isPreLoginValid) {
                    pushCustomPage()
                } else {
                    preLogin(fun(){
                        pushCustomPage()
                    }
                    )
                }
            }
            val takePhoneNumber = fun(accessToken: String, openId: String){
                uniCloud.callFunction(UniCloudCallFunctionOptions(name = "univerify", data = _uO("access_token" to accessToken, "openid" to openId))).then(fun(res){
                    uniVerifyManager.value?.close()
                    setTimeout(fun(){
                        uni_showModal(ShowModalOptions(title = "取号成功", content = res.result.getJSON("res")?.getString("phoneNumber"), showCancel = false))
                    }
                    , 100)
                }
                ).`catch`(fun(err){
                    console.error(JSON.stringify(err))
                    uniVerifyManager.value?.close()
                    setTimeout(fun(){
                        uni_showModal(ShowModalOptions(title = "取号失败", content = (err as UTSError).message, showCancel = false))
                    }
                    , 100)
                }
                )
            }
            val login = fun(fullScreen: Boolean){
                uniVerifyManager.value?.login(UniVerifyManagerLoginOptions(uniVerifyStyle = UniVerifyManagerLoginStyle(fullScreen = fullScreen, loginBtnText = "一键登录", logoPath = "/static/test-image/logo.png"), success = fun(res){
                    console.log("login success => " + JSON.stringify(res))
                    takePhoneNumber(res.accessToken, res.openId)
                }
                , fail = fun(err){
                    console.error("login fail => " + err)
                    val hasCauseMessage = (err.cause?.cause?.message ?: "").length > 0
                    uni_showModal(ShowModalOptions(title = "登录失败", content = if (hasCauseMessage) {
                        JSON.parseObject(err.cause?.cause?.message ?: "")?.getString("errorDesc")
                    } else {
                        err.errMsg
                    }
                    , showCancel = false))
                }
                ))
            }
            val verify = fun(fullScreen: Boolean){
                if ("production" === "production" && "__UNI__HelloUniAppX" === uni_getAppBaseInfo(null).appId) {
                    uni_showModal(ShowModalOptions(title = "提示", content = "一键登录为收费功能，当前环境暂不支持。请在HBuilderX中新建Hello uni-app x项目真机运行体验！", showCancel = false))
                    return
                }
                val isPreLoginValid = uniVerifyManager.value?.isPreLoginValid() ?: false
                if (isPreLoginValid) {
                    login(fullScreen)
                } else {
                    preLogin(fun(){
                        login(fullScreen)
                    }
                    )
                }
            }
            onLoad(fun(_options){
                uniVerifyManager.value = uni_getUniVerifyManager()
                preLogin(fun(){})
            }
            )
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE("view", null, _uA(
                    _cV(_component_page_head, _uM("title" to unref(title)), null, 8, _uA(
                        "title"
                    )),
                    _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt"), _uA(
                        _cE("view", _uM("class" to "uni-btn-v uni-common-mt"), _uA(
                            _cE("button", _uM("type" to "default", "onClick" to fun(){
                                verify(false)
                            }
                            ), "一键登录（半屏）", 8, _uA(
                                "onClick"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-btn-v uni-common-mt"), _uA(
                            _cE("button", _uM("type" to "default", "onClick" to fun(){
                                verify(true)
                            }
                            ), "一键登录（全屏）", 8, _uA(
                                "onClick"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-btn-v uni-common-mt"), _uA(
                            _cE("button", _uM("type" to "default", "onClick" to fun(){
                                customLoginIn()
                            }
                            ), "一键登录（自定义页面）", 8, _uA(
                                "onClick"
                            ))
                        ))
                    ))
                ))
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
