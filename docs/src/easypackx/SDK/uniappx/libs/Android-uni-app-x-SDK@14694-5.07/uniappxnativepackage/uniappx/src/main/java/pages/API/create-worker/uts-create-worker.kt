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
import uts.sdk.modules.utsWorker.onWorkerError
import uts.sdk.modules.utsWorker.createWorkers
import uts.sdk.modules.utsWorker.sendWorkerMessage
import uts.sdk.modules.utsWorker.onWorkerMessage
import uts.sdk.modules.utsWorker.destroyWorker
import uts.sdk.modules.utsWorker.UTSWorkerAddListenerOptions
import uts.sdk.modules.utsWorker.UTSWorkerReceiveEventCallback
import uts.sdk.modules.utsWorker.UTSWorkerSendWorkerMessageOptions
import uts.sdk.modules.utsWorker.UTSWorkerErrorOptions
open class GenPagesAPICreateWorkerUtsCreateWorker : BasePage {
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
    open var test_resetInputValue: () -> Unit
        get() {
            return unref(this.`$exposed`["test_resetInputValue"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "test_resetInputValue", value)
        }
    open var create: () -> Unit
        get() {
            return unref(this.`$exposed`["create"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "create", value)
        }
    open var sendMessage: () -> Unit
        get() {
            return unref(this.`$exposed`["sendMessage"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "sendMessage", value)
        }
    open var test_taskResult: () -> String
        get() {
            return unref(this.`$exposed`["test_taskResult"]) as () -> String
        }
        set(value) {
            setRefValue(this.`$exposed`, "test_taskResult", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPICreateWorkerUtsCreateWorker, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPICreateWorkerUtsCreateWorker
            val _cache = __ins.renderCache
            val created_boolean = ref(false)
            val workerStatus = ref("none")
            val isListening = ref(false)
            val logs = ref(_uA<UTSJSONObject>())
            val inputValue = ref("1")
            val taskResult = ref("")
            val statusText = computed(fun(): String {
                when (workerStatus.value) {
                    "none" -> 
                        return "未创建"
                    "created" -> 
                        return "已创建"
                    "destroyed" -> 
                        return "已销毁"
                    else -> 
                        return "未知"
                }
            }
            )
            fun addLog(message: String, type: String = "info") {
                val now = Date()
                val timeStr = "" + now.getHours().toString(10).padStart(2, "0") + ":" + now.getMinutes().toString(10).padStart(2, "0") + ":" + now.getSeconds().toString(10).padStart(2, "0")
                val logItem: UTSJSONObject = _uO("message" to ("[" + timeStr + "] " + message), "type" to type, "time" to timeStr)
                logs.value.unshift(logItem)
                if (logs.value.length > 50) {
                    logs.value = logs.value.slice(0, 50)
                }
            }
            fun gen_create_fn() {
                createWorkers()
                workerStatus.value = "created"
                addLog("Worker创建成功", "success")
                created_boolean.value = true
                onWorkerMessage(UTSWorkerAddListenerOptions(success = fun(res: Any){
                    val result = (JSON.parse(JSON.stringify(res)) as UTSJSONObject).getAny("result") as UTSJSONObject
                    val resultData = result.getString("data")
                    taskResult.value = resultData as String
                    inputValue.value = taskResult.value
                    addLog("收到WorkerTask返回: " + resultData, "receive")
                }
                ))
                onWorkerError(UTSWorkerErrorOptions(success = fun(error: Any){
                    val errorMsg = (error as UTSJSONObject).getString("message")
                    addLog("Worker错误: " + errorMsg, "error")
                    console.log("Worker错误:", error)
                }
                ))
            }
            val create = ::gen_create_fn
            fun gen_sendMessage_fn() {
                if (inputValue.value == "") {
                    addLog("请输入有效的数字", "warning")
                    return
                }
                val options = UTSWorkerSendWorkerMessageOptions(data = inputValue.value, needReply = true)
                sendWorkerMessage(options)
                addLog("发送值到WorkerTask: " + inputValue.value, "send")
            }
            val sendMessage = ::gen_sendMessage_fn
            fun gen_destory_fn() {
                destroyWorker()
                workerStatus.value = "destroyed"
                isListening.value = false
                addLog("Worker已销毁", "warning")
                created_boolean.value = false
            }
            val destory = ::gen_destory_fn
            fun gen_clearLogs_fn() {
                logs.value = _uA()
            }
            val clearLogs = ::gen_clearLogs_fn
            fun gen_test_resetInputValue_fn() {
                inputValue.value = "1"
            }
            val test_resetInputValue = ::gen_test_resetInputValue_fn
            fun gen_test_taskResult_fn(): String {
                return taskResult.value
            }
            val test_taskResult = ::gen_test_taskResult_fn
            onUnload(fun(){
                destory()
            }
            )
            __expose(_uM("test_resetInputValue" to test_resetInputValue, "create" to create, "sendMessage" to sendMessage, "test_taskResult" to test_taskResult))
            return fun(): Any? {
                return _cE("scroll-view", _uM("class" to "container"), _uA(
                    _cE("view", _uM("class" to "status-section"), _uA(
                        _cE("text", _uM("class" to "status-label"), "Worker状态: "),
                        _cE("text", _uM("class" to "status-text"), _tD(unref(statusText)), 1)
                    )),
                    _cE("view", _uM("class" to "button-group"), _uA(
                        _cE("text", _uM("class" to "description-text"), "操作步骤：1.创建Worker 2.发送数据测试（消息监听已在创建Worker时添加）"),
                        _cE("button", _uM("class" to "btn", "type" to "primary", "disabled" to unref(created_boolean), "onClick" to create), "UTS插件中创建Worker", 8, _uA(
                            "disabled"
                        )),
                        _cE("button", _uM("class" to "btn", "onClick" to destory, "disabled" to (unref(workerStatus) != "created")), "UTS插件中销毁Worker", 8, _uA(
                            "disabled"
                        ))
                    )),
                    _cE("view", _uM("class" to "input-section"), _uA(
                        _cE("text", _uM("class" to "section-title"), "输入测试值:"),
                        _cE("text", _uM("class" to "description-text"), "点击发送按钮后，会将输入值传给WorkerTask，在子线程执行+1操作后返回结果"),
                        _cE("input", _uM("class" to "input-field", "modelValue" to unref(inputValue), "onInput" to fun(`$event`: UniInputEvent){
                            trySetRefValue(inputValue, `$event`.detail.value)
                        }
                        , "type" to "number", "placeholder" to "请输入数字"), null, 40, _uA(
                            "modelValue"
                        )),
                        _cE("button", _uM("class" to "btn", "type" to "primary", "onClick" to sendMessage, "disabled" to (unref(workerStatus) != "created")), "通过UTS插件发送到WorkerTask (值+1)", 8, _uA(
                            "disabled"
                        ))
                    )),
                    _cE("view", _uM("class" to "log-section"), _uA(
                        _cE("text", _uM("class" to "section-title"), "通信日志:"),
                        _cE("scroll-view", _uM("class" to "log-container"), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(unref(logs), fun(log, index, __index, _cached): Any {
                                return _cE("view", _uM("key" to index, "class" to "log-item"), _uA(
                                    _cE("text", _uM("class" to _nC(_uA(
                                        "log-text",
                                        log["type"]
                                    ))), _tD(log["message"]), 3)
                                ))
                            }
                            ), 128)
                        )),
                        _cE("button", _uM("onClick" to clearLogs, "class" to "btn clear-btn"), "清空日志")
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
                return _uM("container" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10)), "status-section" to _pS(_uM("display" to "flex", "alignItems" to "center", "justifyContent" to "center", "marginBottom" to 20, "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "backgroundColor" to "#ffffff", "borderTopLeftRadius" to 8, "borderTopRightRadius" to 8, "borderBottomRightRadius" to 8, "borderBottomLeftRadius" to 8)), "status-label" to _pS(_uM("fontSize" to 16, "color" to "#666666")), "status-text" to _pS(_uM("fontSize" to 16, "fontWeight" to "bold", "marginLeft" to 8)), "button-group" to _pS(_uM("flexDirection" to "column", "marginBottom" to 20)), "input-section" to _pS(_uM("marginBottom" to 20, "paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15, "backgroundColor" to "#ffffff", "borderTopLeftRadius" to 8, "borderTopRightRadius" to 8, "borderBottomRightRadius" to 8, "borderBottomLeftRadius" to 8)), "input-field" to _pS(_uM("width" to "100%", "paddingTop" to 12, "paddingRight" to 12, "paddingBottom" to 12, "paddingLeft" to 12, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#dddddd", "borderRightColor" to "#dddddd", "borderBottomColor" to "#dddddd", "borderLeftColor" to "#dddddd", "borderTopLeftRadius" to 6, "borderTopRightRadius" to 6, "borderBottomRightRadius" to 6, "borderBottomLeftRadius" to 6, "fontSize" to 16, "marginTop" to 10, "marginRight" to 0, "marginBottom" to 10, "marginLeft" to 0, "backgroundColor" to "#ffffff")), "btn" to _pS(_uM("marginBottom" to 10, "paddingTop" to 5, "paddingRight" to 10, "paddingBottom" to 5, "paddingLeft" to 10, "borderTopLeftRadius" to 6, "borderTopRightRadius" to 6, "borderBottomRightRadius" to 6, "borderBottomLeftRadius" to 6, "fontSize" to 14, "textAlign" to "center")), "log-section" to _pS(_uM("backgroundColor" to "#ffffff", "borderTopLeftRadius" to 8, "borderTopRightRadius" to 8, "borderBottomRightRadius" to 8, "borderBottomLeftRadius" to 8, "paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15)), "section-title" to _pS(_uM("fontSize" to 18, "fontWeight" to "bold", "color" to "#333333", "marginBottom" to 10)), "log-container" to _pS(_uM("height" to 300, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#dddddd", "borderRightColor" to "#dddddd", "borderBottomColor" to "#dddddd", "borderLeftColor" to "#dddddd", "borderTopLeftRadius" to 4, "borderTopRightRadius" to 4, "borderBottomRightRadius" to 4, "borderBottomLeftRadius" to 4, "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "marginTop" to 10, "marginRight" to 0, "marginBottom" to 10, "marginLeft" to 0, "backgroundColor" to "#fafafa")), "log-item" to _pS(_uM("marginBottom" to 5)), "log-text" to _uM("" to _uM("fontSize" to 12, "lineHeight" to 1.4), ".info" to _uM("color" to "#2196F3"), ".success" to _uM("color" to "#4CAF50"), ".warning" to _uM("color" to "#ff9800"), ".error" to _uM("color" to "#f44336"), ".send" to _uM("color" to "#9C27B0"), ".receive" to _uM("color" to "#009688")), "clear-btn" to _pS(_uM("backgroundColor" to "#ff9800", "fontSize" to 12, "paddingTop" to 8, "paddingRight" to 12, "paddingBottom" to 8, "paddingLeft" to 12, "color" to "#ffffff", "borderTopLeftRadius" to 4, "borderTopRightRadius" to 4, "borderBottomRightRadius" to 4, "borderBottomLeftRadius" to 4, "textAlign" to "center")), "description-text" to _pS(_uM("fontSize" to 14, "color" to "#666666", "lineHeight" to 1.4, "marginBottom" to 10)), "ios-tip-section" to _pS(_uM("marginBottom" to 15, "paddingTop" to 12, "paddingRight" to 12, "paddingBottom" to 12, "paddingLeft" to 12, "backgroundColor" to "#fff3cd", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#ffeaa7", "borderRightColor" to "#ffeaa7", "borderBottomColor" to "#ffeaa7", "borderLeftColor" to "#ffeaa7", "borderTopLeftRadius" to 8, "borderTopRightRadius" to 8, "borderBottomRightRadius" to 8, "borderBottomLeftRadius" to 8)), "ios-tip-text" to _pS(_uM("fontSize" to 14, "color" to "#856404", "lineHeight" to 1.4)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
