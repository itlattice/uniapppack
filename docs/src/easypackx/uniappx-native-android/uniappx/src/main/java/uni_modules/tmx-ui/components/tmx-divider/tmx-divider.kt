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
open class GenUniModulesTmxUiComponentsTmxDividerTmxDivider : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var align: String by `$props`
    open var label: String by `$props`
    open var color: String by `$props`
    open var darkColor: String by `$props`
    open var lineWidth: String by `$props`
    open var height: String by `$props`
    open var labelColor: String by `$props`
    open var model: String by `$props`
    open var fontSize: String by `$props`
    open var vertical: Boolean by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesTmxUiComponentsTmxDividerTmxDivider) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesTmxUiComponentsTmxDividerTmxDivider
            val _cache = __ins.renderCache
            val props = __props
            val id = ref("xDivider" + Date.now())
            val _label = computed(fun(): String {
                return props.label
            }
            )
            val _lineWidth = computed(fun(): String {
                return checkIsCssUnit(props.lineWidth, xConfig.unit)
            }
            )
            val _fontSize = computed(fun(): String {
                return checkIsCssUnit(props.fontSize, xConfig.unit)
            }
            )
            val _height = computed(fun(): String {
                return checkIsCssUnit(props.height, xConfig.unit)
            }
            )
            val _color = computed(fun(): String {
                if (xConfig.dark == "dark") {
                    if (props.darkColor != "") {
                        return getDefaultColor(props.darkColor)
                    }
                    return xConfig.borderDarkColor
                }
                return getDefaultColor(props.color)
            }
            )
            val _model = computed(fun(): String {
                return props.model
            }
            )
            val _labelColor = computed(fun(): String {
                return getDefaultColor(props.labelColor)
            }
            )
            val _vertical = computed(fun(): Boolean {
                return props.vertical
            }
            )
            return fun(): Any? {
                return _cE("view", _uM("class" to "xDivider", "style" to _nS(_uM("height" to if (_vertical.value) {
                    _height.value
                } else {
                    "auto"
                }
                , "border-left" to if (_vertical.value) {
                    "" + _lineWidth.value + " " + _model.value + " " + _color.value
                } else {
                    "none"
                }
                ))), _uA(
                    if (isTrue(!_vertical.value)) {
                        _cE("view", _uM("key" to 0, "class" to "xDividerLeft", "style" to _nS(_uM("flex" to if (_ctx.align == "left") {
                            1
                        } else {
                            6
                        }, "border-bottom" to ("" + _lineWidth.value + " " + _model.value + " " + _color.value)))), null, 4)
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    renderSlot(_ctx.`$slots`, "default", _uO(), fun(): UTSArray<Any> {
                        return _uA(
                            if (isTrue(_label.value != "" && !_vertical.value)) {
                                _cE("text", _uM("key" to 0, "class" to "xDividerText", "style" to _nS(_uM("color" to _labelColor.value, "fontSize" to _fontSize.value))), _tD(_label.value), 5)
                            } else {
                                _cC("v-if", true)
                            }
                        )
                    }
                    ),
                    if (isTrue(!_vertical.value)) {
                        _cE("view", _uM("key" to 1, "class" to "xDividerRight", "style" to _nS(_uM("flex" to if (_ctx.align == "right") {
                            1
                        } else {
                            6
                        }, "border-bottom" to ("" + _lineWidth.value + " " + _model.value + " " + _color.value)))), null, 4)
                    } else {
                        _cC("v-if", true)
                    }
                ), 4)
            }
        }
        var name = "xDivider"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("xDivider" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "space-between")), "xDividerText" to _pS(_uM("marginTop" to 0, "marginRight" to "24rpx", "marginBottom" to 0, "marginLeft" to "24rpx", "whiteSpace" to "nowrap")), "xDividerLeft" to _pS(_uM("flexGrow" to 6, "flexShrink" to 1, "flexBasis" to "0%")), "xDividerRight" to _pS(_uM("flexGrow" to 6, "flexShrink" to 1, "flexBasis" to "0%")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("align" to _uM("type" to "String", "required" to true, "default" to "center"), "label" to _uM("type" to "String", "required" to true, "default" to ""), "color" to _uM("type" to "String", "required" to true, "default" to "#e5e5e5"), "darkColor" to _uM("type" to "String", "required" to true, "default" to ""), "lineWidth" to _uM("type" to "String", "required" to true, "default" to "1"), "height" to _uM("type" to "String", "required" to true, "default" to "10"), "labelColor" to _uM("type" to "String", "required" to true, "default" to "#a2a2a2"), "model" to _uM("type" to "String", "required" to true, "default" to "solid"), "fontSize" to _uM("type" to "String", "required" to true, "default" to "11"), "vertical" to _uM("type" to "Boolean", "required" to true, "default" to false)))
        var propsNeedCastKeys = _uA(
            "align",
            "label",
            "color",
            "darkColor",
            "lineWidth",
            "height",
            "labelColor",
            "model",
            "fontSize",
            "vertical"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
