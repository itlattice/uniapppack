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
import io.dcloud.uniapp.extapi.clearStorage as uni_clearStorage
import io.dcloud.uniapp.extapi.clearStorageSync as uni_clearStorageSync
import io.dcloud.uniapp.extapi.getStorage as uni_getStorage
import io.dcloud.uniapp.extapi.getStorageInfo as uni_getStorageInfo
import io.dcloud.uniapp.extapi.getStorageInfoSync as uni_getStorageInfoSync
import io.dcloud.uniapp.extapi.getStorageSync as uni_getStorageSync
import io.dcloud.uniapp.extapi.hideModal as uni_hideModal
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
import io.dcloud.uniapp.extapi.removeStorage as uni_removeStorage
import io.dcloud.uniapp.extapi.removeStorageSync as uni_removeStorageSync
import io.dcloud.uniapp.extapi.setStorage as uni_setStorage
import io.dcloud.uniapp.extapi.setStorageSync as uni_setStorageSync
import io.dcloud.uniapp.extapi.showModal as uni_showModal
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesAPIStorageStorage : BasePage {
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
    open var data: DataType__60
        get() {
            return unref(this.`$exposed`["data"]) as DataType__60
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var jest_saveUTSJSONObject: () -> Unit
        get() {
            return unref(this.`$exposed`["jest_saveUTSJSONObject"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_saveUTSJSONObject", value)
        }
    open var jest_saveUTSJSONObjectArray: () -> Unit
        get() {
            return unref(this.`$exposed`["jest_saveUTSJSONObjectArray"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_saveUTSJSONObjectArray", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIStorageStorage, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIStorageStorage
            val _cache = __ins.renderCache
            val data = reactive(DataType__60(title = "get/set/clearStorage", key = "", data = "", apiGetData = "", storageInfo = "", staticComplexRet = false, jest_saveUTSJSONObjectSyncResult = 0, jest_saveUTSJSONObjectAsyncResult = 0, jest_saveUTSJSONObjectArraySyncResult = 0))
            val getStorageInfo = fun(){
                uni_getStorageInfo(GetStorageInfoOptions(success = fun(res){
                    data.apiGetData = res
                    data.storageInfo = JSON.stringify(res)
                }
                ))
            }
            val getStorageInfoSync = fun(){
                try {
                    val res = uni_getStorageInfoSync()
                    data.apiGetData = res
                    data.storageInfo = JSON.stringify(res)
                }
                 catch (e: Throwable) {
                    console.log(e)
                }
            }
            val jsonLikeMock = fun(){
                data.key = "key_" + Math.random()
                data.data = JSON.stringify(_uO("name" to "james", "age" to 12, "from" to "american"))
            }
            val longLikeMock = fun(){
                data.key = "key_" + Math.random()
                data.data = "1234567890"
            }
            val floatLikeMock = fun(){
                data.key = "key_" + Math.random()
                data.data = "321456.1234567890"
            }
            val negativeLikeMock = fun(){
                data.key = "key_" + Math.random()
                data.data = "-321456"
            }
            val strMock = fun(){
                data.key = "key_" + Math.random()
                data.data = "测试字符串数据，长度为16个字符"
            }
            val complexStaticTest = fun(){
                uni_setStorageSync("key_complexStaticMock", _uO("name" to "张三", "age" to 12))
                var savedData = uni_getStorageSync("key_complexStaticMock")
                data.staticComplexRet = false
                if (savedData is UTSJSONObject) {
                    if ((savedData as UTSJSONObject).getNumber("age") == 12) {
                        data.staticComplexRet = true
                        uni_showToast(ShowToastOptions(icon = "success", title = "测试通过"))
                    }
                }
            }
            val complexMock = fun(){
                data.key = "key_" + Math.random()
                var jsonObj: UTSJSONObject = _uO("name" to "张三", "age" to 12, "classMate" to _uA(
                    _uO("id" to 1001, "name" to "李四"),
                    _uO("id" to 1002, "name" to "jack ma")
                ))
                data.data = jsonObj
            }
            val numberMock = fun(){
                data.key = "key_" + Math.random()
                data.data = 10011
            }
            val floatMock = fun(){
                data.key = "key_" + Math.random()
                data.data = 3.1415926535893384626
            }
            val keyChange = fun(e: InputEvent){
                data.key = e.detail.value
            }
            val dataChange = fun(e: InputEvent){
                data.data = e.detail.value
            }
            val getStorage = fun(){
                var key = data.key
                if (key.length == 0) {
                    uni_hideModal(HideModalOptions(modalPage = null))
                    uni_showModal(ShowModalOptions(title = "读取数据失败", content = "key 不能为空", showCancel = false))
                } else {
                    uni_getStorage(GetStorageOptions(key = key, success = fun(res){
                        data.apiGetData = res.data
                        var desc: String = UTSAndroid.`typeof`(data.apiGetData)
                        if ("object" == desc) {
                            desc = desc + ": " + JSON.stringify(data.apiGetData)
                        } else {
                            desc = desc + ": " + data.apiGetData
                        }
                        uni_hideModal(HideModalOptions(modalPage = null))
                        uni_showModal(ShowModalOptions(title = "读取数据成功", content = desc, showCancel = false))
                    }
                    , fail = fun(_){
                        uni_hideModal(HideModalOptions(modalPage = null))
                        uni_showModal(ShowModalOptions(title = "读取数据失败", content = "找不到 key 对应的数据", showCancel = false))
                    }
                    ))
                }
            }
            val getStorageSync = fun(){
                var key = data.key
                if (key.length == 0) {
                    uni_hideModal(HideModalOptions(modalPage = null))
                    uni_showModal(ShowModalOptions(title = "读取数据失败", content = "key 不能为空", showCancel = false))
                } else {
                    data.apiGetData = uni_getStorageSync(key)
                    var desc: String = UTSAndroid.`typeof`(data.apiGetData)
                    if ("object" == desc) {
                        desc = desc + ": " + JSON.stringify(data.apiGetData)
                    } else {
                        desc = desc + ": " + data.apiGetData
                    }
                    uni_hideModal(HideModalOptions(modalPage = null))
                    uni_showModal(ShowModalOptions(title = "读取数据成功", content = desc, showCancel = false))
                }
            }
            val setStorage = fun(){
                var key = data.key
                var storageData = data.data
                if (key.length == 0) {
                    uni_hideModal(HideModalOptions(modalPage = null))
                    uni_showModal(ShowModalOptions(title = "保存数据失败", content = "key 不能为空", showCancel = false))
                } else {
                    uni_setStorage(SetStorageOptions(key = key, data = storageData, success = fun(_){
                        uni_hideModal(HideModalOptions(modalPage = null))
                        uni_showModal(ShowModalOptions(title = "存储数据成功", showCancel = false))
                    }
                    , fail = fun(_){
                        uni_hideModal(HideModalOptions(modalPage = null))
                        uni_showModal(ShowModalOptions(title = "储存数据失败!", showCancel = false))
                    }
                    ))
                }
            }
            val setStorageSync = fun(){
                var key = data.key
                var storageData = data.data
                if (key.length == 0) {
                    uni_hideModal(HideModalOptions(modalPage = null))
                    uni_showModal(ShowModalOptions(title = "保存数据失败", content = "key 不能为空", showCancel = false))
                } else {
                    uni_setStorageSync(key, storageData)
                    uni_hideModal(HideModalOptions(modalPage = null))
                    uni_showModal(ShowModalOptions(title = "存储数据成功", showCancel = false))
                }
            }
            val removeStorage = fun(){
                uni_removeStorage(RemoveStorageOptions(key = data.key, success = fun(_){
                    uni_hideModal(HideModalOptions(modalPage = null))
                    uni_showModal(ShowModalOptions(title = "移除数据成功", showCancel = false))
                }
                , fail = fun(_){
                    uni_hideModal(HideModalOptions(modalPage = null))
                    uni_showModal(ShowModalOptions(title = "移除数据失败", showCancel = false))
                }
                ))
            }
            val removeStorageSync = fun(){
                uni_removeStorageSync(data.key)
                uni_hideModal(HideModalOptions(modalPage = null))
                uni_showModal(ShowModalOptions(title = "移除数据成功", showCancel = false))
            }
            val clearStorage = fun(){
                data.key = ""
                data.data = ""
                uni_clearStorage(ClearStorageOptions(success = fun(_) {
                    uni_hideModal(HideModalOptions(modalPage = null))
                    uni_showModal(ShowModalOptions(title = "清除数据成功", showCancel = false))
                }
                , fail = fun(_) {
                    uni_hideModal(HideModalOptions(modalPage = null))
                    uni_showModal(ShowModalOptions(title = "清除数据失败", showCancel = false))
                }
                ))
            }
            val clearStorageSync = fun(){
                data.key = ""
                data.data = ""
                uni_clearStorageSync()
                uni_hideModal(HideModalOptions(modalPage = null))
                uni_showModal(ShowModalOptions(title = "清除数据成功", content = " ", showCancel = false))
            }
            val jest_saveUTSJSONObject = fun(){
                val key = "test_key_saveUTSJSONObject"
                uni_setStorageSync(key, _uO("a" to _uO("b" to 1)))
                val dataSync = uni_getStorageSync(key) as UTSJSONObject
                val dataSyncA = dataSync["a"] as UTSJSONObject
                data.jest_saveUTSJSONObjectSyncResult = dataSyncA.get("b") as Number
                uni_getStorage(GetStorageOptions(key = key, success = fun(res){
                    val dataAsync = res.data as UTSJSONObject
                    val dataAsyncA = dataAsync["a"] as UTSJSONObject
                    data.jest_saveUTSJSONObjectAsyncResult = dataAsyncA.get("b") as Number
                    console.log("data.jest_saveUTSJSONObjectSyncResult: " + data.jest_saveUTSJSONObjectSyncResult)
                    console.log("data.jest_saveUTSJSONObjectAsyncResult: " + data.jest_saveUTSJSONObjectAsyncResult)
                }
                ))
            }
            val jest_saveUTSJSONObjectArray = fun(){
                val key = "test_key_saveUTSJSONObjectArray"
                uni_setStorageSync(key, _uA<UTSJSONObject>(_uO("a" to 1)))
                val dataSync = uni_getStorageSync(key) as UTSArray<UTSJSONObject>
                data.jest_saveUTSJSONObjectArraySyncResult = dataSync[0].get("a") as Number
            }
            val goto = fun(){
                uni_navigateTo(NavigateToOptions(url = "/pages/API/storage/storagemanage"))
            }
            __expose(_uM("data" to data, "jest_saveUTSJSONObject" to jest_saveUTSJSONObject, "jest_saveUTSJSONObjectArray" to jest_saveUTSJSONObjectArray))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE("scroll-view", _uM("class" to "page-scroll-view"), _uA(
                    _cE("view", null, _uA(
                        _cV(_component_page_head, _uM("title" to unref(data).title), null, 8, _uA(
                            "title"
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("view", _uM("class" to "uni-list"), _uA(
                                _cE("view", _uM("class" to "uni-list-cell uni-list-cell-line"), _uA(
                                    _cE("view", _uM("class" to "uni-list-cell-left"), _uA(
                                        _cE("view", _uM("class" to "uni-label"), "key")
                                    )),
                                    _cE("view", _uM("class" to "uni-list-cell-db"), _uA(
                                        _cE("input", _uM("class" to "uni-input", "type" to "text", "placeholder" to "请输入key", "name" to "key", "value" to unref(data).key, "maxlength" to "-1", "onInput" to keyChange), null, 40, _uA(
                                            "value"
                                        ))
                                    ))
                                )),
                                _cE("view", _uM("class" to "uni-list-cell"), _uA(
                                    _cE("view", _uM("class" to "uni-list-cell-left"), _uA(
                                        _cE("view", _uM("class" to "uni-label"), "value")
                                    )),
                                    _cE("view", _uM("class" to "uni-list-cell-db"), _uA(
                                        _cE("input", _uM("class" to "uni-input", "type" to "text", "placeholder" to "请输入value", "name" to "data", "value" to if (UTSAndroid.`typeof`(unref(data).data) === "string") {
                                            unref(data).data
                                        } else {
                                            JSON.stringify(unref(data).data)
                                        }
                                        , "maxlength" to "-1", "onInput" to dataChange), null, 40, _uA(
                                            "value"
                                        ))
                                    ))
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                                _cE("view", _uM("class" to "uni-btn-v"), _uA(
                                    _cE("button", _uM("class" to "uni-btn btn-getStorageInfoASync", "type" to "primary", "onClick" to getStorageInfo), " 获取存储概述信息-异步 "),
                                    _cE("button", _uM("class" to "uni-btn btn-getStorageInfoSync", "onClick" to getStorageInfoSync), " 获取存储概述信息-同步 ")
                                )),
                                _cE("text", _uM("class" to "uni-list-cell-db-text"), _tD(unref(data).storageInfo), 1),
                                _cE("view", _uM("class" to "uni-flex uni-row"), _uA(
                                    _cE("button", _uM("type" to "default", "style" to _nS(_uM("width" to "50%")), "onClick" to strMock), " 填充字符串 ", 4),
                                    _cE("button", _uM("type" to "default", "style" to _nS(_uM("width" to "50%")), "onClick" to complexMock), " 填充复杂对象 ", 4)
                                )),
                                _cE("view", _uM("class" to "uni-flex uni-row"), _uA(
                                    _cE("button", _uM("type" to "default", "style" to _nS(_uM("width" to "50%")), "onClick" to numberMock), " 填充整型 ", 4),
                                    _cE("button", _uM("type" to "default", "style" to _nS(_uM("width" to "50%")), "onClick" to floatMock), " 填充浮点型 ", 4)
                                )),
                                _cE("view", _uM("class" to "uni-flex uni-row"), _uA(
                                    _cE("button", _uM("type" to "default", "style" to _nS(_uM("width" to "50%")), "onClick" to jsonLikeMock), " 填充json字符串 ", 4),
                                    _cE("button", _uM("type" to "default", "style" to _nS(_uM("width" to "50%")), "onClick" to longLikeMock), " 填充整数字符串 ", 4)
                                )),
                                _cE("view", _uM("class" to "uni-flex uni-row"), _uA(
                                    _cE("button", _uM("type" to "default", "style" to _nS(_uM("width" to "50%")), "onClick" to floatLikeMock), " 填充浮点字符串 ", 4),
                                    _cE("button", _uM("type" to "default", "style" to _nS(_uM("width" to "50%")), "onClick" to negativeLikeMock), " 填充负数字符串 ", 4)
                                )),
                                _cE("view", _uM("class" to "uni-flex uni-row"), _uA(
                                    _cE("button", _uM("type" to "default", "class" to "uni-btn btn-complexStaticTest", "style" to _nS(_uM("width" to "100%")), "onClick" to complexStaticTest), " 字面量读写测试 ", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                                _cE("view", _uM("class" to "uni-btn-v"), _uA(
                                    _cE("button", _uM("type" to "primary", "class" to "uni-btn btn-setstorageAsync", "onClick" to setStorage), " 存储数据-异步 "),
                                    _cE("button", _uM("class" to "uni-btn btn-getstorageAsync", "onClick" to getStorage), "读取数据-异步"),
                                    _cE("button", _uM("class" to "uni-btn btn-removeStorageInfoASync", "onClick" to removeStorage), "移除数据-异步"),
                                    _cE("button", _uM("class" to "uni-btn btn-clearStorageInfoASync", "onClick" to clearStorage), "清理数据-异步")
                                )),
                                _cE("view", _uM("class" to "uni-btn-v"), _uA(
                                    _cE("button", _uM("type" to "primary", "class" to "uni-btn btn-setstorageSync", "onClick" to setStorageSync), " 存储数据-同步 "),
                                    _cE("button", _uM("class" to "uni-btn btn-getstorageSync", "onClick" to getStorageSync), "读取数据-同步"),
                                    _cE("button", _uM("class" to "uni-btn btn-removeStorageInfoSync", "onClick" to removeStorageSync), " 移除数据-同步 "),
                                    _cE("button", _uM("class" to "uni-btn btn-clearStorageInfoSync", "onClick" to clearStorageSync), " 清理数据-同步 ")
                                ))
                            ))
                        )),
                        _cE("button", _uM("type" to "primary", "onClick" to goto), "前往storage管理器")
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
