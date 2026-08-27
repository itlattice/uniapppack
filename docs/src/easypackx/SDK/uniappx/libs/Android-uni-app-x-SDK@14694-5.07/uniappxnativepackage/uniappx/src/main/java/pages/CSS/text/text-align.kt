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
open class GenPagesCSSTextTextAlign : BasePage {
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
    open var radioChangeTextAlign: (index: Number) -> Unit
        get() {
            return unref(this.`$exposed`["radioChangeTextAlign"]) as (index: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "radioChangeTextAlign", value)
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
        var setup: (__props: GenPagesCSSTextTextAlign, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSTextTextAlign
            val _cache = __ins.renderCache
            val textAlignEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "left"),
                ItemType(value = 2, name = "center"),
                ItemType(value = 3, name = "right")
            ) as UTSArray<ItemType>
            val data = reactive(_uO("textAlign" to "left", "textAlignActual" to "", "textAlignActualFlat" to ""))
            val textRef = ref(null as UniTextElement?)
            val textRefFlat = ref(null as UniTextElement?)
            val getPropertyValues = fun(){
                data["textAlignActual"] = textRef.value?.style?.getPropertyValue("text-align") ?: ""
                data["textAlignActualFlat"] = textRefFlat.value?.style?.getPropertyValue("text-align") ?: ""
            }
            val changeTextAlign = fun(value: String){
                data["textAlign"] = value
                textRef.value?.style?.setProperty("text-align", value)
                textRefFlat.value?.style?.setProperty("text-align", value)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangeTextAlign = fun(index: Number){
                val selectedItem = textAlignEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changeTextAlign(selectedItem.name)
                }
            }
            val inputChangeTextAlign = fun(value: String){
                changeTextAlign(value)
            }
            onReady(fun(){
                getPropertyValues()
            }
            )
            __expose(_uM("radioChangeTextAlign" to radioChangeTextAlign, "data" to data))
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1"))), _uA(
                    _cE("view", _uM("class" to "box"), _uA(
                        _cE("text", _uM("class" to "common", "style" to _nS(_uM("text-align" to "left"))), "text-align: left", 4),
                        _cE("text", _uM("class" to "common", "style" to _nS(_uM("text-align" to "center"))), "text-align: center", 4),
                        _cE("text", _uM("class" to "common2", "style" to _nS(_uM("text-align" to "center"))), "text-align: center", 4),
                        _cE("text", _uM("class" to "common", "style" to _nS(_uM("text-align" to "right"))), "text-align: right", 4)
                    )),
                    _cE("text", _uM("class" to "uni-title-text"), "拍平版本"),
                    _cE("view", _uM("class" to "box"), _uA(
                        _cE("text", _uM("class" to "common", "style" to _nS(_uM("text-align" to "left")), "flatten" to ""), "text-align: left", 4),
                        _cE("text", _uM("class" to "common", "style" to _nS(_uM("text-align" to "center")), "flatten" to ""), "text-align: center", 4),
                        _cE("text", _uM("class" to "common2", "style" to _nS(_uM("text-align" to "center")), "flatten" to ""), "text-align: center", 4),
                        _cE("text", _uM("class" to "common", "style" to _nS(_uM("text-align" to "right")), "flatten" to ""), "text-align: right", 4)
                    )),
                    _cE("view", _uM("class" to "uni-common-mt"), _uA(
                        _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 text-align ")
                    )),
                    _cE("view", _uM("class" to "common-box"), _uA(
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "text-align"),
                            _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["textAlign"]), 1),
                            _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["textAlignActual"]), 1),
                            _cE("view", _uM("class" to "test-box"), _uA(
                                _cE("text", _uM("ref_key" to "textRef", "ref" to textRef, "class" to "common-text test-text", "style" to _nS(_uM("textAlign" to unref(data)["textAlign"]))), "当前 text-align: " + _tD(unref(data)["textAlign"]), 5)
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "拍平"),
                            _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["textAlign"]), 1),
                            _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["textAlignActualFlat"]), 1),
                            _cE("view", _uM("class" to "test-box"), _uA(
                                _cE("text", _uM("ref_key" to "textRefFlat", "ref" to textRefFlat, "class" to "common-text test-text-flatten", "style" to _nS(_uM("textAlign" to unref(data)["textAlign"])), "flatten" to ""), "当前 text-align: " + _tD(unref(data)["textAlign"]), 5)
                            ))
                        ))
                    )),
                    _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                        _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                        _cV(_component_enum_data, _uM("items" to textAlignEnum, "title" to "text-align 枚举值", "onChange" to radioChangeTextAlign, "compact" to true)),
                        _cV(_component_input_data, _uM("defaultValue" to unref(data)["textAlign"], "title" to "text-align 自定义值", "type" to "text", "onConfirm" to inputChangeTextAlign), null, 8, _uA(
                            "defaultValue"
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
                return _uM("common" to _pS(_uM("width" to 250, "fontSize" to 20)), "common2" to _pS(_uM("minWidth" to 250, "fontSize" to 20)), "common-text" to _pS(_uM("width" to 100, "fontSize" to 14)), "box" to _pS(_uM("height" to 150, "backgroundColor" to "#808080", "justifyContent" to "center", "alignItems" to "center")), "common-box" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-around")), "test-box" to _pS(_uM("width" to 180, "height" to 80, "backgroundColor" to "#808080", "justifyContent" to "center", "alignItems" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
