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
open class GenPagesComponentListViewListViewChildrenIfShow : BasePage {
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
        var setup: (__props: GenPagesComponentListViewListViewChildrenIfShow) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentListViewListViewChildrenIfShow
            val _cache = __ins.renderCache
            val list = ref(_uA<List>())
            val expandIds = ref(_uA<String>())
            fun gen_init_fn() {
                list.value = _uA<List>(List(id = "1", children = _uA(
                    Child(id = "1-1"),
                    Child(id = "1-2"),
                    Child(id = "1-3")
                )), List(id = "2", children = _uA(
                    Child(id = "2-1"),
                    Child(id = "2-2"),
                    Child(id = "2-3")
                )), List(id = "3", children = _uA(
                    Child(id = "3-1"),
                    Child(id = "3-2"),
                    Child(id = "3-3")
                )))
                expandIds.value = _uA(
                    list.value[0].id
                )
            }
            val init = ::gen_init_fn
            fun gen_clear_fn() {
                list.value = _uA<List>()
                expandIds.value = _uA<String>()
            }
            val clear = ::gen_clear_fn
            fun gen_toggleChildrenShow_fn(id: String) {
                val index = expandIds.value.findIndex(fun(item): Boolean {
                    return item == id
                }
                )
                if (index == -1) {
                    expandIds.value.push(id)
                } else {
                    expandIds.value.splice(index, 1)
                }
            }
            val toggleChildrenShow = ::gen_toggleChildrenShow_fn
            onLoad(fun(_options){
                init()
            }
            )
            return fun(): Any? {
                return _cE("view", _uM("class" to "p-10"), _uA(
                    _cE("button", _uM("id" to "init-btn", "class" to "uni-btn", "onClick" to init), "init"),
                    _cE("button", _uM("id" to "clear-btn", "class" to "uni-btn", "onClick" to clear), "clear"),
                    _cE("view", _uM("class" to _nC(_uA(
                        "uni-common-mt list-view-container",
                        _uM(" p-10" to (unref(list).length > 0))
                    ))), _uA(
                        _cE("list-view", null, _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(unref(list), fun(item, index, __index, _cached): Any {
                                return _cE(Fragment, _uM("key" to item.id), _uA(
                                    _cE("list-item", _uM("id" to "toggle-children-show-btn", "class" to _nC(_uM("uni-common-mt" to (index > 0))), "onClick" to fun(){
                                        toggleChildrenShow(item.id)
                                    }
                                    ), _uA(
                                        _cE("text", null, "toggle children isShow")
                                    ), 10, _uA(
                                        "onClick"
                                    )),
                                    if (isTrue(unref(expandIds).includes(item.id))) {
                                        _cE(Fragment, _uM("key" to 0), RenderHelpers.renderList(item.children, fun(child, __key, __index, _cached): Any {
                                            return _cE("list-item", _uM("key" to child.id, "id" to "list-item-child", "class" to "mt-5"), _uA(
                                                _cE("text", null, _tD(child.id), 1)
                                            ))
                                        }), 128)
                                    } else {
                                        _cC("v-if", true)
                                    }
                                ), 64)
                            }
                            ), 128)
                        ))
                    ), 2)
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
                return _uM("p-10" to _pS(_uM("paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10)), "list-view-container" to _pS(_uM("backgroundColor" to "#ffffff")), "mt-5" to _pS(_uM("marginTop" to 5)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
