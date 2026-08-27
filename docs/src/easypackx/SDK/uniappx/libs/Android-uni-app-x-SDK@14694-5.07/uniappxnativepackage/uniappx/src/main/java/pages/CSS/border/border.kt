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
open class GenPagesCSSBorderBorder : BasePage {
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
        var setup: (__props: GenPagesCSSBorderBorder) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSBorderBorder
            val _cache = __ins.renderCache
            val shown = ref(false)
            setTimeout(fun(){
                shown.value = true
            }
            , 1000)
            val borderEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "none"),
                ItemType(value = 2, name = "1px solid purple"),
                ItemType(value = 3, name = "2px dashed blue"),
                ItemType(value = 4, name = "3px dotted green")
            ) as UTSArray<ItemType>
            val data = reactive(_uO("border" to "5px solid cyan", "borderActual" to "", "borderActualText" to "", "borderActualImage" to "", "borderActualFlat" to "", "borderActualTextFlat" to "", "borderActualImageFlat" to ""))
            val viewRef = ref(null as UniElement?)
            val textRef = ref(null as UniTextElement?)
            val imageRef = ref(null as UniImageElement?)
            val viewRefFlat = ref(null as UniElement?)
            val textRefFlat = ref(null as UniTextElement?)
            val imageRefFlat = ref(null as UniImageElement?)
            val getPropertyValues = fun(){
                val actualValue = viewRef.value?.style?.getPropertyValue("border")
                data["borderActual"] = actualValue ?: ""
                data["borderActualFlat"] = viewRefFlat.value?.style?.getPropertyValue("border") ?: ""
                data["borderActualText"] = textRef.value?.style?.getPropertyValue("border") ?: ""
                data["borderActualTextFlat"] = textRefFlat.value?.style?.getPropertyValue("border") ?: ""
                data["borderActualImage"] = imageRef.value?.style?.getPropertyValue("border") ?: ""
                data["borderActualImageFlat"] = imageRefFlat.value?.style?.getPropertyValue("border") ?: ""
            }
            val changeBorder = fun(value: String){
                data["border"] = value
                viewRef.value?.style?.setProperty("border", value)
                viewRefFlat.value?.style?.setProperty("border", value)
                textRef.value?.style?.setProperty("border", value)
                textRefFlat.value?.style?.setProperty("border", value)
                imageRef.value?.style?.setProperty("border", value)
                imageRefFlat.value?.style?.setProperty("border", value)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangeBorder = fun(index: Number){
                val selectedItem = borderEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changeBorder(selectedItem.name)
                }
            }
            val inputChangeBorder = fun(value: String){
                changeBorder(value)
            }
            onReady(fun(){
                getPropertyValues()
            }
            )
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1"))), _uA(
                        _cE("view", null, _uA(
                            _cE("text", null, "border与background-image同时设置"),
                            _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-style" to "solid", "border-color" to "rgba(0, 0, 255, 0.1)", "background-image" to "linear-gradient(to right, #00ff00, #00bc79)"))), null, 4)
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "设置border 多次赋值的场景"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common multi-times-border")),
                                _cE("view", _uM("class" to "multi-times-border", "style" to _nS(_uM("width" to "150px", "height" to "50px"))), null, 4)
                            ))
                        )),
                        _cE("text", _uM("class" to "uni-tips"), "说明：左边是正常版本，右边是拍平版本"),
                        _cE("view", null, _uA(
                            _cE("text", null, "border内联样式覆盖，预期右边框为blue"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "multi-times-border", "style" to _nS(_uM("border-right" to "6px solid blue", "width" to "150px", "height" to "50px"))), null, 4),
                                _cE("view", _uM("class" to "multi-times-border", "style" to _nS(_uM("border-right" to "6px solid blue", "width" to "150px", "height" to "50px")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "border: 5px dotted blue"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("border" to "5px dotted blue"))), null, 4),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("border" to "5px dotted blue")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "设置border的view，通过v-show控制显示"),
                            withDirectives(_cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("border" to "5px dotted blue"))), null, 4),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("border" to "5px dotted blue")), "flatten" to ""), null, 4)
                            ), 512), _uA(
                                _uA(
                                    vShow,
                                    unref(shown)
                                )
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "border: dashed"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common multi-times-border", "style" to _nS(_uM("border" to "dashed"))), null, 4),
                                _cE("view", _uM("class" to "common multi-times-border", "style" to _nS(_uM("border" to "dashed")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "text组件: border: 5px dotted blue"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("text", _uM("class" to "text-border", "style" to _nS(_uM("border" to "5px dotted blue"))), "文本", 4),
                                _cE("text", _uM("class" to "text-border", "style" to _nS(_uM("border" to "5px dotted blue")), "flatten" to ""), "文本", 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "image组件: border: 5px dotted blue"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("image", _uM("class" to "image-border", "style" to _nS(_uM("border" to "5px dotted blue")), "src" to "/static/test-image/logo.png"), null, 4),
                                _cE("image", _uM("class" to "image-border", "style" to _nS(_uM("border" to "5px dotted blue")), "src" to "/static/test-image/logo.png", "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("text", _uM("class" to "uni-title-text uni-common-mt"), "scroll-view 组件"),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("scroll-view", _uM("class" to "common", "style" to _nS(_uM("border" to "1px solid red"))), _uA(
                                _cE("text", _uM("class" to "common-text"), "border: 1px solid red")
                            ), 4),
                            _cE("scroll-view", _uM("class" to "common", "style" to _nS(_uM("border" to "5px solid blue"))), _uA(
                                _cE("text", _uM("class" to "common-text"), "border: 5px solid blue")
                            ), 4)
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 border ")
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["border"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["borderActual"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("ref_key" to "viewRef", "ref" to viewRef, "class" to "common-dynamic", "style" to _nS(_uM("border" to unref(data)["border"]))), _uA(
                                        _cE("text", null, "view")
                                    ), 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["border"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["borderActualText"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRef", "ref" to textRef, "class" to "common-dynamic", "style" to _nS(_uM("border" to unref(data)["border"]))), "text", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["border"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["borderActualImage"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("ref_key" to "imageRef", "ref" to imageRef, "class" to "common-image", "style" to _nS(_uM("border" to unref(data)["border"])), "src" to "/static/test-image/logo.png"), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["border"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["borderActualFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("ref_key" to "viewRefFlat", "ref" to viewRefFlat, "class" to "common-dynamic", "style" to _nS(_uM("border" to unref(data)["border"])), "flatten" to ""), _uA(
                                        _cE("text", null, "view")
                                    ), 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["border"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["borderActualTextFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRefFlat", "ref" to textRefFlat, "class" to "common-dynamic", "style" to _nS(_uM("border" to unref(data)["border"])), "flatten" to ""), "text", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["border"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["borderActualImageFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("ref_key" to "imageRefFlat", "ref" to imageRefFlat, "class" to "common-image", "style" to _nS(_uM("border" to unref(data)["border"])), "flatten" to "", "src" to "/static/test-image/logo.png"), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                            _cV(_component_enum_data, _uM("items" to borderEnum, "title" to "border 枚举值", "onChange" to radioChangeBorder, "compact" to true)),
                            _cV(_component_input_data, _uM("defaultValue" to unref(data)["border"], "title" to "border 自定义值", "type" to "text", "onConfirm" to inputChangeBorder), null, 8, _uA(
                                "defaultValue"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mb"), _uA(
                            _cE("text", null, "native-view组件: border: 5px dotted blue 和 5px solid cyan;"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("native-view", _uM("class" to "common", "style" to _nS(_uM("border" to "5px dotted blue"))), null, 4),
                                _cE("native-view", _uM("class" to "common", "style" to _nS(_uM("border" to "5px solid cyan"))), null, 4)
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
                return _uM("common" to _uM("" to _uM("width" to 150, "height" to 50, "backgroundColor" to "#808080"), ".multi-times-border" to _uM("borderRightColor" to "#008000")), "demo-box" to _pS(_uM("flexDirection" to "row", "marginTop" to 10, "justifyContent" to "space-between")), "multi-times-border" to _pS(_uM("borderTopWidth" to 3, "borderRightWidth" to 6, "borderBottomWidth" to 3, "borderLeftWidth" to 3, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#800080", "borderRightColor" to "#FFFF00", "borderBottomColor" to "#800080", "borderLeftColor" to "#800080")), "text-border" to _pS(_uM("width" to 150, "height" to 50, "backgroundColor" to "#808080", "fontSize" to 16, "color" to "#000000")), "image-border" to _pS(_uM("width" to 150, "height" to 100, "backgroundColor" to "#808080")), "common-dynamic" to _pS(_uM("height" to 50, "backgroundColor" to "#808080")), "common-image" to _pS(_uM("width" to 50, "height" to 50, "backgroundColor" to "#808080")), "test-container" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "marginTop" to 10)), "test-item" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 5, "marginBottom" to 0, "marginLeft" to 5)), "test-text" to _pS(_uM("height" to 50)), "test-box" to _pS(_uM("width" to "100%", "height" to 60, "backgroundColor" to "#D3D3D3")), "common-text" to _pS(_uM("fontSize" to 12)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
