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
open class GenUniModulesIboxsUiComponentsIboxsShare : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_iboxs_icon = resolveComponent("iboxs-icon")
        val _component_iboxs_bottom_popup = resolveComponent("iboxs-bottom-popup")
        return _cV(_component_iboxs_bottom_popup, _uM("class" to "padding-safe-bottom", "visible" to _ctx.show, "maskClosable" to true, "onClose" to _ctx.close), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
            return _uA(
                _cE("view", _uM("class" to "share-window"), _uA(
                    _cE("text", _uM("class" to "title"), "分享"),
                    _cE("view", _uM("class" to "closeicon"), _uA(
                        _cV(_component_iboxs_icon, _uM("name" to "close", "size" to "16", "color" to "#999"))
                    )),
                    _cE("scroll-view", _uM("direction" to "horizontal", "show-scrollbar" to false, "class" to "share-list display-flex"), _uA(
                        _cE(Fragment, null, RenderHelpers.renderList(_ctx.shareList, fun(item, index, __index, _cached): Any {
                            return _cE("view", _uM("class" to "share-item", "key" to index, "onClick" to fun(){
                                _ctx.clickShare(index)
                            }
                            ), _uA(
                                _cE("image", _uM("src" to item.icon, "mode" to "aspectFit", "class" to "icon"), null, 8, _uA(
                                    "src"
                                )),
                                _cE("text", _uM("class" to "name"), _tD(item.name), 1)
                            ), 8, _uA(
                                "onClick"
                            ))
                        }
                        ), 128)
                    )),
                    _cE("view", _uM("class" to "share-actionlist display-flex"), _uA(
                        _cE("view", _uM("class" to "share-item"), _uA(
                            _cE("image", _uM("src" to "https://cdn.itgz8.com/image/icon/kouling.png", "mode" to "aspectFit", "class" to "icon")),
                            _cE("text", _uM("class" to "name"), "复制口令")
                        ))
                    ))
                ))
            )
        }
        ), "_" to 1), 8, _uA(
            "visible",
            "onClose"
        ))
    }
    open var i18n: Tmui4xI18nTml by `$data`
    open var show: Boolean by `$data`
    open var shareList: UTSArray<shareListInfo> by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml, "show" to false, "shareList" to _uA<shareListInfo>(shareListInfo(key = "wechat", name = "微信", icon = "https://cdn.itgz8.com/image/icon/wechat.png"), shareListInfo(key = "qq", name = "QQ", icon = "https://cdn.itgz8.com/image/icon/qq.png"), shareListInfo(key = "sms", name = "短信", icon = "https://cdn.itgz8.com/image/icon/sms.png")))
    }
    open var open = ::gen_open_fn
    open fun gen_open_fn() {
        this.show = true
    }
    open var close = ::gen_close_fn
    open fun gen_close_fn() {
        this.show = false
    }
    open var clickShare = ::gen_clickShare_fn
    open fun gen_clickShare_fn(index: Number) {
        var key = this.shareList[index].key
        this.`$emit`("share", key)
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("color-white" to _pS(_uM("color" to "#FFFFFF")), "list-items" to _pS(_uM("flexWrap" to "wrap", "flexDirection" to "row")), "litem" to _uM(".list-items " to _uM("flexGrow" to 0, "flexShrink" to 0)), "top-status-bar" to _pS(_uM("top" to CSS_VAR_STATUS_BAR_HEIGHT)), "padding-stauts-bar" to _pS(_uM("paddingTop" to CSS_VAR_STATUS_BAR_HEIGHT)), "margin-status-bar" to _pS(_uM("marginTop" to CSS_VAR_STATUS_BAR_HEIGHT)), "height-status-bar" to _pS(_uM("height" to CSS_VAR_STATUS_BAR_HEIGHT)), "safe-bottom" to _pS(_uM("bottom" to "var(--uni-safe-area-inset-bottom)")), "padding-safe-bottom" to _pS(_uM("paddingBottom" to "var(--uni-safe-area-inset-bottom)")), "safe-bottom-view" to _pS(_uM("width" to "750rpx", "left" to 0, "height" to "var(--uni-safe-area-inset-bottom)", "position" to "fixed", "bottom" to 0)), "overline" to _pS(_uM("whiteSpace" to "nowrap", "overflow" to "hidden", "textOverflow" to "ellipsis")), "overline2" to _pS(_uM("textOverflow" to "ellipsis", "lines" to 2)), "display-flex" to _pS(_uM("display" to "flex", "flexDirection" to "row")), "space-between" to _pS(_uM("justifyContent" to "space-between", "display" to "flex", "flexDirection" to "row")), "share-window" to _pS(_uM("width" to "750rpx", "minHeight" to 200, "backgroundImage" to "none", "backgroundColor" to "#FFFFFF", "position" to "relative", "paddingTop" to 10, "paddingBottom" to 20)), "title" to _uM(".share-window " to _uM("textAlign" to "center", "fontSize" to 14, "marginBottom" to 15)), "closeicon" to _uM(".share-window " to _uM("position" to "absolute", "right" to "20rpx", "top" to 10)), "share-list" to _uM(".share-window " to _uM("width" to "750rpx")), "share-item" to _uM(".share-window " to _uM("width" to 70)), "icon" to _uM(".share-window .share-item " to _uM("marginTop" to 0, "marginRight" to "auto", "marginBottom" to 0, "marginLeft" to "auto", "height" to 50, "width" to 50, "borderTopLeftRadius" to 25, "borderTopRightRadius" to 25, "borderBottomRightRadius" to 25, "borderBottomLeftRadius" to 25)), "name" to _uM(".share-window .share-item " to _uM("textAlign" to "center", "fontSize" to 13, "marginTop" to 10, "color" to "#999999")), "share-actionlist" to _uM(".share-window " to _uM("marginTop" to 15)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM("iboxsIcon" to GenUniModulesIboxsUiComponentsIboxsIconClass, "iboxsBottomPopup" to GenUniModulesIboxsUiComponentsIboxsBottomPopupClass)
    }
}
