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
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
open class GenComponentsXPage : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var topHeight: Number by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXPage) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXPage
            val _cache = __ins.renderCache
            val props = __props
            val pageHeight = computed(fun(): Number {
                return uni_getWindowInfo().safeArea.height - props.topHeight
            }
            )
            return fun(): Any? {
                return _cE("view", _uM("style" to _nS(_uM("height" to (unref(pageHeight) + "px")))), _uA(
                    _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                        renderSlot(_ctx.`$slots`, "default")
                    ), 4)
                ), 4)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("topHeight" to _uM("type" to "Number", "default" to 40)))
        var propsNeedCastKeys = _uA(
            "topHeight"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
