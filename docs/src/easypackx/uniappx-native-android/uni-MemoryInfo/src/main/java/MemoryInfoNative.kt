// 设置原生包名  
package uts.memoryinf.android;


// 引用系统类  
import android.app.ActivityManager
import android.content.Context.ACTIVITY_SERVICE
// 引用 uts 基础库相关类
import io.dcloud.uts.UTSAndroid
import io.dcloud.uts.setInterval
import io.dcloud.uts.clearInterval
import io.dcloud.uts.console


/**
 * 原生 Kotlin 语言实现封装类  
 */
object MemoryInfoNative {
  /**
   * 记录上一次的任务id
   */
  private var lastTaskId:Number = -1

  /**
   * 获取内测信息
   */
  fun getMemInfoKotlin():Array<Number>{
    val activityManager = UTSAndroid.getUniActivity()?.getSystemService(ACTIVITY_SERVICE) as ActivityManager
    val memoryInfo = ActivityManager.MemoryInfo()
    activityManager.getMemoryInfo(memoryInfo)
    val availMem = memoryInfo.availMem / 1024 / 1024
    val totalMem = memoryInfo.totalMem / 1024 / 1024
    // availMem 可用内存，单位MB
    // totalMem 设备内存，单位MB
    // console.log(availMem,totalMem)
    return arrayOf(availMem,totalMem)
  }

  /**
   * 开始监听内存信息变化
   */
  fun onMemoryInfoChangeKotlin(callback: (Array<Number>) -> Unit){
    if(lastTaskId != -1){
      // 避免重复开启
      clearInterval(lastTaskId)
    }

    // 延迟1000ms，每2000ms 获取一次内存
    lastTaskId = setInterval({
      val activityManager = UTSAndroid.getUniActivity()?.getSystemService(ACTIVITY_SERVICE) as ActivityManager
      val memoryInfo = ActivityManager.MemoryInfo()
      activityManager.getMemoryInfo(memoryInfo)
      val availMem = memoryInfo.availMem / 1024 / 1024
      val totalMem = memoryInfo.totalMem / 1024 / 1024
      // availMem 可用内存，单位MB
      // totalMem 设备内存，单位MB
      // console.log(availMem,totalMem)
      callback(arrayOf(availMem,totalMem))
    },1000,2000)
  }

  /**
   * 停止监听内存信息变化
   */
  fun offMemoryInfoChangeKotlin(){
    if(lastTaskId != -1){
      // 避免重复开启
      clearInterval(lastTaskId)
    }
  }

}

