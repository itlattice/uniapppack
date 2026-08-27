@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.iboxsClipboard
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import io.dcloud.uniapp.*
import io.dcloud.uniapp.extapi.*
import io.dcloud.uniapp.framework.*
import io.dcloud.uniapp.runtime.*
import io.dcloud.uniapp.vue.*
import io.dcloud.uniapp.vue.shared.*
import io.dcloud.uts.*
import io.dcloud.uts.Map
import io.dcloud.uts.Set
import kotlin.properties.Delegates
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import io.dcloud.uts.UTSAndroid
import io.dcloud.uniapp.extapi.showToast as uni_showToast
typealias LimeClipboardErrorCode = Number
interface GeneralCallbackResult : IUniError {
    override var errCode: LimeClipboardErrorCode
}
typealias SetClipboardDataCompleteCallback = (res: UniError) -> Unit
typealias SetClipboardDataFailCallback = (res: UniError) -> Unit
typealias SetClipboardDataSuccessCallback = (res: UniError) -> Unit
open class SetClipboardDataOption (
    open var showToast: Boolean? = null,
    @JsonNotNull
    open var data: String,
    open var complete: SetClipboardDataCompleteCallback? = null,
    open var fail: SetClipboardDataFailCallback? = null,
    open var success: SetClipboardDataSuccessCallback? = null,
) : UTSObject()
open class GetClipboardDataSuccessCallbackOption (
    @JsonNotNull
    open var data: String,
    @JsonNotNull
    open var errMsg: String,
) : UTSObject()
typealias GetClipboardDataCompleteCallback = (res: UniError) -> Unit
typealias GetClipboardDataFailCallback = (res: UniError) -> Unit
typealias GetClipboardDataSuccessCallback = (option: GetClipboardDataSuccessCallbackOption) -> Unit
open class GetClipboardDataOption (
    open var complete: GetClipboardDataCompleteCallback? = null,
    open var fail: GetClipboardDataFailCallback? = null,
    open var success: GetClipboardDataSuccessCallback? = null,
) : UTSObject()
val UniErrorSubject = "ClipboardData"
val UniErrors: Map<LimeClipboardErrorCode, String> = Map(_uA(
    _uA(
        9010001,
        "ClipboardData:ok"
    ),
    _uA(
        9010002,
        "ClipboardData:failed"
    )
))
open class GeneralCallbackResultImpl : UniError, GeneralCallbackResult {
    constructor(errCode: LimeClipboardErrorCode, type: String = "set") : super() {
        this.errSubject = type + UniErrorSubject
        this.errCode = errCode
        this.errMsg = type + (UniErrors[errCode] ?: "")
    }
}
fun setClipboardData(options: SetClipboardDataOption) {
    val handleClipboardOperationFailure = fun(){
        val res = GeneralCallbackResultImpl(9010002)
        options.fail?.invoke(res)
        options.complete?.invoke(res)
    }
    try {
        val context = UTSAndroid.getAppContext()
        if (context != null) {
            val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("label", options.data)
            clipboard.setPrimaryClip(clip)
            val res = GeneralCallbackResultImpl(9010001)
            if (options.showToast != false) {
                uni_showToast(ShowToastOptions(icon = "none", title = "复制成功"))
            }
            options.success?.invoke(res)
            options.complete?.invoke(res)
        } else {
            handleClipboardOperationFailure()
        }
    }
     catch (e: Throwable) {
        handleClipboardOperationFailure()
    }
}
fun getClipboardData(options: GetClipboardDataOption) {
    val handleClipboardOperationFailure = fun(){
        val res = GeneralCallbackResultImpl(9010002, "get")
        options.fail?.invoke(res)
        options.complete?.invoke(res)
    }
    try {
        val context = UTSAndroid.getAppContext()
        if (context != null) {
            val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = clipboard.getPrimaryClip()
            if (clip != null && clip.getItemCount() > 0) {
                val text = clip.getItemAt(0).getText()
                if (text != null) {
                    options.success?.invoke(GetClipboardDataSuccessCallbackOption(data = text.toString(), errMsg = "成功"))
                } else {
                    handleClipboardOperationFailure()
                }
            } else {
                handleClipboardOperationFailure()
            }
        } else {
            handleClipboardOperationFailure()
        }
    }
     catch (e: Throwable) {
        handleClipboardOperationFailure()
    }
}
