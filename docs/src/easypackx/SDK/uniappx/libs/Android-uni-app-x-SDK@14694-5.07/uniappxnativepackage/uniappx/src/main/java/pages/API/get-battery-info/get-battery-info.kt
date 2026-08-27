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
import uts.sdk.modules.uniGetbatteryinfo.GetBatteryInfoOptions as GetBatteryInfoOptions
import uts.sdk.modules.uniGetbatteryinfo.getBatteryInfo as uni_getBatteryInfo
import io.dcloud.uniapp.extapi.showModal as uni_showModal
open class GenPagesAPIGetBatteryInfoGetBatteryInfo : BasePage {
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
    open var data: DataType__92
        get() {
            return unref(this.`$exposed`["data"]) as DataType__92
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIGetBatteryInfoGetBatteryInfo, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIGetBatteryInfoGetBatteryInfo
            val _cache = __ins.renderCache
            val data = reactive(DataType__92(level = 0, isCharging = false))
            onLoad(fun(_options){
                try {
                    uni_getBatteryInfo(GetBatteryInfoOptions(success = fun(res){
                        data.level = res.level
                        data.isCharging = res.isCharging
                    }
                    ))
                }
                 catch (e: Throwable) {
                    console.error((e as UTSError).message)
                    uni_showModal(ShowModalOptions(content = (e as UTSError).message, showCancel = false))
                }
            }
            )
            __expose(_uM("data" to data))
            return fun(): Any? {
                return _cE("view", null, _uA(
                    _cE("text", null, "当前电量：" + _tD(unref(data).level) + "%", 1),
                    _cE("text", null, "是否充电中：" + _tD(unref(data).isCharging), 1)
                ))
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
