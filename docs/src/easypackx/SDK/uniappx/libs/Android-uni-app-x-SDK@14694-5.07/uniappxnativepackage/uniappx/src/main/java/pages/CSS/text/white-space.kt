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
open class GenPagesCSSTextWhiteSpace : BasePage {
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
    open var radioChangeWhiteSpace: (index: Number) -> Unit
        get() {
            return unref(this.`$exposed`["radioChangeWhiteSpace"]) as (index: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "radioChangeWhiteSpace", value)
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
        var setup: (__props: GenPagesCSSTextWhiteSpace, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSTextWhiteSpace
            val _cache = __ins.renderCache
            val whiteSpaceEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "normal"),
                ItemType(value = 2, name = "nowrap"),
                ItemType(value = 3, name = "pre"),
                ItemType(value = 4, name = "pre-wrap"),
                ItemType(value = 5, name = "pre-line"),
                ItemType(value = 6, name = "break-spaces"),
                ItemType(value = 7, name = "keep")
            ) as UTSArray<ItemType>
            val data = reactive(_uO("multiLineText" to "HBuilderX，\n\t轻巧、\n\t\t极速，\n\t\t\t极客编辑器；\n\t\t\t\tuni-app x，\n\t\t\t\t\t终极跨平台方案；\n\t\t\t\tuts，\n\t\t\t大一统语言\n\nHBuilderX，轻巧、极速，极客编辑器；uni-app x，终极跨平台方案；uts，大一统语言", "whiteSpace" to "normal", "whiteSpaceActual" to "", "whiteSpaceActualFlat" to ""))
            val textRef = ref(null as UniTextElement?)
            val textRefFlat = ref(null as UniTextElement?)
            val getPropertyValues = fun(){
                data["whiteSpaceActual"] = textRef.value?.style?.getPropertyValue("white-space") ?: ""
                data["whiteSpaceActualFlat"] = textRefFlat.value?.style?.getPropertyValue("white-space") ?: ""
            }
            val changeWhiteSpace = fun(value: String){
                data["whiteSpace"] = value
                textRef.value?.style?.setProperty("white-space", value)
                textRefFlat.value?.style?.setProperty("white-space", value)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangeWhiteSpace = fun(index: Number){
                val selectedItem = whiteSpaceEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changeWhiteSpace(selectedItem.name)
                }
            }
            val inputChangeWhiteSpace = fun(value: String){
                changeWhiteSpace(value)
            }
            onReady(fun(){
                getPropertyValues()
            }
            )
            __expose(_uM("radioChangeWhiteSpace" to radioChangeWhiteSpace, "data" to data))
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1"))), _uA(
                        _cE("scroll-view", _uM("style" to _nS(_uM("padding" to "10px 0px", "background-color" to "gray", "justify-content" to "center")), "direction" to "horizontal"), _uA(
                            _cE("text", _uM("class" to "text", "style" to _nS(_uM("whiteSpace" to unref(data)["whiteSpace"]))), _tD(unref(data)["multiLineText"]), 5)
                        ), 4),
                        _cE("text", null, "拍平"),
                        _cE("scroll-view", _uM("style" to _nS(_uM("padding" to "10px 0px", "background-color" to "gray", "justify-content" to "center")), "direction" to "horizontal"), _uA(
                            _cE("text", _uM("class" to "text", "style" to _nS(_uM("whiteSpace" to unref(data)["whiteSpace"])), "flatten" to ""), _tD(unref(data)["multiLineText"]), 5)
                        ), 4),
                        _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                            _cE("view", _uM("class" to "content uni-common-mt"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 white-space ")
                            )),
                            _cE("view", _uM("class" to "common-box"), _uA(
                                _cE("view", _uM("class" to "uni-common-mt"), _uA(
                                    _cE("text", _uM("class" to "uni-title-text"), "white-space"),
                                    _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["whiteSpace"]), 1),
                                    _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["whiteSpaceActual"]), 1),
                                    _cE("view", _uM("class" to "test-box"), _uA(
                                        _cE("text", _uM("ref_key" to "textRef", "ref" to textRef, "class" to "text test-text", "style" to _nS(_uM("whiteSpace" to unref(data)["whiteSpace"]))), _tD(unref(data)["multiLineText"]), 5)
                                    ))
                                )),
                                _cE("view", _uM("class" to "uni-common-mt"), _uA(
                                    _cE("text", _uM("class" to "uni-title-text"), "拍平"),
                                    _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["whiteSpace"]), 1),
                                    _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["whiteSpaceActualFlat"]), 1),
                                    _cE("view", _uM("class" to "test-box"), _uA(
                                        _cE("text", _uM("ref_key" to "textRefFlat", "ref" to textRefFlat, "class" to "text test-text-flatten", "style" to _nS(_uM("whiteSpace" to unref(data)["whiteSpace"])), "flatten" to ""), _tD(unref(data)["multiLineText"]), 5)
                                    ))
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                                _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                                _cV(_component_enum_data, _uM("items" to whiteSpaceEnum, "title" to "white-space 枚举值", "onChange" to radioChangeWhiteSpace, "compact" to true)),
                                _cV(_component_input_data, _uM("defaultValue" to unref(data)["whiteSpace"], "title" to "white-space 自定义值", "type" to "text", "onConfirm" to inputChangeWhiteSpace), null, 8, _uA(
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
                return _uM("text" to _pS(_uM("fontSize" to 16, "alignSelf" to "flex-start")), "common-box" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-around")), "test-box" to _pS(_uM("width" to 180, "height" to 200, "backgroundColor" to "#808080", "justifyContent" to "center", "alignItems" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
