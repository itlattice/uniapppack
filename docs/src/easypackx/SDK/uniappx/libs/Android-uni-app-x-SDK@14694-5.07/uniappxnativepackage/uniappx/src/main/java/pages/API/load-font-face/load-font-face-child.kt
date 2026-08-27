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
open class GenPagesAPILoadFontFaceLoadFontFaceChild : BasePage {
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
        var setup: (__props: GenPagesAPILoadFontFaceLoadFontFaceChild) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPILoadFontFaceLoadFontFaceChild
            val _cache = __ins.renderCache
            val uniIcon1 = ref("\ue100")
            val uniIcon2 = ref("\ue101")
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE(Fragment, null, _uA(
                    _cV(_component_page_head, _uM("title" to "loadFontFace-child")),
                    _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                        _cE("text", _uM("class" to "font-size-20"), "上一页全局加载字体："),
                        _cE("text", _uM("class" to "font-size-20 line-height-40", "style" to _nS(_uM("font-family" to "UniFontFamily"))), "font-family: uni.ttf", 4),
                        _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row"))), _uA(
                            _cE("text", _uM("style" to _nS(_uM("font-family" to "UniFontFamily", "font-size" to "20px"))), _tD(unref(uniIcon1)), 5),
                            _cE("text", _uM("style" to _nS(_uM("margin-left" to "5px", "margin-right" to "20px", "line-height" to "22px"))), "\\ue100", 4),
                            _cE("text", _uM("style" to _nS(_uM("font-family" to "UniFontFamily", "font-size" to "20px"))), _tD(unref(uniIcon2)), 5),
                            _cE("text", _uM("style" to _nS(_uM("margin-left" to "5px", "line-height" to "22px"))), "\\ue101", 4)
                        ), 4),
                        _cE("text", _uM("class" to "uni-common-mt font-size-20"), "上一页非全局加载字体（不生效为正常）："),
                        _cE("text", _uM("class" to "font-size-20 line-height-40", "style" to _nS(_uM("font-family" to "AlimamaDaoLiTiTTF"))), "font-family: 阿里妈妈刀隶体-ttf", 4),
                        _cE("text", _uM("class" to "font-size-20 line-height-40", "style" to _nS(_uM("font-family" to "AlimamaDaoLiTiOTF"))), "font-family: 阿里妈妈刀隶体-otf", 4)
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
                return _uM("font-size-20" to _pS(_uM("fontSize" to 20)), "line-height-40" to _pS(_uM("lineHeight" to "40px")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
