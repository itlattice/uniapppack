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
import io.dcloud.uniapp.extapi.closePreviewImage as uni_closePreviewImage
import io.dcloud.uniapp.extapi.previewImage as uni_previewImage
open class GenPagesAPIPreviewImagePreviewImageMulti : BasePage {
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
    open var data: Data__1
        get() {
            return unref(this.`$exposed`["data"]) as Data__1
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var testPreviewImage: () -> Unit
        get() {
            return unref(this.`$exposed`["testPreviewImage"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "testPreviewImage", value)
        }
    open var testClosePreviewImage: () -> Unit
        get() {
            return unref(this.`$exposed`["testClosePreviewImage"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "testClosePreviewImage", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIPreviewImagePreviewImageMulti, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIPreviewImagePreviewImageMulti
            val _cache = __ins.renderCache
            val data = Data__1(urls = _uA(), indicatorType = "number")
            fun gen_testPreviewImage_fn() {
                uni_previewImage(PreviewImageOptions(urls = data.urls, indicator = data.indicatorType, complete = fun(_) {}))
            }
            val testPreviewImage = ::gen_testPreviewImage_fn
            val testClosePreviewImage = fun(){
                uni_closePreviewImage(ClosePreviewImageOptions())
            }
            __expose(_uM("data" to data, "testPreviewImage" to testPreviewImage, "testClosePreviewImage" to testClosePreviewImage))
            return fun(): Any? {
                return _cE("view")
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
