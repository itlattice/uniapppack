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
import io.dcloud.uniapp.extapi.showModal as uni_showModal
open class GenPagesAPIUnicloudUnicloudCloudObject : BasePage {
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
    open var data: DataType__78
        get() {
            return unref(this.`$exposed`["data"]) as DataType__78
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var addTodo: () -> UTSPromise<Unit>
        get() {
            return unref(this.`$exposed`["addTodo"]) as () -> UTSPromise<Unit>
        }
        set(value) {
            setRefValue(this.`$exposed`, "addTodo", value)
        }
    open var addTodoWithGeneric: () -> UTSPromise<Unit>
        get() {
            return unref(this.`$exposed`["addTodoWithGeneric"]) as () -> UTSPromise<Unit>
        }
        set(value) {
            setRefValue(this.`$exposed`, "addTodoWithGeneric", value)
        }
    open var fail: () -> UTSPromise<Unit>
        get() {
            return unref(this.`$exposed`["fail"]) as () -> UTSPromise<Unit>
        }
        set(value) {
            setRefValue(this.`$exposed`, "fail", value)
        }
    open var failWithNumberErrCode: () -> UTSPromise<Unit>
        get() {
            return unref(this.`$exposed`["failWithNumberErrCode"]) as () -> UTSPromise<Unit>
        }
        set(value) {
            setRefValue(this.`$exposed`, "failWithNumberErrCode", value)
        }
    open var success: () -> UTSPromise<Unit>
        get() {
            return unref(this.`$exposed`["success"]) as () -> UTSPromise<Unit>
        }
        set(value) {
            setRefValue(this.`$exposed`, "success", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIUnicloudUnicloudCloudObject, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIUnicloudUnicloudCloudObject
            val _cache = __ins.renderCache
            val title = ref("请求云对象")
            val data = reactive(DataType__78(todoTitle = "学习编程", todoContent = "熟悉uts语法", returnTodoTitle = "", returnTodoContent = "", genericDemoReturnTodoTitle = "", genericDemoReturnTodoContent = "", failErrCode = "", failErrSubject = "", failErrDetailTips = "", failNumberErrCode = 0, successErrCode = -1, isUniTest = false))
            fun gen_notify_fn(content: String, title: String) {
                if (!data.isUniTest) {
                    uni_showModal(ShowModalOptions(title = title, content = content, showCancel = false))
                } else {
                    console.log(title, content)
                }
            }
            val notify = ::gen_notify_fn
            fun gen_addTodo_fn(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        val todo = uniCloud.importObject("todo", UniCloudImportObjectOptions(customUI = data.isUniTest), GenCloudObjTodo::class.java)
                        val title = data.todoTitle
                        val content = data.todoContent
                        await(todo.add<UTSJSONObject>(title, content).then(fun(res: UTSJSONObject){
                            data.returnTodoTitle = res["title"] as String
                            data.returnTodoContent = res["content"] as String
                            notify(res["showMessage"] as String, "提示")
                        }
                        ).`catch`(fun(err: Any?){
                            console.log(err)
                            val error = err as UniCloudError
                            console.error(error)
                        }
                        ))
                })
            }
            val addTodo = ::gen_addTodo_fn
            fun gen_addTodoWithGeneric_fn(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        open class AddTodoResult (
                            @JsonNotNull
                            open var title: String,
                            @JsonNotNull
                            open var content: String,
                            @JsonNotNull
                            open var showMessage: String,
                        ) : UTSObject()
                        val todo = uniCloud.importObject("todo", UniCloudImportObjectOptions(customUI = data.isUniTest), GenCloudObjTodo::class.java)
                        val title = data.todoTitle
                        val content = data.todoContent
                        await(todo.add<AddTodoResult>(title, content).then(fun(res: AddTodoResult){
                            data.genericDemoReturnTodoTitle = res.title
                            data.genericDemoReturnTodoContent = res.content
                            notify(res.showMessage, "提示")
                        }
                        ).`catch`(fun(err: Any?){
                            console.log(err)
                            val error = err as UniCloudError
                            console.error(error)
                        }
                        ))
                })
            }
            val addTodoWithGeneric = ::gen_addTodoWithGeneric_fn
            fun gen_randomFail_fn(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        val todoObj = uniCloud.importObject("todo", UniCloudImportObjectOptions(errorOptions = UniCloudImportObjectErrorOptions(retry = true)), GenCloudObjTodo::class.java)
                        await(todoObj.randomFail().then(fun(res: UTSJSONObject){
                            notify(res["showMessage"] as String, "提示")
                        }
                        ).`catch`(fun(err: Any?){
                            val error = err as UniCloudError
                            console.error(error)
                        }
                        ))
                })
            }
            val randomFail = ::gen_randomFail_fn
            fun gen_fail_fn(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        val todo = uniCloud.importObject("todo", UniCloudImportObjectOptions(customUI = data.isUniTest), GenCloudObjTodo::class.java)
                        await(todo.fail().then(fun(res: UTSJSONObject){
                            notify("todo.fail应调用失败，此处错误的触发了成功回调", "错误")
                            console.log("todo.fail: ", res)
                        }
                        ).`catch`(fun(err: Any?){
                            val error = err as UniCloudError
                            data.failErrCode = error.errCode as String
                            data.failErrSubject = error.errSubject as String
                            val detail = error.detail
                            if (detail != null && detail["tips"] != null) {
                                data.failErrDetailTips = detail["tips"] as String
                            }
                            console.error(error)
                        }
                        ))
                })
            }
            val fail = ::gen_fail_fn
            fun gen_failWithNumberErrCode_fn(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        val todo = uniCloud.importObject("todo", UniCloudImportObjectOptions(customUI = data.isUniTest), GenCloudObjTodo::class.java)
                        await(todo.failWithNumberErrCode().then(fun(res: UTSJSONObject){
                            notify("todo.fail应调用失败，此处错误的触发了成功回调", "错误")
                            console.log("todo.fail: ", res)
                        }
                        ).`catch`(fun(err: Any?){
                            val error = err as UniCloudError
                            data.failNumberErrCode = error.errCode as Number
                            console.error(error)
                        }
                        ))
                })
            }
            val failWithNumberErrCode = ::gen_failWithNumberErrCode_fn
            fun gen_success_fn(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        val todo = uniCloud.importObject("todo", UniCloudImportObjectOptions(customUI = data.isUniTest), GenCloudObjTodo::class.java)
                        await(todo.success().then(fun(res: UTSJSONObject){
                            data.successErrCode = res["errCode"] as Number
                            notify(res["showMessage"] as String, "提示")
                        }
                        ).`catch`(fun(err: Any?){
                            val error = err as UniCloudError
                            console.error(error)
                        }
                        ))
                })
            }
            val success = ::gen_success_fn
            __expose(_uM("data" to data, "addTodo" to addTodo, "addTodoWithGeneric" to addTodoWithGeneric, "fail" to fail, "failWithNumberErrCode" to failWithNumberErrCode, "success" to success))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE("scroll-view", _uM("class" to "page-scroll-view"), _uA(
                    _cE("view", null, _uA(
                        _cV(_component_page_head, _uM("title" to unref(title)), null, 8, _uA(
                            "title"
                        )),
                        _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt"), _uA(
                            _cE("view", _uM("class" to "uni-btn-v uni-common-mt"), _uA(
                                _cE("button", _uM("type" to "primary", "onClick" to addTodo), "添加Todo")
                            )),
                            _cE("view", _uM("class" to "uni-btn-v uni-common-mt"), _uA(
                                _cE("button", _uM("type" to "primary", "onClick" to addTodoWithGeneric), " 添加Todo传入泛型 ")
                            )),
                            _cE("view", _uM("class" to "uni-btn-v uni-common-mt"), _uA(
                                _cE("button", _uM("type" to "primary", "onClick" to randomFail), "随机触发失败重试")
                            )),
                            _cE("view", _uM("class" to "uni-btn-v uni-common-mt"), _uA(
                                _cE("button", _uM("type" to "primary", "onClick" to fail), "云对象失败调用")
                            )),
                            _cE("view", _uM("class" to "uni-btn-v uni-common-mt"), _uA(
                                _cE("button", _uM("type" to "primary", "onClick" to failWithNumberErrCode), " 云对象数字错误码 ")
                            )),
                            _cE("view", _uM("class" to "uni-btn-v uni-common-mt"), _uA(
                                _cE("button", _uM("type" to "primary", "onClick" to success), "云对象成功调用")
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
