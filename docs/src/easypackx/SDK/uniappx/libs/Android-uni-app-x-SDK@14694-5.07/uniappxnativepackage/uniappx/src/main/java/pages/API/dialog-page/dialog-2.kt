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
open class GenPagesAPIDialogPageDialog2 : BasePage {
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
        var setup: (__props: GenPagesAPIDialogPageDialog2) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIDialogPageDialog2
            val _cache = __ins.renderCache
            val currentPage = getCurrentInstance()?.proxy?.`$page`
            val title = ref("dialog 2")
            onLoad(fun(options: OnLoadOptions){
                console.log("dialog 2 onLoad", options)
                setLifeCycleNum(state.lifeCycleNum + 1)
            }
            )
            onPageShow(fun(){
                console.log("dialog 2 onShow")
                setLifeCycleNum(state.lifeCycleNum + 1)
            }
            )
            onReady(fun(){
                console.log("dialog 2 onReady")
                setLifeCycleNum(state.lifeCycleNum + 1)
            }
            )
            onHide(fun(){
                console.log("dialog 2 onHide")
                setLifeCycleNum(state.lifeCycleNum - 1)
            }
            )
            onUnload(fun(){
                console.log("dialog 2 onUnload")
                setLifeCycleNum(state.lifeCycleNum - 5)
            }
            )
            onBackPress(fun(options: OnBackPressOptions): Boolean? {
                setLifeCycleNum(state.lifeCycleNum + 1)
                return false
            }
            )
            fun gen_goNextPage_fn() {
                uni_navigateTo(NavigateToOptions(url = "/pages/API/dialog-page/next-page"))
            }
            val goNextPage = ::gen_goNextPage_fn
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
            fun gen_back_fn() {
                uni_navigateBack(null)
            }
            val back = ::gen_back_fn
            return fun(): Any? {
                return _cE("view", _uM("id" to "dialog2", "class" to "dialog-container"), _uA(
                    _cE("view", _uM("class" to "dialog-content"), _uA(
                        _cE("text", null, "title: " + _tD(unref(title)), 1),
                        _cE("text", _uM("class" to "mt-10"), "onBackPress return false"),
                        _cE("button", _uM("class" to "mt-10", "onClick" to goNextPage), "go next page"),
                        _cE("button", _uM("class" to "mt-10", "onClick" to openDialog1), "openDialog1"),
                        _cE("button", _uM("class" to "mt-10", "onClick" to closeDialog), "closeDialog"),
                        _cE("button", _uM("class" to "mt-10", "onClick" to closeThisDialog), "closeThisDialog"),
                        _cE("button", _uM("class" to "mt-10", "onClick" to back), "back")
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
