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
open class GenPagesComponentListViewListViewFormItem : BasePage {
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
        var setup: (__props: GenPagesComponentListViewListViewFormItem) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentListViewListViewFormItem
            val _cache = __ins.renderCache
            val items = ref(_uA<Item__3>())
            val page = ref(1)
            val pageSize: Number = 20
            val total: Number = 100
            fun loadData(isRefresh: Boolean = false): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        if (isRefresh) {
                            page.value = 1
                            items.value = _uA()
                        }
                        val newItems: UTSArray<Item__3> = _uA()
                        run {
                            var i: Number = 0
                            while(i < pageSize){
                                val id = (page.value - 1) * pageSize + i + 1
                                newItems.push(Item__3(id = id, name = "Item " + id, checkboxChecked = false, switchChecked = false, inputValue = "Item " + id))
                                i++
                            }
                        }
                        items.value = items.value.concat(newItems)
                        page.value++
                })
            }
            fun gen_loadmore_fn(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        if (items.value.length < total) {
                            await(loadData(false))
                        }
                })
            }
            val loadmore = ::gen_loadmore_fn
            fun gen_refresh_fn(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        await(loadData(true))
                })
            }
            val refresh = ::gen_refresh_fn
            fun gen_checkboxChange_fn(index: Number) {
                items.value[index].checkboxChecked = !items.value[index].checkboxChecked
            }
            val checkboxChange = ::gen_checkboxChange_fn
            fun gen_switchChange_fn(index: Number) {
                items.value[index].switchChecked = !items.value[index].switchChecked
            }
            val switchChange = ::gen_switchChange_fn
            onMounted(fun(){
                loadData(false)
            }
            )
            return fun(): Any? {
                val _component_checkbox = resolveComponent("checkbox")
                val _component_checkbox_group = resolveComponent("checkbox-group")
                val _component_switch = resolveComponent("switch")
                return _cE("view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("list-view", _uM("style" to _nS(_uM("flex" to "1")), "onScrolltolower" to loadmore, "refresher-enabled" to true, "onRefresherrefresh" to refresh), _uA(
                        _cE(Fragment, null, RenderHelpers.renderList(unref(items), fun(item, index, __index, _cached): Any {
                            return _cE("list-item", _uM("key" to item.id, "style" to _nS(_uM("padding" to "10px", "border-bottom" to "1px solid #eee"))), _uA(
                                _cE("view", null, _uA(
                                    _cE("text", null, _tD(item.name), 1)
                                )),
                                _cE("view", _uM("style" to _nS(_uM("margin-top" to "10px"))), _uA(
                                    _cV(_component_checkbox_group, _uM("onChange" to fun(){
                                        checkboxChange(index)
                                    }
                                    ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_checkbox, _uM("checked" to item.checkboxChecked), null, 8, _uA(
                                                "checked"
                                            ))
                                        )
                                    }
                                    ), "_" to 2), 1032, _uA(
                                        "onChange"
                                    ))
                                ), 4),
                                _cE("view", _uM("style" to _nS(_uM("margin-top" to "10px"))), _uA(
                                    _cV(_component_switch, _uM("checked" to item.switchChecked, "onChange" to fun(){
                                        switchChange(index)
                                    }
                                    ), null, 8, _uA(
                                        "checked",
                                        "onChange"
                                    ))
                                ), 4),
                                _cE("view", _uM("style" to _nS(_uM("margin-top" to "10px"))), _uA(
                                    _cE("input", _uM("modelValue" to item.inputValue, "onInput" to fun(`$event`: UniInputEvent){
                                        item.inputValue = `$event`.detail.value
                                    }
                                    , "placeholder" to "Input something...", "style" to _nS(_uM("border" to "1px solid #ccc"))), null, 44, _uA(
                                        "modelValue",
                                        "onInput"
                                    ))
                                ), 4)
                            ), 4)
                        }
                        ), 128)
                    ), 36)
                ), 4)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
