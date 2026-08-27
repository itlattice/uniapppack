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
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
open class GenUniModulesTmxUiComponentsTmxTagTmxTag : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var _class: String by `$props`
    open var _style: String by `$props`
    open var color: String by `$props`
    open var bgColor: String by `$props`
    open var darkBgColor: String by `$props`
    open var linearGradient: UTSArray<String> by `$props`
    open var fontColor: String by `$props`
    open var fontSize: String by `$props`
    open var round: Number by `$props`
    open var border: Number by `$props`
    open var borderColor: String by `$props`
    open var darkBorderColor: String by `$props`
    open var skin: String by `$props`
    open var icon: String by `$props`
    open var size: String by `$props`
    open var url: String by `$props`
    open var disabled: Boolean by `$props`
    open var loading: Boolean by `$props`
    open var height: String by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesTmxUiComponentsTmxTagTmxTag) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesTmxUiComponentsTmxTagTmxTag
            val _cache = __ins.renderCache
            val props = __props
            fun emits(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val _color = computed(fun(): String {
                var color = getDefaultColor(props.color)
                if (color == "") {
                    color = xConfig.color
                }
                return color
            }
            )
            val _fontSize = computed(fun(): String {
                var fontSize = props.fontSize
                if (fontSize == "") {
                    if (props.size == "mini") {
                        return checkIsCssUnit("10", xConfig.unit)
                    }
                    if (props.size == "small") {
                        return checkIsCssUnit("11", xConfig.unit)
                    }
                    if (props.size == "mdeium") {
                        return checkIsCssUnit("12", xConfig.unit)
                    }
                    if (props.size == "normal") {
                        return checkIsCssUnit("13", xConfig.unit)
                    }
                    if (props.size == "large") {
                        return checkIsCssUnit("14", xConfig.unit)
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
            val _radius = computed(fun(): String {
                if (props.round == -1) {
                    if (props.size == "mini") {
                        return checkIsCssUnit("4", xConfig.unit)
                    }
                    if (props.size == "small") {
                        return checkIsCssUnit("4", xConfig.unit)
                    }
                    if (props.size == "mdeium") {
                        return checkIsCssUnit("5", xConfig.unit)
                    }
                    if (props.size == "normal") {
                        return checkIsCssUnit(xConfig.tagRadius, xConfig.unit)
                    }
                    if (props.size == "large") {
                        return checkIsCssUnit("6", xConfig.unit)
                    }
                }
                return checkIsCssUnit(props.round.toString(10), xConfig.unit)
            }
            )
            val _padding = computed(fun(): String {
                if (props.size == "mini") {
                    return "0px 0px"
                }
                if (props.size == "small") {
                    return "0px " + checkIsCssUnit("3", xConfig.unit)
                }
                if (props.size == "mdeium") {
                    return "0px " + checkIsCssUnit("5", xConfig.unit)
                }
                if (props.size == "normal") {
                    return "0px " + checkIsCssUnit("8", xConfig.unit)
                }
                if (props.size == "large") {
                    return "0px " + checkIsCssUnit("12", xConfig.unit)
                }
                return "0rpx  " + checkIsCssUnit("8", xConfig.unit)
            }
            )
            val _height = computed(fun(): String {
                if (props.height != "") {
                    return checkIsCssUnit(props.height, xConfig.unit)
                }
                if (props.size == "mini") {
                    return checkIsCssUnit("15", xConfig.unit)
                }
                if (props.size == "small") {
                    return checkIsCssUnit("18", xConfig.unit)
                }
                if (props.size == "mdeium") {
                    return checkIsCssUnit("22", xConfig.unit)
                }
                if (props.size == "normal") {
                    return checkIsCssUnit("24", xConfig.unit)
                }
                return checkIsCssUnit("28", xConfig.unit)
            }
            )
            val _resolvedColors = computed(fun(): _TagColorResult {
                var color = getDefaultColor(_color.value)
                var hoverColor = color
                var opacity = if ((props.disabled || props.loading)) {
                    "0.7"
                } else {
                    "1"
                }
                var colorInit: UTSJSONObject = getDefaultColorObj(color, hoverColor)
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
                var defaultObj: UTSJSONObject = colorInit.getJSON("default")!!
                var borderWidth = checkIsCssUnit(props.border.toString(10), "rpx")
                var bordercolor = props.borderColor
                if (xConfig.dark == "dark" && props.darkBorderColor != "") {
                    bordercolor = props.darkBorderColor
                }
                var dbordercolor = getDefaultColor(bordercolor)
                var bgColor = props.bgColor
                if (xConfig.dark == "dark" && props.darkBgColor != "") {
                    bgColor = props.darkBgColor
                }
                var background = getDefaultColor(bgColor)
                var fontcolor = getDefaultColor(props.fontColor)
                var resultBorder = "" + borderWidth + " " + borderStyle + " " + (if (dbordercolor == "") {
                    defaultObj.getString("borderColor")!!
                } else {
                    dbordercolor
                }
                )
                var realBackground = if (background == "") {
                    defaultObj.getString("background")!!
                } else {
                    background
                }
                var realColor = if (fontcolor == "") {
                    defaultObj.getString("fontColor")!!
                } else {
                    fontcolor
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
                return _TagColorResult(border = resultBorder, background = realBackground, backgroundImage = realBackImg, fontColor = realColor, opacity = opacity)
            }
            )
            val _styleMap = computed(fun(): Map<String, Any> {
                var cs = _resolvedColors.value
                var styleMap = Map<String, Any>()
                styleMap.set("padding", _padding.value)
                styleMap.set("height", _height.value)
                styleMap.set("border", cs.border)
                styleMap.set("borderRadius", _radius.value)
                styleMap.set("backgroundColor", cs.background)
                if (cs.backgroundImage != "") {
                    styleMap.set("backgroundImage", cs.backgroundImage)
                }
                styleMap.set("opacity", cs.opacity)
                return styleMap
            }
            )
            fun gen_clickListen_fn(e: Any) {
                if (!props.disabled) {
                    emits("click", e)
                }
                if (!props.disabled && props.url != "") {
                    uni_navigateTo(NavigateToOptions(url = props.url))
                }
            }
            val clickListen = ::gen_clickListen_fn
            return fun(): Any? {
                val _component_tmx_icon = resolveEasyComponent("tmx-icon", GenUniModulesTmxUiComponentsTmxIconTmxIconClass)
                return _cE("view", _uM("disabled" to _ctx.disabled, "onClick" to clickListen, "class" to _nC(_uA(
                    _ctx._class,
                    "button"
                )), "style" to _nS(_styleMap.value)), _uA(
                    if (isTrue(_ctx.icon != "" && !_ctx.loading)) {
                        _cV(_component_tmx_icon, _uM("key" to 0, "style" to _nS(_uM("margin-right" to "3px")), "font-size" to _fontSize.value, "color" to _resolvedColors.value.fontColor, "name" to _ctx.icon), null, 8, _uA(
                            "style",
                            "font-size",
                            "color",
                            "name"
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    _cE("text", _uM("style" to _nS(_uM("color" to _resolvedColors.value.fontColor, "font-size" to _fontSize.value))), _uA(
                        renderSlot(_ctx.`$slots`, "default")
                    ), 4)
                ), 14, _uA(
                    "disabled"
                ))
            }
        }
        var name = "xTag"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("button" to _pS(_uM("flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "display" to "flex", "alignContent" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("click" to null)
        var props = _nP(_uM("_class" to _uM("type" to "String", "required" to true, "default" to ""), "_style" to _uM("type" to "String", "required" to true, "default" to ""), "color" to _uM("type" to "String", "required" to true, "default" to ""), "bgColor" to _uM("type" to "String", "required" to true, "default" to ""), "darkBgColor" to _uM("type" to "String", "required" to true, "default" to ""), "linearGradient" to _uM("type" to "Array", "required" to true, "default" to fun(): UTSArray<String> {
            return _uA<String>()
        }
        ), "fontColor" to _uM("type" to "String", "required" to true, "default" to ""), "fontSize" to _uM("type" to "String", "required" to true, "default" to ""), "round" to _uM("type" to "Number", "required" to true, "default" to -1), "border" to _uM("type" to "Number", "required" to true, "default" to 1), "borderColor" to _uM("type" to "String", "required" to true, "default" to ""), "darkBorderColor" to _uM("type" to "String", "required" to true, "default" to ""), "skin" to _uM("type" to "String", "required" to true, "default" to "default" as SkinType__1), "icon" to _uM("type" to "String", "required" to true, "default" to ""), "size" to _uM("type" to "String", "required" to true, "default" to "normal" as SizeType__1), "url" to _uM("type" to "String", "required" to true, "default" to ""), "disabled" to _uM("type" to "Boolean", "required" to true, "default" to false), "loading" to _uM("type" to "Boolean", "required" to true, "default" to false), "height" to _uM("type" to "String", "required" to true, "default" to "")))
        var propsNeedCastKeys = _uA(
            "_class",
            "_style",
            "color",
            "bgColor",
            "darkBgColor",
            "linearGradient",
            "fontColor",
            "fontSize",
            "round",
            "border",
            "borderColor",
            "darkBorderColor",
            "skin",
            "icon",
            "size",
            "url",
            "disabled",
            "loading",
            "height"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
