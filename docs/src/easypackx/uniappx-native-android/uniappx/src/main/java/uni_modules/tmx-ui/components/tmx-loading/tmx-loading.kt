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
open class GenUniModulesTmxUiComponentsTmxLoadingTmxLoading : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var color: String by `$props`
    open var textColor: String by `$props`
    open var textSize: String by `$props`
    open var iconSize: String by `$props`
    open var vertical: Boolean by `$props`
    open var icon: String by `$props`
    open var hideText: Boolean by `$props`
    open var label: String by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesTmxUiComponentsTmxLoadingTmxLoading) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesTmxUiComponentsTmxLoadingTmxLoading
            val _cache = __ins.renderCache
            val i18n = xConfig.i18n
            val props = __props
            val _label = computed(fun(): String {
                if (props.label == "") {
                    return i18n.t("tmui4x.xloading.label")
                }
                return props.label
            }
            )
            val _icon = computed(fun(): String {
                return props.icon
            }
            )
            val _hideText = computed(fun(): Boolean {
                return props.hideText
            }
            )
            val _color = computed(fun(): String {
                return getDefaultColor(props.color)
            }
            )
            val _textColor = computed(fun(): String {
                return getDefaultColor(props.textColor)
            }
            )
            val _textSize = computed(fun(): String {
                return checkIsCssUnit(props.textSize, xConfig.unit)
            }
            )
            val _iconSize = computed(fun(): String {
                return checkIsCssUnit(props.iconSize, xConfig.unit)
            }
            )
            return fun(): Any? {
                val _component_tmx_icon = resolveEasyComponent("tmx-icon", GenUniModulesTmxUiComponentsTmxIconTmxIconClass)
                return _cE("view", _uM("class" to "xLoading", "style" to _nS(_uM("flex-direction" to if (_ctx.vertical) {
                    "column"
                } else {
                    "row"
                }
                ))), _uA(
                    _cV(_component_tmx_icon, _uM("font-size" to _iconSize.value, "color" to _color.value, "name" to _icon.value, "spin" to true), null, 8, _uA(
                        "font-size",
                        "color",
                        "name"
                    )),
                    if (isTrue(!_hideText.value)) {
                        _cE("text", _uM("key" to 0, "style" to _nS(_uM("font-size" to _textSize.value, "color" to _textColor.value, "marginLeft" to if (_ctx.vertical) {
                            "0px"
                        } else {
                            "5px"
                        }, "marginTop" to if (_ctx.vertical) {
                            "8px"
                        } else {
                            "0px"
                        }, "lineHeight" to "1.1"))), _uA(
                            renderSlot(_ctx.`$slots`, "default", _uO(), fun(): UTSArray<Any> {
                                return _uA(
                                    _tD(_label.value)
                                )
                            })
                        ), 4)
                    } else {
                        _cC("v-if", true)
                    }
                ), 4)
            }
        }
        var name = "xLoading"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("xLoading" to _pS(_uM("display" to "flex", "alignItems" to "center", "justifyContent" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("color" to _uM("type" to "String", "required" to true, "default" to "#8b8b8b"), "textColor" to _uM("type" to "String", "required" to true, "default" to "#8b8b8b"), "textSize" to _uM("type" to "String", "required" to true, "default" to "12"), "iconSize" to _uM("type" to "String", "required" to true, "default" to "21"), "vertical" to _uM("type" to "Boolean", "required" to true, "default" to true), "icon" to _uM("type" to "String", "required" to true, "default" to "loader-line"), "hideText" to _uM("type" to "Boolean", "required" to true, "default" to false), "label" to _uM("type" to "String", "required" to true, "default" to "")))
        var propsNeedCastKeys = _uA(
            "color",
            "textColor",
            "textSize",
            "iconSize",
            "vertical",
            "icon",
            "hideText",
            "label"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
