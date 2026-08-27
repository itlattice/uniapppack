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
import io.dcloud.uniapp.extapi.getElementById as uni_getElementById
open class GenPagesAPIElementRequestFullscreenElementRequestFullscreenBugs : BasePage {
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
    open var requestfullscreen: () -> Unit
        get() {
            return unref(this.`$exposed`["requestfullscreen"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "requestfullscreen", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIElementRequestFullscreenElementRequestFullscreenBugs, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIElementRequestFullscreenElementRequestFullscreenBugs
            val _cache = __ins.renderCache
            val fullscreenElement = ref(null as UniElement?)
            val isFullscreen = ref(false)
            fun gen_getCurrentPage_fn(): UniPage {
                val pages = getCurrentPages()
                return pages[pages.length - 1]
            }
            val getCurrentPage = ::gen_getCurrentPage_fn
            fun gen_requestfullscreen_fn() {
                if (isFullscreen.value) {
                    val page = getCurrentPage()
                    page.exitFullscreen(ExitFullscreenOptions(success = fun(){}, fail = fun(_error){}, complete = fun(_result){}))
                } else {
                    fullscreenElement.value?.requestFullscreen(RequestFullscreenOptions(success = fun(){}, fail = fun(_error){}, complete = fun(_result){}))
                }
                isFullscreen.value = !isFullscreen.value
            }
            val requestfullscreen = ::gen_requestfullscreen_fn
            fun gen_exitfullscreen_fn() {}
            val exitfullscreen = ::gen_exitfullscreen_fn
            onReady(fun(){
                fullscreenElement.value = uni_getElementById("fullscreen") as UniElement
            }
            )
            __expose(_uM("requestfullscreen" to requestfullscreen))
            return fun(): Any? {
                return _cE("view", null, _uA(
                    _cE("view", _uM("style" to _nS(_uM("padding" to "8px"))), _uA(
                        _cE("view", _uM("class" to "position-error", "id" to "fullscreen", "onClick" to requestfullscreen), _uA(
                            _cE("text", _uM("style" to _nS(_uM("color" to "white"))), "测试position：fixed在安卓上的bug", 4)
                        ))
                    ), 4)
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
                return _uM("position-error" to _pS(_uM("width" to 200, "height" to 200, "position" to "fixed", "backgroundColor" to "#A52A2A")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
