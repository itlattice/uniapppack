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
import io.dcloud.uniapp.extapi.env as uni_env
import io.dcloud.uniapp.extapi.getFileSystemManager as uni_getFileSystemManager
open class GenPagesAPICreateInnerAudioContextInnerAudioPath : BasePage {
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
        var setup: (__props: GenPagesAPICreateInnerAudioContextInnerAudioPath) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPICreateInnerAudioContextInnerAudioPath
            val _cache = __ins.renderCache
            val title = ref("audio-path")
            val playIndex = ref(0)
            val isPlaying = ref(false)
            val nativePath = ref(uni_env.CACHE_PATH + "uni-audio/test/test.mp3" as String)
            val _audioContext = ref(null as InnerAudioContext?)
            val supportPaths = ref(_uA<AudioPath>(AudioPath(description = "本地路径：/static方式", src = "/static/test-audio/ForElise.mp3"), AudioPath(description = "本地路径：../static/", src = "../../../static/test-audio/ForElise.mp3"), AudioPath(description = "本地路径：env方式", src = "env"), AudioPath(description = "网络路径", src = "https://web-ext-storage.dcloud.net.cn/uni-app-x/audio/ForElise.mp3"), AudioPath(description = "不存在的音频", src = "https://web-ext-storage.dcloud.net.cn/uni-app-x/audio/invalid_url.mp3"), AudioPath(description = "错误路径", src = "../static/test-audio/ForElise22.mp3")))
            fun gen_pause_fn() {
                _audioContext.value!!.pause()
                isPlaying.value = false
            }
            val pause = ::gen_pause_fn
            fun gen_play_fn(reassignedAudioUrl: String, index: Number) {
                var audioUrl = reassignedAudioUrl
                console.log(index, audioUrl)
                if (isPlaying.value && playIndex.value == index) {
                    pause()
                    return
                }
                if (audioUrl == "env") {
                    audioUrl = nativePath.value
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
                val fileManager = uni_getFileSystemManager()
                fileManager.mkdir(MkDirOptions(dirPath = uni_env.CACHE_PATH + "uni-audio/test", recursive = true, success = fun(res){
                    fileManager.copyFile(CopyFileOptions(srcPath = "/static/test-audio/ForElise.mp3", destPath = nativePath.value, success = fun(_res){
                        console.log("copy成功： ", res)
                    }
                    ))
                }
                , fail = fun(err){
                    console.log("创建路径失败： ", err.errMsg)
                    if (err.errMsg.includes("file already exists")) {
                        console.log("已经包含该路径")
                        fileManager.copyFile(CopyFileOptions(srcPath = "/static/test-audio/ForElise.mp3", destPath = nativePath.value, success = fun(res){
                            console.log("copy成功： ", res)
                        }
                        , fail = fun(err){
                            console.log("copy失败： ", err)
                        }
                        ))
                    }
                }
                ))
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
                    _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt"), _uA(
                        _cE("view", _uM("class" to "uni-title"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "音频路径示例")
                        )),
                        _cE(Fragment, null, RenderHelpers.renderList(unref(supportPaths), fun(item, index, __index, _cached): Any {
                            return _cE("view", _uM("class" to "formats", "key" to index), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), _tD(item.description), 1),
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
