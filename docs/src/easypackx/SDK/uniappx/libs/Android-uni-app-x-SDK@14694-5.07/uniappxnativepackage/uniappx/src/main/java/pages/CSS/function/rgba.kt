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
open class GenPagesCSSFunctionRgba : BasePage {
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
        return _cE("view", _uM("class" to "container"), _uA(
            _cE("text", _uM("class" to "intro-text"), "RGBA 在 RGB 的基础上增加了透明度(Alpha)通道，取值范围为 0-1，0 表示完全透明，1 表示完全不透明。"),
            _cE("view", _uM("class" to "section"), _uA(
                _cE("text", _uM("class" to "section-title"), "数值表示 (RGB: 0-255, A: 0-1)"),
                _cE("view", _uM("class" to "color-grid"), _uA(
                    _cE("view", _uM("class" to "color-item"), _uA(
                        _cE("view", _uM("class" to "color-box", "style" to _nS(_uM("background-color" to "rgba(255, 0, 0, 0.1)"))), null, 4),
                        _cE("text", _uM("class" to "color-name"), "红色 10% 透明"),
                        _cE("text", _uM("class" to "color-value"), "rgba(255, 0, 0, 0.1)")
                    )),
                    _cE("view", _uM("class" to "color-item"), _uA(
                        _cE("view", _uM("class" to "color-box", "style" to _nS(_uM("background-color" to "rgba(255, 0, 0, 0.5)"))), null, 4),
                        _cE("text", _uM("class" to "color-name"), "红色 50% 透明"),
                        _cE("text", _uM("class" to "color-value"), "rgba(255, 0, 0, 0.5)")
                    )),
                    _cE("view", _uM("class" to "color-item"), _uA(
                        _cE("view", _uM("class" to "color-box", "style" to _nS(_uM("background-color" to "rgba(255, 0, 0, 1)"))), null, 4),
                        _cE("text", _uM("class" to "color-name"), "红色 不透明"),
                        _cE("text", _uM("class" to "color-value"), "rgba(255, 0, 0, 1)")
                    ))
                ))
            )),
            _cE("view", _uM("class" to "section"), _uA(
                _cE("view", _uM("class" to "color-grid"), _uA(
                    _cE("view", _uM("class" to "color-item"), _uA(
                        _cE("view", _uM("class" to "color-box", "style" to _nS(_uM("background-color" to "rgba(0, 0, 255, 0.1)"))), null, 4),
                        _cE("text", _uM("class" to "color-name"), "蓝色 10% 透明"),
                        _cE("text", _uM("class" to "color-value"), "rgba(0, 0, 255, 0.1)")
                    )),
                    _cE("view", _uM("class" to "color-item"), _uA(
                        _cE("view", _uM("class" to "color-box", "style" to _nS(_uM("background-color" to "rgba(0, 0, 255, 0.5)"))), null, 4),
                        _cE("text", _uM("class" to "color-name"), "蓝色 50% 透明"),
                        _cE("text", _uM("class" to "color-value"), "rgba(0, 0, 255, 0.5)")
                    )),
                    _cE("view", _uM("class" to "color-item"), _uA(
                        _cE("view", _uM("class" to "color-box", "style" to _nS(_uM("background-color" to "rgba(0, 0, 255, 1)"))), null, 4),
                        _cE("text", _uM("class" to "color-name"), "蓝色 不透明"),
                        _cE("text", _uM("class" to "color-value"), "rgba(0, 0, 255, 1)")
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
                return _uM("container" to _pS(_uM("paddingTop" to 20, "paddingRight" to 20, "paddingBottom" to 20, "paddingLeft" to 20)), "intro-text" to _pS(_uM("fontSize" to 14, "color" to "#333333", "marginBottom" to 30, "lineHeight" to 1.4)), "section" to _pS(_uM("marginBottom" to 30)), "section-title" to _pS(_uM("fontSize" to 18, "fontWeight" to "bold", "marginBottom" to 15)), "color-grid" to _pS(_uM("flexDirection" to "row", "flexWrap" to "wrap", "justifyContent" to "space-between")), "color-item" to _pS(_uM("width" to "30%", "marginBottom" to 20)), "color-box" to _pS(_uM("width" to "100%", "height" to 100, "borderTopLeftRadius" to 8, "borderTopRightRadius" to 8, "borderBottomRightRadius" to 8, "borderBottomLeftRadius" to 8, "marginBottom" to 8)), "color-name" to _pS(_uM("fontSize" to 16, "fontWeight" to "bold", "marginBottom" to 4)), "color-value" to _pS(_uM("fontSize" to 12, "color" to "#666666")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
