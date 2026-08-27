@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.limeSvg
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.drawable.PictureDrawable
import android.util.Base64
import android.widget.ImageView
import com.caverock.androidsvg.SVG
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
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader
import kotlin.properties.Delegates
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
var svgDataURLPrefix = "data:image/svg+xml"
fun readFileToRaw(br: BufferedReader): String? {
    var line: String? = br.readLine()
    var lines: UTSArray<String> = _uA()
    while(line != null){
        lines.push(line)
        line = br.readLine()
    }
    br.close()
    if (lines.length > 0) {
        return lines.join("")
    }
    return null
}
fun fileToRaw(file: String): String? {
    try {
        val br = BufferedReader(InputStreamReader(FileInputStream(file)))
        return readFileToRaw(br)
    }
     catch (e: Throwable) {
        return null
    }
}
fun getResourcePath(path: String): String? {
    var uri = path
    if (uri.startsWith("http") || uri.startsWith("<svg") || uri.startsWith(svgDataURLPrefix) || uri.startsWith("<?xml")) {
        return uri
    }
    if (uri.startsWith("file://")) {
        uri = uri.substring(7)
    } else if (uri.startsWith("unifile://")) {
        uri = uri.substring(10)
    } else {
        uri = UTSAndroid.convert2AbsFullPath(uri)
        if (uri.startsWith("/android_asset/")) {
            uri = uri.replace("/android_asset/", "")
            try {
                val context = UTSAndroid.getUniActivity()!!
                val inputStream = context.getResources()!!.getAssets().open(uri)
                val br = BufferedReader(InputStreamReader(inputStream))
                return readFileToRaw(br)
            }
             catch (e: Throwable) {
                return null
            }
        }
    }
    if (File(uri).exists()) {
        return uri
    } else {
        return null
    }
}
fun processSvgString(path: String): String {
    var svgString = path
    if (path.startsWith(svgDataURLPrefix) && path.includes("base64")) {
        val base64Data = path.split("base64,")[1]
        val decodedData = Base64.decode(base64Data, Base64.DEFAULT)
        svgString = String(decodedData)
    }
    val svgDataURL = "" + svgDataURLPrefix + ","
    if (svgString.startsWith(svgDataURL)) {
        svgString = decodeURIComponent(svgString.replace(svgDataURL, "")) ?: ""
    }
    svgString = svgString.replace(UTSRegExp("<svg[^>]+", ""), fun(match: String, offset: Number, string: String): String {
        return match.replace(UTSRegExp("\\s(width|height)=\"(\\d+(\\.\\d+)?)([a-z]+)?\"", "gm"), "")
    }
    )
    return svgString.replace(UTSRegExp("[\\t\\r\\n]", "g"), "")
}
fun clampValue(value: Number, min: Number = 1000, max: Number = 512): Number {
    return Math.min(Math.max(value, min), max)
}
fun parseRgbaToColor(color: String): Int {
    if (color.startsWith("rgb")) {
        val matcher = color.match(UTSRegExp("\\d+(\\.\\d+)?", ""))
        var r: Number = 0
        var g: Number = 0
        var b: Number = 0
        var a: Number = 0
        if (matcher != null) {
            if (matcher.length > 0) {
                r = parseFloat(matcher[0] ?: "0")
            }
            if (matcher.length > 1) {
                g = parseFloat(matcher[1] ?: "0")
            }
            if (matcher.length > 2) {
                b = parseFloat(matcher[2] ?: "0")
            }
            if (matcher.length > 3) {
                a = parseFloat(matcher[3] ?: "0")
            }
        }
        val hexColor = String.format("#%02X%02X%02X%02X", a * 255, r, g, b)
        return Color.parseColor(hexColor)
    }
    return Color.parseColor(color)
}
fun createColoredBitmap(drawable: PictureDrawable, color: String): Bitmap? {
    val width = clampValue(drawable.getPicture().getWidth() * 100).toInt()
    val height = clampValue(drawable.getPicture().getHeight() * 100).toInt()
    if (width == 0 || height == 0) {
        return null
    }
    val newBM = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
    val bmcanvas = Canvas(newBM)
    val targetColor = parseRgbaToColor(color)
    val colorMatrix = ColorMatrix()
    val r = Color.red(targetColor.toInt())
    val g = Color.green(targetColor.toInt())
    val b = Color.blue(targetColor.toInt())
    val targetColorMatrix = _uA(
        1,
        0,
        0,
        0,
        r,
        0,
        1,
        0,
        0,
        g,
        0,
        0,
        1,
        0,
        b,
        0,
        0,
        0,
        1,
        0
    ).toKotlinList().map(fun(it): Float {
        return it.toFloat()
    }
    ).toFloatArray()
    colorMatrix.postConcat(ColorMatrix(targetColorMatrix))
    val colorFilter = ColorMatrixColorFilter(colorMatrix)
    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    paint.setAntiAlias(true)
    paint.setFilterBitmap(true)
    paint.setColorFilter(colorFilter)
    val srcRect = Rect(0, 0, width, height)
    drawable.setBounds(0, 0, width, height)
    drawable.draw(bmcanvas)
    bmcanvas.drawBitmap(newBM, srcRect, srcRect, paint)
    return newBM
}
open class NativeImage {
    open lateinit var `$element`: UniNativeViewElement
    open var svg: SVG? = null
    open var imageView: ImageView? = null
    open var color: String? = null
    open var svgMap: Map<String, SVG> = Map<String, SVG>()
    constructor(element: UniNativeViewElement){
        this.`$element` = element
        this.bindView()
    }
    open fun bindView() {
        this.imageView = ImageView(this.`$element`.getAndroidActivity()!!, null)
        this.`$element`.bindAndroidView(this.imageView!!)
    }
    private fun emit(type: String, detail: UTSJSONObject) {
        val event = UniNativeViewEvent(type, detail)
        this.`$element`.dispatchEvent(event)
    }
    private fun update() {
        if (this.svg == null) {
            return
        }
        val drawable = PictureDrawable(this.svg!!.renderToPicture())
        if (this.color == null || this.color!!.length == 0) {
            this.imageView?.setImageDrawable(drawable)
        } else {
            val newBM = createColoredBitmap(drawable, this.color!!)
            if (newBM == null) {
                return
            }
            this.imageView?.setImageBitmap(newBM)
        }
    }
    open fun updateSrc(src: String) {
        val path = getResourcePath(src)
        if (path == null) {
            return
        }
        try {
            if (this.svgMap.has(src)) {
                this.svg = this.svgMap.get(src)!!
            } else if (path!!.startsWith("<?xml") || path!!.startsWith("<svg") || path!!.startsWith(svgDataURLPrefix)) {
                val svgStr = processSvgString(path)
                this.svg = SVG.getFromString(svgStr)
                this.svgMap.set(src, this.svg!!)
            } else {
                val raw = fileToRaw(path)
                if (raw == null) {
                    return
                }
                val svgStr = processSvgString(raw)
                this.svg = SVG.getFromString(svgStr)
                this.svgMap.set(src, this.svg!!)
            }
            this.emit("load", _uO("width" to this.svg!!.getDocumentViewBox().width(), "height" to this.svg!!.getDocumentViewBox().height()))
            this.update()
        }
         catch (e: Throwable) {
            this.emit("error", _uO("errMsg" to e.message))
        }
    }
    open fun updateColor(color: String) {
        this.color = color
        this.update()
    }
    open fun destroy() {}
}
