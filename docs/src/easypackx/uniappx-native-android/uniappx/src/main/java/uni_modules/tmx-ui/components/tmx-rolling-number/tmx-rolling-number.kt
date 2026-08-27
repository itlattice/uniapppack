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
open class GenUniModulesTmxUiComponentsTmxRollingNumberTmxRollingNumber : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var fontSize: String by `$props`
    open var fontColor: String by `$props`
    open var fontStyle: String by `$props`
    open var darkFontColor: String by `$props`
    open var startVal: Number by `$props`
    open var endVal: Number by `$props`
    open var duration: Number by `$props`
    open var easing: String by `$props`
    open var useGrouping: Boolean by `$props`
    open var decimals: Number by `$props`
    open var prefix: String by `$props`
    open var suffix: String by `$props`
    open var enableAnimation: Boolean by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    open var play: () -> Unit
        get() {
            return unref(this.`$exposed`["play"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "play", value)
        }
    open var pause: () -> Unit
        get() {
            return unref(this.`$exposed`["pause"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "pause", value)
        }
    open var resume: () -> Unit
        get() {
            return unref(this.`$exposed`["resume"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "resume", value)
        }
    open var stop: () -> Unit
        get() {
            return unref(this.`$exposed`["stop"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "stop", value)
        }
    open var reset: () -> Unit
        get() {
            return unref(this.`$exposed`["reset"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "reset", value)
        }
    open var isAnimating: () -> Boolean
        get() {
            return unref(this.`$exposed`["isAnimating"]) as () -> Boolean
        }
        set(value) {
            setRefValue(this.`$exposed`, "isAnimating", value)
        }
    open var getValue: () -> Number
        get() {
            return unref(this.`$exposed`["getValue"]) as () -> Number
        }
        set(value) {
            setRefValue(this.`$exposed`, "getValue", value)
        }
    open var getFormattedValue: () -> String
        get() {
            return unref(this.`$exposed`["getFormattedValue"]) as () -> String
        }
        set(value) {
            setRefValue(this.`$exposed`, "getFormattedValue", value)
        }
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesTmxUiComponentsTmxRollingNumberTmxRollingNumber, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesTmxUiComponentsTmxRollingNumberTmxRollingNumber
            val _cache = __ins.renderCache
            val props = __props
            fun emits(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val ani = ref<xAnimate?>(null)
            val endValue = ref<Number>(0)
            val oldValue = ref<Number>(0)
            val targetValue = ref<String>("0")
            val isAnimating = ref<Boolean>(false)
            val _fontSize = computed(fun(): String {
                var fontSize = checkIsCssUnit(props.fontSize, xConfig.unit)
                if (xConfig.fontScale == 1) {
                    return fontSize
                }
                var sizeNumber = parseInt(fontSize)
                if (isNaN(sizeNumber)) {
                    sizeNumber = 32
                }
                return (sizeNumber * xConfig.fontScale).toString(10) + getUnit(fontSize)
            }
            )
            val _fontColor = computed(fun(): String {
                if (xConfig.dark == "dark") {
                    if (props.darkFontColor != "") {
                        return getDefaultColor(props.darkFontColor)
                    }
                    return "#FFFFFF"
                }
                return getDefaultColor(props.fontColor)
            }
            )
            val _dmit = computed(fun(): Number {
                if (props.decimals >= 0) {
                    return props.decimals
                }
                var str = props.endVal.toString(10)
                var pasa = str.indexOf(".")
                var endStrNum: Number = 0
                if (pasa > -1) {
                    endStrNum = str.substring(pasa + 1).length
                }
                return endStrNum
            }
            )
            val formatNumber = fun(value: Number): String {
                var formatted = value.toFixed(_dmit.value)
                if (props.useGrouping) {
                    val parts = formatted.split(".")
                    parts[0] = parts[0].replace(UTSRegExp("\\B(?=(\\d{3})+(?!\\d))", "g"), ",")
                    formatted = parts.join(".")
                }
                return props.prefix + formatted + props.suffix
            }
            val formattedValue = computed(fun(): String {
                return formatNumber(parseFloat(targetValue.value))
            }
            )
            val _fontStyle = computed(fun(): String {
                return props.fontStyle
            }
            )
            fun gen_createAnimation_fn(): xAnimate {
                return xAnimate(null, XANIMATE_OPIONS(duration = props.duration, timingFunction = props.easing, frame = fun(propress: Number) {
                    val currentValue = propress * (endValue.value - oldValue.value) + oldValue.value
                    targetValue.value = currentValue.toFixed(_dmit.value)
                    emits("valueChange", parseFloat(targetValue.value))
                }
                , start = fun() {
                    emits("animationStart")
                }
                , complete = fun() {
                    targetValue.value = endValue.value.toFixed(_dmit.value)
                    isAnimating.value = false
                    emits("animationComplete")
                    emits("valueChange", endValue.value)
                }
                ))
            }
            val createAnimation = ::gen_createAnimation_fn
            fun gen_play_fn(): Unit {
                if (!props.enableAnimation) {
                    targetValue.value = endValue.value.toFixed(_dmit.value)
                    emits("valueChange", endValue.value)
                    return
                }
                if (isAnimating.value) {
                    ani.value?.stop()
                }
                ani.value = createAnimation()
                isAnimating.value = true
                ani.value!!.stop()
                ani.value!!.attr("run", "0", "100")
                ani.value!!.setDurations(props.duration)
                ani.value!!.play()
            }
            val play = ::gen_play_fn
            fun gen_pause_fn(): Unit {
                ani.value?.pause()
                isAnimating.value = false
                emits("animationPause")
            }
            val pause = ::gen_pause_fn
            fun gen_resume_fn(): Unit {
                ani.value?.play()
                isAnimating.value = true
                emits("animationResume")
            }
            val resume = ::gen_resume_fn
            fun gen_stop_fn(): Unit {
                ani.value?.stop()
                isAnimating.value = false
                targetValue.value = endValue.value.toFixed(_dmit.value)
                emits("animationStop")
                emits("valueChange", endValue.value)
            }
            val stop = ::gen_stop_fn
            fun gen_reset_fn(): Unit {
                stop()
                oldValue.value = props.startVal
                endValue.value = props.startVal
                targetValue.value = props.startVal.toFixed(_dmit.value)
                emits("valueChange", props.startVal)
            }
            val reset = ::gen_reset_fn
            watch(fun(): Number {
                return props.endVal
            }
            , fun(newValue: Number, oldValue_s: Number): Unit {
                targetValue.value = "" + oldValue_s
                endValue.value = newValue
                oldValue.value = oldValue_s
                play()
            }
            )
            watch(fun(): Boolean {
                return props.enableAnimation
            }
            , fun(newVal: Boolean): Unit {
                if (!newVal && isAnimating.value) {
                    stop()
                }
            }
            )
            onMounted(fun(){
                oldValue.value = props.startVal
                endValue.value = props.endVal
                targetValue.value = props.startVal.toFixed(_dmit.value)
                if (props.startVal !== props.endVal && props.enableAnimation) {
                    play()
                } else if (!props.enableAnimation) {
                    targetValue.value = props.endVal.toFixed(_dmit.value)
                }
            }
            )
            onBeforeUnmount(fun(){
                ani.value?.stop()
                ani.value = null
            }
            )
            __expose(_uM("play" to fun(){
                return play()
            }
            , "pause" to fun(){
                return pause()
            }
            , "resume" to fun(){
                return resume()
            }
            , "stop" to fun(){
                return stop()
            }
            , "reset" to fun(){
                return reset()
            }
            , "isAnimating" to fun(): Boolean {
                return isAnimating.value
            }
            , "getValue" to fun(): Number {
                return parseFloat(targetValue.value)
            }
            , "getFormattedValue" to fun(): String {
                return formattedValue.value
            }
            ))
            return fun(): Any? {
                return _cE("view", _uM("class" to "xRolling"), _uA(
                    renderSlot(_ctx.`$slots`, "default", GenUniModulesTmxUiComponentsTmxRollingNumberTmxRollingNumberSlotDataDefault(value = targetValue.value, formattedValue = formattedValue.value), fun(): UTSArray<Any> {
                        return _uA(
                            _cE("text", _uM("style" to _nS(_uA(
                                _uM("fontSize" to _fontSize.value, "color" to _fontColor.value),
                                _fontStyle.value
                            ))), _tD(formattedValue.value), 5)
                        )
                    }
                    )
                ))
            }
        }
        var name = "xRollingNumber"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("xRolling" to _pS(_uM("display" to "flex", "flexDirection" to "row", "flexWrap" to "nowrap", "justifyContent" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("animationStart" to null, "animationComplete" to null, "animationPause" to null, "animationResume" to null, "animationStop" to null, "valueChange" to null)
        var props = _nP(_uM("fontSize" to _uM("type" to "String", "required" to true, "default" to "32"), "fontColor" to _uM("type" to "String", "required" to true, "default" to "black"), "fontStyle" to _uM("type" to "String", "required" to true, "default" to ""), "darkFontColor" to _uM("type" to "String", "required" to true, "default" to ""), "startVal" to _uM("type" to "Number", "required" to true, "default" to 0), "endVal" to _uM("type" to "Number", "required" to true, "default" to 0), "duration" to _uM("type" to "Number", "required" to true, "default" to 400), "easing" to _uM("type" to "String", "required" to true, "default" to "easeIn"), "useGrouping" to _uM("type" to "Boolean", "required" to true, "default" to false), "decimals" to _uM("type" to "Number", "required" to true, "default" to -1), "prefix" to _uM("type" to "String", "required" to true, "default" to ""), "suffix" to _uM("type" to "String", "required" to true, "default" to ""), "enableAnimation" to _uM("type" to "Boolean", "required" to true, "default" to true)))
        var propsNeedCastKeys = _uA(
            "fontSize",
            "fontColor",
            "fontStyle",
            "darkFontColor",
            "startVal",
            "endVal",
            "duration",
            "easing",
            "useGrouping",
            "decimals",
            "prefix",
            "suffix",
            "enableAnimation"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
