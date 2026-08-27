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
open class GenPagesCSSBorderBorderWidth : BasePage {
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
    open var radioChangeBorderWidth: (index: Number) -> Unit
        get() {
            return unref(this.`$exposed`["radioChangeBorderWidth"]) as (index: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "radioChangeBorderWidth", value)
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
        var setup: (__props: GenPagesCSSBorderBorderWidth, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSBorderBorderWidth
            val _cache = __ins.renderCache
            val borderWidthEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "0"),
                ItemType(value = 2, name = "1px"),
                ItemType(value = 3, name = "3px"),
                ItemType(value = 4, name = "thin"),
                ItemType(value = 5, name = "medium"),
                ItemType(value = 6, name = "thick")
            ) as UTSArray<ItemType>
            val data = reactive(_uO("borderWidth" to "5px", "borderWidthActual" to "", "borderWidthActualText" to "", "borderWidthActualImage" to "", "borderWidthActualFlat" to "", "borderWidthActualTextFlat" to "", "borderWidthActualImageFlat" to ""))
            val viewRef = ref(null as UniElement?)
            val textRef = ref(null as UniTextElement?)
            val imageRef = ref(null as UniImageElement?)
            val viewRefFlat = ref(null as UniElement?)
            val textRefFlat = ref(null as UniTextElement?)
            val imageRefFlat = ref(null as UniImageElement?)
            val getPropertyValues = fun(){
                data["borderWidthActual"] = viewRef.value?.style?.getPropertyValue("border-width") ?: ""
                data["borderWidthActualFlat"] = viewRefFlat.value?.style?.getPropertyValue("border-width") ?: ""
                data["borderWidthActualText"] = textRef.value?.style?.getPropertyValue("border-width") ?: ""
                data["borderWidthActualTextFlat"] = textRefFlat.value?.style?.getPropertyValue("border-width") ?: ""
                data["borderWidthActualImage"] = imageRef.value?.style?.getPropertyValue("border-width") ?: ""
                data["borderWidthActualImageFlat"] = imageRefFlat.value?.style?.getPropertyValue("border-width") ?: ""
            }
            val changeBorderWidth = fun(value: String){
                data["borderWidth"] = value
                viewRef.value?.style?.setProperty("border-width", value)
                viewRefFlat.value?.style?.setProperty("border-width", value)
                textRef.value?.style?.setProperty("border-width", value)
                textRefFlat.value?.style?.setProperty("border-width", value)
                imageRef.value?.style?.setProperty("border-width", value)
                imageRefFlat.value?.style?.setProperty("border-width", value)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangeBorderWidth = fun(index: Number){
                val selectedItem = borderWidthEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changeBorderWidth(selectedItem.name)
                }
            }
            val inputChangeBorderWidth = fun(value: String){
                changeBorderWidth(value)
            }
            onReady(fun(){
                getPropertyValues()
            }
            )
            __expose(_uM("radioChangeBorderWidth" to radioChangeBorderWidth, "data" to data))
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("text", _uM("class" to "uni-tips"), "说明：左边是正常版本，右边是拍平版本"),
                    _cE("view", null, _uA(
                        _cE("text", null, "border-width: 5px (无 border-style)"),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-width" to "5px"))), null, 4),
                            _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-width" to "5px")), "flatten" to ""), null, 4)
                        ))
                    )),
                    _cE("view", null, _uA(
                        _cE("text", null, "border-width: 5px"),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-width" to "5px", "border-style" to "solid"))), null, 4),
                            _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-width" to "5px", "border-style" to "solid")), "flatten" to ""), null, 4)
                        ))
                    )),
                    _cE("view", null, _uA(
                        _cE("text", null, "border-left-width: 5px"),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-left-width" to "5px", "border-left-style" to "solid"))), null, 4),
                            _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-left-width" to "5px", "border-left-style" to "solid")), "flatten" to ""), null, 4)
                        ))
                    )),
                    _cE("view", null, _uA(
                        _cE("text", null, "border-top-width: 10px"),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-top-width" to "10px", "border-top-style" to "solid"))), null, 4),
                            _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-top-width" to "10px", "border-top-style" to "solid")), "flatten" to ""), null, 4)
                        ))
                    )),
                    _cE("view", null, _uA(
                        _cE("text", null, "border-right-width: 15px"),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-right-width" to "15px", "border-right-style" to "solid"))), null, 4),
                            _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-right-width" to "15px", "border-right-style" to "solid")), "flatten" to ""), null, 4)
                        ))
                    )),
                    _cE("view", null, _uA(
                        _cE("text", null, "border-bottom-width: 20px"),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-bottom-width" to "20px", "border-bottom-style" to "solid"))), null, 4),
                            _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-bottom-width" to "20px", "border-bottom-style" to "solid")), "flatten" to ""), null, 4)
                        ))
                    )),
                    _cE("view", null, _uA(
                        _cE("text", null, "左下细边框蓝色"),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-left-width" to "0.5px", "border-bottom-width" to "0.5px", "border-left-style" to "solid", "border-bottom-style" to "solid", "border-color" to "blue"))), null, 4),
                            _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-left-width" to "0.5px", "border-bottom-width" to "0.5px", "border-left-style" to "solid", "border-bottom-style" to "solid", "border-color" to "blue")), "flatten" to ""), null, 4)
                        ))
                    )),
                    _cE("view", null, _uA(
                        _cE("text", null, "border-width: 5px (无 border-style)"),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("view", _uM("class" to "common-circle", "style" to _nS(_uM("border-width" to "5px"))), null, 4),
                            _cE("view", _uM("class" to "common-circle", "style" to _nS(_uM("border-width" to "5px")), "flatten" to ""), null, 4)
                        ))
                    )),
                    _cE("view", null, _uA(
                        _cE("text", null, "border-width: 5px"),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("view", _uM("class" to "common-circle", "style" to _nS(_uM("border-width" to "5px", "border-style" to "solid"))), null, 4),
                            _cE("view", _uM("class" to "common-circle", "style" to _nS(_uM("border-width" to "5px", "border-style" to "solid")), "flatten" to ""), null, 4)
                        ))
                    )),
                    _cE("view", null, _uA(
                        _cE("text", null, "border-left-width: 5px"),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("view", _uM("class" to "common-circle", "style" to _nS(_uM("border-left-width" to "5px", "border-left-style" to "solid"))), null, 4),
                            _cE("view", _uM("class" to "common-circle", "style" to _nS(_uM("border-left-width" to "5px", "border-left-style" to "solid")), "flatten" to ""), null, 4)
                        ))
                    )),
                    _cE("view", null, _uA(
                        _cE("text", null, "border-top-width: 10px"),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("view", _uM("class" to "common-circle", "style" to _nS(_uM("border-top-width" to "10px", "border-top-style" to "solid"))), null, 4),
                            _cE("view", _uM("class" to "common-circle", "style" to _nS(_uM("border-top-width" to "10px", "border-top-style" to "solid")), "flatten" to ""), null, 4)
                        ))
                    )),
                    _cE("view", null, _uA(
                        _cE("text", null, "border-right-width: 15px"),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("view", _uM("class" to "common-circle", "style" to _nS(_uM("border-right-width" to "15px", "border-right-style" to "solid"))), null, 4),
                            _cE("view", _uM("class" to "common-circle", "style" to _nS(_uM("border-right-width" to "15px", "border-right-style" to "solid")), "flatten" to ""), null, 4)
                        ))
                    )),
                    _cE("view", null, _uA(
                        _cE("text", null, "border-bottom-width: 20px"),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("view", _uM("class" to "common-circle", "style" to _nS(_uM("border-bottom-width" to "20px", "border-bottom-style" to "solid"))), null, 4),
                            _cE("view", _uM("class" to "common-circle", "style" to _nS(_uM("border-bottom-width" to "20px", "border-bottom-style" to "solid")), "flatten" to ""), null, 4)
                        ))
                    )),
                    _cE("view", null, _uA(
                        _cE("text", null, "左下细边框蓝色"),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("view", _uM("class" to "common-circle", "style" to _nS(_uM("border-left-width" to "0.5px", "border-bottom-width" to "0.5px", "border-left-style" to "solid", "border-bottom-style" to "solid", "border-color" to "blue"))), null, 4),
                            _cE("view", _uM("class" to "common-circle", "style" to _nS(_uM("border-left-width" to "0.5px", "border-bottom-width" to "0.5px", "border-left-style" to "solid", "border-bottom-style" to "solid", "border-color" to "blue")), "flatten" to ""), null, 4)
                        ))
                    )),
                    _cE("view", null, _uA(
                        _cE("text", null, "裁剪展现半圆"),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("view", _uM("style" to _nS(_uM("width" to "100px", "height" to "50px", "overflow" to "hidden", "position" to "relative"))), _uA(
                                _cE("view", _uM("style" to _nS(_uM("width" to "100px", "height" to "100px", "border" to "10px solid blue", "border-radius" to "50px", "box-sizing" to "border-box"))), null, 4)
                            ), 4),
                            _cE("view", _uM("flatten" to "", "style" to _nS(_uM("width" to "100px", "height" to "50px", "overflow" to "hidden", "position" to "relative"))), _uA(
                                _cE("view", _uM("flatten" to "", "style" to _nS(_uM("width" to "100px", "height" to "100px", "border" to "10px solid blue", "border-radius" to "50px", "box-sizing" to "border-box"))), null, 4)
                            ), 4)
                        ))
                    )),
                    _cE("view", null, _uA(
                        _cE("text", null, "底边透明，3边上色的 3/4 圆弧"),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("view", _uM("style" to _nS(_uM("width" to "40px", "height" to "40px", "border" to "5px solid transparent", "border-top-color" to "blue", "border-right-color" to "blue", "border-left-color" to "blue", "border-radius" to "20px", "transform" to "rotate(45deg) translateZ(0)"))), null, 4),
                            _cE("view", _uM("flatten" to "", "style" to _nS(_uM("width" to "40px", "height" to "40px", "border" to "5px solid transparent", "border-top-color" to "blue", "border-right-color" to "blue", "border-left-color" to "blue", "border-radius" to "20px", "transform" to "rotate(45deg) translateZ(0)"))), null, 4)
                        ))
                    )),
                    _cE("view", null, _uA(
                        _cE("text", null, "底边上色，1/4边透明的 3/4 圆弧 加scale缩小"),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("view", _uM("style" to _nS(_uM("width" to "32px", "height" to "32px", "border-radius" to "16px", "border" to "2px solid blue", "border-bottom-color" to "transparent", "transform" to "scale(0.5) rotate(45deg)"))), null, 4),
                            _cE("view", _uM("flatten" to "", "style" to _nS(_uM("width" to "32px", "height" to "32px", "border-radius" to "16px", "border" to "2px solid blue", "border-bottom-color" to "transparent", "transform" to "scale(0.5) rotate(45deg)"))), null, 4)
                        ))
                    )),
                    _cE("text", _uM("class" to "uni-title-text uni-common-mt"), "scroll-view 组件"),
                    _cE("view", _uM("class" to "demo-box"), _uA(
                        _cE("scroll-view", _uM("class" to "common scroll-view-border", "style" to _nS(_uM("border-width" to "5px"))), _uA(
                            _cE("text", _uM("class" to "common-text"), "border-width: 5px")
                        ), 4),
                        _cE("scroll-view", _uM("class" to "common scroll-view-border", "style" to _nS(_uM("border-width" to "10px"))), _uA(
                            _cE("text", _uM("class" to "common-text"), "border-width: 10px")
                        ), 4)
                    )),
                    _cE("view", _uM("class" to "uni-common-mt"), _uA(
                        _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 border-width ")
                    )),
                    _cE("view", _uM("class" to "test-container"), _uA(
                        _cE("view", _uM("class" to "test-item"), _uA(
                            _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件"),
                            _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["borderWidth"]), 1),
                            _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["borderWidthActual"]), 1),
                            _cE("view", _uM("class" to "test-box"), _uA(
                                _cE("view", _uM("ref_key" to "viewRef", "ref" to viewRef, "class" to "common-dynamic test-view", "style" to _nS(_uM("borderWidth" to unref(data)["borderWidth"], "borderStyle" to "solid"))), _uA(
                                    _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1", "background-color" to "cyan"))), _uA(
                                        _cE("text", null, "view")
                                    ), 4)
                                ), 4)
                            ))
                        )),
                        _cE("view", _uM("class" to "test-item"), _uA(
                            _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件"),
                            _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["borderWidth"]), 1),
                            _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["borderWidthActualText"]), 1),
                            _cE("view", _uM("class" to "test-box"), _uA(
                                _cE("text", _uM("ref_key" to "textRef", "ref" to textRef, "class" to "common-dynamic test-text", "style" to _nS(_uM("borderWidth" to unref(data)["borderWidth"], "borderStyle" to "solid"))), "text", 4)
                            ))
                        )),
                        _cE("view", _uM("class" to "test-item"), _uA(
                            _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件"),
                            _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["borderWidth"]), 1),
                            _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["borderWidthActualImage"]), 1),
                            _cE("view", _uM("class" to "test-box"), _uA(
                                _cE("image", _uM("ref_key" to "imageRef", "ref" to imageRef, "class" to "common-image test-image", "style" to _nS(_uM("borderWidth" to unref(data)["borderWidth"], "borderStyle" to "solid")), "src" to "/static/test-image/logo.png"), null, 4)
                            ))
                        ))
                    )),
                    _cE("view", _uM("class" to "test-container"), _uA(
                        _cE("view", _uM("class" to "test-item"), _uA(
                            _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件拍平"),
                            _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["borderWidth"]), 1),
                            _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["borderWidthActualFlat"]), 1),
                            _cE("view", _uM("class" to "test-box"), _uA(
                                _cE("view", _uM("ref_key" to "viewRefFlat", "ref" to viewRefFlat, "class" to "common-dynamic test-view-flatten", "style" to _nS(_uM("borderWidth" to unref(data)["borderWidth"], "borderStyle" to "solid")), "flatten" to ""), _uA(
                                    _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1", "background-color" to "cyan"))), _uA(
                                        _cE("text", null, "view")
                                    ), 4)
                                ), 4)
                            ))
                        )),
                        _cE("view", _uM("class" to "test-item"), _uA(
                            _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件拍平"),
                            _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["borderWidth"]), 1),
                            _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["borderWidthActualTextFlat"]), 1),
                            _cE("view", _uM("class" to "test-box"), _uA(
                                _cE("text", _uM("ref_key" to "textRefFlat", "ref" to textRefFlat, "class" to "common-dynamic test-text-flatten", "style" to _nS(_uM("borderWidth" to unref(data)["borderWidth"], "borderStyle" to "solid")), "flatten" to ""), "text", 4)
                            ))
                        )),
                        _cE("view", _uM("class" to "test-item"), _uA(
                            _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件拍平"),
                            _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["borderWidth"]), 1),
                            _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["borderWidthActualImageFlat"]), 1),
                            _cE("view", _uM("class" to "test-box"), _uA(
                                _cE("image", _uM("ref_key" to "imageRefFlat", "ref" to imageRefFlat, "class" to "common-image test-image-flatten", "style" to _nS(_uM("borderWidth" to unref(data)["borderWidth"], "borderStyle" to "solid")), "flatten" to "", "src" to "/static/test-image/logo.png"), null, 4)
                            ))
                        ))
                    )),
                    _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                        _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                        _cV(_component_enum_data, _uM("items" to borderWidthEnum, "title" to "border-width 枚举值", "onChange" to radioChangeBorderWidth, "compact" to true)),
                        _cV(_component_input_data, _uM("defaultValue" to unref(data)["borderWidth"], "title" to "border-width 自定义值", "type" to "text", "onConfirm" to inputChangeBorderWidth), null, 8, _uA(
                            "defaultValue"
                        ))
                    )),
                    _cE("view", _uM("class" to "uni-common-mb"), _uA(
                        _cE("text", null, "native-view组件: border-width: 5px 和 10px"),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("native-view", _uM("class" to "common", "style" to _nS(_uM("border-width" to "5px", "border-style" to "solid"))), null, 4),
                            _cE("native-view", _uM("class" to "common", "style" to _nS(_uM("border-width" to "10px", "border-style" to "solid"))), null, 4)
                        ))
                    ))
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
                return _uM("common" to _pS(_uM("width" to 150, "height" to 50, "backgroundColor" to "#808080")), "demo-box" to _pS(_uM("flexDirection" to "row", "marginTop" to 10, "justifyContent" to "space-around")), "common-circle" to _pS(_uM("width" to 50, "height" to 50, "backgroundColor" to "#808080", "borderTopLeftRadius" to 25, "borderTopRightRadius" to 25, "borderBottomRightRadius" to 25, "borderBottomLeftRadius" to 25, "marginTop" to 5, "marginRight" to 5, "marginBottom" to 5, "marginLeft" to 5)), "common-dynamic" to _pS(_uM("height" to 50, "backgroundColor" to "#808080")), "common-image" to _pS(_uM("width" to 50, "height" to 50, "backgroundColor" to "#808080")), "test-container" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "marginTop" to 10)), "test-item" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 5, "marginBottom" to 0, "marginLeft" to 5)), "test-box" to _pS(_uM("width" to "100%", "height" to 60, "backgroundColor" to "#D3D3D3")), "scroll-view-border" to _pS(_uM("borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#0000FF", "borderRightColor" to "#0000FF", "borderBottomColor" to "#0000FF", "borderLeftColor" to "#0000FF")), "common-text" to _pS(_uM("fontSize" to 12)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
