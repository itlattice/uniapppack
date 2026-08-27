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
import io.dcloud.uniapp.extapi.closeSocket as uni_closeSocket
import io.dcloud.uniapp.extapi.connectSocket as uni_connectSocket
import io.dcloud.uniapp.extapi.getDeviceInfo as uni_getDeviceInfo
import io.dcloud.uniapp.extapi.hideLoading as uni_hideLoading
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
import io.dcloud.uniapp.extapi.onSocketClose as uni_onSocketClose
import io.dcloud.uniapp.extapi.onSocketError as uni_onSocketError
import io.dcloud.uniapp.extapi.onSocketMessage as uni_onSocketMessage
import io.dcloud.uniapp.extapi.onSocketOpen as uni_onSocketOpen
import io.dcloud.uniapp.extapi.sendSocketMessage as uni_sendSocketMessage
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading
import io.dcloud.uniapp.extapi.showModal as uni_showModal
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesAPIWebsocketWebsocket : BasePage {
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
        var setup: (__props: GenPagesAPIWebsocketWebsocket) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIWebsocketWebsocket
            val _cache = __ins.renderCache
            val connected = ref(false)
            val connecting = ref(false)
            val msg = ref("")
            val roomId = ref("")
            val platform = ref("")
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
            onLoad(fun(_options){
                platform.value = uni_getDeviceInfo(null).platform as String
            }
            )
            onUnload(fun(){
                uni_closeSocket(CloseSocketOptions(code = 1000, reason = "close reason from client", success = fun(res: Any){
                    console.log("uni.closeSocket success", res)
                }
                , fail = fun(err: Any){
                    console.log("uni.closeSocket fail", err)
                }
                ))
                uni_hideLoading(null)
            }
            )
            val connect = fun(){
                if (connected.value || connecting.value) {
                    uni_showModal(ShowModalOptions(content = "正在连接或者已经连接，请勿重复连接", showCancel = false))
                    return
                }
                connecting.value = true
                uni_showLoading(ShowLoadingOptions(title = "连接中..."))
                uni_connectSocket(ConnectSocketOptions(url = "wss://websocket.dcloud.net.cn", header = _uO("test" to "uniapp x"), protocols = null, success = fun(res: Any){
                    console.log("uni.connectSocket success", res)
                }
                , fail = fun(err: Any){
                    console.log("uni.connectSocket fail", err)
                }
                ))
                uni_onSocketOpen(fun(res){
                    connecting.value = false
                    connected.value = true
                    uni_hideLoading(null)
                    uni_showToast(ShowToastOptions(icon = "none", title = "连接成功"))
                    console.log("onOpen", res)
                }
                )
                uni_onSocketError(fun(err){
                    connecting.value = false
                    connected.value = false
                    uni_hideLoading(null)
                    uni_showModal(ShowModalOptions(content = "连接失败，可能是websocket服务不可用，请稍后再试", showCancel = false))
                    console.log("onError", err)
                }
                )
                uni_onSocketMessage(fun(res){
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
                uni_onSocketClose(fun(res){
                    connected.value = false
                    msg.value = ""
                    console.log("onClose", res)
                }
                )
            }
            val send = fun(){
                uni_sendSocketMessage(SendSocketMessageOptions(data = "from " + platform.value + " : " + parseInt((Math.random() * 10000).toString(10)).toString(10), success = fun(res: Any){
                    console.log(res)
                }
                , fail = fun(err: Any){
                    console.log(err)
                }
                ))
            }
            val close = fun(){
                uni_closeSocket(CloseSocketOptions(code = 1000, reason = "close reason from client", success = fun(res: Any){
                    console.log("uni.closeSocket success", res)
                }
                , fail = fun(err: Any){
                    console.log("uni.closeSocket fail", err)
                }
                ))
            }
            val goSocketTask = fun(){
                uni_navigateTo(NavigateToOptions(url = "/pages/API/websocket/socketTask"))
            }
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
                            _cE("button", _uM("class" to "uni-btn-v", "type" to "primary", "onClick" to close), " 断开websocket服务 "),
                            _cE("text", _uM("class" to "websocket-tips"), "发送消息后会收到一条服务器返回的消息（与发送的消息内容一致）"),
                            _cE("text", _uM("class" to "websocket-tips"), "web端和小程序端uni-push功能、app-android端和app-ios端的web-view组件日志回显、app-harmony端的日志回显会占用一个socket链接，此时使用全局的socket api会引发混乱。应使用socketTask操作websocket链接。"),
                            _cE("text", _uM("class" to "websocket-tips"), "小程序端日志回显功能也会占用一个socket链接，如果不希望使用此功能可以在HBuilderX控制台关闭日志回显。"),
                            _cE("button", _uM("class" to "uni-btn-v", "type" to "primary", "onClick" to goSocketTask), " 跳转 socketTask 示例 ")
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
                return _uM("uni-btn-v" to _pS(_uM("paddingTop" to 5, "paddingRight" to 0, "paddingBottom" to 5, "paddingLeft" to 0, "marginTop" to 10, "marginRight" to 0, "marginBottom" to 10, "marginLeft" to 0)), "websocket-msg" to _pS(_uM("paddingTop" to 40, "paddingRight" to 0, "paddingBottom" to 40, "paddingLeft" to 0, "textAlign" to "center", "fontSize" to 14, "lineHeight" to "40px", "color" to "#666666")), "websocket-tips" to _pS(_uM("paddingTop" to 10, "paddingRight" to 0, "paddingBottom" to 10, "paddingLeft" to 0, "textAlign" to "center", "fontSize" to 14, "lineHeight" to "24px", "color" to "#666666")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
