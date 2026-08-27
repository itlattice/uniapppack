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
open class GenPagesComponentGlobalEventsIssue17662 : BasePage {
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
    open var data: DataType__37
        get() {
            return unref(this.`$exposed`["data"]) as DataType__37
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentGlobalEventsIssue17662, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentGlobalEventsIssue17662
            val _cache = __ins.renderCache
            val data = reactive(DataType__37(longpressItem = false, longpressText = false, isStopPropagation = false, scrollTop = 0))
            fun gen_longpress_item_fn(_e: UniTouchEvent) {
                console.log("longpress listItem")
                data.longpressItem = true
            }
            val longpress_item = ::gen_longpress_item_fn
            fun gen_longpress_text_fn(e: UniTouchEvent) {
                console.log("longpress text")
                data.longpressText = true
                if (data.isStopPropagation) {
                    e.stopPropagation()
                }
            }
            val longpress_text = ::gen_longpress_text_fn
            __expose(_uM("data" to data))
            return fun(): Any? {
                return _cE("list-view", _uM("style" to _nS(_uM("flex" to "1")), "scroll-top" to unref(data).scrollTop), _uA(
                    _cE(Fragment, null, RenderHelpers.renderList(50, fun(item, __key, __index, _cached): Any {
                        return _cE("list-item", _uM("key" to item, "onLongpress" to longpress_item, "style" to _nS(_uM("border-bottom-style" to "solid", "border-bottom-width" to "1px", "border-bottom-color" to "black"))), _uA(
                            _cE("view", _uM("style" to _nS(_uM("width" to "100%", "height" to "40px", "background-color" to "antiquewhite"))), _uA(
                                _cE("text", _uM("onLongpress" to longpress_text, "style" to _nS(_uM("font-size" to "10px", "width" to "100px", "height" to "100%", "background-color" to "red"))), _tD(item), 37)
                            ), 4)
                        ), 36)
                    }
                    ), 64)
                ), 12, _uA(
                    "scroll-top"
                ))
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
