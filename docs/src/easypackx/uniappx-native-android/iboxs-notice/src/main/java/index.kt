@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.iboxsNotice
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.itgz8.notice.NoticeUtils
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
open class ContentNotice (
    @JsonNotNull
    open var title: String,
    @JsonNotNull
    open var content: String,
    @JsonNotNull
    open var noticeID: Number,
    open var isImportant: Boolean? = null,
    open var callback: ((noticeID: Int) -> Unit)? = null,
) : UTSObject()
open class GroupNotice (
    @JsonNotNull
    open var groupKey: String,
    @JsonNotNull
    open var summaryTitle: String,
    @JsonNotNull
    open var title: String,
    @JsonNotNull
    open var content: String,
    @JsonNotNull
    open var noticeID: Int = 0,
    @JsonNotNull
    open var summaryNotificationId: Int = 0,
    open var isImportant: Boolean? = null,
    open var callback: ((noticeID: Int) -> Unit)? = null,
) : UTSObject()
val requestNoticePermission = fun(callback: (r: Boolean) -> Unit) {
    var permission = _uA(
        "android.permission.POST_NOTIFICATIONS"
    )
    UTSAndroid.requestSystemPermission(UTSAndroid.getUniActivity()!!, permission, fun(allRight: Boolean, grantedList: UTSArray<String>) {
        callback(true)
    }
    , fun(doNotAskAgain: Boolean, grantedList: UTSArray<String>) {
        if (doNotAskAgain) {
            callback(false)
        } else {
            callback(false)
        }
    }
    )
}
val initNotice = fun() {
    NoticeUtils.init(UTSAndroid.getAppContext() as Context)
}
val sendContentNotice = fun(options: ContentNotice) {
    NoticeUtils.showTextNotification(UTSAndroid.getAppContext() as Context, options.title, options.content, options.noticeID.toInt(), null, if (options.isImportant == null) {
        false
    } else {
        (options.isImportant as Boolean)
    }
    , Notice.getClickCallBack(options.callback))
}
val playRingtoneOnce = fun(soundUri: String): Unit {
    NoticeUtils.playRingtoneOnce(UTSAndroid.getAppContext() as Context, soundUri)
}
val stopCurrentRingtone = fun(soundUri: String): Unit {
    NoticeUtils.stopCurrentRingtone()
}
val sendGroupNotice = fun(options: GroupNotice) {
    NoticeUtils.showGroupedNotification(UTSAndroid.getAppContext() as Context, options.groupKey, options.summaryTitle, options.title, options.content, options.noticeID.toInt(), options.summaryNotificationId.toInt(), if (options.isImportant == null) {
        false
    } else {
        (options.isImportant as Boolean)
    }
    , Notice.getClickCallBack(options.callback))
}
