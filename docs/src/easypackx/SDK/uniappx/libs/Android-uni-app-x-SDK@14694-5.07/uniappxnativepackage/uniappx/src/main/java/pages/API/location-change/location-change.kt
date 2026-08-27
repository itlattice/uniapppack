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
import io.dcloud.uniapp.extapi.getProviderSync as uni_getProviderSync
import io.dcloud.uniapp.extapi.offLocationChange as uni_offLocationChange
import io.dcloud.uniapp.extapi.offLocationChangeError as uni_offLocationChangeError
import io.dcloud.uniapp.extapi.onLocationChange as uni_onLocationChange
import io.dcloud.uniapp.extapi.onLocationChangeError as uni_onLocationChangeError
import io.dcloud.uniapp.extapi.showToast as uni_showToast
import io.dcloud.uniapp.extapi.startLocationUpdate as uni_startLocationUpdate
import io.dcloud.uniapp.extapi.startLocationUpdateBackground as uni_startLocationUpdateBackground
import io.dcloud.uniapp.extapi.stopLocationUpdate as uni_stopLocationUpdate
open class GenPagesAPILocationChangeLocationChange : BasePage {
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
    open var data: DataType__67
        get() {
            return unref(this.`$exposed`["data"]) as DataType__67
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var stopLocationUpdate: () -> Unit
        get() {
            return unref(this.`$exposed`["stopLocationUpdate"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "stopLocationUpdate", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPILocationChangeLocationChange, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPILocationChangeLocationChange
            val _cache = __ins.renderCache
            val data = reactive(DataType__67(log = "", logAble = true, providerList = _uA(), currentSelectedProvider = 0, currentSelectedType = 0, startSuccess = false, stopSuccess = false, errCode = 0))
            val types = ref(_uA<ItemType__7>(ItemType__7(value = "wgs84", name = "wgs84"), ItemType__7(value = "gcj02", name = "gcj02")))
            val getProvider = fun(){
                var provider = uni_getProviderSync(GetProviderSyncOptions(service = "location"))
                console.log(provider)
                provider.providerObjects.forEach(fun(value: UniProvider){
                    var currentProvider = value
                    data.providerList.push(LocationItem__1(name = currentProvider.description, id = currentProvider.id, provider = currentProvider))
                }
                )
                data.providerList.forEach(fun(value, index){
                    if (value.id == "system") {
                        data.currentSelectedProvider = index
                    }
                }
                )
            }
            val providerChange = fun(e: UniRadioGroupChangeEvent){
                run {
                    var i: Number = 0
                    while(i < data.providerList.length){
                        if (data.providerList[i].id === e.detail.value) {
                            data.currentSelectedProvider = i
                            break
                        }
                        i++
                    }
                }
                if (e.detail.value == "system") {
                    data.currentSelectedType = 0
                } else if (e.detail.value == "tencent") {
                    data.currentSelectedType = 1
                }
            }
            val typeChange = fun(e: UniRadioGroupChangeEvent){
                run {
                    var i: Number = 0
                    while(i < types.value.length){
                        if (types.value[i].value === e.detail.value) {
                            data.currentSelectedType = i
                            break
                        }
                        i++
                    }
                }
            }
            val offLocationChangeError = fun(){
                if (data.logAble) {
                    data.log += "关闭offLocationChangeError监听\n\n"
                }
                console.log("关闭onLocationChangeError监听")
                uni_offLocationChangeError(null)
            }
            val onLocationChangeError = fun(){
                uni_offLocationChangeError(null)
                if (data.logAble) {
                    data.log += "开启onLocationChangeError监听\n\n"
                }
                console.log("开启onLocationChangeError监听")
                uni_onLocationChangeError(fun(e){
                    console.log("onLocationChangeError回调: ", e)
                    if (data.logAble) {
                        data.log += JSON.stringify(e) + "\n\n"
                    }
                }
                )
            }
            val onLocationChange = fun(){
                uni_offLocationChange(null)
                console.log("开启onLocationChange监听")
                if (data.logAble) {
                    data.log += "开启onLocationChange监听\n\n"
                }
                uni_onLocationChange(fun(e){
                    console.log("onLocationChange持续监听回调: ", e)
                    if (data.logAble) {
                        data.log += "provider= " + data.providerList[data.currentSelectedProvider].id + "\n" + JSON.stringify(e) + "\n\n"
                    }
                }
                )
            }
            val offLocationChange = fun(){
                if (data.logAble) {
                    data.log += "关闭offLocationChange监听\n\n"
                }
                console.log("关闭offLocationChange监听")
                uni_offLocationChange(null)
            }
            val startLocationUpdate = fun(){
                if (data.providerList.length == 0) {
                    uni_showToast(ShowToastOptions(title = "未获取到provider，请确定基座中包含location功能", icon = "error"))
                    console.log("未获取到provider，请确定基座中包含location功能")
                    return
                }
                val currentProvider = data.providerList[data.currentSelectedProvider]
                uni_startLocationUpdate(StartLocationUpdateOptions(provider = currentProvider.id, type = types.value[data.currentSelectedType].value, success = fun(_){
                    if (data.logAble) {
                        data.log += "开启startLocationUpdate成功, provider= " + currentProvider.id + "\n\n"
                    }
                    console.log("持续定位启动成功")
                    data.startSuccess = true
                }
                , fail = fun(err){
                    if (data.logAble) {
                        data.log += "启动startLocationUpdate失败：erroCode=" + err.errCode + "\n\n"
                    }
                    console.log("持续定位启动失败")
                    data.startSuccess = false
                    data.errCode = err.errCode
                }
                ))
            }
            val startLocationUpdateBackground = fun(){
                if (data.providerList.length == 0) {
                    uni_showToast(ShowToastOptions(title = "未获取到provider，请确定基座中包含location功能", icon = "error"))
                    console.log("未获取到provider，请确定基座中包含location功能")
                    return
                }
                val currentProvider = data.providerList[data.currentSelectedProvider]
                uni_startLocationUpdateBackground(StartLocationUpdateBackgroundOptions(provider = currentProvider.id, type = types.value[data.currentSelectedType].value, success = fun(_){
                    if (data.logAble) {
                        data.log += "开启startLocationUpdateBackground成功, provider= " + currentProvider.id + "\n\n"
                    }
                    console.log("后台持续定位api启动成功")
                    data.startSuccess = true
                }
                , fail = fun(err){
                    if (data.logAble) {
                        data.log += "启动startLocationUpdateBackground失败：erroCode=" + err.errCode + "\n\n"
                    }
                    console.log("后台持续定位启动失败")
                    data.startSuccess = false
                    data.errCode = err.errCode
                }
                ))
            }
            val stopLocationUpdate = fun(){
                uni_stopLocationUpdate(StopLocationUpdateOptions(success = fun(_){
                    if (data.logAble) {
                        data.log += "成功关闭stopLocationUpdate定位\n\n"
                    }
                    console.log("成功关闭stopLocationUpdate定位")
                    data.stopSuccess = true
                }
                ))
            }
            onLoad(fun(_options){
                getProvider()
            }
            )
            onUnload(fun(){
                uni_stopLocationUpdate(StopLocationUpdateOptions())
                uni_offLocationChange(null)
                uni_offLocationChangeError(null)
            }
            )
            __expose(_uM("data" to data, "stopLocationUpdate" to stopLocationUpdate))
            return fun(): Any? {
                val _component_radio = resolveComponent("radio")
                val _component_radio_group = resolveComponent("radio-group")
                return _cE(Fragment, null, _uA(
                    _cE("text", null, "显示简易操作日志(可滚动查看)"),
                    _cE("button", _uM("size" to "mini", "onClick" to fun(){
                        unref(data).log = ""
                    }
                    ), "清空日志", 8, _uA(
                        "onClick"
                    )),
                    _cE("scroll-view", _uM("style" to _nS(_uM("max-height" to "300px"))), _uA(
                        _cE("text", _uM("style" to _nS(_uM("margin" to "2px", "padding" to "2px", "border" to "1px solid #000000"))), _tD(unref(data).log), 5)
                    ), 4),
                    _cE("view", _uM("class" to "uni-list"), _uA(
                        _cE("text", _uM("style" to _nS(_uM("margin-bottom" to "4px"))), " 请选择定位服务提供商：", 4),
                        _cV(_component_radio_group, _uM("class" to "uni-flex uni-row", "onChange" to providerChange, "style" to _nS(_uM("flex-wrap" to "wrap"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(unref(data).providerList, fun(item, index, __index, _cached): Any {
                                    return _cV(_component_radio, _uM("class" to "uni-list-cell", "style" to _nS(_uM("margin-right" to "15px")), "key" to item.id, "value" to item.id, "checked" to (index === unref(data).currentSelectedProvider)), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(item.name)
                                        )
                                    }
                                    ), "_" to 2), 1032, _uA(
                                        "style",
                                        "value",
                                        "checked"
                                    ))
                                }
                                ), 128)
                            )
                        }
                        ), "_" to 1), 8, _uA(
                            "style"
                        ))
                    )),
                    _cE("view", _uM("class" to "uni-list"), _uA(
                        _cE("text", _uM("style" to _nS(_uM("margin-bottom" to "4px"))), " 请选择坐标系：", 4),
                        _cV(_component_radio_group, _uM("class" to "uni-flex uni-row", "onChange" to typeChange, "style" to _nS(_uM("flex-wrap" to "wrap"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(unref(types), fun(item, index, __index, _cached): Any {
                                    return _cV(_component_radio, _uM("class" to "uni-list-cell", "style" to _nS(_uM("margin-right" to "15px")), "key" to item.value, "value" to item.value, "checked" to (index === unref(data).currentSelectedType)), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(item.name)
                                        )
                                    }
                                    ), "_" to 2), 1032, _uA(
                                        "style",
                                        "value",
                                        "checked"
                                    ))
                                }
                                ), 128)
                            )
                        }
                        ), "_" to 1), 8, _uA(
                            "style"
                        ))
                    )),
                    _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to startLocationUpdate, "id" to "startLocationUpdate"), "点击连续定位"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to startLocationUpdateBackground, "id" to "startLocationUpdateBackground"), "后台点击连续定位"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to stopLocationUpdate, "id" to "stopLocationUpdate"), "点击关闭定位"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to onLocationChange, "id" to "onLocationChange"), "onLocationChange"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to offLocationChange, "id" to "offLocationChange"), "offLocationChange"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to onLocationChangeError, "id" to "onLocationChangeError"), "onLocationChangeError"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to offLocationChangeError, "id" to "offLocationChangeError"), "offLocationChangeError")
                    ), 4)
                ), 64)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("uni-list" to _pS(_uM("borderBottomWidth" to 0, "borderBottomStyle" to "none", "borderBottomColor" to "#000000", "backgroundColor" to "rgba(0,0,0,0)", "marginLeft" to 10, "marginRight" to 10, "marginTop" to 4, "marginBottom" to 4)), "uni-list-cell" to _pS(_uM("position" to "relative", "display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center")), "btnstyle" to _pS(_uM("marginTop" to 4, "marginRight" to 4, "marginBottom" to 4, "marginLeft" to 4)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
