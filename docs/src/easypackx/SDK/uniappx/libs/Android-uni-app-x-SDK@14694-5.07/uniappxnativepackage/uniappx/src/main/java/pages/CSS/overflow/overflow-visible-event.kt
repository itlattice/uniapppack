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
import io.dcloud.uniapp.extapi.getSystemInfoSync as uni_getSystemInfoSync
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesCSSOverflowOverflowVisibleEvent : BasePage {
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
    open var data: DataType__117
        get() {
            return unref(this.`$exposed`["data"]) as DataType__117
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var jest_getRect: () -> UTSPromise<Unit>
        get() {
            return unref(this.`$exposed`["jest_getRect"]) as () -> UTSPromise<Unit>
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_getRect", value)
        }
    open var jest_getParentRect: () -> Unit
        get() {
            return unref(this.`$exposed`["jest_getParentRect"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_getParentRect", value)
        }
    open var jest_getAbsoluteViewRect: () -> UTSPromise<Unit>
        get() {
            return unref(this.`$exposed`["jest_getAbsoluteViewRect"]) as () -> UTSPromise<Unit>
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_getAbsoluteViewRect", value)
        }
    open var jest_scrollToDeepOverflow: () -> UTSPromise<Unit>
        get() {
            return unref(this.`$exposed`["jest_scrollToDeepOverflow"]) as () -> UTSPromise<Unit>
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_scrollToDeepOverflow", value)
        }
    open var jest_scrollToZIndexOverflow: () -> UTSPromise<Unit>
        get() {
            return unref(this.`$exposed`["jest_scrollToZIndexOverflow"]) as () -> UTSPromise<Unit>
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_scrollToZIndexOverflow", value)
        }
    open var jest_restScorllView: () -> UTSPromise<Unit>
        get() {
            return unref(this.`$exposed`["jest_restScorllView"]) as () -> UTSPromise<Unit>
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_restScorllView", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesCSSOverflowOverflowVisibleEvent, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSOverflowOverflowVisibleEvent
            val _cache = __ins.renderCache
            val data = reactive(DataType__117(jest_result = false, jest_click_x = -1, jest_click_y = -1, jest_parent_top = -1.0, startX = 0, startY = 0, moveX = 0, moveY = 0, oldX = 0, oldY = 0, moveEl = null as UniElement?))
            onReady(fun(){
                data.moveEl = uni_getElementById("parent")
            }
            )
            val handleClickOverflowPart = fun(){
                console.log("click")
                data.jest_result = true
                uni_showToast(ShowToastOptions(title = "点击红色区域"))
            }
            val handleTouchStartOverflowPart = fun(e: UniTouchEvent){
                data.startX = e.changedTouches[0].clientX
                data.startY = e.changedTouches[0].clientY
            }
            val handleTouchMoveOverflowPart = fun(e: UniTouchEvent){
                console.log("touchmove:" + e.touches[0].clientX + "," + e.touches[0].clientY)
                e.preventDefault()
                e.stopPropagation()
                val difX = e.changedTouches[0].clientX
                val difY = e.changedTouches[0].clientY
                data.moveX = difX - data.startX + data.oldX
                data.moveY = difY - data.startY + data.oldY
                data.moveEl?.style?.setProperty("transform", "translate(" + data.moveX + "px," + data.moveY + "px)")
            }
            val handleTouchEndOverflowPart = fun(_: UniTouchEvent){
                data.oldX = data.moveX
                data.oldY = data.moveY
            }
            val handleClick = fun(str: String){
                console.log("点击了 " + str + " view")
                if (str == "red") {
                    data.jest_result = true
                }
            }
            val jest_getRect = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        val rect = await(uni_getElementById("child")!!.getBoundingClientRectAsync()!!)
                        var ratio: Number = 1
                        if (uni_getSystemInfoSync().platform == "android") {
                            ratio = uni_getSystemInfoSync().devicePixelRatio
                        }
                        data.jest_click_x = rect.x * ratio + 30
                        data.jest_click_y = rect.bottom * ratio - 30
                })
            }
            val jest_getParentRect = fun(){
                val transform = uni_getElementById("parent")?.style?.getPropertyValue("transform")
                if (transform != null) {
                    var value = transform as String
                    value = value.split(",")[1].slice(0, -3)
                    var ratio: Number = 1
                    if (uni_getSystemInfoSync().platform == "android") {
                        ratio = uni_getSystemInfoSync().devicePixelRatio
                    }
                    data.jest_parent_top = Math.round((parseFloat(value) * ratio))
                }
            }
            val jest_getAbsoluteViewRect = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        val rect = await(uni_getElementById("absolute-view")!!.getBoundingClientRectAsync()!!)
                        val systemInfo = uni_getSystemInfoSync()
                        val titleBarHeight = systemInfo.screenHeight - systemInfo.windowHeight
                        var ratio: Number = 1
                        if (uni_getSystemInfoSync().platform == "android") {
                            ratio = uni_getSystemInfoSync().devicePixelRatio
                        }
                        data.jest_click_x = rect.x * ratio + 30
                        data.jest_click_y = (rect.top + titleBarHeight) * ratio + 30
                })
            }
            val jest_restScorllView = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        val scrollView = uni_getElementById("scroll-view") as UniScrollViewElement
                        scrollView.scrollTo(0, 0)
                })
            }
            val jest_scrollToDeepOverflow = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        val scrollView = uni_getElementById("scroll-view") as UniScrollViewElement
                        val rect = await(uni_getElementById("deep-overflow")!!.getBoundingClientRectAsync()!!)
                        scrollView.scrollTo(0, rect.top)
                        setTimeout(fun(){
                            val systemInfo = uni_getSystemInfoSync()
                            var ratio: Number = 1
                            if (uni_getSystemInfoSync().platform == "android") {
                                ratio = uni_getSystemInfoSync().devicePixelRatio
                            }
                            val titleBarHeight = systemInfo.screenHeight - systemInfo.windowHeight
                            uni_getElementById("deep-overflow")!!.getBoundingClientRectAsync()!!.then(fun(afterRect: DOMRect){
                                data.jest_click_x = afterRect.x * ratio + 30
                                data.jest_click_y = (afterRect.top + titleBarHeight) * ratio + 30
                            }
                            )
                        }
                        , 200)
                })
            }
            val jest_scrollToZIndexOverflow = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        val scrollView = uni_getElementById("scroll-view") as UniScrollViewElement
                        val rect = await(uni_getElementById("zindex-overflow")!!.getBoundingClientRectAsync()!!)
                        scrollView.scrollTo(0, rect.top)
                        setTimeout(fun(){
                            val systemInfo = uni_getSystemInfoSync()
                            var ratio: Number = 1
                            if (uni_getSystemInfoSync().platform == "android") {
                                ratio = uni_getSystemInfoSync().devicePixelRatio
                            }
                            val titleBarHeight = systemInfo.screenHeight - systemInfo.windowHeight
                            uni_getElementById("zindex-overflow")!!.getBoundingClientRectAsync()!!.then(fun(afterRect: DOMRect){
                                data.jest_click_x = afterRect.x * ratio + 30
                                data.jest_click_y = (afterRect.top + titleBarHeight) * ratio + 30
                            }
                            )
                        }
                        , 200)
                })
            }
            __expose(_uM("data" to data, "jest_getRect" to jest_getRect, "jest_getParentRect" to jest_getParentRect, "jest_getAbsoluteViewRect" to jest_getAbsoluteViewRect, "jest_scrollToDeepOverflow" to jest_scrollToDeepOverflow, "jest_scrollToZIndexOverflow" to jest_scrollToZIndexOverflow, "jest_restScorllView" to jest_restScorllView))
            return fun(): Any? {
                val _component_page_intro = resolveEasyComponent("page-intro", GenComponentsPageIntroPageIntroClass)
                return _cE("scroll-view", _uM("id" to "scroll-view", "style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", null, _uA(
                        _cV(_component_page_intro, _uM("content" to "本页演示 overflow: visible 下的事件行为：子元素超出父区域时点击仍可触发 click/touch 事件；与 position:absolute 遮挡时的点击顺序、hover-class、多层级 overflow:visible、以及 overflow:visible 与 z-index 组合时的事件触发。")),
                        _cE("text", _uM("style" to _nS(_uM("font-size" to "15px"))), "overflow=visible 父view（绿色），子view（红色），点击超出父view区域的部分也可触发事件。", 4),
                        _cE("view", _uM("class" to "backgroundview"), _uA(
                            _cE("view", _uM("id" to "parent", "class" to "box-visible-border-radius"), _uA(
                                _cE("view", _uM("id" to "child", "style" to _nS(_uM("width" to "50px", "height" to "150px", "background-color" to "red")), "onClick" to handleClickOverflowPart, "onTouchmove" to handleTouchMoveOverflowPart, "onTouchstart" to handleTouchStartOverflowPart, "onTouchend" to handleTouchEndOverflowPart), null, 36)
                            ))
                        )),
                        _cE("text", _uM("style" to _nS(_uM("font-size" to "15px"))), "overflow=visible组件的子view （绿色）被position: absolute的view（红色）遮挡时，点击事件测试。", 4),
                        _cE("view", _uM("style" to _nS(_uM("width" to "300px", "height" to "300px", "background-color" to "white"))), _uA(
                            _cE("view", _uM("style" to _nS(_uM("overflow" to "visible", "height" to "100px", "width" to "100%"))), _uA(
                                _cE("view", _uM("style" to _nS(_uM("background-color" to "green", "height" to "100px", "width" to "100%")), "onClick" to fun(){
                                    handleClick("green")
                                }
                                ), null, 12, _uA(
                                    "onClick"
                                ))
                            ), 4),
                            _cE("view", _uM("id" to "absolute-view", "style" to _nS(_uM("position" to "absolute", "background-color" to "red", "width" to "100px", "height" to "200px", "right" to "0px")), "onClick" to fun(){
                                handleClick("red")
                            }
                            ), null, 12, _uA(
                                "onClick"
                            ))
                        ), 4),
                        _cE("text", _uM("style" to _nS(_uM("font-size" to "15px"))), "overflow=visible组件设置hover-class的测试", 4),
                        _cE("view", _uM("class" to "backgroundview"), _uA(
                            _cE("view", _uM("class" to "box-visible-border-radius", "hover-class" to "hover-class"), _uA(
                                _cE("view", _uM("style" to _nS(_uM("background-color" to "red", "height" to "100px", "width" to "100px", "margin-left" to "20px", "margin-top" to "20px"))), null, 4)
                            ))
                        )),
                        _cE("text", _uM("style" to _nS(_uM("font-size" to "15px"))), "overflow=visible组件多层级设置测试", 4),
                        _cE("view", _uM("class" to "backgroundview"), _uA(
                            _cE("view", _uM("id" to "deep-overflow", "style" to _nS(_uM("overflow" to "visible"))), _uA(
                                _cE("view", _uM("style" to _nS(_uM("overflow" to "visible", "background-color" to "red", "width" to "100px", "height" to "100px")), "onClick" to fun(){
                                    handleClick("red")
                                }
                                ), null, 12, _uA(
                                    "onClick"
                                ))
                            ), 4),
                            _cE("view", _uM("style" to _nS(_uM("overflow" to "visible"))), _uA(
                                _cE("view", _uM("style" to _nS(_uM("overflow" to "visible", "background-color" to "green", "width" to "100px", "height" to "100px"))), null, 4)
                            ), 4)
                        )),
                        _cE("text", _uM("style" to _nS(_uM("font-size" to "15px"))), "同时设置overflow=visible、z-index的事件触发示例", 4),
                        _cE("view", _uM("class" to "backgroundview"), _uA(
                            _cE("view", _uM("id" to "zindex-overflow", "style" to _nS(_uM("width" to "1px", "height" to "1px", "overflow" to "visible", "z-index" to "100")), "onClick" to fun(){
                                handleClick("red")
                            }
                            ), _uA(
                                _cE("view", _uM("style" to _nS(_uM("width" to "100px", "height" to "100px", "background-color" to "red"))), null, 4)
                            ), 12, _uA(
                                "onClick"
                            )),
                            _cE("view", _uM("style" to _nS(_uM("width" to "1px", "height" to "1px", "overflow" to "visible"))), _uA(
                                _cE("view", _uM("style" to _nS(_uM("width" to "100px", "height" to "100px", "background-color" to "green"))), null, 4)
                            ), 4)
                        ))
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
                return _uM("backgroundview" to _pS(_uM("width" to 300, "height" to 300, "marginBottom" to 20, "backgroundColor" to "#FFFFFF", "justifyContent" to "center", "alignItems" to "center")), "box-visible-border-radius" to _pS(_uM("width" to 100, "height" to 100, "borderTopLeftRadius" to 20, "borderTopRightRadius" to 20, "borderBottomRightRadius" to 20, "borderBottomLeftRadius" to 20, "overflow" to "visible", "backgroundColor" to "#008000")), "hover-class" to _pS(_uM("backgroundColor" to "#00FFFF")), "box" to _pS(_uM("width" to 1, "height" to 1, "overflow" to "visible")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
