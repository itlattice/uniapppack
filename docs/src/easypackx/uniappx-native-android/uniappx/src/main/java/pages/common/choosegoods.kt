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
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
open class GenPagesCommonChoosegoods : BasePage {
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
        var setup: (__props: GenPagesCommonChoosegoods) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCommonChoosegoods
            val _cache = __ins.renderCache
            val pageHeight = ref(0)
            val keywords = ref("")
            val page = ref(1)
            val pageMax = ref(1000)
            val list = ref(_uA<UTSJSONObject>())
            val num = ref(1 as Number)
            val sort = ref(_uO("sale" to "none", "update" to "none", "price" to "none"))
            val loading = ref(false)
            val sortKeyArr = _uA(
                "none",
                "max",
                "min"
            )
            val visible = ref(false)
            val activeGoods = ref(_uO())
            val selectedList = ref(_uA<selectedListType>())
            val selectedCount = ref(0)
            val select = ref(_uA<UTSJSONObject>())
            val submitBool = ref(false)
            val departID = ref("0")
            val paging = ref<UniElement?>(null)
            val numberWindow = ref<UniElement?>(null)
            val noMoreData = computed(fun(): Boolean {
                return loading.value == false && list.value.length > 0 && pageMax.value <= page.value
            }
            )
            val noData = computed(fun(): Boolean {
                return loading.value == false && list.value.length < 1 && pageMax.value <= 1
            }
            )
            val back = fun(){
                uni__off("/pages/common/choosegoods", null)
                common.back()
            }
            val numberChange = fun(id: Number, changedNum: String){
                console.log(selectedList.value)
                run {
                    var i: Number = 0
                    while(i < selectedList.value.length){
                        var item = selectedList.value[i] as selectedListType
                        if (item.id == id) {
                            selectedList.value[i].number = UTSNumber.from(changedNum)
                        }
                        i++
                    }
                }
            }
            val closePopup = fun(){
                visible.value = false
            }
            val showSelected = fun(){
                visible.value = true
            }
            val closeSelected = fun(){
                visible.value = false
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
            val search = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        loading.value = true
                        var res = await(request.callapi("goods/list", _uO("sort" to sort.value, "keywords" to keywords.value, "page" to page.value, "depart" to departID.value)))
                        loading.value = false
                        if (res.code < 0) {
                            common.toast(res.msg)
                            list.value = _uA()
                            pageMax.value = 0
                            return@w1
                        }
                        pageMax.value = res.info["maxPage"] as Number
                        if (page.value == 1) {
                            list.value = res.data as UTSArray<UTSJSONObject>
                        } else {
                            list.value = list.value.concat(res.data as UTSArray<UTSJSONObject>)
                        }
                })
            }
            val refresh = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        page.value = 1
                        pageMax.value = 1000
                        await(search())
                        (paging.value as ComponentPublicInstance).`$callMethod`("closeRefresh")
                })
            }
            val loadPageData = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        await(refresh())
                })
            }
            val clickGoods = fun(goods: UTSJSONObject){
                activeGoods.value = goods
                console.log("返回")
                (numberWindow.value as ComponentPublicInstance).`$callMethod`("open")
            }
            val closeWindow = fun(){
                common.callMethod(numberWindow.value as Any, "close")
                num.value = 1
                activeGoods.value = _uO()
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
            }
            val nextPage = fun(){
                if (page.value >= pageMax.value) {
                    return
                }
                page.value++
                search()
            }
            val checkSort = fun(key: String){
                var k = sort.value[key]
                var index = sortKeyArr.indexOf(k)
                console.log(k, index)
                if (index >= 2) {
                    index = -1
                }
                index++
                sort.value[key] = sortKeyArr[index]
                refresh()
            }
            val submitGoods = fun(){
                if (submitBool.value == false) {
                    submitBool.value = true
                    var result: UTSJSONObject = _uO("data" to selectedList.value)
                    uni__emit("/pages/common/choosegoods", result)
                    setTimeout(fun(){
                        submitBool.value = false
                    }
                    , 10)
                }
            }
            onLoad(fun(options: OnLoadOptions){
                var str = options["str"] as String
                var json = JSON.parseObject(str) as UTSJSONObject
                if (json["list"] != null) {
                    select.value = json["list"] as UTSArray<UTSJSONObject>
                }
                departID.value = options["depart"].toString()
                if (departID.value == "null") {
                    departID.value = "0"
                }
                pageHeight.value = uni_getWindowInfo().windowHeight - 130
                for(item in resolveUTSValueIterator(select.value)){
                    selectedList.value.push(selectedListType(id = item["id"] as Number, number = item["number"] as Number, goods = item["goods"] as UTSJSONObject))
                }
                selectedCount.value = selectedList.value.length
                loadPageData()
            }
            )
            onUnload(fun(){
                uni__off("/pages/common/choosegoods", null)
            }
            )
            return fun(): Any? {
                val _component_x_choosetitle = resolveEasyComponent("x-choosetitle", GenComponentsXChoosetitleClass)
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_x_goods = resolveEasyComponent("x-goods", GenComponentsXGoodsClass)
                val _component_x_buttom_loading = resolveEasyComponent("x-buttom-loading", GenComponentsXButtomLoadingClass)
                val _component_x_nomoredata = resolveEasyComponent("x-nomoredata", GenComponentsXNomoredataClass)
                val _component_x_empty = resolveEasyComponent("x-empty", GenComponentsXEmptyClass)
                val _component_x_paging = resolveEasyComponent("x-paging", GenComponentsXPagingClass)
                val _component_x_numberwindow = resolveEasyComponent("x-numberwindow", GenComponentsXNumberwindowClass)
                val _component_x_selected_goods = resolveEasyComponent("x-selected-goods", GenComponentsXSelectedGoodsClass)
                val _component_fui_bottom_popup = resolveEasyComponent("fui-bottom-popup", GenUniModulesFirstuiUvueComponentsFuiBottomPopupFuiBottomPopupClass)
                return _cE("view", null, _uA(
                    _cV(_component_x_choosetitle, _uM("title" to "选择商品", "page" to "/pages/common/choosegoods", "onBack" to back)),
                    _cE("view", _uM("class" to "searchbox background-white display-flex"), _uA(
                        _cE("view", _uM("class" to "searchinput display-flex background-page"), _uA(
                            _cV(_component_x_iconfont, _uM("class" to "sousuo", "name" to "sousuo", "size" to "16", "color" to "#c4c4c4", "height" to 26)),
                            _cE("input", _uM("type" to "text", "modelValue" to unref(keywords), "onInput" to fun(`$event`: UniInputEvent){
                                trySetRefValue(keywords, `$event`.detail.value)
                            }
                            , "confirm-type" to "search", "placeholder" to "名称/货号/条码", "class" to "input"), null, 40, _uA(
                                "modelValue"
                            ))
                        )),
                        _cV(_component_x_iconfont, _uM("name" to "saoyisao", "color" to "#1776FC", "size" to "24", "height" to 30, "class" to "saoyisao"))
                    )),
                    _cE("view", _uM("class" to "sortbox display-flex background-white"), _uA(
                        _cE("view", _uM("class" to "sortitem display-flex"), _uA(
                            _cE("text", _uM("class" to "text align-center"), "默认")
                        )),
                        _cE("view", _uM("class" to "sortitem margin-center display-flex"), _uA(
                            _cE("text", _uM("class" to "text", "style" to _nS(_uM("color" to if (unref(sort)["sale"] != "none") {
                                "#1776FC"
                            } else {
                                ""
                            }
                            )), "onClick" to fun(){
                                checkSort("sale")
                            }
                            ), "销量", 12, _uA(
                                "onClick"
                            )),
                            _cV(_component_x_iconfont, _uM("height" to 28, "name" to if (unref(sort)["sale"] == "max") {
                                "jiangxu"
                            } else {
                                "shengxu"
                            }
                            , "onClick" to fun(){
                                checkSort("sale")
                            }
                            , "class" to "icon", "size" to "16", "color" to if (unref(sort)["sale"] == "none") {
                                "#fff"
                            } else {
                                "#1776FC"
                            }
                            ), null, 8, _uA(
                                "name",
                                "onClick",
                                "color"
                            ))
                        )),
                        _cE("view", _uM("class" to "sortitem margin-center display-flex"), _uA(
                            _cE("text", _uM("class" to "text", "style" to _nS(_uM("color" to if (unref(sort)["update"] != "none") {
                                "#1776FC"
                            } else {
                                ""
                            }
                            )), "onClick" to fun(){
                                checkSort("update")
                            }
                            ), "更新时间", 12, _uA(
                                "onClick"
                            )),
                            _cV(_component_x_iconfont, _uM("height" to 28, "name" to if (unref(sort)["update"] == "max") {
                                "jiangxu"
                            } else {
                                "shengxu"
                            }
                            , "onClick" to fun(){
                                checkSort("update")
                            }
                            , "class" to "icon", "size" to "16", "color" to if (unref(sort)["update"] == "none") {
                                "#fff"
                            } else {
                                "#1776FC"
                            }
                            ), null, 8, _uA(
                                "name",
                                "onClick",
                                "color"
                            ))
                        )),
                        _cE("view", _uM("class" to "sortitem margin-center display-flex"), _uA(
                            _cE("text", _uM("class" to "text", "style" to _nS(_uM("color" to if (unref(sort)["price"] != "none") {
                                "#1776FC"
                            } else {
                                ""
                            }
                            )), "onClick" to fun(){
                                checkSort("price")
                            }
                            ), "价格", 12, _uA(
                                "onClick"
                            )),
                            _cV(_component_x_iconfont, _uM("height" to 28, "name" to if (unref(sort)["price"] == "max") {
                                "jiangxu"
                            } else {
                                "shengxu"
                            }
                            , "onClick" to fun(){
                                checkSort("price")
                            }
                            , "class" to "icon", "size" to "16", "color" to if (unref(sort)["price"] == "none") {
                                "#fff"
                            } else {
                                "#1776FC"
                            }
                            ), null, 8, _uA(
                                "name",
                                "onClick",
                                "color"
                            ))
                        ))
                    )),
                    _cV(_component_x_paging, _uM("ref_key" to "paging", "ref" to paging, "height" to unref(pageHeight), "onRefresh" to refresh, "onToLower" to nextPage), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", null, _uA(
                                _cE("view", _uM("class" to "goodslist"), _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(unref(list), fun(item, __key, __index, _cached): Any {
                                        return _cE("view", _uM("class" to "goods", "key" to item["id"]), _uA(
                                            _cV(_component_x_goods, _uM("goods" to item, "number" to getGoodsNumber(item), "onClickGoods" to fun(){
                                                clickGoods(item)
                                            }
                                            ), null, 8, _uA(
                                                "goods",
                                                "number",
                                                "onClickGoods"
                                            ))
                                        ))
                                    }
                                    ), 128)
                                )),
                                if (isTrue(unref(loading))) {
                                    _cV(_component_x_buttom_loading, _uM("key" to 0))
                                } else {
                                    _cC("v-if", true)
                                }
                                ,
                                if (isTrue(unref(noMoreData))) {
                                    _cV(_component_x_nomoredata, _uM("key" to 1))
                                } else {
                                    _cC("v-if", true)
                                }
                                ,
                                if (isTrue(unref(noData))) {
                                    _cV(_component_x_empty, _uM("key" to 2))
                                } else {
                                    _cC("v-if", true)
                                }
                                ,
                                _cE("view", _uM("style" to _nS(_uM("height" to "50px"))), null, 4)
                            ))
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "height"
                    )),
                    _cE("view", _uM("class" to "chooseaction display-flex position-fixed"), _uA(
                        _cE("text", _uM("class" to "number background-main align-center", "onClick" to showSelected), _uA(
                            _cV(_component_x_iconfont, _uM("class" to "align-center", "name" to "gouwuche", "onClick" to showSelected, "color" to "#fff", "size" to "18", "height" to 45)),
                            _cE("text", _uM("class" to "name color-white align-center", "onClick" to showSelected), "已选择(" + _tD(unref(selectedCount)) + ")", 1)
                        )),
                        _cE("view", _uM("class" to "okbtn", "onClick" to submitGoods), _uA(
                            _cE("text", _uM("class" to "name color-white align-center"), "选好了")
                        ))
                    )),
                    _cV(_component_x_numberwindow, _uM("ref_key" to "numberWindow", "ref" to numberWindow, "onAddGoods" to addGoods, "onCloseWindow" to closeWindow, "activeGoods" to unref(activeGoods)), null, 8, _uA(
                        "activeGoods"
                    )),
                    _cV(_component_fui_bottom_popup, _uM("visible" to unref(visible), "onClose" to closePopup, "radius" to 0), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to "goodsnumbermodal background-white padding-safe-bottom", "style" to _nS(_uM("height" to (unref(pageHeight) + "px")))), _uA(
                                _cE("scroll-view", _uM("style" to _nS(_uM("height" to ((unref(pageHeight) - 50) + "px"))), "direction" to "vertical"), _uA(
                                    _cE("view", _uM("class" to "selectedlist"), _uA(
                                        _cE(Fragment, null, RenderHelpers.renderList(unref(selectedList), fun(item, __key, __index, _cached): Any {
                                            return _cE("view", _uM("class" to "selecteditem", "key" to item.id), _uA(
                                                _cV(_component_x_selected_goods, _uM("goods" to item, "onNumberChange" to numberChange), null, 8, _uA(
                                                    "goods"
                                                ))
                                            ))
                                        }
                                        ), 128)
                                    ))
                                ), 4),
                                _cE("view", _uM("class" to "completeaction display-flex position-absolute safe-bottom"), _uA(
                                    _cE("text", _uM("class" to "closebtn background-main align-center", "onClick" to closeSelected), _uA(
                                        _cV(_component_x_iconfont, _uM("class" to "align-center", "name" to "jiahao", "onClick" to closeSelected, "color" to "#fff", "size" to "18", "height" to 45)),
                                        _cE("text", _uM("class" to "name color-white align-center", "onClick" to closeSelected), "继续添加")
                                    )),
                                    _cE("view", _uM("class" to "okbtn", "onClick" to submitGoods), _uA(
                                        _cE("text", _uM("class" to "name color-white align-center"), "选好了(" + _tD(unref(selectedCount)) + ")", 1)
                                    ))
                                ))
                            ), 4)
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "visible"
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
                return _uM("searchbox" to _pS(_uM("height" to 39, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#CCCCCC")), "searchinput" to _uM(".searchbox " to _uM("marginLeft" to "14rpx", "marginTop" to 6, "height" to 26, "width" to "660rpx", "borderTopLeftRadius" to 4, "borderTopRightRadius" to 4, "borderBottomRightRadius" to 4, "borderBottomLeftRadius" to 4)), "sousuo" to _uM(".searchbox .searchinput " to _uM("marginLeft" to 3)), "input" to _uM(".searchbox .searchinput " to _uM("paddingLeft" to "10rpx", "width" to "600rpx", "fontSize" to 14)), "saoyisao" to _uM(".searchbox " to _uM("marginLeft" to "10rpx", "marginTop" to 3)), "sortbox" to _pS(_uM("width" to "750rpx", "height" to 31, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#D9D9D9")), "sortitem" to _uM(".sortbox " to _uM("width" to "25%", "height" to 28, "paddingLeft" to "8%")), "text" to _uM(".sortbox .sortitem " to _uM("fontSize" to 13, "color" to "#828282", "height" to 28, "lineHeight" to "28px")), "icon" to _uM(".sortbox .sortitem " to _uM("height" to 28)), "goods" to _uM(".goodslist " to _uM("borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#DEDEDE")), "chooseaction" to _pS(_uM("width" to "750rpx", "bottom" to 0, "left" to 0, "height" to 45)), "number" to _uM(".chooseaction " to _uM("width" to "441rpx")), "name" to _uM(".chooseaction .number " to _uM("lineHeight" to "45px", "fontSize" to 16), ".chooseaction .okbtn " to _uM("lineHeight" to "45px", "fontSize" to 16), ".goodsnumbermodal .completeaction .closebtn " to _uM("lineHeight" to "45px", "fontSize" to 16), ".goodsnumbermodal .completeaction .okbtn " to _uM("lineHeight" to "45px", "fontSize" to 16)), "okbtn" to _uM(".chooseaction " to _uM("width" to "309rpx", "backgroundImage" to "none", "backgroundColor" to "#FF8F05"), ".goodsnumbermodal .completeaction " to _uM("width" to "420rpx", "backgroundImage" to "none", "backgroundColor" to "#FF8F05")), "goodsnumbermodal" to _pS(_uM("width" to "750rpx", "position" to "relative")), "emptylist" to _uM(".goodsnumbermodal " to _uM("fontSize" to 13, "color" to "#8C8C8C", "marginTop" to 30)), "completeaction" to _uM(".goodsnumbermodal " to _uM("width" to "750rpx", "height" to 45, "left" to 0, "zIndex" to 99999)), "closebtn" to _uM(".goodsnumbermodal .completeaction " to _uM("width" to "330rpx", "paddingTop" to 15)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
