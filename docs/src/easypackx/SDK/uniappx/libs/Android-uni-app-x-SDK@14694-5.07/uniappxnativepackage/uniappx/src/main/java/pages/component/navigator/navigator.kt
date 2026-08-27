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
open class GenPagesComponentNavigatorNavigator : BasePage {
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
        var setup: (__props: GenPagesComponentNavigatorNavigator) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentNavigatorNavigator
            val _cache = __ins.renderCache
            val title = ref("navigator")
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                val _component_navigator = resolveComponent("navigator")
                return _cE(Fragment, null, _uA(
                    _cV(_component_page_head, _uM("title" to unref(title)), null, 8, _uA(
                        "title"
                    )),
                    _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt"), _uA(
                        _cV(_component_navigator, _uM("id" to "navigate", "class" to "navigator", "url" to "navigate?title=navigate"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("button", _uM("type" to "default"), "跳转到新页面")
                            )
                        }
                        ), "_" to 1)),
                        _cV(_component_navigator, _uM("id" to "redirect", "class" to "navigator", "url" to "redirect?title=redirect", "open-type" to "redirect"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("button", _uM("type" to "default"), "在当前页打开redirect")
                            )
                        }
                        ), "_" to 1)),
                        _cV(_component_navigator, _uM("id" to "switchTab", "class" to "navigator", "url" to "/pages/tabBar/template", "open-type" to "switchTab"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("button", _uM("type" to "default"), "切换到模板选项卡switchTab")
                            )
                        }
                        ), "_" to 1)),
                        _cV(_component_navigator, _uM("id" to "reLaunch", "class" to "navigator", "url" to "/pages/tabBar/component", "open-type" to "reLaunch"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("button", _uM("type" to "default"), "关闭所有页面回首页reLaunch")
                            )
                        }
                        ), "_" to 1)),
                        _cV(_component_navigator, _uM("id" to "reLaunch", "class" to "navigator", "open-type" to "navigateBack"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("button", _uM("type" to "default"), "返回上一页navigateBack")
                            )
                        }
                        ), "_" to 1)),
                        _cV(_component_navigator, _uM("id" to "navigateToErrorPage", "class" to "navigator", "url" to "/pages/error-page/error-page"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("button", _uM("type" to "default"), " 打开不存在的页面 ")
                            )
                        }
                        ), "_" to 1)),
                        _cV(_component_navigator, _uM("id" to "navigateToErrorPage", "class" to "navigator"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("button", _uM("type" to "default"), " 未指定URL的跳转 ")
                            )
                        }
                        ), "_" to 1)),
                        _cV(_component_navigator, _uM("style" to _nS(_uM("flex-direction" to "row", "justify-content" to "space-between"))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("text", null, "两端对齐样式测试"),
                                _cE("view", _uM("style" to _nS(_uM("width" to "20px", "height" to "20px", "background-color" to "aqua"))), null, 4)
                            )
                        }
                        ), "_" to 1), 8, _uA(
                            "style"
                        ))
                    ))
                ), 64)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("navigator" to _pS(_uM("marginBottom" to 15)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
