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
open class GenComponentsXGoodsitem : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var goods: UTSJSONObject by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXGoodsitem) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXGoodsitem
            val _cache = __ins.renderCache
            return fun(): Any? {
                return _cE("view", _uM("class" to "goods display-flex"), _uA(
                    _cE("view", _uM("class" to "goodsimg"), _uA(
                        _cE("image", _uM("mode" to "aspectFit", "class" to "img", "src" to _ctx.goods["image"]), null, 8, _uA(
                            "src"
                        ))
                    )),
                    _cE("view", _uM("class" to "goodsinfo"), _uA(
                        _cE("text", _uM("class" to "name overline"), _tD(_ctx.goods["name"]), 1),
                        _cE("view", _uM("class" to "goodsdata display-flex"), _uA(
                            _cE("view", _uM("class" to "datacard"), _uA(
                                _cE("text", _uM("class" to "number price"), _tD((_ctx.goods["price"] as Number).toFixed(2)), 1),
                                _cE("text", _uM("class" to "name"), "零售价")
                            )),
                            _cE("view", _uM("class" to "datacard"), _uA(
                                _cE("text", _uM("class" to "number"), _tD(_ctx.goods["stock"]), 1),
                                _cE("text", _uM("class" to "name"), "库存")
                            ))
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
                return _uM("goods" to _pS(_uM("height" to 80, "width" to "740rpx", "paddingLeft" to "20rpx")), "goodsimg" to _uM(".goods " to _uM("width" to 62, "height" to 59)), "img" to _uM(".goods .goodsimg " to _uM("width" to 62, "height" to 59, "borderTopLeftRadius" to 4, "borderTopRightRadius" to 4, "borderBottomRightRadius" to 4, "borderBottomLeftRadius" to 4)), "name" to _uM(".goods .goodsinfo " to _uM("paddingLeft" to "10rpx", "fontSize" to 15, "color" to "#000000"), ".goods .goodsinfo .goodsdata .datacard " to _uM("textAlign" to "center", "fontSize" to 11, "color" to "#8C8C8C")), "goodsdata" to _uM(".goods .goodsinfo " to _uM("marginTop" to 5)), "datacard" to _uM(".goods .goodsinfo .goodsdata " to _uM("width" to "150rpx")), "number" to _uM(".goods .goodsinfo .goodsdata .datacard " to _uM("textAlign" to "center", "fontSize" to 14, "fontWeight" to "bold")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("goods" to _uM("type" to "UTSJSONObject", "default" to _uO())))
        var propsNeedCastKeys = _uA(
            "goods"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
