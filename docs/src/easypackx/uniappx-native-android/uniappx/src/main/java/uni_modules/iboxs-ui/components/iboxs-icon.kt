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
open class GenUniModulesIboxsUiComponentsIboxsIcon : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        return _cE("text", _uM("style" to _nS(_ctx.getIconStyl), "class" to _nC(_uA(
            "xu-iconfont",
            _uM("xu-iconfont__fontsize" to _ctx.isBind, "xu-iconfont__active-color" to (_ctx.primary && _ctx.color == ""), "xu-iconfont__color" to (_ctx.color == "" && !_ctx.primary))
        )), "onClick" to _ctx.handleClick), _tD(_ctx.getIcon), 15, _uA(
            "onClick"
        ))
    }
    open var name: String by `$props`
    open var size: Any by `$props`
    open var unit: String by `$props`
    open var color: String by `$props`
    open var fontWeight: String by `$props`
    open var disabled: Boolean by `$props`
    open var param: String by `$props`
    open var primary: Boolean by `$props`
    open var height: Number by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    open var icons: UTSJSONObject by `$data`
    open var getSize: String by `$data`
    open var isBind: Boolean by `$data`
    open var getIcon: String by `$data`
    open var getIconStyl: Any by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml, "icons" to default__5 as UTSJSONObject, "getSize" to computed<String>(fun(): String {
            var size: String
            if (UTSAndroid.`typeof`(this.size) == "number") {
                size = (this.size as Number).toString(10) + this.unit
            } else if (UTSAndroid.`typeof`(this.size) == "string") {
                size = (this.size as String) + this.unit
            } else {
                size = this.size.toString() + this.unit
            }
            return size
        }
        ), "isBind" to computed<Boolean>(fun(): Boolean {
            val size = this.getSize
            var bind = false
            if (size == "" || size == "px" || size == "rpx" || size == "0rpx" || size == "0px") {
                bind = true
            }
            return bind
        }
        ), "getIcon" to computed<String>(fun(): String {
            val icon = this.icons.getString(this.name)
            return if (icon == null) {
                ""
            } else {
                icon
            }
        }
        ), "getIconStyl" to computed<Any>(fun(): Any {
            val mp: Map<String, String> = Map()
            mp.set("fontWeight", this.fontWeight)
            mp.set("fontSize", this.getSize)
            if (this.height < 1) {
                mp.set("lineHeight", this.getSize)
            } else {
                mp.set("lineHeight", this.height + "px")
            }
            if (this.color != "") {
                mp.set("color", this.color)
            }
            return mp
        }
        ))
    }
    open var handleClick = ::gen_handleClick_fn
    open fun gen_handleClick_fn() {
        if (this.disabled) {
            return
        }
        this.`$emit`("onclick", this.param)
    }
    companion object {
        var name = "iboxs-iconfont"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("xu-iconfont" to _pS(_uM("fontFamily" to "iconfont")), "xu-iconfont__color" to _pS(_uM("!color" to "#333333")), "xu-iconfont__active-color" to _pS(_uM("!color" to "#465CFF")), "xu-iconfont__fontsize" to _pS(_uM("!fontSize" to "64rpx", "!lineHeight" to "64rpx")), "@FONT-FACE" to _uM("0" to _uM("fontFamily" to "iconfont", "src" to "url(\"/static/iconfont.ttf\")")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("onclick" to null)
        var props = _nP(_uM("name" to _uM("type" to "String", "default" to ""), "size" to _uM("type" to _uA(
            "Object",
            "String",
            "Number"
        ), "default" to 0), "unit" to _uM("type" to "String", "default" to "px"), "color" to _uM("type" to "String", "default" to ""), "fontWeight" to _uM("type" to "String", "default" to "normal"), "disabled" to _uM("type" to "Boolean", "default" to false), "param" to _uM("type" to "String", "default" to "0"), "primary" to _uM("type" to "Boolean", "default" to false), "height" to _uM("type" to "Number", "default" to 0)))
        var propsNeedCastKeys = _uA(
            "name",
            "size",
            "unit",
            "color",
            "fontWeight",
            "disabled",
            "param",
            "primary",
            "height"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
