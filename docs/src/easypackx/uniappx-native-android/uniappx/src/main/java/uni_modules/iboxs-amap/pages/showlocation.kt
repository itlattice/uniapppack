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
import uts.sdk.modules.iboxsAmap.IboxsAmapComponent
import uts.sdk.modules.iboxsAmap.IboxsAmapElement
import uts.sdk.modules.iboxsAmap.MarkerInfo
import uts.sdk.modules.iboxsAmap.MylocationInfo
import uts.sdk.modules.iboxsAmap.Poi
import uts.sdk.modules.iboxsAmap.PoiListResult
import uts.sdk.modules.iboxsAmap.UISettingConfig
import uts.sdk.modules.iboxsAmap.poiAroundSearch
import uts.sdk.modules.iboxsAmap.stopLocation
import uts.sdk.modules.iboxsZimfacade.faceVerify
import uts.sdk.modules.iboxsZimfacade.getMetaInfo
import uts.sdk.modules.iboxsZimfacade.initZimfacafe
import uts.sdk.modules.iboxsZimfacade.setUI
import io.dcloud.uniapp.extapi.getElementById as uni_getElementById
import uts.sdk.modules.iboxsAmap.getInstalledMapApps
import uts.sdk.modules.iboxsAmap.openMapNavigation
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
import io.dcloud.uniapp.extapi.navigateBack as uni_navigateBack
import io.dcloud.uniapp.extapi.showToast as uni_showToast
import uts.sdk.modules.iboxsAmap.singleLocation
import uts.sdk.modules.iboxsAmap.LocationError
import uts.sdk.modules.iboxsAmap.LatLng
import uts.sdk.modules.iboxsAmap.openLocation
import uts.sdk.modules.iboxsAmap.chooseLocation
open class GenUniModulesIboxsAmapPagesShowlocation : BasePage {
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
        var setup: (__props: GenUniModulesIboxsAmapPagesShowlocation) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesIboxsAmapPagesShowlocation
            val _cache = __ins.renderCache
            val menu = ref(_uA<bottomMenu__2>())
            val visible = ref(false)
            val aMap = ref<IboxsAmapElement?>(null)
            val poi = ref(LatLng(lat = 0, lng = 0))
            val mapInit = ref(UISettingConfig(isZoomControlsEnabled = false, LogoPosition = "POSITION_BOTTOM_RIGHT"))
            val addressName = ref("")
            val distance = ref(0)
            val title = ref("")
            val mapHeight = ref(0)
            val initlocation = ref("")
            val back = fun(){
                uni_navigateBack(null)
            }
            val closeMenu = fun(){
                visible.value = false
            }
            val menuClick = fun(key: String){
                console.log("菜单点击", key)
                if (key == "cancel") {
                    closeMenu()
                    return
                }
                openMapNavigation(key, poi.value, title.value)
            }
            val startDaohang = fun(){
                var res = getInstalledMapApps()
                if (res.length < 1) {
                    uni_showToast(ShowToastOptions(title = "未安装地图APP", icon = "none"))
                    return
                }
                console.log(res)
                menu.value = _uA()
                for(item in resolveUTSValueIterator(res)){
                    when (item) {
                        "com.autonavi.minimap" -> 
                            menu.value.push(bottomMenu__2(name = "高德地图", key = "com.autonavi.minimap"))
                        "com.baidu.BaiduMap" -> 
                            menu.value.push(bottomMenu__2(name = "百度地图", key = "com.baidu.BaiduMap"))
                        "com.tencent.map" -> 
                            menu.value.push(bottomMenu__2(name = "腾讯地图", key = "com.tencent.map"))
                    }
                }
                menu.value.push(bottomMenu__2(key = "cancel", name = "取消"))
                console.log(menu.value)
                visible.value = true
            }
            onLoad(fun(options){
                var lat = UTSNumber.from(options["lat"] as String) as Number
                var lng = UTSNumber.from(options["lng"] as String) as Number
                var name = options["address"] as String
                poi.value = LatLng(lat = lat, lng = lng)
                addressName.value = name
                title.value = options["title"] as String
                distance.value = UTSNumber.from(options["distance"] as String) as Number
                initlocation.value = JSON.stringify(_uO("lat" to lat, "lng" to lng, "zoom" to 14))
            }
            )
            onReady(fun(){
                var windowInfo = uni_getWindowInfo()
                mapHeight.value = windowInfo.windowHeight - 130
                aMap.value = uni_getElementById("amap") as IboxsAmapElement
                aMap.value?.setUI(mapInit.value)
                aMap.value!!.addMarkers(_uA<MarkerInfo>(MarkerInfo(title = "我的位置", id = "location", lat = poi.value.lat, lng = poi.value.lng, zIndex = 1, icon = "https://cdn.itgz8.com/image/icon/wlocation.png?v=4")))
                aMap.value!!.addMarkers(_uA<MarkerInfo>(MarkerInfo(title = "我的位置", id = "location", lat = poi.value.lat, lng = poi.value.lng, icon = "https://cdn.itgz8.com/image/icon/wlocation2.png", iconHeight = 120, iconWidth = 72, anchor = "bottomCenter", zIndex = 2)))
                setTimeout(fun(){
                    aMap.value!!.zootTo(15)
                }
                , 1500)
            }
            )
            return fun(): Any? {
                return _cE("view", _uM("class" to "iboxs-showlocation"), _uA(
                    _cE("view", _uM("class" to "map"), _uA(
                        _cE("view", _uM("class" to "mapinfo"), _uA(
                            _cE(IboxsAmapComponent.name, _uM("ref" to "amap", "id" to "amap", "style" to _nS(_uM("height" to (unref(mapHeight) + "px"))), "initlocation" to unref(initlocation), "class" to "mapview"), null, 12, _uA(
                                "initlocation"
                            )),
                            _cE("view", _uM("class" to "iboxs-topaction space-between"), _uA(
                                _cE("view", _uM("class" to "fanhui", "onClick" to back), _uA(
                                    _cV(unref(GenUniModulesIboxsAmapComponentsIboxsIconClass), _uM("class" to "icon", "name" to "xiangzuo1", "height" to 40, "color" to "#5C5C5C", "size" to "20"))
                                ))
                            ))
                        ))
                    )),
                    _cE("view", _uM("class" to "info"), _uA(
                        _cE("view", _uM("class" to "addressinfo"), _uA(
                            _cE("text", _uM("class" to "title overline"), _tD(unref(title)), 1),
                            _cE("view", _uM("class" to "content display-flex"), _uA(
                                if (unref(distance) > 0) {
                                    _cE("text", _uM("key" to 0, "class" to "contentdistance"), _tD(unref(distance)) + "m | ", 1)
                                } else {
                                    _cC("v-if", true)
                                }
                                ,
                                _cE("text", _uM("class" to "contentaddress overline2"), _tD(unref(addressName)), 1)
                            ))
                        )),
                        _cE("view", _uM("class" to "daohang"), _uA(
                            _cE("view", _uM("class" to "quan", "onClick" to startDaohang), _uA(
                                _cV(unref(GenUniModulesIboxsAmapComponentsIboxsIconClass), _uM("class" to "icon", "name" to "daohang", "color" to "white", "size" to "50", "height" to 75))
                            ))
                        ))
                    )),
                    _cV(unref(GenUniModulesIboxsAmapComponentsIboxsBottommenuClass), _uM("visible" to unref(visible), "onMenuClick" to menuClick, "menu" to unref(menu), "onClosePopup" to closeMenu), null, 8, _uA(
                        "visible",
                        "menu"
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
                return _uM("color-white" to _pS(_uM("color" to "#FFFFFF")), "list-items" to _pS(_uM("flexWrap" to "wrap", "flexDirection" to "row")), "litem" to _uM(".list-items " to _uM("flexGrow" to 0, "flexShrink" to 0)), "top-status-bar" to _pS(_uM("top" to CSS_VAR_STATUS_BAR_HEIGHT)), "padding-stauts-bar" to _pS(_uM("paddingTop" to CSS_VAR_STATUS_BAR_HEIGHT)), "margin-status-bar" to _pS(_uM("marginTop" to CSS_VAR_STATUS_BAR_HEIGHT)), "height-status-bar" to _pS(_uM("height" to CSS_VAR_STATUS_BAR_HEIGHT)), "safe-bottom" to _pS(_uM("bottom" to "var(--uni-safe-area-inset-bottom)")), "padding-safe-bottom" to _pS(_uM("paddingBottom" to "var(--uni-safe-area-inset-bottom)")), "safe-bottom-view" to _pS(_uM("width" to "750rpx", "left" to 0, "height" to "var(--uni-safe-area-inset-bottom)", "position" to "fixed", "bottom" to 0)), "overline" to _pS(_uM("whiteSpace" to "nowrap", "overflow" to "hidden", "textOverflow" to "ellipsis")), "overline2" to _pS(_uM("textOverflow" to "ellipsis", "lines" to 2)), "display-flex" to _pS(_uM("display" to "flex", "flexDirection" to "row")), "space-between" to _pS(_uM("justifyContent" to "space-between", "display" to "flex", "flexDirection" to "row")), "info" to _uM(".iboxs-showlocation " to _uM("backgroundColor" to "#FFFFFF", "width" to "750rpx", "height" to 130, "position" to "relative")), "addressinfo" to _uM(".iboxs-showlocation .info " to _uM("width" to "690rpx", "paddingLeft" to "35rpx", "paddingTop" to 10)), "title" to _uM(".iboxs-showlocation .info .addressinfo " to _uM("width" to "400rpx", "fontSize" to 24, "fontWeight" to "bold")), "daohang" to _uM(".iboxs-showlocation .info " to _uM("position" to "fixed", "right" to "60rpx", "bottom" to 90)), "quan" to _uM(".iboxs-showlocation .info .daohang " to _uM("width" to 80, "height" to 80, "borderTopLeftRadius" to 40, "borderTopRightRadius" to 40, "borderBottomRightRadius" to 40, "borderBottomLeftRadius" to 40, "backgroundColor" to "#1678fd")), "icon" to _uM(".iboxs-showlocation .info .daohang .quan " to _uM("textAlign" to "center"), ".iboxs-topaction .fanhui " to _uM("textAlign" to "center")), "content" to _uM(".iboxs-showlocation .info " to _uM("width" to "690rpx", "marginTop" to 10)), "contentdistance" to _uM(".iboxs-showlocation .info .content " to _uM("fontSize" to 15, "color" to "#bfbfbf")), "contentaddress" to _uM(".iboxs-showlocation .info .content " to _uM("fontSize" to 15, "color" to "#bfbfbf")), "iboxs-topaction" to _pS(_uM("position" to "fixed", "top" to CSS_VAR_STATUS_BAR_HEIGHT, "zIndex" to 99, "left" to 0, "width" to "750rpx")), "fanhui" to _uM(".iboxs-topaction " to _uM("marginLeft" to "30rpx", "marginTop" to 14, "boxShadow" to "2px 2px 1px #bfbfbf", "height" to 40, "width" to 40, "backgroundColor" to "#ffffff", "borderTopLeftRadius" to 4, "borderTopRightRadius" to 4, "borderBottomRightRadius" to 4, "borderBottomLeftRadius" to 4)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
