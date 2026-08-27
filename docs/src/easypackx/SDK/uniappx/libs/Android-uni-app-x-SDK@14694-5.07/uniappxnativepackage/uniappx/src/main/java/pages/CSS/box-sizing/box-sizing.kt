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
open class GenPagesCSSBoxSizingBoxSizing : BasePage {
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
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesCSSBoxSizingBoxSizing) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSBoxSizingBoxSizing
            val _cache = __ins.renderCache
            val boxSizingEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "content-box"),
                ItemType(value = 2, name = "border-box")
            ) as UTSArray<ItemType>
            val boxSizing = ref("content-box")
            val boxSizingActual = ref("")
            val boxSizingActualText = ref("")
            val boxSizingActualImage = ref("")
            val boxSizingActualFlat = ref("")
            val boxSizingActualTextFlat = ref("")
            val boxSizingActualImageFlat = ref("")
            val viewRef = ref(null as UniElement?)
            val textRef = ref(null as UniTextElement?)
            val imageRef = ref(null as UniImageElement?)
            val viewRefFlat = ref(null as UniElement?)
            val textRefFlat = ref(null as UniTextElement?)
            val imageRefFlat = ref(null as UniImageElement?)
            val getPropertyValues = fun(){
                boxSizingActual.value = viewRef.value?.style?.getPropertyValue("box-sizing") ?: ""
                boxSizingActualFlat.value = viewRefFlat.value?.style?.getPropertyValue("box-sizing") ?: ""
                boxSizingActualText.value = textRef.value?.style?.getPropertyValue("box-sizing") ?: ""
                boxSizingActualTextFlat.value = textRefFlat.value?.style?.getPropertyValue("box-sizing") ?: ""
                boxSizingActualImage.value = imageRef.value?.style?.getPropertyValue("box-sizing") ?: ""
                boxSizingActualImageFlat.value = imageRefFlat.value?.style?.getPropertyValue("box-sizing") ?: ""
            }
            val changeBoxSizing = fun(value: String){
                boxSizing.value = value
                viewRef.value?.style?.setProperty("box-sizing", value)
                viewRefFlat.value?.style?.setProperty("box-sizing", value)
                textRef.value?.style?.setProperty("box-sizing", value)
                textRefFlat.value?.style?.setProperty("box-sizing", value)
                imageRef.value?.style?.setProperty("box-sizing", value)
                imageRefFlat.value?.style?.setProperty("box-sizing", value)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangeBoxSizing = fun(index: Number){
                val selectedItem = boxSizingEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changeBoxSizing(selectedItem.name)
                }
            }
            val inputChangeBoxSizing = fun(value: String){
                changeBoxSizing(value)
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
                        _cE("view", null, _uA(
                            _cE("text", _uM("class" to "desc-text"), "content-box（标准盒模型，默认值）"),
                            _cE("text", _uM("class" to "help-text"), "width 只包括内容宽度，padding 和 border 在盒子外部向外扩展"),
                            _cE("text", _uM("class" to "help-text"), "设置 width: 100px, padding: 10px, border: 10px")
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("view", _uM("class" to "compare-container"), _uA(
                                _cE("view", _uM("class" to "compare-box", "style" to _nS(_uM("box-sizing" to "content-box"))), _uA(
                                    _cE("text", _uM("class" to "box-label"), "content-box"),
                                    _cE("text", _uM("class" to "box-info"), "内容区: 100px")
                                ), 4)
                            )),
                            _cE("text", _uM("class" to "calc-text"), "实际占用宽度 = 100(内容) + 20(padding) + 20(border) = 140px")
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "help-text"), "拍平"),
                            _cE("view", _uM("class" to "compare-container"), _uA(
                                _cE("view", _uM("class" to "compare-box", "style" to _nS(_uM("box-sizing" to "content-box")), "flatten" to ""), _uA(
                                    _cE("text", _uM("class" to "box-label"), "content-box 拍平"),
                                    _cE("text", _uM("class" to "box-info"), "内容区: 100px")
                                ), 4)
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "desc-text"), "border-box"),
                            _cE("text", _uM("class" to "help-text"), "width 包括 border + padding + 内容，padding 和 border 在盒子内部向内挤压"),
                            _cE("text", _uM("class" to "help-text"), "设置 width: 100px, padding: 10px, border: 10px")
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("view", _uM("class" to "compare-container"), _uA(
                                _cE("view", _uM("class" to "compare-box", "style" to _nS(_uM("box-sizing" to "border-box"))), _uA(
                                    _cE("text", _uM("class" to "box-label"), "border-box"),
                                    _cE("text", _uM("class" to "box-info"), "内容区: 60px")
                                ), 4)
                            )),
                            _cE("text", _uM("class" to "calc-text"), "实际占用宽度 = 100px（width 设置值）"),
                            _cE("text", _uM("class" to "calc-text"), "内容宽度 = 100 - 20(padding) - 20(border) = 60px")
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "help-text"), "拍平"),
                            _cE("view", _uM("class" to "compare-container"), _uA(
                                _cE("view", _uM("class" to "compare-box", "style" to _nS(_uM("box-sizing" to "border-box")), "flatten" to ""), _uA(
                                    _cE("text", _uM("class" to "box-label"), "border-box 拍平"),
                                    _cE("text", _uM("class" to "box-info"), "内容区: 60px")
                                ), 4)
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "title-text"), "并排对比（左：content-box 140px，右：border-box 100px）"),
                            _cE("text", _uM("class" to "help-text"), "设置 width: 100px, padding: 10px, border: 10px")
                        )),
                        _cE("view", _uM("class" to "uni-common-mt side-by-side"), _uA(
                            _cE("view", _uM("class" to "compare-box", "style" to _nS(_uM("box-sizing" to "content-box"))), _uA(
                                _cE("text", _uM("class" to "box-label-small"), "content-box")
                            ), 4),
                            _cE("view", _uM("class" to "compare-box", "style" to _nS(_uM("box-sizing" to "border-box", "margin-left" to "10px"))), _uA(
                                _cE("text", _uM("class" to "box-label-small"), "border-box")
                            ), 4)
                        )),
                        _cE("text", _uM("class" to "uni-title-text uni-common-mt"), "scroll-view 组件"),
                        _cE("text", _uM("class" to "help-text"), "设置 width: 100px, padding: 10px, border: 10px"),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("scroll-view", _uM("class" to "common scroll-view-box-sizing", "style" to _nS(_uM("box-sizing" to "content-box"))), _uA(
                                _cE("text", _uM("class" to "box-label-small"), "content-box")
                            ), 4),
                            _cE("scroll-view", _uM("class" to "common scroll-view-box-sizing", "style" to _nS(_uM("box-sizing" to "border-box"))), _uA(
                                _cE("text", _uM("class" to "box-label-small"), "border-box")
                            ), 4)
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 box-sizing "),
                            _cE("text", _uM("class" to "help-text"), "设置 width: 60px, padding: 10px, border: 10px")
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(boxSizing)), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(boxSizingActual)), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("ref_key" to "viewRef", "ref" to viewRef, "class" to "common", "style" to _nS(_uM("boxSizing" to unref(boxSizing)))), _uA(
                                        _cE("text", _uM("class" to "common-text font-size-12"), "view")
                                    ), 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(boxSizing)), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(boxSizingActualText)), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRef", "ref" to textRef, "class" to "common font-size-12", "style" to _nS(_uM("boxSizing" to unref(boxSizing)))), "text", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(boxSizing)), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(boxSizingActualImage)), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("ref_key" to "imageRef", "ref" to imageRef, "class" to "common", "style" to _nS(_uM("boxSizing" to unref(boxSizing))), "src" to "/static/test-image/logo.png"), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(boxSizing)), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(boxSizingActualFlat)), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("ref_key" to "viewRefFlat", "ref" to viewRefFlat, "class" to "common", "style" to _nS(_uM("boxSizing" to unref(boxSizing))), "flatten" to ""), _uA(
                                        _cE("text", _uM("class" to "common-text font-size-12"), "view")
                                    ), 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(boxSizing)), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(boxSizingActualTextFlat)), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRefFlat", "ref" to textRefFlat, "class" to "common font-size-12", "style" to _nS(_uM("boxSizing" to unref(boxSizing))), "flatten" to ""), "text", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(boxSizing)), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(boxSizingActualImageFlat)), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("ref_key" to "imageRefFlat", "ref" to imageRefFlat, "class" to "common", "style" to _nS(_uM("boxSizing" to unref(boxSizing))), "flatten" to "", "src" to "/static/test-image/logo.png"), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                            _cV(_component_enum_data, _uM("items" to boxSizingEnum, "title" to "box-sizing 枚举值", "onChange" to radioChangeBoxSizing, "compact" to true)),
                            _cV(_component_input_data, _uM("defaultValue" to unref(boxSizing), "title" to "box-sizing 自定义值", "type" to "text", "onConfirm" to inputChangeBoxSizing), null, 8, _uA(
                                "defaultValue"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mb"), _uA(
                            _cE("text", null, "native-view组件: box-sizing: content-box 和 border-box"),
                            _cE("text", _uM("class" to "help-text"), "设置 width: 100px, padding: 10px, border: 10px"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("native-view", _uM("class" to "scroll-view-box-sizing", "style" to _nS(_uM("box-sizing" to "content-box"))), null, 4),
                                _cE("native-view", _uM("class" to "scroll-view-box-sizing", "style" to _nS(_uM("box-sizing" to "border-box"))), null, 4)
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
                return _uM("desc-text" to _pS(_uM("fontSize" to 14, "color" to "#333333", "fontWeight" to "bold", "lineHeight" to "22px")), "title-text" to _pS(_uM("fontSize" to 16, "color" to "#333333", "fontWeight" to "bold")), "help-text" to _pS(_uM("fontSize" to 12, "color" to "#666666", "marginTop" to 5, "lineHeight" to "18px")), "calc-text" to _pS(_uM("fontSize" to 13, "color" to "#ff6b6b", "fontWeight" to "bold", "marginTop" to 5, "lineHeight" to "20px")), "side-by-side" to _pS(_uM("flexDirection" to "row", "alignItems" to "flex-start")), "compare-container" to _pS(_uM("backgroundColor" to "#f5f5f5", "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "dashed", "borderRightStyle" to "dashed", "borderBottomStyle" to "dashed", "borderLeftStyle" to "dashed", "borderTopColor" to "#999999", "borderRightColor" to "#999999", "borderBottomColor" to "#999999", "borderLeftColor" to "#999999")), "compare-box" to _pS(_uM("width" to 100, "height" to 80, "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "borderTopWidth" to 10, "borderRightWidth" to 10, "borderBottomWidth" to 10, "borderLeftWidth" to 10, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#00FFFF", "borderRightColor" to "#00FFFF", "borderBottomColor" to "#00FFFF", "borderLeftColor" to "#00FFFF", "backgroundColor" to "#4ecdc4", "justifyContent" to "center", "alignItems" to "center")), "box-label" to _pS(_uM("fontSize" to 13, "color" to "#ffffff", "fontWeight" to "bold", "textAlign" to "center")), "box-label-small" to _pS(_uM("fontSize" to 12, "color" to "#ffffff", "fontWeight" to "bold", "textAlign" to "center")), "box-info" to _pS(_uM("fontSize" to 10, "color" to "#ffffff", "textAlign" to "center", "marginTop" to 3)), "common" to _pS(_uM("width" to 60, "height" to 60, "backgroundColor" to "#00FFFF", "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "borderTopWidth" to 10, "borderRightWidth" to 10, "borderBottomWidth" to 10, "borderLeftWidth" to 10, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#d8dde5", "borderRightColor" to "#d8dde5", "borderBottomColor" to "#d8dde5", "borderLeftColor" to "#d8dde5")), "common-text" to _pS(_uM("width" to 50)), "font-size-12" to _pS(_uM("fontSize" to 12)), "test-container" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "marginTop" to 10)), "test-item" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 5, "marginBottom" to 0, "marginLeft" to 5)), "test-box" to _pS(_uM("width" to "100%", "height" to 100, "backgroundColor" to "#808080")), "demo-box" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-around", "marginTop" to 10)), "scroll-view-box-sizing" to _pS(_uM("width" to 100, "height" to 80, "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "borderTopWidth" to 10, "borderRightWidth" to 10, "borderBottomWidth" to 10, "borderLeftWidth" to 10, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#00FFFF", "borderRightColor" to "#00FFFF", "borderBottomColor" to "#00FFFF", "borderLeftColor" to "#00FFFF", "backgroundColor" to "#4ecdc4")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
