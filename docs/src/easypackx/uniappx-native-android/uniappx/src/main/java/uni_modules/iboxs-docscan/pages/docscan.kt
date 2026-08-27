@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNI2971F61
import android.content.Context
import io.dcloud.uniapp.*
import io.dcloud.uniapp.extapi.*
import io.dcloud.uniapp.framework.*
import io.dcloud.uniapp.runtime.*
import io.dcloud.uniapp.vue.*
import io.dcloud.uniapp.vue.shared.*
import io.dcloud.uts.*
import io.dcloud.uts.Map
import io.dcloud.uts.Set
import io.dcloud.uts.UTSAndroid
import kotlin.properties.Delegates
import uts.sdk.modules.iboxsChooseMedia.MediaScanner
import io.dcloud.uniapp.extapi.`$emit` as uni__emit
import io.dcloud.uniapp.extapi.createCameraContext as uni_createCameraContext
import io.dcloud.uniapp.extapi.createCanvasContextAsync as uni_createCanvasContextAsync
import io.dcloud.uniapp.extapi.getDeviceInfo as uni_getDeviceInfo
import uts.sdk.modules.iboxsDocscan.getDocCorner
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
open class GenUniModulesIboxsDocscanPagesDocscan : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            xProvitae.scrollTop = e.scrollTop
            val pages = getCurrentPages()
            if (pages.length == 0) {
                return
            }
            val page = pages[pages.length - 1].route
            uni__emit("onPageScroll", _uO("top" to e.scrollTop, "page" to page))
        }
        , __ins)
        onResize(fun(_: OnResizeOptions) {
            uni__emit("onResize", fun() {})
        }
        , __ins)
        onLoad(fun(query: OnLoadOptions) {
            xProvitae.onLoadOpts = JSON.parseObject(JSON.stringify(query)!!) ?: _uO()
            uni__emit("onLoad", fun() {})
        }
        , __ins)
        onPageHide(fun() {
            uni__emit("onHide", fun() {})
        }
        , __ins)
        onReady(fun() {
            uni__emit("onReady", fun() {})
            xProvitae.pageReady = true
        }
        , __ins)
        onPageShow(fun() {
            uni__emit("onShow", fun() {})
        }
        , __ins)
    }
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesIboxsDocscanPagesDocscan) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesIboxsDocscanPagesDocscan
            val _cache = __ins.renderCache
            val camera = ref<CameraContext?>(null)
            val pageHeight = uni_getWindowInfo().screenHeight
            val cameraStop = fun(e: UniCameraStopEvent){
                console.log("摄像头停止", e)
            }
            val cameraError = fun(e: UniCameraErrorEvent){
                console.log("摄像头错误", e)
            }
            val ctx = ref<CanvasContext?>(null)
            var canvasWidth = uni_getWindowInfo().screenWidth
            var canvasHeight = pageHeight
            val canvasEl = ref<CanvasRenderingContext2D?>(null)
            val instance = getCurrentInstance()!!.proxy
            var number: Number = 0
            fun gen_initCanvas_fn() {
                console.log("初始化canvas")
                uni_createCanvasContextAsync(CreateCanvasContextAsyncOptions(id = "canvas", component = instance!!, success = fun(res: CanvasContext){
                    console.log("canvas上下文", res)
                    val canvasContext = res.getContext("2d")!!
                    val canvas = canvasContext.canvas
                    val dpr = uni_getDeviceInfo(null).devicePixelRatio ?: 1
                    canvas.width = canvas.offsetWidth * dpr
                    canvas.height = canvas.offsetHeight * dpr
                    canvasContext.scale(dpr, dpr)
                    canvasEl.value = canvasContext
                    console.log("canvasContext", canvasContext)
                }
                , fail = fun(err){
                    console.error("Canvas 初始化失败:", err)
                }
                ))
            }
            val initCanvas = ::gen_initCanvas_fn
            fun gen_drawPolygon_fn(points: UTSArray<Point>) {
                if (canvasEl.value == null) {
                    console.error("请先初始化 Canvas")
                    return
                }
                if (points.length < 3) {
                    console.error("至少需要3个顶点")
                    return
                }
                canvasEl.value?.clearRect(0, 0, canvasWidth, canvasHeight)
                canvasEl.value?.beginPath()
                canvasEl.value?.moveTo(points[0].x, points[0].y)
                run {
                    var i: Number = 1
                    while(i < points.length){
                        canvasEl.value?.lineTo(points[i].x, points[i].y)
                        i++
                    }
                }
                canvasEl.value?.closePath()
                canvasEl.value!!.strokeStyle = "#000000"
                canvasEl.value!!.lineWidth = 2
                canvasEl.value!!.stroke()
            }
            val drawPolygon = ::gen_drawPolygon_fn
            onReady(fun(){
                initCanvas()
            }
            )
            val camveLisen = ref<CameraContextCameraFrameListener?>(null)
            onHide(fun(){
                camveLisen.value?.stop(CameraContextCameraFrameListenerStopOptions(success = fun(_result) {
                    console.log("摄像头帧监听停止")
                }
                ))
            }
            )
            val CamereaInit = fun(e: UniCameraInitDoneEvent){
                console.log("摄像头初始化完成", e)
                camera.value = uni_createCameraContext()
                val lisener = camera.value?.onCameraFrame(fun(photo: CameraContextOnCameraFrame) {
                    number++
                    if (number % 5 != 0) {
                        return
                    }
                    number = 0
                    var arr = getDocCorner(photo.data as ArrayBuffer, photo.height as Number, photo.width as Number)
                    var ponts: UTSArray<Point> = _uA()
                    run {
                        var i: Number = 0
                        while(i < arr.length){
                            ponts.push(Point(x = arr[i] as Number, y = arr[i + 1] as Number))
                            i = i + 2
                        }
                    }
                    drawPolygon(ponts)
                }
                )
                camveLisen.value = lisener
                lisener?.start(CameraContextCameraFrameListenerStartOptions(success = fun(_result) {
                    console.log("摄像头帧监听开始")
                }
                ))
            }
            return fun(): Any? {
                val _component_camera = resolveComponent("camera")
                return _cE("view", _uM("class" to "camera", "style" to _nS(_uM("height" to (unref(pageHeight) + "px")))), _uA(
                    _cV(_component_camera, _uM("id" to "camera", "style" to _nS(_uM("width" to "100%", "height" to "100%")), "device-position" to "back", "mode" to "normal", "resolution" to "high", "frame-size" to "small", "photo-resolution" to "high", "onStop" to cameraStop, "onError" to cameraError, "onInitdone" to CamereaInit), null, 8, _uA(
                        "style"
                    )),
                    _cE("canvas", _uM("id" to "canvas", "class" to "canvas", "style" to _nS(_uM("width" to (unref(canvasWidth) + "px"), "height" to (unref(canvasHeight) + "px")))), null, 4)
                ), 4)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("camera" to _pS(_uM("width" to "100%")), "draw-view" to _pS(_uM("width" to 200, "height" to 200, "backgroundColor" to "#eeeeee", "position" to "fixed")), "canvas" to _pS(_uM("position" to "fixed", "left" to 0, "top" to 0, "width" to "100%", "zIndex" to 999)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
