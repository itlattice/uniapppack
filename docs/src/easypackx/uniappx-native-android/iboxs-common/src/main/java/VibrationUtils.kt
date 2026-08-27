package uts.sdk.modules.iboxsCommon

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager

object VibrationUtils {

    /**
     * 触发震动
     * @param context 上下文
     * @param millis 震动时长(毫秒)，默认500ms
     * @return 是否震动成功
     */
    fun vibrate(context: Context, millis: Long = 500): Boolean {
        return try {
            // 获取震动服务
            val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                val vibratorManager = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
                vibratorManager.defaultVibrator
            } else {
                @Suppress("DEPRECATION")
                context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            }

            // 检查设备是否支持震动
            if (!vibrator.hasVibrator()) {
                return false
            }

            // 触发震动
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val effect = if (vibrator.hasAmplitudeControl()) {
                    VibrationEffect.createOneShot(millis, VibrationEffect.DEFAULT_AMPLITUDE) // 使用默认振幅
                    // 或者明确指定一个振幅值，例如 VibrationEffect.createOneShot(millis, 200)
                } else {
                    VibrationEffect.createOneShot(millis, 255) // 兼容不支持振幅控制的设备
                }
                vibrator.vibrate(effect)
            } else {
                // 旧版本兼容
                @Suppress("DEPRECATION")
                vibrator.vibrate(millis)
            }
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    /**
     * 触发自定义震动模式
     * @param context 上下文
     * @param pattern 震动模式数组，例如 [1000, 500, 1000, 500] 表示震动1秒，停0.5秒，震动1秒，停0.5秒
     * @param repeat 重复次数，-1表示不重复，0表示从开头重复
     * @return 是否震动成功
     */
    fun vibratePattern(context: Context, pattern: LongArray, repeat: Int = -1): Boolean {
        return try {
            val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                val vibratorManager = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
                vibratorManager.defaultVibrator
            } else {
                @Suppress("DEPRECATION")
                context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            }

            if (!vibrator.hasVibrator()) {
                return false
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createWaveform(pattern, repeat))
            } else {
                @Suppress("DEPRECATION")
                vibrator.vibrate(pattern, repeat)
            }
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    /**
     * 停止震动
     */
    fun cancelVibration(context: Context) {
        try {
            val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                val vibratorManager = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
                vibratorManager.defaultVibrator
            } else {
                @Suppress("DEPRECATION")
                context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            }
            vibrator.cancel()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
