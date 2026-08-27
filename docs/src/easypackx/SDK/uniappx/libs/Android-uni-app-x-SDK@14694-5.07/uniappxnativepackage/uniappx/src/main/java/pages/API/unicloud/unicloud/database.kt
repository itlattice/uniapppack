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
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading
import io.dcloud.uniapp.extapi.showModal as uni_showModal
open class GenPagesAPIUnicloudUnicloudDatabase : BasePage {
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
    open var data: DataType__91
        get() {
            return unref(this.`$exposed`["data"]) as DataType__91
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var dbAdd: () -> UTSPromise<Unit>
        get() {
            return unref(this.`$exposed`["dbAdd"]) as () -> UTSPromise<Unit>
        }
        set(value) {
            setRefValue(this.`$exposed`, "dbAdd", value)
        }
    open var dbBatchAdd: () -> UTSPromise<Unit>
        get() {
            return unref(this.`$exposed`["dbBatchAdd"]) as () -> UTSPromise<Unit>
        }
        set(value) {
            setRefValue(this.`$exposed`, "dbBatchAdd", value)
        }
    open var dbGet: () -> UTSPromise<Unit>
        get() {
            return unref(this.`$exposed`["dbGet"]) as () -> UTSPromise<Unit>
        }
        set(value) {
            setRefValue(this.`$exposed`, "dbGet", value)
        }
    open var dbGetWithCommand: () -> UTSPromise<Unit>
        get() {
            return unref(this.`$exposed`["dbGetWithCommand"]) as () -> UTSPromise<Unit>
        }
        set(value) {
            setRefValue(this.`$exposed`, "dbGetWithCommand", value)
        }
    open var dbUpdate: () -> UTSPromise<Unit>
        get() {
            return unref(this.`$exposed`["dbUpdate"]) as () -> UTSPromise<Unit>
        }
        set(value) {
            setRefValue(this.`$exposed`, "dbUpdate", value)
        }
    open var dbRemove: () -> UTSPromise<Unit>
        get() {
            return unref(this.`$exposed`["dbRemove"]) as () -> UTSPromise<Unit>
        }
        set(value) {
            setRefValue(this.`$exposed`, "dbRemove", value)
        }
    open var dbLookupInit: () -> UTSPromise<Unit>
        get() {
            return unref(this.`$exposed`["dbLookupInit"]) as () -> UTSPromise<Unit>
        }
        set(value) {
            setRefValue(this.`$exposed`, "dbLookupInit", value)
        }
    open var dbLookup: () -> UTSPromise<Unit>
        get() {
            return unref(this.`$exposed`["dbLookup"]) as () -> UTSPromise<Unit>
        }
        set(value) {
            setRefValue(this.`$exposed`, "dbLookup", value)
        }
    open var dbMultiSend: () -> UTSPromise<Unit>
        get() {
            return unref(this.`$exposed`["dbMultiSend"]) as () -> UTSPromise<Unit>
        }
        set(value) {
            setRefValue(this.`$exposed`, "dbMultiSend", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIUnicloudUnicloudDatabase, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIUnicloudUnicloudDatabase
            val _cache = __ins.renderCache
            val title = ref("ClientDB")
            val data = reactive(DataType__91(addId = "", batchAddIds = _uA<String>(), batchAddinserted = 0, updateUpdated = 0, getData = _uA<UTSJSONObject>(), getWithCommandData = _uA<UTSJSONObject>(), removeDeleted = 0, lookupData = _uA<UTSJSONObject>(), multiSendSuccessCount = 0, isUniTest = false))
            val dataTag = computed<String>(fun(): String {
                return if (data.isUniTest) {
                    "default-tag" + Date.now()
                } else {
                    "default-tag"
                }
            }
            )
            fun gen_notify_fn(content: String, title: String) {
                if (!data.isUniTest) {
                    uni_showModal(ShowModalOptions(title = title, content = content, showCancel = false))
                } else {
                    console.log(title, content)
                }
            }
            val notify = ::gen_notify_fn
            fun gen_dbAdd_fn(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        uni_showLoading(ShowLoadingOptions(title = "加载中..."))
                        val db = uniCloud.databaseForJQL()
                        await(db.collection("type").add(_uO("num" to 1, "tag" to dataTag.value, "date" to Date())).then(fun(res){
                            uni_hideLoading(null)
                            console.log(res)
                            data.addId = res.id
                            notify("新增成功，id: " + res.id, "提示")
                        }
                        ).`catch`(fun(err: Any?){
                            uni_hideLoading(null)
                            val error = err as UniCloudError
                            notify(error.errMsg, "错误")
                        }
                        ))
                })
            }
            val dbAdd = ::gen_dbAdd_fn
            fun gen_dbBatchAdd_fn(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        uni_showLoading(ShowLoadingOptions(title = "加载中..."))
                        val db = uniCloud.databaseForJQL()
                        await(db.collection("type").add(_uA(
                            _uO("num" to 2, "tag" to dataTag.value),
                            _uO("num" to 3, "tag" to dataTag.value)
                        )).then(fun(res){
                            uni_hideLoading(null)
                            console.log(res)
                            console.log("JSON.stringify(res.inserted)", JSON.stringify(res.inserted))
                            data.batchAddIds = res.ids
                            data.batchAddinserted = res.inserted
                            notify("新增成功条数" + res.inserted + ", id列表: " + res.ids.join(","), "提示")
                        }
                        ).`catch`(fun(err: Any?){
                            uni_hideLoading(null)
                            val error = err as UniCloudError
                            notify(error.errMsg, "错误")
                        }
                        ))
                })
            }
            val dbBatchAdd = ::gen_dbBatchAdd_fn
            fun gen_dbGet_fn(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        uni_showLoading(ShowLoadingOptions(title = "加载中..."))
                        val db = uniCloud.databaseForJQL()
                        await(db.collection("type").where("tag == \"" + dataTag.value + "\"").field("num, tag").orderBy("num desc").skip(1).limit(2).get().then(fun(res){
                            uni_hideLoading(null)
                            console.log(res)
                            data.getData = res.data
                            notify("获取成功，取到了" + res.data.length + "条数据", "提示")
                        }
                        ).`catch`(fun(err: Any?){
                            uni_hideLoading(null)
                            val error = err as UniCloudError
                            notify(error.errMsg, "错误")
                        }
                        ))
                })
            }
            val dbGet = ::gen_dbGet_fn
            fun gen_dbGetWithCommand_fn(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        uni_showLoading(ShowLoadingOptions(title = "加载中..."))
                        val db = uniCloud.databaseForJQL()
                        await(db.collection("type").where(_uO("num" to db.command.gt(1), "tag" to dataTag.value)).field("num, tag").orderBy("num desc").skip(1).limit(2).get().then(fun(res){
                            uni_hideLoading(null)
                            console.log(res)
                            data.getWithCommandData = res.data
                            notify("获取成功，取到了" + res.data.length + "条数据", "提示")
                        }
                        ).`catch`(fun(err: Any?){
                            uni_hideLoading(null)
                            val error = err as UniCloudError
                            notify(error.errMsg, "错误")
                        }
                        ))
                })
            }
            val dbGetWithCommand = ::gen_dbGetWithCommand_fn
            fun gen_dbUpdate_fn(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        uni_showLoading(ShowLoadingOptions(title = "加载中..."))
                        val db = uniCloud.databaseForJQL()
                        await(db.collection("type").where("tag == \"" + dataTag.value + "\"").update(_uO("num" to 4)).then(fun(res){
                            uni_hideLoading(null)
                            console.log(res)
                            data.updateUpdated = res.updated
                            notify("更新成功，更新了" + res.updated + "条数据", "提示")
                        }
                        ).`catch`(fun(err: Any?){
                            uni_hideLoading(null)
                            val error = err as UniCloudError
                            notify(error.errMsg, "错误")
                        }
                        ))
                })
            }
            val dbUpdate = ::gen_dbUpdate_fn
            fun gen_dbRemove_fn(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        uni_showLoading(ShowLoadingOptions(title = "加载中..."))
                        val db = uniCloud.databaseForJQL()
                        await(db.collection("type").where("tag == \"" + dataTag.value + "\"").remove().then(fun(res){
                            uni_hideLoading(null)
                            console.log(res)
                            data.removeDeleted = res.deleted
                            notify("删除成功，删掉了" + res.deleted + "条数据", "提示")
                        }
                        ).`catch`(fun(err: Any?){
                            uni_hideLoading(null)
                            val error = err as UniCloudError
                            notify(error.errMsg, "错误")
                        }
                        ))
                })
            }
            val dbRemove = ::gen_dbRemove_fn
            fun gen_dbLookupInit_fn(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        uni_showLoading(ShowLoadingOptions(title = "加载中..."))
                        val db = uniCloud.databaseForJQL()
                        await(db.collection("local").where("tag == \"" + dataTag.value + "\"").remove().then(fun(): UTSPromise<UniCloudDBRemoveResult> {
                            return db.collection("foreign").where("tag == \"" + dataTag.value + "\"").remove()
                        }
                        ).then(fun(): UTSPromise<UniCloudDBBatchAddResult> {
                            return db.collection("local").add(_uA(
                                _uO("id" to "local_1", "name" to "local_1_name", "tag" to dataTag.value, "foreign_id" to "foreign_1"),
                                _uO("id" to "local_2", "name" to "local_2_name", "tag" to dataTag.value, "foreign_id" to "foreign_2")
                            ))
                        }
                        ).then(fun(): UTSPromise<UniCloudDBBatchAddResult> {
                            return db.collection("foreign").add(_uA(
                                _uO("id" to "foreign_1", "name" to "foreign_1_name", "tag" to dataTag.value),
                                _uO("id" to "foreign_2", "name" to "foreign_2_name", "tag" to dataTag.value)
                            ))
                        }
                        ).then(fun(_): Unit {
                            uni_hideLoading(null)
                            notify("数据初始化成功", "提示")
                        }
                        ).`catch`(fun(err: Any?){
                            uni_hideLoading(null)
                            console.error(err)
                            val error = err as UniCloudError
                            notify(error.errMsg, "错误")
                        }
                        ))
                })
            }
            val dbLookupInit = ::gen_dbLookupInit_fn
            fun gen_dbLookup_fn(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        uni_showLoading(ShowLoadingOptions(title = "加载中..."))
                        val db = uniCloud.databaseForJQL()
                        val local = db.collection("local").where("tag == \"" + dataTag.value + "\"").getTemp()
                        val foreign = db.collection("foreign").where("tag == \"" + dataTag.value + "\"").getTemp()
                        await(db.collection(local, foreign).get().then(fun(res){
                            uni_hideLoading(null)
                            console.log(res)
                            data.lookupData = res.data
                            notify("联表查询成功，取到了" + res.data.length + "条数据", "提示")
                        }
                        ).`catch`(fun(err: Any?){
                            uni_hideLoading(null)
                            val error = err as UniCloudError
                            notify(error.errMsg, "错误")
                        }
                        ))
                })
            }
            val dbLookup = ::gen_dbLookup_fn
            fun gen_dbMultiSend_fn(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        val db = uniCloud.databaseForJQL()
                        val temp1 = db.collection("type").where("tag == \"default-tag\"").getTemp()
                        val temp2 = db.collection("type").where("tag == \"default-tag\"").getTemp()
                        await(db.multiSend(temp1, temp2).then<Unit>(fun(res){
                            uni_hideLoading(null)
                            var successCount: Number = 0
                            run {
                                var i: Number = 0
                                while(i < res.dataList.length){
                                    val item = res.dataList[i]
                                    if (item.errCode == 0) {
                                        console.log("第" + i + "个请求查询到" + item.data!!.length + "条数据")
                                        successCount++
                                    } else {
                                        console.error("第" + i + "个请求查询失败，错误信息：" + item.data!!.length)
                                    }
                                    i++
                                }
                            }
                            data.multiSendSuccessCount = successCount
                            notify("合并查询成功，成功查询的语句条数为：" + successCount, "提示")
                        }
                        ).`catch`<Unit>(fun(err: Any?){
                            uni_hideLoading(null)
                            val error = err as UniCloudError
                            console.error(err)
                            notify(error.errMsg, "错误")
                        }
                        ))
                })
            }
            val dbMultiSend = ::gen_dbMultiSend_fn
            __expose(_uM("data" to data, "dbAdd" to dbAdd, "dbBatchAdd" to dbBatchAdd, "dbGet" to dbGet, "dbGetWithCommand" to dbGetWithCommand, "dbUpdate" to dbUpdate, "dbRemove" to dbRemove, "dbLookupInit" to dbLookupInit, "dbLookup" to dbLookup, "dbMultiSend" to dbMultiSend))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE("scroll-view", _uM("class" to "page-scroll-view"), _uA(
                    _cE("view", null, _uA(
                        _cV(_component_page_head, _uM("title" to unref(title)), null, 8, _uA(
                            "title"
                        )),
                        _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt"), _uA(
                            _cE("view", _uM("class" to "uni-btn-v uni-common-mt"), _uA(
                                _cE("button", _uM("type" to "primary", "onClick" to dbAdd), "新增单条数据"),
                                _cE("button", _uM("type" to "primary", "onClick" to dbBatchAdd), "新增多条数据"),
                                _cE("button", _uM("type" to "primary", "onClick" to dbUpdate), "更新数据"),
                                _cE("button", _uM("type" to "primary", "onClick" to dbGet), "where传字符串获取数据"),
                                _cE("button", _uM("type" to "primary", "onClick" to dbGetWithCommand), "where传对象获取数据"),
                                _cE("button", _uM("type" to "primary", "onClick" to dbRemove), "删除数据"),
                                _cE("button", _uM("type" to "primary", "onClick" to dbLookupInit), "初始化联表查询数据"),
                                _cE("button", _uM("type" to "primary", "onClick" to dbLookup), "联表查询"),
                                _cE("button", _uM("type" to "primary", "onClick" to dbMultiSend), "合并查询查询")
                            ))
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
