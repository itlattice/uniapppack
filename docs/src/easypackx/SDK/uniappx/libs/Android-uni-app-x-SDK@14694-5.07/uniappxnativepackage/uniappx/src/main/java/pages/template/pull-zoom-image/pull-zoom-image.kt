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
open class GenPagesTemplatePullZoomImagePullZoomImage : BasePage {
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
        var setup: (__props: GenPagesTemplatePullZoomImagePullZoomImage) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesTemplatePullZoomImagePullZoomImage
            val _cache = __ins.renderCache
            val headerPullImg = ref<UniElement?>(null)
            val headerImg = ref<UniElement?>(null)
            val userInfo = ref<UniElement?>(null)
            val headerWrapper = ref<UniElement?>(null)
            val `$elementMap` = Map<String, UniElement>()
            fun gen_setElementStyle_fn(refName: String, propertyName: String, propertyStyle: Any): Unit {
                var element: UniElement? = `$elementMap`.get(refName)
                if (element == null) {
                    if (refName == "header-pull-img") {
                        element = headerPullImg.value
                    } else if (refName == "header-img") {
                        element = headerImg.value
                    } else if (refName == "user-info") {
                        element = userInfo.value
                    } else if (refName == "header-wrapper") {
                        element = headerWrapper.value
                    }
                    if (element != null) {
                        `$elementMap`.set(refName, element)
                    }
                }
                if (element != null) {
                    element.style.setProperty(propertyName, propertyStyle)
                }
            }
            val setElementStyle = ::gen_setElementStyle_fn
            fun gen_onScroll_fn(e: ScrollEvent) {
                val scrollTop = e.detail.scrollTop
                var y: Number = scrollTop - 110
                var s: Number = (100 - scrollTop / 3) / 100
                if (y < 0) {
                    y = 0
                }
                if (s < 0.7) {
                    s = 0.7
                }
                var x: Number = (1 - s) * -100
                setElementStyle("user-info", "transform", "translate(" + x + "px, " + (y + (s - 1) * -50) + "px) scale(" + s + ")")
                setElementStyle("header-wrapper", "transform", "translateY(" + y + "px)")
            }
            val onScroll = ::gen_onScroll_fn
            fun gen_onRefresherpulling_fn(e: RefresherEvent) {
                var pullingDistance: Number = e.detail.dy
                setElementStyle("header-pull-img", "transform", "scale(" + (pullingDistance / 200 + 1) + ")")
                setElementStyle("header-img", "transform", "scale(" + (pullingDistance / 200 + 1) + ")")
            }
            val onRefresherpulling = ::gen_onRefresherpulling_fn
            return fun(): Any? {
                val _component_uni_back_arrow_circle = resolveEasyComponent("uni-back-arrow-circle", GenComponentsUniBackArrowCircleUniBackArrowCircleClass)
                return _cE("view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cV(_component_uni_back_arrow_circle, _uM("class" to "back", "arrow-class" to "arrow")),
                    _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1")), "refresher-enabled" to true, "refresher-default-style" to "none", "onRefresherpulling" to onRefresherpulling, "refresher-threshold" to 300, "refresher-max-drag-distance" to 299, "onScroll" to onScroll, "bounces" to false), _uA(
                        _cE("view", _uM("class" to "header-wrapper", "ref_key" to "headerWrapper", "ref" to headerWrapper), _uA(
                            _cE("image", _uM("class" to "header-img", "ref_key" to "headerImg", "ref" to headerImg, "src" to "https://web-ext-storage.dcloud.net.cn/hello-uni-app-x/pull-zoom-image-head-img.jpg", "mode" to "scaleToFill"), null, 512)
                        ), 512),
                        _cE("view", _uM("class" to "user-info", "ref_key" to "userInfo", "ref" to userInfo), _uA(
                            _cE("image", _uM("class" to "avatar", "src" to "/static/test-image/logo.png", "mode" to "widthFix")),
                            _cE("view", _uM("class" to "user-text"), _uA(
                                _cE("text", _uM("class" to "username"), "uni-app-x"),
                                _cE("text", _uM("class" to "slogan"), "一次开发，多端覆盖")
                            ))
                        ), 512),
                        _cE("view", _uM("class" to "content-list"), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(30, fun(item, index, __index, _cached): Any {
                                return _cE("view", _uM("class" to "list-item", "key" to index), _uA(
                                    _cE("text", _uM("class" to "item-text"), _tD(item) + ". 占位", 1)
                                ))
                            }
                            ), 64)
                        )),
                        _cE("view", _uM("slot" to "refresher", "class" to "header-pull-wrapper"), _uA(
                            _cE("image", _uM("class" to "header-pull-img", "ref_key" to "headerPullImg", "ref" to headerPullImg, "src" to "https://web-ext-storage.dcloud.net.cn/hello-uni-app-x/pull-zoom-image-head-img.jpg", "mode" to "scaleToFill"), null, 512)
                        ))
                    ), 36)
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
                return _uM("header-pull-wrapper" to _pS(_uM("position" to "relative", "backgroundImage" to "none", "backgroundColor" to "#5788cd", "height" to 300)), "header-wrapper" to _pS(_uM("position" to "relative", "backgroundImage" to "none", "backgroundColor" to "#5788cd", "height" to 200, "zIndex" to 9)), "header-pull-img" to _pS(_uM("position" to "absolute", "width" to "100%", "height" to 600, "top" to 0)), "header-img" to _pS(_uM("position" to "absolute", "width" to "100%", "height" to 600, "bottom" to -100)), "user-info" to _pS(_uM("marginTop" to -110, "flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15, "flexDirection" to "row", "zIndex" to 10)), "avatar" to _pS(_uM("width" to 75, "height" to 75, "borderTopLeftRadius" to 100, "borderTopRightRadius" to 100, "borderBottomRightRadius" to 100, "borderBottomLeftRadius" to 100, "borderTopWidth" to 3, "borderRightWidth" to 3, "borderBottomWidth" to 3, "borderLeftWidth" to 3, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#FFFFFF", "borderRightColor" to "#FFFFFF", "borderBottomColor" to "#FFFFFF", "borderLeftColor" to "#FFFFFF")), "user-text" to _pS(_uM("flexDirection" to "column", "justifyContent" to "space-around", "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10)), "username" to _pS(_uM("fontSize" to 26, "color" to "#FFFFFF")), "slogan" to _pS(_uM("fontSize" to 16, "color" to "#FFFFFF")), "content-list" to _pS(_uM("backgroundColor" to "#FFFFFF", "zIndex" to 1)), "list-item" to _pS(_uM("paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "marginTop" to 5, "marginRight" to 5, "marginBottom" to 5, "marginLeft" to 5, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "rgba(220,220,220,0.3)", "borderRightColor" to "rgba(220,220,220,0.3)", "borderBottomColor" to "rgba(220,220,220,0.3)", "borderLeftColor" to "rgba(220,220,220,0.3)")), "item-text" to _pS(_uM("fontSize" to 14, "color" to "#666666", "lineHeight" to "20px")), "back" to _pS(_uM("position" to "absolute", "top" to CSS_VAR_STATUS_BAR_HEIGHT, "zIndex" to 10)), "arrow" to _pS(_uM("!borderLeftColor" to "#FFFFFF", "!borderBottomColor" to "#FFFFFF")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
