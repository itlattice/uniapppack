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
import io.dcloud.uniapp.extapi.chooseFile as uni_chooseFile
import io.dcloud.uniapp.extapi.createInnerAudioContext as uni_createInnerAudioContext
import io.dcloud.uniapp.extapi.previewImage as uni_previewImage
open class GenPagesAPIChooseFileChooseFile : BasePage {
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
        var setup: (__props: GenPagesAPIChooseFileChooseFile) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIChooseFileChooseFile
            val _cache = __ins.renderCache
            val log = ref("")
            val title = ref("choose-file")
            val src = ref("")
            val _audioContext = ref(null as InnerAudioContext?)
            onUnmounted(fun(){
                if (_audioContext.value != null) {
                    _audioContext.value!!.destroy()
                }
            }
            )
            val getPath = fun(chooseFils: UTSArray<ChooseFileTempFile>): String {
                var urls = UTSArray<String>()
                chooseFils.forEach(fun(value){
                    urls.push(value.path)
                }
                )
                return urls.join(", ")
            }
            val chooseVideo = fun(){
                uni_chooseFile(ChooseFileOptions(type = "video", count = 1, success = fun(res){
                    console.log(res)
                    if (res.tempFiles.length > 0) {
                        log.value += getPath(res.tempFiles) + "\n\n"
                    }
                }
                , complete = fun(res){
                    console.log(res)
                }
                ))
            }
            val chooseVideoMul = fun(){
                uni_chooseFile(ChooseFileOptions(type = "video", success = fun(res){
                    console.log(res)
                    if (res.tempFiles.length > 0) {
                        log.value += getPath(res.tempFiles) + "\n\n"
                    }
                }
                , complete = fun(res){
                    console.log(res)
                }
                ))
            }
            val playVideo = fun(){
                uni_chooseFile(ChooseFileOptions(type = "video", count = 1, success = fun(res){
                    console.log(res)
                    if (res.tempFiles.length > 0) {
                        src.value = res.tempFiles[0].path
                        _audioContext.value?.destroy()
                        _audioContext.value = null
                    }
                }
                , complete = fun(res){
                    console.log(res)
                }
                ))
            }
            val chooseImage = fun(){
                uni_chooseFile(ChooseFileOptions(type = "image", count = 1, success = fun(res){
                    console.log(res)
                    if (res.tempFiles.length > 0) {
                        log.value += getPath(res.tempFiles) + "\n\n"
                    }
                }
                , complete = fun(res){
                    console.log(res)
                }
                ))
            }
            val chooseImageMul = fun(){
                uni_chooseFile(ChooseFileOptions(type = "image", count = 90, success = fun(res){
                    console.log(res)
                    if (res.tempFiles.length > 0) {
                        log.value += getPath(res.tempFiles) + "\n\n"
                    }
                }
                , complete = fun(res){
                    console.log(res)
                }
                ))
            }
            val viewImg = fun(){
                uni_chooseFile(ChooseFileOptions(type = "image", success = fun(res){
                    console.log(res)
                    if (res.tempFiles.length > 0) {
                        val tempFiles: UTSArray<String> = res.tempFiles.map(fun(value): String {
                            return value.path
                        }
                        )
                        uni_previewImage(PreviewImageOptions(current = 0, urls = tempFiles, success = fun(res){
                            console.log(res)
                        }
                        , fail = fun(err){
                            console.log(err)
                        }
                        ))
                    }
                }
                , complete = fun(res){
                    console.log(res)
                }
                ))
            }
            val chooseAudio = fun(){
                uni_chooseFile(ChooseFileOptions(type = "audio", count = 1, success = fun(res){
                    console.log(res)
                    if (res.tempFiles.length > 0) {
                        log.value += getPath(res.tempFiles) + "\n\n"
                    }
                }
                , complete = fun(res){
                    console.log(res)
                }
                ))
            }
            val chooseAudioMul = fun(){
                uni_chooseFile(ChooseFileOptions(type = "audio", success = fun(res){
                    console.log(res)
                    if (res.tempFiles.length > 0) {
                        log.value += getPath(res.tempFiles) + "\n\n"
                    }
                }
                , complete = fun(res){
                    console.log(res)
                }
                ))
            }
            val playAudio = fun(){
                uni_chooseFile(ChooseFileOptions(type = "audio", count = 1, success = fun(res){
                    console.log(res)
                    if (res.tempFiles.length > 0) {
                        if (_audioContext.value == null) {
                            src.value = ""
                            _audioContext.value = uni_createInnerAudioContext()
                            _audioContext.value!!.autoplay = true
                        } else if (!_audioContext.value!!.paused) {
                            _audioContext.value!!.stop()
                        }
                        _audioContext.value!!.src = res.tempFiles[0].path
                    }
                }
                , complete = fun(res){
                    console.log(res)
                }
                ))
            }
            val chooseAll = fun(){
                uni_chooseFile(ChooseFileOptions(type = "all", count = 1, success = fun(res){
                    console.log(res)
                    if (res.tempFiles.length > 0) {
                        log.value += getPath(res.tempFiles) + "\n\n"
                    }
                }
                , complete = fun(res){
                    console.log(res)
                }
                ))
            }
            val chooseAllMul = fun(){
                uni_chooseFile(ChooseFileOptions(type = "all", success = fun(res){
                    console.log(res)
                    if (res.tempFiles.length > 0) {
                        log.value += getPath(res.tempFiles) + "\n\n"
                    }
                }
                , complete = fun(res){
                    console.log(res)
                }
                ))
            }
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", null, _uA(
                        _cV(_component_page_head, _uM("title" to unref(title)), null, 8, _uA(
                            "title"
                        )),
                        _cE("button", _uM("size" to "mini", "onClick" to fun(){
                            log.value = ""
                        }
                        ), "清空日志", 8, _uA(
                            "onClick"
                        )),
                        _cE("text", _uM("style" to _nS(_uM("margin" to "2px", "padding" to "2px", "border" to "1px solid #000000"))), _tD(unref(log)), 5),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to chooseVideo), "选择文件(video) 单选"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to chooseVideoMul), "选择文件(video) 多选"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to playVideo), "选择文件(video)并播放"),
                        _cE("video", _uM("class" to "video", "src" to unref(src), "controls" to true, "autoplay" to true, "loop" to true), "111", 8, _uA(
                            "src"
                        )),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to chooseImage), "选择文件(image) 单选"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to chooseImageMul), "选择文件(image) 多选"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to viewImg), "选择文件(image) 并预览"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to chooseAudio), "选择文件(audio) 单选"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to chooseAudioMul), "选择文件(audio) 多选"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to playAudio), "选择文件(audio) 并播放"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to chooseAll), "选择文件(all) 单选"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to chooseAllMul), "选择文件(all) 多选"),
                        _cE("view", _uM("style" to _nS(_uM("height" to "4px"))), null, 4)
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
                return _uM("btnstyle" to _pS(_uM("marginTop" to 4, "marginRight" to 4, "marginBottom" to 4, "marginLeft" to 4)), "video" to _pS(_uM("width" to "100%", "height" to 225)), "uni-uploader__input-box" to _pS(_uM("marginTop" to 5, "marginRight" to 5, "marginBottom" to 5, "marginLeft" to 5, "width" to 104, "height" to 104, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#D9D9D9", "borderRightColor" to "#D9D9D9", "borderBottomColor" to "#D9D9D9", "borderLeftColor" to "#D9D9D9")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
