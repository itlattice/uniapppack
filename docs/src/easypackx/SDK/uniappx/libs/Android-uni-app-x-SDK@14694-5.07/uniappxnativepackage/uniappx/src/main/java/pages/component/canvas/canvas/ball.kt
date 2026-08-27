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
open class GenPagesComponentCanvasCanvasBall : BasePage {
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
        var setup: (__props: GenPagesComponentCanvasCanvasBall) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentCanvasCanvasBall
            val _cache = __ins.renderCache
            var fpsString = ref("-/-ms")
            var ballSpeed = ref(3)
            var ballLayer = ref(3)
            var ballInlayer = ref(20)
            open class Ball {
                private var width: Number
                private var height: Number
                open lateinit var x: Number
                open lateinit var y: Number
                open lateinit var vx: Number
                open lateinit var vy: Number
                open var radius: Number = 5
                constructor(w: Number, h: Number, x: Number, y: Number, vx: Number, vy: Number){
                    this.width = w
                    this.height = h
                    this.x = x
                    this.y = y
                    this.vx = vx
                    this.vy = vy
                }
                open fun move() {
                    this.x += this.vx
                    this.y += this.vy
                    if (this.x < this.radius) {
                        this.vx = Math.abs(this.vx)
                        return
                    }
                    if (this.x > this.width - this.radius) {
                        this.vx = -Math.abs(this.vx)
                    }
                    if (this.y < this.radius) {
                        this.vy = Math.abs(this.vy)
                        return
                    }
                    if (this.y > this.height - this.radius) {
                        this.vy = -Math.abs(this.vy)
                    }
                }
            }
            open class BallAnimation {
                private var ctx: CanvasRenderingContext2D
                private var canvasContext: CanvasContext
                private var ballList: UTSArray<Ball> = _uA()
                private var _speed: Number = 3
                private var _layer: Number = 3
                private var _ballInlayer: Number = 20
                private var runningFlag: Boolean = false
                private var _animateTaskId: Number = 0
                private var frameCount: Number = 0
                private var lastTime: Number = 0
                constructor(canvasContext: CanvasContext){
                    this.canvasContext = canvasContext
                    this.ctx = canvasContext.getContext("2d") as CanvasRenderingContext2D
                    this.initBall()
                    this.ctx.fillStyle = "#007AFF"
                }
                private fun getDistance(x: Number, y: Number): Number {
                    return Math.pow((Math.pow(x, 2) + Math.pow(y, 2)), 0.5)
                }
                private fun initBall() {
                    val canvasWidth = this.ctx.canvas.offsetWidth
                    val canvasHeight = this.ctx.canvas.offsetHeight
                    run {
                        var i: Number = 0
                        while(i < this._layer){
                            var radius = this.getDistance(canvasWidth / 2, canvasHeight / 2) / this._layer * i
                            run {
                                var j: Number = 0
                                while(j < this._ballInlayer){
                                    var deg = j * 2 * Math.PI / this._ballInlayer
                                    var sin = Math.sin(deg)
                                    var cos = Math.cos(deg)
                                    var x = radius * cos + canvasWidth / 2
                                    var y = radius * sin + canvasHeight / 2
                                    var vx = this.speed * cos
                                    var vy = this.speed * sin
                                    this.ballList.push(Ball(canvasWidth, canvasHeight, x, y, vx, vy))
                                    j++
                                }
                            }
                            i++
                        }
                    }
                }
                private fun reset() {
                    this.ballList.length = 0
                    this.initBall()
                }
                open var speed: Number
                    get(): Number {
                        return this._speed
                    }
                    set(value: Number) {
                        this._speed = value
                        this.reset()
                    }
                open var layer: Number
                    get(): Number {
                        return this._layer
                    }
                    set(value: Number) {
                        this._layer = value
                        this.reset()
                    }
                open var inLayer: Number
                    get(): Number {
                        return this._ballInlayer
                    }
                    set(value: Number) {
                        this._ballInlayer = value
                        this.reset()
                    }
                public open fun animate() {
                    this.ctx.clearRect(0, 0, this.ctx.canvas.offsetWidth, this.ctx.canvas.offsetHeight)
                    this.ballList.forEach(fun(item){
                        item.move()
                        this.ctx.beginPath()
                        this.ctx.arc(item.x, item.y, item.radius, 0, 2 * Math.PI)
                        this.ctx.fill()
                    }
                    )
                    if (!this.runningFlag) {
                        return
                    }
                    this._animateTaskId = this.canvasContext.requestAnimationFrame(fun(timestamp: Number){
                        this.animate()
                        this.updateFPS(timestamp)
                    }
                    )
                }
                open fun updateFPS(timestamp: Number) {
                    this.frameCount++
                    if (timestamp - this.lastTime >= 1000) {
                        val timeOfFrame = ((1000 as Number) / this.frameCount)
                        fpsString.value = "" + this.frameCount + " / " + timeOfFrame.toFixed(3) + "ms"
                        this.frameCount = 0
                        this.lastTime = timestamp
                    }
                }
                open fun start() {
                    this.canvasContext.cancelAnimationFrame(this._animateTaskId)
                    this.runningFlag = true
                    this.animate()
                }
                open fun stop() {
                    this.runningFlag = false
                    this.canvasContext.cancelAnimationFrame(this._animateTaskId)
                }
            }
            var animation: BallAnimation? = null
            onReady(fun(){
                uni_createCanvasContextAsync(CreateCanvasContextAsyncOptions(id = "canvas", success = fun(context: CanvasContext){
                    val renderingContext = context.getContext("2d")!!
                    val canvas = renderingContext.canvas
                    val dpr = uni_getWindowInfo().pixelRatio
                    canvas.width = canvas.offsetWidth * dpr
                    canvas.height = canvas.offsetHeight * dpr
                    renderingContext.scale(dpr, dpr)
                    animation = BallAnimation(context)
                    animation?.start()
                }
                ))
            }
            )
            var lessClick = fun(type: String){
                if (type == "speed") {
                    animation!!.speed--
                    ballSpeed.value = animation!!.speed
                } else if (type == "layer") {
                    animation!!.layer -= 5
                    ballLayer.value = animation!!.layer
                } else if (type == "inLayer") {
                    animation!!.inLayer -= 5
                    ballInlayer.value = animation!!.inLayer
                }
            }
            var plusClick = fun(type: String){
                if (type == "speed") {
                    animation!!.speed++
                    ballSpeed.value = animation!!.speed
                } else if (type == "layer") {
                    animation!!.layer += 5
                    ballLayer.value = animation!!.layer
                } else if (type == "inLayer") {
                    animation!!.inLayer += 5
                    ballInlayer.value = animation!!.inLayer
                }
            }
            onUnload(fun(){
                animation?.stop()
                animation = null
            }
            )
            onPageShow(fun(){
                animation?.start()
            }
            )
            onPageHide(fun(){
                animation?.stop()
            }
            )
            return fun(): Any? {
                return _cE("view", _uM("class" to "page-body"), _uA(
                    _cE("canvas", _uM("id" to "canvas", "class" to "canvas")),
                    _cE("text", _uM("class" to "fps"), "FPS: " + _tD(unref(fpsString)), 1),
                    _cE("view", _uM("class" to "item"), _uA(
                        _cE("text", _uM("class" to "item-label"), "Speed"),
                        _cE("button", _uM("size" to "mini", "onClick" to fun(){
                            unref(lessClick)("speed")
                        }
                        ), "-", 8, _uA(
                            "onClick"
                        )),
                        _cE("text", _uM("class" to "item-value"), _tD(unref(ballSpeed)), 1),
                        _cE("button", _uM("size" to "mini", "onClick" to fun(){
                            unref(plusClick)("speed")
                        }
                        ), "+", 8, _uA(
                            "onClick"
                        ))
                    )),
                    _cE("view", _uM("class" to "item"), _uA(
                        _cE("text", _uM("class" to "item-label"), "Layer"),
                        _cE("button", _uM("size" to "mini", "onClick" to fun(){
                            unref(lessClick)("layer")
                        }
                        ), "-", 8, _uA(
                            "onClick"
                        )),
                        _cE("text", _uM("class" to "item-value"), _tD(unref(ballLayer)), 1),
                        _cE("button", _uM("size" to "mini", "onClick" to fun(){
                            unref(plusClick)("layer")
                        }
                        ), "+", 8, _uA(
                            "onClick"
                        ))
                    )),
                    _cE("view", _uM("class" to "item"), _uA(
                        _cE("text", _uM("class" to "item-label"), "Inlayer"),
                        _cE("button", _uM("size" to "mini", "onClick" to fun(){
                            unref(lessClick)("inLayer")
                        }
                        ), "-", 8, _uA(
                            "onClick"
                        )),
                        _cE("text", _uM("class" to "item-value"), _tD(unref(ballInlayer)), 1),
                        _cE("button", _uM("size" to "mini", "onClick" to fun(){
                            unref(plusClick)("inLayer")
                        }
                        ), "+", 8, _uA(
                            "onClick"
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
                return _uM("page-body-wrapper" to _pS(_uM("textAlign" to "center")), "page-body" to _pS(_uM("paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15)), "canvas" to _pS(_uM("width" to 300, "height" to 300, "marginTop" to "auto", "marginRight" to "auto", "marginBottom" to "auto", "marginLeft" to "auto", "backgroundColor" to "#ffffff")), "fps" to _pS(_uM("marginTop" to 30, "marginBottom" to 20)), "item" to _pS(_uM("flexDirection" to "row", "alignItems" to "center", "marginTop" to 10)), "item-label" to _pS(_uM("marginRight" to "auto")), "item-value" to _pS(_uM("color" to "#6495ED", "width" to 50, "textAlign" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
