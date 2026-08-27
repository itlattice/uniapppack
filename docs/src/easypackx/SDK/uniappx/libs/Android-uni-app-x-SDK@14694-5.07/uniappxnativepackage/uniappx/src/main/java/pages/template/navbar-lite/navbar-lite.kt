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
import io.dcloud.uniapp.extapi.setNavigationBarColor as uni_setNavigationBarColor
open class GenPagesTemplateNavbarLiteNavbarLite : BasePage {
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
    open var getLifeCycleNum: () -> Number
        get() {
            return unref(this.`$exposed`["getLifeCycleNum"]) as () -> Number
        }
        set(value) {
            setRefValue(this.`$exposed`, "getLifeCycleNum", value)
        }
    open var setLifeCycleNum: (num: Number) -> Unit
        get() {
            return unref(this.`$exposed`["setLifeCycleNum"]) as (num: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setLifeCycleNum", value)
        }
    open var setNavigationBarColor1: () -> Unit
        get() {
            return unref(this.`$exposed`["setNavigationBarColor1"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setNavigationBarColor1", value)
        }
    open var setNavigationBarColor2: () -> Unit
        get() {
            return unref(this.`$exposed`["setNavigationBarColor2"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setNavigationBarColor2", value)
        }
    open var data: UTSJSONObject
        get() {
            return unref(this.`$exposed`["data"]) as UTSJSONObject
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesTemplateNavbarLiteNavbarLite, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesTemplateNavbarLiteNavbarLite
            val _cache = __ins.renderCache
            val currentPage = getCurrentInstance()?.proxy?.`$page`
            val title = ref("Hello uni-app")
            val isLeft = ref(false)
            val navigationBarTextColor = ref("#000")
            val data = reactive(_uO("indexView" to 0, "scrollViewInputFocus" to false, "listViewInputFocus" to false))
            val inputBottom = ref("0px")
            fun gen_onClick_fn() {
                isLeft.value = !isLeft.value
            }
            val onClick = ::gen_onClick_fn
            fun gen_setLifeCycleNum_fn(num: Number) {
                uni.UNIHelloUniAppX.setLifeCycleNum(num)
            }
            val setLifeCycleNum__1 = ::gen_setLifeCycleNum_fn
            fun gen_setNavigationBarColor1_fn() {
                uni_setNavigationBarColor(SetNavigationBarColorOptions(frontColor = "#ffffff", backgroundColor = "#0000", success = fun(_){
                    navigationBarTextColor.value = "#fff"
                    console.log("setNavigationBarColor success")
                    setLifeCycleNum__1(state.lifeCycleNum + 1)
                }
                , fail = fun(_){
                    console.log("setNavigationBarColor fail")
                    setLifeCycleNum__1(state.lifeCycleNum - 1)
                }
                , complete = fun(_){
                    console.log("setNavigationBarColor complete")
                    setLifeCycleNum__1(state.lifeCycleNum + 1)
                }
                ))
            }
            val setNavigationBarColor1 = ::gen_setNavigationBarColor1_fn
            fun gen_setNavigationBarColor2_fn() {
                uni_setNavigationBarColor(SetNavigationBarColorOptions(frontColor = "#000000", backgroundColor = "#0000", success = fun(_){
                    navigationBarTextColor.value = "#000"
                    console.log("setNavigationBarColor success")
                    setLifeCycleNum__1(state.lifeCycleNum + 1)
                }
                , fail = fun(_){
                    console.log("setNavigationBarColor fail")
                    setLifeCycleNum__1(state.lifeCycleNum - 1)
                }
                , complete = fun(_){
                    console.log("setNavigationBarColor complete")
                    setLifeCycleNum__1(state.lifeCycleNum + 1)
                }
                ))
            }
            val setNavigationBarColor2 = ::gen_setNavigationBarColor2_fn
            fun gen_ChangeView_fn(e: UniRadioGroupChangeEvent) {
                data["indexView"] = parseInt(e.detail.value)
            }
            val ChangeView = ::gen_ChangeView_fn
            fun gen_onInputBlur_fn(event: UniInputBlurEvent) {
                inputBottom.value = "0px"
            }
            val onInputBlur = ::gen_onInputBlur_fn
            fun gen_onInputKeyboardChange_fn(e: UniInputKeyboardHeightChangeEvent) {
                var height = e.detail.height
                inputBottom.value = "" + height + "px"
            }
            val onInputKeyboardChange = ::gen_onInputKeyboardChange_fn
            fun gen_getLifeCycleNum_fn(): Number {
                return state.lifeCycleNum
            }
            val getLifeCycleNum = ::gen_getLifeCycleNum_fn
            __expose(_uM("getLifeCycleNum" to getLifeCycleNum, "setLifeCycleNum" to setLifeCycleNum__1, "setNavigationBarColor1" to setNavigationBarColor1, "setNavigationBarColor2" to setNavigationBarColor2, "data" to data))
            return fun(): Any? {
                val _component_uni_nav_bar = resolveEasyComponent("uni-nav-bar", GenUniModulesUniNavBarComponentsUniNavBarUniNavBarClass)
                val _component_radio = resolveComponent("radio")
                val _component_radio_group = resolveComponent("radio-group")
                val _component_web_view = resolveComponent("web-view")
                return _cE("view", _uM("class" to "content"), _uA(
                    _cV(_component_uni_nav_bar, _uM("title" to unref(title), "is-left" to unref(isLeft), "navigationBarTextStyle" to unref(navigationBarTextColor)), null, 8, _uA(
                        "title",
                        "is-left",
                        "navigationBarTextStyle"
                    )),
                    _cE("view", _uM("class" to "content-item", "onClick" to onClick), _uA(
                        _cE("text", null, "点击此处，将标题切换为" + _tD(if (unref(isLeft)) {
                            "居中"
                        } else {
                            "左侧"
                        }
                        ) + "显示", 1)
                    )),
                    _cE("view", _uM("class" to "content-item", "onClick" to setNavigationBarColor1), _uA(
                        _cE("text", null, "设置自定义导航栏前景色白色")
                    )),
                    _cE("view", _uM("class" to "content-item", "onClick" to setNavigationBarColor2), _uA(
                        _cE("text", null, "设置自定义导航栏前景色黑色")
                    )),
                    _cE("view", _uM("style" to _nS(_uM("align-items" to "center", "height" to "60px"))), _uA(
                        _cE("text", null, "测试输入框上推页面"),
                        _cV(_component_radio_group, _uM("onChange" to ChangeView, "style" to _nS(_uM("flex-direction" to "row"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cV(_component_radio, _uM("value" to "0", "checked" to true), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cE("text", null, "scroll-view")
                                    )
                                }
                                ), "_" to 1)),
                                _cV(_component_radio, _uM("value" to "1"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cE("text", null, "list-view")
                                    )
                                }
                                ), "_" to 1)),
                                _cV(_component_radio, _uM("value" to "2"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cE("text", null, "web-view")
                                    )
                                }
                                ), "_" to 1))
                            )
                        }
                        ), "_" to 1), 8, _uA(
                            "style"
                        ))
                    ), 4),
                    if (unref(data)["indexView"] == 0) {
                        _cE("scroll-view", _uM("key" to 0, "class" to "scroll-view", "refresher-enabled" to false), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(10, fun(item, __key, __index, _cached): Any {
                                return _cE("view", _uM("class" to "content-item"), _uA(
                                    _cE("view", _uM("class" to "cell-item"), _uA(
                                        _cE("text", _uM("class" to "text"), "内容：" + _tD(item), 1),
                                        _cE("input", _uM("class" to "text", "style" to _nS(_uM("margin-top" to "8px")), "placeholder" to "备注输入框:", "id" to ("input-in-scroll-view-" + item), "focus" to if (item === 5) {
                                            unref(data)["scrollViewInputFocus"]
                                        } else {
                                            false
                                        }), null, 12, _uA(
                                            "id",
                                            "focus"
                                        ))
                                    ))
                                ))
                            }), 64)
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    if (unref(data)["indexView"] == 1) {
                        _cE("list-view", _uM("key" to 1, "class" to "scroll-view"), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(10, fun(item, __key, __index, _cached): Any {
                                return _cE("list-item", _uM("class" to "content-item", "key" to item), _uA(
                                    _cE("view", _uM("class" to "cell-item"), _uA(
                                        _cE("text", _uM("class" to "text"), "列表项内容：" + _tD(item), 1),
                                        _cE("input", _uM("class" to "text", "style" to _nS(_uM("margin-top" to "8px")), "placeholder" to "备注输入框:", "id" to ("input-in-list-view-" + item), "focus" to if (item === 5) {
                                            unref(data)["listViewInputFocus"]
                                        } else {
                                            false
                                        }), null, 12, _uA(
                                            "id",
                                            "focus"
                                        ))
                                    ))
                                ))
                            }), 64)
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    if (unref(data)["indexView"] == 2) {
                        _cV(_component_web_view, _uM("key" to 2, "src" to "/hybrid/html/local.html", "id" to "webv", "class" to "scroll-view"))
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    _cE("view", _uM("class" to "bottomInput", "style" to _nS(_uM("bottom" to unref(inputBottom)))), _uA(
                        _cE("input", _uM("id" to "input", "style" to _nS(_uM("background-color" to "white")), "placeholder" to "滚动视图外底部输入框，焦点时手动控制显示位置", "adjust-position" to false, "onBlur" to onInputBlur, "onKeyboardheightchange" to onInputKeyboardChange), null, 36)
                    ), 4)
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
                return _uM("content" to _pS(_uM("display" to "flex", "flexDirection" to "column", "flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "scroll-view" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "backgroundColor" to "#f5f5f5", "paddingTop" to 5, "paddingRight" to 0, "paddingBottom" to 5, "paddingLeft" to 0)), "content-item" to _pS(_uM("paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15, "marginTop" to 5, "marginRight" to 10, "marginBottom" to 5, "marginLeft" to 10, "backgroundColor" to "#ffffff", "borderTopLeftRadius" to 5, "borderTopRightRadius" to 5, "borderBottomRightRadius" to 5, "borderBottomLeftRadius" to 5)), "cell-item" to _pS(_uM("display" to "flex", "flexDirection" to "column")), "text" to _pS(_uM("fontSize" to 14, "color" to "#666666")), "bottomInput" to _pS(_uM("position" to "relative", "zIndex" to 1000, "paddingTop" to 0, "paddingRight" to 5, "paddingBottom" to 0, "paddingLeft" to 5, "marginBottom" to "var(--uni-safe-area-inset-bottom)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
