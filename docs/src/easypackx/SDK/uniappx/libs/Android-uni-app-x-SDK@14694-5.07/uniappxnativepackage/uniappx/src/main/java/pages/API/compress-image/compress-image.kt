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
import java.io.FileInputStream
import kotlin.properties.Delegates
import io.dcloud.uniapp.extapi.chooseImage as uni_chooseImage
import io.dcloud.uniapp.extapi.compressImage as uni_compressImage
import io.dcloud.uniapp.extapi.getFileSystemManager as uni_getFileSystemManager
import io.dcloud.uniapp.extapi.getImageInfo as uni_getImageInfo
import io.dcloud.uniapp.extapi.hideLoading as uni_hideLoading
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading
import io.dcloud.uniapp.extapi.showModal as uni_showModal
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesAPICompressImageCompressImage : BasePage {
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
    open var data: DataType__88
        get() {
            return unref(this.`$exposed`["data"]) as DataType__88
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var testCompressImage: () -> Unit
        get() {
            return unref(this.`$exposed`["testCompressImage"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "testCompressImage", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPICompressImageCompressImage, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPICompressImageCompressImage
            val _cache = __ins.renderCache
            val title = ref("compressImage")
            val beforeCompressImageInfo = ref("")
            val afterCompressImageInfo = ref("")
            val beforeCompressPath = ref("")
            val afterCompressPath = ref("")
            val quality = ref(80)
            val rotate = ref(0)
            val data = reactive(DataType__88(imageInfoForTest = null, imageSrcForTest = "/static/test-image/logo.png", compressedWidth = null, compressedHeight = null))
            val compressImage = fun(){
                if (beforeCompressPath.value == "") {
                    uni_showToast(ShowToastOptions(title = "请先选择图片", icon = "error"))
                    return
                }
                uni_showLoading(ShowLoadingOptions(title = "图片压缩中"))
                uni_compressImage(CompressImageOptions(src = beforeCompressPath.value, quality = quality.value, compressedWidth = data.compressedWidth, compressedHeight = data.compressedHeight, rotate = rotate.value, success = fun(res){
                    console.log("compressImage success", JSON.stringify(res))
                    afterCompressPath.value = res.tempFilePath
                    uni_showToast(ShowToastOptions(title = "压缩成功", icon = null))
                    uni_getImageInfo(GetImageInfoOptions(src = res.tempFilePath, success = fun(_res){
                        afterCompressImageInfo.value = "图片宽度: " + _res.width + "\n图片高度: " + _res.height + "\n"
                        val size = FileInputStream(res.tempFilePath.substring(7)).available() / 1024
                        afterCompressImageInfo.value = afterCompressImageInfo.value.concat("图片大小: " + size + "KB")
                    }
                    ))
                }
                , fail = fun(err){
                    uni_showModal(ShowModalOptions(title = "压缩图片失败", content = JSON.stringify(err), showCancel = false))
                }
                , complete = fun(_){
                    uni_hideLoading(null)
                }
                ))
            }
            val chooseImage = fun(){
                uni_chooseImage(ChooseImageOptions(count = 1, sizeType = _uA(
                    "original"
                ), sourceType = _uA(
                    "album"
                ), success = fun(res){
                    beforeCompressPath.value = res.tempFilePaths[0]
                    uni_getImageInfo(GetImageInfoOptions(src = res.tempFilePaths[0], success = fun(_res){
                        beforeCompressImageInfo.value = "图片宽度: " + _res.width + "\n图片高度: " + _res.height + "\n"
                        val size = FileInputStream(res.tempFilePaths[0].substring(7)).available() / 1024
                        beforeCompressImageInfo.value = beforeCompressImageInfo.value.concat("图片大小: " + size + "KB")
                    }
                    ))
                }
                ))
            }
            val onQualityConfirm = fun(value: Number){
                quality.value = value
            }
            val onCompressedWidthConfirm = fun(value: String){
                data.compressedWidth = parseInt(value)
            }
            val onCompressedHeightConfirm = fun(value: String){
                data.compressedHeight = parseInt(value)
            }
            val onRotateConfirm = fun(value: Number){
                rotate.value = value
            }
            val testCompressImage = fun(){
                uni_compressImage(CompressImageOptions(src = data.imageSrcForTest, quality = 50, compressedWidth = 100, compressedHeight = 100, success = fun(res){
                    uni_getImageInfo(GetImageInfoOptions(src = res.tempFilePath, success = fun(_res){
                        val fsm = uni_getFileSystemManager()
                        fsm.getFileInfo(GetFileInfoOptions(filePath = data.imageSrcForTest, digestAlgorithm = null, success = fun(imageInfo){
                            fsm.getFileInfo(GetFileInfoOptions(filePath = res.tempFilePath, digestAlgorithm = null, success = fun(res){
                                data.imageInfoForTest = _uO("width" to _res.width, "height" to _res.height, "isSizeReduce" to (res.size < imageInfo.size))
                            }
                            ))
                        }
                        ))
                    }
                    ))
                }
                , fail = fun(_){
                    data.imageInfoForTest = null
                }
                ))
            }
            __expose(_uM("data" to data, "testCompressImage" to testCompressImage))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", null, _uA(
                        _cV(_component_page_head, _uM("title" to unref(title)), null, 8, _uA(
                            "title"
                        )),
                        _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                            _cE("view", _uM("class" to "image-container"), _uA(
                                _cE("image", _uM("class" to "image", "src" to unref(beforeCompressPath), "mode" to "aspectFit"), null, 8, _uA(
                                    "src"
                                )),
                                _cE("image", _uM("class" to "image", "src" to unref(afterCompressPath), "mode" to "aspectFit"), null, 8, _uA(
                                    "src"
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "压缩前图片信息")
                            )),
                            _cE("text", null, _tD(unref(beforeCompressImageInfo)), 1),
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "压缩后图片信息")
                            )),
                            _cE("text", null, _tD(unref(afterCompressImageInfo)), 1),
                            _cE("view", _uM("class" to "uni-btn-v"), _uA(
                                _cE("button", _uM("type" to "primary", "onClick" to chooseImage), "从相册中选取待压缩的图片")
                            )),
                            _cE("view", _uM("class" to "uni-btn-v"), _uA(
                                _cE("button", _uM("type" to "primary", "onClick" to compressImage), "压缩图片")
                            ))
                        )),
                        _cV(_component_input_data, _uM("defaultValue" to "80", "title" to "压缩质量，范围0～100，数值越小，质量越低，压缩率越高（仅对jpg有效）", "type" to "number", "onConfirm" to onQualityConfirm)),
                        _cV(_component_input_data, _uM("title" to "压缩后图片的宽度，单位px", "type" to "string", "onConfirm" to onCompressedWidthConfirm)),
                        _cV(_component_input_data, _uM("title" to "压缩后图片的高度，单位px", "type" to "string", "onConfirm" to onCompressedHeightConfirm)),
                        _cV(_component_input_data, _uM("defaultValue" to "0", "title" to "旋转度数，范围0～360", "type" to "number", "onConfirm" to onRotateConfirm))
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
                return _uM("image" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "image-container" to _pS(_uM("flexDirection" to "row")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
