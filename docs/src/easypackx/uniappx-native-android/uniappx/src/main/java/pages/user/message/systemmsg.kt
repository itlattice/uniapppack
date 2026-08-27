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
import io.dcloud.uniapp.extapi.switchTab as uni_switchTab
open class GenPagesUserMessageSystemmsg : BasePage {
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
        var setup: (__props: GenPagesUserMessageSystemmsg) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesUserMessageSystemmsg
            val _cache = __ins.renderCache
            val pageKey = ref("")
            val pageTitle = ref("")
            val pageHeight = ref(0)
            val back = fun(e: UniPointerEvent){
                console.log("aa")
                common.back()
            }
            val toIndex = fun(){
                uni_switchTab(SwitchTabOptions(url = "/pages/index/index"))
            }
            onLoad(fun(options){
                pageKey.value = options["key"] as String
                pageTitle.value = options["title"] as String
            }
            )
            onReady(fun(){
                pageHeight.value = uni_getWindowInfo().safeArea.height - 40
            }
            )
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_x_page_title = resolveEasyComponent("x-page-title", GenComponentsXPageTitleClass)
                return _cE("view", null, _uA(
                    _cV(_component_x_page_title, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to "pagetitle display-flex"), _uA(
                                _cE("text", _uM("class" to "align-center color-white title"), _tD(unref(pageTitle)), 1),
                                _cE("view", _uM("class" to "pagestatus display-flex"), _uA(
                                    _cE("view", _uM("class" to "statusitem back", "onClick" to back), _uA(
                                        _cV(_component_x_iconfont, _uM("class" to "icon", "name" to "fanhui", "color" to "white", "height" to 25, "size" to "16"))
                                    )),
                                    _cE("view", _uM("class" to "line")),
                                    _cE("view", _uM("class" to "statusitem index", "onClick" to toIndex), _uA(
                                        _cV(_component_x_iconfont, _uM("class" to "icon", "name" to "shouye1", "color" to "white", "height" to 25, "size" to "16"))
                                    ))
                                ))
                            ))
                        )
                    }
                    ), "_" to 1)),
                    _cE("scroll-view", _uM("scroll-into-view" to "bottoim", "style" to _nS(_uM("height" to (unref(pageHeight) + "px"))), "direction" to "vertical"), _uA(
                        _cE(Fragment, null, RenderHelpers.renderList(3, fun(item, index, __index, _cached): Any {
                            return _cE("view", _uM("class" to "tmpmsg", "key" to index), _uA(
                                _cE("text", _uM("class" to "msgtime align-center"), "2025年9月1日 15：39"),
                                _cE("view", _uM("class" to "tmpmsginfo background-white"), _uA(
                                    _cE("text", _uM("class" to "msgtitle"), "新配送订单提醒"),
                                    _cE("view", _uM("class" to "msgcontent"), _uA(
                                        _cE("view", _uM("class" to "msgitem display-flex"), _uA(
                                            _cE("text", _uM("class" to "mtitle"), "订单号"),
                                            _cE("view", _uM("class" to "mcontent display-flex"), _uA(
                                                _cE("text", _uM("class" to "maohao"), "："),
                                                _cE("text", _uM("class" to "content"), "20252512541414")
                                            ))
                                        )),
                                        _cE("view", _uM("class" to "msgitem display-flex"), _uA(
                                            _cE("text", _uM("class" to "mtitle"), "订单号"),
                                            _cE("view", _uM("class" to "mcontent display-flex"), _uA(
                                                _cE("text", _uM("class" to "maohao"), "："),
                                                _cE("text", _uM("class" to "content"), "20252512541414")
                                            ))
                                        )),
                                        _cE("view", _uM("class" to "msgitem display-flex"), _uA(
                                            _cE("text", _uM("class" to "mtitle"), "订单号"),
                                            _cE("view", _uM("class" to "mcontent display-flex"), _uA(
                                                _cE("text", _uM("class" to "maohao"), "："),
                                                _cE("text", _uM("class" to "content"), "20252512541414")
                                            ))
                                        )),
                                        _cE("view", _uM("class" to "msgitem display-flex"), _uA(
                                            _cE("text", _uM("class" to "mtitle"), "订单号"),
                                            _cE("view", _uM("class" to "mcontent display-flex"), _uA(
                                                _cE("text", _uM("class" to "maohao"), "："),
                                                _cE("text", _uM("class" to "content overline"), "2025251254141420252512541414202525125414142025251254141420252512541414")
                                            ))
                                        ))
                                    )),
                                    _cE("text", _uM("class" to "viewcontent"), "查看详情")
                                ))
                            ))
                        }
                        ), 64),
                        _cE("view", _uM("style" to _nS(_uM("height" to "45px"))), null, 4),
                        _cE("view", _uM("id" to "bottoim")),
                        _cE("view", _uM("style" to _nS(_uM("height" to "20px"))), null, 4)
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
                return _uM("pagetitle" to _pS(_uM("height" to 40, "width" to "750rpx", "position" to "relative")), "pagestatus" to _uM(".pagetitle " to _uM("left" to "18rpx", "top" to 8, "height" to 24, "width" to 76, "borderTopLeftRadius" to 12, "borderTopRightRadius" to 12, "borderBottomRightRadius" to 12, "borderBottomLeftRadius" to 12, "backgroundImage" to "none", "backgroundColor" to "#005FE3")), "statusitem" to _uM(".pagetitle .pagestatus " to _uM("width" to 37.5, "height" to 24)), "icon" to _uM(".pagetitle .pagestatus .statusitem " to _uM("textAlign" to "center")), "line" to _uM(".pagetitle .pagestatus " to _uM("height" to 14, "marginTop" to 5, "width" to 1, "backgroundColor" to "#FFFFFF")), "title" to _uM(".pagetitle " to _uM("position" to "absolute", "lineHeight" to "40px", "fontSize" to 15, "width" to "750rpx", "left" to 0)), "msgtime" to _uM(".tmpmsg " to _uM("color" to "#8A8A8A", "height" to 38, "lineHeight" to "38px", "fontSize" to 12)), "tmpmsginfo" to _uM(".tmpmsg " to _uM("width" to "706rpx", "marginLeft" to "22rpx", "borderTopLeftRadius" to 6, "borderTopRightRadius" to 6, "borderBottomRightRadius" to 6, "borderBottomLeftRadius" to 6, "boxShadow" to "0px 2px 4px #0000003F", "paddingLeft" to 16, "paddingTop" to 14)), "msgtitle" to _uM(".tmpmsg .tmpmsginfo " to _uM("fontSize" to 14, "color" to "#000000", "marginBottom" to 13, "fontWeight" to "bold")), "msgcontent" to _uM(".tmpmsg .tmpmsginfo " to _uM("paddingLeft" to 3, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#F2F2F2")), "mtitle" to _uM(".tmpmsg .tmpmsginfo .msgcontent .msgitem " to _uM("fontSize" to 14, "lineHeight" to "28px", "color" to "#6B6B6B")), "maohao" to _uM(".tmpmsg .tmpmsginfo .msgcontent .msgitem .mcontent " to _uM("fontSize" to 14, "lineHeight" to "28px", "color" to "#6B6B6B")), "content" to _uM(".tmpmsg .tmpmsginfo .msgcontent .msgitem .mcontent " to _uM("paddingLeft" to 9, "fontSize" to 14, "lineHeight" to "28px", "color" to "#000000", "maxWidth" to "500rpx")), "viewcontent" to _uM(".tmpmsg .tmpmsginfo " to _uM("height" to 40, "color" to "#4D4D4D", "fontSize" to 14, "lineHeight" to "40px")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
