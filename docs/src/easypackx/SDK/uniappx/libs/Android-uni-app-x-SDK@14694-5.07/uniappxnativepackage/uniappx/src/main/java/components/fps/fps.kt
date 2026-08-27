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
open class GenComponentsFpsFps : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var interval: Number by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsFpsFps) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsFpsFps
            val _cache = __ins.renderCache
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val props = __props
            var animationId: Number = -1
            val fps = ref<Number>(0)
            var frameCount: Number = 0
            var fpsUpdateTime: Number = 0
            var calculateFPS = fun(currentTime: Number){}
            calculateFPS = fun(currentTime: Number){
                if (fpsUpdateTime == (0 as Number)) {
                    fpsUpdateTime = currentTime
                    animationId = requestAnimationFrame(calculateFPS)
                    return
                }
                frameCount++
                val delta = currentTime - fpsUpdateTime
                if (delta >= props.interval) {
                    val value = Math.round(frameCount * 1000 / delta)
                    fps.value = value
                    emit("updateFps", value)
                    frameCount = 0
                    fpsUpdateTime = currentTime
                }
                animationId = requestAnimationFrame(calculateFPS)
            }
            onMounted(fun(){
                animationId = requestAnimationFrame(calculateFPS)
            }
            )
            onBeforeUnmount(fun(){
                cancelAnimationFrame(animationId)
            }
            )
            return fun(): Any? {
                return _cE("view", _uM("style" to _nS(_uM("position" to "fixed", "right" to "10px", "top" to "10px", "z-index" to "999", "flex-direction" to "column", "align-items" to "flex-end", "pointer-events" to "none"))), _uA(
                    _cE("text", _uM("style" to _nS(_uM("font-size" to "24px", "color" to "green"))), "FPS: " + _tD(unref(fps)), 5)
                ), 4)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("updateFps" to null)
        var props = _nP(_uM("interval" to _uM("type" to "Number", "default" to 1000)))
        var propsNeedCastKeys = _uA(
            "interval"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
