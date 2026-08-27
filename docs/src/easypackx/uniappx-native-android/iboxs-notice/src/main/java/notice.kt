package uts.sdk.modules.iboxsNotice
import com.itgz8.notice.NotificationClickCallback
import io.dcloud.uts.console
import android.content.Context
import com.itgz8.notice.NoticeUtils

object Notice{
	fun getClickCallBack(callback:((Int)->Unit)?):NotificationClickCallback?{
		if(callback==null){
			return null
		}
		var clickCallback = object : NotificationClickCallback {
			override fun onNotificationClicked(notificationId: Int) {
				console.log("通知被点击: $notificationId")
				callback(notificationId)
			}
		}
		return clickCallback
	}
}