@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNI2971F61
import android.content.Context
import io.dcloud.uniapp.*
import io.dcloud.uniapp.extapi.*
import io.dcloud.uniapp.framework.*
import io.dcloud.uniapp.runtime.*
import io.dcloud.uniapp.vue.*
import io.dcloud.uniapp.vue.shared.*
import io.dcloud.uts.*
import io.dcloud.uts.Map
import io.dcloud.uts.Set
import io.dcloud.uts.UTSAndroid
import kotlin.properties.Delegates
import uts.sdk.modules.iboxsChooseMedia.MediaScanner
open class GenUniModulesTmxUiComponentsTmxDropdownItemTmxDropdownItem : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var title: String by `$props`
    open var keyName: String by `$props`
    open var icon: String by `$props`
    open var activeIcon: String by `$props`
    open var fontColor: String by `$props`
    open var darkFontColor: String by `$props`
    open var fontSize: String by `$props`
    open var activeFontColor: String by `$props`
    open var isBtn: Boolean by `$props`
    open var color: String by `$props`
    open var darkColor: String by `$props`
    open var render: Boolean by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesTmxUiComponentsTmxDropdownItemTmxDropdownItem) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesTmxUiComponentsTmxDropdownItemTmxDropdownItem
            val _cache = __ins.renderCache
            val props = __props
            var tid: Number = 56
            var id = ("xDropMenuItem" + getUid()) as String
            val _keyName = computed(fun(): String {
                return if (props.keyName == "") {
                    id
                } else {
                    props.keyName
                }
            }
            )
            val show = inject<ComputedRef<String>>("xDropdownMenuNowKeyName", computed(fun(): String {
                return ""
            }
            ))
            val proxy = getCurrentInstance()?.proxy
            val _color = computed(fun(): String {
                if (xConfig.dark == "dark") {
                    if (props.darkColor != "") {
                        return getDefaultColor(props.darkColor)
                    }
                    return getDefaultColor(xConfig.sheetDarkColor)
                }
                return getDefaultColor(props.color)
            }
            )
            val _activeFontColor = computed(fun(): String {
                if (props.activeFontColor == "") {
                    return getDefaultColor(xConfig.color)
                }
                return getDefaultColor(props.activeFontColor)
            }
            )
            val _fontColor = computed(fun(): String {
                if (xConfig.dark == "dark") {
                    if (props.darkFontColor != "") {
                        return getDefaultColor(props.darkFontColor)
                    }
                    return "#ffffff"
                }
                return getDefaultColor(props.fontColor)
            }
            )
            val _fontSize = computed(fun(): String {
                return checkIsCssUnit(props.fontSize, xConfig.unit)
            }
            )
            val _showrender = computed(fun(): Boolean {
                if (props.render) {
                    return show.value != ""
                }
                return true
            }
            )
            val pushDataToParent = fun(){
                var parent = useTool.findParentVueComponent(proxy, "xDropdownMenu") as TmxDropdownMenuComponentPublicInstance?
                if (parent == null) {
                    return
                }
                clearTimeout(tid)
                tid = setTimeout(fun() {
                    parent!!.addMenu(XDROPDOWN_LISTITEM_INFO_TYPE(id = id as String, title = props.title as String, keyName = _keyName.value, icon = props.icon as String, activeIcon = props.activeIcon as String, fontColor = _fontColor.value, activeFontColor = _activeFontColor.value as String, fontSize = _fontSize.value as String, isBtn = props.isBtn as Boolean))
                }
                , 5)
            }
            val removeSelf = fun(){
                var parent = useTool.findParentVueComponent(proxy, "xDropdownMenu") as TmxDropdownMenuComponentPublicInstance?
                if (parent == null) {
                    return
                }
                if (parent != null) {
                    parent!!.delMenu(id as String)
                }
            }
            onBeforeMount(fun(){
                pushDataToParent()
            }
            )
            onBeforeUnmount(fun(){
                removeSelf()
                clearTimeout(tid)
            }
            )
            watch(fun(): Any {
                return props
            }
            , fun(){
                pushDataToParent()
            }
            )
            return fun(): Any? {
                return if (isTrue(unref(_showrender))) {
                    _cE("view", _uM("key" to 0, "onClick" to withModifiers(fun(){}, _uA(
                        "stop"
                    )), "id" to unref(id), "class" to _nC(_uA(
                        "x-dropdown-item",
                        if (unref(show) == unref(_keyName)) {
                            "x-dropdown-itemOn"
                        } else {
                            "x-dropdown-itemOff"
                        }
                    ))), _uA(
                        _cE("view", _uM("class" to "x-dropdown-itemWrap", "style" to _nS(_uM("backgroundColor" to unref(_color)))), _uA(
                            renderSlot(_ctx.`$slots`, "default")
                        ), 4)
                    ), 10, _uA(
                        "onClick",
                        "id"
                    ))
                } else {
                    _cC("v-if", true)
                }
            }
        }
        var name = "xDropdownItem"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("x-dropdown-item" to _pS(_uM("transitionDuration" to "250ms", "transitionProperty" to "transform,opacity", "transitionTimingFunction" to "cubic-bezier(0.18,0.89,0.32,1)", "transform" to "translateY(-100%)", "position" to "absolute", "top" to 0, "left" to 0, "width" to "100%")), "x-dropdown-itemOn" to _pS(_uM("transform" to "translateY(0%)")), "x-dropdown-itemOff" to _pS(_uM("transitionDuration" to "50ms", "transform" to "translateY(-100%)")), "x-dropdown-itemWrap" to _pS(_uM("transitionDuration" to "250ms", "transitionProperty" to "height", "transitionTimingFunction" to "cubic-bezier(0.18,0.89,0.32,1)", "pointerEvents" to "auto", "paddingLeft" to 12, "paddingRight" to 12, "borderTopLeftRadius" to 0, "borderTopRightRadius" to 0, "borderBottomRightRadius" to 12, "borderBottomLeftRadius" to 12)), "xDrodownItemOn" to _pS(_uM("display" to "flex")), "xDrodownItemOff" to _pS(_uM("display" to "none")), "@TRANSITION" to _uM("x-dropdown-item" to _uM("duration" to "250ms", "property" to "transform,opacity", "timingFunction" to "cubic-bezier(0.18,0.89,0.32,1)"), "x-dropdown-itemOff" to _uM("duration" to "50ms"), "x-dropdown-itemWrap" to _uM("duration" to "250ms", "property" to "height", "timingFunction" to "cubic-bezier(0.18,0.89,0.32,1)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("title" to _uM("type" to "String", "default" to "标题"), "keyName" to _uM("type" to "String", "default" to ""), "icon" to _uM("type" to "String", "default" to "arrow-down-s-fill"), "activeIcon" to _uM("type" to "String", "default" to "arrow-up-s-fill"), "fontColor" to _uM("type" to "String", "default" to "#333333"), "darkFontColor" to _uM("type" to "String", "default" to ""), "fontSize" to _uM("type" to "String", "default" to "16"), "activeFontColor" to _uM("type" to "String", "default" to ""), "isBtn" to _uM("type" to "Boolean", "default" to false), "color" to _uM("type" to "String", "default" to "white"), "darkColor" to _uM("type" to "String", "default" to ""), "render" to _uM("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = _uA(
            "title",
            "keyName",
            "icon",
            "activeIcon",
            "fontColor",
            "darkFontColor",
            "fontSize",
            "activeFontColor",
            "isBtn",
            "color",
            "darkColor",
            "render"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
