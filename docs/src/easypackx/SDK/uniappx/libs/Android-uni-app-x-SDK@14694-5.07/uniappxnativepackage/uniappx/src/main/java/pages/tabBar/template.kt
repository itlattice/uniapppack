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
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
import io.dcloud.uniapp.extapi.reLaunch as uni_reLaunch
import io.dcloud.uniapp.extapi.request as uni_request
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesTabBarTemplate : BasePage {
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
        var setup: (__props: GenPagesTabBarTemplate) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesTabBarTemplate
            val _cache = __ins.renderCache
            val activeIndex = inject<Ref<Number>>("tabBarCurrentIndex", ref(0))
            val instance = getCurrentInstance()?.proxy
            val list = ref<UTSArray<ListItem>>(_uA<ListItem>(ListItem(id = "long-list", url = "long-list", name = "左右滑动长列表", open = false, enable = true, pages = _uA<Page__1>(Page__1(name = "顶部banner长列表（嵌套滚动）", url = "long-list-nested"), Page__1(name = "顶部banner瀑布流长列表（嵌套滚动）", url = "long-waterflow-nested"), Page__1(name = "顶部搜索框随时下移长列表", url = "long-list"))), ListItem(id = "list-news", url = "list-news", name = "列表到详情（吸顶）", open = false, pages = _uA<Page__1>()), ListItem(id = "long-list-deleteable", url = "long-list-deleteable", name = "带删除的不等高长列表", open = false, pages = _uA<Page__1>()), ListItem(id = "long-list-batch", url = "long-list-batch", name = "分批加载长列表", open = false, pages = _uA<Page__1>()), ListItem(id = "custom-long-list", url = "custom-long-list", name = "回收复用长列表", open = false, pages = _uA<Page__1>()), ListItem(id = "swiper-list", url = "swiper-list", name = "swiper-list", open = false, pages = _uA<Page__1>(Page__1(name = "下划线样式", url = "swiper-list"), Page__1(name = "字体放大样式", url = "swiper-list2"))), ListItem(id = "scroll-fold-nav", url = "scroll-fold-nav", name = "随滚动折叠的导航栏", open = false, pages = _uA<Page__1>()), ListItem(id = "pull-zoom-image", url = "pull-zoom-image", name = "下拉缩放顶部封面图", open = false, pages = _uA<Page__1>()), ListItem(id = "scroll-sticky", url = "scroll-sticky", name = "scroll-view自定义滚动吸顶", open = false, pages = _uA<Page__1>()), ListItem(id = "navbar-lite", url = "navbar-lite", name = "自定义导航栏", open = false, pages = _uA<Page__1>()), ListItem(id = "nav-transparent", url = "nav-transparent", name = "自定义透明渐变导航栏", open = false, pages = _uA<Page__1>()), ListItem(id = "custom-tab-bar", url = "custom-tab-bar", name = "自定义TabBar", open = false, enable = true, pages = _uA<Page__1>()), ListItem(id = "swiper-vertical-video", url = "swiper-vertical-video", name = "竖滑视频", open = false, pages = _uA<Page__1>()), ListItem(id = "ai-chat", url = "ai-chat", name = "ai-chat聊天示例", open = false, pages = _uA<Page__1>()), ListItem(id = "half-screen", url = "half-screen", name = "半屏弹窗", open = false, pages = _uA<Page__1>()), ListItem(id = "drop-card", url = "drop-card", name = "划走式卡片", open = false, pages = _uA<Page__1>()), ListItem(id = "calendar", url = "calendar", name = "日历", open = false, pages = _uA<Page__1>()), ListItem(id = "schema", url = "schema", name = "打开外部链接", open = false, pages = _uA<Page__1>()), ListItem(id = "about", url = "about", name = "关于", open = false, pages = _uA<Page__1>())))
            val arrowUpIcon = ref("/static/icons/arrow-up.png")
            val arrowDownIcon = ref("/static/icons/arrow-down.png")
            val arrowRightIcon = ref("/static/icons/arrow-right.png")
            val hasLeftWin = computed(fun(): Boolean {
                return !state.noMatchLeftWindow
            }
            )
            val leftWinActive = computed(fun(): String {
                return state.leftWinActive.split("/")[3]
            }
            )
            val isDarkMode = computed(fun(): Boolean {
                return state.isDarkMode
            }
            )
            val netless = computed(fun(): Boolean {
                return state.netless
            }
            )
            fun gen_goDetailPage_fn(e: Page__1) {
                if (e.enable == false) {
                    uni_showToast(ShowToastOptions(icon = "none", title = "暂不支持"))
                    return
                }
                val url = if (e.url.indexOf("platform") > -1) {
                    e.url
                } else {
                    "/pages/template/" + e.url + "/" + e.url
                }
                if (hasLeftWin.value) {
                    uni_reLaunch(ReLaunchOptions(url = url))
                } else {
                    uni_navigateTo(NavigateToOptions(url = url, fail = fun(_) {
                        console.log("页面跳转失败：" + url)
                    }
                    ))
                }
            }
            val goDetailPage = ::gen_goDetailPage_fn
            fun gen_triggerCollapse_fn(index: Number, item: ListItem) {
                if (item.pages.length == 0) {
                    val page = Page__1(name = item.name, enable = item.enable, url = item.url!!)
                    goDetailPage(page)
                    return
                }
                run {
                    var i: Number = 0
                    while(i < list.value.length){
                        if (index == i) {
                            list.value[i].open = !list.value[i].open
                        } else {
                            list.value[i].open = false
                        }
                        ++i
                    }
                }
            }
            val triggerCollapse = ::gen_triggerCollapse_fn
            onMounted(fun(){
                uni_request<Any>(RequestOptions(url = "https://unidemo.dcloud.net.cn", method = "HEAD", success = fun(res){
                    console.log("预热网络成功", res)
                }
                , fail = fun(err){
                    console.log("预热网络失败", err)
                }
                ))
            }
            )
            return fun(): Any? {
                val _component_u_link = resolveEasyComponent("u-link", GenComponentsULinkULinkClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1")), "enable-back-to-top" to "true"), _uA(
                    _cE("view", _uM("class" to _nC(_uA(
                        "uni-container",
                        if (unref(isDarkMode)) {
                            "theme-dark"
                        } else {
                            "theme-light"
                        }
                    ))), _uA(
                        if (isTrue(!unref(hasLeftWin))) {
                            _cE("view", _uM("key" to 0, "class" to "uni-header-logo"), _uA(
                                _cE("image", _uM("class" to "uni-header-image", "src" to "/static/templateIndex.png"))
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        if (isTrue(!unref(hasLeftWin))) {
                            _cE("view", _uM("key" to 1, "class" to "uni-text-box"), _uA(
                                _cE("text", _uM("class" to "hello-text"), "以下是部分模板示例，更多模板见插件市场："),
                                _cV(_component_u_link, _uM("class" to "hello-text", "href" to "https://ext.dcloud.net.cn", "text" to "https://ext.dcloud.net.cn", "inWhiteList" to true), null, 8, _uA(
                                    "text"
                                ))
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        _cE(Fragment, null, RenderHelpers.renderList(unref(list), fun(item, index, __index, _cached): Any {
                            return _cE("view", _uM("class" to "uni-panel", "key" to item.id), _uA(
                                _cE("view", _uM("hover-class" to "is--active", "class" to "uni-panel-h", "onClick" to fun(){
                                    triggerCollapse(index, item)
                                }
                                ), _uA(
                                    _cE("text", _uM("class" to _nC(_uA(
                                        "uni-panel-text",
                                        if (item.enable == false || item.open == true) {
                                            "text-disabled"
                                        } else {
                                            ""
                                        }
                                        ,
                                        if (item.url == unref(leftWinActive) && item.pages.length == 0) {
                                            "left-win-active"
                                        } else {
                                            ""
                                        }
                                    ))), _tD(item.name), 3),
                                    _cE("image", _uM("src" to if (item.pages.length > 0) {
                                        if (item.open) {
                                            unref(arrowUpIcon)
                                        } else {
                                            unref(arrowDownIcon)
                                        }
                                    } else {
                                        unref(arrowRightIcon)
                                    }
                                    , "class" to "uni-icon-size"), null, 8, _uA(
                                        "src"
                                    ))
                                ), 8, _uA(
                                    "onClick"
                                )),
                                if (isTrue(item.open)) {
                                    _cE("view", _uM("key" to 0), _uA(
                                        _cE(Fragment, null, RenderHelpers.renderList(item.pages, fun(page, key, __index, _cached): Any {
                                            return _cE("view", _uM("style" to _nS(_uM("padding-left" to "18px")), "class" to "uni-navigate-item", "hover-class" to if (page.enable == false) {
                                                ""
                                            } else {
                                                "is--active"
                                            }, "key" to key, "onClick" to fun(){
                                                goDetailPage(page)
                                            }), _uA(
                                                _cE("text", _uM("class" to _nC(_uA(
                                                    "uni-navigate-text",
                                                    _uM("left-win-active" to (unref(leftWinActive) === page.url && unref(hasLeftWin)), "text-disabled" to (page.enable == false))
                                                ))), _tD(page.name), 3),
                                                _cE("image", _uM("src" to unref(arrowRightIcon), "class" to "uni-icon-size"), null, 8, _uA(
                                                    "src"
                                                ))
                                            ), 12, _uA(
                                                "hover-class",
                                                "onClick"
                                            ))
                                        }), 128)
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                            ))
                        }
                        ), 128)
                    ), 2)
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
                return _uM("uni-panel-h" to _pS(_uM("paddingTop" to 12, "paddingRight" to 18, "paddingBottom" to 12, "paddingLeft" to 18)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
