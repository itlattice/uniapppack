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
open class GenPagesComponentCoverViewCoverView : BasePage {
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
        var setup: (__props: GenPagesComponentCoverViewCoverView) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentCoverViewCoverView
            val _cache = __ins.renderCache
            val showMap = ref(false)
            val latitude = ref(39.909)
            val longitude = ref(116.39742)
            onLoad(fun(_options){
                showMap.value = true
            }
            )
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                val _component_map = resolveComponent("map")
                return _cE("view", null, _uA(
                    _cV(_component_page_head, _uM("title" to "cover-view用于覆盖map、video等原生组件")),
                    _cE("view", _uM("class" to "uni-padding-wrap uni-common-mb"), _uA(
                        _cE("text", _uM("class" to "uni-subtitle-text"), "注意：Web和App需正确配置地图SDK的Key才能正常显示地图组件")
                    )),
                    if (isTrue(unref(showMap))) {
                        _cE("view", _uM("key" to 0, "class" to "cover-content"), _uA(
                            _cV(_component_map, _uM("class" to "map", "latitude" to unref(latitude), "longitude" to unref(longitude)), null, 8, _uA(
                                "latitude",
                                "longitude"
                            )),
                            _cE("cover-view", _uM("class" to "cover-view"), _uA(
                                _cE("text", null, "简单的cover-view")
                            )),
                            _cE("image", _uM("class" to "cover-image", "src" to "/static/test-image/logo.png"))
                        ))
                    } else {
                        _cC("v-if", true)
                    }
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
                return _uM("map" to _pS(_uM("width" to "100%", "height" to 600)), "cover-content" to _pS(_uM("position" to "relative")), "cover-view" to _pS(_uM("position" to "absolute", "left" to 5, "top" to 5, "width" to 188, "textAlign" to "center", "backgroundColor" to "#DDDDDD")), "cover-image" to _pS(_uM("position" to "absolute", "left" to 0, "top" to 0, "right" to 0, "bottom" to 0, "marginTop" to "auto", "marginRight" to "auto", "marginBottom" to "auto", "marginLeft" to "auto", "width" to 96, "height" to 96)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
