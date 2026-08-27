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
open class GenPagesCSSFlexFlex : BasePage {
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
    open var radioChangeFlex: (index: Number) -> Unit
        get() {
            return unref(this.`$exposed`["radioChangeFlex"]) as (index: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "radioChangeFlex", value)
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
        var setup: (__props: GenPagesCSSFlexFlex, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSFlexFlex
            val _cache = __ins.renderCache
            val flexEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "0"),
                ItemType(value = 2, name = "1"),
                ItemType(value = 3, name = "2"),
                ItemType(value = 4, name = "auto"),
                ItemType(value = 5, name = "none"),
                ItemType(value = 6, name = "1 1 auto")
            ) as UTSArray<ItemType>
            val data = reactive(_uO("flexProp" to "1", "flexActual" to "", "flexActualFlat" to "", "flexActualText" to "", "flexActualImage" to "", "flexActualTextFlat" to "", "flexActualImageFlat" to ""))
            val viewRef = ref(null as UniElement?)
            val viewRefFlat = ref(null as UniElement?)
            val textRef = ref(null as UniTextElement?)
            val imageRef = ref(null as UniImageElement?)
            val textRefFlat = ref(null as UniTextElement?)
            val imageRefFlat = ref(null as UniImageElement?)
            val getPropertyValues = fun(){
                data["flexActual"] = viewRef.value?.style?.getPropertyValue("flex") ?: ""
                data["flexActualFlat"] = viewRefFlat.value?.style?.getPropertyValue("flex") ?: ""
                data["flexActualText"] = textRef.value?.style?.getPropertyValue("flex") ?: ""
                data["flexActualTextFlat"] = textRefFlat.value?.style?.getPropertyValue("flex") ?: ""
                data["flexActualImage"] = imageRef.value?.style?.getPropertyValue("flex") ?: ""
                data["flexActualImageFlat"] = imageRefFlat.value?.style?.getPropertyValue("flex") ?: ""
            }
            val changeFlex = fun(value: String){
                data["flexProp"] = value
                viewRef.value?.style?.setProperty("flex", value)
                viewRefFlat.value?.style?.setProperty("flex", value)
                textRef.value?.style?.setProperty("flex", value)
                textRefFlat.value?.style?.setProperty("flex", value)
                imageRef.value?.style?.setProperty("flex", value)
                imageRefFlat.value?.style?.setProperty("flex", value)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangeFlex = fun(index: Number){
                val selectedItem = flexEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changeFlex(selectedItem.name)
                }
            }
            val inputChangeFlex = fun(value: String){
                changeFlex(value)
            }
            onReady(fun(){
                getPropertyValues()
            }
            )
            __expose(_uM("radioChangeFlex" to radioChangeFlex, "data" to data))
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1"))), _uA(
                        _cE("text", _uM("class" to "uni-tips"), "说明：左边是正常版本，右边是拍平版本"),
                        _cE("view", null, _uA(
                            _cE("text", null, "flex: 0"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "flex-container"), _uA(
                                    _cE("view", _uM("class" to "flex-item red", "style" to _nS(_uM("min-width" to "25px", "flex" to "0"))), null, 4),
                                    _cE("view", _uM("class" to "flex-item green")),
                                    _cE("view", _uM("class" to "flex-item blue"))
                                )),
                                _cE("view", _uM("class" to "flex-container"), _uA(
                                    _cE("view", _uM("class" to "flex-item red", "style" to _nS(_uM("min-width" to "25px", "flex" to "0")), "flatten" to ""), null, 4),
                                    _cE("view", _uM("class" to "flex-item green")),
                                    _cE("view", _uM("class" to "flex-item blue"))
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "flex: 1"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "flex-container"), _uA(
                                    _cE("view", _uM("class" to "flex-item red", "style" to _nS(_uM("flex" to "1"))), null, 4),
                                    _cE("view", _uM("class" to "flex-item green")),
                                    _cE("view", _uM("class" to "flex-item blue"))
                                )),
                                _cE("view", _uM("class" to "flex-container"), _uA(
                                    _cE("view", _uM("class" to "flex-item red", "style" to _nS(_uM("flex" to "1")), "flatten" to ""), null, 4),
                                    _cE("view", _uM("class" to "flex-item green")),
                                    _cE("view", _uM("class" to "flex-item blue"))
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "flex: auto"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "flex-container"), _uA(
                                    _cE("view", _uM("class" to "flex-item red", "style" to _nS(_uM("flex" to "auto"))), null, 4),
                                    _cE("view", _uM("class" to "flex-item green")),
                                    _cE("view", _uM("class" to "flex-item blue"))
                                )),
                                _cE("view", _uM("class" to "flex-container"), _uA(
                                    _cE("view", _uM("class" to "flex-item red", "style" to _nS(_uM("flex" to "auto")), "flatten" to ""), null, 4),
                                    _cE("view", _uM("class" to "flex-item green")),
                                    _cE("view", _uM("class" to "flex-item blue"))
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "flex: none"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "flex-container"), _uA(
                                    _cE("view", _uM("class" to "flex-item red", "style" to _nS(_uM("flex" to "none"))), null, 4),
                                    _cE("view", _uM("class" to "flex-item green")),
                                    _cE("view", _uM("class" to "flex-item blue"))
                                )),
                                _cE("view", _uM("class" to "flex-container"), _uA(
                                    _cE("view", _uM("class" to "flex-item red", "style" to _nS(_uM("flex" to "none")), "flatten" to ""), null, 4),
                                    _cE("view", _uM("class" to "flex-item green")),
                                    _cE("view", _uM("class" to "flex-item blue"))
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "scroll-view 组件 ")
                        )),
                        _cE("view", null, _uA(
                            _cE("text", _uM("class" to "uni-subtitle-text"), "scroll-view 作为 flex 子项"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "flex-container"), _uA(
                                    _cE("view", _uM("class" to "flex-item red")),
                                    _cE("scroll-view", _uM("class" to "flex-item green", "style" to _nS(_uM("flex" to "1")), "direction" to "horizontal"), _uA(
                                        _cE("text", _uM("class" to "scroll-view-label"), "flex: 1")
                                    ), 4),
                                    _cE("view", _uM("class" to "flex-item blue"))
                                )),
                                _cE("view", _uM("class" to "flex-container"), _uA(
                                    _cE("view", _uM("class" to "flex-item red")),
                                    _cE("scroll-view", _uM("class" to "flex-item green", "style" to _nS(_uM("flex" to "auto")), "direction" to "horizontal"), _uA(
                                        _cE("text", _uM("class" to "scroll-view-label"), "flex: auto")
                                    ), 4),
                                    _cE("view", _uM("class" to "flex-item blue"))
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 flex ")
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["flexProp"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["flexActual"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("class" to "test-flex-container"), _uA(
                                        _cE("view", _uM("class" to "common-dynamic", "style" to _nS(_uM("background-color" to "red"))), null, 4),
                                        _cE("view", _uM("ref_key" to "viewRef", "ref" to viewRef, "class" to "common-dynamic test-view", "style" to _nS(_uA(
                                            _uM("background-color" to "green"),
                                            _uM("flex" to unref(data)["flexProp"])
                                        ))), _uA(
                                            _cE("text", _uM("class" to "text-flex"), "view")
                                        ), 4),
                                        _cE("view", _uM("class" to "common-dynamic", "style" to _nS(_uM("background-color" to "blue"))), null, 4)
                                    ))
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["flexProp"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["flexActualText"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("class" to "test-flex-container"), _uA(
                                        _cE("text", _uM("class" to "common-dynamic text-flex", "style" to _nS(_uM("background-color" to "red"))), "红色", 4),
                                        _cE("text", _uM("ref_key" to "textRef", "ref" to textRef, "class" to "common-dynamic text-flex test-text", "style" to _nS(_uA(
                                            _uM("background-color" to "green"),
                                            _uM("flex" to unref(data)["flexProp"])
                                        ))), "text", 4),
                                        _cE("text", _uM("class" to "common-dynamic text-flex", "style" to _nS(_uM("background-color" to "blue"))), "蓝色", 4)
                                    ))
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["flexProp"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["flexActualImage"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("class" to "test-flex-container"), _uA(
                                        _cE("image", _uM("class" to "common-image", "style" to _nS(_uM("background-color" to "red")), "src" to "/static/test-image/logo.png"), null, 4),
                                        _cE("image", _uM("ref_key" to "imageRef", "ref" to imageRef, "class" to "common-image test-image", "style" to _nS(_uA(
                                            _uM("background-color" to "green"),
                                            _uM("flex" to unref(data)["flexProp"])
                                        )), "src" to "/static/test-image/logo.png"), null, 4),
                                        _cE("image", _uM("class" to "common-image", "style" to _nS(_uM("background-color" to "blue")), "src" to "/static/test-image/logo.png"), null, 4)
                                    ))
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["flexProp"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["flexActualFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("class" to "test-flex-container"), _uA(
                                        _cE("view", _uM("class" to "common-dynamic", "style" to _nS(_uM("background-color" to "red"))), null, 4),
                                        _cE("view", _uM("ref_key" to "viewRefFlat", "ref" to viewRefFlat, "class" to "common-dynamic test-view-flatten", "style" to _nS(_uA(
                                            _uM("background-color" to "green"),
                                            _uM("flex" to unref(data)["flexProp"])
                                        )), "flatten" to ""), _uA(
                                            _cE("text", _uM("class" to "text-flex"), "view")
                                        ), 4),
                                        _cE("view", _uM("class" to "common-dynamic", "style" to _nS(_uM("background-color" to "blue"))), null, 4)
                                    ))
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["flexProp"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["flexActualTextFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("class" to "test-flex-container"), _uA(
                                        _cE("text", _uM("class" to "common-dynamic text-flex", "style" to _nS(_uM("background-color" to "red"))), "红色", 4),
                                        _cE("text", _uM("ref_key" to "textRefFlat", "ref" to textRefFlat, "class" to "common-dynamic text-flex test-text-flatten", "style" to _nS(_uA(
                                            _uM("background-color" to "green"),
                                            _uM("flex" to unref(data)["flexProp"])
                                        )), "flatten" to ""), "text", 4),
                                        _cE("text", _uM("class" to "common-dynamic text-flex", "style" to _nS(_uM("background-color" to "blue"))), "蓝色", 4)
                                    ))
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["flexProp"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["flexActualImageFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("class" to "test-flex-container"), _uA(
                                        _cE("image", _uM("class" to "common-image", "style" to _nS(_uM("background-color" to "red")), "src" to "/static/test-image/logo.png"), null, 4),
                                        _cE("image", _uM("ref_key" to "imageRefFlat", "ref" to imageRefFlat, "class" to "common-image test-image-flatten", "style" to _nS(_uA(
                                            _uM("background-color" to "green"),
                                            _uM("flex" to unref(data)["flexProp"])
                                        )), "flatten" to "", "src" to "/static/test-image/logo.png"), null, 4),
                                        _cE("image", _uM("class" to "common-image", "style" to _nS(_uM("background-color" to "blue")), "src" to "/static/test-image/logo.png"), null, 4)
                                    ))
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                            _cV(_component_enum_data, _uM("items" to flexEnum, "title" to "flex 枚举值", "onChange" to radioChangeFlex, "compact" to true)),
                            _cV(_component_input_data, _uM("defaultValue" to unref(data)["flexProp"], "title" to "flex 自定义值", "type" to "text", "onConfirm" to inputChangeFlex), null, 8, _uA(
                                "defaultValue"
                            ))
                        )),
                        _cE("text", _uM("class" to "uni-title-text uni-common-mt"), "native-view 组件：flex: 1; 和 flex: auto;"),
                        _cE("text", _uM("class" to "uni-subtitle-text"), "native-view 作为 flex 子项"),
                        _cE("view", _uM("class" to "demo-box uni-common-mb"), _uA(
                            _cE("view", _uM("class" to "flex-container"), _uA(
                                _cE("view", _uM("class" to "flex-item red")),
                                _cE("native-view", _uM("class" to "flex-item green", "style" to _nS(_uM("flex" to "1"))), null, 4),
                                _cE("view", _uM("class" to "flex-item blue"))
                            )),
                            _cE("view", _uM("class" to "flex-container"), _uA(
                                _cE("view", _uM("class" to "flex-item red")),
                                _cE("native-view", _uM("class" to "flex-item green", "style" to _nS(_uM("flex" to "auto"))), null, 4),
                                _cE("view", _uM("class" to "flex-item blue"))
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
                return _uM("demo-box" to _pS(_uM("flexDirection" to "row", "marginTop" to 10, "justifyContent" to "space-around")), "flex-container" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 10, "marginBottom" to 0, "marginLeft" to 10, "height" to 100, "backgroundColor" to "#808080", "flexDirection" to "row")), "flex-item" to _pS(_uM("width" to 40, "height" to 40)), "green" to _pS(_uM("backgroundColor" to "#008000")), "blue" to _pS(_uM("backgroundColor" to "#0000FF")), "red" to _pS(_uM("backgroundColor" to "#FF0000")), "box" to _pS(_uM("height" to 50, "justifyContent" to "center", "alignItems" to "center")), "common-dynamic" to _pS(_uM("width" to 30, "height" to 30)), "common-image" to _pS(_uM("width" to 30, "height" to 30)), "text-flex" to _pS(_uM("fontSize" to 12, "color" to "#FFFFFF")), "test-container" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "marginTop" to 10)), "test-item" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 5, "marginBottom" to 0, "marginLeft" to 5)), "test-box" to _pS(_uM("width" to "100%", "height" to 50, "backgroundColor" to "#808080")), "test-flex-container" to _pS(_uM("width" to "100%", "height" to "100%", "flexDirection" to "row")), "scroll-view-label" to _pS(_uM("fontSize" to 12, "lineHeight" to "40px", "textAlign" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
