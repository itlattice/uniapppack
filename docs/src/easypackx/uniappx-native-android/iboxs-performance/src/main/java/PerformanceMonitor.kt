package uts.sdk.modules.iboxsPerformance

import android.app.Activity
import android.app.Application
import android.os.*
import android.util.Log
import android.view.Choreographer
import android.view.ViewTreeObserver
import android.view.Window
import java.util.*
import java.util.concurrent.atomic.AtomicBoolean
import io.dcloud.uts.console

/**
 * 性能监控单例类，整合了各种监控能力
 *
 * 提供以下监控功能：
 * - 崩溃（Crash）监控
 * - 主线程卡顿（Block）监控
 * - ANR 疑似阻塞监控
 * - 页面启动性能监控（首次绘制、完全加载）
 * - 运行时非致命错误监控（非主线程）
 * - 系统资源监控（内存、CPU、FPS）
 * - 慢渲染帧监控
 *
 * 使用方式：
 * 1. 在 Application.onCreate() 中调用 PerformanceMonitor.init(this)
 * 2. 按需调用 startXXXMonitoring 并传入回调
 * 3. 在页面加载完成后调用 markPageLoaded(activity) 标记完成
 */
object PerformanceMonitor {
    private const val TAG = "PerformanceMonitor"
    private var application: Application? = null

    // 监控阈值配置
    private const val BLOCK_THRESHOLD = 500L // 卡顿阈值：超过此毫数视为卡顿
    private const val ANR_TIMEOUT = 5000L    // ANR监控超时时间（毫秒）
    private const val SYSTEM_INFO_INTERVAL = 3000L // 系统信息采样间隔
    private const val SLOW_DRAW_THRESHOLD = 16L    // 慢渲染阈值：>16ms 即为掉帧
	
    // === 数据模型定义（含详细属性说明）===

    /**
     * 崩溃数据模型
     * @property threadName 发生崩溃的线程名称（通常是 "main"）
     * @property exception 异常类型和简要描述（如：java.lang.NullPointerException: Attempt to invoke virtual method）
     * @property stackTrace 异常的完整堆栈信息，用于定位问题代码位置
     * @property timestamp 崩溃发生的时间戳（毫秒）
     */
    data class CrashData(
        val threadName: String,
        val exception: String,
        val stackTrace: String,
        val timestamp: Long = System.currentTimeMillis()
    )

    /**
     * 卡顿数据模型
     * @property costTime 卡顿持续时间（毫秒），即主线程消息处理耗时
     * @property message 引起卡顿的 Looper 消息描述（如：>>>>> Dispatching to Handler）
     * @property stackTrace 卡顿时主线程的堆栈快照，用于分析阻塞点
     * @property timestamp 卡顿发生的时间戳
     */
    data class BlockData(
        val costTime: Long,
        val message: String,
        val stackTrace: String,
        val timestamp: Long = System.currentTimeMillis()
    )

    /**
     * ANR 数据模型（疑似主线程长时间阻塞）
     * @property stackTrace ANR 发生时主线程的堆栈信息
     * @property timestamp 事件发生时间戳
     */
    data class ANRData(
        val stackTrace: String,
        val timestamp: Long = System.currentTimeMillis()
    )

    /**
     * 页面性能数据模型
     * @property pageName 页面名称（通常是 Activity 类名）
     * @property startTime 页面启动时间（onCreate 触发）
     * @property firstDrawTime 页面首次渲染完成时间（onDraw 第一次调用）
     * @property loadedTime 页面完全加载完成时间（由 markPageLoaded 手动标记）
     * @property firstDrawCost 首次绘制耗时 = firstDrawTime - startTime
     * @property totalLoadCost 总加载耗时 = loadedTime - startTime
     * @property timestamp 数据记录时间（通常等于 loadedTime 或 firstDrawTime）
     */
    data class PagePerformanceData(
        val pageName: String,
        val startTime: Long,
        val firstDrawTime: Long = 0,
        val loadedTime: Long = 0,
        val firstDrawCost: Long = 0,
        val totalLoadCost: Long = 0,
        val timestamp: Long = System.currentTimeMillis()
    )

    /**
     * 系统信息数据模型
     * @property memoryUsage 当前应用内存使用量（单位：KB）
     * @property cpuUsage 当前应用 CPU 使用率（百分比，0~100）
     * @property fps 当前应用渲染帧率（帧/秒），理想为 60
     * @property timestamp 采集时间戳
     */
    data class SystemInfoData(
        val memoryUsage: Long, // KB
        val cpuUsage: Float,   // 百分比
        val fps: Float,
        val timestamp: Long = System.currentTimeMillis()
    )

