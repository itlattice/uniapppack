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
import io.dcloud.uniapp.extapi.`$off` as uni__off
import io.dcloud.uniapp.extapi.`$on` as uni__on
import io.dcloud.uniapp.extapi.`$once` as uni__once
import uts.sdk.modules.iboxsScancode.CodeImage
import uts.sdk.modules.iboxsScancode.scanSimpleCode
import uts.sdk.modules.iboxsScancode.SimpleCodeConfig
import uts.sdk.modules.iboxsScancode.SuccessCallback
import uts.sdk.modules.iboxsScancode.CommonResultCallback
import uts.sdk.modules.iboxsScancode.QRCodeType
import uts.sdk.modules.iboxsScancode.deleteFile
import uts.sdk.modules.iboxsChoosemedia.chooseImage
import uts.sdk.modules.iboxsChoosemedia.chooseOptions
import uts.sdk.modules.iboxsChoosemedia.previewImage
import uts.sdk.modules.iboxsChoosemedia.previewMedia
import uts.sdk.modules.iboxsChoosemedia.previewOptions
import uts.sdk.modules.iboxsQcloudCos.init
import uts.sdk.modules.iboxsQcloudCos.cosUploadFile
open class GenComponentsXRemarkbox : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var i18n: Tmui4xI18nTml by `$data`
    open var submit: () -> Unit
        get() {
            return unref(this.`$exposed`["submit"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "submit", value)
        }
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXRemarkbox, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXRemarkbox
            val _cache = __ins.renderCache
            val content = ref("")
            val visible = ref(false)
            val filesList = ref(_uA<UTSJSONObject>())
            val menus = ref(_uA<bottomMenu>(bottomMenu(name = "相册选择", key = "image"), bottomMenu(name = "拍摄视频", key = "video"), bottomMenu(name = "选择文档", key = "doc")))
            val clearEvent = ref(0)
            onBeforeMount(fun(){
                var eventID = uni__once("setremarkbox", fun(res: UTSJSONObject){
                    filesList.value = res["thumb"] as UTSArray<UTSJSONObject>
                    content.value = res["remark"] as String
                }
                )
                setTimeout(fun(){
                    uni__off("setremarkbox", eventID)
                }
                , 5000)
                clearEvent.value = uni__on("clearremarkbox", fun(){
                    filesList.value = _uA<UTSJSONObject>()
                    content.value = ""
                }
                )
            }
            )
            onDeactivated(fun(){
                uni__off("clearremarkbox", clearEvent.value)
            }
            )
            onBeforeUnmount(fun(){
                uni__off("clearremarkbox", clearEvent.value)
            }
            )
            val showUploadProgress = fun(item: UTSJSONObject): Boolean {
                if (item["current"] == null) {
                    return false
                }
                return (item["current"] as Number) < 100
            }
            val addFile = fun(){
                visible.value = true
            }
            val closePopup = fun(){
                visible.value = false
            }
            val submit = fun(){
                if (filesList.value.length > 0) {
                    for(item in resolveUTSValueIterator(filesList.value)){
                        if (item["complete"] == false) {
                            common.toast("有文件尚未上传完成，请等待上传")
                            uni__emit("xremarkbox", _uO())
                            return
                        }
                    }
                }
                var data: UTSJSONObject = _uO("remark" to content.value, "file" to filesList.value)
                uni__emit("xremarkbox", data)
            }
            val cosInit = fun(files: UTSArray<UTSJSONObject>): UTSPromise<Boolean> {
                return wrapUTSPromise(suspend w1@{
                        var list = _uA<UTSJSONObject>()
                        for(item in resolveUTSValueIterator(files)){
                            console.log("加入项", item)
                            var fi = item["uri"] as String
                            fi = fi.replace("file://", "fccc//")
                            var thu = item["thumb"] as String
                            thu = thu.replace("file://", "fccc//")
                            list.push(_uO("file" to fi, "ext" to item["ext"], "type" to item["type"], "thumb" to thu))
                        }
                        var res = await(request.callapi("data/cosinit", _uO("files" to list, "method" to "attachment", "type" to "private")))
                        if (res.code < 0) {
                            common.toast(res.msg)
                            return@w1 false
                        }
                        var uploadData = res.data as UTSJSONObject
                        var config = uploadData["config"] as UTSJSONObject
                        var uploadList = uploadData["uploadKey"] as UTSArray<UTSJSONObject>
                        filesList.value = uploadList
                        var tmpSecretId = config["tmpSecretId"] as String
                        var tmpSecretKey = config["tmpSecretKey"] as String
                        var token = config["sessionToken"] as String
                        var region = config["region"] as String
                        var startTime = config["startTime"] as Number
                        var expiredTime = config["expiredTime"] as Number
                        var host = config["host"] as String
                        init(tmpSecretId, tmpSecretKey, token, host, region, startTime.toLong(), expiredTime.toLong(), true)
                        run {
                            var j: Number = 0
                            while(j < filesList.value.length){
                                filesList.value[j]["current"] = 0
                                filesList.value[j]["complete"] = false
                                var f = filesList.value[j] as UTSJSONObject
                                var uf = f["file"] as String
                                var key = f["key"] as String
                                var bucket = config["bucket"] as String
                                var ind = j
                                cosUploadFile(bucket, key, uf, fun(num: Float){
                                    console.log("进度", num)
                                    filesList.value[ind]["current"] = num
                                }
                                , fun(res: String?){
                                    console.log("上传成功", res)
                                    filesList.value[ind]["complete"] = true
                                }
                                , fun(res: String?){
                                    console.log("上传失败", res)
                                }
                                )
                                j++
                            }
                        }
                        return@w1 true
                })
            }
            val chooseImage = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        var imageFile = await(common.chooseImage("all", 9, 2))
                        cosInit(imageFile)
                        closePopup()
                })
            }
            val chooseDoc = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        var imageFile = await(common.chooseFile())
                        cosInit(imageFile)
                        closePopup()
                })
            }
            val chooseVideo = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        var imageFile = await(common.cameraVideo(60))
                        cosInit(imageFile)
                        closePopup()
                })
            }
            val deleteFile = fun(index: Number){
                filesList.value.splice(index, 1)
            }
            val menuClick = fun(key: String){
                console.log("key", key)
                when (key) {
                    "image" -> 
                        chooseImage()
                    "doc" -> 
                        chooseDoc()
                    "video" -> 
                        chooseVideo()
                }
            }
            __expose(_uM("submit" to submit))
            return fun(): Any? {
                val _component_x_button = resolveEasyComponent("x-button", GenComponentsXButtonClass)
                val _component_x_process = resolveEasyComponent("x-process", GenComponentsXProcessClass)
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_x_buttommenu = resolveEasyComponent("x-buttommenu", GenComponentsXButtommenuClass)
                return _cE("view", null, _uA(
                    _cE("view", _uM("class" to "remarkbox background-white"), _uA(
                        _cE("view", _uM("class" to "remarktext display-flex"), _uA(
                            _cE("text", _uM("class" to "text"), "备注"),
                            _cE("textarea", _uM("class" to "textarea", "modelValue" to unref(content), "onInput" to fun(`$event`: UniInputEvent){
                                trySetRefValue(content, `$event`.detail.value)
                            }
                            ), null, 40, _uA(
                                "modelValue"
                            ))
                        )),
                        _cE("view", _uM("class" to "space-between fujian"), _uA(
                            _cE("text", _uM("class" to "ftitle"), "附件"),
                            _cV(_component_x_button, _uM("onBtnClick" to addFile, "class" to "casherbtn addfile background-white color-main"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    "添加附件"
                                )
                            }
                            ), "_" to 1))
                        )),
                        _cE("view", _uM("class" to "list-items imglist display-flex"), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(unref(filesList), fun(item, index, __index, _cached): Any {
                                return _cE("view", _uM("class" to "litem imtitem", "key" to index, "onClick" to fun(){
                                    deleteFile(index)
                                }
                                ), _uA(
                                    _cE("image", _uM("class" to "image", "src" to item["thumb"]), null, 8, _uA(
                                        "src"
                                    )),
                                    if (isTrue(showUploadProgress(item))) {
                                        _cE("view", _uM("key" to 0, "class" to "jindutiao"), _uA(
                                            _cV(_component_x_process, _uM("current" to item["current"]), null, 8, _uA(
                                                "current"
                                            ))
                                        ))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                    ,
                                    _cE("view", _uM("class" to "deletebtnback")),
                                    _cV(_component_x_iconfont, _uM("name" to "chachajiaobiao", "class" to "deletebtn", "size" to "35", "color" to "red"))
                                ), 8, _uA(
                                    "onClick"
                                ))
                            }
                            ), 128)
                        ))
                    )),
                    _cV(_component_x_buttommenu, _uM("strokeColor" to "#333", "trailColor" to "#f5f5f5", "visible" to unref(visible), "onClosePopup" to closePopup, "menu" to unref(menus), "onMenuClick" to menuClick), null, 8, _uA(
                        "visible",
                        "menu"
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
                return _uM("remarkbox" to _pS(_uM("width" to "750rpx", "borderTopWidth" to 1, "borderTopStyle" to "solid", "borderTopColor" to "#e8e8e8", "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#e8e8e8", "marginTop" to 7, "paddingLeft" to "15rpx", "paddingRight" to "15rpx", "paddingTop" to 4, "paddingBottom" to "15rpx")), "text" to _uM(".remarkbox .remarktext " to _uM("fontSize" to 12, "color" to "#ABABAB", "paddingTop" to 5)), "textarea" to _uM(".remarkbox .remarktext " to _uM("fontSize" to 14, "height" to 70, "marginLeft" to "20rpx", "paddingTop" to 3)), "fujian" to _uM(".remarkbox " to _uM("height" to 50, "borderTopWidth" to 1, "borderTopStyle" to "solid", "borderTopColor" to "#f5f5f5", "paddingTop" to 12)), "ftitle" to _uM(".remarkbox .fujian " to _uM("fontSize" to 12, "color" to "#ABABAB")), "addfile" to _uM(".remarkbox .fujian " to _uM("width" to 88, "height" to 21, "lineHeight" to "19px", "borderTopLeftRadius" to 3, "borderTopRightRadius" to 3, "borderBottomRightRadius" to 3, "borderBottomLeftRadius" to 3, "fontSize" to 12, "paddingTop" to 3, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#1776FC", "borderRightColor" to "#1776FC", "borderBottomColor" to "#1776FC", "borderLeftColor" to "#1776FC")), "imglist" to _uM(".remarkbox " to _uM("width" to "710rpx", "marginLeft" to "17rpx")), "imtitem" to _uM(".remarkbox .imglist " to _uM("width" to "160rpx", "marginRight" to "17rpx", "position" to "relative")), "image" to _uM(".remarkbox .imglist .imtitem " to _uM("width" to "160rpx", "height" to "160rpx", "borderTopLeftRadius" to 6, "borderTopRightRadius" to 6, "borderBottomRightRadius" to 6, "borderBottomLeftRadius" to 6)), "jindutiao" to _uM(".remarkbox .imglist .imtitem " to _uM("position" to "absolute", "left" to "0rpx", "top" to "0rpx", "width" to "160rpx", "height" to "160rpx", "backgroundColor" to "#00000090", "paddingLeft" to "30rpx", "paddingTop" to "70rpx")), "current" to _uM(".remarkbox .imglist .imtitem .jindutiao " to _uM("fontSize" to 12)), "deletebtnback" to _uM(".remarkbox .imglist .imtitem " to _uM("position" to "absolute", "right" to 0, "top" to 0, "height" to "30rpx", "width" to "35rpx", "backgroundImage" to "none", "backgroundColor" to "#FFFFFF")), "deletebtn" to _uM(".remarkbox .imglist .imtitem " to _uM("position" to "absolute", "right" to 0, "top" to "0rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
