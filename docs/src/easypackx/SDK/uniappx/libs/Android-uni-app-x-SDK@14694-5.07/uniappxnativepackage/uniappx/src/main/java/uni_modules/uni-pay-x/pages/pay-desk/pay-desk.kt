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
import io.dcloud.uniapp.extapi.redirectTo as uni_redirectTo
open class GenUniModulesUniPayXPagesPayDeskPayDesk : BasePage {
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
        var setup: (__props: GenUniModulesUniPayXPagesPayDeskPayDesk) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesUniPayXPagesPayDeskPayDesk
            val _cache = __ins.renderCache
            val myOptions = ref(_uO("total_fee" to ""))
            val insideData = ref(_uO("currentProviders" to _uA<String>(), "images" to _uO("alipay" to "", "wxpay" to "")))
            val adpid = ref("")
            val return_url = ref("")
            val main_color = ref("")
            val payRef = ref<UniPayComponentPublicInstance?>(null)
            fun gen_onMounted_fn(insideData_: UTSJSONObject) {
                insideData.value["currentProviders"] = insideData_.getArray("currentProviders") as UTSArray<String>
                insideData.value["images"] = insideData_.getJSON("images") as UTSJSONObject
            }
            val onMounted__1 = ::gen_onMounted_fn
            fun gen_createOrder_fn(data: UTSJSONObject) {
                myOptions.value = objectAssign(myOptions.value, data)
                if (payRef.value != null) {
                    payRef.value!!.createOrder(myOptions.value)
                }
            }
            val createOrder = ::gen_createOrder_fn
            fun gen_createOrderByProvider_fn(provider: String) {
                createOrder(_uO("provider" to provider))
            }
            val createOrderByProvider = ::gen_createOrderByProvider_fn
            fun gen_onSuccess_fn(res: UTSJSONObject) {
                var out_trade_no = res["out_trade_no"] as String
                var pay_order = res.getJSON("pay_order") as UTSJSONObject
                var order_no = pay_order["order_no"] as String
                var total_fee = pay_order.getNumber("total_fee")
                if (total_fee == null) {
                    total_fee = 0
                }
                var return_url_ = return_url.value as String
                var adpid_ = adpid.value as String
                var main_color_ = main_color.value as String
                console.log("success: ", res)
                var user_order_success = res.getBoolean("user_order_success")
                if (user_order_success != null && user_order_success != true) {
                    uni_redirectTo(RedirectToOptions(url = "/uni_modules/uni-pay-x/pages/success/success?out_trade_no=" + out_trade_no + "&order_no=" + order_no + "&total_fee=" + total_fee + "&adpid=" + adpid_ + "&return_url=" + return_url_ + "&main_color=" + main_color_))
                }
            }
            val onSuccess = ::gen_onSuccess_fn
            fun gen_onFail_fn(err: RequestPaymentFail) {
                console.log("fail: ", err)
            }
            val onFail = ::gen_onFail_fn
            fun gen_onCancel_fn(err: RequestPaymentFail) {
                console.log("cancel: ", err)
            }
            val onCancel = ::gen_onCancel_fn
            fun gen_amountFormat_fn(totalFee: Number?): String {
                if (totalFee == null) {
                    return "0"
                } else {
                    return (totalFee / 100).toFixed(2)
                }
            }
            val amountFormat = ::gen_amountFormat_fn
            fun gen_checkProvider_fn(provider: String): Boolean {
                var currentProviders = insideData.value.getArray<String>("currentProviders")
                return if (currentProviders != null && currentProviders.indexOf(provider) > -1) {
                    true
                } else {
                    false
                }
            }
            val checkProvider = ::gen_checkProvider_fn
            onLoad(fun(options){
                var optionsStr = options["options"] as String?
                if (optionsStr != null && optionsStr != "") {
                    var newOptions = JSON.parse(decodeURI(optionsStr)!!) as UTSJSONObject
                    myOptions.value = newOptions as UTSJSONObject
                }
                console.log("myOptions: ", myOptions.value)
            }
            )
            return fun(): Any? {
                val _component_uni_pay = resolveEasyComponent("uni-pay", GenUniModulesUniPayXComponentsUniPayUniPayClass)
                return _cE("view", _uM("class" to "uni-pay"), _uA(
                    _cE("view", _uM("class" to "mobile-pay-popup"), _uA(
                        _cE("view", _uM("class" to "mobile-pay-popup-amount-box"), _uA(
                            _cE("view", null, _uA(
                                _cE("text", _uM("class" to "mobile-pay-popup-amount-box-text"), "待支付金额：")
                            )),
                            _cE("view", _uM("class" to "mobile-pay-popup-amount"), _uA(
                                _cE("text", _uM("class" to "mobile-pay-popup-amount-text"), _tD(amountFormat(unref(myOptions).getNumber("total_fee"))), 1)
                            ))
                        )),
                        _cE("view", _uM("class" to "mobile-pay-popup-provider-list"), _uA(
                            _cE("view", _uM("class" to "uni-list"), _uA(
                                if (isTrue(checkProvider("wxpay"))) {
                                    _cE("view", _uM("key" to 0, "class" to "uni-list-item", "onClick" to fun(){
                                        createOrderByProvider("wxpay")
                                    }), _uA(
                                        _cE("view", _uM("class" to "uni-list-item__container uni-list-item__container--right"), _uA(
                                            _cE("view", _uM("class" to "uni-list-item__header"), _uA(
                                                _cE("image", _uM("src" to unref(insideData).getJSON("images")!!["wxpay"], "class" to "uni-list-item__header-image"), null, 8, _uA(
                                                    "src"
                                                ))
                                            )),
                                            _cE("view", _uM("class" to "uni-list-item__content uni-list-item__content--center"), _uA(
                                                _cE("text", _uM("class" to "uni-list-item__content-text"), "微信支付")
                                            ))
                                        )),
                                        _cE("view", _uM("class" to "uni-list-item-arrowright"))
                                    ), 8, _uA(
                                        "onClick"
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                                ,
                                if (isTrue(checkProvider("alipay"))) {
                                    _cE("view", _uM("key" to 1, "class" to "uni-list-item", "onClick" to fun(){
                                        createOrderByProvider("alipay")
                                    }), _uA(
                                        _cE("view", _uM("class" to "uni-list-item__container uni-list-item__container--right"), _uA(
                                            _cE("view", _uM("class" to "uni-list-item__header"), _uA(
                                                _cE("image", _uM("src" to unref(insideData).getJSON("images")!!["alipay"], "class" to "uni-list-item__header-image"), null, 8, _uA(
                                                    "src"
                                                ))
                                            )),
                                            _cE("view", _uM("class" to "uni-list-item__content uni-list-item__content--center"), _uA(
                                                _cE("text", _uM("class" to "uni-list-item__content-text"), "支付宝")
                                            ))
                                        )),
                                        _cE("view", _uM("class" to "uni-list-item-arrowright"))
                                    ), 8, _uA(
                                        "onClick"
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                            ))
                        ))
                    )),
                    _cV(_component_uni_pay, _uM("ref_key" to "payRef", "ref" to payRef, "height" to "450px", "to-success-page" to false, "onMounted" to onMounted__1, "onSuccess" to onSuccess, "onFail" to onFail, "onCancel" to onCancel), null, 512)
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
                return _uM("uni-pay" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "display" to "flex", "flexDirection" to "column", "backgroundColor" to "#f3f3f3")), "mobile-pay-popup" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "mobile-pay-popup-amount-box" to _pS(_uM("backgroundColor" to "#ffffff", "paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15)), "mobile-pay-popup-amount-box-text" to _pS(_uM("color" to "#333333", "fontSize" to 14)), "mobile-pay-popup-amount" to _pS(_uM("marginTop" to 10)), "mobile-pay-popup-amount-text" to _pS(_uM("color" to "#e43d33", "fontSize" to 30)), "mobile-pay-popup-provider-list" to _pS(_uM("backgroundColor" to "#ffffff", "marginTop" to 10)), "uni-list" to _pS(_uM("display" to "flex", "backgroundColor" to "#ffffff", "position" to "relative", "flexDirection" to "column")), "uni-list-item" to _pS(_uM("display" to "flex", "position" to "relative", "justifyContent" to "space-between", "alignItems" to "center", "backgroundColor" to "#ffffff", "flexDirection" to "row", "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#f8f8f8", "backgroundColor:hover" to "#f1f1f1")), "uni-list-item__container" to _pS(_uM("position" to "relative", "display" to "flex", "flexDirection" to "row", "paddingTop" to 12, "paddingRight" to 15, "paddingBottom" to 12, "paddingLeft" to 15, "flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "overflow" to "hidden")), "uni-list-item__container--right" to _pS(_uM("paddingRight" to 0)), "uni-list-item__header" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center")), "uni-list-item__header-image" to _pS(_uM("width" to 26, "height" to 26, "marginRight" to 9)), "uni-list-item__content" to _pS(_uM("display" to "flex", "paddingRight" to 8, "flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "flexDirection" to "column", "justifyContent" to "space-between", "overflow" to "hidden")), "uni-list-item__content-text" to _pS(_uM("color" to "#3b4144", "fontSize" to 14)), "uni-list-item__content--center" to _pS(_uM("justifyContent" to "center")), "uni-list-item-arrowright" to _pS(_uM("borderTopWidth" to 1, "borderTopStyle" to "solid", "borderTopColor" to "#bbbbbb", "borderRightWidth" to 1, "borderRightStyle" to "solid", "borderRightColor" to "#bbbbbb", "width" to 8, "height" to 8, "marginRight" to 15, "transform" to "rotate(45deg)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
