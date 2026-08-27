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
import uts.sdk.modules.utsProgressNotification.CreateNotificationProgressOptions
import uts.sdk.modules.utsProgressNotification.FinishNotificationProgressOptions
import io.dcloud.uniapp.extapi.closeDialogPage as uni_closeDialogPage
import uts.sdk.modules.utsProgressNotification.createNotificationProgress
import uts.sdk.modules.utsProgressNotification.cancelNotificationProgress
import uts.sdk.modules.utsProgressNotification.finishNotificationProgress
import io.dcloud.uniapp.extapi.downloadFile as uni_downloadFile
import io.dcloud.uniapp.extapi.getStorageSync as uni_getStorageSync
import io.dcloud.uniapp.extapi.installApk as uni_installApk
import io.dcloud.uniapp.extapi.navigateBack as uni_navigateBack
import uts.sdk.modules.utsOpenSchema.openSchema as utsOpenSchema
import uts.sdk.modules.utsOpenSchema.openSchema
import io.dcloud.uniapp.extapi.showModal as uni_showModal
open class GenUniModulesUniUpgradeCenterAppPagesUniAppXUpgradePopup : BasePage {
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
        var setup: (__props: GenUniModulesUniUpgradeCenterAppPagesUniAppXUpgradePopup) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesUniUpgradeCenterAppPagesUniAppXUpgradePopup
            val _cache = __ins.renderCache
            val requiredKey = _uA(
                "version",
                "url",
                "type"
            )
            var downloadTask: DownloadTask? = null
            var openSchemePromise: UTSPromise<Boolean>? = null
            val openSchema = fun(url: String): UTSPromise<Boolean> {
                return UTSPromise<Boolean>(fun(resolve, reject){
                    try {
                        utsOpenSchema(url)
                        resolve(true)
                    }
                     catch (e: Throwable) {
                        reject(false)
                    }
                }
                )
            }
            val installForBeforeFilePath = ref<String>("")
            val installed = ref<Boolean>(false)
            val installing = ref<Boolean>(false)
            val downloadSuccess = ref<Boolean>(false)
            val downloading = ref<Boolean>(false)
            val downLoadPercent = ref<Number>(0)
            val downloadedSize = ref<Number>(0)
            val packageFileSize = ref<Number>(0)
            val tempFilePath = ref<String>("")
            val title = ref<String>("更新日志")
            val contents = ref<String>("")
            val version = ref<String>("")
            val is_mandatory = ref<Boolean>(false)
            val url = ref<String>("")
            val platform = ref(_uA<String>())
            val store_list = ref<UTSArray<StoreListItem>?>(null)
            val subTitle = ref<String>("发现新版本")
            val downLoadBtnTextiOS = ref<String>("立即跳转更新")
            val downLoadBtnText = ref<String>("立即下载更新")
            val downLoadingText = ref<String>("安装包下载中，请稍后")
            val isiOS = computed(fun(): Boolean {
                return platform.value.includes(platform_iOS)
            }
            )
            val isHarmony = computed(fun(): Boolean {
                return platform.value.includes(platform_Harmony)
            }
            )
            val isAndroid = computed(fun(): Boolean {
                return platform.value.includes(platform_Android)
            }
            )
            val needNotificationProgress = computed(fun(): Boolean {
                return isAndroid.value && !is_mandatory.value
            }
            )
            fun gen_getCurrentDialogPage_fn(): UniPage? {
                val pages = getCurrentPages()
                if (pages.length > 0) {
                    val dialogPages = pages[pages.length - 1].getDialogPages()
                    if (dialogPages.length > 0) {
                        return dialogPages[dialogPages.length - 1]
                    }
                }
                return null
            }
            val getCurrentDialogPage = ::gen_getCurrentDialogPage_fn
            fun gen_closePopup_fn() {
                downloadSuccess.value = false
                downloading.value = false
                downLoadPercent.value = 0
                downloadedSize.value = 0
                packageFileSize.value = 0
                tempFilePath.value = ""
                installing.value = false
                installed.value = false
                uni_closeDialogPage(CloseDialogPageOptions(dialogPage = getCurrentDialogPage(), fail = fun(e) {
                    console.log("e: ", e)
                }
                ))
            }
            val closePopup = ::gen_closePopup_fn
            fun gen_askAbortDownload_fn() {
                uni_showModal(ShowModalOptions(title = "是否取消下载？", cancelText = "否", confirmText = "是", success = fun(res){
                    if (res.confirm) {
                        if (downloadTask != null) {
                            downloadTask!!.abort()
                        }
                        if (needNotificationProgress.value) {
                            cancelNotificationProgress()
                        }
                        closePopup()
                    }
                }
                ))
            }
            val askAbortDownload = ::gen_askAbortDownload_fn
            fun gen_closeUpdate_fn() {
                if (downloading.value && !needNotificationProgress.value) {
                    askAbortDownload()
                    return
                }
                closePopup()
            }
            val closeUpdate = ::gen_closeUpdate_fn
            fun gen_jumpToAppStore_fn() {
                openSchema(url.value)
            }
            val jumpToAppStore = ::gen_jumpToAppStore_fn
            fun gen_show_fn(localPackageInfo: UniUpgradeCenterResult?) {
                if (localPackageInfo == null) {
                    return
                }
                for(key in resolveUTSKeyIterator(localPackageInfo)){
                    if (requiredKey.indexOf(key) != -1 && localPackageInfo[key] == null) {
                        console.error("参数 " + key + " 必填，请检查后重试")
                        closePopup()
                        return
                    }
                }
                title.value = localPackageInfo.title
                url.value = localPackageInfo.url
                contents.value = localPackageInfo.contents
                is_mandatory.value = localPackageInfo.is_mandatory
                platform.value = localPackageInfo.platform
                version.value = localPackageInfo.version
                store_list.value = localPackageInfo.store_list
            }
            val show = ::gen_show_fn
            fun gen_checkStoreScheme_fn(): UTSPromise<Boolean>? {
                if (store_list.value != null) {
                    val storeList: UTSArray<StoreListItem> = store_list.value!!.filter(fun(item: StoreListItem): Boolean {
                        return item.enable
                    }
                    )
                    if (storeList.length > 0) {
                        if (openSchemePromise == null) {
                            openSchemePromise = UTSPromise.reject() as UTSPromise<Boolean>
                        }
                        storeList.sort(fun(cur: StoreListItem, next: StoreListItem): Number {
                            return next.priority - cur.priority
                        }
                        ).map(fun(item: StoreListItem): String {
                            return item.scheme
                        }
                        ).reduce(fun(promise: UTSPromise<Boolean>, cur: String): UTSPromise<Boolean> {
                            openSchemePromise = promise.`catch`<Boolean>(fun(): UTSPromise<Boolean> {
                                return openSchema(cur)
                            }
                            )
                            return openSchemePromise!!
                        }
                        , openSchemePromise!!)
                        return openSchemePromise!!
                    }
                }
                return null
            }
            val checkStoreScheme = ::gen_checkStoreScheme_fn
            fun gen_installPackage_fn() {
                installing.value = true
                uni_installApk(InstallApkOptions(filePath = tempFilePath.value, success = fun(_){
                    installing.value = false
                    installed.value = true
                }
                , fail = fun(err){
                    console.error("installApk fail", err)
                    installing.value = false
                    installed.value = false
                    uni_showModal(ShowModalOptions(title = "更新失败，请重新下载", content = "uni.installApk 错误码 " + err.errCode, showCancel = false))
                }
                ))
                if (!is_mandatory.value) {
                    uni_navigateBack(null)
                }
            }
            val installPackage = ::gen_installPackage_fn
            fun gen_downloadFail_fn() {
                val errMsg = "下载失败，请点击重试"
                downloadSuccess.value = false
                downloading.value = false
                downLoadPercent.value = 0
                downloadedSize.value = 0
                packageFileSize.value = 0
                downLoadBtnText.value = errMsg
                downloadTask = null
                if (needNotificationProgress.value) {
                    finishNotificationProgress(FinishNotificationProgressOptions(title = "升级包下载失败", content = "请重新检查更新", onClick = fun() {}))
                }
            }
            val downloadFail = ::gen_downloadFail_fn
            fun gen_downLoadComplete_fn() {
                downloadSuccess.value = true
                downloading.value = false
                downLoadPercent.value = 0
                downloadedSize.value = 0
                packageFileSize.value = 0
                downloadTask = null
                if (needNotificationProgress.value) {
                    finishNotificationProgress(FinishNotificationProgressOptions(title = "安装升级包", content = "下载完成", onClick = fun() {}))
                    installPackage()
                    return
                }
                if (is_mandatory.value) {
                    installPackage()
                }
            }
            val downLoadComplete = ::gen_downLoadComplete_fn
            fun gen_downloadPackage_fn() {
                downloadTask = uni_downloadFile(DownloadFileOptions(url = url.value, success = fun(res){
                    if (res.statusCode == 200) {
                        tempFilePath.value = res.tempFilePath
                        downLoadComplete()
                    } else {
                        console.log("downloadFile err: ", res)
                        downloadFail()
                    }
                }
                , fail = fun(err){
                    console.log("downloadFile err: ", err)
                    downloadFail()
                }
                ))
                if (downloadTask != null) {
                    downloading.value = true
                    if (needNotificationProgress.value) {
                        closePopup()
                    }
                    downloadTask!!.onProgressUpdate(fun(res){
                        downLoadPercent.value = parseFloat(res.progress.toFixed(0))
                        downloadedSize.value = parseFloat((res.totalBytesWritten / Math.pow(1024, 2)).toFixed(2))
                        packageFileSize.value = parseFloat((res.totalBytesExpectedToWrite / Math.pow(1024, 2)).toFixed(2))
                        if (needNotificationProgress.value) {
                            createNotificationProgress(CreateNotificationProgressOptions(title = "升级中心正在下载安装包……", content = "" + downLoadPercent.value + "%", progress = downLoadPercent.value, onClick = fun(){
                                if (!downloadSuccess.value) {
                                    askAbortDownload()
                                }
                            }
                            ))
                        }
                    }
                    )
                }
            }
            val downloadPackage = ::gen_downloadPackage_fn
            fun gen_updateApp_fn() {
                val checkStoreSchemeResult = checkStoreScheme()
                if (checkStoreSchemeResult != null) {
                    checkStoreSchemeResult.then(fun(_){}).`catch`(fun(){
                        downloadPackage()
                    }).`finally`(fun(){
                        openSchemePromise = null
                    })
                } else {
                    downloadPackage()
                }
            }
            val updateApp = ::gen_updateApp_fn
            onUnload(fun(){
                if (needNotificationProgress.value) {
                    cancelNotificationProgress()
                }
            }
            )
            onLoad(fun(onLoadOptions: OnLoadOptions){
                val local_storage_key: String? = onLoadOptions["local_storage_key"]
                if (local_storage_key == null) {
                    console.error("local_storage_key为空，请检查后重试")
                    closePopup()
                    return
                }
                val localPackageInfo = uni_getStorageSync(local_storage_key)
                if (localPackageInfo == null) {
                    console.error("安装包信息为空，请检查后重试")
                    closePopup()
                    return
                }
                show(JSON.parse<UniUpgradeCenterResult>(JSON.stringify(localPackageInfo)) as UniUpgradeCenterResult)
            }
            )
            onBackPress(fun(options: OnBackPressOptions): Boolean? {
                if (is_mandatory.value) {
                    return true
                }
                if (!needNotificationProgress.value) {
                    if (downloadTask != null) {
                        downloadTask!!.abort()
                    }
                }
                return false
            }
            )
            return fun(): Any? {
                val _component_progress = resolveComponent("progress")
                return _cE("view", _uM("class" to "mask flex-center"), _uA(
                    _cE("view", _uM("class" to "content"), _uA(
                        _cE("view", _uM("class" to "content-top"), _uA(
                            _cE("text", _uM("class" to "content-top-text"), _tD(unref(title)), 1),
                            _cE("image", _uM("class" to "content-top-image", "mode" to "widthFix", "src" to "/uni_modules/uni-upgrade-center-app/static/app/bg_top.png"))
                        )),
                        _cE("view", _uM("class" to "content-space")),
                        _cE("view", _uM("class" to "content-body"), _uA(
                            _cE("view", _uM("class" to "content-body-title"), _uA(
                                _cE("text", _uM("class" to "text title content-body-title_title"), _tD(unref(subTitle)), 1),
                                _cE("text", _uM("class" to "text version content-body-title_version"), "v" + _tD(unref(version)), 1)
                            )),
                            _cE("view", _uM("class" to "body"), _uA(
                                _cE("scroll-view", _uM("class" to "box-des-scroll"), _uA(
                                    _cE("text", _uM("class" to "text box-des"), _tD(unref(contents)), 1)
                                ))
                            )),
                            _cE("view", _uM("class" to "footer flex-center"), _uA(
                                if (isTrue(unref(isiOS) || unref(isHarmony))) {
                                    _cE("button", _uM("key" to 0, "class" to "content-button", "style" to _nS(_uM("border" to "none", "color" to "#fff")), "type" to "primary", "plain" to "", "onClick" to jumpToAppStore), _tD(unref(downLoadBtnTextiOS)), 5)
                                } else {
                                    _cE(Fragment, _uM("key" to 1), _uA(
                                        if (isTrue(!unref(downloadSuccess))) {
                                            _cE(Fragment, _uM("key" to 0), _uA(
                                                if (isTrue(unref(downloading))) {
                                                    _cE("view", _uM("key" to 0, "class" to "progress-box flex-column"), _uA(
                                                        _cV(_component_progress, _uM("class" to "progress", "percent" to unref(downLoadPercent), "activeColor" to "#3DA7FF", "show-info" to true, "stroke-width" to 10), null, 8, _uA(
                                                            "percent"
                                                        )),
                                                        _cE("view", _uM("style" to _nS(_uM("width" to "100%", "display" to "flex", "justify-content" to "space-around", "flex-direction" to "row"))), _uA(
                                                            _cE("text", _uM("class" to "text", "style" to _nS(_uM("font-size" to "14px"))), _tD(unref(downLoadingText)), 5),
                                                            _cE("text", _uM("class" to "text", "style" to _nS(_uM("font-size" to "14px"))), "(" + _tD(unref(downloadedSize)) + "/" + _tD(unref(packageFileSize)) + "M)", 5)
                                                        ), 4)
                                                    ))
                                                } else {
                                                    _cE("button", _uM("key" to 1, "class" to "content-button", "onClick" to updateApp), _tD(unref(downLoadBtnText)), 1)
                                                }
                                            ), 64)
                                        } else {
                                            if (isTrue(unref(downloadSuccess) && !unref(installed))) {
                                                _cE("button", _uM("key" to 1, "class" to "content-button", "loading" to unref(installing), "disabled" to unref(installing), "onClick" to installPackage), _tD(if (unref(installing)) {
                                                    "正在安装……"
                                                } else {
                                                    "下载完成，立即安装"
                                                }), 9, _uA(
                                                    "loading",
                                                    "disabled"
                                                ))
                                            } else {
                                                if (isTrue(unref(installed))) {
                                                    _cE("button", _uM("key" to 2, "class" to "content-button", "onClick" to installPackage), " 安装未完成，点击安装 ")
                                                } else {
                                                    _cC("v-if", true)
                                                }
                                            }
                                        }
                                    ), 64)
                                }
                            ))
                        )),
                        _cE("view", _uM("class" to "content-bottom"), _uA(
                            if (isTrue(!unref(is_mandatory))) {
                                _cE("image", _uM("key" to 0, "class" to "close-img", "mode" to "widthFix", "src" to "/uni_modules/uni-upgrade-center-app/static/app/app_update_close.png", "onClick" to closeUpdate))
                            } else {
                                _cC("v-if", true)
                            }
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
                return _uM("flex-center" to _pS(_uM("justifyContent" to "center", "alignItems" to "center")), "mask" to _pS(_uM("position" to "fixed", "left" to 0, "top" to 0, "right" to 0, "bottom" to 0, "backgroundColor" to "rgba(0,0,0,0.65)")), "content" to _pS(_uM("position" to "relative", "top" to 0, "width" to "600rpx", "backgroundColor" to "rgba(0,0,0,0)")), "text" to _pS(_uM("fontFamily" to "Source Han Sans CN")), "content-top" to _pS(_uM("width" to "100%", "borderBottomColor" to "#ffffff", "borderBottomWidth" to 15, "borderBottomStyle" to "solid")), "content-space" to _pS(_uM("width" to "100%", "height" to 120, "backgroundColor" to "#ffffff", "position" to "absolute", "top" to "30%", "zIndex" to -1)), "content-top-image" to _pS(_uM("width" to "100%", "position" to "relative", "bottom" to "-10%")), "content-top-text" to _pS(_uM("fontSize" to 22, "fontWeight" to "bold", "color" to "#F8F8FA", "position" to "absolute", "width" to "65%", "top" to "50%", "left" to 25, "zIndex" to 1)), "content-body" to _pS(_uM("boxSizing" to "border-box", "paddingTop" to 0, "paddingRight" to 25, "paddingBottom" to 0, "paddingLeft" to 25, "width" to "100%", "backgroundColor" to "#ffffff", "borderBottomLeftRadius" to 15, "borderBottomRightRadius" to 15)), "content-body-title" to _pS(_uM("flexDirection" to "row", "alignItems" to "center")), "content-body-title_version" to _pS(_uM("paddingLeft" to 4, "color" to "#ffffff", "fontSize" to 10, "marginLeft" to 5, "paddingTop" to 2, "paddingRight" to 4, "paddingBottom" to 2, "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "borderBottomRightRadius" to 10, "borderBottomLeftRadius" to 10, "backgroundImage" to "none", "backgroundColor" to "#50aefd")), "title" to _pS(_uM("fontSize" to 16, "fontWeight" to "bold", "color" to "#3DA7FF", "lineHeight" to "38px")), "footer" to _pS(_uM("height" to 75, "display" to "flex", "alignItems" to "center", "justifyContent" to "space-around")), "box-des-scroll" to _pS(_uM("boxSizing" to "border-box", "paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 15, "height" to 100)), "box-des" to _pS(_uM("fontSize" to 13, "color" to "#000000", "lineHeight" to "25px")), "progress-box" to _pS(_uM("width" to "100%")), "progress" to _pS(_uM("width" to "90%", "height" to 20)), "content-bottom" to _pS(_uM("height" to 75)), "close-img" to _pS(_uM("width" to 35, "height" to 35, "zIndex" to 1000, "position" to "relative", "bottom" to "-30%", "left" to "50%", "marginLeft" to -17)), "content-button" to _pS(_uM("width" to "100%", "height" to 40, "lineHeight" to "40px", "fontSize" to 15, "fontWeight" to "400", "borderTopLeftRadius" to 20, "borderTopRightRadius" to 20, "borderBottomRightRadius" to 20, "borderBottomLeftRadius" to 20, "borderTopWidth" to "medium", "borderRightWidth" to "medium", "borderBottomWidth" to "medium", "borderLeftWidth" to "medium", "borderTopStyle" to "none", "borderRightStyle" to "none", "borderBottomStyle" to "none", "borderLeftStyle" to "none", "borderTopColor" to "#000000", "borderRightColor" to "#000000", "borderBottomColor" to "#000000", "borderLeftColor" to "#000000", "color" to "#ffffff", "textAlign" to "center", "backgroundColor" to "#1785ff")), "flex-column" to _pS(_uM("display" to "flex", "flexDirection" to "column", "alignItems" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
