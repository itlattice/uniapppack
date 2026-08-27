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
open class GenPagesComponentUnicloudDbUnicloudDbContactsDetail : BasePage {
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
        var setup: (__props: GenPagesComponentUnicloudDbUnicloudDbContactsDetail) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentUnicloudDbUnicloudDbContactsDetail
            val _cache = __ins.renderCache
            val collection = ref("")
            val where = ref("")
            val whereID = ref("")
            val udbRef = ref<UniCloudDBElement?>(null)
            fun gen_displayGender_fn(value: Number?): String {
                val str = value ?: -1
                return (GenderList as UTSArray<GenderType>).find(fun(item: GenderType): Boolean {
                    return item.value == str
                }
                )!!.text
            }
            val displayGender = ::gen_displayGender_fn
            fun gen_onDataChange_fn(event: String) {
                if (udbRef.value != null) {
                    udbRef.value!!.loadData()
                }
            }
            val onDataChange = ::gen_onDataChange_fn
            fun gen_gotoUpdatePage_fn(id: String?) {
                uni__on(UNICLOUD_DB_CONTACTS_UPDATE, onDataChange)
                uni_navigateTo(NavigateToOptions(url = "./edit?id=" + id))
            }
            val gotoUpdatePage = ::gen_gotoUpdatePage_fn
            onLoad(fun(options){
                collection.value = COLLECTION_NAME
                whereID.value = options["id"] as String
                where.value = "_id=='" + whereID.value + "'"
            }
            )
            onPageShow(fun(){
                uni__off(UNICLOUD_DB_CONTACTS_UPDATE, onDataChange)
            }
            )
            onUnload(fun(){
                uni__off(UNICLOUD_DB_CONTACTS_UPDATE, onDataChange)
            }
            )
            return fun(): Any? {
                val _component_unicloud_db = resolveEasyComponent("unicloud-db", GenNodeModulesDcloudioUniComponentsLibXUnicloudDbUnicloudDbClass)
                return _cE("scroll-view", _uM("class" to "page"), _uA(
                    _cV(_component_unicloud_db, _uM("ref_key" to "udbRef", "ref" to udbRef, "collection" to unref(collection), "where" to unref(where), "page-data" to "replace"), _uM("default" to withScopedSlotCtx(fun(slotProps: GenNodeModulesDcloudioUniComponentsLibXUnicloudDbUnicloudDbSlotDataDefault): UTSArray<Any> {
                        val data = slotProps.data
                        val loading = slotProps.loading
                        val error = slotProps.error
                        return _uA(
                            if (error != null) {
                                _cE("view", _uM("key" to 0, "class" to "error"), _tD(error.errMsg), 1)
                            } else {
                                _cC("v-if", true)
                            }
                            ,
                            if (isTrue(loading)) {
                                _cE("view", _uM("key" to 1, "class" to "loading"), "正在加载...")
                            } else {
                                _cC("v-if", true)
                            }
                            ,
                            if (data.length > 0) {
                                _cE("view", _uM("key" to 2), _uA(
                                    _cE("view", _uM("class" to "form-item"), _uA(
                                        _cE("text", _uM("class" to "form-item-label"), "姓名"),
                                        _cE("text", _uM("class" to "form-item-input"), _tD(data[0]["username"]), 1)
                                    )),
                                    _cE("view", _uM("class" to "form-item"), _uA(
                                        _cE("text", _uM("class" to "form-item-label"), "电话"),
                                        _cE("text", _uM("class" to "form-item-input"), _tD(data[0]["mobile"]), 1)
                                    )),
                                    _cE("view", _uM("class" to "form-item"), _uA(
                                        _cE("text", _uM("class" to "form-item-label"), "邮箱"),
                                        _cE("text", _uM("class" to "form-item-input"), _tD(data[0]["email"]), 1)
                                    )),
                                    _cE("view", _uM("class" to "form-item"), _uA(
                                        _cE("text", _uM("class" to "form-item-label"), "备注"),
                                        _cE("text", _uM("class" to "form-item-input"), _tD(data[0]["comment"]), 1)
                                    )),
                                    _cE("view", _uM("class" to "form-item"), _uA(
                                        _cE("text", _uM("class" to "form-item-label"), "性别"),
                                        _cE("text", _uM("class" to "form-item-input"), _tD(displayGender(data[0].getNumber("gender"))), 1)
                                    )),
                                    _cE("button", _uM("type" to "default", "onClick" to fun(){
                                        gotoUpdatePage(data[0].getString("_id"))
                                    }), "编辑", 8, _uA(
                                        "onClick"
                                    ))
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "collection",
                        "where"
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
                return _uM("page" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15)), "loading" to _pS(_uM("alignItems" to "center")), "form-item" to _pS(_uM("flexDirection" to "row", "marginBottom" to 15, "alignItems" to "center", "paddingTop" to 8, "paddingRight" to 0, "paddingBottom" to 8, "paddingLeft" to 0)), "form-item-label" to _pS(_uM("width" to 45, "marginRight" to 10)), "form-item-input" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "fontSize" to 14, "color" to "#666666")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
