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
open class GenComponentsXShaixuawindow : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var show: Boolean by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXShaixuawindow) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXShaixuawindow
            val _cache = __ins.renderCache
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val props = __props
            val top = ref(66)
            val _show = computed(fun(): Boolean {
                return props.show
            }
            )
            val close = fun(){
                emit("update:show", false)
            }
            val updateShow = fun(value: Boolean){
                emit("update:show", value)
            }
            watch(fun(): Boolean {
                return props.show
            }
            , fun(newVal: Boolean){
                if (!newVal) {
                    return
                }
                var windowInfo = uni_getWindowInfo()
                console.log(windowInfo)
                top.value = windowInfo.statusBarHeight + 42
            }
            )
            return fun(): Any? {
                val _component_tmx_drawer = resolveEasyComponent("tmx-drawer", GenUniModulesTmxUiComponentsTmxDrawerTmxDrawerClass)
                return _cV(_component_tmx_drawer, _uM("show" to unref(_show), "onUpdate:show" to updateShow, "size" to "75%", "offsetTop" to (unref(top) + "px"), "contentMargin" to "0", "showTitle" to false, "showCancel" to false, "position" to "right", "onClose" to close), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "filterwindow padding-safe-bottom"), _uA(
                            renderSlot(_ctx.`$slots`, "default")
                        ))
                    )
                }
                ), "_" to 3), 8, _uA(
                    "show",
                    "offsetTop"
                ))
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("update:show" to null)
        var props = _nP(_uM("show" to _uM("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = _uA(
            "show"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
