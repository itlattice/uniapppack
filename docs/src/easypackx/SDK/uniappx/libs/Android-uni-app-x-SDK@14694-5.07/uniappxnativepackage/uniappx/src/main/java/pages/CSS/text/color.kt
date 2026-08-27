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
open class GenPagesCSSTextColor : BasePage {
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
    open var radioChangeColor: (index: Number) -> Unit
        get() {
            return unref(this.`$exposed`["radioChangeColor"]) as (index: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "radioChangeColor", value)
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
        var setup: (__props: GenPagesCSSTextColor, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSTextColor
            val _cache = __ins.renderCache
            val colorEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "green"),
                ItemType(value = 2, name = "#942192"),
                ItemType(value = 3, name = "#000"),
                ItemType(value = 4, name = "#0000ff"),
                ItemType(value = 5, name = "rgb(0, 255, 0)"),
                ItemType(value = 6, name = "rgba(0, 255, 0, 0.5)")
            ) as UTSArray<ItemType>
            val data = reactive(_uO("color" to "cyan", "colorActual" to "", "colorActualFlat" to ""))
            val textRef = ref(null as UniTextElement?)
            val textRefFlat = ref(null as UniTextElement?)
            val getPropertyValues = fun(){
                data["colorActual"] = textRef.value?.style?.getPropertyValue("color") ?: ""
                data["colorActualFlat"] = textRefFlat.value?.style?.getPropertyValue("color") ?: ""
            }
            val changeColor = fun(value: String){
                data["color"] = value
                textRef.value?.style?.setProperty("color", value)
                textRefFlat.value?.style?.setProperty("color", value)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangeColor = fun(index: Number){
                val selectedItem = colorEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changeColor(selectedItem.name)
                }
            }
            val inputChangeColor = fun(value: String){
                changeColor(value)
            }
            onReady(fun(){
                getPropertyValues()
            }
            )
            __expose(_uM("radioChangeColor" to radioChangeColor, "data" to data))
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1"))), _uA(
                        _cE("text", _uM("class" to "uni-tips"), "说明：左边是正常版本，右边是拍平版本"),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("view", _uM("class" to "box"), _uA(
                                _cE("text", _uM("class" to "common", "style" to _nS(_uM("color" to "rgb(0, 0, 255)"))), "color: rgb(0, 0, 255)", 4),
                                _cE("text", _uM("class" to "common", "style" to _nS(_uM("color" to "rgba(0, 0, 255, 0.5)"))), "color: rgba(0, 0, 255, 0.5)", 4),
                                _cE("text", _uM("class" to "common", "style" to _nS(_uM("color" to "#0000ff"))), "color: #0000ff", 4),
                                _cE("text", _uM("class" to "common", "style" to _nS(_uM("color" to "#00f"))), "color: #00f", 4),
                                _cE("text", _uM("class" to "common", "style" to _nS(_uM("color" to "blue"))), "color: blue", 4)
                            )),
                            _cE("view", _uM("class" to "box"), _uA(
                                _cE("text", _uM("class" to "common", "style" to _nS(_uM("color" to "rgb(0, 0, 255)")), "flatten" to ""), "color: rgb(0, 0, 255)", 4),
                                _cE("text", _uM("class" to "common", "style" to _nS(_uM("color" to "rgba(0, 0, 255, 0.5)")), "flatten" to ""), "color: rgba(0, 0, 255, 0.5)", 4),
                                _cE("text", _uM("class" to "common", "style" to _nS(_uM("color" to "#0000ff")), "flatten" to ""), "color: #0000ff", 4),
                                _cE("text", _uM("class" to "common", "style" to _nS(_uM("color" to "#00f")), "flatten" to ""), "color: #00f", 4),
                                _cE("text", _uM("class" to "common", "style" to _nS(_uM("color" to "blue")), "flatten" to ""), "color: blue", 4)
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 color 测试")
                        )),
                        _cE("view", _uM("class" to "common-box"), _uA(
                            _cE("view", _uM("class" to "uni-common-mt"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "color"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["color"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["colorActual"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRef", "ref" to textRef, "class" to "common test-text", "style" to _nS(_uM("color" to unref(data)["color"]))), "当前 color: " + _tD(unref(data)["color"]), 5)
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-common-mt"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "测试拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["color"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["colorActualFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRefFlat", "ref" to textRefFlat, "class" to "common test-text-flatten", "style" to _nS(_uM("color" to unref(data)["color"])), "flatten" to ""), "当前 color: " + _tD(unref(data)["color"]), 5)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                            _cV(_component_enum_data, _uM("items" to colorEnum, "title" to "color 枚举值", "onChange" to radioChangeColor, "compact" to true)),
                            _cV(_component_input_data, _uM("defaultValue" to unref(data)["color"], "title" to "color 自定义值", "type" to "text", "onConfirm" to inputChangeColor), null, 8, _uA(
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
                return _uM("common" to _pS(_uM("fontSize" to 16)), "demo-box" to _pS(_uM("flexDirection" to "row", "marginTop" to 10, "justifyContent" to "space-around")), "box" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "height" to 130, "backgroundColor" to "#808080", "justifyContent" to "center", "alignItems" to "center")), "common-box" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-around")), "test-box" to _pS(_uM("width" to 180, "height" to 80, "backgroundColor" to "#808080", "justifyContent" to "center", "alignItems" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
