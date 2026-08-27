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
open class GenPagesCSSLayoutVisibility : BasePage {
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
    open var radioChangeVisibility: (index: Number) -> Unit
        get() {
            return unref(this.`$exposed`["radioChangeVisibility"]) as (index: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "radioChangeVisibility", value)
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
        var setup: (__props: GenPagesCSSLayoutVisibility, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSLayoutVisibility
            val _cache = __ins.renderCache
            var flag = true
            val data = reactive(_uO("visibility" to "visible", "visibilityValue" to "visible", "visibilityActual" to "", "visibilityActualText" to "", "visibilityActualImage" to ""))
            val changeVisibility = fun(){
                flag = !flag
                if (flag) {
                    data["visibility"] = "visible"
                } else {
                    data["visibility"] = "hidden"
                }
            }
            val visibilityEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "visible"),
                ItemType(value = 2, name = "hidden")
            ) as UTSArray<ItemType>
            val viewRef = ref(null as UniElement?)
            val textRef = ref(null as UniTextElement?)
            val imageRef = ref(null as UniImageElement?)
            val getPropertyValues = fun(){
                data["visibilityActual"] = viewRef.value?.style?.getPropertyValue("visibility") ?: ""
                data["visibilityActualText"] = textRef.value?.style?.getPropertyValue("visibility") ?: ""
                data["visibilityActualImage"] = imageRef.value?.style?.getPropertyValue("visibility") ?: ""
            }
            val changeVisibilityProperty = fun(value: String){
                data["visibilityValue"] = value
                viewRef.value?.style?.setProperty("visibility", value)
                textRef.value?.style?.setProperty("visibility", value)
                imageRef.value?.style?.setProperty("visibility", value)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangeVisibility = fun(index: Number){
                val selectedItem = visibilityEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changeVisibilityProperty(selectedItem.name)
                }
            }
            val inputChangeVisibility = fun(value: String){
                changeVisibilityProperty(value)
            }
            onReady(fun(){
                getPropertyValues()
            }
            )
            __expose(_uM("radioChangeVisibility" to radioChangeVisibility, "data" to data))
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1"))), _uA(
                        _cE("text", _uM("class" to "uni-tips"), "visibility: " + _tD(unref(data)["visibility"]) + " ，说明：点击切换", 1),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("view", _uM("onClick" to changeVisibility), _uA(
                                _cE("text", null, "view组件: " + _tD(unref(data)["visibility"]), 1),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("visibility" to unref(data)["visibility"]))), null, 4)
                            )),
                            _cE("view", _uM("onClick" to changeVisibility), _uA(
                                _cE("text", null, "text组件: " + _tD(unref(data)["visibility"]), 1),
                                _cE("text", _uM("class" to "common", "style" to _nS(_uM("visibility" to unref(data)["visibility"]))), "文本", 4)
                            )),
                            _cE("view", _uM("onClick" to changeVisibility), _uA(
                                _cE("text", null, "image组件: " + _tD(unref(data)["visibility"]), 1),
                                _cE("image", _uM("class" to "common", "style" to _nS(_uM("visibility" to unref(data)["visibility"])), "src" to "/static/test-image/logo.png"), null, 4)
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-title-text uni-common-mt"), "scroll-view 组件"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", null, _uA(
                                    _cE("text", null, "scroll-view: visible"),
                                    _cE("scroll-view", _uM("class" to "common", "style" to _nS(_uM("visibility" to "visible"))), null, 4)
                                )),
                                _cE("view", null, _uA(
                                    _cE("text", null, "scroll-view: hidden"),
                                    _cE("scroll-view", _uM("class" to "common", "style" to _nS(_uM("visibility" to "hidden"))), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 visibility ")
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["visibilityValue"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["visibilityActual"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("ref_key" to "viewRef", "ref" to viewRef, "class" to "common-dynamic test-view", "style" to _nS(_uM("visibility" to unref(data)["visibilityValue"]))), _uA(
                                        _cE("text", null, "view")
                                    ), 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["visibilityValue"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["visibilityActualText"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRef", "ref" to textRef, "class" to "common-dynamic test-text", "style" to _nS(_uM("visibility" to unref(data)["visibilityValue"]))), "text", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["visibilityValue"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["visibilityActualImage"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("ref_key" to "imageRef", "ref" to imageRef, "class" to "common-dynamic test-image", "style" to _nS(_uM("visibility" to unref(data)["visibilityValue"])), "src" to "/static/test-image/logo.png"), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                            _cV(_component_enum_data, _uM("items" to visibilityEnum, "title" to "visibility 枚举值", "onChange" to radioChangeVisibility, "compact" to true)),
                            _cV(_component_input_data, _uM("defaultValue" to unref(data)["visibilityValue"], "title" to "visibility 自定义值", "type" to "text", "onConfirm" to inputChangeVisibility), null, 8, _uA(
                                "defaultValue"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mb"), _uA(
                            _cE("text", null, "native-view 组件"),
                            _cE("view", _uM("class" to "demo-box"), _uA(
                                _cE("view", null, _uA(
                                    _cE("text", null, "native-view: visible"),
                                    _cE("native-view", _uM("class" to "common", "style" to _nS(_uM("visibility" to "visible"))), null, 4)
                                )),
                                _cE("view", null, _uA(
                                    _cE("text", null, "native-view: hidden"),
                                    _cE("native-view", _uM("class" to "common", "style" to _nS(_uM("visibility" to "hidden"))), null, 4)
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
                return _uM("common" to _pS(_uM("width" to 100, "height" to 100, "backgroundColor" to "#00FFFF")), "demo-box" to _pS(_uM("flexDirection" to "row", "marginTop" to 10, "justifyContent" to "space-around")), "common-dynamic" to _pS(_uM("width" to 100, "height" to 100, "backgroundColor" to "#00FFFF")), "test-container" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "marginTop" to 10)), "test-item" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 5, "marginBottom" to 0, "marginLeft" to 5)), "test-box" to _pS(_uM("width" to "100%", "height" to 100, "backgroundColor" to "#808080", "justifyContent" to "center", "alignItems" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
