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
import io.dcloud.uniapp.extapi.navigateBack as uni_navigateBack
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
import io.dcloud.uniapp.extapi.reLaunch as uni_reLaunch
import io.dcloud.uniapp.extapi.redirectTo as uni_redirectTo
import io.dcloud.uniapp.extapi.switchTab as uni_switchTab
open class GenUniModulesTmxUiComponentsTmxButtonTmxButton : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var color: String by `$props`
    open var darkColor: String by `$props`
    open var bgColor: String by `$props`
    open var linearGradient: UTSArray<String> by `$props`
    open var fontColor: String by `$props`
    open var fontDarkColor: String by `$props`
    open var fontSize: String by `$props`
    open var round: String by `$props`
    open var border: Number by `$props`
    open var shadow: UTSArray<Number> by `$props`
    open var borderColor: String by `$props`
    open var skin: String by `$props`
    open var icon: String by `$props`
    open var iconBtn: Boolean by `$props`
    open var iconSize: String by `$props`
    open var size: String by `$props`
    open var url: String by `$props`
    open var navigateMode: String by `$props`
    open var disabled: Boolean by `$props`
    open var loading: Boolean by `$props`
    open var height: String by `$props`
    open var width: String by `$props`
    open var block: Boolean by `$props`
    open var formType: String by `$props`
    open var lineHeight: String by `$props`
    open var fontWeight: String by `$props`
    open var openType: String by `$props`
    open var lang: String by `$props`
    open var sessionFrom: String by `$props`
    open var sendMessageTitle: String by `$props`
    open var sendMessagePath: String by `$props`
    open var sendMessageImg: String by `$props`
    open var appParameter: String by `$props`
    open var showMessageCard: Boolean by `$props`
    open var phoneNumberNoQuotaToast: Boolean by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesTmxUiComponentsTmxButtonTmxButton) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesTmxUiComponentsTmxButtonTmxButton
            val _cache = __ins.renderCache
            val props = __props
            fun emits(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val instance = getCurrentInstance()
            val proxy = instance?.proxy ?: null
            val _isHover = ref(false)
            val _color = computed(fun(): String {
                var color = props.color
                if (xConfig.dark == "dark" && props.darkColor != "") {
                    color = props.darkColor
                } else {
                    if (color == "") {
                        color = xConfig.color
                    }
                }
                return color
            }
            )
            val _fontSize = computed(fun(): String {
                var fontSize = props.fontSize
                if (fontSize == "") {
                    if (props.size == "mini") {
                        fontSize = "12"
                    }
                    if (props.size == "small") {
                        fontSize = "14"
                    }
                    if (props.size == "normal") {
                        fontSize = "16"
                    }
                    if (props.size == "large") {
                        fontSize = "17"
                    }
                }
                fontSize = checkIsCssUnit(fontSize, xConfig.unit)
                if (xConfig.fontScale == 1) {
                    return fontSize
                }
                var sizeNumber = parseInt(fontSize)
                if (isNaN(sizeNumber)) {
                    sizeNumber = 16
                }
                return (sizeNumber * xConfig.fontScale).toString(10) + getUnit(props.fontSize)
            }
            )
            val _iconSize = computed(fun(): String {
                if (props.iconSize != "") {
                    var fontSize = checkIsCssUnit(props.iconSize, xConfig.unit)
                    if (xConfig.fontScale == 1) {
                        return fontSize
                    }
                    var sizeNumber = parseInt(fontSize)
                    if (isNaN(sizeNumber)) {
                        sizeNumber = 16
                    }
                    return (sizeNumber * xConfig.fontScale).toString(10) + getUnit(props.fontSize)
                }
                return _fontSize.value
            }
            )
            val _radius = computed(fun(): String {
                var radius = props.round
                if (radius == "") {
                    radius = xConfig.buttonRadius
                    if (props.size == "mini") {
                        radius = "6"
                    }
                    if (props.size == "small") {
                        radius = "8"
                    }
                }
                return checkIsCssUnit(radius, xConfig.unit)
            }
            )
            val _height = computed(fun(): String {
                if (props.height != "") {
                    return checkIsCssUnit(props.height, xConfig.unit)
                }
                if (props.size == "mini") {
                    return checkIsCssUnit("28", xConfig.unit)
                }
                if (props.size == "small") {
                    return checkIsCssUnit("34", xConfig.unit)
                }
                if (props.size == "normal") {
                    return checkIsCssUnit("42", xConfig.unit)
                }
                return checkIsCssUnit("52", xConfig.unit)
            }
            )
            val _width = computed(fun(): String {
                if (props.iconBtn) {
                    return _height.value
                }
                if (props.block) {
                    return "100%"
                }
                if (props.width != "") {
                    return checkIsCssUnit(props.width, xConfig.unit)
                }
                if (props.size == "mini") {
                    return checkIsCssUnit("46", xConfig.unit)
                }
                if (props.size == "small") {
                    return checkIsCssUnit("60", xConfig.unit)
                }
                if (props.size == "normal") {
                    return checkIsCssUnit("98", xConfig.unit)
                }
                if (props.size == "large") {
                    return checkIsCssUnit("128", xConfig.unit)
                }
                return checkIsCssUnit(props.width, xConfig.unit)
            }
            )
            val _resolvedColors = computed(fun(): _ColorResult {
                var hover = _isHover.value
                var dePrimarycolor = getDefaultColor(xConfig.color)
                var color = getDefaultColor(_color.value)
                var hoverColor = if (props.color == "info") {
                    getDefaultColor(xConfig.color)
                } else {
                    color
                }
                var colorInit: UTSJSONObject = getDefaultColorObj(color, hoverColor, xConfig.dark == "dark")
                var borderStyle = "solid"
                if (props.skin == "text") {
                    colorInit = getTextColorObj(color, hoverColor, xConfig.dark == "dark")
                } else if (props.skin == "thin") {
                    colorInit = getThinColorObj(color, hoverColor, xConfig.dark == "dark")
                } else if (props.skin == "outline" || props.skin == "dashed") {
                    colorInit = getOutlineColorObj(color, hoverColor, xConfig.dark == "dark")
                }
                if (props.skin == "dashed") {
                    borderStyle = "dashed"
                }
                var stateObj: UTSJSONObject = if (hover) {
                    colorInit.getJSON("active")!!
                } else {
                    colorInit.getJSON("default")!!
                }
                var borderWidth = checkIsCssUnit(props.border.toString(10), "rpx")
                var dbordercolor = getDefaultColor(props.borderColor)
                var background = getDefaultColor(props.bgColor)
                var fontcolor = getDefaultColor(props.fontColor)
                var resultBorder = "" + borderWidth + " " + borderStyle + " " + (if (dbordercolor == "") {
                    stateObj.getString("borderColor")!!
                } else {
                    dbordercolor
                }
                )
                var realBackground = if (background == "") {
                    stateObj.getString("background")!!
                } else {
                    background
                }
                var realColor = fontcolor
                if (props.color == "info") {
                    realColor = dePrimarycolor
                } else {
                    realColor = if (fontcolor == "") {
                        stateObj.getString("fontColor")!!
                    } else {
                        fontcolor
                    }
                }
                var realBackImg = ""
                if (props.linearGradient.length > 0) {
                    var dirs = props.linearGradient[0]
                    if (dirs == "top") {
                        dirs = "to top"
                    } else if (dirs == "bottom") {
                        dirs = "to bottom"
                    } else if (dirs == "left") {
                        dirs = "to left"
                    } else if (dirs == "right") {
                        dirs = "to right"
                    }
                    realBackground = ""
                    realBackImg = "linear-gradient(" + dirs + "," + props.linearGradient[1] + "," + props.linearGradient[2] + ")"
                }
                if (props.fontDarkColor != "" && xConfig.dark == "dark") {
                    realColor = getDefaultColor(props.fontDarkColor)
                }
                return _ColorResult(border = resultBorder, background = realBackground, backgroundImage = realBackImg, fontColor = realColor)
            }
            )
            val _styleMap = computed(fun(): Map<String, Any> {
                var cs = _resolvedColors.value
                val styleMap = Map<String, Any>()
                styleMap.set("width", _width.value)
                styleMap.set("height", _height.value)
                styleMap.set("border", cs.border)
                styleMap.set("backgroundColor", cs.background)
                if (cs.backgroundImage != "") {
                    styleMap.set("backgroundImage", cs.backgroundImage)
                }
                styleMap.set("borderRadius", _radius.value)
                styleMap.set("opacity", if ((props.disabled || props.loading)) {
                    "0.5"
                } else {
                    "1"
                }
                )
                return styleMap
            }
            )
            fun gen_findParent_fn(parent: VueComponent?): VueComponent? {
                if (parent == null) {
                    return null
                }
                if (parent.`$parent` is TmxFormComponentPublicInstance) {
                    return parent.`$parent`
                }
                var parents = gen_findParent_fn(parent.`$parent`)
                if (parents is TmxFormComponentPublicInstance) {
                    return parents
                }
                return null
            }
            val findParent = ::gen_findParent_fn
            fun gen_formSubmit_fn() {
                var pelement = findParent(proxy)
                if (pelement == null) {
                    return
                }
                var parent: TmxFormComponentPublicInstance = pelement as TmxFormComponentPublicInstance
                parent.submit()
            }
            val formSubmit = ::gen_formSubmit_fn
            fun gen_touchStart_fn() {
                if (props.disabled || props.loading) {
                    return
                }
                _isHover.value = true
            }
            val touchStart = ::gen_touchStart_fn
            fun gen_touchCacel_fn() {
                _isHover.value = false
            }
            val touchCacel = ::gen_touchCacel_fn
            fun gen_touchEnd_fn() {
                _isHover.value = false
            }
            val touchEnd = ::gen_touchEnd_fn
            fun gen_clickListen_fn(e: UniPointerEvent) {
                if (!props.disabled && !props.loading) {
                    emits("click", e)
                    if (props.formType == "form") {
                        formSubmit()
                    }
                }
                if (!props.disabled && props.url != "" && !props.loading) {
                    if (props.navigateMode == "navigateTo") {
                        uni_navigateTo(NavigateToOptions(url = props.url, fail = fun(error){
                            console.error(error)
                        }))
                    } else if (props.navigateMode == "redirectTo") {
                        uni_redirectTo(RedirectToOptions(url = props.url, fail = fun(error){
                            console.error(error)
                        }))
                    } else if (props.navigateMode == "switchTab") {
                        uni_switchTab(SwitchTabOptions(url = props.url, fail = fun(error){
                            console.error(error)
                        }))
                    } else if (props.navigateMode == "reLaunch") {
                        uni_reLaunch(ReLaunchOptions(url = props.url, fail = fun(error){
                            console.error(error)
                        }))
                    } else if (props.navigateMode == "navigateBack") {
                        uni_navigateBack(NavigateBackOptions(fail = fun(error){
                            console.error(error)
                        }
                        ))
                    }
                }
            }
            val clickListen = ::gen_clickListen_fn
            return fun(): Any? {
                val _component_tmx_icon = resolveEasyComponent("tmx-icon", GenUniModulesTmxUiComponentsTmxIconTmxIconClass)
                return _cE("view", _uM("onTouchcancel" to touchCacel, "onTouchend" to touchEnd, "onTouchstart" to touchStart, "onClick" to clickListen, "style" to _nS(_styleMap.value), "class" to _nC(_uA(
                    "parentButton",
                    _uA(
                        if (_ctx.disabled || _ctx.loading) {
                            "noDrag"
                        } else {
                            ""
                        }
                    )
                ))), _uA(
                    _cE("view", _uM("class" to _nC(_uA(
                        "xButton",
                        if (_ctx.loading) {
                            "load"
                        } else {
                            ""
                        }
                    ))), _uA(
                        if (isTrue(_ctx.icon != "" && !_ctx.loading)) {
                            _cV(_component_tmx_icon, _uM("key" to 0, "style" to _nS(_uM("marginRight" to if (_ctx.iconBtn) {
                                "0px"
                            } else {
                                " 3px"
                            })), "font-size" to _iconSize.value, "color" to _resolvedColors.value.fontColor, "name" to _ctx.icon), null, 8, _uA(
                                "style",
                                "font-size",
                                "color",
                                "name"
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        if (isTrue(_ctx.loading)) {
                            _cV(_component_tmx_icon, _uM("key" to 1, "color" to _resolvedColors.value.fontColor, "font-size" to _iconSize.value, "spin" to true, "name" to "loader-fill"), null, 8, _uA(
                                "color",
                                "font-size"
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        if (isTrue(!_ctx.iconBtn)) {
                            _cE("text", _uM("key" to 2, "style" to _nS(_uM("fontWeight" to _ctx.fontWeight, "color" to _resolvedColors.value.fontColor, "fontSize" to _fontSize.value, "lineHeight" to _ctx.lineHeight))), _uA(
                                renderSlot(_ctx.`$slots`, "default")
                            ), 4)
                        } else {
                            _cC("v-if", true)
                        }
                    ), 2)
                ), 38)
            }
        }
        var name = "xButton"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("parentButton" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center", "position" to "relative")), "xButton" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center", "width" to "100%", "height" to "100%")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("click" to null, "getuserinfo" to null, "contact" to null, "getphonenumber" to null, "getrealtimephonenumber" to null, "error" to null, "opensetting" to null, "launchapp" to null, "chooseavatar" to null, "chooseaddress" to null, "chooseinvoicetitle" to null, "addgroupapp" to null, "subscribe" to null, "login" to null, "agreeprivacyauthorization" to null)
        var props = _nP(_uM("color" to _uM("type" to "String", "required" to true, "default" to ""), "darkColor" to _uM("type" to "String", "required" to true, "default" to ""), "bgColor" to _uM("type" to "String", "required" to true, "default" to ""), "linearGradient" to _uM("type" to "Array", "required" to true, "default" to fun(): UTSArray<String> {
            return _uA<String>()
        }
        ), "fontColor" to _uM("type" to "String", "required" to true, "default" to ""), "fontDarkColor" to _uM("type" to "String", "required" to true, "default" to ""), "fontSize" to _uM("type" to "String", "required" to true, "default" to ""), "round" to _uM("type" to "String", "required" to true, "default" to ""), "border" to _uM("type" to "Number", "required" to true, "default" to 0.5), "shadow" to _uM("type" to "Array", "required" to true, "default" to fun(): UTSArray<Number> {
            return _uA<Number>()
        }
        ), "borderColor" to _uM("type" to "String", "required" to true, "default" to ""), "skin" to _uM("type" to "String", "required" to true, "default" to "default" as SkinType), "icon" to _uM("type" to "String", "required" to true, "default" to ""), "iconBtn" to _uM("type" to "Boolean", "required" to true, "default" to false), "iconSize" to _uM("type" to "String", "required" to true, "default" to ""), "size" to _uM("type" to "String", "required" to true, "default" to "normal" as SizeType), "url" to _uM("type" to "String", "required" to true, "default" to ""), "navigateMode" to _uM("type" to "String", "required" to true, "default" to "navigateTo"), "disabled" to _uM("type" to "Boolean", "required" to true, "default" to false), "loading" to _uM("type" to "Boolean", "required" to true, "default" to false), "height" to _uM("type" to "String", "required" to true, "default" to ""), "width" to _uM("type" to "String", "required" to true, "default" to ""), "block" to _uM("type" to "Boolean", "required" to true, "default" to false), "formType" to _uM("type" to "String", "required" to true, "default" to "" as String), "lineHeight" to _uM("type" to "String", "required" to true, "default" to "1.4"), "fontWeight" to _uM("type" to "String", "required" to true, "default" to "normal"), "openType" to _uM("type" to "String", "required" to true, "default" to ""), "lang" to _uM("type" to "String", "required" to true, "default" to "en"), "sessionFrom" to _uM("type" to "String", "required" to true, "default" to ""), "sendMessageTitle" to _uM("type" to "String", "required" to true, "default" to ""), "sendMessagePath" to _uM("type" to "String", "required" to true, "default" to ""), "sendMessageImg" to _uM("type" to "String", "required" to true, "default" to ""), "appParameter" to _uM("type" to "String", "required" to true, "default" to ""), "showMessageCard" to _uM("type" to "Boolean", "required" to true, "default" to false), "phoneNumberNoQuotaToast" to _uM("type" to "Boolean", "required" to true, "default" to true)))
        var propsNeedCastKeys = _uA(
            "color",
            "darkColor",
            "bgColor",
            "linearGradient",
            "fontColor",
            "fontDarkColor",
            "fontSize",
            "round",
            "border",
            "shadow",
            "borderColor",
            "skin",
            "icon",
            "iconBtn",
            "iconSize",
            "size",
            "url",
            "navigateMode",
            "disabled",
            "loading",
            "height",
            "width",
            "block",
            "formType",
            "lineHeight",
            "fontWeight",
            "openType",
            "lang",
            "sessionFrom",
            "sendMessageTitle",
            "sendMessagePath",
            "sendMessageImg",
            "appParameter",
            "showMessageCard",
            "phoneNumberNoQuotaToast"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
