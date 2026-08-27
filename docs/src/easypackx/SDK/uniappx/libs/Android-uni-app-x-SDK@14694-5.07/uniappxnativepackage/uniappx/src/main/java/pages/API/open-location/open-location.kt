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
import uts.sdk.modules.uniOpenLocation.OpenLocationOptions as OpenLocationOptions__1
import uts.sdk.modules.uniOpenLocation.openLocation as uni_openLocation
open class GenPagesAPIOpenLocationOpenLocation : BasePage {
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
    open var data: DataType__68
        get() {
            return unref(this.`$exposed`["data"]) as DataType__68
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var openLocation: () -> Unit
        get() {
            return unref(this.`$exposed`["openLocation"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "openLocation", value)
        }
    open var pageSetLifeCycleNum: (value: Number) -> Unit
        get() {
            return unref(this.`$exposed`["pageSetLifeCycleNum"]) as (value: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "pageSetLifeCycleNum", value)
        }
    open var getLifeCycleNum: () -> Number
        get() {
            return unref(this.`$exposed`["getLifeCycleNum"]) as () -> Number
        }
        set(value) {
            setRefValue(this.`$exposed`, "getLifeCycleNum", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIOpenLocationOpenLocation, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIOpenLocationOpenLocation
            val _cache = __ins.renderCache
            val title = ref("openLocation")
            val longitude = ref(116.39747)
            val latitude = ref(39.9085)
            val name = ref("天安门")
            val address = ref("北京市东城区东长安街")
            val data = reactive(DataType__68(dialogPagesNum = -1))
            onPageShow(fun(){
                console.log("Page Show")
                setLifeCycleNum(state.lifeCycleNum + 1)
            }
            )
            onPageHide(fun(){
                console.log("Page Hide")
                setLifeCycleNum(state.lifeCycleNum - 1)
            }
            )
            val test = fun(){
                val pages = getCurrentPages()
                val page = pages[pages.length - 1]
                val dialogPages = page.getDialogPages()
                data.dialogPagesNum = dialogPages.length
            }
            val openLocation = fun(){
                uni_openLocation(OpenLocationOptions__1(longitude = longitude.value, latitude = latitude.value, name = name.value, address = address.value))
                setTimeout(fun(){
                    test()
                }
                , 500)
            }
            val pageSetLifeCycleNum = fun(value: Number){
                setLifeCycleNum(value)
            }
            val getLifeCycleNum = fun(): Number {
                return state.lifeCycleNum
            }
            __expose(_uM("data" to data, "openLocation" to openLocation, "pageSetLifeCycleNum" to pageSetLifeCycleNum, "getLifeCycleNum" to getLifeCycleNum))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                val _component_form = resolveComponent("form")
                return _cE("view", null, _uA(
                    _cV(_component_page_head, _uM("title" to unref(title)), null, 8, _uA(
                        "title"
                    )),
                    _cE("view", _uM("class" to "uni-common-mt"), _uA(
                        _cV(_component_form, _uM("onSubmit" to openLocation), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("view", _uM("class" to "uni-list"), _uA(
                                    _cE("view", _uM("class" to "uni-list-cell"), _uA(
                                        _cE("view", _uM("class" to "uni-list-cell-left"), _uA(
                                            _cE("view", _uM("class" to "uni-label"), "经度")
                                        )),
                                        _cE("view", _uM("class" to "uni-list-cell-db"), _uA(
                                            _cE("input", _uM("modelValue" to handleModelValueForModifierNumber(unref(longitude)), "onInput" to fun(`$event`: UniInputEvent){
                                                trySetRefValue(longitude, looseToNumber(`$event`.detail.value))
                                            }
                                            , "class" to "uni-input", "type" to "text", "disabled" to true), null, 40, _uA(
                                                "modelValue"
                                            ))
                                        ))
                                    )),
                                    _cE("view", _uM("class" to "uni-list-cell"), _uA(
                                        _cE("view", _uM("class" to "uni-list-cell-left"), _uA(
                                            _cE("view", _uM("class" to "uni-label"), "纬度")
                                        )),
                                        _cE("view", _uM("class" to "uni-list-cell-db"), _uA(
                                            _cE("input", _uM("modelValue" to handleModelValueForModifierNumber(unref(latitude)), "onInput" to fun(`$event`: UniInputEvent){
                                                trySetRefValue(latitude, looseToNumber(`$event`.detail.value))
                                            }
                                            , "class" to "uni-input", "type" to "text", "disabled" to true), null, 40, _uA(
                                                "modelValue"
                                            ))
                                        ))
                                    )),
                                    _cE("view", _uM("class" to "uni-list-cell"), _uA(
                                        _cE("view", _uM("class" to "uni-list-cell-left"), _uA(
                                            _cE("view", _uM("class" to "uni-label"), "位置名称")
                                        )),
                                        _cE("view", _uM("class" to "uni-list-cell-db"), _uA(
                                            _cE("input", _uM("modelValue" to unref(name), "onInput" to fun(`$event`: UniInputEvent){
                                                trySetRefValue(name, `$event`.detail.value)
                                            }
                                            , "class" to "uni-input", "type" to "text", "disabled" to true), null, 40, _uA(
                                                "modelValue"
                                            ))
                                        ))
                                    )),
                                    _cE("view", _uM("class" to "uni-list-cell"), _uA(
                                        _cE("view", _uM("class" to "uni-list-cell-left"), _uA(
                                            _cE("view", _uM("class" to "uni-label"), "详细位置")
                                        )),
                                        _cE("view", _uM("class" to "uni-list-cell-db"), _uA(
                                            _cE("input", _uM("modelValue" to unref(address), "onInput" to fun(`$event`: UniInputEvent){
                                                trySetRefValue(address, `$event`.detail.value)
                                            }
                                            , "class" to "uni-input", "type" to "text", "disabled" to true), null, 40, _uA(
                                                "modelValue"
                                            ))
                                        ))
                                    ))
                                )),
                                _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                                    _cE("view", _uM("class" to "tips"), "注意：需要正确配置地图服务商的Key才能正常显示位置"),
                                    _cE("view", _uM("class" to "uni-btn-v uni-common-mt"), _uA(
                                        _cE("button", _uM("type" to "primary", "formType" to "submit"), "查看位置")
                                    ))
                                ))
                            )
                        }
                        ), "_" to 1))
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
                return _uM("uni-list-cell-left" to _pS(_uM("paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 15)), "tips" to _pS(_uM("fontSize" to 12, "marginTop" to 15, "opacity" to 0.8)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
