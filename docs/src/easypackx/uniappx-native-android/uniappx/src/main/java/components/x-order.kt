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
open class GenComponentsXOrder : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _cache = this.`$`.renderCache
        val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
        return _cE("view", _uM("class" to "order-item background-white"), _uA(
            _cE("view", _uM("class" to "basicinfo"), _uA(
                _cE("view", _uM("class" to "basic space-between"), _uA(
                    _cE("view", _uM("class" to "orderinfo"), _uA(
                        _cE("view", _uM("class" to "orderno display-flex"), _uA(
                            _cE("view", _uM("class" to "name"), _uA(
                                _cE("text", _uM("class" to "text"), "订单号")
                            )),
                            _cE("view", _uM("class" to "no"), _uA(
                                _cE("text", _uM("class" to "text"), "384515265214125125412")
                            )),
                            _cV(_component_x_iconfont, _uM("class" to "noicon", "name" to "fuzhi", "size" to "16", "color" to "#666666")),
                            _cV(_component_x_iconfont, _uM("class" to "noicon", "name" to "erweima", "size" to "16", "color" to "#666666"))
                        )),
                        _cE("view", _uM("class" to "createtime"), _uA(
                            _cE("text", _uM("class" to "text"), "创建时间：2025-03-05 12:12:12")
                        ))
                    )),
                    _cE("view", _uM("class" to "priceinfo"), _uA(
                        _cE("view", _uM("class" to "space-between"), _uA(
                            _cE("view"),
                            _cE("view", _uM("class" to "tag tagunline"), _uA(
                                _cE("text", _uM("class" to "text"), "线下订单")
                            ))
                        )),
                        _cE("view", _uM("class" to "price"), _uA(
                            _cE("text", _uM("class" to "text font-bold"), "￥38.54")
                        ))
                    ))
                )),
                _cE("view", _uM("class" to "infoline space-between"), _uA(
                    _cE("view", _uM("class" to "lineitem"), _uA(
                        _cE("text", _uM("class" to "text"), "会员：散客")
                    ))
                )),
                _cE("view", _uM("class" to "infoline space-between"), _uA(
                    _cE("view", _uM("class" to "lineitem"), _uA(
                        _cE("text", _uM("class" to "text"), "门店：总店(KM001)")
                    ))
                )),
                _cE("view", _uM("class" to "infoline space-between"), _uA(
                    _cE("view", _uM("class" to "lineitem display-flex"), _uA(
                        _cE("text", _uM("class" to "text"), "单品数："),
                        _cE("text", _uM("class" to "textnumber"), "5")
                    )),
                    _cE("view", _uM("class" to "lineitem"), _uA(
                        _cE("text", _uM("class" to "text"), "收银台：4141441")
                    ))
                )),
                _cE("view", _uM("class" to "infoline space-between"), _uA(
                    _cE("view", _uM("class" to "lineitem display-flex"), _uA(
                        _cE("text", _uM("class" to "text"), "件数："),
                        _cE("text", _uM("class" to "textnumber"), "10")
                    )),
                    _cE("view", _uM("class" to "lineitem"), _uA(
                        _cE("text", _uM("class" to "text"), "收银员：老刘(111111)")
                    ))
                ))
            )),
            _cE("view", _uM("class" to "payinfo"), _uA(
                _cE("view", _uM("class" to "infoline space-between"), _uA(
                    _cE("view", _uM("class" to "lineitem display-flex"), _uA(
                        _cE("text", _uM("class" to "text"), "商品总额："),
                        _cE("text", _uM("class" to "text"), "41.41")
                    )),
                    _cE("view", _uM("class" to "lineitem display-flex"), _uA(
                        _cE("text", _uM("class" to "text"), "结算账户：支付宝"),
                        _cE("text", _uM("class" to "textnumber"), "+41.41")
                    ))
                )),
                _cE("view", _uM("class" to "infoline space-between"), _uA(
                    _cE("view", _uM("class" to "lineitem display-flex"), _uA(
                        _cE("text", _uM("class" to "text"), "优惠金额："),
                        _cE("text", _uM("class" to "text"), "41.41")
                    )),
                    _cE("view", _uM("class" to "lineitem display-flex"), _uA(
                        _cE("text", _uM("class" to "text"), "支付方式："),
                        _cE("text", _uM("class" to "text"), "支付宝")
                    ))
                )),
                _cE("view", _uM("class" to "infoline space-between"), _uA(
                    _cE("view", _uM("class" to "lineitem display-flex"), _uA(
                        _cE("text", _uM("class" to "text"), "抹零金额："),
                        _cE("text", _uM("class" to "text"), "0.04")
                    )),
                    _cE("view", _uM("class" to "lineitem display-flex"), _uA(
                        _cE("text", _uM("class" to "text"), "实收金额"),
                        _cE("text", _uM("class" to "textnumber"), "41.41")
                    ))
                ))
            ))
        ))
    }
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("order-item" to _pS(_uM("height" to "384rpx", "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#CCCCCC", "paddingLeft" to "16rpx", "paddingRight" to "10rpx", "paddingTop" to "9rpx", "paddingBottom" to "21rpx")), "basicinfo" to _uM(".order-item " to _uM("height" to "223rpx")), "name" to _uM(".order-item .basicinfo .basic .orderinfo .orderno " to _uM("paddingTop" to "5rpx")), "text" to _uM(".order-item .basicinfo .basic .orderinfo .orderno .name " to _uM("color" to "#737373", "fontSize" to "26rpx"), ".order-item .basicinfo .basic .orderinfo .orderno .no " to _uM("color" to "#000000", "fontSize" to "28rpx"), ".order-item .basicinfo .basic .orderinfo .createtime " to _uM("color" to "#8a8a8a", "fontSize" to "20rpx"), ".order-item .basicinfo .basic .priceinfo .tag " to _uM("fontSize" to "18rpx", "color" to "#FFFFFF", "textAlign" to "center", "lineHeight" to "26rpx"), ".order-item .basicinfo .basic .priceinfo .price " to _uM("color" to "#FF8D1A", "fontSize" to "28rpx"), ".order-item .infoline .lineitem " to _uM("fontSize" to "28rpx", "color" to "#474747", "lineHeight" to "34rpx"), ".order-item .payinfo .infoline .lineitem " to _uM("fontSize" to "28rpx", "color" to "#858585", "lineHeight" to "36rpx")), "no" to _uM(".order-item .basicinfo .basic .orderinfo .orderno " to _uM("paddingLeft" to "4rpx")), "noicon" to _uM(".order-item .basicinfo .basic .orderinfo .orderno " to _uM("paddingLeft" to "10rpx")), "createtime" to _uM(".order-item .basicinfo .basic .orderinfo " to _uM("paddingTop" to "4rpx")), "tag" to _uM(".order-item .basicinfo .basic .priceinfo " to _uM("width" to "88rpx", "height" to "26rpx", "borderTopLeftRadius" to "10.5rpx", "borderTopRightRadius" to "10.5rpx", "borderBottomRightRadius" to "10.5rpx", "borderBottomLeftRadius" to "10.5rpx", "right" to 0)), "tagunline" to _uM(".order-item .basicinfo .basic .priceinfo " to _uM("backgroundImage" to "none", "backgroundColor" to "#FF3B3B")), "price" to _uM(".order-item .basicinfo .basic .priceinfo " to _uM("paddingTop" to "5rpx")), "infoline" to _uM(".order-item " to _uM("height" to "38rpx", "paddingTop" to "5rpx")), "textnumber" to _uM(".order-item .infoline .lineitem " to _uM("fontSize" to "28rpx", "lineHeight" to "34rpx", "color" to "#FF5733")), "payinfo" to _uM(".order-item " to _uM("paddingTop" to "9rpx", "borderTopWidth" to 1, "borderTopStyle" to "solid", "borderTopColor" to "#f5f5f5")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
