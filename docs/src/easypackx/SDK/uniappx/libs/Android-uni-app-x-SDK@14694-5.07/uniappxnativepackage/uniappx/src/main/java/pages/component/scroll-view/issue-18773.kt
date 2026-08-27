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
import io.dcloud.uniapp.extapi.getElementById as uni_getElementById
open class GenPagesComponentScrollViewIssue18773 : BasePage {
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
    open var data: DataType__7
        get() {
            return unref(this.`$exposed`["data"]) as DataType__7
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var scrollTo: () -> Unit
        get() {
            return unref(this.`$exposed`["scrollTo"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "scrollTo", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentScrollViewIssue18773, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentScrollViewIssue18773
            val _cache = __ins.renderCache
            val data = reactive(DataType__7(scrollEndTriggeredTimes = 0, scrollTop = 0))
            fun gen_scrollTo_fn() {
                val scroll = uni_getElementById("scroll") as UniScrollViewElement
                scroll.scrollTop = data.scrollTop
                data.scrollTop += 20
            }
            val scrollTo = ::gen_scrollTo_fn
            fun gen_onScrollEnd_fn() {
                console.log("scrollEnd触发了")
                data.scrollEndTriggeredTimes++
            }
            val onScrollEnd = ::gen_onScrollEnd_fn
            onLoad(fun(_options){})
            __expose(_uM("data" to data, "scrollTo" to scrollTo))
            return fun(): Any? {
                return _cE("view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("button", _uM("id" to "test-btn", "onClick" to fun(){
                        scrollTo()
                    }
                    ), "滚动", 8, _uA(
                        "onClick"
                    )),
                    _cE("scroll-view", _uM("id" to "scroll", "style" to _nS(_uM("flex" to "1")), "direction" to "vertical", "onScrollend" to onScrollEnd), _uA(
                        _cE("view", _uM("style" to _nS(_uM("border" to "dashed 10px black", "height" to "3000px"))), null, 4)
                    ), 36)
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
