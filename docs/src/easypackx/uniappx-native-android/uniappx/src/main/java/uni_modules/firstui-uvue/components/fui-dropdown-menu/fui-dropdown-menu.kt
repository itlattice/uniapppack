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
import io.dcloud.uniapp.extapi.rpx2px as uni_rpx2px
open class GenUniModulesFirstuiUvueComponentsFuiDropdownMenuFuiDropdownMenu : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onCreated(fun() {
            val data = JSON.parse<UTSArray<FuiDropdownMenuOptionParam>>(JSON.stringify(this.menus))
            if (data != null) {
                this.initData(data)
            }
        }
        , __ins)
        onMounted(fun() {
            this.`$nextTick`(fun(){
                setTimeout(fun(){
                    this.getPosition(fun(res: Boolean){
                        if (res) {}
                    }
                    )
                }
                , 50)
            }
            )
        }
        , __ins)
        this.`$watch`(fun(): Any? {
            return this.menus
        }
        , fun(newVal: UTSArray<FuiDropdownMenuOptionParam>) {
            this.initData(newVal)
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        return _cE("view", _uM("class" to "fui-dropdown__menu", "id" to _ctx.boxId), _uA(
            renderSlot(_ctx.`$slots`, "default"),
            _cE("view", _uM("ref" to _ctx.refMkId, "class" to "fui-ddm__mask", "style" to _nS(_uM("background" to _ctx.maskBackground, "zIndex" to (_ctx.zIndex - 2))), "onClick" to fun(){
                _ctx.close(1)
            }
            ), null, 12, _uA(
                "onClick"
            )),
            _cE("view", _uM("ref" to _ctx.refId, "class" to _nC(_uA(
                "fui-dropdown__menu-list",
                _uA(
                    if (_ctx.direction == "up") {
                        "fui-ddm__up"
                    } else {
                        "fui-ddm__down"
                    }
                )
            )), "style" to _nS(_ctx.getStyles)), _uA(
                _cE("scroll-view", _uM("show-scrollbar" to false, "class" to "fui-ddm__scroll", "scroll-y" to true, "style" to _nS(_uM("maxHeight" to ("" + _ctx.maxHeight + "rpx"), "minWidth" to ("" + _ctx.minWidth + "rpx")))), _uA(
                    _cE(Fragment, null, RenderHelpers.renderList(_ctx.itemList, fun(model, index, __index, _cached): Any {
                        return _cE("view", _uM("key" to index, "class" to _nC(_uA(
                            "fui-dropdown__menu-item",
                            _uM("fui-ddm__reverse" to _ctx.isReverse, "fui-ddm__item-line" to (_ctx.splitLine && _ctx.itemList.length - 1 != index))
                        )), "hover-stay-time" to 150, "hover-class" to "fui-dropdown__item-active", "style" to _nS(_uM("background" to _ctx.background, "padding" to _ctx.padding, "borderBottomColor" to if (_ctx.splitLine) {
                            _ctx.lineColor
                        } else {
                            "transparent"
                        }
                        )), "onClick" to withModifiers(fun(){
                            _ctx.itemClick(index)
                        }
                        , _uA(
                            "stop"
                        ))), _uA(
                            if (isTrue(_ctx.isCheckbox)) {
                                _cE("view", _uM("key" to 0, "class" to _nC(_uA(
                                    "fui-ddm__checkbox",
                                    _uM("fui-is__checkmark" to _ctx.isCheckMark, "fui-ddm__checkbox-color" to (_ctx.checkboxColor == "" && model.checked == true && !_ctx.isCheckMark))
                                )), "style" to _nS(_uM("background" to if (model.checked == true && !_ctx.isCheckMark) {
                                    _ctx.checkboxColor
                                } else {
                                    "transparent"
                                }, "borderColor" to if (model.checked == true && !_ctx.isCheckMark) {
                                    _ctx.checkboxColor
                                } else {
                                    _ctx.borderColor
                                }))), _uA(
                                    if (model.checked == true) {
                                        _cE("view", _uM("key" to 0, "class" to "fui-ddm__checkmark", "style" to _nS(_uM("borderBottomColor" to _ctx.checkmarkColor, "borderRightColor" to _ctx.checkmarkColor))), null, 4)
                                    } else {
                                        _cC("v-if", true)
                                    }
                                ), 6)
                            } else {
                                _cC("v-if", true)
                            }
                            ,
                            _cE("view", _uM("class" to "fui-ddm__flex"), _uA(
                                if (isTrue(model.src != "" && model.src != null)) {
                                    _cE("view", _uM("key" to 0, "class" to _nC(_uA(
                                        "fui-ddm__icon-box",
                                        _uM("fui-ddm__icon-ml" to (!_ctx.isReverse && _ctx.isCheckbox), "fui-ddm__icon-mr" to _ctx.isReverse)
                                    )), "style" to _nS(_uM("width" to ("" + _ctx.iconWidth + "rpx"), "height" to ("" + _ctx.iconWidth + "rpx"), "background" to _ctx.iconBackground))), _uA(
                                        _cE("image", _uM("src" to model.src, "style" to _nS(_uM("width" to ("" + _ctx.iconWidth + "rpx"), "height" to ("" + _ctx.iconWidth + "rpx")))), null, 12, _uA(
                                            "src"
                                        ))
                                    ), 6)
                                } else {
                                    _cC("v-if", true)
                                }
                                ,
                                _cE("text", _uM("class" to _nC(_uA(
                                    "fui-ddm__item-text",
                                    _uM("fui-ddm__text-pl" to (!_ctx.isReverse && (_ctx.isCheckbox || (model.src != "" && model.src != null))), "fui-ddm__text-pr" to (_ctx.isReverse && (_ctx.isCheckbox || (model.src != "" && model.src != null))))
                                )), "style" to _nS(_uM("fontSize" to ("" + _ctx.size + "px"), "color" to if (_ctx.selectedColor != "" && model.checked == true) {
                                    _ctx.selectedColor
                                } else {
                                    _ctx.color
                                }
                                ))), _tD(model.text), 7)
                            ))
                        ), 14, _uA(
                            "onClick"
                        ))
                    }
                    ), 128)
                ), 4)
            ), 6)
        ), 8, _uA(
            "id"
        ))
    }
    open var menus: UTSArray<FuiDropdownMenuOptionParam> by `$props`
    open var maxHeight: Number by `$props`
    open var minWidth: Number by `$props`
    open var left: Number by `$props`
    open var right: Number by `$props`
    open var background: String by `$props`
    open var radius: Number by `$props`
    open var padding: String by `$props`
    open var isCheckbox: Boolean by `$props`
    open var checkboxColor: String by `$props`
    open var borderColor: String by `$props`
    open var isCheckMark: Boolean by `$props`
    open var checkmarkColor: String by `$props`
    open var isReverse: Boolean by `$props`
    open var splitLine: Boolean by `$props`
    open var lineColor: String by `$props`
    open var iconWidth: Number by `$props`
    open var iconBackground: String by `$props`
    open var size: Number by `$props`
    open var color: String by `$props`
    open var selectedColor: String by `$props`
    open var maskBackground: String by `$props`
    open var direction: String by `$props`
    open var zIndex: Number by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    open var boxId: Any? by `$data`
    open var refId: Any? by `$data`
    open var refMkId: Any? by `$data`
    open var itemList: UTSArray<FuiDropdownMenuOptionParam> by `$data`
    open var element: UniElement? by `$data`
    open var maskElement: UniElement? by `$data`
    open var wrap_left: Number by `$data`
    open var wrap_top: Number by `$data`
    open var getStyles: String by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        val boxId = "fui_ddmc_" + parseInt(Math.ceil(Math.random() * 10e5).toString(10), 36)
        val refId = "fui_ddm_" + parseInt(Math.ceil(Math.random() * 10e5).toString(10), 36)
        val refMkId = "fui_ddmmk_" + parseInt(Math.ceil(Math.random() * 10e5).toString(10), 36)
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml, "boxId" to boxId, "refId" to refId, "refMkId" to refMkId, "itemList" to _uA<FuiDropdownMenuOptionParam>(), "element" to null as UniElement?, "maskElement" to null as UniElement?, "wrap_left" to 0, "wrap_top" to 0, "getStyles" to computed<String>(fun(): String {
            var styles = "top:" + this.wrap_top + "px; border-radius:" + this.radius + "rpx;background:" + this.background + ";z-index:" + this.zIndex + ";"
            if (this.right >= 0) {
                styles += "right:" + this.right + "rpx;"
            } else {
                val left = this.rpx2px(this.left)
                styles += "left:" + (left + this.wrap_left) + "px;"
            }
            return styles
        }
        ))
    }
    open var rpx2px = ::gen_rpx2px_fn
    open fun gen_rpx2px_fn(rpx: Number): Number {
        return uni_rpx2px(rpx)
    }
    open var getPosition = ::gen_getPosition_fn
    open fun gen_getPosition_fn(callback: (res: Boolean) -> Unit) {
        uni_createSelectorQuery().select("#" + this.boxId).boundingClientRect().exec(fun(ret){
            val node = ret[0] as NodeInfo
            val height = node.height as Number
            val top = node.top as Number
            this.wrap_left = node.left as Number
            this.wrap_top = if (this.direction == "down") {
                height + top
            } else {
                top
            }
            callback(true)
        }
        )
    }
    open var initData = ::gen_initData_fn
    open fun gen_initData_fn(vals: UTSArray<FuiDropdownMenuOptionParam>) {
        vals.map(fun(item){
            item.checked = if (item.checked == null) {
                false
            } else {
                item.checked
            }
            item.disabled = if (item.disabled == null) {
                false
            } else {
                item.disabled
            }
        }
        )
        this.itemList = vals
    }
    open var itemClick = ::gen_itemClick_fn
    open fun gen_itemClick_fn(index: Number) {
        val items = JSON.parse<UTSArray<FuiDropdownMenuOptionParam>>(JSON.stringify(this.itemList))
        if (items != null) {
            items.forEach(fun(item, idx){
                if (index == idx) {
                    item.checked = true
                } else {
                    item.checked = false
                }
            }
            )
            this.itemList = items
            val item = items[index]
            item.index = index
            this.`$emit`("onclick", item)
            this.close(2)
        }
    }
    open var getEl = ::gen_getEl_fn
    open fun gen_getEl_fn() {
        if (this.element == null) {
            this.element = this.`$refs`[this.refId] as UniElement
        }
        if (this.maskElement == null) {
            this.maskElement = this.`$refs`[this.refMkId] as UniElement
        }
    }
    open var close = ::gen_close_fn
    open fun gen_close_fn(type: Number) {
        this.getEl()
        this.maskElement!!.style.setProperty("opacity", "0")
        this.element!!.style.setProperty("opacity", "0")
        if (this.direction == "up") {
            this.element!!.style.setProperty("transform", "scaleY(0) translateY(-100%)")
        } else {
            this.element!!.style.setProperty("transform", "scaleY(0)")
        }
        setTimeout(fun(){
            this.element!!.style.setProperty("visibility", "hidden")
            this.maskElement!!.style.setProperty("visibility", "hidden")
        }
        , 300)
        if (type == 1) {
            this.`$emit`("close")
        }
    }
    open var show = ::gen_show_fn
    open fun gen_show_fn() {
        this.getEl()
        this.getPosition(fun(res: Boolean){
            if (res) {
                this.`$nextTick`(fun(){
                    this.maskElement!!.style.setProperty("opacity", "1")
                    this.maskElement!!.style.setProperty("visibility", "visible")
                    this.element!!.style.setProperty("opacity", "1")
                    this.element!!.style.setProperty("visibility", "visible")
                    if (this.direction == "up") {
                        this.element!!.style.setProperty("transform", "scaleY(1) translateY(-100%)")
                    } else {
                        this.element!!.style.setProperty("transform", "scaleY(1)")
                    }
                }
                )
            }
        }
        )
    }
    companion object {
        var name = "fui-dropdown-menu"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("fui-dropdown__menu" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "fui-ddm__scroll" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "fui-dropdown__menu-list" to _pS(_uM("position" to "fixed", "transitionTimingFunction" to "ease-in-out", "transitionDuration" to "0.3s", "transitionProperty" to "visibility,opacity,transform", "boxShadow" to "0 0 10rpx rgba(2, 4, 38, 0.05)", "display" to "flex", "flexDirection" to "row", "boxSizing" to "border-box")), "fui-ddm__down" to _pS(_uM("transformOrigin" to "0 0", "transform" to "scaleY(0)", "opacity" to 0, "visibility" to "hidden")), "fui-ddm__up" to _pS(_uM("transformOrigin" to "0 100%", "transform" to "scaleY(0) translateY(-100%)", "opacity" to 0, "visibility" to "hidden")), "fui-ddm__mask" to _pS(_uM("position" to "fixed", "top" to 0, "left" to 0, "right" to 0, "bottom" to 0, "transitionDuration" to "0.3s", "transitionProperty" to "visibility,opacity", "opacity" to 0, "visibility" to "hidden")), "fui-dropdown__menu-item" to _pS(_uM("width" to "100%", "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "backgroundImage" to "none", "backgroundColor" to "#FFFFFF", "position" to "relative", "boxSizing" to "border-box")), "fui-dropdown__item-active" to _pS(_uM("!backgroundImage" to "none", "!backgroundColor" to "rgba(0,0,0,0.2)")), "fui-ddm__flex" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "boxSizing" to "border-box")), "fui-ddm__item-line" to _pS(_uM("position" to "relative", "borderBottomWidth" to 0.5, "borderBottomStyle" to "solid")), "fui-ddm__reverse" to _pS(_uM("justifyContent" to "space-between", "flexDirection" to "row-reverse")), "fui-ddm__checkbox" to _pS(_uM("width" to "40rpx", "height" to "40rpx", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopLeftRadius" to "40rpx", "borderTopRightRadius" to "40rpx", "borderBottomRightRadius" to "40rpx", "borderBottomLeftRadius" to "40rpx", "boxSizing" to "border-box", "flexShrink" to 0, "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "overflow" to "hidden", "position" to "relative")), "fui-ddm__checkbox-color" to _pS(_uM("!backgroundImage" to "none", "!backgroundColor" to "#465CFF", "!borderTopColor" to "#465CFF", "!borderRightColor" to "#465CFF", "!borderBottomColor" to "#465CFF", "!borderLeftColor" to "#465CFF", "transitionProperty" to "borderColor", "transitionDuration" to "0.2s")), "fui-is__checkmark" to _pS(_uM("!borderTopWidth" to 0, "!borderRightWidth" to 0, "!borderBottomWidth" to 0, "!borderLeftWidth" to 0, "!backgroundImage" to "none", "!backgroundColor" to "rgba(0,0,0,0)")), "fui-ddm__checkmark" to _pS(_uM("width" to "20rpx", "height" to "40rpx", "borderBottomStyle" to "solid", "borderBottomWidth" to 3, "borderRightStyle" to "solid", "borderRightWidth" to 3, "boxSizing" to "border-box", "transform" to "rotate(45deg) scale(0.5)", "transformOrigin" to "54% 48%")), "fui-ddm__item-text" to _pS(_uM("fontWeight" to "normal", "flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "fui-ddm__text-pl" to _pS(_uM("paddingLeft" to "24rpx")), "fui-ddm__text-pr" to _pS(_uM("paddingRight" to "24rpx")), "fui-ddm__icon-box" to _pS(_uM("overflow" to "hidden", "flexShrink" to 0)), "fui-ddm__icon-ml" to _pS(_uM("marginLeft" to "24rpx")), "fui-ddm__icon-mr" to _pS(_uM("marginRight" to "24rpx")), "@TRANSITION" to _uM("fui-dropdown__menu-list" to _uM("timingFunction" to "ease-in-out", "duration" to "0.3s", "property" to "visibility,opacity,transform"), "fui-ddm__mask" to _uM("duration" to "0.3s", "property" to "visibility,opacity"), "fui-ddm__checkbox-color" to _uM("property" to "borderColor", "duration" to "0.2s")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("onclick" to null, "close" to null)
        var props = _nP(_uM("menus" to _uM("type" to "Array", "default" to fun(): UTSArray<FuiDropdownMenuOptionParam> {
            return _uA<FuiDropdownMenuOptionParam>()
        }
        ), "maxHeight" to _uM("type" to "Number", "default" to 400), "minWidth" to _uM("type" to "Number", "default" to 0), "left" to _uM("type" to "Number", "default" to 0), "right" to _uM("type" to "Number", "default" to -1), "background" to _uM("type" to "String", "default" to "#FFFFFF"), "radius" to _uM("type" to "Number", "default" to 0), "padding" to _uM("type" to "String", "default" to "32rpx"), "isCheckbox" to _uM("type" to "Boolean", "default" to true), "checkboxColor" to _uM("type" to "String", "default" to ""), "borderColor" to _uM("type" to "String", "default" to "#CCCCCC"), "isCheckMark" to _uM("type" to "Boolean", "default" to false), "checkmarkColor" to _uM("type" to "String", "default" to "#FFFFFF"), "isReverse" to _uM("type" to "Boolean", "default" to false), "splitLine" to _uM("type" to "Boolean", "default" to false), "lineColor" to _uM("type" to "String", "default" to "#EEEEEE"), "iconWidth" to _uM("type" to "Number", "default" to 48), "iconBackground" to _uM("type" to "String", "default" to "transparent"), "size" to _uM("type" to "Number", "default" to 32), "color" to _uM("type" to "String", "default" to "#181818"), "selectedColor" to _uM("type" to "String", "default" to ""), "maskBackground" to _uM("type" to "String", "default" to "transparent"), "direction" to _uM("type" to "String", "default" to "down"), "zIndex" to _uM("type" to "Number", "default" to 990)))
        var propsNeedCastKeys = _uA(
            "menus",
            "maxHeight",
            "minWidth",
            "left",
            "right",
            "background",
            "radius",
            "padding",
            "isCheckbox",
            "checkboxColor",
            "borderColor",
            "isCheckMark",
            "checkmarkColor",
            "isReverse",
            "splitLine",
            "lineColor",
            "iconWidth",
            "iconBackground",
            "size",
            "color",
            "selectedColor",
            "maskBackground",
            "direction",
            "zIndex"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
