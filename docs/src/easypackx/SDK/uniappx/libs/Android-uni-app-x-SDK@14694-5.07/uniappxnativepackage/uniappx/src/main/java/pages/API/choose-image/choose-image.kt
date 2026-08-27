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
import io.dcloud.uniapp.extapi.chooseImage as uni_chooseImage
import io.dcloud.uniapp.extapi.previewImage as uni_previewImage
import io.dcloud.uniapp.extapi.showActionSheet as uni_showActionSheet
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesAPIChooseImageChooseImage : BasePage {
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
        var setup: (__props: GenPagesAPIChooseImageChooseImage) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIChooseImageChooseImage
            val _cache = __ins.renderCache
            val sourceTypeArray = _uA(
                _uA(
                    "camera"
                ),
                _uA(
                    "album"
                ),
                _uA(
                    "camera",
                    "album"
                )
            )
            val sizeTypeArray = _uA(
                _uA(
                    "compressed"
                ),
                _uA(
                    "original"
                ),
                _uA(
                    "compressed",
                    "original"
                )
            )
            val orientationTypeArray = _uA(
                "portrait",
                "landscape",
                "auto"
            )
            val albumModeTypeArray = _uA(
                "custom",
                "system"
            )
            val title = ref("chooseImage")
            val imageList = ref(_uA<String>())
            val sourceTypeIndex = ref(2)
            val sourceType = ref(_uA(
                "拍照",
                "相册",
                "拍照或相册"
            ))
            val sizeTypeIndex = ref(2)
            val sizeType = ref(_uA(
                "压缩",
                "原图",
                "压缩或原图"
            ))
            val orientationTypeIndex = ref(0)
            val orientationType = ref(_uA(
                "竖屏",
                "横屏",
                "自动"
            ))
            val albumModeTypeIndex = ref(0)
            val albumModeType = ref(_uA(
                "自定义相册",
                "系统相册"
            ))
            val count = ref(9)
            val isCrop = ref(false)
            val cropPercent = ref(80)
            val cropWidth = ref(100)
            val cropHeight = ref(100)
            val cropResize = ref(false)
            onPageHide(fun(){
                console.log("Page Hide")
            }
            )
            onUnload(fun(){
                imageList.value = _uA()
                sourceTypeIndex.value = 2
                sourceType.value = _uA(
                    "拍照",
                    "相册",
                    "拍照或相册"
                )
                sizeTypeIndex.value = 2
                sizeType.value = _uA(
                    "压缩",
                    "原图",
                    "压缩或原图"
                )
                orientationTypeIndex.value = 0
                orientationType.value = _uA(
                    "竖屏",
                    "横屏",
                    "自动"
                )
            }
            )
            val cropHeightConfim = fun(e: InputConfirmEvent){
                var value = parseInt(e.detail.value)
                if (value > 0) {
                    cropHeight.value = value
                } else {
                    uni_showToast(ShowToastOptions(position = "bottom", title = "裁剪高度需要大于0"))
                }
            }
            val cropWidthConfim = fun(e: InputConfirmEvent){
                var value = parseInt(e.detail.value)
                if (value > 0) {
                    cropWidth.value = value
                } else {
                    uni_showToast(ShowToastOptions(position = "bottom", title = "裁剪宽度需要大于0"))
                }
            }
            val cropPercentConfim = fun(e: InputConfirmEvent){
                var value = parseInt(e.detail.value)
                if (value > 0 && value <= 100) {
                    cropPercent.value = value
                } else {
                    uni_showToast(ShowToastOptions(position = "bottom", title = "请输入0~100之间的值"))
                }
            }
            val albumModeChange = fun(){
                uni_showActionSheet(ShowActionSheetOptions(itemList = albumModeType.value, success = fun(e){
                    albumModeTypeIndex.value = e.tapIndex
                }
                ))
            }
            val cropResizeChange = fun(e: UniSwitchChangeEvent){
                cropResize.value = e.detail.value
            }
            val switchCrop = fun(e: UniSwitchChangeEvent){
                isCrop.value = e.detail.value
            }
            val removeImage = fun(index: Number){
                imageList.value.splice(index, 1)
            }
            val chooseImageSource = fun(){
                uni_showActionSheet(ShowActionSheetOptions(itemList = _uA(
                    "拍照",
                    "相册",
                    "拍照或相册"
                ), success = fun(e){
                    sourceTypeIndex.value = e.tapIndex
                }
                ))
            }
            val chooseImageType = fun(){
                uni_showActionSheet(ShowActionSheetOptions(itemList = _uA(
                    "压缩",
                    "原图",
                    "压缩或原图"
                ), success = fun(e){
                    sizeTypeIndex.value = e.tapIndex
                }
                ))
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
            val chooseImageCount = fun(event: InputBlurEvent){
                var countValue = parseInt(event.detail.value)
                if (countValue < 0) {
                    uni_showToast(ShowToastOptions(position = "bottom", title = "图片数量应该大于0"))
                    return
                }
                count.value = countValue
            }
            val chooseImage = fun(){
                if (imageList.value.length >= count.value) {
                    uni_showToast(ShowToastOptions(position = "bottom", title = "已经有 " + count.value + " 张图片了，请删除部分图片之后重新选择"))
                    return
                }
                uni_chooseImage(ChooseImageOptions(sourceType = sourceTypeArray[sourceTypeIndex.value], sizeType = sizeTypeArray[sizeTypeIndex.value], crop = if (isCrop.value) {
                    ChooseImageCropOptions(quality = cropPercent.value, width = cropWidth.value, height = cropHeight.value, resize = cropResize.value)
                } else {
                    null
                }
                , count = count.value - imageList.value.length, pageOrientation = orientationTypeArray[orientationTypeIndex.value], albumMode = albumModeTypeArray[albumModeTypeIndex.value], success = fun(res){
                    imageList.value = imageList.value.concat(res.tempFilePaths)
                    console.log("imageList: ", imageList.value)
                }
                , fail = fun(err){
                    console.log("err: ", JSON.stringify(err))
                    uni_showToast(ShowToastOptions(title = "choose image error.code:" + err.errCode + ";message:" + err.errMsg, position = "bottom"))
                }
                ))
            }
            val previewImage = fun(index: Number){
                uni_previewImage(PreviewImageOptions(current = index, urls = imageList.value))
            }
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                val _component_switch = resolveComponent("switch")
                return _cE("scroll-view", _uM("class" to "page-scroll-view"), _uA(
                    _cV(_component_page_head, _uM("title" to unref(title)), null, 8, _uA(
                        "title"
                    )),
                    _cE("view", _uM("class" to "uni-common-mt"), _uA(
                        _cE("view", _uM("class" to "uni-list"), _uA(
                            _cE("view", _uM("class" to "uni-list-cell cell-pd"), _uA(
                                _cE("text", _uM("class" to "uni-list-cell-left uni-label"), " 图片来源 "),
                                _cE("view", _uM("class" to "uni-list-cell-right", "onClick" to chooseImageSource), _uA(
                                    _cE("text", _uM("class" to "click-t"), _tD(unref(sourceType)[unref(sourceTypeIndex)]), 1)
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-list-cell cell-pd"), _uA(
                                _cE("text", _uM("class" to "uni-list-cell-left uni-label"), " 图片质量 "),
                                _cE("view", _uM("class" to "uni-list-cell-right", "onClick" to chooseImageType), _uA(
                                    _cE("text", _uM("class" to "click-t"), _tD(unref(sizeType)[unref(sizeTypeIndex)]), 1)
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-list-cell cell-pd"), _uA(
                                _cE("text", _uM("class" to "uni-list-cell-left uni-label"), " 数量限制 "),
                                _cE("view", _uM("class" to "uni-list-cell-right"), _uA(
                                    _cE("input", _uM("class" to "click-t", "value" to unref(count), "type" to "number", "maxlength" to 1, "onBlur" to chooseImageCount), null, 40, _uA(
                                        "value"
                                    ))
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-list-cell cell-pd"), _uA(
                                _cE("text", _uM("class" to "uni-list-cell-left uni-label"), " 屏幕方向 "),
                                _cE("view", _uM("class" to "uni-list-cell-right", "onClick" to chooseOrientationType), _uA(
                                    _cE("text", _uM("class" to "click-t"), _tD(unref(orientationType)[unref(orientationTypeIndex)]), 1)
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-list-cell cell-pd"), _uA(
                                _cE("text", _uM("class" to "uni-list-cell-left uni-label"), " 相册模式 "),
                                _cE("view", _uM("class" to "uni-list-cell-right", "onClick" to albumModeChange), _uA(
                                    _cE("text", _uM("class" to "click-t"), _tD(unref(albumModeType)[unref(albumModeTypeIndex)]), 1)
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-list-cell cell-pd"), _uA(
                                _cE("text", _uM("class" to "uni-list-cell-left uni-label"), " 图像裁剪 "),
                                _cE("view", _uM("class" to "uni-list-cell-right"), _uA(
                                    _cV(_component_switch, _uM("checked" to unref(isCrop), "onChange" to switchCrop), null, 8, _uA(
                                        "checked"
                                    ))
                                ))
                            )),
                            _cE("view", _uM("ref" to "cropOptionNode", "class" to "crop-option", "style" to _nS(_uM("height" to if (unref(isCrop)) {
                                "200px"
                            } else {
                                "0px"
                            }
                            , "margin-bottom" to if (unref(isCrop)) {
                                "11px"
                            } else {
                                "0px"
                            }
                            ))), _uA(
                                _cE("view", _uM("class" to "uni-list-cell cell-pd"), _uA(
                                    _cE("view", _uM("class" to "uni-list-cell-left item_width"), " 图片质量(%) "),
                                    _cE("view", _uM("class" to "uni-list-cell-right"), _uA(
                                        _cE("input", _uM("value" to unref(cropPercent), "onConfirm" to cropPercentConfim, "type" to "number", "maxlength" to "-1"), null, 40, _uA(
                                            "value"
                                        ))
                                    ))
                                )),
                                _cE("view", _uM("class" to "uni-list-cell cell-pd"), _uA(
                                    _cE("view", _uM("class" to "uni-list-cell-left item_width"), " 裁剪宽度(px) "),
                                    _cE("view", _uM("class" to "uni-list-cell-right"), _uA(
                                        _cE("input", _uM("value" to unref(cropWidth), "onConfirm" to cropWidthConfim, "type" to "number", "maxlength" to "-1"), null, 40, _uA(
                                            "value"
                                        ))
                                    ))
                                )),
                                _cE("view", _uM("class" to "uni-list-cell cell-pd"), _uA(
                                    _cE("view", _uM("class" to "uni-list-cell-left item_width"), " 裁剪高度(px) "),
                                    _cE("view", _uM("class" to "uni-list-cell-right"), _uA(
                                        _cE("input", _uM("value" to unref(cropHeight), "onConfirm" to cropHeightConfim, "type" to "number", "maxlength" to "-1"), null, 40, _uA(
                                            "value"
                                        ))
                                    ))
                                )),
                                _cE("view", _uM("class" to "uni-list-cell cell-pd"), _uA(
                                    _cE("view", _uM("class" to "uni-list-cell-left item_width"), " 保留原宽高 "),
                                    _cE("view", _uM("class" to "uni-list-cell-right"), _uA(
                                        _cV(_component_switch, _uM("checked" to unref(cropResize), "onChange" to cropResizeChange), null, 8, _uA(
                                            "checked"
                                        ))
                                    ))
                                ))
                            ), 4)
                        )),
                        _cE("view", _uM("class" to "uni-list list-pd", "style" to _nS(_uM("padding" to "15px"))), _uA(
                            _cE("view", _uM("class" to "uni-flex", "style" to _nS(_uM("margin-bottom" to "10px"))), _uA(
                                _cE("view", _uM("class" to "uni-list-cell-left"), "点击可预览选好的图片"),
                                _cE("view", _uM("style" to _nS(_uM("margin-left" to "auto"))), _uA(
                                    _cE("text", _uM("class" to "click-t"), _tD(unref(imageList).length) + "/" + _tD(unref(count)), 1)
                                ), 4)
                            ), 4),
                            _cE("view", _uM("class" to "uni-flex", "style" to _nS(_uM("flex-wrap" to "wrap"))), _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(unref(imageList), fun(image, index, __index, _cached): Any {
                                    return _cE("view", _uM("key" to index, "class" to "uni-uploader__input-box", "style" to _nS(_uM("border" to "0"))), _uA(
                                        _cE("image", _uM("style" to _nS(_uM("width" to "104px", "height" to "104px")), "src" to image, "onClick" to fun(){
                                            previewImage(index)
                                        }
                                        ), null, 12, _uA(
                                            "src",
                                            "onClick"
                                        )),
                                        _cE("image", _uM("src" to "/static/plus.png", "class" to "image-remove", "onClick" to fun(){
                                            removeImage(index)
                                        }
                                        ), null, 8, _uA(
                                            "onClick"
                                        ))
                                    ), 4)
                                }
                                ), 128),
                                _cE("image", _uM("class" to "uni-uploader__input-box", "onClick" to chooseImage, "src" to "/static/plus.png"))
                            ), 4)
                        ), 4)
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
                return _uM("cell-pd" to _pS(_uM("paddingTop" to 11, "paddingRight" to 15, "paddingBottom" to 11, "paddingLeft" to 15)), "click-t" to _pS(_uM("color" to "#A9A9A9")), "list-pd" to _pS(_uM("marginTop" to 25)), "uni-uploader__input-box" to _pS(_uM("marginTop" to 5, "marginRight" to 5, "marginBottom" to 5, "marginLeft" to 5, "width" to 104, "height" to 104, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#D9D9D9", "borderRightColor" to "#D9D9D9", "borderBottomColor" to "#D9D9D9", "borderLeftColor" to "#D9D9D9")), "uni-uploader__input" to _pS(_uM("position" to "absolute", "zIndex" to 1, "top" to 0, "left" to 0, "width" to "100%", "height" to "100%", "opacity" to 0)), "image-remove" to _pS(_uM("transform" to "rotate(45deg)", "width" to 25, "height" to 25, "position" to "absolute", "top" to 0, "right" to 0, "borderTopLeftRadius" to 13, "borderTopRightRadius" to 13, "borderBottomRightRadius" to 13, "borderBottomLeftRadius" to 13, "backgroundColor" to "rgba(200,200,200,0.8)")), "item_width" to _pS(_uM("width" to 130)), "crop-option" to _pS(_uM("marginLeft" to 11, "marginRight" to 11, "borderTopLeftRadius" to 11, "borderTopRightRadius" to 11, "borderBottomRightRadius" to 11, "borderBottomLeftRadius" to 11, "backgroundColor" to "#eeeeee", "transitionProperty" to "height,marginBottom", "transitionDuration" to "200ms")), "@TRANSITION" to _uM("crop-option" to _uM("property" to "height,marginBottom", "duration" to "200ms")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
