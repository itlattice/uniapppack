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
import io.dcloud.uniapp.extapi.createSelectorQuery as uni_createSelectorQuery
open class GenUniModulesTmxUiComponentsTmxTabsTabsItem : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var id: String by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesTmxUiComponentsTmxTabsTabsItem) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesTmxUiComponentsTmxTabsTabsItem
            val _cache = __ins.renderCache
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val props = __props
            val proxy = getCurrentInstance()?.proxy
            val getNodeinfo = fun(){
                var t = proxy
                uni_createSelectorQuery().`in`(t).select(".xTabsItemChildren").boundingClientRect(fun(rect: Any){
                    emit("change", rect as NodeInfo, props.id)
                }
                ).exec()
            }
            onMounted(fun(){
                getNodeinfo()
            }
            )
            onBeforeUnmount(fun(){
                emit("destory", props.id)
            }
            )
            return fun(): Any? {
                return _cE("view", _uM("class" to "xTabsItemChildren"), _uA(
                    renderSlot(_ctx.`$slots`, "default")
                ))
            }
        }
        var name = "tabsItem"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("xTabsItemChildren" to _pS(_uM("display" to "flex", "flexDirection" to "row", "flexWrap" to "nowrap", "justifyContent" to "center", "alignItems" to "center", "flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("change" to null, "destory" to null)
        var props = _nP(_uM("id" to _uM("type" to "String", "default" to "")))
        var propsNeedCastKeys = _uA(
            "id"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
