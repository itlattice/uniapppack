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
import io.dcloud.uniapp.extapi.createWebviewContext as uni_createWebviewContext
import io.dcloud.uniapp.extapi.getElementById as uni_getElementById
import io.dcloud.uniapp.extapi.showModal as uni_showModal
open class GenPagesComponentWebViewWebViewWebViewLocal : BasePage {
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
    open var data: DataType__35
        get() {
            return unref(this.`$exposed`["data"]) as DataType__35
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var testEventDownload: () -> Unit
        get() {
            return unref(this.`$exposed`["testEventDownload"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "testEventDownload", value)
        }
    open var testEventMessage: () -> Unit
        get() {
            return unref(this.`$exposed`["testEventMessage"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "testEventMessage", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentWebViewWebViewWebViewLocal, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentWebViewWebViewWebViewLocal
            val _cache = __ins.renderCache
            val data = reactive(DataType__35(loadError = false, loadFinish = false, autoTest = false, eventMessage = null as UTSJSONObject?, eventDownload = null as UTSJSONObject?))
            fun gen_evalJS_fn() {
                val webview = uni_getElementById("web-view") as UniWebViewElement
                webview.evalJS("postMessage(\"evalJS\")")
            }
            val evalJS = ::gen_evalJS_fn
            fun gen_message_fn(event: UniWebViewMessageEvent) {
                console.log(JSON.stringify(event.detail))
                var contentStr = JSON.stringify(event.detail)
                uni_showModal(ShowModalOptions(content = contentStr, showCancel = false))
                if (data.autoTest) {
                    data.eventMessage = _uO("tagName" to event.target?.tagName, "type" to event.type, "data" to event.detail.data)
                }
            }
            val message = ::gen_message_fn
            fun gen_error_fn(event: UniWebViewErrorEvent) {
                console.log(JSON.stringify(event.detail))
            }
            val error = ::gen_error_fn
            fun gen_loading_fn(event: UniWebViewLoadingEvent) {
                console.log(JSON.stringify(event.detail))
            }
            val loading = ::gen_loading_fn
            fun gen_load_fn(event: UniWebViewLoadEvent) {
                data.loadFinish = true
                console.log(JSON.stringify(event.detail))
            }
            val load = ::gen_load_fn
            fun gen_download_fn(event: UniWebViewDownloadEvent) {
                console.log(JSON.stringify(event.detail))
                if (data.autoTest) {
                    val arr = event.detail.userAgent.split(" ")
                    data.eventDownload = _uO("tagName" to event.target?.tagName, "type" to event.type, "url" to event.detail.url, "userAgent" to arr[arr.length - 1], "contentDisposition" to event.detail.contentDisposition, "mimetype" to event.detail.mimetype, "isContentLengthValid" to (Math.trunc(event.detail.contentLength / 1024 / 1024) > 1))
                }
            }
            val download = ::gen_download_fn
            fun gen_testEventDownload_fn() {
                uni_createWebviewContext("web-view", null)?.evalJS("document.getElementsByTagName('a')[0].click()")
            }
            val testEventDownload = ::gen_testEventDownload_fn
            fun gen_testEventMessage_fn() {
                uni_createWebviewContext("web-view", null)?.evalJS("document.getElementById('postMessage').click()")
            }
            val testEventMessage = ::gen_testEventMessage_fn
            __expose(_uM("data" to data, "testEventDownload" to testEventDownload, "testEventMessage" to testEventMessage))
            return fun(): Any? {
                val _component_web_view = resolveComponent("web-view")
                return _cE(Fragment, null, _uA(
                    _cV(_component_web_view, _uM("id" to "web-view", "ref" to "web-view", "class" to "web-view", "src" to "/hybrid/html/local.html", "onMessage" to message, "onError" to error, "onLoading" to loading, "onLoad" to load, "onDownload" to download), null, 512),
                    _cE("button", _uM("onClick" to evalJS), "evalJS"),
                    _cE("view", _uM("class" to "safe-area-inset-bottom"))
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
                return _uM("web-view" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "safe-area-inset-bottom" to _pS(_uM("height" to "var(--uni-safe-area-inset-bottom)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
