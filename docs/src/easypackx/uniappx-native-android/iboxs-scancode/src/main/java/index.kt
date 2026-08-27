@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.iboxsScancode
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.LifecycleOwner
import com.google.mlkit.vision.barcode.common.Barcode
import com.itgz8.scancode.BarcodeScanningActivity
import com.itgz8.scancode.QRCodeData
import com.itgz8.scancode.ResponseStateConfig
import com.itgz8.scancode.ScancodeConfig
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
import java.io.FileOutputStream
import java.io.IOException
import java.util.ArrayList
import kotlin.properties.Delegates
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import uts.sdk.modules.iboxsScancode.R
import io.dcloud.uniapp.extapi.`$emit` as uni__emit
import io.dcloud.uniapp.extapi.`$once` as uni__once
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
open class CommonResultCallback (
    @JsonNotNull
    open var statusCode: Number,
    @JsonNotNull
    open var message: String,
    @JsonNotNull
    open var data: Any,
) : UTSObject()
typealias QRCodeType = String
open class TypeText (
    @JsonNotNull
    open var text: String,
) : UTSObject()
open class TypeURL (
    @JsonNotNull
    open var url: String,
) : UTSObject()
open class TypeWIFI (
    @JsonNotNull
    open var ssid: String,
    @JsonNotNull
    open var password: String,
    @JsonNotNull
    open var type: String,
) : UTSObject()
open class TypePhone (
    @JsonNotNull
    open var number: String,
) : UTSObject()
open class TypeSms (
    @JsonNotNull
    open var number: String,
    @JsonNotNull
    open var message: String,
) : UTSObject()
open class TypeEmail (
    @JsonNotNull
    open var address: String,
    @JsonNotNull
    open var subject: String,
    @JsonNotNull
    open var body: String,
) : UTSObject()
open class TypeContact (
    @JsonNotNull
    open var name: String,
    @JsonNotNull
    open var address: String,
    @JsonNotNull
    open var phone: String,
    @JsonNotNull
    open var email: String,
) : UTSObject()
open class TypeGeo (
    @JsonNotNull
    open var latitude: String,
    @JsonNotNull
    open var longitude: String,
) : UTSObject()
open class TypeCalendar (
    @JsonNotNull
    open var summary: String,
    @JsonNotNull
    open var location: String,
    @JsonNotNull
    open var description: String,
    @JsonNotNull
    open var start: String,
    @JsonNotNull
    open var end: String,
) : UTSObject()
open class TypeDriverLicense (
    @JsonNotNull
    open var firstName: String,
    @JsonNotNull
    open var lastName: String,
    @JsonNotNull
    open var middleName: String,
    @JsonNotNull
    open var addressState: String,
    @JsonNotNull
    open var addressCity: String,
    @JsonNotNull
    open var addressStreet: String,
    @JsonNotNull
    open var addressZip: String,
    @JsonNotNull
    open var birthDate: String,
    @JsonNotNull
    open var documentType: String,
    @JsonNotNull
    open var expiryDate: String,
    @JsonNotNull
    open var gender: String,
    @JsonNotNull
    open var issueDate: String,
    @JsonNotNull
    open var licenseNumber: String,
    @JsonNotNull
    open var issuingCountry: String,
) : UTSObject()
open class SingleQRCodeData (
    @JsonNotNull
    open var type: QRCodeType,
    @JsonNotNull
    open var data: Any,
    @JsonNotNull
    open var value: String,
) : UTSObject()
open class CodeImage (
    open var uri: String? = null,
    open var centerX: Number? = null,
    open var centerY: Number? = null,
    open var left: Number? = null,
    open var top: Number? = null,
    open var right: Number? = null,
    open var bottom: Number? = null,
) : UTSObject()
open class ScanCodeResult (
    @JsonNotNull
    open var data: UTSArray<SingleQRCodeData>,
    open var image: CodeImage? = null,
) : UTSObject()
open class SuccessCallback (
    @JsonNotNull
    open var statusCode: Number,
    @JsonNotNull
    open var message: String,
    @JsonNotNull
    open var data: ScanCodeResult,
) : UTSObject()
open class OnBarcodeCallback (
    @JsonNotNull
    open var statusCode: Number,
    @JsonNotNull
    open var message: String,
    @JsonNotNull
    open var data: ScanCodeResult,
) : UTSObject()
open class ScanCodeConfig (
    open var title: String? = null,
    open var tip: String? = null,
    open var showTip: Boolean? = null,
    open var successTip: String? = null,
    open var failureTip: String? = null,
    open var exitText: String? = null,
    open var cancelText: String? = null,
    open var showFlash: Boolean? = null,
    open var flashOnText: String? = null,
    open var flashOffText: String? = null,
    open var flashOnColor: String? = null,
    open var flashOffColor: String? = null,
    open var flashOnTip: String? = null,
    open var flashOnTextColor: String? = null,
    open var flashOffTip: String? = null,
    open var flashOffTextColor: String? = null,
    open var showAlbum: Boolean? = null,
    open var showBack: Boolean? = null,
    open var showLine: Boolean? = null,
    open var lineDuration: Number? = null,
    open var needImage: Boolean? = null,
    open var vibrate: Boolean? = null,
    open var initZoomRatio: Number? = null,
    open var maxZoomRatio: Number? = null,
    open var autoFullScreen: Boolean? = null,
    open var touchZoom: Boolean? = null,
    open var doubleTapZoom: Boolean? = null,
    open var continuousScanning: Boolean? = null,
    open var batchScanning: Boolean? = null,
    open var markCircleRadius: Number? = null,
    open var markCircleColor: String? = null,
    open var markCircleStrokeColor: String? = null,
    open var markCircleStrokeWidth: Number? = null,
    open var markCircleAnimate: Boolean? = null,
    open var centerBarcode: Boolean? = null,
    open var backFinish: Boolean? = null,
    open var cancelFinish: Boolean? = null,
    open var showMask: Boolean? = null,
    open var maskColor: String? = null,
    open var maskAlpha: Number? = null,
    open var maskDuration: Number? = null,
    open var successFinish: Boolean? = null,
    open var beforeSuccess: ((callback: CommonResultCallback) -> Unit)? = null,
    open var success: ((callback: SuccessCallback) -> Unit)? = null,
    open var fail: ((callback: CommonResultCallback) -> Unit)? = null,
    open var complete: ((callback: CommonResultCallback) -> Unit)? = null,
    open var beforeCancel: (() -> Boolean)? = null,
    open var onCancel: (() -> Unit)? = null,
    open var onBack: (() -> Unit)? = null,
    open var onAlbum: (() -> Unit)? = null,
    open var onFlashOn: (() -> Unit)? = null,
    open var onFlashOff: (() -> Unit)? = null,
    open var onZoom: ((currentZoomRatio: Number) -> Unit)? = null,
    open var onDoubleTap: ((currentZoomRatio: Number) -> Unit)? = null,
    open var onContinuous: ((callback: SuccessCallback) -> Unit)? = null,
    open var onBarcode: ((callback: OnBarcodeCallback) -> Unit)? = null,
    open var onCameraPermissionDenied: (() -> Unit)? = null,
    open var onAlbumPermissionDenied: (() -> Unit)? = null,
    open var onOpenAlbum: (() -> Unit)? = null,
) : UTSObject()
open class SimpleCodeConfig (
    open var tip: String? = null,
    open var needImage: Boolean? = null,
    open var vibrate: Boolean? = null,
    open var success: ((res: SuccessCallback) -> Unit)? = null,
    open var fail: ((res: CommonResultCallback) -> Unit)? = null,
) : UTSObject()
open class MultiCodeClickConfig (
    open var tip: String? = null,
    open var needImage: Boolean? = null,
    open var vibrate: Boolean? = null,
    open var success: ((res: SuccessCallback) -> Unit)? = null,
    open var fail: ((res: CommonResultCallback) -> Unit)? = null,
    open var onClick: ((res: SuccessCallback) -> Unit)? = null,
) : UTSObject()
open class MultiCodeConfig (
    open var tip: String? = null,
    open var needImage: Boolean? = null,
    open var vibrate: Boolean? = null,
    open var success: ((res: SuccessCallback) -> Unit)? = null,
    open var fail: ((res: CommonResultCallback) -> Unit)? = null,
) : UTSObject()
val imageHandleItem = fun(image: String?, barcode: Barcode?): CodeImage? {
    if (image == null) {
        return null
    }
    var result: CodeImage? = null
    var centerX = barcode?.boundingBox?.centerX()
    var centerY = barcode?.boundingBox?.centerY()
    var left = barcode?.boundingBox?.left
    var top = barcode?.boundingBox?.top
    var right = barcode?.boundingBox?.right
    var bottom = barcode?.boundingBox?.bottom
    result = CodeImage(uri = image.toString(), centerX = centerX, centerY = centerY, left = left, top = top, right = right, bottom = bottom)
    return result
}
val imageHandle = fun(item: QRCodeData): CodeImage? {
    var result: CodeImage? = null
    if (item is QRCodeData.Text) {
        var image = item.codeInfo.bitmap
        var barcode = item.codeInfo.barcode
        return imageHandleItem(image, barcode)
    }
    if (item is QRCodeData.Url) {
        var image = item.codeInfo.bitmap
        var barcode = item.codeInfo.barcode
        return imageHandleItem(image, barcode)
    }
    if (item is QRCodeData.Wifi) {
        var image = item.codeInfo.bitmap
        var barcode = item.codeInfo.barcode
        return imageHandleItem(image, barcode)
    }
    if (item is QRCodeData.Phone) {
        var image = item.codeInfo.bitmap
        var barcode = item.codeInfo.barcode
        return imageHandleItem(image, barcode)
    }
    if (item is QRCodeData.Sms) {
        var image = item.codeInfo.bitmap
        var barcode = item.codeInfo.barcode
        return imageHandleItem(image, barcode)
    }
    if (item is QRCodeData.Email) {
        var image = item.codeInfo.bitmap
        var barcode = item.codeInfo.barcode
        return imageHandleItem(image, barcode)
    }
    if (item is QRCodeData.Contact) {
        var image = item.codeInfo.bitmap
        var barcode = item.codeInfo.barcode
        return imageHandleItem(image, barcode)
    }
    if (item is QRCodeData.Geo) {
        var image = item.codeInfo.bitmap
        var barcode = item.codeInfo.barcode
        return imageHandleItem(image, barcode)
    }
    if (item is QRCodeData.Calendar) {
        var image = item.codeInfo.bitmap
        var barcode = item.codeInfo.barcode
        return imageHandleItem(image, barcode)
    }
    if (item is QRCodeData.DriverLicense) {
        var image = item.codeInfo.bitmap
        var barcode = item.codeInfo.barcode
        return imageHandleItem(image, barcode)
    }
    return result
}
val resultHandle = fun(item: QRCodeData): SingleQRCodeData {
    var result: SingleQRCodeData? = null
    if (item is QRCodeData.Text) {
        result = SingleQRCodeData(type = "text", data = TypeText(text = "" + item.text), value = item.codeInfo.rawValue as String)
    }
    if (item is QRCodeData.Url) {
        console.log(item.codeInfo.bitmap)
        var filepath = ""
        if (item.codeInfo.bitmap != null) {
            console.log(item.codeInfo.bitmap)
            uni__emit("image", item.codeInfo.bitmap)
        }
        console.log(filepath)
        result = SingleQRCodeData(type = "url", data = TypeURL(url = "" + item.url), value = item.codeInfo.rawValue as String)
    }
    if (item is QRCodeData.Wifi) {
        result = SingleQRCodeData(type = "wifi", data = TypeWIFI(ssid = "" + item.ssid, password = "" + item.password, type = "" + item.type), value = item.codeInfo.rawValue as String)
    }
    if (item is QRCodeData.Phone) {
        result = SingleQRCodeData(type = "phone", data = TypePhone(number = "" + item.number), value = item.codeInfo.rawValue as String)
    }
    if (item is QRCodeData.Sms) {
        result = SingleQRCodeData(type = "sms", data = TypeSms(number = "" + item.number, message = "" + item.message), value = item.codeInfo.rawValue as String)
    }
    if (item is QRCodeData.Email) {
        result = SingleQRCodeData(type = "email", data = TypeEmail(address = "" + item.address, subject = "" + item.subject, body = "" + item.body), value = item.codeInfo.rawValue as String)
    }
    if (item is QRCodeData.Contact) {
        result = SingleQRCodeData(type = "contact", data = TypeContact(name = "" + item.name, address = "" + item.address, phone = "" + item.phone, email = "" + item.email), value = item.codeInfo.rawValue as String)
    }
    if (item is QRCodeData.Geo) {
        result = SingleQRCodeData(type = "geo", data = TypeGeo(latitude = "" + item.latitude, longitude = "" + item.longitude), value = item.codeInfo.rawValue as String)
    }
    if (item is QRCodeData.Calendar) {
        result = SingleQRCodeData(type = "calendar", data = TypeCalendar(summary = "" + item.summary, location = "" + item.location, description = "" + item.description, start = "" + item.start, end = "" + item.end), value = item.codeInfo.rawValue as String)
    }
    if (item is QRCodeData.DriverLicense) {
        result = SingleQRCodeData(type = "driverLicense", data = TypeDriverLicense(firstName = "" + item.firstName, lastName = "" + item.lastName, middleName = "" + item.middleName, addressState = "" + item.addressState, addressCity = "" + item.addressCity, addressStreet = "" + item.addressStreet, addressZip = "" + item.addressZip, birthDate = "" + item.birthDate, documentType = "" + item.documentType, expiryDate = "" + item.documentType, gender = "" + item.gender, issueDate = "" + item.issueDate, licenseNumber = "" + item.licenseNumber, issuingCountry = "" + item.issuingCountry), value = item.codeInfo.rawValue as String)
    }
    return result as SingleQRCodeData
}
fun configInit(config: ScanCodeConfig = ScanCodeConfig()) {
    ScancodeConfig.title = config.title ?: "扫一扫"
    ScancodeConfig.tip = config.tip ?: "正在扫描，请稍候"
    ScancodeConfig.showTip = config.showTip ?: true
    ScancodeConfig.successTip = config.successTip ?: "扫描成功"
    ScancodeConfig.failureTip = config.failureTip ?: "扫描失败，请重试"
    ScancodeConfig.exitText = config.exitText ?: ""
    ScancodeConfig.cancelText = config.cancelText ?: "取消"
    ScancodeConfig.showFlash = config.showFlash ?: true
    ScancodeConfig.needImage = config.needImage ?: false
    ScancodeConfig.flashOnText = config.flashOnText ?: "轻触关闭"
    ScancodeConfig.flashOffText = config.flashOffText ?: "轻触照亮"
    ScancodeConfig.flashOnColor = config.flashOnColor ?: "#00BC79"
    ScancodeConfig.flashOffColor = config.flashOffColor ?: "#FFFFFF"
    ScancodeConfig.flashOnTip = config.flashOnTip ?: "闪光灯已打开"
    ScancodeConfig.flashOnTextColor = config.flashOnTextColor ?: "#00BC79"
    ScancodeConfig.flashOffTip = config.flashOffTip ?: "闪光灯已关闭"
    ScancodeConfig.flashOffTextColor = config.flashOffTextColor ?: "#FFFFFF"
    ScancodeConfig.showAlbum = config.showAlbum ?: false
    ScancodeConfig.showBack = config.showBack ?: true
    ScancodeConfig.showLine = config.showLine ?: true
    ScancodeConfig.lineDuration = (config.lineDuration ?: 3000).toLong()
    ScancodeConfig.vibrate = config.vibrate ?: true
    ScancodeConfig.initZoomRatio = (config.initZoomRatio ?: 1.0).toFloat()
    ScancodeConfig.maxZoomRatio = (config.maxZoomRatio ?: 5.0).toFloat()
    ScancodeConfig.autoFullScreen = config.autoFullScreen ?: true
    ScancodeConfig.touchZoom = config.touchZoom ?: true
    ScancodeConfig.doubleTapZoom = config.doubleTapZoom ?: true
    ScancodeConfig.continuousScanning = config.continuousScanning ?: false
    ScancodeConfig.batchScanning = config.batchScanning ?: true
    ScancodeConfig.markCircleRadius = (config.markCircleRadius ?: 50).toFloat()
    ScancodeConfig.markCircleColor = config.markCircleColor ?: "#00BC79"
    ScancodeConfig.markCircleStrokeColor = config.markCircleStrokeColor ?: "#FFFFFF"
    ScancodeConfig.markCircleStrokeWidth = (config.markCircleStrokeWidth ?: 3.0).toFloat()
    ScancodeConfig.markCircleAnimate = config.markCircleAnimate ?: true
    ScancodeConfig.centerBarcode = config.centerBarcode ?: true
    ScancodeConfig.backFinish = config.backFinish ?: true
    ScancodeConfig.cancelFinish = config.cancelFinish ?: false
    ScancodeConfig.showMask = config.showMask ?: true
    ScancodeConfig.maskColor = config.maskColor ?: "#80000000"
    ScancodeConfig.maskAlpha = (config.maskAlpha ?: 0.5).toFloat()
    ScancodeConfig.maskDuration = (config.maskDuration ?: 300).toLong()
    ScancodeConfig.beforeSuccess = null
    if (config.beforeSuccess != null) {
        val beforeSuccess = config.beforeSuccess!!
        ScancodeConfig.beforeSuccess = fun(callback: ResponseStateConfig){
            beforeSuccess?.invoke(callback as CommonResultCallback)
        }
    }
    ScancodeConfig.onSuccess = null
    if (config.success != null) {
        val success = config.success!!
        ScancodeConfig.onSuccess = fun(res: ResponseStateConfig){
            var response = SuccessCallback(statusCode = 200, message = "扫码识别成功", data = ScanCodeResult(data = _uA<SingleQRCodeData>()))
            var qrCodeData: UTSArray<SingleQRCodeData> = _uA()
            var image: CodeImage? = null
            (res.data as ArrayList<QRCodeData>).forEach(fun(item: QRCodeData){
                qrCodeData.push(resultHandle(item))
                image = imageHandle(item)
            }
            )
            var resData: ScanCodeResult = ScanCodeResult(data = qrCodeData, image = image)
            response.data = resData
            success?.invoke(response)
            if (config.successFinish != null && config.successFinish === true) {
                (UTSAndroid.getUniActivity() as BarcodeScanningActivity).close()
            }
        }
    }
    ScancodeConfig.onFailure = null
    if (config.fail != null) {
        val failure = config.fail!!
        ScancodeConfig.onFailure = fun(callback: ResponseStateConfig){
            var response = CommonResultCallback(statusCode = 500, message = "扫码识别失败", data = callback.data)
            failure?.invoke(response)
        }
    }
    ScancodeConfig.onComplete = null
    if (config.complete != null) {
        val complete = config.complete!!
        ScancodeConfig.onComplete = fun(callback: ResponseStateConfig){
            var response = CommonResultCallback(statusCode = 200, message = "扫码识别完成", data = callback.data)
            complete?.invoke(response)
        }
    }
    ScancodeConfig.onCancel = null
    if (config.onCancel != null) {
        val onCancel = config.onCancel!!
        ScancodeConfig.onCancel = fun(){
            onCancel?.invoke()
        }
    }
    ScancodeConfig.onBack = null
    if (config.onBack != null) {
        val onBack = config.onBack!!
        ScancodeConfig.onBack = fun(){
            onBack?.invoke()
        }
    }
    ScancodeConfig.onAlbum = null
    if (config.onAlbum != null) {
        val onAlbum = config.onAlbum!!
        ScancodeConfig.onAlbum = fun(){
            onAlbum?.invoke()
        }
    }
    ScancodeConfig.onFlashOn = null
    if (config.onFlashOn != null) {
        val onFlashOn = config.onFlashOn!!
        ScancodeConfig.onFlashOn = fun(){
            onFlashOn?.invoke()
        }
    }
    ScancodeConfig.onFlashOff = null
    if (config.onFlashOff != null) {
        val onFlashOff = config.onFlashOff!!
        ScancodeConfig.onFlashOff = fun(){
            onFlashOff?.invoke()
        }
    }
    ScancodeConfig.onZoom = null
    if (config.onZoom != null) {
        val onZoom = config.onZoom!!
        ScancodeConfig.onZoom = fun(currentZoomRatio: Number){
            onZoom?.invoke(currentZoomRatio)
        }
    }
    ScancodeConfig.onDoubleTap = null
    if (config.onDoubleTap != null) {
        val onDoubleTap = config.onDoubleTap!!
        ScancodeConfig.onDoubleTap = fun(currentZoomRatio: Number){
            onDoubleTap?.invoke(currentZoomRatio)
        }
    }
    ScancodeConfig.onContinuous = null
    if (config.onContinuous != null) {
        val onContinuous = config.onContinuous!!
        ScancodeConfig.onContinuous = fun(res: ResponseStateConfig){
            var response = SuccessCallback(statusCode = 200, message = "扫码识别成功", data = ScanCodeResult(data = _uA<SingleQRCodeData>()))
            var qrCodeData: UTSArray<SingleQRCodeData> = _uA()
            var image: CodeImage? = null
            (res.data as ArrayList<QRCodeData>).forEach(fun(item: QRCodeData){
                qrCodeData.push(resultHandle(item))
                image = imageHandle(item)
            }
            )
            var resData: ScanCodeResult = ScanCodeResult(data = qrCodeData, image = image)
            response.data = resData
            onContinuous?.invoke(response)
        }
    }
    ScancodeConfig.onBarcode = null
    if (config.onBarcode != null) {
        val onBarcode = config.onBarcode!!
        ScancodeConfig.onBarcode = fun(res: ResponseStateConfig){
            var response = OnBarcodeCallback(statusCode = 200, message = "扫码识别成功", data = ScanCodeResult(data = _uA()))
            val item = res.data as QRCodeData
            var r = resultHandle(item)
            var image = imageHandle(item)
            var result = ScanCodeResult(data = _uA(
                r
            ), image = image)
            response.data = result
            onBarcode?.invoke(response)
        }
    }
    ScancodeConfig.onCameraPermissionDenied = null
    if (config.onCameraPermissionDenied != null) {
        val onCameraPermissionDenied = config.onCameraPermissionDenied!!
        ScancodeConfig.onCameraPermissionDenied = fun(){
            onCameraPermissionDenied?.invoke()
        }
    }
    ScancodeConfig.onAlbumPermissionDenied = null
    if (config.onAlbumPermissionDenied != null) {
        val onAlbumPermissionDenied = config.onAlbumPermissionDenied!!
        ScancodeConfig.onAlbumPermissionDenied = fun(){
            onAlbumPermissionDenied?.invoke()
        }
    }
    ScancodeConfig.onOpenAlbum = null
    if (config.onOpenAlbum != null) {
        val onOpenAlbum = config.onOpenAlbum!!
        ScancodeConfig.onOpenAlbum = fun(){
            onOpenAlbum?.invoke()
        }
    }
}
open class ScanCodeManager {
    private var _config: ScanCodeConfig
    private var _instance: BarcodeScanningActivity?
    constructor(config: ScanCodeConfig = ScanCodeConfig()){
        this._config = config
        this._instance = BarcodeScanningActivity()
    }
    open fun getInstance(): BarcodeScanningActivity {
        this._instance = BarcodeScanningActivity()
        return this._instance!!
    }
    open fun scanCode() {
        val intent = Intent(UTSAndroid.getUniActivity()!!, BarcodeScanningActivity().javaClass)
        configInit(this._config)
        this._instance!!.setConfig(ScancodeConfig)
        UTSAndroid.getUniActivity()!!.startActivity(intent)
    }
    open fun selfRequestCameraPermission() {
        (UTSAndroid.getUniActivity() as BarcodeScanningActivity).selfRequestCameraPermission()
    }
    open fun selfRequestReadMediaImagesPermission() {
        (UTSAndroid.getUniActivity() as BarcodeScanningActivity).selfRequestReadMediaImagesPermission()
    }
    open fun openAlbum() {
        (UTSAndroid.getUniActivity() as BarcodeScanningActivity).openAlbum()
    }
    open fun restartScan() {
        (UTSAndroid.getUniActivity() as BarcodeScanningActivity).restartScan()
    }
    open fun close() {
        (UTSAndroid.getUniActivity() as BarcodeScanningActivity).close()
    }
    open fun config(config: ScanCodeConfig = ScanCodeConfig()) {
        this._config = config
    }
    open fun turnOnFlashlight() {
        (UTSAndroid.getUniActivity() as BarcodeScanningActivity).turnOnFlashlight()
    }
    open fun turnOffFlashlight() {
        (UTSAndroid.getUniActivity() as BarcodeScanningActivity).turnOffFlashlight()
    }
}
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
typealias ChooseImage = (options: chooseOptions) -> Unit
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
val activityInstance: BarcodeScanningActivity = BarcodeScanningActivity()
fun scanCode(config: ScanCodeConfig = ScanCodeConfig()) {
    val intent = Intent(UTSAndroid.getUniActivity()!!, BarcodeScanningActivity().javaClass)
    console.log(config)
    configInit(config)
    activityInstance.setConfig(ScancodeConfig)
    UTSAndroid.getUniActivity()!!.startActivity(intent)
}
fun useScanCode(config: ScanCodeConfig = ScanCodeConfig()): ScanCodeManager {
    return ScanCodeManager(config)
}
open class imageScanConfig (
    open var success: ((res: SuccessCallback) -> Unit)? = null,
    open var fail: ((res: CommonResultCallback) -> Unit)? = null,
) : UTSObject()
fun scanMultiCodeClick(config: MultiCodeClickConfig = MultiCodeClickConfig()) {
    scanCode(ScanCodeConfig(title = " ", tip = config.tip, showTip = false, exitText = "返回", cancelText = "返回", showAlbum = true, needImage = config.needImage, vibrate = config.vibrate, continuousScanning = false, batchScanning = true, cancelFinish = true, successFinish = false, success = fun(res: SuccessCallback) {
        console.log(res)
        if (res.data.data.length == 1) {
            if (config.success != null) {
                config.success!!(res)
            }
        }
    }
    , fail = fun(callback: CommonResultCallback) {
        if (config.fail != null) {
            config.fail!!(callback)
        }
    }
    , onBarcode = fun(res: OnBarcodeCallback) {
        console.log(res)
        if (config.success != null) {
            var r = SuccessCallback(statusCode = res.statusCode, data = res.data, message = res.message)
            config.onClick?.invoke(r)
        }
    }
    ))
}
fun scanMultiCode(config: MultiCodeConfig = MultiCodeConfig()) {
    scanCode(ScanCodeConfig(title = " ", tip = config.tip, showTip = false, exitText = "返回", cancelText = "返回", showAlbum = true, needImage = config.needImage, vibrate = config.vibrate, continuousScanning = false, batchScanning = true, cancelFinish = true, successFinish = true, onOpenAlbum = fun() {
        console.log("点击相册")
        imageScan(imageScanConfig(success = config.success, fail = config.fail), false)
    }
    , success = fun(res: SuccessCallback) {
        console.log(res)
        if (res.data.data.length == 1) {
            if (config.success != null) {
                config.success?.invoke(res)
            }
        }
    }
    , fail = fun(callback: CommonResultCallback) {
        if (config.fail != null) {
            config.fail?.invoke(callback)
        }
    }
    ))
}
fun imageScan(config: imageScanConfig = imageScanConfig(), isSimple: Boolean) {
    chooseImage(chooseOptions(type = "image", compress = 1, count = 1, camera = false, success = fun(res: UTSArray<UTSJSONObject>){
        if (res.length < 1) {
            config.fail?.invoke(CommonResultCallback(statusCode = -404, message = "选择照片失败", data = _uO()))
            return
        }
        var image = res[0]["uri"] as String
        var uri: Uri = Uri.parse(image)
        console.log("等待1")
        scanCodeObject.startScanCode(UTSAndroid.getAppContext() as Context, uri as Uri, fun(r: ResponseStateConfig?) {
            if (r == null) {
                return
            }
            console.log("等待2")
            console.log(r)
            var response = SuccessCallback(statusCode = 200, message = "扫码识别成功", data = ScanCodeResult(data = _uA<SingleQRCodeData>()))
            console.log("等待3")
            var qrCodeData: UTSArray<SingleQRCodeData> = _uA()
            var im: CodeImage? = null
            (r.data as ArrayList<QRCodeData>).forEach(fun(item: QRCodeData){
                qrCodeData.push(resultHandle(item))
                im = imageHandle(item)
            }
            )
            console.log("等待4", qrCodeData.length)
            if (qrCodeData.length < 1) {
                config.fail?.invoke(CommonResultCallback(statusCode = -401, message = "未扫描到二维码/条形码", data = _uO()))
                return
            }
            console.log("等待5")
            if (isSimple) {
                qrCodeData = _uA(
                    qrCodeData[0]
                )
            }
            var resData: ScanCodeResult = ScanCodeResult(data = qrCodeData, image = im)
            response.data = resData
            console.log(response)
            var image = response.data.image
            if (image != null) {
                var uri = image.uri
                if (uri != null) {
                    if (response.data != null && response.data.image != null && response.data.image!!.uri != null) {
                        response.data.image!!.uri = uri.toString()
                    }
                }
            }
            config.success?.invoke(response)
        }
        )
    }
    , fail = fun(_res) {
        console.log("失败")
        config.fail?.invoke(CommonResultCallback(statusCode = -401, message = "选择照片失败", data = _uO()))
    }
    ))
    (UTSAndroid.getUniActivity() as BarcodeScanningActivity).close()
}
fun deleteFile(uri: String): Boolean {
    if (uri == null) {
        return false
    }
    var u = Uri.parse(uri)
    var r = scanCodeObject.deleteFileByUri(UTSAndroid.getAppContext() as Context, u)
    console.log("删除文件", r)
    return r
}
fun scanSimpleCode(config: SimpleCodeConfig = SimpleCodeConfig()) {
    scanCode(ScanCodeConfig(title = " ", tip = config.tip, showTip = false, showAlbum = true, needImage = config.needImage, vibrate = config.vibrate, continuousScanning = false, batchScanning = true, cancelFinish = true, successFinish = false, onOpenAlbum = fun() {
        console.log("点击相册")
        var conf = ScanCodeConfig(needImage = false)
        configInit(conf)
        activityInstance.setConfig(ScancodeConfig)
        imageScan(imageScanConfig(success = config.success, fail = config.fail), false)
    }
    , success = fun(res: SuccessCallback) {
        console.log(res)
        if (res.data.data.length == 1) {
            if (config.success != null) {
                config.success!!(res)
            }
            (UTSAndroid.getUniActivity() as BarcodeScanningActivity).close()
        }
    }
    , fail = fun(callback: CommonResultCallback) {
        console.log("失败")
        if (config.fail != null) {
            config.fail!!(callback)
        }
    }
    , onBarcode = fun(res: OnBarcodeCallback) {
        console.log(res)
        if (config.success != null) {
            var r = SuccessCallback(statusCode = res.statusCode, data = res.data, message = res.message)
            config.success!!(r)
        }
        (UTSAndroid.getUniActivity() as BarcodeScanningActivity).close()
    }
    ))
}
val taskPhoto = fun(success: (uri: String) -> Unit, error: (msg: String?) -> Unit) {
    CameraUtils.takePhotoInBackground(UTSAndroid.getAppContext() as Context, UTSAndroid.getUniActivity() as LifecycleOwner, fun(uri: Uri) {
        console.log("照片已保存" + uri.toString())
        success(uri.toString())
        CameraUtils.shutdown()
    }
    , fun(exception: Exception) {
        console.log("拍照失败" + exception.message)
        CameraUtils.shutdown()
        error(exception.message)
    }
    )
}
