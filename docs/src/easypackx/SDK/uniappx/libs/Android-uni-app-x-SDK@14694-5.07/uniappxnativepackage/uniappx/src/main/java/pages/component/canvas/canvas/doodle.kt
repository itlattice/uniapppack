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
import io.dcloud.uniapp.extapi.createCanvasContextAsync as uni_createCanvasContextAsync
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
open class GenPagesComponentCanvasCanvasDoodle : BasePage {
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
        var setup: (__props: GenPagesComponentCanvasCanvasDoodle) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentCanvasCanvasDoodle
            val _cache = __ins.renderCache
            var lastPointX: Number = 0
            var lastPointY: Number = 0
            var offsetX: Number = 0
            var offsetY: Number = 0
            var renderingContext: CanvasRenderingContext2D? = null
            fun gen_getPosition_fn(event: TouchEvent): Point {
                val touch = event.touches[0]
                return Point(x = touch.clientX - offsetX, y = touch.clientY - offsetY)
            }
            val getPosition = ::gen_getPosition_fn
            fun gen_touchStart_fn(event: TouchEvent) {
                val position = getPosition(event)
                lastPointX = position.x
                lastPointY = position.y
            }
            val touchStart = ::gen_touchStart_fn
            fun gen_touchMove_fn(event: TouchEvent) {
                val position = getPosition(event)
                val x = position.x
                val y = position.y
                val ctx = renderingContext!!
                ctx.lineWidth = 5
                ctx.lineCap = "round"
                ctx.lineJoin = "round"
                ctx.beginPath()
                ctx.moveTo(lastPointX, lastPointY)
                ctx.lineTo(x, y)
                ctx.stroke()
                lastPointX = x
                lastPointY = y
            }
            val touchMove = ::gen_touchMove_fn
            fun gen_touchEnd_fn(event: TouchEvent) {}
            val touchEnd = ::gen_touchEnd_fn
            fun gen_doClear_fn() {
                if (renderingContext != null) {
                    renderingContext!!.clearRect(0, 0, renderingContext!!.canvas.width, renderingContext!!.canvas.height)
                }
            }
            val doClear = ::gen_doClear_fn
            onReady(fun(){
                uni_createCanvasContextAsync(CreateCanvasContextAsyncOptions(id = "tablet", success = fun(context: CanvasContext){
                    console.log("success")
                    renderingContext = context.getContext("2d")!!
                    val canvas = renderingContext!!.canvas
                    val dpr = uni_getWindowInfo().pixelRatio
                    canvas.width = canvas.offsetWidth * dpr
                    canvas.height = canvas.offsetHeight * dpr
                    renderingContext!!.scale(dpr, dpr)
                    val elRect = canvas.getBoundingClientRect()
                    offsetX = elRect.left
                    offsetY = elRect.top
                }
                ))
            }
            )
            return fun(): Any? {
                return _cE("view", null, _uA(
                    _cE("canvas", _uM("class" to "drawing", "id" to "tablet", "onTouchstart" to touchStart, "onTouchmove" to touchMove, "onTouchend" to touchEnd), null, 32),
                    _cE("button", _uM("onClick" to fun(){
                        doClear()
                    }
                    ), "清空", 8, _uA(
                        "onClick"
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
                return _uM("drawing" to _pS(_uM("width" to "100%", "height" to 500, "backgroundColor" to "#D3D3D3", "marginBottom" to 15)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
