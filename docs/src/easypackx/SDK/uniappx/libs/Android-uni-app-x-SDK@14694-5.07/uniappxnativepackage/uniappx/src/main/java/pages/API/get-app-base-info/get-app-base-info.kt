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
import io.dcloud.uniapp.extapi.getAppBaseInfo as uni_getAppBaseInfo
open class GenPagesAPIGetAppBaseInfoGetAppBaseInfo : BasePage {
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
        var setup: (__props: GenPagesAPIGetAppBaseInfoGetAppBaseInfo) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIGetAppBaseInfoGetAppBaseInfo
            val _cache = __ins.renderCache
            val title = ref("getAppBaseInfo")
            val data = reactive(DataType__82(items = _uA<Item__8>()))
            val getAppBaseInfo = fun(){
                val res = uni_getAppBaseInfo(null)
                val res_str = JSON.stringify(res)
                val res_obj = JSON.parseObject(res_str)
                val res_map = res_obj!!.toMap()
                var keys = _uA<String>()
                res_map.forEach(fun(_, key){
                    keys.push(key)
                }
                )
                data.items = _uA<Item__8>()
                keys.sort().forEach(fun(key){
                    val value = res[key]
                    if (value != null) {
                        val item = Item__8(label = key, value = "" + (if ((UTSAndroid.`typeof`(value) == "object")) {
                            JSON.stringify(value)
                        } else {
                            value
                        }
                        ))
                        data.items.push(item)
                    }
                }
                )
            }
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE(Fragment, null, _uA(
                    _cV(_component_page_head, _uM("title" to unref(title)), null, 8, _uA(
                        "title"
                    )),
                    _cE("view", _uM("class" to "uni-common-mt"), _uA(
                        _cE("view", _uM("class" to "uni-list"), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(unref(data).items, fun(item, index, __index, _cached): Any {
                                return _cE("view", _uM("class" to "uni-list-cell", "key" to index, "style" to _nS(_uM("align-items" to "center"))), _uA(
                                    _cE("view", _uM("class" to "uni-pd"), _uA(
                                        _cE("view", _uM("class" to "uni-label", "style" to _nS(_uM("width" to "180px"))), _tD(item.label), 5)
                                    )),
                                    _cE("view", _uM("class" to "uni-list-cell-db"), _uA(
                                        _cE("text", _uM("class" to "uni-list-cell-db-text"), _tD(if (item.value == "") {
                                            "未获取"
                                        } else {
                                            item.value
                                        }
                                        ), 1)
                                    ))
                                ), 4)
                            }
                            ), 128)
                        )),
                        _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                            _cE("view", _uM("class" to "uni-btn-v"), _uA(
                                _cE("button", _uM("type" to "primary", "onClick" to getAppBaseInfo), "获取App基础信息")
                            ))
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
                return _uM("uni-pd" to _pS(_uM("paddingLeft" to 15)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
