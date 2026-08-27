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
open class GenUniModulesTmxUiComponentsTmxBetweenTimeTmxBetweenTime : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var modelValue: UTSArray<String> by `$props`
    open var modelStr: String by `$props`
    open var modelShow: Boolean by `$props`
    open var title: String by `$props`
    open var start: String by `$props`
    open var end: String by `$props`
    open var type: String by `$props`
    open var format: String by `$props`
    open var cellUnits: UTSArray<String> by `$props`
    open var quickDate: UTSArray<Any> by `$props`
    open var lazyContent: Boolean by `$props`
    open var drawerSize: String by `$props`
    open var disabledClear: Boolean by `$props`
    open var disabled: Boolean by `$props`
    open var widthCoverCenter: Boolean by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    open var open: () -> Unit
        get() {
            return unref(this.`$exposed`["open"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "open", value)
        }
    open var close: () -> Unit
        get() {
            return unref(this.`$exposed`["close"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "close", value)
        }
    open var clear: () -> Unit
        get() {
            return unref(this.`$exposed`["clear"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "clear", value)
        }
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesTmxUiComponentsTmxBetweenTimeTmxBetweenTime, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesTmxUiComponentsTmxBetweenTimeTmxBetweenTime
            val _cache = __ins.renderCache
            val i18n = xConfig.i18n
            fun emits(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val props = __props
            var startValue = xDate(xDate().format("YYYY-MM-DD 00:00:00"))
            var endValue = xDate(xDate().format("YYYY-MM-DD 59:59:59"))
            startValue.subtraction(1, "y")
            val show = ref(false)
            val nowValue = ref(_uA<String>("", ""))
            val nowModelValue = ref(_uA<String>("", ""))
            val startDate = ref(startValue)
            val endDate = ref(endValue)
            val changeIndex = ref(0)
            val yanchiDuration = ref(false)
            val quicklist = ref(_uA<coverValueType>())
            val quicklistSelectedStr = ref("")
            var tid: Number = 0
            val _formatValStr = computed(fun(): UTSArray<String> {
                var estrt = nowValue.value?.get(0) ?: ""
                var eend = nowValue.value?.get(1) ?: ""
                var selfformat = if (props.format == "") {
                    "YYYY-MM-DD"
                } else {
                    props.format
                }
                var start = if (estrt == "") {
                    ""
                } else {
                    xDate(estrt).format(selfformat)
                }
                var ebd = if (eend == "") {
                    ""
                } else {
                    xDate(eend).format(selfformat)
                }
                return _uA<String>(start, ebd)
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
            val _start_date_str = computed(fun(): String {
                return _start_date.value.format()
            }
            )
            val _end_date_str = computed(fun(): String {
                return _end_date.value.format()
            }
            )
            val _start_date_str_format = computed(fun(): String {
                if (nowValue.value[0] == "") {
                    return xConfig.i18n.t("tmui4x.betweentTime.start")
                }
                if (props.format != "") {
                    return xDate(nowValue.value[0]).format(props.format)
                }
                return xConfig.i18n.d(nowValue.value[0], null, DateTimeFormatOrNull(year = "numeric", month = "numeric", day = "numeric"))
            }
            )
            val _end_date_str_format = computed(fun(): String {
                if (nowValue.value[1] == "") {
                    return xConfig.i18n.t("tmui4x.betweentTime.end")
                }
                if (props.format != "") {
                    return xDate(nowValue.value[1]).format(props.format)
                }
                return xConfig.i18n.d(nowValue.value[1], null, DateTimeFormatOrNull(year = "numeric", month = "numeric", day = "numeric"))
            }
            )
            val _backgroundColor = computed(fun(): String {
                if (xConfig.dark == "dark") {
                    return getDefaultColor(xConfig.inputDarkColor)
                }
                return getDefaultColor(xConfig.inputBgColor)
            }
            )
            val _borderColor = computed(fun(): String {
                if (xConfig.dark == "dark") {
                    return getDefaultColor(xConfig.borderDarkColor)
                }
                return getDefaultColor(xConfig.inputBgColor)
            }
            )
            val _activeBorderColor = computed(fun(): String {
                return getDefaultColor(xConfig.color)
            }
            )
            val _placeStyle = computed(fun(): String {
                if (xConfig.dark == "dark") {
                    return "color:#c7c7c7;"
                }
                return "color:#838383;"
            }
            )
            val _fontColor = computed(fun(): String {
                if (xConfig.dark == "dark") {
                    return "#efefef"
                }
                return "#333"
            }
            )
            val _isDark = computed(fun(): Boolean {
                return xConfig.dark == "dark"
            }
            )
            val _checkPass = computed(fun(): Boolean {
                return nowValue.value.some(fun(el: String): Boolean {
                    return el == ""
                }
                )
            }
            )
            val _cellUnits = computed(fun(): UTSArray<String> {
                if (props.cellUnits.length == 0) {
                    return _uA(
                        xConfig.i18n.t("tmui4x.pickerDate.year"),
                        xConfig.i18n.t("tmui4x.pickerDate.month"),
                        xConfig.i18n.t("tmui4x.pickerDate.day"),
                        xConfig.i18n.t("tmui4x.pickerDate.hour"),
                        xConfig.i18n.t("tmui4x.pickerDate.minute"),
                        xConfig.i18n.t("tmui4x.pickerDate.second")
                    )
                }
                return props.cellUnits
            }
            )
            fun gen_getTypes_fn(): xDateTypeTime {
                if (props.type == "year") {
                    return "y" as xDateTypeTime
                } else if (props.type == "month") {
                    return "m" as xDateTypeTime
                } else if (props.type == "day") {
                    return "d" as xDateTypeTime
                } else if (props.type == "hour") {
                    return "h" as xDateTypeTime
                } else if (props.type == "minute") {
                    return "M" as xDateTypeTime
                } else if (props.type == "second") {
                    return "s" as xDateTypeTime
                }
                return "s" as xDateTypeTime
            }
            val getTypes = ::gen_getTypes_fn
            fun gen_coverStrVal_fn(): String {
                var estrt = nowValue.value[0]
                var eend = nowValue.value[1]
                var selfformat = if (props.format == "") {
                    "YYYY-MM-DD"
                } else {
                    props.format
                }
                var start = if (estrt == "") {
                    ""
                } else {
                    xDate(estrt).format(selfformat)
                }
                var ebd = if (eend == "") {
                    ""
                } else {
                    xDate(eend).format(selfformat)
                }
                return start + "~" + ebd
            }
            val coverStrVal = ::gen_coverStrVal_fn
            fun gen_sorDateVaild_fn(str: UTSArray<String>): UTSArray<String> {
                var types = getTypes()
                str.sort(fun(a: String, b: String): Number {
                    return xDate(a).getTime(types) - xDate(b).getTime(types)
                }
                )
                return str
            }
            val sorDateVaild = ::gen_sorDateVaild_fn
            fun gen_validTimeDate_fn(kVal: UTSArray<String>): UTSArray<String> {
                var str = _uA(
                    "",
                    ""
                )
                if (kVal.length >= 1) {
                    str[0] = kVal[0]!!
                }
                if (kVal.length >= 2) {
                    str[1] = kVal[1]!!
                }
                return sorDateVaild(str)
            }
            val validTimeDate = ::gen_validTimeDate_fn
            fun gen_tongbuModelStr_fn() {
                var str = coverStrVal()
                emits("update:modelStr", if (str == "~") {
                    ""
                } else {
                    str
                }
                )
            }
            val tongbuModelStr = ::gen_tongbuModelStr_fn
            fun gen_getQuickDateType_fn(): UTSArray<coverValueType> {
                var typelist = _uA<coverValueType>()
                var list: UTSArray<Any> = props.quickDate
                if (list.length == 0) {
                    return typelist
                }
                var _date = xDate()
                var startFDate = "YYYY/MM/DD 00:00:00"
                var endFDate = "YYYY/MM/DD 23:59:59"
                var _start = xDate(xDate().getBetweenDate(_start_date_str.value, _end_date_str.value, "min")).format(startFDate)
                var _end = xDate(xDate().getBetweenDate(_start_date_str.value, _end_date_str.value, "max")).format(endFDate)
                _date = xDate(_start)
                run {
                    var i: Number = 0
                    while(i < list.length){
                        var item: Any = list[i]
                        if (UTSAndroid.`typeof`(item) == "string") {
                            if ((item as String).substring(0, 1) == "p") {
                                var dshi = parseInt((item as String).substring(1))!! as Number
                                var date = _date.getClone()
                                var start = _start
                                date.subtraction(dshi, "y")
                                date = xDate(date.getBetweenDate(_start_date_str.value, _end_date_str.value, "min"))
                                var end = date.format()
                                typelist.push(coverValueType(value = _uA(
                                    end,
                                    start
                                ), str = xConfig.i18n.t("tmui4x.betweentTime.quiakListTitle3", dshi)))
                            } else if (!isNaN(parseInt(item as String))) {
                                var dshi = parseInt(item as String)!! as Number
                                var date = _date.getClone()
                                var start = _start
                                date.subtraction(dshi, "d")
                                date = xDate(date.getBetweenDate(_start_date_str.value, _end_date_str.value, "min"))
                                var end = date.format()
                                typelist.push(coverValueType(value = _uA(
                                    end,
                                    start
                                ), str = xConfig.i18n.t("tmui4x.betweentTime.quiakListTitle2", dshi)))
                            } else {
                                var date = xDate(_end)
                                var startFDate = "YYYY/MM/DD 00:00:00"
                                var endFDate = "YYYY/MM/DD 23:59:59"
                                var start = date.format(startFDate)
                                var end = date.format(endFDate)
                                var desc = xConfig.i18n.t("tmui4x.betweentTime.quiakListTitle", 0)
                                if (item as String == "w") {
                                    start = date.getDateStartOf("w").format(startFDate)
                                    end = date.getDateEndOf("w").format(endFDate)
                                    start = xDate(xDate(start).getBetweenDate(_start_date_str.value, _end_date_str.value, "min")).format(startFDate)
                                    end = xDate(xDate(end).getBetweenDate(_start_date_str.value, _end_date_str.value, "max")).format(endFDate)
                                    desc = xConfig.i18n.t("tmui4x.betweentTime.quiakListTitle", 1)
                                } else if (item as String == "m") {
                                    start = date.getDateStartOf("m").format(startFDate)
                                    end = date.getDateEndOf("m").format(endFDate)
                                    start = xDate(xDate(start).getBetweenDate(_start_date_str.value, _end_date_str.value, "min")).format(startFDate)
                                    end = xDate(xDate(end).getBetweenDate(_start_date_str.value, _end_date_str.value, "max")).format(endFDate)
                                    desc = xConfig.i18n.t("tmui4x.betweentTime.quiakListTitle", 2)
                                } else if (item as String == "y") {
                                    start = date.getDateStartOf("y").format(startFDate)
                                    end = date.getDateEndOf("y").format(endFDate)
                                    start = xDate(xDate(start).getBetweenDate(_start_date_str.value, _end_date_str.value, "min")).format(startFDate)
                                    end = xDate(xDate(end).getBetweenDate(_start_date_str.value, _end_date_str.value, "max")).format(endFDate)
                                    desc = xConfig.i18n.t("tmui4x.betweentTime.quiakListTitle", 3)
                                } else if (item as String == "q") {
                                    var nowq = date.getQuarter("")
                                    var itemqatar = nowq[0]
                                    start = itemqatar.start
                                    end = itemqatar.end
                                    start = xDate(xDate(start).getBetweenDate(_start_date_str.value, _end_date_str.value, "min")).format(startFDate)
                                    end = xDate(xDate(end).getBetweenDate(_start_date_str.value, _end_date_str.value, "max")).format(endFDate)
                                    desc = xConfig.i18n.t("tmui4x.betweentTime.quiakListTitle", 4)
                                }
                                typelist.push(coverValueType(value = _uA(
                                    start,
                                    end
                                ), str = desc))
                            }
                        } else if (UTSAndroid.`typeof`(item) == "number") {
                            var dshi = item as Number
                            var date = _date.getClone()
                            var start = _start
                            date.subtraction(dshi, "d")
                            date = xDate(date.getBetweenDate(_start_date_str.value, _end_date_str.value, "min"))
                            var end = date.format()
                            typelist.push(coverValueType(value = _uA(
                                end,
                                start
                            ), str = xConfig.i18n.t("tmui4x.betweentTime.quiakListTitle2", dshi)))
                        } else if (item is UTSJSONObject) {
                            var title = (item as UTSJSONObject).getString("title")
                            var v_start = (item as UTSJSONObject).getString("start")
                            var v_end = (item as UTSJSONObject).getString("end")
                            if (title != null && v_start != null && v_end != null) {
                                typelist.push(coverValueType(value = _uA(
                                    v_start,
                                    v_end
                                ), str = title))
                            }
                        }
                        i++
                    }
                }
                return typelist
            }
            val getQuickDateType = ::gen_getQuickDateType_fn
            fun gen_cancelResetDataCol_fn() {
                nowValue.value = nowModelValue.value.slice(0)
            }
            val cancelResetDataCol = ::gen_cancelResetDataCol_fn
            fun gen_clearDate_fn() {
                var dst = _uA<String>("", "")
                nowValue.value = dst
            }
            val clearDate = ::gen_clearDate_fn
            fun gen_dateChangeView_fn(datestr: String) {
                clearTimeout(tid)
                tid = setTimeout(fun() {
                    quicklistSelectedStr.value = ""
                    var nowvalu = nowValue.value.slice(0)
                    nowvalu[changeIndex.value] = datestr
                    var strStart = nowvalu[0]
                    var strEnd = nowvalu[1]
                    var types = getTypes()
                    if (strEnd != "" && strStart != "") {
                        if (changeIndex.value == 0) {
                            if (xDate(strStart).isBetweenOf(xDate(strEnd), ">", types)) {
                                strEnd = strStart
                            }
                        } else if (changeIndex.value == 1) {
                            if (xDate(strEnd).isBetweenOf(xDate(strStart), "<", types)) {
                                strStart = strEnd
                            }
                        }
                    }
                    nowValue.value = _uA(
                        strStart,
                        strEnd
                    )
                }
                , 50)
            }
            val dateChangeView = ::gen_dateChangeView_fn
            fun gen_tagsClick_fn(item: coverValueType) {
                nowValue.value = item.value
                quicklistSelectedStr.value = item.str
                emits("dateClick", _uO("text" to item.str, "value" to item.value.slice(0)))
            }
            val tagsClick = ::gen_tagsClick_fn
            fun gen_inputClick_fn(index: Number) {
                changeIndex.value = index
                var nowvalu = nowValue.value.slice(0)
                var strStart = nowvalu[0]
                var strEnd = nowvalu[1]
                if (changeIndex.value == 0) {
                    if (strStart == "") {
                        var tempStart = xDate().getBetweenDate(_start_date_str.value, _end_date_str.value, "max")
                        strStart = xDate(tempStart).format()
                        nowValue.value = _uA(
                            strStart,
                            strEnd
                        )
                    }
                } else if (changeIndex.value == 1) {
                    if (strEnd == "") {
                        var tempEnd = xDate().getBetweenDate(_start_date_str.value, _end_date_str.value, "max")
                        strEnd = xDate(tempEnd).format()
                        nowValue.value = _uA(
                            strStart,
                            strEnd
                        )
                    }
                }
            }
            val inputClick = ::gen_inputClick_fn
            fun gen_openShow_fn() {
                if (props.disabled) {
                    return
                }
                show.value = true
                emits("update:modelShow", true)
            }
            val openShow = ::gen_openShow_fn
            fun gen_onClose_fn() {
                emits("update:modelShow", false)
                cancelResetDataCol()
                if (props.lazyContent) {
                    yanchiDuration.value = false
                }
            }
            val onClose = ::gen_onClose_fn
            fun gen_onOpen_fn() {
                yanchiDuration.value = true
            }
            val onOpen = ::gen_onOpen_fn
            fun gen_onCancel_fn() {
                emits("cancel")
                cancelResetDataCol()
            }
            val onCancel = ::gen_onCancel_fn
            fun gen_onConfirm_fn() {
                var nowval = nowModelValue.value.slice(0)
                var str = coverStrVal()
                var tmdate = _uA<String>()
                if (nowValue.value[0] != "" && nowValue.value[1] != "") {
                    tmdate = nowValue.value.slice(0)
                    nowModelValue.value = tmdate
                }
                emits("update:modelValue", tmdate)
                emits("update:modelStr", if (str == "~") {
                    ""
                } else {
                    str
                }
                )
                emits("confirm", tmdate)
            }
            val onConfirm = ::gen_onConfirm_fn
            watch(fun(): UTSArray<String> {
                return props.modelValue
            }
            , fun(newvalue: UTSArray<String>){
                var sortvalue = sorDateVaild(validTimeDate(newvalue))
                var newvaluestr = sortvalue.join("")
                if (newvaluestr == nowModelValue.value.join("")) {
                    return
                }
                nowValue.value = sortvalue
                nowModelValue.value = sortvalue
                tongbuModelStr()
                quicklistSelectedStr.value = ""
            }
            , WatchOptions(deep = true))
            watch(fun(): Boolean {
                return props.modelShow
            }
            , fun(newValue: Boolean){
                if (newValue == show.value) {
                    return
                }
                show.value = newValue
            }
            )
            watch(fun(): UTSArray<Any> {
                return props.quickDate
            }
            , fun(newvalue: UTSArray<Any>){
                quicklist.value = getQuickDateType()
            }
            , WatchOptions(deep = true))
            onMounted(fun(){
                yanchiDuration.value = if (props.lazyContent) {
                    false
                } else {
                    true
                }
                var str = validTimeDate(props.modelValue)
                nowValue.value = str
                nowModelValue.value = str
                quicklist.value = getQuickDateType()
                tongbuModelStr()
            }
            )
            __expose(_uM("open" to fun(){
                return openShow()
            }
            , "close" to fun(){
                return onClose()
            }
            , "clear" to fun(){
                return clearDate()
            }
            ))
            return fun(): Any? {
                val _component_tmx_text = resolveEasyComponent("tmx-text", GenUniModulesTmxUiComponentsTmxTextTmxTextClass)
                val _component_tmx_tag = resolveEasyComponent("tmx-tag", GenUniModulesTmxUiComponentsTmxTagTmxTagClass)
                val _component_tmx_divider = resolveEasyComponent("tmx-divider", GenUniModulesTmxUiComponentsTmxDividerTmxDividerClass)
                val _component_tmx_date_view = resolveEasyComponent("tmx-date-view", GenUniModulesTmxUiComponentsTmxDateViewTmxDateViewClass)
                val _component_tmx_loading = resolveEasyComponent("tmx-loading", GenUniModulesTmxUiComponentsTmxLoadingTmxLoadingClass)
                val _component_tmx_drawer = resolveEasyComponent("tmx-drawer", GenUniModulesTmxUiComponentsTmxDrawerTmxDrawerClass)
                return _cE(Fragment, null, _uA(
                    _cE("view", _uM("onClick" to openShow), _uA(
                        renderSlot(_ctx.`$slots`, "default", GenUniModulesTmxUiComponentsTmxBetweenTimeTmxBetweenTimeSlotDataDefault(show = show.value, startVal = _formatValStr.value[0], endVal = _formatValStr.value[1]))
                    )),
                    _cV(_component_tmx_drawer, _uM("disabledConfirm" to (_checkPass.value && props.disabledClear), "onOpen" to onOpen, "widthCoverCenter" to _ctx.widthCoverCenter, "disabledScroll" to true, "onClose" to onClose, "onConfirm" to onConfirm, "onCancel" to onCancel, "showFooter" to true, "show" to show.value, "onUpdate:show" to fun(`$event`: Boolean){
                        show.value = `$event`
                    }
                    , "size" to _ctx.drawerSize, "showClose" to false), _uM("title" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to "xPickerClear", "style" to _nS(_uM("height" to "50px"))), _uA(
                                _cV(_component_tmx_text, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _tD(if (_ctx.title != "") {
                                            _ctx.title
                                        } else {
                                            unref(i18n)!!.t("tmui4x.betweentTime.title")
                                        }
                                        )
                                    )
                                }
                                ), "_" to 1)),
                                if (isTrue(!props.disabledClear)) {
                                    _cV(_component_tmx_text, _uM("key" to 0, "onClick" to clearDate, "style" to _nS(_uM("opacity" to "0.5"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(unref(i18n)!!.t("tmui4x.clear"))
                                        )
                                    }), "_" to 1), 8, _uA(
                                        "style"
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                            ), 4)
                        )
                    }
                    ), "default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to "xPickerDateWrap"), _uA(
                                if (quicklist.value.length > 0) {
                                    _cE("view", _uM("key" to 0, "class" to "xPickerDateWrapQuickTags"), _uA(
                                        _cE(Fragment, null, RenderHelpers.renderList(quicklist.value, fun(item, index, __index, _cached): Any {
                                            return _cV(_component_tmx_tag, _uM("font-size" to "14", "font-color" to if (_isDark.value) {
                                                "white"
                                            } else {
                                                ""
                                            }, "onClick" to fun(){
                                                tagsClick(item)
                                            }, "skin" to if (quicklistSelectedStr.value == item.str) {
                                                "normal"
                                            } else {
                                                "thin"
                                            }, "round" to 8, "size" to "large", "style" to _nS(_uM("margin-right" to "10px", "margin-bottom" to "5px")), "key" to index), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _tD(item.str)
                                                )
                                            }), "_" to 2), 1032, _uA(
                                                "font-color",
                                                "onClick",
                                                "skin",
                                                "style"
                                            ))
                                        }), 128)
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                                ,
                                _cV(_component_tmx_divider),
                                _cE("view", _uM("style" to _nS(_uM("height" to "8px"))), null, 4),
                                _cE("view", _uM("class" to "xPickerDateWrapQuickInput"), _uA(
                                    _cE("view", _uM("class" to "xPickerInputMaskerParent", "onClick" to fun(){
                                        inputClick(0)
                                    }
                                    , "style" to _nS(_uM("flex" to "1", "height" to "40px"))), _uA(
                                        _cE("input", _uM("placeholder-style" to _placeStyle.value, "style" to _nS(_uM("color" to if (changeIndex.value == 0) {
                                            _activeBorderColor.value
                                        } else {
                                            _fontColor.value
                                        }
                                        , "border" to ("2px solid " + (if (changeIndex.value == 0) {
                                            _activeBorderColor.value
                                        } else {
                                            _backgroundColor.value
                                        }
                                        )), "backgroundColor" to _backgroundColor.value, "fontSize" to "15px")), "class" to "xPickerInput", "value" to _start_date_str_format.value), null, 12, _uA(
                                            "placeholder-style",
                                            "value"
                                        )),
                                        _cE("view", _uM("class" to "xPickerInputMasker"))
                                    ), 12, _uA(
                                        "onClick"
                                    )),
                                    _cV(_component_tmx_text, _uM("font-size" to "11", "style" to _nS(_uM("width" to "36px", "text-align" to "center"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(unref(i18n)!!.t("tmui4x.betweentTime.splite"))
                                        )
                                    }
                                    ), "_" to 1), 8, _uA(
                                        "style"
                                    )),
                                    _cE("view", _uM("class" to "xPickerInputMaskerParent", "onClick" to fun(){
                                        inputClick(1)
                                    }
                                    , "style" to _nS(_uM("flex" to "1", "height" to "40px"))), _uA(
                                        _cE("input", _uM("placeholder-style" to _placeStyle.value, "style" to _nS(_uM("color" to if (changeIndex.value == 1) {
                                            _activeBorderColor.value
                                        } else {
                                            _fontColor.value
                                        }
                                        , "border" to ("2px solid " + (if (changeIndex.value == 1) {
                                            _activeBorderColor.value
                                        } else {
                                            _backgroundColor.value
                                        }
                                        )), "backgroundColor" to _backgroundColor.value, "fontSize" to "15px")), "class" to "xPickerInput", "value" to _end_date_str_format.value), null, 12, _uA(
                                            "placeholder-style",
                                            "value"
                                        )),
                                        _cE("view", _uM("class" to "xPickerInputMasker"))
                                    ), 12, _uA(
                                        "onClick"
                                    ))
                                )),
                                _cV(_component_tmx_divider, _uM("style" to _nS(_uM("margin-bottom" to "8px"))), null, 8, _uA(
                                    "style"
                                )),
                                if (isTrue(yanchiDuration.value)) {
                                    _cV(_component_tmx_date_view, _uM("key" to 1, "onChange" to dateChangeView, "format" to _ctx.format, "type" to _ctx.type, "cell-units" to _cellUnits.value, "start" to _start_date_str.value, "end" to _end_date_str.value, "model-value" to nowValue.value[changeIndex.value]), null, 8, _uA(
                                        "format",
                                        "type",
                                        "cell-units",
                                        "start",
                                        "end",
                                        "model-value"
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                            )),
                            if (isTrue(!yanchiDuration.value)) {
                                _cV(_component_tmx_loading, _uM("key" to 0))
                            } else {
                                _cC("v-if", true)
                            }
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "disabledConfirm",
                        "widthCoverCenter",
                        "show",
                        "onUpdate:show",
                        "size"
                    ))
                ), 64)
            }
        }
        var name = "xBetweenTime"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("xPickerClear" to _pS(_uM("paddingTop" to 0, "paddingRight" to 20, "paddingBottom" to 0, "paddingLeft" to 20, "display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center")), "xPickerDateText" to _pS(_uM("textAlign" to "left", "transitionDuration" to "350ms", "transitionTimingFunction" to "linear", "transitionProperty" to "transform,opacity", "transform" to "translateY(100%) scale(0)", "opacity" to 0)), "xPickerDateWrapQuickInputPlackeTips" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "display" to "flex", "flexDirection" to "row", "pointerEvents" to "none")), "xPickerInputMaskerParent" to _pS(_uM("position" to "relative")), "xPickerInputMasker" to _pS(_uM("position" to "absolute", "width" to "100%", "height" to "100%")), "xPickerInput" to _pS(_uM("borderTopLeftRadius" to 40, "borderTopRightRadius" to 40, "borderBottomRightRadius" to 40, "borderBottomLeftRadius" to 40, "height" to "100%", "paddingTop" to 0, "paddingRight" to 10, "paddingBottom" to 0, "paddingLeft" to 10, "flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "pointerEvents" to "none", "textAlign" to "center")), "xPickerDateWrapQuickInput" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "marginBottom" to 8)), "xPickerDateWrapQuickTags" to _pS(_uM("display" to "flex", "flexDirection" to "row", "flexWrap" to "wrap", "marginBottom" to 8)), "@TRANSITION" to _uM("xPickerDateText" to _uM("duration" to "350ms", "timingFunction" to "linear", "property" to "transform,opacity")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("cancel" to null, "confirm" to null, "change" to null, "dateClick" to null, "update:modelShow" to null, "update:modelStr" to null, "update:modelValue" to null)
        var props = _nP(_uM("modelValue" to _uM("type" to "Array", "required" to true, "default" to fun(): UTSArray<String> {
            return _uA<String>()
        }
        ), "modelStr" to _uM("type" to "String", "required" to true, "default" to ""), "modelShow" to _uM("type" to "Boolean", "required" to true, "default" to false), "title" to _uM("type" to "String", "required" to true, "default" to ""), "start" to _uM("type" to "String", "required" to true, "default" to ""), "end" to _uM("type" to "String", "required" to true, "default" to ""), "type" to _uM("type" to "String", "required" to true, "default" to "day"), "format" to _uM("type" to "String", "required" to true, "default" to ""), "cellUnits" to _uM("type" to "Array", "required" to true, "default" to fun(): UTSArray<String> {
            return _uA<String>()
        }
        ), "quickDate" to _uM("type" to "Array", "required" to true, "default" to fun(): UTSArray<Any> {
            return _uA<Any>("d", "w", "m", "y", "q")
        }
        ), "lazyContent" to _uM("type" to "Boolean", "required" to true, "default" to true), "drawerSize" to _uM("type" to "String", "required" to true, "default" to "540px"), "disabledClear" to _uM("type" to "Boolean", "required" to true, "default" to false), "disabled" to _uM("type" to "Boolean", "required" to true, "default" to false), "widthCoverCenter" to _uM("type" to "Boolean", "required" to true, "default" to true)))
        var propsNeedCastKeys = _uA(
            "modelValue",
            "modelStr",
            "modelShow",
            "title",
            "start",
            "end",
            "type",
            "format",
            "cellUnits",
            "quickDate",
            "lazyContent",
            "drawerSize",
            "disabledClear",
            "disabled",
            "widthCoverCenter"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
