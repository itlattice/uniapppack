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
open class GenComponentsXShowSigner : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var type: String by `$props`
    open var subtype: String by `$props`
    open var infoid: Number by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXShowSigner) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXShowSigner
            val _cache = __ins.renderCache
            val props = __props
            val loading = ref<UniElement?>(null)
            val pageHeight = ref(0)
            val codeSrc = ref("")
            val show = ref(false)
            val showSigner = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        common.loading(loading.value)
                        var res = await(request.callapi("center/getsigner", _uO("type" to props.type, "subtype" to props.subtype, "id" to props.infoid)))
                        common.hideLoading(loading.value)
                        if (res.code < 0) {
                            common.toast(res.msg)
                            return@w1
                        }
                        codeSrc.value = (res.data as UTSJSONObject)["src"] as String
                        show.value = true
                })
            }
            val closeMask = fun(){
                show.value = false
            }
            onMounted(fun(){
                pageHeight.value = uni_getWindowInfo().windowHeight
            }
            )
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_x_loading = resolveEasyComponent("x-loading", GenComponentsXLoadingClass)
                return _cE("view", null, _uA(
                    _cV(_component_x_iconfont, _uM("onClick" to showSigner, "name" to "qianzi", "size" to "16", "height" to 30, "color" to "#1776FC")),
                    _cV(_component_x_loading, _uM("ref_key" to "loading", "ref" to loading), null, 512),
                    if (isTrue(unref(show))) {
                        _cE("view", _uM("key" to 0, "class" to "showcode", "onClick" to closeMask, "style" to _nS(_uM("height" to (unref(pageHeight) + "px")))), _uA(
                            _cE("image", _uM("fade-show" to true, "src" to unref(codeSrc), "mode" to "widthFix", "class" to "image"), null, 8, _uA(
                                "src"
                            ))
                        ), 4)
                    } else {
                        _cC("v-if", true)
                    }
                ))
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
        var props = _nP(_uM("type" to _uM("type" to "String", "default" to ""), "subtype" to _uM("type" to "String", "default" to ""), "infoid" to _uM("type" to "Number", "default" to 0)))
        var propsNeedCastKeys = _uA(
            "type",
            "subtype",
            "infoid"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
