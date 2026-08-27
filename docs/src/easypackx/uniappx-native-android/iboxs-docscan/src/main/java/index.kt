@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.iboxsDocscan
import android.content.Context
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
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
open class ScanOptions (
    open var success: (result: UTSJSONObject) -> Unit,
    open var fail: (error: UTSJSONObject) -> Unit,
) : UTSObject()
val startDocScan = fun(options: ScanOptions){
    uni_navigateTo(NavigateToOptions(url = "/uni_modules/iboxs-docscan/pages/docscan", animationType = "slide-in-bottom"))
}
val getDocCorner = fun(buffer: ArrayBuffer, height: Number, width: Number): UTSArray<Number> {
    var context = UTSAndroid.getAppContext() as Context
    var r = OpenCV.getDocCorner(context, buffer.toByteBuffer(), height, width, buffer.byteLength)
    var result = UTSArray<Number>()
    run {
        var i: Number = 0
        while(i < 8){
            result.push(r[i as Int] as Number)
            i++
        }
    }
    return result
}
