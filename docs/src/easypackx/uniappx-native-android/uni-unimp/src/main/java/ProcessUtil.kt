package uts.sdk.modules.uniUnimp;

import android.app.Application
import android.content.Context
import android.os.Build
import android.text.TextUtils
import java.io.FileInputStream
import java.io.IOException

object ProcessUtil {
    private var currentProcessName: String? = null

    /**
     * @return 当前进程名
     */
    fun getCurrentProcessName(context: Context): String? {
        if (!TextUtils.isEmpty(currentProcessName)) {
            return currentProcessName
        }

        //1)通过Application的API获取当前进程名
        currentProcessName = currentProcessNameByApplication
        if (!TextUtils.isEmpty(currentProcessName)) {
            return currentProcessName
        }

        //2)通过反射ActivityThread获取当前进程名
        currentProcessName = currentProcessNameByActivityThread
        if (!TextUtils.isEmpty(currentProcessName)) {
            return currentProcessName
        }

        //3)通过cmdline获取当前进程名
        currentProcessName = currentProcessNameByCmdline
        if (!TextUtils.isEmpty(currentProcessName)) {
            return currentProcessName
        } else {
            currentProcessName = context.packageName
        }
        return currentProcessName
    }

    val currentProcessNameByApplication: String?
        /**
         * 通过Application新的API获取进程名，无需反射，无需IPC，效率最高。
         */
        get() = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            Application.getProcessName()
        } else null
    val currentProcessNameByActivityThread: String?
        /**
         * 通过反射ActivityThread获取进程名
         */
        get() {
            var processName: String? = null
            try {
                val declaredMethod = Class.forName("android.app.ActivityThread", false, Application::class.java.classLoader)
                    .getDeclaredMethod("currentProcessName", *arrayOfNulls<Class<*>?>(0))
                declaredMethod.isAccessible = true
                val invoke = declaredMethod.invoke(null, *arrayOfNulls(0))
                if (invoke is String) {
                    processName = invoke
                }
            } catch (e: Throwable) {
                e.printStackTrace()
            }
            return processName
        }
    val currentProcessNameByCmdline: String?
        /**
         * 通过cmdline获取进程名
         */
        get() {
            var `in`: FileInputStream? = null
            try {
                val fn = "/proc/self/cmdline"
                `in` = FileInputStream(fn)
                val buffer = ByteArray(256)
                var len = 0
                var b: Int
                while (`in`.read().also { b = it } > 0 && len < buffer.size) {
                    buffer[len++] = b.toByte()
                }
                if (len > 0) {
                    return String(buffer, 0, len, charset("UTF-8"))
                }
            } catch (e: Throwable) {
                e.printStackTrace()
            } finally {
                if (`in` != null) {
                    try {
                        `in`.close()
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            }
            return null
        }
}