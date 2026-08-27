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
open class GenUniModulesTmxUiComponentsTmxProgressTmxProgress : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var min: Number by `$props`
    open var max: Number by `$props`
    open var modelValue: Number by `$props`
    open var color: String by `$props`
    open var bgColor: String by `$props`
    open var darkBgColor: String by `$props`
    open var showLabel: Boolean by `$props`
    open var labelColor: String by `$props`
    open var labelFontSize: String by `$props`
    open var size: String by `$props`
    open var round: String by `$props`
    open var duration: Number by `$props`
    open var linearColor: String by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesTmxUiComponentsTmxProgressTmxProgress) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesTmxUiComponentsTmxProgressTmxProgress
            val _cache = __ins.renderCache
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val props = __props
            val xPropressRef = ref<UniElement?>(null)
            val percentage = ref(0)
            val _val = ref(0)
            val boxwidth = ref(0)
            val boxheight = ref(0)
            val _round = computed(fun(): String {
                if (props.round == "") {
                    return checkIsCssUnit(xConfig.progressRadius, xConfig.unit)
                }
                return checkIsCssUnit(props.round, xConfig.unit)
            }
            )
            val _min = computed(fun(): Number {
                return props.min
            }
            )
            val _max = computed(fun(): Number {
                return props.max
            }
            )
            val _showLabel = computed(fun(): Boolean {
                return props.showLabel
            }
            )
            val _color = computed(fun(): String {
                if (props.color == "") {
                    return getDefaultColor(xConfig.color)
                }
                return getDefaultColor(props.color)
            }
            )
            val _bgColor = computed(fun(): String {
                if (xConfig.dark == "dark") {
                    if (props.darkBgColor != "") {
                        return getDefaultColor(props.darkBgColor)
                    }
                    return getDefaultColor(xConfig.inputDarkColor)
                }
                return getDefaultColor(props.bgColor)
            }
            )
            val _labelColor = computed(fun(): String {
                return getDefaultColor(props.labelColor)
            }
            )
            val _labelFontSize = computed(fun(): String {
                return checkIsCssUnit(props.labelFontSize, xConfig.unit)
            }
            )
            val _size = computed(fun(): String {
                return checkIsCssUnit(props.size, xConfig.unit)
            }
            )
            val _bgStyle = computed(fun(): UTSJSONObject {
                var obj: UTSJSONObject = _uO()
                if (props.linearColor != "") {
                    obj.set("background-image", props.linearColor)
                } else {
                    obj.set("background-color", _color.value)
                }
                return obj
            }
            )
            val valueToPro = fun(kVal: Number): Number {
                var min = Math.min(_min.value, _max.value)
                var max = Math.max(_min.value, _max.value)
                var realval = Math.max(Math.min(kVal, max), min)
                emit("update:modelValue", realval)
                return (realval - min) / (max - min) * 100
            }
            val getNodes = fun(){
                var ele = xPropressRef.value
                if (ele == null) {
                    return
                }
                ele.getBoundingClientRectAsync()?.then(fun(ret: DOMRect){
                    boxwidth.value = ret.width
                    boxheight.value = ret.height
                }
                )
            }
            watch(fun(): Number {
                return props.modelValue
            }
            , fun(newval: Number){
                if (newval != _val.value) {
                    _val.value = newval
                    percentage.value = valueToPro(_val.value)
                    getNodes()
                }
            }
            )
            onMounted(fun(){
                getNodes()
                _val.value = props.modelValue
                percentage.value = valueToPro(_val.value)
            }
            )
            return fun(): Any? {
                return _cE("view", _uM("class" to "xPropressBox"), _uA(
                    _cE("view", _uM("ref_key" to "xPropressRef", "ref" to xPropressRef, "class" to "xPropress", "style" to _nS(_uM("backgroundColor" to unref(_bgColor), "height" to unref(_size), "borderRadius" to unref(_round)))), _uA(
                        _cE("view", _uM("class" to "xPropressBg", "style" to _nS(_uA(
                            _uM("backgroundColor" to unref(_color), "width" to ("" + (unref(percentage) / 100) * unref(boxwidth) + "px"), "borderRadius" to unref(_round), "transitionDuration" to ("" + _ctx.duration + "ms")),
                            unref(_bgStyle)
                        ))), _uA(
                            if (isTrue(_ctx.showLabel)) {
                                _cE("view", _uM("key" to 0, "class" to "xPropressBtn"), _uA(
                                    _cE("text", _uM("class" to "xPropressTxt", "style" to _nS(_uM("color" to unref(_labelColor), "fontSize" to unref(_labelFontSize)))), _uA(
                                        renderSlot(_ctx.`$slots`, "default", _uM("value" to unref(_val), "percentage" to unref(percentage).toFixed(0)), fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(unref(percentage).toFixed(0)) + "%"
                                            )
                                        })
                                    ), 4)
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                        ), 4)
                    ), 4),
                    _cE("view", _uM("class" to "xPropressBoxRight"), _uA(
                        renderSlot(_ctx.`$slots`, "right", _uM("value" to unref(_val), "percentage" to unref(percentage).toFixed(0)))
                    ))
                ))
            }
        }
        var name = "xProgress"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("xPropressBox" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center")), "xPropress" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "xPropressBg" to _pS(_uM("height" to "100%", "display" to "flex", "flexDirection" to "row", "justifyContent" to "flex-end", "alignItems" to "center", "transitionDuration" to "0ms", "transitionProperty" to "width", "transitionTimingFunction" to "ease")), "xPropressBtn" to _pS(_uM("height" to "100%", "paddingTop" to "0rpx", "paddingRight" to "10rpx", "paddingBottom" to "0rpx", "paddingLeft" to "10rpx", "display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center")), "@TRANSITION" to _uM("xPropressBg" to _uM("duration" to "0ms", "property" to "width", "timingFunction" to "ease")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("update:modelValue" to null)
        var props = _nP(_uM("min" to _uM("type" to "Number", "required" to true, "default" to 0), "max" to _uM("type" to "Number", "required" to true, "default" to 100), "modelValue" to _uM("type" to "Number", "required" to true, "default" to 0), "color" to _uM("type" to "String", "required" to true, "default" to ""), "bgColor" to _uM("type" to "String", "required" to true, "default" to "info"), "darkBgColor" to _uM("type" to "String", "required" to true, "default" to ""), "showLabel" to _uM("type" to "Boolean", "required" to true, "default" to false), "labelColor" to _uM("type" to "String", "required" to true, "default" to "white"), "labelFontSize" to _uM("type" to "String", "required" to true, "default" to "10"), "size" to _uM("type" to "String", "required" to true, "default" to "4"), "round" to _uM("type" to "String", "required" to true, "default" to ""), "duration" to _uM("type" to "Number", "required" to true, "default" to 350), "linearColor" to _uM("type" to "String", "required" to true, "default" to "")))
        var propsNeedCastKeys = _uA(
            "min",
            "max",
            "modelValue",
            "color",
            "bgColor",
            "darkBgColor",
            "showLabel",
            "labelColor",
            "labelFontSize",
            "size",
            "round",
            "duration",
            "linearColor"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
