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
open class GenPagesCommonDocumentprintview : BasePage {
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
        var setup: (__props: GenPagesCommonDocumentprintview) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCommonDocumentprintview
            val _cache = __ins.renderCache
            val pageHeight = ref(0)
            val pdfUrl = ref("")
            val key = ref("")
            val type = ref("")
            val page = ref(0)
            val pageCount = ref(0)
            val pdf = ref<UniElement?>(null)
            val prints = ref<UniElement?>(null)
            val back = fun(){
                common.back()
            }
            val loadData = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var res = await(request.callapi("center/getdocumenturl", _uO("key" to key.value, "type" to type.value)))
                        if (res.code < 0) {
                            common.toast(res.msg)
                            common.timeBack()
                            return@w1
                        }
                        var url = (res.data as UTSJSONObject)["url"] as String
                        pdfUrl.value = url
                })
            }
            val startPrint = fun(){
                common.callMethod(prints.value as Any, "open")
            }
            onLoad(fun(options: OnLoadOptions){
                key.value = decodeURIComponent(options["key"] as String) as String
                type.value = options["type"] as String
                loadData()
            }
            )
            onReady(fun(){
                pageHeight.value = uni_getWindowInfo().safeArea.height - 40
            }
            )
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_ib_pdf = resolveEasyComponent("ib-pdf", GenUniModulesIboxsUiComponentsIboxsPdfClass)
                val _component_x_bottom_popup = resolveEasyComponent("x-bottom-popup", GenComponentsXBottomPopupClass)
                val _component_x_order_print = resolveEasyComponent("x-order-print", GenComponentsXOrderPrintClass)
                return _cE("view", null, _uA(
                    _cE("view", _uM("class" to "native padding-stauts-bar background-main"), _uA(
                        _cE("view", _uM("class" to "nativetitle space-between"), _uA(
                            _cE("text", _uM("class" to "text color-white"), "打印预览"),
                            _cE("view", _uM("class" to "close-btn display-flex", "onClick" to back), _uA(
                                _cV(_component_x_iconfont, _uM("name" to "guanbi", "size" to "14", "color" to "white")),
                                _cE("text", _uM("class" to "text color-white"), "关闭")
                            ))
                        ))
                    )),
                    _cE("view", _uM("class" to "viewpdf", "style" to _nS(_uA(
                        _uM("background" to "#f5f5f5"),
                        _uM("width" to "750rpx", "height" to (unref(pageHeight) + "px"))
                    ))), _uA(
                        _cV(_component_ib_pdf, _uM("pdf" to unref(pdfUrl)), null, 8, _uA(
                            "pdf"
                        ))
                    ), 4),
                    _cV(_component_x_bottom_popup, _uM("icon" to "dayin", "color" to "#1678fd", "onClickOn" to startPrint)),
                    _cV(_component_x_order_print, _uM("ref_key" to "prints", "ref" to prints, "printUrl" to unref(pdfUrl)), null, 8, _uA(
                        "printUrl"
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
                return _uM("nativetitle" to _uM(".native " to _uM("paddingLeft" to "16rpx", "paddingRight" to "22rpx", "paddingTop" to 13, "height" to 40)), "text" to _uM(".native " to _uM("fontSize" to 14, "marginLeft" to "6rpx")), "page" to _pS(_uM("position" to "fixed", "textAlign" to "center", "width" to "750rpx", "fontSize" to 14, "color" to "#1678fd")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
