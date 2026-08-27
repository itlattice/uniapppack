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
open class GenPagesCSSLayoutZIndex : BasePage {
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
    open var data: DataType__116
        get() {
            return unref(this.`$exposed`["data"]) as DataType__116
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var changeZIndex: (zIndexValue: Number) -> Unit
        get() {
            return unref(this.`$exposed`["changeZIndex"]) as (zIndexValue: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "changeZIndex", value)
        }
    open var radioChangeZIndex: (index: Number) -> Unit
        get() {
            return unref(this.`$exposed`["radioChangeZIndex"]) as (index: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "radioChangeZIndex", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesCSSLayoutZIndex, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSLayoutZIndex
            val _cache = __ins.renderCache
            val data = reactive(DataType__116(zIndex = 5, autoTest = false, zIndexValue = 5, zIndexActual = "", zIndexActualText = "", zIndexActualImage = ""))
            val view = ref(null as UniElement?)
            val changeZIndex = fun(zIndexValue: Number){
                data.zIndex = 20
                view.value?.style?.setProperty("z-index", zIndexValue)
            }
            val zIndexEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "-1"),
                ItemType(value = 2, name = "0"),
                ItemType(value = 3, name = "1"),
                ItemType(value = 4, name = "10")
            ) as UTSArray<ItemType>
            val viewRef = ref(null as UniElement?)
            val textRef = ref(null as UniTextElement?)
            val imageRef = ref(null as UniImageElement?)
            val getPropertyValues = fun(){
                data.zIndexActual = viewRef.value?.style?.getPropertyValue("z-index") ?: ""
                data.zIndexActualText = textRef.value?.style?.getPropertyValue("z-index") ?: ""
                data.zIndexActualImage = imageRef.value?.style?.getPropertyValue("z-index") ?: ""
            }
            val changeZIndexProperty = fun(value: Number){
                data.zIndexValue = value
                viewRef.value?.style?.setProperty("z-index", value)
                textRef.value?.style?.setProperty("z-index", value.toString(10))
                imageRef.value?.style?.setProperty("z-index", value.toString(10))
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangeZIndex = fun(index: Number){
                val selectedItem = zIndexEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    val value = if (selectedItem.name === "") {
                        0
                    } else {
                        parseInt(selectedItem.name)
                    }
                    changeZIndexProperty(value)
                }
            }
            val inputChangeZIndex = fun(value: String){
                val numValue = parseInt(value)
                if (!isNaN(numValue)) {
                    changeZIndexProperty(numValue)
                }
            }
            onReady(fun(){
                getPropertyValues()
            }
            )
            __expose(_uM("data" to data, "changeZIndex" to changeZIndex, "radioChangeZIndex" to radioChangeZIndex))
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1"))), _uA(
                        _cE("view", _uM("style" to _nS(_uM("position" to "absolute", "z-index" to "0"))), _uA(
                            _cE("view", _uM("class" to "common fixed default"), _uA(
                                _cE("text", null, "position: fixed"),
                                _cE("text", null, "z-index: 10")
                            )),
                            _cE("view", _uM("class" to "common fixed specified"), _uA(
                                _cE("text", null, "position: fixed"),
                                _cE("text", null, "z-index: 5")
                            )),
                            _cE("view", _uM("class" to "common fixed floor"), _uA(
                                _cE("text", null, "position: fixed"),
                                _cE("text", null, "z-index: -1")
                            ))
                        ), 4),
                        _cE("view", _uM("style" to _nS(_uM("top" to "170px"))), _uA(
                            _cE("view", _uM("class" to "common", "style" to _nS(_uM("background-color" to "cyan", "z-index" to "10"))), _uA(
                                _cE("text", null, "z-index: 10")
                            ), 4),
                            _cE("view", _uM("ref_key" to "view", "ref" to view, "class" to "common", "style" to _nS(_uM("background-color" to "green", "z-index" to "5", "top" to "-100px", "left" to "100px")), "onClick" to fun(){
                                changeZIndex(20)
                            }
                            ), _uA(
                                _cE("text", null, "z-index: " + _tD(unref(data).zIndex), 1),
                                _cE("text", null, "点击修改z-index")
                            ), 12, _uA(
                                "onClick"
                            )),
                            _cE("view", _uM("class" to "common", "style" to _nS(_uM("background-color" to "blue", "top" to "-120px", "left" to "175px"))), _uA(
                                _cE("text", null, "z-index: 0")
                            ), 4)
                        ), 4),
                        _cE("view", null, _uA(
                            _cE("view", null, _uA(
                                _cE("view", _uM("class" to "common fixed popup", "style" to _nS(_uM("background-color" to "yellow", "z-index" to "5"))), _uA(
                                    _cE("text", null, "position: fixed"),
                                    _cE("text", null, "z-index: 5")
                                ), 4)
                            ))
                        ))
                    ), 4),
                    if (isTrue(unref(data).autoTest)) {
                        _cE("view", _uM("key" to 0), _uA(
                            _cE("view", _uM("style" to _nS(_uM("z-index" to "1", "position" to "fixed"))), "111", 4),
                            _cE("view", _uM("style" to _nS(_uM("width" to "750rpx"))), "222", 4)
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    _cE("view", _uM("style" to _nS(_uM("top" to "50px"))), _uA(
                        _cE("text", _uM("class" to "uni-title-text uni-common-mt"), "text 组件"),
                        _cE("text", _uM("class" to "common", "style" to _nS(_uM("background-color" to "cyan", "z-index" to "10", "text-align" to "right"))), "text组件: z-index: 10", 4),
                        _cE("text", _uM("class" to "common", "style" to _nS(_uM("background-color" to "green", "top" to "-37px", "left" to "87px", "z-index" to "5", "text-align" to "right"))), "text组件: z-index: 5", 4),
                        _cE("text", _uM("class" to "common", "style" to _nS(_uM("background-color" to "blue", "top" to "-75px", "left" to "175px", "z-index" to "0", "text-align" to "right"))), "text组件: z-index: 0", 4)
                    ), 4),
                    _cE("view", _uM("style" to _nS(_uM("top" to "50px"))), _uA(
                        _cE("text", _uM("class" to "uni-title-text uni-common-mt"), "image 组件"),
                        _cE("image", _uM("class" to "common image-zindex", "style" to _nS(_uM("background-color" to "cyan", "z-index" to "10")), "src" to "/static/test-image/logo.png"), null, 4),
                        _cE("image", _uM("class" to "common image-zindex", "style" to _nS(_uM("background-color" to "green", "top" to "-37px", "left" to "87px", "z-index" to "5")), "src" to "/static/test-image/logo.png"), null, 4),
                        _cE("image", _uM("class" to "common image-zindex", "style" to _nS(_uM("background-color" to "blue", "top" to "-75px", "left" to "175px", "z-index" to "0")), "src" to "/static/test-image/logo.png"), null, 4)
                    ), 4),
                    _cE("view", _uM("class" to "uni-common-mb", "style" to _nS(_uM("top" to "50px"))), _uA(
                        _cE("text", _uM("class" to "uni-title-text uni-common-mt"), "scroll-view 组件"),
                        _cE("text", _uM("class" to "uni-subtitle-text"), "z-index: 10 和 z-index: 5"),
                        _cE("scroll-view", _uM("class" to "common", "style" to _nS(_uM("z-index" to "10", "background-color" to "cyan"))), _uA(
                            _cE("text", null, "z-index: 10")
                        ), 4),
                        _cE("scroll-view", _uM("class" to "common", "style" to _nS(_uM("top" to "-40px", "left" to "30px", "z-index" to "5", "background-color" to "green"))), _uA(
                            _cE("text", _uM("style" to _nS(_uM("line-height" to "100px"))), "z-index: 5", 4)
                        ), 4)
                    ), 4),
                    _cE("view", _uM("class" to "uni-common-mt", "style" to _nS(_uM("top" to "100px"))), _uA(
                        _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 z-index "),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data).zIndexValue), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data).zIndexActual), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("class" to "common-bg", "style" to _nS(_uM("background-color" to "blue", "z-index" to "1"))), _uA(
                                        _cE("text", _uM("class" to "common-text-bg"), "蓝色view")
                                    ), 4),
                                    _cE("view", _uM("ref_key" to "viewRef", "ref" to viewRef, "class" to "common-dynamic test-view", "style" to _nS(_uA(
                                        _uM("background-color" to "cyan"),
                                        _uM("zIndex" to unref(data).zIndexValue)
                                    ))), _uA(
                                        _cE("text", _uM("class" to "common-text-bg"), "青色view")
                                    ), 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data).zIndexValue), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data).zIndexActualText), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("class" to "common-bg common-text-bg", "style" to _nS(_uM("background-color" to "blue", "z-index" to "1"))), "蓝色text", 4),
                                    _cE("text", _uM("ref_key" to "textRef", "ref" to textRef, "class" to "common-dynamic common-text-bg test-text", "style" to _nS(_uA(
                                        _uM("background-color" to "cyan"),
                                        _uM("zIndex" to unref(data).zIndexValue)
                                    ))), "青色text", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data).zIndexValue), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data).zIndexActualImage), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("class" to "common-bg common-image-bg", "style" to _nS(_uM("z-index" to "1")), "src" to "/static/test-image/logo.png"), null, 4),
                                    _cE("image", _uM("ref_key" to "imageRef", "ref" to imageRef, "class" to "common-dynamic common-image-bg test-image", "style" to _nS(_uM("zIndex" to unref(data).zIndexValue)), "src" to "/static/test-image/logo.png"), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                            _cV(_component_enum_data, _uM("items" to zIndexEnum, "title" to "z-index 枚举值", "onChange" to radioChangeZIndex, "compact" to true)),
                            _cV(_component_input_data, _uM("defaultValue" to unref(data).zIndexValue.toString(10), "title" to "z-index 自定义值", "type" to "number", "onConfirm" to inputChangeZIndex), null, 8, _uA(
                                "defaultValue"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mb", "style" to _nS(_uM("top" to "50px"))), _uA(
                            _cE("text", null, "native-view组件: z-index: 10 和 z-index: 5"),
                            _cE("native-view", _uM("class" to "common", "style" to _nS(_uM("z-index" to "10", "background-color" to "cyan"))), null, 4),
                            _cE("native-view", _uM("class" to "common", "style" to _nS(_uM("top" to "-40px", "left" to "30px", "z-index" to "5", "background-color" to "green"))), null, 4)
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
                return _uM("common" to _pS(_uM("width" to 125, "height" to 125, "justifyContent" to "center", "alignItems" to "center")), "fixed" to _pS(_uM("position" to "fixed")), "default" to _pS(_uM("backgroundColor" to "#FFFF00", "zIndex" to 10, "top" to "var(--uni-safe-area-inset-top)", "left" to "var(--uni-safe-area-inset-left)")), "specified" to _pS(_uM("backgroundColor" to "#9ACD32", "zIndex" to 5, "top" to 87, "left" to 87)), "floor" to _pS(_uM("backgroundColor" to "#D2691E", "top" to 250, "left" to 175, "zIndex" to -1)), "popup" to _pS(_uM("top" to 320, "left" to 87, "height" to 40)), "image-zindex" to _pS(_uM("width" to 125, "height" to 125, "backgroundColor" to "rgba(255,255,255,0.5)")), "common-dynamic" to _pS(_uM("width" to 80, "height" to 80, "position" to "absolute", "top" to 20, "left" to 20)), "common-bg" to _pS(_uM("width" to 80, "height" to 80, "position" to "absolute", "top" to 0, "left" to 0)), "common-text-bg" to _pS(_uM("color" to "#FFFFFF", "fontSize" to 12, "paddingTop" to 5, "paddingRight" to 5, "paddingBottom" to 5, "paddingLeft" to 5)), "common-image-bg" to _pS(_uM("width" to 80, "height" to 80)), "test-container" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "marginTop" to 10)), "test-item" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 5, "marginBottom" to 0, "marginLeft" to 5)), "test-box" to _pS(_uM("width" to "100%", "height" to 120, "backgroundColor" to "#808080", "position" to "relative")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
