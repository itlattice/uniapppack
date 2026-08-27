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
open class GenPagesCSSFlexAlignSelf : BasePage {
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
    open var radioChangeAlignSelf: (index: Number) -> Unit
        get() {
            return unref(this.`$exposed`["radioChangeAlignSelf"]) as (index: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "radioChangeAlignSelf", value)
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
        var setup: (__props: GenPagesCSSFlexAlignSelf, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSFlexAlignSelf
            val _cache = __ins.renderCache
            val alignSelfEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "auto"),
                ItemType(value = 2, name = "center"),
                ItemType(value = 3, name = "flex-start"),
                ItemType(value = 4, name = "flex-end"),
                ItemType(value = 5, name = "stretch")
            ) as UTSArray<ItemType>
            val data = reactive(_uO("alignSelf" to "center", "alignSelfActual" to "", "alignSelfActualText" to "", "alignSelfActualImage" to "", "alignSelfActualFlat" to "", "alignSelfActualTextFlat" to "", "alignSelfActualImageFlat" to ""))
            val viewRef = ref(null as UniElement?)
            val textRef = ref(null as UniTextElement?)
            val imageRef = ref(null as UniImageElement?)
            val viewRefFlat = ref(null as UniElement?)
            val textRefFlat = ref(null as UniTextElement?)
            val imageRefFlat = ref(null as UniImageElement?)
            val getPropertyValues = fun(){
                data["alignSelfActual"] = viewRef.value?.style?.getPropertyValue("align-self") ?: ""
                data["alignSelfActualFlat"] = viewRefFlat.value?.style?.getPropertyValue("align-self") ?: ""
                data["alignSelfActualText"] = textRef.value?.style?.getPropertyValue("align-self") ?: ""
                data["alignSelfActualTextFlat"] = textRefFlat.value?.style?.getPropertyValue("align-self") ?: ""
                data["alignSelfActualImage"] = imageRef.value?.style?.getPropertyValue("align-self") ?: ""
                data["alignSelfActualImageFlat"] = imageRefFlat.value?.style?.getPropertyValue("align-self") ?: ""
            }
            val changeAlignSelf = fun(value: String){
                data["alignSelf"] = value
                viewRef.value?.style?.setProperty("align-self", value)
                viewRefFlat.value?.style?.setProperty("align-self", value)
                textRef.value?.style?.setProperty("align-self", value)
                textRefFlat.value?.style?.setProperty("align-self", value)
                imageRef.value?.style?.setProperty("align-self", value)
                imageRefFlat.value?.style?.setProperty("align-self", value)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangeAlignSelf = fun(index: Number){
                val selectedItem = alignSelfEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changeAlignSelf(selectedItem.name)
                }
            }
            val inputChangeAlignSelf = fun(value: String){
                changeAlignSelf(value)
            }
            onReady(fun(){
                getPropertyValues()
            }
            )
            __expose(_uM("radioChangeAlignSelf" to radioChangeAlignSelf, "data" to data))
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1"))), _uA(
                        _cE("text", _uM("class" to "uni-tips"), "说明：左边是正常版本，右边是拍平版本"),
                        _cE("view", null, _uA(
                            _cE("text", null, "align-self: auto"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "demo-container align-start"), _uA(
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("align-self" to "auto"))), null, 4)
                                )),
                                _cE("view", _uM("class" to "demo-container align-start"), _uA(
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("align-self" to "auto")), "flatten" to ""), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", null, "align-self: center"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "demo-container align-center"), _uA(
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("align-self" to "center"))), null, 4)
                                )),
                                _cE("view", _uM("class" to "demo-container align-center"), _uA(
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("align-self" to "center")), "flatten" to ""), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", null, "align-self: flex-start"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "demo-container align-start"), _uA(
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("align-self" to "flex-start"))), null, 4)
                                )),
                                _cE("view", _uM("class" to "demo-container align-start"), _uA(
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("align-self" to "flex-start")), "flatten" to ""), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", null, "align-self: flex-end"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "demo-container"), _uA(
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("align-self" to "flex-end"))), null, 4)
                                )),
                                _cE("view", _uM("class" to "demo-container"), _uA(
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("align-self" to "flex-end")), "flatten" to ""), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", null, "align-self: stretch"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "demo-container"), _uA(
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("align-self" to "stretch"))), null, 4)
                                )),
                                _cE("view", _uM("class" to "demo-container"), _uA(
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("align-self" to "stretch")), "flatten" to ""), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "scroll-view 组件")
                        )),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("view", _uM("class" to "demo-container align-center"), _uA(
                                _cE("scroll-view", _uM("class" to "common", "style" to _nS(_uM("align-self" to "center")), "direction" to "horizontal"), _uA(
                                    _cE("text", _uM("class" to "scroll-view-label"), "align-self: center")
                                ), 4)
                            )),
                            _cE("view", _uM("class" to "demo-container align-center"), _uA(
                                _cE("scroll-view", _uM("class" to "common", "style" to _nS(_uM("align-self" to "flex-start")), "direction" to "horizontal"), _uA(
                                    _cE("text", _uM("class" to "scroll-view-label"), "align-self: flex-start")
                                ), 4)
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 align-self ")
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["alignSelf"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["alignSelfActual"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("ref_key" to "viewRef", "ref" to viewRef, "class" to "common test-view", "style" to _nS(_uM("alignSelf" to unref(data)["alignSelf"]))), _uA(
                                        _cE("text", _uM("class" to "common-text"), "view")
                                    ), 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["alignSelf"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["alignSelfActualText"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRef", "ref" to textRef, "class" to "common test-text", "style" to _nS(_uM("alignSelf" to unref(data)["alignSelf"]))), "text", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["alignSelf"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["alignSelfActualImage"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("ref_key" to "imageRef", "ref" to imageRef, "class" to "common test-image", "style" to _nS(_uM("alignSelf" to unref(data)["alignSelf"])), "src" to "/static/test-image/logo.png"), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["alignSelf"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["alignSelfActualFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("ref_key" to "viewRefFlat", "ref" to viewRefFlat, "class" to "common test-view-flatten", "style" to _nS(_uM("alignSelf" to unref(data)["alignSelf"])), "flatten" to ""), _uA(
                                        _cE("text", _uM("class" to "common-text"), "view")
                                    ), 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["alignSelf"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["alignSelfActualTextFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRefFlat", "ref" to textRefFlat, "class" to "common test-text-flatten", "style" to _nS(_uM("alignSelf" to unref(data)["alignSelf"])), "flatten" to ""), "text", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["alignSelf"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["alignSelfActualImageFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("ref_key" to "imageRefFlat", "ref" to imageRefFlat, "class" to "common test-image-flatten", "style" to _nS(_uM("alignSelf" to unref(data)["alignSelf"])), "flatten" to "", "src" to "/static/test-image/logo.png"), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                            _cV(_component_enum_data, _uM("items" to alignSelfEnum, "title" to "align-self 枚举值", "onChange" to radioChangeAlignSelf, "compact" to true)),
                            _cV(_component_input_data, _uM("defaultValue" to unref(data)["alignSelf"], "title" to "align-self 自定义值", "type" to "text", "onConfirm" to inputChangeAlignSelf), null, 8, _uA(
                                "defaultValue"
                            ))
                        )),
                        _cE("text", _uM("class" to "uni-title-text uni-common-mt"), "native-view 组件：align-self: center 和 flex-start"),
                        _cE("text", _uM("class" to "uni-subtitle-text"), "native-view 作为 flex 子项"),
                        _cE("view", _uM("class" to "demo-box uni-common-mb"), _uA(
                            _cE("view", _uM("class" to "demo-container align-center"), _uA(
                                _cE("native-view", _uM("class" to "common", "style" to _nS(_uM("align-self" to "center"))), null, 4)
                            )),
                            _cE("view", _uM("class" to "demo-container align-center"), _uA(
                                _cE("native-view", _uM("class" to "common", "style" to _nS(_uM("align-self" to "flex-start"))), null, 4)
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
                return _uM("demo-container" to _pS(_uM("display" to "flex", "backgroundColor" to "#cdcbcb", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#dddddd", "borderRightColor" to "#dddddd", "borderBottomColor" to "#dddddd", "borderLeftColor" to "#dddddd", "flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 10, "marginBottom" to 0, "marginLeft" to 10)), "demo-box" to _pS(_uM("flexDirection" to "row", "marginTop" to 10, "justifyContent" to "space-around")), "align-start" to _pS(_uM("alignItems" to "flex-start")), "align-center" to _pS(_uM("alignItems" to "center")), "common" to _pS(_uM("width" to 80, "height" to 80, "backgroundColor" to "#00FFFF")), "common-text" to _pS(_uM("width" to 50)), "test-container" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "marginTop" to 10)), "test-item" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 5, "marginBottom" to 0, "marginLeft" to 5)), "test-box" to _pS(_uM("display" to "flex", "width" to "100%", "height" to 80, "backgroundColor" to "#808080", "alignItems" to "flex-start")), "scroll-view-label" to _pS(_uM("fontSize" to 12, "textAlign" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
