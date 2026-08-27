@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.nativeTimePicker
import android.widget.TimePicker
import io.dcloud.uniapp.*
import io.dcloud.uniapp.extapi.*
import io.dcloud.uniapp.framework.*
import io.dcloud.uniapp.runtime.*
import io.dcloud.uniapp.vue.*
import io.dcloud.uniapp.vue.shared.*
import io.dcloud.uts.*
import io.dcloud.uts.Map
import io.dcloud.uts.Set
import io.dcloud.uts.UTSAndroid
import kotlin.properties.Delegates
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
open class NativeTimePicker {
    open lateinit var `$element`: UniNativeViewElement
    constructor(element: UniNativeViewElement, hour: Number, minute: Number){
        this.`$element` = element
        this.bindView(hour, minute)
    }
    open var picker: TimePicker? = null
    open fun bindView(hour: Number, minute: Number) {
        this.picker = TimePicker(this.`$element`.getAndroidActivity()!!)
        this.`$element`.bindAndroidView(this.picker!!)
        this.setHour(hour)
        this.setMinute(minute)
        this.picker?.setOnTimeChangedListener(fun(_, hourOfDay, minute){
            val detail: UTSJSONObject = _uO("hour" to hourOfDay, "minute" to minute)
            val event = UniNativeViewEvent("timechanged", detail)
            this.`$element`.dispatchEvent(event)
        }
        )
    }
    open fun setHour(hour: Number) {
        this.picker?.setHour(hour.toInt())
    }
    open fun setMinute(minute: Number) {
        this.picker?.setMinute(minute.toInt())
    }
}
