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
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
open class GenPagesTemplateHalfScreenHalfScreen : BasePage {
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
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesTemplateHalfScreenHalfScreen) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesTemplateHalfScreenHalfScreen
            val _cache = __ins.renderCache
            val list = ref(_uA(
                "1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "7",
                "8",
                "9",
                "10",
                "11",
                "12",
                "13",
                "14",
                "15"
            ))
            var totalHeight: Number = 0
            var halfMove = false
            var halfScreenY: Number = 0
            var halfOffset: Number = 0
            var halfHeight: Number = 0
            var lastY: Number = 0
            var lastY2: Number = 0
            var bAnimation = false
            val pageRef = ref<UniElement?>(null)
            val halfScreenRef = ref<UniElement?>(null)
            val halfScrollRef = ref<UniScrollViewElement?>(null)
            val scrollDirection = ref("vertical")
            fun gen_onHalfTouchStart_fn(event: TouchEvent) {
                halfScreenRef.value?.style?.setProperty("transition-duration", 0)
            }
            val onHalfTouchStart = ::gen_onHalfTouchStart_fn
            fun gen_onHalfTouchMove_fn(e: TouchEvent) {
                if (bAnimation) {
                    return
                }
                var top: Number = halfScrollRef.value?.scrollTop ?: 0
                var p = e.touches[0]
                lastY2 = lastY
                lastY = p.screenY
                if (top <= 0.01 || halfMove) {
                    if (halfScreenY == 0) {
                        halfScreenY = p.screenY
                    }
                    var offset = p.screenY - halfScreenY
                    if (offset > 0) {
                        halfMove = true
                        halfScrollRef.value?.setAttribute("direction", "none")
                        halfScreenRef.value?.style?.setProperty("transform", "translateY(" + offset.toFixed(2) + "px)")
                        halfOffset = offset
                    } else if (halfOffset > 0) {
                        offset = halfScreenY - p.screenY
                        if (offset > halfOffset) {
                            offset = 0
                            halfMove = false
                        }
                        halfScrollRef.value?.setAttribute("direction", "vertical")
                        halfScreenRef.value?.style?.setProperty("transform", "translateY(" + offset.toFixed(2) + "px)")
                        halfOffset = offset
                    }
                }
            }
            val onHalfTouchMove = ::gen_onHalfTouchMove_fn
            fun gen_switchHalfScreen_fn(show: Boolean) {
                if (show && ("visible" == halfScreenRef.value?.style?.getPropertyValue("visibility"))) {
                    console.log("quick click button!!!")
                    return
                }
                halfMove = false
                halfScrollRef.value?.setAttribute("direction", "vertical")
                halfScreenY = 0
                halfOffset = 0
                var top = totalHeight
                var time: Number = 300
                if (show) {
                    top = totalHeight * 30 / 100
                    halfScreenRef.value?.style?.setProperty("visibility", "visible")
                    halfScreenRef.value?.style?.setProperty("transition-timing-function", "ease-in-out")
                } else {
                    halfScreenRef.value?.style?.setProperty("transition-timing-function", "linear")
                    time *= (halfHeight / totalHeight)
                }
                halfScreenRef.value?.style?.setProperty("transition-duration", time.toFixed(0) + "ms")
                halfScreenRef.value?.style?.setProperty("transition-property", "top")
                halfScreenRef.value?.style?.setProperty("top", top.toFixed(2) + "px")
                setTimeout(fun(){
                    if (!show) {
                        halfScreenRef.value?.style?.setProperty("visibility", "hidden")
                        halfScreenRef.value?.style?.setProperty("transition-duration", 0)
                        halfScreenRef.value?.style?.setProperty("transform", "")
                    }
                    halfScreenRef.value?.style?.setProperty("transition-property", "none")
                    bAnimation = false
                }
                , time)
                bAnimation = true
            }
            val switchHalfScreen = ::gen_switchHalfScreen_fn
            fun gen_resumeHalfScreen_fn() {
                var time: Number = 300
                halfScreenRef.value?.style?.setProperty("transition-duration", time.toFixed(0) + "ms")
                halfScreenRef.value?.style?.setProperty("transition-timing-function", "ease-in-out")
                halfScreenRef.value?.style?.setProperty("transition-property", "transform")
                halfScreenRef.value?.style?.setProperty("transform", "translateY(0px)")
                halfMove = false
                halfScrollRef.value?.setAttribute("direction", "vertical")
                halfScreenY = 0
                halfOffset = 0
                setTimeout(fun(){
                    bAnimation = false
                    halfScreenRef.value?.style?.setProperty("transition-property", "none")
                }
                , time)
                bAnimation = true
            }
            val resumeHalfScreen = ::gen_resumeHalfScreen_fn
            fun gen_onHalfTouchEnd_fn(event: TouchEvent) {
                halfScreenY = 0
                if (bAnimation) {
                    return
                }
                var top: Number = halfScrollRef.value?.scrollTop ?: 0
                var bHide = (halfHeight - halfOffset) < halfHeight / 4
                if (bHide) {
                    bHide = lastY2 > 0 && lastY2 <= lastY
                } else if (top <= 0.01) {
                    bHide = (lastY - lastY2) > 3
                }
                if (bHide) {
                    switchHalfScreen(false)
                } else if (halfOffset > 0) {
                    resumeHalfScreen()
                }
            }
            val onHalfTouchEnd = ::gen_onHalfTouchEnd_fn
            onReady(fun(){
                halfScreenRef.value!!.getBoundingClientRectAsync()!!.then(fun(rect: DOMRect){
                    halfHeight = rect.height
                }
                )
                pageRef.value!!.getBoundingClientRectAsync()!!.then(fun(rect: DOMRect){
                    totalHeight = rect.height
                    halfScreenRef.value?.style?.setProperty("top", totalHeight.toFixed(2) + "px")
                }
                )
            }
            )
            onResize(fun(_options){
                halfScreenRef.value?.getBoundingClientRectAsync()!!.then(fun(rect: DOMRect){
                    halfHeight = rect.height
                }
                )
                totalHeight = uni_getWindowInfo().windowHeight
                halfScreenRef.value?.style?.setProperty("top", totalHeight.toFixed(2) + "px")
                halfScreenRef.value?.style?.setProperty("visibility", "hidden")
            }
            )
            onBackPress(fun(_options): Boolean {
                if ("visible" == halfScreenRef.value?.style?.getPropertyValue("visibility")) {
                    switchHalfScreen(false)
                    return true
                }
                return false
            }
            )
            return fun(): Any? {
                return _cE("view", _uM("ref_key" to "pageRef", "ref" to pageRef, "class" to "page"), _uA(
                    _cE("text", _uM("class" to "tip"), "半屏弹窗，演示了弹出层内scroll-view滚动到顶时由滚变拖。本效果是通过监听TouchEvent实现，当半屏窗口移动时禁用scroll-view的滚动，避免两者的冲突。"),
                    _cE("button", _uM("class" to "bottomButton", "onClick" to fun(){
                        switchHalfScreen(true)
                    }
                    ), "打开弹窗", 8, _uA(
                        "onClick"
                    )),
                    _cE("view", _uM("ref_key" to "halfScreenRef", "ref" to halfScreenRef, "class" to "halfScreen", "onTouchstart" to onHalfTouchStart, "onTouchmove" to onHalfTouchMove, "onTouchend" to onHalfTouchEnd), _uA(
                        _cE("view", _uM("class" to "halfTitle"), "半屏弹窗标题"),
                        _cE("scroll-view", _uM("ref_key" to "halfScrollRef", "ref" to halfScrollRef, "class" to "halfScroll", "bounces" to "true", "direction" to unref(scrollDirection)), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(unref(list), fun(item, index, __index, _cached): Any {
                                return _cE("view", _uM("key" to index, "class" to "item"), " half screen content-" + _tD(item), 1)
                            }
                            ), 128)
                        ), 8, _uA(
                            "direction"
                        ))
                    ), 544)
                ), 512)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("page" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "backgroundColor" to "#A9A9A9")), "tip" to _pS(_uM("marginTop" to 10, "marginRight" to 10, "marginBottom" to 10, "marginLeft" to 10)), "bottomButton" to _pS(_uM("position" to "absolute", "width" to "100%", "bottom" to 0, "paddingBottom" to "env(safe-area-inset-bottom,0px)")), "halfScreen" to _pS(_uM("position" to "absolute", "top" to "100%", "width" to "100%", "height" to "70%", "transitionTimingFunction" to "ease-in-out", "transitionProperty" to "top", "transitionDuration" to "0ms", "visibility" to "hidden")), "halfTitle" to _pS(_uM("alignItems" to "center", "justifyContent" to "center", "height" to 48, "backgroundColor" to "#F8F8FF", "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "borderBottomRightRadius" to 0, "borderBottomLeftRadius" to 0)), "halfScroll" to _pS(_uM("backgroundColor" to "#FFFFFF", "flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "item" to _pS(_uM("height" to 100)), "@TRANSITION" to _uM("halfScreen" to _uM("timingFunction" to "ease-in-out", "property" to "top", "duration" to "0ms")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
