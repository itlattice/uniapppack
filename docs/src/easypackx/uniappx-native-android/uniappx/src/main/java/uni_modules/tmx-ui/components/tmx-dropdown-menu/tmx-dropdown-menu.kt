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
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
open class GenUniModulesTmxUiComponentsTmxDropdownMenuTmxDropdownMenu : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var position: String by `$props`
    open var offsetTop: String by `$props`
    open var modelValue: Number by `$props`
    open var height: String by `$props`
    open var width: String by `$props`
    open var color: String by `$props`
    open var darkColor: String by `$props`
    open var zIndex: Number by `$props`
    open var hidnMask: Boolean by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    open var addMenu: (obj: XDROPDOWN_LISTITEM_INFO_TYPE) -> Unit
        get() {
            return unref(this.`$exposed`["addMenu"]) as (obj: XDROPDOWN_LISTITEM_INFO_TYPE) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "addMenu", value)
        }
    open var delMenu: (id: String) -> Unit
        get() {
            return unref(this.`$exposed`["delMenu"]) as (id: String) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "delMenu", value)
        }
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesTmxUiComponentsTmxDropdownMenuTmxDropdownMenu, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesTmxUiComponentsTmxDropdownMenuTmxDropdownMenu
            val _cache = __ins.renderCache
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val props = __props
            val _width = ref(0)
            val _height = ref(0)
            val menubarNodeino = ref<NODE_INFO?>(null)
            val nowIndex = ref(-1)
            val opended = ref(false)
            val cacheListItem = ref(_uA<XDROPDOWN_LISTITEM_TYPE>())
            val windtop = ref(0)
            var tid: Number = 23
            val maskMoveX = ref(0)
            val maskMoveY = ref(0)
            var maskTouchTime: Number = 0
            val xDropMenuRef = ref<UniElement?>(null)
            val proxy = getCurrentInstance()?.proxy
            val _cutomhHeight = computed(fun(): String {
                return checkIsCssUnit(props.height, xConfig.unit)
            }
            )
            val _cutomWidth = computed(fun(): String {
                return checkIsCssUnit(props.width, xConfig.unit)
            }
            )
            val _color = computed(fun(): String {
                if (xConfig.dark == "dark") {
                    if (props.darkColor != "") {
                        return getDefaultColor(props.darkColor)
                    }
                    return getDefaultColor(xConfig.sheetDarkColor)
                }
                return getDefaultColor(props.color)
            }
            )
            val _offsetTop = computed(fun(): Number {
                if (props.position == "static") {
                    return windtop.value
                }
                var height = checkIsCssUnit(props.offsetTop, xConfig.unit)
                var unit = getUnit(height)
                var realheight = parseInt(height)
                if (unit == "rpx") {
                    realheight = rpx2px(realheight)
                }
                return realheight + windtop.value
            }
            )
            val menuLeft = computed(fun(): String {
                if (menubarNodeino.value == null) {
                    return ""
                }
                if (props.position == "fixed") {
                    return "0px"
                }
                return menubarNodeino.value!!.left.toString(10) + "px"
            }
            )
            val menuWidth = computed(fun(): String {
                if (menubarNodeino.value == null) {
                    return ""
                }
                if (props.position == "fixed") {
                    return "100%"
                }
                return menubarNodeino.value!!.width.toString(10) + "px"
            }
            )
            val menuTop = computed(fun(): String {
                if (menubarNodeino.value == null) {
                    return ""
                }
                if (props.position == "fixed") {
                    return _offsetTop.value + "px"
                }
                var parentTop = menubarNodeino.value!!.top
                return parentTop.toString(10) + "px"
            }
            )
            val nowItemIsBtn = computed(fun(): Boolean {
                if (nowIndex.value <= -1 || nowIndex.value >= cacheListItem.value.length || cacheListItem.value.length == 0) {
                    return false
                }
                var item = cacheListItem.value[nowIndex.value]
                return item.data.isBtn
            }
            )
            val __height = computed(fun(): String {
                var h = "100%"
                return h
            }
            )
            provide("xDropdownMenuNowKeyName", computed(fun(): String {
                if (nowIndex.value == -1) {
                    return ""
                }
                if (nowIndex.value > cacheListItem.value.length - 1) {
                    return ""
                }
                return cacheListItem.value[nowIndex.value].data.keyName
            }
            ))
            val getNodes = fun(){
                if (xDropMenuRef.value == null) {
                    return
                }
                xDropMenuRef.value!!.getBoundingClientRectAsync()?.then(fun(nodeinfo: DOMRect){
                    menubarNodeino.value = NODE_INFO(left = nodeinfo.left!!, width = nodeinfo.width!!, height = nodeinfo.height!!, bottom = nodeinfo.bottom!!, right = nodeinfo.right!!, top = nodeinfo.top!!)
                }
                )
            }
            watch(fun(): Number {
                return props.modelValue
            }
            , fun(newValue: Number){
                if (nowIndex.value == newValue) {
                    return
                }
                if (newValue == -1) {
                    nowIndex.value = -1
                    opended.value = false
                    return
                }
                nowIndex.value = newValue
            }
            )
            val addMenu = fun(obj: XDROPDOWN_LISTITEM_INFO_TYPE){
                var index = cacheListItem.value.findIndex(fun(el: XDROPDOWN_LISTITEM_TYPE): Boolean {
                    return el.id == obj.id
                }
                )
                if (index > -1) {
                    cacheListItem.value[index] = XDROPDOWN_LISTITEM_TYPE(id = obj.id, data = obj)
                } else {
                    cacheListItem.value.push(XDROPDOWN_LISTITEM_TYPE(id = obj.id, data = obj))
                }
            }
            val delMenu = fun(id: String){
                if (cacheListItem.value.length == 0) {
                    return
                }
                var index: Number = cacheListItem.value.findIndex(fun(el: XDROPDOWN_LISTITEM_TYPE): Boolean {
                    return el.id == id
                }
                )
                if (index > -1) {
                    if (index == nowIndex.value) {
                        nowIndex.value = -1
                    }
                    cacheListItem.value.splice(index, 1)
                }
            }
            val closeMenu = fun(){
                var nkey = ""
                try {
                    nkey = cacheListItem.value[nowIndex.value].data.keyName
                }
                 catch (e: Throwable) {}
                emit("change", nowIndex.value, nkey, false)
                nowIndex.value = -1
                opended.value = false
                emit("update:modelValue", nowIndex.value)
            }
            val openMenu = fun(index: Number){
                getNodes()
                nowIndex.value = index
                opended.value = true
                emit("update:modelValue", index)
                var nkey = ""
                try {
                    nkey = cacheListItem.value[index].data.keyName
                }
                 catch (e: Throwable) {}
                console.log(index)
                emit("change", index, nkey, true)
            }
            val menuClick = fun(index: Number){
                if (index == nowIndex.value) {
                    closeMenu()
                } else {
                    openMenu(index)
                }
            }
            val maskmStart = fun(evt: UniTouchEvent){
                evt.preventDefault()
                maskMoveX.value = evt.changedTouches[0].clientX
                maskMoveY.value = evt.changedTouches[0].clientY
                maskTouchTime = Date.now()
            }
            val maskmMove = fun(evt: UniTouchEvent){}
            val maskmEnd = fun(evt: UniTouchEvent){
                var diffx = evt.changedTouches[0].clientX - maskMoveX.value
                var diffy = evt.changedTouches[0].clientY - maskMoveY.value
                var difftime = Date.now() - maskTouchTime
                if (diffx == diffy && difftime > 50 && difftime < 250) {
                    closeMenu()
                }
            }
            onMounted(fun(){
                var sys = uni_getWindowInfo()
                _width.value = sys.windowWidth
                _height.value = sys.windowHeight + 44
                nowIndex.value = props.modelValue
                getNodes()
                uni__on("onResize", getNodes)
            }
            )
            onBeforeUnmount(fun(){
                uni__off("onResize", getNodes)
                clearTimeout(tid)
            }
            )
            __expose(_uM("addMenu" to addMenu, "delMenu" to delMenu))
            return fun(): Any? {
                val _component_tmx_icon = resolveEasyComponent("tmx-icon", GenUniModulesTmxUiComponentsTmxIconTmxIconClass)
                return _cE("view", _uM("class" to "xDropMenu", "ref_key" to "xDropMenuRef", "ref" to xDropMenuRef, "style" to _nS(_uM("width" to unref(_cutomWidth), "height" to unref(_cutomhHeight), "backgroundColor" to unref(_color)))), _uA(
                    _cE("view", _uM("class" to "xDropMenuBarStatic", "style" to _nS(_uM("height" to unref(_cutomhHeight), "visibility" to if (!unref(opended) || unref(nowItemIsBtn)) {
                        "visible"
                    } else {
                        "hidden"
                    }
                    ))), _uA(
                        _cE(Fragment, null, RenderHelpers.renderList(unref(cacheListItem), fun(item, index, __index, _cached): Any {
                            return _cE("view", _uM("onClick" to withModifiers(fun(){
                                menuClick(index)
                            }
                            , _uA(
                                "stop"
                            )), "class" to "xDropMenuBaritem", "key" to index), _uA(
                                _cE("text", _uM("style" to _nS(_uM("color" to if (unref(nowIndex) == index) {
                                    item.data.activeFontColor
                                } else {
                                    item.data.fontColor
                                }
                                , "fontSize" to item.data.fontSize))), _tD(item.data.title), 5),
                                if (isTrue(unref(nowIndex) == index && item.data.activeIcon != "")) {
                                    _cV(_component_tmx_icon, _uM("key" to 0, "style" to _nS(_uM("margin-left" to "5px")), "color" to if (unref(nowIndex) == index) {
                                        item.data.activeFontColor
                                    } else {
                                        item.data.fontColor
                                    }, "name" to item.data.activeIcon), null, 8, _uA(
                                        "style",
                                        "color",
                                        "name"
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                                ,
                                if (isTrue(unref(nowIndex) != index && item.data.icon != "")) {
                                    _cV(_component_tmx_icon, _uM("key" to 1, "style" to _nS(_uM("margin-left" to "5px")), "color" to if (unref(nowIndex) == index) {
                                        item.data.activeFontColor
                                    } else {
                                        item.data.fontColor
                                    }, "name" to item.data.icon), null, 8, _uA(
                                        "style",
                                        "color",
                                        "name"
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                            ), 8, _uA(
                                "onClick"
                            ))
                        }
                        ), 128)
                    ), 4),
                    if (isTrue(!_ctx.hidnMask)) {
                        _cE("view", _uM("key" to 0, "onTouchstart" to maskmStart, "onTouchmove" to maskmMove, "onTouchend" to maskmEnd, "class" to "xDropMenuWrap", "style" to _nS(_uM("width" to "100%", "height" to unref(__height), "display" to if (unref(opended) && !unref(nowItemIsBtn)) {
                            "flex"
                        } else {
                            "none"
                        }, "top" to (unref(_offsetTop) + "px"), "zIndex" to _ctx.zIndex.toString(), "position" to "fixed"))), null, 36)
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    _cE("view", _uM("onClick" to withModifiers(closeMenu, _uA(
                        "stop"
                    )), "class" to "xDropMenuWrapContent", "style" to _nS(_uM("width" to unref(menuWidth), "height" to "100%", "left" to unref(menuLeft), "top" to unref(menuTop), "zIndex" to (_ctx.zIndex + 1).toString(), "display" to if (unref(opended) && !unref(nowItemIsBtn)) {
                        "flex"
                    } else {
                        "none"
                    }
                    , "position" to "fixed"))), _uA(
                        _cE("view", _uM("class" to "xDropMenuBarStatic xDropMenuBarAbs", "style" to _nS(_uM("width" to unref(_cutomWidth), "height" to unref(_cutomhHeight), "backgroundColor" to unref(_color)))), _uA(
                            if (isTrue(unref(opended))) {
                                _cE(Fragment, _uM("key" to 0), RenderHelpers.renderList(unref(cacheListItem), fun(item, index, __index, _cached): Any {
                                    return _cE("view", _uM("onClick" to withModifiers(fun(){
                                        menuClick(index)
                                    }, _uA(
                                        "stop"
                                    )), "class" to "xDropMenuBaritem", "key" to index), _uA(
                                        _cE("text", _uM("style" to _nS(_uM("color" to if (unref(nowIndex) == index) {
                                            item.data.activeFontColor
                                        } else {
                                            item.data.fontColor
                                        }, "fontSize" to item.data.fontSize))), _tD(item.data.title), 5),
                                        if (isTrue(unref(nowIndex) == index && item.data.activeIcon != "")) {
                                            _cV(_component_tmx_icon, _uM("key" to 0, "style" to _nS(_uM("margin-left" to "5px")), "color" to if (unref(nowIndex) == index) {
                                                item.data.activeFontColor
                                            } else {
                                                item.data.fontColor
                                            }, "name" to item.data.activeIcon), null, 8, _uA(
                                                "style",
                                                "color",
                                                "name"
                                            ))
                                        } else {
                                            _cC("v-if", true)
                                        },
                                        if (isTrue(unref(nowIndex) != index && item.data.icon != "")) {
                                            _cV(_component_tmx_icon, _uM("key" to 1, "style" to _nS(_uM("margin-left" to "5px")), "color" to if (unref(nowIndex) == index) {
                                                item.data.activeFontColor
                                            } else {
                                                item.data.fontColor
                                            }, "name" to item.data.icon), null, 8, _uA(
                                                "style",
                                                "color",
                                                "name"
                                            ))
                                        } else {
                                            _cC("v-if", true)
                                        }
                                    ), 8, _uA(
                                        "onClick"
                                    ))
                                }), 128)
                            } else {
                                _cC("v-if", true)
                            }
                        ), 4),
                        _cE("view", _uM("class" to "xDropMenuBgColor", "style" to _nS(_uM("background-color" to if (unref(opended)) {
                            "rgba(0, 0, 0, 0.4)"
                        } else {
                            "rgba(0, 0, 0, 0)"
                        }
                        ))), _uA(
                            renderSlot(_ctx.`$slots`, "default")
                        ), 4)
                    ), 4)
                ), 4)
            }
        }
        var name = "xDropdownMenu"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("xDropMenuBgColor" to _pS(_uM("transitionDuration" to "300ms", "transitionProperty" to "backgroundColor", "transitionTimingFunction" to "linear", "overflow" to "hidden", "position" to "relative", "backgroundColor" to "rgba(0,0,0,0)", "transitionDelay" to "50ms", "flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "xDropMenu" to _pS(_uM("display" to "flex", "flexDirection" to "column")), "xDropMenuBaritem" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "height" to "100%", "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center")), "xDropMenuBarStatic" to _pS(_uM("display" to "flex", "flexDirection" to "row", "pointerEvents" to "auto")), "xDropMenuWrap" to _pS(_uM("position" to "fixed", "backgroundColor" to "rgba(0,0,0,0)", "left" to 0, "top" to 0)), "xDropMenuWrapContent" to _pS(_uM("left" to 0, "display" to "flex", "flexDirection" to "column")), "@TRANSITION" to _uM("xDropMenuBgColor" to _uM("duration" to "300ms", "property" to "backgroundColor", "timingFunction" to "linear", "delay" to "50ms")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("change" to null, "update:modelValue" to null)
        var props = _nP(_uM("position" to _uM("type" to "String", "default" to "fixed"), "offsetTop" to _uM("type" to "String", "default" to "0"), "modelValue" to _uM("type" to "Number", "default" to -1), "height" to _uM("type" to "String", "default" to "44"), "width" to _uM("type" to "String", "default" to "auto"), "color" to _uM("type" to "String", "default" to "white"), "darkColor" to _uM("type" to "String", "default" to ""), "zIndex" to _uM("type" to "Number", "default" to 88), "hidnMask" to _uM("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = _uA(
            "position",
            "offsetTop",
            "modelValue",
            "height",
            "width",
            "color",
            "darkColor",
            "zIndex",
            "hidnMask"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
