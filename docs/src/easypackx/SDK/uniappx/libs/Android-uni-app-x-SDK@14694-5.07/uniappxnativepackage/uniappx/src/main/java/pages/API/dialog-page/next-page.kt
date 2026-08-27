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
import io.dcloud.uniapp.extapi.openDialogPage as uni_openDialogPage
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesAPIDialogPageNextPage : BasePage {
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
    open var getLifeCycleNum: () -> Number
        get() {
            return unref(this.`$exposed`["getLifeCycleNum"]) as () -> Number
        }
        set(value) {
            setRefValue(this.`$exposed`, "getLifeCycleNum", value)
        }
    open var openDialog1: () -> Unit
        get() {
            return unref(this.`$exposed`["openDialog1"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "openDialog1", value)
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
    open var openDialogPage1ToHomePage: () -> Unit
        get() {
            return unref(this.`$exposed`["openDialogPage1ToHomePage"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "openDialogPage1ToHomePage", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIDialogPageNextPage, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIDialogPageNextPage
            val _cache = __ins.renderCache
            fun gen_openDialog1_fn() {
                uni_openDialogPage(OpenDialogPageOptions(url = "/pages/API/dialog-page/dialog-1?name=dialog1", success = fun(res) {
                    console.log("openDialog1 success", res)
                }
                , fail = fun(err) {
                    console.log("openDialog1 fail", err)
                }
                , complete = fun(res) {
                    console.log("openDialog1 complete", res)
                }
                ))
            }
            val openDialog1 = ::gen_openDialog1_fn
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
            fun gen_openDialogPage1ToHomePage_fn() {
                val pages = getCurrentPages()
                uni_openDialogPage(OpenDialogPageOptions(parentPage = pages[0], url = "/pages/API/dialog-page/dialog-1?name=dialog1", success = fun(res) {
                    console.log("openDialogPage1ToHomePage success", res)
                    uni_showToast(ShowToastOptions(title = "在首页打开了 dialogPage"))
                }
                , fail = fun(err) {
                    console.log("openDialogPage1ToHomePage fail", err)
                }
                , complete = fun(res) {
                    console.log("openDialogPage1ToHomePage complete", res)
                }
                ))
            }
            val openDialogPage1ToHomePage = ::gen_openDialogPage1ToHomePage_fn
            fun gen_getLifeCycleNum_fn(): Number {
                return state.lifeCycleNum
            }
            val getLifeCycleNum = ::gen_getLifeCycleNum_fn
            onLoad(fun(_options){
                console.log("dialogPage parent onLoad")
            }
            )
            onPageShow(fun(){
                console.log("dialogPage parent onShow")
            }
            )
            onReady(fun(){
                console.log("dialogPage parent onReady")
            }
            )
            onHide(fun(){
                console.log("dialogPage parent onHide")
            }
            )
            onUnload(fun(){
                console.log("dialogPage parent onUnload")
            }
            )
            __expose(_uM("getLifeCycleNum" to getLifeCycleNum, "setLifeCycleNum" to setLifeCycleNum, "openDialog1" to openDialog1, "openDialog2" to openDialog2, "closeDialog" to closeDialog, "openDialogPage1ToHomePage" to openDialogPage1ToHomePage))
            return fun(): Any? {
                return _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                    _cE("button", _uM("class" to "uni-common-mt", "onClick" to openDialog1), "open dialog1"),
                    _cE("button", _uM("class" to "uni-common-mt", "onClick" to openDialog2), "open dialog2"),
                    _cE("button", _uM("class" to "uni-common-mt", "onClick" to openDialogPage1ToHomePage), "open dialog page 1 to home page")
                ))
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
