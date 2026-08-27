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
import io.dcloud.uniapp.extapi.`$emit` as uni__emit
import io.dcloud.uniapp.extapi.`$once` as uni__once
import io.dcloud.uniapp.extapi.chooseMedia as uni_chooseMedia
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
import io.dcloud.uniapp.extapi.previewImage as uni_previewImage
import io.dcloud.uniapp.extapi.showActionSheet as uni_showActionSheet
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesAPIChooseMediaChooseMedia : BasePage {
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
        var setup: (__props: GenPagesAPIChooseMediaChooseMedia) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIChooseMediaChooseMedia
            val _cache = __ins.renderCache
            val sourceTypeList = _uA(
                ChooseSource(value = _uA(
                    "camera"
                ), title = "拍摄"),
                ChooseSource(value = _uA(
                    "album"
                ), title = "相册"),
                ChooseSource(value = _uA(
                    "camera",
                    "album"
                ), title = "拍摄或相册")
            ) as UTSArray<ChooseSource>
            val mediaTypeList = _uA(
                ChooseSource(value = _uA(
                    "image"
                ), title = "仅图片"),
                ChooseSource(value = _uA(
                    "video"
                ), title = "仅视频"),
                ChooseSource(value = _uA(
                    "image",
                    "video"
                ), title = "不限制")
            ) as UTSArray<ChooseSource>
            val orientationTypeList = _uA(
                ChooseSource(value = _uA(
                    "portrait"
                ), title = "竖屏"),
                ChooseSource(value = _uA(
                    "landscape"
                ), title = "横屏"),
                ChooseSource(value = _uA(
                    "auto"
                ), title = "自动")
            ) as UTSArray<ChooseSource>
            val cameraTypeList = _uA(
                ChooseSource(value = _uA(
                    "front"
                ), title = "前置摄像头"),
                ChooseSource(value = _uA(
                    "back"
                ), title = "后置摄像头")
            ) as UTSArray<ChooseSource>
            val title = ref("chooseMedia")
            val mediaList = ref(_uA<FileSource>())
            val sourceTypeIndex = ref(2)
            val mediaTypeIndex = ref(2)
            val cameraTypeIndex = ref(1)
            val orientationTypeIndex = ref(0)
            val albumModeTypeIndex = ref(0)
            val count = ref(9)
            val maxDuration = ref(10)
            val sourceTypes = ref(sourceTypeList as UTSArray<ChooseSource>)
            val mediaTypes = ref(mediaTypeList as UTSArray<ChooseSource>)
            val cameraTypes = ref(cameraTypeList as UTSArray<ChooseSource>)
            val orientationTypes = ref(orientationTypeList as UTSArray<ChooseSource>)
            val refCountInput = ref<UniElement?>(null)
            val chooseMediaSource = fun(){
                uni_showActionSheet(ShowActionSheetOptions(itemList = _uA(
                    "拍摄",
                    "相册",
                    "拍摄或相册"
                ), success = fun(e){
                    sourceTypeIndex.value = e.tapIndex
                }
                ))
            }
            val chooseMediaType = fun(){
                uni_showActionSheet(ShowActionSheetOptions(itemList = _uA(
                    "仅图片",
                    "仅视频",
                    "不限制"
                ), success = fun(e){
                    mediaTypeIndex.value = e.tapIndex
                }
                ))
            }
            val chooseMediaCount = fun(event: UniInputBlurEvent){
                var countValue = parseInt(event.detail.value)
                if (countValue < 1 || countValue > 9 || isNaN(countValue)) {
                    uni_showToast(ShowToastOptions(position = "bottom", title = "图片数量应该不小于1不大于9"))
                    return
                }
                count.value = countValue
            }
            val chooseOrientationType = fun(){
                uni_showActionSheet(ShowActionSheetOptions(itemList = _uA(
                    "竖屏",
                    "横屏",
                    "自动"
                ), success = fun(e){
                    orientationTypeIndex.value = e.tapIndex
                }
                ))
            }
            val chooseCameraType = fun(){
                uni_showActionSheet(ShowActionSheetOptions(itemList = _uA(
                    "前置",
                    "后置"
                ), success = fun(e){
                    cameraTypeIndex.value = e.tapIndex
                }
                ))
            }
            val chooseMedia = fun(){
                if (mediaList.value.length >= count.value) {
                    val message = "已经有" + count.value + "个了，请删除部分后重新选择"
                    uni_showToast(ShowToastOptions(position = "bottom", title = message))
                    return
                }
                uni_chooseMedia(ChooseMediaOptions(count = count.value - mediaList.value.length, sourceType = sourceTypeList[sourceTypeIndex.value].value, mediaType = mediaTypeList[mediaTypeIndex.value].value, camera = cameraTypeList[cameraTypeIndex.value].value[0], pageOrientation = orientationTypeList[orientationTypeIndex.value].value[0], success = fun(res){
                    val tempFiles: UTSArray<ChooseMediaTempFile> = res.tempFiles as UTSArray<ChooseMediaTempFile>
                    run {
                        var i: Number = 0
                        while(i < tempFiles.length){
                            val tempFile: ChooseMediaTempFile = tempFiles[i]
                            val imagePath = if (tempFile.fileType == "image") {
                                tempFile.tempFilePath
                            } else {
                                tempFile.thumbTempFilePath
                            }
                            val file = FileSource(imagePath = imagePath!!, filePath = tempFile.tempFilePath, fileType = tempFile.fileType)
                            mediaList.value.push(file)
                            i++
                        }
                    }
                }
                , fail = fun(err){
                    console.log("err: ", JSON.stringify(err))
                    uni_showToast(ShowToastOptions(title = "choose media error.code:" + err.errCode + ";message:" + err.errMsg, position = "bottom"))
                }
                ))
            }
            val previewMedia = fun(index: Number){
                val file: FileSource = mediaList.value[index]
                if (file.fileType == "image") {
                    uni_previewImage(PreviewImageOptions(current = 0, urls = _uA(
                        file.filePath
                    )))
                } else {
                    uni__once("__ONFULLVIDEOLOAD", fun(){
                        uni__emit("__ONRECEIVEURL", _uO("url" to file.filePath, "cover" to file.imagePath))
                    }
                    )
                    val url = "/pages/API/choose-media/fullscreen-video"
                    uni_navigateTo(NavigateToOptions(url = url))
                }
            }
            val removeMedia = fun(index: Number){
                mediaList.value.splice(index, 1)
            }
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE("scroll-view", _uM("class" to "page-scroll-view"), _uA(
                    _cE("view", null, _uA(
                        _cV(_component_page_head, _uM("title" to unref(title)), null, 8, _uA(
                            "title"
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("view", _uM("class" to "uni-list"), _uA(
                                _cE("view", _uM("class" to "uni-list-cell cell-pd"), _uA(
                                    _cE("view", _uM("class" to "uni-list-cell-left uni-label"), " 来源 "),
                                    _cE("view", _uM("class" to "uni-list-cell-right", "onClick" to chooseMediaSource), _uA(
                                        _cE("text", _uM("class" to "click-t"), _tD(unref(sourceTypes)[unref(sourceTypeIndex)].title), 1)
                                    ))
                                )),
                                _cE("view", _uM("class" to "uni-list-cell cell-pd"), _uA(
                                    _cE("view", _uM("class" to "uni-list-cell-left uni-label"), " 方式 "),
                                    _cE("view", _uM("class" to "uni-list-cell-right", "onClick" to chooseMediaType), _uA(
                                        _cE("text", _uM("class" to "click-t"), _tD((unref(mediaTypes)[unref(mediaTypeIndex)] as ChooseSource).title), 1)
                                    ))
                                )),
                                _cE("view", _uM("class" to "uni-list-cell cell-pd"), _uA(
                                    _cE("view", _uM("class" to "uni-list-cell-left uni-label"), " 数量限制 "),
                                    _cE("view", _uM("class" to "uni-list-cell-right"), _uA(
                                        _cE("input", _uM("class" to "click-t", "ref_key" to "refCountInput", "ref" to refCountInput, "value" to unref(count), "type" to "number", "maxlength" to 1, "onBlur" to chooseMediaCount), null, 40, _uA(
                                            "value"
                                        ))
                                    ))
                                )),
                                _cE("view", _uM("class" to "uni-list-cell cell-pd"), _uA(
                                    _cE("view", _uM("class" to "uni-list-cell-left uni-label"), " 屏幕方向 "),
                                    _cE("view", _uM("class" to "uni-list-cell-right", "onClick" to chooseOrientationType), _uA(
                                        _cE("text", _uM("class" to "click-t"), _tD(unref(orientationTypes)[unref(orientationTypeIndex)].title), 1)
                                    ))
                                )),
                                _cE("view", _uM("class" to "uni-list-cell cell-pd"), _uA(
                                    _cE("view", _uM("class" to "uni-list-cell-left uni-label"), " 摄像头 "),
                                    _cE("view", _uM("class" to "uni-list-cell-right", "onClick" to chooseCameraType), _uA(
                                        _cE("text", _uM("class" to "click-t"), _tD(unref(cameraTypes)[unref(cameraTypeIndex)].title), 1)
                                    ))
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-list list-pd", "style" to _nS(_uM("padding" to "15px"))), _uA(
                                _cE("view", _uM("class" to "uni-flex", "style" to _nS(_uM("margin-bottom" to "10px"))), _uA(
                                    _cE("view", _uM("class" to "uni-list-cell-left"), "点击预览"),
                                    _cE("view", _uM("style" to _nS(_uM("margin-left" to "auto"))), _uA(
                                        _cE("text", _uM("class" to "click-t"), _tD(unref(mediaList).length) + "/" + _tD(unref(count)), 1)
                                    ), 4)
                                ), 4),
                                _cE("view", _uM("class" to "uni-flex", "style" to _nS(_uM("flex-wrap" to "wrap"))), _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(unref(mediaList), fun(file, index, __index, _cached): Any {
                                        return _cE("view", _uM("key" to index, "class" to "uni-uploader__input-box", "style" to _nS(_uM("border" to "0"))), _uA(
                                            _cE("image", _uM("style" to _nS(_uM("width" to "104px", "height" to "104px")), "src" to file.imagePath, "onClick" to fun(){
                                                previewMedia(index)
                                            }
                                            ), null, 12, _uA(
                                                "src",
                                                "onClick"
                                            )),
                                            _cE("image", _uM("src" to "/static/plus.png", "class" to "image-remove", "onClick" to fun(){
                                                removeMedia(index)
                                            }
                                            ), null, 8, _uA(
                                                "onClick"
                                            ))
                                        ), 4)
                                    }
                                    ), 128),
                                    _cE("image", _uM("class" to "uni-uploader__input-box", "onClick" to chooseMedia, "src" to "/static/plus.png"))
                                ), 4)
                            ), 4)
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
                return _uM("cell-pd" to _pS(_uM("paddingTop" to 11, "paddingRight" to 15, "paddingBottom" to 11, "paddingLeft" to 15)), "click-t" to _pS(_uM("color" to "#A9A9A9")), "list-pd" to _pS(_uM("marginTop" to 25)), "uni-uploader__input-box" to _pS(_uM("marginTop" to 5, "marginRight" to 5, "marginBottom" to 5, "marginLeft" to 5, "width" to 104, "height" to 104, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#D9D9D9", "borderRightColor" to "#D9D9D9", "borderBottomColor" to "#D9D9D9", "borderLeftColor" to "#D9D9D9")), "uni-uploader__input" to _pS(_uM("position" to "absolute", "zIndex" to 1, "top" to 0, "left" to 0, "width" to "100%", "height" to "100%", "opacity" to 0)), "image-remove" to _pS(_uM("transform" to "rotate(45deg)", "width" to 25, "height" to 25, "position" to "absolute", "top" to 0, "right" to 0, "borderTopLeftRadius" to 13, "borderTopRightRadius" to 13, "borderBottomRightRadius" to 13, "borderBottomLeftRadius" to 13, "backgroundColor" to "rgba(200,200,200,0.8)")), "item_width" to _pS(_uM("width" to 130)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
