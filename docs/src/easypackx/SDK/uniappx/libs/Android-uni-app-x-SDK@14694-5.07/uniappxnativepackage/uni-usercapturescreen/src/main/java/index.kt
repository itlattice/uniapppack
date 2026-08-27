@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.uniUsercapturescreen
import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Environment
import android.os.FileObserver
import android.view.WindowManager
import androidx.core.app.ActivityCompat
import io.dcloud.uniapp.*
import io.dcloud.uniapp.extapi.*
import io.dcloud.uniapp.framework.*
import io.dcloud.uniapp.runtime.*
import io.dcloud.uniapp.vue.*
import io.dcloud.uniapp.vue.shared.*
import io.dcloud.uts.*
import io.dcloud.uts.Map
import io.dcloud.uts.Set
import java.io.File
import java.lang.System
import kotlin.properties.Delegates
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import io.dcloud.uts.UTSAndroid
open class OnUserCaptureScreenCallbackResult (
    open var path: String? = null,
) : UTSObject()
typealias UserCaptureScreenCallback = (res: OnUserCaptureScreenCallbackResult) -> Unit
typealias OnUserCaptureScreen = (callback: UserCaptureScreenCallback?) -> Unit
typealias OffUserCaptureScreen = (callback: UserCaptureScreenCallback?) -> Unit
open class SetUserCaptureScreenSuccess : UTSObject() {
}
typealias SetUserCaptureScreenSuccessCallback = (res: SetUserCaptureScreenSuccess) -> Unit
typealias SetUserCaptureScreenFailCallback = (res: IUniError) -> Unit
typealias SetUserCaptureScreenCompleteCallback = (res: Any) -> Unit
open class SetUserCaptureScreenOptions (
    @JsonNotNull
    open var enable: Boolean = false,
    open var success: SetUserCaptureScreenSuccessCallback? = null,
    open var fail: SetUserCaptureScreenFailCallback? = null,
    open var complete: SetUserCaptureScreenCompleteCallback? = null,
) : UTSObject()
typealias SetUserCaptureScreen = (options: SetUserCaptureScreenOptions) -> Unit
var observer: ScreenFileObserver? = null
var lastObserverTime: Number = 0
var listener: UserCaptureScreenCallback? = null
@Suppress("DEPRECATION")
open class ScreenFileObserver : FileObserver {
    private var screenFile: File
    constructor(screenFileStr: String) : super(screenFileStr) {
        this.screenFile = File(screenFileStr)
    }
    override fun onEvent(event: Int, path: String?): Unit {
        if (event == FileObserver.CREATE) {
            if (path != null) {
                val currentTime = System.currentTimeMillis()
                if ((currentTime - lastObserverTime) < 1000) {
                    return
                }
                lastObserverTime = currentTime
                val screenShotPath = File(this.screenFile, path).getPath()
                val res = OnUserCaptureScreenCallbackResult(path = screenShotPath)
                listener?.invoke(res)
            }
        }
    }
}
val onUserCaptureScreen: OnUserCaptureScreen = fun(callback: UserCaptureScreenCallback?) {
    if (ActivityCompat.checkSelfPermission(UTSAndroid.getAppContext()!!, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
        ActivityCompat.requestPermissions(UTSAndroid.getUniActivity()!!, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 1001)
        return
    }
    listener = callback
    var directory_screenshot: File
    if (Build.MANUFACTURER.toLowerCase() == "xiaomi") {
        directory_screenshot = File(File(Environment.getExternalStorageDirectory(), Environment.DIRECTORY_DCIM), "Screenshots")
    } else {
        directory_screenshot = File(File(Environment.getExternalStorageDirectory(), Environment.DIRECTORY_PICTURES), "Screenshots")
    }
    observer?.stopWatching()
    observer = ScreenFileObserver(directory_screenshot.getPath())
    observer?.startWatching()
    UTSAndroid.onAppActivityDestroy(fun() {
        observer?.stopWatching()
        observer = null
    }
    )
}
val offUserCaptureScreen: OffUserCaptureScreen = fun(_: UserCaptureScreenCallback?) {
    observer?.stopWatching()
    observer = null
    lastObserverTime = 0
}
val setUserCaptureScreen: SetUserCaptureScreen = fun(option: SetUserCaptureScreenOptions) {
    UTSAndroid.getUniActivity()?.runOnUiThread(SetUserCaptureScreenRunnable(option.enable))
    val res = SetUserCaptureScreenSuccess()
    option.success?.invoke(res)
    option.complete?.invoke(res)
}
open class SetUserCaptureScreenRunnable : Runnable {
    private var enable: Boolean
    constructor(enable: Boolean) : super() {
        this.enable = enable
    }
    override fun run(): Unit {
        if (this.enable) {
            UTSAndroid.getUniActivity()?.getWindow()?.clearFlags(WindowManager.LayoutParams.FLAG_SECURE)
        } else {
            UTSAndroid.getUniActivity()?.getWindow()?.addFlags(WindowManager.LayoutParams.FLAG_SECURE)
        }
    }
}
