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
import io.dcloud.uniapp.extapi.closeDialogPage as uni_closeDialogPage
import io.dcloud.uniapp.extapi.getSystemInfoSync as uni_getSystemInfoSync
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
import io.dcloud.uniapp.extapi.openDialogPage as uni_openDialogPage
open class GenPagesAPIDialogPageDialogPage : BasePage {
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
    open var data: DataType__106
        get() {
            return unref(this.`$exposed`["data"]) as DataType__106
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var getLifeCycleNum: () -> Number
        get() {
            return unref(this.`$exposed`["getLifeCycleNum"]) as () -> Number
        }
        set(value) {
            setRefValue(this.`$exposed`, "getLifeCycleNum", value)
        }
    open var setLifeCycleNum: (value: Number) -> Unit
        get() {
            return unref(this.`$exposed`["setLifeCycleNum"]) as (value: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setLifeCycleNum", value)
        }
    open var openDialog1: () -> Unit
        get() {
            return unref(this.`$exposed`["openDialog1"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "openDialog1", value)
        }
    open var openDialog11: () -> Unit
        get() {
            return unref(this.`$exposed`["openDialog11"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "openDialog11", value)
        }
    open var openDialog2: () -> Unit
        get() {
            return unref(this.`$exposed`["openDialog2"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "openDialog2", value)
        }
    open var openDialog1WrongPath: () -> Unit
        get() {
            return unref(this.`$exposed`["openDialog1WrongPath"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "openDialog1WrongPath", value)
        }
    open var goNextPageOpenDialog1: () -> Unit
        get() {
            return unref(this.`$exposed`["goNextPageOpenDialog1"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "goNextPageOpenDialog1", value)
        }
    open var closeDialog: () -> Unit
        get() {
            return unref(this.`$exposed`["closeDialog"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "closeDialog", value)
        }
    open var closeSpecifiedDialog: (index: Number) -> Unit
        get() {
            return unref(this.`$exposed`["closeSpecifiedDialog"]) as (index: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "closeSpecifiedDialog", value)
        }
    open var openDialog4: () -> Unit
        get() {
            return unref(this.`$exposed`["openDialog4"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "openDialog4", value)
        }
    open var openDialogWithTriggerParentHide: () -> Unit
        get() {
            return unref(this.`$exposed`["openDialogWithTriggerParentHide"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "openDialogWithTriggerParentHide", value)
        }
    open var openDialogCheckMoreAttribute: () -> Unit
        get() {
            return unref(this.`$exposed`["openDialogCheckMoreAttribute"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "openDialogCheckMoreAttribute", value)
        }
    open var openDialogWithInput: () -> Unit
        get() {
            return unref(this.`$exposed`["openDialogWithInput"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "openDialogWithInput", value)
        }
    open var closeDialogSimple: () -> Unit
        get() {
            return unref(this.`$exposed`["closeDialogSimple"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "closeDialogSimple", value)
        }
    open var jest_getTapPoint: () -> Unit
        get() {
            return unref(this.`$exposed`["jest_getTapPoint"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_getTapPoint", value)
        }
    open var openDialog2Simple: () -> Unit
        get() {
            return unref(this.`$exposed`["openDialog2Simple"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "openDialog2Simple", value)
        }
    open var setPageStyleForTest: (style: UTSJSONObject) -> Unit
        get() {
            return unref(this.`$exposed`["setPageStyleForTest"]) as (style: UTSJSONObject) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setPageStyleForTest", value)
        }
    open var setPageStyleForTest2: (style: UTSJSONObject) -> Unit
        get() {
            return unref(this.`$exposed`["setPageStyleForTest2"]) as (style: UTSJSONObject) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setPageStyleForTest2", value)
        }
    open var openDialog3: () -> Unit
        get() {
            return unref(this.`$exposed`["openDialog3"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "openDialog3", value)
        }
    open var openDialogWithRelativePath: () -> Unit
        get() {
            return unref(this.`$exposed`["openDialogWithRelativePath"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "openDialogWithRelativePath", value)
        }
    open var getDialogPageRoute: () -> String
        get() {
            return unref(this.`$exposed`["getDialogPageRoute"]) as () -> String
        }
        set(value) {
            setRefValue(this.`$exposed`, "getDialogPageRoute", value)
        }
    open var dialogPageCheckGetDialogPages: () -> Boolean
        get() {
            return unref(this.`$exposed`["dialogPageCheckGetDialogPages"]) as () -> Boolean
        }
        set(value) {
            setRefValue(this.`$exposed`, "dialogPageCheckGetDialogPages", value)
        }
    open var dialogPageGetPageStyle: () -> UTSJSONObject
        get() {
            return unref(this.`$exposed`["dialogPageGetPageStyle"]) as () -> UTSJSONObject
        }
        set(value) {
            setRefValue(this.`$exposed`, "dialogPageGetPageStyle", value)
        }
    open var dialogPageSetPageStyle: () -> Unit
        get() {
            return unref(this.`$exposed`["dialogPageSetPageStyle"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "dialogPageSetPageStyle", value)
        }
    open var dialogPageCheckGetElementById: () -> Boolean
        get() {
            return unref(this.`$exposed`["dialogPageCheckGetElementById"]) as () -> Boolean
        }
        set(value) {
            setRefValue(this.`$exposed`, "dialogPageCheckGetElementById", value)
        }
    open var dialogCheckGetAndroidView: () -> Boolean
        get() {
            return unref(this.`$exposed`["dialogCheckGetAndroidView"]) as () -> Boolean
        }
        set(value) {
            setRefValue(this.`$exposed`, "dialogCheckGetAndroidView", value)
        }
    open var dialogCheckGetIOSView: () -> Boolean
        get() {
            return unref(this.`$exposed`["dialogCheckGetIOSView"]) as () -> Boolean
        }
        set(value) {
            setRefValue(this.`$exposed`, "dialogCheckGetIOSView", value)
        }
    open var dialogCheckGetHTMLElement: () -> Boolean
        get() {
            return unref(this.`$exposed`["dialogCheckGetHTMLElement"]) as () -> Boolean
        }
        set(value) {
            setRefValue(this.`$exposed`, "dialogCheckGetHTMLElement", value)
        }
    open var openDialogCheckSetNavigationBarColor: () -> Unit
        get() {
            return unref(this.`$exposed`["openDialogCheckSetNavigationBarColor"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "openDialogCheckSetNavigationBarColor", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIDialogPageDialogPage, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIDialogPageDialogPage
            val _cache = __ins.renderCache
            val data = reactive(DataType__106(pageBody = null, safeAreaInsets = null, width = null, height = null, statusBarHeight = null, jest_click_x = -1, jest_click_y = -1, openAnimationType = "none", openAnimationTypeList = _uA(
                "auto",
                "none",
                "slide-in-right",
                "slide-in-left",
                "slide-in-top",
                "slide-in-bottom",
                "fade-in",
                "zoom-out",
                "zoom-fade-out"
            )))
            onLoad(fun(_options){
                console.log("dialogPage parent onLoad")
            }
            )
            onPageShow(fun(){
                console.log("dialogPage parent onShow")
                uni.UNIHelloUniAppX.setLifeCycleNum(state.lifeCycleNum + 10)
            }
            )
            onReady(fun(){
                console.log("dialogPage parent onReady")
                val currentPage = getCurrentPages()[getCurrentPages().length - 1]
                data.pageBody = currentPage.pageBody
                data.safeAreaInsets = currentPage.safeAreaInsets
                data.width = currentPage.width
                data.height = currentPage.height
                data.statusBarHeight = currentPage.statusBarHeight
            }
            )
            onPageHide(fun(){
                console.log("dialogPage parent onHide")
                uni.UNIHelloUniAppX.setLifeCycleNum(state.lifeCycleNum - 10)
            }
            )
            onUnload(fun(){
                console.log("dialogPage parent onUnload")
            }
            )
            val goNextPage = fun(){
                uni_navigateTo(NavigateToOptions(url = "/pages/API/dialog-page/next-page"))
            }
            val openDialog1 = fun(){
                uni_openDialogPage(OpenDialogPageOptions(url = "/pages/API/dialog-page/dialog-1?name=dialog1", animationType = data.openAnimationType, success = fun(res) {
                    console.log("openDialogPage1 success", res)
                    uni.UNIHelloUniAppX.setLifeCycleNum(state.lifeCycleNum + 1)
                }
                , fail = fun(err) {
                    console.log("openDialogPage1 fail", err)
                    uni.UNIHelloUniAppX.setLifeCycleNum(state.lifeCycleNum - 4)
                }
                , complete = fun(res) {
                    console.log("openDialogPage1 complete", res)
                    uni.UNIHelloUniAppX.setLifeCycleNum(state.lifeCycleNum + 1)
                }
                ))
            }
            val openDialog11 = fun(){
                uni_openDialogPage(OpenDialogPageOptions(url = "/pages/API/dialog-page/dialog-1-1", animationType = data.openAnimationType))
            }
            val openDialog2 = fun(){
                uni_openDialogPage(OpenDialogPageOptions(url = "/pages/API/dialog-page/dialog-2", animationType = data.openAnimationType, disableEscBack = true, success = fun(res) {
                    console.log("openDialog2 success", res)
                    uni.UNIHelloUniAppX.setLifeCycleNum(state.lifeCycleNum + 1)
                }
                , fail = fun(err) {
                    console.log("openDialog2 fail", err)
                    uni.UNIHelloUniAppX.setLifeCycleNum(state.lifeCycleNum - 4)
                }
                , complete = fun(res) {
                    console.log("openDialog2 complete", res)
                    uni.UNIHelloUniAppX.setLifeCycleNum(state.lifeCycleNum + 1)
                }
                ))
            }
            val openDialog1WrongPath = fun(){
                uni_openDialogPage(OpenDialogPageOptions(url = "/pages/API/dialog-page/dialog-11?name=dialog1", success = fun(res) {
                    console.log("openDialogPage1 success", res)
                    uni.UNIHelloUniAppX.setLifeCycleNum(state.lifeCycleNum + 1)
                }
                , fail = fun(err) {
                    console.log("openDialogPage1 fail", err)
                    uni.UNIHelloUniAppX.setLifeCycleNum(state.lifeCycleNum - 4)
                }
                , complete = fun(res) {
                    console.log("openDialogPage1 complete", res)
                    uni.UNIHelloUniAppX.setLifeCycleNum(state.lifeCycleNum + 1)
                }
                ))
            }
            val goNextPageOpenDialog1 = fun(){
                uni_navigateTo(NavigateToOptions(url = "/pages/API/dialog-page/next-page", success = fun(_) {
                    setTimeout(fun(){
                        uni_openDialogPage(OpenDialogPageOptions(url = "/pages/API/dialog-page/dialog-1?name=dialog1", animationType = data.openAnimationType, success = fun(res) {
                            console.log("openDialogPage1 success", res)
                            uni.UNIHelloUniAppX.setLifeCycleNum(state.lifeCycleNum + 1)
                        }
                        , fail = fun(err) {
                            console.log("openDialogPage1 fail", err)
                            uni.UNIHelloUniAppX.setLifeCycleNum(state.lifeCycleNum - 4)
                        }
                        , complete = fun(res) {
                            console.log("openDialogPage1 complete", res)
                            uni.UNIHelloUniAppX.setLifeCycleNum(state.lifeCycleNum + 1)
                        }
                        ))
                    }
                    , 2000)
                }
                ))
            }
            val closeDialog = fun(){
                uni_closeDialogPage(CloseDialogPageOptions(success = fun(res) {
                    console.log("closeDialog success", res)
                    uni.UNIHelloUniAppX.setLifeCycleNum(state.lifeCycleNum + 1)
                }
                , fail = fun(err) {
                    console.log("closeDialog fail", err)
                    uni.UNIHelloUniAppX.setLifeCycleNum(state.lifeCycleNum - 4)
                }
                , complete = fun(res) {
                    console.log("closeDialog complete", res)
                    uni.UNIHelloUniAppX.setLifeCycleNum(state.lifeCycleNum + 1)
                }
                ))
            }
            val closeSpecifiedDialog = fun(index: Number){
                val dialogPages = getCurrentPages()[getCurrentPages().length - 1].getDialogPages()
                uni_closeDialogPage(CloseDialogPageOptions(dialogPage = dialogPages[index], success = fun(res) {
                    console.log("closeSomeOneDialog success", res)
                    uni.UNIHelloUniAppX.setLifeCycleNum(state.lifeCycleNum + 1)
                }
                , fail = fun(err) {
                    console.log("closeSomeOneDialog fail", err)
                    uni.UNIHelloUniAppX.setLifeCycleNum(state.lifeCycleNum - 4)
                }
                , complete = fun(res) {
                    console.log("closeSomeOneDialog complete", res)
                    uni.UNIHelloUniAppX.setLifeCycleNum(state.lifeCycleNum + 1)
                }
                ))
            }
            val openDialog4 = fun(){
                uni_openDialogPage(OpenDialogPageOptions(url = "/pages/API/dialog-page/dialog-4"))
            }
            val openDialogWithTriggerParentHide = fun(){
                uni_openDialogPage(OpenDialogPageOptions(url = "/pages/API/dialog-page/dialog-4?tag=" + Date.now(), triggerParentHide = true, success = fun(res) {
                    console.log("openDialogWithTriggerParentHide success", res)
                    uni.UNIHelloUniAppX.setLifeCycleNum(state.lifeCycleNum + 1)
                }
                , fail = fun(err) {
                    console.log("openDialogWithTriggerParentHide fail", err)
                    uni.UNIHelloUniAppX.setLifeCycleNum(state.lifeCycleNum - 4)
                }
                , complete = fun(res) {
                    console.log("openDialogWithTriggerParentHide complete", res)
                    uni.UNIHelloUniAppX.setLifeCycleNum(state.lifeCycleNum + 1)
                }
                ))
            }
            val openDialogCheckMoreAttribute = fun(){
                uni_openDialogPage(OpenDialogPageOptions(url = "/pages/API/dialog-page/dialog-5"))
            }
            val openDialogCheckSetNavigationBarColor = fun(){
                uni_openDialogPage(OpenDialogPageOptions(url = "/pages/API/dialog-page/dialog-6"))
            }
            val openDialogWithTextarea = fun(){
                uni_openDialogPage(OpenDialogPageOptions(url = "/pages/API/dialog-page/dialog-textarea"))
            }
            val openDialogWithInput = fun(){
                uni_openDialogPage(OpenDialogPageOptions(url = "/pages/API/dialog-page/dialog-input"))
            }
            val setLifeCycleNumFunc = fun(value: Number){
                uni.UNIHelloUniAppX.setLifeCycleNum(value)
            }
            val getLifeCycleNum = fun(): Number {
                return state.lifeCycleNum
            }
            val closeDialogSimple = fun(){
                uni_closeDialogPage(null)
            }
            val jest_getTapPoint = fun(){
                val systemInfo = uni_getSystemInfoSync()
                var ratio: Number = 1
                if (systemInfo.platform == "android") {
                    ratio = systemInfo.devicePixelRatio
                }
                data.jest_click_x = systemInfo.screenWidth / 2 * ratio
                data.jest_click_y = systemInfo.statusBarHeight * ratio + 10
            }
            val openDialog2Simple = fun(){
                uni_openDialogPage(OpenDialogPageOptions(url = "/pages/API/dialog-page/dialog-2"))
            }
            val setPageStyleForTest = fun(style: UTSJSONObject){
                val pages = getCurrentPages()[getCurrentPages().length - 1].getDialogPages()
                if (pages.length > 0) {
                    pages[pages.length - 1].setPageStyle(style)
                }
            }
            val setPageStyleForTest2 = fun(style: UTSJSONObject){
                getCurrentPages()[getCurrentPages().length - 1].setPageStyle(style)
            }
            val openDialog3 = fun(){
                uni_openDialogPage(OpenDialogPageOptions(url = "/pages/API/dialog-page/dialog-3", animationType = data.openAnimationType))
            }
            val handleOpenAnimationType = fun(e: RadioGroupChangeEvent){
                data.openAnimationType = e.detail.value as OpenAnimationType
            }
            val openDialogWithRelativePath = fun(){
                uni_openDialogPage(OpenDialogPageOptions(url = "./dialog-1?name=dialog1", animationType = data.openAnimationType, success = fun(res) {
                    console.log("openDialogPage1 success", res)
                    uni.UNIHelloUniAppX.setLifeCycleNum(state.lifeCycleNum + 1)
                }
                , fail = fun(err) {
                    console.log("openDialogPage1 fail", err)
                    uni.UNIHelloUniAppX.setLifeCycleNum(state.lifeCycleNum - 4)
                }
                , complete = fun(res) {
                    console.log("openDialogPage1 complete", res)
                    uni.UNIHelloUniAppX.setLifeCycleNum(state.lifeCycleNum + 1)
                }
                ))
            }
            val getDialogPage = fun(): UniPage? {
                val dialogPages = getCurrentPages()[getCurrentPages().length - 1].getDialogPages()
                return if (dialogPages.length > 0) {
                    dialogPages[0]
                } else {
                    null
                }
            }
            val getDialogPageRoute = fun(): String {
                val dialogPage = getDialogPage()
                if (dialogPage != null) {
                    return dialogPage.route
                }
                return ""
            }
            val dialogPageCheckGetDialogPages = fun(): Boolean {
                val dialogPage = getDialogPage()!!
                val dialogPages = dialogPage.getDialogPages()
                val res = dialogPages.length == 0
                return res
            }
            val dialogPageGetPageStyle = fun(): UTSJSONObject {
                val dialogPage = getDialogPage()!!
                return dialogPage.getPageStyle()
            }
            val dialogPageSetPageStyle = fun(){
                val dialogPage = getDialogPage()!!
                dialogPage.setPageStyle(_uO("backgroundColorContent" to "red"))
            }
            val dialogPageCheckGetElementById = fun(): Boolean {
                val dialogPage = getDialogPage()!!
                val element = dialogPage.getElementById("dialog1-go-next-page")
                var res = element != null
                return res
            }
            val dialogCheckGetAndroidView = fun(): Boolean {
                val dialogPage = getDialogPage()!!
                val androidView = dialogPage.getAndroidView<android.view.View>()
                val res = androidView != null
                return res
            }
            val dialogCheckGetIOSView = fun(): Boolean {
                val dialogPage = getDialogPage()!!
                val IOSView = dialogPage.getIOSView()
                val res = IOSView != null
                return res
            }
            val dialogCheckGetHTMLElement = fun(): Boolean {
                val dialogPage = getDialogPage()!!
                val HTMLView = dialogPage.getHTMLElement()
                val res = HTMLView != null
                return res
            }
            __expose(_uM("data" to data, "getLifeCycleNum" to getLifeCycleNum, "setLifeCycleNum" to setLifeCycleNumFunc, "openDialog1" to openDialog1, "openDialog11" to openDialog11, "openDialog2" to openDialog2, "openDialog1WrongPath" to openDialog1WrongPath, "goNextPageOpenDialog1" to goNextPageOpenDialog1, "closeDialog" to closeDialog, "closeSpecifiedDialog" to closeSpecifiedDialog, "openDialog4" to openDialog4, "openDialogWithTriggerParentHide" to openDialogWithTriggerParentHide, "openDialogCheckMoreAttribute" to openDialogCheckMoreAttribute, "openDialogWithInput" to openDialogWithInput, "closeDialogSimple" to closeDialogSimple, "jest_getTapPoint" to jest_getTapPoint, "openDialog2Simple" to openDialog2Simple, "setPageStyleForTest" to setPageStyleForTest, "setPageStyleForTest2" to setPageStyleForTest2, "openDialog3" to openDialog3, "openDialogWithRelativePath" to openDialogWithRelativePath, "getDialogPageRoute" to getDialogPageRoute, "dialogPageCheckGetDialogPages" to dialogPageCheckGetDialogPages, "dialogPageGetPageStyle" to dialogPageGetPageStyle, "dialogPageSetPageStyle" to dialogPageSetPageStyle, "dialogPageCheckGetElementById" to dialogPageCheckGetElementById, "dialogCheckGetAndroidView" to dialogCheckGetAndroidView, "dialogCheckGetIOSView" to dialogCheckGetIOSView, "dialogCheckGetHTMLElement" to dialogCheckGetHTMLElement, "openDialogCheckSetNavigationBarColor" to openDialogCheckSetNavigationBarColor))
            return fun(): Any? {
                val _component_page_intro = resolveEasyComponent("page-intro", GenComponentsPageIntroPageIntroClass)
                val _component_radio = resolveComponent("radio")
                val _component_radio_group = resolveComponent("radio-group")
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cV(_component_page_intro, _uM("content" to "本页演示 dialog 弹窗与页面信息：展示 pageBody、safeAreaInsets、窗口尺寸等；通过按钮跳转下一页、打开各 dialog 示例（含错误路径、triggerParentHide、页面样式等）。")),
                    _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                        if (unref(data).pageBody != null) {
                            _cE("view", _uM("key" to 0, "class" to "uni-common-mt flex-row"), _uA(
                                _cE("text", null, "pageBody: {"),
                                _cE("text", null, "top: "),
                                _cE("text", _uM("id" to "page-body-top"), _tD(unref(data).pageBody!!.top), 1),
                                _cE("text", null, ","),
                                _cE("text", null, "right: "),
                                _cE("text", _uM("id" to "page-body-right"), _tD(unref(data).pageBody!!.right), 1),
                                _cE("text", null, ","),
                                _cE("text", null, "bottom: "),
                                _cE("text", _uM("id" to "page-body-bottom"), _tD(unref(data).pageBody!!.bottom), 1),
                                _cE("text", null, ","),
                                _cE("text", null, "left: "),
                                _cE("text", _uM("id" to "page-body-left"), _tD(unref(data).pageBody!!.left), 1),
                                _cE("text", null, ","),
                                _cE("text", null, "width: "),
                                _cE("text", _uM("id" to "page-body-width"), _tD(unref(data).pageBody!!.width), 1),
                                _cE("text", null, ","),
                                _cE("text", null, "height: "),
                                _cE("text", _uM("id" to "page-body-height"), _tD(unref(data).pageBody!!.height), 1),
                                _cE("text", null, "}")
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        if (unref(data).safeAreaInsets != null) {
                            _cE("view", _uM("key" to 1, "class" to "uni-common-mt flex-row"), _uA(
                                _cE("text", null, "safeAreaInsets: {"),
                                _cE("text", null, "top: "),
                                _cE("text", _uM("id" to "page-safe-area-insets-top"), _tD(unref(data).safeAreaInsets!!.top), 1),
                                _cE("text", null, ","),
                                _cE("text", null, "right: "),
                                _cE("text", _uM("id" to "page-safe-area-insets-right"), _tD(unref(data).safeAreaInsets!!.right), 1),
                                _cE("text", null, ","),
                                _cE("text", null, "bottom: "),
                                _cE("text", _uM("id" to "page-safe-area-insets-bottom"), _tD(unref(data).safeAreaInsets!!.bottom), 1),
                                _cE("text", null, ","),
                                _cE("text", null, "left: "),
                                _cE("text", _uM("id" to "page-safe-area-insets-left"), _tD(unref(data).safeAreaInsets!!.left), 1),
                                _cE("text", null, "}")
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        if (unref(data).width != null) {
                            _cE("view", _uM("key" to 2, "class" to "uni-common-mt flex-row"), _uA(
                                _cE("text", null, "width: "),
                                _cE("text", _uM("id" to "page-width"), _tD(unref(data).width!!), 1)
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        if (unref(data).height != null) {
                            _cE("view", _uM("key" to 3, "class" to "uni-common-mt flex-row"), _uA(
                                _cE("text", null, "height: "),
                                _cE("text", _uM("id" to "page-height"), _tD(unref(data).height!!), 1)
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        if (unref(data).statusBarHeight != null) {
                            _cE("view", _uM("key" to 4, "class" to "uni-common-mt flex-row"), _uA(
                                _cE("text", null, "statusBarHeight: "),
                                _cE("text", _uM("id" to "page-statusBarHeight"), _tD(unref(data).statusBarHeight!!), 1)
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        _cE("button", _uM("class" to "uni-common-mt", "id" to "go-next-page", "onClick" to goNextPage), " go next page "),
                        _cE("button", _uM("class" to "uni-common-mt", "id" to "open-dialog1", "onClick" to openDialog1), " open dialog 1 "),
                        _cE("button", _uM("class" to "uni-common-mt", "id" to "open-dialog11", "onClick" to openDialog11), " open dialog 1-1 "),
                        _cE("button", _uM("class" to "uni-common-mt", "id" to "open-dialog1-wrong-path", "onClick" to openDialog1WrongPath), " open dialog page 1 with wrong path "),
                        _cE("button", _uM("class" to "uni-common-mt", "id" to "go-next-page-open-dialog1", "onClick" to goNextPageOpenDialog1), " go next page & open dialog1 "),
                        _cE("button", _uM("class" to "uni-common-mt", "id" to "open-dialog3", "onClick" to openDialog3), " open dialog 3 test page style "),
                        _cE("button", _uM("class" to "uni-common-mt", "id" to "open-dialog4", "onClick" to openDialogWithTriggerParentHide), " openDialog with triggerParentHide "),
                        _cE("button", _uM("class" to "uni-common-mt", "id" to "open-dialog5", "onClick" to openDialogCheckMoreAttribute), " openDialog check more attribute "),
                        _cE("button", _uM("class" to "uni-common-mt", "id" to "open-dialog1-with-relative-path", "onClick" to openDialogWithRelativePath), " openDialog with relative path "),
                        _cE("button", _uM("class" to "uni-common-mt", "id" to "open-dialog6", "onClick" to openDialogCheckSetNavigationBarColor), " openDialog check setNavigationBarColor "),
                        _cE("button", _uM("class" to "uni-common-mt", "onClick" to openDialogWithTextarea), " openDialog with textarea "),
                        _cE("button", _uM("class" to "uni-common-mt", "onClick" to openDialogWithInput), " openDialog with input "),
                        _cE("text", _uM("class" to "uni-common-mt choose-open-animation-type-title"), "choose open dialogPage animationType"),
                        _cV(_component_radio_group, _uM("class" to "choose-open-animation-type-radio-group", "onChange" to handleOpenAnimationType), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(unref(data).openAnimationTypeList, fun(item, __key, __index, _cached): Any {
                                    return _cV(_component_radio, _uM("class" to "ml-10 uni-common-mt", "key" to item, "value" to item, "checked" to (unref(data).openAnimationType == item)), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(item)
                                        )
                                    }
                                    ), "_" to 2), 1032, _uA(
                                        "value",
                                        "checked"
                                    ))
                                }
                                ), 128)
                            )
                        }
                        ), "_" to 1))
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
                return _uM("uni-padding-wrap" to _pS(_uM("paddingBottom" to "var(--uni-safe-area-inset-bottom)")), "ml-10" to _pS(_uM("marginLeft" to 10)), "choose-open-animation-type-title" to _pS(_uM("fontWeight" to "bold")), "choose-open-animation-type-radio-group" to _pS(_uM("flexDirection" to "row", "flexWrap" to "wrap", "marginBottom" to 20)), "flex-row" to _pS(_uM("flexDirection" to "row", "flexWrap" to "wrap")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
