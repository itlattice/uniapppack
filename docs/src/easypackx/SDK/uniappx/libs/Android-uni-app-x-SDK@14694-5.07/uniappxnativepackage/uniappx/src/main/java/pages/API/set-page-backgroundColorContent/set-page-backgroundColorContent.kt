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
open class GenPagesAPISetPageBackgroundColorContentSetPageBackgroundColorContent : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onLoad(fun(_: OnLoadOptions) {
            stat_instance.onLoad(this)
        }
        , __ins)
        onPageShow(fun() {
            stat_instance.onShow(this)
        }
        , __ins)
        onPageHide(fun() {
            stat_instance.onHide(this)
        }
        , __ins)
        onUnload(fun() {
            stat_instance.onUnload(this)
        }
        , __ins)
    }
    open var data: DataType__57
        get() {
            return unref(this.`$exposed`["data"]) as DataType__57
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var changeColor: () -> Unit
        get() {
            return unref(this.`$exposed`["changeColor"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "changeColor", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPISetPageBackgroundColorContentSetPageBackgroundColorContent, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPISetPageBackgroundColorContentSetPageBackgroundColorContent
            val _cache = __ins.renderCache
            val isChange = ref(false)
            val data = reactive(DataType__57(currentBackgroundColorContent = null as String?))
            fun gen_changeColor_fn() {
                var pages = getCurrentPages()
                var page = pages[pages.length - 1]
                page.setPageStyle(_uO("backgroundColorContent" to if (isChange.value) {
                    ""
                } else {
                    "red"
                }
                ))
                isChange.value = !isChange.value
                var pageJson = page.getPageStyle()
                data.currentBackgroundColorContent = pageJson["backgroundColorContent"] as String?
            }
            val changeColor = ::gen_changeColor_fn
            __expose(_uM("data" to data, "changeColor" to changeColor))
            return fun(): Any? {
                return _cE("view", _uM("class" to "container", "onClick" to changeColor), _uA(
                    _cE("text", null, "点击切换页面容器颜色")
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
                return _uM("container" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "alignItems" to "center", "justifyContent" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
