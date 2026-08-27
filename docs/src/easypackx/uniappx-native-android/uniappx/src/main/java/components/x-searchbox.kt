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
open class GenComponentsXSearchbox : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var placeholder: String by `$props`
    open var width: Number by `$props`
    open var modelValue: String by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXSearchbox) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXSearchbox
            val _cache = __ins.renderCache
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val props = __props
            val keywords = computed(fun(): String {
                return props.modelValue
            }
            )
            val inputChange = fun(e: UniInputEvent){
                emit("change", e.detail.value)
                emit("update:modelValue", e.detail.value)
            }
            val confirm = fun(e: InputConfirmEvent){
                emit("search", e.detail.value)
            }
            val clickSaoma = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        emit("saoma")
                })
            }
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                return _cE("view", _uM("class" to "searchbox position-relative display-flex", "style" to _nS(_uM("width" to (_ctx.width + "rpx")))), _uA(
                    _cV(_component_x_iconfont, _uM("name" to "sousuo1", "size" to "22", "height" to 34, "color" to "#C7C7C7")),
                    _cE("input", _uM("onInput" to inputChange, "onConfirm" to confirm, "style" to _nS(_uM("width" to ((_ctx.width - 140) + "rpx"))), "class" to "searchinput", "type" to "text", "placeholder" to _ctx.placeholder, "confirm-type" to "search"), null, 44, _uA(
                        "placeholder"
                    )),
                    _cV(_component_x_iconfont, _uM("onClick" to clickSaoma, "name" to "saoyisao", "size" to "22", "color" to "#7D7D7D", "height" to 34, "class" to "saoma"))
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
                return _uM("searchbox" to _pS(_uM("paddingLeft" to "10rpx", "backgroundColor" to "#F5F5F5", "borderTopLeftRadius" to 4, "borderTopRightRadius" to 4, "borderBottomRightRadius" to 4, "borderBottomLeftRadius" to 4, "height" to 34)), "searchinput" to _uM(".searchbox " to _uM("paddingLeft" to "10rpx", "fontSize" to 15)), "saoma" to _uM(".searchbox " to _uM("position" to "absolute", "right" to "10rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("change" to null, "update:modelValue" to null, "search" to null, "saoma" to null)
        var props = _nP(_uM("placeholder" to _uM("type" to "String", "default" to "关键词"), "width" to _uM("type" to "Number", "default" to 710), "modelValue" to _uM("type" to "String", "default" to "")))
        var propsNeedCastKeys = _uA(
            "placeholder",
            "width",
            "modelValue"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
