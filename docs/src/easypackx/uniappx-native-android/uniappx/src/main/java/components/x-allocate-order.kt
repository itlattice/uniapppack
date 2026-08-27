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
open class GenComponentsXAllocateOrder : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var width: Number by `$props`
    open var order: UTSJSONObject by `$props`
    open var index: Number by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXAllocateOrder) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXAllocateOrder
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
            val admin = computed(fun(): UTSJSONObject {
                var admin = props.order["admin"] as UTSJSONObject
                return admin as UTSJSONObject
            }
            )
            val fromdepart = computed(fun(): UTSJSONObject {
                var depart = props.order["fromdepart"] as UTSJSONObject
                return depart
            }
            )
            val todepart = computed(fun(): UTSJSONObject {
                var depart = props.order["todepart"] as UTSJSONObject
                return depart
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
                common.goto("/pages/warehouse/allocate/view?id=" + props.order["id"].toString(), "slide-in-bottom")
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
                val _component_x_tag = resolveEasyComponent("x-tag", GenComponentsXTagClass)
                return _cE("view", _uM("class" to "allocate-order background-white space-between", "style" to _nS(_uM("width" to (unref(width) + "rpx"))), "onClick" to toView), _uA(
                    _cE("view", _uM("class" to "orderinfo"), _uA(
                        _cE("view", _uM("class" to "line space-between", "style" to _nS(_uM("width" to ((unref(width) - 20) + "rpx")))), _uA(
                            _cE("view", _uM("class" to "orderno display-flex"), _uA(
                                _cE("text", _uM("class" to "no"), _tD(unref(order)["no"]), 1),
                                _cV(_component_x_iconfont, _uM("class" to "fuzhiicon", "name" to "fuzhi", "size" to "13", "color" to "#C4C4C4", "onClick" to copyString)),
                                _cV(_component_x_iconfont, _uM("class" to "fuzhiicon", "name" to "erweima", "size" to "13", "color" to "#C4C4C4", "onClick" to erWeima))
                            )),
                            _cE("text", _uM("class" to "statuscontent", "style" to _nS(_uM("color" to unref(order)["status_color"]))), _tD(unref(order)["status_name"]), 5)
                        ), 4),
                        _cE("view", _uM("class" to "line space-between", "style" to _nS(_uM("width" to ((unref(width) - 20) + "rpx")))), _uA(
                            _cE("view", _uM("class" to "departinfo display-flex"), _uA(
                                _cE("text", _uM("class" to "shop"), _tD(unref(fromdepart)["name"]), 1),
                                _cV(_component_x_iconfont, _uM("class" to "icon", "name" to "xiangyou3", "color" to "#1678fd", "height" to 20, "size" to "20")),
                                _cE("text", _uM("class" to "shop"), _tD(unref(todepart)["name"]), 1)
                            )),
                            _cE("text", _uM("class" to "numbers"), "调拨数量：" + _tD(unref(order)["total"]), 1)
                        ), 4),
                        _cE("view", _uM("class" to "line space-between", "style" to _nS(_uM("width" to ((unref(width) - 20) + "rpx")))), _uA(
                            _cE("view"),
                            _cE("view", _uM("class" to "person display-flex"), _uA(
                                _cE("text", _uM("class" to "name"), "单品数:"),
                                _cE("text", _uM("class" to "content color-red"), _tD(unref(order)["goods_num"]), 1)
                            ))
                        ), 4),
                        _cE("view", _uM("class" to "line space-between", "style" to _nS(_uM("width" to ((unref(width) - 20) + "rpx")))), _uA(
                            _cE("view", _uM("class" to "mingcheng display-flex"), _uA(
                                _cV(_component_x_tag, _uM("name" to "备注", "color" to "#1776FC")),
                                _cE("text", _uM("class" to "taskname"), _tD(unref(order)["remark"]), 1)
                            )),
                            _cE("view", _uM("class" to "faqiperson display-flex"), _uA(
                                _cE("text", _uM("class" to "person"), _tD(unref(order)["add_date"]) + "由", 1),
                                _cE("text", _uM("class" to "nperson color-main"), _tD(unref(admin)["name"]), 1),
                                _cE("text", _uM("class" to "person"), "提交")
                            ))
                        ), 4)
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
                return _uM("allocate-order" to _pS(_uM("paddingTop" to 5, "paddingLeft" to "10rpx", "paddingRight" to "10rpx")), "orderno" to _uM(".allocate-order .orderinfo " to _uM("marginBottom" to 4)), "no" to _uM(".allocate-order .orderinfo .orderno " to _uM("color" to "#6B6B6B", "fontSize" to 13)), "fuzhiicon" to _uM(".allocate-order .orderinfo .orderno " to _uM("marginLeft" to "8rpx")), "notag" to _uM(".allocate-order .orderinfo " to _uM("width" to 40, "height" to 12, "textAlign" to "center", "lineHeight" to "10px", "fontSize" to 8, "color" to "#FF8D1A", "borderTopLeftRadius" to 3, "borderTopRightRadius" to 3, "borderBottomRightRadius" to 3, "borderBottomLeftRadius" to 3, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#FF8D1A", "borderRightColor" to "#FF8D1A", "borderBottomColor" to "#FF8D1A", "borderLeftColor" to "#FF8D1A", "marginLeft" to "10rpx", "marginTop" to 2)), "robottag" to _uM(".allocate-order .orderinfo " to _uM("color" to "#ff300c", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#ff300c", "borderRightColor" to "#ff300c", "borderBottomColor" to "#ff300c", "borderLeftColor" to "#ff300c")), "shop" to _uM(".allocate-order .departinfo " to _uM("fontSize" to 18, "fontWeight" to "bold", "paddingRight" to "10rpx"), ".allocate-order .line " to _uM("fontSize" to 15)), "icon" to _uM(".allocate-order .departinfo " to _uM("paddingRight" to "10rpx")), "line" to _uM(".allocate-order " to _uM("marginBottom" to "15rpx")), "numbers" to _uM(".allocate-order .line " to _uM("fontSize" to 13, "color" to "#6B6B6B")), "statuscontent" to _uM(".allocate-order .line " to _uM("fontSize" to 12)), "name" to _uM(".allocate-order .line .person " to _uM("fontSize" to 13, "color" to "#000000")), "content" to _uM(".allocate-order .line .person " to _uM("fontSize" to 13, "color" to "#ff300c")), "taskname" to _uM(".allocate-order .line .mingcheng " to _uM("fontSize" to 13, "marginLeft" to "10rpx")), "person" to _uM(".allocate-order .line .faqiperson " to _uM("fontSize" to 12, "color" to "#9C9C9C")), "nperson" to _uM(".allocate-order .line .faqiperson " to _uM("fontSize" to 12)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("erWeima" to null)
        var props = _nP(_uM("width" to _uM("type" to "Number", "default" to 750), "order" to _uM("type" to "UTSJSONObject", "default" to _uO()), "index" to _uM("type" to "Number", "default" to 0)))
        var propsNeedCastKeys = _uA(
            "width",
            "order",
            "index"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
