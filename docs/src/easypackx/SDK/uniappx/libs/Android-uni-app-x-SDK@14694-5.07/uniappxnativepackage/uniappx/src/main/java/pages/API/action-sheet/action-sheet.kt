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
import io.dcloud.uniapp.extapi.getSystemInfoSync as uni_getSystemInfoSync
import io.dcloud.uniapp.extapi.hideActionSheet as uni_hideActionSheet
import io.dcloud.uniapp.extapi.navigateBack as uni_navigateBack
import io.dcloud.uniapp.extapi.setAppTheme as uni_setAppTheme
import io.dcloud.uniapp.extapi.showActionSheet as uni_showActionSheet
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesAPIActionSheetActionSheet : BasePage {
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
    open var data: DataType__62
        get() {
            return unref(this.`$exposed`["data"]) as DataType__62
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var setThemeAuto: () -> Unit
        get() {
            return unref(this.`$exposed`["setThemeAuto"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setThemeAuto", value)
        }
    open var resetTheme: () -> Unit
        get() {
            return unref(this.`$exposed`["resetTheme"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "resetTheme", value)
        }
    open var getLifeCycleNum: () -> Number
        get() {
            return unref(this.`$exposed`["getLifeCycleNum"]) as () -> Number
        }
        set(value) {
            setRefValue(this.`$exposed`, "getLifeCycleNum", value)
        }
    open var hideActionSheet: () -> Unit
        get() {
            return unref(this.`$exposed`["hideActionSheet"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "hideActionSheet", value)
        }
    open var setLifeCycleNumFunc: (num: Number) -> Unit
        get() {
            return unref(this.`$exposed`["setLifeCycleNumFunc"]) as (num: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setLifeCycleNumFunc", value)
        }
    open var showActionSheetAndNavigateBackInSuccessCallback: () -> Unit
        get() {
            return unref(this.`$exposed`["showActionSheetAndNavigateBackInSuccessCallback"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "showActionSheetAndNavigateBackInSuccessCallback", value)
        }
    open var showActionSheetAndShowAgainInCallback: () -> Unit
        get() {
            return unref(this.`$exposed`["showActionSheetAndShowAgainInCallback"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "showActionSheetAndShowAgainInCallback", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIActionSheetActionSheet, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIActionSheetActionSheet
            val _cache = __ins.renderCache
            val data = reactive(DataType__62(title = "action-sheet", titleColorCustom = false, itemColorCustom = false, itemContentLarge = false, itemNumLargeSelect = false, cancelTextCustom = false, cancelColorCustom = false, backgroundColorCustom = false, showErrorToast = true, items = _uA(
                ItemType__3(value = "标题", name = "有标题"),
                ItemType__3(value = "", name = "无标题"),
                ItemType__3(value = "超长标题测试内容，测试超过显示最大范围之后的样式-超长标题测试内容，测试超过显示最大范围之后的样式", name = "超长标题")
            ), current = 0, originTheme = null))
            val setThemeAuto = fun(){
                uni_setAppTheme(SetAppThemeOptions(theme = "auto"))
            }
            val resetTheme = fun(){
                val originTheme = data.originTheme
                if (originTheme != null) {
                    uni_setAppTheme(SetAppThemeOptions(theme = originTheme))
                }
            }
            val radioChange = fun(e: UniRadioGroupChangeEvent){
                run {
                    var i: Number = 0
                    while(i < data.items.length){
                        if (data.items[i].value === e.detail.value) {
                            data.current = i
                            break
                        }
                        i++
                    }
                }
            }
            val titleColorChange = fun(e: UniSwitchChangeEvent){
                data.titleColorCustom = e.detail.value
            }
            val itemContentLargeChange = fun(e: UniSwitchChangeEvent){
                data.itemContentLarge = e.detail.value
            }
            val itemColorChange = fun(e: UniSwitchChangeEvent){
                data.itemColorCustom = e.detail.value
            }
            val itemNumLargeChange = fun(e: UniSwitchChangeEvent){
                data.itemNumLargeSelect = e.detail.value
            }
            val cancelTextChange = fun(e: UniSwitchChangeEvent){
                data.cancelTextCustom = e.detail.value
            }
            val cancelColorChange = fun(e: UniSwitchChangeEvent){
                data.cancelColorCustom = e.detail.value
            }
            val backgroundColorChange = fun(e: UniSwitchChangeEvent){
                data.backgroundColorCustom = e.detail.value
            }
            val showActionSheet = fun(){
                val options = ShowActionSheetOptions(title = data.items[data.current].value, itemList = _uA(
                    "item1",
                    "item2",
                    "item3",
                    "item4"
                ), success = fun(res){
                    console.log(res.tapIndex)
                    uni_showToast(ShowToastOptions(title = "点击了第" + res.tapIndex + "个选项", icon = "none"))
                }
                , fail = fun(error){
                    if (data.showErrorToast) {
                        uni_showToast(ShowToastOptions(title = error.errMsg, icon = "none"))
                    }
                    console.log(error)
                }
                )
                if (data.itemContentLarge) {
                    options.itemList = _uA(
                        "两个黄鹂鸣翠柳，一行白鹭上青天。窗含西岭千秋雪，门泊东吴万里船",
                        "水光潋滟晴方好,山色空蒙雨亦奇。 欲把西湖比西子,淡妆浓抹总相宜",
                        ""
                    )
                }
                if (data.itemNumLargeSelect) {
                    val arr: UTSArray<String> = _uA()
                    run {
                        var i: Number = 0
                        while(i < 10){
                            arr.push("两个黄鹂鸣翠柳，一行白鹭上青天 " + (i + 1))
                            i++
                        }
                    }
                    options.itemList = arr
                }
                if (data.titleColorCustom) {
                    options.titleColor = "#007AFF"
                }
                if (data.itemColorCustom) {
                    options.itemColor = "#ff00ff"
                }
                if (data.cancelTextCustom) {
                    options.cancelText = "custom cancel"
                }
                if (data.cancelColorCustom) {
                    options.cancelColor = "#007AFF"
                }
                if (data.backgroundColorCustom) {
                    options.backgroundColor = "#ccc"
                }
                uni_showActionSheet(options)
            }
            val showActionSheetAndShowAgainInCallback = fun(){
                uni_showActionSheet(ShowActionSheetOptions(title = "第一个", itemList = _uA(
                    "1",
                    "2",
                    "3"
                ), complete = fun(_) {
                    uni_showActionSheet(ShowActionSheetOptions(title = "第二个", itemList = _uA(
                        "a",
                        "b",
                        "c"
                    ), complete = fun(res){
                        console.log("showActionSheetAndShowAgainInCallback complete", res)
                    }
                    ))
                }
                ))
            }
            val getLifeCycleNum = fun(): Number {
                return state.lifeCycleNum
            }
            val setLifeCycleNumFunc = fun(num: Number){
                return setLifeCycleNum(num)
            }
            val hideActionSheet = fun(){
                uni_hideActionSheet()
            }
            val showActionSheetAndNavigateBackInSuccessCallback = fun(){
                uni_showActionSheet(ShowActionSheetOptions(title = "showActionSheetAndNavigateBackInSuccessCallback", itemList = _uA(
                    "1",
                    "2",
                    "3"
                ), success = fun(res){
                    console.log("showActionSheetAndNavigateBackInSuccessCallback success", res)
                    setLifeCycleNum(state.lifeCycleNum + 1)
                    uni_navigateBack(null)
                }
                , fail = fun(error){
                    console.log("showActionSheetAndNavigateBackInSuccessCallback fail", error)
                }
                ))
            }
            onLoad(fun(_options){
                uni_showActionSheet(ShowActionSheetOptions(title = "onLoad 调用示例,请手动取消", itemList = _uA(
                    "item1",
                    "item2"
                ), fail = fun(res){
                    setLifeCycleNum(state.lifeCycleNum + 1)
                    console.log("onLoad showActionSheet fail", res)
                }
                , complete = fun(res){
                    setLifeCycleNum(state.lifeCycleNum + 1)
                    console.log("onLoad showActionSheet complete", res)
                }
                ))
                data.originTheme = uni_getSystemInfoSync().appTheme
            }
            )
            __expose(_uM("data" to data, "setThemeAuto" to setThemeAuto, "resetTheme" to resetTheme, "getLifeCycleNum" to getLifeCycleNum, "hideActionSheet" to hideActionSheet, "setLifeCycleNumFunc" to setLifeCycleNumFunc, "showActionSheetAndNavigateBackInSuccessCallback" to showActionSheetAndNavigateBackInSuccessCallback, "showActionSheetAndShowAgainInCallback" to showActionSheetAndShowAgainInCallback))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                val _component_page_intro = resolveEasyComponent("page-intro", GenComponentsPageIntroPageIntroClass)
                val _component_radio = resolveComponent("radio")
                val _component_radio_group = resolveComponent("radio-group")
                val _component_switch = resolveComponent("switch")
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", null, _uA(
                        _cV(_component_page_head, _uM("title" to unref(data).title), null, 8, _uA(
                            "title"
                        )),
                        _cV(_component_page_intro, _uM("content" to "本页演示 uni.showActionSheet：通过单选切换列表项、开关控制 titleColor/itemColor、超长与空文本 item、cancelText/cancelColor/backgroundColor 等；点击按钮弹出 actionSheet，可查看回调结果。")),
                        _cE("view", _uM("class" to "uni-list"), _uA(
                            _cV(_component_radio_group, _uM("onChange" to radioChange), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(unref(data).items, fun(item, index, __index, _cached): Any {
                                        return _cV(_component_radio, _uM("class" to _nC(_uA(
                                            "uni-list-cell uni-list-cell-pd",
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
                        )),
                        _cE("view", _uM("class" to "uni-list"), _uA(
                            _cE("view", _uM("class" to "uni-list-cell uni-list-cell-pd"), _uA(
                                _cE("view", _uM("class" to "uni-list-cell-db"), "自定义 titleColor"),
                                _cV(_component_switch, _uM("checked" to unref(data).titleColorCustom, "onChange" to titleColorChange), null, 8, _uA(
                                    "checked"
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-list-cell uni-list-cell-pd"), _uA(
                                _cE("view", _uM("class" to "uni-list-cell-db"), "自定义 itemColor"),
                                _cV(_component_switch, _uM("checked" to unref(data).itemColorCustom, "onChange" to itemColorChange), null, 8, _uA(
                                    "checked"
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-list-cell uni-list-cell-pd"), _uA(
                                _cE("view", _uM("class" to "uni-list-cell-db"), "超长文本和空文本 item"),
                                _cV(_component_switch, _uM("checked" to unref(data).itemContentLarge, "onChange" to itemContentLargeChange), null, 8, _uA(
                                    "checked"
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-list-cell uni-list-cell-pd"), _uA(
                                _cE("view", _uM("class" to "uni-list-cell-db"), "超过6个 item"),
                                _cV(_component_switch, _uM("checked" to unref(data).itemNumLargeSelect, "onChange" to itemNumLargeChange), null, 8, _uA(
                                    "checked"
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-list-cell uni-list-cell-pd"), _uA(
                                _cE("view", _uM("class" to "uni-list-cell-db"), "自定义 cancelText"),
                                _cV(_component_switch, _uM("checked" to unref(data).cancelTextCustom, "onChange" to cancelTextChange), null, 8, _uA(
                                    "checked"
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-list-cell uni-list-cell-pd"), _uA(
                                _cE("view", _uM("class" to "uni-list-cell-db"), "自定义 cancelColor"),
                                _cV(_component_switch, _uM("checked" to unref(data).cancelColorCustom, "onChange" to cancelColorChange), null, 8, _uA(
                                    "checked"
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-list-cell uni-list-cell-pd"), _uA(
                                _cE("view", _uM("class" to "uni-list-cell-db"), "自定义 backgroundColor"),
                                _cV(_component_switch, _uM("checked" to unref(data).backgroundColorCustom, "onChange" to backgroundColorChange), null, 8, _uA(
                                    "checked"
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                            _cE("view", _uM("class" to "uni-btn-v"), _uA(
                                _cE("button", _uM("class" to "uni-btn-v", "type" to "default", "onClick" to showActionSheet, "id" to "btn-action-sheet-show"), "弹出actionSheet"),
                                _cE("button", _uM("class" to "uni-btn-v uni-btn", "type" to "default", "onClick" to showActionSheetAndShowAgainInCallback, "id" to "btn-action-sheet-show"), "showActionSheet 并在回调中再次 showActionSheet")
                            ))
                        ))
                    ))
                ), 4)
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
