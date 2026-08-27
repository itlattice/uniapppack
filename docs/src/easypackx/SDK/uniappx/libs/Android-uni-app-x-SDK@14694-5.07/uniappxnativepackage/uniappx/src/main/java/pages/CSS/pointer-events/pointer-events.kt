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
open class GenPagesCSSPointerEventsPointerEvents : BasePage {
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
        var setup: (__props: GenPagesCSSPointerEventsPointerEvents) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSPointerEventsPointerEvents
            val _cache = __ins.renderCache
            var isTranstionWidthOrHeight = false
            var widthOrHeight: UniElement? = null
            var widthProgress: UniElement? = null
            var textPointer: UniElement? = null
            var imagePointer: UniElement? = null
            var progressWidth: Number = 200
            var isTextWidth = false
            var isImageWidth = false
            val pointerEvents1 = ref("auto")
            val pointerEvents2 = ref("auto")
            val pointerEvents3 = ref("auto")
            val pointerEvents4 = ref("auto")
            onReady(fun(){
                widthOrHeight = uni_getElementById("widthOrHeight")
                widthProgress = uni_getElementById("widthProgress")
                textPointer = uni_getElementById("textPointer")
                imagePointer = uni_getElementById("imagePointer")
            }
            )
            val changeWidthOrHeight = fun(){
                widthOrHeight?.style?.setProperty("width", if (isTranstionWidthOrHeight) {
                    "200px"
                } else {
                    "300px"
                }
                )
                isTranstionWidthOrHeight = !isTranstionWidthOrHeight
            }
            val changeWidthProgress = fun(){
                progressWidth += 20
                widthProgress?.style?.setProperty("width", progressWidth + "px")
            }
            val onChange1 = fun(e: UniSwitchChangeEvent){
                pointerEvents1.value = if (e.detail.value) {
                    "auto"
                } else {
                    "none"
                }
            }
            val onChange2 = fun(e: UniSwitchChangeEvent){
                pointerEvents2.value = if (e.detail.value) {
                    "auto"
                } else {
                    "none"
                }
            }
            val changeTextWidth = fun(){
                textPointer?.style?.setProperty("width", if (isTextWidth) {
                    "200px"
                } else {
                    "300px"
                }
                )
                isTextWidth = !isTextWidth
            }
            val changeImageWidth = fun(){
                imagePointer?.style?.setProperty("width", if (isImageWidth) {
                    "200px"
                } else {
                    "300px"
                }
                )
                isImageWidth = !isImageWidth
            }
            val onChange3 = fun(e: UniSwitchChangeEvent){
                pointerEvents3.value = if (e.detail.value) {
                    "auto"
                } else {
                    "none"
                }
            }
            val onChange4 = fun(e: UniSwitchChangeEvent){
                pointerEvents4.value = if (e.detail.value) {
                    "auto"
                } else {
                    "none"
                }
            }
            return fun(): Any? {
                val _component_page_intro = resolveEasyComponent("page-intro", GenComponentsPageIntroPageIntroClass)
                val _component_switch = resolveComponent("switch")
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", null, _uA(
                        _cV(_component_page_intro, _uM("content" to "本页演示 pointer-events：通过开关控制父 view、遮罩层、text、image 的 pointer-events（auto/none），观察点击是否穿透或响应；点击可修改 view/text/image 宽度，用于验证事件是否命中目标。")),
                        _cE("view", _uM("class" to "container1"), _uA(
                            _cE("text", null, "控制父视图pointer-events打开时可以点击"),
                            _cV(_component_switch, _uM("checked" to true, "onChange" to onChange1))
                        )),
                        _cE("view", _uM("class" to "container", "style" to _nS(_uM("pointer-events" to unref(pointerEvents1)))), _uA(
                            _cE("text", _uM("class" to "text"), "点击修改宽度"),
                            _cE("view", _uM("class" to "base-style transition-width", "id" to "widthOrHeight", "onClick" to changeWidthOrHeight))
                        ), 4),
                        _cE("view", _uM("class" to "container1"), _uA(
                            _cE("text", null, "控制遮罩层pointer-events关闭时可以点击"),
                            _cV(_component_switch, _uM("checked" to true, "onChange" to onChange2))
                        )),
                        _cE("view", _uM("class" to "container"), _uA(
                            _cE("text", _uM("class" to "text"), "点击修改宽度(递增)"),
                            _cE("view", _uM("class" to "width-progress transition-width", "id" to "widthProgress", "onClick" to changeWidthProgress)),
                            _cE("view", _uM("class" to "mask", "style" to _nS(_uM("pointer-events" to unref(pointerEvents2)))), null, 4)
                        )),
                        _cE("view", _uM("class" to "container1"), _uA(
                            _cE("text", null, "控制text组件pointer-events打开时可以点击"),
                            _cV(_component_switch, _uM("checked" to true, "onChange" to onChange3))
                        )),
                        _cE("view", _uM("class" to "container", "style" to _nS(_uM("pointer-events" to unref(pointerEvents3)))), _uA(
                            _cE("text", _uM("class" to "text"), "点击修改宽度"),
                            _cE("text", _uM("class" to "text-pointer transition-width", "id" to "textPointer", "onClick" to changeTextWidth), "测试文本")
                        ), 4),
                        _cE("view", _uM("class" to "container1"), _uA(
                            _cE("text", null, "控制image组件pointer-events打开时可以点击"),
                            _cV(_component_switch, _uM("checked" to true, "onChange" to onChange4))
                        )),
                        _cE("view", _uM("class" to "container", "style" to _nS(_uM("pointer-events" to unref(pointerEvents4)))), _uA(
                            _cE("text", _uM("class" to "text"), "点击修改宽度"),
                            _cE("image", _uM("class" to "image-pointer transition-width", "id" to "imagePointer", "onClick" to changeImageWidth, "src" to "/static/test-image/logo.png"))
                        ), 4)
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
                return _uM("container1" to _pS(_uM("marginTop" to 7, "marginRight" to 0, "marginBottom" to 7, "marginLeft" to 7, "display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center")), "container" to _pS(_uM("marginTop" to 7, "marginRight" to 7, "marginBottom" to 7, "marginLeft" to 7, "backgroundColor" to "#FFFFFF")), "text" to _pS(_uM("marginTop" to 10, "marginBottom" to 16)), "base-style" to _pS(_uM("width" to 200, "height" to 200, "backgroundColor" to "#A52A2A")), "width-progress" to _pS(_uM("width" to 200, "height" to 200, "backgroundColor" to "#A52A2A")), "transition-width" to _pS(_uM("transitionProperty" to "width", "transitionDuration" to "1s")), "mask" to _pS(_uM("position" to "absolute", "bottom" to 0, "left" to 0, "width" to "100%", "height" to 200, "backgroundColor" to "rgba(0,0,0,0.5)")), "text-pointer" to _pS(_uM("width" to 200, "height" to 200, "backgroundColor" to "#A52A2A", "fontSize" to 16, "color" to "#FFFFFF")), "image-pointer" to _pS(_uM("width" to 200, "height" to 200, "backgroundColor" to "#A52A2A")), "@TRANSITION" to _uM("transition-width" to _uM("property" to "width", "duration" to "1s")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
