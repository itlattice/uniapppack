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
open class GenPagesWarehouseRequiregoodsAddrequiregoods : BasePage {
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
        var setup: (__props: GenPagesWarehouseRequiregoodsAddrequiregoods) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesWarehouseRequiregoodsAddrequiregoods
            val _cache = __ins.renderCache
            val depart = ref(_uO())
            val goodsList = ref(_uA<requiregoodsinfo>())
            val openIndex = ref(-1)
            val selectedGoods = ref(_uA<UTSJSONObject>())
            val pageHeight = ref(0)
            val haveCache = ref(false)
            val orderremark = ref<UniElement?>(null)
            val remarkwindow = ref<UniElement?>(null)
            val signer = ref<UniElement?>(null)
            val loading = ref<UniElement?>(null)
            val selectList = computed(fun(): UTSJSONObject {
                return _uO("list" to selectedGoods.value)
            }
            )
            val total = computed(fun(): Number {
                var sum: Number = 0
                for(item in resolveUTSValueIterator(goodsList.value)){
                    sum += item.number
                }
                return sum
            }
            )
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
            val loadCache = fun(){
                var cacheData = common.getStorage("requiregoods")
                if (cacheData == "") {
                    return
                }
                cacheData = cacheData as UTSJSONObject
                console.log("加载到缓存", cacheData)
                var list = cacheData["goods"] as UTSArray<UTSJSONObject>
                goodsList.value = _uA<requiregoodsinfo>()
                for(item in resolveUTSValueIterator(list)){
                    goodsList.value.push(requiregoodsinfo(goodsinfo = item["goodsinfo"] as UTSJSONObject, number = item["number"] as Number, stock = item["stock"] as Number, id = item["id"] as Number, remark = if (item["remark"] == null) {
                        null
                    } else {
                        (item["remark"] as String)
                    }
                    ))
                }
                depart.value = cacheData["depart"] as UTSJSONObject
                uni__emit("setremarkbox", _uO("remark" to cacheData["remark"] as String, "thumb" to cacheData["thumb"] as UTSArray<UTSJSONObject>))
                haveCache.value = true
                common.rmStorage("requiregoods")
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
                        var data: UTSJSONObject = _uO("depart" to depart.value, "goods" to goodsList.value, "remark" to remarkbox["remark"] as String, "thumb" to remarkbox["file"] as UTSArray<UTSJSONObject>)
                        return@w1 data
                })
            }
            val submit = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var data = await(getData())
                        console.log(data)
                        if (data == null) {
                            return@w1
                        }
                        var goods = JSON.parseArray(JSON.stringify(data["goods"])) as UTSArray<UTSJSONObject>
                        if (goods.length < 1) {
                            common.toast("请选择商品")
                            return@w1
                        }
                        var gl = _uA<UTSJSONObject>()
                        for(g in resolveUTSValueIterator(goods)){
                            gl.push(_uO("stock" to g["stock"] as Number, "number" to g["number"] as Number, "id" to g["id"] as Number, "remark" to g["remark"]))
                        }
                        data["goods"] = gl
                        var departData = data["depart"] as UTSJSONObject
                        if (departData["id"] == null) {
                            common.toast("请选择门店或仓库")
                            return@w1
                        }
                        console.log("提交信息", data)
                        var sign = await(common.signer(signer.value as Any))
                        console.log("签字信息", sign)
                        if (sign == null) {
                            return@w1
                        }
                        data["signer"] = sign
                        common.loading(loading.value)
                        var res = await(request.callapi("warehouse/addrequiregoods", data))
                        common.hideLoading(loading.value)
                        common.toast(res.msg)
                        if (res.code < 0) {
                            return@w1
                        }
                        cache.set("refreshrequiregoods", "ok", 10)
                        var orderID = (res.data as UTSJSONObject)["id"] as Number
                        common.timeToPage("/pages/warehouse/requiregoods/view?id=" + orderID.toString(), true)
                })
            }
            val draft = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var data = await(getData())
                        if (data == null) {
                            return@w1
                        }
                        console.log("草稿信息", data)
                        var goods = data["goods"] as UTSArray<UTSJSONObject>
                        if (goods.length < 1) {
                            common.toast("请选择商品")
                            return@w1
                        }
                        common.setStorage("requiregoods", data)
                        common.toast("保存草稿成功")
                        setTimeout(fun(){
                            common.back()
                        }
                        , 1500)
                })
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
            val chooseDepart = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var selectedDepart = await(common.navigatoEvent("/pages/common/choosedepart"))
                        if (selectedDepart["name"] == null) {
                            return@w1
                        }
                        depart.value = selectedDepart
                })
            }
            val openIndexAction = fun(index: Number){
                if (openIndex.value == index) {
                    openIndex.value = -1
                } else {
                    openIndex.value = index
                }
            }
            val bindNumberInput = fun(index: Number, e: UniInputEvent){
                if (e.detail.value == "") {
                    return
                }
                var number = UTSNumber.from(e.detail.value)
                goodsList.value[index].number = number
            }
            val addGoods = fun(goods: UTSArray<selectedListType>): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        console.log("收到商品信息")
                        var data = _uA<UTSJSONObject>()
                        for(g in resolveUTSValueIterator(goods)){
                            data.push(_uO("id" to g.id, "number" to g.number))
                        }
                        selectedGoods.value = goods as UTSArray<UTSJSONObject>
                        var res = await(request.callapi("goods/getpurchaseinfo", _uO("list" to data)))
                        if (res.code < 0) {
                            common.toast(res.msg)
                            return@w1
                        }
                        goodsList.value = _uA<requiregoodsinfo>()
                        for(item in resolveUTSKeyIterator((res.data as UTSArray<UTSJSONObject>))){
                            goodsList.value.push(requiregoodsinfo(goodsinfo = item["goodsinfo"] as UTSJSONObject, number = item["number"] as Number, id = item["id"] as Number, stock = item["stock"] as Number))
                        }
                })
            }
            val addRemark = fun(index: Number){
                openIndex.value = index
                common.callMethod(remarkwindow.value as Any, "open")
            }
            val closeWindow = fun(){
                common.callMethod(remarkwindow.value as Any, "close")
            }
            val addRemarkContent = fun(newRemark: String){
                goodsList.value[openIndex.value].remark = newRemark
                openIndex.value = -1
                closeWindow()
            }
            val clearCache = fun(){
                selectedGoods.value = _uA<UTSJSONObject>()
                goodsList.value = _uA<requiregoodsinfo>()
                getUserShop()
                uni__emit("clearremarkbox", null)
            }
            onLoad(fun(_options){
                getUserShop()
            }
            )
            onReady(fun(){
                pageHeight.value = uni_getWindowInfo().safeArea.height - 80
                loadCache()
            }
            )
            return fun(): Any? {
                val _component_x_viewtitle = resolveEasyComponent("x-viewtitle", GenComponentsXViewtitleClass)
                val _component_x_triangleinput = resolveEasyComponent("x-triangleinput", GenComponentsXTriangleinputClass)
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_x_addgoods = resolveEasyComponent("x-addgoods", GenComponentsXAddgoodsClass)
                val _component_x_remarkbox = resolveEasyComponent("x-remarkbox", GenComponentsXRemarkboxClass)
                val _component_x_remarkwindow = resolveEasyComponent("x-remarkwindow", GenComponentsXRemarkwindowClass)
                val _component_x_order_action = resolveEasyComponent("x-order-action", GenComponentsXOrderActionClass)
                val _component_x_signer = resolveEasyComponent("x-signer", GenComponentsXSignerClass)
                val _component_x_loading = resolveEasyComponent("x-loading", GenComponentsXLoadingClass)
                return _cE("view", null, _uA(
                    _cV(_component_x_viewtitle, _uM("title" to "创建要货单"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to "handles"), _uA(
                                if (isTrue(unref(haveCache))) {
                                    _cE("text", _uM("key" to 0, "class" to "name color-white", "onClick" to clearCache, "style" to _nS(_uM("line-height" to "35px", "font-size" to "14px", "padding-left" to "20rpx"))), "清空", 4)
                                } else {
                                    _cC("v-if", true)
                                }
                            ))
                        )
                    }
                    ), "_" to 1)),
                    _cE("scroll-view", _uM("direction" to "vertical", "style" to _nS(_uM("height" to (unref(pageHeight) + "px")))), _uA(
                        _cE("view", _uM("class" to "tasklist background-white width-full"), _uA(
                            _cE("view", _uM("class" to "lineitem"), _uA(
                                _cV(_component_x_triangleinput, _uM("height" to 35, "width" to 710), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cE("view", _uM("class" to "linebox display-flex"), _uA(
                                            _cE("text", _uM("class" to "title"), "要货店仓"),
                                            _cE("view", _uM("class" to "changbox", "onClick" to chooseDepart), _uA(
                                                if (isTrue(unref(depart)["name"])) {
                                                    _cE("text", _uM("key" to 0, "class" to "text"), _tD(unref(depart)["name"]), 1)
                                                } else {
                                                    _cE("text", _uM("key" to 1, "class" to "text placeholder"), "请选择要盘点的店/仓")
                                                }
                                            ))
                                        ))
                                    )
                                }
                                ), "_" to 1))
                            ))
                        )),
                        _cE("view", _uM("class" to "goodslist background-white"), _uA(
                            _cE("view", _uM("class" to "title space-between"), _uA(
                                if (unref(goodsList).length < 1) {
                                    _cE("view", _uM("key" to 0, "class" to "name"), _uA(
                                        _cE("text", _uM("class" to "text color-main"), "添加商品")
                                    ))
                                } else {
                                    _cE("view", _uM("key" to 1, "class" to "name display-flex"), _uA(
                                        _cV(_component_x_iconfont, _uM("class" to "bianji", "name" to "bianji1", "color" to "#1776FC", "size" to "16")),
                                        _cE("text", _uM("class" to "text2 color-main"), "编辑"),
                                        _cV(_component_x_iconfont, _uM("class" to "wenhao", "name" to "wenhao", "color" to "#C7C7C7", "size" to "16"))
                                    ))
                                }
                            )),
                            _cE("view", _uM("class" to "list"), _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(unref(goodsList), fun(item, index, __index, _cached): Any {
                                    return _cE("view", _uM("class" to "item", "key" to index), _uA(
                                        _cE("view", _uM("class" to "basicdata space-between"), _uA(
                                            _cE("view", _uM("class" to "nameinfo display-flex"), _uA(
                                                _cE("text", _uM("class" to "name overline"), _tD(item.goodsinfo["name"]) + "（" + _tD(item.goodsinfo["code"]) + "）", 1),
                                                _cV(_component_x_iconfont, _uM("name" to "bianjibiaoge", "onClick" to fun(){
                                                    openIndexAction(index)
                                                }
                                                , "color" to "#1776FC", "size" to "15", "class" to "bianjitable"), null, 8, _uA(
                                                    "onClick"
                                                ))
                                            )),
                                            _cE("text", _uM("class" to "stock"), "当前库存:" + _tD(if (item.stock > 0) {
                                                item.stock
                                            } else {
                                                "-"
                                            }
                                            ), 1)
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
                                                    _cE("text", _uM("class" to "yugu"), "要货数量"),
                                                    _cE("text", _uM("class" to "input"), _tD(item.number), 1)
                                                ))
                                            ), 8, _uA(
                                                "onClick"
                                            )),
                                            _cV(_component_x_iconfont, _uM("class" to "xiangxiaicon", "onClick" to fun(){
                                                openIndexAction(index)
                                            }
                                            , "name" to if (unref(openIndex) != index) {
                                                "xiangxia"
                                            } else {
                                                "xiangshang"
                                            }
                                            , "size" to "13", "color" to "#C4C4C4"), null, 8, _uA(
                                                "onClick",
                                                "name"
                                            ))
                                        )),
                                        if (unref(openIndex) == index) {
                                            _cE("view", _uM("key" to 0, "class" to "updateinput"), _uA(
                                                _cE("view", _uM("class" to "titles display-flex"), _uA(
                                                    _cE("text", _uM("class" to "title align-center"), "数量")
                                                )),
                                                _cE("view", _uM("class" to "inputs display-flex"), _uA(
                                                    _cE("input", _uM("type" to "digit", "class" to "input align-center", "onInput" to fun(`$event`: UniInputEvent){
                                                        bindNumberInput(index, `$event`)
                                                    }, "value" to item.number), null, 40, _uA(
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
                            _cV(_component_x_addgoods, _uM("onAddGoods" to addGoods, "selected" to unref(selectList)), null, 8, _uA(
                                "selected"
                            ))
                        )),
                        _cV(_component_x_remarkbox, _uM("ref_key" to "orderremark", "ref" to orderremark), null, 512),
                        _cV(_component_x_remarkwindow, _uM("ref_key" to "remarkwindow", "ref" to remarkwindow, "onAddRemark" to addRemarkContent, "onCloseWindow" to closeWindow, "remark" to unref(remark)), null, 8, _uA(
                            "remark"
                        ))
                    ), 4),
                    _cV(_component_x_order_action, _uM("btn2" to "提交", "active" to (unref(goodsList).length > 0), "onSubmit" to submit, "onDraft" to draft), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to "total display-flex"), _uA(
                                _cE("text", _uM("class" to "heji"), "合计：" + _tD(unref(total)) + "件", 1),
                                _cE("text", _uM("class" to "heji", "style" to _nS(_uM("padding-left" to "20rpx"))), "品类：" + _tD(unref(goodsList).length), 5)
                            ))
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "active"
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
                return _uM("tasklist" to _pS(_uM("paddingTop" to 3, "paddingLeft" to "20rpx", "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#e8e8e8", "marginBottom" to 10)), "lineitem" to _uM(".tasklist " to _uM("height" to 35)), "title" to _uM(".tasklist .lineitem .linebox " to _uM("lineHeight" to "35px", "width" to "140rpx", "fontSize" to 14, "textAlign" to "right", "color" to "#ABABAB"), ".goodslist " to _uM("borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#f5f5f5", "paddingBottom" to 6, "paddingTop" to 4), ".list .item .updateinput .titles " to _uM("width" to "33.3%", "fontSize" to 12)), "changbox" to _uM(".tasklist .lineitem .linebox " to _uM("marginLeft" to "60rpx", "width" to "480rpx", "height" to 35)), "nameinput" to _uM(".tasklist .lineitem .linebox .changbox " to _uM("fontSize" to 14, "width" to "430rpx")), "text" to _uM(".tasklist .lineitem .linebox .changbox " to _uM("lineHeight" to "35px", "fontSize" to 14, "textAlign" to "left"), ".goodslist .title .name " to _uM("color" to "#ABABAB", "fontSize" to 12, "lineHeight" to "26px")), "placeholder" to _uM(".tasklist .lineitem .linebox .changbox " to _uM("color" to "#9c9c9c")), "icon" to _uM(".tasklist .lineitem .linebox .changbox " to _uM("paddingTop" to 10)), "goodslist" to _pS(_uM("width" to "750rpx", "minHeight" to 130, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#e8e8e8", "paddingLeft" to "15rpx", "paddingRight" to "15rpx")), "name" to _uM(".goodslist .title " to _uM("height" to 26), ".list .item .basicdata .nameinfo " to _uM("maxWidth" to "450rpx", "fontSize" to 12, "lineHeight" to "18px")), "text2" to _uM(".goodslist .title .name " to _uM("fontSize" to 14, "lineHeight" to "26px", "paddingLeft" to "8rpx")), "bianji" to _uM(".goodslist .title .name " to _uM("paddingTop" to 4)), "wenhao" to _uM(".goodslist .title .name " to _uM("paddingLeft" to "8rpx", "paddingTop" to 4)), "basicdata" to _uM(".list .item " to _uM("borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#F5F5F5", "height" to 20)), "stock" to _uM(".list .item .basicdata " to _uM("lineHeight" to "18px", "fontSize" to 12, "color" to "#919191")), "priceinfo" to _uM(".list .item " to _uM("paddingTop" to 3, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#F5F5F5", "marginBottom" to 6, "height" to 20)), "xiangxiaicon" to _uM(".list .item .priceinfo " to _uM("marginTop" to 1)), "tagbox" to _uM(".list .item .priceinfo .remark " to _uM("width" to 30, "height" to 16, "borderTopLeftRadius" to 2, "borderTopRightRadius" to 2, "borderBottomRightRadius" to 2, "borderBottomLeftRadius" to 2, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#1776FC", "borderRightColor" to "#1776FC", "borderBottomColor" to "#1776FC", "borderLeftColor" to "#1776FC", "fontSize" to 11, "lineHeight" to "14px")), "overline" to _uM(".list .item .priceinfo .remark " to _uM("maxWidth" to "250rpx", "fontSize" to 11, "marginLeft" to "10rpx", "color" to "#919191")), "input" to _uM(".list .item .priceinfo .priceinfocontent .price " to _uM("fontSize" to 12, "color" to "#FF5029"), ".list .item .updateinput .inputs " to _uM("width" to "30%", "marginRight" to "3.3%", "fontSize" to 12, "backgroundImage" to "none", "backgroundColor" to "#FFFFFF", "height" to 22, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#1776FC")), "yugu" to _uM(".list .item .priceinfo .priceinfocontent .price " to _uM("fontSize" to 12)), "number" to _uM(".list .item .priceinfo .priceinfocontent " to _uM("marginLeft" to "20rpx", "fontSize" to 12)), "updateinput" to _uM(".list .item " to _uM("backgroundImage" to "none", "backgroundColor" to "#EBEBEB", "width" to "710rpx", "marginLeft" to "20rpx", "height" to 54, "marginBottom" to 10)), "inputs" to _uM(".list .item .updateinput " to _uM("marginLeft" to "3.3%")), "total" to _pS(_uM("paddingLeft" to "12rpx")), "heji" to _uM(".total " to _uM("lineHeight" to "50px", "fontSize" to 13, "color" to "#000000", "width" to "150rpx")), "amount" to _uM(".total " to _uM("lineHeight" to "50px", "paddingLeft" to "16rpx", "color" to "#ff8f1a", "fontSize" to 18, "width" to "150rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
