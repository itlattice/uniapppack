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
open class GenPagesAPIElementGetAttributeElementGetAttribute : BasePage {
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
    open var data: DataType__85
        get() {
            return unref(this.`$exposed`["data"]) as DataType__85
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var getAttributeId: () -> Unit
        get() {
            return unref(this.`$exposed`["getAttributeId"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "getAttributeId", value)
        }
    open var setStyle: () -> Unit
        get() {
            return unref(this.`$exposed`["setStyle"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setStyle", value)
        }
    open var getAttributeStyle: () -> Unit
        get() {
            return unref(this.`$exposed`["getAttributeStyle"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "getAttributeStyle", value)
        }
    open var getPropertyValue: () -> Unit
        get() {
            return unref(this.`$exposed`["getPropertyValue"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "getPropertyValue", value)
        }
    open var getBoundingClientRectAsyncChild: () -> Unit
        get() {
            return unref(this.`$exposed`["getBoundingClientRectAsyncChild"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "getBoundingClientRectAsyncChild", value)
        }
    open var scrollTo: () -> Unit
        get() {
            return unref(this.`$exposed`["scrollTo"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "scrollTo", value)
        }
    open var handleGetScaledViewSize: () -> Unit
        get() {
            return unref(this.`$exposed`["handleGetScaledViewSize"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "handleGetScaledViewSize", value)
        }
    open var getScrollViewStyleMarginTop: () -> String
        get() {
            return unref(this.`$exposed`["getScrollViewStyleMarginTop"]) as () -> String
        }
        set(value) {
            setRefValue(this.`$exposed`, "getScrollViewStyleMarginTop", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIElementGetAttributeElementGetAttribute, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIElementGetAttributeElementGetAttribute
            val _cache = __ins.renderCache
            val boxRef = ref<UniElement?>(null)
            val scrollViewRef = ref<UniScrollViewElement?>(null)
            val data = reactive(DataType__85(attrId = "", attrStyle = "", propertyValue = "", rectInfo = DomRectType__1(x = 0, y = 0, width = 0, height = 0, left = 0, top = 0, right = 0, bottom = 0), scaledViewWidth = 0, scaledViewHeight = 0))
            fun gen_getBoundingClientRectAsyncChild_fn() {
                val childEl = uni_getElementById("child")!!
                childEl.getBoundingClientRectAsync()!!.then(fun(rect: DOMRect){
                    console.log("rect: ", rect)
                    data.rectInfo = DomRectType__1(x = rect.x, y = rect.y, width = rect.width, height = rect.height, left = rect.left, top = rect.top, right = rect.right, bottom = rect.bottom)
                }
                )
            }
            val getBoundingClientRectAsyncChild = ::gen_getBoundingClientRectAsyncChild_fn
            fun gen_getAttributeId_fn() {
                if (boxRef.value != null) {
                    data.attrId = boxRef.value!!.getAttribute("id") ?: ""
                }
            }
            val getAttributeId = ::gen_getAttributeId_fn
            fun gen_setStyle_fn() {
                if (boxRef.value != null) {
                    boxRef.value!!.style.setProperty("background-color", "#FFF000")
                }
            }
            val setStyle = ::gen_setStyle_fn
            fun gen_getPropertyValue_fn() {
                if (boxRef.value != null) {
                    data.propertyValue = boxRef.value!!.style.getPropertyValue("background-color")
                }
            }
            val getPropertyValue = ::gen_getPropertyValue_fn
            fun gen_getAttributeStyle_fn() {
                if (boxRef.value != null) {
                    data.attrStyle = boxRef.value!!.getAttribute("style") ?: ""
                }
            }
            val getAttributeStyle = ::gen_getAttributeStyle_fn
            fun gen_scrollTo_fn() {
                if (scrollViewRef.value != null) {
                    scrollViewRef.value!!.scrollTo(200, 0)
                }
            }
            val scrollTo = ::gen_scrollTo_fn
            fun gen_getScrollViewStyleMarginTop_fn(): String {
                if (scrollViewRef.value != null) {
                    return scrollViewRef.value!!.style.getPropertyValue("margin-top")
                }
                return ""
            }
            val getScrollViewStyleMarginTop = ::gen_getScrollViewStyleMarginTop_fn
            val handleGetScaledViewSize = fun(){
                val element = uni_getElementById("scaledView")
                if (element != null) {
                    val rect = element.getBoundingClientRect()
                    data.scaledViewWidth = rect.width
                    data.scaledViewHeight = rect.height
                    console.log("scaledView size : ", data.scaledViewWidth, data.scaledViewHeight)
                }
            }
            onReady(fun(){})
            __expose(_uM("data" to data, "getAttributeId" to getAttributeId, "setStyle" to setStyle, "getAttributeStyle" to getAttributeStyle, "getPropertyValue" to getPropertyValue, "getBoundingClientRectAsyncChild" to getBoundingClientRectAsyncChild, "scrollTo" to scrollTo, "handleGetScaledViewSize" to handleGetScaledViewSize, "getScrollViewStyleMarginTop" to getScrollViewStyleMarginTop))
            return fun(): Any? {
                val _component_page_intro = resolveEasyComponent("page-intro", GenComponentsPageIntroPageIntroClass)
                return _cE("scroll-view", _uM("class" to "page-scroll-view"), _uA(
                    _cE("view", _uM("style" to _nS(_uM("padding" to "15px"))), _uA(
                        _cV(_component_page_intro, _uM("content" to "本页演示元素属性与样式读写：getAttribute 获取元素 id（小程序端支持 style）、getPropertyValue 获取样式值（如背景色）、setProperty 设置样式；含自定义组件子元素的 getBoundingClientRectAsync、scroll-view 的 scrollTo、以及获取 scale 变换后 view 的尺寸信息。")),
                        _cE("view", _uM("id" to "box", "ref_key" to "boxRef", "ref" to boxRef), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "元素的id：" + _tD(unref(data).attrId), 1),
                            _cE("text", _uM("class" to "uni-title-text"), "元素的背景色样式值：" + _tD(unref(data).propertyValue), 1),
                            _cE("text", _uM("class" to "uni-subtitle-text"), "小程序端：getAttribute 获取元素的属性值，目前仅支持id、style"),
                            _cE("text", _uM("class" to "uni-subtitle-text"), "App端：getAttribute 不支持获取 class、style 属性")
                        ), 512),
                        _cE("button", _uM("onClick" to getAttributeId), "getAttribute获取元素的id"),
                        _cE("button", _uM("onClick" to setStyle), "setProperty设置背景色"),
                        _cE("button", _uM("onClick" to getPropertyValue), "getPropertyValue获取背景色值"),
                        _cV(unref(GenPagesAPIElementGetAttributeChildClass), _uM("id" to "child", "ref" to "childRef"), null, 512),
                        _cE("button", _uM("onClick" to getBoundingClientRectAsyncChild), "获取自定义组件child元素信息"),
                        if (isTrue(unref(data).rectInfo)) {
                            _cE("view", _uM("key" to 0, "class" to "rect-info"), _uA(
                                _cE("view", _uM("class" to "node-info-item"), _uA(
                                    _cE("text", _uM("class" to "node-info-item-k"), "x: "),
                                    _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(data).rectInfo.x), 1)
                                )),
                                _cE("view", _uM("class" to "node-info-item"), _uA(
                                    _cE("text", _uM("class" to "node-info-item-k"), "y: "),
                                    _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(data).rectInfo.y), 1)
                                )),
                                _cE("view", _uM("class" to "node-info-item"), _uA(
                                    _cE("text", _uM("class" to "node-info-item-k"), "width: "),
                                    _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(data).rectInfo.width), 1)
                                )),
                                _cE("view", _uM("class" to "node-info-item"), _uA(
                                    _cE("text", _uM("class" to "node-info-item-k"), "height: "),
                                    _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(data).rectInfo.height), 1)
                                )),
                                _cE("view", _uM("class" to "node-info-item"), _uA(
                                    _cE("text", _uM("class" to "node-info-item-k"), "left: "),
                                    _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(data).rectInfo.left), 1)
                                )),
                                _cE("view", _uM("class" to "node-info-item"), _uA(
                                    _cE("text", _uM("class" to "node-info-item-k"), "top: "),
                                    _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(data).rectInfo.top), 1)
                                )),
                                _cE("view", _uM("class" to "node-info-item"), _uA(
                                    _cE("text", _uM("class" to "node-info-item-k"), "right: "),
                                    _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(data).rectInfo.right), 1)
                                )),
                                _cE("view", _uM("class" to "node-info-item"), _uA(
                                    _cE("text", _uM("class" to "node-info-item-k"), "bottom: "),
                                    _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(data).rectInfo.bottom), 1)
                                ))
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        _cE("scroll-view", _uM("ref_key" to "scrollViewRef", "ref" to scrollViewRef, "class" to "scroll-view_H", "direction" to "horizontal"), _uA(
                            _cE("view", _uM("class" to "scroll-view-item_H uni-bg-red"), _uA(
                                _cE("text", _uM("class" to "text"), "A")
                            )),
                            _cE("view", _uM("class" to "scroll-view-item_H uni-bg-green"), _uA(
                                _cE("text", _uM("class" to "text"), "B")
                            )),
                            _cE("view", _uM("class" to "scroll-view-item_H uni-bg-blue"), _uA(
                                _cE("text", _uM("class" to "text"), "C")
                            ))
                        ), 512),
                        _cE("button", _uM("onClick" to scrollTo), "scrollTo设置left滚动200px"),
                        _cE("view", _uM("id" to "scaledView", "style" to _nS(_uM("transform" to "scale(2)", "background-color" to "green", "width" to "50px", "height" to "50px", "margin-top" to "45px", "margin-left" to "25px"))), null, 4),
                        _cE("button", _uM("type" to "default", "onClick" to handleGetScaledViewSize, "style" to _nS(_uM("margin-top" to "30px"))), "获取scale后的view尺寸信息", 4)
                    ), 4)
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
                return _uM("scroll-view_H" to _pS(_uM("width" to "100%", "flexDirection" to "row", "marginTop" to 15)), "scroll-view-item_H" to _pS(_uM("width" to "100%", "height" to 150, "justifyContent" to "center", "alignItems" to "center")), "text" to _pS(_uM("fontSize" to 18, "color" to "#ffffff")), "rect-info" to _pS(_uM("marginTop" to 15, "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "flexDirection" to "column")), "node-info-item" to _pS(_uM("flexDirection" to "row")), "node-info-item-k" to _pS(_uM("width" to 72, "lineHeight" to 2)), "node-info-item-v" to _pS(_uM("fontWeight" to "bold", "lineHeight" to 2)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
