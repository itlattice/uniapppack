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
open class GenPagesCSSPaddingPaddingLeft : BasePage {
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
    open var radioChangePaddingLeft: (index: Number) -> Unit
        get() {
            return unref(this.`$exposed`["radioChangePaddingLeft"]) as (index: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "radioChangePaddingLeft", value)
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
        var setup: (__props: GenPagesCSSPaddingPaddingLeft, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSPaddingPaddingLeft
            val _cache = __ins.renderCache
            val data = reactive(_uO("paddingLeft" to "25px", "paddingLeftActual" to "", "paddingLeftActualText" to "", "paddingLeftActualImage" to "", "paddingLeftActualFlat" to "", "paddingLeftActualTextFlat" to "", "paddingLeftActualImageFlat" to ""))
            val viewRef = ref(null as UniElement?)
            val textRef = ref(null as UniTextElement?)
            val imageRef = ref(null as UniImageElement?)
            val viewRefFlat = ref(null as UniElement?)
            val textRefFlat = ref(null as UniTextElement?)
            val imageRefFlat = ref(null as UniImageElement?)
            val paddingLeftEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "0"),
                ItemType(value = 2, name = "0px"),
                ItemType(value = 3, name = "20px"),
                ItemType(value = 4, name = "0%"),
                ItemType(value = 5, name = "10%")
            ) as UTSArray<ItemType>
            val getPropertyValues = fun(){
                data["paddingLeftActual"] = viewRef.value?.style?.getPropertyValue("padding-left") ?: ""
                data["paddingLeftActualFlat"] = viewRefFlat.value?.style?.getPropertyValue("padding-left") ?: ""
                data["paddingLeftActualText"] = textRef.value?.style?.getPropertyValue("padding-left") ?: ""
                data["paddingLeftActualTextFlat"] = textRefFlat.value?.style?.getPropertyValue("padding-left") ?: ""
                data["paddingLeftActualImage"] = imageRef.value?.style?.getPropertyValue("padding-left") ?: ""
                data["paddingLeftActualImageFlat"] = imageRefFlat.value?.style?.getPropertyValue("padding-left") ?: ""
            }
            val changePaddingLeft = fun(value: String){
                data["paddingLeft"] = value
                viewRef.value?.style?.setProperty("padding-left", value)
                viewRefFlat.value?.style?.setProperty("padding-left", value)
                textRef.value?.style?.setProperty("padding-left", value)
                textRefFlat.value?.style?.setProperty("padding-left", value)
                imageRef.value?.style?.setProperty("padding-left", value)
                imageRefFlat.value?.style?.setProperty("padding-left", value)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangePaddingLeft = fun(index: Number){
                val selectedItem = paddingLeftEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changePaddingLeft(selectedItem.name)
                }
            }
            val inputChangePaddingLeft = fun(value: String){
                changePaddingLeft(value)
            }
            onReady(fun(){
                getPropertyValues()
            }
            )
            __expose(_uM("radioChangePaddingLeft" to radioChangePaddingLeft, "data" to data))
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1"))), _uA(
                        _cE("text", _uM("class" to "uni-tips"), "说明：左边是正常版本，右边是拍平版本"),
                        _cE("view", null, _uA(
                            _cE("text", null, "padding-left: 25px"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("padding-left" to "25px"))), _uA(
                                    _cE("view", _uM("class" to "inner-content"))
                                ), 4),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("padding-left" to "25px")), "flatten" to ""), _uA(
                                    _cE("view", _uM("class" to "inner-content"))
                                ), 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "padding-left: 10%"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("padding-left" to "10%"))), _uA(
                                    _cE("view", _uM("class" to "inner-content"))
                                ), 4),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("padding-left" to "10%")), "flatten" to ""), _uA(
                                    _cE("view", _uM("class" to "inner-content"))
                                ), 4)
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "scroll-view 组件")
                        )),
                        _cE("view", null, _uA(
                            _cE("text", _uM("class" to "uni-subtitle-text"), "padding-left: 10% 和 padding-left: 30px"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("scroll-view", _uM("class" to "common", "style" to _nS(_uM("padding-left" to "10%"))), _uA(
                                    _cE("view", _uM("class" to "inner-content"))
                                ), 4),
                                _cE("scroll-view", _uM("class" to "common", "style" to _nS(_uM("padding-left" to "30px"))), _uA(
                                    _cE("view", _uM("class" to "inner-content"))
                                ), 4)
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 padding-left ")
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["paddingLeft"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["paddingLeftActual"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("ref_key" to "viewRef", "ref" to viewRef, "class" to "common-dynamic test-view", "style" to _nS(_uM("paddingLeft" to unref(data)["paddingLeft"]))), _uA(
                                        _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1", "background-color" to "cyan"))), _uA(
                                            _cE("text", null, "view")
                                        ), 4)
                                    ), 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["paddingLeft"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["paddingLeftActualText"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRef", "ref" to textRef, "class" to "common-dynamic test-text", "style" to _nS(_uM("paddingLeft" to unref(data)["paddingLeft"]))), "text", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["paddingLeft"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["paddingLeftActualImage"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("ref_key" to "imageRef", "ref" to imageRef, "class" to "common-image test-image", "style" to _nS(_uM("paddingLeft" to unref(data)["paddingLeft"])), "src" to "/static/test-image/logo.png"), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["paddingLeft"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["paddingLeftActualFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("ref_key" to "viewRefFlat", "ref" to viewRefFlat, "class" to "common-dynamic test-view-flatten", "style" to _nS(_uM("paddingLeft" to unref(data)["paddingLeft"])), "flatten" to ""), _uA(
                                        _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1", "background-color" to "cyan"))), _uA(
                                            _cE("text", null, "view")
                                        ), 4)
                                    ), 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["paddingLeft"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["paddingLeftActualTextFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRefFlat", "ref" to textRefFlat, "class" to "common-dynamic test-text-flatten", "style" to _nS(_uM("paddingLeft" to unref(data)["paddingLeft"])), "flatten" to ""), "text", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["paddingLeft"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["paddingLeftActualImageFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("ref_key" to "imageRefFlat", "ref" to imageRefFlat, "class" to "common-image test-image-flatten", "style" to _nS(_uM("paddingLeft" to unref(data)["paddingLeft"])), "flatten" to "", "src" to "/static/test-image/logo.png"), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                            _cV(_component_enum_data, _uM("items" to paddingLeftEnum, "title" to "padding-left 枚举值", "onChange" to radioChangePaddingLeft, "compact" to true)),
                            _cV(_component_input_data, _uM("defaultValue" to unref(data)["paddingLeft"], "title" to "padding-left 自定义值", "type" to "text", "onConfirm" to inputChangePaddingLeft), null, 8, _uA(
                                "defaultValue"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mb"), _uA(
                            _cE("text", null, "native-view组件: padding-left: 30px 和 padding-left: 30%"),
                            _cE("text", _uM("class" to "uni-tips"), "说明：cyan 背景色区域的宽度即为 padding-left 的值，灰色区域为容器背景"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "native-view-container-large"), _uA(
                                    _cE("native-view", _uM("class" to "native-view-padding-large", "style" to _nS(_uM("padding-left" to "30px"))), null, 4)
                                )),
                                _cE("view", _uM("class" to "native-view-container-large"), _uA(
                                    _cE("native-view", _uM("class" to "native-view-padding-large", "style" to _nS(_uM("padding-left" to "30%"))), null, 4)
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
                return _uM("common" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 10, "marginBottom" to 0, "marginLeft" to 10, "height" to 100, "backgroundColor" to "#808080")), "demo-box" to _pS(_uM("flexDirection" to "row", "marginTop" to 10, "justifyContent" to "space-around")), "inner-content" to _pS(_uM("flexGrow" to 1, "backgroundColor" to "#00FFFF")), "common-dynamic" to _pS(_uM("height" to 80, "backgroundColor" to "#808080")), "common-image" to _pS(_uM("width" to 80, "height" to 80, "backgroundColor" to "#808080")), "test-container" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "marginTop" to 10)), "test-item" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 5, "marginBottom" to 0, "marginLeft" to 5)), "test-box" to _pS(_uM("width" to "100%", "height" to 80, "backgroundColor" to "#D3D3D3")), "native-view-container-large" to _pS(_uM("width" to 120, "height" to 120, "backgroundColor" to "#e0e0e0", "borderTopWidth" to 2, "borderRightWidth" to 2, "borderBottomWidth" to 2, "borderLeftWidth" to 2, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#999999", "borderRightColor" to "#999999", "borderBottomColor" to "#999999", "borderLeftColor" to "#999999", "marginTop" to 0, "marginRight" to 10, "marginBottom" to 0, "marginLeft" to 10, "alignItems" to "flex-start")), "native-view-padding-large" to _pS(_uM("height" to "100%", "backgroundColor" to "#00FFFF")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
