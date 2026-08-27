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
import uts.sdk.modules.utsOpenSchema.openSchema
open class GenPagesTemplateSchemaSchema : BasePage {
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
        var setup: (__props: GenPagesTemplateSchemaSchema) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesTemplateSchemaSchema
            val _cache = __ins.renderCache
            return fun(): Any? {
                return _cE("view", null, _uA(
                    _cE("button", _uM("class" to "button", "onClick" to fun(){
                        unref(openSchema)("https://uniapp.dcloud.io/uni-app-x")
                    }
                    ), "使用外部浏览器打开指定URL", 8, _uA(
                        "onClick"
                    )),
                    _cE("button", _uM("class" to "button", "onClick" to fun(){
                        unref(openSchema)("market://details?id=com.tencent.mm")
                    }
                    ), "使用应用商店打开指定App", 8, _uA(
                        "onClick"
                    )),
                    _cE("button", _uM("class" to "button", "onClick" to fun(){
                        unref(openSchema)("androidamap://viewMap?sourceApplication=Hello%20uni-app&poiname=DCloud&lat=39.9631018208&lon=116.3406135236&dev=0")
                    }
                    ), " 打开地图坐标 ", 8, _uA(
                        "onClick"
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
                return _uM("button" to _pS(_uM("marginTop" to 15, "marginRight" to 15, "marginBottom" to 15, "marginLeft" to 15)), "tip" to _pS(_uM("paddingTop" to 8, "paddingRight" to 8, "paddingBottom" to 8, "paddingLeft" to 8)), "link" to _pS(_uM("color" to "#7A7E83", "fontSize" to 14, "lineHeight" to "20px")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
