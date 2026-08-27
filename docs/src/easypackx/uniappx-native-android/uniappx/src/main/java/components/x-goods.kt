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
open class GenComponentsXGoods : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var goods: UTSJSONObject by `$props`
    open var number: Number by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXGoods) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXGoods
            val _cache = __ins.renderCache
            val props = __props
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val goods = computed(fun(): UTSJSONObject {
                return props.goods
            }
            )
            val number = computed(fun(): Number {
                return props.number
            }
            )
            val price = computed(fun(): UTSJSONObject {
                return props.goods["price"] as UTSJSONObject
            }
            )
            val clickView = ref(false)
            val clickGoods = fun(){
                if (clickView.value) {
                    return
                }
                console.log("点击了商品", props.goods["id"])
                emit("clickGoods")
            }
            val showView = fun(){
                clickView.value = true
                setTimeout(fun(){
                    clickView.value = false
                }
                , 100)
                console.log("点击了详情", props.goods["id"])
            }
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                return _cE("view", _uM("class" to "goods background-white space-between", "onClick" to clickGoods), _uA(
                    _cE("view", _uM("class" to "goodsinfo display-flex"), _uA(
                        _cE("view", _uM("class" to "images"), _uA(
                            _cE("image", _uM("src" to unref(goods)["image"], "class" to "img"), null, 8, _uA(
                                "src"
                            )),
                            if (unref(number) > 0) {
                                _cE("text", _uM("key" to 0, "class" to "number"), _tD(unref(number)), 1)
                            } else {
                                _cC("v-if", true)
                            }
                        )),
                        _cE("view", _uM("class" to "basicinfo"), _uA(
                            _cE("text", _uM("class" to "goodsname overline2"), _tD(unref(goods)["name"]), 1)
                        ))
                    )),
                    _cE("text", _uM("class" to "code"), _tD(unref(goods)["code"]), 1),
                    _cE("text", _uM("class" to "price font-bold"), "￥" + _tD(unref(price)["price_str"]) + "/" + _tD(if (unref(price)["type"] == "piece") {
                        unref(goods)["unit"]
                    } else {
                        "Kg"
                    }
                    ), 1),
                    _cE("view", _uM("class" to "viewbtn display-flex", "onClick" to showView), _uA(
                        _cV(_component_x_iconfont, _uM("name" to "gengduo", "size" to "15", "color" to "#1776FC")),
                        _cE("text", _uM("class" to "content color-main"), "详情")
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
                return _uM("goods" to _pS(_uM("width" to "750rpx", "height" to 80, "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "position" to "relative")), "images" to _uM(".goods .goodsinfo " to _uM("width" to 60, "height" to 60)), "img" to _uM(".goods .goodsinfo .images " to _uM("borderTopLeftRadius" to 3, "borderTopRightRadius" to 3, "borderBottomRightRadius" to 3, "borderBottomLeftRadius" to 3, "width" to 60, "height" to 60)), "basicinfo" to _uM(".goods .goodsinfo " to _uM("marginLeft" to 8)), "goodsname" to _uM(".goods .goodsinfo .basicinfo " to _uM("width" to "450rpx", "fontSize" to 14)), "code" to _uM(".goods " to _uM("color" to "#737373", "fontSize" to 12, "left" to 80, "bottom" to 10, "position" to "absolute")), "price" to _uM(".goods " to _uM("color" to "#FF8D1A", "fontSize" to 15, "right" to 10, "bottom" to 10, "position" to "absolute")), "viewbtn" to _uM(".goods " to _uM("position" to "absolute", "right" to 10)), "content" to _uM(".goods .viewbtn " to _uM("fontSize" to 13, "marginLeft" to 2)), "number" to _uM(".goods " to _uM("position" to "absolute", "left" to -5, "bottom" to 0, "backgroundImage" to "none", "backgroundColor" to "#FF0000", "color" to "#FFFFFF", "fontSize" to 13, "height" to 16, "lineHeight" to "16px", "textAlign" to "center", "width" to 70)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("clickGoods" to null)
        var props = _nP(_uM("goods" to _uM("type" to "UTSJSONObject", "default" to _uO()), "number" to _uM("type" to "Number", "default" to 0)))
        var propsNeedCastKeys = _uA(
            "goods",
            "number"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
