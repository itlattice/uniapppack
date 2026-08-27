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
open class GenPagesCSSTextTextDecorationLine : BasePage {
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
    open var radioChangeTextDecorationLine: (index: Number) -> Unit
        get() {
            return unref(this.`$exposed`["radioChangeTextDecorationLine"]) as (index: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "radioChangeTextDecorationLine", value)
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
        var setup: (__props: GenPagesCSSTextTextDecorationLine, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSTextTextDecorationLine
            val _cache = __ins.renderCache
            val textDecorationLineEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "none"),
                ItemType(value = 2, name = "underline"),
                ItemType(value = 3, name = "line-through")
            ) as UTSArray<ItemType>
            val data = reactive(_uO("textDecorationLine" to "none", "textDecorationLineActual" to "", "textDecorationLineActualFlat" to ""))
            val textRef = ref(null as UniTextElement?)
            val textRefFlat = ref(null as UniTextElement?)
            val getPropertyValues = fun(){
                data["textDecorationLineActual"] = textRef.value?.style?.getPropertyValue("text-decoration-line") ?: ""
                data["textDecorationLineActualFlat"] = textRefFlat.value?.style?.getPropertyValue("text-decoration-line") ?: ""
            }
            val changeTextDecorationLine = fun(value: String){
                data["textDecorationLine"] = value
                textRef.value?.style?.setProperty("text-decoration-line", value)
                textRefFlat.value?.style?.setProperty("text-decoration-line", value)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangeTextDecorationLine = fun(index: Number){
                val selectedItem = textDecorationLineEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changeTextDecorationLine(selectedItem.name)
                }
            }
            val inputChangeTextDecorationLine = fun(value: String){
                changeTextDecorationLine(value)
            }
            onReady(fun(){
                getPropertyValues()
            }
            )
            __expose(_uM("radioChangeTextDecorationLine" to radioChangeTextDecorationLine, "data" to data))
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1"))), _uA(
                        _cE("view", _uM("class" to "content"), _uA(
                            _cE("text", _uM("style" to _nS(_uM("text-decoration-line" to "underline"))), "text-decoration-line: underline 下划线 底部易重叠字符：,.9pQqyzgj;\\{}[]", 4),
                            _cE("text", _uM("style" to _nS(_uM("text-decoration-line" to "line-through"))), "text-decoration-line: line-through 删除线 较多文字测试换行和裁剪效果", 4)
                        )),
                        _cE("view", _uM("class" to "content"), _uA(
                            _cE("text", _uM("style" to _nS(_uM("text-decoration-line" to "underline")), "flatten" to ""), "text-decoration-line: underline flatten", 4),
                            _cE("text", _uM("style" to _nS(_uM("text-decoration-line" to "line-through")), "flatten" to ""), "text-decoration-line: line-through flatten", 4)
                        )),
                        _cE("view", _uM("class" to "content"), _uA(
                            _cE("text", _uM("class" to "common", "style" to _nS(_uM("text-decoration-line" to "underline", "color" to "blue", "text-overflow" to "ellipsis", "width" to "200px", "white-space" to "nowrap"))), "下划线颜色和ellipsis组合", 4),
                            _cE("text", _uM("class" to "common", "style" to _nS(_uM("text-decoration-line" to "line-through", "color" to "blue", "text-overflow" to "ellipsis", "width" to "200px", "white-space" to "nowrap"))), "删除线颜色和ellipsis组合", 4)
                        )),
                        _cE("view", _uM("style" to _nS(_uM("background-color" to "gray", "justify-content" to "center", "align-items" to "center", "margin-bottom" to "16px"))), _uA(
                            _cE("text", _uM("class" to "common", "style" to _nS(_uM("text-decoration-line" to "underline", "color" to "blue")), "flatten" to ""), "text-decoration-line: underline 自适应宽高且拍平", 4),
                            _cE("text", _uM("class" to "common", "style" to _nS(_uM("text-decoration-line" to "line-through", "color" to "blue")), "flatten" to ""), "text-decoration-line: line-through 自适应宽高且拍平", 4)
                        ), 4),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 text-decoration-line ")
                        )),
                        _cE("view", _uM("class" to "common-box"), _uA(
                            _cE("view", _uM("class" to "uni-common-mt"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "text-decoration-line"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["textDecorationLine"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["textDecorationLineActual"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRef", "ref" to textRef, "class" to "common test-text", "style" to _nS(_uM("textDecorationLine" to unref(data)["textDecorationLine"]))), "当前 text-decoration-line: " + _tD(unref(data)["textDecorationLine"]), 5)
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-common-mt"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["textDecorationLine"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["textDecorationLineActualFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRefFlat", "ref" to textRefFlat, "class" to "common test-text-flatten", "style" to _nS(_uM("textDecorationLine" to unref(data)["textDecorationLine"])), "flatten" to ""), "当前 text-decoration-line: " + _tD(unref(data)["textDecorationLine"]), 5)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                            _cV(_component_enum_data, _uM("items" to textDecorationLineEnum, "title" to "text-decoration-line 枚举值", "onChange" to radioChangeTextDecorationLine, "compact" to true)),
                            _cV(_component_input_data, _uM("defaultValue" to unref(data)["textDecorationLine"], "title" to "text-decoration-line 自定义值", "type" to "text", "onConfirm" to inputChangeTextDecorationLine), null, 8, _uA(
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
                return _uM("common" to _pS(_uM("fontSize" to 20)), "content" to _pS(_uM("width" to 200, "height" to 100, "backgroundColor" to "#808080", "justifyContent" to "center", "alignItems" to "center", "marginBottom" to 16)), "common-box" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-around")), "test-box" to _pS(_uM("width" to 180, "height" to 80, "backgroundColor" to "#808080", "justifyContent" to "center", "alignItems" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
