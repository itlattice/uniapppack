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
open class GenPagesComponentPickerViewPickerView : BasePage {
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
    open var data: DataType__30
        get() {
            return unref(this.`$exposed`["data"]) as DataType__30
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var setIndicatorStyle: (checked: Boolean) -> Unit
        get() {
            return unref(this.`$exposed`["setIndicatorStyle"]) as (checked: Boolean) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setIndicatorStyle", value)
        }
    open var setIndicatorClass: (checked: Boolean) -> Unit
        get() {
            return unref(this.`$exposed`["setIndicatorClass"]) as (checked: Boolean) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setIndicatorClass", value)
        }
    open var setMaskStyle: (checked: Boolean) -> Unit
        get() {
            return unref(this.`$exposed`["setMaskStyle"]) as (checked: Boolean) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setMaskStyle", value)
        }
    open var setMaskClass: (checked: Boolean) -> Unit
        get() {
            return unref(this.`$exposed`["setMaskClass"]) as (checked: Boolean) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setMaskClass", value)
        }
    open var setMaskTopStyle: (checked: Boolean) -> Unit
        get() {
            return unref(this.`$exposed`["setMaskTopStyle"]) as (checked: Boolean) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setMaskTopStyle", value)
        }
    open var setMaskBottomStyle: (checked: Boolean) -> Unit
        get() {
            return unref(this.`$exposed`["setMaskBottomStyle"]) as (checked: Boolean) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setMaskBottomStyle", value)
        }
    open var getEventCallbackNum: () -> Number
        get() {
            return unref(this.`$exposed`["getEventCallbackNum"]) as () -> Number
        }
        set(value) {
            setRefValue(this.`$exposed`, "getEventCallbackNum", value)
        }
    open var setEventCallbackNumTest: (num: Number) -> Unit
        get() {
            return unref(this.`$exposed`["setEventCallbackNumTest"]) as (num: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setEventCallbackNumTest", value)
        }
    open var setValue: () -> Unit
        get() {
            return unref(this.`$exposed`["setValue"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setValue", value)
        }
    open var setValue1: () -> Unit
        get() {
            return unref(this.`$exposed`["setValue1"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setValue1", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentPickerViewPickerView, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentPickerViewPickerView
            val _cache = __ins.renderCache
            val _years: UTSArray<Number> = _uA()
            val _year: Number = 2018
            val _months: UTSArray<Number> = _uA()
            val _month: Number = 1
            val _days: UTSArray<Number> = _uA()
            val _day: Number = 12
            run {
                var i: Number = 2000
                while(i <= _year){
                    _years.push(i)
                    i++
                }
            }
            run {
                var i: Number = 1
                while(i <= 12){
                    _months.push(i)
                    i++
                }
            }
            run {
                var i: Number = 1
                while(i <= 31){
                    _days.push(i)
                    i++
                }
            }
            val data = reactive(DataType__30(title = "picker-view", years = _years, year = _year, months = _months, month = _month, days = _days, day = _day, value = _uA(
                _year - 2000,
                _month - 1,
                _day - 1
            ), result = _uA(), indicatorStyle = "height: 50px;", indicatorClass = "", maskStyle = "", maskClass = "", maskTopStyle = "", maskBottomStyle = ""))
            val setIndicatorStyle = fun(checked: Boolean){
                val extraStyle = "height: 50px;border:#ff5500 solid 1px;background:rgba(182, 179, 255, 0.4);"
                data.indicatorStyle = if (checked) {
                    extraStyle
                } else {
                    "height: 50px;"
                }
            }
            val setIndicatorClass = fun(checked: Boolean){
                data.indicatorClass = if (checked) {
                    "indicator-test"
                } else {
                    ""
                }
            }
            val setMaskStyle = fun(checked: Boolean){
                val extraMaskStyle = "background-image: linear-gradient(to bottom, #d8e5ff, rgba(216, 229, 255, 0));"
                data.maskStyle = if (checked) {
                    extraMaskStyle
                } else {
                    ""
                }
            }
            val setMaskClass = fun(checked: Boolean){
                data.maskClass = if (checked) {
                    "mask-test"
                } else {
                    ""
                }
            }
            val setMaskTopStyle = fun(checked: Boolean){
                val linearToTop = "background-image: linear-gradient(to bottom, #f4ff73, rgba(216, 229, 255, 0));"
                data.maskTopStyle = if (checked) {
                    linearToTop
                } else {
                    ""
                }
            }
            val setMaskBottomStyle = fun(checked: Boolean){
                val linearToBottom = "background-image: linear-gradient(to top, #f4ff73, rgba(216, 229, 255, 0));"
                data.maskBottomStyle = if (checked) {
                    linearToBottom
                } else {
                    ""
                }
            }
            val getEventCallbackNum = fun(): Number {
                return state.eventCallbackNum
            }
            val setEventCallbackNumTest = fun(num: Number){
                setEventCallbackNum(num)
            }
            val bindChange = fun(e: UniPickerViewChangeEvent){
                if ((e.target?.tagName ?: "").includes("PICKER-VIEW")) {
                    setEventCallbackNumTest(state.eventCallbackNum + 1)
                }
                if (e.type === "change") {
                    setEventCallbackNumTest(state.eventCallbackNum + 2)
                }
                val kVal = e.detail.value
                data.result = kVal
                data.year = data.years[kVal[0]]
                data.month = data.months[kVal[1]]
                data.day = data.days[kVal[2]]
            }
            val setValue = fun(){
                data.value = _uA<Number>(0, 1, 30)
            }
            val setValue1 = fun(){
                data.value = _uA<Number>(10, 10, 10)
            }
            __expose(_uM("data" to data, "setIndicatorStyle" to setIndicatorStyle, "setIndicatorClass" to setIndicatorClass, "setMaskStyle" to setMaskStyle, "setMaskClass" to setMaskClass, "setMaskTopStyle" to setMaskTopStyle, "setMaskBottomStyle" to setMaskBottomStyle, "getEventCallbackNum" to getEventCallbackNum, "setEventCallbackNumTest" to setEventCallbackNumTest, "setValue" to setValue, "setValue1" to setValue1))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                val _component_picker_view_column = resolveComponent("picker-view-column")
                val _component_picker_view = resolveComponent("picker-view")
                val _component_boolean_data = resolveEasyComponent("boolean-data", GenComponentsBooleanDataBooleanDataClass)
                return _cE("view", null, _uA(
                    _cV(_component_page_head, _uM("title" to unref(data).title), null, 8, _uA(
                        "title"
                    )),
                    _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                        _cE("view", _uM("class" to "uni-title"), " 日期：" + _tD(unref(data).year) + "年" + _tD(unref(data).month) + "月" + _tD(unref(data).day) + "日 ", 1)
                    )),
                    _cV(_component_picker_view, _uM("class" to "picker-view", "value" to unref(data).value, "onChange" to bindChange, "indicator-style" to unref(data).indicatorStyle, "indicator-class" to unref(data).indicatorClass, "mask-style" to unref(data).maskStyle, "mask-class" to unref(data).maskClass, "mask-top-style" to unref(data).maskTopStyle, "mask-bottom-style" to unref(data).maskBottomStyle), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cV(_component_picker_view_column, _uM("class" to "picker-view-column"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(unref(data).years, fun(item, index, __index, _cached): Any {
                                        return _cE("view", _uM("class" to "item", "key" to index), _uA(
                                            _cE("text", _uM("class" to "text"), _tD(item) + "年", 1)
                                        ))
                                    }
                                    ), 128)
                                )
                            }
                            ), "_" to 1)),
                            _cV(_component_picker_view_column, _uM("class" to "picker-view-column"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(unref(data).months, fun(item, index, __index, _cached): Any {
                                        return _cE("view", _uM("class" to "item", "key" to index), _uA(
                                            _cE("text", _uM("class" to "text"), _tD(item) + "月", 1)
                                        ))
                                    }
                                    ), 128)
                                )
                            }
                            ), "_" to 1)),
                            _cV(_component_picker_view_column, _uM("class" to "picker-view-column"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(unref(data).days, fun(item, index, __index, _cached): Any {
                                        return _cE("view", _uM("class" to "item", "key" to index), _uA(
                                            _cE("text", _uM("class" to "text"), _tD(item) + "日", 1)
                                        ))
                                    }
                                    ), 128)
                                )
                            }
                            ), "_" to 1))
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "value",
                        "indicator-style",
                        "indicator-class",
                        "mask-style",
                        "mask-class",
                        "mask-top-style",
                        "mask-bottom-style"
                    )),
                    _cV(_component_boolean_data, _uM("defaultValue" to false, "title" to "设置选择器中间选中框的样式", "onChange" to setIndicatorStyle)),
                    _cV(_component_boolean_data, _uM("defaultValue" to false, "title" to "设置蒙层上半部分的样式", "onChange" to setMaskTopStyle)),
                    _cV(_component_boolean_data, _uM("defaultValue" to false, "title" to "设置蒙层下半部分的样式", "onChange" to setMaskBottomStyle))
                ))
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("picker-view" to _pS(_uM("width" to "100%", "height" to 320, "marginTop" to 10, "marginBottom" to 20)), "item" to _pS(_uM("height" to 50)), "text" to _pS(_uM("lineHeight" to "50px", "textAlign" to "center")), "indicator-test" to _pS(_uM("height" to 50, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#ff5500", "borderRightColor" to "#ff5500", "borderBottomColor" to "#ff5500", "borderLeftColor" to "#ff5500", "backgroundImage" to "none", "backgroundColor" to "rgba(182,179,255,0.4)")), "mask-test" to _pS(_uM("backgroundImage" to "linear-gradient(to bottom, #d8e5ff, rgba(216, 229, 255, 0))")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
