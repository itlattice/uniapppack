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
open class GenComponentsXIconfont : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
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
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXIconfont) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXIconfont
            val _cache = __ins.renderCache
            val props = __props
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val color = computed(fun(): String {
                return props.color
            }
            )
            val primary = computed(fun(): Boolean {
                return props.primary
            }
            )
            val iconsObj = default__5 as UTSJSONObject
            val getSize = computed(fun(): String {
                var size: String
                if (UTSAndroid.`typeof`(props.size) == "number") {
                    size = (props.size as Number).toString(10) + props.unit
                } else if (UTSAndroid.`typeof`(props.size) == "string") {
                    size = (props.size as String) + props.unit
                } else {
                    size = (props.size as Any).toString() + props.unit
                }
                return size
            }
            )
            val isBind = computed(fun(): Boolean {
                val size = getSize.value
                var bind = false
                if (size == "" || size == "px" || size == "rpx" || size == "0rpx" || size == "0px") {
                    bind = true
                }
                return bind
            }
            )
            val getIcon = computed(fun(): String {
                val icon = iconsObj.getString(props.name)
                return if (icon == null) {
                    ""
                } else {
                    icon
                }
            }
            )
            val getIconStyl = computed(fun(): Any {
                val mp: Map<String, String> = Map()
                mp.set("fontWeight", props.fontWeight)
                mp.set("fontSize", getSize.value)
                if (props.height < 1) {
                    mp.set("lineHeight", getSize.value)
                } else {
                    mp.set("lineHeight", props.height + "px")
                }
                if (props.color != "") {
                    mp.set("color", props.color)
                }
                return mp
            }
            )
            val handleClick = fun(){
                if (props.disabled) {
                    return
                }
                emit("onclick", props.param)
            }
            return fun(): Any? {
                return _cE("text", _uM("style" to _nS(unref(getIconStyl)), "class" to _nC(_uA(
                    "xu-iconfont",
                    _uM("xu-iconfont__fontsize" to unref(isBind), "xu-iconfont__active-color" to (unref(primary) && unref(color) == ""), "xu-iconfont__color" to (unref(color) == "" && !unref(primary)))
                )), "onClick" to handleClick), _tD(unref(getIcon)), 7)
            }
        }
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
