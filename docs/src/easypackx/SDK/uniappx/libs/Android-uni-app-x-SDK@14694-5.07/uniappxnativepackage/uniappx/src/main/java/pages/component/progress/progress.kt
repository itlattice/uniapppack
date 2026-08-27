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
open class GenPagesComponentProgressProgress : BasePage {
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
    open var data: DataType__21
        get() {
            return unref(this.`$exposed`["data"]) as DataType__21
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
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
    open var setProgress: () -> Unit
        get() {
            return unref(this.`$exposed`["setProgress"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setProgress", value)
        }
    open var clearProgress: () -> Unit
        get() {
            return unref(this.`$exposed`["clearProgress"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "clearProgress", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentProgressProgress, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentProgressProgress
            val _cache = __ins.renderCache
            val data = reactive(DataType__21(title = "progress", pgList = _uA<Number>(0, 0, 0, 0), curPercent = 0, showInfo = true, borderRadius = 0, fontSize = 16, strokeWidth = 3, backgroundColor = "#EBEBEB", active_boolean = false, show_info_boolean = false, duration_input = 30, percent_input = 0, stroke_width_input = 6, activeColor_input = "#09BB07", backgroundColor_input = "#EBEBEB", active_mode_enum = _uA<ItemType>(ItemType(value = 0, name = "backwards"), ItemType(value = 1, name = "forwards")), active_mode_enum_current = 0))
            val getEventCallbackNum = fun(): Number {
                return state.eventCallbackNum
            }
            val setEventCallbackNumTest = fun(num: Number){
                setEventCallbackNum(num)
            }
            val setProgress = fun(){
                data.pgList = _uA<Number>(20, 40, 60, 80)
            }
            val clearProgress = fun(){
                data.pgList = _uA<Number>(0, 0, 0, 0)
            }
            val activeend = fun(e: UniProgressActiveendEvent){
                if ((e.target?.tagName ?: "").includes("PROGRESS")) {
                    setEventCallbackNumTest(state.eventCallbackNum + 1)
                }
                if (e.type === "activeend") {
                    setEventCallbackNumTest(state.eventCallbackNum + 2)
                }
                data.curPercent = e.detail.curPercent
            }
            val progress_touchstart = fun(){
                console.log("手指触摸动作开始")
            }
            val progress_touchmove = fun(){
                console.log("手指触摸后移动")
            }
            val progress_touchcancel = fun(){
                console.log("手指触摸动作被打断，如来电提醒，弹窗")
            }
            val progress_touchend = fun(){
                console.log("手指触摸动作结束")
            }
            val progress_tap = fun(){
                console.log("手指触摸后马上离开")
            }
            val change_active_boolean = fun(checked: Boolean){
                data.active_boolean = checked
            }
            val change_show_info_boolean = fun(checked: Boolean){
                data.show_info_boolean = checked
            }
            val confirm_duration_input = fun(value: Number){
                data.duration_input = value
            }
            val confirm_percent_input = fun(value: Number){
                data.percent_input = value
            }
            val confirm_stroke_width_input = fun(value: Number){
                data.stroke_width_input = value
            }
            val confirm_activeColor_input = fun(value: String){
                data.activeColor_input = value
            }
            val confirm_backgroundColor_input = fun(value: String){
                data.backgroundColor_input = value
            }
            val radio_change_active_mode_enum = fun(checked: Number){
                data.active_mode_enum_current = checked
            }
            __expose(_uM("data" to data, "getEventCallbackNum" to getEventCallbackNum, "setEventCallbackNumTest" to setEventCallbackNumTest, "setProgress" to setProgress, "clearProgress" to clearProgress))
            return fun(): Any? {
                val _component_progress = resolveComponent("progress")
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                val _component_boolean_data = resolveEasyComponent("boolean-data", GenComponentsBooleanDataBooleanDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_navigator = resolveComponent("navigator")
                return _cE(Fragment, null, _uA(
                    _cE("view", _uM("class" to "main"), _uA(
                        _cV(_component_progress, _uM("duration" to unref(data).duration_input, "percent" to unref(data).percent_input, "show-info" to unref(data).show_info_boolean, "stroke-width" to unref(data).stroke_width_input, "activeColor" to unref(data).activeColor_input, "backgroundColor" to unref(data).backgroundColor_input, "active" to unref(data).active_boolean, "active-mode" to unref(data).active_mode_enum[unref(data).active_mode_enum_current].name, "onTouchstart" to progress_touchstart, "onTouchmove" to progress_touchmove, "onTouchcancel" to progress_touchcancel, "onTouchend" to progress_touchend, "onClick" to progress_tap, "style" to _nS(_uM("width" to "80%"))), null, 8, _uA(
                            "duration",
                            "percent",
                            "show-info",
                            "stroke-width",
                            "activeColor",
                            "backgroundColor",
                            "active",
                            "active-mode",
                            "style"
                        ))
                    )),
                    _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                        _cE("view", _uM("class" to "content"), _uA(
                            _cV(_component_page_head, _uM("title" to "组件属性")),
                            _cV(_component_boolean_data, _uM("defaultValue" to false, "title" to "进度条从左往右的动画", "onChange" to change_active_boolean)),
                            _cV(_component_boolean_data, _uM("defaultValue" to false, "title" to "在进度条右侧显示百分比", "onChange" to change_show_info_boolean)),
                            _cV(_component_input_data, _uM("defaultValue" to "30", "title" to "进度增加1%所需毫秒数", "type" to "number", "onConfirm" to confirm_duration_input)),
                            _cV(_component_input_data, _uM("defaultValue" to "0", "title" to "百分比0~100", "type" to "number", "onConfirm" to confirm_percent_input)),
                            _cV(_component_input_data, _uM("defaultValue" to "6", "title" to "进度条线的宽度，单位px", "type" to "number", "onConfirm" to confirm_stroke_width_input)),
                            _cV(_component_input_data, _uM("defaultValue" to "#09BB07", "title" to "已选择的进度条的颜色", "type" to "text", "onConfirm" to confirm_activeColor_input)),
                            _cV(_component_input_data, _uM("defaultValue" to "#EBEBEB", "title" to "未选择的进度条的颜色", "type" to "text", "onConfirm" to confirm_backgroundColor_input)),
                            _cV(_component_enum_data, _uM("items" to unref(data).active_mode_enum, "title" to "backwards: 动画从头播；forwards：动画从上次结束点接着播", "onChange" to radio_change_active_mode_enum), null, 8, _uA(
                                "items"
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cV(_component_page_head, _uM("title" to "默认及使用")),
                            _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt"), _uA(
                                _cE("view", _uM("class" to "progress-box"), _uA(
                                    _cV(_component_progress, _uM("percent" to unref(data).pgList[0], "active" to true, "border-radius" to unref(data).borderRadius, "show-info" to unref(data).showInfo, "font-size" to unref(data).fontSize, "stroke-width" to unref(data).strokeWidth, "background-color" to unref(data).backgroundColor, "class" to "progress p", "onActiveend" to activeend), null, 8, _uA(
                                        "percent",
                                        "border-radius",
                                        "show-info",
                                        "font-size",
                                        "stroke-width",
                                        "background-color"
                                    ))
                                )),
                                _cE("view", _uM("class" to "progress-box"), _uA(
                                    _cV(_component_progress, _uM("percent" to unref(data).pgList[1], "stroke-width" to 3, "class" to "progress p1"), null, 8, _uA(
                                        "percent"
                                    ))
                                )),
                                _cE("view", _uM("class" to "progress-box"), _uA(
                                    _cV(_component_progress, _uM("percent" to unref(data).pgList[2], "stroke-width" to 3, "class" to "progress p2"), null, 8, _uA(
                                        "percent"
                                    ))
                                )),
                                _cE("view", _uM("class" to "progress-box"), _uA(
                                    _cV(_component_progress, _uM("percent" to unref(data).pgList[3], "activeColor" to "#10AEFF", "stroke-width" to 3, "class" to "progress p3"), null, 8, _uA(
                                        "percent"
                                    ))
                                )),
                                _cE("view", _uM("class" to "progress-control"), _uA(
                                    _cE("button", _uM("type" to "primary", "onClick" to setProgress, "class" to "button"), " 设置进度 "),
                                    _cE("button", _uM("type" to "warn", "onClick" to clearProgress, "class" to "button"), " 清除进度 ")
                                ))
                            ))
                        )),
                        _cV(_component_navigator, _uM("class" to "uni-common-mb", "url" to "/pages/template/progress-100/progress-100"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("button", null, "组件性能测试")
                            )
                        }
                        ), "_" to 1))
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
                return _uM("main" to _pS(_uM("maxHeight" to 250, "paddingTop" to 5, "paddingRight" to 0, "paddingBottom" to 5, "paddingLeft" to 0, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "rgba(0,0,0,0.06)", "flexDirection" to "row", "justifyContent" to "center")), "progress-box" to _pS(_uM("height" to 25, "marginBottom" to 30)), "button" to _pS(_uM("marginTop" to 10)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
