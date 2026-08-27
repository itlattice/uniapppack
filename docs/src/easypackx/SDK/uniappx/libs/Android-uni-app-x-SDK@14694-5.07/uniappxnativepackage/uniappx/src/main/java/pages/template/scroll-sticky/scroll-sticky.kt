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
import io.dcloud.uniapp.extapi.navigateBack as uni_navigateBack
open class GenPagesTemplateScrollStickyScrollSticky : BasePage {
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
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesTemplateScrollStickyScrollSticky) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesTemplateScrollStickyScrollSticky
            val _cache = __ins.renderCache
            val list = ref(_uA(
                "1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "7",
                "8",
                "9",
                "10",
                "11",
                "12",
                "13",
                "14",
                "15"
            ))
            var stickyTop: Number = 0
            var stickyTran: Number = 0
            val scrollTop = ref(0)
            val sticky = ref<UniElement?>(null)
            val scroll = ref<UniElement?>(null)
            fun gen_onScroll_fn(e: ScrollEvent) {
                if (e.detail.scrollTop > stickyTop) {
                    var stickyTran_ = e.detail.scrollTop - stickyTop
                    if (stickyTran_ != stickyTran) {
                        sticky.value?.style?.setProperty("transform", "translateY(" + stickyTran_ + "px)")
                    }
                    stickyTran = stickyTran_
                } else {
                    sticky.value?.style?.setProperty("transform", "")
                    stickyTran = 0
                }
            }
            val onScroll = ::gen_onScroll_fn
            fun gen_back_fn() {
                uni_navigateBack(NavigateBackOptions(success = fun(result) {
                    console.log("navigateBack success", result.errMsg)
                }
                , fail = fun(error) {
                    console.log("navigateBack fail", error.errMsg)
                }
                , complete = fun(result) {
                    console.log("navigateBack complete", result.errMsg)
                }
                ))
            }
            val back = ::gen_back_fn
            fun gen_calcStickyTop_fn(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        if (sticky.value != null && scroll.value != null) {
                            val stickyRect = await(sticky.value!!.getBoundingClientRectAsync()!!)
                            val scrollRect = await(scroll.value!!.getBoundingClientRectAsync()!!)
                            stickyTop = stickyRect.top - scrollRect.top
                            console.log(stickyRect, scrollRect)
                        }
                })
            }
            val calcStickyTop = ::gen_calcStickyTop_fn
            onLoad(fun(_options){})
            onReady(fun(){
                calcStickyTop()
            }
            )
            return fun(): Any? {
                return _cE("scroll-view", _uM("ref_key" to "scroll", "ref" to scroll, "onScroll" to onScroll, "class" to "page", "bounces" to "false"), _uA(
                    _cE("view", _uM("class" to "content-item"), _uA(
                        _cE("text", _uM("class" to "text"), "向上滑动页面，体验元素吸顶效果。")
                    )),
                    _cE(Fragment, null, RenderHelpers.renderList(unref(list), fun(item, index, __index, _cached): Any {
                        return _cE("view", _uM("key" to index, "class" to "content-item"), _uA(
                            _cE("text", _uM("class" to "text"), "first content-" + _tD(item), 1)
                        ))
                    }
                    ), 128),
                    _cE("view", _uM("ref_key" to "sticky", "ref" to sticky, "class" to "search"), _uA(
                        _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row"))), _uA(
                            _cE("image", _uM("src" to "/static/template/scroll-fold-nav/search.png", "style" to _nS(_uM("width" to "15px")), "mode" to "widthFix"), null, 4),
                            _cE("text", _uM("class" to "search-tip-text"), "请输入你要搜索的内容")
                        ), 4),
                        _cE("text", _uM("class" to "search-btn"), "搜索")
                    ), 512),
                    _cE(Fragment, null, RenderHelpers.renderList(unref(list), fun(item, index, __index, _cached): Any {
                        return _cE("view", _uM("key" to index, "class" to "content-item"), _uA(
                            _cE("text", _uM("class" to "text"), "second content-" + _tD(item), 1)
                        ))
                    }
                    ), 128),
                    _cE(Fragment, null, RenderHelpers.renderList(unref(list), fun(item, index, __index, _cached): Any {
                        return _cE("view", _uM("key" to index, "class" to "content-item"), _uA(
                            _cE("text", _uM("class" to "text"), "second content-" + _tD(item), 1)
                        ))
                    }
                    ), 128)
                ), 544)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("page" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 15, "backgroundColor" to "#f5f5f5")), "content-item" to _pS(_uM("paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15, "marginTop" to 5, "marginRight" to 0, "marginBottom" to 5, "marginLeft" to 0, "backgroundColor" to "#ffffff", "borderTopLeftRadius" to 5, "borderTopRightRadius" to 5, "borderBottomRightRadius" to 5, "borderBottomLeftRadius" to 5)), "text" to _pS(_uM("fontSize" to 14, "color" to "#666666", "lineHeight" to "20px")), "search" to _pS(_uM("backgroundColor" to "#FFFFFF", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#fbdf0d", "borderRightColor" to "#fbdf0d", "borderBottomColor" to "#fbdf0d", "borderLeftColor" to "#fbdf0d", "height" to 35, "borderTopLeftRadius" to 100, "borderTopRightRadius" to 100, "borderBottomRightRadius" to 100, "borderBottomLeftRadius" to 100, "marginTop" to 0, "marginRight" to 12, "marginBottom" to 0, "marginLeft" to 12, "paddingTop" to 8, "paddingRight" to 8, "paddingBottom" to 8, "paddingLeft" to 8, "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "space-between", "zIndex" to 100)), "search-tip-text" to _pS(_uM("fontSize" to 12, "color" to "#666666")), "search-btn" to _pS(_uM("fontSize" to 12, "backgroundColor" to "#ff6900", "color" to "#FFFFFF", "paddingTop" to 5, "paddingRight" to 8, "paddingBottom" to 5, "paddingLeft" to 8, "borderTopLeftRadius" to 100, "borderTopRightRadius" to 100, "borderBottomRightRadius" to 100, "borderBottomLeftRadius" to 100)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
