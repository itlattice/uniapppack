package uts.sdk.modules.iboxsCommon

import android.app.Activity
import android.view.KeyEvent
import java.lang.ref.WeakReference

/**
 * 音量键监听单例工具类
 * 提供设置监听（拆分音量加/减参数）和取消监听两个核心函数
 */
// 定义类型别名，简化回调写法
typealias OnVolumeDownPressed = () -> Boolean
typealias OnVolumeUpPressed = () -> Boolean

object VolumeKeyMonitor {
    // 弱引用持有Activity，避免内存泄漏
    private var mActivityRef: WeakReference<Activity>? = null
    // 原始的Window.Callback，用于取消监听时还原
    private var mOriginalCallback: android.view.Window.Callback? = null
    // 音量键回调（拆分存储）
    private var onVolumeDown: OnVolumeDownPressed? = null
    private var onVolumeUp: OnVolumeUpPressed? = null

    /**
     * 设置音量键监听（拆分参数：支持单独监听音量加/减，也可同时监听）
     * @param activity 要监听的Activity
     * @param onVolumeDownPressed 音量减键回调（可选），返回true消费事件，false不消费
     * @param onVolumeUpPressed 音量加键回调（可选），返回true消费事件，false不消费
     */
    fun setListener(
        activity: Activity,
        onVolumeDownPressed: OnVolumeDownPressed? = null,
        onVolumeUpPressed: OnVolumeUpPressed? = null
    ) {
        // 先取消之前的监听，避免重复设置
        removeListener()

        // 弱引用持有Activity
        mActivityRef = WeakReference(activity)
        // 拆分存储回调
        onVolumeDown = onVolumeDownPressed
        onVolumeUp = onVolumeUpPressed
        // 保存原始Callback
        mOriginalCallback = activity.window.callback

        // 拦截Window事件分发，监听音量键
        activity.window.callback = object : android.view.Window.Callback by mOriginalCallback!! {
            override fun dispatchKeyEvent(event: KeyEvent): Boolean {
                // 只处理按键按下事件
                if (event.action == KeyEvent.ACTION_DOWN) {
                    return when (event.keyCode) {
                        // 音量减键逻辑（拆分）
                        KeyEvent.KEYCODE_VOLUME_DOWN -> {
                            onVolumeDown?.invoke() ?: originalDispatch(event)
                        }
                        // 音量加键逻辑（拆分）
                        KeyEvent.KEYCODE_VOLUME_UP -> {
                            onVolumeUp?.invoke() ?: originalDispatch(event)
                        }
                        // 其他按键交给原始逻辑处理
                        else -> originalDispatch(event)
                    }
                }
                return originalDispatch(event)
            }

            // 调用原始的事件分发逻辑
            private fun originalDispatch(event: KeyEvent): Boolean {
                return mOriginalCallback?.dispatchKeyEvent(event) ?: false
            }
        }
    }

    /**
     * 取消音量键监听
     * 还原原始的Window.Callback，释放资源
     */
    fun removeListener() {
        // 还原原始的Window.Callback
        mActivityRef?.get()?.window?.callback = mOriginalCallback
        // 清空所有引用，避免内存泄漏
        mActivityRef?.clear()
        mActivityRef = null
        onVolumeDown = null
        onVolumeUp = null
        mOriginalCallback = null
    }
}