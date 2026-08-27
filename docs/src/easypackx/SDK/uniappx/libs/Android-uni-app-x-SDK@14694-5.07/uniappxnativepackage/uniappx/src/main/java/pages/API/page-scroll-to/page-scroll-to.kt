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
import io.dcloud.uniapp.extapi.pageScrollTo as uni_pageScrollTo
open class GenPagesAPIPageScrollToPageScrollTo : BasePage {
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
    open var scrollTo: () -> Unit
        get() {
            return unref(this.`$exposed`["scrollTo"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "scrollTo", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIPageScrollToPageScrollTo, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIPageScrollToPageScrollTo
            val _cache = __ins.renderCache
            val title = ref("pageScrollTo")
            val scrollTo = fun(){
                uni_pageScrollTo(PageScrollToOptions(scrollTop = 100, duration = 300, success = fun(_){
                    console.log("success")
                }
                ))
            }
            val scrollToElement = fun(){
                uni_pageScrollTo(PageScrollToOptions(selector = ".custom-element", duration = 300, success = fun(_){
                    console.log("success")
                }
                ))
            }
            __expose(_uM("scrollTo" to scrollTo))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1")), "scroll-with-animation" to "true"), _uA(
                    _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                        _cV(_component_page_head, _uM("title" to unref(title)), null, 8, _uA(
                            "title"
                        )),
                        _cE("button", _uM("type" to "default", "class" to "btn-scrollTo", "onClick" to scrollTo), " scrollTo "),
                        _cE("button", _uM("type" to "default", "class" to "btn-scrollToElement", "onClick" to scrollToElement), " scrollToElement "),
                        _cE(Fragment, null, RenderHelpers.renderList(10, fun(_, index, __index, _cached): Any {
                            return _cE("view", _uM("class" to "uni-list", "key" to index), _uA(
                                _cE("view", _uM("class" to "uni-list-cell list-item"), _tD(index), 1)
                            ))
                        }
                        ), 64),
                        _cE("view", _uM("class" to "custom-element"), "scrollTo-custom-element"),
                        _cE(Fragment, null, RenderHelpers.renderList(10, fun(_, index2, __index, _cached): Any {
                            return _cE("view", _uM("class" to "uni-list", "key" to index2), _uA(
                                _cE("view", _uM("class" to "uni-list-cell list-item"), _tD(index2), 1)
                            ))
                        }
                        ), 64)
                    ))
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
                return _uM("list-item" to _pS(_uM("height" to 100, "paddingLeft" to 30)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
