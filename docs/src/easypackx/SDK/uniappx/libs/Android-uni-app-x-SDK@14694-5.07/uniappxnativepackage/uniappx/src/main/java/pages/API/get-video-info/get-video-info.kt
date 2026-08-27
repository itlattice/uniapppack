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
import io.dcloud.uniapp.extapi.chooseVideo as uni_chooseVideo
import io.dcloud.uniapp.extapi.getVideoInfo as uni_getVideoInfo
import io.dcloud.uniapp.extapi.showModal as uni_showModal
open class GenPagesAPIGetVideoInfoGetVideoInfo : BasePage {
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
    open var testState: TestStateType__2
        get() {
            return unref(this.`$exposed`["testState"]) as TestStateType__2
        }
        set(value) {
            setRefValue(this.`$exposed`, "testState", value)
        }
    open var testGetVideoInfo: () -> Unit
        get() {
            return unref(this.`$exposed`["testGetVideoInfo"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "testGetVideoInfo", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIGetVideoInfoGetVideoInfo, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIGetVideoInfoGetVideoInfo
            val _cache = __ins.renderCache
            val title = ref("getVideoInfo")
            val relativeVideoPath = ref("/static/test-video/10second-demo.mp4")
            val relativeVideoInfo = ref("")
            val relativeCoverImagePath = ref("")
            val absoluteVideoPath = ref("")
            val absoluteVideoInfo = ref("")
            val absoluteCoverImagePath = ref("")
            val testState = reactive(TestStateType__2(videoInfoForTest = null as UTSJSONObject?))
            val needLoadOnReady = ref(true)
            onLoad(fun(event: OnLoadOptions){
                needLoadOnReady.value = (event["is_debug"] ?: "1") == "1"
            }
            )
            onReady(fun(){
                if (!needLoadOnReady.value) {
                    return
                }
                uni_getVideoInfo(GetVideoInfoOptions(src = relativeVideoPath.value, success = fun(res){
                    console.log("getVideoInfo success", JSON.stringify(res))
                    relativeVideoInfo.value = "视频画面方向: " + res.orientation + "\n视频格式: " + res.type + "\n视频长度: " + res.duration + "s\n视频大小: " + res.size + "KB\n视频宽度: " + res.width + "\n视频高度: " + res.height + "\n视频帧率: " + res.fps + "fps\n视频码率: " + res.bitrate + "kbps"
                    relativeVideoInfo.value = relativeVideoInfo.value + ("\n视频字节大小: " + res.byteSize + "B\n视频首帧图片路径: " + res.thumbTempFilePath)
                    if (res.thumbTempFilePath != null) {
                        relativeCoverImagePath.value = res.thumbTempFilePath!!
                    }
                }
                , fail = fun(err){
                    uni_showModal(ShowModalOptions(title = "获取视频信息失败", content = JSON.stringify(err), showCancel = false))
                }
                ))
            }
            )
            val chooseVideo = fun(){
                uni_chooseVideo(ChooseVideoOptions(compressed = false, success = fun(res){
                    absoluteVideoPath.value = res.tempFilePath
                    uni_getVideoInfo(GetVideoInfoOptions(src = res.tempFilePath, success = fun(_res){
                        console.log("getVideoInfo success", JSON.stringify(_res))
                        absoluteVideoInfo.value = "视频画面方向: " + _res.orientation + "\n视频格式: " + _res.type + "\n视频长度: " + _res.duration + "s\n视频大小: " + _res.size + "KB\n视频宽度: " + _res.width + "\n视频高度: " + _res.height + "\n视频帧率: " + _res.fps + "fps\n视频码率: " + _res.bitrate + "kbps"
                        absoluteVideoInfo.value = absoluteVideoInfo.value + ("\n视频字节大小: " + _res.byteSize + "B\n视频首帧图片路径: " + _res.thumbTempFilePath)
                        if (_res.thumbTempFilePath != null) {
                            absoluteCoverImagePath.value = _res.thumbTempFilePath!!
                        }
                    }
                    , fail = fun(err){
                        uni_showModal(ShowModalOptions(title = "获取视频信息失败", content = JSON.stringify(err), showCancel = false))
                    }
                    ))
                }
                ))
            }
            val testGetVideoInfo = fun(){
                uni_getVideoInfo(GetVideoInfoOptions(src = "/static/test-video/10second-demo.mp4", success = fun(res){
                    testState.videoInfoForTest = _uO("orientation" to res.orientation, "type" to res.type, "duration" to Math.trunc(res.duration), "size" to res.size, "width" to res.width, "height" to res.height, "fps" to res.fps, "bitrate" to res.bitrate)
                }
                , fail = fun(_){
                    testState.videoInfoForTest = null
                }
                ))
            }
            __expose(_uM("testState" to testState, "testGetVideoInfo" to testGetVideoInfo))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cV(_component_page_head, _uM("title" to unref(title)), null, 8, _uA(
                        "title"
                    )),
                    _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                        _cE("view", _uM("class" to "uni-title"), _uA(
                            _cE("text", _uM("class" to "uni-subtitle-text"), "获取本地绝对路径视频信息")
                        )),
                        _cE("video", _uM("class" to "video", "src" to unref(absoluteVideoPath), "controls" to true, "poster" to unref(absoluteCoverImagePath)), null, 8, _uA(
                            "src",
                            "poster"
                        )),
                        _cE("text", _uM("class" to "margin-top-10"), _tD(unref(absoluteVideoInfo)), 1),
                        _cE("view", _uM("class" to "uni-btn-v"), _uA(
                            _cE("button", _uM("type" to "primary", "onClick" to chooseVideo), "拍摄视频或从相册中选择视频")
                        ))
                    )),
                    _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                        _cE("view", _uM("class" to "uni-title"), _uA(
                            _cE("text", _uM("class" to "uni-subtitle-text"), "获取本地相对路径视频信息")
                        )),
                        _cE("video", _uM("class" to "video", "src" to unref(relativeVideoPath), "controls" to true, "poster" to unref(relativeCoverImagePath)), null, 8, _uA(
                            "src",
                            "poster"
                        )),
                        _cE("text", _uM("class" to "margin-top-10"), _tD(unref(relativeVideoInfo)), 1)
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
                return _uM("video" to _pS(_uM("width" to "100%")), "margin-top-10" to _pS(_uM("marginTop" to 10)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
