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
open class GenPagesCSSSpecificitySpecificity : BasePage {
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
        return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
            _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1"))), _uA(
                _cE("view", _uM("class" to "uni-common-mt"), _uA(
                    _cE("text", null, "多类名优先级测试 (.s1.s2 > .s1)"),
                    _cE("view", _uM("class" to "test-box s1", "id" to "spec-multi-1"), _uA(
                        _cE("text", null, "1 class: .s1 (blue)")
                    )),
                    _cE("view", _uM("class" to "test-box s1 s2", "id" to "spec-multi-2"), _uA(
                        _cE("text", null, "2 classes: .s1.s2 (green)")
                    )),
                    _cE("view", _uM("class" to "test-box s1 s2 s3", "id" to "spec-multi-3"), _uA(
                        _cE("text", null, "3 classes: .s1.s2.s3 (red)")
                    ))
                )),
                _cE("view", _uM("class" to "uni-common-mt"), _uA(
                    _cE("text", null, "字母排序测试 (测试编译是否受字母顺序影响)"),
                    _cE("view", _uM("class" to "test-box alpha beta", "id" to "spec-alpha-1"), _uA(
                        _cE("text", null, ".alpha defined before .beta (Gold)")
                    )),
                    _cE("view", _uM("class" to "test-box z-class a-class", "id" to "spec-alpha-2"), _uA(
                        _cE("text", null, ".z-class defined before .a-class (Cyan)")
                    ))
                )),
                _cE("view", _uM("class" to "uni-common-mt"), _uA(
                    _cE("text", null, "组合类名顺序测试 (Chained Classes Order)"),
                    _cE("text", null, "1. 字母序与定义序一致 (.ab.x then .ab.y)"),
                    _cE("view", _uM("class" to "test-box ab x y", "id" to "spec-chain-1"), _uA(
                        _cE("text", null, "Expect Green (.ab.y)")
                    )),
                    _cE("text", null, "2. 字母序与定义序相反 (.ab.z then .ab.w)"),
                    _cE("view", _uM("class" to "test-box ab z w", "id" to "spec-chain-2"), _uA(
                        _cE("text", null, "Expect Green (.ab.w)")
                    ))
                )),
                _cE("view", _uM("class" to "uni-common-mt"), _uA(
                    _cE("text", null, "特定前缀测试 (.a.b vs .a.c)"),
                    _cE("text", null, "1. Normal Order: .a.b then .a.c"),
                    _cE("view", _uM("class" to "test-box a b c", "id" to "spec-prefix-1"), _uA(
                        _cE("text", null, "Expect Green (.a.c)")
                    )),
                    _cE("text", null, "2. Inverse Order: .a.e then .a.d"),
                    _cE("view", _uM("class" to "test-box a d e", "id" to "spec-prefix-2"), _uA(
                        _cE("text", null, "Expect Green (.a.d)")
                    ))
                )),
                _cE("view", _uM("class" to "uni-common-mt"), _uA(
                    _cE("text", null, "完全无公共前缀测试 (Disjoint Classes)"),
                    _cE("text", null, "Inverse Order: .year-2025.month-12 then .year-2024.month-01"),
                    _cE("view", _uM("class" to "test-box year-2025 month-12 year-2024 month-01", "id" to "spec-disjoint"), _uA(
                        _cE("text", null, "Expect Green (2024)")
                    ))
                ))
            ), 4)
        ), 4)
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("test-box" to _pS(_uM("width" to 300, "height" to 100, "backgroundColor" to "#808080", "marginTop" to 10, "marginRight" to 10, "marginBottom" to 10, "marginLeft" to 10, "borderTopWidth" to 2, "borderRightWidth" to 2, "borderBottomWidth" to 2, "borderLeftWidth" to 2, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#000000", "borderRightColor" to "#000000", "borderBottomColor" to "#000000", "borderLeftColor" to "#000000", "justifyContent" to "center", "alignItems" to "center")), "class-style" to _pS(_uM("borderTopWidth" to 5, "borderRightWidth" to 5, "borderBottomWidth" to 5, "borderLeftWidth" to 5, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#0000FF", "borderRightColor" to "#0000FF", "borderBottomColor" to "#0000FF", "borderLeftColor" to "#0000FF", "backgroundColor" to "#ADD8E6")), "s1" to _uM("" to _uM("borderTopColor" to "#0000FF", "borderRightColor" to "#0000FF", "borderBottomColor" to "#0000FF", "borderLeftColor" to "#0000FF", "borderTopWidth" to 5, "borderRightWidth" to 5, "borderBottomWidth" to 5, "borderLeftWidth" to 5, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid"), ".s2" to _uM("borderTopColor" to "#008000", "borderRightColor" to "#008000", "borderBottomColor" to "#008000", "borderLeftColor" to "#008000"), ".s2.s3" to _uM("borderTopColor" to "#FF0000", "borderRightColor" to "#FF0000", "borderBottomColor" to "#FF0000", "borderLeftColor" to "#FF0000")), "order-first" to _pS(_uM("borderTopColor" to "#FFA500", "borderRightColor" to "#FFA500", "borderBottomColor" to "#FFA500", "borderLeftColor" to "#FFA500", "borderTopWidth" to 5, "borderRightWidth" to 5, "borderBottomWidth" to 5, "borderLeftWidth" to 5, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid")), "order-second" to _pS(_uM("borderTopColor" to "#800080", "borderRightColor" to "#800080", "borderBottomColor" to "#800080", "borderLeftColor" to "#800080")), "alpha" to _pS(_uM("borderTopColor" to "#C0C0C0", "borderRightColor" to "#C0C0C0", "borderBottomColor" to "#C0C0C0", "borderLeftColor" to "#C0C0C0", "borderTopWidth" to 5, "borderRightWidth" to 5, "borderBottomWidth" to 5, "borderLeftWidth" to 5, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid")), "beta" to _pS(_uM("borderTopColor" to "#FFD700", "borderRightColor" to "#FFD700", "borderBottomColor" to "#FFD700", "borderLeftColor" to "#FFD700")), "z-class" to _pS(_uM("borderTopColor" to "#A52A2A", "borderRightColor" to "#A52A2A", "borderBottomColor" to "#A52A2A", "borderLeftColor" to "#A52A2A", "borderTopWidth" to 5, "borderRightWidth" to 5, "borderBottomWidth" to 5, "borderLeftWidth" to 5, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid")), "a-class" to _pS(_uM("borderTopColor" to "#00FFFF", "borderRightColor" to "#00FFFF", "borderBottomColor" to "#00FFFF", "borderLeftColor" to "#00FFFF")), "ab" to _uM(".x" to _uM("borderTopColor" to "#FF0000", "borderRightColor" to "#FF0000", "borderBottomColor" to "#FF0000", "borderLeftColor" to "#FF0000", "borderTopWidth" to 5, "borderRightWidth" to 5, "borderBottomWidth" to 5, "borderLeftWidth" to 5, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid"), ".y" to _uM("borderTopColor" to "#008000", "borderRightColor" to "#008000", "borderBottomColor" to "#008000", "borderLeftColor" to "#008000"), ".z" to _uM("borderTopColor" to "#FF0000", "borderRightColor" to "#FF0000", "borderBottomColor" to "#FF0000", "borderLeftColor" to "#FF0000", "borderTopWidth" to 5, "borderRightWidth" to 5, "borderBottomWidth" to 5, "borderLeftWidth" to 5, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid"), ".w" to _uM("borderTopColor" to "#008000", "borderRightColor" to "#008000", "borderBottomColor" to "#008000", "borderLeftColor" to "#008000")), "a" to _uM(".b" to _uM("borderTopColor" to "#FF0000", "borderRightColor" to "#FF0000", "borderBottomColor" to "#FF0000", "borderLeftColor" to "#FF0000", "borderTopWidth" to 5, "borderRightWidth" to 5, "borderBottomWidth" to 5, "borderLeftWidth" to 5, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid"), ".c" to _uM("borderTopColor" to "#008000", "borderRightColor" to "#008000", "borderBottomColor" to "#008000", "borderLeftColor" to "#008000"), ".e" to _uM("borderTopColor" to "#FF0000", "borderRightColor" to "#FF0000", "borderBottomColor" to "#FF0000", "borderLeftColor" to "#FF0000", "borderTopWidth" to 5, "borderRightWidth" to 5, "borderBottomWidth" to 5, "borderLeftWidth" to 5, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid"), ".d" to _uM("borderTopColor" to "#008000", "borderRightColor" to "#008000", "borderBottomColor" to "#008000", "borderLeftColor" to "#008000")), "year-2025" to _uM(".month-12" to _uM("borderTopColor" to "#FF0000", "borderRightColor" to "#FF0000", "borderBottomColor" to "#FF0000", "borderLeftColor" to "#FF0000", "borderTopWidth" to 5, "borderRightWidth" to 5, "borderBottomWidth" to 5, "borderLeftWidth" to 5, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid")), "year-2024" to _uM(".month-01" to _uM("borderTopColor" to "#008000", "borderRightColor" to "#008000", "borderBottomColor" to "#008000", "borderLeftColor" to "#008000")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
