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
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesAPIGetCurrentPagesComponentCheckPage : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var `check$page`: () -> Boolean
        get() {
            return unref(this.`$exposed`["check\$page"]) as () -> Boolean
        }
        set(value) {
            setRefValue(this.`$exposed`, "check\$page", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIGetCurrentPagesComponentCheckPage, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIGetCurrentPagesComponentCheckPage
            val _cache = __ins.renderCache
            val instance = getCurrentInstance()
            val checkPageRes = ref(false)
            val `check$page` = fun(): Boolean {
                val pages = getCurrentPages()
                val page = pages[pages.length - 1]
                val `$page` = instance?.proxy?.`$page`
                val res = `$page` === page
                uni_showToast(if (res) {
                    ShowToastOptions(title = "check success")
                } else {
                    ShowToastOptions(title = "check fail", icon = "error")
                }
                )
                checkPageRes.value = res
                return res
            }
            __expose(_uM("check\$page" to `check$page`))
            return fun(): Any? {
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("style" to _nS(_uM("padding" to "0 10px"))), _uA(
                        _cE("button", _uM("class" to "uni-common-mb component-check-page-btn", "onClick" to `check$page`), " component check \$page "),
                        _cE("view", _uM("class" to "flex-row uni-common-mb"), _uA(
                            _cE("text", null, "check page:"),
                            _cE("text", _uM("class" to "check-page-res"), _tD(unref(checkPageRes)), 1)
                        ))
                    ), 4)
                ), 4)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("flex-row" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
