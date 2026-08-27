package uts.sdk.modules.iboxsQuicklogin

import android.app.Activity
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.Log
import cn.jiguang.verifysdk.api.JVerificationInterface
import cn.jiguang.verifysdk.api.RequestCallback
import cn.jiguang.verifysdk.api.JVerifyUIClickCallback
import cn.jiguang.verifysdk.api.PreLoginListener
import cn.jiguang.verifysdk.api.AuthPageEventListener
import cn.jiguang.verifysdk.api.VerifyListener
import cn.jiguang.verifysdk.api.LoginSettings
import cn.jiguang.verifysdk.api.JVerifyUIConfig
import cn.jiguang.verifysdk.api.PrivacyBean
import androidx.compose.ui.graphics.Color
import io.dcloud.uts.console
import org.json.JSONObject
import android.widget.Toast
import android.widget.Button
import android.view.View
import android.view.Gravity
import android.widget.RelativeLayout

object IBoxsQuickLogin {
    /**
     * 初始化
     * @param context 应用上下文
     */
    fun init(context: Context,complete:(Int,String)->Unit) {
		JVerificationInterface.setDebugMode(true);
		JVerificationInterface.init(context,5000,object : RequestCallback<String> {
			override fun onResult(code: Int, msg:String) {
				console.log("初始化结果",code,msg)
				complete(code,msg)
			}
		});
    }
	
	/**
	 * 初始化是否成功
	 */
	fun initSuccess():Boolean{
		var isSuccess = JVerificationInterface.isInitSuccess()
		return isSuccess
	}
	/**
	 * 判断当前网络运营商
	 */
	fun getOperatorType(context: Context):String{
		return JVerificationInterface.operatorType(context)
	}
	/**
	 * 检查当前网络环境是否支持一键登录
	 */
	fun checkVerifyEnable(context: Context):Boolean{
		return JVerificationInterface.checkVerifyEnable(context)
	}
	/**
	 * 检查当前环境是否支持短信登录
	 */	
	fun checkSmsEnable(context:Context):Boolean{
		return JVerificationInterface.checkSmsEnable(context)
	}
	/**
	 * 判断当前预取号是否有效
	 */
	fun isValidePreloginCache(context:Context):Boolean{
		return JVerificationInterface.isValidePreloginCache(context)
	}
	
	fun preLogin(context:Context,timeOut:Int,complete:(Int,String)->Unit){
		console.log("执行")
		JVerificationInterface.preLogin(context, timeOut,object : PreLoginListener {
			override fun onResult(code: Int, content:String, json:JSONObject) {
				console.log("预取号结果",code,content,json)
				complete(code,content)
			}
		});
	}
	
