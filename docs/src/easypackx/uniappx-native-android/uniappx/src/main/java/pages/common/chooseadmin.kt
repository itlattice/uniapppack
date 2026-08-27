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
open class GenPagesCommonChooseadmin : BasePage {
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
        var setup: (__props: GenPagesCommonChooseadmin) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCommonChooseadmin
            val _cache = __ins.renderCache
            val pageHeight = ref(50)
            val keywords = ref("")
            val page = ref(1)
            val pageMax = ref(1000)
            val loading = ref(false)
            val list = ref(_uA<UTSJSONObject>())
            val depart = ref(_uO())
            val departID = ref(0)
            val dataCount = ref(0)
            val paging = ref<ComponentPublicInstance?>(null)
            val noMoreData = computed(fun(): Boolean {
                return loading.value == false && list.value.length > 0 && pageMax.value <= page.value
            }
            )
            val noData = computed(fun(): Boolean {
                return loading.value == false && list.value.length < 1 && pageMax.value <= 1
            }
            )
            val back = fun(){
                uni__off("/pages/common/chooseadmin", null)
                common.back()
            }
            val getDepartInfo = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        var res = await(request.callapi("depart/getdepartview", _uO("id" to departID.value)))
                        depart.value = res.data as UTSJSONObject
                })
            }
            val chooseDepart = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var departData = await(common.navigatoEvent("/pages/common/choosedepart"))
                        if (departData["name"] == null) {
                            return@w1
                        }
                        depart.value = departData
                })
            }
            val search = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        loading.value = true
                        var res = await(request.callapi("depart/adminlist", _uO("keywords" to keywords.value, "page" to page.value, "depart" to departID.value)))
                        loading.value = false
                        if (res.code < 0) {
                            common.toast(res.msg)
                            list.value = _uA()
                            pageMax.value = 0
                            dataCount.value = 0
                            return@w1
                        } else {
                            var info = res.info as UTSJSONObject
                            pageMax.value = UTSNumber.from(info["maxPage"].toString())
                            dataCount.value = UTSNumber.from(info["count"].toString())
                            if (page.value == 1) {
                                list.value = res.data as UTSArray<UTSJSONObject>
                            } else {
                                list.value = list.value.concat(res.data as UTSArray<UTSJSONObject>)
                            }
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
                        getDepartInfo()
                        refresh()
                })
            }
            val nextPage = fun(){
                if (page.value >= pageMax.value) {
                    return
                }
                page.value++
                search()
            }
            val chooseAdmin = fun(data: UTSJSONObject){
                console.log("选中员工", data)
                uni__emit("/pages/common/chooseadmin", data)
            }
            onLoad(fun(options){
                departID.value = UTSNumber.from(options["depart"] as String)
                pageHeight.value = uni_getWindowInfo().windowHeight - 130
                loadPageData()
            }
            )
            onUnload(fun(){
                uni__off("/pages/common/chooseadmin", null)
            }
            )
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_x_searchbox = resolveEasyComponent("x-searchbox", GenComponentsXSearchboxClass)
                val _component_x_admin = resolveEasyComponent("x-admin", GenComponentsXAdminClass)
                val _component_x_buttom_loading = resolveEasyComponent("x-buttom-loading", GenComponentsXButtomLoadingClass)
                val _component_x_nomoredata = resolveEasyComponent("x-nomoredata", GenComponentsXNomoredataClass)
                val _component_x_empty = resolveEasyComponent("x-empty", GenComponentsXEmptyClass)
                val _component_x_paging = resolveEasyComponent("x-paging", GenComponentsXPagingClass)
                return _cE("view", null, _uA(
                    _cE("view", _uM("class" to "native padding-stauts-bar background-main"), _uA(
                        _cE("view", _uM("class" to "nativetitle space-between"), _uA(
                            _cE("view", _uM("class" to "lefttitle display-flex"), _uA(
                                _cE("text", _uM("class" to "text color-white"), "选择员工"),
                                _cE("view", _uM("class" to "shoplist display-flex", "onClick" to chooseDepart), _uA(
                                    _cE("text", _uM("class" to "name color-white"), _tD(unref(depart)["name"]), 1),
                                    _cV(_component_x_iconfont, _uM("name" to "xiangxia1", "color" to "white", "size" to "12", "height" to 16))
                                ))
                            )),
                            _cE("view", _uM("class" to "close-btn display-flex", "onClick" to back), _uA(
                                _cV(_component_x_iconfont, _uM("name" to "guanbi", "size" to "14", "color" to "white")),
                                _cE("text", _uM("class" to "text color-white"), "关闭")
                            ))
                        ))
                    )),
                    _cE("view", _uM("class" to "searchview background-white"), _uA(
                        _cV(_component_x_searchbox, _uM("ref" to "searchbox", "modelValue" to unref(keywords), "onUpdate:modelValue" to fun(`$event`: String){
                            trySetRefValue(keywords, `$event`)
                        }
                        , "width" to 710, "placeholder" to "手机号/姓名/工号"), null, 8, _uA(
                            "modelValue"
                        ))
                    )),
                    _cV(_component_x_paging, _uM("ref_key" to "paging", "ref" to paging, "height" to unref(pageHeight), "onRefresh" to refresh, "onToLower" to nextPage), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", null, _uA(
                                _cE("text", _uM("class" to "count"), "共" + _tD(unref(dataCount)) + "人", 1),
                                _cE("view", _uM("class" to "goodslist"), _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(unref(list), fun(item, index, __index, _cached): Any {
                                        return _cE("view", _uM("class" to "goods", "key" to index), _uA(
                                            _cV(_component_x_admin, _uM("user" to item, "onClk" to chooseAdmin), null, 8, _uA(
                                                "user"
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
                return _uM("nativetitle" to _uM(".native " to _uM("paddingLeft" to "16rpx", "paddingRight" to "22rpx", "paddingTop" to 13, "height" to 40)), "text" to _uM(".native " to _uM("fontSize" to 14, "marginLeft" to "6rpx")), "shoplist" to _uM(".lefttitle " to _uM("marginLeft" to "20rpx")), "name" to _uM(".lefttitle .shoplist " to _uM("fontSize" to 14, "marginRight" to "5rpx")), "searchview" to _pS(_uM("width" to "750rpx", "height" to 50, "paddingLeft" to "20rpx", "paddingRight" to "20rpx", "paddingTop" to 7)), "count" to _pS(_uM("marginTop" to 5, "marginBottom" to 5, "fontSize" to 14, "textAlign" to "right", "color" to "#696969")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
