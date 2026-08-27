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
import io.dcloud.uniapp.extapi.makePhoneCall as uni_makePhoneCall
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesAPIMakePhoneCallMakePhoneCall : BasePage {
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
        var setup: (__props: GenPagesAPIMakePhoneCallMakePhoneCall) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIMakePhoneCallMakePhoneCall
            val _cache = __ins.renderCache
            val title = ref("makePhoneCall")
            val data = reactive(DataType__98(disabled = true, inputValue = ""))
            val bindInput = fun(e: UniInputEvent){
                data.inputValue = e.detail.value
                if (data.inputValue.length > 0) {
                    data.disabled = false
                } else {
                    data.disabled = true
                }
            }
            val makePhoneCall = fun(){
                uni_makePhoneCall(MakePhoneCallOptions(phoneNumber = data.inputValue, success = fun(_){
                    console.log("成功拨打电话")
                }
                , fail = fun(err){
                    console.log(err.errCode)
                    uni_showToast(ShowToastOptions(title = "错误码：" + err.errCode.toString(), icon = "error"))
                }
                ))
            }
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE("view", null, _uA(
                    _cV(_component_page_head, _uM("title" to unref(title)), null, 8, _uA(
                        "title"
                    )),
                    _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt"), _uA(
                        _cE("view", _uM("class" to "uni-hello-text uni-center"), "请在下方输入电话号码"),
                        _cE("input", _uM("class" to "input uni-common-mt", "type" to "number", "name" to "input", "onInput" to bindInput), null, 32),
                        _cE("view", _uM("class" to "uni-btn-v uni-common-mt"), _uA(
                            _cE("button", _uM("onClick" to makePhoneCall, "type" to "primary", "disabled" to unref(data).disabled), "拨打", 8, _uA(
                                "disabled"
                            ))
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
                return _uM("input" to _pS(_uM("height" to 60, "lineHeight" to "60px", "fontSize" to 39, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#E2E2E2", "textAlign" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
