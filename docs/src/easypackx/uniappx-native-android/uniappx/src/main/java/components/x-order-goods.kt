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
open class GenComponentsXOrderGoods : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var goods: UTSJSONObject by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXOrderGoods) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXOrderGoods
            val _cache = __ins.renderCache
            val props = __props
            val viewimg = ref<UniElement?>(null)
            val images = computed(fun(): String {
                var data = props.goods["goods_data"] as UTSJSONObject
                var list = data["images"] as UTSArray<String>
                return list[0]
            }
            )
            val info = computed(fun(): UTSJSONObject {
                var data = props.goods["goods_data"] as UTSJSONObject
                return data
            }
            )
            val showImg = fun(){
                common.callMethod(viewimg.value as Any, "open", images.value)
            }
            val goodsNumber = computed(fun(): Number {
                return UTSNumber.from((props.goods["number"] as Any).toString())
            }
            )
            val goodsAmountText = computed(fun(): String {
                return UTSNumber.from((props.goods["amount"] as Any).toString()).toFixed(2)
            }
            )
            val showCode = fun(){
                var code = info.value["code"] as String
                var url = "https://api.itgz8.com/v1/direct/image-qrcode?txt=" + code
                common.callMethod(viewimg.value as Any, "open", url)
            }
            return fun(): Any? {
                val _component_x_previewimg = resolveEasyComponent("x-previewimg", GenComponentsXPreviewimgClass)
                return _cE("view", _uM("class" to "goods space-between"), _uA(
                    _cE("view", _uM("class" to "basicinfo display-flex"), _uA(
                        _cE("image", _uM("class" to "image", "onClick" to showImg, "src" to unref(images)), null, 8, _uA(
                            "src"
                        )),
                        _cE("view", _uM("class" to "goodsname", "onClick" to showCode), _uA(
                            _cE("text", _uM("class" to "overline2 name"), _tD(unref(info)["name"]), 1)
                        )),
                        _cE("text", _uM("class" to "code", "onClick" to showCode), _tD(unref(info)["code"]), 1)
                    )),
                    _cE("view", _uM("class" to "numberinfo"), _uA(
                        _cE("view", _uM("class" to "numb"), _uA(
                            _cE("text", _uM("class" to "number"), "x" + _tD(unref(goodsNumber)), 1)
                        ))
                    )),
                    if (isTrue(_ctx.goods["amount"])) {
                        _cE("view", _uM("key" to 0, "class" to "yuguinfo display-flex"), _uA(
                            _cE("text", _uM("class" to "t align-right"), "预估"),
                            _cE("text", _uM("class" to "num align-right"), "￥" + _tD(unref(goodsAmountText)), 1)
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    _cV(_component_x_previewimg, _uM("ref_key" to "viewimg", "ref" to viewimg), null, 512)
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
                return _uM("goods" to _pS(_uM("position" to "relative", "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#F5F5F5")), "basicinfo" to _uM(".goods " to _uM("paddingLeft" to 12, "paddingRight" to 6)), "image" to _uM(".goods .basicinfo " to _uM("height" to 40, "width" to 40)), "goodsname" to _uM(".goods .basicinfo " to _uM("paddingLeft" to 3, "paddingTop" to 3)), "name" to _uM(".goods .basicinfo .goodsname " to _uM("maxWidth" to "450rpx", "fontSize" to 14)), "code" to _uM(".goods .basicinfo " to _uM("position" to "absolute", "left" to 55, "bottom" to 1, "fontSize" to 11, "color" to "#ABABAB")), "numberinfo" to _uM(".goods " to _uM("paddingRight" to 6)), "number" to _uM(".goods .numberinfo .numb " to _uM("fontSize" to 13)), "yuguinfo" to _uM(".goods " to _uM("position" to "absolute", "right" to 6, "bottom" to 1)), "t" to _uM(".goods .yuguinfo " to _uM("fontSize" to 13)), "num" to _uM(".goods .yuguinfo " to _uM("color" to "#FF8D1A", "fontSize" to 13)))
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
