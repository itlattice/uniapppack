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
import uts.sdk.modules.uniUsercapturescreen.OnUserCaptureScreenCallbackResult
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
import uts.sdk.modules.uniUsercapturescreen.offUserCaptureScreen as uni_offUserCaptureScreen
import uts.sdk.modules.uniUsercapturescreen.onUserCaptureScreen as uni_onUserCaptureScreen
open class GenPagesWarehouseRequiregoodsView : BasePage {
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
        var setup: (__props: GenPagesWarehouseRequiregoodsView) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesWarehouseRequiregoodsView
            val _cache = __ins.renderCache
            val orderID = ref(0)
            val menusList = _uA<UTSJSONObject>(_uO("name" to "撤销要货单", "key" to "cancel"), _uO("name" to "改单", "key" to "end"), _uO("name" to "发送单据", "key" to "share"))
            val examremark = ref("")
            val viewData = ref(_uO())
            val pageHeight = ref(0)
            val printUrl = ref("")
            val signer = ref<UniElement?>(null)
            val modal = ref<UniElement?>(null)
            val loading = ref<UniElement?>(null)
            val previewimg = ref<UniElement?>(null)
            val remarkwindow = ref<UniElement?>(null)
            val share = ref<UniElement?>(null)
            val admin = computed(fun(): UTSJSONObject {
                if (viewData.value["admin"] == null) {
                    return _uO()
                }
                return viewData.value["admin"] as UTSJSONObject
            }
            )
            val exam_user = computed(fun(): UTSJSONObject {
                if (viewData.value["exam_user"] == null) {
                    return _uO()
                }
                return viewData.value["exam_user"] as UTSJSONObject
            }
            )
            val goodslist = computed(fun(): UTSArray<UTSJSONObject> {
                if (viewData.value["items"] == null) {
                    return _uA<UTSJSONObject>()
                }
                return viewData.value["items"] as UTSArray<UTSJSONObject>
            }
            )
            val danpin = computed(fun(): Number {
                if (viewData.value["items"] == null) {
                    return 0
                }
                var items = viewData.value["items"] as UTSArray<UTSJSONObject>
                return items.length
            }
            )
            val depart = computed(fun(): UTSJSONObject {
                if (viewData.value["depart"] == null) {
                    return _uO()
                }
                return viewData.value["depart"] as UTSJSONObject
            }
            )
            val loadPageData = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        common.loading(loading.value)
                        var res = await(request.callapi("warehouse/requestorderview", _uO("id" to orderID.value)))
                        common.hideLoading(loading.value)
                        if (res.code < 0) {
                            common.toast(res.msg)
                            common.timeBack()
                            return@w1
                        }
                        viewData.value = res.data as UTSJSONObject
                })
            }
            val clickMenu = fun(menu: UTSJSONObject){
                console.log("收到点击菜单", menu)
                var key = menu["key"] as String
                when (key) {
                    "share" -> 
                        common.callMethod(share.value as Any, "open")
                }
            }
            val showPrintOrder = fun(){
                var pdf = viewData.value["order_pdf"]
                if (pdf == null) {
                    common.toast("尚未生成，请稍等")
                    return
                }
                printUrl.value = pdf as String
                console.log(printUrl.value)
                common.print(printUrl.value, "requestorder")
            }
            val examNoOrder = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        common.callMethod(remarkwindow.value as Any, "open")
                })
            }
            val addRemarkContent = fun(remark: String): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var query = await(common.showQuery(modal.value as Any, "确认审核不通过？"))
                        if (!query) {
                            return@w1
                        }
                        var sign = await(common.signer(signer.value as Any))
                        if (sign == null) {
                            return@w1
                        }
                        var res = await(request.callapi("warehouse/examrequestorder", _uO("id" to viewData.value["id"].toString(), "sign" to sign, "remark" to remark, "exam" to false)))
                        common.toast(res.msg)
                        if (res.code < 0) {
                            return@w1
                        }
                        loadPageData()
                })
            }
            val closeWindow = fun(){
                common.callMethod(remarkwindow.value as Any, "close")
            }
            val confirmOrder = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var query = await(common.showQuery(modal.value as Any, "确认审核通过？"))
                        if (!query) {
                            return@w1
                        }
                        var sign = await(common.signer(signer.value as Any))
                        if (sign == null) {
                            return@w1
                        }
                        var res = await(request.callapi("warehouse/examrequestorder", _uO("id" to viewData.value["id"].toString(), "sign" to sign, "remark" to "", "exam" to true)))
                        common.toast(res.msg)
                        if (res.code < 0) {
                            return@w1
                        }
                        loadPageData()
                })
            }
            val captureHandler = fun(res: OnUserCaptureScreenCallbackResult){
                console.log("监听到截屏", res)
            }
            onLoad(fun(query: OnLoadOptions){
                orderID.value = UTSNumber.from(query["id"] as String)
                loadPageData()
            }
            )
            onReady(fun(){
                pageHeight.value = uni_getWindowInfo().safeArea.height - 82
                uni_onUserCaptureScreen(captureHandler)
            }
            )
            onUnload(fun(){
                uni_offUserCaptureScreen(captureHandler)
            }
            )
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_xp_popover = resolveEasyComponent("xp-popover", GenComponentsXpPopoverXpPopoverClass)
                val _component_x_viewtitle = resolveEasyComponent("x-viewtitle", GenComponentsXViewtitleClass)
                val _component_x_show_signer = resolveEasyComponent("x-show-signer", GenComponentsXShowSignerClass)
                val _component_x_order_goods = resolveEasyComponent("x-order-goods", GenComponentsXOrderGoodsClass)
                val _component_x_remarkshow = resolveEasyComponent("x-remarkshow", GenComponentsXRemarkshowClass)
                val _component_x_signer = resolveEasyComponent("x-signer", GenComponentsXSignerClass)
                val _component_x_model = resolveEasyComponent("x-model", GenComponentsXModelClass)
                val _component_x_loading = resolveEasyComponent("x-loading", GenComponentsXLoadingClass)
                val _component_x_previewimg = resolveEasyComponent("x-previewimg", GenComponentsXPreviewimgClass)
                val _component_x_remarkwindow = resolveEasyComponent("x-remarkwindow", GenComponentsXRemarkwindowClass)
                val _component_ib_share = resolveEasyComponent("ib-share", GenUniModulesIboxsUiComponentsIboxsShareClass)
                return _cE("view", null, _uA(
                    _cV(_component_x_viewtitle, _uM("title" to "要货单详情", "status" to unref(viewData)["status_name"], "color" to unref(viewData)["status_color"]), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to "handleaction display-flex"), _uA(
                                _cE("view", _uM("class" to "copy action display-flex"), _uA(
                                    _cV(_component_x_iconfont, _uM("name" to "fuzhi1", "color" to "white", "size" to "18", "height" to 20)),
                                    _cE("text", _uM("class" to "name color-white"), "复制")
                                )),
                                _cV(_component_xp_popover, _uM("placement" to "bottom-right", "menus" to menusList, "onClickMenu" to clickMenu), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cE("view", _uM("class" to "gengduo action display-flex"), _uA(
                                            _cV(_component_x_iconfont, _uM("name" to "gengduo1", "color" to "white", "size" to "18", "height" to 20)),
                                            _cE("text", _uM("class" to "name color-white"), "更多")
                                        ))
                                    )
                                }
                                ), "_" to 1))
                            ))
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "status",
                        "color"
                    )),
                    _cE("scroll-view", _uM("direction" to "vertical", "style" to _nS(_uM("height" to (unref(pageHeight) + "px")))), _uA(
                        _cE("view", _uM("class" to "pagecard background-white cardborderbottom"), _uA(
                            _cE("view", _uM("class" to "lineitem space-between"), _uA(
                                _cE("view", _uM("class" to "pagedata display-flex"), _uA(
                                    _cE("text", _uM("class" to "title"), "单号"),
                                    _cE("text", _uM("class" to "content"), _tD(unref(viewData)["no"]), 1)
                                ))
                            )),
                            _cE("view", _uM("class" to "lineitem space-between"), _uA(
                                _cE("view", _uM("class" to "pagedata display-flex"), _uA(
                                    _cE("text", _uM("class" to "title"), "发起人"),
                                    _cE("text", _uM("class" to "content"), _tD(unref(admin)["name"]) + "(No." + _tD(unref(admin)["no"]) + ")", 1)
                                )),
                                _cV(_component_x_show_signer, _uM("type" to "requestorder", "subtype" to "admin", "infoid" to unref(viewData)["id"]), null, 8, _uA(
                                    "infoid"
                                ))
                            )),
                            _cE("view", _uM("class" to "lineitem space-between"), _uA(
                                _cE("view", _uM("class" to "pagedata display-flex"), _uA(
                                    _cE("text", _uM("class" to "title"), "发起时间"),
                                    _cE("text", _uM("class" to "content"), _tD(unref(viewData)["add_time"]), 1)
                                ))
                            )),
                            _cE("view", _uM("class" to "lineitem space-between"), _uA(
                                _cE("view", _uM("class" to "pagedata display-flex"), _uA(
                                    _cE("text", _uM("class" to "title"), "要货门店"),
                                    _cE("text", _uM("class" to "content"), _tD(unref(depart)["name"]), 1)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "pagecard goodscard background-white cardborder"), _uA(
                            _cE("view", _uM("class" to "titlebox space-between"), _uA(
                                _cE("text", _uM("class" to "title"), "商品明细"),
                                _cE("view", _uM("class" to "static display-flex"), _uA(
                                    _cE("text", _uM("class" to "piecenum"), "单品: " + _tD(unref(danpin)) + " 件数:" + _tD(unref(viewData)["piece"]), 1)
                                ))
                            )),
                            _cE("view", _uM("class" to "goodslist"), _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(unref(goodslist), fun(item, index, __index, _cached): Any {
                                    return _cE("view", _uM("key" to index), _uA(
                                        _cV(_component_x_order_goods, _uM("goods" to item), null, 8, _uA(
                                            "goods"
                                        ))
                                    ))
                                }
                                ), 128)
                            ))
                        )),
                        _cE("view", _uM("class" to "pagecard background-white cardborder"), _uA(
                            _cE("view", _uM("class" to "lineitem space-between"), _uA(
                                _cE("view", _uM("class" to "pagedata display-flex"), _uA(
                                    _cE("text", _uM("class" to "title"), "审核时间"),
                                    if (unref(viewData)["exam_admin_id"] == null) {
                                        _cE("text", _uM("key" to 0, "class" to "content color-red"), "未审核")
                                    } else {
                                        _cE("text", _uM("key" to 1, "class" to "content"), _tD(unref(viewData)["exam_time"]), 1)
                                    }
                                ))
                            )),
                            _cE("view", _uM("class" to "lineitem space-between"), _uA(
                                _cE("view", _uM("class" to "pagedata display-flex"), _uA(
                                    _cE("text", _uM("class" to "title"), "审核人"),
                                    if (isTrue(unref(exam_user)["name"])) {
                                        _cE("text", _uM("key" to 0, "class" to "content"), _tD(unref(exam_user)["name"]) + "(No." + _tD(unref(exam_user)["no"]) + ")", 1)
                                    } else {
                                        _cE("text", _uM("key" to 1, "class" to "content"))
                                    }
                                )),
                                if (isTrue(unref(exam_user)["name"])) {
                                    _cV(_component_x_show_signer, _uM("key" to 0, "type" to "requestorder", "subtype" to "exam_admin", "infoid" to unref(viewData)["id"]), null, 8, _uA(
                                        "infoid"
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                            )),
                            _cE("view", _uM("class" to "lineitem space-between"), _uA(
                                _cE("view", _uM("class" to "pagedata display-flex"), _uA(
                                    _cE("text", _uM("class" to "title"), "审核意见"),
                                    _cE("text", _uM("class" to "content"), _tD(unref(viewData)["exam_remark"]), 1)
                                ))
                            ))
                        )),
                        _cV(_component_x_remarkshow, _uM("remark" to unref(viewData)["remark"], "thumb" to unref(viewData)["thumb"]), null, 8, _uA(
                            "remark",
                            "thumb"
                        ))
                    ), 4),
                    if (unref(viewData)["status"] == 0) {
                        _cE("view", _uM("key" to 0, "class" to "actions position-fixed display-flex"), _uA(
                            _cE("view", _uM("class" to "action chexiaobtn display-flex", "onClick" to examNoOrder), _uA(
                                _cV(_component_x_iconfont, _uM("color" to "white", "size" to "18", "class" to "chexiao", "name" to "chexiao")),
                                _cE("text", _uM("class" to "name color-white"), "审核不通过")
                            )),
                            _cE("view", _uM("class" to "action confirmbtn display-flex", "onClick" to confirmOrder), _uA(
                                _cV(_component_x_iconfont, _uM("color" to "white", "size" to "18", "class" to "queren", "name" to "queren")),
                                _cE("text", _uM("class" to "name color-white"), "审核通过")
                            ))
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    if (UTSNumber.from(unref(viewData)["status"].toString()) > 0) {
                        _cE("view", _uM("key" to 1, "class" to "actions position-fixed display-flex"), _uA(
                            _cE("view", _uM("class" to "action chexiaobtn display-flex", "style" to _nS(_uM("width" to "750rpx", "padding-left" to "300rpx")), "onClick" to showPrintOrder), _uA(
                                _cV(_component_x_iconfont, _uM("color" to "white", "size" to "18", "class" to "queren", "name" to "dayin")),
                                _cE("text", _uM("class" to "name color-white"), "打印单据")
                            ), 4)
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    _cV(_component_x_signer, _uM("ref_key" to "signer", "ref" to signer), null, 512),
                    _cV(_component_x_model, _uM("ref_key" to "modal", "ref" to modal), null, 512),
                    _cV(_component_x_loading, _uM("ref_key" to "loading", "ref" to loading), null, 512),
                    _cV(_component_x_previewimg, _uM("ref_key" to "previewimg", "ref" to previewimg), null, 512),
                    _cV(_component_x_remarkwindow, _uM("ref_key" to "remarkwindow", "ref" to remarkwindow, "title" to "审核意见", "onAddRemark" to addRemarkContent, "onCloseWindow" to closeWindow, "remark" to unref(examremark)), null, 8, _uA(
                        "remark"
                    )),
                    _cV(_component_ib_share, _uM("ref_key" to "share", "ref" to share), null, 512)
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
                return _uM("name" to _uM(".handleaction " to _uM("fontSize" to 14, "marginLeft" to "8rpx", "lineHeight" to "22px"), ".actions " to _uM("fontSize" to 16, "paddingLeft" to "10rpx")), "gengduo" to _uM(".handleaction " to _uM("marginLeft" to "20rpx")), "actions" to _pS(_uM("bottom" to 0, "left" to 0, "paddingBottom" to "var(--uni-safe-area-inset-bottom)")), "action" to _uM(".actions " to _uM("height" to 40, "width" to "375rpx", "paddingTop" to 10)), "chexiaobtn" to _uM(".actions " to _uM("backgroundImage" to "none", "backgroundColor" to "#1776FC", "paddingLeft" to "100rpx")), "confirmbtn" to _uM(".actions " to _uM("backgroundImage" to "none", "backgroundColor" to "#ED3232", "paddingLeft" to "100rpx")), "menulist" to _pS(_uM("paddingLeft" to "10rpx", "paddingRight" to "10rpx", "paddingTop" to 5)), "menu" to _uM(".menulist " to _uM("height" to 40)), "content" to _uM(".menulist .menu " to _uM("lineHeight" to "40px", "fontSize" to 16), ".pagecard .lineitem .pagedata " to _uM("lineHeight" to "30px", "paddingLeft" to "29rpx", "fontSize" to 13)), "borderb" to _uM(".menulist " to _uM("borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#f5f5f5")), "pagecard" to _pS(_uM("paddingBottom" to 4, "paddingLeft" to "27rpx", "paddingRight" to "21rpx", "marginBottom" to 6)), "lineitem" to _uM(".pagecard " to _uM("height" to 30, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#f5f5f5")), "title" to _uM(".pagecard .lineitem .pagedata " to _uM("width" to "125rpx", "textAlign" to "right", "lineHeight" to "30px", "fontSize" to 13, "color" to "#ABABAB"), ".goodscard .titlebox " to _uM("color" to "#4D4D4D", "fontSize" to 13, "lineHeight" to "23px")), "goodscard" to _pS(_uM("paddingBottom" to 9, "paddingLeft" to 0, "paddingRight" to 0)), "titlebox" to _uM(".goodscard " to _uM("height" to 23, "paddingLeft" to 12, "paddingRight" to 6, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#f5f5f5")), "piecenum" to _uM(".goodscard .titlebox .static " to _uM("fontSize" to 13, "color" to "#454545", "lineHeight" to "23px")), "yugunum" to _uM(".goodscard .titlebox .static " to _uM("paddingLeft" to "20rpx", "paddingTop" to 3)), "t" to _uM(".goodscard .titlebox .static .yugunum " to _uM("lineHeight" to "23px", "fontSize" to 13, "color" to "#000000")), "num" to _uM(".goodscard .titlebox .static .yugunum " to _uM("lineHeight" to "23px", "fontSize" to 13, "color" to "#ff7700")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
