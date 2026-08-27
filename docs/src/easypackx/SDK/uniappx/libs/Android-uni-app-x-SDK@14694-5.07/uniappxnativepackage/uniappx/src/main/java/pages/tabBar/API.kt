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
import io.dcloud.uniapp.extapi.closeDialogPage as uni_closeDialogPage
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
import io.dcloud.uniapp.extapi.openDialogPage as uni_openDialogPage
import io.dcloud.uniapp.extapi.reLaunch as uni_reLaunch
open class GenPagesTabBarAPI : BasePage {
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
    open var testOpenDialogPage: () -> Unit
        get() {
            return unref(this.`$exposed`["testOpenDialogPage"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "testOpenDialogPage", value)
        }
    open var testCloseDialogPage: () -> Unit
        get() {
            return unref(this.`$exposed`["testCloseDialogPage"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "testCloseDialogPage", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesTabBarAPI, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesTabBarAPI
            val _cache = __ins.renderCache
            val activeIndex = inject<Ref<Number>>("tabBarCurrentIndex", ref(0))
            val instance = getCurrentInstance()!!.proxy!!
            val menuData = generateMenu("pages/API")
            val popRef = ref<UniElement?>(null)
            val categoryRef = ref<UTSArray<ComponentPublicInstance>?>(null)
            val menu = ref(menuData as UTSArray<MenuItem>)
            val arrowRightIcon = ref("/static/icons/arrow-right.png")
            val hasLeftWin = computed(fun(): Boolean {
                return !state.noMatchLeftWindow
            }
            )
            val leftWinActive = computed(fun(): String {
                return state.leftWinActive.slice(1)
            }
            )
            val windowWidth = computed(fun(): Number {
                return uni_getWindowInfo().windowWidth
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
            fun gen_showPop_fn() {
                val popElement = popRef.value
                if (popElement != null) {
                    popElement.style.setProperty("display", "flex")
                }
            }
            val showPop = ::gen_showPop_fn
            fun gen_goPage_fn(url: String) {
                if (url == "/set-tab-bar") {
                    showPop()
                } else {
                    if (hasLeftWin.value) {
                        uni_reLaunch(ReLaunchOptions(url = url))
                    } else {
                        uni_navigateTo(NavigateToOptions(url = url))
                    }
                }
            }
            val goPage = ::gen_goPage_fn
            fun gen_hidePop_fn() {
                val popElement = popRef.value
                if (popElement != null) {
                    popElement.style.setProperty("display", "none")
                }
            }
            val hidePop = ::gen_hidePop_fn
            fun gen_stopClickPop_fn(e: PointerEvent) {
                e.stopPropagation()
            }
            val stopClickPop = ::gen_stopClickPop_fn
            fun gen_stopPropagation_fn() {}
            val stopPropagation = ::gen_stopPropagation_fn
            val testOpenDialogPage = fun(){
                uni_openDialogPage(OpenDialogPageOptions(url = "/pages/API/dialog-page/dialog-5"))
            }
            val testCloseDialogPage = fun(){
                uni_closeDialogPage(null)
            }
            __expose(_uM("testOpenDialogPage" to testOpenDialogPage, "testCloseDialogPage" to testCloseDialogPage))
            return fun(): Any? {
                val _component_u_link = resolveEasyComponent("u-link", GenComponentsULinkULinkClass)
                val _component_uni_collapse_item = resolveEasyComponent("uni-collapse-item", GenComponentsUniCollapseItemUniCollapseItemClass)
                val _component_uni_collapse = resolveEasyComponent("uni-collapse", GenComponentsUniCollapseUniCollapseClass)
                val _component_api_set_tabbar = resolveEasyComponent("api-set-tabbar", GenComponentsApiSetTabbarApiSetTabbarClass)
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
                                _cE("image", _uM("class" to "uni-header-image", "src" to "/static/apiIndex.png"))
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        if (isTrue(!unref(hasLeftWin))) {
                            _cE("view", _uM("key" to 1, "class" to "uni-text-box"), _uA(
                                _cE("text", _uM("class" to "hello-text"), "以下将演示uni-app x接口能力，详细文档见："),
                                _cV(_component_u_link, _uM("class" to "hello-text", "href" to "https://doc.dcloud.net.cn/uni-app-x/api/", "text" to "https://doc.dcloud.net.cn/uni-app-x/api/", "inWhiteList" to true), null, 8, _uA(
                                    "href",
                                    "text"
                                ))
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        _cV(_component_uni_collapse, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(unref(menu), fun(menuItem, __key, __index, _cached): Any {
                                    return _cV(_component_uni_collapse_item, _uM("ref_for" to true, "ref_key" to "categoryRef", "ref" to categoryRef, "key" to menuItem.id, "title" to menuItem.name, "class" to "uni-panel"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cE(Fragment, null, RenderHelpers.renderList(menuItem.items, fun(childMenuItem, __key, __index, _cached): Any {
                                                return _cE(Fragment, _uM("key" to childMenuItem.id), _uA(
                                                    if (childMenuItem.items.length == 0) {
                                                        _cE("view", _uM("key" to 0, "class" to _nC(_uA(
                                                            "pl",
                                                            _uM("uni-navigate-item" to (childMenuItem.path !== "set-tab-bar" || unref(windowWidth) <= 768))
                                                        )), "hover-class" to "is--active", "onClick" to fun(){
                                                            goPage("/" + childMenuItem.path)
                                                        }), _uA(
                                                            if (isTrue(childMenuItem.path !== "set-tab-bar" || unref(windowWidth) <= 768)) {
                                                                _cE(Fragment, _uM("key" to 0), _uA(
                                                                    _cE("text", _uM("class" to _nC(_uA(
                                                                        "uni-navigate-text",
                                                                        _uM("left-win-active" to (unref(leftWinActive) === childMenuItem.path && unref(hasLeftWin)))
                                                                    ))), _tD(childMenuItem.style["navigationBarTitleText"]), 3),
                                                                    _cE("image", _uM("src" to unref(arrowRightIcon), "class" to "uni-icon-size"), null, 8, _uA(
                                                                        "src"
                                                                    ))
                                                                ), 64)
                                                            } else {
                                                                _cC("v-if", true)
                                                            }
                                                        ), 10, _uA(
                                                            "onClick"
                                                        ))
                                                    } else {
                                                        _cV(_component_uni_collapse, _uM("key" to 1, "style" to _nS(_uM("width" to "100%", "border-top" to "1px solid #f0f0f0"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                            return _uA(
                                                                _cV(_component_uni_collapse_item, _uM("title" to childMenuItem.name, "class" to "uni-panel", "style" to _nS(_uM("margin-bottom" to "0"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                    return _uA(
                                                                        _cE(Fragment, null, RenderHelpers.renderList(childMenuItem.items, fun(grandChildMenuItem, __key, __index, _cached): Any {
                                                                            return _cE("view", _uM("class" to "uni-navigate-item pl", "hover-class" to "is--active", "key" to grandChildMenuItem.path, "onClick" to fun(){
                                                                                goPage("/" + grandChildMenuItem.path)
                                                                            }
                                                                            ), _uA(
                                                                                _cE("text", _uM("class" to _nC(_uA(
                                                                                    "uni-navigate-text",
                                                                                    _uM("left-win-active" to (unref(leftWinActive) === grandChildMenuItem.path && unref(hasLeftWin)))
                                                                                ))), _tD(grandChildMenuItem.style["navigationBarTitleText"]), 3),
                                                                                _cE("image", _uM("src" to unref(arrowRightIcon), "class" to "uni-icon-size"), null, 8, _uA(
                                                                                    "src"
                                                                                ))
                                                                            ), 8, _uA(
                                                                                "onClick"
                                                                            ))
                                                                        }
                                                                        ), 128)
                                                                    )
                                                                }
                                                                ), "_" to 2), 1032, _uA(
                                                                    "title",
                                                                    "style"
                                                                ))
                                                            )
                                                        }
                                                        ), "_" to 2), 1032, _uA(
                                                            "style"
                                                        ))
                                                    }
                                                ), 64)
                                            }
                                            ), 128)
                                        )
                                    }
                                    ), "_" to 2), 1032, _uA(
                                        "title"
                                    ))
                                }
                                ), 128)
                            )
                        }
                        ), "_" to 1)),
                        if (isTrue(!unref(hasLeftWin))) {
                            _cE("view", _uM("key" to 2, "ref_key" to "popRef", "ref" to popRef, "onClick" to fun(){
                                hidePop()
                            }, "class" to "popup"), _uA(
                                _cE("view", _uM("style" to _nS(_uM("width" to "90%", "background-color" to "white")), "onClick" to withModifiers(stopClickPop, _uA(
                                    "stop"
                                ))), _uA(
                                    _cV(_component_api_set_tabbar)
                                ), 4)
                            ), 8, _uA(
                                "onClick"
                            ))
                        } else {
                            _cC("v-if", true)
                        }
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
                return _uM("pl" to _pS(_uM("paddingLeft" to 18)), "popup" to _pS(_uM("position" to "fixed", "top" to 0, "bottom" to 0, "left" to 0, "right" to 0, "alignItems" to "center", "justifyContent" to "center", "display" to "none", "backgroundColor" to "rgba(16,16,16,0.5)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
