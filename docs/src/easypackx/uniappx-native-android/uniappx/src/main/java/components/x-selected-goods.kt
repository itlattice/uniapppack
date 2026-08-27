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
open class GenComponentsXSelectedGoods : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var goods: Any? by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXSelectedGoods) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXSelectedGoods
            val _cache = __ins.renderCache
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val props = __props
            val num = computed(fun(): Number {
                if (props.goods == null) {
                    return 0
                }
                return (props.goods as selectedListType).number as Number
            }
            )
            val goodsInfo = computed(fun(): UTSJSONObject {
                if (props.goods == null) {
                    return _uO()
                }
                return (props.goods as selectedListType).goods as UTSJSONObject
            }
            )
            val numberChange = fun(e: String){
                if (props.goods == null) {
                    return
                }
                emit("numberChange", (props.goods as selectedListType).id, e)
            }
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_x_numberstep = resolveEasyComponent("x-numberstep", GenComponentsXNumberstepClass)
                return _cE("view", _uM("class" to "sgoods display-flex"), _uA(
                    _cE("image", _uM("class" to "img", "src" to unref(goodsInfo)["image"]), null, 8, _uA(
                        "src"
                    )),
                    _cE("view", _uM("class" to "goodsinfo"), _uA(
                        _cE("text", _uM("class" to "overline2 name"), _tD(unref(goodsInfo)["name"]), 1),
                        _cE("text", _uM("class" to "code position-absolute"), _tD(unref(goodsInfo)["code"]), 1)
                    )),
                    _cV(_component_x_iconfont, _uM("name" to "shanchu", "color" to "#FF6363", "size" to "23", "class" to "shanchu")),
                    _cV(_component_x_numberstep, _uM("class" to "numberstep", "modelValue" to unref(num), "onChange" to numberChange), null, 8, _uA(
                        "modelValue"
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
                return _uM("sgoods" to _pS(_uM("position" to "relative", "width" to "100%", "height" to 90, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#C7C7C7")), "img" to _uM(".sgoods " to _uM("width" to 70, "height" to 70, "borderTopLeftRadius" to 3, "borderTopRightRadius" to 3, "borderBottomRightRadius" to 3, "borderBottomLeftRadius" to 3, "marginTop" to 11, "marginLeft" to 9)), "goodsinfo" to _uM(".sgoods " to _uM("paddingTop" to 12)), "name" to _uM(".sgoods .goodsinfo " to _uM("marginLeft" to 9, "width" to "450rpx", "fontSize" to 14)), "code" to _uM(".sgoods .goodsinfo " to _uM("bottom" to 10, "left" to 9, "fontSize" to 13, "color" to "#A8A8A8")), "shanchu" to _uM(".sgoods " to _uM("position" to "absolute", "right" to 9, "top" to 9)), "numberstep" to _uM(".sgoods " to _uM("position" to "absolute", "right" to 6, "bottom" to 3)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("numberChange" to null)
        var props = _nP(_uM("goods" to _uM("default" to selectedListType(goods = _uO("id" to 0), id = 0, number = 0))))
        var propsNeedCastKeys = _uA(
            "goods"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
