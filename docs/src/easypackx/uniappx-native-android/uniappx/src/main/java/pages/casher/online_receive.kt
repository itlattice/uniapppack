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
import uts.sdk.modules.uniUsercapturescreen.SetUserCaptureScreenOptions
import uts.sdk.modules.uniUsercapturescreen.setUserCaptureScreen as uni_setUserCaptureScreen
open class GenPagesCasherOnlineReceive : BasePage {
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
        var setup: (__props: GenPagesCasherOnlineReceive) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCasherOnlineReceive
            val _cache = __ins.renderCache
            val proxy = getCurrentInstance()!!.proxy as Any
            val amount = ref(0)
            val reson = ref("")
            val member = ref("0")
            val bill = ref("")
            val img = ref("")
            val formloading = ref<UniElement?>(null)
            val amountStr = computed(fun(): String {
                return amount.value.toFixed(2)
            }
            )
            onLoad(fun(options){
                console.log(options)
                amount.value = parseFloat(options["amount"] as String)
                reson.value = options["reson"] as String
                member.value = if (options["member"] == "null") {
                    "0"
                } else {
                    options["member"]
                }
                 as String
                bill.value = options["bill"] as String
                uni_setUserCaptureScreen(SetUserCaptureScreenOptions(enable = false))
            }
            )
            val createCode = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        common.loading(formloading.value as Any)
                        var res = await(request.callapi("payment/createreceivecode", _uO("amount" to amount.value, "reson" to reson.value, "member" to member.value, "bill" to bill.value)))
                        common.hideLoading(formloading.value as Any)
                        if (res.code < 0) {
                            common.toast(res.msg)
                            common.back()
                            return@w1
                        }
                        var data = res.data as UTSJSONObject
                        img.value = data["qrcode"] as String
                })
            }
            onReady(fun(){
                createCode()
            }
            )
            val back = fun(){
                common.back()
            }
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_x_loading = resolveEasyComponent("x-loading", GenComponentsXLoadingClass)
                return _cE("view", _uM("class" to "onlinereceive"), _uA(
                    _cE("view", _uM("class" to "navigat padding-stauts-bar display-flex"), _uA(
                        _cV(_component_x_iconfont, _uM("onClick" to back, "class" to "icon", "name" to "fanhui", "color" to "white", "size" to "18")),
                        _cE("text", _uM("class" to "text color-white"), "在线收款")
                    )),
                    _cE("view", _uM("class" to "cashbox background-white position-relative"), _uA(
                        _cE("view", _uM("class" to "title display-flex"), _uA(
                            _cV(_component_x_iconfont, _uM("name" to "shoukuanguanli", "size" to "18", "color" to "#000000")),
                            _cE("text", _uM("class" to "text"), "在线收款")
                        )),
                        _cE("text", _uM("class" to "reson align-center"), _tD(if (unref(reson) == "") {
                            "收款码"
                        } else {
                            unref(reson)
                        }
                        ), 1),
                        _cE("view", _uM("class" to "qrcode margin-center"), _uA(
                            _cE("image", _uM("class" to "qrcodeimg", "src" to unref(img)), null, 8, _uA(
                                "src"
                            ))
                        )),
                        _cE("view", _uM("class" to "display-flex amount margin-center"), _uA(
                            _cE("text", _uM("class" to "fuhao"), "￥"),
                            _cE("text", _uM("class" to "number font-bold color-red"), _tD(unref(amountStr)), 1)
                        )),
                        _cE("view", _uM("class" to "list position-absolute space-between width-full"), _uA(
                            _cE("view", _uM("class" to "content display-flex"), _uA(
                                _cV(_component_x_iconfont, _uM("class" to "icon", "size" to "18", "color" to "#616161", "name" to "shoukuanjilu")),
                                _cE("text", _uM("class" to "text"), "收款记录")
                            )),
                            _cV(_component_x_iconfont, _uM("class" to "iconyou", "name" to "xiangyou1", "size" to "18", "color" to "#C4C4C4"))
                        ))
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
                return _uM("onlinereceive" to _pS(_uM("width" to "750rpx", "height" to "100%", "backgroundImage" to "linear-gradient(to bottom, #1776FC, #1776fc80)")), "navigat" to _uM(".onlinereceive " to _uM("height" to 50)), "icon" to _uM(".onlinereceive .navigat " to _uM("paddingLeft" to "10rpx", "paddingTop" to 5)), "text" to _uM(".onlinereceive .navigat " to _uM("paddingTop" to 5, "paddingLeft" to "5rpx", "fontSize" to 15), ".onlinereceive .cashbox .title " to _uM("paddingLeft" to "10rpx", "fontSize" to 14), ".onlinereceive .cashbox .list .content " to _uM("paddingTop" to "4rpx", "paddingLeft" to "8rpx", "fontSize" to 13, "color" to "#4A4A4A")), "cashbox" to _uM(".onlinereceive " to _uM("width" to "638rpx", "height" to "811rpx", "borderTopLeftRadius" to "17rpx", "borderTopRightRadius" to "17rpx", "borderBottomRightRadius" to "17rpx", "borderBottomLeftRadius" to "17rpx", "marginTop" to 40, "marginLeft" to "56rpx", "paddingTop" to "19rpx", "paddingRight" to "16rpx")), "title" to _uM(".onlinereceive .cashbox " to _uM("paddingLeft" to "23rpx")), "reson" to _uM(".onlinereceive .cashbox " to _uM("marginTop" to "40rpx", "fontSize" to 14, "color" to "#000000")), "list" to _uM(".onlinereceive .cashbox " to _uM("bottom" to 0, "borderTopWidth" to 1, "borderTopStyle" to "solid", "borderTopColor" to "#f5f5f5", "height" to "68rpx")), "content" to _uM(".onlinereceive .cashbox .list " to _uM("paddingLeft" to "15rpx", "paddingTop" to "15rpx")), "iconyou" to _uM(".onlinereceive .cashbox .list " to _uM("paddingTop" to "12rpx", "paddingRight" to "15rpx")), "qrcode" to _uM(".onlinereceive .cashbox " to _uM("width" to "430rpx", "height" to "430rpx", "marginTop" to "38rpx")), "qrcodeimg" to _uM(".onlinereceive .cashbox .qrcode " to _uM("width" to "430rpx", "height" to "430rpx")), "amount" to _uM(".onlinereceive .cashbox " to _uM("marginTop" to "26rpx")), "fuhao" to _uM(".onlinereceive .cashbox .amount " to _uM("fontSize" to 14, "color" to "#000000", "lineHeight" to "33px")), "number" to _uM(".onlinereceive .cashbox .amount " to _uM("fontSize" to 23)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
