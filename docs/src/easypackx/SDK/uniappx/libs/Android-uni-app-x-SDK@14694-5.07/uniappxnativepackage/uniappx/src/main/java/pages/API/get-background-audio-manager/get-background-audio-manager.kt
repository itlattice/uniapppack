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
import io.dcloud.uniapp.extapi.getBackgroundAudioManager as uni_getBackgroundAudioManager
open class GenPagesAPIGetBackgroundAudioManagerGetBackgroundAudioManager : BasePage {
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
        var setup: (__props: GenPagesAPIGetBackgroundAudioManagerGetBackgroundAudioManager) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIGetBackgroundAudioManagerGetBackgroundAudioManager
            val _cache = __ins.renderCache
            val title = ref("backgroundAudio")
            val sliderRef = ref<UniSliderElement?>(null)
            val bgAudioMannager = ref(null as BackgroundAudioManager?)
            val dataUrl = ref("https://web-ext-storage.dcloud.net.cn/uni-app/ForElise.mp3")
            val playing = ref(false)
            val playTime = ref(0)
            val formatedPlayTime = ref("00:00:00")
            val count = ref(100)
            val isPlayEnd = ref(false)
            val duration = ref(100)
            val currentTime = ref(0)
            val _isChanging = ref(false)
            val buffered = ref(0)
            val isLoop = ref(false)
            val position = computed(fun(): Number {
                return if (isPlayEnd.value) {
                    0
                } else {
                    currentTime.value
                }
            }
            )
            val play = fun(){
                console.log("play")
                isPlayEnd.value = false
                bgAudioMannager.value!!.play()
            }
            val pause = fun(){
                bgAudioMannager.value?.pause()
            }
            val stop = fun(){
                bgAudioMannager.value?.stop()
                playing.value = false
            }
            val onchanging = fun(){
                _isChanging.value = true
            }
            val onchange = fun(e: UniSliderChangeEvent){
                var pos = e.detail.value
                console.log("pos", pos)
                bgAudioMannager.value!!.seek(pos)
                _isChanging.value = false
            }
            val setLoop = fun(){
                isLoop.value = !isLoop.value
                console.log("当前是否设置循环播放，loop= ", isLoop.value)
            }
            onUnload(fun(){
                bgAudioMannager.value?.offCanplay()
                bgAudioMannager.value?.offEnded()
                bgAudioMannager.value?.offError()
                bgAudioMannager.value?.offNext()
                bgAudioMannager.value?.offPause()
                bgAudioMannager.value?.offPlay()
                bgAudioMannager.value?.offPrev()
                bgAudioMannager.value?.offSeeked()
                bgAudioMannager.value?.offSeeking()
                bgAudioMannager.value?.offStop()
                bgAudioMannager.value?.offTimeUpdate()
                bgAudioMannager.value?.offWaiting()
            }
            )
            onLoad(fun(_options){
                var bgAudioMannagerInstance = uni_getBackgroundAudioManager()
                bgAudioMannagerInstance.title = "致爱丽丝" + count.value
                bgAudioMannagerInstance.epname = "专辑名：致爱丽丝" + count.value
                bgAudioMannagerInstance.singer = "歌手：暂无" + count.value
                bgAudioMannagerInstance.coverImgUrl = "https://web-assets.dcloud.net.cn/unidoc/zh/Alice.jpeg"
                bgAudioMannagerInstance.src = dataUrl.value
                currentTime.value = bgAudioMannagerInstance.currentTime
                duration.value = bgAudioMannagerInstance.duration
                bgAudioMannagerInstance.onCanplay(fun(_result){
                    console.log("音频进入可以播放状态事件")
                    buffered.value = bgAudioMannagerInstance.buffered
                    duration.value = bgAudioMannagerInstance.duration
                }
                )
                bgAudioMannagerInstance.onPlay(fun(_result){
                    console.log("开始播放")
                    playing.value = true
                }
                )
                bgAudioMannagerInstance.onPause(fun(_result){
                    console.log("暂停播放")
                    playing.value = false
                }
                )
                bgAudioMannagerInstance.onStop(fun(_result){
                    console.log("停止播放")
                    playing.value = false
                }
                )
                bgAudioMannagerInstance.onEnded(fun(_result){
                    if (isLoop.value == false) {
                        console.log("播放结束")
                        playing.value = false
                        currentTime.value = 0
                        isPlayEnd.value = true
                        sliderRef.value!!.value = 0
                    } else {
                        console.log("播放结束, 开始循环播放")
                        bgAudioMannager.value!!.src = dataUrl.value
                        bgAudioMannager.value?.play()
                    }
                }
                )
                bgAudioMannagerInstance.onNext(fun(_result){
                    count.value++
                    console.log("下一曲", count.value)
                    bgAudioMannager.value?.stop()
                    bgAudioMannagerInstance.title = "致爱丽丝" + count.value
                    bgAudioMannagerInstance.singer = "歌手：暂无" + count.value
                    dataUrl.value = "https://web-ext-storage.dcloud.net.cn/uni-app/ForElise.mp3"
                    bgAudioMannagerInstance.coverImgUrl = "https://qiniu-web-assets.dcloud.net.cn/unidoc/zh/music-a.png"
                    bgAudioMannager.value!!.src = dataUrl.value
                    bgAudioMannager.value?.play()
                }
                )
                bgAudioMannagerInstance.onPrev(fun(_result){
                    count.value--
                    console.log("上一曲", count.value)
                    bgAudioMannager.value?.stop()
                    bgAudioMannagerInstance.title = "致爱丽丝" + count.value
                    bgAudioMannagerInstance.singer = "歌手：暂无" + count.value
                    dataUrl.value = "https://web-ext-storage.dcloud.net.cn/uni-app/ForElise.mp3"
                    bgAudioMannagerInstance.coverImgUrl = "https://web-assets.dcloud.net.cn/unidoc/zh/Alice.jpeg"
                    bgAudioMannager.value!!.src = dataUrl.value
                    bgAudioMannager.value?.play()
                }
                )
                bgAudioMannagerInstance.onSeeking(fun(_result){
                    console.log("音频进行 seek 操作事件")
                }
                )
                bgAudioMannagerInstance.onSeeked(fun(_result){
                    console.log("音频完成 seek 操作事件")
                }
                )
                bgAudioMannagerInstance.onWaiting(fun(_result){
                    console.log("音频加载中事件")
                }
                )
                bgAudioMannagerInstance.onTimeUpdate(fun(_result){
                    console.log("onTimeUpdate", bgAudioMannagerInstance.currentTime)
                    if (_isChanging.value) {
                        return
                    }
                    currentTime.value = bgAudioMannager.value!!.currentTime
                    buffered.value = bgAudioMannager.value!!.buffered
                    console.log("onTimeUpdateCb", currentTime.value)
                    if (currentTime.value > buffered.value) {
                        console.log("缓冲不足")
                    }
                }
                )
                bgAudioMannagerInstance.onError(fun(err){
                    console.log("播放出错err", err)
                }
                )
                bgAudioMannager.value = bgAudioMannagerInstance
                playing.value = !bgAudioMannagerInstance.paused
                console.log("currentTime=", bgAudioMannager.value!!.currentTime, bgAudioMannager.value!!.currentTime == 0)
            }
            )
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                val _component_boolean_data = resolveEasyComponent("boolean-data", GenComponentsBooleanDataBooleanDataClass)
                val _component_slider = resolveComponent("slider")
                return _cE("view", null, _uA(
                    _cV(_component_page_head, _uM("title" to unref(title)), null, 8, _uA(
                        "title"
                    )),
                    _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                        _cE("text", null, " 注意：1.离开当前页面后背景音乐将保持播放；\n 2. 硬退出app、调用stop api、播放结束都会清理后台控制中心和锁屏信息显示 "),
                        _cV(_component_boolean_data, _uM("defaultValue" to false, "title" to "是否循环播放", "onChange" to setLoop)),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cV(_component_slider, _uM("ref_key" to "sliderRef", "ref" to sliderRef, "value" to unref(position), "min" to 0, "max" to unref(duration), "onChanging" to onchanging, "onChange" to onchange), null, 8, _uA(
                                "value",
                                "max"
                            ))
                        )),
                        _cE("view", _uM("class" to "page-body-buttons"), _uA(
                            if (isTrue(unref(playing))) {
                                _cE(Fragment, _uM("key" to 0), _uA(
                                    _cE("view", _uM("class" to "page-body-button", "onClick" to stop), _uA(
                                        _cE("image", _uM("class" to "image", "src" to "/static/test-audio/stop.png"))
                                    )),
                                    _cE("view", _uM("class" to "page-body-button", "onClick" to pause, "style" to _nS(_uM("margin-top" to "20px"))), _uA(
                                        _cE("image", _uM("class" to "image", "src" to "/static/test-audio/pause.png"))
                                    ), 4)
                                ), 64)
                            } else {
                                _cC("v-if", true)
                            }
                            ,
                            if (isTrue(!unref(playing))) {
                                _cE("view", _uM("key" to 1, "class" to "page-body-button", "onClick" to play), _uA(
                                    _cE("image", _uM("class" to "image", "src" to "/static/test-audio/play.png"))
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                            ,
                            _cE("view", _uM("class" to "page-body-button"))
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
                return _uM("image" to _pS(_uM("width" to 75, "height" to 75)), "page-body-text" to _pS(_uM("paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 15)), "page-body-wrapper" to _pS(_uM("marginTop" to 0)), "page-body-info" to _pS(_uM("paddingBottom" to 25)), "time-big" to _pS(_uM("fontSize" to 30, "marginTop" to 10, "marginRight" to 10, "marginBottom" to 10, "marginLeft" to 10)), "slider" to _pS(_uM("width" to 315)), "play-time" to _pS(_uM("width" to "100%", "paddingTop" to 10, "paddingRight" to 0, "paddingBottom" to 10, "paddingLeft" to 0, "display" to "flex", "justifyContent" to "space-between", "boxSizing" to "border-box")), "page-body-buttons" to _pS(_uM("display" to "flex", "justifyContent" to "center", "marginTop" to 50, "flexDirection" to "column")), "page-body-button" to _pS(_uM("flexDirection" to "row", "justifyContent" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
