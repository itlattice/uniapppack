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
open class GenPagesCommonChooserequireorder : BasePage {
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
        var setup: (__props: GenPagesCommonChooserequireorder) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCommonChooserequireorder
            val _cache = __ins.renderCache
            val keywords = ref("")
            val eventID = ref(0)
            val dataList = ref(_uA<UTSJSONObject>())
            val buttomLoading = ref(false)
            val pageHeight = ref(100)
            val page = ref(1)
            val pageMax = ref(1000)
            val depart = ref("0")
            val paging = ref<ComponentPublicInstance?>(null)
            val loading = ref<UniElement?>(null)
            val erweima = ref<UniElement?>(null)
            val orderWidth = computed(fun(): Number {
                return 750
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
            val scanCode = fun(code: Any): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        console.log("选择要货单页面收到扫码", code)
                })
            }
            val back = fun(){
                uni__off("/pages/common/chooserequireorder", null)
                common.back()
            }
            val getList = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var res = await(request.callapi("warehouse/requireorder", _uO("page" to page.value, "keywords" to keywords.value, "depart" to depart.value)))
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
            val erWeima = fun(index: Number){
                common.callMethod(erweima.value as Any, "showCode", dataList.value[index]["no"] as Any)
            }
            val selectdata = fun(data: UTSJSONObject){
                uni__emit("/pages/common/chooserequireorder", data)
            }
            onLoad(fun(options){
                var departVal = options["depart"]
                if (!(departVal == null || departVal == "null")) {
                    depart.value = departVal.toString()
                }
                loadData()
            }
            )
            onReady(fun(){
                pageHeight.value = uni_getWindowInfo().safeArea.height - 110
            }
            )
            onShow(fun(){
                common.navigationBar()
                console.log("选择要货单页面开始监听扫码")
                eventID.value = uni__on("scanCode", scanCode)
            }
            )
            onHide(fun(){
                console.log("选择要货单页面停止监听扫码")
                uni__off("scanCode", eventID.value)
            }
            )
            onUnload(fun(){
                uni__off("/pages/common/chooserequireorder", null)
                console.log("选择要货单页面停止监听扫码")
                uni__off("scanCode", eventID.value)
            }
            )
            return fun(): Any? {
                val _component_x_choosetitle = resolveEasyComponent("x-choosetitle", GenComponentsXChoosetitleClass)
                val _component_x_searchbox = resolveEasyComponent("x-searchbox", GenComponentsXSearchboxClass)
                val _component_x_requiregoods_order = resolveEasyComponent("x-requiregoods-order", GenComponentsXRequiregoodsOrderClass)
                val _component_x_empty = resolveEasyComponent("x-empty", GenComponentsXEmptyClass)
                val _component_x_buttom_loading = resolveEasyComponent("x-buttom-loading", GenComponentsXButtomLoadingClass)
                val _component_x_nomoredata = resolveEasyComponent("x-nomoredata", GenComponentsXNomoredataClass)
                val _component_x_paging = resolveEasyComponent("x-paging", GenComponentsXPagingClass)
                val _component_x_loading = resolveEasyComponent("x-loading", GenComponentsXLoadingClass)
                val _component_x_showcode = resolveEasyComponent("x-showcode", GenComponentsXShowcodeClass)
                return _cE("view", _uM("class" to "chooserequireorder"), _uA(
                    _cV(_component_x_choosetitle, _uM("title" to "选择要货单", "page" to "/pages/common/chooserequireorder", "onBack" to back)),
                    _cE("view", _uM("class" to "searchview background-white"), _uA(
                        _cV(_component_x_searchbox, _uM("ref" to "searchbox", "modelValue" to unref(keywords), "onUpdate:modelValue" to fun(`$event`: String){
                            trySetRefValue(keywords, `$event`)
                        }
                        , "width" to 710, "placeholder" to "手机号/姓名/工号"), null, 8, _uA(
                            "modelValue"
                        ))
                    )),
                    _cE("text", _uM("class" to "totalnum align-right"), "共" + _tD(unref(dataList).length) + "条", 1),
                    _cE("view", _uM("class" to "orderlist"), _uA(
                        _cV(_component_x_paging, _uM("ref_key" to "paging", "ref" to paging, "height" to unref(pageHeight), "onRefresh" to refresh, "onToLower" to nextPage), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("view", null, _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(unref(dataList), fun(item, index, __index, _cached): Any {
                                        return _cE("view", _uM("class" to "orderitem display-flex background-white", "key" to index), _uA(
                                            _cV(_component_x_requiregoods_order, _uM("select" to true, "width" to unref(orderWidth), "order" to item, "index" to index, "onErWeima" to erWeima, "onSelectdata" to selectdata), null, 8, _uA(
                                                "width",
                                                "order",
                                                "index"
                                            ))
                                        ))
                                    }
                                    ), 128),
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
                return _uM("searchview" to _pS(_uM("width" to "750rpx", "height" to 50, "paddingLeft" to "20rpx", "paddingRight" to "20rpx", "paddingTop" to 7)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
