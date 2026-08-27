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
open class GenPagesComponentGlobalEventsTouchEventsBubbles : BasePage {
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
    open var data: DataType__41
        get() {
            return unref(this.`$exposed`["data"]) as DataType__41
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var isPassTest1: () -> Unit
        get() {
            return unref(this.`$exposed`["isPassTest1"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "isPassTest1", value)
        }
    open var isPassTest2: () -> Unit
        get() {
            return unref(this.`$exposed`["isPassTest2"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "isPassTest2", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentGlobalEventsTouchEventsBubbles, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentGlobalEventsTouchEventsBubbles
            val _cache = __ins.renderCache
            val touchstartValue = ref(_uA<String>())
            val touchmoveValue = ref(_uA<String>())
            val touchendValue = ref(_uA<String>())
            val data = reactive(DataType__41(iconRect = null as DOMRect?, viewEleRect = null as DOMRect?, ret1 = false, ret2 = false))
            fun gen_clearValue_fn() {
                touchstartValue.value = _uA()
                touchmoveValue.value = _uA()
                touchendValue.value = _uA()
            }
            val clearValue = ::gen_clearValue_fn
            fun gen_isPassTest1_fn() {
                var touchStart = touchstartValue.value.join("")
                var touchMove = touchmoveValue.value.join("")
                var touchEnd = touchendValue.value.join("")
                console.log("touchStart: ", touchStart)
                console.log("touchMove: ", touchMove)
                console.log("touchEnd: ", touchEnd)
                var result = touchStart == "view1-3view1-2view1" && touchMove == "view1-3view1-2view1" && touchEnd == "view1-3view1-2view1"
                console.log("isPassTest1", result)
                data.ret1 = result
                clearValue()
            }
            val isPassTest1 = ::gen_isPassTest1_fn
            fun gen_isPassTest2_fn() {
                var touchStart = touchstartValue.value.join("")
                var touchMove = touchmoveValue.value.join("")
                var touchEnd = touchendValue.value.join("")
                console.log("touchStart: ", touchStart)
                console.log("touchMove: ", touchMove)
                console.log("touchEnd: ", touchEnd)
                var result = touchStart == "view2-3view2" && touchMove == "view2" && touchEnd == "view2-3view2-2view2"
                console.log("isPassTest2", result)
                data.ret2 = result
                clearValue()
            }
            val isPassTest2 = ::gen_isPassTest2_fn
            fun gen_onTouchStart_fn(e: TouchEvent) {
                var _id = e.currentTarget!!.getAttribute("id") as String
                if (!touchstartValue.value.includes(_id)) {
                    touchstartValue.value.push(_id)
                }
                console.log("onTouchStart", e.currentTarget!!.getAttribute("id"))
            }
            val onTouchStart = ::gen_onTouchStart_fn
            fun gen_onTouchMove_fn(e: TouchEvent) {
                var _id = e.currentTarget!!.getAttribute("id") as String
                if (!touchmoveValue.value.includes(_id)) {
                    touchmoveValue.value.push(_id)
                }
                console.log("onTouchMove", e.currentTarget!!.getAttribute("id"))
            }
            val onTouchMove = ::gen_onTouchMove_fn
            fun gen_onTouchEnd_fn(e: TouchEvent) {
                var _id = e.currentTarget!!.getAttribute("id") as String
                if (!touchendValue.value.includes(_id)) {
                    touchendValue.value.push(_id)
                }
            }
            val onTouchEnd = ::gen_onTouchEnd_fn
            onReady(fun(){})
            __expose(_uM("data" to data, "isPassTest1" to isPassTest1, "isPassTest2" to isPassTest2))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cV(_component_page_head, _uM("title" to "事件冒泡测试")),
                    _cE("view", _uM("class" to "container"), _uA(
                        _cE("view", _uM("class" to "view-box", "id" to "view1", "onTouchstart" to onTouchStart, "onTouchmove" to onTouchMove, "onTouchend" to onTouchEnd), _uA(
                            _cE("view", _uM("class" to "mid-view", "id" to "view1-2", "onTouchstart" to onTouchStart, "onTouchmove" to onTouchMove, "onTouchend" to onTouchEnd), _uA(
                                _cE("image", _uM("class" to "icon", "id" to "view1-3", "src" to default__3, "onTouchstart" to onTouchStart, "onTouchmove" to onTouchMove, "onTouchend" to onTouchEnd), null, 32)
                            ), 32)
                        ), 32),
                        _cE("view", _uM("class" to "view-box", "id" to "view2", "onTouchstart" to onTouchStart, "onTouchmove" to onTouchMove, "onTouchend" to onTouchEnd), _uA(
                            _cE("view", _uM("class" to "mid-view", "id" to "view2-2", "onTouchend" to onTouchEnd), _uA(
                                _cE("view", _uM("style" to _nS(_uM("background-color" to "beige")), "class" to "icon", "id" to "view2-3", "onTouchstart" to onTouchStart, "onTouchend" to onTouchEnd), null, 36)
                            ), 32)
                        ), 32)
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
                return _uM("container" to _pS(_uM("width" to "100%", "height" to "80%", "flexDirection" to "column", "alignItems" to "center", "justifyContent" to "space-between")), "view-box" to _pS(_uM("width" to 200, "height" to 200, "alignItems" to "center", "justifyContent" to "center", "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid")), "mid-view" to _pS(_uM("width" to 150, "height" to 150, "alignItems" to "center", "justifyContent" to "center", "backgroundColor" to "#00FFFF")), "icon" to _pS(_uM("width" to 100, "height" to 100)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
