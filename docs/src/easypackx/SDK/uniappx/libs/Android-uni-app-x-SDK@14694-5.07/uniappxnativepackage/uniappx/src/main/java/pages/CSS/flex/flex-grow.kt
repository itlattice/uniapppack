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
open class GenPagesCSSFlexFlexGrow : BasePage {
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
    open var radioChangeFlexGrow: (index: Number) -> Unit
        get() {
            return unref(this.`$exposed`["radioChangeFlexGrow"]) as (index: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "radioChangeFlexGrow", value)
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
        var setup: (__props: GenPagesCSSFlexFlexGrow, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSFlexFlexGrow
            val _cache = __ins.renderCache
            val flexGrowEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "0"),
                ItemType(value = 2, name = "0.5"),
                ItemType(value = 3, name = "1"),
                ItemType(value = 4, name = "2")
            ) as UTSArray<ItemType>
            val data = reactive(_uO("flexGrow" to "0", "flexGrowActual" to "", "flexGrowActualFlat" to "", "flexGrowActualText" to "", "flexGrowActualImage" to "", "flexGrowActualTextFlat" to "", "flexGrowActualImageFlat" to ""))
            val viewRef = ref(null as UniElement?)
            val viewRefFlat = ref(null as UniElement?)
            val textRef = ref(null as UniTextElement?)
            val imageRef = ref(null as UniImageElement?)
            val textRefFlat = ref(null as UniTextElement?)
            val imageRefFlat = ref(null as UniImageElement?)
            val getPropertyValues = fun(){
                data["flexGrowActual"] = viewRef.value?.style?.getPropertyValue("flex-grow") ?: ""
                data["flexGrowActualFlat"] = viewRefFlat.value?.style?.getPropertyValue("flex-grow") ?: ""
                data["flexGrowActualText"] = textRef.value?.style?.getPropertyValue("flex-grow") ?: ""
                data["flexGrowActualTextFlat"] = textRefFlat.value?.style?.getPropertyValue("flex-grow") ?: ""
                data["flexGrowActualImage"] = imageRef.value?.style?.getPropertyValue("flex-grow") ?: ""
                data["flexGrowActualImageFlat"] = imageRefFlat.value?.style?.getPropertyValue("flex-grow") ?: ""
            }
            val changeFlexGrow = fun(value: String){
                data["flexGrow"] = value
                viewRef.value?.style?.setProperty("flex-grow", value)
                viewRefFlat.value?.style?.setProperty("flex-grow", value)
                textRef.value?.style?.setProperty("flex-grow", value)
                textRefFlat.value?.style?.setProperty("flex-grow", value)
                imageRef.value?.style?.setProperty("flex-grow", value)
                imageRefFlat.value?.style?.setProperty("flex-grow", value)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangeFlexGrow = fun(index: Number){
                val selectedItem = flexGrowEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changeFlexGrow(selectedItem.name)
                }
            }
            val inputChangeFlexGrow = fun(value: String){
                changeFlexGrow(value)
            }
            onReady(fun(){
                getPropertyValues()
            }
            )
            __expose(_uM("radioChangeFlexGrow" to radioChangeFlexGrow, "data" to data))
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1"))), _uA(
                        _cE("text", _uM("class" to "uni-tips"), "说明：左边是正常版本，右边是拍平版本"),
                        _cE("view", null, _uA(
                            _cE("text", null, "flex-grow"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "flex-container"), _uA(
                                    _cE("view", _uM("class" to "common red", "style" to _nS(_uM("flex-grow" to "0.5"))), _uA(
                                        _cE("text", null, "0.5")
                                    ), 4),
                                    _cE("view", _uM("class" to "common green", "style" to _nS(_uM("flex-grow" to "1"))), _uA(
                                        _cE("text", null, "1")
                                    ), 4),
                                    _cE("view", _uM("class" to "common blue", "style" to _nS(_uM("flex-grow" to "2"))), _uA(
                                        _cE("text", null, "2")
                                    ), 4)
                                )),
                                _cE("view", _uM("class" to "flex-container"), _uA(
                                    _cE("view", _uM("class" to "common red", "style" to _nS(_uM("flex-grow" to "0.5")), "flatten" to ""), _uA(
                                        _cE("text", null, "0.5")
                                    ), 4),
                                    _cE("view", _uM("class" to "common green", "style" to _nS(_uM("flex-grow" to "1")), "flatten" to ""), _uA(
                                        _cE("text", null, "1")
                                    ), 4),
                                    _cE("view", _uM("class" to "common blue", "style" to _nS(_uM("flex-grow" to "2")), "flatten" to ""), _uA(
                                        _cE("text", null, "2")
                                    ), 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "scroll-view 组件")
                        )),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("view", _uM("class" to "flex-container-compare", "style" to _nS(_uM("margin-right" to "10px"))), _uA(
                                _cE("view", _uM("class" to "common red width-30-no-grow")),
                                _cE("scroll-view", _uM("class" to "scroll-view-grow green", "style" to _nS(_uM("flex-grow" to "0.5"))), _uA(
                                    _cE("text", _uM("class" to "scroll-view-label"), "flex-grow: 0.5")
                                ), 4),
                                _cE("view", _uM("class" to "common blue width-30-no-grow"))
                            ), 4),
                            _cE("view", _uM("class" to "flex-container-compare"), _uA(
                                _cE("view", _uM("class" to "common red width-30-no-grow")),
                                _cE("scroll-view", _uM("class" to "scroll-view-grow green", "style" to _nS(_uM("flex-grow" to "1"))), _uA(
                                    _cE("text", _uM("class" to "scroll-view-label"), "flex-grow: 1")
                                ), 4),
                                _cE("view", _uM("class" to "common blue width-30-no-grow"))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 flex-grow ")
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["flexGrow"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["flexGrowActual"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("class" to "test-flex-container"), _uA(
                                        _cE("view", _uM("class" to "common-image red")),
                                        _cE("view", _uM("ref_key" to "viewRef", "ref" to viewRef, "class" to "common-image green test-view", "style" to _nS(_uM("flexGrow" to unref(data)["flexGrow"]))), _uA(
                                            _cE("text", _uM("class" to "common-text"), _tD(unref(data)["flexGrow"]), 1)
                                        ), 4),
                                        _cE("view", _uM("class" to "common-image blue"))
                                    ))
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["flexGrow"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["flexGrowActualText"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("class" to "test-flex-container"), _uA(
                                        _cE("text", _uM("class" to "common-text red"), "红色"),
                                        _cE("text", _uM("ref_key" to "textRef", "ref" to textRef, "class" to "common-text green test-text", "style" to _nS(_uM("flexGrow" to unref(data)["flexGrow"]))), "text", 4),
                                        _cE("text", _uM("class" to "common-text blue"), "蓝色")
                                    ))
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["flexGrow"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["flexGrowActualImage"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("class" to "test-flex-container"), _uA(
                                        _cE("image", _uM("class" to "common-image red", "src" to "/static/test-image/logo.png")),
                                        _cE("image", _uM("ref_key" to "imageRef", "ref" to imageRef, "class" to "common-image green test-image", "style" to _nS(_uM("flexGrow" to unref(data)["flexGrow"])), "src" to "/static/test-image/logo.png"), null, 4),
                                        _cE("image", _uM("class" to "common-image blue", "src" to "/static/test-image/logo.png"))
                                    ))
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["flexGrow"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["flexGrowActualFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("class" to "test-flex-container"), _uA(
                                        _cE("view", _uM("class" to "common-image red")),
                                        _cE("view", _uM("ref_key" to "viewRefFlat", "ref" to viewRefFlat, "class" to "common-image green test-view-flatten", "style" to _nS(_uM("flexGrow" to unref(data)["flexGrow"])), "flatten" to ""), _uA(
                                            _cE("text", _uM("class" to "common-text"), _tD(unref(data)["flexGrow"]), 1)
                                        ), 4),
                                        _cE("view", _uM("class" to "common-image blue"))
                                    ))
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["flexGrow"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["flexGrowActualTextFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("class" to "test-flex-container"), _uA(
                                        _cE("text", _uM("class" to "common-text red"), "红色"),
                                        _cE("text", _uM("ref_key" to "textRefFlat", "ref" to textRefFlat, "class" to "common-text green test-text-flatten", "style" to _nS(_uM("flexGrow" to unref(data)["flexGrow"])), "flatten" to ""), "text", 4),
                                        _cE("text", _uM("class" to "common-text blue"), "蓝色")
                                    ))
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["flexGrow"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["flexGrowActualImageFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("class" to "test-flex-container"), _uA(
                                        _cE("image", _uM("class" to "common-image red", "src" to "/static/test-image/logo.png")),
                                        _cE("image", _uM("ref_key" to "imageRefFlat", "ref" to imageRefFlat, "class" to "common-image green test-image-flatten", "style" to _nS(_uM("flexGrow" to unref(data)["flexGrow"])), "flatten" to "", "src" to "/static/test-image/logo.png"), null, 4),
                                        _cE("image", _uM("class" to "common-image blue", "src" to "/static/test-image/logo.png"))
                                    ))
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                            _cV(_component_enum_data, _uM("items" to flexGrowEnum, "title" to "flex-grow 枚举值", "onChange" to radioChangeFlexGrow, "compact" to true)),
                            _cV(_component_input_data, _uM("defaultValue" to unref(data)["flexGrow"], "title" to "flex-grow 自定义值", "type" to "text", "onConfirm" to inputChangeFlexGrow), null, 8, _uA(
                                "defaultValue"
                            ))
                        )),
                        _cE("text", _uM("class" to "uni-title-text uni-common-mt"), "native-view 组件：flex-grow: 0.5 和 flex-grow: 1"),
                        _cE("view", _uM("class" to "demo-box uni-common-mb"), _uA(
                            _cE("view", _uM("class" to "flex-container-compare", "style" to _nS(_uM("margin-right" to "10px"))), _uA(
                                _cE("view", _uM("class" to "common red width-30-no-grow")),
                                _cE("native-view", _uM("class" to "native-view-grow green", "style" to _nS(_uM("flex-grow" to "0.5"))), null, 4),
                                _cE("view", _uM("class" to "common blue width-30-no-grow"))
                            ), 4),
                            _cE("view", _uM("class" to "flex-container-compare"), _uA(
                                _cE("view", _uM("class" to "common red width-30-no-grow")),
                                _cE("native-view", _uM("class" to "native-view-grow green", "style" to _nS(_uM("flex-grow" to "1"))), null, 4),
                                _cE("view", _uM("class" to "common blue width-30-no-grow"))
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
                return _uM("demo-box" to _pS(_uM("flexDirection" to "row", "marginTop" to 10, "justifyContent" to "space-around")), "flex-container" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 10, "marginBottom" to 0, "marginLeft" to 10, "height" to 100, "backgroundColor" to "#808080", "flexDirection" to "row")), "common" to _pS(_uM("width" to 50, "height" to 50, "justifyContent" to "center", "alignItems" to "center")), "common-text" to _pS(_uM("height" to 30, "backgroundColor" to "#008000", "fontSize" to 14, "color" to "#FFFFFF")), "common-image" to _pS(_uM("width" to 30, "height" to 30, "backgroundColor" to "#008000")), "test-container" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "marginTop" to 10)), "test-item" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 5, "marginBottom" to 0, "marginLeft" to 5)), "test-box" to _pS(_uM("width" to "100%", "height" to 50, "backgroundColor" to "#808080")), "test-flex-container" to _pS(_uM("width" to "100%", "height" to "100%", "flexDirection" to "row")), "red" to _pS(_uM("backgroundColor" to "#FF0000")), "blue" to _pS(_uM("backgroundColor" to "#0000FF")), "green" to _pS(_uM("backgroundColor" to "#008000")), "scroll-view-label" to _pS(_uM("fontSize" to 12, "lineHeight" to "50px", "textAlign" to "center")), "flex-container-compare" to _pS(_uM("width" to 180, "height" to 100, "backgroundColor" to "#808080", "flexDirection" to "row")), "scroll-view-grow" to _pS(_uM("height" to 50, "justifyContent" to "center", "alignItems" to "center")), "native-view-grow" to _pS(_uM("height" to 50, "justifyContent" to "center", "alignItems" to "center")), "width-30-no-grow" to _pS(_uM("width" to 30, "flexGrow" to 0)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
