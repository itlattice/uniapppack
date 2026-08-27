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
open class GenPagesComponentListViewIssue16126 : BasePage {
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
    open var data: DataType__46
        get() {
            return unref(this.`$exposed`["data"]) as DataType__46
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var setScrollTop: (value: Number) -> Unit
        get() {
            return unref(this.`$exposed`["setScrollTop"]) as (value: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setScrollTop", value)
        }
    open var getScrollTop: () -> Number
        get() {
            return unref(this.`$exposed`["getScrollTop"]) as () -> Number
        }
        set(value) {
            setRefValue(this.`$exposed`, "getScrollTop", value)
        }
    open var changeSize: () -> Unit
        get() {
            return unref(this.`$exposed`["changeSize"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "changeSize", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentListViewIssue16126, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentListViewIssue16126
            val _cache = __ins.renderCache
            val listViewStyle = ref("flex:1; width: 100%; heigth: 100%")
            val dataList = ref(10)
            val scrolltop = ref(0)
            val listviewRef = ref<UniListViewElement?>(null)
            val data = reactive(DataType__46(intoview = ""))
            fun gen_changeSize_fn() {
                if (listViewStyle.value == "flex:1; width: 100%; heigth: 100%") {
                    listViewStyle.value = "flex:1; width: 50%; heigth: 100%;"
                } else {
                    listViewStyle.value = "flex:1; width: 100%; heigth: 100%"
                }
            }
            val changeSize = ::gen_changeSize_fn
            fun gen_loadMore_fn() {
                setTimeout(fun(){
                    dataList.value += 10
                }
                , 1000)
            }
            val loadMore = ::gen_loadMore_fn
            fun gen_setScrollTop_fn(value: Number) {
                scrolltop.value = value
            }
            val setScrollTop = ::gen_setScrollTop_fn
            fun gen_getScrollTop_fn(): Number {
                var ret = listviewRef.value?.scrollTop ?: -1
                console.log(ret)
                return ret
            }
            val getScrollTop = ::gen_getScrollTop_fn
            onReady(fun(){})
            __expose(_uM("data" to data, "setScrollTop" to setScrollTop, "getScrollTop" to getScrollTop, "changeSize" to changeSize))
            return fun(): Any? {
                return _cE("view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("list-view", _uM("ref_key" to "listviewRef", "ref" to listviewRef, "style" to _nS(unref(listViewStyle)), "onScrolltolower" to loadMore, "scroll-into-view" to unref(data).intoview, "scroll-top" to unref(scrolltop)), _uA(
                        _cE(Fragment, null, RenderHelpers.renderList(unref(dataList), fun(index, __key, __index, _cached): Any {
                            return _cE("list-item", _uM("class" to "listItem", "key" to index, "id" to ("item" + index), "onClick" to changeSize, "type" to "1"), _uA(
                                _cE("text", null, _tD(index), 1)
                            ), 8, _uA(
                                "id"
                            ))
                        }
                        ), 128),
                        _cE("list-item", _uM("class" to "listItem"), _uA(
                            _cE("text", null, "加载更多中...")
                        ))
                    ), 44, _uA(
                        "scroll-into-view",
                        "scroll-top"
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
                return _uM("listView" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "listItem" to _pS(_uM("width" to "100%", "height" to 100, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 0, "borderLeftWidth" to 1, "borderTopColor" to "#FF0000", "borderRightColor" to "#FF0000", "borderBottomColor" to "#FF0000", "borderLeftColor" to "#FF0000", "alignItems" to "center", "justifyContent" to "center")), "banner" to _pS(_uM("height" to 180, "overflow" to "hidden", "position" to "relative", "backgroundColor" to "#cccccc")), "banner-img" to _pS(_uM("width" to "100%")), "banner-title" to _pS(_uM("maxHeight" to 42, "overflow" to "hidden", "position" to "absolute", "left" to 15, "bottom" to 15, "width" to "90%", "fontSize" to 16, "fontWeight" to "400", "lineHeight" to "21px", "color" to "#FFFFFF")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
