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
import uts.sdk.modules.iboxsAmap.MapPosition
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
import io.dcloud.uniapp.extapi.getStorageSync as uni_getStorageSync
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
import io.dcloud.uniapp.extapi.setStorageSync as uni_setStorageSync
import io.dcloud.uniapp.extapi.showToast as uni_showToast
import uts.sdk.modules.iboxsAmap.singleLocation
import uts.sdk.modules.iboxsAmap.LocationError
import uts.sdk.modules.iboxsAmap.LatLng
import uts.sdk.modules.iboxsAmap.openLocation
import uts.sdk.modules.iboxsAmap.chooseLocation
open class GenUniModulesIboxsAmapPagesChooselocation : BasePage {
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
        var setup: (__props: GenUniModulesIboxsAmapPagesChooselocation) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesIboxsAmapPagesChooselocation
            val _cache = __ins.renderCache
            val aMap = ref<IboxsAmapElement?>(null)
            val mapInit = ref(UISettingConfig(isZoomControlsEnabled = false, LogoPosition = "POSITION_BOTTOM_RIGHT"))
            val showImg = ref(false)
            val imgLeft = ref(0)
            val locationReady = ref(false)
            val dingweiColor = ref("#000")
            val showRealSearch = ref(false)
            val initlocation = ref("")
            val pageHeight = ref(1000)
            val showHeightList = ref(false)
            val topDistanse = ref(0)
            val heightClass = ref("")
            val imgTop = ref(0)
            val activeIndex = ref(0)
            val haveScroll = ref(true)
            val keywords = ref("")
            val cityCode = ref("")
            val addressList = ref(_uA<Poi>())
            val centerLatLng = ref(_uO())
            val kwIndex = ref(0)
            val changeIndex = ref(0)
            val backBool = ref(false)
            val noSearch = ref(false)
            val mapHeight = computed(fun(): Number {
                var basic = pageHeight.value * 0.55
                return basic - topDistanse.value
            }
            )
            val listHeight = computed(fun(): Number {
                var jian: Number = 60
                if (showHeightList.value) {
                    jian = 90
                }
                return pageHeight.value - mapHeight.value - jian
            }
            )
            val showFujin = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        console.log("开始检索")
                        var center = LatLng(lat = centerLatLng.value["lat"] as Number, lng = centerLatLng.value["lng"] as Number)
                        poiAroundSearch(keywords.value, center, 500, cityCode.value, 15, 0, fun(res: PoiListResult){
                            console.log("检索成功", res)
                            addressList.value = res.list
                            activeIndex.value = 0
                        }
                        , fun(reson: String){
                            console.log("检索失败")
                        }
                        )
                })
            }
            val showMyLocation = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        aMap.value!!.zootTo(14)
                        singleLocation("None", "none", false, fun(res: UTSJSONObject){
                            console.log("定位成功", res)
                            cityCode.value = res["citycode"] as String
                            uni_setStorageSync("iboxs-userlocation", res)
                            aMap.value!!.changeLatLng(res["lat"] as Number, res["lon"] as Number)
                            locationReady.value = true
                            setTimeout(fun(){
                                aMap.value!!.zootTo(15)
                            }
                            , 500)
                            centerLatLng.value = _uO("lat" to res["lat"] as Number, "lng" to res["lon"] as Number)
                            showFujin()
                        }
                        , fun(reson: LocationError){
                            console.error("定位失败", reson)
                        }
                        )
                        aMap.value!!.showMyLocation(MylocationInfo(show = true, updatingMapCenter = false, icon = "https://cdn.itgz8.com/image/icon/wlocation.png?v=4", zIndex = 1))
                })
            }
            val back = fun(){
                backBool.value = true
                setTimeout(fun(){
                    backBool.value = false
                }
                , 50)
                uni__emit("/uni_modules/iboxs-amap/pages/chooselocation", _uO())
            }
            val regionWillChange = fun(res: MapPosition){
                console.log("regionWillChange", res)
                aMap.value!!.removeSomeMarkers(_uA(
                    "location"
                ))
                showImg.value = true
            }
            val dingweiBtn = fun(){
                showMyLocation()
            }
            val keyboardheightchange = fun(e: UniInputKeyboardHeightChangeEvent){
                console.log(e)
                var height = e.detail.height
                if (height == 0) {
                    if (keywords.value == "") {
                        showRealSearch.value = false
                        showHeightList.value = false
                    }
                }
            }
            val cacelBtn = fun(){
                keywords.value = ""
                showRealSearch.value = false
                showHeightList.value = false
            }
            val startSearch = fun(){
                showRealSearch.value = true
                showHeightList.value = true
            }
            val confirm = fun(){
                if (addressList.value.length < 1) {
                    uni_showToast(ShowToastOptions(title = "地址为空", icon = "none"))
                    return
                }
                backBool.value = true
                setTimeout(fun(){
                    backBool.value = false
                }
                , 50)
                var poi = addressList.value[activeIndex.value] as Poi
                var data: UTSJSONObject = _uO("adCode" to poi.adCode, "adName" to poi.adName, "address" to poi.address, "businessArea" to poi.businessArea, "cityCode" to poi.cityCode, "cityName" to poi.cityName, "direction" to poi.direction, "distance" to poi.distance, "id" to poi.id, "provinceCode" to poi.provinceCode, "province" to poi.province, "title" to poi.title, "typeCode" to poi.typeCode, "typeDes" to poi.typeDes, "lat" to poi.latlng?.lat, "lng" to poi.latlng?.lng)
                uni__emit("/uni_modules/iboxs-amap/pages/chooselocation", data)
            }
            val startNestedScroll = fun(e: UniScrollEvent){
                if (e.detail.scrollTop > 0) {
                    if (showHeightList.value == false) {
                        haveScroll.value = false
                        setTimeout(fun(){
                            haveScroll.value = true
                        }
                        , 300)
                    }
                    showHeightList.value = true
                } else if (e.detail.scrollTop <= 0) {
                    showHeightList.value = false
                }
            }
            val hideHeightList = fun(){
                showHeightList.value = false
            }
            val clearKeywords = fun(){
                keywords.value = ""
            }
            val regionDidChange = fun(res: MapPosition){
                console.log("regionDidChange", res)
                showImg.value = false
                centerLatLng.value = _uO("lat" to res.centerLat, "lng" to res.centerLng)
                if (locationReady.value) {
                    aMap.value!!.addMarkers(_uA<MarkerInfo>(MarkerInfo(title = "我的位置", id = "location", lat = res.centerLat, lng = res.centerLng, icon = "https://cdn.itgz8.com/image/icon/wlocation2.png", iconHeight = 120, iconWidth = 72, anchor = "bottomCenter", zIndex = 2)))
                }
                if (noSearch.value == false) {
                    clearTimeout(changeIndex.value)
                    changeIndex.value = setTimeout(fun(){
                        console.log("开始执行检索")
                        showFujin()
                    }
                    , 800)
                }
            }
            val clickPoi = fun(index: Number){
                activeIndex.value = index
                var poi = addressList.value[index] as Poi
                aMap.value!!.changeLatLngAnimal(poi.latlng?.lat as Number, poi.latlng?.lng as Number)
                centerLatLng.value = _uO("lat" to poi.latlng?.lat, "lng" to poi.latlng?.lng)
                noSearch.value = true
                setTimeout(fun(){
                    noSearch.value = false
                }
                , 500)
            }
            watch(keywords, fun(){
                clearTimeout(kwIndex.value)
                kwIndex.value = setTimeout(fun(){
                    showFujin()
                }
                , 800)
            }
            )
            watch(mapHeight, fun(newVal: Number){
                imgTop.value = newVal / 2 - 45
            }
            )
            watch(showHeightList, fun(newValue: Boolean){
                var max = pageHeight.value * 0.3
                if (newValue) {
                    var mapElem = uni_getElementById("amap")
                    mapElem?.style?.setProperty("height", (pageHeight.value * 0.55 - max) + "px")
                    var addressElem = uni_getElementById("addresslist")
                    addressElem?.style?.setProperty("height", (pageHeight.value * 0.45 + max) + "px")
                    topDistanse.value = max
                    aMap.value!!.removeSomeMarkers(_uA(
                        "location"
                    ))
                } else {
                    topDistanse.value = 0
                    var mapElem = uni_getElementById("amap")
                    mapElem?.style?.setProperty("height", (pageHeight.value * 0.55) + "px")
                    var addressElem = uni_getElementById("addresslist")
                    addressElem?.style?.setProperty("height", (pageHeight.value * 0.45) + "px")
                    aMap.value!!.addMarkers(_uA<MarkerInfo>(MarkerInfo(title = "我的位置", id = "location", lat = centerLatLng.value["lat"] as Number, lng = centerLatLng.value["lng"] as Number, icon = "https://cdn.itgz8.com/image/icon/wlocation2.png", iconHeight = 120, iconWidth = 72, anchor = "bottomCenter", zIndex = 2)))
                }
            }
            )
            onLoad(fun(_options){
                var windowInfo: GetWindowInfoResult = uni_getWindowInfo()
                var height = windowInfo.windowHeight
                pageHeight.value = height
                var location = uni_getStorageSync("iboxs-userlocation")
                if (location != "") {
                    location = location as UTSJSONObject
                    locationReady.value = true
                    initlocation.value = JSON.stringify(_uO("lat" to location["lat"] as Number, "lng" to location["lon"] as Number, "zoom" to 14))
                }
            }
            )
            onReady(fun(){
                var windowInfo: GetWindowInfoResult = uni_getWindowInfo()
                var height = windowInfo.windowHeight
                pageHeight.value = height
                aMap.value = uni_getElementById("amap") as IboxsAmapElement
                showMyLocation()
                aMap.value?.setUI(mapInit.value)
                imgLeft.value = (windowInfo.windowWidth - 24) / 2
                heightClass.value = "transition-height"
            }
            )
            onUnload(fun(){
                aMap.value!!.showMyLocation(MylocationInfo(show = false, updatingMapCenter = false))
                if (backBool.value == false) {
                    uni__emit("/uni_modules/iboxs-amap/pages/chooselocation", _uO())
                }
            }
            )
            onShow(fun(){
                if (aMap.value != null) {
                    aMap.value!!.showMyLocation(MylocationInfo(show = true, updatingMapCenter = false, icon = "https://cdn.itgz8.com/image/icon/wlocation.png?v=4", zIndex = 1))
                    aMap.value!!.removeSomeMarkers(_uA(
                        "location"
                    ))
                    showMyLocation()
                }
            }
            )
            onHide(fun(){
                aMap.value!!.showMyLocation(MylocationInfo(show = false, updatingMapCenter = false))
            }
            )
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                return _cE("view", _uM("class" to "iboxs-chooselocation"), _uA(
                    _cE("view", _uM("class" to "map"), _uA(
                        _cE("view", _uM("class" to "mapinfo"), _uA(
                            _cE(IboxsAmapComponent.name, _uM("ref" to "amap", "id" to "amap", "style" to _nS(_uM("height" to (unref(mapHeight) + "px"))), "initlocation" to unref(initlocation), "class" to _nC(_uA(
                                "mapview",
                                unref(heightClass)
                            )), "on:regionWillChange" to regionWillChange, "on:regionDidChange" to regionDidChange), null, 46, _uA(
                                "initlocation"
                            )),
                            _cE("view", _uM("class" to "iboxs-topaction space-between"), _uA(
                                _cE("text", _uM("class" to "iboxs-cancelbox", "onClick" to back), "取消"),
                                _cE("button", _uM("class" to "iboxs-confirmbtn", "hover-class" to "none", "onClick" to confirm), "确定")
                            )),
                            if (isTrue(unref(showImg) && unref(locationReady))) {
                                _cE("image", _uM("key" to 0, "style" to _nS(_uM("left" to (unref(imgLeft) + "px"), "top" to (unref(imgTop) + "px"))), "src" to "https://cdn.itgz8.com/image/icon/wlocation2.png", "mode" to "aspectFit", "class" to "icondw"), null, 4)
                            } else {
                                _cC("v-if", true)
                            }
                            ,
                            _cE("view", _uM("class" to "iboxs-dingweibtn", "onClick" to dingweiBtn), _uA(
                                _cV(unref(GenUniModulesIboxsAmapComponentsIboxsIconClass), _uM("class" to "icon", "name" to "dingwei", "color" to unref(dingweiColor), "size" to "28", "height" to 40), null, 8, _uA(
                                    "color"
                                ))
                            ))
                        ))
                    )),
                    _cE("view", _uM("class" to "iboxs-addressinfo transition-height", "id" to "addressinfo"), _uA(
                        if (isTrue(unref(showHeightList))) {
                            _cE("view", _uM("key" to 0, "class" to "xiangxiabtn", "onClick" to hideHeightList), _uA(
                                _cV(_component_x_iconfont, _uM("class" to "icon", "name" to "gundongtiao2", "color" to "#323232", "height" to 22, "size" to "24"))
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        if (isTrue(!unref(showRealSearch))) {
                            _cE("view", _uM("key" to 1, "class" to "jiainput display-flex"), _uA(
                                _cE("view", _uM("class" to "searchbox display-flex", "style" to _nS(_uM("width" to "690rpx")), "onClick" to startSearch), _uA(
                                    _cE("view", _uM("class" to "display-flex", "style" to _nS(_uM("width" to "100px", "margin" to "0 auto"))), _uA(
                                        _cV(_component_x_iconfont, _uM("class" to "icon", "name" to "sousuo", "size" to "20", "height" to 42, "color" to "#b9b9b9")),
                                        _cE("text", _uM("class" to "ploca"), "搜索地点")
                                    ), 4)
                                ), 4)
                            ))
                        } else {
                            _cE("view", _uM("key" to 2, "class" to "realinput display-flex"), _uA(
                                _cE("view", _uM("class" to "searchbox display-flex", "style" to _nS(_uM("width" to "570rpx"))), _uA(
                                    _cV(_component_x_iconfont, _uM("class" to "icon", "name" to "sousuo", "size" to "20", "height" to 40, "color" to "#787878")),
                                    _cE("input", _uM("onKeyboardheightchange" to keyboardheightchange, "modelValue" to unref(keywords), "onInput" to fun(`$event`: UniInputEvent){
                                        trySetRefValue(keywords, `$event`.detail.value)
                                    }
                                    , "ref" to "searchinput", "focus" to true, "type" to "text", "placeholder" to "搜索地点", "adjust-position" to "true", "confirm-type" to "search", "class" to "searchinput"), null, 40, _uA(
                                        "modelValue"
                                    )),
                                    if (unref(keywords).length > 0) {
                                        _cV(_component_x_iconfont, _uM("key" to 0, "onClick" to clearKeywords, "class" to "chachaicon", "name" to "chacha", "size" to "20", "height" to 40, "color" to "#787878"))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                ), 4),
                                _cE("text", _uM("class" to "cancel", "onClick" to cacelBtn), "取消")
                            ))
                        }
                        ,
                        _cE("scroll-view", _uM("id" to "addresslist", "class" to _nC(_uA(
                            "addresslist",
                            unref(heightClass)
                        )), "onScroll" to startNestedScroll, "direction" to if (unref(haveScroll)) {
                            "vertical"
                        } else {
                            "none"
                        }
                        , "style" to _nS(_uM("height" to (unref(listHeight) + "px")))), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(unref(addressList), fun(item, index, __index, _cached): Any {
                                return _cE("view", _uM("class" to "addresslistitem space-between", "hover-class" to "poihover", "key" to index, "onClick" to fun(){
                                    clickPoi(index)
                                }
                                ), _uA(
                                    _cE("view", _uM("class" to "dizhi"), _uA(
                                        _cE("text", _uM("class" to "addressname overline"), _tD(item.title), 1),
                                        _cE("text", _uM("class" to "distanse overline2"), _tD(item.distance) + "m | " + _tD(item.adName) + _tD(item.address), 1)
                                    )),
                                    if (index == unref(activeIndex)) {
                                        _cV(_component_x_iconfont, _uM("key" to 0, "name" to "gougou", "size" to "15", "class" to "gougouicon", "color" to "#1678fd"))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                ), 8, _uA(
                                    "onClick"
                                ))
                            }
                            ), 128)
                        ), 46, _uA(
                            "direction"
                        ))
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
                return _uM("color-white" to _pS(_uM("color" to "#FFFFFF")), "list-items" to _pS(_uM("flexWrap" to "wrap", "flexDirection" to "row")), "litem" to _uM(".list-items " to _uM("flexGrow" to 0, "flexShrink" to 0)), "top-status-bar" to _pS(_uM("top" to CSS_VAR_STATUS_BAR_HEIGHT)), "padding-stauts-bar" to _pS(_uM("paddingTop" to CSS_VAR_STATUS_BAR_HEIGHT)), "margin-status-bar" to _pS(_uM("marginTop" to CSS_VAR_STATUS_BAR_HEIGHT)), "height-status-bar" to _pS(_uM("height" to CSS_VAR_STATUS_BAR_HEIGHT)), "safe-bottom" to _pS(_uM("bottom" to "var(--uni-safe-area-inset-bottom)")), "padding-safe-bottom" to _pS(_uM("paddingBottom" to "var(--uni-safe-area-inset-bottom)")), "safe-bottom-view" to _pS(_uM("width" to "750rpx", "left" to 0, "height" to "var(--uni-safe-area-inset-bottom)", "position" to "fixed", "bottom" to 0)), "overline" to _pS(_uM("whiteSpace" to "nowrap", "overflow" to "hidden", "textOverflow" to "ellipsis")), "overline2" to _pS(_uM("textOverflow" to "ellipsis", "lines" to 2)), "display-flex" to _pS(_uM("display" to "flex", "flexDirection" to "row")), "space-between" to _pS(_uM("justifyContent" to "space-between", "display" to "flex", "flexDirection" to "row")), "iboxs-addressinfo" to _uM(".iboxs-chooselocation " to _uM("backgroundImage" to "none", "backgroundColor" to "#FFFFFF", "marginTop" to -10, "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "width" to "750rpx")), "xiangxiabtn" to _uM(".iboxs-chooselocation .iboxs-addressinfo " to _uM("width" to 45, "height" to 20, "backgroundColor" to "#f4f4f4", "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "borderBottomRightRadius" to 10, "borderBottomLeftRadius" to 10, "marginTop" to 10, "marginRight" to "auto", "marginBottom" to 0, "marginLeft" to "auto")), "icon" to _uM(".iboxs-chooselocation .iboxs-addressinfo .xiangxiabtn " to _uM("textAlign" to "center"), ".iboxs-chooselocation .iboxs-addressinfo .realinput " to _uM("marginLeft" to "20rpx", "marginRight" to "15rpx"), ".iboxs-chooselocation .map .iboxs-dingweibtn " to _uM("textAlign" to "center")), "jiainput" to _uM(".iboxs-chooselocation .iboxs-addressinfo " to _uM("height" to 65, "width" to "750rpx", "backgroundColor" to "#FFFFFF")), "ploca" to _uM(".iboxs-chooselocation .iboxs-addressinfo .jiainput " to _uM("fontSize" to 17, "lineHeight" to "40px", "marginLeft" to "12rpx", "color" to "#b9b9b9")), "searchbox" to _uM(".iboxs-chooselocation .iboxs-addressinfo " to _uM("height" to 40, "backgroundColor" to "#ededed", "marginLeft" to "30rpx", "marginTop" to 15, "borderTopLeftRadius" to 6, "borderTopRightRadius" to 6, "borderBottomRightRadius" to 6, "borderBottomLeftRadius" to 6)), "searchinput" to _uM(".iboxs-chooselocation .iboxs-addressinfo .realinput " to _uM("width" to "440rpx")), "chahcaicon" to _uM(".iboxs-chooselocation .iboxs-addressinfo .realinput " to _uM("marginLeft" to "10rpx")), "cancel" to _uM(".iboxs-chooselocation .iboxs-addressinfo .realinput " to _uM("marginTop" to 15, "lineHeight" to "40px", "fontSize" to 16, "color" to "#6e7e9e", "width" to "140rpx", "textAlign" to "center")), "addresslist" to _uM(".iboxs-chooselocation .iboxs-addressinfo " to _uM("marginTop" to 5)), "addresslistitem" to _uM(".iboxs-chooselocation .iboxs-addressinfo .addresslist " to _uM("paddingLeft" to "20rpx", "paddingRight" to "40rpx", "paddingTop" to 8, "paddingBottom" to 10, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#f4f4f4")), "gougouicon" to _uM(".iboxs-chooselocation .iboxs-addressinfo .addresslist .addresslistitem " to _uM("paddingTop" to 20)), "dizhi" to _uM(".iboxs-chooselocation .iboxs-addressinfo .addresslist .addresslistitem " to _uM("width" to "620rpx")), "addressname" to _uM(".iboxs-chooselocation .iboxs-addressinfo .addresslist .addresslistitem .dizhi " to _uM("fontSize" to 18)), "distanse" to _uM(".iboxs-chooselocation .iboxs-addressinfo .addresslist .addresslistitem .dizhi " to _uM("marginTop" to 8, "fontSize" to 15, "color" to "#cacaca")), "mapinfo" to _uM(".iboxs-chooselocation .map " to _uM("position" to "relative")), "iboxs-dingweibtn" to _uM(".iboxs-chooselocation .map " to _uM("height" to 40, "width" to 40, "position" to "absolute", "bottom" to 40, "left" to 16, "borderTopLeftRadius" to 4, "borderTopRightRadius" to 4, "borderBottomRightRadius" to 4, "borderBottomLeftRadius" to 4, "backgroundColor" to "#FFFFFF")), "icondw" to _uM(".iboxs-chooselocation .map " to _uM("position" to "fixed", "height" to 40, "width" to 24)), "mapview" to _uM(".iboxs-chooselocation .map " to _uM("width" to "750rpx")), "iboxs-topaction" to _uM(".iboxs-chooselocation .map " to _uM("position" to "fixed", "top" to CSS_VAR_STATUS_BAR_HEIGHT, "zIndex" to 99, "left" to 0, "width" to "750rpx")), "iboxs-cancelbox" to _uM(".iboxs-chooselocation .map .iboxs-topaction " to _uM("marginTop" to 10, "marginLeft" to "40rpx", "color" to "#000000", "textShadow" to "2px 2px 2px white", "height" to 35, "lineHeight" to "35px", "fontSize" to 16)), "iboxs-confirmbtn" to _uM(".iboxs-chooselocation .map .iboxs-topaction " to _uM("marginRight" to "30rpx", "marginTop" to 10, "color" to "#FFFFFF", "height" to 35, "lineHeight" to "35px", "fontSize" to 14, "backgroundColor" to "#1678fd")), "transition-height" to _pS(_uM("transitionProperty" to "height", "transitionDuration" to "0.3s")), "poihover" to _pS(_uM("backgroundColor" to "#f5f5f5")), "@TRANSITION" to _uM("transition-height" to _uM("property" to "height", "duration" to "0.3s")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
