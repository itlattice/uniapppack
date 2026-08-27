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
import uts.sdk.modules.limePdf.LimePDF
import uts.sdk.modules.limePdf.RenderOptions
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
open class GenUniModulesLimePdfComponentsLPdfLPdf : VueComponent, PDFProps {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    override var url: String? by `$props`
    override var lStyle: Any? by `$props`
    override var page: Number by `$props`
    override var spacing: Number? by `$props`
    override var swipeHorizontal: Boolean by `$props`
    override var password: String? by `$props`
    override var scrollView: Boolean by `$props`
    override var backTop: Boolean by `$props`
    override var zoomEnable: Boolean by `$props`
    override var scrollEnable: Boolean by `$props`
    override var scale: Number? by `$props`
    override var renderType: String? by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    open var jumpTo: (page: Number) -> Unit
        get() {
            return unref(this.`$exposed`["jumpTo"]) as (page: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "jumpTo", value)
        }
    open var render: (options: RenderOptions) -> Unit
        get() {
            return unref(this.`$exposed`["render"]) as (options: RenderOptions) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "render", value)
        }
    open var nextPage: () -> Unit
        get() {
            return unref(this.`$exposed`["nextPage"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "nextPage", value)
        }
    open var prevPage: () -> Unit
        get() {
            return unref(this.`$exposed`["prevPage"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "prevPage", value)
        }
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesLimePdfComponentsLPdfLPdf, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesLimePdfComponentsLPdfLPdf
            val _cache = __ins.renderCache
            var limePDF: LimePDF? = null
            val props = __props
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val height = ref(0)
            val top = ref(0)
            val pixelRatio = uni_getWindowInfo().pixelRatio
            fun gen_render_fn(options: RenderOptions) {
                val path = options.url
                val page = options.page
                val swipeHorizontal = options.swipeHorizontal
                val password = options.password
                limePDF?.render(RenderOptions(url = path, page = page, swipeHorizontal = swipeHorizontal, password = password, scrollView = props.scrollView, spacing = props.spacing))
            }
            val render = ::gen_render_fn
            fun gen_jumpTo_fn(page: Number) {
                limePDF?.jumpTo(page)
            }
            val jumpTo = ::gen_jumpTo_fn
            fun gen_nextPage_fn() {
                limePDF?.nextPage()
            }
            val nextPage = ::gen_nextPage_fn
            fun gen_prevPage_fn() {
                limePDF?.prevPage()
            }
            val prevPage = ::gen_prevPage_fn
            fun gen_handleLoad_fn(e: UniNativeViewEvent) {
                val h = (e.detail.getNumber("pageHeight") ?: 0) / pixelRatio
                val p = e.detail.getNumber("pageCount") ?: 0
                height.value = h * (p + 1)
                emit("load", e.detail)
            }
            val handleLoad = ::gen_handleLoad_fn
            fun gen_handProgress_fn(e: UniNativeViewEvent) {
                val y = (e.detail.getNumber("y") ?: 0)
                top.value = Math.abs(y / pixelRatio)
            }
            val handProgress = ::gen_handProgress_fn
            fun gen_scroll_fn(e: UniScrollEvent) {
                top.value = e.detail.scrollTop
                limePDF?.moveTo(0, e.detail.scrollTop * -1 * pixelRatio)
            }
            val scroll = ::gen_scroll_fn
            fun gen_handleFail_fn(e: UniNativeViewEvent) {
                emit("fail", e.detail)
            }
            val handleFail = ::gen_handleFail_fn
            fun gen_pageChanged_fn(e: UniNativeViewEvent) {
                emit("pageChanged", e.detail)
            }
            val pageChanged = ::gen_pageChanged_fn
            fun gen_onviewinit_fn(e: UniNativeViewInitEvent) {
                limePDF = LimePDF(e.detail.element)
                if (props.url == null) {
                    return
                }
                render(RenderOptions(url = props.url!!, page = props.page, swipeHorizontal = props.swipeHorizontal, password = props.password ?: ""))
            }
            val onviewinit = ::gen_onviewinit_fn
            fun gen_onUnmounted_fn() {
                limePDF?.destroy()
            }
            val onUnmounted__1 = ::gen_onUnmounted_fn
            watchEffect(fun(){
                render(RenderOptions(url = props.url ?: "", page = props.page, swipeHorizontal = props.swipeHorizontal, password = props.password ?: ""))
            }
            )
            __expose(_uM("jumpTo" to jumpTo, "render" to render, "nextPage" to nextPage, "prevPage" to prevPage))
            return fun(): Any? {
                return if (isTrue(_ctx.scrollView && !_ctx.swipeHorizontal)) {
                    _cE("view", _uM("key" to 0, "style" to _nS(_uA(
                        _ctx.lStyle
                    ))), _uA(
                        _cE("scroll-view", _uM("scroll-y" to "true", "direction" to "vertical", "onScroll" to scroll, "scroll-top" to unref(top), "style" to _nS(_uM("flex" to "1", "position" to "absolute", "z-index" to "1", "left" to "0", "right" to "0", "top" to "0", "bottom" to "0"))), _uA(
                            _cE("view", _uM("style" to _nS(_uM("height" to (unref(height) + "px")))), null, 4)
                        ), 44, _uA(
                            "scroll-top"
                        )),
                        _cE("native-view", _uM("style" to _nS(_uM("flex" to "1")), "onInit" to onviewinit, "onLoad" to handleLoad, "onFail" to handleFail, "on:pageChanged" to pageChanged, "onProgress" to handProgress), null, 36)
                    ), 4)
                } else {
                    _cE("native-view", _uM("key" to 1, "onInit" to onviewinit, "onLoad" to handleLoad, "onFail" to handleFail, "on:pageChanged" to pageChanged, "style" to _nS(_uA(
                        _ctx.lStyle
                    ))), null, 36)
                }
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("l-pdf" to _pS(_uM("width" to "100%", "height" to "100%")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("load" to null, "fail" to null, "pageChanged" to null)
        var props = _nP(_uM("url" to _uM("type" to "String", "required" to false), "lStyle" to _uM("type" to _uA(
            "String",
            "UTSJSONObject"
        ), "required" to false), "page" to _uM("type" to "Number", "required" to true, "default" to 0), "spacing" to _uM("type" to "Number", "required" to false), "swipeHorizontal" to _uM("type" to "Boolean", "required" to true, "default" to false), "password" to _uM("type" to "String", "required" to false), "scrollView" to _uM("type" to "Boolean", "required" to true, "default" to false), "backTop" to _uM("type" to "Boolean", "required" to true, "default" to false), "zoomEnable" to _uM("type" to "Boolean", "required" to true, "default" to true), "scrollEnable" to _uM("type" to "Boolean", "required" to true, "default" to true), "scale" to _uM("type" to "Number", "required" to false), "renderType" to _uM("type" to "String", "required" to false)))
        var propsNeedCastKeys = _uA(
            "page",
            "swipeHorizontal",
            "scrollView",
            "backTop",
            "zoomEnable",
            "scrollEnable"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
