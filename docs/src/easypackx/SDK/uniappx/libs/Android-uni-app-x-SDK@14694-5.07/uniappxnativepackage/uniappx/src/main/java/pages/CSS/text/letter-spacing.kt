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
open class GenPagesCSSTextLetterSpacing : BasePage {
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
    open var autoTestData: AutoTextData
        get() {
            return unref(this.`$exposed`["autoTestData"]) as AutoTextData
        }
        set(value) {
            setRefValue(this.`$exposed`, "autoTestData", value)
        }
    open var getLetterSpacing: () -> Number
        get() {
            return unref(this.`$exposed`["getLetterSpacing"]) as () -> Number
        }
        set(value) {
            setRefValue(this.`$exposed`, "getLetterSpacing", value)
        }
    open var plusLetterSpacing: () -> Unit
        get() {
            return unref(this.`$exposed`["plusLetterSpacing"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "plusLetterSpacing", value)
        }
    open var minusLetterSpacing: () -> Unit
        get() {
            return unref(this.`$exposed`["minusLetterSpacing"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "minusLetterSpacing", value)
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
        var setup: (__props: GenPagesCSSTextLetterSpacing, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSTextLetterSpacing
            val _cache = __ins.renderCache
            val letterSpacingEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "0"),
                ItemType(value = 2, name = "0px"),
                ItemType(value = 3, name = "-2px"),
                ItemType(value = 4, name = "2px"),
                ItemType(value = 5, name = "5px"),
                ItemType(value = 6, name = "10px")
            ) as UTSArray<ItemType>
            val data = reactive(_uO("letterSpacing" to "0px", "letterSpacingActual" to "", "letterSpacingActualFlat" to ""))
            val letterSpacing_mix = ref(1)
            val textRef = ref(null as UniTextElement?)
            val textRefFlat = ref(null as UniTextElement?)
            val getPropertyValues = fun(){
                data["letterSpacingActual"] = textRef.value?.style?.getPropertyValue("letter-spacing") ?: ""
                data["letterSpacingActualFlat"] = textRefFlat.value?.style?.getPropertyValue("letter-spacing") ?: ""
            }
            val changeLetterSpacing = fun(value: String){
                data["letterSpacing"] = value
                textRef.value?.style?.setProperty("letter-spacing", value)
                textRefFlat.value?.style?.setProperty("letter-spacing", value)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangeLetterSpacing = fun(index: Number){
                val selectedItem = letterSpacingEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changeLetterSpacing(selectedItem.name)
                }
            }
            val inputChangeLetterSpacing = fun(value: String){
                changeLetterSpacing(value)
            }
            val autoTestData = reactive<AutoTextData>(AutoTextData(begin = false))
            fun gen_plusLetterSpacing_fn() {
                letterSpacing_mix.value += 0.2
            }
            val plusLetterSpacing = ::gen_plusLetterSpacing_fn
            fun gen_minusLetterSpacing_fn() {
                letterSpacing_mix.value -= 0.2
            }
            val minusLetterSpacing = ::gen_minusLetterSpacing_fn
            fun gen_getLetterSpacing_fn(): Number {
                val testText = uni_getElementById("testText")
                if (testText != null) {
                    return parseFloat(testText.style.getPropertyValue("letter-spacing"))
                }
                return 0
            }
            val getLetterSpacing = ::gen_getLetterSpacing_fn
            __expose(_uM("autoTestData" to autoTestData, "getLetterSpacing" to getLetterSpacing, "plusLetterSpacing" to plusLetterSpacing, "minusLetterSpacing" to minusLetterSpacing, "data" to data))
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
                            _cE("text", _uM("id" to "testText", "style" to _nS("letter-spacing:" + unref(letterSpacing_mix) + "px;")), " uni-app 是一个使用 Vue.js 开发所有前端应用的框架，开发者编写一套代码，可发布到iOS、Android、鸿蒙Next、Web（响应式）、以及各种小程序（微信/支付宝/百度/抖音/飞书/QQ/快手/钉钉/淘宝/京东/小红书）、快应用、鸿蒙元服务等多个平台。", 4),
                            _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row"))), _uA(
                                _cE("button", _uM("onClick" to plusLetterSpacing), "+字宽"),
                                _cE("button", _uM("onClick" to minusLetterSpacing), "-字宽")
                            ), 4)
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1"))), _uA(
                        _cE("view", _uM("class" to "box"), _uA(
                            _cE("text", _uM("class" to "common"), "letter-spacing"),
                            _cE("text", _uM("class" to "common", "style" to _nS(_uM("letter-spacing" to "5px"))), "letter-spacing: 5px", 4),
                            _cE("text", _uM("class" to "common", "style" to _nS(_uM("letter-spacing" to "-2px"))), "letter-spacing: -2px", 4)
                        )),
                        _cE("text", _uM("class" to "uni-title-text"), "拍平"),
                        _cE("view", _uM("class" to "box"), _uA(
                            _cE("text", _uM("class" to "common"), "letter-spacing"),
                            _cE("text", _uM("class" to "common", "style" to _nS(_uM("letter-spacing" to "5px")), "flatten" to ""), "letter-spacing: 5px", 4),
                            _cE("text", _uM("class" to "common", "style" to _nS(_uM("letter-spacing" to "-2px")), "flatten" to ""), "letter-spacing: -2px", 4)
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 letter-spacing 测试")
                        )),
                        _cE("view", _uM("class" to "common-box"), _uA(
                            _cE("view", _uM("class" to "uni-common-mt"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "letter-spacing"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["letterSpacing"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["letterSpacingActual"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRef", "ref" to textRef, "class" to "common-text", "style" to _nS(_uM("letterSpacing" to unref(data)["letterSpacing"]))), "当前 letter-spacing: " + _tD(unref(data)["letterSpacing"]), 5)
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-common-mt"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["letterSpacing"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["letterSpacingActualFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRefFlat", "ref" to textRefFlat, "class" to "common-text", "style" to _nS(_uM("letterSpacing" to unref(data)["letterSpacing"])), "flatten" to ""), "当前 letter-spacing: " + _tD(unref(data)["letterSpacing"]), 5)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                            _cV(_component_enum_data, _uM("items" to letterSpacingEnum, "title" to "letter-spacing 枚举值", "onChange" to radioChangeLetterSpacing, "compact" to true)),
                            _cV(_component_input_data, _uM("defaultValue" to unref(data)["letterSpacing"], "title" to "letter-spacing 自定义值", "type" to "text", "onConfirm" to inputChangeLetterSpacing), null, 8, _uA(
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
                return _uM("common" to _pS(_uM("fontSize" to 20)), "box" to _pS(_uM("height" to 110, "backgroundColor" to "#808080", "justifyContent" to "center", "alignItems" to "center")), "common-text" to _pS(_uM("fontSize" to 14)), "common-box" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-around")), "test-box" to _pS(_uM("width" to 180, "height" to 80, "backgroundColor" to "#808080", "justifyContent" to "center", "alignItems" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
