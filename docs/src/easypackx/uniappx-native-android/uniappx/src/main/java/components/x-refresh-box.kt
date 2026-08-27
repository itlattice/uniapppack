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
open class GenComponentsXRefreshBox : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var state: Number by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXRefreshBox) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXRefreshBox
            val _cache = __ins.renderCache
            val text = ref(_uA(
                "继续下拉执行刷新",
                "释放立即刷新",
                "刷新中",
                "刷新完成"
            ))
            return fun(): Any? {
                val _component_tmx_loading = resolveEasyComponent("tmx-loading", GenUniModulesTmxUiComponentsTmxLoadingTmxLoadingClass)
                val _component_x_loading = resolveEasyComponent("x-loading", GenComponentsXLoadingClass)
                return _cE("view", _uM("slot" to "refresher", "class" to "refresh-box"), _uA(
                    _cV(_component_tmx_loading, _uM("label" to unref(text)[_ctx.state], "showIcon" to (_ctx.state == 2), "icon" to "loader-line", "vertical" to false), null, 8, _uA(
                        "label",
                        "showIcon"
                    )),
                    _cV(_component_x_loading, _uM("title" to unref(text)[_ctx.state], "showIcon" to (_ctx.state == 2)), null, 8, _uA(
                        "title",
                        "showIcon"
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
                return _uM("refresh-box" to _pS(_uM("justifyContent" to "center", "alignItems" to "center", "flexDirection" to "row", "width" to "100%", "height" to 30)), "refresh-icon" to _pS(_uM("width" to 20, "height" to 20, "marginTop" to 5, "marginRight" to 5, "marginBottom" to 5, "marginLeft" to 5)), "tip-text" to _pS(_uM("color" to "#888888", "fontSize" to 12)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("state" to _uM("type" to "Number", "default" to 0)))
        var propsNeedCastKeys = _uA(
            "state"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
