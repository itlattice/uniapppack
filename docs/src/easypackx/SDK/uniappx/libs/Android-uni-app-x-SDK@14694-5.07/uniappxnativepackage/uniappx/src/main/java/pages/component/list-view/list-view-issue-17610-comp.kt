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
open class GenPagesComponentListViewListViewIssue17610Comp : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentListViewListViewIssue17610Comp) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentListViewListViewIssue17610Comp
            val _cache = __ins.renderCache
            val list = ref(_uA<Item__5>(Item__5(id = "id-1", name = "Item 1", childNum = 10), Item__5(id = "id-2", name = "Item 2", childNum = 10), Item__5(id = "id-3", name = "Item 3", childNum = 10), Item__5(id = "id-4", name = "Item 4", childNum = 10), Item__5(id = "id-5", name = "Item 5", childNum = 10)))
            val currentId = ref("1")
            val handleTabClick = fun(index: Number){
                currentId.value = list.value[index].id
            }
            return fun(): Any? {
                return _cE(Fragment, null, _uA(
                    _cE("sticky-header", null, _uA(
                        _cE("scroll-view", _uM("class" to "flex-row"), _uA(
                            _cE("view", _uM("class" to "tab-container w-100 flex-row items-center justify-around"), _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(unref(list), fun(item, index, __index, _cached): Any {
                                    return _cE("text", _uM("key" to item.id, "onClick" to fun(){
                                        handleTabClick(index)
                                    }
                                    , "class" to _nC(_uA(
                                        "tab-text",
                                        _uM("active" to (item.id == unref(currentId)))
                                    )), "id" to ("" + item.id + "-tab")), _tD(item.name), 11, _uA(
                                        "onClick",
                                        "id"
                                    ))
                                }
                                ), 128)
                            ))
                        ))
                    )),
                    _cE("list-item", null, _uA(
                        _cE("swiper", _uM("class" to "swiper", "current-item-id" to unref(currentId)), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(unref(list), fun(item, __key, __index, _cached): Any {
                                return _cE("swiper-item", _uM("item-id" to item.id), _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(item.childNum, fun(itemChild, __key, __index, _cached): Any {
                                        return _cE("view", _uM("class" to "item", "key" to itemChild, "id" to ("" + item.id + "-item")), _uA(
                                            _cE("text", null, _tD(item.id) + "-" + _tD(itemChild), 1)
                                        ), 8, _uA(
                                            "id"
                                        ))
                                    }
                                    ), 128)
                                ), 8, _uA(
                                    "item-id"
                                ))
                            }
                            ), 256)
                        ), 8, _uA(
                            "current-item-id"
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
                return _uM("flex-row" to _pS(_uM("flexDirection" to "row")), "w-100" to _pS(_uM("width" to "100%")), "flex-1" to _pS(_uM("height" to "100%")), "justify-around" to _pS(_uM("justifyContent" to "space-around")), "items-center" to _pS(_uM("alignItems" to "center")), "tab-container" to _pS(_uM("height" to 40, "backgroundColor" to "#FAEBD7")), "tab-text" to _pS(_uM("color" to "#cccccc")), "swiper" to _pS(_uM("height" to 500)), "item" to _pS(_uM("marginTop" to 20, "alignItems" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
