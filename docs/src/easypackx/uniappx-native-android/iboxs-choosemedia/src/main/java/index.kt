@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.iboxsChoosemedia
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
import io.dcloud.uniapp.extapi.`$once` as uni__once
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
open class chooseOptions (
    open var type: String? = null,
    open var compress: Number? = null,
    @JsonNotNull
    open var count: Number,
    @JsonNotNull
    open var camera: Boolean = false,
    open var success: (res: UTSArray<UTSJSONObject>) -> Unit,
    open var fail: (res: String) -> Unit,
) : UTSObject()
open class previewMedia (
    @JsonNotNull
    open var type: String,
    @JsonNotNull
    open var uri: String,
) : UTSObject()
open class previewOptions (
    @JsonNotNull
    open var list: UTSArray<previewMedia>,
    open var index: Number? = null,
) : UTSObject()
typealias ChooseImage = (options: chooseOptions) -> Unit
typealias PreviewImage = (options: previewOptions) -> Unit
val chooseImage: ChooseImage = fun(options: chooseOptions): Unit {
    console.log("监听开始")
    uni__once("iboxs-choosemedia", fun(res: UTSArray<UTSJSONObject>) {
        console.log("收到回调", res)
        if (res.length < 1) {
            options.fail("cancel")
            return
        }
        options.success(res)
    }
    )
    var url = "/uni_modules/iboxs-choosemedia/pages/choose"
    var query = ""
    if (options.type != null) {
        query += "type=" + options.type + "&"
    }
    if (options.compress != null) {
        query += "compress=" + options.compress!! + "&"
    }
    if (options.count != 0) {
        query += "count=" + options.count + "&"
    }
    if (options.camera != null) {
        query += "camera=" + options.camera + "&"
    }
    if (query != "") {
        url += "?" + query
    }
    uni_navigateTo(NavigateToOptions(url = url, animationType = "slide-in-bottom"))
}
val previewImage: PreviewImage = fun(options: previewOptions): Unit {
    var url = "/uni_modules/iboxs-choosemedia/pages/preview"
    var list = options.list
    var json = JSON.stringify(list)
    json = encodeURIComponent(json) as String
    uni_navigateTo(NavigateToOptions(url = url + "?list=" + json + "&index=" + options.index, animationType = "slide-in-bottom"))
}
