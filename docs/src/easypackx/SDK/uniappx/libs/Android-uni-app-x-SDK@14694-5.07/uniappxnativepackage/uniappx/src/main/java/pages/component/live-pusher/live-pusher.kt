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
import io.dcloud.uniapp.extapi.createLivePusherContext as uni_createLivePusherContext
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesComponentLivePusherLivePusher : BasePage {
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
        var setup: (__props: GenPagesComponentLivePusherLivePusher) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentLivePusherLivePusher
            val _cache = __ins.renderCache
            val context = ref(null as LivePusherContext?)
            val instance = ref(null as ComponentPublicInstance?)
            val url = ref("rtmp://test")
            val beauty = ref(0)
            val whiteness = ref(0)
            val remoteMirror = ref(false)
            val localMirror = ref("auto")
            val devicePosition = ref("front")
            val mode = ref("SD")
            val autoFocus = ref(true)
            val muted = ref(false)
            val orientation = ref("orientation")
            val enableCamera = ref(true)
            val enableMic = ref(true)
            val audioQuality = ref("high")
            val minBitrate = ref(200)
            val maxBitrate = ref(1000)
            val audioVolumeType = ref("media")
            val aspect = ref("3:4")
            val backgroundMute = ref(false)
            val waitingImage = ref("")
            val zoom = ref(1)
            val videoWidth = ref(0)
            val videoHeight = ref(0)
            val fps = ref(0)
            val isPermissionGranted = ref(false)
            val isUrlSet = ref(true)
            val initState = ref(true)
            val connectedState = ref(false)
            val stopState = ref(false)
            val previewState = ref(true)
            onReady(fun(){
                instance.value = getCurrentInstance()?.proxy
                val permissions = _uA(
                    "android.permission.CAMERA",
                    "android.permission.RECORD_AUDIO"
                )
                UTSAndroid.requestSystemPermission(UTSAndroid.getUniActivity()!!, permissions, fun(allRight: Boolean, grantedList: UTSArray<String>){
                    if (allRight) {
                        isPermissionGranted.value = true
                    }
                }
                , fun(doNotAskAgain: Boolean, grantedList: UTSArray<String>){})
            }
            )
            val statechange = fun(e: UniLivePusherStatechangeEvent){
                console.log("statechange", e)
                when (e.detail.code) {
                    1002 -> 
                        {
                            initState.value = false
                            connectedState.value = true
                            stopState.value = false
                        }
                    3004 -> 
                        connectedState.value = false
                }
            }
            val netstatus = fun(e: UniLivePusherNetstatusEvent){
                console.log("netstatus", e)
            }
            val error = fun(e: UniLivePusherErrorEvent){
                console.log("error", e)
            }
            val isUrlValid = fun(): Boolean {
                val valid = url.value != "rtmp://test"
                if (!valid) {
                    uni_showToast(ShowToastOptions(title = "请输入推流地址", icon = "none"))
                }
                return valid
            }
            val start = fun(){
                if (!isUrlValid()) {
                    return
                }
                if (context.value == null) {
                    context.value = uni_createLivePusherContext("live-pusher", instance.value)
                }
                context.value?.start(LivePusherOptions(success = fun(res){
                    console.log("start", JSON.stringify(res))
                }
                , fail = fun(err){
                    console.log("start", JSON.stringify(err))
                }
                , complete = fun(res){
                    console.log("start", JSON.stringify(res))
                }
                ))
            }
            val pause = fun(){
                if (!isUrlValid()) {
                    return
                }
                if (context.value == null) {
                    context.value = uni_createLivePusherContext("live-pusher", instance.value)
                }
                context.value?.pause(LivePusherOptions(success = fun(res){
                    console.log("pause", JSON.stringify(res))
                }
                , fail = fun(err){
                    console.log("pause", JSON.stringify(err))
                }
                , complete = fun(res){
                    console.log("pause", JSON.stringify(res))
                }
                ))
            }
            val resume = fun(){
                if (!isUrlValid()) {
                    return
                }
                if (context.value == null) {
                    context.value = uni_createLivePusherContext("live-pusher", instance.value)
                }
                context.value?.resume(LivePusherOptions(success = fun(res){
                    console.log("resume", JSON.stringify(res))
                }
                , fail = fun(err){
                    console.log("resume", JSON.stringify(err))
                }
                , complete = fun(res){
                    console.log("resume", JSON.stringify(res))
                }
                ))
            }
            val stop = fun(){
                if (!isUrlValid()) {
                    return
                }
                stopState.value = true
                if (context.value == null) {
                    context.value = uni_createLivePusherContext("live-pusher", instance.value)
                }
                context.value?.stop(LivePusherOptions(success = fun(res){
                    console.log("stop", JSON.stringify(res))
                }
                , fail = fun(err){
                    console.log("stop", JSON.stringify(err))
                }
                , complete = fun(res){
                    console.log("stop", JSON.stringify(res))
                }
                ))
            }
            val switchCamera = fun(){
                if (context.value == null) {
                    context.value = uni_createLivePusherContext("live-pusher", instance.value)
                }
                context.value?.switchCamera(LivePusherOptions(success = fun(res){
                    console.log("switchCamera", JSON.stringify(res))
                }
                , fail = fun(err){
                    console.log("switchCamera", JSON.stringify(err))
                }
                , complete = fun(res){
                    console.log("switchCamera", JSON.stringify(res))
                }
                ))
            }
            val snapshot = fun(){
                if (context.value == null) {
                    context.value = uni_createLivePusherContext("live-pusher", instance.value)
                }
                context.value?.snapshot(LivePusherOptions(success = fun(res){
                    console.log("snapshot", JSON.stringify(res))
                }
                , fail = fun(err){
                    console.log("snapshot", JSON.stringify(err))
                }
                , complete = fun(res){
                    console.log("snapshot", JSON.stringify(res))
                }
                ))
            }
            val startPreview = fun(){
                if (context.value == null) {
                    context.value = uni_createLivePusherContext("live-pusher", instance.value)
                }
                previewState.value = true
                context.value?.startPreview(LivePusherOptions(success = fun(res){
                    console.log("startPreview", JSON.stringify(res))
                }
                , fail = fun(err){
                    console.log("startPreview", JSON.stringify(err))
                }
                , complete = fun(res){
                    console.log("startPreview", JSON.stringify(res))
                }
                ))
            }
            val stopPreview = fun(){
                if (context.value == null) {
                    context.value = uni_createLivePusherContext("live-pusher", instance.value)
                }
                previewState.value = false
                context.value?.stopPreview(LivePusherOptions(success = fun(res){
                    console.log("stopPreview", JSON.stringify(res))
                }
                , fail = fun(err){
                    console.log("stopPreview", JSON.stringify(err))
                }
                , complete = fun(res){
                    console.log("stopPreview", JSON.stringify(res))
                }
                ))
            }
            val localMirrorItemTypes = _uA<ItemType>(ItemType(value = 0, name = "auto(前置摄像头镜像，后置摄像头不镜像)"), ItemType(value = 1, name = "enable(前后置摄像头均镜像)"), ItemType(value = 2, name = "disable(前后置摄像头均不镜像)"))
            val localMirrorItems = _uA(
                "auto",
                "enable",
                "disable"
            )
            val modeItemTypes = _uA<ItemType>(ItemType(value = 0, name = "SD(标清)"), ItemType(value = 1, name = "HD(高清)"), ItemType(value = 2, name = "FHD(超清)"))
            val modeItems = _uA(
                "SD",
                "HD",
                "FHD"
            )
            val orientationItemTypes = _uA<ItemType>(ItemType(value = 0, name = "vertical"), ItemType(value = 1, name = "horizontal"))
            val orientationItems = _uA(
                "vertical",
                "horizontal"
            )
            val aspectItemTypes = _uA<ItemType>(ItemType(value = 0, name = "3:4"), ItemType(value = 1, name = "9:16"))
            val aspectItems = _uA(
                "3:4",
                "9:16"
            )
            val audioQualityItemTypes = _uA<ItemType>(ItemType(value = 0, name = "high(高音质(48KHz))"), ItemType(value = 1, name = "low(低音质(16KHz))"))
            val audioQualityItems = _uA(
                "high",
                "low"
            )
            val devicePositionItemTypes = _uA<ItemType>(ItemType(value = 0, name = "front"), ItemType(value = 1, name = "back"))
            val devicePositionItems = _uA(
                "front",
                "back"
            )
            val onUrlComfirm = fun(event: UniInputConfirmEvent){
                var value = event.detail.value
                if (value == "") {
                    return
                }
                context.value = null
                isUrlSet.value = false
                setTimeout(fun(){
                    url.value = value
                    isUrlSet.value = true
                }
                , 200)
                console.log("url ->", value)
            }
            val onMinBitrateComfirm = fun(event: UniInputConfirmEvent){
                var value = event.detail.value
                if (value == "") {
                    return
                }
                minBitrate.value = parseInt(value)
                console.log("min-bitrate ->", value)
            }
            val onMaxBitrateComfirm = fun(event: UniInputConfirmEvent){
                var value = event.detail.value
                if (value == "") {
                    return
                }
                maxBitrate.value = parseInt(value)
                console.log("max-bitrate ->", value)
            }
            val onWaitingImageComfirm = fun(event: UniInputConfirmEvent){
                var value = event.detail.value
                if (value == "") {
                    return
                }
                waitingImage.value = value
                console.log("waiting-image ->", value)
            }
            val onZoomComfirm = fun(event: UniInputConfirmEvent){
                var value = event.detail.value
                if (value == "") {
                    return
                }
                zoom.value = parseInt(value)
                console.log("zoom ->", value)
            }
            val onBeautyChange = fun(event: UniSliderChangeEvent){
                beauty.value = event.detail.value
                console.log("beauty ->", beauty.value)
            }
            val onWhitenessChange = fun(event: UniSliderChangeEvent){
                whiteness.value = event.detail.value
                console.log("whiteness ->", whiteness.value)
            }
            val onMutedChange = fun(value: Boolean){
                muted.value = value
                console.log("muted ->", muted.value)
            }
            val onBackgroundMuteChange = fun(value: Boolean){
                backgroundMute.value = value
                console.log("background-mute ->", backgroundMute.value)
            }
            val onAutoFocusChange = fun(value: Boolean){
                autoFocus.value = value
                console.log("auto-focus ->", backgroundMute.value)
            }
            val onRemoteMirrorChange = fun(value: Boolean){
                remoteMirror.value = value
                console.log("remote-mirror ->", remoteMirror.value)
            }
            val onLocalMirrorChange = fun(value: Number){
                localMirror.value = localMirrorItems[value]
                console.log("local-mirror ->", localMirrorItems[value])
            }
            val onDevicePositionChange = fun(value: Number){
                devicePosition.value = devicePositionItems[value]
                console.log("device-position ->", devicePosition.value)
            }
            val onModeChange = fun(value: Number){
                mode.value = modeItems[value]
                console.log("mode ->", modeItems[value])
            }
            val onAspectChange = fun(value: Number){
                aspect.value = aspectItems[value]
                console.log("aspect ->", aspectItems[value])
            }
            val onOrientationChange = fun(value: Number){
                orientation.value = orientationItems[value]
                console.log("orientation ->", orientation.value)
            }
            val onAudioQualityChange = fun(value: Number){
                audioQuality.value = audioQualityItems[value]
                console.log("audio-quality ->", audioQuality.value)
            }
            return fun(): Any? {
                val _component_live_pusher = resolveComponent("live-pusher")
                val _component_slider = resolveComponent("slider")
                val _component_boolean_data = resolveEasyComponent("boolean-data", GenComponentsBooleanDataBooleanDataClass)
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                return _cE("view", _uM("class" to "uni-flex-item"), _uA(
                    if (isTrue(unref(isPermissionGranted) && unref(isUrlSet))) {
                        _cV(_component_live_pusher, _uM("key" to 0, "id" to "live-pusher", "class" to "live-pusher", "url" to unref(url), "beauty" to unref(beauty), "whiteness" to unref(whiteness), "remote-mirror" to unref(remoteMirror), "local-mirror" to unref(localMirror), "device-position" to unref(devicePosition), "mode" to unref(mode), "auto-focus" to unref(autoFocus), "muted" to unref(muted), "orientation" to unref(orientation), "enable-camera" to unref(enableCamera), "enable-mic" to unref(enableMic), "audio-quality" to unref(audioQuality), "min-bitrate" to unref(minBitrate), "max-bitrate" to unref(maxBitrate), "audio-volume-type" to unref(audioVolumeType), "aspect" to unref(aspect), "background-mute" to unref(backgroundMute), "waiting-image" to unref(waitingImage), "zoom" to unref(zoom), "onStatechange" to statechange, "onNetstatus" to netstatus, "onError" to error), null, 8, _uA(
                            "url",
                            "beauty",
                            "whiteness",
                            "remote-mirror",
                            "local-mirror",
                            "device-position",
                            "mode",
                            "auto-focus",
                            "muted",
                            "orientation",
                            "enable-camera",
                            "enable-mic",
                            "audio-quality",
                            "min-bitrate",
                            "max-bitrate",
                            "audio-volume-type",
                            "aspect",
                            "background-mute",
                            "waiting-image",
                            "zoom"
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    _cE("scroll-view", _uM("class" to "uni-padding-wrap uni-common-mt uni-flex-item"), _uA(
                        _cE("view", _uM("class" to "uni-title"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "API示例")
                        )),
                        _cE("view", _uM("class" to "uni-btn-v"), _uA(
                            _cE("button", _uM("type" to "primary", "onClick" to start, "disabled" to (unref(connectedState) || !unref(previewState))), "开始推流", 8, _uA(
                                "disabled"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-btn-v"), _uA(
                            _cE("button", _uM("type" to "primary", "onClick" to pause, "disabled" to (!unref(connectedState) || !unref(previewState))), "暂停推流", 8, _uA(
                                "disabled"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-btn-v"), _uA(
                            _cE("button", _uM("type" to "primary", "onClick" to resume, "disabled" to (unref(initState) || unref(connectedState) || unref(stopState) || !unref(previewState))), "恢复推流", 8, _uA(
                                "disabled"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-btn-v"), _uA(
                            _cE("button", _uM("type" to "primary", "onClick" to stop, "disabled" to (!unref(connectedState) || !unref(previewState))), "停止推流", 8, _uA(
                                "disabled"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-btn-v"), _uA(
                            _cE("button", _uM("type" to "primary", "onClick" to switchCamera, "disabled" to (unref(stopState) || !unref(previewState))), "切换前后摄像头", 8, _uA(
                                "disabled"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-btn-v"), _uA(
                            _cE("button", _uM("type" to "primary", "onClick" to snapshot, "disabled" to (unref(stopState) || !unref(previewState))), "快照", 8, _uA(
                                "disabled"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-btn-v"), _uA(
                            _cE("button", _uM("type" to "primary", "onClick" to startPreview, "disabled" to (unref(stopState) || unref(previewState))), "开启摄像头预览", 8, _uA(
                                "disabled"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-btn-v"), _uA(
                            _cE("button", _uM("type" to "primary", "onClick" to stopPreview, "disabled" to (unref(stopState) || !unref(previewState))), "关闭摄像头预览", 8, _uA(
                                "disabled"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-title"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "属性示例")
                        )),
                        _cE("input", _uM("class" to "input margin-10", "type" to "string", "placeholder" to "设置推流地址", "onConfirm" to onUrlComfirm), null, 32),
                        _cE("input", _uM("class" to "input margin-10", "type" to "string", "placeholder" to "设置最小码率", "onConfirm" to onMinBitrateComfirm), null, 32),
                        _cE("input", _uM("class" to "input margin-10", "type" to "string", "placeholder" to "设置最大码率", "onConfirm" to onMaxBitrateComfirm), null, 32),
                        _cE("input", _uM("class" to "input margin-10", "type" to "string", "placeholder" to "设置进入后台时推流的等待画面", "onConfirm" to onWaitingImageComfirm), null, 32),
                        _cE("input", _uM("class" to "input margin-10", "type" to "string", "placeholder" to "设置焦距", "onConfirm" to onZoomComfirm), null, 32),
                        _cE("view", _uM("class" to "margin-10"), _uA(
                            _cE("text", null, "美颜, 取值范围0-9(iOS取值范围为1), 0表示关闭"),
                            _cV(_component_slider, _uM("min" to 0, "max" to 9, "onChange" to onBeautyChange))
                        )),
                        _cE("view", _uM("class" to "margin-10"), _uA(
                            _cE("text", null, "美白, 取值范围0-9(iOS取值范围为1), 0表示关闭"),
                            _cV(_component_slider, _uM("min" to 0, "max" to 9, "onChange" to onWhitenessChange))
                        )),
                        _cV(_component_boolean_data, _uM("title" to "设置是否静音", "defaultValue" to unref(muted), "onChange" to onMutedChange), null, 8, _uA(
                            "defaultValue"
                        )),
                        _cV(_component_boolean_data, _uM("title" to "设置是否自动聚焦", "defaultValue" to unref(autoFocus), "onChange" to onAutoFocusChange), null, 8, _uA(
                            "defaultValue"
                        )),
                        _cV(_component_boolean_data, _uM("title" to "设置进入后台时是否静音", "defaultValue" to unref(backgroundMute), "onChange" to onBackgroundMuteChange), null, 8, _uA(
                            "defaultValue"
                        )),
                        _cV(_component_boolean_data, _uM("title" to "设置推流画面是否镜像", "defaultValue" to unref(remoteMirror), "onChange" to onRemoteMirrorChange), null, 8, _uA(
                            "defaultValue"
                        )),
                        _cV(_component_enum_data, _uM("title" to "设置本地预览画面是否镜像", "items" to localMirrorItemTypes, "onChange" to onLocalMirrorChange)),
                        _cV(_component_enum_data, _uM("title" to "设置使用前置或后置摄像头", "items" to devicePositionItemTypes, "onChange" to onDevicePositionChange)),
                        _cV(_component_enum_data, _uM("title" to "设置推流视频模式", "items" to modeItemTypes, "onChange" to onModeChange)),
                        _cV(_component_enum_data, _uM("title" to "设置视频宽高比例", "items" to aspectItemTypes, "onChange" to onAspectChange)),
                        _cV(_component_enum_data, _uM("title" to "设置画面方向", "items" to orientationItemTypes, "onChange" to onOrientationChange)),
                        _cV(_component_enum_data, _uM("title" to "设置音质", "items" to audioQualityItemTypes, "onChange" to onAudioQualityChange))
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
                return _uM("live-pusher" to _pS(_uM("width" to "100%", "height" to "50%")), "input" to _pS(_uM("height" to 40, "backgroundImage" to "none", "backgroundColor" to "#FFFFFF", "paddingTop" to 8, "paddingRight" to 13, "paddingBottom" to 8, "paddingLeft" to 13)), "margin-10" to _pS(_uM("marginTop" to 10, "marginRight" to 10, "marginBottom" to 10, "marginLeft" to 10)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
