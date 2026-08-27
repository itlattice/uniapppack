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
import io.dcloud.uniapp.extapi.createSelectorQuery as uni_createSelectorQuery
import io.dcloud.uniapp.extapi.getElementById as uni_getElementById
open class GenUniModulesTmxUiComponentsTmxSwitchSliderTmxSwitchSlider : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            this.getNodeInfo()
        }
        , __ins)
        this.`$watch`(fun(): Any? {
            return this.status
        }
        , fun(newval: Boolean) {
            if (newval == this.opened) {
                return
            }
            if (this.status) {
                this.open()
            } else {
                this.close()
            }
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        return _cE("view", null, _uA(
            _cE("view", _uM("class" to "xSwitchSilder", "style" to _nS(_uM("minHeight" to _ctx._height))), _uA(
                _cE("view", _uM("onLongpress" to _ctx.longTimePress, "onTouchstart" to _ctx.mStart, "onTouchmove" to _ctx.mMove, "onTouchend" to _ctx.mEnd, "onTouchcancel" to _ctx.mEnd, "id" to _ctx.id, "ref" to "xSwitchSilder", "style" to _nS(_uA(
                    _uM("transition-timing-function" to _ctx._animationFun),
                    _ctx._custonmStyle
                )), "class" to "xSwitchSilderWrap", "onTransitionend" to _ctx.onAniEnd), _uA(
                    _cE("view", _uM("class" to _nC(_uA(
                        _uA(
                            if (_ctx.eventNone) {
                                "noEventBySwitchSlider"
                            } else {
                                ""
                            }
                        ),
                        ""
                    )), "style" to _nS(_uM("width" to "100%", "height" to "100%"))), _uA(
                        renderSlot(_ctx.`$slots`, "default")
                    ), 6)
                ), 44, _uA(
                    "onLongpress",
                    "onTouchstart",
                    "onTouchmove",
                    "onTouchend",
                    "onTouchcancel",
                    "id",
                    "onTransitionend"
                )),
                _cE("view", _uM("class" to "xSwitchSilderItemsWrap"), _uA(
                    _cE("view", _uM("ref" to "xSwitchSilderItems", "id" to _ctx.idMenuRight, "class" to "xSwitchSilderItems", "style" to _nS(_ctx._custonmMenuStyle)), _uA(
                        renderSlot(_ctx.`$slots`, "menu", GenUniModulesTmxUiComponentsTmxSwitchSliderTmxSwitchSliderSlotDataMenu(status = _ctx.opened))
                    ), 12, _uA(
                        "id"
                    ))
                ))
            ), 4),
            if (isTrue(_ctx._showBottomBorder)) {
                _cE("view", _uM("key" to 0, "style" to _nS(_uM("backgroundColor" to _ctx._borderColor, "height" to "1px"))), null, 4)
            } else {
                _cC("v-if", true)
            }
        ))
    }
    open var custonmStyle: String by `$props`
    open var custonmMenuStyle: String by `$props`
    open var width: String by `$props`
    open var height: String by `$props`
    open var disabled: Boolean by `$props`
    open var threshold: Number by `$props`
    open var duration: Number by `$props`
    open var status: Boolean by `$props`
    open var borderColor: String by `$props`
    open var borderDarkColor: String by `$props`
    open var eventNone: Boolean by `$props`
    open var showBottomBorder: Boolean by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    open var opened: Boolean by `$data`
    open var startX: Number by `$data`
    open var startY: Number by `$data`
    open var slideX: Number by `$data`
    open var _x: Number by `$data`
    open var _y: Number by `$data`
    open var _tempPop_x: Number by `$data`
    open var _tempPop_y: Number by `$data`
    open var dirs: String by `$data`
    open var id: Any? by `$data`
    open var idMenuRight: Any? by `$data`
    open var isMove: Boolean by `$data`
    open var dateTime: Number by `$data`
    open var diffX: Number by `$data`
    open var isSwiper: String by `$data`
    open var weblongTimePressId: Number by `$data`
    open var _height: String by `$data`
    open var _disabled: Boolean by `$data`
    open var _showBottomBorder: Boolean by `$data`
    open var _custonmStyle: String by `$data`
    open var _custonmMenuStyle: String by `$data`
    open var _borderColor: String by `$data`
    open var _animationFun: String by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml, "opened" to false, "startX" to 0, "startY" to 0, "slideX" to 0, "_x" to 0, "_y" to 0, "_tempPop_x" to 0, "_tempPop_y" to 0, "dirs" to "right", "id" to ("xSwitchSilder" + getUid()), "idMenuRight" to ("xSwitchSilderItems" + getUid()), "isMove" to false, "dateTime" to 0, "diffX" to 0, "isSwiper" to "none", "weblongTimePressId" to 5656, "_height" to computed<String>(fun(): String {
            return checkIsCssUnit(this.height, xConfig.unit)
        }
        ), "_disabled" to computed<Boolean>(fun(): Boolean {
            return this.disabled
        }
        ), "_showBottomBorder" to computed<Boolean>(fun(): Boolean {
            return this.showBottomBorder
        }
        ), "_custonmStyle" to computed<String>(fun(): String {
            return this.custonmStyle
        }
        ), "_custonmMenuStyle" to computed<String>(fun(): String {
            return this.custonmStyle
        }
        ), "_borderColor" to computed<String>(fun(): String {
            if (xConfig.dark == "dark" && this.borderDarkColor == "") {
                return getDefaultColor(xConfig.borderDarkColor)
            }
            if (xConfig.dark == "dark" && this.borderDarkColor != "") {
                return getDefaultColor(this.borderDarkColor)
            }
            return getDefaultColor(this.borderColor)
        }
        ), "_animationFun" to computed<String>(fun(): String {
            return xConfig.animationFun
        }
        ))
    }
    open var resetMoveData = ::gen_resetMoveData_fn
    open fun gen_resetMoveData_fn() {
        this.startX = 0
        this.startY = 0
        var ele = this.`$refs`["xSwitchSilder"] as UniElement
        ele.style.setProperty("transition-duration", "0ms")
    }
    open var getNodeInfo = ::gen_getNodeInfo_fn
    open fun gen_getNodeInfo_fn() {
        uni_createSelectorQuery().`in`(this).select(".xSwitchSilderItems").boundingClientRect().exec(fun(ret){
            var el = uni_getElementById(this.id as String) as UniElement?
            var nodeinfo = ret[0] as NodeInfo
            var width = nodeinfo.width as Number
            if (this.status && el != null) {
                this.opened = false
                this.dirs = "left"
                el.style.setProperty("transition-duration", this.duration.toString(10) + "ms")
                el.style.setProperty("left", "-" + width.toString(10) + "px")
                this.slideX = -width
            }
        }
        )
    }
    open var longTimePress = ::gen_longTimePress_fn
    open fun gen_longTimePress_fn() {
        if (this.isMove || this.opened) {
            return
        }
        this.`$emit`("longTimePress")
    }
    open var getMenuRightwidth = ::gen_getMenuRightwidth_fn
    open fun gen_getMenuRightwidth_fn(): Number {
        var idMenuRight = this.`$refs`["xSwitchSilderItems"] as UniElement
        var menurightWidth = idMenuRight.getBoundingClientRect().width
        return menurightWidth
    }
    open var eventTransform_start = ::gen_eventTransform_start_fn
    open fun gen_eventTransform_start_fn(evt: POSITION_TYPE_XY__1) {
        this.diffX = 0
        this.dateTime = Date().getTime()
        this.resetMoveData()
        if (this._disabled) {
            return
        }
        this.startX = evt.x - this.slideX
        this._x = evt.x
        this._y = evt.y
        this.startY = evt.y
        this.isMove = true
    }
    open var eventTransform_move = ::gen_eventTransform_move_fn
    open fun gen_eventTransform_move_fn(evt: POSITION_TYPE_XY__1) {
        var el = this.`$refs`["xSwitchSilder"] as UniElement?
        if (el == null) {
            return
        }
        var x = evt.x - this.startX
        var realleftdom = el.style.getPropertyValue("left") as String?
        var leftpos = parseInt(if (realleftdom == null) {
            "0"
        } else {
            realleftdom
        }
        )
        if (isNaN(leftpos)) {
            leftpos = 0
        }
        var menuwidth = this.getMenuRightwidth()
        var diffX = evt.x - this._x
        this._x = evt.x
        if (leftpos > 0) {
            x = 0
        } else if (leftpos < -menuwidth) {
            x = -menuwidth
        }
        x = Math.min(0, x)
        x = Math.max(-menuwidth, x)
        this.slideX = x
        if (Math.abs(x) > this.threshold) {
            if (diffX > 0) {
                this.dirs = "right"
            } else {
                this.dirs = "left"
            }
        }
        if (leftpos >= -menuwidth && leftpos <= 0 && Math.abs(diffX) > 0) {
            el.style.setProperty("left", x + "px")
        }
        this.diffX = diffX
    }
    open var mStart = ::gen_mStart_fn
    open fun gen_mStart_fn(evt: UniTouchEvent) {
        this.`$emit`("start")
        this.dateTime = Date.now()
        var event = evt.changedTouches[0]
        this._tempPop_x = event.clientX
        this._tempPop_y = event.clientY
        this.resetMoveData()
        if (this._disabled) {
            return
        }
        this.isMove = true
        this.isSwiper = "none"
        this.eventTransform_start(POSITION_TYPE_XY__1(x = event.clientX, y = event.clientY))
    }
    open var mMove = ::gen_mMove_fn
    open fun gen_mMove_fn(evt: UniTouchEvent) {
        this.`$emit`("move")
        var event = evt.changedTouches[0]
        if (this._disabled) {
            return
        }
        var y = Math.abs(event.clientY - this._tempPop_y)
        var x = Math.abs(event.clientX - this._tempPop_x)
        val hasDirection = Math.max(x, y) > 10
        val isHorizontal = x > y
        if (hasDirection && this.isSwiper == "none") {
            if (isHorizontal) {
                this.isSwiper = "swiper"
                evt.preventDefault()
                evt.stopPropagation()
            } else {
                this.isSwiper = "off"
            }
        }
        if (this.isSwiper == "swiper") {
            this.eventTransform_move(POSITION_TYPE_XY__1(x = event.clientX, y = event.clientY))
        }
    }
    open var mEnd = ::gen_mEnd_fn
    open fun gen_mEnd_fn(evt: UniTouchEvent) {
        this.`$emit`("end")
        var diffdate = Date.now() - this.dateTime
        var diffx = evt.changedTouches[0].clientX - this._tempPop_x
        var diffy = evt.changedTouches[0].clientY - this._tempPop_y
        if (Math.abs(diffx) == Math.abs(diffy) && diffx == 0 && diffdate > 5 && diffdate <= 250) {
            this.mClick()
        }
        var el = this.`$refs`["xSwitchSilder"] as UniElement?
        var idMenuRight = this.`$refs`["xSwitchSilderItems"] as UniElement?
        if (el == null || idMenuRight == null) {
            return
        }
        this.isMove = false
        if (this._disabled || this.isSwiper == "off") {
            return
        }
        var menuwidth = idMenuRight.getBoundingClientRect().width
        el.style.setProperty("transition-duration", this.duration.toString(10) + "ms")
        if (this.dirs == "left") {
            this.slideX = -menuwidth
            el.style.setProperty("left", (-menuwidth).toString(10) + "px")
            this.opened = true
            this.`$emit`("open")
        } else if (this.dirs == "right") {
            el.style.setProperty("left", "0px")
            this.slideX = 0
            this.opened = false
            this.`$emit`("close")
        }
    }
    open var onAniEnd = ::gen_onAniEnd_fn
    open fun gen_onAniEnd_fn() {
        if (this.dirs == "left") {
            this.`$emit`("update:status", true)
            this.isMove = false
        }
        if (this.dirs == "right") {
            this.`$emit`("update:status", false)
            this.isMove = false
        }
    }
    open var mClick = ::gen_mClick_fn
    open fun gen_mClick_fn() {
        this.`$emit`("click")
    }
    open var open = ::gen_open_fn
    open fun gen_open_fn() {
        this.opened = true
        this.dirs = "left"
        var menuwidth = this.getMenuRightwidth()
        var el = this.`$refs`["xSwitchSilder"] as UniElement?
        if (el == null) {
            return
        }
        el.style.setProperty("transition-duration", this.duration.toString(10) + "ms")
        el.style.setProperty("left", "-" + menuwidth.toString(10) + "px")
        this.slideX = -menuwidth
    }
    open var close = ::gen_close_fn
    open fun gen_close_fn() {
        this.opened = false
        this.dirs = "right"
        var el = this.`$refs`["xSwitchSilder"] as UniElement?
        if (el != null) {
            el.style.setProperty("transition-duration", this.duration.toString(10) + "ms")
            el.style.setProperty("left", "0px")
        }
        this.slideX = 0
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("noEventBySwitchSlider" to _pS(_uM("pointerEvents" to "none")), "xSwitchSilder" to _pS(_uM("display" to "flex", "flexDirection" to "column")), "xSwitchSilderWrap" to _pS(_uM("position" to "absolute", "width" to "100%", "height" to "100%", "zIndex" to 2, "right" to 0, "transitionProperty" to "left", "transitionDuration" to "0ms")), "xSwitchSilderItemsWrap" to _pS(_uM("width" to "100%", "height" to "100%", "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "flex-end")), "xSwitchSilderItems" to _pS(_uM("flexShrink" to 0, "height" to "100%", "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "flex-end")), "@TRANSITION" to _uM("xSwitchSilderWrap" to _uM("property" to "left", "duration" to "0ms")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("disabledScrollChange" to null, "click" to null, "open" to null, "close" to null, "start" to null, "end" to null, "move" to null, "update:status" to null, "longTimePress" to null)
        var props = _nP(_uM("custonmStyle" to _uM("type" to "String", "default" to ""), "custonmMenuStyle" to _uM("type" to "String", "default" to ""), "width" to _uM("type" to "String", "default" to "100%"), "height" to _uM("type" to "String", "default" to "50"), "disabled" to _uM("type" to "Boolean", "default" to false), "threshold" to _uM("type" to "Number", "default" to 15), "duration" to _uM("type" to "Number", "default" to 450), "status" to _uM("type" to "Boolean", "default" to false), "borderColor" to _uM("type" to "String", "default" to "#f5f5f5"), "borderDarkColor" to _uM("type" to "String", "default" to ""), "eventNone" to _uM("type" to "Boolean", "default" to true), "showBottomBorder" to _uM("type" to "Boolean", "default" to true)))
        var propsNeedCastKeys = _uA(
            "custonmStyle",
            "custonmMenuStyle",
            "width",
            "height",
            "disabled",
            "threshold",
            "duration",
            "status",
            "borderColor",
            "borderDarkColor",
            "eventNone",
            "showBottomBorder"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
