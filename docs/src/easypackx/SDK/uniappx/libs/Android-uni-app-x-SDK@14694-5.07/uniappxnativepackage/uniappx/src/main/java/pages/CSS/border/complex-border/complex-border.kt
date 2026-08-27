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
open class GenPagesCSSBorderComplexBorderComplexBorder : BasePage {
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
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _cache = this.`$`.renderCache
        return _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1"))), _uA(
            _cE("view", null, _uA(
                _cE("text", null, "圆角 : 各边之间 不同width && 不同颜色 && 不同圆角"),
                _cE("view", _uM("style" to _nS(_uM("width" to "250px", "height" to "250px", "background-color" to "gray", "justify-content" to "center", "align-items" to "center"))), _uA(
                    _cE("view", _uM("class" to "border-circle"))
                ), 4)
            )),
            _cE("view", null, _uA(
                _cE("text", null, "直角 : 各边之间 不同width && 不同颜色 "),
                _cE("view", _uM("style" to _nS(_uM("width" to "250px", "height" to "250px", "background-color" to "gray", "justify-content" to "center", "align-items" to "center"))), _uA(
                    _cE("view", _uM("class" to "border-rect"))
                ), 4)
            ))
        ), 4)
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("common" to _pS(_uM("width" to 250, "height" to 250, "backgroundColor" to "#808080")), "border-circle" to _pS(_uM("width" to 125, "height" to 125, "backgroundColor" to "#00dd00", "borderTopWidth" to 10, "borderRightWidth" to 10, "borderBottomWidth" to 20, "borderLeftWidth" to 10, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#000000", "borderRightColor" to "#FFDC02", "borderBottomColor" to "#ff0000", "borderLeftColor" to "#000000", "borderBottomRightRadius" to 5, "borderBottomLeftRadius" to 5, "borderTopLeftRadius" to 5, "borderTopRightRadius" to 5)), "border-rect" to _pS(_uM("width" to 125, "height" to 125, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "backgroundColor" to "#00dd00", "borderTopWidth" to 10, "borderRightWidth" to 10, "borderBottomWidth" to 20, "borderLeftWidth" to 10, "borderTopColor" to "#000000", "borderRightColor" to "#FFDC02", "borderBottomColor" to "#ff0000", "borderLeftColor" to "#000000")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
