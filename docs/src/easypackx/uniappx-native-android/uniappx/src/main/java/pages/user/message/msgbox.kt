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
import io.dcloud.uniapp.extapi.`$emit` as uni__emit
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
open class GenPagesUserMessageMsgbox : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            xProvitae.scrollTop = e.scrollTop
            val pages = getCurrentPages()
            if (pages.length == 0) {
                return
            }
            val page = pages[pages.length - 1].route
            uni__emit("onPageScroll", _uO("top" to e.scrollTop, "page" to page))
        }
        , __ins)
        onResize(fun(_: OnResizeOptions) {
            uni__emit("onResize", fun() {})
        }
        , __ins)
        onLoad(fun(query: OnLoadOptions) {
            xProvitae.onLoadOpts = JSON.parseObject(JSON.stringify(query)!!) ?: _uO()
            uni__emit("onLoad", fun() {})
        }
        , __ins)
        onPageHide(fun() {
            uni__emit("onHide", fun() {})
        }
        , __ins)
        onReady(fun() {
            uni__emit("onReady", fun() {})
            xProvitae.pageReady = true
        }
        , __ins)
        onPageShow(fun() {
            uni__emit("onShow", fun() {})
        }
        , __ins)
    }
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesUserMessageMsgbox) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesUserMessageMsgbox
            val _cache = __ins.renderCache
            val keywords = ref("")
            val pageHeight = ref(0)
            val clearKeywords = fun(){
                keywords.value = ""
            }
            val systemMsg = fun(pageTitle: String, pageKey: String){
                common.goto("/pages/user/message/systemmsg?key=" + pageKey + "&title=" + pageTitle)
            }
            val back = fun(){
                common.back()
            }
            val toChatLog = fun(ind: Number){
                common.goto("/pages/user/message/chatmsg?id=ind")
            }
            onReady(fun(){
                pageHeight.value = uni_getWindowInfo().safeArea.height - 70
            }
            )
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_x_page_title = resolveEasyComponent("x-page-title", GenComponentsXPageTitleClass)
                return _cE("view", null, _uA(
                    _cV(_component_x_page_title, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to "pagetitle space-between"), _uA(
                                _cE("view", _uM("class" to "lefttitle display-flex"), _uA(
                                    _cE("view", _uM("class" to "backbtn display-flex", "onClick" to back), _uA(
                                        _cV(_component_x_iconfont, _uM("name" to "fanhui", "color" to "white", "height" to 40, "size" to "18")),
                                        _cE("text", _uM("class" to "msgbox color-white"), "消息盒子")
                                    )),
                                    _cV(_component_x_iconfont, _uM("class" to "ico", "name" to "yidu", "color" to "white", "size" to "20", "height" to 40))
                                )),
                                _cE("view", _uM("class" to "righttitle"), _uA(
                                    _cV(_component_x_iconfont, _uM("name" to "tongxunlu", "color" to "white", "size" to "22", "height" to 40))
                                ))
                            )),
                            _cE("view", _uM("class" to "seachinputbox background-white display-flex"), _uA(
                                _cV(_component_x_iconfont, _uM("class" to "sousuoicon", "size" to "14", "name" to "sousuo")),
                                _cE("view", _uM("class" to "searchinput"), _uA(
                                    _cE("input", _uM("type" to "text", "modelValue" to unref(keywords), "onInput" to fun(`$event`: UniInputEvent){
                                        trySetRefValue(keywords, `$event`.detail.value)
                                    }
                                    , "placeholder" to "检索消息列表", "class" to "inp"), null, 40, _uA(
                                        "modelValue"
                                    ))
                                )),
                                _cE("view", _uM("class" to "chachaicon", "onClick" to clearKeywords), _uA(
                                    if (unref(keywords).length > 0) {
                                        _cV(_component_x_iconfont, _uM("key" to 0, "name" to "chacha", "class" to "chacha", "color" to "#C4C4C4", "size" to "16"))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                )),
                                _cE("text", _uM("class" to "label left-border color-main text align-center font"), "搜索")
                            )),
                            _cE("view", _uM("style" to _nS(_uM("height" to "10px"))), null, 4)
                        )
                    }
                    ), "_" to 1)),
                    _cE("scroll-view", _uM("style" to _nS(_uM("height" to (unref(pageHeight) + "px"))), "direction" to "vertical"), _uA(
                        _cE("view", _uM("class" to "msgboxlist"), _uA(
                            _cE("view", _uM("class" to "msgitem background-white display-flex", "onClick" to fun(){
                                systemMsg("订单提醒", "ordermsg")
                            }
                            ), _uA(
                                _cE("view", _uM("class" to "avar"), _uA(
                                    _cV(_component_x_iconfont, _uM("class" to "align-center icon", "name" to "icon156", "height" to 43, "size" to "24", "color" to "#FFA13D"))
                                )),
                                _cE("view", _uM("class" to "userinfo"), _uA(
                                    _cE("view", _uM("class" to "space-between"), _uA(
                                        _cE("text", _uM("class" to "username"), "订单提醒"),
                                        _cE("text", _uM("class" to "time"), "2025-08-17 18:59")
                                    )),
                                    _cE("text", _uM("class" to "msgremark overline"), "新品[诶是是是是是]")
                                )),
                                _cE("text", _uM("class" to "msgnumber"), "99+")
                            ), 8, _uA(
                                "onClick"
                            )),
                            _cE("view", _uM("class" to "msgitem background-white display-flex", "onClick" to fun(){
                                systemMsg("待审核通知", "exammsg")
                            }
                            ), _uA(
                                _cE("view", _uM("class" to "avar", "style" to _nS(_uM("background" to "#FFD4D4"))), _uA(
                                    _cV(_component_x_iconfont, _uM("class" to "align-center icon", "name" to "daishenhe", "height" to 43, "size" to "24", "color" to "#FF3D3D"))
                                ), 4),
                                _cE("view", _uM("class" to "userinfo"), _uA(
                                    _cE("view", _uM("class" to "space-between"), _uA(
                                        _cE("text", _uM("class" to "username"), "待审核通知"),
                                        _cE("text", _uM("class" to "time"), "2025-08-17 18:59")
                                    )),
                                    _cE("text", _uM("class" to "msgremark overline"), "新品[诶是是是是是]")
                                )),
                                _cE("text", _uM("class" to "msgnumber"), "99+")
                            ), 8, _uA(
                                "onClick"
                            )),
                            _cE("view", _uM("class" to "msgitem background-white display-flex", "onClick" to fun(){
                                systemMsg("工单提醒", "workorder")
                            }
                            ), _uA(
                                _cE("view", _uM("class" to "avar", "style" to _nS(_uM("background" to "#D4FFFA"))), _uA(
                                    _cV(_component_x_iconfont, _uM("class" to "align-center icon", "name" to "gongdanguanli", "height" to 43, "size" to "24", "color" to "#3DF2FF"))
                                ), 4),
                                _cE("view", _uM("class" to "userinfo"), _uA(
                                    _cE("view", _uM("class" to "space-between"), _uA(
                                        _cE("text", _uM("class" to "username"), "工单提醒"),
                                        _cE("text", _uM("class" to "time"), "2025-08-17 18:59")
                                    )),
                                    _cE("text", _uM("class" to "msgremark overline"), "新品[诶是是是是是]")
                                )),
                                _cE("text", _uM("class" to "msgnumber"), "99+")
                            ), 8, _uA(
                                "onClick"
                            )),
                            _cE("view", _uM("class" to "msgitem background-white display-flex", "onClick" to fun(){
                                systemMsg("客服消息", "customer")
                            }
                            ), _uA(
                                _cE("view", _uM("class" to "avar", "style" to _nS(_uM("background" to "#D4E2FF"))), _uA(
                                    _cV(_component_x_iconfont, _uM("class" to "align-center icon", "name" to "kefu", "height" to 43, "size" to "24", "color" to "#3D6AFF"))
                                ), 4),
                                _cE("view", _uM("class" to "userinfo"), _uA(
                                    _cE("view", _uM("class" to "space-between"), _uA(
                                        _cE("text", _uM("class" to "username"), "客服消息"),
                                        _cE("text", _uM("class" to "time"), "2025-08-17 18:59")
                                    )),
                                    _cE("text", _uM("class" to "msgremark overline"), "新品[诶是是是是是]")
                                )),
                                _cE("text", _uM("class" to "msgnumber"), "99+")
                            ), 8, _uA(
                                "onClick"
                            ))
                        )),
                        _cE("text", _uM("class" to "fenge"), "聊天消息"),
                        _cE("view", _uM("class" to "chatlist"), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(10, fun(item, index, __index, _cached): Any {
                                return _cE("view", _uM("class" to "msgitem background-white display-flex", "key" to index, "onClick" to fun(){
                                    toChatLog(index)
                                }
                                ), _uA(
                                    _cE("view", _uM("class" to "avar"), _uA(
                                        _cE("image", _uM("mode" to "aspectFill", "class" to "img", "src" to "https://img.js.design/assets/smartFill/img318164da746310.jpg"))
                                    )),
                                    _cE("view", _uM("class" to "userinfo"), _uA(
                                        _cE("view", _uM("class" to "space-between"), _uA(
                                            _cE("text", _uM("class" to "username"), "张三"),
                                            _cE("text", _uM("class" to "time"), "2025-08-17 18:59")
                                        )),
                                        _cE("text", _uM("class" to "msgremark overline"), "adsnaodnoan0xsan0saxna0nxmso0aadsnaodnoan0xsan0saxna0nxmso0aadsnaodnoan0xsan0saxna0nxmso0aadsnaodnoan0xsan0saxna0nxmso0aadsnaodnoan0xsan0saxna0nxmso0a")
                                    )),
                                    _cE("text", _uM("class" to "msgnumber"), "99+")
                                ), 8, _uA(
                                    "onClick"
                                ))
                            }
                            ), 64)
                        )),
                        _cE("view", _uM("class" to "height-safe-bottom")),
                        _cE("view", _uM("style" to _nS(_uM("height" to "50px"))), null, 4)
                    ), 4)
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
                return _uM("fenge" to _pS(_uM("height" to 26, "color" to "#999999", "paddingLeft" to 6, "fontSize" to 12, "lineHeight" to "26px")), "msgitem" to _pS(_uM("height" to 66, "paddingLeft" to "34rpx", "paddingRight" to "30rpx", "paddingTop" to 12, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#EDEDED", "position" to "relative")), "msgnumber" to _uM(".msgitem " to _uM("position" to "absolute", "width" to 15, "height" to 15, "borderTopLeftRadius" to 7.5, "borderTopRightRadius" to 7.5, "borderBottomRightRadius" to 7.5, "borderBottomLeftRadius" to 7.5, "backgroundColor" to "#FF0000", "color" to "#FFFFFF", "lineHeight" to "15px", "textAlign" to "center", "right" to "20rpx", "bottom" to 15, "fontSize" to 10)), "avar" to _uM(".msgitem " to _uM("width" to 43, "height" to 43, "borderTopLeftRadius" to 21.5, "borderTopRightRadius" to 21.5, "borderBottomRightRadius" to 21.5, "borderBottomLeftRadius" to 21.5, "backgroundImage" to "none", "backgroundColor" to "#FFEBD4")), "img" to _uM(".msgitem .avar " to _uM("width" to 43, "height" to 43, "borderTopLeftRadius" to 21.5, "borderTopRightRadius" to 21.5, "borderBottomRightRadius" to 21.5, "borderBottomLeftRadius" to 21.5)), "userinfo" to _uM(".msgitem " to _uM("marginLeft" to 10)), "username" to _uM(".msgitem .userinfo " to _uM("paddingTop" to 1, "fontSize" to 14, "color" to "#000000", "lineHeight" to "24px")), "time" to _uM(".msgitem .userinfo " to _uM("fontSize" to 12, "color" to "#999999", "lineHeight" to "26px")), "msgremark" to _uM(".msgitem .userinfo " to _uM("width" to "580rpx", "fontSize" to 12, "color" to "#969696")), "pagetitle" to _pS(_uM("height" to 40, "paddingLeft" to "20rpx", "paddingRight" to "20rpx", "paddingBottom" to 10)), "lefttitle" to _uM(".pagetitle " to _uM("height" to 40)), "msgbox" to _uM(".pagetitle .lefttitle " to _uM("paddingLeft" to 4, "lineHeight" to "40px", "fontSize" to 15)), "ico" to _uM(".pagetitle .lefttitle " to _uM("marginLeft" to "25rpx")), "seachinputbox" to _pS(_uM("marginLeft" to "25rpx", "height" to 30, "width" to "700rpx", "borderTopLeftRadius" to 15, "borderTopRightRadius" to 15, "borderBottomRightRadius" to 15, "borderBottomLeftRadius" to 15)), "sousuoicon" to _uM(".seachinputbox " to _uM("paddingLeft" to "15rpx", "paddingTop" to 8)), "searchinput" to _uM(".seachinputbox " to _uM("height" to 30, "paddingLeft" to "10rpx", "width" to "500rpx", "paddingTop" to 7)), "inp" to _uM(".seachinputbox .searchinput " to _uM("fontSize" to 14)), "label" to _uM(".seachinputbox " to _uM("height" to 18, "marginLeft" to "7rpx", "width" to "90rpx", "borderLeftWidth" to 1, "borderLeftStyle" to "solid", "borderLeftColor" to "#1678fd", "marginTop" to 7, "fontSize" to 14, "textAlign" to "center")), "chacha" to _uM(".seachinputbox " to _uM("marginTop" to 5, "marginRight" to "10rpx")), "chachaicon" to _uM(".seachinputbox " to _uM("width" to "45rpx", "height" to 55)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
