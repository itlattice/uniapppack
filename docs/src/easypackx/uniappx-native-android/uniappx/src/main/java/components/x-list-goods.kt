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
open class GenComponentsXListGoods : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var goods: Any? by `$props`
    open var index: Number by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXListGoods) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXListGoods
            val _cache = __ins.renderCache
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val props = __props
            val info = computed(fun(): selectedListType {
                if (props.goods == null) {
                    return selectedListType(goods = _uO(), id = 0, number = 0)
                }
                return props.goods as selectedListType
            }
            )
            val bindNumberInput = fun(e: UniInputEvent){
                if (e.detail.value == "") {
                    return
                }
                var number = UTSNumber.from(e.detail.value)
                emit("numberInput", props.index, number)
            }
            val deleteItem = fun(){
                emit("delete", props.index)
            }
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_x_triangleinput = resolveEasyComponent("x-triangleinput", GenComponentsXTriangleinputClass)
                return _cE("view", _uM("class" to "goods space-between"), _uA(
                    _cE("view", _uM("class" to "goodsinfo display-flex"), _uA(
                        _cV(_component_x_iconfont, _uM("name" to "shanchu1", "color" to "red", "class" to "shanchu", "size" to "15", "height" to 24, "onClick" to deleteItem)),
                        _cE("text", _uM("class" to "infocontent overline"), _tD(unref(info).goods["name"]) + "(" + _tD(unref(info).goods["code"]) + ")", 1)
                    )),
                    _cE("view", _uM("class" to "inputnumber"), _uA(
                        _cV(_component_x_triangleinput, _uM("width" to 60, "height" to 21, "size" to 9), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("input", _uM("type" to "digit", "class" to "number", "value" to unref(info).number, "onInput" to fun(`$event`: UniInputEvent){
                                    bindNumberInput(`$event`)
                                }
                                ), null, 40, _uA(
                                    "value",
                                    "onInput"
                                ))
                            )
                        }
                        ), "_" to 1))
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
                return _uM("goods" to _pS(_uM("paddingRight" to "10rpx", "width" to "750rpx", "height" to 25, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#F0F0F0", "marginLeft" to "8rpx")), "goodsinfo" to _uM(".goods " to _uM("marginLeft" to 7)), "infocontent" to _uM(".goods .goodsinfo " to _uM("marginLeft" to 8, "fontSize" to 12, "color" to "#000000", "maxWidth" to "600rpx", "lineHeight" to "25px")), "inputnumber" to _pS(_uM("paddingRight" to "10rpx")), "number" to _uM(".inputnumber " to _uM("fontSize" to 14, "textAlign" to "center", "paddingTop" to 5)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("numberInput" to null, "delete" to null)
        var props = _nP(_uM("goods" to _uM("default" to selectedListType(goods = _uO(), id = 0, number = 0)), "index" to _uM("type" to "Number", "default" to 0)))
        var propsNeedCastKeys = _uA(
            "goods",
            "index"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
