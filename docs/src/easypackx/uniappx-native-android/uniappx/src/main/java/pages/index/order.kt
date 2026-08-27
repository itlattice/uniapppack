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
import io.dcloud.uniapp.extapi.`$emit` as uni__emit
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
open class GenPagesIndexOrder : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            xProvitae.scrollTop = e.scrollTop
            val pages = getCurrentPages()
            if (pages.length == 0) {
                return
            }
            val page = pages[pages.length - 1].route
            uni__emit("onPageScroll", _uO("top" to e.scrollTop, "page" to page))
        }
        , __ins)
        onResize(fun(_: OnResizeOptions) {
            uni__emit("onResize", fun() {})
        }
        , __ins)
        onLoad(fun(query: OnLoadOptions) {
            xProvitae.onLoadOpts = JSON.parseObject(JSON.stringify(query)!!) ?: _uO()
            uni__emit("onLoad", fun() {})
        }
        , __ins)
        onPageHide(fun() {
            uni__emit("onHide", fun() {})
        }
        , __ins)
        onReady(fun() {
            uni__emit("onReady", fun() {})
            xProvitae.pageReady = true
        }
        , __ins)
        onPageShow(fun() {
            uni__emit("onShow", fun() {})
        }
        , __ins)
    }
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesIndexOrder) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesIndexOrder
            val _cache = __ins.renderCache
            val pageHeight = ref(100)
            val visible = ref(false)
            val NavigaHeight = ref(100)
            val keywords = ref("")
            val number = ref(0)
            val handleConfirm = fun(e: UTSArray<Number>){}
            onLoad(fun(_options){
                var window = uni_getWindowInfo()
                console.log(window)
                pageHeight.value = window.screenHeight - window.statusBarHeight - 220
                NavigaHeight.value = window.safeAreaInsets.top + 50
            }
            )
            onShow(fun(){
                common.navigationBar("#1678fd")
                setTimeout(fun(){
                    number.value = 15
                }
                , 3000)
            }
            )
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_x_order = resolveEasyComponent("x-order", GenComponentsXOrderClass)
                val _component_x_calendar = resolveEasyComponent("x-calendar", GenComponentsXCalendarClass)
                return _cE("view", _uM("class" to "order"), _uA(
                    _cE("view", _uM("class" to "background-main padding-stauts-bar native-height", "style" to _nS(_uM("height" to (unref(NavigaHeight) + "px")))), _uA(
                        _cE("view", _uM("class" to "native display-flex"), _uA(
                            _cE("view", _uM("class" to "shopname display-flex"), _uA(
                                _cE("text", _uM("class" to "name color-white text"), "总店"),
                                _cV(_component_x_iconfont, _uM("class" to "actionxia", "name" to "xiangxia", "color" to "#ffffff", "size" to "12"))
                            )),
                            _cE("view", _uM("class" to "seachinputbox display-flex background-white"), _uA(
                                _cV(_component_x_iconfont, _uM("class" to "sousuoicon", "size" to "18", "name" to "sousuo")),
                                _cE("view", _uM("class" to "searchinput"), _uA(
                                    _cE("input", _uM("type" to "text", "modelValue" to unref(keywords), "onInput" to fun(`$event`: UniInputEvent){
                                        trySetRefValue(keywords, `$event`.detail.value)
                                    }
                                    , "placeholder" to "快速检索订单/账单", "class" to "inp"), null, 40, _uA(
                                        "modelValue"
                                    ))
                                )),
                                _cE("view", _uM("class" to "chachaicon"), _uA(
                                    if (unref(keywords).length > 0) {
                                        _cV(_component_x_iconfont, _uM("key" to 0, "name" to "chacha", "class" to "chacha", "color" to "#C4C4C4", "size" to "18"))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                )),
                                _cE("view", _uM("class" to "chachaicon"), _uA(
                                    _cV(_component_x_iconfont, _uM("name" to "saoyisao", "class" to "saoyisao", "color" to "#1776FC", "size" to "18"))
                                )),
                                _cE("view", _uM("class" to "label left-border"), _uA(
                                    _cE("text", _uM("class" to "color-main text align-center"), "搜索")
                                ))
                            )),
                            _cE("view", _uM("class" to "shaixuan display-flex"), _uA(
                                _cV(_component_x_iconfont, _uM("name" to "shaixuan", "color" to "#ffffff", "size" to "16", "class" to "shaixuan")),
                                _cE("text", _uM("class" to "content color-white text"), "筛选")
                            ))
                        ))
                    ), 4),
                    _cE("view", _uM("class" to "timeargin background-white"), _uA(
                        _cE("view", _uM("class" to "dateaggin display-flex"), _uA(
                            _cE("view", _uM("class" to "date datestart display-flex"), _uA(
                                _cE("text", _uM("class" to "dcontent text align-center"), "2025-03-05"),
                                _cV(_component_x_iconfont, _uM("class" to "iconfont", "name" to "xiangxia1", "size" to "14", "color" to "#000000"))
                            )),
                            _cE("text", _uM("class" to "datecontent align-center text"), " 至 "),
                            _cE("view", _uM("class" to "date dateend display-flex"), _uA(
                                _cE("text", _uM("class" to "dcontent text align-center"), "2025-03-05"),
                                _cV(_component_x_iconfont, _uM("class" to "iconfont", "name" to "xiangxia1", "size" to "14", "color" to "#000000"))
                            ))
                        )),
                        _cE("view", _uM("class" to "dateselect display-flex"), _uA(
                            _cE("text", _uM("class" to "dateselectitem activeitem text align-center"), "今日"),
                            _cE("text", _uM("class" to "dateselectitem text align-center"), "近7日"),
                            _cE("text", _uM("class" to "dateselectitem text align-center"), "近15日"),
                            _cE("text", _uM("class" to "dateselectitem text align-center"), "近30日"),
                            _cE("text", _uM("class" to "dateselectitem text align-center"), "全部")
                        ))
                    )),
                    _cE("view", _uM("class" to "staticdata background-white display-flex"), _uA(
                        _cE("view", _uM("class" to "dataitem"), _uA(
                            _cE("text", _uM("class" to "content text align-center"), "单品数"),
                            _cE("text", _uM("class" to "number text align-center font-bold"), "24")
                        )),
                        _cE("view", _uM("class" to "dataitem"), _uA(
                            _cE("text", _uM("class" to "content text align-center"), "销售额"),
                            _cE("text", _uM("class" to "number text align-center font-bold"), "￥465414.51")
                        )),
                        _cE("view", _uM("class" to "dataitem"), _uA(
                            _cE("text", _uM("class" to "content text align-center"), "客单价"),
                            _cE("text", _uM("class" to "number text align-center font-bold"), "￥1454.51")
                        )),
                        _cE("view", _uM("class" to "dataitem"), _uA(
                            _cE("text", _uM("class" to "content text align-center"), "订单数"),
                            _cE("text", _uM("class" to "number text align-center font-bold"), "87414")
                        ))
                    )),
                    _cE("view", _uM("class" to "orderlist", "style" to _nS(_uM("height" to (unref(pageHeight) + "px")))), _uA(
                        _cE("scroll-view", _uM("scroll-y" to "true", "style" to _nS(_uM("height" to (unref(pageHeight) + "px"))), "show-scrollbar" to false), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(unref(number), fun(item, __key, __index, _cached): Any {
                                return _cE("view", _uM("class" to "orderitem background-white", "key" to item), _uA(
                                    _cE("view", _uM("class" to "order-i"), _uA(
                                        _cV(_component_x_order)
                                    ))
                                ))
                            }
                            ), 128),
                            _cE("text", _uM("class" to "empty text align-center"), "没有更多啦~"),
                            _cE("view", _uM("style" to _nS(_uM("height" to "100rpx"))), null, 4)
                        ), 4)
                    ), 4),
                    _cV(_component_x_calendar, _uM("modelValue" to unref(visible), "onUpdate:modelValue" to fun(`$event`: Boolean){
                        trySetRefValue(visible, `$event`)
                    }
                    , "type" to "range", "onConfirm" to handleConfirm), null, 8, _uA(
                        "modelValue"
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
                return _uM("native" to _uM(".order .native-height " to _uM("paddingTop" to 10)), "shopname" to _uM(".order .native-height .native " to _uM("paddingLeft" to "16rpx", "paddingTop" to 4)), "actionxia" to _uM(".order .native-height .native .shopname " to _uM("paddingTop" to 3, "paddingLeft" to "3rpx", "paddingRight" to "14rpx")), "name" to _uM(".order .native-height .native .shopname " to _uM("fontSize" to 16)), "shaixuan" to _uM(".order .native-height .native " to _uM("marginLeft" to "8rpx", "marginTop" to 4)), "content" to _uM(".order .native-height .native .shaixuan " to _uM("paddingTop" to 4, "paddingLeft" to "2rpx", "fontSize" to 16), ".order .staticdata .dataitem " to _uM("color" to "#A3A3A3", "fontSize" to 12)), "seachinputbox" to _uM(".order .native-height .native " to _uM("height" to 30, "width" to "510rpx", "borderTopLeftRadius" to 15, "borderTopRightRadius" to 15, "borderBottomRightRadius" to 15, "borderBottomLeftRadius" to 15)), "sousuoicon" to _uM(".order .native-height .native .seachinputbox " to _uM("paddingLeft" to "15rpx", "paddingTop" to 5)), "searchinput" to _uM(".order .native-height .native .seachinputbox " to _uM("height" to 55, "paddingLeft" to "10rpx")), "inp" to _uM(".order .native-height .native .seachinputbox .searchinput " to _uM("height" to 30, "width" to "270rpx", "fontSize" to 14)), "label" to _uM(".order .native-height .native .seachinputbox " to _uM("height" to 18, "marginTop" to 6, "marginLeft" to "7rpx", "width" to "80rpx", "borderLeftWidth" to 1, "borderLeftStyle" to "solid", "borderLeftColor" to "#1678fd")), "text" to _uM(".order .native-height .native .seachinputbox .label " to _uM("marginTop" to 1, "fontSize" to 14), ".order .timeargin .dateaggin .date " to _uM("fontSize" to 16)), "saoyisao" to _uM(".order .native-height .native .seachinputbox " to _uM("marginTop" to 5, "marginRight" to "5rpx")), "chacha" to _uM(".order .native-height .native .seachinputbox " to _uM("marginTop" to 5, "marginRight" to "10rpx")), "chachaicon" to _uM(".order .native-height .native .seachinputbox " to _uM("width" to "45rpx", "height" to 55)), "timeargin" to _uM(".order " to _uM("height" to 70)), "dateaggin" to _uM(".order .timeargin " to _uM("paddingTop" to "10rpx", "marginBottom" to "16rpx")), "date" to _uM(".order .timeargin .dateaggin " to _uM("width" to "50%", "paddingLeft" to "10%")), "iconfont" to _uM(".order .timeargin .dateaggin " to _uM("paddingTop" to 3, "paddingLeft" to "6rpx")), "datecontent" to _uM(".order .timeargin .dateaggin " to _uM("fontSize" to 16, "color" to "#8a8a8a")), "dateselect" to _uM(".order .timeargin " to _uM("marginLeft" to "35rpx", "marginTop" to 5)), "dateselectitem" to _uM(".order .timeargin .dateselect " to _uM("width" to "124rpx", "height" to 24, "borderTopLeftRadius" to "23.5rpx", "borderTopRightRadius" to "23.5rpx", "borderBottomRightRadius" to "23.5rpx", "borderBottomLeftRadius" to "23.5rpx", "backgroundColor" to "#FFFFFF", "borderTopWidth" to "2rpx", "borderRightWidth" to "2rpx", "borderBottomWidth" to "2rpx", "borderLeftWidth" to "2rpx", "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#D1D1D1", "borderRightColor" to "#D1D1D1", "borderBottomColor" to "#D1D1D1", "borderLeftColor" to "#D1D1D1", "marginRight" to "14rpx", "lineHeight" to "22px", "fontSize" to 13, "color" to "#666666")), "activeitem" to _uM(".order .timeargin .dateselect " to _uM("borderTopWidth" to 0, "borderRightWidth" to 0, "borderBottomWidth" to 0, "borderLeftWidth" to 0, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#000000", "borderRightColor" to "#000000", "borderBottomColor" to "#000000", "borderLeftColor" to "#000000", "backgroundColor" to "#1776FC", "lineHeight" to "47rpx", "fontSize" to 14, "color" to "#FFFFFF")), "staticdata" to _uM(".order " to _uM("height" to "104rpx", "marginTop" to "7rpx")), "dataitem" to _uM(".order .staticdata " to _uM("width" to "25%", "paddingTop" to "12rpx")), "number" to _uM(".order .staticdata .dataitem " to _uM("paddingTop" to "8rpx", "fontSize" to 14, "color" to "#FF8D1A")), "orderlist" to _uM(".order " to _uM("marginTop" to 12)), "empty" to _uM(".order .orderlist " to _uM("marginTop" to 15, "color" to "#ABABAB", "fontSize" to 14)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
