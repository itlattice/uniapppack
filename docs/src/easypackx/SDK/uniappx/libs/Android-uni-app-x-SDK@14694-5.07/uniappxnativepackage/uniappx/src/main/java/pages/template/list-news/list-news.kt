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
import io.dcloud.uniapp.extapi.getDeviceInfo as uni_getDeviceInfo
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
import io.dcloud.uniapp.extapi.request as uni_request
import io.dcloud.uniapp.extapi.showModal as uni_showModal
open class GenPagesTemplateListNewsListNews : BasePage {
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
        var setup: (__props: GenPagesTemplateListNewsListNews) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesTemplateListNewsListNews
            val _cache = __ins.renderCache
            val th_item = ref(_uA(
                "排序",
                "筛选"
            ))
            val refresherTriggered = ref(false)
            var banner = ref(_uO())
            val listData = ref(_uA<Item__11>())
            val isWideScreen = ref(false)
            val currentIndex = ref(0)
            val post_id = ref("")
            val cover = ref("")
            val title = ref("")
            val firstDetailContent = ref("")
            fun gen_checkScreenWidth_fn() {
                val windowWidth = uni_getWindowInfo().windowWidth
                val deviceType = uni_getDeviceInfo(null).deviceType
                isWideScreen.value = deviceType === "pad" || windowWidth > 700
            }
            val checkScreenWidth = ::gen_checkScreenWidth_fn
            fun gen_getBanner_fn() {
                var data: UTSJSONObject = _uO("column" to "post_id,title,cover")
                uni_request<Any>(RequestOptions(url = "https://unidemo.dcloud.net.cn/api/banner/36kr", data = data, success = fun(data){
                    refresherTriggered.value = false
                    if (data.statusCode == 200) {
                        banner.value = data.data as UTSJSONObject
                    }
                }
                , fail = fun(e){
                    console.log("fail", e)
                }
                ))
            }
            val getBanner = ::gen_getBanner_fn
            fun gen_goDetail_fn(e: Item__11, key: Number) {
                currentIndex.value = key
                val detail = e
                post_id.value = detail.post_id
                cover.value = detail.cover
                title.value = detail.title
                if (!isWideScreen.value) {
                    cover.value = btoa(cover.value)
                    uni_navigateTo(NavigateToOptions(url = "/pages/template/list-news/detail/detail?post_id=" + post_id.value + "&cover=" + cover.value + "&title=" + title.value + "&shareKey=image_" + key))
                }
            }
            val goDetail = ::gen_goDetail_fn
            fun gen_getList_fn() {
                var url = "https://unidemo.dcloud.net.cn/api/news?column=id,post_id,title,author_name,cover,published_at"
                uni_request<UTSArray<Item__11>>(RequestOptions(url = url, method = "GET", success = fun(res){
                    if (res.statusCode == 200) {
                        val result = res.data
                        if (result != null) {
                            listData.value = result
                            if (isWideScreen.value && listData.value.length > 0) {
                                goDetail(listData.value[0], 0)
                                val first = listData.value[0]
                                uni_request<Any>(RequestOptions(url = "https://unidemo.dcloud.net.cn/api/news/36kr/" + first.post_id, success = fun(res){
                                    if (res.statusCode == 200) {
                                        val result = res.data as UTSJSONObject
                                        firstDetailContent.value = result["content"] as String
                                    }
                                }
                                ))
                            }
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
            fun gen_bannerClick_fn(e: UTSJSONObject) {
                val post_id_val = e["post_id"] as String
                var cover_val = e["cover"] as String
                cover_val = btoa(cover_val)
                val title_val = e["title"]
                uni_navigateTo(NavigateToOptions(url = "/pages/template/list-news/detail/detail?post_id=" + post_id_val + "&cover=" + cover_val + "&title=" + title_val))
            }
            val bannerClick = ::gen_bannerClick_fn
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
            val currentDetailContent = computed(fun(): String {
                if (isWideScreen.value && listData.value.length > 0 && post_id.value === listData.value[0].post_id && firstDetailContent.value !== "") {
                    return firstDetailContent.value
                }
                return ""
            }
            )
            val isDarkMode = computed(fun(): Boolean {
                return state.isDarkMode
            }
            )
            onLoad(fun(_options){
                checkScreenWidth()
                getBanner()
                getList()
            }
            )
            onResize(fun(_options){
                checkScreenWidth()
            }
            )
            return fun(): Any? {
                return _cE("view", _uM("class" to _nC(_uA(
                    "uni-container",
                    _uM("flex-row" to unref(isWideScreen)),
                    if (unref(isDarkMode)) {
                        "theme-dark"
                    } else {
                        "theme-light"
                    }
                )), "style" to _nS(_uM("flex" to "1", "padding" to "0px"))), _uA(
                    _cE("list-view", _uM("class" to _nC(_uA(
                        "list-container",
                        _uM("list-narrow" to unref(isWideScreen))
                    )), "refresher-enabled" to "", "onRefresherrefresh" to onRefresherrefresh, "refresher-triggered" to unref(refresherTriggered), "enable-back-to-top" to ""), _uA(
                        _cE("list-item", _uM("class" to "banner", "onClick" to fun(){
                            bannerClick(unref(banner))
                        }
                        ), _uA(
                            _cE("image", _uM("class" to "banner-img", "src" to unref(banner)["cover"]), null, 8, _uA(
                                "src"
                            )),
                            _cE("text", _uM("class" to "banner-title"), _tD(unref(banner)["title"]), 1)
                        ), 8, _uA(
                            "onClick"
                        )),
                        _cE("sticky-section", null, _uA(
                            _cE("sticky-header", null, _uA(
                                _cE("view", _uM("class" to "th-item"), _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(unref(th_item), fun(name, index, __index, _cached): Any {
                                        return _cE("text", _uM("key" to index, "onClick" to fun(){
                                            clickTH(index)
                                        }
                                        , "class" to "th-item-text"), _tD(name), 9, _uA(
                                            "onClick"
                                        ))
                                    }
                                    ), 128)
                                ))
                            )),
                            _cE(Fragment, null, RenderHelpers.renderList(unref(listData), fun(value, index, __index, _cached): Any {
                                return _cE("list-item", _uM("key" to index, "type" to "2"), _uA(
                                    _cE("view", _uM("class" to "uni-list-cell", "hover-class" to "uni-list-cell-hover", "onClick" to fun(){
                                        goDetail(value, index)
                                    }
                                    ), _uA(
                                        _cE("view", _uM("class" to "uni-media-list"), _uA(
                                            if (isTrue(unref(isWideScreen))) {
                                                _cE("image", _uM("key" to 0, "class" to "uni-media-list-logo", "src" to value.cover), null, 8, _uA(
                                                    "src"
                                                ))
                                            } else {
                                                _cE("share-element", _uM("key" to 1, "share-key" to ("image_" + index)), _uA(
                                                    _cE("image", _uM("class" to "uni-media-list-logo", "src" to value.cover), null, 8, _uA(
                                                        "src"
                                                    ))
                                                ), 8, _uA(
                                                    "share-key"
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
                                    ), 8, _uA(
                                        "onClick"
                                    ))
                                ))
                            }
                            ), 128)
                        ))
                    ), 42, _uA(
                        "refresher-triggered"
                    )),
                    if (isTrue(unref(isWideScreen))) {
                        _cE("view", _uM("key" to 0, "class" to "detail-container"), _uA(
                            if (isTrue(unref(post_id) != "" && unref(title) != "" && unref(cover) != "")) {
                                _cV(unref(GenPagesTemplateListNewsDetailDetailClass), _uM("key" to unref(post_id), "post_id" to unref(post_id), "cover" to unref(cover), "title" to unref(title), "isWideScreen" to unref(isWideScreen), "firstDetailContent" to unref(currentDetailContent)), null, 8, _uA(
                                    "post_id",
                                    "cover",
                                    "title",
                                    "isWideScreen",
                                    "firstDetailContent"
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                        ))
                    } else {
                        _cC("v-if", true)
                    }
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
                return _uM("flex-row" to _pS(_uM("flexDirection" to "row")), "list-container" to _pS(_uM("width" to "100%", "backgroundColor" to "var(--list-background-color,#ffffff)", "flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "list-narrow" to _pS(_uM("width" to 100)), "th-item" to _pS(_uM("width" to "100%", "height" to 44, "backgroundColor" to "var(--list-background-color,#ffffff)", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center")), "th-item-text" to _pS(_uM("marginRight" to 20, "color" to "var(--text-color,#333333)")), "detail-container" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "minWidth" to 0, "paddingTop" to 20, "paddingRight" to 20, "paddingBottom" to 20, "paddingLeft" to 20, "backgroundColor" to "var(--background-color,#f8f8f8)")), "banner" to _pS(_uM("height" to 180, "overflow" to "hidden", "position" to "relative", "backgroundColor" to "var(--background-color,#f8f8f8)")), "banner-img" to _pS(_uM("width" to "100%")), "banner-title" to _pS(_uM("maxHeight" to 42, "overflow" to "hidden", "position" to "absolute", "left" to 15, "bottom" to 15, "width" to "90%", "fontSize" to 16, "fontWeight" to "400", "lineHeight" to "21px", "color" to "#FFFFFF")), "uni-media-list" to _pS(_uM("paddingTop" to 11, "paddingRight" to 15, "paddingBottom" to 11, "paddingLeft" to 15, "boxSizing" to "border-box", "display" to "flex", "width" to "100%", "flexDirection" to "row")), "uni-media-list-logo" to _pS(_uM("width" to 90, "height" to 70)), "uni-media-list-body" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "paddingLeft" to 7, "justifyContent" to "space-around")), "uni-media-list-text-top" to _pS(_uM("fontSize" to 14, "lines" to 2, "overflow" to "hidden", "color" to "var(--text-color,#333333)")), "uni-media-list-text-bottom" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between")), "uni-media-list-text" to _pS(_uM("color" to "#9D9D9F", "fontSize" to 13)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
