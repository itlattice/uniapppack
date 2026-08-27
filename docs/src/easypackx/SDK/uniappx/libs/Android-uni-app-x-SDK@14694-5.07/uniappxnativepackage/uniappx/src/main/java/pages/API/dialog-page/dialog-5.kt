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
open class GenPagesAPIDialogPageDialog5 : BasePage {
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
        var setup: (__props: GenPagesAPIDialogPageDialog5) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIDialogPageDialog5
            val _cache = __ins.renderCache
            val instance = getCurrentInstance()!!.proxy!!
            val currentPage = instance.`$page`
            val title = ref("dialog 5")
            val pageBody = ref(null as UniPageBody?)
            val safeAreaInsets = ref(null as UniSafeAreaInsets?)
            val width = ref(null as Number?)
            val height = ref(null as Number?)
            val statusBarHeight = ref(null as Number?)
            onPageShow(fun(){
                console.log("dialog 5 onShow")
            }
            )
            onReady(fun(){
                pageBody.value = currentPage.pageBody
                safeAreaInsets.value = currentPage.safeAreaInsets
                width.value = currentPage.width
                height.value = currentPage.height
                statusBarHeight.value = currentPage.statusBarHeight
            }
            )
            onUnload(fun(){
                console.log("dialog 5 onUnload")
            }
            )
            fun gen_closeThisDialog_fn() {
                if (currentPage != null) {
                    uni_closeDialogPage(CloseDialogPageOptions(dialogPage = currentPage, success = fun(res) {
                        console.log("closeThisDialog success", res)
                    }
                    , fail = fun(err) {
                        console.log("closeThisDialog fail", err)
                    }
                    , complete = fun(res) {
                        console.log("closeThisDialog complete", res)
                    }
                    ))
                }
            }
            val closeThisDialog = ::gen_closeThisDialog_fn
            return fun(): Any? {
                return _cE("view", _uM("class" to "dialog-container"), _uA(
                    _cE("view", _uM("class" to "dialog-content"), _uA(
                        _cE("text", null, "title: " + _tD(unref(title)), 1),
                        if (unref(pageBody) != null) {
                            _cE("view", _uM("key" to 0, "class" to "uni-common-mt flex-row"), _uA(
                                "pageBody: { top: ",
                                _cE("text", _uM("id" to "page-body-top"), _tD(unref(pageBody)!!.top), 1),
                                ", right: ",
                                _cE("text", _uM("id" to "page-body-right"), _tD(unref(pageBody)!!.right), 1),
                                ", bottom: ",
                                _cE("text", _uM("id" to "page-body-bottom"), _tD(unref(pageBody)!!.bottom), 1),
                                ", left: ",
                                _cE("text", _uM("id" to "page-body-left"), _tD(unref(pageBody)!!.left), 1),
                                ", width: ",
                                _cE("text", _uM("id" to "page-body-width"), _tD(unref(pageBody)!!.width), 1),
                                ", height: ",
                                _cE("text", _uM("id" to "page-body-height"), _tD(unref(pageBody)!!.height), 1),
                                " } "
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        if (unref(safeAreaInsets) != null) {
                            _cE("view", _uM("key" to 1, "class" to "uni-common-mt flex-row"), _uA(
                                "safeAreaInsets: { top: ",
                                _cE("text", _uM("id" to "page-safe-area-insets-top"), _tD(unref(safeAreaInsets)!!.top), 1),
                                ", right: ",
                                _cE("text", _uM("id" to "page-safe-area-insets-right"), _tD(unref(safeAreaInsets)!!.right), 1),
                                ", bottom: ",
                                _cE("text", _uM("id" to "page-safe-area-insets-bottom"), _tD(unref(safeAreaInsets)!!.bottom), 1),
                                ", left: ",
                                _cE("text", _uM("id" to "page-safe-area-insets-left"), _tD(unref(safeAreaInsets)!!.left), 1),
                                "} "
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        if (unref(width) != null) {
                            _cE("view", _uM("key" to 2, "class" to "uni-common-mt flex-row"), _uA(
                                "width: ",
                                _cE("text", null, _tD(unref(width)!!), 1)
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        if (unref(height) != null) {
                            _cE("view", _uM("key" to 3, "class" to "uni-common-mt flex-row"), _uA(
                                "height: ",
                                _cE("text", null, _tD(unref(height)!!), 1)
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        if (unref(statusBarHeight) != null) {
                            _cE("view", _uM("key" to 4, "class" to "uni-common-mt flex-row"), _uA(
                                "statusBarHeight: ",
                                _cE("text", null, _tD(unref(statusBarHeight)!!), 1)
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        _cE("button", _uM("class" to "mt-10", "onClick" to closeThisDialog), " closeThisDialog ")
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
                return _uM("dialog-container" to _pS(_uM("width" to "100%", "height" to "100%", "backgroundColor" to "rgba(0,0,0,0.3)", "display" to "flex", "justifyContent" to "center", "alignItems" to "center")), "dialog-content" to _pS(_uM("width" to "80%", "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "backgroundColor" to "#ffffff", "borderTopLeftRadius" to 6, "borderTopRightRadius" to 6, "borderBottomRightRadius" to 6, "borderBottomLeftRadius" to 6)), "mt-10" to _pS(_uM("marginTop" to 10)), "flex-row" to _pS(_uM("flexDirection" to "row", "flexWrap" to "wrap")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
