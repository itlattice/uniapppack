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
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
open class GenPagesCommonBrowserAction : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            xProvitae.scrollTop = e.scrollTop
            val pages = getCurrentPages()
            if (pages.length == 0) {
                return
            }
            val page = pages[pages.length - 1].route
            uni__emit("onPageScroll", _uO("top" to e.scrollTop, "page" to page))
        }
        , __ins)
        onResize(fun(_: OnResizeOptions) {
            uni__emit("onResize", fun() {})
        }
        , __ins)
        onLoad(fun(query: OnLoadOptions) {
            xProvitae.onLoadOpts = JSON.parseObject(JSON.stringify(query)!!) ?: _uO()
            uni__emit("onLoad", fun() {})
        }
        , __ins)
        onPageHide(fun() {
            uni__emit("onHide", fun() {})
        }
        , __ins)
        onReady(fun() {
            uni__emit("onReady", fun() {})
            xProvitae.pageReady = true
        }
        , __ins)
        onPageShow(fun() {
            uni__emit("onShow", fun() {})
        }
        , __ins)
    }
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesCommonBrowserAction) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCommonBrowserAction
            val _cache = __ins.renderCache
            val statusHeight = ref(0)
            val src = ref("")
            val pageHeight = ref(0)
            val webStyle = ref(_uO("progress" to _uO("color" to "#1678fd")))
            onLoad(fun(options){
                var srcValue = options["src"].toString()
                src.value = decodeURIComponent(srcValue) as String
            }
            )
            onReady(fun(){
                statusHeight.value = uni_getWindowInfo().safeArea.top
                pageHeight.value = uni_getWindowInfo().windowHeight
            }
            )
            val back = fun(){
                common.back()
            }
            return fun(): Any? {
                val _component_web_view = resolveComponent("web-view")
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_x_float_button = resolveEasyComponent("x-float-button", GenComponentsXFloatButtonClass)
                return _cE("view", null, _uA(
                    _cE("view", _uM("class" to "statusheight", "style" to _nS(_uM("height" to (unref(statusHeight) + "px")))), null, 4),
                    _cV(_component_web_view, _uM("src" to unref(src), "id" to "web", "class" to "full", "style" to _nS(_uM("height" to (unref(pageHeight) + "px"), "width" to "750rpx")), "progress-color" to "#1678fd"), null, 8, _uA(
                        "src",
                        "style"
                    )),
                    _cV(_component_x_float_button, _uM("onClickBotton" to back), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cV(_component_x_iconfont, _uM("name" to "guanbi", "class" to "xicon", "color" to "#ffffff", "size" to "36", "height" to 50))
                        )
                    }
                    ), "_" to 1))
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
                return _uM("statusheight" to _pS(_uM("backgroundColor" to "#ffffff")), "full" to _pS(_uM("width" to "750rpx")), "xicon" to _pS(_uM("lineHeight" to "60px", "textAlign" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
