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
open class GenComponentsXProcess : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var current: Number by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXProcess) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXProcess
            val _cache = __ins.renderCache
            return fun(): Any? {
                return _cE("view", _uM("class" to "progress-container"), _uA(
                    _cE("view", _uM("class" to "progress", "style" to _nS(_uM("width" to (_ctx.current + "%")))), null, 4)
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
                return _uM("progress-container" to _pS(_uM("position" to "relative", "height" to "11rpx", "width" to "95rpx", "backgroundImage" to "none", "backgroundColor" to "#d3d3d3")), "progress" to _pS(_uM("position" to "absolute", "height" to "100%", "backgroundImage" to "none", "backgroundColor" to "#1678fd")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("current" to _uM("type" to "Number", "default" to 0)))
        var propsNeedCastKeys = _uA(
            "current"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
