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
open class GenPagesComponentGlobalEventsTouchEventsCase : BasePage {
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
    open var data: DataType__42
        get() {
            return unref(this.`$exposed`["data"]) as DataType__42
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var resetEvent: () -> Unit
        get() {
            return unref(this.`$exposed`["resetEvent"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "resetEvent", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentGlobalEventsTouchEventsCase, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentGlobalEventsTouchEventsCase
            val _cache = __ins.renderCache
            val stopPropagation = ref(false)
            val preventDefault = ref(false)
            val touchResult = ref("")
            val data = reactive(DataType__42(swiperChangeEvent = false, viewTouchEvent = false, swiperItemTouchEvent = false, swiperTouchEvent = false))
            fun gen_changeStopPropagation_fn(value: Boolean) {
                stopPropagation.value = value
            }
            val changeStopPropagation = ::gen_changeStopPropagation_fn
            fun gen_changePreventDefault_fn(value: Boolean) {
                preventDefault.value = value
            }
            val changePreventDefault = ::gen_changePreventDefault_fn
            fun gen_swiperChange_fn(e: UniSwiperChangeEvent) {
                console.log("swiperChange", e.detail.current)
                data.swiperChangeEvent = true
            }
            val swiperChange = ::gen_swiperChange_fn
            fun gen_viewTouchStart_fn(e: UniTouchEvent) {
                console.log("viewTouchStart")
                touchResult.value = "viewTouchStart"
                data.viewTouchEvent = true
                if (stopPropagation.value) {
                    e.stopPropagation()
                }
                if (preventDefault.value) {
                    e.preventDefault()
                }
            }
            val viewTouchStart = ::gen_viewTouchStart_fn
            fun gen_viewTouchMove_fn(e: UniTouchEvent) {
                console.log("viewTouchMove")
                touchResult.value = "viewTouchMove"
                data.viewTouchEvent = true
                if (stopPropagation.value) {
                    e.stopPropagation()
                }
                if (preventDefault.value) {
                    e.preventDefault()
                }
            }
            val viewTouchMove = ::gen_viewTouchMove_fn
            fun gen_viewTouchEnd_fn(e: UniTouchEvent) {
                console.log("viewTouchEnd")
                touchResult.value = "viewTouchEnd"
                if (stopPropagation.value) {
                    e.stopPropagation()
                }
            }
            val viewTouchEnd = ::gen_viewTouchEnd_fn
            fun gen_swiperItemTouchStart_fn(e: UniTouchEvent) {
                console.log("swiperItemTouchStart")
                touchResult.value += " -> swiperItemTouchStart"
                data.swiperItemTouchEvent = true
            }
            val swiperItemTouchStart = ::gen_swiperItemTouchStart_fn
            fun gen_swiperItemTouchMove_fn(e: UniTouchEvent) {
                console.log("swiperItemTouchMove")
                touchResult.value += " -> swiperItemTouchMove"
            }
            val swiperItemTouchMove = ::gen_swiperItemTouchMove_fn
            fun gen_swiperItemTouchEnd_fn(e: UniTouchEvent) {
                console.log("swiperItemTouchEnd")
                touchResult.value += " -> swiperItemTouchEnd"
            }
            val swiperItemTouchEnd = ::gen_swiperItemTouchEnd_fn
            fun gen_swiperTouchStart_fn(e: UniTouchEvent) {
                console.log("swiperTouchStart")
                touchResult.value += " -> swiperTouchStart"
                data.swiperTouchEvent = true
            }
            val swiperTouchStart = ::gen_swiperTouchStart_fn
            fun gen_swiperTouchMove_fn(e: UniTouchEvent) {
                console.log("swiperTouchMove")
                touchResult.value += " -> swiperTouchMove"
            }
            val swiperTouchMove = ::gen_swiperTouchMove_fn
            fun gen_swiperTouchEnd_fn(e: UniTouchEvent) {
                console.log("swiperTouchEnd")
                touchResult.value += " -> swiperTouchEnd"
            }
            val swiperTouchEnd = ::gen_swiperTouchEnd_fn
            fun gen_resetEvent_fn() {
                data.swiperChangeEvent = false
                data.viewTouchEvent = false
                data.swiperItemTouchEvent = false
                data.swiperTouchEvent = false
                stopPropagation.value = true
                preventDefault.value = true
            }
            val resetEvent = ::gen_resetEvent_fn
            fun gen_isPassTest1_fn(): Boolean {
                console.log("swiperChangeEvent:", data.swiperChangeEvent)
                return data.swiperChangeEvent == false
            }
            val isPassTest1 = ::gen_isPassTest1_fn
            fun gen_isPassTest2_fn(): Boolean {
                console.log("viewTouchEvent:", data.viewTouchEvent)
                console.log("swiperItemTouchEvent:", data.swiperItemTouchEvent)
                console.log("swiperTouchEvent:", data.swiperTouchEvent)
                return data.viewTouchEvent == true && data.swiperItemTouchEvent == true && data.swiperTouchEvent == true
            }
            val isPassTest2 = ::gen_isPassTest2_fn
            __expose(_uM("data" to data, "resetEvent" to resetEvent))
            return fun(): Any? {
                val _component_boolean_data = resolveEasyComponent("boolean-data", GenComponentsBooleanDataBooleanDataClass)
                val _component_navigator = resolveComponent("navigator")
                return _cE("view", null, _uA(
                    _cE("swiper", _uM("ref" to "header", "class" to "h-300", "indicator-dots" to "true", "circular" to "true", "onChange" to swiperChange, "onTouchstart" to swiperTouchStart, "onTouchmove" to swiperTouchMove, "onTouchend" to swiperTouchEnd), _uA(
                        _cE(Fragment, null, RenderHelpers.renderList(3, fun(i, __key, __index, _cached): Any {
                            return _cE("swiper-item", _uM("item-id" to i, "onTouchstart" to swiperItemTouchStart, "onTouchmove" to swiperItemTouchMove, "onTouchend" to swiperItemTouchEnd), _uA(
                                _cE("view", _uM("class" to "h-300 header-tiem", "onTouchstart" to viewTouchStart, "onTouchmove" to viewTouchMove, "onTouchend" to viewTouchEnd), _uA(
                                    _cE("text", null, _tD(i), 1)
                                ), 32)
                            ), 40, _uA(
                                "item-id"
                            ))
                        }
                        ), 64)
                    ), 544),
                    _cE("view", _uM("class" to "content"), _uA(
                        _cV(_component_boolean_data, _uM("defaultValue" to false, "title" to "stopPropagation", "onChange" to changeStopPropagation)),
                        _cV(_component_boolean_data, _uM("defaultValue" to false, "title" to "preventDefault", "onChange" to changePreventDefault)),
                        _cE("text", _uM("style" to _nS(_uM("padding" to "10px"))), _tD(unref(touchResult)), 5),
                        _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt", "style" to _nS(_uM("bottom" to "20px"))), _uA(
                            _cV(_component_navigator, _uM("url" to "/pages/component/global-events/touch-events-preventDefault", "hover-class" to "none"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("button", _uM("type" to "default", "class" to "button"), " 测试 preventDefault ")
                                )
                            }
                            ), "_" to 1))
                        ), 4)
                    ))
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
                return _uM("h-300" to _pS(_uM("height" to 300)), "header-tiem" to _pS(_uM("backgroundColor" to "#89ff8d", "alignItems" to "center", "justifyContent" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
