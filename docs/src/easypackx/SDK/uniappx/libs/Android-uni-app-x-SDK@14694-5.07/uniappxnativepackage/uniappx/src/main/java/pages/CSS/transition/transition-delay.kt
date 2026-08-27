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
open class GenPagesCSSTransitionTransitionDelay : BasePage {
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
    open var jest_start: () -> Unit
        get() {
            return unref(this.`$exposed`["jest_start"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_start", value)
        }
    open var jest_reset: () -> Unit
        get() {
            return unref(this.`$exposed`["jest_reset"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_reset", value)
        }
    open var radioChangeTransitionDelay: (index: Number) -> Unit
        get() {
            return unref(this.`$exposed`["radioChangeTransitionDelay"]) as (index: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "radioChangeTransitionDelay", value)
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
        var setup: (__props: GenPagesCSSTransitionTransitionDelay, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSTransitionTransitionDelay
            val _cache = __ins.renderCache
            val classValue = ref("box")
            val textClassValue = ref("text-box")
            val imageClassValue = ref("image-box")
            val scrollViewClassValue = ref("scroll-view-box")
            val nativeViewClassValue = ref("native-view-box")
            val start = fun(){
                classValue.value = "box ani"
            }
            val reset = fun(){
                classValue.value = "box"
            }
            val textStart = fun(){
                textClassValue.value = "text-box text-ani"
            }
            val textReset = fun(){
                textClassValue.value = "text-box"
            }
            val imageStart = fun(){
                imageClassValue.value = "image-box image-ani"
            }
            val imageReset = fun(){
                imageClassValue.value = "image-box"
            }
            val scrollViewStart = fun(){
                scrollViewClassValue.value = "scroll-view-box scroll-view-ani"
            }
            val scrollViewReset = fun(){
                scrollViewClassValue.value = "scroll-view-box"
            }
            val nativeViewStart = fun(){
                nativeViewClassValue.value = "native-view-box native-view-ani"
            }
            val nativeViewReset = fun(){
                nativeViewClassValue.value = "native-view-box"
            }
            val jest_start = fun(){
                start()
            }
            val jest_reset = fun(){
                reset()
            }
            val data = reactive(_uO("transitionDelayDynamic" to "1s", "transitionDelayActual" to "", "transitionDelayActualText" to "", "transitionDelayActualImage" to ""))
            val viewRefDynamic = ref(null as UniElement?)
            val textRefDynamic = ref(null as UniTextElement?)
            val imageRefDynamic = ref(null as UniImageElement?)
            val scrollViewRefDynamic = ref(null as UniElement?)
            val isExpandedDynamic = ref(false)
            val isExpandedDynamicText = ref(false)
            val isExpandedDynamicImage = ref(false)
            val isExpandedDynamicScrollView = ref(false)
            val transitionDelayEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "0s"),
                ItemType(value = 2, name = "0.5s"),
                ItemType(value = 3, name = "1s"),
                ItemType(value = 4, name = "2s")
            ) as UTSArray<ItemType>
            val getPropertyValues = fun(){
                data["transitionDelayActual"] = viewRefDynamic.value?.style?.getPropertyValue("transition-delay") ?: ""
                data["transitionDelayActualText"] = textRefDynamic.value?.style?.getPropertyValue("transition-delay") ?: ""
                data["transitionDelayActualImage"] = imageRefDynamic.value?.style?.getPropertyValue("transition-delay") ?: ""
            }
            val changeTransitionDelayDynamic = fun(value: String){
                data["transitionDelayDynamic"] = value
                viewRefDynamic.value?.style?.setProperty("transition-delay", value)
                textRefDynamic.value?.style?.setProperty("transition-delay", value)
                imageRefDynamic.value?.style?.setProperty("transition-delay", value)
                scrollViewRefDynamic.value?.style?.setProperty("transition-delay", value)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangeTransitionDelay = fun(index: Number){
                val selectedItem = transitionDelayEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changeTransitionDelayDynamic(selectedItem.name)
                }
            }
            val inputChangeTransitionDelay = fun(value: String){
                changeTransitionDelayDynamic(value)
            }
            val triggerTransitionDynamic = fun(){
                isExpandedDynamic.value = !isExpandedDynamic.value
                val width = if (isExpandedDynamic.value) {
                    "100px"
                } else {
                    "50px"
                }
                viewRefDynamic.value?.style?.setProperty("width", width)
            }
            val triggerTransitionTextDynamic = fun(){
                isExpandedDynamicText.value = !isExpandedDynamicText.value
                val width = if (isExpandedDynamicText.value) {
                    "100px"
                } else {
                    "50px"
                }
                textRefDynamic.value?.style?.setProperty("width", width)
            }
            val triggerTransitionImageDynamic = fun(){
                isExpandedDynamicImage.value = !isExpandedDynamicImage.value
                val width = if (isExpandedDynamicImage.value) {
                    "100px"
                } else {
                    "50px"
                }
                imageRefDynamic.value?.style?.setProperty("width", width)
            }
            onReady(fun(){
                getPropertyValues()
                if (scrollViewRefDynamic.value != null) {
                    scrollViewRefDynamic.value!!.style.setProperty("transition-delay", data["transitionDelayDynamic"])
                    scrollViewRefDynamic.value!!.style.setProperty("transition-property", "width")
                    scrollViewRefDynamic.value!!.style.setProperty("transition-duration", "1s")
                }
            }
            )
            __expose(_uM("jest_start" to jest_start, "jest_reset" to jest_reset, "radioChangeTransitionDelay" to radioChangeTransitionDelay, "data" to data))
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", null, _uA(
                        _cE("text", _uM("class" to "uni-title-text"), "view 组件 transition-delay：1s"),
                        _cE("view", _uM("class" to _nC(unref(classValue))), null, 2),
                        _cE("view", _uM("class" to "button-container"), _uA(
                            _cE("button", _uM("class" to "button-item", "onClick" to start), "start"),
                            _cE("button", _uM("class" to "button-item", "onClick" to reset), "reset")
                        )),
                        _cE("text", _uM("class" to "uni-title-text uni-common-mt"), "text 组件 transition-delay：2s"),
                        _cE("text", _uM("class" to _nC(unref(textClassValue))), "transition-delay: 2s", 2),
                        _cE("view", _uM("class" to "button-container"), _uA(
                            _cE("button", _uM("class" to "button-item", "onClick" to textStart), "text start"),
                            _cE("button", _uM("class" to "button-item", "onClick" to textReset), "text reset")
                        )),
                        _cE("text", _uM("class" to "uni-title-text uni-common-mt"), "image 组件 transition-delay：1s"),
                        _cE("image", _uM("class" to _nC(unref(imageClassValue)), "src" to "/static/test-image/logo.png"), null, 2),
                        _cE("view", _uM("class" to "button-container"), _uA(
                            _cE("button", _uM("class" to "button-item", "onClick" to imageStart), "image start"),
                            _cE("button", _uM("class" to "button-item", "onClick" to imageReset), "image reset")
                        )),
                        _cE("text", _uM("class" to "uni-title-text uni-common-mt"), "scroll-view 组件 transition-delay：1s"),
                        _cE("scroll-view", _uM("class" to _nC(unref(scrollViewClassValue))), null, 2),
                        _cE("view", _uM("class" to "button-container"), _uA(
                            _cE("button", _uM("class" to "button-item", "onClick" to scrollViewStart), "scroll-view start"),
                            _cE("button", _uM("class" to "button-item", "onClick" to scrollViewReset), "scroll-view reset")
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 transition-delay ")
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["transitionDelayDynamic"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["transitionDelayActual"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("ref_key" to "viewRefDynamic", "ref" to viewRefDynamic, "class" to "common-image test-view", "style" to _nS(_uM("transitionDelay" to unref(data)["transitionDelayDynamic"], "transitionProperty" to "width", "transitionDuration" to "1s")), "onClick" to triggerTransitionDynamic), _uA(
                                        _cE("text", _uM("style" to _nS(_uM("font-size" to "12px"))), "点击view", 4)
                                    ), 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["transitionDelayDynamic"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["transitionDelayActualText"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRefDynamic", "ref" to textRefDynamic, "class" to "common-text test-text", "style" to _nS(_uM("transitionDelay" to unref(data)["transitionDelayDynamic"], "transitionProperty" to "width", "transitionDuration" to "1s")), "onClick" to triggerTransitionTextDynamic), "点击text", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["transitionDelayDynamic"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["transitionDelayActualImage"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("ref_key" to "imageRefDynamic", "ref" to imageRefDynamic, "class" to "common-image test-image", "style" to _nS(_uM("transitionDelay" to unref(data)["transitionDelayDynamic"], "transitionProperty" to "width", "transitionDuration" to "1s")), "onClick" to triggerTransitionImageDynamic, "src" to "/static/test-image/logo.png"), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                            _cV(_component_enum_data, _uM("items" to transitionDelayEnum, "title" to "transition-delay 枚举值", "onChange" to radioChangeTransitionDelay, "compact" to true)),
                            _cV(_component_input_data, _uM("defaultValue" to unref(data)["transitionDelayDynamic"], "title" to "transition-delay 自定义值", "type" to "text", "onConfirm" to inputChangeTransitionDelay), null, 8, _uA(
                                "defaultValue"
                            ))
                        )),
                        _cE("text", _uM("class" to "uni-title-text uni-common-mt uni-common-mb"), "native-view 组件 transition-delay：1s"),
                        _cE("native-view", _uM("class" to _nC(unref(nativeViewClassValue))), null, 2),
                        _cE("view", _uM("class" to "button-container"), _uA(
                            _cE("button", _uM("class" to "button-item", "onClick" to nativeViewStart), "native-view start"),
                            _cE("button", _uM("class" to "button-item", "onClick" to nativeViewReset), "native-view reset")
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
                return _uM("box" to _pS(_uM("width" to 200, "height" to 50, "backgroundColor" to "#0000FF")), "ani" to _pS(_uM("transitionProperty" to "width", "transitionDuration" to "2s", "transitionDelay" to "1s", "width" to 300)), "text-box" to _pS(_uM("width" to 200, "height" to 60, "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "fontSize" to 16, "backgroundColor" to "#ADD8E6", "textAlign" to "center")), "text-ani" to _pS(_uM("transitionProperty" to "width", "transitionDuration" to "2s", "transitionDelay" to "2s", "width" to 300)), "image-box" to _pS(_uM("width" to 100, "height" to 100)), "image-ani" to _pS(_uM("transitionProperty" to "width,height", "transitionDuration" to "2s", "transitionDelay" to "1s", "width" to 150, "height" to 150)), "common-text" to _pS(_uM("width" to 50, "height" to 50, "backgroundColor" to "#008000", "fontSize" to 12, "color" to "#FFFFFF")), "common-image" to _pS(_uM("width" to 50, "height" to 50, "backgroundColor" to "#008000")), "scroll-view-box" to _pS(_uM("width" to 200, "height" to 50, "backgroundColor" to "#008000")), "scroll-view-ani" to _pS(_uM("transitionProperty" to "width", "transitionDuration" to "2s", "transitionDelay" to "1s", "width" to 300)), "native-view-box" to _pS(_uM("width" to 200, "height" to 50, "backgroundColor" to "#008000")), "native-view-ani" to _pS(_uM("transitionProperty" to "width", "transitionDuration" to "2s", "transitionDelay" to "1s", "width" to 300)), "test-container" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "marginTop" to 10)), "test-item" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 5, "marginBottom" to 0, "marginLeft" to 5)), "test-box" to _pS(_uM("width" to "100%", "height" to 80, "backgroundColor" to "#808080")), "demo-box" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-around", "marginTop" to 10)), "button-container" to _pS(_uM("flexDirection" to "row", "marginTop" to 10, "paddingBottom" to 15, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#d3d3d3")), "button-item" to _pS(_uM("marginRight" to 10)), "@TRANSITION" to _uM("ani" to _uM("property" to "width", "duration" to "2s", "delay" to "1s"), "text-ani" to _uM("property" to "width", "duration" to "2s", "delay" to "2s"), "image-ani" to _uM("property" to "width,height", "duration" to "2s", "delay" to "1s"), "scroll-view-ani" to _uM("property" to "width", "duration" to "2s", "delay" to "1s"), "native-view-ani" to _uM("property" to "width", "duration" to "2s", "delay" to "1s")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
