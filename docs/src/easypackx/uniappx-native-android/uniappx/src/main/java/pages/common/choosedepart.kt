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
open class GenPagesCommonChoosedepart : BasePage {
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
        var setup: (__props: GenPagesCommonChoosedepart) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCommonChoosedepart
            val _cache = __ins.renderCache
            val keywords = ref("")
            val pageHeight = ref(0)
            val page = ref(1)
            val pageMax = ref(1000)
            val dataList = ref(_uA<UTSJSONObject>())
            val buttomLoading = ref(false)
            val userAddress = ref(_uO())
            val submitBool = ref(false)
            val loading = ref<UniElement?>(null)
            val emptyList = computed(fun(): Boolean {
                return buttomLoading.value == false && dataList.value.length < 1 && pageMax.value <= 1
            }
            )
            val noMoreData = computed(fun(): Boolean {
                return buttomLoading.value == false && dataList.value.length > 0 && pageMax.value <= page.value
            }
            )
            val back = fun(){
                uni__off("/pages/common/choosedepart", null)
                common.back()
            }
            val search = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        if (pageMax.value <= page.value) {
                            return@w1
                        }
                        buttomLoading.value = true
                        var res = await(request.callapi("depart/getlist", _uO("keywords" to keywords.value, "city" to userAddress.value["city_code"], "page" to page.value)))
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
                        page.value = res.info["page"] as Number
                })
            }
            val refresh = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        page.value = 1
                        pageMax.value = 1000
                        dataList.value = _uA<UTSJSONObject>()
                        await(search())
                })
            }
            val chooseCity = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var city = await(common.navigatoEvent("/pages/common/choosecity"))
                        if (city["code"] == null) {
                            return@w1
                        }
                        userAddress.value = _uO("city_code" to city["code"], "city" to city["short"])
                        common.setStorage("useraddresscity", userAddress.value)
                        refresh()
                })
            }
            val clickItem = fun(item: UTSJSONObject){
                if (submitBool.value) {
                    return
                }
                submitBool.value = true
                uni__emit("/pages/common/choosedepart", item)
                setTimeout(fun(){
                    submitBool.value = false
                }
                , 50)
            }
            val getCityCode = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var cache = common.getStorage("useraddresscity")
                        if (cache != "") {
                            userAddress.value = cache as UTSJSONObject
                            return@w1
                        }
                        var res = await(common.getLocationInfo("None", "none", false))
                        if (res == false) {
                            common.toast("定位失败")
                            userAddress.value = _uO("city_code" to "000000", "city" to "定位失败")
                            return@w1
                        }
                        res = res as LocationInfoResult
                        userAddress.value = _uO("city_code" to (res as LocationInfoResult).city_code, "city" to (res as LocationInfoResult).city_short)
                        console.log(userAddress.value)
                        common.setStorage("useraddresscity", userAddress.value)
                })
            }
            val clearKeywords = fun(){
                keywords.value = ""
            }
            val loadPageData = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        common.loading(loading.value)
                        await(getCityCode())
                        await(refresh())
                        common.hideLoading(loading.value)
                })
            }
            onLoad(fun(_options){
                pageHeight.value = uni_getWindowInfo().windowHeight - 85
            }
            )
            onReady(fun(){
                loadPageData()
            }
            )
            onUnload(fun(){
                uni__off("/pages/common/choosedepart", null)
            }
            )
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_x_buttom_loading = resolveEasyComponent("x-buttom-loading", GenComponentsXButtomLoadingClass)
                val _component_x_nomoredata = resolveEasyComponent("x-nomoredata", GenComponentsXNomoredataClass)
                val _component_x_paging = resolveEasyComponent("x-paging", GenComponentsXPagingClass)
                val _component_x_loading = resolveEasyComponent("x-loading", GenComponentsXLoadingClass)
                return _cE("view", null, _uA(
                    _cE("view", _uM("class" to "native padding-stauts-bar background-main"), _uA(
                        _cE("view", _uM("class" to "nativetitle space-between"), _uA(
                            _cE("text", _uM("class" to "text color-white"), "选择门店/仓库"),
                            _cE("view", _uM("class" to "close-btn display-flex", "onClick" to back), _uA(
                                _cV(_component_x_iconfont, _uM("name" to "guanbi", "size" to "14", "color" to "white")),
                                _cE("text", _uM("class" to "text color-white"), "关闭")
                            ))
                        ))
                    )),
                    _cE("view", _uM("class" to "searchbox display-flex background-white"), _uA(
                        _cE("view", _uM("class" to "cityname display-flex", "onClick" to chooseCity), _uA(
                            _cE("text", _uM("class" to "text overline"), _tD(unref(userAddress)["city"]), 1),
                            _cV(_component_x_iconfont, _uM("class" to "icon", "name" to "xiangxia", "color" to "#000000", "size" to "14"))
                        )),
                        _cE("view", _uM("class" to "inputbox display-flex"), _uA(
                            _cV(_component_x_iconfont, _uM("class" to "sousuo", "color" to "#C4C4C4", "name" to "sousuo", "size" to "15")),
                            _cE("input", _uM("onConfirm" to search, "type" to "text", "ref" to "input", "confirm-type" to "search", "auto-focus" to true, "class" to "input", "modelValue" to unref(keywords), "onInput" to fun(`$event`: UniInputEvent){
                                trySetRefValue(keywords, `$event`.detail.value)
                            }
                            , "placeholder" to "请输入名称"), null, 40, _uA(
                                "modelValue"
                            )),
                            _cE("view", _uM("class" to "empty"), _uA(
                                if (unref(keywords).length > 0) {
                                    _cV(_component_x_iconfont, _uM("key" to 0, "onClick" to clearKeywords, "name" to "chacha", "size" to "16", "color" to "#C4C4C4"))
                                } else {
                                    _cC("v-if", true)
                                }
                            ))
                        ))
                    )),
                    _cV(_component_x_paging, _uM("ref" to "paging", "height" to unref(pageHeight), "onRefresh" to refresh), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", null, _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(unref(dataList), fun(item, __key, __index, _cached): Any {
                                    return _cE("view", _uM("class" to "depart space-between background-white", "key" to item["id"], "onClick" to fun(){
                                        clickItem(item)
                                    }
                                    ), _uA(
                                        _cE("view", _uM("class" to "info"), _uA(
                                            _cE("text", _uM("class" to "name"), _tD(item["name"]), 1),
                                            _cE("text", _uM("class" to "addr overline"), _tD(item["location"]) + _tD(item["room"]), 1)
                                        ))
                                    ), 8, _uA(
                                        "onClick"
                                    ))
                                }
                                ), 128),
                                if (isTrue(unref(emptyList))) {
                                    _cE("view", _uM("key" to 0, "class" to "emptylist"), _uA(
                                        _cV(_component_x_iconfont, _uM("class" to "icon margin-center", "name" to "qiye", "color" to "#BDBDBD", "size" to "130")),
                                        _cE("text", _uM("class" to "content align-center"), "无数据")
                                    ))
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
                    )),
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
                return _uM("nativetitle" to _uM(".native " to _uM("paddingLeft" to "16rpx", "paddingRight" to "22rpx", "paddingTop" to 13, "height" to 40)), "text" to _uM(".native " to _uM("fontSize" to 14, "marginLeft" to "6rpx"), ".searchbox .cityname " to _uM("color" to "#000000", "maxWidth" to "94rpx", "fontSize" to 14, "paddingRight" to "3rpx")), "searchbox" to _pS(_uM("height" to 45, "borderBottomWidth" to 0.5, "borderBottomStyle" to "solid", "borderBottomColor" to "#cccccc")), "cityname" to _uM(".searchbox " to _uM("width" to "154rpx", "paddingLeft" to "17rpx", "paddingRight" to "9rpx", "paddingTop" to "31rpx")), "icon" to _uM(".searchbox .cityname " to _uM("paddingTop" to 1)), "inputbox" to _uM(".searchbox " to _uM("marginTop" to 7, "marginLeft" to "20rpx", "height" to 31, "width" to "560rpx", "backgroundColor" to "#f5f5f5", "borderTopLeftRadius" to 4, "borderTopRightRadius" to 4, "borderBottomRightRadius" to 4, "borderBottomLeftRadius" to 4)), "sousuo" to _uM(".searchbox .inputbox " to _uM("paddingTop" to 8, "paddingLeft" to "10rpx")), "input" to _uM(".searchbox .inputbox " to _uM("marginLeft" to "10rpx", "fontSize" to 14, "width" to "530rpx")), "empty" to _uM(".searchbox .inputbox " to _uM("width" to "68rpx", "paddingTop" to 7)), "emptylist" to _pS(_uM("marginTop" to "25%")), "content" to _uM(".emptylist " to _uM("color" to "#BDBDBD", "fontSize" to 18, "marginTop" to 10)), "depart" to _pS(_uM("height" to 52, "paddingLeft" to 11, "paddingTop" to 7, "paddingBottom" to 6, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#E3E3E3", "paddingRight" to 12)), "name" to _uM(".depart .info " to _uM("color" to "#000000", "fontSize" to 15)), "addr" to _uM(".depart .info " to _uM("paddingTop" to 2, "color" to "#A1A1A1", "fontSize" to 12)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
