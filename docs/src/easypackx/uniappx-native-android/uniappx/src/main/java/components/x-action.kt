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
open class GenComponentsXAction : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var name: String by `$props`
    open var icon: String by `$props`
    open var color: String by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXAction) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXAction
            val _cache = __ins.renderCache
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                return _cE("view", _uM("class" to "xaction"), _uA(
                    _cE("view", _uM("class" to "action-icon", "style" to _nS(_uM("backgroundColor" to _ctx.color))), _uA(
                        _cE("view", _uM("class" to "icon"), _uA(
                            _cV(_component_x_iconfont, _uM("size" to "23", "style" to _nS(_uM("text-align" to "center", "line-height" to "80rpx")), "color" to "white", "name" to _ctx.icon), null, 8, _uA(
                                "style",
                                "name"
                            ))
                        ))
                    ), 4),
                    _cE("text", _uM("class" to "name align-center text font"), _tD(_ctx.name), 1)
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
                return _uM("action-icon" to _uM(".xaction " to _uM("width" to "80rpx", "height" to "80rpx", "borderTopLeftRadius" to "40rpx", "borderTopRightRadius" to "40rpx", "borderBottomRightRadius" to "40rpx", "borderBottomLeftRadius" to "40rpx", "marginTop" to 0, "marginRight" to "auto", "marginBottom" to 0, "marginLeft" to "auto")), "name" to _uM(".xaction " to _uM("marginTop" to "14rpx", "fontSize" to "26rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("name" to _uM("type" to "String", "default" to "操作按钮"), "icon" to _uM("type" to "String", "default" to "cangkukucun"), "color" to _uM("type" to "String", "default" to "#1678fd")))
        var propsNeedCastKeys = _uA(
            "name",
            "icon",
            "color"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
