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
open class GenPagesComponentSwitchSwitch : BasePage {
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
    open var data: DataType__31
        get() {
            return unref(this.`$exposed`["data"]) as DataType__31
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentSwitchSwitch, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentSwitchSwitch
            val _cache = __ins.renderCache
            val data = reactive(DataType__31(title = "switch 开关", checked = true, color = "#FFCC33", clickCheckedValue = true, testVerifyEvent = false))
            val switch1Change = fun(e: UniSwitchChangeEvent){
                data.clickCheckedValue = e.detail.value
                console.log("switch1 发生 change 事件，携带值为", e.detail.value)
                data.testVerifyEvent = (e.type == "change" && (e.target?.tagName ?: "") == "SWITCH")
            }
            val switch2Change = fun(e: UniSwitchChangeEvent){
                console.log("switch2 发生 change 事件，携带值为", e.detail.value)
            }
            __expose(_uM("data" to data))
            return fun(): Any? {
                val _component_switch = resolveComponent("switch")
                val _component_navigator = resolveComponent("navigator")
                return _cE("view", null, _uA(
                    _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt"), _uA(
                        _cE("view", _uM("class" to "uni-title"), "默认样式"),
                        _cE("view", _uM("class" to "flex-row"), _uA(
                            _cV(_component_switch, _uM("class" to "switch-checked", "checked" to unref(data).checked, "onChange" to switch1Change), null, 8, _uA(
                                "checked"
                            )),
                            _cV(_component_switch, _uM("onChange" to switch2Change))
                        )),
                        _cE("view", _uM("class" to "uni-title"), "暗黑样式"),
                        _cE("view", _uM("class" to "flex-row"), _uA(
                            _cV(_component_switch, _uM("id" to "darkChecked", "background-color" to "#1f1f1f", "activeBackgroundColor" to "#007aff", "foreColor" to "#f0f0f0", "activeForeColor" to "#ffffff", "checked" to unref(data).checked), null, 8, _uA(
                                "checked"
                            )),
                            _cV(_component_switch, _uM("id" to "dark", "background-color" to "#1f1f1f", "activeBackgroundColor" to "#007aff", "foreColor" to "#f0f0f0", "activeForeColor" to "#ffffff"))
                        )),
                        _cE("view", _uM("class" to "uni-title"), "禁用样式"),
                        _cE("view", _uM("class" to "flex-row"), _uA(
                            _cV(_component_switch, _uM("class" to "switch-checked", "checked" to unref(data).checked, "disabled" to true), null, 8, _uA(
                                "checked"
                            )),
                            _cV(_component_switch, _uM("disabled" to true))
                        )),
                        _cE("view", _uM("class" to "uni-title"), "不同颜色和尺寸的switch"),
                        _cE("view", _uM("class" to "flex-row"), _uA(
                            _cV(_component_switch, _uM("class" to "switch-color-checked", "color" to unref(data).color, "style" to _nS(_uM("transform" to "scale(0.7)")), "checked" to true), null, 8, _uA(
                                "color",
                                "style"
                            )),
                            _cV(_component_switch, _uM("class" to "switch-color", "color" to unref(data).color, "style" to _nS(_uM("transform" to "scale(0.7)"))), null, 8, _uA(
                                "color",
                                "style"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-title"), "推荐展示样式")
                    )),
                    _cE("view", _uM("class" to "uni-list"), _uA(
                        _cE("view", _uM("class" to "uni-list-cell uni-list-cell-padding"), _uA(
                            _cE("view", _uM("class" to "uni-list-cell-db"), "开启中"),
                            _cV(_component_switch, _uM("checked" to true))
                        )),
                        _cE("view", _uM("class" to "uni-list-cell uni-list-cell-padding"), _uA(
                            _cE("view", _uM("class" to "uni-list-cell-db"), "关闭"),
                            _cV(_component_switch)
                        ))
                    )),
                    _cV(_component_navigator, _uM("class" to "uni-common-mb", "url" to "/pages/template/switch-100/switch-100"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("button", null, "组件性能测试")
                        )
                    }
                    ), "_" to 1))
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
                return _uM("flex-row" to _pS(_uM("flexDirection" to "row")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
