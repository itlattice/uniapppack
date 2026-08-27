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
import io.dcloud.uniapp.extapi.`$off` as uni__off
import io.dcloud.uniapp.extapi.`$on` as uni__on
import io.dcloud.uniapp.extapi.`$once` as uni__once
open class GenPagesAPIEventBusEventBus : BasePage {
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
    open var data: DataType__90
        get() {
            return unref(this.`$exposed`["data"]) as DataType__90
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var on: () -> Unit
        get() {
            return unref(this.`$exposed`["on"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "on", value)
        }
    open var on2: () -> Unit
        get() {
            return unref(this.`$exposed`["on2"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "on2", value)
        }
    open var onObj: () -> Unit
        get() {
            return unref(this.`$exposed`["onObj"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "onObj", value)
        }
    open var once: () -> Unit
        get() {
            return unref(this.`$exposed`["once"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "once", value)
        }
    open var off: () -> Unit
        get() {
            return unref(this.`$exposed`["off"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "off", value)
        }
    open var offAll: () -> Unit
        get() {
            return unref(this.`$exposed`["offAll"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "offAll", value)
        }
    open var emit: () -> Unit
        get() {
            return unref(this.`$exposed`["emit"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "emit", value)
        }
    open var emitWithObj: () -> Unit
        get() {
            return unref(this.`$exposed`["emitWithObj"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "emitWithObj", value)
        }
    open var clear: () -> Unit
        get() {
            return unref(this.`$exposed`["clear"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "clear", value)
        }
    open var testReturnId: () -> Unit
        get() {
            return unref(this.`$exposed`["testReturnId"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "testReturnId", value)
        }
    open var testEmitNoArgs: () -> Unit
        get() {
            return unref(this.`$exposed`["testEmitNoArgs"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "testEmitNoArgs", value)
        }
    open var testEmitMultipleArgs: () -> Unit
        get() {
            return unref(this.`$exposed`["testEmitMultipleArgs"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "testEmitMultipleArgs", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIEventBusEventBus, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIEventBusEventBus
            val _cache = __ins.renderCache
            val data = reactive(DataType__90(log = _uA(), objArg = _uO()))
            val fn = fun(res: String){
                data.log.push(res)
            }
            val fn2 = fun(res: String){
                data.log.push(res)
            }
            val on = fun(){
                uni__on("test", fn)
            }
            val on2 = fun(){
                uni__on("test", fn2)
            }
            val onObj = fun(){
                uni__on("test-obj", fun(res: UTSJSONObject){
                    data.objArg = res
                }
                )
            }
            val once = fun(){
                uni__once("test", fn)
            }
            val off = fun(){
                uni__off("test", fn)
            }
            val offAll = fun(){
                uni__off("test", null)
            }
            val emit = fun(){
                uni__emit("test", "msg:" + Date.now())
            }
            val emitWithObj = fun(){
                uni__emit("test-obj", _uO("a" to 1, "b" to 2))
            }
            val clear = fun(){
                data.log.length = 0
            }
            val testReturnId = fun(){
                val id1 = uni__on("test-return-id", fn)
                uni__emit("test-return-id", "触发 test-return-id \$on fn")
                uni__off("test-return-id", id1)
                uni__emit("test-return-id", "触发 test-return-id \$on fn")
                uni__once("test-return-id", fn)
                uni__emit("test-return-id", "触发 test-return-id \$once fn")
                uni__emit("test-return-id", "触发 test-return-id \$once fn")
                val id2 = uni__once("test-id", fn)
                uni__off("test-return-id", id2)
                uni__emit("test-return-id", "触发 test-return-id \$once fn")
            }
            val testEmitNoArgs = fun(){
                uni__on("test-emit-no-args", fun(){
                    data.log.push("test-emit-no-args")
                }
                )
                uni__emit("test-emit-no-args", null)
                uni__off("test-emit-no-args", null)
            }
            val testEmitMultipleArgs = fun(){
                uni__on("test-emit-multiple-args", fun(arg1: String, arg2: Number){
                    data.log.push("" + arg1 + "_" + arg2)
                }
                )
                uni__emit("test-emit-multiple-args", "arg1", 2)
                uni__off("test-emit-multiple-args", null)
            }
            __expose(_uM("data" to data, "on" to on, "on2" to on2, "onObj" to onObj, "once" to once, "off" to off, "offAll" to offAll, "emit" to emit, "emitWithObj" to emitWithObj, "clear" to clear, "testReturnId" to testReturnId, "testEmitNoArgs" to testEmitNoArgs, "testEmitMultipleArgs" to testEmitMultipleArgs))
            return fun(): Any? {
                return _cE("scroll-view", _uM("class" to "page-scroll-view"), _uA(
                    _cE("view", _uM("class" to "box"), _uA(
                        _cE("button", _uM("class" to "uni-btn", "onClick" to on), "开始监听"),
                        _cE("button", _uM("class" to "uni-btn", "onClick" to once), "监听一次"),
                        _cE("button", _uM("class" to "uni-btn", "onClick" to off), "取消监听"),
                        _cE("button", _uM("class" to "uni-btn", "onClick" to emit), "触发监听"),
                        _cE("button", _uM("class" to "uni-btn", "onClick" to clear), "清空消息"),
                        _cE("view", null, _uA(
                            _cE("view", _uM("class" to "uni-btn"), "收到的消息："),
                            _cE("view", _uM("class" to "uni-btn"), _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(unref(data).log, fun(item, index, __index, _cached): Any {
                                    return _cE("view", _uM("key" to index), _tD(item), 1)
                                }
                                ), 128)
                            )),
                            _cE("button", _uM("class" to "uni-btn", "onClick" to onObj), "开始监听 obj 参数"),
                            _cE("button", _uM("class" to "uni-btn", "onClick" to emitWithObj), "触发监听 obj 参数"),
                            _cE("view", _uM("class" to "uni-btn"), _uA(
                                _cE("text", null, "接收到的 obj 参数："),
                                _cE("text", null, _tD(JSON.stringify(unref(data).objArg)), 1)
                            )),
                            _cE("button", _uM("class" to "uni-btn", "onClick" to testReturnId), "测试返回 id"),
                            _cE("button", _uM("class" to "uni-btn", "onClick" to testEmitNoArgs), "测试 \$emit 无参"),
                            _cE("button", _uM("class" to "uni-btn", "onClick" to testEmitMultipleArgs), "测试 \$emit 多个参数")
                        ))
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
                return _uM("box" to _pS(_uM("paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
