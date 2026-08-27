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
open class GenComponentsXEmpty : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var icon: String by `$props`
    open var content: String by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXEmpty) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXEmpty
            val _cache = __ins.renderCache
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                return _cE("view", _uM("class" to "empty"), _uA(
                    _cV(_component_x_iconfont, _uM("name" to _ctx.icon, "size" to "130", "color" to "#aaaaaa", "class" to "align-center icon"), null, 8, _uA(
                        "name"
                    )),
                    _cE("text", _uM("class" to "content align-center"), _tD(_ctx.content), 1)
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
                return _uM("empty" to _pS(_uM("marginTop" to "20%")), "content" to _uM(".empty " to _uM("fontSize" to 14, "color" to "#aaaaaa", "marginTop" to 20)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("icon" to _uM("type" to "String", "default" to "wushuju"), "content" to _uM("type" to "String", "default" to "无数据")))
        var propsNeedCastKeys = _uA(
            "icon",
            "content"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
