package com.example.uniappx_native_package

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import io.dcloud.uniapp.UniAppActivity
import io.dcloud.uniapp.sdk.UniAppXSDK
import io.dcloud.uniapp.sdk.UniAppXSDKStartOptions

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        findViewById<View>(R.id.btn_goto).setOnClickListener {
            UniAppXSDK.start(null, this@MainActivity)
        }

        findViewById<View>(R.id.btn_go_view).setOnClickListener {
            UniAppXSDK.start(UniAppXSDKStartOptions(animationType = "slide-in-top", appScheme = "uniappx://redirect/pages/component/view/view"), this@MainActivity)
        }
    }
}