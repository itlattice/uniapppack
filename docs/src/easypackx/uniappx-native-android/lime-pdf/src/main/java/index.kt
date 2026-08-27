@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.limePdf
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.MotionEvent
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.github.barteksc.pdfviewer.PDFView
import com.github.barteksc.pdfviewer.listener.OnErrorListener
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener
import com.github.barteksc.pdfviewer.listener.OnPageScrollListener
import com.github.barteksc.pdfviewer.listener.OnTapListener
import com.github.barteksc.pdfviewer.util.FitPolicy
import com.shockwave.pdfium.PdfDocument
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
import java.io.File
import kotlin.collections.List
import kotlin.properties.Delegates
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import uts.sdk.modules.limePdf.R
import io.dcloud.uniapp.extapi.downloadFile as uni_downloadFile
import io.dcloud.uniapp.extapi.getFileSystemManager as uni_getFileSystemManager
import io.dcloud.uniapp.extapi.hideLoading as uni_hideLoading
open class RenderOptions (
    @JsonNotNull
    open var url: String,
    open var page: Number? = null,
    open var swipeHorizontal: Boolean? = null,
    open var password: String? = null,
    open var scrollView: Boolean? = null,
    open var backTop: Boolean? = null,
    open var zoomEnable: Boolean? = null,
    open var scrollEnable: Boolean? = null,
    open var spacing: Number? = null,
    open var renderType: String? = null,
    open var scale: Number? = null,
) : UTSObject()
open class OpenPDFOptions (
    @JsonNotNull
    open var url: String,
    open var page: Number? = null,
    open var swipeHorizontal: Boolean? = null,
    open var password: String? = null,
    open var scrollView: Boolean? = null,
    open var backTop: Boolean? = null,
    open var zoomEnable: Boolean? = null,
    open var scrollEnable: Boolean? = null,
    open var spacing: Number? = null,
    open var renderType: String? = null,
    open var scale: Number? = null,
    open var success: ((res: OpenPDFSuccess) -> Unit)? = null,
    open var fail: ((res: OpenPDFFail) -> Unit)? = null,
    open var complete: (() -> Unit)? = null,
) : UTSObject()
open class OpenPDFSuccess (
    @JsonNotNull
    open var page: Number,
    @JsonNotNull
    open var pageCount: Number,
) : UTSObject()
open class OpenPDFFail (
    @JsonNotNull
    open var errMsg: String,
) : UTSObject()
typealias OpenPDF = (options: OpenPDFOptions) -> Unit
typealias PDFErrorCode = Number
interface PDFError {
    var errCode: PDFErrorCode
    var errMsg: String
}
open class GetPDFInfoOptions (
    @JsonNotNull
    open var url: String,
    open var success: ((res: PDFInfoResult) -> Unit)? = null,
    open var fail: ((res: PDFError) -> Unit)? = null,
    open var complete: (() -> Unit)? = null,
) : UTSObject()
open class PDFInfoResult (
    @JsonNotNull
    open var pageCount: Number,
) : UTSObject()
open class RenderPageOptions (
    @JsonNotNull
    open var url: String,
    @JsonNotNull
    open var page: Number,
    open var dpi: Number? = null,
    open var format: String? = null,
    open var quality: Number? = null,
    open var asBase64: Boolean? = null,
    open var success: ((res: RenderPageResult) -> Unit)? = null,
    open var fail: ((res: PDFError) -> Unit)? = null,
    open var complete: (() -> Unit)? = null,
) : UTSObject()
open class RenderPageResult (
    @JsonNotNull
    open var path: String,
    @JsonNotNull
    open var width: Number,
    @JsonNotNull
    open var height: Number,
    @JsonNotNull
    open var page: Number,
    @JsonNotNull
    open var pageCount: Number,
) : UTSObject()
open class RenderPagesOptions (
    @JsonNotNull
    open var url: String,
    open var pages: UTSArray<Number>? = null,
    open var dpi: Number? = null,
    open var format: String? = null,
    open var quality: Number? = null,
    open var asBase64: Boolean? = null,
    open var success: ((res: RenderPagesResult) -> Unit)? = null,
    open var fail: ((res: PDFError) -> Unit)? = null,
    open var complete: (() -> Unit)? = null,
) : UTSObject()
open class RenderPagesResult (
    @JsonNotNull
    open var images: UTSArray<RenderPageResult>,
    @JsonNotNull
    open var pageCount: Number,
) : UTSObject()
var pdfActivityInstance: LimePDFFActivity? = null
var pdfOptions: OpenPDFOptions? = null
var pdfView: PDFView? = null
var totalPageCount: Int = 0
fun runOnUiThread(callback: () -> Unit): Unit {
    try {
        UTSAndroid.getDispatcher("main").async(fun(_) {
            callback()
        }
        , null)
    }
     catch (e: Throwable) {
        console.error("Run on UI thread error:", e)
        callback()
    }
}
@Suppress("DEPRECATION")
open class PDFLauncher : Runnable {
    override fun run() {
        val pdfIntent = Intent(UTSAndroid.getUniActivity(), LimePDFFActivity().javaClass)
        console.log("run")
        UTSAndroid.getUniActivity()!!.startActivityForResult(pdfIntent, 1)
    }
}
@Suppress("DEPRECATION")
fun launchPDFViewerImpl(options: OpenPDFOptions): Boolean {
    pdfOptions = options
    UTSAndroid.getUniActivity()!!.runOnUiThread(PDFLauncher())
    return true
}
open class LimePDFFActivity : Activity, OnLoadCompleteListener, OnPageChangeListener, OnTapListener, OnPageErrorListener, OnErrorListener, OnPageScrollListener {
    private var pdfContainer: RelativeLayout? = null
    private var pageIndicator: TextView? = null
    private var appContext: Context
    constructor() : super() {
        this.appContext = UTSAndroid.getAppContext() as Context
    }
    override fun onCreate(savedInstanceState: Bundle?): Unit {
        super.onCreate(savedInstanceState)
        pdfActivityInstance = this
        this.initializeUI()
        this.loadPDF()
    }
    private fun initializeUI() {
        val actionBar = this.getActionBar()
        if (actionBar != null) {
            actionBar.setTitle("PDF")
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setDisplayShowHomeEnabled(false)
        }
        val rootLayout = RelativeLayout(this.appContext)
        rootLayout.setBackgroundColor(Color.BLACK)
        rootLayout.setLayoutParams(RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
        this.pdfContainer = RelativeLayout(this.appContext)
        val containerParams = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        this.pdfContainer?.setLayoutParams(containerParams)
        this.pageIndicator = TextView(this.appContext)
        this.pageIndicator?.setText("0/0")
        this.pageIndicator?.setTextColor(Color.WHITE)
        this.pageIndicator?.setTextSize(12.toFloat())
        this.pageIndicator?.setPadding(16, 8, 16, 8)
        val indicatorBg = GradientDrawable()
        indicatorBg.setColor(Color.argb(180, 0, 0, 0))
        indicatorBg.setCornerRadius(16.toFloat())
        this.pageIndicator?.setBackground(indicatorBg)
        val indicatorParams = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        indicatorParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT)
        indicatorParams.addRule(RelativeLayout.ALIGN_PARENT_TOP)
        indicatorParams.setMargins(16, 16, 16, 16)
        this.pageIndicator?.setLayoutParams(indicatorParams)
        rootLayout.addView(this.pdfContainer!!)
        rootLayout.addView(this.pageIndicator!!)
        this.setContentView(rootLayout)
    }
    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        if (item.getItemId() == android.R.id.home) {
            this.closePDF()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    private fun loadPDF() {
        if (pdfOptions == null) {
            runOnUiThread(fun(){
                this.failCallback(OpenPDFFail(errMsg = "参数不能为空"))
            }
            )
            return
        }
        val actionBar = this.getActionBar()
        if (actionBar != null) {
            val path = pdfOptions!!.url
            val fileName = path.substring(path.lastIndexOf("/") + 1)
            actionBar.setTitle(fileName)
        }
        pdfView = PDFView(this.appContext, null)
        pdfContainer!!.addView(pdfView, RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
        this.renderPDFInternal()
    }
    private fun renderPDFInternal() {
        if (pdfOptions == null || pdfView == null) {
            return
        }
        val _ref = pdfOptions!!
        val path = _ref.url
        val tmp = _ref.page
        val defaultPage = if (tmp == null) {
            0
        } else {
            tmp
        }
        val _ref_swipeHorizontal = _ref.swipeHorizontal
        val swipeHorizontal = if (_ref_swipeHorizontal == null) {
            false
        } else {
            _ref_swipeHorizontal
        }
        val _ref_password = _ref.password
        val password = if (_ref_password == null) {
            ""
        } else {
            _ref_password
        }
        val _ref_scrollView = _ref.scrollView
        val scrollView = if (_ref_scrollView == null) {
            false
        } else {
            _ref_scrollView
        }
        val spacing = _ref.spacing
        if (path.startsWith("http") || path.startsWith("ftp")) {
            uni_downloadFile(DownloadFileOptions(url = path, success = fun(res) {
                var decodedPath = res.tempFilePath
                pdfOptions!!.url = decodedPath
                pdfActivityInstance!!.renderPDFInternal()
            }, fail = fun(err) {
                pdfOptions?.fail?.invoke(OpenPDFFail(errMsg = err.errMsg))
            }))
        } else {
            try {
                var _path = path
                if (path.startsWith("file://")) {
                    _path = path.substring(7)
                } else if (path.startsWith("unifile://")) {
                    _path = UTSAndroid.convert2AbsFullPath(path)
                } else if (!path.startsWith("/storage")) {
                    _path = UTSAndroid.getResourcePath(path)
                }
                val file = File(_path)
                if (!file.exists() && !_path.startsWith("/android_asset/")) {
                    runOnUiThread(fun(){
                        console.warn("【lime-pdf】pdf路径无效")
                        pdfOptions?.fail?.invoke(OpenPDFFail(errMsg = "pdf路径无效"))
                    }
                    )
                    return
                }
                val _spacing: Int? = spacing?.toInt()
                val view = if (_path.startsWith("/android_asset/")) {
                    pdfView!!.fromAsset(_path)
                } else {
                    pdfView!!.fromFile(file)
                }
                view.defaultPage(defaultPage.toInt()).onLoad(this).enableAnnotationRendering(true).enableAntialiasing(true).pageFitPolicy(if (swipeHorizontal) {
                    FitPolicy.HEIGHT
                } else {
                    FitPolicy.WIDTH
                }
                )
                if (_spacing != null) {
                    view.spacing(_spacing)
                }
                view.password(password).swipeHorizontal(swipeHorizontal).onTap(this).onPageChange(this).onPageError(this).onPageScroll(this).onError(this).load()
            }
             catch (e: Throwable) {
                runOnUiThread(fun(){
                    pdfOptions?.fail?.invoke(OpenPDFFail(errMsg = e.message ?: "加载失败"))
                }
                )
            }
        }
    }
    private fun failCallback(fail: OpenPDFFail) {
        runOnUiThread(fun(){
            pdfOptions?.fail?.invoke(fail)
            pdfOptions?.complete?.invoke()
            this.finish()
        }
        )
    }
    private fun closePDF() {
        pdfView?.recycle()
        pdfOptions?.complete?.invoke()
        pdfActivityInstance = null
        pdfOptions = null
        pdfView = null
        this.finish()
    }
    override fun onDestroy(): Unit {
        pdfView?.recycle()
        pdfActivityInstance = null
        pdfOptions = null
        pdfView = null
        super.onDestroy()
    }
    override fun onPageChanged(page: Int, pageCount: Int) {
        runOnUiThread(fun(){
            this.pageIndicator?.setText("" + (page + 1) + "/" + totalPageCount)
        }
        )
    }
    override fun onError(err: Throwable) {
        runOnUiThread(fun(){
            pdfOptions?.fail?.invoke(OpenPDFFail(errMsg = err.message ?: "加载失败"))
        }
        )
    }
    override fun onPageError(page: Int, err: Throwable) {
        runOnUiThread(fun(){
            pdfOptions?.fail?.invoke(OpenPDFFail(errMsg = err.message ?: "加载失败"))
        }
        )
    }
    override fun onTap(motionEvent: MotionEvent): Boolean {
        return true
    }
    override fun loadComplete(nbPages: Int) {
        runOnUiThread(fun(){
            totalPageCount = nbPages
            val meta = pdfView?.getDocumentMeta()
            val title = meta?.getTitle()
            if (title != null && title.length > 0) {
                val actionBar = this.getActionBar()
                if (actionBar != null) {
                    actionBar.setTitle(title)
                }
            }
            val currentPage = pdfView?.getCurrentPage() ?: 0
            this.pageIndicator?.setText("" + (currentPage + 1) + "/" + totalPageCount)
            val success = OpenPDFSuccess(page = pdfOptions?.page ?: 0, pageCount = nbPages.toInt())
            pdfOptions?.success?.invoke(success)
        }
        )
    }
    override fun onPageScrolled(p0: Int, p1: Float) {}
}
fun jumpToPageImpl(page: Number): Unit {
    pdfView?.jumpTo(page.toInt(), true)
}
fun nextPageImpl(): Unit {
    if (pdfView == null) {
        return
    }
    val currentPage = pdfView?.getCurrentPage() ?: 0
    pdfView?.jumpTo(currentPage + 1, true)
}
fun prevPageImpl(): Unit {
    if (pdfView == null) {
        return
    }
    val currentPage = pdfView?.getCurrentPage() ?: 0
    pdfView?.jumpTo(currentPage - 1, true)
}
val ERR_INVALID_PARAM: PDFErrorCode = 9020001
val ERR_FILE_NOT_FOUND: PDFErrorCode = 9020002
val ERR_RENDER_FAILED: PDFErrorCode = 9020003
val ERR_PAGE_OUT_OF_RANGE: PDFErrorCode = 9020004
val errMsgMap: Map<PDFErrorCode, String> = Map(_uA(
    _uA(
        ERR_INVALID_PARAM,
        "无效参数"
    ),
    _uA(
        ERR_FILE_NOT_FOUND,
        "文件不存在"
    ),
    _uA(
        ERR_RENDER_FAILED,
        "渲染失败"
    ),
    _uA(
        ERR_PAGE_OUT_OF_RANGE,
        "页码超出范围"
    )
))
open class PDFErrorImpl : PDFError {
    override lateinit var errCode: PDFErrorCode
    override lateinit var errMsg: String
    constructor(errCode: Number, errMsg: String? = null){
        this.errCode = errCode as PDFErrorCode
        this.errMsg = errMsg ?: (errMsgMap.get(errCode as PDFErrorCode) ?: "未知错误")
    }
}
fun resolveFilePath(path: String): String {
    if (path.startsWith("http") || path.startsWith("ftp")) {
        return path
    }
    var uri = path
    if (uri.startsWith("file://")) {
        uri = uri.substring(7)
    } else if (uri.startsWith("unifile://")) {
        uri = UTSAndroid.convert2AbsFullPath(uri)
    } else if (!uri.startsWith("/storage")) {
        uri = UTSAndroid.getResourcePath(uri)
    }
    return uri
}
fun getPDFInfoImpl(options: GetPDFInfoOptions): Unit {
    val url = options.url
    val success = options.success
    val fail = options.fail
    val complete = options.complete
    val resolvedPath = resolveFilePath(url)
    LimePdfNative.getPageCount(resolvedPath, fun(isSuccess: Boolean, pageCount: Int, errMsg: String){
        if (isSuccess) {
            success?.invoke(PDFInfoResult(pageCount = UTSNumber.from(pageCount)))
        } else {
            fail?.invoke(PDFErrorImpl(UTSNumber.from(pageCount), errMsg))
        }
        complete?.invoke()
    }
    )
}
fun renderPageImpl(options: RenderPageOptions): Unit {
    val url = options.url
    val page = options.page
    val dpi = options.dpi
    val format = options.format
    val quality = options.quality
    val asBase64 = options.asBase64
    val success = options.success
    val fail = options.fail
    val complete = options.complete
    val renderDpi = dpi ?: 150
    val renderFormat = format ?: "png"
    val renderQuality = quality ?: 90
    val renderAsBase64 = asBase64 ?: true
    val resolvedPath = resolveFilePath(url)
    LimePdfNative.renderPage(resolvedPath, page.toInt(), renderDpi.toInt(), renderFormat, renderQuality.toInt(), renderAsBase64, fun(isSuccess: Boolean, data: String, width: Int, height: Int, pageNum: Int, pageCount: Int, extra: Int, extraStr: String){
        if (isSuccess) {
            val result = RenderPageResult(path = if (renderAsBase64 && extraStr != null && extraStr.length > 0) {
                extraStr
            } else {
                data
            }, width = UTSNumber.from(width), height = UTSNumber.from(height), page = UTSNumber.from(pageNum), pageCount = UTSNumber.from(pageCount))
            success?.invoke(result)
        } else {
            fail?.invoke(PDFErrorImpl(UTSNumber.from(extra), if (data.length > 0) {
                data
            } else {
                extraStr
            }
            ))
        }
        complete?.invoke()
    }
    )
}
fun renderPagesImpl(options: RenderPagesOptions): Unit {
    val url = options.url
    val pages = options.pages
    val dpi = options.dpi
    val format = options.format
    val quality = options.quality
    val asBase64 = options.asBase64
    val success = options.success
    val fail = options.fail
    val complete = options.complete
    val renderDpi = dpi ?: 150
    val renderFormat = format ?: "png"
    val renderQuality = quality ?: 90
    val renderAsBase64 = asBase64 ?: true
    val resolvedPath = resolveFilePath(url)
    val pagesArray = if (pages != null) {
        pages!!.map(fun(p: Number): Int {
            return p.toInt()
        }).toIntArray()
    } else {
        null
    }
    LimePdfNative.renderPages(resolvedPath, pagesArray, renderDpi.toInt(), renderFormat, renderQuality.toInt(), renderAsBase64, fun(isSuccess: Boolean, results: UTSArray<UTSJSONObject>, pageCount: Int, errCode: Int, errMsg: String){
        if (isSuccess) {
            val images: UTSArray<RenderPageResult> = _uA()
            for(item in resolveUTSKeyIterator(results)){
                val imgResult = RenderPageResult(path = if (renderAsBase64 && item["base64"] != null) {
                    item["base64"] as String
                } else {
                    item["path"] as String
                }, width = item["width"] as Number, height = item["height"] as Number, page = item["page"] as Number, pageCount = UTSNumber.from(pageCount))
                images.push(imgResult)
            }
            success?.invoke(RenderPagesResult(images = images, pageCount = UTSNumber.from(pageCount)))
        } else {
            fail?.invoke(PDFErrorImpl(UTSNumber.from(errCode), errMsg))
        }
        complete?.invoke()
    }
    )
}
fun isAsset(path: String): Boolean {
    return path.startsWith("/android_asset/")
}
fun coverBookmark(list: List<PdfDocument.Bookmark>?): UTSArray<UTSJSONObject> {
    var bookList: UTSArray<UTSJSONObject> = _uA()
    list?.forEach(fun(bookmark: PdfDocument.Bookmark){
        val item: UTSJSONObject = _uO("title" to bookmark.getTitle(), "pageNum" to bookmark.getPageIdx(), "children" to coverBookmark(bookmark.getChildren()))
        bookList.push(item)
    }
    )
    return bookList
}
open class LimePDF : OnPageChangeListener, OnTapListener, OnPageErrorListener, OnLoadCompleteListener, OnErrorListener, OnPageScrollListener {
    open lateinit var `$element`: UniNativeViewElement
    constructor(element: UniNativeViewElement){
        this.`$element` = element
        this.bindView()
    }
    open var pdfView: PDFView? = null
    open var timer: Number = -1
    open fun bindView() {
        this.pdfView = PDFView(this.`$element`.getAndroidActivity()!!, null)
        this.`$element`.bindAndroidView(this.pdfView!!)
    }
    open fun getPageSize(): UTSArray<Number> {
        val current = this.pdfView?.getCurrentPage() ?: 0
        val count = this.pdfView?.getPageCount() ?: 0
        return _uA(
            current,
            count
        )
    }
    open fun moveTo(offsetX: Number, offsetY: Number) {
        this.pdfView?.moveTo(offsetX.toFloat(), offsetY.toFloat())
        val o = this.pdfView!!.getPositionOffset()
        this.pdfView?.setPositionOffset(o)
    }
    open fun nextPage() {
        val current = this.pdfView?.getCurrentPage() ?: 0
        this.jumpTo(current + 1)
    }
    open fun prevPage() {
        val current = this.pdfView?.getCurrentPage() ?: 0
        this.jumpTo(current - 1)
    }
    open fun jumpTo(page: Number) {
        this.pdfView?.jumpTo(page.toInt(), true)
    }
    open fun getCategory(): UTSArray<UTSJSONObject> {
        var list = this.pdfView?.getTableOfContents()
        return coverBookmark(list)
    }
    open fun getDocumentMeta(): UTSJSONObject {
        val meta = this.pdfView?.getDocumentMeta()
        val title = meta?.getTitle() ?: ""
        val author = meta?.getAuthor() ?: ""
        val subject = meta?.getSubject() ?: ""
        val keywords = meta?.getKeywords() ?: ""
        val creator = meta?.getCreator() ?: ""
        val producer = meta?.getProducer() ?: ""
        val creationDate = meta?.getCreationDate() ?: ""
        val modDate = meta?.getModDate() ?: ""
        return _uO("title" to title, "author" to author, "subject" to subject, "keywords" to keywords, "creator" to creator, "producer" to producer, "creationDate" to creationDate, "modDate" to modDate)
    }
    open fun render(options: RenderOptions) {
        val path = options.url
        val tmp = options.page
        val defaultPage = if (tmp == null) {
            0
        } else {
            tmp
        }
        val _options_swipeHorizontal = options.swipeHorizontal
        val swipeHorizontal = if (_options_swipeHorizontal == null) {
            false
        } else {
            _options_swipeHorizontal
        }
        val _options_password = options.password
        val password = if (_options_password == null) {
            ""
        } else {
            _options_password
        }
        val _options_scrollView = options.scrollView
        val scrollView = if (_options_scrollView == null) {
            false
        } else {
            _options_scrollView
        }
        val spacing = options.spacing
        if (path.startsWith("http") || path.startsWith("ftp")) {
            if (this.cacheUrl.has(path)) {
                val _path = this.cacheUrl.get(path)!!
                val file = File(_path)
                if (file.exists()) {
                    uni_hideLoading(null)
                    this.render(RenderOptions(url = _path, page = defaultPage, swipeHorizontal = swipeHorizontal, password = password))
                    return
                }
            }
            uni_downloadFile(DownloadFileOptions(url = path, success = fun(res) {
                uni_hideLoading(null)
                var decodedPath = res.tempFilePath
                this.cacheUrl.set(path, decodedPath)
                this.render(RenderOptions(url = decodedPath, page = defaultPage, swipeHorizontal = swipeHorizontal, password = password, scrollView = scrollView, spacing = spacing))
            }, fail = fun(err) {
                uni_hideLoading(null)
                this.emit("fail", _uO("errMsg" to err.errMsg))
            }))
        } else {
            try {
                if (this.pdfView == null) {
                    this.emit("fail", _uO("errMsg" to "未初始化"))
                    return
                }
                var _path = path
                if (path.startsWith("file://")) {
                    _path = path.substring(7)
                } else if (path.startsWith("unifile://")) {
                    _path = UTSAndroid.convert2AbsFullPath(path)
                } else if (!path.startsWith("/storage")) {
                    _path = UTSAndroid.getResourcePath(path)
                }
                if (isAsset(_path)) {
                    var fileManager = uni_getFileSystemManager()
                    _path = "" + UTSAndroid.getAppCachePath() + path.substring(path.lastIndexOf("/") + 1)
                    fileManager.copyFileSync(path, _path)
                }
                val file = File(_path)
                if (!file.exists()) {
                    this.emit("fail", _uO("errMsg" to "pdf路径无效"))
                    return
                }
                val _spacing: Int? = spacing?.toInt()
                val view = this.pdfView!!.fromFile(file)
                view.defaultPage(defaultPage.toInt()).onLoad(this).enableAnnotationRendering(true).enableAntialiasing(true).autoSpacing(false).fitEachPage(true).pageFitPolicy(if (swipeHorizontal) {
                    FitPolicy.HEIGHT
                } else {
                    FitPolicy.WIDTH
                }
                )
                if (_spacing != null) {
                    view.spacing(_spacing)
                }
                view.password(password).swipeHorizontal(swipeHorizontal).onTap(this).onPageChange(this).onPageError(this).onPageScroll(this).onError(this).load()
            }
             catch (e: Throwable) {
                this.emit("fail", _uO("errMsg" to e.message))
            }
        }
    }
    override fun onPageChanged(page: Int, pageCount: Int) {
        this.emit("pageChanged", _uO("page" to page, "pageCount" to pageCount))
    }
    override fun onError(err: Throwable) {
        this.emit("fail", _uO("errMsg" to (err.message ?: "加载失败")))
    }
    override fun onPageError(page: Int, err: Throwable) {
        this.emit("fail", _uO("page" to page, "errMsg" to (err.message ?: "加载失败")))
    }
    override fun onTap(motionEvent: MotionEvent): Boolean {
        this.emit("click", _uO())
        return true
    }
    override fun loadComplete(nbPages: Int) {
        val category = this.getCategory()
        val meta = this.getDocumentMeta()
        val size = this.pdfView!!.getPageSize(0)
        this.emit("load", _uO("errMsg" to "加载成功", "page" to 0, "pageWidth" to size.width, "pageHeight" to size.height, "width" to this.pdfView!!.getWidth(), "height" to this.pdfView!!.getHeight(), "pageCount" to nbPages, "category" to category, "meta" to meta))
    }
    override fun onPageScrolled(p0: Int, p1: Float) {
        val p = this.pdfView?.getPositionOffset()
        val y = this.pdfView?.getCurrentYOffset()
        clearTimeout(this.timer)
        this.timer = setTimeout(fun(){
            this.emit("progress", _uO("value" to p, "y" to y))
        }
        , 100)
    }
    private var cacheUrl: Map<String, String> = Map<String, String>()
    private fun emit(type: String, detail: UTSJSONObject) {
        val event = UniNativeViewEvent(type, detail)
        this.`$element`.dispatchEvent(event)
    }
    open fun destroy() {
        this.pdfView?.recycle()
    }
}
val openPDF: OpenPDF = fun(options: OpenPDFOptions): Unit {
    launchPDFViewerImpl(options)
}
val jumpToPage = fun(page: Number): Unit {
    jumpToPageImpl(page)
}
val nextPage = fun(): Unit {
    nextPageImpl()
}
val prevPage = fun(): Unit {
    prevPageImpl()
}
val getPDFInfo = fun(options: GetPDFInfoOptions){
    getPDFInfoImpl(options)
}
val renderPage = fun(options: RenderPageOptions): Unit {
    renderPageImpl(options)
}
val renderPages = fun(options: RenderPagesOptions): Unit {
    renderPagesImpl(options)
}
