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
open class GenPagesAPIUnicloudUnicloudSseChannel : BasePage {
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
    open var data: DataType__79
        get() {
            return unref(this.`$exposed`["data"]) as DataType__79
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var receiveMessage: () -> UTSPromise<Unit>
        get() {
            return unref(this.`$exposed`["receiveMessage"]) as () -> UTSPromise<Unit>
        }
        set(value) {
            setRefValue(this.`$exposed`, "receiveMessage", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIUnicloudUnicloudSseChannel, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIUnicloudUnicloudSseChannel
            val _cache = __ins.renderCache
            val title = ref("服务端通知通道")
            val data = reactive(DataType__79(messages = _uA<String>()))
            fun gen_receiveMessage_fn(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        data.messages.splice(0, data.messages.length)
                        val sseChannel = uniCloud.SSEChannel()
                        sseChannel.on("message", fun(message: Any?){
                            if (UTSAndroid.`typeof`(message) === "string") {
                                data.messages.push(message as String)
                            }
                        }
                        )
                        sseChannel.on("end", fun(message: Any?){
                            if (UTSAndroid.`typeof`(message) === "string") {
                                data.messages.push(message as String)
                            }
                        }
                        )
                        sseChannel.on("open", fun(){
                            console.log("sseChannel open")
                        }
                        )
                        sseChannel.on("close", fun(){
                            console.log("sseChannel close")
                        }
                        )
                        sseChannel.on("error", fun(error: UniCloudError){
                            console.log("sseChannel error: " + error.message)
                        }
                        )
                        await(sseChannel.open())
                        val res = await(uniCloud.callFunction(UniCloudCallFunctionOptions(name = "sse", data = _uO("sseChannel" to sseChannel))))
                        console.log(res)
                })
            }
            val receiveMessage = ::gen_receiveMessage_fn
            __expose(_uM("data" to data, "receiveMessage" to receiveMessage))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE("scroll-view", _uM("class" to "page-scroll-view"), _uA(
                    _cE("view", null, _uA(
                        _cV(_component_page_head, _uM("title" to unref(title)), null, 8, _uA(
                            "title"
                        )),
                        _cE("button", _uM("onClick" to receiveMessage), "接收服务端通知"),
                        _cE("view", null, _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(unref(data).messages, fun(item, __key, __index, _cached): Any {
                                return _cE("view", null, _tD(item), 1)
                            }
                            ), 256)
                        ))
                    ))
                ))
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
