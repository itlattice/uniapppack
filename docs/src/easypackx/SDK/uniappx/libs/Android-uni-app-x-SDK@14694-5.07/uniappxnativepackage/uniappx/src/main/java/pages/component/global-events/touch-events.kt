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
open class GenPagesComponentGlobalEventsTouchEvents : BasePage {
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
    open var data: DataType__40
        get() {
            return unref(this.`$exposed`["data"]) as DataType__40
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentGlobalEventsTouchEvents, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentGlobalEventsTouchEvents
            val _cache = __ins.renderCache
            val move = ref(false)
            val posX = ref(0)
            val posY = ref(0)
            val lastX = ref(0)
            val lastY = ref(0)
            val touchEvent = ref(null as TouchEvent?)
            val icon = ref(null as UniElement?)
            val data = reactive(DataType__40(touchTargets = "", touchTargetsCount = 0, iconRect = null as DOMRect?))
            fun gen_onViewTouchStart_fn(e: TouchEvent) {
                data.touchTargets += e.target!!.tagName + e.currentTarget!!.tagName
                data.touchTargetsCount++
            }
            val onViewTouchStart = ::gen_onViewTouchStart_fn
            fun gen_onTouchStart_fn(e: TouchEvent) {
                data.touchTargetsCount++
                data.touchTargets += e.target!!.tagName + e.currentTarget!!.tagName
                touchEvent.value = e
                if (!move.value) {
                    move.value = true
                    posX.value = e.touches[0].screenX
                    posY.value = e.touches[0].screenY
                }
            }
            val onTouchStart = ::gen_onTouchStart_fn
            fun gen_onTouchMove_fn(e: TouchEvent) {
                e.preventDefault()
                touchEvent.value = e
                var p = e.touches[0]
                if (p.screenX == lastX.value && p.screenY == lastY.value) {
                    return
                }
                var x = p.screenX - posX.value
                var y = p.screenY - posY.value
                lastX.value = p.screenX
                lastY.value = p.screenY
                icon.value?.style?.setProperty("transform", "translate(" + x + "px," + y + "px)")
            }
            val onTouchMove = ::gen_onTouchMove_fn
            fun gen_resetIcon_fn() {
                move.value = false
                posX.value = 0
                posY.value = 0
                icon.value?.style?.setProperty("transform", "translate(0px,0px)")
            }
            val resetIcon = ::gen_resetIcon_fn
            fun gen_onTouchEnd_fn(e: TouchEvent) {
                if (e.touches.length == 0) {
                    resetIcon()
                    touchEvent.value = null
                }
            }
            val onTouchEnd = ::gen_onTouchEnd_fn
            fun gen_onTouchCancel_fn(event: TouchEvent) {
                resetIcon()
                touchEvent.value = null
            }
            val onTouchCancel = ::gen_onTouchCancel_fn
            onReady(fun(){
                icon.value = uni_getElementById("icon")
            }
            )
            __expose(_uM("data" to data))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                val _component_navigator = resolveComponent("navigator")
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cV(_component_page_head, _uM("title" to "拖拽图标测试相关事件")),
                    _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt", "style" to _nS(_uM("bottom" to "20px"))), _uA(
                        _cV(_component_navigator, _uM("url" to "/pages/component/global-events/touch-events-case", "hover-class" to "none"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("button", _uM("type" to "default"), " stopPropagation / preventDefault ")
                            )
                        }
                        ), "_" to 1))
                    ), 4),
                    _cE("view", _uM("class" to "container"), _uA(
                        _cE("view", _uM("class" to "view-box", "onTouchstart" to onViewTouchStart), _uA(
                            _cE("image", _uM("class" to "icon", "id" to "icon", "src" to default__3, "onTouchstart" to onTouchStart, "onTouchcancel" to onTouchCancel, "onTouchmove" to onTouchMove, "onTouchend" to onTouchEnd), null, 32)
                        ), 32)
                    )),
                    if (unref(touchEvent) != null) {
                        _cE("view", _uM("key" to 0), _uA(
                            _cE("text", _uM("class" to "title1"), "touches: "),
                            _cE(Fragment, null, RenderHelpers.renderList(unref(touchEvent)!!.touches, fun(touch, index, __index, _cached): Any {
                                return _cE(Fragment, _uM("key" to index), _uA(
                                    _cE("text", _uM("class" to "title2"), "touch[" + _tD(index) + "]:", 1),
                                    _cE("text", null, "identifier: " + _tD(touch.identifier), 1),
                                    _cE("text", null, "pageX: " + _tD(touch.pageX) + ", pageY: " + _tD(touch.pageY), 1),
                                    _cE("text", null, "clientX: " + _tD(touch.clientX) + ", clientY: " + _tD(touch.clientY), 1),
                                    _cE("text", null, "screenX: " + _tD(touch.screenX) + ", screenY: " + _tD(touch.screenY), 1)
                                ), 64)
                            }), 128)
                        ))
                    } else {
                        _cC("v-if", true)
                    }
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
                return _uM("container" to _pS(_uM("width" to "100%", "flexDirection" to "column", "alignItems" to "center")), "view-box" to _pS(_uM("width" to 300, "height" to 300, "alignItems" to "center", "justifyContent" to "center", "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid")), "icon" to _pS(_uM("width" to 100, "height" to 100)), "title1" to _pS(_uM("marginTop" to 10, "fontSize" to 18)), "title2" to _pS(_uM("marginTop" to 5, "fontSize" to 16)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
