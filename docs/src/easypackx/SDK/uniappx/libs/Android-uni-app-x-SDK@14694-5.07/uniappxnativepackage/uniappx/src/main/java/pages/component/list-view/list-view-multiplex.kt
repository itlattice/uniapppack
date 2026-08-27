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
open class GenPagesComponentListViewListViewMultiplex : BasePage {
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
    open var data: DataType__12
        get() {
            return unref(this.`$exposed`["data"]) as DataType__12
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var listViewScrollByY: (y: Number) -> Unit
        get() {
            return unref(this.`$exposed`["listViewScrollByY"]) as (y: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "listViewScrollByY", value)
        }
    open var delayShow: () -> Unit
        get() {
            return unref(this.`$exposed`["delayShow"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "delayShow", value)
        }
    open var switchItemContent: () -> Unit
        get() {
            return unref(this.`$exposed`["switchItemContent"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "switchItemContent", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentListViewListViewMultiplex, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentListViewListViewMultiplex
            val _cache = __ins.renderCache
            val list = ref(_uA<Item__2>())
            val listViewElement = ref(null as UniListViewElement?)
            val data = reactive(DataType__12(list_show = true, displayArrow = false))
            fun gen_generateItems_fn(count: Number) {
                val startIndex = list.value.length
                run {
                    var i: Number = 0
                    while(i < count){
                        list.value.push(Item__2(id = startIndex + i + 1, checked = false))
                        i++
                    }
                }
            }
            val generateItems = ::gen_generateItems_fn
            fun gen_onScrollTolower_fn(event: ScrollToLowerEvent) {
                setTimeout(fun(){
                    generateItems(20)
                }
                , 300)
            }
            val onScrollTolower = ::gen_onScrollTolower_fn
            onMounted(fun(){
                generateItems(20)
            }
            )
            fun gen_listViewScrollByY_fn(y: Number) {
                listViewElement.value?.scrollBy(0, y)
            }
            val listViewScrollByY = ::gen_listViewScrollByY_fn
            fun gen_itemClick_fn(index: Number) {
                console.log("itemTextClick---" + index)
            }
            val itemClick = ::gen_itemClick_fn
            fun gen_checkedChange_fn(index: Number) {
                list.value[index].checked = !list.value[index].checked
            }
            val checkedChange = ::gen_checkedChange_fn
            fun gen_delayShow_fn() {
                data.list_show = !data.list_show
                setTimeout(fun(){
                    data.list_show = !data.list_show
                }
                , 400)
            }
            val delayShow = ::gen_delayShow_fn
            fun gen_modifyItemPadding_fn(index: Number) {
                var element = uni_getElementById("item_" + index)
                element?.style?.setProperty("padding", "0px")
            }
            val modifyItemPadding = ::gen_modifyItemPadding_fn
            fun gen_switchItemContent_fn() {
                data.displayArrow = !data.displayArrow
                modifyItemPadding(1)
            }
            val switchItemContent = ::gen_switchItemContent_fn
            onReady(fun(){
                listViewElement.value = uni_getElementById<UniListViewElement>("listview")
            }
            )
            __expose(_uM("data" to data, "listViewScrollByY" to listViewScrollByY, "delayShow" to delayShow, "switchItemContent" to switchItemContent))
            return fun(): Any? {
                val _component_checkbox = resolveComponent("checkbox")
                val _component_checkbox_group = resolveComponent("checkbox-group")
                return _cE("view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("scroll-view", _uM("direction" to "horizontal", "style" to _nS(_uM("flex-direction" to "row"))), _uA(
                        _cE("button", _uM("class" to "button_item", "onClick" to delayShow), "测试延时显示"),
                        _cE("button", _uM("class" to "button_item", "onClick" to switchItemContent), "修改item子元素")
                    ), 4),
                    withDirectives(_cE("list-view", _uM("id" to "listview", "style" to _nS(_uM("flex" to "1")), "show-scrollbar" to "false", "onScrolltolower" to onScrollTolower), _uA(
                        _cE(Fragment, null, RenderHelpers.renderList(unref(list), fun(item, index, __index, _cached): Any {
                            return _cE("list-item", _uM("key" to item.id, "id" to ("item_" + item.id), "class" to "item", "onClick" to fun(){
                                itemClick(item.id)
                            }
                            ), _uA(
                                _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row"))), _uA(
                                    _cE("text", null, _uA(
                                        "item-------",
                                        _cE("text", null, _tD(item.id), 1)
                                    )),
                                    _cE("scroll-view", _uM("direction" to "horizontal", "show-scrollbar" to "false", "class" to "scroll_item"), _uA(
                                        _cE("text", null, "scroll-view" + _tD(item.id) + "：", 1),
                                        _cE(Fragment, null, RenderHelpers.renderList(5, fun(tab, __key, __index, _cached): Any {
                                            return _cE("text", _uM("class" to "tip_text"), "元素" + _tD(tab), 1)
                                        }
                                        ), 64)
                                    ))
                                ), 4),
                                withDirectives(_cE("text", null, _uA(
                                    "item-------",
                                    _cE("text", null, _tD(item.id), 1)
                                ), 512), _uA(
                                    _uA(
                                        vShow,
                                        unref(data).displayArrow
                                    )
                                )),
                                _cV(_component_checkbox_group, _uM("onChange" to fun(){
                                    checkedChange(index)
                                }
                                ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cV(_component_checkbox, _uM("checked" to item.checked), null, 8, _uA(
                                            "checked"
                                        ))
                                    )
                                }
                                ), "_" to 2), 1032, _uA(
                                    "onChange"
                                ))
                            ), 8, _uA(
                                "id",
                                "onClick"
                            ))
                        }
                        ), 128)
                    ), 36), _uA(
                        _uA(
                            vShow,
                            unref(data).list_show
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
                return _uM("item" to _pS(_uM("paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15, "marginTop" to 0, "marginRight" to 0, "marginBottom" to 5, "marginLeft" to 0, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#000000", "borderRightColor" to "#000000", "borderBottomColor" to "#000000", "borderLeftColor" to "#000000", "backgroundColor" to "#fdfdfd", "borderTopLeftRadius" to 5, "borderTopRightRadius" to 5, "borderBottomRightRadius" to 5, "borderBottomLeftRadius" to 5)), "button_item" to _pS(_uM("width" to 200)), "scroll_item" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "flexDirection" to "row", "overflow" to "hidden", "marginLeft" to 10)), "tip_text" to _pS(_uM("borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopLeftRadius" to 3, "borderTopRightRadius" to 3, "borderBottomRightRadius" to 3, "borderBottomLeftRadius" to 3, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "marginTop" to 0, "marginRight" to 10, "marginBottom" to 0, "marginLeft" to 10)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
