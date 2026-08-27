@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.iboxsNfc
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.itgz8.scannfc.NFCScanningActivity
import com.itgz8.scannfc.ScanConfig
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
open class NFCCardScanResult (
    open var result: UTSArray<NFCCardResult>? = null,
    @JsonNotNull
    open var state: Boolean = false,
) : UTSObject()
open class NFCCardResult (
    @JsonNotNull
    open var sector: Number,
    open var errorMsg: String? = null,
    @JsonNotNull
    open var state: Boolean = false,
    open var blocks: UTSArray<BlockData>? = null,
) : UTSObject()
open class BlockData (
    @JsonNotNull
    open var block: Number,
    open var data: String? = null,
) : UTSObject()
typealias InitNFC = () -> Boolean
typealias IsNFCEnabled = () -> Boolean
typealias ReadCard = (customKey: String, success: (res: NFCCardScanResult) -> Unit, error: (msg: String) -> Unit) -> Unit
val readCard: ReadCard = fun(customKey: String, success: (res: NFCCardScanResult) -> Unit, error: (msg: String) -> Unit) {
    ScanConfig.success = fun(json: String) {
        console.log("NFC扫描成功：" + json)
        var result = _uA<NFCCardResult>()
        var data = JSON.parseArray(json) as UTSArray<UTSJSONObject>
        for(item in resolveUTSValueIterator(data)){
            var itemData = item as UTSJSONObject
            var it = NFCCardResult(sector = itemData["sector"] as Number, state = true)
            if (itemData["blocks"] != null) {
                var blocks = _uA<BlockData>()
                var blockList = itemData["blocks"] as UTSArray<UTSJSONObject>
                for(jitem in resolveUTSValueIterator(blockList)){
                    var bitem = BlockData(block = jitem["block"] as Number)
                    if (jitem["data"] != null) {
                        bitem.data = jitem["data"] as String
                    }
                    blocks.push(bitem)
                }
                it.blocks = blocks
            } else {
                it.state = false
                it.errorMsg = itemData["error"] as String
            }
            result.push(it)
        }
        var r = NFCCardScanResult(state = true, result = result)
        success(r)
    }
    ScanConfig.error = fun(errorMsg: String) {
        console.log("NFC扫描失败" + errorMsg)
        error(errorMsg)
    }
    ScanConfig.customKey = customKey
    NFCScanningActivity.setConfig(ScanConfig)
    var intent = NFCManager.startRead(UTSAndroid.getAppContext() as Context, ScanConfig) as Intent
    UTSAndroid.getUniActivity()!!.startActivity(intent)
}
val initNFC: InitNFC = fun(): Boolean {
    return NFCManager.init(UTSAndroid.getAppContext() as Context) as Boolean
}
val isNFCEnabled: IsNFCEnabled = fun(): Boolean {
    return NFCManager.isNFCEnabled() as Boolean
}
