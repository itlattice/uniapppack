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
import uts.sdk.modules.uniUsercapturescreen.OnUserCaptureScreenCallbackResult
import uts.sdk.modules.uniUsercapturescreen.SetUserCaptureScreenSuccess
import uts.sdk.modules.uniUsercapturescreen.SetUserCaptureScreenOptions as SetUserCaptureScreenOptions
import uts.sdk.modules.uniUsercapturescreen.offUserCaptureScreen as uni_offUserCaptureScreen
import uts.sdk.modules.uniUsercapturescreen.onUserCaptureScreen as uni_onUserCaptureScreen
import uts.sdk.modules.uniUsercapturescreen.setUserCaptureScreen as uni_setUserCaptureScreen
open class GenPagesAPICaptureScreenCaptureScreen : BasePage {
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
        var setup: (__props: GenPagesAPICaptureScreenCaptureScreen) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPICaptureScreenCaptureScreen
            val _cache = __ins.renderCache
            val title = "截屏监听"
            val allowCapture = ref(state.allowCapture)
            val captureStatus = ref("未监听")
            var captureCallback: ((res: OnUserCaptureScreenCallbackResult) -> Unit)? = null
            val toggleCaptureScreen = fun(checked: Boolean){
                uni_setUserCaptureScreen(SetUserCaptureScreenOptions(enable = checked, success = fun(res: SetUserCaptureScreenSuccess){
                    allowCapture.value = checked
                    setAllowCapture(checked)
                    console.log("设置截屏状态成功：", res)
                }
                , fail = fun(err: IUniError){
                    console.log("设置截屏状态失败：", err)
                }
                ))
            }
            val startCaptureListener = fun(){
                captureCallback = fun(res: OnUserCaptureScreenCallbackResult){
                    captureStatus.value = "检测到截屏"
                    console.log("检测到用户截屏", res)
                }
                uni_onUserCaptureScreen(captureCallback)
                captureStatus.value = "正在监听"
                console.log("开始监听截屏")
            }
            val stopCaptureListener = fun(){
                if (captureCallback != null) {
                    uni_offUserCaptureScreen(captureCallback)
                    captureStatus.value = "未监听"
                    console.log("停止监听截屏")
                }
            }
            onUnmounted(fun(){
                stopCaptureListener()
            }
            )
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                val _component_switch = resolveComponent("switch")
                return _cE("view", _uM("class" to "uni-container"), _uA(
                    _cV(_component_page_head, _uM("title" to title)),
                    _cE("view", _uM("class" to "uni-common-mt"), _uA(
                        _cE("text", _uM("class" to "uni-title"), "截屏状态：" + _tD(unref(captureStatus)), 1),
                        _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row"))), _uA(
                            _cE("text", _uM("class" to "uni-title"), "是否允许截屏"),
                            _cV(_component_switch, _uM("checked" to unref(allowCapture), "onChange" to fun(e: UniSwitchChangeEvent){
                                return toggleCaptureScreen(e.detail.value)
                            }
                            ), null, 8, _uA(
                                "checked",
                                "onChange"
                            ))
                        ), 4),
                        _cE("view", _uM("class" to "uni-btn"), _uA(
                            _cE("button", _uM("onClick" to startCaptureListener, "type" to "primary", "class" to "uni-common-mt"), "开启截屏监听"),
                            _cE("button", _uM("onClick" to stopCaptureListener, "class" to "uni-common-mt"), "关闭截屏监听")
                        ))
                    ))
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
