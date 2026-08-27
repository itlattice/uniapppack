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
open class GenPagesAPIChooseVideoChooseVideo : BasePage {
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
        var setup: (__props: GenPagesAPIChooseVideoChooseVideo) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIChooseVideoChooseVideo
            val _cache = __ins.renderCache
            val title = ref("chooseVideo")
            val src = ref("")
            val orientationTypeItemTypes = ref(_uA<ItemType>(ItemType(value = 0, name = "竖屏"), ItemType(value = 1, name = "横屏"), ItemType(value = 2, name = "自动")))
            val sourceTypeItemTypes = ref(_uA<ItemType>(ItemType(value = 0, name = "从相册中选择视频"), ItemType(value = 1, name = "拍摄视频"), ItemType(value = 2, name = "从相册中选择视频或拍摄视频")))
            val sourceTypeItems = ref(_uA<UTSArray<Source>>(_uA(
                "album"
            ), _uA(
                "camera"
            ), _uA(
                "album",
                "camera"
            )))
            val cameraItemTypes = ref(_uA<ItemType>(ItemType(value = 0, name = "后置摄像头"), ItemType(value = 1, name = "前置摄像头")))
            val albumModeTypes = ref(_uA<ItemType>(ItemType(value = 0, name = "自定义视频选择器"), ItemType(value = 1, name = "系统视频选择器")))
            val albumModeTypeItems = ref(_uA(
                "custom",
                "system"
            ))
            val cameraItems = ref(_uA<Camera>("back", "front"))
            val sourceType = ref(_uA<Source>("album", "camera"))
            val orientationType = ref("portrait")
            val orientationTypeItems = ref(_uA(
                "portrait",
                "landscape",
                "auto"
            ))
            val compressed = ref(true)
            val maxDuration = ref(60)
            val camera = ref("back" as Camera)
            val videoInfo = ref("")
            val videoCoverImage = ref("")
            val albumMode = ref("custom")
            onPageHide(fun(){
                console.log("Page Hide")
            }
            )
            val chooseVideo = fun(){
                uni_chooseVideo(ChooseVideoOptions(sourceType = sourceType.value, compressed = compressed.value, pageOrientation = orientationType.value, maxDuration = maxDuration.value, albumMode = albumMode.value, camera = camera.value, success = fun(res){
                    console.log("chooseVideo success", JSON.stringify(res))
                    src.value = res.tempFilePath
                    videoInfo.value = "视频长度: " + res.duration + "s\n视频大小: " + Math.ceil(res.size) + "KB\n视频宽度: " + res.width + "\n视频高度: " + res.height + "\n"
                    uni_getVideoInfo(GetVideoInfoOptions(src = res.tempFilePath, success = fun(_res){
                        if (_res.thumbTempFilePath != null) {
                            videoCoverImage.value = _res.thumbTempFilePath!!
                        }
                    }
                    ))
                }
                , fail = fun(err){
                    uni_showModal(ShowModalOptions(title = "选择视频失败", content = JSON.stringify(err), showCancel = false))
                }
                ))
            }
            val onOrientationTypeChange = fun(value: Number){
                orientationType.value = orientationTypeItems.value[value]
            }
            val onSourceTypeChange = fun(value: Number){
                sourceType.value = sourceTypeItems.value[value]
            }
            val onCompressedChange = fun(value: Boolean){
                compressed.value = value
            }
            val onMaxDurationConfirm = fun(value: Number){
                maxDuration.value = value
            }
            val onCameraChange = fun(value: Number){
                camera.value = cameraItems.value[value]
            }
            val onAlbumModeChange = fun(value: Number){
                albumMode.value = albumModeTypeItems.value[value]
            }
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                val _component_boolean_data = resolveEasyComponent("boolean-data", GenComponentsBooleanDataBooleanDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cV(_component_page_head, _uM("title" to unref(title)), null, 8, _uA(
                        "title"
                    )),
                    _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                        _cE("video", _uM("class" to "video", "src" to unref(src), "controls" to true, "poster" to unref(videoCoverImage)), null, 8, _uA(
                            "src",
                            "poster"
                        )),
                        _cE("view", _uM("class" to "uni-title"), _uA(
                            _cE("text", _uM("class" to "uni-subtitle-text"), "视频信息")
                        )),
                        _cE("text", null, _tD(unref(videoInfo)), 1),
                        _cE("view", _uM("class" to "uni-btn-v"), _uA(
                            _cE("button", _uM("type" to "primary", "onClick" to chooseVideo), "选取视频")
                        )),
                        _cV(_component_enum_data, _uM("title" to "视频来源", "items" to unref(sourceTypeItemTypes), "onChange" to onSourceTypeChange), null, 8, _uA(
                            "items"
                        )),
                        _cV(_component_enum_data, _uM("title" to "屏幕方向", "items" to unref(orientationTypeItemTypes), "onChange" to onOrientationTypeChange), null, 8, _uA(
                            "items"
                        )),
                        _cV(_component_enum_data, _uM("title" to "摄像头", "items" to unref(cameraItemTypes), "onChange" to onCameraChange), null, 8, _uA(
                            "items"
                        )),
                        _cV(_component_enum_data, _uM("title" to "相册模式", "items" to unref(albumModeTypes), "onChange" to onAlbumModeChange), null, 8, _uA(
                            "items"
                        ))
                    )),
                    _cV(_component_input_data, _uM("title" to "最长拍摄时间，单位秒", "defaultValue" to "60", "type" to "number", "onConfirm" to onMaxDurationConfirm)),
                    _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                        _cV(_component_boolean_data, _uM("title" to "是否压缩（HamonyOS 不支持，推荐使用 uni.compressVideo 进行压缩）", "defaultValue" to true, "onChange" to onCompressedChange))
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
                return _uM("video" to _pS(_uM("alignSelf" to "center", "width" to 300, "height" to 225)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
