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
open class GenPagesComponentSliderSlider : BasePage {
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
    open var data: DataType__28
        get() {
            return unref(this.`$exposed`["data"]) as DataType__28
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentSliderSlider, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentSliderSlider
            val _cache = __ins.renderCache
            val data = reactive(DataType__28(sliderValue = 50, sliderBlockSize = 20, sliderBackgroundColor = "#000000", sliderActiveColor = "#FFCC33", sliderBlockColor = "#8A6DE9", show_value_boolean = false, disabled_boolean = false, min_input = 0, max_input = 100, step_input = 1, value_input = 0, activeColor_input = "#007aff", backgroundColor_input = "#e9e9e9", block_size_input = 28, block_color_input = "#ffffff", valueColor = "#888888"))
            val sliderChange = fun(e: UniSliderChangeEvent){
                console.log("value 发生变化：" + e.detail.value)
            }
            val slider_click = fun(){
                console.log("组件被点击时触发")
            }
            val slider_touchstart = fun(){
                console.log("手指触摸动作开始")
            }
            val slider_touchmove = fun(){
                console.log("手指触摸后移动")
            }
            val slider_touchcancel = fun(){
                console.log("手指触摸动作被打断，如来电提醒，弹窗")
            }
            val slider_touchend = fun(){
                console.log("手指触摸动作结束")
            }
            val slider_tap = fun(){
                console.log("手指触摸后马上离开")
            }
            val slider_longpress = fun(){
                console.log("如果一个组件被绑定了 longpress 事件，那么当用户长按这个组件时，该事件将会被触发。")
            }
            val slider_change = fun(){
                console.log("完成一次拖动后触发的事件，event.detail = {value: value}")
            }
            val slider_changing = fun(){
                console.log("拖动过程中触发的事件，event.detail = {value: value}")
            }
            val change_show_value_boolean = fun(checked: Boolean){
                data.show_value_boolean = checked
            }
            val change_disabled_boolean = fun(checked: Boolean){
                data.disabled_boolean = checked
            }
            val confirm_min_input = fun(value: Number){
                data.min_input = value
            }
            val confirm_max_input = fun(value: Number){
                data.max_input = value
            }
            val confirm_step_input = fun(value: Number){
                data.step_input = value
            }
            val confirm_value_input = fun(value: Number){
                data.value_input = value
            }
            val confirm_activeColor_input = fun(value: String){
                data.activeColor_input = value
            }
            val confirm_backgroundColor_input = fun(value: String){
                data.backgroundColor_input = value
            }
            val confirm_block_size_input = fun(value: Number){
                data.block_size_input = value
            }
            val confirm_block_color_input = fun(value: String){
                data.block_color_input = value
            }
            val confirm_value_color_input = fun(value: String){
                data.valueColor = value
            }
            __expose(_uM("data" to data))
            return fun(): Any? {
                val _component_slider = resolveComponent("slider")
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                val _component_boolean_data = resolveEasyComponent("boolean-data", GenComponentsBooleanDataBooleanDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                val _component_navigator = resolveComponent("navigator")
                return _cE(Fragment, null, _uA(
                    _cE("view", _uM("class" to "main"), _uA(
                        _cV(_component_slider, _uM("disabled" to unref(data).disabled_boolean, "min" to unref(data).min_input, "max" to unref(data).max_input, "step" to unref(data).step_input, "value" to unref(data).value_input, "activeColor" to unref(data).activeColor_input, "backgroundColor" to unref(data).backgroundColor_input, "block-size" to unref(data).block_size_input, "block-color" to unref(data).block_color_input, "show-value" to unref(data).show_value_boolean, "valueColor" to unref(data).valueColor, "onClick" to _uA(
                            slider_click,
                            slider_tap
                        ), "onTouchstart" to slider_touchstart, "onTouchmove" to slider_touchmove, "onTouchcancel" to slider_touchcancel, "onTouchend" to slider_touchend, "onLongpress" to slider_longpress, "onChange" to slider_change, "onChanging" to slider_changing, "style" to _nS(_uM("width" to "90%"))), null, 8, _uA(
                            "disabled",
                            "min",
                            "max",
                            "step",
                            "value",
                            "activeColor",
                            "backgroundColor",
                            "block-size",
                            "block-color",
                            "show-value",
                            "valueColor",
                            "style"
                        ))
                    )),
                    _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                        _cE("view", _uM("class" to "content"), _uA(
                            _cV(_component_page_head, _uM("title" to "组件属性")),
                            _cV(_component_boolean_data, _uM("defaultValue" to false, "title" to "是否显示当前 value", "onChange" to change_show_value_boolean)),
                            _cV(_component_boolean_data, _uM("defaultValue" to false, "title" to "是否禁用", "onChange" to change_disabled_boolean)),
                            _cV(_component_input_data, _uM("defaultValue" to "0", "title" to "最小值(min)", "type" to "number", "onConfirm" to confirm_min_input)),
                            _cV(_component_input_data, _uM("defaultValue" to "100", "title" to "最大值(max)", "type" to "number", "onConfirm" to confirm_max_input)),
                            _cV(_component_input_data, _uM("defaultValue" to "1", "title" to "步长(step)，取值必须大于 0，并且可被(max - min)整除", "type" to "number", "onConfirm" to confirm_step_input)),
                            _cV(_component_input_data, _uM("defaultValue" to "0", "title" to "当前取值(value)", "type" to "number", "onConfirm" to confirm_value_input)),
                            _cV(_component_input_data, _uM("defaultValue" to "#007aff", "title" to "滑块左侧已选择部分的线条颜色(active-color)", "type" to "text", "onConfirm" to confirm_activeColor_input)),
                            _cV(_component_input_data, _uM("defaultValue" to "#e9e9e9", "title" to "背景条的颜色(background-color)", "type" to "text", "onConfirm" to confirm_backgroundColor_input)),
                            _cV(_component_input_data, _uM("defaultValue" to "28", "title" to "滑块的大小(block-size)，取值范围为 12 - 28", "type" to "number", "onConfirm" to confirm_block_size_input)),
                            _cV(_component_input_data, _uM("defaultValue" to "#ffffff", "title" to "滑块颜色(block-color)", "type" to "text", "onConfirm" to confirm_block_color_input)),
                            _cV(_component_input_data, _uM("defaultValue" to "#888888", "title" to "Value颜色(value-color)", "type" to "text", "onConfirm" to confirm_value_color_input))
                        )),
                        _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                            _cV(_component_page_head, _uM("title" to "默认及使用")),
                            _cE("view", _uM("class" to "uni-title"), "显示当前value"),
                            _cE("view", null, _uA(
                                _cV(_component_slider, _uM("style" to _nS(_uM("padding" to "5px 0")), "onChange" to sliderChange, "value" to 50, "show-value" to true), null, 8, _uA(
                                    "style"
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-title"), "设置步进:step=10跳动"),
                            _cE("view", null, _uA(
                                _cE("view", _uM("class" to "uni-row"), _uA(
                                    _cE("text", null, "0"),
                                    _cE("text", _uM("class" to "m-l-a"), "100")
                                )),
                                _cV(_component_slider, _uM("style" to _nS(_uM("padding" to "5px 0")), "onChange" to sliderChange, "value" to 60, "step" to 10), null, 8, _uA(
                                    "style"
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-title"), "浮点步进:step=0.01跳动"),
                            _cE("view", null, _uA(
                                _cV(_component_slider, _uM("style" to _nS(_uM("padding" to "5px 0")), "value" to 0.5, "min" to 0, "max" to 1, "step" to 0.01, "show-value" to true), null, 8, _uA(
                                    "style"
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-title"), "设置最小/最大值"),
                            _cE("view", null, _uA(
                                _cV(_component_slider, _uM("style" to _nS(_uM("padding" to "5px 0")), "onChange" to sliderChange, "value" to 100, "min" to 50, "max" to 200, "show-value" to true), null, 8, _uA(
                                    "style"
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-title"), "不同颜色和大小的滑块"),
                            _cE("view", null, _uA(
                                _cV(_component_slider, _uM("style" to _nS(_uM("padding" to "5px 0")), "id" to "slider-custom-color-and-size", "onChange" to sliderChange, "value" to unref(data).sliderValue, "backgroundColor" to unref(data).sliderBackgroundColor, "activeColor" to unref(data).sliderActiveColor, "activeBackgroundColor" to unref(data).sliderActiveColor, "blockColor" to unref(data).sliderBlockColor, "foreColor" to unref(data).sliderBlockColor, "block-size" to unref(data).sliderBlockSize, "track-class" to "custom-track", "track-active-class" to "custom-track-active", "thumb-class" to "custom-thumb"), null, 8, _uA(
                                    "style",
                                    "value",
                                    "backgroundColor",
                                    "activeColor",
                                    "activeBackgroundColor",
                                    "blockColor",
                                    "foreColor",
                                    "block-size"
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-title"), "暗黑模式"),
                            _cE("view", null, _uA(
                                _cV(_component_slider, _uM("style" to _nS(_uM("padding" to "5px 0")), "show-value" to true, "backgroundColor" to "rgba(32,32,32,0.5)", "valueColor" to "#555", "track-class" to "dark-track", "thumb-class" to "dark-thumb"), null, 8, _uA(
                                    "style"
                                ))
                            )),
                            _cV(_component_navigator, _uM("class" to "uni-common-mb", "url" to "/pages/template/slider-100/slider-100"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("button", null, "组件性能测试")
                                )
                            }
                            ), "_" to 1)),
                            _cV(_component_navigator, _uM("class" to "uni-common-mb", "url" to "./slider-in-swiper"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("button", null, "slider in swiper")
                                )
                            }
                            ), "_" to 1)),
                            _cV(_component_navigator, _uM("class" to "uni-common-mb", "url" to "./slider-maxValue"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("button", null, "slider maxValue")
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
                return _uM("main" to _pS(_uM("paddingTop" to 5, "paddingRight" to 0, "paddingBottom" to 5, "paddingLeft" to 0, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "rgba(0,0,0,0.06)", "flexDirection" to "row", "justifyContent" to "center")), "m-l-a" to _pS(_uM("marginLeft" to "auto")), "custom-track" to _pS(_uM("backgroundColor" to "#000000")), "custom-track-active" to _pS(_uM("backgroundColor" to "#FFCC33")), "custom-thumb" to _pS(_uM("width" to 20, "height" to 20, "backgroundColor" to "#8A6DE9", "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "borderBottomRightRadius" to 10, "borderBottomLeftRadius" to 10)), "dark-track" to _pS(_uM("backgroundColor" to "rgba(32,32,32,0.5)")), "dark-thumb" to _pS(_uM("backgroundColor" to "#555555")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
