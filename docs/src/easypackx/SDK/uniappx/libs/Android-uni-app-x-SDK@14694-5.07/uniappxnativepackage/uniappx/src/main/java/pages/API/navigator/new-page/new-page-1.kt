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
import io.dcloud.uniapp.extapi.navigateBack as uni_navigateBack
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
open class GenPagesAPINavigatorNewPageNewPage1 : BasePage {
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
    open var data: DataType__58
        get() {
            return unref(this.`$exposed`["data"]) as DataType__58
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var navigateToOnLoadWithType: (type: String) -> Unit
        get() {
            return unref(this.`$exposed`["navigateToOnLoadWithType"]) as (type: String) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "navigateToOnLoadWithType", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPINavigatorNewPageNewPage1, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPINavigatorNewPageNewPage1
            val _cache = __ins.renderCache
            val checked = ref(false)
            val data = reactive(DataType__58(data = ""))
            fun gen_getLifeCycleNum_fn(): Number {
                return state.lifeCycleNum
            }
            val getLifeCycleNum = ::gen_getLifeCycleNum_fn
            fun gen_navigateBackWithDelta2_fn() {
                uni_navigateBack(NavigateBackOptions(delta = 2, success = fun(_) {
                    console.log("回退上上层页面成功")
                }
                , fail = fun(error) {
                    console.warn("回退上上层页面失败: " + error.errMsg)
                }
                ))
            }
            val navigateBackWithDelta2 = ::gen_navigateBackWithDelta2_fn
            fun gen_navigateToOnLoadWithType_fn(type: String) {
                uni_navigateTo(NavigateToOptions(url = "/pages/API/navigator/new-page/onLoad?type=" + type))
            }
            val navigateToOnLoadWithType = ::gen_navigateToOnLoadWithType_fn
            onLoad(fun(options: OnLoadOptions){
                if (options["data"] != null) {
                    data.data = options["data"]!!
                }
            }
            )
            __expose(_uM("data" to data, "navigateToOnLoadWithType" to navigateToOnLoadWithType))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE(Fragment, null, _uA(
                    _cV(_component_page_head, _uM("title" to "new-page-1")),
                    _cE("share-element", _uM("share-key" to "test-share-element-key"), _uA(
                        _cE("image", _uM("style" to _nS(_uM("width" to "250px", "height" to "176px")), "src" to "/static/shuijiao.jpg", "mode" to "scaleToFill"), null, 4)
                    )),
                    _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                        _cE("text", null, "onLoad 接收到参数"),
                        _cE("text", null, "data: " + _tD(unref(data).data), 1),
                        _cE("button", _uM("onClick" to navigateBackWithDelta2, "class" to "uni-btn"), " 回退到上上层页面 ")
                    ))
                ), 64)
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
