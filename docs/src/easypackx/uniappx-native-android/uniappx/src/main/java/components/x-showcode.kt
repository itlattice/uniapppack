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
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
open class GenComponentsXShowcode : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var i18n: Tmui4xI18nTml by `$data`
    open var showCode: (value: Any) -> Unit
        get() {
            return unref(this.`$exposed`["showCode"]) as (value: Any) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "showCode", value)
        }
    open var closeCode: () -> Unit
        get() {
            return unref(this.`$exposed`["closeCode"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "closeCode", value)
        }
    open var closeMask: () -> Unit
        get() {
            return unref(this.`$exposed`["closeMask"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "closeMask", value)
        }
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXShowcode, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXShowcode
            val _cache = __ins.renderCache
            val pageHeight = ref(0)
            val codeSrc = ref("")
            val show = ref(false)
            val src = ref("")
            val showCode = fun(value: Any){
                src.value = value as String
                codeSrc.value = "https://api.itgz8.com/v1/direct/image-qrcode?level=3&txt=" + src.value
                show.value = true
            }
            val closeCode = fun(){
                show.value = false
            }
            val closeMask = fun(){
                show.value = false
            }
            onMounted(fun(){
                pageHeight.value = uni_getWindowInfo().safeArea.height
            }
            )
            __expose(_uM("showCode" to showCode, "closeCode" to closeCode, "closeMask" to closeMask))
            return fun(): Any? {
                return if (isTrue(unref(show))) {
                    _cE("view", _uM("key" to 0, "class" to "showcode", "onClick" to closeMask, "style" to _nS(_uM("height" to (unref(pageHeight) + "px")))), _uA(
                        _cE("image", _uM("fade-show" to true, "src" to unref(codeSrc), "mode" to "widthFix", "class" to "image"), null, 8, _uA(
                            "src"
                        ))
                    ), 4)
                } else {
                    _cC("v-if", true)
                }
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("showcode" to _pS(_uM("position" to "fixed", "top" to 0, "left" to 0, "width" to "750rpx", "alignItems" to "center", "justifyContent" to "center", "backgroundImage" to "none", "backgroundColor" to "#0000006f")), "image" to _uM(".showcode " to _uM("width" to "450rpx", "height" to "450rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
