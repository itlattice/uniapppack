@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNIHelloUniAppX
import io.dcloud.uniapp.*
import io.dcloud.uniapp.extapi.*
import io.dcloud.uniapp.framework.*
import io.dcloud.uniapp.runtime.*
import io.dcloud.uniapp.vue.*
import io.dcloud.uniapp.vue.shared.*
import io.dcloud.unicloud.*
import io.dcloud.uts.*
import io.dcloud.uts.Map
import io.dcloud.uts.Set
import io.dcloud.uts.UTSAndroid
import kotlin.properties.Delegates
open class GenPagesTemplateProgress100Progress100 : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onLoad(fun(_: OnLoadOptions) {
            stat_instance.onLoad(this)
        }
        , __ins)
        onPageShow(fun() {
            stat_instance.onShow(this)
        }
        , __ins)
        onPageHide(fun() {
            stat_instance.onHide(this)
        }
        , __ins)
        onUnload(fun() {
            stat_instance.onUnload(this)
        }
        , __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesTemplateProgress100Progress100) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesTemplateProgress100Progress100
            val _cache = __ins.renderCache
            val sharedPercent = ref(50)
            val sharedShowInfo = ref(false)
            val sharedStrokeWidth = ref(4)
            val fontSize = ref(8)
            val sharedActiveColor = ref("#09BB07")
            val sharedBackgroundColor = ref("#EBEBEB")
            val strokeWidths: UTSArray<Number> = _uA(
                3,
                4,
                5,
                6
            )
            val activeColors = _uA(
                "#09BB07",
                "#FF6B6B",
                "#4ECDC4",
                "#FFA07A"
            )
            var strokeWidthIndex: Number = 1
            var activeColorIndex: Number = 0
            fun gen_setPercent_fn(percent: Number) {
                sharedPercent.value = percent
                console.log("percent:", percent)
            }
            val setPercent = ::gen_setPercent_fn
            fun gen_toggleShowInfo_fn() {
                sharedShowInfo.value = !sharedShowInfo.value
                console.log("show-info:", sharedShowInfo.value)
            }
            val toggleShowInfo = ::gen_toggleShowInfo_fn
            fun gen_changeStrokeWidth_fn() {
                strokeWidthIndex = (strokeWidthIndex + 1) % strokeWidths.length
                sharedStrokeWidth.value = strokeWidths[strokeWidthIndex]
                console.log("stroke-width:", sharedStrokeWidth.value)
            }
            val changeStrokeWidth = ::gen_changeStrokeWidth_fn
            fun gen_changeActiveColor_fn() {
                activeColorIndex = (activeColorIndex + 1) % activeColors.length
                sharedActiveColor.value = activeColors[activeColorIndex]
                console.log("activeColor:", sharedActiveColor.value)
            }
            val changeActiveColor = ::gen_changeActiveColor_fn
            return fun(): Any? {
                val _component_fps = resolveEasyComponent("fps", GenComponentsFpsFpsClass)
                val _component_progress = resolveComponent("progress")
                return _cE("view", _uM("style" to _nS(_uM("flex-direction" to "column", "background-color" to "#f5f5f5"))), _uA(
                    _cV(_component_fps),
                    _cE("view", _uM("style" to _nS(_uM("padding" to "3px", "background-color" to "#ffffff", "flex-direction" to "row", "flex-wrap" to "wrap", "align-items" to "center"))), _uA(
                        _cE("button", _uM("onClick" to fun(){
                            setPercent(0)
                        }
                        , "type" to if (unref(sharedPercent) == 0) {
                            "primary"
                        } else {
                            "default"
                        }
                        , "size" to "mini", "style" to _nS(_uM("margin" to "2px"))), "0%", 12, _uA(
                            "onClick",
                            "type"
                        )),
                        _cE("button", _uM("onClick" to fun(){
                            setPercent(60)
                        }
                        , "type" to if (unref(sharedPercent) == 60) {
                            "primary"
                        } else {
                            "default"
                        }
                        , "size" to "mini", "style" to _nS(_uM("margin" to "2px"))), "60%", 12, _uA(
                            "onClick",
                            "type"
                        )),
                        _cE("button", _uM("onClick" to fun(){
                            setPercent(100)
                        }
                        , "type" to if (unref(sharedPercent) == 100) {
                            "primary"
                        } else {
                            "default"
                        }
                        , "size" to "mini", "style" to _nS(_uM("margin" to "2px"))), "100%", 12, _uA(
                            "onClick",
                            "type"
                        )),
                        _cE("button", _uM("onClick" to toggleShowInfo, "type" to if (unref(sharedShowInfo)) {
                            "primary"
                        } else {
                            "default"
                        }
                        , "size" to "mini", "style" to _nS(_uM("margin" to "2px"))), _tD(if (unref(sharedShowInfo)) {
                            "隐藏%"
                        } else {
                            "显示%"
                        }
                        ), 13, _uA(
                            "type"
                        )),
                        _cE("button", _uM("onClick" to changeStrokeWidth, "size" to "mini", "style" to _nS(_uM("margin" to "2px"))), _tD(unref(sharedStrokeWidth)) + "px", 5),
                        _cE("button", _uM("onClick" to changeActiveColor, "size" to "mini", "style" to _nS(_uM("margin" to "2px"))), "颜色", 4)
                    ), 4),
                    _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row", "flex-wrap" to "wrap", "padding" to "5px"))), _uA(
                        _cE(Fragment, null, RenderHelpers.renderList(100, fun(index, __key, __index, _cached): Any {
                            return _cE("view", _uM("key" to index, "style" to _nS(_uM("width" to "15%", "margin" to "8rpx", "flex-direction" to "column"))), _uA(
                                _cE("text", _uM("style" to _nS(_uM("font-size" to "10px", "color" to "#666", "margin-bottom" to "2px"))), _tD(index), 5),
                                _cV(_component_progress, _uM("percent" to unref(sharedPercent), "show-info" to unref(sharedShowInfo), "stroke-width" to unref(sharedStrokeWidth), "activeColor" to unref(sharedActiveColor), "backgroundColor" to unref(sharedBackgroundColor), "font-size" to unref(fontSize)), null, 8, _uA(
                                    "percent",
                                    "show-info",
                                    "stroke-width",
                                    "activeColor",
                                    "backgroundColor",
                                    "font-size"
                                ))
                            ), 4)
                        }
                        ), 64)
                    ), 4)
                ), 4)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
