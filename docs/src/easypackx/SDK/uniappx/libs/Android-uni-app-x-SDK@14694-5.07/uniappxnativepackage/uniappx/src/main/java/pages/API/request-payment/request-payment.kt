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
import io.dcloud.uniapp.extapi.requestPayment as uni_requestPayment
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesAPIRequestPaymentRequestPayment : BasePage {
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
    open var data: DataType__96
        get() {
            return unref(this.`$exposed`["data"]) as DataType__96
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var jest_pay: () -> Unit
        get() {
            return unref(this.`$exposed`["jest_pay"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_pay", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIRequestPaymentRequestPayment, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIRequestPaymentRequestPayment
            val _cache = __ins.renderCache
            val providerList = ref(_uA<PayItem>())
            val data = reactive(DataType__96(btnText = "支付宝支付", btnType = "primary", orderInfo = "", errorCode = 0, errorMsg = "", complete = false, fail = false, outTradeNo = "", openid = ""))
            val payAli = fun(id: String){
                uni_showLoading(ShowLoadingOptions(title = "请求中..."))
                uni_request<Any>(RequestOptions(url = "https://demo.dcloud.net.cn/payment/alipay/?total=0.01", method = "GET", timeout = 6000, success = fun(res){
                    data.orderInfo = JSON.stringify(res.data)
                    console.log("====" + data.orderInfo)
                    uni_hideLoading(null)
                    uni_requestPayment(RequestPaymentOptions(provider = id, orderInfo = res.data as String, fail = fun(res){
                        console.log(JSON.stringify(res))
                        data.errorCode = res.errCode
                        uni_showToast(ShowToastOptions(icon = "error", title = "errorCode:" + data.errorCode))
                    }
                    , success = fun(res){
                        console.log(JSON.stringify(res))
                        uni_showToast(ShowToastOptions(icon = "success", title = "支付成功"))
                    }
                    ))
                }
                , fail = fun(e){
                    console.log(e)
                    uni_hideLoading(null)
                }
                ))
            }
            val payWX = fun(id: String){
                uni_showLoading(ShowLoadingOptions(title = "请求中..."))
                var url = "https://demo.dcloud.net.cn/payment/wxpayv3.__UNI__uniappx/?total=0.01"
                val res = uni_getAppBaseInfo(null)
                var packageName: String?
                packageName = res.packageName
                if (packageName == "io.dcloud.hellouniappx") {
                    url = "https://demo.dcloud.net.cn/payment/wxpayv3.__UNI__HelloUniAppX/?total=0.01"
                }
                uni_request<Any>(RequestOptions(url = url, method = "GET", timeout = 6000, header = _uO("Content-Type" to "application/json"), success = fun(res){
                    console.log(res.data)
                    uni_hideLoading(null)
                    uni_requestPayment(RequestPaymentOptions(provider = id, orderInfo = JSON.stringify(res.data), fail = fun(res){
                        console.log(JSON.stringify(res))
                        data.errorCode = res.errCode
                        uni_showToast(ShowToastOptions(duration = 5000, icon = "error", title = "errorCode:" + data.errorCode))
                    }
                    , success = fun(res){
                        console.log(JSON.stringify(res))
                        uni_showToast(ShowToastOptions(duration = 5000, icon = "success", title = "支付成功"))
                    }
                    ))
                }
                , fail = fun(res){
                    uni_hideLoading(null)
                    console.log(res)
                }
                ))
            }
            val requestPayment = fun(e: PayItem){
                val provider = e.id
                if (provider == "alipay") {
                    payAli(provider)
                } else if (provider == "wxpay") {
                    if (e.provider != null && e.provider is UniPaymentWxpayProvider && !(e.provider as UniPaymentWxpayProvider).isWeChatInstalled) {
                        uni_showToast(ShowToastOptions(title = "微信没有安装", icon = "error"))
                    } else {
                        payWX(provider)
                    }
                }
            }
            val jest_pay = fun(){
                uni_requestPayment(RequestPaymentOptions(provider = "alipay", orderInfo = data.orderInfo, fail = fun(res: RequestPaymentFail){
                    data.errorCode = res.errCode
                    data.complete = true
                    data.fail = true
                }
                , success = fun(res: RequestPaymentSuccess){
                    console.log(JSON.stringify(res))
                    data.complete = true
                    data.fail = false
                }
                ))
            }
            onLoad(fun(_options){
                var provider = uni_getProviderSync(GetProviderSyncOptions(service = "payment"))
                console.log(provider)
                provider.providerObjects.forEach(fun(value: UniProvider){
                    when (value.id) {
                        "alipay" -> 
                            {
                                var aliPayProvider = value as UniPaymentAlipayProvider
                                console.log("alipay", aliPayProvider)
                                providerList.value.push(PayItem(name = aliPayProvider.description, id = aliPayProvider.id, provider = aliPayProvider))
                            }
                        "wxpay" -> 
                            {
                                var wxPayProvider = value as UniPaymentWxpayProvider
                                console.log("wxpay", wxPayProvider)
                                providerList.value.push(PayItem(name = wxPayProvider.description, id = wxPayProvider.id, provider = wxPayProvider))
                            }
                        else -> 
                            {}
                    }
                }
                )
            }
            )
            __expose(_uM("data" to data, "jest_pay" to jest_pay))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE(Fragment, null, _uA(
                    _cV(_component_page_head, _uM("title" to "发起支付")),
                    _cE("view", _uM("class" to "uni-common-mt", "style" to _nS(_uM("padding" to "0 10px"))), _uA(
                        _cE("text", null, "如对当前页面的支付示例功能有任何疑问，通过电子邮件：service@dcloud.io 联系我们")
                    ), 4),
                    if (unref(providerList).length > 0) {
                        _cE(Fragment, _uM("key" to 0), RenderHelpers.renderList(unref(providerList), fun(item, index, __index, _cached): Any {
                            return _cE("button", _uM("style" to _nS(_uM("margin-top" to "20px")), "type" to "primary", "key" to index, "onClick" to fun(){
                                requestPayment(item)
                            }), _tD(item.name), 13, _uA(
                                "onClick"
                            ))
                        }), 128)
                    } else {
                        _cC("v-if", true)
                    }
                ), 64)
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
