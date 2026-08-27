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
open class GenPagesCSSTextFontSize : BasePage {
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
    open var setFontSize: () -> Unit
        get() {
            return unref(this.`$exposed`["setFontSize"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setFontSize", value)
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
        var setup: (__props: GenPagesCSSTextFontSize, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSTextFontSize
            val _cache = __ins.renderCache
            val data = reactive(_uO("fontSize" to "15px", "fontSizeProp" to "15px", "fontSizeActual" to "", "fontSizeActualFlat" to ""))
            val setFontSize = fun(){
                data["fontSize"] = "30px"
            }
            __expose(_uM("setFontSize" to setFontSize, "data" to data))
            val fontSizeEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "0"),
                ItemType(value = 2, name = "0px"),
                ItemType(value = 3, name = "10px"),
                ItemType(value = 4, name = "20px"),
                ItemType(value = 5, name = "0rpx"),
                ItemType(value = 6, name = "20rpx")
            ) as UTSArray<ItemType>
            val textRef = ref(null as UniTextElement?)
            val textRefFlat = ref(null as UniTextElement?)
            val getPropertyValues = fun(){
                data["fontSizeActual"] = textRef.value?.style?.getPropertyValue("font-size") ?: ""
                data["fontSizeActualFlat"] = textRefFlat.value?.style?.getPropertyValue("font-size") ?: ""
            }
            val changeFontSize = fun(value: String){
                data["fontSizeProp"] = value
                textRef.value?.style?.setProperty("font-size", value)
                textRefFlat.value?.style?.setProperty("font-size", value)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangeFontSize = fun(index: Number){
                val selectedItem = fontSizeEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changeFontSize(selectedItem.name)
                }
            }
            val inputChangeFontSize = fun(value: String){
                changeFontSize(value)
            }
            onReady(fun(){
                getPropertyValues()
            }
            )
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1"))), _uA(
                        _cE("text", _uM("class" to "uni-tips"), "说明：左边是正常版本，右边是拍平版本"),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("view", _uM("class" to "common"), _uA(
                                _cE("text", _uM("ref" to "text", "style" to _nS(_uM("font-size" to unref(data)["fontSize"]))), "font-size: " + _tD(unref(data)["fontSize"]), 5),
                                _cE("text", _uM("style" to _nS(_uM("font-size" to "30px"))), "font-size: 30px", 4)
                            )),
                            _cE("view", _uM("class" to "common"), _uA(
                                _cE("text", _uM("ref" to "text", "style" to _nS(_uM("font-size" to unref(data)["fontSize"])), "flatten" to ""), "font-size: " + _tD(unref(data)["fontSize"]), 5),
                                _cE("text", _uM("style" to _nS(_uM("font-size" to "30px")), "flatten" to ""), "font-size: 30px", 4)
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 font-size 测试")
                        )),
                        _cE("view", _uM("class" to "common-box"), _uA(
                            _cE("view", _uM("class" to "uni-common-mt"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "font-size"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["fontSizeProp"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["fontSizeActual"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRef", "ref" to textRef, "style" to _nS(_uM("fontSize" to unref(data)["fontSizeProp"]))), "当前 font-size: " + _tD(unref(data)["fontSizeProp"]), 5)
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-common-mt"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "测试拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["fontSizeProp"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["fontSizeActualFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRefFlat", "ref" to textRefFlat, "style" to _nS(_uM("fontSize" to unref(data)["fontSizeProp"])), "flatten" to ""), "当前 font-size: " + _tD(unref(data)["fontSizeProp"]), 5)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                            _cV(_component_enum_data, _uM("items" to fontSizeEnum, "title" to "font-size 枚举值", "onChange" to radioChangeFontSize, "compact" to true)),
                            _cV(_component_input_data, _uM("defaultValue" to unref(data)["fontSizeProp"], "title" to "font-size 自定义值", "type" to "text", "onConfirm" to inputChangeFontSize), null, 8, _uA(
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
                return _uM("common" to _pS(_uM("backgroundColor" to "#808080", "justifyContent" to "center", "height" to 100, "flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "demo-box" to _pS(_uM("flexDirection" to "row", "marginTop" to 10, "justifyContent" to "space-around")), "common-box" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-around")), "test-box" to _pS(_uM("width" to 180, "height" to 80, "backgroundColor" to "#808080", "justifyContent" to "center", "alignItems" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
