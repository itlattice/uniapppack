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
open class GenPagesCSSFlexAlignItems : BasePage {
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
    open var radioChangeAlignItems: (index: Number) -> Unit
        get() {
            return unref(this.`$exposed`["radioChangeAlignItems"]) as (index: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "radioChangeAlignItems", value)
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
        var setup: (__props: GenPagesCSSFlexAlignItems, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSFlexAlignItems
            val _cache = __ins.renderCache
            val alignItemsEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "flex-start"),
                ItemType(value = 2, name = "flex-end"),
                ItemType(value = 3, name = "center"),
                ItemType(value = 4, name = "stretch")
            ) as UTSArray<ItemType>
            val data = reactive(_uO("alignItems" to "center", "alignItemsActual" to "", "alignItemsActualFlat" to ""))
            val viewRef = ref(null as UniElement?)
            val viewRefFlat = ref(null as UniElement?)
            val getPropertyValues = fun(){
                data["alignItemsActual"] = viewRef.value?.style?.getPropertyValue("align-items") ?: ""
                data["alignItemsActualFlat"] = viewRefFlat.value?.style?.getPropertyValue("align-items") ?: ""
            }
            val changeAlignItems = fun(value: String){
                data["alignItems"] = value
                viewRef.value?.style?.setProperty("align-items", value)
                viewRefFlat.value?.style?.setProperty("align-items", value)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangeAlignItems = fun(index: Number){
                val selectedItem = alignItemsEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changeAlignItems(selectedItem.name)
                }
            }
            val inputChangeAlignItems = fun(value: String){
                changeAlignItems(value)
            }
            onReady(fun(){
                getPropertyValues()
            }
            )
            __expose(_uM("radioChangeAlignItems" to radioChangeAlignItems, "data" to data))
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1"))), _uA(
                        _cE("text", _uM("class" to "uni-tips"), "说明：左边是正常版本，右边是拍平版本"),
                        _cE("view", null, _uA(
                            _cE("text", null, "align-items: center"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("align-items" to "center"))), _uA(
                                    _cE("view", _uM("class" to "flex-item red")),
                                    _cE("view", _uM("class" to "flex-item green")),
                                    _cE("view", _uM("class" to "flex-item blue"))
                                ), 4),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("align-items" to "center")), "flatten" to ""), _uA(
                                    _cE("view", _uM("class" to "flex-item red")),
                                    _cE("view", _uM("class" to "flex-item green")),
                                    _cE("view", _uM("class" to "flex-item blue"))
                                ), 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "align-items: flex-start"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("align-items" to "flex-start"))), _uA(
                                    _cE("view", _uM("class" to "flex-item red")),
                                    _cE("view", _uM("class" to "flex-item green")),
                                    _cE("view", _uM("class" to "flex-item blue"))
                                ), 4),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("align-items" to "flex-start")), "flatten" to ""), _uA(
                                    _cE("view", _uM("class" to "flex-item red")),
                                    _cE("view", _uM("class" to "flex-item green")),
                                    _cE("view", _uM("class" to "flex-item blue"))
                                ), 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "align-items: flex-end"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("align-items" to "flex-end"))), _uA(
                                    _cE("view", _uM("class" to "flex-item red")),
                                    _cE("view", _uM("class" to "flex-item green")),
                                    _cE("view", _uM("class" to "flex-item blue"))
                                ), 4),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("align-items" to "flex-end")), "flatten" to ""), _uA(
                                    _cE("view", _uM("class" to "flex-item red")),
                                    _cE("view", _uM("class" to "flex-item green")),
                                    _cE("view", _uM("class" to "flex-item blue"))
                                ), 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "align-items: stretch"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("align-items" to "stretch"))), _uA(
                                    _cE("view", _uM("class" to "flex-item-stretch red")),
                                    _cE("view", _uM("class" to "flex-item-stretch green")),
                                    _cE("view", _uM("class" to "flex-item-stretch blue"))
                                ), 4),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("align-items" to "stretch")), "flatten" to ""), _uA(
                                    _cE("view", _uM("class" to "flex-item-stretch red")),
                                    _cE("view", _uM("class" to "flex-item-stretch green")),
                                    _cE("view", _uM("class" to "flex-item-stretch blue"))
                                ), 4)
                            ))
                        ))
                    ), 4),
                    _cE("view", null, _uA(
                        _cE("text", null, "text组件 align-items: center"),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("view", _uM("class" to "common", "style" to _nS(_uM("align-items" to "center"))), _uA(
                                _cE("text", _uM("class" to "flex-item red"), "text1"),
                                _cE("text", _uM("class" to "flex-item green"), "text2"),
                                _cE("text", _uM("class" to "flex-item blue"), "text3")
                            ), 4),
                            _cE("view", _uM("class" to "common", "style" to _nS(_uM("align-items" to "center")), "flatten" to ""), _uA(
                                _cE("text", _uM("class" to "flex-item red"), "text1"),
                                _cE("text", _uM("class" to "flex-item green"), "text2"),
                                _cE("text", _uM("class" to "flex-item blue"), "text3")
                            ), 4)
                        ))
                    )),
                    _cE("view", _uM("class" to "uni-common-mt"), _uA(
                        _cE("text", _uM("class" to "uni-title-text"), "scroll-view 组件")
                    )),
                    _cE("view", null, _uA(
                        _cE("text", _uM("class" to "uni-subtitle-text"), "align-items: center; 和 align-items: flex-start;"),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("scroll-view", _uM("class" to "common", "style" to _nS(_uM("align-items" to "center")), "direction" to "horizontal"), _uA(
                                _cE("view", _uM("class" to "flex-item red")),
                                _cE("view", _uM("class" to "flex-item green")),
                                _cE("view", _uM("class" to "flex-item blue"))
                            ), 4),
                            _cE("scroll-view", _uM("class" to "common", "style" to _nS(_uM("align-items" to "flex-start")), "direction" to "horizontal"), _uA(
                                _cE("view", _uM("class" to "flex-item red")),
                                _cE("view", _uM("class" to "flex-item green")),
                                _cE("view", _uM("class" to "flex-item blue"))
                            ), 4)
                        ))
                    )),
                    _cE("view", _uM("class" to "uni-common-mt"), _uA(
                        _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 align-items ")
                    )),
                    _cE("view", _uM("class" to "common-box"), _uA(
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "align-items"),
                            _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["alignItems"]), 1),
                            _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["alignItemsActual"]), 1),
                            _cE("view", _uM("class" to "test-box"), _uA(
                                _cE("view", _uM("ref_key" to "viewRef", "ref" to viewRef, "class" to "test-flex-container test-view", "style" to _nS(_uM("alignItems" to unref(data)["alignItems"]))), _uA(
                                    _cE("view", _uM("class" to "test-item-small red")),
                                    _cE("view", _uM("class" to "test-item-small green")),
                                    _cE("view", _uM("class" to "test-item-small blue"))
                                ), 4)
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "拍平"),
                            _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["alignItems"]), 1),
                            _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["alignItemsActualFlat"]), 1),
                            _cE("view", _uM("class" to "test-box"), _uA(
                                _cE("view", _uM("ref_key" to "viewRefFlat", "ref" to viewRefFlat, "class" to "test-flex-container test-view-flatten", "style" to _nS(_uM("alignItems" to unref(data)["alignItems"])), "flatten" to ""), _uA(
                                    _cE("view", _uM("class" to "test-item-small red")),
                                    _cE("view", _uM("class" to "test-item-small green")),
                                    _cE("view", _uM("class" to "test-item-small blue"))
                                ), 4)
                            ))
                        ))
                    )),
                    _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                        _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                        _cV(_component_enum_data, _uM("items" to alignItemsEnum, "title" to "align-items 枚举值", "onChange" to radioChangeAlignItems, "compact" to true)),
                        _cV(_component_input_data, _uM("defaultValue" to unref(data)["alignItems"], "title" to "align-items 自定义值", "type" to "text", "onConfirm" to inputChangeAlignItems), null, 8, _uA(
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
                return _uM("demo-box" to _pS(_uM("flexDirection" to "row", "marginTop" to 10, "justifyContent" to "space-around")), "flex-item" to _pS(_uM("width" to 40, "height" to 40)), "flex-item-stretch" to _pS(_uM("width" to 40)), "red" to _pS(_uM("backgroundColor" to "#FF0000")), "green" to _pS(_uM("backgroundColor" to "#008000")), "blue" to _pS(_uM("backgroundColor" to "#0000FF")), "common" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 10, "marginBottom" to 0, "marginLeft" to 10, "height" to 100, "backgroundColor" to "#808080", "flexDirection" to "row")), "common-scroll" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 10, "marginBottom" to 0, "marginLeft" to 10, "height" to 100, "backgroundColor" to "#808080", "flexDirection" to "row")), "common-box" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-around")), "test-box" to _pS(_uM("width" to 180, "height" to 150, "backgroundColor" to "#808080")), "test-flex-container" to _pS(_uM("width" to "100%", "height" to "100%", "backgroundColor" to "#808080", "flexDirection" to "row")), "test-item-small" to _pS(_uM("width" to 30, "height" to 30)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