    /**
     * 慢渲染数据模型
     * @property pageName 发生慢渲染的页面名称
     * @property drawCost 渲染一帧所用时间（毫秒），超过 16ms 即可能掉帧
     * @property timestamp 事件发生时间
     */
    data class SlowDrawData(
        val pageName: String,
        val drawCost: Long, // ms
        val timestamp: Long = System.currentTimeMillis()
    )

    /**
     * 运行时错误数据模型（非致命异常）
     * @property threadName 发生错误的线程名称
     * @property errorType 错误类型（如：IOException）
     * @property message 错误消息文本
     * @property stackTrace 错误堆栈信息
     * @property isFatal 是否为致命错误（当前主要用于非主线程）
     * @property timestamp 错误发生时间
     */
    data class RuntimeErrorData(
        val threadName: String,
        val errorType: String,
        val message: String,
        val stackTrace: String,
        val isFatal: Boolean,
        val timestamp: Long = System.currentTimeMillis()
    )

    // 回调引用（用于页面性能数据回调）
    private var pagePerformanceCallback: ((PagePerformanceData) -> Unit)? = null

    // 页面性能数据缓存
    private val pageDataMap = mutableMapOf<String, PagePerformanceData>()

    // 监控状态标志（防止重复注册）
    private var isCrashMonitoring = false
    private var isBlockMonitoring = false
    private var isANRMonitoring = false
    private var isPagePerformanceMonitoring = false
    private var isRuntimeErrorMonitoring = false
    private var isSystemInfoMonitoring = false

    // FPS 计算状态
    private var lastFrameTimeNanos = 0L
    private var currentFps = 0f

    // CPU 计算状态
    private var lastCpuTime = 0L
    private var lastAppCpuTime = 0L

    // === 初始化 ===

    /**
     * 初始化监控，必须在 Application 中调用
     * @param application Application 实例
     */
    fun init(application: Application) {
        this.application = application
        console.log("PerformanceMonitor initialized")
    }

    // === 监控启动方法 ===

    /**
     * 启动崩溃监控（仅捕获主线程崩溃）
     * 使用示例：
     * PerformanceMonitor.startCrashMonitoring { crash ->
     *     Log.e("Crash", "崩溃: ${crash.exception}")
     *     reportToServer(crash)
     * }
     */
    // === 修改 startCrashMonitoring ===
    fun startCrashMonitoring(callback: (crashData: CrashData) -> Unit) {
        if (isCrashMonitoring) return
        isCrashMonitoring = true
    
        val defaultHandler = Thread.getDefaultUncaughtExceptionHandler()
    
        Thread.setDefaultUncaughtExceptionHandler { thread, throwable ->
            val stackTrace = throwable.stackTrace.joinToString("\n")
            val exceptionDesc = throwable.toString()
    
            // 区分主线程（Crash）和非主线程（RuntimeError）
            if (thread.name == "main") {
                // 主线程崩溃 → 上报 Crash
                val crashData = CrashData(
                    threadName = thread.name,
                    exception = exceptionDesc,
                    stackTrace = stackTrace
                )
                console.log("Crash captured: ${crashData.exception}")
                callback(crashData)
            } else {
                // 非主线程异常 → 触发 RuntimeError 回调（如果有）
                if (isRuntimeErrorMonitoring) {
                    val errorData = RuntimeErrorData(
                        threadName = thread.name,
                        errorType = throwable.javaClass.simpleName,
                        message = throwable.message ?: "No message",
                        stackTrace = stackTrace,
                        isFatal = false
                    )
                    runtimeErrorCallback?.invoke(errorData)
                }
                // 非主线程异常通常不终止 App，可以继续抛给默认处理器
            }
    
            // 最终仍交给默认处理器（保证正常崩溃行为）
            defaultHandler?.uncaughtException(thread, throwable)
        }
    
        console.log("Unified crash & runtime error monitoring started")
    }

    /**
     * 启动卡顿监控（主线程消息处理超时）
     * 使用示例：
     * PerformanceMonitor.startBlockMonitoring { block ->
     *     Log.w("Block", "卡顿 ${block.costTime}ms")
     * }
     */
    fun startBlockMonitoring(callback: (blockData: BlockData) -> Unit) {
        if (isBlockMonitoring) return
        isBlockMonitoring = true

        var startTimestamp = 0L
        var startMsg = ""

        Looper.getMainLooper().setMessageLogging { msg ->
            if (msg.startsWith(">>>>> Dispatching")) {
                startTimestamp = System.currentTimeMillis()
                startMsg = msg
            } else if (msg.startsWith("<<<<< Finished")) {
                val cost = System.currentTimeMillis() - startTimestamp
                if (cost > BLOCK_THRESHOLD) {
                    val stackTrace = getStackTraceString(Looper.getMainLooper().thread)
                    val blockData = BlockData(costTime = cost, message = startMsg, stackTrace = stackTrace)
                    console.log("Block detected: ${blockData.costTime}ms")
                    callback(blockData)
                }
            }
        }
        console.log("Block monitoring started")
    }

