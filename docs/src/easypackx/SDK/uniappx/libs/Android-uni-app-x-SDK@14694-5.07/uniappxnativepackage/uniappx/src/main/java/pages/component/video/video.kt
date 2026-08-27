@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNIHelloUniAppX
import android.view.ViewGroup
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
import io.dcloud.uniapp.extapi.closeDialogPage as uni_closeDialogPage
import io.dcloud.uniapp.extapi.createVideoContext as uni_createVideoContext
import io.dcloud.uniapp.extapi.downloadFile as uni_downloadFile
import io.dcloud.uniapp.extapi.getElementById as uni_getElementById
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
import io.dcloud.uniapp.extapi.openDialogPage as uni_openDialogPage
open class GenPagesComponentVideoVideo : BasePage {
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
    open var data: DataType__33
        get() {
            return unref(this.`$exposed`["data"]) as DataType__33
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var play: () -> Unit
        get() {
            return unref(this.`$exposed`["play"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "play", value)
        }
    open var pause: () -> Unit
        get() {
            return unref(this.`$exposed`["pause"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "pause", value)
        }
    open var downloadSource: () -> Unit
        get() {
            return unref(this.`$exposed`["downloadSource"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "downloadSource", value)
        }
    open var seek: (pos: Number) -> Unit
        get() {
            return unref(this.`$exposed`["seek"]) as (pos: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "seek", value)
        }
    open var requestFullScreen: () -> Unit
        get() {
            return unref(this.`$exposed`["requestFullScreen"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "requestFullScreen", value)
        }
    open var exitFullScreen: () -> Unit
        get() {
            return unref(this.`$exposed`["exitFullScreen"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "exitFullScreen", value)
        }
    open var hasSubComponent: () -> Boolean
        get() {
            return unref(this.`$exposed`["hasSubComponent"]) as () -> Boolean
        }
        set(value) {
            setRefValue(this.`$exposed`, "hasSubComponent", value)
        }
    open var requestVerticalFullScreen: () -> Unit
        get() {
            return unref(this.`$exposed`["requestVerticalFullScreen"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "requestVerticalFullScreen", value)
        }
    open var openDialogPageVideo: () -> Unit
        get() {
            return unref(this.`$exposed`["openDialogPageVideo"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "openDialogPageVideo", value)
        }
    open var closeDialogPageVideo: () -> Unit
        get() {
            return unref(this.`$exposed`["closeDialogPageVideo"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "closeDialogPageVideo", value)
        }
    open var getWindowInfo: () -> GetWindowInfoResult
        get() {
            return unref(this.`$exposed`["getWindowInfo"]) as () -> GetWindowInfoResult
        }
        set(value) {
            setRefValue(this.`$exposed`, "getWindowInfo", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentVideoVideo, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentVideoVideo
            val _cache = __ins.renderCache
            val data = reactive(DataType__33(videoContext = null, src = "https://web-ext-storage.dcloud.net.cn/video/sample/2minute-demo.mp4", autoplay = false, loop = false, muted = false, initialTime = 0, duration = 0, controls = true, danmuList = _uA(
                Danmu(text = "要显示的文本", color = "#FF0000", time = 3),
                Danmu(text = "要显示的文本2", color = "#31ff23", time = 5),
                Danmu(text = "要显示的文本3", color = "#f13ef8", time = 7),
                Danmu(text = "要显示的文本4", color = "#4972f8", time = 9),
                Danmu(text = "要显示的文本5", color = "#000000", time = 11)
            ) as UTSArray<Danmu>, danmuBtn = false, enableDanmu = true, pageGesture = false, direction = -1, directionItemTypes = _uA(
                ItemType(value = 0, name = "0(正常竖向)"),
                ItemType(value = 1, name = "90(屏幕逆时针90度)"),
                ItemType(value = 2, name = "-90(屏幕顺时针90度)")
            ), directionItems = _uA(
                0,
                90,
                -90
            ), showProgress = true, showFullscreenBtn = true, showPlayBtn = true, showCenterPlayBtn = true, showLoading = true, enableProgressGesture = true, objectFit = "contain", objectFitItemTypes = _uA(
                ItemType(value = 0, name = "contain(包含)"),
                ItemType(value = 1, name = "fill(填充)"),
                ItemType(value = 2, name = "cover(覆盖)")
            ), objectFitItems = _uA(
                "contain",
                "fill",
                "cover"
            ), poster = "https://qiniu-web-assets.dcloud.net.cn/unidoc/zh/uni-android.png", showMuteBtn = false, title = "video-component", enablePlayGesture = false, vslideGesture = false, vslideGestureInFullscreen = true, codec = "hardware", codecItemTypes = _uA(
                ItemType(value = 0, name = "hardware(硬解码)"),
                ItemType(value = 1, name = "software(软解码)")
            ), codecItems = _uA(
                "hardware",
                "software"
            ), httpCache = true, playStrategy = 0, playStrategyItemTypes = _uA(
                ItemType(value = 0, name = "0(普通模式)"),
                ItemType(value = 1, name = "1(平滑播放模式)"),
                ItemType(value = 2, name = "2(M3U8优化模式)")
            ), playStrategyItems = _uA(
                0,
                1,
                2
            ), header = _uO("User-Agent" to "User-Agent test", "header" to "header test", "cookie" to "cookie test"), pos = 0, requestFullScreenOptions = null, danmu = Danmu(text = "要显示的文本", color = "#FF0000"), rate = 1, rateItemTypes = _uA(
                ItemType(value = 0, name = "0.5"),
                ItemType(value = 1, name = "0.8"),
                ItemType(value = 2, name = "1.0"),
                ItemType(value = 3, name = "1.25"),
                ItemType(value = 4, name = "1.5")
            ), rateItems = _uA(
                0.5,
                0.8,
                1.0,
                1.25,
                1.5
            ), subCompEnable = false, subCompControlsEnable = false, subCompShow = false, subCompControlsShow = false, curPos = 0, endPos = 0, autoTest = false, isPlaying = false, isPause = false, isError = false, eventPlay = null, eventPause = null, eventEnded = null, eventTimeupdate = null, eventFullscreenchange = null, eventWaiting = null, eventError = null, eventProgress = null, eventFullscreenclick = null, eventControlstoggle = null, dialogPageVideo = null))
            onReady(fun(){
                data.videoContext = uni_createVideoContext("video", null)
            }
            )
            val pause = fun(){
                console.log("pause")
                (uni_getElementById("video") as UniVideoElement).pause()
            }
            val openDialogPageVideo = fun(){
                pause()
                data.dialogPageVideo = uni_openDialogPage(OpenDialogPageOptions(url = "/pages/component/video/video-dialog-page"))
            }
            val closeDialogPageVideo = fun(){
                uni_closeDialogPage(CloseDialogPageOptions(dialogPage = data.dialogPageVideo))
            }
            val play = fun(){
                console.log("play")
                data.videoContext?.play()
            }
            val seek = fun(pos: Number){
                console.log("seek -> " + pos)
                data.videoContext?.seek(pos)
            }
            val onSeekInput = fun(event: UniInputEvent){
                data.pos = parseInt(event.detail.value)
            }
            val requestFullScreen = fun(){
                console.log("requestFullScreen -> " + data.requestFullScreenOptions)
                data.videoContext?.requestFullScreen(data.requestFullScreenOptions)
            }
            val exitFullScreen = fun(){
                console.log("exitFullScreen")
                data.videoContext?.exitFullScreen()
            }
            val stop = fun(){
                console.log("stop")
                uni_getElementById<UniVideoElement>("video")?.stop()
            }
            val sendDanmu = fun(){
                console.log("sendDanmu -> " + data.danmu)
                data.videoContext?.sendDanmu(data.danmu)
            }
            val onSendDanmuInput = fun(event: UniInputEvent){
                var json = JSON.parse<Danmu>(event.detail.value)
                if (json == null) {
                    return
                }
                data.danmu = json as Danmu
            }
            val playbackRate = fun(){
                console.log("playbackRate -> " + data.rate)
                data.videoContext?.playbackRate(data.rate)
            }
            val onPlaybackRateChange = fun(value: Number){
                data.rate = data.rateItems[value]
            }
            val fastBackward = fun(){
                var posValue = data.curPos - 15
                if (posValue < 0) {
                    posValue = 0
                }
                seek(posValue)
            }
            val fastForward = fun(){
                var posValue = data.curPos + 15
                if (posValue > data.endPos) {
                    posValue = data.endPos
                }
                seek(posValue)
            }
            val onSendDanmuConfirm = fun(event: UniInputConfirmEvent){
                data.videoContext?.sendDanmu(Danmu(text = event.detail.value, color = "#ff0000"))
            }
            val onSendDanmuKeyboardHeightChange = fun(event: UniInputKeyboardHeightChangeEvent){
                val element = uni_getElementById("input-send-danmu") as UniElement
                if (event.detail.height.toInt() == 0) {
                    element.style.setProperty("bottom", "50px")
                } else {
                    element.style.setProperty("bottom", event.detail.height + element.getBoundingClientRect().height)
                }
            }
            val onSendDanmuBlur = fun(_: UniInputBlurEvent){
                (uni_getElementById("input-send-danmu") as UniElement).style.setProperty("bottom", "50px")
            }
            val onSrcComfirm = fun(event: UniInputConfirmEvent){
                var value = event.detail.value
                if (value == "") {
                    return
                }
                data.src = value
                console.log("src -> " + data.src)
            }
            val onAutoplayChange = fun(value: Boolean){
                data.autoplay = value
                console.log("autoplay -> " + data.autoplay)
            }
            val onLoopChange = fun(value: Boolean){
                data.loop = value
                console.log("loop -> " + data.loop)
            }
            val onMutedChange = fun(value: Boolean){
                data.muted = value
                console.log("muted -> " + data.muted)
            }
            val onInitialTimeComfirm = fun(event: UniInputConfirmEvent){
                var value = parseInt(event.detail.value)
                if (isNaN(value)) {
                    value = 0
                }
                data.initialTime = value
                console.log("initialTime -> " + data.initialTime)
            }
            val onDurationComfirm = fun(event: UniInputConfirmEvent){
                var value = parseInt(event.detail.value)
                if (isNaN(value)) {
                    value = 0
                }
                data.duration = value
                console.log("duration -> " + data.duration)
            }
            val onControlsChange = fun(value: Boolean){
                data.controls = value
                console.log("controls -> " + data.controls)
            }
            val onEnableDanmuChange = fun(value: Boolean){
                data.enableDanmu = value
                console.log("enableDanmu -> " + data.enableDanmu)
            }
            val onDanmuBtnChange = fun(value: Boolean){
                data.danmuBtn = value
                console.log("danmuBtn -> " + data.danmuBtn)
            }
            val onPageGestureChange = fun(value: Boolean){
                data.pageGesture = value
                console.log("pageGesture -> " + data.pageGesture)
            }
            val onRequestFullScreenDirectionChange = fun(value: Number){
                var directionValue = data.directionItems[value]
                data.requestFullScreenOptions = RequestFullScreenOptions(direction = directionValue)
            }
            val onShowProgressChange = fun(value: Boolean){
                data.showProgress = value
                console.log("showProgress -> " + data.showProgress)
            }
            val onShowFullscreenBtnChange = fun(value: Boolean){
                data.showFullscreenBtn = value
                console.log("showFullscreenBtn -> " + data.showFullscreenBtn)
            }
            val onShowPlayBtnChange = fun(value: Boolean){
                data.showPlayBtn = value
                console.log("showPlayBtn -> " + data.showPlayBtn)
            }
            val onShowCenterPlayBtnChange = fun(value: Boolean){
                data.showCenterPlayBtn = value
                console.log("showCenterPlayBtn -> " + data.showCenterPlayBtn)
            }
            val onShowLoadingChange = fun(value: Boolean){
                data.showLoading = value
                console.log("showLoading -> " + data.showLoading)
            }
            val onEnableProgressGestureChange = fun(value: Boolean){
                data.enableProgressGesture = value
                console.log("enableProgressGesture -> " + data.enableProgressGesture)
            }
            val onObjectFitChange = fun(value: Number){
                data.objectFit = data.objectFitItems[value]
                console.log("objectFit -> " + data.objectFit)
            }
            val onPosterComfirm = fun(event: UniInputConfirmEvent){
                var value = event.detail.value
                if (value == "") {
                    return
                }
                data.poster = value
                console.log("poster -> " + data.poster)
            }
            val onShowMuteBtnChange = fun(value: Boolean){
                data.showMuteBtn = value
                console.log("showMuteBtn -> " + data.showMuteBtn)
            }
            val onTitleComfirm = fun(event: UniInputConfirmEvent){
                var value = event.detail.value
                if (value == "") {
                    return
                }
                data.title = value
                console.log("title -> " + data.title)
            }
            val onEnablePlayGestureChange = fun(value: Boolean){
                data.enablePlayGesture = value
                console.log("enablePlayGesture -> " + data.enablePlayGesture)
            }
            val onVslideGestureChange = fun(value: Boolean){
                data.vslideGesture = value
                console.log("vslideGesture -> " + data.vslideGesture)
            }
            val onVslideGestureInFullscreenChange = fun(value: Boolean){
                data.vslideGestureInFullscreen = value
                console.log("vslideGestureInFullscreen -> " + data.vslideGestureInFullscreen)
            }
            val onCodecChange = fun(value: Number){
                data.codec = data.codecItems[value]
                console.log("codec -> " + data.codec)
            }
            val onHttpCacheChange = fun(value: Boolean){
                data.httpCache = value
                console.log("httpCache -> " + data.httpCache)
            }
            val onPlayStrategyChange = fun(value: Number){
                data.playStrategy = data.playStrategyItems[value]
                console.log("playStrategy -> " + data.playStrategy)
            }
            val onHeaderComfirm = fun(event: UniInputConfirmEvent){
                var json = JSON.parse(event.detail.value)
                if (json == null) {
                    return
                }
                data.header = json as UTSJSONObject
                console.log("header -> " + JSON.stringify(data.header))
            }
            val onSubCompEnableChange = fun(event: UniSwitchChangeEvent){
                data.subCompEnable = event.detail.value
            }
            fun gen_onSubCompControlsEnable_fn(event: UniSwitchChangeEvent) {
                data.subCompControlsEnable = event.detail.value
            }
            val onSubCompControlsEnable = ::gen_onSubCompControlsEnable_fn
            val isHorizontalFullscreen = ref(false)
            val fullscreenShowPlayBtn = ref(data.showPlayBtn)
            val fullscreenShowMuteBtn = ref(data.showMuteBtn)
            val fullscreenShowFullscreenBtn = ref(data.showFullscreenBtn)
            val fullscreenShowDanmuBtn = ref(data.danmuBtn)
            watchEffect(fun(){
                data.subCompControlsShow = isHorizontalFullscreen.value && data.subCompControlsEnable
                fullscreenShowPlayBtn.value = !data.subCompControlsShow
                fullscreenShowMuteBtn.value = !data.subCompControlsShow
                fullscreenShowFullscreenBtn.value = !data.subCompControlsShow
                fullscreenShowDanmuBtn.value = !data.subCompControlsShow
            }
            )
            val onPlay = fun(res: UniEvent){
                console.log(res.type)
                data.isPlaying = true
                data.isPause = false
                if (data.autoTest) {
                    data.eventPlay = _uO("tagName" to res.target?.tagName, "type" to res.type)
                }
            }
            val onPause = fun(res: UniEvent){
                console.log(res.type)
                data.isPlaying = false
                data.isPause = true
                if (data.autoTest) {
                    data.eventPause = _uO("tagName" to res.target?.tagName, "type" to res.type)
                }
            }
            val onEnded = fun(res: UniEvent){
                console.log(res.type)
                if (data.autoTest) {
                    data.eventEnded = _uO("tagName" to res.target?.tagName, "type" to res.type)
                }
            }
            val onTimeUpdate = fun(res: UniVideoTimeUpdateEvent){
                console.log(res.type + " -> " + JSON.stringify(res.detail))
                data.curPos = res.detail.currentTime
                data.endPos = res.detail.duration
                if (data.autoTest) {
                    data.eventTimeupdate = _uO("tagName" to res.target?.tagName, "type" to res.type, "currentTime" to Math.trunc(res.detail.currentTime), "duration" to Math.trunc(res.detail.duration))
                }
            }
            val onFullScreenChange = fun(res: UniVideoFullScreenChangeEvent){
                val detail = res.detail
                console.log(res.type + " -> " + JSON.stringify(detail))
                data.subCompShow = detail.fullScreen
                isHorizontalFullscreen.value = detail.fullScreen && detail.direction === "horizontal"
                if (data.autoTest) {
                    data.eventFullscreenchange = _uO("tagName" to res.target?.tagName, "type" to res.type, "fullScreen" to res.detail.fullScreen, "direction" to res.detail.direction)
                }
            }
            val onWaiting = fun(res: UniEvent){
                console.log(res.type)
                if (data.autoTest) {
                    data.eventWaiting = _uO("tagName" to res.target?.tagName, "type" to res.type)
                }
            }
            val onError__1 = fun(res: UniVideoErrorEvent){
                console.log(res.type + " -> " + JSON.stringify(res.detail))
                data.isError = true
                if (data.autoTest) {
                    data.eventError = _uO("tagName" to res.target?.tagName, "type" to res.type, "errCode" to res.detail.errCode)
                }
            }
            val onProgress = fun(res: UniVideoProgressEvent){
                console.log(res.type + " -> " + JSON.stringify(res.detail))
                if (data.autoTest) {
                    data.eventProgress = _uO("tagName" to res.target?.tagName, "type" to res.type, "isBufferedValid" to (res.detail.buffered >= 0))
                }
            }
            val onFullScreenClick = fun(res: UniVideoFullScreenClickEvent){
                console.log(res.type + " -> " + JSON.stringify(res.detail))
                if (data.autoTest) {
                    data.eventFullscreenclick = _uO("tagName" to res.target?.tagName, "type" to res.type, "screenX" to Math.trunc(res.detail.screenX), "screenY" to Math.trunc(res.detail.screenY), "screenWidth" to Math.trunc(res.detail.screenWidth), "screenHeight" to Math.trunc(res.detail.screenHeight))
                }
            }
            val onControlsToggle = fun(res: UniVideoControlsToggleEvent){
                console.log(res.type + " -> " + JSON.stringify(res.detail))
                if (data.autoTest) {
                    data.eventControlstoggle = _uO("tagName" to res.target?.tagName, "type" to res.type, "show" to res.detail.show)
                }
            }
            val downloadSource = fun(){
                uni_downloadFile(DownloadFileOptions(url = "https://qiniu-web-assets.dcloud.net.cn/video/sample/2minute-demo.mp4", success = fun(res){
                    data.src = res.tempFilePath
                }
                , fail = fun(_){
                    data.isError = true
                }
                ))
            }
            val getWindowInfo = fun(): GetWindowInfoResult {
                return uni_getWindowInfo()
            }
            val hasSubComponent = fun(): Boolean {
                val view = uni_getElementById("video")?.getAndroidView<ViewGroup>()
                return if (view == null) {
                    false
                } else {
                    view.getChildAt(0) is ViewGroup
                }
            }
            val requestVerticalFullScreen = fun(){
                data.videoContext?.requestFullScreen(RequestFullScreenOptions(direction = 0))
            }
            __expose(_uM("data" to data, "play" to play, "pause" to pause, "downloadSource" to downloadSource, "seek" to seek, "requestFullScreen" to requestFullScreen, "exitFullScreen" to exitFullScreen, "hasSubComponent" to hasSubComponent, "requestVerticalFullScreen" to requestVerticalFullScreen, "openDialogPageVideo" to openDialogPageVideo, "closeDialogPageVideo" to closeDialogPageVideo, "getWindowInfo" to getWindowInfo))
            return fun(): Any? {
                val _component_navigator = resolveComponent("navigator")
                val _component_switch = resolveComponent("switch")
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_boolean_data = resolveEasyComponent("boolean-data", GenComponentsBooleanDataBooleanDataClass)
                return _cE("view", _uM("class" to "uni-flex-item"), _uA(
                    _cE("video", _uM("class" to "video", "ref" to "video", "id" to "video", "header" to unref(data).header, "src" to unref(data).src, "autoplay" to unref(data).autoplay, "loop" to unref(data).loop, "muted" to unref(data).muted, "initial-time" to unref(data).initialTime, "duration" to unref(data).duration, "controls" to unref(data).controls, "danmu-btn" to (unref(data).danmuBtn && unref(fullscreenShowDanmuBtn)), "enable-danmu" to unref(data).enableDanmu, "page-gesture" to unref(data).pageGesture, "direction" to unref(data).direction, "show-progress" to unref(data).showProgress, "show-fullscreen-btn" to (unref(data).showFullscreenBtn && unref(fullscreenShowFullscreenBtn)), "show-play-btn" to (unref(data).showPlayBtn && unref(fullscreenShowPlayBtn)), "show-center-play-btn" to unref(data).showCenterPlayBtn, "show-loading" to unref(data).showLoading, "enable-progress-gesture" to unref(data).enableProgressGesture, "object-fit" to unref(data).objectFit, "poster" to unref(data).poster, "show-mute-btn" to (unref(data).showMuteBtn && unref(fullscreenShowMuteBtn)), "title" to unref(data).title, "enable-play-gesture" to unref(data).enablePlayGesture, "vslide-gesture" to unref(data).vslideGesture, "vslide-gesture-in-fullscreen" to unref(data).vslideGestureInFullscreen, "codec" to unref(data).codec, "http-cache" to unref(data).httpCache, "play-strategy" to unref(data).playStrategy, "danmu-list" to unref(data).danmuList, "onPlay" to onPlay, "onPause" to onPause, "onEnded" to onEnded, "onTimeupdate" to onTimeUpdate, "onWaiting" to onWaiting, "onError" to onError__1, "onProgress" to onProgress, "onFullscreenclick" to onFullScreenClick, "onControlstoggle" to onControlsToggle, "onFullscreenchange" to onFullScreenChange), _uA(
                        if (isTrue(unref(data).subCompEnable && unref(data).subCompShow)) {
                            _cE("image", _uM("key" to 0, "class" to "img-fast-backward", "src" to default__4, "onClick" to withModifiers(fastBackward, _uA(
                                "stop"
                            ))))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        if (isTrue(unref(data).subCompEnable && unref(data).subCompShow)) {
                            _cE("image", _uM("key" to 1, "class" to "img-fast-forward", "src" to default__5, "onClick" to withModifiers(fastForward, _uA(
                                "stop"
                            ))))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        if (isTrue(unref(data).subCompEnable && unref(data).subCompShow)) {
                            _cE("input", _uM("key" to 2, "id" to "input-send-danmu", "class" to "input-send-danmu", "placeholder" to "请输入弹幕内容", "placeholder-style" to "color: white;", "confirm-type" to "send", "onConfirm" to onSendDanmuConfirm, "onKeyboardheightchange" to onSendDanmuKeyboardHeightChange, "onBlur" to onSendDanmuBlur), null, 32)
                        } else {
                            _cC("v-if", true)
                        }
                    ), 40, _uA(
                        "header",
                        "src",
                        "autoplay",
                        "loop",
                        "muted",
                        "initial-time",
                        "duration",
                        "controls",
                        "danmu-btn",
                        "enable-danmu",
                        "page-gesture",
                        "direction",
                        "show-progress",
                        "show-fullscreen-btn",
                        "show-play-btn",
                        "show-center-play-btn",
                        "show-loading",
                        "enable-progress-gesture",
                        "object-fit",
                        "poster",
                        "show-mute-btn",
                        "title",
                        "enable-play-gesture",
                        "vslide-gesture",
                        "vslide-gesture-in-fullscreen",
                        "codec",
                        "http-cache",
                        "play-strategy",
                        "danmu-list"
                    )),
                    _cE("scroll-view", _uM("class" to "uni-padding-wrap uni-common-mt uni-flex-item"), _uA(
                        _cE("view", _uM("class" to "uni-btn-v"), _uA(
                            _cV(_component_navigator, _uM("url" to "/pages/component/video/video-format"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("button", _uM("type" to "primary", "onClick" to pause), "视频格式示例")
                                )
                            }
                            ), "_" to 1))
                        )),
                        _cE("view", _uM("class" to "uni-flex uni-btn-v", "style" to _nS(_uM("justify-content" to "space-between", "align-items" to "center"))), _uA(
                            _cE("text", _uM("class" to "uni-title", "style" to _nS(_uM("width" to "80%"))), "子组件实现快进、快退、发送弹幕功能（全屏后显示）", 4),
                            _cV(_component_switch, _uM("checked" to unref(data).subCompEnable, "onChange" to onSubCompEnableChange), null, 8, _uA(
                                "checked"
                            ))
                        ), 4),
                        _cE("view", _uM("class" to "uni-title"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "API示例")
                        )),
                        _cE("view", _uM("class" to "uni-btn-v"), _uA(
                            _cE("button", _uM("type" to "primary", "onClick" to play), "播放")
                        )),
                        _cE("view", _uM("class" to "uni-btn-v"), _uA(
                            _cE("button", _uM("type" to "primary", "onClick" to pause), "暂停")
                        )),
                        _cE("view", _uM("class" to "uni-btn-v"), _uA(
                            _cE("input", _uM("class" to "input", "placeholder" to "输入要跳转的位置,单位s", "type" to "number", "onInput" to onSeekInput), null, 32),
                            _cE("button", _uM("type" to "primary", "onClick" to fun(){
                                seek(unref(data).pos)
                            }
                            ), "跳转到指定位置", 8, _uA(
                                "onClick"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-btn-v"), _uA(
                            _cV(_component_enum_data, _uM("title" to "选择进入全屏时的视频方向", "items" to unref(data).directionItemTypes, "onChange" to onRequestFullScreenDirectionChange), null, 8, _uA(
                                "items"
                            )),
                            _cE("button", _uM("type" to "primary", "onClick" to requestFullScreen), "进入全屏")
                        )),
                        _cE("view", _uM("class" to "uni-btn-v"), _uA(
                            _cE("button", _uM("type" to "primary", "onClick" to exitFullScreen), "退出全屏")
                        )),
                        _cE("view", _uM("class" to "uni-btn-v"), _uA(
                            _cE("button", _uM("type" to "primary", "onClick" to stop), "停止")
                        )),
                        _cE("view", _uM("class" to "uni-btn-v"), _uA(
                            _cE("input", _uM("class" to "input", "placeholder" to "输入弹幕", "value" to "{ 'text': '要显示的文本', 'color': '#FF0000' }", "type" to "string", "onInput" to onSendDanmuInput), null, 32),
                            _cE("button", _uM("type" to "primary", "disabled" to !unref(data).enableDanmu, "onClick" to sendDanmu), "发送弹幕", 8, _uA(
                                "disabled"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-btn-v"), _uA(
                            _cV(_component_enum_data, _uM("title" to "选择倍速", "items" to unref(data).rateItemTypes, "onChange" to onPlaybackRateChange), null, 8, _uA(
                                "items"
                            )),
                            _cE("button", _uM("type" to "primary", "onClick" to playbackRate), "设置倍速")
                        )),
                        _cE("view", _uM("class" to "uni-title"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "属性示例")
                        )),
                        _cE("input", _uM("class" to "input margin-10", "type" to "string", "placeholder" to "设置播放资源", "onConfirm" to onSrcComfirm), null, 32),
                        _cE("input", _uM("class" to "input margin-10", "type" to "number", "placeholder" to "设置初始播放位置（播放前设置有效）", "onConfirm" to onInitialTimeComfirm), null, 32),
                        _cE("input", _uM("class" to "input margin-10", "type" to "number", "placeholder" to "设置视频时长（播放前设置有效）", "onConfirm" to onDurationComfirm), null, 32),
                        _cE("input", _uM("class" to "input margin-10", "type" to "string", "placeholder" to "设置视频封面", "onConfirm" to onPosterComfirm), null, 32),
                        _cE("input", _uM("class" to "input margin-10", "type" to "string", "placeholder" to "设置视频标题（仅限非 Web 平台）", "onConfirm" to onTitleComfirm), null, 32),
                        _cE("input", _uM("class" to "input margin-10", "type" to "string", "placeholder" to "设置header(json格式)", "onConfirm" to onHeaderComfirm), null, 32),
                        _cV(_component_boolean_data, _uM("title" to "设置是否展示弹幕（播放前设置有效）", "defaultValue" to unref(data).enableDanmu, "onChange" to onEnableDanmuChange), null, 8, _uA(
                            "defaultValue"
                        )),
                        _cV(_component_boolean_data, _uM("title" to "设置是否自动播放（播放前设置有效）", "defaultValue" to unref(data).autoplay, "onChange" to onAutoplayChange), null, 8, _uA(
                            "defaultValue"
                        )),
                        _cV(_component_boolean_data, _uM("title" to "设置是否循环播放（播放完成后生效）", "defaultValue" to unref(data).loop, "onChange" to onLoopChange), null, 8, _uA(
                            "defaultValue"
                        )),
                        _cV(_component_boolean_data, _uM("title" to "设置是否静音播放", "defaultValue" to unref(data).muted, "onChange" to onMutedChange), null, 8, _uA(
                            "defaultValue"
                        )),
                        _cV(_component_boolean_data, _uM("title" to "设置是否显示默认播放控件", "defaultValue" to unref(data).controls, "onChange" to onControlsChange), null, 8, _uA(
                            "defaultValue"
                        )),
                        _cV(_component_boolean_data, _uM("title" to "设置是否显示弹幕按钮", "defaultValue" to unref(data).danmuBtn, "onChange" to onDanmuBtnChange), null, 8, _uA(
                            "defaultValue"
                        )),
                        _cV(_component_boolean_data, _uM("title" to "设置是否显示进度条", "defaultValue" to unref(data).showProgress, "onChange" to onShowProgressChange), null, 8, _uA(
                            "defaultValue"
                        )),
                        _cV(_component_boolean_data, _uM("title" to "设置是否显示全屏按钮", "defaultValue" to unref(data).showFullscreenBtn, "onChange" to onShowFullscreenBtnChange), null, 8, _uA(
                            "defaultValue"
                        )),
                        _cV(_component_boolean_data, _uM("title" to "设置是否显示视频底部控制栏的播放按钮", "defaultValue" to unref(data).showPlayBtn, "onChange" to onShowPlayBtnChange), null, 8, _uA(
                            "defaultValue"
                        )),
                        _cV(_component_boolean_data, _uM("title" to "设置是否显示静音按钮（仅限非 Web 平台）", "defaultValue" to unref(data).showMuteBtn, "onChange" to onShowMuteBtnChange), null, 8, _uA(
                            "defaultValue"
                        )),
                        _cV(_component_boolean_data, _uM("title" to "设置是否显示视频中间的播放按钮", "defaultValue" to unref(data).showCenterPlayBtn, "onChange" to onShowCenterPlayBtnChange), null, 8, _uA(
                            "defaultValue"
                        )),
                        _cV(_component_boolean_data, _uM("title" to "设置是否显示loading控件", "defaultValue" to unref(data).showLoading, "onChange" to onShowLoadingChange), null, 8, _uA(
                            "defaultValue"
                        )),
                        _cV(_component_boolean_data, _uM("title" to "设置是否开启控制进度的手势", "defaultValue" to unref(data).enableProgressGesture, "onChange" to onEnableProgressGestureChange), null, 8, _uA(
                            "defaultValue"
                        )),
                        _cV(_component_boolean_data, _uM("title" to "设置是否开启播放手势,双击播放暂停（仅限非 Web 平台）", "defaultValue" to unref(data).enablePlayGesture, "onChange" to onEnablePlayGestureChange), null, 8, _uA(
                            "defaultValue"
                        )),
                        _cV(_component_boolean_data, _uM("title" to "非全屏模式下，设置是否开启亮度与音量调节手势 page-gesture", "defaultValue" to unref(data).pageGesture, "onChange" to onPageGestureChange), null, 8, _uA(
                            "defaultValue"
                        )),
                        _cV(_component_boolean_data, _uM("title" to "非全屏模式下，设置是否开启亮度与音量调节手势 vslide-gesture（仅限非 Web 平台）", "defaultValue" to unref(data).vslideGesture, "onChange" to onVslideGestureChange), null, 8, _uA(
                            "defaultValue"
                        )),
                        _cV(_component_boolean_data, _uM("title" to "全屏模式下，设置是否开启亮度与音量调节手势（仅限非 Web 平台）", "defaultValue" to unref(data).vslideGestureInFullscreen, "onChange" to onVslideGestureInFullscreenChange), null, 8, _uA(
                            "defaultValue"
                        )),
                        _cV(_component_enum_data, _uM("title" to "视频与video容器大小不一致时的表现", "items" to unref(data).objectFitItemTypes, "onChange" to onObjectFitChange), null, 8, _uA(
                            "items"
                        )),
                        _cV(_component_boolean_data, _uM("title" to "设置是否对http、https视频源开启本地缓存（仅 Android、iOS 平台，播放前设置有效）", "defaultValue" to unref(data).httpCache, "onChange" to onHttpCacheChange), null, 8, _uA(
                            "defaultValue"
                        )),
                        _cV(_component_enum_data, _uM("title" to "设置解码器（仅 Android、iOS 平台，播放前设置有效）", "items" to unref(data).codecItemTypes, "onChange" to onCodecChange), null, 8, _uA(
                            "items"
                        )),
                        _cV(_component_enum_data, _uM("title" to "设置播放策略（仅 Android、iOS 平台，播放前设置有效）", "items" to unref(data).playStrategyItemTypes, "onChange" to onPlayStrategyChange), null, 8, _uA(
                            "items"
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
                return _uM("video" to _pS(_uM("width" to "100%", "height" to 200)), "input" to _pS(_uM("height" to 40, "backgroundImage" to "none", "backgroundColor" to "#FFFFFF", "paddingTop" to 8, "paddingRight" to 13, "paddingBottom" to 8, "paddingLeft" to 13)), "margin-10" to _pS(_uM("marginTop" to 10, "marginRight" to 10, "marginBottom" to 10, "marginLeft" to 10)), "img-fast-backward" to _pS(_uM("width" to 40, "height" to 40, "top" to "50%", "left" to "12%", "transform" to "translate(-50%, -50%)", "position" to "absolute")), "img-fast-forward" to _pS(_uM("width" to 40, "height" to 40, "top" to "50%", "right" to "12%", "transform" to "translate(50%, -50%)", "position" to "absolute")), "input-send-danmu" to _pS(_uM("height" to 40, "paddingTop" to 8, "paddingRight" to 13, "paddingBottom" to 8, "paddingLeft" to 13, "marginTop" to 0, "marginRight" to CSS_VAR_STATUS_BAR_HEIGHT, "marginBottom" to 0, "marginLeft" to CSS_VAR_STATUS_BAR_HEIGHT, "bottom" to 100, "position" to "absolute", "backgroundColor" to "rgba(0,0,0,0.5)", "color" to "#FFFFFF")), "video-fullscreen_controls" to _pS(_uM("position" to "absolute", "left" to 0, "right" to 0, "bottom" to 8, "height" to 50, "flexDirection" to "row", "justifyContent" to "flex-start", "alignItems" to "center")), "control-btn" to _pS(_uM("width" to 60, "height" to "100%", "justifyContent" to "center", "alignItems" to "center", "marginTop" to 0, "marginRight" to 15, "marginBottom" to 0, "marginLeft" to 15)), "control-icon" to _pS(_uM("fontFamily" to "uni-video-icon", "fontSize" to 24, "color" to "rgba(255,255,255,0.8)", "textAlign" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
