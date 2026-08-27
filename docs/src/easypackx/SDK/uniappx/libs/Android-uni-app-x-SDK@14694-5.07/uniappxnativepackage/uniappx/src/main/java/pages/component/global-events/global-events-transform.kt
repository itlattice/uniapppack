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
open class GenPagesComponentGlobalEventsGlobalEventsTransform : BasePage {
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
    open var data: DataType__38
        get() {
            return unref(this.`$exposed`["data"]) as DataType__38
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentGlobalEventsGlobalEventsTransform, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentGlobalEventsGlobalEventsTransform
            val _cache = __ins.renderCache
            val data = reactive(DataType__38(clickTriger = false, longClickTriger = false))
            fun gen_onclick_fn(event: UniPointerEvent) {
                data.clickTriger = true
                uni_showToast(ShowToastOptions(title = "触发了点击事件"))
            }
            val onclick = ::gen_onclick_fn
            fun gen_onLongPress_fn(event: UniTouchEvent) {
                data.longClickTriger = true
                uni_showToast(ShowToastOptions(title = "触发了长按事件"))
            }
            val onLongPress = ::gen_onLongPress_fn
            __expose(_uM("data" to data))
            return fun(): Any? {
                return _cE(Fragment, null, _uA(
                    _cE("view", null, _uA(
                        _cE("view", _uM("onClick" to onclick, "style" to _nS(_uM("transform" to "rotate(180deg)", "background-color" to "brown", "width" to "100px", "height" to "100px", "margin" to "8px auto")), "onLongpress" to onLongPress, "id" to "event-transform"), _uA(
                            _cE("text", _uM("style" to _nS(_uM("text-align" to "center", "line-height" to "100px"))), "旋转180°后", 4)
                        ), 36)
                    )),
                    _cE("text", _uM("style" to _nS(_uM("margin" to "0px auto"))), "点击上面view触发点击事件", 4)
                ), 64)
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
