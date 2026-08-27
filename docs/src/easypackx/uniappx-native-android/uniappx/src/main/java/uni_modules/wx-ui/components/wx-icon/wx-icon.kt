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
open class GenUniModulesWxUiComponentsWxIconWxIcon : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        return if (isTrue(_ctx.isImg)) {
            _cE("image", _uM("key" to 0, "class" to "wx-icon-img", "src" to _ctx.name, "style" to _nS(_uA(
                _ctx.imgStyle
            )), "mode" to _ctx.imgMode, "onClick" to _ctx.clickHandler), null, 12, _uA(
                "src",
                "mode",
                "onClick"
            ))
        } else {
            _cE("text", _uM("key" to 1, "class" to _nC(_uA(
                "wx-icon",
                _uA(
                    _ctx.customPrefix,
                    _ctx.customClass
                )
            )), "style" to _nS(_uA(
                _ctx.iconStyle,
                _ctx.customStyle
            )), "onClick" to _ctx.clickHandler), _tD(_ctx.icon), 15, _uA(
                "onClick"
            ))
        }
    }
    open var name: String by `$props`
    open var color: String by `$props`
    open var size: Number by `$props`
    open var bold: Boolean by `$props`
    open var customPrefix: String by `$props`
    open var imgMode: String by `$props`
    open var width: Number by `$props`
    open var height: Number by `$props`
    open var top: Number by `$props`
    open var stop: Boolean by `$props`
    open var customStyle: UTSArray<Any> by `$props`
    open var customClass: UTSArray<Any> by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    open var useColor: String by `$data`
    open var icon: String by `$data`
    open var isImg: Boolean by `$data`
    open var iconStyle: Any by `$data`
    open var imgStyle: Any by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml, "useColor" to computed<String>(fun(): String {
            return if (this.color != "") {
                this.color
            } else {
                wxConfig.theme.main
            }
        }
        ), "icon" to computed<String>(fun(): String {
            var icon = icons.filter(fun(item: IconType): Boolean {
                return item.name == "wxicon-" + this.name
            }
            )
            return if (icon.length > 0) {
                icon[0].unicode
            } else {
                this.name
            }
        }
        ), "isImg" to computed<Boolean>(fun(): Boolean {
            val isBase64 = this.name.indexOf("data:") > -1 && this.name.indexOf("base64") > -1
            return this.name.indexOf("/") != -1 || isBase64
        }
        ), "iconStyle" to computed<Any>(fun(): Any {
            var style: UTSJSONObject = _uO("fontSize" to (this.size + "px"), "lineHeight" to (this.size + "px"), "fontWeight" to if (this.bold) {
                "bold"
            } else {
                "normal"
            }
            , "color" to this.useColor)
            if (this.top != 0) {
                style["top"] = this.top + "px"
            }
            return style
        }
        ), "imgStyle" to computed<Any>(fun(): Any {
            var style: UTSJSONObject = _uO("width" to if (this.width != 0) {
                this.width + "px"
            } else {
                this.size + "px"
            }
            , "height" to if (this.height != 0) {
                this.height + "px"
            } else {
                this.size + "px"
            }
            )
            return style
        }
        ))
    }
    open var clickHandler = ::gen_clickHandler_fn
    open fun gen_clickHandler_fn(e: UniPointerEvent) {
        this.`$emit`("click", e)
        if (this.stop) {
            e.stopPropagation()
        }
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("wx-icon" to _pS(_uM("fontFamily" to "wxicon-iconfont", "position" to "relative")), "@FONT-FACE" to _uM("0" to _uM("fontFamily" to "wxicon-iconfont", "src" to "url(\"/assets/wx-icons.d0eb9965.ttf\")")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("click" to null)
        var props = _nP(_uM("name" to _uM("type" to "String", "default" to ""), "color" to _uM("type" to "String", "default" to ""), "size" to _uM("type" to "Number", "default" to 16), "bold" to _uM("type" to "Boolean", "default" to false), "customPrefix" to _uM("type" to "String", "default" to "wxicon"), "imgMode" to _uM("type" to "String", "default" to ""), "width" to _uM("type" to "Number", "default" to 0), "height" to _uM("type" to "Number", "default" to 0), "top" to _uM("type" to "Number", "default" to 0), "stop" to _uM("type" to "Boolean", "default" to false), "customStyle" to _uM("type" to "Array", "default" to fun(): UTSArray<Any> {
            return _uA()
        }
        ), "customClass" to _uM("type" to "Array", "default" to fun(): UTSArray<Any> {
            return _uA()
        }
        )))
        var propsNeedCastKeys = _uA(
            "name",
            "color",
            "size",
            "bold",
            "customPrefix",
            "imgMode",
            "width",
            "height",
            "top",
            "stop",
            "customStyle",
            "customClass"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
