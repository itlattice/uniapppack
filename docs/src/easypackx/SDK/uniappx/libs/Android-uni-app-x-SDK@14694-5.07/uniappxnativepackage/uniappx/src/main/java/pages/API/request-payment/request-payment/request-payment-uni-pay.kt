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
import io.dcloud.uniapp.extapi.getSystemInfoSync as uni_getSystemInfoSync
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
import io.dcloud.uniapp.extapi.showModal as uni_showModal
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesAPIRequestPaymentRequestPaymentRequestPaymentUniPay : BasePage {
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
        var setup: (__props: GenPagesAPIRequestPaymentRequestPaymentRequestPaymentUniPay) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIRequestPaymentRequestPaymentRequestPaymentUniPay
            val _cache = __ins.renderCache
            val total_fee = ref("1")
            val order_no = ref("")
            val out_trade_no = ref("")
            val description = ref("测试订单")
            val type = ref("test")
            val openid = ref("")
            val custom = ref(_uO("a" to "a", "b" to 1))
            val adpid = ref("1000000001")
            val transaction_id = ref("")
            val getOrderRes = ref(_uO())
            val useUniCloud = ref(true)
            val errMsg = ref("")
            val payRef = ref<UniPayComponentPublicInstance?>(null)
            val getOrderPopupRef = ref<UniPayPopupComponentPublicInstance?>(null)
            val h5Env = computed(fun(): String {
                return ""
            }
            )
            val isIosAppCom = computed(fun(): Boolean {
                var info = uni_getSystemInfoSync()
                return if (info.uniPlatform == "app" && info.osName == "ios") {
                    true
                } else {
                    false
                }
            }
            )
            val isPcCom = computed(fun(): Boolean {
                var isPC = false
                return isPC
            }
            )
            val open = fun(){
                order_no.value = "test" + Date.now()
                out_trade_no.value = "" + order_no.value + "-1"
                val payInstance = payRef.value as UniPayComponentPublicInstance
                payInstance.open(_uO("total_fee" to parseInt(total_fee.value), "order_no" to order_no.value, "out_trade_no" to out_trade_no.value, "description" to description.value, "type" to type.value, "openid" to openid.value, "custom" to custom.value, "qr_code" to isPcCom.value))
            }
            val createOrder = fun(provider: String){
                order_no.value = "test" + Date.now()
                out_trade_no.value = "" + order_no.value + "-1"
                val payInstance = payRef.value as UniPayComponentPublicInstance
                payInstance.createOrder(_uO("provider" to provider, "total_fee" to parseInt(total_fee.value), "order_no" to order_no.value, "out_trade_no" to out_trade_no.value, "description" to description.value, "type" to type.value, "openid" to openid.value, "custom" to custom.value, "qr_code" to isPcCom.value))
            }
            val createQRcode = fun(provider: String){
                order_no.value = "test" + Date.now()
                out_trade_no.value = "" + order_no.value + "-1"
                val payInstance = payRef.value as UniPayComponentPublicInstance
                payInstance.createOrder(_uO("provider" to provider, "total_fee" to parseInt(total_fee.value), "order_no" to order_no.value, "out_trade_no" to out_trade_no.value, "description" to description.value, "type" to type.value, "qr_code" to true, "openid" to openid.value, "custom" to custom.value))
            }
            val toPayDesk = fun(){
                order_no.value = "test" + Date.now()
                out_trade_no.value = "" + order_no.value + "-1"
                var options: UTSJSONObject = _uO("total_fee" to parseInt(total_fee.value), "order_no" to order_no.value, "out_trade_no" to out_trade_no.value, "description" to description.value, "type" to type.value, "openid" to openid.value, "custom" to custom.value)
                var optionsStr = encodeURI(JSON.stringify(options))
                uni_navigateTo(NavigateToOptions(url = "/uni_modules/uni-pay-x/pages/pay-desk/pay-desk?options=" + optionsStr))
            }
            val getOrderPopup = fun(key: Boolean){
                val getOrderPopupInstance = getOrderPopupRef.value as UniPayPopupComponentPublicInstance
                if (key) {
                    getOrderPopupInstance.open()
                } else {
                    getOrderPopupInstance.close()
                }
            }
            val getOrder = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        getOrderRes.value = _uO()
                        val payInstance = payRef.value as UniPayComponentPublicInstance
                        var getOrderData: UTSJSONObject = _uO("await_notify" to true)
                        if (transaction_id.value != "") {
                            getOrderData["transaction_id"] = transaction_id.value
                        } else if (out_trade_no.value != "") {
                            getOrderData["out_trade_no"] = out_trade_no.value
                        }
                        var res = await(payInstance.getOrder(getOrderData))
                        if (res["errCode"] == 0) {
                            getOrderRes.value = res.getJSON("pay_order") as UTSJSONObject
                            var obj: UTSJSONObject = _uO("-1" to "已关闭", "1" to "已支付", "0" to "未支付", "2" to "已部分退款", "3" to "已全额退款")
                            var status = res["status"] as Number
                            var statusStr = status + ""
                            var title = obj[statusStr] as String
                            uni_showToast(ShowToastOptions(title = title, icon = "none"))
                        }
                })
            }
            val onCreate = fun(res: UTSJSONObject){
                console.log("create: ", res)
            }
            val onSuccess = fun(res: UTSJSONObject){
                console.log("success: ", res)
                var user_order_success = res.getBoolean("user_order_success")
                if (user_order_success != null && user_order_success != true) {}
            }
            val onFail = fun(err: UTSJSONObject){
                console.log("fail: ", err)
            }
            val onCancel = fun(err: UTSJSONObject){
                console.log("cancel: ", err)
                uni_showToast(ShowToastOptions(title = "用户取消了支付", icon = "none"))
            }
            val pageTo = fun(url: String){
                uni_navigateTo(NavigateToOptions(url = url))
            }
            val providerFormat = fun(provider: String?): String {
                if (provider == null) {
                    return ""
                }
                var providerObj: UTSJSONObject = _uO("wxpay" to "微信支付", "alipay" to "支付宝支付", "appleiap" to "ios内购")
                var providerStr = providerObj[provider] as String
                return providerStr
            }
            val amountFormat = fun(totalFee: Number?): String {
                if (totalFee == null) {
                    return "0"
                } else {
                    return (totalFee / 100).toFixed(2)
                }
            }
            val checkUniCloud = fun(): Boolean {
                var useUniCloudResult = false
                if (UTSAndroid.`typeof`(uniCloud) != "undefined" && UTSAndroid.`typeof`(uniCloud.config) == "object" && uniCloud.config.spaceId != "") {
                    useUniCloudResult = true
                }
                if (!useUniCloudResult) {
                    var errMsgText = "本示例依赖 uniCloud，请先关联服务空间，填写正确的支付配置，支付配置文件地址：/uni_modules/uni-config-center/uniCloud/cloudfunctions/common/uni-config-center/uni-pay/config.js"
                    errMsg.value = errMsgText
                    uni_showModal(ShowModalOptions(title = "提示", content = errMsgText, showCancel = false))
                    console.error(errMsgText)
                }
                return useUniCloudResult
            }
            onLoad(fun(options){
                console.log("onLoad: ", options)
                useUniCloud.value = checkUniCloud()
            }
            )
            return fun(): Any? {
                val _component_uni_pay_popup = resolveEasyComponent("uni-pay-popup", GenUniModulesUniPayXComponentsUniPayPopupUniPayPopupClass)
                val _component_uni_pay = resolveEasyComponent("uni-pay", GenUniModulesUniPayXComponentsUniPayUniPayClass)
                return _cE("view", _uM("class" to "app"), _uA(
                    _cE("view", _uM("class" to "uni-common-mb"), _uA(
                        _cE("text", null, "如对当前页面的支付示例功能有任何疑问，通过在线IM联系我们 https://im.dcloud.net.cn/#/?joinGroup=662b3d7e8551460030874a5d")
                    )),
                    if (unref(errMsg) != "") {
                        _cE("view", _uM("key" to 0), _uA(
                            _cE("text", _uM("class" to "err-msg"), "注意：" + _tD(unref(errMsg)), 1)
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    _cE("view", null, _uA(
                        _cE("view", _uM("class" to "margin"), _uA(
                            _cE("text", null, "支付单号：")
                        )),
                        _cE("view", null, _uA(
                            _cE("input", _uM("class" to "input", "modelValue" to unref(out_trade_no), "onInput" to fun(`$event`: UniInputEvent){
                                trySetRefValue(out_trade_no, `$event`.detail.value)
                            }
                            , "placeholder" to "点击发起支付会自动生成"), null, 40, _uA(
                                "modelValue"
                            ))
                        ))
                    )),
                    _cE("view", null, _uA(
                        _cE("view", _uM("class" to "margin"), _uA(
                            _cE("text", null, "支付金额（单位分，100=1元）：")
                        )),
                        _cE("view", null, _uA(
                            _cE("input", _uM("class" to "input", "modelValue" to unref(total_fee), "onInput" to fun(`$event`: UniInputEvent){
                                trySetRefValue(total_fee, `$event`.detail.value)
                            }
                            ), null, 40, _uA(
                                "modelValue"
                            ))
                        ))
                    )),
                    _cE("button", _uM("class" to "button", "onClick" to fun(){
                        open()
                    }
                    ), "打开收银台（弹窗模式）", 8, _uA(
                        "onClick"
                    )),
                    if (isTrue(!unref(isPcCom))) {
                        _cE("view", _uM("key" to 1), _uA(
                            _cE("button", _uM("class" to "button", "onClick" to toPayDesk), "打开收银台（新页面模式）")
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    _cE("button", _uM("class" to "button", "onClick" to fun(){
                        createOrder("wxpay")
                    }
                    ), "发起支付（微信）", 8, _uA(
                        "onClick"
                    )),
                    _cE("button", _uM("class" to "button", "onClick" to fun(){
                        createOrder("alipay")
                    }
                    ), "发起支付（支付宝）", 8, _uA(
                        "onClick"
                    )),
                    _cE("button", _uM("class" to "button", "onClick" to fun(){
                        createQRcode("alipay")
                    }
                    ), "APP扫码支付（支付宝）", 8, _uA(
                        "onClick"
                    )),
                    _cE("button", _uM("class" to "button", "onClick" to fun(){
                        getOrderPopup(true)
                    }
                    ), "查询支付状态", 8, _uA(
                        "onClick"
                    )),
                    _cE("button", _uM("class" to "button", "onClick" to fun(){
                        pageTo("/uni_modules/uni-pay-x/pages/success/success?out_trade_no=test2024030501-1&order_no=test2024030501&total_fee=1&adpid=1000000001&return_url=/pages/API/request-payment/request-payment/order-detail")
                    }
                    ), "支付成功页面示例", 8, _uA(
                        "onClick"
                    )),
                    _cV(_component_uni_pay_popup, _uM("ref_key" to "getOrderPopupRef", "ref" to getOrderPopupRef, "type" to "center"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("scroll-view", _uM("direction" to "vertical", "class" to "get-order-popup"), _uA(
                                _cE("view", _uM("class" to "margin"), "插件支付单号："),
                                _cE("view", _uM("class" to "mt20"), _uA(
                                    _cE("input", _uM("class" to "input pd2030", "modelValue" to unref(out_trade_no), "onInput" to fun(`$event`: UniInputEvent){
                                        trySetRefValue(out_trade_no, `$event`.detail.value)
                                    }
                                    , "placeholder" to "请输入"), null, 40, _uA(
                                        "modelValue"
                                    )),
                                    _cE("view", null, _uA(
                                        _cE("text", _uM("class" to "tips"), "插件支付单号和第三方交易单号2选1填即可")
                                    ))
                                )),
                                _cE("view", _uM("class" to "margin"), "第三方交易单号："),
                                _cE("view", _uM("class" to "mt20"), _uA(
                                    _cE("input", _uM("class" to "input pd2030", "modelValue" to unref(transaction_id), "onInput" to fun(`$event`: UniInputEvent){
                                        trySetRefValue(transaction_id, `$event`.detail.value)
                                    }
                                    , "placeholder" to "请输入"), null, 40, _uA(
                                        "modelValue"
                                    )),
                                    _cE("view", null, _uA(
                                        _cE("text", _uM("class" to "tips"), "可从支付宝账单（订单号）、微信账单（交易单号）中复制")
                                    ))
                                )),
                                _cE("view", _uM("class" to "mt20"), _uA(
                                    _cE("button", _uM("class" to "button", "onClick" to getOrder), "查询支付状态")
                                )),
                                if (isTrue(unref(getOrderRes)["transaction_id"])) {
                                    _cE("view", _uM("key" to 0, "class" to "mt20"), _uA(
                                        _cE("view", _uM("class" to "table"), _uA(
                                            _cE("view", _uM("class" to "table-tr"), _uA(
                                                _cE("view", _uM("class" to "table-td label"), _uA(
                                                    _cE("text", _uM("class" to "text align-left"), "订单描述")
                                                )),
                                                _cE("view", _uM("class" to "table-td"), _uA(
                                                    _cE("text", _uM("class" to "text align-right"), _tD(unref(getOrderRes)["description"]), 1)
                                                ))
                                            )),
                                            _cE("view", _uM("class" to "table-tr"), _uA(
                                                _cE("view", _uM("class" to "table-td label"), _uA(
                                                    _cE("text", _uM("class" to "text align-left"), "支付金额")
                                                )),
                                                _cE("view", _uM("class" to "table-td"), _uA(
                                                    _cE("text", _uM("class" to "text align-right"), _tD(amountFormat(unref(getOrderRes).getNumber("total_fee"))), 1)
                                                ))
                                            )),
                                            _cE("view", _uM("class" to "table-tr"), _uA(
                                                _cE("view", _uM("class" to "table-td label"), _uA(
                                                    _cE("text", _uM("class" to "text align-left"), "支付方式")
                                                )),
                                                _cE("view", _uM("class" to "table-td"), _uA(
                                                    _cE("text", _uM("class" to "text align-right"), _tD(providerFormat(unref(getOrderRes)["provider"] as String)), 1)
                                                ))
                                            )),
                                            _cE("view", _uM("class" to "table-tr"), _uA(
                                                _cE("view", _uM("class" to "table-td label"), _uA(
                                                    _cE("text", _uM("class" to "text align-left"), "第三方交易单号")
                                                )),
                                                _cE("view", _uM("class" to "table-td"), _uA(
                                                    _cE("text", _uM("class" to "text align-right"), _tD(unref(getOrderRes)["transaction_id"]), 1)
                                                ))
                                            )),
                                            _cE("view", _uM("class" to "table-tr"), _uA(
                                                _cE("view", _uM("class" to "table-td label"), _uA(
                                                    _cE("text", _uM("class" to "text align-left"), "插件支付单号")
                                                )),
                                                _cE("view", _uM("class" to "table-td"), _uA(
                                                    _cE("text", _uM("class" to "text align-right"), _tD(unref(getOrderRes)["out_trade_no"]), 1)
                                                ))
                                            )),
                                            _cE("view", _uM("class" to "table-tr"), _uA(
                                                _cE("view", _uM("class" to "table-td label"), _uA(
                                                    _cE("text", _uM("class" to "text align-left"), "回调状态")
                                                )),
                                                _cE("view", _uM("class" to "table-td"), _uA(
                                                    _cE("text", _uM("class" to "text align-right"), _tD(if (unref(getOrderRes).getBoolean("user_order_success") != null && unref(getOrderRes).getBoolean("user_order_success") == true) {
                                                        "成功"
                                                    } else {
                                                        "异常"
                                                    }), 1)
                                                ))
                                            ))
                                        ))
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                            ))
                        )
                    }
                    ), "_" to 1), 512),
                    _cV(_component_uni_pay, _uM("ref_key" to "payRef", "ref" to payRef, "adpid" to unref(adpid), "height" to "450px", "return-url" to "/pages/API/request-payment/request-payment/order-detail", "logo" to "/static/test-image/logo.png", "onSuccess" to onSuccess, "onCreate" to onCreate, "onFail" to onFail, "onCancel" to onCancel), null, 8, _uA(
                        "adpid"
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
                return _uM("app" to _pS(_uM("paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15)), "input" to _pS(_uM("borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#f3f3f3", "borderRightColor" to "#f3f3f3", "borderBottomColor" to "#f3f3f3", "borderLeftColor" to "#f3f3f3", "paddingTop" to 5, "paddingRight" to 5, "paddingBottom" to 5, "paddingLeft" to 5, "width" to "100%", "boxSizing" to "border-box", "height" to 40, "backgroundImage" to "none", "backgroundColor" to "#FFFFFF")), "button" to _pS(_uM("marginTop" to 10)), "margin" to _pS(_uM("marginTop" to 5, "marginRight" to 0, "marginBottom" to 5, "marginLeft" to 0)), "tips" to _pS(_uM("marginTop" to 10, "marginRight" to 0, "marginBottom" to 10, "marginLeft" to 0, "fontSize" to 12, "color" to "#565656")), "get-order-popup" to _pS(_uM("backgroundColor" to "#ffffff", "paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15, "height" to 450, "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "borderBottomRightRadius" to 10, "borderBottomLeftRadius" to 10, "width" to "100%")), "mt20" to _pS(_uM("marginTop" to 10)), "pd2030" to _pS(_uM("paddingTop" to 10, "paddingRight" to 15, "paddingBottom" to 10, "paddingLeft" to 15)), "table-tr" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center", "paddingTop" to 5, "paddingRight" to 0, "paddingBottom" to 5, "paddingLeft" to 0)), "table-td" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "align-left" to _pS(_uM("textAlign" to "left")), "align-right" to _pS(_uM("textAlign" to "right")), "label" to _pS(_uM("width" to 90)), "text" to _pS(_uM("fontSize" to 12)), "err-msg" to _pS(_uM("color" to "#FF0000", "fontSize" to 14)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
