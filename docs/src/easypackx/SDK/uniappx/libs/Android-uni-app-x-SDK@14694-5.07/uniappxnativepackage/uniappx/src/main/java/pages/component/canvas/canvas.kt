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
import io.dcloud.uniapp.extapi.`$off` as uni__off
import io.dcloud.uniapp.extapi.`$on` as uni__on
import io.dcloud.uniapp.extapi.createCanvasContextAsync as uni_createCanvasContextAsync
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
open class GenPagesComponentCanvasCanvas : BasePage {
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
    open var data: DataType__48
        get() {
            return unref(this.`$exposed`["data"]) as DataType__48
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var canvasToDataURL: () -> Unit
        get() {
            return unref(this.`$exposed`["canvasToDataURL"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "canvasToDataURL", value)
        }
    open var onCreateImage: () -> Unit
        get() {
            return unref(this.`$exposed`["onCreateImage"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "onCreateImage", value)
        }
    open var onCreatePath2D: () -> Unit
        get() {
            return unref(this.`$exposed`["onCreatePath2D"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "onCreatePath2D", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentCanvasCanvas, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentCanvasCanvas
            val _cache = __ins.renderCache
            val instance = getCurrentInstance()!!.proxy
            val data = reactive(DataType__48(title = "Context2D", canvas = null, canvasContext = null, renderingContext = null, canvasWidth = 0, canvasHeight = 0, dataBase64 = "", taskId = 0, lastTime = 0, frameCount = 0, testCanvasContext = false, testToBlobResult = false, testToDataURLResult = false, testCreateImage = false, testCreatePath2D = false, testFrameCount = 0, testCanvasCtx1 = false, testCanvasCtx2 = false, testCounter = 0))
            val canvasChildRef = ref<ComponentPublicInstance?>(null)
            val testCanvasCtx = computed(fun(): Boolean {
                return data.testCanvasCtx1 && data.testCanvasCtx2
            }
            )
            fun gen_hidpi_fn(canvas: UniCanvasElement) {
                val context = canvas.getContext("2d")!!
                val dpr = uni_getWindowInfo().pixelRatio
                canvas.width = canvas.offsetWidth * dpr
                canvas.height = canvas.offsetHeight * dpr
                context.scale(dpr, dpr)
            }
            val hidpi = ::gen_hidpi_fn
            val canvasToDataURL = fun(){
                data.dataBase64 = data.canvasContext!!.toDataURL()
            }
            val onCreateImage = fun(){
                data.renderingContext!!.clearRect(0, 0, data.canvasWidth, data.canvasHeight)
                var image = data.canvasContext!!.createImage()
                image.src = "/static/test-image/logo.png"
                image.onload = fun(){
                    data.testCreateImage = true
                    data.renderingContext?.drawImage(image, 0, 0, 100, 100)
                }
            }
            val onCreatePath2D = fun(){
                data.renderingContext!!.clearRect(0, 0, data.canvasWidth, data.canvasHeight)
                val context = data.renderingContext!!
                var path2D = data.canvasContext!!.createPath2D()
                data.testCreatePath2D = true
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
            }
            val updateFPS = fun(timestamp: Number){
                data.frameCount++
                if (timestamp - data.lastTime >= 1000) {
                    val timeOfFrame = ((1000 as Number) / data.frameCount)
                    data.renderingContext!!.clearRect(0, 0, data.canvasWidth, data.canvasHeight)
                    data.renderingContext!!.fillText("" + data.frameCount + " / " + timeOfFrame.toFixed(3) + "ms", 10, 18)
                    data.frameCount = 0
                    data.lastTime = timestamp
                }
            }
            var startAnimationFrame: StartAnimationFrameType = fun(){}
            startAnimationFrame = fun(){
                data.taskId = data.canvasContext!!.requestAnimationFrame(fun(timestamp: Number){
                    data.testFrameCount++
                    updateFPS(timestamp)
                    startAnimationFrame()
                }
                )
            }
            val stopAnimationFrame = fun(){
                data.canvasContext!!.cancelAnimationFrame(data.taskId)
                data.taskId = 0
            }
            val testCreateContextAsync = fun(){
                uni_createCanvasContextAsync(CreateCanvasContextAsyncOptions(id = "canvas", component = instance!!, success = fun(_){
                    data.testCanvasCtx1 = true
                }
                ))
                uni_createCanvasContextAsync(CreateCanvasContextAsyncOptions(id = "canvas", success = fun(_){
                    data.testCanvasCtx2 = true
                }
                ))
            }
            val onChildReady = fun(count: Number){
                data.testCounter = count
            }
            onReady(fun(){
                uni_createCanvasContextAsync(CreateCanvasContextAsyncOptions(id = "canvas", component = instance!!, success = fun(context: CanvasContext){
                    data.canvasContext = context
                    data.renderingContext = context.getContext("2d")!!
                    data.canvas = data.renderingContext!!.canvas
                    hidpi(data.canvas!!)
                    data.canvasWidth = data.canvas!!.width
                    data.canvasHeight = data.canvas!!.height
                    setTimeout(fun(){
                        data.testToDataURLResult = data.canvasContext!!.toDataURL().startsWith("data:image/png;base64")
                    }
                    , 50)
                    data.testCanvasContext = true
                }
                ))
            }
            )
            onReady(fun(){})
            onLoad(fun(_options){
                uni__on("canvasChildReady", onChildReady)
            }
            )
            onUnload(fun(){
                uni__off("canvasChildReady", onChildReady)
                if (data.taskId > 0) {
                    stopAnimationFrame()
                }
            }
            )
            __expose(_uM("data" to data, "canvasToDataURL" to canvasToDataURL, "onCreateImage" to onCreateImage, "onCreatePath2D" to onCreatePath2D))
            return fun(): Any? {
                val _component_page_intro = resolveEasyComponent("page-intro", GenComponentsPageIntroPageIntroClass)
                val _component_navigator = resolveComponent("navigator")
                return _cE("view", _uM("class" to "page", "id" to "page-canvas"), _uA(
                    _cV(_component_page_intro, _uM("content" to "本页演示 canvas 画布组件：toDataURL、createImage、createPath2D、requestAnimationFrame 等；可跳转 CanvasContext API 子页，展示绘图与异步上下文。")),
                    _cE("canvas", _uM("id" to "canvas", "class" to "canvas-element")),
                    _cE("scroll-view", _uM("class" to "scroll-view"), _uA(
                        _cE("button", _uM("class" to "canvas-drawing-button", "id" to "toDataURL", "onClick" to canvasToDataURL), "canvasToDataURL"),
                        if (unref(data).dataBase64.length > 0) {
                            _cE("view", _uM("key" to 0, "class" to "text-group"), _uA(
                                _cE("text", null, "canvasToDataURL:"),
                                _cE("text", null, _tD(unref(data).dataBase64.slice(0, 22)) + "...", 1)
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        _cE("button", _uM("onClick" to onCreateImage), "createImage"),
                        _cE("button", _uM("onClick" to onCreatePath2D), "createPath2D"),
                        _cE("button", _uM("onClick" to unref(startAnimationFrame)), "requestAnimationFrame", 8, _uA(
                            "onClick"
                        )),
                        _cE("button", _uM("onClick" to stopAnimationFrame), "cancelAnimationFrame"),
                        _cE("view", _uM("style" to _nS(_uM("padding" to "8px 10px"))), "CanvasContext API 演示", 4),
                        _cV(_component_navigator, _uM("url" to "./canvas-context"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("button", null, "CanvasContext API")
                            )
                        }
                        ), "_" to 1)),
                        _cE("view", _uM("class" to "text-group"), _uA(
                            _cE("text", null, "获取 CanvasContext 结果："),
                            _cE("text", _uM("id" to "testCanvasContext"), _tD(unref(data).testCanvasContext), 1)
                        )),
                        _cE("view", _uM("class" to "text-group"), _uA(
                            _cE("text", null, "测试 ToDataURL 结果："),
                            _cE("text", _uM("id" to "testToDataURLResult"), _tD(unref(data).testToDataURLResult), 1)
                        )),
                        _cE("view", _uM("class" to "text-group"), _uA(
                            _cE("text", null, "测试 createImage 结果："),
                            _cE("text", _uM("id" to "testCreateImage"), _tD(unref(data).testCreateImage), 1)
                        )),
                        _cE("view", _uM("class" to "text-group"), _uA(
                            _cE("text", null, "测试 createPath2D 结果："),
                            _cE("text", _uM("id" to "testCreatePath2D"), _tD(unref(data).testCreatePath2D), 1)
                        )),
                        _cE("view", _uM("class" to "text-group"), _uA(
                            _cE("text", null, "测试 createCanvasContextAsync 结果："),
                            _cE("view", _uM("onClick" to testCreateContextAsync, "id" to "createCanvasContextAsync"), _tD(unref(testCanvasCtx)), 1)
                        )),
                        _cV(unref(GenPagesComponentCanvasCanvasChildClass), _uM("ref_key" to "canvasChildRef", "ref" to canvasChildRef), null, 512)
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
                return _uM("page" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "height" to "100%", "overflow" to "hidden")), "scroll-view" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "canvas-element" to _pS(_uM("width" to "100%", "height" to 250, "backgroundColor" to "#ffffff")), "btn-to-image" to _pS(_uM("marginTop" to 10, "marginRight" to 10, "marginBottom" to 10, "marginLeft" to 10)), "text-group" to _pS(_uM("display" to "flex", "flexDirection" to "row", "flexWrap" to "nowrap", "justifyContent" to "space-between", "alignItems" to "center", "paddingTop" to 8, "paddingRight" to 10, "paddingBottom" to 8, "paddingLeft" to 10)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
