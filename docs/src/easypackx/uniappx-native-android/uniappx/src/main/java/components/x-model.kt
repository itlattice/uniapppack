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
import uts.sdk.modules.tmxModalS.showModal
open class GenComponentsXModel : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var i18n: Tmui4xI18nTml by `$data`
    open var showModal: (modalContent: String, modalTitle: String) -> Unit
        get() {
            return unref(this.`$exposed`["showModal"]) as (modalContent: String, modalTitle: String) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "showModal", value)
        }
    open var showConfirm: (modalContent: String, modalTitle: String) -> UTSPromise<Boolean>
        get() {
            return unref(this.`$exposed`["showConfirm"]) as (modalContent: String, modalTitle: String) -> UTSPromise<Boolean>
        }
        set(value) {
            setRefValue(this.`$exposed`, "showConfirm", value)
        }
    open var closeModal: () -> Unit
        get() {
            return unref(this.`$exposed`["closeModal"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "closeModal", value)
        }
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXModel, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXModel
            val _cache = __ins.renderCache
            val content = ref("")
            val show = ref(false)
            val title = ref("提示")
            val confirm = ref(false)
            val showModal = fun(modalContent: String, modalTitle: String){
                confirm.value = false
                show.value = true
                content.value = modalContent
                title.value = modalTitle
            }
            val closeModal = fun(){
                show.value = false
            }
            var ConfirmClick = fun(){}
            var cancelClick = fun(){}
            val showConfirm = fun(modalContent: String, modalTitle: String): UTSPromise<Boolean> {
                return wrapUTSPromise(suspend w1@{
                        confirm.value = true
                        return@w1 await(UTSPromise(fun(resolve, reject){
                            content.value = modalContent
                            title.value = modalTitle
                            console.log(modalContent)
                            show.value = true
                            ConfirmClick = fun(){
                                show.value = false
                                resolve(true)
                            }
                            cancelClick = fun(){
                                show.value = false
                                resolve(false)
                            }
                        }
                        ))
                })
            }
            __expose(_uM("showModal" to showModal, "showConfirm" to showConfirm, "closeModal" to closeModal))
            return fun(): Any? {
                val _component_tmx_text = resolveEasyComponent("tmx-text", GenUniModulesTmxUiComponentsTmxTextTmxTextClass)
                val _component_tmx_modal = resolveEasyComponent("tmx-modal", GenUniModulesTmxUiComponentsTmxModalTmxModalClass)
                return _cV(_component_tmx_modal, _uM("show" to unref(show), "onUpdate:show" to fun(`$event`: Boolean){
                    trySetRefValue(show, `$event`)
                }
                , "title" to unref(title), "showCancel" to unref(confirm), "onClose" to closeModal, "onCancel" to unref(cancelClick), "height" to "auto", "onConfirm" to unref(ConfirmClick)), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cV(_component_tmx_text, _uM("class" to "text-size-m text-grey line-8"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _tD(unref(content))
                            )
                        }
                        ), "_" to 1))
                    )
                }
                ), "_" to 1), 8, _uA(
                    "show",
                    "title",
                    "showCancel",
                    "onCancel",
                    "onConfirm"
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
