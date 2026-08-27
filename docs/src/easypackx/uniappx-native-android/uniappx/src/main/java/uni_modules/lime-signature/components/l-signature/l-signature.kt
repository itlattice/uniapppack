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
open class GenUniModulesLimeSignatureComponentsLSignatureLSignature : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var styles: String by `$props`
    open var penColor: String by `$props`
    open var penSize: Number by `$props`
    open var backgroundColor: String by `$props`
    open var openSmooth: Boolean by `$props`
    open var minLineWidth: Number by `$props`
    open var maxLineWidth: Number by `$props`
    open var minSpeed: Number by `$props`
    open var maxWidthDiffRate: Number by `$props`
    open var maxHistoryLength: Number by `$props`
    open var disableScroll: Boolean by `$props`
    open var disabled: Boolean by `$props`
    open var landscape: Boolean by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    open var clear: () -> Unit
        get() {
            return unref(this.`$exposed`["clear"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "clear", value)
        }
    open var redo: () -> Unit
        get() {
            return unref(this.`$exposed`["redo"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "redo", value)
        }
    open var undo: () -> Unit
        get() {
            return unref(this.`$exposed`["undo"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "undo", value)
        }
    open var canvasToTempFilePath: (options: LimeSignatureToTempFilePathOptions) -> Unit
        get() {
            return unref(this.`$exposed`["canvasToTempFilePath"]) as (options: LimeSignatureToTempFilePathOptions) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "canvasToTempFilePath", value)
        }
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesLimeSignatureComponentsLSignatureLSignature, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesLimeSignatureComponentsLSignatureLSignature
            val _cache = __ins.renderCache
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val props = __props
            val drawableStyle = computed<String>(fun(): String {
                var style: String = ""
                if (props.backgroundColor != "") {
                    style += "background-color: " + props.backgroundColor + ";"
                }
                if (props.styles != "") {
                    style += props.styles
                }
                return style
            }
            )
            val signatureRef = ref<UniElement?>(null)
            val signatureCanvasRef = ref<UniElement?>(null)
            var signatureLandscapeRef = ref<UniElement?>(null)
            var landscapeStyle = ref<Map<String, String>>(Map())
            var landscapeImageStyle = ref<Map<String, String>>(Map())
            var isCanvasEmpty = true
            var signature: Signature? = null
            var url = ref("")
            val checkAndEmitEmptyStatus = fun(){
                val isEmpty = signature?.isEmpty ?: true
                if (isEmpty != isCanvasEmpty) {
                    isCanvasEmpty = isEmpty
                    emit("change", isCanvasEmpty)
                }
            }
            val clear = fun(){
                signature?.clear()
                checkAndEmitEmptyStatus()
            }
            val redo = fun(){
                signature?.redo()
                checkAndEmitEmptyStatus()
            }
            val undo = fun(){
                signature?.undo()
                checkAndEmitEmptyStatus()
            }
            val canvasToTempFilePath = fun(options: LimeSignatureToTempFilePathOptions){
                val success = options.success
                val fail = options.fail
                val complete = options.complete
                val format = options.format ?: "png"
                signatureRef.value?.takeSnapshot(TakeSnapshotOptions(format = format, success = fun(res){
                    if (props.landscape) {
                        url.value = res.tempFilePath
                        signatureLandscapeRef.value?.getBoundingClientRectAsync()?.then(fun(rect){
                            setTimeout(fun(){
                                signatureLandscapeRef.value?.takeSnapshot(TakeSnapshotOptions(format = format, success = fun(res2){
                                    success?.invoke(LimeSignatureToFileSuccess(tempFilePath = res2.tempFilePath, isEmpty = signature?.isEmpty ?: false))
                                }))
                            }, 300)
                        })
                    } else {
                        success?.invoke(LimeSignatureToFileSuccess(tempFilePath = res.tempFilePath, isEmpty = signature?.isEmpty ?: false))
                    }
                }
                , fail = fun(res){
                    fail?.invoke(res)
                }
                , complete = fun(res){
                    complete?.invoke(res)
                }
                ))
            }
            __expose(_uM("clear" to clear, "redo" to redo, "undo" to undo, "canvasToTempFilePath" to canvasToTempFilePath))
            onMounted(fun(){
                nextTick(fun(){
                    setTimeout(fun(){
                        val width = signatureRef.value?.offsetWidth
                        val height = signatureRef.value?.offsetHeight
                        landscapeStyle.value.set("width", "" + height + "px")
                        landscapeStyle.value.set("height", "" + width + "px")
                        landscapeImageStyle.value.set("width", "" + width + "px")
                        landscapeImageStyle.value.set("height", "" + height + "px")
                        landscapeImageStyle.value.set("transform", "rotate(-90deg) translateX(-" + width + "px)")
                        signature = Signature(signatureRef.value!!)
                        watchEffect(fun(){
                            val options = LimeSignatureOptions(penColor = props.penColor, openSmooth = props.openSmooth, disableScroll = props.disableScroll, disabled = props.disabled, penSize = props.penSize, minLineWidth = props.minLineWidth, maxLineWidth = props.maxLineWidth, minSpeed = props.minSpeed, maxWidthDiffRate = props.maxWidthDiffRate, maxHistoryLength = props.maxHistoryLength)
                            signature?.setOption(options)
                            signature?.onChange(fun(_isEmpty: Boolean){
                                checkAndEmitEmptyStatus()
                            }
                            )
                        }
                        )
                    }
                    , 300)
                }
                )
            }
            )
            onUnmounted(fun(){})
            return fun(): Any? {
                return _cE("view", _uM("class" to "l-signature", "ref_key" to "signatureRef", "ref" to signatureRef, "style" to _nS(_uA(
                    unref(drawableStyle)
                ))), _uA(
                    if (isTrue(_ctx.landscape)) {
                        _cE("view", _uM("key" to 0, "class" to "l-signature-landscape", "ref_key" to "signatureLandscapeRef", "ref" to signatureLandscapeRef, "style" to _nS(_uA(
                            unref(landscapeStyle)
                        ))), _uA(
                            _cE("image", _uM("class" to "l-signature-image", "style" to _nS(_uA(
                                unref(landscapeImageStyle)
                            )), "src" to unref(url)), null, 12, _uA(
                                "src"
                            ))
                        ), 4)
                    } else {
                        _cC("v-if", true)
                    }
                ), 4)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("l-signature" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "l-signature__canvas" to _pS(_uM("width" to "100%", "height" to "100%")), "l-signature-landscape" to _pS(_uM("position" to "absolute", "pointerEvents" to "none", "overflow" to "visible", "left" to "99.9%")), "l-signature-image" to _pS(_uM("transformOrigin" to "0% 0%")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("change" to null)
        var props = _nP(_uM("styles" to _uM("type" to "String", "default" to ""), "penColor" to _uM("type" to "String", "default" to "black"), "penSize" to _uM("type" to "Number", "default" to 2), "backgroundColor" to _uM("type" to "String", "default" to ""), "openSmooth" to _uM("type" to "Boolean", "default" to false), "minLineWidth" to _uM("type" to "Number", "default" to 2), "maxLineWidth" to _uM("type" to "Number", "default" to 6), "minSpeed" to _uM("type" to "Number", "default" to 1.5), "maxWidthDiffRate" to _uM("type" to "Number", "default" to 20), "maxHistoryLength" to _uM("type" to "Number", "default" to 20), "disableScroll" to _uM("type" to "Boolean", "default" to true), "disabled" to _uM("type" to "Boolean", "default" to false), "landscape" to _uM("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = _uA(
            "styles",
            "penColor",
            "penSize",
            "backgroundColor",
            "openSmooth",
            "minLineWidth",
            "maxLineWidth",
            "minSpeed",
            "maxWidthDiffRate",
            "maxHistoryLength",
            "disableScroll",
            "disabled",
            "landscape"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
