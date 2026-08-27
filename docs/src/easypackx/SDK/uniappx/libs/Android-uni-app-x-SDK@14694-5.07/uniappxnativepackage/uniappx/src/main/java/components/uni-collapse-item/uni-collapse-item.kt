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
open class GenComponentsUniCollapseItemUniCollapseItem : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var title: String by `$props`
    open var open: Boolean by `$props`
    open var disabled: Boolean by `$props`
    open var is_open: Boolean
        get() {
            return unref(this.`$exposed`["is_open"]) as Boolean
        }
        set(value) {
            setRefValue(this.`$exposed`, "is_open", value)
        }
    open var openOrClose: (open: Boolean) -> Unit
        get() {
            return unref(this.`$exposed`["openOrClose"]) as (open: Boolean) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "openOrClose", value)
        }
    open var openCollapse: (open: Boolean) -> Unit
        get() {
            return unref(this.`$exposed`["openCollapse"]) as (open: Boolean) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "openCollapse", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsUniCollapseItemUniCollapseItem, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsUniCollapseItemUniCollapseItem
            val _cache = __ins.renderCache
            val isDarkMode = computed(fun(): Boolean {
                return state.isDarkMode
            }
            )
            val props = __props
            var is_open = ref<Boolean>(props.open)
            var box_is_open = ref<Boolean>(props.open)
            var boxRef = ref<UniViewElement?>(null)
            var contentRef = ref<UniViewElement?>(null)
            var openType = computed(fun(): Boolean {
                return props.open
            }
            )
            val elId = ref("uni_collapse_item_" + Math.ceil(Math.random() * 10e5).toString(36))
            val registerChild = inject<((child: ItemChildType) -> String)?>("uni-collapse-register-child", null)
            val collapseToggle = inject<((elId: String) -> String)?>("k-collapse-child-toggle", null)
            fun gen_openOrClose_fn(open: Boolean) {
                setTimeout(fun(){
                    box_is_open.value = !box_is_open.value
                }
                , 10)
                val bNode = boxRef.value?.style!!
                val cNode = contentRef.value?.style!!
                var hide = if (open) {
                    "flex"
                } else {
                    "none"
                }
                val opacity = if (open) {
                    "1"
                } else {
                    "0"
                }
                var ani_transform = if (open) {
                    "translateY(0)"
                } else {
                    "translateY(-100%)"
                }
                bNode.setProperty("display", hide)
                nextTick(fun(){
                    setTimeout(fun(){
                        cNode.setProperty("transform", ani_transform)
                        cNode.setProperty("opacity", opacity)
                    }
                    , 10)
                }
                )
            }
            val openOrClose = ::gen_openOrClose_fn
            fun gen_openCollapse_fn(open: Boolean) {
                if (props.disabled) {
                    return
                }
                if (collapseToggle != null) {
                    collapseToggle(elId.value)
                }
                is_open.value = open
                openOrClose(open)
            }
            val openCollapse = ::gen_openCollapse_fn
            onMounted(fun(){
                if (registerChild != null) {
                    val child = ItemChildType(is_open = is_open, elId = elId.value, openOrClose = openOrClose)
                    registerChild(child)
                }
            }
            )
            watch(openType, fun(value: Boolean){
                if (boxRef.value != null) {
                    openCollapse(value)
                }
            }
            )
            __expose(_uM("is_open" to is_open, "openOrClose" to openOrClose, "openCollapse" to openCollapse))
            return fun(): Any? {
                return _cE("view", _uM("class" to _nC(_uA(
                    "uni-collapse-item",
                    if (unref(isDarkMode)) {
                        "theme-dark"
                    } else {
                        "theme-light"
                    }
                ))), _uA(
                    _cE("view", _uM("class" to "uni-collapse-item__title", "onClick" to fun(){
                        openCollapse(!unref(is_open))
                    }
                    ), _uA(
                        _cE("text", _uM("class" to _nC(_uA(
                            "uni-collapse-item__title-text",
                            _uM("is-disabled" to _ctx.disabled, "open--active" to unref(is_open))
                        ))), _tD(_ctx.title), 3),
                        _cE("view", _uM("class" to _nC(_uA(
                            "down_arrow",
                            _uM("down_arrow--active" to unref(is_open))
                        ))), null, 2)
                    ), 8, _uA(
                        "onClick"
                    )),
                    _cE("view", _uM("ref_key" to "boxRef", "ref" to boxRef, "class" to _nC(_uA(
                        "uni-collapse-item__content",
                        _uM("box-open--active" to unref(is_open))
                    ))), _uA(
                        _cE("view", _uM("ref_key" to "contentRef", "ref" to contentRef, "class" to _nC(_uA(
                            "uni-collapse-item__content-box",
                            _uM("content-open--active" to unref(box_is_open))
                        ))), _uA(
                            renderSlot(_ctx.`$slots`, "default")
                        ), 2)
                    ), 2)
                ), 2)
            }
        }
        var name = "UniCollapseItem"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("uni-collapse-item__title" to _pS(_uM("flexDirection" to "row", "alignItems" to "center", "paddingTop" to 12, "paddingRight" to 18, "paddingBottom" to 12, "paddingLeft" to 18, "backgroundColor" to "var(--list-background-color,#ffffff)")), "down_arrow" to _pS(_uM("width" to 8, "height" to 8, "transform" to "rotate(45deg)", "borderRightWidth" to 1, "borderRightStyle" to "solid", "borderRightColor" to "#999999", "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#999999", "marginTop" to -3, "transitionProperty" to "transform", "transitionDuration" to "150ms")), "down_arrow--active" to _pS(_uM("transform" to "rotate(-135deg)", "marginTop" to 0)), "uni-collapse-item__title-text" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "fontSize" to 14, "fontWeight" to "400", "color" to "var(--text-color, #333333)")), "open--active" to _pS(_uM("color" to "var(--active-color, #bbb)")), "is-disabled" to _pS(_uM("color" to "#999999")), "uni-collapse-item__content" to _pS(_uM("display" to "none", "position" to "relative", "overflow" to "hidden")), "box-open--active" to _pS(_uM("display" to "flex")), "uni-collapse-item__content-box" to _pS(_uM("width" to "100%", "transitionProperty" to "transform,opacity", "transitionDuration" to "150ms", "transform" to "translateY(-100%)", "opacity" to 0)), "content-open--active" to _pS(_uM("transform" to "translateY(0%)", "opacity" to 1)), "@TRANSITION" to _uM("down_arrow" to _uM("property" to "transform", "duration" to "150ms"), "uni-collapse-item__content-box" to _uM("property" to "transform,opacity", "duration" to "150ms")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("title" to _uM("type" to "String", "default" to ""), "open" to _uM("type" to "Boolean", "default" to false), "disabled" to _uM("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = _uA(
            "title",
            "open",
            "disabled"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
