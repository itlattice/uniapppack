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
open class GenPagesTemplateButton100Button100 : BasePage {
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
        var setup: (__props: GenPagesTemplateButton100Button100) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesTemplateButton100Button100
            val _cache = __ins.renderCache
            val sharedDisabled = ref(false)
            val sharedPlain = ref(false)
            val sharedType = ref("default")
            val sharedSize = ref("mini")
            fun gen_toggleDisabled_fn() {
                sharedDisabled.value = !sharedDisabled.value
                console.log("disabled:", sharedDisabled.value)
            }
            val toggleDisabled = ::gen_toggleDisabled_fn
            fun gen_togglePlain_fn() {
                sharedPlain.value = !sharedPlain.value
                console.log("plain:", sharedPlain.value)
            }
            val togglePlain = ::gen_togglePlain_fn
            val types = _uA(
                "default",
                "primary",
                "warn"
            )
            var typeIndex: Number = 0
            val sizes = _uA(
                "mini",
                "default"
            )
            var sizeIndex: Number = 0
            fun gen_cycleType_fn() {
                typeIndex = (typeIndex + 1) % types.length
                sharedType.value = types[typeIndex]
                console.log("type:", sharedType.value)
            }
            val cycleType = ::gen_cycleType_fn
            fun gen_cycleSize_fn() {
                sizeIndex = (sizeIndex + 1) % sizes.length
                sharedSize.value = sizes[sizeIndex]
                console.log("size:", sharedSize.value)
            }
            val cycleSize = ::gen_cycleSize_fn
            fun gen_onButtonClick_fn(index: Number) {
                console.log("button clicked:", index - 1)
            }
            val onButtonClick = ::gen_onButtonClick_fn
            return fun(): Any? {
                val _component_fps = resolveEasyComponent("fps", GenComponentsFpsFpsClass)
                return _cE("view", _uM("style" to _nS(_uM("flex-direction" to "column", "background-color" to "#f5f5f5"))), _uA(
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
                        )),
                        _cE("button", _uM("onClick" to togglePlain, "type" to if (unref(sharedPlain)) {
                            "primary"
                        } else {
                            "default"
                        }
                        , "size" to "mini", "style" to _nS(_uM("margin" to "2px"))), _tD(if (unref(sharedPlain)) {
                            "实心"
                        } else {
                            "镂空"
                        }
                        ), 13, _uA(
                            "type"
                        )),
                        _cE("button", _uM("onClick" to cycleType, "size" to "mini", "style" to _nS(_uM("margin" to "2px"))), "type: " + _tD(unref(sharedType)), 5),
                        _cE("button", _uM("onClick" to cycleSize, "size" to "mini", "style" to _nS(_uM("margin" to "2px"))), "size: " + _tD(unref(sharedSize)), 5)
                    ), 4),
                    _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row", "flex-wrap" to "wrap", "padding" to "5px"))), _uA(
                        _cE(Fragment, null, RenderHelpers.renderList(100, fun(index, __key, __index, _cached): Any {
                            return _cE("view", _uM("key" to index, "style" to _nS(_uM("width" to "15%", "margin" to "4rpx", "align-items" to "center"))), _uA(
                                _cE("button", _uM("disabled" to unref(sharedDisabled), "plain" to unref(sharedPlain), "type" to unref(sharedType), "size" to unref(sharedSize), "onClick" to fun(){
                                    onButtonClick(index)
                                }
                                , "style" to _nS(_uM("width" to "100%"))), _tD(index), 13, _uA(
                                    "disabled",
                                    "plain",
                                    "type",
                                    "size",
                                    "onClick"
                                ))
                            ), 4)
                        }
                        ), 64)
                    ), 4)
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
