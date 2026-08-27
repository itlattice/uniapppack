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
open class GenPagesComponentGlobalEventsGlobalEvents : BasePage {
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
    open var clearAllEvents: () -> Unit
        get() {
            return unref(this.`$exposed`["clearAllEvents"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "clearAllEvents", value)
        }
    open var longPressTargetRect: Rect
        get() {
            return unref(this.`$exposed`["longPressTargetRect"]) as Rect
        }
        set(value) {
            setRefValue(this.`$exposed`, "longPressTargetRect", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentGlobalEventsGlobalEvents, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentGlobalEventsGlobalEvents
            val _cache = __ins.renderCache
            val title = ref("global-events")
            val touchStartEvent = ref<TouchEvent?>(null)
            val touchCancelEvent = ref<TouchEvent?>(null)
            val touchMoveEvent = ref<TouchEvent?>(null)
            val longPressEvent = ref<TouchEvent?>(null)
            val touchEndEvent = ref<TouchEvent?>(null)
            val tapEvent = ref<PointerEvent?>(null)
            val clickEvent = ref<PointerEvent?>(null)
            val longPressTargetRect = reactive<Rect>(Rect(x = 0, y = 0, width = 0, height = 0))
            onReady(fun(){
                val longpressTarget = uni_getElementById("longpress-target")!!
                val rect = longpressTarget.getBoundingClientRect()
                longPressTargetRect.x = rect.x
                longPressTargetRect.y = rect.y
                longPressTargetRect.width = rect.width
                longPressTargetRect.height = rect.height
            }
            )
            val onTouchStart = fun(e: TouchEvent){
                touchStartEvent.value = e
                console.log("onTouchStart", e)
            }
            val onTouchCancel = fun(e: TouchEvent){
                touchCancelEvent.value = e
                console.log("onTouchCancel")
            }
            val onTouchMove = fun(e: TouchEvent){
                touchMoveEvent.value = e
                console.log("onTouchMove", e)
            }
            val onLongPress = fun(e: TouchEvent){
                longPressEvent.value = e
                console.log("onLongPress", e)
            }
            val onTouchEnd = fun(e: TouchEvent){
                touchEndEvent.value = e
                console.log("onTouchEnd", e)
            }
            val onTap = fun(e: PointerEvent){
                tapEvent.value = e
                longPressEvent.value = null
                console.log("onTap", e)
            }
            val onClick = fun(e: PointerEvent){
                clickEvent.value = e
                longPressEvent.value = null
                console.log("onClick", e)
            }
            val clearAllEvents = fun(){
                touchStartEvent.value = null
                touchCancelEvent.value = null
                touchMoveEvent.value = null
                longPressEvent.value = null
                touchEndEvent.value = null
                tapEvent.value = null
                clickEvent.value = null
            }
            __expose(_uM("clearAllEvents" to clearAllEvents, "longPressTargetRect" to longPressTargetRect))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                val _component_page_intro = resolveEasyComponent("page-intro", GenComponentsPageIntroPageIntroClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cV(_component_page_head, _uM("title" to "组件全局事件示例")),
                    _cV(_component_page_intro, _uM("content" to "本页演示组件全局事件：触摸区域展示 touchstart/touchmove/touchend/touchcancel，点击区域展示 tap/click/longpress，并显示事件详情与清除；可跳转冒泡、阻止默认、transform 等子示例。")),
                    _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt container"), _uA(
                        _cE("view", _uM("class" to "section"), _uA(
                            _cE("text", _uM("class" to "section-title"), "触摸事件区域：touchstart/touchmove/touchend/touchcancel"),
                            _cE("text", _uM("class" to "section-desc"), "在下方蓝色区域滑动查看触摸事件详情"),
                            _cE("view", _uM("class" to "target touch-area", "id" to "touch-target", "onTouchstart" to onTouchStart, "onTouchcancel" to onTouchCancel, "onTouchmove" to onTouchMove, "onTouchend" to onTouchEnd), _uA(
                                _cE("text", _uM("class" to "target-text"), "在此区域滑动")
                            ), 32)
                        )),
                        _cE("view", _uM("class" to "section"), _uA(
                            _cE("text", _uM("class" to "section-title"), "点击/长按事件区域：tap/click/longpress"),
                            _cE("text", _uM("class" to "section-desc"), "点击或长按下方绿色区域查看事件详情"),
                            _cE("view", _uM("class" to "target click-area", "id" to "longpress-target", "onClick" to _uA<Any?>(onTap, onClick), "onLongpress" to onLongPress), _uA(
                                _cE("text", _uM("class" to "target-text"), "点击或长按")
                            ), 32)
                        )),
                        if (isTrue(unref(touchStartEvent) != null || unref(touchMoveEvent) != null || unref(touchEndEvent) != null || unref(touchCancelEvent) != null || unref(tapEvent) != null || unref(clickEvent) != null || unref(longPressEvent) != null)) {
                            _cE("view", _uM("key" to 0, "class" to "section"), _uA(
                                _cE("view", _uM("class" to "clear-btn-wrapper"), _uA(
                                    _cE("button", _uM("class" to "clear-btn", "onClick" to clearAllEvents), "清除所有事件")
                                ))
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        if (unref(touchStartEvent) != null) {
                            _cE("view", _uM("key" to 1, "class" to "event-detail"), _uA(
                                _cE("text", _uM("class" to "event-title"), "touchStart Event（触摸开始事件）"),
                                _cE("view", _uM("class" to "event-base-info"), _uA(
                                    _cE("text", _uM("class" to "info-title"), "UniEvent 基础属性:"),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.type (事件类型):"),
                                        _cE("text", _uM("class" to "info-value"), _tD(unref(touchStartEvent)!!.type), 1)
                                    )),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.bubbles (是否冒泡):"),
                                        _cE("text", _uM("class" to "info-value"), _tD(unref(touchStartEvent)!!.bubbles), 1)
                                    )),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.cancelable (是否可取消):"),
                                        _cE("text", _uM("class" to "info-value"), _tD(unref(touchStartEvent)!!.cancelable), 1)
                                    )),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.timeStamp (时间戳):"),
                                        _cE("text", _uM("class" to "info-value"), _tD(unref(touchStartEvent)!!.timeStamp), 1)
                                    ))
                                )),
                                _cE("text", _uM("class" to "touches-title"), "event.touches (当前所有触摸点):"),
                                _cE(Fragment, null, RenderHelpers.renderList(unref(touchStartEvent)!!.touches, fun(touch, index, __index, _cached): Any {
                                    return _cE("view", _uM("key" to index, "class" to "touch-item"), _uA(
                                        _cE("text", _uM("class" to "touch-index"), "event.touches[" + _tD(index) + "]:", 1),
                                        _cE("view", _uM("class" to "touch-props"), _uA(
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .identifier (触摸点标识符):"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-start-touch-identifier"), _tD(touch.identifier), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .pageX (相对于页面左边,含滚动):"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-start-touch-page-x"), _tD(touch.pageX), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .pageY (相对于页面顶部,含滚动):"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-start-touch-page-y"), _tD(touch.pageY), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .clientX (相对于可视区域左边):"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-start-touch-client-x"), _tD(touch.clientX), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .clientY (相对于可视区域顶部):"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-start-touch-client-y"), _tD(touch.clientY), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .screenX (相对于屏幕左边,不含滚动):"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-start-touch-screen-x"), _tD(touch.screenX), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .screenY (相对于屏幕顶部,不含滚动):"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-start-touch-screen-y"), _tD(touch.screenY), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .force (触摸点的压力大小):"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-start-touch-force"), _tD(touch.force), 1)
                                            ))
                                        ))
                                    ))
                                }), 128),
                                _cE("text", _uM("class" to "touches-title"), "event.changedTouches (变化的触摸点):"),
                                _cE(Fragment, null, RenderHelpers.renderList(unref(touchStartEvent)!!.changedTouches, fun(touch, index, __index, _cached): Any {
                                    return _cE("view", _uM("key" to index, "class" to "touch-item"), _uA(
                                        _cE("text", _uM("class" to "touch-index"), "event.changedTouches[" + _tD(index) + "]:", 1),
                                        _cE("view", _uM("class" to "touch-props"), _uA(
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .identifier:"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-start-changed-touch-identifier"), _tD(touch.identifier), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .pageX:"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-start-changed-touch-page-x"), _tD(touch.pageX), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .pageY:"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-start-changed-touch-page-y"), _tD(touch.pageY), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .clientX:"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-start-changed-touch-client-x"), _tD(touch.clientX), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .clientY:"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-start-changed-touch-client-y"), _tD(touch.clientY), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .screenX:"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-start-changed-touch-screen-x"), _tD(touch.screenX), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .screenY:"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-start-changed-touch-screen-y"), _tD(touch.screenY), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .force:"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-start-changed-touch-force"), _tD(touch.force), 1)
                                            ))
                                        ))
                                    ))
                                }), 128)
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        if (unref(touchCancelEvent) != null) {
                            _cE("view", _uM("key" to 2, "class" to "event-detail"), _uA(
                                _cE("text", _uM("class" to "event-title"), "touchCancel Event（触摸取消事件）"),
                                _cE("view", _uM("class" to "event-base-info"), _uA(
                                    _cE("text", _uM("class" to "info-title"), "UniEvent 基础属性:"),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.type (事件类型):"),
                                        _cE("text", _uM("class" to "info-value"), _tD(unref(touchCancelEvent)!!.type), 1)
                                    )),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.bubbles (是否冒泡):"),
                                        _cE("text", _uM("class" to "info-value"), _tD(unref(touchCancelEvent)!!.bubbles), 1)
                                    )),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.cancelable (是否可取消):"),
                                        _cE("text", _uM("class" to "info-value"), _tD(unref(touchCancelEvent)!!.cancelable), 1)
                                    )),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.timeStamp (时间戳):"),
                                        _cE("text", _uM("class" to "info-value"), _tD(unref(touchCancelEvent)!!.timeStamp), 1)
                                    ))
                                )),
                                _cE("text", _uM("class" to "touches-title"), "event.touches (当前所有触摸点):"),
                                _cE(Fragment, null, RenderHelpers.renderList(unref(touchCancelEvent)!!.touches, fun(touch, index, __index, _cached): Any {
                                    return _cE("view", _uM("key" to index, "class" to "touch-item"), _uA(
                                        _cE("text", _uM("class" to "touch-index"), "event.touches[" + _tD(index) + "]:", 1),
                                        _cE("view", _uM("class" to "touch-props"), _uA(
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .identifier (触摸点标识符):"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-cancel-touch-identifier"), _tD(touch.identifier), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .pageX (相对于页面左边,含滚动):"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-cancel-touch-page-x"), _tD(touch.pageX), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .pageY (相对于页面顶部,含滚动):"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-cancel-touch-page-y"), _tD(touch.pageY), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .clientX (相对于可视区域左边):"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-cancel-touch-client-x"), _tD(touch.clientX), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .clientY (相对于可视区域顶部):"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-cancel-touch-client-y"), _tD(touch.clientY), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .screenX (相对于屏幕左边,不含滚动):"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-cancel-touch-screen-x"), _tD(touch.screenX), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .screenY (相对于屏幕顶部,不含滚动):"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-cancel-touch-screen-y"), _tD(touch.screenY), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .force (触摸点的压力大小):"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-cancel-touch-force"), _tD(touch.force), 1)
                                            ))
                                        ))
                                    ))
                                }), 128),
                                _cE("text", _uM("class" to "touches-title"), "event.changedTouches (变化的触摸点):"),
                                _cE(Fragment, null, RenderHelpers.renderList(unref(touchCancelEvent)!!.changedTouches, fun(touch, index, __index, _cached): Any {
                                    return _cE("view", _uM("key" to index, "class" to "touch-item"), _uA(
                                        _cE("text", _uM("class" to "touch-index"), "event.changedTouches[" + _tD(index) + "]:", 1),
                                        _cE("view", _uM("class" to "touch-props"), _uA(
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .identifier:"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-cancel-changed-touch-identifier"), _tD(touch.identifier), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .pageX:"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-cancel-changed-touch-page-x"), _tD(touch.pageX), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .pageY:"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-cancel-changed-touch-page-y"), _tD(touch.pageY), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .clientX:"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-cancel-changed-touch-client-x"), _tD(touch.clientX), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .clientY:"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-cancel-changed-touch-client-y"), _tD(touch.clientY), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .screenX:"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-cancel-changed-touch-screen-x"), _tD(touch.screenX), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .screenY:"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-cancel-changed-touch-screen-y"), _tD(touch.screenY), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .force:"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-cancel-changed-touch-force"), _tD(touch.force), 1)
                                            ))
                                        ))
                                    ))
                                }), 128)
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        if (unref(touchMoveEvent) != null) {
                            _cE("view", _uM("key" to 3, "class" to "event-detail"), _uA(
                                _cE("text", _uM("class" to "event-title"), "touchMove Event（触摸移动事件）"),
                                _cE("view", _uM("class" to "event-base-info"), _uA(
                                    _cE("text", _uM("class" to "info-title"), "UniEvent 基础属性:"),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.type (事件类型):"),
                                        _cE("text", _uM("class" to "info-value"), _tD(unref(touchMoveEvent)!!.type), 1)
                                    )),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.bubbles (是否冒泡):"),
                                        _cE("text", _uM("class" to "info-value"), _tD(unref(touchMoveEvent)!!.bubbles), 1)
                                    )),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.cancelable (是否可取消):"),
                                        _cE("text", _uM("class" to "info-value"), _tD(unref(touchMoveEvent)!!.cancelable), 1)
                                    )),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.timeStamp (时间戳):"),
                                        _cE("text", _uM("class" to "info-value"), _tD(unref(touchMoveEvent)!!.timeStamp), 1)
                                    ))
                                )),
                                _cE("text", _uM("class" to "touches-title"), "event.touches (当前所有触摸点):"),
                                _cE(Fragment, null, RenderHelpers.renderList(unref(touchMoveEvent)!!.touches, fun(touch, index, __index, _cached): Any {
                                    return _cE("view", _uM("key" to index, "class" to "touch-item"), _uA(
                                        _cE("text", _uM("class" to "touch-index"), "event.touches[" + _tD(index) + "]:", 1),
                                        _cE("view", _uM("class" to "touch-props"), _uA(
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .identifier (触摸点标识符):"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-move-touch-identifier"), _tD(touch.identifier), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .pageX (相对于页面左边,含滚动):"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-move-touch-page-x"), _tD(touch.pageX), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .pageY (相对于页面顶部,含滚动):"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-move-touch-page-y"), _tD(touch.pageY), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .clientX (相对于可视区域左边):"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-move-touch-client-x"), _tD(touch.clientX), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .clientY (相对于可视区域顶部):"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-move-touch-client-y"), _tD(touch.clientY), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .screenX (相对于屏幕左边,不含滚动):"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-move-touch-screen-x"), _tD(touch.screenX), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .screenY (相对于屏幕顶部,不含滚动):"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-move-touch-screen-y"), _tD(touch.screenY), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .force (触摸点的压力大小):"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-move-touch-force"), _tD(touch.force), 1)
                                            ))
                                        ))
                                    ))
                                }), 128),
                                _cE("text", _uM("class" to "touches-title"), "event.changedTouches (变化的触摸点):"),
                                _cE(Fragment, null, RenderHelpers.renderList(unref(touchMoveEvent)!!.changedTouches, fun(touch, index, __index, _cached): Any {
                                    return _cE("view", _uM("key" to index, "class" to "touch-item"), _uA(
                                        _cE("text", _uM("class" to "touch-index"), "event.changedTouches[" + _tD(index) + "]:", 1),
                                        _cE("view", _uM("class" to "touch-props"), _uA(
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .identifier:"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-move-changed-touch-identifier"), _tD(touch.identifier), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .pageX:"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-move-changed-touch-page-x"), _tD(touch.pageX), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .pageY:"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-move-changed-touch-page-y"), _tD(touch.pageY), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .clientX:"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-move-changed-touch-client-x"), _tD(touch.clientX), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .clientY:"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-move-changed-touch-client-y"), _tD(touch.clientY), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .screenX:"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-move-changed-touch-screen-x"), _tD(touch.screenX), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .screenY:"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-move-changed-touch-screen-y"), _tD(touch.screenY), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .force:"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-move-changed-touch-force"), _tD(touch.force), 1)
                                            ))
                                        ))
                                    ))
                                }), 128)
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        if (unref(touchEndEvent) != null) {
                            _cE("view", _uM("key" to 4, "class" to "event-detail"), _uA(
                                _cE("text", _uM("class" to "event-title"), "touchEnd Event（触摸结束事件）"),
                                _cE("view", _uM("class" to "event-base-info"), _uA(
                                    _cE("text", _uM("class" to "info-title"), "UniEvent 基础属性:"),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.type (事件类型):"),
                                        _cE("text", _uM("class" to "info-value"), _tD(unref(touchEndEvent)!!.type), 1)
                                    )),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.bubbles (是否冒泡):"),
                                        _cE("text", _uM("class" to "info-value"), _tD(unref(touchEndEvent)!!.bubbles), 1)
                                    )),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.cancelable (是否可取消):"),
                                        _cE("text", _uM("class" to "info-value"), _tD(unref(touchEndEvent)!!.cancelable), 1)
                                    )),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.timeStamp (时间戳):"),
                                        _cE("text", _uM("class" to "info-value"), _tD(unref(touchEndEvent)!!.timeStamp), 1)
                                    ))
                                )),
                                _cE("text", _uM("class" to "touches-title"), "event.touches (当前所有触摸点):"),
                                _cE(Fragment, null, RenderHelpers.renderList(unref(touchEndEvent)!!.touches, fun(touch, index, __index, _cached): Any {
                                    return _cE("view", _uM("key" to index, "class" to "touch-item"), _uA(
                                        _cE("text", _uM("class" to "touch-index"), "event.touches[" + _tD(index) + "]:", 1),
                                        _cE("view", _uM("class" to "touch-props"), _uA(
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .identifier (触摸点标识符):"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-end-touch-identifier"), _tD(touch.identifier), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .pageX (相对于页面左边,含滚动):"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-end-touch-page-x"), _tD(touch.pageX), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .pageY (相对于页面顶部,含滚动):"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-end-touch-page-y"), _tD(touch.pageY), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .clientX (相对于可视区域左边):"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-end-touch-client-x"), _tD(touch.clientX), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .clientY (相对于可视区域顶部):"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-end-touch-client-y"), _tD(touch.clientY), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .screenX (相对于屏幕左边,不含滚动):"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-end-touch-screen-x"), _tD(touch.screenX), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .screenY (相对于屏幕顶部,不含滚动):"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-end-touch-screen-y"), _tD(touch.screenY), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .force (触摸点的压力大小):"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-end-touch-force"), _tD(touch.force), 1)
                                            ))
                                        ))
                                    ))
                                }), 128),
                                _cE("text", _uM("class" to "touches-title"), "event.changedTouches (变化的触摸点):"),
                                _cE(Fragment, null, RenderHelpers.renderList(unref(touchEndEvent)!!.changedTouches, fun(touch, index, __index, _cached): Any {
                                    return _cE("view", _uM("key" to index, "class" to "touch-item"), _uA(
                                        _cE("text", _uM("class" to "touch-index"), "event.changedTouches[" + _tD(index) + "]:", 1),
                                        _cE("view", _uM("class" to "touch-props"), _uA(
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .identifier:"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-end-changed-touch-identifier"), _tD(touch.identifier), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .pageX:"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-end-changed-touch-page-x"), _tD(touch.pageX), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .pageY:"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-end-changed-touch-page-y"), _tD(touch.pageY), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .clientX:"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-end-changed-touch-client-x"), _tD(touch.clientX), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .clientY:"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-end-changed-touch-client-y"), _tD(touch.clientY), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .screenX:"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-end-changed-touch-screen-x"), _tD(touch.screenX), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .screenY:"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-end-changed-touch-screen-y"), _tD(touch.screenY), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .force:"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "touch-end-changed-touch-force"), _tD(touch.force), 1)
                                            ))
                                        ))
                                    ))
                                }), 128)
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        if (unref(longPressEvent) != null) {
                            _cE("view", _uM("key" to 5, "class" to "event-detail"), _uA(
                                _cE("text", _uM("class" to "event-title"), "longPress Event（长按事件）"),
                                _cE("view", _uM("class" to "event-base-info"), _uA(
                                    _cE("text", _uM("class" to "info-title"), "UniEvent 基础属性:"),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.type (事件类型):"),
                                        _cE("text", _uM("class" to "info-value"), _tD(unref(longPressEvent)!!.type), 1)
                                    )),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.bubbles (是否冒泡):"),
                                        _cE("text", _uM("class" to "info-value"), _tD(unref(longPressEvent)!!.bubbles), 1)
                                    )),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.cancelable (是否可取消):"),
                                        _cE("text", _uM("class" to "info-value"), _tD(unref(longPressEvent)!!.cancelable), 1)
                                    )),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.timeStamp (时间戳):"),
                                        _cE("text", _uM("class" to "info-value"), _tD(unref(longPressEvent)!!.timeStamp), 1)
                                    ))
                                )),
                                _cE("text", _uM("class" to "touches-title"), "event.touches (当前所有触摸点):"),
                                _cE(Fragment, null, RenderHelpers.renderList(unref(longPressEvent)!!.touches, fun(touch, index, __index, _cached): Any {
                                    return _cE("view", _uM("key" to index, "class" to "touch-item"), _uA(
                                        _cE("text", _uM("class" to "touch-index"), "event.touches[" + _tD(index) + "]:", 1),
                                        _cE("view", _uM("class" to "touch-props"), _uA(
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .identifier (触摸点标识符):"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "long-press-touch-identifier"), _tD(touch.identifier), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .pageX (相对于页面左边,含滚动):"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "long-press-touch-page-x"), _tD(touch.pageX), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .pageY (相对于页面顶部,含滚动):"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "long-press-touch-page-y"), _tD(touch.pageY), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .clientX (相对于可视区域左边):"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "long-press-touch-client-x"), _tD(touch.clientX), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .clientY (相对于可视区域顶部):"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "long-press-touch-client-y"), _tD(touch.clientY), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .screenX (相对于屏幕左边,不含滚动):"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "long-press-touch-screen-x"), _tD(touch.screenX), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .screenY (相对于屏幕顶部,不含滚动):"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "long-press-touch-screen-y"), _tD(touch.screenY), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .force (触摸点的压力大小):"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "long-press-touch-force"), _tD(touch.force), 1)
                                            ))
                                        ))
                                    ))
                                }), 128),
                                _cE("text", _uM("class" to "touches-title"), "event.changedTouches (变化的触摸点):"),
                                _cE(Fragment, null, RenderHelpers.renderList(unref(longPressEvent)!!.changedTouches, fun(touch, index, __index, _cached): Any {
                                    return _cE("view", _uM("key" to index, "class" to "touch-item"), _uA(
                                        _cE("text", _uM("class" to "touch-index"), "event.changedTouches[" + _tD(index) + "]:", 1),
                                        _cE("view", _uM("class" to "touch-props"), _uA(
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .identifier:"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "long-press-changed-touch-identifier"), _tD(touch.identifier), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .pageX:"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "long-press-changed-touch-page-x"), _tD(touch.pageX), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .pageY:"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "long-press-changed-touch-page-y"), _tD(touch.pageY), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .clientX:"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "long-press-changed-touch-client-x"), _tD(touch.clientX), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .clientY:"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "long-press-changed-touch-client-y"), _tD(touch.clientY), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .screenX:"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "long-press-changed-touch-screen-x"), _tD(touch.screenX), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .screenY:"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "long-press-changed-touch-screen-y"), _tD(touch.screenY), 1)
                                            )),
                                            _cE("view", _uM("class" to "prop-row"), _uA(
                                                _cE("text", _uM("class" to "prop-label"), " .force:"),
                                                _cE("text", _uM("class" to "prop-value", "id" to "long-press-changed-touch-force"), _tD(touch.force), 1)
                                            ))
                                        ))
                                    ))
                                }), 128)
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        if (unref(tapEvent) != null) {
                            _cE("view", _uM("key" to 6, "class" to "event-detail"), _uA(
                                _cE("text", _uM("class" to "event-title"), "tap Event（点击事件）"),
                                _cE("view", _uM("class" to "event-base-info"), _uA(
                                    _cE("text", _uM("class" to "info-title"), "UniEvent 基础属性:"),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.type (事件类型):"),
                                        _cE("text", _uM("class" to "info-value"), _tD(unref(tapEvent)!!.type), 1)
                                    )),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.bubbles (是否冒泡):"),
                                        _cE("text", _uM("class" to "info-value"), _tD(unref(tapEvent)!!.bubbles), 1)
                                    )),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.cancelable (是否可取消):"),
                                        _cE("text", _uM("class" to "info-value"), _tD(unref(tapEvent)!!.cancelable), 1)
                                    )),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.timeStamp (时间戳):"),
                                        _cE("text", _uM("class" to "info-value"), _tD(unref(tapEvent)!!.timeStamp), 1)
                                    ))
                                )),
                                _cE("view", _uM("class" to "event-base-info"), _uA(
                                    _cE("text", _uM("class" to "info-title"), "PointerEvent 位置信息:"),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.x (同clientX):"),
                                        _cE("text", _uM("class" to "info-value", "id" to "tap-event-x"), _tD(unref(tapEvent)!!.x), 1)
                                    )),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.y (同clientY):"),
                                        _cE("text", _uM("class" to "info-value", "id" to "tap-event-y"), _tD(unref(tapEvent)!!.y), 1)
                                    )),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.clientX (相对于可视区域左边):"),
                                        _cE("text", _uM("class" to "info-value"), _tD(unref(tapEvent)!!.clientX), 1)
                                    )),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.clientY (相对于可视区域顶部):"),
                                        _cE("text", _uM("class" to "info-value"), _tD(unref(tapEvent)!!.clientY), 1)
                                    )),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.pageX (相对于页面左边,含滚动):"),
                                        _cE("text", _uM("class" to "info-value"), _tD(unref(tapEvent)!!.pageX), 1)
                                    )),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.pageY (相对于页面顶部,含滚动):"),
                                        _cE("text", _uM("class" to "info-value"), _tD(unref(tapEvent)!!.pageY), 1)
                                    )),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.screenX (相对于屏幕左边,不含滚动):"),
                                        _cE("text", _uM("class" to "info-value"), _tD(unref(tapEvent)!!.screenX), 1)
                                    )),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.screenY (相对于屏幕顶部,不含滚动):"),
                                        _cE("text", _uM("class" to "info-value"), _tD(unref(tapEvent)!!.screenY), 1)
                                    ))
                                ))
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        if (unref(clickEvent) != null) {
                            _cE("view", _uM("key" to 7, "class" to "event-detail"), _uA(
                                _cE("text", _uM("class" to "event-title"), "click Event（点击事件）"),
                                _cE("view", _uM("class" to "event-base-info"), _uA(
                                    _cE("text", _uM("class" to "info-title"), "UniEvent 基础属性:"),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.type (事件类型):"),
                                        _cE("text", _uM("class" to "info-value"), _tD(unref(clickEvent)!!.type), 1)
                                    )),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.bubbles (是否冒泡):"),
                                        _cE("text", _uM("class" to "info-value"), _tD(unref(clickEvent)!!.bubbles), 1)
                                    )),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.cancelable (是否可取消):"),
                                        _cE("text", _uM("class" to "info-value"), _tD(unref(clickEvent)!!.cancelable), 1)
                                    )),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.timeStamp (时间戳):"),
                                        _cE("text", _uM("class" to "info-value"), _tD(unref(clickEvent)!!.timeStamp), 1)
                                    ))
                                )),
                                _cE("view", _uM("class" to "event-base-info"), _uA(
                                    _cE("text", _uM("class" to "info-title"), "PointerEvent 位置信息:"),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.x (同clientX):"),
                                        _cE("text", _uM("class" to "info-value", "id" to "click-event-x"), _tD(unref(clickEvent)!!.x), 1)
                                    )),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.y (同clientY):"),
                                        _cE("text", _uM("class" to "info-value", "id" to "click-event-y"), _tD(unref(clickEvent)!!.y), 1)
                                    )),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.clientX (相对于可视区域左边):"),
                                        _cE("text", _uM("class" to "info-value"), _tD(unref(clickEvent)!!.clientX), 1)
                                    )),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.clientY (相对于可视区域顶部):"),
                                        _cE("text", _uM("class" to "info-value"), _tD(unref(clickEvent)!!.clientY), 1)
                                    )),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.pageX (相对于页面左边,含滚动):"),
                                        _cE("text", _uM("class" to "info-value"), _tD(unref(clickEvent)!!.pageX), 1)
                                    )),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.pageY (相对于页面顶部,含滚动):"),
                                        _cE("text", _uM("class" to "info-value"), _tD(unref(clickEvent)!!.pageY), 1)
                                    )),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.screenX (相对于屏幕左边,不含滚动):"),
                                        _cE("text", _uM("class" to "info-value"), _tD(unref(clickEvent)!!.screenX), 1)
                                    )),
                                    _cE("view", _uM("class" to "info-row"), _uA(
                                        _cE("text", _uM("class" to "info-label"), "event.screenY (相对于屏幕顶部,不含滚动):"),
                                        _cE("text", _uM("class" to "info-value"), _tD(unref(clickEvent)!!.screenY), 1)
                                    ))
                                ))
                            ))
                        } else {
                            _cC("v-if", true)
                        }
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
                return _uM("container" to _pS(_uM("paddingBottom" to 10)), "section" to _pS(_uM("marginBottom" to 20)), "section-title" to _pS(_uM("fontSize" to 16, "fontWeight" to "bold", "color" to "#333333", "marginBottom" to 8)), "section-desc" to _pS(_uM("fontSize" to 14, "color" to "#666666", "marginBottom" to 10)), "target" to _pS(_uM("width" to "100%", "height" to "200rpx", "borderTopLeftRadius" to "10rpx", "borderTopRightRadius" to "10rpx", "borderBottomRightRadius" to "10rpx", "borderBottomLeftRadius" to "10rpx", "display" to "flex", "alignItems" to "center", "justifyContent" to "center")), "touch-area" to _pS(_uM("backgroundColor" to "#409eff")), "click-area" to _pS(_uM("backgroundColor" to "#67c23a")), "target-text" to _pS(_uM("color" to "#ffffff", "fontSize" to 16, "fontWeight" to "bold")), "clear-btn-wrapper" to _pS(_uM("display" to "flex", "justifyContent" to "center", "marginTop" to 20, "marginRight" to 0, "marginBottom" to 20, "marginLeft" to 0)), "clear-btn" to _pS(_uM("width" to "100%", "backgroundColor" to "#f56c6c", "color" to "#ffffff", "paddingTop" to 12, "paddingRight" to 0, "paddingBottom" to 12, "paddingLeft" to 0, "borderTopLeftRadius" to 6, "borderTopRightRadius" to 6, "borderBottomRightRadius" to 6, "borderBottomLeftRadius" to 6, "fontSize" to 14)), "event-detail" to _pS(_uM("backgroundColor" to "#f5f7fa", "paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15, "borderTopLeftRadius" to 8, "borderTopRightRadius" to 8, "borderBottomRightRadius" to 8, "borderBottomLeftRadius" to 8, "marginBottom" to 20)), "event-title" to _pS(_uM("fontSize" to 18, "fontWeight" to "bold", "color" to "#303133", "marginBottom" to 12)), "event-base-info" to _pS(_uM("backgroundColor" to "#ffffff", "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "borderTopLeftRadius" to 6, "borderTopRightRadius" to 6, "borderBottomRightRadius" to 6, "borderBottomLeftRadius" to 6, "marginBottom" to 12)), "info-title" to _pS(_uM("fontSize" to 15, "fontWeight" to "bold", "color" to "#606266", "marginBottom" to 8)), "info-row" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "flex-start", "marginBottom" to 8)), "info-label" to _pS(_uM("fontSize" to 14, "color" to "#909399", "flexGrow" to 0, "flexShrink" to 0, "flexBasis" to "120px", "maxWidth" to 120, "marginRight" to 10, "whiteSpace" to "normal")), "info-value" to _pS(_uM("fontSize" to 14, "color" to "#303133", "fontWeight" to "bold", "textAlign" to "right", "flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "minWidth" to 60, "whiteSpace" to "normal")), "touches-title" to _pS(_uM("fontSize" to 15, "fontWeight" to "bold", "color" to "#606266", "marginTop" to 12, "marginBottom" to 8)), "touch-item" to _pS(_uM("backgroundColor" to "#ffffff", "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "borderTopLeftRadius" to 6, "borderTopRightRadius" to 6, "borderBottomRightRadius" to 6, "borderBottomLeftRadius" to 6, "marginBottom" to 10)), "touch-index" to _pS(_uM("fontSize" to 14, "fontWeight" to "bold", "color" to "#409eff", "marginBottom" to 8)), "touch-props" to _pS(_uM("paddingLeft" to 10)), "prop-row" to _pS(_uM("display" to "flex", "flexDirection" to "row", "marginBottom" to 6, "alignItems" to "flex-start")), "prop-label" to _pS(_uM("fontSize" to 13, "color" to "#909399", "flexGrow" to 0, "flexShrink" to 0, "flexBasis" to "120px", "maxWidth" to 120, "marginRight" to 8, "whiteSpace" to "normal")), "prop-value" to _pS(_uM("fontSize" to 13, "color" to "#303133", "fontWeight" to "bold", "flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "minWidth" to 60, "textAlign" to "right", "whiteSpace" to "normal")), "title1" to _pS(_uM("marginTop" to 15, "fontSize" to 20)), "title2" to _pS(_uM("marginTop" to 10, "fontSize" to 18)), "title3" to _pS(_uM("marginTop" to 5, "fontSize" to 16)), "uni-list-cell" to _pS(_uM("display" to "flex", "flexDirection" to "row", "marginBottom" to 5)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
