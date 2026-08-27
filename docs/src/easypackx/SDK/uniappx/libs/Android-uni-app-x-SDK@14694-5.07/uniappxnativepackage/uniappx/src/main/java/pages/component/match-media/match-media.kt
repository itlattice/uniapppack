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
open class GenPagesComponentMatchMediaMatchMedia : BasePage {
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
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _cache = this.`$`.renderCache
        val _component_page_intro = resolveEasyComponent("page-intro", GenComponentsPageIntroPageIntroClass)
        return _cE("view", null, _uA(
            _cV(_component_page_intro, _uM("style" to _nS(_uM("margin" to "10px 20px 0")), "content" to "本页演示 match-media 媒体查询组件：按 min-width、max-width、width、高度与 orientation 等条件匹配，控制子节点在不同屏幕下的显示。"), null, 8, _uA(
                "style"
            )),
            _cE("view", _uM("class" to "container"), _uA(
                _cE("view", _uM("class" to "section"), _uA(
                    _cE("text", _uM("class" to "subtitle"), "基础条件匹配"),
                    _cE("match-media", _uM("min-width" to 400), _uA(
                        _cE("view", _uM("class" to "demo-box"), "屏幕宽度 ≥ 400px 时显示")
                    )),
                    _cE("match-media", _uM("max-width" to 600), _uA(
                        _cE("view", _uM("class" to "demo-box"), "屏幕宽度 ≤ 600px 时显示")
                    )),
                    _cE("match-media", _uM("width" to 375), _uA(
                        _cE("view", _uM("class" to "demo-box"), "屏幕宽度 = 375px 时显示")
                    )),
                    _cE("match-media", _uM("min-height" to 600), _uA(
                        _cE("view", _uM("class" to "demo-box"), "屏幕高度 ≥ 600px 时显示")
                    )),
                    _cE("match-media", _uM("max-height" to 800), _uA(
                        _cE("view", _uM("class" to "demo-box"), "屏幕高度 ≤ 800px 时显示")
                    )),
                    _cE("match-media", _uM("height" to 667), _uA(
                        _cE("view", _uM("class" to "demo-box"), "屏幕高度 = 667px 时显示")
                    )),
                    _cE("match-media", _uM("orientation" to "portrait"), _uA(
                        _cE("view", _uM("class" to "demo-box"), "竖屏 时显示")
                    )),
                    _cE("match-media", _uM("orientation" to "landscape"), _uA(
                        _cE("view", _uM("class" to "demo-box"), "横屏 时显示")
                    ))
                )),
                _cE("view", _uM("class" to "section"), _uA(
                    _cE("text", _uM("class" to "subtitle"), "组合条件匹配"),
                    _cE("match-media", _uM("min-width" to 500, "max-width" to 1000, "orientation" to "landscape"), _uA(
                        _cE("view", _uM("class" to "demo-box"), "横屏 且宽度在 500px ~ 1000px 时显示")
                    )),
                    _cE("match-media", _uM("min-height" to 200, "max-height" to 800, "orientation" to "portrait"), _uA(
                        _cE("view", _uM("class" to "demo-box"), "竖屏 且高度在 200px ~ 800px 时显示")
                    )),
                    _cE("match-media", _uM("min-width" to 300, "max-width" to 900, "min-height" to 400, "max-height" to 800, "orientation" to "portrait"), _uA(
                        _cE("view", _uM("class" to "demo-box"), "竖屏 且宽度在 300px ~ 900px，高度在 400px ~ 800px 时显示")
                    ))
                ))
            ))
        ))
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("container" to _pS(_uM("paddingTop" to 20, "paddingRight" to 20, "paddingBottom" to 20, "paddingLeft" to 20)), "section" to _pS(_uM("paddingTop" to 5)), "subtitle" to _pS(_uM("fontSize" to 20, "fontWeight" to "bold", "marginBottom" to 5)), "demo-box" to _pS(_uM("paddingTop" to 5, "paddingRight" to 0, "paddingBottom" to 5, "paddingLeft" to 0)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
