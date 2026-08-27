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
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
open class GenUniModulesUniPayXPagesSuccessSuccess : BasePage {
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
        var setup: (__props: GenUniModulesUniPayXPagesSuccessSuccess) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesUniPayXPagesSuccessSuccess
            val _cache = __ins.renderCache
            val myOptions = ref(_uO("adpid" to "", "order_no" to "", "out_trade_no" to "", "total_fee" to 0, "pay_date" to "", "return_url" to ""))
            val successImages = ref("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEAAAABAEAYAAAD6+a2dAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAAgY0hSTQAAeiYAAICEAAD6AAAAgOgAAHUwAADqYAAAOpgAABdwnLpRPAAAAAZiS0dEAAAAAAAA+UO7fwAAAAlwSFlzAAAASAAAAEgARslrPgAACAlJREFUeNrtnVlszF8Ux++d4B+JWhqERGJvlRJLJQ1RHsQeFEXFUmt5scWWiPVB2qKERIglSpEg9vJAYn8RQlRFI5ryYm+prbZ7/g/fOdPOtNPfdDrjzEx/n5dvf3fuTM895869v3t/997RKswhQ4ZM69a4SkpSWmmle/TAdbdu0JgYaIsW0ObNoU2auH/a16/QT5+gpaXQwkLos2fQggJFihTdvq0d2qEd795J+yHiQaD794dmZxMREeXnQ40hEfj/5ufDru3boQkJ0v4KW+DApk2hK1bAwU+fygS4rhQUuMphyJCJipL2b8gBR0VHQzdtgpaUSIcuOHC5Nm6EcpdUj0DBtcY3YuZMXL97Jx0aGT5+hC5ZAnU4pOMTvMAbMmS6dEFB796Vdn1ocucOtHNn6XgFLvBERJScDC0tlXZxeFBWBp06VTp+fgbc4YDu2CHtyrCHRxdEFNJdBAxt1AiGHj8u7bfI5Ngx+Llhw0DFTQcq8JiAOXsWqaNGyVXF+kBeHiaikpMxEfX7t7+f5HeTghqpNQK/fz9S7cD/G0aPht9zchAH/7uGOvYp2dnQmTOlXVI/SU1FS5CZ6e8n1LoLQJOfkoIaePKktAtsKjNtmtZaa33ihK/v8LkCoKnh8emDB9BmzaSLbFOZz5+hffuiIhQVWb3Dsgtw9fVKKaWOHIHagQ9NOC6HD7vHzTvW9wCkSNHcubgYMEC6iDa+MGgQ1PrezGsNQQ2KjkYFKCxEn9+ypXTRbGoDr1OIjUWXwOscKrBoAZYutQMfzvBCmcWLveWo0gLw83gEvrgYqfXwsWVEUVKClrxDB0wcffnCr3hpARYsgNqBjwyio/GFnj/f85WqFUArrfScOdIm1w/KyqA8hR5sZs/2THFVAF5zh6u4OGnXRDbfv0PHjoWmpEDPnQvu/42Px819nz6c4tECpKZKuyay+fEDOmYM7spv3oT+/Yv06dOhL18GzQRSpGjaNL6sqABaaaWHDZN2UWTy6xc0JQUBv369+ny8AKR9++DaM3Qo/6Vd6+q10kq/eeNMrvNjYhullOLHtJMmIfAXLnjmQJM8YgSuLl6ENmgQXLuI0BK0bu1sAZKSoHbgA8OfP9CpU2sOPPfF/FAt2IFn+DF+UpIDf8THS7ssMuC+PC0NgT9zxjMHWtx27XDFFUNqv0CPHs4WIDZWxoBIgZvURYsQ+GPHquQwZMg0a4Yv3OXLSOWKIEVsrLMCdO0qa0i4woFPT8cMG6+MqpTDkCHz338I/PnzSO3ZU9pyEBPj7HPsuf5aQ4oUrVrlNfBuj2MPHIAOHixttjstWzpbAM9dslIcOQLH8i7cUGXFCgR+27aa82VkQHl8H0KQIkVRUc6a+vOn7HLne/fcl5W3aIHr69dl7fJk7VpLvxoyZNLTpS31jfJy4QrAO4U6dqzekVwhcnNlHbV5s2+BHzMG+f/8kbXXV1wV4MMHGQNmzbJ0LBFVbCbdsuWfmWbIkMnK8s2+xETot28yfvS3fO/fOwtQXCxjxdOn7uNiH7ouIiKaMwf661dw7Nq1yzc7OnWCvn0r47+6UlTkLMj9+2I2GDJkXrzARadOtasII0dCv3wJjDF790K9z4jC3latkO/5czG/BYR795yODJW9fK9fw8G9evlcEQwZMj174v2vXvn3f3kVrfcdNni9cWNopGxvP3rUWWA+BEmaNm0wYXLjBgxMTLR6B4Zj+fm4SkzE8ObRI+uao0jRqVPQefMwg2dM9YF3OJAvNxepEbA6mhf7ooATJ0rXxerhffJDhvhcLueUK/Tateo/99QpvG798AX5d++W9kRwSE52HbOGBKnTtqwoL3cZXKuK0KAB3rdvH/TKFdfUrE+BX7VKuuTB4e9f+KHSDDBeePxY2rSa4bt+31cuIT8PI6331SP/lCkuR0UahgyZhw+5vBU3PaRI0bVrvjpWBg4gTwwtXGj1DvTtRFb76OEYXheRk+N0T+ieyFEnrl714oCEBOkK6h8bNvjrCrw/Lg4aqcfTedK7t4VD+ATOcCMjA2q9sgn52raFSk2E/WsKCjz9ULWJI0WKuAkMN1avhu7ZgwJXbcJdJ3aSIkV5eUgN9iLMUOHgQc8UL1vDoqIwHuflyeG6Q+jECQS60jMHrbTSvPhy+HBpC/8N3reGVRkHcwZ8g3hO3P8+VpbUVASc1zt8+ACtL4Fndu70DDxjsT2cv/k8U9iqlXRRbGrD27f45sfGogLwCSIVeB3mYPjE5+WvWSNdFJtaQooUrVzpLfCMj3fLfFd9+zZ04EDp8tnUxK1b0CFDeB7EW077kKiIgk8A6dcvYIdEMfjAFy/46Zl0UW2qY+5cXwPP1HqqE33K6dOoCHxQpI0sWVnediJZ4fdeQPd7g0OHoGlp0q6oXxw/Dp0xw9t6BisCdFh0w4YYb/MBB/aZwcHl0iW0wBMmiB0WzbgMIEWKxo2DcotgE1hycwMV+KDBXQNahq1bpR9/hDe8QCczExqG2/dh+Pjx0PryuLWufP4MnTxZOn4Brgi8jv7WLWkXhyY3b0Kr7pSKGFBAz5+NC9eNFXWFfzZuwQL2i3R8hCpE8+bQ9evdHRNp8Ba8detcB0bYuAPHNGkCRy1fDn3yRDp0/sErq5Yt43JJ+zdsgSP79HEfXTx6BJVavcvLqx8+5M2kSK9hzV2IEfZ9jmt9u/PUK4yTu3fHdVwcrvnn4/nM3Bp+Pp4UKeKHKiUlyF9Y6Dq4QiuttOfPx/NCk/Djf0hQD04eJaNOAAAAJXRFWHRkYXRlOmNyZWF0ZQAyMDIyLTEwLTI3VDE0OjAzOjAyKzA4OjAwisT1owAAACV0RVh0ZGF0ZTptb2RpZnkAMjAyMi0xMC0yN1QxNDowMzowMiswODowMPuZTR8AAABQdEVYdHN2ZzpiYXNlLXVyaQBmaWxlOi8vL2hvbWUvYWRtaW4vaWNvbi1mb250L3RtcC9pY29uX3ZwM212emVpcjcvemhpZnVjaGVuZ2dvbmcuc3ZntdPldAAAAABJRU5ErkJggg==")
            val color = ref(_uO("wxpay" to "#01be6e", "alipay" to "#108ee9"))
            fun gen_queryOrder_fn() {
                var return_url = myOptions.value["return_url"] as String
                var out_trade_no = myOptions.value["out_trade_no"] as String
                var order_no = myOptions.value["order_no"] as String
                var url = return_url + ("?out_trade_no=" + out_trade_no + "&order_no=" + order_no)
                if (url.indexOf("/") != 0) {
                    url = "/" + url
                }
                uni_navigateTo(NavigateToOptions(url = url))
            }
            val queryOrder = ::gen_queryOrder_fn
            fun gen_onaderror_fn(e: Any) {
                console.log("ad-error", e)
            }
            val onaderror = ::gen_onaderror_fn
            fun gen_amountFormat_fn(totalFee: Number?): String {
                if (totalFee == null || totalFee == 0) {
                    return "0"
                } else {
                    return (totalFee / 100).toFixed(2)
                }
            }
            val amountFormat = ::gen_amountFormat_fn
            onLoad(fun(options){
                myOptions.value["adpid"] = options["adpid"]
                myOptions.value["order_no"] = if (options["order_no"] != null) {
                    options["order_no"]
                } else {
                    "-"
                }
                myOptions.value["out_trade_no"] = options["out_trade_no"]
                if (options["total_fee"] != null) {
                    myOptions.value["total_fee"] = parseFloat(options["total_fee"] as String)
                }
                myOptions.value["pay_date"] = options["pay_date"]
                myOptions.value["return_url"] = options["return_url"]
            }
            )
            return fun(): Any? {
                return _cE("view", _uM("class" to "app"), _uA(
                    _cE("view", _uM("class" to "header"), _uA(
                        _cE("image", _uM("src" to unref(successImages), "class" to "header-success-image"), null, 8, _uA(
                            "src"
                        )),
                        _cE("view", null, _uA(
                            _cE("text", _uM("class" to "header-success-title-text"), "支付成功")
                        )),
                        _cE("view", _uM("class" to "header-hr"))
                    )),
                    _cE("view", _uM("class" to "info-box"), _uA(
                        _cE("view", _uM("class" to "info-box-amount"), _uA(
                            _cE("text", _uM("class" to "info-box-amount-text"), "¥ " + _tD(amountFormat(unref(myOptions).getNumber("total_fee"))), 1)
                        )),
                        _cE("view", _uM("class" to "info-box-left-circle")),
                        _cE("view", _uM("class" to "info-box-right-circle")),
                        _cE("view", _uM("class" to "info-box-main"), _uA(
                            _cE("view", _uM("class" to "info-box-cell"), _uA(
                                _cE("view", _uM("class" to "info-box-cell-left"), _uA(
                                    _cE("text", _uM("class" to "info-box-cell-left-text"), "订单编号")
                                )),
                                _cE("view", _uM("class" to "info-box-cell-right"), _uA(
                                    _cE("text", _uM("class" to "info-box-cell-right-text"), _tD(unref(myOptions)["order_no"]), 1)
                                ))
                            ))
                        ))
                    )),
                    _cE("view", _uM("class" to "uni-ad")),
                    if (isTrue(unref(myOptions)["return_url"])) {
                        _cE("view", _uM("key" to 0, "class" to "button-query", "onClick" to queryOrder), _uA(
                            _cE("text", _uM("class" to "button-query-text"), "查看订单")
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    _cE("view", _uM("class" to "footer-hr"))
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
                return _uM("app" to _pS(_uM("backgroundColor" to "#f3f3f3", "flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "header" to _pS(_uM("backgroundColor" to "#007aff", "display" to "flex", "alignItems" to "center", "paddingTop" to 40, "paddingRight" to 15, "paddingBottom" to 25, "paddingLeft" to 15)), "header-success-image" to _pS(_uM("width" to 60, "height" to 60)), "header-success-title-text" to _pS(_uM("color" to "#ffffff", "fontSize" to 17, "marginTop" to 20, "fontWeight" to "bold")), "header-hr" to _pS(_uM("marginTop" to 20, "width" to "100%", "height" to 15, "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "borderBottomRightRadius" to 10, "borderBottomLeftRadius" to 10, "opacity" to 0.1, "backgroundColor" to "#000000")), "info-box" to _pS(_uM("marginTop" to -32, "marginRight" to 25, "marginBottom" to 0, "marginLeft" to 25, "position" to "relative", "backgroundColor" to "#ffffff")), "info-box-amount" to _pS(_uM("height" to 75, "borderBottomWidth" to 2, "borderBottomStyle" to "dashed", "borderBottomColor" to "#f3f3f3")), "info-box-amount-text" to _pS(_uM("lineHeight" to "75px", "color" to "#007aff", "fontWeight" to "bold", "fontSize" to 30, "textAlign" to "center")), "info-box-left-circle" to _pS(_uM("backgroundColor" to "#f3f3f3", "position" to "absolute", "width" to 20, "height" to 20, "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "borderBottomRightRadius" to 10, "borderBottomLeftRadius" to 10, "top" to 65, "left" to -10)), "info-box-right-circle" to _pS(_uM("backgroundColor" to "#f3f3f3", "position" to "absolute", "width" to 20, "height" to 20, "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "borderBottomRightRadius" to 10, "borderBottomLeftRadius" to 10, "top" to 65, "right" to -10)), "info-box-main" to _pS(_uM("paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15)), "info-box-cell" to _pS(_uM("display" to "flex", "flexDirection" to "row")), "info-box-cell-left" to _pS(_uM("width" to 100)), "info-box-cell-left-text" to _pS(_uM("textAlign" to "left", "fontSize" to 13, "color" to "#333333")), "info-box-cell-right" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "info-box-cell-right-text" to _pS(_uM("textAlign" to "right", "fontSize" to 13, "color" to "#333333")), "uni-ad" to _pS(_uM("marginTop" to 25, "minHeight" to 50)), "ad-interactive" to _pS(_uM("textAlign" to "center")), "button-query" to _pS(_uM("backgroundColor" to "#007aff", "marginTop" to 25, "marginRight" to 30, "marginBottom" to 0, "marginLeft" to 30, "paddingTop" to 10, "paddingRight" to 15, "paddingBottom" to 10, "paddingLeft" to 15, "borderTopLeftRadius" to 25, "borderTopRightRadius" to 25, "borderBottomRightRadius" to 25, "borderBottomLeftRadius" to 25, "boxSizing" to "border-box", "opacity:active" to 0.7)), "button-query-text" to _pS(_uM("color" to "#ffffff", "textAlign" to "center")), "footer-hr" to _pS(_uM("height" to 50)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
