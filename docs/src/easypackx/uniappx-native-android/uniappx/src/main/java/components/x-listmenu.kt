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
open class GenComponentsXListmenu : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var list: UTSArray<UTSJSONObject> by `$props`
    open var menus: UTSArray<UTSJSONObject> by `$props`
    open var height: Number by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXListmenu) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXListmenu
            val _cache = __ins.renderCache
            val props = __props
            val showList = ref(_uA<UTSJSONObject>())
            val menuClick = fun(key: String, index: Number){
                console.log("菜单")
            }
            watch(props.list, fun(newVal: UTSArray<UTSJSONObject>){
                var oldlist = newVal.slice(0)
                oldlist = oldlist.map(fun(el: UTSJSONObject, from: Number): UTSJSONObject {
                    if (from != -1) {
                        el.set("opened", false)
                    } else {
                        el.set("opened", true)
                    }
                    return el
                }
                )
                showList.value = oldlist.slice(0)
            }
            )
            val onclose = fun(index: Number){}
            val onopen = fun(index: Number){
                var oldlist = showList.value.slice(0)
                oldlist = oldlist.map(fun(el: UTSJSONObject, from: Number): UTSJSONObject {
                    if (from != index) {
                        el.set("opened", false)
                    } else {
                        el.set("opened", true)
                    }
                    return el
                }
                )
                showList.value = oldlist.slice(0)
            }
            return fun(): Any? {
                val _component_tmx_cell = resolveEasyComponent("tmx-cell", GenUniModulesTmxUiComponentsTmxCellTmxCellClass)
                val _component_tmx_switch_slider = resolveEasyComponent("tmx-switch-slider", GenUniModulesTmxUiComponentsTmxSwitchSliderTmxSwitchSliderClass)
                return _cE(Fragment, null, RenderHelpers.renderList(_ctx.list, fun(item, index, __index, _cached): Any {
                    return _cV(_component_tmx_switch_slider, _uM("status" to item.getBoolean("opened"), "onOpen" to fun(){
                        onopen(index)
                    }
                    , "onClose" to fun(){
                        onclose(index)
                    }
                    , "height" to _ctx.height.toString(10), "key" to index, "eventNone" to false), _uM("menu" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to "display-flex", "style" to _nS(_uA(
                                _uM("height" to "100%"),
                                _uM("width" to ((_ctx.menus.length * 80) + "px"))
                            ))), _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(_ctx.menus, fun(menu, ind, __index, _cached): Any {
                                    return _cE("view", _uM("class" to "menu", "onClick" to fun(){
                                        menuClick(menu["key"] as String, index)
                                    }
                                    , "style" to _nS(_uM("backgroundColor" to menu["background"] as String))), _uA(
                                        _cE("text", _uM("class" to "menuname", "style" to _nS(_uM("color" to (menu["color"] as String), "lineHeight" to (_ctx.height + "px")))), _tD(menu["name"]), 5)
                                    ), 12, _uA(
                                        "onClick"
                                    ))
                                }
                                ), 256)
                            ), 4)
                        )
                    }
                    ), "default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cV(_component_tmx_cell, _uM("leftSize" to "0", "link" to false, "padding" to _uA(
                                "0",
                                "0",
                                "0",
                                "0"
                            ), "margin" to _uA(
                                "0",
                                "0",
                                "0",
                                "0"
                            ), "rightWidth" to "0", "min-height" to _ctx.height.toString(10), "linkColor" to "#fff", "showBottomBorder" to false, "card" to false), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    renderSlot(_ctx.`$slots`, "default", _uM("item" to item))
                                )
                            }
                            ), "_" to 2), 1032, _uA(
                                "min-height"
                            ))
                        )
                    }
                    ), "_" to 2), 1032, _uA(
                        "status",
                        "onOpen",
                        "onClose",
                        "height"
                    ))
                }
                ), 128)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("menu" to _pS(_uM("width" to 80)), "menuname" to _uM(".menu " to _uM("fontSize" to 16, "textAlign" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("list" to _uM("type" to "Object", "default" to fun(): UTSArray<UTSJSONObject> {
            return _uA<UTSJSONObject>()
        }
        ), "menus" to _uM("type" to "Object", "default" to fun(): UTSArray<UTSJSONObject> {
            return _uA<UTSJSONObject>()
        }
        ), "height" to _uM("type" to "Number", "default" to 64)))
        var propsNeedCastKeys = _uA(
            "list",
            "menus",
            "height"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
