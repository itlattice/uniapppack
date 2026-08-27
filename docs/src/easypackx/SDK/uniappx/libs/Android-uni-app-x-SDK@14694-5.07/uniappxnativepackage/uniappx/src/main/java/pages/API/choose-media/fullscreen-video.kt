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
import io.dcloud.uniapp.extapi.`$emit` as uni__emit
import io.dcloud.uniapp.extapi.`$once` as uni__once
open class GenPagesAPIChooseMediaFullscreenVideo : BasePage {
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
        var setup: (__props: GenPagesAPIChooseMediaFullscreenVideo) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIChooseMediaFullscreenVideo
            val _cache = __ins.renderCache
            val url = ref("")
            val coverPath = ref("")
            onLoad(fun(options: OnLoadOptions){
                uni__once("__ONRECEIVEURL", fun(value: UTSJSONObject){
                    url.value = value["url"] as String
                    coverPath.value = value["cover"] as String
                }
                )
                uni__emit("__ONFULLVIDEOLOAD", null)
            }
            )
            return fun(): Any? {
                val _component_uni_back_arrow_circle = resolveEasyComponent("uni-back-arrow-circle", GenComponentsUniBackArrowCircleUniBackArrowCircleClass)
                return _cE("view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cV(_component_uni_back_arrow_circle, _uM("class" to "back", "arrow-class" to "arrow")),
                    _cE("video", _uM("ref" to "video", "class" to "video-box", "src" to unref(url), "controls" to "false", "autoplay" to "true", "show-progress" to "false", "show-fullscreen-btn" to "false", "show-play-btn" to "false", "show-center-play-btn" to "false"), null, 8, _uA(
                        "src"
                    ))
                ), 4)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("video-box" to _pS(_uM("width" to "100%", "flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "height" to "100%")), "back" to _pS(_uM("position" to "absolute", "top" to CSS_VAR_STATUS_BAR_HEIGHT, "zIndex" to 10)), "arrow" to _pS(_uM("!borderLeftColor" to "#FFFFFF", "!borderBottomColor" to "#FFFFFF")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
