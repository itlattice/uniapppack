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
open class GenPagesTemplateLabel100Label100 : BasePage {
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
        var setup: (__props: GenPagesTemplateLabel100Label100) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesTemplateLabel100Label100
            val _cache = __ins.renderCache
            val sharedChecked = ref(false)
            fun gen_toggleAll_fn() {
                sharedChecked.value = !sharedChecked.value
                console.log("切换全选状态:", sharedChecked.value)
            }
            val toggleAll = ::gen_toggleAll_fn
            fun gen_onGroupChange_fn(e: UniCheckboxGroupChangeEvent) {
                console.log("checkbox-group change:", e.detail.value)
            }
            val onGroupChange = ::gen_onGroupChange_fn
            return fun(): Any? {
                val _component_fps = resolveEasyComponent("fps", GenComponentsFpsFpsClass)
                val _component_checkbox = resolveComponent("checkbox")
                val _component_label = resolveComponent("label")
                val _component_checkbox_group = resolveComponent("checkbox-group")
                return _cE("view", _uM("style" to _nS(_uM("flex-direction" to "column", "background-color" to "#f5f5f5"))), _uA(
                    _cV(_component_fps),
                    _cE("view", _uM("style" to _nS(_uM("padding" to "2px", "background-color" to "#ffffff", "flex-direction" to "row", "flex-wrap" to "wrap", "align-items" to "center"))), _uA(
                        _cE("button", _uM("onClick" to toggleAll, "size" to "mini", "style" to _nS(_uM("margin" to "2px"))), _tD(if (unref(sharedChecked)) {
                            "取消"
                        } else {
                            "全选"
                        }
                        ), 5)
                    ), 4),
                    _cV(_component_checkbox_group, _uM("style" to _nS(_uM("flex-direction" to "row", "flex-wrap" to "wrap", "padding" to "2px")), "onChange" to onGroupChange), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(100, fun(index, __key, __index, _cached): Any {
                                return _cV(_component_label, _uM("key" to index, "style" to _nS(_uM("width" to "12%", "margin" to "4rpx", "padding" to "1px", "align-items" to "center", "flex-direction" to "column"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cE("text", _uM("style" to _nS(_uM("font-size" to "9px", "color" to "#666", "margin-bottom" to "2px"))), _tD(index), 5),
                                        _cV(_component_checkbox, _uM("value" to index.toString(10), "checked" to unref(sharedChecked)), null, 8, _uA(
                                            "value",
                                            "checked"
                                        ))
                                    )
                                }
                                ), "_" to 2), 1032, _uA(
                                    "style"
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
