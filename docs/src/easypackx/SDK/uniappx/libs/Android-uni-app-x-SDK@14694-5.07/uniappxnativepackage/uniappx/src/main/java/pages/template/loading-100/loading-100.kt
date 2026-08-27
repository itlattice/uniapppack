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
open class GenPagesTemplateLoading100Loading100 : BasePage {
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
        var setup: (__props: GenPagesTemplateLoading100Loading100) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesTemplateLoading100Loading100
            val _cache = __ins.renderCache
            val paused = ref(false)
            val datetime = ref("")
            var timerId: Number? = null
            var timerRunning = false
            fun gen_updateTime_fn() {
                val now = Date()
                val hours = now.getHours().toString(10).padStart(2, "0")
                val minutes = now.getMinutes().toString(10).padStart(2, "0")
                val seconds = now.getSeconds().toString(10).padStart(2, "0")
                val milliseconds = now.getMilliseconds().toString(10)
                datetime.value = "" + hours + ":" + minutes + ":" + seconds + "." + milliseconds
            }
            val updateTime = ::gen_updateTime_fn
            fun gen_startTimer_fn() {
                updateTime()
                timerId = setInterval(fun(){
                    updateTime()
                }
                , 1)
                timerRunning = true
            }
            val startTimer = ::gen_startTimer_fn
            fun gen_stopTimer_fn() {
                if (timerId != null) {
                    clearInterval(timerId as Number)
                    timerId = null
                }
                timerRunning = false
            }
            val stopTimer = ::gen_stopTimer_fn
            fun gen_toggleTimer_fn() {
                if (timerRunning) {
                    stopTimer()
                } else {
                    startTimer()
                }
            }
            val toggleTimer = ::gen_toggleTimer_fn
            onReady(fun(){
                startTimer()
            }
            )
            onUnload(fun(){
                stopTimer()
            }
            )
            fun gen_changePaused_fn() {
                paused.value = !paused.value
            }
            val changePaused = ::gen_changePaused_fn
            return fun(): Any? {
                val _component_fps = resolveEasyComponent("fps", GenComponentsFpsFpsClass)
                val _component_loading = resolveComponent("loading")
                return _cE("view", _uM("style" to _nS(_uM("flex-direction" to "column", "background-color" to "#f5f5f5", "padding" to "3px"))), _uA(
                    _cV(_component_fps),
                    _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row", "flex-wrap" to "wrap", "align-items" to "center", "margin-top" to "40px"))), _uA(
                        _cE("button", _uM("size" to "mini", "onClick" to toggleTimer, "style" to _nS(_uM("margin-right" to "4px"))), "停止/启动 计时", 4),
                        _cE("text", null, _tD(unref(datetime)), 1)
                    ), 4),
                    _cE("text", _uM("style" to _nS(_uM<String, Any?>())), "计时器主线程一直占用绘制文字，但100个loading圈不卡顿", 4),
                    _cE("button", _uM("size" to "mini", "onClick" to changePaused), _tD(if (unref(paused)) {
                        "旋转"
                    } else {
                        "暂停"
                    }
                    ), 1),
                    _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row", "flex-wrap" to "wrap", "padding" to "2px"))), _uA(
                        _cE(Fragment, null, RenderHelpers.renderList(100, fun(index, __key, __index, _cached): Any {
                            return _cV(_component_loading, _uM("key" to index, "paused" to unref(paused), "style" to _nS(_uM("margin" to "10px"))), null, 8, _uA(
                                "paused",
                                "style"
                            ))
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
