package com.example.app_comm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build.VERSION
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.dcloud.uniapp.sdk.UniAppXSDK
import io.dcloud.uniapp.sdk.UniAppXSDKStartOptions

class MainActivity : AppCompatActivity() {
    private var selectedAnimationType = "auto"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        val spinner = findViewById<Spinner>(R.id.animateType)
        val items = arrayOf("auto", "none", "fade", "slide-in-right", "slide-in-left", "slide-in-top", "slide-in-bottom", "fade-in","zoom-out","zoom-fade-out","pop-in","custom")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : android.widget.AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: android.widget.AdapterView<*>, view: View?, position: Int, id: Long) {
                selectedAnimationType = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: android.widget.AdapterView<*>) {
            }
        }

        findViewById<View>(R.id.btn_goto).setOnClickListener {
            if (selectedAnimationType == "custom")
                UniAppXSDK.start(
                    UniAppXSDKStartOptions(
                        enterCustomAnimation = R.anim.uni_app_x_fade_in,
                        exitCustomAnimation = R.anim.uni_app_x_fade_out
                    ), this@MainActivity
                )
            else
                UniAppXSDK.start(
                    UniAppXSDKStartOptions(animationType = selectedAnimationType),
                    this@MainActivity
                )
            if (VERSION.SDK_INT >= 33) {
                registerReceiver(broadcast, IntentFilter("ACTION_TO_NATIVE"), null, null, RECEIVER_EXPORTED)
            } else {
                registerReceiver(broadcast, IntentFilter("ACTION_TO_NATIVE"))
            }
        }
    }

    private val broadcast = object : BroadcastReceiver() {
        val handler = Handler(Looper.getMainLooper())
        override fun onReceive(context: Context, intent: Intent) {
            if(intent.action == "ACTION_TO_NATIVE") {
                Toast.makeText(context, intent.getStringExtra("key"), Toast.LENGTH_SHORT).show()
                handler.postDelayed({
                    val inte = Intent("ACTION_FROM_NATIVE")
                    inte.putExtra("key", "接受来自原生的广播")
                    context.sendBroadcast(inte)
                }, 3000)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(broadcast)
    }
}