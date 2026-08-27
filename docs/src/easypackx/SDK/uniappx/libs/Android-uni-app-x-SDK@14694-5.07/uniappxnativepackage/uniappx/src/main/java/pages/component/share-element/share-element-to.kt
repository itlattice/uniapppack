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
import io.dcloud.uniapp.extapi.navigateBack as uni_navigateBack
open class GenPagesComponentShareElementShareElementTo : BasePage {
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
        var setup: (__props: GenPagesComponentShareElementShareElementTo) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentShareElementShareElementTo
            val _cache = __ins.renderCache
            val shuttleOnPush = ref("to")
            val transitionOnGesture = ref(false)
            fun gen_openPage_fn() {
                uni_navigateBack(null)
            }
            val openPage = ::gen_openPage_fn
            onLoad(fun(event: OnLoadOptions){
                shuttleOnPush.value = event["shuttleOnPush"] as String
                transitionOnGesture.value = event["transitionOnGesture"] === "true"
                console.log("shuttleOnPush:" + shuttleOnPush.value + " transitionOnGesture:" + transitionOnGesture.value)
            }
            )
            return fun(): Any? {
                return _cE(Fragment, null, _uA(
                    _cE("view", _uM("class" to "main"), _uA(
                        _cE("share-element", _uM("class" to "share-element", "share-key" to "left", "shuttle-on-pop" to unref(shuttleOnPush), "transition-on-gesture" to unref(transitionOnGesture), "onClick" to fun(){
                            openPage()
                        }
                        ), _uA(
                            _cE("image", _uM("src" to "https://web-ext-storage.dcloud.net.cn/hello-uni-app-x/drop-card-1.jpg", "mode" to "widthFix")),
                            _cE("view", _uM("class" to "text-label"), _uA(
                                _cE("text", _uM("style" to _nS(_uM("color" to "white"))), "每一口，都是幸福", 4)
                            ))
                        ), 8, _uA(
                            "shuttle-on-pop",
                            "transition-on-gesture",
                            "onClick"
                        ))
                    )),
                    _cE("share-element", _uM("class" to "bottomWrap", "share-key" to "bottom", "onClick" to fun(){
                        openPage()
                    }
                    , "transitionOnGesture" to "true"), _uA(
                        _cE("view", _uM("class" to "bottom"), _uA(
                            _cE("text", _uM("style" to _nS(_uM("color" to "white"))), "share-element(底部固定)", 4)
                        ))
                    ), 8, _uA(
                        "onClick"
                    ))
                ), 64)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("bottomWrap" to _pS(_uM("width" to "100%", "bottom" to 0, "height" to 80, "position" to "fixed")), "bottom" to _pS(_uM("width" to "100%", "height" to "100%", "alignItems" to "center", "justifyContent" to "center", "backgroundColor" to "#007aff")), "text-label" to _pS(_uM("position" to "absolute", "backgroundColor" to "#007aff", "opacity" to 0.8, "textAlign" to "center", "justifyContent" to "center", "alignItems" to "center", "bottom" to 0, "left" to 0, "right" to 0, "height" to 30)), "main" to _pS(_uM("paddingTop" to 5, "paddingRight" to 5, "paddingBottom" to 5, "paddingLeft" to 5, "alignItems" to "center", "justifyContent" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
