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
open class GenPagesTemplateSwiperList2SwiperList2 : BasePage {
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
        var setup: (__props: GenPagesTemplateSwiperList2SwiperList2) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesTemplateSwiperList2SwiperList2
            val _cache = __ins.renderCache
            fun gen_lerpNumber_fn(value1: Number, value2: Number, amount: Number): Number {
                return (value1 + (value2 - value1) * amount)
            }
            val lerpNumber = ::gen_lerpNumber_fn
            val swiperList = ref(_uA<SwiperViewItem__2>())
            val swiperIndex = ref(0)
            val tabScroll = ref<UniScrollViewElement?>(null)
            val swipertab = ref<UTSArray<UniTextElement>?>(null)
            val swiper = ref<UniSwiperElement?>(null)
            var animationFinishIndex: Number = 0
            var swiperWidth: Number = 0
            fun gen_updateTabIndicator_fn(current_index: Number, move_to_index: Number, percentage: Number) {
                if (percentage == 0) {
                    return
                }
                val min_ratio: Number = 1
                val max_ratio: Number = 1.3
                val tabs = swipertab.value as UTSArray<UniTextElement>
                val current_node = tabs[current_index]
                val move_to_node = tabs[move_to_index]
                val current_scale = lerpNumber(min_ratio, max_ratio, 1 - percentage)
                current_node.style.setProperty("transform", "scale(" + current_scale + ")")
                val move_to_scale = lerpNumber(min_ratio, max_ratio, percentage)
                move_to_node.style.setProperty("transform", "scale(" + move_to_scale + ")")
                val target_x = lerpNumber(current_node.offsetLeft, move_to_node.offsetLeft, percentage)
                val center_x = target_x + move_to_node.offsetWidth / 2 - swiperWidth / 2
                tabScroll.value!!.scrollLeft = center_x
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
                val current_offset_x = offset_x % swiperWidth
                val current_offset_i = offset_x / swiperWidth
                val current_index = animationFinishIndex + parseInt(current_offset_i + "")
                var move_to_index = current_index
                if (current_offset_x > 0 && move_to_index < swiperList.value.length - 1) {
                    move_to_index += 1
                } else if (current_offset_x < 0 && move_to_index > 0) {
                    move_to_index -= 1
                }
                val percentage = Math.abs(current_offset_x) / swiperWidth
                if (current_index != move_to_index) {
                    updateTabIndicator(current_index, move_to_index, percentage)
                }
            }
            val onSwiperTransition = ::gen_onSwiperTransition_fn
            fun gen_onSwiperAnimationfinish_fn(e: SwiperAnimationFinishEvent) {
                setSwiperIndex(e.detail.current, true)
                animationFinishIndex = e.detail.current
            }
            val onSwiperAnimationfinish = ::gen_onSwiperAnimationfinish_fn
            onLoad(fun(_options){
                run {
                    var i: Number = 0
                    while(i < 4){
                        swiperList.value.push(SwiperViewItem__2(title = "Tab " + i))
                        i++
                    }
                }
            }
            )
            onReady(fun(){
                (swiper.value as UniSwiperElement).getBoundingClientRectAsync()!!.then(fun(res: DOMRect){
                    swiperWidth = res.width
                    updateTabIndicator(swiperIndex.value, swiperIndex.value, 1)
                }
                )
            }
            )
            return fun(): Any? {
                return _cE("view", _uM("class" to "swiper-list"), _uA(
                    _cE("scroll-view", _uM("ref_key" to "tabScroll", "ref" to tabScroll, "class" to "swiper-tabs", "direction" to "horizontal", "show-scrollbar" to false), _uA(
                        _cE("view", _uM("class" to "flex-row", "style" to _nS(_uM("align-self" to "flex-start"))), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(unref(swiperList), fun(item, index, __index, _cached): Any {
                                return _cE("text", _uM("ref_for" to true, "ref_key" to "swipertab", "ref" to swipertab, "class" to _nC(_uA(
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
                        ), 4)
                    ), 512),
                    _cE("swiper", _uM("ref_key" to "swiper", "ref" to swiper, "class" to "swiper-view", "current" to unref(swiperIndex), "onTransition" to onSwiperTransition, "onAnimationfinish" to onSwiperAnimationfinish), _uA(
                        _cE(Fragment, null, RenderHelpers.renderList(unref(swiperList), fun(_, index, __index, _cached): Any {
                            return _cE("swiper-item", _uM("class" to "swiper-item", "key" to index), _uA(
                                _cE("text", _uM("class" to "swiper-item-text"), _tD(index), 1)
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
                return _uM("flex-row" to _pS(_uM("flexDirection" to "row")), "swiper-list" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "swiper-tabs-item" to _pS(_uM("color" to "#555555", "fontSize" to 16, "marginTop" to 15, "marginRight" to 25, "marginBottom" to 5, "marginLeft" to 25, "whiteSpace" to "nowrap")), "swiper-tabs-item-active" to _pS(_uM("color" to "#000000")), "swiper-view" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "swiper-item" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "alignItems" to "center", "justifyContent" to "center")), "swiper-item-text" to _pS(_uM("fontSize" to 72, "fontWeight" to "bold")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
