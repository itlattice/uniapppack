@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.iboxsAmap
import android.view.View
import android.widget.ImageView
import com.amap.api.location.AMapLocation
import com.amap.api.location.AMapLocationClientOption
import com.amap.api.maps.AMapOptions
import com.amap.api.maps.MapsInitializer
import com.amap.api.services.core.AMapException
import com.amap.api.services.core.LatLonPoint
import com.amap.api.services.core.PoiItem
import com.amap.api.services.poisearch.PoiResult
import io.dcloud.uniapp.*
import io.dcloud.uniapp.UniSDKEngine
import io.dcloud.uniapp.appframe.PageProxy
import io.dcloud.uniapp.dom.node.DomNode
import io.dcloud.uniapp.dom.node.PageNode
import io.dcloud.uniapp.extapi.*
import io.dcloud.uniapp.framework.*
import io.dcloud.uniapp.interfaces.INodeData
import io.dcloud.uniapp.runtime.*
import io.dcloud.uniapp.ui.component.IComponentData
import io.dcloud.uniapp.vue.*
import io.dcloud.uniapp.vue.shared.*
import io.dcloud.uts.*
import io.dcloud.uts.Map
import io.dcloud.uts.Set
import io.dcloud.uts.UTSAndroid
import io.dcloud.uts.component.*
import io.dcloud.uts.component.UTSComponent
import io.dcloud.uts.component.UTSSize
import kotlin.properties.Delegates
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import io.dcloud.uniapp.extapi.`$once` as uni__once
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.Point
import android.content.Context
import java.io.File
import java.io.FileOutputStream
import android.graphics.drawable.GradientDrawable
import android.widget.LinearLayout
import android.widget.TextView
import com.amap.api.maps.MapView
import com.amap.api.maps.AMap
import com.amap.api.maps.CameraUpdateFactory
import com.amap.api.maps.model.MyLocationStyle
import com.amap.api.maps.model.LatLng as LatLng__1
import com.amap.api.maps.model.MarkerOptions
import com.amap.api.maps.model.BitmapDescriptorFactory
import com.amap.api.maps.model.BitmapDescriptor
import com.amap.api.maps.model.PolylineOptions
import com.amap.api.maps.model.Polyline
import com.amap.api.maps.model.Marker
import com.amap.api.maps.model.CircleOptions
import com.amap.api.maps.model.Circle
import com.amap.api.maps.model.Polygon
import com.amap.api.maps.model.PolygonOptions
import com.amap.api.maps.model.LatLngBounds
import com.amap.api.maps.model.CameraPosition
import com.amap.api.maps.model.HeatMapLayerOptions
import com.amap.api.maps.model.HeatMapLayer
import com.amap.api.maps.model.WeightedLatLng
import com.amap.api.maps.model.Gradient
import com.amap.api.maps.model.HeatmapTileProvider
import com.amap.api.maps.model.TileOverlayOptions
import com.amap.api.maps.model.TileOverlay
import java.net.URL
import androidx.core.view.ViewCompat
import io.dcloud.uniapp.extapi.navigateBack as uni_navigateBack
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
open class LocationError (
    @JsonNotNull
    open var errCode: Number,
    open var reson: String? = null,
) : UTSObject()
enum class LocationMode__1(override val value: String) : UTSEnumString {
    Battery("Battery"),
    Device("Device"),
    Hight("Hight"),
    None("None")
}
enum class LocationPurpose__1(override val value: String) : UTSEnumString {
    None("none"),
    SignIn("signin"),
    Sport("sport"),
    Transport("transport")
}
open class MylocationInfo (
    @JsonNotNull
    open var show: Boolean = false,
    @JsonNotNull
    open var updatingMapCenter: Boolean = false,
    open var icon: String? = null,
    open var zIndex: Number? = null,
) : UTSObject()
open class MarkerInfo (
    @JsonNotNull
    open var title: String,
    open var subtitle: String? = null,
    @JsonNotNull
    open var lat: Number,
    @JsonNotNull
    open var lng: Number,
    @JsonNotNull
    open var id: String,
    open var anchor: String? = null,
    open var zIndex: Number? = null,
    open var icon: String? = null,
    open var iconWidth: Number? = null,
    open var iconHeight: Number? = null,
    open var callout: Callout? = null,
) : UTSObject()
open class Callout (
    open var content: String? = null,
    open var textColor: String? = null,
    open var fontSize: Number? = null,
    open var textAlign: String? = null,
    open var padding: Number? = null,
    open var bgColor: String? = null,
    open var borderColor: String? = null,
    open var borderWidth: Number? = null,
    open var borderRadius: Number? = null,
) : UTSObject()
open class UISettingConfig (
    open var scaleControlsEnabled: Boolean? = null,
    open var isZoomControlsEnabled: Boolean? = null,
    open var LogoPosition: String? = null,
) : UTSObject()
open class MapPosition (
    @JsonNotNull
    open var centerLng: Number,
    @JsonNotNull
    open var centerLat: Number,
    @JsonNotNull
    open var zoom: Number,
) : UTSObject()
open class LatLng (
    @JsonNotNull
    open var lat: Number,
    @JsonNotNull
    open var lng: Number,
) : UTSObject()
open class PoiListResult (
    @JsonNotNull
    open var pageCount: Number,
    @JsonNotNull
    open var list: UTSArray<Poi>,
    @JsonNotNull
    open var time: Number,
) : UTSObject()
open class Poi (
    open var adCode: String? = null,
    open var adName: String? = null,
    open var businessArea: String? = null,
    open var cityCode: String? = null,
    open var cityName: String? = null,
    open var direction: String? = null,
    open var distance: Number? = null,
    open var provinceCode: String? = null,
    open var province: String? = null,
    open var address: String? = null,
    open var title: String? = null,
    open var typeCode: String? = null,
    open var typeDes: String? = null,
    open var id: String? = null,
    open var latlng: LatLng? = null,
) : UTSObject()
fun runInMain(codes: () -> Unit) {
    UTSAndroid.getDispatcher("main").async(fun(_) {
        codes()
    }
    , null)
}
fun bitmapDescriptor(icon: String?, cb: (bitmapDescriptor: BitmapDescriptor) -> Unit) {
    if (icon!!.startsWith("http")) {
        UTSAndroid.getDispatcher("io").async(fun(_) {
            console.log("" + icon + "读取本地缓存")
            var bitmap: Bitmap?
            var file = File(UTSAndroid.getUniActivity()!!.getCacheDir(), icon!!.hashCode().toString())
            if (file.exists()) {
                console.log("" + icon + " 存在本地缓存图片")
                bitmap = BitmapFactory.decodeFile(file.getAbsolutePath())
            } else {
                console.log("" + icon + " 本地无缓存图片，从网络获取")
                bitmap = BitmapFactory.decodeStream(URL(icon!!).openStream())
                var fos = FileOutputStream(file)
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos)
                fos.close()
            }
            var bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(bitmap)
            runInMain(fun(){
                cb(bitmapDescriptor!!)
            })
        }, null)
    } else {
        var bitmapDescriptor = BitmapDescriptorFactory.fromPath(icon)
        runInMain(fun(){
            cb(bitmapDescriptor!!)
        }
        )
    }
}
open class IboxsAmapComponent : UTSComponent<MapView> {
    constructor(proxy: PageProxy, componentData: IComponentData) : super(proxy, componentData)
    open var initlocation: String = ""
    open var uisetting = _uO()
    open var markersCache: UTSArray<Map<String, Any>> = _uA()
    open var polylinesCache: UTSArray<Map<String, Any>> = _uA()
    open var circlesCache: UTSArray<Map<String, Any>> = _uA()
    open var polygonsCache: UTSArray<Map<String, Any>> = _uA()
    open var markerClickListener: IBoxsMarkerClickListener? = null
    open var markerDragListener: IBoxsMarkerDragListener? = null
    open var tileOverlayCache = Map<String, TileOverlay>()
    open var heatMapLayers = Map<String, TileOverlay>()
    open var amapClickListener: IBoxsAmapClickListener? = null
    open var cameraListener: IBoxsCameraChangeListener? = null
    override fun created() {}
    override fun NVBeforeLoad() {}
    override fun NVLoad(): MapView {
        var mapView = MapView(`$androidContext`!!)
        mapView.onCreate(null)
        var aMap = mapView.getMap()
        aMap.setMapType(AMap.MAP_TYPE_NORMAL)
        this.markerClickListener = IBoxsMarkerClickListener(this, this.markersCache)
        aMap.setOnMarkerClickListener(this.markerClickListener!!)
        this.markerClickListener!!.markersCache = this.markersCache
        this.markerDragListener = IBoxsMarkerDragListener(this, this.markersCache)
        aMap.setOnMarkerDragListener(this.markerDragListener!!)
        this.markerDragListener!!.markersCache = this.markersCache
        this.cameraListener = IBoxsCameraChangeListener(this)
        aMap.addOnCameraChangeListener(this.cameraListener)
        this.amapClickListener = IBoxsAmapClickListener(this)
        aMap.setOnMapClickListener(this.amapClickListener)
        screenshotListener = IBoxsOnMapScreenShotListener(this)
        mapView.onResume()
        console.log("初始化数据", this.initlocation)
        return mapView
    }
    override fun NVLoaded() {}
    override fun NVLayouted() {}
    override fun NVBeforeUnload() {
        console.log("地图即将释放")
        this.removeAllMarkers()
        this.removeAllPolylines()
        this.removeAllCircles()
        this.removeAllPolygons()
        if (this.`$el` != null && this.markerClickListener != null) {
            this.`$el`!!.getMap().removeOnMarkerClickListener(this.markerClickListener)
        }
        this.markerClickListener?.releaseComponent()
        this.markerClickListener = null
        if (this.`$el` != null && this.markerDragListener != null) {
            this.`$el`!!.getMap().removeOnMarkerDragListener(this.markerDragListener)
        }
        this.markerDragListener?.releaseComponent()
        this.markerDragListener = null
        this.cameraListener?.releaseComponent()
        this.cameraListener = null
        this.amapClickListener?.releaseComponent()
        this.amapClickListener = null
        screenshotListener?.releaseComponent()
        screenshotListener = null
    }
    override fun NVUnloaded() {
        console.log("amapall 已销毁")
    }
    override fun unmounted() {}
    override fun NVMeasure(size: UTSSize): UTSSize {
        return size
    }
    open fun removeTileOverlay(params: String) {
        console.log("removeTileOverlay调用")
        var paramsObj = JSON.parseObject(params)
        if (paramsObj == null) {
            console.log("错误，removeTileOverlay方法需要参数")
            return
        }
        if (paramsObj["id"] == null) {
            console.log("错误，removeTileOverlay需要参数id")
            return
        }
        var id = paramsObj.getString("id")!!
        runInMain(fun(){
            var tileOverlay = this.tileOverlayCache[id]
            if (tileOverlay != null) {
                tileOverlay.remove()
            }
        }
        )
    }
    open fun hideLogo() {
        console.log("hideLogo调用")
        var aMap = this.`$el`!!.getMap()
        var uisettings = aMap.getUiSettings()
        uisettings.setLogoBottomMargin(-100)
    }
    open fun removeHeatMap(params: String) {
        console.log("removeHeatMap调用")
        var paramsObj = JSON.parseObject(params)
        if (paramsObj == null) {
            console.log("没传参数，移除所有热力图层")
        } else {
            var id = paramsObj.getString("id")
            if (id != null) {
                runInMain(fun(){
                    var heatMap = this.heatMapLayers[id]
                    if (heatMap != null) {
                        console.log("移除 id=" + id + "的热力图层")
                        heatMap.remove()
                        return
                    }
                }
                )
            }
        }
        console.log("移除所有热力图层" + this.heatMapLayers.size)
        runInMain(fun(){
            this.heatMapLayers.forEach(fun(heatMap: TileOverlay, key: String, map: Map<String, TileOverlay>){
                console.log("移除 id=" + key + "的热力图层")
                heatMap.remove()
            }
            )
        }
        )
    }
    open fun removeCircle(params: String) {
        console.log("删除圆")
        var circleObj = JSON.parseObject(params)
        if (circleObj == null) {
            console.log("错误，removeCircle方法需要参数")
            return
        }
        var idToRemove = circleObj.getString("id")
        if (idToRemove == null) {
            console.log("错误，removeCircle方法需要id参数")
            return
        }
        runInMain(fun(){
            var indexToRemove: Number = -1
            run {
                var index: Number = 0
                while(index < this.circlesCache.length){
                    var circleInCache = this.circlesCache[index]
                    var circleIdInCache = circleInCache.get("id") as String
                    if (circleIdInCache == idToRemove) {
                        console.log("找到并删除指定id的圆：" + idToRemove)
                        var circle = circleInCache.get("circle") as Circle
                        circle.remove()
                        indexToRemove = index
                        break
                    }
                    index++
                }
            }
            if (indexToRemove != -1) {
                this.circlesCache.splice(indexToRemove, 1)
            }
        }
        )
    }
    open fun removeAllCircles() {
        console.log("删除所有圆")
        runInMain(fun(){
            circlesCache.forEach(fun(circleInCache){
                var circle = circleInCache.get("circle") as Circle
                if (circle != null) {
                    circle.remove()
                }
            }
            )
            this.circlesCache.clear()
        }
        )
    }
    open fun drawPolygon(params: String) {
        console.log("绘制多边形")
        var polygonObj = JSON.parseObject(params)
        if (polygonObj == null) {
            console.log("错误，drawPolygon方法需要参数")
            return
        }
        var id = polygonObj.getString("id")
        if (id == null) {
            console.log("错误，drawPolygon方法需要id参数")
            return
        }
        console.log("插件层添加多边形:" + params)
        var points = polygonObj.getArray("points") as UTSArray<String>
        if (points == null) {
            console.log("错误，line需要传入points参数")
            return
        }
        var latlngs = UTSArray<LatLng__1>()
        run {
            var i: Number = 0
            while(i < points.length){
                var lnglatStr = points[i]
                var lng = parseFloat(lnglatStr.split(",")[0]).toDouble()
                var lat = parseFloat(lnglatStr.split(",")[1]).toDouble()
                var pointLatlng = LatLng__1(lat, lng)
                latlngs.push(pointLatlng)
                console.log("添加多边形边界点：(" + lng + "," + lat + ")")
                i++
            }
        }
        var polygonOptions = PolygonOptions()
        polygonOptions.addAll(latlngs)
        var linewidth = polygonObj.getNumber("lineWidth")
        if (linewidth != null) {
            polygonOptions.strokeWidth(linewidth.toFloat())
            console.log("设置线宽：" + linewidth)
        }
        var strokeColor = polygonObj.getString("strokeColor")
        if (strokeColor != null) {
            polygonOptions.strokeColor(Color.parseColor(strokeColor))
        }
        var fillColor = polygonObj.getString("fillColor")
        if (fillColor != null) {
            polygonOptions.fillColor(Color.parseColor(fillColor))
        }
        var zIndex = polygonObj.getNumber("zIndex")
        if (zIndex != null) {
            polygonOptions.zIndex(zIndex.toFloat())
        }
        runInMain(fun(){
            var aMap = this.`$el`!!.getMap()
            var polygon = aMap.addPolygon(polygonOptions)
            var polygonInCache = Map<String, Any>()
            polygonInCache.set("id", id)
            polygonInCache.set("polygon", polygon)
            polygonInCache.set("info", polygonObj)
            this.polygonsCache.push(polygonInCache)
        }
        )
    }
    open fun removePolygon(params: String) {
        console.log("删除多边形")
        var polygonObj = JSON.parseObject(params)
        if (polygonObj == null) {
            console.log("错误，removePolygon方法需要参数")
            return
        }
        var idToRemove = polygonObj.getString("id")
        if (idToRemove == null) {
            console.log("错误，removePolygon方法需要id参数")
            return
        }
        runInMain(fun(){
            var indexToRemove: Number = -1
            run {
                var index: Number = 0
                while(index < this.polygonsCache.length){
                    var polygonInCache = this.polygonsCache[index]
                    var polygonIdInCache = polygonInCache.get("id") as String
                    if (polygonIdInCache == idToRemove) {
                        console.log("找到并删除指定id的多边形：" + idToRemove)
                        var polygon = polygonInCache.get("polygon") as Polygon
                        polygon.remove()
                        indexToRemove = index
                        break
                    }
                    index++
                }
            }
            if (indexToRemove != -1) {
                this.polygonsCache.splice(indexToRemove, 1)
            }
        }
        )
    }
    open fun removeAllPolygons() {
        console.log("删除所有多边形")
        runInMain(fun(){
            this.polygonsCache.forEach(fun(polygonInCache){
                var polygon = polygonInCache.get("polygon") as Polygon
                if (polygon != null) {
                    polygon.remove()
                }
            }
            )
            this.polygonsCache.clear()
        }
        )
    }
    open fun removeAllPolylines() {
        console.log("删除所有折线")
        runInMain(fun(){
            this.polylinesCache.forEach(fun(polylineInCache){
                var polyline = polylineInCache.get("polyline") as Polyline
                if (polyline != null) {
                    polyline.remove()
                }
            }
            )
            this.polylinesCache.clear()
        }
        )
    }
    open fun removePolyline(params: String) {
        var lineObj = JSON.parseObject(params)
        if (lineObj == null) {
            console.log("错误，removePolyline方法需要line参数")
            return
        }
        var idToRemove = lineObj.getString("id")
        if (idToRemove == null) {
            console.log("错误，removePolyline方法需要id参数")
            return
        }
        runInMain(fun(){
            var indexOfLineToRemove: Number = -1
            run {
                var index: Number = 0
                while(index < this.polylinesCache.length){
                    var lineInCache = this.polylinesCache[index]
                    var lineIdInCache = lineInCache.get("id") as String
                    if (lineIdInCache == idToRemove) {
                        console.log("找到并删除指定id的折线：" + idToRemove)
                        var polyline = lineInCache.get("polyline") as Polyline
                        polyline.remove()
                        indexOfLineToRemove = index
                        break
                    }
                    index++
                }
            }
            if (indexOfLineToRemove != -1) {
                this.polylinesCache.splice(indexOfLineToRemove, 1)
            }
        }
        )
    }
    open fun setMinAndZoomLevel(params: String) {
        var paramsObj = JSON.parseObject(params)
        if (paramsObj == null) {
            console.log("错误，setMinAndZoomLevel方法需要min或者max参数")
            return
        }
        var min = paramsObj.getNumber("min")
        var max = paramsObj.getNumber("max")
        if (max == null && min == null) {
            console.log("错误，setMinAndZoomLevel方法需要min或者max参数")
            return
        }
        console.log("插件层设置允许缩放的范围：" + min?.toFloat() + "-" + max?.toFloat())
        runInMain(fun(){
            var aMap = this.`$el`!!.getMap()
            if (min != null) {
                aMap.setMinZoomLevel(min.toFloat())
            }
            if (max != null) {
                aMap.setMaxZoomLevel(max.toFloat())
            }
        }
        )
    }
    open fun addMarkers(paramsArray: UTSArray<MarkerInfo>) {
        run {
            var i: Number = 0
            while(i < paramsArray.length){
                var paramsObj = paramsArray[i] as MarkerInfo
                var title = paramsObj.title
                var subtitle = paramsObj.subtitle
                var lat = paramsObj.lat
                var lng = paramsObj.lng
                var id = paramsObj.id
                var anchor = paramsObj.anchor
                if (subtitle == null) {
                    subtitle = ""
                }
                if (anchor == null) {
                    anchor = "center"
                }
                var latLng = LatLng__1(lat.toDouble(), lng.toDouble())
                var markerOption = MarkerOptions().position(latLng).title(title).snippet(subtitle)
                var aMap = this.`$el`!!.getMap()
                var zIndex = paramsObj.zIndex
                if (zIndex != null) {
                    markerOption.zIndex(zIndex.toFloat())
                }
                var icon = paramsObj.icon
                if (icon == null || icon.startsWith("http") == false) {
                    icon = "https://a.amap.com/jsapi_demos/static/demo-center/icons/poi-marker-default.png"
                }
                UTSAndroid.getDispatcher("io").async(fun(_) {
                    console.log("读取本地缓存")
                    var bitmap: Bitmap?
                    var file = File(UTSAndroid.getUniActivity()!!.getCacheDir(), icon.hashCode().toString())
                    if (file.exists()) {
                        console.log("存在本地缓存图片")
                        bitmap = BitmapFactory.decodeFile(file.getAbsolutePath())
                    } else {
                        console.log("本地无缓存图片，从网络获取")
                        bitmap = BitmapFactory.decodeStream(URL(icon).openStream())
                        var fos = FileOutputStream(file)
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos)
                        fos.close()
                    }
                    var iconWidth = paramsObj.iconWidth
                    var iconHeight = paramsObj.iconHeight
                    if (iconWidth != null && iconHeight != null) {
                        console.log("icon图片转成宽" + iconWidth + "px,高" + iconHeight + "px")
                        bitmap = Bitmap.createScaledBitmap(bitmap!!, iconWidth.toInt(), iconHeight.toInt(), true)
                    }
                    runInMain(fun(){
                        if (paramsObj.callout == null) {
                            if (bitmap != null) {
                                var bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(bitmap)
                                markerOption.icon(bitmapDescriptor)
                            }
                        } else {
                            var markerBit = LinearLayout(UTSAndroid.getUniActivity()!!)
                            var textView = TextView(UTSAndroid.getUniActivity()!!)
                            markerBit.addView(textView)
                            markerBit.setOrientation(LinearLayout.VERTICAL)
                            console.log("自定义callout,id:" + id)
                            var calloutObj = paramsObj.callout!!
                            var calloutText = calloutObj?.content
                            if (calloutText == null) {
                                calloutText = paramsObj.title
                            }
                            if (calloutText == null || calloutText.length == 0) {
                                console.log("自定义气泡缺少content字段, id:" + id)
                            }
                            textView.setText(calloutText)
                            var textColor = calloutObj?.textColor
                            if (textColor != null) {
                                textView.setTextColor(Color.parseColor(textColor))
                            }
                            var fontSize = calloutObj?.fontSize
                            if (fontSize != null) {
                                textView.setTextSize(fontSize.toFloat())
                            }
                            var textAlign = calloutObj?.textAlign
                            if (textAlign != null) {
                                textAlign = textAlign.toLowerCase()
                                if (textAlign == "left") {
                                    textView.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START)
                                } else if (textAlign == "center") {
                                    textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER)
                                } else if (textAlign == "right") {
                                    textView.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END)
                                }
                            }
                            if (bitmap != null) {
                                var imageView = ImageView(UTSAndroid.getUniActivity()!!)
                                imageView.setImageBitmap(bitmap)
                                var spave10 = View(UTSAndroid.getUniActivity()!!)
                                var params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 10)
                                spave10.setLayoutParams(params)
                                markerBit.addView(spave10)
                                markerBit.addView(imageView)
                            }
                            var gradientDrawable = GradientDrawable()
                            gradientDrawable.setShape(GradientDrawable.RECTANGLE)
                            var borderRadius = calloutObj?.borderRadius
                            if (borderRadius != null) {
                                gradientDrawable.setCornerRadius(borderRadius.toFloat())
                            }
                            var borderWidth = calloutObj?.borderWidth
                            var borderColor = calloutObj?.borderColor
                            var bgColor = calloutObj?.bgColor
                            var padding = calloutObj?.padding
                            if (borderWidth != null && borderColor != null) {
                                var bdc = Color.parseColor(borderColor)
                                gradientDrawable.setStroke(borderWidth.toInt(), bdc)
                            }
                            if (bgColor != null) {
                                gradientDrawable.setColor(Color.parseColor(bgColor))
                            }
                            ViewCompat.setBackground(textView, gradientDrawable)
                            if (padding != null) {
                                textView.setPadding(padding.toInt(), padding.toInt(), padding.toInt(), padding.toInt())
                            }
                            var bitmapDescriptor = BitmapDescriptorFactory.fromView(markerBit)
                            markerOption.icon(bitmapDescriptor)
                            anchor = "bottomCenter"
                        }
                        console.log("设置锚点", anchor)
                        if (anchor == "bottomCenter") {
                            var x: Number = 0.5
                            var y: Number = 1
                            markerOption.anchor(x.toFloat(), y.toFloat())
                        } else {
                            var x: Number = 0.5
                            markerOption.anchor(x.toFloat(), x.toFloat())
                        }
                        var marker = aMap.addMarker(markerOption)
                        var markerInCache = Map<String, Any>()
                        markerInCache.set("id", id)
                        markerInCache.set("marker", marker)
                        markerInCache.set("info", paramsObj)
                        this.markersCache.push(markerInCache)
                    }
                    )
                }
                , null)
                i++
            }
        }
    }
    open fun removeSomeMarkers(paramsObjArray: UTSArray<String>) {
        runInMain(fun(){
            run {
                var i: Number = 0
                while(i < paramsObjArray.length){
                    var markerIndexToRemove: Number = -1
                    var paramsObj = paramsObjArray[i] as String
                    this.markersCache.some(fun(markerObj: Map<String, Any>, index: Number): Boolean {
                        if (markerObj.get("id") as String == paramsObj) {
                            markerIndexToRemove = index
                            var markerToRemove = markerObj.get("marker") as Marker
                            markerToRemove.remove()
                            console.log("找到id为" + markerObj.get("id") + "的marker，index是:" + index)
                            return true
                        } else {
                            return false
                        }
                    }
                    )
                    console.log("删除index是" + markerIndexToRemove + "的marker")
                    if (markerIndexToRemove != -1) {
                        this.markersCache.splice(markerIndexToRemove, 1)
                    }
                    i++
                }
            }
        }
        )
    }
    open fun removeAllMarkers() {
        console.log("删除所有markers")
        runInMain(fun(){
            run {
                var index: Number = 0
                while(index < this.markersCache.length){
                    var markerInCahce = this.markersCache[index]
                    var marker = markerInCahce["marker"] as Marker
                    marker.remove()
                    index++
                }
            }
            this.markersCache.clear()
        }
        )
    }
    open fun zootTo(zoomLevel: Number) {
        runInMain(fun(){
            var cameraUpdate = CameraUpdateFactory.zoomTo(zoomLevel.toFloat())
            this.`$el`!!.getMap().animateCamera(cameraUpdate)
        }
        )
    }
    open fun zoomIn() {
        runInMain(fun(){
            var cameraUpdate = CameraUpdateFactory.zoomIn()
            this.`$el`!!.getMap().animateCamera(cameraUpdate)
        }
        )
    }
    open fun changeLatLng(lat: Number, lng: Number) {
        runInMain(fun(){
            var latlng = LatLng__1(lat.toDouble(), lng.toDouble())
            var cameraUpdate = CameraUpdateFactory.changeLatLng(latlng)
            this.`$el`!!.getMap().moveCamera(cameraUpdate)
        }
        )
    }
    open fun changeLatLngAnimal(lat: Number, lng: Number) {
        runInMain(fun(){
            var latlng = LatLng__1(lat.toDouble(), lng.toDouble())
            var cameraUpdate = CameraUpdateFactory.changeLatLng(latlng)
            this.`$el`!!.getMap().animateCamera(cameraUpdate)
        }
        )
    }
    open fun changeLatLngAnimate(lat: Number, lng: Number) {
        runInMain(fun(){
            var latlng = LatLng__1(lat.toDouble(), lng.toDouble())
            var cameraUpdate = CameraUpdateFactory.changeLatLng(latlng)
            this.`$el`!!.getMap().animateCamera(cameraUpdate)
        }
        )
    }
    open fun showMyLocationBtn(show: Boolean) {
        console.log("设置是否展示定位按钮：" + show)
        runInMain(fun(){
            var aMap = this.`$el`!!.getMap()
            var uiSettings = aMap.getUiSettings()
            uiSettings.setMyLocationButtonEnabled(show)
        }
        )
    }
    open fun showMyLocation(params: MylocationInfo) {
        console.log("设置是否展示自身位置", params)
        var show = params.show
        if (show == null) {
            console.log("错误，showMyLocation方法需要参数show")
            return
        }
        var updatingMapCenter = params.updatingMapCenter
        runInMain(fun(){
            var aMap = this.`$el`!!.getMap()
            if (show) {
                var myLocationStyle = MyLocationStyle()
                myLocationStyle.interval(2000)
                if (updatingMapCenter == true) {
                    myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE)
                } else {
                    myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE_NO_CENTER)
                }
                if (params.icon == null) {
                    aMap.setMyLocationStyle(myLocationStyle)
                    aMap.setMyLocationEnabled(true)
                } else {
                    bitmapDescriptor(params.icon!!, fun(ic: BitmapDescriptor) {
                        myLocationStyle.myLocationIcon(ic)
                        aMap.setMyLocationStyle(myLocationStyle)
                        aMap.setMyLocationEnabled(true)
                    })
                }
            } else {
                aMap.setMyLocationEnabled(false)
            }
        }
        )
    }
    open fun setUI(uisetting: UISettingConfig) {
        var uiSettings = this.`$el`!!.getMap()?.uiSettings
        if (uisetting.scaleControlsEnabled != null) {
            console.log("设置比例尺显示", uisetting.scaleControlsEnabled)
            uiSettings?.setScaleControlsEnabled(uisetting.scaleControlsEnabled as Boolean)
        }
        if (uisetting.isZoomControlsEnabled != null) {
            console.log("设置加减尺寸显示", uisetting.isZoomControlsEnabled)
            uiSettings?.setZoomControlsEnabled(uisetting.isZoomControlsEnabled as Boolean)
        }
        if (uisetting.LogoPosition != null) {
            var position = AMapOptions.LOGO_POSITION_BOTTOM_LEFT
            when (uisetting.LogoPosition!!) {
                "MARGIN_BOTTOM" -> 
                    position = AMapOptions.LOGO_MARGIN_BOTTOM
                "POSITION_BOTTOM_LEFT" -> 
                    position = AMapOptions.LOGO_POSITION_BOTTOM_LEFT
                "MARGIN_RIGHT" -> 
                    position = AMapOptions.LOGO_POSITION_BOTTOM_RIGHT
                "POSITION_BOTTOM_CENTER" -> 
                    position = AMapOptions.LOGO_POSITION_BOTTOM_CENTER
                "POSITION_BOTTOM_RIGHT" -> 
                    position = AMapOptions.LOGO_POSITION_BOTTOM_RIGHT
            }
            uiSettings?.setLogoPosition(position)
        }
    }
    override fun `$init`() {
        this.`$watch`<String>("initlocation", fun(nValue, oldValue){
            if (nValue == "") {
                return
            }
            var newValue = JSON.parse(nValue) as UTSJSONObject
            var lng = newValue["lng"] as Number
            var lat = newValue["lat"] as Number
            var zoom = newValue["zoom"]
            if (zoom != null) {
                var zoom = (zoom as Number).toFloat()
                console.log("初始化位置:" + lng + " , " + lat + ",  缩放:" + zoom)
                var latlng = LatLng__1(lat.toDouble(), lng.toDouble())
                var update = CameraUpdateFactory.newLatLngZoom(latlng, zoom)
                var aMap = this.`$el`!!.getMap()
                aMap.moveCamera(update)
                return
            }
            var latlng = LatLng__1(lat.toDouble(), lng.toDouble())
            var update = CameraUpdateFactory.newLatLng(latlng)
            var aMap = this.`$el`!!.getMap()
            aMap.moveCamera(update)
        }
        )
    }
    companion object {
        var name = "iboxs-amap"
        init {
            io.dcloud.uniapp.UniSDKEngine.registerUniComponent("iboxs-amap", IboxsAmapComponent::class.java, IboxsAmapElement::class.java)
        }
    }
}
open class IboxsAmapElement : DomNode {
    constructor(data: INodeData, pageNode: PageNode) : super(data, pageNode)
    open fun removeTileOverlay(params: String) {
        return (getComponent() as IboxsAmapComponent).removeTileOverlay(params)
    }
    open fun hideLogo() {
        return (getComponent() as IboxsAmapComponent).hideLogo()
    }
    open fun removeHeatMap(params: String) {
        return (getComponent() as IboxsAmapComponent).removeHeatMap(params)
    }
    open fun removeCircle(params: String) {
        return (getComponent() as IboxsAmapComponent).removeCircle(params)
    }
    open fun removeAllCircles() {
        return (getComponent() as IboxsAmapComponent).removeAllCircles()
    }
    open fun drawPolygon(params: String) {
        return (getComponent() as IboxsAmapComponent).drawPolygon(params)
    }
    open fun removePolygon(params: String) {
        return (getComponent() as IboxsAmapComponent).removePolygon(params)
    }
    open fun removeAllPolygons() {
        return (getComponent() as IboxsAmapComponent).removeAllPolygons()
    }
    open fun removeAllPolylines() {
        return (getComponent() as IboxsAmapComponent).removeAllPolylines()
    }
    open fun removePolyline(params: String) {
        return (getComponent() as IboxsAmapComponent).removePolyline(params)
    }
    open fun setMinAndZoomLevel(params: String) {
        return (getComponent() as IboxsAmapComponent).setMinAndZoomLevel(params)
    }
    open fun addMarkers(paramsArray: UTSArray<MarkerInfo>) {
        return (getComponent() as IboxsAmapComponent).addMarkers(paramsArray)
    }
    open fun removeSomeMarkers(paramsObjArray: UTSArray<String>) {
        return (getComponent() as IboxsAmapComponent).removeSomeMarkers(paramsObjArray)
    }
    open fun removeAllMarkers() {
        return (getComponent() as IboxsAmapComponent).removeAllMarkers()
    }
    open fun zootTo(zoomLevel: Number) {
        return (getComponent() as IboxsAmapComponent).zootTo(zoomLevel)
    }
    open fun zoomIn() {
        return (getComponent() as IboxsAmapComponent).zoomIn()
    }
    open fun changeLatLng(lat: Number, lng: Number) {
        return (getComponent() as IboxsAmapComponent).changeLatLng(lat, lng)
    }
    open fun changeLatLngAnimal(lat: Number, lng: Number) {
        return (getComponent() as IboxsAmapComponent).changeLatLngAnimal(lat, lng)
    }
    open fun changeLatLngAnimate(lat: Number, lng: Number) {
        return (getComponent() as IboxsAmapComponent).changeLatLngAnimate(lat, lng)
    }
    open fun showMyLocationBtn(show: Boolean) {
        return (getComponent() as IboxsAmapComponent).showMyLocationBtn(show)
    }
    open fun showMyLocation(params: MylocationInfo) {
        return (getComponent() as IboxsAmapComponent).showMyLocation(params)
    }
    open fun setUI(uisetting: UISettingConfig) {
        return (getComponent() as IboxsAmapComponent).setUI(uisetting)
    }
}
var screenshotListener: IBoxsOnMapScreenShotListener? = null
open class IBoxsOnMapScreenShotListener : AMap.OnMapScreenShotListener {
    private var comp: UTSComponent<MapView>?
    constructor(comp: UTSComponent<MapView>) : super() {
        this.comp = comp
    }
    open fun releaseComponent() {
        this.comp = null
    }
    override fun onMapScreenShot(bitmap: Bitmap) {}
    override fun onMapScreenShot(bitmap: Bitmap, status: Int) {
        if (null == bitmap) {
            console.log("截图回调是null")
            return
        }
        var fileName = "IBoxsuts_" + Date().valueOf() + ".png"
        var filePath = "" + UTSAndroid.getUniActivity()!!.getCacheDir().getAbsolutePath() + "/" + fileName
        var file = File(filePath)
        var fos = FileOutputStream(file)
        var write2fileRes = bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos)
        console.log("截图写文件成功" + write2fileRes)
        fos.flush()
        fos.close()
        var res: UTSJSONObject = _uO("path" to filePath, "hasGrid" to (status == 0), "timestamp" to Date().valueOf())
        this.comp?.`$emit`("mapScreenshotRes", JSON.stringify(res))
    }
}
open class IBoxsMarkerDragListener : AMap.OnMarkerDragListener {
    private var comp: UTSComponent<MapView>?
    open var markersCache: UTSArray<Map<String, Any>>? = null
    constructor(comp: UTSComponent<MapView>, markersCache: UTSArray<Map<String, Any>>?) : super() {
        this.comp = comp
        this.markersCache = markersCache
    }
    open fun releaseComponent() {
        this.comp = null
        this.markersCache = null
    }
    override fun onMarkerDragStart(marker: Marker) {
        console.log("onMarkerDragStart")
    }
    override fun onMarkerDrag(marker: Marker) {
        console.log("onMarkerDrag")
    }
    override fun onMarkerDragEnd(marker: Marker) {
        console.log("onMarkerDragEnd")
    }
}
open class IBoxsMarkerClickListener : AMap.OnMarkerClickListener {
    private var comp: UTSComponent<MapView>?
    open var markersCache: UTSArray<Map<String, Any>>? = null
    constructor(comp: UTSComponent<MapView>, markersCache: UTSArray<Map<String, Any>>?) : super() {
        this.comp = comp
        this.markersCache = markersCache
    }
    open fun releaseComponent() {
        this.comp = null
        this.markersCache = null
    }
    override fun onMarkerClick(marker: Marker): Boolean {
        if (this.markersCache == null) {
            return false
        }
        run {
            var index: Number = 0
            while(index < this.markersCache!!.length){
                var markerInCache = this.markersCache!![index]
                var markerOfAndroidObj = markerInCache["marker"] as Marker
                var markerIdInCache = markerInCache["id"] as String
                var markerInfo = markerInCache["info"] as UTSJSONObject
                if (markerOfAndroidObj == marker) {
                    console.log("在缓存中找到了被点击的marker,id:" + markerIdInCache)
                    this.comp?.`$emit`("markerClick", JSON.stringify(markerInfo))
                    break
                }
                index++
            }
        }
        return true
    }
}
open class IBoxsAmapClickListener : AMap.OnMapClickListener {
    private var comp: UTSComponent<MapView>?
    constructor(comp: UTSComponent<MapView>) : super() {
        this.comp = comp
    }
    open fun releaseComponent() {
        this.comp = null
    }
    override fun onMapClick(latLng: LatLng__1) {
        var res: UTSJSONObject = _uO("lng" to latLng.longitude, "lat" to latLng.latitude)
        this.comp?.`$emit`("mapClick", JSON.stringify(res))
    }
}
open class IBoxsCameraChangeListener : AMap.OnCameraChangeListener {
    private var comp: UTSComponent<MapView>?
    private var isCameraChanging: Boolean = false
    constructor(comp: UTSComponent<MapView>) : super() {
        this.comp = comp
    }
    open fun releaseComponent() {
        this.comp = null
    }
    override fun onCameraChange(cameraPosition: CameraPosition) {
        var targetLatLng = cameraPosition.target
        var res = MapPosition(centerLng = targetLatLng.longitude, centerLat = targetLatLng.latitude, zoom = cameraPosition.zoom)
        this.comp?.`$emit`("regionWillChange", res)
    }
    override fun onCameraChangeFinish(cameraPosition: CameraPosition) {
        var targetLatLng = cameraPosition.target
        var res = MapPosition(centerLng = targetLatLng.longitude, centerLat = targetLatLng.latitude, zoom = cameraPosition.zoom)
        this.isCameraChanging = false
        this.comp?.`$emit`("regionDidChange", res)
    }
}
val setAmapAndriodKey = fun(key: String) {
    MapsInitializer.setApiKey(key)
    console.log("收到安卓版高德地图Key")
    var context = UTSAndroid.getAppContext() as Context
    MapsInitializer.updatePrivacyShow(context, true, true)
    MapsInitializer.updatePrivacyAgree(context, true)
    IBoxsAmap.init(context)
}
val checkAndRequestStoragePermissionInside = fun(callback: (res: UTSJSONObject) -> Unit){
    console.log("检查定位权限")
    val permissionLocation = _uA(
        "android.permission.ACCESS_FINE_LOCATION",
        "android.permission.ACCESS_COARSE_LOCATION"
    )
    if (callback != null) {
        console.log("开始检查权限")
        var errInfo: UTSJSONObject = _uO("errCode" to 0, "msg" to "用户同意授权")
        if (UTSAndroid.checkSystemPermissionGranted(UTSAndroid.getUniActivity()!!, permissionLocation)) {
            console.log("用户同意授权")
            callback(errInfo)
            return
        }
        console.log("开始检查权限2")
        UTSAndroid.requestSystemPermission(UTSAndroid.getUniActivity()!!, permissionLocation, fun(allRight: Boolean, _: UTSArray<String>) {
            console.log("权限检查结果")
            if (allRight) {
                console.log("用户同意授权")
                callback(errInfo)
            } else {
                console.log("用户拒绝授权")
                errInfo["errCode"] = -1
                errInfo["msg"] = "用户拒绝授权"
            }
            callback(errInfo)
        }
        , fun(doNotAskAgain: Boolean, grantedList: UTSArray<String>) {
            console.log("用户拒绝授权")
            errInfo["errCode"] = -1
            errInfo["msg"] = "用户拒绝授权"
            callback(errInfo)
        }
        , false)
    }
}
val singleLocation = fun(mode: String, purpose: String, needAddress: Boolean, success: (location: UTSJSONObject) -> Unit, fail: (reson: LocationError) -> Unit) {
    checkAndRequestStoragePermissionInside(fun(res: UTSJSONObject){
        var code = res["errCode"] as Number
        if (code == 0) {
            console.log("开始单次定位")
            var option = AMapLocationClientOption()
            option.setOnceLocation(true)
            option.setNeedAddress(needAddress)
            option.setMockEnable(true)
            option.setOnceLocationLatest(false)
            when (mode) {
                LocationMode__1.Battery.toString() -> 
                    option.setLocationMode(AMapLocationClientOption.AMapLocationMode.Battery_Saving)
                LocationMode__1.Hight.toString() -> 
                    option.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy)
                LocationMode__1.Device.toString() -> 
                    option.setLocationMode(AMapLocationClientOption.AMapLocationMode.Device_Sensors)
                else -> 
                    {}
            }
            when (purpose) {
                LocationPurpose__1.None.toString() -> 
                    {}
                LocationPurpose__1.SignIn.toString() -> 
                    option.setLocationPurpose(AMapLocationClientOption.AMapLocationPurpose.SignIn)
                LocationPurpose__1.Sport.toString() -> 
                    option.setLocationPurpose(AMapLocationClientOption.AMapLocationPurpose.Sport)
                LocationPurpose__1.Transport.toString() -> 
                    option.setLocationPurpose(AMapLocationClientOption.AMapLocationPurpose.Transport)
                else -> 
                    {}
            }
            IBoxsAmap.singleLocation(option, fun(result: AMapLocation) {
                console.log(result)
                var r: UTSJSONObject = JSON.parseObject(result.toStr()) as UTSJSONObject
                success(r)
            }, fun(ex: String) {
                fail(LocationError(errCode = -1, reson = ex))
            })
        } else {
            fail(LocationError(errCode = if (code == -1) {
                -100
            } else {
                code
            }
            , reson = "获取权限失败"))
        }
    }
    )
}
val continuousLocation = fun(interval: Number, mode: LocationMode__1, purpose: LocationPurpose__1, needAddress: Boolean, success: (location: UTSJSONObject) -> Unit, fail: (reson: LocationError) -> Unit) {
    checkAndRequestStoragePermissionInside(fun(res: UTSJSONObject){
        var code = res["errCode"] as Number
        if (code == 0) {
            var option = AMapLocationClientOption()
            option.setOnceLocation(false)
            option.setNeedAddress(needAddress)
            option.setMockEnable(true)
            option.setInterval(interval.toLong())
            when (mode) {
                LocationMode__1.Battery -> 
                    option.setLocationMode(AMapLocationClientOption.AMapLocationMode.Battery_Saving)
                LocationMode__1.Hight -> 
                    option.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy)
                LocationMode__1.Device -> 
                    option.setLocationMode(AMapLocationClientOption.AMapLocationMode.Device_Sensors)
                else -> 
                    {}
            }
            when (purpose) {
                LocationPurpose__1.None -> 
                    {}
                LocationPurpose__1.SignIn -> 
                    option.setLocationPurpose(AMapLocationClientOption.AMapLocationPurpose.SignIn)
                LocationPurpose__1.Sport -> 
                    option.setLocationPurpose(AMapLocationClientOption.AMapLocationPurpose.Sport)
                LocationPurpose__1.Transport -> 
                    option.setLocationPurpose(AMapLocationClientOption.AMapLocationPurpose.Transport)
                else -> 
                    {}
            }
            IBoxsAmap.continuousLocation(option, fun(result: AMapLocation) {
                console.log(result)
                var r: UTSJSONObject = JSON.parseObject(result.toStr()) as UTSJSONObject
                success(r)
            })
        } else {
            fail(LocationError(errCode = if (code == -1) {
                -100
            } else {
                code
            }
            , reson = "获取权限失败"))
        }
    }
    )
}
val stopLocation = fun() {
    IBoxsAmap.stopContinuousLocation()
}
val chooseLocation = fun(): UTSPromise<UTSJSONObject> {
    return wrapUTSPromise(suspend w@{
            var res = await(UTSPromise(fun(resolve, reject){
                console.log("开始选择位置")
                uni_navigateTo(NavigateToOptions(url = "/uni_modules/iboxs-amap/pages/chooselocation", animationType = "slide-in-bottom"))
                uni__once("/uni_modules/iboxs-amap/pages/chooselocation", fun(data: UTSJSONObject) {
                    console.log("收到返回信息", data)
                    resolve(data)
                    uni_navigateBack(null)
                }
                )
            }
            ))
            return@w res
    })
}
val openLocation = fun(lat: Number, lng: Number, distance: Number, title: String, address: String) {
    var params = "lat=" + lat + "&lng=" + lng + "&title=" + encodeURIComponent(title) + "&distance=" + distance + "&address=" + encodeURIComponent(address)
    var url = "/uni_modules/iboxs-amap/pages/showlocation?" + params
    uni_navigateTo(NavigateToOptions(url = url, animationType = "slide-in-bottom"))
}
val getInstalledMapApps = fun(): UTSArray<String> {
    var list = IBoxsAmap.getInstalledMapApps(UTSAndroid.getUniActivity()!!)
    var result = _uA<String>()
    var len = list.size
    run {
        var i: Number = 0
        while(i < len){
            result.push(list[i as Int] as String)
            i++
        }
    }
    return result
}
val openMapNavigation = fun(app: String, latlng: LatLng, address: String) {
    IBoxsAmap.openMapNavigation(UTSAndroid.getUniActivity()!!, address, latlng.lat as Double, latlng.lng as Double, app)
}
val bitmapDescriptorFrom = fun(icon: String?, cb: (bitmapDescriptor: BitmapDescriptor) -> Unit) {
    var iconBase64Bitmap: Bitmap? = null
    if (iconBase64Bitmap != null) {
        var bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(iconBase64Bitmap)
        cb(bitmapDescriptor!!)
    } else if (icon != null) {
        if (icon!!.startsWith("http")) {
            UTSAndroid.getDispatcher("io").async(fun(_) {
                console.log("" + icon + "读取本地缓存")
                var bitmap: Bitmap?
                var file = File(UTSAndroid.getUniActivity()!!.getCacheDir(), icon!!.hashCode().toString())
                if (file.exists()) {
                    console.log("" + icon + " 存在本地缓存图片")
                    bitmap = BitmapFactory.decodeFile(file.getAbsolutePath())
                } else {
                    console.log("" + icon + " 本地无缓存图片，从网络获取")
                    bitmap = BitmapFactory.decodeStream(URL(icon!!).openStream())
                    var fos = FileOutputStream(file)
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos)
                    fos.close()
                }
                var bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(bitmap)
                cb(bitmapDescriptor!!)
            }
            , null)
        }
    }
}
val poiAroundSearch = fun(keywords: String, center: LatLng, radius: Number, cityCode: String, limit: Number, count: Number, success: (res: PoiListResult) -> Unit, fail: (err: String) -> Unit) {
    IBoxsAmap.poiAroundSearch(UTSAndroid.getUniActivity()!!, keywords, center.lat.toDouble(), center.lng.toDouble(), radius.toInt(), cityCode, limit.toInt(), count.toInt(), fun(res: PoiResult) {
        var count = res.getPageCount()
        var list: ArrayList<PoiItem> = res.getPois()
        var len = list.size
        console.log(list, len)
        var listRes = _uA<Poi>()
        run {
            var i: Number = 0
            while(i < len){
                var item: PoiItem = list[i.toInt()] as PoiItem
                var point = item.getLatLonPoint() as LatLonPoint
                listRes.push(Poi(adCode = item.getAdCode(), adName = item.getAdName(), businessArea = item.getBusinessArea(), cityCode = item.getCityCode(), cityName = item.getCityName(), direction = item.getDirection(), distance = item.getDistance(), id = item.getPoiId(), province = item.getProvinceName(), provinceCode = item.getProvinceCode(), address = item.getSnippet(), title = item.getTitle(), typeCode = item.getTypeCode(), typeDes = item.getTypeDes(), latlng = LatLng(lat = point.getLatitude(), lng = point.getLongitude())))
                i++
            }
        }
        var r = PoiListResult(pageCount = count, list = listRes, time = Date().getTime())
        success(r)
    }
    , fun(err: AMapException) {
        var reson = err.getErrorMessage()
        fail(reson)
    }
    )
}
