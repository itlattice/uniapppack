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
open class GenPagesComponentListViewListViewWithType : BasePage {
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
        var setup: (__props: GenPagesComponentListViewListViewWithType) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentListViewListViewWithType
            val _cache = __ins.renderCache
            val list = ref(_uA<Item__4>())
            fun gen_generateList_fn() {
                val startIndex = list.value.length + 1
                run {
                    var i: Number = 0
                    while(i < 50){
                        val id = startIndex + i
                        list.value.push(Item__4(id = id, name = "Item " + id, stars = (id - 1) % 5 + 1, type = id % 2))
                        i++
                    }
                }
            }
            val generateList = ::gen_generateList_fn
            generateList()
            fun gen_onScrollToLower_fn() {
                generateList()
            }
            val onScrollToLower = ::gen_onScrollToLower_fn
            return fun(): Any? {
                return _cE("list-view", _uM("onScrolltolower" to onScrollToLower, "style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE(Fragment, null, RenderHelpers.renderList(unref(list), fun(item, __key, __index, _cached): Any {
                        return _cE("list-item", _uM("key" to item.id, "type" to item.type), _uA(
                            _cE("view", _uM("style" to _nS(_uM("padding" to "10px", "border-bottom" to "1px solid #eee"))), _uA(
                                _cE("text", _uM("style" to _nS(_uM("font-weight" to "bold"))), "name: " + _tD(item.name) + " type: " + _tD(item.type), 5),
                                if (item.type == 0) {
                                    _cE("view", _uM("key" to 0, "style" to _nS(_uM("flex-direction" to "row"))), _uA(
                                        _cE(Fragment, null, RenderHelpers.renderList(item.stars, fun(star, __key, __index, _cached): Any {
                                            return _cE("text", _uM("key" to star), "★")
                                        }), 128)
                                    ), 4)
                                } else {
                                    if (item.type == 1) {
                                        _cE("text", _uM("key" to 1), "Stars: " + _tD(item.stars), 1)
                                    } else {
                                        _cC("v-if", true)
                                    }
                                }
                            ), 4)
                        ), 8, _uA(
                            "type"
                        ))
                    }
                    ), 128)
                ), 36)
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
