@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNI2971F61
import android.content.Context
import io.dcloud.uniapp.*
import io.dcloud.uniapp.extapi.*
import io.dcloud.uniapp.framework.*
import io.dcloud.uniapp.runtime.*
import io.dcloud.uniapp.vue.*
import io.dcloud.uniapp.vue.shared.*
import io.dcloud.uts.*
import io.dcloud.uts.Map
import io.dcloud.uts.Set
import io.dcloud.uts.UTSAndroid
import kotlin.properties.Delegates
import uts.sdk.modules.iboxsChooseMedia.MediaScanner
open class GenUniModulesTmxUiComponentsTmxPickerDateTmxPickerDate : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var modelValue: String by `$props`
    open var modelStr: String by `$props`
    open var modelShow: Boolean by `$props`
    open var title: String by `$props`
    open var cancelText: String by `$props`
    open var confirmText: String by `$props`
    open var start: String by `$props`
    open var end: String by `$props`
    open var type: String by `$props`
    open var format: String by `$props`
    open var formatSyncValue: Boolean by `$props`
    open var cellUnits: UTSArray<String> by `$props`
    open var lazyContent: Boolean by `$props`
    open var zIndex: Number by `$props`
    open var showClose: Boolean by `$props`
    open var disabled: Boolean by `$props`
    open var widthCoverCenter: Boolean by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesTmxUiComponentsTmxPickerDateTmxPickerDate) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesTmxUiComponentsTmxPickerDateTmxPickerDate
            val _cache = __ins.renderCache
            val i18n = xConfig.i18n
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val props = __props
            val show = ref(false)
            val currentVal = ref(xDate(props.modelValue).format("YYYY-MM-DD hh:mm:ss"))
            val currentStr = ref("")
            val _cellUnits = computed(fun(): UTSArray<String> {
                if (props.cellUnits.length == 0) {
                    return _uA(
                        i18n.t("tmui4x.pickerDate.year"),
                        i18n.t("tmui4x.pickerDate.month"),
                        i18n.t("tmui4x.pickerDate.day"),
                        i18n.t("tmui4x.pickerDate.hour"),
                        i18n.t("tmui4x.pickerDate.minute"),
                        i18n.t("tmui4x.pickerDate.second")
                    )
                }
                return props.cellUnits
            }
            )
            val _cancelText = computed(fun(): String {
                if (props.cancelText == "") {
                    return i18n.t("tmui4x.cancel")
                }
                return props.cancelText
            }
            )
            val _confirmText = computed(fun(): String {
                if (props.confirmText == "") {
                    return i18n.t("tmui4x.confirm")
                }
                return props.confirmText
            }
            )
            val _title = computed(fun(): String {
                if (props.title == "") {
                    return i18n.t("tmui4x.pickerTitle")
                }
                return props.title
            }
            )
            val openShow = fun(){
                if (props.disabled) {
                    return
                }
                show.value = true
                emit("update:modelShow", true)
                setPagePullRefresh(false)
            }
            val onClose = fun(){
                emit("update:modelShow", false)
            }
            val onOpen = fun(){
                openShow()
            }
            val mchange = fun(nowValueStr: String){
                emit("change", nowValueStr)
            }
            val onCancel = fun(){
                emit("cancel")
                currentVal.value = xDate(props.modelValue).format("YYYY-MM-DD hh:mm:ss")
            }
            val onConfirm = fun(){
                emit("confirm", currentVal.value)
                emit("update:modelValue", currentVal.value)
                emit("update:modelStr", currentStr.value)
            }
            watch(fun(): String {
                return props.modelValue
            }
            , fun(newvalue: String){
                currentVal.value = props.modelValue
            }
            )
            watch(fun(): Boolean {
                return props.modelShow
            }
            , fun(newValue: Boolean){
                if (newValue == show.value) {
                    return
                }
                openShow()
            }
            )
            return fun(): Any? {
                val _component_tmx_date_view = resolveEasyComponent("tmx-date-view", GenUniModulesTmxUiComponentsTmxDateViewTmxDateViewClass)
                val _component_tmx_drawer = resolveEasyComponent("tmx-drawer", GenUniModulesTmxUiComponentsTmxDrawerTmxDrawerClass)
                return _cE(Fragment, null, _uA(
                    _cE("view", _uM("onClick" to openShow), _uA(
                        renderSlot(_ctx.`$slots`, "default", _uM("label" to currentStr.value))
                    )),
                    _cV(_component_tmx_drawer, _uM("lazy" to props.lazyContent, "cancel-text" to _cancelText.value, "confirm-text" to _confirmText.value, "zIndex" to props.zIndex, "onOpen" to onOpen, "widthCoverCenter" to props.widthCoverCenter, "disabledScroll" to true, "title" to _title.value, "onClose" to onClose, "onConfirm" to onConfirm, "onCancel" to onCancel, "showFooter" to true, "show" to show.value, "onUpdate:show" to fun(`$event`: Boolean){
                        show.value = `$event`
                    }
                    , "show-close" to props.showClose, "size" to "410"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to "xPickerDateWrap"), _uA(
                                _cV(_component_tmx_date_view, _uM("onChange" to mchange, "style" to _nS(_uM("flex" to "1")), "start" to props.start, "end" to props.end, "title" to _title.value, "format" to props.format, "modelValue" to currentVal.value, "onUpdate:modelValue" to fun(`$event`: String){
                                    currentVal.value = `$event`
                                }
                                , "model-str" to currentStr.value, "onUpdate:modelStr" to fun(`$event`: String){
                                    currentStr.value = `$event`
                                }
                                , "type" to props.type, "cellUnits" to _cellUnits.value), null, 8, _uA(
                                    "style",
                                    "start",
                                    "end",
                                    "title",
                                    "format",
                                    "modelValue",
                                    "onUpdate:modelValue",
                                    "model-str",
                                    "onUpdate:modelStr",
                                    "type",
                                    "cellUnits"
                                ))
                            ))
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "lazy",
                        "cancel-text",
                        "confirm-text",
                        "zIndex",
                        "widthCoverCenter",
                        "title",
                        "show",
                        "onUpdate:show",
                        "show-close"
                    ))
                ), 64)
            }
        }
        var name = "xPickerDate"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("xPickerDateWrap" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "flex-start")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("cancel" to null, "confirm" to null, "change" to null, "update:modelShow" to null, "update:modelStr" to null, "update:modelValue" to null)
        var props = _nP(_uM("modelValue" to _uM("type" to "String", "required" to false, "default" to ""), "modelStr" to _uM("type" to "String", "required" to false, "default" to ""), "modelShow" to _uM("type" to "Boolean", "required" to false, "default" to false), "title" to _uM("type" to "String", "required" to false, "default" to ""), "cancelText" to _uM("type" to "String", "required" to false, "default" to ""), "confirmText" to _uM("type" to "String", "required" to false, "default" to ""), "start" to _uM("type" to "String", "required" to false, "default" to ""), "end" to _uM("type" to "String", "required" to false, "default" to ""), "type" to _uM("type" to "String", "required" to false, "default" to "day"), "format" to _uM("type" to "String", "required" to false, "default" to "YYYY-MM-DD"), "formatSyncValue" to _uM("type" to "Boolean", "required" to false, "default" to false), "cellUnits" to _uM("type" to "Array", "required" to false, "default" to fun(): UTSArray<String> {
            return _uA<String>()
        }
        ), "lazyContent" to _uM("type" to "Boolean", "required" to false, "default" to true), "zIndex" to _uM("type" to "Number", "required" to false, "default" to 1100), "showClose" to _uM("type" to "Boolean", "required" to false, "default" to true), "disabled" to _uM("type" to "Boolean", "required" to false, "default" to false), "widthCoverCenter" to _uM("type" to "Boolean", "required" to false, "default" to false)))
        var propsNeedCastKeys = _uA(
            "modelValue",
            "modelStr",
            "modelShow",
            "title",
            "cancelText",
            "confirmText",
            "start",
            "end",
            "type",
            "format",
            "formatSyncValue",
            "cellUnits",
            "lazyContent",
            "zIndex",
            "showClose",
            "disabled",
            "widthCoverCenter"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
