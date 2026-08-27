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
open class GenPagesGoodsView : BasePage {
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
        var setup: (__props: GenPagesGoodsView) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesGoodsView
            val _cache = __ins.renderCache
            val goodsID = ref(0)
            val topTab = ref("data")
            val stockAnalysis = ref<UniElement?>(null)
            val saleAnalysis = ref<UniElement?>(null)
            val topTabs = ref(_uA<TABS_ITEM_INFO>(TABS_ITEM_INFO(title = "数据", id = "data"), TABS_ITEM_INFO(title = "详情", id = "view")))
            val analysisTab = ref("stock")
            val analysisTabs = ref(_uA<TABS_ITEM_INFO>(TABS_ITEM_INFO(title = "库存统计", id = "stock"), TABS_ITEM_INFO(title = "销售统计", id = "sale")))
            val topTabChange = fun(item: TABS_ITEM){
                console.log("topTabChange", item)
                topTab.value = item.id as String
            }
            onLoad(fun(options){
                goodsID.value = UTSNumber.from(options["id"] as String) as Number
            }
            )
            return fun(): Any? {
                val _component_tmx_tabs = resolveEasyComponent("tmx-tabs", GenUniModulesTmxUiComponentsTmxTabsTmxTabsClass)
                val _component_x_view_title_action = resolveEasyComponent("x-view-title-action", GenComponentsXViewTitleActionClass)
                val _component_tmx_echart = resolveEasyComponent("tmx-echart", GenUniModulesTmxUiComponentsTmxEchartTmxEchartClass)
                val _component_x_page = resolveEasyComponent("x-page", GenComponentsXPageClass)
                return _cE("view", _uM("class" to "goodsview"), _uA(
                    _cV(_component_x_view_title_action, null, _uM("center" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to "tabs"), _uA(
                                _cV(_component_tmx_tabs, _uM("list" to unref(topTabs), "modelValue" to unref(topTab), "onUpdate:modelValue" to fun(`$event`: String){
                                    trySetRefValue(topTab, `$event`)
                                }
                                , "height" to "30", "color" to "transparent", "fontSize" to "13", "activeFontSize" to "14", "activeTitleColor" to "white", "titleColor" to "#ffffff8f", "onChange" to topTabChange), null, 8, _uA(
                                    "list",
                                    "modelValue"
                                ))
                            ))
                        )
                    }
                    ), "_" to 1)),
                    _cV(_component_x_page, _uM("topHeight" to 40), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            if (unref(topTab) == "data") {
                                _cE("view", _uM("key" to 0, "class" to "datapage"), _uA(
                                    _cE("view", _uM("class" to "goodsdata display-flex"), _uA(
                                        _cE("view", _uM("class" to "goodsimg"), _uA(
                                            _cE("image", _uM("src" to "https://cdn.itgz8.com/logo.png", "mode" to "aspectFit", "class" to "img"))
                                        )),
                                        _cE("view", _uM("class" to "goodsinfo"), _uA(
                                            _cE("text", _uM("class" to "name overline2"), "商品名称商品名称商品名称商品名称商品名称商品名称商品名称"),
                                            _cE("text", _uM("class" to "infodata"), _uA(
                                                "零售价：",
                                                _cE("text", _uM("class" to "pricenumber"), "￥100.00")
                                            )),
                                            _cE("text", _uM("class" to "infodata"), "分类：食品 > 小零食")
                                        ))
                                    )),
                                    _cE("view", _uM("class" to "analysisdata"), _uA(
                                        _cV(_component_tmx_tabs, _uM("list" to unref(analysisTabs), "modelValue" to unref(analysisTab), "onUpdate:modelValue" to fun(`$event`: String){
                                            trySetRefValue(analysisTab, `$event`)
                                        }), null, 8, _uA(
                                            "list",
                                            "modelValue"
                                        )),
                                        _cE("view", _uM("class" to "analysispage"), _uA(
                                            if (unref(analysisTab) == "stock") {
                                                _cE("view", _uM("key" to 0, "class" to "stock background-white"), _uA(
                                                    _cE("view", _uM("class" to "data"), _uA(
                                                        _cE("text", _uM("class" to "title"), _uA(
                                                            "店内库存：",
                                                            _cE("text", _uM("class" to "number"), "100")
                                                        ))
                                                    )),
                                                    _cE("view", _uM("class" to "analysisimg"), _uA(
                                                        _cV(_component_tmx_echart, _uM("ref_key" to "stockAnalysis", "ref" to stockAnalysis, "width" to "700rpx", "height" to "250px"), null, 512)
                                                    ))
                                                ))
                                            } else {
                                                _cC("v-if", true)
                                            },
                                            if (unref(analysisTab) == "sale") {
                                                _cE("view", _uM("key" to 1, "class" to "sale"), _uA(
                                                    _cE("view", _uM("class" to "datecheck space-between"), _uA(
                                                        _cE("view", _uM("class" to "date"), _uA(
                                                            _cE("text", _uM("class" to "text"), "今天")
                                                        )),
                                                        _cE("view", _uM("class" to "date"), _uA(
                                                            _cE("text", _uM("class" to "text"), "7天")
                                                        )),
                                                        _cE("view", _uM("class" to "date"), _uA(
                                                            _cE("text", _uM("class" to "text"), "30天")
                                                        )),
                                                        _cE("view", _uM("class" to "date"), _uA(
                                                            _cE("text", _uM("class" to "text"), "自定义")
                                                        ))
                                                    )),
                                                    _cE("view", _uM("class" to "datanumber background-white"), " 汇总统计数据 "),
                                                    _cE("view", _uM("class" to "analysisimg"), _uA(
                                                        _cV(_component_tmx_echart, _uM("ref_key" to "saleAnalysis", "ref" to saleAnalysis, "width" to "700rpx", "height" to "250px"), null, 512)
                                                    )),
                                                    _cE("view", _uM("class" to "hotmember"), " 热衷本产品的会员列表 ")
                                                ))
                                            } else {
                                                _cC("v-if", true)
                                            }
                                        ))
                                    ))
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                            ,
                            if (unref(topTab) == "view") {
                                _cE("view", _uM("key" to 1, "class" to "viewpage"), " 详情 ")
                            } else {
                                _cC("v-if", true)
                            }
                        )
                    }
                    ), "_" to 1))
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
                return _uM("tabs" to _pS(_uM("marginTop" to -7, "backgroundColor" to "rgba(0,0,0,0)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
