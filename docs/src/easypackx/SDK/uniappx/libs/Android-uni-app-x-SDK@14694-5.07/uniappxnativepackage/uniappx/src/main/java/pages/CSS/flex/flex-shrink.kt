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
open class GenPagesCSSFlexFlexShrink : BasePage {
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
    open var radioChangeFlexShrink: (index: Number) -> Unit
        get() {
            return unref(this.`$exposed`["radioChangeFlexShrink"]) as (index: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "radioChangeFlexShrink", value)
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
        var setup: (__props: GenPagesCSSFlexFlexShrink, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSFlexFlexShrink
            val _cache = __ins.renderCache
            val flexShrinkEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "0"),
                ItemType(value = 2, name = "1"),
                ItemType(value = 3, name = "2"),
                ItemType(value = 4, name = "3")
            ) as UTSArray<ItemType>
            val data = reactive(_uO("flexShrink" to "1", "flexShrinkActual" to "", "flexShrinkActualFlat" to "", "flexShrinkActualText" to "", "flexShrinkActualImage" to "", "flexShrinkActualTextFlat" to "", "flexShrinkActualImageFlat" to ""))
            val viewRef = ref(null as UniElement?)
            val viewRefFlat = ref(null as UniElement?)
            val textRef = ref(null as UniTextElement?)
            val imageRef = ref(null as UniImageElement?)
            val textRefFlat = ref(null as UniTextElement?)
            val imageRefFlat = ref(null as UniImageElement?)
            val getPropertyValues = fun(){
                data["flexShrinkActual"] = viewRef.value?.style?.getPropertyValue("flex-shrink") ?: ""
                data["flexShrinkActualFlat"] = viewRefFlat.value?.style?.getPropertyValue("flex-shrink") ?: ""
                data["flexShrinkActualText"] = textRef.value?.style?.getPropertyValue("flex-shrink") ?: ""
                data["flexShrinkActualTextFlat"] = textRefFlat.value?.style?.getPropertyValue("flex-shrink") ?: ""
                data["flexShrinkActualImage"] = imageRef.value?.style?.getPropertyValue("flex-shrink") ?: ""
                data["flexShrinkActualImageFlat"] = imageRefFlat.value?.style?.getPropertyValue("flex-shrink") ?: ""
            }
            val changeFlexShrink = fun(value: String){
                data["flexShrink"] = value
                viewRef.value?.style?.setProperty("flex-shrink", value)
                viewRefFlat.value?.style?.setProperty("flex-shrink", value)
                textRef.value?.style?.setProperty("flex-shrink", value)
                textRefFlat.value?.style?.setProperty("flex-shrink", value)
                imageRef.value?.style?.setProperty("flex-shrink", value)
                imageRefFlat.value?.style?.setProperty("flex-shrink", value)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangeFlexShrink = fun(index: Number){
                val selectedItem = flexShrinkEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changeFlexShrink(selectedItem.name)
                }
            }
            val inputChangeFlexShrink = fun(value: String){
                changeFlexShrink(value)
            }
            onReady(fun(){
                getPropertyValues()
            }
            )
            __expose(_uM("radioChangeFlexShrink" to radioChangeFlexShrink, "data" to data))
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1"))), _uA(
                        _cE("text", _uM("class" to "uni-tips"), "说明：左边是正常版本，右边是拍平版本"),
                        _cE("view", null, _uA(
                            _cE("text", null, "flex-shrink"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "flex-container"), _uA(
                                    _cE("view", _uM("class" to "common red", "style" to _nS(_uM("flex-shrink" to "1"))), _uA(
                                        _cE("text", null, "1")
                                    ), 4),
                                    _cE("view", _uM("class" to "common green", "style" to _nS(_uM("flex-shrink" to "2"))), _uA(
                                        _cE("text", null, "2")
                                    ), 4),
                                    _cE("view", _uM("class" to "common blue", "style" to _nS(_uM("flex-shrink" to "3"))), _uA(
                                        _cE("text", null, "3")
                                    ), 4)
                                )),
                                _cE("view", _uM("class" to "flex-container"), _uA(
                                    _cE("view", _uM("class" to "common red", "style" to _nS(_uM("flex-shrink" to "1")), "flatten" to ""), _uA(
                                        _cE("text", null, "1")
                                    ), 4),
                                    _cE("view", _uM("class" to "common green", "style" to _nS(_uM("flex-shrink" to "2")), "flatten" to ""), _uA(
                                        _cE("text", null, "2")
                                    ), 4),
                                    _cE("view", _uM("class" to "common blue", "style" to _nS(_uM("flex-shrink" to "3")), "flatten" to ""), _uA(
                                        _cE("text", null, "3")
                                    ), 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "scroll-view 组件：flex-shrink: 1 、2、3")
                        )),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("view", _uM("class" to "flex-container-shrink"), _uA(
                                _cE("scroll-view", _uM("class" to "scroll-view-shrink red", "style" to _nS(_uM("width" to "100px", "flex-shrink" to "1"))), _uA(
                                    _cE("text", _uM("class" to "scroll-view-label"), "flex-shrink: 1")
                                ), 4),
                                _cE("scroll-view", _uM("class" to "scroll-view-shrink green", "style" to _nS(_uM("width" to "100px", "flex-shrink" to "2"))), _uA(
                                    _cE("text", _uM("class" to "scroll-view-label"), "flex-shrink: 2")
                                ), 4),
                                _cE("scroll-view", _uM("class" to "scroll-view-shrink blue", "style" to _nS(_uM("width" to "100px", "flex-shrink" to "3"))), _uA(
                                    _cE("text", _uM("class" to "scroll-view-label"), "flex-shrink: 3")
                                ), 4)
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 flex-shrink ")
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["flexShrink"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["flexShrinkActual"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("class" to "test-flex-container"), _uA(
                                        _cE("view", _uM("class" to "common-image red", "style" to _nS(_uM("flex-shrink" to "1"))), null, 4),
                                        _cE("view", _uM("ref_key" to "viewRef", "ref" to viewRef, "class" to "common-image green test-view", "style" to _nS(_uM("flexShrink" to unref(data)["flexShrink"]))), _uA(
                                            _cE("text", _uM("class" to "test-label"), _tD(unref(data)["flexShrink"]), 1)
                                        ), 4),
                                        _cE("view", _uM("class" to "common-image blue", "style" to _nS(_uM("flex-shrink" to "1"))), null, 4)
                                    ))
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["flexShrink"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["flexShrinkActualText"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("class" to "test-flex-container"), _uA(
                                        _cE("text", _uM("class" to "common-text red", "style" to _nS(_uM("flex-shrink" to "1"))), "红色", 4),
                                        _cE("text", _uM("ref_key" to "textRef", "ref" to textRef, "class" to "common-text green test-text", "style" to _nS(_uM("flexShrink" to unref(data)["flexShrink"]))), "text", 4),
                                        _cE("text", _uM("class" to "common-text blue", "style" to _nS(_uM("flex-shrink" to "1"))), "蓝色", 4)
                                    ))
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["flexShrink"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["flexShrinkActualImage"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("class" to "test-flex-container"), _uA(
                                        _cE("image", _uM("class" to "common-image red", "style" to _nS(_uM("flex-shrink" to "1")), "src" to "/static/test-image/logo.png"), null, 4),
                                        _cE("image", _uM("ref_key" to "imageRef", "ref" to imageRef, "class" to "common-image green test-image", "style" to _nS(_uM("flexShrink" to unref(data)["flexShrink"])), "src" to "/static/test-image/logo.png"), null, 4),
                                        _cE("image", _uM("class" to "common-image blue", "style" to _nS(_uM("flex-shrink" to "1")), "src" to "/static/test-image/logo.png"), null, 4)
                                    ))
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["flexShrink"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["flexShrinkActualFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("class" to "test-flex-container"), _uA(
                                        _cE("view", _uM("class" to "common-image red", "style" to _nS(_uM("flex-shrink" to "1"))), null, 4),
                                        _cE("view", _uM("ref_key" to "viewRefFlat", "ref" to viewRefFlat, "class" to "common-image green test-view-flatten", "style" to _nS(_uM("flexShrink" to unref(data)["flexShrink"])), "flatten" to ""), _uA(
                                            _cE("text", _uM("class" to "test-label"), _tD(unref(data)["flexShrink"]), 1)
                                        ), 4),
                                        _cE("view", _uM("class" to "common-image blue", "style" to _nS(_uM("flex-shrink" to "1"))), null, 4)
                                    ))
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["flexShrink"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["flexShrinkActualTextFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("class" to "test-flex-container"), _uA(
                                        _cE("text", _uM("class" to "common-text red", "style" to _nS(_uM("flex-shrink" to "1"))), "红色", 4),
                                        _cE("text", _uM("ref_key" to "textRefFlat", "ref" to textRefFlat, "class" to "common-text green test-text-flatten", "style" to _nS(_uM("flexShrink" to unref(data)["flexShrink"])), "flatten" to ""), "text", 4),
                                        _cE("text", _uM("class" to "common-text blue", "style" to _nS(_uM("flex-shrink" to "1"))), "蓝色", 4)
                                    ))
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["flexShrink"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["flexShrinkActualImageFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("class" to "test-flex-container"), _uA(
                                        _cE("image", _uM("class" to "common-image red", "style" to _nS(_uM("flex-shrink" to "1")), "src" to "/static/test-image/logo.png"), null, 4),
                                        _cE("image", _uM("ref_key" to "imageRefFlat", "ref" to imageRefFlat, "class" to "common-image green test-image-flatten", "style" to _nS(_uM("flexShrink" to unref(data)["flexShrink"])), "flatten" to "", "src" to "/static/test-image/logo.png"), null, 4),
                                        _cE("image", _uM("class" to "common-image blue", "style" to _nS(_uM("flex-shrink" to "1")), "src" to "/static/test-image/logo.png"), null, 4)
                                    ))
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                            _cV(_component_enum_data, _uM("items" to flexShrinkEnum, "title" to "flex-shrink 枚举值", "onChange" to radioChangeFlexShrink, "compact" to true)),
                            _cV(_component_input_data, _uM("defaultValue" to unref(data)["flexShrink"], "title" to "flex-shrink 自定义值", "type" to "text", "onConfirm" to inputChangeFlexShrink), null, 8, _uA(
                                "defaultValue"
                            ))
                        )),
                        _cE("text", _uM("class" to "uni-title-text uni-common-mt"), "native-view 组件：flex-shrink: 1 、2、3"),
                        _cE("view", _uM("class" to "demo-box uni-common-mb"), _uA(
                            _cE("view", _uM("class" to "flex-container-shrink"), _uA(
                                _cE("native-view", _uM("class" to "native-view-shrink red", "style" to _nS(_uM("width" to "100px", "flex-shrink" to "1"))), null, 4),
                                _cE("native-view", _uM("class" to "native-view-shrink green", "style" to _nS(_uM("width" to "100px", "flex-shrink" to "2"))), null, 4),
                                _cE("native-view", _uM("class" to "native-view-shrink blue", "style" to _nS(_uM("width" to "100px", "flex-shrink" to "3"))), null, 4)
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
                return _uM("demo-box" to _pS(_uM("flexDirection" to "row", "marginTop" to 10, "justifyContent" to "space-around")), "flex-container" to _pS(_uM("width" to 200, "marginTop" to 0, "marginRight" to 10, "marginBottom" to 0, "marginLeft" to 10, "height" to 100, "backgroundColor" to "#808080", "flexDirection" to "row")), "common" to _pS(_uM("width" to 100, "height" to 50, "justifyContent" to "center", "alignItems" to "center")), "common-text" to _pS(_uM("width" to 60, "height" to 30, "backgroundColor" to "#008000", "fontSize" to 12, "color" to "#FFFFFF")), "common-image" to _pS(_uM("width" to 60, "height" to 30, "backgroundColor" to "#008000")), "test-container" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "marginTop" to 10)), "test-item" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 5, "marginBottom" to 0, "marginLeft" to 5)), "test-box" to _pS(_uM("width" to "100%", "height" to 50, "backgroundColor" to "#808080")), "test-flex-container" to _pS(_uM("width" to 135, "height" to "100%", "flexDirection" to "row")), "red" to _pS(_uM("backgroundColor" to "#FF0000")), "blue" to _pS(_uM("backgroundColor" to "#0000FF")), "green" to _pS(_uM("backgroundColor" to "#008000")), "test-label" to _pS(_uM("fontSize" to 12, "color" to "#FFFFFF")), "scroll-view-label" to _pS(_uM("fontSize" to 12, "textAlign" to "center")), "flex-container-shrink" to _pS(_uM("width" to 200, "height" to 100, "backgroundColor" to "#808080", "flexDirection" to "row", "marginTop" to 10, "marginRight" to 10, "marginBottom" to 10, "marginLeft" to 10)), "scroll-view-shrink" to _pS(_uM("height" to 50, "justifyContent" to "center", "alignItems" to "center")), "native-view-shrink" to _pS(_uM("height" to 50, "justifyContent" to "center", "alignItems" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
