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
open class GenUniModulesWxUiComponentsWxTransitionWxTransition : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            if (this.show && this.isFirstLoad) {
                this.isFirstLoad = false
                this.display = false
                this.enter()
            }
        }
        , __ins)
        this.`$watch`(fun(): Any? {
            return this.show
        }
        , fun() {
            if (this.timer != 0) {
                clearTimeout(this.timer as Number)
            }
            this.`$nextTick`(fun(){
                if (this.show) {
                    this.display = false
                    this.enter()
                } else {
                    this.leave()
                }
            }
            )
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        return if (isTrue(_ctx.display)) {
            _cE("view", _uM("key" to 0, "class" to _nC(_uA(
                "wx-transition",
                _ctx.className
            )), "style" to _nS(_ctx.style)), _uA(
                renderSlot(_ctx.`$slots`, "default")
            ), 6)
        } else {
            _cC("v-if", true)
        }
    }
    open var show: Boolean by `$props`
    open var mode: String by `$props`
    open var duration: Number by `$props`
    open var timingFunction: String by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    open var display: Boolean by `$data`
    open var className: String by `$data`
    open var timer: Any by `$data`
    open var isFirstLoad: Boolean by `$data`
    open var style: String by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml, "display" to false as Boolean, "className" to "", "timer" to 0 as Any, "isFirstLoad" to true, "style" to computed<String>(fun(): String {
            var styles = _uA<String>()
            styles.push("transition-duration: " + this.duration + "ms")
            styles.push("transition-timing-function: " + this.timingFunction)
            return styles.join(";")
        }
        ))
    }
    open var setClasss = ::gen_setClasss_fn
    open fun gen_setClasss_fn(key: String) {
        var mode = "wx-transition__" + this.mode
        this.className = (_uO("enter" to ("" + mode + "-enter " + mode + "-enter-active"), "enter-to" to ("" + mode + "-enter-to " + mode + "-enter-active"), "leave" to ("" + mode + "-leave " + mode + "-leave-active"), "leave-to" to ("" + mode + "-leave-to " + mode + "-leave-active")))[key] as String
    }
    open var enter = ::gen_enter_fn
    open fun gen_enter_fn() {
        this.`$emit`("before-enter")
        this.setClasss("enter")
        this.`$nextTick`(fun(){
            this.display = true
            setTimeout(fun(){
                this.setClasss("enter")
                this.`$emit`("enter")
                this.setClasss("enter-to")
                this.`$nextTick`(fun(){
                    this.`$emit`("after-enter")
                }
                )
            }
            , 20)
        }
        )
    }
    open var leave = ::gen_leave_fn
    open fun gen_leave_fn() {
        this.`$emit`("before-leave")
        this.setClasss("leave")
        this.`$nextTick`(fun(){
            this.`$emit`("leave")
            this.setClasss("leave-to")
            this.timer = setTimeout(fun(){
                this.display = false
                this.`$emit`("after-leave")
            }
            , this.duration)
        }
        )
    }
    companion object {
        var name = "wx-transition"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("wx-transition__fade-enter-active" to _pS(_uM("transitionProperty" to "opacity")), "wx-transition__fade-leave-active" to _pS(_uM("transitionProperty" to "opacity")), "wx-transition__fade-enter" to _pS(_uM("opacity" to 0)), "wx-transition__fade-leave-to" to _pS(_uM("opacity" to 0)), "wx-transition__fade-enter-to" to _pS(_uM("opacity" to 1)), "wx-transition__fade-zoom-enter" to _pS(_uM("transform" to "scale(0)", "opacity" to 0)), "wx-transition__fade-zoom-leave-to" to _pS(_uM("transform" to "scale(0)", "opacity" to 0)), "wx-transition__fade-zoom-enter-active" to _pS(_uM("transitionProperty" to "transform,opacity")), "wx-transition__fade-zoom-leave-active" to _pS(_uM("transitionProperty" to "transform,opacity")), "wx-transition__fade-down-enter-active" to _pS(_uM("transitionProperty" to "opacity,transform")), "wx-transition__fade-down-leave-active" to _pS(_uM("transitionProperty" to "opacity,transform")), "wx-transition__fade-left-enter-active" to _pS(_uM("transitionProperty" to "opacity,transform")), "wx-transition__fade-left-leave-active" to _pS(_uM("transitionProperty" to "opacity,transform")), "wx-transition__fade-right-enter-active" to _pS(_uM("transitionProperty" to "opacity,transform")), "wx-transition__fade-right-leave-active" to _pS(_uM("transitionProperty" to "opacity,transform")), "wx-transition__fade-up-enter-active" to _pS(_uM("transitionProperty" to "opacity,transform")), "wx-transition__fade-up-leave-active" to _pS(_uM("transitionProperty" to "opacity,transform")), "wx-transition__fade-up-enter" to _pS(_uM("transform" to "translate(0, 100%)", "opacity" to 0)), "wx-transition__fade-up-leave-to" to _pS(_uM("transform" to "translate(0, 100%)", "opacity" to 0)), "wx-transition__fade-down-enter" to _pS(_uM("transform" to "translate(0, -100%)", "opacity" to 0)), "wx-transition__fade-down-leave-to" to _pS(_uM("transform" to "translate(0, -100%)", "opacity" to 0)), "wx-transition__fade-left-enter" to _pS(_uM("transform" to "translate(-100%, 0)", "opacity" to 0)), "wx-transition__fade-left-leave-to" to _pS(_uM("transform" to "translate(-100%, 0)", "opacity" to 0)), "wx-transition__fade-right-enter" to _pS(_uM("transform" to "translate(100%, 0)", "opacity" to 0)), "wx-transition__fade-right-leave-to" to _pS(_uM("transform" to "translate(100%, 0)", "opacity" to 0)), "wx-transition__slide-down-enter-active" to _pS(_uM("transitionProperty" to "transform")), "wx-transition__slide-down-leave-active" to _pS(_uM("transitionProperty" to "transform")), "wx-transition__slide-left-enter-active" to _pS(_uM("transitionProperty" to "transform")), "wx-transition__slide-left-leave-active" to _pS(_uM("transitionProperty" to "transform")), "wx-transition__slide-right-enter-active" to _pS(_uM("transitionProperty" to "transform")), "wx-transition__slide-right-leave-active" to _pS(_uM("transitionProperty" to "transform")), "wx-transition__slide-up-enter-active" to _pS(_uM("transitionProperty" to "transform")), "wx-transition__slide-up-leave-active" to _pS(_uM("transitionProperty" to "transform")), "wx-transition__slide-up-enter" to _pS(_uM("transform" to "translate(0, 100%)")), "wx-transition__slide-up-leave-to" to _pS(_uM("transform" to "translate(0, 100%)")), "wx-transition__slide-down-enter" to _pS(_uM("transform" to "translate(0, -100%)")), "wx-transition__slide-down-leave-to" to _pS(_uM("transform" to "translate(0, -100%)")), "wx-transition__slide-left-enter" to _pS(_uM("transform" to "translate(-100%, 0)")), "wx-transition__slide-left-leave-to" to _pS(_uM("transform" to "translate(-100%, 0)")), "wx-transition__slide-right-enter" to _pS(_uM("transform" to "translate(100%, 0)")), "wx-transition__slide-right-leave-to" to _pS(_uM("transform" to "translate(100%, 0)")), "wx-transition__zoom-enter-active" to _pS(_uM("transitionProperty" to "transform")), "wx-transition__zoom-leave-active" to _pS(_uM("transitionProperty" to "transform")), "wx-transition__zoom-enter" to _pS(_uM("transform" to "scale(0)")), "wx-transition__zoom-leave-to" to _pS(_uM("transform" to "scale(0)")), "wx-transition__fade-up-enter-to" to _pS(_uM("transform" to "translate(0, 0%)", "opacity" to 1)), "wx-transition__fade-down-enter-to" to _pS(_uM("transform" to "translate(0, 0%)", "opacity" to 1)), "wx-transition__slide-up-enter-to" to _pS(_uM("transform" to "translate(0, 0%)", "opacity" to 1)), "wx-transition__slide-down-enter-to" to _pS(_uM("transform" to "translate(0, 0%)", "opacity" to 1)), "wx-transition__fade-left-enter-to" to _pS(_uM("transform" to "translate(0%, 0)", "opacity" to 1)), "wx-transition__fade-right-enter-to" to _pS(_uM("transform" to "translate(0%, 0)", "opacity" to 1)), "wx-transition__slide-left-enter-to" to _pS(_uM("transform" to "translate(0%, 0)", "opacity" to 1)), "wx-transition__slide-right-enter-to" to _pS(_uM("transform" to "translate(0%, 0)", "opacity" to 1)), "wx-transition__fade-zoom-enter-to" to _pS(_uM("transform" to "scale(1)", "opacity" to 1)), "@TRANSITION" to _uM("wx-transition__fade-enter-active" to _uM("property" to "opacity"), "wx-transition__fade-leave-active" to _uM("property" to "opacity"), "wx-transition__fade-zoom-enter-active" to _uM("property" to "transform,opacity"), "wx-transition__fade-zoom-leave-active" to _uM("property" to "transform,opacity"), "wx-transition__fade-down-enter-active" to _uM("property" to "opacity,transform"), "wx-transition__fade-down-leave-active" to _uM("property" to "opacity,transform"), "wx-transition__fade-left-enter-active" to _uM("property" to "opacity,transform"), "wx-transition__fade-left-leave-active" to _uM("property" to "opacity,transform"), "wx-transition__fade-right-enter-active" to _uM("property" to "opacity,transform"), "wx-transition__fade-right-leave-active" to _uM("property" to "opacity,transform"), "wx-transition__fade-up-enter-active" to _uM("property" to "opacity,transform"), "wx-transition__fade-up-leave-active" to _uM("property" to "opacity,transform"), "wx-transition__slide-down-enter-active" to _uM("property" to "transform"), "wx-transition__slide-down-leave-active" to _uM("property" to "transform"), "wx-transition__slide-left-enter-active" to _uM("property" to "transform"), "wx-transition__slide-left-leave-active" to _uM("property" to "transform"), "wx-transition__slide-right-enter-active" to _uM("property" to "transform"), "wx-transition__slide-right-leave-active" to _uM("property" to "transform"), "wx-transition__slide-up-enter-active" to _uM("property" to "transform"), "wx-transition__slide-up-leave-active" to _uM("property" to "transform"), "wx-transition__zoom-enter-active" to _uM("property" to "transform"), "wx-transition__zoom-leave-active" to _uM("property" to "transform")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("before-enter" to null, "enter" to null, "after-enter" to null, "before-leave" to null, "leave" to null, "after-leave" to null)
        var props = _nP(_uM("show" to _uM("type" to "Boolean", "default" to false), "mode" to _uM("type" to "String", "default" to "fade"), "duration" to _uM("type" to "Number", "default" to 300), "timingFunction" to _uM("type" to "String", "default" to "ease-out")))
        var propsNeedCastKeys = _uA(
            "show",
            "mode",
            "duration",
            "timingFunction"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
