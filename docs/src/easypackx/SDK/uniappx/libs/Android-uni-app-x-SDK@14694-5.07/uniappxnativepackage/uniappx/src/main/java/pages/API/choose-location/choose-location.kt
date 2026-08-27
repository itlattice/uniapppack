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
import io.dcloud.uniapp.extapi.chooseLocation as uni_chooseLocation
open class GenPagesAPIChooseLocationChooseLocation : BasePage {
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
    open var data: DataType__69
        get() {
            return unref(this.`$exposed`["data"]) as DataType__69
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var setLifeCycleNumFunc: (value: Number) -> Unit
        get() {
            return unref(this.`$exposed`["setLifeCycleNumFunc"]) as (value: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setLifeCycleNumFunc", value)
        }
    open var getLifeCycleNum: () -> Number
        get() {
            return unref(this.`$exposed`["getLifeCycleNum"]) as () -> Number
        }
        set(value) {
            setRefValue(this.`$exposed`, "getLifeCycleNum", value)
        }
    open var chooseLocation: () -> Unit
        get() {
            return unref(this.`$exposed`["chooseLocation"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "chooseLocation", value)
        }
    open var clear: () -> Unit
        get() {
            return unref(this.`$exposed`["clear"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "clear", value)
        }
    open var changeLocationBoolean: (checked: Boolean) -> Unit
        get() {
            return unref(this.`$exposed`["changeLocationBoolean"]) as (checked: Boolean) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "changeLocationBoolean", value)
        }
    open var changeKeywordBoolean: (checked: Boolean) -> Unit
        get() {
            return unref(this.`$exposed`["changeKeywordBoolean"]) as (checked: Boolean) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "changeKeywordBoolean", value)
        }
    open var changePayloadBoolean: (checked: Boolean) -> Unit
        get() {
            return unref(this.`$exposed`["changePayloadBoolean"]) as (checked: Boolean) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "changePayloadBoolean", value)
        }
    open var test: () -> Unit
        get() {
            return unref(this.`$exposed`["test"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "test", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIChooseLocationChooseLocation, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIChooseLocationChooseLocation
            val _cache = __ins.renderCache
            val data = reactive(DataType__69(title = "chooseLocation", hasLocation = false, location = Location(latitude = _uA(), longitude = _uA()), locationName = "", locationAddress = "", dialogPagesNum = -1, hoverLocation = false, hoverKeyword = false, hoverPayload = false))
            val formatLocation = fun(longitude: Number, latitude: Number): Location {
                val longitudeArr = longitude.toString(10).split(".")
                val latitudeArr = latitude.toString(10).split(".")
                if (longitudeArr.length > 1) {
                    longitudeArr[1] = longitudeArr[1].substring(0, 2)
                }
                if (latitudeArr.length > 1) {
                    latitudeArr[1] = latitudeArr[1].substring(0, 2)
                }
                return Location(longitude = longitudeArr, latitude = latitudeArr)
            }
            val clear = fun(){
                data.hasLocation = false
            }
            val changeLocationBoolean = fun(checked: Boolean){
                data.hoverLocation = checked
            }
            val changeKeywordBoolean = fun(checked: Boolean){
                data.hoverKeyword = checked
            }
            val changePayloadBoolean = fun(checked: Boolean){
                data.hoverPayload = checked
            }
            val test = fun(){
                val pages = getCurrentPages()
                val page = pages[pages.length - 1]
                val dialogPages = page.getDialogPages()
                data.dialogPagesNum = dialogPages.length
            }
            val setLifeCycleNumFunc = fun(value: Number){
                setLifeCycleNum(value)
            }
            val getLifeCycleNum = fun(): Number {
                return state.lifeCycleNum
            }
            val chooseLocation = fun(){
                var chooseLocationOptions = ChooseLocationOptions(success = fun(res){
                    console.log("chooseLocation success", res)
                    data.hasLocation = true
                    data.location = formatLocation(res.longitude, res.latitude)
                    data.locationName = res.name
                    data.locationAddress = res.address
                }
                )
                if (data.hoverLocation) {
                    chooseLocationOptions.latitude = 39.908823
                    chooseLocationOptions.longitude = 116.39747
                }
                if (data.hoverKeyword) {
                    chooseLocationOptions.keyword = "公园"
                }
                if (data.hoverPayload) {
                    chooseLocationOptions.payload = _uO("token" to "xxx")
                }
                uni_chooseLocation(chooseLocationOptions)
                setTimeout(fun(){
                    test()
                }
                , 500)
            }
            onPageShow(fun(){
                console.log("Page Show")
                setLifeCycleNumFunc(state.lifeCycleNum + 1)
            }
            )
            onPageHide(fun(){
                console.log("Page Hide")
                setLifeCycleNumFunc(state.lifeCycleNum - 1)
            }
            )
            __expose(_uM("data" to data, "setLifeCycleNumFunc" to setLifeCycleNumFunc, "getLifeCycleNum" to getLifeCycleNum, "chooseLocation" to chooseLocation, "clear" to clear, "changeLocationBoolean" to changeLocationBoolean, "changeKeywordBoolean" to changeKeywordBoolean, "changePayloadBoolean" to changePayloadBoolean, "test" to test))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                val _component_boolean_data = resolveEasyComponent("boolean-data", GenComponentsBooleanDataBooleanDataClass)
                return _cE("view", null, _uA(
                    _cV(_component_page_head, _uM("title" to unref(data).title), null, 8, _uA(
                        "title"
                    )),
                    _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                        _cE("view", _uM("class" to "uni-column uni-container align-center"), _uA(
                            _cE("text", _uM("class" to "uni-hello-text"), "位置信息"),
                            if (isTrue(!unref(data).hasLocation)) {
                                _cE("text", _uM("key" to 0, "class" to "uni-title-text uni-common-mt"), "未选择位置")
                            } else {
                                _cC("v-if", true)
                            }
                            ,
                            if (isTrue(unref(data).hasLocation)) {
                                _cE("view", _uM("key" to 1, "class" to "align-center"), _uA(
                                    _cE("text", _uM("class" to "uni-common-mt"), _tD(unref(data).locationName), 1),
                                    _cE("text", _uM("class" to "uni-common-mt"), _tD(unref(data).locationAddress), 1),
                                    if (unref(data).location.latitude.length > 1) {
                                        _cE("view", _uM("key" to 0, "class" to "uni-common-mt"), _uA(
                                            _cE("text", null, "E: " + _tD(unref(data).location.longitude[0]) + "°" + _tD(unref(data).location.longitude[1]) + "′", 1),
                                            _cE("text", null, "\nN: " + _tD(unref(data).location.latitude[0]) + "°" + _tD(unref(data).location.latitude[1]) + "′", 1)
                                        ))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                        )),
                        _cE("view", _uM("class" to "uni-btn-v"), _uA(
                            _cE("text", _uM("class" to "tips"), "注意：\n1. Web和App需要正确配置地图服务商的Key并且保证Key的权限和余额足够，才能正常选择位置\n2. 若没有关联uniCloud空间，则只能全屏地图选点，不能根据POI选择位置\n3. payload参数会原样透传给uni-map-co，可用于用户鉴权"),
                            _cV(_component_boolean_data, _uM("defaultValue" to false, "title" to "是否指定位置为天安门", "onChange" to changeLocationBoolean)),
                            _cV(_component_boolean_data, _uM("defaultValue" to false, "title" to "是否携带keyword参数", "onChange" to changeKeywordBoolean)),
                            _cV(_component_boolean_data, _uM("defaultValue" to false, "title" to "是否携带payload参数", "onChange" to changePayloadBoolean)),
                            _cE("button", _uM("class" to "uni-btn", "type" to "primary", "onClick" to chooseLocation), "选择位置"),
                            _cE("button", _uM("class" to "uni-btn", "onClick" to clear), "清空")
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
                return _uM("page-body-info" to _pS(_uM("paddingBottom" to 0, "height" to 220)), "align-center" to _pS(_uM("alignItems" to "center")), "tips" to _pS(_uM("fontSize" to 12, "marginTop" to 15, "marginRight" to 0, "marginBottom" to 15, "marginLeft" to 0, "opacity" to 0.8)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
