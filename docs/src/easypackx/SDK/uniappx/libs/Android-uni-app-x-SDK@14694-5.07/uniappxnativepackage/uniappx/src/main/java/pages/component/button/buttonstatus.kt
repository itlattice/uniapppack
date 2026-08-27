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
open class GenPagesComponentButtonButtonstatus : BasePage {
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
        var setup: (__props: GenPagesComponentButtonButtonstatus) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentButtonButtonstatus
            val _cache = __ins.renderCache
            val disabled_boolean = ref(false)
            fun gen_change_disabled_boolean_fn() {
                disabled_boolean.value = !disabled_boolean.value
            }
            val change_disabled_boolean = ::gen_change_disabled_boolean_fn
            return fun(): Any? {
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1", "padding" to "8px"))), _uA(
                    _cE("button", _uM("class" to "margin-10 btn", "disabled" to unref(disabled_boolean)), " type-default ", 8, _uA(
                        "disabled"
                    )),
                    _cE("button", _uM("class" to "margin-10 btn", "disabled" to unref(disabled_boolean), "type" to "primary"), " type-primary ", 8, _uA(
                        "disabled"
                    )),
                    _cE("button", _uM("class" to "margin-10 btn", "disabled" to unref(disabled_boolean), "type" to "warn"), " type-warn ", 8, _uA(
                        "disabled"
                    )),
                    _cE("button", _uM("class" to "margin-10 btn", "disabled" to unref(disabled_boolean)), " size-default ", 8, _uA(
                        "disabled"
                    )),
                    _cE("button", _uM("class" to "margin-10 btn", "disabled" to unref(disabled_boolean), "size" to "mini"), " size-mini ", 8, _uA(
                        "disabled"
                    )),
                    _cE("button", _uM("class" to "margin-10 btn", "disabled" to unref(disabled_boolean), "plain" to true), " plain=true ", 8, _uA(
                        "disabled"
                    )),
                    _cE("button", _uM("class" to "margin-10 btn", "disabled" to unref(disabled_boolean), "type" to "primary", "plain" to true), " plain=true type=primary ", 8, _uA(
                        "disabled"
                    )),
                    _cE("button", _uM("class" to "margin-10 btn", "disabled" to unref(disabled_boolean), "type" to "warn", "plain" to true), " plain=true type=warn ", 8, _uA(
                        "disabled"
                    )),
                    _cE("button", _uM("class" to "margin-10 btn", "disabled" to unref(disabled_boolean)), " plain-false ", 8, _uA(
                        "disabled"
                    )),
                    _cE("button", _uM("class" to "margin-10 btn custom-btn", "disabled" to unref(disabled_boolean), "hover-class" to "is-hover"), " custom-btn ", 8, _uA(
                        "disabled"
                    )),
                    _cE("button", _uM("class" to "margin-10 btn custom-btn", "disabled" to unref(disabled_boolean), "plain" to "", "hover-class" to "is-hover"), " custom-btn ", 8, _uA(
                        "disabled"
                    )),
                    _cE("button", _uM("class" to "margin-10 btn", "style" to _nS(_uM("font-size" to "15px", "color" to "red")), "type" to "warn", "plain" to true, "disabled" to unref(disabled_boolean)), " custom-btn-plain-warn ", 12, _uA(
                        "disabled"
                    )),
                    _cE("button", _uM("class" to "margin-10", "type" to "primary", "disabled" to unref(disabled_boolean), "hover-class" to "none"), "hover-class none", 8, _uA(
                        "disabled"
                    )),
                    _cE("button", _uM("class" to "margin-10", "type" to "primary", "disabled" to unref(disabled_boolean)), "uni-app x", 8, _uA(
                        "disabled"
                    )),
                    _cE("button", _uM("id" to "changeDisabledButton", "class" to "margin-10", "type" to "primary", "onClick" to change_disabled_boolean), "修改disabled为" + _tD(!unref(disabled_boolean)), 1),
                    _cE("button", _uM("class" to "margin-10 btn"), " disable-false "),
                    _cE("button", _uM("class" to "margin-10 btn", "disabled" to true), " disable-true "),
                    _cE("button", _uM("class" to "margin-10 btn", "disabled" to unref(disabled_boolean)), " uni-app x，是下一代 uni-app，是一个跨平台应用开发引擎。 ", 8, _uA(
                        "disabled"
                    ))
                ), 4)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("margin-10" to _pS(_uM("marginTop" to 10, "marginRight" to 10, "marginBottom" to 10, "marginLeft" to 10)), "custom-btn" to _pS(_uM("color" to "#ffffff", "backgroundColor" to "#1AAD19", "borderTopColor" to "#1AAD19", "borderRightColor" to "#1AAD19", "borderBottomColor" to "#1AAD19", "borderLeftColor" to "#1AAD19", "borderTopLeftRadius" to 5, "borderTopRightRadius" to 5, "borderBottomRightRadius" to 5, "borderBottomLeftRadius" to 5, "borderTopWidth" to 0.5, "borderRightWidth" to 0.5, "borderBottomWidth" to 0.5, "borderLeftWidth" to 0.5, "height" to 53)), "is-hover" to _pS(_uM("color" to "rgba(255,255,255,0.6)", "backgroundColor" to "rgba(26,173,25,0.7)", "borderTopColor" to "rgba(26,173,25,0.7)", "borderRightColor" to "rgba(26,173,25,0.7)", "borderBottomColor" to "rgba(26,173,25,0.7)", "borderLeftColor" to "rgba(26,173,25,0.7)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
