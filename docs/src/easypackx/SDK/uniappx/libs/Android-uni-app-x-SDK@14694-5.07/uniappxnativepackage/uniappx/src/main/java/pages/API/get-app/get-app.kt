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
open class GenPagesAPIGetAppGetApp : BasePage {
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
    open var data: DataType__50
        get() {
            return unref(this.`$exposed`["data"]) as DataType__50
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var getGlobalData: () -> Unit
        get() {
            return unref(this.`$exposed`["getGlobalData"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "getGlobalData", value)
        }
    open var setGlobalData: () -> Unit
        get() {
            return unref(this.`$exposed`["setGlobalData"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setGlobalData", value)
        }
    open var _increaseLifeCycleNum: () -> Unit
        get() {
            return unref(this.`$exposed`["_increaseLifeCycleNum"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "_increaseLifeCycleNum", value)
        }
    open var setLifeCycleNumFunc: (num: Number) -> Unit
        get() {
            return unref(this.`$exposed`["setLifeCycleNumFunc"]) as (num: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setLifeCycleNumFunc", value)
        }
    open var getAndroidApplication: () -> Boolean
        get() {
            return unref(this.`$exposed`["getAndroidApplication"]) as () -> Boolean
        }
        set(value) {
            setRefValue(this.`$exposed`, "getAndroidApplication", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIGetAppGetApp, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIGetAppGetApp
            val _cache = __ins.renderCache
            val data = reactive(DataType__50(originGlobalData = MyGlobalData(str = "", num = 0, bool = false, obj = _uO("str" to "", "num" to 0, "bool" to false), `null` = null, arr = _uA<Number>(), set = _uA<String>(), map = _uO(), `fun` = fun(): String {
                return ""
            }
            ), originGlobalDataFuncRes = "", newGlobalData = MyGlobalData(str = "", num = 0, bool = false, obj = _uO("str" to "", "num" to 0, "bool" to false), `null` = null, arr = _uA<Number>(), set = _uA<String>(), map = _uO(), `fun` = fun(): String {
                return ""
            }
            ), newGlobalDataFuncRes = "", lifeCycleNum = 0, androidApplication = null))
            val getGlobalData = fun(){
                data.originGlobalData.str = state.globalData.str
                data.originGlobalData.num = state.globalData.num
                data.originGlobalData.bool = state.globalData.bool
                data.originGlobalData.obj = state.globalData.obj
                data.originGlobalData.`null` = state.globalData.`null`
                data.originGlobalData.arr = state.globalData.arr
                state.globalData.set.forEach(fun(value: String){
                    data.originGlobalData.set.push(value)
                }
                )
                state.globalData.map.forEach(fun(value: Any, key: String){
                    data.originGlobalData.map[key] = value
                }
                )
                data.originGlobalData.`fun` = state.globalData.`fun`
                data.originGlobalDataFuncRes = data.originGlobalData.`fun`()
            }
            val setGlobalData = fun(){
                updateGlobalData("str", "new globalData str")
                updateGlobalData("num", 100)
                updateGlobalData("bool", true)
                updateGlobalData("obj", _uO("str" to "new globalData obj str", "num" to 200, "bool" to true))
                updateGlobalData("null", "not null")
                updateGlobalData("arr", _uA(
                    1,
                    2,
                    3
                ))
                updateGlobalData("set", Set(_uA(
                    "a",
                    "b",
                    "c"
                )))
                updateGlobalData("map", Map<String, Any>(_uA(
                    _uA(
                        "a",
                        1
                    ),
                    _uA(
                        "b",
                        2
                    ),
                    _uA(
                        "c",
                        3
                    )
                )))
                updateGlobalData("fun", fun(): String {
                    return "new globalData fun"
                }
                )
                data.newGlobalData.str = state.globalData.str
                data.newGlobalData.num = state.globalData.num
                data.newGlobalData.bool = state.globalData.bool
                data.newGlobalData.obj = state.globalData.obj
                data.newGlobalData.`null` = state.globalData.`null`
                data.newGlobalData.arr = state.globalData.arr
                console.log("state.globalData.arr", state.globalData.arr)
                console.log("state.globalData.set", state.globalData.set)
                state.globalData.set.forEach(fun(value: String){
                    data.newGlobalData.set.push(value)
                }
                )
                state.globalData.map.forEach(fun(value: Any, key: String){
                    data.newGlobalData.map[key] = value
                }
                )
                data.newGlobalData.`fun` = state.globalData.`fun`
                data.newGlobalDataFuncRes = data.newGlobalData.`fun`()
            }
            val _increaseLifeCycleNum = fun(){
                val app = getApp()
                app.vm!!.increaseLifeCycleNum()
                data.lifeCycleNum = state.lifeCycleNum
            }
            val setLifeCycleNumFunc = fun(num: Number){
                setLifeCycleNum(num)
            }
            val getAndroidApplication = fun(): Boolean {
                val app = getApp()
                data.androidApplication = app.getAndroidApplication()
                return data.androidApplication != null
            }
            onReady(fun(){
                data.lifeCycleNum = state.lifeCycleNum
            }
            )
            __expose(_uM("data" to data, "getGlobalData" to getGlobalData, "setGlobalData" to setGlobalData, "_increaseLifeCycleNum" to _increaseLifeCycleNum, "setLifeCycleNumFunc" to setLifeCycleNumFunc, "getAndroidApplication" to getAndroidApplication))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1", "padding-bottom" to "20px"))), _uA(
                    _cE("view", null, _uA(
                        _cV(_component_page_head, _uM("title" to "getApp")),
                        _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                            _cE("button", _uM("onClick" to getGlobalData), "get globalData"),
                            if (isTrue(unref(data).originGlobalData.str.length)) {
                                _cE(Fragment, _uM("key" to 0), _uA(
                                    _cE("text", _uM("class" to "uni-common-mt bold"), "初始的 globalData:"),
                                    _cE("text", _uM("class" to "uni-common-mt"), "globalData string: " + _tD(unref(data).originGlobalData.str), 1),
                                    _cE("text", _uM("class" to "uni-common-mt"), "globalData number: " + _tD(unref(data).originGlobalData.num), 1),
                                    _cE("text", _uM("class" to "uni-common-mt"), "globalData boolean: " + _tD(unref(data).originGlobalData.bool), 1),
                                    _cE("text", _uM("class" to "uni-common-mt"), "globalData object: " + _tD(unref(data).originGlobalData.obj), 1),
                                    _cE("text", _uM("class" to "uni-common-mt"), "globalData null: " + _tD(unref(data).originGlobalData.`null`), 1),
                                    _cE("text", _uM("class" to "uni-common-mt"), "globalData array: " + _tD(unref(data).originGlobalData.arr), 1),
                                    _cE("text", _uM("class" to "uni-common-mt"), "globalData Set: " + _tD(unref(data).originGlobalData.set), 1),
                                    _cE("text", _uM("class" to "uni-common-mt"), "globalData Map: " + _tD(unref(data).originGlobalData.map), 1),
                                    _cE("text", _uM("class" to "uni-common-mt"), "globalData fun 返回值: " + _tD(unref(data).originGlobalDataFuncRes), 1)
                                ), 64)
                            } else {
                                _cC("v-if", true)
                            }
                            ,
                            _cE("button", _uM("onClick" to setGlobalData, "class" to "uni-common-mt"), " set globalData "),
                            if (isTrue(unref(data).newGlobalData.bool)) {
                                _cE(Fragment, _uM("key" to 1), _uA(
                                    _cE("text", _uM("class" to "uni-common-mt bold"), "更新后的 globalData:"),
                                    _cE("text", _uM("class" to "uni-common-mt"), "globalData string: " + _tD(unref(data).newGlobalData.str), 1),
                                    _cE("text", _uM("class" to "uni-common-mt"), "globalData number: " + _tD(unref(data).newGlobalData.num), 1),
                                    _cE("text", _uM("class" to "uni-common-mt"), "globalData boolean: " + _tD(unref(data).newGlobalData.bool), 1),
                                    _cE("text", _uM("class" to "uni-common-mt"), "globalData object: " + _tD(unref(data).newGlobalData.obj), 1),
                                    _cE("text", _uM("class" to "uni-common-mt"), "globalData null: " + _tD(unref(data).newGlobalData.`null`), 1),
                                    _cE("text", _uM("class" to "uni-common-mt"), "globalData array: " + _tD(unref(data).newGlobalData.arr), 1),
                                    _cE("text", _uM("class" to "uni-common-mt"), "globalData Set: " + _tD(unref(data).newGlobalData.set), 1),
                                    _cE("text", _uM("class" to "uni-common-mt"), "globalData Map: " + _tD(unref(data).newGlobalData.map), 1),
                                    _cE("text", _uM("class" to "uni-common-mt"), "globalData fun 返回值: " + _tD(unref(data).newGlobalDataFuncRes), 1)
                                ), 64)
                            } else {
                                _cC("v-if", true)
                            }
                            ,
                            _cE("text", _uM("class" to "uni-common-mt"), "点击按钮调用 App.uvue methods"),
                            _cE("text", _uM("class" to "uni-common-mt"), "increaseLifeCycleNum 方法"),
                            _cE("button", _uM("class" to "uni-common-mt", "onClick" to _increaseLifeCycleNum), " increase lifeCycleNum "),
                            _cE("text", _uM("class" to "uni-common-mt"), "lifeCycleNum: " + _tD(unref(data).lifeCycleNum), 1),
                            _cE("button", _uM("class" to "uni-common-mt", "onClick" to getAndroidApplication), " getAndroidApplication "),
                            _cE("text", _uM("class" to "uni-common-mt"), "androidApplication is null: " + _tD(unref(data).androidApplication == null), 1)
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
                return _uM("bold" to _pS(_uM("fontWeight" to "bold")), "hr" to _pS(_uM("borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#cccccc")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
