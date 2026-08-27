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
open class GenComponentsXStaticAction : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var iconColor: String by `$props`
    open var icon: String by `$props`
    open var name: String by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXStaticAction) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXStaticAction
            val _cache = __ins.renderCache
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                return _cE("view", _uM("class" to "static-action display-flex"), _uA(
                    _cE("view", _uM("class" to "action-icon", "style" to _nS(_uM("background" to _ctx.iconColor))), _uA(
                        _cV(_component_x_iconfont, _uM("class" to "icon", "color" to "white", "name" to _ctx.icon, "size" to "23"), null, 8, _uA(
                            "name"
                        ))
                    ), 4),
                    _cE("view", _uM("class" to "action-title"), _uA(
                        _cE("text", _uM("class" to "title"), _tD(_ctx.name), 1),
                        _cE("view", _uM("class" to "scontent"), _uA(
                            renderSlot(_ctx.`$slots`, "content")
                        ))
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
                return _uM("static-action" to _pS(_uM("paddingLeft" to "12rpx")), "action-icon" to _uM(".static-action " to _uM("width" to 40, "height" to 40, "borderTopLeftRadius" to 20, "borderTopRightRadius" to 20, "borderBottomRightRadius" to 20, "borderBottomLeftRadius" to 20, "marginTop" to "3rpx")), "icon" to _uM(".static-action .action-icon " to _uM("paddingTop" to 8, "textAlign" to "center", "lineHeight" to "40px")), "action-title" to _uM(".static-action " to _uM("paddingLeft" to "17rpx", "paddingTop" to 5)), "title" to _uM(".static-action .action-title " to _uM("fontSize" to 16, "color" to "#000000")), "scontent" to _uM(".static-action .action-title " to _uM("marginTop" to "-12rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("iconColor" to _uM("type" to "String", "default" to "#FF5733"), "icon" to _uM("type" to "String", "default" to "saoyisao"), "name" to _uM("type" to "String", "default" to "销售报表")))
        var propsNeedCastKeys = _uA(
            "iconColor",
            "icon",
            "name"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
