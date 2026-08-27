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
open class GenUniModulesUniRefreshBoxComponentsUniRefreshBoxUniRefreshBox : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var pullingDistance: Number by `$props`
    open var refreshing: Boolean by `$props`
    open var threshold: Number by `$props`
    open var pullingText: String by `$props`
    open var loosingText: String by `$props`
    open var loadingText: String by `$props`
    open var completeText: String by `$props`
    open var textClass: Any? by `$props`
    open var loadingClass: Any? by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesUniRefreshBoxComponentsUniRefreshBoxUniRefreshBox, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesUniRefreshBoxComponentsUniRefreshBoxUniRefreshBox
            val _cache = __ins.renderCache
            val props = __props
            val loadingRef = ref<UniElement?>(null)
            val resetting = ref(false)
            val restoring = ref(false)
            val currentState = computed(fun(): Number {
                if (resetting.value) {
                    return 3
                }
                if (props.refreshing) {
                    return 2
                }
                if (restoring.value) {
                    return 4
                }
                if (props.pullingDistance > props.threshold) {
                    return 1
                }
                return 0
            }
            )
            val tipText = computed(fun(): String {
                when (currentState.value) {
                    0 -> 
                        return props.pullingText
                    1 -> 
                        return props.loosingText
                    2 -> 
                        return props.loadingText
                    3 -> 
                        return props.completeText
                    4 -> 
                        return ""
                    else -> 
                        return props.pullingText
                }
            }
            )
            watch(fun(): Boolean {
                return props.refreshing
            }
            , fun(newVal: Boolean, oldVal: Boolean){
                if (!newVal && oldVal) {
                    resetting.value = true
                    restoring.value = true
                    setTimeout(fun(){
                        resetting.value = false
                    }
                    , 300)
                }
            }
            )
            watch(fun(): Number {
                return props.pullingDistance
            }
            , fun(distance: Number, oldDistance: Number){
                if (distance == 0 && restoring.value) {
                    restoring.value = false
                }
                if (distance > 0 && oldDistance == 0 && !props.refreshing) {
                    restoring.value = false
                }
                val el = loadingRef.value
                if (el != null && !props.refreshing) {
                    val maxDistance: Number = 200
                    val maxRotation: Number = 540
                    val rotation = Math.min((distance / maxDistance) * maxRotation, maxRotation)
                    el.style.setProperty("transform", "rotate(" + rotation + "deg)")
                }
            }
            )
            __expose(_uM("currentState" to currentState))
            return fun(): Any? {
                val _component_loading = resolveComponent("loading")
                return _cE("view", _uM("slot" to "refresher", "class" to "uni-refresh-box-buildin"), _uA(
                    renderSlot(_ctx.`$slots`, "loading", _uM("state" to unref(currentState)), fun(): UTSArray<Any> {
                        return _uA(
                            _cV(_component_loading, _uM("ref_key" to "loadingRef", "ref" to loadingRef, "paused" to (unref(currentState) != 2), "class" to _nC(_uA(
                                "uni-loading-class-buildin",
                                _ctx.loadingClass
                            )), "bold" to ""), null, 8, _uA(
                                "paused",
                                "class"
                            ))
                        )
                    }
                    ),
                    _cE("text", _uM("class" to _nC(_uA(
                        "uni-text-class-buildin",
                        _ctx.textClass
                    ))), _tD(unref(tipText)), 3)
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
                return _uM("uni-refresh-box-buildin" to _pS(_uM("justifyContent" to "center", "alignItems" to "center", "flexDirection" to "row", "width" to "100%", "height" to 30)), "uni-loading-class-buildin" to _pS(_uM("width" to 14, "height" to 14, "borderTopColor" to "#888888", "borderRightColor" to "#888888", "borderBottomColor" to "#888888", "borderLeftColor" to "#888888")), "uni-text-class-buildin" to _pS(_uM("color" to "#888888", "fontSize" to 14, "marginLeft" to 4)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("pullingDistance" to _uM("type" to "Number", "default" to 0), "refreshing" to _uM("type" to "Boolean", "default" to false), "threshold" to _uM("type" to "Number", "default" to 45), "pullingText" to _uM("type" to "String", "default" to "下拉刷新"), "loosingText" to _uM("type" to "String", "default" to "松手刷新"), "loadingText" to _uM("type" to "String", "default" to "正在刷新"), "completeText" to _uM("type" to "String", "default" to ""), "textClass" to _uM("type" to null, "default" to "", "externalClasses" to true, "skipCheck" to true), "loadingClass" to _uM("type" to null, "default" to "", "externalClasses" to true, "skipCheck" to true)))
        var propsNeedCastKeys = _uA(
            "pullingDistance",
            "refreshing",
            "threshold",
            "pullingText",
            "loosingText",
            "loadingText",
            "completeText",
            "textClass",
            "loadingClass"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
