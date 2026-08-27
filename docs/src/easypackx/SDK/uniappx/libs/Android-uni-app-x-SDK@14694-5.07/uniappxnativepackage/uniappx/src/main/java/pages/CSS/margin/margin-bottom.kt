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
open class GenPagesCSSMarginMarginBottom : BasePage {
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
    open var radioChangeMarginBottom: (index: Number) -> Unit
        get() {
            return unref(this.`$exposed`["radioChangeMarginBottom"]) as (index: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "radioChangeMarginBottom", value)
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
        var setup: (__props: GenPagesCSSMarginMarginBottom, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSMarginMarginBottom
            val _cache = __ins.renderCache
            val data = reactive(_uO("marginBottom" to "25px", "marginBottomActual" to "", "marginBottomActualText" to "", "marginBottomActualImage" to "", "marginBottomActualFlat" to "", "marginBottomActualTextFlat" to "", "marginBottomActualImageFlat" to ""))
            val viewRef = ref(null as UniElement?)
            val textRef = ref(null as UniTextElement?)
            val imageRef = ref(null as UniImageElement?)
            val viewRefFlat = ref(null as UniElement?)
            val textRefFlat = ref(null as UniTextElement?)
            val imageRefFlat = ref(null as UniImageElement?)
            val marginBottomEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "0"),
                ItemType(value = 2, name = "0px"),
                ItemType(value = 3, name = "20px"),
                ItemType(value = 4, name = "0%"),
                ItemType(value = 5, name = "10%"),
                ItemType(value = 6, name = "auto")
            ) as UTSArray<ItemType>
            val getPropertyValues = fun(){
                data["marginBottomActual"] = viewRef.value?.style?.getPropertyValue("margin-bottom") ?: ""
                data["marginBottomActualFlat"] = viewRefFlat.value?.style?.getPropertyValue("margin-bottom") ?: ""
                data["marginBottomActualText"] = textRef.value?.style?.getPropertyValue("margin-bottom") ?: ""
                data["marginBottomActualTextFlat"] = textRefFlat.value?.style?.getPropertyValue("margin-bottom") ?: ""
                data["marginBottomActualImage"] = imageRef.value?.style?.getPropertyValue("margin-bottom") ?: ""
                data["marginBottomActualImageFlat"] = imageRefFlat.value?.style?.getPropertyValue("margin-bottom") ?: ""
            }
            val changeMarginBottom = fun(value: String){
                data["marginBottom"] = value
                viewRef.value?.style?.setProperty("margin-bottom", value)
                viewRefFlat.value?.style?.setProperty("margin-bottom", value)
                textRef.value?.style?.setProperty("margin-bottom", value)
                textRefFlat.value?.style?.setProperty("margin-bottom", value)
                imageRef.value?.style?.setProperty("margin-bottom", value)
                imageRefFlat.value?.style?.setProperty("margin-bottom", value)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangeMarginBottom = fun(index: Number){
                val selectedItem = marginBottomEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changeMarginBottom(selectedItem.name)
                }
            }
            val inputChangeMarginBottom = fun(value: String){
                changeMarginBottom(value)
            }
            onReady(fun(){
                getPropertyValues()
            }
            )
            __expose(_uM("radioChangeMarginBottom" to radioChangeMarginBottom, "data" to data))
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1"))), _uA(
                        _cE("text", _uM("class" to "uni-tips"), "说明：左边是正常版本，右边是拍平版本"),
                        _cE("view", null, _uA(
                            _cE("text", null, "margin-bottom: 25px"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "demo-container"), _uA(
                                    _cE("view", _uM("class" to "common red")),
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("margin-bottom" to "25px"))), null, 4),
                                    _cE("view", _uM("class" to "common blue"))
                                )),
                                _cE("view", _uM("class" to "demo-container"), _uA(
                                    _cE("view", _uM("class" to "common red")),
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("margin-bottom" to "25px")), "flatten" to ""), null, 4),
                                    _cE("view", _uM("class" to "common blue"))
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "margin-bottom: 10%"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "demo-container"), _uA(
                                    _cE("view", _uM("class" to "common red")),
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("margin-bottom" to "10%"))), null, 4),
                                    _cE("view", _uM("class" to "common blue"))
                                )),
                                _cE("view", _uM("class" to "demo-container"), _uA(
                                    _cE("view", _uM("class" to "common red")),
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("margin-bottom" to "10%")), "flatten" to ""), null, 4),
                                    _cE("view", _uM("class" to "common blue"))
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "scroll-view 组件")
                        )),
                        _cE("view", null, _uA(
                            _cE("text", _uM("class" to "uni-subtitle-text"), "margin-bottom: 10% 和 margin-bottom: 30px"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "demo-container"), _uA(
                                    _cE("view", _uM("class" to "common red")),
                                    _cE("scroll-view", _uM("class" to "common", "style" to _nS(_uM("margin-bottom" to "10%"))), null, 4),
                                    _cE("view", _uM("class" to "common blue"))
                                )),
                                _cE("view", _uM("class" to "demo-container"), _uA(
                                    _cE("view", _uM("class" to "common red")),
                                    _cE("scroll-view", _uM("class" to "common", "style" to _nS(_uM("margin-bottom" to "30px"))), null, 4),
                                    _cE("view", _uM("class" to "common blue"))
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 margin-bottom ")
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["marginBottom"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["marginBottomActual"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("class" to "common-view", "style" to _nS(_uM("background-color" to "red"))), null, 4),
                                    _cE("view", _uM("ref_key" to "viewRef", "ref" to viewRef, "class" to "common-view test-view", "style" to _nS(_uM("marginBottom" to unref(data)["marginBottom"]))), _uA(
                                        _cE("text", _uM("class" to "common-text"), "view")
                                    ), 4),
                                    _cE("view", _uM("class" to "common-view", "style" to _nS(_uM("background-color" to "blue"))), null, 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["marginBottom"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["marginBottomActualText"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("class" to "common-view common-text", "style" to _nS(_uM("background-color" to "red"))), "红色", 4),
                                    _cE("text", _uM("ref_key" to "textRef", "ref" to textRef, "class" to "common-view common-text test-text", "style" to _nS(_uM("marginBottom" to unref(data)["marginBottom"]))), "text", 4),
                                    _cE("text", _uM("class" to "common-view common-text", "style" to _nS(_uM("background-color" to "blue"))), "蓝色", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["marginBottom"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["marginBottomActualImage"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("class" to "common-image", "style" to _nS(_uM("background-color" to "red")), "src" to "/static/test-image/logo.png"), null, 4),
                                    _cE("image", _uM("ref_key" to "imageRef", "ref" to imageRef, "class" to "common-image test-image", "style" to _nS(_uM("marginBottom" to unref(data)["marginBottom"])), "src" to "/static/test-image/logo.png"), null, 4),
                                    _cE("image", _uM("class" to "common-image", "style" to _nS(_uM("background-color" to "blue")), "src" to "/static/test-image/logo.png"), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["marginBottom"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["marginBottomActualFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("class" to "common-view", "style" to _nS(_uM("background-color" to "red"))), null, 4),
                                    _cE("view", _uM("ref_key" to "viewRefFlat", "ref" to viewRefFlat, "class" to "common-view test-view-flatten", "style" to _nS(_uM("marginBottom" to unref(data)["marginBottom"])), "flatten" to ""), _uA(
                                        _cE("text", _uM("class" to "common-text"), "view")
                                    ), 4),
                                    _cE("view", _uM("class" to "common-view", "style" to _nS(_uM("background-color" to "blue"))), null, 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["marginBottom"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["marginBottomActualTextFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("class" to "common-view common-text", "style" to _nS(_uM("background-color" to "red"))), "红色", 4),
                                    _cE("text", _uM("ref_key" to "textRefFlat", "ref" to textRefFlat, "class" to "common-view common-text test-text-flatten", "style" to _nS(_uM("marginBottom" to unref(data)["marginBottom"])), "flatten" to ""), "text", 4),
                                    _cE("text", _uM("class" to "common-view common-text", "style" to _nS(_uM("background-color" to "blue"))), "蓝色", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["marginBottom"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["marginBottomActualImageFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("class" to "common-image", "style" to _nS(_uM("background-color" to "red")), "src" to "/static/test-image/logo.png"), null, 4),
                                    _cE("image", _uM("ref_key" to "imageRefFlat", "ref" to imageRefFlat, "class" to "common-image test-image-flatten", "style" to _nS(_uM("marginBottom" to unref(data)["marginBottom"])), "flatten" to "", "src" to "/static/test-image/logo.png"), null, 4),
                                    _cE("image", _uM("class" to "common-image", "style" to _nS(_uM("background-color" to "blue")), "src" to "/static/test-image/logo.png"), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                            _cV(_component_enum_data, _uM("items" to marginBottomEnum, "title" to "margin-bottom 枚举值", "onChange" to radioChangeMarginBottom, "compact" to true)),
                            _cV(_component_input_data, _uM("defaultValue" to unref(data)["marginBottom"], "title" to "margin-bottom 自定义值", "type" to "text", "onConfirm" to inputChangeMarginBottom), null, 8, _uA(
                                "defaultValue"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mb"), _uA(
                            _cE("text", null, "native-view组件: margin-bottom: 25px 和 10%"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "demo-container"), _uA(
                                    _cE("view", _uM("class" to "common red")),
                                    _cE("native-view", _uM("class" to "common", "style" to _nS(_uM("margin-bottom" to "25px"))), null, 4),
                                    _cE("view", _uM("class" to "common blue"))
                                )),
                                _cE("view", _uM("class" to "demo-container"), _uA(
                                    _cE("view", _uM("class" to "common red")),
                                    _cE("native-view", _uM("class" to "common", "style" to _nS(_uM("margin-bottom" to "10%"))), null, 4),
                                    _cE("view", _uM("class" to "common blue"))
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
                return _uM("demo-container" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 10, "marginBottom" to 0, "marginLeft" to 10, "height" to 220, "backgroundColor" to "#808080")), "demo-box" to _pS(_uM("flexDirection" to "row", "marginTop" to 10, "justifyContent" to "space-around")), "common" to _pS(_uM("height" to 50, "backgroundColor" to "#008000")), "red" to _pS(_uM("backgroundColor" to "#FF0000")), "blue" to _pS(_uM("backgroundColor" to "#0000FF")), "green" to _pS(_uM("backgroundColor" to "#008000")), "scroll-view-test" to _pS(_uM("height" to 50)), "common-view" to _pS(_uM("height" to 30, "backgroundColor" to "#008000")), "common-text" to _pS(_uM("fontSize" to 12, "color" to "#FFFFFF")), "common-image" to _pS(_uM("width" to 30, "height" to 30, "backgroundColor" to "#008000")), "test-container" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "marginTop" to 10)), "test-item" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 5, "marginBottom" to 0, "marginLeft" to 5)), "test-box" to _pS(_uM("width" to "100%", "height" to 140, "backgroundColor" to "#808080")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
