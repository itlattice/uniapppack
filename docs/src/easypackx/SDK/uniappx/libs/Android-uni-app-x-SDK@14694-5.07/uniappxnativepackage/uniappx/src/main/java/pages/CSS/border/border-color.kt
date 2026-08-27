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
open class GenPagesCSSBorderBorderColor : BasePage {
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
    open var radioChangeBorderColor: (index: Number) -> Unit
        get() {
            return unref(this.`$exposed`["radioChangeBorderColor"]) as (index: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "radioChangeBorderColor", value)
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
        var setup: (__props: GenPagesCSSBorderBorderColor, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSBorderBorderColor
            val _cache = __ins.renderCache
            val borderColorEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "blue"),
                ItemType(value = 2, name = "#0000ff"),
                ItemType(value = 3, name = "rgb(0, 0, 255)"),
                ItemType(value = 4, name = "rgba(0, 0, 255, 0.5)"),
                ItemType(value = 5, name = "transparent")
            ) as UTSArray<ItemType>
            val data = reactive(_uO("borderColor" to "blue", "borderColorActual" to "", "borderColorActualText" to "", "borderColorActualImage" to "", "borderColorActualFlat" to "", "borderColorActualTextFlat" to "", "borderColorActualImageFlat" to ""))
            val viewRef = ref(null as UniElement?)
            val textRef = ref(null as UniTextElement?)
            val imageRef = ref(null as UniImageElement?)
            val viewRefFlat = ref(null as UniElement?)
            val textRefFlat = ref(null as UniTextElement?)
            val imageRefFlat = ref(null as UniImageElement?)
            val getPropertyValues = fun(){
                data["borderColorActual"] = viewRef.value?.style?.getPropertyValue("border-color") ?: ""
                data["borderColorActualFlat"] = viewRefFlat.value?.style?.getPropertyValue("border-color") ?: ""
                data["borderColorActualText"] = textRef.value?.style?.getPropertyValue("border-color") ?: ""
                data["borderColorActualTextFlat"] = textRefFlat.value?.style?.getPropertyValue("border-color") ?: ""
                data["borderColorActualImage"] = imageRef.value?.style?.getPropertyValue("border-color") ?: ""
                data["borderColorActualImageFlat"] = imageRefFlat.value?.style?.getPropertyValue("border-color") ?: ""
            }
            val changeBorderColor = fun(value: String){
                data["borderColor"] = value
                viewRef.value?.style?.setProperty("border-color", value)
                viewRefFlat.value?.style?.setProperty("border-color", value)
                textRef.value?.style?.setProperty("border-color", value)
                textRefFlat.value?.style?.setProperty("border-color", value)
                imageRef.value?.style?.setProperty("border-color", value)
                imageRefFlat.value?.style?.setProperty("border-color", value)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangeBorderColor = fun(index: Number){
                val selectedItem = borderColorEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changeBorderColor(selectedItem.name)
                }
            }
            val inputChangeBorderColor = fun(value: String){
                changeBorderColor(value)
            }
            onReady(fun(){
                getPropertyValues()
            }
            )
            __expose(_uM("radioChangeBorderColor" to radioChangeBorderColor, "data" to data))
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1"))), _uA(
                        _cE("text", _uM("class" to "uni-tips"), "说明：左边是正常版本，右边是拍平版本"),
                        _cE("view", null, _uA(
                            _cE("text", null, "border-color: cyan"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-width" to "5px", "border-color" to "cyan", "border-style" to "solid"))), null, 4),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-width" to "5px", "border-color" to "cyan", "border-style" to "solid")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "border-color: #00FF00"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-width" to "5px", "border-color" to "#00FF00", "border-style" to "solid"))), null, 4),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-width" to "5px", "border-color" to "#00FF00", "border-style" to "solid")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "border-color: rgb(0,0,255)"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-width" to "5px", "border-color" to "rgb(0,0,255)", "border-style" to "solid"))), null, 4),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-width" to "5px", "border-color" to "rgb(0,0,255)", "border-style" to "solid")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "border-color: rgba(0,255,255,0.5)"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-width" to "5px", "border-color" to "rgba(0,255,255,0.5)", "border-style" to "solid"))), null, 4),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-width" to "5px", "border-color" to "rgba(0,255,255,0.5)", "border-style" to "solid")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "border-left-color: cyan"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-left-width" to "5px", "border-left-color" to "cyan", "border-left-style" to "solid"))), null, 4),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-left-width" to "5px", "border-left-color" to "cyan", "border-left-style" to "solid")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "border-top-color: green"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-top-width" to "5px", "border-top-color" to "green", "border-top-style" to "solid"))), null, 4),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-top-width" to "5px", "border-top-color" to "green", "border-top-style" to "solid")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "border-right-color: yellow"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-right-width" to "5px", "border-right-color" to "yellow", "border-right-style" to "solid"))), null, 4),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-right-width" to "5px", "border-right-color" to "yellow", "border-right-style" to "solid")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "border-bottom-color: blue"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-bottom-width" to "5px", "border-bottom-color" to "blue", "border-bottom-style" to "solid"))), null, 4),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-bottom-width" to "5px", "border-bottom-color" to "blue", "border-bottom-style" to "solid")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("text", _uM("class" to "uni-title-text uni-common-mt"), "scroll-view 组件"),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("scroll-view", _uM("class" to "common scroll-view-border", "style" to _nS(_uM("border-color" to "cyan"))), _uA(
                                _cE("text", _uM("class" to "common-text"), "border-color: cyan")
                            ), 4),
                            _cE("scroll-view", _uM("class" to "common scroll-view-border", "style" to _nS(_uM("border-color" to "#00FF00"))), _uA(
                                _cE("text", _uM("class" to "common-text"), "border-color: #00FF00")
                            ), 4)
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 border-color ")
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["borderColor"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["borderColorActual"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("ref_key" to "viewRef", "ref" to viewRef, "class" to "common-dynamic test-view", "style" to _nS(_uM("borderWidth" to "5px", "borderColor" to unref(data)["borderColor"], "borderStyle" to "solid"))), _uA(
                                        _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1", "background-color" to "green"))), _uA(
                                            _cE("text", null, "view")
                                        ), 4)
                                    ), 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["borderColor"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["borderColorActualText"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRef", "ref" to textRef, "class" to "common-dynamic test-text", "style" to _nS(_uM("borderWidth" to "5px", "borderColor" to unref(data)["borderColor"], "borderStyle" to "solid"))), "text", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["borderColor"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["borderColorActualImage"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("ref_key" to "imageRef", "ref" to imageRef, "class" to "common-image test-image", "style" to _nS(_uM("borderWidth" to "5px", "borderColor" to unref(data)["borderColor"], "borderStyle" to "solid")), "src" to "/static/test-image/logo.png"), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["borderColor"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["borderColorActualFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("ref_key" to "viewRefFlat", "ref" to viewRefFlat, "class" to "common-dynamic test-view-flatten", "style" to _nS(_uM("borderWidth" to "5px", "borderColor" to unref(data)["borderColor"], "borderStyle" to "solid")), "flatten" to ""), _uA(
                                        _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1", "background-color" to "green"))), _uA(
                                            _cE("text", null, "view")
                                        ), 4)
                                    ), 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["borderColor"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["borderColorActualTextFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRefFlat", "ref" to textRefFlat, "class" to "common-dynamic test-text-flatten", "style" to _nS(_uM("borderWidth" to "5px", "borderColor" to unref(data)["borderColor"], "borderStyle" to "solid")), "flatten" to ""), "text", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["borderColor"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["borderColorActualImageFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("ref_key" to "imageRefFlat", "ref" to imageRefFlat, "class" to "common-image test-image-flatten", "style" to _nS(_uM("borderWidth" to "5px", "borderColor" to unref(data)["borderColor"], "borderStyle" to "solid")), "flatten" to "", "src" to "/static/test-image/logo.png"), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                            _cV(_component_enum_data, _uM("items" to borderColorEnum, "title" to "border-color 枚举值", "onChange" to radioChangeBorderColor, "compact" to true)),
                            _cV(_component_input_data, _uM("defaultValue" to unref(data)["borderColor"], "title" to "border-color 自定义值", "type" to "text", "onConfirm" to inputChangeBorderColor), null, 8, _uA(
                                "defaultValue"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mb"), _uA(
                            _cE("text", null, "native-view组件: border-color: cyan 和 #00FF00"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("native-view", _uM("class" to "common", "style" to _nS(_uM("border-width" to "5px", "border-style" to "solid", "border-color" to "cyan"))), null, 4),
                                _cE("native-view", _uM("class" to "common", "style" to _nS(_uM("border-width" to "5px", "border-style" to "solid", "border-color" to "#00FF00"))), null, 4)
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
                return _uM("common" to _pS(_uM("width" to 150, "height" to 50, "backgroundColor" to "#808080")), "demo-box" to _pS(_uM("flexDirection" to "row", "marginTop" to 10, "justifyContent" to "space-around")), "common-dynamic" to _pS(_uM("height" to 50, "backgroundColor" to "#808080")), "common-image" to _pS(_uM("width" to 50, "height" to 50, "backgroundColor" to "#808080")), "test-container" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "marginTop" to 10)), "test-item" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 5, "marginBottom" to 0, "marginLeft" to 5)), "test-box" to _pS(_uM("width" to "100%", "height" to 60, "backgroundColor" to "#D3D3D3")), "scroll-view-border" to _pS(_uM("borderTopWidth" to 5, "borderRightWidth" to 5, "borderBottomWidth" to 5, "borderLeftWidth" to 5, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid")), "common-text" to _pS(_uM("fontSize" to 12)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
