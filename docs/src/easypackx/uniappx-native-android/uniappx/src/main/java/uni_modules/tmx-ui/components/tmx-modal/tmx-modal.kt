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
open class GenUniModulesTmxUiComponentsTmxModalTmxModal : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var customStyle: String by `$props`
    open var title: String by `$props`
    open var showFooter: Boolean by `$props`
    open var showTitle: Boolean by `$props`
    open var showClose: Boolean by `$props`
    open var showCancel: Boolean by `$props`
    open var overlayClick: Boolean by `$props`
    open var show: Boolean by `$props`
    open var duration: Number by `$props`
    open var watiDuration: Number by `$props`
    open var cancelText: String by `$props`
    open var confirmText: String by `$props`
    open var round: String by `$props`
    open var width: String by `$props`
    open var height: String by `$props`
    open var maxHeight: String by `$props`
    open var disabledScroll: Boolean by `$props`
    open var bgColor: String by `$props`
    open var darkBgColor: String by `$props`
    open var zIndex: String by `$props`
    open var contentPadding: String by `$props`
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
        var setup: (__props: GenUniModulesTmxUiComponentsTmxModalTmxModal, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesTmxUiComponentsTmxModalTmxModal
            val _cache = __ins.renderCache
            val i18n = xConfig.i18n
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val props = __props
            val _width = ref<Number>(0)
            val _height = ref<Number>(0)
            val showOverflay = ref<Boolean>(false)
            val elementRef = ref<UniElement?>(null)
            val xDrawerWrapContentRef = ref<UniElement?>(null)
            val xModalWrapBoxRef = ref<UniElement?>(null)
            val actioning = ref<Boolean>(false)
            val status = ref<String>("")
            val id = ref<String>("xModal" + getUid())
            val wrapId = ref<String>("xModal" + getUid())
            val first = ref<Boolean>(true)
            val tid = ref<Number>(0)
            val tid2 = ref<Number>(34)
            val windtop = ref<Number>(0)
            val xani = ref<xAnimate?>(null)
            val isOpenedDefault = ref<Boolean>(false)
            val isLoading = ref<Boolean>(false)
            val instance = getCurrentInstance()?.proxy
            val _customStyle = computed<String>(fun(): String {
                return props.customStyle
            }
            )
            val _show = computed<Boolean>(fun(): Boolean {
                return props.show
            }
            )
            val _showClose = computed<Boolean>(fun(): Boolean {
                return props.showClose
            }
            )
            val _duration = computed<Number>(fun(): Number {
                return props.duration
            }
            )
            val _showTitle = computed<Boolean>(fun(): Boolean {
                return props.showTitle
            }
            )
            val _round = computed<String>(fun(): String {
                if (props.round == "") {
                    return checkIsCssUnit(xConfig.modalRadius, xConfig.unit)
                }
                return checkIsCssUnit(props.round, xConfig.unit)
            }
            )
            val _c_width = computed<String>(fun(): String {
                return checkIsCssUnit(props.width, xConfig.unit)
            }
            )
            val _c_height = computed<String>(fun(): String {
                return checkIsCssUnit(props.height, xConfig.unit)
            }
            )
            val _disabledScroll = computed<Boolean>(fun(): Boolean {
                return props.disabledScroll || _c_height.value == "auto"
            }
            )
            val _showFooter = computed<Boolean>(fun(): Boolean {
                return props.showFooter
            }
            )
            val _maxHeight = computed<String>(fun(): String {
                return checkIsCssUnit(props.maxHeight, xConfig.unit)
            }
            )
            val _contentPadding = computed<String>(fun(): String {
                var cps = props.contentPadding.split(" ")
                if (cps.length > 1) {
                    return props.contentPadding
                }
                return "0px " + checkIsCssUnit(props.contentPadding, xConfig.unit)
            }
            )
            val _showCancel = computed<Boolean>(fun(): Boolean {
                return props.showCancel
            }
            )
            val _title = computed<String>(fun(): String {
                if (props.title == "") {
                    return i18n.t("tmui4x.modal.title")
                }
                return props.title
            }
            )
            val _cancelText = computed<String>(fun(): String {
                if (props.cancelText == "") {
                    return i18n.t("tmui4x.cancel")
                }
                return props.cancelText
            }
            )
            val _confirmText = computed<String>(fun(): String {
                if (props.confirmText == "") {
                    return i18n.t("tmui4x.confirm")
                }
                return props.confirmText
            }
            )
            val _animationFun = computed<String>(fun(): String {
                return xConfig.animationFun
            }
            )
            val __height = computed<String>(fun(): String {
                var h = "100%"
                return h
            }
            )
            val _bgColor = computed<String>(fun(): String {
                if (xConfig.dark == "dark") {
                    if (props.darkBgColor != "") {
                        return getDefaultColor(props.darkBgColor)
                    }
                    return getDefaultColor(xConfig.sheetDarkColor)
                }
                return getDefaultColor(props.bgColor)
            }
            )
            val _btnColor = computed<String>(fun(): String {
                if (props.btnColor == "") {
                    return getDefaultColor(xConfig.color)
                }
                return getDefaultColor(props.btnColor)
            }
            )
            val _closeIcon = computed<String>(fun(): String {
                return xConfig.closeIcon
            }
            )
            val onEnd = fun(){
                try {
                    if (actioning.value) {
                        return
                    }
                    actioning.value = true
                    tid2.value = setTimeout(fun() {
                        if (status.value == "close") {
                            showOverflay.value = false
                            emit("close")
                            emit("update:show", false)
                        } else {
                            emit("open")
                        }
                        nextTick(fun(){
                            actioning.value = false
                        }
                        )
                    }
                    , _duration.value + 5)
                }
                 catch (e: Throwable) {
                    console.error("动画结束执行出现意外。", e)
                    showOverflay.value = false
                }
            }
            val setStyleAni = fun(){
                if (status.value == "open") {
                    var watiDuration: Number = 60
                    showOverflay.value = true
                    clearTimeout(tid.value)
                    tid.value = setTimeout(fun() {
                        if (elementRef.value == null || xDrawerWrapContentRef.value == null) {
                            return
                        }
                        elementRef.value!!.style.setProperty("transition-duration", _duration.value.toString(10) + "ms")
                        xDrawerWrapContentRef.value!!.style.setProperty("transition-duration", _duration.value.toString(10) + "ms")
                        elementRef.value!!.style.setProperty("opacity", "1")
                        xDrawerWrapContentRef.value!!.style.setProperty("transform", "scale(1)")
                        xDrawerWrapContentRef.value!!.style.setProperty("opacity", "1")
                        onEnd()
                    }, watiDuration)
                } else if (status.value == "close") {
                    elementRef.value!!.style.setProperty("transition-duration", _duration.value.toString(10) + "ms")
                    xDrawerWrapContentRef.value!!.style.setProperty("transition-duration", _duration.value.toString(10) + "ms")
                    elementRef.value!!.style.setProperty("opacity", "0")
                    xDrawerWrapContentRef.value!!.style.setProperty("transform", "scale(0.64)")
                    xDrawerWrapContentRef.value!!.style.setProperty("opacity", "0")
                    onEnd()
                }
            }
            val closeAlert = fun(){
                if (actioning.value) {
                    return
                }
                if (status.value == "close") {
                    return
                }
                status.value = "close"
                emit("beforeClose")
                setStyleAni()
            }
            val cancelEvt = fun(){
                emit("cancel")
                closeAlert()
            }
            val confirmEvt = fun(): UTSPromise<Any> {
                return wrapUTSPromise(suspend w1@{
                        isLoading.value = true
                        var isCanClose = await(props.beforeClose())
                        isLoading.value = false
                        if (!isCanClose) {
                            return@w1 UTSPromise.resolve(true)
                        }
                        emit("confirm")
                        closeAlert()
                        return@w1 UTSPromise.resolve(false)
                })
            }
            val onClickOverflowy = fun(evt: UniPointerEvent){
                evt.stopPropagation()
                emit("click")
                if (isLoading.value) {
                    return
                }
                if (!props.overlayClick) {
                    var el = xModalWrapBoxRef.value as UniElement?
                    if (xani.value != null) {
                        xani.value!!.stop()
                        xani.value = null
                    }
                    if (el != null) {
                        xani.value = xAnimate(el!!, XANIMATE_OPIONS(duration = 100, isDescPlay = true))
                        xani.value!!.attr("scale", "1", "0.95", false).attr("scale", "0.95", "1.05", false).attr("scale", "1.05", "1", false).play()
                    }
                    return
                }
                closeAlert()
            }
            val showAlert = fun(){
                if (actioning.value) {
                    return
                }
                if (status.value == "open") {
                    return
                }
                showOverflay.value = true
                status.value = "open"
                emit("beforeOpen")
                setStyleAni()
            }
            val openDrawer = fun(){
                showAlert()
            }
            val maskerMove = fun(evt: UniTouchEvent){}
            onMounted(fun(){
                fun oninitready() {
                    var sys = uni_getWindowInfo()
                    _width.value = sys.windowWidth
                    _height.value = sys.windowHeight
                    windtop.value = sys.windowTop
                    if (_show.value) {
                        showAlert()
                    }
                }
                oninitready()
            }
            )
            onUpdated(fun(){})
            onBeforeUnmount(fun(){
                if (xani.value != null) {
                    xani.value!!.stop()
                    xani.value = null
                }
                clearTimeout(tid.value)
                clearTimeout(tid2.value)
            }
            )
            watch(fun(): Boolean {
                return props.show
            }
            , fun(newVal: Boolean){
                if (newVal) {
                    showAlert()
                } else {
                    closeAlert()
                }
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
                val _component_tmx_text = resolveEasyComponent("tmx-text", GenUniModulesTmxUiComponentsTmxTextTmxTextClass)
                val _component_tmx_button = resolveEasyComponent("tmx-button", GenUniModulesTmxUiComponentsTmxButtonTmxButtonClass)
                return _cE("view", null, _uA(
                    _cE("view", _uM("onClick" to openDrawer), _uA(
                        renderSlot(_ctx.`$slots`, "trigger")
                    )),
                    if (isTrue(showOverflay.value)) {
                        _cE("view", _uM("key" to 0, "onClick" to onClickOverflowy, "onTouchmove" to maskerMove, "ref_key" to "elementRef", "ref" to elementRef, "id" to id.value, "class" to "xDrawerWrap xDrawerWrap_center", "style" to _nS(_uA(
                            _uM("top" to (windtop.value + "px"), "zIndex" to _ctx.zIndex, "width" to "100%", "height" to __height.value, "transition-timing-function" to _animationFun.value),
                            _customStyle.value
                        ))), _uA(
                            _cE("view", _uM("onClick" to withModifiers(fun(){}, _uA(
                                "stop"
                            )), "ref_key" to "xDrawerWrapContentRef", "ref" to xDrawerWrapContentRef, "class" to "xDrawerWrapContent xDrawerWrapContent_center", "id" to wrapId.value, "style" to _nS(_uM("width" to _c_width.value, "height" to _c_height.value, "maxWidth" to "750px", "borderRadius" to _round.value, "maxHeight" to if (_maxHeight.value != "") {
                                _maxHeight.value
                            } else {
                                "100%"
                            }, "backgroundColor" to _bgColor.value, "transition-timing-function" to "cubic-bezier(0.07, 0.82, 0.17, 1.20)"))), _uA(
                                _cE("view", _uM("ref_key" to "xModalWrapBoxRef", "ref" to xModalWrapBoxRef, "class" to "xModalWrapBox", "style" to _nS(_uM("borderRadius" to _round.value))), _uA(
                                    _cE("view", _uM("class" to "xDrawerXclose"), _uA(
                                        if (isTrue(_showClose.value)) {
                                            _cV(_component_tmx_icon, _uM("key" to 0, "onClick" to closeAlert, "color" to _ctx.closeColor, "dark-color" to _ctx.closeDarkColor, "font-size" to "21", "name" to _closeIcon.value), null, 8, _uA(
                                                "color",
                                                "dark-color",
                                                "name"
                                            ))
                                        } else {
                                            _cC("v-if", true)
                                        }
                                    )),
                                    _cE("view", null, _uA(
                                        if (isTrue(_showTitle.value)) {
                                            _cE("view", _uM("key" to 0, "class" to "xDrawerTitleBox"), _uA(
                                                renderSlot(_ctx.`$slots`, "title", _uO(), fun(): UTSArray<Any> {
                                                    return _uA(
                                                        _cV(_component_tmx_text, _uM("font-size" to "17", "class" to "xDrawertitleBoxTitle"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                            return _uA(
                                                                _tD(_title.value)
                                                            )
                                                        }), "_" to 1))
                                                    )
                                                })
                                            ))
                                        } else {
                                            _cC("v-if", true)
                                        }
                                    )),
                                    if (isTrue(!_disabledScroll.value)) {
                                        _cE("scroll-view", _uM("key" to 0, "style" to _nS(_uM("flex" to "1")), "scroll-y" to true, "rebound" to false), _uA(
                                            _cE("view", _uM("style" to _nS(_uM("padding" to _contentPadding.value))), _uA(
                                                renderSlot(_ctx.`$slots`, "default")
                                            ), 4)
                                        ), 4)
                                    } else {
                                        _cC("v-if", true)
                                    },
                                    if (isTrue(_disabledScroll.value)) {
                                        _cE("view", _uM("key" to 1, "style" to _nS(_uM("flex" to "1", "padding" to _contentPadding.value))), _uA(
                                            renderSlot(_ctx.`$slots`, "default")
                                        ), 4)
                                    } else {
                                        _cC("v-if", true)
                                    },
                                    if (isTrue(_ctx.showFooter)) {
                                        _cE("view", _uM("key" to 2, "class" to "xDrawerFooter", "style" to _nS(_uM("backgroundColor" to _bgColor.value))), _uA(
                                            renderSlot(_ctx.`$slots`, "footer", _uO(), fun(): UTSArray<Any> {
                                                return _uA(
                                                    if (isTrue(_showCancel.value)) {
                                                        _cV(_component_tmx_button, _uM("key" to 0, "disabled" to isLoading.value, "color" to _btnColor.value, "onClick" to cancelEvt, "skin" to "thin", "width" to "0px", "block" to true, "style" to _nS(_uM("margin-right" to "16px", "flex" to "1"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
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
                                                    _cV(_component_tmx_button, _uM("loading" to isLoading.value, "color" to _btnColor.value, "onClick" to confirmEvt, "width" to "0px", "block" to true, "style" to _nS(_uM("flex" to "1"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                        return _uA(
                                                            _tD(_confirmText.value)
                                                        )
                                                    }), "_" to 1), 8, _uA(
                                                        "loading",
                                                        "color",
                                                        "style"
                                                    ))
                                                )
                                            })
                                        ), 4)
                                    } else {
                                        _cC("v-if", true)
                                    }
                                ), 4)
                            ), 12, _uA(
                                "onClick",
                                "id"
                            ))
                        ), 44, _uA(
                            "id"
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                ))
            }
        }
        var name = "xModal"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("xModalWrapBox" to _pS(_uM("display" to "flex", "flexDirection" to "column", "height" to "100%", "width" to "100%", "position" to "relative")), "xDrawerFooter" to _pS(_uM("width" to "100%", "paddingTop" to 20, "paddingRight" to 16, "paddingBottom" to 16, "paddingLeft" to 16, "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "display" to "flex")), "xDrawerXclose" to _pS(_uM("position" to "absolute", "right" to 12, "top" to 6, "zIndex" to 100)), "xDrawertitleBoxTitle" to _pS(_uM("fontSize" to 16)), "xDrawerTitleBox" to _pS(_uM("height" to 60, "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center")), "xDrawertitleBox" to _pS(_uM("maxWidth" to 350, "overflow" to "hidden", "lines" to 1, "textOverflow" to "ellipsis", "fontSize" to 14)), "xDrawerWrap_center" to _pS(_uM("display" to "flex", "flexDirection" to "column", "justifyContent" to "center", "alignItems" to "center")), "xDrawerWrapContent" to _pS(_uM("transitionDuration" to "350ms", "transitionProperty" to "transform,opacity", "display" to "flex", "flexDirection" to "column")), "xDrawerWrapContent_center" to _pS(_uM("transform" to "scale(0.64)", "opacity" to 0)), "xDrawerWrap" to _pS(_uM("backgroundImage" to "none", "backgroundColor" to "rgba(0,0,0,0.4)", "opacity" to 0, "position" to "fixed", "left" to 0, "top" to 0, "transitionDuration" to "350ms", "transitionProperty" to "opacity")), "@TRANSITION" to _uM("xDrawerWrapContent" to _uM("duration" to "350ms", "property" to "transform,opacity"), "xDrawerWrap" to _uM("duration" to "350ms", "property" to "opacity")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("click" to null, "close" to null, "open" to null, "beforeOpen" to null, "beforeClose" to null, "update:show" to null, "cancel" to null, "confirm" to null)
        var props = _nP(_uM("customStyle" to _uM("type" to "String", "required" to true, "default" to ""), "title" to _uM("type" to "String", "required" to true, "default" to ""), "showFooter" to _uM("type" to "Boolean", "required" to true, "default" to true), "showTitle" to _uM("type" to "Boolean", "required" to true, "default" to true), "showClose" to _uM("type" to "Boolean", "required" to true, "default" to false), "showCancel" to _uM("type" to "Boolean", "required" to true, "default" to true), "overlayClick" to _uM("type" to "Boolean", "required" to true, "default" to true), "show" to _uM("type" to "Boolean", "required" to true, "default" to false), "duration" to _uM("type" to "Number", "required" to true, "default" to 300), "watiDuration" to _uM("type" to "Number", "required" to true, "default" to 120), "cancelText" to _uM("type" to "String", "required" to true, "default" to ""), "confirmText" to _uM("type" to "String", "required" to true, "default" to ""), "round" to _uM("type" to "String", "required" to true, "default" to ""), "width" to _uM("type" to "String", "required" to true, "default" to "84%"), "height" to _uM("type" to "String", "required" to true, "default" to "240px"), "maxHeight" to _uM("type" to "String", "required" to true, "default" to "80%"), "disabledScroll" to _uM("type" to "Boolean", "required" to true, "default" to false), "bgColor" to _uM("type" to "String", "required" to true, "default" to "white"), "darkBgColor" to _uM("type" to "String", "required" to true, "default" to ""), "zIndex" to _uM("type" to "String", "required" to true, "default" to "1105"), "contentPadding" to _uM("type" to "String", "required" to true, "default" to "16"), "btnColor" to _uM("type" to "String", "required" to true, "default" to ""), "beforeClose" to _uM("type" to "Function", "required" to true, "default" to fun(): UTSPromise<Boolean> {
            return UTSPromise.resolve(true)
        }
        ), "closeColor" to _uM("type" to "String", "required" to true, "default" to "#e6e6e6"), "closeDarkColor" to _uM("type" to "String", "required" to true, "default" to "#545454")))
        var propsNeedCastKeys = _uA(
            "customStyle",
            "title",
            "showFooter",
            "showTitle",
            "showClose",
            "showCancel",
            "overlayClick",
            "show",
            "duration",
            "watiDuration",
            "cancelText",
            "confirmText",
            "round",
            "width",
            "height",
            "maxHeight",
            "disabledScroll",
            "bgColor",
            "darkBgColor",
            "zIndex",
            "contentPadding",
            "btnColor",
            "beforeClose",
            "closeColor",
            "closeDarkColor"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
