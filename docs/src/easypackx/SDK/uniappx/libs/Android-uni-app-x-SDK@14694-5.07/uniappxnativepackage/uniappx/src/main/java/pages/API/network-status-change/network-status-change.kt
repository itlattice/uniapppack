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
import io.dcloud.uniapp.extapi.offNetworkStatusChange as uni_offNetworkStatusChange
import io.dcloud.uniapp.extapi.onNetworkStatusChange as uni_onNetworkStatusChange
open class GenPagesAPINetworkStatusChangeNetworkStatusChange : BasePage {
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
        var setup: (__props: GenPagesAPINetworkStatusChangeNetworkStatusChange) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPINetworkStatusChangeNetworkStatusChange
            val _cache = __ins.renderCache
            val isConnected = ref(false)
            val networkType = ref("unknown")
            val listenStatus = ref("未监听")
            val networkCallback = ref<((result: OnNetworkStatusChangeCallbackResult) -> Unit)?>(null)
            val getCurrentNetworkStatus = fun(){
                uni_getNetworkType(GetNetworkTypeOptions(success = fun(res){
                    networkType.value = res.networkType
                    isConnected.value = res.networkType != "none"
                }
                , fail = fun(_){
                    console.log("获取网络状态失败")
                    networkType.value = "unknown"
                    isConnected.value = false
                }
                ))
            }
            val startListen = fun(){
                if (networkCallback.value != null) {
                    listenStatus.value = "正在监听"
                    return
                }
                networkCallback.value = fun(result: OnNetworkStatusChangeCallbackResult){
                    console.log("网络状态: ", result)
                    isConnected.value = result.isConnected
                    networkType.value = result.networkType
                    if (!result.isConnected) {
                        networkType.value = "none"
                    }
                }
                uni_onNetworkStatusChange(networkCallback.value!!)
                listenStatus.value = "正在监听"
            }
            val stopListen = fun(){
                if (networkCallback.value == null) {
                    listenStatus.value = "未监听"
                    return
                }
                uni_offNetworkStatusChange(networkCallback.value!!)
                networkCallback.value = null
                listenStatus.value = "停止监听"
            }
            onLoad(fun(_options){
                getCurrentNetworkStatus()
            }
            )
            onUnload(fun(){
                stopListen()
            }
            )
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE(Fragment, null, _uA(
                    _cV(_component_page_head, _uM("title" to "networkStatusChange")),
                    _cE("view", _uM("class" to "uni-list-cell-padding status-box"), _uA(
                        _cE("text", _uM("class" to "uni-title-text"), "网络状态"),
                        _cE("view", _uM("class" to "uni-row uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-hello-text"), "是否连接："),
                            _cE("text", null, _tD(if (unref(isConnected)) {
                                "已连接"
                            } else {
                                "未连接"
                            }
                            ), 1)
                        )),
                        _cE("view", _uM("class" to "uni-row uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-hello-text"), "网络类型："),
                            _cE("text", null, _tD(unref(networkType)), 1)
                        )),
                        _cE("view", _uM("class" to "uni-row uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-hello-text"), "监听状态："),
                            _cE("text", null, _tD(unref(listenStatus)), 1)
                        ))
                    )),
                    _cE("view", _uM("class" to "uni-list-cell-padding uni-common-mt"), _uA(
                        _cE("button", _uM("type" to "primary", "onClick" to startListen), "开始监听"),
                        _cE("button", _uM("type" to "default", "class" to "uni-common-mt", "onClick" to stopListen), "停止监听")
                    ))
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
                return _uM("status-box" to _pS(_uM("backgroundColor" to "#FFFFFF", "marginTop" to 0, "marginRight" to 20, "marginBottom" to 0, "marginLeft" to 20)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
