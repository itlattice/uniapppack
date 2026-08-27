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
import io.dcloud.uniapp.extapi.`$emit` as uni__emit
open class GenComponentsXChoosedate : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var now: String by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    open var open: () -> Unit
        get() {
            return unref(this.`$exposed`["open"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "open", value)
        }
    open var cancel: () -> Unit
        get() {
            return unref(this.`$exposed`["cancel"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "cancel", value)
        }
    open var confirm: () -> Unit
        get() {
            return unref(this.`$exposed`["confirm"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "confirm", value)
        }
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXChoosedate, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXChoosedate
            val _cache = __ins.renderCache
            val show = ref(false)
            val start = ref("2020-01-01")
            val end = ref("2029-01-01")
            val nowVal = ref("")
            val open = fun(){
                console.log("打开选择")
                show.value = true
            }
            val cancel = fun(){
                show.value = false
                uni__emit("choosedate", null)
            }
            val updateShow = fun(value: Boolean){
                show.value = value
            }
            val updateNowVal = fun(value: String){
                nowVal.value = value
            }
            val confirm = fun(){
                show.value = false
                console.log("选择日期", nowVal.value)
                uni__emit("choosedate", nowVal.value)
            }
            onBeforeMount(fun(){
                var data = xDate(Date.now() + "")
                start.value = data.format("YYYY-MM-DD")
                var date = xDate((Date.now() + 94608000000).toString(10))
                end.value = date.format("YYYY-MM-DD")
            }
            )
            __expose(_uM("open" to open, "cancel" to cancel, "confirm" to confirm))
            return fun(): Any? {
                val _component_tmx_picker_date = resolveEasyComponent("tmx-picker-date", GenUniModulesTmxUiComponentsTmxPickerDateTmxPickerDateClass)
                return _cV(_component_tmx_picker_date, _uM("model-show" to unref(show), "modelValue" to _ctx.now, "model-str" to unref(nowVal), "start" to unref(start), "end" to unref(end), "type" to "day", "onUpdate:modelShow" to updateShow, "onUpdate:modelStr" to updateNowVal, "onCancel" to cancel, "onConfirm" to confirm), null, 8, _uA(
                    "model-show",
                    "modelValue",
                    "model-str",
                    "start",
                    "end"
                ))
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("now" to _uM("type" to "String", "default" to fun(): String {
            var data = xDate(Date.now() + "")
            return data.format("YYYY-MM-DD")
        }
        )))
        var propsNeedCastKeys = _uA(
            "now"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
