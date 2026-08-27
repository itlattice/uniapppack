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
import io.dcloud.uniapp.extapi.request as uni_request
import io.dcloud.uniapp.extapi.showModal as uni_showModal
open class GenPagesTemplateNavTransparentNavTransparent : BasePage {
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
        var setup: (__props: GenPagesTemplateNavTransparentNavTransparent) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesTemplateNavTransparentNavTransparent
            val _cache = __ins.renderCache
            val th_item = ref(_uA(
                "排序",
                "筛选"
            ))
            val refresherTriggered = ref(false)
            val banner = ref(Banner())
            val listData = ref(_uA<Item__10>())
            val isWideScreen = ref(false)
            val currentIndex = ref(0)
            val post_id = ref("")
            val cover = ref("")
            val title = ref("")
            val firstDetailContent = ref("")
            val navbar = ref<UniElement?>(null)
            var backBackgroundColor = ref<String>("rgba(255, 255, 255, 1)")
            val textRef = ref<UniElement?>(null)
            val arrowClass = ref("arrow-gray")
            fun gen_getBanner_fn() {
                var data: UTSJSONObject = _uO("column" to "id,post_id,title,author_name,cover,published_at")
                uni_request<Banner>(RequestOptions(url = "https://unidemo.dcloud.net.cn/api/banner/36kr", data = data, success = fun(data){
                    refresherTriggered.value = false
                    if (data.statusCode == 200) {
                        val result = data.data
                        if (result != null) {
                            banner.value = result
                        }
                    }
                }
                , fail = fun(e){
                    console.log("fail", e)
                }
                ))
            }
            val getBanner = ::gen_getBanner_fn
            fun gen_getList_fn() {
                var url = "https://unidemo.dcloud.net.cn/api/news?column=id,post_id,title,author_name,cover,published_at"
                uni_request<UTSArray<Item__10>>(RequestOptions(url = url, method = "GET", success = fun(res){
                    if (res.statusCode == 200) {
                        val result = res.data
                        if (result != null) {
                            listData.value = result
                        }
                        refresherTriggered.value = false
                    }
                }
                , fail = fun(res){
                    console.log("fail", res)
                    refresherTriggered.value = false
                }
                ))
            }
            val getList = ::gen_getList_fn
            fun gen_clickTH_fn(index: Number) {
                uni_showModal(ShowModalOptions(content = "点击表头项：" + index, showCancel = false))
            }
            val clickTH = ::gen_clickTH_fn
            fun gen_onRefresherrefresh_fn() {
                refresherTriggered.value = true
                getBanner()
                getList()
            }
            val onRefresherrefresh = ::gen_onRefresherrefresh_fn
            fun gen_contentScroll_fn(event: UniScrollEvent) {
                val top = event.detail.scrollTop
                val THRESHOLD: Number = 100
                var transparent_count = parseFloat((top / THRESHOLD).toFixed(2))
                if (transparent_count >= 1) {
                    transparent_count = 1
                    arrowClass.value = "arrow-white"
                } else {
                    arrowClass.value = "arrow-gray"
                }
                navbar.value!!.style.setProperty("background-color", "rgba(0, 122, 255," + transparent_count + ")")
                backBackgroundColor.value = "rgba(255, 255, 255," + (1 - transparent_count) + ")"
                textRef.value!!.style.setProperty("opacity", transparent_count.toString(10))
            }
            val contentScroll = ::gen_contentScroll_fn
            val isDarkMode = computed(fun(): Boolean {
                return state.isDarkMode
            }
            )
            onLoad(fun(_options){
                getBanner()
                getList()
            }
            )
            onReady(fun(){})
            return fun(): Any? {
                val _component_uni_back_arrow_circle = resolveEasyComponent("uni-back-arrow-circle", GenComponentsUniBackArrowCircleUniBackArrowCircleClass)
                return _cE("view", _uM("class" to _nC(_uA(
                    "uni-container",
                    if (unref(isDarkMode)) {
                        "theme-dark"
                    } else {
                        "theme-light"
                    }
                )), "style" to _nS(_uM("flex" to "1", "padding" to "0px"))), _uA(
                    _cE("view", _uM("ref_key" to "navbar", "ref" to navbar, "class" to "custom-navbar"), _uA(
                        _cE("view", _uM("class" to "status-bar")),
                        _cE("view", _uM("class" to "custom-navbar-inner"), _uA(
                            _cV(_component_uni_back_arrow_circle, _uM("style" to _nS(_uM("backgroundColor" to unref(backBackgroundColor))), "arrow-class" to unref(arrowClass)), null, 8, _uA(
                                "style",
                                "arrow-class"
                            )),
                            _cE("view", _uM("class" to "custom-navbar-content"), _uA(
                                _cE("text", _uM("ref_key" to "textRef", "ref" to textRef, "class" to "content-inner-text"), " 标题 ", 512)
                            ))
                        ))
                    ), 512),
                    _cE("scroll-view", _uM("class" to "list-container", "direction" to "vertical", "refresher-enabled" to "true", "onRefresherrefresh" to onRefresherrefresh, "refresher-triggered" to unref(refresherTriggered), "onScroll" to contentScroll), _uA(
                        _cE("view", _uM("class" to "banner"), _uA(
                            _cE("image", _uM("class" to "banner-img", "src" to unref(banner).cover), null, 8, _uA(
                                "src"
                            )),
                            _cE("text", _uM("class" to "banner-title"), _tD(unref(banner).title), 1)
                        )),
                        _cE(Fragment, null, RenderHelpers.renderList(unref(listData), fun(value, index, __index, _cached): Any {
                            return _cE("view", _uM("key" to index, "class" to "uni-list-cell", "hover-class" to "uni-list-cell-hover"), _uA(
                                _cE("view", _uM("class" to "uni-media-list"), _uA(
                                    if (isTrue(unref(isWideScreen))) {
                                        _cE("image", _uM("key" to 0, "class" to "uni-media-list-logo", "src" to value.cover), null, 8, _uA(
                                            "src"
                                        ))
                                    } else {
                                        _cE("image", _uM("key" to 1, "class" to "uni-media-list-logo", "src" to value.cover), null, 8, _uA(
                                            "src"
                                        ))
                                    }
                                    ,
                                    _cE("view", _uM("class" to "uni-media-list-body"), _uA(
                                        _cE("text", _uM("class" to "uni-media-list-text-top"), _tD(value.title), 1),
                                        _cE("view", _uM("class" to "uni-media-list-text-bottom"), _uA(
                                            _cE("text", _uM("class" to "uni-media-list-text"), _tD(value.author_name), 1),
                                            _cE("text", _uM("class" to "uni-media-list-text"), _tD(value.published_at), 1)
                                        ))
                                    ))
                                ))
                            ))
                        }
                        ), 128)
                    ), 40, _uA(
                        "refresher-triggered"
                    ))
                ), 6)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("list-container" to _pS(_uM("position" to "relative", "width" to "100%", "backgroundColor" to "var(--list-background-color, #ffffff)", "flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "th-item" to _pS(_uM("width" to "100%", "height" to 44, "backgroundColor" to "var(--list-background-color, #ffffff)", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center")), "th-item-text" to _pS(_uM("marginRight" to 20, "color" to "var(--text-color, #333333)")), "banner" to _pS(_uM("height" to 180, "overflow" to "hidden", "position" to "relative", "backgroundColor" to "var(--background-color, #f8f8f8)")), "banner-img" to _pS(_uM("width" to "100%")), "banner-title" to _pS(_uM("maxHeight" to 42, "overflow" to "hidden", "position" to "absolute", "left" to 15, "bottom" to 15, "width" to "90%", "fontSize" to 16, "fontWeight" to "400", "lineHeight" to "21px", "color" to "#FFFFFF")), "uni-media-list" to _pS(_uM("paddingTop" to 11, "paddingRight" to 15, "paddingBottom" to 11, "paddingLeft" to 15, "boxSizing" to "border-box", "display" to "flex", "width" to "100%", "flexDirection" to "row")), "uni-media-list-logo" to _pS(_uM("width" to 90, "height" to 70)), "uni-media-list-body" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "paddingLeft" to 7, "justifyContent" to "space-around")), "uni-media-list-text-top" to _pS(_uM("fontSize" to 14, "overflow" to "hidden", "color" to "var(--text-color, #333333)")), "uni-media-list-text-bottom" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between")), "uni-media-list-text" to _pS(_uM("color" to "#9D9D9F", "fontSize" to 13)), "status-bar" to _pS(_uM("height" to CSS_VAR_STATUS_BAR_HEIGHT)), "custom-navbar" to _pS(_uM("position" to "absolute", "top" to 0, "left" to 0, "right" to 0, "zIndex" to 10, "backgroundColor" to "rgba(0,122,255,0)")), "custom-navbar-inner" to _pS(_uM("position" to "relative", "flexDirection" to "row", "justifyContent" to "space-between", "height" to 45)), "arrow-gray" to _pS(_uM("!borderLeftColor" to "#999999", "!borderBottomColor" to "#999999")), "arrow-white" to _pS(_uM("!borderLeftColor" to "#FFFFFF", "!borderBottomColor" to "#FFFFFF")), "custom-navbar-content" to _pS(_uM("position" to "absolute", "height" to "100%", "top" to 0, "bottom" to 0, "left" to 45, "right" to 45, "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center")), "content-inner-text" to _pS(_uM("opacity" to 0, "color" to "#f5f5f5")), "list-tab" to _pS(_uM("position" to "relative", "zIndex" to 9)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
