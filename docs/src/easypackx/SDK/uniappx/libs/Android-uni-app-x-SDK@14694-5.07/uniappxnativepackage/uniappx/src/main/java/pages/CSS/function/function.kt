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
open class GenPagesCSSFunctionFunction : BasePage {
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
        var setup: (__props: GenPagesCSSFunctionFunction) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSFunctionFunction
            val _cache = __ins.renderCache
            val safeareaInsetTop = ref(0)
            val safeareaInsetLeft = ref(0)
            val safeareaInsetRight = ref(0)
            val safeareaInsetBottom = ref(0)
            val instance = getCurrentInstance()
            onReady(fun(){
                val page = instance?.proxy?.`$page`
                safeareaInsetTop.value = page?.safeAreaInsets?.top ?: 0
                safeareaInsetLeft.value = page?.safeAreaInsets?.left ?: 0
                safeareaInsetRight.value = page?.safeAreaInsets?.right ?: 0
                safeareaInsetBottom.value = page?.safeAreaInsets?.bottom ?: 0
            }
            )
            onResize(fun(options){
                val page = instance?.proxy?.`$page`
                safeareaInsetTop.value = page?.safeAreaInsets?.top ?: 0
                safeareaInsetLeft.value = page?.safeAreaInsets?.left ?: 0
                safeareaInsetRight.value = page?.safeAreaInsets?.right ?: 0
                safeareaInsetBottom.value = page?.safeAreaInsets?.bottom ?: 0
            }
            )
            return fun(): Any? {
                return _cE("view", _uM("class" to "padding-safe-area-inset"), _uA(
                    _cE("view", _uM("class" to "text-background"), "我在状态栏下边"),
                    _cE("view", _uM("class" to "content"), _uA(
                        _cE("text", null, "此页面使用env()函数适配安全区域，仅在app平台生效。"),
                        _cE("text", null, "safe-area-inset-top: " + _tD(unref(safeareaInsetTop)) + "px", 1),
                        _cE("text", null, "safe-area-inset-left: " + _tD(unref(safeareaInsetLeft)) + "px", 1),
                        _cE("text", null, "safe-area-inset-right: " + _tD(unref(safeareaInsetRight)) + "px", 1),
                        _cE("text", null, "safe-area-inset-bottom: " + _tD(unref(safeareaInsetBottom)) + "px", 1)
                    )),
                    _cE("view", _uM("class" to "text-background"), "我在导航栏上边")
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
                return _uM("text-background" to _pS(_uM("backgroundColor" to "#FF0000")), "padding-safe-area-inset" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "justifyContent" to "space-between", "paddingTop" to "env(safe-area-inset-top,0px)", "paddingLeft" to "env(safe-area-inset-left,0px)", "paddingRight" to "env(safe-area-inset-right,0px)", "paddingBottom" to "env(safe-area-inset-bottom,0px)")), "content" to _pS(_uM("paddingTop" to 20, "paddingRight" to 20, "paddingBottom" to 20, "paddingLeft" to 20)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
