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
open class GenPagesGoodsQuery : BasePage {
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
        var setup: (__props: GenPagesGoodsQuery) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesGoodsQuery
            val _cache = __ins.renderCache
            val NavigaHeight = ref(0)
            val pageHeight = ref(0)
            val back = fun(){
                common.back()
            }
            onLoad(fun(_options){
                var window = uni_getWindowInfo()
                console.log(window)
                pageHeight.value = window.screenHeight - window.statusBarHeight - 150
                NavigaHeight.value = window.safeAreaInsets.top + 50
            }
            )
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                return _cE("view", null, _uA(
                    _cE("view", _uM("class" to "navigat padding-stauts-bar display-flex background-white", "style" to _nS(_uM("height" to (unref(NavigaHeight) + "px")))), _uA(
                        _cV(_component_x_iconfont, _uM("class" to "fanhui", "name" to "fanhui", "size" to "20", "color" to "#000000", "onClick" to back)),
                        _cE("view", _uM("class" to "searchbox display-flex"), _uA(
                            _cV(_component_x_iconfont, _uM("class" to "saoyisao", "name" to "saoyisao", "size" to "16", "color" to "#C4C4C4")),
                            _cE("input", _uM("class" to "inputbox", "placeholder" to "商品条码"))
                        ))
                    ), 4),
                    _cE("view", _uM("class" to "result"), _uA(
                        _cE("view", _uM("class" to "query-result background-white", "style" to _nS(_uM("height" to (unref(pageHeight) + "px")))), _uA(
                            _cE("view", _uM("class" to "basicinfo display-flex position-relative"), _uA(
                                _cE("image", _uM("class" to "img", "src" to "https://img.js.design/assets/smartFill/img394164da755928.jpeg")),
                                _cE("view", _uM("class" to "info"), _uA(
                                    _cE("text", _uM("class" to "name"), "商品每次商品每次商品每次商品每次商品每次商品每次商品每次商品每次"),
                                    _cE("view", _uM("class" to "priceinfo space-between"), _uA(
                                        _cE("text", _uM("class" to "guige"), "规格：5Kg"),
                                        _cE("view", _uM("class" to "price display-flex"), _uA(
                                            _cE("text", _uM("class" to "f"), "￥"),
                                            _cE("text", _uM("class" to "color-red font-bold number"), "50.00"),
                                            _cE("text", _uM("class" to "f"), "/份")
                                        ))
                                    ))
                                ))
                            )),
                            _cE("view", _uM("class" to "lineitem space-between"), _uA(
                                _cE("text", _uM("class" to "title"), "计费方式"),
                                _cE("text", _uM("class" to "content"), "按件计费")
                            )),
                            _cE("view", _uM("class" to "lineitem space-between"), _uA(
                                _cE("text", _uM("class" to "title"), "计费方式"),
                                _cE("text", _uM("class" to "content"), "按件计费")
                            )),
                            _cE("view", _uM("class" to "lineitem space-between"), _uA(
                                _cE("text", _uM("class" to "title"), "计费方式"),
                                _cE("text", _uM("class" to "content"), "按件计费")
                            ))
                        ), 4),
                        _cE("view", _uM("class" to "bottombtn background-main width-full"), _uA(
                            _cE("text", _uM("class" to "content color-white align-center"), "打印商品标签")
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
                return _uM("navigat" to _pS(_uM("paddingLeft" to "20rpx")), "fanhui" to _uM(".navigat " to _uM("paddingTop" to 14)), "searchbox" to _uM(".navigat " to _uM("marginLeft" to "20rpx", "width" to "650rpx", "marginTop" to 8, "height" to 35, "borderTopLeftRadius" to 17.5, "borderTopRightRadius" to 17.5, "borderBottomRightRadius" to 17.5, "borderBottomLeftRadius" to 17.5, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#D9D9D9", "borderRightColor" to "#D9D9D9", "borderBottomColor" to "#D9D9D9", "borderLeftColor" to "#D9D9D9")), "saoyisao" to _uM(".navigat .searchbox " to _uM("lineHeight" to "33px", "paddingTop" to 8, "paddingLeft" to "17rpx")), "inputbox" to _uM(".navigat .searchbox " to _uM("width" to "616rpx", "marginLeft" to "17rpx", "fontSize" to 14)), "img" to _uM(".start " to _uM("marginTop" to "30%"), ".result .query-result .basicinfo " to _uM("width" to "200rpx", "height" to "200rpx", "borderTopLeftRadius" to 5, "borderTopRightRadius" to 5, "borderBottomRightRadius" to 5, "borderBottomLeftRadius" to 5)), "full" to _uM(".start .img " to _uM("width" to "334rpx", "height" to "334rpx")), "content" to _uM(".start " to _uM("marginTop" to 29, "fontSize" to 14, "color" to "#8F8F8F"), ".result .query-result .lineitem " to _uM("lineHeight" to "36px", "fontSize" to 14, "color" to "#000000", "fontWeight" to "bold"), ".result .bottombtn " to _uM("lineHeight" to "52px", "fontSize" to 19)), "query-result" to _uM(".result " to _uM("marginTop" to 10, "paddingLeft" to "38rpx", "paddingRight" to "38rpx", "paddingTop" to 21)), "lineitem" to _uM(".result .query-result " to _uM("height" to 36, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#f5f5f5")), "title" to _uM(".result .query-result .lineitem " to _uM("fontSize" to 14, "lineHeight" to "36px", "color" to "#404040")), "basicinfo" to _uM(".result .query-result " to _uM("paddingBottom" to 15, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#f5f5f5")), "info" to _uM(".result .query-result .basicinfo " to _uM("paddingLeft" to "31rpx")), "name" to _uM(".result .query-result .basicinfo .info " to _uM("fontSize" to 14, "width" to "440rpx")), "priceinfo" to _uM(".result .query-result .basicinfo .info " to _uM("position" to "absolute", "bottom" to 0, "right" to 0, "width" to "440rpx")), "guige" to _uM(".result .query-result .basicinfo .info .priceinfo " to _uM("fontSize" to 11, "lineHeight" to "30px")), "f" to _uM(".result .query-result .basicinfo .info .priceinfo .price " to _uM("fontSize" to 11, "lineHeight" to "30px")), "number" to _uM(".result .query-result .basicinfo .info .priceinfo .price " to _uM("fontSize" to 20)), "bottombtn" to _uM(".result " to _uM("width" to "750rpx", "height" to 52, "backgroundImage" to "none", "backgroundColor" to "#1776FC", "position" to "fixed", "bottom" to 0, "left" to 0, "paddingBottom" to "var(--uni-safe-area-inset-bottom)")), "actions" to _uM(".result " to _uM("bottom" to 100, "right" to "23rpx")), "action" to _uM(".result .actions " to _uM("width" to 52, "height" to 52, "borderTopLeftRadius" to 26, "borderTopRightRadius" to 26, "borderBottomRightRadius" to 26, "borderBottomLeftRadius" to 26)), "icon" to _uM(".result .actions .action " to _uM("paddingTop" to 13)), "haibao" to _uM(".result .actions " to _uM("backgroundImage" to "none", "backgroundColor" to "#43CF7C", "marginTop" to 11)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
