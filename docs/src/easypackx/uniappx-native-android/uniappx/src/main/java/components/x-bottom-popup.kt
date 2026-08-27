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
open class GenComponentsXBottomPopup : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var color: String by `$props`
    open var icon: String by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXBottomPopup) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXBottomPopup
            val _cache = __ins.renderCache
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val offset = ref(_uA<Number>(-1, -1))
            val thresholdBottom = ref(12)
            val thresholdTop = ref(0)
            val clickMenu = fun(){
                emit("clickOn")
            }
            onMounted(fun(){
                var info = uni_getWindowInfo()
                thresholdBottom.value = info.safeAreaInsets.bottom + 30
                thresholdTop.value = info.statusBarHeight + 42
                offset.value = _uA(
                    info.safeArea.right,
                    info.safeArea.bottom - 180
                )
                console.log(offset.value)
            }
            )
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_tmx_float_button = resolveEasyComponent("tmx-float-button", GenUniModulesTmxUiComponentsTmxFloatButtonTmxFloatButtonClass)
                return _cV(_component_tmx_float_button, _uM("bgColor" to _ctx.color, "offset" to unref(offset), "thresholdBottom" to unref(thresholdBottom), "thresholdTop" to unref(thresholdTop), "onClick" to clickMenu), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cV(_component_x_iconfont, _uM("class" to "icon", "height" to 50, "name" to _ctx.icon, "color" to "white"), null, 8, _uA(
                            "name"
                        ))
                    )
                }
                ), "_" to 1), 8, _uA(
                    "bgColor",
                    "offset",
                    "thresholdBottom",
                    "thresholdTop"
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
                return _uM("popupmenu" to _pS(_uM("right" to "20rpx", "height" to 60, "width" to 60, "borderTopLeftRadius" to 30, "borderTopRightRadius" to 30, "borderBottomRightRadius" to 30, "borderBottomLeftRadius" to 30)), "icon" to _uM(".popupmenu " to _uM("paddingTop" to 13.5, "textAlign" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("clickOn" to null)
        var props = _nP(_uM("color" to _uM("type" to "String", "default" to "#1678fd"), "icon" to _uM("type" to "String", "default" to "saoyisao")))
        var propsNeedCastKeys = _uA(
            "color",
            "icon"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
