@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.iboxsOcr
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
import uts.sdk.modules.iboxsOcr.OCRManager.OCRResult
open class OCRRecognizeBlock (
    @JsonNotNull
    open var text: String,
    @JsonNotNull
    open var left: Number,
    @JsonNotNull
    open var top: Number,
    @JsonNotNull
    open var right: Number,
    @JsonNotNull
    open var bottom: Number,
) : UTSObject()
open class OCRRecognizeLabel (
    @JsonNotNull
    open var text: String,
    @JsonNotNull
    open var confidence: Number,
    @JsonNotNull
    open var index: Number,
) : UTSObject()
open class OCRRecognizeResult (
    @JsonNotNull
    open var text: String,
    @JsonNotNull
    open var blocks: UTSArray<OCRRecognizeBlock>,
    @JsonNotNull
    open var labels: UTSArray<OCRRecognizeLabel>,
) : UTSObject()
open class RecognizeOptions (
    @JsonNotNull
    open var imgPath: String,
    @JsonNotNull
    open var includeImageLabels: Boolean = false,
    open var onSuccess: (res: OCRRecognizeResult) -> Unit,
    open var onError: (String) -> Unit,
) : UTSObject()
val initOcr = fun(){
    API.init()
}
val recognizeImage = fun(options: RecognizeOptions){
    API.recognizeImage(options.imgPath, options.includeImageLabels, fun(res: OCRResult) {
        var blocks = _uA<OCRRecognizeBlock>()
        for(item in resolveUTSValueIterator(res.blocks)){
            blocks.push(OCRRecognizeBlock(text = item.text, left = item.left, top = item.top, right = item.right, bottom = item.bottom))
        }
        var labels = _uA<OCRRecognizeLabel>()
        for(label in resolveUTSValueIterator(res.labels)){
            labels.push(OCRRecognizeLabel(text = label.text, confidence = label.confidence, index = label.index))
        }
        var result = OCRRecognizeResult(text = res.text, blocks = blocks, labels = labels)
        options.onSuccess(result)
    }
    , fun(err: String) {
        options.onError(err)
    }
    )
}
