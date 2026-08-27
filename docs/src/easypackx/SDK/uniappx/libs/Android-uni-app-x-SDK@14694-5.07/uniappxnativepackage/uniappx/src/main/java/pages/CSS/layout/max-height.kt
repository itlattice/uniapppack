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
open class GenPagesCSSLayoutMaxHeight : BasePage {
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
    open var radioChangeMaxHeight: (index: Number) -> Unit
        get() {
            return unref(this.`$exposed`["radioChangeMaxHeight"]) as (index: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "radioChangeMaxHeight", value)
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
        var setup: (__props: GenPagesCSSLayoutMaxHeight, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSLayoutMaxHeight
            val _cache = __ins.renderCache
            val maxHeightEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "0"),
                ItemType(value = 2, name = "0px"),
                ItemType(value = 3, name = "100px"),
                ItemType(value = 4, name = "150px"),
                ItemType(value = 5, name = "80rpx"),
                ItemType(value = 6, name = "none")
            ) as UTSArray<ItemType>
            val data = reactive(_uO("maxHeight" to "50px", "maxHeightActual" to "", "maxHeightActualText" to "", "maxHeightActualImage" to "", "maxHeightActualFlat" to "", "maxHeightActualTextFlat" to "", "maxHeightActualImageFlat" to ""))
            val viewRef = ref(null as UniElement?)
            val textRef = ref(null as UniTextElement?)
            val imageRef = ref(null as UniImageElement?)
            val viewRefFlat = ref(null as UniElement?)
            val textRefFlat = ref(null as UniTextElement?)
            val imageRefFlat = ref(null as UniImageElement?)
            val getPropertyValues = fun(){
                data["maxHeightActual"] = viewRef.value?.style?.getPropertyValue("max-height") ?: ""
                data["maxHeightActualFlat"] = viewRefFlat.value?.style?.getPropertyValue("max-height") ?: ""
                data["maxHeightActualText"] = textRef.value?.style?.getPropertyValue("max-height") ?: ""
                data["maxHeightActualTextFlat"] = textRefFlat.value?.style?.getPropertyValue("max-height") ?: ""
                data["maxHeightActualImage"] = imageRef.value?.style?.getPropertyValue("max-height") ?: ""
                data["maxHeightActualImageFlat"] = imageRefFlat.value?.style?.getPropertyValue("max-height") ?: ""
            }
            val changeMaxHeight = fun(value: String){
                data["maxHeight"] = value
                viewRef.value?.style?.setProperty("max-height", value)
                viewRefFlat.value?.style?.setProperty("max-height", value)
                textRef.value?.style?.setProperty("max-height", value)
                textRefFlat.value?.style?.setProperty("max-height", value)
                imageRef.value?.style?.setProperty("max-height", value)
                imageRefFlat.value?.style?.setProperty("max-height", value)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangeMaxHeight = fun(index: Number){
                val selectedItem = maxHeightEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changeMaxHeight(selectedItem.name)
                }
            }
            val inputChangeMaxHeight = fun(value: String){
                changeMaxHeight(value)
            }
            onReady(fun(){
                getPropertyValues()
            }
            )
            __expose(_uM("radioChangeMaxHeight" to radioChangeMaxHeight, "data" to data))
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1"))), _uA(
                        _cE("view", null, _uA(
                            _cE("text", null, "max-height: 100px"),
                            _cE("view", _uM("class" to "common", "style" to _nS(_uM("max-height" to "100px"))), _uA(
                                _cE("text", null, "height: 400px")
                            ), 4),
                            _cE("text", null, "拍平"),
                            _cE("view", _uM("class" to "common", "style" to _nS(_uM("max-height" to "100px")), "flatten" to ""), _uA(
                                _cE("text", null, "height: 400px")
                            ), 4)
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "scroll-view 组件")
                        )),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("scroll-view", _uM("class" to "common", "style" to _nS(_uM("max-height" to "80px", "background-color" to "cyan", "width" to "100px"))), _uA(
                                _cE("text", _uM("class" to "scroll-view-label"), "max-height: 80px")
                            ), 4),
                            _cE("scroll-view", _uM("class" to "common", "style" to _nS(_uM("max-height" to "120px", "background-color" to "cyan", "width" to "100px"))), _uA(
                                _cE("text", _uM("class" to "scroll-view-label"), "max-height: 120px")
                            ), 4)
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 max-height ")
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["maxHeight"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["maxHeightActual"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("ref_key" to "viewRef", "ref" to viewRef, "class" to "common-dynamic test-view", "style" to _nS(_uM("maxHeight" to unref(data)["maxHeight"]))), _uA(
                                        _cE("text", _uM("style" to _nS(_uM("font-size" to "12px"))), "view", 4)
                                    ), 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["maxHeight"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["maxHeightActualText"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRef", "ref" to textRef, "class" to "common-dynamic test-text", "style" to _nS(_uM("maxHeight" to unref(data)["maxHeight"]))), "text", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["maxHeight"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["maxHeightActualImage"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("ref_key" to "imageRef", "ref" to imageRef, "class" to "common-dynamic test-image", "style" to _nS(_uM("maxHeight" to unref(data)["maxHeight"])), "src" to "/static/test-image/logo.png"), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["maxHeight"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["maxHeightActualFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("ref_key" to "viewRefFlat", "ref" to viewRefFlat, "class" to "common-dynamic test-view-flatten", "style" to _nS(_uM("maxHeight" to unref(data)["maxHeight"])), "flatten" to ""), _uA(
                                        _cE("text", _uM("style" to _nS(_uM("font-size" to "12px"))), "view", 4)
                                    ), 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["maxHeight"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["maxHeightActualTextFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRefFlat", "ref" to textRefFlat, "class" to "common-dynamic test-text-flatten", "style" to _nS(_uM("maxHeight" to unref(data)["maxHeight"])), "flatten" to ""), "text", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["maxHeight"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["maxHeightActualImageFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("ref_key" to "imageRefFlat", "ref" to imageRefFlat, "class" to "common-dynamic test-image-flatten", "style" to _nS(_uM("maxHeight" to unref(data)["maxHeight"])), "flatten" to "", "src" to "/static/test-image/logo.png"), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                            _cV(_component_enum_data, _uM("items" to maxHeightEnum, "title" to "max-height 枚举值", "onChange" to radioChangeMaxHeight, "compact" to true)),
                            _cV(_component_input_data, _uM("defaultValue" to unref(data)["maxHeight"], "title" to "max-height 自定义值", "type" to "text", "onConfirm" to inputChangeMaxHeight), null, 8, _uA(
                                "defaultValue"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mb"), _uA(
                            _cE("text", null, "native-view组件: max-height: 80px 和 max-height: 120px"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("native-view", _uM("class" to "common", "style" to _nS(_uM("max-height" to "80px", "background-color" to "cyan", "width" to "100px"))), null, 4),
                                _cE("native-view", _uM("class" to "common", "style" to _nS(_uM("max-height" to "120px", "background-color" to "cyan", "width" to "100px"))), null, 4)
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
                return _uM("common" to _pS(_uM("width" to 200, "height" to 400, "backgroundColor" to "#00FFFF", "justifyContent" to "center", "alignItems" to "center")), "common-dynamic" to _pS(_uM("width" to 100, "height" to 150, "backgroundColor" to "#00FFFF")), "test-container" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "marginTop" to 10)), "test-item" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 5, "marginBottom" to 0, "marginLeft" to 5)), "test-box" to _pS(_uM("width" to "100%", "height" to 150, "backgroundColor" to "#808080")), "demo-box" to _pS(_uM("flexDirection" to "row", "marginTop" to 10, "justifyContent" to "space-around")), "scroll-view-label" to _pS(_uM("fontSize" to 12, "textAlign" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
