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
open class GenComponentsXNaviteorder : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var title: String by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXNaviteorder) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXNaviteorder
            val _cache = __ins.renderCache
            val back = fun(){
                common.back()
            }
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                return _cE("view", _uM("class" to "background-main padding-stauts-bar navigat"), _uA(
                    _cE("view", _uM("class" to "navigattitle space-between"), _uA(
                        _cE("view", _uM("class" to "title display-flex", "onClick" to back), _uA(
                            _cV(_component_x_iconfont, _uM("height" to 42, "class" to "icon", "name" to "fanhui", "color" to "white", "size" to "18")),
                            _cE("text", _uM("class" to "name color-white"), _tD(_ctx.title), 1)
                        )),
                        _cE("view", _uM("class" to "actions display-flex"), _uA(
                            renderSlot(_ctx.`$slots`, "default")
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
                return _uM("navigattitle" to _uM(".navigat " to _uM("paddingLeft" to "10rpx", "paddingRight" to "20rpx", "height" to 42)), "name" to _uM(".navigat .navigattitle " to _uM("lineHeight" to "42px", "fontSize" to 16, "paddingLeft" to "6rpx"), ".navigat .navigattitle .actions " to _uM("fontSize" to 14)), "robot" to _uM(".navigat .navigattitle .actions " to _uM("marginLeft" to "30rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("title" to _uM("type" to "String", "default" to "标题")))
        var propsNeedCastKeys = _uA(
            "title"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
