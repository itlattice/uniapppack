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
import io.dcloud.uniapp.extapi.createCameraContext as uni_createCameraContext
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
open class GenPagesComponentCameraCamera : BasePage {
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
        var setup: (__props: GenPagesComponentCameraCamera) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentCameraCamera
            val _cache = __ins.renderCache
            val devicePosition = ref("back")
            val flash = ref("off")
            val frameSize = ref("medium")
            var listener: CameraContextCameraFrameListener? = null
            val maxZoom = ref(0)
            val imageSrc = ref("")
            var quality = "normal"
            val timeout = ref(30)
            var compressed = false
            val videoSrc = ref("")
            val startRecordStatus = ref(false)
            val remain = ref(0)
            var intervalId: Number = -1
            var timeoutStr = "30"
            val handleScanCode = fun(){
                uni_navigateTo(NavigateToOptions(url = "/pages/component/camera/camera-scan-code"))
            }
            val switchDevicePosition = fun(){
                devicePosition.value = if (devicePosition.value == "back") {
                    "front"
                } else {
                    "back"
                }
            }
            val switchFlash = fun(){
                flash.value = if (flash.value == "torch") {
                    "off"
                } else {
                    "torch"
                }
            }
            val handleStop = fun(e: UniCameraStopEvent){
                console.log("stop", e.detail)
            }
            val handleError = fun(e: UniCameraErrorEvent){
                console.log("error", e.detail)
            }
            val handleInitDone = fun(e: UniCameraInitDoneEvent){
                console.log("initdone", e.detail)
                maxZoom.value = e.detail.maxZoom ?: 0
            }
            val zoomSliderChange = fun(event: UniSliderChangeEvent){
                val value = event.detail.value
                val context = uni_createCameraContext()
                context?.setZoom(CameraContextSetZoomOptions(zoom = value, success = fun(e: Any){
                    console.log(e)
                }
                ))
            }
            val handleTakePhoto = fun(){
                val context = uni_createCameraContext()
                context?.takePhoto(CameraContextTakePhotoOptions(quality = quality, selfieMirror = false, success = fun(res: CameraContextTakePhotoResult){
                    console.log("res.tempImagePath", res.tempImagePath)
                    imageSrc.value = res.tempImagePath ?: ""
                }
                , fail = fun(e: Any){
                    console.log("take photo", e)
                }
                ))
            }
            val takePhotoQualityChange = fun(event: UniRadioGroupChangeEvent){
                quality = event.detail.value
                console.log("quality", quality)
            }
            val setOnFrameListener = fun(){
                val context = uni_createCameraContext()
                listener = context?.onCameraFrame(fun(frame: CameraContextOnCameraFrame){
                    console.log("OnFrame :", frame)
                }
                )
            }
            val startFrameListener = fun(){
                listener?.start(CameraContextCameraFrameListenerStartOptions(success = fun(res: Any){
                    console.log("startFrameListener success", res)
                }
                ))
            }
            val stopFrameListener = fun(){
                listener?.stop(CameraContextCameraFrameListenerStopOptions(success = fun(res: Any){
                    console.log("stopFrameListener success", res)
                }
                ))
            }
            val getTimeout = fun(): Number {
                var value = parseInt(timeoutStr)
                if (UTSNumber.isNaN(value)) {
                    return 30
                } else {
                    if (value < 1) {
                        return 1
                    } else if (value > 300) {
                        return 300
                    } else {
                        return value
                    }
                }
            }
            val startRecord = fun(){
                val context = uni_createCameraContext()
                var timeoutValue = getTimeout()
                timeout.value = timeoutValue
                context?.startRecord(CameraContextStartRecordOptions(timeout = timeoutValue, selfieMirror = false, timeoutCallback = fun(res: Any){
                    console.log("timeoutCallback", res)
                    startRecordStatus.value = false
                    if (UTSAndroid.`typeof`(res) != "string") {
                        val result = res as CameraContextStartRecordTimeoutResult
                        videoSrc.value = result.tempVideoPath ?: ""
                    }
                    clearInterval(intervalId)
                }
                , success = fun(res: Any){
                    startRecordStatus.value = true
                    console.log("start record success", res)
                    remain.value = timeoutValue
                    intervalId = setInterval(fun(){
                        if (remain.value <= 0) {
                            clearInterval(intervalId)
                        } else {
                            remain.value--
                        }
                    }
                    , 1000)
                }
                , fail = fun(res: Any){
                    console.log("start record fail", res)
                    startRecordStatus.value = false
                    remain.value = 0
                    clearInterval(intervalId)
                }
                ))
            }
            val stopRecord = fun(){
                startRecordStatus.value = false
                val context = uni_createCameraContext()
                context?.stopRecord(CameraContextStopRecordOptions(compressed = compressed, success = fun(res: CameraContextStopRecordResult){
                    console.log("stop record success", res)
                    videoSrc.value = res.tempVideoPath ?: ""
                }
                , fail = fun(res: Any){
                    console.log("stop record fail", res)
                }
                ))
                clearInterval(intervalId)
                remain.value = 0
            }
            val startRecordCompressChange = fun(event: UniRadioGroupChangeEvent){
                compressed = parseInt(event.detail.value) == 1
            }
            val timeoutInput = fun(event: UniInputEvent){
                timeoutStr = event.detail.value
            }
            return fun(): Any? {
                val _component_camera = resolveComponent("camera")
                val _component_slider = resolveComponent("slider")
                val _component_radio = resolveComponent("radio")
                val _component_radio_group = resolveComponent("radio-group")
                return _cE("view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cV(_component_camera, _uM("style" to _nS(_uM("width" to "100%", "height" to "300px")), "resolution" to "medium", "device-position" to unref(devicePosition), "photo-resolution" to "high", "flash" to unref(flash), "frame-size" to unref(frameSize), "onStop" to handleStop, "onError" to handleError, "onInitdone" to handleInitDone), null, 8, _uA(
                        "style",
                        "device-position",
                        "flash",
                        "frame-size"
                    )),
                    _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                        _cE("view", null, _uA(
                            _cE("button", _uM("type" to "default", "onClick" to handleScanCode), "扫码"),
                            _cE("button", _uM("type" to "default", "onClick" to switchDevicePosition), "切换前后摄像头"),
                            _cE("button", _uM("type" to "default", "onClick" to switchFlash), "闪光灯"),
                            _cE("button", _uM("type" to "default", "onClick" to setOnFrameListener), "设置帧数据监听"),
                            _cE("button", _uM("type" to "default", "onClick" to startFrameListener), "开始捕捉帧数据"),
                            _cE("button", _uM("type" to "default", "onClick" to stopFrameListener), "停止捕捉帧数据"),
                            _cE("view", null, _uA(
                                _cE("view", _uM("class" to "uni-title"), _uA(
                                    _cE("text", _uM("class" to "uni-title-text"), "设置预览缩放")
                                )),
                                _cE("view", _uM("class" to "uni-camera-wrapper"), _uA(
                                    _cV(_component_slider, _uM("class" to "uni-camera-test-host", "disabled" to (unref(maxZoom) == 0), "show-value" to true, "min" to 1, "max" to unref(maxZoom), "value" to 1, "onChange" to zoomSliderChange), null, 8, _uA(
                                        "disabled",
                                        "max"
                                    ))
                                ))
                            )),
                            _cE("view", null, _uA(
                                _cE("view", _uM("class" to "uni-title"), _uA(
                                    _cE("text", _uM("class" to "uni-title-text"), "拍摄照片示例"),
                                    _cE("button", _uM("type" to "default", "onClick" to handleTakePhoto), "拍摄照片"),
                                    _cV(_component_radio_group, _uM("style" to _nS(_uM("flex-direction" to "row")), "name" to "成像质量", "onChange" to takePhotoQualityChange), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_radio, _uM("value" to "normal", "checked" to true), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    "普通质量"
                                                )
                                            }
                                            ), "_" to 1)),
                                            _cV(_component_radio, _uM("value" to "low"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    "低质量"
                                                )
                                            }
                                            ), "_" to 1)),
                                            _cV(_component_radio, _uM("value" to "high"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    "高质量"
                                                )
                                            }
                                            ), "_" to 1)),
                                            _cV(_component_radio, _uM("value" to "original"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    "原图"
                                                )
                                            }
                                            ), "_" to 1))
                                        )
                                    }
                                    ), "_" to 1), 8, _uA(
                                        "style"
                                    ))
                                )),
                                _cE("view", _uM("class" to "uni-camera-wrapper"), _uA(
                                    if (unref(imageSrc) != "") {
                                        _cE("image", _uM("key" to 0, "class" to "uni-camera-test-host-without-flex", "style" to _nS(_uM("width" to "150px", "height" to "150px")), "src" to unref(imageSrc)), null, 12, _uA(
                                            "src"
                                        ))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                ))
                            )),
                            _cE("view", null, _uA(
                                _cE("view", _uM("class" to "uni-title"), _uA(
                                    _cE("text", _uM("class" to "uni-title-text"), "录制视频示例"),
                                    _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row", "margin-top" to "8px"))), _uA(
                                        _cE("text", _uM("class" to "uni-title-size"), "录制时长："),
                                        _cE("input", _uM("class" to "uni-title-size", "style" to _nS(_uM("width" to "50px", "margin-left" to "10px", "border" to "0.5px solid grey", "text-align" to "right")), "type" to "number", "onInput" to timeoutInput, "value" to unref(timeout)), null, 44, _uA(
                                            "value"
                                        )),
                                        _cE("text", _uM("class" to "uni-title-size", "style" to _nS(_uM("margin-left" to "8px"))), "秒", 4)
                                    ), 4),
                                    _cE("button", _uM("type" to "default", "style" to _nS(_uM("font-family" to "monospace", "margin-top" to "8px")), "onClick" to startRecord, "disabled" to unref(startRecordStatus)), _tD(if (unref(startRecordStatus)) {
                                        "" + unref(remain) + "秒"
                                    } else {
                                        "录制视频"
                                    }
                                    ), 13, _uA(
                                        "disabled"
                                    )),
                                    _cE("button", _uM("type" to "default", "onClick" to stopRecord), "停止录制"),
                                    _cV(_component_radio_group, _uM("style" to _nS(_uM("flex-direction" to "row", "margin-top" to "8px")), "name" to "是否压缩", "onChange" to startRecordCompressChange), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_radio, _uM("value" to "0", "checked" to true), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    "未启动视频压缩"
                                                )
                                            }
                                            ), "_" to 1)),
                                            _cV(_component_radio, _uM("value" to "1"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    "启动视频压缩"
                                                )
                                            }
                                            ), "_" to 1))
                                        )
                                    }
                                    ), "_" to 1), 8, _uA(
                                        "style"
                                    ))
                                )),
                                _cE("view", _uM("class" to "uni-camera-wrapper"), _uA(
                                    if (unref(videoSrc) != "") {
                                        _cE("video", _uM("key" to 0, "class" to "uni-camera-test-host-without-flex", "style" to _nS(_uM("width" to "300px", "height" to "300px")), "src" to unref(videoSrc), "controls" to true), null, 12, _uA(
                                            "src"
                                        ))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                ))
                            ))
                        ))
                    ), 4)
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
                return _uM("uni-title" to _pS(_uM("paddingTop" to 10, "paddingRight" to 0, "paddingBottom" to 10, "paddingLeft" to 0)), "uni-title-text" to _pS(_uM("fontSize" to 15, "fontWeight" to "bold")), "uni-camera-wrapper" to _pS(_uM("display" to "flex", "paddingTop" to 8, "paddingRight" to 13, "paddingBottom" to 8, "paddingLeft" to 13, "marginTop" to 5, "marginRight" to 0, "marginBottom" to 5, "marginLeft" to 0, "flexDirection" to "row", "flexWrap" to "nowrap", "backgroundColor" to "#ffffff")), "uni-camera-test-host" to _pS(_uM("height" to 28, "paddingTop" to 0, "paddingRight" to 0, "paddingBottom" to 0, "paddingLeft" to 0, "flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "backgroundColor" to "#ffffff")), "uni-camera-test-host-without-flex" to _pS(_uM("height" to 28, "paddingTop" to 0, "paddingRight" to 0, "paddingBottom" to 0, "paddingLeft" to 0, "backgroundColor" to "#ffffff")), "uni-title-size" to _pS(_uM("fontSize" to 22)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
