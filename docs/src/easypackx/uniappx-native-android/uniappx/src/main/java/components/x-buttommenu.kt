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
open class GenComponentsXButtommenu : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var menu: UTSArray<bottomMenu> by `$props`
    open var visible: Boolean by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXButtommenu) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXButtommenu
            val _cache = __ins.renderCache
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val closePopup = fun(){
                emit("closePopup")
            }
            val clickMenu = fun(key: String){
                emit("menuClick", key)
            }
            return fun(): Any? {
                val _component_fui_bottom_popup = resolveEasyComponent("fui-bottom-popup", GenUniModulesFirstuiUvueComponentsFuiBottomPopupFuiBottomPopupClass)
                return _cV(_component_fui_bottom_popup, _uM("visible" to _ctx.visible, "onClose" to closePopup), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "bottompopup padding-safe-bottom"), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(_ctx.menu, fun(item, index, __index, _cached): Any {
                                return _cE("text", _uM("class" to "buttom align-center", "key" to index, "onClick" to fun(){
                                    clickMenu(item.key)
                                }
                                ), _tD(item.name), 9, _uA(
                                    "onClick"
                                ))
                            }
                            ), 128)
                        ))
                    )
                }
                ), "_" to 1), 8, _uA(
                    "visible"
                ))
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("bottompopup" to _pS(_uM("width" to "100%")), "buttom" to _uM(".bottompopup " to _uM("marginLeft" to "20rpx", "marginRight" to "20rpx", "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#f5f5f5", "height" to 48, "lineHeight" to "47px", "fontSize" to 15, "color" to "#000000")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("closePopup" to null, "menuClick" to null)
        var props = _nP(_uM("menu" to _uM("type" to "Object", "default" to _uA<bottomMenu>()), "visible" to _uM("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = _uA(
            "menu",
            "visible"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
