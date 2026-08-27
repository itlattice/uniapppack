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
open class GenPagesAnalysisTodayanalysis : BasePage {
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
        var setup: (__props: GenPagesAnalysisTodayanalysis) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAnalysisTodayanalysis
            val _cache = __ins.renderCache
            val chartRef = ref<TmxEchartComponentPublicInstance?>(null)
            val analysisData = ref(_uO())
            val loading = ref<UniElement?>(null)
            val hotGoodsList = ref(_uA<UTSJSONObject>())
            val getAnalysis = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        var res = await(request.callapi("analysis/todayAnalysisWeek", _uO()))
                        if (res.code == 0) {
                            chartRef.value?.setOptions?.invoke(res.data as UTSJSONObject)
                        }
                })
            }
            val getAnalysisData = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var res = await(request.callapi("analysis/todayAnalysisData", _uO()))
                        if (res.code < 0) {
                            return@w1
                        }
                        analysisData.value = res.data as UTSJSONObject
                })
            }
            val getTodayHotGoods = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var res = await(request.callapi("analysis/todayHotGoods", _uO()))
                        common.hideLoading(loading.value)
                        if (res.code < 0) {
                            return@w1
                        }
                })
            }
            onReady(fun(){
                common.loading(loading.value)
                getAnalysisData()
                getTodayHotGoods()
            }
            )
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_x_viewtitle = resolveEasyComponent("x-viewtitle", GenComponentsXViewtitleClass)
                val _component_tmx_rolling_number = resolveEasyComponent("tmx-rolling-number", GenUniModulesTmxUiComponentsTmxRollingNumberTmxRollingNumberClass)
                val _component_tmx_echart = resolveEasyComponent("tmx-echart", GenUniModulesTmxUiComponentsTmxEchartTmxEchartClass)
                val _component_x_page = resolveEasyComponent("x-page", GenComponentsXPageClass)
                val _component_x_loading = resolveEasyComponent("x-loading", GenComponentsXLoadingClass)
                return _cE("view", _uM("class" to "todayanalysis"), _uA(
                    _cV(_component_x_viewtitle, _uM("title" to "今日统计"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to "handles display-flex"), _uA(
                                _cV(_component_x_iconfont, _uM("name" to "dianpufill", "height" to 22, "size" to "15", "color" to "white")),
                                _cE("text", _uM("class" to "text"), "总店")
                            ))
                        )
                    }
                    ), "_" to 1)),
                    _cV(_component_x_page, _uM("topHeight" to 40), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to "basicdata radius-50")),
                            _cE("view", _uM("class" to "basicdatainfo"), _uA(
                                _cE("view", _uM("class" to "todayamount"), _uA(
                                    _cE("text", _uM("class" to "amountname"), "今日营业额"),
                                    _cV(_component_tmx_rolling_number, _uM("fontSize" to "28px", "enableAnimation" to true, "decimals" to 2, "font-color" to "white", "font-style" to "text-align:center;font-weight:bold;", "end-val" to unref(analysisData)["today"], "useGrouping" to true), null, 8, _uA(
                                        "end-val"
                                    ))
                                )),
                                _cE("view", _uM("class" to "amountlist display-flex"), _uA(
                                    _cE("view", _uM("class" to "amountitem"), _uA(
                                        _cE("text", _uM("class" to "align-center title"), "订单数"),
                                        _cE("view", _uM("class" to "number"), _uA(
                                            _cV(_component_tmx_rolling_number, _uM("fontSize" to "18px", "enableAnimation" to true, "font-color" to "white", "font-style" to "text-align:center;font-weight:bold;", "end-val" to unref(analysisData)["orderNum"], "useGrouping" to true), null, 8, _uA(
                                                "end-val"
                                            ))
                                        ))
                                    )),
                                    _cE("view", _uM("class" to "amountitem"), _uA(
                                        _cE("text", _uM("class" to "align-center title"), "客单价"),
                                        _cE("view", _uM("class" to "number"), _uA(
                                            _cV(_component_tmx_rolling_number, _uM("fontSize" to "18px", "enableAnimation" to true, "decimals" to 2, "font-color" to "white", "font-style" to "text-align:center;font-weight:bold;", "end-val" to unref(analysisData)["cusPrice"], "useGrouping" to true), null, 8, _uA(
                                                "end-val"
                                            ))
                                        ))
                                    )),
                                    _cE("view", _uM("class" to "amountitem"), _uA(
                                        _cE("text", _uM("class" to "align-center title"), "线上订单"),
                                        _cE("view", _uM("class" to "number"), _uA(
                                            _cV(_component_tmx_rolling_number, _uM("fontSize" to "18px", "enableAnimation" to true, "font-color" to "white", "font-style" to "text-align:center;font-weight:bold;", "end-val" to unref(analysisData)["online"], "useGrouping" to true), null, 8, _uA(
                                                "end-val"
                                            ))
                                        ))
                                    )),
                                    _cE("view", _uM("class" to "amountitem"), _uA(
                                        _cE("text", _uM("class" to "align-center title"), "顾客储值"),
                                        _cE("view", _uM("class" to "number"), _uA(
                                            _cV(_component_tmx_rolling_number, _uM("fontSize" to "18px", "enableAnimation" to true, "decimals" to 2, "font-color" to "white", "font-style" to "text-align:center;font-weight:bold;", "end-val" to unref(analysisData)["recharge"], "useGrouping" to true), null, 8, _uA(
                                                "end-val"
                                            ))
                                        ))
                                    ))
                                ))
                            )),
                            _cE("view", _uM("class" to "analysisimage datacard"), _uA(
                                _cE("text", _uM("class" to "title"), "近7日销售趋势"),
                                _cE("view", _uM("class" to "coverimg"), _uA(
                                    _cV(_component_tmx_echart, _uM("ref_key" to "chartRef", "ref" to chartRef, "onInit" to getAnalysis), null, 512)
                                ))
                            )),
                            _cE("view", _uM("class" to "hotgoods datacard"), _uA(
                                _cE("text", _uM("class" to "title"), "商品热销"),
                                _cE("view", _uM("class" to "goodslist"), _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(unref(hotGoodsList), fun(item, index, __index, _cached): Any {
                                        return _cE("view", _uM("class" to "goodsitem space-between"), _uA(
                                            _cE("view", _uM("class" to "basic display-flex"), _uA(
                                                _cE("text", _uM("class" to _nC(_uA(
                                                    "num lineheight",
                                                    "num-" + index
                                                ))), _tD(index + 1), 3),
                                                _cE("view", _uM("class" to "goodsimg"), _uA(
                                                    _cE("image", _uM("mode" to "aspectFit", "class" to "img full", "src" to item["img"]), null, 8, _uA(
                                                        "src"
                                                    ))
                                                )),
                                                _cE("text", _uM("class" to "name lineheight"), _tD(item["name"]), 1)
                                            )),
                                            _cE("text", _uM("class" to _nC(_uA(
                                                "number lineheight",
                                                "num-" + index
                                            ))), _tD(item["count"]) + _tD(item["unit"]), 3)
                                        ))
                                    }
                                    ), 256)
                                ))
                            )),
                            _cE("view", _uM("style" to _nS(_uM("height" to "50px"))), null, 4)
                        )
                    }
                    ), "_" to 1)),
                    _cV(_component_x_loading, _uM("ref_key" to "loading", "ref" to loading), null, 512)
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
                return _uM("text" to _uM(".handles " to _uM("fontSize" to 14, "color" to "#FFFFFF", "paddingLeft" to 8)), "basicdata" to _pS(_uM("width" to "1400rpx", "height" to "1400rpx", "backgroundImage" to "none", "backgroundColor" to "#1678fd", "marginLeft" to "-325rpx", "marginTop" to "-876rpx", "zIndex" to -1)), "basicdatainfo" to _pS(_uM("marginTop" to "-520rpx")), "amountname" to _uM(".basicdatainfo " to _uM("textAlign" to "center", "color" to "#FFFFFF", "fontSize" to 12, "marginBottom" to 4)), "amountlist" to _uM(".basicdatainfo " to _uM("marginLeft" to 16, "marginTop" to 30)), "amountitem" to _uM(".basicdatainfo .amountlist " to _uM("width" to "174rpx")), "title" to _uM(".basicdatainfo .amountlist .amountitem " to _uM("color" to "#FFFFFF", "fontSize" to 11, "marginBottom" to 4), ".analysisimage " to _uM("paddingLeft" to "26rpx", "paddingTop" to 10, "fontSize" to 11, "color" to "#000000"), ".hotgoods " to _uM("paddingLeft" to "26rpx", "paddingTop" to 10, "fontSize" to 11, "color" to "#000000")), "datacard" to _pS(_uM("width" to "700rpx", "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "borderBottomRightRadius" to 10, "borderBottomLeftRadius" to 10, "backgroundImage" to "none", "backgroundColor" to "#FFFFFF", "marginLeft" to "25rpx")), "analysisimage" to _pS(_uM("height" to 230, "marginTop" to 22)), "coverimg" to _uM(".analysisimage " to _uM("marginLeft" to "25rpx", "width" to "650rpx", "marginTop" to "23rpx", "height" to 200)), "hotgoods" to _pS(_uM("marginTop" to 14)), "goodslist" to _uM(".hotgoods " to _uM("marginTop" to 17)), "goodsitem" to _uM(".hotgoods .goodslist " to _uM("paddingLeft" to "26rpx", "paddingRight" to "25rpx", "height" to 35, "marginBottom" to 11)), "lineheight" to _uM(".hotgoods .goodslist .goodsitem " to _uM("lineHeight" to "35px")), "number" to _uM(".hotgoods .goodslist .goodsitem " to _uM("color" to "#000000", "fontSize" to 14)), "num" to _uM(".hotgoods .goodslist .goodsitem .basic " to _uM("color" to "#8C8C8C", "fontSize" to 14)), "name" to _uM(".hotgoods .goodslist .goodsitem .basic " to _uM("marginLeft" to "17rpx", "color" to "#000000", "fontSize" to 14)), "goodsimg" to _uM(".hotgoods .goodslist .goodsitem .basic " to _uM("marginLeft" to "17rpx", "width" to 35, "height" to 35)), "img" to _uM(".hotgoods .goodslist .goodsitem .basic .goodsimg " to _uM("width" to 35, "height" to 35)), "num-0" to _uM(".hotgoods .goodslist .goodsitem .basic " to _uM("color" to "#FF0000"), ".hotgoods .goodslist .goodsitem " to _uM("color" to "#FF0000")), "num-1" to _uM(".hotgoods .goodslist .goodsitem .basic " to _uM("color" to "#FF5500"), ".hotgoods .goodslist .goodsitem " to _uM("color" to "#FF5500")), "num-2" to _uM(".hotgoods .goodslist .goodsitem .basic " to _uM("color" to "#FF8400"), ".hotgoods .goodslist .goodsitem " to _uM("color" to "#FF8400")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
