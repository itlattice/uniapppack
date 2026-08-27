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
open class GenComponentsCustomRecycleViewButtonsCustomRecycleViewButtons : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var name: String by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsCustomRecycleViewButtonsCustomRecycleViewButtons) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsCustomRecycleViewButtonsCustomRecycleViewButtons
            val _cache = __ins.renderCache
            val props = __props
            val testName = props.name
            fun gen_onClickWrong_fn() {
                console.log("current name is " + testName)
            }
            val onClickWrong = ::gen_onClickWrong_fn
            fun gen_onClickRight_fn() {
                console.log("current name is " + props.name)
            }
            val onClickRight = ::gen_onClickRight_fn
            return fun(): Any? {
                return _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row"))), _uA(
                    _cE("view", _uM("onClick" to onClickWrong, "class" to "btn"), _uA(
                        _cE("text", _uM("class" to "btn-text"), "点击测试，错误写法")
                    )),
                    _cE("view", _uM("onClick" to onClickRight, "class" to "btn"), _uA(
                        _cE("text", _uM("class" to "btn-text"), "点击测试，正确写法")
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
                return _uM("btn" to _pS(_uM("paddingTop" to 5, "paddingRight" to 5, "paddingBottom" to 5, "paddingLeft" to 5)), "btn-text" to _pS(_uM("fontSize" to 12, "color" to "#cccccc", "borderTopLeftRadius" to 3, "borderTopRightRadius" to 3, "borderBottomRightRadius" to 3, "borderBottomLeftRadius" to 3, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#cccccc", "borderRightColor" to "#cccccc", "borderBottomColor" to "#cccccc", "borderLeftColor" to "#cccccc")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("name" to _uM("type" to "String", "default" to "")))
        var propsNeedCastKeys = _uA(
            "name"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
