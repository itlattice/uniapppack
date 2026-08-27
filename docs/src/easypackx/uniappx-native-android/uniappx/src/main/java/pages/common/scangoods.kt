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
open class GenPagesCommonScangoods : BasePage {
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
        var setup: (__props: GenPagesCommonScangoods) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCommonScangoods
            val _cache = __ins.renderCache
            val pageHeight = ref(0)
            val eventID = ref(0)
            val activeGoods = ref(_uO())
            val selectedList = ref(_uA<selectedListType>())
            val selectedCount = ref(0)
            val goodsPiece = ref(0)
            val select = ref(_uA<UTSJSONObject>())
            val num = ref(1)
            val departID = ref("0")
            val modal = ref<UniElement?>(null)
            val numberWindow = ref<UniElement?>(null)
            val back = fun(){
                uni__off("/pages/common/scangoods", null)
                common.back()
            }
            val scanData = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                })
            }
            val closeWindow = fun(){
                common.callMethod(numberWindow.value as Any, "close")
                num.value = 1
                activeGoods.value = _uO()
            }
            val refreshGoodsPiece = fun(){
                var totalNum: Number = 0
                for(item in resolveUTSValueIterator(selectedList.value)){
                    totalNum += item.number
                }
                goodsPiece.value = totalNum
            }
            val bindNumberInput = fun(e: UniInputEvent, index: Number){
                if (e.detail.value == "") {
                    return
                }
                selectedList.value[index].number = UTSNumber.from(e.detail.value)
                refreshGoodsPiece()
            }
            val getGoodsInfo = fun(code: String): UTSPromise<UTSJSONObject?> {
                return wrapUTSPromise(suspend w1@{
                        console.log("开始获取商品信息", code)
                        var res = await(request.callapi("goods/codeinfo", _uO("code" to code, "depart" to departID.value)))
                        console.log("获得商品信息", res)
                        if (res.code < 0) {
                            common.showModal(modal.value as Any, res.msg, "失败")
                            return@w1 null
                        }
                        activeGoods.value = res.data as UTSJSONObject
                        return@w1 res.data as UTSJSONObject
                })
            }
            val getGoodsNumber = fun(goods: UTSJSONObject): Any {
                var id = goods["id"] as Number
                for(item in resolveUTSValueIterator(selectedList.value)){
                    if (item.id == id) {
                        return item.number as Number
                    }
                }
                return 0
            }
            val addGoods = fun(goodsNum: Number){
                var goodsID = activeGoods.value["id"] as Number
                var have = false
                run {
                    var i: Number = 0
                    while(i < selectedList.value.length){
                        var item = selectedList.value[i] as selectedListType
                        if (item.id == goodsID) {
                            var oldNumber = getGoodsNumber(activeGoods.value) as Number
                            selectedList.value[i].number = oldNumber + goodsNum
                            console.log(oldNumber, goodsNum)
                            have = true
                        }
                        i++
                    }
                }
                if (!have) {
                    selectedList.value.push(selectedListType(id = goodsID, number = goodsNum, goods = activeGoods.value))
                }
                console.log(selectedList.value)
                common.callMethod(numberWindow.value as Any, "close")
                num.value = 1
                activeGoods.value = _uO()
                selectedCount.value = selectedList.value.length
                refreshGoodsPiece()
            }
            val scanCode = fun(code: Any): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        console.log("商品扫描页监听到扫码", code)
                        var goodsinfo = await(getGoodsInfo(code as String))
                        if (goodsinfo == null) {
                            return@w1
                        }
                        num.value = 1
                        addGoods(1)
                })
            }
            val scanComplete = fun(){
                console.log("扫描完成")
                var result: UTSJSONObject = _uO("data" to selectedList.value)
                uni__emit("/pages/common/scangoods", result)
            }
            onLoad(fun(options: OnLoadOptions){
                var str = options["str"] as String
                var json = JSON.parseObject(str) as UTSJSONObject
                select.value = json["list"] as UTSArray<UTSJSONObject>
                departID.value = options["depart"].toString()
                if (departID.value == "null") {
                    departID.value = "0"
                }
                for(item in resolveUTSValueIterator(select.value)){
                    selectedList.value.push(selectedListType(id = item["id"] as Number, number = item["number"] as Number, goods = item["goods"] as UTSJSONObject))
                }
                selectedCount.value = selectedList.value.length
                refreshGoodsPiece()
            }
            )
            onReady(fun(){
                pageHeight.value = uni_getWindowInfo().safeArea.height - 90
            }
            )
            onShow(fun(){
                console.log("商品扫描页开始监听扫码")
                eventID.value = uni__on("scanCode", scanCode)
            }
            )
            onHide(fun(){
                console.log("商品扫描页停止监听扫码")
                uni__off("scanCode", eventID.value)
            }
            )
            onUnload(fun(){
                uni__off("/pages/common/scangoods", null)
                uni__off("scanCode", eventID.value)
            }
            )
            return fun(): Any? {
                val _component_x_choosetitle = resolveEasyComponent("x-choosetitle", GenComponentsXChoosetitleClass)
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_x_triangleinput = resolveEasyComponent("x-triangleinput", GenComponentsXTriangleinputClass)
                val _component_x_model = resolveEasyComponent("x-model", GenComponentsXModelClass)
                val _component_x_numberwindow = resolveEasyComponent("x-numberwindow", GenComponentsXNumberwindowClass)
                return _cE("view", _uM("class" to "scangoods"), _uA(
                    _cV(_component_x_choosetitle, _uM("title" to "商品批量扫描", "page" to "/pages/common/scangoods", "onBack" to back)),
                    _cE("scroll-view", _uM("show-scrollbar" to false, "class" to "list", "style" to _nS(_uM("height" to (unref(pageHeight) + "px"))), "direction" to "vertical"), _uA(
                        if (unref(selectedList).length > 0) {
                            _cE("view", _uM("key" to 0, "class" to "height background-white"), _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(unref(selectedList), fun(item, index, __index, _cached): Any {
                                    return _cE("view", _uM("key" to item.id, "class" to "goods space-between"), _uA(
                                        _cE("view", _uM("class" to "goodsinfo display-flex"), _uA(
                                            _cV(_component_x_iconfont, _uM("name" to "shanchu1", "color" to "red", "class" to "shanchu", "size" to "15", "height" to 24)),
                                            _cE("text", _uM("class" to "infocontent overline"), _tD(item.goods["name"]) + "(" + _tD(item.goods["code"]) + ")", 1)
                                        )),
                                        _cE("view", _uM("class" to "inputnumber"), _uA(
                                            _cV(_component_x_triangleinput, _uM("width" to 60, "height" to 21, "size" to 9), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("input", _uM("type" to "digit", "class" to "number", "onInput" to fun(`$event`: UniInputEvent){
                                                        bindNumberInput(`$event`, index)
                                                    }, "value" to item.number), null, 40, _uA(
                                                        "onInput",
                                                        "value"
                                                    ))
                                                )
                                            }), "_" to 2), 1024)
                                        ))
                                    ))
                                }), 128)
                            ))
                        } else {
                            _cE("view", _uM("key" to 1, "class" to "emptylist", "onClick" to scanData), _uA(
                                _cV(_component_x_iconfont, _uM("class" to "align-center saoma", "name" to "saoyisao", "size" to "170", "color" to "#C4C4C4")),
                                _cE("text", _uM("class" to "align-center content"), "开始扫码")
                            ))
                        }
                        ,
                        _cE("view", _uM("style" to _nS(_uM("height" to "20px"))), null, 4)
                    ), 4),
                    _cE("view", _uM("class" to "actions safe-bottom space-between"), _uA(
                        _cE("view", _uM("class" to "total display-flex"), _uA(
                            _cE("text", _uM("class" to "number lineheight"), "合计:" + _tD(unref(selectedList).length) + "种", 1),
                            _cE("text", _uM("class" to "piece lineheight font-bold"), "共" + _tD(unref(goodsPiece)) + "件", 1)
                        )),
                        _cE("view", _uM("class" to "rightbtn display-flex"), _uA(
                            _cV(_component_x_iconfont, _uM("class" to "actionsao", "onClick" to scanData, "name" to "saoyisao", "size" to "30", "color" to "#1776FC", "height" to 50)),
                            _cE("text", _uM("onClick" to scanComplete, "class" to "okbtn lineheight align-center color-white"), "扫描完成")
                        ))
                    )),
                    _cV(_component_x_model, _uM("ref_key" to "modal", "ref" to modal), null, 512),
                    _cV(_component_x_numberwindow, _uM("ref_key" to "numberWindow", "ref" to numberWindow, "onAddGoods" to addGoods, "onCloseWindow" to closeWindow, "activeGoods" to unref(activeGoods)), null, 8, _uA(
                        "activeGoods"
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
                return _uM("list" to _uM(".scangoods " to _uM("marginTop" to 5)), "height" to _uM(".scangoods .list " to _uM("width" to "750rpx", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#E6E6E6", "borderRightColor" to "#E6E6E6", "borderBottomColor" to "#E6E6E6", "borderLeftColor" to "#E6E6E6")), "goods" to _uM(".scangoods .list " to _uM("paddingRight" to "10rpx", "width" to "750rpx", "height" to 25, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#F0F0F0", "marginLeft" to "8rpx")), "goodsinfo" to _uM(".scangoods .list .goods " to _uM("marginLeft" to 7)), "infocontent" to _uM(".scangoods .list .goods .goodsinfo " to _uM("marginLeft" to 8, "fontSize" to 12, "color" to "#000000", "maxWidth" to "600rpx", "lineHeight" to "25px")), "inputnumber" to _uM(".scangoods .list " to _uM("paddingRight" to "10rpx")), "number" to _uM(".scangoods .list .inputnumber " to _uM("fontSize" to 14, "textAlign" to "center", "paddingTop" to 5), ".scangoods .actions .total " to _uM("fontSize" to 14)), "actions" to _uM(".scangoods " to _uM("borderTopWidth" to 1, "borderTopStyle" to "solid", "borderTopColor" to "#E6E6E6", "height" to 50, "position" to "fixed", "width" to "750rpx", "backgroundImage" to "none", "backgroundColor" to "#ffffff")), "lineheight" to _uM(".scangoods .actions " to _uM("lineHeight" to "50px")), "total" to _uM(".scangoods .actions " to _uM("paddingLeft" to 6)), "piece" to _uM(".scangoods .actions .total " to _uM("marginLeft" to 8, "fontSize" to 16, "color" to "#FF8D1A")), "actionsao" to _uM(".scangoods .actions " to _uM("marginRight" to 16)), "okbtn" to _uM(".scangoods .actions " to _uM("width" to 169, "height" to 50, "backgroundImage" to "none", "backgroundColor" to "#FF5733", "fontSize" to 18)), "saoma" to _uM(".scangoods .emptylist " to _uM("marginTop" to "30%")), "content" to _uM(".scangoods .emptylist " to _uM("color" to "#c4c4c4", "marginTop" to 20, "fontSize" to 18)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
