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
import io.dcloud.uniapp.extapi.getNetworkType as uni_getNetworkType
import io.dcloud.uniapp.extapi.showModal as uni_showModal
open class GenPagesAPIGetNetworkTypeGetNetworkType : BasePage {
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
    open var data: DataType__89
        get() {
            return unref(this.`$exposed`["data"]) as DataType__89
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var jest_getNetworkType: () -> Unit
        get() {
            return unref(this.`$exposed`["jest_getNetworkType"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_getNetworkType", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIGetNetworkTypeGetNetworkType, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIGetNetworkTypeGetNetworkType
            val _cache = __ins.renderCache
            val data = reactive(DataType__89(title = "getNetworkType", hasNetworkType = false, networkType = "", connectedWifi = "", jest_result = false))
            onUnload(fun(){
                data.networkType = ""
                data.hasNetworkType = false
            }
            )
            val getNetworkType = fun(){
                uni_getNetworkType(GetNetworkTypeOptions(success = fun(res){
                    console.log(res)
                    data.hasNetworkType = true
                    data.networkType = res.networkType
                }
                , fail = fun(_){
                    uni_showModal(ShowModalOptions(content = "获取失败！", showCancel = false))
                }
                ))
            }
            val clear = fun(){
                data.hasNetworkType = false
                data.networkType = ""
                data.connectedWifi = ""
            }
            val jest_getNetworkType = fun(){
                uni_getNetworkType(GetNetworkTypeOptions(success = fun(_){
                    data.jest_result = true
                }
                , fail = fun(_){
                    data.jest_result = false
                }
                ))
            }
            __expose(_uM("data" to data, "jest_getNetworkType" to jest_getNetworkType))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE(Fragment, null, _uA(
                    _cV(_component_page_head, _uM("title" to unref(data).title), null, 8, _uA(
                        "title"
                    )),
                    _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt"), _uA(
                        _cE("view", _uM("class" to "uni-container"), _uA(
                            _cE("view", _uM("class" to "uni-center"), "网络状态"),
                            if (unref(data).hasNetworkType == false) {
                                _cE("view", _uM("key" to 0), _uA(
                                    _cE("view", _uM("class" to "uni-center uni-common-mt"), "未获取"),
                                    _cE("view", _uM("class" to "uni-center uni-common-mt"), "请点击下面按钮获取网络状态")
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                            ,
                            if (unref(data).hasNetworkType == true) {
                                _cE("view", _uM("key" to 1), _uA(
                                    _cE("view", _uM("class" to "uni-center uni-common-mt"), _tD(unref(data).networkType), 1)
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                        )),
                        _cE("view", _uM("class" to "uni-btn-v uni-common-mt"), _uA(
                            _cE("button", _uM("type" to "primary", "onClick" to getNetworkType), "获取设备网络状态"),
                            _cE("button", _uM("class" to "uni-common-mt", "onClick" to clear), "清空")
                        ))
                    ))
                ), 64)
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
