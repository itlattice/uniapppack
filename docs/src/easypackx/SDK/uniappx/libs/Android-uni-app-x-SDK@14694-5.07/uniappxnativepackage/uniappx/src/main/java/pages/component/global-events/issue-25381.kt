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
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
open class GenPagesComponentGlobalEventsIssue25381 : BasePage {
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
    open var data: DataType__36
        get() {
            return unref(this.`$exposed`["data"]) as DataType__36
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentGlobalEventsIssue25381, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentGlobalEventsIssue25381
            val _cache = __ins.renderCache
            val data = reactive(DataType__36(ret1 = false))
            val appWidth = ref(0)
            val appHeight = ref(0)
            val animationInterval = ref<Number?>(null)
            val scanLinePosition = ref(0)
            fun gen_startScanAnimation_fn() {
                var interval = animationInterval.value
                if (interval != null) {
                    clearInterval(interval)
                }
                scanLinePosition.value = 0
                animationInterval.value = setInterval(fun(){
                    scanLinePosition.value += 0.1
                    if (scanLinePosition.value > 100) {
                        scanLinePosition.value = 0
                        val t = animationInterval.value
                        if (t != null) {
                            clearInterval(t)
                        }
                    }
                }
                , 2) as Number
            }
            val startScanAnimation = ::gen_startScanAnimation_fn
            onReady(fun(){
                console.log("onReady")
                data.ret1 = true
            }
            )
            onMounted(fun(){
                appWidth.value = uni_getWindowInfo().screenWidth
                appHeight.value = uni_getWindowInfo().screenHeight
                startScanAnimation()
            }
            )
            onUnmounted(fun(){
                val interval = animationInterval.value
                if (interval != null) {
                    clearInterval(interval)
                    animationInterval.value = null
                }
            }
            )
            __expose(_uM("data" to data))
            return fun(): Any? {
                return _cE("view", _uM("style" to _nS(_uM("background-color" to "black", "flex" to "1"))), _uA(
                    _cE("view", _uM("style" to _nS(_uM("width" to "100%", "height" to "60px", "background" to "linear-gradient(to bottom, #00000000, #FFFFFF)", "position" to "absolute", "top" to (unref(scanLinePosition) + "%")))), null, 4)
                ), 4)
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
