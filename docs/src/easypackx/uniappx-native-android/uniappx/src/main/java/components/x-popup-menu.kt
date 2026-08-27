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
import io.dcloud.uniapp.extapi.getElementById as uni_getElementById
open class GenComponentsXPopupMenu : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var x: Number by `$props`
    open var y: Number by `$props`
    open var height: Number by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    open var open: () -> Unit
        get() {
            return unref(this.`$exposed`["open"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "open", value)
        }
    open var close: () -> Unit
        get() {
            return unref(this.`$exposed`["close"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "close", value)
        }
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXPopupMenu, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXPopupMenu
            val _cache = __ins.renderCache
            val props = __props
            val show = ref(false)
            val isTransitionstyleOpacity = ref(true)
            val styleOpacity = ref<UniElement?>(null)
            val styleH = computed(fun(): UTSJSONObject {
                return _uO("height" to ((props.height - 10) + "px"))
            }
            )
            val popupStyle = computed(fun(): UTSJSONObject {
                return _uO("bottom" to (props.y.toString(10) + "px"), "left" to (props.x.toString(10) + "rpx"))
            }
            )
            watch(show, fun(){
                console.log("show", styleOpacity.value)
                styleOpacity.value?.style?.setProperty("opacity", if (isTransitionstyleOpacity.value) {
                    "1"
                } else {
                    "0"
                }
                )
                styleOpacity.value?.style?.setProperty("height", if (isTransitionstyleOpacity.value) {
                    props.height + "px"
                } else {
                    "10px"
                }
                )
                isTransitionstyleOpacity.value = !isTransitionstyleOpacity.value
            }
            )
            val open = fun(){
                show.value = !show.value
            }
            val close = fun(){
                show.value = false
            }
            onMounted(fun(){
                styleOpacity.value = uni_getElementById("styleOpacity")
            }
            )
            __expose(_uM("open" to open, "close" to close))
            return fun(): Any? {
                return _cE("view", _uM("id" to "styleOpacity", "class" to "position-absolute popupmenu trans", "style" to _nS(unref(popupStyle))), _uA(
                    _cE("view", _uM("class" to "bubble transheight", "style" to _nS(unref(styleH))), _uA(
                        renderSlot(_ctx.`$slots`, "default")
                    ), 4),
                    _cE("view", _uM("class" to "triangle"))
                ), 4)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("popupmenu" to _pS(_uM("zIndex" to 999, "position" to "relative", "width" to "305rpx", "height" to 10, "opacity" to 0)), "trans" to _pS(_uM("transitionDuration" to "0.15s")), "show" to _pS(_uM("display" to "flex")), "hide" to _pS(_uM("display" to "none")), "bubble" to _pS(_uM("zIndex" to 999, "position" to "absolute", "left" to "0rpx", "width" to "300rpx", "top" to 2, "borderTopLeftRadius" to 6, "borderTopRightRadius" to 6, "borderBottomRightRadius" to 6, "borderBottomLeftRadius" to 6, "backgroundColor" to "#ffffff", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#e6e6e6", "borderRightColor" to "#e6e6e6", "borderBottomColor" to "#e6e6e6", "borderLeftColor" to "#e6e6e6")), "triangle" to _pS(_uM("width" to 0, "height" to 0, "borderLeftWidth" to 10, "borderLeftStyle" to "solid", "borderLeftColor" to "rgba(0,0,0,0)", "borderRightWidth" to 10, "borderRightStyle" to "solid", "borderRightColor" to "rgba(0,0,0,0)", "borderTopWidth" to 10, "borderTopStyle" to "solid", "borderTopColor" to "#ffffff", "position" to "absolute", "zIndex" to 1, "bottom" to 0, "left" to "130rpx")), "@TRANSITION" to _uM("trans" to _uM("duration" to "0.15s")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("x" to _uM("type" to "Number", "default" to 225), "y" to _uM("type" to "Number", "default" to 500), "height" to _uM("type" to "Number", "default" to 300)))
        var propsNeedCastKeys = _uA(
            "x",
            "y",
            "height"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
