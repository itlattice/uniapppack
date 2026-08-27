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
open class GenPagesAPIRequestPaymentRequestPaymentOrderDetail : BasePage {
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
        var setup: (__props: GenPagesAPIRequestPaymentRequestPaymentOrderDetail) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIRequestPaymentRequestPaymentOrderDetail
            val _cache = __ins.renderCache
            val myOptions = reactive(DataType__97(order_no = "", out_trade_no = ""))
            onLoad(fun(options: OnLoadOptions){
                console.log("options: ", options)
                if (options["order_no"] != null) {
                    myOptions.order_no = options["order_no"] as String
                }
                if (options["out_trade_no"] != null) {
                    myOptions.out_trade_no = options["out_trade_no"] as String
                }
            }
            )
            return fun(): Any? {
                return _cE("view", _uM("class" to "app"), _uA(
                    _cE("view", null, _uA(
                        _cE("text", null, "你自己的业务系统订单详情页面")
                    )),
                    _cE("view", _uM("style" to _nS(_uM("margin-top" to "10px"))), _uA(
                        _cE("text", null, "order_no：" + _tD(unref(myOptions).order_no), 1)
                    ), 4),
                    _cE("view", _uM("style" to _nS(_uM("margin-top" to "10px"))), _uA(
                        _cE("text", null, "out_trade_no：" + _tD(unref(myOptions).out_trade_no), 1)
                    ), 4)
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
                return _uM("app" to _pS(_uM("paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
