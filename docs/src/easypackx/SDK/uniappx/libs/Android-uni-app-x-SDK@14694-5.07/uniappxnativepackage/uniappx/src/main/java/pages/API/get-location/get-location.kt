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
import io.dcloud.uniapp.extapi.getLocation as uni_getLocation
import io.dcloud.uniapp.extapi.getProviderSync as uni_getProviderSync
import io.dcloud.uniapp.extapi.hideLoading as uni_hideLoading
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesAPIGetLocationGetLocation : BasePage {
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
    open var jestData: JestData
        get() {
            return unref(this.`$exposed`["jestData"]) as JestData
        }
        set(value) {
            setRefValue(this.`$exposed`, "jestData", value)
        }
    open var jestGetLocation: () -> Unit
        get() {
            return unref(this.`$exposed`["jestGetLocation"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "jestGetLocation", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIGetLocationGetLocation, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIGetLocationGetLocation
            val _cache = __ins.renderCache
            val title = ref<String>("get-location")
            val altitudeSelect = ref<Boolean>(false)
            val isHighAccuracySelect = ref<Boolean>(false)
            val geocodeSelect = ref<Boolean>(false)
            val exeRet = ref<String>("")
            val items = ref(_uA<ItemType__6>(ItemType__6(value = "wgs84", name = "wgs84"), ItemType__6(value = "gcj02", name = "gcj02")))
            val providerList = ref(_uA<LocationItem>())
            val current = ref<Number>(0)
            val currentProvider = ref<Number>(0)
            val jestData = reactive<JestData>(JestData(jest_provider = "", jest_type = "wgs84" as GetLocationType, jest_isAltitude = false, jest_isGeocode = false, jest_isHighAccuracy = false, jest_altitude = -1000, jest_longitude = 200, jest_latitude = 100, jest_address = "", jest_errCode = 0, jest_complete = false))
            val getProvider = fun(){
                var provider = uni_getProviderSync(GetProviderSyncOptions(service = "location"))
                console.log(provider)
                provider.providerObjects.forEach(fun(value: UniProvider){
                    var currentProvider = value
                    providerList.value.push(LocationItem(name = currentProvider.description, id = currentProvider.id, provider = currentProvider))
                }
                )
                providerList.value.forEach(fun(value, index){
                    if (value.id == "system") {
                        currentProvider.value = index
                    }
                }
                )
            }
            val altitudeChange = fun(e: UniSwitchChangeEvent){
                altitudeSelect.value = e.detail.value
            }
            val geocodeChange = fun(e: UniSwitchChangeEvent){
                geocodeSelect.value = e.detail.value
            }
            val highAccuracySelectChange = fun(e: UniSwitchChangeEvent){
                isHighAccuracySelect.value = e.detail.value
            }
            val radioChange = fun(e: UniRadioGroupChangeEvent){
                run {
                    var i: Number = 0
                    while(i < items.value.length){
                        if (items.value[i].value === e.detail.value) {
                            current.value = i
                            break
                        }
                        i++
                    }
                }
            }
            val radioChangePV = fun(e: UniRadioGroupChangeEvent){
                run {
                    var i: Number = 0
                    while(i < providerList.value.length){
                        if (providerList.value[i].id === e.detail.value) {
                            currentProvider.value = i
                            break
                        }
                        i++
                    }
                }
                if (e.detail.value == "system") {
                    current.value = 0
                } else if (e.detail.value == "tencent") {
                    current.value = 1
                }
            }
            val getLocationTap = fun(){
                if (providerList.value.length == 0) {
                    uni_showToast(ShowToastOptions(title = "未获取到provider，请确定基座中包含location功能", icon = "error"))
                    console.log("未获取到provider，请确定基座中包含location功能")
                    return
                }
                uni_showLoading(ShowLoadingOptions(title = "定位中"))
                uni_getLocation((GetLocationOptions(provider = providerList.value[currentProvider.value].id, type = items.value[current.value].value, altitude = altitudeSelect.value, isHighAccuracy = isHighAccuracySelect.value, geocode = geocodeSelect.value, success = fun(res: Any){
                    uni_hideLoading(null)
                    exeRet.value = JSON.stringify(res)
                }
                , fail = fun(res: Any){
                    uni_hideLoading(null)
                    exeRet.value = JSON.stringify(res)
                }
                , complete = fun(res: Any){
                    uni_hideLoading(null)
                    exeRet.value = JSON.stringify(res)
                }
                )))
            }
            val jestGetLocation = fun(){
                jestData.jest_complete = false
                jestData.jest_errCode = 0
                uni_getLocation((GetLocationOptions(provider = jestData.jest_provider, type = jestData.jest_type, altitude = jestData.jest_isAltitude, isHighAccuracy = jestData.jest_isHighAccuracy, geocode = jestData.jest_isGeocode, success = fun(res){
                    if (res.address != null) {
                        jestData.jest_address = res.address!!
                    }
                    jestData.jest_longitude = res.longitude
                    jestData.jest_latitude = res.latitude
                    jestData.jest_altitude = res.altitude
                    jestData.jest_complete = true
                }
                , fail = fun(err){
                    jestData.jest_errCode = err.errCode
                    jestData.jest_complete = true
                }
                )))
            }
            onLoad(fun(_options){
                getProvider()
            }
            )
            __expose(_uM("jestData" to jestData, "jestGetLocation" to jestGetLocation))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                val _component_radio = resolveComponent("radio")
                val _component_radio_group = resolveComponent("radio-group")
                val _component_switch = resolveComponent("switch")
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cV(_component_page_head, _uM("title" to unref(title)), null, 8, _uA(
                        "title"
                    )),
                    _cE("view", _uM("style" to _nS(_uM("padding" to "4px"))), _uA(
                        _cE("text", _uM("class" to "hello-text"), " 定位功能默认调用操作系统定位API实现。也支持三方SDK定位\n 部分老款Android手机因gms问题可能导致无法使用系统定位。\n Web、Android、iOS平台，gcj国标、逆地理信息等功能需调用腾讯定位。")
                    ), 4),
                    _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt"), _uA(
                        _cE("view", _uM("class" to "uni-list-cell-db"), "定位服务商provider(如系统定位，腾讯定位等)"),
                        _cE("view", _uM("class" to "uni-list", "style" to _nS(_uM("margin-bottom" to "20px"))), _uA(
                            _cV(_component_radio_group, _uM("onChange" to radioChangePV), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(unref(providerList), fun(item, index, __index, _cached): Any {
                                        return _cV(_component_radio, _uM("class" to _nC(_uA(
                                            "uni-list-cell uni-list-cell-pd",
                                            if (index < unref(providerList).length - 1) {
                                                "uni-list-cell-line"
                                            } else {
                                                ""
                                            }
                                        )), "key" to item.id, "value" to item.id, "checked" to (index === unref(currentProvider))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(item.name)
                                            )
                                        }
                                        ), "_" to 2), 1032, _uA(
                                            "class",
                                            "value",
                                            "checked"
                                        ))
                                    }
                                    ), 128)
                                )
                            }
                            ), "_" to 1))
                        ), 4),
                        _cE("view", _uM("class" to "uni-list-cell-db"), "定位类型"),
                        _cE("view", _uM("class" to "uni-list"), _uA(
                            _cV(_component_radio_group, _uM("onChange" to radioChange), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(unref(items), fun(item, index, __index, _cached): Any {
                                        return _cV(_component_radio, _uM("class" to _nC(_uA(
                                            "uni-list-cell uni-list-cell-pd",
                                            if (index < unref(items).length - 1) {
                                                "uni-list-cell-line"
                                            } else {
                                                ""
                                            }
                                        )), "key" to item.value, "value" to item.value, "checked" to (index === unref(current))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(item.name)
                                            )
                                        }
                                        ), "_" to 2), 1032, _uA(
                                            "class",
                                            "value",
                                            "checked"
                                        ))
                                    }
                                    ), 128)
                                )
                            }
                            ), "_" to 1))
                        )),
                        _cE("view", _uM("class" to "uni-list-cell uni-list-cell-pd", "style" to _nS(_uM("margin-top" to "20px"))), _uA(
                            _cE("view", _uM("class" to "uni-list-cell-db"), "高度信息"),
                            _cV(_component_switch, _uM("checked" to unref(altitudeSelect), "onChange" to altitudeChange), null, 8, _uA(
                                "checked"
                            ))
                        ), 4),
                        _cE("view", _uM("class" to "uni-list-cell uni-list-cell-pd"), _uA(
                            _cE("view", _uM("class" to "uni-list-cell-db"), "开启高精度定位"),
                            _cV(_component_switch, _uM("checked" to unref(isHighAccuracySelect), "onChange" to highAccuracySelectChange), null, 8, _uA(
                                "checked"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-list-cell uni-list-cell-pd"), _uA(
                            _cE("view", _uM("class" to "uni-list-cell-db"), "是否解析地址信息"),
                            _cV(_component_switch, _uM("checked" to unref(geocodeSelect), "onChange" to geocodeChange), null, 8, _uA(
                                "checked"
                            ))
                        )),
                        _cE("view", _uM("class" to "get-location-result"), _tD(unref(exeRet)), 1),
                        _cE("view", _uM("class" to "uni-btn-v"), _uA(
                            _cE("button", _uM("class" to "uni-btn", "type" to "default", "onClick" to getLocationTap), " 获取定位 ")
                        ))
                    ))
                ), 4)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
