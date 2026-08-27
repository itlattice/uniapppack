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
open class GenPagesWarehousePurchasePurchase : BasePage {
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
        var setup: (__props: GenPagesWarehousePurchasePurchase) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesWarehousePurchasePurchase
            val _cache = __ins.renderCache
            val orderAdmin = ref(false)
            val adminList = ref(_uA<String>())
            val dateList = ref(_uA<String>())
            val pageHeight = ref(100)
            val page = ref(1)
            val pageMax = ref(1000)
            val buttomLoading = ref(false)
            val keywords = ref("")
            val filterWindow = ref(false)
            val aiOrderWindow = ref(false)
            val aiOrderTool = _uA<UTSJSONObject>(_uO("icon" to "diaobodan", "name" to "要货单进货", "content" to "根据要货单和当前库存情况智能生成", "key" to "allocate"), _uO("icon" to "xiaoshoudan", "name" to "销售数据生成", "content" to "根据过去一段时间的销售情况智能生成进货单", "key" to "sale"), _uO("icon" to "jinhuodan1", "name" to "供应商商品清单生成", "content" to "根据供应商的货物清单智能生成", "key" to "purchase"))
            val dataList = ref(_uA<UTSJSONObject>())
            val paging = ref<UniElement?>(null)
            val loading = ref<UniElement?>(null)
            val erweima = ref<UniElement?>(null)
            val orderWidth = computed(fun(): Number {
                return if (orderAdmin.value) {
                    680
                } else {
                    750
                }
            }
            )
            val handleNumber = computed(fun(): Number {
                return adminList.value.length
            }
            )
            val emptyList = computed(fun(): Boolean {
                return buttomLoading.value == false && dataList.value.length < 1 && pageMax.value <= 1
            }
            )
            val noMoreData = computed(fun(): Boolean {
                return buttomLoading.value == false && dataList.value.length > 0 && pageMax.value <= page.value
            }
            )
            val aiToolClick = fun(key: String){
                console.log("智能工具点击", key)
            }
            val back = fun(){
                common.back()
            }
            val filterClick = fun(){
                filterWindow.value = true
            }
            val aiNewOrder = fun(){
                aiOrderWindow.value = true
            }
            val getDate = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        var res = await(request.callapi("common/getdate", _uO("page" to "warehouse/purchare")))
                        dateList.value = res.data as UTSArray<String>
                })
            }
            val getList = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var res = await(request.callapi("warehouse/purchaseorder", _uO("date" to dateList.value, "page" to page.value, "keywords" to keywords.value)))
                        if (res.code < 0) {
                            buttomLoading.value = false
                            common.toast(res.msg)
                            pageMax.value = 0
                            return@w1
                        }
                        buttomLoading.value = false
                        if (page.value == 1) {
                            dataList.value = res.data as UTSArray<UTSJSONObject>
                        } else {
                            dataList.value = dataList.value.concat(res.data as UTSArray<UTSJSONObject>)
                        }
                        pageMax.value = res.info["maxPage"] as Number
                })
            }
            val loadData = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        await(getDate())
                        console.log("开始刷新")
                        page.value = 1
                        pageMax.value = 1000
                        common.loading(loading.value)
                        await(getList())
                        common.hideLoading(loading.value)
                })
            }
            val nextPage = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        if (noMoreData.value) {
                            return@w1
                        }
                        buttomLoading.value = true
                        page.value++
                        await(getList())
                        buttomLoading.value = false
                })
            }
            val refresh = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        console.log("数据刷新")
                        page.value = 1
                        pageMax.value = 1000
                        await(getList())
                        (paging.value as ComponentPublicInstance).`$callMethod`("closeRefresh")
                })
            }
            val longPress = fun(){
                orderAdmin.value = true
                console.log("查干")
            }
            val cancelAdmin = fun(){
                orderAdmin.value = false
                adminList.value = _uA()
            }
            val newOrder = fun(){
                common.goto("/pages/warehouse/purchase/editpurchase", "slide-in-bottom")
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
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_x_purchase_order = resolveEasyComponent("x-purchase-order", GenComponentsXPurchaseOrderClass)
                val _component_fui_checkbox = resolveEasyComponent("fui-checkbox", GenUniModulesFirstuiUvueComponentsFuiCheckboxFuiCheckboxClass)
                val _component_x_longpress = resolveEasyComponent("x-longpress", GenComponentsXLongpressClass)
                val _component_x_empty = resolveEasyComponent("x-empty", GenComponentsXEmptyClass)
                val _component_x_buttom_loading = resolveEasyComponent("x-buttom-loading", GenComponentsXButtomLoadingClass)
                val _component_x_nomoredata = resolveEasyComponent("x-nomoredata", GenComponentsXNomoredataClass)
                val _component_x_paging = resolveEasyComponent("x-paging", GenComponentsXPagingClass)
                val _component_fui_checkbox_group = resolveEasyComponent("fui-checkbox-group", GenUniModulesFirstuiUvueComponentsFuiCheckboxGroupFuiCheckboxGroupClass)
                val _component_x_aiorder = resolveEasyComponent("x-aiorder", GenComponentsXAiorderClass)
                val _component_x_loading = resolveEasyComponent("x-loading", GenComponentsXLoadingClass)
                val _component_x_showcode = resolveEasyComponent("x-showcode", GenComponentsXShowcodeClass)
                val _component_x_shaixuawindow = resolveEasyComponent("x-shaixuawindow", GenComponentsXShaixuawindowClass)
                return _cE("view", null, _uA(
                    _cE("view", _uM("class" to "navigat padding-stauts-bar background-main"), _uA(
                        _cE("view", _uM("class" to "navigattitle space-between"), _uA(
                            _cE("view", _uM("class" to "title display-flex", "onClick" to back), _uA(
                                _cV(_component_x_iconfont, _uM("height" to 42, "class" to "icon", "name" to "fanhui", "color" to "white", "size" to "18")),
                                _cE("text", _uM("class" to "name color-white"), "进货单")
                            )),
                            _cE("view", _uM("class" to "actions display-flex"), _uA(
                                _cE("view", _uM("class" to "addbtn display-flex", "onClick" to newOrder), _uA(
                                    _cV(_component_x_iconfont, _uM("height" to 42, "class" to "icon", "name" to "jiahao", "size" to "14", "color" to "white")),
                                    _cE("text", _uM("class" to "name color-white"), "新增")
                                )),
                                _cE("view", _uM("class" to "robot display-flex", "onClick" to aiNewOrder), _uA(
                                    _cV(_component_x_iconfont, _uM("height" to 42, "class" to "icon", "name" to "robot", "size" to "18", "color" to "white")),
                                    _cE("text", _uM("class" to "name color-white"), "智能创建")
                                ))
                            ))
                        ))
                    )),
                    _cE("view", _uM("class" to "searchbox display-flex background-white"), _uA(
                        _cE("view", _uM("class" to "seachinputbox display-flex"), _uA(
                            _cV(_component_x_iconfont, _uM("name" to "sousuo", "size" to "18", "color" to "#C4C4C4", "height" to 26)),
                            _cE("input", _uM("type" to "text", "placeholder" to "进货单号/备注", "modelValue" to unref(keywords), "onInput" to fun(`$event`: UniInputEvent){
                                trySetRefValue(keywords, `$event`.detail.value)
                            }
                            , "class" to "input"), null, 40, _uA(
                                "modelValue"
                            )),
                            _cV(_component_x_iconfont, _uM("name" to "saoyisao", "size" to "18", "color" to "#7D7D7D", "height" to 28))
                        )),
                        _cE("view", _uM("class" to "display-flex shaixuan", "onClick" to filterClick), _uA(
                            _cV(_component_x_iconfont, _uM("name" to "shaixuan", "class" to "icon", "color" to "#1776FC", "size" to "16", "height" to 39)),
                            _cE("text", _uM("class" to "content color-main"), "筛选")
                        ))
                    )),
                    _cE("text", _uM("class" to "totalnum align-right"), "共" + _tD(unref(dataList).length) + "条", 1),
                    _cV(_component_fui_checkbox_group, _uM("name" to "orderlist", "modelValue" to unref(adminList), "onUpdate:modelValue" to fun(`$event`: UTSArray<String>){
                        trySetRefValue(adminList, `$event`)
                    }
                    ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to "orderlist"), _uA(
                                _cV(_component_x_paging, _uM("ref_key" to "paging", "ref" to paging, "height" to unref(pageHeight), "onRefresh" to refresh, "onToLower" to nextPage), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cE("view", null, _uA(
                                            _cE(Fragment, null, RenderHelpers.renderList(unref(dataList), fun(item, index, __index, _cached): Any {
                                                return _cV(_component_x_longpress, _uM("key" to index, "onLongpress" to longPress), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return _uA(
                                                        _cE("view", _uM("class" to "orderitem display-flex background-white"), _uA(
                                                            _cV(_component_x_purchase_order, _uM("width" to unref(orderWidth), "order" to item, "index" to index, "onErWeima" to erWeima), null, 8, _uA(
                                                                "width",
                                                                "order",
                                                                "index"
                                                            )),
                                                            _cE("view", _uM("class" to "check"), _uA(
                                                                _cV(_component_fui_checkbox, _uM("value" to (index + ""), "color" to "#1776FC"), null, 8, _uA(
                                                                    "value"
                                                                ))
                                                            ))
                                                        ))
                                                    )
                                                }
                                                ), "_" to 2), 1024)
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
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "modelValue"
                    )),
                    if (isTrue(unref(orderAdmin))) {
                        _cE("view", _uM("key" to 0, "class" to "actions position-fixed safe-bottom width-full"), _uA(
                            _cE("text", _uM("class" to "content"), _uA(
                                _cE("text", _uM("class" to "t"), "已选"),
                                _cE("text", _uM("class" to "color-red number font-bold"), _tD(unref(handleNumber)), 1)
                            )),
                            _cE("view", _uM("class" to "titlesbtn display-flex"), _uA(
                                _cE("text", _uM("class" to "actionbtn align-center quanxuan"), "全选"),
                                _cE("text", _uM("class" to "actionbtn align-center piliang"), "批量打印"),
                                _cE("text", _uM("class" to "actionbtn align-center gengduo"), "更多操作"),
                                _cE("text", _uM("class" to "actionbtn align-center quxiao", "onClick" to cancelAdmin), "取消")
                            ))
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    _cV(_component_x_aiorder, _uM("modelValue" to unref(aiOrderWindow), "onUpdate:modelValue" to fun(`$event`: Boolean){
                        trySetRefValue(aiOrderWindow, `$event`)
                    }
                    , "tools" to aiOrderTool, "onToolClick" to aiToolClick), null, 8, _uA(
                        "modelValue"
                    )),
                    _cV(_component_x_loading, _uM("ref_key" to "loading", "ref" to loading), null, 512),
                    _cV(_component_x_showcode, _uM("ref_key" to "erweima", "ref" to erweima), null, 512),
                    _cV(_component_x_shaixuawindow, _uM("modelValue" to unref(filterWindow), "onUpdate:modelValue" to fun(`$event`: Boolean){
                        trySetRefValue(filterWindow, `$event`)
                    }
                    ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            " 555 "
                        )
                    }
                    ), "_" to 1), 8, _uA(
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
                return _uM("navigattitle" to _uM(".navigat " to _uM("paddingLeft" to "10rpx", "paddingRight" to "20rpx", "height" to 42)), "name" to _uM(".navigat .navigattitle " to _uM("lineHeight" to "42px", "fontSize" to 16, "paddingLeft" to "6rpx"), ".navigat .navigattitle .actions " to _uM("fontSize" to 14)), "robot" to _uM(".navigat .navigattitle .actions " to _uM("marginLeft" to "30rpx")), "searchbox" to _pS(_uM("width" to "750rpx", "height" to 40)), "seachinputbox" to _uM(".searchbox " to _uM("marginLeft" to "20rpx", "width" to "600rpx", "height" to 27, "backgroundImage" to "none", "backgroundColor" to "#f5f5f5", "marginTop" to 7, "borderTopLeftRadius" to 4, "borderTopRightRadius" to 4, "borderBottomRightRadius" to 4, "borderBottomLeftRadius" to 4, "paddingLeft" to "6rpx")), "input" to _uM(".searchbox .seachinputbox " to _uM("paddingLeft" to "6rpx", "fontSize" to 14, "width" to "500rpx")), "shaixuan" to _uM(".searchbox " to _uM("height" to 27, "paddingLeft" to "10rpx")), "content" to _uM(".searchbox .shaixuan " to _uM("paddingTop" to 7, "height" to 27, "paddingLeft" to "4rpx", "lineHeight" to "27px", "fontSize" to 14), ".actions " to _uM("paddingLeft" to "10rpx", "paddingBottom" to 5)), "totalnum" to _pS(_uM("fontSize" to 13, "color" to "#B3B3B3", "paddingTop" to 4, "paddingRight" to "8rpx", "paddingBottom" to 4)), "times" to _pS(_uM("fontSize" to 12, "color" to "#A6A6A6", "marginTop" to 7)), "orderitem" to _pS(_uM("borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#D4D4D4")), "check" to _uM(".orderitem " to _uM("paddingLeft" to "10rpx", "paddingTop" to 25)), "t" to _uM(".actions .content " to _uM("fontSize" to 13, "color" to "#616161", "paddingRight" to "10rpx")), "number" to _uM(".actions .content " to _uM("fontSize" to 13)), "titlesbtn" to _uM(".actions " to _uM("height" to 43)), "actionbtn" to _uM(".actions .titlesbtn " to _uM("height" to 43, "lineHeight" to "43px", "width" to "25%", "fontSize" to 14)), "quanxuan" to _uM(".actions .titlesbtn " to _uM("color" to "#FFFFFF", "backgroundImage" to "none", "backgroundColor" to "#66A6FF")), "piliang" to _uM(".actions .titlesbtn " to _uM("backgroundImage" to "none", "backgroundColor" to "#FF3D3D", "color" to "#FFFFFF")), "gengduo" to _uM(".actions .titlesbtn " to _uM("backgroundImage" to "none", "backgroundColor" to "#2E2E2E", "color" to "#FFFFFF")), "quxiao" to _uM(".actions .titlesbtn " to _uM("color" to "#696969", "backgroundImage" to "none", "backgroundColor" to "#FFFFFF")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
