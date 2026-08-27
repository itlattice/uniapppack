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
import io.dcloud.uniapp.extapi.hideModal as uni_hideModal
import io.dcloud.uniapp.extapi.showModal as uni_showModal
open class GenPagesAPIModalModal : BasePage {
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
    open var data: DataType__63
        get() {
            return unref(this.`$exposed`["data"]) as DataType__63
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIModalModal, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIModalModal
            val _cache = __ins.renderCache
            val data = reactive(DataType__63(title = "modal", showCancelSelect = false, showLongContent = false, illegalColorSelect = false, illegalButtonTextSelect = false, cancelTextSelect = false, confirmTextSelect = false, editableSelect = false, placeholderTextSelect = false, exeRet = "", lastModal = null as UniPage?, items = _uA<ItemType__4>(ItemType__4(value = "标题", name = "有标题"), ItemType__4(value = "", name = "无标题"), ItemType__4(value = "超长标题测试内容，测试超过显示最大范围之后的样式-超长标题测试内容，测试超过显示最大范围之后的样式", name = "超长标题")), current = 0, timesShowRet = _uA<Any>()))
            val showLongContentChange = fun(e: UniSwitchChangeEvent){
                data.showLongContent = e.detail.value
            }
            val illegalColorChange = fun(e: UniSwitchChangeEvent){
                data.illegalColorSelect = e.detail.value
            }
            val illegalButtonTextChange = fun(e: UniSwitchChangeEvent){
                data.illegalButtonTextSelect = e.detail.value
            }
            val showCancelChange = fun(e: UniSwitchChangeEvent){
                data.showCancelSelect = e.detail.value
            }
            val cancelTextChange = fun(e: UniSwitchChangeEvent){
                data.cancelTextSelect = e.detail.value
            }
            val confirmTextChange = fun(e: UniSwitchChangeEvent){
                data.confirmTextSelect = e.detail.value
            }
            val editableChange = fun(e: UniSwitchChangeEvent){
                data.editableSelect = e.detail.value
            }
            val placeholderTextChange = fun(e: UniSwitchChangeEvent){
                data.editableSelect = e.detail.value
                data.placeholderTextSelect = e.detail.value
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
            val closeLastModal = fun(){
                setTimeout(fun(){
                    uni_hideModal(HideModalOptions(modalPage = data.lastModal, success = fun(res){
                        data.exeRet = JSON.stringify(res)
                    }
                    , fail = fun(res){
                        data.exeRet = JSON.stringify(res)
                    }
                    , complete = fun(res){
                        data.timesShowRet.push(res)
                    }
                    ))
                }
                , 3000)
            }
            val closeAllModal = fun(){
                setTimeout(fun(){
                    uni_hideModal(HideModalOptions(modalPage = null, success = fun(res){
                        data.exeRet = JSON.stringify(res)
                    }
                    , fail = fun(res){
                        data.exeRet = JSON.stringify(res)
                    }
                    , complete = fun(res){
                        data.timesShowRet.push(res)
                    }
                    ))
                }
                , 3000)
            }
            val modalTap = fun(){
                data.timesShowRet = _uA()
                var cancelTextVal: String? = null
                var cancelColorVal = ""
                if (data.cancelTextSelect) {
                    cancelTextVal = "修改后的取消文本"
                    cancelColorVal = "#ff00ff"
                }
                var confirmTextVal: String? = null
                var confirmColorVal = ""
                if (data.confirmTextSelect) {
                    confirmTextVal = "修改后的确定文本"
                    confirmColorVal = "#0ff"
                }
                var placeholderTextVal = ""
                var contentVal = "弹窗内容，告知当前状态、信息和解决方法，描述文字尽量控制在三行内"
                if (data.showLongContent) {
                    contentVal = "弹窗内容，告知当前状态、信息和解决方法，描述文字原则上可以无限多！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！"
                }
                if (data.placeholderTextSelect) {
                    placeholderTextVal = "定制提示信息"
                }
                if (data.illegalColorSelect) {
                    cancelColorVal = "#WW00ff"
                    confirmColorVal = "#0ffff"
                }
                if (data.illegalButtonTextSelect) {
                    confirmTextVal = "超长版文字-修改后的确定文本-超长版本文字"
                    cancelTextVal = "超长版文字-修改后的取消文本-超长版本文字"
                }
                var op = ShowModalOptions(title = data.items[data.current].value, editable = data.editableSelect, placeholderText = placeholderTextVal, content = contentVal, showCancel = data.showCancelSelect, cancelText = cancelTextVal, cancelColor = cancelColorVal, confirmText = confirmTextVal, confirmColor = confirmColorVal, success = fun(res){
                    data.exeRet = JSON.stringify(res)
                }
                , fail = fun(res){
                    data.exeRet = JSON.stringify(res)
                }
                , complete = fun(res){
                    data.timesShowRet.push(res)
                }
                )
                data.lastModal = uni_showModal(op)
            }
            val modalTapTimes = fun(){
                data.timesShowRet = _uA()
                modalTap()
                modalTap()
                setTimeout(fun(){
                    modalTap()
                }
                , 200)
            }
            onLoad(fun(options: OnLoadOptions){
                if (options["onLoadShowModal"] == "false") {
                    return
                }
                uni_showModal(ShowModalOptions(title = "onLoad 调用示例,请手动取消"))
            }
            )
            __expose(_uM("data" to data))
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
                        _cV(_component_page_intro, _uM("content" to "uni.showModal 用于弹出模态对话框，可配置标题、内容、是否显示取消/确认按钮及文案、是否带输入框等。本页演示单次/多次弹出、延迟关闭、标题样式、长文案、非法颜色与超长按钮文案等能力，并展示 success/fail/complete 回调结果。")),
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
                                _cE("view", _uM("class" to "uni-list-cell-db"), "是否显示过长文字"),
                                _cV(_component_switch, _uM("checked" to unref(data).showLongContent, "onChange" to showLongContentChange), null, 8, _uA(
                                    "checked"
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-list-cell uni-list-cell-pd"), _uA(
                                _cE("view", _uM("class" to "uni-list-cell-db"), "是否显示取消按钮"),
                                _cV(_component_switch, _uM("checked" to unref(data).showCancelSelect, "onChange" to showCancelChange), null, 8, _uA(
                                    "checked"
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-list-cell uni-list-cell-pd"), _uA(
                                _cE("view", _uM("class" to "uni-list-cell-db"), "定制取消文案"),
                                _cV(_component_switch, _uM("checked" to unref(data).cancelTextSelect, "onChange" to cancelTextChange), null, 8, _uA(
                                    "checked"
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-list-cell uni-list-cell-pd"), _uA(
                                _cE("view", _uM("class" to "uni-list-cell-db"), "定制确认文案"),
                                _cV(_component_switch, _uM("checked" to unref(data).confirmTextSelect, "onChange" to confirmTextChange), null, 8, _uA(
                                    "checked"
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-list-cell uni-list-cell-pd"), _uA(
                                _cE("view", _uM("class" to "uni-list-cell-db"), "测试非法的颜色"),
                                _cV(_component_switch, _uM("checked" to unref(data).illegalColorSelect, "onChange" to illegalColorChange), null, 8, _uA(
                                    "checked"
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-list-cell uni-list-cell-pd"), _uA(
                                _cE("view", _uM("class" to "uni-list-cell-db"), "测试超长的按钮文本"),
                                _cV(_component_switch, _uM("checked" to unref(data).illegalButtonTextSelect, "onChange" to illegalButtonTextChange), null, 8, _uA(
                                    "checked"
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-list-cell uni-list-cell-pd"), _uA(
                                _cE("view", _uM("class" to "uni-list-cell-db"), "是否显示输入框"),
                                _cV(_component_switch, _uM("checked" to unref(data).editableSelect, "onChange" to editableChange), null, 8, _uA(
                                    "checked"
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-list-cell uni-list-cell-pd"), _uA(
                                _cE("view", _uM("class" to "uni-list-cell-db"), "是否定制输入提示词"),
                                _cV(_component_switch, _uM("checked" to unref(data).placeholderTextSelect, "onChange" to placeholderTextChange), null, 8, _uA(
                                    "checked"
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt"), _uA(
                            _cE("text", null, "complete 执行结果：" + _tD(unref(data).timesShowRet), 1),
                            _cE("view", _uM("class" to "uni-btn-v"), _uA(
                                _cE("button", _uM("type" to "primary", "onClick" to modalTap, "id" to "btn-modal-show"), " modal单次弹出 ")
                            )),
                            _cE("view", _uM("class" to "uni-btn-v"), _uA(
                                _cE("button", _uM("type" to "default", "onClick" to modalTapTimes, "id" to "btn-modal-show-multitime"), " modal多次弹出 ")
                            )),
                            _cE("view", _uM("class" to "uni-btn-v"), _uA(
                                _cE("button", _uM("type" to "default", "onClick" to closeAllModal, "id" to "btn-modal-hide-all"), " 延迟3s关闭全部弹窗 ")
                            )),
                            _cE("view", _uM("class" to "uni-btn-v"), _uA(
                                _cE("button", _uM("type" to "default", "onClick" to closeLastModal, "id" to "btn-modal-hide-last"), " 延迟3s关闭最后一个弹窗 ")
                            )),
                            _cE("text", null, " success/fail 执行结果：" + _tD(unref(data).exeRet), 1)
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
