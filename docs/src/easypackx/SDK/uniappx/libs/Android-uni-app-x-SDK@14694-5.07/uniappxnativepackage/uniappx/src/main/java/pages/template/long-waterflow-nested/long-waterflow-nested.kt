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
import io.dcloud.uniapp.extapi.stopPullDownRefresh as uni_stopPullDownRefresh
open class GenPagesTemplateLongWaterflowNestedLongWaterflowNested : BasePage {
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
        var setup: (__props: GenPagesTemplateLongWaterflowNestedLongWaterflowNested) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesTemplateLongWaterflowNestedLongWaterflowNested
            val _cache = __ins.renderCache
            fun gen_lerpNumber_fn(value1: Number, value2: Number, amount: Number): Number {
                return (value1 + (value2 - value1) * amount)
            }
            val lerpNumber = ::gen_lerpNumber_fn
            val swiperList = ref(_uA<SwiperViewItem__6>(SwiperViewItem__6(type = "UpdatedDate", name = "最新上架", id = "list-id-1", preload = true), SwiperViewItem__6(type = "FreeHot", name = "免费热榜", id = "list-id-2", preload = false), SwiperViewItem__6(type = "PaymentHot", name = "付费热榜", id = "list-id-3", preload = false), SwiperViewItem__6(type = "HotList", name = "热门总榜", id = "list-id-4", preload = false)))
            val swiperIndex = ref(0)
            val pageScrollView = ref<UniScrollViewElement?>(null)
            var headerHeight: Number = 0
            var animationFinishIndex: Number = 0
            val tabScrollView = ref<UniScrollViewElement?>(null)
            val indicatorNode = ref<UniElement?>(null)
            var swiperWidth: Number = 0
            var swiperTabsRect: UTSArray<SwiperTabsItem__5> = _uA()
            var nestedScrollChildId = ""
            val header = ref<UniSwiperElement?>(null)
            val swipertab = ref(_uA<UniElement>())
            val swiper = ref<UniSwiperElement?>(null)
            val longPageRef = ref(_uA<ComponentPublicInstance>())
            fun gen_cacheTabItemsSize_fn() {
                swiperTabsRect.length = 0
                swipertab.value.forEach(fun(node){
                    swiperTabsRect.push(SwiperTabsItem__5(x = node.offsetLeft, w = node.offsetWidth))
                }
                )
            }
            val cacheTabItemsSize = ::gen_cacheTabItemsSize_fn
            fun gen_initSwiperItemData_fn(index: Number) {
                if (!swiperList.value[index].preload) {
                    swiperList.value[index].preload = true
                    longPageRef.value[index].`$callMethod`("loadData", null)
                }
                nestedScrollChildId = swiperList.value[index].id
            }
            val initSwiperItemData = ::gen_initSwiperItemData_fn
            fun gen_updateTabIndicator_fn(current_index: Number, move_to_index: Number, percentage: Number) {
                val current_size = swiperTabsRect[current_index]
                val move_to_size = swiperTabsRect[move_to_index]
                val indicator_line_x = lerpNumber(current_size.x, move_to_size.x, percentage)
                val indicator_line_w = lerpNumber(current_size.w, move_to_size.w, percentage)
                val x = indicator_line_x + indicator_line_w / 2
                indicatorNode.value?.style?.setProperty("transform", "translateX(" + x + "px) scaleX(" + indicator_line_w + ")")
                val scroll_x = x - swiperWidth / 2
                if (tabScrollView.value != null) {
                    tabScrollView.value!!.scrollLeft = scroll_x
                }
            }
            val updateTabIndicator = ::gen_updateTabIndicator_fn
            fun gen_setSwiperIndex_fn(index: Number, updateIndicator: Boolean) {
                if (swiperIndex.value === index) {
                    return
                }
                swiperIndex.value = index
                initSwiperItemData(index)
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
                initSwiperItemData(move_to_index)
            }
            val onSwiperTransition = ::gen_onSwiperTransition_fn
            fun gen_onSwiperAnimationfinish_fn(e: SwiperAnimationFinishEvent) {
                setSwiperIndex(e.detail.current, true)
                animationFinishIndex = e.detail.current
            }
            val onSwiperAnimationfinish = ::gen_onSwiperAnimationfinish_fn
            onReady(fun(){
                headerHeight = header.value!!.offsetHeight
                swiperWidth = swiper.value!!.getBoundingClientRect().width
                cacheTabItemsSize()
                updateTabIndicator(swiperIndex.value, swiperIndex.value, 1)
            }
            )
            onPullDownRefresh(fun(){
                longPageRef.value[swiperIndex.value].`$callMethod`("refreshData", fun(){
                    uni_stopPullDownRefresh()
                }
                )
            }
            )
            return fun(): Any? {
                return _cE("scroll-view", _uM("ref_key" to "pageScrollView", "ref" to pageScrollView, "class" to "page", "bounces" to false, "type" to "nested"), _uA(
                    _cE("nested-scroll-header", null, _uA(
                        _cE("swiper", _uM("ref_key" to "header", "ref" to header, "indicator-dots" to "true", "circular" to "true"), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(3, fun(i, __key, __index, _cached): Any {
                                return _cE("swiper-item", _uM("item-id" to i), _uA(
                                    _cE("image", _uM("src" to "/static/shuijiao.jpg", "style" to _nS(_uM("width" to "100%", "height" to "240px"))), null, 4),
                                    _cE("text", _uM("style" to _nS(_uM("position" to "absolute"))), _tD(i), 5)
                                ), 8, _uA(
                                    "item-id"
                                ))
                            }
                            ), 64)
                        ), 512)
                    )),
                    _cE("nested-scroll-body", _uM("style" to _nS(_uM("height" to "100%"))), _uA(
                        _cE("view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                            _cE("scroll-view", _uM("ref_key" to "tabScrollView", "ref" to tabScrollView, "class" to "swiper-tabs", "direction" to "horizontal", "show-scrollbar" to false), _uA(
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
                                        ), _tD(item.name), 11, _uA(
                                            "onClick"
                                        ))
                                    }
                                    ), 128)
                                ), 4),
                                _cE("view", _uM("ref_key" to "indicatorNode", "ref" to indicatorNode, "class" to "swiper-tabs-indicator"), null, 512)
                            ), 512),
                            _cE("swiper", _uM("ref_key" to "swiper", "ref" to swiper, "class" to "swiper-view", "current" to unref(swiperIndex), "onTransition" to onSwiperTransition, "onAnimationfinish" to onSwiperAnimationfinish), _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(unref(swiperList), fun(item, index, __index, _cached): Any {
                                    return _cE("swiper-item", _uM("class" to "swiper-item", "key" to index), _uA(
                                        _cV(unref(GenPagesTemplateLongWaterflowNestedLongWaterflowPageClass), _uM("ref_for" to true, "ref_key" to "longPageRef", "ref" to longPageRef, "id" to item.id, "type" to item.type, "preload" to item.preload), null, 8, _uA(
                                            "id",
                                            "type",
                                            "preload"
                                        ))
                                    ))
                                }
                                ), 128)
                            ), 40, _uA(
                                "current"
                            ))
                        ), 4)
                    ), 4)
                ), 512)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("flex-row" to _pS(_uM("flexDirection" to "row")), "page" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "search-bar" to _pS(_uM("paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10)), "swiper-list" to _pS(_uM("height" to "100%")), "swiper-tabs" to _pS(_uM("backgroundColor" to "#ffffff", "flexDirection" to "column")), "swiper-tabs-item" to _pS(_uM("color" to "#555555", "fontSize" to 16, "paddingTop" to 12, "paddingRight" to 25, "paddingBottom" to 12, "paddingLeft" to 25, "whiteSpace" to "nowrap")), "swiper-tabs-item-active" to _pS(_uM("color" to "#007AFF")), "swiper-tabs-indicator" to _pS(_uM("width" to 1, "height" to 2, "backgroundColor" to "#007AFF")), "swiper-view" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "swiper-item" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
