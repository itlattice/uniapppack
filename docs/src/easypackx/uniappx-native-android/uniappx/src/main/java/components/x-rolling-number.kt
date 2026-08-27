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
open class GenComponentsXRollingNumber : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var `val`: Number by `$props`
    open var decimals: Number by `$props`
    open var fontSize: String by `$props`
    open var fontColor: String by `$props`
    open var fontStyle: String by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXRollingNumber) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXRollingNumber
            val _cache = __ins.renderCache
            return fun(): Any? {
                val _component_tmx_rolling_number = resolveEasyComponent("tmx-rolling-number", GenUniModulesTmxUiComponentsTmxRollingNumberTmxRollingNumberClass)
                return _cV(_component_tmx_rolling_number, _uM("fontSize" to _ctx.fontSize, "enableAnimation" to true, "decimals" to _ctx.decimals, "font-color" to _ctx.fontColor, "font-style" to _ctx.fontStyle, "end-val" to _ctx.`val`, "useGrouping" to true), null, 8, _uA(
                    "fontSize",
                    "decimals",
                    "font-color",
                    "font-style",
                    "end-val"
                ))
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("val" to _uM("type" to "Number", "default" to 0), "decimals" to _uM("type" to "Number", "default" to 0), "fontSize" to _uM("type" to "String", "default" to "16px"), "fontColor" to _uM("type" to "String", "default" to "#000"), "fontStyle" to _uM("type" to "String", "default" to "text-align:center;font-weight:bold;")))
        var propsNeedCastKeys = _uA(
            "val",
            "decimals",
            "fontSize",
            "fontColor",
            "fontStyle"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
