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
open class GenPagesCSSTextTextShadow : BasePage {
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
    open var radioChangeTextShadow: (index: Number) -> Unit
        get() {
            return unref(this.`$exposed`["radioChangeTextShadow"]) as (index: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "radioChangeTextShadow", value)
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
        var setup: (__props: GenPagesCSSTextTextShadow, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSTextTextShadow
            val _cache = __ins.renderCache
            val textShadowEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "1px 1px 2px pink"),
                ItemType(value = 3, name = "5px 5px #558abb"),
                ItemType(value = 4, name = "cyan 2px 5px"),
                ItemType(value = 5, name = "5px 10px"),
                ItemType(value = 6, name = "1px 2px 4px rgb(34, 202, 43)"),
                ItemType(value = 7, name = "2px 4px rgba(202, 207, 17, 0.5)")
            ) as UTSArray<ItemType>
            val data = reactive(_uO("textShadow" to "1px 1px 2px pink", "textShadowActual" to "", "textShadowActualFlat" to ""))
            val textRef = ref(null as UniTextElement?)
            val textRefFlat = ref(null as UniTextElement?)
            val getPropertyValues = fun(){
                data["textShadowActual"] = textRef.value?.style?.getPropertyValue("text-shadow") ?: ""
                data["textShadowActualFlat"] = textRefFlat.value?.style?.getPropertyValue("text-shadow") ?: ""
            }
            val changeTextShadow = fun(value: String){
                data["textShadow"] = value
                textRef.value?.style?.setProperty("text-shadow", value)
                textRefFlat.value?.style?.setProperty("text-shadow", value)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangeTextShadow = fun(index: Number){
                val selectedItem = textShadowEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changeTextShadow(selectedItem.name)
                }
            }
            val inputChangeTextShadow = fun(value: String){
                changeTextShadow(value)
            }
            onReady(fun(){
                getPropertyValues()
            }
            )
            __expose(_uM("radioChangeTextShadow" to radioChangeTextShadow, "data" to data))
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("class" to "container"), _uA(
                        _cE("text", _uM("class" to "text", "style" to _nS(_uM("text-shadow" to "1px 1px 2px pink"))), "text-shadow: 1px 1px 2px pink", 4),
                        _cE("text", _uM("class" to "text", "style" to _nS(_uM("text-shadow" to "5px 5px #558abb"))), "text-shadow: 5px 5px #558abb", 4),
                        _cE("text", _uM("class" to "text", "style" to _nS(_uM("text-shadow" to "cyan 2px 5px"))), "text-shadow: cyan 2px 5px", 4),
                        _cE("text", _uM("class" to "text", "style" to _nS(_uM("text-shadow" to "5px 10px"))), "text-shadow: 5px 10px", 4),
                        _cE("text", _uM("class" to "text", "style" to _nS(_uM("text-shadow" to "1px 2px 4px rgb(34, 202, 43)"))), "text-shadow: 1px 2px 4px rgb(34, 202, 43)", 4),
                        _cE("text", _uM("class" to "text", "style" to _nS(_uM("text-shadow" to "2px 4px rgba(202, 207, 17, 0.5)"))), "text-shadow: 2px 4px rgba(202, 207, 17, 0.5)", 4),
                        _cE("text", _uM("class" to "uni-title-text"), "【拍平版本】"),
                        _cE("text", _uM("class" to "text", "style" to _nS(_uM("text-shadow" to "1px 1px 2px pink")), "flatten" to ""), "text-shadow: 1px 1px 2px pink", 4),
                        _cE("text", _uM("class" to "text", "style" to _nS(_uM("text-shadow" to "5px 5px #558abb")), "flatten" to ""), "text-shadow: 5px 5px #558abb", 4),
                        _cE("text", _uM("class" to "text", "style" to _nS(_uM("text-shadow" to "cyan 2px 5px")), "flatten" to ""), "text-shadow: cyan 2px 5px", 4),
                        _cE("text", _uM("class" to "text", "style" to _nS(_uM("text-shadow" to "5px 10px")), "flatten" to ""), "text-shadow: 5px 10px", 4),
                        _cE("text", _uM("class" to "text", "style" to _nS(_uM("text-shadow" to "1px 2px 4px rgb(34, 202, 43)")), "flatten" to ""), "text-shadow: 1px 2px 4px rgb(34, 202, 43)", 4),
                        _cE("text", _uM("class" to "text", "style" to _nS(_uM("text-shadow" to "2px 4px rgba(202, 207, 17, 0.5)")), "flatten" to ""), "text-shadow: 2px 4px rgba(202, 207, 17, 0.5)", 4),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 text-shadow ")
                        )),
                        _cE("view", _uM("class" to "common-box"), _uA(
                            _cE("view", _uM("class" to "uni-common-mt"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "text-shadow"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["textShadow"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["textShadowActual"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRef", "ref" to textRef, "class" to "text test-text", "style" to _nS(_uM("textShadow" to unref(data)["textShadow"]))), "当前 text-shadow: " + _tD(unref(data)["textShadow"]), 5)
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-common-mt"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["textShadow"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["textShadowActualFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRefFlat", "ref" to textRefFlat, "class" to "text test-text-flatten", "style" to _nS(_uM("textShadow" to unref(data)["textShadow"])), "flatten" to ""), "当前 text-shadow: " + _tD(unref(data)["textShadow"]), 5)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                            _cV(_component_enum_data, _uM("items" to textShadowEnum, "title" to "text-shadow 枚举值", "onChange" to radioChangeTextShadow, "compact" to true)),
                            _cV(_component_input_data, _uM("defaultValue" to unref(data)["textShadow"], "title" to "text-shadow 自定义值", "type" to "text", "onConfirm" to inputChangeTextShadow), null, 8, _uA(
                                "defaultValue"
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
                return _uM("container" to _pS(_uM("backgroundColor" to "#808080", "justifyContent" to "center")), "text" to _pS(_uM("width" to "100%", "height" to 50, "fontSize" to 20, "textAlign" to "center")), "common-box" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-around")), "test-box" to _pS(_uM("width" to 180, "height" to 80, "backgroundColor" to "#cccccc", "justifyContent" to "center", "alignItems" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
