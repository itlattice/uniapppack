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
open class GenComponentsXMineAction : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var name: String by `$props`
    open var color: String by `$props`
    open var icon: String by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXMineAction) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXMineAction
            val _cache = __ins.renderCache
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                return _cE("view", _uM("class" to "maction"), _uA(
                    _cE("view", _uM("class" to "icon"), _uA(
                        _cV(_component_x_iconfont, _uM("class" to "ico", "color" to _ctx.color, "name" to _ctx.icon, "size" to "35"), null, 8, _uA(
                            "color",
                            "name"
                        ))
                    )),
                    _cE("view", _uM("class" to "mcontent"), _uA(
                        _cE("text", _uM("class" to "text align-center"), _tD(_ctx.name), 1)
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
                return _uM("ico" to _uM(".maction .icon " to _uM("marginTop" to 0, "marginRight" to "auto", "marginBottom" to 0, "marginLeft" to "auto")), "mcontent" to _uM(".maction " to _uM("paddingTop" to 5)), "text" to _uM(".maction .mcontent " to _uM("fontSize" to 12)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("name" to _uM("type" to "String", "default" to "物流设置"), "color" to _uM("type" to "String", "default" to "#1776FC"), "icon" to _uM("type" to "String", "default" to "wuliushezhi")))
        var propsNeedCastKeys = _uA(
            "name",
            "color",
            "icon"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
