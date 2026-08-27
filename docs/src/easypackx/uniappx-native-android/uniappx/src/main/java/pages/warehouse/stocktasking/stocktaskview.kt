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
open class GenPagesWarehouseStocktaskingStocktaskview : BasePage {
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
        var setup: (__props: GenPagesWarehouseStocktaskingStocktaskview) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesWarehouseStocktaskingStocktaskview
            val _cache = __ins.renderCache
            val orderID = ref(0)
            val pageHeight = ref(0)
            val menusList = _uA<UTSJSONObject>(_uO("name" to "核对明细", "key" to "approval"), _uO("name" to "撤销任务", "key" to "cancel"), _uO("name" to "结束盘点", "key" to "end"))
            val info = ref(_uO())
            val loading = ref<UniElement?>(null)
            val signer = ref<UniElement?>(null)
            val modal = ref<UniElement?>(null)
            val user = computed(fun(): userInfoType {
                return state.user
            }
            )
            val addAdmin = computed(fun(): UTSJSONObject {
                var addAdminInfo = info.value["add_admin"]
                if (addAdminInfo == null) {
                    return _uO()
                }
                return addAdminInfo as UTSJSONObject
            }
            )
            val admin = computed(fun(): UTSJSONObject {
                var adminInfo = info.value["admin"]
                if (adminInfo == null) {
                    return _uO()
                }
                return adminInfo as UTSJSONObject
            }
            )
            val depart = computed(fun(): UTSJSONObject {
                var departInfo = info.value["depart"]
                if (departInfo == null) {
                    return _uO()
                }
                return departInfo as UTSJSONObject
            }
            )
            val userList = computed(fun(): UTSArray<UTSJSONObject> {
                var users = info.value["users"]
                if (users == null) {
                    return _uA<UTSJSONObject>()
                }
                return users as UTSArray<UTSJSONObject>
            }
            )
            val loadPageData = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        common.loading(loading.value)
                        var res = await(request.callapi("warehouse/stocktaskview", _uO("id" to orderID.value)))
                        common.hideLoading(loading.value)
                        if (res.code < 0) {
                            common.toast(res.msg)
                            return@w1
                        }
                        info.value = res.data as UTSJSONObject
                })
            }
            val cancelTask = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        if (!(info.value["admin_id"] == user.value.id || info.value["add_admin_id"] == user.value.id)) {
                            common.toast("只有负责人或者创建人可以操作")
                            return@w1
                        }
                        var q = await(common.showQuery(modal.value as Any, "确定撤销任务"))
                        if (!q) {
                            return@w1
                        }
                        var sign = await(common.signer(signer.value as Any))
                        console.log("签字信息", sign)
                        if (sign == null) {
                            return@w1
                        }
                        common.loading(loading.value)
                        var res = await(request.callapi("warehouse/cancelstocktask", _uO("id" to orderID.value, "sign" to sign)))
                        common.hideLoading(loading.value)
                        if (res.code < 0) {
                            common.toast(res.msg)
                            return@w1
                        }
                        loadPageData()
                })
            }
            val endList = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        if (info.value["admin_id"] != user.value.id) {
                            common.toast("只有负责人可以结束")
                            return@w1
                        }
                        var sign = await(common.signer(signer.value as Any))
                        console.log("签字信息", sign)
                        if (sign == null) {
                            return@w1
                        }
                        common.loading(loading.value)
                        var res = await(request.callapi("warehouse/endstocktask", _uO("id" to orderID.value, "sign" to sign)))
                        common.hideLoading(loading.value)
                        if (res.code < 0) {
                            common.toast(res.msg)
                            return@w1
                        }
                        loadPageData()
                })
            }
            val approval = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        common.loading(loading.value)
                        var res = await(request.callapi("warehouse/stockapproval", _uO("id" to orderID.value)))
                        common.hideLoading(loading.value)
                        if (res.code < 0) {
                            common.toast(res.msg)
                            return@w1
                        }
                        if (res.code == 2) {
                            common.goto("/pages/warehouse/stocktasking/showstocktaskdata?id=" + orderID.value)
                            return@w1
                        }
                        if (res.code == 1) {
                            common.goto("/pages/warehouse/stocktasking/viewstocktaskdata?id=" + orderID.value)
                            return@w1
                        }
                        if (res.code == 0) {
                            common.toast(res.msg)
                            return@w1
                        }
                })
            }
            val clickMenu = fun(menu: UTSJSONObject){
                console.log("收到点击菜单", menu)
                var key = menu["key"] as String
                when (key) {
                    "approval" -> 
                        approval()
                    "end" -> 
                        endList()
                    "cancel" -> 
                        cancelTask()
                    else -> 
                        return
                }
            }
            val joinTask = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        common.loading(loading.value)
                        var res = await(request.callapi("warehouse/addstocktask", _uO("id" to orderID.value)))
                        common.hideLoading(loading.value)
                        if (res.code < 0) {
                            common.toast(res.msg)
                            return@w1
                        }
                        common.goto("/pages/warehouse/stocktasking/runstocktask?id=" + orderID.value)
                })
            }
            onLoad(fun(query: OnLoadOptions){
                orderID.value = UTSNumber.from(query["id"] as String)
                loadPageData()
            }
            )
            onReady(fun(){
                pageHeight.value = uni_getWindowInfo().safeArea.height - 82
            }
            )
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_xp_popover = resolveEasyComponent("xp-popover", GenComponentsXpPopoverXpPopoverClass)
                val _component_x_viewtitle = resolveEasyComponent("x-viewtitle", GenComponentsXViewtitleClass)
                val _component_x_show_signer = resolveEasyComponent("x-show-signer", GenComponentsXShowSignerClass)
                val _component_x_remarkshow = resolveEasyComponent("x-remarkshow", GenComponentsXRemarkshowClass)
                val _component_x_loading = resolveEasyComponent("x-loading", GenComponentsXLoadingClass)
                val _component_x_signer = resolveEasyComponent("x-signer", GenComponentsXSignerClass)
                val _component_x_model = resolveEasyComponent("x-model", GenComponentsXModelClass)
                return _cE("view", null, _uA(
                    _cV(_component_x_viewtitle, _uM("title" to "任务详情", "status" to unref(info)["status_name"], "color" to unref(info)["status_color"]), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cV(_component_xp_popover, _uM("placement" to "bottom-right", "menus" to menusList, "onClickMenu" to clickMenu), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "handle display-flex"), _uA(
                                        _cV(_component_x_iconfont, _uM("name" to "caidan", "color" to "white", "height" to 21, "size" to "20")),
                                        _cE("text", _uM("class" to "content color-white"), "操作")
                                    ))
                                )
                            }
                            ), "_" to 1))
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "status",
                        "color"
                    )),
                    _cE("scroll-view", _uM("direction" to "vertical", "style" to _nS(_uM("height" to (unref(pageHeight) + "px")))), _uA(
                        _cE("view", _uM("class" to "datalist background-white"), _uA(
                            _cE("view", _uM("class" to "data display-flex"), _uA(
                                _cE("text", _uM("class" to "name"), "任务名称"),
                                _cE("text", _uM("class" to "content"), _tD(unref(info)["name"]), 1)
                            )),
                            _cE("view", _uM("class" to "data display-flex"), _uA(
                                _cE("text", _uM("class" to "name"), "店/仓"),
                                _cE("text", _uM("class" to "content"), _tD(unref(depart)["name"]), 1)
                            )),
                            _cE("view", _uM("class" to "data space-between"), _uA(
                                _cE("view", _uM("class" to "datainfo display-flex"), _uA(
                                    _cE("text", _uM("class" to "name"), "发起人"),
                                    _cE("text", _uM("class" to "content"), _tD(unref(addAdmin)["name"]) + "(No." + _tD(unref(addAdmin)["no"]) + ")", 1)
                                )),
                                _cV(_component_x_show_signer, _uM("type" to "stocktask", "subtype" to "add_admin", "infoid" to unref(info)["id"]), null, 8, _uA(
                                    "infoid"
                                ))
                            )),
                            _cE("view", _uM("class" to "data display-flex"), _uA(
                                _cE("text", _uM("class" to "name"), "任务编号"),
                                _cE("text", _uM("class" to "content"), _tD(unref(info)["no"]), 1)
                            )),
                            _cE("view", _uM("class" to "data display-flex"), _uA(
                                _cE("text", _uM("class" to "name"), "发起时间"),
                                _cE("text", _uM("class" to "content"), _tD(unref(info)["add_time"]), 1)
                            )),
                            if (isTrue(unref(info)["start_time"])) {
                                _cE("view", _uM("key" to 0, "class" to "data display-flex"), _uA(
                                    _cE("text", _uM("class" to "name"), "开始时间"),
                                    _cE("text", _uM("class" to "content"), _tD(unref(info)["start_time"]), 1)
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                            ,
                            if (isTrue(unref(info)["end_time"])) {
                                _cE("view", _uM("key" to 1, "class" to "data display-flex"), _uA(
                                    _cE("text", _uM("class" to "name"), "结束时间"),
                                    _cE("text", _uM("class" to "content"), _tD(unref(info)["end_time"]), 1)
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                            ,
                            _cE("view", _uM("class" to "data display-flex", "style" to _nS(_uM("border-bottom" to "0px solid"))), _uA(
                                _cE("text", _uM("class" to "name"), "负责人"),
                                _cE("text", _uM("class" to "content"), _tD(unref(admin)["name"]) + "(No." + _tD(unref(admin)["no"]) + ")", 1)
                            ), 4)
                        )),
                        _cV(_component_x_remarkshow, _uM("remark" to unref(info)["remark"], "thumb" to unref(info)["thumb"]), null, 8, _uA(
                            "remark",
                            "thumb"
                        )),
                        _cE("view", _uM("class" to "datalist background-white", "style" to _nS(_uM("border-top" to "1px solid #e8e8e8", "padding-bottom" to "20rpx"))), _uA(
                            _cE("text", _uM("class" to "task"), "已加入任务"),
                            _cE("view", _uM("class" to "userlist"), _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(unref(userList), fun(item, index, __index, _cached): Any {
                                    return _cE("view", _uM("class" to "space-between item", "key" to index), _uA(
                                        _cE("text", _uM("class" to "name"), _tD(item["name"]) + "（No." + _tD(item["no"]) + "）", 1),
                                        _cE("text", _uM("class" to "time"), _tD(item["add_time"]), 1)
                                    ))
                                }
                                ), 128)
                            ))
                        ), 4)
                    ), 4),
                    if (isTrue(unref(info)["start_time"])) {
                        _cE("view", _uM("key" to 0, "class" to "actions position-fixed background-main"), _uA(
                            _cE("view", _uM("class" to "action chexiaobtn display-flex margin-bottom", "onClick" to joinTask), _uA(
                                _cE("text", _uM("class" to "name color-white align-center"), "加入并开始")
                            ))
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    if (isTrue(unref(info)["start_time"] == null && unref(admin)["id"] == unref(user)["id"])) {
                        _cE("view", _uM("key" to 1, "class" to "actions position-fixed background-main"), _uA(
                            _cE("view", _uM("class" to "action chexiaobtn display-flex margin-bottom", "onClick" to joinTask), _uA(
                                _cE("text", _uM("class" to "name color-white align-center"), "加入并开始")
                            ))
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    if (isTrue(unref(info)["start_time"] == null && unref(admin)["id"] != unref(user)["id"])) {
                        _cE("view", _uM("key" to 2, "class" to "actions position-fixed disablecolor"), _uA(
                            _cE("view", _uM("class" to "action chexiaobtn display-flex margin-bottom"), _uA(
                                _cE("text", _uM("class" to "name color-white align-center"), "请联系负责人开始")
                            ))
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    _cV(_component_x_loading, _uM("ref_key" to "loading", "ref" to loading), null, 512),
                    _cV(_component_x_signer, _uM("ref_key" to "signer", "ref" to signer), null, 512),
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
                return _uM("content" to _uM(".handle " to _uM("lineHeight" to "21px", "fontSize" to 14, "marginLeft" to "8rpx"), ".datalist .data " to _uM("marginLeft" to "30rpx", "width" to "450rpx", "fontSize" to 15, "lineHeight" to "34px")), "datalist" to _pS(_uM("borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#E8E8E8", "marginBottom" to 8)), "data" to _uM(".datalist " to _uM("height" to 35, "marginLeft" to "20rpx", "marginRight" to "20rpx", "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#e8e8e8")), "name" to _uM(".datalist .data " to _uM("width" to "154rpx", "textAlign" to "right", "fontSize" to 15, "color" to "#ABABAB", "lineHeight" to "34px"), ".datalist .userlist .item " to _uM("fontSize" to 14, "lineHeight" to "22px"), ".actions " to _uM("fontSize" to 16, "lineHeight" to "40px", "width" to "750rpx")), "task" to _uM(".datalist " to _uM("marginLeft" to "30rpx", "fontSize" to 14, "color" to "#ABABAB", "marginTop" to "20rpx")), "userlist" to _uM(".datalist " to _uM("marginLeft" to "30rpx", "marginRight" to "30rpx", "marginTop" to "10rpx")), "item" to _uM(".datalist .userlist " to _uM("height" to 22)), "time" to _uM(".datalist .userlist .item " to _uM("lineHeight" to "22px", "fontSize" to 14, "color" to "#ABABAB")), "actions" to _pS(_uM("bottom" to 0, "left" to 0, "width" to "750rpx")), "action" to _uM(".actions " to _uM("height" to 40, "width" to "750rpx")), "disablecolor" to _pS(_uM("backgroundColor" to "#ABABAB")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
