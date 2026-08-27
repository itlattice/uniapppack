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
open class GenComponentsXCalculator : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var isShow: Boolean by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXCalculator) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXCalculator
            val _cache = __ins.renderCache
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val arr = ref(_uA<String>())
            val result = ref(0)
            val str = ref("")
            watch(str, fun(newVal: String){
                emit("str", newVal)
            }
            )
            watch(result, fun(newVal: Number){
                emit("result", newVal)
            }
            )
            val reply = fun(){
                str.value = calcular.calcStr(arr.value)
                result.value = calcular.calcResult(str.value)
            }
            val closePopup = fun(){
                emit("close")
            }
            val clickNumber = fun(num: Number){
                arr.value.push(num.toString(10))
                reply()
            }
            val clickDel = fun(){
                if (arr.value.length < 1) {
                    return
                }
                arr.value.splice(arr.value.length - 1, 1)
                reply()
            }
            val clickAdd = fun(){
                arr.value.push("+")
                reply()
            }
            val clickZero = fun(){
                arr.value.push(".")
                reply()
            }
            val confirm = fun(){
                emit("confirm")
            }
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_fui_bottom_popup = resolveEasyComponent("fui-bottom-popup", GenUniModulesFirstuiUvueComponentsFuiBottomPopupFuiBottomPopupClass)
                return _cV(_component_fui_bottom_popup, _uM("visible" to _ctx.isShow, "onClose" to closePopup, "radius" to 0, "maskBackground" to "#00000000"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "fui-custom__wrap background-white"), _uA(
                            _cE("view", _uM("class" to "numberbtnlist display-flex"), _uA(
                                _cE("view", _uM("class" to "numberbtn", "onClick" to fun(){
                                    clickNumber(1)
                                }
                                ), _uA(
                                    _cE("text", _uM("class" to "text"), "1")
                                ), 8, _uA(
                                    "onClick"
                                )),
                                _cE("view", _uM("class" to "numberbtn", "onClick" to fun(){
                                    clickNumber(2)
                                }
                                ), _uA(
                                    _cE("text", _uM("class" to "text"), "2")
                                ), 8, _uA(
                                    "onClick"
                                )),
                                _cE("view", _uM("class" to "numberbtn", "onClick" to fun(){
                                    clickNumber(3)
                                }
                                ), _uA(
                                    _cE("text", _uM("class" to "text"), "3")
                                ), 8, _uA(
                                    "onClick"
                                )),
                                _cE("view", _uM("class" to "numberbtn", "onClick" to clickDel), _uA(
                                    _cE("view", _uM("class" to "tuige"), _uA(
                                        _cV(_component_x_iconfont, _uM("class" to "tuige", "name" to "tuige", "size" to "28", "color" to "#464646"))
                                    ))
                                ))
                            )),
                            _cE("view", _uM("class" to "numberbtnlist display-flex"), _uA(
                                _cE("view", _uM("class" to "numberbtn", "onClick" to fun(){
                                    clickNumber(4)
                                }
                                ), _uA(
                                    _cE("text", _uM("class" to "text"), "4")
                                ), 8, _uA(
                                    "onClick"
                                )),
                                _cE("view", _uM("class" to "numberbtn", "onClick" to fun(){
                                    clickNumber(5)
                                }
                                ), _uA(
                                    _cE("text", _uM("class" to "text"), "5")
                                ), 8, _uA(
                                    "onClick"
                                )),
                                _cE("view", _uM("class" to "numberbtn", "onClick" to fun(){
                                    clickNumber(6)
                                }
                                ), _uA(
                                    _cE("text", _uM("class" to "text"), "6")
                                ), 8, _uA(
                                    "onClick"
                                )),
                                _cE("view", _uM("class" to "numberbtn", "onClick" to clickAdd), _uA(
                                    _cE("text", _uM("class" to "text"), "+")
                                ))
                            )),
                            _cE("view", _uM("class" to "display-flex"), _uA(
                                _cE("view", _uM("class" to "numberbtnlist"), _uA(
                                    _cE("view", _uM("class" to "numberb display-flex"), _uA(
                                        _cE("view", _uM("class" to "numberbtn", "onClick" to fun(){
                                            clickNumber(7)
                                        }
                                        ), _uA(
                                            _cE("text", _uM("class" to "text"), "7")
                                        ), 8, _uA(
                                            "onClick"
                                        )),
                                        _cE("view", _uM("class" to "numberbtn", "onClick" to fun(){
                                            clickNumber(8)
                                        }
                                        ), _uA(
                                            _cE("text", _uM("class" to "text"), "8")
                                        ), 8, _uA(
                                            "onClick"
                                        )),
                                        _cE("view", _uM("class" to "numberbtn", "onClick" to fun(){
                                            clickNumber(9)
                                        }
                                        ), _uA(
                                            _cE("text", _uM("class" to "text"), "9")
                                        ), 8, _uA(
                                            "onClick"
                                        ))
                                    )),
                                    _cE("view", _uM("class" to "numberb display-flex"), _uA(
                                        _cE("view", _uM("class" to "numberbtnbig", "onClick" to fun(){
                                            clickNumber(0)
                                        }
                                        ), _uA(
                                            _cE("text", _uM("class" to "text"), "0")
                                        ), 8, _uA(
                                            "onClick"
                                        )),
                                        _cE("view", _uM("class" to "numberbtn", "onClick" to clickZero), _uA(
                                            _cE("text", _uM("class" to "text"), ".")
                                        ))
                                    ))
                                )),
                                _cE("view", _uM("class" to "cashreceiver", "onClick" to confirm), _uA(
                                    _cE("text", _uM("class" to "text color-white align-center"), "收"),
                                    _cE("text", _uM("class" to "text color-white align-center"), "款")
                                ))
                            ))
                        ))
                    )
                }
                ), "_" to 1), 8, _uA(
                    "visible"
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
                return _uM("fui-custom__wrap" to _pS(_uM("height" to "720rpx", "width" to "750rpx", "borderTopWidth" to 1, "borderTopStyle" to "solid", "borderTopColor" to "#cccccc")), "numberbtn" to _uM(".fui-custom__wrap .numberbtnlist " to _uM("width" to "187.5rpx", "height" to "180rpx", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#ececec", "borderRightColor" to "#ececec", "borderBottomColor" to "#ececec", "borderLeftColor" to "#ececec")), "tuige" to _uM(".fui-custom__wrap .numberbtnlist .numberbtn " to _uM("marginTop" to 0, "marginRight" to "auto", "marginBottom" to 0, "marginLeft" to "auto", "paddingTop" to "60rpx")), "numberbtnbig" to _uM(".fui-custom__wrap .numberbtnlist " to _uM("width" to "375rpx", "height" to "180rpx", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#ececec", "borderRightColor" to "#ececec", "borderBottomColor" to "#ececec", "borderLeftColor" to "#ececec")), "text" to _uM(".fui-custom__wrap .numberbtnlist " to _uM("textAlign" to "center", "lineHeight" to "180rpx", "fontSize" to 32), ".fui-custom__wrap .cashreceiver " to _uM("fontSize" to 25, "lineHeight" to "40px")), "cashreceiver" to _uM(".fui-custom__wrap " to _uM("height" to "360rpx", "width" to "187.5rpx", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#ececec", "borderRightColor" to "#ececec", "borderBottomColor" to "#ececec", "borderLeftColor" to "#ececec", "backgroundColor" to "#1776FC", "paddingTop" to "94rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("str" to null, "result" to null, "close" to null, "confirm" to null)
        var props = _nP(_uM("isShow" to _uM("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = _uA(
            "isShow"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
