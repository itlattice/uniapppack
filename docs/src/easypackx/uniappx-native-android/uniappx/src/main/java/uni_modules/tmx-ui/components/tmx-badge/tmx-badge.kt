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
open class GenUniModulesTmxUiComponentsTmxBadgeTmxBadge : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var fontSize: String by `$props`
    open var bgColor: String by `$props`
    open var fontColor: String by `$props`
    open var dot: Boolean by `$props`
    open var count: Number by `$props`
    open var maxCount: Number by `$props`
    open var label: String by `$props`
    open var position: String by `$props`
    open var offset: UTSArray<Number> by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesTmxUiComponentsTmxBadgeTmxBadge) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesTmxUiComponentsTmxBadgeTmxBadge
            val _cache = __ins.renderCache
            val proxy = getCurrentInstance()?.proxy ?: null
            val props = __props
            val padding = ref<String>("4px 4px")
            val test = ref<Map<String, String>>(Map<String, String>(_uA(
                _uA(
                    "border",
                    "2px solid red"
                ),
                _uA(
                    "background-color",
                    "green"
                )
            )))
            fun gen_getNodeInfo_fn(): Unit {
                uni_createSelectorQuery().`in`(proxy).select(".xBadge-countAndLabel").boundingClientRect().exec(fun(ret){
                    if (ret.length == 0) {
                        return
                    }
                    var nodeinfo = ret[0] as NodeInfo
                    if (nodeinfo == null) {
                        return
                    }
                    var width = nodeinfo.width as Number
                    var height = nodeinfo.height as Number
                    var max = Math.max(width, height)
                    var px = Math.ceil(max / 2)
                    padding.value = "" + px + "px " + px + "px"
                }
                )
            }
            val getNodeInfo = ::gen_getNodeInfo_fn
            val _offset = computed(fun(): UTSArray<Number> {
                return props.offset
            }
            )
            val _isDot = computed(fun(): Boolean {
                if (props.label != "" || props.count > 0 || !props.dot) {
                    return false
                }
                return true
            }
            )
            val _fontColor = computed(fun(): String {
                return getDefaultColor(props.fontColor)
            }
            )
            val _fontSize = computed(fun(): String {
                return checkIsCssUnit(props.fontSize, xConfig.unit)
            }
            )
            val _label = computed(fun(): String {
                if (props.label != "") {
                    return props.label
                }
                if (props.count > 0 && props.count <= props.maxCount) {
                    return props.count.toString(10)
                }
                if (props.count <= 0) {
                    return ""
                }
                return props.maxCount.toString(10) + "+"
            }
            )
            val _cStyles = computed(fun(): UTSArray<Map<String, String>> {
                var trs = ""
                if (props.position == "right") {
                    trs = "translate(50%, -50%)"
                } else if (props.position == "left") {
                    trs = "translate(-50%, -50%)"
                } else if (props.position == "bottomLeft") {
                    trs = "translate(-50%, 50%)"
                } else if (props.position == "bottomRight") {
                    trs = "translate(50%, 50%)"
                } else if (props.position == "top") {
                    trs = "translate(0%, -50%)"
                } else if (props.position == "bottom") {
                    trs = "translate(0%, 50%)"
                }
                var top = ""
                var bottom = ""
                var left = ""
                var right = ""
                if (props.position == "top") {
                    top = "0px"
                    left = "auto"
                    right = "auto"
                } else if (props.position == "bottom") {
                    bottom = "0px"
                    left = "auto"
                    right = "auto"
                } else if (props.position == "right") {
                    top = _offset.value[1].toString(10) + "px"
                    right = _offset.value[0].toString(10) + "px"
                } else if (props.position == "left") {
                    top = "0px"
                    left = "0px"
                } else if (props.position == "bottomLeft") {
                    bottom = "0px"
                    left = "0px"
                } else if (props.position == "bottomRight") {
                    bottom = "0px"
                    right = "0px"
                }
                var dotMapCs = Map<String, String>()
                dotMapCs.set("background", getDefaultColor(props.bgColor))
                dotMapCs.set("left", left)
                dotMapCs.set("right", right)
                dotMapCs.set("top", top)
                dotMapCs.set("bottom", bottom)
                dotMapCs.set("transform", trs)
                var labelMapCs = Map<String, String>()
                labelMapCs.set("background", getDefaultColor(props.bgColor))
                labelMapCs.set("left", left)
                labelMapCs.set("right", right)
                labelMapCs.set("top", top)
                labelMapCs.set("bottom", bottom)
                labelMapCs.set("transform", trs)
                labelMapCs.set("visibility", if (_label.value == "") {
                    "hidden"
                } else {
                    "visible"
                }
                )
                nextTick(fun(){
                    getNodeInfo()
                }
                )
                return _uA<Map<String, String>>(dotMapCs, labelMapCs)
            }
            )
            watch(_uA(
                fun(): String {
                    return props.label
                }
                ,
                fun(): String {
                    return props.position
                }
                ,
                fun(): Number {
                    return props.count
                }
                ,
                fun(): UTSArray<Number> {
                    return props.offset
                }
            ), fun(): Unit {
                nextTick(fun(){
                    getNodeInfo()
                }
                )
            }
            )
            onMounted(fun(): Unit {
                getNodeInfo()
            }
            )
            return fun(): Any? {
                return _cE("view", _uM("class" to "xBadge", "style" to _nS(_uM("padding" to padding.value))), _uA(
                    _cE("view", _uM("class" to "xBadgeWrap"), _uA(
                        _cE("text", _uM("style" to _nS(_cStyles.value[0]!!), "class" to _nC(_uA(
                            "xBadge-dot",
                            _uA(
                                if (_isDot.value) {
                                    "noneShow"
                                } else {
                                    "nonex"
                                }
                            )
                        ))), null, 6),
                        _cE("view", _uM("id" to "xBadge-countAndLabel", "class" to _nC(_uA(
                            "xBadge-countAndLabel",
                            _uA(
                                if (_isDot.value) {
                                    "nonex"
                                } else {
                                    "noneShow"
                                }
                            )
                        )), "style" to _nS(_cStyles.value[1]!!)), _uA(
                            _cE("text", _uM("class" to "xBadge-countAndLabelText", "style" to _nS(_uM("color" to _fontColor.value, "fontSize" to _fontSize.value))), _tD(_label.value), 5)
                        ), 6),
                        renderSlot(_ctx.`$slots`, "default")
                    ))
                ), 4)
            }
        }
        var name = "xBadge"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("xBadge" to _pS(_uM("overflow" to "visible")), "xBadge-countAndLabel" to _pS(_uM("position" to "absolute", "zIndex" to 3, "borderTopLeftRadius" to 100, "borderTopRightRadius" to 100, "borderBottomRightRadius" to 100, "borderBottomLeftRadius" to 100, "paddingTop" to "0rpx", "paddingRight" to 4, "paddingBottom" to "0rpx", "paddingLeft" to 4, "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center")), "xBadge-countAndLabelText" to _pS(_uM("lineHeight" to 1.5, "textAlign" to "center")), "xBadge-dot" to _pS(_uM("position" to "absolute", "width" to 6, "height" to 6, "borderTopLeftRadius" to 18, "borderTopRightRadius" to 18, "borderBottomRightRadius" to 18, "borderBottomLeftRadius" to 18, "zIndex" to 3, "opacity" to 0)), "noneShow" to _pS(_uM("opacity" to 1)), "nonex" to _pS(_uM("opacity" to 0)), "xBadgeWrap" to _pS(_uM("flexDirection" to "column", "justifyContent" to "center", "alignItems" to "center", "overflow" to "visible", "position" to "relative")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("fontSize" to _uM("type" to "String", "required" to true, "default" to "9"), "bgColor" to _uM("type" to "String", "required" to true, "default" to "error"), "fontColor" to _uM("type" to "String", "required" to true, "default" to "white"), "dot" to _uM("type" to "Boolean", "required" to true, "default" to true), "count" to _uM("type" to "Number", "required" to true, "default" to 0), "maxCount" to _uM("type" to "Number", "required" to true, "default" to 99), "label" to _uM("type" to "String", "required" to true, "default" to ""), "position" to _uM("type" to "String", "required" to true, "default" to "right"), "offset" to _uM("type" to "Array", "required" to true, "default" to fun(): UTSArray<Number> {
            return _uA<Number>(0, 0)
        }
        )))
        var propsNeedCastKeys = _uA(
            "fontSize",
            "bgColor",
            "fontColor",
            "dot",
            "count",
            "maxCount",
            "label",
            "position",
            "offset"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
