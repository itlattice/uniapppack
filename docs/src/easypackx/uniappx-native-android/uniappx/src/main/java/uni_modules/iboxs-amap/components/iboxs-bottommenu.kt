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
open class GenUniModulesIboxsAmapComponentsIboxsBottommenu : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_x_bottom_popup = resolveEasyComponent("x-bottom-popup", GenComponentsXBottomPopupClass)
        return _cV(_component_x_bottom_popup, _uM("visible" to _ctx.visible, "onClose" to _ctx.closePopup), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
            return _uA(
                _cE("view", _uM("class" to "bottompopup padding-safe-bottom"), _uA(
                    _cE(Fragment, null, RenderHelpers.renderList(_ctx.menu, fun(item, index, __index, _cached): Any {
                        return _cE("text", _uM("class" to "buttom align-center", "key" to index, "onClick" to fun(){
                            _ctx.clickMenu(item.key)
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
            "visible",
            "onClose"
        ))
    }
    open var menu: UTSArray<bottomMenu__2> by `$props`
    open var visible: Boolean by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    open var closePopup = ::gen_closePopup_fn
    open fun gen_closePopup_fn() {
        this.`$emit`("closePopup")
    }
    open var clickMenu = ::gen_clickMenu_fn
    open fun gen_clickMenu_fn(key: String) {
        this.`$emit`("menuClick", key)
    }
    companion object {
        var name = "xu-buttommenu"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("color-white" to _pS(_uM("color" to "#FFFFFF")), "list-items" to _pS(_uM("flexWrap" to "wrap", "flexDirection" to "row")), "litem" to _uM(".list-items " to _uM("flexGrow" to 0, "flexShrink" to 0)), "top-status-bar" to _pS(_uM("top" to CSS_VAR_STATUS_BAR_HEIGHT)), "padding-stauts-bar" to _pS(_uM("paddingTop" to CSS_VAR_STATUS_BAR_HEIGHT)), "margin-status-bar" to _pS(_uM("marginTop" to CSS_VAR_STATUS_BAR_HEIGHT)), "height-status-bar" to _pS(_uM("height" to CSS_VAR_STATUS_BAR_HEIGHT)), "safe-bottom" to _pS(_uM("bottom" to "var(--uni-safe-area-inset-bottom)")), "padding-safe-bottom" to _pS(_uM("paddingBottom" to "var(--uni-safe-area-inset-bottom)")), "safe-bottom-view" to _pS(_uM("width" to "750rpx", "left" to 0, "height" to "var(--uni-safe-area-inset-bottom)", "position" to "fixed", "bottom" to 0)), "overline" to _pS(_uM("whiteSpace" to "nowrap", "overflow" to "hidden", "textOverflow" to "ellipsis")), "overline2" to _pS(_uM("textOverflow" to "ellipsis", "lines" to 2)), "display-flex" to _pS(_uM("display" to "flex", "flexDirection" to "row")), "space-between" to _pS(_uM("justifyContent" to "space-between", "display" to "flex", "flexDirection" to "row")), "bottompopup" to _pS(_uM("width" to "100%")), "buttom" to _uM(".bottompopup " to _uM("marginLeft" to "20rpx", "marginRight" to "20rpx", "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#f5f5f5", "height" to 60, "lineHeight" to "59px", "fontSize" to 16, "color" to "#000000")), "align-center" to _pS(_uM("textAlign" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("closePopup" to null, "menuClick" to null)
        var props = _nP(_uM("menu" to _uM("type" to "Object", "default" to _uA<bottomMenu__2>()), "visible" to _uM("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = _uA(
            "menu",
            "visible"
        )
        var components: Map<String, CreateVueComponent> = _uM("xBottomPopup" to GenUniModulesIboxsAmapComponentsIboxsBottomPopupClass)
    }
}
