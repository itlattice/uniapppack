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
open class GenPagesCSSBorderBorderRadius : BasePage {
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
    open var radioChangeBorderRadius: (index: Number) -> Unit
        get() {
            return unref(this.`$exposed`["radioChangeBorderRadius"]) as (index: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "radioChangeBorderRadius", value)
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
        var setup: (__props: GenPagesCSSBorderBorderRadius, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSBorderBorderRadius
            val _cache = __ins.renderCache
            val borderRadiusEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "0"),
                ItemType(value = 2, name = "5px"),
                ItemType(value = 3, name = "20px"),
                ItemType(value = 4, name = "0%"),
                ItemType(value = 5, name = "50%")
            ) as UTSArray<ItemType>
            val data = reactive(_uO("borderRadius" to "10px", "borderRadiusActual" to "", "borderRadiusActualText" to "", "borderRadiusActualImage" to "", "borderRadiusActualFlat" to "", "borderRadiusActualTextFlat" to "", "borderRadiusActualImageFlat" to ""))
            val viewRef = ref(null as UniElement?)
            val textRef = ref(null as UniTextElement?)
            val imageRef = ref(null as UniImageElement?)
            val viewRefFlat = ref(null as UniElement?)
            val textRefFlat = ref(null as UniTextElement?)
            val imageRefFlat = ref(null as UniImageElement?)
            val getPropertyValues = fun(){
                data["borderRadiusActual"] = viewRef.value?.style?.getPropertyValue("border-radius") ?: ""
                data["borderRadiusActualFlat"] = viewRefFlat.value?.style?.getPropertyValue("border-radius") ?: ""
                data["borderRadiusActualText"] = textRef.value?.style?.getPropertyValue("border-radius") ?: ""
                data["borderRadiusActualTextFlat"] = textRefFlat.value?.style?.getPropertyValue("border-radius") ?: ""
                data["borderRadiusActualImage"] = imageRef.value?.style?.getPropertyValue("border-radius") ?: ""
                data["borderRadiusActualImageFlat"] = imageRefFlat.value?.style?.getPropertyValue("border-radius") ?: ""
            }
            val changeBorderRadius = fun(value: String){
                data["borderRadius"] = value
                viewRef.value?.style?.setProperty("border-radius", value)
                viewRefFlat.value?.style?.setProperty("border-radius", value)
                textRef.value?.style?.setProperty("border-radius", value)
                textRefFlat.value?.style?.setProperty("border-radius", value)
                imageRef.value?.style?.setProperty("border-radius", value)
                imageRefFlat.value?.style?.setProperty("border-radius", value)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangeBorderRadius = fun(index: Number){
                val selectedItem = borderRadiusEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changeBorderRadius(selectedItem.name)
                }
            }
            val inputChangeBorderRadius = fun(value: String){
                changeBorderRadius(value)
            }
            onReady(fun(){
                getPropertyValues()
            }
            )
            __expose(_uM("radioChangeBorderRadius" to radioChangeBorderRadius, "data" to data))
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1"))), _uA(
                        _cE("text", _uM("class" to "uni-tips"), "说明：左边是正常版本，右边是拍平版本"),
                        _cE("view", null, _uA(
                            _cE("text", null, "border-radius: 10px"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-radius" to "10px"))), null, 4),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-radius" to "10px")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "border-radius: 10% 和阴影"),
                            _cE("view", _uM("class" to "demo-box", "style" to _nS(_uM("height" to "60px"))), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-radius" to "10%", "box-shadow" to "5px 5px  rgba(0, 0, 0, .3)"))), null, 4),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-radius" to "10%", "box-shadow" to "5px 5px  rgba(0, 0, 0, .3)")), "flatten" to ""), null, 4)
                            ), 4)
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "border-top-left-radius: 10px"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-top-left-radius" to "10px"))), null, 4),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-top-left-radius" to "10px")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "border-top-right-radius: 10px"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-top-right-radius" to "10px"))), null, 4),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-top-right-radius" to "10px")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "border-bottom-left-radius: 10px"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-bottom-left-radius" to "10px"))), null, 4),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-bottom-left-radius" to "10px")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "border-bottom-right-radius: 10px"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-bottom-right-radius" to "10px"))), null, 4),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-bottom-right-radius" to "10px")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "border-radius: 150px（长宽不同形成扁圆）"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-radius" to "150px"))), null, 4),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-radius" to "150px")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "border-radius: 150px（与长宽相同形成正圆）"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common-square", "style" to _nS(_uM("border-radius" to "150px"))), null, 4),
                                _cE("view", _uM("class" to "common-square", "style" to _nS(_uM("border-radius" to "150px")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "border-radius: 10px（包含子视图）"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("margin-left" to "5px", "border-radius" to "10px"))), _uA(
                                    _cE("view", _uM("style" to _nS(_uM("background-color" to "wheat", "width" to "100%", "height" to "20px"))), null, 4)
                                ), 4),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("margin-left" to "5px", "border-radius" to "10px")), "flatten" to ""), _uA(
                                    _cE("view", _uM("style" to _nS(_uM("background-color" to "wheat", "width" to "100%", "height" to "20px")), "flatten" to ""), null, 4)
                                ), 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "border-bottom-left-radius: 10px \nborder-bottom-right-radius: 10px \n(包含子视图）"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("margin-left" to "5px", "border-top-left-radius" to "10px", "border-top-right-radius" to "10px"))), _uA(
                                    _cE("view", _uM("style" to _nS(_uM("background-color" to "wheat", "width" to "100%", "height" to "20px"))), null, 4)
                                ), 4),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("margin-left" to "5px", "border-top-left-radius" to "10px", "border-top-right-radius" to "10px")), "flatten" to ""), _uA(
                                    _cE("view", _uM("style" to _nS(_uM("background-color" to "wheat", "width" to "100%", "height" to "20px")), "flatten" to ""), null, 4)
                                ), 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "text组件: border-radius: 10px"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("text", _uM("class" to "text-radius", "style" to _nS(_uM("border-radius" to "10px"))), "文本", 4),
                                _cE("text", _uM("class" to "text-radius", "style" to _nS(_uM("border-radius" to "10px")), "flatten" to ""), "文本", 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "text组件: border-radius: 25px（与高度相同形成圆角）"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("text", _uM("class" to "text-radius-circle", "style" to _nS(_uM("border-radius" to "25px"))), "文本", 4),
                                _cE("text", _uM("class" to "text-radius-circle", "style" to _nS(_uM("border-radius" to "25px")), "flatten" to ""), "文本", 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "image组件: border-radius: 10px"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("image", _uM("class" to "image-radius", "style" to _nS(_uM("border-radius" to "10px")), "src" to "/static/test-image/logo.png"), null, 4),
                                _cE("image", _uM("class" to "image-radius", "style" to _nS(_uM("border-radius" to "10px")), "src" to "/static/test-image/logo.png", "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "image组件: border-radius: 100px（与长宽相同形成正圆）"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("image", _uM("class" to "image-radius-circle", "style" to _nS(_uM("border-radius" to "100px")), "src" to "/static/test-image/logo.png"), null, 4),
                                _cE("image", _uM("class" to "image-radius-circle", "style" to _nS(_uM("border-radius" to "100px")), "src" to "/static/test-image/logo.png", "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("text", _uM("class" to "uni-title-text uni-common-mt"), "scroll-view 组件"),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("scroll-view", _uM("class" to "common", "style" to _nS(_uM("border-radius" to "10px"))), _uA(
                                _cE("text", _uM("class" to "common-text"), "border-radius: 10px")
                            ), 4),
                            _cE("scroll-view", _uM("class" to "common", "style" to _nS(_uM("border-radius" to "100px"))), _uA(
                                _cE("text", _uM("class" to "common-text"), "border-radius: 100px")
                            ), 4)
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 border-radius ")
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["borderRadius"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["borderRadiusActual"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("ref_key" to "viewRef", "ref" to viewRef, "class" to "common-dynamic test-view", "style" to _nS(_uM("borderRadius" to unref(data)["borderRadius"]))), _uA(
                                        _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1", "background-color" to "bisque"))), _uA(
                                            _cE("text", null, "view")
                                        ), 4)
                                    ), 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["borderRadius"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["borderRadiusActualText"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRef", "ref" to textRef, "class" to "common-dynamic test-text", "style" to _nS(_uM("borderRadius" to unref(data)["borderRadius"]))), "text", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["borderRadius"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["borderRadiusActualImage"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("ref_key" to "imageRef", "ref" to imageRef, "class" to "common-image test-image", "style" to _nS(_uM("borderRadius" to unref(data)["borderRadius"])), "src" to "/static/test-image/logo.png"), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["borderRadius"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["borderRadiusActualFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("ref_key" to "viewRefFlat", "ref" to viewRefFlat, "class" to "common-dynamic test-view-flatten", "style" to _nS(_uM("borderRadius" to unref(data)["borderRadius"])), "flatten" to ""), _uA(
                                        _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1", "background-color" to "bisque")), "flatten" to ""), _uA(
                                            _cE("text", _uM("flatten" to ""), "view")
                                        ), 4)
                                    ), 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["borderRadius"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["borderRadiusActualTextFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRefFlat", "ref" to textRefFlat, "class" to "common-dynamic test-text-flatten", "style" to _nS(_uM("borderRadius" to unref(data)["borderRadius"])), "flatten" to ""), "text", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["borderRadius"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["borderRadiusActualImageFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("ref_key" to "imageRefFlat", "ref" to imageRefFlat, "class" to "common-image test-image-flatten", "style" to _nS(_uM("borderRadius" to unref(data)["borderRadius"])), "flatten" to "", "src" to "/static/test-image/logo.png"), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                            _cV(_component_enum_data, _uM("items" to borderRadiusEnum, "title" to "border-radius 枚举值", "onChange" to radioChangeBorderRadius, "compact" to true)),
                            _cV(_component_input_data, _uM("defaultValue" to unref(data)["borderRadius"], "title" to "border-radius 自定义值", "type" to "text", "onConfirm" to inputChangeBorderRadius), null, 8, _uA(
                                "defaultValue"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mb"), _uA(
                            _cE("text", null, "native-view组件: border-radius: 10px 和 border-top-left-radius: 10px"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("native-view", _uM("class" to "common", "style" to _nS(_uM("border-radius" to "10px"))), null, 4),
                                _cE("native-view", _uM("class" to "common", "style" to _nS(_uM("border-top-left-radius" to "10px"))), null, 4)
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
                return _uM("common" to _pS(_uM("width" to 150, "height" to 50, "backgroundColor" to "#808080")), "demo-box" to _pS(_uM("flexDirection" to "row", "marginTop" to 10, "justifyContent" to "space-around")), "common-square" to _pS(_uM("width" to 150, "height" to 150, "backgroundColor" to "#808080")), "text-radius" to _pS(_uM("width" to 150, "height" to 50, "backgroundColor" to "#808080", "fontSize" to 16, "color" to "#000000")), "text-radius-circle" to _pS(_uM("width" to 150, "height" to 25, "backgroundColor" to "#808080", "fontSize" to 16, "color" to "#000000")), "image-radius" to _pS(_uM("width" to 150, "height" to 100, "backgroundColor" to "#808080")), "image-radius-circle" to _pS(_uM("width" to 100, "height" to 100, "backgroundColor" to "#808080")), "common-dynamic" to _pS(_uM("height" to 50, "backgroundColor" to "#808080")), "common-image" to _pS(_uM("width" to 50, "height" to 50, "backgroundColor" to "#808080")), "test-container" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "marginTop" to 10)), "test-item" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 5, "marginBottom" to 0, "marginLeft" to 5)), "test-box" to _pS(_uM("width" to "100%", "height" to 60, "backgroundColor" to "#D3D3D3")), "common-text" to _pS(_uM("fontSize" to 12)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
