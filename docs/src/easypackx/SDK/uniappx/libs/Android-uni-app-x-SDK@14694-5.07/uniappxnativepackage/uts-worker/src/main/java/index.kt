@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.utsWorker
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import io.dcloud.uniapp.extapi.createWorker as uni_createWorker
open class HelloWorkerTask : WorkerTaskImpl {
    constructor() : super() {
        console.log("[WorkerTask] HelloWorkerTask 构造器初始化")
    }
    override fun entry() {
        console.log("[WorkerTask] HelloWorkerTask 启动完成，等待主线程消息")
    }
    override fun onMessage(message: Any) {
        console.log("[WorkerTask] 收到主线程消息: ", message)
        val messageData = message as UTSJSONObject
        val msgData = messageData["data"] as String
        val needReply = messageData["needReply"] as Boolean
        console.log("[WorkerTask] 数据: " + msgData + ", 需要回复: " + needReply)
        if (needReply) {
            this.sendReply(msgData)
        }
    }
    private fun sendReply(msgData: String) {
        val response = UTSJSONObject()
        val inputNumber = parseInt(msgData)
        if (isNaN(inputNumber)) {
            response["data"] = "输入\"" + msgData + "\"不是有效数字"
        } else {
            val result = inputNumber + 1
            response["data"] = result.toString(10)
        }
        console.log("[WorkerTask] 发送回复消息:", response)
        this.postMessage(response)
    }
}
open class UTSWorkerAddListenerOptions (
    open var success: UTSWorkerReceiveEventCallback? = null,
) : UTSObject()
open class UTSWorkerAddListenerOptionsSuccess (
    @JsonNotNull
    open var result: UTSJSONObject,
) : UTSObject()
open class UTSWorkerSendWorkerMessageOptions (
    @JsonNotNull
    open var data: String,
    @JsonNotNull
    open var needReply: Boolean = false,
) : UTSObject()
open class UTSWorkerErrorCallbackSuccess (
    @JsonNotNull
    open var message: String,
) : UTSObject()
open class UTSWorkerErrorOptions (
    open var success: UTSWorkerErrorCallback? = null,
) : UTSObject()
typealias UTSWorkerErrorCallback = (error: UTSWorkerErrorCallbackSuccess) -> Unit
typealias UTSWorkerReceiveEventCallback = (callback: UTSWorkerAddListenerOptionsSuccess) -> Unit
typealias SendWorkerMessage = (options: UTSWorkerSendWorkerMessageOptions) -> Unit
typealias OnWorkerMessage = (options: UTSWorkerAddListenerOptions) -> Unit
typealias OnWorkerError = (options: UTSWorkerErrorOptions) -> Unit
typealias CreateWorkers = () -> Unit
typealias DestroyWorker = () -> Unit
val createWorkers: CreateWorkers = fun(): Unit {
    UTSWorkerImpl.shared.create()
}
val sendWorkerMessage: SendWorkerMessage = fun(options: UTSWorkerSendWorkerMessageOptions): Unit {
    UTSWorkerImpl.shared.sendMessage(options)
}
val onWorkerMessage: OnWorkerMessage = fun(options: UTSWorkerAddListenerOptions): Unit {
    UTSWorkerImpl.shared.onMessage(options)
}
val destroyWorker: DestroyWorker = fun(): Unit {
    UTSWorkerImpl.shared.destroy()
}
val onWorkerError: OnWorkerError = fun(options: UTSWorkerErrorOptions): Unit {
    UTSWorkerImpl.shared.onError(options)
}
open class UTSWorkerImpl {
    private var workerImp: Worker? = null
    private var options: UTSWorkerAddListenerOptions? = null
    private var errorOptions: UTSWorkerErrorOptions? = null
    open fun create() {
        if (this.workerImp != null) {
            console.warn("[UTS Plugin] Worker已存在，先销毁旧的Worker")
            this.destroy()
        }
        console.log("[UTS Plugin] 创建Worker")
        val worker = uni_createWorker(fun(): WorkerTaskImpl {
            return HelloWorkerTask()
        }
        )
        this.workerImp = worker
    }
    open fun sendMessage(options: UTSWorkerSendWorkerMessageOptions) {
        if (this.workerImp == null) {
            console.error("Worker未创建，无法发送消息")
            return
        }
        val msgData = options.data
        val needReply = options.needReply
        console.log("[UTS Plugin] 向Worker发送消息: " + msgData + " (需要回复: " + needReply + ")")
        val messageToWorker: UTSJSONObject = _uO("data" to msgData, "needReply" to needReply)
        this.workerImp!!.postMessage(messageToWorker, null)
    }
    open fun onMessage(options: UTSWorkerAddListenerOptions) {
        if (this.workerImp == null) {
            console.error("Worker未创建，无法监听消息")
            return
        }
        this.options = options
        this.workerImp!!.onMessage(fun(result){
            console.log("[UTS Plugin] 收到Worker消息:", result)
            if (this.options != null && this.options!!.success != null) {
                var success = UTSWorkerAddListenerOptionsSuccess(result = result as UTSJSONObject)
                this.options!!.success!!(success)
            }
        }
        )
    }
    open fun onError(options: UTSWorkerErrorOptions) {
        if (this.workerImp == null) {
            console.error("Worker未创建，无法监听错误")
            return
        }
        this.errorOptions = options
        this.workerImp!!.onError(fun(error){
            console.error("[UTS Plugin] Worker发生错误:", error)
            if (this.errorOptions != null && this.errorOptions!!.success != null) {
                val errorInfo = UTSWorkerErrorCallbackSuccess(message = "worker error")
                this.errorOptions!!.success!!(errorInfo)
            }
        }
        )
    }
    open fun destroy() {
        if (this.workerImp != null) {
            console.log("[UTS Plugin] 销毁Worker")
            this.workerImp!!.terminate()
            this.workerImp = null
            this.options = null
            this.errorOptions = null
        }
    }
    companion object {
        var shared: UTSWorkerImpl = UTSWorkerImpl()
    }
}
