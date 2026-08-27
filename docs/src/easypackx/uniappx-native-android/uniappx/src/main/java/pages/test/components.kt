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
import uts.sdk.modules.iboxsAmap.IboxsAmapComponent
import io.dcloud.uniapp.extapi.connectSocket as uni_connectSocket
import uts.sdk.modules.uniUnimp.createUniMPContext as uni_createUniMPContext
import uts.sdk.modules.iboxsZimfacade.faceVerify
import uts.sdk.modules.iboxsZimfacade.getMetaInfo
import uts.sdk.modules.iboxsZimfacade.initZimfacafe
import uts.sdk.modules.iboxsZimfacade.setUI
import uts.sdk.modules.iboxsSqlite.init as init__1
import uts.sdk.modules.iboxsSqlite.executeSql
import uts.sdk.modules.iboxsSqlite.queryData
import uts.sdk.modules.iboxsSqlite.exportDatabase
import uts.sdk.modules.iboxsBiometric.initBiometric
import uts.sdk.modules.iboxsNfc.initNFC
import uts.sdk.modules.iboxsScancode.scanCode as scanCode__1
open class GenPagesTestComponents : BasePage {
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
        var setup: (__props: GenPagesTestComponents) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesTestComponents
            val _cache = __ins.renderCache
            val a = ref("aa")
            onLoad(fun(_options){
                val app = getApp()
                console.log("初始化结果", initBiometric(app.getAndroidApplication()))
                var sq = sqlite()
                sq.exportDatabase()
                initNFC()
                authinfo.startInitQuickLogin()
                scanCode__1()
                initZimfacafe()
                var ws: SocketTask = uni_connectSocket(ConnectSocketOptions(url = "ws://echo.websocket.org"))
                var unimpInstance = uni_createUniMPContext()
            }
            )
            return fun(): Any? {
                val _component_camera = resolveComponent("camera")
                val _component_tmx_echart = resolveEasyComponent("tmx-echart", GenUniModulesTmxUiComponentsTmxEchartTmxEchartClass)
                val _component_tmx_tree_flat = resolveEasyComponent("tmx-tree-flat", GenUniModulesTmxUiComponentsTmxTreeFlatTmxTreeFlatClass)
                val _component_x_update_window = resolveEasyComponent("x-update-window", GenComponentsXUpdateWindowClass)
                val _component_tmx_markdown = resolveEasyComponent("tmx-markdown", GenUniModulesTmxUiComponentsTmxMarkdownTmxMarkdownClass)
                val _component_fui_dialog = resolveEasyComponent("fui-dialog", GenUniModulesFirstuiUvueComponentsFuiDialogFuiDialogClass)
                val _component_l_pdf = resolveEasyComponent("l-pdf", GenUniModulesLimePdfComponentsLPdfLPdfClass)
                return _cE("view", _uM("class" to "container"), _uA(
                    _cV(_component_camera),
                    _cE(IboxsAmapComponent.name),
                    _cV(_component_tmx_echart),
                    _cV(_component_tmx_tree_flat),
                    _cV(_component_x_update_window),
                    _cV(_component_tmx_markdown),
                    _cE("video"),
                    _cV(_component_fui_dialog),
                    _cV(_component_l_pdf)
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
