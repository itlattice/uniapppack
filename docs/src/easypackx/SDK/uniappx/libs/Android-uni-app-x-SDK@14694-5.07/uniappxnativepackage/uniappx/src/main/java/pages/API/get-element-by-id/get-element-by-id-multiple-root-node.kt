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
import io.dcloud.uniapp.extapi.getElementById as uni_getElementById
open class GenPagesAPIGetElementByIdGetElementByIdMultipleRootNode : BasePage {
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
    open var getElementByNotExistId: () -> Element?
        get() {
            return unref(this.`$exposed`["getElementByNotExistId"]) as () -> Element?
        }
        set(value) {
            setRefValue(this.`$exposed`, "getElementByNotExistId", value)
        }
    open var changePageHeadBackgroundColor: () -> Unit
        get() {
            return unref(this.`$exposed`["changePageHeadBackgroundColor"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "changePageHeadBackgroundColor", value)
        }
    open var changeTextColor: () -> Unit
        get() {
            return unref(this.`$exposed`["changeTextColor"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "changeTextColor", value)
        }
    open var changeViewStyle: () -> Unit
        get() {
            return unref(this.`$exposed`["changeViewStyle"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "changeViewStyle", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIGetElementByIdGetElementByIdMultipleRootNode, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIGetElementByIdGetElementByIdMultipleRootNode
            val _cache = __ins.renderCache
            fun gen_getElementByNotExistId_fn(): Element? {
                return uni_getElementById("not-exist-id")
            }
            val getElementByNotExistId = ::gen_getElementByNotExistId_fn
            fun gen_changePageHeadBackgroundColor_fn() {
                val pageHead = uni_getElementById("page-head")!!
                pageHead.style.setProperty("background-color", "red")
            }
            val changePageHeadBackgroundColor = ::gen_changePageHeadBackgroundColor_fn
            fun gen_changeTextColor_fn() {
                val text = uni_getElementById("text")!!
                text.style.setProperty("color", "red")
            }
            val changeTextColor = ::gen_changeTextColor_fn
            fun gen_changeViewStyle_fn() {
                val view = uni_getElementById<UniViewElement>("view")
                if (view != null) {
                    view.style.setProperty("width", "90%")
                    view.style.setProperty("height", "50px")
                    view.style.setProperty("background-color", "#007AFF")
                }
            }
            val changeViewStyle = ::gen_changeViewStyle_fn
            __expose(_uM("getElementByNotExistId" to getElementByNotExistId, "changePageHeadBackgroundColor" to changePageHeadBackgroundColor, "changeTextColor" to changeTextColor, "changeViewStyle" to changeViewStyle))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE(Fragment, null, _uA(
                    _cV(_component_page_head, _uM("id" to "page-head", "title" to "getElementById-multiple-root-node")),
                    _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                        _cE("text", _uM("id" to "text"), "this is text"),
                        _cE("view", _uM("id" to "view", "class" to "uni-common-mt", "style" to _nS(_uM("border" to "1px solid red"))), "this is view", 4),
                        _cE("button", _uM("class" to "uni-btn", "onClick" to changePageHeadBackgroundColor), " 修改 page-head 背景色 "),
                        _cE("button", _uM("class" to "uni-btn", "onClick" to changeTextColor), "修改 text 字体颜色"),
                        _cE("button", _uM("class" to "uni-btn", "onClick" to changeViewStyle), " 修改 view 宽高及背景色 ")
                    ))
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
