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
open class GenUniModulesIboxsChoosemediaComponentsXuCheckbox : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onCreated(fun() {
            this.`val` = this.checked
            this.getParent("xu-checkbox-group")
            if (this.xCkGroup != null) {
                val group = this.xCkGroup as ComponentPublicInstance
                (group.`$data`["childrens"] as UTSArray<ComponentPublicInstance>).push(this as ComponentPublicInstance)
                val modelValue = group.`$props`["modelValue"] as UTSArray<String>
                if (modelValue.length > 0) {
                    this.`val` = modelValue.includes(this.value)
                }
            }
            val parent = this.getParent("xu-label")
            if (parent) {
                val label = this.xLabel as ComponentPublicInstance
                (label.`$data`["childrens"] as UTSArray<ComponentPublicInstance>).push(this as ComponentPublicInstance)
            }
        }
        , __ins)
        this.`$watch`(fun(): Any? {
            return this.checked
        }
        , fun(newVal: Boolean) {
            this.`val` = newVal
        }
        )
        this.`$watch`(fun(): Any? {
            return this.`val`
        }
        , fun() {
            if (this.xCkGroup != null) {
                val group = this.xCkGroup as ComponentPublicInstance
                group.`$callMethod`("changeValue")
            }
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
            "x-checkbox__input",
            _uA(
                if (_ctx.scaleRatio != 1) {
                    "xu-checkbox__scale-" + _ctx.scaleAlign
                } else {
                    ""
                }
                ,
                if (_ctx.disabled) {
                    "xu-checkbox__disabled"
                } else {
                    ""
                }
                ,
                if (_ctx.color == "" && _ctx.styleVal && !_ctx.isCheckMark) {
                    "xu-checkbox__color"
                } else {
                    ""
                }
                ,
                if (_ctx.normalColor == "" && !_ctx.styleVal && !_ctx.isCheckMark) {
                    "xu-checkbox__background"
                } else {
                    ""
                }
                ,
                if (_ctx.borderColor == "" && !_ctx.styleVal && !_ctx.isCheckMark) {
                    "xu-checkbox__normal-border"
                } else {
                    ""
                }
            )
        )), "style" to _nS(_ctx.getStyl), "onClick" to withModifiers(_ctx.checkboxClick, _uA(
            "stop"
        ))), _uA(
            if (isTrue(_ctx.`val`)) {
                _cE("view", _uM("key" to 0, "class" to _nC(_uA(
                    "x-check__mark",
                    _uM("xu-checkbox__mark-color" to (_ctx.checkMarkColor == ""))
                )), "style" to _nS(_ctx.getMarkStyl)), null, 6)
            } else {
                _cC("v-if", true)
            }
        ), 14, _uA(
            "onClick"
        ))
    }
    open var value: String by `$props`
    open var checked: Boolean by `$props`
    open var disabled: Boolean by `$props`
    open var color: String by `$props`
    open var normalColor: String by `$props`
    open var borderColor: String by `$props`
    open var borderRadius: String by `$props`
    open var isCheckMark: Boolean by `$props`
    open var checkMarkColor: String by `$props`
    open var scaleRatio: Number by `$props`
    open var scaleAlign: String by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    open var `val`: Boolean by `$data`
    open var styleVal: Boolean by `$data`
    open var xLabel: ComponentPublicInstance? by `$data`
    open var xCkGroup: ComponentPublicInstance? by `$data`
    open var getStyl: Any by `$data`
    open var getMarkStyl: Any by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml, "val" to false, "styleVal" to false, "xLabel" to null as ComponentPublicInstance?, "xCkGroup" to null as ComponentPublicInstance?, "getStyl" to computed<Any>(fun(): Any {
            val mp: Map<String, String> = Map()
            mp.set("transform", "scale(" + this.scaleRatio + ")")
            mp.set("border-radius", this.borderRadius)
            var color = if (this.`val`) {
                this.color
            } else {
                if (this.borderColor == "") {
                    this.color
                } else {
                    this.borderColor
                }
            }
            val bgColor = if (this.`val`) {
                this.color
            } else {
                this.normalColor
            }
            if (this.isCheckMark) {
                mp.set("border-color", "transparent")
                mp.set("background", "transparent")
            } else {
                if (color != "") {
                    mp.set("border-color", color)
                }
                if (bgColor != "") {
                    mp.set("background", bgColor)
                }
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
    open var checkboxClick = ::gen_checkboxClick_fn
    open fun gen_checkboxClick_fn(e: UniPointerEvent) {
        e.stopPropagation()
        this.checkboxChange()
    }
    open var checkboxChange = ::gen_checkboxChange_fn
    open fun gen_checkboxChange_fn() {
        if (this.disabled) {
            return
        }
        this.`val` = !this.`val`
        this.`$emit`("change", xCheckboxChangeParam(checked = this.`val`, value = this.value))
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
        if (name == "xu-checkbox-group") {
            this.xCkGroup = parent
        } else {
            this.xLabel = parent
        }
        return true
    }
    open var labelClick = ::gen_labelClick_fn
    open fun gen_labelClick_fn() {
        this.checkboxChange()
    }
    companion object {
        var name = "xu-checkbox"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("x-checkbox__input" to _pS(_uM("width" to "36rpx", "height" to "36rpx", "borderTopWidth" to 1.5, "borderRightWidth" to 1.5, "borderBottomWidth" to 1.5, "borderLeftWidth" to 1.5, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "boxSizing" to "border-box", "borderTopLeftRadius" to 30, "borderTopRightRadius" to 30, "borderBottomRightRadius" to 30, "borderBottomLeftRadius" to 30, "flexShrink" to 0, "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "overflow" to "hidden", "position" to "relative")), "x-checkbox__scale-left" to _pS(_uM("transformOrigin" to "0 center")), "x-checkbox__scale-center" to _pS(_uM("transformOrigin" to "center center")), "x-checkbox__scale-right" to _pS(_uM("transformOrigin" to "100% center")), "x-checkbox__color" to _pS(_uM("!backgroundImage" to "none", "!backgroundColor" to "#1678fd", "!borderTopColor" to "#1678fd", "!borderRightColor" to "#1678fd", "!borderBottomColor" to "#1678fd", "!borderLeftColor" to "#1678fd")), "x-checkbox__normal-border" to _pS(_uM("!borderTopColor" to "#CCCCCC", "!borderRightColor" to "#CCCCCC", "!borderBottomColor" to "#CCCCCC", "!borderLeftColor" to "#CCCCCC")), "x-checkbox__background" to _pS(_uM("!backgroundImage" to "none", "!backgroundColor" to "#ffffff00")), "x-checkbox__mark-color" to _pS(_uM("!borderBottomColor" to "#ffffff", "!borderRightColor" to "#ffffff")), "x-check__mark" to _pS(_uM("width" to "15rpx", "height" to "30rpx", "borderBottomStyle" to "solid", "borderBottomWidth" to 3, "borderBottomColor" to "#FFFFFF", "borderRightStyle" to "solid", "borderRightWidth" to 3, "borderRightColor" to "#FFFFFF", "boxSizing" to "border-box", "transform" to "rotate(45deg) scale(0.5)", "transformOrigin" to "54% 48%")), "x-checkbox__disabled" to _pS(_uM("opacity" to 0.6)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("change" to null)
        var props = _nP(_uM("value" to _uM("type" to "String", "default" to ""), "checked" to _uM("type" to "Boolean", "default" to false), "disabled" to _uM("type" to "Boolean", "default" to false), "color" to _uM("type" to "String", "default" to ""), "normalColor" to _uM("type" to "String", "default" to ""), "borderColor" to _uM("type" to "String", "default" to ""), "borderRadius" to _uM("type" to "String", "default" to "1px"), "isCheckMark" to _uM("type" to "Boolean", "default" to false), "checkMarkColor" to _uM("type" to "String", "default" to ""), "scaleRatio" to _uM("type" to "Number", "default" to 1), "scaleAlign" to _uM("type" to "String", "default" to "center")))
        var propsNeedCastKeys = _uA(
            "value",
            "checked",
            "disabled",
            "color",
            "normalColor",
            "borderColor",
            "borderRadius",
            "isCheckMark",
            "checkMarkColor",
            "scaleRatio",
            "scaleAlign"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
