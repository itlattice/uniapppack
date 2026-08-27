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
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
open class GenPagesCSSBackgroundBackgroundColor : BasePage {
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
    open var radioChangeBackgroundColor: (index: Number) -> Unit
        get() {
            return unref(this.`$exposed`["radioChangeBackgroundColor"]) as (index: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "radioChangeBackgroundColor", value)
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
        var setup: (__props: GenPagesCSSBackgroundBackgroundColor, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSBackgroundBackgroundColor
            val _cache = __ins.renderCache
            val data = reactive(_uO("backgroundColor" to "cyan", "backgroundColorActual" to "", "backgroundColorActualText" to "", "backgroundColorActualImage" to "", "backgroundColorActualFlat" to "", "backgroundColorActualTextFlat" to "", "backgroundColorActualImageFlat" to ""))
            val viewRef = ref(null as UniElement?)
            val textRef = ref(null as UniTextElement?)
            val imageRef = ref(null as UniImageElement?)
            val viewRefFlat = ref(null as UniElement?)
            val textRefFlat = ref(null as UniTextElement?)
            val imageRefFlat = ref(null as UniImageElement?)
            val backgroundColorEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "green"),
                ItemType(value = 2, name = "#88abf0"),
                ItemType(value = 3, name = "rgb(0, 255, 0)"),
                ItemType(value = 4, name = "rgba(0, 255, 0, 0.5)"),
                ItemType(value = 5, name = "#ddd"),
                ItemType(value = 6, name = "transparent")
            ) as UTSArray<ItemType>
            val getPropertyValues = fun(){
                data["backgroundColorActual"] = viewRef.value?.style?.getPropertyValue("background-color") ?: ""
                data["backgroundColorActualFlat"] = viewRefFlat.value?.style?.getPropertyValue("background-color") ?: ""
                data["backgroundColorActualText"] = textRef.value?.style?.getPropertyValue("background-color") ?: ""
                data["backgroundColorActualTextFlat"] = textRefFlat.value?.style?.getPropertyValue("background-color") ?: ""
                data["backgroundColorActualImage"] = imageRef.value?.style?.getPropertyValue("background-color") ?: ""
                data["backgroundColorActualImageFlat"] = imageRefFlat.value?.style?.getPropertyValue("background-color") ?: ""
            }
            val changeBackgroundColor = fun(color: String){
                data["backgroundColor"] = color
                viewRef.value?.style?.setProperty("background-color", color)
                viewRefFlat.value?.style?.setProperty("background-color", color)
                textRef.value?.style?.setProperty("background-color", color)
                textRefFlat.value?.style?.setProperty("background-color", color)
                imageRef.value?.style?.setProperty("background-color", color)
                imageRefFlat.value?.style?.setProperty("background-color", color)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangeBackgroundColor = fun(index: Number){
                val selectedItem = backgroundColorEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changeBackgroundColor(selectedItem.name)
                }
            }
            val inputChangeBackgroundColor = fun(value: String){
                changeBackgroundColor(value)
            }
            val jumpToCheckBoxWithBackgroundColor = fun(){
                uni_navigateTo(NavigateToOptions(url = "/pages/CSS/background/background-color-check-box"))
            }
            onReady(fun(){
                getPropertyValues()
            }
            )
            __expose(_uM("radioChangeBackgroundColor" to radioChangeBackgroundColor, "data" to data))
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1"))), _uA(
                        _cE("text", _uM("class" to "uni-tips"), "说明：左边是正常版本，右边是拍平版本"),
                        _cE("view", null, _uA(
                            _cE("text", null, "background-color: blue"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("background-color" to "blue"))), null, 4),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("background-color" to "blue")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "background-color: #0000ff"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("background-color" to "#0000ff"))), null, 4),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("background-color" to "#0000ff")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "background-color: #00f"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("background-color" to "#00f"))), null, 4),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("background-color" to "#00f")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "background-color: #0000ff80"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("background-color" to "#0000ff80"))), null, 4),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("background-color" to "#0000ff80")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "background-color: #00f8"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("background-color" to "#00f8"))), null, 4),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("background-color" to "#00f8")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "background-color: rgb(0, 0, 255)"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("background-color" to "rgb(0, 0, 255)"))), null, 4),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("background-color" to "rgb(0, 0, 255)")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "background-color: rgba(0, 0, 255, 0.5)"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("background-color" to "rgba(0, 0, 255, 0.5)"))), null, 4),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("background-color" to "rgba(0, 0, 255, 0.5)")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "background-color: #0000ff80"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("background-color" to "#0000ff80"))), null, 4),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("background-color" to "#0000ff80")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", _uM("style" to _nS(_uM("margin-left" to "30px", "margin-right" to "30px"))), _uA(
                            _cE("button", _uM("type" to "default", "onClick" to jumpToCheckBoxWithBackgroundColor), "应用background-color示例")
                        ), 4),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "text 组件 background-color ")
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "background-color: blue"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("text", _uM("class" to "common", "style" to _nS(_uM("background-color" to "blue"))), "文字内容", 4),
                                _cE("text", _uM("class" to "common", "style" to _nS(_uM("background-color" to "blue")), "flatten" to ""), "文字内容", 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "background-color: rgba(0, 0, 255, 0.5)"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("text", _uM("class" to "common", "style" to _nS(_uM("background-color" to "rgba(0, 0, 255, 0.5)"))), "文字内容", 4),
                                _cE("text", _uM("class" to "common", "style" to _nS(_uM("background-color" to "rgba(0, 0, 255, 0.5)")), "flatten" to ""), "文字内容", 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "background-color: #00ff00"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("text", _uM("class" to "common", "style" to _nS(_uM("background-color" to "#00ff00"))), "文字内容", 4),
                                _cE("text", _uM("class" to "common", "style" to _nS(_uM("background-color" to "#00ff00")), "flatten" to ""), "文字内容", 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "background-color: #0000ff80"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("text", _uM("class" to "common", "style" to _nS(_uM("background-color" to "#0000ff80"))), "文字内容", 4),
                                _cE("text", _uM("class" to "common", "style" to _nS(_uM("background-color" to "#0000ff80")), "flatten" to ""), "文字内容", 4)
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "image 组件 background-color ")
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "background-color: blue (无src时显示背景色)"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("image", _uM("class" to "common-image", "style" to _nS(_uM("background-color" to "blue"))), null, 4),
                                _cE("image", _uM("class" to "common-image", "style" to _nS(_uM("background-color" to "blue")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "background-color: rgba(0, 0, 255, 0.5) (无src时显示背景色)"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("image", _uM("class" to "common-image", "style" to _nS(_uM("background-color" to "rgba(0, 0, 255, 0.5)"))), null, 4),
                                _cE("image", _uM("class" to "common-image", "style" to _nS(_uM("background-color" to "rgba(0, 0, 255, 0.5)")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "background-color: #00ff00 (无src时显示背景色)"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("image", _uM("class" to "common-image", "style" to _nS(_uM("background-color" to "#00ff00"))), null, 4),
                                _cE("image", _uM("class" to "common-image", "style" to _nS(_uM("background-color" to "#00ff00")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "background-color: #0000ff80 (无src时显示背景色)"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("image", _uM("class" to "common-image", "style" to _nS(_uM("background-color" to "#0000ff80"))), null, 4),
                                _cE("image", _uM("class" to "common-image", "style" to _nS(_uM("background-color" to "#0000ff80")), "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "background-color: yellow (有src时，背景色在图片加载失败或透明区域显示)"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("image", _uM("class" to "common-image", "style" to _nS(_uM("background-color" to "yellow")), "src" to "/static/test-image/logo.png"), null, 4),
                                _cE("image", _uM("class" to "common-image", "style" to _nS(_uM("background-color" to "yellow")), "src" to "/static/test-image/logo.png", "flatten" to ""), null, 4)
                            ))
                        )),
                        _cE("text", _uM("class" to "uni-title-text uni-common-mt"), "scroll-view 组件"),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("scroll-view", _uM("style" to _nS(_uM("width" to "100px", "height" to "100px", "background-color" to "#0000ff80"))), _uA(
                                _cE("text", _uM("class" to "scroll-view-label"), "#0000ff80")
                            ), 4),
                            _cE("scroll-view", _uM("style" to _nS(_uM("width" to "100px", "height" to "100px", "background-color" to "green"))), _uA(
                                _cE("text", _uM("class" to "scroll-view-label"), "green")
                            ), 4)
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 background-color ")
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["backgroundColor"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["backgroundColorActual"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("ref_key" to "viewRef", "ref" to viewRef, "class" to "common-view test-view", "style" to _nS(_uM("backgroundColor" to unref(data)["backgroundColor"]))), _uA(
                                        _cE("text", _uM("style" to _nS(_uM("font-size" to "12px"))), "view", 4)
                                    ), 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["backgroundColor"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["backgroundColorActualText"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRef", "ref" to textRef, "class" to "common-text test-text", "style" to _nS(_uM("backgroundColor" to unref(data)["backgroundColor"]))), "text", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["backgroundColor"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["backgroundColorActualImage"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("ref_key" to "imageRef", "ref" to imageRef, "class" to "common-image test-image", "style" to _nS(_uM("backgroundColor" to unref(data)["backgroundColor"])), "src" to "/static/test-image/logo.png"), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["backgroundColor"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["backgroundColorActualFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("ref_key" to "viewRefFlat", "ref" to viewRefFlat, "class" to "common-view test-view-flatten", "style" to _nS(_uM("backgroundColor" to unref(data)["backgroundColor"])), "flatten" to ""), _uA(
                                        _cE("text", _uM("style" to _nS(_uM("font-size" to "12px"))), "view", 4)
                                    ), 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["backgroundColor"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["backgroundColorActualTextFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRefFlat", "ref" to textRefFlat, "class" to "common-text test-text-flatten", "style" to _nS(_uM("backgroundColor" to unref(data)["backgroundColor"])), "flatten" to ""), "text", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["backgroundColor"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["backgroundColorActualImageFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("ref_key" to "imageRefFlat", "ref" to imageRefFlat, "class" to "common-image test-image-flatten", "style" to _nS(_uM("backgroundColor" to unref(data)["backgroundColor"])), "flatten" to "", "src" to "/static/test-image/logo.png"), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                            _cV(_component_enum_data, _uM("compact" to true, "items" to backgroundColorEnum, "title" to "background-color 枚举值", "onChange" to radioChangeBackgroundColor)),
                            _cV(_component_input_data, _uM("defaultValue" to unref(data)["backgroundColor"], "title" to "background-color 自定义值", "type" to "text", "onConfirm" to inputChangeBackgroundColor), null, 8, _uA(
                                "defaultValue"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mb"), _uA(
                            _cE("text", null, "native-view组件: background-color: blue 和 #0000ff80 "),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("native-view", _uM("class" to "common", "style" to _nS(_uM("background-color" to "blue"))), null, 4),
                                _cE("native-view", _uM("class" to "common", "style" to _nS(_uM("background-color" to "#0000ff80"))), null, 4)
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
                return _uM("common" to _pS(_uM("width" to 150, "height" to 50)), "demo-box" to _pS(_uM("flexDirection" to "row", "marginTop" to 10, "justifyContent" to "space-around")), "test-container" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "marginTop" to 10)), "test-item" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 5, "marginBottom" to 0, "marginLeft" to 5)), "test-box" to _pS(_uM("width" to "100%", "height" to 60, "backgroundColor" to "#808080")), "common-view" to _pS(_uM("height" to 50, "backgroundColor" to "#FFFF00")), "common-text" to _pS(_uM("height" to 50, "backgroundColor" to "#FFFF00", "fontSize" to 12)), "common-image" to _pS(_uM("width" to 50, "height" to 50, "backgroundColor" to "#FFFF00")), "scroll-view-label" to _pS(_uM("fontSize" to 12, "textAlign" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
