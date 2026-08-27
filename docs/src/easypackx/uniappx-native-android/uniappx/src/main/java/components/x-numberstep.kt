@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNI2971F61
import android.content.Context
import io.dcloud.uniapp.*
import io.dcloud.uniapp.extapi.*
import io.dcloud.uniapp.framework.*
import io.dcloud.uniapp.runtime.*
import io.dcloud.uniapp.vue.*
import io.dcloud.uniapp.vue.shared.*
import io.dcloud.uts.*
import io.dcloud.uts.Map
import io.dcloud.uts.Set
import io.dcloud.uts.UTSAndroid
import kotlin.properties.Delegates
import uts.sdk.modules.iboxsChooseMedia.MediaScanner
open class GenComponentsXNumberstep : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var modelValue: Number by `$props`
    open var step: Number by `$props`
    open var min: Number by `$props`
    open var max: Number by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXNumberstep) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXNumberstep
            val _cache = __ins.renderCache
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val props = __props
            val num = computed(fun(): Number {
                return props.modelValue
            }
            )
            val inputChange = fun(e: UniInputEvent){
                emit("change", e.detail.value)
                emit("update:modelValue", e.detail.value)
            }
            val add = fun(){
                var value = props.modelValue + props.step
                if (value > props.max && props.max >= 0) {
                    value = props.max
                }
                emit("change", value + "")
            }
            val dec = fun(){
                var value = props.modelValue - props.step
                if (value < props.min) {
                    value = props.min
                }
                emit("change", value + "")
            }
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                return _cE("view", _uM("class" to "step display-flex"), _uA(
                    _cE("view", _uM("class" to "decbtn activebtn", "onClick" to dec), _uA(
                        _cV(_component_x_iconfont, _uM("class" to "icon align-center", "name" to "jianhao", "size" to "16", "color" to if (_ctx.min >= unref(num)) {
                            "#C4C4C4"
                        } else {
                            "#adadad"
                        }
                        , "height" to 25), null, 8, _uA(
                            "color"
                        ))
                    )),
                    _cE("view", _uM("class" to "input"), _uA(
                        _cE("input", _uM("type" to "digit", "onInput" to inputChange, "value" to unref(num), "class" to "inp align-center"), null, 40, _uA(
                            "value"
                        ))
                    )),
                    _cE("view", _uM("class" to "addbtn activebtn", "onClick" to add), _uA(
                        _cV(_component_x_iconfont, _uM("class" to "icon align-center", "name" to "jiahao", "size" to "16", "color" to if ((_ctx.max >= 0 && _ctx.max <= unref(num))) {
                            "#C4C4C4"
                        } else {
                            "#adadad"
                        }
                        , "height" to 25), null, 8, _uA(
                            "color"
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
                return _uM("step" to _pS(_uM("width" to 91, "height" to 27)), "decbtn" to _uM(".step " to _uM("width" to 27, "height" to 27, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#DEDEDE", "borderRightColor" to "#DEDEDE", "borderBottomColor" to "#DEDEDE", "borderLeftColor" to "#DEDEDE", "borderTopLeftRadius" to 3, "borderBottomLeftRadius" to 3)), "input" to _uM(".step " to _uM("width" to 27, "height" to 27, "borderTopWidth" to 1, "borderTopStyle" to "solid", "borderTopColor" to "#adadad", "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#adadad")), "inp" to _uM(".step .input " to _uM("height" to 27, "fontSize" to 13)), "addbtn" to _uM(".step " to _uM("width" to 27, "height" to 27, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#DEDEDE", "borderRightColor" to "#DEDEDE", "borderBottomColor" to "#DEDEDE", "borderLeftColor" to "#DEDEDE", "borderTopRightRadius" to 3, "borderBottomRightRadius" to 3)), "activebtn" to _uM(".step " to _uM("borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#adadad", "borderRightColor" to "#adadad", "borderBottomColor" to "#adadad", "borderLeftColor" to "#adadad")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("change" to null, "update:modelValue" to null)
        var props = _nP(_uM("modelValue" to _uM("type" to "Number", "default" to 0), "step" to _uM("type" to "Number", "default" to 1), "min" to _uM("type" to "Number", "default" to 0), "max" to _uM("type" to "Number", "default" to -1)))
        var propsNeedCastKeys = _uA(
            "modelValue",
            "step",
            "min",
            "max"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
