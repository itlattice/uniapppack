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
import io.dcloud.uniapp.extapi.arrayBufferToBase64 as uni_arrayBufferToBase64
import io.dcloud.uniapp.extapi.base64ToArrayBuffer as uni_base64ToArrayBuffer
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesAPIBase64Base64 : BasePage {
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
    open var data: DataType__105
        get() {
            return unref(this.`$exposed`["data"]) as DataType__105
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var arrayBufferToBase64: () -> Unit
        get() {
            return unref(this.`$exposed`["arrayBufferToBase64"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "arrayBufferToBase64", value)
        }
    open var base64ToArrayBuffer: () -> Unit
        get() {
            return unref(this.`$exposed`["base64ToArrayBuffer"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "base64ToArrayBuffer", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIBase64Base64, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIBase64Base64
            val _cache = __ins.renderCache
            val data = reactive(DataType__105(arrayBufferToBase64Res = "", base64ToArrayBufferRes = ""))
            val arrayBufferToBase64 = fun(){
                val arraybuffer = ArrayBuffer(3)
                val uint8 = Uint8Array(arraybuffer)
                uint8.set(_uA(
                    11,
                    22,
                    33
                ))
                val base64 = uni_arrayBufferToBase64(arraybuffer)
                console.log(base64)
                data.arrayBufferToBase64Res = base64
                uni_showToast(ShowToastOptions(title = data.arrayBufferToBase64Res))
            }
            val base64ToArrayBuffer = fun(){
                val base64 = "CxYh"
                val arrayBuffer = uni_base64ToArrayBuffer(base64)
                val uint8 = Uint8Array(arrayBuffer)
                console.log(uint8.toString())
                data.base64ToArrayBufferRes = uint8.toString()
                uni_showToast(ShowToastOptions(title = data.base64ToArrayBufferRes))
            }
            __expose(_uM("data" to data, "arrayBufferToBase64" to arrayBufferToBase64, "base64ToArrayBuffer" to base64ToArrayBuffer))
            return fun(): Any? {
                return _cE("view", null, _uA(
                    _cE("view", null, _uA(
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to arrayBufferToBase64), " arrayBufferToBase64 "),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to base64ToArrayBuffer), " base64ToArrayBuffer ")
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
                return _uM("logo" to _pS(_uM("height" to 100, "width" to 100, "marginTop" to 100, "marginRight" to "auto", "marginBottom" to 25, "marginLeft" to "auto")), "title" to _pS(_uM("fontSize" to 18, "color" to "#8f8f94", "textAlign" to "center")), "btnstyle" to _pS(_uM("marginTop" to 4, "marginRight" to 4, "marginBottom" to 4, "marginLeft" to 4)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
