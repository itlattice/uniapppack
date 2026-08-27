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
open class GenPagesCSSVariableVariable : BasePage {
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
        var setup: (__props: GenPagesCSSVariableVariable) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSVariableVariable
            val _cache = __ins.renderCache
            val statusBarHeight = ref(0)
            val statusBarHeight2 = ref(0)
            val instance = getCurrentInstance()
            onReady(fun(){
                statusBarHeight.value = uni_getWindowInfo().statusBarHeight
                statusBarHeight2.value = instance?.proxy?.`$page`?.statusBarHeight ?: 0
            }
            )
            return fun(): Any? {
                return _cE("view", _uM("class" to "page"), _uA(
                    _cE("view", _uM("class" to "status-bar-height"), _uA(
                        _cE("text", null, "通过var(--status-bar-height)获取状态栏高度")
                    )),
                    _cE("view", _uM("class" to "status-bar-window", "style" to _nS(_uM("height" to (unref(statusBarHeight) + "px")))), _uA(
                        _cE("text", null, "通过uni.getWindowInfo获取状态栏高度")
                    ), 4),
                    _cE("view", _uM("class" to "status-bar-unipage", "style" to _nS(_uM("height" to (unref(statusBarHeight2) + "px")))), _uA(
                        _cE("text", null, "通过this.\$page.statusBarHeight获取状态栏高度")
                    ), 4),
                    _cE("view", _uM("class" to "window-top"), _uA(
                        _cE("text", null, "window top")
                    )),
                    _cE("view", _uM("class" to "window-bottom"), _uA(
                        _cE("text", null, "window bottom")
                    )),
                    _cE("view", _uM("class" to "uni-safe-area-inset-top"), _uA(
                        _cE("text", null, "height:var(--uni-safe-area-inset-top)")
                    )),
                    _cE("view", _uM("class" to "uni-safe-area-inset-left"), _uA(
                        _cE("text", null, "height:var(--uni-safe-area-inset-left)")
                    )),
                    _cE("view", _uM("class" to "uni-safe-area-inset-right"), _uA(
                        _cE("text", null, "height:var(--uni-safe-area-inset-right)")
                    )),
                    _cE("view", _uM("class" to "uni-safe-area-inset-bottom"), _uA(
                        _cE("text", null, "height:var(--uni-safe-area-inset-bottom)")
                    )),
                    _cE("view", _uM("class" to "uni-fixed-bottom"), _uA(
                        _cE("text", null, "此区域应显示在安全区域内")
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
                return _uM("page" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "status-bar-height" to _pS(_uM("height" to CSS_VAR_STATUS_BAR_HEIGHT, "alignItems" to "center", "justifyContent" to "center", "backgroundColor" to "#FF0000")), "status-bar-window" to _pS(_uM("backgroundColor" to "#FFFF00", "alignItems" to "center", "justifyContent" to "center")), "status-bar-unipage" to _pS(_uM("alignItems" to "center", "justifyContent" to "center", "backgroundColor" to "#ADFF2F")), "window-top" to _pS(_uM("height" to CSS_VAR_WINDOW_TOP, "alignItems" to "center", "backgroundColor" to "#008000", "marginTop" to 2, "marginRight" to 0, "marginBottom" to 2, "marginLeft" to 0)), "window-bottom" to _pS(_uM("height" to CSS_VAR_WINDOW_BOTTOM, "alignItems" to "center", "backgroundColor" to "#0000FF", "marginTop" to 2, "marginRight" to 0, "marginBottom" to 2, "marginLeft" to 0)), "uni-safe-area-inset-top" to _pS(_uM("height" to "var(--uni-safe-area-inset-top)", "alignItems" to "center", "backgroundColor" to "#FFFF00", "marginTop" to 2, "marginRight" to 0, "marginBottom" to 2, "marginLeft" to 0)), "uni-safe-area-inset-left" to _pS(_uM("height" to "var(--uni-safe-area-inset-left)", "alignItems" to "center", "backgroundColor" to "#ADFF2F", "marginTop" to 2, "marginRight" to 0, "marginBottom" to 2, "marginLeft" to 0)), "uni-safe-area-inset-right" to _pS(_uM("height" to "var(--uni-safe-area-inset-right, 60px)", "alignItems" to "center", "backgroundColor" to "#8B4513", "marginTop" to 2, "marginRight" to 0, "marginBottom" to 2, "marginLeft" to 0)), "uni-safe-area-inset-bottom" to _pS(_uM("height" to "var(--uni-safe-area-inset-bottom)", "alignItems" to "center", "backgroundColor" to "#FA8072", "marginTop" to 2, "marginRight" to 0, "marginBottom" to 2, "marginLeft" to 0)), "uni-fixed-bottom" to _pS(_uM("position" to "fixed", "left" to "var(--uni-safe-area-inset-left)", "right" to "var(--uni-safe-area-inset-right)", "bottom" to "var(--uni-safe-area-inset-bottom)", "alignItems" to "center", "backgroundColor" to "#8A2BE2")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
