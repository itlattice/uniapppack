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
import io.dcloud.uniapp.extapi.`$emit` as uni__emit
import io.dcloud.uniapp.extapi.navigateBack as uni_navigateBack
import io.dcloud.uniapp.extapi.showModal as uni_showModal
open class GenPagesComponentUnicloudDbUnicloudDbContactsEdit : BasePage {
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
        var setup: (__props: GenPagesComponentUnicloudDbUnicloudDbContactsEdit) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentUnicloudDbUnicloudDbContactsEdit
            val _cache = __ins.renderCache
            val collection = ref("")
            val where = ref("")
            val genderList = ref(GenderList as UTSArray<GenderType>)
            val whereID = ref("")
            val udbRef = ref<UniCloudDBElement?>(null)
            fun gen_onFormSubmit_fn(e: UniFormSubmitEvent) {
                val formData = e.detail.value
                val genderString = formData["gender"] as String
                formData["gender"] = if ((genderString.length > 0)) {
                    parseInt(genderString)
                } else {
                    -1
                }
                if (udbRef.value != null) {
                    udbRef.value!!.update(whereID.value, formData, _uO("showToast" to false, "needLoading" to true, "needConfirm" to false, "loadingTitle" to "正在保存...", "success" to fun(_: UniCloudDBUpdateResult){
                        uni__emit(UNICLOUD_DB_CONTACTS_UPDATE, whereID.value)
                        setTimeout(fun(){
                            uni_navigateBack(null)
                        }
                        , 500)
                    }
                    , "fail" to fun(err: Any?){
                        val error = err as UniCloudError
                        uni_showModal(ShowModalOptions(content = error.errMsg, showCancel = false))
                    }
                    ))
                }
            }
            val onFormSubmit = ::gen_onFormSubmit_fn
            fun gen_remove_fn(id: String?, name: String?) {
                if (udbRef.value != null) {
                    udbRef.value!!.remove(id!!, _uO("needConfirm" to true, "needLoading" to true, "loadingTitle" to "正在删除...", "confirmTitle" to "确定删除?", "confirmContent" to name, "success" to fun(_: UniCloudDBRemoveResult){
                        uni__emit(UNICLOUD_DB_CONTACTS_DELETE, whereID.value)
                        setTimeout(fun(){
                            uni_navigateBack(NavigateBackOptions(delta = 2))
                        }
                        , 500)
                    }
                    , "fail" to fun(err: Any?){
                        val error = err as UniCloudError
                        uni_showModal(ShowModalOptions(content = error.errMsg, showCancel = false))
                    }
                    ))
                }
            }
            val remove = ::gen_remove_fn
            onLoad(fun(options){
                collection.value = COLLECTION_NAME
                whereID.value = options["id"] as String
                where.value = "_id=='" + whereID.value + "'"
            }
            )
            return fun(): Any? {
                val _component_radio = resolveComponent("radio")
                val _component_radio_group = resolveComponent("radio-group")
                val _component_form = resolveComponent("form")
                val _component_unicloud_db = resolveEasyComponent("unicloud-db", GenNodeModulesDcloudioUniComponentsLibXUnicloudDbUnicloudDbClass)
                return _cE("scroll-view", _uM("class" to "scroll-view"), _uA(
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
                                _cV(_component_form, _uM("key" to 2, "onSubmit" to onFormSubmit), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cE("view", _uM("class" to "form-item"), _uA(
                                            _cE("text", _uM("class" to "form-item-label"), "姓名"),
                                            _cE("input", _uM("class" to "form-item-input", "placeholder" to "姓名", "name" to "username", "value" to data[0].getString("username")), null, 8, _uA(
                                                "value"
                                            ))
                                        )),
                                        _cE("view", _uM("class" to "form-item"), _uA(
                                            _cE("text", _uM("class" to "form-item-label"), "电话"),
                                            _cE("input", _uM("class" to "form-item-input", "placeholder" to "电话", "name" to "mobile", "value" to data[0].getString("mobile")), null, 8, _uA(
                                                "value"
                                            ))
                                        )),
                                        _cE("view", _uM("class" to "form-item"), _uA(
                                            _cE("text", _uM("class" to "form-item-label"), "邮箱"),
                                            _cE("input", _uM("class" to "form-item-input", "placeholder" to "邮箱地址", "name" to "email", "value" to data[0].getString("email")), null, 8, _uA(
                                                "value"
                                            ))
                                        )),
                                        _cE("view", _uM("class" to "form-item"), _uA(
                                            _cE("text", _uM("class" to "form-item-label"), "备注"),
                                            _cE("textarea", _uM("class" to "form-item-input-comment", "placeholder" to "备注", "name" to "comment", "maxlength" to "-1", "value" to data[0].getString("comment")), null, 8, _uA(
                                                "value"
                                            ))
                                        )),
                                        _cE("view", _uM("class" to "form-item"), _uA(
                                            _cE("text", _uM("class" to "form-item-label"), "性别"),
                                            _cV(_component_radio_group, _uM("class" to "radio-list", "name" to "gender"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE(Fragment, null, RenderHelpers.renderList(unref(genderList), fun(item, _, __index, _cached): Any {
                                                        return _cE("view", _uM("class" to "radio-item", "key" to item.value), _uA(
                                                            _cV(_component_radio, _uM("value" to item.value, "checked" to (item.value == data[0].getNumber("gender"))), null, 8, _uA(
                                                                "value",
                                                                "checked"
                                                            )),
                                                            _cE("text", null, _tD(item.text), 1)
                                                        ))
                                                    }), 128)
                                                )
                                            }), "_" to 2), 1024)
                                        )),
                                        _cE("view", _uM("class" to "btn-group"), _uA(
                                            _cE("button", _uM("class" to "btn-submit", "type" to "primary", "form-type" to "submit"), "保存"),
                                            _cE("button", _uM("class" to "btn-delete", "type" to "warn", "onClick" to fun(){
                                                remove(data[0].getString("_id"), data[0].getString("username"))
                                            }), "删除联系人", 8, _uA(
                                                "onClick"
                                            ))
                                        ))
                                    )
                                }), "_" to 2), 1024)
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
                return _uM("page" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "scroll-view" to _pS(_uM("paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15, "flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "loading" to _pS(_uM("alignItems" to "center")), "form-item" to _pS(_uM("flexDirection" to "row", "marginBottom" to 15, "alignItems" to "center")), "form-item-label" to _pS(_uM("width" to 45, "marginRight" to 10)), "form-item-input" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "fontSize" to 14, "color" to "#666666", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#e5e5e5", "borderRightColor" to "#e5e5e5", "borderBottomColor" to "#e5e5e5", "borderLeftColor" to "#e5e5e5", "borderTopLeftRadius" to 5, "borderTopRightRadius" to 5, "borderBottomRightRadius" to 5, "borderBottomLeftRadius" to 5, "height" to 34, "paddingLeft" to 8, "paddingRight" to 8)), "form-item-input-comment" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "fontSize" to 14, "color" to "#666666", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#e5e5e5", "borderRightColor" to "#e5e5e5", "borderBottomColor" to "#e5e5e5", "borderLeftColor" to "#e5e5e5", "borderTopLeftRadius" to 5, "borderTopRightRadius" to 5, "borderBottomRightRadius" to 5, "borderBottomLeftRadius" to 5, "paddingTop" to 8, "paddingRight" to 8, "paddingBottom" to 8, "paddingLeft" to 8)), "radio-list" to _pS(_uM("flexDirection" to "row")), "radio-item" to _pS(_uM("flexDirection" to "row", "marginRight" to 30, "alignItems" to "center")), "btn-group" to _pS(_uM("marginTop" to 30)), "btn-delete" to _pS(_uM("marginTop" to 15)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
