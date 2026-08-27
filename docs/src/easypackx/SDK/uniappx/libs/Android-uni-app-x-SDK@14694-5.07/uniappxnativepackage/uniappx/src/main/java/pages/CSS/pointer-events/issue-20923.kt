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
open class GenPagesCSSPointerEventsIssue20923 : BasePage {
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
    open var get_jest_result: () -> UTSArray<Number>
        get() {
            return unref(this.`$exposed`["get_jest_result"]) as () -> UTSArray<Number>
        }
        set(value) {
            setRefValue(this.`$exposed`, "get_jest_result", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesCSSPointerEventsIssue20923, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSPointerEventsIssue20923
            val _cache = __ins.renderCache
            val logs = reactive(_uA<String>())
            val jest_result: UTSArray<Number> = _uA()
            fun gen_clickEvent_fn(from: Number) {
                if (logs.length > 5) {
                    logs.shift()
                    jest_result.shift()
                }
                logs.push("trigger click from " + from + ": " + Date.now())
                jest_result.push(from)
            }
            val clickEvent = ::gen_clickEvent_fn
            fun gen_get_jest_result_fn(): UTSArray<Number> {
                return jest_result
            }
            val get_jest_result = ::gen_get_jest_result_fn
            __expose(_uM("get_jest_result" to get_jest_result))
            return fun(): Any? {
                return _cE(Fragment, null, _uA(
                    _cE("view", _uM("style" to _nS(_uM("flex" to "1")), "onClick" to fun(){
                        clickEvent(0)
                    }
                    ), _uA(
                        _cE(Fragment, null, RenderHelpers.renderList(unref(logs), fun(item, __key, __index, _cached): Any {
                            return _cE("view", _uM("key" to item), _tD(item), 1)
                        }
                        ), 128)
                    ), 12, _uA(
                        "onClick"
                    )),
                    _cE("view", _uM("class" to "mask", "onClick" to fun(){
                        clickEvent(1)
                    }
                    ), _uA(
                        _cE("view", _uM("class" to "mask-content", "onClick" to fun(){
                            clickEvent(2)
                        }
                        ), null, 8, _uA(
                            "onClick"
                        ))
                    ), 8, _uA(
                        "onClick"
                    ))
                ), 64)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("mask" to _pS(_uM("position" to "absolute", "left" to 0, "top" to 0, "right" to 0, "bottom" to 0, "pointerEvents" to "none", "alignItems" to "center", "justifyContent" to "center")), "mask-content" to _pS(_uM("width" to 100, "height" to 100, "backgroundColor" to "#FF0000")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
