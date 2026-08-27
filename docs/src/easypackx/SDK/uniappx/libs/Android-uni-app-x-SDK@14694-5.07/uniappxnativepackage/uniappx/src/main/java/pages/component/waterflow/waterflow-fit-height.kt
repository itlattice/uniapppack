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
import io.dcloud.uniapp.extapi.hideLoading as uni_hideLoading
import io.dcloud.uniapp.extapi.request as uni_request
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesComponentWaterflowWaterflowFitHeight : BasePage {
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
    open var changeShow: () -> Unit
        get() {
            return unref(this.`$exposed`["changeShow"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "changeShow", value)
        }
    open var verify: () -> Boolean
        get() {
            return unref(this.`$exposed`["verify"]) as () -> Boolean
        }
        set(value) {
            setRefValue(this.`$exposed`, "verify", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentWaterflowWaterflowFitHeight, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentWaterflowWaterflowFitHeight
            val _cache = __ins.renderCache
            val list = ref<UTSArray<UTSJSONObject>>(_uA<UTSJSONObject>())
            val isShow = ref<Boolean>(true)
            val itemClick = fun(title: String?){
                if (title != null) {
                    uni_showToast(ShowToastOptions(title = title, icon = "none"))
                }
            }
            fun gen_getList_fn() {
                uni_showLoading(ShowLoadingOptions(title = "loading..."))
                uni_request<UTSArray<UTSJSONObject>>(RequestOptions(url = "https://unidemo.dcloud.net.cn/api/news?column=title,author_name,cover,published_at", method = "GET", success = fun(res: RequestSuccess<UTSArray<UTSJSONObject>>){
                    if (res.statusCode == 200) {
                        val result = res.data
                        if (result != null) {
                            list.value.push(*result.toTypedArray())
                        }
                    }
                }
                , complete = fun(_){
                    uni_hideLoading(null)
                }
                ))
            }
            val getList = ::gen_getList_fn
            fun gen_changeShow_fn() {
                isShow.value = false
            }
            val changeShow = ::gen_changeShow_fn
            fun gen_verify_fn(): Boolean {
                return true
            }
            val verify = ::gen_verify_fn
            onLoad(fun(_: OnLoadOptions){
                getList()
            }
            )
            __expose(_uM("changeShow" to changeShow, "verify" to verify))
            return fun(): Any? {
                return _cE("view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    if (isTrue(unref(isShow))) {
                        _cE("waterflow", _uM("key" to 0, "style" to _nS(_uM("flex" to "1")), "cross-axis-gap" to "5", "main-axis-gap" to "5"), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(unref(list), fun(item, index, __index, _cached): Any {
                                return _cE("flow-item", _uM("key" to index, "onClick" to fun(){
                                    itemClick(item["author_name"] as String?)
                                }), _uA(
                                    _cE("view", _uM("class" to "item"), _uA(
                                        _cE("image", _uM("class" to "img", "fade-show" to true, "src" to item["cover"], "mode" to "widthFix"), null, 8, _uA(
                                            "src"
                                        )),
                                        _cE("text", _uM("class" to "name"), _tD(item["author_name"]), 1),
                                        _cE("text", _uM("class" to "title"), _tD(item["title"]), 1),
                                        _cE("text", _uM("class" to "time"), _tD(item["published_at"]), 1)
                                    ))
                                ), 8, _uA(
                                    "onClick"
                                ))
                            }), 128),
                            _cE("flow-item", _uM("slot" to "refresher", "id" to "refresher", "type" to "2"), _uA(
                                _cE("text", null, "自定义加载")
                            )),
                            _cE("flow-item", _uM("slot" to "load-more", "id" to "loadmore", "type" to "6", "class" to "load-more-box"), _uA(
                                _cE("text", null, "加载更多")
                            ))
                        ), 4)
                    } else {
                        _cC("v-if", true)
                    }
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
                return _uM("item" to _pS(_uM("width" to "100%", "borderTopLeftRadius" to 8, "borderTopRightRadius" to 8, "borderBottomRightRadius" to 8, "borderBottomLeftRadius" to 8, "backgroundColor" to "#FFFFFF")), "img" to _pS(_uM("width" to "100%", "borderTopLeftRadius" to 5, "borderTopRightRadius" to 5, "borderBottomRightRadius" to 5, "borderBottomLeftRadius" to 5)), "name" to _pS(_uM("fontSize" to 18, "fontWeight" to "bold", "marginTop" to 10, "marginRight" to 10, "marginBottom" to 10, "marginLeft" to 10)), "title" to _pS(_uM("fontSize" to 14, "marginTop" to 0, "marginRight" to 10, "marginBottom" to 0, "marginLeft" to 10, "color" to "#808080")), "time" to _pS(_uM("fontSize" to 14, "color" to "#808080", "marginTop" to 10, "marginRight" to 10, "marginBottom" to 10, "marginLeft" to 10)), "load-more-box" to _pS(_uM("justifyContent" to "center", "alignItems" to "center", "flexDirection" to "row", "height" to 45, "width" to "100%", "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
