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
open class GenPagesTemplateIssue26523Issue26523 : BasePage {
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
    open var toggleListView: () -> Unit
        get() {
            return unref(this.`$exposed`["toggleListView"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "toggleListView", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesTemplateIssue26523Issue26523, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesTemplateIssue26523Issue26523
            val _cache = __ins.renderCache
            val showList = ref(true)
            fun gen_toggleListView_fn() {
                showList.value = !showList.value
            }
            val toggleListView = ::gen_toggleListView_fn
            __expose(_uM("toggleListView" to toggleListView))
            return fun(): Any? {
                return _cE("view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("button", _uM("onClick" to toggleListView), "toggle list view"),
                    if (isTrue(unref(showList))) {
                        _cE("list-view", _uM("key" to 0, "style" to _nS(_uM("flex" to "1"))), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(1, fun(index, __key, __index, _cached): Any {
                                return _cE("list-item", _uM("key" to index), _uA(
                                    _cE("view", null, _uA(
                                        _cE("text", null, "item " + _tD(index), 1)
                                    ))
                                ))
                            }), 64)
                        ), 4)
                    } else {
                        _cC("v-if", true)
                    }
                ), 4)
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
