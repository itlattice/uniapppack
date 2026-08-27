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
import io.dcloud.uniapp.extapi.`$emit` as uni__emit
open class GenPagesTemplateCustomTabBarCustomTabBarTab1 : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var scrollTop: (top: Number) -> Unit
        get() {
            return unref(this.`$exposed`["scrollTop"]) as (top: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "scrollTop", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesTemplateCustomTabBarCustomTabBarTab1, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesTemplateCustomTabBarCustomTabBarTab1
            val _cache = __ins.renderCache
            val dataList = ref(_uA<ListItem__3>())
            val oldScrollTop = ref(0)
            val newScrollTop = ref(0)
            fun gen_loadData_fn() {
                var index = dataList.value.length
                run {
                    var i: Number = 0
                    while(i < 20){
                        dataList.value.push(ListItem__3(title = index.toString(10)))
                        index++
                        i++
                    }
                }
            }
            val loadData = ::gen_loadData_fn
            fun gen_onScroll_fn(e: ScrollEvent) {
                uni__emit("tabchange", e.detail.scrollTop)
                oldScrollTop.value = e.detail.scrollTop
            }
            val onScroll = ::gen_onScroll_fn
            fun gen_scrollTop_fn(top: Number) {
                newScrollTop.value = oldScrollTop.value
                nextTick(fun(){
                    newScrollTop.value = top
                }
                )
            }
            val scrollTop = ::gen_scrollTop_fn
            onMounted(fun(){
                loadData()
            }
            )
            __expose(_uM("scrollTop" to scrollTop))
            return fun(): Any? {
                return _cE("scroll-view", _uM("ref" to "listView", "class" to "list", "bounces" to false, "scroll-with-animation" to true, "scroll-top" to unref(newScrollTop), "onScrolltolower" to fun(){
                    loadData()
                }
                , "onScroll" to onScroll), _uA(
                    _cE(Fragment, null, RenderHelpers.renderList(unref(dataList), fun(item, index, __index, _cached): Any {
                        return _cE("view", _uM("class" to "list-item", "key" to index), _uA(
                            _cE("view", _uM("class" to "cell-item"), _uA(
                                _cE("text", _uM("class" to "title"), "内容：" + _tD(item.title), 1),
                                _cE("input", _uM("class" to "title", "style" to _nS(_uM("margin-top" to "8px")), "placeholder" to "备注:"), null, 4)
                            ))
                        ))
                    }
                    ), 128)
                ), 40, _uA(
                    "scroll-top",
                    "onScrolltolower"
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
                return _uM("list" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "backgroundColor" to "#ffffff")), "list-item" to _pS(_uM("flexDirection" to "row", "paddingTop" to 30, "paddingRight" to 30, "paddingBottom" to 30, "paddingLeft" to 30, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#dbdbdb")), "title" to _pS(_uM("fontSize" to 16, "textAlign" to "left")), "cell-item" to _pS(_uM("display" to "flex", "flexDirection" to "column")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
