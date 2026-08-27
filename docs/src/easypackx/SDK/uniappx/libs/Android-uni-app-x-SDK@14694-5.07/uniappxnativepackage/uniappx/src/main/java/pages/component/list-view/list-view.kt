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
open class GenPagesComponentListViewListView : BasePage {
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
    open var data: DataType__10
        get() {
            return unref(this.`$exposed`["data"]) as DataType__10
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
    open var change_scroll_x_boolean: (checked: Boolean) -> Unit
        get() {
            return unref(this.`$exposed`["change_scroll_x_boolean"]) as (checked: Boolean) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "change_scroll_x_boolean", value)
        }
    open var change_scroll_y_boolean: (checked: Boolean) -> Unit
        get() {
            return unref(this.`$exposed`["change_scroll_y_boolean"]) as (checked: Boolean) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "change_scroll_y_boolean", value)
        }
    open var confirm_scroll_left_input: (value: Number) -> Unit
        get() {
            return unref(this.`$exposed`["confirm_scroll_left_input"]) as (value: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "confirm_scroll_left_input", value)
        }
    open var check_scroll_height: () -> Boolean
        get() {
            return unref(this.`$exposed`["check_scroll_height"]) as () -> Boolean
        }
        set(value) {
            setRefValue(this.`$exposed`, "check_scroll_height", value)
        }
    open var check_scroll_width: () -> Boolean
        get() {
            return unref(this.`$exposed`["check_scroll_width"]) as () -> Boolean
        }
        set(value) {
            setRefValue(this.`$exposed`, "check_scroll_width", value)
        }
    open var item_change_size_enum: (index: Number) -> Unit
        get() {
            return unref(this.`$exposed`["item_change_size_enum"]) as (index: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "item_change_size_enum", value)
        }
    open var setScrollIntoView: (id: String) -> Unit
        get() {
            return unref(this.`$exposed`["setScrollIntoView"]) as (id: String) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setScrollIntoView", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentListViewListView, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentListViewListView
            val _cache = __ins.renderCache
            val data = reactive(DataType__10(refresher_triggered_boolean = false, refresher_enabled_boolean = false, scroll_with_animation_boolean = false, show_scrollbar_boolean = false, bounces_boolean = true, scroll_y_boolean = true, scroll_x_boolean = false, scroll_direction = "vertical", upper_threshold_input = 50, lower_threshold_input = 50, scroll_top_input = 0, scroll_left_input = 0, refresher_background_input = "#FFF", scrollData = _uA(), size_enum = _uA(
                ItemType(value = 0, name = "item---0"),
                ItemType(value = 3, name = "item---3")
            ), scrollIntoView = "", refresherrefresh = false, refresher_default_style_input = "black", text = _uA(
                "继续下拉执行刷新",
                "释放立即刷新",
                "刷新中",
                ""
            ), state = 3, reset = true, isScrollTest = "", isScrolltolowerTest = "", isScrolltoupperTest = "", scrollDetailTest = null, scrollEndDetailTest = null))
            onLoad(fun(_options){
                var lists: UTSArray<String> = _uA()
                run {
                    var i: Number = 0
                    while(i < 10){
                        lists.push("item---" + i)
                        i++
                    }
                }
                data.scrollData = lists
            }
            )
            val list_view_click = fun(){
                console.log("组件被点击时触发")
            }
            val list_view_touchstart = fun(){
                console.log("手指触摸动作开始")
            }
            val list_view_touchmove = fun(){
                console.log("手指触摸后移动")
            }
            val list_view_touchcancel = fun(){
                console.log("手指触摸动作被打断，如来电提醒，弹窗")
            }
            val list_view_touchend = fun(){
                console.log("手指触摸动作结束")
            }
            val list_view_tap = fun(){
                console.log("手指触摸后马上离开")
            }
            val list_view_longpress = fun(){
                console.log("如果一个组件被绑定了 longpress 事件，那么当用户长按这个组件时，该事件将会被触发。")
            }
            val list_view_refresherpulling = fun(e: RefresherEvent){
                console.log("下拉刷新控件被下拉")
                if (data.reset) {
                    if (e.detail.dy > 45) {
                        data.state = 1
                    } else {
                        data.state = 0
                    }
                }
            }
            val list_view_refresherrefresh = fun(){
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
            val list_view_refresherrestore = fun(){
                data.refresherrefresh = false
                data.state = 3
                data.reset = true
                console.log("下拉刷新被复位")
            }
            val list_view_refresherabort = fun(){
                console.log("下拉刷新被中止")
            }
            val checkEventTest = fun(e: ScrollEventTest__1, eventName: String){
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
            val list_view_scrolltoupper = fun(e: UniScrollToUpperEvent){
                console.log("滚动到顶部/左边，会触发 scrolltoupper 事件  direction=" + e.detail.direction)
                checkEventTest(ScrollEventTest__1(type = e.type, target = e.target, currentTarget = e.currentTarget, direction = e.detail.direction), "scrolltoupper")
            }
            val list_view_scrolltolower = fun(e: UniScrollToLowerEvent){
                console.log("滚动到底部/右边，会触发 scrolltolower 事件  direction=" + e.detail.direction)
                checkEventTest(ScrollEventTest__1(type = e.type, target = e.target, currentTarget = e.currentTarget, direction = e.detail.direction), "scrolltolower")
            }
            val list_view_scroll = fun(e: UniScrollEvent){
                console.log("滚动时触发，event.detail = {scrollLeft, scrollTop, scrollHeight, scrollWidth, deltaX, deltaY}")
                data.scrollDetailTest = e.detail
                checkEventTest(ScrollEventTest__1(type = e.type, target = e.target, currentTarget = e.currentTarget), "scroll")
            }
            val list_view_scrollend = fun(e: UniScrollEvent){
                console.log("滚动结束时触发", e.detail)
                data.scrollEndDetailTest = e.detail
                checkEventTest(ScrollEventTest__1(type = e.type, target = e.target, currentTarget = e.currentTarget), "scrollend")
            }
            val list_item_click = fun(){
                console.log("list-item组件被点击时触发")
            }
            val list_item_touchstart = fun(){
                console.log("手指触摸list-item组件动作开始")
            }
            val list_item_touchmove = fun(){
                console.log("手指触摸list-item组件后移动")
            }
            val list_item_touchcancel = fun(){
                console.log("手指触摸list-item组件动作被打断，如来电提醒，弹窗")
            }
            val list_item_touchend = fun(){
                console.log("手指触摸list-item组件动作结束")
            }
            val list_item_tap = fun(){
                console.log("手指触摸list-item组件后马上离开")
            }
            val list_item_longpress = fun(){
                console.log("list-item组件被绑定了 longpress 事件，那么当用户长按这个组件时，该事件将会被触发。")
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
            val change_scroll_direction = fun(){
                if (data.scroll_y_boolean && data.scroll_x_boolean || data.scroll_y_boolean) {
                    data.scroll_direction = "vertical"
                } else if (!data.scroll_y_boolean && !data.scroll_x_boolean) {
                    data.scroll_direction = "none"
                } else if (!data.scroll_y_boolean && data.scroll_x_boolean) {
                    data.scroll_direction = "horizontal"
                }
            }
            val change_scroll_y_boolean = fun(checked: Boolean){
                data.scroll_y_boolean = checked
                change_scroll_direction()
            }
            val change_scroll_x_boolean = fun(checked: Boolean){
                data.scroll_x_boolean = checked
                change_scroll_direction()
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
            val confirm_scroll_left_input = fun(value: Number){
                data.scroll_left_input = value
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
                var listElement = uni_getElementById("listview") as UniElement
                console.log("check_scroll_height--" + listElement.scrollHeight)
                if (listElement.scrollHeight > 2000) {
                    return true
                }
                return false
            }
            val check_scroll_width = fun(): Boolean {
                var listElement = uni_getElementById("listview") as UniElement
                console.log("check_scroll_width" + listElement.scrollWidth)
                if (listElement.scrollWidth > 2000) {
                    return true
                }
                return false
            }
            val change_refresher_style_boolean = fun(checked: Boolean){
                if (checked) {
                    data.refresher_default_style_input = "none"
                } else {
                    data.refresher_default_style_input = "black"
                }
            }
            __expose(_uM("data" to data, "confirm_scroll_top_input" to confirm_scroll_top_input, "change_scroll_x_boolean" to change_scroll_x_boolean, "change_scroll_y_boolean" to change_scroll_y_boolean, "confirm_scroll_left_input" to confirm_scroll_left_input, "check_scroll_height" to check_scroll_height, "check_scroll_width" to check_scroll_width, "item_change_size_enum" to item_change_size_enum, "setScrollIntoView" to setScrollIntoView))
            return fun(): Any? {
                val _component_boolean_data = resolveEasyComponent("boolean-data", GenComponentsBooleanDataBooleanDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_navigator = resolveComponent("navigator")
                return _cE(Fragment, null, _uA(
                    _cE("view", _uM("class" to "main"), _uA(
                        _cE("list-view", _uM("direction" to unref(data).scroll_direction, "bounces" to unref(data).bounces_boolean, "upper-threshold" to unref(data).upper_threshold_input, "lower-threshold" to unref(data).lower_threshold_input, "scroll-top" to unref(data).scroll_top_input, "scroll-left" to unref(data).scroll_left_input, "show-scrollbar" to unref(data).show_scrollbar_boolean, "scroll-into-view" to unref(data).scrollIntoView, "scroll-with-animation" to unref(data).scroll_with_animation_boolean, "refresher-enabled" to unref(data).refresher_enabled_boolean, "refresher-background" to unref(data).refresher_background_input, "refresher-triggered" to unref(data).refresher_triggered_boolean, "refresher-default-style" to unref(data).refresher_default_style_input, "onClick" to _uA<Any?>(list_view_click, list_view_tap), "onTouchstart" to list_view_touchstart, "onTouchmove" to list_view_touchmove, "onTouchcancel" to list_view_touchcancel, "onTouchend" to list_view_touchend, "onLongpress" to list_view_longpress, "onRefresherpulling" to list_view_refresherpulling, "onRefresherrefresh" to list_view_refresherrefresh, "onRefresherrestore" to list_view_refresherrestore, "onRefresherabort" to list_view_refresherabort, "onScrolltoupper" to list_view_scrolltoupper, "ref" to "listview", "onScrolltolower" to list_view_scrolltolower, "onScroll" to list_view_scroll, "onScrollend" to list_view_scrollend, "style" to _nS(_uM("width" to "100%")), "id" to "listview"), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(unref(data).scrollData, fun(key, __key, __index, _cached): Any {
                                return _cE("list-item", _uM("key" to key, "id" to key, "onClick" to _uA<Any?>(list_item_click, list_item_tap), "onTouchstart" to list_item_touchstart, "onTouchmove" to list_item_touchmove, "onTouchcancel" to list_item_touchcancel, "onTouchend" to list_item_touchend, "onLongpress" to list_item_longpress, "class" to "list-item"), _uA(
                                    _cE("text", null, _tD(key), 1)
                                ), 40, _uA(
                                    "id"
                                ))
                            }
                            ), 128),
                            _cE("list-item", _uM("slot" to "refresher", "class" to "refresh-box"), _uA(
                                _cE("text", _uM("class" to "tip-text"), _tD(unref(data).text[unref(data).state]), 1)
                            ))
                        ), 44, _uA(
                            "direction",
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
                            "refresher-default-style"
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
                            _cV(_component_boolean_data, _uM("defaultValue" to true, "title" to "允许纵向滚动", "onChange" to change_scroll_y_boolean)),
                            _cV(_component_boolean_data, _uM("defaultValue" to false, "title" to "允许横向滚动", "onChange" to change_scroll_x_boolean)),
                            _cV(_component_input_data, _uM("defaultValue" to "50", "title" to "距顶部/左边多远时（单位px），触发 scrolltoupper 事件", "type" to "number", "onConfirm" to confirm_upper_threshold_input)),
                            _cV(_component_input_data, _uM("defaultValue" to "50", "title" to "距底部/右边多远时（单位px），触发 scrolltolower 事件", "type" to "number", "onConfirm" to confirm_lower_threshold_input)),
                            _cV(_component_input_data, _uM("defaultValue" to "0", "title" to "设置竖向滚动条位置", "type" to "number", "onConfirm" to confirm_scroll_top_input)),
                            _cV(_component_input_data, _uM("defaultValue" to "0", "title" to "设置横向滚动条位置", "type" to "number", "onConfirm" to confirm_scroll_left_input)),
                            _cV(_component_input_data, _uM("defaultValue" to "#FFF", "title" to "设置下拉刷新区域背景颜色", "type" to "text", "onConfirm" to confirm_refresher_background_input)),
                            _cV(_component_enum_data, _uM("items" to unref(data).size_enum, "title" to "通过id位置跳转", "onChange" to item_change_size_enum), null, 8, _uA(
                                "items"
                            )),
                            _cV(_component_navigator, _uM("url" to "/pages/component/list-view/list-view-refresh"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("button", _uM("type" to "primary", "class" to "button"), " list-view 下拉刷新 ")
                                )
                            }
                            ), "_" to 1)),
                            _cV(_component_navigator, _uM("url" to "/pages/component/list-view/list-view-multiplex"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("button", _uM("type" to "primary", "class" to "button"), " list-view 对list-item复用测试 ")
                                )
                            }
                            ), "_" to 1)),
                            _cV(_component_navigator, _uM("url" to "/pages/component/list-view/list-view-multiplex-input"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("button", _uM("type" to "primary", "class" to "button"), " list-view 复用测试（item中嵌入input） ")
                                )
                            }
                            ), "_" to 1)),
                            _cV(_component_navigator, _uM("url" to "/pages/component/list-view/list-view-multiplex-video"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("button", _uM("type" to "primary", "class" to "button"), " list-view 复用测试（item中嵌入video） ")
                                )
                            }
                            ), "_" to 1)),
                            _cV(_component_navigator, _uM("url" to "/pages/component/list-view/list-view-children-in-slot"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("button", _uM("type" to "primary", "class" to "button"), " list-view 测试插槽中子组件增删 ")
                                )
                            }
                            ), "_" to 1)),
                            _cV(_component_navigator, _uM("url" to "/pages/component/list-view/list-view-children-if-show"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("button", _uM("type" to "primary", "class" to "button"), " list-item v-if v-show 组合增删 ")
                                )
                            }
                            ), "_" to 1)),
                            _cV(_component_navigator, _uM("url" to "/pages/template/im/im"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("button", _uM("type" to "primary", "class" to "button"), " list-item 中设置长按事件测试 ")
                                )
                            }
                            ), "_" to 1)),
                            _cV(_component_navigator, _uM("url" to "/pages/component/list-view/list-view-form-item"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("button", _uM("type" to "primary", "class" to "button"), " list-item 中使用表单元素测试 ")
                                )
                            }
                            ), "_" to 1)),
                            _cV(_component_navigator, _uM("url" to "/pages/component/list-view/list-view-with-type"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("button", _uM("type" to "primary", "class" to "button"), " list-item 上使用 type 属性测试 ")
                                )
                            }
                            ), "_" to 1)),
                            _cV(_component_navigator, _uM("url" to "/pages/component/list-view/list-view-issue-17610"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("button", _uM("type" to "primary", "class" to "button"), " list-view 子节点为多根节点组件 ")
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
                return _uM("main" to _pS(_uM("maxHeight" to 250, "paddingTop" to 5, "paddingRight" to 0, "paddingBottom" to 5, "paddingLeft" to 0, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "rgba(0,0,0,0.06)", "flexDirection" to "row", "justifyContent" to "center")), "list-item" to _pS(_uM("width" to "100%", "height" to 250, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#666666", "borderRightColor" to "#666666", "borderBottomColor" to "#666666", "borderLeftColor" to "#666666", "backgroundColor" to "#66ccff", "alignItems" to "center", "justifyContent" to "center")), "tip-text" to _pS(_uM("color" to "#888888", "fontSize" to 12)), "refresh-box" to _pS(_uM("justifyContent" to "center", "alignItems" to "center", "flexDirection" to "row", "height" to 45, "width" to "100%")), "button" to _pS(_uM("marginTop" to 15)), "content" to _pS(_uM("paddingBottom" to 20)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
