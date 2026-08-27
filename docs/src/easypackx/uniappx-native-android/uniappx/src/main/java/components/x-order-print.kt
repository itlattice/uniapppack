@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNI2971F61
import android.content.Context
import io.dcloud.uniapp.*
import io.dcloud.uniapp.extapi.*
import io.dcloud.uniapp.framework.*
import io.dcloud.uniapp.runtime.*
import io.dcloud.uniapp.vue.*
import io.dcloud.uniapp.vue.shared.*
import io.dcloud.uts.*
import io.dcloud.uts.Map
import io.dcloud.uts.Set
import io.dcloud.uts.UTSAndroid
import kotlin.properties.Delegates
import uts.sdk.modules.iboxsChooseMedia.MediaScanner
open class GenComponentsXOrderPrint : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var printUrl: String by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    open var open: () -> UTSPromise<Unit>
        get() {
            return unref(this.`$exposed`["open"]) as () -> UTSPromise<Unit>
        }
        set(value) {
            setRefValue(this.`$exposed`, "open", value)
        }
    open var closePopup: () -> Unit
        get() {
            return unref(this.`$exposed`["closePopup"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "closePopup", value)
        }
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXOrderPrint, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXOrderPrint
            val _cache = __ins.renderCache
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val loading = ref<UniElement?>(null)
            val visible = ref(false)
            val prints = ref(_uA<bottomMenu>())
            val open = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        prints.value = _uA<bottomMenu>()
                        common.loading(loading.value)
                        var res = await(request.callapi("data/getprinter", _uO("type" to "file")))
                        common.hideLoading(loading.value)
                        if (res.code < 0) {
                            common.toast(res.msg)
                            return@w1
                        }
                        var list = res.data as UTSArray<UTSJSONObject>
                        for(item in resolveUTSValueIterator(list)){
                            prints.value.push(bottomMenu(name = item["name"] as String, key = item["id"].toString()))
                        }
                        visible.value = true
                })
            }
            val closePopup = fun(){
                visible.value = false
                emit("closePopup")
            }
            val clickMenu = fun(key: String){
                console.log("点击打印机", key)
                emit("menuClick", key)
            }
            __expose(_uM("open" to open, "closePopup" to closePopup))
            return fun(): Any? {
                val _component_fui_bottom_popup = resolveEasyComponent("fui-bottom-popup", GenUniModulesFirstuiUvueComponentsFuiBottomPopupFuiBottomPopupClass)
                val _component_x_loading = resolveEasyComponent("x-loading", GenComponentsXLoadingClass)
                return _cE("view", null, _uA(
                    _cV(_component_fui_bottom_popup, _uM("visible" to unref(visible), "onClose" to closePopup), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to "bottompopup padding-safe-bottom"), _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(unref(prints), fun(item, index, __index, _cached): Any {
                                    return _cE("text", _uM("class" to "buttom align-center", "key" to index, "onClick" to fun(){
                                        clickMenu(item.key)
                                    }
                                    ), _tD(item.name), 9, _uA(
                                        "onClick"
                                    ))
                                }
                                ), 128)
                            ))
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "visible"
                    )),
                    _cV(_component_x_loading, _uM("ref_key" to "loading", "ref" to loading), null, 512)
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
                return _uM("bottompopup" to _pS(_uM("width" to "100%")), "buttom" to _uM(".bottompopup " to _uM("marginLeft" to "20rpx", "marginRight" to "20rpx", "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#f5f5f5", "height" to 48, "lineHeight" to "47px", "fontSize" to 15, "color" to "#000000")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("closePopup" to null, "menuClick" to null)
        var props = _nP(_uM("printUrl" to _uM("type" to "String", "default" to "")))
        var propsNeedCastKeys = _uA(
            "printUrl"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
