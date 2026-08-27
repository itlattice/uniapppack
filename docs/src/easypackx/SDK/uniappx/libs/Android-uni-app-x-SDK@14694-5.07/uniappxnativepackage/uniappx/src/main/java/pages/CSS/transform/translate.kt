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
open class GenPagesCSSTransformTranslate : BasePage {
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
        var setup: (__props: GenPagesCSSTransformTranslate, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSTransformTranslate
            val _cache = __ins.renderCache
            val data = reactive(_uO("transformValueDynamic" to "translateX(0px)", "transformActual" to "", "transformActualText" to "", "transformActualImage" to "", "transformActualFlat" to "", "transformActualTextFlat" to "", "transformActualImageFlat" to ""))
            val viewRefDynamic = ref(null as UniElement?)
            val textRefDynamic = ref(null as UniTextElement?)
            val imageRefDynamic = ref(null as UniImageElement?)
            val viewRefDynamicFlat = ref(null as UniElement?)
            val textRefDynamicFlat = ref(null as UniTextElement?)
            val imageRefDynamicFlat = ref(null as UniImageElement?)
            val transformEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "translateX(0px)"),
                ItemType(value = 2, name = "translateX(50px)"),
                ItemType(value = 3, name = "translateY(50px)"),
                ItemType(value = 4, name = "translate(50px, 50px)"),
                ItemType(value = 5, name = "translateX(80%)"),
                ItemType(value = 6, name = "translateY(50%)"),
                ItemType(value = 7, name = "translate(-50%, 50%)")
            ) as UTSArray<ItemType>
            val getPropertyValues = fun(){
                data["transformActual"] = viewRefDynamic.value?.style?.getPropertyValue("transform") ?: ""
                data["transformActualFlat"] = viewRefDynamicFlat.value?.style?.getPropertyValue("transform") ?: ""
                data["transformActualText"] = textRefDynamic.value?.style?.getPropertyValue("transform") ?: ""
                data["transformActualTextFlat"] = textRefDynamicFlat.value?.style?.getPropertyValue("transform") ?: ""
                data["transformActualImage"] = imageRefDynamic.value?.style?.getPropertyValue("transform") ?: ""
                data["transformActualImageFlat"] = imageRefDynamicFlat.value?.style?.getPropertyValue("transform") ?: ""
            }
            val changeTransformDynamic = fun(value: String){
                data["transformValueDynamic"] = value
                viewRefDynamic.value?.style?.setProperty("transform", value)
                viewRefDynamicFlat.value?.style?.setProperty("transform", value)
                textRefDynamic.value?.style?.setProperty("transform", value)
                textRefDynamicFlat.value?.style?.setProperty("transform", value)
                imageRefDynamic.value?.style?.setProperty("transform", value)
                imageRefDynamicFlat.value?.style?.setProperty("transform", value)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangeTransform = fun(index: Number){
                val selectedItem = transformEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changeTransformDynamic(selectedItem.name)
                }
            }
            val inputChangeTransform = fun(value: String){
                changeTransformDynamic(value)
            }
            onReady(fun(){
                getPropertyValues()
            }
            )
            __expose(_uM("data" to data))
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                val _component_navigator = resolveComponent("navigator")
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("class" to "page"), _uA(
                        _cE("view", _uM("class" to "trace"), _uA(
                            _cE("view", _uM("class" to "base reserve"), _uA(
                                _cE("text", _uM("class" to "reserve-text"), "translateX(80%)"),
                                _cE("text", _uM("class" to "reserve-text"), "转变前位置")
                            )),
                            _cE("view", _uM("class" to "base reserve", "flatten" to ""), _uA(
                                _cE("text", _uM("class" to "reserve-text", "flatten" to ""), "translateX(80%)"),
                                _cE("text", _uM("class" to "reserve-text", "flatten" to ""), "拍平 转变前位置")
                            )),
                            _cE("view", _uM("class" to "base reserve", "style" to _nS(_uM("margin-bottom" to "50px"))), _uA(
                                _cE("text", _uM("class" to "reserve-text"), "translateY(50px)"),
                                _cE("text", _uM("class" to "reserve-text"), "转变前位置")
                            ), 4),
                            _cE("view", _uM("class" to "base reserve", "style" to _nS(_uM("margin-bottom" to "50px")), "flatten" to ""), _uA(
                                _cE("text", _uM("class" to "reserve-text", "flatten" to ""), "translateY(50px)"),
                                _cE("text", _uM("class" to "reserve-text", "flatten" to ""), "拍平 转变前位置")
                            ), 4),
                            _cE("view", _uM("class" to "base reserve", "style" to _nS(_uM("margin-bottom" to "70px"))), _uA(
                                _cE("text", _uM("class" to "reserve-text"), "translate(-50%,50%)"),
                                _cE("text", _uM("class" to "reserve-text"), "转变前位置")
                            ), 4),
                            _cE("view", _uM("class" to "base reserve", "style" to _nS(_uM("margin-bottom" to "80px")), "flatten" to ""), _uA(
                                _cE("text", _uM("class" to "reserve-text", "flatten" to ""), "translate(-50%,50%)"),
                                _cE("text", _uM("class" to "reserve-text", "flatten" to ""), "拍平 转变前位置")
                            ), 4)
                        )),
                        _cE("view", _uM("class" to "trace-res"), _uA(
                            _cE("view", _uM("class" to "base transform", "style" to _nS(_uM("transform" to "translateX(80%)"))), _uA(
                                _cE("text", null, "translateX(80%)"),
                                _cE("text", null, "转变后位置")
                            ), 4),
                            _cE("view", _uM("class" to "base transform", "style" to _nS(_uM("transform" to "translateX(80%)")), "flatten" to ""), _uA(
                                _cE("text", _uM("flatten" to ""), "拍平"),
                                _cE("text", _uM("flatten" to ""), "translateX(80%)"),
                                _cE("text", _uM("flatten" to ""), "转变后位置")
                            ), 4),
                            _cE("view", _uM("class" to "base transform", "style" to _nS(_uM("transform" to "translateY(50px)", "margin-bottom" to "50px"))), _uA(
                                _cE("text", null, "translateY(50px)"),
                                _cE("text", null, "转变后位置")
                            ), 4),
                            _cE("view", _uM("class" to "base transform", "style" to _nS(_uM("transform" to "translateY(50px)", "margin-bottom" to "50px")), "flatten" to ""), _uA(
                                _cE("text", _uM("flatten" to ""), "拍平"),
                                _cE("text", _uM("flatten" to ""), "translateY(50px)"),
                                _cE("text", _uM("flatten" to ""), "转变后位置")
                            ), 4),
                            _cE("view", _uM("class" to "base transform", "style" to _nS(_uM("transform" to "translate(-50%, 50%)", "margin-bottom" to "70px"))), _uA(
                                _cE("text", null, "translate(-50%,50%)"),
                                _cE("text", null, "转变后位置")
                            ), 4),
                            _cE("view", _uM("class" to "base transform", "style" to _nS(_uM("transform" to "translate(-50%, 50%)", "margin-bottom" to "80px")), "flatten" to ""), _uA(
                                _cE("text", _uM("flatten" to ""), "拍平"),
                                _cE("text", _uM("flatten" to ""), "translate(-50%,50%)"),
                                _cE("text", _uM("flatten" to ""), "转变后位置")
                            ), 4)
                        )),
                        _cE("text", _uM("class" to "uni-title-text uni-common-mt", "style" to _nS(_uM("margin-top" to "50px"))), "scroll-view 组件", 4),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("view", _uM("class" to "scroll-view-item"), _uA(
                                _cE("scroll-view", _uM("class" to "scroll-view-base transform", "style" to _nS(_uM("transform" to "translateX(50px)"))), _uA(
                                    _cE("text", null, "translateX(50px)")
                                ), 4)
                            )),
                            _cE("view", _uM("class" to "scroll-view-item"), _uA(
                                _cE("scroll-view", _uM("class" to "scroll-view-base transform", "style" to _nS(_uM("transform" to "translateY(30px)"))), _uA(
                                    _cE("text", null, "translateY(30px)")
                                ), 4)
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 transform (translate) ")
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["transformValueDynamic"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["transformActual"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("ref_key" to "viewRefDynamic", "ref" to viewRefDynamic, "class" to "common-image", "style" to _nS(_uM("transform" to unref(data)["transformValueDynamic"]))), _uA(
                                        _cE("text", _uM("style" to _nS(_uM("font-size" to "12px"))), "view", 4)
                                    ), 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["transformValueDynamic"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["transformActualText"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRefDynamic", "ref" to textRefDynamic, "class" to "common-text", "style" to _nS(_uM("transform" to unref(data)["transformValueDynamic"]))), "text", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["transformValueDynamic"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["transformActualImage"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("ref_key" to "imageRefDynamic", "ref" to imageRefDynamic, "class" to "common-image", "style" to _nS(_uM("transform" to unref(data)["transformValueDynamic"])), "src" to "/static/test-image/logo.png"), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["transformValueDynamic"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["transformActualFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("ref_key" to "viewRefDynamicFlat", "ref" to viewRefDynamicFlat, "class" to "common-image", "style" to _nS(_uM("transform" to unref(data)["transformValueDynamic"])), "flatten" to ""), _uA(
                                        _cE("text", _uM("style" to _nS(_uM("font-size" to "12px")), "flatten" to ""), "view", 4)
                                    ), 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["transformValueDynamic"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["transformActualTextFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRefDynamicFlat", "ref" to textRefDynamicFlat, "class" to "common-text", "style" to _nS(_uM("transform" to unref(data)["transformValueDynamic"])), "flatten" to ""), "text", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["transformValueDynamic"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["transformActualImageFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("ref_key" to "imageRefDynamicFlat", "ref" to imageRefDynamicFlat, "class" to "common-image", "style" to _nS(_uM("transform" to unref(data)["transformValueDynamic"])), "src" to "/static/test-image/logo.png", "flatten" to ""), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                            _cV(_component_enum_data, _uM("items" to transformEnum, "title" to "transform 枚举值", "onChange" to radioChangeTransform, "compact" to true)),
                            _cV(_component_input_data, _uM("defaultValue" to unref(data)["transformValueDynamic"], "title" to "transform 自定义值", "type" to "text", "onConfirm" to inputChangeTransform), null, 8, _uA(
                                "defaultValue"
                            ))
                        )),
                        _cV(_component_navigator, _uM("style" to _nS(_uM("width" to "80%")), "url" to "/pages/CSS/transform/transform-origin"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("button", _uM("type" to "primary"), "transform-origin")
                            )
                        }
                        ), "_" to 1), 8, _uA(
                            "style"
                        )),
                        _cE("text", _uM("class" to "uni-title-text uni-common-mt uni-common-mb"), "native-view 组件"),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("view", _uM("class" to "scroll-view-item"), _uA(
                                _cE("native-view", _uM("class" to "scroll-view-base transform", "style" to _nS(_uM("transform" to "translateX(50px)"))), null, 4)
                            )),
                            _cE("view", _uM("class" to "scroll-view-item"), _uA(
                                _cE("native-view", _uM("class" to "scroll-view-base transform", "style" to _nS(_uM("transform" to "translateY(30px)"))), null, 4)
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
                return _uM("page" to _pS(_uM("alignItems" to "center")), "trace" to _pS(_uM("position" to "absolute", "top" to 0, "left" to 0, "width" to "100%", "alignItems" to "center")), "trace-res" to _pS(_uM("top" to 0, "left" to 0, "width" to "100%", "alignItems" to "center")), "base" to _pS(_uM("marginTop" to 10, "marginRight" to 10, "marginBottom" to 10, "marginLeft" to 10, "width" to 150, "height" to 150, "alignItems" to "center", "justifyContent" to "center")), "reserve" to _pS(_uM("borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "dotted", "borderRightStyle" to "dotted", "borderBottomStyle" to "dotted", "borderLeftStyle" to "dotted", "borderTopColor" to "#558888", "borderRightColor" to "#558888", "borderBottomColor" to "#558888", "borderLeftColor" to "#558888", "backgroundColor" to "#DDDDDD")), "reserve-text" to _pS(_uM("color" to "#CCCCCC")), "transform" to _pS(_uM("borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#0000FF", "borderRightColor" to "#0000FF", "borderBottomColor" to "#0000FF", "borderLeftColor" to "#0000FF", "backgroundColor" to "rgba(0,255,255,0.5)")), "common-text" to _pS(_uM("width" to 50, "height" to 50, "backgroundColor" to "#008000", "fontSize" to 12, "color" to "#FFFFFF")), "common-image" to _pS(_uM("width" to 50, "height" to 50, "backgroundColor" to "#008000")), "test-container" to _pS(_uM("width" to "100%", "flexDirection" to "row", "justifyContent" to "space-between", "marginTop" to 10)), "test-item" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 5, "marginBottom" to 0, "marginLeft" to 5)), "test-box" to _pS(_uM("width" to "90%", "height" to 120, "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "backgroundColor" to "#808080")), "demo-box" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-around", "marginTop" to 10, "width" to "100%")), "scroll-view-item" to _pS(_uM("position" to "relative", "width" to 200, "height" to 180, "marginTop" to 10, "marginRight" to 10, "marginBottom" to 10, "marginLeft" to 10, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#dddddd", "borderRightColor" to "#dddddd", "borderBottomColor" to "#dddddd", "borderLeftColor" to "#dddddd")), "scroll-view-base" to _pS(_uM("width" to 120, "height" to 120, "alignItems" to "center", "justifyContent" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
