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
open class GenPagesComponentListViewListViewChildrenInSlot : BasePage {
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
        var setup: (__props: GenPagesComponentListViewListViewChildrenInSlot) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentListViewListViewChildrenInSlot
            val _cache = __ins.renderCache
            val list = ref(_uA(
                0,
                1,
                2
            ))
            fun gen_addItem_fn() {
                var listNum = list.value.length as Int
                list.value.push(listNum)
            }
            val addItem = ::gen_addItem_fn
            fun gen_emptyList_fn() {
                list.value = _uA()
            }
            val emptyList = ::gen_emptyList_fn
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1", "padding-bottom" to "20px"))), _uA(
                    _cE("view", null, _uA(
                        _cV(_component_page_head, _uM("title" to "getApp")),
                        _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                            _cV(unref(GenPagesComponentListViewListViewWrapperClass), null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(unref(list), fun(item, __key, __index, _cached): Any {
                                        return _cE("list-item", _uM("key" to item), _uA(
                                            _cE("text", _uM("class" to "text-in-list-item"), _tD(item), 1)
                                        ))
                                    }
                                    ), 128)
                                )
                            }
                            ), "second" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(unref(list), fun(item, __key, __index, _cached): Any {
                                        return _cE("list-item", _uM("key" to item), _uA(
                                            _cE("text", _uM("class" to "text-in-list-item"), _tD(item), 1)
                                        ))
                                    }
                                    ), 128)
                                )
                            }
                            ), "_" to 1)),
                            _cE("button", _uM("id" to "add-btn", "class" to "uni-common-mt", "onClick" to addItem), "add item"),
                            _cE("button", _uM("id" to "empty-btn", "class" to "uni-common-mt", "onClick" to emptyList), "empty list")
                        ))
                    ))
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
