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
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
open class GenPagesAPIGetElementByIdGetElementById : BasePage {
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
    open var changeImageStyle: () -> Unit
        get() {
            return unref(this.`$exposed`["changeImageStyle"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "changeImageStyle", value)
        }
    open var changeScrollViewStyle: () -> Unit
        get() {
            return unref(this.`$exposed`["changeScrollViewStyle"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "changeScrollViewStyle", value)
        }
    open var getTextOffsetLeft: () -> Number
        get() {
            return unref(this.`$exposed`["getTextOffsetLeft"]) as () -> Number
        }
        set(value) {
            setRefValue(this.`$exposed`, "getTextOffsetLeft", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIGetElementByIdGetElementById, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIGetElementByIdGetElementById
            val _cache = __ins.renderCache
            val getElementByNotExistId = fun(): Element? {
                return uni_getElementById("not-exist-id")
            }
            val changePageHeadBackgroundColor = fun(){
                val pageHead = uni_getElementById("page-head")!!
                pageHead.style.setProperty("background-color", "red")
            }
            val changeTextColor = fun(){
                val text = uni_getElementById("text")!!
                text.style.setProperty("color", "red")
            }
            val changeViewStyle = fun(){
                val view = uni_getElementById<UniViewElement>("view")
                if (view != null) {
                    view.style.setProperty("width", "90%")
                    view.style.setProperty("height", "50px")
                    view.style.setProperty("background-color", "#007AFF")
                }
            }
            val changeImageStyle = fun(){
                val image = uni_getElementById<UniImageElement>("image")
                if (image != null) {
                    image.style.setProperty("width", "100px")
                    image.style.setProperty("height", "100px")
                    image.style.setProperty("border", "3px solid blue")
                    image.style.setProperty("border-radius", "10px")
                }
            }
            val changeScrollViewStyle = fun(){
                val scrollView = uni_getElementById<UniElement>("scroll-view")
                if (scrollView != null) {
                    scrollView.style.setProperty("width", "200px")
                    scrollView.style.setProperty("height", "60px")
                    scrollView.style.setProperty("background-color", "#e3f2fd")
                    scrollView.style.setProperty("border", "2px solid #007AFF")
                }
            }
            val goMultipleRootNode = fun(){
                uni_navigateTo(NavigateToOptions(url = "/pages/API/get-element-by-id/get-element-by-id-multiple-root-node"))
            }
            val getTextOffsetLeft = fun(): Number {
                val text = uni_getElementById("text")!!
                return text.offsetLeft
            }
            __expose(_uM("getElementByNotExistId" to getElementByNotExistId, "changePageHeadBackgroundColor" to changePageHeadBackgroundColor, "changeTextColor" to changeTextColor, "changeViewStyle" to changeViewStyle, "changeImageStyle" to changeImageStyle, "changeScrollViewStyle" to changeScrollViewStyle, "getTextOffsetLeft" to getTextOffsetLeft))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE(Fragment, null, _uA(
                    _cV(_component_page_head, _uM("id" to "page-head", "title" to "getElementById")),
                    _cE("view", _uM("style" to _nS(_uM("margin" to "0 15px"))), _uA(
                        _cE("text", _uM("id" to "text"), "this is text"),
                        _cE("view", _uM("id" to "view", "class" to "uni-common-mt", "style" to _nS(_uM("border" to "1px solid red"))), "this is view", 4),
                        _cE("image", _uM("id" to "image", "class" to "uni-common-mt", "src" to "/static/test-image/logo.png", "style" to _nS(_uM("width" to "50px", "height" to "50px"))), null, 4),
                        _cE("scroll-view", _uM("id" to "scroll-view", "class" to "uni-common-mt", "style" to _nS(_uM("width" to "100px", "height" to "50px", "background-color" to "#f0f0f0", "border" to "1px solid #ccc"))), _uA(
                            _cE("text", null, "this is scroll-view")
                        ), 4),
                        _cE("button", _uM("class" to "uni-btn", "onClick" to changePageHeadBackgroundColor), " 修改 page-head 背景色 "),
                        _cE("button", _uM("class" to "uni-btn", "onClick" to changeTextColor), " 修改 text 字体颜色 "),
                        _cE("button", _uM("class" to "uni-btn", "onClick" to changeViewStyle), " 修改 view 宽高及背景色 "),
                        _cE("button", _uM("class" to "uni-btn", "onClick" to changeImageStyle), " 修改 image 宽高及边框 "),
                        _cE("button", _uM("class" to "uni-btn", "onClick" to changeScrollViewStyle), " 修改 scroll-view 宽高及背景色 "),
                        _cE("button", _uM("class" to "uni-btn", "onClick" to goMultipleRootNode), " 跳转多根节点示例 ")
                    ), 4)
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
