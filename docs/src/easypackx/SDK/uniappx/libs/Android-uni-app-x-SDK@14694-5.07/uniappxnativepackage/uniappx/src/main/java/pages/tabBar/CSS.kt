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
open class GenPagesTabBarCSS : BasePage {
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
        var setup: (__props: GenPagesTabBarCSS) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesTabBarCSS
            val _cache = __ins.renderCache
            val activeIndex = inject<Ref<Number>>("tabBarCurrentIndex", ref(0))
            val instance = getCurrentInstance()!!.proxy!!
            val menuData = generateMenu("pages/CSS")
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
            val isDarkMode = computed(fun(): Boolean {
                return state.isDarkMode
            }
            )
            fun gen_goPage_fn(url: String) {
                if (hasLeftWin.value) {
                    uni_reLaunch(ReLaunchOptions(url = url))
                } else {
                    uni_navigateTo(NavigateToOptions(url = url))
                }
            }
            val goPage = ::gen_goPage_fn
            return fun(): Any? {
                val _component_u_link = resolveEasyComponent("u-link", GenComponentsULinkULinkClass)
                val _component_uni_collapse_item = resolveEasyComponent("uni-collapse-item", GenComponentsUniCollapseItemUniCollapseItemClass)
                val _component_uni_collapse = resolveEasyComponent("uni-collapse", GenComponentsUniCollapseUniCollapseClass)
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
                                _cE("image", _uM("class" to "uni-header-image", "src" to "/static/cssIndex.png"))
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        if (isTrue(!unref(hasLeftWin))) {
                            _cE("view", _uM("key" to 1, "class" to "uni-text-box"), _uA(
                                _cE("text", _uM("class" to "hello-text"), "uni-app x App平台支持的CSS，文档详见："),
                                _cV(_component_u_link, _uM("class" to "hello-text", "href" to "https://doc.dcloud.net.cn/uni-app-x/css/", "text" to "https://doc.dcloud.net.cn/uni-app-x/css/", "inWhiteList" to true), null, 8, _uA(
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
                                                        _cE("view", _uM("key" to 0, "class" to "uni-navigate-item pl", "hover-class" to "is--active", "onClick" to fun(){
                                                            goPage("/" + childMenuItem.path)
                                                        }), _uA(
                                                            _cE("text", _uM("class" to _nC(_uA(
                                                                "uni-navigate-text",
                                                                _uM("left-win-active" to (unref(leftWinActive) === childMenuItem.path && unref(hasLeftWin)))
                                                            ))), _tD(childMenuItem.style["navigationBarTitleText"]), 3),
                                                            _cE("image", _uM("src" to unref(arrowRightIcon), "class" to "uni-icon-size"), null, 8, _uA(
                                                                "src"
                                                            ))
                                                        ), 8, _uA(
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
                        ), "_" to 1))
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
                return _uM("pl" to _pS(_uM("paddingLeft" to 18)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
