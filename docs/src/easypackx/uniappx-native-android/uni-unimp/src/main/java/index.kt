@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.uniUnimp
import android.app.Application
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import com.squareup.picasso.Picasso
import io.dcloud.common.adapter.util.DeviceInfo
import io.dcloud.feature.internal.splash.SplashViewDBackground
import io.dcloud.feature.sdk.DCSDKInitConfig
import io.dcloud.feature.sdk.DCUniMPSDK
import io.dcloud.feature.sdk.Interface.IDCUniMPAppSplashView
import io.dcloud.feature.sdk.Interface.IMenuButtonClickCallBack
import io.dcloud.feature.sdk.Interface.IOnUniMPEventCallBack
import io.dcloud.feature.sdk.Interface.IUniMP
import io.dcloud.feature.sdk.MenuActionSheetItem
import io.dcloud.feature.unimp.DCUniMPJSCallback
import io.dcloud.feature.unimp.config.IUniMPReleaseCallBack
import io.dcloud.feature.unimp.config.UniMPOpenConfiguration
import io.dcloud.feature.unimp.config.UniMPReleaseConfiguration
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
import kotlin.properties.Delegates
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import org.json.JSONObject
open class UniMPDefSplash : IDCUniMPAppSplashView {
    open var background: SplashViewDBackground? = null
    open var bitmap: Bitmap? = null
    open var hostIcon: String = ""
    override fun getSplashView(context: Context?, appid: String?, appName: String?, icon: String?): View {
        this.background = SplashViewDBackground(context, this.bitmap, appName!!, false)
        if (icon != null && icon != "") {
            UTSAndroid.getDispatcher("io").async(fun(_) {
                try {
                    if (icon.startsWith("https://") || icon.startsWith("http://")) {
                        this.bitmap = Picasso.get().load(icon).get()
                    } else {
                        this.bitmap = Picasso.get().load(File(icon)).get()
                    }
                } catch (e: Exception) {
                    console.log("load error:", e)
                }
                UTSAndroid.getDispatcher("main").async(fun(_) {
                    if (this.bitmap != null) {
                        this.background!!.setImageBitmap(this.bitmap)
                    }
                }, null)
            }, null)
        } else {
            this.bitmap = BitmapFactory.decodeResource(context!!.getResources(), context!!.getApplicationInfo().icon)
            if (this.bitmap != null) {
                this.background!!.setImageBitmap(this.bitmap)
            }
        }
        return this.background!!
    }
    override fun onCloseSplash(rootView: ViewGroup?): Unit {
        rootView!!.removeView(this.background)
        this.background = null
    }
}
open class InstallUniMPOptions (
    @JsonNotNull
    open var appid: String,
    @JsonNotNull
    open var wgtFile: String,
    open var password: String? = null,
    open var success: ((res: UniMPResult) -> Unit)? = null,
    open var fail: ((res: UniMPFail) -> Unit)? = null,
    open var complete: ((res: Any) -> Unit)? = null,
) : UTSObject()
open class OpenUniMPOptions (
    @JsonNotNull
    open var appid: String,
    open var icon: String? = null,
    open var path: String? = null,
    open var extraData: UTSJSONObject? = null,
    open var fromAppid: String? = null,
    open var scene: Number? = null,
    open var openMode: String? = null,
    open var enableGestureClose: Boolean? = null,
    open var enableShowAnimated: Boolean? = null,
    open var enableHideAnimated: Boolean? = null,
    open var enableBackground: Boolean? = null,
) : UTSObject()
open class UniMPResult (
    @JsonNotNull
    open var type: String,
    @JsonNotNull
    open var code: Number,
    @JsonNotNull
    open var message: String,
) : UTSObject()
open class UniMPEventResult (
    @JsonNotNull
    open var fromAppid: String,
    @JsonNotNull
    open var event: String,
    open var data: Any? = null,
) : UTSObject()
open class VersionInfo (
    @JsonNotNull
    open var name: String,
    @JsonNotNull
    open var code: Number,
) : UTSObject()
open class UniMPVersionResult (
    @JsonNotNull
    open var type: String,
    @JsonNotNull
    open var code: Number,
    open var message: String? = null,
    open var versionInfo: VersionInfo? = null,
) : UTSObject()
open class ActionSheetClickResult (
    @JsonNotNull
    open var appid: String,
    @JsonNotNull
    open var id: String,
) : UTSObject()
open class ActionSheetItem (
    @JsonNotNull
    open var title: String,
    @JsonNotNull
    open var id: String,
) : UTSObject()
open class MenuItemsOptions (
    @JsonNotNull
    open var items: UTSArray<ActionSheetItem>,
) : UTSObject()
typealias UniMPEventCallback = (res: UniMPEventResult) -> Unit
typealias UniMPResultCallback = (res: UniMPResult) -> Unit
typealias UniMPCallback = (res: Any) -> Unit
typealias UniMPVersionResultCallback = (res: UniMPVersionResult) -> Unit
typealias ActionSheetClickResultCallback = (res: ActionSheetClickResult) -> Unit
interface UniMPInstance {
    fun installUniMP(options: InstallUniMPOptions)
    fun openUniMP(options: OpenUniMPOptions)
    fun closeUniMP(appid: String, callback: UniMPResultCallback)
    fun hideUniMP(appid: String, callback: UniMPResultCallback)
    fun showUniMP(appid: String, callback: UniMPResultCallback)
    fun getUniMPVersion(appid: String, callback: UniMPVersionResultCallback)
    fun onUniMPEventReceive(callback: UniMPEventCallback)
    fun sendUniMPEvent(appid: String, event: String, data: UTSJSONObject, callback: UniMPCallback)
    fun setDefaultMenuItems(options: MenuItemsOptions, callback: ActionSheetClickResultCallback)
}
typealias UniMPErrorCode = Number
interface UniMPFail : IUniError {
    override var errCode: UniMPErrorCode
}
typealias CreateUniMPContext = () -> UniMPInstance
val UniErrorSubject = "uni-mp"
val UniErrors: Map<UniMPErrorCode, String> = Map(_uA(
    _uA(
        9010001,
        "No corresponding WGT file found"
    ),
    _uA(
        9010002,
        "unknown error"
    ),
    _uA(
        9010003,
        "Wrong Password"
    )
))
fun getErrcode(errCode: Number): UniMPErrorCode {
    val res = UniErrors[errCode]
    return if (res == null) {
        602001
    } else {
        errCode
    }
}
open class UniMPFailImpl : UniError, UniMPFail {
    constructor(errCode: UniMPErrorCode) : super() {
        this.errSubject = UniErrorSubject
        this.errCode = errCode
        this.errMsg = UniErrors[errCode] ?: ""
    }
}
open class AndroidUniMPInstance : UniMPInstance {
    open var appMap: Map<String, IUniMP> = Map()
    public override fun installUniMP(options: InstallUniMPOptions) {
        var releaseConfig = UniMPReleaseConfiguration()
        releaseConfig.wgtPath = options.wgtFile
        if (options.password != null) {
            releaseConfig.password = options.password
        }
        open class ReleaseCallbak : IUniMPReleaseCallBack {
            override fun onCallBack(pType: Int, pArgs: Any): Unit {
                if (pType == 1) {
                    var ret = UniMPResult("success", 0, "")
                    options?.success?.invoke(ret)
                    options?.complete?.invoke(ret)
                } else if (pType == -4) {
                    var error = UniMPFailImpl(getErrcode(9010001))
                    options?.fail?.invoke(error)
                    options?.complete?.invoke(error)
                } else if (pType == -5) {
                    var error = UniMPFailImpl(getErrcode(9010003))
                    options?.fail?.invoke(error)
                    options?.complete?.invoke(error)
                } else {
                    var error = UniMPFailImpl(getErrcode(9010002))
                    error.errMsg = pArgs.toString()
                    options?.fail?.invoke(error)
                    options?.complete?.invoke(error)
                }
            }
        }
        UTSAndroid.getDispatcher("io").async(fun(_) {
            var releaseCallback = ReleaseCallbak()
            DCUniMPSDK.getInstance().releaseWgtToRunPath(options.appid, releaseConfig, releaseCallback)
        }
        , null)
    }
    public override fun openUniMP(options: OpenUniMPOptions) {
        var uniMPOpenConfiguration = UniMPOpenConfiguration()
        if (options.path != null) {
            uniMPOpenConfiguration.path = options.path
        }
        if (options.extraData != null) {
            uniMPOpenConfiguration.extraData = JSONObject(options.extraData!!.toMap())
        }
        var splash = UniMPDefSplash()
        var mpInfo = JSONObject()
        if (options.fromAppid != null) {
            mpInfo.put("fromAppid", options.fromAppid!!)
        }
        if (options.icon != null) {
            mpInfo.put("icon", options.icon!!)
        }
        uniMPOpenConfiguration.splashClass = splash::class.java
        var hostMP = DCUniMPSDK.getInstance().openUniMPForX(UTSAndroid.getAppContext(), options.appid, uniMPOpenConfiguration, mpInfo)
        this.appMap.set(options.appid, hostMP)
    }
    public override fun closeUniMP(appid: String, callback: UniMPResultCallback) {
        var appInstance = this.appMap.get(appid)
        if (appInstance == null) {
            var ret = UniMPResult("fail", -1, "应用实例不存在")
            callback?.invoke(ret)
            return
        }
        appInstance.closeUniMP()
        var ret = UniMPResult("success", 0, "")
        callback?.invoke(ret)
    }
    public override fun hideUniMP(appid: String, callback: UniMPResultCallback) {
        var appInstance = this.appMap.get(appid)
        if (appInstance == null) {
            var ret = UniMPResult("fail", -1, "应用实例不存在")
            callback?.invoke(ret)
            return
        }
        appInstance.hideUniMP()
        var ret = UniMPResult("success", 0, "")
        callback?.invoke(ret)
    }
    public override fun showUniMP(appid: String, callback: UniMPResultCallback) {
        var appInstance = this.appMap.get(appid)
        if (appInstance == null) {
            var ret = UniMPResult("fail", -1, "应用实例不存在")
            callback?.invoke(ret)
            return
        }
        appInstance.showUniMP()
        var ret = UniMPResult("success", 0, "")
        callback?.invoke(ret)
    }
    public override fun getUniMPVersion(appid: String, callback: UniMPVersionResultCallback) {
        var versionInfo = DCUniMPSDK.getInstance().getAppVersionInfo(appid)
        if (versionInfo == null) {
            var versionRet = UniMPVersionResult("fail", -1)
            callback?.invoke(versionRet)
            return
        }
        var nameStr = versionInfo.getString("name")
        var codeInt = versionInfo.getInt("code")
        var versionInfoRet = VersionInfo(nameStr, codeInt)
        var versionRet = UniMPVersionResult("success", 0, "", versionInfoRet)
        callback(versionRet)
    }
    public override fun onUniMPEventReceive(clientCallback: UniMPEventCallback) {
        open class CustomIOnUniMPEventCallBack : IOnUniMPEventCallBack {
            override fun onUniMPEventReceive(appid: String, event: String, data: Any?, callback: DCUniMPJSCallback): Unit {
                console.log(data)
                console.log(UTSAndroid.getJavaClass(data!!))
                var eventResult = UniMPEventResult(appid, event, data)
                clientCallback(eventResult)
            }
        }
        DCUniMPSDK.getInstance().setOnUniMPEventCallBack(CustomIOnUniMPEventCallBack())
    }
    public override fun sendUniMPEvent(appid: String, event: String, data: UTSJSONObject, callback: UniMPCallback) {
        var appInstance = this.appMap.get(appid)
        if (appInstance == null) {
            var ret = UniMPResult("fail", -1, "应用实例不存在")
            callback?.invoke(ret)
            return
        }
        var dataJson = data.toJSONObject()
        appInstance.sendUniMPEvent(event, dataJson)
    }
    public override fun setDefaultMenuItems(options: MenuItemsOptions, callback: ActionSheetClickResultCallback) {
        val sheetItems = options.items.map(fun(x: ActionSheetItem): MenuActionSheetItem {
            return MenuActionSheetItem(x.title, x.id)
        }
        )
        DCUniMPSDK.getInstance().updateSheetItems(sheetItems)
        open class CustomIMenuButtonClickCallBack : IMenuButtonClickCallBack {
            override fun onClick(appid: String, id: String): Unit {
                var actionRet = ActionSheetClickResult(appid, id)
                callback(actionRet)
            }
        }
        DCUniMPSDK.getInstance().setDefMenuButtonClickCallBack(CustomIMenuButtonClickCallBack())
    }
}
val createUniMPContext: CreateUniMPContext = fun(): UniMPInstance {
    return AndroidUniMPInstance()
}
interface Uni {
    fun createUniMPContext(): CreateUniMPContext
}
open class AppHookProxy : UTSAndroidHookProxy {
    override fun onCreate(application: Application) {
        UTSAndroid.setPrivacyAgree(true)
        if (UTSAndroid.isPrivacyAgree()) {
            if (Build.VERSION.SDK_INT >= 28) {
                var processName = ProcessUtil.getCurrentProcessName(application)
                console.log("processName", processName)
                console.log("application.getPackageName()", application.getPackageName())
                if (processName != null && processName != application.getPackageName()) {
                    console.log("setDataDirectorySuffix processName", processName)
                    WebView.setDataDirectorySuffix(processName)
                }
            }
            Picasso.setSingletonInstance(Picasso.Builder(application).build())
            DeviceInfo.init(application)
            DeviceInfo.initPath(application)
            var config = DCSDKInitConfig.Builder().setCapsule(true).build()
            DCUniMPSDK.getInstance().initialize(application, config)
        }
    }
}
