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
import io.dcloud.uniapp.extapi.getSystemInfo as uni_getSystemInfo
import io.dcloud.uniapp.extapi.getSystemInfoSync as uni_getSystemInfoSync
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
open class GenPagesAPIGetSystemInfoGetSystemInfo : BasePage {
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
    open var data: DataType__80
        get() {
            return unref(this.`$exposed`["data"]) as DataType__80
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var jest_getSystemInfo: () -> GetSystemInfoResult
        get() {
            return unref(this.`$exposed`["jest_getSystemInfo"]) as () -> GetSystemInfoResult
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_getSystemInfo", value)
        }
    open var jest_getScreenHeight_at_different_stages: () -> Unit
        get() {
            return unref(this.`$exposed`["jest_getScreenHeight_at_different_stages"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_getScreenHeight_at_different_stages", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIGetSystemInfoGetSystemInfo, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIGetSystemInfoGetSystemInfo
            val _cache = __ins.renderCache
            var globalScreenHeight: Number = 0
            try {
                globalScreenHeight = uni_getWindowInfo().screenHeight
            }
             catch (e: Throwable) {
                console.error(e)
            }
            val data = reactive(DataType__80(title = "getSystemInfo", items = _uA<Item__6>(), screenHeightAtReady = 0, jest_result = false))
            onReady(fun(){
                data.screenHeightAtReady = uni_getSystemInfoSync().screenHeight
                console.log("全局获取屏幕高度: " + globalScreenHeight + "  onReady内获取屏幕高度: " + data.screenHeightAtReady)
            }
            )
            val getSystemInfo = fun(){
                uni_getSystemInfo(GetSystemInfoOptions(success = fun(res){
                    data.items = _uA<Item__6>()
                    val res_str = JSON.stringify(res)
                    val res_obj = JSON.parseObject(res_str)
                    val res_map = res_obj!!.toMap()
                    var keys = _uA<String>()
                    res_map.forEach(fun(_, key){
                        keys.push(key)
                    }
                    )
                    keys.sort().forEach(fun(key){
                        val value = res[key]
                        if (value != null) {
                            val item = Item__6(label = key, value = "" + (if ((UTSAndroid.`typeof`(value) == "object")) {
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
                ))
            }
            val getSystemInfoSync = fun(){
                data.items = _uA<Item__6>()
                val res = uni_getSystemInfoSync()
                val res_str = JSON.stringify(res)
                val res_obj = JSON.parseObject(res_str)
                val res_map = res_obj!!.toMap()
                var keys = _uA<String>()
                res_map.forEach(fun(_, key){
                    keys.push(key)
                }
                )
                keys.sort().forEach(fun(key){
                    val value = res[key]
                    if (value != null) {
                        val item = Item__6(label = key, value = "" + (if ((UTSAndroid.`typeof`(value) == "object")) {
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
            val jest_getSystemInfo = fun(): GetSystemInfoResult {
                return uni_getSystemInfoSync()
            }
            val jest_getScreenHeight_at_different_stages = fun(){
                data.jest_result = (globalScreenHeight == data.screenHeightAtReady)
            }
            __expose(_uM("data" to data, "jest_getSystemInfo" to jest_getSystemInfo, "jest_getScreenHeight_at_different_stages" to jest_getScreenHeight_at_different_stages))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", null, _uA(
                        _cV(_component_page_head, _uM("title" to unref(data).title), null, 8, _uA(
                            "title"
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("view", _uM("class" to "uni-list"), _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(unref(data).items, fun(item, _, __index, _cached): Any {
                                    return _cE("view", _uM("class" to "uni-list-cell", "style" to _nS(_uM("align-items" to "center"))), _uA(
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
                                ), 256)
                            )),
                            _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                                _cE("view", _uM("class" to "uni-btn-v"), _uA(
                                    _cE("button", _uM("type" to "primary", "onClick" to getSystemInfoSync), " 同步获取设备系统信息 "),
                                    _cE("button", _uM("type" to "primary", "onClick" to getSystemInfo, "style" to _nS(_uM("margin-top" to "20px"))), " 异步获取设备系统信息 ", 4)
                                ))
                            ))
                        ))
                    ))
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
