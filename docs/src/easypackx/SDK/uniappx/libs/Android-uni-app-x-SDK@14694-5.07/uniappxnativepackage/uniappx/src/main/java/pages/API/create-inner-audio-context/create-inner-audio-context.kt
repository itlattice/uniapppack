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
import io.dcloud.uniapp.extapi.createInnerAudioContext as uni_createInnerAudioContext
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesAPICreateInnerAudioContextCreateInnerAudioContext : BasePage {
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
    open var data: DataType__113
        get() {
            return unref(this.`$exposed`["data"]) as DataType__113
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var setSrc: (src: String) -> Unit
        get() {
            return unref(this.`$exposed`["setSrc"]) as (src: String) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setSrc", value)
        }
    open var play: () -> Unit
        get() {
            return unref(this.`$exposed`["play"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "play", value)
        }
    open var stop: () -> Unit
        get() {
            return unref(this.`$exposed`["stop"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "stop", value)
        }
    open var pause: () -> Unit
        get() {
            return unref(this.`$exposed`["pause"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "pause", value)
        }
    open var onchangeValue: (pos: Number) -> Unit
        get() {
            return unref(this.`$exposed`["onchangeValue"]) as (pos: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "onchangeValue", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPICreateInnerAudioContextCreateInnerAudioContext, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPICreateInnerAudioContextCreateInnerAudioContext
            val _cache = __ins.renderCache
            val audioUrl = "https://web-ext-storage.dcloud.net.cn/uni-app/ForElise.mp3"
            val title = ref("innerAudioContext")
            val sliderRef = ref<UniSliderElement?>(null)
            val onTimeUpdateCb = ref(fun(res: Any){})
            val onWaitingCb = ref(fun(res: Any){})
            val data = reactive(DataType__113(currentTime = 0, duration = 100, startTime = 0, buffered = 0, volume = 0.5, isCanplay = false, isPlaying = false, isPaused = true, isPlayEnd = false, _isChanging = false, _audioContext = null as InnerAudioContext?, playbackRateChecked = true, onSeekingTest = false, onSeekedTest = false, onWaitingTest = false))
            val position = computed(fun(): Number {
                return if (data.isPlayEnd) {
                    0
                } else {
                    data.currentTime
                }
            }
            )
            val stop = fun(){
                console.log("stop")
                data._audioContext!!.onStop(fun(_result){
                    data.isPaused = true
                    console.log("音频停止事件")
                }
                )
                data._audioContext!!.stop()
                data.isPlaying = false
                console.log("stop", data.isPaused)
            }
            val onCanplay = fun(){
                data._audioContext!!.onCanplay(fun(_result){
                    console.log("音频进入可以播放状态事件")
                    data.isCanplay = true
                    data.buffered = data._audioContext!!.buffered
                    data.duration = data._audioContext!!.duration
                }
                )
            }
            val onchanging = fun(){
                data._isChanging = true
            }
            val setAutoplay = fun(){
                data._audioContext!!.autoplay = !data._audioContext!!.autoplay
                console.log(data._audioContext!!.autoplay, "autoplay")
            }
            val setLoop = fun(){
                data._audioContext!!.loop = !data._audioContext!!.loop
                console.log(data._audioContext!!.loop, "loop")
            }
            val onSeeking = fun(){
                data._audioContext!!.onSeeking(fun(_result){
                    console.log("音频进行 seek 操作事件")
                    data.onSeekingTest = true
                }
                )
            }
            val onSeeked = fun(){
                data._audioContext!!.onSeeked(fun(_result){
                    console.log("音频完成 seek 操作事件")
                    data.onSeekedTest = true
                }
                )
            }
            val onchange = fun(e: UniSliderChangeEvent){
                var pos = e.detail.value
                console.log("pos", pos)
                onSeeking()
                onSeeked()
                data._audioContext!!.seek(pos)
                data._isChanging = false
            }
            val onchangeValue = fun(pos: Number){
                onSeeking()
                onSeeked()
                data._audioContext!!.seek(pos)
                data._isChanging = false
            }
            val startTimeInput = fun(e: UniInputEvent){
                var startTimeValue = parseInt(e.detail.value)
                data._audioContext!!.startTime = startTimeValue
                onchangeValue(startTimeValue)
            }
            val play = fun(){
                if (!data.isCanplay) {
                    uni_showToast(ShowToastOptions(title = "音频未进入可以播放状态，请稍后再试", icon = "error"))
                    return
                }
                data.isPlaying = true
                data._audioContext!!.play()
                data.isPlayEnd = false
                if (data._audioContext!!.startTime > 0) {
                    onchangeValue(data._audioContext!!.startTime)
                }
            }
            val onWaiting = fun(){
                data._audioContext!!.onWaiting(onWaitingCb.value)
            }
            val offWaiting = fun(){
                data._audioContext!!.offWaiting(onWaitingCb.value)
            }
            val onTimeUpdate = fun(){
                data._audioContext!!.onTimeUpdate(onTimeUpdateCb.value)
            }
            val offTimeUpdate = fun(){
                data._audioContext!!.offTimeUpdate(onTimeUpdateCb.value)
            }
            val increaseVolume = fun(){
                data.volume = Math.min(data.volume + 0.1, 1)
                data.volume = parseFloat(data.volume.toFixed(1))
                data._audioContext!!.volume = data.volume
                console.log("增加音量", data.volume)
            }
            val decreaseVolume = fun(){
                data.volume = Math.max(data.volume - 0.1, 0)
                data.volume = parseFloat(data.volume.toFixed(1))
                console.log("减少音量", data.volume)
                data._audioContext!!.volume = data.volume
            }
            val onEnded = fun(){
                data._audioContext!!.onEnded(fun(_result){
                    console.log("播放结束")
                    data.currentTime = 0
                    data.startTime = 0
                    data.isPlaying = false
                    data.isPaused = true
                    data.isPlayEnd = true
                    sliderRef.value!!.value = 0
                }
                )
            }
            val onError__1 = fun(){
                data._audioContext!!.onError(fun(err){
                    console.log("err", err)
                    data.isPlaying = false
                    data.isPaused = true
                }
                )
            }
            val pause = fun(){
                data._audioContext!!.onPause(fun(_result){
                    console.log("音频暂停事件")
                    data.isPaused = true
                }
                )
                data._audioContext!!.pause()
                data.isPlaying = false
            }
            val destory = fun(){
                if (data._audioContext != null) {
                    data.isPlaying = false
                    data._audioContext!!.destroy()
                }
            }
            val playbackRateChange = fun(e: UniRadioGroupChangeEvent){
                console.log(parseFloat(e.detail.value))
                data._audioContext!!.playbackRate = parseFloat(e.detail.value)
            }
            val setSrc = fun(src: String){
                if (data._audioContext != null) {
                    data._audioContext!!.src = src
                }
            }
            onReady(fun(){
                data._audioContext = uni_createInnerAudioContext()
                data._audioContext!!.src = audioUrl
                data.volume = data._audioContext!!.volume
                onCanplay()
                data._audioContext!!.onPlay(fun(_result){
                    data.isPaused = false
                    data.isPlaying = true
                    console.log("开始播放", data.isPaused)
                }
                )
                onTimeUpdateCb.value = fun(res: Any){
                    if (data._isChanging) {
                        return
                    }
                    data.currentTime = data._audioContext!!.currentTime
                    data.buffered = data._audioContext!!.buffered
                    console.log("onTimeUpdateCb", data.currentTime)
                    if (data.currentTime > data.buffered) {
                        console.log("缓冲不足")
                    }
                }
                onWaitingCb.value = fun(res: Any){
                    console.log("音频加载中事件")
                    data.onWaitingTest = true
                }
                onTimeUpdate()
                onError__1()
                onEnded()
            }
            )
            onUnload(fun(){
                if (data._audioContext != null) {
                    if (data.isPlaying) {
                        stop()
                    }
                    data._audioContext!!.destroy()
                }
            }
            )
            __expose(_uM("data" to data, "setSrc" to setSrc, "play" to play, "stop" to stop, "pause" to pause, "onchangeValue" to onchangeValue))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                val _component_slider = resolveComponent("slider")
                val _component_boolean_data = resolveEasyComponent("boolean-data", GenComponentsBooleanDataBooleanDataClass)
                val _component_radio = resolveComponent("radio")
                val _component_radio_group = resolveComponent("radio-group")
                val _component_navigator = resolveComponent("navigator")
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                        _cV(_component_page_head, _uM("title" to "audio")),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cV(_component_slider, _uM("ref_key" to "sliderRef", "ref" to sliderRef, "value" to unref(position), "min" to 0, "max" to unref(data).duration, "onChanging" to onchanging, "onChange" to onchange), null, 8, _uA(
                                "value",
                                "max"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-title"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "属性示例")
                        )),
                        _cE("text", _uM("class" to "uni-text-box uni-common-mt"), "当前音频播放位置（保留小数点后 3 位）：" + _tD(unref(data).currentTime) + " s", 1),
                        _cE("text", _uM("class" to "uni-text-box"), "音频的长度（单位:s）：" + _tD(unref(data).duration) + " s", 1),
                        _cE("text", _uM("class" to "uni-text-box"), "当前是否停止状态：" + _tD(unref(data).isPaused), 1),
                        _cE("text", _uM("class" to "uni-text-box"), "音频缓冲的时间点：" + _tD(unref(data).buffered) + " s", 1),
                        _cE("text", _uM("class" to "uni-text-box"), "当前音量：" + _tD(unref(data).volume), 1),
                        _cE("button", _uM("plain" to "", "disabled" to (unref(data).volume == 1), "onClick" to increaseVolume), "增加音量", 8, _uA(
                            "disabled"
                        )),
                        _cE("button", _uM("plain" to "", "disabled" to (unref(data).volume == 0), "onClick" to decreaseVolume), "减少音量", 8, _uA(
                            "disabled"
                        )),
                        _cE("text", _uM("class" to "uni-subtitle-text uni-title"), "开始播放的位置（单位：s）"),
                        _cE("input", _uM("value" to unref(data).startTime, "type" to "number", "placeholder" to "开始播放的位置（单位：s）", "class" to "uni-input", "onInput" to startTimeInput), null, 40, _uA(
                            "value"
                        )),
                        _cV(_component_boolean_data, _uM("defaultValue" to false, "title" to "是否自动开始播放", "onChange" to setAutoplay)),
                        _cV(_component_boolean_data, _uM("defaultValue" to false, "title" to "是否循环播放", "onChange" to setLoop)),
                        _cE("text", _uM("class" to "uni-subtitle-text uni-title", "style" to _nS(_uM("padding-left" to "10px", "padding-top" to "10px", "padding-right" to "10px"))), "播放倍率(Web/HarmonyOS 不支持)", 4),
                        _cV(_component_radio_group, _uM("class" to "uni-flex uni-row radio-group", "onChange" to playbackRateChange, "style" to _nS(_uM("flex-wrap" to "wrap", "padding" to "10px"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cV(_component_radio, _uM("value" to "0.5", "style" to _nS(_uM("margin-right" to "3px"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        "0.5 "
                                    )
                                }
                                ), "_" to 1), 8, _uA(
                                    "style"
                                )),
                                _cV(_component_radio, _uM("value" to "0.8", "style" to _nS(_uM("margin-right" to "3px"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        "0.8"
                                    )
                                }
                                ), "_" to 1), 8, _uA(
                                    "style"
                                )),
                                _cV(_component_radio, _uM("value" to "1.0", "style" to _nS(_uM("margin-right" to "3px")), "checked" to unref(data).playbackRateChecked), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        "1.0"
                                    )
                                }
                                ), "_" to 1), 8, _uA(
                                    "style",
                                    "checked"
                                )),
                                _cV(_component_radio, _uM("value" to "1.25", "style" to _nS(_uM("margin-right" to "3px"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        "1.25"
                                    )
                                }
                                ), "_" to 1), 8, _uA(
                                    "style"
                                )),
                                _cV(_component_radio, _uM("value" to "1.5", "style" to _nS(_uM("margin-right" to "3px"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        "1.5"
                                    )
                                }
                                ), "_" to 1), 8, _uA(
                                    "style"
                                )),
                                _cV(_component_radio, _uM("value" to "2.0"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        "2.0"
                                    )
                                }
                                ), "_" to 1))
                            )
                        }
                        ), "_" to 1), 8, _uA(
                            "style"
                        )),
                        _cE("view", _uM("class" to "uni-title"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "方法示例")
                        )),
                        _cE("button", _uM("disabled" to unref(data).isPlaying, "onClick" to play, "class" to "uni-btn"), "播放", 8, _uA(
                            "disabled"
                        )),
                        _cE("button", _uM("disabled" to !unref(data).isPlaying, "onClick" to pause, "class" to "uni-btn"), "暂停", 8, _uA(
                            "disabled"
                        )),
                        _cE("button", _uM("disabled" to !unref(data).isPlaying, "onClick" to stop, "class" to "uni-btn"), "停止", 8, _uA(
                            "disabled"
                        )),
                        _cE("button", _uM("onClick" to fun(){
                            onchangeValue(20)
                        }
                        , "class" to "uni-btn"), "跳转到指定位置20", 8, _uA(
                            "onClick"
                        )),
                        _cE("button", _uM("onClick" to onTimeUpdate, "class" to "uni-btn"), "onTimeUpdate"),
                        _cE("button", _uM("onClick" to offTimeUpdate, "class" to "uni-btn"), "offTimeUpdate"),
                        _cE("button", _uM("onClick" to onWaiting, "class" to "uni-btn"), "onWaiting"),
                        _cE("button", _uM("onClick" to offWaiting, "class" to "uni-btn"), "offWaiting"),
                        _cE("text", _uM("style" to _nS(_uM("color" to "red", "font-size" to "15px", "margin-top" to "10px"))), "tip:销毁后请重新进入此界面再播放", 4),
                        _cE("button", _uM("onClick" to destory, "class" to "uni-btn"), "销毁"),
                        _cE("view", _uM("class" to "uni-title"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "格式/路径示例")
                        )),
                        _cV(_component_navigator, _uM("url" to "/pages/API/create-inner-audio-context/inner-audio-format", "class" to "uni-btn"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("button", _uM("onClick" to pause), "音频格式示例")
                            )
                        }
                        ), "_" to 1)),
                        _cV(_component_navigator, _uM("url" to "/pages/API/create-inner-audio-context/inner-audio-path", "class" to "uni-btn"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("button", _uM("onClick" to pause), "音频路径示例")
                            )
                        }
                        ), "_" to 1)),
                        _cV(_component_navigator, _uM("url" to "/pages/API/create-inner-audio-context/inner-audio-mult", "class" to "uni-btn"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("button", _uM("onClick" to pause), "多音频同时播放")
                            )
                        }
                        ), "_" to 1))
                    ))
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
                return _uM("play-time-area" to _pS(_uM("display" to "flex", "flexDirection" to "row", "marginTop" to 20)), "duration" to _pS(_uM("marginLeft" to "auto")), "play-button-area" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "marginTop" to 50, "marginRight" to 0, "marginBottom" to 50, "marginLeft" to 0)), "icon-play" to _pS(_uM("width" to 60, "height" to 60)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
