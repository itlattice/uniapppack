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
import io.dcloud.uniapp.extapi.hideLoading as uni_hideLoading
import io.dcloud.uniapp.extapi.hideToast as uni_hideToast
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading
import io.dcloud.uniapp.extapi.showModal as uni_showModal
open class GenPagesAPIUnicloudUnicloudCloudFunction : BasePage {
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
    open var data: DataType__77
        get() {
            return unref(this.`$exposed`["data"]) as DataType__77
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var callFunction: () -> UTSPromise<Unit>
        get() {
            return unref(this.`$exposed`["callFunction"]) as () -> UTSPromise<Unit>
        }
        set(value) {
            setRefValue(this.`$exposed`, "callFunction", value)
        }
    open var callFunctionWithGeneric: () -> UTSPromise<Unit>
        get() {
            return unref(this.`$exposed`["callFunctionWithGeneric"]) as () -> UTSPromise<Unit>
        }
        set(value) {
            setRefValue(this.`$exposed`, "callFunctionWithGeneric", value)
        }
    open var jest_UniCloudError: () -> Boolean
        get() {
            return unref(this.`$exposed`["jest_UniCloudError"]) as () -> Boolean
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_UniCloudError", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIUnicloudUnicloudCloudFunction, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIUnicloudUnicloudCloudFunction
            val _cache = __ins.renderCache
            val title = ref("请求云函数")
            val data = reactive(DataType__77(callFunctionResult = _uO(), callFunctionResult_Detail_functionName = "", callFunctionError = _uO(), genericDemoShowMessage = "", isUniTest = false))
            fun gen_notify_fn(content: String, title: String) {
                if (!data.isUniTest) {
                    uni_showModal(ShowModalOptions(title = title, content = content, showCancel = false))
                } else {
                    console.log(title, content)
                }
            }
            val notify = ::gen_notify_fn
            fun gen_callFunctionWithGeneric_fn(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        open class EchoCfResult (
                            @JsonNotNull
                            open var showMessage: String,
                        ) : UTSObject()
                        uni_showLoading(ShowLoadingOptions(title = "加载中..."))
                        await(uniCloud.callFunction<EchoCfResult>(UniCloudCallFunctionOptions(name = "echo-cf", data = _uO("num" to 1, "str" to "ABC"))).then(fun(res){
                            val result = res.result
                            uni_hideLoading(null)
                            data.genericDemoShowMessage = result.showMessage
                            notify(result.showMessage, "提示")
                        }
                        ).`catch`(fun(err: Any?){
                            val error = err as UniCloudError
                            data.callFunctionError = _uO("errCode" to error.errCode, "errMsg" to error.errMsg)
                            uni_hideLoading(null)
                            notify(error.errMsg, "错误")
                        }
                        ))
                })
            }
            val callFunctionWithGeneric = ::gen_callFunctionWithGeneric_fn
            fun gen_callFunction_fn(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        uni_showLoading(ShowLoadingOptions(title = "加载中..."))
                        await(uniCloud.callFunction(UniCloudCallFunctionOptions(name = "echo-cf", data = _uO("num" to 1, "str" to "ABC"))).then(fun(res){
                            val result = res.result
                            data.callFunctionResult = result
                            val detail = result.get("detail") as UTSJSONObject
                            data.callFunctionResult_Detail_functionName = detail.get("functionName") as String
                            console.log("callFunctionResult_Detail_functionName: " + data.callFunctionResult_Detail_functionName)
                            console.log(JSON.stringify(result))
                            uni_hideLoading(null)
                            notify(result["showMessage"] as String, "提示")
                        }
                        ).`catch`(fun(err: Any?){
                            uni_hideLoading(null)
                            if (err is UniCloudError) {
                                val error = err as UniCloudError
                                data.callFunctionError = _uO("errCode" to error.errCode, "errMsg" to error.errMsg)
                                notify(error.errMsg, "错误")
                            } else {
                                console.error(err)
                            }
                        }
                        ))
                })
            }
            val callFunction = ::gen_callFunction_fn
            fun gen_callEncryptionFunction_fn() {
                uni_showLoading(ShowLoadingOptions(title = "加载中..."))
                uniCloud.callFunction(UniCloudCallFunctionOptions(name = "encryption", data = _uO(), secretType = "both")).then(fun(res){
                    uni_hideLoading(null)
                    notify(JSON.stringify(res.result), "提示")
                }
                ).`catch`(fun(err: Any?){
                    uni_hideLoading(null)
                    if (err is UniCloudError) {
                        val error = err as UniCloudError
                        data.callFunctionError = _uO("errCode" to error.errCode, "errMsg" to error.errMsg)
                        notify(error.errMsg, "错误")
                    } else {
                        console.error(err)
                    }
                }
                )
            }
            val callEncryptionFunction = ::gen_callEncryptionFunction_fn
            fun gen_callVerifyFunction_fn() {
                uni_showLoading(ShowLoadingOptions(title = "加载中..."))
                uniCloud.callFunction(UniCloudCallFunctionOptions(name = "verify-client", data = _uO())).then(fun(res){
                    uni_hideLoading(null)
                    notify(JSON.stringify(res.result), "提示")
                }
                ).`catch`(fun(err: Any?){
                    uni_hideLoading(null)
                    if (err is UniCloudError) {
                        val error = err as UniCloudError
                        data.callFunctionError = _uO("errCode" to error.errCode, "errMsg" to error.errMsg)
                        notify(error.errMsg, "错误")
                    } else {
                        console.error(err)
                    }
                }
                )
            }
            val callVerifyFunction = ::gen_callVerifyFunction_fn
            fun gen_jest_UniCloudError_fn(): Boolean {
                return UTSError() is UniCloudError
            }
            val jest_UniCloudError = ::gen_jest_UniCloudError_fn
            onLoad(fun(options: OnLoadOptions){})
            onUnload(fun(){
                if (data.isUniTest) {
                    uni_hideToast()
                }
            }
            )
            __expose(_uM("data" to data, "callFunction" to callFunction, "callFunctionWithGeneric" to callFunctionWithGeneric, "jest_UniCloudError" to jest_UniCloudError))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE("scroll-view", _uM("class" to "page-scroll-view"), _uA(
                    _cE("view", null, _uA(
                        _cV(_component_page_head, _uM("title" to unref(title)), null, 8, _uA(
                            "title"
                        )),
                        _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt"), _uA(
                            _cE("view", _uM("class" to "uni-btn-v uni-common-mt"), _uA(
                                _cE("button", _uM("type" to "primary", "onClick" to callFunction), "请求云函数"),
                                _cE("button", _uM("type" to "primary", "onClick" to callFunctionWithGeneric), "请求云函数传入泛型"),
                                _cE("button", _uM("type" to "primary", "onClick" to callEncryptionFunction), "请求安全网络加密云函数"),
                                _cE("button", _uM("type" to "primary", "onClick" to callVerifyFunction), "请求安全网络客户端校验云函数"),
                                _cE("view", null, _uA(
                                    _cE("text", _uM("class" to "tips"), "安全网络相关功能需要打包自定义基座方可正常使用")
                                ))
                            ))
                        ))
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
                return _uM("tips" to _pS(_uM("color" to "#999999", "fontSize" to 12, "paddingTop" to 10, "paddingRight" to 0, "paddingBottom" to 10, "paddingLeft" to 0)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
