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
import io.dcloud.uniapp.extapi.getElementById as uni_getElementById
open class GenPagesCSSTextLineHeight : BasePage {
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
    open var autoTestData: AutoTextData__1
        get() {
            return unref(this.`$exposed`["autoTestData"]) as AutoTextData__1
        }
        set(value) {
            setRefValue(this.`$exposed`, "autoTestData", value)
        }
    open var getLineHeight: () -> Number
        get() {
            return unref(this.`$exposed`["getLineHeight"]) as () -> Number
        }
        set(value) {
            setRefValue(this.`$exposed`, "getLineHeight", value)
        }
    open var plusLineHeight: () -> Unit
        get() {
            return unref(this.`$exposed`["plusLineHeight"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "plusLineHeight", value)
        }
    open var minusLineHeight: () -> Unit
        get() {
            return unref(this.`$exposed`["minusLineHeight"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "minusLineHeight", value)
        }
    open var data: LineHeightData
        get() {
            return unref(this.`$exposed`["data"]) as LineHeightData
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesCSSTextLineHeight, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSTextLineHeight
            val _cache = __ins.renderCache
            val lineHeightEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "1.5"),
                ItemType(value = 2, name = "2"),
                ItemType(value = 3, name = "25px"),
                ItemType(value = 4, name = "50rpx"),
                ItemType(value = 5, name = "1.5em"),
                ItemType(value = 6, name = "2em")
            ) as UTSArray<ItemType>
            val data = reactive(LineHeightData(lineHeight = "20px", lineHeightActual = "", lineHeightActualFlat = "", lineHeight_mix = 1.5))
            val textRef = ref(null as UniTextElement?)
            val textRefFlat = ref(null as UniTextElement?)
            val getPropertyValues = fun(){
                data.lineHeightActual = textRef.value?.style?.getPropertyValue("line-height") ?: ""
                data.lineHeightActualFlat = textRefFlat.value?.style?.getPropertyValue("line-height") ?: ""
            }
            val changeLineHeight = fun(value: String){
                data.lineHeight = value
                textRef.value?.style?.setProperty("line-height", value)
                textRefFlat.value?.style?.setProperty("line-height", value)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangeLineHeight = fun(index: Number){
                val selectedItem = lineHeightEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changeLineHeight(selectedItem.name)
                }
            }
            val inputChangeLineHeight = fun(value: String){
                changeLineHeight(value)
            }
            val autoTestData = reactive<AutoTextData__1>(AutoTextData__1(begin = false))
            fun gen_plusLineHeight_fn() {
                data.lineHeight_mix = data.lineHeight_mix + 0.2
            }
            val plusLineHeight = ::gen_plusLineHeight_fn
            fun gen_minusLineHeight_fn() {
                data.lineHeight_mix = data.lineHeight_mix - 0.2
            }
            val minusLineHeight = ::gen_minusLineHeight_fn
            fun gen_getLineHeight_fn(): Number {
                val testText = uni_getElementById("testText")
                if (testText != null) {
                    return parseFloat(testText.style.getPropertyValue("line-height"))
                }
                return 0
            }
            val getLineHeight = ::gen_getLineHeight_fn
            __expose(_uM("autoTestData" to autoTestData, "getLineHeight" to getLineHeight, "plusLineHeight" to plusLineHeight, "minusLineHeight" to minusLineHeight, "data" to data))
            onReady(fun(){
                getPropertyValues()
            }
            )
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    if (isTrue(unref(autoTestData).begin)) {
                        _cE("view", _uM("key" to 0), _uA(
                            _cE("text", _uM("id" to "testText", "style" to _nS("line-height: " + unref(data).lineHeight_mix + ";")), " uni-app 是一个使用 Vue.js 开发所有前端应用的框架，开发者编写一套代码，可发布到iOS、Android、鸿蒙Next、Web（响应式）、以及各种小程序（微信/支付宝/百度/抖音/飞书/QQ/快手/钉钉/淘宝/京东/小红书）、快应用、鸿蒙元服务等多个平台。", 4),
                            _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row"))), _uA(
                                _cE("button", _uM("onClick" to plusLineHeight), "+行高"),
                                _cE("button", _uM("onClick" to minusLineHeight), "-行高")
                            ), 4)
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    _cE("text", _uM("class" to "uni-tips"), "说明：左边是正常版本，右边是拍平版本"),
                    _cE("view", _uM("class" to "demo-box"), _uA(
                        _cE("view", _uM("class" to "box"), _uA(
                            _cE("text", _uM("class" to "common", "style" to _nS(_uM("line-height" to "75px"))), "line-height: 75px", 4),
                            _cE("text", _uM("class" to "line-height-3 common"), "line-height: 3"),
                            _cE("text", _uM("class" to "common", "style" to _nS(_uM("line-height" to "3em"))), "line-height: 3em", 4),
                            _cE("text", _uM("class" to "common", "style" to _nS(_uM("line-height" to "3"))), "line-height: 3\nline-height: 3\nline-height: 3", 4)
                        )),
                        _cE("view", _uM("class" to "box"), _uA(
                            _cE("text", _uM("class" to "common", "style" to _nS(_uM("line-height" to "75px")), "flatten" to ""), "line-height: 75px", 4),
                            _cE("text", _uM("class" to "line-height-3 common", "flatten" to ""), "line-height: 3"),
                            _cE("text", _uM("class" to "common", "style" to _nS(_uM("line-height" to "3em")), "flatten" to ""), "line-height: 3em", 4),
                            _cE("text", _uM("class" to "common", "style" to _nS(_uM("line-height" to "3")), "flatten" to ""), "line-height: 3\nline-height: 3\nline-height: 3", 4)
                        ))
                    )),
                    _cE("view", _uM("class" to "uni-common-mt"), _uA(
                        _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 line-height ")
                    )),
                    _cE("view", _uM("class" to "common-box"), _uA(
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "line-height"),
                            _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data).lineHeight), 1),
                            _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data).lineHeightActual), 1),
                            _cE("view", _uM("class" to "test-box"), _uA(
                                _cE("text", _uM("ref_key" to "textRef", "ref" to textRef, "class" to "common", "style" to _nS(_uM("lineHeight" to unref(data).lineHeight))), "当前 line-height: " + _tD(unref(data).lineHeight), 5)
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "拍平"),
                            _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data).lineHeight), 1),
                            _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data).lineHeightActualFlat), 1),
                            _cE("view", _uM("class" to "test-box"), _uA(
                                _cE("text", _uM("ref_key" to "textRefFlat", "ref" to textRefFlat, "class" to "common", "style" to _nS(_uM("lineHeight" to unref(data).lineHeight)), "flatten" to ""), "当前 line-height: " + _tD(unref(data).lineHeight), 5)
                            ))
                        ))
                    )),
                    _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                        _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                        _cV(_component_enum_data, _uM("items" to lineHeightEnum, "title" to "line-height 枚举值", "onChange" to radioChangeLineHeight, "compact" to true)),
                        _cV(_component_input_data, _uM("defaultValue" to unref(data).lineHeight, "title" to "line-height 自定义值", "type" to "text", "onConfirm" to inputChangeLineHeight), null, 8, _uA(
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
                return _uM("common" to _pS(_uM("fontSize" to 20, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#00FFFF", "borderRightColor" to "#00FFFF", "borderBottomColor" to "#00FFFF", "borderLeftColor" to "#00FFFF", "marginTop" to 10, "marginRight" to 0, "marginBottom" to 10, "marginLeft" to 0, "paddingTop" to 0, "paddingRight" to 10, "paddingBottom" to 0, "paddingLeft" to 10)), "line-height-3" to _pS(_uM("lineHeight" to 3)), "box" to _pS(_uM("height" to 500, "backgroundColor" to "#808080", "justifyContent" to "center", "alignItems" to "center", "flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "demo-box" to _pS(_uM("flexDirection" to "row", "marginTop" to 10, "justifyContent" to "space-around")), "common-box" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-around")), "test-box" to _pS(_uM("width" to 180, "height" to 150, "backgroundColor" to "#808080", "justifyContent" to "center", "alignItems" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
