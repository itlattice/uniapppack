@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.kuxBroadcastReceiver
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
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
open class ApiCommonSuccessCallback (
    @JsonNotNull
    open var errCode: Number,
    @JsonNotNull
    open var errMsg: String,
) : UTSObject()
typealias ApiFail = (err: UniError) -> Unit
typealias ApiComplete = (res: Any) -> Unit
open class AddActionOptions (
    @JsonNotNull
    open var actionName: String,
    open var success: ((res: ApiCommonSuccessCallback) -> Unit)? = null,
    open var fail: ApiFail? = null,
    open var complete: ApiComplete? = null,
) : UTSObject()
typealias BroadcastNameType = String
open class BroadcastNameItem (
    @JsonNotNull
    open var type: BroadcastNameType,
    @JsonNotNull
    open var name: Any,
    @JsonNotNull
    open var defaultValue: Any,
) : UTSObject()
open class RegisterReceiverOptions (
    @JsonNotNull
    open var broadcastNames: UTSArray<BroadcastNameItem>,
    open var success: ((res: ApiCommonSuccessCallback) -> Unit)? = null,
    open var fail: ApiFail? = null,
    open var complete: ApiComplete? = null,
) : UTSObject()
typealias OnReceiverCallback = (data: UTSArray<Any>) -> Unit
typealias OnReceiverActionCallback = (data: String) -> Unit
open class UnregisterReceiverOptions (
    open var success: ((res: ApiCommonSuccessCallback) -> Unit)? = null,
    open var fail: ApiFail? = null,
    open var complete: ApiComplete? = null,
) : UTSObject()
typealias KuxApiErrorCode = Number
interface KuxApiFail : IUniError {
    override var errCode: KuxApiErrorCode
}
interface IKuxBroadcastReceiver {
    var broadcastNames: UTSArray<BroadcastNameItem>
    var broadcastActionName: String
    fun addAction(options: AddActionOptions)
    fun registerReceiver(options: RegisterReceiverOptions)
    fun onReceiver(callback: OnReceiverCallback)
    fun onActionReceiver(callback: OnReceiverActionCallback)
    fun unregisterReceiver(options: UnregisterReceiverOptions)
}
val UniErrorSubject = "kux-boradcast-receiver"
val UniErrors: Map<KuxApiErrorCode, String> = Map(_uA(
    _uA(
        9010001,
        "指定广播动作不存在"
    ),
    _uA(
        9010002,
        "指定监听不存在"
    ),
    _uA(
        9010003,
        "其他系统异常"
    )
))
open class KuxApiFailImpl : UniError, KuxApiFail {
    constructor(errCode: KuxApiErrorCode) : super() {
        this.errSubject = UniErrorSubject
        this.errCode = errCode
        this.errMsg = UniErrors[errCode] ?: ""
    }
}
open class KuxBroadcastReceiver : IKuxBroadcastReceiver {
    override lateinit var broadcastNames: UTSArray<BroadcastNameItem>
    private var onReceiverCallback: OnReceiverCallback?
    private var receiverCallback: CustomBroadcastReceiver?
    private var onReceiverActionCallback: OnReceiverActionCallback?
    override lateinit var broadcastActionName: String
    private var intentFilter: IntentFilter
    constructor(){
        this.broadcastNames = _uA()
        this.onReceiverCallback = null
        this.receiverCallback = null
        this.onReceiverActionCallback = null
        this.broadcastActionName = ""
        this.intentFilter = IntentFilter()
    }
    override fun addAction(options: AddActionOptions) {
        try {
            this.broadcastActionName = options.actionName
            this.intentFilter.addAction(this.broadcastActionName)
            val res = ApiCommonSuccessCallback(errCode = 0, errMsg = "addAction:ok")
            options?.success?.invoke(res)
            options?.complete?.invoke(res)
        }
         catch (e: Throwable) {
            val res = KuxApiFailImpl(9010003)
            res.cause = SourceError(e.message ?: "添加广播动作失败")
            options?.fail?.invoke(res)
            options?.complete?.invoke(res)
        }
    }
    private fun _checkAction(fail: ApiFail?, complete: ApiComplete?) {
        if (this.broadcastActionName.length === 0) {
            val res = KuxApiFailImpl(9010001)
            fail?.invoke(res)
            complete?.invoke(res)
            return
        }
    }
    override fun registerReceiver(options: RegisterReceiverOptions) {
        this._checkAction(options?.fail, options?.complete)
        try {
            this.broadcastNames = options.broadcastNames
            this.receiverCallback = CustomBroadcastReceiver(this.broadcastNames, fun(data: UTSArray<Any>){
                if (this.onReceiverCallback != null) {
                    this.onReceiverCallback!!(data)
                }
            }
            , fun(data: String){
                if (this.onReceiverActionCallback != null) {
                    this.onReceiverActionCallback!!(data)
                }
            }
            )
            UTSAndroid.getUniActivity()!!.registerReceiver(this.receiverCallback, this.intentFilter)
            val res = ApiCommonSuccessCallback(errCode = 0, errMsg = "registerReceiver:ok")
            options?.success?.invoke(res)
            options?.complete?.invoke(res)
            return
        }
         catch (e: Throwable) {
            val res = KuxApiFailImpl(9010003)
            res.cause = SourceError(e.message ?: "注册监听失败")
            options?.fail?.invoke(res)
            options?.complete?.invoke(res)
        }
    }
    override fun onReceiver(callback: OnReceiverCallback) {
        this.onReceiverCallback = callback
    }
    override fun onActionReceiver(callback: OnReceiverActionCallback) {
        this.onReceiverActionCallback = callback
    }
    override fun unregisterReceiver(options: UnregisterReceiverOptions) {
        try {
            if (this.receiverCallback == null) {
                val res = KuxApiFailImpl(9010002)
                options?.fail?.invoke(res)
                options?.complete?.invoke(res)
                return
            }
            UTSAndroid.getUniActivity()!!.unregisterReceiver(this.receiverCallback)
            this.receiverCallback = null
            this.onReceiverCallback = null
            val res = ApiCommonSuccessCallback(errCode = 0, errMsg = "unregisterReceiver:ok")
            options?.success?.invoke(res)
            options?.complete?.invoke(res)
            return
        }
         catch (e: Throwable) {
            val res = KuxApiFailImpl(9010003)
            res.cause = SourceError(e.message ?: "取消监听失败")
            options?.fail?.invoke(res)
            options?.complete?.invoke(res)
        }
    }
}
open class CustomBroadcastReceiver : BroadcastReceiver {
    private var broadcastNames: UTSArray<BroadcastNameItem>
    private var callback: OnReceiverCallback
    private var onActionCallback: OnReceiverActionCallback
    constructor(broadcastNames: UTSArray<BroadcastNameItem>, callback: OnReceiverCallback, onActionCallback: OnReceiverActionCallback) : super() {
        this.broadcastNames = broadcastNames
        this.callback = callback
        this.onActionCallback = onActionCallback
    }
    override fun onReceive(context: Context, intent: Intent) {
        val res: UTSArray<Any> = _uA()
        this.broadcastNames.map(fun(item){
            when (item.type) {
                "bool" -> 
                    res.push(intent.getBooleanExtra("" + item.name, item.defaultValue as Boolean))
                "byte" -> 
                    res.push(intent.getByteExtra("" + item.name, ("" + item.defaultValue).toInt().toByte()))
                "char" -> 
                    res.push(intent.getCharExtra("" + item.name, ("" + item.defaultValue).toInt().toChar()))
                "double" -> 
                    res.push(intent.getDoubleExtra("" + item.name, ("" + item.defaultValue).toInt().toDouble()))
                "float" -> 
                    res.push(intent.getFloatExtra("" + item.name, ("" + item.defaultValue).toFloat()))
                "int" -> 
                    res.push(intent.getIntExtra("" + item.name, ("" + item.defaultValue).toInt()))
                "long" -> 
                    res.push(intent.getLongExtra("" + item.name, ("" + item.defaultValue).toInt().toLong()))
                else -> 
                    res.push(intent.getStringExtra("" + item.name) ?: "")
            }
        }
        )
        this.callback(res)
        if (intent.action != null) {
            this.onActionCallback(intent.action as String)
        }
    }
}
fun useBroadcastReceiver(): IKuxBroadcastReceiver {
    return KuxBroadcastReceiver()
}
