@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.iboxsPerformance
import android.app.Application
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
open class CrashData (
    @JsonNotNull
    open var threadName: String,
    @JsonNotNull
    open var exception: String,
    @JsonNotNull
    open var stackTrace: String,
    @JsonNotNull
    open var timestamp: Long = 0,
) : UTSObject()
open class RuntimeErrorData (
    @JsonNotNull
    open var threadName: String,
    @JsonNotNull
    open var errorType: String,
    @JsonNotNull
    open var message: String,
    @JsonNotNull
    open var stackTrace: String,
    @JsonNotNull
    open var isFatal: Boolean = false,
    @JsonNotNull
    open var timestamp: Long = 0,
) : UTSObject()
open class BlockData (
    @JsonNotNull
    open var costTime: Long = 0,
    @JsonNotNull
    open var message: String,
    @JsonNotNull
    open var stackTrace: String,
    @JsonNotNull
    open var timestamp: Long = 0,
) : UTSObject()
open class ANRData (
    @JsonNotNull
    open var stackTrace: String,
    @JsonNotNull
    open var timestamp: Long = 0,
) : UTSObject()
val initPerformance = fun(app: Application) {
    return PerformanceMonitor.init(app)
}
val startCrashMonitoring = fun(callback: (crashData: CrashData) -> Unit) {
    return PerformanceMonitor.startCrashMonitoring(fun(res: PerformanceMonitor.CrashData) {
        callback(CrashData(threadName = res.threadName, exception = res.exception, stackTrace = res.stackTrace, timestamp = res.timestamp))
    }
    )
}
val startBlockMonitoring = fun(callback: (blockData: BlockData) -> Unit) {
    return PerformanceMonitor.startBlockMonitoring(fun(res: PerformanceMonitor.BlockData) {
        callback(BlockData(costTime = res.costTime, message = res.message, stackTrace = res.stackTrace, timestamp = res.timestamp))
    }
    )
}
val startANRMonitoring = fun(callback: (anrData: ANRData) -> Unit) {
    return PerformanceMonitor.startANRMonitoring(fun(res: PerformanceMonitor.ANRData) {
        callback(ANRData(stackTrace = res.stackTrace, timestamp = res.timestamp))
    }
    )
}
val startRuntimeErrorMonitoring = fun(callback: (runtimeErrorData: RuntimeErrorData) -> Unit) {
    return PerformanceMonitor.startRuntimeErrorMonitoring(fun(res: PerformanceMonitor.RuntimeErrorData) {
        callback(RuntimeErrorData(threadName = res.threadName, errorType = res.errorType, message = res.message, stackTrace = res.stackTrace, isFatal = res.isFatal, timestamp = res.timestamp))
    }
    )
}
