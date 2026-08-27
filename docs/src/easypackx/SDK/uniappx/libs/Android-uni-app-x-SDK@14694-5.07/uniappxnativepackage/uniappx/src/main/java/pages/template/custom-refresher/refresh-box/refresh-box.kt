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
open class GenPagesTemplateCustomRefresherRefreshBoxRefreshBox : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var state: Number by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesTemplateCustomRefresherRefreshBoxRefreshBox) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesTemplateCustomRefresherRefreshBoxRefreshBox
            val _cache = __ins.renderCache
            val text = _uA(
                "继续下拉执行刷新",
                "释放立即刷新",
                "刷新中",
                ""
            )
            return fun(): Any? {
                return _cE("list-item", _uM("slot" to "refresher", "class" to "refresh-box"), _uA(
                    if (_ctx.state == 2) {
                        _cE("image", _uM("key" to 0, "class" to "refresh-icon", "src" to "https://web-ext-storage.dcloud.net.cn/hello-uni-app-x/refresh-box-run.gif", "mode" to "widthFix"))
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    _cE("text", _uM("class" to "tip-text"), _tD(text[_ctx.state]), 1)
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
                return _uM("refresh-box" to _pS(_uM("justifyContent" to "center", "alignItems" to "center", "flexDirection" to "row", "height" to 30)), "refresh-icon" to _pS(_uM("width" to 20, "height" to 20, "marginTop" to 5, "marginRight" to 5, "marginBottom" to 5, "marginLeft" to 5)), "tip-text" to _pS(_uM("color" to "#888888", "fontSize" to 12)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("state" to _uM("type" to "Number", "required" to true, "default" to 0)))
        var propsNeedCastKeys = _uA(
            "state"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
