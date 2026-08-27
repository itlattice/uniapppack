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
open class GenPagesAPICreateInnerAudioContextInnerAudioFormat : BasePage {
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
        var setup: (__props: GenPagesAPICreateInnerAudioContextInnerAudioFormat) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPICreateInnerAudioContextInnerAudioFormat
            val _cache = __ins.renderCache
            val title = ref("audio-format")
            val playIndex = ref(0)
            val isPlaying = ref(false)
            val _audioContext = ref(null as InnerAudioContext?)
            val supportFormats = ref(_uA<AudioFormat>(AudioFormat(format = "mp3", src = "https://web-ext-storage.dcloud.net.cn/uni-app-x/audio/ForElise.mp3"), AudioFormat(format = "mp4", src = "https://web-ext-storage.dcloud.net.cn/uni-app-x/audio/ForElise.mp4"), AudioFormat(format = "m4a", src = "https://web-ext-storage.dcloud.net.cn/uni-app-x/audio/ForElise.m4a"), AudioFormat(format = "aac", src = "https://web-ext-storage.dcloud.net.cn/uni-app-x/audio/ForElise.aac"), AudioFormat(format = "flac", src = "https://web-ext-storage.dcloud.net.cn/uni-app-x/audio/ForElise.flac"), AudioFormat(format = "wav", src = "https://web-ext-storage.dcloud.net.cn/uni-app-x/audio/ForElise.wav"), AudioFormat(format = "m3u8", src = "https://qiniu-web-assets.dcloud.net.cn/audio/sample/m3u8/ForElise.m3u8")))
            val notSupportFormats = ref(_uA<AudioFormat>(AudioFormat(format = "ogg", support = "(iOS 不支持)", src = "https://web-ext-storage.dcloud.net.cn/uni-app-x/audio/ForElise.ogg"), AudioFormat(format = "wma", support = "(iOS/Android/web/Harmony 不支持)", src = "https://web-ext-storage.dcloud.net.cn/uni-app-x/audio/ForElise.wma"), AudioFormat(format = "aiff", support = "(Android/web/Harmony 不支持)", src = "https://web-ext-storage.dcloud.net.cn/uni-app-x/audio/ForElise.aiff"), AudioFormat(format = "caf", support = "(Android/web/Harmony 不支持)", src = "https://web-ext-storage.dcloud.net.cn/uni-app-x/audio/ForElise.caf"), AudioFormat(format = "dash", support = "(iOS 不支持)", src = "https://qiniu-web-assets.dcloud.net.cn/audio/sample/dash/ForElise.mpd"), AudioFormat(format = "错误格式", support = "(iOS/Android/web/Harmony 不支持)", src = "https://web-ext-storage.dcloud.net.cn/uni-app-x/audio/ForElise.wmaa")))
            fun gen_pause_fn() {
                _audioContext.value!!.pause()
                isPlaying.value = false
            }
            val pause = ::gen_pause_fn
            fun gen_play_fn(audioUrl: String, index: Number) {
                if (isPlaying.value && playIndex.value == index) {
                    pause()
                    return
                }
                playIndex.value = index
                _audioContext.value!!.src = audioUrl
                _audioContext.value!!.play()
                isPlaying.value = true
            }
            val play = ::gen_play_fn
            onReady(fun(){
                _audioContext.value = uni_createInnerAudioContext()
                _audioContext.value!!.onPlay(fun(_result){
                    console.log("开始播放")
                }
                )
                _audioContext.value!!.onPause(fun(_result){
                    console.log("播放暂停")
                }
                )
                _audioContext.value!!.onEnded(fun(_result){
                    console.log("播放结束")
                    isPlaying.value = false
                }
                )
                _audioContext.value!!.onError(fun(err){
                    isPlaying.value = false
                    console.log("err", err)
                }
                )
            }
            )
            onUnload(fun(){
                if (_audioContext.value != null) {
                    pause()
                    _audioContext.value!!.destroy()
                }
            }
            )
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE(Fragment, null, _uA(
                    _cV(_component_page_head, _uM("title" to unref(title)), null, 8, _uA(
                        "title"
                    )),
                    _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                        _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt"), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(unref(supportFormats), fun(item, index, __index, _cached): Any {
                                return _cE("view", _uM("class" to "formats", "key" to index), _uA(
                                    _cE("text", _uM("class" to "uni-subtitle-text"), _tD(item.format), 1),
                                    _cE("image", _uM("class" to "icon-play", "src" to if ((unref(isPlaying) && unref(playIndex) == index)) {
                                        "/static/test-audio/pause.png"
                                    } else {
                                        "/static/test-audio/play.png"
                                    }
                                    , "onClick" to fun(){
                                        play(item.src, index)
                                    }
                                    ), null, 8, _uA(
                                        "src",
                                        "onClick"
                                    ))
                                ))
                            }
                            ), 128),
                            _cE(Fragment, null, RenderHelpers.renderList(unref(notSupportFormats), fun(item, index, __index, _cached): Any {
                                return _cE("view", _uM("class" to "formats", "key" to index), _uA(
                                    _cE("text", _uM("class" to "uni-subtitle-text"), _tD(item.format + item.support), 1),
                                    _cE("image", _uM("class" to "icon-play", "src" to if ((unref(isPlaying) && unref(playIndex) == index)) {
                                        "/static/test-audio/pause.png"
                                    } else {
                                        "/static/test-audio/play.png"
                                    }
                                    , "onClick" to fun(){
                                        play(item.src, index)
                                    }
                                    ), null, 8, _uA(
                                        "src",
                                        "onClick"
                                    ))
                                ))
                            }
                            ), 128)
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
                return _uM("formats" to _pS(_uM("alignItems" to "center")), "icon-play" to _pS(_uM("width" to 60, "height" to 60, "marginTop" to 10, "marginRight" to 10, "marginBottom" to 10, "marginLeft" to 10)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
