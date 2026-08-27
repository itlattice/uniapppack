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
import io.dcloud.uniapp.extapi.connectEventSource as uni_connectEventSource
import io.dcloud.uniapp.extapi.hideLoading as uni_hideLoading
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading
open class GenPagesAPIConnectEventSourceConnectEventSource : BasePage {
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
    open var data: DataType__76
        get() {
            return unref(this.`$exposed`["data"]) as DataType__76
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var connect: () -> Unit
        get() {
            return unref(this.`$exposed`["connect"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "connect", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIConnectEventSourceConnectEventSource, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIConnectEventSourceConnectEventSource
            val _cache = __ins.renderCache
            val data = reactive(DataType__76(logList = _uA<String>(), title = "sse", url = "https://request.dcloud.net.cn/api/sse/connect", eventSource = null, open = false, receiveMessage = false))
            onUnmounted(fun(){
                if (data.eventSource != null) {
                    data.eventSource?.close()
                }
            }
            )
            val connect = fun(){
                console.log("connect start")
                uni_showLoading(ShowLoadingOptions(title = "", mask = true))
                data.eventSource?.close()
                var headers: UTSJSONObject = UTSJSONObject()
                headers.set("header1", "value1")
                headers.set("header2", "value3")
                data.eventSource = uni_connectEventSource(ConnectEventSourceOptions(url = data.url, header = headers))
                data.eventSource?.onMessage(fun(ev){
                    val log = "onMessage callback:\ntype: " + ev.type + "\n" + "data: " + ev.data + "\n\n"
                    data.logList.push(log)
                    data.receiveMessage = true
                    uni_hideLoading(null)
                }
                )
                data.eventSource?.onOpen(fun(ev){
                    val log = "onOpen callback: " + ev.type + "\n\n"
                    data.logList.push(log)
                    data.open = true
                }
                )
                data.eventSource?.onError(fun(err){
                    val log = "onError callback: " + err + " \n\n"
                    data.logList.push(log)
                    uni_hideLoading(null)
                }
                )
            }
            val close = fun(){
                data.eventSource?.close()
                val log = "connect close\n\n"
                data.logList.push(log)
            }
            __expose(_uM("data" to data, "connect" to connect))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE(Fragment, null, _uA(
                    _cV(_component_page_head, _uM("title" to unref(data).title), null, 8, _uA(
                        "title"
                    )),
                    _cE("button", _uM("class" to "button", "type" to "primary", "onClick" to connect), "连接"),
                    _cE("button", _uM("class" to "button", "type" to "primary", "onClick" to close), "关闭"),
                    _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                        _cE("view", null, _uA(
                            _cE("text", _uM("style" to _nS(_uM("width" to "100%", "text-align" to "center", "margin-bottom" to "5px"))), " 显示简易操作日志(可滚动查看) ", 4),
                            _cE("button", _uM("size" to "mini", "onClick" to fun(){
                                unref(data).logList = _uA()
                            }
                            ), "清空日志", 8, _uA(
                                "onClick"
                            )),
                            _cE("view", _uM("style" to _nS(_uM("margin-top" to "10px"))), _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(unref(data).logList, fun(item, index, __index, _cached): Any {
                                    return _cE("view", _uM("key" to index), _uA(
                                        _cE("text", _uM("style" to _nS(_uM("margin-left" to "20px", "margin-right" to "20px"))), _tD(item), 5)
                                    ))
                                }
                                ), 128)
                            ), 4)
                        ))
                    ), 4)
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
                return _uM("button" to _pS(_uM("marginLeft" to 30, "marginRight" to 30, "marginBottom" to 15)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
