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
import io.dcloud.uniapp.extapi.compressVideo as uni_compressVideo
import io.dcloud.uniapp.extapi.getVideoInfo as uni_getVideoInfo
import io.dcloud.uniapp.extapi.hideLoading as uni_hideLoading
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading
import io.dcloud.uniapp.extapi.showModal as uni_showModal
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesAPICompressVideoCompressVideo : BasePage {
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
    open var testState: TestStateType__1
        get() {
            return unref(this.`$exposed`["testState"]) as TestStateType__1
        }
        set(value) {
            setRefValue(this.`$exposed`, "testState", value)
        }
    open var testCompressVideo: () -> Unit
        get() {
            return unref(this.`$exposed`["testCompressVideo"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "testCompressVideo", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPICompressVideoCompressVideo, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPICompressVideoCompressVideo
            val _cache = __ins.renderCache
            val title = ref("compressVideo")
            val beforeCompressVideoInfo = ref("")
            val afterCompressVideoInfo = ref("")
            val beforeCompressPath = ref("")
            val afterCompressPath = ref("")
            val beforeCoverImagePath = ref("")
            val afterCoverImagePath = ref("")
            val qualityItemTypes = ref(_uA<ItemType>(ItemType(value = 0, name = "low(低)"), ItemType(value = 1, name = "medium(中)"), ItemType(value = 2, name = "high(高)")))
            val qualityItems = ref(_uA(
                "low",
                "medium",
                "high"
            ))
            val quality = ref(null as String?)
            val bitrate = ref(null as Number?)
            val fps = ref(null as Number?)
            val resolution = ref(null as Number?)
            val videoSrcForTest = ref("/static/test-video/10second-demo.mp4")
            val testState = reactive(TestStateType__1(videoInfoForTest = null as VideoInfoForTest?, videoSrcForTestWidth = 0, videoSrcForTestHeight = 0))
            val compressVideo = fun(){
                if (beforeCompressPath.value == "") {
                    uni_showToast(ShowToastOptions(title = "请先选择视频", icon = "error"))
                    return
                }
                uni_showLoading(ShowLoadingOptions(title = "视频压缩中"))
                uni_compressVideo(CompressVideoOptions(src = beforeCompressPath.value, quality = quality.value, resolution = resolution.value, success = fun(res){
                    console.log("compressVideo success", JSON.stringify(res))
                    afterCompressPath.value = res.tempFilePath
                    uni_showToast(ShowToastOptions(title = "压缩成功", icon = null))
                    uni_getVideoInfo(GetVideoInfoOptions(src = res.tempFilePath, success = fun(_res){
                        afterCompressVideoInfo.value = "视频画面方向: " + _res.orientation + "\n视频格式: " + _res.type + "\n视频长度: " + _res.duration + "s\n视频大小: " + _res.size + "KB\n视频宽度: " + _res.width + "\n视频高度: " + _res.height + "\n视频帧率: " + _res.fps + "fps\n视频码率: " + _res.bitrate + "kbps"
                        afterCompressVideoInfo.value = afterCompressVideoInfo.value + ("\n视频字节大小: " + _res.byteSize + "B\n视频首帧图片路径: " + _res.thumbTempFilePath)
                        if (_res.thumbTempFilePath != null) {
                            afterCoverImagePath.value = _res.thumbTempFilePath!!
                        }
                    }
                    ))
                }
                , fail = fun(err){
                    uni_showModal(ShowModalOptions(title = "压缩视频失败", content = JSON.stringify(err), showCancel = false))
                }
                , complete = fun(_){
                    uni_hideLoading(null)
                }
                ))
            }
            val chooseVideo = fun(){
                uni_chooseVideo(ChooseVideoOptions(sourceType = _uA(
                    "album"
                ), compressed = false, success = fun(res){
                    beforeCompressPath.value = res.tempFilePath
                    uni_getVideoInfo(GetVideoInfoOptions(src = res.tempFilePath, success = fun(_res){
                        beforeCompressVideoInfo.value = "视频画面方向: " + _res.orientation + "\n视频格式: " + _res.type + "\n视频长度: " + _res.duration + "s\n视频大小: " + _res.size + "KB\n视频宽度: " + _res.width + "\n视频高度: " + _res.height + "\n视频帧率: " + _res.fps + "fps\n视频码率: " + _res.bitrate + "kbps"
                        beforeCompressVideoInfo.value = beforeCompressVideoInfo.value + ("\n视频字节大小: " + _res.byteSize + "B\n视频首帧图片路径: " + _res.thumbTempFilePath)
                        if (_res.thumbTempFilePath != null) {
                            beforeCoverImagePath.value = _res.thumbTempFilePath!!
                        }
                    }
                    ))
                }
                ))
            }
            val onQualityChange = fun(value: Number){
                quality.value = qualityItems.value[value]
            }
            val onResolutionChange = fun(event: UniSliderChangeEvent){
                resolution.value = event.detail.value
            }
            val testCompressVideo = fun(){
                var beforeCompressSize: Number
                var afterComoressSize: Number
                uni_compressVideo(CompressVideoOptions(src = videoSrcForTest.value, quality = "medium", success = fun(res){
                    uni_getVideoInfo(GetVideoInfoOptions(src = videoSrcForTest.value, success = fun(_res){
                        beforeCompressSize = Math.trunc(_res.size)
                        testState.videoSrcForTestWidth = _res.width
                        testState.videoSrcForTestHeight = _res.height
                        uni_getVideoInfo(GetVideoInfoOptions(src = res.tempFilePath, success = fun(__res){
                            afterComoressSize = Math.trunc(__res.size)
                            testState.videoInfoForTest = VideoInfoForTest(width = __res.width, height = __res.height, isSizeReduce = afterComoressSize < beforeCompressSize)
                        }
                        , fail = fun(err) {
                            console.log(">>>>>> 压缩失败", err.errMsg)
                        }
                        ))
                    }
                    ))
                }
                , fail = fun(_){
                    testState.videoInfoForTest = null
                }
                ))
            }
            __expose(_uM("testState" to testState, "testCompressVideo" to testCompressVideo))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_slider = resolveComponent("slider")
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cV(_component_page_head, _uM("title" to unref(title)), null, 8, _uA(
                        "title"
                    )),
                    _cE("view", null, _uA(
                        _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                            _cE("video", _uM("class" to "video", "src" to unref(beforeCompressPath), "controls" to true, "poster" to unref(beforeCoverImagePath)), null, 8, _uA(
                                "src",
                                "poster"
                            )),
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "压缩前视频信息")
                            )),
                            _cE("text", null, _tD(unref(beforeCompressVideoInfo)), 1),
                            _cE("video", _uM("class" to "video", "src" to unref(afterCompressPath), "controls" to true, "poster" to unref(afterCoverImagePath)), null, 8, _uA(
                                "src",
                                "poster"
                            )),
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "压缩后视频信息")
                            )),
                            _cE("text", null, _tD(unref(afterCompressVideoInfo)), 1),
                            _cE("view", _uM("class" to "uni-btn-v"), _uA(
                                _cE("button", _uM("type" to "primary", "onClick" to chooseVideo), "从相册中选取待压缩的视频")
                            )),
                            _cE("view", _uM("class" to "uni-btn-v"), _uA(
                                _cE("button", _uM("type" to "primary", "onClick" to compressVideo), "压缩视频")
                            )),
                            _cV(_component_enum_data, _uM("title" to "压缩质量", "items" to unref(qualityItemTypes), "onChange" to onQualityChange), null, 8, _uA(
                                "items"
                            )),
                            _cE("view", _uM("class" to "uni-common-mt"), _uA(
                                _cE("text", _uM("class" to "uni-title uni-title-text"), "相对于原视频的分辨率比例，取值范围(0, 1]"),
                                _cV(_component_slider, _uM("min" to 0.1, "max" to 1, "step" to 0.1, "show-value" to true, "onChange" to onResolutionChange))
                            ))
                        ))
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
                return _uM("video" to _pS(_uM("alignSelf" to "center")), "image-container" to _pS(_uM("flexDirection" to "row")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
