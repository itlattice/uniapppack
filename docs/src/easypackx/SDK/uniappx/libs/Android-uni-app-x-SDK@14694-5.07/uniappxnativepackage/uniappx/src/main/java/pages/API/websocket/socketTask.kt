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
import io.dcloud.uniapp.extapi.connectSocket as uni_connectSocket
import io.dcloud.uniapp.extapi.getDeviceInfo as uni_getDeviceInfo
import io.dcloud.uniapp.extapi.hideLoading as uni_hideLoading
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading
import io.dcloud.uniapp.extapi.showModal as uni_showModal
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesAPIWebsocketSocketTask : BasePage {
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
    open var data: DataType__75
        get() {
            return unref(this.`$exposed`["data"]) as DataType__75
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var jest_connectSocket: () -> Unit
        get() {
            return unref(this.`$exposed`["jest_connectSocket"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_connectSocket", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIWebsocketSocketTask, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIWebsocketSocketTask
            val _cache = __ins.renderCache
            val connected = ref(false)
            val connecting = ref(false)
            val socketTask = ref(null as SocketTask?)
            val msg = ref("")
            val platform = ref("")
            val data = reactive(DataType__75(jest_result = 0))
            val showMsg = computed(fun(): String {
                if (connected.value) {
                    if (msg.value.length > 0) {
                        return "收到消息：" + msg.value
                    } else {
                        return "等待接收消息"
                    }
                } else {
                    return "尚未连接"
                }
            }
            )
            fun gen_connect_fn() {
                if (connected.value || connecting.value) {
                    uni_showModal(ShowModalOptions(content = "正在连接或者已经连接，请勿重复连接", showCancel = false))
                    return
                }
                connecting.value = true
                uni_showLoading(ShowLoadingOptions(title = "连接中..."))
                socketTask.value = uni_connectSocket(ConnectSocketOptions(url = "wss://websocket.dcloud.net.cn", success = fun(res: Any){
                    console.log("uni.connectSocket success", res)
                }
                , fail = fun(err: Any){
                    console.log("uni.connectSocket fail", err)
                }
                ))
                socketTask.value?.onOpen(fun(res: Any){
                    connecting.value = false
                    connected.value = true
                    uni_hideLoading(null)
                    uni_showToast(ShowToastOptions(icon = "none", title = "连接成功"))
                    console.log("onOpen", res)
                }
                )
                socketTask.value?.onError(fun(err: Any){
                    connecting.value = false
                    connected.value = false
                    uni_hideLoading(null)
                    uni_showModal(ShowModalOptions(content = "连接失败，可能是websocket服务不可用，请稍后再试", showCancel = false))
                    console.log("onError", err)
                }
                )
                socketTask.value?.onMessage(fun(res: OnSocketMessageCallbackResult){
                    if (res.data is ArrayBuffer) {
                        var int8 = Int8Array(res.data as ArrayBuffer)
                        msg.value = int8.toString()
                        console.log("onMessage", res)
                    } else {
                        msg.value = res.data as String
                        console.log("onMessage", res)
                    }
                }
                )
                socketTask.value?.onClose(fun(res: Any){
                    connected.value = false
                    socketTask.value = null
                    msg.value = ""
                    console.log("onClose", res)
                }
                )
            }
            val connect = ::gen_connect_fn
            fun gen_send_fn() {
                val data = "from " + platform.value + " : " + parseInt(Math.random() * 10000 + "").toString(10)
                socketTask.value?.send(SendSocketMessageOptions(data = data, success = fun(res: Any){
                    console.log(res)
                }
                , fail = fun(err: Any){
                    console.log(err)
                }
                ))
            }
            val send = ::gen_send_fn
            fun gen_sendArrayBuffer_fn() {
                val data = ArrayBuffer(2)
                var int8 = Int8Array(data)
                int8[0] = 1
                int8[1] = 2
                socketTask.value?.send(SendSocketMessageOptions(data = data, success = fun(res: Any){
                    console.log(res)
                }
                , fail = fun(err: Any){
                    console.log(err)
                }
                ))
            }
            val sendArrayBuffer = ::gen_sendArrayBuffer_fn
            fun gen_close_fn() {
                socketTask.value?.close(CloseSocketOptions(code = 1000, reason = "close reason from client", success = fun(res: Any){
                    console.log("uni.closeSocket success", res)
                }
                , fail = fun(err: Any){
                    console.log("uni.closeSocket fail", err)
                }
                ))
            }
            val close = ::gen_close_fn
            fun gen_jest_connectSocket_fn() {
                socketTask.value = uni_connectSocket(ConnectSocketOptions(url = "wss://websocket.dcloud.net.cn", success = fun(_){
                    data.jest_result++
                }
                , fail = fun(_){
                    data.jest_result = 0
                }
                ))
                socketTask.value?.onOpen(fun(_){
                    val message = "from " + platform.value + " : " + parseInt(Math.random() * 10000 + "").toString(10)
                    socketTask.value?.send(SendSocketMessageOptions(data = message, success = fun(_){
                        data.jest_result++
                    }
                    , fail = fun(_){
                        data.jest_result = 0
                    }
                    ))
                }
                )
                socketTask.value?.onError(fun(_){
                    data.jest_result = 0
                }
                )
            }
            val jest_connectSocket = ::gen_jest_connectSocket_fn
            onLoad(fun(_options){
                platform.value = uni_getDeviceInfo(null).platform as String
            }
            )
            onUnload(fun(){
                uni_hideLoading(null)
                var task = socketTask.value
                if (task != null) {
                    task.close(CloseSocketOptions(code = 1000, reason = "close reason from client", success = fun(res: Any){
                        console.log("uni.closeSocket success", res)
                    }
                    , fail = fun(err: Any){
                        console.log("uni.closeSocket fail", err)
                    }
                    ))
                }
            }
            )
            __expose(_uM("data" to data, "jest_connectSocket" to jest_connectSocket))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE(Fragment, null, _uA(
                    _cV(_component_page_head, _uM("title" to "websocket通讯示例")),
                    _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                        _cE("view", _uM("class" to "uni-btn-v"), _uA(
                            _cE("text", _uM("class" to "websocket-msg"), _tD(unref(showMsg)), 1),
                            _cE("button", _uM("class" to "uni-btn-v", "type" to "primary", "onClick" to connect), " 连接websocket服务 "),
                            withDirectives(_cE("button", _uM("class" to "uni-btn-v", "type" to "primary", "onClick" to send), " 发送一条消息 ", 512), _uA(
                                _uA(
                                    vShow,
                                    unref(connected)
                                )
                            )),
                            withDirectives(_cE("button", _uM("class" to "uni-btn-v", "type" to "primary", "onClick" to sendArrayBuffer), " 发送一条ArrayBuffer消息,返回也是ArrayBuffer ", 512), _uA(
                                _uA(
                                    vShow,
                                    unref(connected)
                                )
                            )),
                            _cE("button", _uM("class" to "uni-btn-v", "type" to "primary", "onClick" to close), " 断开websocket服务 "),
                            _cE("text", _uM("class" to "websocket-tips"), "发送消息后会收到一条服务器返回的消息（与发送的消息内容一致）")
                        ))
                    ))
                ), 64)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("uni-btn-v" to _pS(_uM("paddingTop" to 5, "paddingRight" to 0, "paddingBottom" to 5, "paddingLeft" to 0, "marginTop" to 10, "marginRight" to 0, "marginBottom" to 10, "marginLeft" to 0)), "websocket-msg" to _pS(_uM("paddingTop" to 40, "paddingRight" to 0, "paddingBottom" to 40, "paddingLeft" to 0, "textAlign" to "center", "fontSize" to 14, "lineHeight" to "40px", "color" to "#666666")), "websocket-tips" to _pS(_uM("paddingTop" to 40, "paddingRight" to 0, "paddingBottom" to 40, "paddingLeft" to 0, "textAlign" to "center", "fontSize" to 14, "lineHeight" to "24px", "color" to "#666666")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
