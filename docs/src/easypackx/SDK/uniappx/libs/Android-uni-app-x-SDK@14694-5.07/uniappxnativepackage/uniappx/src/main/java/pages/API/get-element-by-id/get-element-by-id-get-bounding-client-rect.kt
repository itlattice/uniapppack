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
import io.dcloud.uniapp.extapi.getElementById as uni_getElementById
open class GenPagesAPIGetElementByIdGetElementByIdGetBoundingClientRect : BasePage {
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
    open var getNode1Info: () -> DOMRect
        get() {
            return unref(this.`$exposed`["getNode1Info"]) as () -> DOMRect
        }
        set(value) {
            setRefValue(this.`$exposed`, "getNode1Info", value)
        }
    open var getNode2Info: () -> DOMRect
        get() {
            return unref(this.`$exposed`["getNode2Info"]) as () -> DOMRect
        }
        set(value) {
            setRefValue(this.`$exposed`, "getNode2Info", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIGetElementByIdGetElementByIdGetBoundingClientRect, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIGetElementByIdGetElementByIdGetBoundingClientRect
            val _cache = __ins.renderCache
            fun gen_getNode1Info_fn(): DOMRect {
                val info = uni_getElementById("node1")?.getBoundingClientRect()
                if (info != null) {
                    return info
                }
                return DOMRect(x = 0, y = 0, height = 0, width = 0)
            }
            val getNode1Info = ::gen_getNode1Info_fn
            fun gen_getNode2Info_fn(): DOMRect {
                val info = uni_getElementById("node2")?.getBoundingClientRect()
                if (info != null) {
                    return info
                }
                return DOMRect(x = 0, y = 0, height = 0, width = 0)
            }
            val getNode2Info = ::gen_getNode2Info_fn
            __expose(_uM("getNode1Info" to getNode1Info, "getNode2Info" to getNode2Info))
            return fun(): Any? {
                return _cE("view", _uM("class" to "container"), _uA(
                    _cE("view", _uM("id" to "node1", "class" to "node node1"), " 这里是 transfrom 之后的节点 "),
                    _cE("view", _uM("id" to "node2", "class" to "node node2"), " 这里是没有 transfrom 的节点 "),
                    _cE("button", _uM("onClick" to getNode1Info), " getNode1Info "),
                    _cE("button", _uM("onClick" to getNode2Info), " getNode2Info ")
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
                return _uM("container" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "backgroundColor" to "#f8f8f8")), "node" to _pS(_uM("marginTop" to "20rpx", "marginRight" to "20rpx", "marginBottom" to "20rpx", "marginLeft" to "20rpx", "backgroundColor" to "#FFFFFF", "paddingTop" to "40rpx", "paddingRight" to "40rpx", "paddingBottom" to "40rpx", "paddingLeft" to "40rpx", "borderTopLeftRadius" to "10rpx", "borderTopRightRadius" to "10rpx", "borderBottomRightRadius" to "10rpx", "borderBottomLeftRadius" to "10rpx")), "node1" to _pS(_uM("transform" to "translateY(500px) scale(1.5)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
