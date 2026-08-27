@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNIHelloUniAppX
import io.dcloud.uniapp.*
import io.dcloud.uniapp.extapi.*
import io.dcloud.uniapp.framework.*
import io.dcloud.uniapp.runtime.*
import io.dcloud.uniapp.vue.*
import io.dcloud.uniapp.vue.shared.*
import io.dcloud.unicloud.*
import io.dcloud.uts.*
import io.dcloud.uts.Map
import io.dcloud.uts.Set
import io.dcloud.uts.UTSAndroid
import kotlin.properties.Delegates
import io.dcloud.uniapp.extapi.`$emit` as uni__emit
import io.dcloud.uniapp.extapi.`$off` as uni__off
import io.dcloud.uniapp.extapi.`$on` as uni__on
import uts.sdk.modules.uniOpenLocation.OpenLocationOptions
import uts.sdk.modules.utsOpenSchema.canOpenURL
import io.dcloud.uniapp.extapi.closeDialogPage as uni_closeDialogPage
import io.dcloud.uniapp.extapi.createMapContext as uni_createMapContext
import io.dcloud.uniapp.extapi.getAppBaseInfo as uni_getAppBaseInfo
import io.dcloud.uniapp.extapi.getSystemInfoSync as uni_getSystemInfoSync
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
import io.dcloud.uniapp.extapi.onAppThemeChange as uni_onAppThemeChange
import io.dcloud.uniapp.extapi.onOsThemeChange as uni_onOsThemeChange
import uts.sdk.modules.utsOpenSchema.openSchema
import io.dcloud.uniapp.extapi.showActionSheet as uni_showActionSheet
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenUniModulesUniOpenLocationPagesOpenLocationOpenLocation : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onLoad(fun(_: OnLoadOptions) {
            stat_instance.onLoad(this)
        }
        , __ins)
        onPageShow(fun() {
            stat_instance.onShow(this)
        }
        , __ins)
        onPageHide(fun() {
            stat_instance.onHide(this)
        }
        , __ins)
        onUnload(fun() {
            stat_instance.onUnload(this)
        }
        , __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesUniOpenLocationPagesOpenLocationOpenLocation) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesUniOpenLocationPagesOpenLocationOpenLocation
            val _cache = __ins.renderCache
            val languageData: UTSJSONObject = _uO("en" to _uO("navigation" to "navigation"), "zh-Hans" to _uO("navigation" to "导航"), "zh-Hant" to _uO("navigation" to "導航"))
            val currentInstance = getCurrentInstance()!!.proxy!!
            val uniPage = currentInstance.`$page`
            val id1 = "UniMap1_" + (Math.random() * 10e5).toString(36) as String
            val readyEventName = ref("")
            val optionsEventName = ref("")
            val successEventName = ref("")
            val failEventName = ref("")
            val openLocationOptions = ref(OpenLocationOptions(latitude = 0, longitude = 0, scale = 18, name = "", address = ""))
            val safeArea = ref(AafeArea(top = 0, bottom = 0, left = 0, right = 0))
            val icon = ref(IconPath(target = "\ue683", position = "\ue653", navigation = "\ue640", back = "\ue651"))
            val language = ref("zh-Hans")
            val isLandscape = ref(false)
            val theme = ref("light")
            val mapId = ref(id1)
            val latitude = ref(0)
            val longitude = ref(0)
            val markers = ref(_uA<Marker>())
            val languageCom = computed(fun(): UTSJSONObject {
                val textInfo = if (languageData[language.value] != null) {
                    languageData[language.value] as UTSJSONObject
                } else {
                    languageData["zh-Hans"] as UTSJSONObject
                }
                return textInfo
            }
            )
            val darkClassCom = computed(fun(): String {
                return if (theme.value == "dark") {
                    "uni-open-location-dark"
                } else {
                    "uni-open-location-light"
                }
            }
            )
            val landscapeClassCom = computed(fun(): String {
                return if (isLandscape.value) {
                    "uni-open-location-landscape"
                } else {
                    ""
                }
            }
            )
            val initPageOptions = fun(options: UTSJSONObject){
                readyEventName.value = options["readyEventName"]!! as String
                optionsEventName.value = options["optionsEventName"]!! as String
                successEventName.value = options["successEventName"]!! as String
                failEventName.value = options["failEventName"]!! as String
                uni__on(optionsEventName.value, fun(data: UTSJSONObject){
                    console.log("data: ", JSON.stringify(data))
                    if (data["latitude"] != null) {
                        openLocationOptions.value.latitude = data["latitude"] as Number
                        latitude.value = openLocationOptions.value.latitude
                    }
                    if (data["longitude"] != null) {
                        openLocationOptions.value.longitude = data["longitude"] as Number
                        longitude.value = openLocationOptions.value.longitude
                    }
                    if (data["scale"] != null) {
                        openLocationOptions.value.scale = data["scale"] as Number
                    }
                    if (data["name"] != null) {
                        openLocationOptions.value.name = data["name"] as String
                    }
                    if (data["address"] != null) {
                        openLocationOptions.value.address = data["address"] as String
                    }
                    setTimeout(fun(){
                        markers.value = _uA<Marker>(Marker(id = 1, latitude = openLocationOptions.value.latitude, longitude = openLocationOptions.value.longitude, iconPath = default__6, width = 50, height = 50))
                    }
                    , 300)
                    uni__emit(successEventName.value, _uO())
                }
                )
                uni__emit(readyEventName.value, _uO())
            }
            val getSystemInfo = fun(){
                val info = uni_getWindowInfo()
                safeArea.value.top = info.safeAreaInsets.top
                safeArea.value.bottom = info.safeAreaInsets.bottom
                safeArea.value.left = info.safeAreaInsets.left
                safeArea.value.right = info.safeAreaInsets.right
                val systemInfo = uni_getSystemInfoSync()
                val appLanguage = systemInfo.appLanguage
                language.value = appLanguage
                val osTheme = systemInfo.osTheme
                val appTheme = systemInfo.appTheme
                if (appTheme != null && appTheme != "auto") {
                    theme.value = appTheme
                } else if (osTheme != null) {
                    theme.value = osTheme
                }
                isLandscape.value = systemInfo.deviceOrientation == "landscape"
                uni_onAppThemeChange(fun(res: AppThemeChangeResult){
                    theme.value = res.appTheme
                }
                )
                uni_onOsThemeChange(fun(res: OsThemeChangeResult){
                    theme.value = res.osTheme
                }
                )
            }
            val closeDialogPage = fun(){
                uni_closeDialogPage(io.dcloud.uniapp.framework.extapi.CloseDialogPageOptions(dialogPage = uniPage))
            }
            val back = fun(){
                closeDialogPage()
            }
            val getMapContext = fun(): MapContext? {
                return uni_createMapContext(mapId.value, currentInstance)
            }
            val moveToLocation = fun(){
                val mapContext = getMapContext()
                if (mapContext != null) {
                    mapContext.moveToLocation(MapContextMoveToLocationOptions())
                }
            }
            val mapReset = fun(){
                moveToLocation()
            }
            val navigation = fun(){
                val appBaseInfo = uni_getAppBaseInfo(null)
                val src = appBaseInfo.packageName
                val list = _uA<String>("腾讯地图", "高德地图", "百度地图")
                uni_showActionSheet(ShowActionSheetOptions(itemList = list, success = fun(res){
                    var index = res.tapIndex
                    if (index >= 0) {
                        var item = list[index] as String
                        try {
                            var url = ""
                            if (item == "腾讯地图") {
                                url = "qqmap://map/routeplan?type=drive&from=我的位置&fromcoord=CurrentLocation&to=" + openLocationOptions.value.name + "&tocoord=" + openLocationOptions.value.latitude + "," + openLocationOptions.value.longitude + "&referer=1"
                            } else if (item == "高德地图") {
                                url = "androidamap://route/plan/?sourceApplication=" + src + "&slat=&slon=&sname=我的位置&dlat=" + openLocationOptions.value.latitude + "&dlon=" + openLocationOptions.value.longitude + "&dname=" + openLocationOptions.value.name + "&dev=0&t=0"
                            } else if (item == "百度地图") {
                                url = "baidumap://map/direction?origin=我的位置&destination=latlng:" + openLocationOptions.value.latitude + "," + openLocationOptions.value.longitude + "|name:" + openLocationOptions.value.name + "&coord_type=gcj02&mode=driving&src=" + src
                            } else if (item == "苹果地图") {} else if (item == "华为地图") {}
                            if (url != "") {
                                var schemaPrefix = ""
                                val schemaIndex = url.indexOf("?")
                                if (schemaIndex != -1) {
                                    schemaPrefix = url.substring(0, schemaIndex)
                                }
                                if (canOpenURL(schemaPrefix)) {
                                    openSchema(url)
                                } else {
                                    uni_showToast(ShowToastOptions(title = "请先安装" + item, icon = "none"))
                                }
                            }
                        }
                         catch (err: Throwable) {
                            console.error(err)
                        }
                    }
                }
                ))
            }
            onLoad(fun(options: UTSJSONObject){
                initPageOptions(options)
                getSystemInfo()
            }
            )
            onUnload(fun(){
                uni__off(optionsEventName.value, null)
                uni__off(readyEventName.value, null)
                uni__off(successEventName.value, null)
                uni__off(failEventName.value, null)
            }
            )
            onResize(fun(_options){
                val systemInfo = uni_getSystemInfoSync()
                isLandscape.value = systemInfo.deviceOrientation == "landscape"
            }
            )
            return fun(): Any? {
                val _component_map = resolveComponent("map")
                return _cE("view", _uM("class" to "uni-open-location"), _uA(
                    _cE("view", _uM("class" to "uni-open-location-map-box"), _uA(
                        _cV(_component_map, _uM("class" to "uni-open-location-map", "id" to unref(mapId), "ref" to unref(mapId), "latitude" to unref(latitude), "longitude" to unref(longitude), "scale" to unref(openLocationOptions).scale, "markers" to unref(markers), "layer-style" to if (unref(theme) == "dark") {
                            "2"
                        } else {
                            "1"
                        }
                        , "show-compass" to false, "enable-zoom" to true, "enable-scroll" to true, "enable-rotate" to false, "enable-poi" to true, "show-location" to true), null, 8, _uA(
                            "id",
                            "latitude",
                            "longitude",
                            "scale",
                            "markers",
                            "layer-style"
                        )),
                        _cE("view", _uM("class" to _nC(_uA(
                            "uni-open-location-map-reset",
                            _uA(
                                unref(darkClassCom)
                            )
                        )), "onClick" to mapReset), _uA(
                            _cE("text", _uM("class" to _nC(_uA(
                                "uni-open-location-icons uni-open-location-map-reset-icon",
                                _uA(
                                    unref(darkClassCom)
                                )
                            ))), _tD(unref(icon).position), 3)
                        ), 2)
                    )),
                    _cE("view", _uM("class" to "uni-open-location-nav", "style" to _nS("height:" + (60 + unref(safeArea).top) + "px;")), _uA(
                        _cE("view", _uM("class" to _nC(_uA(
                            "uni-open-location-nav-btn uni-open-location-nav-back-btn",
                            _uA(
                                unref(landscapeClassCom)
                            )
                        )), "style" to _nS(if (unref(safeArea).top > 0) {
                            "top: " + unref(safeArea).top + "px;"
                        } else {
                            ""
                        }
                        )), _uA(
                            _cE("view", _uM("class" to "uni-open-location-nav-btn-bg")),
                            _cE("text", _uM("class" to "uni-open-location-nav-text uni-open-location-nav-back-text uni-open-location-icons", "onClick" to back), _tD(unref(icon).back), 1)
                        ), 6)
                    ), 4),
                    _cE("view", _uM("class" to _nC(_uA(
                        "uni-open-location-footer",
                        _uA(
                            unref(darkClassCom)
                        )
                    ))), _uA(
                        _cE("view", _uM("class" to "uni-open-location-address"), _uA(
                            _cE("text", _uM("class" to _nC(_uA(
                                "uni-open-location-name-text",
                                _uA(
                                    unref(darkClassCom)
                                )
                            ))), _tD(unref(openLocationOptions).name), 3),
                            _cE("text", _uM("class" to _nC(_uA(
                                "uni-open-location-address-text",
                                _uA(
                                    unref(darkClassCom)
                                )
                            ))), _tD(unref(openLocationOptions).address), 3)
                        )),
                        _cE("view", _uM("class" to "uni-open-location-footer-icon-btns"), _uA(
                            _cE("view", _uM("class" to "uni-open-location-footer-icon-btns-item", "onClick" to navigation), _uA(
                                _cE("view", _uM("class" to _nC(_uA(
                                    "uni-open-location-footer-icon-box",
                                    _uA(
                                        unref(darkClassCom)
                                    )
                                ))), _uA(
                                    _cE("text", _uM("class" to "uni-open-location-icons uni-open-location-navigation"), _tD(unref(icon).navigation), 1)
                                ), 2),
                                _cE("text", _uM("class" to _nC(_uA(
                                    "uni-open-location-footer-btn-text",
                                    _uA(
                                        unref(darkClassCom)
                                    )
                                ))), _tD(unref(languageCom)["navigation"]), 3)
                            ))
                        ))
                    ), 2)
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
                return _uM("uni-open-location-icons" to _pS(_uM("fontFamily" to "UniOpenLocationFontFamily", "fontSize" to 16, "fontStyle" to "normal")), "uni-open-location" to _pS(_uM("position" to "relative", "left" to 0, "top" to 0, "width" to "100%", "height" to "100%", "backgroundImage" to "none", "backgroundColor" to "#f8f8f8", "zIndex" to 999, "display" to "flex", "flexDirection" to "column")), "uni-open-location-map-box" to _pS(_uM("width" to "100%", "flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "uni-open-location-map" to _pS(_uM("width" to "100%", "height" to "100%")), "uni-open-location-map-reset" to _pS(_uM("position" to "absolute", "left" to 20, "bottom" to 40, "width" to 40, "height" to 40, "boxSizing" to "border-box", "backgroundColor" to "#ffffff", "borderTopLeftRadius" to 20, "borderTopRightRadius" to 20, "borderBottomRightRadius" to 20, "borderBottomLeftRadius" to 20, "pointerEvents" to "auto", "boxShadow" to "0px 0px 20px 2px rgba(0, 0, 0, .3)", "zIndex" to 9, "display" to "flex", "justifyContent" to "center", "alignItems" to "center")), "uni-open-location-map-reset-icon" to _pS(_uM("fontSize" to 26, "textAlign" to "center", "lineHeight" to "40px")), "uni-open-location-nav" to _pS(_uM("position" to "absolute", "top" to 0, "left" to 0, "width" to "100%", "height" to 60, "backgroundColor" to "rgba(0,0,0,0)", "backgroundImage" to "linear-gradient(to bottom, rgba(0, 0, 0, .3), rgba(0, 0, 0, 0))")), "uni-open-location-nav-btn" to _pS(_uM("position" to "absolute", "top" to 5, "left" to 5, "width" to 44, "height" to 44, "display" to "flex", "justifyContent" to "center", "alignItems" to "center")), "uni-open-location-nav-btn-bg" to _pS(_uM("width" to 20, "height" to 20, "backgroundColor" to "#cbcbcb", "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "borderBottomRightRadius" to 10, "borderBottomLeftRadius" to 10, "overflow" to "hidden", "position" to "absolute")), "uni-open-location-nav-back-text" to _pS(_uM("color" to "#ffffff", "fontSize" to 26)), "uni-open-location-footer" to _pS(_uM("height" to 150, "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "borderBottomRightRadius" to 0, "borderBottomLeftRadius" to 0, "overflow" to "hidden", "backgroundColor" to "#ffffff", "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "space-between", "paddingTop" to 0, "paddingRight" to 20, "paddingBottom" to 0, "paddingLeft" to 20)), "uni-open-location-address" to _pS(_uM("display" to "flex", "flexDirection" to "column", "flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "uni-open-location-name-text" to _pS(_uM("fontSize" to 18, "fontWeight" to "bold", "overflow" to "hidden", "textOverflow" to "ellipsis", "whiteSpace" to "nowrap")), "uni-open-location-address-text" to _pS(_uM("fontSize" to 16, "marginTop" to 10, "overflow" to "hidden", "textOverflow" to "ellipsis", "whiteSpace" to "nowrap")), "uni-open-location-footer-icon-btns" to _pS(_uM("width" to 100, "display" to "flex", "flexDirection" to "row", "justifyContent" to "flex-end")), "uni-open-location-footer-icon-btns-item" to _pS(_uM("display" to "flex", "flexDirection" to "column", "alignItems" to "center", "opacity:active" to 0.6)), "uni-open-location-footer-icon-box" to _pS(_uM("backgroundColor" to "#f8f8f8", "width" to 40, "height" to 40, "borderTopLeftRadius" to 6, "borderTopRightRadius" to 6, "borderBottomRightRadius" to 6, "borderBottomLeftRadius" to 6, "display" to "flex", "justifyContent" to "center", "alignItems" to "center", "marginBottom" to 6)), "uni-open-location-navigation" to _uM(".uni-open-location-icons" to _uM("color" to "#007aff", "fontSize" to 24)), "uni-open-location-footer-btn-text" to _pS(_uM("fontSize" to 12, "textAlign" to "center")), "uni-open-location-dark" to _uM(".uni-open-location-map-reset" to _uM("backgroundColor" to "#111111"), ".uni-open-location-map-reset-icon" to _uM("color" to "#d1d1d1"), ".uni-open-location-footer" to _uM("backgroundColor" to "#181818"), ".uni-open-location-name-text" to _uM("color" to "#fafafa"), ".uni-open-location-address-text" to _uM("color" to "#fafafa"), ".uni-open-location-footer-icon-box" to _uM("backgroundColor" to "#393939"), ".uni-open-location-footer-btn-text" to _uM("color" to "#909090")), "@FONT-FACE" to _uM("0" to _uM("fontFamily" to "UniOpenLocationFontFamily", "src" to "url('data:font/ttf;charset=utf-8;base64,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') format('truetype')")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
