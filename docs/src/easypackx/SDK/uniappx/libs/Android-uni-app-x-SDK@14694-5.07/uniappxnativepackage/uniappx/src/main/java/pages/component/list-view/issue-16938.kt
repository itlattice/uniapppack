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
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
open class GenPagesComponentListViewIssue16938 : BasePage {
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
    open var setScrollTop: (top: Number) -> Unit
        get() {
            return unref(this.`$exposed`["setScrollTop"]) as (top: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setScrollTop", value)
        }
    open var toNextPage: () -> Unit
        get() {
            return unref(this.`$exposed`["toNextPage"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "toNextPage", value)
        }
    open var getScrollTop: () -> Number
        get() {
            return unref(this.`$exposed`["getScrollTop"]) as () -> Number
        }
        set(value) {
            setRefValue(this.`$exposed`, "getScrollTop", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentListViewIssue16938, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentListViewIssue16938
            val _cache = __ins.renderCache
            val scrollTop = ref(0)
            val listRef = ref<UniListViewElement?>(null)
            fun gen_toNextPage_fn() {
                uni_navigateTo(NavigateToOptions(url = "/pages/component/list-view/list-view"))
            }
            val toNextPage = ::gen_toNextPage_fn
            fun gen_getScrollTop_fn(): Number {
                return listRef.value?.scrollTop ?: 0
            }
            val getScrollTop = ::gen_getScrollTop_fn
            fun gen_setScrollTop_fn(top: Number) {
                if (listRef.value != null) {
                    listRef.value!!.scrollTop = top
                }
            }
            val setScrollTop = ::gen_setScrollTop_fn
            __expose(_uM("setScrollTop" to setScrollTop, "toNextPage" to toNextPage, "getScrollTop" to getScrollTop))
            return fun(): Any? {
                return _cE("list-view", _uM("ref_key" to "listRef", "ref" to listRef, "style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE(Fragment, null, RenderHelpers.renderList(1000, fun(item, __key, __index, _cached): Any {
                        return _cE("list-item", _uM("class" to "item", "key" to item, "onClick" to toNextPage), _uA(
                            _cE("text", null, _tD(item) + "点击跳转下一页", 1)
                        ))
                    }
                    ), 64)
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
                return _uM("item" to _pS(_uM("height" to 100)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
