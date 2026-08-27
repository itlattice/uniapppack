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
open class GenPagesComponentInputInputPerformance : BasePage {
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
        var setup: (__props: GenPagesComponentInputInputPerformance) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentInputInputPerformance
            val _cache = __ins.renderCache
            val sharedValue = ref("")
            val sharedDisabled = ref(false)
            fun gen_onInput_fn(e: UniInputEvent) {
                sharedValue.value = e.detail.value
                console.log("input value changed:", e.detail.value)
            }
            val onInput = ::gen_onInput_fn
            fun gen_clearValue_fn() {
                sharedValue.value = ""
                console.log("value cleared")
            }
            val clearValue = ::gen_clearValue_fn
            fun gen_toggleDisabled_fn() {
                sharedDisabled.value = !sharedDisabled.value
                console.log("disabled:", sharedDisabled.value)
            }
            val toggleDisabled = ::gen_toggleDisabled_fn
            return fun(): Any? {
                val _component_fps = resolveEasyComponent("fps", GenComponentsFpsFpsClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("class" to "page-container"), _uA(
                        _cV(_component_fps),
                        _cE("view", _uM("class" to "control-panel padding-2 flex-row flex-wrap"), _uA(
                            _cE("button", _uM("onClick" to clearValue, "size" to "mini", "class" to "ml-2"), "清空内容"),
                            _cE("button", _uM("onClick" to toggleDisabled, "type" to if (unref(sharedDisabled)) {
                                "primary"
                            } else {
                                "default"
                            }
                            , "size" to "mini", "class" to "ml-2"), _tD(if (unref(sharedDisabled)) {
                                "启用"
                            } else {
                                "禁用"
                            }
                            ) + "输入 ", 9, _uA(
                                "type"
                            )),
                            _cE("text", _uM("class" to "current-value"), "值: " + _tD(if (unref(sharedValue) == "") {
                                "(空)"
                            } else {
                                unref(sharedValue)
                            }
                            ), 1)
                        )),
                        _cE("view", _uM("class" to "padding-2 flex-row flex-wrap"), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(100, fun(index, __key, __index, _cached): Any {
                                return _cE("input", _uM("key" to index, "value" to unref(sharedValue), "placeholder" to index.toString(10), "disabled" to unref(sharedDisabled), "onInput" to onInput, "class" to "item padding-2"), null, 40, _uA(
                                    "value",
                                    "placeholder",
                                    "disabled"
                                ))
                            }
                            ), 64)
                        ))
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
                return _uM("ml-2" to _pS(_uM("marginLeft" to 2)), "padding-2" to _pS(_uM("paddingTop" to 2, "paddingRight" to 2, "paddingBottom" to 2, "paddingLeft" to 2)), "flex-row" to _pS(_uM("flexDirection" to "row")), "flex-wrap" to _pS(_uM("flexWrap" to "wrap")), "page-container" to _pS(_uM("backgroundColor" to "#f5f5f5")), "control-panel" to _pS(_uM("backgroundColor" to "#ffffff", "alignItems" to "center")), "current-value" to _pS(_uM("fontSize" to 11, "color" to "#666666", "marginLeft" to 5)), "item" to _pS(_uM("width" to "15%", "marginTop" to 1, "marginRight" to 1, "marginBottom" to 1, "marginLeft" to 1, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#dddddd", "borderRightColor" to "#dddddd", "borderBottomColor" to "#dddddd", "borderLeftColor" to "#dddddd", "fontSize" to 9, "borderTopLeftRadius" to 2, "borderTopRightRadius" to 2, "borderBottomRightRadius" to 2, "borderBottomLeftRadius" to 2, "backgroundColor" to "#ffffff", "height" to 30)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
