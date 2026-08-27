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
open class GenPagesGoodsIndex : BasePage {
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
        var setup: (__props: GenPagesGoodsIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesGoodsIndex
            val _cache = __ins.renderCache
            val dropdownMenu = ref(-1)
            val analysisData = ref(_uO("count" to 0, "stock" to 0, "stock_price" to 0))
            val sortType = ref(_uA(
                _uO("name" to "默认排序", "key" to "default"),
                _uO("name" to "价格升序", "key" to "priceasc"),
                _uO("name" to "价格降序", "key" to "pricedesc"),
                _uO("name" to "库存升序", "key" to "stockasc"),
                _uO("name" to "库存降序", "key" to "stockdesc")
            ))
            val menusList = ref(_uA<UTSJSONObject>(_uO("name" to "生成条码", "key" to "barcode")))
            val goodsMenus = ref(_uA<UTSJSONObject>(_uO("name" to "调价", "key" to "edit", "color" to "#fff", "background" to "#409EFF")))
            val typeList = ref(_uA<CASCADER_ITEM_INFO>())
            val selecteds = ref("")
            val goodsList = ref(_uA<UTSJSONObject>())
            val clickScanCode = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var code = await(common.scanCode())
                        if (code.success == false) {
                            return@w1
                        }
                        console.log(code)
                })
            }
            val getTypeName = fun(key: String): String {
                var name = ""
                for(item in resolveUTSValueIterator(typeList.value)){
                    if (item.id == key) {
                        return item.title
                    } else {
                        if (item.children != null) {
                            for(child in resolveUTSValueIterator(item.children!!)){
                                if (child.id == key) {
                                    return item.title + "-" + child.title
                                }
                            }
                        }
                    }
                }
                return name
            }
            val clearGoodsType = fun(){
                selecteds.value = ""
            }
            val clickMenu = fun(menu: UTSJSONObject){
                console.log("收到点击菜单", menu)
            }
            val page = ref(1)
            val pageHeight = ref(100)
            val pageMax = ref(1000)
            val buttomLoading = ref(false)
            val keywords = ref("")
            val paging = ref<UniElement?>(null)
            val loading = ref<Any?>(null)
            val drawer = ref<UniElement?>(null)
            val filters = ref(_uO())
            val sort = ref("")
            val openShaixuan = fun(){
                console.log("打开筛选")
                common.callMethod(drawer.value as Any, "show")
            }
            val emptyList = computed(fun(): Boolean {
                return buttomLoading.value == false && goodsList.value.length < 1 && pageMax.value <= 1
            }
            )
            val noMoreData = computed(fun(): Boolean {
                return buttomLoading.value == false && goodsList.value.length > 0 && pageMax.value <= page.value
            }
            )
            val getList = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        var res = await(request.callapi("goods/index", _uO("page" to page.value, "keywords" to keywords.value, "filters" to filters.value, "type" to selecteds.value, "sort" to sort.value)))
                        var info = res.info as UTSJSONObject
                        pageMax.value = info.getNumber("max_page") as Number
                        if (page.value == 1) {
                            goodsList.value = res.data as UTSArray<UTSJSONObject>
                        } else {
                            goodsList.value = goodsList.value.concat(res.data as UTSArray<UTSJSONObject>)
                        }
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
            val confirmGoodsType = fun(){
                console.log("确定分类", selecteds.value)
                common.callMethod(drawer.value as Any, "close")
                dropdownMenu.value = -1
                refresh()
            }
            fun gen_handleTypeList_fn(list: UTSArray<UTSJSONObject>): UTSArray<CASCADER_ITEM_INFO> {
                var result = _uA<CASCADER_ITEM_INFO>()
                for(item in resolveUTSValueIterator(list)){
                    var obj = CASCADER_ITEM_INFO(title = item["name"] as String, id = (item["id"] as Number).toString())
                    if (item["children"] != null) {
                        obj.children = gen_handleTypeList_fn(item["children"] as UTSArray<UTSJSONObject>)
                    }
                    result.push(obj)
                }
                return result
            }
            val handleTypeList = ::gen_handleTypeList_fn
            val getGoodsType = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        var res = await(request.callapi("goods/typelist", _uO()))
                        if (res != null && res.code == 0) {
                            var list = res.data as UTSArray<UTSJSONObject>
                            var type = handleTypeList(list)
                            typeList.value = type
                        }
                })
            }
            val getGoodsAnalysis = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var res = await(request.callapi("goods/analysis", _uO()))
                        if (res == null) {
                            return@w1
                        }
                        if (res.code < 0) {
                            common.toast(res.msg)
                            return@w1
                        }
                        analysisData.value = res.data as UTSJSONObject
                })
            }
            val loadData = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        getGoodsType()
                        getGoodsAnalysis()
                        console.log("开始刷新")
                        page.value = 1
                        pageMax.value = 1000
                        common.loading(loading.value)
                        console.log("正在加载数据")
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
            val goodsView = fun(id: Number){
                common.goto("/pages/goods/view?id=" + id, "slide-in-bottom")
            }
            onLoad(fun(_options){
                loadData()
            }
            )
            onReady(fun(){
                pageHeight.value = uni_getWindowInfo().safeArea.height - 210
            }
            )
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_xp_popover_menu = resolveEasyComponent("xp-popover-menu", GenComponentsXpPopoverMenuXpPopoverMenuClass)
                val _component_x_viewtitle = resolveEasyComponent("x-viewtitle", GenComponentsXViewtitleClass)
                val _component_x_searchbox = resolveEasyComponent("x-searchbox", GenComponentsXSearchboxClass)
                val _component_x_rolling_number = resolveEasyComponent("x-rolling-number", GenComponentsXRollingNumberClass)
                val _component_tmx_dropdown_item = resolveEasyComponent("tmx-dropdown-item", GenUniModulesTmxUiComponentsTmxDropdownItemTmxDropdownItemClass)
                val _component_tmx_cascader = resolveEasyComponent("tmx-cascader", GenUniModulesTmxUiComponentsTmxCascaderTmxCascaderClass)
                val _component_tmx_dropdown_menu = resolveEasyComponent("tmx-dropdown-menu", GenUniModulesTmxUiComponentsTmxDropdownMenuTmxDropdownMenuClass)
                val _component_x_goodsitem = resolveEasyComponent("x-goodsitem", GenComponentsXGoodsitemClass)
                val _component_x_listmenu = resolveEasyComponent("x-listmenu", GenComponentsXListmenuClass)
                val _component_x_empty = resolveEasyComponent("x-empty", GenComponentsXEmptyClass)
                val _component_x_buttom_loading = resolveEasyComponent("x-buttom-loading", GenComponentsXButtomLoadingClass)
                val _component_x_nomoredata = resolveEasyComponent("x-nomoredata", GenComponentsXNomoredataClass)
                val _component_x_paging = resolveEasyComponent("x-paging", GenComponentsXPagingClass)
                val _component_x_loading = resolveEasyComponent("x-loading", GenComponentsXLoadingClass)
                val _component_x_drawer = resolveEasyComponent("x-drawer", GenComponentsXDrawerClass)
                return _cE("view", null, _uA(
                    _cV(_component_x_viewtitle, _uM("title" to "商品列表"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to "handles display-flex"), _uA(
                                _cV(_component_xp_popover_menu, _uM("placement" to "bottom-right", "menus" to unref(menusList), "onClickMenu" to clickMenu), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cE("view", _uM("class" to "addbtn display-flex"), _uA(
                                            _cV(_component_x_iconfont, _uM("height" to 18, "class" to "icon", "name" to "gengduo1", "size" to "14", "color" to "white")),
                                            _cE("text", _uM("class" to "name color-white"), "管理")
                                        ))
                                    )
                                }
                                ), "_" to 1), 8, _uA(
                                    "menus"
                                ))
                            ))
                        )
                    }
                    ), "_" to 1)),
                    _cE("view", _uM("class" to "search display-flex"), _uA(
                        _cV(_component_x_searchbox, _uM("width" to 600, "placeholder" to "商品名称/条码", "modelValue" to unref(keywords), "onUpdate:modelValue" to fun(`$event`: String){
                            trySetRefValue(keywords, `$event`)
                        }
                        , "onSaoma" to clickScanCode), null, 8, _uA(
                            "modelValue"
                        )),
                        _cE("view", _uM("class" to "shaixuan display-flex", "onClick" to openShaixuan), _uA(
                            _cV(_component_x_iconfont, _uM("height" to 30, "class" to "icon", "name" to "shaixuan", "size" to "16", "color" to "white")),
                            _cE("text", _uM("class" to "name color-white"), "筛选")
                        ))
                    )),
                    _cE("view", _uM("class" to "staticsdata"), _uA(
                        _cE("view", _uM("class" to "basicstatic display-flex"), _uA(
                            _cE("view", _uM("class" to "staticcard"), _uA(
                                _cV(_component_x_rolling_number, _uM("val" to unref(analysisData).getNumber("count"), "font-style" to "text-align:center;font-weight:bold;"), null, 8, _uA(
                                    "val"
                                )),
                                _cE("text", _uM("class" to "name"), "商品")
                            )),
                            _cE("view", _uM("class" to "staticcard"), _uA(
                                _cV(_component_x_rolling_number, _uM("val" to unref(analysisData).getNumber("stock"), "font-color" to "#FF8D1A", "font-style" to "text-align:center;font-weight:bold;"), null, 8, _uA(
                                    "val"
                                )),
                                _cE("text", _uM("class" to "name"), "库存")
                            )),
                            _cE("view", _uM("class" to "staticcard"), _uA(
                                _cV(_component_x_rolling_number, _uM("val" to unref(analysisData).getNumber("stock_price"), "decimals" to 2, "font-style" to "text-align:center;font-weight:bold;"), null, 8, _uA(
                                    "val"
                                )),
                                _cE("text", _uM("class" to "name"), "库存成本")
                            ))
                        )),
                        _cV(_component_tmx_dropdown_menu, _uM("position" to "static", "modelValue" to unref(dropdownMenu), "onUpdate:modelValue" to fun(`$event`: Number){
                            trySetRefValue(dropdownMenu, `$event`)
                        }
                        ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cV(_component_tmx_dropdown_item, _uM("title" to "智能排序", "class" to "padding-buttom"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cE(Fragment, null, RenderHelpers.renderList(unref(sortType), fun(item, index, __index, _cached): Any {
                                            return _cE("view", _uM("class" to "menuitem"), _uA(
                                                _cE("view", _uM("class" to "space-between"), _uA(
                                                    _cE("text", _uM("class" to _nC(_uA(
                                                        "itemname",
                                                        if (unref(sort) == (item["key"] as String)) {
                                                            "activeitem"
                                                        } else {
                                                            ""
                                                        }
                                                    ))), _tD(item["name"]), 3),
                                                    if (unref(sort) == (item["key"] as String)) {
                                                        _cV(_component_x_iconfont, _uM("key" to 0, "name" to "gou", "height" to 39, "size" to "14", "color" to "#1776FC"))
                                                    } else {
                                                        _cC("v-if", true)
                                                    }
                                                ))
                                            ))
                                        }
                                        ), 256)
                                    )
                                }
                                ), "_" to 1)),
                                _cV(_component_tmx_dropdown_item, _uM("title" to if (unref(selecteds) == "") {
                                    "全部分类"
                                } else {
                                    getTypeName(unref(selecteds))
                                }
                                ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cE("scroll-view", _uM("direction" to "vertical", "class" to "goodstype"), _uA(
                                            _cV(_component_tmx_cascader, _uM("fontSize" to "14px", "height" to "300px", "showCurrentBtn" to true, "modelValue" to unref(selecteds), "onUpdate:modelValue" to fun(`$event`: String){
                                                trySetRefValue(selecteds, `$event`)
                                            }
                                            , "list" to unref(typeList)), null, 8, _uA(
                                                "modelValue",
                                                "list"
                                            ))
                                        )),
                                        _cE("view", _uM("class" to "typeaction display-flex"), _uA(
                                            _cE("button", _uM("hover-class" to "none", "class" to "actionbtn align-center quxiao", "onClick" to clearGoodsType), "撤销"),
                                            _cE("button", _uM("hover-class" to "none", "class" to "actionbtn align-center queding", "onClick" to confirmGoodsType), "确定")
                                        ))
                                    )
                                }
                                ), "_" to 1), 8, _uA(
                                    "title"
                                ))
                            )
                        }
                        ), "_" to 1), 8, _uA(
                            "modelValue"
                        ))
                    )),
                    _cE("view", _uM("class" to "goodslist"), _uA(
                        _cV(_component_x_paging, _uM("ref_key" to "paging", "ref" to paging, "height" to unref(pageHeight), "onRefresh" to refresh, "onToLower" to nextPage), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("view", null, _uA(
                                    _cV(_component_x_listmenu, _uM("list" to unref(goodsList), "height" to 80, "menus" to unref(goodsMenus)), _uM("default" to withScopedSlotCtx(fun(slotProps: Record<String, Any?>): UTSArray<Any> {
                                        val item = slotProps["item"]
                                        return _uA(
                                            _cE("view", _uM("onClick" to fun(){
                                                goodsView((item as UTSJSONObject)["id"] as Number)
                                            }
                                            ), _uA(
                                                _cV(_component_x_goodsitem, _uM("goods" to item), null, 8, _uA(
                                                    "goods"
                                                ))
                                            ), 8, _uA(
                                                "onClick"
                                            ))
                                        )
                                    }
                                    ), "_" to 1), 8, _uA(
                                        "list",
                                        "menus"
                                    )),
                                    if (isTrue(unref(emptyList))) {
                                        _cV(_component_x_empty, _uM("key" to 0))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                    ,
                                    if (isTrue(unref(buttomLoading))) {
                                        _cV(_component_x_buttom_loading, _uM("key" to 1))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                    ,
                                    if (isTrue(unref(noMoreData))) {
                                        _cV(_component_x_nomoredata, _uM("key" to 2))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                ))
                            )
                        }
                        ), "_" to 1), 8, _uA(
                            "height"
                        ))
                    )),
                    _cV(_component_x_loading, _uM("ref_key" to "loading", "ref" to loading), null, 512),
                    _cV(_component_x_drawer, _uM("ref_key" to "drawer", "ref" to drawer), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            " 暂无 "
                        )
                    }
                    ), "_" to 1), 512)
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
                return _uM("name" to _uM(".handles " to _uM("fontSize" to 14, "paddingLeft" to "8rpx"), ".search " to _uM("fontSize" to 16, "paddingLeft" to "4rpx", "lineHeight" to "30px"), ".staticsdata .basicstatic .staticcard " to _uM("paddingTop" to 5, "textAlign" to "center", "color" to "#8F8F8F", "fontSize" to 13)), "addbtn" to _uM(".handles " to _uM("marginRight" to "12rpx")), "search" to _pS(_uM("backgroundColor" to "#1678fd", "paddingLeft" to "20rpx", "paddingTop" to 8, "paddingBottom" to 38)), "shaixuan" to _uM(".search " to _uM("paddingLeft" to "15rpx")), "staticsdata" to _pS(_uM("backgroundColor" to "#FFFFFF", "marginTop" to -28, "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10)), "basicstatic" to _uM(".staticsdata " to _uM("height" to 70)), "staticcard" to _uM(".staticsdata .basicstatic " to _uM("width" to "250rpx", "paddingTop" to 10)), "number" to _uM(".staticsdata .basicstatic .staticcard " to _uM("textAlign" to "center", "color" to "#000000", "fontSize" to 16, "fontWeight" to "bold")), "kucun" to _uM(".staticsdata .basicstatic .staticcard " to _uM("color" to "#FF8D1A")), "goodstype" to _uM(".staticsdata " to _uM("maxHeight" to 300, "paddingTop" to 0)), "menuitem" to _uM(".staticsdata " to _uM("height" to 40, "borderTopWidth" to 1, "borderTopStyle" to "solid", "borderTopColor" to "#f5f5f5", "width" to "690rpx")), "itemname" to _uM(".staticsdata .menuitem " to _uM("lineHeight" to "39px", "color" to "#5d5d5d", "fontSize" to 14)), "activeitem" to _uM(".staticsdata .menuitem " to _uM("color" to "#1678fd", "fontWeight" to "bold")), "typeaction" to _uM(".staticsdata " to _uM("width" to "690rpx", "marginLeft" to "10rpx")), "actionbtn" to _uM(".staticsdata .typeaction " to _uM("height" to 35, "lineHeight" to "35px", "color" to "#FFFFFF", "marginBottom" to 10)), "quxiao" to _uM(".staticsdata .typeaction " to _uM("width" to "250rpx", "backgroundColor" to "#000000")), "queding" to _uM(".staticsdata .typeaction " to _uM("width" to "430rpx", "marginLeft" to "10rpx", "backgroundColor" to "#1678fd")), "goodsitem" to _pS(_uM("width" to "750rpx", "height" to 64)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