	fun loginAuth(context:Context,event:(Int,String)->Unit,result:(Int, String,String, String)->Unit){
		val resources = context.resources
		val displayMetrics = resources.displayMetrics
		
		val screenWidth = displayMetrics.widthPixels   // 屏幕宽度（像素）
		val screenHeight = displayMetrics.heightPixels // 屏幕高度（像素）
		val dpWidth = screenWidth / displayMetrics.density
		val dpHeight = screenHeight / displayMetrics.density
		val SloganOffsetY = (dpWidth*0.3) + 130
		val privacyList = listOf(
		    PrivacyBean("用户协议", "https://example.com/user_agreement","")
		)
		val toast = Toast(context)
		// val toastMessage = message ?: context.getString(messageRes!!)
		// toast.setText(toastMessage)
		// 设置显示位置
		toast.setGravity(Gravity.CENTER, 0, 0)
		
		var mBtn = Button(context);
		    mBtn.setText("其他方式登录");
		// 设置按钮背景颜色为白色
		mBtn.setBackgroundColor(0xFFFFFFFF.toInt())
		// 设置按钮文字字号为16
		mBtn.textSize = 16f
		// 设置按钮文字颜色为黑色
		mBtn.setTextColor(0xFF333333.toInt())
		mBtn.setBackgroundResource(android.R.color.transparent)
		mBtn.isFocusable = false
		mBtn.isClickable = false
		// 设置按钮的位置偏移，这里假设距离顶部偏移为 SloganOffsetY + 100，距离左边偏移为 20dp
		val layoutParams = RelativeLayout.LayoutParams(
			RelativeLayout.LayoutParams.WRAP_CONTENT,
			RelativeLayout.LayoutParams.WRAP_CONTENT
		)
		layoutParams.topMargin = (SloganOffsetY + (dpWidth*0.3) + 700).toInt()
		layoutParams.leftMargin = ((dpWidth*0.36) * displayMetrics.density).toInt()
		mBtn.layoutParams = layoutParams
					
		var uiConfig:JVerifyUIConfig =JVerifyUIConfig.Builder()
								.setStatusBarColorWithNav(true)
								.setStatusBarDarkMode(true)
								.setNavColor(0xFFFFFFFF.toInt())
								.setNavText("快速登录")
								.setNavReturnBtnHidden(true)
								.setNavTextColor(0xFF000000.toInt())
								.setLogoWidth((dpWidth*0.3).toInt())
								.setLogoHeight((dpWidth*0.3).toInt())
								.setNumberColor(0xFF000000.toInt())
								.setNumberSize(30)
								.setNumberFieldHeight(80)
								.setNumberTextBold(true)
								.setSloganTextColor(0xFFCCCCCC.toInt())
								.setSloganTextSize(14)
								.setSloganOffsetY(SloganOffsetY.toInt())
								.setLogBtnText("一键登录")
								.setLogBtnTextColor(0xFFFFFFFF.toInt())
								.setLogBtnOffsetY((SloganOffsetY + 30).toInt())
								.setLogBtnWidth((dpWidth*0.65).toInt())
								.setLogBtnHeight(50)
								.setLogBtnTextSize(20)
								.setAppPrivacyColor(0xFFCCCCCC.toInt(),0xFF1678FD.toInt())
								.setPrivacyMarginB(30)
								.setPrivacyTextSize(16)
								.setPrivacyText("同意","")
								.enableHintToast(true,toast)
								.enablePrivacyCheckDialog(true)
								.setPrivacyMarginL(20)
								.setPrivacyCheckboxSize(16)
								.setPrivacyCheckDialogTitleTextSize(18)
								.setPrivacyCheckDialogContentTextPaddingT(20)
								.setPrivacyCheckDialogContentTextSize(18)
								.setPrivacyCheckDialogContentTextPaddingB(20)
								.setPrivacyCheckDialogLogBtnWidth((dpWidth*0.5).toInt())
								.setPrivacyCheckDialogContentTextGravity(Gravity.CENTER)
								.setPrivacyCheckDialogContentTextPaddingL(15)
								// .setPrivacyNameAndUrlBeanList(List<PrivacyBean()>)
								.setPrivacyCheckDialogLogBtnHeight(40)
								.addCustomView(mBtn,true,object:JVerifyUIClickCallback{
									override fun onClicked(context:Context,view:View){
										console.log("点击")
									}
								})
								.build()
		JVerificationInterface.setCustomUIWithConfig(uiConfig);
		
		
		var settings = LoginSettings()
		settings.setAutoFinish(true)  // 设置登录完成后是否自动关闭授权页
		settings.setTimeout(5 * 1000)  // 设置超时时间，单位毫秒。 合法范围（5000, 30000], 范围以外默认设置为 10000
		settings.setAuthPageEventListener(object : AuthPageEventListener() {
			override fun onEvent(cmd: Int, msg: String) {
				// 处理授权页事件
				console.log("处理授权页事件",cmd,msg)
				event(cmd,msg)
			}
		})
		JVerificationInterface.loginAuth(context, settings,object : VerifyListener {
			// 添加缺失的方法实现
			override fun onResult(code: Int, content: String,reson:String, json:JSONObject) {
				console.log("授权结果",code,content,reson,json)
				result(code,content,reson,json.toString())
			}
		})
	}
	/**
	 * 关闭授权页
	 */
	fun dismissLoginAuthActivity(needCloseAnim:Boolean,complete:(Int,String)->Unit){
		JVerificationInterface.dismissLoginAuthActivity(true, object:RequestCallback<String> {
			override fun onResult(code:Int, desc:String) {
				complete(code,desc)
			}
		})
	}
	/**
	 * 获取号码认证token
	 */
	fun authToken(context:Context,timeOut:Int,result:(Int,String,String,String)->Unit){
		JVerificationInterface.getToken(context, timeOut,object:VerifyListener{
			override fun onResult(code:Int, content:String, operator:String, json:JSONObject){
				result(code,content,operator,json.toString())
			}
		})
	}
}