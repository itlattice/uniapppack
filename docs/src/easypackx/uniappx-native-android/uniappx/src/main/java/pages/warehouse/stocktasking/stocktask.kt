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
import io.dcloud.uniapp.extapi.`$off` as uni__off
import io.dcloud.uniapp.extapi.`$on` as uni__on
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
open class GenPagesWarehouseStocktaskingStocktask : BasePage {
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
        var setup: (__props: GenPagesWarehouseStocktaskingStocktask) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesWarehouseStocktaskingStocktask
            val _cache = __ins.renderCache
            val eventID = ref(0)
            val buttomLoading = ref(false)
            val keywords = ref("")
            val dataList = ref(_uA<UTSJSONObject>())
            val pageMax = ref(1000)
            val page = ref(1)
            val pageHeight = ref(0)
            val dateList = ref(_uA<String>())
            val loading = ref<UniElement?>(null)
            val searchbox = ref<UniElement?>(null)
            val paging = ref<ComponentPublicInstance?>(null)
            val erweima = ref<UniElement?>(null)
            val emptyList = computed(fun(): Boolean {
                return buttomLoading.value == false && dataList.value.length < 1 && pageMax.value <= 1
            }
            )
            val noMoreData = computed(fun(): Boolean {
                return buttomLoading.value == false && dataList.value.length > 0 && pageMax.value <= page.value
            }
            )
            val getDate = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        var res = await(request.callapi("common/getdate", _uO("page" to "warehouse/stocktask")))
                        dateList.value = res.data as UTSArray<String>
                })
            }
            val getList = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var res = await(request.callapi("warehouse/getstocking", _uO("page" to page.value, "date" to dateList.value, "keywords" to keywords.value)))
                        common.hideLoading(loading.value)
                        buttomLoading.value = false
                        if (res.code < 0) {
                            common.toast(res.msg)
                            pageMax.value = 0
                            return@w1
                        }
                        if (page.value == 1) {
                            dataList.value = res.data as UTSArray<UTSJSONObject>
                        } else {
                            dataList.value = dataList.value.concat(res.data as UTSArray<UTSJSONObject>)
                        }
                        pageMax.value = res.info["maxPage"] as Number
                        (paging.value as ComponentPublicInstance).`$callMethod`("closeRefresh")
                })
            }
            val refresh = fun(){
                page.value = 1
                pageMax.value = 1000
                getList()
            }
            val loadData = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        common.loading(loading.value)
                        await(getDate())
                        refresh()
                })
            }
            val scanCode = fun(e: String){
                common.callMethod(searchbox.value as Any, "setKeywords", e)
            }
            val createTask = fun(){
                common.goto("/pages/warehouse/stocktasking/addstocktask", "slide-in-bottom")
            }
            val nextPage = fun(){
                if (page.value >= pageMax.value) {
                    return
                }
                buttomLoading.value = true
                page.value++
                getList()
            }
            val erWeima = fun(index: Number){
                common.callMethod(erweima.value as Any, "showCode", dataList.value[index]["no"] as Any)
            }
            onLoad(fun(_options){
                loadData()
            }
            )
            onReady(fun(){
                pageHeight.value = uni_getWindowInfo().safeArea.height - 110
            }
            )
            onShow(fun(){
                console.log("库存盘点首页开始监听扫码")
                eventID.value = uni__on("scanCode", scanCode)
            }
            )
            onUnload(fun(){
                console.log("库存盘点首页停止监听扫码")
                uni__off("scanCode", eventID.value)
            }
            )
            onHide(fun(){
                console.log("库存盘点首页停止监听扫码")
                uni__off("scanCode", eventID.value)
            }
            )
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_x_viewtitle = resolveEasyComponent("x-viewtitle", GenComponentsXViewtitleClass)
                val _component_x_searchbox = resolveEasyComponent("x-searchbox", GenComponentsXSearchboxClass)
                val _component_x_stocktask = resolveEasyComponent("x-stocktask", GenComponentsXStocktaskClass)
                val _component_x_empty = resolveEasyComponent("x-empty", GenComponentsXEmptyClass)
                val _component_x_buttom_loading = resolveEasyComponent("x-buttom-loading", GenComponentsXButtomLoadingClass)
                val _component_x_nomoredata = resolveEasyComponent("x-nomoredata", GenComponentsXNomoredataClass)
                val _component_x_paging = resolveEasyComponent("x-paging", GenComponentsXPagingClass)
                val _component_x_loading = resolveEasyComponent("x-loading", GenComponentsXLoadingClass)
                val _component_x_showcode = resolveEasyComponent("x-showcode", GenComponentsXShowcodeClass)
                return _cE("view", null, _uA(
                    _cV(_component_x_viewtitle, _uM("title" to "库存盘点"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to "handle display-flex", "onClick" to createTask), _uA(
                                _cV(_component_x_iconfont, _uM("name" to "xinzengrenwu", "color" to "white", "height" to 21, "size" to "20")),
                                _cE("text", _uM("class" to "content color-white"), "新增任务")
                            ))
                        )
                    }
                    ), "_" to 1)),
                    _cE("view", _uM("class" to "searchview background-white"), _uA(
                        _cV(_component_x_searchbox, _uM("ref_key" to "searchbox", "ref" to searchbox, "modelValue" to unref(keywords), "onUpdate:modelValue" to fun(`$event`: String){
                            trySetRefValue(keywords, `$event`)
                        }
                        , "width" to 710, "placeholder" to "盘点任务编号/名称"), null, 8, _uA(
                            "modelValue"
                        ))
                    )),
                    _cE("view", _uM("class" to "basiclist"), _uA(
                        _cE("text", _uM("class" to "totalnum align-right"), "共" + _tD(unref(dataList).length) + "条", 1),
                        _cE("view", _uM("class" to "orderlist"), _uA(
                            _cV(_component_x_paging, _uM("ref_key" to "paging", "ref" to paging, "height" to unref(pageHeight), "onRefresh" to refresh, "onToLower" to nextPage), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", null, _uA(
                                        _cE(Fragment, null, RenderHelpers.renderList(unref(dataList), fun(item, index, __index, _cached): Any {
                                            return _cE("view", _uM("class" to "orderitem display-flex background-white", "key" to index), _uA(
                                                _cV(_component_x_stocktask, _uM("order" to item, "index" to index, "onErWeima" to erWeima), null, 8, _uA(
                                                    "order",
                                                    "index"
                                                ))
                                            ))
                                        }
                                        ), 128),
                                        if (unref(dataList).length > 0) {
                                            _cE("text", _uM("key" to 0, "class" to "align-center times"), "查询时间:" + _tD(unref(dateList)[0]) + "至" + _tD(unref(dateList)[1]), 1)
                                        } else {
                                            _cC("v-if", true)
                                        }
                                        ,
                                        if (isTrue(unref(emptyList))) {
                                            _cV(_component_x_empty, _uM("key" to 1))
                                        } else {
                                            _cC("v-if", true)
                                        }
                                        ,
                                        if (isTrue(unref(buttomLoading))) {
                                            _cV(_component_x_buttom_loading, _uM("key" to 2))
                                        } else {
                                            _cC("v-if", true)
                                        }
                                        ,
                                        if (isTrue(unref(noMoreData))) {
                                            _cV(_component_x_nomoredata, _uM("key" to 3))
                                        } else {
                                            _cC("v-if", true)
                                        }
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "height"
                            ))
                        ))
                    )),
                    _cV(_component_x_loading, _uM("ref_key" to "loading", "ref" to loading), null, 512),
                    _cV(_component_x_showcode, _uM("ref_key" to "erweima", "ref" to erweima), null, 512)
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
                return _uM("content" to _uM(".handle " to _uM("lineHeight" to "21px", "fontSize" to 14)), "searchview" to _pS(_uM("width" to "750rpx", "height" to 50, "paddingLeft" to "20rpx", "paddingRight" to "20rpx", "paddingTop" to 7)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
