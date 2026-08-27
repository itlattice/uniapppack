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
open class GenComponentsXDrawer : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var i18n: Tmui4xI18nTml by `$data`
    open var show: () -> Unit
        get() {
            return unref(this.`$exposed`["show"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "show", value)
        }
    open var hide: () -> Unit
        get() {
            return unref(this.`$exposed`["hide"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "hide", value)
        }
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXDrawer, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXDrawer
            val _cache = __ins.renderCache
            val showShaixuanWindow = ref(false)
            val offsetTop = ref(0)
            onCreated(fun(){
                offsetTop.value = uni_getWindowInfo().safeArea.top + 40
            }
            )
            val show = fun(){
                showShaixuanWindow.value = true
            }
            val hide = fun(){
                showShaixuanWindow.value = false
            }
            __expose(_uM("show" to show, "hide" to hide))
            return fun(): Any? {
                val _component_tmx_drawer = resolveEasyComponent("tmx-drawer", GenUniModulesTmxUiComponentsTmxDrawerTmxDrawerClass)
                return if (unref(offsetTop) > 0) {
                    _cV(_component_tmx_drawer, _uM("key" to 0, "contentMargin" to "0", "position" to "right", "offset-top" to unref(offsetTop).toString(10), "show" to unref(showShaixuanWindow), "onUpdate:show" to fun(`$event`: Boolean){
                        trySetRefValue(showShaixuanWindow, `$event`)
                    }, "showTitle" to false, "size" to "100%"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            renderSlot(_ctx.`$slots`, "default")
                        )
                    }), "_" to 3), 8, _uA(
                        "offset-top",
                        "show"
                    ))
                } else {
                    _cC("v-if", true)
                }
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
