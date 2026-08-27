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
import io.dcloud.uniapp.extapi.getElementById as uni_getElementById
open class GenPagesComponentGlobalEventsTransitionEvents : BasePage {
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
    open var data: DataType__39
        get() {
            return unref(this.`$exposed`["data"]) as DataType__39
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var switchBtn: () -> Unit
        get() {
            return unref(this.`$exposed`["switchBtn"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "switchBtn", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentGlobalEventsTransitionEvents, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentGlobalEventsTransitionEvents
            val _cache = __ins.renderCache
            var times: Number = 0
            var element: UniElement? = null
            var isStart = false
            val buttonValue = ref("开启图片旋转")
            val data = reactive(DataType__39(onTransitionEndTriggr = false))
            val isShow = ref(false)
            fun gen_switchBtn_fn() {
                if (!isStart) {
                    if (element == null) {
                        element = uni_getElementById("transition-transform")
                    }
                    buttonValue.value = "关闭图片旋转"
                    times = times + 1
                    element!!.style.setProperty("transition-duration", "2000ms")
                    element!!.style.setProperty("transform", "rotate(" + times * 360 + "deg)")
                    isStart = true
                } else {
                    isStart = false
                    times = 0
                    data.onTransitionEndTriggr = false
                    buttonValue.value = "开启图片旋转"
                    element!!.style.setProperty("transition-duration", "0ms")
                    element!!.style.setProperty("transform", "rotate(0deg)")
                }
            }
            val switchBtn = ::gen_switchBtn_fn
            fun gen_onEnd_fn() {
                console.log("transform transitionend")
                if (isStart) {
                    times = times + 1
                    element!!.style.setProperty("transform", "rotate(" + times * 360 + "deg)")
                    data.onTransitionEndTriggr = true
                }
            }
            val onEnd = ::gen_onEnd_fn
            onReady(fun(){
                open class ThreadRunnable : Runnable {
                    override fun run() {
                        isShow.value = true
                    }
                }
                Thread(ThreadRunnable()).start()
            }
            )
            __expose(_uM("data" to data, "switchBtn" to switchBtn))
            return fun(): Any? {
                return if (isTrue(unref(isShow))) {
                    _cE("scroll-view", _uM("key" to 0, "style" to _nS(_uM("flex" to "1"))), _uA(
                        _cE("image", _uM("class" to "transition-transform", "id" to "transition-transform", "onTransitionend" to onEnd, "src" to "/static/test-image/logo.png"), null, 32),
                        _cE("text", _uM("class" to "adjust"), "对图片设置transform进行旋转，在旋转完成的transitionend事件后，继续旋转"),
                        _cE("button", _uM("class" to "adjust", "onClick" to switchBtn), _tD(unref(buttonValue)), 1)
                    ), 4)
                } else {
                    _cC("v-if", true)
                }
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("adjust" to _pS(_uM("marginTop" to 10, "marginRight" to 10, "marginBottom" to 10, "marginLeft" to 10)), "transition-transform" to _pS(_uM("width" to 200, "height" to 200, "marginTop" to 25, "marginRight" to "auto", "marginBottom" to 25, "marginLeft" to "auto", "borderTopLeftRadius" to 100, "borderTopRightRadius" to 100, "borderBottomRightRadius" to 100, "borderBottomLeftRadius" to 100, "transitionProperty" to "transform", "transitionTimingFunction" to "linear", "transform" to "rotate(0deg)")), "@TRANSITION" to _uM("transition-transform" to _uM("property" to "transform", "timingFunction" to "linear")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
