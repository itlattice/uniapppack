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
import io.dcloud.uniapp.extapi.rpx2px as uni_rpx2px
open class GenUniModulesTmxUiComponentsTmxDrawerTmxDrawer : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var customStyle: String by `$props`
    open var customWrapStyle: String by `$props`
    open var customFooterStyle: String by `$props`
    open var title: String by `$props`
    open var showFooter: Boolean by `$props`
    open var showTitle: Boolean by `$props`
    open var showClose: Boolean by `$props`
    open var overlayClick: Boolean by `$props`
    open var show: Boolean by `$props`
    open var showCancel: Boolean by `$props`
    open var cancelText: String by `$props`
    open var confirmText: String by `$props`
    open var duration: Number by `$props`
    open var watiDuration: Number by `$props`
    open var position: String by `$props`
    open var round: String by `$props`
    open var size: String by `$props`
    open var maxHeight: String by `$props`
    open var bgColor: String by `$props`
    open var darkBgColor: String by `$props`
    open var overflayBgColor: String by `$props`
    open var disabledScroll: Boolean by `$props`
    open var contentMargin: String by `$props`
    open var widthCoverCenter: Boolean by `$props`
    open var swiperLenClose: Number by `$props`
    open var offsetTop: String by `$props`
    open var offsetBottom: String by `$props`
    open var zIndex: Number by `$props`
    open var lazy: Boolean by `$props`
    open var disabledConfirm: Boolean by `$props`
    open var btnColor: String by `$props`
    open var beforeClose: () -> UTSPromise<Boolean> by `$props`
    open var closeColor: String by `$props`
    open var closeDarkColor: String by `$props`
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
        var setup: (__props: GenUniModulesTmxUiComponentsTmxDrawerTmxDrawer, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesTmxUiComponentsTmxDrawerTmxDrawer
            val _cache = __ins.renderCache
            val i18n = xConfig.i18n
            val proxy = getCurrentInstance()?.proxy ?: null
            fun emits(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val props = __props
            val _width = ref(0)
            val _height = ref(0)
            val showOverflay = ref(false)
            val actioning = ref(false)
            val status = ref("")
            val id = ref("xDrawer" + getUid())
            val wrapId = ref("xDrawerWrap" + getUid())
            val first = ref(true)
            val tid = ref(0)
            val windtop = ref(0)
            val windowBottom = ref(0)
            val start_move_x = ref(0)
            val start_move_y = ref(0)
            val move_x = ref(0)
            val move_y = ref(0)
            val move_end_x = ref(0)
            val move_end_y = ref(0)
            val scrollTop = ref(-1)
            val isTopOrBottomByScroll = ref(false)
            val xDrawerContentHeight = ref(0)
            val safeFooterHeight = ref(0)
            val lezyShowModal = ref(true)
            val isOpenedDefault = ref(false)
            val isLoading = ref(false)
            val anitid = ref(23)
            val _disabledConfirm = computed(fun(): Boolean {
                return props.disabledConfirm
            }
            )
            val _lazy = computed(fun(): Boolean {
                return props.lazy
            }
            )
            val _customStyle = computed(fun(): String {
                return props.customStyle
            }
            )
            val _customWrapStyle = computed(fun(): String {
                return props.customWrapStyle
            }
            )
            val _show = computed(fun(): Boolean {
                return props.show
            }
            )
            val _widthCoverCenter = computed(fun(): Boolean {
                return props.widthCoverCenter
            }
            )
            val _showClose = computed(fun(): Boolean {
                return props.showClose
            }
            )
            val _duration = computed(fun(): Number {
                return props.duration
            }
            )
            val _position = computed(fun(): String {
                return props.position
            }
            )
            val _showTitle = computed(fun(): Boolean {
                return props.showTitle
            }
            )
            val _round = computed(fun(): String {
                var round = props.round
                if (round == "") {
                    round = xConfig.drawerRadius
                }
                var radius = checkIsCssUnit(round, xConfig.unit)
                var _r = "none"
                if (props.position == "top") {
                    _r = "0px 0px " + radius + " " + radius
                } else if (props.position == "bottom") {
                    _r = "" + radius + " " + radius + " 0px 0px"
                } else if (props.position == "left" && props.round != "") {
                    _r = "0px " + radius + " " + radius + " 0px"
                } else if (props.position == "right" && props.round != "") {
                    _r = "" + radius + " 0px 0px " + radius
                }
                return _r
            }
            )
            val _offset = computed(fun(): Number {
                var offset = checkIsCssUnit(props.offsetTop, xConfig.unit)
                var x = parseFloat(offset)
                var unit = getUnit(offset)
                if (unit == "rpx") {
                    x = uni_rpx2px(x)
                }
                return x
            }
            )
            val _offsetBottom = computed(fun(): Number {
                var offset = checkIsCssUnit(props.offsetBottom, xConfig.unit)
                var x = parseFloat(offset)
                var unit = getUnit(offset)
                if (unit == "rpx") {
                    x = uni_rpx2px(x)
                }
                return x
            }
            )
            val _size = computed(fun(): String {
                return checkIsCssUnit(props.size, xConfig.unit)
            }
            )
            val _contentMargin = computed(fun(): String {
                return checkIsCssUnit(props.contentMargin, xConfig.unit)
            }
            )
            val _showFooter = computed(fun(): Boolean {
                return props.showFooter
            }
            )
            val _maxHeight = computed(fun(): String {
                if (props.maxHeight == "") {
                    return ""
                }
                if (props.position == "left" || props.position == "right") {
                    return ""
                }
                return checkIsCssUnit(props.maxHeight, xConfig.unit)
            }
            )
            val _showCancel = computed(fun(): Boolean {
                return props.showCancel
            }
            )
            val _title = computed(fun(): String {
                if (props.title == "") {
                    return i18n.t("tmui4x.modal.title")
                }
                return props.title
            }
            )
            val _cancelText = computed(fun(): String {
                if (props.cancelText == "") {
                    return i18n.t("tmui4x.cancel")
                }
                return props.cancelText
            }
            )
            val _confirmText = computed(fun(): String {
                if (props.confirmText == "") {
                    return i18n.t("tmui4x.confirm")
                }
                return props.confirmText
            }
            )
            val _animationFun = computed(fun(): String {
                return xConfig.animationFun
            }
            )
            val _bgColor = computed(fun(): String {
                var bgcolor = props.bgColor
                if (xConfig.dark == "dark") {
                    if (props.darkBgColor != "") {}
                    bgcolor = if (props.darkBgColor != "") {
                        props.darkBgColor
                    } else {
                        xConfig.sheetDarkColor
                    }
                }
                return getDefaultColor(bgcolor)
            }
            )
            val _btnColor = computed(fun(): String {
                if (props.btnColor == "") {
                    return getDefaultColor(xConfig.color)
                }
                return getDefaultColor(props.btnColor)
            }
            )
            val __height = computed(fun(): String {
                var h = "100%"
                if (_offset.value > 0 || _offsetBottom.value > 0) {
                    h = (_height.value - _offsetBottom.value) + "px"
                }
                return h
            }
            )
            val _titleFontSize = computed(fun(): String {
                return (xConfig.fontScale * 16).toString(10) + "px"
            }
            )
            val _isDark = computed(fun(): Boolean {
                return xConfig.dark == "dark"
            }
            )
            val _closeIcon = computed(fun(): String {
                return xConfig.closeIcon
            }
            )
            fun gen_onEnd_fn() {
                actioning.value = false
                if (status.value == "close") {
                    showOverflay.value = false
                    emits("close")
                    emits("update:show", false)
                    if (_lazy.value) {
                        lezyShowModal.value = false
                    }
                } else {
                    emits("open")
                    if (_lazy.value) {
                        lezyShowModal.value = true
                    }
                }
            }
            val onEnd = ::gen_onEnd_fn
            fun gen_setStyleAni_fn() {
                try {
                    var sys = uni_getWindowInfo()
                    _height.value = sys.windowHeight - _offset.value
                    var watiDuration: Number = 60
                    if (status.value == "open") {
                        showOverflay.value = true
                        clearTimeout(tid.value)
                        tid.value = setTimeout(fun() {
                            var element = proxy!!.`$refs`["xDrawerWrap"] as UniElement?
                            var elementWrap = proxy!!.`$refs`["xDrawerWrapContent"] as UniElement?
                            if (element == null || elementWrap == null) {
                                return
                            }
                            element!!.style.setProperty("transition-duration", _duration.value.toString(10) + "ms")
                            elementWrap!!.style.setProperty("transition-duration", _duration.value.toString(10) + "ms")
                            element!!.style.setProperty("opacity", 1)
                            elementWrap!!.style.setProperty("transform", "translate(0%,0%)")
                        }, watiDuration)
                    } else if (status.value == "close") {
                        var element = proxy!!.`$refs`["xDrawerWrap"] as UniElement?
                        var elementWrap = proxy!!.`$refs`["xDrawerWrapContent"] as UniElement?
                        if (element == null || elementWrap == null) {
                            return
                        }
                        element.style.setProperty("transition-duration", _duration.value.toString(10) + "ms")
                        elementWrap.style.setProperty("transition-duration", _duration.value.toString(10) + "ms")
                        element.style.setProperty("opacity", 0)
                        if (_position.value == "bottom") {
                            elementWrap.style.setProperty("transform", "translate(0%,100%)")
                        } else if (_position.value == "top") {
                            elementWrap.style.setProperty("transform", "translate(0%,-100%)")
                        } else if (_position.value == "left") {
                            elementWrap.style.setProperty("transform", "translate(-100%,0%)")
                        } else if (_position.value == "right") {
                            elementWrap.style.setProperty("transform", "translate(100%,0%)")
                        }
                    }
                }
                 catch (e: Throwable) {}
            }
            val setStyleAni = ::gen_setStyleAni_fn
            fun gen_overflayMoveTouch_fn(evt: TouchEvent) {
                evt.preventDefault()
            }
            val overflayMoveTouch = ::gen_overflayMoveTouch_fn
            fun gen_closeAlert_fn() {
                if (actioning.value) {
                    return
                }
                if (status.value == "close") {
                    return
                }
                actioning.value = true
                status.value = "close"
                emits("beforeClose")
                setStyleAni()
                anitid.value = setTimeout(fun() {
                    onEnd()
                }
                , _duration.value)
            }
            val closeAlert = ::gen_closeAlert_fn
            fun gen_showAlert_fn() {
                if (actioning.value) {
                    return
                }
                if (status.value == "open") {
                    return
                }
                showOverflay.value = true
                actioning.value = true
                status.value = "open"
                emits("beforeOpen")
                setStyleAni()
                anitid.value = setTimeout(fun() {
                    onEnd()
                }
                , _duration.value + 60)
            }
            val showAlert = ::gen_showAlert_fn
            fun gen_onClickOverflowy_fn(evt: Event) {
                evt.stopPropagation()
                emits("click")
                if (!props.overlayClick || isLoading.value) {
                    return
                }
                closeAlert()
            }
            val onClickOverflowy = ::gen_onClickOverflowy_fn
            fun gen_cancelEvt_fn() {
                emits("cancel")
                closeAlert()
            }
            val cancelEvt = ::gen_cancelEvt_fn
            fun gen_confirmEvt_fn(): UTSPromise<Any> {
                return wrapUTSPromise(suspend w1@{
                        isLoading.value = true
                        var isCanClose = await(props.beforeClose())
                        isLoading.value = false
                        if (!isCanClose) {
                            return@w1 UTSPromise.resolve(true)
                        }
                        emits("confirm")
                        closeAlert()
                        return@w1 UTSPromise.resolve(false)
                })
            }
            val confirmEvt = ::gen_confirmEvt_fn
            fun gen_openDrawer_fn() {
                showAlert()
            }
            val openDrawer = ::gen_openDrawer_fn
            fun gen_swiperClose_fn() {
                var offsetX = move_end_x.value - start_move_x.value
                var offsetY = move_end_y.value - start_move_y.value
                if (props.swiperLenClose == 0 || (actioning.value && status.value == "close")) {
                    return
                }
                if (props.position == "left" && offsetX < props.swiperLenClose * -1 && Math.abs(offsetX) >= Math.abs(offsetY)) {
                    closeAlert()
                }
                if (props.position == "right" && offsetX > props.swiperLenClose && Math.abs(offsetX) >= Math.abs(offsetY)) {
                    closeAlert()
                }
                if (props.position == "top" && offsetY < props.swiperLenClose * -1 && Math.abs(offsetY) >= Math.abs(offsetX)) {
                    closeAlert()
                }
                if (props.position == "bottom" && offsetY > props.swiperLenClose && Math.abs(offsetY) >= Math.abs(offsetX)) {
                    closeAlert()
                }
            }
            val swiperClose = ::gen_swiperClose_fn
            fun gen_maskerMove_fn(evt: UniTouchEvent) {}
            val maskerMove = ::gen_maskerMove_fn
            fun gen_mStart_fn(evt: UniTouchEvent) {
                if (props.swiperLenClose == 0) {
                    return
                }
                start_move_x.value = evt.changedTouches[0].clientX
                start_move_y.value = evt.changedTouches[0].clientY
            }
            val mStart = ::gen_mStart_fn
            fun gen_mMove_fn(evt: UniTouchEvent) {
                if (props.swiperLenClose == 0) {
                    return
                }
                if (evt.changedTouches.length == 0) {
                    return
                }
                move_x.value = evt.changedTouches[0].clientX
                move_y.value = evt.changedTouches[0].clientY
            }
            val mMove = ::gen_mMove_fn
            fun gen_mEnd_fn(evt: UniTouchEvent) {
                if (props.swiperLenClose == 0) {
                    return
                }
                if (evt.changedTouches.length == 0) {
                    return
                }
                var x = evt.changedTouches[0].clientX
                var y = evt.changedTouches[0].clientY
                move_end_x.value = x
                move_end_y.value = y
                swiperClose()
            }
            val mEnd = ::gen_mEnd_fn
            fun gen_onScroll_fn(evt: UniScrollEvent) {
                if (props.position == "bottom") {
                    if (evt.detail.scrollTop > 0) {
                        start_move_x.value = move_x.value
                        start_move_y.value = move_y.value
                    }
                }
                if (props.position == "top") {
                    var ele = proxy!!.`$refs`["xDrawerContent"] as UniElement?
                    if (ele == null) {
                        return
                    }
                    var height = ele.getBoundingClientRect().height
                    var maxheight = evt.detail.scrollHeight - evt.detail.scrollTop
                    if (evt.detail.scrollTop < maxheight - 1) {
                        start_move_x.value = move_x.value
                        start_move_y.value = move_y.value
                    }
                }
            }
            val onScroll = ::gen_onScroll_fn
            fun gen_onScrollTop_fn(evt: UniScrollToUpperEvent) {
                start_move_x.value = move_x.value
                start_move_y.value = move_y.value
            }
            val onScrollTop = ::gen_onScrollTop_fn
            fun gen_onScrollBottom_fn(evt: UniScrollToLowerEvent) {
                start_move_x.value = move_x.value
                start_move_y.value = move_y.value
            }
            val onScrollBottom = ::gen_onScrollBottom_fn
            watch(fun(): Boolean {
                return props.show
            }
            , fun(newval: Boolean){
                if (newval) {
                    showAlert()
                } else {
                    closeAlert()
                }
            }
            )
            onMounted(fun(){
                lezyShowModal.value = if (_lazy.value) {
                    false
                } else {
                    true
                }
                fun oninitready() {
                    isOpenedDefault.value = true
                    var sys = uni_getWindowInfo()
                    _width.value = sys.windowWidth
                    _height.value = sys.windowHeight + 44
                    windtop.value = _offset.value
                    safeFooterHeight.value = if (sys.safeAreaInsets.bottom == 0) {
                        16
                    } else {
                        sys.safeAreaInsets.bottom
                    }
                    if (_show.value) {
                        showAlert()
                    }
                }
                oninitready()
            }
            )
            onUpdated(fun(){})
            onBeforeUnmount(fun(){
                clearTimeout(tid.value)
            }
            )
            __expose(_uM("open" to fun(){
                return showAlert()
            }
            , "close" to fun(){
                return closeAlert()
            }
            ))
            return fun(): Any? {
                val _component_tmx_icon = resolveEasyComponent("tmx-icon", GenUniModulesTmxUiComponentsTmxIconTmxIconClass)
                val _component_tmx_loading = resolveEasyComponent("tmx-loading", GenUniModulesTmxUiComponentsTmxLoadingTmxLoadingClass)
                val _component_tmx_button = resolveEasyComponent("tmx-button", GenUniModulesTmxUiComponentsTmxButtonTmxButtonClass)
                return _cE("view", null, _uA(
                    _cE("view", _uM("onClick" to openDrawer), _uA(
                        renderSlot(_ctx.`$slots`, "trigger", GenUniModulesTmxUiComponentsTmxDrawerTmxDrawerSlotDataTrigger(show = _ctx.show))
                    )),
                    if (isTrue(showOverflay.value)) {
                        _cE("view", _uM("key" to 0, "onClick" to onClickOverflowy, "onTouchmove" to maskerMove, "id" to id.value, "ref" to "xDrawerWrap", "class" to _nC(_uA(
                            "xDrawerWrap",
                            _uA(
                                if ((_position.value == "top" || _position.value == "bottom") && _widthCoverCenter.value) {
                                    "xDrawerWrapContentMinwidthWrapDir"
                                } else {
                                    ""
                                },
                                "xDrawerWrap_" + _position.value
                            )
                        )), "style" to _nS(_uA(
                            _uM("backgroundColor" to _ctx.overflayBgColor, "width" to "100%", "top" to (windtop.value + "px"), "height" to __height.value, "zIndex" to _ctx.zIndex, "transition-timing-function" to _animationFun.value),
                            _customStyle.value
                        ))), _uA(
                            if (isTrue(showOverflay.value && _position.value == "bottom" && !actioning.value)) {
                                _cE("view", _uM("key" to 0), _uA(
                                    renderSlot(_ctx.`$slots`, "contentTop")
                                ))
                            } else {
                                _cC("v-if", true)
                            },
                            _cE("view", _uM("onClick" to withModifiers(fun(){}, _uA(
                                "stop"
                            )), "ref" to "xDrawerWrapContent", "class" to _nC(_uA(
                                "xDrawerWrapContent",
                                _uA(
                                    if ((_position.value == "top" || _position.value == "bottom") && _widthCoverCenter.value) {
                                        "xDrawerWrapContentMinwidth"
                                    } else {
                                        ""
                                    },
                                    "xDrawerWrapContent_" + _position.value
                                )
                            )), "onTouchstart" to mStart, "onTouchmove" to mMove, "onTouchend" to mEnd, "id" to wrapId.value, "style" to _nS(_uA(
                                _uM("width" to if (_position.value == "left" || _position.value == "right") {
                                    _size.value
                                } else {
                                    "100%"
                                }, "height" to if (_position.value == "left" || _position.value == "right") {
                                    "100%"
                                } else {
                                    _size.value
                                }, "borderRadius" to _round.value, "maxHeight" to if (_maxHeight.value != "") {
                                    _maxHeight.value
                                } else {
                                    "100%"
                                }, "transition-timing-function" to _animationFun.value, "backgroundColor" to _bgColor.value),
                                _ctx.customWrapStyle
                            ))), _uA(
                                _cE("view", _uM("class" to "xDrawerWrapContentBg"), _uA(
                                    renderSlot(_ctx.`$slots`, "bg")
                                )),
                                if (isTrue(_showClose.value)) {
                                    _cE("view", _uM("key" to 0, "class" to "xDrawerXclose"), _uA(
                                        _cV(_component_tmx_icon, _uM("onClick" to cancelEvt, "color" to _ctx.closeColor, "dark-color" to _ctx.closeDarkColor, "font-size" to "24px", "name" to _closeIcon.value), null, 8, _uA(
                                            "color",
                                            "dark-color",
                                            "name"
                                        ))
                                    ))
                                } else {
                                    _cC("v-if", true)
                                },
                                if (isTrue(_showTitle.value)) {
                                    _cE("view", _uM("key" to 1), _uA(
                                        renderSlot(_ctx.`$slots`, "title", _uM("show" to _ctx.show), fun(): UTSArray<Any> {
                                            return _uA(
                                                _cE("view", _uM("class" to "xDrawerTitleBox"), _uA(
                                                    _cE("text", _uM("style" to _nS(_uM("fontSize" to _titleFontSize.value, "color" to if (_isDark.value) {
                                                        "white"
                                                    } else {
                                                        "black"
                                                    }, "opacity" to "0.64")), "class" to "xDrawertitleBox"), _tD(_title.value), 5)
                                                ))
                                            )
                                        })
                                    ))
                                } else {
                                    _cC("v-if", true)
                                },
                                if (isTrue(!lezyShowModal.value)) {
                                    _cV(_component_tmx_loading, _uM("key" to 2), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cE("text")
                                        )
                                    }), "_" to 1))
                                } else {
                                    _cC("v-if", true)
                                },
                                _cE("view", _uM("ref" to "xDrawerContent", "class" to "xDrawerContent", "style" to _nS(_uM("flex" to "1", "margin" to ("0px 0px " + _contentMargin.value + " 0px")))), _uA(
                                    if (isTrue(!_ctx.disabledScroll && lezyShowModal.value)) {
                                        _cE("scroll-view", _uM("key" to 0, "onScroll" to onScroll, "onScrolltoupper" to onScrollTop, "onScrolltolower" to onScrollBottom, "style" to _nS(_uM("flex" to "1")), "scroll-y" to true, "rebound" to false), _uA(
                                            _cE("view", _uM("style" to _nS(_uM("padding" to ("0px " + _contentMargin.value + " 0px " + _contentMargin.value)))), _uA(
                                                renderSlot(_ctx.`$slots`, "default")
                                            ), 4)
                                        ), 36)
                                    } else {
                                        _cC("v-if", true)
                                    },
                                    if (isTrue(_ctx.disabledScroll && lezyShowModal.value)) {
                                        _cE("view", _uM("key" to 1, "style" to _nS(_uM("flex" to "1", "padding" to ("0px " + _contentMargin.value + " 0px " + _contentMargin.value)))), _uA(
                                            renderSlot(_ctx.`$slots`, "default")
                                        ), 4)
                                    } else {
                                        _cC("v-if", true)
                                    }
                                ), 4),
                                if (isTrue(_ctx.showFooter && lezyShowModal.value)) {
                                    _cE("view", _uM("key" to 3, "class" to "xDrawerFooter", "style" to _nS(_uA(
                                        _uM("backgroundColor" to _bgColor.value),
                                        _ctx.customFooterStyle
                                    ))), _uA(
                                        renderSlot(_ctx.`$slots`, "footer", _uO(), fun(): UTSArray<Any> {
                                            return _uA(
                                                _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row", "align-items" to "center", "justify-content" to "center", "display" to "flex"))), _uA(
                                                    if (isTrue(_showCancel.value)) {
                                                        _cV(_component_tmx_button, _uM("key" to 0, "disabled" to isLoading.value, "color" to _btnColor.value, "onClick" to cancelEvt, "skin" to "thin", "width" to "0px", "block" to true, "style" to _nS(_uM("margin-right" to "16rpx", "flex" to "1"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                            return _uA(
                                                                _tD(_cancelText.value)
                                                            )
                                                        }), "_" to 1), 8, _uA(
                                                            "disabled",
                                                            "color",
                                                            "style"
                                                        ))
                                                    } else {
                                                        _cC("v-if", true)
                                                    },
                                                    _cV(_component_tmx_button, _uM("loading" to isLoading.value, "color" to _btnColor.value, "onClick" to confirmEvt, "width" to "0px", "disabled" to _disabledConfirm.value, "block" to true, "style" to _nS(_uM("flex" to "1"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                        return _uA(
                                                            _tD(_confirmText.value)
                                                        )
                                                    }), "_" to 1), 8, _uA(
                                                        "loading",
                                                        "color",
                                                        "disabled",
                                                        "style"
                                                    ))
                                                ), 4)
                                            )
                                        }),
                                        _cE("view", _uM("style" to _nS(_uM("height" to (safeFooterHeight.value + "px")))), null, 4)
                                    ), 4)
                                } else {
                                    _cC("v-if", true)
                                }
                            ), 46, _uA(
                                "onClick",
                                "id"
                            ))
                        ), 46, _uA(
                            "id"
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                ))
            }
        }
        var name = "xDrawer"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("xDrawerWrapContentBg" to _pS(_uM("position" to "absolute", "zIndex" to 0, "pointerEvents" to "none", "width" to "100%", "height" to "100%")), "xDrawerContent" to _pS(_uM("position" to "relative")), "xDrawerFooter" to _pS(_uM("width" to "100%", "paddingTop" to 0, "paddingRight" to 16, "paddingBottom" to 0, "paddingLeft" to 16)), "xDrawerXclose" to _pS(_uM("position" to "absolute", "right" to 16, "top" to 9, "zIndex" to 100)), "xDrawerXcloseOutter" to _pS(_uM("paddingRight" to 16)), "xDrawerTitleBox" to _pS(_uM("height" to 50, "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center")), "xDrawertitleBox" to _pS(_uM("maxWidth" to 175, "overflow" to "hidden", "lines" to 1, "textOverflow" to "ellipsis")), "xDrawerWrap_bottom" to _pS(_uM("display" to "flex", "flexDirection" to "column", "justifyContent" to "flex-end")), "xDrawerWrap_top" to _pS(_uM("display" to "flex", "flexDirection" to "column", "justifyContent" to "flex-start")), "xDrawerWrap_left" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "flex-start")), "xDrawerWrap_right" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "flex-end")), "xDrawerWrapContent" to _pS(_uM("transitionDuration" to "350ms", "transitionProperty" to "transform", "display" to "flex", "flexDirection" to "column", "position" to "relative")), "xDrawerWrapContentMinwidth" to _pS(_uM("maxWidth" to 500)), "xDrawerWrapContentMinwidthWrapDir" to _pS(_uM("alignItems" to "center")), "xDrawerWrapContent_bottom" to _pS(_uM("transform" to "translate(0%, 100%)")), "xDrawerWrapContent_top" to _pS(_uM("transform" to "translate(0%, -100%)")), "xDrawerWrapContent_left" to _pS(_uM("transform" to "translate(-100%, 0%)")), "xDrawerWrapContent_right" to _pS(_uM("transform" to "translate(100%, 0%)")), "xDrawerWrap" to _pS(_uM("opacity" to 0, "position" to "fixed", "left" to 0, "top" to 0, "transitionDuration" to "350ms", "transitionProperty" to "opacity")), "@TRANSITION" to _uM("xDrawerWrapContent" to _uM("duration" to "350ms", "property" to "transform"), "xDrawerWrap" to _uM("duration" to "350ms", "property" to "opacity")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("click" to null, "close" to null, "open" to null, "beforeOpen" to null, "beforeClose" to null, "update:show" to null, "cancel" to null, "confirm" to null)
        var props = _nP(_uM("customStyle" to _uM("type" to "String", "required" to true, "default" to ""), "customWrapStyle" to _uM("type" to "String", "required" to true, "default" to ""), "customFooterStyle" to _uM("type" to "String", "required" to true, "default" to ""), "title" to _uM("type" to "String", "required" to true, "default" to ""), "showFooter" to _uM("type" to "Boolean", "required" to true, "default" to false), "showTitle" to _uM("type" to "Boolean", "required" to true, "default" to true), "showClose" to _uM("type" to "Boolean", "required" to true, "default" to false), "overlayClick" to _uM("type" to "Boolean", "required" to true, "default" to true), "show" to _uM("type" to "Boolean", "required" to true, "default" to false), "showCancel" to _uM("type" to "Boolean", "required" to true, "default" to true), "cancelText" to _uM("type" to "String", "required" to true, "default" to ""), "confirmText" to _uM("type" to "String", "required" to true, "default" to ""), "duration" to _uM("type" to "Number", "required" to true, "default" to 300), "watiDuration" to _uM("type" to "Number", "required" to true, "default" to 120), "position" to _uM("type" to "String", "required" to true, "default" to "bottom"), "round" to _uM("type" to "String", "required" to true, "default" to ""), "size" to _uM("type" to "String", "required" to true, "default" to "50%"), "maxHeight" to _uM("type" to "String", "required" to true, "default" to ""), "bgColor" to _uM("type" to "String", "required" to true, "default" to "white"), "darkBgColor" to _uM("type" to "String", "required" to true, "default" to ""), "overflayBgColor" to _uM("type" to "String", "required" to true, "default" to "rgba(0, 0, 0, 0.4)"), "disabledScroll" to _uM("type" to "Boolean", "required" to true, "default" to false), "contentMargin" to _uM("type" to "String", "required" to true, "default" to "16"), "widthCoverCenter" to _uM("type" to "Boolean", "required" to true, "default" to false), "swiperLenClose" to _uM("type" to "Number", "required" to true, "default" to 0), "offsetTop" to _uM("type" to "String", "required" to true, "default" to "0"), "offsetBottom" to _uM("type" to "String", "required" to true, "default" to "0"), "zIndex" to _uM("type" to "Number", "required" to true, "default" to 1100), "lazy" to _uM("type" to "Boolean", "required" to true, "default" to false), "disabledConfirm" to _uM("type" to "Boolean", "required" to true, "default" to false), "btnColor" to _uM("type" to "String", "required" to true, "default" to ""), "beforeClose" to _uM("type" to "Function", "required" to true, "default" to fun(): UTSPromise<Boolean> {
            return UTSPromise.resolve(true)
        }
        ), "closeColor" to _uM("type" to "String", "required" to true, "default" to "#e6e6e6"), "closeDarkColor" to _uM("type" to "String", "required" to true, "default" to "#545454")))
        var propsNeedCastKeys = _uA(
            "customStyle",
            "customWrapStyle",
            "customFooterStyle",
            "title",
            "showFooter",
            "showTitle",
            "showClose",
            "overlayClick",
            "show",
            "showCancel",
            "cancelText",
            "confirmText",
            "duration",
            "watiDuration",
            "position",
            "round",
            "size",
            "maxHeight",
            "bgColor",
            "darkBgColor",
            "overflayBgColor",
            "disabledScroll",
            "contentMargin",
            "widthCoverCenter",
            "swiperLenClose",
            "offsetTop",
            "offsetBottom",
            "zIndex",
            "lazy",
            "disabledConfirm",
            "btnColor",
            "beforeClose",
            "closeColor",
            "closeDarkColor"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