    /**
     * 启动 ANR 监控（基于心跳检测）
     * 使用示例：
     * PerformanceMonitor.startANRMonitoring { anr ->
     *     Log.e("ANR", "疑似 ANR 发生")
     * }
     */
    fun startANRMonitoring(callback: (anrData: ANRData) -> Unit) {
        if (isANRMonitoring) return
        isANRMonitoring = true

        val mainHandler = Handler(Looper.getMainLooper())
        val anrCheckRunnable = object : Runnable {
            override fun run() {
                val stackTrace = getStackTraceString(Looper.getMainLooper().thread)
                val anrData = ANRData(stackTrace = stackTrace)
                console.log("ANR疑似发生: 主线程阻塞超过 $ANR_TIMEOUT ms")
                callback(anrData)
                mainHandler.postDelayed(this, ANR_TIMEOUT)
            }
        }

        mainHandler.postDelayed(anrCheckRunnable, ANR_TIMEOUT)

        Looper.getMainLooper().setMessageLogging { msg ->
            if (msg.startsWith("<<<<< Finished")) {
                mainHandler.removeCallbacks(anrCheckRunnable)
                mainHandler.postDelayed(anrCheckRunnable, ANR_TIMEOUT)
            }
        }

        console.log("ANR monitoring started")
    }

    /**
     * 启动页面性能监控
     * 使用示例：
     * PerformanceMonitor.startPagePerformanceMonitoring { data ->
     *     when (data) {
     *         is PerformanceMonitor.PagePerformanceData -> {
     *             Log.d("PageLoad", "${data.pageName}: 首次绘制 ${data.firstDrawCost}ms, 总耗时 ${data.totalLoadCost}ms")
     *         }
     *         is PerformanceMonitor.SlowDrawData -> {
     *             Log.w("SlowDraw", "慢渲染: ${data.drawCost}ms")
     *         }
     *     }
     * }
     */
    fun startPagePerformanceMonitoring(callback: (performanceData: Any) -> Unit) {
        if (isPagePerformanceMonitoring) return
        isPagePerformanceMonitoring = true

        val app = application ?: run {
            console.log("请先调用init方法初始化")
            return
        }

        pagePerformanceCallback = { data -> callback(data) }

        app.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                val pageName = activity.javaClass.simpleName
                pageDataMap[pageName] = PagePerformanceData(pageName = pageName, startTime = System.currentTimeMillis())
            }

            override fun onActivityResumed(activity: Activity) {
                val pageName = activity.javaClass.simpleName
                val decorView = activity.window.decorView

                val onDrawListener = object : ViewTreeObserver.OnDrawListener {
                    private var hasDrawn = false
                    override fun onDraw() {
                        if (!hasDrawn) {
                            hasDrawn = true
                            pageDataMap[pageName]?.let { data ->
                                val firstDrawTime = System.currentTimeMillis()
                                val firstDrawCost = firstDrawTime - data.startTime
                                val updatedData = data.copy(
                                    firstDrawTime = firstDrawTime,
                                    firstDrawCost = firstDrawCost
                                )
                                pageDataMap[pageName] = updatedData
                                pagePerformanceCallback?.invoke(updatedData)
                            }
                            decorView.viewTreeObserver.removeOnDrawListener(this)
                        }
                    }
                }
                decorView.viewTreeObserver.addOnDrawListener(onDrawListener)

                monitorDrawPerformance(activity.window, pageName) { slowDrawData ->
                    callback(slowDrawData)
                }
            }

