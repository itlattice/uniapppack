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
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesTemplateScrollFoldNavScrollFoldNav : BasePage {
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
        var setup: (__props: GenPagesTemplateScrollFoldNavScrollFoldNav) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesTemplateScrollFoldNavScrollFoldNav
            val _cache = __ins.renderCache
            val NAVIBARHEIGHT: Number = 88
            val SEARCHBARHEIGHT: Number = 40
            val BACKWIDTH: Number = 32
            var statusBarHeight: Number = 0
            var nviBarHeight: Number = 0
            val navigatorbarRef = ref<UniElement?>(null)
            val searchbarRef = ref<UniElement?>(null)
            val titleRef = ref<UniElement?>(null)
            val seatbarRef = ref<UniElement?>(null)
            fun gen_onScroll_fn(e: ScrollEvent) {
                var offset = if (e.detail.scrollTop > SEARCHBARHEIGHT) {
                    SEARCHBARHEIGHT
                } else {
                    e.detail.scrollTop
                }
                navigatorbarRef.value?.style?.setProperty("height", (nviBarHeight - offset) + "px")
                titleRef.value?.style?.setProperty("opacity", (1 - offset / SEARCHBARHEIGHT).toString(10))
                searchbarRef.value?.style?.setProperty("left", (if ((offset < 0)) {
                    0
                } else {
                    BACKWIDTH * offset / SEARCHBARHEIGHT
                }
                ) + "px")
            }
            val onScroll = ::gen_onScroll_fn
            fun gen_search_fn() {
                uni_showToast(ShowToastOptions(title = "暂不支持", icon = "none"))
            }
            val search = ::gen_search_fn
            fun gen_setStyle_fn() {
                navigatorbarRef.value?.style?.setProperty("padding-top", statusBarHeight + "px")
                navigatorbarRef.value?.style?.setProperty("height", (NAVIBARHEIGHT + statusBarHeight) + "px")
                seatbarRef.value?.style?.setProperty("height", (NAVIBARHEIGHT + statusBarHeight) + "px")
            }
            val setStyle = ::gen_setStyle_fn
            onLoad(fun(_options){
                statusBarHeight = uni_getWindowInfo().statusBarHeight
                nviBarHeight = NAVIBARHEIGHT + statusBarHeight
            }
            )
            onReady(fun(){
                setStyle()
            }
            )
            onResize(fun(event: OnResizeOptions){
                statusBarHeight = uni_getWindowInfo().statusBarHeight
                nviBarHeight = NAVIBARHEIGHT + statusBarHeight
                setStyle()
            }
            )
            return fun(): Any? {
                val _component_uni_back_arrow_circle = resolveEasyComponent("uni-back-arrow-circle", GenComponentsUniBackArrowCircleUniBackArrowCircleClass)
                return _cE("scroll-view", _uM("onScroll" to onScroll, "class" to "page", "show-scrollbar" to "false"), _uA(
                    _cE("view", _uM("ref_key" to "seatbarRef", "ref" to seatbarRef, "class" to "seatbar"), null, 512),
                    _cE("view", _uM("class" to "content"), _uA(
                        _cE("view", _uM("class" to "content-item"), _uA(
                            _cE("text", _uM("class" to "text"), "1. 当前示例监听了 scroll-view 的 scroll 事件 ，滚动页面实时监听scrollTop。"),
                            _cE("text", _uM("class" to "text"), "2. 使用 ref 直接获取元素的节点，并在 scroll 事件中通过节点的 setProperty 方法来修改搜索导航栏的高度、位置和背景颜色等样式，从而达到滚动折叠的效果。"),
                            _cE("text", _uM("class" to "text"), "3. 请向上\\向下滚动页面观察效果。")
                        )),
                        _cE(Fragment, null, RenderHelpers.renderList(20, fun(item, index, __index, _cached): Any {
                            return _cE("view", _uM("class" to "content-item", "key" to index), _uA(
                                _cE("text", _uM("class" to "text"), "content-" + _tD(item), 1)
                            ))
                        }
                        ), 64)
                    )),
                    _cE("view", _uM("ref_key" to "navigatorbarRef", "ref" to navigatorbarRef, "class" to "navigatorbar"), _uA(
                        _cE("view", _uM("class" to "titlebar"), _uA(
                            _cV(_component_uni_back_arrow_circle, _uM("style" to _nS(_uM("background-color" to "transparent")), "arrow-class" to "arrow"), null, 8, _uA(
                                "style"
                            )),
                            _cE("text", _uM("ref_key" to "titleRef", "ref" to titleRef, "class" to "title"), "DCloud 为开发者而生", 512)
                        )),
                        _cE("view", _uM("ref_key" to "searchbarRef", "ref" to searchbarRef, "class" to "searchbar", "onClick" to search), _uA(
                            _cE("image", _uM("class" to "searchimg", "src" to "/static/template/scroll-fold-nav/search.png", "mode" to "widthFix")),
                            _cE("text", _uM("class" to "searchinput"), "请输入你要搜索的内容"),
                            _cE("text", _uM("class" to "searchbutton"), "搜索")
                        ), 512)
                    ), 512)
                ), 32)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("page" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "backgroundColor" to "#f5f5f5")), "navigatorbar" to _pS(_uM("position" to "fixed", "paddingTop" to 35, "height" to 124, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#efefef", "width" to "100%", "backgroundColor" to "#f5f5f5")), "titlebar" to _pS(_uM("flexDirection" to "row", "alignItems" to "center", "height" to 44)), "arrow" to _pS(_uM("!borderLeftWidth" to 2, "!borderLeftStyle" to "solid", "!borderLeftColor" to "#555555", "!borderBottomWidth" to 2, "!borderBottomStyle" to "solid", "!borderBottomColor" to "#555555")), "title" to _pS(_uM("marginTop" to 0, "marginRight" to 2, "marginBottom" to 0, "marginLeft" to 2)), "searchbar" to _pS(_uM("position" to "absolute", "bottom" to 2, "left" to 0, "right" to 0, "backgroundColor" to "#FFFFFF", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#fbdf0d", "borderRightColor" to "#fbdf0d", "borderBottomColor" to "#fbdf0d", "borderLeftColor" to "#fbdf0d", "height" to 32, "borderTopLeftRadius" to 100, "borderTopRightRadius" to 100, "borderBottomRightRadius" to 100, "borderBottomLeftRadius" to 100, "marginTop" to 6, "marginRight" to 12, "marginBottom" to 6, "marginLeft" to 12, "paddingTop" to 8, "paddingRight" to 8, "paddingBottom" to 8, "paddingLeft" to 8, "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center")), "searchimg" to _pS(_uM("width" to 15)), "searchinput" to _pS(_uM("flexGrow" to 1, "fontSize" to 12, "color" to "#666666")), "searchbutton" to _pS(_uM("fontSize" to 12, "backgroundColor" to "#ff6900", "color" to "#FFFFFF", "paddingTop" to 5, "paddingRight" to 8, "paddingBottom" to 5, "paddingLeft" to 8, "borderTopLeftRadius" to 100, "borderTopRightRadius" to 100, "borderBottomRightRadius" to 100, "borderBottomLeftRadius" to 100)), "seatbar" to _pS(_uM("height" to 124)), "content" to _pS(_uM("paddingTop" to 5, "paddingRight" to 15, "paddingBottom" to 5, "paddingLeft" to 15)), "content-item" to _pS(_uM("paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15, "marginTop" to 5, "marginRight" to 0, "marginBottom" to 5, "marginLeft" to 0, "backgroundColor" to "#ffffff", "borderTopLeftRadius" to 5, "borderTopRightRadius" to 5, "borderBottomRightRadius" to 5, "borderBottomLeftRadius" to 5)), "text" to _pS(_uM("fontSize" to 14, "color" to "#666666", "lineHeight" to "20px")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
