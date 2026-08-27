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
import io.dcloud.uniapp.extapi.closePreviewImage as uni_closePreviewImage
import io.dcloud.uniapp.extapi.previewImage as uni_previewImage
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesAPIPreviewImagePreviewImage : BasePage {
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
    open var testSetCurrentIndicator: (value: String) -> Unit
        get() {
            return unref(this.`$exposed`["testSetCurrentIndicator"]) as (value: String) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "testSetCurrentIndicator", value)
        }
    open var previewImage: (index: Number) -> Unit
        get() {
            return unref(this.`$exposed`["previewImage"]) as (index: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "previewImage", value)
        }
    open var closePreviewImage: () -> Unit
        get() {
            return unref(this.`$exposed`["closePreviewImage"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "closePreviewImage", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIPreviewImagePreviewImage, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIPreviewImagePreviewImage
            val _cache = __ins.renderCache
            val imageList = ref(_uA<ImageType>(ImageType(src = "https://qiniu-web-assets.dcloud.net.cn/unidoc/zh/uni@2x.png", error = false), ImageType(src = "/static/test-image/logo.png", error = false), ImageType(src = "/static/test-image/logo.svg", error = false), ImageType(src = "/static/uni2.png", error = false)))
            val indicator = ref(_uA<ItemType__8>(ItemType__8(value = "default", name = "圆点"), ItemType__8(value = "number", name = "数字"), ItemType__8(value = "none", name = "不显示")))
            val longPressAction = ref(_uA<LongPressType>(LongPressType(value = "0", name = "默认长按行为"), LongPressType(value = "1", name = "自定义长按行为")))
            val currentIndicator = ref("default" as Indicator)
            val isWeb = ref(false)
            val isIOS = ref(false)
            val isLongPress = ref(true)
            val isLoop = ref(true)
            val previewImage = fun(index: Number){
                var list = _uA<String>()
                imageList.value.forEach(fun(item: ImageType){
                    list.push(item.src)
                }
                )
                uni_previewImage(PreviewImageOptions(urls = list, current = index, indicator = currentIndicator.value, loop = isLoop.value, longPressActions = if (isLongPress.value) {
                    (LongPressActionsOptions(itemList = _uA(
                        "按钮1",
                        "按钮2",
                        "按钮3"
                    ), itemColor = "#ccc", success = fun(e: LongPressActionsSuccessResult){
                        uni_showToast(ShowToastOptions(title = "用户选中了第" + (e.index + 1) + "张图片，并选中了第" + (e.tapIndex + 1) + "个选项", position = "bottom"))
                    }, fail = fun(e: LongPressActionsFailResult){
                        uni_showToast(ShowToastOptions(title = "用户关闭了action sheet", position = "bottom"))
                    }))
                } else {
                    null
                }
                ))
            }
            val chooseImage = fun(){
                uni_chooseImage(ChooseImageOptions(sourceType = _uA(
                    "album"
                ), count = 1, success = fun(e){
                    imageList.value = imageList.value.concat(ImageType(src = e.tempFilePaths[0], error = false))
                }
                , fail = fun(_) {}))
            }
            val onIndicatorChanged = fun(e: UniRadioGroupChangeEvent){
                currentIndicator.value = e.detail.value as Indicator
            }
            val onCheckboxChange = fun(_: UniCheckboxGroupChangeEvent){
                isLoop.value = !isLoop.value
            }
            val onLongPressCheckboxChange = fun(e: UniRadioGroupChangeEvent){
                isLongPress.value = (e.detail.value == "1")
            }
            val onImageLoadError = fun(index: Number, error: UniImageErrorEvent){
                imageList.value[index].error = true
            }
            val closePreviewImage = fun(){
                uni_closePreviewImage(ClosePreviewImageOptions())
            }
            val testSetCurrentIndicator = fun(value: String){
                currentIndicator.value = value as Indicator
            }
            __expose(_uM("testSetCurrentIndicator" to testSetCurrentIndicator, "previewImage" to previewImage, "closePreviewImage" to closePreviewImage))
            return fun(): Any? {
                val _component_radio = resolveComponent("radio")
                val _component_radio_group = resolveComponent("radio-group")
                val _component_checkbox = resolveComponent("checkbox")
                val _component_checkbox_group = resolveComponent("checkbox-group")
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("style" to _nS(_uM("padding-left" to "8px", "padding-right" to "8px"))), _uA(
                        _cE("view", null, _uA(
                            _cE("text", _uM("class" to "text-desc"), "图片指示器样式"),
                            _cV(_component_radio_group, _uM("class" to "cell-ct", "style" to _nS(_uM("background-color" to "white")), "onChange" to onIndicatorChanged), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(unref(indicator), fun(item, index, __index, _cached): Any {
                                        return _cE("view", _uM("class" to "indicator-it", "key" to item.value), _uA(
                                            _cV(_component_radio, _uM("disabled" to unref(isWeb), "checked" to (index == 0), "value" to item.value), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _tD(item.name)
                                                )
                                            }
                                            ), "_" to 2), 1032, _uA(
                                                "disabled",
                                                "checked",
                                                "value"
                                            ))
                                        ))
                                    }
                                    ), 128)
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "style"
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cV(_component_checkbox_group, _uM("onChange" to onCheckboxChange, "style" to _nS(_uM("margin-top" to "16px", "margin-left" to "8px"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_checkbox, _uM("disabled" to unref(isWeb), "checked" to unref(isLoop), "style" to _nS(_uM("margin-right" to "15px"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            "循环播放"
                                        )
                                    }
                                    ), "_" to 1), 8, _uA(
                                        "disabled",
                                        "checked",
                                        "style"
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "style"
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", _uM("class" to "text-desc"), "长按行为"),
                            _cV(_component_radio_group, _uM("class" to "cell-ct", "style" to _nS(_uM("background-color" to "white", "margin-bottom" to "16px")), "onChange" to onLongPressCheckboxChange), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(unref(longPressAction), fun(item, index, __index, _cached): Any {
                                        return _cE("view", _uM("class" to "indicator-it", "key" to item.value), _uA(
                                            _cV(_component_radio, _uM("disabled" to unref(isWeb), "checked" to (index == 1), "value" to item.value), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _tD(item.name)
                                                )
                                            }
                                            ), "_" to 2), 1032, _uA(
                                                "disabled",
                                                "checked",
                                                "value"
                                            ))
                                        ))
                                    }
                                    ), 128)
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "style"
                            ))
                        )),
                        _cE("view", _uM("style" to _nS(_uM("background-color" to "white"))), _uA(
                            _cE("text", _uM("class" to "text-desc"), "点击图片开始预览"),
                            _cE("view", _uM("class" to "cell-ct", "style" to _nS(_uM("margin" to "8px"))), _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(unref(imageList), fun(image, index, __index, _cached): Any {
                                    return _cE("view", _uM("class" to "cell cell-choose-image", "key" to index), _uA(
                                        if (isTrue(image.error)) {
                                            _cE("text", _uM("key" to 0, "style" to _nS(_uM("width" to "100px", "height" to "100px", "background-color" to "lightgray", "color" to "red", "text-align" to "center", "line-height" to "100px", "font-size" to "14px")), "onClick" to fun(){
                                                previewImage(index)
                                            }), "图片路径非法", 12, _uA(
                                                "onClick"
                                            ))
                                        } else {
                                            _cC("v-if", true)
                                        }
                                        ,
                                        if (isTrue(!image.error)) {
                                            _cE("image", _uM("key" to 1, "style" to _nS(_uM("width" to "100px", "height" to "100px", "background-color" to "white")), "mode" to "aspectFit", "src" to image.src, "onClick" to fun(){
                                                previewImage(index)
                                            }, "onError" to fun(`$event`: Any){
                                                onImageLoadError(index, `$event` as ImageErrorEvent)
                                            }), null, 44, _uA(
                                                "src",
                                                "onClick",
                                                "onError"
                                            ))
                                        } else {
                                            _cC("v-if", true)
                                        }
                                    ))
                                }
                                ), 128),
                                _cE("image", _uM("class" to "cell cell-choose-image", "src" to "/static/plus.png", "onClick" to chooseImage))
                            ), 4)
                        ), 4),
                        _cE("view", _uM("style" to _nS(_uM("margin" to "8px"))), _uA(
                            _cE("text", _uM("style" to _nS(_uM("color" to "black", "font-size" to "18px", "margin-bottom" to "4px"))), "注意事项:", 4),
                            _cE("text", _uM("style" to _nS(_uM("font-size" to "17px", "margin-left" to "4px", "color" to "darkgray"))), "1、indicator属性仅App平台支持。", 4),
                            _cE("text", _uM("style" to _nS(_uM("font-size" to "17px", "margin-left" to "4px", "color" to "darkgray"))), "2、Web平台不支持loop属性。", 4)
                        ), 4)
                    ), 4)
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
                return _uM("text-desc" to _pS(_uM("marginTop" to 16, "marginLeft" to 8, "marginBottom" to 16, "fontWeight" to "bold")), "cell-ct" to _pS(_uM("display" to "flex", "flexWrap" to "wrap", "flexDirection" to "row")), "cell" to _pS(_uM("marginLeft" to 3, "marginRight" to 3, "width" to 100, "height" to 100)), "cell-choose-image" to _pS(_uM("borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#D3D3D3", "borderRightColor" to "#D3D3D3", "borderBottomColor" to "#D3D3D3", "borderLeftColor" to "#D3D3D3")), "indicator-it" to _pS(_uM("marginTop" to 8, "marginRight" to 8, "marginBottom" to 8, "marginLeft" to 8)), "cell-pd" to _pS(_uM("paddingTop" to 11, "paddingRight" to 0, "paddingBottom" to 11, "paddingLeft" to 0)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
