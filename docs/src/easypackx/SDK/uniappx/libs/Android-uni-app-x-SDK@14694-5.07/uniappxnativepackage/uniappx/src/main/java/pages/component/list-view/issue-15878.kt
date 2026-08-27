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
open class GenPagesComponentListViewIssue15878 : BasePage {
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
    open var data: DataType__47
        get() {
            return unref(this.`$exposed`["data"]) as DataType__47
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var onRefresh: () -> Unit
        get() {
            return unref(this.`$exposed`["onRefresh"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "onRefresh", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentListViewIssue15878, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentListViewIssue15878
            val _cache = __ins.renderCache
            val data = reactive(DataType__47(refresherTriggered = false))
            fun gen_onRefresh_fn() {
                data.refresherTriggered = true
                setTimeout(fun(){
                    data.refresherTriggered = false
                }
                , 5000)
            }
            val onRefresh = ::gen_onRefresh_fn
            onLoad(fun(_options){})
            __expose(_uM("data" to data, "onRefresh" to onRefresh))
            return fun(): Any? {
                return _cE("view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("list-view", _uM("style" to _nS(_uM("flex" to "1")), "refresher-enabled" to "true", "onRefresherrefresh" to onRefresh, "refresher-triggered" to unref(data).refresherTriggered, "refresher-default-style" to "none"), _uA(
                        _cE(Fragment, null, RenderHelpers.renderList(1000, fun(item, __key, __index, _cached): Any {
                            return _cE("list-item", _uM("class" to "item", "key" to item), _uA(
                                _cE("text", null, _tD(item), 1)
                            ))
                        }
                        ), 64),
                        _cE("list-item", _uM("class" to "refresher", "slot" to "refresher"), _uA(
                            _cE("text", _uM("class" to "refresher-text"), "自定义下拉刷新")
                        ))
                    ), 44, _uA(
                        "refresher-triggered"
                    ))
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
                return _uM("item" to _pS(_uM("height" to 50)), "refresher" to _pS(_uM("height" to 45)), "refresher-text" to _pS(_uM("lineHeight" to "45px", "textAlign" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
