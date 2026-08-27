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
import io.dcloud.uniapp.extapi.chooseVideo as uni_chooseVideo
import io.dcloud.uniapp.extapi.getElementById as uni_getElementById
import io.dcloud.uniapp.extapi.hideToast as uni_hideToast
import io.dcloud.uniapp.extapi.shareWithSystem as uni_shareWithSystem
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesAPIShareWithSystemShareWithSystem : BasePage {
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
        var setup: (__props: GenPagesAPIShareWithSystemShareWithSystem) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIShareWithSystemShareWithSystem
            val _cache = __ins.renderCache
            val summary = "欢迎使用hello uniapp-x"
            val sharePrivateErrorAudios = fun(){
                uni_hideToast()
                val path1: String = "/static/test-audio/ForElise.mp3"
                val path2: String = "/static/test-audio/ForElise.mp32"
                uni_shareWithSystem(ShareWithSystemOptions(audioPaths = _uA(
                    path1,
                    path2
                ), type = "audio", success = fun(_) {
                    console.log("Shared----------------------------success")
                }
                , fail = fun(res) {
                    console.log("Share failed, res.errCode =" + res.errCode + "---res.errMsg= " + res.errMsg)
                    uni_showToast(ShowToastOptions(icon = "error", title = "errorCode=" + res.errCode))
                }
                , complete = fun(_) {}))
            }
            val sharePrivateErrorFiles = fun(){
                uni_hideToast()
                val path1: String = "/static/filemanager1/to.zip"
                val path2: String = "/static/filemanager/11.txt.br"
                uni_shareWithSystem(ShareWithSystemOptions(filePaths = _uA(
                    path1,
                    path2
                ), type = "file", success = fun(_) {
                    console.log("Shared----------------------------success")
                }
                , fail = fun(res) {
                    console.log("Share failed, res.errCode =" + res.errCode + "---res.errMsg= " + res.errMsg)
                    uni_showToast(ShowToastOptions(icon = "error", title = "errorCode=" + res.errCode))
                }
                , complete = fun(_) {}))
            }
            val sharePrivateFile = fun(){
                uni_hideToast()
                val path1: String = "/static/filemanager/to.zip"
                uni_shareWithSystem(ShareWithSystemOptions(filePaths = _uA(
                    path1
                ), type = "file", success = fun(_) {
                    console.log("Shared----------------------------success")
                }
                , fail = fun(res) {
                    console.log("Share failed, res.errCode =" + res.errCode + "---res.errMsg= " + res.errMsg)
                    uni_showToast(ShowToastOptions(icon = "error", title = "errorCode=" + res.errCode))
                }
                , complete = fun(_) {}))
            }
            val sharePrivateFiles = fun(){
                uni_hideToast()
                val path1: String = "/static/filemanager/to.zip"
                val path2: String = "/static/filemanager/1.txt.br"
                uni_shareWithSystem(ShareWithSystemOptions(filePaths = _uA(
                    path1,
                    path2
                ), type = "file", success = fun(_) {
                    console.log("Shared----------------------------success")
                }
                , fail = fun(res) {
                    console.log("Share failed, res.errCode =" + res.errCode + "---res.errMsg= " + res.errMsg)
                    uni_showToast(ShowToastOptions(icon = "error", title = "errorCode=" + res.errCode))
                }
                , complete = fun(_) {}))
            }
            val sharePrivateAudio = fun(){
                uni_hideToast()
                val path1: String = "/static/test-audio/ForElise.mp3"
                uni_shareWithSystem(ShareWithSystemOptions(audioPaths = _uA(
                    path1
                ), type = "audio", success = fun(_) {
                    console.log("Shared----------------------------success")
                }
                , fail = fun(res) {
                    console.log("Share failed, res.errCode =" + res.errCode + "---res.errMsg= " + res.errMsg)
                    uni_showToast(ShowToastOptions(icon = "error", title = "errorCode=" + res.errCode))
                }
                , complete = fun(_) {}))
            }
            val sharePrivateAudios = fun(){
                uni_hideToast()
                val path1: String = "/static/test-audio/ForElise.mp3"
                val path2: String = "/static/test-audio/ForElise.mp3"
                uni_shareWithSystem(ShareWithSystemOptions(audioPaths = _uA(
                    path1,
                    path2
                ), type = "audio", success = fun(_) {
                    console.log("Shared----------------------------success")
                }
                , fail = fun(res) {
                    console.log("Share failed, res.errCode =" + res.errCode + "---res.errMsg= " + res.errMsg)
                    uni_showToast(ShowToastOptions(icon = "error", title = "errorCode=" + res.errCode))
                }
                , complete = fun(_) {}))
            }
            val sharePrivateErrorVideos = fun(){
                uni_hideToast()
                val path1: String = "/static/test-video/10second-demo.mp4"
                val path2: String = "/static/test-video/10second-demo1.mp4"
                uni_shareWithSystem(ShareWithSystemOptions(videoPaths = _uA(
                    path1,
                    path2
                ), type = "video", success = fun(_) {
                    console.log("Shared----------------------------success")
                }
                , fail = fun(res) {
                    console.log("Share failed, res.errCode =" + res.errCode + "---res.errMsg= " + res.errMsg)
                    uni_showToast(ShowToastOptions(icon = "error", title = "errorCode=" + res.errCode))
                }
                , complete = fun(_) {}))
            }
            val sharePrivateVideo = fun(){
                uni_hideToast()
                val path1: String = "/static/test-video/10second-demo.mp4"
                uni_shareWithSystem(ShareWithSystemOptions(videoPaths = _uA(
                    path1
                ), type = "video", success = fun(_) {
                    console.log("Shared----------------------------success")
                }
                , fail = fun(res) {
                    console.log("Share failed, res.errCode =" + res.errCode + "---res.errMsg= " + res.errMsg)
                    uni_showToast(ShowToastOptions(icon = "error", title = "errorCode=" + res.errCode))
                }
                , complete = fun(_) {}))
            }
            val sharePrivateVideos = fun(){
                uni_hideToast()
                val path1: String = "/static/test-video/10second-demo.mp4"
                val path2: String = "/static/test-video/10second-demo.mp4"
                uni_shareWithSystem(ShareWithSystemOptions(videoPaths = _uA(
                    path1,
                    path2
                ), type = "video", success = fun(_) {
                    console.log("Shared----------------------------success")
                }
                , fail = fun(res) {
                    console.log("Share failed, res.errCode =" + res.errCode + "---res.errMsg= " + res.errMsg)
                    uni_showToast(ShowToastOptions(icon = "error", title = "errorCode=" + res.errCode))
                }
                , complete = fun(_) {}))
            }
            val sharePubMedias = fun(){
                uni_hideToast()
                uni_chooseVideo(ChooseVideoOptions(success = fun(res) {
                    uni_shareWithSystem(ShareWithSystemOptions(videoPaths = _uA(
                        res.tempFilePath
                    ), type = "video", success = fun(_) {
                        console.log("Shared----------------------------success")
                    }
                    , fail = fun(res) {
                        console.log("Share failed, res.errCode =" + res.errCode + "---res.errMsg= " + res.errMsg)
                        uni_showToast(ShowToastOptions(icon = "error", title = "errorCode=" + res.errCode))
                    }
                    , complete = fun(_) {}))
                }
                ))
            }
            val shareText = fun(){
                uni_hideToast()
                uni_shareWithSystem(ShareWithSystemOptions(summary = summary, type = "text", success = fun(_) {
                    console.log("Shared----------------------------success")
                }
                , fail = fun(res) {
                    console.log("Share failed, res.errCode =" + res.errCode + "---res.errMsg= " + res.errMsg)
                    uni_showToast(ShowToastOptions(icon = "error", title = "errorCode=" + res.errCode))
                }
                , complete = fun(_) {}))
            }
            val shareLink = fun(){
                uni_hideToast()
                uni_shareWithSystem(ShareWithSystemOptions(type = "text", href = "https://uniapp.dcloud.io", success = fun(_) {
                    console.log("Shared----------------------------success")
                }
                , fail = fun(res) {
                    console.log("Share failed, res.errCode =" + res.errCode + "---res.errMsg= " + res.errMsg)
                    uni_showToast(ShowToastOptions(icon = "error", title = "errorCode=" + res.errCode))
                }
                , complete = fun(_) {}))
            }
            val sharePrivateImg = fun(){
                uni_hideToast()
                val imageSrc: String = "/static/test-image/logo.gif"
                uni_shareWithSystem(ShareWithSystemOptions(type = "image", imageUrl = imageSrc, success = fun(_) {
                    console.log("Shared----------------------------success")
                }
                , fail = fun(res) {
                    console.log("Share failed, res.errCode =" + res.errCode + "---res.errMsg= " + res.errMsg)
                    uni_showToast(ShowToastOptions(icon = "error", title = "errorCode=" + res.errCode))
                }
                , complete = fun(_) {}))
            }
            val sharePrivateErrorImg = fun(){
                uni_hideToast()
                val imageSrc: String = "/static/test-image/logo.jpg11"
                uni_shareWithSystem(ShareWithSystemOptions(imageUrl = imageSrc, type = "image", success = fun(_) {
                    console.log("Shared----------------------------success")
                }
                , fail = fun(res) {
                    console.log("Share failed, res.errCode =" + res.errCode + "---res.errMsg= " + res.errMsg)
                    uni_showToast(ShowToastOptions(icon = "error", title = "errorCode=" + res.errCode))
                }
                , complete = fun(_) {}))
            }
            val sharePrivateImgs = fun(){
                uni_hideToast()
                val errorImageSrc2: String = "/static/test-image/logo.png"
                val imageSrc: String = "/static/test-image/logo.jpg"
                var imageUrlList: UTSArray<String> = UTSArray()
                imageUrlList.push(errorImageSrc2)
                imageUrlList.push(imageSrc)
                uni_shareWithSystem(ShareWithSystemOptions(imagePaths = imageUrlList, type = "image", success = fun(_) {
                    console.log("Shared----------------------------success")
                }
                , fail = fun(res) {
                    console.log("Share failed, res.errCode =" + res.errCode + "---res.errMsg= " + res.errMsg)
                    uni_showToast(ShowToastOptions(icon = "error", title = "errorCode=" + res.errCode))
                }
                , complete = fun(_) {}))
            }
            val sharePrivateErrorImgs = fun(){
                uni_hideToast()
                val errorImageSrc1: String = "/static/test-image/logo.jpg1"
                val errorImageSrc2: String = "/static/test-image/logo.jpg3"
                val imageSrc: String = "/static/test-image/logo.jpg"
                var imageUrlList: UTSArray<String> = UTSArray()
                imageUrlList.push(imageSrc)
                imageUrlList.push(errorImageSrc1)
                imageUrlList.push(errorImageSrc2)
                uni_shareWithSystem(ShareWithSystemOptions(imagePaths = imageUrlList, type = "image", success = fun(_) {
                    console.log("Shared----------------------------success")
                }
                , fail = fun(res) {
                    console.log("Share failed, res.errCode =" + res.errCode + "---res.errMsg= " + res.errMsg)
                    uni_showToast(ShowToastOptions(icon = "error", title = "errorCode=" + res.errCode))
                }
                , complete = fun(_) {}))
            }
            val shareAll = fun(){
                uni_hideToast()
                val imageSrc: String = "/static/test-video/fast-forward.png"
                var imageUrlList: UTSArray<String> = UTSArray()
                imageUrlList.push(imageSrc)
                uni_shareWithSystem(ShareWithSystemOptions(summary = summary, href = "https://uniapp.dcloud.io", imagePaths = imageUrlList, type = "image", success = fun(_) {
                    console.log("Shared----------------------------success")
                }
                , fail = fun(res) {
                    console.log("Share failed, res.errCode =" + res.errCode + "---res.errMsg= " + res.errMsg)
                    uni_showToast(ShowToastOptions(icon = "error", title = "errorCode=" + res.errCode))
                }
                , complete = fun(_) {}))
            }
            val sharePubImg = fun(){
                uni_hideToast()
                uni_chooseImage(ChooseImageOptions(count = 3, sourceType = _uA(
                    "camera",
                    "album"
                ), success = fun(e) {
                    console.log(e)
                    console.log(JSON.stringify(e))
                    uni_shareWithSystem(ShareWithSystemOptions(imagePaths = e.tempFilePaths, type = "image", success = fun(_) {
                        console.log("Shared----------------------------success")
                    }
                    , fail = fun(res) {
                        console.log("Share failed, res.errCode =" + res.errCode + "---res.errMsg= " + res.errMsg)
                        uni_showToast(ShowToastOptions(icon = "error", title = "errorCode=" + res.errCode))
                    }
                    , complete = fun(_) {}))
                }
                ))
            }
            val shareSnapShot = fun(){
                uni_hideToast()
                uni_getElementById("viewshot")?.takeSnapshot(TakeSnapshotOptions(success = fun(res) {
                    uni_shareWithSystem(ShareWithSystemOptions(imageUrl = res.tempFilePath, type = "image", success = fun(_) {
                        console.log("Shared----------------------------success")
                    }
                    , fail = fun(res) {
                        console.log("Share failed, res.errCode =" + res.errCode + "---res.errMsg= " + res.errMsg)
                        uni_showToast(ShowToastOptions(icon = "error", title = "errorCode=" + res.errCode))
                    }
                    , complete = fun(_) {}))
                }
                , fail = fun(res) {
                    console.log(res)
                    uni_showToast(ShowToastOptions(icon = "error", title = "截图失败"))
                }
                ))
            }
            return fun(): Any? {
                return _cE("scroll-view", _uM("direction" to "vertical", "style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("id" to "viewshot"), _uA(
                        _cE("button", _uM("class" to "button", "onClick" to fun(){
                            shareText()
                        }
                        ), "分享文本", 8, _uA(
                            "onClick"
                        )),
                        _cE("button", _uM("class" to "button", "onClick" to fun(){
                            shareLink()
                        }
                        ), "分享链接", 8, _uA(
                            "onClick"
                        )),
                        _cE("button", _uM("class" to "button", "onClick" to fun(){
                            sharePrivateImg()
                        }
                        ), "分享单个本地图片", 8, _uA(
                            "onClick"
                        )),
                        _cE("button", _uM("class" to "button", "onClick" to fun(){
                            sharePrivateImgs()
                        }
                        ), "分享多个本地图片", 8, _uA(
                            "onClick"
                        )),
                        _cE("button", _uM("class" to "button", "onClick" to fun(){
                            shareAll()
                        }
                        ), "分享链接、文本、一张图片", 8, _uA(
                            "onClick"
                        )),
                        _cE("button", _uM("class" to "button", "onClick" to fun(){
                            sharePrivateVideo()
                        }
                        ), "分享video文件(单个)", 8, _uA(
                            "onClick"
                        )),
                        _cE("button", _uM("class" to "button", "onClick" to fun(){
                            sharePrivateVideos()
                        }
                        ), "分享video文件(多个)", 8, _uA(
                            "onClick"
                        )),
                        _cE("button", _uM("class" to "button", "onClick" to fun(){
                            sharePrivateAudio()
                        }
                        ), "分享Audio文件(单个)", 8, _uA(
                            "onClick"
                        )),
                        _cE("button", _uM("class" to "button", "onClick" to fun(){
                            sharePrivateAudios()
                        }
                        ), "分享Audio文件(多个)", 8, _uA(
                            "onClick"
                        )),
                        _cE("button", _uM("class" to "button", "onClick" to fun(){
                            sharePrivateFile()
                        }
                        ), "分享文件(单个)", 8, _uA(
                            "onClick"
                        )),
                        _cE("button", _uM("class" to "button", "onClick" to fun(){
                            sharePrivateFiles()
                        }
                        ), "分享文件(多个)", 8, _uA(
                            "onClick"
                        )),
                        _cE("button", _uM("class" to "button", "onClick" to fun(){
                            sharePubImg()
                        }
                        ), "选择图片并分享", 8, _uA(
                            "onClick"
                        )),
                        _cE("button", _uM("class" to "button", "onClick" to fun(){
                            sharePubMedias()
                        }
                        ), "选择video并分享", 8, _uA(
                            "onClick"
                        )),
                        _cE("button", _uM("class" to "button", "onClick" to fun(){
                            shareSnapShot()
                        }
                        ), "指定view截图并分享", 8, _uA(
                            "onClick"
                        )),
                        _cE("button", _uM("class" to "button", "type" to "warn", "onClick" to fun(){
                            sharePrivateErrorImg()
                        }
                        ), "分享单个本地图片(错误路径)", 8, _uA(
                            "onClick"
                        )),
                        _cE("button", _uM("class" to "button", "type" to "warn", "onClick" to fun(){
                            sharePrivateErrorImgs()
                        }
                        ), "分享多个本地图片(含有错误路径)", 8, _uA(
                            "onClick"
                        )),
                        _cE("button", _uM("class" to "button", "type" to "warn", "onClick" to fun(){
                            sharePrivateErrorVideos()
                        }
                        ), "分享Video文件(错误路径)", 8, _uA(
                            "onClick"
                        )),
                        _cE("button", _uM("class" to "button", "type" to "warn", "onClick" to fun(){
                            sharePrivateErrorAudios()
                        }
                        ), "分享Audio文件(错误路径)", 8, _uA(
                            "onClick"
                        )),
                        _cE("button", _uM("class" to "button", "type" to "warn", "onClick" to fun(){
                            sharePrivateErrorFiles()
                        }
                        ), "分享文件(错误路径)", 8, _uA(
                            "onClick"
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
                return _uM("button" to _pS(_uM("marginLeft" to 30, "marginRight" to 30, "marginBottom" to 15)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
