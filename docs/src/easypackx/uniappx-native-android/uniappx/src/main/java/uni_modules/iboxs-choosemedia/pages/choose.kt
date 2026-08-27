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
import io.dcloud.uniapp.extapi.chooseImage as uni_chooseImage
import io.dcloud.uniapp.extapi.compressImage as uni_compressImage
import io.dcloud.uniapp.extapi.compressVideo as uni_compressVideo
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
import io.dcloud.uniapp.extapi.hideLoading as uni_hideLoading
import io.dcloud.uniapp.extapi.navigateBack as uni_navigateBack
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenUniModulesIboxsChoosemediaPagesChoose : BasePage {
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
        var setup: (__props: GenUniModulesIboxsChoosemediaPagesChoose) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesIboxsChoosemediaPagesChoose
            val _cache = __ins.renderCache
            val type = ref("all")
            val windowHeight = ref(150)
            val compress = ref(0)
            val pageHeight = ref(0)
            val showImageList = ref(_uA<String>())
            val errorImageList = ref(_uA<String>())
            val imgList = ref(_uA<media>())
            val accessTitle = ref("图片和视频")
            val selectIndexList = ref(_uA<String>())
            val pageMax = ref(10000)
            val mediaCount = ref(0)
            val page = ref(1)
            val listHeight = ref(50)
            val listMaxHeight = ref(100)
            val showPopup = ref(false)
            val pathList = ref(_uA<path>())
            val pathIDList = ref(_uA<Long>())
            val floderID = ref(0)
            val chooseCount = ref(20)
            val showCamera = ref(true)
            val isCompress = ref(true)
            val popup = ref<UniElement?>(null)
            val splitArray = fun(arr: UTSArray<media>): UTSArray<UTSArray<media>> {
                val result = _uA<UTSArray<media>>()
                if (arr.length > 0) {
                    run {
                        var i: Number = 0
                        while(i < arr.length){
                            result.push(arr.slice(i, i + 4))
                            i += 4
                        }
                    }
                }
                return result
            }
            val titleName = computed(fun(): String {
                when (type.value) {
                    "image" -> 
                        return "全部图片"
                    "video" -> 
                        return "全部视频"
                    "all" -> 
                        return "图片和视频"
                    else -> 
                        return "图片和视频"
                }
            }
            )
            val showList = computed(fun(): UTSArray<UTSArray<media>> {
                return splitArray(imgList.value)
            }
            )
            val setShow = fun(value: Boolean){
                showPopup.value = value
            }
            val changeCompress = fun(e: UTSArray<String>){
                isCompress.value = e.length < 1
            }
            val imageSelected = fun(e: UTSArray<String>){
                console.log("选中项", e)
                selectIndexList.value = e
            }
            val showAccessList = fun(){
                if (pathIDList.value.length < 1) {
                    return
                }
                (popup.value as ComponentPublicInstance).`$callMethod`("open")
            }
            val loadComplete = fun(index: Number, index2: Number){
                showImageList.value.push(index + "-" + index2)
            }
            val loadError = fun(errorIndex: Number, errorIndex2: Number){
                errorImageList.value.push(errorIndex + "-" + errorIndex2)
                imgList.value[errorIndex].uri = "https://cdn.itgz8.com/image/error.png"
            }
            val closeChoosePage = fun(){
                uni__emit("iboxs-choosemedia", _uA<UTSJSONObject>())
                uni_navigateBack(null)
            }
            val closeAccessList = fun(){
                (popup.value as ComponentPublicInstance).`$callMethod`("close")
            }
            val pushData = fun(res: String, currentPage: Number): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        var list = JSON.parseArray(res) as UTSArray<UTSJSONObject>
                        for(item in resolveUTSValueIterator(list)){
                            imgList.value.push(media(file = item["file"] as String, type = item["type"] as String, id = item["fileId"] as Number, uri = item["uri"] as String, duration = item["duration"] as Number, ext = item["ext"] as String, folderID = item["folderId"] as Number, folder = item["path"] as String))
                            if (floderID.value == 0) {
                                if (pathIDList.value.length < 1) {
                                    pathIDList.value.push(0)
                                    pathList.value.push(path(name = accessTitle.value, id = 0, uri = item["uri"] as String, count = mediaCount.value))
                                }
                                var currentPathID = (item["folderId"] as Number).toLong()
                                var pathName = item["path"] as String
                                var index = pathIDList.value.indexOf(currentPathID)
                                if (index < 0) {
                                    pathIDList.value.push(currentPathID)
                                    pathList.value.push(path(name = pathName, id = currentPathID, uri = item["uri"] as String, count = 1))
                                } else {
                                    var count = pathList.value[index].count as Number
                                    count++
                                    pathList.value[index].count = count
                                }
                                listHeight.value = pathIDList.value.length * 60
                            }
                        }
                })
            }
            val getMediaList = fun(){
                MediaScanner.scanMedia(UTSAndroid.getAppContext() as Context, type.value, floderID.value.toLong(), page.value.toInt(), 150, fun(res: String){
                    console.log("收到媒体回调", res)
                    pushData(res, page.value)
                }
                , fun(str: String){
                    console.log("失败回调", str)
                }
                , fun(){
                    console.log("获取完成")
                }
                )
            }
            val refresh = fun(){
                imgList.value = _uA<media>()
                showImageList.value = _uA<String>()
                selectIndexList.value = _uA<String>()
                page.value = 1
                getMediaList()
            }
            val selectPath = fun(index: Number){
                accessTitle.value = pathList.value[index].name as String
                floderID.value = pathList.value[index].id as Number
                closeAccessList()
                refresh()
            }
            val requestPermission = fun(): UTSPromise<Boolean> {
                return wrapUTSPromise(suspend w1@{
                        console.log("权限请求")
                        var res = await(UTSPromise(fun(resolve, reject){
                            var perList = _uA(
                                "android.permission.READ_MEDIA_IMAGES",
                                "android.permission.READ_MEDIA_VIDEO",
                                "android.permission.WRITE_EXTERNAL_STORAGE"
                            )
                            if (UTSAndroid.checkSystemPermissionGranted(UTSAndroid.getUniActivity()!!, perList)) {
                                resolve(true)
                                console.log("权限请求结果")
                                return
                            }
                            UTSAndroid.requestSystemPermission(UTSAndroid.getUniActivity()!!, perList, fun(permission: Boolean, p: UTSArray<String>){
                                console.log("权限请求结果", permission, p)
                                resolve(permission)
                            }
                            , fun(perssion: Boolean, p: UTSArray<String>){
                                console.log("权限请求结果")
                                uni_showToast(ShowToastOptions(title = "无权限", position = "bottom"))
                                resolve(false)
                            }
                            )
                        }
                        ))
                        return@w1 res
                })
            }
            val complete = fun(files: UTSArray<UTSJSONObject>){
                console.log("已选中", files)
                uni__emit("iboxs-choosemedia", files)
                uni_navigateBack(null)
            }
            val getSelectedList = fun(): UTSArray<media> {
                var list = selectIndexList.value
                var selectedList = _uA<media>()
                for(it in resolveUTSValueIterator(list)){
                    var arr = it.split("-")
                    var index = UTSNumber.from(arr[0]).toInt()
                    var index2 = UTSNumber.from(arr[1]).toInt()
                    selectedList.push(showList.value[index][index2])
                }
                return selectedList
            }
            val compressImages = fun(uri: String): UTSPromise<String> {
                return wrapUTSPromise(suspend w1@{
                        var res = await(UTSPromise(fun(resolve, reject){
                            uni_compressImage(CompressImageOptions(src = uri, quality = 80, success = fun(res: CompressImageSuccess){
                                resolve(res.tempFilePath)
                            }
                            , fail = fun(_){
                                resolve(uri)
                            }
                            ))
                        }
                        ))
                        return@w1 res
                })
            }
            val compressVideo = fun(uri: String): UTSPromise<String> {
                return wrapUTSPromise(suspend w1@{
                        var res = await(UTSPromise(fun(resolve, reject){
                            uni_showLoading(ShowLoadingOptions(title = "压缩中", mask = true))
                            uni_compressVideo(CompressVideoOptions(src = uri, quality = "medium", success = fun(res: CompressVideoSuccess){
                                uni_hideLoading(null)
                                resolve(res.tempFilePath)
                            }
                            , fail = fun(_){
                                uni_hideLoading(null)
                                resolve(uri)
                            }
                            ))
                        }
                        ))
                        return@w1 res
                })
            }
            val handleVid = fun(item: UTSJSONObject, from: String): UTSPromise<UTSJSONObject> {
                return wrapUTSPromise(suspend w1@{
                        var thumb = item["thumb"] as String
                        var file = item["file"] as String
                        if (isCompress.value) {
                            file = await(compressVideo(file)) as String
                        }
                        var result: UTSJSONObject = _uO("from" to from, "compress" to isCompress.value, "type" to "video", "uri" to file, "thumb" to thumb, "ext" to item["ext"] as String, "duration" to item["duration"] as Double)
                        return@w1 result
                })
            }
            val handleVideo = fun(files: UTSArray<UTSJSONObject>, from: String): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        var resp = _uA<UTSJSONObject>()
                        for(item in resolveUTSValueIterator(files)){
                            var result = await(handleVid(item, from))
                            resp.push(result)
                        }
                        complete(resp)
                })
            }
            val handleImg = fun(item: UTSJSONObject, from: String): UTSPromise<UTSJSONObject> {
                return wrapUTSPromise(suspend w1@{
                        var uri = item["file"] as String
                        if (isCompress.value) {
                            uri = await(compressImages(item["file"] as String)) as String
                        } else {
                            uri = item["file"] as String
                        }
                        var result: UTSJSONObject = _uO("from" to from, "compress" to isCompress.value, "type" to "image", "uri" to uri, "thumb" to uri, "ext" to item["ext"] as String, "duration" to item["duration"] as Number)
                        return@w1 result
                })
            }
            val handleImage = fun(files: UTSArray<UTSJSONObject>, from: String): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        var resp = _uA<UTSJSONObject>()
                        for(item in resolveUTSValueIterator(files)){
                            var result = await(handleImg(item, from))
                            resp.push(result)
                        }
                        complete(resp)
                })
            }
            val clickComplete = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        var selectedList = getSelectedList()
                        console.log("选择", selectedList)
                        var result = _uA<UTSJSONObject>()
                        for(item in resolveUTSValueIterator(selectedList)){
                            if (item.type == "image") {
                                var handleItem: UTSJSONObject = _uO("thumb" to item.uri, "file" to item.file, "ext" to item.ext, "type" to item.type, "duration" to item.duration)
                                var rr = await(handleImg(handleItem, "album"))
                                result.push(rr)
                            } else if (item.type == "video") {
                                var handleItem2: UTSJSONObject = _uO("thumb" to item.uri, "file" to item.file, "type" to item.type, "ext" to item.ext, "duration" to item.duration)
                                var rr = await(handleVid(handleItem2, "album"))
                                result.push(rr)
                            }
                        }
                        console.log("选择结果", result)
                        complete(result)
                })
            }
            val next = fun(){
                if (page.value >= pageMax.value) {
                    return
                }
                page.value++
                getMediaList()
            }
            val clickImage = fun(index: Number, index2: Number){
                if (chooseCount.value == 1) {
                    var file = showList.value[index][index2] as media
                    if (file.type == "image") {
                        var list = _uA<UTSJSONObject>(_uO("file" to file.file, "thumb" to file.file, "ext" to file.ext, "duration" to file.duration))
                        handleImage(list, "album")
                    } else if (file.type == "video") {
                        var list = _uA<UTSJSONObject>(_uO("thumb" to file.uri, "file" to file.file, "ext" to file.ext, "duration" to file.duration))
                        handleVideo(list, "album")
                    }
                    return
                }
            }
            val getMedia = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var permission = await(requestPermission())
                        console.log("权限结果", permission)
                        if (!permission) {
                            return@w1
                        }
                        var count = MediaScanner.getTotalMediaCount(UTSAndroid.getAppContext() as Context, "all", 0)
                        var maxPage = Math.ceil(count.toFloat() / 150)
                        pageMax.value = maxPage
                        mediaCount.value = count
                        refresh()
                })
            }
            val useCamera = fun(){
                uni_chooseImage(ChooseImageOptions(albumMode = "system", sourceType = _uA(
                    "camera"
                ), success = fun(res: ChooseImageSuccess){
                    var file = res.tempFilePaths[0]
                    var extArr = file.split(".")
                    var ext = extArr[extArr.length - 1] as String
                    var data: UTSJSONObject = _uO("file" to file, "thumb" to file, "ext" to ext, "duration" to 0)
                    handleImage(_uA(
                        data
                    ), "camera")
                }
                , fail = fun(f: IMediaError){
                    console.log(f)
                    uni_showToast(ShowToastOptions(title = f.errMsg, icon = "error"))
                }
                ))
            }
            val previewCurrentImage = fun(){
                if (selectIndexList.value.length < 1) {
                    uni_showToast(ShowToastOptions(title = "请选择图片", icon = "none"))
                    return
                }
                var queryList = _uA<previewMedia__1>()
                var mediaList = getSelectedList()
                for(it in resolveUTSValueIterator(mediaList)){
                    queryList.push(previewMedia__1(type = it.type, uri = it.file as String))
                }
                previewImage__1(previewOptions__1(list = queryList))
            }
            onLoad(fun(options: OnLoadOptions){
                if (options["type"] != null) {
                    type.value = options["type"] as String
                    when (type.value) {
                        "image" -> 
                            accessTitle.value = "全部图片"
                        "video" -> 
                            accessTitle.value = "全部视频"
                        "all" -> 
                            accessTitle.value = "图片和视频"
                        else -> 
                            accessTitle.value = "图片和视频"
                    }
                }
                if (options["compress"] != null) {
                    compress.value = UTSNumber.from(options["compress"] as String).toInt()
                    if (compress.value == 2) {
                        isCompress.value = false
                    }
                }
                if (options["count"] != null) {
                    chooseCount.value = UTSNumber.from(options["count"] as String).toInt()
                }
                if (options["camera"] != null) {
                    console.log("相机状态", options["camera"])
                    showCamera.value = options["camera"] == "true"
                }
            }
            )
            onReady(fun(){
                windowHeight.value = uni_getWindowInfo().windowHeight
                pageHeight.value = uni_getWindowInfo().safeArea.height - 46
                listMaxHeight.value = pageHeight.value - 80
                getMedia()
            }
            )
            return fun(): Any? {
                return _cE("view", null, _uA(
                    _cE("view", _uM("class" to "navigate padding-stauts-bar"), _uA(
                        _cE("view", _uM("class" to "titlebox"), _uA(
                            _cE("view", _uM("class" to "access display-flex", "onClick" to showAccessList), _uA(
                                _cE("text", _uM("class" to "names color-white"), _tD(unref(accessTitle)), 1),
                                if (unref(pathIDList).length > 0) {
                                    _cV(unref(GenUniModulesIboxsChoosemediaComponentsXuIconfontClass), _uM("key" to 0, "class" to "xiangxia", "name" to if (unref(showPopup)) {
                                        "xiangshang"
                                    } else {
                                        "xiangxia"
                                    }, "size" to "19", "color" to "#b2b2b2"), null, 8, _uA(
                                        "name"
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                            )),
                            _cV(unref(GenUniModulesIboxsChoosemediaComponentsXuIconfontClass), _uM("onClick" to closeChoosePage, "height" to 32, "class" to "closebtn", "size" to "28", "name" to "close", "color" to "#fff")),
                            if (isTrue(unref(showCamera))) {
                                _cV(unref(GenUniModulesIboxsChoosemediaComponentsXuIconfontClass), _uM("key" to 0, "onClick" to useCamera, "height" to 32, "size" to "28", "class" to "camrea", "name" to "zhaoxiangji", "color" to "#fff"))
                            } else {
                                _cC("v-if", true)
                            }
                        ))
                    )),
                    _cE("view", _uM("class" to "page"), _uA(
                        _cV(unref(GenUniModulesIboxsChoosemediaComponentsXuCheckboxGroupClass), _uM("name" to "image", "onChange" to imageSelected), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("list-view", _uM("class" to "list", "onScrolltolower" to next, "direction" to "vertical", "style" to _nS(_uM("maxHeight" to (unref(pageHeight) + "px")))), _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(unref(showList), fun(list, index, __index, _cached): Any {
                                        return _cE("list-item", _uM("type" to 3, "key" to index), _uA(
                                            _cE("view", _uM("class" to "display-flex"), _uA(
                                                _cE(Fragment, null, RenderHelpers.renderList(list, fun(item, index2, __index, _cached): Any {
                                                    return _cE("view", _uM("class" to "imglist item", "key" to index2, "onClick" to fun(){
                                                        clickImage(index, index2)
                                                    }
                                                    ), _uA(
                                                        _cE("image", _uM("mode" to "aspectFill", "src" to item.uri, "class" to "img", "onLoad" to fun(){
                                                            loadComplete(index, index2)
                                                        }
                                                        , "onError" to fun(){
                                                            loadError(index, index2)
                                                        }
                                                        ), null, 40, _uA(
                                                            "src",
                                                            "onLoad",
                                                            "onError"
                                                        )),
                                                        if (isTrue(unref(errorImageList).indexOf(index + "-" + index2) < 0 && unref(showImageList).indexOf(index + "-" + index2) > -1 && item.type != "camera" && unref(chooseCount) > 1)) {
                                                            _cV(unref(GenUniModulesIboxsChoosemediaComponentsXuCheckboxImageClass), _uM("key" to 0, "ref_for" to true, "ref" to "checkimg", "checkCount" to unref(selectIndexList).length, "maxCount" to unref(chooseCount), "value" to (index + "-" + index2), "number" to unref(selectIndexList).indexOf(index + "-" + index2), "class" to "checkbox"), null, 8, _uA(
                                                                "checkCount",
                                                                "maxCount",
                                                                "value",
                                                                "number"
                                                            ))
                                                        } else {
                                                            _cC("v-if", true)
                                                        }
                                                        ,
                                                        if (isTrue(item.type == "video" && item.type != "camera")) {
                                                            _cE("view", _uM("key" to 1, "class" to "video"), _uA(
                                                                _cE("text", _uM("class" to "color-white"), _tD(item.duration), 1)
                                                            ))
                                                        } else {
                                                            _cC("v-if", true)
                                                        }
                                                    ), 8, _uA(
                                                        "onClick"
                                                    ))
                                                }
                                                ), 128)
                                            ))
                                        ))
                                    }
                                    ), 128),
                                    _cE("list-item", _uM("style" to _nS(_uM("height" to "46px"))), null, 4)
                                ), 36)
                            )
                        }
                        ), "_" to 1))
                    )),
                    _cE("view", _uM("class" to "actionbottom padding-safe-bottom"), _uA(
                        _cE("view", _uM("class" to "actions space-between"), _uA(
                            _cE("view", _uM("class" to "yulan display-flex", "onClick" to previewCurrentImage), _uA(
                                _cE("text", _uM("class" to "namel color-white"), "预览"),
                                if (unref(selectIndexList).length > 0) {
                                    _cE("text", _uM("key" to 0, "class" to "number color-white"), "(" + _tD(unref(selectIndexList).length) + ")", 1)
                                } else {
                                    _cC("v-if", true)
                                }
                            )),
                            _cE("view", _uM("class" to "display-flex")),
                            if (unref(compress) == 0) {
                                _cE("view", _uM("key" to 0, "class" to "yuantu"), _uA(
                                    _cE("view", _uM("class" to "yt"), _uA(
                                        _cV(unref(GenUniModulesIboxsChoosemediaComponentsXuCheckboxGroupClass), _uM("class" to "display-flex", "onChange" to changeCompress), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _cV(unref(GenUniModulesIboxsChoosemediaComponentsXuCheckboxClass), _uM("value" to "c")),
                                                _cE("text", _uM("class" to "content color-white"), "原图")
                                            )
                                        }), "_" to 1))
                                    ))
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                            ,
                            _cE("view", _uM("class" to "complete"), _uA(
                                _cE("button", _uM("class" to "btn", "onClick" to clickComplete, "hover-class" to "none"), "完成")
                            ))
                        ))
                    )),
                    _cV(unref(GenUniModulesIboxsChoosemediaComponentsXuPopupClass), _uM("class" to "padding-safe-bottom", "ref_key" to "popup", "ref" to popup, "onSetShow" to setShow), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("list-view", _uM("direction" to "vertical", "class" to "accesslist", "style" to _nS(_uM("height" to unref(listHeight), "maxHeight" to unref(listMaxHeight)))), _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(unref(pathList), fun(item, index, __index, _cached): Any {
                                    return _cE("list-item", _uM("type" to 2, "key" to index), _uA(
                                        _cE("view", _uM("class" to "path space-between", "onClick" to fun(){
                                            selectPath(index)
                                        }
                                        ), _uA(
                                            _cE("view", _uM("class" to "basicinfo display-flex"), _uA(
                                                _cE("image", _uM("mode" to "aspectFill", "src" to item.uri, "class" to "img"), null, 8, _uA(
                                                    "src"
                                                )),
                                                _cE("view", _uM("class" to "pname display-flex"), _uA(
                                                    _cE("text", _uM("class" to "pathname color-white"), _tD(item.name), 1),
                                                    _cE("text", _uM("class" to "number"), "(" + _tD(item.count) + ")", 1)
                                                ))
                                            )),
                                            _cE("view", _uM("class" to "seleted"), _uA(
                                                if (item.id == unref(floderID)) {
                                                    _cV(unref(GenUniModulesIboxsChoosemediaComponentsXuIconfontClass), _uM("key" to 0, "class" to "close", "height" to 60, "size" to "15", "name" to "gougou", "color" to "#1678fd"))
                                                } else {
                                                    _cC("v-if", true)
                                                }
                                            ))
                                        ), 8, _uA(
                                            "onClick"
                                        ))
                                    ))
                                }
                                ), 128)
                            ), 4)
                        )
                    }
                    ), "_" to 1), 512)
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
                return _uM("color-white" to _pS(_uM("color" to "#FFFFFF")), "list-items" to _pS(_uM("flexWrap" to "wrap", "flexDirection" to "row")), "litem" to _uM(".list-items " to _uM("flexGrow" to 0, "flexShrink" to 0)), "top-status-bar" to _pS(_uM("top" to CSS_VAR_STATUS_BAR_HEIGHT)), "padding-stauts-bar" to _pS(_uM("paddingTop" to CSS_VAR_STATUS_BAR_HEIGHT)), "margin-status-bar" to _pS(_uM("marginTop" to CSS_VAR_STATUS_BAR_HEIGHT)), "height-status-bar" to _pS(_uM("height" to CSS_VAR_STATUS_BAR_HEIGHT)), "safe-bottom" to _pS(_uM("bottom" to "var(--uni-safe-area-inset-bottom)")), "padding-safe-bottom" to _pS(_uM("paddingBottom" to "var(--uni-safe-area-inset-bottom)")), "safe-bottom-view" to _pS(_uM("width" to "750rpx", "left" to 0, "height" to "var(--uni-safe-area-inset-bottom)", "position" to "fixed", "bottom" to 0)), "overline" to _pS(_uM("whiteSpace" to "nowrap", "overflow" to "hidden", "textOverflow" to "ellipsis")), "display-flex" to _pS(_uM("display" to "flex", "flexDirection" to "row")), "space-between" to _pS(_uM("justifyContent" to "space-between", "display" to "flex", "flexDirection" to "row")), "list" to _pS(_uM("width" to "750rpx")), "item" to _uM(".list " to _uM("width" to "187.5rpx", "height" to "187.5rpx", "position" to "relative")), "img" to _uM(".list .item " to _uM("marginRight" to "3rpx", "marginBottom" to "3rpx", "width" to "184.5rpx", "height" to "184.5rpx"), ".path .basicinfo " to _uM("width" to "120rpx", "height" to "120rpx")), "video" to _uM(".list .item " to _uM("position" to "absolute", "left" to 0, "bottom" to 0, "height" to 0)), "checkbox" to _uM(".list .item " to _uM("position" to "absolute", "right" to "10rpx", "top" to "10rpx")), "navigate" to _pS(_uM("backgroundImage" to "none", "backgroundColor" to "#333333")), "titlebox" to _uM(".navigate " to _uM("height" to 46, "position" to "relative")), "name" to _uM(".navigate .titlebox " to _uM("marginTop" to 0, "marginRight" to "auto", "marginBottom" to 0, "marginLeft" to "auto", "lineHeight" to "42px", "fontSize" to 16)), "closebtn" to _uM(".navigate .titlebox " to _uM("position" to "absolute", "top" to 6, "left" to 14, "fontSize" to 16)), "camrea" to _uM(".navigate .titlebox " to _uM("position" to "absolute", "top" to 8, "right" to 14)), "actionbottom" to _pS(_uM("position" to "fixed", "bottom" to 0, "left" to 0, "width" to "750rpx", "backgroundImage" to "none", "backgroundColor" to "#333333c0")), "actions" to _uM(".actionbottom " to _uM("height" to 46, "paddingTop" to 10, "paddingLeft" to "10rpx", "position" to "relative")), "yulan" to _uM(".actionbottom .actions " to _uM("position" to "absolute", "top" to 10, "left" to 30)), "namel" to _uM(".actionbottom .actions .yulan " to _uM("fontSize" to 15)), "number" to _uM(".actionbottom .actions .yulan " to _uM("fontSize" to 15), ".path .basicinfo .pname " to _uM("paddingLeft" to "10rpx", "lineHeight" to "60px", "color" to "#b8b8b8c0")), "yuantu" to _uM(".actionbottom .actions " to _uM("position" to "absolute", "left" to "330rpx")), "content" to _uM(".actionbottom .actions .yuantu .yt " to _uM("paddingTop" to 1, "fontSize" to 15, "paddingLeft" to "6rpx")), "complete" to _uM(".actionbottom .actions " to _uM("marginRight" to "30rpx", "paddingRight" to "20rpx", "marginTop" to -3)), "btn" to _uM(".actionbottom .actions .complete " to _uM("paddingLeft" to 0, "paddingRight" to 0, "textAlign" to "center", "lineHeight" to "26px", "borderTopWidth" to 0, "borderRightWidth" to 0, "borderBottomWidth" to 0, "borderLeftWidth" to 0, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#000000", "borderRightColor" to "#000000", "borderBottomColor" to "#000000", "borderLeftColor" to "#000000", "width" to 60, "height" to 26, "fontSize" to 12, "backgroundColor" to "#1678fd", "color" to "#FFFFFF")), "page" to _pS(_uM("backgroundImage" to "none", "backgroundColor" to "#484848")), "access" to _pS(_uM("paddingLeft" to "20rpx", "maxWidth" to "600rpx", "marginTop" to 8, "marginRight" to "auto", "marginBottom" to 0, "marginLeft" to "auto", "backgroundImage" to "none", "backgroundColor" to "#4c4c4c", "height" to 30, "borderTopLeftRadius" to 15, "borderTopRightRadius" to 15, "borderBottomRightRadius" to 15, "borderBottomLeftRadius" to 15, "paddingRight" to "20rpx")), "names" to _uM(".access " to _uM("paddingTop" to 0, "marginTop" to 0, "fontSize" to 16, "lineHeight" to "30px", "maxWidth" to "500rpx")), "xiangxia" to _uM(".access " to _uM("paddingTop" to 5, "paddingLeft" to 3)), "accesslist" to _pS(_uM("width" to "750rpx", "minHeight" to 60, "backgroundColor" to "#333333")), "path" to _pS(_uM("height" to 60, "width" to "750rpx", "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#474747")), "basicinfo" to _uM(".path " to _uM("maxWidth" to "600rpx")), "pathname" to _uM(".path .basicinfo .pname " to _uM("paddingLeft" to "20rpx", "lineHeight" to "60px")), "seleted" to _uM(".path " to _uM("height" to 60, "paddingRight" to 10)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
