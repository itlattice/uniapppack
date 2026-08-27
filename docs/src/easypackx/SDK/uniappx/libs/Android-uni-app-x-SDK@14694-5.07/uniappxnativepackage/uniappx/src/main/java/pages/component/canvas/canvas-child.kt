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
import io.dcloud.uniapp.extapi.`$emit` as uni__emit
import io.dcloud.uniapp.extapi.createCanvasContextAsync as uni_createCanvasContextAsync
open class GenPagesComponentCanvasCanvasChild : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var testCounter: Number
        get() {
            return unref(this.`$exposed`["testCounter"]) as Number
        }
        set(value) {
            setRefValue(this.`$exposed`, "testCounter", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentCanvasCanvasChild, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentCanvasCanvasChild
            val _cache = __ins.renderCache
            val instance = getCurrentInstance()!!.proxy!!
            val testCounter = ref(0)
            fun gen__dispatchEvent_fn() {
                if (testCounter.value == 2) {
                    uni__emit("canvasChildReady", testCounter.value)
                }
            }
            val _dispatchEvent = ::gen__dispatchEvent_fn
            onMounted(fun(){
                uni_createCanvasContextAsync(CreateCanvasContextAsyncOptions(id = "canvas1", component = instance, success = fun(_: CanvasContext){
                    testCounter.value++
                    _dispatchEvent()
                }
                ))
                uni_createCanvasContextAsync(CreateCanvasContextAsyncOptions(id = "canvas2", component = instance, success = fun(_: CanvasContext){
                    testCounter.value++
                    _dispatchEvent()
                }
                ))
            }
            )
            __expose(_uM("testCounter" to testCounter))
            return fun(): Any? {
                return _cE(Fragment, null, _uA(
                    _cE("view", null, _uA(
                        _cE("canvas", _uM("id" to "canvas1"))
                    )),
                    _cE("view", null, _uA(
                        _cE("canvas", _uM("id" to "canvas2"))
                    )),
                    _cE("view", null, _tD(unref(testCounter)), 1)
                ), 64)
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
