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
open class GenPagesCSSFlexFlexBasis : BasePage {
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
    open var radioChangeFlexBasis: (index: Number) -> Unit
        get() {
            return unref(this.`$exposed`["radioChangeFlexBasis"]) as (index: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "radioChangeFlexBasis", value)
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
        var setup: (__props: GenPagesCSSFlexFlexBasis, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSFlexFlexBasis
            val _cache = __ins.renderCache
            val flexBasisEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "0"),
                ItemType(value = 2, name = "0px"),
                ItemType(value = 3, name = "50px"),
                ItemType(value = 4, name = "0%"),
                ItemType(value = 5, name = "50%"),
                ItemType(value = 6, name = "auto")
            ) as UTSArray<ItemType>
            val data = reactive(_uO("flexBasis" to "30px", "flexBasisActual" to "", "flexBasisActualFlat" to "", "flexBasisActualText" to "", "flexBasisActualImage" to "", "flexBasisActualTextFlat" to "", "flexBasisActualImageFlat" to ""))
            val viewRef = ref(null as UniElement?)
            val viewRefFlat = ref(null as UniElement?)
            val textRef = ref(null as UniTextElement?)
            val imageRef = ref(null as UniImageElement?)
            val textRefFlat = ref(null as UniTextElement?)
            val imageRefFlat = ref(null as UniImageElement?)
            val getPropertyValues = fun(){
                data["flexBasisActual"] = viewRef.value?.style?.getPropertyValue("flex-basis") ?: ""
                data["flexBasisActualFlat"] = viewRefFlat.value?.style?.getPropertyValue("flex-basis") ?: ""
                data["flexBasisActualText"] = textRef.value?.style?.getPropertyValue("flex-basis") ?: ""
                data["flexBasisActualTextFlat"] = textRefFlat.value?.style?.getPropertyValue("flex-basis") ?: ""
                data["flexBasisActualImage"] = imageRef.value?.style?.getPropertyValue("flex-basis") ?: ""
                data["flexBasisActualImageFlat"] = imageRefFlat.value?.style?.getPropertyValue("flex-basis") ?: ""
            }
            val changeFlexBasis = fun(value: String){
                data["flexBasis"] = value
                viewRef.value?.style?.setProperty("flex-basis", value)
                viewRefFlat.value?.style?.setProperty("flex-basis", value)
                textRef.value?.style?.setProperty("flex-basis", value)
                textRefFlat.value?.style?.setProperty("flex-basis", value)
                imageRef.value?.style?.setProperty("flex-basis", value)
                imageRefFlat.value?.style?.setProperty("flex-basis", value)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangeFlexBasis = fun(index: Number){
                val selectedItem = flexBasisEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changeFlexBasis(selectedItem.name)
                }
            }
            val inputChangeFlexBasis = fun(value: String){
                changeFlexBasis(value)
            }
            onReady(fun(){
                getPropertyValues()
            }
            )
            __expose(_uM("radioChangeFlexBasis" to radioChangeFlexBasis, "data" to data))
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1"))), _uA(
                        _cE("text", _uM("class" to "uni-tips"), "说明：左边是正常版本，右边是拍平版本"),
                        _cE("view", null, _uA(
                            _cE("text", null, "flex-basis"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", _uM("class" to "flex-container"), _uA(
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("flex-basis" to "100px"))), _uA(
                                        _cE("text", null, "100px")
                                    ), 4),
                                    _cE("view", _uM("class" to "flex-item green")),
                                    _cE("view", _uM("class" to "flex-item blue"))
                                )),
                                _cE("view", _uM("class" to "flex-container"), _uA(
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("flex-basis" to "100px")), "flatten" to ""), _uA(
                                        _cE("text", null, "100px")
                                    ), 4),
                                    _cE("view", _uM("class" to "flex-item green")),
                                    _cE("view", _uM("class" to "flex-item blue"))
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "scroll-view 组件")
                        )),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("view", _uM("class" to "flex-container"), _uA(
                                _cE("scroll-view", _uM("class" to "common", "style" to _nS(_uM("flex-basis" to "50px"))), _uA(
                                    _cE("text", _uM("class" to "scroll-view-label"), "50px")
                                ), 4),
                                _cE("view", _uM("class" to "flex-item green")),
                                _cE("view", _uM("class" to "flex-item blue"))
                            )),
                            _cE("view", _uM("class" to "flex-container"), _uA(
                                _cE("scroll-view", _uM("class" to "common", "style" to _nS(_uM("flex-basis" to "100px"))), _uA(
                                    _cE("text", _uM("class" to "scroll-view-label"), "100px")
                                ), 4),
                                _cE("view", _uM("class" to "flex-item green")),
                                _cE("view", _uM("class" to "flex-item blue"))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 flex-basis ")
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["flexBasis"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["flexBasisActual"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("class" to "test-flex-container"), _uA(
                                        _cE("view", _uM("class" to "common-image red")),
                                        _cE("view", _uM("ref_key" to "viewRef", "ref" to viewRef, "class" to "common-image green test-view", "style" to _nS(_uM("flexBasis" to unref(data)["flexBasis"]))), _uA(
                                            _cE("text", _uM("class" to "test-label"), "view")
                                        ), 4),
                                        _cE("view", _uM("class" to "common-image blue"))
                                    ))
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["flexBasis"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["flexBasisActualText"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("class" to "test-flex-container"), _uA(
                                        _cE("text", _uM("class" to "common-text red"), "红色"),
                                        _cE("text", _uM("ref_key" to "textRef", "ref" to textRef, "class" to "common-text green test-text", "style" to _nS(_uM("flexBasis" to unref(data)["flexBasis"]))), "text", 4),
                                        _cE("text", _uM("class" to "common-text blue"), "蓝色")
                                    ))
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["flexBasis"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["flexBasisActualImage"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("class" to "test-flex-container"), _uA(
                                        _cE("image", _uM("class" to "common-image red", "src" to "/static/test-image/logo.png")),
                                        _cE("image", _uM("ref_key" to "imageRef", "ref" to imageRef, "class" to "common-image green test-image", "style" to _nS(_uM("flexBasis" to unref(data)["flexBasis"])), "src" to "/static/test-image/logo.png"), null, 4),
                                        _cE("image", _uM("class" to "common-image blue", "src" to "/static/test-image/logo.png"))
                                    ))
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["flexBasis"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["flexBasisActualFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("class" to "test-flex-container"), _uA(
                                        _cE("view", _uM("class" to "common-image red")),
                                        _cE("view", _uM("ref_key" to "viewRefFlat", "ref" to viewRefFlat, "class" to "common-image green test-view-flatten", "style" to _nS(_uM("flexBasis" to unref(data)["flexBasis"])), "flatten" to ""), _uA(
                                            _cE("text", _uM("class" to "test-label"), "view")
                                        ), 4),
                                        _cE("view", _uM("class" to "common-image blue"))
                                    ))
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["flexBasis"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["flexBasisActualTextFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("class" to "test-flex-container"), _uA(
                                        _cE("text", _uM("class" to "common-text red"), "红色"),
                                        _cE("text", _uM("ref_key" to "textRefFlat", "ref" to textRefFlat, "class" to "common-text green test-text-flatten", "style" to _nS(_uM("flexBasis" to unref(data)["flexBasis"])), "flatten" to ""), "text", 4),
                                        _cE("text", _uM("class" to "common-text blue"), "蓝色")
                                    ))
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["flexBasis"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["flexBasisActualImageFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("class" to "test-flex-container"), _uA(
                                        _cE("image", _uM("class" to "common-image red", "src" to "/static/test-image/logo.png")),
                                        _cE("image", _uM("ref_key" to "imageRefFlat", "ref" to imageRefFlat, "class" to "common-image green test-image-flatten", "style" to _nS(_uM("flexBasis" to unref(data)["flexBasis"])), "flatten" to "", "src" to "/static/test-image/logo.png"), null, 4),
                                        _cE("image", _uM("class" to "common-image blue", "src" to "/static/test-image/logo.png"))
                                    ))
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                            _cV(_component_enum_data, _uM("items" to flexBasisEnum, "title" to "flex-basis 枚举值", "onChange" to radioChangeFlexBasis, "compact" to true)),
                            _cV(_component_input_data, _uM("defaultValue" to unref(data)["flexBasis"], "title" to "flex-basis 自定义值", "type" to "text", "onConfirm" to inputChangeFlexBasis), null, 8, _uA(
                                "defaultValue"
                            ))
                        )),
                        _cE("text", _uM("class" to "uni-title-text"), "native-view 组件：flex-basis: 50px 和 100px"),
                        _cE("view", _uM("class" to "demo-box uni-common-mb"), _uA(
                            _cE("view", _uM("class" to "flex-container"), _uA(
                                _cE("native-view", _uM("class" to "common", "style" to _nS(_uM("flex-basis" to "50px"))), null, 4),
                                _cE("view", _uM("class" to "flex-item green")),
                                _cE("view", _uM("class" to "flex-item blue"))
                            )),
                            _cE("view", _uM("class" to "flex-container"), _uA(
                                _cE("native-view", _uM("class" to "common", "style" to _nS(_uM("flex-basis" to "100px"))), null, 4),
                                _cE("view", _uM("class" to "flex-item green")),
                                _cE("view", _uM("class" to "flex-item blue"))
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
                return _uM("demo-box" to _pS(_uM("flexDirection" to "row", "marginTop" to 10, "justifyContent" to "space-around")), "flex-container" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 10, "marginBottom" to 0, "marginLeft" to 10, "height" to 80, "backgroundColor" to "#808080", "flexDirection" to "row")), "flex-item" to _pS(_uM("width" to 40, "height" to 40)), "red" to _pS(_uM("backgroundColor" to "#FF0000")), "green" to _pS(_uM("backgroundColor" to "#008000")), "blue" to _pS(_uM("backgroundColor" to "#0000FF")), "common" to _pS(_uM("width" to 40, "height" to 40, "backgroundColor" to "#FF0000", "justifyContent" to "center", "alignItems" to "center")), "common-text" to _pS(_uM("width" to 30, "height" to 30, "fontSize" to 12, "color" to "#FFFFFF")), "common-image" to _pS(_uM("width" to 30, "height" to 30)), "test-container" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "marginTop" to 10)), "test-item" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 5, "marginBottom" to 0, "marginLeft" to 5)), "test-box" to _pS(_uM("width" to "100%", "height" to 50, "backgroundColor" to "#808080")), "test-flex-container" to _pS(_uM("width" to "100%", "height" to "100%", "flexDirection" to "row")), "test-label" to _pS(_uM("fontSize" to 12)), "scroll-view-label" to _pS(_uM("fontSize" to 12, "lineHeight" to "50px", "textAlign" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
