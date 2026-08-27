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
import io.dcloud.uniapp.extapi.getElementById as uni_getElementById
open class GenPagesComponentListViewListViewMultiplexInput : BasePage {
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
    open var data: DataType__13
        get() {
            return unref(this.`$exposed`["data"]) as DataType__13
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentListViewListViewMultiplexInput, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentListViewListViewMultiplexInput
            val _cache = __ins.renderCache
            val data = reactive(DataType__13(item_count = 20, isTesting = false))
            val listViewElement = ref(null as UniListViewElement?)
            fun gen_onScrollTolower_fn(event: ScrollToLowerEvent) {
                setTimeout(fun(){
                    if (data.isTesting && data.item_count > 20) {
                        return
                    }
                    data.item_count += 20
                }
                , 300)
            }
            val onScrollTolower = ::gen_onScrollTolower_fn
            fun gen_itemClick_fn(index: Number) {
                console.log("itemTextClick---" + index)
            }
            val itemClick = ::gen_itemClick_fn
            fun gen_childTextClick_fn(index: Number) {
                console.log("childTextClick---" + index)
            }
            val childTextClick = ::gen_childTextClick_fn
            onReady(fun(){
                listViewElement.value = uni_getElementById<UniListViewElement>("listview")
            }
            )
            __expose(_uM("data" to data))
            return fun(): Any? {
                return _cE("list-view", _uM("id" to "listview", "style" to _nS(_uM("flex" to "1")), "show-scrollbar" to "false", "onScrolltolower" to onScrollTolower), _uA(
                    _cE(Fragment, null, RenderHelpers.renderList(unref(data).item_count, fun(index, __key, __index, _cached): Any {
                        return _cE("list-item", _uM("key" to index, "class" to "item", "onClick" to fun(){
                            itemClick(index)
                        }
                        ), _uA(
                            _cE("text", null, _uA(
                                "item---",
                                _cE("text", _uM("onClick" to withModifiers(fun(){
                                    childTextClick(index)
                                }
                                , _uA(
                                    "stop"
                                ))), "----" + _tD(index), 9, _uA(
                                    "onClick"
                                ))
                            )),
                            _cE("input", _uM("style" to _nS(_uM("border-width" to "1px", "border-style" to "solid")), "placeholder" to (index + ""), "value" to if (index == 1) {
                                "第一个"
                            } else {
                                index
                            }
                            ), null, 12, _uA(
                                "placeholder",
                                "value"
                            ))
                        ), 8, _uA(
                            "onClick"
                        ))
                    }
                    ), 128)
                ), 36)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("item" to _pS(_uM("paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15, "marginTop" to 0, "marginRight" to 0, "marginBottom" to 5, "marginLeft" to 0, "backgroundColor" to "#ffffff", "borderTopLeftRadius" to 5, "borderTopRightRadius" to 5, "borderBottomRightRadius" to 5, "borderBottomLeftRadius" to 5)), "button_item" to _pS(_uM("width" to 200)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
