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
import io.dcloud.uniapp.extapi.getRecorderManager as uni_getRecorderManager
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesAPIGetRecorderManagerGetRecorderManager : BasePage {
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
    open var data: DataType__108
        get() {
            return unref(this.`$exposed`["data"]) as DataType__108
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIGetRecorderManagerGetRecorderManager, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIGetRecorderManagerGetRecorderManager
            val _cache = __ins.renderCache
            val disableStartBtn = ref(false)
            val disableResumeBtn = ref(false)
            val disablePauseBtn = ref(false)
            val title = ref("start/stopRecord、play/stopVoice")
            val hasRecord = ref(false)
            val data = reactive(DataType__108(registerError = false, recording = false, playing = false))
            val playTimeInterval = ref(0)
            val recordTimeInterval = ref(0)
            val tempFilePath = ref("")
            val recordTime = ref(0)
            val current = ref(0)
            val playTime = ref(0)
            val formatedRecordTime = ref("00:00:00")
            val formatedPlayTime = ref("00:00:00")
            val recorderManager = ref(null as RecorderManager?)
            val music = ref(null as InnerAudioContext?)
            val items = ref(_uA<ItemType__9>(ItemType__9(value = "aac", name = "aac"), ItemType__9(value = "mp3", name = "mp3"), ItemType__9(value = "wav", name = "wav"), ItemType__9(value = "pcm", name = "pcm")))
            val radioChange = fun(e: UniRadioGroupChangeEvent){
                run {
                    var i: Number = 0
                    while(i < items.value.length){
                        if (items.value[i].value === e.detail.value) {
                            current.value = i
                            break
                        }
                        i++
                    }
                }
            }
            val formatTime = fun(reassignedTime: Number): String {
                var time = reassignedTime
                if (UTSAndroid.`typeof`(time) !== "number" || time < 0) {
                    return time.toString(10)
                }
                var hour = parseInt((time / 3600).toString(10))
                time = time % 3600
                var minute = parseInt((time / 60).toString(10))
                time = time % 60
                var second = time
                return _uA(
                    hour,
                    minute,
                    second
                ).map(fun(n: Number): String {
                    var str = n.toString(10)
                    return if (str.length > 1) {
                        str
                    } else {
                        "0" + str
                    }
                }
                ).join(":")
            }
            val registerOnStart = fun(){
                uni_showToast(ShowToastOptions(title = "already registerOnStart"))
                recorderManager.value!!.onStart(fun(_result){
                    console.log("recorder on start")
                    recordTime.value = 0
                    data.recording = true
                    recordTimeInterval.value = setInterval(fun(){
                        recordTime.value += 1
                        formatedRecordTime.value = formatTime(recordTime.value)
                    }
                    , 1000)
                }
                )
            }
            val registeronStop = fun(){
                uni_showToast(ShowToastOptions(title = "already registeronStop"))
                recorderManager.value!!.onStop(fun(res){
                    console.log("on stop", res)
                    music.value!!.src = res.tempFilePath
                    clearInterval(recordTimeInterval.value)
                    hasRecord.value = true
                    data.recording = false
                }
                )
            }
            val registeronError = fun(){
                uni_showToast(ShowToastOptions(title = "already registeronError"))
                data.registerError = true
                recorderManager.value!!.onError(fun(res){
                    console.log("recorder onError", JSON.stringify(res))
                }
                )
            }
            val registeronPause = fun(){
                uni_showToast(ShowToastOptions(title = "already registeronPause"))
                recorderManager.value?.onPause(fun(_result){
                    console.log("recorder onPause")
                }
                )
            }
            val registeronResume = fun(){
                uni_showToast(ShowToastOptions(title = "already registeronStop"))
                recorderManager.value?.onResume(fun(_result){
                    console.log("recorder onResume")
                }
                )
            }
            val registeronInterruptionBegin = fun(){
                uni_showToast(ShowToastOptions(title = "already registeronInterruptionBegin"))
                recorderManager.value?.onInterruptionBegin(fun(_result){
                    console.log("recorder onInterruptionBegin")
                }
                )
            }
            val registeronInterruptionEnd = fun(){
                uni_showToast(ShowToastOptions(title = "already registeronInterruptionEnd"))
                recorderManager.value?.onInterruptionBegin(fun(_result){
                    console.log("recorder registeronInterruptionEnd")
                }
                )
            }
            val pauseRecord = fun(){
                console.log("recorder pause")
                recorderManager.value?.pause()
                if (data.recording) {
                    disableStartBtn.value = false
                    disablePauseBtn.value = true
                    disableResumeBtn.value = false
                }
                clearInterval(recordTimeInterval.value)
            }
            val resumeRecord = fun(){
                console.log("recorder resume ", recorderManager.value)
                recorderManager.value?.resume()
                recorderManager.value?.onResume(fun(_result){
                    console.log("recorder onResume")
                }
                )
                if (data.recording) {
                    disableStartBtn.value = false
                    disablePauseBtn.value = false
                    disableResumeBtn.value = true
                    recordTimeInterval.value = setInterval(fun(){
                        recordTime.value += 1
                        formatedRecordTime.value = formatTime(recordTime.value)
                    }
                    , 1000)
                }
            }
            val startRecord = fun(){
                if (data.recording) {
                    uni_showToast(ShowToastOptions(title = if (disablePauseBtn.value) {
                        "当前是录音暂停状态"
                    } else {
                        "当前正在录音"
                    }
                    ))
                    return
                }
                console.log("startRecord", items.value[current.value].value)
                recorderManager.value?.start(RecorderManagerStartOptions(format = items.value[current.value].value, sampleRate = 8000, numberOfChannels = 2, encodeBitRate = 48000, frameSize = 2))
            }
            val stopRecord = fun(){
                recorderManager.value?.stop()
                disableStartBtn.value = false
                disablePauseBtn.value = false
                disableResumeBtn.value = false
            }
            val playVoice = fun(){
                if (data.recording) {
                    uni_showToast(ShowToastOptions(title = "当前录音还未结束"))
                    return
                }
                console.log("play voice")
                if (data.playing) {
                    return
                }
                data.playing = true
                playTimeInterval.value = setInterval(fun(){
                    if (playTime.value < recordTime.value) {
                        playTime.value += 1
                    }
                    formatedRecordTime.value = formatTime(playTime.value)
                }
                , 1000)
                music.value?.play()
            }
            val stopVoice = fun(){
                if (data.recording) {
                    uni_showToast(ShowToastOptions(title = "当前录音还未结束"))
                    return
                }
                clearInterval(playTimeInterval.value)
                data.playing = false
                formatedRecordTime.value = formatTime(0)
                playTime.value = 0
                music.value?.stop()
            }
            val end = fun(){
                music.value?.stop()
                music.value?.destroy()
                recorderManager.value?.offError()
                recorderManager.value?.offFrameRecorded()
                recorderManager.value?.offInterruptionBegin()
                recorderManager.value?.offInterruptionEnd()
                recorderManager.value?.offPause()
                recorderManager.value?.offResume()
                recorderManager.value?.offStart()
                recorderManager.value?.offStop()
                recorderManager.value?.stop()
                clearInterval(recordTimeInterval.value)
                clearInterval(playTimeInterval.value)
                data.recording = false
                data.playing = false
                hasRecord.value = false
                playTime.value = 0
                recordTime.value = 0
                formatedRecordTime.value = "00:00:00"
                formatedRecordTime.value = "00:00:00"
            }
            onUnload(fun(){
                end()
            }
            )
            onLoad(fun(_options){
                music.value = uni_createInnerAudioContext()
                music.value!!.onEnded(fun(_result){
                    clearInterval(playTimeInterval.value)
                    var playTimeValue: Number = 0
                    console.log("play voice finished")
                    data.playing = false
                    formatedPlayTime.value = formatTime(playTimeValue)
                    playTime.value = playTimeValue
                }
                )
                recorderManager.value = uni_getRecorderManager()
                recorderManager.value!!.onStart(fun(_result){
                    console.log("recorder onStart")
                    disableStartBtn.value = true
                    disablePauseBtn.value = false
                    disableResumeBtn.value = false
                    data.recording = true
                    recordTime.value = 0
                    recordTimeInterval.value = setInterval(fun(){
                        recordTime.value += 1
                        formatedRecordTime.value = formatTime(recordTime.value)
                    }
                    , 1000)
                }
                )
                recorderManager.value!!.onStop(fun(res){
                    console.log("on stop", res.tempFilePath)
                    disablePauseBtn.value = false
                    disableResumeBtn.value = false
                    disableStartBtn.value = false
                    music.value!!.src = res.tempFilePath
                    clearInterval(recordTimeInterval.value)
                    hasRecord.value = true
                    data.recording = false
                }
                )
                recorderManager.value!!.onError(fun(res){
                    console.log("recorder onError", JSON.stringify(res))
                    disablePauseBtn.value = false
                    disableResumeBtn.value = false
                    disableStartBtn.value = false
                    data.registerError = true
                    uni_showToast(ShowToastOptions(title = JSON.stringify(res)))
                }
                )
            }
            )
            __expose(_uM("data" to data))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                val _component_radio = resolveComponent("radio")
                val _component_radio_group = resolveComponent("radio-group")
                return _cE(Fragment, null, _uA(
                    _cV(_component_page_head, _uM("title" to unref(title)), null, 8, _uA(
                        "title"
                    )),
                    _cE("view", _uM("class" to "page-body-time"), _uA(
                        _cE("text", _uM("class" to "time-big"), _tD(unref(formatedRecordTime)), 1)
                    )),
                    _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                        _cE("view", null, _uA(
                            _cE("button", _uM("class" to "btnstyle", "size" to "default", "onClick" to registerOnStart), "注册onStart"),
                            _cE("button", _uM("class" to "btnstyle", "size" to "default", "onClick" to registeronStop), "注册onStop"),
                            _cE("button", _uM("class" to "btnstyle", "size" to "default", "id" to "btn-error", "onClick" to registeronError), "注册onError"),
                            _cE("button", _uM("class" to "btnstyle", "size" to "default", "onClick" to registeronPause), "注册onPause"),
                            _cE("button", _uM("class" to "btnstyle", "size" to "default", "onClick" to registeronResume), "注册onResume"),
                            _cE("button", _uM("class" to "btnstyle", "size" to "default", "onClick" to registeronInterruptionBegin), "注册onInterruptionBegin"),
                            _cE("button", _uM("class" to "btnstyle", "size" to "default", "onClick" to registeronInterruptionEnd), "注册onInterruptionEnd"),
                            _cE("view", _uM("class" to "uni-list"), _uA(
                                _cE("text", _uM("style" to _nS(_uM("margin-bottom" to "10px"))), " 请选择录音格式：", 4),
                                _cV(_component_radio_group, _uM("class" to "uni-flex uni-row", "onChange" to radioChange, "style" to _nS(_uM("flex-wrap" to "wrap"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cE(Fragment, null, RenderHelpers.renderList(unref(items), fun(item, index, __index, _cached): Any {
                                            return _cV(_component_radio, _uM("class" to "uni-list-cell", "style" to _nS(_uM("margin-right" to "15px")), "key" to item.value, "value" to item.value, "checked" to (index === unref(current))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _tD(item.name)
                                                )
                                            }
                                            ), "_" to 2), 1032, _uA(
                                                "style",
                                                "value",
                                                "checked"
                                            ))
                                        }
                                        ), 128)
                                    )
                                }
                                ), "_" to 1), 8, _uA(
                                    "style"
                                ))
                            )),
                            _cE("button", _uM("class" to "btnstyle", "size" to "default", "disabled" to unref(disableStartBtn), "id" to "btn-startRecord", "onClick" to fun(){
                                startRecord()
                            }
                            ), "开始录制", 8, _uA(
                                "disabled",
                                "onClick"
                            )),
                            _cE("button", _uM("class" to "btnstyle", "size" to "default", "disabled" to unref(disablePauseBtn), "onClick" to pauseRecord), "暂停录制", 8, _uA(
                                "disabled"
                            )),
                            _cE("button", _uM("class" to "btnstyle", "size" to "default", "disabled" to unref(disableResumeBtn), "onClick" to resumeRecord), "继续录制", 8, _uA(
                                "disabled"
                            )),
                            _cE("button", _uM("class" to "btnstyle", "size" to "default", "id" to "btn-stopRecord", "onClick" to stopRecord), "停止录制"),
                            _cE("button", _uM("class" to "btnstyle", "size" to "default", "id" to "btn-startPlay", "onClick" to playVoice), "开始播放"),
                            _cE("button", _uM("class" to "btnstyle", "size" to "default", "id" to "btn-stopPlay", "onClick" to stopVoice), "停止播放")
                        ))
                    ), 4)
                ), 64)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("page-body-time" to _pS(_uM("display" to "flex", "flexDirection" to "column", "alignItems" to "center")), "time-big" to _pS(_uM("fontSize" to 30, "marginTop" to 10, "marginRight" to 10, "marginBottom" to 10, "marginLeft" to 10)), "btnstyle" to _pS(_uM("marginLeft" to 30, "marginRight" to 30, "marginTop" to 10)), "uni-list" to _pS(_uM("borderBottomWidth" to 0, "borderBottomStyle" to "none", "borderBottomColor" to "#000000", "backgroundColor" to "rgba(0,0,0,0)", "marginLeft" to 30, "marginRight" to 30, "marginTop" to 10, "marginBottom" to 10)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
