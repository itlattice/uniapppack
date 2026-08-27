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
import uts.sdk.modules.uniUsercapturescreen.SetUserCaptureScreenOptions as SetUserCaptureScreenOptions__1
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
import uts.sdk.modules.iboxsNotice.initNotice
import uts.sdk.modules.iboxsNotice.requestNoticePermission
import uts.sdk.modules.uniUsercapturescreen.setUserCaptureScreen as uni_setUserCaptureScreen
open class GenPagesIndexIndex : BasePage {
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
        var setup: (__props: GenPagesIndexIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesIndexIndex
            val _cache = __ins.renderCache
            val version = AppConfig.app_version()
            val pageHeight = ref(1440)
            val weather = ref(_uO())
            val shopList = ref(_uA(
                _uO()
            ) as UTSArray<UTSJSONObject>)
            val shop = ref(_uO("name" to "None"))
            val keywords = ref("")
            val eventID = ref(0)
            val menusList = ref(_uA<UTSJSONObject>(_uO("name" to "消息盒子", "key" to "msgbox", "point" to true), _uO("name" to "帮助中心", "key" to "helper"), _uO("name" to "打印设置", "key" to "print"), _uO("name" to "交班/下班", "key" to "endwork")))
            val updateInfo = ref(_uO())
            val loading = ref<Any?>(null)
            val update = ref<UniElement?>(null)
            val user = computed(fun(): userInfoType {
                return state.user
            }
            )
            val menuPermission = computed(fun(): UTSJSONObject {
                return state.menuPermission
            }
            )
            val upgradeApp = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var haveUpgrade = await(upgrade.check())
                        if (haveUpgrade == false) {
                            return@w1
                        }
                        var nextUpdateInfo = haveUpgrade as UTSJSONObject
                        updateInfo.value = nextUpdateInfo
                        common.callMethod(update.value as Any, "show")
                })
            }
            val clickMenu = fun(menu: UTSJSONObject){
                console.log("收到点击菜单", menu)
                var key = menu["key"] as String
                if (key == "msgbox") {
                    common.goto("/pages/user/message/msgbox")
                    return
                }
            }
            val queryMember = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        common.goto("/pages/common/browserAction?src=" + encodeURIComponent("https://www.itgz8.com/"))
                })
            }
            val scanCode = fun(code: Any): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        console.log("首页收到扫码", code)
                        keywords.value = code as String
                })
            }
            val getUserRule = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var res = await(request.callapi("user/usermenu", _uO()))
                        if (res.code < 0) {
                            common.toast(res.msg)
                            return@w1
                        }
                        var menuList = res.data as UTSArray<String>
                        console.log("菜单列表", menuList)
                        setMenuList(menuList)
                        console.log("菜单权限信息", menuPermission.value)
                })
            }
            val getShopList = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        console.log("获取店铺列表")
                        var res = await(request.callapi("depart/userdepartlist", _uO()))
                        if (res.code < 0) {
                            common.toast(res.msg)
                            return@w1
                        }
                        var data = res.data as UTSJSONObject
                        shopList.value = data["list"] as UTSArray<UTSJSONObject>
                        shop.value = data["usershop"] as UTSJSONObject
                        console.log("店铺列表", res)
                        getUserRule()
                })
            }
            val getPageData = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        common.loading(loading.value, "载入数据")
                        await(getShopList())
                        common.hideLoading(loading.value)
                })
            }
            val getWeather = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        console.log("获取天气")
                        var res = await(request.callapi("common/weather", _uO()))
                        if (res.code == -409) {
                            var loc = await(common.getLocationInfo("None", "none", false))
                            if (loc == false) {
                                common.toast("定位失败")
                                return@w1
                            }
                            loc = loc as LocationInfoResult
                            res = await(request.callapi("common/weather", _uO("code" to (loc as LocationInfoResult).area_code)))
                        }
                        if (res.code < 0) {
                            common.toast("天气获取失败")
                            return@w1
                        }
                        var data = res.data as UTSJSONObject
                        console.log("天气", data)
                        weather.value = data
                })
            }
            val chooseDepart = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var depart = await(common.navigatoEvent("/pages/common/choosedepart"))
                        if (depart["name"] == null) {
                            return@w1
                        }
                        console.log("响应", depart)
                        var res = await(request.callapi("user/setdepart", _uO("depart" to depart["id"])))
                        if (res.code < 0) {
                            common.toast(res.msg)
                            return@w1
                        }
                        shop.value = depart
                        getUserRule()
                        setUserDepart(depart["id"] as Number)
                })
            }
            val clearKeywords = fun(){
                keywords.value = ""
            }
            val toPage = fun(page: String){
                common.goto(page)
            }
            val topScanCode = fun(){}
            watch(user, fun(nextUser: userInfoType){
                if (nextUser.id != null && (nextUser.id as Number) > 0) {
                    getPageData()
                }
            }
            )
            onLoad(fun(_options){
                uni_setUserCaptureScreen(SetUserCaptureScreenOptions__1(enable = false))
                pageHeight.value = uni_getWindowInfo().windowHeight
            }
            )
            onReady(fun(){
                getWeather()
                var currentUser = user.value
                console.log(currentUser.id)
                if (currentUser.id != null && (currentUser.id as Number) > 0) {
                    getPageData()
                }
                initNotice()
                requestNoticePermission(fun(r: Boolean){
                    console.log("通知权限")
                }
                )
            }
            )
            onShow(fun(){
                common.navigationBar()
                console.log("首页index开始监听扫码")
                eventID.value = uni__on("scanCode", scanCode)
                common.showPage()
                setTimeout(fun(){
                    upgradeApp()
                }
                , 1500)
            }
            )
            onHide(fun(){
                console.log("首页index停止监听扫码")
                uni__off("scanCode", eventID.value)
            }
            )
            onUnload(fun(){
                uni__off("scanCode", eventID.value)
            }
            )
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_xp_popover_menu = resolveEasyComponent("xp-popover-menu", GenComponentsXpPopoverMenuXpPopoverMenuClass)
                val _component_x_action = resolveEasyComponent("x-action", GenComponentsXActionClass)
                val _component_x_model = resolveEasyComponent("x-model", GenComponentsXModelClass)
                val _component_x_loading = resolveEasyComponent("x-loading", GenComponentsXLoadingClass)
                val _component_x_update_window = resolveEasyComponent("x-update-window", GenComponentsXUpdateWindowClass)
                val _component_x_signer = resolveEasyComponent("x-signer", GenComponentsXSignerClass)
                return _cE("view", _uM("class" to "index"), _uA(
                    _cE("view", _uM("class" to "background-main padding-stauts-bar"), _uA(
                        _cE("view", _uM("class" to "topaction display-flex"), _uA(
                            _cE("view", _uM("class" to "leftshop display-flex", "onClick" to chooseDepart), _uA(
                                _cE("view", _uM("class" to "leftinfo"), _uA(
                                    _cE("text", _uM("class" to "shopname color-white text font"), _tD(shop.value["name"]), 1),
                                    if (isTrue(weather.value["name"])) {
                                        _cE("text", _uM("key" to 0, "class" to "tianqi color-white text font"), _tD(weather.value["name"]) + " " + _tD(weather.value["temperature"]) + "℃", 1)
                                    } else {
                                        _cC("v-if", true)
                                    }
                                )),
                                _cV(_component_x_iconfont, _uM("class" to "actionxia", "name" to "xiangxia", "color" to "#ffffff", "size" to "11"))
                            )),
                            _cE("view", _uM("class" to "seachinputbox background-white display-flex"), _uA(
                                _cV(_component_x_iconfont, _uM("class" to "sousuoicon", "size" to "14", "name" to "sousuo")),
                                _cE("view", _uM("class" to "searchinput"), _uA(
                                    _cE("input", _uM("type" to "text", "modelValue" to keywords.value, "onInput" to fun(`$event`: UniInputEvent){
                                        keywords.value = `$event`.detail.value
                                    }
                                    , "placeholder" to "快速检索订单/账单", "class" to "inp"), null, 40, _uA(
                                        "modelValue",
                                        "onInput"
                                    ))
                                )),
                                _cE("view", _uM("class" to "chachaicon", "onClick" to clearKeywords), _uA(
                                    if (keywords.value.length > 0) {
                                        _cV(_component_x_iconfont, _uM("key" to 0, "name" to "chacha", "class" to "chacha", "color" to "#C4C4C4", "size" to "16"))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                )),
                                _cE("view", _uM("class" to "chachaicon", "onClick" to topScanCode), _uA(
                                    _cV(_component_x_iconfont, _uM("name" to "saoyisao", "class" to "saoyisao", "color" to "#1776FC", "size" to "18"))
                                )),
                                _cE("text", _uM("class" to "label left-border color-main text align-center font"), "搜索")
                            )),
                            _cV(_component_xp_popover_menu, _uM("placement" to "bottom-right", "menus" to menusList.value, "onClickMenu" to clickMenu), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "gengduo"), _uA(
                                        _cV(_component_x_iconfont, _uM("name" to "tianjia", "color" to "#fff", "size" to "22")),
                                        _cE("text", _uM("class" to "msgnumber"), "9+")
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "menus"
                            ))
                        ))
                    )),
                    _cE("scroll-view", _uM("class" to "pageheight", "show-scrollbar" to false, "style" to _nS(_uM("height" to pageHeight.value)), "scroll-y" to "true"), _uA(
                        _cE("view", _uM("class" to "indextopback weight-full position-relative"), _uA(
                            _cE("view", _uM("class" to "topback weight-full")),
                            _cE("view", _uM("class" to "back weight-full")),
                            _cE("view", _uM("class" to "pageindex position-absolute"), _uA(
                                _cE("view", _uM("class" to "indextopaction display-flex"), _uA(
                                    if (isTrue(menuPermission.value["casher"])) {
                                        _cE("view", _uM("key" to 0, "class" to "actionindex"), _uA(
                                            _cE("view", _uM("class" to "icon"), _uA(
                                                _cV(_component_x_iconfont, _uM("class" to "ic", "size" to "30", "color" to "#fff", "name" to "shouyinguanli"))
                                            )),
                                            _cE("view", _uM("class" to "actioncontent"), _uA(
                                                _cE("text", _uM("class" to "color-white align-center text"), "移动收银")
                                            ))
                                        ))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                    ,
                                    if (isTrue(menuPermission.value["direct_payment"])) {
                                        _cE("view", _uM("key" to 1, "class" to "actionindex", "onClick" to fun(){
                                            toPage("/pages/casher/receive")
                                        }), _uA(
                                            _cE("view", _uM("class" to "icon"), _uA(
                                                _cV(_component_x_iconfont, _uM("class" to "ic", "size" to "30", "color" to "#fff", "name" to "yingshoukuan"))
                                            )),
                                            _cE("view", _uM("class" to "actioncontent"), _uA(
                                                _cE("text", _uM("class" to "color-white align-center text"), "直接收款")
                                            ))
                                        ), 8, _uA(
                                            "onClick"
                                        ))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                    ,
                                    if (isTrue(menuPermission.value["goodsquery"])) {
                                        _cE("view", _uM("key" to 2, "class" to "actionindex", "onClick" to fun(){
                                            toPage("/pages/goods/query")
                                        }), _uA(
                                            _cE("view", _uM("class" to "icon"), _uA(
                                                _cV(_component_x_iconfont, _uM("class" to "ic", "size" to "30", "color" to "#fff", "name" to "shangpinchaxun"))
                                            )),
                                            _cE("view", _uM("class" to "actioncontent"), _uA(
                                                _cE("text", _uM("class" to "color-white align-center text"), "商品查询")
                                            ))
                                        ), 8, _uA(
                                            "onClick"
                                        ))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                    ,
                                    if (isTrue(menuPermission.value["todayanalysis"])) {
                                        _cE("view", _uM("key" to 3, "class" to "actionindex", "onClick" to fun(){
                                            toPage("/pages/analysis/todayanalysis")
                                        }), _uA(
                                            _cE("view", _uM("class" to "icon"), _uA(
                                                _cV(_component_x_iconfont, _uM("class" to "ic", "size" to "30", "color" to "#fff", "name" to "tongji"))
                                            )),
                                            _cE("view", _uM("class" to "actioncontent"), _uA(
                                                _cE("text", _uM("class" to "color-white align-center text"), "今日统计")
                                            ))
                                        ), 8, _uA(
                                            "onClick"
                                        ))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "quickaction background-white"), _uA(
                            _cE("text", _uM("class" to "title text"), "快捷操作"),
                            _cE("view", _uM("class" to "actions list-items"), _uA(
                                if (isTrue(menuPermission.value["goodsruku"])) {
                                    _cE("view", _uM("key" to 0, "class" to "action-item litem"), _uA(
                                        _cV(_component_x_action, _uM("onClick" to fun(){
                                            toPage("/pages/warehouse/instorage/addinstorage")
                                        }, "icon" to "ruku", "color" to "#D65454", "name" to "商品入库"), null, 8, _uA(
                                            "onClick"
                                        ))
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                                ,
                                if (isTrue(menuPermission.value["goodschuku"])) {
                                    _cE("view", _uM("key" to 1, "class" to "action-item litem"), _uA(
                                        _cV(_component_x_action, _uM("onClick" to fun(){
                                            toPage("/pages/warehouse/outstorage/addoutstorage")
                                        }, "icon" to "chuku", "color" to "#EB6A4D", "name" to "商品出库"), null, 8, _uA(
                                            "onClick"
                                        ))
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                                ,
                                _cE("view", _uM("class" to "action-item litem"), _uA(
                                    _cV(_component_x_action, _uM("icon" to "hexiao", "color" to "#7FC930", "name" to "商品核销"))
                                )),
                                _cE("view", _uM("class" to "action-item litem"), _uA(
                                    _cV(_component_x_action, _uM("icon" to "return_loaded", "color" to "#40C2B3", "name" to "生鲜进场"))
                                )),
                                if (isTrue(menuPermission.value["stocktask"])) {
                                    _cE("view", _uM("key" to 2, "class" to "action-item litem", "onClick" to fun(){
                                        toPage("/pages/warehouse/stocktasking/stocktask")
                                    }), _uA(
                                        _cV(_component_x_action, _uM("icon" to "kucunpandian", "color" to "#00C9DD", "name" to "库存盘点"))
                                    ), 8, _uA(
                                        "onClick"
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                                ,
                                _cE("view", _uM("class" to "action-item litem"), _uA(
                                    _cV(_component_x_action, _uM("icon" to "taocan", "color" to "#C91E7C", "name" to "商品套餐"))
                                )),
                                _cE("view", _uM("class" to "action-item litem"), _uA(
                                    _cV(_component_x_action, _uM("icon" to "huiyuanchaxun", "color" to "#C7384B", "name" to "会员查询", "onClick" to queryMember))
                                )),
                                if (isTrue(menuPermission.value["allocate"])) {
                                    _cE("view", _uM("key" to 3, "class" to "action-item litem"), _uA(
                                        _cV(_component_x_action, _uM("icon" to "mm_dep_cangkukucuntiaopei", "onClick" to fun(){
                                            toPage("/pages/warehouse/allocate/allocate")
                                        }, "color" to "#2433BD", "name" to "库存调配"), null, 8, _uA(
                                            "onClick"
                                        ))
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                            ))
                        )),
                        if (isTrue(unref(AppConfig).isDebug)) {
                            _cE("view", _uM("key" to 0, "class" to "action-panel background-white"), _uA(
                                _cE("text", _uM("class" to "title text"), "组件测试"),
                                _cE("view", _uM("class" to "actions list-items"), _uA(
                                    _cE("view", _uM("class" to "action-item litem"), _uA(
                                        _cV(_component_x_action, _uM("icon" to "shangpinliebiao", "name" to "PDF显示", "onClick" to fun(){
                                            toPage("/pages/test/pdf")
                                        }), null, 8, _uA(
                                            "onClick"
                                        ))
                                    )),
                                    _cE("view", _uM("class" to "action-item litem"), _uA(
                                        _cV(_component_x_action, _uM("icon" to "zizhimoban", "name" to "地图显示", "onClick" to fun(){
                                            toPage("/pages/test/map")
                                        }), null, 8, _uA(
                                            "onClick"
                                        ))
                                    )),
                                    _cE("view", _uM("class" to "action-item litem"), _uA(
                                        _cV(_component_x_action, _uM("icon" to "zizhimoban", "name" to "功能测试", "onClick" to fun(){
                                            toPage("/pages/test/program")
                                        }), null, 8, _uA(
                                            "onClick"
                                        ))
                                    )),
                                    _cE("view", _uM("class" to "action-item litem"), _uA(
                                        _cV(_component_x_action, _uM("icon" to "zizhimoban", "name" to "支付码", "onClick" to fun(){
                                            toPage("/pages/test/paycode")
                                        }), null, 8, _uA(
                                            "onClick"
                                        ))
                                    )),
                                    _cE("view", _uM("class" to "action-item litem"), _uA(
                                        _cV(_component_x_action, _uM("icon" to "zizhimoban", "name" to "浏览器内核", "onClick" to fun(){
                                            toPage("/pages/test/webview")
                                        }), null, 8, _uA(
                                            "onClick"
                                        ))
                                    )),
                                    _cE("view", _uM("class" to "action-item litem"), _uA(
                                        _cV(_component_x_action, _uM("icon" to "zizhimoban", "name" to "OCRTTS", "onClick" to fun(){
                                            toPage("/pages/test/ocrtts")
                                        }), null, 8, _uA(
                                            "onClick"
                                        ))
                                    ))
                                ))
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        _cE("view", _uM("class" to "action-panel background-white"), _uA(
                            _cE("text", _uM("class" to "title text"), "商品管理"),
                            _cE("view", _uM("class" to "actions list-items"), _uA(
                                if (isTrue(menuPermission.value["goodslist"])) {
                                    _cE("view", _uM("key" to 0, "class" to "action-item litem"), _uA(
                                        _cV(_component_x_action, _uM("icon" to "shangpinliebiao", "name" to "商品列表", "onClick" to fun(){
                                            toPage("/pages/goods/index")
                                        }), null, 8, _uA(
                                            "onClick"
                                        ))
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                                ,
                                _cE("view", _uM("class" to "action-item litem"), _uA(
                                    _cV(_component_x_action, _uM("icon" to "chaisan", "name" to "商品拆散"))
                                )),
                                _cE("view", _uM("class" to "action-item litem"), _uA(
                                    _cV(_component_x_action, _uM("icon" to "taocan", "name" to "商品套餐"))
                                )),
                                _cE("view", _uM("class" to "action-item litem"), _uA(
                                    _cV(_component_x_action, _uM("icon" to "biaoqian", "name" to "打印标签"))
                                )),
                                _cE("view", _uM("class" to "action-item litem"), _uA(
                                    _cV(_component_x_action, _uM("icon" to "jiaqian", "name" to "打印价签"))
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "action-panel background-white"), _uA(
                            _cE("text", _uM("class" to "title text"), "库存管理"),
                            _cE("view", _uM("class" to "actions list-items"), _uA(
                                if (isTrue(menuPermission.value["allocate"])) {
                                    _cE("view", _uM("key" to 0, "class" to "action-item litem"), _uA(
                                        _cV(_component_x_action, _uM("icon" to "mm_dep_cangkukucuntiaopei", "name" to "库存调配", "onClick" to fun(){
                                            toPage("/pages/warehouse/allocate/allocate")
                                        }), null, 8, _uA(
                                            "onClick"
                                        ))
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                                ,
                                if (isTrue(menuPermission.value["requiregoods"])) {
                                    _cE("view", _uM("key" to 1, "class" to "action-item litem"), _uA(
                                        _cV(_component_x_action, _uM("icon" to "yaohuodan", "onClick" to fun(){
                                            toPage("/pages/warehouse/requiregoods/list")
                                        }, "name" to "要货单"), null, 8, _uA(
                                            "onClick"
                                        ))
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                                ,
                                if (isTrue(menuPermission.value["stocktask"])) {
                                    _cE("view", _uM("key" to 2, "class" to "action-item litem", "onClick" to fun(){
                                        toPage("/pages/warehouse/stocktasking/stocktask")
                                    }), _uA(
                                        _cV(_component_x_action, _uM("icon" to "kucunpandian", "name" to "库存盘点"))
                                    ), 8, _uA(
                                        "onClick"
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                                ,
                                if (isTrue(menuPermission.value["goodsruku"])) {
                                    _cE("view", _uM("key" to 3, "class" to "action-item litem", "onClick" to fun(){
                                        toPage("/pages/warehouse/instorage/addinstorage")
                                    }), _uA(
                                        _cV(_component_x_action, _uM("icon" to "ruku", "name" to "商品入库"))
                                    ), 8, _uA(
                                        "onClick"
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                                ,
                                if (isTrue(menuPermission.value["goodschuku"])) {
                                    _cE("view", _uM("key" to 4, "class" to "action-item litem"), _uA(
                                        _cV(_component_x_action, _uM("icon" to "chuku", "name" to "商品出库", "onClick" to fun(){
                                            toPage("/pages/warehouse/outstorage/addoutstorage")
                                        }), null, 8, _uA(
                                            "onClick"
                                        ))
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                                ,
                                _cE("view", _uM("class" to "action-item litem"), _uA(
                                    _cV(_component_x_action, _uM("icon" to "hexiao", "name" to "商品核销"))
                                )),
                                _cE("view", _uM("class" to "action-item litem"), _uA(
                                    _cV(_component_x_action, _uM("icon" to "return_loaded", "name" to "生鲜进场"))
                                )),
                                _cE("view", _uM("class" to "action-item litem"), _uA(
                                    _cV(_component_x_action, _uM("icon" to "zidonghexiao", "name" to "商品核销"))
                                )),
                                if (isTrue(menuPermission.value["purchase"])) {
                                    _cE("view", _uM("key" to 5, "class" to "action-item litem", "onClick" to fun(){
                                        toPage("/pages/warehouse/purchase/purchase")
                                    }), _uA(
                                        _cV(_component_x_action, _uM("icon" to "jinhuodan", "name" to "进货单"))
                                    ), 8, _uA(
                                        "onClick"
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                                ,
                                if (isTrue(menuPermission.value["outstorage"])) {
                                    _cE("view", _uM("key" to 6, "class" to "action-item litem"), _uA(
                                        _cV(_component_x_action, _uM("icon" to "chukudan", "name" to "出库单", "onClick" to fun(){
                                            toPage("/pages/warehouse/outstorage/outstorage")
                                        }), null, 8, _uA(
                                            "onClick"
                                        ))
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                                ,
                                _cE("view", _uM("class" to "action-item litem"), _uA(
                                    _cV(_component_x_action, _uM("icon" to "huaizhanghexiaodan", "name" to "核销单"))
                                )),
                                if (isTrue(menuPermission.value["instorage"])) {
                                    _cE("view", _uM("key" to 7, "class" to "action-item litem", "onClick" to fun(){
                                        toPage("/pages/warehouse/instorage/instorage")
                                    }), _uA(
                                        _cV(_component_x_action, _uM("icon" to "rukudan", "name" to "入库单"))
                                    ), 8, _uA(
                                        "onClick"
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                                ,
                                _cE("view", _uM("class" to "action-item litem"), _uA(
                                    _cV(_component_x_action, _uM("icon" to "tuikuantuihuo", "name" to "退货单"))
                                )),
                                _cE("view", _uM("class" to "action-item litem"), _uA(
                                    _cV(_component_x_action, _uM("icon" to "linqishangpin", "name" to "临期查询"))
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "action-panel background-white"), _uA(
                            _cE("text", _uM("class" to "title text"), "账户管理"),
                            _cE("view", _uM("class" to "actions list-items"), _uA(
                                _cE("view", _uM("class" to "action-item litem"), _uA(
                                    _cV(_component_x_action, _uM("icon" to "zhifumingxi", "name" to "支付明细"))
                                )),
                                _cE("view", _uM("class" to "action-item litem"), _uA(
                                    _cV(_component_x_action, _uM("icon" to "wodexitongzhanghu", "name" to "系统账户"))
                                )),
                                _cE("view", _uM("class" to "action-item litem"), _uA(
                                    _cV(_component_x_action, _uM("icon" to "zijinliushui", "name" to "资金流水"))
                                )),
                                _cE("view", _uM("class" to "action-item litem"), _uA(
                                    _cV(_component_x_action, _uM("icon" to "qianxiang", "name" to "钱箱现金"))
                                )),
                                _cE("view", _uM("class" to "action-item litem"), _uA(
                                    _cV(_component_x_action, _uM("icon" to "fukuandanguanli", "name" to "付款单"))
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "action-panel background-white"), _uA(
                            _cE("text", _uM("class" to "title text"), "会员管理"),
                            _cE("view", _uM("class" to "actions list-items"), _uA(
                                _cE("view", _uM("class" to "action-item litem"), _uA(
                                    _cV(_component_x_action, _uM("icon" to "huiyuanchaxun", "name" to "会员查询"))
                                )),
                                _cE("view", _uM("class" to "action-item litem"), _uA(
                                    _cV(_component_x_action, _uM("icon" to "gongyingshang", "name" to "供应商"))
                                ))
                            ))
                        )),
                        _cE("view", _uM("style" to _nS(_uM("height" to "120px"))), null, 4)
                    ), 4),
                    _cV(_component_x_model, _uM("ref" to "modal"), null, 512),
                    _cV(_component_x_loading, _uM("ref_key" to "loading", "ref" to loading), null, 512),
                    _cV(_component_x_update_window, _uM("ref_key" to "update", "ref" to update, "info" to updateInfo.value), null, 8, _uA(
                        "info"
                    )),
                    _cV(_component_x_signer, _uM("ref" to "signer"), null, 512)
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
                return _uM("index" to _pS(_uM("width" to "750rpx")), "topaction" to _uM(".index " to _uM("backgroundColor" to "#1678fd", "paddingBottom" to "5rpx", "paddingTop" to "10rpx")), "leftshop" to _uM(".index .topaction " to _uM("width" to "142rpx", "paddingLeft" to "25rpx")), "shopname" to _uM(".index .topaction .leftshop " to _uM("fontSize" to 14)), "tianqi" to _uM(".index .topaction .leftshop " to _uM("fontSize" to 10, "paddingLeft" to "5rpx")), "actionxia" to _uM(".index .topaction .leftshop " to _uM("paddingTop" to 5, "paddingLeft" to "5rpx")), "seachinputbox" to _uM(".index .topaction " to _uM("marginLeft" to "10rpx", "height" to 30, "width" to "500rpx", "borderTopLeftRadius" to 15, "borderTopRightRadius" to 15, "borderBottomRightRadius" to 15, "borderBottomLeftRadius" to 15)), "sousuoicon" to _uM(".index .topaction .seachinputbox " to _uM("paddingLeft" to "15rpx", "paddingTop" to 8)), "searchinput" to _uM(".index .topaction .seachinputbox " to _uM("height" to 30, "paddingLeft" to "10rpx", "width" to "270rpx", "paddingTop" to 7)), "inp" to _uM(".index .topaction .seachinputbox .searchinput " to _uM("fontSize" to 14)), "label" to _uM(".index .topaction .seachinputbox " to _uM("height" to 18, "marginLeft" to "7rpx", "width" to "80rpx", "borderLeftWidth" to 1, "borderLeftStyle" to "solid", "borderLeftColor" to "#1678fd", "marginTop" to 7, "fontSize" to 14)), "saoyisao" to _uM(".index .topaction .seachinputbox " to _uM("marginTop" to 5, "marginRight" to "5rpx")), "chacha" to _uM(".index .topaction .seachinputbox " to _uM("marginTop" to 5, "marginRight" to "10rpx")), "chachaicon" to _uM(".index .topaction .seachinputbox " to _uM("width" to "45rpx", "height" to 55)), "gengduo" to _uM(".index .topaction " to _uM("paddingTop" to 4, "marginLeft" to "17rpx", "position" to "relative")), "msgnumber" to _uM(".index .topaction .gengduo " to _uM("width" to 16, "height" to 16, "borderTopLeftRadius" to 8, "borderTopRightRadius" to 8, "borderBottomRightRadius" to 8, "borderBottomLeftRadius" to 8, "backgroundColor" to "#FF0000", "position" to "absolute", "top" to -3, "right" to -4, "color" to "#FFFFFF", "lineHeight" to "16px", "textAlign" to "center", "fontSize" to 9)), "pageheight" to _uM(".index " to _uM("backgroundColor" to "#1678fd00")), "indextopback" to _uM(".index " to _uM("height" to "549rpx")), "topback" to _uM(".index .indextopback " to _uM("height" to "200rpx", "backgroundColor" to "#1678fd")), "back" to _uM(".index .indextopback " to _uM("height" to "253rpx", "backgroundImage" to "linear-gradient(to bottom, #1678fd, #1678fd00)")), "pageindex" to _uM(".index .indextopback " to _uM("width" to "100%", "top" to "40rpx")), "indextopaction" to _uM(".index .indextopback .pageindex " to _uM("paddingLeft" to "10rpx", "paddingRight" to "10rpx")), "actionindex" to _uM(".index .indextopback .pageindex .indextopaction " to _uM("width" to "25%", "marginTop" to 0, "marginRight" to "auto", "marginBottom" to 0, "marginLeft" to "auto")), "icon" to _uM(".index .indextopback .pageindex .indextopaction .actionindex " to _uM("width" to "100%", "marginTop" to 0, "marginRight" to "auto", "marginBottom" to 0, "marginLeft" to "auto")), "ic" to _uM(".index .indextopback .pageindex .indextopaction .actionindex .icon " to _uM("textAlign" to "center")), "actioncontent" to _uM(".index .indextopback .pageindex .indextopaction .actionindex " to _uM("paddingTop" to "15rpx")), "text" to _uM(".index .indextopback .pageindex .indextopaction .actionindex .actioncontent " to _uM("fontSize" to "27rpx")), "quickaction" to _uM(".index " to _uM("borderTopLeftRadius" to "10rpx", "borderTopRightRadius" to "10rpx", "borderBottomRightRadius" to "10rpx", "borderBottomLeftRadius" to "10rpx", "width" to "700rpx", "marginLeft" to "25rpx", "marginTop" to "-360rpx", "paddingLeft" to "25rpx", "paddingTop" to "17rpx", "position" to "relative", "paddingBottom" to 15)), "title" to _uM(".index .quickaction " to _uM("fontSize" to 14), ".index .action-panel " to _uM("fontSize" to 14)), "actions" to _uM(".index .quickaction " to _uM("width" to "100%", "marginLeft" to "-11rpx", "marginTop" to "-10rpx"), ".index .action-panel " to _uM("width" to "100%", "marginLeft" to "-11rpx", "marginTop" to -2)), "action-item" to _uM(".index .quickaction .actions " to _uM("flexBasis" to "25%", "marginTop" to "32rpx"), ".index .action-panel .actions " to _uM("flexBasis" to "25%", "marginTop" to 17)), "action-panel" to _uM(".index " to _uM("height" to "auto", "marginLeft" to "25rpx", "width" to "700rpx", "borderTopLeftRadius" to "10rpx", "borderTopRightRadius" to "10rpx", "borderBottomRightRadius" to "10rpx", "borderBottomLeftRadius" to "10rpx", "marginTop" to 10, "paddingLeft" to "25rpx", "paddingTop" to 10, "position" to "relative", "paddingBottom" to 15)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
