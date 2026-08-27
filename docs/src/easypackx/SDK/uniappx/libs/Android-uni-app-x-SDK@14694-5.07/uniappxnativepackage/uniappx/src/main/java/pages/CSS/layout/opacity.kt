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
open class GenPagesCSSLayoutOpacity : BasePage {
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
    open var radioChangeOpacity: (index: Number) -> Unit
        get() {
            return unref(this.`$exposed`["radioChangeOpacity"]) as (index: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "radioChangeOpacity", value)
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
        var setup: (__props: GenPagesCSSLayoutOpacity, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSLayoutOpacity
            val _cache = __ins.renderCache
            val opacityEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "0"),
                ItemType(value = 2, name = "0.2"),
                ItemType(value = 3, name = "0.5"),
                ItemType(value = 4, name = "0.8"),
                ItemType(value = 5, name = "1")
            ) as UTSArray<ItemType>
            val data = reactive(_uO("opacity" to "1", "opacityActual" to "", "opacityActualText" to "", "opacityActualImage" to "", "opacityActualFlat" to "", "opacityActualTextFlat" to "", "opacityActualImageFlat" to ""))
            val viewRef = ref(null as UniElement?)
            val textRef = ref(null as UniTextElement?)
            val imageRef = ref(null as UniImageElement?)
            val viewRefFlat = ref(null as UniElement?)
            val textRefFlat = ref(null as UniTextElement?)
            val imageRefFlat = ref(null as UniImageElement?)
            val getPropertyValues = fun(){
                data["opacityActual"] = viewRef.value?.style?.getPropertyValue("opacity") ?: ""
                data["opacityActualFlat"] = viewRefFlat.value?.style?.getPropertyValue("opacity") ?: ""
                data["opacityActualText"] = textRef.value?.style?.getPropertyValue("opacity") ?: ""
                data["opacityActualTextFlat"] = textRefFlat.value?.style?.getPropertyValue("opacity") ?: ""
                data["opacityActualImage"] = imageRef.value?.style?.getPropertyValue("opacity") ?: ""
                data["opacityActualImageFlat"] = imageRefFlat.value?.style?.getPropertyValue("opacity") ?: ""
            }
            val changeOpacity = fun(value: String){
                data["opacity"] = value
                viewRef.value?.style?.setProperty("opacity", value)
                viewRefFlat.value?.style?.setProperty("opacity", value)
                textRef.value?.style?.setProperty("opacity", value)
                textRefFlat.value?.style?.setProperty("opacity", value)
                imageRef.value?.style?.setProperty("opacity", value)
                imageRefFlat.value?.style?.setProperty("opacity", value)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangeOpacity = fun(index: Number){
                val selectedItem = opacityEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changeOpacity(selectedItem.name)
                }
            }
            val inputChangeOpacity = fun(value: String){
                changeOpacity(value)
            }
            onReady(fun(){
                getPropertyValues()
            }
            )
            __expose(_uM("radioChangeOpacity" to radioChangeOpacity, "data" to data))
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1"))), _uA(
                        _cE("view", _uM("class" to "demo-row"), _uA(
                            _cE("view", _uM("class" to "demo-item"), _uA(
                                _cE("text", null, "opacity: 1 (默认值)"),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("opacity" to "1"))), null, 4)
                            )),
                            _cE("view", _uM("class" to "demo-item"), _uA(
                                _cE("text", null, "拍平"),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("opacity" to "1")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", _uM("class" to "demo-row uni-common-mt"), _uA(
                            _cE("view", _uM("class" to "demo-item"), _uA(
                                _cE("text", null, "opacity: 0.8"),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("opacity" to "0.8"))), null, 4)
                            )),
                            _cE("view", _uM("class" to "demo-item"), _uA(
                                _cE("text", null, "拍平"),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("opacity" to "0.8")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", _uM("class" to "demo-row uni-common-mt"), _uA(
                            _cE("view", _uM("class" to "demo-item"), _uA(
                                _cE("text", null, "opacity: 0.5"),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("opacity" to "0.5"))), null, 4)
                            )),
                            _cE("view", _uM("class" to "demo-item"), _uA(
                                _cE("text", null, "拍平"),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("opacity" to "0.5")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", _uM("class" to "demo-row uni-common-mt"), _uA(
                            _cE("view", _uM("class" to "demo-item"), _uA(
                                _cE("text", null, "opacity: 0.2"),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("opacity" to "0.2"))), null, 4)
                            )),
                            _cE("view", _uM("class" to "demo-item"), _uA(
                                _cE("text", null, "拍平"),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("opacity" to "0.2")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", _uM("class" to "demo-row uni-common-mt"), _uA(
                            _cE("view", _uM("class" to "demo-item"), _uA(
                                _cE("text", null, "opacity: 0"),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("opacity" to "0"))), null, 4)
                            )),
                            _cE("view", _uM("class" to "demo-item"), _uA(
                                _cE("text", null, "拍平"),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("opacity" to "0")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("text", _uM("class" to "uni-title-text uni-common-mt"), "scroll-view 组件"),
                        _cE("view", _uM("class" to "demo-row uni-common-mt"), _uA(
                            _cE("view", _uM("class" to "demo-item"), _uA(
                                _cE("text", null, "opacity: 0.5"),
                                _cE("scroll-view", _uM("class" to "common", "style" to _nS(_uM("opacity" to "0.5"))), null, 4)
                            )),
                            _cE("view", _uM("class" to "demo-item"), _uA(
                                _cE("text", null, "opacity: 0.2"),
                                _cE("scroll-view", _uM("class" to "common", "style" to _nS(_uM("opacity" to "0.2"))), null, 4)
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 opacity ")
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["opacity"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["opacityActual"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("ref_key" to "viewRef", "ref" to viewRef, "class" to "common test-view", "style" to _nS(_uM("opacity" to unref(data)["opacity"]))), _uA(
                                        _cE("text", _uM("class" to "common-text"), "view")
                                    ), 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["opacity"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["opacityActualText"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRef", "ref" to textRef, "class" to "common test-text", "style" to _nS(_uM("opacity" to unref(data)["opacity"]))), "text", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["opacity"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["opacityActualImage"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("ref_key" to "imageRef", "ref" to imageRef, "class" to "common test-image", "style" to _nS(_uM("opacity" to unref(data)["opacity"])), "src" to "/static/test-image/logo.png"), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["opacity"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["opacityActualFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("ref_key" to "viewRefFlat", "ref" to viewRefFlat, "class" to "common test-view-flatten", "style" to _nS(_uM("opacity" to unref(data)["opacity"])), "flatten" to ""), _uA(
                                        _cE("text", _uM("class" to "common-text"), "view")
                                    ), 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["opacity"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["opacityActualTextFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRefFlat", "ref" to textRefFlat, "class" to "common test-text-flatten", "style" to _nS(_uM("opacity" to unref(data)["opacity"])), "flatten" to ""), "text", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["opacity"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["opacityActualImageFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("ref_key" to "imageRefFlat", "ref" to imageRefFlat, "class" to "common test-image-flatten", "style" to _nS(_uM("opacity" to unref(data)["opacity"])), "flatten" to "", "src" to "/static/test-image/logo.png"), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                            _cV(_component_enum_data, _uM("items" to opacityEnum, "title" to "opacity 枚举值", "onChange" to radioChangeOpacity, "compact" to true)),
                            _cV(_component_input_data, _uM("defaultValue" to unref(data)["opacity"], "title" to "opacity 自定义值", "type" to "text", "onConfirm" to inputChangeOpacity), null, 8, _uA(
                                "defaultValue"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mb"), _uA(
                            _cE("text", null, "native-view组件: opacity: 0.5 和 opacity: 0.2"),
                            _cE("view", _uM("class" to "demo-row uni-common-mt"), _uA(
                                _cE("view", _uM("class" to "demo-item"), _uA(
                                    _cE("text", null, "opacity: 0.5"),
                                    _cE("native-view", _uM("class" to "common", "style" to _nS(_uM("opacity" to "0.5"))), null, 4)
                                )),
                                _cE("view", _uM("class" to "demo-item"), _uA(
                                    _cE("text", null, "opacity: 0.2"),
                                    _cE("native-view", _uM("class" to "common", "style" to _nS(_uM("opacity" to "0.2"))), null, 4)
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
                return _uM("demo-row" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between")), "demo-item" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 5, "marginBottom" to 0, "marginLeft" to 5)), "common" to _pS(_uM("width" to 80, "height" to 80, "backgroundColor" to "#0000FF")), "common-text" to _pS(_uM("width" to 50)), "test-container" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "marginTop" to 10)), "test-item" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 5, "marginBottom" to 0, "marginLeft" to 5)), "test-box" to _pS(_uM("width" to "100%", "height" to 80, "backgroundColor" to "#808080")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
