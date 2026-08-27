package uts.sdk.modules.iboxsPerformance

import android.app.Activity
import android.os.Handler
import android.os.Looper
import android.util.Log
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import kotlin.random.Random
import io.dcloud.uts.console

/**
 * 性能问题模拟工具，用于测试监控系统
 * 可以模拟各种崩溃、卡顿、ANR、内存问题等
 */
object PerformanceIssueSimulator {
    private const val TAG = "IssueSimulator"
    private val executor: ExecutorService = Executors.newFixedThreadPool(5)
    private val mainHandler = Handler(Looper.getMainLooper())

    /**
     * 模拟 Java 崩溃
     * 测试用例：调用此函数应导致应用立即崩溃，并在日志中看到 "模拟 Java 运行时异常导致的崩溃"
     */
    fun simulateJavaCrash() {
        console.log("模拟 Java 崩溃...")
        throw RuntimeException("模拟 Java 运行时异常导致的崩溃")
    }

    /**
     * 模拟 Kotlin 崩溃 (空指针异常)
     * 测试用例：调用此函数应导致应用立即崩溃，并在日志中看到空指针异常堆栈
     */
    fun simulateKotlinCrash() {
        console.log("模拟 Kotlin 崩溃...")
        // 模拟空指针异常
        val nullObject: String? = null
        nullObject!!.length // 这里会抛出 KotlinNullPointerException
    }

    /**
     * 模拟主线程卡顿
     * @param durationMs 卡顿持续时间 (毫秒)
     * 测试用例：调用此函数后，UI应冻结指定时间，ANR监控工具应能检测到主线程无响应。
     */
    fun simulateMainThreadBlock(durationMs: Long = 1000) {
        console.log("模拟主线程卡顿 ${durationMs} ms...")
        val startTime = System.currentTimeMillis()
        // 通过循环阻塞主线程
        while (System.currentTimeMillis() - startTime < durationMs) {
            // 空循环阻塞线程
        }
    }

    /**
     * 模拟 ANR (应用无响应)
     * @param durationMs ANR 持续时间 (毫秒)，通常大于5秒
     * 测试用例：调用此函数（默认6秒），应用应弹出ANR对话框或被系统终止，日志应记录相关信息。
     */
    fun simulateANR(durationMs: Long = 6000) {
        console.log("模拟 ANR ${durationMs} ms...")
        simulateMainThreadBlock(durationMs)
    }

    /**
     * 模拟内存泄漏
     * 持有 Activity 的强引用，阻止其被回收
     * 测试用例：多次调用此函数传入不同的Activity实例，使用内存分析工具（如Android Profiler）
     * 应能观察到Activity实例数量不随页面关闭而减少，存在泄漏。
     */
    private val leakedActivities = mutableListOf<Activity>()

    fun simulateMemoryLeak(activity: Activity) {
        console.log("模拟内存泄漏...")
        // 保存 Activity 的强引用，导致无法被回收
        leakedActivities.add(activity)
        console.log("已泄漏 ${leakedActivities.size} 个 Activity 实例")
    }

    /**
     * 模拟大量内存占用
     * @param sizeMB 要分配的内存大小 (MB)
     * 测试用例：调用此函数分配大量内存（如50MB），内存监控工具应显示内存使用量显著上升。
     * 如果分配过多，应能触发 OutOfMemoryError 并导致应用崩溃。
     */
    fun simulateHighMemoryUsage(sizeMB: Int = 50) {
        console.log("模拟高内存占用 ${sizeMB}MB...")
        executor.execute {
            try {
                // 分配大内存数组
                val buffer = ByteArray(sizeMB * 1024 * 1024)
                // 填充数据防止被优化掉
                for (i in buffer.indices) {
                    buffer[i] = (i % 256).toByte()
                }
                console.log("已分配 ${sizeMB} MB 内存 ")
                // 保持一段时间
                Thread.sleep(5000)
                // 注意：这里不会主动释放内存，模拟内存占用
            } catch (e: OutOfMemoryError) {
                console.error("模拟内存占用时发生 OOM", e)
                // 在子线程中抛出的异常不会导致应用崩溃，需要在主线程抛出或让其自然传播
                // 为确保崩溃，我们可以将错误抛到主线程
                mainHandler.post {
                    throw e
                }
            } catch (e: Exception) {
                console.error("模拟内存占用失败", e)
            }
        }
    }

