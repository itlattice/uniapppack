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
import io.dcloud.uniapp.extapi.`$off` as uni__off
import io.dcloud.uniapp.extapi.`$on` as uni__on
import io.dcloud.uniapp.extapi.showModal as uni_showModal
open class GenPagesTemplateCustomTabBarCustomTabBar : BasePage {
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
        var setup: (__props: GenPagesTemplateCustomTabBarCustomTabBar) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesTemplateCustomTabBarCustomTabBar
            val _cache = __ins.renderCache
            val tabview = ref<UniElement?>(null)
            val tab1Ref = ref<ComponentPublicInstance?>(null)
            val tab2Ref = ref<ComponentPublicInstance?>(null)
            val tabList = ref(_uA<TabItem>(TabItem(init = true, preload = false), TabItem(init = false, preload = false)))
            val selectedIndex = ref(0)
            val displayArrow = ref(false)
            var lastTab1Top: Number = 0
            var tabViewHeight: Number = 0
            fun gen_setSelectedIndex_fn(index: Number) {
                if (selectedIndex.value === index) {
                    return
                }
                if (!tabList.value[index].init) {
                    tabList.value[index].init = true
                }
                selectedIndex.value = index
            }
            val setSelectedIndex = ::gen_setSelectedIndex_fn
            fun gen_onTabClick_fn(index: Number) {
                if (selectedIndex.value == index && index == 0 && displayArrow.value == true) {
                    displayArrow.value = false
                    val tab1Instance = tab1Ref.value
                    if (tab1Instance != null) {
                        tab1Instance.`$callMethod`("scrollTop", 0)
                    }
                } else if (index != 0) {
                    displayArrow.value = false
                } else if (index == 0 && selectedIndex.value != 0) {
                    displayArrow.value = lastTab1Top > tabViewHeight
                }
                setSelectedIndex(index)
            }
            val onTabClick = ::gen_onTabClick_fn
            fun gen_onTabPageEvent_fn(top: Number) {
                displayArrow.value = top > tabViewHeight
                lastTab1Top = top
            }
            val onTabPageEvent = ::gen_onTabPageEvent_fn
            fun gen_onPlusClick_fn() {
                uni_showModal(ShowModalOptions(title = "提示", content = "你点击了 +", showCancel = false))
            }
            val onPlusClick = ::gen_onPlusClick_fn
            onLoad(fun(_options){
                uni__on("tabchange", onTabPageEvent)
            }
            )
            onReady(fun(){
                val tabviewElement = tabview.value
                if (tabviewElement != null) {
                    tabviewElement.getBoundingClientRectAsync()!!.then(fun(res: DOMRect){
                        tabViewHeight = res.height
                    }
                    )
                }
            }
            )
            onUnload(fun(){
                uni__off("tabchange", onTabPageEvent)
            }
            )
            return fun(): Any? {
                return _cE("view", _uM("class" to "tabs"), _uA(
                    _cE("view", _uM("ref_key" to "tabview", "ref" to tabview, "class" to "tab-view"), _uA(
                        if (isTrue(unref(tabList)[0].init)) {
                            _cV(unref(GenPagesTemplateCustomTabBarCustomTabBarTab1Class), _uM("key" to 0, "ref_key" to "tab1Ref", "ref" to tab1Ref, "class" to "tab-page", "style" to _nS(_uM("visibility" to if (unref(selectedIndex) == 0) {
                                "visible"
                            } else {
                                "hidden"
                            }))), null, 8, _uA(
                                "style"
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        if (isTrue(unref(tabList)[1].init)) {
                            _cV(unref(GenPagesTemplateCustomTabBarCustomTabBarTab2Class), _uM("key" to 1, "ref_key" to "tab2Ref", "ref" to tab2Ref, "class" to "tab-page", "style" to _nS(_uM("visibility" to if (unref(selectedIndex) == 1) {
                                "visible"
                            } else {
                                "hidden"
                            }))), null, 8, _uA(
                                "style"
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                    ), 512),
                    _cE("view", _uM("ref" to "tabbar", "class" to "tab-bar"), _uA(
                        _cE("view", _uM("class" to "tab-item", "onClick" to fun(){
                            onTabClick(0)
                        }
                        ), _uA(
                            _cE("view", _uM("ref" to "tab-item1", "class" to "tab-item-content"), _uA(
                                if (isTrue(unref(displayArrow))) {
                                    _cE("text", _uM("key" to 0, "class" to _nC(_uA(
                                        "tab-item-icon tab-item-arrow uni-icon",
                                        if (unref(selectedIndex) == 0) {
                                            "tab-item-text-active"
                                        } else {
                                            ""
                                        }
                                    ))), _tD("\ue6bd"), 2)
                                } else {
                                    _cC("v-if", true)
                                }
                                ,
                                if (isTrue(!unref(displayArrow))) {
                                    _cE("text", _uM("key" to 1, "class" to _nC(_uA(
                                        "tab-item-icon uni-icon",
                                        if (unref(selectedIndex) == 0) {
                                            "tab-item-text-active"
                                        } else {
                                            ""
                                        }
                                    ))), _tD("\ue644"), 2)
                                } else {
                                    _cC("v-if", true)
                                }
                                ,
                                if (isTrue(!unref(displayArrow))) {
                                    _cE("text", _uM("key" to 2, "class" to _nC(_uA(
                                        "tab-item-text",
                                        if (unref(selectedIndex) == 0) {
                                            "tab-item-text-active"
                                        } else {
                                            ""
                                        }
                                    ))), " 首页 ", 2)
                                } else {
                                    _cC("v-if", true)
                                }
                            ), 512)
                        ), 8, _uA(
                            "onClick"
                        )),
                        _cE("view", null, _uA(
                            _cE("image", _uM("class" to "concave-image", "mode" to "heightFix", "src" to "/static/template/custom-tab-bar/concave.png"))
                        )),
                        _cE("view", _uM("class" to "tab-item", "onClick" to fun(){
                            onTabClick(1)
                        }
                        ), _uA(
                            _cE("view", _uM("ref" to "tab-item2", "class" to "tab-item-content"), _uA(
                                _cE("text", _uM("class" to _nC(_uA(
                                    "tab-item-icon uni-icon",
                                    if (unref(selectedIndex) == 1) {
                                        "tab-item-text-active"
                                    } else {
                                        ""
                                    }
                                ))), _tD("\ue699"), 2),
                                _cE("text", _uM("class" to _nC(_uA(
                                    "tab-item-text",
                                    if (unref(selectedIndex) == 1) {
                                        "tab-item-text-active"
                                    } else {
                                        ""
                                    }
                                ))), " 我的 ", 2)
                            ), 512)
                        ), 8, _uA(
                            "onClick"
                        ))
                    ), 512),
                    _cE("view", _uM("class" to "btn-plus", "onClick" to onPlusClick), _uA(
                        _cE("text", _uM("class" to "btn-plus-text"), "+")
                    ))
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
                return _uM("uni-icon" to _pS(_uM("fontFamily" to "UniFontFamily", "fontSize" to 16, "fontStyle" to "normal")), "tabs" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "backgroundColor" to "#ffffff", "overflow" to "visible")), "tab-view" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "tab-page" to _pS(_uM("position" to "absolute", "width" to "100%", "height" to "100%")), "tab-bar" to _pS(_uM("flexDirection" to "row", "height" to 56, "overflow" to "visible")), "tab-item" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "position" to "relative", "backgroundColor" to "#1e90ff", "overflow" to "visible")), "tab-item-content" to _pS(_uM("marginTop" to "auto", "marginRight" to "auto", "marginBottom" to "auto", "marginLeft" to "auto", "transitionProperty" to "transform", "transitionDuration" to "0.3s")), "tab-item-icon" to _pS(_uM("color" to "#cccccc", "fontSize" to 12, "textAlign" to "center", "marginBottom" to 4)), "tab-item-text" to _pS(_uM("color" to "#cccccc", "fontSize" to 12, "textAlign" to "center")), "tab-item-text-active" to _pS(_uM("color" to "#ffffff")), "tab-item-arrow" to _pS(_uM("!fontSize" to 30, "fontWeight" to "bold")), "concave-image" to _pS(_uM("height" to 56)), "btn-plus" to _pS(_uM("position" to "absolute", "width" to 70, "height" to 70, "bottom" to 21, "borderTopLeftRadius" to 50, "borderTopRightRadius" to 50, "borderBottomRightRadius" to 50, "borderBottomLeftRadius" to 50, "backgroundColor" to "#FE5722", "boxShadow" to "0 0 4px rgba(0, 0, 0, 0.5)", "alignSelf" to "center", "alignItems" to "center", "justifyContent" to "center", "overflow" to "visible")), "btn-plus-text" to _pS(_uM("color" to "#ffffff", "fontSize" to 32)), "@FONT-FACE" to _uM("0" to _uM("fontFamily" to "UniFontFamily", "src" to "url('/static/font/uni.ttf')")), "@TRANSITION" to _uM("tab-item-content" to _uM("property" to "transform", "duration" to "0.3s")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
