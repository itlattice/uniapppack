package uts.sdk.modules.iboxsAmap

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import com.amap.api.location.AMapLocationClient
import com.amap.api.location.AMapLocationClientOption
import com.amap.api.location.AMapLocationListener
import com.amap.api.location.AMapLocation
import com.amap.api.services.core.AMapException
import com.amap.api.services.core.LatLonPoint
import com.amap.api.services.poisearch.PoiResult
import com.amap.api.services.poisearch.PoiSearch
import com.amap.api.services.core.PoiItem
import io.dcloud.uts.console

object IBoxsAmap {

    private lateinit var locationClient: AMapLocationClient
    private var isContinuousLocation = false

    // 初始化定位客户端（可在应用启动时调用）
    fun init(applicationContext: android.content.Context) {
        if (!::locationClient.isInitialized) {
            locationClient = AMapLocationClient(applicationContext)
        }
    }

    // 周边POI检索
    fun poiAroundSearch(
        activity: Activity,
        keyword: String?,
        centerLat: Double,
        centerLon: Double,
        radius: Int,
        cityCode: String?,
        pageSize: Int,
        pageNum: Int,
        success: (PoiResult) -> Unit,
        fail: (AMapException) -> Unit
    ) {
        console.log("执行检索")
        val query = PoiSearch.Query(keyword, "", cityCode)
        query.pageSize = pageSize // 设置每页最多返回多少条poiitem
        query.pageNum = pageNum   // 设置查第一页

        val lp = LatLonPoint(centerLat, centerLon)
        val bound = PoiSearch.SearchBound(lp, radius, true)
        val poiSearch = PoiSearch(activity, query)
        poiSearch.bound = bound

        poiSearch.setOnPoiSearchListener(object : PoiSearch.OnPoiSearchListener {
            override fun onPoiSearched(result: PoiResult?, rCode: Int) {
                console.log("检索结果", rCode)
                if (rCode == AMapException.CODE_AMAP_SUCCESS) {
                    if (result != null) {
                        success(result)
                    }
                } else {
                    val exception = AMapException(
                        "POI搜索失败，错误码: $rCode"
                    )
                    fail(exception)
                }
            }

            override fun onPoiItemSearched(p0: PoiItem?, p1: Int) {
                // 不需要处理
            }
        })
        poiSearch.searchPOIAsyn()
    }

    // 获取 Android 设备上安装的地图 APP
    fun getInstalledMapApps(activity: Activity): List<String> {
        val packageManager = activity.packageManager
        val installedApps = packageManager.getInstalledApplications(PackageManager.GET_META_DATA)
        val mapApps = mutableListOf<String>()
        val mapPackages = listOf(
            "com.autonavi.minimap", // 高德地图
            "com.baidu.BaiduMap",  // 百度地图
            "com.tencent.map"      // 腾讯地图
        )
        for (app in installedApps) {
            if (mapPackages.contains(app.packageName)) {
                mapApps.add(app.packageName)
            }
        }
        return mapApps
    }

    // 传入地址和坐标打开地图 APP 导航
    fun openMapNavigation(activity: Activity, address: String, lat: Double, lon: Double, mapApp: String? = null) {
        val mapApps = getInstalledMapApps(activity)
        if (mapApps.isNotEmpty()) {
            // 如果指定了地图 APP 且该 APP 已安装，则使用指定的 APP
            val targetApp = if (mapApp != null && mapApps.contains(mapApp)) {
                mapApp
            } else {
                // 否则使用第一个找到的地图 APP
                mapApps[0]
            }

            val uri = Uri.parse("geo:$lat,$lon?q=$address")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.setPackage(targetApp)

            // 检查是否有 APP 可以处理该 Intent
            if (activity.packageManager.queryIntentActivities(intent, 0).isNotEmpty()) {
                activity.startActivity(intent)
            } else {
                console.log("没有找到可以处理导航请求的地图 APP")
            }
        } else {
            console.log("没有找到任何地图 APP")
        }
    }
	
	// 单次定位
	fun singleLocation(
		option: AMapLocationClientOption,
		success: (AMapLocation) -> Unit,
		fail: (String) -> Unit
	) {
		if (!::locationClient.isInitialized) {
			fail("定位客户端未初始化")
			return
		}
		
		// 创建一个新的监听器实例
		val listener = object : AMapLocationListener {
			override fun onLocationChanged(location: AMapLocation?) {
				// 停止定位并移除监听器
				locationClient.stopLocation()
				locationClient.unRegisterLocationListener(this)
				
				if (location != null) {
					if (location.errorCode == 0) {
						success(location)
					} else {
						fail("定位失败，错误码: ${location.errorCode}，错误信息: ${location.errorInfo}")
					}
				} else {
					fail("定位结果为空")
				}
			}
		}
		
		// 移除之前的定位监听器
		locationClient.unRegisterLocationListener(null) // 移除所有监听器
		locationClient.setLocationOption(option)
		locationClient.setLocationListener(listener)
		locationClient.startLocation()
	}

	// 持续定位
	fun continuousLocation(option: AMapLocationClientOption, locationListener: AMapLocationListener) {
		if (!::locationClient.isInitialized) {
			console.log("定位客户端未初始化")
			return
		}
		
		// 移除之前的定位监听器
		locationClient.unRegisterLocationListener(null) // 移除所有监听器
		
		// 设置选项和监听器
		locationClient.setLocationOption(option)
		locationClient.setLocationListener(locationListener)
		locationClient.startLocation()
		isContinuousLocation = true
	}

	// 停止持续定位
	fun stopContinuousLocation() {
		if (::locationClient.isInitialized && isContinuousLocation) {
			locationClient.stopLocation()
			// 移除所有定位监听器
			locationClient.unRegisterLocationListener(null)
			isContinuousLocation = false
		}
	}
}