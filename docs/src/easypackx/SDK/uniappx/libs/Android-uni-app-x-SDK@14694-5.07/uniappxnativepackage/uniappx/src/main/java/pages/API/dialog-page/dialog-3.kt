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
open class GenPagesAPIDialogPageDialog3 : BasePage {
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
        var setup: (__props: GenPagesAPIDialogPageDialog3) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIDialogPageDialog3
            val _cache = __ins.renderCache
            val currentPage = getCurrentInstance()?.proxy?.`$page`
            val title = ref("dialog 3")
            val currentPageStyle = ref(_uO())
            val closeAnimationType = ref("auto" as CloseAnimationType)
            val closeAnimationTypeList = _uA(
                "auto",
                "none",
                "slide-out-right",
                "slide-out-left",
                "slide-out-top",
                "slide-out-bottom",
                "fade-out",
                "zoom-in",
                "zoom-fade-in"
            )
            fun gen_getPageStyle_fn() {
                if (currentPage != null) {
                    currentPageStyle.value = currentPage.getPageStyle()
                }
            }
            val getPageStyle = ::gen_getPageStyle_fn
            fun gen_setPageStyle_fn(style: UTSJSONObject) {
                if (currentPage != null) {
                    currentPage.setPageStyle(style)
                }
            }
            val setPageStyle = ::gen_setPageStyle_fn
            onLoad(fun(_: OnLoadOptions){
                getPageStyle()
            }
            )
            fun gen_setStyleValue_fn(key: String, value: Any) {
                val style: UTSJSONObject = _uO()
                style[key] = value
                setPageStyle(style)
                getPageStyle()
            }
            val setStyleValue = ::gen_setStyleValue_fn
            fun gen_radioChange_fn(key: String, e: RadioGroupChangeEvent) {
                setStyleValue(key, e.detail.value)
            }
            val radioChange = ::gen_radioChange_fn
            fun gen_sliderChange_fn(key: String, e: UniSliderChangeEvent) {
                setStyleValue(key, e.detail.value)
            }
            val sliderChange = ::gen_sliderChange_fn
            fun gen_switchChange_fn(key: String, e: UniSwitchChangeEvent) {
                setStyleValue(key, e.detail.value)
            }
            val switchChange = ::gen_switchChange_fn
            fun gen_handleChooseAnimationType_fn(e: RadioGroupChangeEvent) {
                closeAnimationType.value = e.detail.value as CloseAnimationType
            }
            val handleChooseAnimationType = ::gen_handleChooseAnimationType_fn
            fun gen_closeThisDialog_fn() {
                if (currentPage != null) {
                    uni_closeDialogPage(CloseDialogPageOptions(dialogPage = currentPage, animationType = closeAnimationType.value, success = fun(res) {
                        console.log("closeDialog success", res)
                    }
                    , fail = fun(err) {
                        console.log("closeDialog fail", err)
                    }
                    , complete = fun(res) {
                        console.log("closeDialog complete", res)
                    }
                    ))
                }
            }
            val closeThisDialog = ::gen_closeThisDialog_fn
            return fun(): Any? {
                val _component_switch = resolveComponent("switch")
                val _component_slider = resolveComponent("slider")
                val _component_radio = resolveComponent("radio")
                val _component_radio_group = resolveComponent("radio-group")
                return _cE("view", _uM("id" to "dialog3", "class" to "dialog-container"), _uA(
                    _cE("scroll-view", _uM("class" to "dialog-content"), _uA(
                        _cE("text", null, "title: " + _tD(unref(title)), 1),
                        _cE(Fragment, null, RenderHelpers.renderList(unref(PageStyleArray__1), fun(item, index, __index, _cached): Any {
                            return _cE(Fragment, null, _uA(
                                if (unref(currentPageStyle)[item.key] != null) {
                                    _cE("view", _uM("class" to "page-style-item", "key" to index), _uA(
                                        _cE("view", _uM("class" to "item-text"), _uA(
                                            _cE("text", _uM("class" to "item-text-key"), _tD(item.key) + ":", 1),
                                            _cE("text", _uM("class" to "item-text-value"), _tD(unref(currentPageStyle)[item.key]), 1)
                                        )),
                                        if (item.type == "boolean") {
                                            _cE("view", _uM("key" to 0, "class" to "mt-10"), _uA(
                                                _cV(_component_switch, _uM("checked" to unref(currentPageStyle).getBoolean(item.key), "onChange" to fun(`$event`: Any){
                                                    switchChange(item.key, `$event` as UniSwitchChangeEvent)
                                                }), null, 8, _uA(
                                                    "checked",
                                                    "onChange"
                                                ))
                                            ))
                                        } else {
                                            if (item.type == "number") {
                                                _cE("view", _uM("key" to 1, "class" to "mt-10"), _uA(
                                                    _cV(_component_slider, _uM("value" to unref(currentPageStyle).getNumber(item.key), "show-value" to true, "onChange" to fun(`$event`: Any){
                                                        sliderChange(item.key, `$event` as UniSliderChangeEvent)
                                                    }), null, 8, _uA(
                                                        "value",
                                                        "onChange"
                                                    ))
                                                ))
                                            } else {
                                                if (item.type == "string") {
                                                    _cE("view", _uM("key" to 2, "class" to "mt-10"), _uA(
                                                        _cV(_component_radio_group, _uM("class" to "radio-set-value", "onChange" to fun(`$event`: Any){
                                                            radioChange(item.key, `$event` as RadioGroupChangeEvent)
                                                        }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                            return _uA(
                                                                _cE(Fragment, null, RenderHelpers.renderList(item.value, fun(item2, index2, __index, _cached): Any {
                                                                    return _cV(_component_radio, _uM("class" to "ml-10", "key" to index2, "value" to item2, "checked" to (unref(currentPageStyle)[item.key] == item2)), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                        return _uA(
                                                                            _tD(item2)
                                                                        )
                                                                    }), "_" to 2), 1032, _uA(
                                                                        "value",
                                                                        "checked"
                                                                    ))
                                                                }), 128)
                                                            )
                                                        }), "_" to 2), 1032, _uA(
                                                            "onChange"
                                                        ))
                                                    ))
                                                } else {
                                                    _cC("v-if", true)
                                                }
                                            }
                                        }
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                            ), 64)
                        }
                        ), 256),
                        _cE("text", _uM("class" to "mt-10 choose-close-animation-type-title"), "choose close dialogPage animationType"),
                        _cV(_component_radio_group, _uM("class" to "choose-close-animation-type-radio-group", "onChange" to handleChooseAnimationType), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(closeAnimationTypeList, fun(item, __key, __index, _cached): Any {
                                    return _cV(_component_radio, _uM("class" to "ml-10 mt-10", "key" to item, "value" to item, "checked" to (unref(closeAnimationType) == item)), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(item)
                                        )
                                    }
                                    ), "_" to 2), 1032, _uA(
                                        "value",
                                        "checked"
                                    ))
                                }
                                ), 64)
                            )
                        }
                        ), "_" to 1)),
                        _cE("button", _uM("class" to "mt-10", "onClick" to closeThisDialog), " closeThisDialog ")
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
                return _uM("dialog-container" to _pS(_uM("width" to "100%", "height" to "100%", "backgroundColor" to "rgba(0,0,0,0.3)", "display" to "flex", "justifyContent" to "center", "alignItems" to "center")), "dialog-content" to _pS(_uM("width" to "90%", "height" to 500, "paddingTop" to 10, "paddingRight" to 6, "paddingBottom" to 10, "paddingLeft" to 6, "backgroundColor" to "#ffffff", "borderTopLeftRadius" to 6, "borderTopRightRadius" to 6, "borderBottomRightRadius" to 6, "borderBottomLeftRadius" to 6)), "mt-10" to _pS(_uM("marginTop" to 10)), "ml-10" to _pS(_uM("marginLeft" to 10)), "page-style-item" to _pS(_uM("paddingTop" to 6, "paddingRight" to 0, "paddingBottom" to 6, "paddingLeft" to 0, "marginTop" to 10, "backgroundColor" to "#ffffff", "borderTopLeftRadius" to 5, "borderTopRightRadius" to 5, "borderBottomRightRadius" to 5, "borderBottomLeftRadius" to 5)), "item-text" to _pS(_uM("flexDirection" to "row")), "item-text-key" to _pS(_uM("fontWeight" to "bold")), "item-text-value" to _pS(_uM("marginLeft" to 5)), "radio-set-value" to _pS(_uM("flexDirection" to "row")), "choose-close-animation-type-title" to _pS(_uM("fontWeight" to "bold")), "choose-close-animation-type-radio-group" to _pS(_uM("flexDirection" to "row", "flexWrap" to "wrap")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
