package com.example.app_comm

import android.app.Application
import android.content.res.Configuration
import io.dcloud.uniapp.sdk.UniAppXApplication

/**
 * 注意：如果不继承UniApplication时，UniAppXApplication中的三个方法必须全部调用。
 */
class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        UniAppXApplication.onCreate(this)
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        UniAppXApplication.onTrimMemory(level)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        UniAppXApplication.onConfigurationChanged(newConfig)
    }
}