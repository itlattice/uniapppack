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
open class GenPagesCSSTextFontFamilyIcon : BasePage {
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
    open var changeStyle: () -> Unit
        get() {
            return unref(this.`$exposed`["changeStyle"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "changeStyle", value)
        }
    open var data: UTSJSONObject
        get() {
            return unref(this.`$exposed`["data"]) as UTSJSONObject
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesCSSTextFontFamilyIcon, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSTextFontFamilyIcon
            val _cache = __ins.renderCache
            val uniIcons = ref(_uA<Icon>(Icon(name = "back", code = "E601"), Icon(name = "forward", code = "E600"), Icon(name = "share", code = "E602"), Icon(name = "favorites", code = "E604"), Icon(name = "home", code = "E605"), Icon(name = "more", code = "E606"), Icon(name = "close", code = "E650"), Icon(name = "down", code = "E661"), Icon(name = "circle", code = "EA01"), Icon(name = "warn", code = "EA0F"), Icon(name = "info", code = "EA03"), Icon(name = "info circle", code = "EA04"), Icon(name = "success", code = "EA06"), Icon(name = "success circle", code = "EA07"), Icon(name = "success no circle", code = "EA08"), Icon(name = "cancel circle", code = "EA0B"), Icon(name = "clear", code = "EA14"), Icon(name = "download", code = "EA19"), Icon(name = "waitnig", code = "EA1E"), Icon(name = "search", code = "EA23")))
            val data = reactive(_uO("fontWeight" to "normal", "fontStyle" to "normal"))
            val changeStyle = fun(){
                data["fontWeight"] = "bold"
                data["fontStyle"] = "italic"
            }
            __expose(_uM("changeStyle" to changeStyle, "data" to data))
            return fun(): Any? {
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("style" to _nS(_uM("align-items" to "center", "align-self" to "center"))), _uA(
                        _cE("view", _uM("class" to "iconContainer"), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(unref(uniIcons), fun(item, __key, __index, _cached): Any {
                                return _cE("view", _uM("class" to "iconItem"), _uA(
                                    _cE("text", _uM("class" to "icon", "style" to _nS(_uM("font-weight" to unref(data)["fontWeight"], "font-style" to unref(data)["fontStyle"]))), _tD(String.fromCharCode(parseInt(item.code, 16))), 5),
                                    _cE("text", _uM("class" to "code"), "\\u" + _tD(item.code), 1),
                                    _cE("text", _uM("class" to "name"), _tD(item.name), 1)
                                ))
                            }
                            ), 256)
                        ))
                    ), 4)
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
                return _uM("iconContainer" to _pS(_uM("flexDirection" to "row", "flexWrap" to "wrap", "justifyContent" to "center")), "iconItem" to _pS(_uM("width" to 100, "height" to 150, "justifyContent" to "center", "alignItems" to "center")), "icon" to _pS(_uM("width" to 48, "height" to 48, "fontFamily" to "uni-icon", "fontSize" to 42, "lineHeight" to "48px", "color" to "#333333", "marginBottom" to 8)), "code" to _pS(_uM("fontSize" to 14, "color" to "#ff0000")), "name" to _pS(_uM("fontSize" to 12, "color" to "#000000")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
