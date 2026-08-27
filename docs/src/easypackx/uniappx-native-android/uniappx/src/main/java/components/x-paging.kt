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
open class GenComponentsXPaging : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var height: Number by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    open var closeRefresh: () -> Unit
        get() {
            return unref(this.`$exposed`["closeRefresh"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "closeRefresh", value)
        }
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXPaging, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXPaging
            val _cache = __ins.renderCache
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val refresherTriggered = ref(false)
            val pullingDistance = ref(0)
            val resetting = ref(false)
            val triggered = ref(false)
            val state = computed(fun(): Number {
                if (resetting.value) {
                    return 3
                }
                if (refresherTriggered.value) {
                    return 2
                }
                if (pullingDistance.value > 45) {
                    return 1
                }
                return 0
            }
            )
            val onRefresherpulling = fun(e: RefresherEvent){
                pullingDistance.value = e.detail.dy
                triggered.value = true
            }
            val onRefresherrefresh = fun(){
                refresherTriggered.value = true
                emit("refresh")
            }
            val toLower = fun(){
                emit("toLower")
            }
            val closeRefresh = fun(){
                refresherTriggered.value = false
                resetting.value = true
            }
            val onRefreshrestore = fun(){
                pullingDistance.value = 0
                resetting.value = false
            }
            __expose(_uM("closeRefresh" to closeRefresh))
            return fun(): Any? {
                val _component_x_refresh_box = resolveEasyComponent("x-refresh-box", GenComponentsXRefreshBoxClass)
                return _cE("view", _uM("style" to _nS(_uM("height" to (_ctx.height + "px")))), _uA(
                    _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1")), "refresher-enabled" to true, "refresher-triggered" to unref(refresherTriggered), "refresher-default-style" to "none", "onRefresherpulling" to onRefresherpulling, "onRefresherrefresh" to onRefresherrefresh, "onRefresherrestore" to onRefreshrestore, "refresher-max-drag-distance" to "200px", "onScrolltolower" to toLower), _uA(
                        renderSlot(_ctx.`$slots`, "default"),
                        _cV(_component_x_refresh_box, _uM("slot" to "refresher", "state" to unref(state)), null, 8, _uA(
                            "state"
                        ))
                    ), 44, _uA(
                        "refresher-triggered"
                    ))
                ), 4)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("refresh" to null, "toLower" to null)
        var props = _nP(_uM("height" to _uM("type" to "Number", "default" to 300)))
        var propsNeedCastKeys = _uA(
            "height"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
