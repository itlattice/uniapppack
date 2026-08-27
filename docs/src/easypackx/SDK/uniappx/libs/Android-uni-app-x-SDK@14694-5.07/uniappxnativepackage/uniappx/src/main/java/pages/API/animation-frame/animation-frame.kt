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
open class GenPagesAPIAnimationFrameAnimationFrame : BasePage {
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
    open var data: DataType__55
        get() {
            return unref(this.`$exposed`["data"]) as DataType__55
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var startRequestAnimationFrame: StartRequestAnimationFrameType
        get() {
            return unref(this.`$exposed`["startRequestAnimationFrame"]) as StartRequestAnimationFrameType
        }
        set(value) {
            setRefValue(this.`$exposed`, "startRequestAnimationFrame", value)
        }
    open var stopRequestAnimationFrame: () -> Unit
        get() {
            return unref(this.`$exposed`["stopRequestAnimationFrame"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "stopRequestAnimationFrame", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIAnimationFrameAnimationFrame, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIAnimationFrameAnimationFrame
            val _cache = __ins.renderCache
            val data = reactive(DataType__55(title = "AnimationFrame", taskId = 0, FPSString = "- / -ms", lastTime = 0, frameCount = 0, testFrameCount = 0))
            val updateFPS = fun(timestamp: Number){
                data.frameCount++
                if (timestamp - data.lastTime >= 1000) {
                    val timeOfFrame = ((1000 as Number) / data.frameCount)
                    data.FPSString = "" + data.frameCount + " / " + timeOfFrame.toFixed(3) + "ms"
                    data.frameCount = 0
                    data.lastTime = timestamp
                }
            }
            var startRequestAnimationFrame: StartRequestAnimationFrameType = fun(){}
            startRequestAnimationFrame = fun(){
                data.taskId = requestAnimationFrame(fun(timestamp: Number){
                    updateFPS(timestamp)
                    data.testFrameCount++
                    startRequestAnimationFrame()
                }
                )
            }
            val stopRequestAnimationFrame = fun(){
                cancelAnimationFrame(data.taskId)
                data.lastTime = 0
                data.frameCount = 0
                data.FPSString = "- / -ms"
            }
            onUnload(fun(){
                if (data.taskId > 0) {
                    stopRequestAnimationFrame()
                }
            }
            )
            __expose(_uM("data" to data, "startRequestAnimationFrame" to startRequestAnimationFrame, "stopRequestAnimationFrame" to stopRequestAnimationFrame))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE("view", _uM("class" to "page"), _uA(
                    _cV(_component_page_head, _uM("title" to unref(data).title), null, 8, _uA(
                        "title"
                    )),
                    _cE("button", _uM("onClick" to unref(startRequestAnimationFrame)), "requestAnimationFrame", 8, _uA(
                        "onClick"
                    )),
                    _cE("button", _uM("onClick" to stopRequestAnimationFrame), "cancelAnimationFrame"),
                    _cE("text", _uM("class" to "frame-count"), "FPS: " + _tD(unref(data).FPSString), 1),
                    _cE("text", _uM("class" to "frame-count"), "FrameCount: " + _tD(unref(data).testFrameCount), 1),
                    _cE("text", _uM("class" to "tips"), "提示: 在当前测试例子中，每增加一次调用 requestAnimationFrame 帧率翻倍，cancelAnimationFrame 后恢复")
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
                return _uM("page" to _pS(_uM("paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15)), "frame-count" to _pS(_uM("marginTop" to 15)), "tips" to _pS(_uM("fontSize" to 12, "marginTop" to 30, "opacity" to 0.7)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
