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
open class GenPagesTemplateRadio200Radio200 : BasePage {
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
        var setup: (__props: GenPagesTemplateRadio200Radio200) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesTemplateRadio200Radio200
            val _cache = __ins.renderCache
            val sharedChecked = ref("")
            val sharedDisabled = ref(false)
            fun gen_toggleDisabled_fn() {
                sharedDisabled.value = !sharedDisabled.value
                console.log("切换disabled状态:", sharedDisabled.value)
            }
            val toggleDisabled = ::gen_toggleDisabled_fn
            fun gen_onSharedChange_fn(e: UniRadioGroupChangeEvent) {
                sharedChecked.value = e.detail.value
                console.log("radio状态改变:", e.detail.value)
            }
            val onSharedChange = ::gen_onSharedChange_fn
            return fun(): Any? {
                val _component_fps = resolveEasyComponent("fps", GenComponentsFpsFpsClass)
                val _component_radio = resolveComponent("radio")
                val _component_radio_group = resolveComponent("radio-group")
                return _cE("view", _uM("style" to _nS(_uM("background-color" to "#f5f5f5"))), _uA(
                    _cV(_component_fps),
                    _cE("view", _uM("style" to _nS(_uM("padding" to "2px", "background-color" to "#ffffff", "flex-direction" to "row", "flex-wrap" to "wrap", "align-items" to "center"))), _uA(
                        _cE("button", _uM("onClick" to toggleDisabled, "type" to if (unref(sharedDisabled)) {
                            "primary"
                        } else {
                            "default"
                        }
                        , "size" to "mini", "style" to _nS(_uM("margin" to "2px"))), _tD(if (unref(sharedDisabled)) {
                            "启用"
                        } else {
                            "禁用"
                        }
                        ), 13, _uA(
                            "type"
                        ))
                    ), 4),
                    _cV(_component_radio_group, _uM("onChange" to onSharedChange, "style" to _nS(_uM("flex-direction" to "row", "flex-wrap" to "wrap", "padding" to "2px"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(200, fun(index, __key, __index, _cached): Any {
                                return _cV(_component_radio, _uM("value" to index.toString(10), "checked" to (unref(sharedChecked) === index.toString(10)), "disabled" to unref(sharedDisabled), "key" to index), null, 8, _uA(
                                    "value",
                                    "checked",
                                    "disabled"
                                ))
                            }
                            ), 64)
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "style"
                    ))
                ), 4)
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
