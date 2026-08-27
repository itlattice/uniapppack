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
open class GenPagesComponentStickySectionIssues16118 : BasePage {
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
    open var switchDisplay: () -> Unit
        get() {
            return unref(this.`$exposed`["switchDisplay"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "switchDisplay", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentStickySectionIssues16118, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentStickySectionIssues16118
            val _cache = __ins.renderCache
            val groupItems = ref(_uA<ItemGroup>())
            val contentVisible = ref(false)
            fun gen_switchDisplay_fn() {
                if (contentVisible.value) {
                    contentVisible.value = false
                } else {
                    contentVisible.value = true
                }
                if (contentVisible.value) {
                    setTimeout(fun(){
                        groupItems.value = _uA<ItemGroup>(ItemGroup(title = "sticky-header"))
                    }, 200)
                } else {
                    setTimeout(fun(){
                        groupItems.value = _uA()
                    }
                    , 200)
                }
            }
            val switchDisplay = ::gen_switchDisplay_fn
            __expose(_uM("switchDisplay" to switchDisplay))
            return fun(): Any? {
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("button", _uM("onClick" to switchDisplay), "显示内容"),
                    withDirectives(_cE("view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                        _cE("list-view", _uM("style" to _nS(_uM("height" to "200px"))), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(unref(groupItems), fun(group, _, __index, _cached): Any {
                                return _cE("sticky-section", null, _uA(
                                    _cE("sticky-header", _uM("style" to _nS(_uM("background-color" to "antiquewhite"))), _uA(
                                        _cE("text", _uM("class" to "group-title"), _tD(group.title), 1)
                                    ), 4),
                                    _cE("list-item", _uM("class" to "content-group"), _uA(
                                        _cE("view", _uM("class" to "content-box"), _uA(
                                            _cE(Fragment, null, RenderHelpers.renderList(20, fun(index, __key, __index, _cached): Any {
                                                return _cE("text", _uM("class" to "item"), _tD(index) + " item信息", 1)
                                            }
                                            ), 64)
                                        ))
                                    ))
                                ))
                            }
                            ), 256)
                        ), 4)
                    ), 4), _uA(
                        _uA(
                            vShow,
                            unref(contentVisible)
                        )
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
                return _uM("group-title" to _pS(_uM("fontWeight" to "bold", "fontSize" to 14, "color" to "#4B515A", "paddingTop" to 8, "paddingRight" to 0, "paddingBottom" to 8, "paddingLeft" to 0, "backgroundColor" to "#FFFFFF")), "content-group" to _pS(_uM("flexDirection" to "row", "flexWrap" to "wrap")), "content-box" to _pS(_uM("width" to "100%", "position" to "relative")), "item" to _pS(_uM("paddingTop" to 10, "paddingRight" to 0, "paddingBottom" to 10, "paddingLeft" to 0, "backgroundColor" to "#efeda7")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
