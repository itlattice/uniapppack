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
open class GenComponentsPageIntroPageIntro : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var content: String by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsPageIntroPageIntro) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsPageIntroPageIntro
            val _cache = __ins.renderCache
            val isDarkMode = computed(fun(): Boolean {
                return state.isDarkMode
            }
            )
            val expanded = ref(false)
            val toggle = fun(){
                expanded.value = !expanded.value
            }
            return fun(): Any? {
                return _cE("view", _uM("class" to _nC(_uA(
                    "page-intro",
                    if (unref(isDarkMode)) {
                        "theme-dark"
                    } else {
                        "theme-light"
                    }
                )), "onClick" to toggle), _uA(
                    _cE("view", _uM("class" to "page-intro-header"), _uA(
                        _cE("text", _uM("class" to "page-intro-label"), "页面介绍"),
                        _cE("text", _uM("class" to "page-intro-arrow"), _tD(if (unref(expanded)) {
                            "▲"
                        } else {
                            "▼"
                        }
                        ), 1)
                    )),
                    if (isTrue(unref(expanded))) {
                        _cE("view", _uM("key" to 0, "class" to "page-intro-body"), _uA(
                            _cE("text", _uM("class" to "page-intro-content"), _tD(_ctx.content), 1)
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                ), 2)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("theme-light" to _pS(_uM("--page-intro-border-color" to "#91caff", "--page-intro-bg-color" to "#e6f4ff", "--page-intro-title-color" to "#0958d9", "--page-intro-divider-color" to "#91caff", "--page-intro-content-color" to "#1d39c4")), "theme-dark" to _pS(_uM("--page-intro-border-color" to "#1d39c4", "--page-intro-bg-color" to "#0b1b3a", "--page-intro-title-color" to "#91caff", "--page-intro-divider-color" to "rgba(145, 202, 255, 0.35)", "--page-intro-content-color" to "rgba(145, 202, 255, 0.9)")), "page-intro" to _pS(_uM("marginTop" to 10, "marginRight" to 10, "marginBottom" to 10, "marginLeft" to 10, "borderTopLeftRadius" to 4, "borderTopRightRadius" to 4, "borderBottomRightRadius" to 4, "borderBottomLeftRadius" to 4, "borderLeftWidth" to 4, "borderLeftStyle" to "solid", "borderLeftColor" to "var(--page-intro-border-color, #91caff)", "backgroundColor" to "var(--page-intro-bg-color, #e6f4ff)", "overflow" to "hidden")), "page-intro-header" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "paddingTop" to 9, "paddingRight" to 12, "paddingBottom" to 9, "paddingLeft" to 12)), "page-intro-label" to _pS(_uM("fontSize" to 13, "color" to "var(--page-intro-title-color, #0958d9)", "fontWeight" to "bold")), "page-intro-arrow" to _pS(_uM("fontSize" to 11, "color" to "var(--page-intro-title-color, #0958d9)")), "page-intro-body" to _pS(_uM("paddingTop" to 12, "paddingRight" to 10, "paddingBottom" to 12, "paddingLeft" to 10, "borderTopWidth" to 1, "borderTopStyle" to "solid", "borderTopColor" to "var(--page-intro-divider-color, #91caff)")), "page-intro-content" to _pS(_uM("fontSize" to 13, "color" to "var(--page-intro-content-color, #1d39c4)", "lineHeight" to "22px")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("content" to _uM("type" to "String", "default" to "")))
        var propsNeedCastKeys = _uA(
            "content"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
