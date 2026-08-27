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
open class GenComponentsXViewTitleAction : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var backpage: Boolean by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXViewTitleAction) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXViewTitleAction
            val _cache = __ins.renderCache
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val props = __props
            val back = fun(){
                if (props.backpage) {
                    common.back()
                    return
                }
                emit("back")
            }
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                return _cE("view", _uM("class" to "native padding-stauts-bar background-main"), _uA(
                    _cE("view", _uM("class" to "nativetitle space-between"), _uA(
                        _cE("view", _uM("class" to "display-flex", "onClick" to back), _uA(
                            _cV(_component_x_iconfont, _uM("name" to "xiangzuo", "color" to "white", "height" to 20, "size" to "15"))
                        )),
                        _cE("view", _uM("class" to "centeraction"), _uA(
                            renderSlot(_ctx.`$slots`, "center")
                        )),
                        _cE("view", _uM("class" to "rightaction"), _uA(
                            renderSlot(_ctx.`$slots`, "right")
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
                return _uM("nativetitle" to _uM(".native " to _uM("paddingLeft" to "16rpx", "paddingRight" to "22rpx", "paddingTop" to 13, "height" to 40)), "text" to _uM(".native " to _uM("fontSize" to 15, "marginLeft" to "6rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("back" to null)
        var props = _nP(_uM("backpage" to _uM("type" to "Boolean", "default" to true)))
        var propsNeedCastKeys = _uA(
            "backpage"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
