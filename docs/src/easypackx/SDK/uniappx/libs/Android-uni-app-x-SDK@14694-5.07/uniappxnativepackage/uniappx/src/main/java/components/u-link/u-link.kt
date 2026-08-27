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
import uts.sdk.modules.utsOpenSchema.openSchema
open class GenComponentsULinkULink : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var href: String by `$props`
    open var text: String by `$props`
    open var inWhiteList: Boolean by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsULinkULink) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsULinkULink
            val _cache = __ins.renderCache
            val props = __props
            val openURL = fun(){
                openSchema(props.href)
            }
            return fun(): Any? {
                return _cE("text", _uM("class" to "text", "onClick" to openURL), _tD(_ctx.text), 1)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("text" to _pS(_uM("textDecorationLine" to "underline")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("href" to _uM("type" to "String", "default" to ""), "text" to _uM("type" to "String", "default" to ""), "inWhiteList" to _uM("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = _uA(
            "href",
            "text",
            "inWhiteList"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
