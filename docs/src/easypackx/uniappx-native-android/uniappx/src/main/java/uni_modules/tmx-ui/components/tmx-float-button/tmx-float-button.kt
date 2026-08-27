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
import io.dcloud.uniapp.extapi.`$off` as uni__off
import io.dcloud.uniapp.extapi.`$on` as uni__on
import io.dcloud.uniapp.extapi.createSelectorQuery as uni_createSelectorQuery
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
open class GenUniModulesTmxUiComponentsTmxFloatButtonTmxFloatButton : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var duration: Number by `$props`
    open var threshold: Number by `$props`
    open var thresholdTop: Number by `$props`
    open var thresholdBottom: Number by `$props`
    open var round: String by `$props`
    open var offset: UTSArray<Number> by `$props`
    open var bgColor: String by `$props`
    open var width: String by `$props`
    open var height: String by `$props`
    open var adsorption: Boolean by `$props`
    open var disabled: Boolean by `$props`
    open var zIndex: Number by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesTmxUiComponentsTmxFloatButtonTmxFloatButton) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesTmxUiComponentsTmxFloatButtonTmxFloatButton
            val _cache = __ins.renderCache
            fun emits(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val props = __props
            val id = ref<String>(("xFloatButtonId-" + getUid()) as String)
            val _x = ref(0)
            val _y = ref(0)
            val winHeight = ref(0)
            val winWidth = ref(0)
            val nowXy = ref(_uA<Number>(0, 0))
            val windtop = ref(0)
            val isMoveing = ref(false)
            val dateTime = ref(0)
            val diffX = ref(0)
            val _real_X = ref(0)
            val _real_Y = ref(0)
            val lastX = ref(0)
            val lastY = ref(0)
            val first = ref(true)
            val longtimeid = ref<Number>(22)
            val isReady = ref(false)
            val xFloatButton = ref<UniElement?>(null)
            val proxy = getCurrentInstance()?.proxy
            val _diffLen = computed(fun(): Number {
                var p = parseInt(props.width)
                if (props.width.lastIndexOf("rpx") > -1) {
                    p = rpx2px(p)
                }
                return Math.floor(p)
            }
            )
            val _round = computed(fun(): String {
                return checkIsCssUnit(props.round, xConfig.unit)
            }
            )
            val _width = computed(fun(): Number {
                var p = parseInt(props.width)
                if (props.width.lastIndexOf("rpx") > -1) {
                    p = rpx2px(p)
                }
                return Math.floor(p)
            }
            )
            val _height = computed(fun(): Number {
                var p = parseInt(props.height)
                if (props.height.lastIndexOf("rpx") > -1) {
                    p = rpx2px(p)
                }
                return Math.floor(p)
            }
            )
            val _bgColor = computed(fun(): Any {
                if (props.bgColor.indexOf("linear-gradient") > -1) {
                    return _uO("backgroundImage" to props.bgColor)
                }
                var color = if (props.bgColor == "") {
                    getDefaultColor(xConfig.color)
                } else {
                    getDefaultColor(props.bgColor)
                }
                return _uO("backgroundColor" to color)
            }
            )
            val _disabled = computed(fun(): Boolean {
                return props.disabled
            }
            )
            fun gen_onClick_fn() {
                emits("click")
            }
            val onClick = ::gen_onClick_fn
            fun gen_setProperty_fn(reassignedX: Number, reassignedY: Number) {
                var x = reassignedX
                var y = reassignedY
                var node = xFloatButton.value as UniElement
                node.style.setProperty("transition-duration", if (first.value) {
                    "0"
                } else {
                    props.duration.toString(10) + "ms"
                }
                )
                if (x == -1 || x == -4) {
                    x = winWidth.value - _width.value - props.threshold
                } else if (x == -2 || x == -3) {
                    x = props.threshold
                } else if (x == -5) {
                    x = (winWidth.value - _width.value) / 2
                }
                if (y == -1 || y == -2 || y == -5) {
                    y = winHeight.value - _height.value - props.thresholdBottom
                } else if (y == -3 || y == -4) {
                    y = props.thresholdTop
                }
                x = Math.max(props.threshold, Math.min(winWidth.value - _width.value - props.threshold, x))
                if (y > winHeight.value / 2) {
                    y = Math.max(props.thresholdBottom, Math.min(winHeight.value - _height.value - props.thresholdBottom, y))
                } else {
                    y = Math.max(props.thresholdTop, Math.min(winHeight.value - _height.value - props.thresholdTop, y))
                }
                node.style.setProperty("left", "" + x + "px")
                node.style.setProperty("top", "" + (y + windtop.value) + "px")
                nowXy.value = _uA(
                    x,
                    y
                )
                lastX.value = x
                lastY.value = y
                emits("change", nowXy.value)
                first.value = false
            }
            val setProperty = ::gen_setProperty_fn
            fun gen_eventTrasform_start_fn(evt: POSITION_TYPE_XY) {
                isMoveing.value = true
                diffX.value = 0
                dateTime.value = Date().getTime()
                var node = xFloatButton.value as Element
                var leftpos = parseInt(node.style.getPropertyValue("left")!! as String)
                var toppos = parseInt(node.style.getPropertyValue("top")!! as String)
                _x.value = evt.x - leftpos
                _y.value = evt.y - toppos
                _real_X.value = evt.x
                _real_Y.value = evt.y
                node.style.setProperty("transition-duration", "0ms")
                var realx = Math.floor(evt.x - _real_X.value)
                var realy = Math.floor(evt.y - _real_Y.value)
                clearTimeout(longtimeid.value)
                longtimeid.value = setTimeout(fun() {
                    emits("longpress")
                }
                , 500)
            }
            val eventTrasform_start = ::gen_eventTrasform_start_fn
            fun gen_eventTrasform_move_fn(evt: POSITION_TYPE_XY) {
                clearTimeout(longtimeid.value)
                var x = evt.x - _x.value
                var y = evt.y - _y.value
                var diff_x = evt.x - _real_X.value
                var diff_y = evt.y - _real_Y.value
                diffX.value = Math.max(Math.abs(diff_x), Math.abs(diff_y))
                var node = xFloatButton.value as Element
                var maxX = winWidth.value - _width.value
                var maxY = winHeight.value - _height.value + windtop.value
                x = Math.max(Math.min(maxX, x), 0)
                y = Math.max(Math.min(maxY, y), 0)
                node.style.setProperty("left", "" + x + "px")
                node.style.setProperty("top", "" + y + "px")
                nowXy.value = _uA(
                    x,
                    y
                )
                emits("change", _uA(
                    x,
                    y
                ))
            }
            val eventTrasform_move = ::gen_eventTrasform_move_fn
            fun gen_eventTrasform_end_fn(evt: POSITION_TYPE_XY) {
                isMoveing.value = false
                var node = xFloatButton.value as Element
                var x = evt.x - _x.value
                var y = evt.y - _y.value - windtop.value
                var maxX = winWidth.value - _width.value
                var maxY = winHeight.value - _height.value
                x = Math.max(Math.min(maxX, x), 0)
                y = Math.max(Math.min(maxY, y), 0)
                if (props.adsorption) {
                    y = Math.max(Math.min(maxY - props.threshold, y), props.threshold)
                    if (x >= (winWidth.value - _width.value) / 2) {
                        x = winWidth.value - _width.value - props.threshold
                    } else {
                        x = props.threshold
                    }
                    nowXy.value = _uA(
                        x,
                        y
                    )
                    setProperty(x, y)
                }
                var diffTiff = Date().getTime() - dateTime.value
                var realx = Math.floor(evt.x - _real_X.value)
                var realy = Math.floor(evt.y - _real_Y.value)
                if (realx == 0 && realy == 0 && realx == realy) {
                    if (diffTiff > 5 && diffTiff < 250) {
                        onClick()
                    }
                }
            }
            val eventTrasform_end = ::gen_eventTrasform_end_fn
            fun gen_mStart_fn(evt: TouchEvent) {
                if (_disabled.value) {
                    return
                }
                var x = evt.changedTouches[0].clientX
                var y = evt.changedTouches[0].clientY
                _real_X.value = x
                _real_Y.value = x
                eventTrasform_start(POSITION_TYPE_XY(x = x, y = y))
            }
            val mStart = ::gen_mStart_fn
            fun gen_mMove_fn(evt: TouchEvent) {
                if (_disabled.value) {
                    return
                }
                var x = evt.changedTouches[0].clientX
                var y = evt.changedTouches[0].clientY
                eventTrasform_move(POSITION_TYPE_XY(x = x, y = y))
            }
            val mMove = ::gen_mMove_fn
            fun gen_mEnd_fn(evt: TouchEvent) {
                if (_disabled.value) {
                    return
                }
                var x = evt.changedTouches[0].clientX
                var y = evt.changedTouches[0].clientY
                eventTrasform_end(POSITION_TYPE_XY(x = x, y = y))
            }
            val mEnd = ::gen_mEnd_fn
            fun gen_getNodes_fn(): UTSPromise<Boolean> {
                return UTSPromise(fun(res, rej){
                    uni_createSelectorQuery().`in`(proxy).select(".xFloatButtonBox").boundingClientRect().exec(fun(nodes){
                        var node = nodes[0] as NodeInfo
                        winWidth.value = node.width!!
                        winHeight.value = node.height!! - windtop.value
                        res(true)
                    }
                    )
                }
                )
            }
            val getNodes = ::gen_getNodes_fn
            fun gen_onresizeOffsetXy_fn() {
                getNodes().then(fun(){
                    setProperty(props.offset[0], props.offset[1])
                }
                )
            }
            val onresizeOffsetXy = ::gen_onresizeOffsetXy_fn
            watch(fun(): UTSArray<Number> {
                return props.offset
            }
            , fun(newValue: UTSArray<Number>){
                if (newValue.length == 2 && nowXy.value.join("") != newValue.join("")) {
                    setProperty(newValue[0], newValue[1])
                }
            }
            )
            onMounted(fun(){
                isReady.value = false
                var sys = uni_getWindowInfo()
                winWidth.value = sys.windowWidth
                winHeight.value = sys.windowHeight + 44
                getNodes().then(fun(){
                    setProperty(props.offset[0], props.offset[1])
                    isReady.value = true
                }
                )
                uni__on("onResize", onresizeOffsetXy)
            }
            )
            onBeforeUnmount(fun(){
                uni__off("onResize", onresizeOffsetXy)
            }
            )
            return fun(): Any? {
                return _cE("view", null, _uA(
                    _cE("view", _uM("id" to id.value, "onTouchstart" to mStart, "onTouchmove" to withModifiers(mMove, _uA(
                        "stop"
                    )), "onTouchend" to mEnd, "ref_key" to "xFloatButton", "ref" to xFloatButton, "style" to _nS(_uA(
                        _uM("width" to (_width.value + "px"), "height" to (_height.value + "px"), "borderRadius" to _round.value, "zIndex" to (_ctx.zIndex + 1), "opacity" to if (isReady.value) {
                            "1"
                        } else {
                            "0"
                        }
                        ),
                        _bgColor.value
                    )), "class" to "xFloatButton"), _uA(
                        renderSlot(_ctx.`$slots`, "default")
                    ), 44, _uA(
                        "id"
                    )),
                    _cE("view", _uM("class" to "xFloatButtonBox", "style" to _nS(_uM("zIndex" to _ctx.zIndex))), null, 4)
                ))
            }
        }
        var name = "xFloatButton"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("xFloatButtonBox" to _pS(_uM("pointerEvents" to "none", "width" to "100%", "height" to "100%", "backgroundColor" to "rgba(0,0,0,0)", "opacity" to 0, "position" to "fixed", "left" to 0, "top" to 0, "transform" to "translate(-100%, -100%)")), "xFloatButton" to _pS(_uM("transitionDuration" to "0ms", "transitionProperty" to "left,right,top,bottom", "transitionTimingFunction" to "cubic-bezier(0,0.55,0.45,1)", "top" to 0, "left" to 0, "position" to "fixed")), "@TRANSITION" to _uM("xFloatButton" to _uM("duration" to "0ms", "property" to "left,right,top,bottom", "timingFunction" to "cubic-bezier(0,0.55,0.45,1)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("click" to null, "longpress" to null, "change" to null, "update:offset" to null)
        var props = _nP(_uM("duration" to _uM("type" to "Number", "required" to true, "default" to 650), "threshold" to _uM("type" to "Number", "required" to true, "default" to 12), "thresholdTop" to _uM("type" to "Number", "required" to true, "default" to 0), "thresholdBottom" to _uM("type" to "Number", "required" to true, "default" to 12), "round" to _uM("type" to "String", "required" to true, "default" to "64"), "offset" to _uM("type" to "Array", "required" to true, "default" to fun(): UTSArray<Number> {
            return _uA<Number>(-1, -1)
        }
        ), "bgColor" to _uM("type" to "String", "required" to true, "default" to ""), "width" to _uM("type" to "String", "required" to true, "default" to "50px"), "height" to _uM("type" to "String", "required" to true, "default" to "50px"), "adsorption" to _uM("type" to "Boolean", "required" to true, "default" to true), "disabled" to _uM("type" to "Boolean", "required" to true, "default" to false), "zIndex" to _uM("type" to "Number", "required" to true, "default" to 87)))
        var propsNeedCastKeys = _uA(
            "duration",
            "threshold",
            "thresholdTop",
            "thresholdBottom",
            "round",
            "offset",
            "bgColor",
            "width",
            "height",
            "adsorption",
            "disabled",
            "zIndex"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
