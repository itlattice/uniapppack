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
open class GenComponentsXPurchaseOrder : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var width: Number by `$props`
    open var order: UTSJSONObject by `$props`
    open var index: Number by `$props`
    open var select: Boolean by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXPurchaseOrder) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXPurchaseOrder
            val _cache = __ins.renderCache
            val props = __props
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val width = computed(fun(): Number {
                return props.width
            }
            )
            val order = computed(fun(): UTSJSONObject {
                return props.order
            }
            )
            val click = ref(false)
            val amount = computed(fun(): String {
                var a = props.order["amount"] as Number
                if (a <= 0) {
                    return "—"
                }
                return a.toFixed(2)
            }
            )
            val adminName = computed(fun(): String {
                var admin = props.order["admin"] as UTSJSONObject
                return admin["name"] as String
            }
            )
            val paichu = fun(){
                click.value = true
                setTimeout(fun(){
                    click.value = false
                }
                , 50)
            }
            val toView = fun(){
                if (click.value) {
                    return
                }
                if (props.select) {
                    return
                }
                common.goto("/pages/warehouse/purchase/purchaseview?id=" + props.order["id"].toString(), "slide-in-bottom")
            }
            val copyString = fun(){
                paichu()
                common.copy(props.order["no"] as String)
            }
            val erWeima = fun(){
                paichu()
                emit("erWeima", props.index)
            }
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                return _cE("view", _uM("class" to "purchase-order background-white space-between", "style" to _nS(_uM("width" to (unref(width) + "rpx"))), "onClick" to toView), _uA(
                    _cE("view", _uM("class" to "orderinfo"), _uA(
                        _cE("view", _uM("class" to "orderno display-flex"), _uA(
                            _cE("text", _uM("class" to "no"), _tD(unref(order)["no"]), 1),
                            _cV(_component_x_iconfont, _uM("class" to "fuzhiicon", "name" to "fuzhi", "size" to "13", "color" to "#C4C4C4", "onClick" to copyString)),
                            _cV(_component_x_iconfont, _uM("class" to "fuzhiicon", "name" to "erweima", "size" to "13", "color" to "#C4C4C4", "onClick" to erWeima)),
                            _cE("text", _uM("class" to _nC(_uA(
                                "notag",
                                if (unref(order)["from_method"] == "hand") {
                                    "persontag"
                                } else {
                                    "robottag"
                                }
                            ))), _tD(if (unref(order)["from_method"] == "hand") {
                                "人工录入"
                            } else {
                                "智能生成"
                            }
                            ), 3)
                        )),
                        _cE("view", _uM("class" to "remark display-flex"), _uA(
                            _cE("text", _uM("class" to "remarktag"), "备注"),
                            _cE("text", _uM("class" to "remarkcontent overline"), _tD(unref(order)["remark"]), 1)
                        )),
                        _cE("view", _uM("class" to "dateuser display-flex"), _uA(
                            _cE("text", _uM("class" to "date"), _tD(unref(order)["add_time"]) + " 由", 1),
                            _cE("text", _uM("class" to "user date"), _tD(unref(adminName)), 1),
                            _cE("text", _uM("class" to "date"), "提交")
                        ))
                    )),
                    _cE("view", _uM("class" to "orderdata"), _uA(
                        if (unref(order)["status"] == 0) {
                            _cE("text", _uM("key" to 0, "class" to "status align-right color-red"), _tD(unref(order)["status_name"]), 1)
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        if (unref(order)["status"] == 1) {
                            _cE("text", _uM("key" to 1, "class" to "status align-right color-green"), _tD(unref(order)["status_name"]), 1)
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        if (unref(order)["status"] == -1) {
                            _cE("text", _uM("key" to 2, "class" to "status align-right color-gray"), _tD(unref(order)["status_name"]), 1)
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        _cE("text", _uM("class" to "danpin align-right"), _uA(
                            _cE("text", _uM("class" to "name"), "单品数"),
                            _cE("text", _uM("class" to "number align-right"), _tD(unref(order)["goods_piece"]), 1)
                        )),
                        _cE("view", _uM("class" to "yugu display-flex"), _uA(
                            _cE("text", _uM("class" to "name align-right"), "预估"),
                            _cE("text", _uM("class" to "number align-right font-bold"), _tD(unref(amount)), 1)
                        ))
                    ))
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
                return _uM("purchase-order" to _pS(_uM("height" to 75, "paddingTop" to 2, "paddingLeft" to "10rpx", "paddingRight" to "10rpx")), "no" to _uM(".purchase-order .orderinfo .orderno " to _uM("color" to "#6B6B6B", "fontSize" to 13)), "fuzhiicon" to _uM(".purchase-order .orderinfo .orderno " to _uM("marginLeft" to "8rpx")), "remark" to _uM(".purchase-order .orderinfo " to _uM("marginTop" to 7)), "remarktag" to _uM(".purchase-order .orderinfo .remark " to _uM("width" to 31, "height" to 16, "borderTopLeftRadius" to 3, "borderTopRightRadius" to 3, "borderBottomRightRadius" to 3, "borderBottomLeftRadius" to 3, "textAlign" to "center", "lineHeight" to "14px", "color" to "#1776FC", "fontSize" to 10, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#1776FC", "borderRightColor" to "#1776FC", "borderBottomColor" to "#1776FC", "borderLeftColor" to "#1776FC")), "remarkcontent" to _uM(".purchase-order .orderinfo .remark " to _uM("lineHeight" to "16px", "paddingLeft" to "8rpx", "width" to "400rpx")), "dateuser" to _uM(".purchase-order .orderinfo " to _uM("marginTop" to 7)), "date" to _uM(".purchase-order .orderinfo .dateuser " to _uM("fontSize" to 13)), "user" to _uM(".purchase-order .orderinfo .dateuser " to _uM("color" to "#1776FC")), "notag" to _uM(".purchase-order .orderinfo " to _uM("width" to 40, "height" to 12, "textAlign" to "center", "lineHeight" to "10px", "fontSize" to 8, "color" to "#FF8D1A", "borderTopLeftRadius" to 3, "borderTopRightRadius" to 3, "borderBottomRightRadius" to 3, "borderBottomLeftRadius" to 3, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#FF8D1A", "borderRightColor" to "#FF8D1A", "borderBottomColor" to "#FF8D1A", "borderLeftColor" to "#FF8D1A", "marginLeft" to "10rpx", "marginTop" to 2)), "robottag" to _uM(".purchase-order .orderinfo " to _uM("color" to "#ff300c", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#ff300c", "borderRightColor" to "#ff300c", "borderBottomColor" to "#ff300c", "borderLeftColor" to "#ff300c")), "status" to _uM(".purchase-order .orderdata " to _uM("fontSize" to 12)), "daiqueren" to _uM(".purchase-order .orderdata " to _uM("color" to "#FF0000")), "danpin" to _uM(".purchase-order .orderdata " to _uM("marginTop" to 10)), "name" to _uM(".purchase-order .orderdata .danpin " to _uM("fontSize" to 12, "color" to "#6B6B6B"), ".purchase-order .orderdata .yugu " to _uM("fontSize" to 12, "paddingTop" to 3, "color" to "#B3B3B3")), "number" to _uM(".purchase-order .orderdata .danpin " to _uM("paddingLeft" to "3rpx", "fontSize" to 14, "color" to "#FF0000"), ".purchase-order .orderdata .yugu " to _uM("paddingLeft" to "3rpx", "color" to "#FF8D1A", "fontSize" to 16)), "yugu" to _uM(".purchase-order .orderdata " to _uM("marginTop" to 7)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("erWeima" to null)
        var props = _nP(_uM("width" to _uM("type" to "Number", "default" to 750), "order" to _uM("type" to "UTSJSONObject", "default" to _uO()), "index" to _uM("type" to "Number", "default" to 0), "select" to _uM("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = _uA(
            "width",
            "order",
            "index",
            "select"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
