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
open class GenPagesComponentPickerViewWrapPickerView : BasePage {
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
        var setup: (__props: GenPagesComponentPickerViewWrapPickerView) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentPickerViewWrapPickerView
            val _cache = __ins.renderCache
            val visible = ref(false)
            val pickerViewRef = ref<ComponentPublicInstance?>(null)
            fun gen_setValue_fn() {
                if (pickerViewRef.value != null) {
                    pickerViewRef.value!!.`$callMethod`("setValue")
                }
            }
            val setValue = ::gen_setValue_fn
            fun gen_toggle_fn() {
                visible.value = !visible.value
                if (visible.value) {
                    nextTick(fun(){
                        setValue()
                    }
                    )
                }
            }
            val toggle = ::gen_toggle_fn
            return fun(): Any? {
                return _cE("view", null, _uA(
                    if (isTrue(unref(visible))) {
                        _cV(unref(GenPagesComponentPickerViewPickerViewClass), _uM("key" to 0, "ref_key" to "pickerViewRef", "ref" to pickerViewRef), null, 512)
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    _cE("button", _uM("class" to "btn_toggle", "onClick" to toggle), "btn")
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
