@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNI2971F61
import android.content.Context
import io.dcloud.uniapp.*
import io.dcloud.uniapp.extapi.*
import io.dcloud.uniapp.framework.*
import io.dcloud.uniapp.runtime.*
import io.dcloud.uniapp.vue.*
import io.dcloud.uniapp.vue.shared.*
import io.dcloud.uts.*
import io.dcloud.uts.Map
import io.dcloud.uts.Set
import io.dcloud.uts.UTSAndroid
import kotlin.properties.Delegates
import uts.sdk.modules.iboxsChooseMedia.MediaScanner
open class GenUniModulesTmxUiComponentsTmxDateViewTmxDateView : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var modelValue: String by `$props`
    open var modelStr: String by `$props`
    open var title: String by `$props`
    open var start: String by `$props`
    open var end: String by `$props`
    open var type: String by `$props`
    open var format: String by `$props`
    open var formatSyncValue: Boolean by `$props`
    open var cellUnits: UTSArray<String> by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesTmxUiComponentsTmxDateViewTmxDateView) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesTmxUiComponentsTmxDateViewTmxDateView
            val _cache = __ins.renderCache
            val i18n = xConfig.i18n
            val props = __props
            fun emits(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            var startValue = xDate(xDate().format("YYYY-MM-DD 00:00:00"))
            var endValue = xDate(xDate().format("YYYY-MM-DD 59:59:59"))
            startValue.subtraction(1, "y")
            val nowValue = ref(_uA<UTSArray<String>>())
            val nowValueStr = ref("")
            val startDate = ref<xDate>(startValue)
            val endDate = ref<xDate>(endValue)
            val dateList = ref(_uA<UTSArray<X_PICKER_X_ITEM>>())
            val changeIndex = ref(0)
            val nowPull = ref(false)
            val updateDateListTimer = ref(0)
            val isUpdatingDateList = ref(false)
            val lastChangeStr = ref("")
            val nowValueDate = ref(xDate())
            val _cellUnits = computed(fun(): UTSArray<String> {
                if (props.cellUnits.length == 0) {
                    return _uA(
                        i18n.t("tmui4x.pickerDate.year"),
                        i18n.t("tmui4x.pickerDate.month"),
                        i18n.t("tmui4x.pickerDate.day"),
                        i18n.t("tmui4x.pickerDate.hour"),
                        i18n.t("tmui4x.pickerDate.minute"),
                        i18n.t("tmui4x.pickerDate.second")
                    )
                }
                return props.cellUnits
            }
            )
            val _start_date = computed(fun(): xDate {
                if (props.start == "") {
                    return startDate.value as xDate
                }
                return xDate(props.start)
            }
            )
            val _end_date = computed(fun(): xDate {
                if (props.end == "") {
                    return endDate.value as xDate
                }
                return xDate(props.end)
            }
            )
            val _getDateType = computed(fun(): xDateTypeTime {
                var isType = "s" as xDateTypeTime
                if (props.type == "year") {
                    isType = "y"
                }
                if (props.type == "month") {
                    isType = "m"
                }
                if (props.type == "day") {
                    isType = "d"
                }
                if (props.type == "hour") {
                    isType = "h"
                }
                if (props.type == "minute") {
                    isType = "M"
                }
                return isType
            }
            )
            val getNowTypeLenIndex = fun(): Number {
                var index: Number = 6
                if (props.type == "year") {
                    index = 1
                } else if (props.type == "month") {
                    index = 2
                } else if (props.type == "day") {
                    index = 3
                } else if (props.type == "hour") {
                    index = 4
                } else if (props.type == "minute") {
                    index = 5
                }
                return index
            }
            val fillNumber = fun(n: String): String {
                if (parseInt(n) > 9) {
                    return n
                }
                return "0" + n
            }
            val getRangByDateTime = fun(d: xDate): coverValue {
                var nowRange = _uA<UTSArray<String>>(_uA(
                    d.getYear().toString(10)
                ), _uA(
                    (d.getMonth() + 1).toString(10)
                ), _uA(
                    d.getDate().toString(10)
                ), _uA(
                    d.getHours().toString(10)
                ), _uA(
                    d.getMinutes().toString(10)
                ), _uA(
                    d.getSeconds().toString(10)
                ))
                var nowRangeStr = d.getYear().toString(10) + "-" + (d.getMonth() + 1).toString(10) + "-" + d.getDate().toString(10) + " " + d.getHours().toString(10) + ":" + d.getMinutes().toString(10) + ":" + d.getSeconds().toString(10)
                return coverValue(value = nowRange as UTSArray<UTSArray<String>>, str = nowRangeStr)
            }
            val formatTimeDate = fun(): String {
                if (nowValue.value.length != 6) {
                    return ""
                }
                var sp = props.format
                sp = sp.replace(UTSRegExp("YYYY", "g"), fillNumber(nowValue.value[0][0]))
                sp = sp.replace(UTSRegExp("MM", "g"), fillNumber(parseInt(nowValue.value[1][0]).toString(10)))
                sp = sp.replace(UTSRegExp("DD", "g"), fillNumber(nowValue.value[2][0]))
                sp = sp.replace(UTSRegExp("hh", "g"), fillNumber(nowValue.value[3][0]))
                sp = sp.replace(UTSRegExp("mm", "g"), fillNumber(nowValue.value[4][0]))
                sp = sp.replace(UTSRegExp("ss", "g"), fillNumber(nowValue.value[5][0]))
                return sp
            }
            val getRangCuror = fun(start: xDate, end: xDate, currentDate: xDate, type: String): UTSArray<Number> {
                var max: Number = 0
                var min: Number = 0
                val currentTime = currentDate.date.getTime()
                val startTime = start.date.getTime()
                val endTime = end.date.getTime()
                val isBeforeStart = currentTime < startTime
                val isAfterEnd = currentTime > endTime
                if (type == "year") {
                    min = start.getYear()
                    max = end.getYear()
                } else if (type == "month") {
                    if (isBeforeStart || currentDate.getYear() == start.getYear()) {
                        min = start.getMonth()
                    } else {
                        min = 0
                    }
                    if (isAfterEnd || currentDate.getYear() == end.getYear()) {
                        max = end.getMonth()
                    } else {
                        max = 11
                    }
                    min += 1
                    max += 1
                } else if (type == "day") {
                    if (isBeforeStart || (currentDate.getYear() == start.getYear() && currentDate.getMonth() == start.getMonth())) {
                        min = start.getDate()
                    } else {
                        min = 1
                    }
                    if (isAfterEnd || (currentDate.getYear() == end.getYear() && currentDate.getMonth() == end.getMonth())) {
                        max = end.getDate()
                    } else {
                        max = currentDate.getMonthCountDay()
                    }
                } else if (type == "hour") {
                    if (isBeforeStart || (currentDate.getYear() == start.getYear() && currentDate.getMonth() == start.getMonth() && currentDate.getDate() == start.getDate())) {
                        min = start.getHours()
                    } else {
                        min = 0
                    }
                    if (isAfterEnd || (currentDate.getYear() == end.getYear() && currentDate.getMonth() == end.getMonth() && currentDate.getDate() == end.getDate())) {
                        max = end.getHours()
                    } else {
                        max = 23
                    }
                } else if (type == "minute") {
                    if (isBeforeStart || (currentDate.getYear() == start.getYear() && currentDate.getMonth() == start.getMonth() && currentDate.getDate() == start.getDate() && currentDate.getHours() == start.getHours())) {
                        min = start.getMinutes()
                    } else {
                        min = 0
                    }
                    if (isAfterEnd || (currentDate.getYear() == end.getYear() && currentDate.getMonth() == end.getMonth() && currentDate.getDate() == end.getDate() && currentDate.getHours() == end.getHours())) {
                        max = end.getMinutes()
                    } else {
                        max = 59
                    }
                } else if (type == "second") {
                    if (isBeforeStart || (currentDate.getYear() == start.getYear() && currentDate.getMonth() == start.getMonth() && currentDate.getDate() == start.getDate() && currentDate.getHours() == start.getHours() && currentDate.getMinutes() == start.getMinutes())) {
                        min = start.getSeconds()
                    } else {
                        min = 0
                    }
                    if (isAfterEnd || (currentDate.getYear() == end.getYear() && currentDate.getMonth() == end.getMonth() && currentDate.getDate() == end.getDate() && currentDate.getHours() == end.getHours() && currentDate.getMinutes() == end.getMinutes())) {
                        max = end.getSeconds()
                    } else {
                        max = 59
                    }
                }
                return _uA(
                    min,
                    max
                )
            }
            val getTreeDate = fun(start: xDate, end: xDate, nowValue: xDate): UTSArray<UTSArray<X_PICKER_X_ITEM>> {
                var r = _uA(
                    getRangCuror(start, end, nowValue, "year"),
                    getRangCuror(start, end, nowValue, "month"),
                    getRangCuror(start, end, nowValue, "day"),
                    getRangCuror(start, end, nowValue, "hour"),
                    getRangCuror(start, end, nowValue, "minute"),
                    getRangCuror(start, end, nowValue, "second")
                )
                val d = r.splice(0, getNowTypeLenIndex()).map(fun(el: UTSArray<Number>): UTSArray<X_PICKER_X_ITEM> {
                    var min = el[0]
                    var max = el[1]
                    var result: UTSArray<X_PICKER_X_ITEM> = _uA()
                    run {
                        var i = min
                        while(i < max + 1){
                            result.push(X_PICKER_X_ITEM(id = i.toString(10), title = fillNumber(i.toString(10)), children = _uA(), disabled = false))
                            i++
                        }
                    }
                    return result
                }
                )
                return d
            }
            val stringArValuCoverToString = fun(): String {
                if (nowValue.value.length != 6) {
                    return ""
                }
                var newsday = xDate(nowValue.value[0][0] + "-" + parseInt(nowValue.value[1][0]).toString(10) + "-1")
                var days = parseInt(nowValue.value[2][0])
                days = if (days >= newsday.getMonthCountDay()) {
                    newsday.getMonthCountDay()
                } else {
                    days
                }
                nowValue.value.splice(2, 1, _uA(
                    days.toString(10)
                ))
                return fillNumber(nowValue.value[0][0]) + "-" + fillNumber(parseInt(nowValue.value[1][0]).toString(10)) + "-" + fillNumber(nowValue.value[2][0]) + " " + fillNumber(nowValue.value[3][0]) + ":" + fillNumber(nowValue.value[4][0]) + ":" + fillNumber(nowValue.value[5][0])
            }
            val onConfirm = fun(){
                val syncValue: String = if (props.formatSyncValue) {
                    formatTimeDate()
                } else {
                    (toRaw(nowValueStr.value) as String)
                }
                emits("update:modelValue", syncValue)
                emits("update:modelStr", formatTimeDate())
            }
            val defaultModelvalue = fun(newvalue: String, showStr: Boolean){
                var isType = _getDateType.value
                var nowValueDate = xDate(newvalue)
                if (nowValueDate.isBetweenOf(_start_date.value, "<=", isType)) {
                    nowValueDate = _start_date.value
                }
                if (nowValueDate.isBetweenOf(_end_date.value, ">=", isType)) {
                    nowValueDate = _end_date.value
                }
                var stp = getRangByDateTime(nowValueDate)
                dateList.value = getTreeDate(_start_date.value, _end_date.value, nowValueDate)
                nowValue.value = stp.value
                nowValueStr.value = stp.str
                if (showStr) {
                    emits("update:modelStr", formatTimeDate())
                }
            }
            val mchange = fun(ids: UTSArray<String>, index: Number){
                nowValue.value.splice(index, 1, ids)
                nowValueStr.value = stringArValuCoverToString()
                dateList.value = getTreeDate(_start_date.value, _end_date.value, xDate(nowValueStr.value))
                onConfirm()
                emits("change", nowValueStr.value)
            }
            val onTouchstart = fun(){
                setPagePullRefresh(false)
            }
            val onTouchend = fun(){
                setPagePullRefresh(nowPull.value)
            }
            watch(fun(): String {
                return props.modelValue
            }
            , fun(newvalue: String){
                if (newvalue == "") {
                    return
                }
                nowValueStr.value = newvalue
                defaultModelvalue(newvalue, true)
            }
            )
            onMounted(fun(){
                nowPull.value = getPagePullRefresh()
                var nowValueInit = xDate(props.modelValue)
                defaultModelvalue(nowValueInit.format("YYYY-MM-DD hh:mm:ss"), props.modelValue != "")
            }
            )
            onBeforeUnmount(fun(){
                clearTimeout(updateDateListTimer.value)
            }
            )
            return fun(): Any? {
                val _component_tmx_picker_view = resolveEasyComponent("tmx-picker-view", GenUniModulesTmxUiComponentsTmxPickerViewTmxPickerViewClass)
                return _cE("view", _uM("class" to "xPickerDateWrap", "onTouchstart" to onTouchstart, "onTouchend" to onTouchend, "onTouchcancel" to onTouchend), _uA(
                    _cE(Fragment, null, RenderHelpers.renderList(dateList.value, fun(item, index, __index, _cached): Any {
                        return _cV(_component_tmx_picker_view, _uM("cellUnits" to _uA(
                            _cellUnits.value[index]
                        ), "onChange" to fun(`$event`: Any){
                            mchange(`$event` as UTSArray<String>, index)
                        }
                        , "model-value" to nowValue.value[index], "style" to _nS(_uM("flex" to "1")), "listPro" to item, "key" to index), null, 8, _uA(
                            "cellUnits",
                            "onChange",
                            "model-value",
                            "style",
                            "listPro"
                        ))
                    }
                    ), 128)
                ), 32)
            }
        }
        var name = "xDateView"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("xPickerDateWrap" to _pS(_uM("display" to "flex", "flexDirection" to "row")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("change" to null, "update:modelStr" to null, "update:modelValue" to null)
        var props = _nP(_uM("modelValue" to _uM("type" to "String", "default" to ""), "modelStr" to _uM("type" to "String", "default" to ""), "title" to _uM("type" to "String", "default" to "请选择时间"), "start" to _uM("type" to "String", "default" to ""), "end" to _uM("type" to "String", "default" to ""), "type" to _uM("type" to "String", "default" to "day"), "format" to _uM("type" to "String", "default" to "YYYY-MM-DD"), "formatSyncValue" to _uM("type" to "Boolean", "default" to false), "cellUnits" to _uM("type" to "Array", "default" to fun(): UTSArray<String> {
            return _uA<String>()
        }
        )))
        var propsNeedCastKeys = _uA(
            "modelValue",
            "modelStr",
            "title",
            "start",
            "end",
            "type",
            "format",
            "formatSyncValue",
            "cellUnits"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