    /**
     * 模拟页面加载缓慢
     * 测试用例：在页面初始化时调用此函数，页面显示时间应明显延迟。
     * 启动时间监控工具应能捕获到较长的启动耗时。
     */
    fun simulateSlowPageLoad() {
        console.log("模拟页面加载缓慢...")
        executor.execute {
            try {
                // 模拟耗时初始化操作
                Thread.sleep(3000)
            } catch (e: InterruptedException) {
                Thread.currentThread().interrupt() // 正确处理中断
                console.error("模拟页面加载缓慢被中断", e)
            }
        }
    }

    /**
     * 模拟慢渲染
     * @param durationMs 渲染耗时 (毫秒)
     * 测试用例：在UI线程中调用此函数（默认50ms），UI渲染帧率应下降，卡顿监控工具应能检测到掉帧。
     * 可以在动画或滚动过程中调用以观察效果。
     */
    fun simulateSlowRendering(durationMs: Long = 50) {
        console.log("模拟慢渲染 ${durationMs} ms...")
        mainHandler.post {
            val startTime = System.currentTimeMillis()
            // 模拟耗时的 UI 绘制操作
            while (System.currentTimeMillis() - startTime < durationMs) {
                // 模拟复杂计算导致的绘制延迟
                Math.sqrt(Random.nextDouble())
            }
        }
    }

    /**
     * 模拟运行时错误 (非致命)
     * 测试用例：调用此函数，应用不应崩溃，但日志中应记录捕获的 ArithmeticException。
     * 错误监控工具应能捕获到此类非致命异常。
     */
    fun simulateRuntimeError() {
        console.log("模拟运行时错误...")
        executor.execute {
            try {
                // 模拟一个会被捕获的异常
                val result = 10 / 0
                console.log("计算结果: $result") // 这行永远不会执行
            } catch (e: ArithmeticException) {
                console.error("模拟运行时错误发生", e)
                // 这里不抛出，模拟已捕获的异常
				throw RuntimeException("模拟运行时错误发生")
            }
        }
    }

    /**
     * 模拟 CPU 高占用
     * @param durationMs 持续时间 (毫秒)
     * 测试用例：调用此函数后，设备CPU使用率应显著上升，持续指定时间。
     * 性能监控工具应能检测到CPU占用率飙升。
     */
    fun simulateHighCpuUsage(durationMs: Long = 5000) {
        console.log("模拟 CPU 高占用 ${durationMs}ms...")
        // 启动多个线程进行密集计算
        repeat(4) { threadNum ->
            executor.execute {
                val startTime = System.currentTimeMillis()
                var count = 0L
                while (System.currentTimeMillis() - startTime < durationMs) {
                    // 进行无意义的计算消耗CPU
                    count++
                    if (count % 10000000 == 0L) {
                        console.log("CPU密集线程 $threadNum 计数: $count")
                    }
                }
            }
        }
    }

    /**
     * 随机模拟一种性能问题
     * 测试用例：可以循环调用此函数多次，观察监控系统是否能覆盖所有类型的性能问题。
     */
    fun simulateRandomIssue() {
        val random = Random.nextInt(10)
        when (random) {
            0 -> simulateJavaCrash()
            1 -> simulateKotlinCrash()
            2 -> simulateMainThreadBlock(800)
            3 -> simulateANR()
            4 -> simulateRuntimeError()
            5 -> simulateHighMemoryUsage(30)
            6 -> simulateSlowRendering(60)
            7 -> simulateHighCpuUsage()
            8 -> simulateSlowPageLoad()
            9 -> {
                // 模拟多次小卡顿
                repeat(3) {
                    mainHandler.postDelayed({
                        simulateMainThreadBlock(300)
                    }, it * 1000L)
                }
            }
        }
    }

    /**
     * 清理资源
     * 测试用例：在应用退出或测试结束后调用，确保线程池关闭，泄漏列表清空。
     */
    fun cleanUp() {
        executor.shutdown()
        leakedActivities.clear()
        console.log("性能问题模拟器已清理资源")
    }
}