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
import io.dcloud.uniapp.extapi.setNavigationBarColor as uni_setNavigationBarColor
open class GenPagesIndexStaticpage : BasePage {
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
        var setup: (__props: GenPagesIndexStaticpage) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesIndexStaticpage
            val _cache = __ins.renderCache
            val show = ref(false)
            val showDate = fun(){
                show.value = true
            }
            onShow(fun(){
                uni_setNavigationBarColor(SetNavigationBarColorOptions(frontColor = "#ffffff", backgroundColor = "#1678fd"))
            }
            )
            onReady(fun(){})
            return fun(): Any? {
                val _component_x_static_action = resolveEasyComponent("x-static-action", GenComponentsXStaticActionClass)
                val _component_tmx_between_time = resolveEasyComponent("tmx-between-time", GenUniModulesTmxUiComponentsTmxBetweenTimeTmxBetweenTimeClass)
                return _cE("view", null, _uA(
                    _cE("view", _uM("class" to "staticcard background-white"), _uA(
                        _cE("text", _uM("class" to "title font-bold"), "经营汇总"),
                        _cE("view", _uM("class" to "carditems"), _uA(
                            _cE("view", _uM("class" to "actions list-items"), _uA(
                                _cE("view", _uM("class" to "action-item litem"), _uA(
                                    _cV(_component_x_static_action, _uM("name" to "经营概况", "iconColor" to "#FFCE1F"), _uM("content" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cE("text", _uM("class" to "content"), "每日基本情况概况")
                                        )
                                    }
                                    ), "_" to 1))
                                )),
                                _cE("view", _uM("class" to "action-item litem"), _uA(
                                    _cV(_component_x_static_action, _uM("name" to "销售报表", "iconColor" to "#FF5733"), _uM("content" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cE("view", null, _uA(
                                                _cE("view", _uM("class" to "display-flex"), _uA(
                                                    _cE("text", _uM("class" to "content"), "今日销售"),
                                                    _cE("text", _uM("class" to "number"), "3"),
                                                    _cE("text", _uM("class" to "content"), "笔")
                                                )),
                                                _cE("text", _uM("class" to "content2"), "￥49541.25")
                                            ))
                                        )
                                    }
                                    ), "_" to 1))
                                ))
                            ))
                        ))
                    )),
                    _cE("view", _uM("class" to "staticcard background-white"), _uA(
                        _cE("text", _uM("class" to "title font-bold"), "经营汇总"),
                        _cE("view", _uM("class" to "carditems"), _uA(
                            _cE("view", _uM("class" to "actions list-items"), _uA(
                                _cE("view", _uM("class" to "action-item litem"), _uA(
                                    _cV(_component_x_static_action, _uM("name" to "经营概况", "iconColor" to "#FFCE1F"), _uM("content" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cE("text", _uM("class" to "content"), "每日基本情况概况")
                                        )
                                    }
                                    ), "_" to 1))
                                )),
                                _cE("view", _uM("class" to "action-item litem"), _uA(
                                    _cV(_component_x_static_action, _uM("name" to "销售报表", "iconColor" to "#FF5733", "onClick" to showDate), _uM("content" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cE("view", null, _uA(
                                                _cE("view", _uM("class" to "display-flex"), _uA(
                                                    _cE("text", _uM("class" to "content"), "今日销售"),
                                                    _cE("text", _uM("class" to "number"), "3"),
                                                    _cE("text", _uM("class" to "content"), "笔")
                                                )),
                                                _cE("text", _uM("class" to "content2"), "￥49541.25")
                                            ))
                                        )
                                    }
                                    ), "_" to 1))
                                ))
                            ))
                        ))
                    )),
                    _cV(_component_tmx_between_time, _uM("modelShow" to unref(show)), null, 8, _uA(
                        "modelShow"
                    ))
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
                return _uM("staticcard" to _pS(_uM("marginTop" to 8, "width" to "732rpx", "marginLeft" to "9rpx", "borderTopLeftRadius" to "10rpx", "borderTopRightRadius" to "10rpx", "borderBottomRightRadius" to "10rpx", "borderBottomLeftRadius" to "10rpx", "paddingLeft" to "22rpx", "paddingTop" to 10, "paddingBottom" to 20)), "title" to _uM(".staticcard " to _uM("fontSize" to 14, "color" to "#6B6B6B", "marginBottom" to "16rpx")), "carditems" to _uM(".staticcard " to _uM("paddingTop" to "20rpx")), "actions" to _uM(".staticcard .carditems " to _uM("width" to "100%")), "action-item" to _uM(".staticcard .carditems .actions " to _uM("flexBasis" to "50%", "height" to "110rpx")), "content" to _uM(".staticcard .carditems .actions .action-item " to _uM("color" to "#A8A8A8", "fontSize" to 12)), "number" to _uM(".staticcard .carditems .actions .action-item " to _uM("fontSize" to 13, "color" to "#FF8D1A")), "content2" to _uM(".staticcard .carditems .actions .action-item " to _uM("color" to "#000000", "fontSize" to 12)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
