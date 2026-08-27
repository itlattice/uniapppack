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
open class GenPagesCSSTransformTransformOrigin : BasePage {
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
    open var data: UTSJSONObject
        get() {
            return unref(this.`$exposed`["data"]) as UTSJSONObject
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesCSSTransformTransformOrigin, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSTransformTransformOrigin
            val _cache = __ins.renderCache
            val transformView = ref(null as UniElement?)
            val textTransformView = ref(null as UniElement?)
            val imageTransformView = ref(null as UniElement?)
            val scrollViewTransformView = ref(null as UniElement?)
            val nativeViewTransformView = ref(null as UniElement?)
            val count = ref(0)
            val textCount = ref(0)
            val imageCount = ref(0)
            val scrollViewCount = ref(0)
            val nativeViewCount = ref(0)
            val changetransform = fun(){
                val element = transformView.value
                if (count.value == 0) {
                    element?.style?.setProperty("transform-origin", "60px 60px")
                    element?.style?.setProperty("transform", "scale(1)")
                    nextTick(fun(){
                        val originActual = element?.style?.getPropertyValue("transform-origin")
                        val transformActual = element?.style?.getPropertyValue("transform")
                    })
                } else if (count.value == 1) {
                    element?.style?.setProperty("transform-origin", "100% 0%")
                    element?.style?.setProperty("transform", "rotate(-20deg)")
                    nextTick(fun(){
                        val originActual = element?.style?.getPropertyValue("transform-origin")
                        val transformActual = element?.style?.getPropertyValue("transform")
                    }
                    )
                }
                count.value++
            }
            val changeTextTransform = fun(){
                val element = textTransformView.value
                if (textCount.value == 0) {
                    element?.style?.setProperty("transform-origin", "60px 30px")
                    element?.style?.setProperty("transform", "translate(50px, 50px) scale(1.5)")
                    nextTick(fun(){
                        val originActual = element?.style?.getPropertyValue("transform-origin")
                        val transformActual = element?.style?.getPropertyValue("transform")
                    })
                } else if (textCount.value == 1) {
                    element?.style?.setProperty("transform-origin", "100% 0%")
                    element?.style?.setProperty("transform", "rotate(-20deg)")
                    nextTick(fun(){
                        val originActual = element?.style?.getPropertyValue("transform-origin")
                        val transformActual = element?.style?.getPropertyValue("transform")
                    })
                } else {
                    element?.style?.setProperty("transform-origin", "10px 10px")
                    element?.style?.setProperty("transform", "scale(1)")
                    nextTick(fun(){
                        val originActual = element?.style?.getPropertyValue("transform-origin")
                        val transformActual = element?.style?.getPropertyValue("transform")
                    }
                    )
                    textCount.value = -1
                }
                textCount.value++
            }
            val changeImageTransform = fun(){
                val element = imageTransformView.value
                if (imageCount.value == 0) {
                    element?.style?.setProperty("transform-origin", "60px 60px")
                    element?.style?.setProperty("transform", "translate(50px, 50px) scale(2)")
                    nextTick(fun(){
                        val originActual = element?.style?.getPropertyValue("transform-origin")
                        val transformActual = element?.style?.getPropertyValue("transform")
                    })
                } else if (imageCount.value == 1) {
                    element?.style?.setProperty("transform-origin", "100% 0%")
                    element?.style?.setProperty("transform", "rotate(-20deg)")
                    nextTick(fun(){
                        val originActual = element?.style?.getPropertyValue("transform-origin")
                        val transformActual = element?.style?.getPropertyValue("transform")
                    })
                } else {
                    element?.style?.setProperty("transform-origin", "10px 10px")
                    element?.style?.setProperty("transform", "scale(1)")
                    nextTick(fun(){
                        val originActual = element?.style?.getPropertyValue("transform-origin")
                        val transformActual = element?.style?.getPropertyValue("transform")
                    }
                    )
                    imageCount.value = -1
                }
                imageCount.value++
            }
            val changeScrollViewTransform = fun(){
                val element = scrollViewTransformView.value
                if (scrollViewCount.value == 0) {
                    element?.style?.setProperty("transform-origin", "60px 60px")
                    element?.style?.setProperty("transform", "translate(50px, 50px) scale(1.5)")
                    nextTick(fun(){
                        val originActual = element?.style?.getPropertyValue("transform-origin")
                        val transformActual = element?.style?.getPropertyValue("transform")
                    })
                } else if (scrollViewCount.value == 1) {
                    element?.style?.setProperty("transform-origin", "100% 0%")
                    element?.style?.setProperty("transform", "rotate(-20deg)")
                    nextTick(fun(){
                        val originActual = element?.style?.getPropertyValue("transform-origin")
                        val transformActual = element?.style?.getPropertyValue("transform")
                    })
                } else {
                    element?.style?.setProperty("transform-origin", "10px 10px")
                    element?.style?.setProperty("transform", "scale(1)")
                    nextTick(fun(){
                        val originActual = element?.style?.getPropertyValue("transform-origin")
                        val transformActual = element?.style?.getPropertyValue("transform")
                    }
                    )
                    scrollViewCount.value = -1
                }
                scrollViewCount.value++
            }
            val changeNativeViewTransform = fun(){
                val element = nativeViewTransformView.value
                if (nativeViewCount.value == 0) {
                    element?.style?.setProperty("transform-origin", "60px 60px")
                    element?.style?.setProperty("transform", "translate(50px, 50px) scale(1.5)")
                    nextTick(fun(){
                        val originActual = element?.style?.getPropertyValue("transform-origin")
                        val transformActual = element?.style?.getPropertyValue("transform")
                    })
                } else if (nativeViewCount.value == 1) {
                    element?.style?.setProperty("transform-origin", "100% 0%")
                    element?.style?.setProperty("transform", "rotate(-20deg)")
                    nextTick(fun(){
                        val originActual = element?.style?.getPropertyValue("transform-origin")
                        val transformActual = element?.style?.getPropertyValue("transform")
                    })
                } else {
                    element?.style?.setProperty("transform-origin", "10px 10px")
                    element?.style?.setProperty("transform", "scale(1)")
                    nextTick(fun(){
                        val originActual = element?.style?.getPropertyValue("transform-origin")
                        val transformActual = element?.style?.getPropertyValue("transform")
                    }
                    )
                    nativeViewCount.value = -1
                }
                nativeViewCount.value++
            }
            val data = reactive(_uO("transformOrigin" to "50% 50%", "transformOriginActual" to "", "transformOriginActualText" to "", "transformOriginActualImage" to "", "transformOriginActualFlat" to "", "transformOriginActualTextFlat" to "", "transformOriginActualImageFlat" to ""))
            val viewRefDynamic = ref(null as UniElement?)
            val textRefDynamic = ref(null as UniTextElement?)
            val imageRefDynamic = ref(null as UniImageElement?)
            val viewRefDynamicFlat = ref(null as UniElement?)
            val textRefDynamicFlat = ref(null as UniTextElement?)
            val imageRefDynamicFlat = ref(null as UniImageElement?)
            val transformOriginEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "50% 50%"),
                ItemType(value = 2, name = "0% 0%"),
                ItemType(value = 3, name = "100% 0%"),
                ItemType(value = 4, name = "0% 100%"),
                ItemType(value = 5, name = "100% 100%"),
                ItemType(value = 6, name = "10px 10px"),
                ItemType(value = 7, name = "60px 60px")
            ) as UTSArray<ItemType>
            val getPropertyValues = fun(){
                data["transformOriginActual"] = viewRefDynamic.value?.style?.getPropertyValue("transform-origin") ?: ""
                data["transformOriginActualFlat"] = viewRefDynamicFlat.value?.style?.getPropertyValue("transform-origin") ?: ""
                data["transformOriginActualText"] = textRefDynamic.value?.style?.getPropertyValue("transform-origin") ?: ""
                data["transformOriginActualTextFlat"] = textRefDynamicFlat.value?.style?.getPropertyValue("transform-origin") ?: ""
                data["transformOriginActualImage"] = imageRefDynamic.value?.style?.getPropertyValue("transform-origin") ?: ""
                data["transformOriginActualImageFlat"] = imageRefDynamicFlat.value?.style?.getPropertyValue("transform-origin") ?: ""
            }
            val changeTransformOrigin = fun(value: String){
                data["transformOrigin"] = value
                viewRefDynamic.value?.style?.setProperty("transform-origin", value)
                viewRefDynamicFlat.value?.style?.setProperty("transform-origin", value)
                textRefDynamic.value?.style?.setProperty("transform-origin", value)
                textRefDynamicFlat.value?.style?.setProperty("transform-origin", value)
                imageRefDynamic.value?.style?.setProperty("transform-origin", value)
                imageRefDynamicFlat.value?.style?.setProperty("transform-origin", value)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangeTransformOrigin = fun(index: Number){
                val selectedItem = transformOriginEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changeTransformOrigin(selectedItem.name)
                }
            }
            val inputChangeTransformOrigin = fun(value: String){
                changeTransformOrigin(value)
            }
            onReady(fun(){
                getPropertyValues()
            }
            )
            __expose(_uM("data" to data))
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", null, _uA(
                        _cE("view", _uM("ref_key" to "transformView", "ref" to transformView, "class" to "view", "onClick" to changetransform), null, 512),
                        _cE("view", _uM("class" to "text-container"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "text 组件 transform-origin ："),
                            _cE("text", _uM("class" to "uni-subtitle-text"), "点击下方 text 组件，不同 transform-origin 值（60px 30px、100% 0%、10px 10px）对 translate、scale、rotate 变换的影响"),
                            _cE("text", _uM("ref_key" to "textTransformView", "ref" to textTransformView, "class" to "text-view", "onClick" to changeTextTransform), "点击 text 测试 transform-origin", 512)
                        )),
                        _cE("view", _uM("class" to "image-container"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "image 组件 transform-origin ："),
                            _cE("text", _uM("class" to "uni-subtitle-text"), "点击下方 image 组件，不同 transform-origin 值（60px 60px、100% 0%、10px 10px）对 translate、scale、rotate 变换的影响"),
                            _cE("image", _uM("ref_key" to "imageTransformView", "ref" to imageTransformView, "class" to "image-view", "onClick" to changeImageTransform, "src" to "/static/test-image/logo.png"), null, 512)
                        )),
                        _cE("view", _uM("class" to "scroll-view-container"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "scroll-view 组件 transform-origin ："),
                            _cE("text", _uM("class" to "uni-subtitle-text"), "点击下方 scroll-view 组件，不同 transform-origin 值（60px 60px、100% 0%、10px 10px）对 translate、scale、rotate 变换的影响"),
                            _cE("view", _uM("class" to "scroll-view-item"), _uA(
                                _cE("scroll-view", _uM("ref_key" to "scrollViewTransformView", "ref" to scrollViewTransformView, "class" to "scroll-view-base transform", "onClick" to changeScrollViewTransform), _uA(
                                    _cE("text", null, "点击 scroll-view 测试 transform-origin")
                                ), 512)
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 transform-origin ")
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["transformOrigin"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["transformOriginActual"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("ref_key" to "viewRefDynamic", "ref" to viewRefDynamic, "class" to "common-image", "style" to _nS(_uM("transformOrigin" to unref(data)["transformOrigin"], "transform" to "rotate(45deg)"))), _uA(
                                        _cE("text", _uM("style" to _nS(_uM("font-size" to "12px"))), "view", 4)
                                    ), 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["transformOrigin"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["transformOriginActualText"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRefDynamic", "ref" to textRefDynamic, "class" to "common-text", "style" to _nS(_uM("transformOrigin" to unref(data)["transformOrigin"], "transform" to "rotate(45deg)"))), "text", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["transformOrigin"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["transformOriginActualImage"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("ref_key" to "imageRefDynamic", "ref" to imageRefDynamic, "class" to "common-image", "style" to _nS(_uM("transformOrigin" to unref(data)["transformOrigin"], "transform" to "rotate(45deg)")), "src" to "/static/test-image/logo.png"), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["transformOrigin"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["transformOriginActualFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("ref_key" to "viewRefDynamicFlat", "ref" to viewRefDynamicFlat, "class" to "common-image", "style" to _nS(_uM("transformOrigin" to unref(data)["transformOrigin"], "transform" to "rotate(45deg)")), "flatten" to ""), _uA(
                                        _cE("text", _uM("style" to _nS(_uM("font-size" to "12px")), "flatten" to ""), "view", 4)
                                    ), 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["transformOrigin"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["transformOriginActualTextFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRefDynamicFlat", "ref" to textRefDynamicFlat, "class" to "common-text", "style" to _nS(_uM("transformOrigin" to unref(data)["transformOrigin"], "transform" to "rotate(45deg)")), "flatten" to ""), "text", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["transformOrigin"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["transformOriginActualImageFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("ref_key" to "imageRefDynamicFlat", "ref" to imageRefDynamicFlat, "class" to "common-image", "style" to _nS(_uM("transformOrigin" to unref(data)["transformOrigin"], "transform" to "rotate(45deg)")), "src" to "/static/test-image/logo.png", "flatten" to ""), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                            _cV(_component_enum_data, _uM("items" to transformOriginEnum, "title" to "transform-origin 枚举值", "onChange" to radioChangeTransformOrigin, "compact" to true)),
                            _cV(_component_input_data, _uM("defaultValue" to unref(data)["transformOrigin"], "title" to "transform-origin 自定义值", "type" to "text", "onConfirm" to inputChangeTransformOrigin), null, 8, _uA(
                                "defaultValue"
                            ))
                        )),
                        _cE("view", _uM("class" to "scroll-view-container"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "native-view 组件 transform-origin ："),
                            _cE("text", _uM("class" to "uni-subtitle-text"), "点击下方 native-view 组件，不同 transform-origin 值（60px 60px、100% 0%、10px 10px）对 translate、scale、rotate 变换的影响"),
                            _cE("view", _uM("class" to "scroll-view-item"), _uA(
                                _cE("native-view", _uM("ref_key" to "nativeViewTransformView", "ref" to nativeViewTransformView, "class" to "scroll-view-base transform", "onClick" to changeNativeViewTransform), null, 512)
                            ))
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
                return _uM("view" to _pS(_uM("width" to 100, "height" to 100, "transformOrigin" to "10 10", "backgroundColor" to "#00FFFF", "transform" to "translate(50px, 50px) scale(2)", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopColor" to "#000000", "borderRightColor" to "#000000", "borderBottomColor" to "#000000", "borderLeftColor" to "#000000", "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid")), "text-view" to _pS(_uM("width" to 200, "height" to 70, "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "marginTop" to 20, "marginRight" to 20, "marginBottom" to 20, "marginLeft" to 20, "fontSize" to 16, "transformOrigin" to "10 10", "backgroundColor" to "#00FFFF", "transform" to "scale(1)", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopColor" to "#000000", "borderRightColor" to "#000000", "borderBottomColor" to "#000000", "borderLeftColor" to "#000000", "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "textAlign" to "center")), "image-view" to _pS(_uM("width" to 100, "height" to 100, "marginTop" to 20, "marginRight" to 20, "marginBottom" to 20, "marginLeft" to 20, "transformOrigin" to "10 10", "transform" to "scale(1)", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopColor" to "#000000", "borderRightColor" to "#000000", "borderBottomColor" to "#000000", "borderLeftColor" to "#000000", "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid")), "text-container" to _pS(_uM("width" to 400, "height" to 280, "marginTop" to 200)), "image-container" to _pS(_uM("width" to 400, "height" to 300)), "scroll-view-container" to _pS(_uM("width" to 400, "height" to 300, "marginTop" to 20)), "common-text" to _pS(_uM("width" to 50, "height" to 50, "backgroundColor" to "#008000", "fontSize" to 12, "color" to "#FFFFFF")), "common-image" to _pS(_uM("width" to 50, "height" to 50, "backgroundColor" to "#008000")), "test-container" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "marginTop" to 10)), "test-item" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 5, "marginBottom" to 0, "marginLeft" to 5)), "test-box" to _pS(_uM("width" to "100%", "height" to 120, "backgroundColor" to "#808080")), "demo-box" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-around", "marginTop" to 10, "width" to "100%")), "scroll-view-item" to _pS(_uM("position" to "relative", "width" to "100%", "height" to 200, "marginTop" to 10, "marginRight" to 0, "marginBottom" to 10, "marginLeft" to 0)), "scroll-view-base" to _pS(_uM("width" to 200, "height" to 70, "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "marginTop" to 20, "marginRight" to 20, "marginBottom" to 20, "marginLeft" to 20, "fontSize" to 16, "transformOrigin" to "10 10", "backgroundColor" to "#00FFFF", "transform" to "scale(1)", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopColor" to "#000000", "borderRightColor" to "#000000", "borderBottomColor" to "#000000", "borderLeftColor" to "#000000", "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "textAlign" to "center", "position" to "relative")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
