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
import uts.sdk.modules.tmxModalS.showModal
open class GenPagesWarehouseStocktaskingRunstocktask : BasePage {
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
        var setup: (__props: GenPagesWarehouseStocktaskingRunstocktask) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesWarehouseStocktaskingRunstocktask
            val _cache = __ins.renderCache
            val orderID = ref(0)
            val eventID = ref(0)
            val list = ref(_uA<selectedListType>())
            val pageHeight = ref(0)
            val selectedCount = ref(0)
            val goodsPiece = ref(0)
            val num = ref(0)
            val location = ref(_uO())
            val modal = ref<UniElement?>(null)
            val getGoodsNumber = fun(goods: UTSJSONObject): Any {
                var id = goods["id"] as Number
                for(item in resolveUTSValueIterator(list.value)){
                    if (item.id == id) {
                        return item.number as Number
                    }
                }
                return 0
            }
            val refreshGoodsPiece = fun(){
                var totalNum: Number = 0
                for(item in resolveUTSValueIterator(list.value)){
                    totalNum += item.number
                }
                goodsPiece.value = totalNum
            }
            val addGoods = fun(goods: UTSJSONObject, code: String, goodsNum: Number){
                var goodsID = goods["id"] as Number
                var have = false
                run {
                    var i: Number = 0
                    while(i < list.value.length){
                        var item = list.value[i] as selectedListType
                        if (item.id == goodsID) {
                            var oldNumber = getGoodsNumber(goods) as Number
                            list.value[i].number = oldNumber + goodsNum
                            console.log(oldNumber, goodsNum)
                            have = true
                        }
                        i++
                    }
                }
                if (!have) {
                    list.value.push(selectedListType(id = goodsID, number = goodsNum, goods = goods))
                }
                console.log(list.value, code)
                num.value = 1
                selectedCount.value = list.value.length
                refreshGoodsPiece()
            }
            val scanComplete = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var data = _uA<UTSJSONObject>()
                        var currentList = list.value
                        if (currentList.length < 1) {
                            common.back()
                            return@w1
                        }
                        list.value = _uA<selectedListType>()
                        for(item in resolveUTSValueIterator(currentList)){
                            data.push(_uO("goods" to item.id, "number" to item.number))
                        }
                        var res = await(request.callapi("warehouse/updatestocktaskdata", _uO("list" to data, "task" to orderID.value, "location" to location.value)))
                        common.toast(res.msg)
                        if (res.code < 0) {
                            return@w1
                        }
                        common.timeBack()
                })
            }
            val backPage = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        if (list.value.length > 0) {
                            var r = await(common.showQuery(modal.value as Any, "有数据未上报，是否上报？"))
                            if (r) {
                                scanComplete()
                                return@w1
                            }
                        }
                        common.back()
                })
            }
            val loadData = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        var locationRes = await(common.getLocation("Hight", "signin"))
                        location.value = _uO("lat" to locationRes.latitude, "lng" to locationRes.longitude, "accuracy" to locationRes.accuracy)
                        console.log("定位结果", location.value)
                })
            }
            val handAdd = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var res = await(common.navigatoEvent("/pages/common/choosegoods?str={}"))
                        if (res["data"] == null) {
                            return@w1
                        }
                        var selected = res["data"] as UTSArray<selectedListType>
                        for(item in resolveUTSValueIterator(selected)){
                            addGoods(item.goods as UTSJSONObject, item.goods["code"] as String, item.number)
                        }
                })
            }
            val scanCode = fun(e: String): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        if (e == "") {
                            return@w1
                        }
                        console.log("接收到扫码", e, orderID.value)
                        var codeinfo = await(getdata.goodscodeinfo(e))
                        console.log("扫码收到商品", codeinfo)
                        if (codeinfo == null) {
                            common.showModal(modal.value as Any, "未找到商品[" + e + "]", "失败")
                            return@w1
                        }
                        var goods = codeinfo as UTSJSONObject
                        addGoods(goods, e, 1)
                })
            }
            val scan = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        var res = await(common.scanCode())
                        var code = res.codeValue
                        scanCode(code as String)
                })
            }
            val clickMenu = fun(){
                scan()
            }
            val numberInput = fun(index: Number, inputNum: Number){
                list.value[index].number = inputNum
                refreshGoodsPiece()
            }
            val deleteGoods = fun(index: Number): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var res = await(common.showQuery(modal.value as Any, "确定删除该商品？", "提示"))
                        if (!res) {
                            return@w1
                        }
                        list.value.splice(index, 1)
                        refreshGoodsPiece()
                })
            }
            onLoad(fun(query: OnLoadOptions){
                orderID.value = UTSNumber.from(query["id"] as String)
            }
            )
            onShow(fun(){
                console.log("盘点中开始监听扫码")
                eventID.value = uni__on("scanCode", scanCode)
            }
            )
            onReady(fun(){
                pageHeight.value = uni_getWindowInfo().safeArea.height - 95
                loadData()
            }
            )
            onHide(fun(){
                console.log("盘点中停止监听扫码")
                uni__off("scanCode", eventID.value)
            }
            )
            onUnload(fun(){
                console.log("盘点中停止监听扫码")
                uni__off("scanCode", eventID.value)
            }
            )
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_x_viewtitle = resolveEasyComponent("x-viewtitle", GenComponentsXViewtitleClass)
                val _component_x_empty = resolveEasyComponent("x-empty", GenComponentsXEmptyClass)
                val _component_x_list_goods = resolveEasyComponent("x-list-goods", GenComponentsXListGoodsClass)
                val _component_x_bottom_popup = resolveEasyComponent("x-bottom-popup", GenComponentsXBottomPopupClass)
                val _component_x_loading = resolveEasyComponent("x-loading", GenComponentsXLoadingClass)
                val _component_x_model = resolveEasyComponent("x-model", GenComponentsXModelClass)
                return _cE("view", null, _uA(
                    _cV(_component_x_viewtitle, _uM("title" to "盘点中", "backpage" to false, "onBack" to backPage), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to "handle display-flex", "onClick" to handAdd), _uA(
                                _cV(_component_x_iconfont, _uM("name" to "jiahao", "color" to "white", "height" to 20, "size" to "16")),
                                _cE("text", _uM("class" to "content color-white"), "手动添加")
                            ))
                        )
                    }
                    ), "_" to 1)),
                    _cE("scroll-view", _uM("direction" to "vertical", "style" to _nS(_uM("height" to (unref(pageHeight) + "px")))), _uA(
                        if (unref(list).length < 1) {
                            _cE("view", _uM("key" to 0), _uA(
                                _cV(_component_x_empty, _uM("icon" to "saoyisao", "content" to "请扫码", "onClick" to scan))
                            ))
                        } else {
                            _cE("view", _uM("key" to 1, "class" to "list background-white"), _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(unref(list), fun(item, index, __index, _cached): Any {
                                    return _cE("view", _uM("key" to item.id), _uA(
                                        _cV(_component_x_list_goods, _uM("goods" to item, "index" to index, "onNumberInput" to numberInput, "onDelete" to deleteGoods), null, 8, _uA(
                                            "goods",
                                            "index"
                                        ))
                                    ))
                                }
                                ), 128)
                            ))
                        }
                    ), 4),
                    _cE("view", _uM("class" to "actions safe-bottom space-between"), _uA(
                        _cE("view", _uM("class" to "total display-flex"), _uA(
                            _cE("text", _uM("class" to "number lineheight"), "合计:" + _tD(unref(list).length) + "种", 1),
                            _cE("text", _uM("class" to "piece lineheight font-bold"), "共" + _tD(unref(goodsPiece)) + "件", 1)
                        )),
                        _cE("view", _uM("class" to "rightbtn display-flex"), _uA(
                            _cV(_component_x_iconfont, _uM("class" to "actionsao", "onClick" to scan, "name" to "saoyisao", "size" to "30", "color" to "#1776FC", "height" to 50)),
                            _cE("text", _uM("onClick" to scanComplete, "class" to "okbtn lineheight align-center color-white"), "结束本轮")
                        ))
                    )),
                    _cV(_component_x_bottom_popup, _uM("color" to "#1678fd", "bottom" to 100, "icon" to "saoyisao", "onClickOn" to clickMenu)),
                    _cV(_component_x_loading, _uM("ref" to "loading"), null, 512),
                    _cV(_component_x_model, _uM("ref_key" to "modal", "ref" to modal), null, 512)
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
                return _uM("content" to _uM(".handle " to _uM("fontSize" to 14, "marginLeft" to "8rpx", "lineHeight" to "22px")), "actions" to _pS(_uM("borderTopWidth" to 1, "borderTopStyle" to "solid", "borderTopColor" to "#E6E6E6", "height" to 50, "position" to "fixed", "width" to "750rpx", "backgroundImage" to "none", "backgroundColor" to "#ffffff")), "lineheight" to _uM(".actions " to _uM("lineHeight" to "50px")), "total" to _uM(".actions " to _uM("paddingLeft" to 6)), "number" to _uM(".actions .total " to _uM("fontSize" to 14)), "piece" to _uM(".actions .total " to _uM("marginLeft" to 8, "fontSize" to 16, "color" to "#1678fd")), "actionsao" to _uM(".actions " to _uM("marginRight" to 16)), "okbtn" to _uM(".actions " to _uM("width" to 169, "height" to 50, "backgroundImage" to "none", "backgroundColor" to "#1678fd", "fontSize" to 18)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
