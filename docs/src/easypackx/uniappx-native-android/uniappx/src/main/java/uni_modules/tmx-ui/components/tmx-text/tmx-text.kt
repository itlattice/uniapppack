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
open class GenUniModulesTmxUiComponentsTmxTextTmxText : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var _style: String by `$props`
    open var _class: String by `$props`
    open var label: String by `$props`
    open var highlight: UTSArray<String> by `$props`
    open var highlightReg: UTSArray<String> by `$props`
    open var highlightStyle: String by `$props`
    open var lines: Number by `$props`
    open var selectable: Boolean by `$props`
    open var color: String by `$props`
    open var darkColor: String by `$props`
    open var highlightColor: String by `$props`
    open var lineHeight: String by `$props`
    open var fontSize: String by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesTmxUiComponentsTmxTextTmxText) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesTmxUiComponentsTmxTextTmxText
            val _cache = __ins.renderCache
            val props = __props
            fun emits(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val _fontSize = computed(fun(): String {
                var basefontsize = if (props.fontSize == "") {
                    xConfig.fontSize
                } else {
                    props.fontSize
                }
                var fontSize = checkIsCssUnit(basefontsize, xConfig.unit)
                if (xConfig.fontScale == 1) {
                    return fontSize
                }
                var sizeNumber = parseInt(fontSize)
                if (isNaN(sizeNumber)) {
                    sizeNumber = 14
                }
                return (sizeNumber * xConfig.fontScale).toString(10) + getUnit(fontSize)
            }
            )
            val _color = computed(fun(): String {
                var color = if (props.color == "") {
                    xConfig.fontColor
                } else {
                    props.color
                }
                if (xConfig.dark == "dark") {
                    if (props.darkColor != "") {
                        color = props.darkColor
                        return getDefaultColor(color)
                    }
                    color = if (xConfig.fontDarkColor == "") {
                        setTextColorLightByDark(props.color)
                    } else {
                        xConfig.fontDarkColor
                    }
                }
                return getDefaultColor(color)
            }
            )
            val _texts = computed(fun(): UTSArray<ITEMINFO> {
                if (props.label == "") {
                    return _uA<ITEMINFO>()
                }
                var keywords = props.highlight
                var albel = props.label
                var colorVal = _color.value
                if ((keywords.length == 0 && props.highlightReg.length == 0) || albel.length == 0) {
                    return _uA(
                        ITEMINFO(text = albel, color = colorVal, isHeightLight = false)
                    )
                }
                var hlColor = getDefaultColor(props.highlightColor)
                var regexxSet = Set<String>()
                run {
                    var ri: Number = 0
                    while(ri < props.highlightReg.length){
                        var regex = UTSRegExp(props.highlightReg[ri], "gi")
                        var rulst = regex.exec(albel)
                        while(rulst != null && UTSArray.isArray(rulst)){
                            regexxSet.add(rulst[0]!! as String)
                            rulst = regex.exec(albel)
                        }
                        ri++
                    }
                }
                var regexxAr = _uA<String>()
                regexxSet.forEach(fun(v: String){
                    regexxAr.push(v)
                }
                )
                keywords = keywords.concat(regexxAr)
                var specialCharReg = UTSRegExp("[\\*]", "gi")
                run {
                    var ki: Number = 0
                    while(ki < keywords.length){
                        var keyword = keywords[ki]
                        var isFuhao = specialCharReg.test(keyword)
                        var regex = UTSRegExp(if (isFuhao) {
                            ("\\" + keyword)
                        } else {
                            keyword
                        }
                        , "gi")
                        albel = albel.replace(regex, "~-<span>" + keyword + "</span>~-")
                        ki++
                    }
                }
                var ps = albel.split("~-")
                var ar = _uA<ITEMINFO>()
                run {
                    var pi: Number = 0
                    while(pi < ps.length){
                        var el = ps[pi]
                        if (el.length > 0) {
                            var start = el.indexOf("<span>")
                            if (start > -1) {
                                var end = el.lastIndexOf("</span>")
                                ar.push(ITEMINFO(text = el.substring(start + 6, end), color = hlColor, isHeightLight = true))
                            } else {
                                ar.push(ITEMINFO(text = el, color = colorVal, isHeightLight = false))
                            }
                        }
                        pi++
                    }
                }
                return ar
            }
            )
            val _styleMap = computed(fun(): Map<String, Any> {
                var styleMap = Map<String, Any>()
                if (props.lines > 0) {
                    styleMap.set("lines", props.lines)
                }
                styleMap.set("line-height", props.lineHeight)
                styleMap.set("font-size", _fontSize.value)
                styleMap.set("color", _color.value)
                return styleMap
            }
            )
            fun gen_allClick_fn() {
                emits("click")
            }
            val allClick = ::gen_allClick_fn
            fun gen_itemClick_fn(str: String) {
                emits("item-click", str)
            }
            val itemClick = ::gen_itemClick_fn
            return fun(): Any? {
                return _cE("text", _uM("onClick" to allClick, "style" to _nS(_uA(
                    _styleMap.value,
                    props._style
                )), "class" to _nC(_uA(
                    props._class,
                    "xTextLines"
                )), "selectable" to _ctx.selectable), _uA(
                    renderSlot(_ctx.`$slots`, "default", _uO(), fun(): UTSArray<Any> {
                        return _uA(
                            if (props.label == "") {
                                _cE("text", _uM("key" to 0, "onClick" to allClick, "style" to _nS(_uA(
                                    _styleMap.value,
                                    props._style
                                )), "class" to _nC(_uA(
                                    props._class,
                                    "xTextLines"
                                )), "selectable" to _ctx.selectable), _tD(props.label), 15, _uA(
                                    "selectable"
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                        )
                    }
                    ),
                    _cE(Fragment, null, RenderHelpers.renderList(_texts.value, fun(item, index, __index, _cached): Any {
                        return _cE("text", _uM("onClick" to fun(){
                            itemClick(item.text)
                        }
                        , "class" to _nC(_uA(
                            props._class
                        )), "selectable" to _ctx.selectable, "style" to _nS(_uA(
                            _uM("color" to item.color, "lineHeight" to _ctx.lineHeight, "fontSize" to _fontSize.value),
                            if (item.isHeightLight) {
                                _ctx.highlightStyle
                            } else {
                                _uM<String, Any?>()
                            }
                            ,
                            props._style
                        )), "key" to index), _tD(item.text), 15, _uA(
                            "onClick",
                            "selectable"
                        ))
                    }
                    ), 128)
                ), 14, _uA(
                    "selectable"
                ))
            }
        }
        var name = "xText"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("xTextRegx" to _pS(_uM("display" to "flex", "flexDirection" to "row", "flexWrap" to "wrap")), "xTextLines" to _pS(_uM("textOverflow" to "ellipsis")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("click" to null, "item-click" to null)
        var props = _nP(_uM("_style" to _uM("type" to "String", "required" to true, "default" to ""), "_class" to _uM("type" to "String", "required" to true, "default" to ""), "label" to _uM("type" to "String", "required" to true, "default" to ""), "highlight" to _uM("type" to "Array", "required" to true, "default" to fun(): UTSArray<String> {
            return _uA<String>()
        }
        ), "highlightReg" to _uM("type" to "Array", "required" to true, "default" to fun(): UTSArray<String> {
            return _uA<String>()
        }
        ), "highlightStyle" to _uM("type" to "String", "required" to true, "default" to ""), "lines" to _uM("type" to "Number", "required" to true, "default" to 0), "selectable" to _uM("type" to "Boolean", "required" to true, "default" to false), "color" to _uM("type" to "String", "required" to true, "default" to ""), "darkColor" to _uM("type" to "String", "required" to true, "default" to ""), "highlightColor" to _uM("type" to "String", "required" to true, "default" to "primary"), "lineHeight" to _uM("type" to "String", "required" to true, "default" to "1.7"), "fontSize" to _uM("type" to "String", "required" to true, "default" to "")))
        var propsNeedCastKeys = _uA(
            "_style",
            "_class",
            "label",
            "highlight",
            "highlightReg",
            "highlightStyle",
            "lines",
            "selectable",
            "color",
            "darkColor",
            "highlightColor",
            "lineHeight",
            "fontSize"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
