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
open class GenPagesCSSDisplayNone : BasePage {
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
    open var radioChangeDisplay: (index: Number) -> Unit
        get() {
            return unref(this.`$exposed`["radioChangeDisplay"]) as (index: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "radioChangeDisplay", value)
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
        var setup: (__props: GenPagesCSSDisplayNone, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSDisplayNone
            val _cache = __ins.renderCache
            val data = reactive(_uO("display" to "none", "displayProp" to "none", "displayActual" to "", "displayActualText" to "", "displayActualImage" to ""))
            val switchDisplay = fun(){
                data["display"] = if (("flex" == data["display"])) {
                    "none"
                } else {
                    "flex"
                }
            }
            val displayEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "flex"),
                ItemType(value = 2, name = "none")
            ) as UTSArray<ItemType>
            val viewRef = ref(null as UniElement?)
            val textRef = ref(null as UniTextElement?)
            val imageRef = ref(null as UniImageElement?)
            val getPropertyValues = fun(){
                data["displayActual"] = viewRef.value?.style?.getPropertyValue("display") ?: ""
                data["displayActualText"] = textRef.value?.style?.getPropertyValue("display") ?: ""
                data["displayActualImage"] = imageRef.value?.style?.getPropertyValue("display") ?: ""
            }
            val changeDisplay = fun(value: String){
                data["displayProp"] = value
                viewRef.value?.style?.setProperty("display", value)
                textRef.value?.style?.setProperty("display", value)
                imageRef.value?.style?.setProperty("display", value)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangeDisplay = fun(index: Number){
                val selectedItem = displayEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changeDisplay(selectedItem.name)
                }
            }
            val inputChangeDisplay = fun(value: String){
                changeDisplay(value)
            }
            onReady(fun(){
                getPropertyValues()
            }
            )
            __expose(_uM("radioChangeDisplay" to radioChangeDisplay, "data" to data))
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("class" to "page", "style" to _nS(_uM("flex" to "1"))), _uA(
                        _cE("view", _uM("class" to "head"), _uA(
                            _cE("text", _uM("class" to "tip"), "下面有一个灰色区域，display默认值为none"),
                            _cE("text", _uM("class" to "tip"), "当前display值：" + _tD(unref(data)["display"]), 1)
                        )),
                        _cE("view", _uM("class" to "content", "style" to _nS(_uM("display" to unref(data)["display"]))), _uA(
                            _cE("text", _uM("style" to _nS(_uM("background-color" to "aquamarine"))), "展示display区域", 4),
                            _cE("scroll-view", null, _uA(
                                _cE("text", _uM("class" to "common-text", "style" to _nS(_uM("height" to "20px"))), "scroll-view", 4)
                            )),
                            _cE("text", _uM("class" to "common-text", "style" to _nS(_uM("height" to "20px"))), "下方有个native-view", 4),
                            _cE("native-view", _uM("style" to _nS(_uM("width" to "20px", "height" to "20px", "background-color" to "cyan"))), null, 4)
                        ), 4),
                        _cE("button", _uM("onClick" to switchDisplay), "切换display属性"),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 display ")
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["displayProp"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["displayActual"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("ref_key" to "viewRef", "ref" to viewRef, "class" to "common-view test-view", "style" to _nS(_uM("display" to unref(data)["displayProp"]))), _uA(
                                        _cE("text", _uM("class" to "common-text"), "view")
                                    ), 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["displayProp"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["displayActualText"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRef", "ref" to textRef, "class" to "common-text test-text", "style" to _nS(_uM("display" to unref(data)["displayProp"]))), "text", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["displayProp"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["displayActualImage"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("ref_key" to "imageRef", "ref" to imageRef, "class" to "common-image test-image", "style" to _nS(_uM("display" to unref(data)["displayProp"])), "src" to "/static/test-image/logo.png"), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                            _cV(_component_enum_data, _uM("items" to displayEnum, "title" to "display 枚举值", "onChange" to radioChangeDisplay, "compact" to true)),
                            _cV(_component_input_data, _uM("defaultValue" to unref(data)["displayProp"], "title" to "display 自定义值", "type" to "text", "onConfirm" to inputChangeDisplay), null, 8, _uA(
                                "defaultValue"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mb"), _uA(
                            _cE("text", null, "native-view组件: display: none"),
                            _cE("native-view", _uM("class" to "common-view", "style" to _nS(_uM("display" to "none", "width" to "100px"))), null, 4)
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
                return _uM("page" to _pS(_uM("height" to "100%")), "head" to _pS(_uM("marginTop" to 10, "marginBottom" to 10, "alignItems" to "center")), "tip" to _pS(_uM("color" to "#FF0000")), "content" to _pS(_uM("borderTopWidth" to 5, "borderRightWidth" to 5, "borderBottomWidth" to 5, "borderLeftWidth" to 5, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#0000FF", "borderRightColor" to "#0000FF", "borderBottomColor" to "#0000FF", "borderLeftColor" to "#0000FF", "marginTop" to 20, "marginRight" to "auto", "marginBottom" to 20, "marginLeft" to "auto", "paddingTop" to 20, "paddingRight" to 20, "paddingBottom" to 20, "paddingLeft" to 20, "width" to 200, "height" to 150, "backgroundColor" to "#808080", "alignItems" to "center", "justifyContent" to "center")), "test-container" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "marginTop" to 10)), "test-item" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 5, "marginBottom" to 0, "marginLeft" to 5)), "test-box" to _pS(_uM("width" to "100%", "height" to 60, "backgroundColor" to "#808080")), "common-view" to _pS(_uM("height" to 50, "backgroundColor" to "#008000")), "common-text" to _pS(_uM("height" to 50, "backgroundColor" to "#008000", "fontSize" to 12, "color" to "#FFFFFF")), "common-image" to _pS(_uM("width" to 50, "height" to 50, "backgroundColor" to "#008000")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
