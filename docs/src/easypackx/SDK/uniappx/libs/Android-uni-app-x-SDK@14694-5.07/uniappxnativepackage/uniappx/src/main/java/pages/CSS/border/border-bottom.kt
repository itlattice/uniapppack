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
open class GenPagesCSSBorderBorderBottom : BasePage {
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
    open var radioChangeBorderBottom: (index: Number) -> Unit
        get() {
            return unref(this.`$exposed`["radioChangeBorderBottom"]) as (index: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "radioChangeBorderBottom", value)
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
        var setup: (__props: GenPagesCSSBorderBorderBottom, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSBorderBorderBottom
            val _cache = __ins.renderCache
            val borderBottomEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "none"),
                ItemType(value = 2, name = "1px solid black"),
                ItemType(value = 3, name = "2px dashed blue"),
                ItemType(value = 4, name = "3px dotted green")
            ) as UTSArray<ItemType>
            val data = reactive(_uO("borderBottom" to "5px solid purple", "borderBottomActual" to "", "borderBottomActualText" to "", "borderBottomActualImage" to "", "borderBottomActualFlat" to "", "borderBottomActualTextFlat" to "", "borderBottomActualImageFlat" to ""))
            val viewRef = ref(null as UniElement?)
            val textRef = ref(null as UniTextElement?)
            val imageRef = ref(null as UniImageElement?)
            val viewRefFlat = ref(null as UniElement?)
            val textRefFlat = ref(null as UniTextElement?)
            val imageRefFlat = ref(null as UniImageElement?)
            val getPropertyValues = fun(){
                data["borderBottomActual"] = viewRef.value?.style?.getPropertyValue("border-bottom") ?: ""
                data["borderBottomActualFlat"] = viewRefFlat.value?.style?.getPropertyValue("border-bottom") ?: ""
                data["borderBottomActualText"] = textRef.value?.style?.getPropertyValue("border-bottom") ?: ""
                data["borderBottomActualTextFlat"] = textRefFlat.value?.style?.getPropertyValue("border-bottom") ?: ""
                data["borderBottomActualImage"] = imageRef.value?.style?.getPropertyValue("border-bottom") ?: ""
                data["borderBottomActualImageFlat"] = imageRefFlat.value?.style?.getPropertyValue("border-bottom") ?: ""
            }
            val changeBorderBottom = fun(value: String){
                data["borderBottom"] = value
                viewRef.value?.style?.setProperty("border-bottom", value)
                viewRefFlat.value?.style?.setProperty("border-bottom", value)
                textRef.value?.style?.setProperty("border-bottom", value)
                textRefFlat.value?.style?.setProperty("border-bottom", value)
                imageRef.value?.style?.setProperty("border-bottom", value)
                imageRefFlat.value?.style?.setProperty("border-bottom", value)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangeBorderBottom = fun(index: Number){
                val selectedItem = borderBottomEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changeBorderBottom(selectedItem.name)
                }
            }
            val inputChangeBorderBottom = fun(value: String){
                changeBorderBottom(value)
            }
            onReady(fun(){
                getPropertyValues()
            }
            )
            __expose(_uM("radioChangeBorderBottom" to radioChangeBorderBottom, "data" to data))
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1"))), _uA(
                        _cE("view", null, _uA(
                            _cE("text", null, "border-bottom: 5px dashed blue"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-bottom" to "5px dashed blue"))), null, 4),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-bottom" to "5px dashed blue")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("text", _uM("class" to "uni-title-text uni-common-mt"), "scroll-view 组件"),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("scroll-view", _uM("class" to "common", "style" to _nS(_uM("border-bottom" to "5px dashed blue"))), _uA(
                                _cE("text", _uM("class" to "common-text"), "border-bottom: 5px dashed blue")
                            ), 4),
                            _cE("scroll-view", _uM("class" to "common", "style" to _nS(_uM("border-bottom" to "10px solid green"))), _uA(
                                _cE("text", _uM("class" to "common-text"), "border-bottom: 10px solid green")
                            ), 4)
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 border-bottom ")
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["borderBottom"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["borderBottomActual"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("ref_key" to "viewRef", "ref" to viewRef, "class" to "common-dynamic test-view", "style" to _nS(_uM("borderBottom" to unref(data)["borderBottom"]))), _uA(
                                        _cE("text", null, "view")
                                    ), 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["borderBottom"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["borderBottomActualText"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRef", "ref" to textRef, "class" to "common-dynamic test-text", "style" to _nS(_uM("borderBottom" to unref(data)["borderBottom"]))), "text", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["borderBottom"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["borderBottomActualImage"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("ref_key" to "imageRef", "ref" to imageRef, "class" to "common-image test-image", "style" to _nS(_uM("borderBottom" to unref(data)["borderBottom"])), "src" to "/static/test-image/logo.png"), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["borderBottom"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["borderBottomActualFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("ref_key" to "viewRefFlat", "ref" to viewRefFlat, "class" to "common-dynamic test-view-flatten", "style" to _nS(_uM("borderBottom" to unref(data)["borderBottom"])), "flatten" to ""), _uA(
                                        _cE("text", null, "view")
                                    ), 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["borderBottom"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["borderBottomActualTextFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRefFlat", "ref" to textRefFlat, "class" to "common-dynamic test-text-flatten", "style" to _nS(_uM("borderBottom" to unref(data)["borderBottom"])), "flatten" to ""), "text", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["borderBottom"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["borderBottomActualImageFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("ref_key" to "imageRefFlat", "ref" to imageRefFlat, "class" to "common-image test-image-flatten", "style" to _nS(_uM("borderBottom" to unref(data)["borderBottom"])), "flatten" to "", "src" to "/static/test-image/logo.png"), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                            _cV(_component_enum_data, _uM("items" to borderBottomEnum, "title" to "border-bottom 枚举值", "onChange" to radioChangeBorderBottom, "compact" to true)),
                            _cV(_component_input_data, _uM("defaultValue" to unref(data)["borderBottom"], "title" to "border-bottom 自定义值", "type" to "text", "onConfirm" to inputChangeBorderBottom), null, 8, _uA(
                                "defaultValue"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mb"), _uA(
                            _cE("text", null, "native-view组件: border-bottom: 5px dashed blue 和 10px solid green"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("native-view", _uM("class" to "common", "style" to _nS(_uM("border-bottom" to "5px dashed blue"))), null, 4),
                                _cE("native-view", _uM("class" to "common", "style" to _nS(_uM("border-bottom" to "10px solid green"))), null, 4)
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
                return _uM("common" to _pS(_uM("width" to 150, "height" to 50, "backgroundColor" to "#808080")), "demo-box" to _pS(_uM("flexDirection" to "row", "marginTop" to 10, "justifyContent" to "space-between")), "common-dynamic" to _pS(_uM("height" to 50, "backgroundColor" to "#808080")), "common-image" to _pS(_uM("width" to 50, "height" to 50, "backgroundColor" to "#808080")), "test-container" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "marginTop" to 10)), "test-item" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 5, "marginBottom" to 0, "marginLeft" to 5)), "test-box" to _pS(_uM("width" to "100%", "height" to 60, "backgroundColor" to "#D3D3D3")), "common-text" to _pS(_uM("fontSize" to 12)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
