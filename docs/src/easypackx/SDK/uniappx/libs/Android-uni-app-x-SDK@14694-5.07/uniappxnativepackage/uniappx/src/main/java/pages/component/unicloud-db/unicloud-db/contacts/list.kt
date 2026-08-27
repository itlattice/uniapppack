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
import io.dcloud.uniapp.extapi.`$off` as uni__off
import io.dcloud.uniapp.extapi.`$on` as uni__on
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
import io.dcloud.uniapp.extapi.stopPullDownRefresh as uni_stopPullDownRefresh
open class GenPagesComponentUnicloudDbUnicloudDbContactsList : BasePage {
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
        var setup: (__props: GenPagesComponentUnicloudDbUnicloudDbContactsList) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentUnicloudDbUnicloudDbContactsList
            val _cache = __ins.renderCache
            val collection = ref(COLLECTION_NAME)
            val udbRef = ref<UniCloudDBElement?>(null)
            fun gen_loadMore_fn() {
                if (udbRef.value != null) {
                    udbRef.value!!.loadMore()
                }
            }
            val loadMore = ::gen_loadMore_fn
            fun gen_onDataChange_fn(event: String) {
                if (udbRef.value != null) {
                    udbRef.value!!.loadData(_uO("clear" to true))
                }
            }
            val onDataChange = ::gen_onDataChange_fn
            fun gen_gotoAddPage_fn() {
                uni__on(UNICLOUD_DB_CONTACTS_ADD, onDataChange)
                uni_navigateTo(NavigateToOptions(url = "./add"))
            }
            val gotoAddPage = ::gen_gotoAddPage_fn
            fun gen_gotoDetailPage_fn(id: String) {
                uni__on(UNICLOUD_DB_CONTACTS_UPDATE, onDataChange)
                uni_navigateTo(NavigateToOptions(url = "./detail?id=" + id))
            }
            val gotoDetailPage = ::gen_gotoDetailPage_fn
            onReady(fun(){
                uni__on(UNICLOUD_DB_CONTACTS_DELETE, onDataChange)
                if (udbRef.value != null) {
                    udbRef.value!!.loadData()
                }
            }
            )
            onUnload(fun(){
                uni__off(UNICLOUD_DB_CONTACTS_ADD, onDataChange)
                uni__off(UNICLOUD_DB_CONTACTS_UPDATE, onDataChange)
                uni__off(UNICLOUD_DB_CONTACTS_DELETE, onDataChange)
            }
            )
            onPageShow(fun(){
                uni__off(UNICLOUD_DB_CONTACTS_ADD, onDataChange)
                uni__off(UNICLOUD_DB_CONTACTS_UPDATE, onDataChange)
            }
            )
            onPullDownRefresh(fun(){
                if (udbRef.value != null) {
                    udbRef.value!!.loadData(_uO("clear" to true, "success" to fun(_: UniCloudDBGetResult){
                        uni_stopPullDownRefresh()
                    }
                    ))
                }
            }
            )
            return fun(): Any? {
                val _component_loading = resolveComponent("loading")
                val _component_unicloud_db = resolveEasyComponent("unicloud-db", GenNodeModulesDcloudioUniComponentsLibXUnicloudDbUnicloudDbClass)
                return _cE("view", _uM("class" to "page"), _uA(
                    _cV(_component_unicloud_db, _uM("ref_key" to "udbRef", "ref" to udbRef, "class" to "udb", "collection" to unref(collection), "page-size" to 15, "getcount" to true, "loadtime" to "manual"), _uM("default" to withScopedSlotCtx(fun(slotProps: GenNodeModulesDcloudioUniComponentsLibXUnicloudDbUnicloudDbSlotDataDefault): UTSArray<Any> {
                        val data = slotProps.data
                        val pagination = slotProps.pagination
                        val loading = slotProps.loading
                        val hasMore = slotProps.hasMore
                        val error = slotProps.error
                        return _uA(
                            if (error != null) {
                                _cE("view", _uM("key" to 0, "class" to "error"), _tD(error.errMsg), 1)
                            } else {
                                _cC("v-if", true)
                            }
                            ,
                            _cE("scroll-view", _uM("ref" to "listView", "class" to "list-view", "onScrolltolower" to fun(){
                                loadMore()
                            }
                            ), _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(data, fun(item, _, __index, _cached): Any {
                                    return _cE("view", _uM("class" to "list-item", "onClick" to fun(){
                                        gotoDetailPage(item["_id"] as String)
                                    }
                                    ), _uA(
                                        _cE("view", _uM("class" to "list-item-fill"), _uA(
                                            _cE("text", _uM("class" to "name"), _tD(item["username"]), 1),
                                            _cE("text", _uM("class" to "mobile"), _tD(item["mobile"]), 1)
                                        ))
                                    ), 8, _uA(
                                        "onClick"
                                    ))
                                }
                                ), 256)
                            ), 40, _uA(
                                "onScrolltolower"
                            )),
                            if (isTrue(loading)) {
                                _cV(_component_loading, _uM("key" to 1, "style" to _nS(_uM("color" to "#999", "margin" to "20px", "align-self" to "center"))), null, 8, _uA(
                                    "style"
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                            ,
                            if (data.length > 0) {
                                _cE("view", _uM("key" to 2, "class" to "pagination"), _uA(
                                    _cE("text", _uM("class" to "pagination-item"), _tD(data.length) + " / " + _tD(pagination.count), 1)
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "collection"
                    )),
                    _cE("view", _uM("class" to "btn-plus", "onClick" to gotoAddPage), _uA(
                        _cE("text", _uM("class" to "btn-plus-text"), "+")
                    ))
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
                return _uM("page" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "flexDirection" to "column")), "loading" to _pS(_uM("marginTop" to 20, "marginRight" to 20, "marginBottom" to 20, "marginLeft" to 20, "alignSelf" to "center")), "udb" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "flexDirection" to "column")), "list-view" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "flexDirection" to "column")), "list-item" to _pS(_uM("flexDirection" to "row", "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "backgroundColor" to "#ffffff", "marginBottom" to 1)), "mobile" to _pS(_uM("marginTop" to 5)), "btn-plus" to _pS(_uM("position" to "absolute", "width" to 64, "height" to 64, "right" to 20, "bottom" to 20, "alignItems" to "center", "justifyContent" to "center", "backgroundColor" to "#1e90ff", "borderTopLeftRadius" to 64, "borderTopRightRadius" to 64, "borderBottomRightRadius" to 64, "borderBottomLeftRadius" to 64)), "btn-plus-text" to _pS(_uM("fontSize" to 30, "color" to "#ffffff")), "pagination" to _pS(_uM("alignItems" to "center", "backgroundColor" to "#f8f8f8", "paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
