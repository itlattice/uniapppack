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
open class GenPagesCSSPaddingPadding : BasePage {
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
    open var radioChangePadding: (index: Number) -> Unit
        get() {
            return unref(this.`$exposed`["radioChangePadding"]) as (index: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "radioChangePadding", value)
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
        var setup: (__props: GenPagesCSSPaddingPadding, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSPaddingPadding
            val _cache = __ins.renderCache
            val data = reactive(_uO("padding" to "20px", "paddingActual" to "", "paddingActualText" to "", "paddingActualImage" to "", "paddingActualFlat" to "", "paddingActualTextFlat" to "", "paddingActualImageFlat" to "", "paddingActualScrollView" to ""))
            val viewRef = ref(null as UniElement?)
            val textRef = ref(null as UniTextElement?)
            val imageRef = ref(null as UniImageElement?)
            val viewRefFlat = ref(null as UniElement?)
            val textRefFlat = ref(null as UniTextElement?)
            val imageRefFlat = ref(null as UniImageElement?)
            val scrollViewRef = ref(null as UniElement?)
            val paddingEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "0"),
                ItemType(value = 2, name = "0px"),
                ItemType(value = 3, name = "10px"),
                ItemType(value = 4, name = "0%"),
                ItemType(value = 5, name = "5%")
            ) as UTSArray<ItemType>
            val getPropertyValues = fun(){
                data["paddingActual"] = viewRef.value?.style?.getPropertyValue("padding") ?: ""
                data["paddingActualFlat"] = viewRefFlat.value?.style?.getPropertyValue("padding") ?: ""
                data["paddingActualText"] = textRef.value?.style?.getPropertyValue("padding") ?: ""
                data["paddingActualTextFlat"] = textRefFlat.value?.style?.getPropertyValue("padding") ?: ""
                data["paddingActualImage"] = imageRef.value?.style?.getPropertyValue("padding") ?: ""
                data["paddingActualImageFlat"] = imageRefFlat.value?.style?.getPropertyValue("padding") ?: ""
                data["paddingActualScrollView"] = scrollViewRef.value?.style?.getPropertyValue("padding") ?: ""
            }
            val changePadding = fun(value: String){
                data["padding"] = value
                viewRef.value?.style?.setProperty("padding", value)
                viewRefFlat.value?.style?.setProperty("padding", value)
                textRef.value?.style?.setProperty("padding", value)
                textRefFlat.value?.style?.setProperty("padding", value)
                imageRef.value?.style?.setProperty("padding", value)
                imageRefFlat.value?.style?.setProperty("padding", value)
                scrollViewRef.value?.style?.setProperty("padding", value)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangePadding = fun(index: Number){
                val selectedItem = paddingEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changePadding(selectedItem.name)
                }
            }
            val inputChangePadding = fun(value: String){
                changePadding(value)
            }
            onReady(fun(){
                getPropertyValues()
            }
            )
            __expose(_uM("radioChangePadding" to radioChangePadding, "data" to data))
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1"))), _uA(
                        _cE("text", _uM("class" to "uni-tips"), "说明：左边是正常版本，右边是拍平版本"),
                        _cE("view", null, _uA(
                            _cE("text", null, "padding: 25px"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("padding" to "25px"))), _uA(
                                    _cE("view", _uM("class" to "inner-content"))
                                ), 4),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("padding" to "25px")), "flatten" to ""), _uA(
                                    _cE("view", _uM("class" to "inner-content"))
                                ), 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "padding: 5%"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("padding" to "5%"))), _uA(
                                    _cE("view", _uM("class" to "inner-content"))
                                ), 4),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("padding" to "5%")), "flatten" to ""), _uA(
                                    _cE("view", _uM("class" to "inner-content"))
                                ), 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "text组件: padding: 25px"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("text", _uM("class" to "text-padding", "style" to _nS(_uM("padding" to "25px"))), "文本", 4),
                                _cE("text", _uM("class" to "text-padding", "style" to _nS(_uM("padding" to "25px")), "flatten" to ""), "文本", 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "text组件: padding: 5%"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("text", _uM("class" to "text-padding", "style" to _nS(_uM("padding" to "5%"))), "文本", 4),
                                _cE("text", _uM("class" to "text-padding", "style" to _nS(_uM("padding" to "5%")), "flatten" to ""), "文本", 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "image组件: padding: 25px"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("image", _uM("class" to "image-padding", "style" to _nS(_uM("padding" to "25px")), "src" to "/static/test-image/logo.png"), null, 4),
                                _cE("image", _uM("class" to "image-padding", "style" to _nS(_uM("padding" to "25px")), "src" to "/static/test-image/logo.png", "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "image组件: padding: 5%"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("image", _uM("class" to "image-padding", "style" to _nS(_uM("padding" to "5%")), "src" to "/static/test-image/logo.png"), null, 4),
                                _cE("image", _uM("class" to "image-padding", "style" to _nS(_uM("padding" to "5%")), "src" to "/static/test-image/logo.png", "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 padding ")
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["padding"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["paddingActual"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("ref_key" to "viewRef", "ref" to viewRef, "class" to "common-dynamic test-view", "style" to _nS(_uM("padding" to unref(data)["padding"]))), _uA(
                                        _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1", "background-color" to "cyan"))), _uA(
                                            _cE("text", _uM("class" to "common-text"), "view")
                                        ), 4)
                                    ), 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["padding"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["paddingActualText"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRef", "ref" to textRef, "class" to "common-dynamic common-text test-text", "style" to _nS(_uM("padding" to unref(data)["padding"]))), "text", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["padding"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["paddingActualImage"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("ref_key" to "imageRef", "ref" to imageRef, "class" to "common-image test-image", "style" to _nS(_uM("padding" to unref(data)["padding"])), "src" to "/static/test-image/logo.png"), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["padding"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["paddingActualFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("ref_key" to "viewRefFlat", "ref" to viewRefFlat, "class" to "common-dynamic test-view-flatten", "style" to _nS(_uM("padding" to unref(data)["padding"])), "flatten" to ""), _uA(
                                        _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1", "background-color" to "cyan"))), _uA(
                                            _cE("text", _uM("class" to "common-text"), "view")
                                        ), 4)
                                    ), 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["padding"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["paddingActualTextFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRefFlat", "ref" to textRefFlat, "class" to "common-dynamic common-text test-text-flatten", "style" to _nS(_uM("padding" to unref(data)["padding"])), "flatten" to ""), "text", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["padding"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["paddingActualImageFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("ref_key" to "imageRefFlat", "ref" to imageRefFlat, "class" to "common-image test-image-flatten", "style" to _nS(_uM("padding" to unref(data)["padding"])), "flatten" to "", "src" to "/static/test-image/logo.png"), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "scroll-view 组件 padding ")
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["padding"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["paddingActualScrollView"]), 1),
                                _cE("view", _uM("class" to "test-box", "style" to _nS(_uM("height" to "150px"))), _uA(
                                    _cE("scroll-view", _uM("ref_key" to "scrollViewRef", "ref" to scrollViewRef, "class" to "common-scroll-view", "style" to _nS(_uM("padding" to unref(data)["padding"]))), _uA(
                                        _cE("view", _uM("class" to "scroll-view-content"), _uA(
                                            _cE("text", _uM("class" to "common-text"), "scroll-view1")
                                        )),
                                        _cE("view", _uM("class" to "scroll-view-content"), _uA(
                                            _cE("text", _uM("class" to "common-text"), "scroll-view2")
                                        )),
                                        _cE("view", _uM("class" to "scroll-view-content"), _uA(
                                            _cE("text", _uM("class" to "common-text"), "scroll-view3")
                                        ))
                                    ), 4)
                                ), 4)
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                            _cV(_component_enum_data, _uM("items" to paddingEnum, "title" to "padding 枚举值", "onChange" to radioChangePadding, "compact" to true)),
                            _cV(_component_input_data, _uM("defaultValue" to unref(data)["padding"], "title" to "padding 自定义值", "type" to "text", "onConfirm" to inputChangePadding), null, 8, _uA(
                                "defaultValue"
                            ))
                        ))
                    ), 4),
                    _cE("view", null, _uA(
                        _cE("text", null, "native-view组件: padding: 30px 和 padding: 30%"),
                        _cE("text", _uM("class" to "uni-tips"), "说明：cyan 背景色区域的大小即为 padding 的值，灰色区域为容器背景"),
                        _cE("view", _uM("class" to "demo-box", "style" to _nS(_uM("margin" to "20px"))), _uA(
                            _cE("view", _uM("class" to "native-view-container-large"), _uA(
                                _cE("native-view", _uM("class" to "cyan", "style" to _nS(_uM("padding" to "30px"))), null, 4)
                            )),
                            _cE("view", _uM("class" to "native-view-container-large"), _uA(
                                _cE("native-view", _uM("class" to "cyan", "style" to _nS(_uM("padding" to "30%"))), null, 4)
                            ))
                        ), 4)
                    ))
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
                return _uM("common" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 10, "marginBottom" to 0, "marginLeft" to 10, "height" to 100, "backgroundColor" to "#808080")), "demo-box" to _pS(_uM("flexDirection" to "row", "marginTop" to 10, "justifyContent" to "space-around")), "inner-content" to _pS(_uM("flexGrow" to 1, "backgroundColor" to "#00FFFF")), "common-native" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "height" to 100, "backgroundColor" to "#00FFFF", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#FF0000", "borderRightColor" to "#FF0000", "borderBottomColor" to "#FF0000", "borderLeftColor" to "#FF0000")), "common-dynamic" to _pS(_uM("height" to 80, "backgroundColor" to "#808080")), "common-image" to _pS(_uM("width" to 80, "height" to 80, "backgroundColor" to "#808080")), "test-container" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "marginTop" to 10)), "test-item" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 5, "marginBottom" to 0, "marginLeft" to 5)), "test-box" to _pS(_uM("width" to "100%", "height" to 80, "backgroundColor" to "#D3D3D3")), "text-padding" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 10, "marginBottom" to 0, "marginLeft" to 10, "height" to 100, "backgroundColor" to "#808080", "fontSize" to 16, "color" to "#000000")), "image-padding" to _pS(_uM("width" to 100, "height" to 100, "backgroundColor" to "#808080")), "common-scroll-view" to _pS(_uM("height" to 100, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#0000FF", "borderRightColor" to "#0000FF", "borderBottomColor" to "#0000FF", "borderLeftColor" to "#0000FF")), "scroll-view-content" to _pS(_uM("width" to "100%", "height" to 100, "alignItems" to "center", "justifyContent" to "center", "borderTopWidth" to 2, "borderRightWidth" to 2, "borderBottomWidth" to 2, "borderLeftWidth" to 2, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#00FFFF", "borderRightColor" to "#00FFFF", "borderBottomColor" to "#00FFFF", "borderLeftColor" to "#00FFFF")), "common-text" to _pS(_uM("fontSize" to 12)), "native-view-container-large" to _pS(_uM("width" to 120, "height" to 120, "backgroundColor" to "#e0e0e0", "borderTopWidth" to 2, "borderRightWidth" to 2, "borderBottomWidth" to 2, "borderLeftWidth" to 2, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#999999", "borderRightColor" to "#999999", "borderBottomColor" to "#999999", "borderLeftColor" to "#999999", "marginTop" to 0, "marginRight" to 10, "marginBottom" to 0, "marginLeft" to 10, "alignItems" to "center", "justifyContent" to "center")), "cyan" to _pS(_uM("backgroundColor" to "#00FFFF")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
