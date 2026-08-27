@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNI2971F61
import android.content.Context
import io.dcloud.uniapp.*
import io.dcloud.uniapp.extapi.*
import io.dcloud.uniapp.framework.*
import io.dcloud.uniapp.runtime.*
import io.dcloud.uniapp.vue.*
import io.dcloud.uniapp.vue.shared.*
import io.dcloud.uts.*
import io.dcloud.uts.Map
import io.dcloud.uts.Set
import io.dcloud.uts.UTSAndroid
import kotlin.properties.Delegates
import uts.sdk.modules.iboxsChooseMedia.MediaScanner
import io.dcloud.uniapp.extapi.`$emit` as uni__emit
import io.dcloud.uniapp.extapi.downloadFile as uni_downloadFile
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
import io.dcloud.uniapp.extapi.hideLoading as uni_hideLoading
import io.dcloud.uniapp.extapi.navigateBack as uni_navigateBack
import io.dcloud.uniapp.extapi.saveImageToPhotosAlbum as uni_saveImageToPhotosAlbum
import io.dcloud.uniapp.extapi.saveVideoToPhotosAlbum as uni_saveVideoToPhotosAlbum
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenUniModulesIboxsChoosemediaPagesPreview : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            xProvitae.scrollTop = e.scrollTop
            val pages = getCurrentPages()
            if (pages.length == 0) {
                return
            }
            val page = pages[pages.length - 1].route
            uni__emit("onPageScroll", _uO("top" to e.scrollTop, "page" to page))
        }
        , __ins)
        onResize(fun(_: OnResizeOptions) {
            uni__emit("onResize", fun() {})
        }
        , __ins)
        onLoad(fun(query: OnLoadOptions) {
            xProvitae.onLoadOpts = JSON.parseObject(JSON.stringify(query)!!) ?: _uO()
            uni__emit("onLoad", fun() {})
        }
        , __ins)
        onPageHide(fun() {
            uni__emit("onHide", fun() {})
        }
        , __ins)
        onReady(fun() {
            uni__emit("onReady", fun() {})
            xProvitae.pageReady = true
        }
        , __ins)
        onPageShow(fun() {
            uni__emit("onShow", fun() {})
        }
        , __ins)
    }
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesIboxsChoosemediaPagesPreview) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesIboxsChoosemediaPagesPreview
            val _cache = __ins.renderCache
            val visible = ref(false)
            val list = ref(_uA<UTSJSONObject>())
            val pageHeight = ref(0)
            val curIndex = ref(0)
            val menu = ref(_uA<bottomMenu__1>(bottomMenu__1(name = "原图下载", key = "save"), bottomMenu__1(name = "删除图片", key = "delete"), bottomMenu__1(name = "取消", key = "cancel")))
            val model = ref<UniElement?>(null)
            val closeMenu = fun(){
                visible.value = false
            }
            val isUrl = fun(str: String): Boolean {
                val urlRegex = UTSRegExp("^(https?:\\/\\/)?([\\da-z.-]+)\\.([a-z.]{2,6})([/\\w .-]*)*\\/?\$", "")
                return urlRegex.test(str)
            }
            val clickImage = fun(){
                uni_navigateBack(null)
            }
            val saveVideo = fun(url: String){
                if (isUrl(url)) {
                    uni_downloadFile(DownloadFileOptions(url = url, success = fun(down: DownloadFileSuccess){
                        uni_saveVideoToPhotosAlbum(SaveVideoToPhotosAlbumOptions(filePath = down.tempFilePath, success = fun(_){
                            uni_showToast(ShowToastOptions(title = "保存成功", icon = "success"))
                        }
                        , fail = fun(_){
                            uni_showToast(ShowToastOptions(title = "保存失败", icon = "error"))
                        }
                        , complete = fun(_){
                            uni_hideLoading(null)
                            closeMenu()
                        }
                        ))
                    }
                    ))
                    return
                }
                uni_saveVideoToPhotosAlbum(SaveVideoToPhotosAlbumOptions(filePath = url, success = fun(_){
                    uni_showToast(ShowToastOptions(title = "保存成功", icon = "success"))
                }
                , fail = fun(_){
                    uni_showToast(ShowToastOptions(title = "保存失败", icon = "error"))
                }
                , complete = fun(_){
                    uni_hideLoading(null)
                    closeMenu()
                }
                ))
            }
            val saveImage = fun(url: String): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var res = await(request.callapi("album/downloadurl", _uO("url" to url)))
                        if (res.code < 0) {
                            common.toast("获取下载链接失败")
                            uni_hideLoading(null)
                            closeMenu()
                            return@w1
                        }
                        var downloadUrl = (res.data as UTSJSONObject)["url"] as String
                        console.log("下载图片", downloadUrl)
                        uni_downloadFile(DownloadFileOptions(url = downloadUrl, success = fun(down: DownloadFileSuccess){
                            uni_saveImageToPhotosAlbum(SaveImageToPhotosAlbumOptions(filePath = down.tempFilePath, success = fun(_){
                                uni_showToast(ShowToastOptions(title = "保存成功", icon = "success"))
                            }
                            , fail = fun(_){
                                uni_showToast(ShowToastOptions(title = "保存失败", icon = "error"))
                            }
                            , complete = fun(_){
                                uni_hideLoading(null)
                                closeMenu()
                            }
                            ))
                        }
                        , fail = fun(res: DownloadFileFail){
                            console.log(res)
                            uni_showToast(ShowToastOptions(title = "下载失败", icon = "error"))
                        }
                        , complete = fun(_){
                            uni_hideLoading(null)
                            closeMenu()
                        }
                        ))
                })
            }
            val saveImg = fun(){
                var media = list.value[curIndex.value] as UTSJSONObject
                console.log("报错媒体", media)
                uni_showLoading(ShowLoadingOptions(title = "保存中", mask = true))
                var type = media["type"] as String
                console.log(type)
                when (type) {
                    "image" -> 
                        saveImage(media["uri"] as String)
                    "video" -> 
                        saveVideo(media["uri"] as String)
                }
            }
            val longTap = fun(){
                visible.value = true
            }
            val swiperChange = fun(e: UniSwiperChangeEvent){
                console.log(e)
                var index = e.detail.current
                curIndex.value = index
            }
            val deleteImg = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var q = await(common.showQuery(model.value as Any, "确定删除该照片？"))
                        if (!q) {
                            return@w1
                        }
                        var res = await(request.callapi("album/deleteimg", _uO("url" to list.value[curIndex.value]["uri"])))
                        common.toast(res.msg)
                        if (res.code == 0) {
                            common.timeBack()
                        }
                })
            }
            val menuClick = fun(key: String){
                when (key) {
                    "cancel" -> 
                        closeMenu()
                    "save" -> 
                        saveImg()
                    "delete" -> 
                        deleteImg()
                }
            }
            onLoad(fun(options){
                console.log(options)
                if (options["list"] == null) {
                    return
                }
                console.log("原始数据", options["list"])
                var decodedList = decodeURIComponent(options["list"] as String) as String
                console.log("解码结果", decodedList)
                var lists = JSON.parseArray(decodedList) as UTSArray<UTSJSONObject>
                list.value = lists
                console.log(list.value)
                var index = UTSNumber.from(options["index"] as String)
                curIndex.value = index
                console.log("索引值", index)
            }
            )
            onReady(fun(){
                pageHeight.value = uni_getWindowInfo().safeArea.height
            }
            )
            return fun(): Any? {
                val _component_x_model = resolveEasyComponent("x-model", GenComponentsXModelClass)
                return _cE("view", _uM("class" to "padding-stauts-bar padding-safe-bottom", "onClick" to clickImage, "onLongpress" to longTap), _uA(
                    _cE("view", _uM("class" to "page", "style" to _nS(_uM("height" to (unref(pageHeight) + "px")))), _uA(
                        _cE("swiper", _uM("onChange" to swiperChange, "current" to unref(curIndex), "indicator-dots" to true, "circular" to false, "indicator-color" to "#464646", "indicator-active-color" to "#bbb"), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(unref(list), fun(item, index, __index, _cached): Any {
                                return _cE("swiper-item", _uM("key" to index), _uA(
                                    if (item["type"] == "image") {
                                        _cE("view", _uM("key" to 0, "class" to "item", "style" to _nS(_uM("height" to (unref(pageHeight) + "px")))), _uA(
                                            _cE("image", _uM("fade-show" to true, "mode" to "widthFix", "src" to item["uri"], "class" to "image"), null, 8, _uA(
                                                "src"
                                            ))
                                        ), 4)
                                    } else {
                                        _cC("v-if", true)
                                    }
                                    ,
                                    if (item["type"] == "video") {
                                        _cE("view", _uM("key" to 1, "class" to "item", "style" to _nS(_uM("height" to (unref(pageHeight) + "px")))), _uA(
                                            _cE("video", _uM("class" to "image", "auto-pause-if-navigate" to true, "src" to item["uri"], "object-fit" to "fill", "play-btn-position" to "center"), null, 8, _uA(
                                                "src"
                                            ))
                                        ), 4)
                                    } else {
                                        _cC("v-if", true)
                                    }
                                ))
                            }
                            ), 128)
                        ), 40, _uA(
                            "current"
                        ))
                    ), 4),
                    _cV(unref(GenUniModulesIboxsChoosemediaComponentsXuButtommenuClass), _uM("visible" to unref(visible), "onMenuClick" to menuClick, "menu" to unref(menu), "onClosePopup" to closeMenu), null, 8, _uA(
                        "visible",
                        "menu"
                    )),
                    _cV(_component_x_model, _uM("ref_key" to "model", "ref" to model), null, 512)
                ), 32)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("color-white" to _pS(_uM("color" to "#FFFFFF")), "list-items" to _pS(_uM("flexWrap" to "wrap", "flexDirection" to "row")), "litem" to _uM(".list-items " to _uM("flexGrow" to 0, "flexShrink" to 0)), "top-status-bar" to _pS(_uM("top" to CSS_VAR_STATUS_BAR_HEIGHT)), "padding-stauts-bar" to _pS(_uM("paddingTop" to CSS_VAR_STATUS_BAR_HEIGHT)), "margin-status-bar" to _pS(_uM("marginTop" to CSS_VAR_STATUS_BAR_HEIGHT)), "height-status-bar" to _pS(_uM("height" to CSS_VAR_STATUS_BAR_HEIGHT)), "safe-bottom" to _pS(_uM("bottom" to "var(--uni-safe-area-inset-bottom)")), "padding-safe-bottom" to _pS(_uM("paddingBottom" to "var(--uni-safe-area-inset-bottom)")), "safe-bottom-view" to _pS(_uM("width" to "750rpx", "left" to 0, "height" to "var(--uni-safe-area-inset-bottom)", "position" to "fixed", "bottom" to 0)), "overline" to _pS(_uM("whiteSpace" to "nowrap", "overflow" to "hidden", "textOverflow" to "ellipsis")), "display-flex" to _pS(_uM("display" to "flex", "flexDirection" to "row")), "space-between" to _pS(_uM("justifyContent" to "space-between", "display" to "flex", "flexDirection" to "row")), "item" to _pS(_uM("width" to "750rpx", "alignItems" to "center", "justifyContent" to "center")), "image" to _uM(".item " to _uM("width" to "750rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
