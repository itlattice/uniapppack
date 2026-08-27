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
open class GenPagesCSSTextFontStyle : BasePage {
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
    open var radioChangeFontStyle: (index: Number) -> Unit
        get() {
            return unref(this.`$exposed`["radioChangeFontStyle"]) as (index: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "radioChangeFontStyle", value)
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
        var setup: (__props: GenPagesCSSTextFontStyle, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSTextFontStyle
            val _cache = __ins.renderCache
            val fontStyleEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "normal"),
                ItemType(value = 2, name = "italic")
            ) as UTSArray<ItemType>
            val data = reactive(_uO("fontStyle" to "normal", "fontStyleActual" to "", "fontStyleActualFlat" to ""))
            val textRef = ref(null as UniTextElement?)
            val textRefFlat = ref(null as UniTextElement?)
            val getPropertyValues = fun(){
                data["fontStyleActual"] = textRef.value?.style?.getPropertyValue("font-style") ?: ""
                data["fontStyleActualFlat"] = textRefFlat.value?.style?.getPropertyValue("font-style") ?: ""
            }
            val changeFontStyle = fun(value: String){
                data["fontStyle"] = value
                textRef.value?.style?.setProperty("font-style", value)
                textRefFlat.value?.style?.setProperty("font-style", value)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangeFontStyle = fun(index: Number){
                val selectedItem = fontStyleEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changeFontStyle(selectedItem.name)
                }
            }
            val inputChangeFontStyle = fun(value: String){
                changeFontStyle(value)
            }
            onReady(fun(){
                getPropertyValues()
            }
            )
            __expose(_uM("radioChangeFontStyle" to radioChangeFontStyle, "data" to data))
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1"))), _uA(
                        _cE("text", _uM("class" to "uni-tips"), "说明：左边是正常版本，右边是拍平版本"),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("view", _uM("class" to "common"), _uA(
                                _cE("text", _uM("class" to "common-size", "style" to _nS(_uM("font-style" to "italic"))), "font-style: italic", 4),
                                _cE("text", _uM("class" to "common-size", "style" to _nS(_uM("font-style" to "normal"))), "font-style: normal", 4)
                            )),
                            _cE("view", _uM("class" to "common"), _uA(
                                _cE("text", _uM("class" to "common-size", "style" to _nS(_uM("font-style" to "italic")), "flatten" to ""), "font-style: italic", 4),
                                _cE("text", _uM("class" to "common-size", "style" to _nS(_uM("font-style" to "normal")), "flatten" to ""), "font-style: normal", 4)
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 font-style 测试")
                        )),
                        _cE("view", _uM("class" to "common-box"), _uA(
                            _cE("view", _uM("class" to "uni-common-mt"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "font-style"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["fontStyle"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["fontStyleActual"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRef", "ref" to textRef, "class" to "common-size test-text", "style" to _nS(_uM("fontStyle" to unref(data)["fontStyle"]))), "当前 font-style: " + _tD(unref(data)["fontStyle"]), 5)
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-common-mt"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "测试拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["fontStyle"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["fontStyleActualFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRefFlat", "ref" to textRefFlat, "class" to "common-size test-text-flatten", "style" to _nS(_uM("fontStyle" to unref(data)["fontStyle"])), "flatten" to ""), "当前 font-style: " + _tD(unref(data)["fontStyle"]), 5)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                            _cV(_component_enum_data, _uM("items" to fontStyleEnum, "title" to "font-style 枚举值", "onChange" to radioChangeFontStyle, "compact" to true)),
                            _cV(_component_input_data, _uM("defaultValue" to unref(data)["fontStyle"], "title" to "font-style 自定义值", "type" to "text", "onConfirm" to inputChangeFontStyle), null, 8, _uA(
                                "defaultValue"
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
                return _uM("common-size" to _pS(_uM("fontSize" to 20)), "common" to _pS(_uM("height" to 100, "backgroundColor" to "#808080", "justifyContent" to "center", "alignItems" to "center", "flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "demo-box" to _pS(_uM("flexDirection" to "row", "marginTop" to 10, "justifyContent" to "space-around")), "common-box" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-around")), "test-box" to _pS(_uM("width" to 180, "height" to 80, "backgroundColor" to "#808080", "justifyContent" to "center", "alignItems" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
