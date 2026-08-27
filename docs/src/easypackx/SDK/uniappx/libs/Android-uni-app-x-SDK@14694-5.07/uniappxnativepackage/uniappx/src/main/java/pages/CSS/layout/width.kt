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
open class GenPagesCSSLayoutWidth : BasePage {
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
    open var radioChangeWidth: (index: Number) -> Unit
        get() {
            return unref(this.`$exposed`["radioChangeWidth"]) as (index: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "radioChangeWidth", value)
        }
    open var emptyElementValues: UTSJSONObject
        get() {
            return unref(this.`$exposed`["emptyElementValues"]) as UTSJSONObject
        }
        set(value) {
            setRefValue(this.`$exposed`, "emptyElementValues", value)
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
        var setup: (__props: GenPagesCSSLayoutWidth, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSLayoutWidth
            val _cache = __ins.renderCache
            val widthEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "0"),
                ItemType(value = 2, name = "0px"),
                ItemType(value = 3, name = "50px"),
                ItemType(value = 4, name = "0%"),
                ItemType(value = 5, name = "50%"),
                ItemType(value = 6, name = "auto")
            ) as UTSArray<ItemType>
            val data = reactive(_uO("width" to "100px", "widthActual" to "", "widthActualText" to "", "widthActualImage" to "", "widthActualFlat" to "", "widthActualTextFlat" to "", "widthActualImageFlat" to ""))
            val viewRef = ref(null as UniElement?)
            val textRef = ref(null as UniTextElement?)
            val imageRef = ref(null as UniImageElement?)
            val viewRefFlat = ref(null as UniElement?)
            val textRefFlat = ref(null as UniTextElement?)
            val imageRefFlat = ref(null as UniImageElement?)
            val emptyViewRef = ref(null as UniElement?)
            val emptyViewFlatRef = ref(null as UniElement?)
            val emptyTextRef = ref(null as UniTextElement?)
            val emptyTextFlatRef = ref(null as UniTextElement?)
            val emptyImageRef = ref(null as UniImageElement?)
            val emptyImageFlatRef = ref(null as UniImageElement?)
            val emptyScrollViewRef = ref(null as UniElement?)
            val emptyNativeViewRef = ref(null as UniElement?)
            val emptyElementValues = reactive(_uO("emptyViewWidth" to "", "emptyViewHeight" to "", "emptyTextWidth" to "", "emptyTextHeight" to "", "emptyImageWidth" to "", "emptyImageHeight" to "", "emptyScrollViewWidth" to "", "emptyScrollViewHeight" to "", "emptyNativeViewWidth" to "", "emptyNativeViewHeight" to ""))
            val getEmptyElementValues = fun(){
                nextTick(fun(){
                    if (emptyViewRef.value != null) {
                        emptyElementValues["emptyViewWidth"] = emptyViewRef.value!!.style.getPropertyValue("width") ?: ""
                        emptyElementValues["emptyViewHeight"] = emptyViewRef.value!!.style.getPropertyValue("height") ?: ""
                    }
                    if (emptyTextRef.value != null) {
                        emptyElementValues["emptyTextWidth"] = emptyTextRef.value!!.style.getPropertyValue("width") ?: ""
                        emptyElementValues["emptyTextHeight"] = emptyTextRef.value!!.style.getPropertyValue("height") ?: ""
                    }
                    if (emptyImageRef.value != null) {
                        emptyElementValues["emptyImageWidth"] = emptyImageRef.value!!.style.getPropertyValue("width") ?: ""
                        emptyElementValues["emptyImageHeight"] = emptyImageRef.value!!.style.getPropertyValue("height") ?: ""
                    }
                    if (emptyScrollViewRef.value != null) {
                        emptyElementValues["emptyScrollViewWidth"] = emptyScrollViewRef.value!!.style.getPropertyValue("width") ?: ""
                        emptyElementValues["emptyScrollViewHeight"] = emptyScrollViewRef.value!!.style.getPropertyValue("height") ?: ""
                    }
                    if (emptyNativeViewRef.value != null) {
                        emptyElementValues["emptyNativeViewWidth"] = emptyNativeViewRef.value!!.style.getPropertyValue("width") ?: ""
                        emptyElementValues["emptyNativeViewHeight"] = emptyNativeViewRef.value!!.style.getPropertyValue("height") ?: ""
                    }
                }
                )
            }
            val getPropertyValues = fun(){
                data["widthActual"] = viewRef.value?.style?.getPropertyValue("width") ?: ""
                data["widthActualFlat"] = viewRefFlat.value?.style?.getPropertyValue("width") ?: ""
                data["widthActualText"] = textRef.value?.style?.getPropertyValue("width") ?: ""
                data["widthActualTextFlat"] = textRefFlat.value?.style?.getPropertyValue("width") ?: ""
                data["widthActualImage"] = imageRef.value?.style?.getPropertyValue("width") ?: ""
                data["widthActualImageFlat"] = imageRefFlat.value?.style?.getPropertyValue("width") ?: ""
            }
            val changeWidth = fun(value: String){
                data["width"] = value
                viewRef.value?.style?.setProperty("width", value)
                viewRefFlat.value?.style?.setProperty("width", value)
                textRef.value?.style?.setProperty("width", value)
                textRefFlat.value?.style?.setProperty("width", value)
                imageRef.value?.style?.setProperty("width", value)
                imageRefFlat.value?.style?.setProperty("width", value)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangeWidth = fun(index: Number){
                val selectedItem = widthEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changeWidth(selectedItem.name)
                }
            }
            val inputChangeWidth = fun(value: String){
                changeWidth(value)
            }
            onReady(fun(){
                getPropertyValues()
                getEmptyElementValues()
            }
            )
            __expose(_uM("radioChangeWidth" to radioChangeWidth, "emptyElementValues" to emptyElementValues, "data" to data))
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1"))), _uA(
                        _cE("text", _uM("class" to "uni-tips"), "说明：左边是正常版本，右边是拍平版本"),
                        _cE("view", null, _uA(
                            _cE("text", null, "width: 100px"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("width" to "100px"))), null, 4),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("width" to "100px")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "width: 200rpx"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("width" to "200rpx"))), null, 4),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("width" to "200rpx")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "width: 30%"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("width" to "30%"))), null, 4),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("width" to "30%")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "scroll-view 组件")
                        )),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("scroll-view", _uM("style" to _nS(_uM("width" to "100px", "height" to "100px", "background-color" to "cyan"))), _uA(
                                _cE("text", _uM("class" to "scroll-view-label"), "width: 100px")
                            ), 4),
                            _cE("scroll-view", _uM("style" to _nS(_uM("width" to "200px", "height" to "100px", "background-color" to "cyan"))), _uA(
                                _cE("text", _uM("class" to "scroll-view-label"), "width: 200px")
                            ), 4)
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 width ")
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["width"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["widthActual"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("ref_key" to "viewRef", "ref" to viewRef, "class" to "common test-view", "style" to _nS(_uM("width" to unref(data)["width"]))), _uA(
                                        _cE("text", null, "view")
                                    ), 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["width"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["widthActualText"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRef", "ref" to textRef, "class" to "common test-text", "style" to _nS(_uM("width" to unref(data)["width"]))), "text", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["width"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["widthActualImage"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("ref_key" to "imageRef", "ref" to imageRef, "class" to "common test-image", "style" to _nS(_uM("width" to unref(data)["width"])), "src" to "/static/test-image/logo.png"), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["width"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["widthActualFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("ref_key" to "viewRefFlat", "ref" to viewRefFlat, "class" to "common test-view-flatten", "style" to _nS(_uM("width" to unref(data)["width"])), "flatten" to ""), _uA(
                                        _cE("text", null, "view")
                                    ), 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["width"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["widthActualTextFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRefFlat", "ref" to textRefFlat, "class" to "common test-text-flatten", "style" to _nS(_uM("width" to unref(data)["width"])), "flatten" to ""), "text", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["width"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["widthActualImageFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("ref_key" to "imageRefFlat", "ref" to imageRefFlat, "class" to "common test-image-flatten", "style" to _nS(_uM("width" to unref(data)["width"])), "flatten" to "", "src" to "/static/test-image/logo.png"), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                            _cV(_component_enum_data, _uM("items" to widthEnum, "title" to "width 枚举值", "onChange" to radioChangeWidth, "compact" to true)),
                            _cV(_component_input_data, _uM("defaultValue" to unref(data)["width"], "title" to "width 自定义值", "type" to "text", "onConfirm" to inputChangeWidth), null, 8, _uA(
                                "defaultValue"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "默认宽高规则 (无宽高会不显示或使用默认值)")
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "空 view - 无宽高，有背景色 (预期不显示)"),
                            _cE("text", _uM("class" to "uni-info"), "getPropertyValue: width=" + _tD(unref(emptyElementValues)["emptyViewWidth"]) + ", height=" + _tD(unref(emptyElementValues)["emptyViewHeight"]), 1),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("ref_key" to "emptyViewRef", "ref" to emptyViewRef, "style" to _nS(_uM("background-color" to "cyan"))), null, 4),
                                _cE("view", _uM("ref_key" to "emptyViewFlatRef", "ref" to emptyViewFlatRef, "style" to _nS(_uM("background-color" to "cyan")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "空 text - 无文字、无宽高，有背景色"),
                            _cE("text", _uM("class" to "uni-info"), "getPropertyValue: width=" + _tD(unref(emptyElementValues)["emptyTextWidth"]) + ", height=" + _tD(unref(emptyElementValues)["emptyTextHeight"]), 1),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("text", _uM("ref_key" to "emptyTextRef", "ref" to emptyTextRef, "style" to _nS(_uM("background-color" to "cyan"))), null, 4),
                                _cE("text", _uM("ref_key" to "emptyTextFlatRef", "ref" to emptyTextFlatRef, "style" to _nS(_uM("background-color" to "cyan")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "空 image - 无 src、无宽高，有背景色 (image 有默认宽高)"),
                            _cE("text", _uM("class" to "uni-info"), "getPropertyValue: width=" + _tD(unref(emptyElementValues)["emptyImageWidth"]) + ", height=" + _tD(unref(emptyElementValues)["emptyImageHeight"]), 1),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("image", _uM("ref_key" to "emptyImageRef", "ref" to emptyImageRef, "style" to _nS(_uM("background-color" to "cyan"))), null, 4),
                                _cE("image", _uM("ref_key" to "emptyImageFlatRef", "ref" to emptyImageFlatRef, "style" to _nS(_uM("background-color" to "cyan")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "空 scroll-view - 无宽高，有背景色"),
                            _cE("text", _uM("class" to "uni-info"), "getPropertyValue: width=" + _tD(unref(emptyElementValues)["emptyScrollViewWidth"]) + ", height=" + _tD(unref(emptyElementValues)["emptyScrollViewHeight"]), 1),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("scroll-view", _uM("ref_key" to "emptyScrollViewRef", "ref" to emptyScrollViewRef, "style" to _nS(_uM("background-color" to "cyan"))), null, 4)
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mb"), _uA(
                            _cE("text", null, "空 native-view - 无宽高，有背景色"),
                            _cE("text", _uM("class" to "uni-info"), "getPropertyValue: width=" + _tD(unref(emptyElementValues)["emptyNativeViewWidth"]) + ", height=" + _tD(unref(emptyElementValues)["emptyNativeViewHeight"]), 1),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("native-view", _uM("ref_key" to "emptyNativeViewRef", "ref" to emptyNativeViewRef, "style" to _nS(_uM("background-color" to "cyan"))), null, 4)
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mb"), _uA(
                            _cE("text", null, "native-view组件: width: 100px 和 width: 200px"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("native-view", _uM("style" to _nS(_uM("width" to "100px", "height" to "100px", "background-color" to "cyan"))), null, 4),
                                _cE("native-view", _uM("style" to _nS(_uM("width" to "200px", "height" to "100px", "background-color" to "cyan"))), null, 4)
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
                return _uM("common" to _pS(_uM("height" to 80, "backgroundColor" to "#00FFFF")), "demo-box" to _pS(_uM("flexDirection" to "row", "marginTop" to 10, "justifyContent" to "space-around")), "test-container" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "marginTop" to 10)), "test-item" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 5, "marginBottom" to 0, "marginLeft" to 5)), "test-box" to _pS(_uM("width" to "100%", "height" to 80, "backgroundColor" to "#808080")), "scroll-view-label" to _pS(_uM("fontSize" to 12, "lineHeight" to "100px", "textAlign" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
