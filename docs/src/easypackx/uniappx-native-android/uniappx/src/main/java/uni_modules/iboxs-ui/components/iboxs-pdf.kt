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
open class GenUniModulesIboxsUiComponentsIboxsPdf : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var pdf: String by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesIboxsUiComponentsIboxsPdf) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesIboxsUiComponentsIboxsPdf
            val _cache = __ins.renderCache
            val props = __props
            val webviewPDF = computed(fun(): String? {
                return encodeURIComponent(props.pdf)
            }
            )
            return fun(): Any? {
                val _component_web_view = resolveComponent("web-view")
                return _cV(_component_web_view, _uM("src" to ("/static/pdf/webhtml.html?file=" + unref(webviewPDF)), "style" to _nS(_uM("width" to "100%", "height" to "100%"))), null, 8, _uA(
                    "src",
                    "style"
                ))
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("pdf" to _uM("type" to "String", "default" to "")))
        var propsNeedCastKeys = _uA(
            "pdf"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
