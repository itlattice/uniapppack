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
open class GenComponentsXRemarkwindow : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var remark: Any? by `$props`
    open var title: String by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    open var open: () -> Unit
        get() {
            return unref(this.`$exposed`["open"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "open", value)
        }
    open var close: () -> Unit
        get() {
            return unref(this.`$exposed`["close"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "close", value)
        }
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXRemarkwindow, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXRemarkwindow
            val _cache = __ins.renderCache
            val props = __props
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val title = computed(fun(): Any {
                return props.title
            }
            )
            val remarkWindow = ref<UniElement?>(null)
            val remarkContent = ref("")
            watch(fun(): String {
                return (props.remark as String)
            }
            , fun(newVal: String?): Unit {
                if (newVal == null) {
                    remarkContent.value = ""
                    return
                }
                remarkContent.value = newVal as String
            }
            )
            val open = fun(){
                if (props.remark == null) {
                    remarkContent.value = ""
                    common.callMethod(remarkWindow.value as Any, "open")
                    return
                }
                remarkContent.value = props.remark as String
                common.callMethod(remarkWindow.value as Any, "open")
            }
            val closeWindow = fun(){
                emit("closeWindow")
            }
            val close = fun(){
                common.callMethod(remarkWindow.value as Any, "close")
            }
            val addRemark = fun(){
                emit("addRemark", remarkContent.value)
                closeWindow()
            }
            __expose(_uM("open" to open, "close" to close))
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_wx_popup = resolveEasyComponent("wx-popup", GenUniModulesWxUiComponentsWxPopupWxPopupClass)
                return _cV(_component_wx_popup, _uM("ref_key" to "remarkWindow", "ref" to remarkWindow, "mode" to "center", "round" to 12), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("style" to _nS(_uM("width" to "300px", "height" to "230px")), "class" to "position-relative background-white addremarkwindow"), _uA(
                            _cE("view", _uM("class" to "titlebox"), _uA(
                                _cE("text", _uM("class" to "title align-center"), _tD(unref(title)), 1),
                                _cV(_component_x_iconfont, _uM("onClick" to closeWindow, "class" to "guanbi", "name" to "guanbi", "color" to "#A1A1A1", "size" to "20"))
                            )),
                            _cE("view", _uM("class" to "input"), _uA(
                                _cE("textarea", _uM("class" to "textarea", "modelValue" to unref(remarkContent), "onInput" to fun(`$event`: UniInputEvent){
                                    trySetRefValue(remarkContent, `$event`.detail.value)
                                }
                                ), null, 40, _uA(
                                    "modelValue"
                                ))
                            )),
                            _cE("view", _uM("class" to "action position-absolute background-main", "onClick" to addRemark), _uA(
                                _cE("text", _uM("class" to "align-center color-white content"), "保存备注")
                            ))
                        ), 4)
                    )
                }
                ), "_" to 1), 512)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("addremarkwindow" to _pS(_uM("paddingTop" to 5, "paddingLeft" to 8, "paddingRight" to 8)), "titlebox" to _uM(".addremarkwindow " to _uM("height" to 31, "paddingBottom" to 2)), "title" to _uM(".addremarkwindow .titlebox " to _uM("fontSize" to 15, "color" to "#303030", "lineHeight" to "31px")), "guanbi" to _uM(".addremarkwindow .titlebox " to _uM("position" to "absolute", "top" to 8, "right" to 13)), "input" to _uM(".addremarkwindow " to _uM("marginLeft" to 6, "marginRight" to 6, "height" to 130, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#EDEDED", "borderRightColor" to "#EDEDED", "borderBottomColor" to "#EDEDED", "borderLeftColor" to "#EDEDED")), "action" to _uM(".addremarkwindow " to _uM("bottom" to 0, "width" to 300, "overflow" to "hidden", "left" to 0, "height" to 40)), "content" to _uM(".addremarkwindow .action " to _uM("lineHeight" to "40px")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("closeWindow" to null, "addRemark" to null)
        var props = _nP(_uM("remark" to _uM("default" to ""), "title" to _uM("type" to "String", "default" to "商品备注")))
        var propsNeedCastKeys = _uA(
            "remark",
            "title"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
