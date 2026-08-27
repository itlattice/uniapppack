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
import io.dcloud.uniapp.extapi.`$off` as uni__off
import io.dcloud.uniapp.extapi.`$on` as uni__on
import io.dcloud.uniapp.extapi.createSelectorQuery as uni_createSelectorQuery
open class GenUniModulesTmxUiComponentsTmxTabsTmxTabs : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var round: String by `$props`
    open var width: String by `$props`
    open var lineWidth: Number by `$props`
    open var height: String by `$props`
    open var color: String by `$props`
    open var darkColor: String by `$props`
    open var activeTitleColor: String by `$props`
    open var titleColor: String by `$props`
    open var darkTitleColor: String by `$props`
    open var lineColor: String by `$props`
    open var lineGradient: UTSArray<String> by `$props`
    open var lineHeight: String by `$props`
    open var lineFull: Boolean by `$props`
    open var showLine: Boolean by `$props`
    open var list: UTSArray<TABS_ITEM_INFO> by `$props`
    open var modelValue: Any by `$props`
    open var fontSize: String by `$props`
    open var activeFontSize: String by `$props`
    open var itemWidth: String by `$props`
    open var titlePadding: String by `$props`
    open var isItemCenter: Boolean by `$props`
    open var itemActiveStyle: String by `$props`
    open var itemStyle: String by `$props`
    open var textActiveStyle: String by `$props`
    open var textStyle: String by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesTmxUiComponentsTmxTabsTmxTabs) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesTmxUiComponentsTmxTabsTmxTabs
            val _cache = __ins.renderCache
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val props = __props
            val nowActiveId = ref<Any>("")
            val id = ref(("xTabsItem-" + getUid() + "-") as String)
            val lineLeft = ref(0)
            val activeLineWidth = ref(18)
            val totalWidth = ref(0)
            val scrollNowPosId = ref("")
            val first = ref(true)
            val isQueryOk = ref(false)
            val tid = ref(0)
            val tid2 = ref(12)
            val tid3 = ref(133)
            val tid4 = ref(1033)
            val tabsList = ref<Map<String, NodeInfo>>(Map<String, NodeInfo>())
            val tabsItemLeft = ref(0)
            val tabasItemCenter = ref(false)
            val proxy = getCurrentInstance()?.proxy
            val _itemActiveStyle = computed(fun(): String {
                return props.itemActiveStyle
            }
            )
            val _itemStyle = computed(fun(): String {
                return props.itemStyle
            }
            )
            val _textActiveStyle = computed(fun(): String {
                return props.textActiveStyle
            }
            )
            val _textStyle = computed(fun(): String {
                return props.textStyle
            }
            )
            val _showLine = computed(fun(): Boolean {
                return props.showLine
            }
            )
            val _lineFull = computed(fun(): Boolean {
                return props.lineFull
            }
            )
            val _fontSize = computed(fun(): String {
                var fontSize = checkIsCssUnit(props.fontSize, xConfig.unit)
                if (xConfig.fontScale == 1) {
                    return fontSize
                }
                var sizeNumber = parseInt(fontSize)
                if (isNaN(sizeNumber)) {
                    sizeNumber = 14
                }
                return (sizeNumber * xConfig.fontScale).toString(10) + getUnit(fontSize)
            }
            )
            val _itemWidth = computed(fun(): String {
                return checkIsCssUnit(props.itemWidth, xConfig.unit)
            }
            )
            val _round = computed(fun(): String {
                return checkIsCssUnit(props.round, xConfig.unit)
            }
            )
            val _activeFontSize = computed(fun(): String {
                return checkIsCssUnit(props.activeFontSize, xConfig.unit)
            }
            )
            val _lineHeight = computed(fun(): String {
                return checkIsCssUnit(props.lineHeight, xConfig.unit)
            }
            )
            val _height = computed(fun(): String {
                return checkIsCssUnit(props.height, xConfig.unit)
            }
            )
            val _width = computed(fun(): String {
                return checkIsCssUnit(props.width, xConfig.unit)
            }
            )
            val _color = computed(fun(): String {
                if (xConfig.dark == "dark") {
                    if (props.darkColor != "") {
                        return getDefaultColor(props.darkColor)
                    } else {
                        return getDefaultColor(xConfig.sheetDarkColor)
                    }
                }
                return getDefaultColor(props.color)
            }
            )
            val _activeTitleColor = computed(fun(): String {
                if (props.activeTitleColor == "") {
                    return getDefaultColor(xConfig.color)
                }
                return getDefaultColor(props.activeTitleColor)
            }
            )
            val _titleColor = computed(fun(): String {
                if (xConfig.dark == "dark") {
                    if (props.darkTitleColor != "") {
                        return getDefaultColor(props.darkTitleColor)
                    } else {
                        return "#ffffff"
                    }
                }
                return getDefaultColor(props.titleColor)
            }
            )
            val _lineColor = computed(fun(): Map<String, String> {
                var colorstyleline = Map<String, String>()
                if (props.lineGradient.length == 3) {
                    var dirs = props.lineGradient[0]
                    if (props.lineGradient[0] == "top") {
                        dirs = "to top"
                    } else if (props.lineGradient[0] == "bottom") {
                        dirs = "to bottom"
                    } else if (props.lineGradient[0] == "left") {
                        dirs = "to left"
                    } else if (props.lineGradient[0] == "right") {
                        dirs = "to right"
                    }
                    colorstyleline.set("backgroundImage", "linear-gradient(" + dirs + "," + props.lineGradient[1] + "," + props.lineGradient[2] + ")")
                    return colorstyleline
                }
                if (props.lineColor == "") {
                    colorstyleline.set("background-color", _activeTitleColor.value)
                    return colorstyleline
                }
                colorstyleline.set("background-color", props.lineColor)
                return colorstyleline
            }
            )
            val _list = computed(fun(): UTSArray<TABS_ITEM> {
                var lits = _uA<TABS_ITEM>()
                props.list.forEach(fun(el: TABS_ITEM_INFO, index: Number){
                    lits.push(TABS_ITEM(id = if (el.id == null) {
                        index.toString(10)
                    } else {
                        el.id!!
                    }
                    , title = el.title, disabled = if (el.disabled == null) {
                        false
                    } else {
                        el.disabled!! as Boolean
                    }
                    , dotType = if (el.dotType == null) {
                        ""
                    } else {
                        el.dotType!! as String
                    }
                    , dotColor = if (el.dotColor == null) {
                        "red"
                    } else {
                        getDefaultColor(el.dotColor!!)
                    }
                    , dotText = if (el.dotText == null) {
                        ""
                    } else {
                        el.dotText!! as String
                    }
                    , data = if (el.data == null) {
                        _uO()
                    } else {
                        el.data!! as UTSJSONObject
                    }
                    ))
                }
                )
                return lits
            }
            )
            val getNodeInfo = fun(idStr: Any){
                if (_list.value.length == 0) {
                    return
                }
                var _this = proxy
                uni_createSelectorQuery().`in`(_this).select(".xTabs").boundingClientRect(fun(ret){
                    var parentNodeinfo = ret as NodeInfo
                    try {
                        uni_createSelectorQuery().`in`(_this).selectAll(".xTabsItem").boundingClientRect().exec(fun(ret){
                            var allItems = ret[0] as UTSArray<NodeInfo>
                            var totalWidthVal: Number = 0
                            var totalNowWidth: Number = 0
                            var isNow = false
                            var nowNndex: Number = 0
                            allItems.forEach(fun(el: NodeInfo, index: Number){
                                totalWidthVal += el.width!!
                                if (idStr == el.id) {
                                    isNow = true
                                    nowNndex = index
                                }
                                if (!isNow) {
                                    totalNowWidth += el.width!!
                                }
                            }
                            )
                            var realTargetlinewidth = allItems[nowNndex].width!!
                            if (_lineFull.value) {
                                activeLineWidth.value = allItems[nowNndex].width!!
                            } else {
                                activeLineWidth.value = allItems[nowNndex].width!! / 2
                                realTargetlinewidth = props.lineWidth
                            }
                            var parentWidth = parentNodeinfo.width!!
                            var center = parentWidth / 2
                            tabasItemCenter.value = (totalWidthVal - parentWidth) <= 0 && props.isItemCenter
                            tabsItemLeft.value = totalNowWidth - parentWidth + center + allItems[nowNndex].width!! / 2
                            first.value = false
                            var totalNowWidths = totalNowWidth + (allItems[nowNndex].width!! - activeLineWidth.value) / 2
                            totalWidth.value = totalWidthVal
                            if (!_lineFull.value) {
                                activeLineWidth.value = realTargetlinewidth
                                var etotalNowWidth = totalNowWidth + (allItems[nowNndex].width!! - realTargetlinewidth) / 2
                                lineLeft.value = etotalNowWidth
                            } else {
                                lineLeft.value = totalNowWidths
                            }
                            var idnex = Math.max(0, nowNndex)
                            scrollNowPosId.value = allItems[idnex].id!!
                        }
                        )
                    }
                     catch (e: Throwable) {
                        console.error("xTabs:没有找到对应的index id，请检查你的数据。")
                    }
                }
                ).exec()
            }
            val setActiveId = fun(newValue: Any){
                if (_list.value.length == 0) {
                    return
                }
                var index: Number = -1
                run {
                    var i: Number = 0
                    while(i < _list.value.length){
                        if (_list.value[i].id == newValue) {
                            index = i
                            break
                        }
                        i++
                    }
                }
                index = Math.max(0, index)
                var newval = _list.value[index].id
                nowActiveId.value = newval
                if (index > -1) {
                    getNodeInfo(id.value + index.toString(10))
                }
            }
            val lineTranslateEnd = fun(){}
            val itemClick = fun(item: TABS_ITEM, classid: String, index: Number){
                if (item.disabled || nowActiveId.value == item.id) {
                    return
                }
                nowActiveId.value = item.id
                emit("update:modelValue", item.id)
                emit("change", item, index)
                if (_activeFontSize.value != _fontSize.value) {
                    clearTimeout(tid4.value)
                    tid4.value = setTimeout(fun() {
                        getNodeInfo(classid)
                    }, 50)
                } else {
                    getNodeInfo(classid)
                }
            }
            val calcTotalWidth = fun(){
                var totalWidthVal: Number = 0
                tabsList.value.forEach(fun(item: NodeInfo){
                    totalWidthVal += item.width!!
                }
                )
                totalWidth.value = totalWidthVal
            }
            val tabsItemChange = fun(recnode: NodeInfo, rectId: String){
                tabsList.value.set(rectId, recnode)
                calcTotalWidth()
            }
            val tabsItemDestory = fun(idStr: String){
                tabsList.value.`delete`(idStr)
                calcTotalWidth()
            }
            watch(fun(): Any {
                return props.modelValue
            }
            , fun(newValue: Any){
                if (newValue == nowActiveId.value || newValue == "") {
                    return
                }
                setActiveId(newValue)
            }
            )
            watch(fun(): UTSArray<TABS_ITEM_INFO> {
                return props.list
            }
            , fun(){
                clearTimeout(tid3.value)
                tid3.value = setTimeout(fun() {
                    setActiveId(nowActiveId.value)
                }
                , 50)
            }
            )
            val resizechange = fun(){
                setActiveId(nowActiveId.value)
            }
            onMounted(fun(){
                activeLineWidth.value = props.lineWidth
                nowActiveId.value = props.modelValue
                nextTick(fun(){
                    setActiveId(nowActiveId.value)
                }
                )
                uni__on("onResize", resizechange)
            }
            )
            onBeforeUnmount(fun(){
                uni__off("onResize", resizechange)
                clearTimeout(tid.value)
                clearTimeout(tid2.value)
                clearTimeout(tid3.value)
                clearTimeout(tid4.value)
            }
            )
            return fun(): Any? {
                val _component_tmx_badge = resolveEasyComponent("tmx-badge", GenUniModulesTmxUiComponentsTmxBadgeTmxBadgeClass)
                return _cE("view", _uM("class" to "xTabs", "ref" to "xTabs", "style" to _nS(_uM("width" to unref(_width), "borderRadius" to unref(_round), "height" to unref(_height), "backgroundColor" to unref(_color)))), _uA(
                    _cE("scroll-view", _uM("scroll-left" to unref(tabsItemLeft), "scroll-with-animation" to true, "class" to "xTabsWrap", "show-scrollbar" to false, "style" to _nS(_uM("justifyContent" to if (unref(tabasItemCenter)) {
                        "center"
                    } else {
                        "flex-start"
                    }
                    )), "direction" to "horizontal"), _uA(
                        _cE(Fragment, null, RenderHelpers.renderList(unref(_list), fun(item, index, __index, _cached): Any {
                            return _cE("view", _uM("class" to "xTabsItem", "ref_for" to true, "ref" to "xTabsItem", "id" to (unref(id) + index), "key" to index, "style" to _nS(_uA(
                                _uM("width" to unref(_itemWidth), "height" to "100%", "opacity" to if (item.disabled) {
                                    "0.6"
                                } else {
                                    1
                                }
                                ),
                                if (unref(nowActiveId) == item.id) {
                                    unref(_itemActiveStyle)
                                } else {
                                    unref(_itemStyle)
                                }
                            )), "onClick" to fun(){
                                itemClick(item, (unref(id) + index), index)
                            }
                            ), _uA(
                                _cV(unref(GenUniModulesTmxUiComponentsTmxTabsTabsItemClass), _uM("id" to (unref(id) + index), "onChange" to tabsItemChange, "onDestory" to tabsItemDestory, "style" to _nS(_uM("with" to "100%"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        if (item.dotType != "") {
                                            _cV(_component_tmx_badge, _uM("key" to 0, "bg-color" to item.dotColor, "dot" to (item.dotType == "dot"), "label" to item.dotText), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("view", _uM("key" to index, "style" to _nS(_uM("paddingLeft" to _ctx.titlePadding, "paddingRight" to _ctx.titlePadding))), _uA(
                                                        renderSlot(_ctx.`$slots`, "default", GenUniModulesTmxUiComponentsTmxTabsTmxTabsSlotDataDefault(item = item, active = (unref(nowActiveId) == item.id)), fun(): UTSArray<Any> {
                                                            return _uA(
                                                                _cE("text", _uM("class" to "xTabsWrapText", "style" to _nS(_uA(
                                                                    _uM("fontSize" to if (unref(nowActiveId) == item.id) {
                                                                        unref(_activeFontSize)
                                                                    } else {
                                                                        unref(_fontSize)
                                                                    }, "color" to if (unref(nowActiveId) == item.id) {
                                                                        unref(_activeTitleColor)
                                                                    } else {
                                                                        unref(_titleColor)
                                                                    }),
                                                                    if (unref(nowActiveId) == item.id) {
                                                                        unref(_textActiveStyle)
                                                                    } else {
                                                                        unref(_textStyle)
                                                                    }
                                                                ))), _tD(item.title), 5)
                                                            )
                                                        })
                                                    ), 4)
                                                )
                                            }), "_" to 2), 1032, _uA(
                                                "bg-color",
                                                "dot",
                                                "label"
                                            ))
                                        } else {
                                            _cE("view", _uM("key" to 1), _uA(
                                                renderSlot(_ctx.`$slots`, "default", GenUniModulesTmxUiComponentsTmxTabsTmxTabsSlotDataDefault(item = item, active = (unref(nowActiveId) == item.id)), fun(): UTSArray<Any> {
                                                    return _uA(
                                                        _cE("text", _uM("class" to "xTabsWrapText", "style" to _nS(_uA(
                                                            _uM("fontSize" to if (unref(nowActiveId) == item.id) {
                                                                unref(_activeFontSize)
                                                            } else {
                                                                unref(_fontSize)
                                                            }
                                                            , "color" to if (unref(nowActiveId) == item.id) {
                                                                unref(_activeTitleColor)
                                                            } else {
                                                                unref(_titleColor)
                                                            }
                                                            , "paddingLeft" to _ctx.titlePadding, "paddingRight" to _ctx.titlePadding),
                                                            if (unref(nowActiveId) == item.id) {
                                                                unref(_textActiveStyle)
                                                            } else {
                                                                unref(_textStyle)
                                                            }
                                                        ))), _tD(item.title), 5)
                                                    )
                                                }
                                                )
                                            ))
                                        }
                                    )
                                }
                                ), "_" to 2), 1032, _uA(
                                    "id",
                                    "style"
                                ))
                            ), 12, _uA(
                                "id",
                                "onClick"
                            ))
                        }
                        ), 128),
                        _cE("view", _uM("class" to "xLineWrap", "style" to _nS(_uM("width" to (unref(totalWidth) + "px"), "height" to unref(_lineHeight)))), _uA(
                            if (isTrue(unref(_showLine) && !unref(first))) {
                                _cE("view", _uM("key" to 0, "onTransitionend" to lineTranslateEnd, "class" to "xLine", "ref" to "xLine", "style" to _nS(_uA(
                                    _uM("transform" to ("translateX(" + unref(lineLeft) + "px)"), "height" to unref(_lineHeight), "width" to (unref(activeLineWidth) + "px"), "borderRadius" to unref(_lineHeight)),
                                    unref(_lineColor)
                                ))), null, 36)
                            } else {
                                _cC("v-if", true)
                            }
                        ), 4)
                    ), 12, _uA(
                        "scroll-left"
                    ))
                ), 4)
            }
        }
        var name = "xTabs"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("xTabs" to _pS(_uM("overflow" to "hidden")), "xTabsItem" to _pS(_uM("display" to "flex", "flexDirection" to "row", "flexWrap" to "nowrap", "justifyContent" to "center", "alignItems" to "center")), "xLineWrap" to _pS(_uM("position" to "absolute", "bottom" to 0)), "xLine" to _pS(_uM("width" to 20, "position" to "relative", "left" to 0, "transitionDuration" to "300ms", "transitionProperty" to "transform,width", "transitionTimingFunction" to "cubic-bezier(0,0.55,0.45,1)")), "xTabsWrap" to _pS(_uM("width" to "100%", "height" to "100%", "display" to "flex", "flexDirection" to "row", "flexWrap" to "nowrap")), "xTabsWrapText" to _pS(_uM("whiteSpace" to "nowrap")), "@TRANSITION" to _uM("xLine" to _uM("duration" to "300ms", "property" to "transform,width", "timingFunction" to "cubic-bezier(0,0.55,0.45,1)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("change" to null, "update:modelValue" to null)
        var props = _nP(_uM("round" to _uM("type" to "String", "required" to false, "default" to "0"), "width" to _uM("type" to "String", "required" to false, "default" to "auto"), "lineWidth" to _uM("type" to "Number", "required" to false, "default" to 18), "height" to _uM("type" to "String", "required" to false, "default" to "44"), "color" to _uM("type" to "String", "required" to false, "default" to "white"), "darkColor" to _uM("type" to "String", "required" to false, "default" to ""), "activeTitleColor" to _uM("type" to "String", "required" to false, "default" to ""), "titleColor" to _uM("type" to "String", "required" to false, "default" to "#888888"), "darkTitleColor" to _uM("type" to "String", "required" to false, "default" to "#cacaca"), "lineColor" to _uM("type" to "String", "required" to false, "default" to ""), "lineGradient" to _uM("type" to "Array", "required" to false, "default" to fun(): UTSArray<String> {
            return _uA<String>()
        }
        ), "lineHeight" to _uM("type" to "String", "required" to false, "default" to "2px"), "lineFull" to _uM("type" to "Boolean", "required" to false, "default" to false), "showLine" to _uM("type" to "Boolean", "required" to false, "default" to true), "list" to _uM("type" to "Array", "required" to false, "default" to fun(): UTSArray<TABS_ITEM_INFO> {
            return _uA<TABS_ITEM_INFO>()
        }
        ), "modelValue" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false, "default" to "0"), "fontSize" to _uM("type" to "String", "required" to false, "default" to "16"), "activeFontSize" to _uM("type" to "String", "required" to false, "default" to "16"), "itemWidth" to _uM("type" to "String", "required" to false, "default" to "auto"), "titlePadding" to _uM("type" to "String", "required" to false, "default" to "12px"), "isItemCenter" to _uM("type" to "Boolean", "required" to false, "default" to false), "itemActiveStyle" to _uM("type" to "String", "required" to false, "default" to ""), "itemStyle" to _uM("type" to "String", "required" to false, "default" to ""), "textActiveStyle" to _uM("type" to "String", "required" to false, "default" to ""), "textStyle" to _uM("type" to "String", "required" to false, "default" to "")))
        var propsNeedCastKeys = _uA(
            "round",
            "width",
            "lineWidth",
            "height",
            "color",
            "darkColor",
            "activeTitleColor",
            "titleColor",
            "darkTitleColor",
            "lineColor",
            "lineGradient",
            "lineHeight",
            "lineFull",
            "showLine",
            "list",
            "modelValue",
            "fontSize",
            "activeFontSize",
            "itemWidth",
            "titlePadding",
            "isItemCenter",
            "itemActiveStyle",
            "itemStyle",
            "textActiveStyle",
            "textStyle"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
