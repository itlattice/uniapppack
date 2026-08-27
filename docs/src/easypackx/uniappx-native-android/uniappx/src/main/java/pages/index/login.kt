@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNI2971F61
import android.content.Context
import io.dcloud.uniapp.*
import io.dcloud.uniapp.extapi.*
import io.dcloud.uniapp.framework.*
import io.dcloud.uniapp.runtime.*
import io.dcloud.uniapp.vue.*
import io.dcloud.uniapp.vue.shared.*
import io.dcloud.uts.*
import io.dcloud.uts.Map
import io.dcloud.uts.Set
import io.dcloud.uts.UTSAndroid
import kotlin.properties.Delegates
import uts.sdk.modules.iboxsChooseMedia.MediaScanner
import io.dcloud.uniapp.extapi.`$emit` as uni__emit
import io.dcloud.uniapp.extapi.setNavigationBarColor as uni_setNavigationBarColor
import uts.sdk.modules.xMd5.str2Md5
import io.dcloud.uniapp.extapi.switchTab as uni_switchTab
open class GenPagesIndexLogin : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            xProvitae.scrollTop = e.scrollTop
            val pages = getCurrentPages()
            if (pages.length == 0) {
                return
            }
            val page = pages[pages.length - 1].route
            uni__emit("onPageScroll", _uO("top" to e.scrollTop, "page" to page))
        }
        , __ins)
        onResize(fun(_: OnResizeOptions) {
            uni__emit("onResize", fun() {})
        }
        , __ins)
        onLoad(fun(query: OnLoadOptions) {
            xProvitae.onLoadOpts = JSON.parseObject(JSON.stringify(query)!!) ?: _uO()
            uni__emit("onLoad", fun() {})
        }
        , __ins)
        onPageHide(fun() {
            uni__emit("onHide", fun() {})
        }
        , __ins)
        onReady(fun() {
            uni__emit("onReady", fun() {})
            xProvitae.pageReady = true
        }
        , __ins)
        onPageShow(fun() {
            uni__emit("onShow", fun() {})
        }
        , __ins)
    }
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesIndexLogin) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesIndexLogin
            val _cache = __ins.renderCache
            val phone = ref("")
            val password = ref("")
            val userFocus = ref(true)
            val pwdFocus = ref(false)
            val formloading = ref<UniElement?>(null)
            val loginAction = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var permission = _uA(
                            "android.permission.VIBRATE"
                        )
                        UTSAndroid.requestSystemPermission(UTSAndroid.getUniActivity()!!, permission, fun(allRight: Boolean, grantedList: UTSArray<String>){
                            console.log(uts.sdk.modules.iboxsCommon.vibrate(500))
                        }
                        , fun(doNotAskAgain: Boolean, grantedList: UTSArray<String>){
                            return
                        }
                        )
                        if (phone.value == "" || password.value == "") {
                            common.toast("请输入信息")
                            return@w1
                        }
                        var data: UTSJSONObject = _uO("phone" to phone.value, "password" to str2Md5(password.value))
                        common.loading(formloading.value as Any)
                        var res = await(request.callapi("login", data, ""))
                        common.hideLoading(formloading.value as Any)
                        if (res == null) {
                            return@w1
                        }
                        console.log("asdasd", res.code as Number)
                        if (res.code != -401.2 && (res.code as Number) < 0) {
                            common.toast(res.msg as String)
                            return@w1
                        }
                        userObject.loginAfter()
                        console.log("成功")
                        common.toast(res.msg)
                        var d = res.data as UTSJSONObject
                        var pos = _uA<positionInfo>()
                        if (d["role_depart"] != null) {
                            var arr = d["role_depart"] as UTSArray<UTSJSONObject>
                            run {
                                var i: Number = 0
                                while(i < arr.length){
                                    var item = arr[i]
                                    pos.push(positionInfo(position_id = item["position_id"], position_name = item["position_name"], department_id = item["department_id"], department_name = item["department_name"]))
                                    i++
                                }
                            }
                        }
                        var user = userInfoType(id = d["id"] as Number, token = d["token"] as String, name = d["name"] as String, shop = d["shop"].toString(), no = d["no"].toString(), head = d["head"].toString(), position = pos)
                        console.log("shiii")
                        console.log(user)
                        setUser(user)
                        console.log("555150")
                        common.setStorage("usertoken", d["token"] as Any)
                        common.setStorage("username", phone.value)
                        var uinfo = await(request.getUserInfo())
                        if (uinfo) {
                            uni_switchTab(SwitchTabOptions(url = "/pages/index/index"))
                        } else {
                            common.toast("用户信息获取失败，请重试")
                            setUser(userInfoType())
                            WebSocket.stopWebsocket()
                        }
                })
            }
            onLoad(fun(_options){
                var user = common.getStorage("username")
                if (user != "") {
                    phone.value = user as String
                    if (phone.value.length > 0) {
                        userFocus.value = false
                        pwdFocus.value = true
                    }
                }
            }
            )
            onShow(fun(){
                uni_setNavigationBarColor(SetNavigationBarColorOptions(frontColor = "#000000", backgroundColor = "transparent"))
                var user = state.user
                if (user.id != null && (user?.id as Number) > 0) {
                    uni_switchTab(SwitchTabOptions(url = "/pages/index/index"))
                }
            }
            )
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_x_button = resolveEasyComponent("x-button", GenComponentsXButtonClass)
                val _component_x_loading = resolveEasyComponent("x-loading", GenComponentsXLoadingClass)
                return _cE("view", _uM("class" to "loginpage"), _uA(
                    _cE("view", _uM("class" to "native padding-stauts-bar"), _uA(
                        _cE("text", _uM("class" to "text align-center"), "超市管理终端")
                    )),
                    _cE("view", _uM("class" to "logo margin-center"), _uA(
                        _cE("image", _uM("mode" to "aspectFit", "style" to _nS(_uM("height" to "120rpx", "width" to "120rpx")), "src" to "/static/logo/market_logo.png"), null, 4)
                    )),
                    _cE("view", _uM("class" to "loginform"), _uA(
                        _cE("view", _uM("class" to "logininput display-flex margin-center"), _uA(
                            _cV(_component_x_iconfont, _uM("size" to "16", "color" to "#8f8f8f", "style" to _nS(_uM("margin-top" to "45rpx")), "name" to "icon"), null, 8, _uA(
                                "style"
                            )),
                            _cE("input", _uM("type" to "tel", "modelValue" to unref(phone), "onInput" to fun(`$event`: UniInputEvent){
                                trySetRefValue(phone, `$event`.detail.value)
                            }
                            , "maxlength" to "11", "focus" to unref(userFocus), "class" to "inp", "placeholder" to "请输入手机号码"), null, 40, _uA(
                                "modelValue",
                                "focus"
                            ))
                        )),
                        _cE("view", _uM("class" to "logininput display-flex margin-center"), _uA(
                            _cV(_component_x_iconfont, _uM("size" to "16", "color" to "#8f8f8f", "style" to _nS(_uM("margin-top" to "45rpx")), "name" to "icon2"), null, 8, _uA(
                                "style"
                            )),
                            _cE("input", _uM("type" to "text", "onConfirm" to loginAction, "modelValue" to unref(password), "onInput" to fun(`$event`: UniInputEvent){
                                trySetRefValue(password, `$event`.detail.value)
                            }
                            , "focus" to unref(pwdFocus), "maxlength" to "32", "class" to "inp", "password" to "true", "placeholder" to "请输入密码"), null, 40, _uA(
                                "modelValue",
                                "focus"
                            ))
                        ))
                    )),
                    _cE("view", _uM("class" to "loginbtn margin-center"), _uA(
                        _cV(_component_x_button, _uM("class" to "lbtn background-main color-white", "onClick" to loginAction), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                "登录"
                            )
                        }
                        ), "_" to 1))
                    )),
                    _cV(_component_x_loading, _uM("ref_key" to "formloading", "ref" to formloading), null, 512)
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
                return _uM("text" to _uM(".loginpage .native " to _uM("paddingTop" to "10rpx", "fontSize" to "32rpx", "color" to "#000000", "paddingBottom" to "10rpx"), ".loginpage .loginbtn .lbtn " to _uM("fontSize" to "32rpx")), "logo" to _uM(".loginpage " to _uM("marginTop" to "89rpx", "width" to "120rpx", "height" to "120rpx")), "loginform" to _uM(".loginpage " to _uM("marginTop" to "30rpx")), "logininput" to _uM(".loginpage .loginform " to _uM("height" to "93rpx", "width" to "630rpx", "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#F0F0F0")), "inp" to _uM(".loginpage .loginform .logininput " to _uM("marginTop" to "40rpx", "height" to "40rpx", "paddingLeft" to "20rpx")), "loginbtn" to _uM(".loginpage " to _uM("width" to "630rpx", "height" to "75rpx", "marginTop" to 27)), "lbtn" to _uM(".loginpage .loginbtn " to _uM("borderTopLeftRadius" to "37.5rpx", "borderTopRightRadius" to "37.5rpx", "borderBottomRightRadius" to "37.5rpx", "borderBottomLeftRadius" to "37.5rpx", "height" to "75rpx", "lineHeight" to "75rpx", "borderTopColor" to "rgba(0,0,0,0)", "borderRightColor" to "rgba(0,0,0,0)", "borderBottomColor" to "rgba(0,0,0,0)", "borderLeftColor" to "rgba(0,0,0,0)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
