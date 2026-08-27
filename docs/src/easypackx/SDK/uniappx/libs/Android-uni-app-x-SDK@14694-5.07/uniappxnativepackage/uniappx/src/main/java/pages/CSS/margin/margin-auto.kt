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
open class GenPagesCSSMarginMarginAuto : BasePage {
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
    open var radioChangeMargin: (index: Number) -> Unit
        get() {
            return unref(this.`$exposed`["radioChangeMargin"]) as (index: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "radioChangeMargin", value)
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
        var setup: (__props: GenPagesCSSMarginMarginAuto, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSMarginMarginAuto
            val _cache = __ins.renderCache
            val data = reactive(_uO("margin" to "0 auto", "marginActual" to "", "marginActualText" to "", "marginActualImage" to "", "marginActualFlat" to "", "marginActualTextFlat" to "", "marginActualImageFlat" to ""))
            val viewRef = ref(null as UniElement?)
            val textRef = ref(null as UniTextElement?)
            val imageRef = ref(null as UniImageElement?)
            val viewRefFlat = ref(null as UniElement?)
            val textRefFlat = ref(null as UniTextElement?)
            val imageRefFlat = ref(null as UniImageElement?)
            val marginAutoEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "auto"),
                ItemType(value = 2, name = "0"),
                ItemType(value = 3, name = "20px"),
                ItemType(value = 4, name = "10%")
            ) as UTSArray<ItemType>
            val getPropertyValues = fun(){
                data["marginActual"] = viewRef.value?.style?.getPropertyValue("margin") ?: ""
                data["marginActualFlat"] = viewRefFlat.value?.style?.getPropertyValue("margin") ?: ""
                data["marginActualText"] = textRef.value?.style?.getPropertyValue("margin") ?: ""
                data["marginActualTextFlat"] = textRefFlat.value?.style?.getPropertyValue("margin") ?: ""
                data["marginActualImage"] = imageRef.value?.style?.getPropertyValue("margin") ?: ""
                data["marginActualImageFlat"] = imageRefFlat.value?.style?.getPropertyValue("margin") ?: ""
            }
            val changeMargin = fun(value: String){
                data["margin"] = value
                viewRef.value?.style?.setProperty("margin", value)
                viewRefFlat.value?.style?.setProperty("margin", value)
                textRef.value?.style?.setProperty("margin", value)
                textRefFlat.value?.style?.setProperty("margin", value)
                imageRef.value?.style?.setProperty("margin", value)
                imageRefFlat.value?.style?.setProperty("margin", value)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangeMargin = fun(index: Number){
                val selectedItem = marginAutoEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changeMargin(selectedItem.name)
                }
            }
            val inputChangeMargin = fun(value: String){
                changeMargin(value)
            }
            onReady(fun(){
                getPropertyValues()
            }
            )
            __expose(_uM("radioChangeMargin" to radioChangeMargin, "data" to data))
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1"))), _uA(
                        _cE("text", _uM("class" to "uni-tips"), "说明：左边是正常版本，右边是拍平版本"),
                        _cE("view", null, _uA(
                            _cE("text", null, "margin-left: auto (元素会靠右)"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "demo-item"), _uA(
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("width" to "150px", "margin-left" to "auto"))), null, 4)
                                )),
                                _cE("view", _uM("class" to "demo-item"), _uA(
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("width" to "150px", "margin-left" to "auto")), "flatten" to ""), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "margin-right: auto (元素会靠左)"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "demo-item"), _uA(
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("width" to "150px", "margin-right" to "auto"))), null, 4)
                                )),
                                _cE("view", _uM("class" to "demo-item"), _uA(
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("width" to "150px", "margin-right" to "auto")), "flatten" to ""), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "margin-left: auto; margin-right: auto (水平居中)"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "demo-item"), _uA(
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("width" to "150px", "margin-left" to "auto", "margin-right" to "auto"))), null, 4)
                                )),
                                _cE("view", _uM("class" to "demo-item"), _uA(
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("width" to "150px", "margin-left" to "auto", "margin-right" to "auto")), "flatten" to ""), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "margin: 0 auto (常用的水平居中写法)"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "demo-item"), _uA(
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("width" to "150px", "margin" to "0 auto"))), null, 4)
                                )),
                                _cE("view", _uM("class" to "demo-item"), _uA(
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("width" to "150px", "margin" to "0 auto")), "flatten" to ""), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "margin: auto (所有方向auto)"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "demo-item demo-item-tall"), _uA(
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("width" to "150px", "height" to "80px", "margin" to "auto"))), null, 4)
                                )),
                                _cE("view", _uM("class" to "demo-item demo-item-tall"), _uA(
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("width" to "150px", "height" to "80px", "margin" to "auto")), "flatten" to ""), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "margin: 10px auto (垂直固定，水平auto)"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "demo-item demo-item-medium"), _uA(
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("width" to "150px", "margin" to "10px auto"))), null, 4)
                                )),
                                _cE("view", _uM("class" to "demo-item demo-item-medium"), _uA(
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("width" to "150px", "margin" to "10px auto")), "flatten" to ""), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "margin: auto 20px (垂直auto，水平固定)"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "demo-item"), _uA(
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("width" to "150px", "margin" to "auto 20px"))), null, 4)
                                )),
                                _cE("view", _uM("class" to "demo-item"), _uA(
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("width" to "150px", "margin" to "auto 20px")), "flatten" to ""), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "对比: 无margin (默认左对齐)"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "demo-item"), _uA(
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("width" to "150px"))), null, 4)
                                )),
                                _cE("view", _uM("class" to "demo-item"), _uA(
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("width" to "150px")), "flatten" to ""), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "scroll-view 组件")
                        )),
                        _cE("view", null, _uA(
                            _cE("text", _uM("class" to "uni-subtitle-text"), "margin-left: auto (元素会靠右) 和 margin-right: auto (元素会靠左)"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "demo-item"), _uA(
                                    _cE("scroll-view", _uM("class" to "scroll-view-test", "style" to _nS(_uM("margin-left" to "auto"))), null, 4)
                                )),
                                _cE("view", _uM("class" to "demo-item"), _uA(
                                    _cE("scroll-view", _uM("class" to "scroll-view-test", "style" to _nS(_uM("margin-right" to "auto"))), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", _uM("class" to "uni-subtitle-text"), "margin: auto 20px (垂直auto，水平固定) 和 margin: auto;(水平居中)"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "demo-item"), _uA(
                                    _cE("scroll-view", _uM("class" to "scroll-view-test", "style" to _nS(_uM("margin" to "auto 20px"))), null, 4)
                                )),
                                _cE("view", _uM("class" to "demo-item"), _uA(
                                    _cE("scroll-view", _uM("class" to "scroll-view-test", "style" to _nS(_uM("margin" to "auto"))), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 margin ")
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["margin"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["marginActual"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("ref_key" to "viewRef", "ref" to viewRef, "class" to "common test-view", "style" to _nS(_uA(
                                        _uM("width" to "100px"),
                                        _uM("margin" to unref(data)["margin"])
                                    ))), _uA(
                                        _cE("text", _uM("class" to "common-text"), "view")
                                    ), 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["margin"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["marginActualText"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRef", "ref" to textRef, "class" to "common-text test-text", "style" to _nS(_uA(
                                        _uM("width" to "100px"),
                                        _uM("margin" to unref(data)["margin"])
                                    ))), "text", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["margin"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["marginActualImage"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("ref_key" to "imageRef", "ref" to imageRef, "class" to "common-image test-image", "style" to _nS(_uM("margin" to unref(data)["margin"])), "src" to "/static/test-image/logo.png"), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["margin"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["marginActualFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("ref_key" to "viewRefFlat", "ref" to viewRefFlat, "class" to "common test-view-flatten", "style" to _nS(_uA(
                                        _uM("width" to "100px"),
                                        _uM("margin" to unref(data)["margin"])
                                    )), "flatten" to ""), _uA(
                                        _cE("text", _uM("class" to "common-text"), "view")
                                    ), 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["margin"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["marginActualTextFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRefFlat", "ref" to textRefFlat, "class" to "common-text test-text-flatten", "style" to _nS(_uA(
                                        _uM("width" to "100px"),
                                        _uM("margin" to unref(data)["margin"])
                                    )), "flatten" to ""), "text", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["margin"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["marginActualImageFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("ref_key" to "imageRefFlat", "ref" to imageRefFlat, "class" to "common-image test-image-flatten", "style" to _nS(_uM("margin" to unref(data)["margin"])), "flatten" to "", "src" to "/static/test-image/logo.png"), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                            _cV(_component_enum_data, _uM("items" to marginAutoEnum, "title" to "margin 枚举值", "onChange" to radioChangeMargin, "compact" to true)),
                            _cV(_component_input_data, _uM("defaultValue" to unref(data)["margin"], "title" to "margin 自定义值", "type" to "text", "onConfirm" to inputChangeMargin), null, 8, _uA(
                                "defaultValue"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mb"), _uA(
                            _cE("text", null, "native-view组件: margin-left: auto 和 margin: auto"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "demo-item"), _uA(
                                    _cE("native-view", _uM("class" to "common", "style" to _nS(_uM("width" to "150px", "margin-left" to "auto"))), null, 4)
                                )),
                                _cE("view", _uM("class" to "demo-item"), _uA(
                                    _cE("native-view", _uM("class" to "common", "style" to _nS(_uM("width" to "150px", "margin" to "auto"))), null, 4)
                                ))
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
                return _uM("common" to _pS(_uM("height" to 50, "backgroundColor" to "#008000")), "demo-box" to _pS(_uM("flexDirection" to "row", "marginTop" to 10, "justifyContent" to "space-around")), "demo-item" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 10, "marginBottom" to 0, "marginLeft" to 10, "height" to 100, "backgroundColor" to "#808080")), "demo-item-medium" to _pS(_uM("height" to 120)), "demo-item-tall" to _pS(_uM("height" to 150)), "scroll-view-test" to _pS(_uM("width" to 100, "height" to 100, "backgroundColor" to "#008000")), "common-text" to _pS(_uM("height" to 50, "backgroundColor" to "#008000", "fontSize" to 14, "color" to "#FFFFFF")), "common-image" to _pS(_uM("width" to 50, "height" to 50, "backgroundColor" to "#008000")), "test-container" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "marginTop" to 10)), "test-item" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 5, "marginBottom" to 0, "marginLeft" to 5)), "test-box" to _pS(_uM("width" to "100%", "height" to 100, "backgroundColor" to "#808080")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
