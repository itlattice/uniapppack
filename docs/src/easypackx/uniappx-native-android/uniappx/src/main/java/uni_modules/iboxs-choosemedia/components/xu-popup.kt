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
open class GenUniModulesIboxsChoosemediaComponentsXuPopup : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onCreated(fun() {
            var window = uni_getWindowInfo()
            this.top = window.statusBarHeight + 42
        }
        , __ins)
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        return if (isTrue(_ctx.isShow)) {
            _cE("view", _uM("key" to 0, "class" to _nC(_uA(
                "ux-popup",
                _uA(
                    _ctx.pos
                )
            )), "style" to _nS(_uM("top" to (_ctx.top + "px")))), _uA(
                if (isTrue(_ctx.isMask)) {
                    _cE("view", _uM("key" to 0, "class" to _nC(_uA(
                        "mask",
                        _uA(
                            _ctx.maskAnim
                        )
                    )), "style" to _nS(_uM("backgroundColor" to _ctx.maskBgColor)), "onClick" to _ctx.maskClick), null, 14, _uA(
                        "onClick"
                    ))
                } else {
                    _cC("v-if", true)
                },
                _cE("view", _uM("class" to _nC(_uA(
                    "ux-popup-wrapper",
                    _uA(
                        if (_ctx.isEndAnim) {
                            _ctx.posEndAnim
                        } else {
                            _ctx.posStartAnim
                        }
                    )
                ))), _uA(
                    renderSlot(_ctx.`$slots`, "default")
                ), 2)
            ), 6)
        } else {
            _cC("v-if", true)
        }
    }
    open var pos: String by `$props`
    open var isMask: Boolean by `$props`
    open var isMaskClick: Boolean by `$props`
    open var maskBgColor: String by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    open var timer: Number by `$data`
    open var anim: Boolean by `$data`
    open var isShow: Boolean by `$data`
    open var isEndAnim: Boolean by `$data`
    open var top: Number by `$data`
    open var posStartAnim: String by `$data`
    open var posEndAnim: String by `$data`
    open var maskAnim: String by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml, "timer" to -1, "anim" to false, "isShow" to false, "isEndAnim" to false, "top" to 0, "posStartAnim" to computed<String>(fun(): String {
            return if (this.anim) {
                "" + this.pos + "-leave"
            } else {
                "" + this.pos + "-active"
            }
        }
        ), "posEndAnim" to computed<String>(fun(): String {
            return if (this.anim) {
                "" + this.pos + "-active"
            } else {
                "" + this.pos + "-leave"
            }
        }
        ), "maskAnim" to computed<String>(fun(): String {
            return if (this.anim) {
                "show"
            } else {
                "hide"
            }
        }
        ))
    }
    open var open = ::gen_open_fn
    open fun gen_open_fn() {
        if (this.isShow) {
            this.close()
            return
        }
        if (this.timer != -1) {
            clearTimeout(this.timer)
            this.timer = -1
            this.anim = false
        }
        this.isShow = true
        this.timer = setTimeout(fun(){
            this.anim = true
        }
        , 30)
        this.`$emit`("setShow", true)
    }
    open var close = ::gen_close_fn
    open fun gen_close_fn() {
        if (this.timer != -1) {
            clearTimeout(this.timer)
            this.timer = -1
        }
        this.isEndAnim = true
        this.timer = setTimeout(fun(){
            this.anim = false
            this.isEndAnim = false
            this.isShow = false
        }
        , 300)
        this.`$emit`("setShow", false)
    }
    @get:JvmName("getMaskClick0")
    @set:JvmName("setMaskClick0")
    open var maskClick = ::gen_maskClick_fn
    open fun gen_maskClick_fn() {
        if (!this.isMaskClick) {
            return
        }
        this.`$emit`("mask-click")
        this.close()
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("ux-popup" to _uM("" to _uM("position" to "fixed", "left" to 0, "right" to 0, "bottom" to 0, "zIndex" to 9999, "backgroundColor" to "rgba(0,0,0,0)"), ".center" to _uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center"), ".bottom" to _uM("display" to "flex", "flexDirection" to "column", "justifyContent" to "flex-end"), ".left" to _uM("display" to "flex", "flexDirection" to "row"), ".right" to _uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "flex-end")), "mask" to _uM(".ux-popup " to _uM("position" to "absolute", "left" to 0, "top" to 0, "right" to 0, "bottom" to 0, "zIndex" to -1, "transitionProperty" to "opacity", "transitionDuration" to "0.2s"), ".ux-popup .show" to _uM("opacity" to 1), ".ux-popup .hide" to _uM("opacity" to 0)), "ux-popup-wrapper" to _uM("" to _uM("transitionProperty" to "transform", "transitionDuration" to "0.2s"), ".center-active" to _uM("transform" to "scale(0, 0)"), ".center-leave" to _uM("transform" to "scale(1, 1)"), ".top-active" to _uM("transform" to "translateY(-100%)"), ".top-leave" to _uM("transform" to "translateY(0)"), ".bottom-active" to _uM("transform" to "translateY(100%)"), ".bottom-leave" to _uM("transform" to "translateY(0)"), ".left-active" to _uM("transform" to "translateX(-100%)"), ".left-leave" to _uM("transform" to "translateX(0)"), ".right-active" to _uM("transform" to "translateX(100%)"), ".right-leave" to _uM("transform" to "translateX(0)")), "@TRANSITION" to _uM("mask" to _uM("property" to "opacity", "duration" to "0.2s"), "ux-popup-wrapper" to _uM("property" to "transform", "duration" to "0.2s")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("pos" to _uM("type" to "String", "default" to "top"), "isMask" to _uM("type" to "Boolean", "default" to true), "isMaskClick" to _uM("type" to "Boolean", "default" to true), "maskBgColor" to _uM("type" to "String", "default" to "rgba(0, 0, 0, .4)")))
        var propsNeedCastKeys = _uA(
            "pos",
            "isMask",
            "isMaskClick",
            "maskBgColor"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
