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
open class GenPagesCSSLayoutPosition : BasePage {
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
    open var radioChangePosition: (index: Number) -> Unit
        get() {
            return unref(this.`$exposed`["radioChangePosition"]) as (index: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "radioChangePosition", value)
        }
    open var data: UTSJSONObject
        get() {
            return unref(this.`$exposed`["data"]) as UTSJSONObject
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesCSSLayoutPosition, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSLayoutPosition
            val _cache = __ins.renderCache
            val positionEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "static"),
                ItemType(value = 2, name = "relative"),
                ItemType(value = 3, name = "absolute"),
                ItemType(value = 4, name = "fixed")
            ) as UTSArray<ItemType>
            val data = reactive(_uO("position" to "relative", "positionActual" to "", "positionActualText" to "", "positionActualImage" to ""))
            val viewRef = ref(null as UniElement?)
            val textRef = ref(null as UniTextElement?)
            val imageRef = ref(null as UniImageElement?)
            val getPropertyValues = fun(){
                data["positionActual"] = viewRef.value?.style?.getPropertyValue("position") ?: ""
                data["positionActualText"] = textRef.value?.style?.getPropertyValue("position") ?: ""
                data["positionActualImage"] = imageRef.value?.style?.getPropertyValue("position") ?: ""
            }
            val changePosition = fun(value: String){
                data["position"] = value
                viewRef.value?.style?.setProperty("position", value)
                textRef.value?.style?.setProperty("position", value)
                imageRef.value?.style?.setProperty("position", value)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangePosition = fun(index: Number){
                val selectedItem = positionEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changePosition(selectedItem.name)
                }
            }
            val inputChangePosition = fun(value: String){
                changePosition(value)
            }
            onReady(fun(){
                getPropertyValues()
            }
            )
            __expose(_uM("radioChangePosition" to radioChangePosition, "data" to data))
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1"))), _uA(
                        _cE("view", _uM("class" to "common-box"), _uA(
                            _cE("view", null, _uA(
                                _cE("view", _uM("class" to "title-container"), _uA(
                                    _cE("text", _uM("class" to "uni-title-text uni-common-mt"), "position: fixed")
                                )),
                                _cE("scroll-view", _uM("class" to "test-scroll-view"), _uA(
                                    _cE("view", _uM("class" to "test-block red")),
                                    _cE("view", _uM("class" to "common fixed", "style" to _nS(_uM("position" to "fixed"))), _uA(
                                        _cE("text", _uM("class" to "text"), "fixed")
                                    ), 4),
                                    _cE("view", _uM("class" to "common fixed", "style" to _nS(_uM("position" to "fixed")), "flatten" to ""), _uA(
                                        _cE("text", _uM("class" to "text"), "fixed(拍平)")
                                    ), 4),
                                    _cE("view", _uM("class" to "test-block blue")),
                                    _cE("view", _uM("class" to "test-block red")),
                                    _cE("view", _uM("class" to "test-block green")),
                                    _cE("view", _uM("class" to "test-block blue")),
                                    _cE("view", _uM("class" to "test-block red")),
                                    _cE("view", _uM("class" to "test-block green")),
                                    _cE("view", _uM("class" to "test-block blue"))
                                ))
                            )),
                            _cE("view", null, _uA(
                                _cE("view", _uM("class" to "title-container"), _uA(
                                    _cE("text", _uM("class" to "uni-subtitle-text"), "(四方向组合: top + left + bottom + right)")
                                )),
                                _cE("scroll-view", _uM("class" to "test-scroll-view"), _uA(
                                    _cE("view", _uM("class" to "test-block red")),
                                    _cE("view", _uM("class" to "common combo-all-sides fixed-combo", "style" to _nS(_uM("position" to "fixed"))), _uA(
                                        _cE("text", _uM("class" to "text"), "fixed 四方向")
                                    ), 4),
                                    _cE("view", _uM("class" to "common combo-all-sides fixed-combo", "style" to _nS(_uM("position" to "fixed")), "flatten" to ""), _uA(
                                        _cE("text", _uM("class" to "text"), "fixed 四方向(拍平)")
                                    ), 4),
                                    _cE("view", _uM("class" to "test-block blue")),
                                    _cE("view", _uM("class" to "test-block red")),
                                    _cE("view", _uM("class" to "test-block green")),
                                    _cE("view", _uM("class" to "test-block blue")),
                                    _cE("view", _uM("class" to "test-block red")),
                                    _cE("view", _uM("class" to "test-block green")),
                                    _cE("view", _uM("class" to "test-block blue"))
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "common-box"), _uA(
                            _cE("view", null, _uA(
                                _cE("view", _uM("class" to "title-container"), _uA(
                                    _cE("text", _uM("class" to "uni-title-text uni-common-mt"), "position: absolute")
                                )),
                                _cE("scroll-view", _uM("class" to "test-scroll-view"), _uA(
                                    _cE("view", _uM("class" to "test-block red")),
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("position" to "absolute"))), _uA(
                                        _cE("text", _uM("class" to "text"), "absolute")
                                    ), 4),
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("position" to "absolute")), "flatten" to ""), _uA(
                                        _cE("text", _uM("class" to "text"), "absolute(拍平)")
                                    ), 4),
                                    _cE("view", _uM("class" to "test-block blue")),
                                    _cE("view", _uM("class" to "test-block red")),
                                    _cE("view", _uM("class" to "test-block green")),
                                    _cE("view", _uM("class" to "test-block blue")),
                                    _cE("view", _uM("class" to "test-block red")),
                                    _cE("view", _uM("class" to "test-block green")),
                                    _cE("view", _uM("class" to "test-block blue"))
                                ))
                            )),
                            _cE("view", null, _uA(
                                _cE("view", _uM("class" to "title-container"), _uA(
                                    _cE("text", _uM("class" to "uni-subtitle-text"), "(四方向组合: top + left + bottom + right)")
                                )),
                                _cE("scroll-view", _uM("class" to "test-scroll-view"), _uA(
                                    _cE("view", _uM("class" to "test-block red")),
                                    _cE("view", _uM("class" to "common combo-all-sides-container", "style" to _nS(_uM("position" to "absolute"))), _uA(
                                        _cE("text", _uM("class" to "text"), "absolute 四方向")
                                    ), 4),
                                    _cE("view", _uM("class" to "common combo-all-sides-container", "style" to _nS(_uM("position" to "absolute")), "flatten" to ""), _uA(
                                        _cE("text", _uM("class" to "text"), "absolute 四方向(拍平)")
                                    ), 4),
                                    _cE("view", _uM("class" to "test-block blue")),
                                    _cE("view", _uM("class" to "test-block red")),
                                    _cE("view", _uM("class" to "test-block green")),
                                    _cE("view", _uM("class" to "test-block blue")),
                                    _cE("view", _uM("class" to "test-block red")),
                                    _cE("view", _uM("class" to "test-block green")),
                                    _cE("view", _uM("class" to "test-block blue"))
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "common-box"), _uA(
                            _cE("view", null, _uA(
                                _cE("view", _uM("class" to "title-container"), _uA(
                                    _cE("text", _uM("class" to "uni-title-text uni-common-mt"), "position: relative")
                                )),
                                _cE("scroll-view", _uM("class" to "test-scroll-view"), _uA(
                                    _cE("view", _uM("class" to "test-block red")),
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("position" to "relative"))), _uA(
                                        _cE("text", _uM("class" to "text"), "relative")
                                    ), 4),
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("position" to "relative")), "flatten" to ""), _uA(
                                        _cE("text", _uM("class" to "text"), "relative(拍平)")
                                    ), 4),
                                    _cE("view", _uM("class" to "test-block blue")),
                                    _cE("view", _uM("class" to "test-block red")),
                                    _cE("view", _uM("class" to "test-block green")),
                                    _cE("view", _uM("class" to "test-block blue")),
                                    _cE("view", _uM("class" to "test-block red")),
                                    _cE("view", _uM("class" to "test-block green")),
                                    _cE("view", _uM("class" to "test-block blue"))
                                ))
                            )),
                            _cE("view", null, _uA(
                                _cE("view", _uM("class" to "title-container"), _uA(
                                    _cE("text", _uM("class" to "uni-subtitle-text uni-common-mt"), "(四方向组合: top + left + bottom + right)")
                                )),
                                _cE("scroll-view", _uM("class" to "test-scroll-view"), _uA(
                                    _cE("view", _uM("class" to "test-block red")),
                                    _cE("view", _uM("class" to "common combo-all-sides-container", "style" to _nS(_uM("position" to "relative"))), _uA(
                                        _cE("text", _uM("class" to "text"), "relative 四方向")
                                    ), 4),
                                    _cE("view", _uM("class" to "common combo-all-sides-container", "style" to _nS(_uM("position" to "relative")), "flatten" to ""), _uA(
                                        _cE("text", _uM("class" to "text"), "relative 四方向(拍平)")
                                    ), 4),
                                    _cE("view", _uM("class" to "test-block blue")),
                                    _cE("view", _uM("class" to "test-block red")),
                                    _cE("view", _uM("class" to "test-block green")),
                                    _cE("view", _uM("class" to "test-block blue")),
                                    _cE("view", _uM("class" to "test-block red")),
                                    _cE("view", _uM("class" to "test-block green")),
                                    _cE("view", _uM("class" to "test-block blue"))
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-title-text uni-common-mt"), "scroll-view 组件"),
                            _cE("text", _uM("class" to "uni-subtitle-text"), "position: relative 和 position: absolute"),
                            _cE("view", _uM("class" to "position-test-box"), _uA(
                                _cE("scroll-view", _uM("class" to "scroll-view-common", "style" to _nS(_uM("position" to "relative", "top" to "20px", "left" to "20px", "background-color" to "cyan"))), _uA(
                                    _cE("text", null, "relative")
                                ), 4),
                                _cE("scroll-view", _uM("class" to "scroll-view-common", "style" to _nS(_uM("position" to "absolute", "top" to "65px", "left" to "65px", "background-color" to "green"))), _uA(
                                    _cE("text", null, "absolute")
                                ), 4)
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 position ")
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["position"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["positionActual"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("class" to "test-block-small red")),
                                    _cE("view", _uM("ref_key" to "viewRef", "ref" to viewRef, "class" to "common-dynamic test-view", "style" to _nS(_uA(
                                        _uM("top" to "10px", "left" to "10px"),
                                        _uM("position" to unref(data)["position"])
                                    ))), _uA(
                                        _cE("text", _uM("style" to _nS(_uM("font-size" to "10px"))), "view", 4)
                                    ), 4),
                                    _cE("view", _uM("class" to "test-block-small blue"))
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["position"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["positionActualText"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("class" to "test-block-small red test-block-small-text"), "红"),
                                    _cE("text", _uM("ref_key" to "textRef", "ref" to textRef, "class" to "common-dynamic common-text-dynamic test-text", "style" to _nS(_uA(
                                        _uM("top" to "10px", "left" to "10px"),
                                        _uM("position" to unref(data)["position"])
                                    ))), "text", 4),
                                    _cE("text", _uM("class" to "test-block-small blue test-block-small-text"), "蓝")
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["position"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["positionActualImage"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("class" to "common-image-static", "src" to "/static/test-image/logo.png")),
                                    _cE("image", _uM("ref_key" to "imageRef", "ref" to imageRef, "class" to "common-dynamic test-image", "style" to _nS(_uA(
                                        _uM("top" to "10px", "left" to "10px"),
                                        _uM("position" to unref(data)["position"])
                                    )), "src" to "/static/test-image/logo.png"), null, 4),
                                    _cE("image", _uM("class" to "common-image-static", "src" to "/static/test-image/logo.png"))
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                            _cV(_component_enum_data, _uM("items" to positionEnum, "title" to "position 枚举值", "onChange" to radioChangePosition, "compact" to true)),
                            _cV(_component_input_data, _uM("defaultValue" to unref(data)["position"], "title" to "position 自定义值", "type" to "text", "onConfirm" to inputChangePosition), null, 8, _uA(
                                "defaultValue"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mb"), _uA(
                            _cE("text", null, "native-view组件: position: relative 和 position: absolute"),
                            _cE("view", _uM("class" to "position-test-box"), _uA(
                                _cE("native-view", _uM("class" to "scroll-view-common", "style" to _nS(_uM("position" to "relative", "top" to "20px", "left" to "20px", "background-color" to "cyan"))), null, 4),
                                _cE("native-view", _uM("class" to "scroll-view-common", "style" to _nS(_uM("position" to "absolute", "top" to "65px", "left" to "65px", "background-color" to "green"))), null, 4)
                            ))
                        ))
                    ), 4)
                ), 4)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("common-box" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-around")), "title-container" to _pS(_uM("width" to 180, "height" to 45, "flexDirection" to "column")), "common" to _pS(_uM("width" to 80, "height" to 50, "backgroundColor" to "#008000", "top" to 60, "left" to 30, "justifyContent" to "center", "alignItems" to "center")), "text" to _pS(_uM("width" to "100%", "fontSize" to 12)), "test-block" to _pS(_uM("width" to 50, "height" to 50)), "test-block-small" to _pS(_uM("width" to 40, "height" to 40)), "test-block-small-text" to _pS(_uM("fontSize" to 10)), "red" to _pS(_uM("backgroundColor" to "#FF0000")), "blue" to _pS(_uM("backgroundColor" to "#0000FF")), "green" to _pS(_uM("backgroundColor" to "#008000")), "test-scroll-view" to _pS(_uM("width" to 180, "height" to 200, "backgroundColor" to "#808080")), "combo-all-sides" to _pS(_uM("top" to 60, "left" to "45%", "bottom" to 40, "right" to 40)), "combo-all-sides-container" to _pS(_uM("top" to 60, "left" to 30, "bottom" to 40, "right" to 30)), "common-dynamic" to _pS(_uM("width" to 40, "height" to 40, "backgroundColor" to "#008000")), "common-text-dynamic" to _pS(_uM("backgroundColor" to "#008000", "color" to "#FFFFFF", "fontSize" to 10, "paddingTop" to 5, "paddingRight" to 5, "paddingBottom" to 5, "paddingLeft" to 5)), "common-image-static" to _pS(_uM("width" to 40, "height" to 40, "backgroundColor" to "rgba(255,0,0,0.3)")), "test-container" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "marginTop" to 10)), "test-item" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 5, "marginBottom" to 0, "marginLeft" to 5)), "test-box" to _pS(_uM("width" to "100%", "height" to 120, "backgroundColor" to "#808080", "position" to "relative")), "position-test-box" to _pS(_uM("position" to "relative", "width" to 200, "height" to 150, "backgroundColor" to "#f5f5f5", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#dddddd", "borderRightColor" to "#dddddd", "borderBottomColor" to "#dddddd", "borderLeftColor" to "#dddddd", "marginTop" to 10)), "scroll-view-common" to _pS(_uM("width" to 80, "height" to 60)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
