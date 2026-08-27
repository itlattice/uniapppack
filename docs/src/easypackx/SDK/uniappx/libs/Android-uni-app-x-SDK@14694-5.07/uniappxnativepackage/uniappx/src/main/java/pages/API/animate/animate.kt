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
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesAPIAnimateAnimate : BasePage {
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
        var setup: (__props: GenPagesAPIAnimateAnimate) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIAnimateAnimate
            val _cache = __ins.renderCache
            var mainView: UniElement? = null
            var animation: UniAnimation? = null
            fun gen_startAnimate_fn() {
                animation = mainView!!.animate(_uA(
                    UniAnimationKeyframe(transform = "scale(1)", transformOrigin = "0px 0px"),
                    UniAnimationKeyframe(transform = "scale(0)", transformOrigin = "50px 50px"),
                    UniAnimationKeyframe(transform = "scale(1)", transformOrigin = "100px 100px")
                ), UniAnimationOption(duration = 5000))
                animation!!.oncancel = fun(_: UniAnimationPlaybackEvent){
                    uni_showToast(ShowToastOptions(title = "动画被取消了"))
                }
                animation!!.onfinish = fun(_: UniAnimationPlaybackEvent){
                    uni_showToast(ShowToastOptions(title = "动画播放完成"))
                }
            }
            val startAnimate = ::gen_startAnimate_fn
            fun gen_pauseAnimate_fn() {
                animation?.pause()
            }
            val pauseAnimate = ::gen_pauseAnimate_fn
            fun gen_resumeAnimate_fn() {
                animation?.play()
            }
            val resumeAnimate = ::gen_resumeAnimate_fn
            fun gen_cancelAnimate_fn() {
                animation?.cancel()
            }
            val cancelAnimate = ::gen_cancelAnimate_fn
            fun gen_widthProperty_fn(e: UniPointerEvent) {
                e.currentTarget?.animate(_uO("width" to _uA(
                    "100px",
                    "200px",
                    "100px"
                )), _uO("duration" to 1000, "fill" to "forwards"))
            }
            val widthProperty = ::gen_widthProperty_fn
            fun gen_heightProperty_fn(e: UniPointerEvent) {
                e.currentTarget?.animate(_uO("height" to _uA(
                    "100px",
                    "200px"
                )), _uO("duration" to 1000, "fill" to "forwards"))
            }
            val heightProperty = ::gen_heightProperty_fn
            fun gen_marginProperty_fn(e: UniPointerEvent) {
                e.currentTarget?.animate(_uO("margin" to _uA(
                    "8px",
                    "16px",
                    "32px"
                )), _uO("duration" to 1000, "fill" to "forwards"))
            }
            val marginProperty = ::gen_marginProperty_fn
            fun gen_paddingProperty_fn(e: UniPointerEvent) {
                e.currentTarget?.animate(_uO("padding" to _uA(
                    "0px",
                    "16px",
                    "32px",
                    "0px"
                )), _uO("duration" to 1000, "fill" to "forwards"))
            }
            val paddingProperty = ::gen_paddingProperty_fn
            fun gen_backgroundProperty_fn(e: UniPointerEvent) {
                e.currentTarget?.animate(_uA(
                    _uO("offset" to 0.3, "backgroundColor" to "yellow"),
                    _uO("offset" to 0.6, "backgroundColor" to "red"),
                    _uO("backgroundColor" to "blue")
                ), _uO("duration" to 1000, "fill" to "forwards"))
            }
            val backgroundProperty = ::gen_backgroundProperty_fn
            fun gen_borderProperty_fn(e: UniPointerEvent) {
                e.currentTarget?.animate(_uA(
                    _uO("offset" to 0.3, "borderColor" to "yellow"),
                    _uO("offset" to 0.6, "borderColor" to "pink"),
                    _uO("borderColor" to "blue")
                ), _uO("duration" to 1000, "fill" to "forwards"))
            }
            val borderProperty = ::gen_borderProperty_fn
            fun gen_transformProperty_fn(e: UniPointerEvent) {
                e.currentTarget?.animate(_uA(
                    _uO("transform" to "translateX(0px) scale(1) rotate(0deg)"),
                    _uO("transform" to "translateX(100px)"),
                    _uO("transform" to "scale(0.8) rotate(180deg)")
                ), _uO("duration" to 1000, "fill" to "forwards"))
            }
            val transformProperty = ::gen_transformProperty_fn
            fun gen_positionProperty_fn(e: UniPointerEvent) {
                e.currentTarget?.animate(_uO("left" to _uA(
                    "0px",
                    "16px",
                    "32px",
                    "0px"
                )), _uO("duration" to 1000, "fill" to "forwards"))
            }
            val positionProperty = ::gen_positionProperty_fn
            fun gen_backgroundAndWidthProperty_fn(e: UniPointerEvent) {
                e.currentTarget?.animate(_uO("width" to _uA(
                    "100px",
                    "200px"
                ), "backgroundColor" to _uA(
                    "red",
                    "yellow",
                    "blue"
                )), _uO("duration" to 1000, "fill" to "forwards"))
            }
            val backgroundAndWidthProperty = ::gen_backgroundAndWidthProperty_fn
            fun gen_backgroundAndMarginLeftProperty_fn(e: UniPointerEvent) {
                e.currentTarget?.animate(_uA(
                    _uO("offset" to 0.2, "backgroundColor" to "red"),
                    _uO("marginLeft" to "10px"),
                    _uO("marginLeft" to "20px"),
                    _uO("marginLeft" to "30px", "backgroundColor" to "pink")
                ), _uO("duration" to 1000, "fill" to "forwards"))
            }
            val backgroundAndMarginLeftProperty = ::gen_backgroundAndMarginLeftProperty_fn
            fun gen_backgroundAndTransformProperty_fn(e: UniPointerEvent) {
                e.currentTarget?.animate(_uA(
                    _uO("offset" to 0.2, "backgroundColor" to "red"),
                    _uO("transform" to "translate(30px,0px)"),
                    _uO("transform" to "translate(50px,0px)"),
                    _uO("transform" to "translate(100px,0px)", "backgroundColor" to "pink")
                ), _uO("duration" to 1000, "fill" to "forwards"))
            }
            val backgroundAndTransformProperty = ::gen_backgroundAndTransformProperty_fn
            fun gen_oneProperty1_fn(e: UniPointerEvent) {
                e.currentTarget?.animate(_uO("backgroundColor" to "green"), _uO("duration" to 1000, "fill" to "forwards"))
            }
            val oneProperty1 = ::gen_oneProperty1_fn
            fun gen_oneProperty2_fn(e: UniPointerEvent) {
                e.currentTarget?.animate(_uA(
                    _uO("backgroundColor" to "blue")
                ), _uO("duration" to 1000, "fill" to "forwards"))
            }
            val oneProperty2 = ::gen_oneProperty2_fn
            fun gen_borderColorMarginLeftProperty_fn(e: UniPointerEvent) {
                e.currentTarget?.animate(_uA(
                    _uO("borderColor" to "red", "marginLeft" to "0px", "offset" to 0),
                    _uO("marginLeft" to "20px", "offset" to 0.5),
                    _uO("marginLeft" to "60px", "borderColor" to "yellow", "offset" to 1)
                ), _uO("duration" to 1000, "fill" to "forwards"))
            }
            val borderColorMarginLeftProperty = ::gen_borderColorMarginLeftProperty_fn
            fun gen_opacityProperty_fn(e: UniPointerEvent) {
                e.currentTarget?.animate(_uA(
                    _uO("offset" to 0.3, "opacity" to "1"),
                    _uO("offset" to 0.6, "opacity" to "0.1"),
                    _uO("opacity" to "1")
                ), _uO("duration" to 1000, "fill" to "forwards"))
            }
            val opacityProperty = ::gen_opacityProperty_fn
            onReady(fun(){
                mainView = uni_getElementById("main")
                var roll = uni_getElementById("roll")
                roll!!.animate(_uA(
                    UniAnimationKeyframe(transform = "translateX(0) rotate(0)"),
                    UniAnimationKeyframe(transform = "translateX(200px) rotate(540deg)")
                ), UniAnimationOption(duration = 2000, direction = "alternate", easing = "ease-in-out", iterations = Infinity))
            }
            )
            return fun(): Any? {
                val _component_page_intro = resolveEasyComponent("page-intro", GenComponentsPageIntroPageIntroClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cV(_component_page_intro, _uM("content" to "本页演示 uni.createAnimation 与 uni.createAnimateContext：点击开始/暂停/恢复/取消动画，可点击各 view 修改宽度、高度、margin、padding 等属性动画。")),
                    _cE("view", _uM("id" to "main", "style" to _nS(_uM("width" to "100px", "height" to "100px", "background-color" to "brown", "transform" to "scale(1)"))), null, 4),
                    _cE("button", _uM("onClick" to startAnimate), "开始动画"),
                    _cE("button", _uM("onClick" to pauseAnimate), "暂停动画"),
                    _cE("button", _uM("onClick" to resumeAnimate), "恢复动画"),
                    _cE("button", _uM("onClick" to cancelAnimate), "取消动画"),
                    _cE("image", _uM("src" to "/static/test-image/logo.png", "id" to "roll", "style" to _nS(_uM("width" to "100px", "height" to "100px", "margin" to "10px"))), null, 4),
                    _cE("view", _uM("style" to _nS(_uM("border-radius" to "5px", "margin" to "4px", "padding" to "4px", "border-style" to "solid", "background-color" to "#eee", "border-color" to "#eee"))), _uA(
                        _cE("text", _uM("style" to _nS(_uM("margin-bottom" to "4px"))), "修改宽度", 4),
                        _cE("view", _uM("id" to "widthProperty", "style" to _nS(_uM("width" to "100px", "height" to "100px", "background-color" to "brown")), "onClick" to widthProperty), null, 4)
                    ), 4),
                    _cE("view", _uM("style" to _nS(_uM("border-radius" to "5px", "margin" to "4px", "padding" to "4px", "border-style" to "solid", "background-color" to "#eee", "border-color" to "#eee"))), _uA(
                        _cE("text", _uM("style" to _nS(_uM("margin-bottom" to "4px"))), "修改高度", 4),
                        _cE("view", _uM("id" to "height1", "style" to _nS(_uM("width" to "100px", "height" to "100px", "background-color" to "brown")), "onClick" to heightProperty), null, 4)
                    ), 4),
                    _cE("view", _uM("style" to _nS(_uM("border-radius" to "5px", "margin" to "4px", "padding" to "4px", "border-style" to "solid", "background-color" to "#eee", "border-color" to "#eee"))), _uA(
                        _cE("text", _uM("style" to _nS(_uM("margin-bottom" to "4px"))), "修改margin", 4),
                        _cE("view", _uM("id" to "marginProperty", "style" to _nS(_uM("width" to "100px", "height" to "100px", "background-color" to "brown")), "onClick" to marginProperty), null, 4)
                    ), 4),
                    _cE("view", _uM("style" to _nS(_uM("border-radius" to "5px", "margin" to "4px", "padding" to "4px", "border-style" to "solid", "background-color" to "#eee", "border-color" to "#eee"))), _uA(
                        _cE("text", _uM("style" to _nS(_uM("margin-bottom" to "4px"))), "修改padding", 4),
                        _cE("view", _uM("id" to "paddingProperty", "style" to _nS(_uM("width" to "100px", "height" to "100px", "background-color" to "brown")), "onClick" to paddingProperty), _uA(
                            _cE("view", _uM("style" to _nS(_uM("width" to "50px", "height" to "50px", "background-color" to "black"))), null, 4)
                        ), 4)
                    ), 4),
                    _cE("view", _uM("style" to _nS(_uM("border-radius" to "5px", "margin" to "4px", "padding" to "4px", "border-style" to "solid", "background-color" to "#eee", "border-color" to "#eee"))), _uA(
                        _cE("text", _uM("style" to _nS(_uM("margin-bottom" to "4px"))), "修改border颜色", 4),
                        _cE("view", _uM("id" to "borderProperty", "style" to _nS(_uM("width" to "100px", "height" to "100px", "background-color" to "brown", "border-width" to "10px", "border-color" to "black", "border-style" to "solid")), "onClick" to borderProperty), null, 4)
                    ), 4),
                    _cE("view", _uM("style" to _nS(_uM("border-radius" to "5px", "margin" to "4px", "padding" to "4px", "border-style" to "solid", "background-color" to "#eee", "border-color" to "#eee"))), _uA(
                        _cE("text", _uM("style" to _nS(_uM("margin-bottom" to "4px"))), "修改transform", 4),
                        _cE("view", _uM("id" to "transformProperty", "style" to _nS(_uM("width" to "100px", "height" to "100px", "background-color" to "brown")), "onClick" to transformProperty), null, 4)
                    ), 4),
                    _cE("view", _uM("style" to _nS(_uM("border-radius" to "5px", "margin" to "4px", "padding" to "4px", "border-style" to "solid", "background-color" to "#eee", "border-color" to "#eee"))), _uA(
                        _cE("text", _uM("style" to _nS(_uM("margin-bottom" to "4px"))), "修改position", 4),
                        _cE("view", _uM("id" to "positionProperty", "style" to _nS(_uM("width" to "100px", "height" to "100px", "background-color" to "brown")), "onClick" to positionProperty), null, 4)
                    ), 4),
                    _cE("view", _uM("style" to _nS(_uM("border-radius" to "5px", "margin" to "4px", "padding" to "4px", "border-style" to "solid", "background-color" to "#eee", "border-color" to "#eee"))), _uA(
                        _cE("text", _uM("style" to _nS(_uM("margin-bottom" to "4px"))), "修改背景色和宽度", 4),
                        _cE("view", _uM("id" to "backgroundAndWidthProperty", "style" to _nS(_uM("width" to "100px", "height" to "100px", "background-color" to "brown")), "onClick" to backgroundAndWidthProperty), null, 4)
                    ), 4),
                    _cE("view", _uM("style" to _nS(_uM("border-radius" to "5px", "margin" to "4px", "padding" to "4px", "border-style" to "solid", "background-color" to "#eee", "border-color" to "#eee"))), _uA(
                        _cE("text", _uM("style" to _nS(_uM("margin-bottom" to "4px"))), "执行的动画只有一个值1", 4),
                        _cE("view", _uM("id" to "oneProperty1", "style" to _nS(_uM("width" to "100px", "height" to "100px", "background-color" to "brown")), "onClick" to oneProperty1), null, 4)
                    ), 4),
                    _cE("view", _uM("style" to _nS(_uM("border-radius" to "5px", "margin" to "4px", "padding" to "4px", "border-style" to "solid", "background-color" to "#eee", "border-color" to "#eee"))), _uA(
                        _cE("text", _uM("style" to _nS(_uM("margin-bottom" to "4px"))), "执行的动画只有一个值2", 4),
                        _cE("view", _uM("id" to "oneProperty2", "style" to _nS(_uM("width" to "100px", "height" to "100px", "background-color" to "brown")), "onClick" to oneProperty2), null, 4)
                    ), 4),
                    _cE("view", _uM("style" to _nS(_uM("border-radius" to "5px", "margin" to "4px", "padding" to "4px", "border-style" to "solid", "background-color" to "#eee", "border-color" to "#eee"))), _uA(
                        _cE("text", _uM("style" to _nS(_uM("margin-bottom" to "4px"))), "修改背景色和margin-left(关键帧)", 4),
                        _cE("view", _uM("id" to "backgroundAndMarginLeftProperty", "style" to _nS(_uM("width" to "100px", "height" to "100px", "background-color" to "brown")), "onClick" to backgroundAndMarginLeftProperty), null, 4)
                    ), 4),
                    _cE("view", _uM("style" to _nS(_uM("border-radius" to "5px", "margin" to "4px", "padding" to "4px", "border-style" to "solid", "background-color" to "#eee", "border-color" to "#eee"))), _uA(
                        _cE("text", _uM("style" to _nS(_uM("margin-bottom" to "4px"))), "修改背景色和transform(关键帧)", 4),
                        _cE("view", _uM("id" to "backgroundAndTransformProperty", "style" to _nS(_uM("width" to "100px", "height" to "100px", "background-color" to "brown")), "onClick" to backgroundAndTransformProperty), null, 4)
                    ), 4),
                    _cE("view", _uM("style" to _nS(_uM("border-radius" to "5px", "margin" to "4px", "padding" to "4px", "border-style" to "solid", "background-color" to "#eee", "border-color" to "#eee"))), _uA(
                        _cE("text", _uM("style" to _nS(_uM("margin-bottom" to "4px"))), "修改背景色(关键帧)", 4),
                        _cE("view", _uM("id" to "backgroundProperty", "style" to _nS(_uM("width" to "100px", "height" to "100px", "background-color" to "brown")), "onClick" to backgroundProperty), null, 4)
                    ), 4),
                    _cE("view", _uM("style" to _nS(_uM("border-radius" to "5px", "margin" to "4px", "padding" to "4px", "border-style" to "solid", "background-color" to "#eee", "border-color" to "#eee"))), _uA(
                        _cE("text", _uM("style" to _nS(_uM("margin-bottom" to "4px"))), "修改opacity(关键帧)", 4),
                        _cE("view", _uM("id" to "opacityProperty", "style" to _nS(_uM("width" to "100px", "height" to "100px", "background-color" to "brown")), "onClick" to opacityProperty), null, 4)
                    ), 4),
                    _cE("view", _uM("style" to _nS(_uM("border-radius" to "5px", "margin" to "4px", "padding" to "4px", "border-style" to "solid", "background-color" to "#eee", "border-color" to "#eee"))), _uA(
                        _cE("text", _uM("style" to _nS(_uM("margin-bottom" to "4px"))), "修改border-color和margin-left(关键帧)", 4),
                        _cE("view", _uM("id" to "borderColorMarginLeftProperty", "style" to _nS(_uM("width" to "100px", "height" to "100px", "background-color" to "brown", "border-width" to "5px", "border-style" to "solid")), "onClick" to borderColorMarginLeftProperty), null, 4)
                    ), 4)
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
                return _uM("view-margin" to _pS(_uM("marginTop" to 8, "marginRight" to 8, "marginBottom" to 8, "marginLeft" to 8)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
