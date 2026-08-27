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
open class GenPagesCSSTextTextOverflow : BasePage {
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
    open var radioChangeTextOverflow: (index: Number) -> Unit
        get() {
            return unref(this.`$exposed`["radioChangeTextOverflow"]) as (index: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "radioChangeTextOverflow", value)
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
        var setup: (__props: GenPagesCSSTextTextOverflow, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSTextTextOverflow
            val _cache = __ins.renderCache
            val data = reactive(_uO("multiLineText" to "HBuilderX，轻巧、极速，极客编辑器；uni-app x，终极跨平台方案；uts，大一统语言", "singleLineText" to "uts，大一统语言（单行文本）", "textOverflow" to "clip", "textOverflowActual" to "", "textOverflowActualFlat" to ""))
            val textOverflowEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "clip"),
                ItemType(value = 2, name = "ellipsis")
            ) as UTSArray<ItemType>
            val textRef = ref(null as UniTextElement?)
            val textRefFlat = ref(null as UniTextElement?)
            val getPropertyValues = fun(){
                data["textOverflowActual"] = textRef.value?.style?.getPropertyValue("text-overflow") ?: ""
                data["textOverflowActualFlat"] = textRefFlat.value?.style?.getPropertyValue("text-overflow") ?: ""
            }
            val changeTextOverflow = fun(value: String){
                data["textOverflow"] = value
                textRef.value?.style?.setProperty("text-overflow", value)
                textRefFlat.value?.style?.setProperty("text-overflow", value)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangeTextOverflow = fun(index: Number){
                val selectedItem = textOverflowEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changeTextOverflow(selectedItem.name)
                }
            }
            val inputChangeTextOverflow = fun(value: String){
                changeTextOverflow(value)
            }
            onReady(fun(){
                getPropertyValues()
            }
            )
            __expose(_uM("radioChangeTextOverflow" to radioChangeTextOverflow, "data" to data))
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1"))), _uA(
                        _cE("view", _uM("style" to _nS(_uM("padding" to "0 10px", "background-color" to "gray", "justify-content" to "center"))), _uA(
                            _cE("view", _uM("class" to "margin-bottom-10"), _uA(
                                _cE("text", _uM("class" to "font-weight-bold"), "text-overflow:clip white-space:nowrap"),
                                _cE("text", _uM("class" to "font-size-20", "style" to _nS(_uM("text-overflow" to "clip", "white-space" to "nowrap"))), _tD(unref(data)["multiLineText"]), 5),
                                _cE("text", _uM("style" to _nS(_uM("color" to "#dbd9d9"))), "拍平版本", 4),
                                _cE("text", _uM("class" to "font-size-20", "style" to _nS(_uM("text-overflow" to "clip", "white-space" to "nowrap")), "flatten" to ""), _tD(unref(data)["multiLineText"]), 5)
                            )),
                            _cE("view", _uM("class" to "margin-bottom-10"), _uA(
                                _cE("text", _uM("class" to "font-weight-bold"), "text-overflow:ellipsis white-space:nowrap"),
                                _cE("text", _uM("class" to "font-size-20", "style" to _nS(_uM("text-overflow" to "ellipsis", "white-space" to "nowrap"))), _tD(unref(data)["singleLineText"]), 5),
                                _cE("text", _uM("style" to _nS(_uM("color" to "#dbd9d9"))), "拍平版本", 4),
                                _cE("text", _uM("class" to "font-size-20", "style" to _nS(_uM("text-overflow" to "ellipsis", "white-space" to "nowrap")), "flatten" to ""), _tD(unref(data)["singleLineText"]), 5),
                                _cE("text", _uM("class" to "font-size-20", "style" to _nS(_uM("text-overflow" to "ellipsis", "white-space" to "nowrap"))), _tD(unref(data)["multiLineText"]), 5),
                                _cE("text", _uM("style" to _nS(_uM("color" to "#dbd9d9"))), "拍平版本", 4),
                                _cE("text", _uM("class" to "font-size-20", "style" to _nS(_uM("text-overflow" to "ellipsis", "white-space" to "nowrap")), "flatten" to ""), _tD(unref(data)["multiLineText"]), 5)
                            )),
                            _cE("view", _uM("class" to "margin-bottom-10"), _uA(
                                _cE("text", _uM("class" to "font-weight-bold"), "white-space:normal"),
                                _cE("text", _uM("class" to "font-size-20", "style" to _nS(_uM("white-space" to "normal"))), _tD(unref(data)["multiLineText"]), 5),
                                _cE("text", _uM("style" to _nS(_uM("color" to "#dbd9d9"))), "拍平版本", 4),
                                _cE("text", _uM("class" to "font-size-20", "style" to _nS(_uM("white-space" to "normal")), "flatten" to ""), _tD(unref(data)["multiLineText"]), 5)
                            )),
                            _cE("view", _uM("class" to "margin-bottom-10", "style" to _nS(_uM("overflow" to "visible"))), _uA(
                                _cE("text", _uM("class" to "font-weight-bold"), "white-space: nowrap"),
                                _cE("text", _uM("class" to "font-size-20", "style" to _nS(_uM("white-space" to "nowrap", "align-self" to "flex-start"))), _tD(unref(data)["multiLineText"]), 5),
                                _cE("text", _uM("style" to _nS(_uM("color" to "#dbd9d9"))), "拍平版本", 4),
                                _cE("text", _uM("class" to "font-size-20", "style" to _nS(_uM("white-space" to "nowrap", "align-self" to "flex-start")), "flatten" to ""), _tD(unref(data)["multiLineText"]), 5)
                            ), 4),
                            _cE("view", _uM("class" to "margin-bottom-10"), _uA(
                                _cE("text", _uM("class" to "font-weight-bold"), "任意宽度截断（100px、200px、300px）"),
                                _cE("text", _uM("class" to "font-size-20", "style" to _nS(_uM("text-overflow" to "ellipsis", "white-space" to "nowrap", "width" to "100px"))), _tD(unref(data)["multiLineText"]), 5),
                                _cE("text", _uM("style" to _nS(_uM("color" to "#dbd9d9"))), "拍平版本", 4),
                                _cE("text", _uM("class" to "font-size-20", "style" to _nS(_uM("text-overflow" to "ellipsis", "white-space" to "nowrap", "width" to "100px")), "flatten" to ""), _tD(unref(data)["multiLineText"]), 5),
                                _cE("text", _uM("class" to "font-size-20", "style" to _nS(_uM("text-overflow" to "ellipsis", "white-space" to "nowrap", "width" to "200px"))), _tD(unref(data)["multiLineText"]), 5),
                                _cE("text", _uM("style" to _nS(_uM("color" to "#dbd9d9"))), "拍平版本", 4),
                                _cE("text", _uM("class" to "font-size-20", "style" to _nS(_uM("text-overflow" to "ellipsis", "white-space" to "nowrap", "width" to "200px")), "flatten" to ""), _tD(unref(data)["multiLineText"]), 5),
                                _cE("text", _uM("class" to "font-size-20", "style" to _nS(_uM("text-overflow" to "ellipsis", "white-space" to "nowrap", "width" to "300px"))), _tD(unref(data)["multiLineText"]), 5),
                                _cE("text", _uM("style" to _nS(_uM("color" to "#dbd9d9"))), "拍平版本", 4),
                                _cE("text", _uM("class" to "font-size-20", "style" to _nS(_uM("text-overflow" to "ellipsis", "white-space" to "nowrap", "width" to "300px")), "flatten" to ""), _tD(unref(data)["multiLineText"]), 5)
                            )),
                            _cE("view", _uM("class" to "margin-bottom-10"), _uA(
                                _cE("text", _uM("class" to "font-weight-bold"), "lines:1 text-overflow:ellipsis"),
                                _cE("text", _uM("class" to "font-size-20", "style" to _nS(_uM("text-overflow" to "ellipsis", "lines" to "1"))), _tD(unref(data)["multiLineText"]), 5)
                            )),
                            _cE("view", _uM("class" to "margin-bottom-10 uni-common-mt"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 text-overflow ")
                            )),
                            _cE("view", _uM("class" to "common-box"), _uA(
                                _cE("view", _uM("class" to "uni-common-mt"), _uA(
                                    _cE("text", _uM("class" to "uni-title-text"), "text-overflow"),
                                    _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["textOverflow"]), 1),
                                    _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["textOverflowActual"]), 1),
                                    _cE("view", _uM("class" to "test-box"), _uA(
                                        _cE("text", _uM("ref_key" to "textRef", "ref" to textRef, "class" to "font-size-14 test-text", "style" to _nS(_uM("textOverflow" to unref(data)["textOverflow"], "whiteSpace" to "nowrap", "width" to "150px"))), _tD(unref(data)["multiLineText"]), 5)
                                    ))
                                )),
                                _cE("view", _uM("class" to "uni-common-mt"), _uA(
                                    _cE("text", _uM("class" to "uni-title-text"), "拍平"),
                                    _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["textOverflow"]), 1),
                                    _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["textOverflowActualFlat"]), 1),
                                    _cE("view", _uM("class" to "test-box"), _uA(
                                        _cE("text", _uM("ref_key" to "textRefFlat", "ref" to textRefFlat, "class" to "font-size-14 test-text-flatten", "style" to _nS(_uM("textOverflow" to unref(data)["textOverflow"], "whiteSpace" to "nowrap", "width" to "150px")), "flatten" to ""), _tD(unref(data)["multiLineText"]), 5)
                                    ))
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                                _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                                _cV(_component_enum_data, _uM("items" to textOverflowEnum, "title" to "text-overflow 枚举值", "onChange" to radioChangeTextOverflow, "compact" to true)),
                                _cV(_component_input_data, _uM("defaultValue" to unref(data)["textOverflow"], "title" to "text-overflow 自定义值", "type" to "text", "onConfirm" to inputChangeTextOverflow), null, 8, _uA(
                                    "defaultValue"
                                ))
                            ))
                        ), 4)
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
                return _uM("font-size-20" to _pS(_uM("fontSize" to 20)), "font-size-14" to _pS(_uM("fontSize" to 14)), "font-weight-bold" to _pS(_uM("fontWeight" to "bold")), "margin-bottom-10" to _pS(_uM("marginBottom" to 10)), "common-box" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-around")), "test-box" to _pS(_uM("width" to 160, "height" to 80, "backgroundColor" to "#cccccc", "justifyContent" to "center", "alignItems" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
