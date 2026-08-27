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
import io.dcloud.uniapp.extapi.hideToast as uni_hideToast
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesAPIToastToast : BasePage {
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
    open var data: DataType__65
        get() {
            return unref(this.`$exposed`["data"]) as DataType__65
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var toast1Tap: () -> Unit
        get() {
            return unref(this.`$exposed`["toast1Tap"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "toast1Tap", value)
        }
    open var toast3Tap: () -> Unit
        get() {
            return unref(this.`$exposed`["toast3Tap"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "toast3Tap", value)
        }
    open var toast2Tap: () -> Unit
        get() {
            return unref(this.`$exposed`["toast2Tap"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "toast2Tap", value)
        }
    open var hideToast: () -> Unit
        get() {
            return unref(this.`$exposed`["hideToast"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "hideToast", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIToastToast, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIToastToast
            val _cache = __ins.renderCache
            val data = reactive(DataType__65(title = "toast", exeRet = "", imageSelect = false, maskSelect = false, intervalSelect = 1500, position_current = 0, position_enum = _uA(
                PositionItemType(value = "top", name = "top: 居上显示（Android 暂不支持）"),
                PositionItemType(value = "center", name = "center: 居中显示（Android 暂不支持）"),
                PositionItemType(value = "bottom", name = "bottom: 居底显示")
            ), icon_current = 0, icon_enum = _uA(
                IconItemType(value = "success", name = "显示成功图标"),
                IconItemType(value = "error", name = "显示错误图标"),
                IconItemType(value = "loading", name = "显示加载图标"),
                IconItemType(value = "none", name = "不显示图标")
            )))
            onMounted(fun(){
                uni_showToast(ShowToastOptions(title = "onMounted 调用示例,2秒后消失"))
                setTimeout(fun() {
                    uni_hideToast()
                }
                , 2000)
            }
            )
            val radioChangeIcon = fun(e: UniRadioGroupChangeEvent){
                run {
                    var i: Number = 0
                    while(i < data.icon_enum.length){
                        if (data.icon_enum[i].value === e.detail.value) {
                            data.icon_current = i
                            break
                        }
                        i++
                    }
                }
            }
            val change_image_boolean = fun(e: UniSwitchChangeEvent){
                data.imageSelect = e.detail.value
            }
            val change_mask_boolean = fun(e: UniSwitchChangeEvent){
                data.maskSelect = e.detail.value
            }
            val sliderChange = fun(e: UniSliderChangeEvent){
                data.intervalSelect = e.detail.value
            }
            val radioChangePosition = fun(e: UniRadioGroupChangeEvent){
                run {
                    var i: Number = 0
                    while(i < data.position_enum.length){
                        if (data.position_enum[i].value === e.detail.value) {
                            data.position_current = i
                            break
                        }
                        i++
                    }
                }
            }
            val toast1Tap = fun(){
                uni_showToast(ShowToastOptions(title = "默认", icon = data.icon_enum[data.icon_current].value, duration = data.intervalSelect, image = if (data.imageSelect) {
                    "/static/test-image/logo.png"
                } else {
                    null
                }
                , mask = data.maskSelect, success = fun(res){
                    data.exeRet = "success:" + JSON.stringify(res)
                }
                , fail = fun(res){
                    data.exeRet = "fail:" + JSON.stringify(res)
                }
                ))
            }
            val toast3Tap = fun(){
                uni_showToast(ShowToastOptions(title = "默认", icon = "none", duration = data.intervalSelect, image = if (data.imageSelect) {
                    "/static/test-image/logo.png"
                } else {
                    null
                }
                , mask = data.maskSelect, success = fun(res){
                    data.exeRet = "success:" + JSON.stringify(res)
                }
                , fail = fun(res){
                    data.exeRet = "fail:" + JSON.stringify(res)
                }
                ))
            }
            val toast2Tap = fun(){
                var positionValue = data.position_enum[data.position_current].value
                uni_showToast(ShowToastOptions(title = "显示一段轻提示,position:" + positionValue, position = positionValue, success = fun(res){
                    data.exeRet = "success:" + JSON.stringify(res)
                }
                , fail = fun(res){
                    data.exeRet = "fail:" + JSON.stringify(res)
                }
                ))
            }
            val hideToast = fun(){
                uni_hideToast()
            }
            __expose(_uM("data" to data, "toast1Tap" to toast1Tap, "toast3Tap" to toast3Tap, "toast2Tap" to toast2Tap, "hideToast" to hideToast))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                val _component_radio = resolveComponent("radio")
                val _component_radio_group = resolveComponent("radio-group")
                val _component_switch = resolveComponent("switch")
                val _component_slider = resolveComponent("slider")
                return _cE("scroll-view", _uM("direction" to "vertical", "style" to _nS(_uM("flex" to "1"))), _uA(
                    _cV(_component_page_head, _uM("title" to unref(data).title), null, 8, _uA(
                        "title"
                    )),
                    _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                        _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                            _cE("text", _uM("class" to "uni-title-text uni-common-mb"), "设置icon")
                        )),
                        _cE("view", _uM("class" to "uni-list uni-common-pl"), _uA(
                            _cV(_component_radio_group, _uM("onChange" to radioChangeIcon), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(unref(data).icon_enum, fun(icon, index, __index, _cached): Any {
                                        return _cV(_component_radio, _uM("class" to _nC(_uA(
                                            "uni-list-cell uni-list-cell-pd radio-icon",
                                            if (index < unref(data).icon_enum.length - 1) {
                                                "uni-list-cell-line"
                                            } else {
                                                ""
                                            }
                                        )), "key" to icon.value, "value" to icon.value, "checked" to (index === unref(data).icon_current)), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(icon.name)
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
                        _cE("view", _uM("class" to "uni-list-cell uni-list-cell-padding"), _uA(
                            _cE("view", _uM("class" to "uni-list-cell-db"), "是否显示自定义图标"),
                            _cV(_component_switch, _uM("checked" to unref(data).imageSelect, "onChange" to change_image_boolean), null, 8, _uA(
                                "checked"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-list-cell uni-list-cell-padding"), _uA(
                            _cE("view", _uM("class" to "uni-list-cell-db"), "是否显示透明蒙层-屏蔽点击事件"),
                            _cV(_component_switch, _uM("checked" to unref(data).maskSelect, "onChange" to change_mask_boolean), null, 8, _uA(
                                "checked"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-title uni-list-cell-padding"), "提示的延迟时间，默认：1500（单位毫秒）"),
                        _cE("view", _uM("class" to "uni-list-cell-padding"), _uA(
                            _cV(_component_slider, _uM("onChange" to sliderChange, "foreColor" to "#007AFF", "value" to unref(data).intervalSelect, "min" to 1500, "max" to 5000, "show-value" to true), null, 8, _uA(
                                "value"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-btn-v"), _uA(
                            _cE("button", _uM("type" to "default", "onClick" to toast1Tap, "id" to "btn-toast-default"), "点击弹出toast"),
                            _cE("button", _uM("type" to "default", "onClick" to hideToast, "id" to "btn-toast-hide"), "点击隐藏toast")
                        )),
                        _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text uni-common-mb"), " 设置position，仅App生效 ")
                        )),
                        _cE("view", _uM("class" to "uni-list uni-common-pl"), _uA(
                            _cV(_component_radio_group, _uM("onChange" to radioChangePosition), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(unref(data).position_enum, fun(position, index, __index, _cached): Any {
                                        return _cV(_component_radio, _uM("class" to _nC(_uA(
                                            "uni-list-cell uni-list-cell-pd radio-position",
                                            if (index < unref(data).position_enum.length - 1) {
                                                "uni-list-cell-line"
                                            } else {
                                                ""
                                            }
                                        )), "key" to position.value, "value" to position.value, "checked" to (index === unref(data).position_current)), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(position.name)
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
                        _cE("button", _uM("class" to "uni-btn uni-common-mb", "type" to "default", "onClick" to toast2Tap), "点击弹出设置position的toast"),
                        _cE("text", null, _tD(unref(data).exeRet), 1)
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
