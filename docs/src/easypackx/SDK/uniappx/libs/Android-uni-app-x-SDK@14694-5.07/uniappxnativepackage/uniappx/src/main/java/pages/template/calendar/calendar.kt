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
open class GenPagesTemplateCalendarCalendar : BasePage {
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
    open var data: DataType__114
        get() {
            return unref(this.`$exposed`["data"]) as DataType__114
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesTemplateCalendarCalendar, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesTemplateCalendarCalendar
            val _cache = __ins.renderCache
            val drawHeaderRef = ref<UniElement?>(null)
            val drawWeeksRef = ref<UniElement?>(null)
            val weeks = ref(_uA<UTSArray<DateType>>())
            val `$coords` = ref(_uA<CoordsType>())
            val `$calendar` = ref(Calendar() as Calendar)
            val timeData = ref<DateType>(DateType(fullDate = "", year = 0, month = 0, date = 0, day = 0, lunar = "", disabled = false, is_today = false))
            val data = reactive(DataType__114(testWidth = 0))
            val current_month = computed(fun(): String {
                val nowDate = timeData.value
                val month = nowDate.month
                return if (month < 10) {
                    "0" + month
                } else {
                    month.toString(10)
                }
            }
            )
            val current_day = computed(fun(): String {
                val time = timeData.value.data
                if (time == null) {
                    return ""
                }
                return time.IMonthCn + time.IDayCn
            }
            )
            fun gen_drawHeader_fn() {
                val refs = drawHeaderRef.value
                if (refs == null) {
                    return
                }
                var ctx = refs.getDrawableContext()
                if (ctx == null) {
                    return
                }
                ctx.reset()
                val date_header_map = _uA(
                    "一",
                    "二",
                    "三",
                    "四",
                    "五",
                    "六",
                    "日"
                )
                val width = refs.getBoundingClientRect().width
                val num = date_header_map.length
                val one_width = width / num
                ctx.font = "12"
                ctx.textAlign = "center"
                run {
                    var i: Number = 0
                    while(i < num){
                        var box_left = i * one_width + 2
                        var box_width = one_width - 4
                        var box_height: Number = 26
                        val text = date_header_map[i]
                        var text_left = box_width / 2 + box_left
                        var text_top = box_height / 2 + 6
                        ctx.fillText(text, text_left, text_top)
                        i++
                    }
                }
                ctx.update()
            }
            val drawHeader = ::gen_drawHeader_fn
            fun gen_drawWeek_fn(weeks: UTSArray<UTSArray<DateType>>, time: String) {
                val start_time = Date.now()
                val refs = drawWeeksRef.value
                if (refs == null) {
                    return
                }
                var ctx = refs.getDrawableContext()
                if (ctx == null) {
                    return
                }
                val dom = refs.getBoundingClientRect()
                val width = dom.width
                val height = dom.height
                var week_len = weeks.length
                val one_width = width / weeks[0].length
                val one_height = height / week_len
                if (time != "") {
                    `$coords`.value = _uA<CoordsType>()
                    ctx.reset()
                }
                ctx.textAlign = "center"
                run {
                    var week: Number = 0
                    while(week < week_len){
                        val week_item = weeks[week]
                        run {
                            var day: Number = 0
                            while(day < week_item.length){
                                val day_item = week_item[day]
                                var day_left = day * one_width + 2
                                var day_top = one_height * week + 2
                                var day_width = one_width - 4
                                var day_height = one_height - 4
                                var text = day_item.date.toString(10)
                                var text_left = day * one_width + (one_width / 2)
                                var text_top = one_height * week + 25
                                ctx.font = "16"
                                if (day_item.disabled) {
                                    ctx.fillStyle = "#ccc"
                                } else {
                                    if (day_item.is_today) {
                                        ctx.fillStyle = "red"
                                    } else if (time == day_item.fullDate) {
                                        ctx.fillStyle = "blue"
                                    } else {
                                        ctx.fillStyle = "#666"
                                    }
                                    val coords = CoordsType(x = day_left, y = day_top, width = day_width, height = day_height, data = day_item)
                                    var gridArr = `$coords`.value
                                    gridArr.push(coords)
                                }
                                ctx.fillText(text, text_left, text_top)
                                text = day_item.lunar
                                var lunar_left = day * one_width + (one_width / 2)
                                var lunar_top = one_height * week + 42
                                ctx.font = "10"
                                ctx.fillText(text, lunar_left, lunar_top)
                                day++
                            }
                        }
                        week++
                    }
                }
                ctx.update()
                console.log("diff time", Date.now() - start_time)
            }
            val drawWeek = ::gen_drawWeek_fn
            fun gen_init_fn() {
                val calendar = `$calendar`.value
                val refs = drawWeeksRef.value
                if (refs != null) {
                    var ctx = refs.getDrawableContext()
                    if (ctx != null) {
                        ctx.reset()
                    }
                }
                var fulltime = timeData.value.fullDate
                if (fulltime == "") {
                    timeData.value = calendar.getDateInfo()
                    fulltime = timeData.value.fullDate
                }
                weeks.value = calendar.getWeeks(fulltime)
                drawHeader()
                drawWeek(weeks.value, fulltime)
            }
            val init = ::gen_init_fn
            fun gen_clickGrid_fn(x: Number, y: Number) {
                val calendar = `$calendar`.value
                val gridArray = `$coords`.value
                run {
                    var i: Number = 0
                    while(i < gridArray.length){
                        val grid = gridArray[i]
                        val max_x = grid.x + grid.width
                        val max_y = grid.y + grid.height
                        val is_x_limit = grid.x < x && x < max_x
                        val is_y_limit = grid.y < y && y < max_y
                        val is_select = is_x_limit && is_y_limit
                        if (is_select) {
                            val data = grid.data
                            timeData.value = calendar.getDateInfo(data.fullDate)
                            drawWeek(weeks.value, grid.data.fullDate)
                        }
                        i++
                    }
                }
            }
            val clickGrid = ::gen_clickGrid_fn
            fun gen_select_fn(event: UniPointerEvent) {
                val refs = drawWeeksRef.value
                if (refs == null) {
                    return
                }
                val rect = refs.getBoundingClientRect()
                val dom_x = rect.left
                val dom_y = rect.top
                val clientX = event.clientX
                val clientY = event.clientY
                val x = clientX - dom_x
                val y = clientY - dom_y
                clickGrid(x, y)
            }
            val select = ::gen_select_fn
            fun gen_gotoToday_fn() {
                val calendar = `$calendar`.value
                val time = calendar.getDate()
                timeData.value = calendar.getDateInfo(time.fullDate)
                weeks.value = calendar.getWeeks(time.fullDate)
                drawWeek(weeks.value, time.fullDate)
            }
            val gotoToday = ::gen_gotoToday_fn
            fun gen_isCurrentMonth_fn(year: Number, month: Number): Boolean {
                val today = Date()
                return year === today.getFullYear() && month === today.getMonth() + 1
            }
            val isCurrentMonth = ::gen_isCurrentMonth_fn
            fun gen_preDate_fn() {
                val fulldate = timeData.value.fullDate
                val calendar = `$calendar`.value
                var time = calendar.getDate(fulldate, -1, "month")
                val newDate = time.year + "-" + time.month + "-1"
                time = calendar.getDate(newDate)
                timeData.value = calendar.getDateInfo(time.fullDate)
                weeks.value = calendar.getWeeks(time.fullDate)
                if (isCurrentMonth(time.year, time.month)) {
                    gotoToday()
                } else {
                    drawWeek(weeks.value, time.fullDate)
                }
            }
            val preDate = ::gen_preDate_fn
            fun gen_nextDate_fn() {
                val fulldate = timeData.value.fullDate
                val calendar = `$calendar`.value
                var time = calendar.getDate(fulldate, 1, "month")
                val newDate = time.year + "-" + time.month + "-1"
                time = calendar.getDate(newDate)
                timeData.value = calendar.getDateInfo(time.fullDate)
                weeks.value = calendar.getWeeks(time.fullDate)
                if (isCurrentMonth(time.year, time.month)) {
                    gotoToday()
                } else {
                    drawWeek(weeks.value, time.fullDate)
                }
            }
            val nextDate = ::gen_nextDate_fn
            onResize(fun(_options){
                init()
            }
            )
            onReady(fun(){
                init()
                val header = drawHeaderRef.value
                if (header != null) {
                    data.testWidth = header.getBoundingClientRect().width
                }
            }
            )
            __expose(_uM("data" to data))
            return fun(): Any? {
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("class" to "root"), _uA(
                        _cE("view", _uM("class" to "date"), _uA(
                            _cE("text", _uM("class" to "date-text"), _tD(unref(current_month)), 1)
                        )),
                        _cE("view", _uM("ref_key" to "drawHeaderRef", "ref" to drawHeaderRef, "class" to "calendar-header"), null, 512),
                        _cE("view", _uM("ref_key" to "drawWeeksRef", "ref" to drawWeeksRef, "class" to "calendar-week", "onClick" to select), null, 512),
                        _cE("view", _uM("class" to "btn-group"), _uA(
                            _cE("button", _uM("size" to "mini", "onClick" to preDate), "上个月"),
                            _cE("button", _uM("size" to "mini", "onClick" to gotoToday), "回到今天"),
                            _cE("button", _uM("size" to "mini", "onClick" to nextDate), "下个月")
                        )),
                        _cE("view", null, _tD(unref(timeData).fullDate) + " " + _tD(unref(current_day)), 1)
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
                return _uM("root" to _pS(_uM("position" to "relative", "paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15, "backgroundColor" to "#ffffff")), "calendar-header" to _pS(_uM("height" to 30, "marginBottom" to 10)), "date" to _pS(_uM("marginBottom" to 10, "marginLeft" to 10)), "date-text" to _pS(_uM("fontSize" to 34, "fontWeight" to "bold")), "calendar-week" to _pS(_uM("height" to 350, "marginTop" to 2, "marginRight" to 0, "marginBottom" to 2, "marginLeft" to 0)), "btn-group" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "marginTop" to 20, "marginRight" to 0, "marginBottom" to 20, "marginLeft" to 0)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
