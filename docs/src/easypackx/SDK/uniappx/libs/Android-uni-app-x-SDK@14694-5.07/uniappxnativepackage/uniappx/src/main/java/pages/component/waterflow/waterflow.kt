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
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesComponentWaterflowWaterflow : BasePage {
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
    open var data: DataType__49
        get() {
            return unref(this.`$exposed`["data"]) as DataType__49
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var confirm_scroll_top_input: (value: Number) -> Unit
        get() {
            return unref(this.`$exposed`["confirm_scroll_top_input"]) as (value: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "confirm_scroll_top_input", value)
        }
    open var change_load_more_boolean: (checked: Boolean) -> Unit
        get() {
            return unref(this.`$exposed`["change_load_more_boolean"]) as (checked: Boolean) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "change_load_more_boolean", value)
        }
    open var check_scroll_height: () -> Boolean
        get() {
            return unref(this.`$exposed`["check_scroll_height"]) as () -> Boolean
        }
        set(value) {
            setRefValue(this.`$exposed`, "check_scroll_height", value)
        }
    open var setScrollIntoView: (id: String) -> Unit
        get() {
            return unref(this.`$exposed`["setScrollIntoView"]) as (id: String) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setScrollIntoView", value)
        }
    open var getScrollTop: () -> Number
        get() {
            return unref(this.`$exposed`["getScrollTop"]) as () -> Number
        }
        set(value) {
            setRefValue(this.`$exposed`, "getScrollTop", value)
        }
    open var testModifyWaterflowProps: () -> Unit
        get() {
            return unref(this.`$exposed`["testModifyWaterflowProps"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "testModifyWaterflowProps", value)
        }
    open var testModifyWaterflowSingleRow: () -> Unit
        get() {
            return unref(this.`$exposed`["testModifyWaterflowSingleRow"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "testModifyWaterflowSingleRow", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentWaterflowWaterflow, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentWaterflowWaterflow
            val _cache = __ins.renderCache
            val data = reactive(DataType__49(refresher_triggered_boolean = false, refresher_enabled_boolean = false, scroll_with_animation_boolean = false, show_scrollbar_boolean = false, bounces_boolean = true, upper_threshold_input = 50, lower_threshold_input = 50, scroll_top_input = 0, scroll_left_input = 0, refresher_background_input = "#FFF", scrollData = _uA(), size_enum = _uA(
                ItemType(value = 0, name = "item---0"),
                ItemType(value = 3, name = "item---3")
            ), scrollIntoView = "", refresherrefresh = false, refresher_default_style_input = "black", text = _uA(
                "继续下拉执行刷新",
                "释放立即刷新",
                "刷新中",
                ""
            ), state = 3, reset = true, isScrollTest = "", isScrolltolowerTest = "", isScrolltoupperTest = "", scrollDetailTest = null, scrollEndDetailTest = null, cross_axis_count = 2, main_axis_gap = 2, cross_axis_gap = 2, waterflowPadding = _uA(
                10,
                5,
                10,
                5
            ), isLoadingMore = false, hasMore = true))
            val waterflowRef = ref<UniWaterFlowElement?>(null)
            onLoad(fun(_options){
                data.scrollData = _uA<flowItemData>(flowItemData(height = 300, text = "item---0"), flowItemData(height = 150, text = "item---1"), flowItemData(height = 120, text = "item---2"), flowItemData(height = 100, text = "item---3"), flowItemData(height = 100, text = "item---4"), flowItemData(height = 150, text = "item---5"), flowItemData(height = 140, text = "item---6"), flowItemData(height = 190, text = "item---7"), flowItemData(height = 160, text = "item---8"), flowItemData(height = 120, text = "item---9"), flowItemData(height = 109, text = "item---10"), flowItemData(height = 102, text = "item---11"), flowItemData(height = 123, text = "item---12"), flowItemData(height = 156, text = "item---13"), flowItemData(height = 177, text = "item---14"), flowItemData(height = 105, text = "item---15"), flowItemData(height = 110, text = "item---16"), flowItemData(height = 90, text = "item---17"), flowItemData(height = 130, text = "item---18"), flowItemData(height = 140, text = "item---19"))
            }
            )
            val waterflow_click = fun(){
                console.log("组件被点击时触发")
            }
            val waterflow_touchstart = fun(){
                console.log("手指触摸动作开始")
            }
            val waterflow_touchmove = fun(){
                console.log("手指触摸后移动")
            }
            val waterflow_touchcancel = fun(){
                console.log("手指触摸动作被打断，如来电提醒，弹窗")
            }
            val waterflow_touchend = fun(){
                console.log("手指触摸动作结束")
            }
            val waterflow_tap = fun(){
                console.log("手指触摸后马上离开")
            }
            val waterflow_longpress = fun(){
                console.log("如果一个组件被绑定了 longpress 事件，那么当用户长按这个组件时，该事件将会被触发。")
            }
            val waterflow_refresherpulling = fun(e: RefresherEvent){
                console.log("下拉刷新控件被下拉")
                if (data.reset) {
                    if (e.detail.dy > 45) {
                        data.state = 1
                    } else {
                        data.state = 0
                    }
                }
            }
            val waterflow_refresherrefresh = fun(){
                console.log("下拉刷新被触发 ")
                data.refresherrefresh = true
                data.refresher_triggered_boolean = true
                data.state = 2
                data.reset = false
                setTimeout(fun(){
                    data.refresher_triggered_boolean = false
                }
                , 1500)
            }
            val waterflow_refresherrestore = fun(){
                data.refresherrefresh = false
                data.state = 3
                data.reset = true
                console.log("下拉刷新被复位")
            }
            val waterflow_refresherabort = fun(){
                console.log("下拉刷新被中止")
            }
            val checkEventTest = fun(e: ScrollEventTest__2, eventName: String){
                val isPass = e.type === eventName && e.target is UniElement && e.currentTarget is UniElement
                val result = if (isPass) {
                    "" + eventName + ":Success"
                } else {
                    "" + eventName + ":Fail"
                }
                when (eventName) {
                    "scroll" -> 
                        data.isScrollTest = result
                    "scrolltolower" -> 
                        data.isScrolltolowerTest = result + ("-" + e.direction)
                    "scrolltoupper" -> 
                        data.isScrolltoupperTest = result + ("-" + e.direction)
                    else -> 
                        {}
                }
            }
            val waterflow_scrolltoupper = fun(e: UniScrollToUpperEvent){
                console.log("滚动到顶部/左边，会触发 scrolltoupper 事件  direction=" + e.detail.direction)
                checkEventTest(ScrollEventTest__2(type = e.type, target = e.target, currentTarget = e.currentTarget, direction = e.detail.direction), "scrolltoupper")
            }
            val waterflow_scrolltolower = fun(e: UniScrollToLowerEvent){
                console.log("滚动到底部/右边，会触发 scrolltolower 事件  direction=" + e.detail.direction)
                checkEventTest(ScrollEventTest__2(type = e.type, target = e.target, currentTarget = e.currentTarget, direction = e.detail.direction), "scrolltolower")
            }
            val waterflow_scroll = fun(e: UniScrollEvent){
                console.log("滚动时触发，event.detail = ", e.detail)
                data.scrollDetailTest = e.detail
                checkEventTest(ScrollEventTest__2(type = e.type, target = e.target, currentTarget = e.currentTarget), "scroll")
            }
            val waterflow_scrollend = fun(e: UniScrollEvent){
                console.log("滚动结束时触发", e.detail)
                data.scrollEndDetailTest = e.detail
                checkEventTest(ScrollEventTest__2(type = e.type, target = e.target, currentTarget = e.currentTarget), "scrollend")
            }
            val flow_item_click = fun(){
                console.log("flow-item组件被点击时触发")
            }
            val flow_item_touchstart = fun(){
                console.log("手指触摸flow-item组件动作开始")
            }
            val flow_item_touchmove = fun(){
                console.log("手指触摸flow-item组件后移动")
            }
            val flow_item_touchcancel = fun(){
                console.log("手指触摸flow-item组件动作被打断，如来电提醒，弹窗")
            }
            val flow_item_touchend = fun(){
                console.log("手指触摸flow-item组件动作结束")
            }
            val flow_item_tap = fun(){
                console.log("手指触摸flow-item组件后马上离开")
            }
            val flow_item_longpress = fun(){
                console.log("flow-item组件被绑定了 longpress 事件，那么当用户长按这个组件时，该事件将会被触发。")
            }
            val change_refresher_triggered_boolean = fun(checked: Boolean){
                data.refresher_triggered_boolean = checked
            }
            val change_refresher_enabled_boolean = fun(checked: Boolean){
                data.refresher_enabled_boolean = checked
            }
            val change_scroll_with_animation_boolean = fun(checked: Boolean){
                data.scroll_with_animation_boolean = checked
            }
            val change_show_scrollbar_boolean = fun(checked: Boolean){
                data.show_scrollbar_boolean = checked
            }
            val change_bounces_boolean = fun(checked: Boolean){
                data.bounces_boolean = checked
            }
            val confirm_upper_threshold_input = fun(value: Number){
                data.upper_threshold_input = value
            }
            val confirm_lower_threshold_input = fun(value: Number){
                data.lower_threshold_input = value
            }
            val confirm_scroll_top_input = fun(value: Number){
                data.scroll_top_input = value
            }
            val confirm_refresher_background_input = fun(value: String){
                data.refresher_background_input = value
            }
            val item_change_size_enum = fun(index: Number){
                data.scrollIntoView = "item---" + index
            }
            val setScrollIntoView = fun(id: String){
                data.scrollIntoView = id
            }
            val check_scroll_height = fun(): Boolean {
                if (waterflowRef.value == null) {
                    console.log("check_scroll_height--waterflowRef is null")
                    return false
                }
                var listElement = waterflowRef.value as UniWaterFlowElement
                console.log("check_scroll_height--" + listElement.scrollHeight)
                return listElement.scrollHeight > 1400
            }
            val getScrollTop = fun(): Number {
                var ret = waterflowRef.value?.scrollTop ?: 0
                console.log(ret)
                return ret
            }
            val change_refresher_style_boolean = fun(checked: Boolean){
                if (checked) {
                    data.refresher_default_style_input = "none"
                } else {
                    data.refresher_default_style_input = "black"
                }
            }
            val change_load_more_boolean = fun(checked: Boolean){
                data.hasMore = checked
            }
            val handleChangeCrossAxisCount = fun(value: Number){
                if (value < 1) {
                    uni_showToast(ShowToastOptions(title = "cross-axis-count 最小值为 1 请重新设置"))
                    return
                }
                data.cross_axis_count = value
            }
            val handleChangeCrossAxisGap = fun(e: UniSliderChangeEvent){
                data.cross_axis_gap = e.detail.value
            }
            val handleChangeMainAxisGap = fun(e: UniSliderChangeEvent){
                data.main_axis_gap = e.detail.value
            }
            val testModifyWaterflowProps = fun(){
                data.cross_axis_count = 4
                data.main_axis_gap = 6
                data.cross_axis_gap = 6
                data.waterflowPadding = _uA(
                    5,
                    10,
                    5,
                    10
                )
            }
            val testModifyWaterflowSingleRow = fun(){
                data.cross_axis_count = 1
                data.main_axis_gap = 6
                data.cross_axis_gap = 6
            }
            val PAGE_SIZE: Number = 5
            val NETWORK_DELAY: Number = 800
            val load_more_click = fun(){
                if (!data.hasMore) {
                    return
                }
                if (data.isLoadingMore) {
                    return
                }
                data.isLoadingMore = true
                console.log("加载更多：开始加载")
                setTimeout(fun(){
                    val start = data.scrollData.length
                    run {
                        var i: Number = 0
                        while(i < PAGE_SIZE){
                            data.scrollData.push(flowItemData(height = 90 + Math.floor(Math.random() * 120), text = "item---" + (start + i)))
                            i++
                        }
                    }
                    data.isLoadingMore = false
                    console.log("加载更多：完成，当前总数：" + data.scrollData.length)
                }
                , NETWORK_DELAY)
            }
            __expose(_uM("data" to data, "confirm_scroll_top_input" to confirm_scroll_top_input, "change_load_more_boolean" to change_load_more_boolean, "check_scroll_height" to check_scroll_height, "setScrollIntoView" to setScrollIntoView, "getScrollTop" to getScrollTop, "testModifyWaterflowProps" to testModifyWaterflowProps, "testModifyWaterflowSingleRow" to testModifyWaterflowSingleRow))
            return fun(): Any? {
                val _component_page_intro = resolveEasyComponent("page-intro", GenComponentsPageIntroPageIntroClass)
                val _component_boolean_data = resolveEasyComponent("boolean-data", GenComponentsBooleanDataBooleanDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                val _component_slider = resolveComponent("slider")
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_navigator = resolveComponent("navigator")
                return _cE(Fragment, null, _uA(
                    _cV(_component_page_intro, _uM("content" to "本页演示 waterflow 瀑布流组件：列数、间距、下拉刷新与加载更多；下方可调节滚动与 refresher 等属性，可跳转固定高度示例。")),
                    _cE("view", _uM("class" to "main"), _uA(
                        _cE("waterflow", _uM("cross-axis-count" to unref(data).cross_axis_count, "main-axis-gap" to unref(data).main_axis_gap, "cross-axis-gap" to unref(data).cross_axis_gap, "bounces" to unref(data).bounces_boolean, "upper-threshold" to unref(data).upper_threshold_input, "lower-threshold" to unref(data).lower_threshold_input, "scroll-top" to unref(data).scroll_top_input, "scroll-left" to unref(data).scroll_left_input, "show-scrollbar" to unref(data).show_scrollbar_boolean, "scroll-into-view" to unref(data).scrollIntoView, "scroll-with-animation" to unref(data).scroll_with_animation_boolean, "refresher-enabled" to unref(data).refresher_enabled_boolean, "refresher-background" to unref(data).refresher_background_input, "refresher-triggered" to unref(data).refresher_triggered_boolean, "refresher-default-style" to unref(data).refresher_default_style_input, "onClick" to _uA<Any?>(waterflow_click, waterflow_tap), "onTouchstart" to waterflow_touchstart, "onTouchmove" to waterflow_touchmove, "onTouchcancel" to waterflow_touchcancel, "onTouchend" to waterflow_touchend, "onLongpress" to waterflow_longpress, "onRefresherpulling" to waterflow_refresherpulling, "onRefresherrefresh" to waterflow_refresherrefresh, "onRefresherrestore" to waterflow_refresherrestore, "onRefresherabort" to waterflow_refresherabort, "onScrolltoupper" to waterflow_scrolltoupper, "ref_key" to "waterflowRef", "ref" to waterflowRef, "onScrolltolower" to waterflow_scrolltolower, "onScroll" to waterflow_scroll, "onScrollend" to waterflow_scrollend, "style" to _nS(_uM("width" to "100%")), "id" to "waterflow", "padding" to unref(data).waterflowPadding), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(unref(data).scrollData, fun(item, index, __index, _cached): Any {
                                return _cE("flow-item", _uM("key" to index, "id" to item.text, "onClick" to _uA<Any?>(flow_item_click, flow_item_tap), "style" to _nS(_uM("height" to item.height)), "onTouchstart" to flow_item_touchstart, "onTouchmove" to flow_item_touchmove, "onTouchcancel" to flow_item_touchcancel, "onTouchend" to flow_item_touchend, "onLongpress" to flow_item_longpress, "class" to "flow-item", "type" to "1"), _uA(
                                    _cE("text", null, _tD(item.text), 1)
                                ), 44, _uA(
                                    "id"
                                ))
                            }
                            ), 128),
                            _cE("flow-item", _uM("slot" to "refresher", "id" to "refresher", "type" to "2", "class" to "refresh-box"), _uA(
                                _cE("text", _uM("class" to "tip-text"), _tD(unref(data).text[unref(data).state]), 1)
                            )),
                            withDirectives(_cE("flow-item", _uM("slot" to "load-more", "id" to "loadmore", "type" to "6", "class" to "load-more-box", "onClick" to load_more_click), _uA(
                                _cE("text", null, "加载更多")
                            ), 512), _uA(
                                _uA(
                                    vShow,
                                    unref(data).hasMore
                                )
                            ))
                        ), 44, _uA(
                            "cross-axis-count",
                            "main-axis-gap",
                            "cross-axis-gap",
                            "bounces",
                            "upper-threshold",
                            "lower-threshold",
                            "scroll-top",
                            "scroll-left",
                            "show-scrollbar",
                            "scroll-into-view",
                            "scroll-with-animation",
                            "refresher-enabled",
                            "refresher-background",
                            "refresher-triggered",
                            "refresher-default-style",
                            "padding"
                        ))
                    )),
                    _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1")), "direction" to "vertical"), _uA(
                        _cE("view", _uM("class" to "content"), _uA(
                            _cV(_component_boolean_data, _uM("defaultValue" to false, "title" to "设置当前下拉刷新状态，true 表示下拉刷新已经被触发，false 表示下拉刷新未被触发", "onChange" to change_refresher_triggered_boolean)),
                            _cV(_component_boolean_data, _uM("defaultValue" to false, "title" to "开启下拉刷新", "onChange" to change_refresher_enabled_boolean)),
                            _cV(_component_boolean_data, _uM("defaultValue" to false, "title" to "开启自定义样式", "onChange" to change_refresher_style_boolean)),
                            _cV(_component_boolean_data, _uM("defaultValue" to false, "title" to "是否在设置滚动条位置时使用滚动动画，设置false没有滚动动画", "onChange" to change_scroll_with_animation_boolean)),
                            _cV(_component_boolean_data, _uM("defaultValue" to false, "title" to "控制是否出现滚动条", "onChange" to change_show_scrollbar_boolean)),
                            _cV(_component_boolean_data, _uM("defaultValue" to true, "title" to "控制是否回弹效果", "onChange" to change_bounces_boolean)),
                            _cV(_component_boolean_data, _uM("defaultValue" to true, "title" to "是否显示加载更多", "onChange" to change_load_more_boolean)),
                            _cV(_component_input_data, _uM("defaultValue" to "2", "title" to "设置cross-axis-count，触发 scrolltoupper 事件", "type" to "number", "onConfirm" to handleChangeCrossAxisCount)),
                            _cE("view", _uM("class" to "uni-slider uni-list-cell-padding"), _uA(
                                _cE("text", null, "拖动设置cross-axis-gap")
                            )),
                            _cE("view", _uM("class" to "uni-slider uni-list-cell-padding"), _uA(
                                _cV(_component_slider, _uM("max" to 20, "min" to 0, "step" to 1, "value" to unref(data).cross_axis_gap, "show-value" to true, "onChange" to handleChangeCrossAxisGap), null, 8, _uA(
                                    "value"
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-slider uni-list-cell-padding"), _uA(
                                _cE("text", null, "拖动设置main-axis-gap")
                            )),
                            _cE("view", _uM("class" to "uni-slider uni-list-cell-padding"), _uA(
                                _cV(_component_slider, _uM("max" to 20, "min" to 0, "step" to 1, "value" to unref(data).main_axis_gap, "show-value" to true, "onChange" to handleChangeMainAxisGap), null, 8, _uA(
                                    "value"
                                ))
                            )),
                            _cV(_component_input_data, _uM("defaultValue" to "50", "title" to "距顶部/左边多远时（单位px），触发 scrolltoupper 事件", "type" to "number", "onConfirm" to confirm_upper_threshold_input)),
                            _cV(_component_input_data, _uM("defaultValue" to "50", "title" to "距底部/右边多远时（单位px），触发 scrolltolower 事件", "type" to "number", "onConfirm" to confirm_lower_threshold_input)),
                            _cV(_component_input_data, _uM("defaultValue" to "0", "title" to "设置竖向滚动条位置", "type" to "number", "onConfirm" to confirm_scroll_top_input)),
                            _cV(_component_input_data, _uM("defaultValue" to "#FFF", "title" to "设置下拉刷新区域背景颜色", "type" to "text", "onConfirm" to confirm_refresher_background_input)),
                            _cV(_component_enum_data, _uM("items" to unref(data).size_enum, "title" to "通过id位置跳转", "onChange" to item_change_size_enum), null, 8, _uA(
                                "items"
                            )),
                            _cV(_component_navigator, _uM("url" to "/pages/component/waterflow/waterflow-fit-height"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("button", _uM("type" to "primary", "class" to "button"), " item高度自适应 ")
                                )
                            }
                            ), "_" to 1))
                        ))
                    ), 4)
                ), 64)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("main" to _pS(_uM("maxHeight" to 250, "paddingTop" to 5, "paddingRight" to 0, "paddingBottom" to 5, "paddingLeft" to 0, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "rgba(0,0,0,0.06)", "flexDirection" to "row", "justifyContent" to "center")), "flow-item" to _pS(_uM("width" to "100%", "height" to 200, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#666666", "borderRightColor" to "#666666", "borderBottomColor" to "#666666", "borderLeftColor" to "#666666", "backgroundColor" to "#66ccff", "alignItems" to "center", "justifyContent" to "center")), "tip-text" to _pS(_uM("color" to "#888888", "fontSize" to 12)), "refresh-box" to _pS(_uM("justifyContent" to "center", "alignItems" to "center", "flexDirection" to "row", "height" to 45, "width" to "100%")), "load-more-box" to _pS(_uM("justifyContent" to "center", "alignItems" to "center", "flexDirection" to "row", "height" to 45, "width" to "100%", "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid")), "button" to _pS(_uM("marginTop" to 15)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
