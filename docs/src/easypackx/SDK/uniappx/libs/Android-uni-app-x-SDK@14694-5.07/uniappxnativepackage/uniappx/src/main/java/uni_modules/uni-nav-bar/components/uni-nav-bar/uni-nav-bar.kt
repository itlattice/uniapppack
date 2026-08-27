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
open class GenUniModulesUniNavBarComponentsUniNavBarUniNavBar : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var hideDefaultBack: Boolean by `$props`
    open var title: String by `$props`
    open var navigationBarTextStyle: String by `$props`
    open var leftClass: Any? by `$props`
    open var midClass: Any? by `$props`
    open var rightClass: Any? by `$props`
    open var isLeft: Boolean by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesUniNavBarComponentsUniNavBarUniNavBar) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesUniNavBarComponentsUniNavBarUniNavBar
            val _cache = __ins.renderCache
            val props = __props
            val slots = useSlots()
            val currentPage = getCurrentInstance()?.proxy?.`$page`
            val foreColor = computed(fun(): String {
                return if ((props.navigationBarTextStyle == "")) {
                    currentPage?.getPageStyle()?.get("navigationBarTextStyle") as String
                } else {
                    props.navigationBarTextStyle
                }
            }
            )
            onMounted(fun(){})
            val back = fun(){
                uni_navigateBack(NavigateBackOptions())
            }
            return fun(): Any? {
                return _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row", "padding-top" to "var(--status-bar-height)", "box-sizing" to "content-box", "align-items" to "center", "position" to "relative"))), _uA(
                    _cE("view", _uM("style" to _nS(_uM("height" to "44px", "align-items" to "center", "justify-content" to "center")), "class" to _nC(_uA(
                        "uni-left-class-buildin",
                        _ctx.leftClass
                    ))), _uA(
                        if (isTrue(!_ctx.hideDefaultBack && unref(slots)["left"] == null)) {
                            _cE("view", _uM("key" to 0, "style" to _nS(_uM("width" to "44px", "height" to "44px", "justify-content" to "center", "align-items" to "center")), "onClick" to back), _uA(
                                _cE("view", _uM("style" to _nS(_uA(
                                    _uM("width" to "12px", "height" to "12px", "transform" to "rotate(45deg)", "border-left" to "2px solid", "border-bottom" to "2px solid"),
                                    _uM("borderLeftColor" to unref(foreColor), "borderBottomColor" to unref(foreColor))
                                ))), null, 4)
                            ), 4)
                        } else {
                            renderSlot(_ctx.`$slots`, "left", _uM("key" to 1))
                        }
                    ), 6),
                    _cE("view", _uM("style" to _nS(_uM("position" to "absolute", "height" to "44px", "flex-direction" to "row", "align-items" to "center", "justify-content" to if (_ctx.isLeft) {
                        "flex-start"
                    } else {
                        "center"
                    }
                    )), "class" to _nC(_uA(
                        "uni-mid-class-buildin",
                        _ctx.midClass
                    )), "flatten" to ""), _uA(
                        if (unref(slots)["mid"] == null) {
                            _cE("text", _uM("key" to 0, "style" to _nS(_uM("color" to unref(foreColor))), "flatten" to ""), _tD(_ctx.title), 5)
                        } else {
                            renderSlot(_ctx.`$slots`, "mid", _uM("key" to 1))
                        }
                    ), 6),
                    _cE("view", _uM("style" to _nS(_uM("position" to "absolute", "height" to "44px", "flex-direction" to "row", "align-items" to "center", "right" to "0")), "class" to _nC(_uA(
                        "uni-right-class-buildin",
                        _ctx.rightClass
                    )), "flatten" to ""), _uA(
                        renderSlot(_ctx.`$slots`, "right")
                    ), 6)
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
                return _uM("uni-left-class-buildin" to _pS(_uM("width" to 44, "marginLeft" to 6)), "uni-mid-class-buildin" to _pS(_uM("justifyContent" to "center", "left" to 52, "right" to 52)), "uni-right-class-buildin" to _pS(_uM("width" to 44, "marginRight" to 6)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("hideDefaultBack" to _uM("type" to "Boolean", "default" to false), "title" to _uM("type" to "String", "default" to ""), "navigationBarTextStyle" to _uM("type" to "String", "default" to ""), "leftClass" to _uM("type" to null, "default" to "", "externalClasses" to true, "skipCheck" to true), "midClass" to _uM("type" to null, "default" to "", "externalClasses" to true, "skipCheck" to true), "rightClass" to _uM("type" to null, "default" to "", "externalClasses" to true, "skipCheck" to true), "isLeft" to _uM("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = _uA(
            "hideDefaultBack",
            "title",
            "navigationBarTextStyle",
            "leftClass",
            "midClass",
            "rightClass",
            "isLeft"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
