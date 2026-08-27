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
open class GenPagesCSSLayoutTop : BasePage {
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
    open var radioChangeTop: (index: Number) -> Unit
        get() {
            return unref(this.`$exposed`["radioChangeTop"]) as (index: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "radioChangeTop", value)
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
        var setup: (__props: GenPagesCSSLayoutTop, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSLayoutTop
            val _cache = __ins.renderCache
            val topEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "0"),
                ItemType(value = 2, name = "0px"),
                ItemType(value = 3, name = "10px"),
                ItemType(value = 4, name = "20rpx"),
                ItemType(value = 5, name = "0%"),
                ItemType(value = 6, name = "50%"),
                ItemType(value = 7, name = "auto")
            ) as UTSArray<ItemType>
            val data = reactive(_uO("top" to "10px", "topActual" to "", "topActualText" to "", "topActualImage" to "", "topActualFlat" to "", "topActualTextFlat" to "", "topActualImageFlat" to ""))
            val viewRef = ref(null as UniElement?)
            val textRef = ref(null as UniTextElement?)
            val imageRef = ref(null as UniImageElement?)
            val viewRefFlat = ref(null as UniElement?)
            val textRefFlat = ref(null as UniTextElement?)
            val imageRefFlat = ref(null as UniImageElement?)
            val getPropertyValues = fun(){
                data["topActual"] = viewRef.value?.style?.getPropertyValue("top") ?: ""
                data["topActualFlat"] = viewRefFlat.value?.style?.getPropertyValue("top") ?: ""
                data["topActualText"] = textRef.value?.style?.getPropertyValue("top") ?: ""
                data["topActualTextFlat"] = textRefFlat.value?.style?.getPropertyValue("top") ?: ""
                data["topActualImage"] = imageRef.value?.style?.getPropertyValue("top") ?: ""
                data["topActualImageFlat"] = imageRefFlat.value?.style?.getPropertyValue("top") ?: ""
            }
            val changeTop = fun(value: String){
                data["top"] = value
                viewRef.value?.style?.setProperty("top", value)
                viewRefFlat.value?.style?.setProperty("top", value)
                textRef.value?.style?.setProperty("top", value)
                textRefFlat.value?.style?.setProperty("top", value)
                imageRef.value?.style?.setProperty("top", value)
                imageRefFlat.value?.style?.setProperty("top", value)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangeTop = fun(index: Number){
                val selectedItem = topEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changeTop(selectedItem.name)
                }
            }
            val inputChangeTop = fun(value: String){
                changeTop(value)
            }
            onReady(fun(){
                getPropertyValues()
            }
            )
            __expose(_uM("radioChangeTop" to radioChangeTop, "data" to data))
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1"))), _uA(
                        _cE("view", _uM("class" to "uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "top: 20px (距离顶部 20px) - 右侧：拍平"),
                            _cE("view", _uM("class" to "test-container"), _uA(
                                _cE("view", _uM("class" to "example-box"), _uA(
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("top" to "20px"))), null, 4)
                                )),
                                _cE("view", _uM("class" to "example-box"), _uA(
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("top" to "20px")), "flatten" to ""), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "top: 20rpx (距离顶部 20rpx) - 右侧：拍平"),
                            _cE("view", _uM("class" to "test-container"), _uA(
                                _cE("view", _uM("class" to "example-box"), _uA(
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("top" to "20rpx"))), null, 4)
                                )),
                                _cE("view", _uM("class" to "example-box"), _uA(
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("top" to "20rpx")), "flatten" to ""), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "top: 20% (距离顶部 20%) - 右侧：拍平"),
                            _cE("view", _uM("class" to "test-container"), _uA(
                                _cE("view", _uM("class" to "example-box"), _uA(
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("top" to "20%"))), null, 4)
                                )),
                                _cE("view", _uM("class" to "example-box"), _uA(
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("top" to "20%")), "flatten" to ""), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "top: auto (自动，默认顶部对齐) - 右侧：拍平"),
                            _cE("view", _uM("class" to "test-container"), _uA(
                                _cE("view", _uM("class" to "example-box"), _uA(
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("top" to "auto"))), null, 4)
                                )),
                                _cE("view", _uM("class" to "example-box"), _uA(
                                    _cE("view", _uM("class" to "common", "style" to _nS(_uM("top" to "auto")), "flatten" to ""), null, 4)
                                ))
                            ))
                        )),
                        _cE("text", _uM("class" to "uni-title-text uni-common-mt"), "scroll-view 组件"),
                        _cE("view", _uM("class" to "uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-subtitle-text"), "top: 10% 和 top: 30px"),
                            _cE("view", _uM("class" to "test-container"), _uA(
                                _cE("view", _uM("class" to "example-box"), _uA(
                                    _cE("scroll-view", _uM("class" to "common", "style" to _nS(_uM("top" to "10%"))), null, 4)
                                )),
                                _cE("view", _uM("class" to "example-box"), _uA(
                                    _cE("scroll-view", _uM("class" to "common", "style" to _nS(_uM("top" to "30px"))), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 top ")
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["top"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["topActual"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("ref_key" to "viewRef", "ref" to viewRef, "class" to "common test-view", "style" to _nS(_uM("top" to unref(data)["top"]))), _uA(
                                        _cE("text", _uM("class" to "common-text"), "view")
                                    ), 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["top"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["topActualText"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRef", "ref" to textRef, "class" to "common common-text test-text", "style" to _nS(_uM("top" to unref(data)["top"]))), "text", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["top"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["topActualImage"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("ref_key" to "imageRef", "ref" to imageRef, "class" to "common test-image", "style" to _nS(_uM("top" to unref(data)["top"])), "src" to "/static/test-image/logo.png"), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["top"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["topActualFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("ref_key" to "viewRefFlat", "ref" to viewRefFlat, "class" to "common test-view-flatten", "style" to _nS(_uM("top" to unref(data)["top"])), "flatten" to ""), _uA(
                                        _cE("text", _uM("class" to "common-text"), "view")
                                    ), 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["top"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["topActualTextFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRefFlat", "ref" to textRefFlat, "class" to "common common-text test-text-flatten", "style" to _nS(_uM("top" to unref(data)["top"])), "flatten" to ""), "text", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["top"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["topActualImageFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("ref_key" to "imageRefFlat", "ref" to imageRefFlat, "class" to "common test-image-flatten", "style" to _nS(_uM("top" to unref(data)["top"])), "flatten" to "", "src" to "/static/test-image/logo.png"), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                            _cV(_component_enum_data, _uM("items" to topEnum, "title" to "top 枚举值", "onChange" to radioChangeTop, "compact" to true)),
                            _cV(_component_input_data, _uM("defaultValue" to unref(data)["top"], "title" to "top 自定义值", "type" to "text", "onConfirm" to inputChangeTop), null, 8, _uA(
                                "defaultValue"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mb"), _uA(
                            _cE("text", null, "native-view组件: top: 10% 和 top: 30px"),
                            _cE("view", _uM("class" to "test-container"), _uA(
                                _cE("view", _uM("class" to "example-box"), _uA(
                                    _cE("native-view", _uM("class" to "common", "style" to _nS(_uM("top" to "10%"))), null, 4)
                                )),
                                _cE("view", _uM("class" to "example-box"), _uA(
                                    _cE("native-view", _uM("class" to "common", "style" to _nS(_uM("top" to "30px"))), null, 4)
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
                return _uM("example-box" to _pS(_uM("position" to "relative", "flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "height" to 100, "backgroundColor" to "#f5f5f5", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#dddddd", "borderRightColor" to "#dddddd", "borderBottomColor" to "#dddddd", "borderLeftColor" to "#dddddd", "marginTop" to 0, "marginRight" to 5, "marginBottom" to 0, "marginLeft" to 5)), "common" to _pS(_uM("position" to "absolute", "width" to 60, "height" to 60, "backgroundColor" to "#00FFFF")), "common-text" to _pS(_uM("width" to 50, "fontSize" to 12)), "test-container" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "marginTop" to 10)), "test-item" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 5, "marginBottom" to 0, "marginLeft" to 5)), "test-box" to _pS(_uM("position" to "relative", "width" to "100%", "height" to 100, "backgroundColor" to "#e0e0e0")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
