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
import uts.sdk.modules.iboxsQcloudCos.init
import uts.sdk.modules.iboxsQcloudCos.cosUploadFile
open class GenUniModulesFirstuiUvueComponentsFuiSwipeActionFuiSwipeAction : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            this.`$nextTick`(fun(){
                val parent = this.getParent("fui-swipeaction-group")
                if (parent) {
                    val group = this.group as ComponentPublicInstance
                    (group.`$data`["children"] as UTSArray<ComponentPublicInstance>).push(this as ComponentPublicInstance)
                }
                this.init()
            }
            )
        }
        , __ins)
        onBeforeUnmount(fun() {
            this.unInstall()
        }
        , __ins)
        this.`$watch`(fun(): Any? {
            return this.locale
        }
        , fun(kVal: String) {
            val lang = getFuiLocaleLang(kVal)
            val swipea = lang["swipeaction"] as UTSJSONObject
            val btns = JSON.parse<UTSArray<FuiSwipeActionButtonParam>>(JSON.stringify(this.buttons))
            if (btns == null || btns.length == 0) {
                val param = _uA<FuiSwipeActionButtonParam>(FuiSwipeActionButtonParam(text = swipea.getString("delete") as String))
                this.getButtons(param)
            } else {
                this.getButtons(btns)
            }
        }
        , WatchOptions(immediate = true))
        this.`$watch`(fun(): Any? {
            return this.buttons
        }
        , fun(vals: UTSArray<FuiSwipeActionButtonParam>) {
            this.getButtons(vals)
            this.init()
        }
        )
        this.`$watch`(fun(): Any? {
            return this.visible
        }
        , fun(newVal: Boolean) {
            this.openState(newVal)
        }
        )
        this.`$watch`(fun(): Any? {
            return this.left
        }
        , fun() {
            if (this.element == null) {
                this.element = this.`$refs`[this.refLeft] as UniElement
            }
            if (this.rElement == null) {
                this.rElement = this.`$refs`[this.refRight] as UniElement
            }
            this.element!!.style.setProperty("transform", "translateX(" + this.left + "px)")
            if (this.isScale) {
                this.rElement!!.style.setProperty("transform", "scaleX(" + Math.abs(this.left / this.rightWidth) + ")")
            } else {
                this.rElement!!.style.setProperty("transform", "translateX(" + (this.left + this.rightWidth) + "px)")
            }
        }
        )
        this.`$watch`(fun(): Any? {
            return this.isShow
        }
        , fun(newVal: Boolean) {
            this.openState(newVal)
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        return _cE("view", _uM("class" to "fui-swipe__action-wrap", "style" to _nS(_uM("marginTop" to ("" + _ctx.marginTop + "rpx"), "marginBottom" to ("" + _ctx.marginBottom + "rpx")))), _uA(
            _cE("view", _uM("class" to _nC(_uA(
                "fui-swipe__action-inner",
                _uM("fui-swipe__action-visible" to !_ctx.isScale)
            )), "onClick" to withModifiers(_ctx.stop, _uA(
                "stop"
            ))), _uA(
                _cE("view", _uM("ref" to _ctx.refLeft, "class" to "fui-swipe__action-left", "onTouchstart" to _ctx.touchstart, "onTouchmove" to _ctx.touchmove, "onTouchend" to _ctx.touchend, "onTouchcancel" to _ctx.touchend), _uA(
                    renderSlot(_ctx.`$slots`, "default")
                ), 40, _uA(
                    "onTouchstart",
                    "onTouchmove",
                    "onTouchend",
                    "onTouchcancel"
                )),
                _cE("view", _uM("ref" to _ctx.refRight, "class" to _nC(_uA(
                    "fui-swipe__action-right",
                    _uA(
                        "fui-swipe__action-" + (if (_ctx.isScale) {
                            "scale"
                        } else {
                            "translate"
                        }
                        )
                    )
                )), "id" to _ctx.elId), _uA(
                    renderSlot(_ctx.`$slots`, "buttons", _uO(), fun(): UTSArray<Any> {
                        return _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(_ctx.btns, fun(item, index, __index, _cached): Any {
                                return _cE("view", _uM("key" to index, "class" to _nC(_uA(
                                    "fui-swipe__action-btn",
                                    _uM("fui-swipe__action-bg" to (item.background == null || item.background == ""))
                                )), "style" to _nS(_uM("background" to item.background)), "onClick" to withModifiers(fun(){
                                    _ctx.appTouchEnd(index, item)
                                }
                                , _uA(
                                    "stop"
                                ))), _uA(
                                    _cE("text", _uM("class" to "fui-swipe__action-text", "style" to _nS(_uM("fontSize" to ("" + (if (item.size == null) {
                                        _ctx.size
                                    } else {
                                        item.size!!
                                    }
                                    ) + "rpx"), "lineHeight" to ("" + (if (item.size == null) {
                                        _ctx.size
                                    } else {
                                        item.size!!
                                    }
                                    ) + "rpx"), "color" to ("" + (if (item.color == null) {
                                        _ctx.color
                                    } else {
                                        item.color!!
                                    }
                                    ))))), _tD(item.text), 5)
                                ), 14, _uA(
                                    "onClick"
                                ))
                            }
                            ), 128)
                        )
                    }
                    )
                ), 10, _uA(
                    "id"
                ))
            ), 10, _uA(
                "onClick"
            ))
        ), 4)
    }
    open var buttons: UTSArray<FuiSwipeActionButtonParam> by `$props`
    open var size: Number by `$props`
    open var color: String by `$props`
    open var visible: Boolean by `$props`
    open var threshold: Number by `$props`
    open var disabled: Boolean by `$props`
    open var autoClose: Boolean by `$props`
    open var clickClose: Boolean by `$props`
    open var isScale: Boolean by `$props`
    open var marginTop: Number by `$props`
    open var marginBottom: Number by `$props`
    open var param: Number by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    open var group: ComponentPublicInstance? by `$data`
    open var btns: UTSArray<FuiSwipeActionButtonParam> by `$data`
    open var left: Number by `$data`
    open var isShow: Boolean by `$data`
    open var refLeft: Any? by `$data`
    open var refRight: Any? by `$data`
    open var elId: Any? by `$data`
    open var MIN_DISTANCE: Number by `$data`
    open var element: UniElement? by `$data`
    open var rElement: UniElement? by `$data`
    open var rightWidth: Number by `$data`
    open var open: Boolean by `$data`
    open var direction: String by `$data`
    open var deltaX: Number by `$data`
    open var deltaY: Number by `$data`
    open var offsetX: Number by `$data`
    open var offsetY: Number by `$data`
    open var startX: Number by `$data`
    open var startY: Number by `$data`
    open var x: Number by `$data`
    open var clientX: Number by `$data`
    open var timer: Number? by `$data`
    open var locale: String by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        val elId = "fui_swipea_" + parseInt(Math.ceil(Math.random() * 10e5).toString(10), 36)
        val refLeft = "fui_swipearef_" + parseInt(Math.ceil(Math.random() * 10e5).toString(10), 36)
        val refRight = "fui_swipearef_" + parseInt(Math.ceil(Math.random() * 10e5).toString(10), 36)
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml, "group" to null as ComponentPublicInstance?, "btns" to _uA<FuiSwipeActionButtonParam>(), "left" to 0, "isShow" to false, "refLeft" to refLeft, "refRight" to refRight, "elId" to elId, "MIN_DISTANCE" to 10, "element" to null as UniElement?, "rElement" to null as UniElement?, "rightWidth" to 0, "open" to false, "direction" to "", "deltaX" to 0, "deltaY" to 0, "offsetX" to 0, "offsetY" to 0, "startX" to 0, "startY" to 0, "x" to 0, "clientX" to 0, "timer" to null as Number?, "locale" to computed<String>(fun(): String {
            return fuiLang.locale
        }
        ))
    }
    open var getButtons = ::gen_getButtons_fn
    open fun gen_getButtons_fn(vals: UTSArray<FuiSwipeActionButtonParam>) {
        this.btns = _uA<FuiSwipeActionButtonParam>()
        this.`$nextTick`(fun(){
            this.btns = vals
        }
        )
    }
    open var unInstall = ::gen_unInstall_fn
    open fun gen_unInstall_fn() {
        if (this.group != null) {
            val group = this.group as ComponentPublicInstance
            val children = group.`$data`["children"] as UTSArray<ComponentPublicInstance>
            val _this = this as ComponentPublicInstance
            children.forEach(fun(item: ComponentPublicInstance, index: Number){
                if (item == _this) {
                    children.splice(index, 1)
                }
            }
            )
        }
    }
    open var getParent = ::gen_getParent_fn
    open fun gen_getParent_fn(name: String): Boolean {
        if (this.`$parent` == null) {
            return false
        }
        var parent = this.`$parent` as ComponentPublicInstance
        var parentName = parent.`$options`["name"]
        while(parentName != name){
            if (parent.`$parent` == null) {
                return false
            }
            parent = parent.`$parent` as ComponentPublicInstance
            if (parent.`$options`["name"] == "") {
                return false
            }
            parentName = parent.`$options`["name"]
        }
        this.group = parent
        return true
    }
    open var stop = ::gen_stop_fn
    open fun gen_stop_fn() {
        if (this.clickClose && this.open) {
            this.close()
        }
    }
    open var init = ::gen_init_fn
    open fun gen_init_fn() {
        if (this.timer != null) {
            clearTimeout(this.timer as Number)
        }
        this.timer = setTimeout(fun(){
            this.getSelectorQuery()
        }
        , 100)
        this.left = 0
        this.x = 0
    }
    open var closeSwipe = ::gen_closeSwipe_fn
    open fun gen_closeSwipe_fn() {
        if (this.group != null && this.autoClose) {
            val group = this.group as ComponentPublicInstance
            group.`$callMethod`("closeAuto", this)
        }
    }
    open var appTouchEnd = ::gen_appTouchEnd_fn
    open fun gen_appTouchEnd_fn(index: Number, item: FuiSwipeActionButtonParam) {
        val params = item
        params.index = index
        params.param = this.param
        if (this.clickClose) {
            this.close()
        }
        this.`$emit`("onclick", params)
    }
    open var aniSwitch = ::gen_aniSwitch_fn
    open fun gen_aniSwitch_fn(isAdd: Boolean) {
        if (this.element == null) {
            this.element = this.`$refs`[this.refLeft] as UniElement
        }
        if (this.rElement == null) {
            this.rElement = this.`$refs`[this.refRight] as UniElement
        }
        this.element!!.style.setProperty("transition-duration", if (isAdd) {
            "300ms"
        } else {
            "0ms"
        }
        )
        this.element!!.style.setProperty("transition-property", if (isAdd) {
            "transform"
        } else {
            ""
        }
        )
        this.element!!.style.setProperty("transition-timing-function", if (isAdd) {
            "cubic-bezier(0.165, 0.84, 0.44, 1)"
        } else {
            ""
        }
        )
        this.rElement!!.style.setProperty("transition-duration", if (isAdd) {
            "300ms"
        } else {
            "0ms"
        }
        )
        this.rElement!!.style.setProperty("transition-property", if (isAdd) {
            "transform"
        } else {
            ""
        }
        )
        this.rElement!!.style.setProperty("transition-timing-function", if (isAdd) {
            "cubic-bezier(0.165, 0.84, 0.44, 1)"
        } else {
            ""
        }
        )
    }
    open var touchstart = ::gen_touchstart_fn
    open fun gen_touchstart_fn(e: UniTouchEvent) {
        if (!this.disabled) {
            this.aniSwitch(false)
            this.x = this.left
            this.stopTouchStart(e)
            if (this.autoClose) {
                this.closeSwipe()
            }
        }
    }
    open var touchmove = ::gen_touchmove_fn
    open fun gen_touchmove_fn(e: UniTouchEvent): Boolean {
        if (this.disabled) {
            return false
        }
        this.stopTouchMove(e)
        if (this.direction != "horizontal") {
            return false
        } else {
            e.preventDefault()
        }
        this.move(this.x + this.deltaX)
        return false
    }
    open var touchend = ::gen_touchend_fn
    open fun gen_touchend_fn() {
        if (!this.disabled) {
            this.moveDirection(this.left)
        }
    }
    open var move = ::gen_move_fn
    open fun gen_move_fn(value: Number) {
        val rightWidth = this.rightWidth
        this.left = Math.min(Math.max(value, -rightWidth), 0)
    }
    open var moveDirection = ::gen_moveDirection_fn
    open fun gen_moveDirection_fn(left: Number) {
        val threshold = this.threshold
        val open = this.open
        val rightWidth = this.rightWidth
        if (this.deltaX == 0 && this.clickClose) {
            this.openState(false)
        } else {
            if ((!open && rightWidth > 0 && -left > threshold) || (open && rightWidth > 0 && rightWidth + left < threshold)) {
                this.openState(true)
            } else {
                this.openState(false)
            }
        }
    }
    open var openState = ::gen_openState_fn
    open fun gen_openState_fn(type: Boolean) {
        val rightWidth = this.rightWidth
        var left: Number
        if (type) {
            left = -rightWidth
        } else {
            left = 0
        }
        if (this.open != type) {
            this.`$emit`("change", type)
        }
        this.open = type
        this.aniSwitch(true)
        this.`$nextTick`(fun(){
            this.move(left)
        }
        )
    }
    open var close = ::gen_close_fn
    open fun gen_close_fn() {
        this.openState(false)
    }
    open var getDirection = ::gen_getDirection_fn
    open fun gen_getDirection_fn(x: Number, y: Number): String {
        if (x > y && x > this.MIN_DISTANCE) {
            return "horizontal"
        }
        if (y > x && y > this.MIN_DISTANCE) {
            return "vertical"
        }
        return ""
    }
    open var resetTouchStatus = ::gen_resetTouchStatus_fn
    open fun gen_resetTouchStatus_fn() {
        this.direction = ""
        this.deltaX = 0
        this.deltaY = 0
        this.offsetX = 0
        this.offsetY = 0
    }
    open var stopTouchStart = ::gen_stopTouchStart_fn
    open fun gen_stopTouchStart_fn(event: UniTouchEvent) {
        this.resetTouchStatus()
        val touch = event.touches[0]
        this.startX = touch.clientX
        this.startY = touch.clientY
    }
    open var stopTouchMove = ::gen_stopTouchMove_fn
    open fun gen_stopTouchMove_fn(event: UniTouchEvent) {
        val touch = event.touches[0]
        this.deltaX = touch.clientX - this.startX
        this.deltaY = touch.clientY - this.startY
        this.offsetX = Math.abs(this.deltaX)
        this.offsetY = Math.abs(this.deltaY)
        if (this.direction == "") {
            this.direction = this.getDirection(this.offsetX, this.offsetY)
        }
    }
    open var getSelectorQuery = ::gen_getSelectorQuery_fn
    open fun gen_getSelectorQuery_fn() {
        uni_createSelectorQuery().select("#" + this.elId).boundingClientRect().exec(fun(ret){
            val node = ret[0] as NodeInfo
            this.rightWidth = if (node.width == null) {
                0
            } else {
                node.width!!
            }
             as Number
            this.isShow = this.visible
        }
        )
    }
    companion object {
        var name = "fui-swipe-action"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("fui-swipe__action-wrap" to _pS(_uM("position" to "relative", "overflow" to "hidden")), "fui-swipe__action-inner" to _pS(_uM("display" to "flex", "flexShrink" to 0, "position" to "relative")), "fui-swipe__action-visible" to _pS(_uM("overflow" to "visible")), "fui-swipe__action-left" to _pS(_uM("width" to "100%", "position" to "relative", "zIndex" to 2, "transitionDuration" to "0s", "transitionProperty" to "transform", "transitionTimingFunction" to "cubic-bezier(0.165,0.84,0.44,1)")), "fui-swipe__action-right" to _pS(_uM("position" to "absolute", "top" to 0, "bottom" to 0, "right" to 0, "height" to "100%", "display" to "flex", "flexDirection" to "row", "boxSizing" to "border-box", "zIndex" to 1, "transitionDuration" to "0s", "transitionProperty" to "transform", "transitionTimingFunction" to "cubic-bezier(0.165,0.84,0.44,1)")), "fui-swipe__action-translate" to _pS(_uM("transform" to "translateX(100%)")), "fui-swipe__action-scale" to _pS(_uM("transform" to "scaleX(100%)", "transformOrigin" to "100% 0")), "fui-swipe__action-btn" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center", "paddingTop" to 0, "paddingRight" to "48rpx", "paddingBottom" to 0, "paddingLeft" to "48rpx", "boxSizing" to "border-box", "flexShrink" to 0)), "fui-swipe__action-text" to _pS(_uM("flexShrink" to 0, "textAlign" to "center")), "fui-swipe__action-bg" to _pS(_uM("!backgroundImage" to "none", "!backgroundColor" to "#FF2B2B")), "@TRANSITION" to _uM("fui-swipe__action-left" to _uM("duration" to "0s", "property" to "transform", "timingFunction" to "cubic-bezier(0.165,0.84,0.44,1)"), "fui-swipe__action-right" to _uM("duration" to "0s", "property" to "transform", "timingFunction" to "cubic-bezier(0.165,0.84,0.44,1)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("onclick" to null, "change" to null)
        var props = _nP(_uM("buttons" to _uM("type" to "Array", "default" to fun(): UTSArray<FuiSwipeActionButtonParam> {
            return _uA<FuiSwipeActionButtonParam>()
        }
        ), "size" to _uM("type" to "Number", "default" to 32), "color" to _uM("type" to "String", "default" to "#fff"), "visible" to _uM("type" to "Boolean", "default" to false), "threshold" to _uM("type" to "Number", "default" to 30), "disabled" to _uM("type" to "Boolean", "default" to false), "autoClose" to _uM("type" to "Boolean", "default" to true), "clickClose" to _uM("type" to "Boolean", "default" to true), "isScale" to _uM("type" to "Boolean", "default" to false), "marginTop" to _uM("type" to "Number", "default" to 0), "marginBottom" to _uM("type" to "Number", "default" to 0), "param" to _uM("type" to "Number", "default" to 0)))
        var propsNeedCastKeys = _uA(
            "buttons",
            "size",
            "color",
            "visible",
            "threshold",
            "disabled",
            "autoClose",
            "clickClose",
            "isScale",
            "marginTop",
            "marginBottom",
            "param"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
