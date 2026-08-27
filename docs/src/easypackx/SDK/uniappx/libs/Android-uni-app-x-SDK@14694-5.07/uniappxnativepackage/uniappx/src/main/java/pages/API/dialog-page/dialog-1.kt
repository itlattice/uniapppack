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
import io.dcloud.uniapp.extapi.navigateBack as uni_navigateBack
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
import io.dcloud.uniapp.extapi.openDialogPage as uni_openDialogPage
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesAPIDialogPageDialog1 : BasePage {
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
    open var openDialog2: () -> Unit
        get() {
            return unref(this.`$exposed`["openDialog2"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "openDialog2", value)
        }
    open var closeDialog: () -> Unit
        get() {
            return unref(this.`$exposed`["closeDialog"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "closeDialog", value)
        }
    open var closeThisDialog: () -> Unit
        get() {
            return unref(this.`$exposed`["closeThisDialog"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "closeThisDialog", value)
        }
    open var checkGetParentPage: () -> Boolean
        get() {
            return unref(this.`$exposed`["checkGetParentPage"]) as () -> Boolean
        }
        set(value) {
            setRefValue(this.`$exposed`, "checkGetParentPage", value)
        }
    open var checkGetElementById: () -> Boolean
        get() {
            return unref(this.`$exposed`["checkGetElementById"]) as () -> Boolean
        }
        set(value) {
            setRefValue(this.`$exposed`, "checkGetElementById", value)
        }
    open var toggleBackgroundColor: () -> Unit
        get() {
            return unref(this.`$exposed`["toggleBackgroundColor"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "toggleBackgroundColor", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIDialogPageDialog1, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIDialogPageDialog1
            val _cache = __ins.renderCache
            val instance = getCurrentInstance()!!.proxy!!
            val currentPage = instance.`$page`
            val title = ref("dialog 1")
            var backgroundColorContent = "transparent"
            fun gen_goNextPage_fn() {
                uni_navigateTo(NavigateToOptions(url = "/pages/API/dialog-page/next-page"))
            }
            val goNextPage = ::gen_goNextPage_fn
            fun gen_openDialog2_fn() {
                uni_openDialogPage(OpenDialogPageOptions(url = "/pages/API/dialog-page/dialog-2", disableEscBack = true, success = fun(res) {
                    console.log("openDialog2 success", res)
                    setLifeCycleNum(state.lifeCycleNum + 1)
                }
                , fail = fun(err) {
                    console.log("openDialog2 fail", err)
                    setLifeCycleNum(state.lifeCycleNum - 4)
                }
                , complete = fun(res) {
                    console.log("openDialog2 complete", res)
                    setLifeCycleNum(state.lifeCycleNum + 1)
                }
                ))
            }
            val openDialog2 = ::gen_openDialog2_fn
            fun gen_closeDialog_fn() {
                uni_closeDialogPage(CloseDialogPageOptions(success = fun(res) {
                    console.log("closeDialog success", res)
                    setLifeCycleNum(state.lifeCycleNum + 1)
                }
                , fail = fun(err) {
                    console.log("closeDialog fail", err)
                    setLifeCycleNum(state.lifeCycleNum - 4)
                }
                , complete = fun(res) {
                    console.log("closeDialog complete", res)
                    setLifeCycleNum(state.lifeCycleNum + 1)
                }
                ))
            }
            val closeDialog = ::gen_closeDialog_fn
            fun gen_closeThisDialog_fn() {
                if (currentPage != null) {
                    uni_closeDialogPage(CloseDialogPageOptions(dialogPage = currentPage, success = fun(res) {
                        console.log("closeThisDialog success", res)
                        setLifeCycleNum(state.lifeCycleNum + 1)
                    }
                    , fail = fun(err) {
                        console.log("closeThisDialog fail", err)
                        setLifeCycleNum(state.lifeCycleNum - 4)
                    }
                    , complete = fun(res) {
                        console.log("closeThisDialog complete", res)
                        setLifeCycleNum(state.lifeCycleNum + 1)
                    }
                    ))
                }
            }
            val closeThisDialog = ::gen_closeThisDialog_fn
            fun gen_checkGetParentPage_fn(): Boolean {
                if (currentPage == null) {
                    return false
                }
                val parentPage = currentPage.getParentPage()
                console.log("checkGetParentPage", parentPage)
                val res = parentPage != null
                uni_showToast(if (res) {
                    ShowToastOptions(title = "check success")
                } else {
                    ShowToastOptions(title = "check fail", icon = "error")
                }
                )
                return res
            }
            val checkGetParentPage = ::gen_checkGetParentPage_fn
            fun gen_checkGetElementById_fn(): Boolean {
                if (currentPage == null) {
                    return false
                }
                val element = currentPage.getElementById("dialog1-go-next-page")
                var res = element != null
                console.log("check getElementById", res)
                uni_showToast(if (res) {
                    ShowToastOptions(title = "check success")
                } else {
                    ShowToastOptions(title = "check fail", icon = "error")
                }
                )
                return res
            }
            val checkGetElementById = ::gen_checkGetElementById_fn
            fun gen_toggleBackgroundColor_fn() {
                backgroundColorContent = if (backgroundColorContent == "transparent") {
                    "rgb(0, 122, 255)"
                } else {
                    "transparent"
                }
                if (currentPage != null) {
                    currentPage.setPageStyle(_uO("backgroundColorContent" to backgroundColorContent))
                }
            }
            val toggleBackgroundColor = ::gen_toggleBackgroundColor_fn
            fun gen_back_fn() {
                uni_navigateBack(null)
            }
            val back = ::gen_back_fn
            onLoad(fun(options: OnLoadOptions){
                console.log("dialog 1 onLoad", options)
                setLifeCycleNum(state.lifeCycleNum + 1)
                if (options["name"] == "dialog1") {
                    setLifeCycleNum(state.lifeCycleNum + 1)
                }
            }
            )
            onPageShow(fun(){
                console.log("dialog 1 onShow")
                setLifeCycleNum(state.lifeCycleNum + 1)
            }
            )
            onReady(fun(){
                console.log("dialog 1 onReady")
                setLifeCycleNum(state.lifeCycleNum + 1)
                val currentPages = getCurrentPages()
                val parentPage = currentPage.getParentPage()!!
                val grandParentPage = parentPage.getParentPage()
                val dialogPages = parentPage.getDialogPages()
                val dialogPage = currentPage
                if (currentPages.length == 1 && grandParentPage == null && dialogPages.indexOf(dialogPage) != -1) {
                    setLifeCycleNum(state.lifeCycleNum + 1)
                }
            }
            )
            onHide(fun(){
                console.log("dialog 1 onHide")
                setLifeCycleNum(state.lifeCycleNum - 1)
            }
            )
            onUnload(fun(){
                console.log("dialog 1 onUnload")
                setLifeCycleNum(state.lifeCycleNum - 5)
            }
            )
            onBackPress(fun(options: OnBackPressOptions): Boolean? {
                console.log("dialogPage1 onBackPress", options)
                setLifeCycleNum(state.lifeCycleNum + 1)
                return true
            }
            )
            __expose(_uM("openDialog2" to openDialog2, "closeDialog" to closeDialog, "closeThisDialog" to closeThisDialog, "checkGetParentPage" to checkGetParentPage, "checkGetElementById" to checkGetElementById, "toggleBackgroundColor" to toggleBackgroundColor))
            return fun(): Any? {
                return _cE("view", _uM("id" to "dialog1", "class" to "dialog-container"), _uA(
                    _cE("view", _uM("class" to "dialog-content"), _uA(
                        _cE("text", null, "title: " + _tD(unref(title)), 1),
                        _cE("text", _uM("class" to "mt-10"), "onBackPress return true"),
                        _cE("button", _uM("class" to "mt-10", "id" to "dialog1-go-next-page", "onClick" to goNextPage), " go next page "),
                        _cE("button", _uM("class" to "mt-10", "id" to "dialog1-open-dialog2", "onClick" to openDialog2), " openDialog2 "),
                        _cE("button", _uM("class" to "mt-10", "id" to "dialog1-close-dialog", "onClick" to closeDialog), " closeDialog "),
                        _cE("button", _uM("class" to "mt-10", "id" to "dialog1-close-this-dialog", "onClick" to closeThisDialog), " closeThisDialog "),
                        _cE("button", _uM("class" to "mt-10", "onClick" to checkGetParentPage), " check getParentPage "),
                        _cE("button", _uM("class" to "mt-10", "onClick" to checkGetElementById), " check getElementById "),
                        _cE("button", _uM("class" to "mt-10", "onClick" to toggleBackgroundColor), " toggleBackgroundColor "),
                        _cE("button", _uM("class" to "mt-10", "id" to "dialog1-back", "onClick" to back), "back")
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
                return _uM("dialog-container" to _pS(_uM("width" to "100%", "height" to "100%", "backgroundColor" to "rgba(0,0,0,0.3)", "display" to "flex", "justifyContent" to "center", "alignItems" to "center")), "dialog-content" to _pS(_uM("width" to "80%", "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "backgroundColor" to "#ffffff", "borderTopLeftRadius" to 6, "borderTopRightRadius" to 6, "borderBottomRightRadius" to 6, "borderBottomLeftRadius" to 6)), "mt-10" to _pS(_uM("marginTop" to 10)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
