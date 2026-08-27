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
import io.dcloud.uniapp.extapi.getSystemInfoSync as uni_getSystemInfoSync
open class GenPagesComponentSwiperSwiper : BasePage {
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
    open var data: DataType__8
        get() {
            return unref(this.`$exposed`["data"]) as DataType__8
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var jest_getSystemInfo: () -> GetSystemInfoResult
        get() {
            return unref(this.`$exposed`["jest_getSystemInfo"]) as () -> GetSystemInfoResult
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_getSystemInfo", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentSwiperSwiper, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentSwiperSwiper
            val _cache = __ins.renderCache
            val data = reactive(DataType__8(background = _uA(
                "color1",
                "color2",
                "color3"
            ), dotsSelect = false, reboundSelect = false, autoplaySelect = false, circularSelect = false, indicatorColorSelect = false, verticalSelect = false, currentSelect = false, currentItemIdSelect = false, intervalSelect = 2000, durationSelect = 500, indicatorColor = "", indicatorColorActive = "", currentVal = 0, currentItemIdVal = "", disableTouchSelect = false, swiperTransitionSelect = false, swiperAnimationfinishSelect = false, swiperChangeSelect = false, currentValChange = 0, autoplayForDefault = false, circularForDefault = false, changeDetailTest = null as UniSwiperChangeEventDetail?, transitionDetailTest = null as UniSwiperTransitionEventDetail?, animationfinishDetailTest = null as UniSwiperAnimationFinishEventDetail?, isChangeTest = "", isTransitionTest = "", isAnimationfinishTest = "", swipeX = 0, swipeY = 0))
            onReady(fun(){
                var ele = uni_getElementById("swiper-view")
                var eleRect = ele?.getBoundingClientRect()
                if (eleRect != null) {
                    data.swipeX = eleRect.width - 40
                    data.swipeY += eleRect.y + uni_getSystemInfoSync().safeArea.top + 44 + 35
                }
            }
            )
            val swipertouchStart = fun(e: UniTouchEvent){
                console.log("swiper touchstart")
            }
            val viewtouchStart = fun(e: UniTouchEvent){
                console.log("view touchstart:")
            }
            val checkEventTest = fun(e: SwiperEventTest, eventName: String){
                val isPass = e.type === eventName && e.target is UniElement && e.currentTarget is UniElement
                val result = if (isPass) {
                    "" + eventName + ":Success"
                } else {
                    "" + eventName + ":Fail"
                }
                when (eventName) {
                    "change" -> 
                        data.isChangeTest = result
                    "transition" -> 
                        data.isTransitionTest = result
                    "animationfinish" -> 
                        data.isAnimationfinishTest = result
                    else -> 
                        {}
                }
            }
            val swiperChange = fun(e: UniSwiperChangeEvent){
                data.changeDetailTest = e.detail
                checkEventTest(SwiperEventTest(type = e.type, target = e.target, currentTarget = e.currentTarget), "change")
                data.currentValChange = e.detail.current
                console.log(data.currentValChange)
                if (data.swiperChangeSelect) {
                    console.log("swiperChange", e)
                }
            }
            val swiperTransition = fun(e: UniSwiperTransitionEvent){
                data.transitionDetailTest = e.detail
                checkEventTest(SwiperEventTest(type = e.type, target = e.target, currentTarget = e.currentTarget), "transition")
                if (data.swiperTransitionSelect) {
                    console.log("swiperTransition", e)
                }
            }
            val swiperAnimationfinish = fun(e: UniSwiperAnimationFinishEvent){
                data.animationfinishDetailTest = e.detail
                checkEventTest(SwiperEventTest(type = e.type, target = e.target, currentTarget = e.currentTarget), "animationfinish")
                if (data.swiperAnimationfinishSelect) {
                    console.log("swiperAnimationfinish", e)
                }
            }
            val jest_getSystemInfo = fun(): GetSystemInfoResult {
                return uni_getSystemInfoSync()
            }
            val dotsChange = fun(e: UniSwitchChangeEvent){
                data.dotsSelect = e.detail.value
            }
            val swiperTransitionChange = fun(e: UniSwitchChangeEvent){
                data.swiperTransitionSelect = e.detail.value
            }
            val swiperChangeChange = fun(e: UniSwitchChangeEvent){
                data.swiperChangeSelect = e.detail.value
            }
            val swiperAnimationfinishChange = fun(e: UniSwitchChangeEvent){
                data.swiperAnimationfinishSelect = e.detail.value
            }
            val autoplayChange = fun(e: UniSwitchChangeEvent){
                data.autoplaySelect = e.detail.value
            }
            val verticalChange = fun(e: UniSwitchChangeEvent){
                data.verticalSelect = e.detail.value
            }
            val disableTouchChange = fun(e: UniSwitchChangeEvent){
                data.disableTouchSelect = e.detail.value
            }
            val currentItemIdChange = fun(e: UniSwitchChangeEvent){
                data.currentItemIdSelect = e.detail.value
                if (data.currentItemIdSelect) {
                    data.currentItemIdVal = "C"
                } else {
                    data.currentItemIdVal = "A"
                }
            }
            val currentChange = fun(e: UniSwitchChangeEvent){
                data.currentSelect = e.detail.value
                if (data.currentSelect) {
                    data.currentVal = 2
                } else {
                    data.currentVal = 0
                }
            }
            val circularChange = fun(e: UniSwitchChangeEvent){
                data.circularSelect = e.detail.value
                console.log(data.circularSelect)
            }
            val reboundSelectChange = fun(e: UniSwitchChangeEvent){
                data.reboundSelect = e.detail.value
                console.log(data.reboundSelect)
            }
            val sliderChange = fun(e: UniSliderChangeEvent){
                data.intervalSelect = e.detail.value
            }
            val durationSliderChange = fun(e: UniSliderChangeEvent){
                data.durationSelect = e.detail.value
            }
            val indicatorColorChange = fun(e: UniSwitchChangeEvent){
                data.indicatorColorSelect = e.detail.value
                if (data.indicatorColorSelect) {
                    data.indicatorColor = "#ff00ff"
                    data.indicatorColorActive = "#0000ff"
                } else {
                    data.indicatorColor = ""
                    data.indicatorColorActive = ""
                }
            }
            __expose(_uM("data" to data, "jest_getSystemInfo" to jest_getSystemInfo))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                val _component_switch = resolveComponent("switch")
                val _component_slider = resolveComponent("slider")
                val _component_navigator = resolveComponent("navigator")
                return _cE("scroll-view", _uM("class" to "page-scroll-view"), _uA(
                    _cE("view", _uM("class" to "uni-common-mb uni-common-pb"), _uA(
                        _cV(_component_page_head, _uM("title" to "swiper,可滑动视图")),
                        _cE("view", null, _uA(
                            _cE("swiper", _uM("id" to "swiper-view", "class" to "swiper", "vertical" to unref(data).verticalSelect, "indicator-dots" to unref(data).dotsSelect, "autoplay" to unref(data).autoplaySelect, "bounces" to unref(data).reboundSelect, "interval" to unref(data).intervalSelect, "circular" to unref(data).circularSelect, "duration" to unref(data).durationSelect, "indicator-color" to unref(data).indicatorColor, "indicator-active-color" to unref(data).indicatorColorActive, "disable-touch" to unref(data).disableTouchSelect, "current" to unref(data).currentVal, "current-item-id" to unref(data).currentItemIdVal, "onChange" to swiperChange, "onTransition" to swiperTransition, "onAnimationfinish" to swiperAnimationfinish, "onTouchstart" to swipertouchStart), _uA(
                                _cE("swiper-item", _uM("item-id" to "A"), _uA(
                                    _cE("view", _uM("class" to "swiper-item uni-bg-red"), _uA(
                                        _cE("text", _uM("class" to "swiper-item-Text", "onTouchstart" to viewtouchStart), "A", 32)
                                    ))
                                )),
                                _cE("swiper-item", _uM("item-id" to "B"), _uA(
                                    _cE("view", _uM("class" to "swiper-item uni-bg-green"), _uA(
                                        _cE("text", _uM("class" to "swiper-item-Text"), "B")
                                    ))
                                )),
                                _cE("swiper-item", _uM("item-id" to "C"), _uA(
                                    _cE("view", _uM("class" to "swiper-item uni-bg-blue"), _uA(
                                        _cE("text", _uM("class" to "swiper-item-Text"), "C")
                                    ))
                                ))
                            ), 40, _uA(
                                "vertical",
                                "indicator-dots",
                                "autoplay",
                                "bounces",
                                "interval",
                                "circular",
                                "duration",
                                "indicator-color",
                                "indicator-active-color",
                                "disable-touch",
                                "current",
                                "current-item-id"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-list"), _uA(
                            _cE("view", _uM("class" to "uni-list-cell uni-list-cell-padding"), _uA(
                                _cE("view", _uM("class" to "uni-list-cell-db"), "显示面板指示点"),
                                _cV(_component_switch, _uM("checked" to unref(data).dotsSelect, "onChange" to dotsChange), null, 8, _uA(
                                    "checked"
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-list-cell uni-list-cell-padding"), _uA(
                                _cE("view", _uM("class" to "uni-list-cell-db"), "定制指示器颜色"),
                                _cV(_component_switch, _uM("checked" to unref(data).indicatorColorSelect, "onChange" to indicatorColorChange), null, 8, _uA(
                                    "checked"
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-list-cell uni-list-cell-padding"), _uA(
                                _cE("view", _uM("class" to "uni-list-cell-db"), "禁止 touch 操作"),
                                _cV(_component_switch, _uM("checked" to unref(data).disableTouchSelect, "onChange" to disableTouchChange), null, 8, _uA(
                                    "checked"
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-list-cell uni-list-cell-padding"), _uA(
                                _cE("view", _uM("class" to "uni-list-cell-db"), "是否自动切换"),
                                _cV(_component_switch, _uM("checked" to unref(data).autoplaySelect, "onChange" to autoplayChange), null, 8, _uA(
                                    "checked"
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-list-cell uni-list-cell-padding"), _uA(
                                _cE("view", _uM("class" to "uni-list-cell-db"), "是否衔接滑动"),
                                _cV(_component_switch, _uM("checked" to unref(data).circularSelect, "onChange" to circularChange), null, 8, _uA(
                                    "checked"
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-title uni-list-cell-padding"), "间隔时间(毫秒)"),
                            _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                                _cV(_component_slider, _uM("onChange" to sliderChange, "value" to 2000, "min" to 500, "max" to 5000, "show-value" to true))
                            )),
                            _cE("view", _uM("class" to "uni-title uni-list-cell-padding"), "动画时长(毫秒)"),
                            _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                                _cV(_component_slider, _uM("onChange" to durationSliderChange, "value" to 500, "min" to 50, "max" to 2000, "show-value" to true))
                            )),
                            _cE("view", _uM("class" to "uni-list-cell uni-list-cell-padding"), _uA(
                                _cE("view", _uM("class" to "uni-list-cell-db"), "是否纵向滑动"),
                                _cV(_component_switch, _uM("checked" to unref(data).verticalSelect, "onChange" to verticalChange), null, 8, _uA(
                                    "checked"
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-list-cell uni-list-cell-padding"), _uA(
                                _cE("view", _uM("class" to "uni-list-cell-db"), "是否回弹效果"),
                                _cV(_component_switch, _uM("checked" to unref(data).reboundSelect, "onChange" to reboundSelectChange), null, 8, _uA(
                                    "checked"
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-list-cell uni-list-cell-padding"), _uA(
                                _cE("view", _uM("class" to "uni-list-cell-db"), "指定current为最后一个元素"),
                                _cV(_component_switch, _uM("checked" to unref(data).currentSelect, "onChange" to currentChange), null, 8, _uA(
                                    "checked"
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-list-cell uni-list-cell-padding"), _uA(
                                _cE("view", _uM("class" to "uni-list-cell-db"), "指定current-item-id为最后一个元素"),
                                _cV(_component_switch, _uM("checked" to unref(data).currentItemIdSelect, "onChange" to currentItemIdChange), null, 8, _uA(
                                    "checked"
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-list-cell uni-list-cell-padding"), _uA(
                                _cE("view", _uM("class" to "uni-list-cell-db"), "打印 swiperChange 日志"),
                                _cV(_component_switch, _uM("checked" to unref(data).swiperChangeSelect, "onChange" to swiperChangeChange), null, 8, _uA(
                                    "checked"
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-list-cell uni-list-cell-padding"), _uA(
                                _cE("view", _uM("class" to "uni-list-cell-db"), "打印 swiperTransition 日志"),
                                _cV(_component_switch, _uM("checked" to unref(data).swiperTransitionSelect, "onChange" to swiperTransitionChange), null, 8, _uA(
                                    "checked"
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-list-cell uni-list-cell-padding"), _uA(
                                _cE("view", _uM("class" to "uni-list-cell-db"), "打印 swiperAnimationfinish 日志"),
                                _cV(_component_switch, _uM("checked" to unref(data).swiperAnimationfinishSelect, "onChange" to swiperAnimationfinishChange), null, 8, _uA(
                                    "checked"
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-list-cell-padding"), "测试 swiper 默认行为"),
                            _cE("swiper", _uM("class" to "swiper", "autoplay" to unref(data).autoplayForDefault, "circular" to unref(data).circularForDefault), _uA(
                                _cE("swiper-item", _uM("item-id" to "A"), _uA(
                                    _cE("view", _uM("class" to "swiper-item uni-bg-red"), _uA(
                                        _cE("text", _uM("class" to "swiper-item-Text"), "A")
                                    ))
                                )),
                                _cE("swiper-item", _uM("item-id" to "B"), _uA(
                                    _cE("view", _uM("class" to "swiper-item uni-bg-green"), _uA(
                                        _cE("text", _uM("class" to "swiper-item-Text"), "B")
                                    ))
                                )),
                                _cE("swiper-item", _uM("item-id" to "C"), _uA(
                                    _cE("view", _uM("class" to "swiper-item uni-bg-blue"), _uA(
                                        _cE("text", _uM("class" to "swiper-item-Text"), "C")
                                    ))
                                ))
                            ), 8, _uA(
                                "autoplay",
                                "circular"
                            )),
                            _cE("view", _uM("class" to "uni-list-cell uni-list-cell-padding"), _uA(
                                _cE("view", _uM("class" to "uni-list-cell-db"), "是否自动切换"),
                                _cV(_component_switch, _uM("checked" to unref(data).autoplayForDefault, "onChange" to fun(){
                                    unref(data).autoplayForDefault = !unref(data).autoplayForDefault
                                }
                                ), null, 8, _uA(
                                    "checked",
                                    "onChange"
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-list-cell uni-list-cell-padding"), _uA(
                                _cE("view", _uM("class" to "uni-list-cell-db"), "是否衔接滑动"),
                                _cV(_component_switch, _uM("checked" to unref(data).circularForDefault, "onChange" to fun(){
                                    unref(data).circularForDefault = !unref(data).circularForDefault
                                }
                                ), null, 8, _uA(
                                    "checked",
                                    "onChange"
                                ))
                            )),
                            _cV(_component_navigator, _uM("url" to "/pages/component/swiper/swiper-list-view"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("button", _uM("type" to "primary"), " swiper 嵌套 list-view 测试 ")
                                )
                            }
                            ), "_" to 1)),
                            _cV(_component_navigator, _uM("url" to "/pages/component/swiper/swiper-anim", "style" to _nS(_uM("margin-top" to "10px"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("button", _uM("type" to "primary"), " swiper 动画测试 ")
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "style"
                            ))
                        ))
                    ))
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
                return _uM("swiper" to _pS(_uM("height" to 150)), "swiper-item" to _pS(_uM("width" to "100%", "height" to 150)), "swiper-item-Text" to _pS(_uM("width" to "100%", "textAlign" to "center", "lineHeight" to "150px")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
