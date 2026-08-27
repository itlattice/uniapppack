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
import io.dcloud.uniapp.extapi.loadFontFace as uni_loadFontFace
open class GenPagesComponentCanvasCanvasContext : BasePage {
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
    open var measureText: () -> Unit
        get() {
            return unref(this.`$exposed`["measureText"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "measureText", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentCanvasCanvasContext, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentCanvasCanvasContext
            val _cache = __ins.renderCache
            fun gen_hidpi_fn(canvas: UniCanvasElement) {
                val context = canvas.getContext("2d")!!
                val dpr = uni_getWindowInfo().pixelRatio
                canvas.width = canvas.offsetWidth * dpr
                canvas.height = canvas.offsetHeight * dpr
                context.scale(dpr, dpr)
            }
            val hidpi = ::gen_hidpi_fn
            val API_PATH = _uA(
                "arc",
                "arcTo",
                "bezierCurveTo",
                "quadraticCurve",
                "moveTo",
                "lineTo",
                "rect",
                "clip",
                "createPattern",
                "getSetImageData"
            )
            val API_DRAW = _uA(
                "stroke",
                "strokeRect",
                "strokeText",
                "fill",
                "fillRect",
                "fillText",
                "drawImage",
                "drawImageLocal",
                "clearRect"
            )
            val API_STATE = _uA(
                "beginPath",
                "closePath",
                "reset",
                "transform",
                "rotate",
                "resetTransform",
                "save",
                "restore",
                "scale",
                "translate",
                "fontTTF"
            )
            val API_PROPERTIES = _uA(
                "lineCap",
                "lineJoin",
                "lineWidth",
                "miterLimit",
                "fillStyle",
                "strokeStyle",
                "globalAlpha",
                "font",
                "setLineDash",
                "createLinearGradient",
                "createRadialGradient",
                "textAlign"
            )
            var canvas: UniCanvasElement? = null
            var canvasContext: CanvasContext? = null
            var renderingContext: CanvasRenderingContext2D? = null
            var canvasWidth: Number = 0
            var canvasHeight: Number = 0
            var fontLoaded = false
            val names = ref(API_PATH.concat(API_DRAW, API_STATE, API_PROPERTIES, _uA(
                "measureText",
                "path2D"
            )).sort() as UTSArray<String>)
            val instance = getCurrentInstance()!!.proxy!!
            onReady(fun(){
                uni_createCanvasContextAsync(CreateCanvasContextAsyncOptions(id = "canvas", component = instance, success = fun(context: CanvasContext){
                    canvasContext = context
                    renderingContext = context.getContext("2d")!!
                    canvas = renderingContext!!.canvas
                    hidpi(canvas!!)
                    canvasWidth = canvas!!.width
                    canvasHeight = canvas!!.height
                }
                ))
            }
            )
            fun gen_arc_fn() {
                val context = renderingContext!!
                context.beginPath()
                context.lineWidth = 2
                context.arc(75, 75, 50, 0, Math.PI * 2, true)
                context.moveTo(110, 75)
                context.arc(75, 75, 35, 0, Math.PI, false)
                context.moveTo(65, 65)
                context.arc(60, 65, 5, 0, Math.PI * 2, true)
                context.moveTo(95, 65)
                context.arc(90, 65, 5, 0, Math.PI * 2, true)
                context.stroke()
            }
            val arc = ::gen_arc_fn
            fun gen_arcTo_fn() {
                val context = renderingContext!!
                context.beginPath()
                context.moveTo(150, 20)
                context.arcTo(150, 100, 50, 20, 30)
                context.stroke()
                context.fillStyle = "blue"
                context.fillRect(150, 20, 10, 10)
                context.fillStyle = "red"
                context.fillRect(150, 100, 10, 10)
                context.fillRect(50, 20, 10, 10)
                context.setLineDash(_uA(
                    5,
                    5
                ))
                context.moveTo(150, 20)
                context.lineTo(150, 100)
                context.lineTo(50, 20)
                context.stroke()
                context.beginPath()
                context.arc(120, 38, 30, 0, 2 * Math.PI, true)
                context.stroke()
            }
            val arcTo = ::gen_arcTo_fn
            fun gen_beginPath_fn() {
                val context = renderingContext!!
                context.beginPath()
                context.strokeStyle = "blue"
                context.moveTo(20, 20)
                context.lineTo(200, 20)
                context.stroke()
                context.beginPath()
                context.strokeStyle = "green"
                context.moveTo(20, 20)
                context.lineTo(120, 120)
                context.stroke()
            }
            val beginPath = ::gen_beginPath_fn
            fun gen_textAlign_fn() {
                val context = renderingContext!!
                context.beginPath()
                context.moveTo(150, 0)
                context.lineTo(150, 150)
                context.stroke()
                context.font = "30px serif"
                context.textAlign = "left"
                context.fillText("left-aligned", 150, 40)
                context.textAlign = "center"
                context.fillText("center-aligned", 150, 85)
                context.textAlign = "right"
                context.fillText("right-aligned", 150, 130)
            }
            val textAlign = ::gen_textAlign_fn
            fun gen_getSetImageData_fn() {
                val context = renderingContext!!
                context.moveTo(0, 70)
                context.lineTo(80, 0)
                context.lineTo(210, 110)
                context.lineTo(30, 110)
                context.lineTo(160, 0)
                context.lineTo(240, 70)
                context.closePath()
                context.fillStyle = "green"
                context.fill()
                var imageData = context.getImageData(0, 0, context.canvas.width / 2, context.canvas.height / 2)
                context.putImageData(imageData, context.canvas.width / 2, context.canvas.height / 2)
            }
            val getSetImageData = ::gen_getSetImageData_fn
            fun gen_bezierCurveTo_fn() {
                val context = renderingContext!!
                context.beginPath()
                context.moveTo(50, 20)
                context.bezierCurveTo(230, 30, 150, 60, 50, 100)
                context.stroke()
                context.fillStyle = "blue"
                context.fillRect(50, 20, 10, 10)
                context.fillRect(50, 100, 10, 10)
                context.fillStyle = "red"
                context.fillRect(230, 30, 10, 10)
                context.fillRect(150, 70, 10, 10)
            }
            val bezierCurveTo = ::gen_bezierCurveTo_fn
            fun gen_clearRect_fn() {
                val context = renderingContext!!
                context.beginPath()
                context.fillStyle = "#ff6"
                context.fillRect(0, 0, 300, 150)
                context.beginPath()
                context.fillStyle = "blue"
                context.moveTo(20, 20)
                context.lineTo(180, 20)
                context.lineTo(130, 130)
                context.closePath()
                context.fill()
                context.clearRect(10, 10, 120, 100)
            }
            val clearRect = ::gen_clearRect_fn
            fun gen_clip_fn() {
                val context = renderingContext!!
                context.beginPath()
                context.arc(100, 75, 50, 0, Math.PI * 2, true)
                context.clip()
                context.fillStyle = "blue"
                context.fillRect(0, 0, 300, 150)
                context.fillStyle = "orange"
                context.fillRect(0, 0, 100, 100)
            }
            val clip = ::gen_clip_fn
            fun gen_closePath_fn() {
                val context = renderingContext!!
                context.beginPath()
                context.lineWidth = 10
                context.moveTo(20, 20)
                context.lineTo(20, 100)
                context.lineTo(70, 100)
                context.closePath()
                context.stroke()
            }
            val closePath = ::gen_closePath_fn
            fun gen_clearCanvasRect_fn() {
                renderingContext!!.clearRect(0, 0, canvasWidth, canvasHeight)
            }
            val clearCanvasRect = ::gen_clearCanvasRect_fn
            fun gen_pattern_fn() {
                val context = renderingContext!!
                val image = canvasContext!!.createImage()
                image.src = "/static/api.png"
                image.onload = fun(){
                    context.save()
                    clearCanvasRect()
                    val pattern = context.createPattern(image, "repeat")
                    if (pattern != null) {
                        context.fillStyle = pattern
                    }
                    context.fillRect(0, 0, 400, 400)
                    context.restore()
                }
            }
            val pattern = ::gen_pattern_fn
            fun gen_createLinearGradient_fn() {
                val context = renderingContext!!
                val gradient = context.createLinearGradient(20, 0, 220, 0)
                gradient.addColorStop(0, "green")
                gradient.addColorStop(0.5, "cyan")
                gradient.addColorStop(1, "green")
                context.fillStyle = gradient
                context.fillRect(20, 20, 200, 100)
            }
            val createLinearGradient = ::gen_createLinearGradient_fn
            fun gen_createRadialGradient_fn() {
                val context = renderingContext!!
                val gradient = context.createRadialGradient(110, 90, 30, 100, 100, 70)
                gradient.addColorStop(0, "pink")
                gradient.addColorStop(0.9, "white")
                gradient.addColorStop(1, "green")
                context.fillStyle = gradient
                context.fillRect(20, 20, 160, 160)
            }
            val createRadialGradient = ::gen_createRadialGradient_fn
            fun gen_fill_fn() {
                val context = renderingContext!!
                context.beginPath()
                context.rect(20, 20, 150, 100)
                context.strokeStyle = "#00ff00"
                context.fill()
            }
            val fill = ::gen_fill_fn
            fun gen_fillRect_fn() {
                val context = renderingContext!!
                context.fillStyle = "green"
                context.fillRect(20, 10, 150, 100)
            }
            val fillRect = ::gen_fillRect_fn
            fun gen_fillText_fn() {
                val context = renderingContext!!
                context.strokeStyle = "#ff0000"
                context.beginPath()
                context.moveTo(0, 10)
                context.lineTo(300, 10)
                context.stroke()
                context.fillText("Hello World", 0, 30, 300)
                context.fillText("Hello World", 100, 30, 300)
                context.beginPath()
                context.moveTo(0, 30)
                context.lineTo(300, 30)
                context.stroke()
            }
            val fillText = ::gen_fillText_fn
            fun gen_moveTo_fn() {
                val context = renderingContext!!
                context.beginPath()
                context.moveTo(0, 0)
                context.lineTo(300, 150)
                context.stroke()
            }
            val moveTo = ::gen_moveTo_fn
            fun gen_lineTo_fn() {
                val context = renderingContext!!
                context.beginPath()
                context.moveTo(20, 20)
                context.lineTo(20, 100)
                context.lineTo(70, 100)
                context.stroke()
            }
            val lineTo = ::gen_lineTo_fn
            fun gen_stroke_fn() {
                val context = renderingContext!!
                context.beginPath()
                context.moveTo(20, 20)
                context.lineTo(20, 100)
                context.lineTo(70, 100)
                context.strokeStyle = "#00ff00"
                context.stroke()
            }
            val stroke = ::gen_stroke_fn
            fun gen_strokeRect_fn() {
                val context = renderingContext!!
                context.strokeStyle = "green"
                context.strokeRect(20, 10, 160, 100)
            }
            val strokeRect = ::gen_strokeRect_fn
            fun gen_strokeText_fn() {
                val context = renderingContext!!
                context.font = "10px serif"
                context.strokeText("Hello world", 50, 90)
                context.font = "30px serif"
                context.strokeStyle = "blue"
                context.strokeText("Hello world", 50, 100)
            }
            val strokeText = ::gen_strokeText_fn
            fun gen_rotate_fn() {
                val context = renderingContext!!
                context.arc(0, 0, 5, 0, 2 * Math.PI, true)
                context.fillStyle = "blue"
                context.fill()
                context.fillStyle = "gray"
                context.fillRect(100, 0, 80, 20)
                context.rotate((45 * Math.PI) / 180)
                context.fillStyle = "red"
                context.fillRect(100, 0, 80, 20)
                context.setTransform(1, 0, 0, 1, 0, 0)
            }
            val rotate = ::gen_rotate_fn
            fun gen_scale_fn() {
                val context = renderingContext!!
                context.scale(9, 3)
                context.fillStyle = "red"
                context.fillRect(10, 10, 8, 20)
                context.setTransform(1, 0, 0, 1, 0, 0)
                context.fillStyle = "gray"
                context.fillRect(10, 10, 8, 20)
            }
            val scale = ::gen_scale_fn
            fun gen_reset_fn() {
                val context = renderingContext!!
                context.lineWidth = 10
                context.strokeStyle = "#00ff00"
                context.strokeRect(50, 50, 150, 100)
                context.font = "50px serif"
                context.fillText("Rect!", 70, 110)
                context.lineWidth = 5
                context.beginPath()
                context.arc(300, 100, 50, 0, 2 * Math.PI)
                context.stroke()
                context.font = "25px sans-serif"
                context.fillText("Circle!", 265, 100)
                hidpi(canvas!!)
            }
            val reset = ::gen_reset_fn
            fun gen_translate_fn() {
                val context = renderingContext!!
                context.translate(110, 30)
                context.fillStyle = "red"
                context.fillRect(0, 0, 80, 80)
                context.setTransform(1, 0, 0, 1, 0, 0)
                context.fillStyle = "gray"
                context.fillRect(0, 0, 80, 80)
            }
            val translate = ::gen_translate_fn
            fun gen_save_fn() {
                val context = renderingContext!!
                context.beginPath()
                context.strokeStyle = "#00ff00"
                context.scale(2, 2)
                context.strokeStyle = "#ff0000"
                context.rect(0, 0, 100, 100)
                context.stroke()
                context.restore()
                context.save()
                context.rect(0, 0, 50, 50)
                context.stroke()
            }
            val save = ::gen_save_fn
            fun gen_restore_fn() {
                val context = renderingContext!!
                _uA(
                    3,
                    2,
                    1
                ).forEach(fun(item){
                    context.save()
                    context.beginPath()
                    context.scale(item, item)
                    context.rect(10, 10, 100, 100)
                    context.stroke()
                    context.restore()
                }
                )
            }
            val restore = ::gen_restore_fn
            fun gen_drawImageLocal_fn() {
                val context = renderingContext!!
                val image = canvasContext!!.createImage()
                image.src = "/static/test-image/logo.png"
                image.onload = fun(){
                    context.drawImage(image, 0, 0, 100, 100)
                }
            }
            val drawImageLocal = ::gen_drawImageLocal_fn
            fun gen_drawImage_fn() {
                val context = renderingContext!!
                val image = canvasContext!!.createImage()
                image.src = "https://web-ext-storage.dcloud.net.cn/uni-app-x/hello-uniappx-qrcode.png"
                image.onload = fun(){
                    context.drawImage(image, 0, 0, 100, 100)
                }
            }
            val drawImage = ::gen_drawImage_fn
            fun gen_rect_fn() {
                val context = renderingContext!!
                context.beginPath()
                context.rect(20, 20, 150, 100)
                context.stroke()
            }
            val rect = ::gen_rect_fn
            fun gen_quadraticCurveTo_fn() {
                val context = renderingContext!!
                context.beginPath()
                context.moveTo(50, 20)
                context.quadraticCurveTo(230, 30, 50, 100)
                context.stroke()
                context.fillStyle = "blue"
                context.beginPath()
                context.arc(50, 20, 5, 0, 2 * Math.PI, true)
                context.arc(50, 100, 5, 0, 2 * Math.PI, true)
                context.fill()
                context.fillStyle = "red"
                context.beginPath()
                context.arc(230, 30, 5, 0, 2 * Math.PI, true)
                context.fill()
            }
            val quadraticCurveTo = ::gen_quadraticCurveTo_fn
            fun gen_resetTransform_fn() {
                val context = renderingContext!!
                context.rotate((45 * Math.PI) / 180)
                context.fillRect(60, 0, 100, 30)
                context.resetTransform()
                context.fillStyle = "red"
                context.fillRect(60, 0, 100, 30)
            }
            val resetTransform = ::gen_resetTransform_fn
            fun gen_transform_fn() {
                val context = renderingContext!!
                context.transform(1, 0.2, 0.8, 1, 0, 0)
                context.fillRect(0, 0, 100, 100)
            }
            val transform = ::gen_transform_fn
            fun gen_setFillStyle_fn() {
                val context = renderingContext!!
                _uA(
                    "#fef957",
                    "rgb(242,159,63)",
                    "rgb(242,117,63)",
                    "#e87e51"
                ).forEach(fun(item: String, index: Number){
                    context.fillStyle = item
                    context.beginPath()
                    context.rect(0 + 75 * index, 0, 50, 50)
                    context.fill()
                }
                )
            }
            val setFillStyle = ::gen_setFillStyle_fn
            fun gen_setStrokeStyle_fn() {
                val context = renderingContext!!
                _uA(
                    "#fef957",
                    "rgb(242,159,63)",
                    "rgb(242,117,63)",
                    "#e87e51"
                ).forEach(fun(item: String, index: Number){
                    context.strokeStyle = item
                    context.beginPath()
                    context.rect(0 + 75 * index, 0, 50, 50)
                    context.stroke()
                }
                )
            }
            val setStrokeStyle = ::gen_setStrokeStyle_fn
            fun gen_setGlobalAlpha_fn() {
                val context = renderingContext!!
                context.fillStyle = "#000000"
                _uA(
                    1,
                    0.5,
                    0.1
                ).forEach(fun(item: Number, index: Number){
                    context.globalAlpha = item
                    context.beginPath()
                    context.rect(0 + 75 * index, 0, 50, 50)
                    context.fill()
                }
                )
                context.globalAlpha = 1
            }
            val setGlobalAlpha = ::gen_setGlobalAlpha_fn
            fun gen_setFontSize_fn() {
                val context = renderingContext!!
                _uA(
                    10,
                    20,
                    30,
                    40
                ).forEach(fun(item: Number, index: Number){
                    context.font = item + "px serif"
                    context.fillText("Hello, world", 20, 20 + 40 * index)
                }
                )
            }
            val setFontSize = ::gen_setFontSize_fn
            fun gen_setLineCap_fn() {
                val context = renderingContext!!
                context.lineWidth = 10
                _uA(
                    "butt",
                    "round",
                    "square"
                ).forEach(fun(item: String, index: Number){
                    context.beginPath()
                    context.lineCap = item as String
                    context.moveTo(20, 20 + 20 * index)
                    context.lineTo(100, 20 + 20 * index)
                    context.stroke()
                }
                )
            }
            val setLineCap = ::gen_setLineCap_fn
            fun gen_setLineJoin_fn() {
                val context = renderingContext!!
                context.lineWidth = 10
                _uA(
                    "bevel",
                    "round",
                    "miter"
                ).forEach(fun(item: String, index: Number){
                    context.beginPath()
                    context.lineJoin = item as String
                    context.moveTo(20 + 80 * index, 20)
                    context.lineTo(100 + 80 * index, 50)
                    context.lineTo(20 + 80 * index, 100)
                    context.stroke()
                }
                )
            }
            val setLineJoin = ::gen_setLineJoin_fn
            fun gen_setLineWidth_fn() {
                val context = renderingContext!!
                _uA(
                    2,
                    4,
                    6,
                    8,
                    10
                ).forEach(fun(item: Number, index: Number){
                    context.beginPath()
                    context.lineWidth = item
                    context.moveTo(20, 20 + 20 * index)
                    context.lineTo(100, 20 + 20 * index)
                    context.stroke()
                }
                )
            }
            val setLineWidth = ::gen_setLineWidth_fn
            fun gen_lineDash_fn() {
                val context = renderingContext!!
                context.setLineDash(_uA(
                    4,
                    16
                ))
                context.beginPath()
                context.moveTo(0, 50)
                context.lineTo(300, 50)
                context.stroke()
                context.beginPath()
                context.strokeStyle = "red"
                context.lineDashOffset = 4
                context.moveTo(0, 100)
                context.lineTo(300, 100)
                context.stroke()
            }
            val lineDash = ::gen_lineDash_fn
            fun gen_setMiterLimit_fn() {
                val context = renderingContext!!
                context.lineWidth = 4
                _uA(
                    2,
                    4,
                    6,
                    8,
                    10
                ).forEach(fun(item: Number, index: Number){
                    context.beginPath()
                    context.miterLimit = item
                    context.moveTo(20 + 80 * index, 20)
                    context.lineTo(100 + 80 * index, 50)
                    context.lineTo(20 + 80 * index, 100)
                    context.stroke()
                }
                )
            }
            val setMiterLimit = ::gen_setMiterLimit_fn
            fun gen_measureText_fn() {
                val context = renderingContext!!
                val text = "uni-app x，是下一代 uni-app，是一个跨平台应用开发引擎"
                context.font = "20px 宋体"
                context.fillStyle = "red"
                context.fillText(text, 0, 60)
                val textMetrics = context.measureText(text)
                context.strokeText(text, 40, 100)
                context.fillText("measure text width:" + textMetrics.width, 40, 80)
                val text2 = "Hello word Hello word!!!!!"
                context.font = "22px 宋体"
                context.fillStyle = "#00bc79"
                context.fillText(text2, 0, 130)
                val textMetrics2 = context.measureText(text2)
                context.fillRect(0, 140, textMetrics2.width, 14)
            }
            val measureText = ::gen_measureText_fn
            fun gen_path2DMethods_fn() {
                val context = renderingContext!!
                context.beginPath()
                val path2D = canvasContext!!.createPath2D()
                val amplitude: Number = 64
                val wavelength: Number = 64
                run {
                    var i: Number = 0
                    while(i < 5){
                        val x1 = 0 + (i * wavelength)
                        val y1: Number = 128
                        val x2 = x1 + wavelength / 4
                        val y2 = y1 - amplitude
                        val x3 = x1 + 3 * wavelength / 4
                        val y3 = y1 + amplitude
                        val x4 = x1 + wavelength
                        val y4 = y1
                        context.moveTo(x1, y1)
                        path2D.bezierCurveTo(x2, y2, x3, y3, x4, y4)
                        i++
                    }
                }
                context.stroke(path2D)
                val path2DRect = canvasContext!!.createPath2D()
                path2DRect.rect(10, 10, 100, 20)
                context.fill(path2DRect)
            }
            val path2DMethods = ::gen_path2DMethods_fn
            fun gen_fontTTF_fn() {
                val context = renderingContext!!
                val fontMap = Map<String, UTSJSONObject>(_uA(
                    _uA(
                        "AlimamaDaoLiTiOTF",
                        _uO("path" to "/static/font/AlimamaDaoLiTi.otf", "text" to "阿里妈妈刀隶体字体otf加载成功")
                    ),
                    _uA(
                        "person-filled",
                        _uO("path" to "/static/font/uni.ttf", "text" to "\ue69d")
                    )
                ))
                var yOffset: Number = 0
                var drawFont = fun(key: String, value: UTSJSONObject){
                    console.log("" + key + "字体加载成功")
                    context.save()
                    val text = value["text"] as String
                    context.font = "20px " + key
                    context.fillStyle = "red"
                    yOffset += 25
                    context.fillText(text, 0, yOffset)
                    yOffset += 25
                    context.strokeText(text, 0, yOffset)
                    context.restore()
                }
                fontMap.forEach(fun(value: UTSJSONObject, key: String){
                    console.log("key:" + key + " value:" + value["path"])
                    if (fontLoaded) {
                        drawFont(key, value)
                    } else {
                        uni_loadFontFace(LoadFontFaceOptions(family = key, source = "url('" + value["path"] + "')", success = fun(_){
                            drawFont(key, value)
                        }
                        ))
                    }
                }
                )
                fontLoaded = true
            }
            val fontTTF = ::gen_fontTTF_fn
            fun gen_handleCanvasButton_fn(name: String) {
                renderingContext!!.clearRect(0, 0, canvasWidth, canvasHeight)
                renderingContext!!.save()
                when (name) {
                    "arc" -> 
                        arc()
                    "arcTo" -> 
                        arcTo()
                    "beginPath" -> 
                        beginPath()
                    "bezierCurveTo" -> 
                        bezierCurveTo()
                    "clearRect" -> 
                        clearRect()
                    "clip" -> 
                        clip()
                    "closePath" -> 
                        closePath()
                    "getSetImageData" -> 
                        getSetImageData()
                    "createPattern" -> 
                        pattern()
                    "createLinearGradient" -> 
                        createLinearGradient()
                    "createRadialGradient" -> 
                        createRadialGradient()
                    "fill" -> 
                        fill()
                    "fillRect" -> 
                        fillRect()
                    "fillText" -> 
                        fillText()
                    "lineTo" -> 
                        lineTo()
                    "moveTo" -> 
                        moveTo()
                    "quadraticCurve" -> 
                        quadraticCurveTo()
                    "rect" -> 
                        rect()
                    "reset" -> 
                        reset()
                    "resetTransform" -> 
                        resetTransform()
                    "restore" -> 
                        restore()
                    "rotate" -> 
                        rotate()
                    "save" -> 
                        save()
                    "scale" -> 
                        scale()
                    "stroke" -> 
                        stroke()
                    "strokeRect" -> 
                        strokeRect()
                    "strokeText" -> 
                        strokeText()
                    "transform" -> 
                        transform()
                    "translate" -> 
                        translate()
                    "drawImageLocal" -> 
                        drawImageLocal()
                    "drawImage" -> 
                        drawImage()
                    "measureText" -> 
                        measureText()
                    "fillStyle" -> 
                        setFillStyle()
                    "strokeStyle" -> 
                        setStrokeStyle()
                    "globalAlpha" -> 
                        setGlobalAlpha()
                    "font" -> 
                        setFontSize()
                    "lineCap" -> 
                        setLineCap()
                    "lineJoin" -> 
                        setLineJoin()
                    "setLineDash" -> 
                        lineDash()
                    "lineWidth" -> 
                        setLineWidth()
                    "miterLimit" -> 
                        setMiterLimit()
                    "textAlign" -> 
                        textAlign()
                    "path2D" -> 
                        path2DMethods()
                    "fontTTF" -> 
                        fontTTF()
                    else -> 
                        {}
                }
                renderingContext!!.restore()
            }
            val handleCanvasButton = ::gen_handleCanvasButton_fn
            __expose(_uM("measureText" to measureText))
            return fun(): Any? {
                val _component_page_intro = resolveEasyComponent("page-intro", GenComponentsPageIntroPageIntroClass)
                return _cE("view", _uM("class" to "page", "id" to "page-canvas"), _uA(
                    _cV(_component_page_intro, _uM("content" to "本页演示 CanvasContext 2D API：arc、路径、描边填充、drawImage、createPattern、getSetImageData 等绘图与导出能力。")),
                    _cE("canvas", _uM("id" to "canvas", "class" to "canvas-element")),
                    _cE("scroll-view", _uM("class" to "scroll-view"), _uA(
                        _cE("view", _uM("class" to "grid-view"), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(unref(names), fun(name, index, __index, _cached): Any {
                                return _cE("view", _uM("class" to "grid-item", "key" to index), _uA(
                                    _cE("button", _uM("class" to "canvas-drawing-button", "onClick" to fun(){
                                        handleCanvasButton(name)
                                    }
                                    ), _tD(name), 9, _uA(
                                        "onClick"
                                    ))
                                ))
                            }
                            ), 128)
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
                return _uM("page" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "scroll-view" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "canvas-element" to _pS(_uM("width" to "100%", "height" to 250, "backgroundColor" to "#ffffff")), "grid-view" to _pS(_uM("paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "flexDirection" to "row", "flexWrap" to "wrap")), "grid-item" to _pS(_uM("width" to "50%", "paddingTop" to 5, "paddingRight" to 5, "paddingBottom" to 5, "paddingLeft" to 5)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
