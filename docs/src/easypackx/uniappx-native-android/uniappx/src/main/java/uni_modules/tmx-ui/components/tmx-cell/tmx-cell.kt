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
import io.dcloud.uniapp.extapi.switchTab as uni_switchTab
open class GenUniModulesTmxUiComponentsTmxCellTmxCell : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var icon: String by `$props`
    open var avatarRound: String by `$props`
    open var color: String by `$props`
    open var darkColor: String by `$props`
    open var iconColor: String by `$props`
    open var title: String by `$props`
    open var titleColor: String by `$props`
    open var darkTitleColor: String by `$props`
    open var titleSize: String by `$props`
    open var iconSize: String by `$props`
    open var label: String by `$props`
    open var labelColor: String by `$props`
    open var darklabelColor: String by `$props`
    open var labelSize: String by `$props`
    open var desc: String by `$props`
    open var showBottomBorder: Boolean by `$props`
    open var bottomBorderInsert: Boolean by `$props`
    open var bottomBorderColor: String by `$props`
    open var link: Boolean by `$props`
    open var linkColor: String by `$props`
    open var linkDarkColor: String by `$props`
    open var url: String by `$props`
    open var card: Boolean by `$props`
    open var round: String by `$props`
    open var leftSize: String by `$props`
    open var minHeight: String by `$props`
    open var disabled: Boolean by `$props`
    open var padding: UTSArray<String> by `$props`
    open var margin: UTSArray<String> by `$props`
    open var rightWidth: String by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesTmxUiComponentsTmxCellTmxCell) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesTmxUiComponentsTmxCellTmxCell
            val _cache = __ins.renderCache
            fun emits(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val props = __props
            val _padding = computed(fun(): String {
                if (props.padding.length == 0) {
                    var par = fillArrayCssValue(xConfig.sheetPadding)
                    if (par.length == 0) {
                        return "0px 0px 0px 0px"
                    }
                    return par.join(" ")
                }
                var ar: UTSArray<String> = fillArrayCssValue(props.padding as UTSArray<String>)
                if (ar.length == 0) {
                    return "0px 0px 0px 0px"
                }
                return ar.join(" ")
            }
            )
            val _margin = computed(fun(): String {
                if (props.margin.length == 0) {
                    var par = fillArrayCssValue(xConfig.cellMargin)
                    if (par.length == 0) {
                        return "0px 0px 0px 0px"
                    }
                    return par.join(" ")
                }
                var ar: UTSArray<String> = fillArrayCssValue(props.margin as UTSArray<String>)
                if (ar.length == 0) {
                    return "0px 0px 0px 0px"
                }
                return ar.join(" ")
            }
            )
            val _disabled = computed(fun(): Boolean {
                return props.disabled
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
            val _titleColor = computed(fun(): String {
                if (xConfig.dark == "dark") {
                    if (props.darkTitleColor != "") {
                        return getDefaultColor(props.darkTitleColor)
                    }
                    return "#ffffff"
                }
                return getDefaultColor(props.titleColor)
            }
            )
            val _leftSize = computed(fun(): String {
                return checkIsCssUnit(props.leftSize, xConfig.unit)
            }
            )
            val _rightWidth = computed(fun(): String {
                return checkIsCssUnit(props.rightWidth, xConfig.unit)
            }
            )
            val _avatarRound = computed(fun(): String {
                return checkIsCssUnit(props.avatarRound, xConfig.unit)
            }
            )
            val _minHeight = computed(fun(): String {
                return checkIsCssUnit(props.minHeight, xConfig.unit)
            }
            )
            val _bottomBorderColor = computed(fun(): String {
                if (props.bottomBorderColor != "") {
                    return getDefaultColor(props.bottomBorderColor)
                }
                if (xConfig.dark == "dark") {
                    return xConfig.borderDarkColor
                }
                return "#f5f5f5"
            }
            )
            val _icon = computed(fun(): String {
                return props.icon
            }
            )
            val _allAttr = computed(fun(): xCellItemType {
                var iconColor = props.iconColor
                if (iconColor == "") {
                    iconColor = xConfig.color
                }
                var labelColor = props.labelColor
                if (xConfig.dark == "dark") {
                    if (props.darklabelColor != "") {
                        labelColor = props.darklabelColor
                    }
                }
                var p = xCellItemType(icon = props.icon, title = props.title, desc = props.desc, label = props.label, bottom = props.showBottomBorder, link = props.link, url = props.url, iconColor = getDefaultColor(iconColor), labelColor = getDefaultColor(labelColor), card = props.card)
                return p
            }
            )
            val _cardRadius = computed(fun(): String {
                if (props.round == "") {
                    return checkIsCssUnit(xConfig.inputRadius, xConfig.unit)
                }
                return checkIsCssUnit(xConfig.cellRadius, xConfig.unit)
            }
            )
            val _titleSize = computed(fun(): String {
                var fontSize = checkIsCssUnit(props.titleSize, xConfig.unit)
                if (xConfig.fontScale == 1) {
                    return fontSize
                }
                var sizeNumber = parseInt(fontSize)
                if (isNaN(sizeNumber)) {
                    sizeNumber = 16
                }
                return (sizeNumber * xConfig.fontScale).toString(10) + getUnit(fontSize)
            }
            )
            val _iconSize = computed(fun(): String {
                var fontSize = checkIsCssUnit(props.iconSize, xConfig.unit)
                if (xConfig.fontScale == 1) {
                    return fontSize
                }
                var sizeNumber = parseInt(fontSize)
                if (isNaN(sizeNumber)) {
                    sizeNumber = 17
                }
                return (sizeNumber * xConfig.fontScale).toString(10) + getUnit(fontSize)
            }
            )
            val _rightLableSize = computed(fun(): String {
                var fontSize = checkIsCssUnit(props.labelSize, xConfig.unit)
                if (xConfig.fontScale == 1) {
                    return fontSize
                }
                var sizeNumber = parseInt(fontSize)
                if (isNaN(sizeNumber)) {
                    sizeNumber = 13
                }
                return (sizeNumber * xConfig.fontScale).toString(10) + getUnit(fontSize)
            }
            )
            val _isLinksHover = computed(fun(): Boolean {
                return props.link
            }
            )
            fun gen_clickLisent_fn(): Unit {
                emits("click")
                if (props.url != "" && !_disabled.value) {
                    uni_navigateTo(NavigateToOptions(url = props.url, fail = fun(_) {
                        uni_switchTab(SwitchTabOptions(url = props.url))
                    }
                    ))
                }
            }
            val clickLisent = ::gen_clickLisent_fn
            return fun(): Any? {
                val _component_tmx_icon = resolveEasyComponent("tmx-icon", GenUniModulesTmxUiComponentsTmxIconTmxIconClass)
                val _component_tmx_text = resolveEasyComponent("tmx-text", GenUniModulesTmxUiComponentsTmxTextTmxTextClass)
                return _cE("view", _uM("onClick" to clickLisent, "hover-start-time" to if (_isLinksHover.value) {
                    50
                } else {
                    0
                }
                , "hover-stay-time" to if (_isLinksHover.value) {
                    100
                } else {
                    0
                }
                , "hover-class" to if (_isLinksHover.value) {
                    "cellHover"
                } else {
                    ""
                }
                , "class" to "xCell", "style" to _nS(_uM("backgroundColor" to _color.value, "borderRadius" to if (_allAttr.value.card == true) {
                    _cardRadius.value
                } else {
                    "0px"
                }
                , "minHeight" to _minHeight.value, "padding" to _padding.value, "margin" to if (_allAttr.value.card) {
                    _margin.value
                } else {
                    "0px"
                }
                , "borderBottom" to if (_allAttr.value.bottom && !_allAttr.value.card && !_ctx.bottomBorderInsert) {
                    "1px solid " + _bottomBorderColor.value
                } else {
                    "none"
                }
                ))), _uA(
                    if (isTrue(_icon.value)) {
                        _cE("view", _uM("key" to 0, "class" to "xCellAvatar", "style" to _nS(_uM("width" to _leftSize.value, "height" to _leftSize.value, "borderRadius" to _avatarRound.value))), _uA(
                            renderSlot(_ctx.`$slots`, "avatar", GenUniModulesTmxUiComponentsTmxCellTmxCellSlotDataAvatar(icon = _icon.value), fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_tmx_icon, _uM("color" to _allAttr.value.iconColor, "font-size" to _iconSize.value, "name" to _icon.value), null, 8, _uA(
                                        "color",
                                        "font-size",
                                        "name"
                                    ))
                                )
                            })
                        ), 4)
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    _cE("view", _uM("class" to "xCellWrap", "style" to _nS(_uM("borderBottom" to if (_allAttr.value.bottom && !_allAttr.value.card && _ctx.bottomBorderInsert) {
                        "1px solid " + _bottomBorderColor.value
                    } else {
                        "none"
                    }
                    ))), _uA(
                        _cE("view", _uM("class" to "center"), _uA(
                            renderSlot(_ctx.`$slots`, "default", _uO(), fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("text", _uM("class" to "title", "style" to _nS(_uM("color" to _titleColor.value, "fontSize" to _titleSize.value))), _tD(_allAttr.value.title), 5)
                                )
                            }
                            ),
                            renderSlot(_ctx.`$slots`, "desc", GenUniModulesTmxUiComponentsTmxCellTmxCellSlotDataDesc(desc = _allAttr.value.desc), fun(): UTSArray<Any> {
                                return _uA(
                                    if (_allAttr.value.desc != "") {
                                        _cV(_component_tmx_text, _uM("key" to 0, "font-size" to "12", "color" to "#bfbfbf", "dark-color" to "#bfbfbf", "class" to "desc"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(_allAttr.value.desc)
                                            )
                                        }), "_" to 1))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                )
                            }
                            )
                        )),
                        _cE("view", _uM("class" to "xcellRight"), _uA(
                            renderSlot(_ctx.`$slots`, "label", GenUniModulesTmxUiComponentsTmxCellTmxCellSlotDataLabel(label = _allAttr.value.label), fun(): UTSArray<Any> {
                                return _uA(
                                    if (_allAttr.value.label != "") {
                                        _cE("text", _uM("key" to 0, "style" to _nS(_uM("marginLeft" to "16px", "color" to _allAttr.value.labelColor, "fontSize" to _rightLableSize.value, "width" to _rightWidth.value)), "class" to "rightLabel"), _tD(_allAttr.value.label), 5)
                                    } else {
                                        _cC("v-if", true)
                                    }
                                )
                            }
                            ),
                            renderSlot(_ctx.`$slots`, "right"),
                            if (isTrue(_allAttr.value.url != "" || _allAttr.value.link)) {
                                _cE("view", _uM("key" to 0, "style" to _nS(_uM("margin-left" to "5px"))), _uA(
                                    _cV(_component_tmx_icon, _uM("dark-color" to _ctx.linkDarkColor, "color" to _ctx.linkColor, "font-size" to "20", "name" to "arrow-right-s-line"), null, 8, _uA(
                                        "dark-color",
                                        "color"
                                    ))
                                ), 4)
                            } else {
                                _cC("v-if", true)
                            }
                        ))
                    ), 4)
                ), 12, _uA(
                    "hover-start-time",
                    "hover-stay-time",
                    "hover-class"
                ))
            }
        }
        var name = "xCell"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("cellHover" to _pS(_uM("opacity" to 0.9)), "xCell" to _pS(_uM("paddingTop" to 12, "paddingRight" to 0, "paddingBottom" to 12, "paddingLeft" to 0, "display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center")), "xCellWrap" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "height" to "100%", "paddingTop" to 12, "paddingRight" to 0, "paddingBottom" to 12, "paddingLeft" to 0)), "title" to _pS(_uM("lines" to 2, "textOverflow" to "ellipsis", "flexGrow" to 1, "flexShrink" to 0, "flexBasis" to "0%", "lineHeight" to 1.7)), "desc" to _pS(_uM("fontSize" to 12, "paddingTop" to 2)), "xCellAvatar" to _pS(_uM("marginRight" to 10, "display" to "flex", "flexDirection" to "column", "justifyContent" to "center", "alignItems" to "center", "flexShrink" to 0, "overflow" to "hidden")), "center" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "xcellRight" to _pS(_uM("flexDirection" to "row", "justifyContent" to "flex-end", "alignItems" to "center")), "rightLabel" to _pS(_uM("lines" to 1, "textOverflow" to "ellipsis", "fontSize" to 12, "textAlign" to "right")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("click" to null, "update:show" to null)
        var props = _nP(_uM("icon" to _uM("type" to "String", "required" to true, "default" to ""), "avatarRound" to _uM("type" to "String", "required" to true, "default" to "8"), "color" to _uM("type" to "String", "required" to true, "default" to "white"), "darkColor" to _uM("type" to "String", "required" to true, "default" to ""), "iconColor" to _uM("type" to "String", "required" to true, "default" to ""), "title" to _uM("type" to "String", "required" to true, "default" to "标题"), "titleColor" to _uM("type" to "String", "required" to true, "default" to "black"), "darkTitleColor" to _uM("type" to "String", "required" to true, "default" to "white"), "titleSize" to _uM("type" to "String", "required" to true, "default" to "16"), "iconSize" to _uM("type" to "String", "required" to true, "default" to "24"), "label" to _uM("type" to "String", "required" to true, "default" to ""), "labelColor" to _uM("type" to "String", "required" to true, "default" to "#bfbfbf"), "darklabelColor" to _uM("type" to "String", "required" to true, "default" to ""), "labelSize" to _uM("type" to "String", "required" to true, "default" to "13"), "desc" to _uM("type" to "String", "required" to true, "default" to ""), "showBottomBorder" to _uM("type" to "Boolean", "required" to true, "default" to true), "bottomBorderInsert" to _uM("type" to "Boolean", "required" to true, "default" to false), "bottomBorderColor" to _uM("type" to "String", "required" to true, "default" to ""), "link" to _uM("type" to "Boolean", "required" to true, "default" to true), "linkColor" to _uM("type" to "String", "required" to true, "default" to "#bfbfbf"), "linkDarkColor" to _uM("type" to "String", "required" to true, "default" to "#bfbfbf"), "url" to _uM("type" to "String", "required" to true, "default" to ""), "card" to _uM("type" to "Boolean", "required" to true, "default" to true), "round" to _uM("type" to "String", "required" to true, "default" to ""), "leftSize" to _uM("type" to "String", "required" to true, "default" to "32"), "minHeight" to _uM("type" to "String", "required" to true, "default" to "55"), "disabled" to _uM("type" to "Boolean", "required" to true, "default" to false), "padding" to _uM("type" to "Array", "required" to true, "default" to fun(): UTSArray<String> {
            return _uA<String>("12", "0")
        }
        ), "margin" to _uM("type" to "Array", "required" to true, "default" to fun(): UTSArray<String> {
            return _uA<String>()
        }
        ), "rightWidth" to _uM("type" to "String", "required" to true, "default" to "100")))
        var propsNeedCastKeys = _uA(
            "icon",
            "avatarRound",
            "color",
            "darkColor",
            "iconColor",
            "title",
            "titleColor",
            "darkTitleColor",
            "titleSize",
            "iconSize",
            "label",
            "labelColor",
            "darklabelColor",
            "labelSize",
            "desc",
            "showBottomBorder",
            "bottomBorderInsert",
            "bottomBorderColor",
            "link",
            "linkColor",
            "linkDarkColor",
            "url",
            "card",
            "round",
            "leftSize",
            "minHeight",
            "disabled",
            "padding",
            "margin",
            "rightWidth"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
