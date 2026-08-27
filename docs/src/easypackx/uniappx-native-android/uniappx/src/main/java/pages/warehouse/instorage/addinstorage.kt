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
open class GenPagesWarehouseInstorageAddinstorage : BasePage {
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
        var setup: (__props: GenPagesWarehouseInstorageAddinstorage) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesWarehouseInstorageAddinstorage
            val _cache = __ins.renderCache
            val chooseDateStr = ref("")
            val pageHeight = ref(0)
            val depart = ref(_uO())
            val fromdepart = ref(_uO())
            val resons = ref(_uA<FuiDropdownMenuOptionParam>())
            val reson = ref("")
            val resonKey = ref("")
            val rangeShow = ref(false)
            val openIndex = ref(-1)
            val haveCache = ref(true)
            val goodsList = ref(_uA<instoragegoodsinfo>())
            val order = ref(_uO())
            val supplierList = ref(_uA<UTSJSONObject>())
            val orderremark = ref<UniElement?>(null)
            val remarkwindow = ref<UniElement?>(null)
            val model = ref<UniElement?>(null)
            val choosedate = ref<UniElement?>(null)
            val signer = ref<UniElement?>(null)
            val loading = ref<UniElement?>(null)
            val resonRange = ref<UniElement?>(null)
            val remark = computed(fun(): Any {
                if (openIndex.value < 0) {
                    return ""
                }
                if (goodsList.value[openIndex.value].remark == null) {
                    return ""
                }
                return goodsList.value[openIndex.value].remark as String
            }
            )
            val supplierPaid = fun(item: UTSJSONObject): Number {
                return if (item["amount"] == null) {
                    0.00
                } else {
                    item["amount"] as Number
                }
            }
            val supplierPrice = fun(item: UTSJSONObject): Number {
                return if (item["price"] == null) {
                    0.00
                } else {
                    item["price"] as Number
                }
            }
            val supplierDebt = fun(item: UTSJSONObject): Number {
                return supplierPaid(item) - supplierPrice(item)
            }
            val loadCache = fun(){
                var cacheData = common.getStorage("warehouse_instorage")
                if (cacheData == "") {
                    return
                }
                cacheData = cacheData as UTSJSONObject
                console.log("加载到缓存", cacheData)
                var list = cacheData["goodsList"] as UTSArray<UTSJSONObject>
                goodsList.value = _uA<instoragegoodsinfo>()
                for(item in resolveUTSValueIterator(list)){
                    goodsList.value.push(instoragegoodsinfo(goodsinfo = item["goodsinfo"] as UTSJSONObject, number = item["number"] as Number, price = item["price"] as Number, id = item["id"] as Number, remark = if (item["remark"] == null) {
                        null
                    } else {
                        (item["remark"] as String)
                    }
                    ))
                }
                depart.value = cacheData["depart"] as UTSJSONObject
                fromdepart.value = cacheData["fromdepart"] as UTSJSONObject
                reson.value = cacheData["reson"] as String
                resonKey.value = cacheData["resonKey"] as String
                order.value = cacheData["order"] as UTSJSONObject
                supplierList.value = cacheData["supplierList"] as UTSArray<UTSJSONObject>
                if (cacheData["remark"] != null) {
                    uni__emit("setremarkbox", _uO("remark" to cacheData["remark"] as String, "thumb" to cacheData["thumb"] as UTSArray<UTSJSONObject>))
                }
                haveCache.value = true
                common.rmStorage("warehouse_instorage")
            }
            val getData = fun(): UTSPromise<UTSJSONObject?> {
                return wrapUTSPromise(suspend w1@{
                        console.log("submit")
                        var remarkbox = await(common.lisenInfo("xremarkbox", orderremark.value as Any))
                        console.log("remark", remarkbox)
                        if (remarkbox["remark"] == null) {
                            console.log("null")
                            return@w1 null
                        }
                        var data: UTSJSONObject = _uO("fromdepart" to fromdepart.value, "depart" to depart.value, "reson" to reson.value, "resonKey" to resonKey.value, "goodsList" to goodsList.value, "order" to order.value, "supplierList" to supplierList.value, "remark" to remarkbox["remark"] as String, "thumb" to remarkbox["file"] as UTSArray<UTSJSONObject>)
                        return@w1 data
                })
            }
            val draftOrder = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        var data = await(getData())
                        common.setStorage("warehouse_instorage", data as Any)
                        common.back()
                })
            }
            val submitOrder = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var data = await(getData())
                        if (data == null) {
                            common.toast("数据验证失败")
                            return@w1
                        }
                        var goods = _uA<UTSJSONObject>()
                        var list = data["goodsList"] as UTSArray<instoragegoodsinfo>
                        for(g in resolveUTSValueIterator(list)){
                            goods.push(_uO("number" to g.number, "id" to g.id, "remark" to g.remark, "price" to g.price))
                        }
                        var departData = data["depart"] as UTSJSONObject
                        var bindOrderID = "0"
                        if (order.value["id"] != null) {
                            bindOrderID = order.value["id"].toString()
                        }
                        var requestData: UTSJSONObject = _uO("fromdepart" to fromdepart.value["id"], "order" to bindOrderID, "depart" to departData["id"], "resonkey" to data["resonKey"], "goods" to goods, "supplierList" to data["supplierList"], "remark" to data["remark"], "thumb" to data["thumb"])
                        console.log("提交信息", requestData)
                        var sign = await(common.signer(signer.value as Any))
                        console.log("签字信息", sign)
                        if (sign == null) {
                            return@w1
                        }
                        requestData["signer"] = sign
                        common.loading(loading.value)
                        var res = await(request.callapi("warehouse/addinstorage", requestData))
                        common.hideLoading(loading.value)
                        common.toast(res.msg)
                        if (res.code < 0) {
                            return@w1
                        }
                        var orderID = (res.data as UTSJSONObject)["id"] as Number
                        common.timeToPage("/pages/warehouse/instorage/view?id=" + orderID.toString(), true)
                })
            }
            val quankuan = fun(index: Number){
                supplierList.value[index]["amount"] = supplierList.value[index]["price"]
            }
            val chooseDate = fun(index: Number): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        chooseDateStr.value = supplierList.value[index]["date"] as String
                        var res = await(common.chooseDate(choosedate.value as Any))
                        if (res == null) {
                            return@w1
                        }
                        supplierList.value[index]["date"] = res
                })
            }
            val bindSupPriceInput = fun(index: Number, e: UniInputEvent){
                if (e.detail.value == "") {
                    return
                }
                var number = UTSNumber.from(e.detail.value)
                supplierList.value[index]["price"] = number
            }
            val bindSupAmountInput = fun(index: Number, e: UniInputEvent){
                if (e.detail.value == "") {
                    return
                }
                var number = UTSNumber.from(e.detail.value)
                supplierList.value[index]["amount"] = number
            }
            val deleteSupplier = fun(index: Number){
                openIndex.value = -1
                supplierList.value.splice(index, 1)
            }
            val deleteGoods = fun(index: Number){
                openIndex.value = -1
                goodsList.value.splice(index, 1)
            }
            val pullSupplier = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        if (supplierList.value.length > 0) {
                            var b = await(common.showQuery(model.value as Any, "已有供应商列表，拉取供应商会重置本列表，确定继续？"))
                            if (!b) {
                                return@w1
                            }
                        }
                        var goods = _uA<UTSJSONObject>()
                        for(g in resolveUTSValueIterator(goodsList.value)){
                            if (g.price <= 0) {
                                common.toast(g.goodsinfo["name"].toString() + "进货价格异常，请先补充完整")
                                return@w1
                            }
                            goods.push(_uO("id" to g.id, "number" to g.number, "price" to g.price, "remark" to g.remark))
                        }
                        var res = await(request.callapi("warehouse/pullsupplier", _uO("goods" to goods)))
                        if (res.code < 0) {
                            common.toast(res.msg)
                            return@w1
                        }
                        var list = res.data as UTSArray<UTSJSONObject>
                        supplierList.value = list
                })
            }
            val closeWindow = fun(){
                common.callMethod(remarkwindow.value as Any, "close")
            }
            val addRemarkContent = fun(newRemark: String){
                goodsList.value[openIndex.value].remark = newRemark
                openIndex.value = -1
                closeWindow()
            }
            val bindNumberInput = fun(index: Number, e: UniInputEvent){
                if (e.detail.value == "") {
                    return
                }
                var number = UTSNumber.from(e.detail.value)
                goodsList.value[index].number = number
            }
            val bindPriceInput = fun(index: Number, e: UniInputEvent){
                if (e.detail.value == "") {
                    return
                }
                var price = UTSNumber.from(e.detail.value)
                goodsList.value[index].price = price
            }
            val addRemark = fun(index: Number){
                openIndex.value = index
                common.callMethod(remarkwindow.value as Any, "open")
            }
            val openIndexAction = fun(index: Number){
                if (openIndex.value == index) {
                    openIndex.value = -1
                } else {
                    openIndex.value = index
                }
            }
            val getUserShop = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var res = await(request.callapi("user/getshopinfo", _uO()))
                        if (res.code < 0) {
                            common.toast("错误:" + res.msg)
                            return@w1
                        }
                        depart.value = res.data as UTSJSONObject
                })
            }
            val loadPageData = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var res = await(request.callapi("warehouse/getinstorageresonlist", _uO()))
                        if (res.code < 0) {
                            common.toast(res.msg)
                            common.back()
                            return@w1
                        }
                        var list = res.data as UTSArray<UTSJSONObject>
                        reson.value = list[0]["text"] as String
                        resonKey.value = list[0]["value"] as String
                        var mlist = _uA<FuiDropdownMenuOptionParam>()
                        for(item in resolveUTSValueIterator(list)){
                            mlist.push(FuiDropdownMenuOptionParam(text = item["text"] as String, value = item["value"] as String, checked = item["checked"] == true))
                        }
                        resons.value = mlist as UTSArray<FuiDropdownMenuOptionParam>
                })
            }
            val rangeResonClose = fun(){
                rangeShow.value = false
            }
            val rangeItemResonClick = fun(e: FuiDropdownMenuOptionParam){
                console.log(e)
                reson.value = e.text
                resonKey.value = e.value as String
                rangeResonClose()
            }
            val filterTap = fun(){
                (resonRange.value as FuiDropdownMenuComponentPublicInstance).show()
                rangeShow.value = true
            }
            val chooseDepart = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var selectedDepart = await(common.navigatoEvent("/pages/common/choosedepart"))
                        if (selectedDepart["name"] == null) {
                            return@w1
                        }
                        console.log("响应", selectedDepart)
                        depart.value = selectedDepart
                })
            }
            val chooseFromDepart = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var selectedDepart = await(common.navigatoEvent("/pages/common/choosedepart"))
                        if (selectedDepart["name"] == null) {
                            return@w1
                        }
                        console.log("响应", selectedDepart)
                        fromdepart.value = selectedDepart
                })
            }
            val chooseSupplier = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var supplier = await(common.navigatoEvent("/pages/common/choosesupplier"))
                        if (supplier["name"] == null) {
                            return@w1
                        }
                })
            }
            val choosePurchaseOrder = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var selectedOrder = await(common.navigatoEvent("/pages/common/choosepurchaseorder?status=1"))
                        if (selectedOrder["no"] == null) {
                            return@w1
                        }
                        console.log("选择进货单", selectedOrder)
                        order.value = selectedOrder
                        var res = await(request.callapi("warehouse/purchaseview", _uO("id" to selectedOrder["id"])))
                        if (res.code < 0) {
                            common.toast(res.msg)
                            return@w1
                        }
                        var data = res.data as UTSJSONObject
                        var items = data["items"] as UTSArray<UTSJSONObject>
                        goodsList.value = _uA<instoragegoodsinfo>()
                        for(item in resolveUTSValueIterator(items)){
                            goodsList.value.push(instoragegoodsinfo(goodsinfo = item["goods_data"] as UTSJSONObject, number = item["number"] as Number, id = item["goods_id"] as Number, remark = if (item["remark"] == null) {
                                ""
                            } else {
                                item["remark"] as String
                            }
                            , price = item["amount"] as Number))
                        }
                })
            }
            val chooseAllocateOrder = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var selectedOrder = await(common.navigatoEvent("/pages/common/chooseallocateorder?todepart=" + depart.value["id"].toString()))
                        if (selectedOrder["no"] == null) {
                            return@w1
                        }
                        console.log("选择调拨单", selectedOrder)
                        order.value = selectedOrder
                })
            }
            val clearCache = fun(){
                depart.value = _uO()
                reson.value = ""
                resonKey.value = ""
                goodsList.value = _uA<instoragegoodsinfo>()
                order.value = _uO()
                fromdepart.value = _uO()
                supplierList.value = _uA<UTSJSONObject>()
                uni__emit("clearremarkbox", null)
                common.rmStorage("warehouse_instorage")
            }
            onLoad(fun(_options){
                var data = xDate(Date.now() + "")
                chooseDateStr.value = data.format("YYYY-MM-DD")
                getUserShop()
                loadPageData()
            }
            )
            onReady(fun(){
                var windowInfo = uni_getWindowInfo()
                pageHeight.value = windowInfo.safeArea.height - 150
                loadCache()
            }
            )
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_x_viewtitle = resolveEasyComponent("x-viewtitle", GenComponentsXViewtitleClass)
                val _component_x_triangleinput = resolveEasyComponent("x-triangleinput", GenComponentsXTriangleinputClass)
                val _component_fui_dropdown_menu = resolveEasyComponent("fui-dropdown-menu", GenUniModulesFirstuiUvueComponentsFuiDropdownMenuFuiDropdownMenuClass)
                val _component_x_addgoods = resolveEasyComponent("x-addgoods", GenComponentsXAddgoodsClass)
                val _component_x_button = resolveEasyComponent("x-button", GenComponentsXButtonClass)
                val _component_x_remarkbox = resolveEasyComponent("x-remarkbox", GenComponentsXRemarkboxClass)
                val _component_x_remarkwindow = resolveEasyComponent("x-remarkwindow", GenComponentsXRemarkwindowClass)
                val _component_x_order_action = resolveEasyComponent("x-order-action", GenComponentsXOrderActionClass)
                val _component_x_model = resolveEasyComponent("x-model", GenComponentsXModelClass)
                val _component_x_choosedate = resolveEasyComponent("x-choosedate", GenComponentsXChoosedateClass)
                val _component_x_signer = resolveEasyComponent("x-signer", GenComponentsXSignerClass)
                val _component_x_loading = resolveEasyComponent("x-loading", GenComponentsXLoadingClass)
                return _cE("view", null, _uA(
                    _cV(_component_x_viewtitle, _uM("title" to "商品入库"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to "handles display-flex"), _uA(
                                _cE("view", _uM("class" to "addbtn display-flex"), _uA(
                                    _cV(_component_x_iconfont, _uM("class" to "icon", "name" to "zhineng", "color" to "white", "size" to "18")),
                                    _cE("text", _uM("class" to "name color-white"), "智能入库")
                                )),
                                if (isTrue(unref(haveCache))) {
                                    _cE("text", _uM("key" to 0, "class" to "name color-white", "onClick" to clearCache, "style" to _nS(_uM("line-height" to "18px", "font-size" to "14px", "padding-left" to "20rpx"))), "清空", 4)
                                } else {
                                    _cC("v-if", true)
                                }
                            ))
                        )
                    }
                    ), "_" to 1)),
                    _cE("scroll-view", _uM("scroll-y" to true), _uA(
                        _cE("view", null, _uA(
                            _cE("view", _uM("class" to "basicbox background-white width-full"), _uA(
                                _cE("view", _uM("class" to "lineitem"), _uA(
                                    _cV(_component_x_triangleinput, _uM("height" to 35, "width" to 710), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cE("view", _uM("class" to "linebox display-flex"), _uA(
                                                _cE("text", _uM("class" to "title"), "仓库"),
                                                _cE("view", _uM("class" to "changbox", "onClick" to chooseDepart), _uA(
                                                    if (isTrue(unref(depart)["name"])) {
                                                        _cE("text", _uM("key" to 0, "class" to "text"), _tD(unref(depart)["name"]), 1)
                                                    } else {
                                                        _cE("text", _uM("key" to 1, "class" to "text placeholder"), "选择入库的仓库或门店")
                                                    }
                                                ))
                                            ))
                                        )
                                    }
                                    ), "_" to 1))
                                )),
                                _cE("view", _uM("class" to "lineitem"), _uA(
                                    _cV(_component_x_triangleinput, _uM("height" to 35, "width" to 710), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cE("view", _uM("class" to "linebox display-flex", "onClick" to filterTap), _uA(
                                                _cE("text", _uM("class" to "title"), "入库原因"),
                                                _cE("view", _uM("class" to "changbox"), _uA(
                                                    _cV(_component_fui_dropdown_menu, _uM("ref_key" to "resonRange", "ref" to resonRange, "maxHeight" to 324, "size" to 15, "selectedColor" to "#465CFF", "menus" to unref(resons), "onOnclick" to rangeItemResonClick, "onClose" to rangeResonClose, "isCheckbox" to false), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                        return _uA(
                                                            _cE("view", _uM("class" to "fui-filter__item display-flex"), _uA(
                                                                _cE("text", _uM("class" to "text color-black"), _tD(unref(reson)), 1)
                                                            ))
                                                        )
                                                    }
                                                    ), "_" to 1), 8, _uA(
                                                        "menus"
                                                    ))
                                                ))
                                            ))
                                        )
                                    }
                                    ), "_" to 1))
                                )),
                                if (unref(resonKey) == "purchase") {
                                    _cE("view", _uM("key" to 0, "class" to "lineitem"), _uA(
                                        _cV(_component_x_triangleinput, _uM("height" to 35, "width" to 710), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _cE("view", _uM("class" to "linebox display-flex"), _uA(
                                                    _cE("text", _uM("class" to "title"), "进货单"),
                                                    _cE("view", _uM("class" to "changbox display-flex space-between", "onClick" to choosePurchaseOrder), _uA(
                                                        if (isTrue(unref(order)["no"])) {
                                                            _cE("text", _uM("key" to 0, "class" to "text"), _tD(unref(order)["no"]) + "(" + _tD(unref(order)["add_date"]) + ")", 1)
                                                        } else {
                                                            _cE("text", _uM("key" to 1, "class" to "text placeholder"), "选择进货单")
                                                        },
                                                        if (isTrue(unref(order)["no"])) {
                                                            _cV(_component_x_iconfont, _uM("key" to 2, "class" to "icon", "name" to "chacha", "size" to "18", "color" to "#C4C4C4"))
                                                        } else {
                                                            _cC("v-if", true)
                                                        }
                                                    ))
                                                ))
                                            )
                                        }), "_" to 1))
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                                ,
                                if (unref(resonKey) == "allocate") {
                                    _cE("view", _uM("key" to 1, "class" to "lineitem"), _uA(
                                        _cV(_component_x_triangleinput, _uM("height" to 35, "width" to 710), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _cE("view", _uM("class" to "linebox display-flex"), _uA(
                                                    _cE("text", _uM("class" to "title"), "调拨单"),
                                                    _cE("view", _uM("class" to "changbox display-flex space-between", "onClick" to chooseAllocateOrder), _uA(
                                                        if (isTrue(unref(order)["no"])) {
                                                            _cE("text", _uM("key" to 0, "class" to "text"), _tD(unref(order)["no"]) + "(" + _tD(unref(order)["add_date"]) + ")", 1)
                                                        } else {
                                                            _cE("text", _uM("key" to 1, "class" to "text placeholder"), "选择调拨单")
                                                        },
                                                        if (isTrue(unref(order)["no"])) {
                                                            _cV(_component_x_iconfont, _uM("key" to 2, "class" to "icon", "name" to "chacha", "size" to "18", "color" to "#C4C4C4"))
                                                        } else {
                                                            _cC("v-if", true)
                                                        }
                                                    ))
                                                ))
                                            )
                                        }), "_" to 1))
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                                ,
                                if (unref(resonKey) == "down") {
                                    _cE("view", _uM("key" to 2, "class" to "lineitem"), _uA(
                                        _cV(_component_x_triangleinput, _uM("height" to 35, "width" to 710), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _cE("view", _uM("class" to "linebox display-flex"), _uA(
                                                    _cE("text", _uM("class" to "title"), "下架门店"),
                                                    _cE("view", _uM("class" to "changbox", "onClick" to chooseFromDepart), _uA(
                                                        if (isTrue(unref(fromdepart)["name"])) {
                                                            _cE("text", _uM("key" to 0, "class" to "text"), _tD(unref(fromdepart)["name"]), 1)
                                                        } else {
                                                            _cE("text", _uM("key" to 1, "class" to "text placeholder"), "选择门店")
                                                        }
                                                    ))
                                                ))
                                            )
                                        }), "_" to 1))
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                            )),
                            _cE("view", _uM("class" to "goodslist background-white"), _uA(
                                _cE("view", _uM("class" to "title space-between"), _uA(
                                    _cE("view", _uM("class" to "name"), _uA(
                                        _cE("text", _uM("class" to "text color-main"), "添加商品")
                                    ))
                                )),
                                _cE("view", _uM("class" to "list"), _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(unref(goodsList), fun(item, index, __index, _cached): Any {
                                        return _cE("view", _uM("class" to "item", "key" to index), _uA(
                                            _cE("view", _uM("class" to "basicdata space-between"), _uA(
                                                _cE("view", _uM("class" to "nameinfo display-flex"), _uA(
                                                    _cV(_component_x_iconfont, _uM("name" to "jian", "color" to "#ff0000", "size" to "16", "height" to 20, "style" to _nS(_uM("margin-right" to "6px")), "onClick" to fun(){
                                                        deleteGoods(index)
                                                    }
                                                    ), null, 8, _uA(
                                                        "style",
                                                        "onClick"
                                                    )),
                                                    _cE("text", _uM("class" to "name overline"), _tD(item.goodsinfo["name"]) + "（" + _tD(item.goodsinfo["code"]) + "）", 1),
                                                    _cV(_component_x_iconfont, _uM("name" to "bianjibiaoge", "onClick" to fun(){
                                                        openIndexAction(index)
                                                    }
                                                    , "color" to "#1776FC", "size" to "15", "class" to "bianjitable"), null, 8, _uA(
                                                        "onClick"
                                                    ))
                                                )),
                                                _cE("text", _uM("class" to "stock"), "X" + _tD(item.number), 1)
                                            )),
                                            _cE("view", _uM("class" to "priceinfo space-between"), _uA(
                                                _cE("view", _uM("class" to "remark display-flex", "onClick" to fun(){
                                                    addRemark(index)
                                                }
                                                ), _uA(
                                                    _cE("text", _uM("class" to "tagbox align-center color-main"), "备注"),
                                                    _cE("text", _uM("class" to "overline remarkcontent"), _tD(item.remark), 1)
                                                ), 8, _uA(
                                                    "onClick"
                                                )),
                                                _cE("view", _uM("class" to "priceinfocontent display-flex", "onClick" to fun(){
                                                    openIndexAction(index)
                                                }
                                                ), _uA(
                                                    _cE("text", _uM("class" to "price"), _uA(
                                                        _cE("text", _uM("class" to "yugu"), "预估￥"),
                                                        _cE("text", _uM("class" to "input"), _tD(item.price.toFixed(2)), 1)
                                                    ))
                                                ), 8, _uA(
                                                    "onClick"
                                                )),
                                                _cV(_component_x_iconfont, _uM("class" to "xiangxiaicon", "name" to if (unref(openIndex) != index) {
                                                    "xiangxia"
                                                } else {
                                                    "xiangshang"
                                                }
                                                , "size" to "13", "color" to "#C4C4C4", "onClick" to fun(){
                                                    openIndexAction(index)
                                                }
                                                ), null, 8, _uA(
                                                    "name",
                                                    "onClick"
                                                ))
                                            )),
                                            if (unref(openIndex) == index) {
                                                _cE("view", _uM("key" to 0, "class" to "updateinput"), _uA(
                                                    _cE("view", _uM("class" to "titles display-flex"), _uA(
                                                        _cE("text", _uM("class" to "title align-center"), "数量"),
                                                        _cE("text", _uM("class" to "title align-center"), "总进货价")
                                                    )),
                                                    _cE("view", _uM("class" to "inputs display-flex"), _uA(
                                                        _cE("input", _uM("type" to "digit", "class" to "input align-center", "onInput" to fun(`$event`: UniInputEvent){
                                                            bindNumberInput(index, `$event`)
                                                        }, "value" to item.number), null, 40, _uA(
                                                            "onInput",
                                                            "value"
                                                        )),
                                                        _cE("input", _uM("type" to "digit", "class" to "input align-center", "onInput" to fun(`$event`: UniInputEvent){
                                                            bindPriceInput(index, `$event`)
                                                        }, "value" to item.price), null, 40, _uA(
                                                            "onInput",
                                                            "value"
                                                        ))
                                                    ))
                                                ))
                                            } else {
                                                _cC("v-if", true)
                                            }
                                        ))
                                    }
                                    ), 128)
                                )),
                                _cV(_component_x_addgoods)
                            )),
                            _cE("view", _uM("class" to "goodslist background-white"), _uA(
                                _cE("view", _uM("class" to "title space-between"), _uA(
                                    _cE("view", _uM("class" to "name display-flex"), _uA(
                                        _cE("text", _uM("class" to "text color-main"), "货款结算"),
                                        if (unref(goodsList).length > 0) {
                                            _cV(_component_x_button, _uM("key" to 0, "class" to "xbtn-normal addlist", "onClick" to pullSupplier), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    "生成目录"
                                                )
                                            }), "_" to 1))
                                        } else {
                                            _cC("v-if", true)
                                        }
                                    )),
                                    _cE("view", _uM("class" to "inputorder display-flex"), _uA(
                                        _cE("view", _uM("class" to "display-flex"), _uA(
                                            _cV(_component_x_iconfont, _uM("class" to "icon", "name" to "wenjian", "color" to "#1776FC", "size" to "18")),
                                            _cE("text", _uM("class" to "text color-main"), "文件识别")
                                        )),
                                        _cE("view", _uM("class" to "display-flex", "style" to _nS(_uM("margin-left" to "8px")), "onClick" to chooseSupplier), _uA(
                                            _cV(_component_x_iconfont, _uM("class" to "icon", "name" to "tianjia", "color" to "#1776FC", "size" to "18")),
                                            _cE("text", _uM("class" to "text color-main"), "添加供应商")
                                        ), 4)
                                    ))
                                )),
                                if (unref(supplierList).length < 1) {
                                    _cE("view", _uM("key" to 0, "class" to "emptybox display-flex margin-center"), _uA(
                                        _cV(_component_x_iconfont, _uM("name" to "zanwushuju", "color" to "#C4C4C4", "size" to "24")),
                                        _cE("text", _uM("class" to "emptytext"), "暂无数据")
                                    ))
                                } else {
                                    _cE("view", _uM("key" to 1, "class" to "amount-cash display-flex"), _uA(
                                        _cE("view", _uM("class" to "gongys"), _uA(
                                            _cE("text", _uM("class" to "title align-center"), "供应商"),
                                            _cE(Fragment, null, RenderHelpers.renderList(unref(supplierList), fun(item, index, __index, _cached): Any {
                                                return _cE("view", _uM("class" to "datalist display-flex", "key" to index), _uA(
                                                    _cV(_component_x_iconfont, _uM("name" to "jian", "color" to "#ff0000", "size" to "16", "height" to 20, "style" to _nS(_uM("margin-right" to "6px")), "onClick" to fun(){
                                                        deleteSupplier(index)
                                                    }
                                                    ), null, 8, _uA(
                                                        "style",
                                                        "onClick"
                                                    )),
                                                    _cV(_component_x_triangleinput, _uM("width" to 200, "height" to 20, "border-color" to "#1776FC", "size" to 8), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                        return _uA(
                                                            _cE("text", _uM("class" to "company textinput overline"), _tD(item["name"]), 1)
                                                        )
                                                    }
                                                    ), "_" to 2), 1024),
                                                    if (supplierPaid(item) <= 0) {
                                                        _cE("text", _uM("key" to 0, "class" to "tag nopay"), "未付")
                                                    } else {
                                                        _cC("v-if", true)
                                                    }
                                                    ,
                                                    if (isTrue(supplierPaid(item) < supplierPrice(item) && supplierPaid(item) > 0)) {
                                                        _cE("text", _uM("key" to 1, "class" to "tag bfpay"), "部分")
                                                    } else {
                                                        _cC("v-if", true)
                                                    }
                                                    ,
                                                    if (supplierPaid(item) >= supplierPrice(item)) {
                                                        _cE("text", _uM("key" to 2, "class" to "tag yfpay"), "已付")
                                                    } else {
                                                        _cC("v-if", true)
                                                    }
                                                ))
                                            }
                                            ), 128)
                                        )),
                                        _cE("view", _uM("class" to "dataitems"), _uA(
                                            _cE("scroll-view", _uM("class" to "scorll", "direction" to "horizontal", "show-scrollbar" to false), _uA(
                                                _cE("view", _uM("class" to "datatitle display-flex"), _uA(
                                                    _cE("text", _uM("class" to "titleitem danpin"), "单品数"),
                                                    _cE("text", _uM("class" to "titleitem yingfu"), "应付货款"),
                                                    _cE("text", _uM("class" to "titleitem yifuk"), "已付货款"),
                                                    _cE("text", _uM("class" to "titleitem qiankuan"), "欠款"),
                                                    _cE("text", _uM("class" to "titleitem jiesuan"), "结算日期")
                                                )),
                                                _cE(Fragment, null, RenderHelpers.renderList(unref(supplierList), fun(item, index, __index, _cached): Any {
                                                    return _cE("view", _uM("class" to "datanum display-flex", "key" to index), _uA(
                                                        _cE("view", _uM("class" to "danpin"), _uA(
                                                            _cV(_component_x_triangleinput, _uM("width" to 44, "height" to 20, "border-color" to "#1776FC", "unit" to "px", "size" to 8), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                return _uA(
                                                                    _cE("text", _uM("class" to "text overline"), _tD(item["number"]), 1)
                                                                )
                                                            }
                                                            ), "_" to 2), 1024)
                                                        )),
                                                        _cE("view", _uM("class" to "yingfutext display-flex yingfu"), _uA(
                                                            _cV(_component_x_triangleinput, _uM("width" to 60, "height" to 20, "border-color" to "#1776FC", "unit" to "px", "size" to 8), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                return _uA(
                                                                    _cE("view", _uM("class" to "amountinput"), _uA(
                                                                        _cE("text", _uM("class" to "fuhao"), "￥"),
                                                                        _cE("input", _uM("type" to "digit", "style" to _nS(_uM("width" to "50px")), "value" to item["price"], "onInput" to fun(`$event`: UniInputEvent){
                                                                            bindSupPriceInput(index, `$event`)
                                                                        }
                                                                        , "class" to "amounti"), null, 44, _uA(
                                                                            "value",
                                                                            "onInput"
                                                                        ))
                                                                    ))
                                                                )
                                                            }
                                                            ), "_" to 2), 1024),
                                                            _cE("text", _uM("class" to "kuantag quankuan color-white background-main", "onClick" to fun(){
                                                                quankuan(index)
                                                            }
                                                            ), "全款", 8, _uA(
                                                                "onClick"
                                                            ))
                                                        )),
                                                        _cE("view", _uM("class" to "yifuk"), _uA(
                                                            _cV(_component_x_triangleinput, _uM("width" to 80, "height" to 20, "border-color" to "#1776FC", "unit" to "px", "size" to 8), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                return _uA(
                                                                    _cE("view", _uM("class" to "amountinput"), _uA(
                                                                        _cE("text", _uM("class" to "fuhao"), "￥"),
                                                                        _cE("input", _uM("type" to "digit", "style" to _nS(_uM("width" to "70px")), "value" to supplierPaid(item), "class" to "amounti", "onInput" to fun(`$event`: UniInputEvent){
                                                                            bindSupAmountInput(index, `$event`)
                                                                        }
                                                                        ), null, 44, _uA(
                                                                            "value",
                                                                            "onInput"
                                                                        ))
                                                                    ))
                                                                )
                                                            }
                                                            ), "_" to 2), 1024)
                                                        )),
                                                        _cE("view", _uM("class" to "qiankuan"), _uA(
                                                            _cV(_component_x_triangleinput, _uM("width" to 60, "height" to 20, "border-color" to "#FF5733", "size" to 8, "j-color" to "#FF5733", "unit" to "px"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                return _uA(
                                                                    _cE("view", _uM("class" to "amountinput"), _uA(
                                                                        _cE("text", _uM("class" to "fuhao"), "￥"),
                                                                        _cE("text", _uM("class" to "amountnum color-red"), _tD(supplierDebt(item)), 1)
                                                                    ))
                                                                )
                                                            }
                                                            ), "_" to 2), 1024)
                                                        )),
                                                        _cE("view", _uM("class" to "jiesuan"), _uA(
                                                            _cV(_component_x_triangleinput, _uM("width" to 70, "height" to 20, "border-color" to "#1776FC", "unit" to "px", "onClick" to fun(){
                                                                chooseDate(index)
                                                            }
                                                            , "size" to 8), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                return _uA(
                                                                    _cE("text", _uM("class" to "text overline align-center"), _tD(item["date"]), 1)
                                                                )
                                                            }
                                                            ), "_" to 2), 1032, _uA(
                                                                "onClick"
                                                            ))
                                                        ))
                                                    ))
                                                }
                                                ), 128)
                                            ))
                                        ))
                                    ))
                                }
                            )),
                            _cV(_component_x_remarkbox, _uM("ref_key" to "orderremark", "ref" to orderremark), null, 512)
                        ))
                    )),
                    _cV(_component_x_remarkwindow, _uM("ref_key" to "remarkwindow", "ref" to remarkwindow, "onAddRemark" to addRemarkContent, "onCloseWindow" to closeWindow, "remark" to unref(remark)), null, 8, _uA(
                        "remark"
                    )),
                    _cV(_component_x_order_action, _uM("btn2" to "入库", "active" to (unref(goodsList).length > 0 && unref(supplierList).length > 0), "onDraft" to draftOrder, "onSubmit" to submitOrder), null, 8, _uA(
                        "active"
                    )),
                    _cV(_component_x_model, _uM("ref_key" to "model", "ref" to model), null, 512),
                    _cV(_component_x_choosedate, _uM("ref_key" to "choosedate", "ref" to choosedate, "now" to unref(chooseDateStr)), null, 8, _uA(
                        "now"
                    )),
                    _cV(_component_x_signer, _uM("ref_key" to "signer", "ref" to signer), null, 512),
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
                return _uM("name" to _uM(".handles " to _uM("fontSize" to 14, "paddingLeft" to "8rpx"), ".goodslist .title " to _uM("height" to 26), ".list .item .basicdata .nameinfo " to _uM("maxWidth" to "450rpx", "fontSize" to 12, "lineHeight" to "18px")), "addbtn" to _uM(".handles " to _uM("marginRight" to "26rpx")), "placeholder" to _pS(_uM("color" to "#878787")), "basicbox" to _pS(_uM("paddingTop" to 3, "paddingLeft" to "20rpx", "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#e8e8e8")), "lineitem" to _uM(".basicbox " to _uM("height" to 35)), "title" to _uM(".basicbox .lineitem .linebox " to _uM("lineHeight" to "35px", "width" to "140rpx", "fontSize" to 14, "textAlign" to "right", "color" to "#ABABAB"), ".goodslist " to _uM("borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#f5f5f5", "paddingBottom" to 6, "paddingTop" to 4), ".goodslist .amount-cash .gongys " to _uM("color" to "#878787", "fontSize" to 11), ".list .item .updateinput .titles " to _uM("width" to "33.3%", "fontSize" to 12)), "changbox" to _uM(".basicbox .lineitem .linebox " to _uM("marginLeft" to "60rpx", "width" to "480rpx")), "text" to _uM(".basicbox .lineitem .linebox .changbox " to _uM("lineHeight" to "35px", "fontSize" to 14, "textAlign" to "left"), ".goodslist .title .name " to _uM("color" to "#ABABAB", "fontSize" to 12, "lineHeight" to "26px"), ".goodslist .title .inputorder " to _uM("fontSize" to 12, "paddingLeft" to "4rpx", "paddingTop" to 2), ".goodslist .amount-cash .dataitems .datanum " to _uM("lineHeight" to "20px", "fontSize" to 12)), "icon" to _uM(".basicbox .lineitem .linebox .changbox " to _uM("paddingTop" to 10)), "goodslist" to _pS(_uM("width" to "750rpx", "minHeight" to 130, "borderTopWidth" to 1, "borderTopStyle" to "solid", "borderTopColor" to "#e8e8e8", "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#e8e8e8", "marginTop" to 7, "paddingLeft" to "15rpx", "paddingRight" to "15rpx")), "addlist" to _uM(".goodslist .title .name " to _uM("marginLeft" to 10, "height" to 26, "paddingLeft" to 5, "paddingRight" to 5, "lineHeight" to "26px", "fontSize" to 12)), "text2" to _uM(".goodslist .title .name " to _uM("fontSize" to 14, "lineHeight" to "26px", "paddingLeft" to "8rpx")), "bianji" to _uM(".goodslist .title .name " to _uM("paddingTop" to 4)), "wenhao" to _uM(".goodslist .title .name " to _uM("paddingLeft" to "8rpx", "paddingTop" to 4)), "inputorder" to _uM(".goodslist .title " to _uM("paddingTop" to 6)), "emptybox" to _uM(".goodslist " to _uM("width" to "200rpx", "paddingTop" to 30)), "emptytext" to _uM(".goodslist .emptybox " to _uM("color" to "#c4c4c4", "fontSize" to 16, "paddingTop" to 2, "paddingLeft" to "10rpx")), "gongys" to _uM(".goodslist .amount-cash " to _uM("width" to "330rpx", "borderRightWidth" to 1, "borderRightStyle" to "solid", "borderRightColor" to "#f5f5f5")), "company" to _uM(".goodslist .amount-cash .gongys .datalist " to _uM("height" to 20, "fontSize" to 11, "color" to "#000000", "lineHeight" to "20px")), "tag" to _uM(".goodslist .amount-cash .gongys .datalist " to _uM("fontSize" to 10, "width" to 30, "height" to 13, "marginTop" to 5, "marginLeft" to "5rpx", "lineHeight" to "12px", "borderTopLeftRadius" to 3, "borderTopRightRadius" to 3, "borderBottomRightRadius" to 3, "borderBottomLeftRadius" to 3, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#000000", "borderRightColor" to "#000000", "borderBottomColor" to "#000000", "borderLeftColor" to "#000000", "textAlign" to "center")), "nopay" to _uM(".goodslist .amount-cash .gongys .datalist " to _uM("borderTopColor" to "#FF5733", "borderRightColor" to "#FF5733", "borderBottomColor" to "#FF5733", "borderLeftColor" to "#FF5733", "color" to "#FF5733")), "bfpay" to _uM(".goodslist .amount-cash .gongys .datalist " to _uM("borderTopColor" to "#ffad20", "borderRightColor" to "#ffad20", "borderBottomColor" to "#ffad20", "borderLeftColor" to "#ffad20", "color" to "#ffad20")), "yfpay" to _uM(".goodslist .amount-cash .gongys .datalist " to _uM("borderTopColor" to "#6eff00", "borderRightColor" to "#6eff00", "borderBottomColor" to "#6eff00", "borderLeftColor" to "#6eff00", "color" to "#6eff00")), "dataitems" to _uM(".goodslist .amount-cash " to _uM("width" to "390rpx")), "scorll" to _uM(".goodslist .amount-cash .dataitems " to _uM("width" to "430rpx")), "datatitle" to _uM(".goodslist .amount-cash .dataitems .scorll " to _uM("height" to 20, "width" to 530)), "titleitem" to _uM(".goodslist .amount-cash .dataitems .scorll .datatitle " to _uM("fontSize" to 11, "lineHeight" to "20px", "color" to "#878787", "textAlign" to "center")), "danpin" to _uM(".goodslist .amount-cash .dataitems .scorll " to _uM("marginLeft" to 10, "width" to 44)), "yingfu" to _uM(".goodslist .amount-cash .dataitems .scorll " to _uM("marginLeft" to 10, "width" to 100)), "kuantag" to _uM(".goodslist .amount-cash .dataitems .scorll .yingfu " to _uM("borderTopWidth" to 0, "borderRightWidth" to 0, "borderBottomWidth" to 0, "borderLeftWidth" to 0, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#000000", "borderRightColor" to "#000000", "borderBottomColor" to "#000000", "borderLeftColor" to "#000000", "fontSize" to 10, "width" to 36, "height" to 17, "borderTopLeftRadius" to 1, "borderTopRightRadius" to 1, "borderBottomRightRadius" to 1, "borderBottomLeftRadius" to 1, "lineHeight" to "17px", "textAlign" to "center", "marginTop" to 2, "marginLeft" to 3)), "yifuk" to _uM(".goodslist .amount-cash .dataitems .scorll " to _uM("marginLeft" to 12, "width" to 80)), "qiankuan" to _uM(".goodslist .amount-cash .dataitems .scorll " to _uM("marginLeft" to 16, "width" to 60)), "jiesuan" to _uM(".goodslist .amount-cash .dataitems .scorll " to _uM("marginLeft" to 20, "width" to 70)), "fukuan" to _uM(".goodslist .amount-cash .dataitems .scorll " to _uM("width" to 70, "marginLeft" to 20)), "datanum" to _uM(".goodslist .amount-cash .dataitems " to _uM("height" to 20, "width" to 530, "marginTop" to 2)), "amountinput" to _uM(".goodslist .amount-cash .dataitems .datanum " to _uM("display" to "flex", "flexDirection" to "row")), "fuhao" to _uM(".goodslist .amount-cash .dataitems .datanum .amountinput " to _uM("width" to 10, "lineHeight" to "20px", "fontSize" to 10)), "amounti" to _uM(".goodslist .amount-cash .dataitems .datanum .amountinput " to _uM("fontSize" to 11, "height" to 20)), "amountnum" to _uM(".goodslist .amount-cash .dataitems .datanum .amountinput " to _uM("lineHeight" to "20px", "fontSize" to 11)), "total" to _pS(_uM("paddingLeft" to "12rpx")), "heji" to _uM(".total " to _uM("lineHeight" to "50px", "fontSize" to 13, "color" to "#000000", "width" to "150rpx")), "amount" to _uM(".total " to _uM("lineHeight" to "50px", "paddingLeft" to "16rpx", "color" to "#ff8f1a", "fontSize" to 18, "width" to "150rpx")), "basicdata" to _uM(".list .item " to _uM("borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#F5F5F5", "height" to 20)), "stock" to _uM(".list .item .basicdata " to _uM("lineHeight" to "18px", "fontSize" to 12, "color" to "#919191")), "priceinfo" to _uM(".list .item " to _uM("paddingTop" to 3, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#F5F5F5", "marginBottom" to 6, "height" to 20)), "xiangxiaicon" to _uM(".list .item .priceinfo " to _uM("marginTop" to 1)), "tagbox" to _uM(".list .item .priceinfo .remark " to _uM("width" to 30, "height" to 16, "borderTopLeftRadius" to 2, "borderTopRightRadius" to 2, "borderBottomRightRadius" to 2, "borderBottomLeftRadius" to 2, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#1776FC", "borderRightColor" to "#1776FC", "borderBottomColor" to "#1776FC", "borderLeftColor" to "#1776FC", "fontSize" to 11, "lineHeight" to "14px")), "overline" to _uM(".list .item .priceinfo .remark " to _uM("maxWidth" to "250rpx", "fontSize" to 11, "marginLeft" to "10rpx", "color" to "#919191")), "input" to _uM(".list .item .priceinfo .priceinfocontent .price " to _uM("fontSize" to 12, "color" to "#FF5029"), ".list .item .updateinput .inputs " to _uM("width" to "30%", "marginRight" to "3.3%", "fontSize" to 12, "backgroundImage" to "none", "backgroundColor" to "#FFFFFF", "height" to 22, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#1776FC")), "yugu" to _uM(".list .item .priceinfo .priceinfocontent .price " to _uM("fontSize" to 12)), "number" to _uM(".list .item .priceinfo .priceinfocontent " to _uM("marginLeft" to "20rpx", "fontSize" to 12)), "updateinput" to _uM(".list .item " to _uM("backgroundImage" to "none", "backgroundColor" to "#EBEBEB", "width" to "710rpx", "marginLeft" to "20rpx", "height" to 54, "marginBottom" to 10)), "inputs" to _uM(".list .item .updateinput " to _uM("marginLeft" to "3.3%")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
