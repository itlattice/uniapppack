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
import io.dcloud.uniapp.extapi.getLaunchOptionsSync as uni_getLaunchOptionsSync
open class GenPagesAPIGetLaunchOptionsSyncGetLaunchOptionsSync : BasePage {
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
    open var data: DataType__53
        get() {
            return unref(this.`$exposed`["data"]) as DataType__53
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var getLaunchOptionsSync: () -> Unit
        get() {
            return unref(this.`$exposed`["getLaunchOptionsSync"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "getLaunchOptionsSync", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIGetLaunchOptionsSyncGetLaunchOptionsSync, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIGetLaunchOptionsSyncGetLaunchOptionsSync
            val _cache = __ins.renderCache
            val data = reactive(DataType__53(checked = false, homePagePath = "pages/tabBar/component", launchOptionsPath = "", launchOptionsString = "", testResult = false))
            val compareOnLaunchRes = fun(){
                val launchOptions = uni_getLaunchOptionsSync()
                data.launchOptionsString = JSON.stringify(launchOptions, null, 2)
                val appLaunchOptions = state.globalData.launchOptions
                val isPathSame = launchOptions.path == appLaunchOptions.path
                val isAppSchemeSame = launchOptions.appScheme == appLaunchOptions.appScheme
                val isAppLinkSame = launchOptions.appLink == appLaunchOptions.appLink
                data.testResult = isPathSame && isAppSchemeSame && isAppLinkSame
            }
            val getLaunchOptionsSync = fun(){
                val launchOptions = uni_getLaunchOptionsSync()
                data.launchOptionsPath = launchOptions.path
                if (launchOptions.path == data.homePagePath) {
                    data.checked = true
                }
            }
            onReady(fun(){
                compareOnLaunchRes()
            }
            )
            __expose(_uM("data" to data, "getLaunchOptionsSync" to getLaunchOptionsSync))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE(Fragment, null, _uA(
                    _cV(_component_page_head, _uM("title" to "getLaunchOptionsSync")),
                    _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                        _cE("button", _uM("onClick" to getLaunchOptionsSync), "getLaunchOptionsSync"),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", null, "应用本次启动路径："),
                            _cE("text", _uM("style" to _nS(_uM("margin-top" to "5px"))), _tD(unref(data).launchOptionsPath), 5)
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", null, "应用本次启动："),
                            _cE("text", _uM("style" to _nS(_uM("margin-top" to "5px"))), _tD(unref(data).launchOptionsString), 5)
                        ))
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
