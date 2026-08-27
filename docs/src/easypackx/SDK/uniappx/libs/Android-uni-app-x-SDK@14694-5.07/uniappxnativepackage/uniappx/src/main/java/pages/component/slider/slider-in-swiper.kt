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
open class GenPagesComponentSliderSliderInSwiper : BasePage {
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
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentSliderSliderInSwiper) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentSliderSliderInSwiper
            val _cache = __ins.renderCache
            fun gen_lerpNumber_fn(value1: Number, value2: Number, amount: Number): Number {
                return (value1 + (value2 - value1) * amount)
            }
            val lerpNumber = ::gen_lerpNumber_fn
            val swiperList = ref(_uA<SwiperViewItem>())
            val swiperIndex = ref(0)
            val tabScroll = ref<UniElement?>(null)
            val indicator = ref<UniElement?>(null)
            val swiper = ref<UniElement?>(null)
            val animationFinishIndex = ref(0)
            val swiperWidth = ref(0)
            val swiperTabsRect = ref(_uA<SwiperTabsItem>())
            val swiperTabRefs = ref(_uA<UniElement>())
            val sliderValue = ref(50)
            val sliderBlockSize = ref(20)
            val sliderBackgroundColor = ref("#000000")
            val sliderActiveColor = ref("#FFCC33")
            val sliderBlockColor = ref("#8A6DE9")
            fun gen_setSwiperTabRef_fn(el: UniElement?) {
                if (el != null) {
                    swiperTabRefs.value.push(el)
                }
            }
            val setSwiperTabRef = ::gen_setSwiperTabRef_fn
            fun gen_updateTabIndicator_fn(current_index: Number, move_to_index: Number, percentage: Number) {
                if (current_index < 0 || current_index >= swiperTabsRect.value.length || move_to_index < 0 || move_to_index >= swiperTabsRect.value.length) {
                    return
                }
                val current_size = swiperTabsRect.value[current_index]
                val move_to_size = swiperTabsRect.value[move_to_index]
                val indicator_line_x = lerpNumber(current_size.x, move_to_size.x, percentage)
                val indicator_line_w = lerpNumber(current_size.w, move_to_size.w, percentage)
                val x = indicator_line_x + indicator_line_w / 2
                indicator.value?.style?.setProperty("transform", "translateX(" + x + "px) scaleX(" + indicator_line_w + ")")
                val scroll_x = x - swiperWidth.value / 2
                if (tabScroll.value != null) {
                    tabScroll.value!!.scrollLeft = scroll_x
                }
            }
            val updateTabIndicator = ::gen_updateTabIndicator_fn
            fun gen_setSwiperIndex_fn(index: Number, updateIndicator: Boolean) {
                if (swiperIndex.value === index) {
                    return
                }
                swiperIndex.value = index
                if (updateIndicator) {
                    updateTabIndicator(index, index, 1)
                }
            }
            val setSwiperIndex = ::gen_setSwiperIndex_fn
            fun gen_onTabClick_fn(index: Number) {
                setSwiperIndex(index, false)
            }
            val onTabClick = ::gen_onTabClick_fn
            fun gen_onSwiperTransition_fn(e: SwiperTransitionEvent) {
                val offset_x = e.detail.dx
                val current_offset_x = offset_x % swiperWidth.value
                val current_offset_i = offset_x / swiperWidth.value
                val current_index = animationFinishIndex.value + parseInt(current_offset_i + "")
                var move_to_index = current_index
                if (current_offset_x > 0 && move_to_index < swiperList.value.length - 1) {
                    move_to_index += 1
                } else if (current_offset_x < 0 && move_to_index > 0) {
                    move_to_index -= 1
                }
                val percentage = Math.abs(current_offset_x) / swiperWidth.value
                if (current_index != move_to_index) {
                    updateTabIndicator(current_index, move_to_index, percentage)
                }
            }
            val onSwiperTransition = ::gen_onSwiperTransition_fn
            fun gen_onSwiperAnimationfinish_fn(e: SwiperAnimationFinishEvent) {
                setSwiperIndex(e.detail.current, true)
                animationFinishIndex.value = e.detail.current
            }
            val onSwiperAnimationfinish = ::gen_onSwiperAnimationfinish_fn
            fun gen_cacheTabItemsSize_fn(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        swiperTabsRect.value.length = 0
                        val tabs = swiperTabRefs.value
                        run {
                            var i: Number = 0
                            while(i < tabs.length){
                                val element = tabs[i]
                                val x = element.offsetLeft
                                val w = element.offsetWidth
                                swiperTabsRect.value.push(SwiperTabsItem(x = x, w = w))
                                i++
                            }
                        }
                })
            }
            val cacheTabItemsSize = ::gen_cacheTabItemsSize_fn
            onBeforeUpdate(fun(){
                swiperTabRefs.value = _uA()
            }
            )
            onLoad(fun(_options){
                run {
                    var i: Number = 0
                    while(i < 3){
                        val space = " ".repeat(i)
                        swiperList.value.push(SwiperViewItem(title = "Tab " + space + i))
                        i++
                    }
                }
            }
            )
            onReady(fun(){
                if (swiper.value != null) {
                    swiper.value!!.getBoundingClientRectAsync()!!.then(fun(res: DOMRect): UTSPromise<Unit> {
                        swiperWidth.value = res.width
                        return cacheTabItemsSize()
                    }
                    ).then(fun(){
                        if (swiperTabsRect.value.length > 0) {
                            updateTabIndicator(swiperIndex.value, swiperIndex.value, 1)
                        }
                    }
                    )
                }
            }
            )
            return fun(): Any? {
                val _component_slider = resolveComponent("slider")
                return _cE("view", _uM("class" to "swiper-list"), _uA(
                    _cE("scroll-view", _uM("ref_key" to "tabScroll", "ref" to tabScroll, "class" to "swiper-tabs", "direction" to "horizontal", "show-scrollbar" to false), _uA(
                        _cE("view", _uM("class" to "flex-row"), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(unref(swiperList), fun(item, index, __index, _cached): Any {
                                return _cE("text", _uM("ref_for" to true, "ref" to setSwiperTabRef, "class" to _nC(_uA(
                                    "swiper-tabs-item",
                                    if (unref(swiperIndex) == index) {
                                        "swiper-tabs-item-active"
                                    } else {
                                        ""
                                    }
                                )), "key" to index, "onClick" to fun(){
                                    onTabClick(index)
                                }
                                ), _tD(item.title), 11, _uA(
                                    "onClick"
                                ))
                            }
                            ), 128)
                        )),
                        _cE("view", _uM("ref_key" to "indicator", "ref" to indicator, "class" to "swiper-tabs-indicator"), null, 512)
                    ), 512),
                    _cE("swiper", _uM("ref_key" to "swiper", "ref" to swiper, "class" to "swiper-view", "current" to unref(swiperIndex), "onTransition" to onSwiperTransition, "onAnimationfinish" to onSwiperAnimationfinish), _uA(
                        _cE(Fragment, null, RenderHelpers.renderList(unref(swiperList), fun(_, index, __index, _cached): Any {
                            return _cE("swiper-item", _uM("class" to "swiper-item", "key" to index), _uA(
                                _cE("text", _uM("class" to "uni-title"), "显示当前value"),
                                _cV(_component_slider, _uM("value" to 50, "show-value" to true)),
                                _cE("text", _uM("class" to "uni-title"), "设置步进:step=10跳动"),
                                _cV(_component_slider, _uM("value" to 60, "step" to 10)),
                                _cE("text", _uM("class" to "uni-title"), "浮点步进:step=0.01跳动"),
                                _cV(_component_slider, _uM("value" to 0.5, "min" to 0, "max" to 1, "step" to 0.01, "show-value" to true)),
                                _cE("text", _uM("class" to "uni-title"), "设置最小/最大值"),
                                _cV(_component_slider, _uM("value" to 100, "min" to 50, "max" to 200, "show-value" to true)),
                                _cE("text", _uM("class" to "uni-title"), "不同颜色和大小的滑块"),
                                _cV(_component_slider, _uM("id" to "slider-custom-color-and-size", "value" to unref(sliderValue), "backgroundColor" to unref(sliderBackgroundColor), "activeColor" to unref(sliderActiveColor), "activeBackgroundColor" to unref(sliderActiveColor), "blockColor" to unref(sliderBlockColor), "foreColor" to unref(sliderBlockColor), "block-size" to unref(sliderBlockSize), "track-active-class" to "track-active-class", "track-class" to "track-class", "thumb-class" to "thumb-class"), null, 8, _uA(
                                    "value",
                                    "backgroundColor",
                                    "activeColor",
                                    "activeBackgroundColor",
                                    "blockColor",
                                    "foreColor",
                                    "block-size"
                                ))
                            ))
                        }
                        ), 128)
                    ), 40, _uA(
                        "current"
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
                return _uM("flex-row" to _pS(_uM("flexDirection" to "row", "alignSelf" to "flex-start")), "swiper-list" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "swiper-tabs" to _pS(_uM("backgroundColor" to "#ffffff")), "swiper-tabs-item" to _pS(_uM("color" to "#555555", "fontSize" to 16, "paddingTop" to 12, "paddingRight" to 25, "paddingBottom" to 12, "paddingLeft" to 25, "whiteSpace" to "nowrap")), "swiper-tabs-item-active" to _pS(_uM("color" to "#007AFF")), "swiper-tabs-indicator" to _pS(_uM("width" to 1, "height" to 2, "backgroundColor" to "#007AFF")), "swiper-view" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "swiper-item" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15)), "track-class" to _pS(_uM("backgroundColor" to "#000000")), "track-active-class" to _pS(_uM("backgroundColor" to "#FFCC33")), "thumb-class" to _pS(_uM("width" to 20, "height" to 20, "backgroundColor" to "#8A6DE9", "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "borderBottomRightRadius" to 10, "borderBottomLeftRadius" to 10)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
