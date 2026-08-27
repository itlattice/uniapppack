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
import io.dcloud.uniapp.extapi.getClipboardData as uni_getClipboardData
import io.dcloud.uniapp.extapi.setClipboardData as uni_setClipboardData
import io.dcloud.uniapp.extapi.showModal as uni_showModal
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesAPIClipboardClipboard : BasePage {
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
    open var data: DataType__99
        get() {
            return unref(this.`$exposed`["data"]) as DataType__99
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var getClipboard: () -> Unit
        get() {
            return unref(this.`$exposed`["getClipboard"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "getClipboard", value)
        }
    open var setClipboard: () -> Unit
        get() {
            return unref(this.`$exposed`["setClipboard"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setClipboard", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIClipboardClipboard, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIClipboardClipboard
            val _cache = __ins.renderCache
            val title = ref("get/setClipboardData")
            val data = reactive(DataType__99(data = "", getDataTest = "", setClipboardTest = false))
            onUnload(fun(){
                uni_setClipboardData(SetClipboardDataOptions(data = ""))
            }
            )
            val dataChange = fun(e: UniInputEvent){
                data.data = e.detail.value
            }
            val getClipboard = fun(){
                uni_getClipboardData(GetClipboardDataOptions(success = fun(res){
                    console.log(res.data)
                    data.getDataTest = res.data
                    val content = if (res.data != "") {
                        "剪贴板内容为:" + res.data
                    } else {
                        "剪贴板暂无内容"
                    }
                    uni_showModal(ShowModalOptions(content = content, title = "读取剪贴板", showCancel = false))
                }
                , fail = fun(err){
                    uni_showModal(ShowModalOptions(content = "读取剪贴板失败: " + err.errMsg, showCancel = false))
                }
                ))
            }
            val setClipboard = fun(){
                if (data.data.length == 0) {
                    uni_showModal(ShowModalOptions(title = "设置剪贴板失败", content = "内容不能为空", showCancel = false))
                } else {
                    uni_setClipboardData(SetClipboardDataOptions(data = data.data, success = fun(_){
                        data.setClipboardTest = true
                        uni_showToast(ShowToastOptions(title = "设置剪贴板成功", icon = "success"))
                    }
                    , fail = fun(_){
                        data.setClipboardTest = false
                        uni_showToast(ShowToastOptions(title = "储存数据失败!", icon = "none"))
                    }
                    ))
                }
            }
            __expose(_uM("data" to data, "getClipboard" to getClipboard, "setClipboard" to setClipboard))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE("view", null, _uA(
                    _cV(_component_page_head, _uM("title" to unref(title)), null, 8, _uA(
                        "title"
                    )),
                    _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                        _cE("view", _uM("class" to "uni-title"), "请输入剪贴板内容"),
                        _cE("view", _uM("class" to "uni-list"), _uA(
                            _cE("view", _uM("class" to "uni-list-cell"), _uA(
                                _cE("input", _uM("class" to "uni-input", "type" to "text", "placeholder" to "请输入剪贴板内容", "value" to unref(data).data, "onInput" to dataChange), null, 40, _uA(
                                    "value"
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-btn-v"), _uA(
                            _cE("button", _uM("type" to "primary", "onClick" to setClipboard), "存储数据"),
                            _cE("button", _uM("onClick" to getClipboard), "读取数据")
                        ))
                    ))
                ))
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
