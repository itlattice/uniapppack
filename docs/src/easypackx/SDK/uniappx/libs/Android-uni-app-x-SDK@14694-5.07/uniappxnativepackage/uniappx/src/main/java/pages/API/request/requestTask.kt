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
import io.dcloud.uniapp.extapi.request as uni_request
import io.dcloud.uniapp.extapi.showModal as uni_showModal
open class GenPagesAPIRequestRequestTask : BasePage {
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
        var setup: (__props: GenPagesAPIRequestRequestTask) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIRequestRequestTask
            val _cache = __ins.renderCache
            val res = ref("")
            val task = ref<RequestTask?>(null)
            val host = "https://request.dcloud.net.cn"
            val url = "/api/http/contentType/eventStream?limit=10"
            val method: RequestMethod = "POST"
            val onHeadersReceivedObseves = ref(_uA<Number>())
            val onChunkReceivedObseves = ref(_uA<Number>())
            val onHeadersReceived_returnid_1 = ref(-1)
            val onHeadersReceived_returnid_2 = ref(-1)
            val isAbort = ref(false)
            onLoad(fun(options: OnLoadOptions){
                onHeadersReceivedObseves.value.push(1)
                onChunkReceivedObseves.value.push(1)
            }
            )
            onUnload(fun(){
                uni_hideLoading(null)
                task.value?.abort()
            }
            )
            fun gen_onHeadersReceived_observe_1_fn() {
                onHeadersReceivedObseves.value.push(1)
            }
            val onHeadersReceived_observe_1 = ::gen_onHeadersReceived_observe_1_fn
            fun gen_onHeadersReceived_observe_2_fn() {
                onHeadersReceivedObseves.value.push(2)
            }
            val onHeadersReceived_observe_2 = ::gen_onHeadersReceived_observe_2_fn
            fun gen_offHeadersReceived_observe_fn() {
                onHeadersReceivedObseves.value = _uA()
            }
            val offHeadersReceived_observe = ::gen_offHeadersReceived_observe_fn
            fun gen_offHeadersReceived_id_fn() {
                onHeadersReceivedObseves.value = _uA()
                onHeadersReceivedObseves.value.push(1)
            }
            val offHeadersReceived_id = ::gen_offHeadersReceived_id_fn
            fun gen_onChunkReceived_observe_1_fn() {
                onChunkReceivedObseves.value.push(1)
            }
            val onChunkReceived_observe_1 = ::gen_onChunkReceived_observe_1_fn
            fun gen_onChunkReceived_observe_2_fn() {
                onChunkReceivedObseves.value.push(2)
            }
            val onChunkReceived_observe_2 = ::gen_onChunkReceived_observe_2_fn
            fun gen_offChunkReceived_observe_fn() {
                onChunkReceivedObseves.value = _uA()
            }
            val offChunkReceived_observe = ::gen_offChunkReceived_observe_fn
            fun gen_checkRequestTask_fn() {
                isAbort.value = false
                res.value = "发起post流式请求 \n\n"
                task.value = uni_request<Any>(RequestOptions(url = "https://request.dcloud.net.cn/api/http/contentType/eventStream?limit=10", timeout = 600000, method = method, enableChunked = true, success = fun(response){
                    console.log("request success", JSON.stringify(response.data))
                    console.log("request success header is :", JSON.stringify(response.header))
                    res.value += "流式请求结束 \n\n"
                    console.log("请求结果 : " + JSON.stringify(response))
                }
                , fail = fun(err){
                    var content = err.errMsg
                    if (isAbort.value) {
                        content = "中断成功"
                    }
                    console.log("request fail", err)
                    uni_showModal(ShowModalOptions(content = content, showCancel = false))
                }
                , complete = fun(_){
                    task.value = null
                }
                ))
                val onHeadersReceivedCallback1 = fun(response: RequestTaskOnHeadersReceivedListenerResult){
                    console.log("-------onHeadersReceived监听1------", response)
                    res.value += "onHeadersReceived监听1：\n " + JSON.stringify(response) + " \n\n"
                }
                val onHeadersReceivedCallback2 = fun(response: RequestTaskOnHeadersReceivedListenerResult){
                    console.log("-------onHeadersReceived监听2------", response)
                    res.value += "onHeadersReceived监听2：\n " + JSON.stringify(response) + "  \n\n"
                }
                if (onHeadersReceivedObseves.value.includes(1)) {
                    onHeadersReceived_returnid_1.value = task.value?.onHeadersReceived(onHeadersReceivedCallback1) ?: -1
                }
                if (onHeadersReceivedObseves.value.length == 0) {
                    task.value?.offHeadersReceived(null)
                    res.value += "点击了 offHeadersReceived \n\n"
                } else if (onHeadersReceivedObseves.value.length == 1) {
                    task.value?.offHeadersReceived(onHeadersReceived_returnid_2.value)
                }
                val onChunkReceivedCallback1 = fun(response: RequestTaskOnChunkReceivedListenerResult){
                    val chunkText: String = TextDecoder().decode(response.data)
                    console.log("-------onChunkReceived监听1------", chunkText)
                    res.value += "onChunkReceived监听1：\n " + chunkText
                }
                val onChunkReceivedCallback2 = fun(response: RequestTaskOnChunkReceivedListenerResult){
                    val chunkText: String = TextDecoder().decode(response.data)
                    console.log("-------onChunkReceived监听2------", chunkText)
                    res.value += "onChunkReceived监听2：\n " + chunkText
                }
                if (onHeadersReceivedObseves.value.includes(2)) {
                    onHeadersReceived_returnid_2.value = task.value?.onHeadersReceived(onHeadersReceivedCallback2) ?: -1
                }
                if (onChunkReceivedObseves.value.includes(1)) {
                    task.value?.onChunkReceived(onChunkReceivedCallback1)
                }
                if (onChunkReceivedObseves.value.includes(2)) {
                    task.value?.onChunkReceived(onChunkReceivedCallback2)
                }
                if (onChunkReceivedObseves.value.length == 0) {
                    task.value?.offChunkReceived(null)
                    res.value += "点击了 offChunkReceived \n\n"
                }
            }
            val checkRequestTask = ::gen_checkRequestTask_fn
            fun gen_abort_fn() {
                isAbort.value = true
                task.value?.abort()
            }
            val abort = ::gen_abort_fn
            return fun(): Any? {
                return _cE("view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt"), _uA(
                        _cE("view", _uM("class" to "uni-common-mt", "style" to _nS(_uM("border-width" to "2px", "border-style" to "solid", "border-radius" to "4px"))), _uA(
                            _cE("textarea", _uM("value" to unref(res), "class" to "uni-textarea", "style" to _nS(_uM("width" to "100%"))), null, 12, _uA(
                                "value"
                            ))
                        ), 4),
                        _cE("view", null, _uA(
                            _cE("text", null, "地址 : " + _tD(host + url), 1),
                            _cE("text", null, "请求方式 : " + _tD(method))
                        )),
                        _cE("view", _uM("class" to "uni-btn-v uni-common-mt"), _uA(
                            _cE("button", _uM("type" to "primary", "onClick" to checkRequestTask, "id" to "checkRequestTask"), "发起流式请求（设置监听需重新点击、勿重复点击）"),
                            _cE("view", _uM("class" to "uni-common-pb")),
                            _cE("button", _uM("type" to "primary", "onClick" to abort, "id" to "abort"), "中断流式请求")
                        ))
                    )),
                    _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1")), "show-scrollbar" to "true"), _uA(
                        _cE("view", _uM("style" to _nS(_uM("padding" to "20px"))), _uA(
                            _cE("text", null, "添加或者移除流式监听"),
                            _cE("view", _uM("class" to "uni-common-pb")),
                            _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row", "flex-wrap" to "wrap"))), _uA(
                                _cE("button", _uM("style" to _nS(_uM("padding" to "5px")), "type" to "primary", "size" to "mini", "onClick" to onHeadersReceived_observe_1, "id" to "onHeadersReceived_observe_1"), "onHeadersReceived监听1", 4),
                                _cE("button", _uM("style" to _nS(_uM("padding" to "5px")), "type" to "primary", "size" to "mini", "onClick" to onHeadersReceived_observe_2, "id" to "onHeadersReceived_observe_2"), "onHeadersReceived监听2", 4),
                                _cE("button", _uM("style" to _nS(_uM("padding" to "5px")), "type" to "primary", "size" to "mini", "onClick" to onChunkReceived_observe_1, "id" to "onChunkReceived_observe_1"), "onChunkReceived监听1", 4),
                                _cE("button", _uM("style" to _nS(_uM("padding" to "5px")), "type" to "primary", "size" to "mini", "onClick" to onChunkReceived_observe_2, "id" to "onChunkReceived_observe_2"), "onChunkReceived监听2", 4),
                                _cE("button", _uM("style" to _nS(_uM("padding" to "5px")), "type" to "primary", "size" to "mini", "onClick" to offHeadersReceived_id, "id" to "offHeadersReceived_id"), "offHeadersReceived(id)", 4),
                                _cE("button", _uM("style" to _nS(_uM("padding" to "5px")), "type" to "primary", "size" to "mini", "onClick" to offHeadersReceived_observe, "id" to "offHeadersReceived_observe"), "offHeadersReceived移除所有", 4),
                                _cE("button", _uM("style" to _nS(_uM("padding" to "5px")), "type" to "primary", "size" to "mini", "onClick" to offChunkReceived_observe, "id" to "offChunkReceived_observe"), "offChunkReceived移除所有", 4)
                            ), 4)
                        ), 4)
                    ), 4)
                ), 4)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("uni-textarea" to _pS(_uM("paddingTop" to 9, "paddingRight" to 9, "paddingBottom" to 9, "paddingLeft" to 9, "fontSize" to 14)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
