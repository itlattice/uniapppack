@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNI2971F61
import android.content.Context
import io.dcloud.uniapp.*
import io.dcloud.uniapp.extapi.*
import io.dcloud.uniapp.framework.*
import io.dcloud.uniapp.runtime.*
import io.dcloud.uniapp.vue.*
import io.dcloud.uniapp.vue.shared.*
import io.dcloud.uts.*
import io.dcloud.uts.Map
import io.dcloud.uts.Set
import io.dcloud.uts.UTSAndroid
import kotlin.properties.Delegates
import uts.sdk.modules.iboxsChooseMedia.MediaScanner
open class GenComponentsXTriangleinput : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var width: Number by `$props`
    open var height: Number by `$props`
    open var borderColor: String by `$props`
    open var unit: String by `$props`
    open var jColor: String by `$props`
    open var size: Number by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXTriangleinput) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXTriangleinput
            val _cache = __ins.renderCache
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val click = fun(){
                emit("click")
            }
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                return _cE("view", _uM("class" to "triangleinput position-relative", "style" to _nS(_uM("width" to (_ctx.width + _ctx.unit), "height" to (_ctx.height + "px"), "borderColor" to _ctx.borderColor)), "onClick" to click), _uA(
                    renderSlot(_ctx.`$slots`, "default"),
                    _cV(_component_x_iconfont, _uM("class" to "icon position-absolute", "name" to "triangle", "color" to _ctx.jColor, "size" to _ctx.size), null, 8, _uA(
                        "color",
                        "size"
                    ))
                ), 4)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("triangleinput" to _pS(_uM("borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#000000")), "icon" to _uM(".triangleinput " to _uM("bottom" to -1, "right" to 0)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("click" to null)
        var props = _nP(_uM("width" to _uM("type" to "Number", "default" to 200), "height" to _uM("type" to "Number", "default" to 25), "borderColor" to _uM("type" to "String", "default" to "#f5f5f5"), "unit" to _uM("type" to "String", "default" to "rpx"), "jColor" to _uM("type" to "String", "default" to "#1776FC"), "size" to _uM("type" to "Number", "default" to 12)))
        var propsNeedCastKeys = _uA(
            "width",
            "height",
            "borderColor",
            "unit",
            "jColor",
            "size"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
