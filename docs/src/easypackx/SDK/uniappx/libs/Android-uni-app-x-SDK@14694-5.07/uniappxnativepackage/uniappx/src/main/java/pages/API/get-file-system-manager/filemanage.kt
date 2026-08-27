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
import io.dcloud.uniapp.extapi.env as uni_env
import io.dcloud.uniapp.extapi.getElementById as uni_getElementById
import io.dcloud.uniapp.extapi.getFileSystemManager as uni_getFileSystemManager
import io.dcloud.uniapp.extapi.openDocument as uni_openDocument
import io.dcloud.uniapp.extapi.previewImage as uni_previewImage
import io.dcloud.uniapp.extapi.showModal as uni_showModal
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesAPIGetFileSystemManagerFilemanage : BasePage {
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
        var setup: (__props: GenPagesAPIGetFileSystemManagerFilemanage) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIGetFileSystemManagerFilemanage
            val _cache = __ins.renderCache
            var fileList = ref(_uA<fileListType>())
            var count = ref(0)
            var size = ref(0)
            var rootPath = ref("")
            var dialogShow = ref(false)
            val uniIcon = ref("\uE661")
            var currentFile = ref(fileListType(path = "", shotPath = "", size = 0, isFile = false, modifyTime = ""))
            var cacheOrData = ref(uni_env.USER_DATA_PATH)
            val switchCacheOrData = fun(e: UniRadioGroupChangeEvent){
                cacheOrData.value = if ((e.detail.value == "cache")) {
                    uni_env.CACHE_PATH
                } else {
                    uni_env.USER_DATA_PATH
                }
            }
            val refreshFile = fun(){
                val fileManager = uni_getFileSystemManager()
                fileManager.stat(StatOptions(path = cacheOrData.value, recursive = true, success = fun(res: StatSuccessResult){
                    console.log("statFileInfo success1")
                    console.log("res.stats", res.stats)
                    console.log("uni.env.CACHE_PATH: ", uni_env.CACHE_PATH)
                    console.log("uni.env.USER_DATA_PATH: ", uni_env.USER_DATA_PATH)
                    console.log("uni.env.SANDBOX_PATH: ", uni_env.SANDBOX_PATH)
                    var tempFileList = _uA<fileListType>()
                    var tempSize: Number = 0
                    run {
                        var i: Number = 0
                        while(i < res.stats.length){
                            console.log("resitem", res.stats[i].path)
                            if (i == 0) {
                                rootPath.value = res.stats[i].path
                                i++
                                continue
                            }
                            var tempFileItem = fileListType(path = "", shotPath = "", size = 0, isFile = false, modifyTime = "")
                            tempFileItem.shotPath = res.stats[i].path.replace(rootPath.value, "")
                            tempFileItem.path = res.stats[i].path
                            tempFileItem.size = res.stats[i].stats.size / 1024
                            tempFileItem.isFile = res.stats[i].stats.isFile()
                            val mdate = Date(res.stats[i].stats.lastModifiedTime * 1000)
                            tempFileItem.modifyTime = mdate.getFullYear().toString(10) + "-" + (mdate.getMonth() + 1).toString(10) + "-" + mdate.getDate().toString(10) + " " + mdate.getHours().toString(10) + ":" + mdate.getMinutes().toString(10) + ":" + mdate.getSeconds().toString(10)
                            tempSize = tempSize + res.stats[i].stats.size
                            tempFileList.push(tempFileItem)
                            i++
                        }
                    }
                    fileList.value = tempFileList
                    size.value = tempSize / 1024 / 1024
                    count.value = tempFileList.length
                }
                , fail = fun(res: IUniError){
                    uni_showModal(ShowModalOptions(title = "获取文件状态失败", content = res.errMsg, showCancel = false))
                    console.error("statFileInfo fail", res)
                }
                , complete = fun(res: Any){
                    console.log("statFileInfo complete", res)
                }
                ))
            }
            val showDialog = fun(item: fileListType){
                currentFile.value = item
                dialogShow.value = true
            }
            val closeDialog = fun(){
                dialogShow.value = false
            }
            val deleteFile = fun(fileItem: fileListType){
                val fileManager = uni_getFileSystemManager()
                var path = cacheOrData.value + fileItem.path
                if (fileItem.isFile) {
                    fileManager.unlink(UnLinkOptions(filePath = path, success = fun(_res){
                        refreshFile()
                        closeDialog()
                    }, fail = fun(err: IFileSystemManagerFail){
                        uni_showModal(ShowModalOptions(title = "删除文件失败", content = err.errMsg, showCancel = false))
                    }))
                } else {
                    fileManager.rmdir(RmDirOptions(dirPath = path, recursive = true, success = fun(_res){
                        refreshFile()
                        closeDialog()
                    }
                    , fail = fun(err: IFileSystemManagerFail){
                        uni_showModal(ShowModalOptions(title = "删除目录失败", content = err.errMsg, showCancel = false))
                    }
                    ))
                }
            }
            val clearFile = fun(){
                val fileManager = uni_getFileSystemManager()
                fileManager.rmdir(RmDirOptions(dirPath = uni_env.CACHE_PATH, recursive = true, success = fun(res: FileManagerSuccessResult){
                    console.log("rmdir success", res)
                    fileList.value = _uA<fileListType>()
                    size.value = 0
                    count.value = 0
                    uni_showToast(ShowToastOptions(title = "清空缓存目录成功", icon = "success"))
                }
                , fail = fun(res: IFileSystemManagerFail){
                    console.error("清空缓存目录失败", res)
                    uni_showModal(ShowModalOptions(title = "清空缓存目录失败", content = res.errMsg, showCancel = false))
                }
                , complete = fun(res: Any){
                    console.log("rmdir complete", res)
                }
                ))
            }
            val openFile = fun(fileItem: fileListType){
                var path = cacheOrData.value + fileItem.path
                var suffix = path.split(".").pop()
                when (suffix) {
                    "jpg", "png", "gif", "jpeg", "webp", "bmp", "ico", "heic", "heif", "tif" -> 
                        {
                            console.log("path:", path)
                            uni_previewImage(PreviewImageOptions(urls = _uA(
                                path
                            )))
                        }
                    else -> 
                        uni_openDocument(OpenDocumentOptions(filePath = path, success = fun(res){
                            console.log("openDocument success", res)
                        }
                        , fail = fun(res){
                            console.error("openDocument fail", res)
                            uni_showModal(ShowModalOptions(title = "打开文件失败", content = res.errMsg, showCancel = false))
                        }
                        ))
                }
            }
            val snapshot = fun(){
                uni_getElementById("rootview")!!.takeSnapshot(TakeSnapshotOptions())
            }
            val getIndentStyle = fun(path: String): UTSJSONObject {
                val matches = path.match(UTSRegExp("\\/", "g"))
                var level: Number = 0
                if (matches != null) {
                    level = matches.length
                }
                return _uO("paddingLeft" to ("" + level * 20 + "px"))
            }
            return fun(): Any? {
                val _component_radio = resolveComponent("radio")
                val _component_radio_group = resolveComponent("radio-group")
                return _cE(Fragment, null, _uA(
                    _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row")), "id" to "rootview"), _uA(
                        _cV(_component_radio_group, _uM("onChange" to switchCacheOrData), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cV(_component_radio, _uM("value" to "data", "checked" to true), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        "数据目录"
                                    )
                                }
                                ), "_" to 1)),
                                _cV(_component_radio, _uM("value" to "cache"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        "缓存目录"
                                    )
                                }
                                ), "_" to 1))
                            )
                        }
                        ), "_" to 1)),
                        _cE("button", _uM("onClick" to refreshFile), "刷新"),
                        _cE("button", _uM("onClick" to clearFile), "清空缓存"),
                        _cE("button", _uM("onClick" to snapshot), "截图")
                    ), 4),
                    _cE("text", null, "文件总数：" + _tD(unref(count)) + "；\n文件总大小：" + _tD(unref(size)) + " M", 1),
                    _cE("text", _uM("style" to _nS(_uM("border" to "1px solid #ccc", "margin" to "5px"))), "根路径：" + _tD(unref(rootPath)), 5),
                    _cE("list-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                        _cE(Fragment, null, RenderHelpers.renderList(unref(fileList), fun(item, index, __index, _cached): Any {
                            return _cE("list-item", _uM("key" to index, "style" to _nS(_uA(
                                _uM("padding" to "5px", "border-bottom" to "1px solid #ccc"),
                                getIndentStyle(item.shotPath)
                            )), "onClick" to fun(){
                                showDialog(item)
                            }
                            ), _uA(
                                _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row"))), _uA(
                                    if (isTrue(!item.isFile)) {
                                        _cE("text", _uM("key" to 0, "style" to _nS(_uM("font-family" to "uni-icon"))), _tD(unref(uniIcon)), 5)
                                    } else {
                                        _cC("v-if", true)
                                    }
                                    ,
                                    _cE("text", null, _tD((item.shotPath as String)), 1)
                                ), 4),
                                if (isTrue(item.isFile)) {
                                    _cE("text", _uM("key" to 0, "style" to _nS(_uM("font-size" to "12px", "color" to "#ccc"))), _tD(item.size) + "k", 5)
                                } else {
                                    _cC("v-if", true)
                                }
                            ), 12, _uA(
                                "onClick"
                            ))
                        }
                        ), 128)
                    ), 4),
                    if (isTrue(unref(dialogShow))) {
                        _cE("view", _uM("key" to 0, "style" to _nS(_uM("position" to "fixed", "top" to "0", "bottom" to "0", "left" to "0", "right" to "0", "align-items" to "center", "justify-content" to "center", "z-index" to "1000", "background-color" to "rgba(16, 16, 16, 0.5)"))), _uA(
                            _cE("view", _uM("style" to _nS(_uM("background-color" to "#fff", "padding" to "10px", "border-radius" to "10px", "width" to "90%", "margin" to "0 auto"))), _uA(
                                _cE("text", _uM("style" to _nS(_uM("font-size" to "20px", "font-weight" to "bold"))), _tD(unref(currentFile).shotPath), 5),
                                _cE("text", null, "类型：" + _tD(if (unref(currentFile).isFile) {
                                    "文件"
                                } else {
                                    "目录"
                                }), 1),
                                _cE("text", null, "路径：" + _tD(unref(currentFile).path), 1),
                                _cE("text", null, "大小：" + _tD(unref(currentFile).size) + "k", 1),
                                _cE("text", null, "修改时间：" + _tD(unref(currentFile).modifyTime), 1),
                                _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row", "width" to "100%", "justify-content" to "space-between", "padding" to "10px"))), _uA(
                                    if (isTrue(unref(currentFile).isFile)) {
                                        _cE("button", _uM("key" to 0, "onClick" to fun(){
                                            openFile(unref(currentFile))
                                        }, "size" to "mini"), "打开", 8, _uA(
                                            "onClick"
                                        ))
                                    } else {
                                        _cC("v-if", true)
                                    },
                                    _cE("button", _uM("onClick" to fun(){
                                        deleteFile(unref(currentFile))
                                    }, "size" to "mini"), "删除", 8, _uA(
                                        "onClick"
                                    )),
                                    _cE("button", _uM("onClick" to closeDialog, "size" to "mini"), "关闭")
                                ), 4)
                            ), 4)
                        ), 4)
                    } else {
                        _cC("v-if", true)
                    }
                ), 64)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
