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
open class GenPagesCSSTextFontWeight : BasePage {
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
    open var radioChangeFontWeight: (index: Number) -> Unit
        get() {
            return unref(this.`$exposed`["radioChangeFontWeight"]) as (index: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "radioChangeFontWeight", value)
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
        var setup: (__props: GenPagesCSSTextFontWeight, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSTextFontWeight
            val _cache = __ins.renderCache
            val fontWeightEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "normal"),
                ItemType(value = 2, name = "bold"),
                ItemType(value = 3, name = "400"),
                ItemType(value = 4, name = "500"),
                ItemType(value = 5, name = "600"),
                ItemType(value = 6, name = "700")
            ) as UTSArray<ItemType>
            val data = reactive(_uO("fontWeight" to "normal", "fontWeightActual" to "", "fontWeightActualFlat" to ""))
            val textRef = ref(null as UniTextElement?)
            val textRefFlat = ref(null as UniTextElement?)
            val getPropertyValues = fun(){
                data["fontWeightActual"] = textRef.value?.style?.getPropertyValue("font-weight") ?: ""
                data["fontWeightActualFlat"] = textRefFlat.value?.style?.getPropertyValue("font-weight") ?: ""
            }
            val changeFontWeight = fun(value: String){
                data["fontWeight"] = value
                textRef.value?.style?.setProperty("font-weight", value)
                textRefFlat.value?.style?.setProperty("font-weight", value)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangeFontWeight = fun(index: Number){
                val selectedItem = fontWeightEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changeFontWeight(selectedItem.name)
                }
            }
            val inputChangeFontWeight = fun(value: String){
                changeFontWeight(value)
            }
            onReady(fun(){
                getPropertyValues()
            }
            )
            __expose(_uM("radioChangeFontWeight" to radioChangeFontWeight, "data" to data))
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1"))), _uA(
                        _cE("text", _uM("class" to "uni-tips"), "说明：左边是正常版本，右边是拍平版本"),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("view", _uM("class" to "common"), _uA(
                                _cE("text", _uM("class" to "common-size", "style" to _nS(_uM("font-weight" to "normal"))), "font-weight: normal", 4),
                                _cE("text", _uM("class" to "common-size", "style" to _nS(_uM("font-weight" to "bold"))), "font-weight: bold", 4),
                                _cE("text", _uM("class" to "common-size", "style" to _nS(_uM("font-weight" to "400"))), "font-weight: 400", 4),
                                _cE("text", _uM("class" to "common-size", "style" to _nS(_uM("font-weight" to "700"))), "font-weight: 700", 4)
                            )),
                            _cE("view", _uM("class" to "common"), _uA(
                                _cE("text", _uM("class" to "common-size", "style" to _nS(_uM("font-weight" to "normal")), "flatten" to ""), "font-weight: normal", 4),
                                _cE("text", _uM("class" to "common-size", "style" to _nS(_uM("font-weight" to "bold")), "flatten" to ""), "font-weight: bold", 4),
                                _cE("text", _uM("class" to "common-size", "style" to _nS(_uM("font-weight" to "400")), "flatten" to ""), "font-weight: 400", 4),
                                _cE("text", _uM("class" to "common-size", "style" to _nS(_uM("font-weight" to "700")), "flatten" to ""), "font-weight: 700", 4)
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 font-weight 测试")
                        )),
                        _cE("view", _uM("class" to "common-box"), _uA(
                            _cE("view", _uM("class" to "uni-common-mt"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "font-weight"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["fontWeight"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["fontWeightActual"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRef", "ref" to textRef, "class" to "common-size test-text", "style" to _nS(_uM("fontWeight" to unref(data)["fontWeight"]))), "当前 font-weight: " + _tD(unref(data)["fontWeight"]), 5)
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-common-mt"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "测试拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["fontWeight"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["fontWeightActualFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRefFlat", "ref" to textRefFlat, "class" to "common-size test-text-flatten", "style" to _nS(_uM("fontWeight" to unref(data)["fontWeight"])), "flatten" to ""), "当前 font-weight: " + _tD(unref(data)["fontWeight"]), 5)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                            _cV(_component_enum_data, _uM("items" to fontWeightEnum, "title" to "font-weight 枚举值", "onChange" to radioChangeFontWeight, "compact" to true)),
                            _cV(_component_input_data, _uM("defaultValue" to unref(data)["fontWeight"], "title" to "font-weight 自定义值", "type" to "text", "onConfirm" to inputChangeFontWeight), null, 8, _uA(
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
                return _uM("common-size" to _pS(_uM("fontSize" to 20)), "common" to _pS(_uM("height" to 150, "backgroundColor" to "#808080", "justifyContent" to "center", "alignItems" to "center", "flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "demo-box" to _pS(_uM("flexDirection" to "row", "marginTop" to 10, "justifyContent" to "space-around")), "common-box" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-around")), "test-box" to _pS(_uM("width" to 180, "height" to 80, "backgroundColor" to "#808080", "justifyContent" to "center", "alignItems" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