            override fun onActivityPaused(activity: Activity) {}
            override fun onActivityStarted(activity: Activity) {}
            override fun onActivityStopped(activity: Activity) {}
            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
            override fun onActivityDestroyed(activity: Activity) {
                val pageName = activity.javaClass.simpleName
                pageDataMap.remove(pageName)
            }
        })

        console.log("Page performance monitoring started")
    }

    /**
     * 手动标记页面加载完成
     * 在页面数据加载完毕后调用（如网络请求完成）
     * 示例：
     * class MainActivity : Activity() {
     *     override fun onCreate(...) {
     *         super.onCreate(...)
     *         // ... 页面创建
     *     }
     *
     *     private fun onDataLoaded() {
     *         PerformanceMonitor.markPageLoaded(this) // 标记加载完成
     *     }
     * }
     */
    fun markPageLoaded(activity: Activity) {
        val pageName = activity.javaClass.simpleName
        pageDataMap[pageName]?.let { data ->
            val loadedTime = System.currentTimeMillis()
            val totalLoadCost = loadedTime - data.startTime
            val updatedData = data.copy(
                loadedTime = loadedTime,
                totalLoadCost = totalLoadCost
            )
            pageDataMap[pageName] = updatedData
            pagePerformanceCallback?.invoke(updatedData)
        }
    }

    /**
     * 启动运行时错误监控（仅非主线程）
     * 使用示例：
     * PerformanceMonitor.startRuntimeErrorMonitoring { error ->
     *     Log.w("RuntimeError", "后台线程错误: ${error.message}")
     * }
     */
    private var runtimeErrorCallback: ((RuntimeErrorData) -> Unit)? = null
    
    fun startRuntimeErrorMonitoring(callback: (runtimeErrorData: RuntimeErrorData) -> Unit) {
        if (isRuntimeErrorMonitoring) return
        isRuntimeErrorMonitoring = true
        runtimeErrorCallback = callback
        console.log("Runtime error monitoring enabled (will be handled by unified crash handler)")
    }

    /**
     * 启动系统信息监控（内存、CPU、FPS）
     * 使用示例：
     * PerformanceMonitor.startSystemInfoMonitoring { info ->
     *     Log.d("SysInfo", "内存: ${info.memoryUsage}KB, CPU: ${info.cpuUsage}%, FPS: ${info.fps}")
     * }
     */
    fun startSystemInfoMonitoring(callback: (systemInfoData: SystemInfoData) -> Unit) {
        if (isSystemInfoMonitoring) return
        isSystemInfoMonitoring = true

        val app = application ?: run {
            console.log("请先调用init方法初始化")
            return
        }

        val timer = Timer("SystemInfoMonitor")
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                val memoryInfo = android.app.ActivityManager.MemoryInfo()
                val activityManager = app.getSystemService(Application.ACTIVITY_SERVICE) as android.app.ActivityManager
                activityManager.getMemoryInfo(memoryInfo)
                val pid = Process.myPid()
                val memoryInfos = activityManager.getProcessMemoryInfo(intArrayOf(pid))
                val memoryUsage = memoryInfos[0].totalPss.toLong() / 1024

                val cpuUsage = calculateCpuUsage()
                val fps = calculateFps()

                callback(SystemInfoData(memoryUsage, cpuUsage, fps))
            }
        }, 0, SYSTEM_INFO_INTERVAL)

        Runtime.getRuntime().addShutdownHook(Thread { timer.cancel() })
        console.log("System info monitoring started")
    }

    // === 私有工具方法 ===

    private fun getStackTraceString(thread: Thread): String = thread.stackTrace.joinToString("\n")

    private fun calculateFps(): Float {
        if (lastFrameTimeNanos == 0L) {
            lastFrameTimeNanos = System.nanoTime()
            postFrameCallback()
            return 0f
        }
        return currentFps
    }

    private fun postFrameCallback() {
        Choreographer.getInstance().postFrameCallback { frameTimeNanos ->
            if (lastFrameTimeNanos != 0L) {
                val diff = frameTimeNanos - lastFrameTimeNanos
                val frameTimeMs = diff / 1_000_000f
                currentFps = if (frameTimeMs > 0) 1000 / frameTimeMs else 0f
            }
            lastFrameTimeNanos = frameTimeNanos
            postFrameCallback()
        }
    }

    private fun calculateCpuUsage(): Float {
        val appCpuTimeMs = Process.getElapsedCpuTime() // 返回毫秒
		val currentTimeMs = System.currentTimeMillis()
	
		if (lastCpuTime == 0L) {
			lastCpuTime = currentTimeMs
			lastAppCpuTime = appCpuTimeMs
			return 0f
		}
	
		val deltaTimeMs = (currentTimeMs - lastCpuTime).coerceAtLeast(1L)
		val deltaAppCpuMs = (appCpuTimeMs - lastAppCpuTime).coerceAtLeast(0L)
	
		lastCpuTime = currentTimeMs
		lastAppCpuTime = appCpuTimeMs
	
		// CPU 使用率 = 进程消耗的 CPU 时间 / 真实流逝时间
		val cpuUsage = (deltaAppCpuMs * 100f / deltaTimeMs).coerceAtMost(100f)
		return cpuUsage
    }

    private fun monitorDrawPerformance(window: Window, pageName: String, callback: (slowDrawData: SlowDrawData) -> Unit) {
        var lastDrawTime = 0L
        window.decorView.viewTreeObserver.addOnDrawListener {
            val currentTime = System.currentTimeMillis()
            if (lastDrawTime > 0) {
                val drawCost = currentTime - lastDrawTime
                if (drawCost > SLOW_DRAW_THRESHOLD) {
                    callback(SlowDrawData(pageName = pageName, drawCost = drawCost))
                }
            }
            lastDrawTime = currentTime
        }
    }
}