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
open class GenPagesComponentUnicloudDbUnicloudDbMixinDatacomDatacom : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onCreated(fun() {
            this.mixinDatacomPage.current = this.pageCurrent
            this.mixinDatacomPage.size = this.pageSize
            val PROPS_NAME = _uA(
                "",
                "",
                "collection",
                "field",
                "getcount",
                "orderby",
                "where",
                "groupby",
                "groupField",
                "distinct"
            )
            this.`$watch`(fun(): Any {
                return _uA(
                    this.pageCurrent,
                    this.pageSize,
                    this.collection,
                    this.field,
                    this.getcount,
                    this.orderby,
                    this.where,
                    this.groupby,
                    this.groupField,
                    this.distinct
                )
            }
            , fun(newValue: UTSArray<Any>, oldValue: UTSArray<Any>){
                this.mixinDatacomPage.size = this.pageSize
                if (newValue[0] !== oldValue[0]) {
                    this.mixinDatacomPage.current = this.pageCurrent
                }
                var needReset = false
                var changed: UTSArray<String> = _uA()
                run {
                    var i: Number = 2
                    while(i < newValue.length){
                        if (newValue[i] !== oldValue[i]) {
                            needReset = true
                            changed.push(PROPS_NAME[i])
                        }
                        i++
                    }
                }
                this.onMixinDatacomPropsChange(needReset, changed)
            }
            )
        }
        , __ins)
        onCreated(fun() {
            this.load()
        }
        , __ins)
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        return _cE("view", null, _uA(
            if (isTrue(_ctx.mixinDatacomLoading)) {
                _cE("view", _uM("key" to 0), "Loading...")
            } else {
                if (isTrue(_ctx.mixinDatacomError)) {
                    _cE("view", _uM("key" to 1), " 请求错误：" + _tD(_ctx.mixinDatacomError), 1)
                } else {
                    _cE("view", _uM("key" to 2), _uA(
                        _cE("scroll-view", _uM("class" to "list-view"), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(_ctx.mixinDatacomResData, fun(item, _, __index, _cached): Any {
                                return _cE("view", _uM("class" to "list-item"), _uA(
                                    _cE("text", null, _tD(item), 1)
                                ))
                            }
                            ), 256)
                        ))
                    ))
                }
            }
            ,
            if (isTrue(!_ctx.mixinDatacomLoading && _ctx.mixinDatacomResData.length == 0)) {
                _cE("view", _uM("key" to 3), " 无数据 ")
            } else {
                _cC("v-if", true)
            }
        ))
    }
    open var localdata: UTSArray<UTSJSONObject> by `$props`
    open var collection: Any by `$props`
    open var field: String by `$props`
    open var orderby: String by `$props`
    open var where: Any by `$props`
    open var pageData: String by `$props`
    open var pageCurrent: Number by `$props`
    open var pageSize: Number by `$props`
    open var getcount: Boolean by `$props`
    open var gettree: Any by `$props`
    open var gettreepath: Boolean by `$props`
    open var startwith: String by `$props`
    open var limitlevel: Number by `$props`
    open var groupby: String by `$props`
    open var groupField: String by `$props`
    open var distinct: Boolean by `$props`
    open var pageIndistinct: Boolean by `$props`
    open var foreignKey: String by `$props`
    open var loadtime: String by `$props`
    open var manual: Boolean by `$props`
    open var mixinDatacomResData: UTSArray<UTSJSONObject> by `$data`
    open var mixinDatacomLoading: Boolean by `$data`
    open var mixinDatacomHasMore: Boolean by `$data`
    open var mixinDatacomPage: MixinDatacomPaginationType by `$data`
    open var mixinDatacomError: UniCloudError? by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("mixinDatacomResData" to _uA<UTSJSONObject>(), "mixinDatacomLoading" to false, "mixinDatacomHasMore" to false, "mixinDatacomPage" to MixinDatacomPaginationType(current = 1, size = 20, count = 0), "mixinDatacomError" to null as UniCloudError?)
    }
    open var mixinDatacomEasyGet = ::gen_mixinDatacomEasyGet_fn
    open fun gen_mixinDatacomEasyGet_fn(options: MixinDatacomEasyGetOptions?) {
        if (this.mixinDatacomLoading) {
            return
        }
        this.mixinDatacomLoading = true
        this.mixinDatacomError = null
        this.mixinDatacomGet(null).then(fun(res: UniCloudDBGetResult){
            val data = res.data
            val count = res.count
            if (this.getcount && count != null) {
                this.mixinDatacomPage.count = count
            }
            this.mixinDatacomHasMore = !(if ((count != null)) {
                (this.mixinDatacomPage.current * this.mixinDatacomPage.size >= count)
            } else {
                (data.length < this.pageSize)
            }
            )
            this.mixinDatacomResData = data
            options?.success?.invoke(res)
        }
        ).`catch`(fun(err: Any?){
            this.mixinDatacomError = err as UniCloudError
            options?.fail?.invoke(err)
        }
        ).then(fun(){
            this.mixinDatacomLoading = false
            options?.complete?.invoke()
        }
        , fun(){
            this.mixinDatacomLoading = false
            options?.complete?.invoke()
        }
        )
    }
    open var mixinDatacomGet = ::gen_mixinDatacomGet_fn
    open fun gen_mixinDatacomGet_fn(options: MixinDatacomGetOptions?): UTSPromise<UniCloudDBGetResult> {
        var db = uniCloud.databaseForJQL()
        var collection = if (UTSArray.isArray(this.collection)) {
            db.collection(*(this.collection as UTSArray<Any>).toTypedArray())
        } else {
            db.collection(this.collection)
        }
        var filter: UniCloudDBFilter? = null
        if (this.foreignKey.length > 0) {
            filter = collection.foreignKey(this.foreignKey)
        }
        val where: Any = options?.where ?: this.where
        if (UTSAndroid.`typeof`(where) == "string") {
            val whereString = where as String
            if (whereString.length > 0) {
                filter = if ((filter != null)) {
                    filter.where(where)
                } else {
                    collection.where(where)
                }
            }
        } else {
            filter = if ((filter != null)) {
                filter.where(where)
            } else {
                collection.where(where)
            }
        }
        var query: UniCloudDBQuery? = null
        if (this.field.length > 0) {
            query = if ((filter != null)) {
                filter.field(this.field)
            } else {
                collection.field(this.field)
            }
        }
        if (this.groupby.length > 0) {
            if (query != null) {
                query = query.groupBy(this.groupby)
            } else if (filter != null) {
                query = filter.groupBy(this.groupby)
            }
        }
        if (this.groupField.length > 0) {
            if (query != null) {
                query = query.groupField(this.groupField)
            } else if (filter != null) {
                query = filter.groupField(this.groupField)
            }
        }
        if (this.distinct == true) {
            if (query != null) {
                query = query.distinct(this.field)
            } else if (filter != null) {
                query = filter.distinct(this.field)
            }
        }
        if (this.orderby.length > 0) {
            if (query != null) {
                query = query.orderBy(this.orderby)
            } else if (filter != null) {
                query = filter.orderBy(this.orderby)
            }
        }
        val size = this.mixinDatacomPage.size
        val current = this.mixinDatacomPage.current
        if (query != null) {
            query = query.skip(size * (current - 1)).limit(size)
        } else if (filter != null) {
            query = filter.skip(size * (current - 1)).limit(size)
        } else {
            query = collection.skip(size * (current - 1)).limit(size)
        }
        val getOptions: UTSJSONObject = _uO()
        val treeOptions: UTSJSONObject = _uO("limitLevel" to this.limitlevel, "startWith" to this.startwith)
        val getCount: Boolean = options?.getCount ?: this.getcount
        if (this.getcount == true) {
            getOptions["getCount"] = getCount
        }
        val getTree: Any = options?.getTree ?: this.gettree
        if (UTSAndroid.`typeof`(getTree) == "string") {
            val getTreeString = getTree as String
            if (getTreeString.length > 0) {
                getOptions["getTree"] = treeOptions
            }
        } else if (UTSAndroid.`typeof`(getTree) == "object") {
            getOptions["getTree"] = treeOptions
        } else {
            getOptions["getTree"] = getTree
        }
        val getTreePath = options?.getTreePath ?: this.gettreepath
        if (UTSAndroid.`typeof`(getTreePath) == "string") {
            val getTreePathString = getTreePath as String
            if (getTreePathString.length > 0) {
                getOptions["getTreePath"] = getTreePath
            }
        } else {
            getOptions["getTreePath"] = getTreePath
        }
        return query.get(getOptions)
    }
    open var load = ::gen_load_fn
    open fun gen_load_fn() {
        if (this.mixinDatacomLoading == true) {
            return
        }
        this.mixinDatacomLoading = true
        this.mixinDatacomGet(null).then(fun(res: UniCloudDBGetResult){
            val data = res.data
            this.mixinDatacomResData = data
        }
        ).`catch`(fun(err: Any?){
            this.mixinDatacomError = err as UniCloudError
        }
        ).`finally`(fun(){
            this.mixinDatacomLoading = false
        }
        )
    }
    open var onMixinDatacomPropsChange = ::gen_onMixinDatacomPropsChange_fn
    open fun gen_onMixinDatacomPropsChange_fn(needReset: Boolean, changed: UTSArray<String>) {
        console.log(needReset, changed)
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("localdata" to _uM("type" to "Array", "default" to _uA<UTSJSONObject>()), "collection" to _uM("default" to ""), "field" to _uM("type" to "String", "default" to ""), "orderby" to _uM("type" to "String", "default" to ""), "where" to _uM("default" to ""), "pageData" to _uM("type" to "String", "default" to "add"), "pageCurrent" to _uM("type" to "Number", "default" to 1), "pageSize" to _uM("type" to "Number", "default" to 20), "getcount" to _uM("type" to "Boolean", "default" to false), "gettree" to _uM("default" to ""), "gettreepath" to _uM("type" to "Boolean", "default" to false), "startwith" to _uM("type" to "String", "default" to ""), "limitlevel" to _uM("type" to "Number", "default" to 10), "groupby" to _uM("type" to "String", "default" to ""), "groupField" to _uM("type" to "String", "default" to ""), "distinct" to _uM("type" to "Boolean", "default" to false), "pageIndistinct" to _uM("type" to "Boolean", "default" to false), "foreignKey" to _uM("type" to "String", "default" to ""), "loadtime" to _uM("type" to "String", "default" to "auto"), "manual" to _uM("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = _uA(
            "localdata",
            "collection",
            "field",
            "orderby",
            "where",
            "pageData",
            "pageCurrent",
            "pageSize",
            "getcount",
            "gettree",
            "gettreepath",
            "startwith",
            "limitlevel",
            "groupby",
            "groupField",
            "distinct",
            "pageIndistinct",
            "foreignKey",
            "loadtime",
            "manual"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
