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
open class GenUniModulesFirstuiUvueComponentsFuiTabsFuiTabs : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onCreated(fun() {
            val tabs = JSON.parse<UTSArray<FuiTabsItemParam>>(JSON.stringify(this.tabs))
            if (tabs != null) {
                this.initData(tabs)
            }
        }
        , __ins)
        this.`$watch`(fun(): Any? {
            return this.tabs
        }
        , fun(vals: UTSArray<FuiTabsItemParam>) {
            this.initData(vals)
        }
        )
        this.`$watch`(fun(): Any? {
            return this.current
        }
        , fun(newVal: Number) {
            this.switchTab(newVal)
        }
        )
        this.`$watch`(fun(): Any? {
            return this.tabIndex
        }
        , fun(kVal: Number) {
            setTimeout(fun(){
                this.tabIdx = kVal
            }
            , 0)
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        return _cE("scroll-view", _uM("class" to _nC(_uA(
            "fui-tabs__scrollbox",
            _uM("fui-tabs__fixed" to _ctx.isFixed)
        )), "scroll-with-animation" to true, "direction" to if (_ctx.scroll) {
            "horizontal"
        } else {
            "vertical"
        }
        , "show-scrollbar" to false, "scroll-into-view" to _ctx.scrollInto, "style" to _nS(_uM("background" to _ctx.background, "zIndex" to if (_ctx.isFixed) {
            _ctx.zIndex
        } else {
            1
        }
        , "top" to if (_ctx.isFixed) {
            "" + _ctx.top + "px"
        } else {
            "auto"
        }
        ))), _uA(
            _cE("view", _uM("class" to _nC(_uA(
                "fui-scroll__view",
                _uM("fui-tabs__full" to !_ctx.scroll)
            ))), _uA(
                _cE(Fragment, null, RenderHelpers.renderList(_ctx.vals, fun(tab, index, __index, _cached): Any {
                    return _cE("view", _uM("key" to index, "class" to _nC(_uA(
                        "fui-tabs__item",
                        _uM("fui-tabs__full" to !_ctx.scroll)
                    )), "id" to _ctx.ids[index], "onClick" to fun(){
                        _ctx.switchTab(index)
                    }
                    ), _uA(
                        _cE("view", _uM("class" to _nC(_uA(
                            "fui-tabs__text-wrap",
                            _uM("fui-tabs__wrap-disabled" to tab.disabled, "fui-tabs__item-column" to (_ctx.direction == "column" && (tab.icon != null || tab.icon != "")))
                        )), "style" to _nS(_uM("height" to ("" + _ctx.height + "rpx")))), _uA(
                            if (isTrue(_ctx.isSlider)) {
                                _cE("view", _uM("key" to 0, "class" to _nC(_uA(
                                    "fui-tabs__line-wrap",
                                    _uM("fui-tabs__line-center" to _ctx.center)
                                )), "style" to _nS(_uM("bottom" to ("" + _ctx.bottom + "rpx"), "left" to ("-" + _ctx.padding + "rpx"), "right" to ("-" + _ctx.padding + "rpx")))), _uA(
                                    _cE("view", _uM("class" to _nC(_uA(
                                        "fui-tabs__ac-line",
                                        _uM("fui-tabs__line-short" to _ctx.short, "fui-tabs__full" to !_ctx.short, "fui-tabs__slider-color" to (_ctx.sliderBackground == ""))
                                    )), "style" to _nS(_uM("height" to ("" + _ctx.sliderHeight + "rpx"), "background" to _ctx.sliderBackground, "borderRadius" to if (_ctx.sliderRadius == -1) {
                                        "" + _ctx.sliderHeight + "rpx"
                                    } else {
                                        "" + _ctx.sliderRadius + "rpx"
                                    }, "transform" to ("scale(" + (if (_ctx.tabIndex == index) {
                                        _ctx.scale
                                    } else {
                                        0
                                    }) + ")")))), null, 6)
                                ), 6)
                            } else {
                                _cC("v-if", true)
                            }
                            ,
                            if (isTrue(tab.icon != null && tab.icon != "")) {
                                _cE("image", _uM("key" to 1, "class" to _nC(_uA(
                                    "fui-tabs__icon",
                                    _uM("fui-tabs__icon-column" to (_ctx.direction == "column"))
                                )), "src" to if (_ctx.tabIndex == index && tab.selectedIcon != "" && tab.selectedIcon != null) {
                                    tab.selectedIcon
                                } else {
                                    tab.icon
                                }), null, 10, _uA(
                                    "src"
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                            ,
                            _cE("view", _uM("class" to "fui-tabs__text", "style" to _nS(_uM("transform" to ("scale(" + (if (_ctx.tabIndex == index) {
                                _ctx.scale
                            } else {
                                1
                            }
                            ) + ")")))), _uA(
                                _cE("text", _uM("class" to _nC(_uM("fui-tabs__selected-color" to (_ctx.selectedColor == "" && _ctx.tabIdx == index))), "style" to _nS(_ctx.getTextStyl(_ctx.tabIndex, index))), _tD(tab.name), 7),
                                if (isTrue(tab.badge != null && tab.badge != 0)) {
                                    _cE("text", _uM("key" to 0, "class" to _nC(_uM("fui-tabs__badge-color" to (_ctx.badgeBackground == ""), "fui-tabs__badge-dot" to _ctx.isDot, "fui-tabs__badge" to !_ctx.isDot)), "style" to _nS(_uM("color" to _ctx.badgeColor, "background" to _ctx.badgeBackground))), _tD(if (_ctx.isDot) {
                                        ""
                                    } else {
                                        tab.badge
                                    }), 7)
                                } else {
                                    _cC("v-if", true)
                                }
                            ), 4)
                        ), 6)
                    ), 10, _uA(
                        "id",
                        "onClick"
                    ))
                }
                ), 128)
            ), 2)
        ), 14, _uA(
            "direction",
            "scroll-into-view"
        ))
    }
    open var tabs: UTSArray<FuiTabsItemParam> by `$props`
    open var current: Number by `$props`
    open var scroll: Boolean by `$props`
    open var height: Number by `$props`
    open var background: String by `$props`
    open var size: Number by `$props`
    open var color: String by `$props`
    open var fontWeight: String by `$props`
    open var selectedColor: String by `$props`
    open var selectedFontWeight: String by `$props`
    open var scale: Number by `$props`
    open var badgeColor: String by `$props`
    open var badgeBackground: String by `$props`
    open var isDot: Boolean by `$props`
    open var isSlider: Boolean by `$props`
    open var sliderHeight: Number by `$props`
    open var sliderBackground: String by `$props`
    open var sliderRadius: Number by `$props`
    open var padding: Number by `$props`
    open var bottom: Number by `$props`
    open var short: Boolean by `$props`
    open var center: Boolean by `$props`
    open var isFixed: Boolean by `$props`
    open var top: Number by `$props`
    open var direction: String by `$props`
    open var zIndex: Number by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    open var vals: UTSArray<FuiTabsItemParam> by `$data`
    open var ids: UTSArray<String> by `$data`
    open var scrollInto: String by `$data`
    open var tabIndex: Number by `$data`
    open var tabIdx: Number by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml, "vals" to _uA<FuiTabsItemParam>(), "ids" to _uA<String>(), "scrollInto" to "", "tabIndex" to 0, "tabIdx" to 0)
    }
    open var getTextStyl = ::gen_getTextStyl_fn
    open fun gen_getTextStyl_fn(tabIndex: Number, index: Number): Any {
        val mp: Map<String, Any> = Map()
        mp.set("fontSize", "" + this.size + "rpx")
        if (tabIndex == index) {
            mp.set("fontWeight", this.selectedFontWeight)
            if (this.selectedColor != "") {
                mp.set("color", this.selectedColor)
            }
        } else {
            mp.set("color", this.color)
            mp.set("fontWeight", this.fontWeight)
        }
        return mp
    }
    open var initData = ::gen_initData_fn
    open fun gen_initData_fn(vals: UTSArray<FuiTabsItemParam>) {
        this.vals = _uA<FuiTabsItemParam>()
        val ids = _uA<String>()
        val len = vals.length
        run {
            var i: Number = 0
            while(i < len){
                val id = "fui_tabs_" + parseInt(Math.ceil(Math.random() * 10e5).toString(10), 36)
                ids.push(id)
                i++
            }
        }
        this.`$nextTick`(fun(){
            this.ids = ids
            this.vals = vals
            setTimeout(fun(){
                this.switchTab(this.current)
            }
            , 50)
        }
        )
    }
    open var switchTab = ::gen_switchTab_fn
    open fun gen_switchTab_fn(index: Number) {
        if (this.vals.length < 1) {
            return
        }
        val item = this.vals[index]
        if (this.tabIndex != index && item.disabled != true) {
            this.tabIndex = index
            var scrollIndex = if (index - 1 < 0) {
                0
            } else {
                index - 1
            }
            this.scrollInto = this.ids[scrollIndex]
            item.index = index
            this.`$emit`("change", item)
        }
    }
    companion object {
        var name = "fui-tabs"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("fui-tabs__scrollbox" to _pS(_uM("width" to "100%", "flexDirection" to "row", "overflow" to "hidden")), "fui-tabs__fixed" to _pS(_uM("position" to "fixed", "left" to 0, "right" to 0)), "fui-scroll__view" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center")), "fui-tabs__item" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "flexShrink" to 0, "paddingLeft" to "32rpx", "paddingRight" to "32rpx", "position" to "relative")), "fui-tabs__full" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "fui-tabs__text-wrap" to _pS(_uM("position" to "relative", "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "zIndex" to 3, "overflow" to "visible")), "fui-tabs__wrap-disabled" to _pS(_uM("opacity" to 0.5)), "fui-tabs__icon" to _pS(_uM("width" to "40rpx", "height" to "40rpx", "marginRight" to "12rpx")), "fui-tabs__item-column" to _pS(_uM("!flexDirection" to "column")), "fui-tabs__icon-column" to _pS(_uM("!marginRight" to 0, "marginBottom" to "8rpx")), "fui-tabs__text" to _pS(_uM("transitionProperty" to "transform", "transitionDuration" to "0.2s", "transitionTimingFunction" to "linear", "zIndex" to 3, "position" to "relative", "overflow" to "visible")), "fui-tabs__badge" to _pS(_uM("height" to "36rpx", "paddingTop" to 0, "paddingRight" to "12rpx", "paddingBottom" to 0, "paddingLeft" to "12rpx", "color" to "#FFFFFF", "fontSize" to "24rpx", "lineHeight" to "36rpx", "borderTopLeftRadius" to 100, "borderTopRightRadius" to 100, "borderBottomRightRadius" to 100, "borderBottomLeftRadius" to 100, "position" to "absolute", "!minWidth" to "36rpx", "boxSizing" to "border-box", "right" to "-32rpx", "top" to "-18rpx", "zIndex" to 10, "transform" to "scale(0.9)", "textAlign" to "center")), "fui-tabs__badge-dot" to _pS(_uM("!height" to 8, "!width" to 8, "borderTopLeftRadius" to 100, "borderTopRightRadius" to 100, "borderBottomRightRadius" to 100, "borderBottomLeftRadius" to 100, "position" to "absolute", "right" to -6, "top" to -3, "zIndex" to 10)), "fui-tabs__line-wrap" to _pS(_uM("position" to "absolute", "borderTopLeftRadius" to 2, "borderTopRightRadius" to 2, "borderBottomRightRadius" to 2, "borderBottomLeftRadius" to 2, "zIndex" to 2, "flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "display" to "flex", "flexDirection" to "row")), "fui-tabs__line-center" to _pS(_uM("justifyContent" to "center", "left" to 0)), "fui-tabs__ac-line" to _pS(_uM("transitionProperty" to "transform", "transitionDuration" to "0.2s", "transitionTimingFunction" to "linear")), "fui-tabs__line-short" to _pS(_uM("!width" to "45rpx")), "fui-tabs__selected-color" to _pS(_uM("!color" to "#465CFF")), "fui-tabs__slider-color" to _pS(_uM("!backgroundImage" to "none", "!backgroundColor" to "#465CFF")), "fui-tabs__badge-color" to _pS(_uM("!backgroundImage" to "none", "!backgroundColor" to "#FF2B2B")), "@TRANSITION" to _uM("fui-tabs__text" to _uM("property" to "transform", "duration" to "0.2s", "timingFunction" to "linear"), "fui-tabs__ac-line" to _uM("property" to "transform", "duration" to "0.2s", "timingFunction" to "linear")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("change" to null)
        var props = _nP(_uM("tabs" to _uM("type" to "Array", "default" to fun(): UTSArray<FuiTabsItemParam> {
            return _uA<FuiTabsItemParam>()
        }
        ), "current" to _uM("type" to "Number", "default" to 0), "scroll" to _uM("type" to "Boolean", "default" to false), "height" to _uM("type" to "Number", "default" to 96), "background" to _uM("type" to "String", "default" to "#fff"), "size" to _uM("type" to "Number", "default" to 28), "color" to _uM("type" to "String", "default" to "#7F7F7F"), "fontWeight" to _uM("type" to "String", "default" to "normal"), "selectedColor" to _uM("type" to "String", "default" to ""), "selectedFontWeight" to _uM("type" to "String", "default" to "bold"), "scale" to _uM("type" to "Number", "default" to 1.2), "badgeColor" to _uM("type" to "String", "default" to "#fff"), "badgeBackground" to _uM("type" to "String", "default" to ""), "isDot" to _uM("type" to "Boolean", "default" to false), "isSlider" to _uM("type" to "Boolean", "default" to true), "sliderHeight" to _uM("type" to "Number", "default" to 5), "sliderBackground" to _uM("type" to "String", "default" to ""), "sliderRadius" to _uM("type" to "Number", "default" to -1), "padding" to _uM("type" to "Number", "default" to 0), "bottom" to _uM("type" to "Number", "default" to 0), "short" to _uM("type" to "Boolean", "default" to true), "center" to _uM("type" to "Boolean", "default" to false), "isFixed" to _uM("type" to "Boolean", "default" to false), "top" to _uM("type" to "Number", "default" to 0), "direction" to _uM("type" to "String", "default" to "row"), "zIndex" to _uM("type" to "Number", "default" to 900)))
        var propsNeedCastKeys = _uA(
            "tabs",
            "current",
            "scroll",
            "height",
            "background",
            "size",
            "color",
            "fontWeight",
            "selectedColor",
            "selectedFontWeight",
            "scale",
            "badgeColor",
            "badgeBackground",
            "isDot",
            "isSlider",
            "sliderHeight",
            "sliderBackground",
            "sliderRadius",
            "padding",
            "bottom",
            "short",
            "center",
            "isFixed",
            "top",
            "direction",
            "zIndex"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
