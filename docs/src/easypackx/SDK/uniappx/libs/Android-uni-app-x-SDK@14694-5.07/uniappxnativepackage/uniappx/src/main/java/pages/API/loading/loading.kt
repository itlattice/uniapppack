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
import io.dcloud.uniapp.extapi.hideLoading as uni_hideLoading
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading
open class GenPagesAPILoadingLoading : BasePage {
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
    open var data: DataType__64
        get() {
            return unref(this.`$exposed`["data"]) as DataType__64
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var showLoading: () -> Unit
        get() {
            return unref(this.`$exposed`["showLoading"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "showLoading", value)
        }
    open var hideLoading: () -> Unit
        get() {
            return unref(this.`$exposed`["hideLoading"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "hideLoading", value)
        }
    open var closeSomeLoading: () -> Unit
        get() {
            return unref(this.`$exposed`["closeSomeLoading"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "closeSomeLoading", value)
        }
    open var noParamLoading: () -> Unit
        get() {
            return unref(this.`$exposed`["noParamLoading"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "noParamLoading", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPILoadingLoading, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPILoadingLoading
            val _cache = __ins.renderCache
            val data = reactive(DataType__64(title = "loading", items = _uA(
                ItemType__5(value = "null", name = "无标题"),
                ItemType__5(value = "三秒后自动关闭", name = "普通标题"),
                ItemType__5(value = "超长文本内容，测试超出范围-超长文本内容，测试超出范围-三秒后自动关闭", name = "长标题")
            ), callbackText = _uA<String>(), current = 0, titleSelect = "null", iosSpinner = true))
            val radioChange = fun(e: UniRadioGroupChangeEvent){
                val selected = data.items.find(fun(item): Boolean {
                    return item.value == e.detail.value
                }
                )
                if (selected != null) {
                    data.titleSelect = selected.value
                }
            }
            val hideLoading = fun(){
                uni_hideLoading(null)
            }
            val noParamLoading = fun(){
                uni_showLoading(null)
                uni_showLoading(ShowLoadingOptions(success = fun(showRet: ShowLoadingSuccess) {
                    data.callbackText.push("noParamLoading 1 success")
                }
                ))
                uni_showLoading(ShowLoadingOptions(complete = fun(showRet: Any) {
                    data.callbackText.push("noParamLoading 2 complete")
                }
                ))
                setTimeout(fun() {
                    uni_hideLoading(HideLoadingOptions(success = fun(ret: HideLoadingSuccess) {
                        data.callbackText.push("hide loading success")
                    }
                    ))
                }
                , 2000)
            }
            val closeSomeLoading = fun(){
                val loading1 = uni_showLoading(ShowLoadingOptions(title = "第一个loading", iosSpinner = data.iosSpinner, success = fun(res: ShowLoadingSuccess) {
                    data.callbackText.push("showLoading 1 success")
                    console.log("showLoading 1 success", res)
                }
                , fail = fun(res: ShowLoadingFail) {
                    data.callbackText.push("showLoading 1 fail")
                    console.log("showLoading 1 fail", res)
                }
                , complete = fun(res: Any) {
                    data.callbackText.push("showLoading 1 complete")
                    console.log("showLoading 1 complete", res)
                }
                ))
                val loading2 = uni_showLoading(ShowLoadingOptions(title = "第二个loading", iosSpinner = data.iosSpinner, success = fun(res: ShowLoadingSuccess) {
                    data.callbackText.push("showLoading 2 success")
                    console.log("showLoading 2 success", res)
                }
                , fail = fun(res: ShowLoadingFail) {
                    data.callbackText.push("showLoading 2 fail")
                    console.log("showLoading 2 fail", res)
                }
                , complete = fun(res: Any) {
                    data.callbackText.push("showLoading 2 complete")
                    console.log("showLoading 2 complete", res)
                }
                ))
                setTimeout(fun() {
                    uni_hideLoading(HideLoadingOptions(loadingPage = loading2, success = fun(res: HideLoadingSuccess) {
                        data.callbackText.push("hideLoading 2 success")
                        console.log("hideLoading 2 success", res)
                    }
                    , fail = fun(res: HideLoadingFail) {
                        data.callbackText.push("hideLoading 2 fail")
                        console.log("hideLoading 2 fail", res)
                    }
                    , complete = fun(res: Any) {
                        data.callbackText.push("hideLoading 2 complete")
                        console.log("hideLoading 2 complete", res)
                    }
                    ))
                }
                , 1000)
                setTimeout(fun() {
                    uni_hideLoading(HideLoadingOptions(loadingPage = loading1, success = fun(res: HideLoadingSuccess) {
                        data.callbackText.push("hideLoading 1 success")
                        console.log("hideLoading 1 success", res)
                    }
                    , fail = fun(res: HideLoadingFail) {
                        data.callbackText.push("hideLoading 1 fail")
                        console.log("hideLoading 1 fail", res)
                    }
                    , complete = fun(res: Any) {
                        data.callbackText.push("hideLoading 1 complete")
                        console.log("hideLoading 1 complete", res)
                    }
                    ))
                }
                , 3000)
            }
            val showLoading = fun(){
                console.log(data.titleSelect)
                if (data.titleSelect == "null") {
                    uni_showLoading(ShowLoadingOptions(title = "", iosSpinner = data.iosSpinner))
                } else {
                    uni_showLoading(ShowLoadingOptions(title = data.titleSelect, iosSpinner = data.iosSpinner))
                }
                setTimeout(fun(){
                    hideLoading()
                }
                , 3000)
            }
            onLoad(fun(_options){})
            __expose(_uM("data" to data, "showLoading" to showLoading, "hideLoading" to hideLoading, "closeSomeLoading" to closeSomeLoading, "noParamLoading" to noParamLoading))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                val _component_radio = resolveComponent("radio")
                val _component_radio_group = resolveComponent("radio-group")
                return _cE("view", null, _uA(
                    _cV(_component_page_head, _uM("title" to unref(data).title), null, 8, _uA(
                        "title"
                    )),
                    _cE("view", _uM("class" to "uni-list"), _uA(
                        _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                            _cE("view", _uM("class" to "uni-title uni-common-mt"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), " 设置标题 ")
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-list uni-common-pl"), _uA(
                            _cV(_component_radio_group, _uM("onChange" to radioChange), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(unref(data).items, fun(item, index, __index, _cached): Any {
                                        return _cV(_component_radio, _uM("class" to _nC(_uA(
                                            "uni-list-cell uni-list-cell-pd radio",
                                            if (index < unref(data).items.length - 1) {
                                                "uni-list-cell-line"
                                            } else {
                                                ""
                                            }
                                        )), "key" to item.value, "value" to item.value, "checked" to (index === unref(data).current)), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(item.name)
                                            )
                                        }
                                        ), "_" to 2), 1032, _uA(
                                            "class",
                                            "value",
                                            "checked"
                                        ))
                                    }
                                    ), 128)
                                )
                            }
                            ), "_" to 1))
                        ))
                    )),
                    _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                        _cE("view", _uM("class" to "uni-btn-v"), _uA(
                            _cE("button", _uM("type" to "primary", "onClick" to showLoading), "显示 loading 提示框"),
                            _cE("button", _uM("onClick" to hideLoading), "隐藏 loading 提示框"),
                            _cE("text", null, "为方便演示，loading弹出3秒后自动关闭")
                        ))
                    )),
                    _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                        _cE("text", null, _tD(unref(data).callbackText), 1),
                        _cE("view", _uM("class" to "uni-btn-v"), _uA(
                            _cE("button", _uM("type" to "primary", "onClick" to closeSomeLoading), "关闭指定loading"),
                            _cE("button", _uM("type" to "primary", "onClick" to noParamLoading), "无参数测试")
                        ))
                    ))
                ))
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
