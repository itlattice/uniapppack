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
open class GenComponentsXStocktask : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var order: UTSJSONObject by `$props`
    open var index: Number by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXStocktask) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXStocktask
            val _cache = __ins.renderCache
            val props = __props
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val order = computed(fun(): UTSJSONObject {
                return props.order
            }
            )
            val click = ref(false)
            val admin = computed(fun(): UTSJSONObject {
                if (props.order["admin"] == null) {
                    return _uO()
                }
                return props.order["admin"] as UTSJSONObject
            }
            )
            val checkUser = computed(fun(): Boolean {
                return props.order["check_user"] as Boolean
            }
            )
            val depart = computed(fun(): UTSJSONObject {
                if (props.order["depart"] == null) {
                    return _uO()
                }
                return props.order["depart"] as UTSJSONObject
            }
            )
            val addAdmin = computed(fun(): UTSJSONObject {
                if (props.order["add_admin"] == null) {
                    return _uO()
                }
                return props.order["add_admin"] as UTSJSONObject
            }
            )
            val paichu = fun(){
                click.value = true
                setTimeout(fun(){
                    click.value = false
                }
                , 50)
            }
            val erWeima = fun(){
                paichu()
                emit("erWeima", props.index)
            }
            val copyString = fun(){
                paichu()
                common.copy(props.order["no"] as String)
            }
            val toView = fun(){
                if (click.value) {
                    return
                }
                common.goto("/pages/warehouse/stocktasking/stocktaskview?id=" + props.order["id"].toString())
            }
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_x_tag = resolveEasyComponent("x-tag", GenComponentsXTagClass)
                return _cE("view", _uM("class" to "stocktask background-white", "onClick" to toView), _uA(
                    _cE("view", _uM("class" to "line space-between"), _uA(
                        _cE("view", _uM("class" to "noitem display-flex"), _uA(
                            _cE("text", _uM("class" to "no"), _tD(unref(order)["no"]), 1),
                            _cV(_component_x_iconfont, _uM("class" to "icon", "color" to "#C4C4C4", "size" to "14", "name" to "fuzhi", "onClick" to copyString)),
                            _cV(_component_x_iconfont, _uM("class" to "icon", "color" to "#C4C4C4", "size" to "14", "name" to "erweima", "onClick" to erWeima))
                        )),
                        _cE("view", _uM("class" to "orderstatus statuscontent display-flex"), _uA(
                            _cE("text", _uM("class" to "status", "style" to _nS(_uM("color" to unref(order)["status_color"]))), _tD(unref(order)["status_name"]), 5),
                            _cE("text", _uM("class" to _nC(_uA(
                                "status",
                                if (unref(checkUser)) {
                                    "success"
                                } else {
                                    "warning"
                                }
                            ))), _tD(if (unref(checkUser)) {
                                "已加入"
                            } else {
                                "未加入"
                            }
                            ), 3)
                        ))
                    )),
                    _cE("view", _uM("class" to "line space-between"), _uA(
                        _cE("text", _uM("class" to "shop"), "店/仓：" + _tD(unref(depart)["name"]), 1),
                        _cE("view", _uM("class" to "person display-flex"), _uA(
                            _cE("text", _uM("class" to "name"), "负责人:"),
                            _cE("text", _uM("class" to "content"), _tD(unref(admin)["name"]), 1)
                        ))
                    )),
                    _cE("view", _uM("class" to "line space-between"), _uA(
                        _cE("view", _uM("class" to "mingcheng display-flex"), _uA(
                            _cV(_component_x_tag, _uM("name" to "名称", "color" to "#1776FC")),
                            _cE("text", _uM("class" to "taskname"), _tD(unref(order)["name"]), 1)
                        )),
                        _cE("view", _uM("class" to "faqiperson display-flex"), _uA(
                            _cE("text", _uM("class" to "person"), _tD(unref(order)["add_date"]) + "由", 1),
                            _cE("text", _uM("class" to "nperson color-main"), _tD(unref(addAdmin)["name"]), 1),
                            _cE("text", _uM("class" to "person"), "发起")
                        ))
                    ))
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
                return _uM("stocktask" to _pS(_uM("borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#D4D4D4", "paddingLeft" to "10rpx", "paddingRight" to "10rpx", "paddingTop" to "15rpx", "paddingBottom" to "10rpx", "width" to "750rpx")), "line" to _uM(".stocktask " to _uM("width" to "730rpx", "marginBottom" to "15rpx")), "no" to _uM(".stocktask .line .noitem " to _uM("fontSize" to 14, "color" to "#6B6B6B")), "icon" to _uM(".stocktask .line .noitem " to _uM("marginLeft" to "10rpx")), "status" to _uM(".stocktask .line .orderstatus " to _uM("marginLeft" to "20rpx", "fontSize" to 14)), "shop" to _uM(".stocktask .line " to _uM("fontSize" to 15)), "name" to _uM(".stocktask .line .person " to _uM("fontSize" to 14, "color" to "#6B6B6B")), "content" to _uM(".stocktask .line .person " to _uM("fontSize" to 14)), "taskname" to _uM(".stocktask .line .mingcheng " to _uM("fontSize" to 13, "marginLeft" to "10rpx")), "person" to _uM(".stocktask .line .faqiperson " to _uM("fontSize" to 13, "color" to "#9C9C9C")), "nperson" to _uM(".stocktask .line .faqiperson " to _uM("fontSize" to 13)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("erWeima" to null)
        var props = _nP(_uM("order" to _uM("type" to "UTSJSONObject", "default" to _uO()), "index" to _uM("type" to "Number", "default" to 0)))
        var propsNeedCastKeys = _uA(
            "order",
            "index"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
