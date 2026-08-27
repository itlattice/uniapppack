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
open class GenPagesTemplateCheckbox200Checkbox200 : BasePage {
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
        var setup: (__props: GenPagesTemplateCheckbox200Checkbox200) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesTemplateCheckbox200Checkbox200
            val _cache = __ins.renderCache
            val sharedChecked = ref(false)
            fun gen_toggleAll_fn() {
                sharedChecked.value = !sharedChecked.value
                console.log("切换全选状态:", sharedChecked.value)
            }
            val toggleAll = ::gen_toggleAll_fn
            return fun(): Any? {
                val _component_fps = resolveEasyComponent("fps", GenComponentsFpsFpsClass)
                val _component_checkbox = resolveComponent("checkbox")
                val _component_checkbox_group = resolveComponent("checkbox-group")
                return _cE("view", _uM("style" to _nS(_uM("flex-direction" to "column", "background-color" to "#f5f5f5", "position" to "relative"))), _uA(
                    _cV(_component_fps),
                    _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row", "align-items" to "center", "padding" to "2px", "background-color" to "#ffffff"))), _uA(
                        _cE("button", _uM("onClick" to toggleAll, "size" to "mini", "style" to _nS(_uM("margin" to "2px"))), _tD(if (unref(sharedChecked)) {
                            "取消"
                        } else {
                            "全选"
                        }
                        ), 5)
                    ), 4),
                    _cV(_component_checkbox_group, _uM("style" to _nS(_uM("margin" to "2px", "padding" to "2px", "flex-direction" to "row", "flex-wrap" to "wrap"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(200, fun(index, __key, __index, _cached): Any {
                                return _cV(_component_checkbox, _uM("key" to index, "checked" to unref(sharedChecked)), null, 8, _uA(
                                    "checked"
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
