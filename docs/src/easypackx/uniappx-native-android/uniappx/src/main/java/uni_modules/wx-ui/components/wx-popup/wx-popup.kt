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
open class GenUniModulesWxUiComponentsWxPopupWxPopup : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_wx_icon = resolveEasyComponent("wx-icon", GenUniModulesWxUiComponentsWxIconWxIconClass)
        val _component_wx_transition = resolveEasyComponent("wx-transition", GenUniModulesWxUiComponentsWxTransitionWxTransitionClass)
        return if (isTrue(_ctx.showPopup)) {
            _cE("view", _uM("key" to 0, "class" to _nC(_uA(
                "wx-popup wx-fixed",
                _uA(
                    _ctx.mode,
                    if (_ctx.showTrans) {
                        "show"
                    } else {
                        "hidden"
                    }
                )
            )), "style" to _nS(_uA(
                _ctx.popupStyle,
                _ctx.overlayStyle
            )), "onClick" to withModifiers(_ctx.clickMask, _uA(
                "stop"
            ))), _uA(
                _cV(_component_wx_transition, _uM("onClick" to withModifiers(fun(){}, _uA(
                    "stop"
                )), "class" to "wx-popup-conent", "show" to _ctx.showTrans, "mode" to _ctx.transitionMode, "duration" to _ctx.duration, "style" to _nS(_uA(
                    _ctx.transitionFixedStyle,
                    _ctx.transitionStyle,
                    _ctx.customStyle
                ))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        if (isTrue(_ctx.closeable)) {
                            _cV(_component_wx_icon, _uM("key" to 0, "name" to "close", "class" to "wx-popup-close wx-absolute", "style" to _nS(_ctx.closeIconStyle), "size" to _ctx.closeIconSize, "onClick" to _ctx.close), null, 8, _uA(
                                "style",
                                "size",
                                "onClick"
                            ))
                        } else {
                            _cC("v-if", true)
                        },
                        renderSlot(_ctx.`$slots`, "default")
                    )
                }), "_" to 3), 8, _uA(
                    "onClick",
                    "show",
                    "mode",
                    "duration",
                    "style"
                ))
            ), 14, _uA(
                "onClick"
            ))
        } else {
            _cC("v-if", true)
        }
    }
    open var mode: String by `$props`
    open var duration: Number by `$props`
    open var zIndex: Number by `$props`
    open var bgColor: String by `$props`
    open var closeOnClickOverlay: Boolean by `$props`
    open var overlayOpacity: Number by `$props`
    open var overlayStyle: Any by `$props`
    open var customStyle: Any by `$props`
    open var round: Number by `$props`
    open var zoom: Boolean by `$props`
    open var closeable: Boolean by `$props`
    open var closeIconSize: Number by `$props`
    open var closeIconPos: String? by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    open var showPopup: Boolean by `$data`
    open var showTrans: Boolean by `$data`
    open var config: UTSJSONObject by `$data`
    open var transitionMode: String by `$data`
    open var closeTimer: Any by `$data`
    open var transitionFixedStyle: Any by `$data`
    open var transitionStyle: Any by `$data`
    open var popupStyle: Any by `$data`
    open var closeIconStyle: Any by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml, "showPopup" to false as Boolean, "showTrans" to false as Boolean, "config" to _uO("top" to "top", "bottom" to "bottom", "center" to "center", "left" to "left", "right" to "right", "message" to "top", "dialog" to "center", "share" to "bottom"), "transitionMode" to "", "closeTimer" to 0 as Any, "transitionFixedStyle" to computed<Any>(fun(): Any {
            var style: UTSJSONObject = _uO("backgroundColor" to this.bgColor, "zIndex" to (this.zIndex + 1))
            when (this.mode) {
                "top" -> 
                    {
                        style["borderBottomLeftRadius"] = this.round + "px"
                        style["borderBottomRightRadius"] = this.round + "px"
                    }
                "bottom" -> 
                    {
                        style["borderTopLeftRadius"] = this.round + "px"
                        style["borderTopRightRadius"] = this.round + "px"
                    }
                "left" -> 
                    {
                        style["borderTopRightRadius"] = this.round + "px"
                        style["borderBottomRightRadius"] = this.round + "px"
                    }
                "right" -> 
                    {
                        style["borderTopLeftRadius"] = this.round + "px"
                        style["borderBottomLeftRadius"] = this.round + "px"
                    }
                "center" -> 
                    style["borderRadius"] = this.round + "px"
            }
            return style
        }
        ), "transitionStyle" to computed<Any>(fun(): Any {
            when (this.mode) {
                "top" -> 
                    {
                        this.transitionMode = "slide-down"
                        return _uO("position" to "fixed", "left" to 0, "right" to 0)
                    }
                "bottom" -> 
                    {
                        this.transitionMode = "slide-up"
                        return _uO("position" to "fixed", "left" to 0, "right" to 0, "bottom" to 0)
                    }
                "center" -> 
                    {
                        this.transitionMode = if (this.zoom) {
                            "fade-zoom"
                        } else {
                            "fade"
                        }
                        return _uO("position" to "realtive")
                    }
                "left" -> 
                    {
                        this.transitionMode = "slide-left"
                        return _uO("position" to "fixed", "left" to 0, "bottom" to 0, "top" to 0, "display" to "flex", "flexDirection" to "column")
                    }
                "right" -> 
                    {
                        this.transitionMode = "slide-right"
                        return _uO("position" to "fixed", "bottom" to 0, "right" to 0, "top" to 0, "display" to "flex", "flexDirection" to "column")
                    }
                else -> 
                    return ""
            }
        }
        ), "popupStyle" to computed<Any>(fun(): Any {
            return _uO("backgroundColor" to ("rgba(0, 0, 0, " + this.overlayOpacity + ")"), "zIndex" to this.zIndex, "transitionDuration" to ("" + this.duration + "ms"))
        }
        ), "closeIconStyle" to computed<Any>(fun(): Any {
            var style: UTSJSONObject = _uO("zIndex" to this.zIndex)
            var posSize = "12px"
            when (this.closeIconPos) {
                "top-left" -> 
                    {
                        style["top"] = posSize
                        style["left"] = posSize
                    }
                "top-right" -> 
                    {
                        style["top"] = posSize
                        style["right"] = posSize
                    }
                "bottom-left" -> 
                    {
                        style["bottom"] = posSize
                        style["left"] = posSize
                    }
                "bottom-right" -> 
                    {
                        style["bottom"] = posSize
                        style["right"] = posSize
                    }
            }
            return style
        }
        ))
    }
    open var open = ::gen_open_fn
    open fun gen_open_fn() {
        console.log("打开窗体")
        if (this.closeTimer != 0) {
            clearTimeout(this.closeTimer as Number)
        }
        this.showPopup = true
        this.`$nextTick`(fun(){
            this.showTrans = true
        }
        )
        this.change()
    }
    open var clickMask = ::gen_clickMask_fn
    open fun gen_clickMask_fn() {
        if (this.closeOnClickOverlay == true) {
            this.`$emit`("maskClick")
            this.close()
        }
    }
    open var close = ::gen_close_fn
    open fun gen_close_fn() {
        this.showTrans = false
        this.closeTimer = setTimeout(fun(){
            this.showPopup = false
        }
        , this.duration)
        this.change()
    }
    open var change = ::gen_change_fn
    open fun gen_change_fn() {
        this.`$emit`("change", WxPopupChangeEvent(show = this.showTrans, type = this.mode))
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("wx-popup" to _uM("" to _uM("width" to "750rpx", "transitionProperty" to "opacity", "left" to 0, "right" to 0, "top" to 0, "bottom" to 0, "position" to "fixed"), ".show" to _uM("opacity" to 1), ".hidden" to _uM("opacity" to 0), ".center" to _uM("display" to "flex", "justifyContent" to "center", "alignItems" to "center")), "@TRANSITION" to _uM("wx-popup" to _uM("property" to "opacity")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("change" to null, "maskClick" to null)
        var props = _nP(_uM("mode" to _uM("type" to "String", "default" to "center", "validator" to fun(value: String): Boolean {
            return _uA(
                "top",
                "center",
                "bottom",
                "left",
                "right"
            ).includes(value)
        }
        ), "duration" to _uM("type" to "Number", "default" to 300), "zIndex" to _uM("type" to "Number", "default" to 999), "bgColor" to _uM("type" to "String", "default" to "#ffffff"), "closeOnClickOverlay" to _uM("type" to "Boolean", "default" to true), "overlayOpacity" to _uM("type" to "Number", "default" to 0.4), "overlayStyle" to _uM("default" to _uO()), "customStyle" to _uM("default" to _uO()), "round" to _uM("type" to "Number", "default" to 0), "zoom" to _uM("type" to "Boolean", "default" to true), "closeable" to _uM("type" to "Boolean", "default" to false), "closeIconSize" to _uM("type" to "Number", "default" to 24), "closeIconPos" to _uM("type" to "String", "validator" to fun(value: String): Boolean {
            return _uA(
                "top-left",
                "top-right",
                "bottom-left",
                "bottom-right"
            ).includes(value)
        }
        )))
        var propsNeedCastKeys = _uA(
            "mode",
            "duration",
            "zIndex",
            "bgColor",
            "closeOnClickOverlay",
            "overlayOpacity",
            "overlayStyle",
            "customStyle",
            "round",
            "zoom",
            "closeable",
            "closeIconSize"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
