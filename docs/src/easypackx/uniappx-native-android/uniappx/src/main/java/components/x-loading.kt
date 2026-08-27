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
import uts.sdk.modules.tmxLoadingS.showLoading
import uts.sdk.modules.tmxLoadingS.XLOADINGS_TYPE
open class GenComponentsXLoading__1 : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var showIcon: Boolean by `$props`
    open var title: String by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    open fun showLoading(title: String = "加载中") {
        callKotlinFunction(this.`$exposed`["showLoading"]!!, _uA(
            title
        ))
    }
    open var closeLoading: () -> Unit
        get() {
            return unref(this.`$exposed`["closeLoading"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "closeLoading", value)
        }
    open var close: () -> Unit
        get() {
            return unref(this.`$exposed`["close"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "close", value)
        }
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXLoading__1, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXLoading__1
            val _cache = __ins.renderCache
            val props = __props
            val show = ref(false)
            val label = ref("加载中")
            watch(fun(): String {
                return props.title
            }
            , fun(newVal: String){
                label.value = newVal
            }
            , WatchOptions(immediate = true))
            fun showLoading(title: String = "加载中") {
                show.value = true
                if (title != "") {
                    label.value = title
                } else {
                    label.value = "加载中"
                }
            }
            val closeLoading = fun(){
                show.value = false
            }
            val close = fun(){
                show.value = false
            }
            __expose(_uM("showLoading" to ::showLoading, "closeLoading" to closeLoading, "close" to close))
            return fun(): Any? {
                val _component_fui_loading = resolveEasyComponent("fui-loading", GenUniModulesFirstuiUvueComponentsFuiLoadingFuiLoadingClass)
                return if (isTrue(unref(show))) {
                    _cV(_component_fui_loading, _uM("key" to 0, "type" to "col", "text" to unref(label), "isFixed" to true, "isMask" to true), null, 8, _uA(
                        "text"
                    ))
                } else {
                    _cC("v-if", true)
                }
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("showIcon" to _uM("type" to "Boolean", "default" to true), "title" to _uM("type" to "String", "default" to "加载中")))
        var propsNeedCastKeys = _uA(
            "showIcon",
            "title"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
