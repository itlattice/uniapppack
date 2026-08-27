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
open class GenPagesCSSBackgroundBackgroundImage : BasePage {
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
    open var updateBackgroundSelect: () -> Unit
        get() {
            return unref(this.`$exposed`["updateBackgroundSelect"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "updateBackgroundSelect", value)
        }
    open var setBackgroundColor: () -> Unit
        get() {
            return unref(this.`$exposed`["setBackgroundColor"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setBackgroundColor", value)
        }
    open var setBackgroundImage: () -> Unit
        get() {
            return unref(this.`$exposed`["setBackgroundImage"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setBackgroundImage", value)
        }
    open var changeBgClass: () -> Unit
        get() {
            return unref(this.`$exposed`["changeBgClass"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "changeBgClass", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesCSSBackgroundBackgroundImage, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSBackgroundBackgroundImage
            val _cache = __ins.renderCache
            val backgroundSelect = ref(true)
            val directionData = ref(_uA(
                "to right",
                "to left",
                "to bottom",
                "to top",
                "to bottom left",
                "to bottom right",
                "to top left",
                "to top right"
            ))
            val testStyle = ref("background:linear-gradient(to right, red, yellow)")
            val testClass = ref("bg-color")
            val updateBackgroundSelect = fun(){
                backgroundSelect.value = !backgroundSelect.value
            }
            val setBackgroundColor = fun(){
                testStyle.value = "background:blue"
            }
            val setBackgroundImage = fun(){
                testStyle.value = "background:linear-gradient(to right, red, yellow)"
            }
            val changeBgStyle = fun(){
                val isColor = testStyle.value == "background:blue"
                if (isColor) {
                    setBackgroundImage()
                } else {
                    setBackgroundColor()
                }
            }
            val changeBgClass = fun(){
                testClass.value = if (testClass.value == "bg-color") {
                    "bg-image"
                } else {
                    "bg-color"
                }
            }
            __expose(_uM("updateBackgroundSelect" to updateBackgroundSelect, "setBackgroundColor" to setBackgroundColor, "setBackgroundImage" to setBackgroundImage, "changeBgClass" to changeBgClass))
            val backgroundImage = ref("linear-gradient(to right, red, yellow)")
            val viewRef = ref(null as UniElement?)
            val backgroundImageEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "linear-gradient(to right, red, yellow)"),
                ItemType(value = 2, name = "linear-gradient(to bottom, blue, green)"),
                ItemType(value = 3, name = "linear-gradient(to top, red, blue)"),
                ItemType(value = 4, name = "linear-gradient(45deg, red, yellow)"),
                ItemType(value = 5, name = "linear-gradient(to right, red, yellow, green)"),
                ItemType(value = 6, name = "(to right, red 0%, yellow 50%, green 100%)"),
                ItemType(value = 7, name = "linear-gradient(to bottom left, red, yellow)")
            ) as UTSArray<ItemType>
            val changeBackgroundImage = fun(value: String){
                backgroundImage.value = value
                viewRef.value?.style?.setProperty("background-image", value)
            }
            val radioChangeBackgroundImage = fun(index: Number){
                val selectedItem = backgroundImageEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changeBackgroundImage(selectedItem.name)
                }
            }
            val inputChangeBackgroundImage = fun(value: String){
                changeBackgroundImage(value)
            }
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", null, _uA(
                        _cE("view", _uM("style" to _nS(_uM("width" to "0px", "height" to "0px", "background-image" to "linear-gradient(to bottom,#f5f5f5,#eff2f5)"))), null, 4),
                        _cE("text", null, "不支持背景图片，仅支持linear-gradient方法"),
                        _cE(Fragment, null, RenderHelpers.renderList(unref(directionData), fun(direction, __key, __index, _cached): Any {
                            return _cE("view", null, _uA(
                                _cE("text", null, "background-image: linear-gradient(" + _tD(direction) + ", red, yellow)", 1),
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("background-image" to if (unref(backgroundSelect)) {
                                    "linear-gradient(" + direction + ", red, yellow)"
                                } else {
                                    ""
                                }
                                ))), null, 4)
                            ))
                        }
                        ), 256),
                        _cE("view", null, _uA(
                            _cE("text", null, "style 动态切换 background"),
                            _cE("view", _uM("onClick" to changeBgStyle, "class" to "common", "style" to _nS(unref(testStyle))), _tD(unref(testStyle)), 5)
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "class 动态切换 background"),
                            _cE("view", _uM("onClick" to changeBgClass, "class" to _nC(_uA(
                                "common",
                                unref(testClass)
                            ))), _tD(unref(testClass)), 3)
                        )),
                        _cE("text", _uM("class" to "uni-title-text uni-common-mt"), "scroll-view 组件"),
                        _cE("text", _uM("class" to "uni-subtitle-text"), "background-image: linear-gradient(to right, cyan, yellow);"),
                        _cE("text", _uM("class" to "uni-subtitle-text"), "background-image: linear-gradient(to bottom, blue, green);"),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("scroll-view", _uM("class" to "common", "style" to _nS(_uM("background-image" to "linear-gradient(to right, cyan, yellow)", "width" to "150px"))), _uA(
                                _cE("text", _uM("class" to "common-text"), "to right")
                            ), 4),
                            _cE("scroll-view", _uM("class" to "common", "style" to _nS(_uM("background-image" to "linear-gradient(to bottom, blue, green)", "width" to "150px"))), _uA(
                                _cE("text", _uM("class" to "common-text"), "to bottom")
                            ), 4)
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "style.setProperty 动态设置 background-image "),
                            _cE("text", null, "background-image: " + _tD(unref(backgroundImage)), 1),
                            _cE("view", _uM("ref_key" to "viewRef", "ref" to viewRef, "class" to "common", "style" to _nS(_uM("backgroundImage" to unref(backgroundImage)))), _uA(
                                _cE("text", _uM("style" to _nS(_uM("color" to "white"))), "当前 background-image: " + _tD(unref(backgroundImage)), 5)
                            ), 4)
                        )),
                        _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                            _cV(_component_enum_data, _uM("compact" to true, "items" to backgroundImageEnum, "title" to "background-image 枚举值", "onChange" to radioChangeBackgroundImage)),
                            _cV(_component_input_data, _uM("defaultValue" to unref(backgroundImage), "title" to "background-image 自定义值", "type" to "text", "onConfirm" to inputChangeBackgroundImage), null, 8, _uA(
                                "defaultValue"
                            ))
                        )),
                        _cE("text", _uM("class" to "uni-title-text uni-common-mt"), "native-view 组件"),
                        _cE("text", _uM("class" to "uni-subtitle-text"), "background-image: linear-gradient(to right, cyan, yellow);"),
                        _cE("text", _uM("class" to "uni-subtitle-text"), "background-image: linear-gradient(to bottom, blue, green);"),
                        _cE("view", _uM("class" to "demo-box uni-common-mb"), _uA(
                            _cE("native-view", _uM("class" to "native-view-bg", "style" to _nS(_uM("background-image" to "linear-gradient(to right, cyan, yellow)"))), null, 4),
                            _cE("native-view", _uM("class" to "native-view-bg", "style" to _nS(_uM("background-image" to "linear-gradient(to bottom, blue, green)"))), null, 4)
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
                return _uM("common" to _pS(_uM("width" to 250, "height" to 100)), "bg-color" to _pS(_uM("backgroundImage" to "none", "backgroundColor" to "#0000FF")), "bg-image" to _pS(_uM("backgroundImage" to "linear-gradient(to right, red, yellow)", "backgroundColor" to "rgba(0,0,0,0)")), "demo-box" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-around", "marginTop" to 10)), "common-text" to _pS(_uM("fontSize" to 12, "color" to "#FFFFFF")), "native-view-bg" to _pS(_uM("width" to 150, "height" to 100)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
