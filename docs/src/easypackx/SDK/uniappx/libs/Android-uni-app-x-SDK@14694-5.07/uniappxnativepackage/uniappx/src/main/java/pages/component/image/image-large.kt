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
open class GenPagesComponentImageImageLarge : BasePage {
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
        var setup: (__props: GenPagesComponentImageImageLarge) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentImageImageLarge
            val _cache = __ins.renderCache
            val title = ref("image-large")
            val src = ref("https://qiniu-web-assets.dcloud.net.cn/uni-app-x/static/img/building.jpg")
            val width = ref(0)
            val height = ref(0)
            val memory = ref(0)
            fun gen_load_fn(event: ImageLoadEvent) {
                width.value = event.detail.width
                height.value = event.detail.height
                memory.value = Math.round(width.value * height.value * 4 / 1024 / 1024 * 100) / 100
            }
            val load = ::gen_load_fn
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cV(_component_page_head, _uM("title" to unref(title)), null, 8, _uA(
                        "title"
                    )),
                    _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt"), _uA(
                        _cE("view", _uM("class" to "uni-title"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "大图示例")
                        )),
                        _cE(Fragment, null, RenderHelpers.renderList(10, fun(_, __key, __index, _cached): Any {
                            return _cE("view", _uM("class" to "uni-common-mt"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "width=" + _tD(unref(width)) + "px height=" + _tD(unref(height)) + "px memory=" + _tD(unref(memory)) + "MB", 1),
                                _cE("image", _uM("class" to "image", "mode" to "widthFix", "src" to unref(src), "onLoad" to load), null, 40, _uA(
                                    "src"
                                ))
                            ))
                        }
                        ), 64)
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
                return _uM("image" to _pS(_uM("width" to "100%")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
