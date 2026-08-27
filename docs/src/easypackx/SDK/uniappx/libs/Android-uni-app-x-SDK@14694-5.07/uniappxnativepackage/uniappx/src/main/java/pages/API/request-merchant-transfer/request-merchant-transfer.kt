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
import io.dcloud.uniapp.extapi.getProviderSync as uni_getProviderSync
import io.dcloud.uniapp.extapi.hideLoading as uni_hideLoading
import io.dcloud.uniapp.extapi.request as uni_request
import io.dcloud.uniapp.extapi.requestMerchantTransfer as uni_requestMerchantTransfer
import io.dcloud.uniapp.extapi.requestPayment as uni_requestPayment
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading
import io.dcloud.uniapp.extapi.showModal as uni_showModal
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesAPIRequestMerchantTransferRequestMerchantTransfer : BasePage {
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
        var setup: (__props: GenPagesAPIRequestMerchantTransferRequestMerchantTransfer) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIRequestMerchantTransferRequestMerchantTransfer
            val _cache = __ins.renderCache
            val outTradeNo = ref<String>("")
            val disabled = ref<Boolean>(true)
            val openid = ref<String>("")
            val getBundleId = fun(): String? {
                var baseInfo = uni_getAppBaseInfo(null)
                var bundleId: String?
                bundleId = baseInfo.packageName
                return bundleId
            }
            val pay = fun(){
                var bundleId = getBundleId()
                var random = Math.floor(Math.random() * 9000) + 1000
                outTradeNo.value = "test" + Date.now() + random
                console.log("outTradeNo: ", outTradeNo.value)
                disabled.value = true
                uni_showLoading(ShowLoadingOptions(title = "请求中..."))
                val getProviderRes = uni_getProviderSync(GetProviderSyncOptions(service = "payment"))
                if (getProviderRes.providerIds.indexOf("wxpay") == -1) {
                    uni_showToast(ShowToastOptions(title = "未添加微信支付依赖", icon = "error"))
                    uni_hideLoading(null)
                    return
                }
                uni_request<Any>(RequestOptions(url = "https://env-00jxt67zj8kj.dev-hz.cloudbasefunction.cn/uni-pay-api/getOrderInfo", method = "GET", data = _uO("outTradeNo" to outTradeNo.value, "bundleId" to bundleId, "openid" to openid.value), success = fun(res){
                    uni_hideLoading(null)
                    var data = res.data as UTSJSONObject
                    var errCode = data["errCode"] as Number
                    if (errCode != 0) {
                        uni_showModal(ShowModalOptions(title = "提示", content = data["errMsg"] as String, showCancel = false))
                        return
                    }
                    var orderInfo = data["orderInfo"] as String
                    console.log("orderInfo: ", orderInfo)
                    uni_requestPayment(RequestPaymentOptions(provider = "wxpay", orderInfo = orderInfo, success = fun(res){
                        console.log("res: ", res)
                        uni_showToast(ShowToastOptions(title = "支付成功", icon = "success"))
                        disabled.value = false
                    }
                    , fail = fun(err){
                        console.error("err", err)
                        uni_hideLoading(null)
                        uni_showToast(ShowToastOptions(title = "支付失败", icon = "error"))
                    }
                    ))
                }
                , fail = fun(err){
                    uni_hideLoading(null)
                    console.error("request-err", err)
                }
                ))
            }
            val transfer = fun(){
                uni_showLoading(ShowLoadingOptions(title = "请求中..."))
                try {
                    var bundleId = getBundleId()
                    uni_request<Any>(RequestOptions(url = "https://env-00jxt67zj8kj.dev-hz.cloudbasefunction.cn/uni-pay-api/transfer", method = "GET", data = _uO("outTradeNo" to outTradeNo.value, "bundleId" to bundleId), success = fun(res){
                        var data = res.data as UTSJSONObject
                        if (data["errCode"] != null && UTSAndroid.`typeof`(data["errCode"]) == "number" && data["errCode"] == 0) {
                            var options = data["options"] as UTSJSONObject
                            uni_requestMerchantTransfer(RequestMerchantTransferOptions(mchId = options["mchId"] as String, appId = options["appId"] as String, `package` = options["package"] as String, success = fun(res){
                                uni_hideLoading(null)
                                console.log("res: ", res)
                                uni_showToast(ShowToastOptions(title = "转账成功", icon = "success"))
                                disabled.value = true
                            }, fail = fun(err){
                                uni_hideLoading(null)
                                var errMsg = err.errMsg
                                if (errMsg == "requestMerchantTransfer:fail cancel") {
                                    errMsg = "取消转账"
                                }
                                uni_showToast(ShowToastOptions(title = errMsg, icon = "none"))
                                console.error("转账失败", err)
                            }))
                        } else {
                            uni_hideLoading(null)
                            if (data["errMsg"] != null) {
                                uni_showModal(ShowModalOptions(title = "提示", content = data["errMsg"] as String, showCancel = false))
                            }
                            return
                        }
                    }
                    , fail = fun(err){
                        console.error("request-err", err)
                        uni_hideLoading(null)
                    }
                    ))
                }
                 catch (err: Throwable) {
                    console.error("err: ", err)
                    uni_showToast(ShowToastOptions(title = "运行异常", icon = "error"))
                    uni_hideLoading(null)
                }
            }
            onLoad(fun(_options){})
            return fun(): Any? {
                return _cE("view", _uM("class" to "content"), _uA(
                    _cE("button", _uM("class" to "button", "onClick" to pay), "支付0.2元"),
                    _cE("button", _uM("class" to "button", "onClick" to transfer, "disabled" to unref(disabled)), "接受0.1元转账", 8, _uA(
                        "disabled"
                    )),
                    if (isTrue(unref(disabled))) {
                        _cE("view", _uM("key" to 0, "class" to "tips", "style" to _nS(_uM("color" to "#ff5a5f"))), "请先支付 0.2 元，才能体验接收转账 0.1 元", 4)
                    } else {
                        _cE("view", _uM("key" to 1, "class" to "tips"), _uA(
                            _cE("text", _uM("style" to _nS(_uM("color" to "#42b983"))), "已支付 0.2 元，请点击“接受0.1元转账”按钮", 4)
                        ))
                    }
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
                return _uM("content" to _pS(_uM("display" to "flex", "flexDirection" to "column", "alignItems" to "center", "justifyContent" to "center", "paddingTop" to 20, "paddingRight" to 20, "paddingBottom" to 20, "paddingLeft" to 20)), "button" to _pS(_uM("width" to "100%", "marginBottom" to 20, "borderTopLeftRadius" to 5, "borderTopRightRadius" to 5, "borderBottomRightRadius" to 5, "borderBottomLeftRadius" to 5)), "tips" to _pS(_uM("color" to "#999999", "fontSize" to 14)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
