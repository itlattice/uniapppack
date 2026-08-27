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
open class GenUniModulesFirstuiUvueComponentsFuiSwitchFuiSwitch : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onCreated(fun() {
            this.`val` = this.checked
            val parent = this.getParent("fui-label")
            if (parent) {
                this.isLabel = true
                val label = this.fuiLabel as ComponentPublicInstance
                (label.`$data`["childrens"] as UTSArray<ComponentPublicInstance>).push(this as ComponentPublicInstance)
            }
            val isForm = this.getParent("fui-form")
            if (isForm) {
                val form = this.fuiForm as ComponentPublicInstance
                (form.`$data`["formChildren"] as UTSArray<ComponentPublicInstance>).push(this as ComponentPublicInstance)
            }
        }
        , __ins)
        this.`$watch`(fun(): Any? {
            return this.checked
        }
        , fun(kVal: Boolean) {
            this.`val` = kVal
        }
        )
        this.`$watch`(fun(): Any? {
            return this.`val`
        }
        , fun() {
            setTimeout(fun(){
                this.styleVal = this.`val`
            }
            , 0)
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        return _cE("view", _uM("class" to _nC(_uA(
            "fui-switch__input",
            _uA(
                "fui-switch__size-" + _ctx.type,
                if (_ctx.scaleRatio != 1) {
                    "fui-switch__scale-" + _ctx.scaleAlign
                } else {
                    ""
                }
                ,
                if (_ctx.disabled && _ctx.disabledStyle) {
                    "fui-switch__checkbox-disabled"
                } else {
                    ""
                }
            )
        )), "style" to _nS(_uM("transform" to ("scale(" + _ctx.scaleRatio + ")")))), _uA(
            if (_ctx.type == "switch") {
                _cE("view", _uM("key" to 0, "class" to _nC(_uA(
                    "fui-switch__input-def",
                    _uM("fui-checkbox__disabled" to _ctx.disabled, "fui-switch__checked-color" to (_ctx.styleVal && _ctx.color == ""), "fui-switch__normal-bcolor" to (!_ctx.styleVal && _ctx.borderColor == ""), "fui-switch__normal-bg" to (!_ctx.styleVal && _ctx.transitionColor == ""))
                )), "style" to _nS(_ctx.getSwitchStyl), "onClick" to _ctx.onChange), _uA(
                    _cE("view", _uM("class" to _nC(_uA(
                        "fui-switch__input-before",
                        _uM("fui-switch__input--before" to _ctx.`val`, "fui-switch__before-bg" to (!_ctx.styleVal && _ctx.normalColor == ""))
                    )), "style" to _nS(_ctx.getBeforeBgColor)), null, 6),
                    _cE("view", _uM("class" to _nC(_uA(
                        "fui-switch__input-after",
                        _uM("fui-switch__input--after" to _ctx.`val`, "fui-switch__after-bg" to ((_ctx.btnColor == "" && _ctx.styleVal) || (!_ctx.styleVal && _ctx.btnNormalColor == "")))
                    )), "style" to _nS(_ctx.getStyle)), _uA(
                        renderSlot(_ctx.`$slots`, "default")
                    ), 6)
                ), 14, _uA(
                    "onClick"
                ))
            } else {
                _cE("view", _uM("key" to 1, "class" to _nC(_uA(
                    "fui-switch__checkbox-self",
                    _uM("fui-switch__checked-color" to (_ctx.styleVal && _ctx.color == ""), "fui-switch__normal-bcolor" to (!_ctx.styleVal && _ctx.borderColor == ""), "fui-switch__circle-bg" to (!_ctx.styleVal && _ctx.normalColor == ""))
                )), "style" to _nS(_ctx.getSwitchStyl), "onClick" to _ctx.onChange), _uA(
                    if (isTrue(_ctx.`val`)) {
                        _cE("view", _uM("key" to 0, "class" to _nC(_uA(
                            "fui-switch__check-mark",
                            _uM("fui-switch__mark-color" to (_ctx.checkMarkColor == ""))
                        )), "style" to _nS(_ctx.getMarkStyl)), null, 6)
                    } else {
                        _cC("v-if", true)
                    }
                ), 14, _uA(
                    "onClick"
                ))
            }
        ), 6)
    }
    open var name: String by `$props`
    open var checked: Boolean by `$props`
    open var disabled: Boolean by `$props`
    open var disabledStyle: Boolean by `$props`
    open var type: String by `$props`
    open var color: String by `$props`
    open var normalColor: String by `$props`
    open var transitionColor: String by `$props`
    open var btnColor: String by `$props`
    open var btnNormalColor: String by `$props`
    open var borderColor: String by `$props`
    open var checkMarkColor: String by `$props`
    open var scaleRatio: Number by `$props`
    open var scaleAlign: String by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    open var `val`: Boolean by `$data`
    open var styleVal: Boolean by `$data`
    open var isLabel: Boolean by `$data`
    open var fuiLabel: ComponentPublicInstance? by `$data`
    open var fuiForm: ComponentPublicInstance? by `$data`
    open var getStyle: Any by `$data`
    open var getSwitchStyl: Any by `$data`
    open var getBeforeBgColor: Any by `$data`
    open var getMarkStyl: Any by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml, "val" to false, "styleVal" to false, "isLabel" to false, "fuiLabel" to null as ComponentPublicInstance?, "fuiForm" to null as ComponentPublicInstance?, "getStyle" to computed<Any>(fun(): Any {
            val mp: Map<String, String> = Map()
            if (this.`val`) {
                if (this.btnColor != "") {
                    mp.set("background", this.btnColor)
                }
            } else {
                if (this.btnNormalColor != "") {
                    mp.set("background", this.btnNormalColor)
                }
            }
            return mp
        }
        ), "getSwitchStyl" to computed<Any>(fun(): Any {
            val mp: Map<String, String> = Map()
            if (this.`val`) {
                if (this.color != "") {
                    mp.set("borderColor", this.color)
                    mp.set("background", this.color)
                }
            } else {
                if (this.transitionColor != "") {
                    mp.set("background", this.transitionColor)
                }
                if (this.borderColor != "") {
                    mp.set("borderColor", this.borderColor)
                }
            }
            return mp
        }
        ), "getBeforeBgColor" to computed<Any>(fun(): Any {
            val mp: Map<String, String> = Map()
            if (this.normalColor != "") {
                mp.set("background", this.normalColor)
            }
            return mp
        }
        ), "getMarkStyl" to computed<Any>(fun(): Any {
            val mp: Map<String, String> = Map()
            if (this.checkMarkColor != "") {
                mp.set("borderBottomColor", this.checkMarkColor)
                mp.set("borderRightColor", this.checkMarkColor)
            }
            return mp
        }
        ))
    }
    open var onChange = ::gen_onChange_fn
    open fun gen_onChange_fn(e: UniPointerEvent) {
        e.stopPropagation()
        if (this.disabled) {
            return
        }
        this.emitChange(!this.`val`)
    }
    open var emitChange = ::gen_emitChange_fn
    open fun gen_emitChange_fn(e: Boolean) {
        this.`val` = e
        this.`$emit`("change", e)
        this.`$emit`("update:checked", e)
    }
    open var labelClick = ::gen_labelClick_fn
    open fun gen_labelClick_fn() {
        if (this.disabled) {
            return
        }
        this.emitChange(!this.`val`)
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
        if (name == "fui-label") {
            this.fuiLabel = parent
        } else if (name == "fui-form") {
            this.fuiForm = parent
        }
        return true
    }
    open var reset = ::gen_reset_fn
    open fun gen_reset_fn() {
        this.`val` = false
        this.`$emit`("change", false)
        this.`$emit`("update:checked", false)
    }
    open var getSubmitValue = ::gen_getSubmitValue_fn
    open fun gen_getSubmitValue_fn(): Boolean {
        return this.`val`
    }
    companion object {
        var name = "fui-switch"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("fui-switch__input" to _pS(_uM("flexShrink" to 0)), "fui-switch__scale-left" to _pS(_uM("transformOrigin" to "0 center")), "fui-switch__scale-center" to _pS(_uM("transformOrigin" to "center center")), "fui-switch__scale-right" to _pS(_uM("transformOrigin" to "100% center")), "fui-switch__size-switch" to _pS(_uM("width" to 52, "height" to 32)), "fui-switch__size-checkbox" to _pS(_uM("width" to "40rpx", "height" to "40rpx")), "fui-switch__checkbox-self" to _pS(_uM("width" to "40rpx", "height" to "40rpx", "borderTopLeftRadius" to 40, "borderTopRightRadius" to 40, "borderBottomRightRadius" to 40, "borderBottomLeftRadius" to 40, "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "position" to "relative", "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopColor" to "#CCCCCC", "borderRightColor" to "#CCCCCC", "borderBottomColor" to "#CCCCCC", "borderLeftColor" to "#CCCCCC", "boxSizing" to "border-box", "overflow" to "hidden")), "fui-switch__input-def" to _pS(_uM("position" to "relative", "width" to 52, "height" to 32, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#CCCCCC", "borderRightColor" to "#CCCCCC", "borderBottomColor" to "#CCCCCC", "borderLeftColor" to "#CCCCCC", "borderTopLeftRadius" to 16, "borderTopRightRadius" to 16, "borderBottomRightRadius" to 16, "borderBottomLeftRadius" to 16, "boxSizing" to "border-box")), "fui-switch__normal-bg" to _pS(_uM("!backgroundImage" to "none", "!backgroundColor" to "#dfdfdf")), "fui-switch__checked-color" to _pS(_uM("!backgroundImage" to "none", "!backgroundColor" to "#465CFF", "!borderTopColor" to "#465CFF", "!borderRightColor" to "#465CFF", "!borderBottomColor" to "#465CFF", "!borderLeftColor" to "#465CFF")), "fui-switch__normal-bcolor" to _pS(_uM("!borderTopColor" to "#CCCCCC", "!borderRightColor" to "#CCCCCC", "!borderBottomColor" to "#CCCCCC", "!borderLeftColor" to "#CCCCCC")), "fui-switch__input-before" to _pS(_uM("position" to "absolute", "top" to 0, "left" to 0, "width" to 50, "height" to 30, "borderTopLeftRadius" to 15, "borderTopRightRadius" to 15, "borderBottomRightRadius" to 15, "borderBottomLeftRadius" to 15, "transitionProperty" to "transform", "transitionDuration" to "0.3s")), "fui-switch__before-bg" to _pS(_uM("!backgroundImage" to "none", "!backgroundColor" to "#FFFFFF")), "fui-switch__input-after" to _pS(_uM("position" to "absolute", "top" to 0, "left" to 0, "width" to 30, "height" to 30, "borderTopLeftRadius" to 15, "borderTopRightRadius" to 15, "borderBottomRightRadius" to 15, "borderBottomLeftRadius" to 15, "boxShadow" to "0 0 6rpx rgba(0, 0, 0, 0.4)", "transitionProperty" to "transform", "transitionDuration" to "0.3s", "display" to "flex", "alignItems" to "center", "justifyContent" to "center", "transform" to "translateX(0)")), "fui-switch__after-bg" to _pS(_uM("!backgroundImage" to "none", "!backgroundColor" to "#FFFFFF")), "fui-switch__input--before" to _pS(_uM("transform" to "scale(0)")), "fui-switch__input--after" to _pS(_uM("transform" to "translateX(20px)")), "fui-switch__check-mark" to _pS(_uM("width" to "20rpx", "height" to "40rpx", "borderBottomStyle" to "solid", "borderBottomWidth" to 3, "borderBottomColor" to "#FFFFFF", "borderRightStyle" to "solid", "borderRightWidth" to 3, "borderRightColor" to "#FFFFFF", "transform" to "rotate(45deg) scale(0.5)", "transformOrigin" to "54% 48%", "boxSizing" to "border-box")), "fui-switch__circle-bg" to _pS(_uM("!backgroundImage" to "none", "!backgroundColor" to "#FFFFFF")), "fui-switch__mark-color" to _pS(_uM("!borderBottomColor" to "#FFFFFF", "!borderRightColor" to "#FFFFFF")), "fui-switch__checkbox-disabled" to _pS(_uM("opacity" to 0.6)), "@TRANSITION" to _uM("fui-switch__input-before" to _uM("property" to "transform", "duration" to "0.3s"), "fui-switch__input-after" to _uM("property" to "transform", "duration" to "0.3s")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("change" to null, "update:checked" to null)
        var props = _nP(_uM("name" to _uM("type" to "String", "default" to ""), "checked" to _uM("type" to "Boolean", "default" to false), "disabled" to _uM("type" to "Boolean", "default" to false), "disabledStyle" to _uM("type" to "Boolean", "default" to true), "type" to _uM("type" to "String", "default" to "switch"), "color" to _uM("type" to "String", "default" to ""), "normalColor" to _uM("type" to "String", "default" to ""), "transitionColor" to _uM("type" to "String", "default" to ""), "btnColor" to _uM("type" to "String", "default" to ""), "btnNormalColor" to _uM("type" to "String", "default" to ""), "borderColor" to _uM("type" to "String", "default" to ""), "checkMarkColor" to _uM("type" to "String", "default" to ""), "scaleRatio" to _uM("type" to "Number", "default" to 1), "scaleAlign" to _uM("type" to "String", "default" to "center")))
        var propsNeedCastKeys = _uA(
            "name",
            "checked",
            "disabled",
            "disabledStyle",
            "type",
            "color",
            "normalColor",
            "transitionColor",
            "btnColor",
            "btnNormalColor",
            "borderColor",
            "checkMarkColor",
            "scaleRatio",
            "scaleAlign"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
