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
import io.dcloud.uniapp.extapi.getDeviceInfo as uni_getDeviceInfo
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
import io.dcloud.uniapp.extapi.requestPayment as uni_requestPayment
import io.dcloud.uniapp.extapi.showModal as uni_showModal
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenUniModulesUniPayXComponentsUniPayUniPay : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var adpid: String? by `$props`
    open var toSuccessPage: Boolean? by `$props`
    open var returnUrl: String? by `$props`
    open var mainColor: String? by `$props`
    open var mode: String? by `$props`
    open var logo: String? by `$props`
    open var height: String? by `$props`
    open var debug: Boolean? by `$props`
    open var open: (options: UTSJSONObject) -> UTSPromise<Unit>
        get() {
            return unref(this.`$exposed`["open"]) as (options: UTSJSONObject) -> UTSPromise<Unit>
        }
        set(value) {
            setRefValue(this.`$exposed`, "open", value)
        }
    open var createOrder: (data: UTSJSONObject) -> UTSPromise<Unit>
        get() {
            return unref(this.`$exposed`["createOrder"]) as (data: UTSJSONObject) -> UTSPromise<Unit>
        }
        set(value) {
            setRefValue(this.`$exposed`, "createOrder", value)
        }
    open var getOrder: (data: UTSJSONObject) -> UTSPromise<UTSJSONObject>
        get() {
            return unref(this.`$exposed`["getOrder"]) as (data: UTSJSONObject) -> UTSPromise<UTSJSONObject>
        }
        set(value) {
            setRefValue(this.`$exposed`, "getOrder", value)
        }
    open var refund: (data: UTSJSONObject) -> UTSPromise<UTSJSONObject>
        get() {
            return unref(this.`$exposed`["refund"]) as (data: UTSJSONObject) -> UTSPromise<UTSJSONObject>
        }
        set(value) {
            setRefValue(this.`$exposed`, "refund", value)
        }
    open var getRefund: (data: UTSJSONObject) -> UTSPromise<UTSJSONObject>
        get() {
            return unref(this.`$exposed`["getRefund"]) as (data: UTSJSONObject) -> UTSPromise<UTSJSONObject>
        }
        set(value) {
            setRefValue(this.`$exposed`, "getRefund", value)
        }
    open var closeOrder: (data: UTSJSONObject) -> UTSPromise<UTSJSONObject>
        get() {
            return unref(this.`$exposed`["closeOrder"]) as (data: UTSJSONObject) -> UTSPromise<UTSJSONObject>
        }
        set(value) {
            setRefValue(this.`$exposed`, "closeOrder", value)
        }
    open var getPayProviderFromCloud: (data: UTSJSONObject) -> UTSPromise<UTSJSONObject>
        get() {
            return unref(this.`$exposed`["getPayProviderFromCloud"]) as (data: UTSJSONObject) -> UTSPromise<UTSJSONObject>
        }
        set(value) {
            setRefValue(this.`$exposed`, "getPayProviderFromCloud", value)
        }
    open var getProviderAppId: (data: UTSJSONObject) -> UTSPromise<UTSJSONObject>
        get() {
            return unref(this.`$exposed`["getProviderAppId"]) as (data: UTSJSONObject) -> UTSPromise<UTSJSONObject>
        }
        set(value) {
            setRefValue(this.`$exposed`, "getProviderAppId", value)
        }
    open var getOpenid: (data: UTSJSONObject) -> UTSPromise<UTSJSONObject>
        get() {
            return unref(this.`$exposed`["getOpenid"]) as (data: UTSJSONObject) -> UTSPromise<UTSJSONObject>
        }
        set(value) {
            setRefValue(this.`$exposed`, "getOpenid", value)
        }
    open var verifyReceiptFromAppleiap: (data: UTSJSONObject) -> UTSPromise<UTSJSONObject>
        get() {
            return unref(this.`$exposed`["verifyReceiptFromAppleiap"]) as (data: UTSJSONObject) -> UTSPromise<UTSJSONObject>
        }
        set(value) {
            setRefValue(this.`$exposed`, "verifyReceiptFromAppleiap", value)
        }
    open var appleiapRestore: () -> Unit
        get() {
            return unref(this.`$exposed`["appleiapRestore"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "appleiapRestore", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesUniPayXComponentsUniPayUniPay, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesUniPayXComponentsUniPayUniPay
            val _cache = __ins.renderCache
            val props = __props
            val adpid = props.adpid ?: ""
            val toSuccessPage = props.toSuccessPage ?: true
            val returnUrl = props.returnUrl ?: ""
            val mainColor = props.mainColor ?: ""
            val mode = props.mode ?: ""
            val logo = props.logo ?: "/static/test-image/logo.png"
            val height = props.height ?: "70vh"
            val debug = props.debug ?: false
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val myOptions = ref(_uO())
            val orderRes = ref(_uO("order" to "", "order_no" to "", "out_trade_no" to "", "provider" to "", "provider_pay_type" to "", "errCode" to 0))
            val images = ref(_uO("wxpay" to "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAYAAACqaXHeAAAAAXNSR0IArs4c6QAABC9JREFUeF7tWk1a20AMlUzv0bDr13AAYAOcpLCBcoqQU1DYEE6C2QAHIP26q3sPPOqniU2cZMYj+SeGxN5kEXlm9ObpjaQxwpY/uOX+Qw9Az4AtR6APgS0nQC+CfQi0FQLfrvcHXwAGPP4bQMK/fy5f7O9HehphwPfb/dOIogEhHQHBcamDCDESPoIxMQPTNSi1ABj+OrwDpNMaO5og4P2bMZOugFADwNTewWhU0/FVzAgnKZnxuoFQAbB3vX9MET7U2PHgq4R09vv8ZRI0bMhADMDw9uAhGN8NLQrWyAYRAGt1PgcRIU5TOms7JIIAdOL8nElJauikTRBKAdi7ObwioFFTzHaMw3mBzRV8DwKOXy+ertpagxcAq/YR/g2d6TlNrUDu4EiiE0Why4T1rgyINoXRC4DgjE+mF8+7RYAkp4RrRyVztRUKTgCkuz89fz4pAiB5z7WbklBrKxScAEgWxI6joZPXy5c4B0H0nkPdhzcHFIxxhHgZ8OA7AgMnAMObA479UnF6H5twQpF5RBMdibPDvB4AAAL6IZ0rNbTb9IngAyC8IwJ0K5okQBgzqFEKSV4wcXg17bxl8fIiJXFc0bHAgYLjYlHEFaZlVUQDoAIbcVZaN1VRrgAgUfImASiKW6Yh4pAohmHVQqpLABI0dMYiKhJPCeoV0ueuQsDmEJrkSeJ/bqNJnOqfApqVzWznzrdYWkvzhnUDYGnPKLTdV5gpfLiOqJUIaTefF8RKH6wxtAOX2IdA8NcCmmRItmBLfVF5jRBnR58kGQtWlGUJlBeAxpQ5A4eFKTu/ufLzPQv1f2mRRDiZ/nyyYwYrypI0OlQOc/9PsgshDsh2v+BUwTFnD3K5DglVlD4WlDZEsqywNgiK2F9gQBkLi7EtyV59WhBsiTURCjy5QZMgYRn9cxbZWgCQ+IKlnH2sFQYTURHmCYMgAJaKs9aYPkXNXGK6QhQdt9xeC4UhTC+eV/wVASASmrKj6IMA4NIBMQDsX1VN4IlbuU0K7vmiQS0G5EOpmiW6I1Dpjtp8pYc5yxYVj0RtXcMJcwDFSiqYLh2x+QgqAJwnAuEEydxbkZtdj+fKPVfwbPIq7KngqvMVX4WoAmDBAcH9HTMmXw23s0LJSlPOOsZx0l8VAu/0Fzjuc2Td3aY5zf1VoZgBvPgmvuhoIrFSMSXQThcDoJo0YLxGLfBSv5IINgVC1XxCOb/oZrkTBtRJqkQgKG6ROgPgPbGq/6HVIiYK51WngAj5ikbBhoZi3FALbHmozhlQXFChTc75g6wRM2ufzb9N/IwMcG0wg8HZJf9HBF/tFZnBBBH+cW/BpBDnd4XLDNJcon4oBiiY7jS194mEI0IaSz+12ygAclSYEcXvFsqA3UgANEzqAdCgtYm2PQM2cVc1PvUM0KC1ibY9AzZxVzU+bT0D/gPs/oxfcUEcJAAAAABJRU5ErkJggg==", "alipay" to "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAYAAACqaXHeAAAAAXNSR0IArs4c6QAAA2FJREFUeF7tmU122jAQx2cMB2hp9yULeK+naHISwhJyiIRDBJaQkwRO0fdgEWff0h4ANH0yFc+m+hhbckKNvJUsaX76z4ckhAv/8MLthwggKuDCCUQXuHABxCAYXSC6wIUTiC7wFgL4MPveTaj9optrO+696ya8yeQRQFRAdIEYAxoVBD/PNtdCwHWpDIJwr+1PMCk1DgAkCSx/jHrLsv/p+lfKAp3HzQOYDAqxKtcYBJPtXe/B1Y3TXgmATGst0WIrgAC7JmBINOQsNN8HE0zfVQFlFxzrgFgHNLQOkNJuQ7vrcgkS1CXEua5fgnDj+l+172CX/h59Tbn9Of0qBUE1cGe2ngPhLWeiEH0krFDBT63HC8Cnx/VtFuFDfgl90UOldDvuX4WcSo7lBSD0YuR4H6ebZwRNkRUw9xdSah1G+IzZmW5IW7ERDX/e9Rc+YwerBEMvQo1nrhfqkf/ZuYCxxK5J/t4AjkFQBi71CXxFoFSWq2XTlkn+AndXodNf5SwgT4J7gnttoNL6BqUEmCZET/tkvzQZYj5g1Sf/0goIkfcJYIkEK5HsFnkYnen6BXQptUb5lwJgMz4zCihXD/BqAwVDuoy+Uqx399kACrkZaYECVjY5qxJZXpoQwrcDHB6UghfVvPssAMo35W4R7oZVg5EMmAJxUCZ2CNzfVJ2Pm6qdleDBNwFClaHZdRrQAEhWe25VSPCuAMo1tnQhdIzMNUixfDYBqAOGVQEKQB15OFMCwXPV3QsFww7g73E39Pudr/Gn0EyplQPXCkBF/5AKsBtPKRA+AdKAEx/0BhYLL9nHFkhZLiBvbkOcxFzG5wPtoe7gBUrrTiMttqO+8ebZCkAtWErs17jHvrrSLcj+lkCpKeV5g/ABIA05lqgVM4Er2nPhZgev7DHGnToLG+ALIC9budgWwoRzyuMUPlzj8waVBuELIFOB5iksi7xIKQh8PS4wu8/j+a3vBScbRAgABVfg5BZbH6SFgP0kVIl7UCjNja4RCkAGwecaPLDhp4yNsSYkADlp/mncdNLLu8fpud9XQK7//wERGoBrAefSfgRBsLI9pTtPg+diUNV1yLuJypVg1Un/p/8arwDXZkQALkJNb48KaPoOu+yLCnARanp7VEDTd9hlX1SAi1DT2/8AaakVXysj5qkAAAAASUVORK5CYII="))
            val originalRroviders = ref(_uA<String>("wxpay", "alipay"))
            val currentProviders = ref(_uA<String>("wxpay", "alipay"))
            val openid = ref("")
            val modeCom = computed(fun(): String {
                var _mode = mode as String
                if (_mode != "") {
                    return _mode
                }
                var systemInfo = uni_getDeviceInfo(null)
                return if (systemInfo.deviceType == "pc") {
                    "pc"
                } else {
                    "mobile"
                }
            }
            )
            val instance = getCurrentInstance()
            fun gen_openPopup_fn(name: String) {
                var popupRef = instance!!.proxy!!.`$refs`[name] as UniPayPopupComponentPublicInstance
                popupRef.open()
            }
            val openPopup = ::gen_openPopup_fn
            fun gen_closePopup_fn(name: String) {
                var popupRef = instance!!.proxy!!.`$refs`[name] as UniPayPopupComponentPublicInstance
                popupRef.close()
            }
            val closePopup = ::gen_closePopup_fn
            fun gen_getOrder_fn(data: UTSJSONObject): UTSPromise<UTSJSONObject> {
                return wrapUTSPromise(suspend w1@{
                        try {
                            val uniPayCo = uniCloud.importObject("uni-pay-co", GenCloudObjUniPayCo::class.java)
                            var res = await(uniPayCo.getOrder(data))
                            return@w1 res
                        }
                         catch (err: Throwable) {
                            return@w1 _uO("errCode" to -1, "errMsg" to (err as UTSError).message)
                        }
                })
            }
            val getOrder = ::gen_getOrder_fn
            fun gen_clearQrcode_fn() {
                orderRes.value["codeUrl"] = ""
                orderRes.value["qr_code_image"] = ""
            }
            val clearQrcode = ::gen_clearQrcode_fn
            fun gen_pageToSuccess_fn(res: UTSJSONObject) {
                var out_trade_no = res["out_trade_no"] as String
                var pay_order = res.getJSON("pay_order") as UTSJSONObject
                var order_no = pay_order["order_no"] as String
                var total_fee = pay_order.getNumber("total_fee")
                if (total_fee == null) {
                    total_fee = 0
                }
                var _returnUrl = returnUrl as String
                var _adpid = adpid as String
                var _mainColor = mainColor as String
                if (modeCom.value != "pc") {
                    uni_navigateTo(NavigateToOptions(url = "/uni_modules/uni-pay-x/pages/success/success?out_trade_no=" + out_trade_no + "&order_no=" + order_no + "&total_fee=" + total_fee + "&adpid=" + _adpid + "&return_url=" + _returnUrl + "&main_color=" + _mainColor))
                } else {
                    if (_returnUrl != "") {
                        var url = _returnUrl + ("?out_trade_no=" + out_trade_no + "&order_no=" + order_no)
                        if (url.indexOf("/") != 0) {
                            url = "/" + url
                        }
                        uni_navigateTo(NavigateToOptions(url = url))
                    }
                }
            }
            val pageToSuccess = ::gen_pageToSuccess_fn
            fun gen_paySuccess_fn(res: UTSJSONObject) {
                closePopup("payPopup")
                closePopup("payConfirmPopup")
                clearQrcode()
                var _toSuccessPage = toSuccessPage as Boolean
                if (_toSuccessPage) {
                    pageToSuccess(res)
                }
                emit("success", res)
            }
            val paySuccess = ::gen_paySuccess_fn
            fun gen__getOrder_fn(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        var out_trade_no = orderRes.value["out_trade_no"] as String
                        var res = await(getOrder(_uO("out_trade_no" to out_trade_no, "await_notify" to true)))
                        if (res["errCode"] == 0) {
                            var has_paid = res.getBoolean("has_paid")
                            if (has_paid != null && has_paid == true) {
                                closePopup("qrcodePopup")
                                paySuccess(res)
                            }
                        }
                })
            }
            val _getOrder = ::gen__getOrder_fn
            fun gen_orderPayment_fn(res: UTSJSONObject) {
                orderRes.value = res
                if (res["qr_code"] != null && res["qr_code"] != "") {
                    emit("qrcode", res)
                }
                var _order = res.get("order")
                var orderStr = if (UTSAndroid.`typeof`(_order) == "string") {
                    _order as String
                } else {
                    JSON.stringify(_order) as String
                }
                console.log("orderStr: ", orderStr)
                uni_requestPayment(RequestPaymentOptions(provider = res["provider"] as String, orderInfo = orderStr, success = fun(res){
                    console.log("requestPaymentSuccess", JSON.stringify(res))
                    _getOrder()
                }
                , fail = fun(err){
                    console.log("requestPaymentFail", JSON.stringify(err))
                    var errCode = err.errCode
                    var errMsg = err.errMsg
                    if (errCode == 700601 || errMsg.indexOf("fail cancel") > -1) {
                        emit("cancel", _uO("errCode" to errCode, "errMsg" to errMsg))
                    } else {
                        console.error("uni.requestPayment:fail", err)
                        emit("fail", _uO("errCode" to errCode, "errMsg" to errMsg))
                    }
                }
                ))
            }
            val orderPayment = ::gen_orderPayment_fn
            fun gen_createOrder_fn(data: UTSJSONObject): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        var options = myOptions.value
                        options["qr_code"] = false
                        options = objectAssign(options, data)
                        if (options["provider"] == "appleiap") {
                            uni_showModal(ShowModalOptions(title = "提示", content = "请在iOS系统中执行", showCancel = false))
                        }
                        if (options["provider"] == "wxpay") {}
                        var createOrderData: UTSJSONObject = _uO("provider" to options["provider"], "total_fee" to options.getNumber("total_fee"), "order_no" to options["order_no"], "out_trade_no" to options["out_trade_no"], "description" to options["description"], "type" to options["type"], "qr_code" to options.getBoolean("qr_code"), "custom" to options.getJSON("custom"), "other" to options.getJSON("other"), "wxpay_virtual" to options.getJSON("wxpay_virtual"))
                        try {
                            val uniPayCo = uniCloud.importObject("uni-pay-co", GenCloudObjUniPayCo::class.java)
                            var res = await(uniPayCo.createOrder(createOrderData))
                            if (res["errCode"] == 0) {
                                emit("create", res)
                                if (res["qr_code"] != null && res["qr_code"] == true && options.getBoolean("cancel_popup") != true) {
                                    orderRes.value = res
                                    if (modeCom.value == "pc") {
                                        openPopup("payPopup")
                                        var _provider: String = myOptions.value["provider"] as String
                                        var currentProvider = options["provider"] as String
                                        if (currentProvider != _provider) {}
                                    } else {
                                        openPopup("qrcodePopup")
                                    }
                                } else {
                                    orderPayment(res)
                                }
                            } else {
                                emit("fail", res)
                            }
                        }
                         catch (err: Throwable) {
                            emit("fail", _uO("errCode" to -1, "errMsg" to (err as UTSError).message))
                        }
                })
            }
            val createOrder = ::gen_createOrder_fn
            fun gen__pcChooseProvider_fn(provider: String) {
                var _provider: String = myOptions.value["provider"] as String
                if (provider != _provider) {
                    createOrder(_uO("provider" to provider))
                }
            }
            val _pcChooseProvider = ::gen__pcChooseProvider_fn
            fun gen_createOrderByProvider_fn(provider: String) {
                createOrder(_uO("provider" to provider))
            }
            val createOrderByProvider = ::gen_createOrderByProvider_fn
            fun gen_open_fn(options: UTSJSONObject): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        var provider = options["provider"] as String?
                        if (provider != null && provider != "") {
                            var providers: UTSArray<String> = _uA()
                            originalRroviders.value.map(fun(item: String){
                                if (provider == item) {
                                    providers.push(item)
                                }
                            })
                            currentProviders.value = providers
                            options["provider"] = ""
                        } else {
                            currentProviders.value = JSON.parse(JSON.stringify(originalRroviders.value)) as UTSArray<String>
                        }
                        myOptions.value = options
                        if (currentProviders.value.length == 1) {
                            createOrder(_uO("provider" to currentProviders.value[0]))
                        } else {
                            if (modeCom.value == "pc") {
                                _pcChooseProvider(currentProviders.value[0])
                            }
                            openPopup("payPopup")
                        }
                })
            }
            val open = ::gen_open_fn
            fun gen_refund_fn(data: UTSJSONObject): UTSPromise<UTSJSONObject> {
                return wrapUTSPromise(suspend w1@{
                        try {
                            val uniPayCo = uniCloud.importObject("uni-pay-co", GenCloudObjUniPayCo::class.java)
                            var res = await(uniPayCo.refund(data))
                            return@w1 res
                        }
                         catch (err: Throwable) {
                            return@w1 _uO("errCode" to -1, "errMsg" to (err as UTSError).message)
                        }
                })
            }
            val refund = ::gen_refund_fn
            fun gen_getRefund_fn(data: UTSJSONObject): UTSPromise<UTSJSONObject> {
                return wrapUTSPromise(suspend w1@{
                        try {
                            val uniPayCo = uniCloud.importObject("uni-pay-co", GenCloudObjUniPayCo::class.java)
                            var res = await(uniPayCo.getRefund(data))
                            return@w1 res
                        }
                         catch (err: Throwable) {
                            return@w1 _uO("errCode" to -1, "errMsg" to (err as UTSError).message)
                        }
                })
            }
            val getRefund = ::gen_getRefund_fn
            fun gen_closeOrder_fn(data: UTSJSONObject): UTSPromise<UTSJSONObject> {
                return wrapUTSPromise(suspend w1@{
                        try {
                            val uniPayCo = uniCloud.importObject("uni-pay-co", GenCloudObjUniPayCo::class.java)
                            var res = await(uniPayCo.closeOrder(data))
                            return@w1 res
                        }
                         catch (err: Throwable) {
                            return@w1 _uO("errCode" to -1, "errMsg" to (err as UTSError).message)
                        }
                })
            }
            val closeOrder = ::gen_closeOrder_fn
            fun gen_getPayProviderFromCloud_fn(data: UTSJSONObject): UTSPromise<UTSJSONObject> {
                return wrapUTSPromise(suspend w1@{
                        try {
                            val uniPayCo = uniCloud.importObject("uni-pay-co", GenCloudObjUniPayCo::class.java)
                            var res = await(uniPayCo.getPayProviderFromCloud(data))
                            return@w1 res
                        }
                         catch (err: Throwable) {
                            return@w1 _uO("errCode" to -1, "errMsg" to (err as UTSError).message)
                        }
                })
            }
            val getPayProviderFromCloud = ::gen_getPayProviderFromCloud_fn
            fun gen_getProviderAppId_fn(data: UTSJSONObject): UTSPromise<UTSJSONObject> {
                return wrapUTSPromise(suspend w1@{
                        try {
                            val uniPayCo = uniCloud.importObject("uni-pay-co", GenCloudObjUniPayCo::class.java)
                            var res = await(uniPayCo.getProviderAppId(data))
                            return@w1 res
                        }
                         catch (err: Throwable) {
                            return@w1 _uO("errCode" to -1, "errMsg" to (err as UTSError).message)
                        }
                })
            }
            val getProviderAppId = ::gen_getProviderAppId_fn
            fun gen_getOpenid_fn(data: UTSJSONObject): UTSPromise<UTSJSONObject> {
                return wrapUTSPromise(suspend w1@{
                        try {
                            val uniPayCo = uniCloud.importObject("uni-pay-co", GenCloudObjUniPayCo::class.java)
                            var res = await(uniPayCo.getOpenid(data))
                            return@w1 res
                        }
                         catch (err: Throwable) {
                            return@w1 _uO("errCode" to -1, "errMsg" to (err as UTSError).message)
                        }
                })
            }
            val getOpenid = ::gen_getOpenid_fn
            fun gen_verifyReceiptFromAppleiap_fn(data: UTSJSONObject): UTSPromise<UTSJSONObject> {
                return wrapUTSPromise(suspend w1@{
                        try {
                            val uniPayCo = uniCloud.importObject("uni-pay-co", GenCloudObjUniPayCo::class.java)
                            var res = await(uniPayCo.verifyReceiptFromAppleiap(data))
                            return@w1 res
                        }
                         catch (err: Throwable) {
                            return@w1 _uO("errCode" to -1, "errMsg" to (err as UTSError).message)
                        }
                })
            }
            val verifyReceiptFromAppleiap = ::gen_verifyReceiptFromAppleiap_fn
            fun gen__afreshPayment_fn() {
                orderPayment(orderRes.value)
            }
            val _afreshPayment = ::gen__afreshPayment_fn
            fun gen__appleiapCreateOrder_fn(options: UTSJSONObject): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        uni_showToast(ShowToastOptions(title = "请在iOS系统中打开", icon = "none"))
                })
            }
            val _appleiapCreateOrder = ::gen__appleiapCreateOrder_fn
            fun gen_appleiapRestore_fn() {}
            val appleiapRestore = ::gen_appleiapRestore_fn
            val totalFeeCom = computed(fun(): Number {
                var totalFee = myOptions.value.getNumber("total_fee")
                return if (totalFee != null) {
                    totalFee
                } else {
                    0
                }
            }
            )
            __expose(_uM("open" to open, "createOrder" to createOrder, "getOrder" to getOrder, "refund" to refund, "getRefund" to getRefund, "closeOrder" to closeOrder, "getPayProviderFromCloud" to getPayProviderFromCloud, "getProviderAppId" to getProviderAppId, "getOpenid" to getOpenid, "verifyReceiptFromAppleiap" to verifyReceiptFromAppleiap, "appleiapRestore" to appleiapRestore))
            onMounted(fun(){
                var insideData: UTSJSONObject = _uO("images" to images.value as UTSJSONObject, "originalRroviders" to originalRroviders.value as UTSArray<String>, "currentProviders" to currentProviders.value as UTSArray<String>)
                emit("mounted", insideData)
            }
            )
            return fun(): Any? {
                val _component_uni_pay_popup = resolveEasyComponent("uni-pay-popup", GenUniModulesUniPayXComponentsUniPayPopupUniPayPopupClass)
                return _cE("view", _uM("class" to "uni-pay"), _uA(
                    if (unref(modeCom) == "pc") {
                        _cV(_component_uni_pay_popup, _uM("key" to 0, "ref" to "payPopup", "type" to "center", "safe-area" to false), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("view", _uM("class" to "pc-pay-popup"), _uA(
                                    _cE("view", _uM("class" to "pc-pay-popup-title"), _uA(
                                        _cE("text", _uM("class" to "pc-pay-popup-title-text"), "收银台")
                                    )),
                                    _cE("view", _uM("class" to "pc-pay-popup-flex"), _uA(
                                        _cE("view", _uM("class" to "pc-pay-popup-qrcode-box"), _uA(
                                            _cE("image", _uM("class" to "pc-pay-popup-qrcode-image", "src" to unref(orderRes)["qr_code_image"]), null, 8, _uA(
                                                "src"
                                            )),
                                            _cE("view", _uM("class" to "pc-pay-popup-amount-box"), _uA(
                                                _cE("view", _uM("class" to "pc-pay-popup-amount-tips"), _uA(
                                                    if (unref(orderRes)["provider"] == "wxpay") {
                                                        _cE("text", _uM("key" to 0, "class" to "pc-pay-popup-amount-tips-text"), "微信扫一扫付款")
                                                    } else {
                                                        if (unref(orderRes)["provider"] == "alipay") {
                                                            _cE("text", _uM("key" to 1, "class" to "pc-pay-popup-amount-tips-text"), "支付宝扫一扫付款")
                                                        } else {
                                                            _cE("text", _uM("key" to 2, "class" to "pc-pay-popup-amount-tips-text"), "扫一扫付款")
                                                        }
                                                    }
                                                )),
                                                _cE("view", _uM("class" to "pc-pay-popup-amount"), _uA(
                                                    _cE("text", _uM("class" to "pc-pay-popup-amount-text"), _tD((unref(totalFeeCom) / 100).toFixed(2)), 1)
                                                ))
                                            )),
                                            if (isTrue(unref(orderRes)["qr_code_image"])) {
                                                _cE("view", _uM("key" to 0, "class" to "pc-pay-popup-complete-button"), _uA(
                                                    _cE("button", _uM("type" to "primary", "onClick" to fun(){
                                                        _getOrder()
                                                    }), "我已完成支付", 8, _uA(
                                                        "onClick"
                                                    ))
                                                ))
                                            } else {
                                                _cC("v-if", true)
                                            }
                                        )),
                                        _cE("view", _uM("class" to "pc-pay-popup-provider-list"), _uA(
                                            if (unref(currentProviders).indexOf("wxpay") > -1) {
                                                _cE("view", _uM("key" to 0, "class" to _nC(_uA(
                                                    "pc-pay-popup-provider-item",
                                                    if (unref(myOptions)["provider"] == "wxpay") {
                                                        "pc-pay-popup-provider-item-active"
                                                    } else {
                                                        ""
                                                    }
                                                )), "onClick" to fun(){
                                                    _pcChooseProvider("wxpay")
                                                }), _uA(
                                                    _cE("image", _uM("src" to unref(images)["wxpay"], "class" to "pc-pay-popup-provider-image"), null, 8, _uA(
                                                        "src"
                                                    )),
                                                    _cE("text", _uM("class" to "pc-pay-popup-provider-text"), "微信支付")
                                                ), 10, _uA(
                                                    "onClick"
                                                ))
                                            } else {
                                                _cC("v-if", true)
                                            },
                                            if (unref(currentProviders).indexOf("alipay") > -1) {
                                                _cE("view", _uM("key" to 1, "class" to _nC(_uA(
                                                    "pc-pay-popup-provider-item",
                                                    if (unref(myOptions)["provider"] == "alipay") {
                                                        "pc-pay-popup-provider-item-active"
                                                    } else {
                                                        ""
                                                    }
                                                )), "onClick" to fun(){
                                                    _pcChooseProvider("alipay")
                                                }), _uA(
                                                    _cE("image", _uM("src" to unref(images)["alipay"], "class" to "pc-pay-popup-provider-image"), null, 8, _uA(
                                                        "src"
                                                    )),
                                                    _cE("text", _uM("class" to "pc-pay-popup-provider-text"), "支付宝支付")
                                                ), 10, _uA(
                                                    "onClick"
                                                ))
                                            } else {
                                                _cC("v-if", true)
                                            },
                                            _cE("view", _uM("class" to "pc-pay-popup-logo"), _uA(
                                                _cE("image", _uM("class" to "pc-pay-popup-logo-image", "src" to unref(logo), "mode" to "widthFix"), null, 8, _uA(
                                                    "src"
                                                ))
                                            ))
                                        ))
                                    ))
                                ))
                            )
                        }), "_" to 1), 512)
                    } else {
                        _cV(_component_uni_pay_popup, _uM("key" to 1, "ref" to "payPopup", "type" to "bottom", "safe-area" to false), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("view", _uM("class" to "mobile-pay-popup", "style" to _nS("min-height: " + unref(height) + ";")), _uA(
                                    _cE("view", _uM("class" to "mobile-pay-popup-title"), _uA(
                                        _cE("text", _uM("class" to "mobile-pay-popup-title-text"), "收银台")
                                    )),
                                    _cE("view", _uM("class" to "mobile-pay-popup-amount-box"), _uA(
                                        _cE("view", null, _uA(
                                            _cE("text", _uM("class" to "mobile-pay-popup-amount-box-text"), "待支付金额：")
                                        )),
                                        _cE("view", _uM("class" to "mobile-pay-popup-amount"), _uA(
                                            _cE("text", _uM("class" to "mobile-pay-popup-amount-text"), _tD((unref(totalFeeCom) / 100).toFixed(2)), 1)
                                        ))
                                    )),
                                    _cE("view", _uM("class" to "mobile-pay-popup-provider-list"), _uA(
                                        _cE("view", _uM("class" to "uni-list"), _uA(
                                            if (unref(currentProviders).indexOf("wxpay") > -1) {
                                                _cE("view", _uM("key" to 0, "class" to "uni-list-item", "onClick" to fun(){
                                                    createOrderByProvider("wxpay")
                                                }), _uA(
                                                    _cE("view", _uM("class" to "uni-list-item__container uni-list-item__container--right"), _uA(
                                                        _cE("view", _uM("class" to "uni-list-item__header"), _uA(
                                                            _cE("image", _uM("src" to unref(images)["wxpay"], "class" to "uni-list-item__header-image"), null, 8, _uA(
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
                                            if (unref(currentProviders).indexOf("alipay") > -1) {
                                                _cE("view", _uM("key" to 1, "class" to "uni-list-item", "onClick" to fun(){
                                                    createOrderByProvider("alipay")
                                                }), _uA(
                                                    _cE("view", _uM("class" to "uni-list-item__container uni-list-item__container--right"), _uA(
                                                        _cE("view", _uM("class" to "uni-list-item__header"), _uA(
                                                            _cE("image", _uM("src" to unref(images)["alipay"], "class" to "uni-list-item__header-image"), null, 8, _uA(
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
                                ), 4)
                            )
                        }
                        ), "_" to 1), 512)
                    }
                    ,
                    _cV(_component_uni_pay_popup, _uM("ref" to "qrcodePopup", "type" to "center", "safe-area" to false, "animation" to false, "mask-click" to false, "onClose" to clearQrcode), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to "qrcode-popup-content"), _uA(
                                _cE("image", _uM("src" to unref(orderRes)["qr_code_image"], "class" to "qrcode-popup-content-qrcode-image"), null, 8, _uA(
                                    "src"
                                )),
                                _cE("view", _uM("class" to "qrcode-popup-info"), _uA(
                                    _cE("view", _uM("class" to "qrcode-popup-info-fee-box"), _uA(
                                        _cE("view", _uM("class" to "qrcode-popup-info-fee"), _uA(
                                            _cE("text", _uM("class" to "qrcode-popup-info-fee-text"), _tD((unref(totalFeeCom) / 100).toFixed(2)), 1)
                                        )),
                                        _cE("view", _uM("class" to "qrcode-popup-info-fee-unit"), _uA(
                                            _cE("text", _uM("class" to "qrcode-popup-info-fee-unit-text"), "元")
                                        ))
                                    )),
                                    if (unref(myOptions)["provider"] == "wxpay") {
                                        _cE("view", _uM("key" to 0), _uA(
                                            _cE("text", _uM("class" to "qrcode-popup-info-text"), "请用微信扫码支付")
                                        ))
                                    } else {
                                        if (unref(myOptions)["provider"] == "alipay") {
                                            _cE("view", _uM("key" to 1), _uA(
                                                _cE("text", _uM("class" to "qrcode-popup-info-text"), "请用支付宝扫码支付")
                                            ))
                                        } else {
                                            _cC("v-if", true)
                                        }
                                    }
                                )),
                                _cE("button", _uM("type" to "primary", "onClick" to fun(){
                                    _getOrder()
                                }
                                , "class" to "qrcode-popup-btn-primary"), "我已完成支付", 8, _uA(
                                    "onClick"
                                )),
                                _cE("view", _uM("class" to "qrcode-popup-cancel", "onClick" to fun(){
                                    closePopup("qrcodePopup")
                                }
                                ), _uA(
                                    _cE("text", _uM("class" to "qrcode-popup-cancel-text"), "暂不支付")
                                ), 8, _uA(
                                    "onClick"
                                ))
                            ))
                        )
                    }
                    ), "_" to 1), 512),
                    _cV(_component_uni_pay_popup, _uM("ref" to "payConfirmPopup", "type" to "center", "safe-area" to false, "animation" to false, "mask-click" to false), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to "pay-confirm-popup-content"), _uA(
                                _cE("view", _uM("class" to "pay-confirm-popup-title"), _uA(
                                    _cE("text", _uM("class" to "pay-confirm-popup-title-text"), "请确认支付是否已完成")
                                )),
                                _cE("view", null, _uA(
                                    _cE("button", _uM("type" to "primary", "onClick" to fun(){
                                        _getOrder()
                                    }
                                    ), "已完成支付", 8, _uA(
                                        "onClick"
                                    ))
                                )),
                                _cE("view", _uM("class" to "pay-confirm-popup-refresh"), _uA(
                                    _cE("button", _uM("type" to "default", "onClick" to fun(){
                                        _afreshPayment()
                                    }
                                    ), "支付遇到问题，重新支付", 8, _uA(
                                        "onClick"
                                    ))
                                )),
                                _cE("view", _uM("class" to "pay-confirm-popup-cancel", "onClick" to fun(){
                                    closePopup("payConfirmPopup")
                                }
                                ), _uA(
                                    _cE("text", _uM("class" to "pay-confirm-popup-cancel-text"), "暂不支付")
                                ), 8, _uA(
                                    "onClick"
                                ))
                            ))
                        )
                    }
                    ), "_" to 1), 512)
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
                return _uM("mobile-pay-popup" to _pS(_uM("width" to "100%", "minHeight" to 450, "backgroundColor" to "#f3f3f3", "borderTopLeftRadius" to 15, "borderTopRightRadius" to 15, "borderBottomRightRadius" to 0, "borderBottomLeftRadius" to 0, "overflow" to "hidden")), "mobile-pay-popup-title" to _pS(_uM("backgroundColor" to "#ffffff", "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10)), "mobile-pay-popup-title-text" to _pS(_uM("textAlign" to "center", "fontWeight" to "bold", "fontSize" to 20)), "mobile-pay-popup-amount-box" to _pS(_uM("backgroundColor" to "#ffffff", "paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15)), "mobile-pay-popup-amount-box-text" to _pS(_uM("color" to "#333333", "fontSize" to 14)), "mobile-pay-popup-amount" to _pS(_uM("marginTop" to 10)), "mobile-pay-popup-amount-text" to _pS(_uM("color" to "#e43d33", "fontSize" to 30)), "mobile-pay-popup-provider-list" to _pS(_uM("backgroundColor" to "#ffffff", "marginTop" to 10)), "uni-list" to _pS(_uM("display" to "flex", "backgroundColor" to "#ffffff", "position" to "relative", "flexDirection" to "column")), "uni-list-item" to _pS(_uM("display" to "flex", "position" to "relative", "justifyContent" to "space-between", "alignItems" to "center", "backgroundColor" to "#ffffff", "flexDirection" to "row", "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#f8f8f8", "backgroundColor:hover" to "#f1f1f1")), "uni-list-item__container" to _pS(_uM("position" to "relative", "display" to "flex", "flexDirection" to "row", "paddingTop" to 12, "paddingRight" to 15, "paddingBottom" to 12, "paddingLeft" to 15, "flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "overflow" to "hidden")), "uni-list-item__container--right" to _pS(_uM("paddingRight" to 0)), "uni-list-item__header" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center")), "uni-list-item__header-image" to _pS(_uM("width" to 26, "height" to 26, "marginRight" to 9)), "uni-list-item__content" to _pS(_uM("display" to "flex", "paddingRight" to 8, "flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "flexDirection" to "column", "justifyContent" to "space-between", "overflow" to "hidden")), "uni-list-item__content-text" to _pS(_uM("color" to "#3b4144", "fontSize" to 14)), "uni-list-item__content--center" to _pS(_uM("justifyContent" to "center")), "uni-list-item-arrowright" to _pS(_uM("borderTopWidth" to 1, "borderTopStyle" to "solid", "borderTopColor" to "#bbbbbb", "borderRightWidth" to 1, "borderRightStyle" to "solid", "borderRightColor" to "#bbbbbb", "width" to 8, "height" to 8, "marginRight" to 15, "transform" to "rotate(45deg)")), "pc-pay-popup" to _pS(_uM("width" to 800, "height" to 600, "backgroundColor" to "#f3f3f3", "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "borderBottomRightRadius" to 10, "borderBottomLeftRadius" to 10, "overflow" to "hidden")), "pc-pay-popup-title" to _pS(_uM("backgroundColor" to "#ffffff", "height" to 66)), "pc-pay-popup-title-text" to _pS(_uM("textAlign" to "center", "fontWeight" to "bold", "fontSize" to 20, "lineHeight" to "66px")), "pc-pay-popup-flex" to _pS(_uM("width" to "100%", "display" to "flex", "flexDirection" to "row")), "pc-pay-popup-qrcode-box" to _pS(_uM("height" to 534, "flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "backgroundColor" to "#ffffff", "display" to "flex", "flexDirection" to "column", "justifyContent" to "center", "alignItems" to "center")), "pc-pay-popup-qrcode-image" to _pS(_uM("width" to 225, "height" to 225)), "pc-pay-popup-amount-tips" to _pS(_uM("marginTop" to 20)), "pc-pay-popup-amount-tips-text" to _pS(_uM("textAlign" to "center", "color" to "#333333", "fontSize" to 20)), "pc-pay-popup-amount" to _pS(_uM("marginTop" to 20)), "pc-pay-popup-amount-text" to _pS(_uM("textAlign" to "center", "color" to "#dd524d", "fontWeight" to "bold", "fontSize" to 32)), "pc-pay-popup-complete-button" to _pS(_uM("marginTop" to 20)), "pc-pay-popup-provider-list" to _pS(_uM("width" to 300, "display" to "flex", "flexDirection" to "column")), "pc-pay-popup-provider-item" to _pS(_uM("paddingTop" to 20, "paddingRight" to 20, "paddingBottom" to 20, "paddingLeft" to 20, "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "backgroundColor:hover" to "#ffffff")), "pc-pay-popup-provider-item-active" to _pS(_uM("backgroundColor" to "#ffffff")), "pc-pay-popup-provider-image" to _pS(_uM("width" to 60, "height" to 60)), "pc-pay-popup-provider-text" to _pS(_uM("color" to "#333333", "fontSize" to 20, "marginLeft" to 10)), "pc-pay-popup-logo" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center")), "pc-pay-popup-logo-image" to _pS(_uM("width" to 120)), "qrcode-popup-content" to _pS(_uM("width" to 300, "backgroundColor" to "#ffffff", "borderTopLeftRadius" to 5, "borderTopRightRadius" to 5, "borderBottomRightRadius" to 5, "borderBottomLeftRadius" to 5, "paddingTop" to 20, "paddingRight" to 20, "paddingBottom" to 20, "paddingLeft" to 20, "boxSizing" to "border-box", "textAlign" to "center", "display" to "flex", "flexDirection" to "column", "alignItems" to "center", "justifyContent" to "center")), "qrcode-popup-content-qrcode-image" to _pS(_uM("width" to 225, "height" to 225)), "qrcode-popup-info" to _pS(_uM("paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "display" to "flex", "flexDirection" to "column", "alignItems" to "center")), "qrcode-popup-info-text" to _pS(_uM("color" to "#333333", "fontSize" to 14, "textAlign" to "center")), "qrcode-popup-info-fee-box" to _pS(_uM("display" to "flex", "flexDirection" to "row", "marginBottom" to 3)), "qrcode-popup-info-fee-text" to _pS(_uM("color" to "#FF0000", "fontSize" to 30, "fontWeight" to "bold", "textAlign" to "center")), "qrcode-popup-info-fee-unit" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "flex-end", "paddingBottom" to 5)), "qrcode-popup-info-fee-unit-text" to _pS(_uM("color" to "#333333", "fontSize" to 14)), "qrcode-popup-btn-primary" to _pS(_uM("width" to 260)), "qrcode-popup-cancel" to _pS(_uM("marginTop" to 10, "width" to 260)), "qrcode-popup-cancel-text" to _pS(_uM("textAlign" to "center", "color" to "#666666", "fontSize" to 14)), "pay-confirm-popup-content" to _pS(_uM("width" to 275, "backgroundColor" to "#ffffff", "borderTopLeftRadius" to 5, "borderTopRightRadius" to 5, "borderBottomRightRadius" to 5, "borderBottomLeftRadius" to 5, "paddingTop" to 20, "paddingRight" to 20, "paddingBottom" to 20, "paddingLeft" to 20)), "pay-confirm-popup-title" to _pS(_uM("textAlign" to "center", "paddingTop" to 10, "paddingRight" to 0, "paddingBottom" to 10, "paddingLeft" to 0, "marginBottom" to 15)), "pay-confirm-popup-title-text" to _pS(_uM("color" to "#333333", "fontSize" to 16, "textAlign" to "center")), "pay-confirm-popup-refresh" to _pS(_uM("marginTop" to 10)), "pay-confirm-popup-cancel" to _pS(_uM("marginTop" to 10, "textAlign" to "center")), "pay-confirm-popup-cancel-text" to _pS(_uM("color" to "#666666", "fontSize" to 14, "textAlign" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("success" to null, "cancel" to null, "fail" to null, "create" to null, "mounted" to null, "qrcode" to null)
        var props = _nP(_uM("adpid" to _uM("type" to "String", "required" to false), "toSuccessPage" to _uM("type" to "Boolean", "required" to false), "returnUrl" to _uM("type" to "String", "required" to false), "mainColor" to _uM("type" to "String", "required" to false), "mode" to _uM("type" to "String", "required" to false), "logo" to _uM("type" to "String", "required" to false), "height" to _uM("type" to "String", "required" to false), "debug" to _uM("type" to "Boolean", "required" to false)))
        var propsNeedCastKeys = _uA(
            "toSuccessPage",
            "debug"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
