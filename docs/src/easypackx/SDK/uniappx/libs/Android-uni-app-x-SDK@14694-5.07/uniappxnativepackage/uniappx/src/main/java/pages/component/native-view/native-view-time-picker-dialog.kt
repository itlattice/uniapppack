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
import io.dcloud.uniapp.extapi.closeDialogPage as uni_closeDialogPage
open class GenPagesComponentNativeViewNativeViewTimePickerDialog : BasePage {
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
        var setup: (__props: GenPagesComponentNativeViewNativeViewTimePickerDialog) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentNativeViewNativeViewTimePickerDialog
            val _cache = __ins.renderCache
            val currentPage = getCurrentInstance()?.proxy?.`$page`
            fun gen_onChanged_fn(e: UniNativeViewEvent) {
                console.log("onchanged-----", e.detail)
            }
            val onChanged = ::gen_onChanged_fn
            fun gen_sure_fn() {
                if (currentPage != null) {
                    uni_closeDialogPage(CloseDialogPageOptions(dialogPage = currentPage))
                }
            }
            val sure = ::gen_sure_fn
            return fun(): Any? {
                val _component_native_time_picker = resolveEasyComponent("native-time-picker", GenUniModulesNativeTimePickerComponentsNativeTimePickerNativeTimePickerClass)
                return _cE("view", _uM("class" to "dialog-container"), _uA(
                    _cV(_component_native_time_picker, _uM("class" to "native-time-picker", "hour" to 2, "minute" to 3, "onChanged" to onChanged)),
                    _cE("button", _uM("onClick" to sure), "确定")
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
                return _uM("native-time-picker" to _pS(_uM("marginTop" to 10, "marginRight" to "auto", "marginBottom" to 25, "marginLeft" to "auto", "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopLeftRadius" to 5, "borderTopRightRadius" to 5, "borderBottomRightRadius" to 5, "borderBottomLeftRadius" to 5, "backgroundColor" to "#FFFFFF")), "dialog-container" to _pS(_uM("width" to "100%", "height" to "100%", "backgroundColor" to "rgba(0,0,0,0.3)", "display" to "flex", "justifyContent" to "center", "alignItems" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
