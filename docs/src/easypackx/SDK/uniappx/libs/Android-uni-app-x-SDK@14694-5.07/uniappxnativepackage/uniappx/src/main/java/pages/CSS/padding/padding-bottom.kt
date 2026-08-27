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
open class GenPagesCSSPaddingPaddingBottom : BasePage {
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
    open var radioChangePaddingBottom: (index: Number) -> Unit
        get() {
            return unref(this.`$exposed`["radioChangePaddingBottom"]) as (index: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "radioChangePaddingBottom", value)
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
        var setup: (__props: GenPagesCSSPaddingPaddingBottom, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSPaddingPaddingBottom
            val _cache = __ins.renderCache
            val data = reactive(_uO("paddingBottom" to "25px", "paddingBottomActual" to "", "paddingBottomActualText" to "", "paddingBottomActualImage" to "", "paddingBottomActualFlat" to "", "paddingBottomActualTextFlat" to "", "paddingBottomActualImageFlat" to ""))
            val viewRef = ref(null as UniElement?)
            val textRef = ref(null as UniTextElement?)
            val imageRef = ref(null as UniImageElement?)
            val viewRefFlat = ref(null as UniElement?)
            val textRefFlat = ref(null as UniTextElement?)
            val imageRefFlat = ref(null as UniImageElement?)
            val paddingBottomEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "0"),
                ItemType(value = 2, name = "0px"),
                ItemType(value = 3, name = "40px"),
                ItemType(value = 4, name = "0%"),
                ItemType(value = 5, name = "20%")
            ) as UTSArray<ItemType>
            val getPropertyValues = fun(){
                data["paddingBottomActual"] = viewRef.value?.style?.getPropertyValue("padding-bottom") ?: ""
                data["paddingBottomActualFlat"] = viewRefFlat.value?.style?.getPropertyValue("padding-bottom") ?: ""
                data["paddingBottomActualText"] = textRef.value?.style?.getPropertyValue("padding-bottom") ?: ""
                data["paddingBottomActualTextFlat"] = textRefFlat.value?.style?.getPropertyValue("padding-bottom") ?: ""
                data["paddingBottomActualImage"] = imageRef.value?.style?.getPropertyValue("padding-bottom") ?: ""
                data["paddingBottomActualImageFlat"] = imageRefFlat.value?.style?.getPropertyValue("padding-bottom") ?: ""
            }
            val changePaddingBottom = fun(value: String){
                data["paddingBottom"] = value
                viewRef.value?.style?.setProperty("padding-bottom", value)
                viewRefFlat.value?.style?.setProperty("padding-bottom", value)
                textRef.value?.style?.setProperty("padding-bottom", value)
                textRefFlat.value?.style?.setProperty("padding-bottom", value)
                imageRef.value?.style?.setProperty("padding-bottom", value)
                imageRefFlat.value?.style?.setProperty("padding-bottom", value)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangePaddingBottom = fun(index: Number){
                val selectedItem = paddingBottomEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changePaddingBottom(selectedItem.name)
                }
            }
            val inputChangePaddingBottom = fun(value: String){
                changePaddingBottom(value)
            }
            onReady(fun(){
                getPropertyValues()
            }
            )
            __expose(_uM("radioChangePaddingBottom" to radioChangePaddingBottom, "data" to data))
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1"))), _uA(
                        _cE("text", _uM("class" to "uni-tips"), "说明：左边是正常版本，右边是拍平版本"),
                        _cE("view", null, _uA(
                            _cE("text", null, "padding-bottom: 25px"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("padding-bottom" to "25px"))), _uA(
                                    _cE("view", _uM("class" to "inner-content"))
                                ), 4),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("padding-bottom" to "25px")), "flatten" to ""), _uA(
                                    _cE("view", _uM("class" to "inner-content"))
                                ), 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "padding-bottom: 10%"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("padding-bottom" to "10%"))), _uA(
                                    _cE("view", _uM("class" to "inner-content"))
                                ), 4),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("padding-bottom" to "10%")), "flatten" to ""), _uA(
                                    _cE("view", _uM("class" to "inner-content"))
                                ), 4)
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "scroll-view 组件")
                        )),
                        _cE("view", null, _uA(
                            _cE("text", _uM("class" to "uni-subtitle-text"), "padding-bottom: 10% 和 padding-bottom: 30px"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("scroll-view", _uM("class" to "common", "style" to _nS(_uM("padding-bottom" to "10%"))), _uA(
                                    _cE("view", _uM("class" to "inner-content"))
                                ), 4),
                                _cE("scroll-view", _uM("class" to "common", "style" to _nS(_uM("padding-bottom" to "30px"))), _uA(
                                    _cE("view", _uM("class" to "inner-content"))
                                ), 4)
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 padding-bottom ")
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["paddingBottom"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["paddingBottomActual"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("ref_key" to "viewRef", "ref" to viewRef, "class" to "common-view test-view", "style" to _nS(_uM("paddingBottom" to unref(data)["paddingBottom"]))), _uA(
                                        _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1", "background-color" to "cyan"))), _uA(
                                            _cE("text", null, "view")
                                        ), 4)
                                    ), 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["paddingBottom"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["paddingBottomActualText"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRef", "ref" to textRef, "class" to "common-text test-text", "style" to _nS(_uM("paddingBottom" to unref(data)["paddingBottom"]))), "当前为text组件当前为text组件", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["paddingBottom"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["paddingBottomActualImage"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("ref_key" to "imageRef", "ref" to imageRef, "class" to "common-image test-image", "style" to _nS(_uM("paddingBottom" to unref(data)["paddingBottom"])), "src" to "/static/test-image/logo.png"), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["paddingBottom"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["paddingBottomActualFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("ref_key" to "viewRefFlat", "ref" to viewRefFlat, "class" to "common-view test-view-flatten", "style" to _nS(_uM("paddingBottom" to unref(data)["paddingBottom"])), "flatten" to ""), _uA(
                                        _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1", "background-color" to "cyan"))), _uA(
                                            _cE("text", null, "view")
                                        ), 4)
                                    ), 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["paddingBottom"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["paddingBottomActualTextFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRefFlat", "ref" to textRefFlat, "class" to "common-text test-text-flatten", "style" to _nS(_uM("paddingBottom" to unref(data)["paddingBottom"])), "flatten" to ""), "当前为text组件当前为text组件", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["paddingBottom"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["paddingBottomActualImageFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("ref_key" to "imageRefFlat", "ref" to imageRefFlat, "class" to "common-image test-image-flatten", "style" to _nS(_uM("paddingBottom" to unref(data)["paddingBottom"])), "flatten" to "", "src" to "/static/test-image/logo.png"), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                            _cV(_component_enum_data, _uM("items" to paddingBottomEnum, "title" to "padding-bottom 枚举值", "onChange" to radioChangePaddingBottom, "compact" to true)),
                            _cV(_component_input_data, _uM("defaultValue" to unref(data)["paddingBottom"], "title" to "padding-bottom 自定义值", "type" to "text", "onConfirm" to inputChangePaddingBottom), null, 8, _uA(
                                "defaultValue"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mb"), _uA(
                            _cE("text", null, "native-view组件: padding-bottom: 30px 和 padding-bottom: 30%"),
                            _cE("text", _uM("class" to "uni-tips"), "说明：cyan 背景色区域的高度即为 padding-bottom 的值，灰色区域为容器背景"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "native-view-container-large"), _uA(
                                    _cE("native-view", _uM("class" to "native-view-padding-large", "style" to _nS(_uM("padding-bottom" to "30px"))), null, 4)
                                )),
                                _cE("view", _uM("class" to "native-view-container-large"), _uA(
                                    _cE("native-view", _uM("class" to "native-view-padding-large", "style" to _nS(_uM("padding-bottom" to "30%"))), null, 4)
                                ))
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
                return _uM("common" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 10, "marginBottom" to 0, "marginLeft" to 10, "height" to 100, "backgroundColor" to "#808080")), "demo-box" to _pS(_uM("flexDirection" to "row", "marginTop" to 10, "justifyContent" to "space-around")), "inner-content" to _pS(_uM("flexGrow" to 1, "backgroundColor" to "#00FFFF")), "common-view" to _pS(_uM("height" to 80, "backgroundColor" to "#808080")), "common-text" to _pS(_uM("minHeight" to 40, "backgroundColor" to "#808080")), "common-image" to _pS(_uM("width" to 80, "height" to 80, "backgroundColor" to "#808080")), "test-container" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "marginTop" to 10)), "test-item" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 5, "marginBottom" to 0, "marginLeft" to 5)), "test-box" to _pS(_uM("width" to "100%", "height" to 80, "backgroundColor" to "#D3D3D3")), "native-view-container-large" to _pS(_uM("width" to 120, "height" to 120, "backgroundColor" to "#e0e0e0", "borderTopWidth" to 2, "borderRightWidth" to 2, "borderBottomWidth" to 2, "borderLeftWidth" to 2, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#999999", "borderRightColor" to "#999999", "borderBottomColor" to "#999999", "borderLeftColor" to "#999999", "marginTop" to 0, "marginRight" to 10, "marginBottom" to 0, "marginLeft" to 10, "flexDirection" to "column", "justifyContent" to "flex-end")), "native-view-padding-large" to _pS(_uM("width" to "100%", "backgroundColor" to "#00FFFF")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
