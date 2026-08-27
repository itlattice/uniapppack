@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNI2971F61
import android.content.Context
import android.view.Choreographer
import android.view.Choreographer.FrameCallback
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
import uts.sdk.modules.iboxsChooseMedia.MediaScanner
import io.dcloud.uniapp.extapi.`$emit` as uni__emit
import io.dcloud.uniapp.extapi.`$off` as uni__off
import io.dcloud.uniapp.extapi.`$once` as uni__once
import uts.sdk.modules.uniUnimp.ActionSheetItem
import uts.sdk.modules.uniUnimp.UniMPEventResult
import uts.sdk.modules.uniUnimp.UniMPInstance
import uts.sdk.modules.uniUnimp.UniMPResult
import uts.sdk.modules.uniUnimp.VersionInfo
import uts.sdk.modules.kuxBroadcastReceiver.BroadcastNameItem
import uts.sdk.modules.kuxBroadcastReceiver.AddActionOptions
import uts.sdk.modules.kuxBroadcastReceiver.RegisterReceiverOptions
import uts.sdk.modules.iboxsScancode.CodeImage
import uts.sdk.modules.iboxsScancode.scanSimpleCode
import uts.sdk.modules.iboxsScancode.SimpleCodeConfig
import uts.sdk.modules.iboxsScancode.SuccessCallback
import uts.sdk.modules.iboxsScancode.CommonResultCallback
import uts.sdk.modules.iboxsScancode.QRCodeType
import uts.sdk.modules.iboxsScancode.deleteFile
import uts.sdk.modules.kuxBroadcastReceiver.KuxBroadcastReceiver
import uts.sdk.modules.uniUnimp.UniMPFail
import uts.sdk.modules.uniUnimp.InstallUniMPOptions
import uts.sdk.modules.uniUnimp.OpenUniMPOptions
import uts.sdk.modules.uniUnimp.MenuItemsOptions
import uts.sdk.modules.kuxBroadcastReceiver.UnregisterReceiverOptions
import io.dcloud.uniapp.extapi.addInterceptor as uni_addInterceptor
import uts.sdk.modules.iboxsCommon.aes256CbcEncrypt
import uts.sdk.modules.iboxsCommon.aes256CbcDecrypt
import uts.sdk.modules.iboxsQuicklogin.authToken
import uts.sdk.modules.iboxsQuicklogin.checkVerifyEnable
import uts.sdk.modules.iboxsQuicklogin.closeAuth
import uts.sdk.modules.iboxsQuicklogin.initQuickLogin
import uts.sdk.modules.iboxsQuicklogin.initSuccess
import uts.sdk.modules.iboxsQuicklogin.isValidePreloginCache
import uts.sdk.modules.iboxsQuicklogin.loginAuth
import uts.sdk.modules.iboxsQuicklogin.preLogin
import uts.sdk.modules.iboxsCommon.binaryStringToDecimal
import io.dcloud.uniapp.extapi.chooseFile as uni_chooseFile
import io.dcloud.uniapp.extapi.chooseImage as uni_chooseImage
import uts.sdk.modules.iboxsChoosemedia.chooseImage
import uts.sdk.modules.iboxsChoosemedia.chooseOptions
import uts.sdk.modules.iboxsChoosemedia.previewImage
import uts.sdk.modules.iboxsChoosemedia.previewMedia
import uts.sdk.modules.iboxsChoosemedia.previewOptions
import io.dcloud.uniapp.extapi.chooseVideo as uni_chooseVideo
import io.dcloud.uniapp.extapi.compressImage as uni_compressImage
import io.dcloud.uniapp.extapi.compressVideo as uni_compressVideo
import io.dcloud.uniapp.extapi.connectSocket as uni_connectSocket
import uts.sdk.modules.uniUnimp.createUniMPContext as uni_createUniMPContext
import uts.sdk.modules.iboxsCommon.decryptByPublicKey
import uts.sdk.modules.iboxsCommon.decryptEncryptedPublicKey
import uts.sdk.modules.iboxsCommon.encryptByPublicKey
import io.dcloud.uniapp.extapi.downloadFile as uni_downloadFile
import io.dcloud.uniapp.extapi.exit as uni_exit
import uts.sdk.modules.iboxsZimfacade.faceVerify
import uts.sdk.modules.iboxsZimfacade.getMetaInfo
import uts.sdk.modules.iboxsZimfacade.initZimfacafe
import uts.sdk.modules.iboxsZimfacade.setUI
import io.dcloud.uniapp.extapi.getAppBaseInfo as uni_getAppBaseInfo
import io.dcloud.uniapp.extapi.getDeviceInfo as uni_getDeviceInfo
import io.dcloud.uniapp.extapi.getFileSystemManager as uni_getFileSystemManager
import io.dcloud.uniapp.extapi.getNetworkType as uni_getNetworkType
import io.dcloud.uniapp.extapi.getStorageSync as uni_getStorageSync
import io.dcloud.uniapp.extapi.getSystemInfoSync as uni_getSystemInfoSync
import uts.sdk.modules.xUuid.getUUID
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
import io.dcloud.uniapp.extapi.hideLoading as uni_hideLoading
import uts.sdk.modules.iboxsSqlite.init as init__1
import uts.sdk.modules.iboxsSqlite.executeSql
import uts.sdk.modules.iboxsSqlite.queryData
import uts.sdk.modules.iboxsSqlite.exportDatabase
import uts.sdk.modules.iboxsQcloudCos.init
import uts.sdk.modules.iboxsQcloudCos.cosUploadFile
import uts.sdk.modules.iboxsPerformance.initPerformance
import uts.sdk.modules.iboxsPerformance.startCrashMonitoring
import uts.sdk.modules.iboxsPerformance.CrashData
import uts.sdk.modules.iboxsPerformance.startRuntimeErrorMonitoring
import uts.sdk.modules.iboxsPerformance.RuntimeErrorData
import uts.sdk.modules.iboxsPerformance.ANRData
import uts.sdk.modules.iboxsPerformance.BlockData
import uts.sdk.modules.iboxsPerformance.startBlockMonitoring
import uts.sdk.modules.iboxsPerformance.startANRMonitoring
import io.dcloud.uniapp.extapi.loadFontFace as uni_loadFontFace
import io.dcloud.uniapp.extapi.makePhoneCall as uni_makePhoneCall
import uts.sdk.modules.tmxCryptoS.md5
import io.dcloud.uniapp.extapi.navigateBack as uni_navigateBack
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
import io.dcloud.uniapp.extapi.onOsThemeChange as uni_onOsThemeChange
import io.dcloud.uniapp.extapi.redirectTo as uni_redirectTo
import io.dcloud.uniapp.extapi.removeStorage as uni_removeStorage
import io.dcloud.uniapp.extapi.removeStorageSync as uni_removeStorageSync
import io.dcloud.uniapp.extapi.request as uni_request
import io.dcloud.uniapp.extapi.rpx2px as uni_rpx2px
import io.dcloud.uniapp.extapi.setAppTheme as uni_setAppTheme
import uts.sdk.modules.iboxsClipboard.setClipboardData
import uts.sdk.modules.iboxsClipboard.SetClipboardDataOption
import io.dcloud.uniapp.extapi.setNavigationBarColor as uni_setNavigationBarColor
import io.dcloud.uniapp.extapi.setStorageSync as uni_setStorageSync
import uts.sdk.modules.tmxCryptoS.sha256
import io.dcloud.uniapp.extapi.shareWithSystem as uni_shareWithSystem
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading
import io.dcloud.uniapp.extapi.showModal as uni_showModal
import uts.sdk.modules.tmxModalS.showModal
import io.dcloud.uniapp.extapi.showToast as uni_showToast
import uts.sdk.modules.tmxToastS.showToast
import uts.sdk.modules.iboxsAmap.singleLocation
import uts.sdk.modules.iboxsAmap.LocationError
import uts.sdk.modules.iboxsAmap.LatLng
import uts.sdk.modules.iboxsAmap.openLocation
import uts.sdk.modules.iboxsAmap.chooseLocation
import uts.sdk.modules.xMd5.str2Md5
import io.dcloud.uniapp.extapi.switchTab as uni_switchTab
import io.dcloud.uniapp.extapi.uploadFile as uni_uploadFile
import uts.sdk.modules.kuxBroadcastReceiver.useBroadcastReceiver
val __gen_lazy_obj_0_11: UTSJSONObject by lazy {
    utsObjOf(*(__gen_hugeObject0_0() + __gen_hugeObject0_1() + __gen_hugeObject0_2() + __gen_hugeObject0_3() + __gen_hugeObject0_4() + __gen_hugeObject0_5() + __gen_hugeObject0_6() + __gen_hugeObject0_7() + __gen_hugeObject0_8() + __gen_hugeObject0_9() + __gen_hugeObject0_10()))
}
fun __gen_hugeObject0_10(): kotlin.Array<kotlin.Pair<String, Any?>> {
    return arrayOf("film-ai-line" to "f5b9", "font-size-ai" to "f5ba", "mixtral-fill" to "f5bb", "mixtral-line" to "f5bc", "movie-2-ai-fill" to "f5bd", "movie-2-ai-line" to "f5be", "mv-ai-fill" to "f5bf", "mv-ai-line" to "f5c0", "perplexity-fill" to "f5c1", "perplexity-line" to "f5c2", "poker-clubs-fill" to "f5c3", "poker-clubs-line" to "f5c4", "poker-diamonds-fill" to "f5c5", "poker-diamonds-line" to "f5c6", "poker-hearts-fill" to "f5c7", "poker-hearts-line" to "f5c8", "poker-spades-fill" to "f5c9", "poker-spades-line" to "f5ca", "safe-3-fill" to "f5cb", "safe-3-line" to "f5cc", "accessibility-fill" to "f5cd", "accessibility-line" to "f5ce", "alarm-add-fill" to "f5cf", "alarm-add-line" to "f5d0", "arrow-down-long-fill" to "f5d1", "arrow-down-long-line" to "f5d2", "arrow-left-down-long-fill" to "f5d3", "arrow-left-down-long-line" to "f5d4", "arrow-left-long-fill" to "f5d5", "arrow-left-long-line" to "f5d6", "arrow-left-up-long-fill" to "f5d7", "arrow-left-up-long-line" to "f5d8", "arrow-right-down-long-fill" to "f5d9", "arrow-right-down-long-line" to "f5da", "arrow-right-long-fill" to "f5db", "arrow-right-long-line" to "f5dc", "arrow-right-up-long-fill" to "f5dd", "arrow-right-up-long-line" to "f5de", "arrow-up-long-fill" to "f5df", "arrow-up-long-line" to "f5e0", "chess-fill" to "f5e1", "chess-line" to "f5e2", "diamond-fill" to "f5e3", "diamond-line" to "f5e4", "diamond-ring-fill" to "f5e5", "diamond-ring-line" to "f5e6", "figma-fill" to "f5e7", "figma-line" to "f5e8", "firefox-browser-fill" to "f5e9", "firefox-browser-line" to "f5ea", "jewelry-fill" to "f5eb", "jewelry-line" to "f5ec", "multi-image-fill" to "f5ed", "multi-image-line" to "f5ee", "no-credit-card-fill" to "f5ef", "no-credit-card-line" to "f5f0", "service-bell-fill" to "f5f1", "service-bell-line" to "f5f2", "ai-agent-fill" to "f5f3", "ai-agent-line" to "f5f4", "ai-generate-2-fill" to "f5f5", "ai-generate-2-line" to "f5f6", "ai-generate-3d-fill" to "f5f7", "ai-generate-3d-line" to "f5f8", "ai" to "f5f9", "apps-ai-fill" to "f5fa", "apps-ai-line" to "f5fb", "atom-fill" to "f5fc", "atom-line" to "f5fd", "book-ai-fill" to "f5fe", "book-ai-line" to "f5ff", "brain-3-fill" to "f600", "brain-3-line" to "f601", "brain-ai-3-fill" to "f602", "brain-ai-3-line" to "f603", "brush-ai-3-fill" to "f604", "brush-ai-3-line" to "f605", "camera-4-fill" to "f606", "camera-4-line" to "f607", "camera-ai-2-fill" to "f608", "camera-ai-2-line" to "f609", "chat-ai-2-fill" to "f60a", "chat-ai-2-line" to "f60b", "chat-ai-3-fill" to "f60c", "chat-ai-3-line" to "f60d", "chat-ai-4-fill" to "f60e", "chat-ai-4-line" to "f60f", "chat-smile-ai-3-fill" to "f610", "chat-smile-ai-3-line" to "f611", "deepseek-fill" to "f612", "deepseek-line" to "f613", "file-ai-2-fill" to "f614", "file-ai-2-line" to "f615", "file-ai-fill" to "f616", "file-ai-line" to "f617", "function-ai-fill" to "f618", "function-ai-line" to "f619", "game-2-fill" to "f61a", "game-2-line" to "f61b", "goblet-broken-fill" to "f61c", "goblet-broken-line" to "f61d", "lightbulb-ai-fill" to "f61e", "lightbulb-ai-line" to "f61f", "loop-left-ai-fill" to "f620", "loop-left-ai-line" to "f621", "loop-right-ai-fill" to "f622", "loop-right-ai-line" to "f623", "message-ai-3-fill" to "f624", "message-ai-3-line" to "f625", "painting-ai-fill" to "f626", "painting-ai-line" to "f627", "painting-fill" to "f628", "painting-line" to "f629", "pencil-ai-2-fill" to "f62a", "pencil-ai-2-line" to "f62b", "pencil-ai-fill" to "f62c", "pencil-ai-line" to "f62d", "remix-fill" to "f62e", "remix-line" to "f62f", "search-ai-2-fill" to "f630", "search-ai-2-line" to "f631", "search-ai-3-fill" to "f632", "search-ai-3-line" to "f633", "search-ai-4-fill" to "f634", "search-ai-4-line" to "f635", "search-ai-fill" to "f636", "search-ai-line" to "f637", "speech-to-text-fill" to "f638", "speech-to-text-line" to "f639", "target-fill" to "f63a", "target-line" to "f63b", "text-to-speech-fill" to "f63c", "text-to-speech-line" to "f63d", "wrench-fill" to "f63e", "wrench-line" to "f63f")
}
fun __gen_hugeObject0_9(): kotlin.Array<kotlin.Pair<String, Any?>> {
    return arrayOf("signpost-fill" to "f48d", "signpost-line" to "f48e", "time-zone-fill" to "f48f", "time-zone-line" to "f490", "arrow-down-wide-fill" to "f491", "arrow-down-wide-line" to "f492", "arrow-left-wide-fill" to "f493", "arrow-left-wide-line" to "f494", "arrow-right-wide-fill" to "f495", "arrow-right-wide-line" to "f496", "arrow-up-wide-fill" to "f497", "arrow-up-wide-line" to "f498", "bluesky-fill" to "f499", "bluesky-line" to "f49a", "expand-height-fill" to "f49b", "expand-height-line" to "f49c", "expand-width-fill" to "f49d", "expand-width-line" to "f49e", "forward-end-fill" to "f49f", "forward-end-line" to "f4a0", "forward-end-mini-fill" to "f4a1", "forward-end-mini-line" to "f4a2", "friendica-fill" to "f4a3", "friendica-line" to "f4a4", "git-pr-draft-fill" to "f4a5", "git-pr-draft-line" to "f4a6", "play-reverse-fill" to "f4a7", "play-reverse-line" to "f4a8", "play-reverse-mini-fill" to "f4a9", "play-reverse-mini-line" to "f4aa", "rewind-start-fill" to "f4ab", "rewind-start-line" to "f4ac", "rewind-start-mini-fill" to "f4ad", "rewind-start-mini-line" to "f4ae", "scroll-to-bottom-fill" to "f4af", "scroll-to-bottom-line" to "f4b0", "add-large-fill" to "f4b1", "add-large-line" to "f4b2", "aed-electrodes-fill" to "f4b3", "aed-electrodes-line" to "f4b4", "aed-fill" to "f4b5", "aed-line" to "f4b6", "alibaba-cloud-fill" to "f4b7", "alibaba-cloud-line" to "f4b8", "align-item-bottom-fill" to "f4b9", "align-item-bottom-line" to "f4ba", "align-item-horizontal-center-fill" to "f4bb", "align-item-horizontal-center-line" to "f4bc", "align-item-left-fill" to "f4bd", "align-item-left-line" to "f4be", "align-item-right-fill" to "f4bf", "align-item-right-line" to "f4c0", "align-item-top-fill" to "f4c1", "align-item-top-line" to "f4c2", "align-item-vertical-center-fill" to "f4c3", "align-item-vertical-center-line" to "f4c4", "apps-2-add-fill" to "f4c5", "apps-2-add-line" to "f4c6", "close-large-fill" to "f4c7", "close-large-line" to "f4c8", "collapse-diagonal-2-fill" to "f4c9", "collapse-diagonal-2-line" to "f4ca", "collapse-diagonal-fill" to "f4cb", "collapse-diagonal-line" to "f4cc", "dashboard-horizontal-fill" to "f4cd", "dashboard-horizontal-line" to "f4ce", "expand-diagonal-2-fill" to "f4cf", "expand-diagonal-2-line" to "f4d0", "expand-diagonal-fill" to "f4d1", "expand-diagonal-line" to "f4d2", "firebase-fill" to "f4d3", "firebase-line" to "f4d4", "flip-horizontal-2-fill" to "f4d5", "flip-horizontal-2-line" to "f4d6", "flip-horizontal-fill" to "f4d7", "flip-horizontal-line" to "f4d8", "flip-vertical-2-fill" to "f4d9", "flip-vertical-2-line" to "f4da", "flip-vertical-fill" to "f4db", "flip-vertical-line" to "f4dc", "formula" to "f4dd", "function-add-fill" to "f4de", "function-add-line" to "f4df", "goblet-2-fill" to "f4e0", "goblet-2-line" to "f4e1", "golf-ball-fill" to "f4e2", "golf-ball-line" to "f4e3", "group-3-fill" to "f4e4", "group-3-line" to "f4e5", "heart-add-2-fill" to "f4e6", "heart-add-2-line" to "f4e7", "id-card-fill" to "f4e8", "id-card-line" to "f4e9", "information-off-fill" to "f4ea", "information-off-line" to "f4eb", "java-fill" to "f4ec", "java-line" to "f4ed", "layout-grid-2-fill" to "f4ee", "layout-grid-2-line" to "f4ef", "layout-horizontal-fill" to "f4f0", "layout-horizontal-line" to "f4f1", "layout-vertical-fill" to "f4f2", "layout-vertical-line" to "f4f3", "menu-fold-2-fill" to "f4f4", "menu-fold-2-line" to "f4f5", "menu-fold-3-fill" to "f4f6", "menu-fold-3-line" to "f4f7", "menu-fold-4-fill" to "f4f8", "menu-fold-4-line" to "f4f9", "menu-unfold-2-fill" to "f4fa", "menu-unfold-2-line" to "f4fb", "menu-unfold-3-fill" to "f4fc", "menu-unfold-3-line" to "f4fd", "menu-unfold-4-fill" to "f4fe", "menu-unfold-4-line" to "f4ff", "mobile-download-fill" to "f500", "mobile-download-line" to "f501", "nextjs-fill" to "f502", "nextjs-line" to "f503", "nodejs-fill" to "f504", "nodejs-line" to "f505", "pause-large-fill" to "f506", "pause-large-line" to "f507", "play-large-fill" to "f508", "play-large-line" to "f509", "play-reverse-large-fill" to "f50a", "play-reverse-large-line" to "f50b", "police-badge-fill" to "f50c", "police-badge-line" to "f50d", "prohibited-2-fill" to "f50e", "prohibited-2-line" to "f50f", "shopping-bag-4-fill" to "f510", "shopping-bag-4-line" to "f511", "snowflake-fill" to "f512", "snowflake-line" to "f513", "square-root" to "f514", "stop-large-fill" to "f515", "stop-large-line" to "f516", "tailwind-css-fill" to "f517", "tailwind-css-line" to "f518", "tooth-fill" to "f519", "tooth-line" to "f51a", "video-off-fill" to "f51b", "video-off-line" to "f51c", "video-on-fill" to "f51d", "video-on-line" to "f51e", "webhook-fill" to "f51f", "webhook-line" to "f520", "weight-fill" to "f521", "weight-line" to "f522", "book-shelf-fill" to "f523", "book-shelf-line" to "f524", "brain-2-fill" to "f525", "brain-2-line" to "f526", "chat-search-fill" to "f527", "chat-search-line" to "f528", "chat-unread-fill" to "f529", "chat-unread-line" to "f52a", "collapse-horizontal-fill" to "f52b", "collapse-horizontal-line" to "f52c", "collapse-vertical-fill" to "f52d", "collapse-vertical-line" to "f52e", "dna-fill" to "f52f", "dna-line" to "f530", "dropper-fill" to "f531", "dropper-line" to "f532", "expand-diagonal-s-2-fill" to "f533", "expand-diagonal-s-2-line" to "f534", "expand-diagonal-s-fill" to "f535", "expand-diagonal-s-line" to "f536", "expand-horizontal-fill" to "f537", "expand-horizontal-line" to "f538", "expand-horizontal-s-fill" to "f539", "expand-horizontal-s-line" to "f53a", "expand-vertical-fill" to "f53b", "expand-vertical-line" to "f53c", "expand-vertical-s-fill" to "f53d", "expand-vertical-s-line" to "f53e", "gemini-fill" to "f53f", "gemini-line" to "f540", "reset-left-fill" to "f541", "reset-left-line" to "f542", "reset-right-fill" to "f543", "reset-right-line" to "f544", "stairs-fill" to "f545", "stairs-line" to "f546", "telegram-2-fill" to "f547", "telegram-2-line" to "f548", "triangular-flag-fill" to "f549", "triangular-flag-line" to "f54a", "user-minus-fill" to "f54b", "user-minus-line" to "f54c", "account-box-2-fill" to "f54d", "account-box-2-line" to "f54e", "account-circle-2-fill" to "f54f", "account-circle-2-line" to "f550", "alarm-snooze-fill" to "f551", "alarm-snooze-line" to "f552", "arrow-down-box-fill" to "f553", "arrow-down-box-line" to "f554", "arrow-left-box-fill" to "f555", "arrow-left-box-line" to "f556", "arrow-left-down-box-fill" to "f557", "arrow-left-down-box-line" to "f558", "arrow-left-up-box-fill" to "f559", "arrow-left-up-box-line" to "f55a", "arrow-right-box-fill" to "f55b", "arrow-right-box-line" to "f55c", "arrow-right-down-box-fill" to "f55d", "arrow-right-down-box-line" to "f55e", "arrow-right-up-box-fill" to "f55f", "arrow-right-up-box-line" to "f560", "arrow-up-box-fill" to "f561", "arrow-up-box-line" to "f562", "bar-chart-box-ai-fill" to "f563", "bar-chart-box-ai-line" to "f564", "brush-ai-fill" to "f565", "brush-ai-line" to "f566", "camera-ai-fill" to "f567", "camera-ai-line" to "f568", "chat-ai-fill" to "f569", "chat-ai-line" to "f56a", "chat-smile-ai-fill" to "f56b", "chat-smile-ai-line" to "f56c", "chat-voice-ai-fill" to "f56d", "chat-voice-ai-line" to "f56e", "code-ai-fill" to "f56f", "code-ai-line" to "f570", "color-filter-ai-fill" to "f571", "color-filter-ai-line" to "f572", "custom-size" to "f573", "fediverse-fill" to "f574", "fediverse-line" to "f575", "flag-off-fill" to "f576", "flag-off-line" to "f577", "home-9-fill" to "f578", "home-9-line" to "f579", "image-ai-fill" to "f57a", "image-ai-line" to "f57b", "image-circle-ai-fill" to "f57c", "image-circle-ai-line" to "f57d", "info-card-fill" to "f57e", "info-card-line" to "f57f", "landscape-ai-fill" to "f580", "landscape-ai-line" to "f581", "letter-spacing-2" to "f582", "line-height-2" to "f583", "mail-ai-fill" to "f584", "mail-ai-line" to "f585", "mic-2-ai-fill" to "f586", "mic-2-ai-line" to "f587", "mic-ai-fill" to "f588", "mic-ai-line" to "f589", "movie-ai-fill" to "f58a", "movie-ai-line" to "f58b", "music-ai-fill" to "f58c", "music-ai-line" to "f58d", "notification-snooze-fill" to "f58e", "notification-snooze-line" to "f58f", "php-fill" to "f590", "php-line" to "f591", "pix-fill" to "f592", "pix-line" to "f593", "pulse-ai-fill" to "f594", "pulse-ai-line" to "f595", "quill-pen-ai-fill" to "f596", "quill-pen-ai-line" to "f597", "speak-ai-fill" to "f598", "speak-ai-line" to "f599", "star-off-fill" to "f59a", "star-off-line" to "f59b", "translate-ai-2" to "f59c", "translate-ai" to "f59d", "user-community-fill" to "f59e", "user-community-line" to "f59f", "vercel-fill" to "f5a0", "vercel-line" to "f5a1", "video-ai-fill" to "f5a2", "video-ai-line" to "f5a3", "video-on-ai-fill" to "f5a4", "video-on-ai-line" to "f5a5", "voice-ai-fill" to "f5a6", "voice-ai-line" to "f5a7", "ai-generate-2" to "f5a8", "ai-generate-text" to "f5a9", "anthropic-fill" to "f5aa", "anthropic-line" to "f5ab", "apps-2-ai-fill" to "f5ac", "apps-2-ai-line" to "f5ad", "camera-lens-ai-fill" to "f5ae", "camera-lens-ai-line" to "f5af", "clapperboard-ai-fill" to "f5b0", "clapperboard-ai-line" to "f5b1", "claude-fill" to "f5b2", "claude-line" to "f5b3", "closed-captioning-ai-fill" to "f5b4", "closed-captioning-ai-line" to "f5b5", "dvd-ai-fill" to "f5b6", "dvd-ai-line" to "f5b7", "film-ai-fill" to "f5b8")
}
fun __gen_hugeObject0_8(): kotlin.Array<kotlin.Pair<String, Any?>> {
    return arrayOf("skip-down-line" to "f361", "skip-left-fill" to "f362", "skip-left-line" to "f363", "skip-right-fill" to "f364", "skip-right-line" to "f365", "skip-up-fill" to "f366", "skip-up-line" to "f367", "slow-down-fill" to "f368", "slow-down-line" to "f369", "sparkling-2-fill" to "f36a", "sparkling-2-line" to "f36b", "sparkling-fill" to "f36c", "sparkling-line" to "f36d", "speak-fill" to "f36e", "speak-line" to "f36f", "speed-up-fill" to "f370", "speed-up-line" to "f371", "tiktok-fill" to "f372", "tiktok-line" to "f373", "token-swap-fill" to "f374", "token-swap-line" to "f375", "unpin-fill" to "f376", "unpin-line" to "f377", "wechat-channels-fill" to "f378", "wechat-channels-line" to "f379", "wordpress-fill" to "f37a", "wordpress-line" to "f37b", "blender-fill" to "f37c", "blender-line" to "f37d", "emoji-sticker-fill" to "f37e", "emoji-sticker-line" to "f37f", "git-close-pull-request-fill" to "f380", "git-close-pull-request-line" to "f381", "instance-fill" to "f382", "instance-line" to "f383", "megaphone-fill" to "f384", "megaphone-line" to "f385", "pass-expired-fill" to "f386", "pass-expired-line" to "f387", "pass-pending-fill" to "f388", "pass-pending-line" to "f389", "pass-valid-fill" to "f38a", "pass-valid-line" to "f38b", "ai-generate" to "f38c", "calendar-close-fill" to "f38d", "calendar-close-line" to "f38e", "draggable" to "f38f", "font-family" to "f390", "font-mono" to "f391", "font-sans-serif" to "f392", "font-sans" to "f393", "hard-drive-3-fill" to "f394", "hard-drive-3-line" to "f395", "kick-fill" to "f396", "kick-line" to "f397", "list-check-3" to "f398", "list-indefinite" to "f399", "list-ordered-2" to "f39a", "list-radio" to "f39b", "openbase-fill" to "f39c", "openbase-line" to "f39d", "planet-fill" to "f39e", "planet-line" to "f39f", "prohibited-fill" to "f3a0", "prohibited-line" to "f3a1", "quote-text" to "f3a2", "seo-fill" to "f3a3", "seo-line" to "f3a4", "slash-commands" to "f3a5", "archive-2-fill" to "f3a6", "archive-2-line" to "f3a7", "inbox-2-fill" to "f3a8", "inbox-2-line" to "f3a9", "shake-hands-fill" to "f3aa", "shake-hands-line" to "f3ab", "supabase-fill" to "f3ac", "supabase-line" to "f3ad", "water-percent-fill" to "f3ae", "water-percent-line" to "f3af", "yuque-fill" to "f3b0", "yuque-line" to "f3b1", "crosshair-2-fill" to "f3b2", "crosshair-2-line" to "f3b3", "crosshair-fill" to "f3b4", "crosshair-line" to "f3b5", "file-close-fill" to "f3b6", "file-close-line" to "f3b7", "infinity-fill" to "f3b8", "infinity-line" to "f3b9", "rfid-fill" to "f3ba", "rfid-line" to "f3bb", "slash-commands-2" to "f3bc", "user-forbid-fill" to "f3bd", "user-forbid-line" to "f3be", "beer-fill" to "f3bf", "beer-line" to "f3c0", "circle-fill" to "f3c1", "circle-line" to "f3c2", "dropdown-list" to "f3c3", "file-image-fill" to "f3c4", "file-image-line" to "f3c5", "file-pdf-2-fill" to "f3c6", "file-pdf-2-line" to "f3c7", "file-video-fill" to "f3c8", "file-video-line" to "f3c9", "folder-image-fill" to "f3ca", "folder-image-line" to "f3cb", "folder-video-fill" to "f3cc", "folder-video-line" to "f3cd", "hexagon-fill" to "f3ce", "hexagon-line" to "f3cf", "menu-search-fill" to "f3d0", "menu-search-line" to "f3d1", "octagon-fill" to "f3d2", "octagon-line" to "f3d3", "pentagon-fill" to "f3d4", "pentagon-line" to "f3d5", "rectangle-fill" to "f3d6", "rectangle-line" to "f3d7", "robot-2-fill" to "f3d8", "robot-2-line" to "f3d9", "shapes-fill" to "f3da", "shapes-line" to "f3db", "square-fill" to "f3dc", "square-line" to "f3dd", "tent-fill" to "f3de", "tent-line" to "f3df", "threads-fill" to "f3e0", "threads-line" to "f3e1", "tree-fill" to "f3e2", "tree-line" to "f3e3", "triangle-fill" to "f3e4", "triangle-line" to "f3e5", "twitter-x-fill" to "f3e6", "twitter-x-line" to "f3e7", "verified-badge-fill" to "f3e8", "verified-badge-line" to "f3e9", "armchair-fill" to "f3ea", "armchair-line" to "f3eb", "bnb-fill" to "f3ec", "bnb-line" to "f3ed", "bread-fill" to "f3ee", "bread-line" to "f3ef", "btc-fill" to "f3f0", "btc-line" to "f3f1", "calendar-schedule-fill" to "f3f2", "calendar-schedule-line" to "f3f3", "dice-1-fill" to "f3f4", "dice-1-line" to "f3f5", "dice-2-fill" to "f3f6", "dice-2-line" to "f3f7", "dice-3-fill" to "f3f8", "dice-3-line" to "f3f9", "dice-4-fill" to "f3fa", "dice-4-line" to "f3fb", "dice-5-fill" to "f3fc", "dice-5-line" to "f3fd", "dice-6-fill" to "f3fe", "dice-6-line" to "f3ff", "dice-fill" to "f400", "dice-line" to "f401", "drinks-fill" to "f402", "drinks-line" to "f403", "equalizer-2-fill" to "f404", "equalizer-2-line" to "f405", "equalizer-3-fill" to "f406", "equalizer-3-line" to "f407", "eth-fill" to "f408", "eth-line" to "f409", "flower-fill" to "f40a", "flower-line" to "f40b", "glasses-2-fill" to "f40c", "glasses-2-line" to "f40d", "glasses-fill" to "f40e", "glasses-line" to "f40f", "goggles-fill" to "f410", "goggles-line" to "f411", "image-circle-fill" to "f412", "image-circle-line" to "f413", "info-i" to "f414", "money-rupee-circle-fill" to "f415", "money-rupee-circle-line" to "f416", "news-fill" to "f417", "news-line" to "f418", "robot-3-fill" to "f419", "robot-3-line" to "f41a", "share-2-fill" to "f41b", "share-2-line" to "f41c", "sofa-fill" to "f41d", "sofa-line" to "f41e", "svelte-fill" to "f41f", "svelte-line" to "f420", "vk-fill" to "f421", "vk-line" to "f422", "xrp-fill" to "f423", "xrp-line" to "f424", "xtz-fill" to "f425", "xtz-line" to "f426", "archive-stack-fill" to "f427", "archive-stack-line" to "f428", "bowl-fill" to "f429", "bowl-line" to "f42a", "calendar-view" to "f42b", "carousel-view" to "f42c", "code-block" to "f42d", "color-filter-fill" to "f42e", "color-filter-line" to "f42f", "contacts-book-3-fill" to "f430", "contacts-book-3-line" to "f431", "contract-fill" to "f432", "contract-line" to "f433", "drinks-2-fill" to "f434", "drinks-2-line" to "f435", "export-fill" to "f436", "export-line" to "f437", "file-check-fill" to "f438", "file-check-line" to "f439", "focus-mode" to "f43a", "folder-6-fill" to "f43b", "folder-6-line" to "f43c", "folder-check-fill" to "f43d", "folder-check-line" to "f43e", "folder-close-fill" to "f43f", "folder-close-line" to "f440", "folder-cloud-fill" to "f441", "folder-cloud-line" to "f442", "gallery-view-2" to "f443", "gallery-view" to "f444", "hand" to "f445", "import-fill" to "f446", "import-line" to "f447", "information-2-fill" to "f448", "information-2-line" to "f449", "kanban-view-2" to "f44a", "kanban-view" to "f44b", "list-view" to "f44c", "lock-star-fill" to "f44d", "lock-star-line" to "f44e", "puzzle-2-fill" to "f44f", "puzzle-2-line" to "f450", "puzzle-fill" to "f451", "puzzle-line" to "f452", "ram-2-fill" to "f453", "ram-2-line" to "f454", "ram-fill" to "f455", "ram-line" to "f456", "receipt-fill" to "f457", "receipt-line" to "f458", "shadow-fill" to "f459", "shadow-line" to "f45a", "sidebar-fold-fill" to "f45b", "sidebar-fold-line" to "f45c", "sidebar-unfold-fill" to "f45d", "sidebar-unfold-line" to "f45e", "slideshow-view" to "f45f", "sort-alphabet-asc" to "f460", "sort-alphabet-desc" to "f461", "sort-number-asc" to "f462", "sort-number-desc" to "f463", "stacked-view" to "f464", "sticky-note-add-fill" to "f465", "sticky-note-add-line" to "f466", "swap-2-fill" to "f467", "swap-2-line" to "f468", "swap-3-fill" to "f469", "swap-3-line" to "f46a", "table-3" to "f46b", "table-view" to "f46c", "text-block" to "f46d", "text-snippet" to "f46e", "timeline-view" to "f46f", "blogger-fill" to "f470", "blogger-line" to "f471", "chat-thread-fill" to "f472", "chat-thread-line" to "f473", "discount-percent-fill" to "f474", "discount-percent-line" to "f475", "exchange-2-fill" to "f476", "exchange-2-line" to "f477", "git-fork-fill" to "f478", "git-fork-line" to "f479", "input-field" to "f47a", "progress-1-fill" to "f47b", "progress-1-line" to "f47c", "progress-2-fill" to "f47d", "progress-2-line" to "f47e", "progress-3-fill" to "f47f", "progress-3-line" to "f480", "progress-4-fill" to "f481", "progress-4-line" to "f482", "progress-5-fill" to "f483", "progress-5-line" to "f484", "progress-6-fill" to "f485", "progress-6-line" to "f486", "progress-7-fill" to "f487", "progress-7-line" to "f488", "progress-8-fill" to "f489", "progress-8-line" to "f48a", "remix-run-fill" to "f48b", "remix-run-line" to "f48c")
}
fun __gen_hugeObject0_7(): kotlin.Array<kotlin.Pair<String, Any?>> {
    return arrayOf("tv-2-line" to "f235", "tv-fill" to "f236", "tv-line" to "f237", "twitch-fill" to "f238", "twitch-line" to "f239", "twitter-fill" to "f23a", "twitter-line" to "f23b", "typhoon-fill" to "f23c", "typhoon-line" to "f23d", "u-disk-fill" to "f23e", "u-disk-line" to "f23f", "ubuntu-fill" to "f240", "ubuntu-line" to "f241", "umbrella-fill" to "f242", "umbrella-line" to "f243", "underline" to "f244", "uninstall-fill" to "f245", "uninstall-line" to "f246", "unsplash-fill" to "f247", "unsplash-line" to "f248", "upload-2-fill" to "f249", "upload-2-line" to "f24a", "upload-cloud-2-fill" to "f24b", "upload-cloud-2-line" to "f24c", "upload-cloud-fill" to "f24d", "upload-cloud-line" to "f24e", "upload-fill" to "f24f", "upload-line" to "f250", "usb-fill" to "f251", "usb-line" to "f252", "user-2-fill" to "f253", "user-2-line" to "f254", "user-3-fill" to "f255", "user-3-line" to "f256", "user-4-fill" to "f257", "user-4-line" to "f258", "user-5-fill" to "f259", "user-5-line" to "f25a", "user-6-fill" to "f25b", "user-6-line" to "f25c", "user-add-fill" to "f25d", "user-add-line" to "f25e", "user-fill" to "f25f", "user-follow-fill" to "f260", "user-follow-line" to "f261", "user-heart-fill" to "f262", "user-heart-line" to "f263", "user-line" to "f264", "user-location-fill" to "f265", "user-location-line" to "f266", "user-received-2-fill" to "f267", "user-received-2-line" to "f268", "user-received-fill" to "f269", "user-received-line" to "f26a", "user-search-fill" to "f26b", "user-search-line" to "f26c", "user-settings-fill" to "f26d", "user-settings-line" to "f26e", "user-shared-2-fill" to "f26f", "user-shared-2-line" to "f270", "user-shared-fill" to "f271", "user-shared-line" to "f272", "user-smile-fill" to "f273", "user-smile-line" to "f274", "user-star-fill" to "f275", "user-star-line" to "f276", "user-unfollow-fill" to "f277", "user-unfollow-line" to "f278", "user-voice-fill" to "f279", "user-voice-line" to "f27a", "video-add-fill" to "f27b", "video-add-line" to "f27c", "video-chat-fill" to "f27d", "video-chat-line" to "f27e", "video-download-fill" to "f27f", "video-download-line" to "f280", "video-fill" to "f281", "video-line" to "f282", "video-upload-fill" to "f283", "video-upload-line" to "f284", "vidicon-2-fill" to "f285", "vidicon-2-line" to "f286", "vidicon-fill" to "f287", "vidicon-line" to "f288", "vimeo-fill" to "f289", "vimeo-line" to "f28a", "vip-crown-2-fill" to "f28b", "vip-crown-2-line" to "f28c", "vip-crown-fill" to "f28d", "vip-crown-line" to "f28e", "vip-diamond-fill" to "f28f", "vip-diamond-line" to "f290", "vip-fill" to "f291", "vip-line" to "f292", "virus-fill" to "f293", "virus-line" to "f294", "visa-fill" to "f295", "visa-line" to "f296", "voice-recognition-fill" to "f297", "voice-recognition-line" to "f298", "voiceprint-fill" to "f299", "voiceprint-line" to "f29a", "volume-down-fill" to "f29b", "volume-down-line" to "f29c", "volume-mute-fill" to "f29d", "volume-mute-line" to "f29e", "volume-off-vibrate-fill" to "f29f", "volume-off-vibrate-line" to "f2a0", "volume-up-fill" to "f2a1", "volume-up-line" to "f2a2", "volume-vibrate-fill" to "f2a3", "volume-vibrate-line" to "f2a4", "vuejs-fill" to "f2a5", "vuejs-line" to "f2a6", "walk-fill" to "f2a7", "walk-line" to "f2a8", "wallet-2-fill" to "f2a9", "wallet-2-line" to "f2aa", "wallet-3-fill" to "f2ab", "wallet-3-line" to "f2ac", "wallet-fill" to "f2ad", "wallet-line" to "f2ae", "water-flash-fill" to "f2af", "water-flash-line" to "f2b0", "webcam-fill" to "f2b1", "webcam-line" to "f2b2", "wechat-2-fill" to "f2b3", "wechat-2-line" to "f2b4", "wechat-fill" to "f2b5", "wechat-line" to "f2b6", "wechat-pay-fill" to "f2b7", "wechat-pay-line" to "f2b8", "weibo-fill" to "f2b9", "weibo-line" to "f2ba", "whatsapp-fill" to "f2bb", "whatsapp-line" to "f2bc", "wheelchair-fill" to "f2bd", "wheelchair-line" to "f2be", "wifi-fill" to "f2bf", "wifi-line" to "f2c0", "wifi-off-fill" to "f2c1", "wifi-off-line" to "f2c2", "window-2-fill" to "f2c3", "window-2-line" to "f2c4", "window-fill" to "f2c5", "window-line" to "f2c6", "windows-fill" to "f2c7", "windows-line" to "f2c8", "windy-fill" to "f2c9", "windy-line" to "f2ca", "wireless-charging-fill" to "f2cb", "wireless-charging-line" to "f2cc", "women-fill" to "f2cd", "women-line" to "f2ce", "wubi-input" to "f2cf", "xbox-fill" to "f2d0", "xbox-line" to "f2d1", "xing-fill" to "f2d2", "xing-line" to "f2d3", "youtube-fill" to "f2d4", "youtube-line" to "f2d5", "zcool-fill" to "f2d6", "zcool-line" to "f2d7", "zhihu-fill" to "f2d8", "zhihu-line" to "f2d9", "zoom-in-fill" to "f2da", "zoom-in-line" to "f2db", "zoom-out-fill" to "f2dc", "zoom-out-line" to "f2dd", "zzz-fill" to "f2de", "zzz-line" to "f2df", "arrow-down-double-fill" to "f2e0", "arrow-down-double-line" to "f2e1", "arrow-left-double-fill" to "f2e2", "arrow-left-double-line" to "f2e3", "arrow-right-double-fill" to "f2e4", "arrow-right-double-line" to "f2e5", "arrow-turn-back-fill" to "f2e6", "arrow-turn-back-line" to "f2e7", "arrow-turn-forward-fill" to "f2e8", "arrow-turn-forward-line" to "f2e9", "arrow-up-double-fill" to "f2ea", "arrow-up-double-line" to "f2eb", "bard-fill" to "f2ec", "bard-line" to "f2ed", "bootstrap-fill" to "f2ee", "bootstrap-line" to "f2ef", "box-1-fill" to "f2f0", "box-1-line" to "f2f1", "box-2-fill" to "f2f2", "box-2-line" to "f2f3", "box-3-fill" to "f2f4", "box-3-line" to "f2f5", "brain-fill" to "f2f6", "brain-line" to "f2f7", "candle-fill" to "f2f8", "candle-line" to "f2f9", "cash-fill" to "f2fa", "cash-line" to "f2fb", "contract-left-fill" to "f2fc", "contract-left-line" to "f2fd", "contract-left-right-fill" to "f2fe", "contract-left-right-line" to "f2ff", "contract-right-fill" to "f300", "contract-right-line" to "f301", "contract-up-down-fill" to "f302", "contract-up-down-line" to "f303", "copilot-fill" to "f304", "copilot-line" to "f305", "corner-down-left-fill" to "f306", "corner-down-left-line" to "f307", "corner-down-right-fill" to "f308", "corner-down-right-line" to "f309", "corner-left-down-fill" to "f30a", "corner-left-down-line" to "f30b", "corner-left-up-fill" to "f30c", "corner-left-up-line" to "f30d", "corner-right-down-fill" to "f30e", "corner-right-down-line" to "f30f", "corner-right-up-fill" to "f310", "corner-right-up-line" to "f311", "corner-up-left-double-fill" to "f312", "corner-up-left-double-line" to "f313", "corner-up-left-fill" to "f314", "corner-up-left-line" to "f315", "corner-up-right-double-fill" to "f316", "corner-up-right-double-line" to "f317", "corner-up-right-fill" to "f318", "corner-up-right-line" to "f319", "cross-fill" to "f31a", "cross-line" to "f31b", "edge-new-fill" to "f31c", "edge-new-line" to "f31d", "equal-fill" to "f31e", "equal-line" to "f31f", "expand-left-fill" to "f320", "expand-left-line" to "f321", "expand-left-right-fill" to "f322", "expand-left-right-line" to "f323", "expand-right-fill" to "f324", "expand-right-line" to "f325", "expand-up-down-fill" to "f326", "expand-up-down-line" to "f327", "flickr-fill" to "f328", "flickr-line" to "f329", "forward-10-fill" to "f32a", "forward-10-line" to "f32b", "forward-15-fill" to "f32c", "forward-15-line" to "f32d", "forward-30-fill" to "f32e", "forward-30-line" to "f32f", "forward-5-fill" to "f330", "forward-5-line" to "f331", "graduation-cap-fill" to "f332", "graduation-cap-line" to "f333", "home-office-fill" to "f334", "home-office-line" to "f335", "hourglass-2-fill" to "f336", "hourglass-2-line" to "f337", "hourglass-fill" to "f338", "hourglass-line" to "f339", "javascript-fill" to "f33a", "javascript-line" to "f33b", "loop-left-fill" to "f33c", "loop-left-line" to "f33d", "loop-right-fill" to "f33e", "loop-right-line" to "f33f", "memories-fill" to "f340", "memories-line" to "f341", "meta-fill" to "f342", "meta-line" to "f343", "microsoft-loop-fill" to "f344", "microsoft-loop-line" to "f345", "nft-fill" to "f346", "nft-line" to "f347", "notion-fill" to "f348", "notion-line" to "f349", "openai-fill" to "f34a", "openai-line" to "f34b", "overline" to "f34c", "p2p-fill" to "f34d", "p2p-line" to "f34e", "presentation-fill" to "f34f", "presentation-line" to "f350", "replay-10-fill" to "f351", "replay-10-line" to "f352", "replay-15-fill" to "f353", "replay-15-line" to "f354", "replay-30-fill" to "f355", "replay-30-line" to "f356", "replay-5-fill" to "f357", "replay-5-line" to "f358", "school-fill" to "f359", "school-line" to "f35a", "shining-2-fill" to "f35b", "shining-2-line" to "f35c", "shining-fill" to "f35d", "shining-line" to "f35e", "sketching" to "f35f", "skip-down-fill" to "f360")
}
fun __gen_hugeObject0_6(): kotlin.Array<kotlin.Pair<String, Any?>> {
    return arrayOf("shield-star-fill" to "f109", "shield-star-line" to "f10a", "shield-user-fill" to "f10b", "shield-user-line" to "f10c", "ship-2-fill" to "f10d", "ship-2-line" to "f10e", "ship-fill" to "f10f", "ship-line" to "f110", "shirt-fill" to "f111", "shirt-line" to "f112", "shopping-bag-2-fill" to "f113", "shopping-bag-2-line" to "f114", "shopping-bag-3-fill" to "f115", "shopping-bag-3-line" to "f116", "shopping-bag-fill" to "f117", "shopping-bag-line" to "f118", "shopping-basket-2-fill" to "f119", "shopping-basket-2-line" to "f11a", "shopping-basket-fill" to "f11b", "shopping-basket-line" to "f11c", "shopping-cart-2-fill" to "f11d", "shopping-cart-2-line" to "f11e", "shopping-cart-fill" to "f11f", "shopping-cart-line" to "f120", "showers-fill" to "f121", "showers-line" to "f122", "shuffle-fill" to "f123", "shuffle-line" to "f124", "shut-down-fill" to "f125", "shut-down-line" to "f126", "side-bar-fill" to "f127", "side-bar-line" to "f128", "signal-tower-fill" to "f129", "signal-tower-line" to "f12a", "signal-wifi-1-fill" to "f12b", "signal-wifi-1-line" to "f12c", "signal-wifi-2-fill" to "f12d", "signal-wifi-2-line" to "f12e", "signal-wifi-3-fill" to "f12f", "signal-wifi-3-line" to "f130", "signal-wifi-error-fill" to "f131", "signal-wifi-error-line" to "f132", "signal-wifi-fill" to "f133", "signal-wifi-line" to "f134", "signal-wifi-off-fill" to "f135", "signal-wifi-off-line" to "f136", "sim-card-2-fill" to "f137", "sim-card-2-line" to "f138", "sim-card-fill" to "f139", "sim-card-line" to "f13a", "single-quotes-l" to "f13b", "single-quotes-r" to "f13c", "sip-fill" to "f13d", "sip-line" to "f13e", "skip-back-fill" to "f13f", "skip-back-line" to "f140", "skip-back-mini-fill" to "f141", "skip-back-mini-line" to "f142", "skip-forward-fill" to "f143", "skip-forward-line" to "f144", "skip-forward-mini-fill" to "f145", "skip-forward-mini-line" to "f146", "skull-2-fill" to "f147", "skull-2-line" to "f148", "skull-fill" to "f149", "skull-line" to "f14a", "skype-fill" to "f14b", "skype-line" to "f14c", "slack-fill" to "f14d", "slack-line" to "f14e", "slice-fill" to "f14f", "slice-line" to "f150", "slideshow-2-fill" to "f151", "slideshow-2-line" to "f152", "slideshow-3-fill" to "f153", "slideshow-3-line" to "f154", "slideshow-4-fill" to "f155", "slideshow-4-line" to "f156", "slideshow-fill" to "f157", "slideshow-line" to "f158", "smartphone-fill" to "f159", "smartphone-line" to "f15a", "snapchat-fill" to "f15b", "snapchat-line" to "f15c", "snowy-fill" to "f15d", "snowy-line" to "f15e", "sort-asc" to "f15f", "sort-desc" to "f160", "sound-module-fill" to "f161", "sound-module-line" to "f162", "soundcloud-fill" to "f163", "soundcloud-line" to "f164", "space-ship-fill" to "f165", "space-ship-line" to "f166", "space" to "f167", "spam-2-fill" to "f168", "spam-2-line" to "f169", "spam-3-fill" to "f16a", "spam-3-line" to "f16b", "spam-fill" to "f16c", "spam-line" to "f16d", "speaker-2-fill" to "f16e", "speaker-2-line" to "f16f", "speaker-3-fill" to "f170", "speaker-3-line" to "f171", "speaker-fill" to "f172", "speaker-line" to "f173", "spectrum-fill" to "f174", "spectrum-line" to "f175", "speed-fill" to "f176", "speed-line" to "f177", "speed-mini-fill" to "f178", "speed-mini-line" to "f179", "split-cells-horizontal" to "f17a", "split-cells-vertical" to "f17b", "spotify-fill" to "f17c", "spotify-line" to "f17d", "spy-fill" to "f17e", "spy-line" to "f17f", "stack-fill" to "f180", "stack-line" to "f181", "stack-overflow-fill" to "f182", "stack-overflow-line" to "f183", "stackshare-fill" to "f184", "stackshare-line" to "f185", "star-fill" to "f186", "star-half-fill" to "f187", "star-half-line" to "f188", "star-half-s-fill" to "f189", "star-half-s-line" to "f18a", "star-line" to "f18b", "star-s-fill" to "f18c", "star-s-line" to "f18d", "star-smile-fill" to "f18e", "star-smile-line" to "f18f", "steam-fill" to "f190", "steam-line" to "f191", "steering-2-fill" to "f192", "steering-2-line" to "f193", "steering-fill" to "f194", "steering-line" to "f195", "stethoscope-fill" to "f196", "stethoscope-line" to "f197", "sticky-note-2-fill" to "f198", "sticky-note-2-line" to "f199", "sticky-note-fill" to "f19a", "sticky-note-line" to "f19b", "stock-fill" to "f19c", "stock-line" to "f19d", "stop-circle-fill" to "f19e", "stop-circle-line" to "f19f", "stop-fill" to "f1a0", "stop-line" to "f1a1", "stop-mini-fill" to "f1a2", "stop-mini-line" to "f1a3", "store-2-fill" to "f1a4", "store-2-line" to "f1a5", "store-3-fill" to "f1a6", "store-3-line" to "f1a7", "store-fill" to "f1a8", "store-line" to "f1a9", "strikethrough-2" to "f1aa", "strikethrough" to "f1ab", "subscript-2" to "f1ac", "subscript" to "f1ad", "subtract-fill" to "f1ae", "subtract-line" to "f1af", "subway-fill" to "f1b0", "subway-line" to "f1b1", "subway-wifi-fill" to "f1b2", "subway-wifi-line" to "f1b3", "suitcase-2-fill" to "f1b4", "suitcase-2-line" to "f1b5", "suitcase-3-fill" to "f1b6", "suitcase-3-line" to "f1b7", "suitcase-fill" to "f1b8", "suitcase-line" to "f1b9", "sun-cloudy-fill" to "f1ba", "sun-cloudy-line" to "f1bb", "sun-fill" to "f1bc", "sun-foggy-fill" to "f1bd", "sun-foggy-line" to "f1be", "sun-line" to "f1bf", "superscript-2" to "f1c0", "superscript" to "f1c1", "surgical-mask-fill" to "f1c2", "surgical-mask-line" to "f1c3", "surround-sound-fill" to "f1c4", "surround-sound-line" to "f1c5", "survey-fill" to "f1c6", "survey-line" to "f1c7", "swap-box-fill" to "f1c8", "swap-box-line" to "f1c9", "swap-fill" to "f1ca", "swap-line" to "f1cb", "switch-fill" to "f1cc", "switch-line" to "f1cd", "sword-fill" to "f1ce", "sword-line" to "f1cf", "syringe-fill" to "f1d0", "syringe-line" to "f1d1", "t-box-fill" to "f1d2", "t-box-line" to "f1d3", "t-shirt-2-fill" to "f1d4", "t-shirt-2-line" to "f1d5", "t-shirt-air-fill" to "f1d6", "t-shirt-air-line" to "f1d7", "t-shirt-fill" to "f1d8", "t-shirt-line" to "f1d9", "table-2" to "f1da", "table-alt-fill" to "f1db", "table-alt-line" to "f1dc", "table-fill" to "f1dd", "table-line" to "f1de", "tablet-fill" to "f1df", "tablet-line" to "f1e0", "takeaway-fill" to "f1e1", "takeaway-line" to "f1e2", "taobao-fill" to "f1e3", "taobao-line" to "f1e4", "tape-fill" to "f1e5", "tape-line" to "f1e6", "task-fill" to "f1e7", "task-line" to "f1e8", "taxi-fill" to "f1e9", "taxi-line" to "f1ea", "taxi-wifi-fill" to "f1eb", "taxi-wifi-line" to "f1ec", "team-fill" to "f1ed", "team-line" to "f1ee", "telegram-fill" to "f1ef", "telegram-line" to "f1f0", "temp-cold-fill" to "f1f1", "temp-cold-line" to "f1f2", "temp-hot-fill" to "f1f3", "temp-hot-line" to "f1f4", "terminal-box-fill" to "f1f5", "terminal-box-line" to "f1f6", "terminal-fill" to "f1f7", "terminal-line" to "f1f8", "terminal-window-fill" to "f1f9", "terminal-window-line" to "f1fa", "test-tube-fill" to "f1fb", "test-tube-line" to "f1fc", "text-direction-l" to "f1fd", "text-direction-r" to "f1fe", "text-spacing" to "f1ff", "text-wrap" to "f200", "text" to "f201", "thermometer-fill" to "f202", "thermometer-line" to "f203", "thumb-down-fill" to "f204", "thumb-down-line" to "f205", "thumb-up-fill" to "f206", "thumb-up-line" to "f207", "thunderstorms-fill" to "f208", "thunderstorms-line" to "f209", "ticket-2-fill" to "f20a", "ticket-2-line" to "f20b", "ticket-fill" to "f20c", "ticket-line" to "f20d", "time-fill" to "f20e", "time-line" to "f20f", "timer-2-fill" to "f210", "timer-2-line" to "f211", "timer-fill" to "f212", "timer-flash-fill" to "f213", "timer-flash-line" to "f214", "timer-line" to "f215", "todo-fill" to "f216", "todo-line" to "f217", "toggle-fill" to "f218", "toggle-line" to "f219", "tools-fill" to "f21a", "tools-line" to "f21b", "tornado-fill" to "f21c", "tornado-line" to "f21d", "trademark-fill" to "f21e", "trademark-line" to "f21f", "traffic-light-fill" to "f220", "traffic-light-line" to "f221", "train-fill" to "f222", "train-line" to "f223", "train-wifi-fill" to "f224", "train-wifi-line" to "f225", "translate-2" to "f226", "translate" to "f227", "travesti-fill" to "f228", "travesti-line" to "f229", "treasure-map-fill" to "f22a", "treasure-map-line" to "f22b", "trello-fill" to "f22c", "trello-line" to "f22d", "trophy-fill" to "f22e", "trophy-line" to "f22f", "truck-fill" to "f230", "truck-line" to "f231", "tumblr-fill" to "f232", "tumblr-line" to "f233", "tv-2-fill" to "f234")
}
fun __gen_hugeObject0_5(): kotlin.Array<kotlin.Pair<String, Any?>> {
    return arrayOf("pen-nib-fill" to "efdd", "pen-nib-line" to "efde", "pencil-fill" to "efdf", "pencil-line" to "efe0", "pencil-ruler-2-fill" to "efe1", "pencil-ruler-2-line" to "efe2", "pencil-ruler-fill" to "efe3", "pencil-ruler-line" to "efe4", "percent-fill" to "efe5", "percent-line" to "efe6", "phone-camera-fill" to "efe7", "phone-camera-line" to "efe8", "phone-fill" to "efe9", "phone-find-fill" to "efea", "phone-find-line" to "efeb", "phone-line" to "efec", "phone-lock-fill" to "efed", "phone-lock-line" to "efee", "picture-in-picture-2-fill" to "efef", "picture-in-picture-2-line" to "eff0", "picture-in-picture-exit-fill" to "eff1", "picture-in-picture-exit-line" to "eff2", "picture-in-picture-fill" to "eff3", "picture-in-picture-line" to "eff4", "pie-chart-2-fill" to "eff5", "pie-chart-2-line" to "eff6", "pie-chart-box-fill" to "eff7", "pie-chart-box-line" to "eff8", "pie-chart-fill" to "eff9", "pie-chart-line" to "effa", "pin-distance-fill" to "effb", "pin-distance-line" to "effc", "ping-pong-fill" to "effd", "ping-pong-line" to "effe", "pinterest-fill" to "efff", "pinterest-line" to "f000", "pinyin-input" to "f001", "pixelfed-fill" to "f002", "pixelfed-line" to "f003", "plane-fill" to "f004", "plane-line" to "f005", "plant-fill" to "f006", "plant-line" to "f007", "play-circle-fill" to "f008", "play-circle-line" to "f009", "play-fill" to "f00a", "play-line" to "f00b", "play-list-2-fill" to "f00c", "play-list-2-line" to "f00d", "play-list-add-fill" to "f00e", "play-list-add-line" to "f00f", "play-list-fill" to "f010", "play-list-line" to "f011", "play-mini-fill" to "f012", "play-mini-line" to "f013", "playstation-fill" to "f014", "playstation-line" to "f015", "plug-2-fill" to "f016", "plug-2-line" to "f017", "plug-fill" to "f018", "plug-line" to "f019", "polaroid-2-fill" to "f01a", "polaroid-2-line" to "f01b", "polaroid-fill" to "f01c", "polaroid-line" to "f01d", "police-car-fill" to "f01e", "police-car-line" to "f01f", "price-tag-2-fill" to "f020", "price-tag-2-line" to "f021", "price-tag-3-fill" to "f022", "price-tag-3-line" to "f023", "price-tag-fill" to "f024", "price-tag-line" to "f025", "printer-cloud-fill" to "f026", "printer-cloud-line" to "f027", "printer-fill" to "f028", "printer-line" to "f029", "product-hunt-fill" to "f02a", "product-hunt-line" to "f02b", "profile-fill" to "f02c", "profile-line" to "f02d", "projector-2-fill" to "f02e", "projector-2-line" to "f02f", "projector-fill" to "f030", "projector-line" to "f031", "psychotherapy-fill" to "f032", "psychotherapy-line" to "f033", "pulse-fill" to "f034", "pulse-line" to "f035", "pushpin-2-fill" to "f036", "pushpin-2-line" to "f037", "pushpin-fill" to "f038", "pushpin-line" to "f039", "qq-fill" to "f03a", "qq-line" to "f03b", "qr-code-fill" to "f03c", "qr-code-line" to "f03d", "qr-scan-2-fill" to "f03e", "qr-scan-2-line" to "f03f", "qr-scan-fill" to "f040", "qr-scan-line" to "f041", "question-answer-fill" to "f042", "question-answer-line" to "f043", "question-fill" to "f044", "question-line" to "f045", "question-mark" to "f046", "questionnaire-fill" to "f047", "questionnaire-line" to "f048", "quill-pen-fill" to "f049", "quill-pen-line" to "f04a", "radar-fill" to "f04b", "radar-line" to "f04c", "radio-2-fill" to "f04d", "radio-2-line" to "f04e", "radio-button-fill" to "f04f", "radio-button-line" to "f050", "radio-fill" to "f051", "radio-line" to "f052", "rainbow-fill" to "f053", "rainbow-line" to "f054", "rainy-fill" to "f055", "rainy-line" to "f056", "reactjs-fill" to "f057", "reactjs-line" to "f058", "record-circle-fill" to "f059", "record-circle-line" to "f05a", "record-mail-fill" to "f05b", "record-mail-line" to "f05c", "recycle-fill" to "f05d", "recycle-line" to "f05e", "red-packet-fill" to "f05f", "red-packet-line" to "f060", "reddit-fill" to "f061", "reddit-line" to "f062", "refresh-fill" to "f063", "refresh-line" to "f064", "refund-2-fill" to "f065", "refund-2-line" to "f066", "refund-fill" to "f067", "refund-line" to "f068", "registered-fill" to "f069", "registered-line" to "f06a", "remixicon-fill" to "f06b", "remixicon-line" to "f06c", "remote-control-2-fill" to "f06d", "remote-control-2-line" to "f06e", "remote-control-fill" to "f06f", "remote-control-line" to "f070", "repeat-2-fill" to "f071", "repeat-2-line" to "f072", "repeat-fill" to "f073", "repeat-line" to "f074", "repeat-one-fill" to "f075", "repeat-one-line" to "f076", "reply-all-fill" to "f077", "reply-all-line" to "f078", "reply-fill" to "f079", "reply-line" to "f07a", "reserved-fill" to "f07b", "reserved-line" to "f07c", "rest-time-fill" to "f07d", "rest-time-line" to "f07e", "restart-fill" to "f07f", "restart-line" to "f080", "restaurant-2-fill" to "f081", "restaurant-2-line" to "f082", "restaurant-fill" to "f083", "restaurant-line" to "f084", "rewind-fill" to "f085", "rewind-line" to "f086", "rewind-mini-fill" to "f087", "rewind-mini-line" to "f088", "rhythm-fill" to "f089", "rhythm-line" to "f08a", "riding-fill" to "f08b", "riding-line" to "f08c", "road-map-fill" to "f08d", "road-map-line" to "f08e", "roadster-fill" to "f08f", "roadster-line" to "f090", "robot-fill" to "f091", "robot-line" to "f092", "rocket-2-fill" to "f093", "rocket-2-line" to "f094", "rocket-fill" to "f095", "rocket-line" to "f096", "rotate-lock-fill" to "f097", "rotate-lock-line" to "f098", "rounded-corner" to "f099", "route-fill" to "f09a", "route-line" to "f09b", "router-fill" to "f09c", "router-line" to "f09d", "rss-fill" to "f09e", "rss-line" to "f09f", "ruler-2-fill" to "f0a0", "ruler-2-line" to "f0a1", "ruler-fill" to "f0a2", "ruler-line" to "f0a3", "run-fill" to "f0a4", "run-line" to "f0a5", "safari-fill" to "f0a6", "safari-line" to "f0a7", "safe-2-fill" to "f0a8", "safe-2-line" to "f0a9", "safe-fill" to "f0aa", "safe-line" to "f0ab", "sailboat-fill" to "f0ac", "sailboat-line" to "f0ad", "save-2-fill" to "f0ae", "save-2-line" to "f0af", "save-3-fill" to "f0b0", "save-3-line" to "f0b1", "save-fill" to "f0b2", "save-line" to "f0b3", "scales-2-fill" to "f0b4", "scales-2-line" to "f0b5", "scales-3-fill" to "f0b6", "scales-3-line" to "f0b7", "scales-fill" to "f0b8", "scales-line" to "f0b9", "scan-2-fill" to "f0ba", "scan-2-line" to "f0bb", "scan-fill" to "f0bc", "scan-line" to "f0bd", "scissors-2-fill" to "f0be", "scissors-2-line" to "f0bf", "scissors-cut-fill" to "f0c0", "scissors-cut-line" to "f0c1", "scissors-fill" to "f0c2", "scissors-line" to "f0c3", "screenshot-2-fill" to "f0c4", "screenshot-2-line" to "f0c5", "screenshot-fill" to "f0c6", "screenshot-line" to "f0c7", "sd-card-fill" to "f0c8", "sd-card-line" to "f0c9", "sd-card-mini-fill" to "f0ca", "sd-card-mini-line" to "f0cb", "search-2-fill" to "f0cc", "search-2-line" to "f0cd", "search-eye-fill" to "f0ce", "search-eye-line" to "f0cf", "search-fill" to "f0d0", "search-line" to "f0d1", "secure-payment-fill" to "f0d2", "secure-payment-line" to "f0d3", "seedling-fill" to "f0d4", "seedling-line" to "f0d5", "send-backward" to "f0d6", "send-plane-2-fill" to "f0d7", "send-plane-2-line" to "f0d8", "send-plane-fill" to "f0d9", "send-plane-line" to "f0da", "send-to-back" to "f0db", "sensor-fill" to "f0dc", "sensor-line" to "f0dd", "separator" to "f0de", "server-fill" to "f0df", "server-line" to "f0e0", "service-fill" to "f0e1", "service-line" to "f0e2", "settings-2-fill" to "f0e3", "settings-2-line" to "f0e4", "settings-3-fill" to "f0e5", "settings-3-line" to "f0e6", "settings-4-fill" to "f0e7", "settings-4-line" to "f0e8", "settings-5-fill" to "f0e9", "settings-5-line" to "f0ea", "settings-6-fill" to "f0eb", "settings-6-line" to "f0ec", "settings-fill" to "f0ed", "settings-line" to "f0ee", "shape-2-fill" to "f0ef", "shape-2-line" to "f0f0", "shape-fill" to "f0f1", "shape-line" to "f0f2", "share-box-fill" to "f0f3", "share-box-line" to "f0f4", "share-circle-fill" to "f0f5", "share-circle-line" to "f0f6", "share-fill" to "f0f7", "share-forward-2-fill" to "f0f8", "share-forward-2-line" to "f0f9", "share-forward-box-fill" to "f0fa", "share-forward-box-line" to "f0fb", "share-forward-fill" to "f0fc", "share-forward-line" to "f0fd", "share-line" to "f0fe", "shield-check-fill" to "f0ff", "shield-check-line" to "f100", "shield-cross-fill" to "f101", "shield-cross-line" to "f102", "shield-fill" to "f103", "shield-flash-fill" to "f104", "shield-flash-line" to "f105", "shield-keyhole-fill" to "f106", "shield-keyhole-line" to "f107", "shield-line" to "f108")
}
fun __gen_hugeObject0_4(): kotlin.Array<kotlin.Pair<String, Any?>> {
    return arrayOf("link-unlink" to "eeb1", "link" to "eeb2", "linkedin-box-fill" to "eeb3", "linkedin-box-line" to "eeb4", "linkedin-fill" to "eeb5", "linkedin-line" to "eeb6", "links-fill" to "eeb7", "links-line" to "eeb8", "list-check-2" to "eeb9", "list-check" to "eeba", "list-ordered" to "eebb", "list-settings-fill" to "eebc", "list-settings-line" to "eebd", "list-unordered" to "eebe", "live-fill" to "eebf", "live-line" to "eec0", "loader-2-fill" to "eec1", "loader-2-line" to "eec2", "loader-3-fill" to "eec3", "loader-3-line" to "eec4", "loader-4-fill" to "eec5", "loader-4-line" to "eec6", "loader-5-fill" to "eec7", "loader-5-line" to "eec8", "loader-fill" to "eec9", "loader-line" to "eeca", "lock-2-fill" to "eecb", "lock-2-line" to "eecc", "lock-fill" to "eecd", "lock-line" to "eece", "lock-password-fill" to "eecf", "lock-password-line" to "eed0", "lock-unlock-fill" to "eed1", "lock-unlock-line" to "eed2", "login-box-fill" to "eed3", "login-box-line" to "eed4", "login-circle-fill" to "eed5", "login-circle-line" to "eed6", "logout-box-fill" to "eed7", "logout-box-line" to "eed8", "logout-box-r-fill" to "eed9", "logout-box-r-line" to "eeda", "logout-circle-fill" to "eedb", "logout-circle-line" to "eedc", "logout-circle-r-fill" to "eedd", "logout-circle-r-line" to "eede", "luggage-cart-fill" to "eedf", "luggage-cart-line" to "eee0", "luggage-deposit-fill" to "eee1", "luggage-deposit-line" to "eee2", "lungs-fill" to "eee3", "lungs-line" to "eee4", "mac-fill" to "eee5", "mac-line" to "eee6", "macbook-fill" to "eee7", "macbook-line" to "eee8", "magic-fill" to "eee9", "magic-line" to "eeea", "mail-add-fill" to "eeeb", "mail-add-line" to "eeec", "mail-check-fill" to "eeed", "mail-check-line" to "eeee", "mail-close-fill" to "eeef", "mail-close-line" to "eef0", "mail-download-fill" to "eef1", "mail-download-line" to "eef2", "mail-fill" to "eef3", "mail-forbid-fill" to "eef4", "mail-forbid-line" to "eef5", "mail-line" to "eef6", "mail-lock-fill" to "eef7", "mail-lock-line" to "eef8", "mail-open-fill" to "eef9", "mail-open-line" to "eefa", "mail-send-fill" to "eefb", "mail-send-line" to "eefc", "mail-settings-fill" to "eefd", "mail-settings-line" to "eefe", "mail-star-fill" to "eeff", "mail-star-line" to "ef00", "mail-unread-fill" to "ef01", "mail-unread-line" to "ef02", "mail-volume-fill" to "ef03", "mail-volume-line" to "ef04", "map-2-fill" to "ef05", "map-2-line" to "ef06", "map-fill" to "ef07", "map-line" to "ef08", "map-pin-2-fill" to "ef09", "map-pin-2-line" to "ef0a", "map-pin-3-fill" to "ef0b", "map-pin-3-line" to "ef0c", "map-pin-4-fill" to "ef0d", "map-pin-4-line" to "ef0e", "map-pin-5-fill" to "ef0f", "map-pin-5-line" to "ef10", "map-pin-add-fill" to "ef11", "map-pin-add-line" to "ef12", "map-pin-fill" to "ef13", "map-pin-line" to "ef14", "map-pin-range-fill" to "ef15", "map-pin-range-line" to "ef16", "map-pin-time-fill" to "ef17", "map-pin-time-line" to "ef18", "map-pin-user-fill" to "ef19", "map-pin-user-line" to "ef1a", "mark-pen-fill" to "ef1b", "mark-pen-line" to "ef1c", "markdown-fill" to "ef1d", "markdown-line" to "ef1e", "markup-fill" to "ef1f", "markup-line" to "ef20", "mastercard-fill" to "ef21", "mastercard-line" to "ef22", "mastodon-fill" to "ef23", "mastodon-line" to "ef24", "medal-2-fill" to "ef25", "medal-2-line" to "ef26", "medal-fill" to "ef27", "medal-line" to "ef28", "medicine-bottle-fill" to "ef29", "medicine-bottle-line" to "ef2a", "medium-fill" to "ef2b", "medium-line" to "ef2c", "men-fill" to "ef2d", "men-line" to "ef2e", "mental-health-fill" to "ef2f", "mental-health-line" to "ef30", "menu-2-fill" to "ef31", "menu-2-line" to "ef32", "menu-3-fill" to "ef33", "menu-3-line" to "ef34", "menu-4-fill" to "ef35", "menu-4-line" to "ef36", "menu-5-fill" to "ef37", "menu-5-line" to "ef38", "menu-add-fill" to "ef39", "menu-add-line" to "ef3a", "menu-fill" to "ef3b", "menu-fold-fill" to "ef3c", "menu-fold-line" to "ef3d", "menu-line" to "ef3e", "menu-unfold-fill" to "ef3f", "menu-unfold-line" to "ef40", "merge-cells-horizontal" to "ef41", "merge-cells-vertical" to "ef42", "message-2-fill" to "ef43", "message-2-line" to "ef44", "message-3-fill" to "ef45", "message-3-line" to "ef46", "message-fill" to "ef47", "message-line" to "ef48", "messenger-fill" to "ef49", "messenger-line" to "ef4a", "meteor-fill" to "ef4b", "meteor-line" to "ef4c", "mic-2-fill" to "ef4d", "mic-2-line" to "ef4e", "mic-fill" to "ef4f", "mic-line" to "ef50", "mic-off-fill" to "ef51", "mic-off-line" to "ef52", "mickey-fill" to "ef53", "mickey-line" to "ef54", "microscope-fill" to "ef55", "microscope-line" to "ef56", "microsoft-fill" to "ef57", "microsoft-line" to "ef58", "mind-map" to "ef59", "mini-program-fill" to "ef5a", "mini-program-line" to "ef5b", "mist-fill" to "ef5c", "mist-line" to "ef5d", "money-cny-box-fill" to "ef5e", "money-cny-box-line" to "ef5f", "money-cny-circle-fill" to "ef60", "money-cny-circle-line" to "ef61", "money-dollar-box-fill" to "ef62", "money-dollar-box-line" to "ef63", "money-dollar-circle-fill" to "ef64", "money-dollar-circle-line" to "ef65", "money-euro-box-fill" to "ef66", "money-euro-box-line" to "ef67", "money-euro-circle-fill" to "ef68", "money-euro-circle-line" to "ef69", "money-pound-box-fill" to "ef6a", "money-pound-box-line" to "ef6b", "money-pound-circle-fill" to "ef6c", "money-pound-circle-line" to "ef6d", "moon-clear-fill" to "ef6e", "moon-clear-line" to "ef6f", "moon-cloudy-fill" to "ef70", "moon-cloudy-line" to "ef71", "moon-fill" to "ef72", "moon-foggy-fill" to "ef73", "moon-foggy-line" to "ef74", "moon-line" to "ef75", "more-2-fill" to "ef76", "more-2-line" to "ef77", "more-fill" to "ef78", "more-line" to "ef79", "motorbike-fill" to "ef7a", "motorbike-line" to "ef7b", "mouse-fill" to "ef7c", "mouse-line" to "ef7d", "movie-2-fill" to "ef7e", "movie-2-line" to "ef7f", "movie-fill" to "ef80", "movie-line" to "ef81", "music-2-fill" to "ef82", "music-2-line" to "ef83", "music-fill" to "ef84", "music-line" to "ef85", "mv-fill" to "ef86", "mv-line" to "ef87", "navigation-fill" to "ef88", "navigation-line" to "ef89", "netease-cloud-music-fill" to "ef8a", "netease-cloud-music-line" to "ef8b", "netflix-fill" to "ef8c", "netflix-line" to "ef8d", "newspaper-fill" to "ef8e", "newspaper-line" to "ef8f", "node-tree" to "ef90", "notification-2-fill" to "ef91", "notification-2-line" to "ef92", "notification-3-fill" to "ef93", "notification-3-line" to "ef94", "notification-4-fill" to "ef95", "notification-4-line" to "ef96", "notification-badge-fill" to "ef97", "notification-badge-line" to "ef98", "notification-fill" to "ef99", "notification-line" to "ef9a", "notification-off-fill" to "ef9b", "notification-off-line" to "ef9c", "npmjs-fill" to "ef9d", "npmjs-line" to "ef9e", "number-0" to "ef9f", "number-1" to "efa0", "number-2" to "efa1", "number-3" to "efa2", "number-4" to "efa3", "number-5" to "efa4", "number-6" to "efa5", "number-7" to "efa6", "number-8" to "efa7", "number-9" to "efa8", "numbers-fill" to "efa9", "numbers-line" to "efaa", "nurse-fill" to "efab", "nurse-line" to "efac", "oil-fill" to "efad", "oil-line" to "efae", "omega" to "efaf", "open-arm-fill" to "efb0", "open-arm-line" to "efb1", "open-source-fill" to "efb2", "open-source-line" to "efb3", "opera-fill" to "efb4", "opera-line" to "efb5", "order-play-fill" to "efb6", "order-play-line" to "efb7", "organization-chart" to "efb8", "outlet-2-fill" to "efb9", "outlet-2-line" to "efba", "outlet-fill" to "efbb", "outlet-line" to "efbc", "page-separator" to "efbd", "pages-fill" to "efbe", "pages-line" to "efbf", "paint-brush-fill" to "efc0", "paint-brush-line" to "efc1", "paint-fill" to "efc2", "paint-line" to "efc3", "palette-fill" to "efc4", "palette-line" to "efc5", "pantone-fill" to "efc6", "pantone-line" to "efc7", "paragraph" to "efc8", "parent-fill" to "efc9", "parent-line" to "efca", "parentheses-fill" to "efcb", "parentheses-line" to "efcc", "parking-box-fill" to "efcd", "parking-box-line" to "efce", "parking-fill" to "efcf", "parking-line" to "efd0", "passport-fill" to "efd1", "passport-line" to "efd2", "patreon-fill" to "efd3", "patreon-line" to "efd4", "pause-circle-fill" to "efd5", "pause-circle-line" to "efd6", "pause-fill" to "efd7", "pause-line" to "efd8", "pause-mini-fill" to "efd9", "pause-mini-line" to "efda", "paypal-fill" to "efdb", "paypal-line" to "efdc")
}
fun __gen_hugeObject0_3(): kotlin.Array<kotlin.Pair<String, Any?>> {
    return arrayOf("folder-warning-fill" to "ed85", "folder-warning-line" to "ed86", "folder-zip-fill" to "ed87", "folder-zip-line" to "ed88", "folders-fill" to "ed89", "folders-line" to "ed8a", "font-color" to "ed8b", "font-size-2" to "ed8c", "font-size" to "ed8d", "football-fill" to "ed8e", "football-line" to "ed8f", "footprint-fill" to "ed90", "footprint-line" to "ed91", "forbid-2-fill" to "ed92", "forbid-2-line" to "ed93", "forbid-fill" to "ed94", "forbid-line" to "ed95", "format-clear" to "ed96", "fridge-fill" to "ed97", "fridge-line" to "ed98", "fullscreen-exit-fill" to "ed99", "fullscreen-exit-line" to "ed9a", "fullscreen-fill" to "ed9b", "fullscreen-line" to "ed9c", "function-fill" to "ed9d", "function-line" to "ed9e", "functions" to "ed9f", "funds-box-fill" to "eda0", "funds-box-line" to "eda1", "funds-fill" to "eda2", "funds-line" to "eda3", "gallery-fill" to "eda4", "gallery-line" to "eda5", "gallery-upload-fill" to "eda6", "gallery-upload-line" to "eda7", "game-fill" to "eda8", "game-line" to "eda9", "gamepad-fill" to "edaa", "gamepad-line" to "edab", "gas-station-fill" to "edac", "gas-station-line" to "edad", "gatsby-fill" to "edae", "gatsby-line" to "edaf", "genderless-fill" to "edb0", "genderless-line" to "edb1", "ghost-2-fill" to "edb2", "ghost-2-line" to "edb3", "ghost-fill" to "edb4", "ghost-line" to "edb5", "ghost-smile-fill" to "edb6", "ghost-smile-line" to "edb7", "gift-2-fill" to "edb8", "gift-2-line" to "edb9", "gift-fill" to "edba", "gift-line" to "edbb", "git-branch-fill" to "edbc", "git-branch-line" to "edbd", "git-commit-fill" to "edbe", "git-commit-line" to "edbf", "git-merge-fill" to "edc0", "git-merge-line" to "edc1", "git-pull-request-fill" to "edc2", "git-pull-request-line" to "edc3", "git-repository-commits-fill" to "edc4", "git-repository-commits-line" to "edc5", "git-repository-fill" to "edc6", "git-repository-line" to "edc7", "git-repository-private-fill" to "edc8", "git-repository-private-line" to "edc9", "github-fill" to "edca", "github-line" to "edcb", "gitlab-fill" to "edcc", "gitlab-line" to "edcd", "global-fill" to "edce", "global-line" to "edcf", "globe-fill" to "edd0", "globe-line" to "edd1", "goblet-fill" to "edd2", "goblet-line" to "edd3", "google-fill" to "edd4", "google-line" to "edd5", "google-play-fill" to "edd6", "google-play-line" to "edd7", "government-fill" to "edd8", "government-line" to "edd9", "gps-fill" to "edda", "gps-line" to "eddb", "gradienter-fill" to "eddc", "gradienter-line" to "eddd", "grid-fill" to "edde", "grid-line" to "eddf", "group-2-fill" to "ede0", "group-2-line" to "ede1", "group-fill" to "ede2", "group-line" to "ede3", "guide-fill" to "ede4", "guide-line" to "ede5", "h-1" to "ede6", "h-2" to "ede7", "h-3" to "ede8", "h-4" to "ede9", "h-5" to "edea", "h-6" to "edeb", "hail-fill" to "edec", "hail-line" to "eded", "hammer-fill" to "edee", "hammer-line" to "edef", "hand-coin-fill" to "edf0", "hand-coin-line" to "edf1", "hand-heart-fill" to "edf2", "hand-heart-line" to "edf3", "hand-sanitizer-fill" to "edf4", "hand-sanitizer-line" to "edf5", "handbag-fill" to "edf6", "handbag-line" to "edf7", "hard-drive-2-fill" to "edf8", "hard-drive-2-line" to "edf9", "hard-drive-fill" to "edfa", "hard-drive-line" to "edfb", "hashtag" to "edfc", "haze-2-fill" to "edfd", "haze-2-line" to "edfe", "haze-fill" to "edff", "haze-line" to "ee00", "hd-fill" to "ee01", "hd-line" to "ee02", "heading" to "ee03", "headphone-fill" to "ee04", "headphone-line" to "ee05", "health-book-fill" to "ee06", "health-book-line" to "ee07", "heart-2-fill" to "ee08", "heart-2-line" to "ee09", "heart-3-fill" to "ee0a", "heart-3-line" to "ee0b", "heart-add-fill" to "ee0c", "heart-add-line" to "ee0d", "heart-fill" to "ee0e", "heart-line" to "ee0f", "heart-pulse-fill" to "ee10", "heart-pulse-line" to "ee11", "hearts-fill" to "ee12", "hearts-line" to "ee13", "heavy-showers-fill" to "ee14", "heavy-showers-line" to "ee15", "history-fill" to "ee16", "history-line" to "ee17", "home-2-fill" to "ee18", "home-2-line" to "ee19", "home-3-fill" to "ee1a", "home-3-line" to "ee1b", "home-4-fill" to "ee1c", "home-4-line" to "ee1d", "home-5-fill" to "ee1e", "home-5-line" to "ee1f", "home-6-fill" to "ee20", "home-6-line" to "ee21", "home-7-fill" to "ee22", "home-7-line" to "ee23", "home-8-fill" to "ee24", "home-8-line" to "ee25", "home-fill" to "ee26", "home-gear-fill" to "ee27", "home-gear-line" to "ee28", "home-heart-fill" to "ee29", "home-heart-line" to "ee2a", "home-line" to "ee2b", "home-smile-2-fill" to "ee2c", "home-smile-2-line" to "ee2d", "home-smile-fill" to "ee2e", "home-smile-line" to "ee2f", "home-wifi-fill" to "ee30", "home-wifi-line" to "ee31", "honor-of-kings-fill" to "ee32", "honor-of-kings-line" to "ee33", "honour-fill" to "ee34", "honour-line" to "ee35", "hospital-fill" to "ee36", "hospital-line" to "ee37", "hotel-bed-fill" to "ee38", "hotel-bed-line" to "ee39", "hotel-fill" to "ee3a", "hotel-line" to "ee3b", "hotspot-fill" to "ee3c", "hotspot-line" to "ee3d", "hq-fill" to "ee3e", "hq-line" to "ee3f", "html5-fill" to "ee40", "html5-line" to "ee41", "ie-fill" to "ee42", "ie-line" to "ee43", "image-2-fill" to "ee44", "image-2-line" to "ee45", "image-add-fill" to "ee46", "image-add-line" to "ee47", "image-edit-fill" to "ee48", "image-edit-line" to "ee49", "image-fill" to "ee4a", "image-line" to "ee4b", "inbox-archive-fill" to "ee4c", "inbox-archive-line" to "ee4d", "inbox-fill" to "ee4e", "inbox-line" to "ee4f", "inbox-unarchive-fill" to "ee50", "inbox-unarchive-line" to "ee51", "increase-decrease-fill" to "ee52", "increase-decrease-line" to "ee53", "indent-decrease" to "ee54", "indent-increase" to "ee55", "indeterminate-circle-fill" to "ee56", "indeterminate-circle-line" to "ee57", "information-fill" to "ee58", "information-line" to "ee59", "infrared-thermometer-fill" to "ee5a", "infrared-thermometer-line" to "ee5b", "ink-bottle-fill" to "ee5c", "ink-bottle-line" to "ee5d", "input-cursor-move" to "ee5e", "input-method-fill" to "ee5f", "input-method-line" to "ee60", "insert-column-left" to "ee61", "insert-column-right" to "ee62", "insert-row-bottom" to "ee63", "insert-row-top" to "ee64", "instagram-fill" to "ee65", "instagram-line" to "ee66", "install-fill" to "ee67", "install-line" to "ee68", "invision-fill" to "ee69", "invision-line" to "ee6a", "italic" to "ee6b", "kakao-talk-fill" to "ee6c", "kakao-talk-line" to "ee6d", "key-2-fill" to "ee6e", "key-2-line" to "ee6f", "key-fill" to "ee70", "key-line" to "ee71", "keyboard-box-fill" to "ee72", "keyboard-box-line" to "ee73", "keyboard-fill" to "ee74", "keyboard-line" to "ee75", "keynote-fill" to "ee76", "keynote-line" to "ee77", "knife-blood-fill" to "ee78", "knife-blood-line" to "ee79", "knife-fill" to "ee7a", "knife-line" to "ee7b", "landscape-fill" to "ee7c", "landscape-line" to "ee7d", "layout-2-fill" to "ee7e", "layout-2-line" to "ee7f", "layout-3-fill" to "ee80", "layout-3-line" to "ee81", "layout-4-fill" to "ee82", "layout-4-line" to "ee83", "layout-5-fill" to "ee84", "layout-5-line" to "ee85", "layout-6-fill" to "ee86", "layout-6-line" to "ee87", "layout-bottom-2-fill" to "ee88", "layout-bottom-2-line" to "ee89", "layout-bottom-fill" to "ee8a", "layout-bottom-line" to "ee8b", "layout-column-fill" to "ee8c", "layout-column-line" to "ee8d", "layout-fill" to "ee8e", "layout-grid-fill" to "ee8f", "layout-grid-line" to "ee90", "layout-left-2-fill" to "ee91", "layout-left-2-line" to "ee92", "layout-left-fill" to "ee93", "layout-left-line" to "ee94", "layout-line" to "ee95", "layout-masonry-fill" to "ee96", "layout-masonry-line" to "ee97", "layout-right-2-fill" to "ee98", "layout-right-2-line" to "ee99", "layout-right-fill" to "ee9a", "layout-right-line" to "ee9b", "layout-row-fill" to "ee9c", "layout-row-line" to "ee9d", "layout-top-2-fill" to "ee9e", "layout-top-2-line" to "ee9f", "layout-top-fill" to "eea0", "layout-top-line" to "eea1", "leaf-fill" to "eea2", "leaf-line" to "eea3", "lifebuoy-fill" to "eea4", "lifebuoy-line" to "eea5", "lightbulb-fill" to "eea6", "lightbulb-flash-fill" to "eea7", "lightbulb-flash-line" to "eea8", "lightbulb-line" to "eea9", "line-chart-fill" to "eeaa", "line-chart-line" to "eeab", "line-fill" to "eeac", "line-height" to "eead", "line-line" to "eeae", "link-m" to "eeaf", "link-unlink-m" to "eeb0")
}
fun __gen_hugeObject0_2(): kotlin.Array<kotlin.Pair<String, Any?>> {
    return arrayOf("download-fill" to "ec59", "download-line" to "ec5a", "draft-fill" to "ec5b", "draft-line" to "ec5c", "drag-drop-fill" to "ec5d", "drag-drop-line" to "ec5e", "drag-move-2-fill" to "ec5f", "drag-move-2-line" to "ec60", "drag-move-fill" to "ec61", "drag-move-line" to "ec62", "dribbble-fill" to "ec63", "dribbble-line" to "ec64", "drive-fill" to "ec65", "drive-line" to "ec66", "drizzle-fill" to "ec67", "drizzle-line" to "ec68", "drop-fill" to "ec69", "drop-line" to "ec6a", "dropbox-fill" to "ec6b", "dropbox-line" to "ec6c", "dual-sim-1-fill" to "ec6d", "dual-sim-1-line" to "ec6e", "dual-sim-2-fill" to "ec6f", "dual-sim-2-line" to "ec70", "dv-fill" to "ec71", "dv-line" to "ec72", "dvd-fill" to "ec73", "dvd-line" to "ec74", "e-bike-2-fill" to "ec75", "e-bike-2-line" to "ec76", "e-bike-fill" to "ec77", "e-bike-line" to "ec78", "earth-fill" to "ec79", "earth-line" to "ec7a", "earthquake-fill" to "ec7b", "earthquake-line" to "ec7c", "edge-fill" to "ec7d", "edge-line" to "ec7e", "edit-2-fill" to "ec7f", "edit-2-line" to "ec80", "edit-box-fill" to "ec81", "edit-box-line" to "ec82", "edit-circle-fill" to "ec83", "edit-circle-line" to "ec84", "edit-fill" to "ec85", "edit-line" to "ec86", "eject-fill" to "ec87", "eject-line" to "ec88", "emotion-2-fill" to "ec89", "emotion-2-line" to "ec8a", "emotion-fill" to "ec8b", "emotion-happy-fill" to "ec8c", "emotion-happy-line" to "ec8d", "emotion-laugh-fill" to "ec8e", "emotion-laugh-line" to "ec8f", "emotion-line" to "ec90", "emotion-normal-fill" to "ec91", "emotion-normal-line" to "ec92", "emotion-sad-fill" to "ec93", "emotion-sad-line" to "ec94", "emotion-unhappy-fill" to "ec95", "emotion-unhappy-line" to "ec96", "empathize-fill" to "ec97", "empathize-line" to "ec98", "emphasis-cn" to "ec99", "emphasis" to "ec9a", "english-input" to "ec9b", "equalizer-fill" to "ec9c", "equalizer-line" to "ec9d", "eraser-fill" to "ec9e", "eraser-line" to "ec9f", "error-warning-fill" to "eca0", "error-warning-line" to "eca1", "evernote-fill" to "eca2", "evernote-line" to "eca3", "exchange-box-fill" to "eca4", "exchange-box-line" to "eca5", "exchange-cny-fill" to "eca6", "exchange-cny-line" to "eca7", "exchange-dollar-fill" to "eca8", "exchange-dollar-line" to "eca9", "exchange-fill" to "ecaa", "exchange-funds-fill" to "ecab", "exchange-funds-line" to "ecac", "exchange-line" to "ecad", "external-link-fill" to "ecae", "external-link-line" to "ecaf", "eye-2-fill" to "ecb0", "eye-2-line" to "ecb1", "eye-close-fill" to "ecb2", "eye-close-line" to "ecb3", "eye-fill" to "ecb4", "eye-line" to "ecb5", "eye-off-fill" to "ecb6", "eye-off-line" to "ecb7", "facebook-box-fill" to "ecb8", "facebook-box-line" to "ecb9", "facebook-circle-fill" to "ecba", "facebook-circle-line" to "ecbb", "facebook-fill" to "ecbc", "facebook-line" to "ecbd", "fahrenheit-fill" to "ecbe", "fahrenheit-line" to "ecbf", "feedback-fill" to "ecc0", "feedback-line" to "ecc1", "file-2-fill" to "ecc2", "file-2-line" to "ecc3", "file-3-fill" to "ecc4", "file-3-line" to "ecc5", "file-4-fill" to "ecc6", "file-4-line" to "ecc7", "file-add-fill" to "ecc8", "file-add-line" to "ecc9", "file-chart-2-fill" to "ecca", "file-chart-2-line" to "eccb", "file-chart-fill" to "eccc", "file-chart-line" to "eccd", "file-cloud-fill" to "ecce", "file-cloud-line" to "eccf", "file-code-fill" to "ecd0", "file-code-line" to "ecd1", "file-copy-2-fill" to "ecd2", "file-copy-2-line" to "ecd3", "file-copy-fill" to "ecd4", "file-copy-line" to "ecd5", "file-damage-fill" to "ecd6", "file-damage-line" to "ecd7", "file-download-fill" to "ecd8", "file-download-line" to "ecd9", "file-edit-fill" to "ecda", "file-edit-line" to "ecdb", "file-excel-2-fill" to "ecdc", "file-excel-2-line" to "ecdd", "file-excel-fill" to "ecde", "file-excel-line" to "ecdf", "file-fill" to "ece0", "file-forbid-fill" to "ece1", "file-forbid-line" to "ece2", "file-gif-fill" to "ece3", "file-gif-line" to "ece4", "file-history-fill" to "ece5", "file-history-line" to "ece6", "file-hwp-fill" to "ece7", "file-hwp-line" to "ece8", "file-info-fill" to "ece9", "file-info-line" to "ecea", "file-line" to "eceb", "file-list-2-fill" to "ecec", "file-list-2-line" to "eced", "file-list-3-fill" to "ecee", "file-list-3-line" to "ecef", "file-list-fill" to "ecf0", "file-list-line" to "ecf1", "file-lock-fill" to "ecf2", "file-lock-line" to "ecf3", "file-marked-fill" to "ecf4", "file-marked-line" to "ecf5", "file-music-fill" to "ecf6", "file-music-line" to "ecf7", "file-paper-2-fill" to "ecf8", "file-paper-2-line" to "ecf9", "file-paper-fill" to "ecfa", "file-paper-line" to "ecfb", "file-pdf-fill" to "ecfc", "file-pdf-line" to "ecfd", "file-ppt-2-fill" to "ecfe", "file-ppt-2-line" to "ecff", "file-ppt-fill" to "ed00", "file-ppt-line" to "ed01", "file-reduce-fill" to "ed02", "file-reduce-line" to "ed03", "file-search-fill" to "ed04", "file-search-line" to "ed05", "file-settings-fill" to "ed06", "file-settings-line" to "ed07", "file-shield-2-fill" to "ed08", "file-shield-2-line" to "ed09", "file-shield-fill" to "ed0a", "file-shield-line" to "ed0b", "file-shred-fill" to "ed0c", "file-shred-line" to "ed0d", "file-text-fill" to "ed0e", "file-text-line" to "ed0f", "file-transfer-fill" to "ed10", "file-transfer-line" to "ed11", "file-unknow-fill" to "ed12", "file-unknow-line" to "ed13", "file-upload-fill" to "ed14", "file-upload-line" to "ed15", "file-user-fill" to "ed16", "file-user-line" to "ed17", "file-warning-fill" to "ed18", "file-warning-line" to "ed19", "file-word-2-fill" to "ed1a", "file-word-2-line" to "ed1b", "file-word-fill" to "ed1c", "file-word-line" to "ed1d", "file-zip-fill" to "ed1e", "file-zip-line" to "ed1f", "film-fill" to "ed20", "film-line" to "ed21", "filter-2-fill" to "ed22", "filter-2-line" to "ed23", "filter-3-fill" to "ed24", "filter-3-line" to "ed25", "filter-fill" to "ed26", "filter-line" to "ed27", "filter-off-fill" to "ed28", "filter-off-line" to "ed29", "find-replace-fill" to "ed2a", "find-replace-line" to "ed2b", "finder-fill" to "ed2c", "finder-line" to "ed2d", "fingerprint-2-fill" to "ed2e", "fingerprint-2-line" to "ed2f", "fingerprint-fill" to "ed30", "fingerprint-line" to "ed31", "fire-fill" to "ed32", "fire-line" to "ed33", "firefox-fill" to "ed34", "firefox-line" to "ed35", "first-aid-kit-fill" to "ed36", "first-aid-kit-line" to "ed37", "flag-2-fill" to "ed38", "flag-2-line" to "ed39", "flag-fill" to "ed3a", "flag-line" to "ed3b", "flashlight-fill" to "ed3c", "flashlight-line" to "ed3d", "flask-fill" to "ed3e", "flask-line" to "ed3f", "flight-land-fill" to "ed40", "flight-land-line" to "ed41", "flight-takeoff-fill" to "ed42", "flight-takeoff-line" to "ed43", "flood-fill" to "ed44", "flood-line" to "ed45", "flow-chart" to "ed46", "flutter-fill" to "ed47", "flutter-line" to "ed48", "focus-2-fill" to "ed49", "focus-2-line" to "ed4a", "focus-3-fill" to "ed4b", "focus-3-line" to "ed4c", "focus-fill" to "ed4d", "focus-line" to "ed4e", "foggy-fill" to "ed4f", "foggy-line" to "ed50", "folder-2-fill" to "ed51", "folder-2-line" to "ed52", "folder-3-fill" to "ed53", "folder-3-line" to "ed54", "folder-4-fill" to "ed55", "folder-4-line" to "ed56", "folder-5-fill" to "ed57", "folder-5-line" to "ed58", "folder-add-fill" to "ed59", "folder-add-line" to "ed5a", "folder-chart-2-fill" to "ed5b", "folder-chart-2-line" to "ed5c", "folder-chart-fill" to "ed5d", "folder-chart-line" to "ed5e", "folder-download-fill" to "ed5f", "folder-download-line" to "ed60", "folder-fill" to "ed61", "folder-forbid-fill" to "ed62", "folder-forbid-line" to "ed63", "folder-history-fill" to "ed64", "folder-history-line" to "ed65", "folder-info-fill" to "ed66", "folder-info-line" to "ed67", "folder-keyhole-fill" to "ed68", "folder-keyhole-line" to "ed69", "folder-line" to "ed6a", "folder-lock-fill" to "ed6b", "folder-lock-line" to "ed6c", "folder-music-fill" to "ed6d", "folder-music-line" to "ed6e", "folder-open-fill" to "ed6f", "folder-open-line" to "ed70", "folder-received-fill" to "ed71", "folder-received-line" to "ed72", "folder-reduce-fill" to "ed73", "folder-reduce-line" to "ed74", "folder-settings-fill" to "ed75", "folder-settings-line" to "ed76", "folder-shared-fill" to "ed77", "folder-shared-line" to "ed78", "folder-shield-2-fill" to "ed79", "folder-shield-2-line" to "ed7a", "folder-shield-fill" to "ed7b", "folder-shield-line" to "ed7c", "folder-transfer-fill" to "ed7d", "folder-transfer-line" to "ed7e", "folder-unknow-fill" to "ed7f", "folder-unknow-line" to "ed80", "folder-upload-fill" to "ed81", "folder-upload-line" to "ed82", "folder-user-fill" to "ed83", "folder-user-line" to "ed84")
}
fun __gen_hugeObject0_1(): kotlin.Array<kotlin.Pair<String, Any?>> {
    return arrayOf("camera-3-line" to "eb2d", "camera-fill" to "eb2e", "camera-lens-fill" to "eb2f", "camera-lens-line" to "eb30", "camera-line" to "eb31", "camera-off-fill" to "eb32", "camera-off-line" to "eb33", "camera-switch-fill" to "eb34", "camera-switch-line" to "eb35", "capsule-fill" to "eb36", "capsule-line" to "eb37", "car-fill" to "eb38", "car-line" to "eb39", "car-washing-fill" to "eb3a", "car-washing-line" to "eb3b", "caravan-fill" to "eb3c", "caravan-line" to "eb3d", "cast-fill" to "eb3e", "cast-line" to "eb3f", "cellphone-fill" to "eb40", "cellphone-line" to "eb41", "celsius-fill" to "eb42", "celsius-line" to "eb43", "centos-fill" to "eb44", "centos-line" to "eb45", "character-recognition-fill" to "eb46", "character-recognition-line" to "eb47", "charging-pile-2-fill" to "eb48", "charging-pile-2-line" to "eb49", "charging-pile-fill" to "eb4a", "charging-pile-line" to "eb4b", "chat-1-fill" to "eb4c", "chat-1-line" to "eb4d", "chat-2-fill" to "eb4e", "chat-2-line" to "eb4f", "chat-3-fill" to "eb50", "chat-3-line" to "eb51", "chat-4-fill" to "eb52", "chat-4-line" to "eb53", "chat-check-fill" to "eb54", "chat-check-line" to "eb55", "chat-delete-fill" to "eb56", "chat-delete-line" to "eb57", "chat-download-fill" to "eb58", "chat-download-line" to "eb59", "chat-follow-up-fill" to "eb5a", "chat-follow-up-line" to "eb5b", "chat-forward-fill" to "eb5c", "chat-forward-line" to "eb5d", "chat-heart-fill" to "eb5e", "chat-heart-line" to "eb5f", "chat-history-fill" to "eb60", "chat-history-line" to "eb61", "chat-new-fill" to "eb62", "chat-new-line" to "eb63", "chat-off-fill" to "eb64", "chat-off-line" to "eb65", "chat-poll-fill" to "eb66", "chat-poll-line" to "eb67", "chat-private-fill" to "eb68", "chat-private-line" to "eb69", "chat-quote-fill" to "eb6a", "chat-quote-line" to "eb6b", "chat-settings-fill" to "eb6c", "chat-settings-line" to "eb6d", "chat-smile-2-fill" to "eb6e", "chat-smile-2-line" to "eb6f", "chat-smile-3-fill" to "eb70", "chat-smile-3-line" to "eb71", "chat-smile-fill" to "eb72", "chat-smile-line" to "eb73", "chat-upload-fill" to "eb74", "chat-upload-line" to "eb75", "chat-voice-fill" to "eb76", "chat-voice-line" to "eb77", "check-double-fill" to "eb78", "check-double-line" to "eb79", "check-fill" to "eb7a", "check-line" to "eb7b", "checkbox-blank-circle-fill" to "eb7c", "checkbox-blank-circle-line" to "eb7d", "checkbox-blank-fill" to "eb7e", "checkbox-blank-line" to "eb7f", "checkbox-circle-fill" to "eb80", "checkbox-circle-line" to "eb81", "checkbox-fill" to "eb82", "checkbox-indeterminate-fill" to "eb83", "checkbox-indeterminate-line" to "eb84", "checkbox-line" to "eb85", "checkbox-multiple-blank-fill" to "eb86", "checkbox-multiple-blank-line" to "eb87", "checkbox-multiple-fill" to "eb88", "checkbox-multiple-line" to "eb89", "china-railway-fill" to "eb8a", "china-railway-line" to "eb8b", "chrome-fill" to "eb8c", "chrome-line" to "eb8d", "clapperboard-fill" to "eb8e", "clapperboard-line" to "eb8f", "clipboard-fill" to "eb90", "clipboard-line" to "eb91", "clockwise-2-fill" to "eb92", "clockwise-2-line" to "eb93", "clockwise-fill" to "eb94", "clockwise-line" to "eb95", "close-circle-fill" to "eb96", "close-circle-line" to "eb97", "close-fill" to "eb98", "close-line" to "eb99", "closed-captioning-fill" to "eb9a", "closed-captioning-line" to "eb9b", "cloud-fill" to "eb9c", "cloud-line" to "eb9d", "cloud-off-fill" to "eb9e", "cloud-off-line" to "eb9f", "cloud-windy-fill" to "eba0", "cloud-windy-line" to "eba1", "cloudy-2-fill" to "eba2", "cloudy-2-line" to "eba3", "cloudy-fill" to "eba4", "cloudy-line" to "eba5", "code-box-fill" to "eba6", "code-box-line" to "eba7", "code-fill" to "eba8", "code-line" to "eba9", "code-s-fill" to "ebaa", "code-s-line" to "ebab", "code-s-slash-fill" to "ebac", "code-s-slash-line" to "ebad", "code-view" to "ebae", "codepen-fill" to "ebaf", "codepen-line" to "ebb0", "coin-fill" to "ebb1", "coin-line" to "ebb2", "coins-fill" to "ebb3", "coins-line" to "ebb4", "collage-fill" to "ebb5", "collage-line" to "ebb6", "command-fill" to "ebb7", "command-line" to "ebb8", "community-fill" to "ebb9", "community-line" to "ebba", "compass-2-fill" to "ebbb", "compass-2-line" to "ebbc", "compass-3-fill" to "ebbd", "compass-3-line" to "ebbe", "compass-4-fill" to "ebbf", "compass-4-line" to "ebc0", "compass-discover-fill" to "ebc1", "compass-discover-line" to "ebc2", "compass-fill" to "ebc3", "compass-line" to "ebc4", "compasses-2-fill" to "ebc5", "compasses-2-line" to "ebc6", "compasses-fill" to "ebc7", "compasses-line" to "ebc8", "computer-fill" to "ebc9", "computer-line" to "ebca", "contacts-book-2-fill" to "ebcb", "contacts-book-2-line" to "ebcc", "contacts-book-fill" to "ebcd", "contacts-book-line" to "ebce", "contacts-book-upload-fill" to "ebcf", "contacts-book-upload-line" to "ebd0", "contacts-fill" to "ebd1", "contacts-line" to "ebd2", "contrast-2-fill" to "ebd3", "contrast-2-line" to "ebd4", "contrast-drop-2-fill" to "ebd5", "contrast-drop-2-line" to "ebd6", "contrast-drop-fill" to "ebd7", "contrast-drop-line" to "ebd8", "contrast-fill" to "ebd9", "contrast-line" to "ebda", "copper-coin-fill" to "ebdb", "copper-coin-line" to "ebdc", "copper-diamond-fill" to "ebdd", "copper-diamond-line" to "ebde", "copyleft-fill" to "ebdf", "copyleft-line" to "ebe0", "copyright-fill" to "ebe1", "copyright-line" to "ebe2", "coreos-fill" to "ebe3", "coreos-line" to "ebe4", "coupon-2-fill" to "ebe5", "coupon-2-line" to "ebe6", "coupon-3-fill" to "ebe7", "coupon-3-line" to "ebe8", "coupon-4-fill" to "ebe9", "coupon-4-line" to "ebea", "coupon-5-fill" to "ebeb", "coupon-5-line" to "ebec", "coupon-fill" to "ebed", "coupon-line" to "ebee", "cpu-fill" to "ebef", "cpu-line" to "ebf0", "creative-commons-by-fill" to "ebf1", "creative-commons-by-line" to "ebf2", "creative-commons-fill" to "ebf3", "creative-commons-line" to "ebf4", "creative-commons-nc-fill" to "ebf5", "creative-commons-nc-line" to "ebf6", "creative-commons-nd-fill" to "ebf7", "creative-commons-nd-line" to "ebf8", "creative-commons-sa-fill" to "ebf9", "creative-commons-sa-line" to "ebfa", "creative-commons-zero-fill" to "ebfb", "creative-commons-zero-line" to "ebfc", "criminal-fill" to "ebfd", "criminal-line" to "ebfe", "crop-2-fill" to "ebff", "crop-2-line" to "ec00", "crop-fill" to "ec01", "crop-line" to "ec02", "css3-fill" to "ec03", "css3-line" to "ec04", "cup-fill" to "ec05", "cup-line" to "ec06", "currency-fill" to "ec07", "currency-line" to "ec08", "cursor-fill" to "ec09", "cursor-line" to "ec0a", "customer-service-2-fill" to "ec0b", "customer-service-2-line" to "ec0c", "customer-service-fill" to "ec0d", "customer-service-line" to "ec0e", "dashboard-2-fill" to "ec0f", "dashboard-2-line" to "ec10", "dashboard-3-fill" to "ec11", "dashboard-3-line" to "ec12", "dashboard-fill" to "ec13", "dashboard-line" to "ec14", "database-2-fill" to "ec15", "database-2-line" to "ec16", "database-fill" to "ec17", "database-line" to "ec18", "delete-back-2-fill" to "ec19", "delete-back-2-line" to "ec1a", "delete-back-fill" to "ec1b", "delete-back-line" to "ec1c", "delete-bin-2-fill" to "ec1d", "delete-bin-2-line" to "ec1e", "delete-bin-3-fill" to "ec1f", "delete-bin-3-line" to "ec20", "delete-bin-4-fill" to "ec21", "delete-bin-4-line" to "ec22", "delete-bin-5-fill" to "ec23", "delete-bin-5-line" to "ec24", "delete-bin-6-fill" to "ec25", "delete-bin-6-line" to "ec26", "delete-bin-7-fill" to "ec27", "delete-bin-7-line" to "ec28", "delete-bin-fill" to "ec29", "delete-bin-line" to "ec2a", "delete-column" to "ec2b", "delete-row" to "ec2c", "device-fill" to "ec2d", "device-line" to "ec2e", "device-recover-fill" to "ec2f", "device-recover-line" to "ec30", "dingding-fill" to "ec31", "dingding-line" to "ec32", "direction-fill" to "ec33", "direction-line" to "ec34", "disc-fill" to "ec35", "disc-line" to "ec36", "discord-fill" to "ec37", "discord-line" to "ec38", "discuss-fill" to "ec39", "discuss-line" to "ec3a", "dislike-fill" to "ec3b", "dislike-line" to "ec3c", "disqus-fill" to "ec3d", "disqus-line" to "ec3e", "divide-fill" to "ec3f", "divide-line" to "ec40", "donut-chart-fill" to "ec41", "donut-chart-line" to "ec42", "door-closed-fill" to "ec43", "door-closed-line" to "ec44", "door-fill" to "ec45", "door-line" to "ec46", "door-lock-box-fill" to "ec47", "door-lock-box-line" to "ec48", "door-lock-fill" to "ec49", "door-lock-line" to "ec4a", "door-open-fill" to "ec4b", "door-open-line" to "ec4c", "dossier-fill" to "ec4d", "dossier-line" to "ec4e", "douban-fill" to "ec4f", "douban-line" to "ec50", "double-quotes-l" to "ec51", "double-quotes-r" to "ec52", "download-2-fill" to "ec53", "download-2-line" to "ec54", "download-cloud-2-fill" to "ec55", "download-cloud-2-line" to "ec56", "download-cloud-fill" to "ec57", "download-cloud-line" to "ec58")
}
fun __gen_hugeObject0_0(): kotlin.Array<kotlin.Pair<String, Any?>> {
    return arrayOf("24-hours-fill" to "ea01", "24-hours-line" to "ea02", "4k-fill" to "ea03", "4k-line" to "ea04", "a-b" to "ea05", "account-box-fill" to "ea06", "account-box-line" to "ea07", "account-circle-fill" to "ea08", "account-circle-line" to "ea09", "account-pin-box-fill" to "ea0a", "account-pin-box-line" to "ea0b", "account-pin-circle-fill" to "ea0c", "account-pin-circle-line" to "ea0d", "add-box-fill" to "ea0e", "add-box-line" to "ea0f", "add-circle-fill" to "ea10", "add-circle-line" to "ea11", "add-fill" to "ea12", "add-line" to "ea13", "admin-fill" to "ea14", "admin-line" to "ea15", "advertisement-fill" to "ea16", "advertisement-line" to "ea17", "airplay-fill" to "ea18", "airplay-line" to "ea19", "alarm-fill" to "ea1a", "alarm-line" to "ea1b", "alarm-warning-fill" to "ea1c", "alarm-warning-line" to "ea1d", "album-fill" to "ea1e", "album-line" to "ea1f", "alert-fill" to "ea20", "alert-line" to "ea21", "aliens-fill" to "ea22", "aliens-line" to "ea23", "align-bottom" to "ea24", "align-center" to "ea25", "align-justify" to "ea26", "align-left" to "ea27", "align-right" to "ea28", "align-top" to "ea29", "align-vertically" to "ea2a", "alipay-fill" to "ea2b", "alipay-line" to "ea2c", "amazon-fill" to "ea2d", "amazon-line" to "ea2e", "anchor-fill" to "ea2f", "anchor-line" to "ea30", "ancient-gate-fill" to "ea31", "ancient-gate-line" to "ea32", "ancient-pavilion-fill" to "ea33", "ancient-pavilion-line" to "ea34", "android-fill" to "ea35", "android-line" to "ea36", "angularjs-fill" to "ea37", "angularjs-line" to "ea38", "anticlockwise-2-fill" to "ea39", "anticlockwise-2-line" to "ea3a", "anticlockwise-fill" to "ea3b", "anticlockwise-line" to "ea3c", "app-store-fill" to "ea3d", "app-store-line" to "ea3e", "apple-fill" to "ea3f", "apple-line" to "ea40", "apps-2-fill" to "ea41", "apps-2-line" to "ea42", "apps-fill" to "ea43", "apps-line" to "ea44", "archive-drawer-fill" to "ea45", "archive-drawer-line" to "ea46", "archive-fill" to "ea47", "archive-line" to "ea48", "arrow-down-circle-fill" to "ea49", "arrow-down-circle-line" to "ea4a", "arrow-down-fill" to "ea4b", "arrow-down-line" to "ea4c", "arrow-down-s-fill" to "ea4d", "arrow-down-s-line" to "ea4e", "arrow-drop-down-fill" to "ea4f", "arrow-drop-down-line" to "ea50", "arrow-drop-left-fill" to "ea51", "arrow-drop-left-line" to "ea52", "arrow-drop-right-fill" to "ea53", "arrow-drop-right-line" to "ea54", "arrow-drop-up-fill" to "ea55", "arrow-drop-up-line" to "ea56", "arrow-go-back-fill" to "ea57", "arrow-go-back-line" to "ea58", "arrow-go-forward-fill" to "ea59", "arrow-go-forward-line" to "ea5a", "arrow-left-circle-fill" to "ea5b", "arrow-left-circle-line" to "ea5c", "arrow-left-down-fill" to "ea5d", "arrow-left-down-line" to "ea5e", "arrow-left-fill" to "ea5f", "arrow-left-line" to "ea60", "arrow-left-right-fill" to "ea61", "arrow-left-right-line" to "ea62", "arrow-left-s-fill" to "ea63", "arrow-left-s-line" to "ea64", "arrow-left-up-fill" to "ea65", "arrow-left-up-line" to "ea66", "arrow-right-circle-fill" to "ea67", "arrow-right-circle-line" to "ea68", "arrow-right-down-fill" to "ea69", "arrow-right-down-line" to "ea6a", "arrow-right-fill" to "ea6b", "arrow-right-line" to "ea6c", "arrow-right-s-fill" to "ea6d", "arrow-right-s-line" to "ea6e", "arrow-right-up-fill" to "ea6f", "arrow-right-up-line" to "ea70", "arrow-up-circle-fill" to "ea71", "arrow-up-circle-line" to "ea72", "arrow-up-down-fill" to "ea73", "arrow-up-down-line" to "ea74", "arrow-up-fill" to "ea75", "arrow-up-line" to "ea76", "arrow-up-s-fill" to "ea77", "arrow-up-s-line" to "ea78", "artboard-2-fill" to "ea79", "artboard-2-line" to "ea7a", "artboard-fill" to "ea7b", "artboard-line" to "ea7c", "article-fill" to "ea7d", "article-line" to "ea7e", "aspect-ratio-fill" to "ea7f", "aspect-ratio-line" to "ea80", "asterisk" to "ea81", "at-fill" to "ea82", "at-line" to "ea83", "attachment-2" to "ea84", "attachment-fill" to "ea85", "attachment-line" to "ea86", "auction-fill" to "ea87", "auction-line" to "ea88", "award-fill" to "ea89", "award-line" to "ea8a", "baidu-fill" to "ea8b", "baidu-line" to "ea8c", "ball-pen-fill" to "ea8d", "ball-pen-line" to "ea8e", "bank-card-2-fill" to "ea8f", "bank-card-2-line" to "ea90", "bank-card-fill" to "ea91", "bank-card-line" to "ea92", "bank-fill" to "ea93", "bank-line" to "ea94", "bar-chart-2-fill" to "ea95", "bar-chart-2-line" to "ea96", "bar-chart-box-fill" to "ea97", "bar-chart-box-line" to "ea98", "bar-chart-fill" to "ea99", "bar-chart-grouped-fill" to "ea9a", "bar-chart-grouped-line" to "ea9b", "bar-chart-horizontal-fill" to "ea9c", "bar-chart-horizontal-line" to "ea9d", "bar-chart-line" to "ea9e", "barcode-box-fill" to "ea9f", "barcode-box-line" to "eaa0", "barcode-fill" to "eaa1", "barcode-line" to "eaa2", "barricade-fill" to "eaa3", "barricade-line" to "eaa4", "base-station-fill" to "eaa5", "base-station-line" to "eaa6", "basketball-fill" to "eaa7", "basketball-line" to "eaa8", "battery-2-charge-fill" to "eaa9", "battery-2-charge-line" to "eaaa", "battery-2-fill" to "eaab", "battery-2-line" to "eaac", "battery-charge-fill" to "eaad", "battery-charge-line" to "eaae", "battery-fill" to "eaaf", "battery-line" to "eab0", "battery-low-fill" to "eab1", "battery-low-line" to "eab2", "battery-saver-fill" to "eab3", "battery-saver-line" to "eab4", "battery-share-fill" to "eab5", "battery-share-line" to "eab6", "bear-smile-fill" to "eab7", "bear-smile-line" to "eab8", "behance-fill" to "eab9", "behance-line" to "eaba", "bell-fill" to "eabb", "bell-line" to "eabc", "bike-fill" to "eabd", "bike-line" to "eabe", "bilibili-fill" to "eabf", "bilibili-line" to "eac0", "bill-fill" to "eac1", "bill-line" to "eac2", "billiards-fill" to "eac3", "billiards-line" to "eac4", "bit-coin-fill" to "eac5", "bit-coin-line" to "eac6", "blaze-fill" to "eac7", "blaze-line" to "eac8", "bluetooth-connect-fill" to "eac9", "bluetooth-connect-line" to "eaca", "bluetooth-fill" to "eacb", "bluetooth-line" to "eacc", "blur-off-fill" to "eacd", "blur-off-line" to "eace", "body-scan-fill" to "eacf", "body-scan-line" to "ead0", "bold" to "ead1", "book-2-fill" to "ead2", "book-2-line" to "ead3", "book-3-fill" to "ead4", "book-3-line" to "ead5", "book-fill" to "ead6", "book-line" to "ead7", "book-marked-fill" to "ead8", "book-marked-line" to "ead9", "book-open-fill" to "eada", "book-open-line" to "eadb", "book-read-fill" to "eadc", "book-read-line" to "eadd", "booklet-fill" to "eade", "booklet-line" to "eadf", "bookmark-2-fill" to "eae0", "bookmark-2-line" to "eae1", "bookmark-3-fill" to "eae2", "bookmark-3-line" to "eae3", "bookmark-fill" to "eae4", "bookmark-line" to "eae5", "boxing-fill" to "eae6", "boxing-line" to "eae7", "braces-fill" to "eae8", "braces-line" to "eae9", "brackets-fill" to "eaea", "brackets-line" to "eaeb", "briefcase-2-fill" to "eaec", "briefcase-2-line" to "eaed", "briefcase-3-fill" to "eaee", "briefcase-3-line" to "eaef", "briefcase-4-fill" to "eaf0", "briefcase-4-line" to "eaf1", "briefcase-5-fill" to "eaf2", "briefcase-5-line" to "eaf3", "briefcase-fill" to "eaf4", "briefcase-line" to "eaf5", "bring-forward" to "eaf6", "bring-to-front" to "eaf7", "broadcast-fill" to "eaf8", "broadcast-line" to "eaf9", "brush-2-fill" to "eafa", "brush-2-line" to "eafb", "brush-3-fill" to "eafc", "brush-3-line" to "eafd", "brush-4-fill" to "eafe", "brush-4-line" to "eaff", "brush-fill" to "eb00", "brush-line" to "eb01", "bubble-chart-fill" to "eb02", "bubble-chart-line" to "eb03", "bug-2-fill" to "eb04", "bug-2-line" to "eb05", "bug-fill" to "eb06", "bug-line" to "eb07", "building-2-fill" to "eb08", "building-2-line" to "eb09", "building-3-fill" to "eb0a", "building-3-line" to "eb0b", "building-4-fill" to "eb0c", "building-4-line" to "eb0d", "building-fill" to "eb0e", "building-line" to "eb0f", "bus-2-fill" to "eb10", "bus-2-line" to "eb11", "bus-fill" to "eb12", "bus-line" to "eb13", "bus-wifi-fill" to "eb14", "bus-wifi-line" to "eb15", "cactus-fill" to "eb16", "cactus-line" to "eb17", "cake-2-fill" to "eb18", "cake-2-line" to "eb19", "cake-3-fill" to "eb1a", "cake-3-line" to "eb1b", "cake-fill" to "eb1c", "cake-line" to "eb1d", "calculator-fill" to "eb1e", "calculator-line" to "eb1f", "calendar-2-fill" to "eb20", "calendar-2-line" to "eb21", "calendar-check-fill" to "eb22", "calendar-check-line" to "eb23", "calendar-event-fill" to "eb24", "calendar-event-line" to "eb25", "calendar-fill" to "eb26", "calendar-line" to "eb27", "calendar-todo-fill" to "eb28", "calendar-todo-line" to "eb29", "camera-2-fill" to "eb2a", "camera-2-line" to "eb2b", "camera-3-fill" to "eb2c")
}
val runBlock1 = run {
    __uniConfig.getAppStyles = fun(): Map<String, Map<String, Map<String, Any>>> {
        return GenApp.styles
    }
}
open class scanReceiverOptions (
    @JsonNotNull
    open var name: String,
    @JsonNotNull
    open var kuxBroadcastReceiver: KuxBroadcastReceiver,
    open var success: (res: UTSArray<*>) -> Unit,
) : UTSObject()
open class scanCode {
    open fun init(actionName: String): KuxBroadcastReceiver {
        var kuxBroadcastReceiver: KuxBroadcastReceiver = useBroadcastReceiver() as KuxBroadcastReceiver
        kuxBroadcastReceiver.addAction(AddActionOptions(actionName = actionName))
        return kuxBroadcastReceiver
    }
    open fun regAction(options: scanReceiverOptions): Boolean {
        var res = options.kuxBroadcastReceiver.registerReceiver(RegisterReceiverOptions(broadcastNames = _uA<BroadcastNameItem>(BroadcastNameItem(type = "string", name = options.name, defaultValue = "")), success = fun(_){
            console.log("注册监听成功")
        }
        , fail = fun(e){
            console.log("添加失败，错误码：" + e.errCode)
        }
        ))
        options.kuxBroadcastReceiver.onReceiver(fun(data){
            console.log("监听广播触发新事件", data)
            options.success(data)
        }
        )
        return true
    }
    open fun stop(kuxBroadcastReceiver: KuxBroadcastReceiver): Boolean {
        var res = kuxBroadcastReceiver.unregisterReceiver(UnregisterReceiverOptions(success = fun(_){
            console.log("取消监听成功")
        }
        , fail = fun(e){
            console.log("取消监听失败，错误码：" + e.errCode)
        }
        ))
        return res as Boolean
    }
}
open class AppConfig {
    companion object {
        var isDebug: Boolean = true
        var openSocket: Boolean = false
        var host: String = "https://manager.fresh361.com/"
        var postHost: String = "https://post.fresh361.com/"
        var socketHost: String = "wss://ws.fresh361.com:365"
        var socketKey: String = "uvyahY.}sFdKCu_j7<0kZFrYYYIfqT:o`(%#|}d})kE0NHXe.SXK8n'm|bKQ(c"
        var wxatag: String = "app"
        var module: String = "pdaapp"
        var appid: String = "52413292564"
        var appkey: String = "21ba7cd678446499a15d4cfca7be3577"
        var appPublicPwd: String = "MarketManager"
        var APIAppid: String = "240650054141"
        var tongjiHost: String = "https://api.itgz8.com/v1/tongji/uploaddata"
        fun app_version(): String {
            var info = uni_getAppBaseInfo(null)
            return info.appVersion as String
        }
    }
}
open class responseType (
    @JsonNotNull
    open var code: Number,
    open var data: Any? = null,
    @JsonNotNull
    open var msg: String,
    open var response_id: String? = null,
    @JsonNotNull
    open var info: UTSJSONObject,
) : UTSObject()
open class citySectionListItem (
    @JsonNotNull
    open var name: String,
    @JsonNotNull
    open var code: String,
    @JsonNotNull
    open var pinyin: String,
    @JsonNotNull
    open var head: String,
    @JsonNotNull
    open var short: String,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return citySectionListItemReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class citySectionListItemReactiveObject : citySectionListItem, IUTSReactive<citySectionListItem> {
    override var __v_raw: citySectionListItem
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: citySectionListItem, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(name = __v_raw.name, code = __v_raw.code, pinyin = __v_raw.pinyin, head = __v_raw.head, short = __v_raw.short) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): citySectionListItemReactiveObject {
        return citySectionListItemReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var name: String
        get() {
            return _tRG(__v_raw, "name", __v_raw.name, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("name")) {
                return
            }
            val oldValue = __v_raw.name
            __v_raw.name = value
            _tRS(__v_raw, "name", oldValue, value)
        }
    override var code: String
        get() {
            return _tRG(__v_raw, "code", __v_raw.code, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("code")) {
                return
            }
            val oldValue = __v_raw.code
            __v_raw.code = value
            _tRS(__v_raw, "code", oldValue, value)
        }
    override var pinyin: String
        get() {
            return _tRG(__v_raw, "pinyin", __v_raw.pinyin, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("pinyin")) {
                return
            }
            val oldValue = __v_raw.pinyin
            __v_raw.pinyin = value
            _tRS(__v_raw, "pinyin", oldValue, value)
        }
    override var head: String
        get() {
            return _tRG(__v_raw, "head", __v_raw.head, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("head")) {
                return
            }
            val oldValue = __v_raw.head
            __v_raw.head = value
            _tRS(__v_raw, "head", oldValue, value)
        }
    override var short: String
        get() {
            return _tRG(__v_raw, "short", __v_raw.short, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("short")) {
                return
            }
            val oldValue = __v_raw.short
            __v_raw.short = value
            _tRS(__v_raw, "short", oldValue, value)
        }
}
open class citySectionData (
    @JsonNotNull
    open var name: String,
    @JsonNotNull
    open var list: UTSArray<citySectionListItem>,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return citySectionDataReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class citySectionDataReactiveObject : citySectionData, IUTSReactive<citySectionData> {
    override var __v_raw: citySectionData
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: citySectionData, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(name = __v_raw.name, list = __v_raw.list) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): citySectionDataReactiveObject {
        return citySectionDataReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var name: String
        get() {
            return _tRG(__v_raw, "name", __v_raw.name, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("name")) {
                return
            }
            val oldValue = __v_raw.name
            __v_raw.name = value
            _tRS(__v_raw, "name", oldValue, value)
        }
    override var list: UTSArray<citySectionListItem>
        get() {
            return _tRG(__v_raw, "list", __v_raw.list, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("list")) {
                return
            }
            val oldValue = __v_raw.list
            __v_raw.list = value
            _tRS(__v_raw, "list", oldValue, value)
        }
}
open class selectedListType (
    @JsonNotNull
    open var id: Number,
    @JsonNotNull
    open var goods: UTSJSONObject,
    @JsonNotNull
    open var number: Number,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return selectedListTypeReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class selectedListTypeReactiveObject : selectedListType, IUTSReactive<selectedListType> {
    override var __v_raw: selectedListType
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: selectedListType, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(id = __v_raw.id, goods = __v_raw.goods, number = __v_raw.number) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): selectedListTypeReactiveObject {
        return selectedListTypeReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var id: Number
        get() {
            return _tRG(__v_raw, "id", __v_raw.id, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("id")) {
                return
            }
            val oldValue = __v_raw.id
            __v_raw.id = value
            _tRS(__v_raw, "id", oldValue, value)
        }
    override var goods: UTSJSONObject
        get() {
            return _tRG(__v_raw, "goods", __v_raw.goods, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("goods")) {
                return
            }
            val oldValue = __v_raw.goods
            __v_raw.goods = value
            _tRS(__v_raw, "goods", oldValue, value)
        }
    override var number: Number
        get() {
            return _tRG(__v_raw, "number", __v_raw.number, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("number")) {
                return
            }
            val oldValue = __v_raw.number
            __v_raw.number = value
            _tRS(__v_raw, "number", oldValue, value)
        }
}
open class bottomMenu (
    @JsonNotNull
    open var key: String,
    @JsonNotNull
    open var name: String,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return bottomMenuReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class bottomMenuReactiveObject : bottomMenu, IUTSReactive<bottomMenu> {
    override var __v_raw: bottomMenu
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: bottomMenu, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(key = __v_raw.key, name = __v_raw.name) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): bottomMenuReactiveObject {
        return bottomMenuReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var key: String
        get() {
            return _tRG(__v_raw, "key", __v_raw.key, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("key")) {
                return
            }
            val oldValue = __v_raw.key
            __v_raw.key = value
            _tRS(__v_raw, "key", oldValue, value)
        }
    override var name: String
        get() {
            return _tRG(__v_raw, "name", __v_raw.name, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("name")) {
                return
            }
            val oldValue = __v_raw.name
            __v_raw.name = value
            _tRS(__v_raw, "name", oldValue, value)
        }
}
open class OpenMPOptions (
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
open class mpContext {
    protected open var mp: UniMPInstance? = null
    constructor(){
        var mp = uni_createUniMPContext()
        this.mp = mp
    }
    public open fun install(appid: String, url: String): UTSPromise<Boolean> {
        return wrapUTSPromise(suspend w@{
                var ret = await(UTSPromise(fun(resolve, reject){
                    uni_downloadFile(DownloadFileOptions(url = url, timeout = 30000, success = fun(fres) {
                        var file = fres.tempFilePath
                        this.mp?.installUniMP(InstallUniMPOptions(appid = appid, wgtFile = file, success = fun(r: UniMPResult) {
                            console.log("installUniMP: " + JSON.stringify(r))
                            if (r.code == 0) {
                                resolve(true)
                                return
                            }
                            resolve(false)
                        }
                        , fail = fun(res: UniMPFail) {
                            console.log("installUniMP失败: " + JSON.stringify(res))
                            resolve(false)
                        }
                        ))
                    }
                    , fail = fun(_) {
                        resolve(false)
                    }
                    ))
                }
                ))
                return@w ret
        })
    }
    public open fun open(openOptions: OpenMPOptions, event: (fromAppID: String, event: String, data: Any?) -> Unit) {
        this.mp?.onUniMPEventReceive(fun(res: UniMPEventResult){
            console.log("Receive event from MP: " + JSON.stringify(res))
            event(res.fromAppid, res.event, res.data)
        }
        )
        this.mp?.openUniMP(OpenUniMPOptions(appid = openOptions.appid, icon = openOptions.icon, path = openOptions.path, extraData = openOptions.extraData, fromAppid = openOptions.fromAppid, scene = openOptions.scene, openMode = openOptions.openMode, enableGestureClose = openOptions.enableGestureClose, enableShowAnimated = openOptions.enableShowAnimated, enableHideAnimated = openOptions.enableHideAnimated, enableBackground = openOptions.enableBackground))
    }
    public open fun close(appid: String) {
        this.mp?.closeUniMP(appid, fun(ret){
            console.log("closeUniMP: " + JSON.stringify(ret))
        }
        )
    }
    public open fun hide(appid: String) {
        this.mp?.hideUniMP(appid, fun(ret){
            console.log("hideUniMP: " + JSON.stringify(ret))
        }
        )
    }
    public open fun show(appid: String) {
        this.mp?.showUniMP(appid, fun(ret){
            console.log("showUniMP: " + JSON.stringify(ret))
        }
        )
    }
    public open fun getVersion(appid: String): UTSPromise<VersionInfo?> {
        return wrapUTSPromise(suspend w@{
                return@w await(UTSPromise(fun(resolve, reject){
                    this.mp?.getUniMPVersion(appid, fun(ret){
                        console.log("getUniMPVersion: " + JSON.stringify(ret))
                        if (ret.code != 0) {
                            resolve(null)
                            return
                        }
                        resolve(ret.versionInfo)
                    }
                    )
                }
                ))
        })
    }
    public open fun sendEvent(appid: String, event: String, data: UTSJSONObject) {
        this.mp?.sendUniMPEvent(appid, event, data, fun(ret){
            console.log("Send event to MP: " + JSON.stringify(ret))
        }
        )
    }
    public open fun setMenus(menuList: MenuOptions, clickMenu: (appid: String, id: String) -> Unit) {
        var items = _uA<ActionSheetItem>()
        for(it in resolveUTSValueIterator(menuList.items)){
            items.push(ActionSheetItem(id = it.id, title = it.title))
        }
        var menu = MenuItemsOptions(items = items)
        this.mp?.setDefaultMenuItems(menu, fun(ret){
            clickMenu(ret.appid, ret.id)
        }
        )
    }
}
open class MenuOptions (
    @JsonNotNull
    open var items: UTSArray<ActionItem>,
) : UTSObject()
open class ActionItem (
    @JsonNotNull
    open var title: String,
    @JsonNotNull
    open var id: String,
) : UTSObject()
open class positionInfo (
    open var department_id: Any? = null,
    open var department_name: Any? = null,
    open var position_id: Any? = null,
    open var position_name: Any? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return positionInfoReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class positionInfoReactiveObject : positionInfo, IUTSReactive<positionInfo> {
    override var __v_raw: positionInfo
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: positionInfo, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(department_id = __v_raw.department_id, department_name = __v_raw.department_name, position_id = __v_raw.position_id, position_name = __v_raw.position_name) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): positionInfoReactiveObject {
        return positionInfoReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var department_id: Any?
        get() {
            return _tRG(__v_raw, "department_id", __v_raw.department_id, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("department_id")) {
                return
            }
            val oldValue = __v_raw.department_id
            __v_raw.department_id = value
            _tRS(__v_raw, "department_id", oldValue, value)
        }
    override var department_name: Any?
        get() {
            return _tRG(__v_raw, "department_name", __v_raw.department_name, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("department_name")) {
                return
            }
            val oldValue = __v_raw.department_name
            __v_raw.department_name = value
            _tRS(__v_raw, "department_name", oldValue, value)
        }
    override var position_id: Any?
        get() {
            return _tRG(__v_raw, "position_id", __v_raw.position_id, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("position_id")) {
                return
            }
            val oldValue = __v_raw.position_id
            __v_raw.position_id = value
            _tRS(__v_raw, "position_id", oldValue, value)
        }
    override var position_name: Any?
        get() {
            return _tRG(__v_raw, "position_name", __v_raw.position_name, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("position_name")) {
                return
            }
            val oldValue = __v_raw.position_name
            __v_raw.position_name = value
            _tRS(__v_raw, "position_name", oldValue, value)
        }
}
open class pda {
    public open fun main(): UTSPromise<Unit> {
        return wrapUTSPromise(suspend {
                var isauth = await(this.checkAuthDevice())
                setAuthDevice(isauth)
        })
    }
    private fun checkAuthDevice(): UTSPromise<Boolean> {
        return wrapUTSPromise(suspend w@{
                var res = await(request.callapi("data/checkauthdevice", _uO()))
                if (res == null || res.code < 0) {
                    return@w false
                }
                return@w true
        })
    }
    companion object {
        fun start(): UTSPromise<Boolean> {
            return wrapUTSPromise(suspend w@{
                    var p = pda()
                    p.main()
                    return@w true
            })
        }
    }
}
open class LocationResult (
    open var latitude: Number? = null,
    open var longitude: Number? = null,
    open var accuracy: Number? = null,
    open var speed: Number? = null,
) : UTSObject()
open class scanCodeResult (
    @JsonNotNull
    open var success: Boolean = false,
    @JsonNotNull
    open var message: String,
    open var codeType: QRCodeType? = null,
    open var codeValue: String? = null,
    open var codeData: Any? = null,
    open var image: CodeImage? = null,
) : UTSObject()
open class LocationInfoResult (
    @JsonNotNull
    open var latitude: Number,
    @JsonNotNull
    open var longitude: Number,
    @JsonNotNull
    open var province: String,
    @JsonNotNull
    open var city: String,
    @JsonNotNull
    open var city_short: String,
    @JsonNotNull
    open var city_code: String,
    @JsonNotNull
    open var area: String,
    @JsonNotNull
    open var street: String,
    @JsonNotNull
    open var address: String,
    @JsonNotNull
    open var area_code: String,
    @JsonNotNull
    open var street_code: String,
    @JsonNotNull
    open var accuracy: Number,
) : UTSObject()
open class common {
    companion object {
        fun goto(reassignedUrl: String, animationType: String = "auto"): Boolean {
            var url = reassignedUrl
            if (url == "") {
                return true
            }
            if (url.startsWith("tab:")) {
                url = url.replace(UTSRegExp("tab:", ""), "")
                uni_redirectTo(RedirectToOptions(url = url))
                return true
            }
            var currentRoutes = getCurrentPages()
            if (currentRoutes.length > 10) {
                uni_navigateTo(NavigateToOptions(url = url, animationType = animationType, fail = fun(_) {
                    uni_switchTab(SwitchTabOptions(url = url))
                }
                ))
                return false
            }
            run {
                var i: Number = 0
                while(i < currentRoutes.length){
                    if ("/" + currentRoutes[i].route === url) {
                        uni_navigateBack(NavigateBackOptions(delta = currentRoutes.length - i - 1))
                        return false
                    }
                    i++
                }
            }
            uni_navigateTo(NavigateToOptions(url = url, animationType = animationType, fail = fun(r){
                uni_switchTab(SwitchTabOptions(url = url))
            }
            ))
            return false
        }
        fun chooseDate(that: Any): UTSPromise<String?> {
            return wrapUTSPromise(suspend w@{
                    var r = await(UTSPromise(fun(resolve, reject){
                        uni__once("choosedate", fun(r: String?) {
                            resolve(r)
                        }
                        )
                        common.callMethod(that, "open")
                    }
                    ))
                    return@w r
            })
        }
        fun callPhone(phone: String) {
            uni_makePhoneCall(MakePhoneCallOptions(phoneNumber = phone))
        }
        fun `$chooseLocation`(): UTSPromise<UTSJSONObject> {
            return wrapUTSPromise(suspend w@{
                    console.log("调用chooseLocation")
                    var res = await(chooseLocation())
                    return@w res
            })
        }
        fun openLocation(coordinate: LatLng, title: String, address: String, distance: Number = 0) {
            return openLocation(coordinate.lat, coordinate.lng, distance, title, address)
        }
        fun setStorage(key: String, data: Any) {
            return uni_setStorageSync(key, data)
        }
        fun getStorage(key: String): Any {
            var result = uni_getStorageSync(key)
            return result as Any
        }
        fun rmStorage(key: String): Unit {
            uni_removeStorage(RemoveStorageOptions(key = key))
        }
        fun toast(title: String, icon: String = "none") {
            uni_showToast(ShowToastOptions(title = title, icon = icon, mask = true))
        }
        fun showModal(that: Any, content: String, title: String = "提示") {
            (that as ComponentPublicInstance).`$callMethod`("showModal", content, title)
        }
        fun showQuery(that: Any, content: String, title: String = "提示"): UTSPromise<Boolean> {
            return wrapUTSPromise(suspend w@{
                    var res = await(((that as ComponentPublicInstance).`$callMethod`("showConfirm", content, title) as UTSPromise<Boolean>))
                    return@w res
            })
        }
        @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
        fun callMethod(that: Any, method: String, vararg spreadArgs: Any) {
            var args = UTSArray(*spreadArgs)
            (that as ComponentPublicInstance).`$callMethod`(method, *args.toTypedArray())
        }
        fun readFile(file: String): String? {
            val fs = uni_getFileSystemManager()
            try {
                val data = fs.readFileSync(file, "base64")
                return data as String
            }
             catch (e: Throwable) {
                return null
            }
        }
        fun signer(that: Any): UTSPromise<String?> {
            return wrapUTSPromise(suspend w@{
                    var component = that as ComponentPublicInstance
                    var r = await(UTSPromise(fun(resolve, reject){
                        uni__once("signer", fun(res: UTSJSONObject) {
                            console.log("收到签名", res)
                            if ((res["code"] as Number) < 0) {
                                component.`$callMethod`("close")
                                resolve(null)
                                return
                            }
                            var signID = res.getNumber("data")
                            console.log(signID)
                            component.`$callMethod`("close")
                            return resolve(signID.toString())
                        }
                        )
                        component.`$callMethod`("open")
                    }
                    ))
                    return@w r
            })
        }
        fun RandStrUUID(): String {
            var timestamp = Date().getTime()
            var uuidTemplate = "xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx"
            var uuid = ""
            run {
                var i: Number = 0
                while(i < uuidTemplate.length){
                    var c = uuidTemplate.substring(i, i + 1)
                    if (c == "x" || c == "y") {
                        var r = (timestamp + Math.random() * 16) % 16 or 0
                        timestamp = Math.floor(timestamp / 16)
                        uuid += (if (c == "x") {
                            r
                        } else {
                            (r and 0x3 or 0x8)
                        }).toString(16)
                    } else {
                        uuid += c
                    }
                    i++
                }
            }
            return uuid
        }
        fun getMetaInfo(): String {
            var cacheSystem = common.getStorage("systeminfo")
            console.log("获取到的system缓存", cacheSystem)
            if (cacheSystem != "") {}
            var system = uni_getSystemInfoSync()
            var deviceInfo = uni_getDeviceInfo(null)
            var appinfo = uni_getAppBaseInfo(null)
            var meta: UTSJSONObject = _uO("os" to _uO("version" to system.osVersion, "language" to system.osLanguage, "name" to system.osName, "ua" to system.ua, "isRoot" to deviceInfo.isRoot, "platform" to deviceInfo.platform), "device" to _uO("id" to common.deviceID(), "uuid" to system.deviceId, "brand" to system.deviceBrand, "model" to system.deviceModel, "type" to system.deviceType), "platform" to AppConfig.wxatag, "module" to AppConfig.module, "sdk" to _uO("version" to system.uniCompilerVersion, "romVersion" to system.romVersion), "screen" to _uO("width" to system.screenWidth, "height" to system.screenHeight, "status_height" to system.statusBarHeight), "appinfo" to _uO("lauguage" to appinfo.appLanguage, "version" to appinfo.appVersion, "version_code" to appinfo.appVersionCode))
            common.setStorage("systeminfo", JSON.stringify(meta))
            return JSON.stringify(meta)
        }
        fun deviceID(): String {
            var uuid = common.getStorage("uuid")
            if (uuid == "") {
                uuid = getUUID()
                common.setStorage("uuid", uuid as Any)
            }
            return uuid as String
        }
        fun loading(that: Any?, title: String = "加载中") {
            if (that != null) {
                (that as ComponentPublicInstance).`$callMethod`("showLoading", title)
            }
        }
        fun hideLoading(that: Any?) {
            if (that != null) {
                (that as ComponentPublicInstance).`$callMethod`("closeLoading")
            }
        }
        fun getLocation(mode: String, purpose: String, needAddress: Boolean = false): UTSPromise<LocationResult> {
            return wrapUTSPromise(suspend w@{
                    var res = await(UTSPromise(fun(resolve, reject){
                        singleLocation(mode, purpose, needAddress, fun(resp: UTSJSONObject) {
                            var log = "单次定位回调 " + JSON.stringify(resp)
                            console.log(log)
                            console.log(resp)
                            var result = LocationResult(latitude = resp["lat"] as Number, longitude = resp["lon"] as Number, accuracy = resp["accuracy"] as Number, speed = resp["speed"] as Number)
                            resolve(result)
                        }
                        , fun(reson: LocationError) {
                            console.error("定位失败", reson)
                            resolve(null)
                        }
                        )
                    }
                    ))
                    return@w res
            })
        }
        fun getLocationInfo(mode: String, purpose: String, needAddress: Boolean = false): UTSPromise<Any> {
            return wrapUTSPromise(suspend w@{
                    var location = await(common.getLocation(mode, purpose, needAddress))
                    console.log("地址坐标", location)
                    if (location == null) {
                        return@w false
                    }
                    if (location.latitude == 0) {
                        common.toast("地址获取失败")
                        return@w false
                    }
                    var res = await(request.callapi("common/locationinfo", _uO("lat" to location.latitude, "lng" to location.longitude)))
                    var code = res.code as Number
                    if (code < 0) {
                        return@w false
                    }
                    var data = res.data as UTSJSONObject
                    var result = LocationInfoResult(latitude = data["latitude"] as Number, longitude = data["longitude"] as Number, province = data["province"] as String, city = data["city"] as String, city_short = data["city_short"] as String, city_code = data["city_code"] as String, area = data["area"] as String, street = data["street"] as String, address = data["address"] as String, area_code = data["area_code"] as String, street_code = data["street_code"] as String, accuracy = location.accuracy as Number)
                    return@w result
            })
        }
        fun navigationBar(backgroundColor: String = "transparent", frontColor: String = "#ffffff") {
            uni_setNavigationBarColor(SetNavigationBarColorOptions(frontColor = frontColor, backgroundColor = backgroundColor))
        }
        fun print(key: String, type: String): UTSPromise<Unit> {
            return wrapUTSPromise(suspend {
                    console.log("执行打印预览", key)
                    common.goto("/pages/common/documentprintview?key=" + encodeURIComponent(key) + "&type=" + type, "slide-in-bottom")
            })
        }
        fun navigatoEvent(url: String): UTSPromise<UTSJSONObject> {
            return wrapUTSPromise(suspend w@{
                    var res = await(UTSPromise(fun(resolve, reject){
                        common.goto(url, "slide-in-bottom")
                        var onceUrl = url.split("?")[0]
                        uni__once(onceUrl, fun(data: UTSJSONObject) {
                            resolve(data)
                            common.back()
                        }
                        )
                    }
                    ))
                    return@w res
            })
        }
        fun lisenInfo(emitUrl: String, that: Any): UTSPromise<UTSJSONObject> {
            return wrapUTSPromise(suspend w@{
                    var res = await(UTSPromise(fun(resolve, reject){
                        var num = uni__once(emitUrl, fun(res: UTSJSONObject) {
                            console.log("收到返回信息", res)
                            resolve(res)
                        }
                        )
                        (that as ComponentPublicInstance).`$callMethod`("submit")
                        setTimeout(fun() {
                            uni__off(emitUrl, num)
                        }
                        , 1000)
                    }
                    ))
                    return@w res
            })
        }
        fun timeBack() {
            setTimeout(fun() {
                common.back()
            }
            , 1500)
        }
        fun timeToPage(page: String, redirect: Boolean = false) {
            setTimeout(fun() {
                if (redirect) {
                    uni_redirectTo(RedirectToOptions(url = page))
                    return
                }
                common.goto(page)
            }
            , 1500)
        }
        fun back() {
            uni_navigateBack(NavigateBackOptions())
        }
        fun copy(str: String) {
            setClipboardData(SetClipboardDataOption(data = str, showToast = true))
        }
        fun showPage() {
            pageInterceptor.showPage()
        }
        fun getNetworkType(): UTSPromise<GetNetworkTypeSuccess?> {
            return wrapUTSPromise(suspend w@{
                    var res = await(UTSPromise(fun(resolve, reject){
                        uni_getNetworkType(GetNetworkTypeOptions(success = fun(res: GetNetworkTypeSuccess){
                            resolve(res)
                        }
                        , fail = fun(_){
                            resolve(null)
                        }
                        ))
                    }
                    ))
                    return@w res
            })
        }
        fun getFileManager(): FileSystemManager {
            return uni_getFileSystemManager()
        }
        fun deleteAppFile(uri: String): Boolean {
            return deleteFile(uri)
        }
        fun systemShare() {
            uni_shareWithSystem(ShareWithSystemOptions(type = "text", summary = "分享内容"))
        }
        fun cameraVideo(maxDuration: Number): UTSPromise<UTSArray<UTSJSONObject>> {
            return wrapUTSPromise(suspend w@{
                    var res = await(UTSPromise(fun(resolve, reject){
                        uni_chooseVideo(ChooseVideoOptions(sourceType = _uA(
                            "camera"
                        ), maxDuration = maxDuration, success = fun(res: ChooseVideoSuccess) {
                            var path = res.tempFilePath
                            var result: UTSJSONObject = _uO("compress" to false, "duration" to res.duration, "ext" to "mp4", "from" to "camera", "thumb" to res.tempFilePath, "type" to "video", "uri" to path)
                            resolve(result)
                        }
                        , fail = fun(_) {
                            common.toast("获取失败，请重试")
                        }
                        ))
                    }
                    ))
                    return@w _uA<UTSJSONObject>(res)
            })
        }
        fun chooseImage(type: String, count: Number, compress: Number): UTSPromise<UTSArray<UTSJSONObject>> {
            return wrapUTSPromise(suspend w@{
                    var res = await(UTSPromise(fun(resolve, reject){
                        chooseImage(chooseOptions(type = type, count = count, camera = true, compress = compress, success = fun(res: UTSArray<UTSJSONObject>) {
                            resolve(res)
                        }
                        , fail = fun(reson: String) {
                            uni_showToast(ShowToastOptions(title = reson, icon = "error"))
                        }
                        ))
                    }
                    ))
                    return@w res
            })
        }
        fun previewImg(imgs: UTSArray<String>): Unit {
            var list = _uA<previewMedia>()
            for(it in resolveUTSValueIterator(imgs)){
                list.push(previewMedia(uri = it as String, type = "image"))
            }
            previewImage(previewOptions(list = list))
        }
        fun previewImgonce(that: Any, img: String): Unit {
            (that as ComponentPublicInstance).`$callMethod`("open", img)
        }
        fun scanCode(): UTSPromise<scanCodeResult> {
            return wrapUTSPromise(suspend w@{
                    var res = await(UTSPromise(fun(resolve, reject){
                        scanSimpleCode(SimpleCodeConfig(needImage = false, vibrate = true, success = fun(res: SuccessCallback) {
                            if (res.data.data.length <= 0) {
                                resolve(scanCodeResult(success = false, message = res.message))
                                return
                            }
                            resolve(scanCodeResult(success = true, message = res.message, codeType = res.data.data[0].type, codeValue = res.data.data[0].value, codeData = res.data.data[0].data as Any, image = res.data.image))
                        }
                        , fail = fun(res: CommonResultCallback) {
                            resolve(scanCodeResult(success = false, message = res.message))
                            return
                        }
                        ))
                    }
                    ))
                    return@w res
            })
        }
        fun chooseFile(): UTSPromise<UTSArray<UTSJSONObject>> {
            return wrapUTSPromise(suspend w@{
                    var res = await(UTSPromise(fun(resolve, reject){
                        uni_chooseFile(ChooseFileOptions(success = fun(r: ChooseFileSuccess) {
                            var path = r.tempFiles[0].path
                            var name = r.tempFiles[0].name
                            var extArr = name.split(".")
                            var ext = extArr[extArr.length - 1]
                            var result: UTSJSONObject = _uO("compress" to false, "duration" to 0, "ext" to ext, "from" to "file", "thumb" to path, "type" to "file", "uri" to path)
                            resolve(_uA(
                                result
                            ))
                        }
                        , fail = fun(e: IMediaError) {
                            if (e.errCode != 1101001) {
                                common.toast("启动图片选择器失败：" + e.errMsg)
                            }
                            resolve(_uA<UTSJSONObject>())
                        }
                        ))
                    }
                    ))
                    return@w res
            })
        }
        fun randStr(len: Number): String {
            var chars = "ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz2345678"
            var maxPos = chars.length
            var str = ""
            run {
                var i: Number = 0
                while(i < len){
                    str += chars.charAt(Math.floor(Math.random() * maxPos))
                    i++
                }
            }
            return str
        }
    }
}
open class PageState (
    open var page: String? = null,
    @JsonNotNull
    open var exptime: Number,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return PageStateReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class PageStateReactiveObject : PageState, IUTSReactive<PageState> {
    override var __v_raw: PageState
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: PageState, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(page = __v_raw.page, exptime = __v_raw.exptime) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): PageStateReactiveObject {
        return PageStateReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var page: String?
        get() {
            return _tRG(__v_raw, "page", __v_raw.page, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("page")) {
                return
            }
            val oldValue = __v_raw.page
            __v_raw.page = value
            _tRS(__v_raw, "page", oldValue, value)
        }
    override var exptime: Number
        get() {
            return _tRG(__v_raw, "exptime", __v_raw.exptime, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("exptime")) {
                return
            }
            val oldValue = __v_raw.exptime
            __v_raw.exptime = value
            _tRS(__v_raw, "exptime", oldValue, value)
        }
}
val pageState = reactive<PageState>(PageState(page = null, exptime = 0))
var metainfo: String = ""
open class pageInterceptor {
    companion object {
        private fun getPageUrl(): String {
            var pages = getCurrentPages()
            var page = ""
            if (pages.length > 0) {
                page = pages[pages.length - 1].route
            }
            return page
        }
        fun showPage(url: String? = null) {
            var page = ""
            if (url == null) {
                page = pageInterceptor.getPageUrl()
            } else {
                page = url
            }
            page = page.split("?")[0]
            console.log("新页面", page)
            if (pageState.page == null) {
                pageState.page = page
                pageState.exptime = Date.now()
            } else {
                var p = pageState.page as String
                var timeout = Date.now() - pageState.exptime
                console.log("出发点1")
                uploadPage(p, timeout)
                pageState.page = page
                pageState.exptime = Date.now()
            }
        }
        fun hidePage(exit: Boolean = false) {
            console.log("关闭")
            var page = pageInterceptor.getPageUrl()
            console.log("关闭1", page)
            page = page.split("?")[0]
            console.log("结束页面", page)
            var timeout = Date.now() - pageState.exptime
            console.log("出发点2")
            uploadPage(page, timeout)
            pageState.page = null
            pageState.exptime = Date.now()
            console.log("结束处理")
        }
        fun setInterceptor() {
            pageInterceptor.addNavigateTo()
            pageInterceptor.addRedirectTo()
            pageInterceptor.addReLaunch()
            pageInterceptor.addSwitchTab()
            pageInterceptor.addNavigateBack()
        }
        private fun uploadPage(page: String, time: Number) {
            if (time < 1000) {
                return
            }
            console.log("上报数据", page, time)
            pageInterceptor.callTongjiAPI(page, time)
        }
        private fun callTongjiAPI(page: String, time: Number) {
            var data: UTSJSONObject = _uO("page" to page, "time" to time)
            if (metainfo == "") {
                metainfo = common.getMetaInfo()
            }
            pageInterceptor.getToken().then(fun(tongjiToken: String?) {
                console.log("统计token", tongjiToken)
                if (tongjiToken == null) {
                    console.error("统计Token为空")
                    return
                }
                var appid = AppConfig.APIAppid
                val now = Date.now() + ""
                var requestData: UTSJSONObject = _uO("action" to "app.static.page", "data" to _uA(
                    data
                ), "metainfo" to metainfo, "version" to AppConfig.app_version(), "appid" to appid, "time" to now, "module" to AppConfig.module, "platform" to AppConfig.wxatag, "sign" to md5(metainfo + appid + now))
                uni_request<Any>(RequestOptions(url = AppConfig.tongjiHost, data = requestData, method = "POST", header = _uO("token" to tongjiToken), timeout = 3000, firstIpv4 = true, success = fun(res){
                    console.log("上报数据结果", res)
                    if (res.statusCode != 200) {
                        return
                    }
                    var rdata = res.data as UTSJSONObject
                    if ((rdata["code"] as Number) == -401.1) {
                        pageInterceptor.getToken(true).then(fun(t: String?) {
                            if (t != null) {
                                pageInterceptor.callTongjiAPI(page, time)
                            }
                        }
                        )
                    }
                }
                , fail = fun(err){
                    console.log("请求失败", err)
                    return
                }
                ))
            }
            )
        }
        public fun getToken(hasNew: Boolean = false): UTSPromise<String?> {
            return wrapUTSPromise(suspend w@{
                    return@w await(UTSPromise(fun(resolve, reject){
                        if (hasNew == false) {
                            var t = common.getStorage("tongji_token").toString()
                            if (t != null && t != "") {
                                resolve(t)
                                return
                            }
                        }
                        request.callapi("user/gettongjitoken", _uO()).then(fun(res: responseType) {
                            if (res.code != 0) {
                                resolve(null)
                                return
                            }
                            var data = res.data as UTSJSONObject
                            val storageToken = data["token"] as String
                            common.setStorage("tongji_token", storageToken)
                            resolve(storageToken)
                            return
                        }
                        )
                    }
                    ))
            })
        }
        private fun addNavigateTo() {
            val navigateToInterceptor = AddInterceptorOptions(invoke = fun(options: NavigateToOptions) {
                var url = options.url as String
                pageInterceptor.showPage(url)
            }
            )
            uni_addInterceptor("navigateTo", navigateToInterceptor)
        }
        private fun addRedirectTo() {
            val redirectToInterceptor = AddInterceptorOptions(invoke = fun(options: RedirectToOptions) {
                var url = options.url as String
                pageInterceptor.showPage(url)
            }
            )
            uni_addInterceptor("redirectTo", redirectToInterceptor)
        }
        private fun addReLaunch() {
            val redirectToInterceptor = AddInterceptorOptions(invoke = fun(options: ReLaunchOptions) {
                var url = options.url as String
                pageInterceptor.showPage(url)
            }
            )
            uni_addInterceptor("reLaunch", redirectToInterceptor)
        }
        private fun addSwitchTab() {
            val redirectToInterceptor = AddInterceptorOptions(invoke = fun(options: SwitchTabOptions) {
                var url = options.url as String
                pageInterceptor.showPage(url)
            }
            )
            uni_addInterceptor("switchTab", redirectToInterceptor)
        }
        private fun addNavigateBack() {
            val redirectToInterceptor = AddInterceptorOptions(invoke = fun(options: NavigateBackOptions) {
                pageInterceptor.hidePage()
            }
            )
            uni_addInterceptor("navigateBack", redirectToInterceptor)
        }
    }
}
open class userInfoType (
    open var id: Number? = null,
    open var name: String? = null,
    open var token: String? = null,
    open var shop: String? = null,
    open var no: String? = null,
    open var head: String? = null,
    open var position: UTSArray<positionInfo>? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return userInfoTypeReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class userInfoTypeReactiveObject : userInfoType, IUTSReactive<userInfoType> {
    override var __v_raw: userInfoType
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: userInfoType, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(id = __v_raw.id, name = __v_raw.name, token = __v_raw.token, shop = __v_raw.shop, no = __v_raw.no, head = __v_raw.head, position = __v_raw.position) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): userInfoTypeReactiveObject {
        return userInfoTypeReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var id: Number?
        get() {
            return _tRG(__v_raw, "id", __v_raw.id, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("id")) {
                return
            }
            val oldValue = __v_raw.id
            __v_raw.id = value
            _tRS(__v_raw, "id", oldValue, value)
        }
    override var name: String?
        get() {
            return _tRG(__v_raw, "name", __v_raw.name, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("name")) {
                return
            }
            val oldValue = __v_raw.name
            __v_raw.name = value
            _tRS(__v_raw, "name", oldValue, value)
        }
    override var token: String?
        get() {
            return _tRG(__v_raw, "token", __v_raw.token, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("token")) {
                return
            }
            val oldValue = __v_raw.token
            __v_raw.token = value
            _tRS(__v_raw, "token", oldValue, value)
        }
    override var shop: String?
        get() {
            return _tRG(__v_raw, "shop", __v_raw.shop, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("shop")) {
                return
            }
            val oldValue = __v_raw.shop
            __v_raw.shop = value
            _tRS(__v_raw, "shop", oldValue, value)
        }
    override var no: String?
        get() {
            return _tRG(__v_raw, "no", __v_raw.no, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("no")) {
                return
            }
            val oldValue = __v_raw.no
            __v_raw.no = value
            _tRS(__v_raw, "no", oldValue, value)
        }
    override var head: String?
        get() {
            return _tRG(__v_raw, "head", __v_raw.head, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("head")) {
                return
            }
            val oldValue = __v_raw.head
            __v_raw.head = value
            _tRS(__v_raw, "head", oldValue, value)
        }
    override var position: UTSArray<positionInfo>?
        get() {
            return _tRG(__v_raw, "position", __v_raw.position, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("position")) {
                return
            }
            val oldValue = __v_raw.position
            __v_raw.position = value
            _tRS(__v_raw, "position", oldValue, value)
        }
}
open class State (
    @JsonNotNull
    open var user: userInfoType,
    @JsonNotNull
    open var menuList: UTSArray<String>,
    @JsonNotNull
    open var menuPermission: UTSJSONObject,
    @JsonNotNull
    open var networkConnected: Boolean = false,
    open var networkType: String? = null,
    @JsonNotNull
    open var isAuthDevice: Boolean = false,
    open var socket: WebSocket? = null,
    @JsonNotNull
    open var payClientKey: String,
    open var payCodeObj: PayCode? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return StateReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class StateReactiveObject : State, IUTSReactive<State> {
    override var __v_raw: State
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: State, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(user = __v_raw.user, menuList = __v_raw.menuList, menuPermission = __v_raw.menuPermission, networkConnected = __v_raw.networkConnected, networkType = __v_raw.networkType, isAuthDevice = __v_raw.isAuthDevice, socket = __v_raw.socket, payClientKey = __v_raw.payClientKey, payCodeObj = __v_raw.payCodeObj) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): StateReactiveObject {
        return StateReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var user: userInfoType
        get() {
            return _tRG(__v_raw, "user", __v_raw.user, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("user")) {
                return
            }
            val oldValue = __v_raw.user
            __v_raw.user = value
            _tRS(__v_raw, "user", oldValue, value)
        }
    override var menuList: UTSArray<String>
        get() {
            return _tRG(__v_raw, "menuList", __v_raw.menuList, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("menuList")) {
                return
            }
            val oldValue = __v_raw.menuList
            __v_raw.menuList = value
            _tRS(__v_raw, "menuList", oldValue, value)
        }
    override var menuPermission: UTSJSONObject
        get() {
            return _tRG(__v_raw, "menuPermission", __v_raw.menuPermission, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("menuPermission")) {
                return
            }
            val oldValue = __v_raw.menuPermission
            __v_raw.menuPermission = value
            _tRS(__v_raw, "menuPermission", oldValue, value)
        }
    override var networkConnected: Boolean
        get() {
            return _tRG(__v_raw, "networkConnected", __v_raw.networkConnected, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("networkConnected")) {
                return
            }
            val oldValue = __v_raw.networkConnected
            __v_raw.networkConnected = value
            _tRS(__v_raw, "networkConnected", oldValue, value)
        }
    override var networkType: String?
        get() {
            return _tRG(__v_raw, "networkType", __v_raw.networkType, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("networkType")) {
                return
            }
            val oldValue = __v_raw.networkType
            __v_raw.networkType = value
            _tRS(__v_raw, "networkType", oldValue, value)
        }
    override var isAuthDevice: Boolean
        get() {
            return _tRG(__v_raw, "isAuthDevice", __v_raw.isAuthDevice, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("isAuthDevice")) {
                return
            }
            val oldValue = __v_raw.isAuthDevice
            __v_raw.isAuthDevice = value
            _tRS(__v_raw, "isAuthDevice", oldValue, value)
        }
    override var socket: WebSocket?
        get() {
            return _tRG(__v_raw, "socket", __v_raw.socket, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("socket")) {
                return
            }
            val oldValue = __v_raw.socket
            __v_raw.socket = value
            _tRS(__v_raw, "socket", oldValue, value)
        }
    override var payClientKey: String
        get() {
            return _tRG(__v_raw, "payClientKey", __v_raw.payClientKey, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("payClientKey")) {
                return
            }
            val oldValue = __v_raw.payClientKey
            __v_raw.payClientKey = value
            _tRS(__v_raw, "payClientKey", oldValue, value)
        }
    override var payCodeObj: PayCode?
        get() {
            return _tRG(__v_raw, "payCodeObj", __v_raw.payCodeObj, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("payCodeObj")) {
                return
            }
            val oldValue = __v_raw.payCodeObj
            __v_raw.payCodeObj = value
            _tRS(__v_raw, "payCodeObj", oldValue, value)
        }
}
val state = reactive<State>(State(user = userInfoType(), menuList = _uA(), menuPermission = _uO(), networkConnected = false, networkType = null, isAuthDevice = false, socket = null, payClientKey = "", payCodeObj = null))
val setUser = fun(user: userInfoType){
    console.log("用户信息载入")
    state.user = user
    pda.start()
}
val setAuthDevice = fun(auth: Boolean){
    state.isAuthDevice = auth
}
val setUserDepart = fun(shop: Number){
    state.user.shop = shop.toString()
}
open class PayCode {
    constructor(){
        var clentKey = state.payClientKey
        if (clentKey != "") {
            return
        }
        getKey()
        PayCode.payIndex = setInterval(fun(){
            getKey()
        }
        , 10800000)
    }
    private fun getKey(): UTSPromise<Unit> {
        return wrapUTSPromise(suspend {
                var res = await(request.callapi("data/getPayClientKey", _uO()))
                if (res.code == 0) {
                    state.payClientKey = (res.data as UTSJSONObject)["key"] as String
                }
        })
    }
    private fun pickNum(str: String): String {
        return str.replace(UTSRegExp("\\D", "g"), "")
    }
    public open fun createCode(): String {
        var clentKey = state.payClientKey
        var userId = state.user.id as Number
        console.log("userId", userId)
        val now = Date.now()
        val preNum = "5" + ((Math.floor(now / 1000) % 2) + 1)
        val date = Date()
        val day = date.getDate().toString(10).padStart(2, "0")
        val hour = date.getHours().toString(10).padStart(2, "0")
        val minute = date.getMinutes().toString(10).padStart(2, "0")
        val unixMinute = parseInt(day + hour + minute, 10)
        val randomNum = Math.floor(Math.random() * 9000) + 1000
        console.log("Number", userId, unixMinute, randomNum)
        val info = UTSNumber.from(userId) + UTSNumber.from(unixMinute) + UTSNumber.from(randomNum)
        var hash = sha256(info.toString(10) + clentKey)
        console.log("hash", hash, info, clentKey)
        var hashNum = this.pickNum(hash)
        val shortHashNum = hashNum.substring(0, 3)
        console.log("shortHashNum", shortHashNum)
        var hashNumBasic = parseInt(shortHashNum, 10).toString(2).replace(UTSRegExp("^0+", ""), "")
        hashNumBasic = hashNumBasic.padStart(10, "0")
        var userIdBasic = info.toString(2).replace(UTSRegExp("^0+", ""), "")
        userIdBasic = userIdBasic.padStart(34, "0")
        var randomNumBasic = randomNum.toString(2).replace(UTSRegExp("^0+", ""), "")
        randomNumBasic = randomNumBasic.padStart(14, "0")
        val codeBin = hashNumBasic + userIdBasic + randomNumBasic
        var code = binaryStringToDecimal(codeBin)
        console.log("code", code)
        if (code.length > 18 || code.length < 15) {
            return this.createCode()
        }
        code = code.padStart(18, "0")
        val result = preNum + code
        return result
    }
    companion object {
        var payIndex: Number = 0
    }
}
val getUser = fun(): userInfoType {
    return state.user
}
val setMenuList = fun(list: UTSArray<String>){
    state.menuList = list
    setMenuPermission()
}
val setMenuPermission = fun(){
    state.menuPermission = _uO("casher" to (state.menuList.indexOf("casher") > -1), "purchase" to (state.menuList.indexOf("purchase") > -1), "goodsruku" to (state.menuList.indexOf("goodsruku") > -1), "stocktask" to (state.menuList.indexOf("stocktask") > -1), "requiregoods" to (state.menuList.indexOf("requiregoods") > -1), "allocate" to (state.menuList.indexOf("allocate") > -1), "instorage" to (state.menuList.indexOf("instorage") > -1), "direct_payment" to (state.menuList.indexOf("direct_payment") > -1), "todayanalysis" to (state.menuList.indexOf("todayanalysis") > -1), "goodsquery" to (state.menuList.indexOf("goodsquery") > -1), "goodschuku" to (state.menuList.indexOf("goodschuku") > -1), "outstorage" to (state.menuList.indexOf("outstorage") > -1), "goodslist" to (state.menuList.indexOf("goodslist") > -1))
}
var emptyResponse: UTSJSONObject = _uO("code" to -100, "data" to _uO(), "response_id" to "" as String, "msg" to "" as String, "info" to _uO())
open class request {
    companion object {
        fun getheader(reassignedRequestid: String): UTSPromise<UTSJSONObject> {
            var requestid = reassignedRequestid
            return wrapUTSPromise(suspend w@{
                    var pages = getCurrentPages()
                    var page = ""
                    if (pages.length > 0) {
                        page = pages[pages.length - 1].route
                    }
                    val now = Date.now() + ""
                    if (requestid == "") {
                        requestid = common.RandStrUUID()
                    }
                    var header: UTSJSONObject = _uO("Content-Type" to "application/json", "version" to AppConfig.app_version(), "appid" to AppConfig.appid, "module" to AppConfig.module, "requestTime" to now, "platform" to AppConfig.wxatag, "page" to page, "apiver" to 1, "metainfo" to common.getMetaInfo(), "sign" to "", "requestid" to requestid)
                    var auth: String = common.getStorage("usertoken").toString()
                    if (auth != "") {
                        header["auth"] = auth
                        header["shop"] = state.user.shop
                    }
                    var netinfo = await(common.getNetworkType())
                    if (netinfo != null) {
                        header["network"] = JSON.stringify(_uO("type" to netinfo?.networkType))
                    }
                    return@w header
            })
        }
        fun callapiUser(path: String, reassignedParams: UTSJSONObject, host: String = "", requestid: String = ""): UTSPromise<responseType> {
            var params = reassignedParams
            return wrapUTSPromise(suspend w@{
                    var hostStr: String
                    if (host == "") {
                        hostStr = AppConfig.host
                    } else {
                        hostStr = host
                    }
                    var url = hostStr + path
                    console.log("请求地址", url)
                    var header = await(getheader(requestid))
                    params = params as UTSJSONObject
                    console.log("请求参数", params)
                    var sign = request.createSign(params, header.getString("requestTime") as String, header["requestid"] as String)
                    header["sign"] = sign as String
                    if (host == "" && AppConfig.isDebug == false) {
                        params = request.encryptData(params)
                    }
                    var res = await(UTSPromise(fun(resolve, reject){
                        uni_request<Any>(RequestOptions(url = url, data = JSON.stringify(params), method = "POST", header = header as UTSJSONObject, timeout = 30000, firstIpv4 = true, success = fun(res){
                            if (JSON.stringify(res).length < 1000) {}
                            if (res.statusCode == 500) {
                                common.toast("系统开小差了，请稍候重试[code:500]")
                                resolve(emptyResponse)
                                return
                            } else if (res.statusCode != 200) {
                                common.toast("系统开小差了，请稍候重试[code:" + res.statusCode + "]")
                                resolve(emptyResponse)
                                return
                            }
                            resolve(res.data as UTSJSONObject)
                        }
                        , fail = fun(err){
                            reject(err)
                        }
                        ))
                    }
                    )) as UTSJSONObject
                    res = request.decryptData(res)
                    console.log(res)
                    var code = res["code"] as Number
                    if (code == -401.1) {
                        res = emptyResponse as UTSJSONObject
                    }
                    var result: responseType = responseType(code = res["code"] as Number, data = res["data"] as Any, response_id = res["response_id"] as String?, msg = res["msg"] as String, info = res)
                    return@w result
            })
        }
        fun callapi(path: String, reassignedParams: UTSJSONObject, host: String = "", requestid: String = ""): UTSPromise<responseType> {
            var params = reassignedParams
            return wrapUTSPromise(suspend w@{
                    var nettype = await(common.getNetworkType())
                    if (nettype?.networkType == "none") {
                        common.toast("请检查网络连接")
                        return@w null
                    }
                    var hostStr: String
                    if (host == "") {
                        hostStr = AppConfig.host
                    } else {
                        hostStr = host
                    }
                    var url = hostStr + path
                    console.log("请求地址", url)
                    var header = await(getheader(requestid))
                    params = params as UTSJSONObject
                    var sign = request.createSign(params, header.getString("requestTime") as String, header["requestid"] as String)
                    header["sign"] = sign as String
                    if (host == "" && AppConfig.isDebug == false) {
                        header["Encryed"] = 1
                        params = request.encryptData(params)
                    }
                    console.log("请求参数", params)
                    var res = await(UTSPromise(fun(resolve, reject){
                        uni_request<Any>(RequestOptions(url = url, data = JSON.stringify(params), method = "POST", header = header as UTSJSONObject, timeout = 30000, firstIpv4 = true, success = fun(res){
                            if (res.statusCode == 500) {
                                common.toast("系统开小差了，请稍候重试[code:500]")
                                resolve(_uO("code" to -100))
                                return
                            } else if (res.statusCode != 200) {
                                common.toast("系统开小差了，请稍候重试[code:" + res.statusCode + "]")
                                resolve(_uO("code" to -100))
                                return
                            }
                            resolve(res.data as UTSJSONObject)
                        }
                        , fail = fun(err){
                            reject(err)
                        }
                        ))
                    }
                    )) as UTSJSONObject
                    res = request.decryptData(res)
                    console.log("响应", res)
                    var code = res["code"] as Number
                    if (code == -401.1) {
                        uni_redirectTo(RedirectToOptions(url = "/pages/index/login"))
                        res = _uO("code" to -100)
                    }
                    if ((res["code"] as Number) == -100) {
                        return@w null
                    }
                    var result: responseType = responseType(code = res["code"] as Number, data = res["data"] as Any, response_id = res["response_id"] as String?, msg = res["msg"] as String, info = res)
                    return@w result
            })
        }
        fun getUserInfo(toLogin: Boolean = true): UTSPromise<Boolean> {
            return wrapUTSPromise(suspend w@{
                    var res: responseType
                    if (toLogin) {
                        res = await(request.callapi("user/getuserinfo", _uO(), ""))
                    } else {
                        res = await(request.callapiUser("user/getuserinfo", _uO(), ""))
                    }
                    console.log("用户信息", res)
                    if (res == null) {
                        return@w false
                    }
                    if (res.code < 0) {
                        return@w false
                    }
                    var data = res.data as UTSJSONObject
                    var pos = _uA<positionInfo>()
                    if (data["role_depart"] != null) {
                        var arr = data["role_depart"] as UTSArray<UTSJSONObject>
                        run {
                            var i: Number = 0
                            while(i < arr.length){
                                var item = arr[i]
                                pos.push(positionInfo(position_id = item["position_id"], position_name = item["position_name"], department_id = item["department_id"], department_name = item["department_name"]))
                                i++
                            }
                        }
                    }
                    var user = userInfoType(id = data["id"] as Number, token = data["token"] as String, name = data["name"] as String, shop = data["shop"] as String, no = data["no"] as String, head = data["head"] as String, position = pos)
                    setUser(user)
                    common.setStorage("usertoken", data["token"] as Any)
                    return@w true
            })
        }
        fun createSign(params: UTSJSONObject, requestTime: String, requestid: String): String {
            var paramsStr = JSON.stringify(params)
            paramsStr = str2Md5(paramsStr + requestTime)
            return str2Md5(AppConfig.appid + requestid + paramsStr + AppConfig.appkey)
        }
        fun cosUpload(fileType: String, ext: String, reassignedFile: String, method: String, type: String): UTSPromise<Any> {
            var file = reassignedFile
            return wrapUTSPromise(suspend w@{
                    var res = await(UTSPromise(fun(resolve, reject){
                        file = file.replace("file://", "fccc//")
                        request.callapi("data/cosinit", _uO("files" to _uA(
                            _uO("file" to file, "ext" to ext, "type" to fileType, "thumb" to file)
                        ), "method" to method, "type" to type)).then(fun(res){
                            if (res.code < 0) {
                                common.toast(res.msg)
                                resolve(null)
                            }
                            console.log("数据", res.data)
                            var uploadData = res.data as UTSJSONObject
                            var config = uploadData["config"] as UTSJSONObject
                            var filesList = uploadData["uploadKey"] as UTSArray<UTSJSONObject>
                            var tmpSecretId = config["tmpSecretId"] as String
                            var tmpSecretKey = config["tmpSecretKey"] as String
                            var token = config["sessionToken"] as String
                            var region = config["region"] as String
                            var startTime = config["startTime"] as Number
                            var expiredTime = config["expiredTime"] as Number
                            var host = config["host"] as String
                            init(tmpSecretId, tmpSecretKey, token, host, region, startTime.toLong(), expiredTime.toLong(), true)
                            var f = (filesList as UTSArray<UTSJSONObject>)[0]
                            var uf = f["file"] as String
                            var key = f["key"] as String
                            var bucket = config["bucket"] as String
                            cosUploadFile(bucket, key, uf, fun(num: Float) {
                                console.log("进度", num)
                            }
                            , fun(res: String?) {
                                console.log("上传成功", res)
                                resolve(key)
                            }
                            , fun(res: String?) {
                                console.log("上传失败", res)
                                resolve(null)
                            }
                            )
                        }
                        )
                    }
                    ))
                    return@w res
            })
        }
        private fun encryptData(reassignedParams: UTSJSONObject): UTSJSONObject {
            var params = reassignedParams
            var jsonStr = JSON.stringify(params)
            var AesKey = common.randStr(32)
            jsonStr = aes256CbcEncrypt(jsonStr, AesKey, AesKey.substring(0, 16))
            var publicKey = common.readFile("/static/app/encry.enc")
            if (publicKey == null) {
                return params
            }
            publicKey = decryptEncryptedPublicKey(publicKey, AppConfig.appPublicPwd)
            AesKey = encryptByPublicKey(AesKey, publicKey)
            params = _uO("data" to jsonStr, "encryKey" to AesKey)
            return params
        }
        private fun decryptData(res: UTSJSONObject): UTSJSONObject {
            if (res["isEncrypted"] == null) {
                return res
            }
            var isEncrypted = res["isEncrypted"] as Boolean
            var encryptKey = res["encryptKey"] as String
            var data = res["data"] as String
            if (isEncrypted == false) {
                return res
            }
            var publicKey = common.readFile("/static/app/encry.enc")
            if (publicKey == null) {
                return res
            }
            publicKey = decryptEncryptedPublicKey(publicKey, AppConfig.appPublicPwd)
            encryptKey = decryptByPublicKey(encryptKey, publicKey)
            data = aes256CbcDecrypt(data, encryptKey, encryptKey.substring(0, 16))
            var json = JSON.parseObject(data)
            if (json == null) {
                return res
            }
            return json as UTSJSONObject
        }
    }
}
open class WebSocket {
    open var ws: SocketTask? = null
    open var heartbeatInterval: Number = 30000
    open var heartbeatTimer: Number = 0
    open var reconnectDelay: Number = 3000
    open var reconnectTimer: Number = 0
    open var maxReconnectAttempts: Number = 10
    open var reconnectAttempts: Number = 0
    private var closedBySelf: Boolean = false
    private var isConnecting: Boolean = false
    constructor(){
        this.init()
    }
    open fun init(): UTSPromise<Unit> {
        return wrapUTSPromise(suspend w@{
                if (this.isConnecting) {
                    return@w
                }
                this.isConnecting = true
                if (this.ws != null) {
                    this.teardownSocket()
                }
                var res = await(request.callapi("user/getSocketToken", _uO()))
                if (res == null) {
                    this.isConnecting = false
                    return@w
                }
                if (res.code < 0) {
                    common.toast(res.msg as String)
                    this.isConnecting = false
                    return@w
                }
                val token = (res.data as UTSJSONObject)["token"] as String
                try {
                    this.closedBySelf = false
                    this.ws = uni_connectSocket(ConnectSocketOptions(url = AppConfig.socketHost + "?token=" + token, success = fun(_){
                        console.log("链接启动成功Websocket")
                        setTimeout(fun(){
                            if (WebSocket.isConnected == false && this.closedBySelf == false) {
                                this.reconnect()
                            }
                        }
                        , 3000)
                    }
                    , fail = fun(err: Any){
                        console.log("WebSocket连接失败", err)
                        WebSocket.isConnected = false
                        this.reconnect()
                    }
                    ))
                    this.bindEvents()
                }
                 catch (err: Throwable) {
                    console.error("WebSocket 初始化异常", err)
                    this.reconnect()
                }
                 finally {
                    this.isConnecting = false
                }
        })
    }
    open fun bindEvents() {
        if (this.ws == null) {
            return
        }
        val socketTask = this.ws!!
        socketTask.onOpen(fun(_result){
            WebSocket.isConnected = true
            this.reconnectAttempts = 0
            console.log("WebSocket连接已打开")
            this.startHeartbeat()
        }
        )
        socketTask.onClose(fun(closeRes: Any){
            WebSocket.isConnected = false
            this.stopHeartbeat()
            this.ws = null
            console.log("WebSocket连接已关闭", closeRes)
            if (this.closedBySelf) {
                return
            }
            this.reconnect()
        }
        )
        socketTask.onError(fun(err: GeneralCallbackResult){
            WebSocket.isConnected = false
            console.log("WebSocket连接发生错误", err)
            if (this.closedBySelf) {
                return
            }
            this.reconnect()
        }
        )
        socketTask.onMessage(fun(message: OnSocketMessageCallbackResult){
            val data = message.data
            if (data == null) {
                return
            }
            var msgText = data as String
            msgText = this.unHideStr(msgText)
            console.log("收到WebSocket消息", msgText)
            if (msgText == "heartbeat" || msgText == "pong") {
                return
            }
            var messageJson = this.parseJson(msgText as String)
            if (messageJson == null) {
                val maybePlain = this.unHideStr(msgText)
                messageJson = this.parseJson(maybePlain)
            }
            if (messageJson == null) {
                console.log("消息不是合法JSON", msgText)
                return
            }
            var jsonObj = messageJson as UTSJSONObject
            var type = jsonObj["type"] as String
            var key = jsonObj["key"] as String
            val aesKey = str2Md5(key + AppConfig.appkey)
            var msgData = aes256CbcDecrypt(jsonObj["data"] as String, aesKey, aesKey.substring(0, 16))
            console.log(AppConfig.appid + str2Md5(key) + jsonObj["timestamp"] + AppConfig.appkey)
            var signTmp = str2Md5(AppConfig.appid + str2Md5(key) + jsonObj["timestamp"] + AppConfig.appkey)
            if (signTmp != (jsonObj["sign"] as String)) {
                console.error("消息签名验证失败")
                return
            }
            console.log("解密后消息内容", type, msgData)
            this.handleMsg(type, msgData as UTSJSONObject)
            uni__emit("socketMsg", type, msgData as UTSJSONObject)
        }
        )
    }
    open fun handleMsg(type: String, data: UTSJSONObject) {
        console.log("消息处理", data)
        type
    }
    open fun startHeartbeat() {
        if (this.heartbeatTimer > 0) {
            clearInterval(this.heartbeatTimer)
        }
        this.heartbeatTimer = setInterval(fun(){
            if (WebSocket.isConnected) {
                this.send("ping")
            }
        }
        , this.heartbeatInterval)
    }
    open fun stopHeartbeat() {
        if (this.heartbeatTimer > 0) {
            clearInterval(this.heartbeatTimer)
            this.heartbeatTimer = 0
        }
    }
    open fun reconnect() {
        if (this.closedBySelf) {
            return
        }
        if (WebSocket.isConnected) {
            return
        }
        if (this.reconnectAttempts >= this.maxReconnectAttempts) {
            console.log("已达到最大重连次数，停止重连")
            return
        }
        if (this.reconnectTimer > 0) {
            return
        }
        console.log("准备重连", this.reconnectAttempts + 1, "/", this.maxReconnectAttempts)
        this.reconnectTimer = setTimeout(fun(){
            this.reconnectAttempts++
            this.reconnectTimer = 0
            this.init()
        }
        , this.reconnectDelay)
    }
    open fun hideStr(str: String): String {
        val xorKey = AppConfig.socketKey
        if (xorKey.length == 0) {
            return str
        }
        var result = ""
        run {
            var i: Number = 0
            while(i < str.length){
                val keyCode = xorKey.charCodeAt(i % xorKey.length) as Number
                result += String.fromCharCode((str.charCodeAt(i) as Number) xor keyCode)
                i++
            }
        }
        return result
    }
    open fun unHideStr(str: String): String {
        val xorKey = AppConfig.socketKey
        if (xorKey.length == 0) {
            return str
        }
        var result = ""
        run {
            var i: Number = 0
            while(i < str.length){
                val keyCode = xorKey.charCodeAt(i % xorKey.length) as Number
                result += String.fromCharCode((str.charCodeAt(i) as Number) xor keyCode)
                i++
            }
        }
        return result
    }
    open fun send(data: Any) {
        if (this.ws == null || WebSocket.isConnected == false) {
            console.warn("WebSocket未连接，发送失败")
            return
        }
        try {
            var text = ""
            if (UTSAndroid.`typeof`(data) == "string") {
                text = data as String
            } else {
                text = JSON.stringify(data)
            }
            console.log("发送WebSocket消息", text)
            text = this.hideStr(text)
            this.ws?.send(SendSocketMessageOptions(data = text, fail = fun(err: Any){
                console.log("WebSocket发送失败", err)
            }
            ))
        }
         catch (err: Throwable) {
            console.error("发送消息失败", err)
        }
    }
    open fun sendMsg(type: String, subtype: String, data: UTSJSONObject) {
        data["type"] = subtype
        val key = common.randStr(32)
        val now = Date.now()
        val dataJson = JSON.stringify(data)
        val sign = str2Md5(AppConfig.appid + str2Md5(dataJson + key) + now + AppConfig.appkey)
        val aesKey = str2Md5(key + AppConfig.appkey)
        val dataStr = aes256CbcEncrypt(dataJson, aesKey, aesKey.substring(0, 16))
        val msgObj: UTSJSONObject = _uO("appid" to AppConfig.appid, "type" to type, "key" to key, "timestamp" to now, "sign" to sign, "data" to dataStr)
        this.send(msgObj)
    }
    open fun close() {
        this.closedBySelf = true
        WebSocket.isConnected = false
        this.stopHeartbeat()
        if (this.reconnectTimer > 0) {
            clearTimeout(this.reconnectTimer)
            this.reconnectTimer = 0
        }
        this.teardownSocket()
    }
    private fun teardownSocket() {
        if (this.ws == null) {
            return
        }
        try {
            this.ws?.close(CloseSocketOptions(code = 1000))
        }
         catch (err: Throwable) {
            console.log("关闭socket异常", err)
        }
        this.ws = null
    }
    private fun parseJson(text: String): UTSJSONObject? {
        try {
            return JSON.parseObject(text) as UTSJSONObject
        }
         catch (e: Throwable) {
            return null
        }
    }
    companion object {
        var isConnected: Boolean = false
        fun startWebsocket(): WebSocket? {
            if (!AppConfig.openSocket) {
                return null
            }
            if (WebSocket.isConnected) {
                console.error("WebSocket is already connected or connecting.")
                return state.socket
            }
            console.log("开始链接Websocket")
            var websocket = WebSocket()
            return websocket
        }
        fun stopWebsocket() {
            console.log("开始断开Websocket")
            if (state.socket != null) {
                state.socket!!.closedBySelf = true
                state.socket!!.close()
            }
        }
    }
}
var firstBackTime: Number = 0
open class GenGlobalData {
    open var showModal = false
}
open class GenApp : BaseApp {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onLaunch(fun(_: OnLaunchOptions) {}, __ins)
        onLaunch(fun(_: OnLaunchOptions) {
            uni_loadFontFace(LoadFontFaceOptions(global = true, family = "remixicon", source = "url('/static/tmui4xLibs/static/remixicon.ttf')", success = fun(_) {
                uni_setStorageSync("loadedFontBytmx", "true")
                console.log("global loadFontFace uni.ttf success===")
            }
            , fail = fun(error) {
                uni_setStorageSync("loadedFontBytmx", "")
                console.warn("global loadFontFace uni.ttf fail--", error.errMsg)
            }
            ))
            var scan = scanCode()
            var kux = scan.init("android.intent.ACTION_SCAN_OUTPUT")
            if (kux == Object()) {
                return
            }
            scan.regAction(scanReceiverOptions(kuxBroadcastReceiver = kux as KuxBroadcastReceiver, name = "barcode", success = fun(data) {
                console.log("收到广播", data, UTSAndroid.`typeof`(data))
                if (UTSAndroid.`typeof`(data) == "object") {
                    if (data.length < 1) {
                        return
                    } else {
                        for(code in resolveUTSKeyIterator(data)){
                            console.log("广播发送", code)
                            uni__emit("scanCode", code)
                        }
                    }
                } else {
                    console.log("广播发送", data)
                    uni__emit("scanCode", data)
                }
            }
            ))
            pageInterceptor.setInterceptor()
        }
        , __ins)
        onAppShow(fun(_: OnShowOptions) {
            common.getNetworkType().then(fun(res: GetNetworkTypeSuccess?) {
                state.networkType = res?.networkType
            }
            )
            console.log("App Show")
        }
        , __ins)
        onAppHide(fun() {
            console.log("App Hide")
            pageInterceptor.hidePage(true)
        }
        , __ins)
        onLastPageBackPress(fun() {
            console.log("App LastPageBackPress")
            if (firstBackTime == 0) {
                uni_showToast(ShowToastOptions(title = "再按一次退出应用", position = "bottom"))
                firstBackTime = Date.now()
                setTimeout(fun(){
                    firstBackTime = 0
                }, 2000)
            } else if (Date.now() - firstBackTime < 2000) {
                firstBackTime = Date.now()
                pageInterceptor.hidePage(true)
                uni_exit(null)
            }
        }
        , __ins)
        onExit(fun() {
            console.log("App Exit")
        }
        , __ins)
    }
    open val globalData: GenGlobalData
        get() {
            return getApp().globalData
        }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("weight-full" to _pS(_uM("width" to "100%")), "width-full" to _pS(_uM("width" to "100%")), "full" to _pS(_uM("height" to "100%")), "padding-buttom" to _pS(_uM("paddingBottom" to 10)), "radius-50" to _pS(_uM("borderTopLeftRadius" to "50%", "borderTopRightRadius" to "50%", "borderBottomRightRadius" to "50%", "borderBottomLeftRadius" to "50%")), "top-status-bar" to _pS(_uM("top" to CSS_VAR_STATUS_BAR_HEIGHT)), "padding-stauts-bar" to _pS(_uM("paddingTop" to CSS_VAR_STATUS_BAR_HEIGHT)), "margin-status-bar" to _pS(_uM("marginTop" to CSS_VAR_STATUS_BAR_HEIGHT)), "height-status-bar" to _pS(_uM("height" to CSS_VAR_STATUS_BAR_HEIGHT)), "safe-bottom" to _pS(_uM("bottom" to "var(--uni-safe-area-inset-bottom)")), "height-safe-bottom" to _pS(_uM("height" to "var(--uni-safe-area-inset-bottom)")), "margin-bottom" to _pS(_uM("marginBottom" to "var(--uni-safe-area-inset-bottom)")), "padding-safe-bottom" to _pS(_uM("paddingBottom" to "var(--uni-safe-area-inset-bottom)")), "safe-bottom-view" to _pS(_uM("width" to "750rpx", "left" to 0, "height" to "var(--uni-safe-area-inset-bottom)", "position" to "fixed", "bottom" to 0)), "position-relative" to _pS(_uM("position" to "relative")), "position-absolute" to _pS(_uM("position" to "absolute")), "position-fixed" to _pS(_uM("position" to "fixed")), "display-flex" to _pS(_uM("display" to "flex", "flexDirection" to "row")), "space-between" to _pS(_uM("justifyContent" to "space-between", "display" to "flex", "flexDirection" to "row")), "margin-center" to _pS(_uM("marginLeft" to "auto", "marginRight" to "auto")), "background-white" to _pS(_uM("backgroundColor" to "#FFFFFF")), "background-page" to _pS(_uM("backgroundColor" to "#f5f5f5")), "color-white" to _pS(_uM("color" to "#FFFFFF")), "color-main" to _pS(_uM("color" to "#1678fd")), "color-red" to _pS(_uM("color" to "#ff0000")), "color-black" to _pS(_uM("color" to "#000000")), "color-green" to _pS(_uM("color" to "#6ae80a")), "color-gray" to _pS(_uM("color" to "#9dabac")), "background-main" to _pS(_uM("backgroundColor" to "#1678fd")), "left-border" to _pS(_uM("borderLeftWidth" to 1, "borderLeftStyle" to "solid", "borderLeftColor" to "#000000")), "align-center" to _pS(_uM("textAlign" to "center")), "align-right" to _pS(_uM("textAlign" to "right")), "list-items" to _pS(_uM("flexWrap" to "wrap", "flexDirection" to "row", "flexShrink" to 1, "flexGrow" to 0, "flexBasis" to "auto")), "litem" to _uM(".list-items " to _uM("flexGrow" to 0, "flexShrink" to 0)), "font-bold" to _pS(_uM("fontWeight" to "bold")), "casherbtn" to _pS(_uM("borderTopWidth" to 0, "borderRightWidth" to 0, "borderBottomWidth" to 0, "borderLeftWidth" to 0, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#000000", "borderRightColor" to "#000000", "borderBottomColor" to "#000000", "borderLeftColor" to "#000000", "color" to "#ffffff", "backgroundImage" to "none", "backgroundColor" to "#2A82E4")), "overline" to _pS(_uM("whiteSpace" to "nowrap", "overflow" to "hidden", "textOverflow" to "ellipsis")), "overline2" to _pS(_uM("textOverflow" to "ellipsis", "lines" to 2)), "cardborderbottom" to _pS(_uM("borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#E8E8E8")), "cardborder" to _pS(_uM("borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#E8E8E8", "borderTopWidth" to 1, "borderTopStyle" to "solid", "borderTopColor" to "#E8E8E8")), "fui-filter__icon" to _pS(_uM("transitionProperty" to "transform", "transitionDuration" to "0.15s", "transitionTimingFunction" to "linear", "transform" to "rotate(0deg)")), "fui-icon__ani" to _pS(_uM("transform" to "rotate(180deg)")), "font" to _pS(_uM("fontFamily" to "syht")), "text" to _pS(_uM("fontFamily" to "syht")), "totalnum" to _uM(".basiclist " to _uM("fontSize" to 13, "color" to "#B3B3B3", "paddingTop" to 4, "paddingRight" to "8rpx", "paddingBottom" to 4)), "times" to _uM(".basiclist " to _uM("fontSize" to 12, "color" to "#A6A6A6", "marginTop" to 7)), "orderitem" to _uM(".basiclist " to _uM("borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#D4D4D4")), "check" to _uM(".basiclist .orderitem " to _uM("paddingLeft" to "10rpx", "paddingTop" to 25)), "success" to _uM(".statuscontent " to _uM("color" to "#00D647")), "warning" to _uM(".statuscontent " to _uM("color" to "#E33C64")), "xbtn-normal" to _pS(_uM("backgroundColor" to "#1678fd", "color" to "#FFFFFF", "paddingTop" to 0, "paddingRight" to 0, "paddingBottom" to 0, "paddingLeft" to 0, "marginTop" to 0, "marginRight" to 0, "marginBottom" to 0, "marginLeft" to 0, "borderTopWidth" to 0, "borderRightWidth" to 0, "borderBottomWidth" to 0, "borderLeftWidth" to 0, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#000000", "borderRightColor" to "#000000", "borderBottomColor" to "#000000", "borderLeftColor" to "#000000", "borderTopLeftRadius" to 3, "borderTopRightRadius" to 3, "borderBottomRightRadius" to 3, "borderBottomLeftRadius" to 3)), "xbtn-promise" to _pS(_uM("backgroundColor" to "#FFFFFF", "color" to "#1678fd", "paddingTop" to 0, "paddingRight" to 0, "paddingBottom" to 0, "paddingLeft" to 0, "marginTop" to 0, "marginRight" to 0, "marginBottom" to 0, "marginLeft" to 0, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#1678fd", "borderRightColor" to "#1678fd", "borderBottomColor" to "#1678fd", "borderLeftColor" to "#1678fd", "borderTopLeftRadius" to 3, "borderTopRightRadius" to 3, "borderBottomRightRadius" to 3, "borderBottomLeftRadius" to 3)), "@TRANSITION" to _uM("fui-filter__icon" to _uM("property" to "transform", "duration" to "0.15s", "timingFunction" to "linear")))
            }
    }
}
val GenAppClass = CreateVueAppComponent(GenApp::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "app", name = "", inheritAttrs = true, inject = Map(), props = Map(), propsNeedCastKeys = _uA(), emits = Map(), components = Map(), styles = GenApp.styles)
}
, fun(instance): GenApp {
    return GenApp(instance)
}
)
typealias StringOrNull = String?
open class DateTimeNames (
    @JsonNotNull
    open var long: UTSArray<String>,
    @JsonNotNull
    open var short: UTSArray<String>,
    @JsonNotNull
    open var narrow: UTSArray<String>,
) : UTSObject()
typealias NumberOrNull = Number?
typealias StringOrNumberOrNull = Any?
typealias DateOrNumberOrString = Any
typealias UTSJSONObjectOrNull = UTSJSONObject?
typealias UTSJSONObjectOrArray = Any
typealias AnyOrNull = Any?
typealias StringOrMessageFunction = Any
typealias StringOrVoid = Any
typealias GetAnyType = (obj: AnyOrNull) -> AnyOrNull
typealias I18nOptionsOrNull = I18nOptions?
typealias DateTimeFormatOrNull = DateTimeFormat?
typealias GetAnyTypeOrNull = GetAnyType?
typealias WarnHandler = (msg: StringOrNumberOrNull, err: UTSError?) -> Unit
typealias BasePluralRule = (choice: Number, choicesLength: Number) -> Number
typealias PluralRule = (choice: Number, choicesLength: Number, orgRule: BasePluralRule?) -> Number
open class MessageContext (
    @JsonNotNull
    open var list: UTSArray<Any>,
    @JsonNotNull
    open var named: UTSJSONObject,
    @JsonNotNull
    open var pluralIndex: Number,
    open var pluralRule: PluralRule? = null,
    open var orgPluralRule: BasePluralRule? = null,
    open var modifier: (str: String) -> String,
    @JsonNotNull
    open var message: StringOrMessageFunction,
    @JsonNotNull
    open var type: String,
    open var interpolate: (`val`: Any) -> String,
    open var normalize: (values: UTSArray<Any>) -> UTSArray<Any>,
    @JsonNotNull
    open var values: UTSArray<Any>,
) : UTSObject()
typealias MessageFunction = (ctx: MessageContext) -> String
open class NumberFormat (
    open var style: String? = null,
    open var currency: String? = null,
    open var local: String? = null,
    open var currencyDisplay: String? = null,
    open var useGrouping: Boolean? = null,
    open var minimumIntegerDigits: Number? = null,
    open var minimumFractionDigits: Number? = null,
    open var maximumFractionDigits: Number? = null,
    open var minimumSignificantDigits: Number? = null,
    open var maximumSignificantDigits: Number? = null,
) : UTSObject()
open class NumberFormatOpts (
    @JsonNotNull
    open var style: String,
    @JsonNotNull
    open var local: String,
    @JsonNotNull
    open var currency: String,
    @JsonNotNull
    open var currencyDisplay: String,
    @JsonNotNull
    open var useGrouping: Boolean = false,
    @JsonNotNull
    open var minimumIntegerDigits: Number,
    open var minimumFractionDigits: Number? = null,
    open var maximumFractionDigits: Number? = null,
    open var minimumSignificantDigits: Number? = null,
    open var maximumSignificantDigits: Number? = null,
) : UTSObject()
typealias NumberFormats = Map<String, Map<String, NumberFormat>>
open class DateTimeFormat (
    open var localeMatcher: String? = null,
    open var local: String? = null,
    open var calendar: String? = null,
    open var numberingSystem: String? = null,
    open var timeZone: String? = null,
    open var hour12: Boolean? = null,
    open var hourCycle: String? = null,
    open var formatMatcher: String? = null,
    open var dateSeparator: String? = null,
    open var weekday: String? = null,
    open var era: String? = null,
    open var year: String? = null,
    open var month: String? = null,
    open var day: String? = null,
    open var dayPeriod: String? = null,
    open var hour: String? = null,
    open var minute: String? = null,
    open var second: String? = null,
    open var fractionalSecondDigits: Number? = null,
    open var timeZoneName: String? = null,
    open var dateStyle: String? = null,
    open var timeStyle: String? = null,
) : UTSObject()
open class DateTimeFormatReal (
    @JsonNotNull
    open var localeMatcher: String,
    @JsonNotNull
    open var local: String,
    @JsonNotNull
    open var calendar: String,
    @JsonNotNull
    open var numberingSystem: String,
    @JsonNotNull
    open var timeZone: String,
    @JsonNotNull
    open var hour12: Boolean = false,
    @JsonNotNull
    open var hourCycle: String,
    @JsonNotNull
    open var formatMatcher: String,
    @JsonNotNull
    open var dateSeparator: String,
    @JsonNotNull
    open var weekday: String,
    @JsonNotNull
    open var era: String,
    @JsonNotNull
    open var year: String,
    @JsonNotNull
    open var month: String,
    @JsonNotNull
    open var day: String,
    @JsonNotNull
    open var dayPeriod: String,
    @JsonNotNull
    open var hour: String,
    @JsonNotNull
    open var minute: String,
    @JsonNotNull
    open var second: String,
    @JsonNotNull
    open var fractionalSecondDigits: Number,
    @JsonNotNull
    open var timeZoneName: String,
    @JsonNotNull
    open var dateStyle: String,
    @JsonNotNull
    open var timeStyle: String,
) : UTSObject()
typealias DateTimeFormats = Map<String, Map<String, DateTimeFormat>>
open class I18nOptions (
    open var locale: String? = null,
    open var fallbackLocale: String? = null,
    open var messages: UTSJSONObject? = null,
    open var datetimeFormats: DateTimeFormats? = null,
    open var numberFormats: NumberFormats? = null,
    open var modifiers: Map<String, MessageFunction>? = null,
    open var pluralRules: Map<String, PluralRule>? = null,
    open var missing: ((locale: String, key: String, instance: Any?, type: String?) -> StringOrVoid)? = null,
    open var missingWarn: Boolean? = null,
    open var fallbackWarn: Boolean? = null,
    open var fallbackRoot: Boolean? = null,
    open var fallbackFormat: Boolean? = null,
    open var unresolving: Boolean? = null,
    open var postTranslation: ((str: String, key: String) -> String)? = null,
    open var warnHtmlMessage: Boolean? = null,
    open var escapeParameter: Boolean? = null,
    open var inheritLocale: Boolean? = null,
    open var warnHandler: WarnHandler? = null,
    open var pluralRule: PluralRule? = null,
    open var globalInjection: Boolean? = null,
    open var allowComposition: Boolean? = null,
    open var legacy: Boolean? = null,
) : UTSObject()
open class I18nOptionsReally (
    @JsonNotNull
    open var locale: String,
    @JsonNotNull
    open var fallbackLocale: String,
    @JsonNotNull
    open var messages: UTSJSONObject,
    @JsonNotNull
    open var datetimeFormats: DateTimeFormats,
    @JsonNotNull
    open var numberFormats: NumberFormats,
    @JsonNotNull
    open var modifiers: Map<String, MessageFunction>,
    @JsonNotNull
    open var pluralRules: Map<String, PluralRule>,
    open var missing: ((locale: String, key: String, instance: Any?, type: String?) -> StringOrVoid)? = null,
    @JsonNotNull
    open var missingWarn: Boolean = false,
    @JsonNotNull
    open var fallbackWarn: Boolean = false,
    @JsonNotNull
    open var fallbackRoot: Boolean = false,
    @JsonNotNull
    open var fallbackFormat: Boolean = false,
    @JsonNotNull
    open var unresolving: Boolean = false,
    open var postTranslation: ((str: String, key: String) -> String)? = null,
    @JsonNotNull
    open var warnHtmlMessage: Boolean = false,
    @JsonNotNull
    open var escapeParameter: Boolean = false,
    @JsonNotNull
    open var inheritLocale: Boolean = false,
    @JsonNotNull
    open var warnHandler: WarnHandler,
    @JsonNotNull
    open var pluralRule: PluralRule,
    @JsonNotNull
    open var globalInjection: Boolean = false,
    @JsonNotNull
    open var allowComposition: Boolean = false,
    @JsonNotNull
    open var legacy: Boolean = false,
) : UTSObject()
interface Tmui4xI18nTml {
    var ops: I18nOptionsReally
    fun setLocale(local: String)
    fun getLocale(): String
    fun getFallbackLocale(): String
    fun setFallbackLocale(local: String)
    fun setOptions(args: I18nOptions?)
    fun t(key: String, vararg argsopts: Any): String
    fun n(`val`: Number, formatName: String?, opts: NumberFormat?): String
    fun d(`val`: DateOrNumberOrString, formatName: String?, opts: DateTimeFormat?): String
    fun mergeLocaleMessage(local: String, newMessage: UTSJSONObject)
    fun te(key: String, locale: String?): Boolean
    fun rt(timeValues: Any?, units: String?, locale: String?): String
    fun availableLocales(): UTSArray<String>
}
open class BestTimeTYpe (
    @JsonNotNull
    open var unit: String,
    @JsonNotNull
    open var value: Number,
) : UTSObject()
open class timeUnitsTYpe (
    @JsonNotNull
    open var unit: String,
    @JsonNotNull
    open var ms: Number,
    @JsonNotNull
    open var threshold: Number,
) : UTSObject()
open class xI18nsReactiveType (
    @JsonNotNull
    open var local: String,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return xI18nsReactiveTypeReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class xI18nsReactiveTypeReactiveObject : xI18nsReactiveType, IUTSReactive<xI18nsReactiveType> {
    override var __v_raw: xI18nsReactiveType
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: xI18nsReactiveType, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(local = __v_raw.local) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): xI18nsReactiveTypeReactiveObject {
        return xI18nsReactiveTypeReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var local: String
        get() {
            return _tRG(__v_raw, "local", __v_raw.local, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("local")) {
                return
            }
            val oldValue = __v_raw.local
            __v_raw.local = value
            _tRS(__v_raw, "local", oldValue, value)
        }
}
val xI18nsReactive = reactive(xI18nsReactiveType(local = "zh-Hans"))
fun mergeI18nOpts(args: I18nOptions? = null): I18nOptionsReally {
    var localLang = uni_getStorageSync("language")
    val currentLan = if (localLang != null && localLang != "" && UTSAndroid.`typeof`(localLang) == "string") {
        (localLang!! as String)
    } else {
        "zh-Hans"
    }
    val defaultOptions = I18nOptionsReally(locale = currentLan, fallbackLocale = "en", messages = _uO(), datetimeFormats = Map(), numberFormats = Map(), modifiers = Map(), pluralRules = Map(), missing = null, missingWarn = true, fallbackWarn = true, fallbackRoot = true, fallbackFormat = false, unresolving = true, postTranslation = null, warnHtmlMessage = true, escapeParameter = true, inheritLocale = true, warnHandler = fun(v, e){
        console.warn("[tmui4x]:" + v, if (e == null) {
            ""
        } else {
            e!!
        }
        )
    }
    , pluralRule = fun(choice: Number, choicesLength: Number, orgRule: BasePluralRule?): Number {
        if (orgRule != null) {
            return orgRule(choice, choicesLength)
        }
        if (choicesLength <= 1) {
            return 0
        }
        return choice
    }
    , globalInjection = true, allowComposition = true, legacy = true)
    if (args == null) {
        return defaultOptions
    }
    return I18nOptionsReally(locale = args.locale ?: defaultOptions.locale, fallbackLocale = args.fallbackLocale ?: defaultOptions.fallbackLocale, messages = args.messages ?: defaultOptions.messages, datetimeFormats = args.datetimeFormats ?: defaultOptions.datetimeFormats, numberFormats = args.numberFormats ?: defaultOptions.numberFormats, modifiers = args.modifiers ?: defaultOptions.modifiers, pluralRules = args.pluralRules ?: defaultOptions.pluralRules, missing = args.missing ?: defaultOptions.missing, missingWarn = args.missingWarn ?: defaultOptions.missingWarn, fallbackWarn = args.fallbackWarn ?: defaultOptions.fallbackWarn, fallbackRoot = args.fallbackRoot ?: defaultOptions.fallbackRoot, fallbackFormat = args.fallbackFormat ?: defaultOptions.fallbackFormat, unresolving = args.unresolving ?: defaultOptions.unresolving, postTranslation = args.postTranslation ?: defaultOptions.postTranslation, warnHtmlMessage = args.warnHtmlMessage ?: defaultOptions.warnHtmlMessage, escapeParameter = args.escapeParameter ?: defaultOptions.escapeParameter, inheritLocale = args.inheritLocale ?: defaultOptions.inheritLocale, warnHandler = args.warnHandler ?: defaultOptions.warnHandler, pluralRule = args.pluralRule ?: defaultOptions.pluralRule, globalInjection = args.globalInjection ?: defaultOptions.globalInjection, allowComposition = args.allowComposition ?: defaultOptions.allowComposition, legacy = args.legacy ?: defaultOptions.legacy)
}
open class Tmui4xI18n : Tmui4xI18nTml {
    override lateinit var ops: I18nOptionsReally
    constructor(args: I18nOptions?){
        this.ops = mergeI18nOpts(args)
    }
    override fun setLocale(local: String) {
        uni_setStorageSync("language", local)
        this.ops.locale = local
        xI18nsReactive.local = local
    }
    override fun getLocale(): String {
        return this.ops.locale
    }
    override fun getFallbackLocale(): String {
        return this.ops.fallbackLocale
    }
    override fun setFallbackLocale(local: String) {
        this.ops.fallbackLocale = local
    }
    override fun setOptions(args: I18nOptions?) {
        this.ops = mergeI18nOpts(args)
    }
    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun t(key: String, vararg spreadArgsopts: Any): String {
        var argsopts = UTSArray(*spreadArgsopts)
        var repeatCount: NumberOrNull = null
        var values = UTSJSONObjectOrArray()
        var locale: String = xI18nsReactive.local
        if (argsopts.length > 0) {
            var args: AnyOrNull = argsopts[0]
            var opts: AnyOrNull = null
            if (argsopts.length > 1) {
                opts = argsopts[1]
            }
            if (args != null && opts == null) {
                if (UTSAndroid.`typeof`(args) == "number") {
                    val numArgs: Number = args as Number
                    values = _uO("count" to numArgs, "n" to numArgs)
                    repeatCount = numArgs
                } else if (UTSAndroid.`typeof`(args) == "string") {
                    val strArgs: String = args as String
                    locale = strArgs
                } else if ((args is UTSJSONObject || UTSAndroid.`typeof`(args) == "object") && !UTSArray.isArray(args)) {
                    val objArgs: UTSJSONObject = args as UTSJSONObject
                    values = objArgs
                } else if (UTSArray.isArray(args)) {
                    val arrArgs: UTSArray<Any> = args as UTSArray<Any>
                    values = arrArgs
                }
            } else if (UTSAndroid.`typeof`(args) == "number" && opts is UTSJSONObject) {
                val objOpts: UTSJSONObject = opts as UTSJSONObject
                values = objOpts
                val numArgs: Number = args as Number
                repeatCount = numArgs
            }
        }
        var message: StringOrNull = this.getMessage(key, locale)
        if (message == null && locale != this.ops.fallbackLocale) {
            message = this.getMessage(key, this.ops.fallbackLocale)
            if (this.ops.fallbackWarn && message != null) {
                this.ops.warnHandler("Fall back to translate the key '" + key + "' with '" + this.ops.fallbackLocale + "' locale.", null)
            }
        }
        if (message == null) {
            this.ops.warnHandler("Not found '" + key + "' key in '" + locale + "' locale messages.", null)
            return key
        }
        if (repeatCount != null && UTSAndroid.`typeof`(message) == "string" && message.includes("|")) {
            val safeCount: Number = repeatCount
            message = this.handlePlural(message, safeCount, locale)
        }
        if (UTSAndroid.`typeof`(message) == "string") {
            message = this.interpolate(message, values)
        }
        if (this.ops.postTranslation != null && UTSAndroid.`typeof`(message) == "string") {
            val processedMessage: String = this.ops.postTranslation!!(message, key)
            message = processedMessage
        }
        return if (UTSAndroid.`typeof`(message) == "string") {
            message
        } else {
            key
        }
    }
    override fun n(kVal: Number, formatName: String?, opts: NumberFormat?): String {
        var currentLocale = (opts?.local ?: xI18nsReactive.local)!!
        var formatOptions = NumberFormatOpts(style = "decimal", currency = "CNY", local = currentLocale, currencyDisplay = "symbol", useGrouping = false, minimumIntegerDigits = 1, minimumFractionDigits = 0, maximumFractionDigits = 3, minimumSignificantDigits = null, maximumSignificantDigits = null)
        if (opts != null) {
            formatOptions = NumberFormatOpts(style = opts?.style ?: formatOptions.style, currency = opts?.currency ?: formatOptions.currency, local = opts?.local ?: formatOptions.local, currencyDisplay = opts?.currencyDisplay ?: formatOptions.currencyDisplay, useGrouping = opts?.useGrouping ?: formatOptions.useGrouping, minimumIntegerDigits = opts?.minimumIntegerDigits ?: formatOptions.minimumIntegerDigits, minimumFractionDigits = opts?.minimumFractionDigits ?: formatOptions.minimumFractionDigits, maximumFractionDigits = opts?.maximumFractionDigits ?: formatOptions.maximumFractionDigits, minimumSignificantDigits = opts?.minimumSignificantDigits ?: formatOptions.minimumSignificantDigits, maximumSignificantDigits = opts?.maximumSignificantDigits ?: formatOptions.maximumSignificantDigits)
        }
        if (UTSAndroid.`typeof`(formatName) == "string") {
            val formatNameReal = formatName!!
            if (this.ops.numberFormats.has(currentLocale)) {
                val localeFormats = this.ops.numberFormats.get(currentLocale)!!
                if (localeFormats.has(formatNameReal)) {
                    val formatOptions_templ = localeFormats.get(formatNameReal)!!
                    formatOptions = NumberFormatOpts(style = formatOptions_templ?.style ?: formatOptions.style, currency = formatOptions_templ?.currency ?: formatOptions.currency, local = formatOptions_templ?.local ?: formatOptions.local, currencyDisplay = formatOptions_templ?.currencyDisplay ?: formatOptions.currencyDisplay, useGrouping = formatOptions_templ?.useGrouping ?: formatOptions.useGrouping, minimumIntegerDigits = formatOptions_templ?.minimumIntegerDigits ?: formatOptions.minimumIntegerDigits, minimumFractionDigits = formatOptions_templ?.minimumFractionDigits ?: formatOptions.minimumFractionDigits, maximumFractionDigits = formatOptions_templ?.maximumFractionDigits ?: formatOptions.maximumFractionDigits, minimumSignificantDigits = formatOptions_templ?.minimumSignificantDigits ?: formatOptions.minimumSignificantDigits, maximumSignificantDigits = formatOptions_templ?.maximumSignificantDigits ?: formatOptions.maximumSignificantDigits)
                } else {
                    this.ops.warnHandler("Number format '" + formatNameReal + "' not found for locale '" + currentLocale + "'", null)
                }
            } else {
                this.ops.warnHandler("Number formats not found for locale '" + currentLocale + "'", null)
            }
        }
        currentLocale = formatOptions.local
        return this.formatNumber(kVal, formatOptions, currentLocale)
    }
    override fun d(kVal: Any, formatName: StringOrNull?, opts: DateTimeFormatOrNull?): String {
        var currentLocale = (opts?.local ?: xI18nsReactive.local)!!
        var formatOptions = DateTimeFormatReal(localeMatcher = "best fit", local = currentLocale, calendar = "gregory", numberingSystem = "latn", dateSeparator = "", timeZone = "UTC", hour12 = false, hourCycle = "h23", formatMatcher = "best fit", weekday = "", era = "", year = "numeric", month = "numeric", day = "numeric", dayPeriod = "", hour = "", minute = "", second = "", fractionalSecondDigits = 0, timeZoneName = "", dateStyle = "", timeStyle = "")
        if (opts != null) {
            formatOptions = DateTimeFormatReal(localeMatcher = opts?.localeMatcher ?: formatOptions.localeMatcher, local = opts?.local ?: formatOptions.local, dateSeparator = opts?.dateSeparator ?: formatOptions.dateSeparator, calendar = opts?.calendar ?: formatOptions.calendar, numberingSystem = opts?.numberingSystem ?: formatOptions.numberingSystem, timeZone = opts?.timeZone ?: formatOptions.timeZone, hour12 = opts?.hour12 ?: formatOptions.hour12, hourCycle = opts?.hourCycle ?: formatOptions.hourCycle, formatMatcher = opts?.formatMatcher ?: formatOptions.formatMatcher, weekday = opts?.weekday ?: formatOptions.weekday, era = opts?.era ?: formatOptions.era, year = opts?.year ?: formatOptions.year, month = opts?.month ?: formatOptions.month, day = opts?.day ?: formatOptions.day, dayPeriod = opts?.dayPeriod ?: formatOptions.dayPeriod, hour = opts?.hour ?: formatOptions.hour, minute = opts?.minute ?: formatOptions.minute, second = opts?.second ?: formatOptions.second, fractionalSecondDigits = opts?.fractionalSecondDigits ?: formatOptions.fractionalSecondDigits, timeZoneName = opts?.timeZoneName ?: formatOptions.timeZoneName, dateStyle = opts?.dateStyle ?: formatOptions.dateStyle, timeStyle = opts?.timeStyle ?: formatOptions.timeStyle)
        }
        if (UTSAndroid.`typeof`(formatName) == "string") {
            val formatNameReal = formatName!!
            if (this.ops.datetimeFormats.has(currentLocale)) {
                val localeFormats = this.ops.datetimeFormats.get(currentLocale)!!
                if (localeFormats.has(formatNameReal)) {
                    val formatOptions_templ = localeFormats.get(formatNameReal)!!
                    formatOptions = DateTimeFormatReal(localeMatcher = formatOptions_templ?.localeMatcher ?: formatOptions.localeMatcher, local = formatOptions_templ?.local ?: formatOptions.local, calendar = formatOptions_templ?.calendar ?: formatOptions.calendar, numberingSystem = formatOptions_templ?.numberingSystem ?: formatOptions.numberingSystem, timeZone = formatOptions_templ?.timeZone ?: formatOptions.timeZone, hour12 = formatOptions_templ?.hour12 ?: formatOptions.hour12, hourCycle = formatOptions_templ?.hourCycle ?: formatOptions.hourCycle, formatMatcher = formatOptions_templ?.formatMatcher ?: formatOptions.formatMatcher, dateSeparator = formatOptions_templ?.dateSeparator ?: formatOptions.dateSeparator, weekday = formatOptions_templ?.weekday ?: formatOptions.weekday, era = formatOptions_templ?.era ?: formatOptions.era, year = formatOptions_templ?.year ?: formatOptions.year, month = formatOptions_templ?.month ?: formatOptions.month, day = formatOptions_templ?.day ?: formatOptions.day, dayPeriod = formatOptions_templ?.dayPeriod ?: formatOptions.dayPeriod, hour = formatOptions_templ?.hour ?: formatOptions.hour, minute = formatOptions_templ?.minute ?: formatOptions.minute, second = formatOptions_templ?.second ?: formatOptions.second, fractionalSecondDigits = formatOptions_templ?.fractionalSecondDigits ?: formatOptions.fractionalSecondDigits, timeZoneName = formatOptions_templ?.timeZoneName ?: formatOptions.timeZoneName, dateStyle = formatOptions_templ?.dateStyle ?: formatOptions.dateStyle, timeStyle = formatOptions_templ?.timeStyle ?: formatOptions.timeStyle)
                } else {
                    this.ops.warnHandler("DateTime format '" + formatNameReal + "' not found for locale '" + currentLocale + "'", null)
                }
            } else {
                this.ops.warnHandler("DateTime formats not found for locale '" + currentLocale + "'", null)
            }
        }
        currentLocale = formatOptions.local
        return this.formatDateTime(kVal, formatOptions, currentLocale)
    }
    override fun mergeLocaleMessage(local: String, newMessage: UTSJSONObject) {
        var nowmessage = this.ops.messages.getJSON(local)
        if (nowmessage != null) {
            nowmessage = UTSJSONObject.assign(_uO(), nowmessage, newMessage)
            this.ops.messages.set(local, nowmessage)
        } else {
            this.ops.messages.set(local, newMessage)
        }
    }
    override fun te(key: String, locale: String?): Boolean {
        val targetLocale = if (locale != null) {
            locale
        } else {
            xI18nsReactive.local
        }
        val messages = this.ops.messages
        if (messages[targetLocale] == null) {
            return false
        }
        val localeMessages = messages[targetLocale] as UTSJSONObjectOrNull
        if (localeMessages == null) {
            return false
        }
        val message = this.getNestedValue(localeMessages, key)
        return message != null
    }
    override fun rt(timeValues: Any?, units: String?, locale: String?): String {
        val targetLocale = if (locale != null) {
            locale
        } else {
            xI18nsReactive.local
        }
        val timeValue = if (timeValues != null) {
            timeValues!!
        } else {
            Date()
        }
        val unit = if (units != null) {
            units!!
        } else {
            "minute"
        }
        try {
            var targetTimestamp: Number = 0
            if (UTSAndroid.`typeof`(timeValue) == "number") {
                targetTimestamp = timeValue as Number
            } else if (timeValue is Date) {
                targetTimestamp = (timeValue as Date).getTime()
            } else if (UTSAndroid.`typeof`(timeValue) == "string") {
                targetTimestamp = Date((timeValue as String).replace(UTSRegExp("-", "g"), "/")).getTime()
            }
            val currentTimestamp = Date().getTime()
            val timeDiff = targetTimestamp - currentTimestamp
            val validUnits = _uA(
                "year",
                "years",
                "quarter",
                "quarters",
                "month",
                "months",
                "week",
                "weeks",
                "day",
                "days",
                "hour",
                "hours",
                "minute",
                "minutes",
                "second",
                "seconds"
            )
            var normalizedUnit = unit.toLowerCase()
            if (normalizedUnit.endsWith("s") && normalizedUnit != "seconds") {
                normalizedUnit = normalizedUnit.slice(0, -1)
            }
            when (normalizedUnit) {
                "yr", "y" -> 
                    normalizedUnit = "year"
                "mo", "m" -> 
                    normalizedUnit = "month"
                "w" -> 
                    normalizedUnit = "week"
                "d" -> 
                    normalizedUnit = "day"
                "h" -> 
                    normalizedUnit = "hour"
                "min" -> 
                    normalizedUnit = "minute"
                "s", "sec" -> 
                    normalizedUnit = "second"
                "q" -> 
                    normalizedUnit = "quarter"
            }
            if (!validUnits.includes(normalizedUnit) && !validUnits.includes(normalizedUnit + "s")) {
                this.ops.warnHandler("Invalid unit '" + unit + "' for relative time formatting. Valid units are: " + validUnits.join(", "), null)
                return "" + timeValue + " " + unit
            }
            val bestTime = this.getBestTimeUnit(timeDiff, normalizedUnit)
            return this.formatRelativeTimeFallback(bestTime.value, bestTime.unit, targetLocale)
        }
         catch (e: Throwable) {
            this.ops.warnHandler("Relative time formatting failed for value " + timeValue + " " + unit, e as UTSError)
            return "" + timeValue + " " + unit
        }
    }
    override fun availableLocales(): UTSArray<String> {
        return UTSJSONObject.keys(this.ops.messages)
    }
    private fun getBestTimeUnit(timeDiff: Number, preferredUnit: String): BestTimeTYpe {
        val timeUnits = _uA(
            timeUnitsTYpe(unit = "second", ms = 1000, threshold = 60),
            timeUnitsTYpe(unit = "minute", ms = 60000, threshold = 60),
            timeUnitsTYpe(unit = "hour", ms = 3600000, threshold = 24),
            timeUnitsTYpe(unit = "day", ms = 86400000, threshold = 7),
            timeUnitsTYpe(unit = "week", ms = 604800000, threshold = 4.33),
            timeUnitsTYpe(unit = "month", ms = 2630016000, threshold = 3),
            timeUnitsTYpe(unit = "quarter", ms = 7890048000, threshold = 4),
            timeUnitsTYpe(unit = "year", ms = 31557600000, threshold = Infinity)
        ) as UTSArray<timeUnitsTYpe>
        var startIndex = timeUnits.findIndex(fun(tu): Boolean {
            return tu.unit == preferredUnit
        }
        )
        if (startIndex == -1) {
            startIndex = 0
        }
        run {
            var i = startIndex
            while(i < timeUnits.length){
                val currentUnit = timeUnits[i]
                val value = Math.round(timeDiff / currentUnit.ms)
                val absValue = Math.abs(value)
                if (absValue < currentUnit.threshold || i == timeUnits.length - 1) {
                    return BestTimeTYpe(unit = currentUnit.unit, value = value)
                }
                i++
            }
        }
        val fallbackUnit = timeUnits[startIndex]
        return BestTimeTYpe(unit = fallbackUnit.unit, value = Math.round(timeDiff / fallbackUnit.ms))
    }
    private fun formatRelativeTimeFallback(value: Number, unit: String, locale: String): String {
        val absValue = Math.abs(value)
        val isPast = value < 0
        val isFuture = value > 0
        val isNow = value == 0
        val langCode = locale.split("-")[0].toLowerCase()
        if (unit == "day") {
            if (isNow) {
                return if (langCode == "zh") {
                    "今天"
                } else {
                    if (langCode == "ja") {
                        "今日"
                    } else {
                        if (langCode == "ko") {
                            "오늘"
                        } else {
                            "today"
                        }
                    }
                }
            } else if (value == -1) {
                return if (langCode == "zh") {
                    "昨天"
                } else {
                    if (langCode == "ja") {
                        "昨日"
                    } else {
                        if (langCode == "ko") {
                            "어제"
                        } else {
                            "yesterday"
                        }
                    }
                }
            } else if (value == 1) {
                return if (langCode == "zh") {
                    "明天"
                } else {
                    if (langCode == "ja") {
                        "明日"
                    } else {
                        if (langCode == "ko") {
                            "내일"
                        } else {
                            "tomorrow"
                        }
                    }
                }
            }
        }
        val unitName = this.getLocalizedUnitName(unit, absValue, langCode)
        if (langCode == "zh") {
            if (isPast) {
                return "" + absValue + unitName + "前"
            } else if (isFuture) {
                return "" + absValue + unitName + "后"
            } else {
                return "现在"
            }
        } else if (langCode == "ja") {
            if (isPast) {
                return "" + absValue + unitName + "前"
            } else if (isFuture) {
                return "" + absValue + unitName + "後"
            } else {
                return "今"
            }
        } else if (langCode == "ko") {
            if (isPast) {
                return "" + absValue + unitName + " 전"
            } else if (isFuture) {
                return "" + absValue + unitName + " 후"
            } else {
                return "지금"
            }
        } else {
            if (isPast) {
                return "" + absValue + " " + unitName + " ago"
            } else if (isFuture) {
                return "in " + absValue + " " + unitName
            } else {
                return "now"
            }
        }
    }
    private fun getLocalizedUnitName(unit: String, value: Number, langCode: String): String {
        val isPlural = value != 1
        when (langCode) {
            "zh" -> 
                when (unit) {
                    "year" -> 
                        return "年"
                    "quarter" -> 
                        return "季度"
                    "month" -> 
                        return "个月"
                    "week" -> 
                        return "周"
                    "day" -> 
                        return "天"
                    "hour" -> 
                        return "小时"
                    "minute" -> 
                        return "分钟"
                    "second" -> 
                        return "秒"
                    else -> 
                        return unit
                }
            "ja" -> 
                when (unit) {
                    "year" -> 
                        return "年"
                    "quarter" -> 
                        return "四半期"
                    "month" -> 
                        return "ヶ月"
                    "week" -> 
                        return "週間"
                    "day" -> 
                        return "日"
                    "hour" -> 
                        return "時間"
                    "minute" -> 
                        return "分"
                    "second" -> 
                        return "秒"
                    else -> 
                        return unit
                }
            "ko" -> 
                when (unit) {
                    "year" -> 
                        return "년"
                    "quarter" -> 
                        return "분기"
                    "month" -> 
                        return "개월"
                    "week" -> 
                        return "주"
                    "day" -> 
                        return "일"
                    "hour" -> 
                        return "시간"
                    "minute" -> 
                        return "분"
                    "second" -> 
                        return "초"
                    else -> 
                        return unit
                }
            else -> 
                when (unit) {
                    "year" -> 
                        return if (isPlural) {
                            "years"
                        } else {
                            "year"
                        }
                    "quarter" -> 
                        return if (isPlural) {
                            "quarters"
                        } else {
                            "quarter"
                        }
                    "month" -> 
                        return if (isPlural) {
                            "months"
                        } else {
                            "month"
                        }
                    "week" -> 
                        return if (isPlural) {
                            "weeks"
                        } else {
                            "week"
                        }
                    "day" -> 
                        return if (isPlural) {
                            "days"
                        } else {
                            "day"
                        }
                    "hour" -> 
                        return if (isPlural) {
                            "hours"
                        } else {
                            "hour"
                        }
                    "minute" -> 
                        return if (isPlural) {
                            "minutes"
                        } else {
                            "minute"
                        }
                    "second" -> 
                        return if (isPlural) {
                            "seconds"
                        } else {
                            "second"
                        }
                    else -> 
                        return unit
                }
        }
    }
    private fun formatDateTime(value: Any, options: DateTimeFormatReal, locale: String): String {
        try {
            var dateObj: Date = Date()
            if (value is Date) {
                dateObj = value as Date
            } else if (UTSAndroid.`typeof`(value) == "number") {
                dateObj = Date(value as Number)
            } else if (UTSAndroid.`typeof`(value) == "string") {
                dateObj = Date((value as String).replace(UTSRegExp("-", "g"), "/"))
            }
            if (isNaN(dateObj.getTime())) {
                this.ops.warnHandler("Invalid date: " + value, null)
                return value.toString()
            }
            if (options.dateStyle != "" || options.timeStyle != "") {
                return this.formatWithPredefinedStyle(dateObj, options, locale)
            }
            return this.formatWithCustomOptions(dateObj, options, locale)
        }
         catch (e: Throwable) {
            this.ops.warnHandler("DateTime formatting failed for value " + value, e as UTSError)
            return value.toString()
        }
    }
    private fun formatWithPredefinedStyle(date: Date, options: DateTimeFormatReal, locale: String): String {
        var result = ""
        if (options.dateStyle != "") {
            when (options.dateStyle) {
                "full" -> 
                    result += this.getFullDateFormat(date, locale)
                "long" -> 
                    result += this.getLongDateFormat(date, locale)
                "medium" -> 
                    result += this.getMediumDateFormat(date, locale)
                "short" -> 
                    result += this.getShortDateFormat(date, locale)
                else -> 
                    result += this.getMediumDateFormat(date, locale)
            }
        }
        if (options.timeStyle != "") {
            if (result != "") {
                result += " "
            }
            when (options.timeStyle) {
                "full" -> 
                    result += this.getFullTimeFormat(date, options, locale)
                "long" -> 
                    result += this.getLongTimeFormat(date, options, locale)
                "medium" -> 
                    result += this.getMediumTimeFormat(date, options, locale)
                "short" -> 
                    result += this.getShortTimeFormat(date, options, locale)
                else -> 
                    result += this.getMediumTimeFormat(date, options, locale)
            }
        }
        return result
    }
    private fun formatWithCustomOptions(date: Date, options: DateTimeFormatReal, locale: String): String {
        val dateParts: UTSArray<String> = _uA()
        val timeParts: UTSArray<String> = _uA()
        val langCode = locale.split("-")[0].toLowerCase()
        val isUSFormat = langCode == "en" && (locale.toLowerCase().includes("us") || locale.toLowerCase() == "en")
        if (options.weekday != "") {
            dateParts.push(this.formatWeekday(date, options.weekday, locale))
        }
        if (options.era != "") {
            dateParts.push(this.formatEra(date, options.era, locale))
        }
        if (isUSFormat) {
            if (options.month != "") {
                dateParts.push(this.formatMonth(date, options.month, locale, options.numberingSystem, options.dateSeparator))
            }
            if (options.day != "") {
                dateParts.push(this.formatDay(date, options.day, locale, options.numberingSystem, options.dateSeparator))
            }
            if (options.year != "") {
                dateParts.push(this.formatYear(date, options.year, locale, options.numberingSystem, options.dateSeparator))
            }
        } else {
            if (langCode == "zh" || langCode == "ja" || langCode == "ko") {
                if (options.year != "") {
                    dateParts.push(this.formatYear(date, options.year, locale, options.numberingSystem, options.dateSeparator))
                }
                if (options.month != "") {
                    dateParts.push(this.formatMonth(date, options.month, locale, options.numberingSystem, options.dateSeparator))
                }
                if (options.day != "") {
                    dateParts.push(this.formatDay(date, options.day, locale, options.numberingSystem, options.dateSeparator))
                }
            } else {
                if (options.day != "") {
                    dateParts.push(this.formatDay(date, options.day, locale, options.numberingSystem, options.dateSeparator))
                }
                if (options.month != "") {
                    dateParts.push(this.formatMonth(date, options.month, locale, options.numberingSystem, options.dateSeparator))
                }
                if (options.year != "") {
                    dateParts.push(this.formatYear(date, options.year, locale, options.numberingSystem, options.dateSeparator))
                }
            }
        }
        if (options.hour != "") {
            timeParts.push(this.formatHour(date, options.hour, options.hour12, options.hourCycle, options.numberingSystem))
        }
        if (options.minute != "") {
            timeParts.push(this.formatMinute(date, options.minute, options.numberingSystem))
        }
        if (options.second != "") {
            timeParts.push(this.formatSecond(date, options.second, options.fractionalSecondDigits, options.numberingSystem))
        }
        var timeStr = ""
        if (timeParts.length > 0) {
            timeStr = timeParts.join(":")
            if (options.dayPeriod != "" && options.hour12) {
                timeStr += " " + this.formatDayPeriod(date, options.dayPeriod, locale)
            }
            if (options.timeZoneName != "") {
                timeStr += " " + this.formatTimeZone(date, options.timeZoneName, options.timeZone)
            }
        }
        val result: UTSArray<String> = _uA()
        if (dateParts.length > 0) {
            result.push(this.combineDateTimeParts(dateParts, locale, options.dateSeparator))
        }
        if (timeStr != "") {
            result.push(timeStr)
        }
        return result.join(" ")
    }
    private fun formatNumber(value: Number, options: NumberFormatOpts, locale: String): String {
        try {
            var result = value.toString(10)
            if (options.minimumSignificantDigits != null || options.maximumSignificantDigits != null) {
                result = this.formatWithSignificantDigits(value, options)
            } else {
                if (options.minimumFractionDigits != null || options.maximumFractionDigits != null) {
                    val minDigits = if (options.minimumFractionDigits == null) {
                        0
                    } else {
                        options.minimumFractionDigits!!
                    }
                    val maxDigits = if (options.maximumFractionDigits == null) {
                        3
                    } else {
                        options.maximumFractionDigits!!
                    }
                    result = value.toFixed(Math.max(minDigits, Math.min(maxDigits, 10)))
                    if (maxDigits > minDigits) {
                        result = parseFloat(result).toString(10)
                        if (minDigits > 0) {
                            val parts = result.split(".")
                            if (parts.length == 1) {
                                result += "." + "0".repeat(minDigits)
                            } else {
                                val decimalPart = parts[1]
                                if (decimalPart.length < minDigits) {
                                    result += "0".repeat(minDigits - decimalPart.length)
                                }
                            }
                        }
                    }
                }
                if (options.minimumIntegerDigits != null && options.minimumIntegerDigits > 1) {
                    result = this.formatWithMinimumIntegerDigits(result, options.minimumIntegerDigits)
                }
            }
            if (options.useGrouping == true) {
                result = this.addThousandsSeparator(result, locale)
            }
            if (options.style != null) {
                when (options.style) {
                    "currency" -> 
                        result = this.formatCurrency(result, options, locale)
                    "percent" -> 
                        result = this.formatPercent(result, value)
                    "decimal" -> 
                        {}
                    else -> 
                        {}
                }
            }
            return result
        }
         catch (e: Throwable) {
            this.ops.warnHandler("Number formatting failed for value " + value, e as UTSError)
            return value.toString(10)
        }
    }
    private fun formatWithSignificantDigits(value: Number, options: NumberFormatOpts): String {
        val minSigDigits = options.minimumSignificantDigits ?: 1
        val maxSigDigits = options.maximumSignificantDigits ?: 21
        val actualMinSigDigits = Math.max(1, Math.min(minSigDigits, 21))
        val actualMaxSigDigits = Math.max(actualMinSigDigits, Math.min(maxSigDigits, 21))
        var result = value.toPrecision(actualMaxSigDigits)
        if (!result.includes("e") && !result.includes("E")) {
            val num = parseFloat(result)
            result = num.toPrecision(actualMinSigDigits)
            if (!result.includes("e") && !result.includes("E")) {
                result = parseFloat(result).toString(10)
            }
        }
        return result
    }
    private fun formatWithMinimumIntegerDigits(numStr: String, minIntegerDigits: Number): String {
        val parts = numStr.split(".")
        val integerPart = parts[0]
        val decimalPart = if (parts.length > 1) {
            parts[1]
        } else {
            ""
        }
        val paddedInteger = integerPart.padStart(minIntegerDigits, "0")
        return if (decimalPart != "") {
            "" + paddedInteger + "." + decimalPart
        } else {
            paddedInteger
        }
    }
    private fun getFullDateFormat(date: Date, locale: String): String {
        val langCode = locale.split("-")[0].toLowerCase()
        val isUSFormat = langCode == "en" && (locale.toLowerCase().includes("us") || locale.toLowerCase() == "en")
        if (langCode == "zh") {
            return "" + date.getFullYear() + "年" + (date.getMonth() + 1) + "月" + date.getDate() + "日 " + this.formatWeekday(date, "long", locale)
        } else if (langCode == "ja") {
            return "" + date.getFullYear() + "年" + (date.getMonth() + 1) + "月" + date.getDate() + "日 " + this.formatWeekday(date, "long", locale)
        } else if (langCode == "ko") {
            return "" + date.getFullYear() + "년 " + (date.getMonth() + 1) + "월 " + date.getDate() + "일 " + this.formatWeekday(date, "long", locale)
        } else if (isUSFormat) {
            return "" + this.formatWeekday(date, "long", locale) + ", " + this.formatMonth(date, "long", locale) + " " + date.getDate() + ", " + date.getFullYear()
        } else {
            return "" + this.formatWeekday(date, "long", locale) + ", " + date.getDate() + " " + this.formatMonth(date, "long", locale) + " " + date.getFullYear()
        }
    }
    private fun getLongDateFormat(date: Date, locale: String): String {
        val langCode = locale.split("-")[0].toLowerCase()
        val isUSFormat = langCode == "en" && (locale.toLowerCase().includes("us") || locale.toLowerCase() == "en")
        if (langCode == "zh") {
            return "" + date.getFullYear() + "年" + (date.getMonth() + 1) + "月" + date.getDate() + "日"
        } else if (langCode == "ja") {
            return "" + date.getFullYear() + "年" + (date.getMonth() + 1) + "月" + date.getDate() + "日"
        } else if (langCode == "ko") {
            return "" + date.getFullYear() + "년 " + (date.getMonth() + 1) + "월 " + date.getDate() + "일"
        } else if (isUSFormat) {
            return "" + this.formatMonth(date, "long", locale) + " " + date.getDate() + ", " + date.getFullYear()
        } else {
            return "" + date.getDate() + " " + this.formatMonth(date, "long", locale) + " " + date.getFullYear()
        }
    }
    private fun getMediumDateFormat(date: Date, locale: String): String {
        val langCode = locale.split("-")[0].toLowerCase()
        val isUSFormat = langCode == "en" && (locale.toLowerCase().includes("us") || locale.toLowerCase() == "en")
        if (langCode == "zh" || langCode == "ja" || langCode == "ko") {
            return "" + date.getFullYear() + "-" + (date.getMonth() + 1).toString(10).padStart(2, "0") + "-" + date.getDate().toString(10).padStart(2, "0")
        } else if (isUSFormat) {
            return "" + this.formatMonth(date, "short", locale) + " " + date.getDate() + ", " + date.getFullYear()
        } else {
            return "" + date.getDate() + " " + this.formatMonth(date, "short", locale) + " " + date.getFullYear()
        }
    }
    private fun getShortDateFormat(date: Date, locale: String): String {
        val langCode = locale.split("-")[0].toLowerCase()
        val isUSFormat = langCode == "en" && (locale.toLowerCase().includes("us") || locale.toLowerCase() == "en")
        val year = date.getFullYear().toString(10).slice(-2)
        val month = (date.getMonth() + 1).toString(10).padStart(2, "0")
        val day = date.getDate().toString(10).padStart(2, "0")
        if (isUSFormat) {
            return "" + month + "/" + day + "/" + year
        } else if (langCode == "zh" || langCode == "ja" || langCode == "ko") {
            return "" + year + "/" + month + "/" + day
        } else {
            return "" + day + "/" + month + "/" + year
        }
    }
    private fun getFullTimeFormat(date: Date, options: DateTimeFormatReal, locale: String): String {
        val timeStr = this.getMediumTimeFormat(date, options, locale)
        val timeZone = this.formatTimeZone(date, "long", options.timeZone)
        return "" + timeStr + " " + timeZone
    }
    private fun getLongTimeFormat(date: Date, options: DateTimeFormatReal, locale: String): String {
        val timeStr = this.getMediumTimeFormat(date, options, locale)
        val timeZone = this.formatTimeZone(date, "short", options.timeZone)
        return "" + timeStr + " " + timeZone
    }
    private fun getMediumTimeFormat(date: Date, options: DateTimeFormatReal, locale: String): String {
        val hour = this.formatHour(date, "numeric", options.hour12, options.hourCycle)
        val minute = this.formatMinute(date, "2-digit")
        val second = this.formatSecond(date, "2-digit", 0)
        val dayPeriod = if (options.hour12) {
            " " + this.formatDayPeriod(date, "short", locale)
        } else {
            ""
        }
        return "" + hour + ":" + minute + ":" + second + dayPeriod
    }
    private fun getShortTimeFormat(date: Date, options: DateTimeFormatReal, locale: String): String {
        val hour = this.formatHour(date, "numeric", options.hour12, options.hourCycle)
        val minute = this.formatMinute(date, "2-digit")
        val dayPeriod = if (options.hour12) {
            " " + this.formatDayPeriod(date, "short", locale)
        } else {
            ""
        }
        return "" + hour + ":" + minute + dayPeriod
    }
    private fun formatWeekday(date: Date, style: String, locale: String): String {
        val weekdays = this.getWeekdayNames(locale)
        val dayIndex = date.getDay()
        when (style) {
            "long" -> 
                return weekdays.long[dayIndex]
            "short" -> 
                return weekdays.short[dayIndex]
            "narrow" -> 
                return weekdays.narrow[dayIndex]
            else -> 
                return weekdays.long[dayIndex]
        }
    }
    private fun formatEra(date: Date, style: String, locale: String): String {
        val year = date.getFullYear()
        val langCode = locale.split("-")[0].toLowerCase()
        if (langCode == "zh") {
            return if (year > 0) {
                "公元"
            } else {
                "公元前"
            }
        } else {
            when (style) {
                "long" -> 
                    return if (year > 0) {
                        "Anno Domini"
                    } else {
                        "Before Christ"
                    }
                "short" -> 
                    return if (year > 0) {
                        "AD"
                    } else {
                        "BC"
                    }
                "narrow" -> 
                    return if (year > 0) {
                        "AD"
                    } else {
                        "BC"
                    }
                else -> 
                    return if (year > 0) {
                        "AD"
                    } else {
                        "BC"
                    }
            }
        }
    }
    private fun convertNumberingSystem(number: String, numberingSystem: String): String {
        if (numberingSystem == "latn" || numberingSystem == "") {
            return number
        }
        val digits = Tmui4xI18n.NUMBERING_SYSTEMS_MAP.get(numberingSystem)
        if (digits == null) {
            return number
        }
        var result = ""
        run {
            var i: Number = 0
            while(i < number.length){
                val char = number.charAt(i)
                if (char >= "0" && char <= "9") {
                    val digitIndex = parseInt(char)
                    result += digits[digitIndex]
                } else {
                    result += char
                }
                i++
            }
        }
        return result
    }
    private fun formatYear(date: Date, style: String, locale: String = "", numberingSystem: String = "latn", dateSeparator: String = ""): String {
        val year = date.getFullYear()
        val langCode = locale.split("-")[0].toLowerCase()
        var yearStr = ""
        when (style) {
            "numeric" -> 
                {
                    yearStr = this.convertNumberingSystem(year.toString(10), numberingSystem)
                    return if ((dateSeparator != "" || langCode != "zh")) {
                        yearStr
                    } else {
                        "" + yearStr + "年"
                    }
                }
            "2-digit" -> 
                {
                    val shortYear = year.toString(10).slice(-2).padStart(2, "0")
                    yearStr = this.convertNumberingSystem(shortYear, numberingSystem)
                    return if ((dateSeparator != "" || langCode != "zh")) {
                        yearStr
                    } else {
                        "" + yearStr + "年"
                    }
                }
            else -> 
                {
                    yearStr = this.convertNumberingSystem(year.toString(10), numberingSystem)
                    return if ((dateSeparator != "" || langCode != "zh")) {
                        yearStr
                    } else {
                        "" + yearStr + "年"
                    }
                }
        }
    }
    private fun formatMonth(date: Date, style: String, locale: String, numberingSystem: String = "latn", dateSeparator: String = ""): String {
        val month = date.getMonth()
        val monthNames = this.getMonthNames(locale)
        val langCode = locale.split("-")[0].toLowerCase()
        when (style) {
            "numeric" -> 
                {
                    val monthStr = this.convertNumberingSystem((month + 1).toString(10), numberingSystem)
                    return if ((dateSeparator != "" || langCode != "zh")) {
                        monthStr
                    } else {
                        "" + monthStr + "月"
                    }
                }
            "2-digit" -> 
                {
                    val paddedMonth = (month + 1).toString(10).padStart(2, "0")
                    val paddedMonthStr = this.convertNumberingSystem(paddedMonth, numberingSystem)
                    return if ((dateSeparator != "" || langCode != "zh")) {
                        paddedMonthStr
                    } else {
                        "" + paddedMonthStr + "月"
                    }
                }
            "long" -> 
                return monthNames.long[month]
            "short" -> 
                return monthNames.short[month]
            "narrow" -> 
                return monthNames.narrow[month]
            else -> 
                {
                    val defaultMonthStr = this.convertNumberingSystem((month + 1).toString(10), numberingSystem)
                    return if ((dateSeparator != "" || langCode != "zh")) {
                        defaultMonthStr
                    } else {
                        "" + defaultMonthStr + "月"
                    }
                }
        }
    }
    private fun formatDay(date: Date, style: String, locale: String = "", numberingSystem: String = "latn", dateSeparator: String = ""): String {
        val day = date.getDate()
        val langCode = locale.split("-")[0].toLowerCase()
        when (style) {
            "numeric" -> 
                {
                    val dayStr = this.convertNumberingSystem(day.toString(10), numberingSystem)
                    return if ((dateSeparator != "" || langCode != "zh")) {
                        dayStr
                    } else {
                        "" + dayStr + "日"
                    }
                }
            "2-digit" -> 
                {
                    val paddedDay = day.toString(10).padStart(2, "0")
                    val paddedDayStr = this.convertNumberingSystem(paddedDay, numberingSystem)
                    return if ((dateSeparator != "" || langCode != "zh")) {
                        paddedDayStr
                    } else {
                        "" + paddedDayStr + "日"
                    }
                }
            else -> 
                {
                    val defaultDayStr = this.convertNumberingSystem(day.toString(10), numberingSystem)
                    return if ((dateSeparator != "" || langCode != "zh")) {
                        defaultDayStr
                    } else {
                        "" + defaultDayStr + "日"
                    }
                }
        }
    }
    private fun formatHour(date: Date, style: String, hour12: Boolean, hourCycle: String, numberingSystem: String = "latn"): String {
        var hour = date.getHours()
        if (hour12) {
            if (hourCycle == "h11") {
                hour = hour % 12
            } else {
                hour = hour % 12
                if (hour == 0) {
                    hour = 12
                }
            }
        } else {
            if (hourCycle == "h11") {
                hour = hour % 12
            } else if (hourCycle == "h24") {
                if (hour == 0) {
                    hour = 24
                }
            }
        }
        when (style) {
            "numeric" -> 
                return this.convertNumberingSystem(hour.toString(10), numberingSystem)
            "2-digit" -> 
                return this.convertNumberingSystem(hour.toString(10).padStart(2, "0"), numberingSystem)
            else -> 
                return this.convertNumberingSystem(hour.toString(10), numberingSystem)
        }
    }
    private fun formatMinute(date: Date, style: String, numberingSystem: String = "latn"): String {
        val minute = date.getMinutes()
        when (style) {
            "numeric" -> 
                return this.convertNumberingSystem(minute.toString(10), numberingSystem)
            "2-digit" -> 
                return this.convertNumberingSystem(minute.toString(10).padStart(2, "0"), numberingSystem)
            else -> 
                return this.convertNumberingSystem(minute.toString(10), numberingSystem)
        }
    }
    private fun formatSecond(date: Date, style: String, fractionalDigits: Number, numberingSystem: String = "latn"): String {
        val second = date.getSeconds()
        val millisecond = date.getMilliseconds()
        var result = ""
        when (style) {
            "numeric" -> 
                result = this.convertNumberingSystem(second.toString(10), numberingSystem)
            "2-digit" -> 
                result = this.convertNumberingSystem(second.toString(10).padStart(2, "0"), numberingSystem)
            else -> 
                result = this.convertNumberingSystem(second.toString(10), numberingSystem)
        }
        if (fractionalDigits > 0) {
            val fractional = millisecond.toString(10).padStart(3, "0").slice(0, fractionalDigits)
            val convertedFractional = this.convertNumberingSystem(fractional, numberingSystem)
            result += "." + convertedFractional
        }
        return result
    }
    private fun formatDayPeriod(date: Date, style: String, locale: String): String {
        val hour = date.getHours()
        val isAM = hour < 12
        val langCode = locale.split("-")[0].toLowerCase()
        if (langCode == "zh") {
            return if (isAM) {
                "上午"
            } else {
                "下午"
            }
        }
        return if (isAM) {
            "AM"
        } else {
            "PM"
        }
    }
    private fun formatTimeZone(date: Date, style: String, timeZone: String): String {
        when (style) {
            "long" -> 
                return if (timeZone == "UTC") {
                    "Coordinated Universal Time"
                } else {
                    timeZone
                }
            "short" -> 
                return if (timeZone == "UTC") {
                    "UTC"
                } else {
                    timeZone
                }
            else -> 
                return if (timeZone == "UTC") {
                    "UTC"
                } else {
                    timeZone
                }
        }
    }
    private fun combineDateTimeParts(parts: UTSArray<String>, locale: String, dateSeparator: String = ""): String {
        val langCode = locale.split("-")[0].toLowerCase()
        if (dateSeparator != "") {
            return parts.join(dateSeparator)
        }
        if (langCode == "zh") {
            return parts.join("")
        } else {
            return parts.join(" ")
        }
    }
    private fun getWeekdayNames(locale: String): DateTimeNames {
        val langCode = locale.split("-")[0].toLowerCase()
        return if (langCode == "zh") {
            Tmui4xI18n.WEEKDAY_NAMES_ZH
        } else {
            Tmui4xI18n.WEEKDAY_NAMES_EN
        }
    }
    private fun getMonthNames(locale: String): DateTimeNames {
        val langCode = locale.split("-")[0].toLowerCase()
        return if (langCode == "zh") {
            Tmui4xI18n.MONTH_NAMES_ZH
        } else {
            Tmui4xI18n.MONTH_NAMES_EN
        }
    }
    private fun addThousandsSeparator(numStr: String, locale: String): String {
        val parts = numStr.split(".")
        val integerPart = parts[0]
        val decimalPart = if (parts.length > 1) {
            parts[1]
        } else {
            ""
        }
        val separator = this.getThousandsSeparator(locale)
        val formattedInteger = integerPart.replace(UTSRegExp("(\\d)(?=(\\d{3})+(?!\\d))", "g"), "\$1" + separator)
        return if (decimalPart != "") {
            "" + formattedInteger + "." + decimalPart
        } else {
            formattedInteger
        }
    }
    private fun getThousandsSeparator(locale: String): String {
        val langCode = locale.split("-")[0].toLowerCase()
        val separator = Tmui4xI18n.THOUSANDS_SEPARATOR_MAP.get(langCode)
        return separator ?: ","
    }
    private fun formatCurrency(numStr: String, options: NumberFormatOpts, locale: String): String {
        val currency = options.currency ?: "USD"
        val currencyDisplay = options.currencyDisplay ?: "symbol"
        var currencySymbol = currency
        if (currencyDisplay == "symbol") {
            when (currency.toUpperCase()) {
                "USD" -> 
                    currencySymbol = "\$"
                "CAD" -> 
                    currencySymbol = "C\$"
                "BRL" -> 
                    currencySymbol = "R\$"
                "MXN" -> 
                    currencySymbol = "\$"
                "EUR" -> 
                    currencySymbol = "€"
                "GBP" -> 
                    currencySymbol = "£"
                "CHF" -> 
                    currencySymbol = "CHF"
                "RUB" -> 
                    currencySymbol = "₽"
                "JPY" -> 
                    currencySymbol = "¥"
                "CNY", "RMB" -> 
                    currencySymbol = "¥"
                "KRW" -> 
                    currencySymbol = "₩"
                "INR" -> 
                    currencySymbol = "₹"
                "AUD" -> 
                    currencySymbol = "A\$"
                "SGD" -> 
                    currencySymbol = "S\$"
                "HKD" -> 
                    currencySymbol = "HK\$"
                "TWD" -> 
                    currencySymbol = "NT\$"
                "THB" -> 
                    currencySymbol = "฿"
                "MYR" -> 
                    currencySymbol = "RM"
                "VND" -> 
                    currencySymbol = "₫"
                "IDR" -> 
                    currencySymbol = "Rp"
                "PHP" -> 
                    currencySymbol = "₱"
                "SAR" -> 
                    currencySymbol = "﷼"
                "AED" -> 
                    currencySymbol = "د.إ"
                "ILS" -> 
                    currencySymbol = "₪"
                "TRY" -> 
                    currencySymbol = "₺"
                "ZAR" -> 
                    currencySymbol = "R"
                else -> 
                    currencySymbol = currency
            }
        }
        return this.getCurrencyPosition(currencySymbol, numStr, currency, locale)
    }
    private fun getCurrencyPosition(symbol: String, numStr: String, currency: String, locale: String): String {
        val currencyCode = currency.toUpperCase()
        if (Tmui4xI18n.PREFIX_NO_SPACE.has(currencyCode)) {
            return "" + symbol + numStr
        } else if (Tmui4xI18n.PREFIX_WITH_SPACE.has(currencyCode)) {
            return "" + symbol + " " + numStr
        } else if (Tmui4xI18n.SUFFIX_WITH_SPACE.has(currencyCode)) {
            return "" + numStr + " " + symbol
        } else {
            if (locale.startsWith("en") || locale.startsWith("zh")) {
                return "" + symbol + numStr
            } else {
                return "" + numStr + " " + symbol
            }
        }
    }
    private fun formatPercent(numStr: String, originalValue: Number): String {
        val percentValue = originalValue * 100
        return "" + percentValue + "%"
    }
    private fun getMessage(key: String, locale: String): StringOrNull {
        val messages = this.ops.messages
        if (messages[locale] == null) {
            return null
        }
        val localeMessages = messages[locale] as UTSJSONObjectOrNull
        return this.getNestedValue(localeMessages, key)
    }
    private fun getNestedValue(obj: UTSJSONObjectOrNull, path: String): StringOrNull {
        val keys = path.split(".")
        var keyIdx: Number = 0
        var getAny: GetAnyTypeOrNull = null
        getAny = fun(objdata: AnyOrNull): AnyOrNull {
            var realGetAny = getAny!!
            if (objdata == null) {
                return null
            }
            if (UTSAndroid.`typeof`(objdata) == "string" || UTSAndroid.`typeof`(objdata) == "number") {
                return objdata
            }
            if (keyIdx >= keys.length) {
                return null
            }
            var key = keys[keyIdx]
            keyIdx++
            return realGetAny((objdata!! as UTSJSONObject).getAny(key))
        }
        var current: AnyOrNull = getAny(obj)
        if (UTSAndroid.`typeof`(current) == "number") {
            return (current as Number).toString()
        }
        return if (UTSAndroid.`typeof`(current) == "string") {
            current as String
        } else {
            null
        }
    }
    private fun handlePlural(message: String, count: Number, locale: String): String {
        val choices = message.split("|").map(fun(choice: String): String {
            return choice.trim()
        }
        )
        val choicesLength = choices.length
        var pluralRule = this.ops.pluralRule
        if (this.ops.pluralRules.has(locale)) {
            pluralRule = this.ops.pluralRules.get(locale)!!
        }
        var index: Number = 0
        if (pluralRule != null) {
            index = pluralRule(count, choicesLength, null)
        }
        val safeIndex = Math.max(0, Math.min(index, choicesLength - 1))
        var result = choices[safeIndex]
        if (result == "" || result == null) {
            result = choices[0]
        }
        if (result == "" || result == null) {
            result = message
        }
        return result
    }
    private fun interpolate(message: String, values: Any): String {
        if (!message.includes("{")) {
            return message
        }
        var msg = message
        if (UTSArray.isArray(values)) {
            msg = message.replace(UTSRegExp("\\{(\\d+)\\}", "g"), fun(match: String, key: String, offset: Number, str: String): String {
                val value = (values as UTSArray<Any>)[parseInt(key)]
                if (value != null) {
                    var result = if (UTSAndroid.`typeof`(value) == "number") {
                        (value as Number).toString()
                    } else {
                        value as String
                    }
                    return result
                }
                return match
            })
        } else if (values is UTSJSONObject || UTSAndroid.`typeof`(values) == "object") {
            msg = message.replace(UTSRegExp("\\{([^}]+)\\}", "g"), fun(match: String, key: String, offset: Number, str: String): String {
                val value = (values as UTSJSONObject)[key]
                if (value != null) {
                    if (UTSAndroid.`typeof`(value) == "string") {
                        return value as String
                    }
                    if (UTSAndroid.`typeof`(value) == "number") {
                        return (value as Number).toString()
                    }
                }
                return match
            }
            )
        }
        return msg
    }
    companion object {
        private val WEEKDAY_NAMES_ZH: DateTimeNames = DateTimeNames(long = _uA(
            "星期日",
            "星期一",
            "星期二",
            "星期三",
            "星期四",
            "星期五",
            "星期六"
        ), short = _uA(
            "周日",
            "周一",
            "周二",
            "周三",
            "周四",
            "周五",
            "周六"
        ), narrow = _uA(
            "日",
            "一",
            "二",
            "三",
            "四",
            "五",
            "六"
        ))
        private val WEEKDAY_NAMES_EN: DateTimeNames = DateTimeNames(long = _uA(
            "Sunday",
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday",
            "Saturday"
        ), short = _uA(
            "Sun",
            "Mon",
            "Tue",
            "Wed",
            "Thu",
            "Fri",
            "Sat"
        ), narrow = _uA(
            "S",
            "M",
            "T",
            "W",
            "T",
            "F",
            "S"
        ))
        private val MONTH_NAMES_ZH: DateTimeNames = DateTimeNames(long = _uA(
            "一月",
            "二月",
            "三月",
            "四月",
            "五月",
            "六月",
            "七月",
            "八月",
            "九月",
            "十月",
            "十一月",
            "十二月"
        ), short = _uA(
            "1月",
            "2月",
            "3月",
            "4月",
            "5月",
            "6月",
            "7月",
            "8月",
            "9月",
            "10月",
            "11月",
            "12月"
        ), narrow = _uA(
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12"
        ))
        private val MONTH_NAMES_EN: DateTimeNames = DateTimeNames(long = _uA(
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"
        ), short = _uA(
            "Jan",
            "Feb",
            "Mar",
            "Apr",
            "May",
            "Jun",
            "Jul",
            "Aug",
            "Sep",
            "Oct",
            "Nov",
            "Dec"
        ), narrow = _uA(
            "J",
            "F",
            "M",
            "A",
            "M",
            "J",
            "J",
            "A",
            "S",
            "O",
            "N",
            "D"
        ))
        private val NUMBERING_SYSTEMS_MAP = Map<String, UTSArray<String>>(_uA(
            _uA(
                "arab",
                _uA(
                    "٠",
                    "١",
                    "٢",
                    "٣",
                    "٤",
                    "٥",
                    "٦",
                    "٧",
                    "٨",
                    "٩"
                )
            ),
            _uA(
                "arabext",
                _uA(
                    "۰",
                    "۱",
                    "۲",
                    "۳",
                    "۴",
                    "۵",
                    "۶",
                    "۷",
                    "۸",
                    "۹"
                )
            ),
            _uA(
                "deva",
                _uA(
                    "०",
                    "१",
                    "२",
                    "३",
                    "४",
                    "५",
                    "६",
                    "७",
                    "८",
                    "९"
                )
            ),
            _uA(
                "fullwide",
                _uA(
                    "０",
                    "１",
                    "２",
                    "３",
                    "４",
                    "５",
                    "６",
                    "７",
                    "８",
                    "９"
                )
            ),
            _uA(
                "hanidec",
                _uA(
                    "〇",
                    "一",
                    "二",
                    "三",
                    "四",
                    "五",
                    "六",
                    "七",
                    "八",
                    "九"
                )
            ),
            _uA(
                "thai",
                _uA(
                    "๐",
                    "๑",
                    "๒",
                    "๓",
                    "๔",
                    "๕",
                    "๖",
                    "๗",
                    "๘",
                    "๙"
                )
            )
        ))
        private val THOUSANDS_SEPARATOR_MAP = Map<String, String>(_uA(
            _uA(
                "en",
                ","
            ),
            _uA(
                "zh",
                ","
            ),
            _uA(
                "zh-Hant",
                ","
            ),
            _uA(
                "ja",
                ","
            ),
            _uA(
                "ko",
                ","
            ),
            _uA(
                "pt",
                ","
            ),
            _uA(
                "th",
                ","
            ),
            _uA(
                "vi",
                ","
            ),
            _uA(
                "id",
                ","
            ),
            _uA(
                "ms",
                ","
            ),
            _uA(
                "tl",
                ","
            ),
            _uA(
                "he",
                ","
            ),
            _uA(
                "ar",
                ","
            ),
            _uA(
                "de",
                " "
            ),
            _uA(
                "fr",
                " "
            ),
            _uA(
                "ru",
                " "
            ),
            _uA(
                "sv",
                " "
            ),
            _uA(
                "no",
                " "
            ),
            _uA(
                "da",
                " "
            ),
            _uA(
                "fi",
                " "
            ),
            _uA(
                "cs",
                " "
            ),
            _uA(
                "sk",
                " "
            ),
            _uA(
                "pl",
                " "
            ),
            _uA(
                "es",
                "."
            ),
            _uA(
                "it",
                "."
            ),
            _uA(
                "nl",
                "."
            ),
            _uA(
                "tr",
                "."
            ),
            _uA(
                "ch",
                "'"
            )
        ))
        private val PREFIX_NO_SPACE = Set<String>(_uA(
            "USD",
            "CAD",
            "AUD",
            "HKD",
            "SGD",
            "TWD",
            "GBP",
            "CNY",
            "RMB",
            "JPY"
        ))
        private val PREFIX_WITH_SPACE = Set<String>(_uA(
            "BRL",
            "MXN",
            "KRW",
            "INR",
            "THB",
            "VND",
            "IDR",
            "PHP",
            "ILS",
            "TRY"
        ))
        private val SUFFIX_WITH_SPACE = Set<String>(_uA(
            "EUR",
            "CHF",
            "RUB",
            "MYR",
            "SAR",
            "AED",
            "ZAR"
        ))
    }
}
typealias NAVIGATE_TYPE = String
open class XDROPDOWN_LISTITEM_INFO_TYPE (
    @JsonNotNull
    open var id: String,
    @JsonNotNull
    open var title: String,
    @JsonNotNull
    open var keyName: String,
    @JsonNotNull
    open var icon: String,
    @JsonNotNull
    open var activeIcon: String,
    @JsonNotNull
    open var fontColor: String,
    @JsonNotNull
    open var activeFontColor: String,
    @JsonNotNull
    open var fontSize: String,
    @JsonNotNull
    open var isBtn: Boolean = false,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return XDROPDOWN_LISTITEM_INFO_TYPEReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class XDROPDOWN_LISTITEM_INFO_TYPEReactiveObject : XDROPDOWN_LISTITEM_INFO_TYPE, IUTSReactive<XDROPDOWN_LISTITEM_INFO_TYPE> {
    override var __v_raw: XDROPDOWN_LISTITEM_INFO_TYPE
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: XDROPDOWN_LISTITEM_INFO_TYPE, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(id = __v_raw.id, title = __v_raw.title, keyName = __v_raw.keyName, icon = __v_raw.icon, activeIcon = __v_raw.activeIcon, fontColor = __v_raw.fontColor, activeFontColor = __v_raw.activeFontColor, fontSize = __v_raw.fontSize, isBtn = __v_raw.isBtn) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): XDROPDOWN_LISTITEM_INFO_TYPEReactiveObject {
        return XDROPDOWN_LISTITEM_INFO_TYPEReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var id: String
        get() {
            return _tRG(__v_raw, "id", __v_raw.id, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("id")) {
                return
            }
            val oldValue = __v_raw.id
            __v_raw.id = value
            _tRS(__v_raw, "id", oldValue, value)
        }
    override var title: String
        get() {
            return _tRG(__v_raw, "title", __v_raw.title, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("title")) {
                return
            }
            val oldValue = __v_raw.title
            __v_raw.title = value
            _tRS(__v_raw, "title", oldValue, value)
        }
    override var keyName: String
        get() {
            return _tRG(__v_raw, "keyName", __v_raw.keyName, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("keyName")) {
                return
            }
            val oldValue = __v_raw.keyName
            __v_raw.keyName = value
            _tRS(__v_raw, "keyName", oldValue, value)
        }
    override var icon: String
        get() {
            return _tRG(__v_raw, "icon", __v_raw.icon, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("icon")) {
                return
            }
            val oldValue = __v_raw.icon
            __v_raw.icon = value
            _tRS(__v_raw, "icon", oldValue, value)
        }
    override var activeIcon: String
        get() {
            return _tRG(__v_raw, "activeIcon", __v_raw.activeIcon, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("activeIcon")) {
                return
            }
            val oldValue = __v_raw.activeIcon
            __v_raw.activeIcon = value
            _tRS(__v_raw, "activeIcon", oldValue, value)
        }
    override var fontColor: String
        get() {
            return _tRG(__v_raw, "fontColor", __v_raw.fontColor, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("fontColor")) {
                return
            }
            val oldValue = __v_raw.fontColor
            __v_raw.fontColor = value
            _tRS(__v_raw, "fontColor", oldValue, value)
        }
    override var activeFontColor: String
        get() {
            return _tRG(__v_raw, "activeFontColor", __v_raw.activeFontColor, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("activeFontColor")) {
                return
            }
            val oldValue = __v_raw.activeFontColor
            __v_raw.activeFontColor = value
            _tRS(__v_raw, "activeFontColor", oldValue, value)
        }
    override var fontSize: String
        get() {
            return _tRG(__v_raw, "fontSize", __v_raw.fontSize, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("fontSize")) {
                return
            }
            val oldValue = __v_raw.fontSize
            __v_raw.fontSize = value
            _tRS(__v_raw, "fontSize", oldValue, value)
        }
    override var isBtn: Boolean
        get() {
            return _tRG(__v_raw, "isBtn", __v_raw.isBtn, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("isBtn")) {
                return
            }
            val oldValue = __v_raw.isBtn
            __v_raw.isBtn = value
            _tRS(__v_raw, "isBtn", oldValue, value)
        }
}
open class NODE_INFO (
    @JsonNotNull
    open var left: Number,
    @JsonNotNull
    open var width: Number,
    @JsonNotNull
    open var height: Number,
    @JsonNotNull
    open var bottom: Number,
    @JsonNotNull
    open var right: Number,
    @JsonNotNull
    open var top: Number,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return NODE_INFOReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class NODE_INFOReactiveObject : NODE_INFO, IUTSReactive<NODE_INFO> {
    override var __v_raw: NODE_INFO
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: NODE_INFO, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(left = __v_raw.left, width = __v_raw.width, height = __v_raw.height, bottom = __v_raw.bottom, right = __v_raw.right, top = __v_raw.top) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): NODE_INFOReactiveObject {
        return NODE_INFOReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var left: Number
        get() {
            return _tRG(__v_raw, "left", __v_raw.left, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("left")) {
                return
            }
            val oldValue = __v_raw.left
            __v_raw.left = value
            _tRS(__v_raw, "left", oldValue, value)
        }
    override var width: Number
        get() {
            return _tRG(__v_raw, "width", __v_raw.width, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("width")) {
                return
            }
            val oldValue = __v_raw.width
            __v_raw.width = value
            _tRS(__v_raw, "width", oldValue, value)
        }
    override var height: Number
        get() {
            return _tRG(__v_raw, "height", __v_raw.height, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("height")) {
                return
            }
            val oldValue = __v_raw.height
            __v_raw.height = value
            _tRS(__v_raw, "height", oldValue, value)
        }
    override var bottom: Number
        get() {
            return _tRG(__v_raw, "bottom", __v_raw.bottom, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("bottom")) {
                return
            }
            val oldValue = __v_raw.bottom
            __v_raw.bottom = value
            _tRS(__v_raw, "bottom", oldValue, value)
        }
    override var right: Number
        get() {
            return _tRG(__v_raw, "right", __v_raw.right, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("right")) {
                return
            }
            val oldValue = __v_raw.right
            __v_raw.right = value
            _tRS(__v_raw, "right", oldValue, value)
        }
    override var top: Number
        get() {
            return _tRG(__v_raw, "top", __v_raw.top, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("top")) {
                return
            }
            val oldValue = __v_raw.top
            __v_raw.top = value
            _tRS(__v_raw, "top", oldValue, value)
        }
}
open class TABS_ITEM_INFO (
    @JsonNotNull
    open var title: String,
    open var disabled: Boolean? = null,
    open var id: String? = null,
    open var dotType: String? = null,
    open var dotColor: String? = null,
    open var dotText: String? = null,
    open var data: UTSJSONObject? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return TABS_ITEM_INFOReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class TABS_ITEM_INFOReactiveObject : TABS_ITEM_INFO, IUTSReactive<TABS_ITEM_INFO> {
    override var __v_raw: TABS_ITEM_INFO
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: TABS_ITEM_INFO, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(title = __v_raw.title, disabled = __v_raw.disabled, id = __v_raw.id, dotType = __v_raw.dotType, dotColor = __v_raw.dotColor, dotText = __v_raw.dotText, data = __v_raw.data) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): TABS_ITEM_INFOReactiveObject {
        return TABS_ITEM_INFOReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var title: String
        get() {
            return _tRG(__v_raw, "title", __v_raw.title, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("title")) {
                return
            }
            val oldValue = __v_raw.title
            __v_raw.title = value
            _tRS(__v_raw, "title", oldValue, value)
        }
    override var disabled: Boolean?
        get() {
            return _tRG(__v_raw, "disabled", __v_raw.disabled, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("disabled")) {
                return
            }
            val oldValue = __v_raw.disabled
            __v_raw.disabled = value
            _tRS(__v_raw, "disabled", oldValue, value)
        }
    override var id: String?
        get() {
            return _tRG(__v_raw, "id", __v_raw.id, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("id")) {
                return
            }
            val oldValue = __v_raw.id
            __v_raw.id = value
            _tRS(__v_raw, "id", oldValue, value)
        }
    override var dotType: String?
        get() {
            return _tRG(__v_raw, "dotType", __v_raw.dotType, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("dotType")) {
                return
            }
            val oldValue = __v_raw.dotType
            __v_raw.dotType = value
            _tRS(__v_raw, "dotType", oldValue, value)
        }
    override var dotColor: String?
        get() {
            return _tRG(__v_raw, "dotColor", __v_raw.dotColor, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("dotColor")) {
                return
            }
            val oldValue = __v_raw.dotColor
            __v_raw.dotColor = value
            _tRS(__v_raw, "dotColor", oldValue, value)
        }
    override var dotText: String?
        get() {
            return _tRG(__v_raw, "dotText", __v_raw.dotText, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("dotText")) {
                return
            }
            val oldValue = __v_raw.dotText
            __v_raw.dotText = value
            _tRS(__v_raw, "dotText", oldValue, value)
        }
    override var data: UTSJSONObject?
        get() {
            return _tRG(__v_raw, "data", __v_raw.data, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("data")) {
                return
            }
            val oldValue = __v_raw.data
            __v_raw.data = value
            _tRS(__v_raw, "data", oldValue, value)
        }
}
open class TABS_ITEM (
    @JsonNotNull
    open var title: String,
    @JsonNotNull
    open var disabled: Boolean = false,
    @JsonNotNull
    open var id: String,
    @JsonNotNull
    open var dotType: String,
    @JsonNotNull
    open var dotColor: String,
    @JsonNotNull
    open var dotText: String,
    @JsonNotNull
    open var data: UTSJSONObject,
) : UTSObject()
open class SLIDER_TREE_ITEM_INFO (
    @JsonNotNull
    open var id: String,
    @JsonNotNull
    open var title: String,
    open var children: UTSArray<SLIDER_TREE_ITEM_INFO>? = null,
    open var disabled: Boolean? = null,
    open var icon: String? = null,
    open var selected: UTSArray<String>? = null,
    open var data: UTSArray<UTSJSONObject>? = null,
) : UTSObject()
open class TABBAR_ITEM_INFO (
    open var title: String? = null,
    open var icon: String? = null,
    open var selectedIcon: String? = null,
    open var disabled: Boolean? = null,
    open var color: String? = null,
    open var selectedColor: String? = null,
    open var openType: NAVIGATE_TYPE? = null,
    open var url: String? = null,
    open var dotType: String? = null,
    open var dotLabel: String? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return TABBAR_ITEM_INFOReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class TABBAR_ITEM_INFOReactiveObject : TABBAR_ITEM_INFO, IUTSReactive<TABBAR_ITEM_INFO> {
    override var __v_raw: TABBAR_ITEM_INFO
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: TABBAR_ITEM_INFO, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(title = __v_raw.title, icon = __v_raw.icon, selectedIcon = __v_raw.selectedIcon, disabled = __v_raw.disabled, color = __v_raw.color, selectedColor = __v_raw.selectedColor, openType = __v_raw.openType, url = __v_raw.url, dotType = __v_raw.dotType, dotLabel = __v_raw.dotLabel) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): TABBAR_ITEM_INFOReactiveObject {
        return TABBAR_ITEM_INFOReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var title: String?
        get() {
            return _tRG(__v_raw, "title", __v_raw.title, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("title")) {
                return
            }
            val oldValue = __v_raw.title
            __v_raw.title = value
            _tRS(__v_raw, "title", oldValue, value)
        }
    override var icon: String?
        get() {
            return _tRG(__v_raw, "icon", __v_raw.icon, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("icon")) {
                return
            }
            val oldValue = __v_raw.icon
            __v_raw.icon = value
            _tRS(__v_raw, "icon", oldValue, value)
        }
    override var selectedIcon: String?
        get() {
            return _tRG(__v_raw, "selectedIcon", __v_raw.selectedIcon, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("selectedIcon")) {
                return
            }
            val oldValue = __v_raw.selectedIcon
            __v_raw.selectedIcon = value
            _tRS(__v_raw, "selectedIcon", oldValue, value)
        }
    override var disabled: Boolean?
        get() {
            return _tRG(__v_raw, "disabled", __v_raw.disabled, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("disabled")) {
                return
            }
            val oldValue = __v_raw.disabled
            __v_raw.disabled = value
            _tRS(__v_raw, "disabled", oldValue, value)
        }
    override var color: String?
        get() {
            return _tRG(__v_raw, "color", __v_raw.color, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("color")) {
                return
            }
            val oldValue = __v_raw.color
            __v_raw.color = value
            _tRS(__v_raw, "color", oldValue, value)
        }
    override var selectedColor: String?
        get() {
            return _tRG(__v_raw, "selectedColor", __v_raw.selectedColor, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("selectedColor")) {
                return
            }
            val oldValue = __v_raw.selectedColor
            __v_raw.selectedColor = value
            _tRS(__v_raw, "selectedColor", oldValue, value)
        }
    override var openType: NAVIGATE_TYPE?
        get() {
            return _tRG(__v_raw, "openType", __v_raw.openType, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("openType")) {
                return
            }
            val oldValue = __v_raw.openType
            __v_raw.openType = value
            _tRS(__v_raw, "openType", oldValue, value)
        }
    override var url: String?
        get() {
            return _tRG(__v_raw, "url", __v_raw.url, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("url")) {
                return
            }
            val oldValue = __v_raw.url
            __v_raw.url = value
            _tRS(__v_raw, "url", oldValue, value)
        }
    override var dotType: String?
        get() {
            return _tRG(__v_raw, "dotType", __v_raw.dotType, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("dotType")) {
                return
            }
            val oldValue = __v_raw.dotType
            __v_raw.dotType = value
            _tRS(__v_raw, "dotType", oldValue, value)
        }
    override var dotLabel: String?
        get() {
            return _tRG(__v_raw, "dotLabel", __v_raw.dotLabel, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("dotLabel")) {
                return
            }
            val oldValue = __v_raw.dotLabel
            __v_raw.dotLabel = value
            _tRS(__v_raw, "dotLabel", oldValue, value)
        }
}
open class XUPLOADFILE_INFO (
    open var count: Number? = null,
    open var sourceType: UTSArray<String>? = null,
    open var sizeType: UTSArray<String>? = null,
    open var hostUrl: String? = null,
    open var name: String? = null,
    open var header: UTSJSONObject? = null,
    open var formData: UTSJSONObject? = null,
    open var multipart: Boolean? = null,
    open var autoUpload: Boolean? = null,
    open var statusCode: Number? = null,
    open var compress: Boolean? = null,
    open var quality: Number? = null,
    open var compressedHeight: Number? = null,
    open var compressedWidth: Number? = null,
) : UTSObject()
typealias XUPLOADFILE_FILE_STATUS = Number
open class XUPLOADFILE_FILE_INFO (
    @JsonNotNull
    open var id: String,
    @JsonNotNull
    open var type: String,
    @JsonNotNull
    open var size: Number,
    @JsonNotNull
    open var path: String,
    @JsonNotNull
    open var name: String,
    @JsonNotNull
    open var extension: String,
    @JsonNotNull
    open var progress: Number,
    @JsonNotNull
    open var statusText: String,
    @JsonNotNull
    open var status: XUPLOADFILE_FILE_STATUS,
    @JsonNotNull
    open var response: String,
    open var model: String? = null,
) : UTSObject()
typealias XUPLOADFILE_EVENT_NAME = String
open class XUPLOADFILE_FILE_VALUE (
    open var id: String? = null,
    open var response: String? = null,
    @JsonNotNull
    open var url: String,
    open var status: Number? = null,
) : UTSObject()
open class PICKER_ITEM_INFO (
    @JsonNotNull
    open var title: String,
    open var id: String? = null,
    open var children: UTSArray<PICKER_ITEM_INFO>? = null,
    open var disabled: Boolean? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return PICKER_ITEM_INFOReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class PICKER_ITEM_INFOReactiveObject : PICKER_ITEM_INFO, IUTSReactive<PICKER_ITEM_INFO> {
    override var __v_raw: PICKER_ITEM_INFO
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: PICKER_ITEM_INFO, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(title = __v_raw.title, id = __v_raw.id, children = __v_raw.children, disabled = __v_raw.disabled) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): PICKER_ITEM_INFOReactiveObject {
        return PICKER_ITEM_INFOReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var title: String
        get() {
            return _tRG(__v_raw, "title", __v_raw.title, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("title")) {
                return
            }
            val oldValue = __v_raw.title
            __v_raw.title = value
            _tRS(__v_raw, "title", oldValue, value)
        }
    override var id: String?
        get() {
            return _tRG(__v_raw, "id", __v_raw.id, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("id")) {
                return
            }
            val oldValue = __v_raw.id
            __v_raw.id = value
            _tRS(__v_raw, "id", oldValue, value)
        }
    override var children: UTSArray<PICKER_ITEM_INFO>?
        get() {
            return _tRG(__v_raw, "children", __v_raw.children, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("children")) {
                return
            }
            val oldValue = __v_raw.children
            __v_raw.children = value
            _tRS(__v_raw, "children", oldValue, value)
        }
    override var disabled: Boolean?
        get() {
            return _tRG(__v_raw, "disabled", __v_raw.disabled, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("disabled")) {
                return
            }
            val oldValue = __v_raw.disabled
            __v_raw.disabled = value
            _tRS(__v_raw, "disabled", oldValue, value)
        }
}
open class X_PICKER_X_ITEM (
    @JsonNotNull
    open var id: String,
    @JsonNotNull
    open var title: String,
    @JsonNotNull
    open var children: UTSArray<X_PICKER_X_ITEM>,
    @JsonNotNull
    open var disabled: Boolean = false,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return X_PICKER_X_ITEMReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class X_PICKER_X_ITEMReactiveObject : X_PICKER_X_ITEM, IUTSReactive<X_PICKER_X_ITEM> {
    override var __v_raw: X_PICKER_X_ITEM
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: X_PICKER_X_ITEM, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(id = __v_raw.id, title = __v_raw.title, children = __v_raw.children, disabled = __v_raw.disabled) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): X_PICKER_X_ITEMReactiveObject {
        return X_PICKER_X_ITEMReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var id: String
        get() {
            return _tRG(__v_raw, "id", __v_raw.id, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("id")) {
                return
            }
            val oldValue = __v_raw.id
            __v_raw.id = value
            _tRS(__v_raw, "id", oldValue, value)
        }
    override var title: String
        get() {
            return _tRG(__v_raw, "title", __v_raw.title, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("title")) {
                return
            }
            val oldValue = __v_raw.title
            __v_raw.title = value
            _tRS(__v_raw, "title", oldValue, value)
        }
    override var children: UTSArray<X_PICKER_X_ITEM>
        get() {
            return _tRG(__v_raw, "children", __v_raw.children, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("children")) {
                return
            }
            val oldValue = __v_raw.children
            __v_raw.children = value
            _tRS(__v_raw, "children", oldValue, value)
        }
    override var disabled: Boolean
        get() {
            return _tRG(__v_raw, "disabled", __v_raw.disabled, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("disabled")) {
                return
            }
            val oldValue = __v_raw.disabled
            __v_raw.disabled = value
            _tRS(__v_raw, "disabled", oldValue, value)
        }
}
open class CASCADER_ITEM_INFO (
    @JsonNotNull
    open var id: String,
    @JsonNotNull
    open var title: String,
    open var children: UTSArray<CASCADER_ITEM_INFO>? = null,
    open var disabled: Boolean? = null,
    open var selected: UTSArray<String>? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return CASCADER_ITEM_INFOReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class CASCADER_ITEM_INFOReactiveObject : CASCADER_ITEM_INFO, IUTSReactive<CASCADER_ITEM_INFO> {
    override var __v_raw: CASCADER_ITEM_INFO
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: CASCADER_ITEM_INFO, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(id = __v_raw.id, title = __v_raw.title, children = __v_raw.children, disabled = __v_raw.disabled, selected = __v_raw.selected) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): CASCADER_ITEM_INFOReactiveObject {
        return CASCADER_ITEM_INFOReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var id: String
        get() {
            return _tRG(__v_raw, "id", __v_raw.id, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("id")) {
                return
            }
            val oldValue = __v_raw.id
            __v_raw.id = value
            _tRS(__v_raw, "id", oldValue, value)
        }
    override var title: String
        get() {
            return _tRG(__v_raw, "title", __v_raw.title, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("title")) {
                return
            }
            val oldValue = __v_raw.title
            __v_raw.title = value
            _tRS(__v_raw, "title", oldValue, value)
        }
    override var children: UTSArray<CASCADER_ITEM_INFO>?
        get() {
            return _tRG(__v_raw, "children", __v_raw.children, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("children")) {
                return
            }
            val oldValue = __v_raw.children
            __v_raw.children = value
            _tRS(__v_raw, "children", oldValue, value)
        }
    override var disabled: Boolean?
        get() {
            return _tRG(__v_raw, "disabled", __v_raw.disabled, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("disabled")) {
                return
            }
            val oldValue = __v_raw.disabled
            __v_raw.disabled = value
            _tRS(__v_raw, "disabled", oldValue, value)
        }
    override var selected: UTSArray<String>?
        get() {
            return _tRG(__v_raw, "selected", __v_raw.selected, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("selected")) {
                return
            }
            val oldValue = __v_raw.selected
            __v_raw.selected = value
            _tRS(__v_raw, "selected", oldValue, value)
        }
}
typealias FORM_RULE_TYPE = String
open class FORM_RULE (
    open var type: FORM_RULE_TYPE? = null,
    open var valid: ((`val`: Any?) -> Boolean)? = null,
    open var errorMessage: String? = null,
    open var max: Number? = null,
    open var min: Number? = null,
    open var trigger: String? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return FORM_RULEReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class FORM_RULEReactiveObject : FORM_RULE, IUTSReactive<FORM_RULE> {
    override var __v_raw: FORM_RULE
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: FORM_RULE, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(type = __v_raw.type, valid = __v_raw.valid, errorMessage = __v_raw.errorMessage, max = __v_raw.max, min = __v_raw.min, trigger = __v_raw.trigger) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): FORM_RULEReactiveObject {
        return FORM_RULEReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var type: FORM_RULE_TYPE?
        get() {
            return _tRG(__v_raw, "type", __v_raw.type, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("type")) {
                return
            }
            val oldValue = __v_raw.type
            __v_raw.type = value
            _tRS(__v_raw, "type", oldValue, value)
        }
    override var errorMessage: String?
        get() {
            return _tRG(__v_raw, "errorMessage", __v_raw.errorMessage, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("errorMessage")) {
                return
            }
            val oldValue = __v_raw.errorMessage
            __v_raw.errorMessage = value
            _tRS(__v_raw, "errorMessage", oldValue, value)
        }
    override var max: Number?
        get() {
            return _tRG(__v_raw, "max", __v_raw.max, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("max")) {
                return
            }
            val oldValue = __v_raw.max
            __v_raw.max = value
            _tRS(__v_raw, "max", oldValue, value)
        }
    override var min: Number?
        get() {
            return _tRG(__v_raw, "min", __v_raw.min, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("min")) {
                return
            }
            val oldValue = __v_raw.min
            __v_raw.min = value
            _tRS(__v_raw, "min", oldValue, value)
        }
    override var trigger: String?
        get() {
            return _tRG(__v_raw, "trigger", __v_raw.trigger, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("trigger")) {
                return
            }
            val oldValue = __v_raw.trigger
            __v_raw.trigger = value
            _tRS(__v_raw, "trigger", oldValue, value)
        }
}
open class FORM_SUBMIT_OBJECT (
    @JsonNotNull
    open var errorMessage: String,
    @JsonNotNull
    open var valid: Boolean = false,
    @JsonNotNull
    open var key: String,
    open var value: Any? = null,
) : UTSObject()
open class FORM_SUBMIT_RESULT (
    @JsonNotNull
    open var valid: Boolean = false,
    @JsonNotNull
    open var errorMessage: String,
    @JsonNotNull
    open var key: String,
    @JsonNotNull
    open var formData: UTSArray<FORM_SUBMIT_OBJECT>,
) : UTSObject()
open class CASCADER_TREE_ITEM (
    @JsonNotNull
    open var id: String,
    @JsonNotNull
    open var title: String,
    @JsonNotNull
    open var children: UTSArray<CASCADER_TREE_ITEM>,
    @JsonNotNull
    open var disabled: Boolean = false,
    @JsonNotNull
    open var selected: UTSArray<String>,
    @JsonNotNull
    open var checked: Boolean = false,
) : UTSObject()
open class XANIMATE_OPIONS (
    open var ele: String? = null,
    open var duration: Number? = null,
    open var timingFunction: String? = null,
    open var loop: Number? = null,
    open var tyty: Boolean? = null,
    open var isDescPlay: Boolean? = null,
    open var bezier: UTSArray<Number>? = null,
    open var complete: (() -> Unit)? = null,
    open var start: (() -> Unit)? = null,
    open var frame: ((propress: Number) -> Unit)? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return XANIMATE_OPIONSReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class XANIMATE_OPIONSReactiveObject : XANIMATE_OPIONS, IUTSReactive<XANIMATE_OPIONS> {
    override var __v_raw: XANIMATE_OPIONS
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: XANIMATE_OPIONS, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(ele = __v_raw.ele, duration = __v_raw.duration, timingFunction = __v_raw.timingFunction, loop = __v_raw.loop, tyty = __v_raw.tyty, isDescPlay = __v_raw.isDescPlay, bezier = __v_raw.bezier, complete = __v_raw.complete, start = __v_raw.start, frame = __v_raw.frame) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): XANIMATE_OPIONSReactiveObject {
        return XANIMATE_OPIONSReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var ele: String?
        get() {
            return _tRG(__v_raw, "ele", __v_raw.ele, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("ele")) {
                return
            }
            val oldValue = __v_raw.ele
            __v_raw.ele = value
            _tRS(__v_raw, "ele", oldValue, value)
        }
    override var duration: Number?
        get() {
            return _tRG(__v_raw, "duration", __v_raw.duration, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("duration")) {
                return
            }
            val oldValue = __v_raw.duration
            __v_raw.duration = value
            _tRS(__v_raw, "duration", oldValue, value)
        }
    override var timingFunction: String?
        get() {
            return _tRG(__v_raw, "timingFunction", __v_raw.timingFunction, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("timingFunction")) {
                return
            }
            val oldValue = __v_raw.timingFunction
            __v_raw.timingFunction = value
            _tRS(__v_raw, "timingFunction", oldValue, value)
        }
    override var loop: Number?
        get() {
            return _tRG(__v_raw, "loop", __v_raw.loop, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("loop")) {
                return
            }
            val oldValue = __v_raw.loop
            __v_raw.loop = value
            _tRS(__v_raw, "loop", oldValue, value)
        }
    override var tyty: Boolean?
        get() {
            return _tRG(__v_raw, "tyty", __v_raw.tyty, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("tyty")) {
                return
            }
            val oldValue = __v_raw.tyty
            __v_raw.tyty = value
            _tRS(__v_raw, "tyty", oldValue, value)
        }
    override var isDescPlay: Boolean?
        get() {
            return _tRG(__v_raw, "isDescPlay", __v_raw.isDescPlay, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("isDescPlay")) {
                return
            }
            val oldValue = __v_raw.isDescPlay
            __v_raw.isDescPlay = value
            _tRS(__v_raw, "isDescPlay", oldValue, value)
        }
    override var bezier: UTSArray<Number>?
        get() {
            return _tRG(__v_raw, "bezier", __v_raw.bezier, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("bezier")) {
                return
            }
            val oldValue = __v_raw.bezier
            __v_raw.bezier = value
            _tRS(__v_raw, "bezier", oldValue, value)
        }
}
open class xDateDayInfoType (
    @JsonNotNull
    open var year: Number,
    @JsonNotNull
    open var month: Number,
    @JsonNotNull
    open var day: Number,
    @JsonNotNull
    open var hours: Number,
    @JsonNotNull
    open var minutes: Number,
    @JsonNotNull
    open var seconds: Number,
    @JsonNotNull
    open var weeks: Number,
    @JsonNotNull
    open var week: Number,
    @JsonNotNull
    open var weekCn: String,
    @JsonNotNull
    open var date: String,
    open var isRender: Boolean? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return xDateDayInfoTypeReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class xDateDayInfoTypeReactiveObject : xDateDayInfoType, IUTSReactive<xDateDayInfoType> {
    override var __v_raw: xDateDayInfoType
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: xDateDayInfoType, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(year = __v_raw.year, month = __v_raw.month, day = __v_raw.day, hours = __v_raw.hours, minutes = __v_raw.minutes, seconds = __v_raw.seconds, weeks = __v_raw.weeks, week = __v_raw.week, weekCn = __v_raw.weekCn, date = __v_raw.date, isRender = __v_raw.isRender) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): xDateDayInfoTypeReactiveObject {
        return xDateDayInfoTypeReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var year: Number
        get() {
            return _tRG(__v_raw, "year", __v_raw.year, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("year")) {
                return
            }
            val oldValue = __v_raw.year
            __v_raw.year = value
            _tRS(__v_raw, "year", oldValue, value)
        }
    override var month: Number
        get() {
            return _tRG(__v_raw, "month", __v_raw.month, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("month")) {
                return
            }
            val oldValue = __v_raw.month
            __v_raw.month = value
            _tRS(__v_raw, "month", oldValue, value)
        }
    override var day: Number
        get() {
            return _tRG(__v_raw, "day", __v_raw.day, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("day")) {
                return
            }
            val oldValue = __v_raw.day
            __v_raw.day = value
            _tRS(__v_raw, "day", oldValue, value)
        }
    override var hours: Number
        get() {
            return _tRG(__v_raw, "hours", __v_raw.hours, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("hours")) {
                return
            }
            val oldValue = __v_raw.hours
            __v_raw.hours = value
            _tRS(__v_raw, "hours", oldValue, value)
        }
    override var minutes: Number
        get() {
            return _tRG(__v_raw, "minutes", __v_raw.minutes, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("minutes")) {
                return
            }
            val oldValue = __v_raw.minutes
            __v_raw.minutes = value
            _tRS(__v_raw, "minutes", oldValue, value)
        }
    override var seconds: Number
        get() {
            return _tRG(__v_raw, "seconds", __v_raw.seconds, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("seconds")) {
                return
            }
            val oldValue = __v_raw.seconds
            __v_raw.seconds = value
            _tRS(__v_raw, "seconds", oldValue, value)
        }
    override var weeks: Number
        get() {
            return _tRG(__v_raw, "weeks", __v_raw.weeks, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("weeks")) {
                return
            }
            val oldValue = __v_raw.weeks
            __v_raw.weeks = value
            _tRS(__v_raw, "weeks", oldValue, value)
        }
    override var week: Number
        get() {
            return _tRG(__v_raw, "week", __v_raw.week, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("week")) {
                return
            }
            val oldValue = __v_raw.week
            __v_raw.week = value
            _tRS(__v_raw, "week", oldValue, value)
        }
    override var weekCn: String
        get() {
            return _tRG(__v_raw, "weekCn", __v_raw.weekCn, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("weekCn")) {
                return
            }
            val oldValue = __v_raw.weekCn
            __v_raw.weekCn = value
            _tRS(__v_raw, "weekCn", oldValue, value)
        }
    override var date: String
        get() {
            return _tRG(__v_raw, "date", __v_raw.date, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("date")) {
                return
            }
            val oldValue = __v_raw.date
            __v_raw.date = value
            _tRS(__v_raw, "date", oldValue, value)
        }
    override var isRender: Boolean?
        get() {
            return _tRG(__v_raw, "isRender", __v_raw.isRender, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("isRender")) {
                return
            }
            val oldValue = __v_raw.isRender
            __v_raw.isRender = value
            _tRS(__v_raw, "isRender", oldValue, value)
        }
}
typealias xRequestMethond = String
open class xRequestOptions (
    open var hostUrl: String? = null,
    open var successStatusCode: Number? = null,
    open var url: String? = null,
    open var cacheTime: Number? = null,
    open var useCache: Boolean? = null,
    open var data: Any? = null,
    open var header: UTSJSONObject? = null,
    open var method: xRequestMethond? = null,
    open var timeout: Number? = null,
    open var firstIpv4: Boolean? = null,
    open var showLoadToast: Boolean? = null,
    open var showSuccessToast: Boolean? = null,
    open var showErrorToast: Boolean? = null,
    open var dataType: String? = null,
    open var responseType: String? = null,
    open var loadToastText: String? = null,
    open var successToastText: String? = null,
    open var errorToastText: String? = null,
) : UTSObject()
open class xRequestOptionsCallBack (
    @JsonNotNull
    open var hostUrl: String,
    @JsonNotNull
    open var successStatusCode: Number,
    @JsonNotNull
    open var useCache: Boolean = false,
    @JsonNotNull
    open var cacheTime: Number,
    @JsonNotNull
    open var url: String,
    @JsonNotNull
    open var data: Any,
    @JsonNotNull
    open var header: UTSJSONObject,
    @JsonNotNull
    open var method: xRequestMethond,
    @JsonNotNull
    open var timeout: Number,
    @JsonNotNull
    open var firstIpv4: Boolean = false,
    @JsonNotNull
    open var showLoadToast: Boolean = false,
    @JsonNotNull
    open var showSuccessToast: Boolean = false,
    @JsonNotNull
    open var showErrorToast: Boolean = false,
    open var dataType: String? = null,
    open var responseType: String? = null,
    open var loadToastText: String? = null,
    open var successToastText: String? = null,
    open var errorToastText: String? = null,
) : UTSObject()
open class xRequestResult (
    open var data: Any? = null,
    @JsonNotNull
    open var statusCode: Number,
    @JsonNotNull
    open var header: Any,
    @JsonNotNull
    open var cookies: UTSArray<String>,
) : UTSObject()
open class xRequestHistoryType (
    @JsonNotNull
    open var id: String,
    @JsonNotNull
    open var loading: Boolean = false,
    @JsonNotNull
    open var loaded: Boolean = false,
    @JsonNotNull
    open var status: String,
    @JsonNotNull
    open var time: Number,
    @JsonNotNull
    open var api: String,
    @JsonNotNull
    open var result: Any,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return xRequestHistoryTypeReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class xRequestHistoryTypeReactiveObject : xRequestHistoryType, IUTSReactive<xRequestHistoryType> {
    override var __v_raw: xRequestHistoryType
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: xRequestHistoryType, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(id = __v_raw.id, loading = __v_raw.loading, loaded = __v_raw.loaded, status = __v_raw.status, time = __v_raw.time, api = __v_raw.api, result = __v_raw.result) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): xRequestHistoryTypeReactiveObject {
        return xRequestHistoryTypeReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var id: String
        get() {
            return _tRG(__v_raw, "id", __v_raw.id, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("id")) {
                return
            }
            val oldValue = __v_raw.id
            __v_raw.id = value
            _tRS(__v_raw, "id", oldValue, value)
        }
    override var loading: Boolean
        get() {
            return _tRG(__v_raw, "loading", __v_raw.loading, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("loading")) {
                return
            }
            val oldValue = __v_raw.loading
            __v_raw.loading = value
            _tRS(__v_raw, "loading", oldValue, value)
        }
    override var loaded: Boolean
        get() {
            return _tRG(__v_raw, "loaded", __v_raw.loaded, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("loaded")) {
                return
            }
            val oldValue = __v_raw.loaded
            __v_raw.loaded = value
            _tRS(__v_raw, "loaded", oldValue, value)
        }
    override var status: String
        get() {
            return _tRG(__v_raw, "status", __v_raw.status, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("status")) {
                return
            }
            val oldValue = __v_raw.status
            __v_raw.status = value
            _tRS(__v_raw, "status", oldValue, value)
        }
    override var time: Number
        get() {
            return _tRG(__v_raw, "time", __v_raw.time, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("time")) {
                return
            }
            val oldValue = __v_raw.time
            __v_raw.time = value
            _tRS(__v_raw, "time", oldValue, value)
        }
    override var api: String
        get() {
            return _tRG(__v_raw, "api", __v_raw.api, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("api")) {
                return
            }
            val oldValue = __v_raw.api
            __v_raw.api = value
            _tRS(__v_raw, "api", oldValue, value)
        }
    override var result: Any
        get() {
            return _tRG(__v_raw, "result", __v_raw.result, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("result")) {
                return
            }
            val oldValue = __v_raw.result
            __v_raw.result = value
            _tRS(__v_raw, "result", oldValue, value)
        }
}
open class XTABBARCONFIG (
    @JsonNotNull
    open var tabbarActiveIndex: Number,
    @JsonNotNull
    open var tabbarHeight: Number,
    @JsonNotNull
    open var list: UTSArray<TABBAR_ITEM_INFO>,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return XTABBARCONFIGReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class XTABBARCONFIGReactiveObject : XTABBARCONFIG, IUTSReactive<XTABBARCONFIG> {
    override var __v_raw: XTABBARCONFIG
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: XTABBARCONFIG, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(tabbarActiveIndex = __v_raw.tabbarActiveIndex, tabbarHeight = __v_raw.tabbarHeight, list = __v_raw.list) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): XTABBARCONFIGReactiveObject {
        return XTABBARCONFIGReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var tabbarActiveIndex: Number
        get() {
            return _tRG(__v_raw, "tabbarActiveIndex", __v_raw.tabbarActiveIndex, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("tabbarActiveIndex")) {
                return
            }
            val oldValue = __v_raw.tabbarActiveIndex
            __v_raw.tabbarActiveIndex = value
            _tRS(__v_raw, "tabbarActiveIndex", oldValue, value)
        }
    override var tabbarHeight: Number
        get() {
            return _tRG(__v_raw, "tabbarHeight", __v_raw.tabbarHeight, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("tabbarHeight")) {
                return
            }
            val oldValue = __v_raw.tabbarHeight
            __v_raw.tabbarHeight = value
            _tRS(__v_raw, "tabbarHeight", oldValue, value)
        }
    override var list: UTSArray<TABBAR_ITEM_INFO>
        get() {
            return _tRG(__v_raw, "list", __v_raw.list, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("list")) {
                return
            }
            val oldValue = __v_raw.list
            __v_raw.list = value
            _tRS(__v_raw, "list", oldValue, value)
        }
}
open class X_REQUEST_PRIVATE_CALL_FUN_TYPE (
    @JsonNotNull
    open var history: UTSArray<xRequestHistoryType>,
    @JsonNotNull
    open var authPass: Boolean = false,
    @JsonNotNull
    open var hostUrl: String,
    open var header: UTSJSONObject? = null,
    @JsonNotNull
    open var dev: Boolean = false,
    @JsonNotNull
    open var showLoadToast: Boolean = false,
    @JsonNotNull
    open var showSuccessToast: Boolean = false,
    @JsonNotNull
    open var showErrorToast: Boolean = false,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return X_REQUEST_PRIVATE_CALL_FUN_TYPEReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class X_REQUEST_PRIVATE_CALL_FUN_TYPEReactiveObject : X_REQUEST_PRIVATE_CALL_FUN_TYPE, IUTSReactive<X_REQUEST_PRIVATE_CALL_FUN_TYPE> {
    override var __v_raw: X_REQUEST_PRIVATE_CALL_FUN_TYPE
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: X_REQUEST_PRIVATE_CALL_FUN_TYPE, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(history = __v_raw.history, authPass = __v_raw.authPass, hostUrl = __v_raw.hostUrl, header = __v_raw.header, dev = __v_raw.dev, showLoadToast = __v_raw.showLoadToast, showSuccessToast = __v_raw.showSuccessToast, showErrorToast = __v_raw.showErrorToast) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): X_REQUEST_PRIVATE_CALL_FUN_TYPEReactiveObject {
        return X_REQUEST_PRIVATE_CALL_FUN_TYPEReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var history: UTSArray<xRequestHistoryType>
        get() {
            return _tRG(__v_raw, "history", __v_raw.history, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("history")) {
                return
            }
            val oldValue = __v_raw.history
            __v_raw.history = value
            _tRS(__v_raw, "history", oldValue, value)
        }
    override var authPass: Boolean
        get() {
            return _tRG(__v_raw, "authPass", __v_raw.authPass, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("authPass")) {
                return
            }
            val oldValue = __v_raw.authPass
            __v_raw.authPass = value
            _tRS(__v_raw, "authPass", oldValue, value)
        }
    override var hostUrl: String
        get() {
            return _tRG(__v_raw, "hostUrl", __v_raw.hostUrl, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("hostUrl")) {
                return
            }
            val oldValue = __v_raw.hostUrl
            __v_raw.hostUrl = value
            _tRS(__v_raw, "hostUrl", oldValue, value)
        }
    override var header: UTSJSONObject?
        get() {
            return _tRG(__v_raw, "header", __v_raw.header, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("header")) {
                return
            }
            val oldValue = __v_raw.header
            __v_raw.header = value
            _tRS(__v_raw, "header", oldValue, value)
        }
    override var dev: Boolean
        get() {
            return _tRG(__v_raw, "dev", __v_raw.dev, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("dev")) {
                return
            }
            val oldValue = __v_raw.dev
            __v_raw.dev = value
            _tRS(__v_raw, "dev", oldValue, value)
        }
    override var showLoadToast: Boolean
        get() {
            return _tRG(__v_raw, "showLoadToast", __v_raw.showLoadToast, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("showLoadToast")) {
                return
            }
            val oldValue = __v_raw.showLoadToast
            __v_raw.showLoadToast = value
            _tRS(__v_raw, "showLoadToast", oldValue, value)
        }
    override var showSuccessToast: Boolean
        get() {
            return _tRG(__v_raw, "showSuccessToast", __v_raw.showSuccessToast, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("showSuccessToast")) {
                return
            }
            val oldValue = __v_raw.showSuccessToast
            __v_raw.showSuccessToast = value
            _tRS(__v_raw, "showSuccessToast", oldValue, value)
        }
    override var showErrorToast: Boolean
        get() {
            return _tRG(__v_raw, "showErrorToast", __v_raw.showErrorToast, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("showErrorToast")) {
                return
            }
            val oldValue = __v_raw.showErrorToast
            __v_raw.showErrorToast = value
            _tRS(__v_raw, "showErrorToast", oldValue, value)
        }
}
open class xPageStyle (
    @JsonNotNull
    open var path: String,
    @JsonNotNull
    open var backgroundColorContent: String,
    @JsonNotNull
    open var navigationBarBackgroundColor: String,
    @JsonNotNull
    open var navigationBarTextStyle: String,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return xPageStyleReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class xPageStyleReactiveObject : xPageStyle, IUTSReactive<xPageStyle> {
    override var __v_raw: xPageStyle
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: xPageStyle, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(path = __v_raw.path, backgroundColorContent = __v_raw.backgroundColorContent, navigationBarBackgroundColor = __v_raw.navigationBarBackgroundColor, navigationBarTextStyle = __v_raw.navigationBarTextStyle) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): xPageStyleReactiveObject {
        return xPageStyleReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var path: String
        get() {
            return _tRG(__v_raw, "path", __v_raw.path, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("path")) {
                return
            }
            val oldValue = __v_raw.path
            __v_raw.path = value
            _tRS(__v_raw, "path", oldValue, value)
        }
    override var backgroundColorContent: String
        get() {
            return _tRG(__v_raw, "backgroundColorContent", __v_raw.backgroundColorContent, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("backgroundColorContent")) {
                return
            }
            val oldValue = __v_raw.backgroundColorContent
            __v_raw.backgroundColorContent = value
            _tRS(__v_raw, "backgroundColorContent", oldValue, value)
        }
    override var navigationBarBackgroundColor: String
        get() {
            return _tRG(__v_raw, "navigationBarBackgroundColor", __v_raw.navigationBarBackgroundColor, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("navigationBarBackgroundColor")) {
                return
            }
            val oldValue = __v_raw.navigationBarBackgroundColor
            __v_raw.navigationBarBackgroundColor = value
            _tRS(__v_raw, "navigationBarBackgroundColor", oldValue, value)
        }
    override var navigationBarTextStyle: String
        get() {
            return _tRG(__v_raw, "navigationBarTextStyle", __v_raw.navigationBarTextStyle, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("navigationBarTextStyle")) {
                return
            }
            val oldValue = __v_raw.navigationBarTextStyle
            __v_raw.navigationBarTextStyle = value
            _tRS(__v_raw, "navigationBarTextStyle", oldValue, value)
        }
}
open class XPRIVATECONFIG (
    @JsonNotNull
    open var scrollTop: Number,
    @JsonNotNull
    open var windowInnerWidth: Number,
    @JsonNotNull
    open var windowInnerHeight: Number,
    @JsonNotNull
    open var windowWidth: Number,
    @JsonNotNull
    open var windowHeight: Number,
    @JsonNotNull
    open var pageStyle: Map<String, xPageStyle>,
    @JsonNotNull
    open var pageReady: Boolean = false,
    @JsonNotNull
    open var onLoadOpts: UTSJSONObject,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return XPRIVATECONFIGReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class XPRIVATECONFIGReactiveObject : XPRIVATECONFIG, IUTSReactive<XPRIVATECONFIG> {
    override var __v_raw: XPRIVATECONFIG
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: XPRIVATECONFIG, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(scrollTop = __v_raw.scrollTop, windowInnerWidth = __v_raw.windowInnerWidth, windowInnerHeight = __v_raw.windowInnerHeight, windowWidth = __v_raw.windowWidth, windowHeight = __v_raw.windowHeight, pageStyle = __v_raw.pageStyle, pageReady = __v_raw.pageReady, onLoadOpts = __v_raw.onLoadOpts) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): XPRIVATECONFIGReactiveObject {
        return XPRIVATECONFIGReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var scrollTop: Number
        get() {
            return _tRG(__v_raw, "scrollTop", __v_raw.scrollTop, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("scrollTop")) {
                return
            }
            val oldValue = __v_raw.scrollTop
            __v_raw.scrollTop = value
            _tRS(__v_raw, "scrollTop", oldValue, value)
        }
    override var windowInnerWidth: Number
        get() {
            return _tRG(__v_raw, "windowInnerWidth", __v_raw.windowInnerWidth, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("windowInnerWidth")) {
                return
            }
            val oldValue = __v_raw.windowInnerWidth
            __v_raw.windowInnerWidth = value
            _tRS(__v_raw, "windowInnerWidth", oldValue, value)
        }
    override var windowInnerHeight: Number
        get() {
            return _tRG(__v_raw, "windowInnerHeight", __v_raw.windowInnerHeight, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("windowInnerHeight")) {
                return
            }
            val oldValue = __v_raw.windowInnerHeight
            __v_raw.windowInnerHeight = value
            _tRS(__v_raw, "windowInnerHeight", oldValue, value)
        }
    override var windowWidth: Number
        get() {
            return _tRG(__v_raw, "windowWidth", __v_raw.windowWidth, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("windowWidth")) {
                return
            }
            val oldValue = __v_raw.windowWidth
            __v_raw.windowWidth = value
            _tRS(__v_raw, "windowWidth", oldValue, value)
        }
    override var windowHeight: Number
        get() {
            return _tRG(__v_raw, "windowHeight", __v_raw.windowHeight, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("windowHeight")) {
                return
            }
            val oldValue = __v_raw.windowHeight
            __v_raw.windowHeight = value
            _tRS(__v_raw, "windowHeight", oldValue, value)
        }
    override var pageStyle: Map<String, xPageStyle>
        get() {
            return _tRG(__v_raw, "pageStyle", __v_raw.pageStyle, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("pageStyle")) {
                return
            }
            val oldValue = __v_raw.pageStyle
            __v_raw.pageStyle = value
            _tRS(__v_raw, "pageStyle", oldValue, value)
        }
    override var pageReady: Boolean
        get() {
            return _tRG(__v_raw, "pageReady", __v_raw.pageReady, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("pageReady")) {
                return
            }
            val oldValue = __v_raw.pageReady
            __v_raw.pageReady = value
            _tRS(__v_raw, "pageReady", oldValue, value)
        }
    override var onLoadOpts: UTSJSONObject
        get() {
            return _tRG(__v_raw, "onLoadOpts", __v_raw.onLoadOpts, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("onLoadOpts")) {
                return
            }
            val oldValue = __v_raw.onLoadOpts
            __v_raw.onLoadOpts = value
            _tRS(__v_raw, "onLoadOpts", oldValue, value)
        }
}
open class XCONFIG (
    @JsonNotNull
    open var i18n: Tmui4xI18nTml,
    @JsonNotNull
    open var theme: Map<String, String>,
    @JsonNotNull
    open var color: String,
    @JsonNotNull
    open var fontColor: String,
    @JsonNotNull
    open var fontDarkColor: String,
    @JsonNotNull
    open var dark: String,
    @JsonNotNull
    open var designSize: Number,
    @JsonNotNull
    open var maximumCalculatedSize: Number,
    @JsonNotNull
    open var unit: String,
    @JsonNotNull
    open var language: String,
    @JsonNotNull
    open var fontScale: Number,
    @JsonNotNull
    open var fontSize: String,
    @JsonNotNull
    open var navigationBarTextStyleDark: String,
    @JsonNotNull
    open var navigationBarTextStyleLight: String,
    @JsonNotNull
    open var navigationBarBackgroundColorDark: String,
    @JsonNotNull
    open var navigationBarBackgroundColorLight: String,
    @JsonNotNull
    open var backgroundColorContentDark: String,
    @JsonNotNull
    open var backgroundColorContentLight: String,
    @JsonNotNull
    open var tabarBackgroundColorDark: String,
    @JsonNotNull
    open var tabarBackgroundColorLight: String,
    @JsonNotNull
    open var sheetDarkColor: String,
    @JsonNotNull
    open var sheetDarkBorderColor: UTSArray<String>,
    @JsonNotNull
    open var inputDarkColor: String,
    @JsonNotNull
    open var inputBgColor: String,
    @JsonNotNull
    open var placeholderStyle: String,
    @JsonNotNull
    open var borderDarkColor: String,
    @JsonNotNull
    open var inputRadius: String,
    @JsonNotNull
    open var inputFocusBorder: UTSArray<String>,
    @JsonNotNull
    open var buttonRadius: String,
    @JsonNotNull
    open var tagRadius: String,
    @JsonNotNull
    open var cellRadius: String,
    @JsonNotNull
    open var cellMargin: UTSArray<String>,
    @JsonNotNull
    open var sheetRadius: UTSArray<String>,
    @JsonNotNull
    open var sheetMargin: UTSArray<String>,
    @JsonNotNull
    open var sheetPadding: UTSArray<String>,
    @JsonNotNull
    open var drawerRadius: String,
    @JsonNotNull
    open var modalRadius: String,
    @JsonNotNull
    open var switchRadius: String,
    @JsonNotNull
    open var progressRadius: String,
    @JsonNotNull
    open var unRadioAndCheckBoxColor: String,
    @JsonNotNull
    open var radioButtonRadius: String,
    @JsonNotNull
    open var animationFun: String,
    @JsonNotNull
    open var cardRound: String,
    @JsonNotNull
    open var closeIcon: String,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return XCONFIGReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class XCONFIGReactiveObject : XCONFIG, IUTSReactive<XCONFIG> {
    override var __v_raw: XCONFIG
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: XCONFIG, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(i18n = __v_raw.i18n, theme = __v_raw.theme, color = __v_raw.color, fontColor = __v_raw.fontColor, fontDarkColor = __v_raw.fontDarkColor, dark = __v_raw.dark, designSize = __v_raw.designSize, maximumCalculatedSize = __v_raw.maximumCalculatedSize, unit = __v_raw.unit, language = __v_raw.language, fontScale = __v_raw.fontScale, fontSize = __v_raw.fontSize, navigationBarTextStyleDark = __v_raw.navigationBarTextStyleDark, navigationBarTextStyleLight = __v_raw.navigationBarTextStyleLight, navigationBarBackgroundColorDark = __v_raw.navigationBarBackgroundColorDark, navigationBarBackgroundColorLight = __v_raw.navigationBarBackgroundColorLight, backgroundColorContentDark = __v_raw.backgroundColorContentDark, backgroundColorContentLight = __v_raw.backgroundColorContentLight, tabarBackgroundColorDark = __v_raw.tabarBackgroundColorDark, tabarBackgroundColorLight = __v_raw.tabarBackgroundColorLight, sheetDarkColor = __v_raw.sheetDarkColor, sheetDarkBorderColor = __v_raw.sheetDarkBorderColor, inputDarkColor = __v_raw.inputDarkColor, inputBgColor = __v_raw.inputBgColor, placeholderStyle = __v_raw.placeholderStyle, borderDarkColor = __v_raw.borderDarkColor, inputRadius = __v_raw.inputRadius, inputFocusBorder = __v_raw.inputFocusBorder, buttonRadius = __v_raw.buttonRadius, tagRadius = __v_raw.tagRadius, cellRadius = __v_raw.cellRadius, cellMargin = __v_raw.cellMargin, sheetRadius = __v_raw.sheetRadius, sheetMargin = __v_raw.sheetMargin, sheetPadding = __v_raw.sheetPadding, drawerRadius = __v_raw.drawerRadius, modalRadius = __v_raw.modalRadius, switchRadius = __v_raw.switchRadius, progressRadius = __v_raw.progressRadius, unRadioAndCheckBoxColor = __v_raw.unRadioAndCheckBoxColor, radioButtonRadius = __v_raw.radioButtonRadius, animationFun = __v_raw.animationFun, cardRound = __v_raw.cardRound, closeIcon = __v_raw.closeIcon) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): XCONFIGReactiveObject {
        return XCONFIGReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var i18n: Tmui4xI18nTml
        get() {
            return _tRG(__v_raw, "i18n", __v_raw.i18n, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("i18n")) {
                return
            }
            val oldValue = __v_raw.i18n
            __v_raw.i18n = value
            _tRS(__v_raw, "i18n", oldValue, value)
        }
    override var theme: Map<String, String>
        get() {
            return _tRG(__v_raw, "theme", __v_raw.theme, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("theme")) {
                return
            }
            val oldValue = __v_raw.theme
            __v_raw.theme = value
            _tRS(__v_raw, "theme", oldValue, value)
        }
    override var color: String
        get() {
            return _tRG(__v_raw, "color", __v_raw.color, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("color")) {
                return
            }
            val oldValue = __v_raw.color
            __v_raw.color = value
            _tRS(__v_raw, "color", oldValue, value)
        }
    override var fontColor: String
        get() {
            return _tRG(__v_raw, "fontColor", __v_raw.fontColor, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("fontColor")) {
                return
            }
            val oldValue = __v_raw.fontColor
            __v_raw.fontColor = value
            _tRS(__v_raw, "fontColor", oldValue, value)
        }
    override var fontDarkColor: String
        get() {
            return _tRG(__v_raw, "fontDarkColor", __v_raw.fontDarkColor, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("fontDarkColor")) {
                return
            }
            val oldValue = __v_raw.fontDarkColor
            __v_raw.fontDarkColor = value
            _tRS(__v_raw, "fontDarkColor", oldValue, value)
        }
    override var dark: String
        get() {
            return _tRG(__v_raw, "dark", __v_raw.dark, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("dark")) {
                return
            }
            val oldValue = __v_raw.dark
            __v_raw.dark = value
            _tRS(__v_raw, "dark", oldValue, value)
        }
    override var designSize: Number
        get() {
            return _tRG(__v_raw, "designSize", __v_raw.designSize, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("designSize")) {
                return
            }
            val oldValue = __v_raw.designSize
            __v_raw.designSize = value
            _tRS(__v_raw, "designSize", oldValue, value)
        }
    override var maximumCalculatedSize: Number
        get() {
            return _tRG(__v_raw, "maximumCalculatedSize", __v_raw.maximumCalculatedSize, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("maximumCalculatedSize")) {
                return
            }
            val oldValue = __v_raw.maximumCalculatedSize
            __v_raw.maximumCalculatedSize = value
            _tRS(__v_raw, "maximumCalculatedSize", oldValue, value)
        }
    override var unit: String
        get() {
            return _tRG(__v_raw, "unit", __v_raw.unit, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("unit")) {
                return
            }
            val oldValue = __v_raw.unit
            __v_raw.unit = value
            _tRS(__v_raw, "unit", oldValue, value)
        }
    override var language: String
        get() {
            return _tRG(__v_raw, "language", __v_raw.language, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("language")) {
                return
            }
            val oldValue = __v_raw.language
            __v_raw.language = value
            _tRS(__v_raw, "language", oldValue, value)
        }
    override var fontScale: Number
        get() {
            return _tRG(__v_raw, "fontScale", __v_raw.fontScale, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("fontScale")) {
                return
            }
            val oldValue = __v_raw.fontScale
            __v_raw.fontScale = value
            _tRS(__v_raw, "fontScale", oldValue, value)
        }
    override var fontSize: String
        get() {
            return _tRG(__v_raw, "fontSize", __v_raw.fontSize, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("fontSize")) {
                return
            }
            val oldValue = __v_raw.fontSize
            __v_raw.fontSize = value
            _tRS(__v_raw, "fontSize", oldValue, value)
        }
    override var navigationBarTextStyleDark: String
        get() {
            return _tRG(__v_raw, "navigationBarTextStyleDark", __v_raw.navigationBarTextStyleDark, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("navigationBarTextStyleDark")) {
                return
            }
            val oldValue = __v_raw.navigationBarTextStyleDark
            __v_raw.navigationBarTextStyleDark = value
            _tRS(__v_raw, "navigationBarTextStyleDark", oldValue, value)
        }
    override var navigationBarTextStyleLight: String
        get() {
            return _tRG(__v_raw, "navigationBarTextStyleLight", __v_raw.navigationBarTextStyleLight, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("navigationBarTextStyleLight")) {
                return
            }
            val oldValue = __v_raw.navigationBarTextStyleLight
            __v_raw.navigationBarTextStyleLight = value
            _tRS(__v_raw, "navigationBarTextStyleLight", oldValue, value)
        }
    override var navigationBarBackgroundColorDark: String
        get() {
            return _tRG(__v_raw, "navigationBarBackgroundColorDark", __v_raw.navigationBarBackgroundColorDark, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("navigationBarBackgroundColorDark")) {
                return
            }
            val oldValue = __v_raw.navigationBarBackgroundColorDark
            __v_raw.navigationBarBackgroundColorDark = value
            _tRS(__v_raw, "navigationBarBackgroundColorDark", oldValue, value)
        }
    override var navigationBarBackgroundColorLight: String
        get() {
            return _tRG(__v_raw, "navigationBarBackgroundColorLight", __v_raw.navigationBarBackgroundColorLight, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("navigationBarBackgroundColorLight")) {
                return
            }
            val oldValue = __v_raw.navigationBarBackgroundColorLight
            __v_raw.navigationBarBackgroundColorLight = value
            _tRS(__v_raw, "navigationBarBackgroundColorLight", oldValue, value)
        }
    override var backgroundColorContentDark: String
        get() {
            return _tRG(__v_raw, "backgroundColorContentDark", __v_raw.backgroundColorContentDark, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("backgroundColorContentDark")) {
                return
            }
            val oldValue = __v_raw.backgroundColorContentDark
            __v_raw.backgroundColorContentDark = value
            _tRS(__v_raw, "backgroundColorContentDark", oldValue, value)
        }
    override var backgroundColorContentLight: String
        get() {
            return _tRG(__v_raw, "backgroundColorContentLight", __v_raw.backgroundColorContentLight, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("backgroundColorContentLight")) {
                return
            }
            val oldValue = __v_raw.backgroundColorContentLight
            __v_raw.backgroundColorContentLight = value
            _tRS(__v_raw, "backgroundColorContentLight", oldValue, value)
        }
    override var tabarBackgroundColorDark: String
        get() {
            return _tRG(__v_raw, "tabarBackgroundColorDark", __v_raw.tabarBackgroundColorDark, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("tabarBackgroundColorDark")) {
                return
            }
            val oldValue = __v_raw.tabarBackgroundColorDark
            __v_raw.tabarBackgroundColorDark = value
            _tRS(__v_raw, "tabarBackgroundColorDark", oldValue, value)
        }
    override var tabarBackgroundColorLight: String
        get() {
            return _tRG(__v_raw, "tabarBackgroundColorLight", __v_raw.tabarBackgroundColorLight, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("tabarBackgroundColorLight")) {
                return
            }
            val oldValue = __v_raw.tabarBackgroundColorLight
            __v_raw.tabarBackgroundColorLight = value
            _tRS(__v_raw, "tabarBackgroundColorLight", oldValue, value)
        }
    override var sheetDarkColor: String
        get() {
            return _tRG(__v_raw, "sheetDarkColor", __v_raw.sheetDarkColor, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("sheetDarkColor")) {
                return
            }
            val oldValue = __v_raw.sheetDarkColor
            __v_raw.sheetDarkColor = value
            _tRS(__v_raw, "sheetDarkColor", oldValue, value)
        }
    override var sheetDarkBorderColor: UTSArray<String>
        get() {
            return _tRG(__v_raw, "sheetDarkBorderColor", __v_raw.sheetDarkBorderColor, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("sheetDarkBorderColor")) {
                return
            }
            val oldValue = __v_raw.sheetDarkBorderColor
            __v_raw.sheetDarkBorderColor = value
            _tRS(__v_raw, "sheetDarkBorderColor", oldValue, value)
        }
    override var inputDarkColor: String
        get() {
            return _tRG(__v_raw, "inputDarkColor", __v_raw.inputDarkColor, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("inputDarkColor")) {
                return
            }
            val oldValue = __v_raw.inputDarkColor
            __v_raw.inputDarkColor = value
            _tRS(__v_raw, "inputDarkColor", oldValue, value)
        }
    override var inputBgColor: String
        get() {
            return _tRG(__v_raw, "inputBgColor", __v_raw.inputBgColor, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("inputBgColor")) {
                return
            }
            val oldValue = __v_raw.inputBgColor
            __v_raw.inputBgColor = value
            _tRS(__v_raw, "inputBgColor", oldValue, value)
        }
    override var placeholderStyle: String
        get() {
            return _tRG(__v_raw, "placeholderStyle", __v_raw.placeholderStyle, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("placeholderStyle")) {
                return
            }
            val oldValue = __v_raw.placeholderStyle
            __v_raw.placeholderStyle = value
            _tRS(__v_raw, "placeholderStyle", oldValue, value)
        }
    override var borderDarkColor: String
        get() {
            return _tRG(__v_raw, "borderDarkColor", __v_raw.borderDarkColor, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("borderDarkColor")) {
                return
            }
            val oldValue = __v_raw.borderDarkColor
            __v_raw.borderDarkColor = value
            _tRS(__v_raw, "borderDarkColor", oldValue, value)
        }
    override var inputRadius: String
        get() {
            return _tRG(__v_raw, "inputRadius", __v_raw.inputRadius, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("inputRadius")) {
                return
            }
            val oldValue = __v_raw.inputRadius
            __v_raw.inputRadius = value
            _tRS(__v_raw, "inputRadius", oldValue, value)
        }
    override var inputFocusBorder: UTSArray<String>
        get() {
            return _tRG(__v_raw, "inputFocusBorder", __v_raw.inputFocusBorder, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("inputFocusBorder")) {
                return
            }
            val oldValue = __v_raw.inputFocusBorder
            __v_raw.inputFocusBorder = value
            _tRS(__v_raw, "inputFocusBorder", oldValue, value)
        }
    override var buttonRadius: String
        get() {
            return _tRG(__v_raw, "buttonRadius", __v_raw.buttonRadius, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("buttonRadius")) {
                return
            }
            val oldValue = __v_raw.buttonRadius
            __v_raw.buttonRadius = value
            _tRS(__v_raw, "buttonRadius", oldValue, value)
        }
    override var tagRadius: String
        get() {
            return _tRG(__v_raw, "tagRadius", __v_raw.tagRadius, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("tagRadius")) {
                return
            }
            val oldValue = __v_raw.tagRadius
            __v_raw.tagRadius = value
            _tRS(__v_raw, "tagRadius", oldValue, value)
        }
    override var cellRadius: String
        get() {
            return _tRG(__v_raw, "cellRadius", __v_raw.cellRadius, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("cellRadius")) {
                return
            }
            val oldValue = __v_raw.cellRadius
            __v_raw.cellRadius = value
            _tRS(__v_raw, "cellRadius", oldValue, value)
        }
    override var cellMargin: UTSArray<String>
        get() {
            return _tRG(__v_raw, "cellMargin", __v_raw.cellMargin, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("cellMargin")) {
                return
            }
            val oldValue = __v_raw.cellMargin
            __v_raw.cellMargin = value
            _tRS(__v_raw, "cellMargin", oldValue, value)
        }
    override var sheetRadius: UTSArray<String>
        get() {
            return _tRG(__v_raw, "sheetRadius", __v_raw.sheetRadius, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("sheetRadius")) {
                return
            }
            val oldValue = __v_raw.sheetRadius
            __v_raw.sheetRadius = value
            _tRS(__v_raw, "sheetRadius", oldValue, value)
        }
    override var sheetMargin: UTSArray<String>
        get() {
            return _tRG(__v_raw, "sheetMargin", __v_raw.sheetMargin, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("sheetMargin")) {
                return
            }
            val oldValue = __v_raw.sheetMargin
            __v_raw.sheetMargin = value
            _tRS(__v_raw, "sheetMargin", oldValue, value)
        }
    override var sheetPadding: UTSArray<String>
        get() {
            return _tRG(__v_raw, "sheetPadding", __v_raw.sheetPadding, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("sheetPadding")) {
                return
            }
            val oldValue = __v_raw.sheetPadding
            __v_raw.sheetPadding = value
            _tRS(__v_raw, "sheetPadding", oldValue, value)
        }
    override var drawerRadius: String
        get() {
            return _tRG(__v_raw, "drawerRadius", __v_raw.drawerRadius, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("drawerRadius")) {
                return
            }
            val oldValue = __v_raw.drawerRadius
            __v_raw.drawerRadius = value
            _tRS(__v_raw, "drawerRadius", oldValue, value)
        }
    override var modalRadius: String
        get() {
            return _tRG(__v_raw, "modalRadius", __v_raw.modalRadius, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("modalRadius")) {
                return
            }
            val oldValue = __v_raw.modalRadius
            __v_raw.modalRadius = value
            _tRS(__v_raw, "modalRadius", oldValue, value)
        }
    override var switchRadius: String
        get() {
            return _tRG(__v_raw, "switchRadius", __v_raw.switchRadius, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("switchRadius")) {
                return
            }
            val oldValue = __v_raw.switchRadius
            __v_raw.switchRadius = value
            _tRS(__v_raw, "switchRadius", oldValue, value)
        }
    override var progressRadius: String
        get() {
            return _tRG(__v_raw, "progressRadius", __v_raw.progressRadius, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("progressRadius")) {
                return
            }
            val oldValue = __v_raw.progressRadius
            __v_raw.progressRadius = value
            _tRS(__v_raw, "progressRadius", oldValue, value)
        }
    override var unRadioAndCheckBoxColor: String
        get() {
            return _tRG(__v_raw, "unRadioAndCheckBoxColor", __v_raw.unRadioAndCheckBoxColor, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("unRadioAndCheckBoxColor")) {
                return
            }
            val oldValue = __v_raw.unRadioAndCheckBoxColor
            __v_raw.unRadioAndCheckBoxColor = value
            _tRS(__v_raw, "unRadioAndCheckBoxColor", oldValue, value)
        }
    override var radioButtonRadius: String
        get() {
            return _tRG(__v_raw, "radioButtonRadius", __v_raw.radioButtonRadius, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("radioButtonRadius")) {
                return
            }
            val oldValue = __v_raw.radioButtonRadius
            __v_raw.radioButtonRadius = value
            _tRS(__v_raw, "radioButtonRadius", oldValue, value)
        }
    override var animationFun: String
        get() {
            return _tRG(__v_raw, "animationFun", __v_raw.animationFun, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("animationFun")) {
                return
            }
            val oldValue = __v_raw.animationFun
            __v_raw.animationFun = value
            _tRS(__v_raw, "animationFun", oldValue, value)
        }
    override var cardRound: String
        get() {
            return _tRG(__v_raw, "cardRound", __v_raw.cardRound, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("cardRound")) {
                return
            }
            val oldValue = __v_raw.cardRound
            __v_raw.cardRound = value
            _tRS(__v_raw, "cardRound", oldValue, value)
        }
    override var closeIcon: String
        get() {
            return _tRG(__v_raw, "closeIcon", __v_raw.closeIcon, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("closeIcon")) {
                return
            }
            val oldValue = __v_raw.closeIcon
            __v_raw.closeIcon = value
            _tRS(__v_raw, "closeIcon", oldValue, value)
        }
}
typealias xTweenStatus = Number
typealias xTweenCallbackFunType = (x: Number) -> Number
open class xTweenEventCallFunType (
    @JsonNotNull
    open var id: String,
    open var ease: xTweenCallbackFunType? = null,
    @JsonNotNull
    open var status: xTweenStatus,
    @JsonNotNull
    open var duration: Number,
    @JsonNotNull
    open var progress: Number,
    @JsonNotNull
    open var oldProgeress: Number,
    @JsonNotNull
    open var startTime: Number,
    @JsonNotNull
    open var autoRemove: Boolean = false,
    @JsonNotNull
    open var complete: xTweenEventCall,
    @JsonNotNull
    open var enter: xTweenEventCall,
    @JsonNotNull
    open var start: xTweenEventCall,
    @JsonNotNull
    open var pause: xTweenEventCall,
    @JsonNotNull
    open var loop: Number,
    @JsonNotNull
    open var tyty: Boolean = false,
    @JsonNotNull
    open var step: Number,
    @JsonNotNull
    open var _finishLoop: Number,
    @JsonNotNull
    open var reverse: Boolean = false,
) : UTSObject()
typealias xTweenEventCall = (item: xTweenEventCallFunType) -> Unit
open class xTweenAnimate (
    open var complete: xTweenEventCall? = null,
    open var enter: xTweenEventCall? = null,
    open var start: xTweenEventCall? = null,
    open var pause: xTweenEventCall? = null,
    open var ease: Any? = null,
    @JsonNotNull
    open var duration: Number,
    open var autoRemove: Boolean? = null,
    open var loop: Number? = null,
    open var tyty: Boolean? = null,
    open var step: Number? = null,
) : UTSObject()
open class XTREEFLAT_NODES (
    @JsonNotNull
    open var title: String,
    open var id: Any? = null,
    open var fontColor: String? = null,
    open var bgColor: String? = null,
    open var padding: Number? = null,
    open var gutter: Number? = null,
    open var parentLineGutter: Number? = null,
    open var opened: Boolean? = null,
    open var disabled: Boolean? = null,
    open var selected: Boolean? = null,
    open var fontSize: Number? = null,
    open var children: UTSArray<XTREEFLAT_NODES>? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return XTREEFLAT_NODESReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class XTREEFLAT_NODESReactiveObject : XTREEFLAT_NODES, IUTSReactive<XTREEFLAT_NODES> {
    override var __v_raw: XTREEFLAT_NODES
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: XTREEFLAT_NODES, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(title = __v_raw.title, id = __v_raw.id, fontColor = __v_raw.fontColor, bgColor = __v_raw.bgColor, padding = __v_raw.padding, gutter = __v_raw.gutter, parentLineGutter = __v_raw.parentLineGutter, opened = __v_raw.opened, disabled = __v_raw.disabled, selected = __v_raw.selected, fontSize = __v_raw.fontSize, children = __v_raw.children) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): XTREEFLAT_NODESReactiveObject {
        return XTREEFLAT_NODESReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var title: String
        get() {
            return _tRG(__v_raw, "title", __v_raw.title, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("title")) {
                return
            }
            val oldValue = __v_raw.title
            __v_raw.title = value
            _tRS(__v_raw, "title", oldValue, value)
        }
    override var id: Any?
        get() {
            return _tRG(__v_raw, "id", __v_raw.id, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("id")) {
                return
            }
            val oldValue = __v_raw.id
            __v_raw.id = value
            _tRS(__v_raw, "id", oldValue, value)
        }
    override var fontColor: String?
        get() {
            return _tRG(__v_raw, "fontColor", __v_raw.fontColor, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("fontColor")) {
                return
            }
            val oldValue = __v_raw.fontColor
            __v_raw.fontColor = value
            _tRS(__v_raw, "fontColor", oldValue, value)
        }
    override var bgColor: String?
        get() {
            return _tRG(__v_raw, "bgColor", __v_raw.bgColor, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("bgColor")) {
                return
            }
            val oldValue = __v_raw.bgColor
            __v_raw.bgColor = value
            _tRS(__v_raw, "bgColor", oldValue, value)
        }
    override var padding: Number?
        get() {
            return _tRG(__v_raw, "padding", __v_raw.padding, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("padding")) {
                return
            }
            val oldValue = __v_raw.padding
            __v_raw.padding = value
            _tRS(__v_raw, "padding", oldValue, value)
        }
    override var gutter: Number?
        get() {
            return _tRG(__v_raw, "gutter", __v_raw.gutter, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("gutter")) {
                return
            }
            val oldValue = __v_raw.gutter
            __v_raw.gutter = value
            _tRS(__v_raw, "gutter", oldValue, value)
        }
    override var parentLineGutter: Number?
        get() {
            return _tRG(__v_raw, "parentLineGutter", __v_raw.parentLineGutter, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("parentLineGutter")) {
                return
            }
            val oldValue = __v_raw.parentLineGutter
            __v_raw.parentLineGutter = value
            _tRS(__v_raw, "parentLineGutter", oldValue, value)
        }
    override var opened: Boolean?
        get() {
            return _tRG(__v_raw, "opened", __v_raw.opened, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("opened")) {
                return
            }
            val oldValue = __v_raw.opened
            __v_raw.opened = value
            _tRS(__v_raw, "opened", oldValue, value)
        }
    override var disabled: Boolean?
        get() {
            return _tRG(__v_raw, "disabled", __v_raw.disabled, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("disabled")) {
                return
            }
            val oldValue = __v_raw.disabled
            __v_raw.disabled = value
            _tRS(__v_raw, "disabled", oldValue, value)
        }
    override var selected: Boolean?
        get() {
            return _tRG(__v_raw, "selected", __v_raw.selected, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("selected")) {
                return
            }
            val oldValue = __v_raw.selected
            __v_raw.selected = value
            _tRS(__v_raw, "selected", oldValue, value)
        }
    override var fontSize: Number?
        get() {
            return _tRG(__v_raw, "fontSize", __v_raw.fontSize, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("fontSize")) {
                return
            }
            val oldValue = __v_raw.fontSize
            __v_raw.fontSize = value
            _tRS(__v_raw, "fontSize", oldValue, value)
        }
    override var children: UTSArray<XTREEFLAT_NODES>?
        get() {
            return _tRG(__v_raw, "children", __v_raw.children, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("children")) {
                return
            }
            val oldValue = __v_raw.children
            __v_raw.children = value
            _tRS(__v_raw, "children", oldValue, value)
        }
}
open class XTreeFlatOpts (
    open var bgColor: String? = null,
    open var nodeBgColor: String? = null,
    open var fontColor: String? = null,
    open var fontSize: Number? = null,
    open var lineColor: String? = null,
    open var lineWidth: Number? = null,
    open var padding: Number? = null,
    open var gutter: Number? = null,
    open var parentLineGutter: Number? = null,
    open var enbleOpenChildren: Boolean? = null,
    open var nodeRadius: Number? = null,
    open var layout: String? = null,
    open var lineType: String? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return XTreeFlatOptsReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class XTreeFlatOptsReactiveObject : XTreeFlatOpts, IUTSReactive<XTreeFlatOpts> {
    override var __v_raw: XTreeFlatOpts
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: XTreeFlatOpts, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(bgColor = __v_raw.bgColor, nodeBgColor = __v_raw.nodeBgColor, fontColor = __v_raw.fontColor, fontSize = __v_raw.fontSize, lineColor = __v_raw.lineColor, lineWidth = __v_raw.lineWidth, padding = __v_raw.padding, gutter = __v_raw.gutter, parentLineGutter = __v_raw.parentLineGutter, enbleOpenChildren = __v_raw.enbleOpenChildren, nodeRadius = __v_raw.nodeRadius, layout = __v_raw.layout, lineType = __v_raw.lineType) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): XTreeFlatOptsReactiveObject {
        return XTreeFlatOptsReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var bgColor: String?
        get() {
            return _tRG(__v_raw, "bgColor", __v_raw.bgColor, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("bgColor")) {
                return
            }
            val oldValue = __v_raw.bgColor
            __v_raw.bgColor = value
            _tRS(__v_raw, "bgColor", oldValue, value)
        }
    override var nodeBgColor: String?
        get() {
            return _tRG(__v_raw, "nodeBgColor", __v_raw.nodeBgColor, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("nodeBgColor")) {
                return
            }
            val oldValue = __v_raw.nodeBgColor
            __v_raw.nodeBgColor = value
            _tRS(__v_raw, "nodeBgColor", oldValue, value)
        }
    override var fontColor: String?
        get() {
            return _tRG(__v_raw, "fontColor", __v_raw.fontColor, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("fontColor")) {
                return
            }
            val oldValue = __v_raw.fontColor
            __v_raw.fontColor = value
            _tRS(__v_raw, "fontColor", oldValue, value)
        }
    override var fontSize: Number?
        get() {
            return _tRG(__v_raw, "fontSize", __v_raw.fontSize, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("fontSize")) {
                return
            }
            val oldValue = __v_raw.fontSize
            __v_raw.fontSize = value
            _tRS(__v_raw, "fontSize", oldValue, value)
        }
    override var lineColor: String?
        get() {
            return _tRG(__v_raw, "lineColor", __v_raw.lineColor, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("lineColor")) {
                return
            }
            val oldValue = __v_raw.lineColor
            __v_raw.lineColor = value
            _tRS(__v_raw, "lineColor", oldValue, value)
        }
    override var lineWidth: Number?
        get() {
            return _tRG(__v_raw, "lineWidth", __v_raw.lineWidth, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("lineWidth")) {
                return
            }
            val oldValue = __v_raw.lineWidth
            __v_raw.lineWidth = value
            _tRS(__v_raw, "lineWidth", oldValue, value)
        }
    override var padding: Number?
        get() {
            return _tRG(__v_raw, "padding", __v_raw.padding, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("padding")) {
                return
            }
            val oldValue = __v_raw.padding
            __v_raw.padding = value
            _tRS(__v_raw, "padding", oldValue, value)
        }
    override var gutter: Number?
        get() {
            return _tRG(__v_raw, "gutter", __v_raw.gutter, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("gutter")) {
                return
            }
            val oldValue = __v_raw.gutter
            __v_raw.gutter = value
            _tRS(__v_raw, "gutter", oldValue, value)
        }
    override var parentLineGutter: Number?
        get() {
            return _tRG(__v_raw, "parentLineGutter", __v_raw.parentLineGutter, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("parentLineGutter")) {
                return
            }
            val oldValue = __v_raw.parentLineGutter
            __v_raw.parentLineGutter = value
            _tRS(__v_raw, "parentLineGutter", oldValue, value)
        }
    override var enbleOpenChildren: Boolean?
        get() {
            return _tRG(__v_raw, "enbleOpenChildren", __v_raw.enbleOpenChildren, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("enbleOpenChildren")) {
                return
            }
            val oldValue = __v_raw.enbleOpenChildren
            __v_raw.enbleOpenChildren = value
            _tRS(__v_raw, "enbleOpenChildren", oldValue, value)
        }
    override var nodeRadius: Number?
        get() {
            return _tRG(__v_raw, "nodeRadius", __v_raw.nodeRadius, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("nodeRadius")) {
                return
            }
            val oldValue = __v_raw.nodeRadius
            __v_raw.nodeRadius = value
            _tRS(__v_raw, "nodeRadius", oldValue, value)
        }
    override var layout: String?
        get() {
            return _tRG(__v_raw, "layout", __v_raw.layout, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("layout")) {
                return
            }
            val oldValue = __v_raw.layout
            __v_raw.layout = value
            _tRS(__v_raw, "layout", oldValue, value)
        }
    override var lineType: String?
        get() {
            return _tRG(__v_raw, "lineType", __v_raw.lineType, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("lineType")) {
                return
            }
            val oldValue = __v_raw.lineType
            __v_raw.lineType = value
            _tRS(__v_raw, "lineType", oldValue, value)
        }
}
open class Tmui4xOptions (
    open var config: UTSJSONObject? = null,
    open var i18nOptions: I18nOptions? = null,
) : UTSObject()
fun createI18n(args: I18nOptions? = null): Tmui4xI18n {
    return Tmui4xI18n(args)
}
var globalI18nInstans: Tmui4xI18n = createI18n()
val tmxI18n = definePlugin(VuePlugin(install = fun(app: VueApp, config: Any?) {
    globalI18nInstans = createI18n(config as I18nOptions?)
    app.config.globalProperties["\$i18n"] = true
}
))
val tmui4x: UTSJSONObject = _uO("cancel" to "Cancel", "confirm" to "Confirm", "success" to "Success", "fail" to "Failed", "warn" to "Warning", "info" to "Info", "clear" to "Clear", "pickerTitle" to "Please select", "calendar" to _uO("year" to "Year", "month" to "Month", "day" to "Day", "hour" to "Hour", "minute" to "Minute", "second" to "Second", "titleCurrentMonth" to "{0} {1}", "monthCountSelected" to "{count} months", "selectedStatus" to "{count} days selected | No date selected | Selected | End date not selected", "rangStatus" to "Start | End | Today", "tips" to "Max {count} days", "currentMonthTitle" to "This month", "week" to "Mon | Tue | Wed | Thu | Fri | Sat | Sun"), "betweentTime" to _uO("start" to "Start time", "end" to "End time", "quiakListTitle" to "Today | This week | This month | This year | This quarter", "quiakListTitle2" to "Last {count} days", "quiakListTitle3" to "Previous {count} years", "title" to "Please select time", "splite" to "to"), "uploadFile" to _uO("title" to "Select file", "uploadStatus" to "Pending upload | Uploading... | Upload failed | Upload successful | Exceeds size", "tips1" to "Deletion prohibited during upload", "tips2" to "Deletion prohibited for uploaded files"), "pickerSelected" to _uO("placeholder" to "Please enter keywords", "search" to "Search", "selected" to "{count} items selected", "claer" to "Clear selection", "selectedMode" to "Currently in single selection mode", "selectedALl" to "Select all"), "tree" to _uO("changeTitle" to "Modify content", "addTitle" to "Add subordinate", "inputTitle" to "Title", "inputId" to "Identifier ID", "inputTips1" to "Do not repeat, auto-generate when empty"), "input" to _uO("placeholder" to "Please select or fill in"), "inputTag" to _uO("placeholder" to "Please enter and press Enter", "tips" to "Cannot be empty", "tips2" to "Exceeds maximum limit: {count}", "btnText" to "Add Tag"), "keyboard" to _uO("placeholder" to "Safe keyboard for secure input", "space" to "Space", "confirm" to "Confirm"), "pickerTime" to _uO("hour" to "Hour", "minute" to "Minute", "second" to "Second"), "cascader" to _uO("placeholder" to "Please select", "currentPlaceholder" to "Select current"), "pickerDate" to _uO("placeholder" to "Please select time", "year" to "Year", "month" to "Month", "day" to "Day", "hour" to "Hour", "minute" to "Minute", "second" to "Second"), "uploadMedia" to _uO("tips1" to "Dragging sort not allowed during upload", "videoPreview" to "Video preview", "close" to "Close", "systemError" to "System error", "limitMaxCount" to "Exceeded max upload count", "uploadStatus" to "Pending upload | Uploading... | Upload failed | Upload successful | Exceeds size"), "checkbox" to _uO("tips" to "Exceeds maximum selection"), "weekbar" to _uO("week" to "Mon | Tue | Wed | Thu | Fri | Sat | Sun"), "pagination" to _uO("prev" to "Previous", "next" to "Next"), "search" to _uO("placeholder" to "Enter keywords", "cancel" to "Cancel"), "xmore" to _uO("off" to "Expand more", "on" to "Collapse more"), "empty" to _uO("moreLabel" to "No more data", "errorLabel" to "Error~", "btnLabel" to "Retry", "title" to "No data"), "xloading" to _uO("label" to "Loading..."), "actionModal" to _uO("title" to "Reminder", "btnText" to "Confirm"), "actionMenu" to _uO("title" to "Please select", "btnText" to "Confirm"), "pullRefresh" to _uO("status_1" to "Refreshing", "status_2" to "Pull down more", "status_3" to "Release to refresh", "status_4" to "Refresh done", "status_5" to "Refresh failed"), "virtualList" to _uO("status_0" to "Pull down more", "status_1" to "Release to refresh", "status_2" to "Refreshing", "status_3" to "Cancel refresh", "status_4" to "Refresh timeout, retry", "status_5" to "Refresh done"), "imageResize" to _uO("ok" to "Done", "cancel" to "Cancel", "reset" to "Reset"), "colorView" to _uO("rgb" to "RGB", "hub" to "Spectrum", "grid" to "Palette", "alpha" to "Alpha", "hex" to "HEX", "r" to "Red", "g" to "Green", "b" to "Blue"), "modal" to _uO("title" to "Title"), "mention" to _uO("placeholder" to "Enter content, @select friend, press confirm"), "slideVerify" to _uO("tipsText" to "Drag to position", "tipsTextSuccess" to "Verified", "tipsTextFail" to "Verification failed"), "xRequest" to _uO("error" to "Server error:", "success" to "Success", "hostFailEmpty" to "Domain empty", "loading" to "Loading"))
val `default`: UTSJSONObject = _uO("tmui4x" to tmui4x)
val tmui4x__1: UTSJSONObject = _uO("cancel" to "取消", "confirm" to "确认", "success" to "成功", "fail" to "失败", "warn" to "警告", "info" to "提醒", "clear" to "清空", "pickerTitle" to "请选择", "calendar" to _uO("year" to "年", "month" to "月", "day" to "日", "hour" to "时", "minute" to "分", "second" to "秒", "titleCurrentMonth" to "{0}年{1}月", "monthCountSelected" to "{count}月", "selectedStatus" to "已选择{count}日 | 未选择日期 | 已选择 | 未选择结束日期", "rangStatus" to "开始 | 结束 | 本日", "tips" to "最大选择{count}日", "currentMonthTitle" to "本月", "week" to "周一 | 周二 | 周三 | 周四 | 周五 | 周六 | 周日"), "betweentTime" to _uO("start" to "开始时间", "end" to "结束时间", "quiakListTitle" to "本日 | 本周 | 本月 | 本年 | 本季度", "quiakListTitle2" to "最近{count}天", "quiakListTitle3" to "前{count}年", "title" to "请选择时间", "splite" to "至"), "uploadFile" to _uO("title" to "选择文件", "uploadStatus" to "待上传 | 上传中... | 上传失败 | 上传成功 | 超过大小", "tips1" to "上传中禁止删除", "tips2" to "已上传文件禁止删除"), "pickerSelected" to _uO("placeholder" to "请输入关键词", "search" to "搜索", "selected" to "已选择{count}项", "claer" to "清空选择", "selectedMode" to "当前为单选模式", "selectedALl" to "选择所有"), "tree" to _uO("changeTitle" to "修改内容", "addTitle" to "添加下级", "inputTitle" to "标题", "inputId" to "标识ID", "inputTips1" to "不要重复,空时自动生成"), "input" to _uO("placeholder" to "请选择或者填写"), "inputTag" to _uO("placeholder" to "请输入并回车", "tips" to "不能为空", "tips2" to "超过限制最大数:{count}", "btnText" to "添加标签"), "keyboard" to _uO("placeholder" to "安全键盘放心输入", "space" to "空格", "confirm" to "确认"), "pickerTime" to _uO("hour" to "小时", "minute" to "分钟", "second" to "秒数"), "cascader" to _uO("placeholder" to "请选择", "currentPlaceholder" to "选择本级"), "pickerDate" to _uO("placeholder" to "请选择时间", "year" to "年", "month" to "月", "day" to "日", "hour" to "时", "minute" to "分", "second" to "秒"), "uploadMedia" to _uO("tips1" to "上传中不允许拖动排序", "videoPreview" to "视频预览", "close" to "关闭", "systemError" to "系统异常", "limitMaxCount" to "已超最大上传数量", "uploadStatus" to "待上传 | 上传中... | 上传失败 | 上传成功 | 超过大小"), "checkbox" to _uO("tips" to "超过最大选择"), "weekbar" to _uO("week" to "周一 | 周二 | 周三 | 周四 | 周五 | 周六 | 周日"), "pagination" to _uO("prev" to "上一页", "next" to "下一页"), "search" to _uO("placeholder" to "请输入关键词", "cancel" to "取消"), "xmore" to _uO("off" to "展开更多", "on" to "收起更多"), "empty" to _uO("moreLabel" to "没有更多数据啦", "errorLabel" to "出错啦~", "btnLabel" to "点击重试", "title" to "当前没有数据"), "xloading" to _uO("label" to "加载中..."), "actionModal" to _uO("title" to "提醒", "btnText" to "确认"), "actionMenu" to _uO("title" to "请选择", "btnText" to "确认"), "pullRefresh" to _uO("status_1" to "正在刷新", "status_2" to "继续下拉", "status_3" to "松开刷新", "status_4" to "刷新完成", "status_5" to "刷新失败"), "virtualList" to _uO("status_0" to "继续下拉", "status_1" to "松开刷新", "status_2" to "刷新中", "status_3" to "取消刷新", "status_4" to "刷新超时,点击重试", "status_5" to "刷新完成"), "imageResize" to _uO("ok" to "完成", "cancel" to "取消", "reset" to "还原"), "colorView" to _uO("rgb" to "RGB", "hub" to "光谱", "grid" to "色卡", "alpha" to "透明度", "hex" to "HEX", "r" to "红色", "g" to "绿色", "b" to "蓝色"), "modal" to _uO("title" to "标题"), "mention" to _uO("placeholder" to "请输入内容，@选择朋友,按确认完成"), "slideVerify" to _uO("tipsText" to "请拖动到指定位置", "tipsTextSuccess" to "验证成功", "tipsTextFail" to "验证失败"), "xRequest" to _uO("error" to "服务器错误:", "success" to "操作成功", "hostFailEmpty" to "未填请求域名", "loading" to "加载中"))
val default__1: UTSJSONObject = _uO("tmui4x" to tmui4x__1)
val tmui4x__2: UTSJSONObject = _uO("cancel" to "取消", "confirm" to "確認", "success" to "成功", "fail" to "失敗", "warn" to "警告", "info" to "提醒", "clear" to "清空", "pickerTitle" to "請選擇", "calendar" to _uO("year" to "年", "month" to "月", "day" to "日", "hour" to "時", "minute" to "分", "second" to "秒", "titleCurrentMonth" to "{0}年{1}月", "monthCountSelected" to "{count}月", "selectedStatus" to "已選擇{count}日 | 未選擇日期 | 已選擇 | 未選擇結束日期", "rangStatus" to "開始 | 結束 | 本日", "tips" to "最大選擇{count}日", "currentMonthTitle" to "本月", "week" to "週一 | 週二 | 週三 | 週四 | 週五 | 週六 | 週日"), "betweentTime" to _uO("start" to "開始時間", "end" to "結束時間", "quiakListTitle" to "本日 | 本週 | 本月 | 本年 | 本季度", "quiakListTitle2" to "最近{count}天", "quiakListTitle3" to "前{count}年", "title" to "請選擇時間", "splite" to "至"), "uploadFile" to _uO("title" to "選擇檔案", "uploadStatus" to "待上傳 | 上傳中... | 上傳失敗 | 上傳成功 | 超過大小", "tips1" to "上傳中禁止刪除", "tips2" to "已上傳檔案禁止刪除"), "pickerSelected" to _uO("placeholder" to "請輸入關鍵詞", "search" to "搜尋", "selected" to "已選擇{count}項", "claer" to "清空選擇", "selectedMode" to "當前為單選模式", "selectedALl" to "選擇所有"), "tree" to _uO("changeTitle" to "修改內容", "addTitle" to "添加下級", "inputTitle" to "標題", "inputId" to "標識ID", "inputTips1" to "不要重複，空時自動生成"), "input" to _uO("placeholder" to "請選擇或者填寫"), "inputTag" to _uO("placeholder" to "請輸入並回車", "tips" to "不能為空", "tips2" to "超過限制最大數:{count}", "btnText" to "添加標籤"), "keyboard" to _uO("placeholder" to "安全鍵盤放心輸入", "space" to "空格", "confirm" to "確認"), "pickerTime" to _uO("hour" to "小時", "minute" to "分鐘", "second" to "秒數"), "cascader" to _uO("placeholder" to "請選擇", "currentPlaceholder" to "選擇本級"), "pickerDate" to _uO("placeholder" to "請選擇時間", "year" to "年", "month" to "月", "day" to "日", "hour" to "時", "minute" to "分", "second" to "秒"), "uploadMedia" to _uO("tips1" to "上傳中不允许拖動排序", "videoPreview" to "視頻預覽", "close" to "關閉", "systemError" to "系統異常", "limitMaxCount" to "已超最大上傳數量", "uploadStatus" to "待上傳 | 上傳中... | 上傳失敗 | 上傳成功 | 超過大小"), "checkbox" to _uO("tips" to "超過最大選擇"), "weekbar" to _uO("week" to "週一 | 週二 | 週三 | 週四 | 週五 | 週六 | 週日"), "pagination" to _uO("prev" to "上一頁", "next" to "下一頁"), "search" to _uO("placeholder" to "請輸入關鍵詞", "cancel" to "取消"), "xmore" to _uO("off" to "展開更多", "on" to "收起更多"), "empty" to _uO("moreLabel" to "沒有更多數據啦", "errorLabel" to "出錯啦~", "btnLabel" to "點擊重試", "title" to "當前沒有數據"), "xloading" to _uO("label" to "加載中..."), "actionModal" to _uO("title" to "提醒", "btnText" to "確認"), "actionMenu" to _uO("title" to "請選擇", "btnText" to "確認"), "pullRefresh" to _uO("status_1" to "正在刷新", "status_2" to "繼續下拉", "status_3" to "鬆開刷新", "status_4" to "刷新完成", "status_5" to "刷新失敗"), "virtualList" to _uO("status_0" to "繼續下拉", "status_1" to "鬆開刷新", "status_2" to "刷新中", "status_3" to "取消刷新", "status_4" to "刷新超時,點擊重試", "status_5" to "刷新完成"), "imageResize" to _uO("ok" to "完成", "cancel" to "取消", "reset" to "還原"), "colorView" to _uO("rgb" to "RGB", "hub" to "光譜", "grid" to "色卡", "alpha" to "透明度", "hex" to "HEX", "r" to "紅色", "g" to "綠色", "b" to "藍色"), "modal" to _uO("title" to "標題"), "mention" to _uO("placeholder" to "請輸入內容，@選擇朋友,按確認完成"), "slideVerify" to _uO("tipsText" to "請拖動到指定位置", "tipsTextSuccess" to "驗證成功", "tipsTextFail" to "驗證失敗"), "xRequest" to _uO("error" to "服務器錯誤:", "success" to "操作成功", "hostFailEmpty" to "未填請求域名", "loading" to "加載中"))
val default__2: UTSJSONObject = _uO("tmui4x" to tmui4x__2)
val tmui4x__3: UTSJSONObject = _uO("cancel" to "취소", "confirm" to "확인", "success" to "성공", "fail" to "실패", "warn" to "경고", "info" to "정보", "clear" to "지우기", "pickerTitle" to "선택하세요", "calendar" to _uO("year" to "년", "month" to "월", "day" to "일", "hour" to "시", "minute" to "분", "second" to "초", "titleCurrentMonth" to "{0}년{1}월", "monthCountSelected" to "{count}개월", "selectedStatus" to "선택됨{count}일 | 날짜 미선택 | 선택됨 | 종료일 미선택", "rangStatus" to "시작 | 종료 | 오늘", "tips" to "최대선택{count}일", "currentMonthTitle" to "이번 달", "week" to "월요일 | 화요일 | 수요일 | 목요일 | 금요일 | 토요일 | 일요일"), "betweentTime" to _uO("start" to "시작 시간", "end" to "종료 시간", "quiakListTitle" to "오늘 | 이번 주 | 이번 달 | 올해 | 이번 분기", "quiakListTitle2" to "최근 {count}일", "quiakListTitle3" to "이전 {count}년", "title" to "시간을 선택하세요", "splite" to "부터"), "uploadFile" to _uO("title" to "파일 선택", "uploadStatus" to "업로드 대기 | 업로드 중... | 업로드 실패 | 업로드 성공 | 크기 초과", "tips1" to "업로드 중 삭제 금지", "tips2" to "업로드된 파일 삭제 금지"), "pickerSelected" to _uO("placeholder" to "키워드를 입력하세요", "search" to "검색", "selected" to "선택됨{count}개", "claer" to "선택 지우기", "selectedMode" to "현재 단일 선택 모드", "selectedALl" to "모두 선택"), "tree" to _uO("changeTitle" to "내용 수정", "addTitle" to "하위 추가", "inputTitle" to "제목", "inputId" to "식별 ID", "inputTips1" to "중복하지 마세요, 비어있으면 자동 생성"), "input" to _uO("placeholder" to "선택하거나 입력하세요"), "inputTag" to _uO("placeholder" to "입력 후 엔터를 누르세요", "tips" to "비워둘 수 없습니다", "tips2" to "최대 수 초과:{count}", "btnText" to "태그 추가"), "keyboard" to _uO("placeholder" to "안전한 키보드로 안심 입력", "space" to "스페이스", "confirm" to "확인"), "pickerTime" to _uO("hour" to "시간", "minute" to "분", "second" to "초수"), "cascader" to _uO("placeholder" to "선택하세요", "currentPlaceholder" to "본급 선택"), "pickerDate" to _uO("placeholder" to "시간을 선택하세요", "year" to "년", "month" to "월", "day" to "일", "hour" to "시", "minute" to "분", "second" to "초"), "uploadMedia" to _uO("tips1" to "업로드 중 드래그 정렬 금지", "videoPreview" to "비디오 미리보기", "close" to "닫기", "systemError" to "시스템 이상", "limitMaxCount" to "최대 업로드 수 초과", "uploadStatus" to "업로드 대기 | 업로드 중... | 업로드 실패 | 업로드 성공 | 크기 초과"), "checkbox" to _uO("tips" to "최대 선택 수 초과"), "weekbar" to _uO("week" to "월요일 | 화요일 | 수요일 | 목요일 | 금요일 | 토요일 | 일요일"), "pagination" to _uO("prev" to "이전 페이지", "next" to "다음 페이지"), "search" to _uO("placeholder" to "키워드 입력", "cancel" to "취소"), "xmore" to _uO("off" to "더 펼치기", "on" to "더 접기"), "empty" to _uO("moreLabel" to "데이터 없음", "errorLabel" to "오류", "btnLabel" to "재시도", "title" to "데이터 없음"), "xloading" to _uO("label" to "로드 중..."), "actionModal" to _uO("title" to "리마인더", "btnText" to "확인"), "actionMenu" to _uO("title" to "선택하세요", "btnText" to "확인"), "pullRefresh" to _uO("status_1" to "새로고침 중", "status_2" to "더 아래로 끌기", "status_3" to "놓아서 새로고침", "status_4" to "새로고침 완료", "status_5" to "새로고침 실패"), "virtualList" to _uO("status_0" to "더 아래로 끌기", "status_1" to "놓아서 새로고침", "status_2" to "새로고침 중", "status_3" to "새로고침 취소", "status_4" to "새로고침 타임아웃, 재시도", "status_5" to "새로고침 완료"), "imageResize" to _uO("ok" to "완료", "cancel" to "취소", "reset" to "리셋"), "colorView" to _uO("rgb" to "RGB", "hub" to "스펙트럼", "grid" to "팔레트", "alpha" to "투명도", "hex" to "HEX", "r" to "빨강", "g" to "녹색", "b" to "파랑"), "modal" to _uO("title" to "제목"), "mention" to _uO("placeholder" to "내용 입력, @로 친구 선택, 확인 누르기"), "slideVerify" to _uO("tipsText" to "지정 위치로 드래그", "tipsTextSuccess" to "검증 성공", "tipsTextFail" to "검증 실패"), "xRequest" to _uO("error" to "서버 오류:", "success" to "작업 성공", "hostFailEmpty" to "요청 도메인 미입력", "loading" to "로드 중"))
val default__3: UTSJSONObject = _uO("tmui4x" to tmui4x__3)
val tmui4x__4: UTSJSONObject = _uO("cancel" to "キャンセル", "confirm" to "確認", "success" to "成功", "fail" to "失敗", "warn" to "警告", "info" to "情報", "clear" to "クリア", "pickerTitle" to "選択してください", "calendar" to _uO("year" to "年", "month" to "月", "day" to "日", "hour" to "時", "minute" to "分", "second" to "秒", "titleCurrentMonth" to "{0}年{1}月", "monthCountSelected" to "{count}ヶ月", "selectedStatus" to "選択済み{count}日 | 日付未選択 | 選択済み | 終了日未選択", "rangStatus" to "開始 | 終了 | 本日", "tips" to "最大選択{count}日", "currentMonthTitle" to "今月", "week" to "月曜日 | 火曜日 | 水曜日 | 木曜日 | 金曜日 | 土曜日 | 日曜日"), "betweentTime" to _uO("start" to "開始時間", "end" to "終了時間", "quiakListTitle" to "本日 | 今週 | 今月 | 今年 | 今四半期", "quiakListTitle2" to "最近{count}日", "quiakListTitle3" to "前{count}年", "title" to "時間を選択してください", "splite" to "から"), "uploadFile" to _uO("title" to "ファイルを選択", "uploadStatus" to "アップロード待機 | アップロード中... | アップロード失敗 | アップロード成功 | サイズ超過", "tips1" to "アップロード中は削除禁止", "tips2" to "アップロード済みファイルは削除禁止"), "pickerSelected" to _uO("placeholder" to "キーワードを入力してください", "search" to "検索", "selected" to "選択済み{count}項目", "claer" to "選択をクリア", "selectedMode" to "現在は単一選択モード", "selectedALl" to "すべて選択"), "tree" to _uO("changeTitle" to "内容を変更", "addTitle" to "下位を追加", "inputTitle" to "タイトル", "inputId" to "識別ID", "inputTips1" to "重複しないでください、空の場合は自動生成"), "input" to _uO("placeholder" to "選択または入力してください"), "inputTag" to _uO("placeholder" to "入力してEnterを押してください", "tips" to "空にできません", "tips2" to "制限最大数を超過:{count}", "btnText" to "タグを追加"), "keyboard" to _uO("placeholder" to "安全キーボードで安心入力", "space" to "スペース", "confirm" to "確認"), "pickerTime" to _uO("hour" to "時間", "minute" to "分", "second" to "秒数"), "cascader" to _uO("placeholder" to "選択してください", "currentPlaceholder" to "本級を選択"), "pickerDate" to _uO("placeholder" to "時間を選択してください", "year" to "年", "month" to "月", "day" to "日", "hour" to "時", "minute" to "分", "second" to "秒"), "uploadMedia" to _uO("tips1" to "アップロード中はドラッグソート禁止", "videoPreview" to "ビデオプレビュー", "close" to "閉じる", "systemError" to "システム異常", "limitMaxCount" to "最大アップロード数を超過", "uploadStatus" to "アップロード待機 | アップロード中... | アップロード失敗 | アップロード成功 | サイズ超過"), "checkbox" to _uO("tips" to "最大選択数を超過"), "weekbar" to _uO("week" to "月曜日 | 火曜日 | 水曜日 | 木曜日 | 金曜日 | 土曜日 | 日曜日"), "pagination" to _uO("prev" to "前のページ", "next" to "次のページ"), "search" to _uO("placeholder" to "キーワードを入力", "cancel" to "キャンセル"), "xmore" to _uO("off" to "もっと展開", "on" to "もっと収納"), "empty" to _uO("moreLabel" to "データなし", "errorLabel" to "エラー", "btnLabel" to "リトライ", "title" to "データなし"), "xloading" to _uO("label" to "ロード中..."), "actionModal" to _uO("title" to "リマインダー", "btnText" to "確認"), "actionMenu" to _uO("title" to "選択してください", "btnText" to "確認"), "pullRefresh" to _uO("status_1" to "リフレッシュ中", "status_2" to "さらに下に引っ張る", "status_3" to "離してリフレッシュ", "status_4" to "リフレッシュ完了", "status_5" to "リフレッシュ失敗"), "virtualList" to _uO("status_0" to "さらに下に引っ張る", "status_1" to "離してリフレッシュ", "status_2" to "リフレッシュ中", "status_3" to "リフレッシュキャンセル", "status_4" to "リフレッシュタイムアウト、リトライ", "status_5" to "リフレッシュ完了"), "imageResize" to _uO("ok" to "完了", "cancel" to "キャンセル", "reset" to "リセット"), "colorView" to _uO("rgb" to "RGB", "hub" to "スペクトル", "grid" to "カラーパレット", "alpha" to "透明度", "hex" to "HEX", "r" to "赤", "g" to "緑", "b" to "青"), "modal" to _uO("title" to "タイトル"), "mention" to _uO("placeholder" to "内容を入力、@で友達選択、確認押す"), "slideVerify" to _uO("tipsText" to "指定位置にドラッグ", "tipsTextSuccess" to "検証成功", "tipsTextFail" to "検証失敗"), "xRequest" to _uO("error" to "サーバーエラー:", "success" to "操作成功", "hostFailEmpty" to "リクエストドメイン未入力", "loading" to "ロード中"))
val default__4: UTSJSONObject = _uO("tmui4x" to tmui4x__4)
val messages: UTSJSONObject = _uO("en" to `default`, "zh-Hans" to default__1, "zh-Hant" to default__2, "ko" to default__3, "ja" to default__4)
val _hexReg = UTSRegExp("^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3}|[A-Fa-f0-9]{8})\$", "")
fun getDarkMode(): String {
    var dark = getOsTheme()
    var model = "light" as String
    if (dark == "dark" || dark == "light") {
        model = dark
    }
    var customSetings = uni_getStorageSync("tmuiXuiOsThemeSet")
    if (customSetings != null && customSetings != "auto" && customSetings != "") {
        var dsd = customSetings as String
        if (dark == "dark" || dark == "light") {
            model = dsd as String
        }
    }
    return model
}
val xProvitae = reactive(XPRIVATECONFIG(scrollTop = -1, windowInnerWidth = 0, windowInnerHeight = 0, windowWidth = 0, windowHeight = 0, pageStyle = Map<String, xPageStyle>(), pageReady = false, onLoadOpts = _uO()))
val xConfig = reactive(XCONFIG(theme = Map<String, String>(_uA()), i18n = createI18n(I18nOptions(messages = messages, locale = "zh-Hans")), color = "#0091FF", dark = "auto", designSize = 375, maximumCalculatedSize = 667, unit = "px", language = "zh-Hans", fontScale = 1, fontSize = "16", fontColor = "#1d1d1f", fontDarkColor = "#f5f5f7", navigationBarTextStyleDark = "#ffffff", navigationBarTextStyleLight = "#000000", navigationBarBackgroundColorDark = "#000000", navigationBarBackgroundColorLight = "#f5f5f5", backgroundColorContentDark = "#000000", backgroundColorContentLight = "#f5f5f5", tabarBackgroundColorDark = "#0a0a0a", tabarBackgroundColorLight = "#FFFFFF", sheetDarkColor = "#1c1c1E", sheetDarkBorderColor = _uA(
    "#2c2c2e"
), inputDarkColor = "#2c2c2e", inputBgColor = "#f2f2f7", placeholderStyle = "color:#8e8e93", borderDarkColor = "#2c2c2e", inputRadius = "12", inputFocusBorder = _uA(), buttonRadius = "12", tagRadius = "5", cellRadius = "12", cellMargin = _uA(
    "12px",
    "0",
    "12px",
    "6px"
), sheetRadius = _uA(
    "12"
), sheetMargin = _uA(
    "14",
    "0",
    "14",
    "14"
), sheetPadding = _uA(
    "14"
), drawerRadius = "26", modalRadius = "18", switchRadius = "32", progressRadius = "32", unRadioAndCheckBoxColor = "#8e8e93", radioButtonRadius = "12", animationFun = "cubic-bezier(.42,.38,.15,.93)", cardRound = "12", closeIcon = "close-circle-fill"))
val _rgbPrefixReg = UTSRegExp("^(rgb|RGB|rgba|RGBA)", "")
val _rgbStripReg = UTSRegExp("(?:\\(|\\)|rgba|rgb|RGB|RGBA)*", "g")
val _defaultColorCache = Map<String, String>()
val _themeObjCache = Map<String, UTSJSONObject>()
var _themeCacheVersion = ""
fun isCustomTheme(): Boolean {
    var issettheme = false
    var customSetings = uni_getStorageSync("tmuiXuiOsThemeSet")
    if (customSetings != null) {
        var str = customSetings as String
        if (str == "dark" || str == "light" || str == "auto") {
            issettheme = true
        }
    }
    return issettheme
}
fun getOsTheme(): String {
    var defaultModel = "light" as String
    var str = uni_getSystemInfoSync().osTheme
    if (str != null) {
        defaultModel = str
    }
    return defaultModel
}
fun WebObserveTheme() {
    uni_onOsThemeChange(fun(res: OsThemeChangeResult){
        var customSetings = uni_getStorageSync("tmuiXuiOsThemeSet")
        if (customSetings != "auto") {
            return
        }
        xConfig.dark = res.osTheme
        setThemeDarkModel()
    }
    )
}
fun setThemeDarkModel() {
    setBgBodyColor()
}
val setDarkModel = fun(value: String){
    uni_setStorageSync("tmuiXuiOsThemeSet", value)
    var darkmodl = getDarkMode()
    xConfig.dark = darkmodl
    setThemeDarkModel()
}
fun getDefaultColor(sColor: String): String {
    if (sColor == "") {
        return ""
    }
    val ch0 = sColor.charAt(0)
    if (ch0 == "#") {
        if (_hexReg.test(sColor)) {
            return sColor
        }
        return colors.get("primary")!!
    }
    if ((ch0 == "r" || ch0 == "R") && sColor.indexOf("(") > 2) {
        return sColor
    }
    if (ch0 == "h" && sColor.indexOf("(") > 2) {
        return sColor
    }
    _checkThemeCache()
    val cached = _defaultColorCache.get(sColor)
    if (cached != null) {
        return cached
    }
    var sc = sColor.toLowerCase().trim()
    if (sc != sColor) {
        val cached2 = _defaultColorCache.get(sc)
        if (cached2 != null) {
            _defaultColorCache.set(sColor, cached2)
            return cached2
        }
    }
    var result = colors.get("primary")!!
    var colorhtme = xConfig.theme.get(sc)
    var sco = if (colorhtme == null) {
        colors.get(sc)
    } else {
        colorhtme
    }
    if (UTSAndroid.`typeof`(sco) == "string") {
        result = sco as String
    }
    _defaultColorCache.set(sColor, result)
    if (sc != sColor) {
        _defaultColorCache.set(sc, result)
    }
    return result
}
val xTabbarConfig = reactive(XTABBARCONFIG(tabbarActiveIndex = 0, tabbarHeight = 60, list = _uA<TABBAR_ITEM_INFO>()))
val setConfig = fun(configs: Tmui4xOptions?){
    var localLang = uni_getStorageSync("language") as String?
    if (configs != null && configs?.i18nOptions != null) {
        var opts = configs.i18nOptions!!
        xConfig.i18n = createI18n(opts)
    }
    if (configs != null && configs?.config != null) {
        val config = configs.config!!
        var cfg = config!! as UTSJSONObject
        if (cfg.getString("color") != null && cfg.getString("color") != "") {
            xConfig.color = cfg.getString("color")!!
        }
        if (cfg.getAny("theme") != null) {
            var theme = cfg.getAny("theme")!! as Map<String, String>
            xConfig.theme = theme
        }
        if (cfg.getString("dark") != null && cfg.getString("dark") != "") {
            xConfig.dark = cfg.getString("dark")!! as String
            setDarkModel(xConfig.dark)
        }
        if (cfg.getNumber("designSize") != null) {
            xConfig.designSize = cfg.getNumber("designSize")!!
        }
        if (cfg.getNumber("maximumCalculatedSize") != null) {
            xConfig.maximumCalculatedSize = cfg.getNumber("maximumCalculatedSize")!!
        }
        if (cfg.getString("unit") != null && cfg.getString("unit") != "") {
            xConfig.unit = cfg.getString("unit")!! as String
        }
        if (cfg.getString("language") != null && cfg.getString("language") != "") {
            if (localLang == "" || localLang == null) {
                xConfig.language = cfg.getString("language")!!
                xConfig.i18n.setLocale(xConfig.language)
            } else {
                xConfig.language = localLang!!
                xConfig.i18n.setLocale(localLang!!)
            }
        }
        if (cfg.getString("language") == null || cfg.getString("language") == "") {
            if (localLang != "" && UTSAndroid.`typeof`(localLang) == "string") {
                xConfig.language = localLang!!
                xConfig.i18n.setLocale(localLang!!)
            }
        }
        if (cfg.getNumber("fontScale") != null) {
            xConfig.fontScale = cfg.getNumber("fontScale")!!
        }
        if (cfg.getString("fontSize") != null && cfg.getString("fontSize") != "") {
            xConfig.fontSize = cfg.getString("fontSize")!!
        }
        if (cfg.getString("navigationBarTextStyleDark") != null) {
            xConfig.navigationBarTextStyleDark = cfg.getString("navigationBarTextStyleDark")!!
        }
        if (cfg.getString("navigationBarTextStyleLight") != null) {
            xConfig.navigationBarTextStyleLight = cfg.getString("navigationBarTextStyleLight")!!
        }
        if (cfg.getString("navigationBarBackgroundColorDark") != null) {
            xConfig.navigationBarBackgroundColorDark = cfg.getString("navigationBarBackgroundColorDark")!!
        }
        if (cfg.getString("navigationBarBackgroundColorLight") != null) {
            xConfig.navigationBarBackgroundColorLight = cfg.getString("navigationBarBackgroundColorLight")!!
        }
        if (cfg.getString("backgroundColorContentDark") != null) {
            xConfig.backgroundColorContentDark = cfg.getString("backgroundColorContentDark")!!
        }
        if (cfg.getString("backgroundColorContentLight") != null) {
            xConfig.backgroundColorContentLight = cfg.getString("backgroundColorContentLight")!!
        }
        if (cfg.getString("tabarBackgroundColorDark") != null) {
            xConfig.tabarBackgroundColorDark = cfg.getString("tabarBackgroundColorDark")!!
        }
        if (cfg.getString("tabarBackgroundColorLight") != null) {
            xConfig.tabarBackgroundColorLight = cfg.getString("tabarBackgroundColorLight")!!
        }
        if (cfg.getString("sheetDarkColor") != null) {
            xConfig.sheetDarkColor = cfg.getString("sheetDarkColor")!!
        }
        if (cfg.getString("fontColor") != null) {
            xConfig.fontColor = cfg.getString("fontColor")!!
        }
        if (cfg.getString("fontDarkColor") != null) {
            xConfig.fontDarkColor = cfg.getString("fontDarkColor")!!
        }
        if (cfg.getArray<String>("sheetDarkBorderColor") != null) {
            xConfig.sheetDarkBorderColor = cfg.getArray<String>("sheetDarkBorderColor")!!
        }
        if (cfg.getString("inputDarkColor") != null) {
            xConfig.inputDarkColor = cfg.getString("inputDarkColor")!!
        }
        if (cfg.getString("sheetDarkColor") != null) {
            xConfig.borderDarkColor = cfg.getString("borderDarkColor")!!
        }
        if (cfg.getString("inputRadius") != null) {
            xConfig.inputRadius = cfg.getString("inputRadius")!!
        }
        if (cfg.getArray<String>("inputFocusBorder") != null) {
            xConfig.inputFocusBorder = cfg.getArray<String>("inputFocusBorder")!!
        }
        if (cfg.getString("buttonRadius") != null) {
            xConfig.buttonRadius = cfg.getString("buttonRadius")!!
        }
        if (cfg.getString("tagRadius") != null) {
            xConfig.tagRadius = cfg.getString("tagRadius")!!
        }
        if (cfg.getString("cellRadius") != null) {
            xConfig.cellRadius = cfg.getString("cellRadius")!!
        }
        if (cfg.getArray<String>("sheetRadius") != null) {
            xConfig.sheetRadius = cfg.getArray<String>("sheetRadius")!!
        }
        if (cfg.getArray<String>("sheetMargin") != null) {
            xConfig.sheetMargin = cfg.getArray<String>("sheetMargin")!!
        }
        if (cfg.getArray<String>("sheetPadding") != null) {
            xConfig.sheetPadding = cfg.getArray<String>("sheetPadding")!!
        }
        if (cfg.getString("drawerRadius") != null) {
            xConfig.drawerRadius = cfg.getString("drawerRadius")!!
        }
        if (cfg.getString("modalRadius") != null) {
            xConfig.modalRadius = cfg.getString("modalRadius")!!
        }
        if (cfg.getString("switchRadius") != null) {
            xConfig.switchRadius = cfg.getString("switchRadius")!!
        }
        if (cfg.getString("progressRadius") != null) {
            xConfig.progressRadius = cfg.getString("progressRadius")!!
        }
        if (cfg.getString("unRadioAndCheckBoxColor") != null) {
            xConfig.unRadioAndCheckBoxColor = cfg.getString("unRadioAndCheckBoxColor")!!
        }
        if (cfg.getString("radioButtonRadius") != null) {
            xConfig.radioButtonRadius = cfg.getString("radioButtonRadius")!!
        }
        if (cfg.getString("animationFun") != null) {
            xConfig.animationFun = cfg.getString("animationFun")!!
        }
        if (cfg.getString("cardRound") != null) {
            xConfig.cardRound = cfg.getString("cardRound")!!
        }
        if (cfg.getString("closeIcon") != null) {
            xConfig.closeIcon = cfg.getString("closeIcon")!!
        }
        if (cfg.getString("inputBgColor") != null) {
            xConfig.inputBgColor = cfg.getString("inputBgColor")!!
        }
        if (cfg.getString("placeholderStyle") != null) {
            xConfig.placeholderStyle = cfg.getString("placeholderStyle")!!
        }
        return
    }
    xConfig.language = xConfig.i18n.ops.locale
}
fun _getThemeCacheVersion(): String {
    return xConfig.dark + "|" + xConfig.theme.size.toString(10)
}
fun _checkThemeCache() {
    val ver = _getThemeCacheVersion()
    if (ver != _themeCacheVersion) {
        _themeCacheVersion = ver
        _defaultColorCache.clear()
        _themeObjCache.clear()
    }
}
val colors = Map<String, String>(_uA(
    _uA(
        "primary",
        "#0088FF"
    ),
    _uA(
        "success",
        "#34C759"
    ),
    _uA(
        "danger",
        "#FF8D28"
    ),
    _uA(
        "warn",
        "#F7B500"
    ),
    _uA(
        "error",
        "#FF383C"
    ),
    _uA(
        "info",
        "#F2F2F7"
    ),
    _uA(
        "kleinblue",
        "#002FA7"
    ),
    _uA(
        "chinesered",
        "#FF0000"
    ),
    _uA(
        "internationalorange",
        "#FF4F00"
    ),
    _uA(
        "egyptianvlue",
        "#1034A6"
    ),
    _uA(
        "parisviolet",
        "#6C3082"
    ),
    _uA(
        "moroccanblue",
        "#1256A7"
    ),
    _uA(
        "brazilgreen",
        "#009B3A"
    ),
    _uA(
        "britishracinggreen",
        "#004225"
    ),
    _uA(
        "indianyellow",
        "#E3A857"
    ),
    _uA(
        "australiangold",
        "#FFDF00"
    ),
    _uA(
        "venetianred",
        "#C80815"
    ),
    _uA(
        "majorelleblue",
        "#6050DC"
    ),
    _uA(
        "tuscanred",
        "#7C3030"
    ),
    _uA(
        "naplesyellow",
        "#FADA5E"
    ),
    _uA(
        "capumortuum",
        "#592720"
    ),
    _uA(
        "mayablue",
        "#73C2FB"
    ),
    _uA(
        "persianrose",
        "#FE28A2"
    ),
    _uA(
        "tyrianpurple",
        "#66023C"
    ),
    _uA(
        "saharasand",
        "#F1E788"
    ),
    _uA(
        "burmeseruby",
        "#B00A0A"
    ),
    _uA(
        "transparent",
        "rgba(0,0,0,0)"
    ),
    _uA(
        "aliceblue",
        "#F0F8FF"
    ),
    _uA(
        "antiquewhite",
        "#FAEBD7"
    ),
    _uA(
        "aqua",
        "#00FFFF"
    ),
    _uA(
        "aquamarine",
        "#7FFFD4"
    ),
    _uA(
        "azure",
        "#F0FFFF"
    ),
    _uA(
        "beige",
        "#F5F5DC"
    ),
    _uA(
        "bisque",
        "#FFE4C4"
    ),
    _uA(
        "black",
        "#000000"
    ),
    _uA(
        "blanchedalmond",
        "#FFEBCD"
    ),
    _uA(
        "blue",
        "#0000FF"
    ),
    _uA(
        "blueviolet",
        "#8A2BE2"
    ),
    _uA(
        "brown",
        "#A52A2A"
    ),
    _uA(
        "burlywood",
        "#DEB887"
    ),
    _uA(
        "cadetblue",
        "#5F9EA0"
    ),
    _uA(
        "chartreuse",
        "#7FFF00"
    ),
    _uA(
        "chocolate",
        "#D2691E"
    ),
    _uA(
        "coral",
        "#FF7F50"
    ),
    _uA(
        "cornflowerblue",
        "#6495ED"
    ),
    _uA(
        "cornsilk",
        "#FFF8DC"
    ),
    _uA(
        "crimson",
        "#DC143C"
    ),
    _uA(
        "cyan",
        "#00FFFF"
    ),
    _uA(
        "darkblue",
        "#00008B"
    ),
    _uA(
        "darkcyan",
        "#008B8B"
    ),
    _uA(
        "darkgoldenrod",
        "#B8860B"
    ),
    _uA(
        "darkgray",
        "#A9A9A9"
    ),
    _uA(
        "darkgreen",
        "#006400"
    ),
    _uA(
        "darkkhaki",
        "#BDB76B"
    ),
    _uA(
        "darkmagenta",
        "#8B008B"
    ),
    _uA(
        "darkolivegreen",
        "#556B2F"
    ),
    _uA(
        "darkorange",
        "#FF8C00"
    ),
    _uA(
        "darkorchid",
        "#9932CC"
    ),
    _uA(
        "darkred",
        "#8B0000"
    ),
    _uA(
        "darksalmon",
        "#E9967A"
    ),
    _uA(
        "darkseagreen",
        "#8FBC8F"
    ),
    _uA(
        "darkslateblue",
        "#483D8B"
    ),
    _uA(
        "darkslategray",
        "#2F4F4F"
    ),
    _uA(
        "darkturquoise",
        "#00CED1"
    ),
    _uA(
        "darkviolet",
        "#9400D3"
    ),
    _uA(
        "deeppink",
        "#FF1493"
    ),
    _uA(
        "deepskyblue",
        "#00BFFF"
    ),
    _uA(
        "dimgray",
        "#696969"
    ),
    _uA(
        "dodgerblue",
        "#1E90FF"
    ),
    _uA(
        "firebrick",
        "#B22222"
    ),
    _uA(
        "floralwhite",
        "#FFFAF0"
    ),
    _uA(
        "forestgreen",
        "#228B22"
    ),
    _uA(
        "fuchsia",
        "#FF00FF"
    ),
    _uA(
        "gainsboro",
        "#DCDCDC"
    ),
    _uA(
        "ghostwhite",
        "#F8F8FF"
    ),
    _uA(
        "gold",
        "#FFD700"
    ),
    _uA(
        "goldenrod",
        "#DAA520"
    ),
    _uA(
        "gray",
        "#808080"
    ),
    _uA(
        "green",
        "#008000"
    ),
    _uA(
        "greenyellow",
        "#ADFF2F"
    ),
    _uA(
        "honeydew",
        "#F0FFF0"
    ),
    _uA(
        "hotpink",
        "#FF69B4"
    ),
    _uA(
        "indianred",
        "#CD5C5C"
    ),
    _uA(
        "indigo",
        "#4B0082"
    ),
    _uA(
        "ivory",
        "#FFFFF0"
    ),
    _uA(
        "khaki",
        "#F0E68C"
    ),
    _uA(
        "lavender",
        "#E6E6FA"
    ),
    _uA(
        "lavenderblush",
        "#FFF0F5"
    ),
    _uA(
        "lawngreen",
        "#7CFC00"
    ),
    _uA(
        "lemonchiffon",
        "#FFFACD"
    ),
    _uA(
        "lightblue",
        "#ADD8E6"
    ),
    _uA(
        "lightcoral",
        "#F08080"
    ),
    _uA(
        "lightcyan",
        "#E0FFFF"
    ),
    _uA(
        "lightgoldenrodyellow",
        "#FAFAD2"
    ),
    _uA(
        "lightgray",
        "#D3D3D3"
    ),
    _uA(
        "lightgreen",
        "#90EE90"
    ),
    _uA(
        "lightpink",
        "#FFB6C1"
    ),
    _uA(
        "lightsalmon",
        "#FFA07A"
    ),
    _uA(
        "lightseagreen",
        "#20B2AA"
    ),
    _uA(
        "lightskyblue",
        "#87CEFA"
    ),
    _uA(
        "lightslategray",
        "#778899"
    ),
    _uA(
        "lightsteelblue",
        "#B0C4DE"
    ),
    _uA(
        "lightyellow",
        "#FFFFE0"
    ),
    _uA(
        "lime",
        "#00FF00"
    ),
    _uA(
        "limegreen",
        "#32CD32"
    ),
    _uA(
        "linen",
        "#FAF0E6"
    ),
    _uA(
        "magenta",
        "#FF00FF"
    ),
    _uA(
        "maroon",
        "#800000"
    ),
    _uA(
        "mediumaquamarine",
        "#66CDAA"
    ),
    _uA(
        "mediumblue",
        "#0000CD"
    ),
    _uA(
        "mediumorchid",
        "#BA55D3"
    ),
    _uA(
        "mediumpurple",
        "#9370DB"
    ),
    _uA(
        "mediumseagreen",
        "#3CB371"
    ),
    _uA(
        "mediumslateblue",
        "#7B68EE"
    ),
    _uA(
        "mediumspringgreen",
        "#00FA9A"
    ),
    _uA(
        "mediumturquoise",
        "#48D1CC"
    ),
    _uA(
        "mediumvioletred",
        "#C71585"
    ),
    _uA(
        "midnightblue",
        "#191970"
    ),
    _uA(
        "mintcream",
        "#F5FFFA"
    ),
    _uA(
        "mistyrose",
        "#FFE4E1"
    ),
    _uA(
        "moccasin",
        "#FFE4B5"
    ),
    _uA(
        "navajowhite",
        "#FFDEAD"
    ),
    _uA(
        "navy",
        "#000080"
    ),
    _uA(
        "oldlace",
        "#FDF5E6"
    ),
    _uA(
        "olive",
        "#808000"
    ),
    _uA(
        "olivedrab",
        "#6B8E23"
    ),
    _uA(
        "orange",
        "#FFA500"
    ),
    _uA(
        "orangered",
        "#FF4500"
    ),
    _uA(
        "orchid",
        "#DA70D6"
    ),
    _uA(
        "palegoldenrod",
        "#EEE8AA"
    ),
    _uA(
        "palegreen",
        "#98FB98"
    ),
    _uA(
        "paleturquoise",
        "#AFEEEE"
    ),
    _uA(
        "palevioletred",
        "#DB7093"
    ),
    _uA(
        "papayawhip",
        "#FFEFD5"
    ),
    _uA(
        "peachpuff",
        "#FFDAB9"
    ),
    _uA(
        "peru",
        "#CD853F"
    ),
    _uA(
        "pink",
        "#FFC0CB"
    ),
    _uA(
        "plum",
        "#DDA0DD"
    ),
    _uA(
        "powderblue",
        "#B0E0E6"
    ),
    _uA(
        "purple",
        "#800080"
    ),
    _uA(
        "rebeccapurple",
        "#663399"
    ),
    _uA(
        "red",
        "#FF0000"
    ),
    _uA(
        "rosybrown",
        "#BC8F8F"
    ),
    _uA(
        "royalblue",
        "#4169E1"
    ),
    _uA(
        "saddlebrown",
        "#8B4513"
    ),
    _uA(
        "salmon",
        "#FA8072"
    ),
    _uA(
        "sandybrown",
        "#F4A460"
    ),
    _uA(
        "seagreen",
        "#2E8B57"
    ),
    _uA(
        "seashell",
        "#FFF5EE"
    ),
    _uA(
        "sienna",
        "#A0522D"
    ),
    _uA(
        "silver",
        "#C0C0C0"
    ),
    _uA(
        "skyblue",
        "#87CEEB"
    ),
    _uA(
        "slateblue",
        "#6A5ACD"
    ),
    _uA(
        "slategray",
        "#708090"
    ),
    _uA(
        "snow",
        "#FFFAFA"
    ),
    _uA(
        "springgreen",
        "#00FF7F"
    ),
    _uA(
        "steelblue",
        "#4682B4"
    ),
    _uA(
        "tan",
        "#D2B48C"
    ),
    _uA(
        "teal",
        "#008080"
    ),
    _uA(
        "thistle",
        "#D8BFD8"
    ),
    _uA(
        "tomato",
        "#FF6347"
    ),
    _uA(
        "turquoise",
        "#40E0D0"
    ),
    _uA(
        "violet",
        "#EE82EE"
    ),
    _uA(
        "wheat",
        "#F5DEB3"
    ),
    _uA(
        "white",
        "#FFFFFF"
    ),
    _uA(
        "whitesmoke",
        "#F5F5F5"
    ),
    _uA(
        "yellow",
        "#FFFF00"
    ),
    _uA(
        "yellowgreen",
        "#9ACD32"
    )
))
fun hexToRgb(sColors: String): UTSJSONObject {
    if (sColors == "") {
        return _uO("r" to 0, "g" to 0, "b" to 0, "a" to 0)
    }
    var sColor: String = sColors.toLowerCase()
    if (sColor.charAt(0) == "#" && _hexReg.test(sColor)) {
        if (sColor.length == 4) {
            var sColorNew = "#"
            run {
                var i: Number = 1
                while(i < 4){
                    sColorNew += sColor.slice(i, i + 1).concat(sColor.slice(i, i + 1))
                    i += 1
                }
            }
            sColor = sColorNew
        }
        var r = parseInt(sColor.substring(1, 3), 16)
        var g = parseInt(sColor.substring(3, 5), 16)
        var b = parseInt(sColor.substring(5, 7), 16)
        var a: Number = if (sColor.length == 9) {
            parseInt(sColor.substring(7, 9), 16) / 255
        } else {
            1
        }
        return _uO("r" to r, "g" to g, "b" to b, "a" to a)
    } else if (_rgbPrefixReg.test(sColor)) {
        var arr: UTSArray<String> = sColor.replace(_rgbStripReg, "").split(",")
        var p: UTSArray<Number> = arr.map(fun(kVal: String): Number {
            return parseInt(kVal)
        })
        if (p.length < 3) {
            return _uO("r" to 0, "g" to 0, "b" to 0, "a" to 1)
        }
        if (p.length == 3) {
            arr.push("1")
        }
        return _uO("r" to p[0], "g" to p[1], "b" to p[2], "a" to parseFloat(arr[3]))
    } else {
        return _uO("r" to 0, "g" to 0, "b" to 0, "a" to 1)
    }
}
fun rgbToHsl(rgb: UTSJSONObject): UTSJSONObject {
    var r = rgb.getNumber("r")
    r = r as Number / 255
    var g = rgb.getNumber("g")
    g = g as Number / 255
    var b = rgb.getNumber("b")
    b = b as Number / 255
    var a = rgb.getNumber("a")
    var max = Math.max(r, g, b)
    var min = Math.min(r, g, b)
    var maxmindiff = max - min
    var maxmindiffAdd = max + min
    maxmindiff = maxmindiff.toDouble()
    maxmindiffAdd = maxmindiffAdd.toDouble()
    var h = 60 * (4 + (r - g) / maxmindiff)
    var sdy = 2 - max - min
    sdy = sdy.toDouble()
    var s = (max - min) / sdy
    var l = (max + min) / 2
    if (max === r) {
        h = (60 * (g - b)) / maxmindiff
    } else if (max === g) {
        h = 60 * (2 + (b - r) / maxmindiff)
    }
    if (h < 0) {
        h += 360
    }
    if (max === min) {
        s = 0
    } else if (l < 0.5) {
        s = (max - min) / maxmindiffAdd
    }
    return _uO("h" to h, "s" to (s * 100), "l" to (l * 100), "a" to a)
}
fun hslToRgb(hsl: UTSJSONObject): UTSJSONObject {
    var h = hsl.getNumber("h")!!
    var s = hsl.getNumber("s")!!
    var l = hsl.getNumber("l")!!
    var a = hsl.getNumber("a")!!
    h = h / 360
    s = s / 100
    l = l / 100
    var r = l
    var g = l
    var b = l
    fun hue2rgb(pxx: Number, q: Number, txs: Number): Number {
        var t = txs
        var p = pxx
        if (t < 0) {
            t += 1
        }
        if (t > 1) {
            t -= 1
        }
        if (t < (1 as Number) / 6) {
            return p + (q - p) * 6 * t
        }
        if (t < 0.5) {
            return q
        }
        if (t < (2 as Number) / 3) {
            return p + (q - p) * ((2 as Number) / 3 - t) * 6
        }
        return p
    }
    if (s > 0) {
        var q = l * (1 + s)
        if (l >= 0.5) {
            q = l + s - l * s
        }
        var p = 2 * l - q
        r = hue2rgb(p, q, h + (1 as Number) / 3)
        g = hue2rgb(p, q, h)
        b = hue2rgb(p, q, h - (1 as Number) / 3)
    }
    r = Math.round(r * 255)
    g = Math.round(g * 255)
    b = Math.round(b * 255)
    return _uO("r" to r, "g" to g, "b" to b, "a" to a)
}
fun hslaToRgbCss(hsl: UTSJSONObject): String {
    var rgb = hslToRgb(hsl)
    var r = rgb.getNumber("r")!!
    var g = rgb.getNumber("g")!!
    var b = rgb.getNumber("b")!!
    var a = rgb.getNumber("a")!!
    return "rgba(" + r + "," + g + "," + b + "," + a + ")"
}
fun getLuminance(color: UTSJSONObject, type: String = "rgba"): Number {
    var colordefault: UTSJSONObject = if (type == "rgba") {
        color
    } else {
        hslToRgb(color)
    }
    val r = colordefault.getNumber("r")!!
    val g = colordefault.getNumber("g")!!
    val b = colordefault.getNumber("b")!!
    val rs = r / 255
    val gs = g / 255
    val bs = b / 255
    val rl = Math.pow(if (rs <= 0.03928) {
        rs / 12.92
    } else {
        ((rs + 0.055) / 1.055)
    }
    , 2.4)
    val gl = Math.pow(if (gs <= 0.03928) {
        gs / 12.92
    } else {
        ((gs + 0.055) / 1.055)
    }
    , 2.4)
    val bl = Math.pow(if (bs <= 0.03928) {
        bs / 12.92
    } else {
        ((bs + 0.055) / 1.055)
    }
    , 2.4)
    return 0.2126 * rl + 0.7152 * gl + 0.0722 * bl
}
fun getDefaultColorObj(color: String, hoverColor: String, isCoverDark: Boolean = false): UTSJSONObject {
    var dark = if (isCoverDark == null) {
        false
    } else {
        isCoverDark
    }
    _checkThemeCache()
    val cacheKey = "D|" + color + "|" + hoverColor + "|" + (if (dark) {
        "1"
    } else {
        "0"
    }
    )
    val hit = _themeObjCache.get(cacheKey)
    if (hit != null) {
        return hit
    }
    var hsla: UTSJSONObject = rgbToHsl(hexToRgb(getDefaultColor(color)))
    var hoverHsla: UTSJSONObject = rgbToHsl(hexToRgb(getDefaultColor(hoverColor)))
    var shadow = hslaToRgbCss(_uO("h" to hsla.getNumber("h")!!, "s" to if (hsla.getNumber("s")!! == 0) {
        0
    } else {
        60
    }
    , "l" to 40, "a" to 0.4))
    var shadowHOver = hslaToRgbCss(_uO("h" to hoverHsla.getNumber("h")!!, "s" to if (hoverHsla.getNumber("s")!! == 0) {
        0
    } else {
        60
    }
    , "l" to 40, "a" to 0.4))
    if (hsla.getNumber("h")!! == 0 && hsla.getNumber("s")!! == 0) {
        shadow = "transparent"
    }
    if (hoverHsla.getNumber("h")!! == 0 && hoverHsla.getNumber("s")!! == 0) {
        shadowHOver = "transparent"
    }
    var lightnum = getLuminance(hoverHsla, "hsla")
    var h = hsla.getNumber("h")!!
    var maxLightNum: Number = 0.55
    if (h >= 31 && h <= 90) {
        maxLightNum = 0.60
    }
    var l = hsla.getNumber("l")!!
    var s = hsla.getNumber("s")!!
    var parimaryHsla = hsla
    if (dark && (h != 0 && s != 0)) {
        parimaryHsla.set("l", Math.min(Math.max(0, l - 3), l))
    }
    var o: UTSJSONObject = _uO("default" to _uO("background" to hslaToRgbCss(parimaryHsla), "borderColor" to hslaToRgbCss(_uO("h" to hsla.getNumber("h")!!, "s" to hsla.getNumber("s")!!, "a" to hsla.getNumber("a")!!, "l" to Math.min(Math.max(0, hsla.getNumber("l")!! - 3), hsla.getNumber("l")!!))), "fontColor" to if (lightnum < maxLightNum && hsla.getNumber("a")!! > 0.1) {
        "#ffffff"
    } else {
        "#000000"
    }
    , "shadow" to shadow), "active" to _uO("background" to hslaToRgbCss(_uO("h" to hoverHsla.getNumber("h")!!, "s" to hoverHsla.getNumber("s")!!, "a" to hoverHsla.getNumber("a")!!, "l" to Math.min(Math.max(0, hoverHsla.getNumber("l")!! - 5), hoverHsla.getNumber("l")!!))), "borderColor" to hslaToRgbCss(_uO("h" to hoverHsla.getNumber("h")!!, "s" to hoverHsla.getNumber("s")!!, "a" to hoverHsla.getNumber("a")!!, "l" to Math.max(Math.max(0, hoverHsla.getNumber("l")!! - 10), hoverHsla.getNumber("l")!!))), "fontColor" to if (lightnum < maxLightNum && hoverHsla.getNumber("a")!! > 0.1) {
        "#ffffff"
    } else {
        "#000000"
    }
    , "shadow" to shadowHOver))
    _themeObjCache.set(cacheKey, o)
    return o
}
val hslColorMap = Map<String, UTSArray<Number>>(_uA(
    _uA(
        "红色",
        _uA(
            0,
            30
        )
    ),
    _uA(
        "橙色",
        _uA(
            31,
            60
        )
    ),
    _uA(
        "黄色",
        _uA(
            61,
            90
        )
    ),
    _uA(
        "绿色",
        _uA(
            91,
            150
        )
    ),
    _uA(
        "青色",
        _uA(
            151,
            210
        )
    ),
    _uA(
        "蓝色",
        _uA(
            211,
            270
        )
    ),
    _uA(
        "紫色",
        _uA(
            271,
            330
        )
    ),
    _uA(
        "红色2",
        _uA(
            331,
            360
        )
    )
))
fun getTextColorObj(color: String, hoverColor: String, isCoverDark: Boolean = false): UTSJSONObject {
    var dark = if (isCoverDark == null) {
        false
    } else {
        isCoverDark
    }
    _checkThemeCache()
    val cacheKey = "T|" + color + "|" + hoverColor + "|" + (if (dark) {
        "1"
    } else {
        "0"
    }
    )
    val hit = _themeObjCache.get(cacheKey)
    if (hit != null) {
        return hit
    }
    var hsla: UTSJSONObject = rgbToHsl(hexToRgb(getDefaultColor(color)))
    var hsla2: UTSJSONObject = rgbToHsl(hexToRgb(getDefaultColor(color)))
    var hoverHsla: UTSJSONObject = rgbToHsl(hexToRgb(getDefaultColor(hoverColor)))
    var bgcolor = hslaToRgbCss(_uO("h" to hoverHsla.getNumber("h")!!, "s" to hoverHsla.getNumber("s")!!, "a" to hoverHsla.getNumber("a")!!, "l" to if (dark == true) {
        20
    } else {
        95
    }
    ))
    if (dark) {
        var p = hsla2
        p.set("l", 20)
        p.set("s", if (p.getNumber("s") != 0) {
            0
        } else {
            20
        }
        )
        bgcolor = hslaToRgbCss(p)
    }
    var lightnum = getLuminance(hoverHsla, "hsla")
    var h = hsla.getNumber("h")!!
    var maxLightNum: Number = 0.3
    var o: UTSJSONObject = _uO("default" to _uO("background" to "transparent", "borderColor" to "transparent", "fontColor" to if (lightnum < maxLightNum && hsla.getNumber("a")!! > 0.1) {
        hslaToRgbCss(hsla)
    } else {
        hslaToRgbCss(_uO("h" to hsla.getNumber("h")!!, "s" to hsla.getNumber("s")!!, "a" to hsla.getNumber("a")!!, "l" to 30))
    }
    , "shadow" to "transparent"), "active" to _uO("background" to bgcolor, "borderColor" to "transparent", "fontColor" to if (lightnum < maxLightNum && hoverHsla.getNumber("a")!! > 0.1) {
        hslaToRgbCss(hoverHsla)
    } else {
        hslaToRgbCss(_uO("h" to hoverHsla.getNumber("h")!!, "s" to hoverHsla.getNumber("s")!!, "a" to hoverHsla.getNumber("a")!!, "l" to 30))
    }
    , "shadow" to "transparent"))
    _themeObjCache.set(cacheKey, o)
    return o
}
fun getThinColorObj(color: String, hoverColor: String, isCoverDark: Boolean = false): UTSJSONObject {
    var dark = if (isCoverDark == null) {
        false
    } else {
        isCoverDark
    }
    _checkThemeCache()
    val cacheKey = "H|" + color + "|" + hoverColor + "|" + (if (dark) {
        "1"
    } else {
        "0"
    }
    )
    val hit = _themeObjCache.get(cacheKey)
    if (hit != null) {
        return hit
    }
    var hsla: UTSJSONObject = rgbToHsl(hexToRgb(getDefaultColor(color)))
    var hoverHsla: UTSJSONObject = rgbToHsl(hexToRgb(getDefaultColor(hoverColor)))
    var fontcolor = if (getLuminance(hsla, "hsla") < 0.3 && hsla.getNumber("a")!! > 0.1) {
        hslaToRgbCss(hsla)
    } else {
        hslaToRgbCss(_uO("h" to hsla.getNumber("h")!!, "s" to hsla.getNumber("s")!!, "a" to hsla.getNumber("a")!!, "l" to 30))
    }
    var bordercolor = hslaToRgbCss(_uO("h" to hoverHsla.getNumber("h")!!, "s" to hoverHsla.getNumber("s")!!, "a" to hoverHsla.getNumber("a")!!, "l" to if (dark == true) {
        21
    } else {
        92
    }
    ))
    var bgcolor = hslaToRgbCss(_uO("h" to hoverHsla.getNumber("h")!!, "s" to hoverHsla.getNumber("s")!!, "a" to hoverHsla.getNumber("a")!!, "l" to if (dark == true) {
        20
    } else {
        95
    }
    ))
    var lightnum = getLuminance(hoverHsla, "hsla")
    if (dark) {
        var p = hsla
        p.set("l", 98)
        fontcolor = hslaToRgbCss(p)
        p.set("l", 20)
        p.set("s", if (p.getNumber("s") != 0) {
            5
        } else {
            20
        }
        )
        bgcolor = hslaToRgbCss(p)
        p.set("l", 22)
        bordercolor = hslaToRgbCss(p)
    }
    var o: UTSJSONObject = _uO("default" to _uO("background" to bgcolor, "borderColor" to bordercolor, "fontColor" to fontcolor, "shadow" to "transparent"), "active" to _uO("background" to hslaToRgbCss(_uO("h" to hoverHsla.getNumber("h")!!, "s" to if (dark) {
        10
    } else {
        50
    }
    , "a" to hoverHsla.getNumber("a")!!, "l" to if (dark == true) {
        15
    } else {
        88
    }
    )), "borderColor" to hslaToRgbCss(_uO("h" to hoverHsla.getNumber("h")!!, "s" to hoverHsla.getNumber("s")!!, "a" to 0, "l" to if (dark == true) {
        18
    } else {
        80
    }
    )), "fontColor" to if (lightnum < 0.3 && hoverHsla.getNumber("a")!! > 0.1) {
        hslaToRgbCss(hoverHsla)
    } else {
        hslaToRgbCss(_uO("h" to hoverHsla.getNumber("h")!!, "s" to hoverHsla.getNumber("s")!!, "a" to hoverHsla.getNumber("a")!!, "l" to 64))
    }
    , "shadow" to "transparent"))
    _themeObjCache.set(cacheKey, o)
    return o
}
fun getOutlineColorObj(color: String, hoverColor: String, isCoverDark: Boolean = false): UTSJSONObject {
    var dark = if (isCoverDark == null) {
        false
    } else {
        isCoverDark
    }
    _checkThemeCache()
    val cacheKey = "O|" + color + "|" + hoverColor + "|" + (if (dark) {
        "1"
    } else {
        "0"
    }
    )
    val hit = _themeObjCache.get(cacheKey)
    if (hit != null) {
        return hit
    }
    var hsla: UTSJSONObject = rgbToHsl(hexToRgb(getDefaultColor(color)))
    var hoverHsla: UTSJSONObject = rgbToHsl(hexToRgb(getDefaultColor(hoverColor)))
    var lightnum = getLuminance(hoverHsla, "hsla")
    var h = hsla.getNumber("h")!!
    var borderLight: Number = 70
    if (dark) {
        borderLight = 50
    }
    var o: UTSJSONObject = _uO("default" to _uO("background" to "transparent", "borderColor" to hslaToRgbCss(_uO("h" to hoverHsla.getNumber("h")!!, "s" to hoverHsla.getNumber("s")!!, "a" to 1, "l" to (borderLight + 5))), "fontColor" to if (lightnum < 0.6 && hsla.getNumber("a")!! > 0.1) {
        hslaToRgbCss(hsla)
    } else {
        hslaToRgbCss(_uO("h" to hsla.getNumber("h")!!, "s" to hsla.getNumber("s")!!, "a" to hsla.getNumber("a")!!, "l" to 30))
    }
    , "shadow" to "transparent"), "active" to _uO("background" to "transparent", "borderColor" to hslaToRgbCss(_uO("h" to hoverHsla.getNumber("h")!!, "s" to hoverHsla.getNumber("s")!!, "a" to 1, "l" to borderLight)), "fontColor" to if (lightnum < 0.6 && hoverHsla.getNumber("a")!! > 0.1) {
        hslaToRgbCss(hoverHsla)
    } else {
        hslaToRgbCss(_uO("h" to hoverHsla.getNumber("h")!!, "s" to hoverHsla.getNumber("s")!!, "a" to hoverHsla.getNumber("a")!!, "l" to 30))
    }
    , "shadow" to "transparent"))
    _themeObjCache.set(cacheKey, o)
    return o
}
fun setTextColorLightByDark(color: String): String {
    var realColor = getDefaultColor(color)
    var hsla = rgbToHsl(hexToRgb(realColor))
    var l = hsla.getNumber("l")!!
    var s = hsla.getNumber("s")!!
    if (l < 30) {
        if (s > 0) {
            hsla.set("l", 50)
        } else {
            hsla.set("l", 100)
        }
    }
    return hslaToRgbCss(hsla)
}
fun setBgBodyColor() {
    var dark = xConfig.dark
    uni_setAppTheme(SetAppThemeOptions(theme = dark, success = fun(_: SetAppThemeSuccessResult) {}, fail = fun(result: IAppThemeFail) {
        console.log(result)
    }
    ))
}
fun getUid(rdix: Number = 1, length: Number = 12): String {
    var ix = ""
    ix = Math.floor(Math.random() * rdix * Math.floor(Math.random() * Date.now())).toString(10).substring(0, length as Int)
    return ix
}
fun rpx2px(n: Number, _w: Number = 750): Number {
    var r = n
    r = uni_rpx2px(n)
    return r
}
fun checkIsCssUnit(str: Any, unit: String): String {
    if (UTSAndroid.`typeof`(str) != "string") {
        return (str as Number).toString(10) + unit
    }
    var s = str as String
    if (s.indexOf("px") > -1 || s.indexOf("%") > -1 || s.indexOf("auto") > -1 || s.indexOf("vw") > -1 || s.indexOf("vh") > -1) {
        return s
    }
    return s + (if (unit == "") {
        "px"
    } else {
        unit
    }
    )
}
fun fillArrayCssValue(kVal: UTSArray<String>): UTSArray<String> {
    var ar: UTSArray<String> = kVal.map(fun(el: String): String {
        return checkIsCssUnit(el, xConfig.unit)
    }
    )
    if (ar.length == 0) {
        return _uA()
    }
    if (ar.length == 1) {
        return _uA(
            ar[0],
            ar[0],
            ar[0],
            ar[0]
        )
    }
    if (ar.length == 2) {
        return _uA(
            ar[1],
            ar[0],
            ar[1],
            ar[0]
        )
    }
    if (ar.length == 3) {
        return _uA(
            ar[1],
            ar[2],
            "0px",
            ar[0]
        )
    }
    return _uA(
        ar[1],
        ar[2],
        ar[3],
        ar[0]
    )
}
fun getUnit(n: String?): String {
    if (n == null || n == "") {
        return xConfig.unit
    }
    var unit = n.replace(UTSRegExp("[\\d|\\-|\\+|\\.]", "g"), "")
    if (unit == "") {
        unit = xConfig.unit
    }
    return unit
}
fun setPagePullRefresh(enbledpull: Boolean) {
    var pages = getCurrentPages()
    var page = pages[pages.length - 1]
    page.`$setPageStyle`(_uO("enablePullDownRefresh" to enbledpull))
}
fun getPagePullRefresh(): Boolean {
    var pages = getCurrentPages()
    var page = pages[pages.length - 1]
    var pageJson = page.`$getPageStyle`()
    var enb = pageJson.get("enablePullDownRefresh") as Boolean?
    if (enb == null) {
        return false
    }
    return enb as Boolean
}
val xRequestCall = reactive(X_REQUEST_PRIVATE_CALL_FUN_TYPE(history = _uA<xRequestHistoryType>(), authPass = true, hostUrl = "", dev = false, header = null, showLoadToast = true, showSuccessToast = true, showErrorToast = true))
typealias callbackFunType = (x: Number) -> Number
var kSplineTableSize: Number = 11
var kSampleStepSize = (1.0 as Number) / (kSplineTableSize - 1.0)
fun A(aA1: Number, aA2: Number): Number {
    return 1.0 - 3.0 * aA2 + 3.0 * aA1
}
fun B(aA1: Number, aA2: Number): Number {
    return 3.0 * aA2 - 6.0 * aA1
}
fun C(aA1: Number): Number {
    return 3.0 * aA1
}
fun calcBezier(aT: Number, aA1: Number, aA2: Number): Number {
    return ((A(aA1, aA2) * aT + B(aA1, aA2)) * aT + C(aA1)) * aT
}
fun getSlope(aT: Number, aA1: Number, aA2: Number): Number {
    return 3.0 * A(aA1, aA2) * aT * aT + 2.0 * B(aA1, aA2) * aT + C(aA1)
}
fun binarySubdivide(aX: Number, reassignedAA: Number, reassignedAB: Number, mX1: Number, mX2: Number): Number {
    var aB = reassignedAB
    var aA = reassignedAA
    var currentX: Number = 0
    var currentT: Number = 0
    var i: Number = 0
    do {
        currentT = aA + (aB - aA) / 2.0
        currentX = calcBezier(currentT, mX1, mX2) - aX
        if (currentX > 0.0) {
            aB = currentT
        } else {
            aA = currentT
        }
    }
    while (Math.abs(currentX) > 0.0000001 && ++i < 10)
    return currentT
}
fun newtonRaphsonIterate(aX: Number, aGuessT: Number, mX1: Number, mX2: Number): Number {
    var pat = aGuessT
    run {
        var i: Number = 0
        while(i < 4){
            var currentSlope = getSlope(aGuessT, mX1, mX2)
            if (currentSlope == 0.0) {
                return aGuessT
            }
            var currentX = calcBezier(aGuessT, mX1, mX2) - aX
            pat -= currentX / currentSlope
            ++i
        }
    }
    return pat
}
fun bezier(mX1: Number, mY1: Number, mX2: Number, mY2: Number): callbackFunType? {
    if (!(0 <= mX1 && mX1 <= 1 && 0 <= mX2 && mX2 <= 1)) {
        return null
    }
    var sampleValues: UTSArray<Number> = _uA()
    if (mX1 != mY1 || mX2 != mY2) {
        run {
            var i: Number = 0
            while(i < kSplineTableSize){
                sampleValues.push(calcBezier(i * kSampleStepSize, mX1, mX2))
                ++i
            }
        }
    }
    fun getTForX(aX: Number): Number {
        var intervalStart: Number = 0
        var currentSample: Number = 1
        var lastSample = kSplineTableSize - 1
        while(currentSample != lastSample && sampleValues[currentSample] <= aX){
            intervalStart += kSampleStepSize
            ++currentSample
        }
        --currentSample
        var dist = (aX - sampleValues[currentSample]) / (sampleValues[currentSample + 1] - sampleValues[currentSample])
        var guessForT: Number = intervalStart + dist * kSampleStepSize
        var initialSlope = getSlope(guessForT, mX1, mX2)
        if (initialSlope >= 0.001) {
            return newtonRaphsonIterate(aX, guessForT, mX1, mX2)
        } else if (initialSlope == 0.0) {
            return guessForT
        }
        return binarySubdivide(aX, intervalStart, intervalStart + kSampleStepSize, mX1, mX2)
    }
    return fun(x: Number): Number {
        if (mX1 == mY1 && mX2 == mY2) {
            return x
        }
        if (x == 0 || x == 1) {
            return x
        }
        return calcBezier(getTForX(x), mY1, mY2)
    }
}
typealias FrameRequestCallback = (time: Number) -> Unit
open class xTween {
    private var frameId: Number? = null
    open var isRuning: Boolean = false
    open var isStoping: Boolean = true
    open var frmae: Number = 0
    open var isRendering = false
    private var _callListFun: UTSArray<xTweenEventCallFunType> = _uA()
    private var _frema_starttimes: Number = 0
    private var enters: (listAni: UTSArray<xTweenEventCallFunType>, tims: Number) -> Unit = fun(listAni: UTSArray<xTweenEventCallFunType>, tims: Number){}
    private var complete: () -> Unit = fun(){}
    private var lastTime: Number = 0
    private var nextHandle: Number = 0
    private var callbacks: Map<Number, FrameRequestCallback> = Map()
    private var easingList = Map<String, UTSArray<Number>>(_uA(
        _uA(
            "linear",
            _uA(
                0.250,
                0.250,
                0.750,
                0.750
            )
        ),
        _uA(
            "ease",
            _uA(
                0.250,
                0.100,
                0.250,
                1.000
            )
        ),
        _uA(
            "easeIn",
            _uA(
                0.420,
                0.000,
                1.000,
                1.000
            )
        ),
        _uA(
            "easeOut",
            _uA(
                0.000,
                0.000,
                0.580,
                1.000
            )
        ),
        _uA(
            "easeInOut",
            _uA(
                0.420,
                0.000,
                0.580,
                1.000
            )
        ),
        _uA(
            "easeInQuad",
            _uA(
                0.550,
                0.085,
                0.680,
                0.530
            )
        ),
        _uA(
            "easeOutQuad",
            _uA(
                0.250,
                0.460,
                0.450,
                0.940
            )
        ),
        _uA(
            "easeInOutQuad",
            _uA(
                0.455,
                0.030,
                0.515,
                0.955
            )
        ),
        _uA(
            "easeInCubic",
            _uA(
                0.550,
                0.055,
                0.675,
                0.190
            )
        ),
        _uA(
            "easeOutCubic",
            _uA(
                0.215,
                0.610,
                0.355,
                1.000
            )
        ),
        _uA(
            "easeInOutCubic",
            _uA(
                0.645,
                0.045,
                0.355,
                1.000
            )
        ),
        _uA(
            "easeInQuart",
            _uA(
                0.895,
                0.030,
                0.685,
                0.220
            )
        ),
        _uA(
            "easeOutQuart",
            _uA(
                0.165,
                0.840,
                0.440,
                1.000
            )
        ),
        _uA(
            "easeInOutQuart",
            _uA(
                0.770,
                0.000,
                0.175,
                1.000
            )
        ),
        _uA(
            "easeInQuint",
            _uA(
                0.755,
                0.050,
                0.855,
                0.060
            )
        ),
        _uA(
            "easeOutQuint",
            _uA(
                0.230,
                1.000,
                0.320,
                1.000
            )
        ),
        _uA(
            "easeInOutQuint",
            _uA(
                0.860,
                0.000,
                0.070,
                1.000
            )
        ),
        _uA(
            "easeInSine",
            _uA(
                0.470,
                0.000,
                0.745,
                0.715
            )
        ),
        _uA(
            "easeOutSine",
            _uA(
                0.390,
                0.575,
                0.565,
                1.000
            )
        ),
        _uA(
            "easeInOutSine",
            _uA(
                0.445,
                0.050,
                0.550,
                0.950
            )
        ),
        _uA(
            "easeInExpo",
            _uA(
                0.950,
                0.050,
                0.795,
                0.035
            )
        ),
        _uA(
            "easeOutExpo",
            _uA(
                0.190,
                1.000,
                0.220,
                1.000
            )
        ),
        _uA(
            "easeInOutExpo",
            _uA(
                1.000,
                0.000,
                0.000,
                1.000
            )
        ),
        _uA(
            "easeInCirc",
            _uA(
                0.600,
                0.040,
                0.980,
                0.335
            )
        ),
        _uA(
            "easeOutCirc",
            _uA(
                0.075,
                0.820,
                0.165,
                1.000
            )
        ),
        _uA(
            "easeInOutBack",
            _uA(
                0.680,
                -0.550,
                0.265,
                1.550
            )
        ),
        _uA(
            "tmxEase",
            _uA(
                0.42,
                0.38,
                0.15,
                0.93
            )
        )
    ))
    constructor(){}
    private fun customRequestAnimationFrame(callback: FrameRequestCallback): Number {
        val currTime: Number = Date.now()
        val timeToCall: Number = Math.max(0, 16 - (currTime - this.lastTime))
        val handle: Number = this.nextHandle++
        this.callbacks.set(handle, callback)
        val id = setTimeout(fun(){
            callback(currTime + timeToCall)
        }
        , timeToCall)
        this.lastTime = currTime + timeToCall
        return handle
    }
    private fun customCancelAnimationFrame(handle: Number) {
        if (this.callbacks.has(handle)) {
            this.callbacks.`delete`(handle)
            clearTimeout(handle)
        }
    }
    open fun startRender(): xTween {
        this.isRendering = true
        if (this.frameId == null) {
            this._run(this)
        }
        return this
    }
    open fun destroy() {
        if (this.frameId != null) {
            cancelAnimationFrame(this.frameId!!)
        }
        this.frameId = null
        this.isRendering = false
    }
    open fun getFrame(): Number {
        return this.frmae
    }
    open fun setComplete(call: () -> Unit): xTween {
        this.complete = call
        return this
    }
    open fun setEnter(call: (listAni: UTSArray<xTweenEventCallFunType>, tims: Number) -> Unit): xTween {
        this.enters = call
        return this
    }
    open fun addAnimate(opts: xTweenAnimate): String {
        var uid = getUid()
        var call: xTweenEventCall = fun(item: xTweenEventCallFunType){}
        this._callListFun.push(xTweenEventCallFunType(id = uid, ease = this._getEasing(opts?.ease ?: "linear"), duration = opts.duration, status = 1, progress = 0, oldProgeress = 0, startTime = 0, autoRemove = if (opts?.autoRemove != null) {
            (opts!!.autoRemove as Boolean)
        } else {
            true
        }
        , complete = if (opts?.complete != null) {
            opts!!.complete!!
        } else {
            call
        }
        , enter = if (opts?.enter != null) {
            opts!!.enter!!
        } else {
            call
        }
        , start = if (opts?.start != null) {
            opts!!.start!!
        } else {
            call
        }
        , pause = if (opts?.pause != null) {
            opts!!.pause!!
        } else {
            call
        }
        , loop = if (opts?.loop != null) {
            opts!!.loop!!
        } else {
            1
        }
        , tyty = if (opts?.tyty != null) {
            opts!!.tyty!!
        } else {
            false
        }
        , step = if (opts?.step != null) {
            opts!!.step!!
        } else {
            1
        }
        , _finishLoop = 0, reverse = false))
        return uid
    }
    open fun removeAnimate(uid: String? = null): xTween {
        if (uid == null) {
            this._callListFun = _uA<xTweenEventCallFunType>()
        } else {
            var index = this._getCallIndex(uid as String)
            if (index > -1) {
                this._callListFun.splice(index, 1)
            }
        }
        return this
    }
    open fun play(uid: String? = null) {
        if (uid != null && uid != "") {
            var index = this._getCallIndex(uid!! as String)
            if (index > -1) {
                var item = this._callListFun[index]
                if (item.status == 1) {
                    this._by_run_set_status(item, 1)
                    this._by_run_item_callFun(item, 0)
                }
                this._by_run_set_status(item, 4)
            }
        } else {
            run {
                var i: Number = 0
                while(i < this._callListFun.length){
                    var item = this._callListFun[i]
                    if (item.status == 1) {
                        this._by_run_set_status(item, 1)
                        this._by_run_item_callFun(item, 0)
                    }
                    this._by_run_set_status(item, 4)
                    i++
                }
            }
        }
        this._setGlobaleStatus(1)
    }
    open fun getAnimationListLen(): Number {
        return this._callListFun.length
    }
    open fun pause(uid: String? = null): xTween {
        if (uid != null && uid != "") {
            var index = this._getCallIndex(uid!! as String)
            if (index > -1) {
                var item = this._callListFun[index]
                this._by_run_set_status(item, if (this._isLoopPauseing(item)) {
                    6
                } else {
                    3
                }
                )
                this._by_run_item_callFun(item, item.progress)
            }
        } else {
            run {
                var i: Number = 0
                while(i < this._callListFun.length){
                    var item = this._callListFun[i]
                    this._by_run_set_status(item, if (this._isLoopPauseing(item)) {
                        6
                    } else {
                        3
                    }
                    )
                    this._by_run_item_callFun(item, item.progress)
                    i++
                }
            }
            this._setGlobaleStatus(2)
        }
        return this
    }
    open fun stop(uid: String? = null): xTween {
        if (uid != null && uid != "") {
            var index = this._getCallIndex(uid!! as String)
            if (index > -1) {
                var item = this._callListFun[index]
                this._by_run_set_status(item, 2)
                this._by_run_item_callFun(item, 1)
            }
        } else {
            run {
                var i: Number = 0
                while(i < this._callListFun.length){
                    var item = this._callListFun[i]
                    this._by_run_set_status(item, 2)
                    this._by_run_item_callFun(item, 1)
                    i++
                }
            }
            this._callListFun = this._callListFun.filter(fun(el: xTweenEventCallFunType): Boolean {
                return !el.autoRemove
            }
            )
            this.enters(this._callListFun, 0)
        }
        return this
    }
    private fun _getEasing(args: Any): xTweenCallbackFunType? {
        var kFun: xTweenCallbackFunType? = fun(x: Number): Number {
            return x
        }
        if (UTSAndroid.`typeof`(args) == "string") {
            var animateNumber = this.easingList.get(args as String)
            if (animateNumber != null) {
                var ease = animateNumber!! as UTSArray<Number>
                kFun = bezier(ease[0], ease[1], ease[2], ease[3])
            }
        } else if (UTSArray.isArray(args)) {
            var argsar = args as UTSArray<Number>
            if (argsar.length == 4) {
                kFun = bezier(argsar[0], argsar[1], argsar[2], argsar[3])
            }
        } else {
            var animateNumber = this.easingList.get("linear")
            if (animateNumber != null) {
                var ease = animateNumber!! as UTSArray<Number>
                kFun = bezier(ease[0], ease[1], ease[2], ease[3])
            }
        }
        return kFun
    }
    private fun _getCallIndex(uid: String): Number {
        var index: Number = -1
        run {
            var i: Number = 0
            while(i < this._callListFun.length){
                var item = this._callListFun[i]
                if (item.id == uid) {
                    index = i
                    break
                }
                i++
            }
        }
        return index
    }
    private fun _isLoopPauseing(item: xTweenEventCallFunType): Boolean {
        if (item.loop == -1) {
            return true
        }
        if (item._finishLoop < item.loop) {
            return true
        }
        return false
    }
    private fun _by_run_set_status(item: xTweenEventCallFunType, status: xTweenStatus) {
        if (status == 1) {
            item.progress = 0
            item.startTime = 0
            item._finishLoop = 0
        } else if (status == 2) {
            item.progress = 1
            item.oldProgeress = 0
            item.startTime = 0
            item._finishLoop = item.loop
        } else if (status == 3) {
            item.startTime = 0
            item.oldProgeress = item.progress
        } else if (status == 5) {
            item.progress = 0
            item.oldProgeress = 0
            item.startTime = 0
        } else if (status == 6) {
            item.oldProgeress = item.progress
            item.startTime = 0
        }
        item.status = status
    }
    private fun _by_run_item_callFun(item: xTweenEventCallFunType, progress: Number) {
        if (item.status == 1) {
            item.start(item)
        }
        if (item.status == 2) {
            item.enter(item)
            item.complete(item)
            if (item.autoRemove) {
                var index = this._getCallIndex(item.id)
                if (index > -1) {
                    this._callListFun.splice(index, 1)
                }
            }
        }
        if (item.status == 3) {
            item.pause(item)
        }
        if (item.status == 4 || item.status == 5) {
            item.enter(item)
        }
    }
    private fun _setGlobaleStatus(type: Number) {
        if (type == 1) {
            this.isRuning = true
            this.isStoping = false
        } else if (type == 2) {
            this.isRuning = false
            this.isStoping = true
        }
    }
    private fun _run(_this: xTween) {
        if (!_this.isRendering) {
            return
        }
        fun actions(times: Number) {
            _this.enters(_this._callListFun, times)
            if (_this._frema_starttimes == 0) {
                _this._frema_starttimes = times
            }
            var isAllCompelted = true
            run {
                var i: Number = 0
                while(i < _this._callListFun.length){
                    var item = _this._callListFun[i]
                    var isFinishStatus: Number = 1
                    if (item.status == 4 || item.status == 5) {
                        if (item.startTime == 0) {
                            item.startTime = times
                        }
                        if (_this.frmae > 0) {
                            var progress = Math.min((times - item.startTime) / item.duration + item.oldProgeress, 1)
                            var eas = item.ease!!
                            item.progress = eas(progress)
                            if (progress == isFinishStatus) {
                                item._finishLoop += 1
                                if (item.loop > 0) {
                                    if (item.loop == item._finishLoop) {
                                        _this._by_run_set_status(item, 2)
                                        _this._by_run_item_callFun(item, isFinishStatus)
                                    } else {
                                        _this._by_run_set_status(item, 5)
                                    }
                                } else if (item.loop == -1) {
                                    _this._by_run_set_status(item, 5)
                                }
                                if (item.tyty) {
                                    item.reverse = !item.reverse
                                }
                            }
                            _this._by_run_item_callFun(item, item.progress)
                        }
                    }
                    if (item.progress != 2) {
                        isAllCompelted = false
                    }
                    i++
                }
            }
            if (isAllCompelted && _this.isRuning) {
                _this.complete()
                _this._setGlobaleStatus(2)
            }
            _this.frmae = Math.ceil((1000 as Number) / (times - _this._frema_starttimes))
            _this._frema_starttimes = times
            _this._run(_this)
        }
        _this.frameId = requestAnimationFrame(fun(times: Number){
            actions(times)
        }
        )
    }
}
typealias xDateLanguage = String
open class xDateI18nTypeRelativeTime (
    @JsonNotNull
    open var future: String,
    @JsonNotNull
    open var past: String,
    @JsonNotNull
    open var s: String,
    @JsonNotNull
    @get:JvmName("getM0")
    @set:JvmName("setM0")
    open var m: String,
    @JsonNotNull
    open var mm: String,
    @JsonNotNull
    open var h: String,
    @JsonNotNull
    open var hh: String,
    @JsonNotNull
    open var d: String,
    @JsonNotNull
    open var dd: String,
    @JsonNotNull
    @get:JvmName("getM1")
    @set:JvmName("setM1")
    open var M: String,
    @JsonNotNull
    open var MM: String,
    @JsonNotNull
    open var y: String,
    @JsonNotNull
    open var yy: String,
) : UTSObject()
open class xDateI18nType (
    @JsonNotNull
    open var weekdays: UTSArray<String>,
    @JsonNotNull
    open var weekdaysShort: UTSArray<String>,
    @JsonNotNull
    open var months: UTSArray<String>,
    @JsonNotNull
    open var monthsShort: UTSArray<String>,
    open var meridiem: (hour: Number, minute: Number, isLowercase: Boolean) -> String,
    @JsonNotNull
    open var relativeTime: xDateI18nTypeRelativeTime,
) : UTSObject()
val zhHans = xDateI18nType(weekdays = _uA(
    "星期日",
    "星期一",
    "星期二",
    "星期三",
    "星期四",
    "星期五",
    "星期六"
), weekdaysShort = _uA(
    "周日",
    "周一",
    "周二",
    "周三",
    "周四",
    "周五",
    "周六"
), months = _uA(
    "一月",
    "二月",
    "三月",
    "四月",
    "五月",
    "六月",
    "七月",
    "八月",
    "九月",
    "十月",
    "十一月",
    "十二月"
), monthsShort = _uA(
    "1月",
    "2月",
    "3月",
    "4月",
    "5月",
    "6月",
    "7月",
    "8月",
    "9月",
    "10月",
    "11月",
    "12月"
), meridiem = fun(hour: Number, minute: Number, isLowercase: Boolean): String {
    return if (hour < 12) {
        "上午"
    } else {
        "下午"
    }
}
, relativeTime = xDateI18nTypeRelativeTime(future = "%s内", past = "%s前", s = "几秒", m = "1分钟", mm = "%d分钟", h = "1小时", hh = "%d小时", d = "1天", dd = "%d天", M = "1个月", MM = "%d个月", y = "1年", yy = "%d年"))
val en = xDateI18nType(weekdays = _uA(
    "Sunday",
    "Monday",
    "Tuesday",
    "Wednesday",
    "Thursday",
    "Friday",
    "Saturday"
), weekdaysShort = _uA(
    "Sun",
    "Mon",
    "Tue",
    "Wed",
    "Thu",
    "Fri",
    "Sat"
), months = _uA(
    "January",
    "February",
    "March",
    "April",
    "May",
    "June",
    "July",
    "August",
    "September",
    "October",
    "November",
    "December"
), monthsShort = _uA(
    "Jan",
    "Feb",
    "Mar",
    "Apr",
    "May",
    "Jun",
    "Jul",
    "Aug",
    "Sep",
    "Oct",
    "Nov",
    "Dec"
), meridiem = fun(hour: Number, minute: Number, isLowercase: Boolean): String {
    return if (hour < 12) {
        if (isLowercase) {
            "am"
        } else {
            "AM"
        }
    } else {
        if (isLowercase) {
            "pm"
        } else {
            "PM"
        }
    }
}
, relativeTime = xDateI18nTypeRelativeTime(future = "in %s", past = "%s ago", s = "a few seconds", m = "a minute", mm = "%d minutes", h = "an hour", hh = "%d hours", d = "a day", dd = "%d days", M = "a month", MM = "%d months", y = "a year", yy = "%d years"))
val ja = xDateI18nType(weekdays = _uA(
    "日曜日",
    "月曜日",
    "火曜日",
    "水曜日",
    "木曜日",
    "金曜日",
    "土曜日"
), weekdaysShort = _uA(
    "日",
    "月",
    "火",
    "水",
    "木",
    "金",
    "土"
), months = _uA(
    "1月",
    "2月",
    "3月",
    "4月",
    "5月",
    "6月",
    "7月",
    "8月",
    "9月",
    "10月",
    "11月",
    "12月"
), monthsShort = _uA(
    "1月",
    "2月",
    "3月",
    "4月",
    "5月",
    "6月",
    "7月",
    "8月",
    "9月",
    "10月",
    "11月",
    "12月"
), meridiem = fun(hour: Number, minute: Number, isLowercase: Boolean): String {
    return if (hour < 12) {
        "午前"
    } else {
        "午後"
    }
}
, relativeTime = xDateI18nTypeRelativeTime(future = "%s後", past = "%s前", s = "数秒", m = "1分", mm = "%d分", h = "1時間", hh = "%d時間", d = "1日", dd = "%d日", M = "1ヶ月", MM = "%dヶ月", y = "1年", yy = "%d年"))
val ko = xDateI18nType(weekdays = _uA(
    "일요일",
    "월요일",
    "화요일",
    "수요일",
    "목요일",
    "금요일",
    "토요일"
), weekdaysShort = _uA(
    "일",
    "월",
    "화",
    "수",
    "목",
    "금",
    "토"
), months = _uA(
    "1월",
    "2월",
    "3월",
    "4월",
    "5월",
    "6월",
    "7월",
    "8월",
    "9월",
    "10월",
    "11월",
    "12월"
), monthsShort = _uA(
    "1월",
    "2월",
    "3월",
    "4월",
    "5월",
    "6월",
    "7월",
    "8월",
    "9월",
    "10월",
    "11월",
    "12월"
), meridiem = fun(hour: Number, minute: Number, isLowercase: Boolean): String {
    return if (hour < 12) {
        "오전"
    } else {
        "오후"
    }
}
, relativeTime = xDateI18nTypeRelativeTime(future = "%s 후", past = "%s 전", s = "몇 초", m = "1분", mm = "%d분", h = "1시간", hh = "%d시간", d = "1일", dd = "%d일", M = "1개월", MM = "%d개월", y = "1년", yy = "%d년"))
val zhHant = xDateI18nType(weekdays = _uA(
    "星期日",
    "星期一",
    "星期二",
    "星期三",
    "星期四",
    "星期五",
    "星期六"
), weekdaysShort = _uA(
    "週日",
    "週一",
    "週二",
    "週三",
    "週四",
    "週五",
    "週六"
), months = _uA(
    "一月",
    "二月",
    "三月",
    "四月",
    "五月",
    "六月",
    "七月",
    "八月",
    "九月",
    "十月",
    "十一月",
    "十二月"
), monthsShort = _uA(
    "1月",
    "2月",
    "3月",
    "4月",
    "5月",
    "6月",
    "7月",
    "8月",
    "9月",
    "10月",
    "11月",
    "12月"
), meridiem = fun(hour: Number, minute: Number, isLowercase: Boolean): String {
    return if (hour < 12) {
        "上午"
    } else {
        "下午"
    }
}
, relativeTime = xDateI18nTypeRelativeTime(future = "%s內", past = "%s前", s = "幾秒", m = "1分鐘", mm = "%d分鐘", h = "1小時", hh = "%d小時", d = "1天", dd = "%d天", M = "1個月", MM = "%d個月", y = "1年", yy = "%d年"))
val fr = xDateI18nType(weekdays = _uA(
    "dimanche",
    "lundi",
    "mardi",
    "mercredi",
    "jeudi",
    "vendredi",
    "samedi"
), weekdaysShort = _uA(
    "dim.",
    "lun.",
    "mar.",
    "mer.",
    "jeu.",
    "ven.",
    "sam."
), months = _uA(
    "janvier",
    "février",
    "mars",
    "avril",
    "mai",
    "juin",
    "juillet",
    "août",
    "septembre",
    "octobre",
    "novembre",
    "décembre"
), monthsShort = _uA(
    "janv.",
    "févr.",
    "mars",
    "avr.",
    "mai",
    "juin",
    "juil.",
    "août",
    "sept.",
    "oct.",
    "nov.",
    "déc."
), meridiem = fun(hour: Number, minute: Number, isLowercase: Boolean): String {
    return ""
}
, relativeTime = xDateI18nTypeRelativeTime(future = "dans %s", past = "il y a %s", s = "quelques secondes", m = "une minute", mm = "%d minutes", h = "une heure", hh = "%d heures", d = "un jour", dd = "%d jours", M = "un mois", MM = "%d mois", y = "un an", yy = "%d ans"))
val ru = xDateI18nType(weekdays = _uA(
    "воскресенье",
    "понедельник",
    "вторник",
    "среда",
    "четверг",
    "пятница",
    "суббота"
), weekdaysShort = _uA(
    "вс",
    "пн",
    "вт",
    "ср",
    "чт",
    "пт",
    "сб"
), months = _uA(
    "январь",
    "февраль",
    "март",
    "апрель",
    "май",
    "июнь",
    "июль",
    "август",
    "сентябрь",
    "октябрь",
    "ноябрь",
    "декабрь"
), monthsShort = _uA(
    "янв.",
    "февр.",
    "март",
    "апр.",
    "май",
    "июнь",
    "июль",
    "авг.",
    "сент.",
    "окт.",
    "нояб.",
    "дек."
), meridiem = fun(hour: Number, minute: Number, isLowercase: Boolean): String {
    return ""
}
, relativeTime = xDateI18nTypeRelativeTime(future = "через %s", past = "%s назад", s = "несколько секунд", m = "минута", mm = "%d минут", h = "час", hh = "%d часов", d = "день", dd = "%d дней", M = "месяц", MM = "%d месяцев", y = "год", yy = "%d лет"))
val locales: Map<xDateLanguage, xDateI18nType> = Map(_uA(
    _uA(
        "zh-Hans",
        zhHans
    ),
    _uA(
        "en",
        en
    ),
    _uA(
        "ja",
        ja
    ),
    _uA(
        "ko",
        ko
    ),
    _uA(
        "zh-Hant",
        zhHant
    ),
    _uA(
        "fr",
        fr
    ),
    _uA(
        "ru",
        ru
    )
))
@JvmField
var currentLocale: xDateLanguage = "zh-Hans"
fun getCurrentLocale(): xDateLanguage {
    return currentLocale
}
fun setLocale(locale: xDateLanguage): Unit {
    if (locales.has(locale)) {
        currentLocale = locale
    }
}
fun getLocaleData(): xDateI18nType {
    return locales.get(currentLocale)!!
}
val _regSlash = UTSRegExp("\\/", "g")
val _regYYYY = UTSRegExp("^(\\d{4})\$", "")
val _regYYMM = UTSRegExp("^(\\d{4})[-/](\\d{1,2})\$", "")
val _regYYMMDD = UTSRegExp("^(\\d{4})[-/](\\d{1,2})[-/](\\d{1,2})\$", "")
val _regYYMMDDHH = UTSRegExp("^(\\d{4})[-/](\\d{1,2})[-/](\\d{1,2}) (\\d{1,2})\$", "")
val _regYYMMDDHHMM = UTSRegExp("^(\\d{4})[-/](\\d{1,2})[-/](\\d{1,2}) (\\d{1,2}):(\\d{1,2})\$", "")
val _regYYMMDDHHMMSS = UTSRegExp("^(\\d{4})[-/](\\d{1,2})[-/](\\d{1,2}) (\\d{1,2}):(\\d{1,2}):(\\d{1,2})\$", "")
val _regRFC2822 = UTSRegExp("^(?:\\w{3},\\s)?(?:\\d{1,2}\\s(?:Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)\\s\\d{4}\\s\\d{2}:\\d{2}(?::\\d{2})?(?:\\sGMT)?)|(?:\\w{3}\\s(?:Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)\\s\\d{1,2}\\s\\d{2}:\\d{2}(?::\\d{2})?\\s\\d{4})", "")
val _regISO8601 = UTSRegExp("^\\d{4}(-\\d\\d(-\\d\\d(T\\d\\d:\\d\\d(:\\d\\d)?(\\.\\d+)?(([+-]\\d\\d:\\d\\d)|Z)?)?)?)?\$", "")
val _regDash = UTSRegExp("-", "g")
val _regNumOnly = UTSRegExp("^\\d+\$", "")
val _fmtYYYY = UTSRegExp("YYYY", "g")
val _fmtMM = UTSRegExp("MM", "g")
val _fmtDD = UTSRegExp("DD", "g")
val _fmtHH = UTSRegExp("hh", "g")
val _fmtmm = UTSRegExp("mm", "g")
val _fmtSS = UTSRegExp("ss", "g")
val _timeThresholds = _uA(
    33696000,
    31104000,
    15552000,
    12960000,
    10368000,
    7776000,
    5184000,
    2592000,
    604800,
    172800,
    86400,
    82800,
    18000,
    10800,
    7200,
    3600,
    1800,
    600,
    300,
    60,
    30
) as UTSArray<Number>
typealias xDateTypeTime = String
open class xDateTypeQuarter (
    @JsonNotNull
    open var quarter: Number,
    @JsonNotNull
    open var start: String,
    @JsonNotNull
    open var end: String,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return xDateTypeQuarterReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class xDateTypeQuarterReactiveObject : xDateTypeQuarter, IUTSReactive<xDateTypeQuarter> {
    override var __v_raw: xDateTypeQuarter
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: xDateTypeQuarter, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(quarter = __v_raw.quarter, start = __v_raw.start, end = __v_raw.end) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): xDateTypeQuarterReactiveObject {
        return xDateTypeQuarterReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var quarter: Number
        get() {
            return _tRG(__v_raw, "quarter", __v_raw.quarter, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("quarter")) {
                return
            }
            val oldValue = __v_raw.quarter
            __v_raw.quarter = value
            _tRS(__v_raw, "quarter", oldValue, value)
        }
    override var start: String
        get() {
            return _tRG(__v_raw, "start", __v_raw.start, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("start")) {
                return
            }
            val oldValue = __v_raw.start
            __v_raw.start = value
            _tRS(__v_raw, "start", oldValue, value)
        }
    override var end: String
        get() {
            return _tRG(__v_raw, "end", __v_raw.end, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("end")) {
                return
            }
            val oldValue = __v_raw.end
            __v_raw.end = value
            _tRS(__v_raw, "end", oldValue, value)
        }
}
typealias DateFormat = String
fun createDate(dateStrs: String): Date {
    val dateStr = dateStrs.replace(_regSlash, "-")
    val result = Date()
    var year = result.getFullYear()
    var month = result.getMonth()
    var day = result.getDate()
    var hour = result.getHours()
    var minute = result.getMinutes()
    var second = result.getSeconds()
    result.setDate(1)
    var match = dateStr.match(_regYYMMDDHHMMSS)
    if (match != null) {
        year = parseInt(match[1] as String)
        month = parseInt(match[2] as String) - 1
        day = parseInt(match[3] as String)
        hour = parseInt(match[4] as String)
        minute = parseInt(match[5] as String)
        second = parseInt(match[6] as String)
    } else {
        match = dateStr.match(_regYYMMDDHHMM)
        if (match != null) {
            year = parseInt(match[1] as String)
            month = parseInt(match[2] as String) - 1
            day = parseInt(match[3] as String)
            hour = parseInt(match[4] as String)
            minute = parseInt(match[5] as String)
        } else {
            match = dateStr.match(_regYYMMDDHH)
            if (match != null) {
                year = parseInt(match[1] as String)
                month = parseInt(match[2] as String) - 1
                day = parseInt(match[3] as String)
                hour = parseInt(match[4] as String)
            } else {
                match = dateStr.match(_regYYMMDD)
                if (match != null) {
                    year = parseInt(match[1] as String)
                    month = parseInt(match[2] as String) - 1
                    day = parseInt(match[3] as String)
                } else {
                    match = dateStr.match(_regYYMM)
                    if (match != null) {
                        year = parseInt(match[1] as String)
                        month = parseInt(match[2] as String) - 1
                    } else {
                        match = dateStr.match(_regYYYY)
                        if (match != null) {
                            year = parseInt(match[1] as String)
                        }
                    }
                }
            }
        }
    }
    result.setSeconds(second)
    result.setMinutes(minute)
    result.setHours(hour)
    result.setFullYear(year)
    result.setMonth(month)
    result.setDate(day)
    return result
}
open class xDate {
    open lateinit var date: Date
    constructor(dateStr: Any? = null){
        this.date = this.checkDate(dateStr)
    }
    private fun checkDate(dateStr: Any? = null): Date {
        var tempDate = Date()
        if (dateStr == null) {
            return tempDate
        }
        if (UTSAndroid.`typeof`(dateStr) == "number") {
            return Date(dateStr!! as Number)
        } else if (UTSAndroid.`typeof`(dateStr) == "string") {
            if (dateStr as String == "") {
                return tempDate
            }
            val dateformatStr = this.detectDateFormat(dateStr!! as String)
            if (dateformatStr == "CUSTOM") {
                var str = dateStr!! as String
                str = str.replace(_regDash, "/")
                var isNumberStr = _regNumOnly.test(str)
                if (!isNumberStr) {
                    return createDate(dateStr!! as String)
                } else {
                    return Date(parseInt(str!!))
                }
            } else {
                return Date(dateStr!! as String)
            }
        } else if (dateStr is Date) {
            return dateStr!! as Date
        }
        return tempDate
    }
    open fun detectDateFormat(dateStr: String): DateFormat {
        if (_regRFC2822.test(dateStr)) {
            return "RFC2822"
        }
        if (_regISO8601.test(dateStr)) {
            return "ISO8601"
        }
        return "CUSTOM"
    }
    open fun translateFullDate(d: Number, w: Number): String {
        var dstr = d.toString(10)
        while(dstr.length < w){
            dstr = "0" + dstr
        }
        return dstr
    }
    open fun format(s: String? = null): String {
        var str = if (s != null) {
            s!!
        } else {
            "YYYY/MM/DD hh:mm:ss"
        }
        str = str.replace(_fmtYYYY, this.translateFullDate(this.date.getFullYear(), 2))
        str = str.replace(_fmtMM, this.translateFullDate(this.date.getMonth() + 1, 2))
        str = str.replace(_fmtDD, this.translateFullDate(this.date.getDate(), 2))
        str = str.replace(_fmtHH, this.translateFullDate(this.date.getHours(), 2))
        str = str.replace(_fmtmm, this.translateFullDate(this.date.getMinutes(), 2))
        str = str.replace(_fmtSS, this.translateFullDate(this.date.getSeconds(), 2))
        return str
    }
    open fun getYear(): Number {
        return this.date.getFullYear()
    }
    open fun getMonth(): Number {
        return this.date.getMonth()
    }
    open fun getMonthName(useShort: Boolean = false): String {
        val monthIndex = this.date.getMonth()
        return if (useShort) {
            getLocaleData().monthsShort[monthIndex]
        } else {
            getLocaleData().months[monthIndex]
        }
    }
    open fun getDate(): Number {
        return this.date.getDate()
    }
    open fun getHours(): Number {
        return this.date.getHours()
    }
    open fun getMinutes(): Number {
        return this.date.getMinutes()
    }
    open fun getSeconds(): Number {
        return this.date.getSeconds()
    }
    open fun getDateOf(d: xDateTypeTime = "d"): Number {
        if (d == "y") {
            return this.date.getFullYear()
        } else if (d == "m") {
            return this.date.getMonth()
        } else if (d == "d") {
            return this.date.getDate()
        } else if (d == "h") {
            return this.date.getHours()
        } else if (d == "M") {
            return this.date.getMinutes()
        } else if (d == "s") {
            return this.date.getSeconds()
        }
        return this.date.getMilliseconds()
    }
    open fun setDateOf(n: Number, d: xDateTypeTime = "d"): xDate {
        if (d == "y") {
            this.date.setFullYear(n)
        } else if (d == "m") {
            this.date.setMonth(n)
        } else if (d == "d") {
            this.date.setDate(n)
        } else if (d == "h") {
            this.date.setHours(n)
        } else if (d == "M") {
            this.date.setMinutes(n)
        } else if (d == "s") {
            this.date.setSeconds(n)
        } else if (d == "ms") {
            this.date.setMilliseconds(n)
        }
        return this
    }
    open fun getTime(d: xDateTypeTime): Number {
        var date = Date(this.date.getTime())
        if (d == "y") {
            date.setMonth(0)
            date.setDate(1)
            date.setHours(0)
            date.setMinutes(0)
            date.setSeconds(0)
            date.setMilliseconds(0)
            return date.getTime()
        } else if (d == "m") {
            date.setDate(1)
            date.setHours(0)
            date.setMinutes(0)
            date.setSeconds(0)
            date.setMilliseconds(0)
            return date.getTime()
        } else if (d == "d") {
            date.setHours(0)
            date.setMinutes(0)
            date.setSeconds(0)
            date.setMilliseconds(0)
            return date.getTime()
        } else if (d == "h") {
            date.setMinutes(0)
            date.setSeconds(0)
            date.setMilliseconds(0)
            return date.getTime()
        } else if (d == "M") {
            date.setSeconds(0)
            date.setMilliseconds(0)
            return date.getTime()
        } else if (d == "s") {
            date.setMilliseconds(0)
            return date.getTime()
        }
        return date.getTime()
    }
    open fun getClone(): xDate {
        return xDate(this.date.getTime())
    }
    open fun getWeek(): Number {
        var target = Date(this.date.getTime())
        target.setDate(target.getDate() - (if (target.getDay() == 0) {
            7
        } else {
            target.getDay()
        }
        ))
        var firstDayOfYear = Date(target.getFullYear(), 0, 1)
        firstDayOfYear.setDate(firstDayOfYear.getDate() - (if (firstDayOfYear.getDay() == 0) {
            7
        } else {
            firstDayOfYear.getDay()
        }
        ))
        return Math.ceil((((target.getTime() - firstDayOfYear.getTime()) / 86400000) + 1) / 7)
    }
    open fun getDateStartOf(d: String = "m"): xDate {
        var now = Date(this.date.getTime())
        if (d == "w") {
            var dayOfWeek = now.getDay()
            if (dayOfWeek === 0) {
                now.setDate(now.getDate() - 7)
            }
            now.setDate(now.getDate() - dayOfWeek + 1)
        }
        if (d == "m" || d == "y") {
            now.setDate(1)
        }
        if (d == "y") {
            now.setMonth(0)
        }
        now.setHours(0)
        now.setMinutes(0)
        now.setSeconds(0)
        return dateCovertXdate(now)
    }
    open fun getDateEndOf(d: String = "m"): xDate {
        var now = Date(this.date.getTime())
        if (d == "w") {
            var dayOfWeek = now.getDay()
            if (dayOfWeek === 0) {
                now.setHours(23)
                now.setMinutes(59)
                now.setSeconds(59)
                return dateCovertXdate(now)
            }
            now.setDate(now.getDate() + (7 - dayOfWeek))
        }
        if (d == "m") {
            now.setDate(this.getMonthCountDay())
        }
        if (d == "y") {
            now.setMonth(11)
            now.setDate(31)
        }
        now.setHours(23)
        now.setMinutes(59)
        now.setSeconds(59)
        return dateCovertXdate(now)
    }
    open fun getWeekDay(): Number {
        return this.date.getDay()
    }
    open fun getWeekDayCn(model: UTSArray<String>? = null, useShort: Boolean = true): String {
        var ml = if (useShort) {
            getLocaleData().weekdaysShort
        } else {
            getLocaleData().weekdays
        }
        if (model != null && model?.length == 7) {
            ml = model!!
        }
        return ml[this.getWeekDay()]!!
    }
    open fun getMonthCountDay(): Number {
        var nextDate = Date(this.date.getTime())
        nextDate.setDate(1)
        nextDate.setMonth(this.getMonth() + 1)
        nextDate.setDate(0)
        return nextDate.getDate()
    }
    open fun getDateInfo(str: String? = null): xDateDayInfoType {
        var date = this as xDate
        if (str != null) {
            date = xDate(str)
        }
        var info = xDateDayInfoType(year = date.getYear(), month = date.getMonth(), day = date.getDate(), hours = date.getHours(), minutes = date.getMinutes(), seconds = date.getSeconds(), week = date.getWeekDay(), weeks = date.getWeek(), weekCn = date.getWeekDayCn(), date = "")
        info.date = info.year + "/" + (info.month + 1) + "/" + info.day
        return info
    }
    open fun getDaysOf(d: String = "m"): UTSArray<xDateDayInfoType> {
        var dates = _uA<xDateDayInfoType>()
        if (d == "w") {
            var first = this.getDateStartOf("w")
            run {
                var i: Number = 0
                while(i < 7){
                    var date = first.getClone()
                    date.date.setDate(date.date.getDate() + i)
                    dates.push(date.getDateInfo())
                    i++
                }
            }
        }
        if (d == "m") {
            var first = this.getDateStartOf("m")
            var maxDay = this.getMonthCountDay()
            run {
                var i: Number = 1
                while(i <= maxDay){
                    var date = first.getClone()
                    date.date.setDate(i)
                    dates.push(date.getDateInfo())
                    i++
                }
            }
        }
        return dates
    }
    open fun getDaysOfNum(d: Number = 0, type: String): UTSArray<xDateDayInfoType> {
        var ar = _uA<xDateDayInfoType>()
        var nowdate = this.getClone()
        if (type == "after") {
            run {
                var i: Number = 0
                while(i < d){
                    nowdate.add(1, "d")
                    ar.push(nowdate.getDateInfo())
                    i++
                }
            }
        } else if (type == "before") {
            run {
                var i: Number = 0
                while(i < d){
                    nowdate.subtraction(1, "d")
                    ar.push(nowdate.getDateInfo())
                    i++
                }
            }
            ar.reverse()
        }
        return ar
    }
    open fun add(count: Number, d: xDateTypeTime = "d"): xDate {
        if (d == "y") {
            this.date.setFullYear(this.getYear() + count)
        } else if (d == "m") {
            this.date.setMonth(this.getMonth() + count)
        } else if (d == "d") {
            this.date.setDate(this.getDate() + count)
        } else if (d == "h") {
            this.date.setHours(this.getHours() + count)
        } else if (d == "M") {
            this.date.setMinutes(this.getMinutes() + count)
        } else if (d == "s") {
            this.date.setSeconds(this.getSeconds() + count)
        } else if (d == "w") {
            this.date.setDate(this.getDate() + count * 7)
        }
        return this
    }
    open fun subtraction(count: Number, d: xDateTypeTime = "d"): xDate {
        if (d == "y") {
            this.date.setFullYear(this.getYear() - count)
        } else if (d == "m") {
            this.date.setMonth(this.getMonth() - count)
        } else if (d == "d") {
            this.date.setDate(this.getDate() - count)
        } else if (d == "h") {
            this.date.setHours(this.getHours() - count)
        } else if (d == "M") {
            this.date.setMinutes(this.getMinutes() - count)
        } else if (d == "s") {
            this.date.setSeconds(this.getSeconds() - count)
        } else if (d == "w") {
            this.date.setDate(this.getDate() - count * 7)
        }
        return this
    }
    open fun isBetween(start: xDate, end: xDate, type: xDateTypeTime = "ms", d: String = "[]"): Boolean {
        var startTime = start.getTime(type)
        var endTime = end.getTime(type)
        var nowTime = this.getTime(type)
        if (d == "()") {
            return nowTime > startTime && nowTime < endTime
        } else if (d == "[]") {
            return nowTime >= startTime && nowTime <= endTime
        } else if (d == "(]") {
            return nowTime > startTime && nowTime <= endTime
        } else if (d == "[)") {
            return nowTime >= startTime && nowTime < endTime
        }
        return nowTime >= startTime && nowTime <= endTime
    }
    open fun isBetweenOf(targetDate: xDate, d: String = ">", type: xDateTypeTime = "ms"): Boolean {
        var startTime = targetDate.getTime(type)
        var nowTime = this.getTime(type)
        if (d == ">") {
            return nowTime > startTime
        } else if (d == ">=") {
            return nowTime >= startTime
        } else if (d == "<") {
            return nowTime < startTime
        } else if (d == "<=") {
            return nowTime <= startTime
        } else if (d == "=") {
            return nowTime == startTime
        }
        return nowTime > startTime
    }
    open fun fromBetweenLongTime(target: Any, model: Map<Number, String>?, format: String?): String {
        var bijiaodate: xDate = xDate()
        if (target is xDate) {
            bijiaodate = (target as xDate)
        } else if (UTSAndroid.`typeof`(target) == "string") {
            bijiaodate = xDate(target as String)
        } else if (target == null) {
            bijiaodate = xDate()
        }
        var fmt = if (format == null) {
            "YYYY-MM-DD"
        } else {
            format!!
        }
        if (model != null && model!!.size > 0) {
            var mapmodel = model!!
            var str = ""
            var fanzhumap = _uA<Number>()
            mapmodel.forEach(fun(_v: String, key: Number){
                fanzhumap.push(key)
            }
            )
            fanzhumap.reverse()
            try {
                var startTime = bijiaodate.getTime("s")
                var nowTime = this.getTime("s")
                var diff = (nowTime - startTime) / 1000
                if (diff > 0) {
                    run {
                        var i: Number = 0
                        while(i < fanzhumap.length){
                            if (diff >= fanzhumap[i]) {
                                str = mapmodel.get(fanzhumap[i])!!
                                break
                            }
                            i++
                        }
                    }
                } else {
                    str = mapmodel.get(fanzhumap[fanzhumap.length - 1])!!
                }
                if (str == "") {
                    str = bijiaodate.format(fmt)
                }
            }
             catch (_e: Throwable) {}
            return str
        }
        var relativeTime = getLocaleData().relativeTime
        var mmSuffix = relativeTime.mm.replace("%d", "")
        var hhSuffix = relativeTime.hh.replace("%d", "")
        var ddSuffix = relativeTime.dd.replace("%d", "")
        var MMSuffix = relativeTime.MM.replace("%d", "")
        var labels = _uA(
            "",
            relativeTime.y,
            "6" + MMSuffix,
            "5" + MMSuffix,
            "4" + MMSuffix,
            "3" + MMSuffix,
            "2" + MMSuffix,
            relativeTime.M,
            "7" + ddSuffix,
            "2" + ddSuffix,
            relativeTime.d,
            "23" + hhSuffix,
            "5" + hhSuffix,
            "3" + hhSuffix,
            "2" + hhSuffix,
            relativeTime.h,
            "30" + mmSuffix,
            "10" + mmSuffix,
            "5" + mmSuffix,
            relativeTime.m,
            relativeTime.s
        ) as UTSArray<String>
        var str = ""
        try {
            var startTime = bijiaodate.getTime("s")
            var nowTime = this.getTime("s")
            var diff = (nowTime - startTime) / 1000
            if (diff > 0) {
                run {
                    var i: Number = 0
                    while(i < _timeThresholds.length){
                        if (diff >= _timeThresholds[i]) {
                            str = labels[i]
                            break
                        }
                        i++
                    }
                }
            } else {
                str = labels[labels.length - 1]
            }
            if (str == "") {
                str = bijiaodate.format(fmt)
            }
        }
         catch (_e: Throwable) {}
        return str
    }
    open fun diffTime(target: Any, type: xDateTypeTime = "s"): Number {
        var startTime: Number = 0
        var typed: xDateTypeTime = if (type == "w") {
            "d"
        } else {
            type
        }
        if (target is xDate) {
            startTime = (target as xDate).getTime(typed)
        } else if (UTSAndroid.`typeof`(target) == "string") {
            startTime = xDate(target as String).getTime(typed)
        } else if (target == null) {
            startTime = xDate().getTime(typed)
        }
        var nowTime = this.getTime(typed)
        var diff = Math.abs(nowTime - startTime)
        var d: Number = 0
        if (type == "s") {
            d = diff / 1000
        } else if (type == "M") {
            d = diff / 60 / 1000
        } else if (type == "h") {
            d = diff / 60 / 60 / 1000
        } else if (type == "d") {
            d = diff / 60 / 60 / 24 / 1000
        } else if (type == "m") {
            d = diff / 60 / 60 / 24 / 30 / 1000
        } else if (type == "y") {
            d = diff / 60 / 60 / 24 / 30 / 12 / 1000
        } else if (type == "w") {
            var ondate: Number = 604800000
            d = diff / ondate
        }
        return Math.floor(d)
    }
    open fun getQuarter(type: String = ""): UTSArray<xDateTypeQuarter> {
        var q1: UTSArray<Number> = _uA(
            1,
            2,
            3
        )
        var q2: UTSArray<Number> = _uA(
            4,
            5,
            6
        )
        var q3: UTSArray<Number> = _uA(
            7,
            8,
            9
        )
        var q4: UTSArray<Number> = _uA(
            10,
            11,
            12
        )
        var nowMonth = this.getMonth() + 1
        var qall = _uA<UTSArray<Number>>(q1, q2, q3, q4)
        var qmap = _uA<xDateTypeQuarter>()
        if (type == "y") {
            run {
                var i: Number = 0
                while(i < qall.length){
                    var item = qall[i]
                    var sdate = xDate(this.getYear() + "/" + item[0] + "/1")
                    var edate = xDate(this.getYear() + "/" + item[item.length - 1] + "/1")
                    var start = sdate.format("YYYY/MM/DD")
                    var end = edate.getDateEndOf("m").format("YYYY/MM/DD")
                    qmap.push(xDateTypeQuarter(quarter = i, start = start, end = end))
                    i++
                }
            }
        } else {
            run {
                var i: Number = 0
                while(i < qall.length){
                    var item = qall[i]
                    if (item.includes(nowMonth)) {
                        var sdate = xDate(this.getYear() + "/" + item[0] + "/1")
                        var edate = xDate(this.getYear() + "/" + item[item.length - 1] + "/1")
                        var start = sdate.format("YYYY/MM/DD")
                        var end = edate.getDateEndOf("m").format("YYYY/MM/DD")
                        qmap.push(xDateTypeQuarter(quarter = i, start = start, end = end))
                        break
                    }
                    i++
                }
            }
        }
        return qmap
    }
    open fun setDateLocale(locale: xDateLanguage): Unit {
        setLocale(locale)
    }
    open fun getDateLocale(): xDateLanguage {
        return getCurrentLocale()
    }
    open fun getBetweenDate(start: Any, end: Any, minx: String = "auto"): Date {
        var _start = this.checkDate(start)
        var _end = this.checkDate(end)
        var startDiff = _start.getTime()
        var endDiff = _end.getTime()
        var nowDiff = this.getTime("ms")
        if (nowDiff >= startDiff && nowDiff <= endDiff) {
            return this.date
        }
        if (minx == "min") {
            return _start
        }
        if (minx == "max") {
            return _end
        }
        if (nowDiff < startDiff) {
            return _start
        }
        return _end
    }
}
val dateCovertXdate = fun(date: Date): xDate {
    return xDate(date)
}
val i18n = xConfig.i18n
typealias xRequestEventType = String
typealias funType = (arg: Any) -> UTSPromise<Any>
open class funCall (
    @JsonNotNull
    open var `fun`: funType,
    @JsonNotNull
    open var type: xRequestEventType,
) : UTSObject()
fun getUid__1(rdix: Number = 1, length: Number = 12): String {
    var ix = ""
    ix = Math.floor(Math.random() * rdix * Math.floor(Math.random() * Date.now())).toString(10).substring(0, length as Int)
    return ix
}
open class xCacheManager {
    private var cache = _uO()
    constructor(){
        var cs = uni_getStorageSync("xCacheManager")
        if (cs is UTSJSONObject) {
            this.cache = cs!! as UTSJSONObject
        }
    }
    open fun generateCacheKey(config: xRequestOptionsCallBack): String {
        val url = config.url
        val method = config.method
        val qIdx = url.indexOf("?")
        var key = method + "_" + (if (qIdx > 0) {
            url.substring(0, qIdx)
        } else {
            url
        }
        )
        if (config.data != null) {
            if (!(config.data is UTSJSONObject)) {
                key += "_d:" + config.data
            } else {
                var _data = config.data as UTSJSONObject
                var _keys = _uA<String>()
                for(k in resolveUTSKeyIterator(_data)){
                    _keys.push(k)
                }
                key += "_d:" + _keys.sort().join(",")
            }
        }
        return key
    }
    open fun set(config: xRequestOptionsCallBack, response: Any): Unit {
        val key = this.generateCacheKey(config)
        this.cache.set(key, _uO("data" to response, "timestamp" to Date.now()))
        try {
            uni_setStorageSync("xCacheManager", this.cache)
        }
         catch (error: Throwable) {
            this.pruneCache()
            try {
                uni_setStorageSync("xCacheManager", this.cache)
            }
             catch (e: Throwable) {
                console.error("二次缓存设置失败")
            }
        }
    }
    open fun get(config: xRequestOptionsCallBack): Any? {
        val key = this.generateCacheKey(config)
        val cacheItem = this.cache.getJSON(key)
        if (cacheItem == null) {
            return null
        }
        val cacheTime = if (config.cacheTime == 0) {
            60000
        } else {
            config.cacheTime
        }
        if (Date.now() - cacheItem.getNumber("timestamp")!! > cacheTime) {
            this.cache.set(key, null)
            return null
        }
        return cacheItem.getAny("data")
    }
    open fun clear(): Unit {
        this.cache = _uO()
        uni_removeStorageSync("xCacheManager")
    }
    private fun pruneCache(): Unit {
        val _keys = _uA<String>()
        for(key in resolveUTSKeyIterator(this.cache)){
            _keys.push(key)
        }
        if (_keys.length > 20) {
            val sortedKeys = _keys.sort(fun(a: String, b: String): Number {
                var ad = this.cache[a]!! as UTSJSONObject
                var bd = this.cache[b]!! as UTSJSONObject
                return ad.getNumber("timestamp")!! - bd.getNumber("timestamp")!!
            }
            )
            val halfIndex = Math.floor(sortedKeys.length / 2)
            var allkeys: UTSJSONObject = _uO()
            run {
                var i = halfIndex
                while(i < sortedKeys.length){
                    var key = sortedKeys[i]
                    allkeys.set(key, this.cache[key])
                    i++
                }
            }
            this.cache = allkeys
            uni_setStorageSync("xCacheManager", allkeys)
            console.log("已清理" + halfIndex + "个旧缓存项")
        }
    }
}
open class xRequest {
    private var auth = true
    private var cacheManager: xCacheManager
    private var selfOpts = xRequestOptionsCallBack(useCache = false, cacheTime = 60000, hostUrl = xRequestCall.hostUrl, successStatusCode = 200, url = "", data = _uO(), header = _uO("content-type" to "application/json"), method = "GET", timeout = 6000, firstIpv4 = false, showLoadToast = xRequestCall.showLoadToast, showSuccessToast = xRequestCall.showSuccessToast, showErrorToast = xRequestCall.showErrorToast, loadToastText = i18n.t("tmui4x.xRequest.loading"), successToastText = i18n.t("tmui4x.xRequest.success"), errorToastText = "")
    private var _lisentEventList = _uA<funCall>()
    private var status = null as xRequestEventType?
    private var result = xRequestResult(data = null, statusCode = 0, header = _uO() as Any, cookies = _uA<String>())
    private var reqtask = null as RequestTask?
    constructor(opts: xRequestOptions? = null){
        this.setOptions(opts)
        this.cacheManager = xCacheManager()
    }
    open fun setOptions(opts: xRequestOptions? = null): xRequestOptionsCallBack {
        if (opts == null) {
            return this.selfOpts
        }
        var mergedHeader: UTSJSONObject = _uO("content-type" to "application/json")
        if (xRequestCall.header != null) {
            var globalObj = xRequestCall.header as UTSJSONObject
            for(key in resolveUTSKeyIterator(globalObj)){
                mergedHeader.set(key, globalObj.get(key))
            }
        }
        var userHeader = opts.header
        if (userHeader != null) {
            var uh = userHeader!! as UTSJSONObject
            for(key in resolveUTSKeyIterator(uh)){
                mergedHeader.set(key, uh.get(key))
            }
        }
        var dataTmep = opts?.data ?: (_uO())
        var firstIpv4 = (opts?.firstIpv4 ?: false) as Boolean
        var method = (opts?.method ?: this.selfOpts.method) as xRequestMethond
        var timeout = (opts?.timeout ?: this.selfOpts.timeout) as Number
        var successStatusCode = (opts?.successStatusCode ?: this.selfOpts.successStatusCode) as Number
        var url = (opts?.url ?: this.selfOpts.url) as String
        var showLoadToast = (opts?.showLoadToast ?: this.selfOpts.showSuccessToast) as Boolean
        var showSuccessToast = (opts?.showSuccessToast ?: this.selfOpts.showSuccessToast) as Boolean
        var showErrorToast = (opts?.showErrorToast ?: this.selfOpts.showErrorToast) as Boolean
        var hostUrl = (opts?.hostUrl ?: xRequestCall.hostUrl) as String
        var cacheTime = (opts?.cacheTime ?: this.selfOpts.cacheTime) as Number
        var useCache = (opts?.useCache ?: this.selfOpts.useCache) as Boolean
        var loadToastText = (opts?.loadToastText ?: this.selfOpts!!.loadToastText) as String
        var successToastText = (opts?.successToastText ?: this.selfOpts!!.successToastText) as String
        var errorToastText = (opts?.errorToastText ?: this.selfOpts!!.errorToastText) as String
        this.selfOpts.firstIpv4 = firstIpv4!!
        this.selfOpts.method = method!! as xRequestMethond
        this.selfOpts.timeout = timeout!!
        this.selfOpts.cacheTime = cacheTime!!
        this.selfOpts.useCache = useCache!!
        this.selfOpts.successStatusCode = successStatusCode!!
        this.selfOpts.data = dataTmep!!
        this.selfOpts.header = mergedHeader
        this.selfOpts.url = url!! as String
        this.selfOpts.showLoadToast = showLoadToast!! as Boolean
        this.selfOpts.showSuccessToast = showSuccessToast!! as Boolean
        this.selfOpts.showErrorToast = showErrorToast!! as Boolean
        this.selfOpts.responseType = opts.responseType
        this.selfOpts.dataType = opts.dataType
        this.selfOpts.hostUrl = hostUrl
        this.selfOpts!!.loadToastText = loadToastText
        this.selfOpts!!.successToastText = successToastText
        this.selfOpts!!.errorToastText = errorToastText
        return this.selfOpts
    }
    open fun addEventListener(event: xRequestEventType = "success", kFun: (arg: Any) -> UTSPromise<Any>): xRequest {
        this._lisentEventList.push(funCall(type = event, `fun` = kFun))
        return this
    }
    open fun abort(): Boolean {
        if (this.reqtask != null) {
            this.reqtask!!.abort()
            return true
        }
        return false
    }
    private fun _callFun_build(): UTSPromise<UTSArray<Any>> {
        if (this.status == null) {
            return UTSPromise.resolve(_uA<Any>(true))
        }
        val st = this.status!!
        var funCalls = _uA<funType>()
        run {
            var i: Number = 0
            while(i < this._lisentEventList.length){
                if (this._lisentEventList[i].type == st) {
                    funCalls.push(this._lisentEventList[i].`fun`)
                }
                i++
            }
        }
        if (funCalls.length == 0) {
            if (st == "auth" || st == "before") {
                return UTSPromise.resolve(_uA<Any>(true))
            }
            return UTSPromise.resolve(_uA<Any>(this.result))
        }
        return this._buildPromise(funCalls)
    }
    private fun _buildPromise(lst: UTSArray<funType>): UTSPromise<UTSArray<Any>> {
        var _this = this
        var len = lst.length
        var i: Number = 0
        var p = _uA<Any>()
        fun customPromiseAll(evt: funType): UTSPromise<Any> {
            return wrapUTSPromise(suspend w1@{
                    if (i >= len) {
                        return@w1 UTSPromise.resolve(p)
                    }
                    var arg: Any = _this.selfOpts
                    if (_this.status != "auth" && _this.status != "before") {
                        arg = _this.result as xRequestResult
                    }
                    var v = await(evt(arg))
                    if ((_this.status == "auth") && UTSAndroid.`typeof`(v) != "boolean") {
                        v = true
                    }
                    if ((_this.status == "before") && UTSAndroid.`typeof`(v) != "boolean") {
                        var beforeOpts = JSON.stringify(v)
                        _this.setOptions(JSON.parse<xRequestOptions>(beforeOpts!!)!!)
                        v = true
                    }
                    if ((_this.status == "before") && UTSAndroid.`typeof`(v) == "boolean") {
                        var iabort = v as Boolean
                        if (!iabort) {
                            p.push(v)
                            return@w1 UTSPromise.resolve(p)
                        }
                    }
                    if ((_this.status == "after") && UTSAndroid.`typeof`(v) == "object") {
                        _this.result = v as xRequestResult
                    }
                    if (_this.status == "success" || _this.status == "timeout" || _this.status == "error" || _this.status == "abort" || _this.status == "complete") {
                        v = _this.result
                    }
                    i += 1
                    p.push(v)
                    if (i >= len) {
                        return@w1 UTSPromise.resolve(p)
                    }
                    return@w1 await(customPromiseAll(lst[i]))
            })
        }
        return UTSPromise(fun(res, rej){
            customPromiseAll(lst[i]).then(fun(){
                res(p)
            }
            )
        }
        )
    }
    private fun _setDevReqStatus(id: String) {
        if (!xRequestCall.dev) {
            return
        }
        var eventType = this.status
        var index: Number = -1
        run {
            var i: Number = 0
            while(i < xRequestCall.history.length){
                var item = xRequestCall.history[i]
                if (id == item.id) {
                    index = i
                    break
                }
                i++
            }
        }
        if (index > -1 && eventType != null) {
            xRequestCall.history[index].status = eventType
            if (eventType == "complete" || eventType == "abort" || eventType == "auth") {
                xRequestCall.history[index].loaded = true
                xRequestCall.history[index].loading = false
            }
            if (eventType == "before") {
                xRequestCall.history[index].loading = true
            }
            if (eventType == "success") {
                xRequestCall.history[index].time = Date.now() - xRequestCall.history[index].time
            }
            if (eventType == "complete" || eventType == "success") {
                xRequestCall.history[index].result = this.result
            }
        }
    }
    open fun request(opts: xRequestOptions? = null): UTSPromise<xRequestResult> {
        return wrapUTSPromise(suspend w@{
                var _this = this
                var _thisOpts = this.setOptions(opts)
                var requestId = getUid__1()
                if (xRequestCall.dev) {
                    xRequestCall.history.push(xRequestHistoryType(id = requestId, loading = true, loaded = false, status = "", time = Date.now(), api = _thisOpts.url, result = _uO() as Any))
                }
                if (_thisOpts.showLoadToast) {
                    uni_showLoading(ShowLoadingOptions(title = _thisOpts!!.loadToastText!!, mask = true))
                }
                val url = _thisOpts.hostUrl + _thisOpts.url
                if (url == "" || _thisOpts.hostUrl == "") {
                    this.status = "error"
                    this._setDevReqStatus(requestId)
                    await(this._callFun_build())
                    console.warn("未填写请求接口")
                    if (_thisOpts.showLoadToast) {
                        uni_hideLoading(null)
                    }
                    if (_thisOpts.showErrorToast) {
                        return@w UTSPromise<xRequestResult>(fun(tres, trej){
                            uni_showToast(ShowToastOptions(title = i18n.t("tmui4x.xRequest.hostFailEmpty"), icon = "error", mask = true, complete = fun(_) {
                                trej(_this.result)
                            }
                            ))
                        }
                        )
                    }
                    return@w UTSPromise.reject(_this.result)
                }
                if (xRequestCall.authPass == false) {
                    this.status = "auth"
                    console.warn("授权失败，中断请求")
                    this._setDevReqStatus(requestId)
                    await(this._callFun_build())
                    if (_thisOpts.showLoadToast) {
                        uni_hideLoading(null)
                    }
                    return@w UTSPromise.reject(_thisOpts)
                }
                if (_thisOpts.useCache && (_thisOpts.method == "GET" || _thisOpts.method == "POST")) {
                    val cachedResponse = this.cacheManager.get(_thisOpts)
                    if (cachedResponse != null) {
                        val cachedata = cachedResponse as UTSJSONObject
                        val _cookies = cachedata.getArray<String>("cookies")
                        val cacheResult = xRequestResult(data = cachedata.getAny("data"), statusCode = cachedata.getNumber("statusCode")!!, header = cachedata.getAny("header")!!, cookies = if (_cookies == null) {
                            (_uA<String>())
                        } else {
                            _cookies!!
                        }
                        )
                        if (_thisOpts.showLoadToast) {
                            uni_hideLoading(null)
                        }
                        return@w UTSPromise.resolve(cacheResult)
                    }
                }
                this.status = "before"
                this._setDevReqStatus(requestId)
                var jg2 = await(this._callFun_build())
                var isAbor = (jg2 as UTSArray<Boolean>).some(fun(el): Boolean {
                    return !el
                }
                )
                if (isAbor) {
                    console.warn("事件before中断了请求")
                    this.status = "abort"
                    this._setDevReqStatus(requestId)
                    await(this._callFun_build())
                    if (_thisOpts.showLoadToast) {
                        uni_hideLoading(null)
                    }
                    return@w UTSPromise.reject(this.result)
                }
                return@w UTSPromise(fun(res, rej){
                    _this.reqtask = uni_request<Any>(RequestOptions(url = url, data = _thisOpts.data, header = _thisOpts.header, method = _thisOpts.method, timeout = _thisOpts.timeout, firstIpv4 = _thisOpts.firstIpv4, sslVerify = false, withCredentials = false, dataType = _thisOpts.dataType, responseType = _thisOpts.responseType, success = fun(rst) {
                        _this.result = xRequestResult(data = rst.data, statusCode = rst.statusCode, header = rst.header, cookies = rst.cookies as UTSArray<String>)
                        _this.status = "after"
                        _this._setDevReqStatus(requestId)
                        _this._callFun_build().then(fun(v){
                            if (_thisOpts.successStatusCode != rst.statusCode) {
                                _this.status = "error"
                                _this.result.statusCode = rst.statusCode
                                _this._setDevReqStatus(requestId)
                                _this._callFun_build().then(fun(){
                                    if (_thisOpts.showLoadToast) {
                                        uni_hideLoading(null)
                                    }
                                    if (_thisOpts.showErrorToast) {
                                        var msg = _thisOpts!!.errorToastText
                                        msg = if (msg == "") {
                                            (i18n.t("tmui4x.xRequest.error") + rst.statusCode.toString(10))
                                        } else {
                                            msg
                                        }
                                        uni_showToast(ShowToastOptions(title = msg!!, mask = true, icon = "error", complete = fun(_) {
                                            rej(_this.result)
                                        }))
                                    } else {
                                        rej(_this.result)
                                    }
                                }
                                )
                                return
                            }
                            var jgtss = v as UTSArray<xRequestResult>
                            var formartv = _this.result as xRequestResult
                            if (jgtss.length > 0) {
                                formartv = jgtss[jgtss.length - 1]
                            }
                            _this.result = formartv
                            _this.status = "success"
                            _this._setDevReqStatus(requestId)
                            _this._callFun_build().then(fun(){
                                if (_thisOpts.showLoadToast) {
                                    uni_hideLoading(null)
                                }
                                _this.cacheManager.set(_thisOpts, _this.result)
                                if (_thisOpts.showSuccessToast) {
                                    var d = formartv.data
                                    var msg = _thisOpts!!.successToastText
                                    if (UTSAndroid.`typeof`(d) == "object" && d != null && !UTSArray.isArray(d) && msg == "") {
                                        try {
                                            var s = d as UTSJSONObject
                                            msg = if (s.getString("msg") != null) {
                                                s.getString("msg")!!
                                            } else {
                                                msg
                                            }
                                        }
                                         catch (e: Throwable) {
                                            console.error("服务没有返回msg字段")
                                        }
                                    }
                                    msg = if (msg == "") {
                                        i18n.t("tmui4x.xRequest.success")
                                    } else {
                                        msg
                                    }
                                    uni_showToast(ShowToastOptions(title = msg!!, icon = "none", mask = true, complete = fun(_) {
                                        res(_this.result)
                                    }))
                                } else {
                                    res(_this.result)
                                }
                            }
                            )
                        }
                        )
                    }
                    , fail = fun(er) {
                        if (er.errCode == 5) {
                            _this.status = "timeout"
                        } else {
                            _this.status = "error"
                        }
                        _this.result.statusCode = er.errCode
                        _this._setDevReqStatus(requestId)
                        _this._callFun_build().then(fun(){
                            if (_thisOpts.showLoadToast) {
                                uni_hideLoading(null)
                            }
                            if (_thisOpts.showErrorToast) {
                                uni_showToast(ShowToastOptions(title = i18n.t("tmui4x.xRequest.error") + er.errCode.toString(), mask = true, icon = "error", complete = fun(_) {
                                    rej(_this.result)
                                }))
                            } else {
                                rej(_this.result)
                            }
                        }
                        )
                    }
                    , complete = fun(_) {
                        _this.status = "complete"
                        _this._setDevReqStatus(requestId)
                        _this._callFun_build()
                    }
                    ))
                }
                )
        })
    }
    companion object {
        fun setAuth(isPass: Boolean) {
            xRequestCall.authPass = isPass
        }
        fun setHeader(header: UTSJSONObject? = null): UTSJSONObject? {
            if (xRequestCall.header == null) {
                xRequestCall.header = header
            } else {
                var obj = xRequestCall.header as UTSJSONObject
                var newObj = header!! as UTSJSONObject
                for(key in resolveUTSKeyIterator(newObj)){
                    obj.set(key, newObj.get(key))
                }
                xRequestCall.header = obj
            }
            return xRequestCall.header
        }
        fun setHostUrl(url: String?) {
            xRequestCall.hostUrl = if (url == null) {
                ""
            } else {
                url!!
            }
        }
        fun setDev(dev: Boolean = false) {
            xRequestCall.dev = dev
            if (dev) {
                console.warn("tmui4.0提醒：" + "你开启了请求调试模式")
            } else {
                console.warn("tmui4.0提醒：" + "你关闭了请求调试模式")
            }
        }
        fun getHistory(): UTSArray<xRequestHistoryType> {
            return xRequestCall.history.slice(0)
        }
        fun setShowToast(showLoadToast: Boolean = true, showSuccessToast: Boolean = true, showErrorToast: Boolean = true) {
            xRequestCall.showLoadToast = showLoadToast
            xRequestCall.showSuccessToast = showSuccessToast
            xRequestCall.showErrorToast = showErrorToast
        }
    }
}
open class ATTRGERTS (
    @JsonNotNull
    open var from: String,
    @JsonNotNull
    open var to: String,
    @JsonNotNull
    open var unit: String,
    @JsonNotNull
    open var now: String,
    @JsonNotNull
    open var progress: Number,
    @JsonNotNull
    open var name: String,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return ATTRGERTSReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class ATTRGERTSReactiveObject : ATTRGERTS, IUTSReactive<ATTRGERTS> {
    override var __v_raw: ATTRGERTS
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: ATTRGERTS, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(from = __v_raw.from, to = __v_raw.to, unit = __v_raw.unit, now = __v_raw.now, progress = __v_raw.progress, name = __v_raw.name) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): ATTRGERTSReactiveObject {
        return ATTRGERTSReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var from: String
        get() {
            return _tRG(__v_raw, "from", __v_raw.from, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("from")) {
                return
            }
            val oldValue = __v_raw.from
            __v_raw.from = value
            _tRS(__v_raw, "from", oldValue, value)
        }
    override var to: String
        get() {
            return _tRG(__v_raw, "to", __v_raw.to, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("to")) {
                return
            }
            val oldValue = __v_raw.to
            __v_raw.to = value
            _tRS(__v_raw, "to", oldValue, value)
        }
    override var unit: String
        get() {
            return _tRG(__v_raw, "unit", __v_raw.unit, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("unit")) {
                return
            }
            val oldValue = __v_raw.unit
            __v_raw.unit = value
            _tRS(__v_raw, "unit", oldValue, value)
        }
    override var now: String
        get() {
            return _tRG(__v_raw, "now", __v_raw.now, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("now")) {
                return
            }
            val oldValue = __v_raw.now
            __v_raw.now = value
            _tRS(__v_raw, "now", oldValue, value)
        }
    override var progress: Number
        get() {
            return _tRG(__v_raw, "progress", __v_raw.progress, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("progress")) {
                return
            }
            val oldValue = __v_raw.progress
            __v_raw.progress = value
            _tRS(__v_raw, "progress", oldValue, value)
        }
    override var name: String
        get() {
            return _tRG(__v_raw, "name", __v_raw.name, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("name")) {
                return
            }
            val oldValue = __v_raw.name
            __v_raw.name = value
            _tRS(__v_raw, "name", oldValue, value)
        }
}
typealias callbackFunType__1 = (x: Number) -> Number
open class xAnimate {
    open var easingList = Map<String, UTSArray<Number>>(_uA(
        _uA(
            "linear",
            _uA(
                0.250,
                0.250,
                0.750,
                0.750
            )
        ),
        _uA(
            "ease",
            _uA(
                0.250,
                0.100,
                0.250,
                1.000
            )
        ),
        _uA(
            "easeIn",
            _uA(
                0.420,
                0.000,
                1.000,
                1.000
            )
        ),
        _uA(
            "easeOut",
            _uA(
                0.000,
                0.000,
                0.580,
                1.000
            )
        ),
        _uA(
            "easeInOut",
            _uA(
                0.420,
                0.000,
                0.580,
                1.000
            )
        ),
        _uA(
            "easeInQuad",
            _uA(
                0.550,
                0.085,
                0.680,
                0.530
            )
        ),
        _uA(
            "easeOutQuad",
            _uA(
                0.250,
                0.460,
                0.450,
                0.940
            )
        ),
        _uA(
            "easeInOutQuad",
            _uA(
                0.455,
                0.030,
                0.515,
                0.955
            )
        ),
        _uA(
            "easeInCubic",
            _uA(
                0.550,
                0.055,
                0.675,
                0.190
            )
        ),
        _uA(
            "easeOutCubic",
            _uA(
                0.215,
                0.610,
                0.355,
                1.000
            )
        ),
        _uA(
            "easeInOutCubic",
            _uA(
                0.645,
                0.045,
                0.355,
                1.000
            )
        ),
        _uA(
            "easeInQuart",
            _uA(
                0.895,
                0.030,
                0.685,
                0.220
            )
        ),
        _uA(
            "easeOutQuart",
            _uA(
                0.165,
                0.840,
                0.440,
                1.000
            )
        ),
        _uA(
            "easeInOutQuart",
            _uA(
                0.770,
                0.000,
                0.175,
                1.000
            )
        ),
        _uA(
            "easeInQuint",
            _uA(
                0.755,
                0.050,
                0.855,
                0.060
            )
        ),
        _uA(
            "easeOutQuint",
            _uA(
                0.230,
                1.000,
                0.320,
                1.000
            )
        ),
        _uA(
            "easeInOutQuint",
            _uA(
                0.860,
                0.000,
                0.070,
                1.000
            )
        ),
        _uA(
            "easeInSine",
            _uA(
                0.470,
                0.000,
                0.745,
                0.715
            )
        ),
        _uA(
            "easeOutSine",
            _uA(
                0.390,
                0.575,
                0.565,
                1.000
            )
        ),
        _uA(
            "easeInOutSine",
            _uA(
                0.445,
                0.050,
                0.550,
                0.950
            )
        ),
        _uA(
            "easeInExpo",
            _uA(
                0.950,
                0.050,
                0.795,
                0.035
            )
        ),
        _uA(
            "easeOutExpo",
            _uA(
                0.190,
                1.000,
                0.220,
                1.000
            )
        ),
        _uA(
            "easeInOutExpo",
            _uA(
                1.000,
                0.000,
                0.000,
                1.000
            )
        ),
        _uA(
            "easeInCirc",
            _uA(
                0.600,
                0.040,
                0.980,
                0.335
            )
        ),
        _uA(
            "easeOutCirc",
            _uA(
                0.075,
                0.820,
                0.165,
                1.000
            )
        ),
        _uA(
            "easeInOutBack",
            _uA(
                0.680,
                -0.550,
                0.265,
                1.550
            )
        )
    ))
    private var tid = null as Number?
    open var element = null as UniElement?
    open var timingFunction = "linear"
    open var duration: Number = 500
    open var ele = ""
    open var running = false
    open var pauseing = false
    open var progress: Number = 0
    open var reverse = false
    open var tyty = false
    open var _tyty = false
    open var loop: Number = 1
    private var _loop: Number = 0
    private var _isStopping = true
    private var attrIndex: Number = 0
    private var completeCallBack = fun(){}
    private var startCallBack = fun(){}
    private var doCallBack = fun(propress: Number){}
    private var tagetsAttr = _uA<ATTRGERTS>()
    private var startTime: Number = 0
    private var easing = null as callbackFunType__1?
    private var isDescPlay = false
    private var enterCallFun = fun(){}
    private var ChoreographerDemo = null as Choreographer?
    private var FrameCallbackCallFun = null as FrameCallback?
    constructor(ele: UniElement?, options: XANIMATE_OPIONS){
        this.element = ele
        this.duration = if (options.duration == null) {
            this.duration
        } else {
            options.duration!!
        }
        this.loop = if (options.loop == null) {
            this.loop
        } else {
            options.loop!!
        }
        this.tyty = if (options.tyty == null) {
            this.tyty
        } else {
            options.tyty!!
        }
        this.isDescPlay = if (options.isDescPlay == null) {
            this.isDescPlay
        } else {
            options.isDescPlay!!
        }
        var easingName = if (options.timingFunction == null) {
            "linear"
        } else {
            options.timingFunction!!
        }
        var ecall = this.easingList.get(easingName)
        if (ecall != null) {
            var ecallps = ecall!!
            this.easing = bezier(ecallps[0], ecallps[1], ecallps[2], ecallps[3])
        }
        if (options.bezier != null) {
            var ecallps = options.bezier!!
            this.easing = bezier(ecallps[0], ecallps[1], ecallps[2], ecallps[3])
        }
        if (options.complete != null) {
            this.completeCallBack = options.complete!!
        }
        if (options.start != null) {
            this.startCallBack = options.start!!
        }
        if (options.frame != null) {
            this.doCallBack = options.frame!!
        }
    }
    private fun getUnit(n: String?): String {
        if (n == null) {
            return "px"
        }
        var unit = n.replace(UTSRegExp("[\\d|\\-|\\+]", "g"), "")
        if (unit == ".") {
            unit = ""
        }
        return unit
    }
    open fun addTimingFunction(name: String, nubs: UTSArray<Number>) {
        this.easingList.set(name, nubs)
    }
    open fun setAniReverse(n: Boolean? = null) {
        if (n != null) {
            this.reverse = n!!
        } else {
            this.reverse = !this.reverse
        }
    }
    open fun setLoops(n: Number? = null) {
        if (n != null) {
            this.loop = n!!
        }
    }
    open fun setDurations(n: Number? = null) {
        if (n != null) {
            this.duration = n!!
        }
    }
    open fun setTytys(n: Boolean? = null) {
        if (n != null) {
            this.tyty = n!!
        }
    }
    open fun attr(name: String, from: String, to: String, only: Boolean = true): xAnimate {
        var unit = if (this.isColorStyle(name)) {
            ""
        } else {
            this.getUnit(from)
        }
        var from_n = if (this.isColorStyle(name)) {
            getDefaultColor(from)
        } else {
            parseFloat(from).toString(10)
        }
        var to_n = if (this.isColorStyle(name)) {
            getDefaultColor(to)
        } else {
            parseFloat(to).toString(10)
        }
        var index = this.tagetsAttr.findIndex(fun(item: ATTRGERTS): Boolean {
            return item.name == name
        }
        )
        if (!only) {
            index = -1
        }
        if (index == -1) {
            this.tagetsAttr.push(ATTRGERTS(from = from_n.toString(), to = to_n.toString(), unit = unit, progress = 0, now = from_n, name = name))
        } else {
            this.tagetsAttr[index] = ATTRGERTS(from = from_n.toString(), to = to_n.toString(), unit = unit, progress = 0, now = from_n, name = name)
        }
        return this
    }
    private fun interpolate(startValue: Number, endValue: Number, progress: Number): Number {
        return startValue + (endValue - startValue) * progress
    }
    private fun isColorStyle(kVal: String): Boolean {
        return kVal.indexOf("background") > -1 || kVal.indexOf("color") > -1
    }
    private fun _setAttr(name: String, current: Number, unit: String, progress: Number, item: ATTRGERTS) {
        if (this.element == null) {
            return
        }
        if (name == "scaleX") {
            this.element!!.style!!.setProperty("transform", "scaleX(" + current + ")")
        } else if (name == "scaleY") {
            this.element!!.style!!.setProperty("transform", "scaleY(" + current + ")")
        } else if (name == "scale") {
            this.element!!.style!!.setProperty("transform", "scale(" + current + ")")
        } else if (name == "rotateX") {
            this.element!!.style!!.setProperty("transform", "rotateX(" + (current.toString(10) + unit) + ")")
        } else if (name == "rotateY") {
            this.element!!.style!!.setProperty("transform", "rotateY(" + (current.toString(10) + unit) + ")")
        } else if (name == "rotate") {
            this.element!!.style!!.setProperty("transform", "rotate(" + (current.toString(10) + unit) + ")")
        } else if (name == "translateX") {
            this.element!!.style!!.setProperty("transform", "translateX(" + (current.toString(10) + unit) + ")")
        } else if (name == "translateY") {
            this.element!!.style!!.setProperty("transform", "translateY(" + (current.toString(10) + unit) + ")")
        } else if (name == "translate") {
            this.element!!.style!!.setProperty("transform", "translate(" + (current.toString(10) + unit) + "," + (current.toString(10) + unit) + ")")
        } else if (this.isColorStyle(name)) {
            var startRgba = hexToRgb(item.from)
            var dndRgba = hexToRgb(item.to)
            var r = this.interpolate(startRgba.getNumber("r")!!, dndRgba.getNumber("r")!!, progress)
            var g = this.interpolate(startRgba.getNumber("g")!!, dndRgba.getNumber("g")!!, progress)
            var b = this.interpolate(startRgba.getNumber("b")!!, dndRgba.getNumber("b")!!, progress)
            var a = this.interpolate(startRgba.getNumber("a")!!, dndRgba.getNumber("a")!!, progress)
            this.element!!.style!!.setProperty(name, "rgba(" + r.toFixed(0) + "," + g.toFixed(0) + "," + b.toFixed(0) + "," + a.toFixed(1) + ")")
        } else {
            this.element!!.style!!.setProperty(name, current.toFixed(2) + unit)
        }
    }
    private fun _run_web() {}
    private fun _run_weapp() {}
    private fun _run_andriod() {
        var _this = this
        _this.startTime = 0
        if (this.ChoreographerDemo == null) {
            this.ChoreographerDemo = Choreographer.getInstance()
        } else {
            if (this.FrameCallbackCallFun != null) {
                _this.ChoreographerDemo!!.removeFrameCallback(this.FrameCallbackCallFun!!)
            }
        }
        open class frameCallback : Choreographer.FrameCallback {
            override fun doFrame(frameTimeNanos: Long) {
                if (_this.startTime <= 0) {
                    _this.startTime = Date.now()
                }
                val progress = Math.min((Date.now() - _this.startTime) / _this.duration + _this.progress, 1)
                if (_this.element != null) {
                    if (!_this.isDescPlay) {
                        run {
                            var i: Number = 0
                            while(i < _this.tagetsAttr.length){
                                var item = _this.tagetsAttr[i]
                                if (!_this.isColorStyle(item.name)) {
                                    var fromN = parseFloat(item.from)
                                    var toN = parseFloat(item.to)
                                    var easeInt: Number = 1
                                    if (_this.easing != null) {
                                        var eas = _this.easing!!
                                        easeInt = eas(progress)
                                    }
                                    var current = fromN + (toN - fromN) * (if (easeInt == 1) {
                                        progress
                                    } else {
                                        easeInt
                                    })
                                    if (_this.reverse || _this._tyty) {
                                        current = toN + (fromN - toN) * (if (easeInt == 1) {
                                            progress
                                        } else {
                                            easeInt
                                        }
                                        )
                                    }
                                    if (_this.element != null) {
                                        _this._setAttr(item.name, current, item.unit, progress, item)
                                    }
                                } else {
                                    if (_this.element != null) {
                                        _this._setAttr(item.name, 0, item.unit, progress, item)
                                    }
                                }
                                i++
                            }
                        }
                    } else {
                        if (_this.attrIndex < _this.tagetsAttr.length) {
                            var item = _this.tagetsAttr[_this.attrIndex]
                            item.progress = progress
                            if (!_this.isColorStyle(item.name)) {
                                var fromN = parseFloat(item.from)
                                var toN = parseFloat(item.to)
                                var easeInt: Number = 1
                                if (_this.easing != null) {
                                    var eas = _this.easing!!
                                    easeInt = eas(progress)
                                }
                                var current = fromN + (toN - fromN) * (if (easeInt == 1) {
                                    progress
                                } else {
                                    easeInt
                                })
                                if (_this.reverse || _this._tyty) {
                                    current = toN + (fromN - toN) * (if (easeInt == 1) {
                                        progress
                                    } else {
                                        easeInt
                                    }
                                    )
                                }
                                if (_this.element != null) {
                                    _this._setAttr(item.name, current, item.unit, progress, item)
                                }
                            } else {
                                if (_this.element != null) {
                                    _this._setAttr(item.name, 0, item.unit, progress, item)
                                }
                            }
                        }
                    }
                }
                if (progress >= 1 || _this._isStopping) {
                    if (_this.isDescPlay && _this.attrIndex < _this.tagetsAttr.length) {
                        _this.attrIndex += 1
                        _this.progress = 0
                        _this._run_andriod()
                        return
                    }
                    _this.progress = 0
                    if (_this.tyty) {
                        _this._tyty = !_this._tyty
                    }
                    if (_this.loop == -1) {
                        _this._run_andriod()
                        return
                    } else {
                        _this._loop += 1
                        if (_this._loop < _this.loop) {
                            _this._run_andriod()
                            return
                        }
                    }
                    _this.running = false
                    _this.completeCallBack()
                    return
                }
                if (_this.pauseing) {
                    _this.running = false
                    console.log(_this.pauseing, "动画暂停")
                    _this.progress = progress
                    return
                }
                if (progress < 1 && _this.running) {
                    _this.doCallBack(progress)
                    _this.ChoreographerDemo!!.postFrameCallback(this)
                }
            }
        }
        _this.startCallBack()
        this.FrameCallbackCallFun = frameCallback()
        _this.ChoreographerDemo!!.postFrameCallback(this.FrameCallbackCallFun!!)
    }
    private fun __run_web() {}
    private fun __run_andriod() {
        var _this = this
        if (this.ChoreographerDemo == null) {
            this.ChoreographerDemo = Choreographer.getInstance()
        } else {
            if (this.FrameCallbackCallFun != null) {
                _this.ChoreographerDemo!!.removeFrameCallback(this.FrameCallbackCallFun!!)
            }
        }
        open class frameCallback : Choreographer.FrameCallback {
            override fun doFrame(frameTimeNanos: Long) {
                _this.enterCallFun()
                if (_this._isStopping) {
                    _this.running = false
                    return
                }
                if (_this.running) {
                    _this.ChoreographerDemo!!.postFrameCallback(this)
                }
            }
        }
        this.FrameCallbackCallFun = frameCallback()
        _this.ChoreographerDemo!!.postFrameCallback(this.FrameCallbackCallFun!!)
    }
    private fun __run_weapp() {}
    open fun play(): xAnimate {
        if (this.running) {
            return this
        }
        this.running = true
        this._isStopping = false
        this.pauseing = false
        this._loop = 0
        this.attrIndex = 0
        this._run_andriod()
        return this
    }
    open fun stop(): xAnimate {
        var _this = this
        this._isStopping = true
        this.progress = 0
        this.attrIndex = _this.tagetsAttr.length
        if (this.ChoreographerDemo == null) {
            this.ChoreographerDemo = Choreographer.getInstance()
        } else {
            if (this.FrameCallbackCallFun != null) {
                this.ChoreographerDemo!!.removeFrameCallback(this.FrameCallbackCallFun!!)
            }
        }
        return this
    }
    open fun pause(): xAnimate {
        this.pauseing = true
        return this
    }
    open fun enterFrame(evt: () -> Unit) {
        this.stop()
        this.enterCallFun = evt
        this.running = true
        this._isStopping = false
        this.__run_andriod()
    }
}
open class CONFIG (
    @JsonNotNull
    open var count: Number,
    @JsonNotNull
    open var sourceType: UTSArray<String>,
    @JsonNotNull
    open var sizeType: UTSArray<String>,
    @JsonNotNull
    open var hostUrl: String,
    @JsonNotNull
    open var name: String,
    @JsonNotNull
    open var header: UTSJSONObject,
    @JsonNotNull
    open var formData: UTSJSONObject,
    @JsonNotNull
    open var multipart: Boolean = false,
    @JsonNotNull
    open var autoUpload: Boolean = false,
    @JsonNotNull
    open var statusCode: Number,
    @JsonNotNull
    open var compress: Boolean = false,
    open var quality: Number? = null,
    open var compressedHeight: Number? = null,
    open var compressedWidth: Number? = null,
) : UTSObject()
open class xUploadMedia {
    open var model = "photo"
    open var videoOps = _uO("pageOrientation" to "auto", "albumMode" to "system", "sourceType" to _uA<String>("album", "camera"), "compressed" to true, "maxDuration" to 60, "camera" to "back")
    open var config = CONFIG(count = 9, sourceType = _uA(
        "album",
        "camera"
    ), sizeType = _uA(
        "original",
        "compressed"
    ), hostUrl = "", name = "file", header = _uO(), multipart = false, formData = _uO(), autoUpload = true, statusCode = 200, compress = true, quality = 80, compressedHeight = null, compressedWidth = null)
    open var fileList: UTSArray<XUPLOADFILE_FILE_INFO> = _uA()
    open var currentIndex: Number = 0
    open var uploading = false
    open var uploadObj = null as UploadTask?
    open var systemError = xConfig.i18n.t("tmui4x.uploadMedia.systemError")
    open var limitMaxCount = xConfig.i18n.t("tmui4x.uploadMedia.limitMaxCount")
    constructor(opts: XUPLOADFILE_INFO = XUPLOADFILE_INFO()){
        this.chuliConfigArgs(opts)
    }
    open var chooseBefore = fun(res: UTSArray<String>): UTSPromise<UTSArray<String>> {
        return UTSPromise.resolve(res)
    }
    open var complete = fun(res: UTSArray<XUPLOADFILE_FILE_INFO>): UTSPromise<UTSArray<XUPLOADFILE_FILE_INFO>> {
        return UTSPromise.resolve(res)
    }
    open var change = fun(res: UTSArray<XUPLOADFILE_FILE_INFO>): UTSPromise<UTSArray<XUPLOADFILE_FILE_INFO>> {
        return UTSPromise.resolve(res)
    }
    open var beforeComplete = fun(res: XUPLOADFILE_FILE_INFO): XUPLOADFILE_FILE_INFO {
        return res
    }
    open var myChangeSync = fun(res: UTSArray<XUPLOADFILE_FILE_INFO>) {}
    open var beforeUpload = fun(res: XUPLOADFILE_FILE_INFO): UTSPromise<XUPLOADFILE_FILE_INFO> {
        return UTSPromise.resolve(res)
    }
    open var events: Map<XUPLOADFILE_EVENT_NAME, (res: Any) -> UTSPromise<Any>> = Map()
    private fun chuliConfigArgs(opts: XUPLOADFILE_INFO): CONFIG {
        this.config = CONFIG(count = if (opts.count == null) {
            this.config.count
        } else {
            opts.count as Number
        }
        , statusCode = if (opts.statusCode == null) {
            this.config.statusCode
        } else {
            opts.statusCode as Number
        }
        , sourceType = if (opts.sourceType == null) {
            this.config.sourceType
        } else {
            opts.sourceType as UTSArray<String>
        }
        , sizeType = if (opts.sizeType == null) {
            this.config.sizeType
        } else {
            opts.sizeType as UTSArray<String>
        }
        , hostUrl = if (opts.hostUrl == null) {
            this.config.hostUrl
        } else {
            opts.hostUrl as String
        }
        , name = if (opts.name == null) {
            this.config.name
        } else {
            opts.name as String
        }
        , header = if (opts.header == null) {
            this.config.header
        } else {
            opts.header as UTSJSONObject
        }
        , formData = if (opts.formData == null) {
            this.config.formData
        } else {
            opts.formData as UTSJSONObject
        }
        , multipart = if (opts.multipart == null) {
            this.config.multipart
        } else {
            opts.multipart as Boolean
        }
        , autoUpload = if (opts.autoUpload == null) {
            this.config.autoUpload
        } else {
            opts.autoUpload as Boolean
        }
        , compress = if (opts.compress == null) {
            this.config.compress
        } else {
            opts.compress as Boolean
        }
        , quality = if (opts.quality == null) {
            this.config.quality
        } else {
            opts.quality as Number
        }
        , compressedHeight = opts.compressedHeight, compressedWidth = opts.compressedWidth)
        return this.config
    }
    open fun stop() {
        if (this.uploadObj == null) {
            return
        }
        this.currentIndex = 0
        this.uploading = false
        this.uploadObj!!.abort()
        this.uploadObj = null
        console.info("xUploadMedia:中断上传")
    }
    open fun chooseMedia() {
        if (this.fileList.length == this.config.count) {
            uni_showToast(ShowToastOptions(title = this.limitMaxCount, mask = true, icon = "none"))
            console.warn("xUploadMedia:已经超过最大上传数量")
            return
        }
        if (this.model == "photo") {
            uni_chooseImage(ChooseImageOptions(count = Math.max(this.config.count - this.fileList.length, 0), sourceType = this.config.sourceType, sizeType = this.config.sizeType, success = fun(res){
                var temps = _uA<UTSJSONObject>()
                var items = res.tempFiles
                run {
                    var i: Number = 0
                    while(i < res.tempFiles.length){
                        temps.push(_uO("path" to items[i].path, "size" to items[i].size))
                        i++
                    }
                }
                var chooseBefore = this.events.get("chooseBefore")
                if (chooseBefore != null) {
                    if (UTSArray.isArray(temps)) {
                        chooseBefore(res.tempFilePaths).then(fun(){
                            this.addNewFile(temps)
                            if (this.config.autoUpload && !this.uploading) {
                                this.start()
                            }
                        }).`catch`(fun(er){
                            console.error(er)
                            uni_showModal(ShowModalOptions(title = this.systemError, content = er as String, showCancel = false))
                        })
                    } else {
                        var tps = res.tempFilePaths as UTSJSONObject
                        chooseBefore(_uA<UTSJSONObject>(tps)).then(fun(){
                            this.addNewFile(temps)
                            if (this.config.autoUpload && !this.uploading) {
                                this.start()
                            }
                        }).`catch`(fun(er){
                            console.error(er)
                            uni_showModal(ShowModalOptions(title = this.systemError, content = er as String, showCancel = false))
                        })
                    }
                } else {
                    if (UTSArray.isArray(temps)) {
                        this.addNewFile(temps)
                        if (this.config.autoUpload && !this.uploading) {
                            this.start()
                        }
                    } else {
                        var tps = res.tempFilePaths as UTSJSONObject
                        this.addNewFile(_uA<UTSJSONObject>(tps))
                        if (this.config.autoUpload && !this.uploading) {
                            this.start()
                        }
                    }
                }
            }, fail = fun(err){
                this.chooseBefore(_uA<String>())
                console.warn("xUploadMedia:", err)
            }))
        } else if (this.model == "video") {
            var pageOrientation = this.videoOps.getString("pageOrientation")
            pageOrientation = if (pageOrientation == null) {
                "auto"
            } else {
                pageOrientation
            }
            var albumMode = this.videoOps.getString("albumMode")
            albumMode = if (albumMode == null) {
                "system"
            } else {
                albumMode
            }
            var sourceType = this.videoOps.getArray<String>("sourceType")
            sourceType = if (sourceType == null) {
                (_uA<String>("album", "camera"))
            } else {
                sourceType
            }
            var compressed = this.videoOps.getBoolean("compressed")
            compressed = if (compressed == null) {
                true
            } else {
                compressed
            }
            var maxDuration = this.videoOps.getNumber("maxDuration")
            maxDuration = if (maxDuration == null) {
                60
            } else {
                maxDuration
            }
            var camera = this.videoOps.getString("camera")
            camera = if (camera == null) {
                "back"
            } else {
                camera
            }
            uni_chooseVideo(ChooseVideoOptions(pageOrientation = pageOrientation, albumMode = albumMode, sourceType = sourceType, compressed = compressed, maxDuration = maxDuration, camera = camera, success = fun(res){
                var temps = _uA<UTSJSONObject>(_uO("path" to res.tempFilePath, "size" to res.size))
                var chooseBefore = this.events.get("chooseBefore")
                if (chooseBefore != null) {
                    chooseBefore(_uA<String>(res.tempFilePath)).then(fun(){
                        this.addNewFile(temps)
                        if (this.config.autoUpload && !this.uploading) {
                            this.start()
                        }
                    }).`catch`(fun(er){
                        console.error(er)
                        uni_showModal(ShowModalOptions(title = this.systemError, content = er as String, showCancel = false))
                    })
                } else {
                    this.addNewFile(temps)
                    if (this.config.autoUpload && !this.uploading) {
                        this.start()
                    }
                }
            }
            , fail = fun(err){
                this.chooseBefore(_uA<String>())
                console.warn("xUploadMedia:", err)
            }
            ))
        }
    }
    open fun addListenEvent(eventName: XUPLOADFILE_EVENT_NAME, callback: (res: Any) -> UTSPromise<Any>) {
        this.events.set(eventName, callback)
    }
    open fun <T : UTSArray<*>> addListenEventsss(eventName: XUPLOADFILE_EVENT_NAME, callback: (res: T) -> UTSPromise<T>) {
        if (eventName == "chooseBefore") {
            this.chooseBefore = fun(res2: UTSArray<String>): UTSPromise<UTSArray<String>> {
                return callback(res2 as UTSArray<*> as T) as UTSPromise<UTSArray<String>>
            }
        } else if (eventName == "complete") {
            this.complete = fun(res2: UTSArray<XUPLOADFILE_FILE_INFO>): UTSPromise<UTSArray<XUPLOADFILE_FILE_INFO>> {
                return callback(res2 as UTSArray<*> as T) as UTSPromise<UTSArray<XUPLOADFILE_FILE_INFO>>
            }
        } else if (eventName == "change") {
            this.change = fun(res2: UTSArray<XUPLOADFILE_FILE_INFO>): UTSPromise<UTSArray<XUPLOADFILE_FILE_INFO>> {
                return callback(res2 as UTSArray<*> as T) as UTSPromise<UTSArray<XUPLOADFILE_FILE_INFO>>
            }
        }
    }
    open fun setConfig(opts: XUPLOADFILE_INFO) {
        this.chuliConfigArgs(opts)
    }
    open fun setVideoOps(config: UTSJSONObject, model: String) {
        this.videoOps = config
        this.model = model
    }
    open fun setChangeSync(callBack: (res: UTSArray<XUPLOADFILE_FILE_INFO>) -> Unit) {
        this.myChangeSync = fun(res2: UTSArray<XUPLOADFILE_FILE_INFO>) {
            callBack(res2)
        }
    }
    open fun delFile(id: String): Boolean {
        var index = this.fileList.findIndex(fun(item: XUPLOADFILE_FILE_INFO): Boolean {
            return item.id == id
        }
        )
        if (index >= 0) {
            var item = this.fileList[index]
            if (item.status == 1) {
                item.status = 4
                item.statusText = "取消上传"
                this.stop()
            }
            this.fileList.splice(index, 1)
            this.myChangeSync(this.fileList)
            return true
        }
        return false
    }
    open fun clear() {
        this.fileList = _uA<XUPLOADFILE_FILE_INFO>()
        this.myChangeSync(this.fileList)
    }
    private fun addNewFile(files: UTSArray<UTSJSONObject>) {
        if (files.length == 0) {
            return
        }
        var t = this
        if (this.model == "photo") {
            var i: Number = 0
            fun compress() {
                if (i >= files.length) {
                    return
                }
                var item = files[i]!! as UTSJSONObject
                uni_compressImage(CompressImageOptions(src = item.getString("path")!!, quality = t.config.quality, compressedHeight = t.config.compressedHeight, compressedWidth = t.config.compressedWidth, success = fun(res: CompressImageSuccess){
                    item.set("path", res.tempFilePath)
                    i += 1
                    compress()
                }, fail = fun(err){
                    i += 1
                    compress()
                }))
            }
            if (this.config.compress) {
                compress()
            }
        } else if (this.model == "video") {
            var i: Number = 0
            fun compress() {
                if (i >= files.length) {
                    return
                }
                var item = files[i]!! as UTSJSONObject
                uni_compressVideo(CompressVideoOptions(src = item.getString("path")!!, quality = "medium", success = fun(res){
                    item.set("path", res.tempFilePath)
                    i += 1
                    compress()
                }
                , fail = fun(err){
                    i += 1
                    compress()
                }
                ))
            }
            if (this.config.compress) {
                compress()
            }
        }
        files.forEach(fun(item: UTSJSONObject){
            var id = getUid()
            var name = ""
            var size: Number = 0
            var items = item as UTSJSONObject
            name = items.getString("path")!!
            size = items.getNumber("size")!!
            this.fileList.push(XUPLOADFILE_FILE_INFO(id = id, type = "", size = size, extension = name.substring(name.lastIndexOf(".") + 1), statusText = "待上传", status = 0, path = name, progress = 0, response = "", name = name.substring(name.lastIndexOf("/") + 1), model = this.model))
        }
        )
        this.myChangeSync(this.fileList)
    }
    open fun addFile(files: UTSArray<XUPLOADFILE_FILE_VALUE>) {
        var ids = this.fileList.map(fun(el: XUPLOADFILE_FILE_INFO): String {
            return el.id
        }
        )
        var i: Number = 0
        var tempList: UTSArray<XUPLOADFILE_FILE_INFO> = _uA()
        var oldList = this.fileList.slice()
        files.forEach(fun(el: XUPLOADFILE_FILE_VALUE){
            var oldId = if (el.id == null) {
                ""
            } else {
                el.id!! as String
            }
            if (!ids.includes(oldId)) {
                var id = getUid()
                var name = el.url
                var status = el?.status ?: 2
                tempList.push(XUPLOADFILE_FILE_INFO(id = id, type = "", size = 0, extension = name.substring(name.lastIndexOf(".") + 1), statusText = if (status == 2) {
                    "上传成功"
                } else {
                    "待上传"
                }
                , status = el?.status ?: 2, path = name, progress = if (status == 2) {
                    100
                } else {
                    0
                }
                , response = if (el.response == null) {
                    ""
                } else {
                    el.response!! as String
                }
                , name = name.substring(name.lastIndexOf("/") + 1)))
                ++i
            }
        }
        )
        if (tempList.length > 0) {
            this.fileList = JSON.parseArray<XUPLOADFILE_FILE_INFO>(JSON.stringify(oldList.concat(tempList))!!)!!
            this.myChangeSync(this.fileList)
        }
    }
    open fun _addFilesByself(files: UTSArray<XUPLOADFILE_FILE_INFO>) {
        this.fileList = files.slice(0)
    }
    private fun getWaitUploadFilesNumber(): Number {
        var num: Number = 0
        this.fileList.forEach(fun(item: XUPLOADFILE_FILE_INFO){
            if (item.status == 0 || item.status == 3 || item.status == 4) {
                num += 1
            }
        }
        )
        return num
    }
    open fun start() {
        if (this.uploading) {
            return
        }
        this.uploading = true
        this.currentIndex = 0
        this.uploadFile()
    }
    private fun uploadFile() {
        if (this.currentIndex >= this.fileList.length) {
            this.uploadObj = null
            this.uploading = false
            this.complete(this.fileList)
            this.myChangeSync(this.fileList)
            var complete = this.events.get("complete")
            if (complete != null) {
                complete(this.fileList.slice(0))
            }
            return
        }
        this.beforeUpload(this.fileList[this.currentIndex]).then(fun(beforeUploadFileRes: XUPLOADFILE_FILE_INFO){
            this.fileList[this.currentIndex] = beforeUploadFileRes
            var nowitemStatus = this.fileList[this.currentIndex].status
            if (nowitemStatus == 1 || nowitemStatus == 2 || nowitemStatus == 5) {
                this.uploadObj = null
                this.uploading = false
                this.currentIndex += 1
                this.uploadFile()
                return
            }
            this.fileList[this.currentIndex].status = 1
            this.fileList[this.currentIndex].statusText = "上传中"
            this.myChangeSync(this.fileList)
            this.uploadObj = uni_uploadFile(UploadFileOptions(url = this.config.hostUrl, filePath = this.fileList[this.currentIndex].path, name = this.config.name, formData = this.config.formData, header = this.config.header, success = fun(uploadFileRes){
                if (uploadFileRes.statusCode != 200) {
                    this.fileList[this.currentIndex].status = 3
                    this.fileList[this.currentIndex].statusText = "上传失败"
                    this.currentIndex += 1
                    this.uploadFile()
                    this.myChangeSync(this.fileList)
                    return
                }
                this.fileList[this.currentIndex].status = 2
                this.fileList[this.currentIndex].response = uploadFileRes.data
                this.fileList[this.currentIndex].statusText = "上传成功"
                var itemtemp = this.fileList.slice(0)[this.currentIndex]
                var calllItem = this.beforeComplete(itemtemp)
                this.fileList[this.currentIndex] = calllItem
                this.currentIndex += 1
                this.uploadFile()
                this.myChangeSync(this.fileList)
            }
            , fail = fun(err){
                console.error("上传失败了,请检查配置:", err)
                this.fileList[this.currentIndex].status = 3
                this.fileList[this.currentIndex].statusText = "上传失败"
                this.currentIndex += 1
                this.uploadFile()
            }
            , complete = fun(_){
                this.myChangeSync(this.fileList)
            }
            ))
            this.uploadObj?.onProgressUpdate(fun(res){
                this.fileList[this.currentIndex].progress = res.progress
                this.myChangeSync(this.fileList)
            }
            )
        }
        )
    }
}
val tmxui = definePlugin(VuePlugin(install = fun(app: VueApp, config: Tmui4xOptions?) {
    setConfig(config)
    app.config.globalProperties["\$i18n"] = true
    var darkModel = getDarkMode()
    if (isCustomTheme()) {
        xConfig.dark = darkModel
    } else {
        if (xConfig.dark == "auto") {
            uni_setStorageSync("tmuiXuiOsThemeSet", darkModel)
            xConfig.dark = darkModel
        } else {
            uni_setStorageSync("tmuiXuiOsThemeSet", xConfig.dark)
        }
    }
    WebObserveTheme()
    setThemeDarkModel()
}
))
open class PerformaceData (
    @JsonNotNull
    open var type: String,
    @JsonNotNull
    open var timestamp: Long = 0,
    open var threadName: String? = null,
    open var exception: String? = null,
    open var stackTrace: String? = null,
    open var errorType: String? = null,
    open var message: String? = null,
    open var isFatal: Boolean? = null,
    open var costTime: Long? = null,
) : UTSObject()
var metainfo__1: String = ""
open class performance {
    public open fun start() {
        console.log("开启性能监控")
        startCrashMonitoring(fun(res: CrashData) {
            console.log("监控到崩溃", res)
            this.crash(res)
        }
        )
        startBlockMonitoring(fun(res: BlockData) {
            console.log("监控到卡顿", res)
            this.block(res)
        }
        )
        startANRMonitoring(fun(res: ANRData) {
            console.log("监控ANR", res)
            this.anr(res)
        }
        )
        startRuntimeErrorMonitoring(fun(res: RuntimeErrorData) {
            console.log("监控运行错误", res)
            this.runtime(res)
        }
        )
    }
    private fun crash(res: CrashData) {
        var data = PerformaceData(type = "crash", timestamp = res.timestamp, threadName = res.threadName, exception = res.exception, stackTrace = res.stackTrace)
        this.upload(data)
    }
    private fun block(res: BlockData) {
        var data = PerformaceData(type = "block", timestamp = res.timestamp, costTime = res.costTime, message = res.message, stackTrace = res.stackTrace)
        this.upload(data)
    }
    private fun anr(res: ANRData) {
        var data = PerformaceData(type = "anr", timestamp = res.timestamp, stackTrace = res.stackTrace)
        this.upload(data)
    }
    private fun runtime(res: RuntimeErrorData) {
        var data = PerformaceData(type = "runerror", timestamp = res.timestamp, errorType = res.errorType, message = res.message, stackTrace = res.stackTrace, isFatal = res.isFatal, threadName = res.threadName)
        this.upload(data)
    }
    private fun upload(data: PerformaceData): UTSPromise<Unit> {
        return wrapUTSPromise(suspend w@{
                console.log("上传性能监控数据", data)
                var tongjiToken = await(pageInterceptor.getToken())
                if (tongjiToken == null) {
                    console.error("统计Token为空")
                    return@w
                }
                if (metainfo__1 == "") {
                    metainfo__1 = common.getMetaInfo()
                }
                var appid = AppConfig.APIAppid
                val now = Date.now() + ""
                var requestData: UTSJSONObject = _uO("action" to "app.static.performance", "data" to _uA(
                    data
                ), "metainfo" to metainfo__1, "version" to AppConfig.app_version(), "appid" to appid, "time" to now, "module" to AppConfig.module, "platform" to AppConfig.wxatag, "sign" to md5(metainfo__1 + appid + now))
                var that = this
                uni_request<Any>(RequestOptions(url = AppConfig.tongjiHost, data = requestData, method = "POST", header = _uO("token" to tongjiToken), timeout = 3000, firstIpv4 = true, success = fun(res){
                    console.log("上报性能监控数据结果", res)
                    if (res.statusCode != 200) {
                        return
                    }
                    var rdata = res.data as UTSJSONObject
                    if ((rdata["code"] as Number) == -401.1) {
                        pageInterceptor.getToken(true).then(fun(t: String?) {
                            if (t != null) {
                                that.upload(data)
                            }
                        }
                        )
                    }
                }
                , fail = fun(err){
                    console.log("请求失败", err)
                    return
                }
                ))
        })
    }
}
open class sqlite {
    constructor(){
        init__1("pdaapp", 1, "")
    }
    open fun exec(sql: String) {
        executeSql(sql)
    }
    open fun query(sql: String): UTSArray<UTSJSONObject> {
        var queryList = queryData(sql)
        return queryList
    }
    open fun exportDatabase(): Boolean {
        return exportDatabase("pdaapp")
    }
}
open class userObject {
    companion object {
        fun loginAfter(): UTSPromise<Unit> {
            return wrapUTSPromise(suspend {
                    state.socket = WebSocket.startWebsocket()
                    setInterval(fun(){
                        userObject.checkLogin()
                    }
                    , 3600000)
                    if (state.payCodeObj == null) {
                        state.payCodeObj = PayCode()
                    }
            })
        }
        fun logoutAfter(): UTSPromise<Unit> {
            return wrapUTSPromise(suspend {
                    WebSocket.stopWebsocket()
                    clearInterval(PayCode.payIndex)
            })
        }
        fun checkLogin(): UTSPromise<Unit> {
            return wrapUTSPromise(suspend w@{
                    var user = await(request.getUserInfo(false))
                    console.log(user)
                    if (user == false) {
                        uni_redirectTo(RedirectToOptions(url = "/pages/index/login"))
                        userObject.logoutAfter()
                        return@w
                    }
                    userObject.loginAfter()
                    uni_switchTab(SwitchTabOptions(url = "/pages/index/index"))
            })
        }
    }
}
val GenPagesSplashClass = CreateVueComponent(GenPagesSplash::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesSplash.inheritAttrs, inject = GenPagesSplash.inject, props = GenPagesSplash.props, propsNeedCastKeys = GenPagesSplash.propsNeedCastKeys, emits = GenPagesSplash.emits, components = GenPagesSplash.components, styles = GenPagesSplash.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesSplash.setup(props as GenPagesSplash)
    }
    )
}
, fun(instance, renderer): GenPagesSplash {
    return GenPagesSplash(instance, renderer)
}
)
val default__5: UTSJSONObject = _uO("kefu" to "\ue682", "daishenhe" to "\ue683", "gongdanguanli" to "\ue684", "yidu" to "\ue675", "tongxunlu" to "\ue676", "icon156" to "\ue677", "shouye1" to "\ue679", "biaoqing" to "\ue67a", "wenjianjia" to "\ue67b", "xiangce" to "\ue67c", "zhaoxiangji1" to "\ue67e", "jian" to "\ue674", "methoddrawimage" to "\ue671", "xiaoshoudan" to "\ue66e", "jinhuodan1" to "\ue66a", "diaobodan" to "\ue666", "chacha1" to "\ue6d8", "checkbox" to "\ue662", "checkboxoutlineblank" to "\ue664", "jiantou_xiangzuo" to "\ueb09", "gundongtiao" to "\ue665", "gundongtiao2" to "\ueb0a", "close" to "\ue6d6", "tupianjiazaishibai" to "\uec0d", "xiangxiafanbai" to "\ue66f", "xiangxiafanbaicopy" to "\ue667", "gougou" to "\ue668", "zhaoxiangji" to "\ue669", "dingwei1" to "\ue93f", "sousuo2" to "\ue66c", "xiangzuo1" to "\ue779", "daohang" to "\ue66d", "xiangyou3" to "\ue65d", "dingwei" to "\ue6c5", "caidan" to "\ue65c", "jixu1" to "\ue653", "fasongyoujian" to "\ue654", "dadianhua" to "\ue655", "caozuo1" to "\ue65a", "sousuo1" to "\ue651", "xinzengrenwu" to "\ue650", "jixu" to "\ue652", "caozuo" to "\ue64f", "dayin" to "\ue64d", "queren" to "\ue64e", "fuzhi1" to "\ue648", "mingxi" to "\ue649", "bianji2" to "\ue64a", "qianzi" to "\ue64b", "gengduo1" to "\ue64c", "chexiao" to "\ue646", "shanchu1" to "\ue645", "jiaobiao" to "\ue6a8", "shanchu" to "\ue642", "jianhao" to "\ue644", "shengxu" to "\ue641", "gouwuche" to "\ue63f", "jiangxu" to "\ue640", "wushuju" to "\ue63e", "gou" to "\ue643", "qiye" to "\ue63d", "jinhuo" to "\ue635", "bianji1" to "\ue636", "wenhao" to "\ue637", "bianjibiaoge" to "\ue638", "chachajiaobiao" to "\ue639", "saoyisao1" to "\ue62d", "zhineng" to "\ue62e", "wenjian" to "\ue630", "zanwushuju" to "\ue631", "jia" to "\ue632", "triangle" to "\ue634", "haibao" to "\ue628", "xiazai" to "\ue661", "bianji" to "\ue6ce", "xiangyou1" to "\ue775", "helpo" to "\ue743", "weixin" to "\ue624", "icon_on_the_down" to "\ue625", "xiangzuo" to "\ue65e", "qiehuan" to "\ue626", "xuanzhong" to "\ue627", "atongjishujuquxianzhishu" to "\ue63c", "chazhaoyonghu" to "\ue620", "jiahao" to "\ue621", "gengduo" to "\ue622", "guanbi" to "\ue623", "androidgengduo" to "\ue78d", "shoukuanguanli" to "\ue618", "shoukuanjilu" to "\ue619", "a003cashier" to "\ue66b", "tuige" to "\ue61f", "fanhui" to "\ue647", "more" to "\ue611", "yuangong" to "\ue612", "shezhi" to "\ue613", "printer" to "\ue9c3", "wuliushezhi" to "\ue688", "quanxian" to "\ue659", "gerenxinxi" to "\ue678", "xingxing2" to "\ue685", "robot" to "\ue7a2", "erweima" to "\ue617", "fuzhi" to "\ue660", "xiangxia1" to "\ue771", "shaixuan" to "\ue6b7", "saoyisao" to "\ue8b5", "chacha" to "\ue62f", "fapiaoguanli" to "\ue610", "danjusaomiao" to "\ue727", "danjuyanzhengchaxun" to "\ue94d", "fapiaoyanzhen" to "\ue658", "gongyingshang" to "\ue65b", "zijinliushui" to "\ue61c", "linqishangpin" to "\ue6eb", "taocan" to "\ue681", "huiyuanchaxun" to "\ue663", "wodexitongzhanghu" to "\ue60d", "fukuandanguanli" to "\ue70d", "zhifumingxi" to "\ue61e", "qianxiang" to "\ue616", "tuikuantuihuo" to "\ue60a", "zidonghexiao" to "\ue747", "mm_dep_cangkukucuntiaopei" to "\ue60c", "yaohuodan" to "\ue609", "yiwuyimaicon" to "\ue615", "chaisan" to "\ue60f", "shangpinchaxun" to "\ue697", "icon" to "\ue62b", "icon2" to "\ue62c", "yunshu" to "\ue61b", "jinhuodan" to "\ue608", "baolingqiu" to "\ue68f", "jianshen" to "\ue88d", "jiaqian" to "\ue6c3", "biaoqian" to "\ue607", "kucun" to "\ue63b", "shangjia" to "\ue6d5", "ahexiao3x" to "\ue614", "zizhimoban" to "\ue672", "tongjiliebiao" to "\ue689", "chukudan" to "\ue670", "huaizhanghexiaodan" to "\ue7c1", "shangpinliebiao" to "\ue629", "yiwuyima" to "\ue62a", "sanzhuang" to "\ue656", "rukudan" to "\ue60e", "chuku" to "\ue67d", "ruku" to "\ue680", "hexiao" to "\ue73b", "huojialiebiao" to "\ue65f", "return_loaded" to "\ue657", "chukudengji" to "\ue61d", "kucunpandian" to "\ue673", "shouyinguanli" to "\ue603", "atongjifenxitongjibaobiaoyanpan" to "\ue604", "yingshoukuan" to "\ue605", "QR" to "\ue606", "sousuo" to "\ue600", "tianjia" to "\ue602", "xiangshang" to "\ue9c4", "xiangxia" to "\ue63a", "tongji" to "\ue67f", "wode" to "\ue60b", "dingdan" to "\ue601", "gongju" to "\ue633", "shouye" to "\ue61a", "dianpufill" to "\ue735")
val GenComponentsXIconfontClass = CreateVueComponent(GenComponentsXIconfont::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXIconfont.inheritAttrs, inject = GenComponentsXIconfont.inject, props = GenComponentsXIconfont.props, propsNeedCastKeys = GenComponentsXIconfont.propsNeedCastKeys, emits = GenComponentsXIconfont.emits, components = GenComponentsXIconfont.components, styles = GenComponentsXIconfont.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXIconfont.setup(props as GenComponentsXIconfont)
    }
    )
}
, fun(instance, renderer): GenComponentsXIconfont {
    return GenComponentsXIconfont(instance)
}
)
interface PopoverPropsMenu {
    var closeOnClickOutside: Boolean
    var content: String?
    var placement: String
    var showArrow: Boolean
    var theme: String
    var visible: Boolean?
    var color: String?
    var disabled: Boolean
    var menus: UTSArray<UTSJSONObject>
}
open class PlacementAndWidthMenu (
    @JsonNotNull
    open var placement: String,
    @JsonNotNull
    open var finalWidth: Number,
) : UTSObject()
fun raf(fn: UniAnimationFrameCallback): Number {
    return raf(fn as Any)
}
fun raf(fn: UniAnimationFrameCallbackWithNoArgument): Number {
    return raf(fn as Any)
}
fun raf(fn: Any): Number {
    if (UTSAndroid.`typeof`(fn) == "UniAnimationFrameCallback") {
        return requestAnimationFrame(fn as UniAnimationFrameCallback)
    } else {
        return requestAnimationFrame(fn as UniAnimationFrameCallbackWithNoArgument)
    }
}
fun doubleRaf(fn: UniAnimationFrameCallback): Unit {
    return doubleRaf(fn as Any)
}
fun doubleRaf(fn: UniAnimationFrameCallbackWithNoArgument): Unit {
    return doubleRaf(fn as Any)
}
fun doubleRaf(fn: Any): Unit {
    raf(fun(): Number {
        return raf(fn)
    }
    )
}
var popoverQueue: UTSArray<ComponentPublicInstance> = _uA()
fun pushToQueue(comp: ComponentPublicInstance) {
    popoverQueue.push(comp)
}
fun removeFromQueue(comp: ComponentPublicInstance) {
    val index = popoverQueue.findIndex(fun(item): Boolean {
        return item == comp
    }
    )
    if (index == -1) {
        return
    }
    popoverQueue.splice(index, 1)
}
fun closeOther(comp: ComponentPublicInstance) {
    popoverQueue.forEach(fun(item){
        if (item.`$`.uid != comp.`$`.uid) {
            item.`$callMethod`("close")
        }
    }
    )
}
val transformMap = Map<String, String>(_uA())
val appTransformMap = Map<String, String>(_uA(
    _uA(
        "left",
        "translateY(-50%)"
    ),
    _uA(
        "right",
        "translateY(-50%)"
    ),
    _uA(
        "right-bottom",
        "translateY(-100%)"
    ),
    _uA(
        "left-bottom",
        "translateY(-100%)"
    )
))
val transformOriginMap = Map<String, String>(_uA(
    _uA(
        "top",
        "50% 100%"
    ),
    _uA(
        "top-left",
        "0 100%"
    ),
    _uA(
        "top-right",
        "100% 100%"
    ),
    _uA(
        "bottom",
        "50% 0%"
    ),
    _uA(
        "bottom-left",
        "0% 0%"
    ),
    _uA(
        "bottom-right",
        "100% 0"
    ),
    _uA(
        "left-bottom",
        "100% 100%"
    ),
    _uA(
        "right-bottom",
        "0 100%"
    ),
    _uA(
        "left",
        "100% 50%"
    ),
    _uA(
        "left-top",
        "100% 0"
    ),
    _uA(
        "right",
        "0 50%"
    ),
    _uA(
        "right-top",
        "0 0"
    )
))
fun findPageElement(startEl: UniElement?): UniElement? {
    var currentEl: UniElement? = startEl
    while(currentEl != null && currentEl.parentElement != null){
        currentEl = currentEl.parentElement
    }
    return currentEl
}
fun calculateWidthAndAdjustPlacement(placement: String, availableLeft: Number, availableRight: Number, popoverWidth: Number): PlacementAndWidthMenu {
    var finalPlacement: String = placement
    var finalWidth: Number = popoverWidth
    if (_uA(
        "left",
        "right"
    ).some(fun(dir): Boolean {
        return placement.startsWith(dir)
    }
    )) {
        val isLeft = placement.startsWith("left")
        val availableSpace = if (isLeft) {
            availableLeft
        } else {
            availableRight
        }
        val oppositeSpace = if (isLeft) {
            availableRight
        } else {
            availableLeft
        }
        if (availableSpace >= popoverWidth) {
            finalWidth = popoverWidth
        } else if (oppositeSpace >= popoverWidth) {
            finalWidth = popoverWidth
            finalPlacement = placement.replace(if (isLeft) {
                "left"
            } else {
                "right"
            }, if (isLeft) {
                "right"
            } else {
                "left"
            })
        } else if (availableSpace < 64 && finalWidth > 64) {
            finalPlacement = "bottom"
            finalWidth = popoverWidth
        } else {
            finalWidth = availableSpace
        }
    }
    return PlacementAndWidthMenu(placement = finalPlacement, finalWidth = finalWidth)
}
val GenComponentsXpPopoverMenuXpPopoverMenuClass = CreateVueComponent(GenComponentsXpPopoverMenuXpPopoverMenu::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXpPopoverMenuXpPopoverMenu.inheritAttrs, inject = GenComponentsXpPopoverMenuXpPopoverMenu.inject, props = GenComponentsXpPopoverMenuXpPopoverMenu.props, propsNeedCastKeys = GenComponentsXpPopoverMenuXpPopoverMenu.propsNeedCastKeys, emits = GenComponentsXpPopoverMenuXpPopoverMenu.emits, components = GenComponentsXpPopoverMenuXpPopoverMenu.components, styles = GenComponentsXpPopoverMenuXpPopoverMenu.styles, setup = fun(props: ComponentPublicInstance, ctx: SetupContext): Any? {
        return GenComponentsXpPopoverMenuXpPopoverMenu.setup(props as GenComponentsXpPopoverMenuXpPopoverMenu, ctx)
    }
    )
}
, fun(instance, renderer): GenComponentsXpPopoverMenuXpPopoverMenu {
    return GenComponentsXpPopoverMenuXpPopoverMenu(instance)
}
)
val GenComponentsXActionClass = CreateVueComponent(GenComponentsXAction::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXAction.inheritAttrs, inject = GenComponentsXAction.inject, props = GenComponentsXAction.props, propsNeedCastKeys = GenComponentsXAction.propsNeedCastKeys, emits = GenComponentsXAction.emits, components = GenComponentsXAction.components, styles = GenComponentsXAction.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXAction.setup(props as GenComponentsXAction)
    }
    )
}
, fun(instance, renderer): GenComponentsXAction {
    return GenComponentsXAction(instance)
}
)
open class ITEMINFO (
    @JsonNotNull
    open var text: String,
    @JsonNotNull
    open var color: String,
    @JsonNotNull
    open var isHeightLight: Boolean = false,
) : UTSObject()
val GenUniModulesTmxUiComponentsTmxTextTmxTextClass = CreateVueComponent(GenUniModulesTmxUiComponentsTmxTextTmxText::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesTmxUiComponentsTmxTextTmxText.name, inheritAttrs = GenUniModulesTmxUiComponentsTmxTextTmxText.inheritAttrs, inject = GenUniModulesTmxUiComponentsTmxTextTmxText.inject, props = GenUniModulesTmxUiComponentsTmxTextTmxText.props, propsNeedCastKeys = GenUniModulesTmxUiComponentsTmxTextTmxText.propsNeedCastKeys, emits = GenUniModulesTmxUiComponentsTmxTextTmxText.emits, components = GenUniModulesTmxUiComponentsTmxTextTmxText.components, styles = GenUniModulesTmxUiComponentsTmxTextTmxText.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesTmxUiComponentsTmxTextTmxText.setup(props as GenUniModulesTmxUiComponentsTmxTextTmxText)
    }
    )
}
, fun(instance, renderer): GenUniModulesTmxUiComponentsTmxTextTmxText {
    return GenUniModulesTmxUiComponentsTmxTextTmxText(instance)
}
)
var fonts: UTSJSONObject = _uO()
val runBlock2 = run {
    fonts = __gen_lazy_obj_0_11
}
val GenUniModulesTmxUiComponentsTmxIconTmxIconClass = CreateVueComponent(GenUniModulesTmxUiComponentsTmxIconTmxIcon::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesTmxUiComponentsTmxIconTmxIcon.name, inheritAttrs = GenUniModulesTmxUiComponentsTmxIconTmxIcon.inheritAttrs, inject = GenUniModulesTmxUiComponentsTmxIconTmxIcon.inject, props = GenUniModulesTmxUiComponentsTmxIconTmxIcon.props, propsNeedCastKeys = GenUniModulesTmxUiComponentsTmxIconTmxIcon.propsNeedCastKeys, emits = GenUniModulesTmxUiComponentsTmxIconTmxIcon.emits, components = GenUniModulesTmxUiComponentsTmxIconTmxIcon.components, styles = GenUniModulesTmxUiComponentsTmxIconTmxIcon.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesTmxUiComponentsTmxIconTmxIcon.setup(props as GenUniModulesTmxUiComponentsTmxIconTmxIcon)
    }
    )
}
, fun(instance, renderer): GenUniModulesTmxUiComponentsTmxIconTmxIcon {
    return GenUniModulesTmxUiComponentsTmxIconTmxIcon(instance)
}
)
open class FORMITEM_R (
    @JsonNotNull
    open var key: String,
    open var value: Any? = null,
) : UTSObject()
open class FORM_ITEM (
    @JsonNotNull
    open var id: String,
    @JsonNotNull
    open var ele: TmxFormItemComponentPublicInstance,
    @JsonNotNull
    open var top: Number,
    @JsonNotNull
    open var name: String,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return FORM_ITEMReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class FORM_ITEMReactiveObject : FORM_ITEM, IUTSReactive<FORM_ITEM> {
    override var __v_raw: FORM_ITEM
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: FORM_ITEM, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(id = __v_raw.id, ele = __v_raw.ele, top = __v_raw.top, name = __v_raw.name) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): FORM_ITEMReactiveObject {
        return FORM_ITEMReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var id: String
        get() {
            return _tRG(__v_raw, "id", __v_raw.id, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("id")) {
                return
            }
            val oldValue = __v_raw.id
            __v_raw.id = value
            _tRS(__v_raw, "id", oldValue, value)
        }
    override var ele: TmxFormItemComponentPublicInstance
        get() {
            return _tRG(__v_raw, "ele", __v_raw.ele, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("ele")) {
                return
            }
            val oldValue = __v_raw.ele
            __v_raw.ele = value
            _tRS(__v_raw, "ele", oldValue, value)
        }
    override var top: Number
        get() {
            return _tRG(__v_raw, "top", __v_raw.top, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("top")) {
                return
            }
            val oldValue = __v_raw.top
            __v_raw.top = value
            _tRS(__v_raw, "top", oldValue, value)
        }
    override var name: String
        get() {
            return _tRG(__v_raw, "name", __v_raw.name, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("name")) {
                return
            }
            val oldValue = __v_raw.name
            __v_raw.name = value
            _tRS(__v_raw, "name", oldValue, value)
        }
}
fun getDefaultRule(rule: FORM_RULE): FORM_RULE_SELF {
    var type: FORM_RULE_TYPE = rule?.type ?: ""
    var errorMessage: String = rule?.errorMessage ?: "请正确填写/选择"
    var max: Number = rule?.max ?: -1
    var min: Number = rule?.min ?: 1
    var selfvaild: FORM_VAILD_FUN? = rule.valid
    var validfaun: FORM_VAILD_FUN? = selfvaild
    var trigger: String = rule?.trigger ?: "change"
    return FORM_RULE_SELF(type = type, errorMessage = errorMessage, max = max, min = min, valid = validfaun, trigger = trigger)
}
fun vaild(kVal: Any?, rule: FORM_RULE_SELF): Boolean {
    if (rule.type != "") {
        return vaildBytType(kVal, rule)
    }
    if (kVal == null) {
        return false
    }
    if (UTSAndroid.`typeof`(kVal) === "string") {
        var vallen = (kVal as String).trim().split("").length
        if (rule.max == -1) {
            return vallen >= rule.min
        }
        return vallen >= rule.min && vallen <= rule.max
    }
    if (UTSArray.isArray(kVal)) {
        var vallen = (kVal as UTSArray<Any>).length
        if (rule.max == -1) {
            return vallen >= rule.min
        }
        return vallen >= rule.min && vallen <= rule.max
    }
    if (UTSAndroid.`typeof`(kVal) === "boolean") {
        return kVal as Boolean
    }
    if (UTSAndroid.`typeof`(kVal) === "number") {
        if (isNaN(kVal as Number)) {
            return false
        }
        var vallen = kVal as Number
        if (rule.max == -1) {
            return vallen >= rule.min
        }
        return vallen >= rule.min && vallen <= rule.max
    }
    if (UTSAndroid.`typeof`(kVal) == "Int") {
        var vallen = kVal as Int
        if (rule.max == -1) {
            return vallen >= rule.min.toInt()
        }
        return vallen >= rule.min.toInt() && vallen <= rule.max.toInt()
    }
    if (UTSAndroid.`typeof`(kVal) == "Float") {
        var vallen = kVal as Float
        if (rule.max == -1) {
            return vallen >= rule.min.toFloat()
        }
        return vallen >= rule.min.toFloat() && vallen <= rule.max.toFloat()
    }
    if (UTSAndroid.`typeof`(kVal) == "Double") {
        var vallen = kVal as Double
        if (rule.max == -1) {
            return vallen >= rule.min.toDouble()
        }
        return vallen >= rule.min.toDouble() && vallen <= rule.max.toDouble()
    }
    if (UTSAndroid.`typeof`(kVal) == "Long") {
        var vallen = kVal as Long
        if (rule.max == -1) {
            return vallen >= rule.min.toLong()
        }
        return vallen >= rule.min.toLong() && vallen <= rule.max.toLong()
    }
    return false
}
fun formVaild(kVal: Any?, rule: FORM_RULE): Boolean {
    var rulereal = getDefaultRule(rule)
    var selfVaildFun = rulereal?.valid ?: null
    var isPass = true
    isPass = if (selfVaildFun == null) {
        vaild(kVal, rulereal)
    } else {
        selfVaildFun(kVal)
    }
    return isPass
}
typealias flatFunCall = (obj: UTSJSONObject, prefix: String) -> UTSJSONObject
val GenUniModulesTmxUiComponentsTmxFormTmxFormClass = CreateVueComponent(GenUniModulesTmxUiComponentsTmxFormTmxForm::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesTmxUiComponentsTmxFormTmxForm.name, inheritAttrs = GenUniModulesTmxUiComponentsTmxFormTmxForm.inheritAttrs, inject = GenUniModulesTmxUiComponentsTmxFormTmxForm.inject, props = GenUniModulesTmxUiComponentsTmxFormTmxForm.props, propsNeedCastKeys = GenUniModulesTmxUiComponentsTmxFormTmxForm.propsNeedCastKeys, emits = GenUniModulesTmxUiComponentsTmxFormTmxForm.emits, components = GenUniModulesTmxUiComponentsTmxFormTmxForm.components, styles = GenUniModulesTmxUiComponentsTmxFormTmxForm.styles, setup = fun(props: ComponentPublicInstance, ctx: SetupContext): Any? {
        return GenUniModulesTmxUiComponentsTmxFormTmxForm.setup(props as GenUniModulesTmxUiComponentsTmxFormTmxForm, ctx)
    }
    )
}
, fun(instance, renderer): GenUniModulesTmxUiComponentsTmxFormTmxForm {
    return GenUniModulesTmxUiComponentsTmxFormTmxForm(instance)
}
)
typealias TmxFormComponentPublicInstance = GenUniModulesTmxUiComponentsTmxFormTmxForm
typealias FORM_VAILD_FUN = (`val`: Any?) -> Boolean
open class FORM_RULE_SELF (
    @JsonNotNull
    open var type: FORM_RULE_TYPE,
    open var valid: FORM_VAILD_FUN? = null,
    @JsonNotNull
    open var errorMessage: String,
    @JsonNotNull
    open var max: Number,
    @JsonNotNull
    open var min: Number,
    @JsonNotNull
    open var trigger: String,
) : UTSObject()
val GenUniModulesTmxUiComponentsTmxFormItemTmxFormItemClass = CreateVueComponent(GenUniModulesTmxUiComponentsTmxFormItemTmxFormItem::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesTmxUiComponentsTmxFormItemTmxFormItem.name, inheritAttrs = GenUniModulesTmxUiComponentsTmxFormItemTmxFormItem.inheritAttrs, inject = GenUniModulesTmxUiComponentsTmxFormItemTmxFormItem.inject, props = GenUniModulesTmxUiComponentsTmxFormItemTmxFormItem.props, propsNeedCastKeys = GenUniModulesTmxUiComponentsTmxFormItemTmxFormItem.propsNeedCastKeys, emits = GenUniModulesTmxUiComponentsTmxFormItemTmxFormItem.emits, components = GenUniModulesTmxUiComponentsTmxFormItemTmxFormItem.components, styles = GenUniModulesTmxUiComponentsTmxFormItemTmxFormItem.styles)
}
, fun(instance, renderer): GenUniModulesTmxUiComponentsTmxFormItemTmxFormItem {
    return GenUniModulesTmxUiComponentsTmxFormItemTmxFormItem(instance)
}
)
typealias TmxFormItemComponentPublicInstance = GenUniModulesTmxUiComponentsTmxFormItemTmxFormItem
fun vaildBytType(kVal: Any?, rule: FORM_RULE_SELF): Boolean {
    if (kVal == null) {
        return false
    }
    if (rule.type == "string") {
        var vallen = (kVal as String).trim().split("").length
        if (rule.max == -1) {
            return vallen >= rule.min
        }
        return vallen >= rule.min && vallen <= rule.max
    }
    if (rule.type == "array") {
        var vallen = (kVal as UTSArray<Any>).length
        if (rule.max == -1) {
            return vallen >= rule.min
        }
        return vallen >= rule.min && vallen <= rule.max
    }
    if (rule.type == "boolean") {
        return kVal as Boolean
    }
    if (rule.type == "number") {
        var v: Number = 0
        if (UTSAndroid.`typeof`(kVal) != "number" && UTSAndroid.`typeof`(kVal) != "string") {
            return false
        }
        if (UTSAndroid.`typeof`(kVal) == "Int") {
            var vallen = kVal as Int
            v = vallen + 0
        }
        if (UTSAndroid.`typeof`(kVal) == "Float") {
            var vallen = kVal as Float
            v = vallen + 0
        }
        if (UTSAndroid.`typeof`(kVal) == "Double") {
            var vallen = kVal as Double
            v = vallen + 0
        }
        if (UTSAndroid.`typeof`(kVal) == "Long") {
            var vallen = kVal as Long
            v = vallen + 0
        }
        if (UTSAndroid.`typeof`(kVal) == "number") {
            v = kVal as Number
        } else if (UTSAndroid.`typeof`(kVal) == "string") {
            var pv = kVal as String
            var vazhi = parseFloat(pv)
            if (isNaN(vazhi)) {
                return false
            }
            v = vazhi
        }
        var vallen = v
        if (rule.max == -1) {
            return vallen >= rule.min
        }
        return vallen >= rule.min && vallen <= rule.max
    }
    if (rule.type == "phone") {
        var vallen = ""
        if (UTSAndroid.`typeof`(kVal) == "string") {
            vallen = kVal as String
        } else if (UTSAndroid.`typeof`(kVal) == "number") {
            vallen = (kVal as Number).toString(10)
        }
        var reg = UTSRegExp("^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}\$", "")
        return reg.test(vallen)
    }
    if (rule.type == "email") {
        var vallen = kVal as String
        var reg = UTSRegExp("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\$", "")
        return reg.test(vallen)
    }
    if (rule.type == "UTSJSON") {
        var vallen = kVal as UTSJSONObject
        var mapkeys = vallen.toMap()
        var len = mapkeys.size
        if (rule.max == -1) {
            return len >= rule.min
        }
        return len >= rule.min && len <= rule.max
    }
    if (rule.type == "date" && (UTSAndroid.`typeof`(kVal) == "string")) {
        var vallen = kVal as String
        var date = Date(vallen)
        var times = date.getTime()
        if (isNaN(times)) {
            return false
        }
        var len = times
        if (rule.max == -1) {
            return len >= rule.min
        }
        return len >= rule.min && len <= rule.max
    }
    return false
}
typealias SkinType = String
typealias SizeType = String
open class _ColorResult (
    @JsonNotNull
    open var border: String,
    @JsonNotNull
    open var background: String,
    @JsonNotNull
    open var backgroundImage: String,
    @JsonNotNull
    open var fontColor: String,
) : UTSObject()
val GenUniModulesTmxUiComponentsTmxButtonTmxButtonClass = CreateVueComponent(GenUniModulesTmxUiComponentsTmxButtonTmxButton::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesTmxUiComponentsTmxButtonTmxButton.name, inheritAttrs = GenUniModulesTmxUiComponentsTmxButtonTmxButton.inheritAttrs, inject = GenUniModulesTmxUiComponentsTmxButtonTmxButton.inject, props = GenUniModulesTmxUiComponentsTmxButtonTmxButton.props, propsNeedCastKeys = GenUniModulesTmxUiComponentsTmxButtonTmxButton.propsNeedCastKeys, emits = GenUniModulesTmxUiComponentsTmxButtonTmxButton.emits, components = GenUniModulesTmxUiComponentsTmxButtonTmxButton.components, styles = GenUniModulesTmxUiComponentsTmxButtonTmxButton.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesTmxUiComponentsTmxButtonTmxButton.setup(props as GenUniModulesTmxUiComponentsTmxButtonTmxButton)
    }
    )
}
, fun(instance, renderer): GenUniModulesTmxUiComponentsTmxButtonTmxButton {
    return GenUniModulesTmxUiComponentsTmxButtonTmxButton(instance)
}
)
val GenUniModulesTmxUiComponentsTmxModalTmxModalClass = CreateVueComponent(GenUniModulesTmxUiComponentsTmxModalTmxModal::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesTmxUiComponentsTmxModalTmxModal.name, inheritAttrs = GenUniModulesTmxUiComponentsTmxModalTmxModal.inheritAttrs, inject = GenUniModulesTmxUiComponentsTmxModalTmxModal.inject, props = GenUniModulesTmxUiComponentsTmxModalTmxModal.props, propsNeedCastKeys = GenUniModulesTmxUiComponentsTmxModalTmxModal.propsNeedCastKeys, emits = GenUniModulesTmxUiComponentsTmxModalTmxModal.emits, components = GenUniModulesTmxUiComponentsTmxModalTmxModal.components, styles = GenUniModulesTmxUiComponentsTmxModalTmxModal.styles, setup = fun(props: ComponentPublicInstance, ctx: SetupContext): Any? {
        return GenUniModulesTmxUiComponentsTmxModalTmxModal.setup(props as GenUniModulesTmxUiComponentsTmxModalTmxModal, ctx)
    }
    )
}
, fun(instance, renderer): GenUniModulesTmxUiComponentsTmxModalTmxModal {
    return GenUniModulesTmxUiComponentsTmxModalTmxModal(instance)
}
)
val GenComponentsXModelClass = CreateVueComponent(GenComponentsXModel::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXModel.inheritAttrs, inject = GenComponentsXModel.inject, props = GenComponentsXModel.props, propsNeedCastKeys = GenComponentsXModel.propsNeedCastKeys, emits = GenComponentsXModel.emits, components = GenComponentsXModel.components, styles = GenComponentsXModel.styles, setup = fun(props: ComponentPublicInstance, ctx: SetupContext): Any? {
        return GenComponentsXModel.setup(props as GenComponentsXModel, ctx)
    }
    )
}
, fun(instance, renderer): GenComponentsXModel {
    return GenComponentsXModel(instance)
}
)
val default__6: UTSJSONObject = _uO("actionsheet" to _uO("cancel" to "取消"), "dialog" to _uO("title" to "提示", "cancel" to "取消", "confirm" to "确定"), "swipeaction" to _uO("delete" to "删除"), "loading" to _uO("text" to "加载中"), "pagination" to _uO("prevText" to "上一页", "nextText" to "下一页"), "loadmore" to _uO("initText" to "上拉加载", "text" to "正在加载...", "noneText" to "没有更多了"))
val default__7: UTSJSONObject = _uO("actionsheet" to _uO("cancel" to "取消"), "dialog" to _uO("title" to "提示", "cancel" to "取消", "confirm" to "確定"), "swipeaction" to _uO("delete" to "刪除"), "loading" to _uO("text" to "載入中"), "pagination" to _uO("prevText" to "上一頁", "nextText" to "下一頁"), "loadmore" to _uO("initText" to "上拉加載", "text" to "正在加載...", "noneText" to "沒有更多了"))
val default__8: UTSJSONObject = _uO("actionsheet" to _uO("cancel" to "Cancel"), "dialog" to _uO("title" to "Message", "cancel" to "Cancel", "confirm" to "OK"), "swipeaction" to _uO("delete" to "Delete"), "loading" to _uO("text" to "Loading"), "pagination" to _uO("prevText" to "Prev page", "nextText" to "Next page"), "loadmore" to _uO("initText" to "Pull-up loading", "text" to "Loading", "noneText" to "No more"))
val default__9: UTSJSONObject = _uO("actionsheet" to _uO("cancel" to "ยกเลิก"), "dialog" to _uO("title" to "ข้อความ", "cancel" to "ยกเลิก", "confirm" to "ตกลง"), "swipeaction" to _uO("delete" to "ลบ"), "loading" to _uO("text" to "กำลังโหลด"), "pagination" to _uO("prevText" to "Prev page", "nextText" to "Next page"), "loadmore" to _uO("initText" to "Pull-up loading", "text" to "กำลังโหลด", "noneText" to "ไม่มีอีกแล้ว"))
val default__10: UTSJSONObject = _uO("actionsheet" to _uO("cancel" to "Отмена"), "dialog" to _uO("title" to "Сообщение", "cancel" to "Отмена", "confirm" to "OK"), "swipeaction" to _uO("delete" to "Удалить"), "loading" to _uO("text" to "Загрузка"), "pagination" to _uO("prevText" to "Prev page", "nextText" to "Next page"), "loadmore" to _uO("initText" to "Pull-up loading", "text" to "Загрузка", "noneText" to "больше не надо"))
val default__11: UTSJSONObject = _uO("actionsheet" to _uO("cancel" to "إلغاء"), "dialog" to _uO("title" to "العنوان", "cancel" to "إلغاء", "confirm" to "موافق"), "swipeaction" to _uO("delete" to "حذف"), "loading" to _uO("text" to "جار التحميل"), "pagination" to _uO("prevText" to "Prev page", "nextText" to "Next page"), "loadmore" to _uO("initText" to "Pull-up loading", "text" to "جار التحميل", "noneText" to "لا أكثر"))
open class FuiLocaleLangParam (
    @JsonNotNull
    open var locale: String,
    @JsonNotNull
    open var messages: UTSJSONObject,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return FuiLocaleLangParamReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class FuiLocaleLangParamReactiveObject : FuiLocaleLangParam, IUTSReactive<FuiLocaleLangParam> {
    override var __v_raw: FuiLocaleLangParam
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: FuiLocaleLangParam, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(locale = __v_raw.locale, messages = __v_raw.messages) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): FuiLocaleLangParamReactiveObject {
        return FuiLocaleLangParamReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var locale: String
        get() {
            return _tRG(__v_raw, "locale", __v_raw.locale, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("locale")) {
                return
            }
            val oldValue = __v_raw.locale
            __v_raw.locale = value
            _tRS(__v_raw, "locale", oldValue, value)
        }
    override var messages: UTSJSONObject
        get() {
            return _tRG(__v_raw, "messages", __v_raw.messages, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("messages")) {
                return
            }
            val oldValue = __v_raw.messages
            __v_raw.messages = value
            _tRS(__v_raw, "messages", oldValue, value)
        }
}
val fuiLang = reactive(FuiLocaleLangParam(locale = "", messages = _uO("cn" to default__6, "tc" to default__7, "en" to default__8, "th" to default__9, "ru" to default__10, "ar" to default__11)))
val getFuiLocaleLang = fun(locale: String?): UTSJSONObject {
    var initLangData: UTSJSONObject
    if (locale != null && locale != "") {
        initLangData = fuiLang.messages[locale] as UTSJSONObject
    } else {
        var key = uni_getStorageSync("fui_locale_lang")
        if (key == null || key == "") {
            key = if (fuiLang.locale == "") {
                "cn"
            } else {
                fuiLang.locale
            }
        }
        initLangData = fuiLang.messages[key] as UTSJSONObject
    }
    return initLangData
}
val GenUniModulesFirstuiUvueComponentsFuiLoadingFuiLoadingClass = CreateVueComponent(GenUniModulesFirstuiUvueComponentsFuiLoadingFuiLoading::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesFirstuiUvueComponentsFuiLoadingFuiLoading.name, inheritAttrs = GenUniModulesFirstuiUvueComponentsFuiLoadingFuiLoading.inheritAttrs, inject = GenUniModulesFirstuiUvueComponentsFuiLoadingFuiLoading.inject, props = GenUniModulesFirstuiUvueComponentsFuiLoadingFuiLoading.props, propsNeedCastKeys = GenUniModulesFirstuiUvueComponentsFuiLoadingFuiLoading.propsNeedCastKeys, emits = GenUniModulesFirstuiUvueComponentsFuiLoadingFuiLoading.emits, components = GenUniModulesFirstuiUvueComponentsFuiLoadingFuiLoading.components, styles = GenUniModulesFirstuiUvueComponentsFuiLoadingFuiLoading.styles)
}
, fun(instance, renderer): GenUniModulesFirstuiUvueComponentsFuiLoadingFuiLoading {
    return GenUniModulesFirstuiUvueComponentsFuiLoadingFuiLoading(instance)
}
)
val GenComponentsXLoadingClass = CreateVueComponent(GenComponentsXLoading__1::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXLoading__1.inheritAttrs, inject = GenComponentsXLoading__1.inject, props = GenComponentsXLoading__1.props, propsNeedCastKeys = GenComponentsXLoading__1.propsNeedCastKeys, emits = GenComponentsXLoading__1.emits, components = GenComponentsXLoading__1.components, styles = GenComponentsXLoading__1.styles, setup = fun(props: ComponentPublicInstance, ctx: SetupContext): Any? {
        return GenComponentsXLoading__1.setup(props as GenComponentsXLoading__1, ctx)
    }
    )
}
, fun(instance, renderer): GenComponentsXLoading__1 {
    return GenComponentsXLoading__1(instance)
}
)
val GenUniModulesTmxUiComponentsTmxProgressTmxProgressClass = CreateVueComponent(GenUniModulesTmxUiComponentsTmxProgressTmxProgress::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesTmxUiComponentsTmxProgressTmxProgress.name, inheritAttrs = GenUniModulesTmxUiComponentsTmxProgressTmxProgress.inheritAttrs, inject = GenUniModulesTmxUiComponentsTmxProgressTmxProgress.inject, props = GenUniModulesTmxUiComponentsTmxProgressTmxProgress.props, propsNeedCastKeys = GenUniModulesTmxUiComponentsTmxProgressTmxProgress.propsNeedCastKeys, emits = GenUniModulesTmxUiComponentsTmxProgressTmxProgress.emits, components = GenUniModulesTmxUiComponentsTmxProgressTmxProgress.components, styles = GenUniModulesTmxUiComponentsTmxProgressTmxProgress.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesTmxUiComponentsTmxProgressTmxProgress.setup(props as GenUniModulesTmxUiComponentsTmxProgressTmxProgress)
    }
    )
}
, fun(instance, renderer): GenUniModulesTmxUiComponentsTmxProgressTmxProgress {
    return GenUniModulesTmxUiComponentsTmxProgressTmxProgress(instance)
}
)
val GenUniModulesTmxUiComponentsTmxLoadingTmxLoadingClass = CreateVueComponent(GenUniModulesTmxUiComponentsTmxLoadingTmxLoading::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesTmxUiComponentsTmxLoadingTmxLoading.name, inheritAttrs = GenUniModulesTmxUiComponentsTmxLoadingTmxLoading.inheritAttrs, inject = GenUniModulesTmxUiComponentsTmxLoadingTmxLoading.inject, props = GenUniModulesTmxUiComponentsTmxLoadingTmxLoading.props, propsNeedCastKeys = GenUniModulesTmxUiComponentsTmxLoadingTmxLoading.propsNeedCastKeys, emits = GenUniModulesTmxUiComponentsTmxLoadingTmxLoading.emits, components = GenUniModulesTmxUiComponentsTmxLoadingTmxLoading.components, styles = GenUniModulesTmxUiComponentsTmxLoadingTmxLoading.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesTmxUiComponentsTmxLoadingTmxLoading.setup(props as GenUniModulesTmxUiComponentsTmxLoadingTmxLoading)
    }
    )
}
, fun(instance, renderer): GenUniModulesTmxUiComponentsTmxLoadingTmxLoading {
    return GenUniModulesTmxUiComponentsTmxLoadingTmxLoading(instance)
}
)
open class GenUniModulesTmxUiComponentsTmxDrawerTmxDrawerSlotDataTrigger (
    @JsonNotNull
    open var show: Boolean = false,
) : SlotData()
val GenUniModulesTmxUiComponentsTmxDrawerTmxDrawerClass = CreateVueComponent(GenUniModulesTmxUiComponentsTmxDrawerTmxDrawer::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesTmxUiComponentsTmxDrawerTmxDrawer.name, inheritAttrs = GenUniModulesTmxUiComponentsTmxDrawerTmxDrawer.inheritAttrs, inject = GenUniModulesTmxUiComponentsTmxDrawerTmxDrawer.inject, props = GenUniModulesTmxUiComponentsTmxDrawerTmxDrawer.props, propsNeedCastKeys = GenUniModulesTmxUiComponentsTmxDrawerTmxDrawer.propsNeedCastKeys, emits = GenUniModulesTmxUiComponentsTmxDrawerTmxDrawer.emits, components = GenUniModulesTmxUiComponentsTmxDrawerTmxDrawer.components, styles = GenUniModulesTmxUiComponentsTmxDrawerTmxDrawer.styles, setup = fun(props: ComponentPublicInstance, ctx: SetupContext): Any? {
        return GenUniModulesTmxUiComponentsTmxDrawerTmxDrawer.setup(props as GenUniModulesTmxUiComponentsTmxDrawerTmxDrawer, ctx)
    }
    )
}
, fun(instance, renderer): GenUniModulesTmxUiComponentsTmxDrawerTmxDrawer {
    return GenUniModulesTmxUiComponentsTmxDrawerTmxDrawer(instance)
}
)
val GenComponentsXUpdateWindowClass = CreateVueComponent(GenComponentsXUpdateWindow::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXUpdateWindow.inheritAttrs, inject = GenComponentsXUpdateWindow.inject, props = GenComponentsXUpdateWindow.props, propsNeedCastKeys = GenComponentsXUpdateWindow.propsNeedCastKeys, emits = GenComponentsXUpdateWindow.emits, components = GenComponentsXUpdateWindow.components, styles = GenComponentsXUpdateWindow.styles, setup = fun(props: ComponentPublicInstance, ctx: SetupContext): Any? {
        return GenComponentsXUpdateWindow.setup(props as GenComponentsXUpdateWindow, ctx)
    }
    )
}
, fun(instance, renderer): GenComponentsXUpdateWindow {
    return GenComponentsXUpdateWindow(instance)
}
)
open class LimeSignatureToFileSuccess (
    @JsonNotNull
    open var tempFilePath: String,
    @JsonNotNull
    open var isEmpty: Boolean = false,
) : UTSObject()
typealias LimeSignatureToFileSuccessCallback = (res: LimeSignatureToFileSuccess) -> Unit
typealias LimeSignatureToFileFailCallback = (res: TakeSnapshotFail) -> Unit
typealias LimeSignatureToFileCompleteCallback = (res: Any) -> Unit
open class LimeSignatureToTempFilePathOptions (
    open var success: LimeSignatureToFileSuccessCallback? = null,
    open var fail: LimeSignatureToFileFailCallback? = null,
    open var complete: LimeSignatureToFileCompleteCallback? = null,
    open var format: String? = null,
) : UTSObject()
open class LimeSignatureOptions (
    @JsonNotNull
    open var penColor: String,
    @JsonNotNull
    open var openSmooth: Boolean = false,
    @JsonNotNull
    open var disableScroll: Boolean = false,
    @JsonNotNull
    open var disabled: Boolean = false,
    @JsonNotNull
    open var penSize: Number,
    @JsonNotNull
    open var minLineWidth: Number,
    @JsonNotNull
    open var maxLineWidth: Number,
    @JsonNotNull
    open var minSpeed: Number,
    @JsonNotNull
    open var maxWidthDiffRate: Number,
    @JsonNotNull
    open var maxHistoryLength: Number,
) : UTSObject()
open class LimeSignaturePoint (
    @JsonNotNull
    open var x: Number,
    @JsonNotNull
    open var y: Number,
    open var c: String? = null,
    open var w: Number? = null,
) : UTSObject()
typealias LimeSignatureLine = UTSArray<LimeSignaturePoint>
var points: LimeSignatureLine = _uA()
var undoStack: UTSArray<LimeSignatureLine> = _uA()
var redoStack: UTSArray<LimeSignatureLine> = _uA()
var lastX: Number = 0
var lastY: Number = 0
typealias SignatureUniElement = UniElement
typealias SignatureCanvasContext = DrawableContext
open class Signature {
    open lateinit var el: SignatureUniElement
    open lateinit var ctx: SignatureCanvasContext
    open var options: LimeSignatureOptions = LimeSignatureOptions(penColor = "black", openSmooth = true, disableScroll = true, disabled = false, penSize = 2, minLineWidth = 2, maxLineWidth = 6, minSpeed = 1.5, maxWidthDiffRate = 20, maxHistoryLength = 20)
    open var isEmpty: Boolean = true
    open var isDrawing: Boolean = false
    open var touchstartCallbackWrapper: UniCallbackWrapper? = null
    open var touchmoveCallbackWrapper: UniCallbackWrapper? = null
    open var touchendCallbackWrapper: UniCallbackWrapper? = null
    open var change: ((isEmpty: Boolean) -> Unit)? = null
    constructor(el: SignatureUniElement){
        this.el = el
        this.ctx = el.getDrawableContext() as DrawableContext
        this.init()
    }
    open fun onChange(cb: (isEmpty: Boolean) -> Unit) {
        this.change = cb
    }
    open fun init() {
        this.touchstartCallbackWrapper = this.el.addEventListener("touchstart", this.onTouchStart)
        this.touchmoveCallbackWrapper = this.el.addEventListener("touchmove", this.onTouchMove)
        this.touchendCallbackWrapper = this.el.addEventListener("touchend", this.onTouchEnd)
    }
    open fun remove() {
        if (this.touchstartCallbackWrapper == null) {
            return
        }
        this.el.removeEventListener("touchstart", this.touchstartCallbackWrapper!!)
        this.el.removeEventListener("touchmove", this.touchmoveCallbackWrapper!!)
        this.el.removeEventListener("touchend", this.touchendCallbackWrapper!!)
    }
    open fun setOption(options: LimeSignatureOptions) {
        this.options = options
    }
    open fun disableScroll(event: UniTouchEvent) {
        event.stopPropagation()
        if (this.options.disableScroll) {
            event.preventDefault()
        }
    }
    open fun getTouchLimeSignaturePoint(event: UniTouchEvent): LimeSignaturePoint {
        val rect = this.el.getBoundingClientRect()
        val touche = event.touches[0]
        val x = touche.clientX
        val y = touche.clientY
        return LimeSignaturePoint(x = x - rect.left, y = y - rect.top)
    }
    open var onTouchStart: (event: UniTouchEvent) -> Unit = fun(event: UniTouchEvent){
        if (this.options.disabled) {
            return
        }
        this.disableScroll(event)
        val _this_getTouchLimeSignaturePoint = this.getTouchLimeSignaturePoint(event)
        val x = _this_getTouchLimeSignaturePoint.x
        val y = _this_getTouchLimeSignaturePoint.y
        this.isDrawing = true
        this.isEmpty = false
        lastX = x
        lastY = y
        points.push(LimeSignaturePoint(x = x, y = y))
    }
    open var onTouchMove: (event: UniTouchEvent) -> Unit = fun(event: UniTouchEvent){
        if (this.options.disabled || !this.isDrawing) {
            return
        }
        this.disableScroll(event)
        val _this_getTouchLimeSignaturePoint = this.getTouchLimeSignaturePoint(event)
        val x = _this_getTouchLimeSignaturePoint.x
        val y = _this_getTouchLimeSignaturePoint.y
        val lineWidth = this.options.penSize
        val strokeStyle = this.options.penColor
        val point = LimeSignaturePoint(x = x, y = y)
        val last = LimeSignaturePoint(x = lastX, y = lastY)
        this.drawLine(point, last, lineWidth, strokeStyle)
        lastX = x
        lastY = y
        points.push(LimeSignaturePoint(x = x, y = y, c = strokeStyle, w = lineWidth))
    }
    open var onTouchEnd: (event: UniTouchEvent) -> Unit = fun(event: UniTouchEvent){
        this.disableScroll(event)
        this.isDrawing = false
        undoStack.push(points)
        redoStack = _uA<LimeSignatureLine>()
        points = _uA<LimeSignaturePoint>()
        this.change?.invoke(this.isEmpty)
    }
    open fun drawLine(point: LimeSignaturePoint, last: LimeSignaturePoint, lineWidth: Number, strokeStyle: String) {
        val ctx = this.ctx
        ctx.lineWidth = lineWidth
        ctx.strokeStyle = strokeStyle
        ctx.lineCap = "round"
        ctx.lineJoin = "round"
        ctx.beginPath()
        ctx.moveTo(last.x, last.y)
        ctx.lineTo(point.x, point.y)
        ctx.stroke()
        ctx.closePath()
        this._draw()
    }
    open fun _clear() {
        this.ctx.reset()
    }
    open fun _draw() {
        this.ctx.update()
    }
    open fun clear() {
        this._clear()
        this._draw()
        this.isEmpty = true
        undoStack = _uA<LimeSignatureLine>()
        redoStack = _uA<LimeSignatureLine>()
        points = _uA<LimeSignaturePoint>()
    }
    open fun undo() {
        if (redoStack.length == this.options.maxHistoryLength && this.options.maxHistoryLength != 0) {
            return
        }
        this._clear()
        if (undoStack.length > 0) {
            val lastPath: LimeSignatureLine = undoStack.pop()!!
            redoStack.push(lastPath)
            if (undoStack.length == 0) {
                this.isEmpty = true
                this._draw()
                return
            }
            run {
                var l: Number = 0
                while(l < undoStack.length){
                    run {
                        var i: Number = 1
                        while(i < undoStack[l].length){
                            val last = undoStack[l][i - 1]
                            val point = undoStack[l][i]
                            this.drawLine(point, last, point.w!!, point.c!!)
                            i++
                        }
                    }
                    l++
                }
            }
        } else {
            this._draw()
        }
    }
    open fun redo() {
        if (redoStack.length < 1) {
            return
        }
        val lastPath: LimeSignatureLine = redoStack.pop()!!
        undoStack.push(lastPath)
        this.isEmpty = false
        run {
            var l: Number = 0
            while(l < undoStack.length){
                run {
                    var i: Number = 1
                    while(i < undoStack[l].length){
                        val last = undoStack[l][i - 1]
                        val point = undoStack[l][i]
                        this.drawLine(point, last, point.w!!, point.c!!)
                        i++
                    }
                }
                l++
            }
        }
    }
}
val GenUniModulesLimeSignatureComponentsLSignatureLSignatureClass = CreateVueComponent(GenUniModulesLimeSignatureComponentsLSignatureLSignature::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenUniModulesLimeSignatureComponentsLSignatureLSignature.inheritAttrs, inject = GenUniModulesLimeSignatureComponentsLSignatureLSignature.inject, props = GenUniModulesLimeSignatureComponentsLSignatureLSignature.props, propsNeedCastKeys = GenUniModulesLimeSignatureComponentsLSignatureLSignature.propsNeedCastKeys, emits = GenUniModulesLimeSignatureComponentsLSignatureLSignature.emits, components = GenUniModulesLimeSignatureComponentsLSignatureLSignature.components, styles = GenUniModulesLimeSignatureComponentsLSignatureLSignature.styles, setup = fun(props: ComponentPublicInstance, ctx: SetupContext): Any? {
        return GenUniModulesLimeSignatureComponentsLSignatureLSignature.setup(props as GenUniModulesLimeSignatureComponentsLSignatureLSignature, ctx)
    }
    )
}
, fun(instance, renderer): GenUniModulesLimeSignatureComponentsLSignatureLSignature {
    return GenUniModulesLimeSignatureComponentsLSignatureLSignature(instance)
}
)
typealias LSignatureComponentPublicInstance = GenUniModulesLimeSignatureComponentsLSignatureLSignature
val GenUniModulesFirstuiUvueComponentsFuiBottomPopupFuiBottomPopupClass = CreateVueComponent(GenUniModulesFirstuiUvueComponentsFuiBottomPopupFuiBottomPopup::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesFirstuiUvueComponentsFuiBottomPopupFuiBottomPopup.name, inheritAttrs = GenUniModulesFirstuiUvueComponentsFuiBottomPopupFuiBottomPopup.inheritAttrs, inject = GenUniModulesFirstuiUvueComponentsFuiBottomPopupFuiBottomPopup.inject, props = GenUniModulesFirstuiUvueComponentsFuiBottomPopupFuiBottomPopup.props, propsNeedCastKeys = GenUniModulesFirstuiUvueComponentsFuiBottomPopupFuiBottomPopup.propsNeedCastKeys, emits = GenUniModulesFirstuiUvueComponentsFuiBottomPopupFuiBottomPopup.emits, components = GenUniModulesFirstuiUvueComponentsFuiBottomPopupFuiBottomPopup.components, styles = GenUniModulesFirstuiUvueComponentsFuiBottomPopupFuiBottomPopup.styles)
}
, fun(instance, renderer): GenUniModulesFirstuiUvueComponentsFuiBottomPopupFuiBottomPopup {
    return GenUniModulesFirstuiUvueComponentsFuiBottomPopupFuiBottomPopup(instance)
}
)
open class LoginResult (
    @JsonNotNull
    open var result: Boolean = false,
    open var code: Number? = null,
    open var reson: String? = null,
    open var token: String? = null,
    open var operator: String? = null,
    open var json: UTSJSONObject? = null,
) : UTSObject()
open class AuthResult (
    @JsonNotNull
    open var result: Boolean = false,
    open var reson: String? = null,
    open var token: String? = null,
    open var operator: String? = null,
    open var json: UTSJSONObject? = null,
) : UTSObject()
open class FaceVerifyResult (
    @JsonNotNull
    open var result: Boolean = false,
    open var reson: String? = null,
    open var json: UTSJSONObject? = null,
    open var certifyId: String? = null,
    open var data: Any? = null,
) : UTSObject()
open class authinfo {
    companion object {
        fun startInitQuickLogin(): UTSPromise<Boolean> {
            return wrapUTSPromise(suspend w@{
                    var r = await(UTSPromise(fun(resolve, reject){
                        var checkVerify = checkVerifyEnable()
                        if (checkVerify == true) {
                            resolve(true)
                            return
                        }
                        initQuickLogin(fun(code: Number, msg: String) {
                            console.log("一键登录初始化", code, msg)
                            if (code == 8000) {
                                var checkVerify = checkVerifyEnable()
                                if (checkVerify == false) {
                                    resolve(false)
                                    return
                                }
                                resolve(initSuccess())
                            } else {
                                resolve(false)
                            }
                        }
                        )
                    }
                    ))
                    return@w r
            })
        }
        fun preAuthLogin(timeOut: Number): UTSPromise<Boolean> {
            return wrapUTSPromise(suspend w@{
                    return@w await(UTSPromise(fun(resolve, reject){
                        preLogin(timeOut, fun(code: Number, content: String) {
                            if (code == 7000) {
                                resolve(isValidePreloginCache())
                                return
                            }
                            resolve(false)
                        }
                        )
                    }
                    ))
            })
        }
        fun startLogin(): UTSPromise<LoginResult> {
            return wrapUTSPromise(suspend w@{
                    return@w await(UTSPromise(fun(resolve, reject){
                        loginAuth(fun(code: Int, msg: String) {
                            console.log("授权事件", code, msg)
                            if (code == 1) {
                                var result = LoginResult(result = false, code = code, reson = "页面被关闭")
                                resolve(result)
                                return
                            }
                        }
                        , fun(code: Int, token: String, opereationType: String, json: UTSJSONObject) {
                            console.log("授权结果", code, token, opereationType, json)
                            if (code == 6000) {
                                var result = LoginResult(result = true, code = code, token = token, operator = opereationType, json = json)
                                resolve(result)
                            } else {
                                var result = LoginResult(result = false, code = code, reson = token, operator = opereationType, json = json)
                                resolve(result)
                            }
                        }
                        )
                    }
                    ))
            })
        }
        fun closeAuth(needCloseAnim: Boolean): UTSPromise<Boolean> {
            return wrapUTSPromise(suspend w@{
                    return@w await(UTSPromise(fun(resolve, reject){
                        closeAuth(needCloseAnim, fun(code: Number, msg: String) {
                            if (code == 0) {
                                resolve(true)
                                return
                            }
                            console.log("关闭授权页失败", msg, code)
                            resolve(false)
                        }
                        )
                    }
                    ))
            })
        }
        fun getAuthToken(timeOut: Number): UTSPromise<AuthResult> {
            return wrapUTSPromise(suspend w@{
                    return@w await(UTSPromise(fun(resolve, reject){
                        authToken(timeOut, fun(code: Int, token: String, operator: String, json: UTSJSONObject) {
                            if (code == 2000) {
                                var r = AuthResult(result = true, token = token, operator = operator, json = json)
                                resolve(r)
                                return
                            }
                            var e = AuthResult(result = false, reson = token, operator = operator, json = json)
                            resolve(e)
                        }
                        )
                    }
                    ))
            })
        }
        fun runPhoneAuth(): UTSPromise<Boolean> {
            return wrapUTSPromise(suspend w@{
                    return@w UTSPromise(fun(resolve, reject){
                        authinfo.startInitQuickLogin().then(fun(res: Boolean) {
                            if (res == false) {
                                resolve(res)
                                return
                            } else {
                                var authResult = authinfo.getAuthToken(5000).then(fun(result: AuthResult) {
                                    if (result.result == false) {
                                        resolve(false)
                                        return
                                    }
                                    var token = result.token as String
                                    request.callapi("user/phoneverify", _uO("verify" to token)).then(fun(resp: responseType) {
                                        if (resp.code == 0) {
                                            var r = resp.data as UTSJSONObject
                                            var b = r["verify"] as Boolean
                                            resolve(b)
                                            return
                                        }
                                        resolve(false)
                                    }
                                    ).`catch`(fun() {
                                        resolve(false)
                                    }
                                    )
                                }
                                ).`catch`(fun() {
                                    resolve(false)
                                }
                                )
                            }
                        }
                        ).`catch`(fun() {
                            resolve(false)
                        }
                        )
                    }
                    )
            })
        }
        fun startFaceVerify(): UTSPromise<FaceVerifyResult> {
            return wrapUTSPromise(suspend w@{
                    var res = await(UTSPromise(fun(resolve, reject){
                        var init = initZimfacafe()
                        if (init != 0) {
                            resolve(FaceVerifyResult(result = false, reson = "初始化失败"))
                            return
                        }
                        var metainfo = getMetaInfo()
                        uni_request<Any>(RequestOptions(url = "https://cdn.itgz8.com/json/faceui.json?v=1.0", method = "GET", success = fun(res){
                            var data = JSON.stringify(res.data) as String
                            var json = data
                            console.log("设定UI", setUI(json))
                            request.callapi("user/getcertifyid", _uO("metainfo" to metainfo)).then(fun(resp: responseType) {
                                if (resp.code < 0) {
                                    console.log("人脸识别启动失败", resp)
                                    resolve(FaceVerifyResult(result = false, reson = "获取certifyid失败", json = resp.info, data = resp))
                                    return
                                }
                                var data = resp.data as UTSJSONObject
                                var certifyId = data["certifyId"] as String
                                faceVerify(certifyId, null, fun(success: Boolean, code: Int?, reason: String?) {
                                    if (success) {
                                        resolve(FaceVerifyResult(result = true, certifyId = certifyId, data = reason))
                                    } else {
                                        var reson = ""
                                        when (code) {
                                            10001 -> 
                                                reson = "certifyId 不能为空"
                                            10002 -> 
                                                reson = "当前设备不支持"
                                            10010 -> 
                                                reson = "刷脸异常"
                                            10011 -> 
                                                reson = "验证中断"
                                            10012 -> 
                                                reson = "网络异常"
                                            10013 -> 
                                                reson = "刷脸验证失败"
                                            10020 -> 
                                                reson = "设备设置时间异常"
                                            else -> 
                                                reson = "未知错误"
                                        }
                                        resolve(FaceVerifyResult(result = false, reson = reson, data = reason))
                                    }
                                }
                                )
                            }
                            )
                        }
                        , fail = fun(_){
                            resolve(FaceVerifyResult(result = false, reson = "获取UI配置失败"))
                        }
                        ))
                    }
                    ))
                    return@w res
            })
        }
    }
}
val GenComponentsXSignerClass = CreateVueComponent(GenComponentsXSigner::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXSigner.inheritAttrs, inject = GenComponentsXSigner.inject, props = GenComponentsXSigner.props, propsNeedCastKeys = GenComponentsXSigner.propsNeedCastKeys, emits = GenComponentsXSigner.emits, components = GenComponentsXSigner.components, styles = GenComponentsXSigner.styles, setup = fun(props: ComponentPublicInstance, ctx: SetupContext): Any? {
        return GenComponentsXSigner.setup(props as GenComponentsXSigner, ctx)
    }
    )
}
, fun(instance, renderer): GenComponentsXSigner {
    return GenComponentsXSigner(instance)
}
)
open class upgrade {
    companion object {
        fun check(): UTSPromise<Any> {
            return wrapUTSPromise(suspend w@{
                    var appver = uni_getAppBaseInfo(GetAppBaseInfoOptions(filter = _uA(
                        "appVersion",
                        "appVersionCode"
                    )))
                    var res = await(request.callapi("app/appupgrade", _uO("version" to appver.appVersion, "version_code" to appver.appVersionCode), AppConfig.postHost))
                    if (res == null || res.code < 0) {
                        return@w false
                    }
                    return@w res.data as UTSJSONObject
            })
        }
    }
}
val GenPagesIndexIndexClass = CreateVueComponent(GenPagesIndexIndex::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesIndexIndex.inheritAttrs, inject = GenPagesIndexIndex.inject, props = GenPagesIndexIndex.props, propsNeedCastKeys = GenPagesIndexIndex.propsNeedCastKeys, emits = GenPagesIndexIndex.emits, components = GenPagesIndexIndex.components, styles = GenPagesIndexIndex.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesIndexIndex.setup(props as GenPagesIndexIndex)
    }
    )
}
, fun(instance, renderer): GenPagesIndexIndex {
    return GenPagesIndexIndex(instance, renderer)
}
)
val GenComponentsXButtonClass = CreateVueComponent(GenComponentsXButton::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXButton.inheritAttrs, inject = GenComponentsXButton.inject, props = GenComponentsXButton.props, propsNeedCastKeys = GenComponentsXButton.propsNeedCastKeys, emits = GenComponentsXButton.emits, components = GenComponentsXButton.components, styles = GenComponentsXButton.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXButton.setup(props as GenComponentsXButton)
    }
    )
}
, fun(instance, renderer): GenComponentsXButton {
    return GenComponentsXButton(instance)
}
)
val GenPagesIndexLoginClass = CreateVueComponent(GenPagesIndexLogin::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesIndexLogin.inheritAttrs, inject = GenPagesIndexLogin.inject, props = GenPagesIndexLogin.props, propsNeedCastKeys = GenPagesIndexLogin.propsNeedCastKeys, emits = GenPagesIndexLogin.emits, components = GenPagesIndexLogin.components, styles = GenPagesIndexLogin.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesIndexLogin.setup(props as GenPagesIndexLogin)
    }
    )
}
, fun(instance, renderer): GenPagesIndexLogin {
    return GenPagesIndexLogin(instance, renderer)
}
)
open class FuiCheckboxChangeParam (
    @JsonNotNull
    open var checked: Boolean = false,
    @JsonNotNull
    open var value: String,
) : UTSObject()
open class FuiDialogButtonsParam (
    @JsonNotNull
    open var text: String,
    open var color: String? = null,
    open var primary: Boolean? = null,
    open var param: String? = null,
    open var index: Number? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return FuiDialogButtonsParamReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class FuiDialogButtonsParamReactiveObject : FuiDialogButtonsParam, IUTSReactive<FuiDialogButtonsParam> {
    override var __v_raw: FuiDialogButtonsParam
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: FuiDialogButtonsParam, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(text = __v_raw.text, color = __v_raw.color, primary = __v_raw.primary, param = __v_raw.param, index = __v_raw.index) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): FuiDialogButtonsParamReactiveObject {
        return FuiDialogButtonsParamReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var text: String
        get() {
            return _tRG(__v_raw, "text", __v_raw.text, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("text")) {
                return
            }
            val oldValue = __v_raw.text
            __v_raw.text = value
            _tRS(__v_raw, "text", oldValue, value)
        }
    override var color: String?
        get() {
            return _tRG(__v_raw, "color", __v_raw.color, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("color")) {
                return
            }
            val oldValue = __v_raw.color
            __v_raw.color = value
            _tRS(__v_raw, "color", oldValue, value)
        }
    override var primary: Boolean?
        get() {
            return _tRG(__v_raw, "primary", __v_raw.primary, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("primary")) {
                return
            }
            val oldValue = __v_raw.primary
            __v_raw.primary = value
            _tRS(__v_raw, "primary", oldValue, value)
        }
    override var param: String?
        get() {
            return _tRG(__v_raw, "param", __v_raw.param, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("param")) {
                return
            }
            val oldValue = __v_raw.param
            __v_raw.param = value
            _tRS(__v_raw, "param", oldValue, value)
        }
    override var index: Number?
        get() {
            return _tRG(__v_raw, "index", __v_raw.index, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("index")) {
                return
            }
            val oldValue = __v_raw.index
            __v_raw.index = value
            _tRS(__v_raw, "index", oldValue, value)
        }
}
open class FuiDropdownMenuOptionParam (
    @JsonNotNull
    open var text: String,
    open var value: String? = null,
    open var src: String? = null,
    open var checked: Boolean? = null,
    open var disabled: Boolean? = null,
    open var param: String? = null,
    open var index: Number? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return FuiDropdownMenuOptionParamReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class FuiDropdownMenuOptionParamReactiveObject : FuiDropdownMenuOptionParam, IUTSReactive<FuiDropdownMenuOptionParam> {
    override var __v_raw: FuiDropdownMenuOptionParam
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: FuiDropdownMenuOptionParam, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(text = __v_raw.text, value = __v_raw.value, src = __v_raw.src, checked = __v_raw.checked, disabled = __v_raw.disabled, param = __v_raw.param, index = __v_raw.index) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): FuiDropdownMenuOptionParamReactiveObject {
        return FuiDropdownMenuOptionParamReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var text: String
        get() {
            return _tRG(__v_raw, "text", __v_raw.text, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("text")) {
                return
            }
            val oldValue = __v_raw.text
            __v_raw.text = value
            _tRS(__v_raw, "text", oldValue, value)
        }
    override var value: String?
        get() {
            return _tRG(__v_raw, "value", __v_raw.value, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("value")) {
                return
            }
            val oldValue = __v_raw.value
            __v_raw.value = value
            _tRS(__v_raw, "value", oldValue, value)
        }
    override var src: String?
        get() {
            return _tRG(__v_raw, "src", __v_raw.src, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("src")) {
                return
            }
            val oldValue = __v_raw.src
            __v_raw.src = value
            _tRS(__v_raw, "src", oldValue, value)
        }
    override var checked: Boolean?
        get() {
            return _tRG(__v_raw, "checked", __v_raw.checked, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("checked")) {
                return
            }
            val oldValue = __v_raw.checked
            __v_raw.checked = value
            _tRS(__v_raw, "checked", oldValue, value)
        }
    override var disabled: Boolean?
        get() {
            return _tRG(__v_raw, "disabled", __v_raw.disabled, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("disabled")) {
                return
            }
            val oldValue = __v_raw.disabled
            __v_raw.disabled = value
            _tRS(__v_raw, "disabled", oldValue, value)
        }
    override var param: String?
        get() {
            return _tRG(__v_raw, "param", __v_raw.param, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("param")) {
                return
            }
            val oldValue = __v_raw.param
            __v_raw.param = value
            _tRS(__v_raw, "param", oldValue, value)
        }
    override var index: Number?
        get() {
            return _tRG(__v_raw, "index", __v_raw.index, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("index")) {
                return
            }
            val oldValue = __v_raw.index
            __v_raw.index = value
            _tRS(__v_raw, "index", oldValue, value)
        }
}
open class FuiSwipeActionButtonParam (
    @JsonNotNull
    open var text: String,
    open var background: String? = null,
    open var size: Number? = null,
    open var color: String? = null,
    open var param: Number? = null,
    open var index: Number? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return FuiSwipeActionButtonParamReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class FuiSwipeActionButtonParamReactiveObject : FuiSwipeActionButtonParam, IUTSReactive<FuiSwipeActionButtonParam> {
    override var __v_raw: FuiSwipeActionButtonParam
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: FuiSwipeActionButtonParam, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(text = __v_raw.text, background = __v_raw.background, size = __v_raw.size, color = __v_raw.color, param = __v_raw.param, index = __v_raw.index) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): FuiSwipeActionButtonParamReactiveObject {
        return FuiSwipeActionButtonParamReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var text: String
        get() {
            return _tRG(__v_raw, "text", __v_raw.text, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("text")) {
                return
            }
            val oldValue = __v_raw.text
            __v_raw.text = value
            _tRS(__v_raw, "text", oldValue, value)
        }
    override var background: String?
        get() {
            return _tRG(__v_raw, "background", __v_raw.background, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("background")) {
                return
            }
            val oldValue = __v_raw.background
            __v_raw.background = value
            _tRS(__v_raw, "background", oldValue, value)
        }
    override var size: Number?
        get() {
            return _tRG(__v_raw, "size", __v_raw.size, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("size")) {
                return
            }
            val oldValue = __v_raw.size
            __v_raw.size = value
            _tRS(__v_raw, "size", oldValue, value)
        }
    override var color: String?
        get() {
            return _tRG(__v_raw, "color", __v_raw.color, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("color")) {
                return
            }
            val oldValue = __v_raw.color
            __v_raw.color = value
            _tRS(__v_raw, "color", oldValue, value)
        }
    override var param: Number?
        get() {
            return _tRG(__v_raw, "param", __v_raw.param, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("param")) {
                return
            }
            val oldValue = __v_raw.param
            __v_raw.param = value
            _tRS(__v_raw, "param", oldValue, value)
        }
    override var index: Number?
        get() {
            return _tRG(__v_raw, "index", __v_raw.index, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("index")) {
                return
            }
            val oldValue = __v_raw.index
            __v_raw.index = value
            _tRS(__v_raw, "index", oldValue, value)
        }
}
open class FuiTabsItemParam (
    @JsonNotNull
    open var name: String,
    open var icon: String? = null,
    open var selectedIcon: String? = null,
    open var badge: Number? = null,
    open var isDot: Boolean? = null,
    open var disabled: Boolean? = null,
    open var index: Number? = null,
    open var key: String? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return FuiTabsItemParamReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class FuiTabsItemParamReactiveObject : FuiTabsItemParam, IUTSReactive<FuiTabsItemParam> {
    override var __v_raw: FuiTabsItemParam
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: FuiTabsItemParam, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(name = __v_raw.name, icon = __v_raw.icon, selectedIcon = __v_raw.selectedIcon, badge = __v_raw.badge, isDot = __v_raw.isDot, disabled = __v_raw.disabled, index = __v_raw.index, key = __v_raw.key) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): FuiTabsItemParamReactiveObject {
        return FuiTabsItemParamReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var name: String
        get() {
            return _tRG(__v_raw, "name", __v_raw.name, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("name")) {
                return
            }
            val oldValue = __v_raw.name
            __v_raw.name = value
            _tRS(__v_raw, "name", oldValue, value)
        }
    override var icon: String?
        get() {
            return _tRG(__v_raw, "icon", __v_raw.icon, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("icon")) {
                return
            }
            val oldValue = __v_raw.icon
            __v_raw.icon = value
            _tRS(__v_raw, "icon", oldValue, value)
        }
    override var selectedIcon: String?
        get() {
            return _tRG(__v_raw, "selectedIcon", __v_raw.selectedIcon, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("selectedIcon")) {
                return
            }
            val oldValue = __v_raw.selectedIcon
            __v_raw.selectedIcon = value
            _tRS(__v_raw, "selectedIcon", oldValue, value)
        }
    override var badge: Number?
        get() {
            return _tRG(__v_raw, "badge", __v_raw.badge, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("badge")) {
                return
            }
            val oldValue = __v_raw.badge
            __v_raw.badge = value
            _tRS(__v_raw, "badge", oldValue, value)
        }
    override var isDot: Boolean?
        get() {
            return _tRG(__v_raw, "isDot", __v_raw.isDot, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("isDot")) {
                return
            }
            val oldValue = __v_raw.isDot
            __v_raw.isDot = value
            _tRS(__v_raw, "isDot", oldValue, value)
        }
    override var disabled: Boolean?
        get() {
            return _tRG(__v_raw, "disabled", __v_raw.disabled, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("disabled")) {
                return
            }
            val oldValue = __v_raw.disabled
            __v_raw.disabled = value
            _tRS(__v_raw, "disabled", oldValue, value)
        }
    override var index: Number?
        get() {
            return _tRG(__v_raw, "index", __v_raw.index, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("index")) {
                return
            }
            val oldValue = __v_raw.index
            __v_raw.index = value
            _tRS(__v_raw, "index", oldValue, value)
        }
    override var key: String?
        get() {
            return _tRG(__v_raw, "key", __v_raw.key, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("key")) {
                return
            }
            val oldValue = __v_raw.key
            __v_raw.key = value
            _tRS(__v_raw, "key", oldValue, value)
        }
}
val GenUniModulesFirstuiUvueComponentsFuiTabsFuiTabsClass = CreateVueComponent(GenUniModulesFirstuiUvueComponentsFuiTabsFuiTabs::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesFirstuiUvueComponentsFuiTabsFuiTabs.name, inheritAttrs = GenUniModulesFirstuiUvueComponentsFuiTabsFuiTabs.inheritAttrs, inject = GenUniModulesFirstuiUvueComponentsFuiTabsFuiTabs.inject, props = GenUniModulesFirstuiUvueComponentsFuiTabsFuiTabs.props, propsNeedCastKeys = GenUniModulesFirstuiUvueComponentsFuiTabsFuiTabs.propsNeedCastKeys, emits = GenUniModulesFirstuiUvueComponentsFuiTabsFuiTabs.emits, components = GenUniModulesFirstuiUvueComponentsFuiTabsFuiTabs.components, styles = GenUniModulesFirstuiUvueComponentsFuiTabsFuiTabs.styles)
}
, fun(instance, renderer): GenUniModulesFirstuiUvueComponentsFuiTabsFuiTabs {
    return GenUniModulesFirstuiUvueComponentsFuiTabsFuiTabs(instance)
}
)
val GenComponentsXToolActionClass = CreateVueComponent(GenComponentsXToolAction::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXToolAction.inheritAttrs, inject = GenComponentsXToolAction.inject, props = GenComponentsXToolAction.props, propsNeedCastKeys = GenComponentsXToolAction.propsNeedCastKeys, emits = GenComponentsXToolAction.emits, components = GenComponentsXToolAction.components, styles = GenComponentsXToolAction.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXToolAction.setup(props as GenComponentsXToolAction)
    }
    )
}
, fun(instance, renderer): GenComponentsXToolAction {
    return GenComponentsXToolAction(instance)
}
)
val GenPagesIndexToolClass = CreateVueComponent(GenPagesIndexTool::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesIndexTool.inheritAttrs, inject = GenPagesIndexTool.inject, props = GenPagesIndexTool.props, propsNeedCastKeys = GenPagesIndexTool.propsNeedCastKeys, emits = GenPagesIndexTool.emits, components = GenPagesIndexTool.components, styles = GenPagesIndexTool.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesIndexTool.setup(props as GenPagesIndexTool)
    }
    )
}
, fun(instance, renderer): GenPagesIndexTool {
    return GenPagesIndexTool(instance, renderer)
}
)
val GenComponentsXOrderClass = CreateVueComponent(GenComponentsXOrder::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXOrder.inheritAttrs, inject = GenComponentsXOrder.inject, props = GenComponentsXOrder.props, propsNeedCastKeys = GenComponentsXOrder.propsNeedCastKeys, emits = GenComponentsXOrder.emits, components = GenComponentsXOrder.components, styles = GenComponentsXOrder.styles)
}
, fun(instance, renderer): GenComponentsXOrder {
    return GenComponentsXOrder(instance)
}
)
val GenComponentsXCalendarClass = CreateVueComponent(GenComponentsXCalendar::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXCalendar.inheritAttrs, inject = GenComponentsXCalendar.inject, props = GenComponentsXCalendar.props, propsNeedCastKeys = GenComponentsXCalendar.propsNeedCastKeys, emits = GenComponentsXCalendar.emits, components = GenComponentsXCalendar.components, styles = GenComponentsXCalendar.styles)
}
, fun(instance, renderer): GenComponentsXCalendar {
    return GenComponentsXCalendar(instance)
}
)
val GenPagesIndexOrderClass = CreateVueComponent(GenPagesIndexOrder::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesIndexOrder.inheritAttrs, inject = GenPagesIndexOrder.inject, props = GenPagesIndexOrder.props, propsNeedCastKeys = GenPagesIndexOrder.propsNeedCastKeys, emits = GenPagesIndexOrder.emits, components = GenPagesIndexOrder.components, styles = GenPagesIndexOrder.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesIndexOrder.setup(props as GenPagesIndexOrder)
    }
    )
}
, fun(instance, renderer): GenPagesIndexOrder {
    return GenPagesIndexOrder(instance, renderer)
}
)
val GenComponentsXStaticActionClass = CreateVueComponent(GenComponentsXStaticAction::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXStaticAction.inheritAttrs, inject = GenComponentsXStaticAction.inject, props = GenComponentsXStaticAction.props, propsNeedCastKeys = GenComponentsXStaticAction.propsNeedCastKeys, emits = GenComponentsXStaticAction.emits, components = GenComponentsXStaticAction.components, styles = GenComponentsXStaticAction.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXStaticAction.setup(props as GenComponentsXStaticAction)
    }
    )
}
, fun(instance, renderer): GenComponentsXStaticAction {
    return GenComponentsXStaticAction(instance)
}
)
typealias SkinType__1 = String
typealias SizeType__1 = String
open class _TagColorResult (
    @JsonNotNull
    open var border: String,
    @JsonNotNull
    open var background: String,
    @JsonNotNull
    open var backgroundImage: String,
    @JsonNotNull
    open var fontColor: String,
    @JsonNotNull
    open var opacity: String,
) : UTSObject()
val GenUniModulesTmxUiComponentsTmxTagTmxTagClass = CreateVueComponent(GenUniModulesTmxUiComponentsTmxTagTmxTag::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesTmxUiComponentsTmxTagTmxTag.name, inheritAttrs = GenUniModulesTmxUiComponentsTmxTagTmxTag.inheritAttrs, inject = GenUniModulesTmxUiComponentsTmxTagTmxTag.inject, props = GenUniModulesTmxUiComponentsTmxTagTmxTag.props, propsNeedCastKeys = GenUniModulesTmxUiComponentsTmxTagTmxTag.propsNeedCastKeys, emits = GenUniModulesTmxUiComponentsTmxTagTmxTag.emits, components = GenUniModulesTmxUiComponentsTmxTagTmxTag.components, styles = GenUniModulesTmxUiComponentsTmxTagTmxTag.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesTmxUiComponentsTmxTagTmxTag.setup(props as GenUniModulesTmxUiComponentsTmxTagTmxTag)
    }
    )
}
, fun(instance, renderer): GenUniModulesTmxUiComponentsTmxTagTmxTag {
    return GenUniModulesTmxUiComponentsTmxTagTmxTag(instance)
}
)
val GenUniModulesTmxUiComponentsTmxDividerTmxDividerClass = CreateVueComponent(GenUniModulesTmxUiComponentsTmxDividerTmxDivider::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesTmxUiComponentsTmxDividerTmxDivider.name, inheritAttrs = GenUniModulesTmxUiComponentsTmxDividerTmxDivider.inheritAttrs, inject = GenUniModulesTmxUiComponentsTmxDividerTmxDivider.inject, props = GenUniModulesTmxUiComponentsTmxDividerTmxDivider.props, propsNeedCastKeys = GenUniModulesTmxUiComponentsTmxDividerTmxDivider.propsNeedCastKeys, emits = GenUniModulesTmxUiComponentsTmxDividerTmxDivider.emits, components = GenUniModulesTmxUiComponentsTmxDividerTmxDivider.components, styles = GenUniModulesTmxUiComponentsTmxDividerTmxDivider.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesTmxUiComponentsTmxDividerTmxDivider.setup(props as GenUniModulesTmxUiComponentsTmxDividerTmxDivider)
    }
    )
}
, fun(instance, renderer): GenUniModulesTmxUiComponentsTmxDividerTmxDivider {
    return GenUniModulesTmxUiComponentsTmxDividerTmxDivider(instance)
}
)
open class X_PICKER_PATH_MENU_TYPE (
    @JsonNotNull
    open var indexPath: UTSArray<Number>,
    @JsonNotNull
    open var ids: UTSArray<String>,
    @JsonNotNull
    open var pathData: UTSArray<X_PICKER_X_ITEM>,
    @JsonNotNull
    open var list: UTSArray<UTSArray<X_PICKER_X_ITEM>>,
) : UTSObject()
fun updatePickerLinkage(tree: UTSArray<X_PICKER_X_ITEM>, oldIndex: UTSArray<Number>, newIndex: UTSArray<Number>): X_PICKER_PATH_MENU_TYPE? {
    var currentNodes = tree
    val path: UTSArray<String> = _uA()
    val indexPaths: UTSArray<Number> = _uA()
    val pathData: UTSArray<X_PICKER_X_ITEM> = _uA()
    val list: UTSArray<UTSArray<X_PICKER_X_ITEM>> = _uA()
    var firstDiffIndex: Number = 0
    run {
        var i: Number = 0
        while(i < Math.min(oldIndex.length, newIndex.length)){
            if (oldIndex[i] !== newIndex[i]) {
                firstDiffIndex = i
                break
            }
            firstDiffIndex = i + 1
            i++
        }
    }
    if (firstDiffIndex === Math.min(oldIndex.length, newIndex.length) && newIndex.length > oldIndex.length) {
        firstDiffIndex = oldIndex.length
    }
    currentNodes = tree
    var level: Number = 0
    while(currentNodes.length > 0){
        var targetIndex: Number
        if (level <= firstDiffIndex) {
            if (level < newIndex.length) {
                targetIndex = newIndex[level]
            } else {
                targetIndex = 0
            }
        } else {
            val oldIdx = if (level < oldIndex.length) {
                oldIndex[level]
            } else {
                0
            }
            if (oldIdx >= 0 && oldIdx < currentNodes.length) {
                targetIndex = oldIdx
            } else {
                targetIndex = currentNodes.length - 1
            }
        }
        if (targetIndex < 0 || targetIndex >= currentNodes.length) {
            targetIndex = 0
        }
        val foundNode = currentNodes[targetIndex]
        path.push(foundNode.id)
        indexPaths.push(targetIndex)
        pathData.push(foundNode)
        list.push(currentNodes)
        currentNodes = foundNode.children
        level++
    }
    if (path.length === 0) {
        return null
    }
    return X_PICKER_PATH_MENU_TYPE(indexPath = indexPaths, ids = path, pathData = pathData, list = list)
}
typealias normalizeListType = (tree: UTSArray<PICKER_ITEM_INFO>) -> UTSArray<X_PICKER_X_ITEM>
open class pickerPathResult (
    @JsonNotNull
    open var ids: UTSArray<String>,
    @JsonNotNull
    open var titles: UTSArray<String>,
) : UTSObject()
open class GenUniModulesTmxUiComponentsTmxPickerViewTmxPickerViewSlotDataLabel (
    @JsonNotNull
    open var checked: Boolean = false,
    @JsonNotNull
    open var value: String,
) : SlotData()
val GenUniModulesTmxUiComponentsTmxPickerViewTmxPickerViewClass = CreateVueComponent(GenUniModulesTmxUiComponentsTmxPickerViewTmxPickerView::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesTmxUiComponentsTmxPickerViewTmxPickerView.name, inheritAttrs = GenUniModulesTmxUiComponentsTmxPickerViewTmxPickerView.inheritAttrs, inject = GenUniModulesTmxUiComponentsTmxPickerViewTmxPickerView.inject, props = GenUniModulesTmxUiComponentsTmxPickerViewTmxPickerView.props, propsNeedCastKeys = GenUniModulesTmxUiComponentsTmxPickerViewTmxPickerView.propsNeedCastKeys, emits = GenUniModulesTmxUiComponentsTmxPickerViewTmxPickerView.emits, components = GenUniModulesTmxUiComponentsTmxPickerViewTmxPickerView.components, styles = GenUniModulesTmxUiComponentsTmxPickerViewTmxPickerView.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesTmxUiComponentsTmxPickerViewTmxPickerView.setup(props as GenUniModulesTmxUiComponentsTmxPickerViewTmxPickerView)
    }
    )
}
, fun(instance, renderer): GenUniModulesTmxUiComponentsTmxPickerViewTmxPickerView {
    return GenUniModulesTmxUiComponentsTmxPickerViewTmxPickerView(instance)
}
)
open class coverValue (
    @JsonNotNull
    open var value: UTSArray<UTSArray<String>>,
    @JsonNotNull
    open var str: String,
) : UTSObject()
typealias ModelType = String
val GenUniModulesTmxUiComponentsTmxDateViewTmxDateViewClass = CreateVueComponent(GenUniModulesTmxUiComponentsTmxDateViewTmxDateView::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesTmxUiComponentsTmxDateViewTmxDateView.name, inheritAttrs = GenUniModulesTmxUiComponentsTmxDateViewTmxDateView.inheritAttrs, inject = GenUniModulesTmxUiComponentsTmxDateViewTmxDateView.inject, props = GenUniModulesTmxUiComponentsTmxDateViewTmxDateView.props, propsNeedCastKeys = GenUniModulesTmxUiComponentsTmxDateViewTmxDateView.propsNeedCastKeys, emits = GenUniModulesTmxUiComponentsTmxDateViewTmxDateView.emits, components = GenUniModulesTmxUiComponentsTmxDateViewTmxDateView.components, styles = GenUniModulesTmxUiComponentsTmxDateViewTmxDateView.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesTmxUiComponentsTmxDateViewTmxDateView.setup(props as GenUniModulesTmxUiComponentsTmxDateViewTmxDateView)
    }
    )
}
, fun(instance, renderer): GenUniModulesTmxUiComponentsTmxDateViewTmxDateView {
    return GenUniModulesTmxUiComponentsTmxDateViewTmxDateView(instance)
}
)
open class coverValueType (
    @JsonNotNull
    open var value: UTSArray<String>,
    @JsonNotNull
    open var str: String,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return coverValueTypeReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class coverValueTypeReactiveObject : coverValueType, IUTSReactive<coverValueType> {
    override var __v_raw: coverValueType
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: coverValueType, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(value = __v_raw.value, str = __v_raw.str) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): coverValueTypeReactiveObject {
        return coverValueTypeReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var value: UTSArray<String>
        get() {
            return _tRG(__v_raw, "value", __v_raw.value, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("value")) {
                return
            }
            val oldValue = __v_raw.value
            __v_raw.value = value
            _tRS(__v_raw, "value", oldValue, value)
        }
    override var str: String
        get() {
            return _tRG(__v_raw, "str", __v_raw.str, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("str")) {
                return
            }
            val oldValue = __v_raw.str
            __v_raw.str = value
            _tRS(__v_raw, "str", oldValue, value)
        }
}
open class GenUniModulesTmxUiComponentsTmxBetweenTimeTmxBetweenTimeSlotDataDefault (
    @JsonNotNull
    open var show: Boolean = false,
    @JsonNotNull
    open var startVal: String,
    @JsonNotNull
    open var endVal: String,
) : SlotData()
val GenUniModulesTmxUiComponentsTmxBetweenTimeTmxBetweenTimeClass = CreateVueComponent(GenUniModulesTmxUiComponentsTmxBetweenTimeTmxBetweenTime::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesTmxUiComponentsTmxBetweenTimeTmxBetweenTime.name, inheritAttrs = GenUniModulesTmxUiComponentsTmxBetweenTimeTmxBetweenTime.inheritAttrs, inject = GenUniModulesTmxUiComponentsTmxBetweenTimeTmxBetweenTime.inject, props = GenUniModulesTmxUiComponentsTmxBetweenTimeTmxBetweenTime.props, propsNeedCastKeys = GenUniModulesTmxUiComponentsTmxBetweenTimeTmxBetweenTime.propsNeedCastKeys, emits = GenUniModulesTmxUiComponentsTmxBetweenTimeTmxBetweenTime.emits, components = GenUniModulesTmxUiComponentsTmxBetweenTimeTmxBetweenTime.components, styles = GenUniModulesTmxUiComponentsTmxBetweenTimeTmxBetweenTime.styles, setup = fun(props: ComponentPublicInstance, ctx: SetupContext): Any? {
        return GenUniModulesTmxUiComponentsTmxBetweenTimeTmxBetweenTime.setup(props as GenUniModulesTmxUiComponentsTmxBetweenTimeTmxBetweenTime, ctx)
    }
    )
}
, fun(instance, renderer): GenUniModulesTmxUiComponentsTmxBetweenTimeTmxBetweenTime {
    return GenUniModulesTmxUiComponentsTmxBetweenTimeTmxBetweenTime(instance)
}
)
val GenPagesIndexStaticpageClass = CreateVueComponent(GenPagesIndexStaticpage::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesIndexStaticpage.inheritAttrs, inject = GenPagesIndexStaticpage.inject, props = GenPagesIndexStaticpage.props, propsNeedCastKeys = GenPagesIndexStaticpage.propsNeedCastKeys, emits = GenPagesIndexStaticpage.emits, components = GenPagesIndexStaticpage.components, styles = GenPagesIndexStaticpage.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesIndexStaticpage.setup(props as GenPagesIndexStaticpage)
    }
    )
}
, fun(instance, renderer): GenPagesIndexStaticpage {
    return GenPagesIndexStaticpage(instance, renderer)
}
)
val GenComponentsXMineActionClass = CreateVueComponent(GenComponentsXMineAction::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXMineAction.inheritAttrs, inject = GenComponentsXMineAction.inject, props = GenComponentsXMineAction.props, propsNeedCastKeys = GenComponentsXMineAction.propsNeedCastKeys, emits = GenComponentsXMineAction.emits, components = GenComponentsXMineAction.components, styles = GenComponentsXMineAction.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXMineAction.setup(props as GenComponentsXMineAction)
    }
    )
}
, fun(instance, renderer): GenComponentsXMineAction {
    return GenComponentsXMineAction(instance)
}
)
interface LSvpProps {
    var src: String
    var color: String
    var web: Boolean
    var inherit: Boolean
}
fun pathToDataUrl(path: String): UTSPromise<String> {
    return UTSPromise(fun(resolve, reject){
        val url = path
        resolve(url.replace(UTSRegExp("\\s+", "g"), ""))
    }
    )
}
fun svgToDataUrl(svgString: String): String {
    val encodedSvg = encodeURIComponent(svgString)!!.replace(UTSRegExp("\\+", "g"), "%20")
    return "data:image/svg+xml," + encodedSvg
}
val GenUniModulesLimeSvgComponentsLSvgLSvgClass = CreateVueComponent(GenUniModulesLimeSvgComponentsLSvgLSvg::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenUniModulesLimeSvgComponentsLSvgLSvg.inheritAttrs, inject = GenUniModulesLimeSvgComponentsLSvgLSvg.inject, props = GenUniModulesLimeSvgComponentsLSvgLSvg.props, propsNeedCastKeys = GenUniModulesLimeSvgComponentsLSvgLSvg.propsNeedCastKeys, emits = GenUniModulesLimeSvgComponentsLSvgLSvg.emits, components = GenUniModulesLimeSvgComponentsLSvgLSvg.components, styles = GenUniModulesLimeSvgComponentsLSvgLSvg.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesLimeSvgComponentsLSvgLSvg.setup(props as GenUniModulesLimeSvgComponentsLSvgLSvg)
    }
    )
}
, fun(instance, renderer): GenUniModulesLimeSvgComponentsLSvgLSvg {
    return GenUniModulesLimeSvgComponentsLSvgLSvg(instance)
}
)
val GenComponentsXVerClass = CreateVueComponent(GenComponentsXVer::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXVer.inheritAttrs, inject = GenComponentsXVer.inject, props = GenComponentsXVer.props, propsNeedCastKeys = GenComponentsXVer.propsNeedCastKeys, emits = GenComponentsXVer.emits, components = GenComponentsXVer.components, styles = GenComponentsXVer.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXVer.setup(props as GenComponentsXVer)
    }
    )
}
, fun(instance, renderer): GenComponentsXVer {
    return GenComponentsXVer(instance)
}
)
val GenPagesIndexMineClass = CreateVueComponent(GenPagesIndexMine::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesIndexMine.inheritAttrs, inject = GenPagesIndexMine.inject, props = GenPagesIndexMine.props, propsNeedCastKeys = GenPagesIndexMine.propsNeedCastKeys, emits = GenPagesIndexMine.emits, components = GenPagesIndexMine.components, styles = GenPagesIndexMine.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesIndexMine.setup(props as GenPagesIndexMine)
    }
    )
}
, fun(instance, renderer): GenPagesIndexMine {
    return GenPagesIndexMine(instance, renderer)
}
)
val GenUniModulesFirstuiUvueComponentsFuiDropdownMenuFuiDropdownMenuClass = CreateVueComponent(GenUniModulesFirstuiUvueComponentsFuiDropdownMenuFuiDropdownMenu::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesFirstuiUvueComponentsFuiDropdownMenuFuiDropdownMenu.name, inheritAttrs = GenUniModulesFirstuiUvueComponentsFuiDropdownMenuFuiDropdownMenu.inheritAttrs, inject = GenUniModulesFirstuiUvueComponentsFuiDropdownMenuFuiDropdownMenu.inject, props = GenUniModulesFirstuiUvueComponentsFuiDropdownMenuFuiDropdownMenu.props, propsNeedCastKeys = GenUniModulesFirstuiUvueComponentsFuiDropdownMenuFuiDropdownMenu.propsNeedCastKeys, emits = GenUniModulesFirstuiUvueComponentsFuiDropdownMenuFuiDropdownMenu.emits, components = GenUniModulesFirstuiUvueComponentsFuiDropdownMenuFuiDropdownMenu.components, styles = GenUniModulesFirstuiUvueComponentsFuiDropdownMenuFuiDropdownMenu.styles)
}
, fun(instance, renderer): GenUniModulesFirstuiUvueComponentsFuiDropdownMenuFuiDropdownMenu {
    return GenUniModulesFirstuiUvueComponentsFuiDropdownMenuFuiDropdownMenu(instance)
}
)
typealias FuiDropdownMenuComponentPublicInstance = GenUniModulesFirstuiUvueComponentsFuiDropdownMenuFuiDropdownMenu
open class calcular {
    companion object {
        fun calcStr(arr: UTSArray<String>): String {
            var result = ""
            var last = ""
            for(item in resolveUTSKeyIterator(arr)){
                if (item == "." && last == "+") {
                    result += "0"
                }
                if (item == "." && last == ".") {
                    continue
                }
                if (item == "+" && last == "+") {
                    continue
                }
                if (item == "+" && last == "") {
                    continue
                }
                result += item
                last = item
            }
            return result
        }
        fun calcResult(reassignedStr: String): Number {
            var str = reassignedStr
            str = str.trim()
            var arr = str.split("+")
            var result: Number = 0
            for(n in resolveUTSKeyIterator(arr)){
                if (n == "") {
                    continue
                }
                if (parseFloat(n) == NaN) {
                    continue
                }
                result += parseFloat(n)
            }
            return result
        }
    }
}
val GenComponentsXCalculatorClass = CreateVueComponent(GenComponentsXCalculator::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXCalculator.inheritAttrs, inject = GenComponentsXCalculator.inject, props = GenComponentsXCalculator.props, propsNeedCastKeys = GenComponentsXCalculator.propsNeedCastKeys, emits = GenComponentsXCalculator.emits, components = GenComponentsXCalculator.components, styles = GenComponentsXCalculator.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXCalculator.setup(props as GenComponentsXCalculator)
    }
    )
}
, fun(instance, renderer): GenComponentsXCalculator {
    return GenComponentsXCalculator(instance)
}
)
val GenPagesCasherReceiveClass = CreateVueComponent(GenPagesCasherReceive::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesCasherReceive.inheritAttrs, inject = GenPagesCasherReceive.inject, props = GenPagesCasherReceive.props, propsNeedCastKeys = GenPagesCasherReceive.propsNeedCastKeys, emits = GenPagesCasherReceive.emits, components = GenPagesCasherReceive.components, styles = GenPagesCasherReceive.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesCasherReceive.setup(props as GenPagesCasherReceive)
    }
    )
}
, fun(instance, renderer): GenPagesCasherReceive {
    return GenPagesCasherReceive(instance, renderer)
}
)
val GenPagesCasherOnlineReceiveClass = CreateVueComponent(GenPagesCasherOnlineReceive::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesCasherOnlineReceive.inheritAttrs, inject = GenPagesCasherOnlineReceive.inject, props = GenPagesCasherOnlineReceive.props, propsNeedCastKeys = GenPagesCasherOnlineReceive.propsNeedCastKeys, emits = GenPagesCasherOnlineReceive.emits, components = GenPagesCasherOnlineReceive.components, styles = GenPagesCasherOnlineReceive.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesCasherOnlineReceive.setup(props as GenPagesCasherOnlineReceive)
    }
    )
}
, fun(instance, renderer): GenPagesCasherOnlineReceive {
    return GenPagesCasherOnlineReceive(instance, renderer)
}
)
val GenComponentsXRefreshBoxClass = CreateVueComponent(GenComponentsXRefreshBox::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXRefreshBox.inheritAttrs, inject = GenComponentsXRefreshBox.inject, props = GenComponentsXRefreshBox.props, propsNeedCastKeys = GenComponentsXRefreshBox.propsNeedCastKeys, emits = GenComponentsXRefreshBox.emits, components = GenComponentsXRefreshBox.components, styles = GenComponentsXRefreshBox.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXRefreshBox.setup(props as GenComponentsXRefreshBox)
    }
    )
}
, fun(instance, renderer): GenComponentsXRefreshBox {
    return GenComponentsXRefreshBox(instance)
}
)
val GenComponentsXPagingClass = CreateVueComponent(GenComponentsXPaging::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXPaging.inheritAttrs, inject = GenComponentsXPaging.inject, props = GenComponentsXPaging.props, propsNeedCastKeys = GenComponentsXPaging.propsNeedCastKeys, emits = GenComponentsXPaging.emits, components = GenComponentsXPaging.components, styles = GenComponentsXPaging.styles, setup = fun(props: ComponentPublicInstance, ctx: SetupContext): Any? {
        return GenComponentsXPaging.setup(props as GenComponentsXPaging, ctx)
    }
    )
}
, fun(instance, renderer): GenComponentsXPaging {
    return GenComponentsXPaging(instance)
}
)
val GenPagesCommonChoosememberClass = CreateVueComponent(GenPagesCommonChoosemember::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesCommonChoosemember.inheritAttrs, inject = GenPagesCommonChoosemember.inject, props = GenPagesCommonChoosemember.props, propsNeedCastKeys = GenPagesCommonChoosemember.propsNeedCastKeys, emits = GenPagesCommonChoosemember.emits, components = GenPagesCommonChoosemember.components, styles = GenPagesCommonChoosemember.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesCommonChoosemember.setup(props as GenPagesCommonChoosemember)
    }
    )
}
, fun(instance, renderer): GenPagesCommonChoosemember {
    return GenPagesCommonChoosemember(instance, renderer)
}
)
val GenComponentsXButtomLoadingClass = CreateVueComponent(GenComponentsXButtomLoading::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXButtomLoading.inheritAttrs, inject = GenComponentsXButtomLoading.inject, props = GenComponentsXButtomLoading.props, propsNeedCastKeys = GenComponentsXButtomLoading.propsNeedCastKeys, emits = GenComponentsXButtomLoading.emits, components = GenComponentsXButtomLoading.components, styles = GenComponentsXButtomLoading.styles)
}
, fun(instance, renderer): GenComponentsXButtomLoading {
    return GenComponentsXButtomLoading(instance)
}
)
val GenComponentsXNomoredataClass = CreateVueComponent(GenComponentsXNomoredata::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXNomoredata.inheritAttrs, inject = GenComponentsXNomoredata.inject, props = GenComponentsXNomoredata.props, propsNeedCastKeys = GenComponentsXNomoredata.propsNeedCastKeys, emits = GenComponentsXNomoredata.emits, components = GenComponentsXNomoredata.components, styles = GenComponentsXNomoredata.styles)
}
, fun(instance, renderer): GenComponentsXNomoredata {
    return GenComponentsXNomoredata(instance)
}
)
val GenPagesCommonChoosedepartClass = CreateVueComponent(GenPagesCommonChoosedepart::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesCommonChoosedepart.inheritAttrs, inject = GenPagesCommonChoosedepart.inject, props = GenPagesCommonChoosedepart.props, propsNeedCastKeys = GenPagesCommonChoosedepart.propsNeedCastKeys, emits = GenPagesCommonChoosedepart.emits, components = GenPagesCommonChoosedepart.components, styles = GenPagesCommonChoosedepart.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesCommonChoosedepart.setup(props as GenPagesCommonChoosedepart)
    }
    )
}
, fun(instance, renderer): GenPagesCommonChoosedepart {
    return GenPagesCommonChoosedepart(instance, renderer)
}
)
val GenPagesMemberViewClass = CreateVueComponent(GenPagesMemberView::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesMemberView.inheritAttrs, inject = GenPagesMemberView.inject, props = GenPagesMemberView.props, propsNeedCastKeys = GenPagesMemberView.propsNeedCastKeys, emits = GenPagesMemberView.emits, components = GenPagesMemberView.components, styles = GenPagesMemberView.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesMemberView.setup(props as GenPagesMemberView)
    }
    )
}
, fun(instance, renderer): GenPagesMemberView {
    return GenPagesMemberView(instance, renderer)
}
)
val GenPagesGoodsQueryClass = CreateVueComponent(GenPagesGoodsQuery::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesGoodsQuery.inheritAttrs, inject = GenPagesGoodsQuery.inject, props = GenPagesGoodsQuery.props, propsNeedCastKeys = GenPagesGoodsQuery.propsNeedCastKeys, emits = GenPagesGoodsQuery.emits, components = GenPagesGoodsQuery.components, styles = GenPagesGoodsQuery.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesGoodsQuery.setup(props as GenPagesGoodsQuery)
    }
    )
}
, fun(instance, renderer): GenPagesGoodsQuery {
    return GenPagesGoodsQuery(instance, renderer)
}
)
val GenComponentsXViewtitleClass = CreateVueComponent(GenComponentsXViewtitle::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXViewtitle.inheritAttrs, inject = GenComponentsXViewtitle.inject, props = GenComponentsXViewtitle.props, propsNeedCastKeys = GenComponentsXViewtitle.propsNeedCastKeys, emits = GenComponentsXViewtitle.emits, components = GenComponentsXViewtitle.components, styles = GenComponentsXViewtitle.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXViewtitle.setup(props as GenComponentsXViewtitle)
    }
    )
}
, fun(instance, renderer): GenComponentsXViewtitle {
    return GenComponentsXViewtitle(instance)
}
)
val GenComponentsXTriangleinputClass = CreateVueComponent(GenComponentsXTriangleinput::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXTriangleinput.inheritAttrs, inject = GenComponentsXTriangleinput.inject, props = GenComponentsXTriangleinput.props, propsNeedCastKeys = GenComponentsXTriangleinput.propsNeedCastKeys, emits = GenComponentsXTriangleinput.emits, components = GenComponentsXTriangleinput.components, styles = GenComponentsXTriangleinput.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXTriangleinput.setup(props as GenComponentsXTriangleinput)
    }
    )
}
, fun(instance, renderer): GenComponentsXTriangleinput {
    return GenComponentsXTriangleinput(instance)
}
)
val GenComponentsXAddgoodsClass = CreateVueComponent(GenComponentsXAddgoods::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXAddgoods.inheritAttrs, inject = GenComponentsXAddgoods.inject, props = GenComponentsXAddgoods.props, propsNeedCastKeys = GenComponentsXAddgoods.propsNeedCastKeys, emits = GenComponentsXAddgoods.emits, components = GenComponentsXAddgoods.components, styles = GenComponentsXAddgoods.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXAddgoods.setup(props as GenComponentsXAddgoods)
    }
    )
}
, fun(instance, renderer): GenComponentsXAddgoods {
    return GenComponentsXAddgoods(instance)
}
)
val GenComponentsXProcessClass = CreateVueComponent(GenComponentsXProcess::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXProcess.inheritAttrs, inject = GenComponentsXProcess.inject, props = GenComponentsXProcess.props, propsNeedCastKeys = GenComponentsXProcess.propsNeedCastKeys, emits = GenComponentsXProcess.emits, components = GenComponentsXProcess.components, styles = GenComponentsXProcess.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXProcess.setup(props as GenComponentsXProcess)
    }
    )
}
, fun(instance, renderer): GenComponentsXProcess {
    return GenComponentsXProcess(instance)
}
)
val GenComponentsXButtommenuClass = CreateVueComponent(GenComponentsXButtommenu::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXButtommenu.inheritAttrs, inject = GenComponentsXButtommenu.inject, props = GenComponentsXButtommenu.props, propsNeedCastKeys = GenComponentsXButtommenu.propsNeedCastKeys, emits = GenComponentsXButtommenu.emits, components = GenComponentsXButtommenu.components, styles = GenComponentsXButtommenu.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXButtommenu.setup(props as GenComponentsXButtommenu)
    }
    )
}
, fun(instance, renderer): GenComponentsXButtommenu {
    return GenComponentsXButtommenu(instance)
}
)
val GenComponentsXRemarkboxClass = CreateVueComponent(GenComponentsXRemarkbox::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXRemarkbox.inheritAttrs, inject = GenComponentsXRemarkbox.inject, props = GenComponentsXRemarkbox.props, propsNeedCastKeys = GenComponentsXRemarkbox.propsNeedCastKeys, emits = GenComponentsXRemarkbox.emits, components = GenComponentsXRemarkbox.components, styles = GenComponentsXRemarkbox.styles, setup = fun(props: ComponentPublicInstance, ctx: SetupContext): Any? {
        return GenComponentsXRemarkbox.setup(props as GenComponentsXRemarkbox, ctx)
    }
    )
}
, fun(instance, renderer): GenComponentsXRemarkbox {
    return GenComponentsXRemarkbox(instance)
}
)
open class WxPopupChangeEvent (
    @JsonNotNull
    open var show: Boolean = false,
    @JsonNotNull
    open var type: String,
) : UTSObject()
open class IconType (
    @JsonNotNull
    open var name: String,
    @JsonNotNull
    open var unicode: String,
) : UTSObject()
var icons = _uA<IconType>(IconType(name = "wxicon-level", unicode = "\ue68f"), IconType(name = "wxicon-download", unicode = "\ue670"), IconType(name = "wxicon-search", unicode = "\ue632"), IconType(name = "wxicon-reload", unicode = "\ue627"), IconType(name = "wxicon-scan", unicode = "\ue631"), IconType(name = "wxicon-calendar", unicode = "\ue65c"), IconType(name = "wxicon-bag", unicode = "\ue647"), IconType(name = "wxicon-checkbox-mark", unicode = "\ue659"), IconType(name = "wxicon-attach", unicode = "\ue640"), IconType(name = "wxicon-wifi-off", unicode = "\ue6cc"), IconType(name = "wxicon-woman", unicode = "\ue626"), IconType(name = "wxicon-man", unicode = "\ue675"), IconType(name = "wxicon-chat", unicode = "\ue656"), IconType(name = "wxicon-chat-fill", unicode = "\ue63f"), IconType(name = "wxicon-red-packet", unicode = "\ue6c3"), IconType(name = "wxicon-folder", unicode = "\ue694"), IconType(name = "wxicon-order", unicode = "\ue695"), IconType(name = "wxicon-arrow-up-fill", unicode = "\ue636"), IconType(name = "wxicon-arrow-down-fill", unicode = "\ue638"), IconType(name = "wxicon-backspace", unicode = "\ue64d"), IconType(name = "wxicon-photo", unicode = "\ue60d"), IconType(name = "wxicon-photo-fill", unicode = "\ue6b4"), IconType(name = "wxicon-lock", unicode = "\ue69d"), IconType(name = "wxicon-lock-fill", unicode = "\ue6a6"), IconType(name = "wxicon-lock-open", unicode = "\ue68d"), IconType(name = "wxicon-lock-opened-fill", unicode = "\ue6a1"), IconType(name = "wxicon-home", unicode = "\ue67b"), IconType(name = "wxicon-home-fill", unicode = "\ue68e"), IconType(name = "wxicon-star", unicode = "\ue618"), IconType(name = "wxicon-star-fill", unicode = "\ue61e"), IconType(name = "wxicon-star-half", unicode = "\ue699"), IconType(name = "wxicon-share", unicode = "\ue629"), IconType(name = "wxicon-share-fill", unicode = "\ue6bb"), IconType(name = "wxicon-share-square", unicode = "\ue6c4"), IconType(name = "wxicon-volume", unicode = "\ue605"), IconType(name = "wxicon-volume-fill", unicode = "\ue624"), IconType(name = "wxicon-volume-off", unicode = "\ue6bd"), IconType(name = "wxicon-volume-off-fill", unicode = "\ue6c8"), IconType(name = "wxicon-trash", unicode = "\ue623"), IconType(name = "wxicon-trash-fill", unicode = "\ue6ce"), IconType(name = "wxicon-shopping-cart", unicode = "\ue6cb"), IconType(name = "wxicon-shopping-cart-fill", unicode = "\ue630"), IconType(name = "wxicon-question-circle", unicode = "\ue622"), IconType(name = "wxicon-question-circle-fill", unicode = "\ue6bc"), IconType(name = "wxicon-plus", unicode = "\ue625"), IconType(name = "wxicon-plus-circle", unicode = "\ue603"), IconType(name = "wxicon-plus-circle-fill", unicode = "\ue611"), IconType(name = "wxicon-tags", unicode = "\ue621"), IconType(name = "wxicon-tags-fill", unicode = "\ue613"), IconType(name = "wxicon-pause", unicode = "\ue61c"), IconType(name = "wxicon-pause-circle", unicode = "\ue696"), IconType(name = "wxicon-pause-circle-fill", unicode = "\ue60c"), IconType(name = "wxicon-play-circle", unicode = "\ue6af"), IconType(name = "wxicon-play-circle-fill", unicode = "\ue62a"), IconType(name = "wxicon-map", unicode = "\ue665"), IconType(name = "wxicon-map-fill", unicode = "\ue6a8"), IconType(name = "wxicon-phone", unicode = "\ue6ba"), IconType(name = "wxicon-phone-fill", unicode = "\ue6ac"), IconType(name = "wxicon-list", unicode = "\ue690"), IconType(name = "wxicon-list-dot", unicode = "\ue6a9"), IconType(name = "wxicon-info-circle", unicode = "\ue69f"), IconType(name = "wxicon-info-circle-fill", unicode = "\ue6a7"), IconType(name = "wxicon-minus", unicode = "\ue614"), IconType(name = "wxicon-minus-circle", unicode = "\ue6a5"), IconType(name = "wxicon-mic", unicode = "\ue66d"), IconType(name = "wxicon-mic-off", unicode = "\ue691"), IconType(name = "wxicon-grid", unicode = "\ue68c"), IconType(name = "wxicon-grid-fill", unicode = "\ue698"), IconType(name = "wxicon-eye", unicode = "\ue664"), IconType(name = "wxicon-eye-fill", unicode = "\ue697"), IconType(name = "wxicon-eye-off", unicode = "\ue69c"), IconType(name = "wxicon-eye-off-outline", unicode = "\ue688"), IconType(name = "wxicon-file-text", unicode = "\ue687"), IconType(name = "wxicon-file-text-fill", unicode = "\ue67f"), IconType(name = "wxicon-edit-pen", unicode = "\ue65d"), IconType(name = "wxicon-edit-pen-fill", unicode = "\ue679"), IconType(name = "wxicon-email", unicode = "\ue673"), IconType(name = "wxicon-email-fill", unicode = "\ue683"), IconType(name = "wxicon-checkmark", unicode = "\ue64a"), IconType(name = "wxicon-checkmark-circle", unicode = "\ue643"), IconType(name = "wxicon-checkmark-circle-fill", unicode = "\ue668"), IconType(name = "wxicon-clock", unicode = "\ue66c"), IconType(name = "wxicon-clock-fill", unicode = "\ue64b"), IconType(name = "wxicon-close", unicode = "\ue65a"), IconType(name = "wxicon-close-circle", unicode = "\ue64e"), IconType(name = "wxicon-close-circle-fill", unicode = "\ue666"), IconType(name = "wxicon-car", unicode = "\ue64f"), IconType(name = "wxicon-car-fill", unicode = "\ue648"), IconType(name = "wxicon-bell", unicode = "\ue651"), IconType(name = "wxicon-bell-fill", unicode = "\ue604"), IconType(name = "wxicon-play-left", unicode = "\ue6bf"), IconType(name = "wxicon-play-right", unicode = "\ue6b3"), IconType(name = "wxicon-play-left-fill", unicode = "\ue6ae"), IconType(name = "wxicon-play-right-fill", unicode = "\ue6ad"), IconType(name = "wxicon-skip-back-left", unicode = "\ue6c5"), IconType(name = "wxicon-skip-forward-right", unicode = "\ue61f"), IconType(name = "wxicon-setting", unicode = "\ue602"), IconType(name = "wxicon-setting-fill", unicode = "\ue6d0"), IconType(name = "wxicon-more-dot-fill", unicode = "\ue66f"), IconType(name = "wxicon-more-circle", unicode = "\ue69e"), IconType(name = "wxicon-more-circle-fill", unicode = "\ue684"), IconType(name = "wxicon-arrow-upward", unicode = "\ue641"), IconType(name = "wxicon-arrow-downward", unicode = "\ue634"), IconType(name = "wxicon-arrow-leftward", unicode = "\ue63b"), IconType(name = "wxicon-arrow-rightward", unicode = "\ue644"), IconType(name = "wxicon-arrow-up", unicode = "\ue633"), IconType(name = "wxicon-arrow-down", unicode = "\ue63e"), IconType(name = "wxicon-arrow-left", unicode = "\ue646"), IconType(name = "wxicon-arrow-right", unicode = "\ue63c"), IconType(name = "wxicon-thumb-up", unicode = "\ue612"), IconType(name = "wxicon-thumb-up-fill", unicode = "\ue62c"), IconType(name = "wxicon-thumb-down", unicode = "\ue60a"), IconType(name = "wxicon-thumb-down-fill", unicode = "\ue628"), IconType(name = "wxicon-coupon", unicode = "\ue65f"), IconType(name = "wxicon-coupon-fill", unicode = "\ue64c"), IconType(name = "wxicon-kefu-ermai", unicode = "\ue660"), IconType(name = "wxicon-server-fill", unicode = "\ue610"), IconType(name = "wxicon-server-man", unicode = "\ue601"), IconType(name = "wxicon-warning", unicode = "\ue6c1"), IconType(name = "wxicon-warning-fill", unicode = "\ue6c7"), IconType(name = "wxicon-camera", unicode = "\ue642"), IconType(name = "wxicon-camera-fill", unicode = "\ue650"), IconType(name = "wxicon-pushpin", unicode = "\ue6d1"), IconType(name = "wxicon-pushpin-fill", unicode = "\ue6b6"), IconType(name = "wxicon-heart", unicode = "\ue6a2"), IconType(name = "wxicon-heart-fill", unicode = "\ue68b"), IconType(name = "wxicon-account", unicode = "\ue63a"), IconType(name = "wxicon-account-fill", unicode = "\ue653"), IconType(name = "wxicon-integral", unicode = "\ue693"), IconType(name = "wxicon-integral-fill", unicode = "\ue6b1"), IconType(name = "wxicon-gift", unicode = "\ue680"), IconType(name = "wxicon-gift-fill", unicode = "\ue6b0"), IconType(name = "wxicon-empty-data", unicode = "\ue671"), IconType(name = "wxicon-empty-address", unicode = "\ue68a"), IconType(name = "wxicon-empty-favor", unicode = "\ue662"), IconType(name = "wxicon-empty-car", unicode = "\ue656"), IconType(name = "wxicon-empty-order", unicode = "\ue66b"), IconType(name = "wxicon-empty-list", unicode = "\ue671"), IconType(name = "wxicon-empty-search", unicode = "\ue677"), IconType(name = "wxicon-empty-permission", unicode = "\ue67c"), IconType(name = "wxicon-empty-news", unicode = "\ue67d"), IconType(name = "wxicon-empty-history", unicode = "\ue684"), IconType(name = "wxicon-empty-coupon", unicode = "\ue69b"), IconType(name = "wxicon-empty-page", unicode = "\ue60e"), IconType(name = "wxicon-apple-fill", unicode = "\ue635"), IconType(name = "wxicon-zhifubao-circle-fill", unicode = "\ue617"), IconType(name = "wxicon-weixin-circle-fill", unicode = "\ue6cd"), IconType(name = "wxicon-weixin-fill", unicode = "\ue620"), IconType(name = "wxicon-qq-fill", unicode = "\ue608"), IconType(name = "wxicon-qq-circle-fill", unicode = "\ue6b9"), IconType(name = "wxicon-moments", unicode = "\ue6a0"), IconType(name = "wxicon-moments-circel-fill", unicode = "\ue6c2"), IconType(name = "wxicon-twitter", unicode = "\ue607"), IconType(name = "wxicon-twitter-circle-fill", unicode = "\ue6cf"), IconType(name = "wxicon-flash-lamp-open", unicode = "\ue685"), IconType(name = "wxicon-flash-lamp-close", unicode = "\ue686"))
open class WxThemeType (
    @JsonNotNull
    open var primary: String,
    @JsonNotNull
    open var primaryDark: String,
    @JsonNotNull
    open var primaryDisabled: String,
    @JsonNotNull
    open var primaryLight: String,
    @JsonNotNull
    open var warning: String,
    @JsonNotNull
    open var warningDark: String,
    @JsonNotNull
    open var warningDisabled: String,
    @JsonNotNull
    open var warningLight: String,
    @JsonNotNull
    open var success: String,
    @JsonNotNull
    open var successDark: String,
    @JsonNotNull
    open var successDisabled: String,
    @JsonNotNull
    open var successLight: String,
    @JsonNotNull
    open var error: String,
    @JsonNotNull
    open var errorDark: String,
    @JsonNotNull
    open var errorDisabled: String,
    @JsonNotNull
    open var errorLight: String,
    @JsonNotNull
    open var info: String,
    @JsonNotNull
    open var infoDark: String,
    @JsonNotNull
    open var infoDisabled: String,
    @JsonNotNull
    open var infoLight: String,
    @JsonNotNull
    open var main: String,
    @JsonNotNull
    open var content: String,
    @JsonNotNull
    open var secondary: String,
    @JsonNotNull
    open var placeholder: String,
    @JsonNotNull
    open var background: String,
    @JsonNotNull
    open var disabled: String,
    @JsonNotNull
    open var border: String,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return WxThemeTypeReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class WxThemeTypeReactiveObject : WxThemeType, IUTSReactive<WxThemeType> {
    override var __v_raw: WxThemeType
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: WxThemeType, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(primary = __v_raw.primary, primaryDark = __v_raw.primaryDark, primaryDisabled = __v_raw.primaryDisabled, primaryLight = __v_raw.primaryLight, warning = __v_raw.warning, warningDark = __v_raw.warningDark, warningDisabled = __v_raw.warningDisabled, warningLight = __v_raw.warningLight, success = __v_raw.success, successDark = __v_raw.successDark, successDisabled = __v_raw.successDisabled, successLight = __v_raw.successLight, error = __v_raw.error, errorDark = __v_raw.errorDark, errorDisabled = __v_raw.errorDisabled, errorLight = __v_raw.errorLight, info = __v_raw.info, infoDark = __v_raw.infoDark, infoDisabled = __v_raw.infoDisabled, infoLight = __v_raw.infoLight, main = __v_raw.main, content = __v_raw.content, secondary = __v_raw.secondary, placeholder = __v_raw.placeholder, background = __v_raw.background, disabled = __v_raw.disabled, border = __v_raw.border) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): WxThemeTypeReactiveObject {
        return WxThemeTypeReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var primary: String
        get() {
            return _tRG(__v_raw, "primary", __v_raw.primary, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("primary")) {
                return
            }
            val oldValue = __v_raw.primary
            __v_raw.primary = value
            _tRS(__v_raw, "primary", oldValue, value)
        }
    override var primaryDark: String
        get() {
            return _tRG(__v_raw, "primaryDark", __v_raw.primaryDark, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("primaryDark")) {
                return
            }
            val oldValue = __v_raw.primaryDark
            __v_raw.primaryDark = value
            _tRS(__v_raw, "primaryDark", oldValue, value)
        }
    override var primaryDisabled: String
        get() {
            return _tRG(__v_raw, "primaryDisabled", __v_raw.primaryDisabled, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("primaryDisabled")) {
                return
            }
            val oldValue = __v_raw.primaryDisabled
            __v_raw.primaryDisabled = value
            _tRS(__v_raw, "primaryDisabled", oldValue, value)
        }
    override var primaryLight: String
        get() {
            return _tRG(__v_raw, "primaryLight", __v_raw.primaryLight, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("primaryLight")) {
                return
            }
            val oldValue = __v_raw.primaryLight
            __v_raw.primaryLight = value
            _tRS(__v_raw, "primaryLight", oldValue, value)
        }
    override var warning: String
        get() {
            return _tRG(__v_raw, "warning", __v_raw.warning, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("warning")) {
                return
            }
            val oldValue = __v_raw.warning
            __v_raw.warning = value
            _tRS(__v_raw, "warning", oldValue, value)
        }
    override var warningDark: String
        get() {
            return _tRG(__v_raw, "warningDark", __v_raw.warningDark, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("warningDark")) {
                return
            }
            val oldValue = __v_raw.warningDark
            __v_raw.warningDark = value
            _tRS(__v_raw, "warningDark", oldValue, value)
        }
    override var warningDisabled: String
        get() {
            return _tRG(__v_raw, "warningDisabled", __v_raw.warningDisabled, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("warningDisabled")) {
                return
            }
            val oldValue = __v_raw.warningDisabled
            __v_raw.warningDisabled = value
            _tRS(__v_raw, "warningDisabled", oldValue, value)
        }
    override var warningLight: String
        get() {
            return _tRG(__v_raw, "warningLight", __v_raw.warningLight, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("warningLight")) {
                return
            }
            val oldValue = __v_raw.warningLight
            __v_raw.warningLight = value
            _tRS(__v_raw, "warningLight", oldValue, value)
        }
    override var success: String
        get() {
            return _tRG(__v_raw, "success", __v_raw.success, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("success")) {
                return
            }
            val oldValue = __v_raw.success
            __v_raw.success = value
            _tRS(__v_raw, "success", oldValue, value)
        }
    override var successDark: String
        get() {
            return _tRG(__v_raw, "successDark", __v_raw.successDark, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("successDark")) {
                return
            }
            val oldValue = __v_raw.successDark
            __v_raw.successDark = value
            _tRS(__v_raw, "successDark", oldValue, value)
        }
    override var successDisabled: String
        get() {
            return _tRG(__v_raw, "successDisabled", __v_raw.successDisabled, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("successDisabled")) {
                return
            }
            val oldValue = __v_raw.successDisabled
            __v_raw.successDisabled = value
            _tRS(__v_raw, "successDisabled", oldValue, value)
        }
    override var successLight: String
        get() {
            return _tRG(__v_raw, "successLight", __v_raw.successLight, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("successLight")) {
                return
            }
            val oldValue = __v_raw.successLight
            __v_raw.successLight = value
            _tRS(__v_raw, "successLight", oldValue, value)
        }
    override var error: String
        get() {
            return _tRG(__v_raw, "error", __v_raw.error, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("error")) {
                return
            }
            val oldValue = __v_raw.error
            __v_raw.error = value
            _tRS(__v_raw, "error", oldValue, value)
        }
    override var errorDark: String
        get() {
            return _tRG(__v_raw, "errorDark", __v_raw.errorDark, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("errorDark")) {
                return
            }
            val oldValue = __v_raw.errorDark
            __v_raw.errorDark = value
            _tRS(__v_raw, "errorDark", oldValue, value)
        }
    override var errorDisabled: String
        get() {
            return _tRG(__v_raw, "errorDisabled", __v_raw.errorDisabled, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("errorDisabled")) {
                return
            }
            val oldValue = __v_raw.errorDisabled
            __v_raw.errorDisabled = value
            _tRS(__v_raw, "errorDisabled", oldValue, value)
        }
    override var errorLight: String
        get() {
            return _tRG(__v_raw, "errorLight", __v_raw.errorLight, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("errorLight")) {
                return
            }
            val oldValue = __v_raw.errorLight
            __v_raw.errorLight = value
            _tRS(__v_raw, "errorLight", oldValue, value)
        }
    override var info: String
        get() {
            return _tRG(__v_raw, "info", __v_raw.info, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("info")) {
                return
            }
            val oldValue = __v_raw.info
            __v_raw.info = value
            _tRS(__v_raw, "info", oldValue, value)
        }
    override var infoDark: String
        get() {
            return _tRG(__v_raw, "infoDark", __v_raw.infoDark, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("infoDark")) {
                return
            }
            val oldValue = __v_raw.infoDark
            __v_raw.infoDark = value
            _tRS(__v_raw, "infoDark", oldValue, value)
        }
    override var infoDisabled: String
        get() {
            return _tRG(__v_raw, "infoDisabled", __v_raw.infoDisabled, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("infoDisabled")) {
                return
            }
            val oldValue = __v_raw.infoDisabled
            __v_raw.infoDisabled = value
            _tRS(__v_raw, "infoDisabled", oldValue, value)
        }
    override var infoLight: String
        get() {
            return _tRG(__v_raw, "infoLight", __v_raw.infoLight, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("infoLight")) {
                return
            }
            val oldValue = __v_raw.infoLight
            __v_raw.infoLight = value
            _tRS(__v_raw, "infoLight", oldValue, value)
        }
    override var main: String
        get() {
            return _tRG(__v_raw, "main", __v_raw.main, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("main")) {
                return
            }
            val oldValue = __v_raw.main
            __v_raw.main = value
            _tRS(__v_raw, "main", oldValue, value)
        }
    override var content: String
        get() {
            return _tRG(__v_raw, "content", __v_raw.content, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("content")) {
                return
            }
            val oldValue = __v_raw.content
            __v_raw.content = value
            _tRS(__v_raw, "content", oldValue, value)
        }
    override var secondary: String
        get() {
            return _tRG(__v_raw, "secondary", __v_raw.secondary, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("secondary")) {
                return
            }
            val oldValue = __v_raw.secondary
            __v_raw.secondary = value
            _tRS(__v_raw, "secondary", oldValue, value)
        }
    override var placeholder: String
        get() {
            return _tRG(__v_raw, "placeholder", __v_raw.placeholder, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("placeholder")) {
                return
            }
            val oldValue = __v_raw.placeholder
            __v_raw.placeholder = value
            _tRS(__v_raw, "placeholder", oldValue, value)
        }
    override var background: String
        get() {
            return _tRG(__v_raw, "background", __v_raw.background, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("background")) {
                return
            }
            val oldValue = __v_raw.background
            __v_raw.background = value
            _tRS(__v_raw, "background", oldValue, value)
        }
    override var disabled: String
        get() {
            return _tRG(__v_raw, "disabled", __v_raw.disabled, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("disabled")) {
                return
            }
            val oldValue = __v_raw.disabled
            __v_raw.disabled = value
            _tRS(__v_raw, "disabled", oldValue, value)
        }
    override var border: String
        get() {
            return _tRG(__v_raw, "border", __v_raw.border, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("border")) {
                return
            }
            val oldValue = __v_raw.border
            __v_raw.border = value
            _tRS(__v_raw, "border", oldValue, value)
        }
}
open class WxSetThemeType (
    open var primary: String? = null,
    open var primaryDark: String? = null,
    open var primaryDisabled: String? = null,
    open var primaryLight: String? = null,
    open var warning: String? = null,
    open var warningDark: String? = null,
    open var warningDisabled: String? = null,
    open var warningLight: String? = null,
    open var success: String? = null,
    open var successDark: String? = null,
    open var successDisabled: String? = null,
    open var successLight: String? = null,
    open var error: String? = null,
    open var errorDark: String? = null,
    open var errorDisabled: String? = null,
    open var errorLight: String? = null,
    open var info: String? = null,
    open var infoDark: String? = null,
    open var infoDisabled: String? = null,
    open var infoLight: String? = null,
    open var main: String? = null,
    open var content: String? = null,
    open var secondary: String? = null,
    open var placeholder: String? = null,
    open var background: String? = null,
    open var disabled: String? = null,
    open var border: String? = null,
) : UTSObject()
open class WxSetConfigType (
    open var theme: WxSetThemeType? = null,
) : UTSObject()
val _theme = reactive(WxThemeType(primary = "#3c9cff", primaryDark = "#398ade", primaryDisabled = "#9acafc", primaryLight = "#ecf5ff", warning = "#f9ae3d", warningDark = "#f1a532", warningDisabled = "#f9d39b", warningLight = "#fdf6ec", success = "#5ac725", successDark = "#53c21d", successDisabled = "#a9e08f", successLight = "#f5fff0", error = "#f56c6c", errorDark = "#e45656", errorDisabled = "#f7b2b2", errorLight = "#fef0f0", info = "#909399", infoDark = "#767a82", infoDisabled = "#c4c6c9", infoLight = "#f4f4f5", main = "#333333", content = "#606266", secondary = "#909193", placeholder = "#c0c4cc", background = "#f3f4f6", disabled = "#c8c9cc", border = "#e7e6e4"))
open class WxConfig {
    open lateinit var theme: WxThemeType
    constructor(){
        this.theme = _theme
    }
    open fun setConfig(Config: WxSetConfigType) {
        for(key in resolveUTSKeyIterator(Config)){
            if (Config[key] == null) {
                continue
            }
            if (key == "theme") {
                var theme = Config[key]!! as WxSetThemeType
                for(themeKey in resolveUTSKeyIterator(theme)){
                    if (theme[themeKey] != null) {
                        this.setThemeColor(theme[themeKey] as String, themeKey)
                    }
                }
            }
        }
    }
    open fun setThemeColor(color: String, themeName: String = "primary") {
        when (themeName) {
            "primary" -> 
                this.theme.primary = color
            "primaryDark" -> 
                this.theme.primaryDark = color
            "primaryDisabled" -> 
                this.theme.primaryDisabled = color
            "primaryLight" -> 
                this.theme.primaryLight = color
            "warning" -> 
                this.theme.warning = color
            "warningDark" -> 
                this.theme.warningDark = color
            "warningDisabled" -> 
                this.theme.warningDisabled = color
            "warningLight" -> 
                this.theme.warningLight = color
            "success" -> 
                this.theme.success = color
            "successDark" -> 
                this.theme.successDark = color
            "successDisabled" -> 
                this.theme.successDisabled = color
            "successLight" -> 
                this.theme.successLight = color
            "error" -> 
                this.theme.error = color
            "errorDark" -> 
                this.theme.errorDark = color
            "errorDisabled" -> 
                this.theme.errorDisabled = color
            "errorLight" -> 
                this.theme.errorLight = color
            "info" -> 
                this.theme.info = color
            "infoDark" -> 
                this.theme.infoDark = color
            "infoDisabled" -> 
                this.theme.infoDisabled = color
            "infoLight" -> 
                this.theme.infoLight = color
            "main" -> 
                this.theme.main = color
            "content" -> 
                this.theme.content = color
            "secondary" -> 
                this.theme.secondary = color
            "placeholder" -> 
                this.theme.placeholder = color
            "background" -> 
                this.theme.background = color
            "disabled" -> 
                this.theme.disabled = color
            "border" -> 
                this.theme.border = color
        }
    }
}
val wxConfig = WxConfig()
val GenUniModulesWxUiComponentsWxIconWxIconClass = CreateVueComponent(GenUniModulesWxUiComponentsWxIconWxIcon::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenUniModulesWxUiComponentsWxIconWxIcon.inheritAttrs, inject = GenUniModulesWxUiComponentsWxIconWxIcon.inject, props = GenUniModulesWxUiComponentsWxIconWxIcon.props, propsNeedCastKeys = GenUniModulesWxUiComponentsWxIconWxIcon.propsNeedCastKeys, emits = GenUniModulesWxUiComponentsWxIconWxIcon.emits, components = GenUniModulesWxUiComponentsWxIconWxIcon.components, styles = GenUniModulesWxUiComponentsWxIconWxIcon.styles)
}
, fun(instance, renderer): GenUniModulesWxUiComponentsWxIconWxIcon {
    return GenUniModulesWxUiComponentsWxIconWxIcon(instance)
}
)
val GenUniModulesWxUiComponentsWxTransitionWxTransitionClass = CreateVueComponent(GenUniModulesWxUiComponentsWxTransitionWxTransition::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesWxUiComponentsWxTransitionWxTransition.name, inheritAttrs = GenUniModulesWxUiComponentsWxTransitionWxTransition.inheritAttrs, inject = GenUniModulesWxUiComponentsWxTransitionWxTransition.inject, props = GenUniModulesWxUiComponentsWxTransitionWxTransition.props, propsNeedCastKeys = GenUniModulesWxUiComponentsWxTransitionWxTransition.propsNeedCastKeys, emits = GenUniModulesWxUiComponentsWxTransitionWxTransition.emits, components = GenUniModulesWxUiComponentsWxTransitionWxTransition.components, styles = GenUniModulesWxUiComponentsWxTransitionWxTransition.styles)
}
, fun(instance, renderer): GenUniModulesWxUiComponentsWxTransitionWxTransition {
    return GenUniModulesWxUiComponentsWxTransitionWxTransition(instance)
}
)
val GenUniModulesWxUiComponentsWxPopupWxPopupClass = CreateVueComponent(GenUniModulesWxUiComponentsWxPopupWxPopup::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenUniModulesWxUiComponentsWxPopupWxPopup.inheritAttrs, inject = GenUniModulesWxUiComponentsWxPopupWxPopup.inject, props = GenUniModulesWxUiComponentsWxPopupWxPopup.props, propsNeedCastKeys = GenUniModulesWxUiComponentsWxPopupWxPopup.propsNeedCastKeys, emits = GenUniModulesWxUiComponentsWxPopupWxPopup.emits, components = GenUniModulesWxUiComponentsWxPopupWxPopup.components, styles = GenUniModulesWxUiComponentsWxPopupWxPopup.styles)
}
, fun(instance, renderer): GenUniModulesWxUiComponentsWxPopupWxPopup {
    return GenUniModulesWxUiComponentsWxPopupWxPopup(instance)
}
)
val GenComponentsXRemarkwindowClass = CreateVueComponent(GenComponentsXRemarkwindow::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXRemarkwindow.inheritAttrs, inject = GenComponentsXRemarkwindow.inject, props = GenComponentsXRemarkwindow.props, propsNeedCastKeys = GenComponentsXRemarkwindow.propsNeedCastKeys, emits = GenComponentsXRemarkwindow.emits, components = GenComponentsXRemarkwindow.components, styles = GenComponentsXRemarkwindow.styles, setup = fun(props: ComponentPublicInstance, ctx: SetupContext): Any? {
        return GenComponentsXRemarkwindow.setup(props as GenComponentsXRemarkwindow, ctx)
    }
    )
}
, fun(instance, renderer): GenComponentsXRemarkwindow {
    return GenComponentsXRemarkwindow(instance)
}
)
val GenComponentsXOrderActionClass = CreateVueComponent(GenComponentsXOrderAction::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXOrderAction.inheritAttrs, inject = GenComponentsXOrderAction.inject, props = GenComponentsXOrderAction.props, propsNeedCastKeys = GenComponentsXOrderAction.propsNeedCastKeys, emits = GenComponentsXOrderAction.emits, components = GenComponentsXOrderAction.components, styles = GenComponentsXOrderAction.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXOrderAction.setup(props as GenComponentsXOrderAction)
    }
    )
}
, fun(instance, renderer): GenComponentsXOrderAction {
    return GenComponentsXOrderAction(instance)
}
)
val GenUniModulesTmxUiComponentsTmxPickerDateTmxPickerDateClass = CreateVueComponent(GenUniModulesTmxUiComponentsTmxPickerDateTmxPickerDate::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesTmxUiComponentsTmxPickerDateTmxPickerDate.name, inheritAttrs = GenUniModulesTmxUiComponentsTmxPickerDateTmxPickerDate.inheritAttrs, inject = GenUniModulesTmxUiComponentsTmxPickerDateTmxPickerDate.inject, props = GenUniModulesTmxUiComponentsTmxPickerDateTmxPickerDate.props, propsNeedCastKeys = GenUniModulesTmxUiComponentsTmxPickerDateTmxPickerDate.propsNeedCastKeys, emits = GenUniModulesTmxUiComponentsTmxPickerDateTmxPickerDate.emits, components = GenUniModulesTmxUiComponentsTmxPickerDateTmxPickerDate.components, styles = GenUniModulesTmxUiComponentsTmxPickerDateTmxPickerDate.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesTmxUiComponentsTmxPickerDateTmxPickerDate.setup(props as GenUniModulesTmxUiComponentsTmxPickerDateTmxPickerDate)
    }
    )
}
, fun(instance, renderer): GenUniModulesTmxUiComponentsTmxPickerDateTmxPickerDate {
    return GenUniModulesTmxUiComponentsTmxPickerDateTmxPickerDate(instance)
}
)
val GenComponentsXChoosedateClass = CreateVueComponent(GenComponentsXChoosedate::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXChoosedate.inheritAttrs, inject = GenComponentsXChoosedate.inject, props = GenComponentsXChoosedate.props, propsNeedCastKeys = GenComponentsXChoosedate.propsNeedCastKeys, emits = GenComponentsXChoosedate.emits, components = GenComponentsXChoosedate.components, styles = GenComponentsXChoosedate.styles, setup = fun(props: ComponentPublicInstance, ctx: SetupContext): Any? {
        return GenComponentsXChoosedate.setup(props as GenComponentsXChoosedate, ctx)
    }
    )
}
, fun(instance, renderer): GenComponentsXChoosedate {
    return GenComponentsXChoosedate(instance)
}
)
open class instoragegoodsinfo (
    @JsonNotNull
    open var goodsinfo: UTSJSONObject,
    @JsonNotNull
    open var number: Number,
    @JsonNotNull
    open var id: Number,
    open var remark: String? = null,
    @JsonNotNull
    open var price: Number,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return instoragegoodsinfoReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class instoragegoodsinfoReactiveObject : instoragegoodsinfo, IUTSReactive<instoragegoodsinfo> {
    override var __v_raw: instoragegoodsinfo
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: instoragegoodsinfo, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(goodsinfo = __v_raw.goodsinfo, number = __v_raw.number, id = __v_raw.id, remark = __v_raw.remark, price = __v_raw.price) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): instoragegoodsinfoReactiveObject {
        return instoragegoodsinfoReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var goodsinfo: UTSJSONObject
        get() {
            return _tRG(__v_raw, "goodsinfo", __v_raw.goodsinfo, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("goodsinfo")) {
                return
            }
            val oldValue = __v_raw.goodsinfo
            __v_raw.goodsinfo = value
            _tRS(__v_raw, "goodsinfo", oldValue, value)
        }
    override var number: Number
        get() {
            return _tRG(__v_raw, "number", __v_raw.number, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("number")) {
                return
            }
            val oldValue = __v_raw.number
            __v_raw.number = value
            _tRS(__v_raw, "number", oldValue, value)
        }
    override var id: Number
        get() {
            return _tRG(__v_raw, "id", __v_raw.id, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("id")) {
                return
            }
            val oldValue = __v_raw.id
            __v_raw.id = value
            _tRS(__v_raw, "id", oldValue, value)
        }
    override var remark: String?
        get() {
            return _tRG(__v_raw, "remark", __v_raw.remark, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("remark")) {
                return
            }
            val oldValue = __v_raw.remark
            __v_raw.remark = value
            _tRS(__v_raw, "remark", oldValue, value)
        }
    override var price: Number
        get() {
            return _tRG(__v_raw, "price", __v_raw.price, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("price")) {
                return
            }
            val oldValue = __v_raw.price
            __v_raw.price = value
            _tRS(__v_raw, "price", oldValue, value)
        }
}
val GenPagesWarehouseInstorageAddinstorageClass = CreateVueComponent(GenPagesWarehouseInstorageAddinstorage::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesWarehouseInstorageAddinstorage.inheritAttrs, inject = GenPagesWarehouseInstorageAddinstorage.inject, props = GenPagesWarehouseInstorageAddinstorage.props, propsNeedCastKeys = GenPagesWarehouseInstorageAddinstorage.propsNeedCastKeys, emits = GenPagesWarehouseInstorageAddinstorage.emits, components = GenPagesWarehouseInstorageAddinstorage.components, styles = GenPagesWarehouseInstorageAddinstorage.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesWarehouseInstorageAddinstorage.setup(props as GenPagesWarehouseInstorageAddinstorage)
    }
    )
}
, fun(instance, renderer): GenPagesWarehouseInstorageAddinstorage {
    return GenPagesWarehouseInstorageAddinstorage(instance, renderer)
}
)
val GenPagesCommonChoosecityClass = CreateVueComponent(GenPagesCommonChoosecity::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesCommonChoosecity.inheritAttrs, inject = GenPagesCommonChoosecity.inject, props = GenPagesCommonChoosecity.props, propsNeedCastKeys = GenPagesCommonChoosecity.propsNeedCastKeys, emits = GenPagesCommonChoosecity.emits, components = GenPagesCommonChoosecity.components, styles = GenPagesCommonChoosecity.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesCommonChoosecity.setup(props as GenPagesCommonChoosecity)
    }
    )
}
, fun(instance, renderer): GenPagesCommonChoosecity {
    return GenPagesCommonChoosecity(instance, renderer)
}
)
val GenComponentsXChoosetitleClass = CreateVueComponent(GenComponentsXChoosetitle::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXChoosetitle.inheritAttrs, inject = GenComponentsXChoosetitle.inject, props = GenComponentsXChoosetitle.props, propsNeedCastKeys = GenComponentsXChoosetitle.propsNeedCastKeys, emits = GenComponentsXChoosetitle.emits, components = GenComponentsXChoosetitle.components, styles = GenComponentsXChoosetitle.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXChoosetitle.setup(props as GenComponentsXChoosetitle)
    }
    )
}
, fun(instance, renderer): GenComponentsXChoosetitle {
    return GenComponentsXChoosetitle(instance)
}
)
val GenComponentsXSearchboxClass = CreateVueComponent(GenComponentsXSearchbox::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXSearchbox.inheritAttrs, inject = GenComponentsXSearchbox.inject, props = GenComponentsXSearchbox.props, propsNeedCastKeys = GenComponentsXSearchbox.propsNeedCastKeys, emits = GenComponentsXSearchbox.emits, components = GenComponentsXSearchbox.components, styles = GenComponentsXSearchbox.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXSearchbox.setup(props as GenComponentsXSearchbox)
    }
    )
}
, fun(instance, renderer): GenComponentsXSearchbox {
    return GenComponentsXSearchbox(instance)
}
)
val GenComponentsXPurchaseOrderClass = CreateVueComponent(GenComponentsXPurchaseOrder::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXPurchaseOrder.inheritAttrs, inject = GenComponentsXPurchaseOrder.inject, props = GenComponentsXPurchaseOrder.props, propsNeedCastKeys = GenComponentsXPurchaseOrder.propsNeedCastKeys, emits = GenComponentsXPurchaseOrder.emits, components = GenComponentsXPurchaseOrder.components, styles = GenComponentsXPurchaseOrder.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXPurchaseOrder.setup(props as GenComponentsXPurchaseOrder)
    }
    )
}
, fun(instance, renderer): GenComponentsXPurchaseOrder {
    return GenComponentsXPurchaseOrder(instance)
}
)
val GenComponentsXEmptyClass = CreateVueComponent(GenComponentsXEmpty::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXEmpty.inheritAttrs, inject = GenComponentsXEmpty.inject, props = GenComponentsXEmpty.props, propsNeedCastKeys = GenComponentsXEmpty.propsNeedCastKeys, emits = GenComponentsXEmpty.emits, components = GenComponentsXEmpty.components, styles = GenComponentsXEmpty.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXEmpty.setup(props as GenComponentsXEmpty)
    }
    )
}
, fun(instance, renderer): GenComponentsXEmpty {
    return GenComponentsXEmpty(instance)
}
)
val GenComponentsXShowcodeClass = CreateVueComponent(GenComponentsXShowcode::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXShowcode.inheritAttrs, inject = GenComponentsXShowcode.inject, props = GenComponentsXShowcode.props, propsNeedCastKeys = GenComponentsXShowcode.propsNeedCastKeys, emits = GenComponentsXShowcode.emits, components = GenComponentsXShowcode.components, styles = GenComponentsXShowcode.styles, setup = fun(props: ComponentPublicInstance, ctx: SetupContext): Any? {
        return GenComponentsXShowcode.setup(props as GenComponentsXShowcode, ctx)
    }
    )
}
, fun(instance, renderer): GenComponentsXShowcode {
    return GenComponentsXShowcode(instance)
}
)
val GenPagesCommonChoosepurchaseorderClass = CreateVueComponent(GenPagesCommonChoosepurchaseorder::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesCommonChoosepurchaseorder.inheritAttrs, inject = GenPagesCommonChoosepurchaseorder.inject, props = GenPagesCommonChoosepurchaseorder.props, propsNeedCastKeys = GenPagesCommonChoosepurchaseorder.propsNeedCastKeys, emits = GenPagesCommonChoosepurchaseorder.emits, components = GenPagesCommonChoosepurchaseorder.components, styles = GenPagesCommonChoosepurchaseorder.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesCommonChoosepurchaseorder.setup(props as GenPagesCommonChoosepurchaseorder)
    }
    )
}
, fun(instance, renderer): GenPagesCommonChoosepurchaseorder {
    return GenPagesCommonChoosepurchaseorder(instance, renderer)
}
)
val GenPagesCommonChooseareaClass = CreateVueComponent(GenPagesCommonChoosearea::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesCommonChoosearea.inheritAttrs, inject = GenPagesCommonChoosearea.inject, props = GenPagesCommonChoosearea.props, propsNeedCastKeys = GenPagesCommonChoosearea.propsNeedCastKeys, emits = GenPagesCommonChoosearea.emits, components = GenPagesCommonChoosearea.components, styles = GenPagesCommonChoosearea.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesCommonChoosearea.setup(props as GenPagesCommonChoosearea)
    }
    )
}
, fun(instance, renderer): GenPagesCommonChoosearea {
    return GenPagesCommonChoosearea(instance, renderer)
}
)
val GenUniModulesFirstuiUvueComponentsFuiCheckboxFuiCheckboxClass = CreateVueComponent(GenUniModulesFirstuiUvueComponentsFuiCheckboxFuiCheckbox::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesFirstuiUvueComponentsFuiCheckboxFuiCheckbox.name, inheritAttrs = GenUniModulesFirstuiUvueComponentsFuiCheckboxFuiCheckbox.inheritAttrs, inject = GenUniModulesFirstuiUvueComponentsFuiCheckboxFuiCheckbox.inject, props = GenUniModulesFirstuiUvueComponentsFuiCheckboxFuiCheckbox.props, propsNeedCastKeys = GenUniModulesFirstuiUvueComponentsFuiCheckboxFuiCheckbox.propsNeedCastKeys, emits = GenUniModulesFirstuiUvueComponentsFuiCheckboxFuiCheckbox.emits, components = GenUniModulesFirstuiUvueComponentsFuiCheckboxFuiCheckbox.components, styles = GenUniModulesFirstuiUvueComponentsFuiCheckboxFuiCheckbox.styles)
}
, fun(instance, renderer): GenUniModulesFirstuiUvueComponentsFuiCheckboxFuiCheckbox {
    return GenUniModulesFirstuiUvueComponentsFuiCheckboxFuiCheckbox(instance)
}
)
val GenComponentsXLongpressClass = CreateVueComponent(GenComponentsXLongpress::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXLongpress.inheritAttrs, inject = GenComponentsXLongpress.inject, props = GenComponentsXLongpress.props, propsNeedCastKeys = GenComponentsXLongpress.propsNeedCastKeys, emits = GenComponentsXLongpress.emits, components = GenComponentsXLongpress.components, styles = GenComponentsXLongpress.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXLongpress.setup(props as GenComponentsXLongpress)
    }
    )
}
, fun(instance, renderer): GenComponentsXLongpress {
    return GenComponentsXLongpress(instance)
}
)
val GenUniModulesFirstuiUvueComponentsFuiCheckboxGroupFuiCheckboxGroupClass = CreateVueComponent(GenUniModulesFirstuiUvueComponentsFuiCheckboxGroupFuiCheckboxGroup::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesFirstuiUvueComponentsFuiCheckboxGroupFuiCheckboxGroup.name, inheritAttrs = GenUniModulesFirstuiUvueComponentsFuiCheckboxGroupFuiCheckboxGroup.inheritAttrs, inject = GenUniModulesFirstuiUvueComponentsFuiCheckboxGroupFuiCheckboxGroup.inject, props = GenUniModulesFirstuiUvueComponentsFuiCheckboxGroupFuiCheckboxGroup.props, propsNeedCastKeys = GenUniModulesFirstuiUvueComponentsFuiCheckboxGroupFuiCheckboxGroup.propsNeedCastKeys, emits = GenUniModulesFirstuiUvueComponentsFuiCheckboxGroupFuiCheckboxGroup.emits, components = GenUniModulesFirstuiUvueComponentsFuiCheckboxGroupFuiCheckboxGroup.components, styles = GenUniModulesFirstuiUvueComponentsFuiCheckboxGroupFuiCheckboxGroup.styles)
}
, fun(instance, renderer): GenUniModulesFirstuiUvueComponentsFuiCheckboxGroupFuiCheckboxGroup {
    return GenUniModulesFirstuiUvueComponentsFuiCheckboxGroupFuiCheckboxGroup(instance)
}
)
val GenComponentsXAiorderClass = CreateVueComponent(GenComponentsXAiorder::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXAiorder.inheritAttrs, inject = GenComponentsXAiorder.inject, props = GenComponentsXAiorder.props, propsNeedCastKeys = GenComponentsXAiorder.propsNeedCastKeys, emits = GenComponentsXAiorder.emits, components = GenComponentsXAiorder.components, styles = GenComponentsXAiorder.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXAiorder.setup(props as GenComponentsXAiorder)
    }
    )
}
, fun(instance, renderer): GenComponentsXAiorder {
    return GenComponentsXAiorder(instance)
}
)
val GenComponentsXShaixuawindowClass = CreateVueComponent(GenComponentsXShaixuawindow::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXShaixuawindow.inheritAttrs, inject = GenComponentsXShaixuawindow.inject, props = GenComponentsXShaixuawindow.props, propsNeedCastKeys = GenComponentsXShaixuawindow.propsNeedCastKeys, emits = GenComponentsXShaixuawindow.emits, components = GenComponentsXShaixuawindow.components, styles = GenComponentsXShaixuawindow.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXShaixuawindow.setup(props as GenComponentsXShaixuawindow)
    }
    )
}
, fun(instance, renderer): GenComponentsXShaixuawindow {
    return GenComponentsXShaixuawindow(instance)
}
)
val GenPagesWarehousePurchasePurchaseClass = CreateVueComponent(GenPagesWarehousePurchasePurchase::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesWarehousePurchasePurchase.inheritAttrs, inject = GenPagesWarehousePurchasePurchase.inject, props = GenPagesWarehousePurchasePurchase.props, propsNeedCastKeys = GenPagesWarehousePurchasePurchase.propsNeedCastKeys, emits = GenPagesWarehousePurchasePurchase.emits, components = GenPagesWarehousePurchasePurchase.components, styles = GenPagesWarehousePurchasePurchase.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesWarehousePurchasePurchase.setup(props as GenPagesWarehousePurchasePurchase)
    }
    )
}
, fun(instance, renderer): GenPagesWarehousePurchasePurchase {
    return GenPagesWarehousePurchasePurchase(instance, renderer)
}
)
val GenComponentsXNaviteorderClass = CreateVueComponent(GenComponentsXNaviteorder::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXNaviteorder.inheritAttrs, inject = GenComponentsXNaviteorder.inject, props = GenComponentsXNaviteorder.props, propsNeedCastKeys = GenComponentsXNaviteorder.propsNeedCastKeys, emits = GenComponentsXNaviteorder.emits, components = GenComponentsXNaviteorder.components, styles = GenComponentsXNaviteorder.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXNaviteorder.setup(props as GenComponentsXNaviteorder)
    }
    )
}
, fun(instance, renderer): GenComponentsXNaviteorder {
    return GenComponentsXNaviteorder(instance)
}
)
open class purchaseinfo (
    @JsonNotNull
    open var goodsinfo: UTSJSONObject,
    @JsonNotNull
    open var stock: Number,
    @JsonNotNull
    open var number: Number,
    @JsonNotNull
    open var id: Number,
    open var remark: String? = null,
    open var total: Number? = null,
    open var total_str: String? = null,
    open var price: Number? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return purchaseinfoReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class purchaseinfoReactiveObject : purchaseinfo, IUTSReactive<purchaseinfo> {
    override var __v_raw: purchaseinfo
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: purchaseinfo, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(goodsinfo = __v_raw.goodsinfo, stock = __v_raw.stock, number = __v_raw.number, id = __v_raw.id, remark = __v_raw.remark, total = __v_raw.total, total_str = __v_raw.total_str, price = __v_raw.price) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): purchaseinfoReactiveObject {
        return purchaseinfoReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var goodsinfo: UTSJSONObject
        get() {
            return _tRG(__v_raw, "goodsinfo", __v_raw.goodsinfo, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("goodsinfo")) {
                return
            }
            val oldValue = __v_raw.goodsinfo
            __v_raw.goodsinfo = value
            _tRS(__v_raw, "goodsinfo", oldValue, value)
        }
    override var stock: Number
        get() {
            return _tRG(__v_raw, "stock", __v_raw.stock, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("stock")) {
                return
            }
            val oldValue = __v_raw.stock
            __v_raw.stock = value
            _tRS(__v_raw, "stock", oldValue, value)
        }
    override var number: Number
        get() {
            return _tRG(__v_raw, "number", __v_raw.number, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("number")) {
                return
            }
            val oldValue = __v_raw.number
            __v_raw.number = value
            _tRS(__v_raw, "number", oldValue, value)
        }
    override var id: Number
        get() {
            return _tRG(__v_raw, "id", __v_raw.id, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("id")) {
                return
            }
            val oldValue = __v_raw.id
            __v_raw.id = value
            _tRS(__v_raw, "id", oldValue, value)
        }
    override var remark: String?
        get() {
            return _tRG(__v_raw, "remark", __v_raw.remark, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("remark")) {
                return
            }
            val oldValue = __v_raw.remark
            __v_raw.remark = value
            _tRS(__v_raw, "remark", oldValue, value)
        }
    override var total: Number?
        get() {
            return _tRG(__v_raw, "total", __v_raw.total, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("total")) {
                return
            }
            val oldValue = __v_raw.total
            __v_raw.total = value
            _tRS(__v_raw, "total", oldValue, value)
        }
    override var total_str: String?
        get() {
            return _tRG(__v_raw, "total_str", __v_raw.total_str, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("total_str")) {
                return
            }
            val oldValue = __v_raw.total_str
            __v_raw.total_str = value
            _tRS(__v_raw, "total_str", oldValue, value)
        }
    override var price: Number?
        get() {
            return _tRG(__v_raw, "price", __v_raw.price, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("price")) {
                return
            }
            val oldValue = __v_raw.price
            __v_raw.price = value
            _tRS(__v_raw, "price", oldValue, value)
        }
}
val GenPagesWarehousePurchaseEditpurchaseClass = CreateVueComponent(GenPagesWarehousePurchaseEditpurchase::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesWarehousePurchaseEditpurchase.inheritAttrs, inject = GenPagesWarehousePurchaseEditpurchase.inject, props = GenPagesWarehousePurchaseEditpurchase.props, propsNeedCastKeys = GenPagesWarehousePurchaseEditpurchase.propsNeedCastKeys, emits = GenPagesWarehousePurchaseEditpurchase.emits, components = GenPagesWarehousePurchaseEditpurchase.components, styles = GenPagesWarehousePurchaseEditpurchase.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesWarehousePurchaseEditpurchase.setup(props as GenPagesWarehousePurchaseEditpurchase)
    }
    )
}
, fun(instance, renderer): GenPagesWarehousePurchaseEditpurchase {
    return GenPagesWarehousePurchaseEditpurchase(instance, renderer)
}
)
val GenComponentsXGoodsClass = CreateVueComponent(GenComponentsXGoods::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXGoods.inheritAttrs, inject = GenComponentsXGoods.inject, props = GenComponentsXGoods.props, propsNeedCastKeys = GenComponentsXGoods.propsNeedCastKeys, emits = GenComponentsXGoods.emits, components = GenComponentsXGoods.components, styles = GenComponentsXGoods.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXGoods.setup(props as GenComponentsXGoods)
    }
    )
}
, fun(instance, renderer): GenComponentsXGoods {
    return GenComponentsXGoods(instance)
}
)
val GenComponentsXNumberwindowClass = CreateVueComponent(GenComponentsXNumberwindow::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXNumberwindow.inheritAttrs, inject = GenComponentsXNumberwindow.inject, props = GenComponentsXNumberwindow.props, propsNeedCastKeys = GenComponentsXNumberwindow.propsNeedCastKeys, emits = GenComponentsXNumberwindow.emits, components = GenComponentsXNumberwindow.components, styles = GenComponentsXNumberwindow.styles, setup = fun(props: ComponentPublicInstance, ctx: SetupContext): Any? {
        return GenComponentsXNumberwindow.setup(props as GenComponentsXNumberwindow, ctx)
    }
    )
}
, fun(instance, renderer): GenComponentsXNumberwindow {
    return GenComponentsXNumberwindow(instance)
}
)
val GenComponentsXNumberstepClass = CreateVueComponent(GenComponentsXNumberstep::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXNumberstep.inheritAttrs, inject = GenComponentsXNumberstep.inject, props = GenComponentsXNumberstep.props, propsNeedCastKeys = GenComponentsXNumberstep.propsNeedCastKeys, emits = GenComponentsXNumberstep.emits, components = GenComponentsXNumberstep.components, styles = GenComponentsXNumberstep.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXNumberstep.setup(props as GenComponentsXNumberstep)
    }
    )
}
, fun(instance, renderer): GenComponentsXNumberstep {
    return GenComponentsXNumberstep(instance)
}
)
val GenComponentsXSelectedGoodsClass = CreateVueComponent(GenComponentsXSelectedGoods::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXSelectedGoods.inheritAttrs, inject = GenComponentsXSelectedGoods.inject, props = GenComponentsXSelectedGoods.props, propsNeedCastKeys = GenComponentsXSelectedGoods.propsNeedCastKeys, emits = GenComponentsXSelectedGoods.emits, components = GenComponentsXSelectedGoods.components, styles = GenComponentsXSelectedGoods.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXSelectedGoods.setup(props as GenComponentsXSelectedGoods)
    }
    )
}
, fun(instance, renderer): GenComponentsXSelectedGoods {
    return GenComponentsXSelectedGoods(instance)
}
)
val GenPagesCommonChoosegoodsClass = CreateVueComponent(GenPagesCommonChoosegoods::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesCommonChoosegoods.inheritAttrs, inject = GenPagesCommonChoosegoods.inject, props = GenPagesCommonChoosegoods.props, propsNeedCastKeys = GenPagesCommonChoosegoods.propsNeedCastKeys, emits = GenPagesCommonChoosegoods.emits, components = GenPagesCommonChoosegoods.components, styles = GenPagesCommonChoosegoods.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesCommonChoosegoods.setup(props as GenPagesCommonChoosegoods)
    }
    )
}
, fun(instance, renderer): GenPagesCommonChoosegoods {
    return GenPagesCommonChoosegoods(instance, renderer)
}
)
open class previewMedia__1 (
    @JsonNotNull
    open var type: String,
    @JsonNotNull
    open var uri: String,
) : UTSObject()
open class previewOptions__1 (
    @JsonNotNull
    open var list: UTSArray<previewMedia__1>,
    open var index: Number? = null,
) : UTSObject()
open class bottomMenu__1 (
    @JsonNotNull
    open var key: String,
    @JsonNotNull
    open var name: String,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return bottomMenu__1ReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class bottomMenu__1ReactiveObject : bottomMenu__1, IUTSReactive<bottomMenu__1> {
    override var __v_raw: bottomMenu__1
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: bottomMenu__1, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(key = __v_raw.key, name = __v_raw.name) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): bottomMenu__1ReactiveObject {
        return bottomMenu__1ReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var key: String
        get() {
            return _tRG(__v_raw, "key", __v_raw.key, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("key")) {
                return
            }
            val oldValue = __v_raw.key
            __v_raw.key = value
            _tRS(__v_raw, "key", oldValue, value)
        }
    override var name: String
        get() {
            return _tRG(__v_raw, "name", __v_raw.name, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("name")) {
                return
            }
            val oldValue = __v_raw.name
            __v_raw.name = value
            _tRS(__v_raw, "name", oldValue, value)
        }
}
typealias PreviewImage = (options: previewOptions__1) -> Unit
val previewImage__1: PreviewImage = fun(options: previewOptions__1): Unit {
    var url = "/uni_modules/iboxs-choosemedia/pages/preview"
    var list = options.list
    var json = JSON.stringify(list)
    json = encodeURIComponent(json) as String
    uni_navigateTo(NavigateToOptions(url = url + "?list=" + json + "&index=" + options.index, animationType = "slide-in-bottom"))
}
val default__12: UTSJSONObject = _uO("checkbox" to "\ue637", "checkboxoutlineblank" to "\ue63c", "jiantou_xiangzuo" to "\ueb09", "gundongtiao" to "\ue62d", "gundongtiao2" to "\ueb0a", "close" to "\ue6d5", "youxiajiao" to "\ue634", "xiangxia" to "\ue66f", "xiangshang" to "\ue600", "gougou" to "\ue651", "zhaoxiangji" to "\ue601")
val GenUniModulesIboxsChoosemediaComponentsXuIconfontClass = CreateVueComponent(GenUniModulesIboxsChoosemediaComponentsXuIconfont::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesIboxsChoosemediaComponentsXuIconfont.name, inheritAttrs = GenUniModulesIboxsChoosemediaComponentsXuIconfont.inheritAttrs, inject = GenUniModulesIboxsChoosemediaComponentsXuIconfont.inject, props = GenUniModulesIboxsChoosemediaComponentsXuIconfont.props, propsNeedCastKeys = GenUniModulesIboxsChoosemediaComponentsXuIconfont.propsNeedCastKeys, emits = GenUniModulesIboxsChoosemediaComponentsXuIconfont.emits, components = GenUniModulesIboxsChoosemediaComponentsXuIconfont.components, styles = GenUniModulesIboxsChoosemediaComponentsXuIconfont.styles)
}
, fun(instance, renderer): GenUniModulesIboxsChoosemediaComponentsXuIconfont {
    return GenUniModulesIboxsChoosemediaComponentsXuIconfont(instance)
}
)
val GenUniModulesIboxsChoosemediaComponentsXuPopupClass = CreateVueComponent(GenUniModulesIboxsChoosemediaComponentsXuPopup::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenUniModulesIboxsChoosemediaComponentsXuPopup.inheritAttrs, inject = GenUniModulesIboxsChoosemediaComponentsXuPopup.inject, props = GenUniModulesIboxsChoosemediaComponentsXuPopup.props, propsNeedCastKeys = GenUniModulesIboxsChoosemediaComponentsXuPopup.propsNeedCastKeys, emits = GenUniModulesIboxsChoosemediaComponentsXuPopup.emits, components = GenUniModulesIboxsChoosemediaComponentsXuPopup.components, styles = GenUniModulesIboxsChoosemediaComponentsXuPopup.styles)
}
, fun(instance, renderer): GenUniModulesIboxsChoosemediaComponentsXuPopup {
    return GenUniModulesIboxsChoosemediaComponentsXuPopup(instance)
}
)
open class xCheckboxChangeParam (
    @JsonNotNull
    open var checked: Boolean = false,
    @JsonNotNull
    open var value: String,
) : UTSObject()
val GenUniModulesIboxsChoosemediaComponentsXuCheckboxClass = CreateVueComponent(GenUniModulesIboxsChoosemediaComponentsXuCheckbox::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesIboxsChoosemediaComponentsXuCheckbox.name, inheritAttrs = GenUniModulesIboxsChoosemediaComponentsXuCheckbox.inheritAttrs, inject = GenUniModulesIboxsChoosemediaComponentsXuCheckbox.inject, props = GenUniModulesIboxsChoosemediaComponentsXuCheckbox.props, propsNeedCastKeys = GenUniModulesIboxsChoosemediaComponentsXuCheckbox.propsNeedCastKeys, emits = GenUniModulesIboxsChoosemediaComponentsXuCheckbox.emits, components = GenUniModulesIboxsChoosemediaComponentsXuCheckbox.components, styles = GenUniModulesIboxsChoosemediaComponentsXuCheckbox.styles)
}
, fun(instance, renderer): GenUniModulesIboxsChoosemediaComponentsXuCheckbox {
    return GenUniModulesIboxsChoosemediaComponentsXuCheckbox(instance)
}
)
val GenUniModulesIboxsChoosemediaComponentsXuCheckboxGroupClass = CreateVueComponent(GenUniModulesIboxsChoosemediaComponentsXuCheckboxGroup::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesIboxsChoosemediaComponentsXuCheckboxGroup.name, inheritAttrs = GenUniModulesIboxsChoosemediaComponentsXuCheckboxGroup.inheritAttrs, inject = GenUniModulesIboxsChoosemediaComponentsXuCheckboxGroup.inject, props = GenUniModulesIboxsChoosemediaComponentsXuCheckboxGroup.props, propsNeedCastKeys = GenUniModulesIboxsChoosemediaComponentsXuCheckboxGroup.propsNeedCastKeys, emits = GenUniModulesIboxsChoosemediaComponentsXuCheckboxGroup.emits, components = GenUniModulesIboxsChoosemediaComponentsXuCheckboxGroup.components, styles = GenUniModulesIboxsChoosemediaComponentsXuCheckboxGroup.styles)
}
, fun(instance, renderer): GenUniModulesIboxsChoosemediaComponentsXuCheckboxGroup {
    return GenUniModulesIboxsChoosemediaComponentsXuCheckboxGroup(instance)
}
)
open class xCheckboxChangeParam__1 (
    @JsonNotNull
    open var checked: Boolean = false,
    @JsonNotNull
    open var value: String,
) : UTSObject()
val GenUniModulesIboxsChoosemediaComponentsXuCheckboxImageClass = CreateVueComponent(GenUniModulesIboxsChoosemediaComponentsXuCheckboxImage::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesIboxsChoosemediaComponentsXuCheckboxImage.name, inheritAttrs = GenUniModulesIboxsChoosemediaComponentsXuCheckboxImage.inheritAttrs, inject = GenUniModulesIboxsChoosemediaComponentsXuCheckboxImage.inject, props = GenUniModulesIboxsChoosemediaComponentsXuCheckboxImage.props, propsNeedCastKeys = GenUniModulesIboxsChoosemediaComponentsXuCheckboxImage.propsNeedCastKeys, emits = GenUniModulesIboxsChoosemediaComponentsXuCheckboxImage.emits, components = GenUniModulesIboxsChoosemediaComponentsXuCheckboxImage.components, styles = GenUniModulesIboxsChoosemediaComponentsXuCheckboxImage.styles)
}
, fun(instance, renderer): GenUniModulesIboxsChoosemediaComponentsXuCheckboxImage {
    return GenUniModulesIboxsChoosemediaComponentsXuCheckboxImage(instance)
}
)
open class media (
    open var file: String? = null,
    @JsonNotNull
    open var type: String,
    open var id: Number? = null,
    @JsonNotNull
    open var uri: String,
    open var folder: String? = null,
    open var folderID: Number? = null,
    open var duration: Number? = null,
    open var ext: String? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return mediaReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class mediaReactiveObject : media, IUTSReactive<media> {
    override var __v_raw: media
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: media, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(file = __v_raw.file, type = __v_raw.type, id = __v_raw.id, uri = __v_raw.uri, folder = __v_raw.folder, folderID = __v_raw.folderID, duration = __v_raw.duration, ext = __v_raw.ext) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): mediaReactiveObject {
        return mediaReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var file: String?
        get() {
            return _tRG(__v_raw, "file", __v_raw.file, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("file")) {
                return
            }
            val oldValue = __v_raw.file
            __v_raw.file = value
            _tRS(__v_raw, "file", oldValue, value)
        }
    override var type: String
        get() {
            return _tRG(__v_raw, "type", __v_raw.type, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("type")) {
                return
            }
            val oldValue = __v_raw.type
            __v_raw.type = value
            _tRS(__v_raw, "type", oldValue, value)
        }
    override var id: Number?
        get() {
            return _tRG(__v_raw, "id", __v_raw.id, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("id")) {
                return
            }
            val oldValue = __v_raw.id
            __v_raw.id = value
            _tRS(__v_raw, "id", oldValue, value)
        }
    override var uri: String
        get() {
            return _tRG(__v_raw, "uri", __v_raw.uri, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("uri")) {
                return
            }
            val oldValue = __v_raw.uri
            __v_raw.uri = value
            _tRS(__v_raw, "uri", oldValue, value)
        }
    override var folder: String?
        get() {
            return _tRG(__v_raw, "folder", __v_raw.folder, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("folder")) {
                return
            }
            val oldValue = __v_raw.folder
            __v_raw.folder = value
            _tRS(__v_raw, "folder", oldValue, value)
        }
    override var folderID: Number?
        get() {
            return _tRG(__v_raw, "folderID", __v_raw.folderID, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("folderID")) {
                return
            }
            val oldValue = __v_raw.folderID
            __v_raw.folderID = value
            _tRS(__v_raw, "folderID", oldValue, value)
        }
    override var duration: Number?
        get() {
            return _tRG(__v_raw, "duration", __v_raw.duration, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("duration")) {
                return
            }
            val oldValue = __v_raw.duration
            __v_raw.duration = value
            _tRS(__v_raw, "duration", oldValue, value)
        }
    override var ext: String?
        get() {
            return _tRG(__v_raw, "ext", __v_raw.ext, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("ext")) {
                return
            }
            val oldValue = __v_raw.ext
            __v_raw.ext = value
            _tRS(__v_raw, "ext", oldValue, value)
        }
}
open class path (
    open var name: String? = null,
    open var id: Long? = null,
    open var uri: String? = null,
    open var count: Number? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return pathReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class pathReactiveObject : path, IUTSReactive<path> {
    override var __v_raw: path
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: path, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(name = __v_raw.name, id = __v_raw.id, uri = __v_raw.uri, count = __v_raw.count) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): pathReactiveObject {
        return pathReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var name: String?
        get() {
            return _tRG(__v_raw, "name", __v_raw.name, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("name")) {
                return
            }
            val oldValue = __v_raw.name
            __v_raw.name = value
            _tRS(__v_raw, "name", oldValue, value)
        }
    override var id: Long?
        get() {
            return _tRG(__v_raw, "id", __v_raw.id, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("id")) {
                return
            }
            val oldValue = __v_raw.id
            __v_raw.id = value
            _tRS(__v_raw, "id", oldValue, value)
        }
    override var uri: String?
        get() {
            return _tRG(__v_raw, "uri", __v_raw.uri, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("uri")) {
                return
            }
            val oldValue = __v_raw.uri
            __v_raw.uri = value
            _tRS(__v_raw, "uri", oldValue, value)
        }
    override var count: Number?
        get() {
            return _tRG(__v_raw, "count", __v_raw.count, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("count")) {
                return
            }
            val oldValue = __v_raw.count
            __v_raw.count = value
            _tRS(__v_raw, "count", oldValue, value)
        }
}
val GenUniModulesIboxsChoosemediaPagesChooseClass = CreateVueComponent(GenUniModulesIboxsChoosemediaPagesChoose::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenUniModulesIboxsChoosemediaPagesChoose.inheritAttrs, inject = GenUniModulesIboxsChoosemediaPagesChoose.inject, props = GenUniModulesIboxsChoosemediaPagesChoose.props, propsNeedCastKeys = GenUniModulesIboxsChoosemediaPagesChoose.propsNeedCastKeys, emits = GenUniModulesIboxsChoosemediaPagesChoose.emits, components = GenUniModulesIboxsChoosemediaPagesChoose.components, styles = GenUniModulesIboxsChoosemediaPagesChoose.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesIboxsChoosemediaPagesChoose.setup(props as GenUniModulesIboxsChoosemediaPagesChoose)
    }
    )
}
, fun(instance, renderer): GenUniModulesIboxsChoosemediaPagesChoose {
    return GenUniModulesIboxsChoosemediaPagesChoose(instance, renderer)
}
)
val GenUniModulesIboxsChoosemediaComponentsXuBottomPopupClass = CreateVueComponent(GenUniModulesIboxsChoosemediaComponentsXuBottomPopup::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesIboxsChoosemediaComponentsXuBottomPopup.name, inheritAttrs = GenUniModulesIboxsChoosemediaComponentsXuBottomPopup.inheritAttrs, inject = GenUniModulesIboxsChoosemediaComponentsXuBottomPopup.inject, props = GenUniModulesIboxsChoosemediaComponentsXuBottomPopup.props, propsNeedCastKeys = GenUniModulesIboxsChoosemediaComponentsXuBottomPopup.propsNeedCastKeys, emits = GenUniModulesIboxsChoosemediaComponentsXuBottomPopup.emits, components = GenUniModulesIboxsChoosemediaComponentsXuBottomPopup.components, styles = GenUniModulesIboxsChoosemediaComponentsXuBottomPopup.styles)
}
, fun(instance, renderer): GenUniModulesIboxsChoosemediaComponentsXuBottomPopup {
    return GenUniModulesIboxsChoosemediaComponentsXuBottomPopup(instance)
}
)
val GenUniModulesIboxsChoosemediaComponentsXuButtommenuClass = CreateVueComponent(GenUniModulesIboxsChoosemediaComponentsXuButtommenu::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesIboxsChoosemediaComponentsXuButtommenu.name, inheritAttrs = GenUniModulesIboxsChoosemediaComponentsXuButtommenu.inheritAttrs, inject = GenUniModulesIboxsChoosemediaComponentsXuButtommenu.inject, props = GenUniModulesIboxsChoosemediaComponentsXuButtommenu.props, propsNeedCastKeys = GenUniModulesIboxsChoosemediaComponentsXuButtommenu.propsNeedCastKeys, emits = GenUniModulesIboxsChoosemediaComponentsXuButtommenu.emits, components = GenUniModulesIboxsChoosemediaComponentsXuButtommenu.components, styles = GenUniModulesIboxsChoosemediaComponentsXuButtommenu.styles)
}
, fun(instance, renderer): GenUniModulesIboxsChoosemediaComponentsXuButtommenu {
    return GenUniModulesIboxsChoosemediaComponentsXuButtommenu(instance)
}
)
val GenUniModulesIboxsChoosemediaPagesPreviewClass = CreateVueComponent(GenUniModulesIboxsChoosemediaPagesPreview::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenUniModulesIboxsChoosemediaPagesPreview.inheritAttrs, inject = GenUniModulesIboxsChoosemediaPagesPreview.inject, props = GenUniModulesIboxsChoosemediaPagesPreview.props, propsNeedCastKeys = GenUniModulesIboxsChoosemediaPagesPreview.propsNeedCastKeys, emits = GenUniModulesIboxsChoosemediaPagesPreview.emits, components = GenUniModulesIboxsChoosemediaPagesPreview.components, styles = GenUniModulesIboxsChoosemediaPagesPreview.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesIboxsChoosemediaPagesPreview.setup(props as GenUniModulesIboxsChoosemediaPagesPreview)
    }
    )
}
, fun(instance, renderer): GenUniModulesIboxsChoosemediaPagesPreview {
    return GenUniModulesIboxsChoosemediaPagesPreview(instance, renderer)
}
)
val GenPagesCommonBrowserClass = CreateVueComponent(GenPagesCommonBrowser::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesCommonBrowser.inheritAttrs, inject = GenPagesCommonBrowser.inject, props = GenPagesCommonBrowser.props, propsNeedCastKeys = GenPagesCommonBrowser.propsNeedCastKeys, emits = GenPagesCommonBrowser.emits, components = GenPagesCommonBrowser.components, styles = GenPagesCommonBrowser.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesCommonBrowser.setup(props as GenPagesCommonBrowser)
    }
    )
}
, fun(instance, renderer): GenPagesCommonBrowser {
    return GenPagesCommonBrowser(instance, renderer)
}
)
val GenPagesCommonScangoodsClass = CreateVueComponent(GenPagesCommonScangoods::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesCommonScangoods.inheritAttrs, inject = GenPagesCommonScangoods.inject, props = GenPagesCommonScangoods.props, propsNeedCastKeys = GenPagesCommonScangoods.propsNeedCastKeys, emits = GenPagesCommonScangoods.emits, components = GenPagesCommonScangoods.components, styles = GenPagesCommonScangoods.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesCommonScangoods.setup(props as GenPagesCommonScangoods)
    }
    )
}
, fun(instance, renderer): GenPagesCommonScangoods {
    return GenPagesCommonScangoods(instance, renderer)
}
)
val GenUniModulesIboxsUiComponentsIboxsPdfClass = CreateVueComponent(GenUniModulesIboxsUiComponentsIboxsPdf::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenUniModulesIboxsUiComponentsIboxsPdf.inheritAttrs, inject = GenUniModulesIboxsUiComponentsIboxsPdf.inject, props = GenUniModulesIboxsUiComponentsIboxsPdf.props, propsNeedCastKeys = GenUniModulesIboxsUiComponentsIboxsPdf.propsNeedCastKeys, emits = GenUniModulesIboxsUiComponentsIboxsPdf.emits, components = GenUniModulesIboxsUiComponentsIboxsPdf.components, styles = GenUniModulesIboxsUiComponentsIboxsPdf.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesIboxsUiComponentsIboxsPdf.setup(props as GenUniModulesIboxsUiComponentsIboxsPdf)
    }
    )
}
, fun(instance, renderer): GenUniModulesIboxsUiComponentsIboxsPdf {
    return GenUniModulesIboxsUiComponentsIboxsPdf(instance)
}
)
open class POSITION_TYPE_XY (
    @JsonNotNull
    open var x: Number,
    @JsonNotNull
    open var y: Number,
) : UTSObject()
val GenUniModulesTmxUiComponentsTmxFloatButtonTmxFloatButtonClass = CreateVueComponent(GenUniModulesTmxUiComponentsTmxFloatButtonTmxFloatButton::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesTmxUiComponentsTmxFloatButtonTmxFloatButton.name, inheritAttrs = GenUniModulesTmxUiComponentsTmxFloatButtonTmxFloatButton.inheritAttrs, inject = GenUniModulesTmxUiComponentsTmxFloatButtonTmxFloatButton.inject, props = GenUniModulesTmxUiComponentsTmxFloatButtonTmxFloatButton.props, propsNeedCastKeys = GenUniModulesTmxUiComponentsTmxFloatButtonTmxFloatButton.propsNeedCastKeys, emits = GenUniModulesTmxUiComponentsTmxFloatButtonTmxFloatButton.emits, components = GenUniModulesTmxUiComponentsTmxFloatButtonTmxFloatButton.components, styles = GenUniModulesTmxUiComponentsTmxFloatButtonTmxFloatButton.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesTmxUiComponentsTmxFloatButtonTmxFloatButton.setup(props as GenUniModulesTmxUiComponentsTmxFloatButtonTmxFloatButton)
    }
    )
}
, fun(instance, renderer): GenUniModulesTmxUiComponentsTmxFloatButtonTmxFloatButton {
    return GenUniModulesTmxUiComponentsTmxFloatButtonTmxFloatButton(instance)
}
)
val GenComponentsXBottomPopupClass = CreateVueComponent(GenComponentsXBottomPopup::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXBottomPopup.inheritAttrs, inject = GenComponentsXBottomPopup.inject, props = GenComponentsXBottomPopup.props, propsNeedCastKeys = GenComponentsXBottomPopup.propsNeedCastKeys, emits = GenComponentsXBottomPopup.emits, components = GenComponentsXBottomPopup.components, styles = GenComponentsXBottomPopup.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXBottomPopup.setup(props as GenComponentsXBottomPopup)
    }
    )
}
, fun(instance, renderer): GenComponentsXBottomPopup {
    return GenComponentsXBottomPopup(instance)
}
)
val GenComponentsXOrderPrintClass = CreateVueComponent(GenComponentsXOrderPrint::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXOrderPrint.inheritAttrs, inject = GenComponentsXOrderPrint.inject, props = GenComponentsXOrderPrint.props, propsNeedCastKeys = GenComponentsXOrderPrint.propsNeedCastKeys, emits = GenComponentsXOrderPrint.emits, components = GenComponentsXOrderPrint.components, styles = GenComponentsXOrderPrint.styles, setup = fun(props: ComponentPublicInstance, ctx: SetupContext): Any? {
        return GenComponentsXOrderPrint.setup(props as GenComponentsXOrderPrint, ctx)
    }
    )
}
, fun(instance, renderer): GenComponentsXOrderPrint {
    return GenComponentsXOrderPrint(instance)
}
)
val GenPagesCommonDocumentprintviewClass = CreateVueComponent(GenPagesCommonDocumentprintview::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesCommonDocumentprintview.inheritAttrs, inject = GenPagesCommonDocumentprintview.inject, props = GenPagesCommonDocumentprintview.props, propsNeedCastKeys = GenPagesCommonDocumentprintview.propsNeedCastKeys, emits = GenPagesCommonDocumentprintview.emits, components = GenPagesCommonDocumentprintview.components, styles = GenPagesCommonDocumentprintview.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesCommonDocumentprintview.setup(props as GenPagesCommonDocumentprintview)
    }
    )
}
, fun(instance, renderer): GenPagesCommonDocumentprintview {
    return GenPagesCommonDocumentprintview(instance, renderer)
}
)
interface PopoverProps {
    var closeOnClickOutside: Boolean
    var content: String?
    var placement: String
    var showArrow: Boolean
    var theme: String
    var visible: Boolean?
    var color: String?
    var disabled: Boolean
    var menus: UTSArray<UTSJSONObject>
}
open class PlacementAndWidth (
    @JsonNotNull
    open var placement: String,
    @JsonNotNull
    open var finalWidth: Number,
) : UTSObject()
val transformMap__1 = Map<String, String>(_uA())
val appTransformMap__1 = Map<String, String>(_uA(
    _uA(
        "left",
        "translateY(-50%)"
    ),
    _uA(
        "right",
        "translateY(-50%)"
    ),
    _uA(
        "right-bottom",
        "translateY(-100%)"
    ),
    _uA(
        "left-bottom",
        "translateY(-100%)"
    )
))
val transformOriginMap__1 = Map<String, String>(_uA(
    _uA(
        "top",
        "50% 100%"
    ),
    _uA(
        "top-left",
        "0 100%"
    ),
    _uA(
        "top-right",
        "100% 100%"
    ),
    _uA(
        "bottom",
        "50% 0%"
    ),
    _uA(
        "bottom-left",
        "0% 0%"
    ),
    _uA(
        "bottom-right",
        "100% 0"
    ),
    _uA(
        "left-bottom",
        "100% 100%"
    ),
    _uA(
        "right-bottom",
        "0 100%"
    ),
    _uA(
        "left",
        "100% 50%"
    ),
    _uA(
        "left-top",
        "100% 0"
    ),
    _uA(
        "right",
        "0 50%"
    ),
    _uA(
        "right-top",
        "0 0"
    )
))
fun findPageElement__1(startEl: UniElement?): UniElement? {
    var currentEl: UniElement? = startEl
    while(currentEl != null && currentEl.parentElement != null){
        currentEl = currentEl.parentElement
    }
    return currentEl
}
fun calculateWidthAndAdjustPlacement__1(placement: String, availableLeft: Number, availableRight: Number, popoverWidth: Number): PlacementAndWidth {
    var finalPlacement: String = placement
    var finalWidth: Number = popoverWidth
    if (_uA(
        "left",
        "right"
    ).some(fun(dir): Boolean {
        return placement.startsWith(dir)
    }
    )) {
        val isLeft = placement.startsWith("left")
        val availableSpace = if (isLeft) {
            availableLeft
        } else {
            availableRight
        }
        val oppositeSpace = if (isLeft) {
            availableRight
        } else {
            availableLeft
        }
        if (availableSpace >= popoverWidth) {
            finalWidth = popoverWidth
        } else if (oppositeSpace >= popoverWidth) {
            finalWidth = popoverWidth
            finalPlacement = placement.replace(if (isLeft) {
                "left"
            } else {
                "right"
            }, if (isLeft) {
                "right"
            } else {
                "left"
            })
        } else if (availableSpace < 64 && finalWidth > 64) {
            finalPlacement = "bottom"
            finalWidth = popoverWidth
        } else {
            finalWidth = availableSpace
        }
    }
    return PlacementAndWidth(placement = finalPlacement, finalWidth = finalWidth)
}
val GenComponentsXpPopoverXpPopoverClass = CreateVueComponent(GenComponentsXpPopoverXpPopover::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXpPopoverXpPopover.inheritAttrs, inject = GenComponentsXpPopoverXpPopover.inject, props = GenComponentsXpPopoverXpPopover.props, propsNeedCastKeys = GenComponentsXpPopoverXpPopover.propsNeedCastKeys, emits = GenComponentsXpPopoverXpPopover.emits, components = GenComponentsXpPopoverXpPopover.components, styles = GenComponentsXpPopoverXpPopover.styles, setup = fun(props: ComponentPublicInstance, ctx: SetupContext): Any? {
        return GenComponentsXpPopoverXpPopover.setup(props as GenComponentsXpPopoverXpPopover, ctx)
    }
    )
}
, fun(instance, renderer): GenComponentsXpPopoverXpPopover {
    return GenComponentsXpPopoverXpPopover(instance)
}
)
val GenComponentsXShowSignerClass = CreateVueComponent(GenComponentsXShowSigner::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXShowSigner.inheritAttrs, inject = GenComponentsXShowSigner.inject, props = GenComponentsXShowSigner.props, propsNeedCastKeys = GenComponentsXShowSigner.propsNeedCastKeys, emits = GenComponentsXShowSigner.emits, components = GenComponentsXShowSigner.components, styles = GenComponentsXShowSigner.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXShowSigner.setup(props as GenComponentsXShowSigner)
    }
    )
}
, fun(instance, renderer): GenComponentsXShowSigner {
    return GenComponentsXShowSigner(instance)
}
)
val GenComponentsXPreviewimgClass = CreateVueComponent(GenComponentsXPreviewimg::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXPreviewimg.inheritAttrs, inject = GenComponentsXPreviewimg.inject, props = GenComponentsXPreviewimg.props, propsNeedCastKeys = GenComponentsXPreviewimg.propsNeedCastKeys, emits = GenComponentsXPreviewimg.emits, components = GenComponentsXPreviewimg.components, styles = GenComponentsXPreviewimg.styles, setup = fun(props: ComponentPublicInstance, ctx: SetupContext): Any? {
        return GenComponentsXPreviewimg.setup(props as GenComponentsXPreviewimg, ctx)
    }
    )
}
, fun(instance, renderer): GenComponentsXPreviewimg {
    return GenComponentsXPreviewimg(instance)
}
)
val GenComponentsXOrderGoodsClass = CreateVueComponent(GenComponentsXOrderGoods::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXOrderGoods.inheritAttrs, inject = GenComponentsXOrderGoods.inject, props = GenComponentsXOrderGoods.props, propsNeedCastKeys = GenComponentsXOrderGoods.propsNeedCastKeys, emits = GenComponentsXOrderGoods.emits, components = GenComponentsXOrderGoods.components, styles = GenComponentsXOrderGoods.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXOrderGoods.setup(props as GenComponentsXOrderGoods)
    }
    )
}
, fun(instance, renderer): GenComponentsXOrderGoods {
    return GenComponentsXOrderGoods(instance)
}
)
val GenComponentsXRemarkshowClass = CreateVueComponent(GenComponentsXRemarkshow::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXRemarkshow.inheritAttrs, inject = GenComponentsXRemarkshow.inject, props = GenComponentsXRemarkshow.props, propsNeedCastKeys = GenComponentsXRemarkshow.propsNeedCastKeys, emits = GenComponentsXRemarkshow.emits, components = GenComponentsXRemarkshow.components, styles = GenComponentsXRemarkshow.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXRemarkshow.setup(props as GenComponentsXRemarkshow)
    }
    )
}
, fun(instance, renderer): GenComponentsXRemarkshow {
    return GenComponentsXRemarkshow(instance)
}
)
val GenComponentsXMaskClass = CreateVueComponent(GenComponentsXMask::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXMask.inheritAttrs, inject = GenComponentsXMask.inject, props = GenComponentsXMask.props, propsNeedCastKeys = GenComponentsXMask.propsNeedCastKeys, emits = GenComponentsXMask.emits, components = GenComponentsXMask.components, styles = GenComponentsXMask.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXMask.setup(props as GenComponentsXMask)
    }
    )
}
, fun(instance, renderer): GenComponentsXMask {
    return GenComponentsXMask(instance)
}
)
val GenComponentsXPopupMenuClass = CreateVueComponent(GenComponentsXPopupMenu::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXPopupMenu.inheritAttrs, inject = GenComponentsXPopupMenu.inject, props = GenComponentsXPopupMenu.props, propsNeedCastKeys = GenComponentsXPopupMenu.propsNeedCastKeys, emits = GenComponentsXPopupMenu.emits, components = GenComponentsXPopupMenu.components, styles = GenComponentsXPopupMenu.styles, setup = fun(props: ComponentPublicInstance, ctx: SetupContext): Any? {
        return GenComponentsXPopupMenu.setup(props as GenComponentsXPopupMenu, ctx)
    }
    )
}
, fun(instance, renderer): GenComponentsXPopupMenu {
    return GenComponentsXPopupMenu(instance)
}
)
val GenUniModulesIboxsUiComponentsIboxsIconClass = CreateVueComponent(GenUniModulesIboxsUiComponentsIboxsIcon::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesIboxsUiComponentsIboxsIcon.name, inheritAttrs = GenUniModulesIboxsUiComponentsIboxsIcon.inheritAttrs, inject = GenUniModulesIboxsUiComponentsIboxsIcon.inject, props = GenUniModulesIboxsUiComponentsIboxsIcon.props, propsNeedCastKeys = GenUniModulesIboxsUiComponentsIboxsIcon.propsNeedCastKeys, emits = GenUniModulesIboxsUiComponentsIboxsIcon.emits, components = GenUniModulesIboxsUiComponentsIboxsIcon.components, styles = GenUniModulesIboxsUiComponentsIboxsIcon.styles)
}
, fun(instance, renderer): GenUniModulesIboxsUiComponentsIboxsIcon {
    return GenUniModulesIboxsUiComponentsIboxsIcon(instance)
}
)
val GenUniModulesIboxsUiComponentsIboxsBottomPopupClass = CreateVueComponent(GenUniModulesIboxsUiComponentsIboxsBottomPopup::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesIboxsUiComponentsIboxsBottomPopup.name, inheritAttrs = GenUniModulesIboxsUiComponentsIboxsBottomPopup.inheritAttrs, inject = GenUniModulesIboxsUiComponentsIboxsBottomPopup.inject, props = GenUniModulesIboxsUiComponentsIboxsBottomPopup.props, propsNeedCastKeys = GenUniModulesIboxsUiComponentsIboxsBottomPopup.propsNeedCastKeys, emits = GenUniModulesIboxsUiComponentsIboxsBottomPopup.emits, components = GenUniModulesIboxsUiComponentsIboxsBottomPopup.components, styles = GenUniModulesIboxsUiComponentsIboxsBottomPopup.styles)
}
, fun(instance, renderer): GenUniModulesIboxsUiComponentsIboxsBottomPopup {
    return GenUniModulesIboxsUiComponentsIboxsBottomPopup(instance)
}
)
open class shareListInfo (
    open var key: String? = null,
    open var name: String? = null,
    open var icon: String? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return shareListInfoReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class shareListInfoReactiveObject : shareListInfo, IUTSReactive<shareListInfo> {
    override var __v_raw: shareListInfo
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: shareListInfo, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(key = __v_raw.key, name = __v_raw.name, icon = __v_raw.icon) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): shareListInfoReactiveObject {
        return shareListInfoReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var key: String?
        get() {
            return _tRG(__v_raw, "key", __v_raw.key, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("key")) {
                return
            }
            val oldValue = __v_raw.key
            __v_raw.key = value
            _tRS(__v_raw, "key", oldValue, value)
        }
    override var name: String?
        get() {
            return _tRG(__v_raw, "name", __v_raw.name, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("name")) {
                return
            }
            val oldValue = __v_raw.name
            __v_raw.name = value
            _tRS(__v_raw, "name", oldValue, value)
        }
    override var icon: String?
        get() {
            return _tRG(__v_raw, "icon", __v_raw.icon, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("icon")) {
                return
            }
            val oldValue = __v_raw.icon
            __v_raw.icon = value
            _tRS(__v_raw, "icon", oldValue, value)
        }
}
val GenUniModulesIboxsUiComponentsIboxsShareClass = CreateVueComponent(GenUniModulesIboxsUiComponentsIboxsShare::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenUniModulesIboxsUiComponentsIboxsShare.inheritAttrs, inject = GenUniModulesIboxsUiComponentsIboxsShare.inject, props = GenUniModulesIboxsUiComponentsIboxsShare.props, propsNeedCastKeys = GenUniModulesIboxsUiComponentsIboxsShare.propsNeedCastKeys, emits = GenUniModulesIboxsUiComponentsIboxsShare.emits, components = GenUniModulesIboxsUiComponentsIboxsShare.components, styles = GenUniModulesIboxsUiComponentsIboxsShare.styles)
}
, fun(instance, renderer): GenUniModulesIboxsUiComponentsIboxsShare {
    return GenUniModulesIboxsUiComponentsIboxsShare(instance)
}
)
val GenPagesWarehousePurchasePurchaseviewClass = CreateVueComponent(GenPagesWarehousePurchasePurchaseview::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesWarehousePurchasePurchaseview.inheritAttrs, inject = GenPagesWarehousePurchasePurchaseview.inject, props = GenPagesWarehousePurchasePurchaseview.props, propsNeedCastKeys = GenPagesWarehousePurchasePurchaseview.propsNeedCastKeys, emits = GenPagesWarehousePurchasePurchaseview.emits, components = GenPagesWarehousePurchasePurchaseview.components, styles = GenPagesWarehousePurchasePurchaseview.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesWarehousePurchasePurchaseview.setup(props as GenPagesWarehousePurchasePurchaseview)
    }
    )
}
, fun(instance, renderer): GenPagesWarehousePurchasePurchaseview {
    return GenPagesWarehousePurchasePurchaseview(instance, renderer)
}
)
val GenComponentsXTagClass = CreateVueComponent(GenComponentsXTag::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXTag.inheritAttrs, inject = GenComponentsXTag.inject, props = GenComponentsXTag.props, propsNeedCastKeys = GenComponentsXTag.propsNeedCastKeys, emits = GenComponentsXTag.emits, components = GenComponentsXTag.components, styles = GenComponentsXTag.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXTag.setup(props as GenComponentsXTag)
    }
    )
}
, fun(instance, renderer): GenComponentsXTag {
    return GenComponentsXTag(instance)
}
)
val GenComponentsXStocktaskClass = CreateVueComponent(GenComponentsXStocktask::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXStocktask.inheritAttrs, inject = GenComponentsXStocktask.inject, props = GenComponentsXStocktask.props, propsNeedCastKeys = GenComponentsXStocktask.propsNeedCastKeys, emits = GenComponentsXStocktask.emits, components = GenComponentsXStocktask.components, styles = GenComponentsXStocktask.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXStocktask.setup(props as GenComponentsXStocktask)
    }
    )
}
, fun(instance, renderer): GenComponentsXStocktask {
    return GenComponentsXStocktask(instance)
}
)
val GenPagesWarehouseStocktaskingStocktaskClass = CreateVueComponent(GenPagesWarehouseStocktaskingStocktask::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesWarehouseStocktaskingStocktask.inheritAttrs, inject = GenPagesWarehouseStocktaskingStocktask.inject, props = GenPagesWarehouseStocktaskingStocktask.props, propsNeedCastKeys = GenPagesWarehouseStocktaskingStocktask.propsNeedCastKeys, emits = GenPagesWarehouseStocktaskingStocktask.emits, components = GenPagesWarehouseStocktaskingStocktask.components, styles = GenPagesWarehouseStocktaskingStocktask.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesWarehouseStocktaskingStocktask.setup(props as GenPagesWarehouseStocktaskingStocktask)
    }
    )
}
, fun(instance, renderer): GenPagesWarehouseStocktaskingStocktask {
    return GenPagesWarehouseStocktaskingStocktask(instance, renderer)
}
)
val GenPagesWarehouseStocktaskingAddstocktaskClass = CreateVueComponent(GenPagesWarehouseStocktaskingAddstocktask::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesWarehouseStocktaskingAddstocktask.inheritAttrs, inject = GenPagesWarehouseStocktaskingAddstocktask.inject, props = GenPagesWarehouseStocktaskingAddstocktask.props, propsNeedCastKeys = GenPagesWarehouseStocktaskingAddstocktask.propsNeedCastKeys, emits = GenPagesWarehouseStocktaskingAddstocktask.emits, components = GenPagesWarehouseStocktaskingAddstocktask.components, styles = GenPagesWarehouseStocktaskingAddstocktask.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesWarehouseStocktaskingAddstocktask.setup(props as GenPagesWarehouseStocktaskingAddstocktask)
    }
    )
}
, fun(instance, renderer): GenPagesWarehouseStocktaskingAddstocktask {
    return GenPagesWarehouseStocktaskingAddstocktask(instance, renderer)
}
)
val GenUniModulesFirstuiUvueComponentsFuiSwipeActionFuiSwipeActionClass = CreateVueComponent(GenUniModulesFirstuiUvueComponentsFuiSwipeActionFuiSwipeAction::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesFirstuiUvueComponentsFuiSwipeActionFuiSwipeAction.name, inheritAttrs = GenUniModulesFirstuiUvueComponentsFuiSwipeActionFuiSwipeAction.inheritAttrs, inject = GenUniModulesFirstuiUvueComponentsFuiSwipeActionFuiSwipeAction.inject, props = GenUniModulesFirstuiUvueComponentsFuiSwipeActionFuiSwipeAction.props, propsNeedCastKeys = GenUniModulesFirstuiUvueComponentsFuiSwipeActionFuiSwipeAction.propsNeedCastKeys, emits = GenUniModulesFirstuiUvueComponentsFuiSwipeActionFuiSwipeAction.emits, components = GenUniModulesFirstuiUvueComponentsFuiSwipeActionFuiSwipeAction.components, styles = GenUniModulesFirstuiUvueComponentsFuiSwipeActionFuiSwipeAction.styles)
}
, fun(instance, renderer): GenUniModulesFirstuiUvueComponentsFuiSwipeActionFuiSwipeAction {
    return GenUniModulesFirstuiUvueComponentsFuiSwipeActionFuiSwipeAction(instance)
}
)
val GenComponentsXAdminClass = CreateVueComponent(GenComponentsXAdmin::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXAdmin.inheritAttrs, inject = GenComponentsXAdmin.inject, props = GenComponentsXAdmin.props, propsNeedCastKeys = GenComponentsXAdmin.propsNeedCastKeys, emits = GenComponentsXAdmin.emits, components = GenComponentsXAdmin.components, styles = GenComponentsXAdmin.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXAdmin.setup(props as GenComponentsXAdmin)
    }
    )
}
, fun(instance, renderer): GenComponentsXAdmin {
    return GenComponentsXAdmin(instance)
}
)
val GenPagesCommonChooseadminClass = CreateVueComponent(GenPagesCommonChooseadmin::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesCommonChooseadmin.inheritAttrs, inject = GenPagesCommonChooseadmin.inject, props = GenPagesCommonChooseadmin.props, propsNeedCastKeys = GenPagesCommonChooseadmin.propsNeedCastKeys, emits = GenPagesCommonChooseadmin.emits, components = GenPagesCommonChooseadmin.components, styles = GenPagesCommonChooseadmin.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesCommonChooseadmin.setup(props as GenPagesCommonChooseadmin)
    }
    )
}
, fun(instance, renderer): GenPagesCommonChooseadmin {
    return GenPagesCommonChooseadmin(instance, renderer)
}
)
val GenPagesWarehouseStocktaskingStocktaskviewClass = CreateVueComponent(GenPagesWarehouseStocktaskingStocktaskview::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesWarehouseStocktaskingStocktaskview.inheritAttrs, inject = GenPagesWarehouseStocktaskingStocktaskview.inject, props = GenPagesWarehouseStocktaskingStocktaskview.props, propsNeedCastKeys = GenPagesWarehouseStocktaskingStocktaskview.propsNeedCastKeys, emits = GenPagesWarehouseStocktaskingStocktaskview.emits, components = GenPagesWarehouseStocktaskingStocktaskview.components, styles = GenPagesWarehouseStocktaskingStocktaskview.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesWarehouseStocktaskingStocktaskview.setup(props as GenPagesWarehouseStocktaskingStocktaskview)
    }
    )
}
, fun(instance, renderer): GenPagesWarehouseStocktaskingStocktaskview {
    return GenPagesWarehouseStocktaskingStocktaskview(instance, renderer)
}
)
val GenComponentsXListGoodsClass = CreateVueComponent(GenComponentsXListGoods::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXListGoods.inheritAttrs, inject = GenComponentsXListGoods.inject, props = GenComponentsXListGoods.props, propsNeedCastKeys = GenComponentsXListGoods.propsNeedCastKeys, emits = GenComponentsXListGoods.emits, components = GenComponentsXListGoods.components, styles = GenComponentsXListGoods.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXListGoods.setup(props as GenComponentsXListGoods)
    }
    )
}
, fun(instance, renderer): GenComponentsXListGoods {
    return GenComponentsXListGoods(instance)
}
)
open class cacheInfo (
    @JsonNotNull
    open var data: Any,
    @JsonNotNull
    open var timeout: Number,
) : UTSObject()
open class cache {
    companion object {
        private fun getNow(): Number {
            return Date().getTime()
        }
        fun rm(key: String): Unit {
            common.rmStorage("timeCache-" + key)
        }
        fun get(key: String): Any {
            var data = common.getStorage("timeCache-" + key)
            if (data == "") {
                return ""
            }
            var j = JSON.parseObject(data as String) as UTSJSONObject
            var d = cacheInfo(data = j["data"] as Any, timeout = j["timeout"] as Number)
            var now = this.getNow()
            var timeout = d.timeout
            if (now > timeout) {
                common.rmStorage("timeCache-" + key)
                return ""
            }
            return d.data
        }
        fun set(key: String, value: Any, expire: Number): Unit {
            var data = cacheInfo(data = value, timeout = this.getNow() + expire * 1000)
            var json = JSON.stringify(data)
            common.setStorage("timeCache-" + key, json)
        }
    }
}
open class getdata {
    companion object {
        fun goodscodeinfo(code: String): UTSPromise<Any> {
            return wrapUTSPromise(suspend w@{
                    var cacheKey = "goodscodeinfo:" + code
                    var ca = cache.get(cacheKey)
                    if (ca != "") {
                        return@w ca
                    }
                    var res = await(request.callapi("goods/codeinfo", _uO("code" to code)))
                    if (res.code < 0) {
                        common.toast(res.msg)
                        return@w null
                    }
                    var goods = res.data as UTSJSONObject
                    cache.set(cacheKey, goods, 30)
                    return@w res.data as UTSJSONObject
            })
        }
    }
}
val GenPagesWarehouseStocktaskingRunstocktaskClass = CreateVueComponent(GenPagesWarehouseStocktaskingRunstocktask::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesWarehouseStocktaskingRunstocktask.inheritAttrs, inject = GenPagesWarehouseStocktaskingRunstocktask.inject, props = GenPagesWarehouseStocktaskingRunstocktask.props, propsNeedCastKeys = GenPagesWarehouseStocktaskingRunstocktask.propsNeedCastKeys, emits = GenPagesWarehouseStocktaskingRunstocktask.emits, components = GenPagesWarehouseStocktaskingRunstocktask.components, styles = GenPagesWarehouseStocktaskingRunstocktask.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesWarehouseStocktaskingRunstocktask.setup(props as GenPagesWarehouseStocktaskingRunstocktask)
    }
    )
}
, fun(instance, renderer): GenPagesWarehouseStocktaskingRunstocktask {
    return GenPagesWarehouseStocktaskingRunstocktask(instance, renderer)
}
)
val GenPagesWarehouseStocktaskingViewstocktaskdataClass = CreateVueComponent(GenPagesWarehouseStocktaskingViewstocktaskdata::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesWarehouseStocktaskingViewstocktaskdata.inheritAttrs, inject = GenPagesWarehouseStocktaskingViewstocktaskdata.inject, props = GenPagesWarehouseStocktaskingViewstocktaskdata.props, propsNeedCastKeys = GenPagesWarehouseStocktaskingViewstocktaskdata.propsNeedCastKeys, emits = GenPagesWarehouseStocktaskingViewstocktaskdata.emits, components = GenPagesWarehouseStocktaskingViewstocktaskdata.components, styles = GenPagesWarehouseStocktaskingViewstocktaskdata.styles)
}
, fun(instance, renderer): GenPagesWarehouseStocktaskingViewstocktaskdata {
    return GenPagesWarehouseStocktaskingViewstocktaskdata(instance, renderer)
}
)
interface PDFProps {
    var url: String?
    var lStyle: Any?
    var page: Number
    var spacing: Number?
    var swipeHorizontal: Boolean
    var password: String?
    var scrollView: Boolean
    var backTop: Boolean
    var zoomEnable: Boolean
    var scrollEnable: Boolean
    var scale: Number?
    var renderType: String?
}
val GenUniModulesLimePdfComponentsLPdfLPdfClass = CreateVueComponent(GenUniModulesLimePdfComponentsLPdfLPdf::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenUniModulesLimePdfComponentsLPdfLPdf.inheritAttrs, inject = GenUniModulesLimePdfComponentsLPdfLPdf.inject, props = GenUniModulesLimePdfComponentsLPdfLPdf.props, propsNeedCastKeys = GenUniModulesLimePdfComponentsLPdfLPdf.propsNeedCastKeys, emits = GenUniModulesLimePdfComponentsLPdfLPdf.emits, components = GenUniModulesLimePdfComponentsLPdfLPdf.components, styles = GenUniModulesLimePdfComponentsLPdfLPdf.styles, setup = fun(props: ComponentPublicInstance, ctx: SetupContext): Any? {
        return GenUniModulesLimePdfComponentsLPdfLPdf.setup(props as GenUniModulesLimePdfComponentsLPdfLPdf, ctx)
    }
    )
}
, fun(instance, renderer): GenUniModulesLimePdfComponentsLPdfLPdf {
    return GenUniModulesLimePdfComponentsLPdfLPdf(instance)
}
)
val GenPagesWarehouseStocktaskingShowstocktaskdataClass = CreateVueComponent(GenPagesWarehouseStocktaskingShowstocktaskdata::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesWarehouseStocktaskingShowstocktaskdata.inheritAttrs, inject = GenPagesWarehouseStocktaskingShowstocktaskdata.inject, props = GenPagesWarehouseStocktaskingShowstocktaskdata.props, propsNeedCastKeys = GenPagesWarehouseStocktaskingShowstocktaskdata.propsNeedCastKeys, emits = GenPagesWarehouseStocktaskingShowstocktaskdata.emits, components = GenPagesWarehouseStocktaskingShowstocktaskdata.components, styles = GenPagesWarehouseStocktaskingShowstocktaskdata.styles)
}
, fun(instance, renderer): GenPagesWarehouseStocktaskingShowstocktaskdata {
    return GenPagesWarehouseStocktaskingShowstocktaskdata(instance, renderer)
}
)
val GenComponentsXRequiregoodsOrderClass = CreateVueComponent(GenComponentsXRequiregoodsOrder::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXRequiregoodsOrder.inheritAttrs, inject = GenComponentsXRequiregoodsOrder.inject, props = GenComponentsXRequiregoodsOrder.props, propsNeedCastKeys = GenComponentsXRequiregoodsOrder.propsNeedCastKeys, emits = GenComponentsXRequiregoodsOrder.emits, components = GenComponentsXRequiregoodsOrder.components, styles = GenComponentsXRequiregoodsOrder.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXRequiregoodsOrder.setup(props as GenComponentsXRequiregoodsOrder)
    }
    )
}
, fun(instance, renderer): GenComponentsXRequiregoodsOrder {
    return GenComponentsXRequiregoodsOrder(instance)
}
)
val GenPagesWarehouseRequiregoodsListClass = CreateVueComponent(GenPagesWarehouseRequiregoodsList::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesWarehouseRequiregoodsList.inheritAttrs, inject = GenPagesWarehouseRequiregoodsList.inject, props = GenPagesWarehouseRequiregoodsList.props, propsNeedCastKeys = GenPagesWarehouseRequiregoodsList.propsNeedCastKeys, emits = GenPagesWarehouseRequiregoodsList.emits, components = GenPagesWarehouseRequiregoodsList.components, styles = GenPagesWarehouseRequiregoodsList.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesWarehouseRequiregoodsList.setup(props as GenPagesWarehouseRequiregoodsList)
    }
    )
}
, fun(instance, renderer): GenPagesWarehouseRequiregoodsList {
    return GenPagesWarehouseRequiregoodsList(instance, renderer)
}
)
open class requiregoodsinfo (
    @JsonNotNull
    open var goodsinfo: UTSJSONObject,
    @JsonNotNull
    open var stock: Number,
    @JsonNotNull
    open var number: Number,
    @JsonNotNull
    open var id: Number,
    open var remark: String? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return requiregoodsinfoReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class requiregoodsinfoReactiveObject : requiregoodsinfo, IUTSReactive<requiregoodsinfo> {
    override var __v_raw: requiregoodsinfo
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: requiregoodsinfo, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(goodsinfo = __v_raw.goodsinfo, stock = __v_raw.stock, number = __v_raw.number, id = __v_raw.id, remark = __v_raw.remark) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): requiregoodsinfoReactiveObject {
        return requiregoodsinfoReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var goodsinfo: UTSJSONObject
        get() {
            return _tRG(__v_raw, "goodsinfo", __v_raw.goodsinfo, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("goodsinfo")) {
                return
            }
            val oldValue = __v_raw.goodsinfo
            __v_raw.goodsinfo = value
            _tRS(__v_raw, "goodsinfo", oldValue, value)
        }
    override var stock: Number
        get() {
            return _tRG(__v_raw, "stock", __v_raw.stock, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("stock")) {
                return
            }
            val oldValue = __v_raw.stock
            __v_raw.stock = value
            _tRS(__v_raw, "stock", oldValue, value)
        }
    override var number: Number
        get() {
            return _tRG(__v_raw, "number", __v_raw.number, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("number")) {
                return
            }
            val oldValue = __v_raw.number
            __v_raw.number = value
            _tRS(__v_raw, "number", oldValue, value)
        }
    override var id: Number
        get() {
            return _tRG(__v_raw, "id", __v_raw.id, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("id")) {
                return
            }
            val oldValue = __v_raw.id
            __v_raw.id = value
            _tRS(__v_raw, "id", oldValue, value)
        }
    override var remark: String?
        get() {
            return _tRG(__v_raw, "remark", __v_raw.remark, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("remark")) {
                return
            }
            val oldValue = __v_raw.remark
            __v_raw.remark = value
            _tRS(__v_raw, "remark", oldValue, value)
        }
}
val GenPagesWarehouseRequiregoodsAddrequiregoodsClass = CreateVueComponent(GenPagesWarehouseRequiregoodsAddrequiregoods::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesWarehouseRequiregoodsAddrequiregoods.inheritAttrs, inject = GenPagesWarehouseRequiregoodsAddrequiregoods.inject, props = GenPagesWarehouseRequiregoodsAddrequiregoods.props, propsNeedCastKeys = GenPagesWarehouseRequiregoodsAddrequiregoods.propsNeedCastKeys, emits = GenPagesWarehouseRequiregoodsAddrequiregoods.emits, components = GenPagesWarehouseRequiregoodsAddrequiregoods.components, styles = GenPagesWarehouseRequiregoodsAddrequiregoods.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesWarehouseRequiregoodsAddrequiregoods.setup(props as GenPagesWarehouseRequiregoodsAddrequiregoods)
    }
    )
}
, fun(instance, renderer): GenPagesWarehouseRequiregoodsAddrequiregoods {
    return GenPagesWarehouseRequiregoodsAddrequiregoods(instance, renderer)
}
)
val GenPagesWarehouseRequiregoodsViewClass = CreateVueComponent(GenPagesWarehouseRequiregoodsView::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesWarehouseRequiregoodsView.inheritAttrs, inject = GenPagesWarehouseRequiregoodsView.inject, props = GenPagesWarehouseRequiregoodsView.props, propsNeedCastKeys = GenPagesWarehouseRequiregoodsView.propsNeedCastKeys, emits = GenPagesWarehouseRequiregoodsView.emits, components = GenPagesWarehouseRequiregoodsView.components, styles = GenPagesWarehouseRequiregoodsView.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesWarehouseRequiregoodsView.setup(props as GenPagesWarehouseRequiregoodsView)
    }
    )
}
, fun(instance, renderer): GenPagesWarehouseRequiregoodsView {
    return GenPagesWarehouseRequiregoodsView(instance, renderer)
}
)
val default__13: UTSJSONObject = _uO("checkbox" to "\ue637", "checkboxoutlineblank" to "\ue63c", "jiantou_xiangzuo" to "\ueb09", "gundongtiao" to "\ue62d", "gundongtiao2" to "\ueb0a", "close" to "\ue6d5", "youxiajiao" to "\ue634", "xiangxia" to "\ue66f", "xiangshang" to "\ue600", "gougou" to "\ue651", "zhaoxiangji" to "\ue601", "chacha" to "\ue62f", "dingwei" to "\ue93f", "sousuo" to "\ue633", "xiangzuo1" to "\ue779", "daohang" to "\ue66c")
val GenUniModulesIboxsAmapComponentsIboxsIconClass = CreateVueComponent(GenUniModulesIboxsAmapComponentsIboxsIcon::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesIboxsAmapComponentsIboxsIcon.name, inheritAttrs = GenUniModulesIboxsAmapComponentsIboxsIcon.inheritAttrs, inject = GenUniModulesIboxsAmapComponentsIboxsIcon.inject, props = GenUniModulesIboxsAmapComponentsIboxsIcon.props, propsNeedCastKeys = GenUniModulesIboxsAmapComponentsIboxsIcon.propsNeedCastKeys, emits = GenUniModulesIboxsAmapComponentsIboxsIcon.emits, components = GenUniModulesIboxsAmapComponentsIboxsIcon.components, styles = GenUniModulesIboxsAmapComponentsIboxsIcon.styles)
}
, fun(instance, renderer): GenUniModulesIboxsAmapComponentsIboxsIcon {
    return GenUniModulesIboxsAmapComponentsIboxsIcon(instance)
}
)
val GenUniModulesIboxsAmapPagesChooselocationClass = CreateVueComponent(GenUniModulesIboxsAmapPagesChooselocation::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenUniModulesIboxsAmapPagesChooselocation.inheritAttrs, inject = GenUniModulesIboxsAmapPagesChooselocation.inject, props = GenUniModulesIboxsAmapPagesChooselocation.props, propsNeedCastKeys = GenUniModulesIboxsAmapPagesChooselocation.propsNeedCastKeys, emits = GenUniModulesIboxsAmapPagesChooselocation.emits, components = GenUniModulesIboxsAmapPagesChooselocation.components, styles = GenUniModulesIboxsAmapPagesChooselocation.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesIboxsAmapPagesChooselocation.setup(props as GenUniModulesIboxsAmapPagesChooselocation)
    }
    )
}
, fun(instance, renderer): GenUniModulesIboxsAmapPagesChooselocation {
    return GenUniModulesIboxsAmapPagesChooselocation(instance, renderer)
}
)
open class bottomMenu__2 (
    @JsonNotNull
    open var key: String,
    @JsonNotNull
    open var name: String,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return bottomMenu__2ReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class bottomMenu__2ReactiveObject : bottomMenu__2, IUTSReactive<bottomMenu__2> {
    override var __v_raw: bottomMenu__2
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: bottomMenu__2, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(key = __v_raw.key, name = __v_raw.name) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): bottomMenu__2ReactiveObject {
        return bottomMenu__2ReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var key: String
        get() {
            return _tRG(__v_raw, "key", __v_raw.key, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("key")) {
                return
            }
            val oldValue = __v_raw.key
            __v_raw.key = value
            _tRS(__v_raw, "key", oldValue, value)
        }
    override var name: String
        get() {
            return _tRG(__v_raw, "name", __v_raw.name, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("name")) {
                return
            }
            val oldValue = __v_raw.name
            __v_raw.name = value
            _tRS(__v_raw, "name", oldValue, value)
        }
}
val GenUniModulesIboxsAmapComponentsIboxsBottomPopupClass = CreateVueComponent(GenUniModulesIboxsAmapComponentsIboxsBottomPopup::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesIboxsAmapComponentsIboxsBottomPopup.name, inheritAttrs = GenUniModulesIboxsAmapComponentsIboxsBottomPopup.inheritAttrs, inject = GenUniModulesIboxsAmapComponentsIboxsBottomPopup.inject, props = GenUniModulesIboxsAmapComponentsIboxsBottomPopup.props, propsNeedCastKeys = GenUniModulesIboxsAmapComponentsIboxsBottomPopup.propsNeedCastKeys, emits = GenUniModulesIboxsAmapComponentsIboxsBottomPopup.emits, components = GenUniModulesIboxsAmapComponentsIboxsBottomPopup.components, styles = GenUniModulesIboxsAmapComponentsIboxsBottomPopup.styles)
}
, fun(instance, renderer): GenUniModulesIboxsAmapComponentsIboxsBottomPopup {
    return GenUniModulesIboxsAmapComponentsIboxsBottomPopup(instance)
}
)
val GenUniModulesIboxsAmapComponentsIboxsBottommenuClass = CreateVueComponent(GenUniModulesIboxsAmapComponentsIboxsBottommenu::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesIboxsAmapComponentsIboxsBottommenu.name, inheritAttrs = GenUniModulesIboxsAmapComponentsIboxsBottommenu.inheritAttrs, inject = GenUniModulesIboxsAmapComponentsIboxsBottommenu.inject, props = GenUniModulesIboxsAmapComponentsIboxsBottommenu.props, propsNeedCastKeys = GenUniModulesIboxsAmapComponentsIboxsBottommenu.propsNeedCastKeys, emits = GenUniModulesIboxsAmapComponentsIboxsBottommenu.emits, components = GenUniModulesIboxsAmapComponentsIboxsBottommenu.components, styles = GenUniModulesIboxsAmapComponentsIboxsBottommenu.styles)
}
, fun(instance, renderer): GenUniModulesIboxsAmapComponentsIboxsBottommenu {
    return GenUniModulesIboxsAmapComponentsIboxsBottommenu(instance)
}
)
val GenUniModulesIboxsAmapPagesShowlocationClass = CreateVueComponent(GenUniModulesIboxsAmapPagesShowlocation::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenUniModulesIboxsAmapPagesShowlocation.inheritAttrs, inject = GenUniModulesIboxsAmapPagesShowlocation.inject, props = GenUniModulesIboxsAmapPagesShowlocation.props, propsNeedCastKeys = GenUniModulesIboxsAmapPagesShowlocation.propsNeedCastKeys, emits = GenUniModulesIboxsAmapPagesShowlocation.emits, components = GenUniModulesIboxsAmapPagesShowlocation.components, styles = GenUniModulesIboxsAmapPagesShowlocation.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesIboxsAmapPagesShowlocation.setup(props as GenUniModulesIboxsAmapPagesShowlocation)
    }
    )
}
, fun(instance, renderer): GenUniModulesIboxsAmapPagesShowlocation {
    return GenUniModulesIboxsAmapPagesShowlocation(instance, renderer)
}
)
val GenComponentsXAllocateOrderClass = CreateVueComponent(GenComponentsXAllocateOrder::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXAllocateOrder.inheritAttrs, inject = GenComponentsXAllocateOrder.inject, props = GenComponentsXAllocateOrder.props, propsNeedCastKeys = GenComponentsXAllocateOrder.propsNeedCastKeys, emits = GenComponentsXAllocateOrder.emits, components = GenComponentsXAllocateOrder.components, styles = GenComponentsXAllocateOrder.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXAllocateOrder.setup(props as GenComponentsXAllocateOrder)
    }
    )
}
, fun(instance, renderer): GenComponentsXAllocateOrder {
    return GenComponentsXAllocateOrder(instance)
}
)
val GenPagesWarehouseAllocateAllocateClass = CreateVueComponent(GenPagesWarehouseAllocateAllocate::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesWarehouseAllocateAllocate.inheritAttrs, inject = GenPagesWarehouseAllocateAllocate.inject, props = GenPagesWarehouseAllocateAllocate.props, propsNeedCastKeys = GenPagesWarehouseAllocateAllocate.propsNeedCastKeys, emits = GenPagesWarehouseAllocateAllocate.emits, components = GenPagesWarehouseAllocateAllocate.components, styles = GenPagesWarehouseAllocateAllocate.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesWarehouseAllocateAllocate.setup(props as GenPagesWarehouseAllocateAllocate)
    }
    )
}
, fun(instance, renderer): GenPagesWarehouseAllocateAllocate {
    return GenPagesWarehouseAllocateAllocate(instance, renderer)
}
)
val GenUniModulesFirstuiUvueComponentsFuiSwitchFuiSwitchClass = CreateVueComponent(GenUniModulesFirstuiUvueComponentsFuiSwitchFuiSwitch::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesFirstuiUvueComponentsFuiSwitchFuiSwitch.name, inheritAttrs = GenUniModulesFirstuiUvueComponentsFuiSwitchFuiSwitch.inheritAttrs, inject = GenUniModulesFirstuiUvueComponentsFuiSwitchFuiSwitch.inject, props = GenUniModulesFirstuiUvueComponentsFuiSwitchFuiSwitch.props, propsNeedCastKeys = GenUniModulesFirstuiUvueComponentsFuiSwitchFuiSwitch.propsNeedCastKeys, emits = GenUniModulesFirstuiUvueComponentsFuiSwitchFuiSwitch.emits, components = GenUniModulesFirstuiUvueComponentsFuiSwitchFuiSwitch.components, styles = GenUniModulesFirstuiUvueComponentsFuiSwitchFuiSwitch.styles)
}
, fun(instance, renderer): GenUniModulesFirstuiUvueComponentsFuiSwitchFuiSwitch {
    return GenUniModulesFirstuiUvueComponentsFuiSwitchFuiSwitch(instance)
}
)
open class allocategoodsinfo (
    @JsonNotNull
    open var goodsinfo: UTSJSONObject,
    @JsonNotNull
    open var stock: Number,
    @JsonNotNull
    open var number: Number,
    @JsonNotNull
    open var id: Number,
    open var remark: String? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return allocategoodsinfoReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class allocategoodsinfoReactiveObject : allocategoodsinfo, IUTSReactive<allocategoodsinfo> {
    override var __v_raw: allocategoodsinfo
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: allocategoodsinfo, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(goodsinfo = __v_raw.goodsinfo, stock = __v_raw.stock, number = __v_raw.number, id = __v_raw.id, remark = __v_raw.remark) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): allocategoodsinfoReactiveObject {
        return allocategoodsinfoReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var goodsinfo: UTSJSONObject
        get() {
            return _tRG(__v_raw, "goodsinfo", __v_raw.goodsinfo, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("goodsinfo")) {
                return
            }
            val oldValue = __v_raw.goodsinfo
            __v_raw.goodsinfo = value
            _tRS(__v_raw, "goodsinfo", oldValue, value)
        }
    override var stock: Number
        get() {
            return _tRG(__v_raw, "stock", __v_raw.stock, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("stock")) {
                return
            }
            val oldValue = __v_raw.stock
            __v_raw.stock = value
            _tRS(__v_raw, "stock", oldValue, value)
        }
    override var number: Number
        get() {
            return _tRG(__v_raw, "number", __v_raw.number, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("number")) {
                return
            }
            val oldValue = __v_raw.number
            __v_raw.number = value
            _tRS(__v_raw, "number", oldValue, value)
        }
    override var id: Number
        get() {
            return _tRG(__v_raw, "id", __v_raw.id, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("id")) {
                return
            }
            val oldValue = __v_raw.id
            __v_raw.id = value
            _tRS(__v_raw, "id", oldValue, value)
        }
    override var remark: String?
        get() {
            return _tRG(__v_raw, "remark", __v_raw.remark, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("remark")) {
                return
            }
            val oldValue = __v_raw.remark
            __v_raw.remark = value
            _tRS(__v_raw, "remark", oldValue, value)
        }
}
val GenPagesWarehouseAllocateAddorderClass = CreateVueComponent(GenPagesWarehouseAllocateAddorder::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesWarehouseAllocateAddorder.inheritAttrs, inject = GenPagesWarehouseAllocateAddorder.inject, props = GenPagesWarehouseAllocateAddorder.props, propsNeedCastKeys = GenPagesWarehouseAllocateAddorder.propsNeedCastKeys, emits = GenPagesWarehouseAllocateAddorder.emits, components = GenPagesWarehouseAllocateAddorder.components, styles = GenPagesWarehouseAllocateAddorder.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesWarehouseAllocateAddorder.setup(props as GenPagesWarehouseAllocateAddorder)
    }
    )
}
, fun(instance, renderer): GenPagesWarehouseAllocateAddorder {
    return GenPagesWarehouseAllocateAddorder(instance, renderer)
}
)
val GenPagesCommonChooserequireorderClass = CreateVueComponent(GenPagesCommonChooserequireorder::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesCommonChooserequireorder.inheritAttrs, inject = GenPagesCommonChooserequireorder.inject, props = GenPagesCommonChooserequireorder.props, propsNeedCastKeys = GenPagesCommonChooserequireorder.propsNeedCastKeys, emits = GenPagesCommonChooserequireorder.emits, components = GenPagesCommonChooserequireorder.components, styles = GenPagesCommonChooserequireorder.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesCommonChooserequireorder.setup(props as GenPagesCommonChooserequireorder)
    }
    )
}
, fun(instance, renderer): GenPagesCommonChooserequireorder {
    return GenPagesCommonChooserequireorder(instance, renderer)
}
)
val GenPagesWarehouseAllocateViewClass = CreateVueComponent(GenPagesWarehouseAllocateView::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesWarehouseAllocateView.inheritAttrs, inject = GenPagesWarehouseAllocateView.inject, props = GenPagesWarehouseAllocateView.props, propsNeedCastKeys = GenPagesWarehouseAllocateView.propsNeedCastKeys, emits = GenPagesWarehouseAllocateView.emits, components = GenPagesWarehouseAllocateView.components, styles = GenPagesWarehouseAllocateView.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesWarehouseAllocateView.setup(props as GenPagesWarehouseAllocateView)
    }
    )
}
, fun(instance, renderer): GenPagesWarehouseAllocateView {
    return GenPagesWarehouseAllocateView(instance, renderer)
}
)
val GenPagesCommonChooseallocateorderClass = CreateVueComponent(GenPagesCommonChooseallocateorder::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesCommonChooseallocateorder.inheritAttrs, inject = GenPagesCommonChooseallocateorder.inject, props = GenPagesCommonChooseallocateorder.props, propsNeedCastKeys = GenPagesCommonChooseallocateorder.propsNeedCastKeys, emits = GenPagesCommonChooseallocateorder.emits, components = GenPagesCommonChooseallocateorder.components, styles = GenPagesCommonChooseallocateorder.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesCommonChooseallocateorder.setup(props as GenPagesCommonChooseallocateorder)
    }
    )
}
, fun(instance, renderer): GenPagesCommonChooseallocateorder {
    return GenPagesCommonChooseallocateorder(instance, renderer)
}
)
val GenComponentsXFloatButtonClass = CreateVueComponent(GenComponentsXFloatButton::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXFloatButton.inheritAttrs, inject = GenComponentsXFloatButton.inject, props = GenComponentsXFloatButton.props, propsNeedCastKeys = GenComponentsXFloatButton.propsNeedCastKeys, emits = GenComponentsXFloatButton.emits, components = GenComponentsXFloatButton.components, styles = GenComponentsXFloatButton.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXFloatButton.setup(props as GenComponentsXFloatButton)
    }
    )
}
, fun(instance, renderer): GenComponentsXFloatButton {
    return GenComponentsXFloatButton(instance)
}
)
val GenPagesCommonBrowserActionClass = CreateVueComponent(GenPagesCommonBrowserAction::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesCommonBrowserAction.inheritAttrs, inject = GenPagesCommonBrowserAction.inject, props = GenPagesCommonBrowserAction.props, propsNeedCastKeys = GenPagesCommonBrowserAction.propsNeedCastKeys, emits = GenPagesCommonBrowserAction.emits, components = GenPagesCommonBrowserAction.components, styles = GenPagesCommonBrowserAction.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesCommonBrowserAction.setup(props as GenPagesCommonBrowserAction)
    }
    )
}
, fun(instance, renderer): GenPagesCommonBrowserAction {
    return GenPagesCommonBrowserAction(instance, renderer)
}
)
val GenPagesCommonChoosesupplierClass = CreateVueComponent(GenPagesCommonChoosesupplier::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesCommonChoosesupplier.inheritAttrs, inject = GenPagesCommonChoosesupplier.inject, props = GenPagesCommonChoosesupplier.props, propsNeedCastKeys = GenPagesCommonChoosesupplier.propsNeedCastKeys, emits = GenPagesCommonChoosesupplier.emits, components = GenPagesCommonChoosesupplier.components, styles = GenPagesCommonChoosesupplier.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesCommonChoosesupplier.setup(props as GenPagesCommonChoosesupplier)
    }
    )
}
, fun(instance, renderer): GenPagesCommonChoosesupplier {
    return GenPagesCommonChoosesupplier(instance, renderer)
}
)
val GenPagesWarehouseInstorageViewClass = CreateVueComponent(GenPagesWarehouseInstorageView::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesWarehouseInstorageView.inheritAttrs, inject = GenPagesWarehouseInstorageView.inject, props = GenPagesWarehouseInstorageView.props, propsNeedCastKeys = GenPagesWarehouseInstorageView.propsNeedCastKeys, emits = GenPagesWarehouseInstorageView.emits, components = GenPagesWarehouseInstorageView.components, styles = GenPagesWarehouseInstorageView.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesWarehouseInstorageView.setup(props as GenPagesWarehouseInstorageView)
    }
    )
}
, fun(instance, renderer): GenPagesWarehouseInstorageView {
    return GenPagesWarehouseInstorageView(instance, renderer)
}
)
val GenComponentsXInstorageOrderClass = CreateVueComponent(GenComponentsXInstorageOrder::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXInstorageOrder.inheritAttrs, inject = GenComponentsXInstorageOrder.inject, props = GenComponentsXInstorageOrder.props, propsNeedCastKeys = GenComponentsXInstorageOrder.propsNeedCastKeys, emits = GenComponentsXInstorageOrder.emits, components = GenComponentsXInstorageOrder.components, styles = GenComponentsXInstorageOrder.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXInstorageOrder.setup(props as GenComponentsXInstorageOrder)
    }
    )
}
, fun(instance, renderer): GenComponentsXInstorageOrder {
    return GenComponentsXInstorageOrder(instance)
}
)
val GenPagesWarehouseInstorageInstorageClass = CreateVueComponent(GenPagesWarehouseInstorageInstorage::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesWarehouseInstorageInstorage.inheritAttrs, inject = GenPagesWarehouseInstorageInstorage.inject, props = GenPagesWarehouseInstorageInstorage.props, propsNeedCastKeys = GenPagesWarehouseInstorageInstorage.propsNeedCastKeys, emits = GenPagesWarehouseInstorageInstorage.emits, components = GenPagesWarehouseInstorageInstorage.components, styles = GenPagesWarehouseInstorageInstorage.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesWarehouseInstorageInstorage.setup(props as GenPagesWarehouseInstorageInstorage)
    }
    )
}
, fun(instance, renderer): GenPagesWarehouseInstorageInstorage {
    return GenPagesWarehouseInstorageInstorage(instance, renderer)
}
)
val GenComponentsXPageTitleClass = CreateVueComponent(GenComponentsXPageTitle::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXPageTitle.inheritAttrs, inject = GenComponentsXPageTitle.inject, props = GenComponentsXPageTitle.props, propsNeedCastKeys = GenComponentsXPageTitle.propsNeedCastKeys, emits = GenComponentsXPageTitle.emits, components = GenComponentsXPageTitle.components, styles = GenComponentsXPageTitle.styles)
}
, fun(instance, renderer): GenComponentsXPageTitle {
    return GenComponentsXPageTitle(instance)
}
)
val GenPagesUserMessageMsgboxClass = CreateVueComponent(GenPagesUserMessageMsgbox::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesUserMessageMsgbox.inheritAttrs, inject = GenPagesUserMessageMsgbox.inject, props = GenPagesUserMessageMsgbox.props, propsNeedCastKeys = GenPagesUserMessageMsgbox.propsNeedCastKeys, emits = GenPagesUserMessageMsgbox.emits, components = GenPagesUserMessageMsgbox.components, styles = GenPagesUserMessageMsgbox.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesUserMessageMsgbox.setup(props as GenPagesUserMessageMsgbox)
    }
    )
}
, fun(instance, renderer): GenPagesUserMessageMsgbox {
    return GenPagesUserMessageMsgbox(instance, renderer)
}
)
val GenPagesUserMessageSystemmsgClass = CreateVueComponent(GenPagesUserMessageSystemmsg::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesUserMessageSystemmsg.inheritAttrs, inject = GenPagesUserMessageSystemmsg.inject, props = GenPagesUserMessageSystemmsg.props, propsNeedCastKeys = GenPagesUserMessageSystemmsg.propsNeedCastKeys, emits = GenPagesUserMessageSystemmsg.emits, components = GenPagesUserMessageSystemmsg.components, styles = GenPagesUserMessageSystemmsg.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesUserMessageSystemmsg.setup(props as GenPagesUserMessageSystemmsg)
    }
    )
}
, fun(instance, renderer): GenPagesUserMessageSystemmsg {
    return GenPagesUserMessageSystemmsg(instance, renderer)
}
)
open class Message (
    @JsonNotNull
    open var type: String,
    @JsonNotNull
    open var content: String,
    @JsonNotNull
    open var time: String,
    @JsonNotNull
    open var isMe: Boolean = false,
    open var filename: String? = null,
    open var size: String? = null,
    open var thumb: String? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return MessageReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class MessageReactiveObject : Message, IUTSReactive<Message> {
    override var __v_raw: Message
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: Message, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(type = __v_raw.type, content = __v_raw.content, time = __v_raw.time, isMe = __v_raw.isMe, filename = __v_raw.filename, size = __v_raw.size, thumb = __v_raw.thumb) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): MessageReactiveObject {
        return MessageReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var type: String
        get() {
            return _tRG(__v_raw, "type", __v_raw.type, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("type")) {
                return
            }
            val oldValue = __v_raw.type
            __v_raw.type = value
            _tRS(__v_raw, "type", oldValue, value)
        }
    override var content: String
        get() {
            return _tRG(__v_raw, "content", __v_raw.content, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("content")) {
                return
            }
            val oldValue = __v_raw.content
            __v_raw.content = value
            _tRS(__v_raw, "content", oldValue, value)
        }
    override var time: String
        get() {
            return _tRG(__v_raw, "time", __v_raw.time, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("time")) {
                return
            }
            val oldValue = __v_raw.time
            __v_raw.time = value
            _tRS(__v_raw, "time", oldValue, value)
        }
    override var isMe: Boolean
        get() {
            return _tRG(__v_raw, "isMe", __v_raw.isMe, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("isMe")) {
                return
            }
            val oldValue = __v_raw.isMe
            __v_raw.isMe = value
            _tRS(__v_raw, "isMe", oldValue, value)
        }
    override var filename: String?
        get() {
            return _tRG(__v_raw, "filename", __v_raw.filename, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("filename")) {
                return
            }
            val oldValue = __v_raw.filename
            __v_raw.filename = value
            _tRS(__v_raw, "filename", oldValue, value)
        }
    override var size: String?
        get() {
            return _tRG(__v_raw, "size", __v_raw.size, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("size")) {
                return
            }
            val oldValue = __v_raw.size
            __v_raw.size = value
            _tRS(__v_raw, "size", oldValue, value)
        }
    override var thumb: String?
        get() {
            return _tRG(__v_raw, "thumb", __v_raw.thumb, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("thumb")) {
                return
            }
            val oldValue = __v_raw.thumb
            __v_raw.thumb = value
            _tRS(__v_raw, "thumb", oldValue, value)
        }
}
val GenPagesUserMessageChatmsgClass = CreateVueComponent(GenPagesUserMessageChatmsg::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesUserMessageChatmsg.inheritAttrs, inject = GenPagesUserMessageChatmsg.inject, props = GenPagesUserMessageChatmsg.props, propsNeedCastKeys = GenPagesUserMessageChatmsg.propsNeedCastKeys, emits = GenPagesUserMessageChatmsg.emits, components = GenPagesUserMessageChatmsg.components, styles = GenPagesUserMessageChatmsg.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesUserMessageChatmsg.setup(props as GenPagesUserMessageChatmsg)
    }
    )
}
, fun(instance, renderer): GenPagesUserMessageChatmsg {
    return GenPagesUserMessageChatmsg(instance, renderer)
}
)
open class GenUniModulesTmxUiComponentsTmxRollingNumberTmxRollingNumberSlotDataDefault (
    @JsonNotNull
    open var value: String,
    @JsonNotNull
    open var formattedValue: String,
) : SlotData()
val GenUniModulesTmxUiComponentsTmxRollingNumberTmxRollingNumberClass = CreateVueComponent(GenUniModulesTmxUiComponentsTmxRollingNumberTmxRollingNumber::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesTmxUiComponentsTmxRollingNumberTmxRollingNumber.name, inheritAttrs = GenUniModulesTmxUiComponentsTmxRollingNumberTmxRollingNumber.inheritAttrs, inject = GenUniModulesTmxUiComponentsTmxRollingNumberTmxRollingNumber.inject, props = GenUniModulesTmxUiComponentsTmxRollingNumberTmxRollingNumber.props, propsNeedCastKeys = GenUniModulesTmxUiComponentsTmxRollingNumberTmxRollingNumber.propsNeedCastKeys, emits = GenUniModulesTmxUiComponentsTmxRollingNumberTmxRollingNumber.emits, components = GenUniModulesTmxUiComponentsTmxRollingNumberTmxRollingNumber.components, styles = GenUniModulesTmxUiComponentsTmxRollingNumberTmxRollingNumber.styles, setup = fun(props: ComponentPublicInstance, ctx: SetupContext): Any? {
        return GenUniModulesTmxUiComponentsTmxRollingNumberTmxRollingNumber.setup(props as GenUniModulesTmxUiComponentsTmxRollingNumberTmxRollingNumber, ctx)
    }
    )
}
, fun(instance, renderer): GenUniModulesTmxUiComponentsTmxRollingNumberTmxRollingNumber {
    return GenUniModulesTmxUiComponentsTmxRollingNumberTmxRollingNumber(instance)
}
)
fun escapeStr(s: String): String {
    var result = ""
    run {
        var i: Number = 0
        while(i < s.length){
            var c = s.charAt(i)
            if (c == "\\") {
                result += "\\\\"
            } else if (c == "\"") {
                result += "\\\""
            } else if (c == "'") {
                result += "\\'"
            } else if (c == "\n") {
                result += "\\n"
            } else if (c == "\r") {
                result += "\\r"
            } else if (c == "\t") {
                result += "\\t"
            } else {
                result += c
            }
            i++
        }
    }
    return result
}
fun escapeFuncBody(s: String): String {
    var result = ""
    var i: Number = 0
    while(i < s.length){
        var c = s.charAt(i)
        if (c == "\\") {
            result += c
            i++
            if (i < s.length) {
                result += s.charAt(i)
            }
        } else if (c == "'") {
            result += "\\'"
        } else {
            result += c
        }
        i++
    }
    return result
}
fun isFuncLike(s: String): Boolean {
    var t = s.trim()
    if (t.startsWith("__STR__")) {
        return false
    }
    if (t.startsWith("function")) {
        return true
    }
    var arrowIdx = t.indexOf("=>")
    if (arrowIdx > 0) {
        var afterArrow = t.substring(arrowIdx + 2).trim()
        if (afterArrow.startsWith("{") || afterArrow.startsWith("(") || afterArrow.startsWith("[") || afterArrow.indexOf(".") > -1 || afterArrow.indexOf("+") > -1 || afterArrow.indexOf("return") > -1) {
            return true
        }
    }
    return false
}
fun serializeValue(kVal: Any?): String {
    if (kVal == null) {
        return "null"
    }
    var t = UTSAndroid.`typeof`(kVal)
    if (t == "number") {
        return (kVal as Number).toString(10)
    }
    if (t == "boolean") {
        if (kVal as Boolean) {
            return "true"
        }
        return "false"
    }
    if (t == "function") {
        return escapeFuncBody(kVal!!.toString())
    }
    if (t == "string") {
        var sv = kVal as String
        if (sv.trim().startsWith("__STR__")) {
            return "\"" + escapeStr(sv.trim().substring(7)) + "\""
        }
        if (isFuncLike(sv)) {
            return escapeFuncBody(sv)
        }
        return "\"" + escapeStr(sv) + "\""
    }
    if (UTSArray.isArray(kVal)) {
        var arr = kVal as UTSArray<Any?>
        var parts: UTSArray<String> = _uA()
        run {
            var i: Number = 0
            while(i < arr.length){
                parts.push(serializeValue(arr[i]))
                i++
            }
        }
        return "[" + parts.join(",") + "]"
    }
    if (t == "object") {
        var obj = kVal as UTSJSONObject
        var entries = obj.toMap()
        var parts: UTSArray<String> = _uA()
        entries.forEach(fun(v: Any?, k: String){
            parts.push(k + ":" + serializeValue(v))
        }
        )
        return "{" + parts.join(",") + "}"
    }
    return "\"" + escapeStr(kVal!!.toString()) + "\""
}
fun optsJsonToStr(ops: Any): String {
    if (UTSAndroid.`typeof`(ops) == "string") {
        return ops as String
    }
    return serializeValue(ops)
}
typealias eventsType = (data: Any) -> Unit
val GenUniModulesTmxUiComponentsTmxEchartTmxEchartClass = CreateVueComponent(GenUniModulesTmxUiComponentsTmxEchartTmxEchart::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesTmxUiComponentsTmxEchartTmxEchart.name, inheritAttrs = GenUniModulesTmxUiComponentsTmxEchartTmxEchart.inheritAttrs, inject = GenUniModulesTmxUiComponentsTmxEchartTmxEchart.inject, props = GenUniModulesTmxUiComponentsTmxEchartTmxEchart.props, propsNeedCastKeys = GenUniModulesTmxUiComponentsTmxEchartTmxEchart.propsNeedCastKeys, emits = GenUniModulesTmxUiComponentsTmxEchartTmxEchart.emits, components = GenUniModulesTmxUiComponentsTmxEchartTmxEchart.components, styles = GenUniModulesTmxUiComponentsTmxEchartTmxEchart.styles, setup = fun(props: ComponentPublicInstance, ctx: SetupContext): Any? {
        return GenUniModulesTmxUiComponentsTmxEchartTmxEchart.setup(props as GenUniModulesTmxUiComponentsTmxEchartTmxEchart, ctx)
    }
    )
}
, fun(instance, renderer): GenUniModulesTmxUiComponentsTmxEchartTmxEchart {
    return GenUniModulesTmxUiComponentsTmxEchartTmxEchart(instance)
}
)
typealias TmxEchartComponentPublicInstance = GenUniModulesTmxUiComponentsTmxEchartTmxEchart
val GenComponentsXPageClass = CreateVueComponent(GenComponentsXPage::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXPage.inheritAttrs, inject = GenComponentsXPage.inject, props = GenComponentsXPage.props, propsNeedCastKeys = GenComponentsXPage.propsNeedCastKeys, emits = GenComponentsXPage.emits, components = GenComponentsXPage.components, styles = GenComponentsXPage.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXPage.setup(props as GenComponentsXPage)
    }
    )
}
, fun(instance, renderer): GenComponentsXPage {
    return GenComponentsXPage(instance)
}
)
val GenPagesAnalysisTodayanalysisClass = CreateVueComponent(GenPagesAnalysisTodayanalysis::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesAnalysisTodayanalysis.inheritAttrs, inject = GenPagesAnalysisTodayanalysis.inject, props = GenPagesAnalysisTodayanalysis.props, propsNeedCastKeys = GenPagesAnalysisTodayanalysis.propsNeedCastKeys, emits = GenPagesAnalysisTodayanalysis.emits, components = GenPagesAnalysisTodayanalysis.components, styles = GenPagesAnalysisTodayanalysis.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesAnalysisTodayanalysis.setup(props as GenPagesAnalysisTodayanalysis)
    }
    )
}
, fun(instance, renderer): GenPagesAnalysisTodayanalysis {
    return GenPagesAnalysisTodayanalysis(instance, renderer)
}
)
open class outstoragegoodsinfo (
    @JsonNotNull
    open var goodsinfo: UTSJSONObject,
    @JsonNotNull
    open var number: Number,
    @JsonNotNull
    open var id: Number,
    open var remark: String? = null,
    @JsonNotNull
    open var price: Number,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return outstoragegoodsinfoReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class outstoragegoodsinfoReactiveObject : outstoragegoodsinfo, IUTSReactive<outstoragegoodsinfo> {
    override var __v_raw: outstoragegoodsinfo
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: outstoragegoodsinfo, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(goodsinfo = __v_raw.goodsinfo, number = __v_raw.number, id = __v_raw.id, remark = __v_raw.remark, price = __v_raw.price) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): outstoragegoodsinfoReactiveObject {
        return outstoragegoodsinfoReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var goodsinfo: UTSJSONObject
        get() {
            return _tRG(__v_raw, "goodsinfo", __v_raw.goodsinfo, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("goodsinfo")) {
                return
            }
            val oldValue = __v_raw.goodsinfo
            __v_raw.goodsinfo = value
            _tRS(__v_raw, "goodsinfo", oldValue, value)
        }
    override var number: Number
        get() {
            return _tRG(__v_raw, "number", __v_raw.number, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("number")) {
                return
            }
            val oldValue = __v_raw.number
            __v_raw.number = value
            _tRS(__v_raw, "number", oldValue, value)
        }
    override var id: Number
        get() {
            return _tRG(__v_raw, "id", __v_raw.id, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("id")) {
                return
            }
            val oldValue = __v_raw.id
            __v_raw.id = value
            _tRS(__v_raw, "id", oldValue, value)
        }
    override var remark: String?
        get() {
            return _tRG(__v_raw, "remark", __v_raw.remark, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("remark")) {
                return
            }
            val oldValue = __v_raw.remark
            __v_raw.remark = value
            _tRS(__v_raw, "remark", oldValue, value)
        }
    override var price: Number
        get() {
            return _tRG(__v_raw, "price", __v_raw.price, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("price")) {
                return
            }
            val oldValue = __v_raw.price
            __v_raw.price = value
            _tRS(__v_raw, "price", oldValue, value)
        }
}
val GenPagesWarehouseOutstorageAddoutstorageClass = CreateVueComponent(GenPagesWarehouseOutstorageAddoutstorage::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesWarehouseOutstorageAddoutstorage.inheritAttrs, inject = GenPagesWarehouseOutstorageAddoutstorage.inject, props = GenPagesWarehouseOutstorageAddoutstorage.props, propsNeedCastKeys = GenPagesWarehouseOutstorageAddoutstorage.propsNeedCastKeys, emits = GenPagesWarehouseOutstorageAddoutstorage.emits, components = GenPagesWarehouseOutstorageAddoutstorage.components, styles = GenPagesWarehouseOutstorageAddoutstorage.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesWarehouseOutstorageAddoutstorage.setup(props as GenPagesWarehouseOutstorageAddoutstorage)
    }
    )
}
, fun(instance, renderer): GenPagesWarehouseOutstorageAddoutstorage {
    return GenPagesWarehouseOutstorageAddoutstorage(instance, renderer)
}
)
val GenPagesWarehouseOutstorageOutstorageClass = CreateVueComponent(GenPagesWarehouseOutstorageOutstorage::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesWarehouseOutstorageOutstorage.inheritAttrs, inject = GenPagesWarehouseOutstorageOutstorage.inject, props = GenPagesWarehouseOutstorageOutstorage.props, propsNeedCastKeys = GenPagesWarehouseOutstorageOutstorage.propsNeedCastKeys, emits = GenPagesWarehouseOutstorageOutstorage.emits, components = GenPagesWarehouseOutstorageOutstorage.components, styles = GenPagesWarehouseOutstorageOutstorage.styles)
}
, fun(instance, renderer): GenPagesWarehouseOutstorageOutstorage {
    return GenPagesWarehouseOutstorageOutstorage(instance, renderer)
}
)
val GenPagesWarehouseOutstorageViewClass = CreateVueComponent(GenPagesWarehouseOutstorageView::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesWarehouseOutstorageView.inheritAttrs, inject = GenPagesWarehouseOutstorageView.inject, props = GenPagesWarehouseOutstorageView.props, propsNeedCastKeys = GenPagesWarehouseOutstorageView.propsNeedCastKeys, emits = GenPagesWarehouseOutstorageView.emits, components = GenPagesWarehouseOutstorageView.components, styles = GenPagesWarehouseOutstorageView.styles)
}
, fun(instance, renderer): GenPagesWarehouseOutstorageView {
    return GenPagesWarehouseOutstorageView(instance, renderer)
}
)
val GenComponentsXRollingNumberClass = CreateVueComponent(GenComponentsXRollingNumber::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXRollingNumber.inheritAttrs, inject = GenComponentsXRollingNumber.inject, props = GenComponentsXRollingNumber.props, propsNeedCastKeys = GenComponentsXRollingNumber.propsNeedCastKeys, emits = GenComponentsXRollingNumber.emits, components = GenComponentsXRollingNumber.components, styles = GenComponentsXRollingNumber.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXRollingNumber.setup(props as GenComponentsXRollingNumber)
    }
    )
}
, fun(instance, renderer): GenComponentsXRollingNumber {
    return GenComponentsXRollingNumber(instance)
}
)
open class DebounceMapType (
    open var timer: Number? = null,
    open var lastArgs: Any? = null,
) : UTSObject()
open class ThrottleMapType (
    open var timer: Number? = null,
    @JsonNotNull
    open var lastExecTime: Number,
) : UTSObject()
open class useTool {
    companion object {
        var instanceReal: useTool? = null
        var debounceKeys = Map<String, DebounceMapType>()
        var throttleKeys = Map<String, ThrottleMapType>()
        public fun getInstance(): useTool {
            if (useTool.instanceReal == null) {
                useTool.instanceReal = useTool()
            }
            return useTool.instanceReal!!
        }
        public fun getRandomKey(prefix: String = "tmx", isUseUquid: Boolean = true): String {
            val key = prefix + "-" + Math.random().toString(16).substring(4)
            return if (isUseUquid) {
                key
            } else {
                prefix
            }
        }
        public fun debounce(key: String, func: () -> Unit, delay: Number = 300, immediate: Boolean = false): Unit {
            val newRecord = DebounceMapType(timer = null, lastArgs = null)
            val record = useTool.debounceKeys.get(key) ?: newRecord
            if (record.timer != null) {
                clearTimeout(record.timer!!)
                useTool.debounceKeys.`delete`(key)
            }
            if (immediate) {
                if (record.timer == null) {
                    func()
                }
                record.timer = setTimeout(fun(){
                    record.timer = null
                    useTool.debounceKeys.`delete`(key)
                }, delay)
            } else {
                record.timer = setTimeout(fun(){
                    func()
                    record.timer = null
                    useTool.debounceKeys.`delete`(key)
                }
                , delay)
            }
            useTool.debounceKeys.set(key, record)
        }
        public fun throttle(key: String, func: () -> Unit, delay: Number = 300): Unit {
            val now = Date.now()
            val newRecord = ThrottleMapType(timer = null, lastExecTime = 0)
            val record = useTool.throttleKeys.get(key) ?: newRecord
            if (now - record.lastExecTime < delay) {
                return
            }
            if (record.timer != null) {
                clearTimeout(record.timer!!)
                useTool.throttleKeys.`delete`(key)
            }
            func()
            record.lastExecTime = now
            useTool.throttleKeys.set(key, record)
        }
        public fun findParentVueComponent(parent: VueComponent?, comName: String): VueComponent? {
            if (parent == null) {
                return null
            }
            if ((parent.`$parent`?.`$options`?.name?.indexOf(comName) ?: -1) > -1) {
                return parent.`$parent`
            }
            var parents = useTool.findParentVueComponent(parent.`$parent`, comName)
            if ((parents?.`$options`?.name?.indexOf(comName) ?: -1) > -1) {
                return parents
            }
            return null
        }
    }
}
open class XDROPDOWN_LISTITEM_TYPE (
    @JsonNotNull
    open var id: String,
    @JsonNotNull
    open var data: XDROPDOWN_LISTITEM_INFO_TYPE,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return XDROPDOWN_LISTITEM_TYPEReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class XDROPDOWN_LISTITEM_TYPEReactiveObject : XDROPDOWN_LISTITEM_TYPE, IUTSReactive<XDROPDOWN_LISTITEM_TYPE> {
    override var __v_raw: XDROPDOWN_LISTITEM_TYPE
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: XDROPDOWN_LISTITEM_TYPE, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(id = __v_raw.id, data = __v_raw.data) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): XDROPDOWN_LISTITEM_TYPEReactiveObject {
        return XDROPDOWN_LISTITEM_TYPEReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var id: String
        get() {
            return _tRG(__v_raw, "id", __v_raw.id, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("id")) {
                return
            }
            val oldValue = __v_raw.id
            __v_raw.id = value
            _tRS(__v_raw, "id", oldValue, value)
        }
    override var data: XDROPDOWN_LISTITEM_INFO_TYPE
        get() {
            return _tRG(__v_raw, "data", __v_raw.data, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("data")) {
                return
            }
            val oldValue = __v_raw.data
            __v_raw.data = value
            _tRS(__v_raw, "data", oldValue, value)
        }
}
val GenUniModulesTmxUiComponentsTmxDropdownMenuTmxDropdownMenuClass = CreateVueComponent(GenUniModulesTmxUiComponentsTmxDropdownMenuTmxDropdownMenu::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesTmxUiComponentsTmxDropdownMenuTmxDropdownMenu.name, inheritAttrs = GenUniModulesTmxUiComponentsTmxDropdownMenuTmxDropdownMenu.inheritAttrs, inject = GenUniModulesTmxUiComponentsTmxDropdownMenuTmxDropdownMenu.inject, props = GenUniModulesTmxUiComponentsTmxDropdownMenuTmxDropdownMenu.props, propsNeedCastKeys = GenUniModulesTmxUiComponentsTmxDropdownMenuTmxDropdownMenu.propsNeedCastKeys, emits = GenUniModulesTmxUiComponentsTmxDropdownMenuTmxDropdownMenu.emits, components = GenUniModulesTmxUiComponentsTmxDropdownMenuTmxDropdownMenu.components, styles = GenUniModulesTmxUiComponentsTmxDropdownMenuTmxDropdownMenu.styles, setup = fun(props: ComponentPublicInstance, ctx: SetupContext): Any? {
        return GenUniModulesTmxUiComponentsTmxDropdownMenuTmxDropdownMenu.setup(props as GenUniModulesTmxUiComponentsTmxDropdownMenuTmxDropdownMenu, ctx)
    }
    )
}
, fun(instance, renderer): GenUniModulesTmxUiComponentsTmxDropdownMenuTmxDropdownMenu {
    return GenUniModulesTmxUiComponentsTmxDropdownMenuTmxDropdownMenu(instance)
}
)
typealias TmxDropdownMenuComponentPublicInstance = GenUniModulesTmxUiComponentsTmxDropdownMenuTmxDropdownMenu
val GenUniModulesTmxUiComponentsTmxDropdownItemTmxDropdownItemClass = CreateVueComponent(GenUniModulesTmxUiComponentsTmxDropdownItemTmxDropdownItem::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesTmxUiComponentsTmxDropdownItemTmxDropdownItem.name, inheritAttrs = GenUniModulesTmxUiComponentsTmxDropdownItemTmxDropdownItem.inheritAttrs, inject = GenUniModulesTmxUiComponentsTmxDropdownItemTmxDropdownItem.inject, props = GenUniModulesTmxUiComponentsTmxDropdownItemTmxDropdownItem.props, propsNeedCastKeys = GenUniModulesTmxUiComponentsTmxDropdownItemTmxDropdownItem.propsNeedCastKeys, emits = GenUniModulesTmxUiComponentsTmxDropdownItemTmxDropdownItem.emits, components = GenUniModulesTmxUiComponentsTmxDropdownItemTmxDropdownItem.components, styles = GenUniModulesTmxUiComponentsTmxDropdownItemTmxDropdownItem.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesTmxUiComponentsTmxDropdownItemTmxDropdownItem.setup(props as GenUniModulesTmxUiComponentsTmxDropdownItemTmxDropdownItem)
    }
    )
}
, fun(instance, renderer): GenUniModulesTmxUiComponentsTmxDropdownItemTmxDropdownItem {
    return GenUniModulesTmxUiComponentsTmxDropdownItemTmxDropdownItem(instance)
}
)
typealias findNodePathType = (nodes: UTSArray<CASCADER_ITEM_INFO>, targetId: String, currentPath: UTSArray<CASCADER_ITEM_INFO>) -> UTSArray<CASCADER_ITEM_INFO>?
typealias findNodeLayersType = (nodes: UTSArray<CASCADER_ITEM_INFO>, targetId: String, currentLayers: UTSArray<UTSArray<CASCADER_ITEM_INFO>>) -> UTSArray<UTSArray<CASCADER_ITEM_INFO>>?
open class menuTypeCascaderType (
    @JsonNotNull
    open var selected: Boolean = false,
    @JsonNotNull
    open var item: CASCADER_ITEM_INFO,
) : UTSObject()
val GenUniModulesTmxUiComponentsTmxCascaderTmxCascaderClass = CreateVueComponent(GenUniModulesTmxUiComponentsTmxCascaderTmxCascader::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesTmxUiComponentsTmxCascaderTmxCascader.name, inheritAttrs = GenUniModulesTmxUiComponentsTmxCascaderTmxCascader.inheritAttrs, inject = GenUniModulesTmxUiComponentsTmxCascaderTmxCascader.inject, props = GenUniModulesTmxUiComponentsTmxCascaderTmxCascader.props, propsNeedCastKeys = GenUniModulesTmxUiComponentsTmxCascaderTmxCascader.propsNeedCastKeys, emits = GenUniModulesTmxUiComponentsTmxCascaderTmxCascader.emits, components = GenUniModulesTmxUiComponentsTmxCascaderTmxCascader.components, styles = GenUniModulesTmxUiComponentsTmxCascaderTmxCascader.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesTmxUiComponentsTmxCascaderTmxCascader.setup(props as GenUniModulesTmxUiComponentsTmxCascaderTmxCascader)
    }
    )
}
, fun(instance, renderer): GenUniModulesTmxUiComponentsTmxCascaderTmxCascader {
    return GenUniModulesTmxUiComponentsTmxCascaderTmxCascader(instance)
}
)
val GenComponentsXGoodsitemClass = CreateVueComponent(GenComponentsXGoodsitem::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXGoodsitem.inheritAttrs, inject = GenComponentsXGoodsitem.inject, props = GenComponentsXGoodsitem.props, propsNeedCastKeys = GenComponentsXGoodsitem.propsNeedCastKeys, emits = GenComponentsXGoodsitem.emits, components = GenComponentsXGoodsitem.components, styles = GenComponentsXGoodsitem.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXGoodsitem.setup(props as GenComponentsXGoodsitem)
    }
    )
}
, fun(instance, renderer): GenComponentsXGoodsitem {
    return GenComponentsXGoodsitem(instance)
}
)
open class xCellItemType (
    @JsonNotNull
    open var icon: String,
    @JsonNotNull
    open var title: String,
    @JsonNotNull
    open var desc: String,
    @JsonNotNull
    open var label: String,
    @JsonNotNull
    open var bottom: Boolean = false,
    @JsonNotNull
    open var link: Boolean = false,
    @JsonNotNull
    open var url: String,
    @JsonNotNull
    open var iconColor: String,
    @JsonNotNull
    open var labelColor: String,
    @JsonNotNull
    open var card: Boolean = false,
) : UTSObject()
open class GenUniModulesTmxUiComponentsTmxCellTmxCellSlotDataAvatar (
    @JsonNotNull
    open var icon: String,
) : SlotData()
open class GenUniModulesTmxUiComponentsTmxCellTmxCellSlotDataDesc (
    @JsonNotNull
    open var desc: String,
) : SlotData()
open class GenUniModulesTmxUiComponentsTmxCellTmxCellSlotDataLabel (
    @JsonNotNull
    open var label: String,
) : SlotData()
val GenUniModulesTmxUiComponentsTmxCellTmxCellClass = CreateVueComponent(GenUniModulesTmxUiComponentsTmxCellTmxCell::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesTmxUiComponentsTmxCellTmxCell.name, inheritAttrs = GenUniModulesTmxUiComponentsTmxCellTmxCell.inheritAttrs, inject = GenUniModulesTmxUiComponentsTmxCellTmxCell.inject, props = GenUniModulesTmxUiComponentsTmxCellTmxCell.props, propsNeedCastKeys = GenUniModulesTmxUiComponentsTmxCellTmxCell.propsNeedCastKeys, emits = GenUniModulesTmxUiComponentsTmxCellTmxCell.emits, components = GenUniModulesTmxUiComponentsTmxCellTmxCell.components, styles = GenUniModulesTmxUiComponentsTmxCellTmxCell.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesTmxUiComponentsTmxCellTmxCell.setup(props as GenUniModulesTmxUiComponentsTmxCellTmxCell)
    }
    )
}
, fun(instance, renderer): GenUniModulesTmxUiComponentsTmxCellTmxCell {
    return GenUniModulesTmxUiComponentsTmxCellTmxCell(instance)
}
)
open class POSITION_TYPE_XY__1 (
    @JsonNotNull
    open var x: Number,
    @JsonNotNull
    open var y: Number,
) : UTSObject()
open class GenUniModulesTmxUiComponentsTmxSwitchSliderTmxSwitchSliderSlotDataDefault (
    @JsonNotNull
    open var status: Boolean = false,
) : SlotData()
open class GenUniModulesTmxUiComponentsTmxSwitchSliderTmxSwitchSliderSlotDataMenu (
    @JsonNotNull
    open var status: Boolean = false,
) : SlotData()
val GenUniModulesTmxUiComponentsTmxSwitchSliderTmxSwitchSliderClass = CreateVueComponent(GenUniModulesTmxUiComponentsTmxSwitchSliderTmxSwitchSlider::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenUniModulesTmxUiComponentsTmxSwitchSliderTmxSwitchSlider.inheritAttrs, inject = GenUniModulesTmxUiComponentsTmxSwitchSliderTmxSwitchSlider.inject, props = GenUniModulesTmxUiComponentsTmxSwitchSliderTmxSwitchSlider.props, propsNeedCastKeys = GenUniModulesTmxUiComponentsTmxSwitchSliderTmxSwitchSlider.propsNeedCastKeys, emits = GenUniModulesTmxUiComponentsTmxSwitchSliderTmxSwitchSlider.emits, components = GenUniModulesTmxUiComponentsTmxSwitchSliderTmxSwitchSlider.components, styles = GenUniModulesTmxUiComponentsTmxSwitchSliderTmxSwitchSlider.styles)
}
, fun(instance, renderer): GenUniModulesTmxUiComponentsTmxSwitchSliderTmxSwitchSlider {
    return GenUniModulesTmxUiComponentsTmxSwitchSliderTmxSwitchSlider(instance)
}
)
val GenComponentsXListmenuClass = CreateVueComponent(GenComponentsXListmenu::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXListmenu.inheritAttrs, inject = GenComponentsXListmenu.inject, props = GenComponentsXListmenu.props, propsNeedCastKeys = GenComponentsXListmenu.propsNeedCastKeys, emits = GenComponentsXListmenu.emits, components = GenComponentsXListmenu.components, styles = GenComponentsXListmenu.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXListmenu.setup(props as GenComponentsXListmenu)
    }
    )
}
, fun(instance, renderer): GenComponentsXListmenu {
    return GenComponentsXListmenu(instance)
}
)
val GenComponentsXDrawerClass = CreateVueComponent(GenComponentsXDrawer::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXDrawer.inheritAttrs, inject = GenComponentsXDrawer.inject, props = GenComponentsXDrawer.props, propsNeedCastKeys = GenComponentsXDrawer.propsNeedCastKeys, emits = GenComponentsXDrawer.emits, components = GenComponentsXDrawer.components, styles = GenComponentsXDrawer.styles, setup = fun(props: ComponentPublicInstance, ctx: SetupContext): Any? {
        return GenComponentsXDrawer.setup(props as GenComponentsXDrawer, ctx)
    }
    )
}
, fun(instance, renderer): GenComponentsXDrawer {
    return GenComponentsXDrawer(instance)
}
)
val GenPagesGoodsIndexClass = CreateVueComponent(GenPagesGoodsIndex::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesGoodsIndex.inheritAttrs, inject = GenPagesGoodsIndex.inject, props = GenPagesGoodsIndex.props, propsNeedCastKeys = GenPagesGoodsIndex.propsNeedCastKeys, emits = GenPagesGoodsIndex.emits, components = GenPagesGoodsIndex.components, styles = GenPagesGoodsIndex.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesGoodsIndex.setup(props as GenPagesGoodsIndex)
    }
    )
}
, fun(instance, renderer): GenPagesGoodsIndex {
    return GenPagesGoodsIndex(instance, renderer)
}
)
val GenPagesTestPdfClass = CreateVueComponent(GenPagesTestPdf::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesTestPdf.inheritAttrs, inject = GenPagesTestPdf.inject, props = GenPagesTestPdf.props, propsNeedCastKeys = GenPagesTestPdf.propsNeedCastKeys, emits = GenPagesTestPdf.emits, components = GenPagesTestPdf.components, styles = GenPagesTestPdf.styles)
}
, fun(instance, renderer): GenPagesTestPdf {
    return GenPagesTestPdf(instance, renderer)
}
)
val GenPagesTestMapClass = CreateVueComponent(GenPagesTestMap::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesTestMap.inheritAttrs, inject = GenPagesTestMap.inject, props = GenPagesTestMap.props, propsNeedCastKeys = GenPagesTestMap.propsNeedCastKeys, emits = GenPagesTestMap.emits, components = GenPagesTestMap.components, styles = GenPagesTestMap.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesTestMap.setup(props as GenPagesTestMap)
    }
    )
}
, fun(instance, renderer): GenPagesTestMap {
    return GenPagesTestMap(instance, renderer)
}
)
typealias XTREEFLAT_LAYOUT = String
typealias XTREEFLAT_LINE_TYPE = String
open class XTREEFLAT_CONFIG (
    open var width: Number? = null,
    open var height: Number? = null,
    open var bgColor: String? = null,
    open var nodeBgColor: String? = null,
    open var fontColor: String? = null,
    open var fontSize: Number? = null,
    open var lineColor: String? = null,
    open var lineWidth: Number? = null,
    @JsonNotNull
    open var canvas: CanvasContext,
    @JsonNotNull
    open var nodeInfo: NodeInfo,
    open var padding: Number? = null,
    open var gutter: Number? = null,
    open var parentLineGutter: Number? = null,
    open var enbleOpenChildren: Boolean? = null,
    open var nodeRadius: Number? = null,
    open var layout: XTREEFLAT_LAYOUT? = null,
    open var lineType: XTREEFLAT_LINE_TYPE? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return XTREEFLAT_CONFIGReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class XTREEFLAT_CONFIGReactiveObject : XTREEFLAT_CONFIG, IUTSReactive<XTREEFLAT_CONFIG> {
    override var __v_raw: XTREEFLAT_CONFIG
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: XTREEFLAT_CONFIG, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(width = __v_raw.width, height = __v_raw.height, bgColor = __v_raw.bgColor, nodeBgColor = __v_raw.nodeBgColor, fontColor = __v_raw.fontColor, fontSize = __v_raw.fontSize, lineColor = __v_raw.lineColor, lineWidth = __v_raw.lineWidth, canvas = __v_raw.canvas, nodeInfo = __v_raw.nodeInfo, padding = __v_raw.padding, gutter = __v_raw.gutter, parentLineGutter = __v_raw.parentLineGutter, enbleOpenChildren = __v_raw.enbleOpenChildren, nodeRadius = __v_raw.nodeRadius, layout = __v_raw.layout, lineType = __v_raw.lineType) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): XTREEFLAT_CONFIGReactiveObject {
        return XTREEFLAT_CONFIGReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var width: Number?
        get() {
            return _tRG(__v_raw, "width", __v_raw.width, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("width")) {
                return
            }
            val oldValue = __v_raw.width
            __v_raw.width = value
            _tRS(__v_raw, "width", oldValue, value)
        }
    override var height: Number?
        get() {
            return _tRG(__v_raw, "height", __v_raw.height, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("height")) {
                return
            }
            val oldValue = __v_raw.height
            __v_raw.height = value
            _tRS(__v_raw, "height", oldValue, value)
        }
    override var bgColor: String?
        get() {
            return _tRG(__v_raw, "bgColor", __v_raw.bgColor, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("bgColor")) {
                return
            }
            val oldValue = __v_raw.bgColor
            __v_raw.bgColor = value
            _tRS(__v_raw, "bgColor", oldValue, value)
        }
    override var nodeBgColor: String?
        get() {
            return _tRG(__v_raw, "nodeBgColor", __v_raw.nodeBgColor, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("nodeBgColor")) {
                return
            }
            val oldValue = __v_raw.nodeBgColor
            __v_raw.nodeBgColor = value
            _tRS(__v_raw, "nodeBgColor", oldValue, value)
        }
    override var fontColor: String?
        get() {
            return _tRG(__v_raw, "fontColor", __v_raw.fontColor, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("fontColor")) {
                return
            }
            val oldValue = __v_raw.fontColor
            __v_raw.fontColor = value
            _tRS(__v_raw, "fontColor", oldValue, value)
        }
    override var fontSize: Number?
        get() {
            return _tRG(__v_raw, "fontSize", __v_raw.fontSize, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("fontSize")) {
                return
            }
            val oldValue = __v_raw.fontSize
            __v_raw.fontSize = value
            _tRS(__v_raw, "fontSize", oldValue, value)
        }
    override var lineColor: String?
        get() {
            return _tRG(__v_raw, "lineColor", __v_raw.lineColor, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("lineColor")) {
                return
            }
            val oldValue = __v_raw.lineColor
            __v_raw.lineColor = value
            _tRS(__v_raw, "lineColor", oldValue, value)
        }
    override var lineWidth: Number?
        get() {
            return _tRG(__v_raw, "lineWidth", __v_raw.lineWidth, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("lineWidth")) {
                return
            }
            val oldValue = __v_raw.lineWidth
            __v_raw.lineWidth = value
            _tRS(__v_raw, "lineWidth", oldValue, value)
        }
    override var canvas: CanvasContext
        get() {
            return _tRG(__v_raw, "canvas", __v_raw.canvas, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("canvas")) {
                return
            }
            val oldValue = __v_raw.canvas
            __v_raw.canvas = value
            _tRS(__v_raw, "canvas", oldValue, value)
        }
    override var nodeInfo: NodeInfo
        get() {
            return _tRG(__v_raw, "nodeInfo", __v_raw.nodeInfo, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("nodeInfo")) {
                return
            }
            val oldValue = __v_raw.nodeInfo
            __v_raw.nodeInfo = value
            _tRS(__v_raw, "nodeInfo", oldValue, value)
        }
    override var padding: Number?
        get() {
            return _tRG(__v_raw, "padding", __v_raw.padding, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("padding")) {
                return
            }
            val oldValue = __v_raw.padding
            __v_raw.padding = value
            _tRS(__v_raw, "padding", oldValue, value)
        }
    override var gutter: Number?
        get() {
            return _tRG(__v_raw, "gutter", __v_raw.gutter, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("gutter")) {
                return
            }
            val oldValue = __v_raw.gutter
            __v_raw.gutter = value
            _tRS(__v_raw, "gutter", oldValue, value)
        }
    override var parentLineGutter: Number?
        get() {
            return _tRG(__v_raw, "parentLineGutter", __v_raw.parentLineGutter, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("parentLineGutter")) {
                return
            }
            val oldValue = __v_raw.parentLineGutter
            __v_raw.parentLineGutter = value
            _tRS(__v_raw, "parentLineGutter", oldValue, value)
        }
    override var enbleOpenChildren: Boolean?
        get() {
            return _tRG(__v_raw, "enbleOpenChildren", __v_raw.enbleOpenChildren, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("enbleOpenChildren")) {
                return
            }
            val oldValue = __v_raw.enbleOpenChildren
            __v_raw.enbleOpenChildren = value
            _tRS(__v_raw, "enbleOpenChildren", oldValue, value)
        }
    override var nodeRadius: Number?
        get() {
            return _tRG(__v_raw, "nodeRadius", __v_raw.nodeRadius, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("nodeRadius")) {
                return
            }
            val oldValue = __v_raw.nodeRadius
            __v_raw.nodeRadius = value
            _tRS(__v_raw, "nodeRadius", oldValue, value)
        }
    override var layout: XTREEFLAT_LAYOUT?
        get() {
            return _tRG(__v_raw, "layout", __v_raw.layout, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("layout")) {
                return
            }
            val oldValue = __v_raw.layout
            __v_raw.layout = value
            _tRS(__v_raw, "layout", oldValue, value)
        }
    override var lineType: XTREEFLAT_LINE_TYPE?
        get() {
            return _tRG(__v_raw, "lineType", __v_raw.lineType, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("lineType")) {
                return
            }
            val oldValue = __v_raw.lineType
            __v_raw.lineType = value
            _tRS(__v_raw, "lineType", oldValue, value)
        }
}
open class XTREEFLAT_CHILDREN (
    @JsonNotNull
    open var id: Any,
    @JsonNotNull
    open var title: String,
    @JsonNotNull
    open var fontColor: String,
    @JsonNotNull
    open var bgColor: String,
    @JsonNotNull
    open var padding: Number,
    @JsonNotNull
    open var gutter: Number,
    @JsonNotNull
    open var parentLineGutter: Number,
    @JsonNotNull
    open var opened: Boolean = false,
    @JsonNotNull
    open var disabled: Boolean = false,
    @JsonNotNull
    open var selected: Boolean = false,
    @JsonNotNull
    open var fontSize: Number,
    @JsonNotNull
    open var children: UTSArray<XTREEFLAT_CHILDREN>,
    @JsonNotNull
    open var lineColor: String,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return XTREEFLAT_CHILDRENReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class XTREEFLAT_CHILDRENReactiveObject : XTREEFLAT_CHILDREN, IUTSReactive<XTREEFLAT_CHILDREN> {
    override var __v_raw: XTREEFLAT_CHILDREN
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: XTREEFLAT_CHILDREN, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(id = __v_raw.id, title = __v_raw.title, fontColor = __v_raw.fontColor, bgColor = __v_raw.bgColor, padding = __v_raw.padding, gutter = __v_raw.gutter, parentLineGutter = __v_raw.parentLineGutter, opened = __v_raw.opened, disabled = __v_raw.disabled, selected = __v_raw.selected, fontSize = __v_raw.fontSize, children = __v_raw.children, lineColor = __v_raw.lineColor) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): XTREEFLAT_CHILDRENReactiveObject {
        return XTREEFLAT_CHILDRENReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var id: Any
        get() {
            return _tRG(__v_raw, "id", __v_raw.id, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("id")) {
                return
            }
            val oldValue = __v_raw.id
            __v_raw.id = value
            _tRS(__v_raw, "id", oldValue, value)
        }
    override var title: String
        get() {
            return _tRG(__v_raw, "title", __v_raw.title, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("title")) {
                return
            }
            val oldValue = __v_raw.title
            __v_raw.title = value
            _tRS(__v_raw, "title", oldValue, value)
        }
    override var fontColor: String
        get() {
            return _tRG(__v_raw, "fontColor", __v_raw.fontColor, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("fontColor")) {
                return
            }
            val oldValue = __v_raw.fontColor
            __v_raw.fontColor = value
            _tRS(__v_raw, "fontColor", oldValue, value)
        }
    override var bgColor: String
        get() {
            return _tRG(__v_raw, "bgColor", __v_raw.bgColor, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("bgColor")) {
                return
            }
            val oldValue = __v_raw.bgColor
            __v_raw.bgColor = value
            _tRS(__v_raw, "bgColor", oldValue, value)
        }
    override var padding: Number
        get() {
            return _tRG(__v_raw, "padding", __v_raw.padding, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("padding")) {
                return
            }
            val oldValue = __v_raw.padding
            __v_raw.padding = value
            _tRS(__v_raw, "padding", oldValue, value)
        }
    override var gutter: Number
        get() {
            return _tRG(__v_raw, "gutter", __v_raw.gutter, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("gutter")) {
                return
            }
            val oldValue = __v_raw.gutter
            __v_raw.gutter = value
            _tRS(__v_raw, "gutter", oldValue, value)
        }
    override var parentLineGutter: Number
        get() {
            return _tRG(__v_raw, "parentLineGutter", __v_raw.parentLineGutter, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("parentLineGutter")) {
                return
            }
            val oldValue = __v_raw.parentLineGutter
            __v_raw.parentLineGutter = value
            _tRS(__v_raw, "parentLineGutter", oldValue, value)
        }
    override var opened: Boolean
        get() {
            return _tRG(__v_raw, "opened", __v_raw.opened, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("opened")) {
                return
            }
            val oldValue = __v_raw.opened
            __v_raw.opened = value
            _tRS(__v_raw, "opened", oldValue, value)
        }
    override var disabled: Boolean
        get() {
            return _tRG(__v_raw, "disabled", __v_raw.disabled, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("disabled")) {
                return
            }
            val oldValue = __v_raw.disabled
            __v_raw.disabled = value
            _tRS(__v_raw, "disabled", oldValue, value)
        }
    override var selected: Boolean
        get() {
            return _tRG(__v_raw, "selected", __v_raw.selected, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("selected")) {
                return
            }
            val oldValue = __v_raw.selected
            __v_raw.selected = value
            _tRS(__v_raw, "selected", oldValue, value)
        }
    override var fontSize: Number
        get() {
            return _tRG(__v_raw, "fontSize", __v_raw.fontSize, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("fontSize")) {
                return
            }
            val oldValue = __v_raw.fontSize
            __v_raw.fontSize = value
            _tRS(__v_raw, "fontSize", oldValue, value)
        }
    override var children: UTSArray<XTREEFLAT_CHILDREN>
        get() {
            return _tRG(__v_raw, "children", __v_raw.children, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("children")) {
                return
            }
            val oldValue = __v_raw.children
            __v_raw.children = value
            _tRS(__v_raw, "children", oldValue, value)
        }
    override var lineColor: String
        get() {
            return _tRG(__v_raw, "lineColor", __v_raw.lineColor, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("lineColor")) {
                return
            }
            val oldValue = __v_raw.lineColor
            __v_raw.lineColor = value
            _tRS(__v_raw, "lineColor", oldValue, value)
        }
}
open class XTREE_NODES_FLAT (
    @JsonNotNull
    open var node: XTREEFLAT_CHILDREN,
    @JsonNotNull
    open var x: Number,
    @JsonNotNull
    open var y: Number,
    @JsonNotNull
    open var width: Number,
    @JsonNotNull
    open var height: Number,
    @JsonNotNull
    open var level: Number,
    open var parent: XTREEFLAT_CHILDREN? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return XTREE_NODES_FLATReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class XTREE_NODES_FLATReactiveObject : XTREE_NODES_FLAT, IUTSReactive<XTREE_NODES_FLAT> {
    override var __v_raw: XTREE_NODES_FLAT
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: XTREE_NODES_FLAT, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(node = __v_raw.node, x = __v_raw.x, y = __v_raw.y, width = __v_raw.width, height = __v_raw.height, level = __v_raw.level, parent = __v_raw.parent) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): XTREE_NODES_FLATReactiveObject {
        return XTREE_NODES_FLATReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var node: XTREEFLAT_CHILDREN
        get() {
            return _tRG(__v_raw, "node", __v_raw.node, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("node")) {
                return
            }
            val oldValue = __v_raw.node
            __v_raw.node = value
            _tRS(__v_raw, "node", oldValue, value)
        }
    override var x: Number
        get() {
            return _tRG(__v_raw, "x", __v_raw.x, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("x")) {
                return
            }
            val oldValue = __v_raw.x
            __v_raw.x = value
            _tRS(__v_raw, "x", oldValue, value)
        }
    override var y: Number
        get() {
            return _tRG(__v_raw, "y", __v_raw.y, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("y")) {
                return
            }
            val oldValue = __v_raw.y
            __v_raw.y = value
            _tRS(__v_raw, "y", oldValue, value)
        }
    override var width: Number
        get() {
            return _tRG(__v_raw, "width", __v_raw.width, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("width")) {
                return
            }
            val oldValue = __v_raw.width
            __v_raw.width = value
            _tRS(__v_raw, "width", oldValue, value)
        }
    override var height: Number
        get() {
            return _tRG(__v_raw, "height", __v_raw.height, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("height")) {
                return
            }
            val oldValue = __v_raw.height
            __v_raw.height = value
            _tRS(__v_raw, "height", oldValue, value)
        }
    override var level: Number
        get() {
            return _tRG(__v_raw, "level", __v_raw.level, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("level")) {
                return
            }
            val oldValue = __v_raw.level
            __v_raw.level = value
            _tRS(__v_raw, "level", oldValue, value)
        }
    override var parent: XTREEFLAT_CHILDREN?
        get() {
            return _tRG(__v_raw, "parent", __v_raw.parent, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("parent")) {
                return
            }
            val oldValue = __v_raw.parent
            __v_raw.parent = value
            _tRS(__v_raw, "parent", oldValue, value)
        }
}
open class XTREEFLAT_CONFIG_REAL (
    @JsonNotNull
    open var width: Number,
    @JsonNotNull
    open var height: Number,
    @JsonNotNull
    open var bgColor: String,
    @JsonNotNull
    open var nodeBgColor: String,
    @JsonNotNull
    open var fontColor: String,
    @JsonNotNull
    open var fontSize: Number,
    @JsonNotNull
    open var lineColor: String,
    @JsonNotNull
    open var canvas: CanvasContext,
    @JsonNotNull
    open var nodeInfo: NodeInfo,
    @JsonNotNull
    open var padding: Number,
    @JsonNotNull
    open var gutter: Number,
    @JsonNotNull
    open var parentLineGutter: Number,
    @JsonNotNull
    open var lineWidth: Number,
    @JsonNotNull
    open var enbleOpenChildren: Boolean = false,
    @JsonNotNull
    open var nodeRadius: Number,
    @JsonNotNull
    open var layout: XTREEFLAT_LAYOUT,
    @JsonNotNull
    open var lineType: XTREEFLAT_LINE_TYPE,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return XTREEFLAT_CONFIG_REALReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class XTREEFLAT_CONFIG_REALReactiveObject : XTREEFLAT_CONFIG_REAL, IUTSReactive<XTREEFLAT_CONFIG_REAL> {
    override var __v_raw: XTREEFLAT_CONFIG_REAL
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: XTREEFLAT_CONFIG_REAL, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(width = __v_raw.width, height = __v_raw.height, bgColor = __v_raw.bgColor, nodeBgColor = __v_raw.nodeBgColor, fontColor = __v_raw.fontColor, fontSize = __v_raw.fontSize, lineColor = __v_raw.lineColor, canvas = __v_raw.canvas, nodeInfo = __v_raw.nodeInfo, padding = __v_raw.padding, gutter = __v_raw.gutter, parentLineGutter = __v_raw.parentLineGutter, lineWidth = __v_raw.lineWidth, enbleOpenChildren = __v_raw.enbleOpenChildren, nodeRadius = __v_raw.nodeRadius, layout = __v_raw.layout, lineType = __v_raw.lineType) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): XTREEFLAT_CONFIG_REALReactiveObject {
        return XTREEFLAT_CONFIG_REALReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var width: Number
        get() {
            return _tRG(__v_raw, "width", __v_raw.width, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("width")) {
                return
            }
            val oldValue = __v_raw.width
            __v_raw.width = value
            _tRS(__v_raw, "width", oldValue, value)
        }
    override var height: Number
        get() {
            return _tRG(__v_raw, "height", __v_raw.height, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("height")) {
                return
            }
            val oldValue = __v_raw.height
            __v_raw.height = value
            _tRS(__v_raw, "height", oldValue, value)
        }
    override var bgColor: String
        get() {
            return _tRG(__v_raw, "bgColor", __v_raw.bgColor, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("bgColor")) {
                return
            }
            val oldValue = __v_raw.bgColor
            __v_raw.bgColor = value
            _tRS(__v_raw, "bgColor", oldValue, value)
        }
    override var nodeBgColor: String
        get() {
            return _tRG(__v_raw, "nodeBgColor", __v_raw.nodeBgColor, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("nodeBgColor")) {
                return
            }
            val oldValue = __v_raw.nodeBgColor
            __v_raw.nodeBgColor = value
            _tRS(__v_raw, "nodeBgColor", oldValue, value)
        }
    override var fontColor: String
        get() {
            return _tRG(__v_raw, "fontColor", __v_raw.fontColor, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("fontColor")) {
                return
            }
            val oldValue = __v_raw.fontColor
            __v_raw.fontColor = value
            _tRS(__v_raw, "fontColor", oldValue, value)
        }
    override var fontSize: Number
        get() {
            return _tRG(__v_raw, "fontSize", __v_raw.fontSize, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("fontSize")) {
                return
            }
            val oldValue = __v_raw.fontSize
            __v_raw.fontSize = value
            _tRS(__v_raw, "fontSize", oldValue, value)
        }
    override var lineColor: String
        get() {
            return _tRG(__v_raw, "lineColor", __v_raw.lineColor, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("lineColor")) {
                return
            }
            val oldValue = __v_raw.lineColor
            __v_raw.lineColor = value
            _tRS(__v_raw, "lineColor", oldValue, value)
        }
    override var canvas: CanvasContext
        get() {
            return _tRG(__v_raw, "canvas", __v_raw.canvas, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("canvas")) {
                return
            }
            val oldValue = __v_raw.canvas
            __v_raw.canvas = value
            _tRS(__v_raw, "canvas", oldValue, value)
        }
    override var nodeInfo: NodeInfo
        get() {
            return _tRG(__v_raw, "nodeInfo", __v_raw.nodeInfo, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("nodeInfo")) {
                return
            }
            val oldValue = __v_raw.nodeInfo
            __v_raw.nodeInfo = value
            _tRS(__v_raw, "nodeInfo", oldValue, value)
        }
    override var padding: Number
        get() {
            return _tRG(__v_raw, "padding", __v_raw.padding, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("padding")) {
                return
            }
            val oldValue = __v_raw.padding
            __v_raw.padding = value
            _tRS(__v_raw, "padding", oldValue, value)
        }
    override var gutter: Number
        get() {
            return _tRG(__v_raw, "gutter", __v_raw.gutter, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("gutter")) {
                return
            }
            val oldValue = __v_raw.gutter
            __v_raw.gutter = value
            _tRS(__v_raw, "gutter", oldValue, value)
        }
    override var parentLineGutter: Number
        get() {
            return _tRG(__v_raw, "parentLineGutter", __v_raw.parentLineGutter, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("parentLineGutter")) {
                return
            }
            val oldValue = __v_raw.parentLineGutter
            __v_raw.parentLineGutter = value
            _tRS(__v_raw, "parentLineGutter", oldValue, value)
        }
    override var lineWidth: Number
        get() {
            return _tRG(__v_raw, "lineWidth", __v_raw.lineWidth, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("lineWidth")) {
                return
            }
            val oldValue = __v_raw.lineWidth
            __v_raw.lineWidth = value
            _tRS(__v_raw, "lineWidth", oldValue, value)
        }
    override var enbleOpenChildren: Boolean
        get() {
            return _tRG(__v_raw, "enbleOpenChildren", __v_raw.enbleOpenChildren, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("enbleOpenChildren")) {
                return
            }
            val oldValue = __v_raw.enbleOpenChildren
            __v_raw.enbleOpenChildren = value
            _tRS(__v_raw, "enbleOpenChildren", oldValue, value)
        }
    override var nodeRadius: Number
        get() {
            return _tRG(__v_raw, "nodeRadius", __v_raw.nodeRadius, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("nodeRadius")) {
                return
            }
            val oldValue = __v_raw.nodeRadius
            __v_raw.nodeRadius = value
            _tRS(__v_raw, "nodeRadius", oldValue, value)
        }
    override var layout: XTREEFLAT_LAYOUT
        get() {
            return _tRG(__v_raw, "layout", __v_raw.layout, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("layout")) {
                return
            }
            val oldValue = __v_raw.layout
            __v_raw.layout = value
            _tRS(__v_raw, "layout", oldValue, value)
        }
    override var lineType: XTREEFLAT_LINE_TYPE
        get() {
            return _tRG(__v_raw, "lineType", __v_raw.lineType, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("lineType")) {
                return
            }
            val oldValue = __v_raw.lineType
            __v_raw.lineType = value
            _tRS(__v_raw, "lineType", oldValue, value)
        }
}
open class calculateNodeSize_return (
    @JsonNotNull
    open var width: Number,
    @JsonNotNull
    open var height: Number,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return calculateNodeSize_returnReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class calculateNodeSize_returnReactiveObject : calculateNodeSize_return, IUTSReactive<calculateNodeSize_return> {
    override var __v_raw: calculateNodeSize_return
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: calculateNodeSize_return, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(width = __v_raw.width, height = __v_raw.height) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): calculateNodeSize_returnReactiveObject {
        return calculateNodeSize_returnReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var width: Number
        get() {
            return _tRG(__v_raw, "width", __v_raw.width, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("width")) {
                return
            }
            val oldValue = __v_raw.width
            __v_raw.width = value
            _tRS(__v_raw, "width", oldValue, value)
        }
    override var height: Number
        get() {
            return _tRG(__v_raw, "height", __v_raw.height, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("height")) {
                return
            }
            val oldValue = __v_raw.height
            __v_raw.height = value
            _tRS(__v_raw, "height", oldValue, value)
        }
}
typealias xCalcListDataFun = (list: UTSArray<XTREEFLAT_NODES>) -> UTSArray<XTREEFLAT_CHILDREN>
typealias traverseFun = (node: XTREEFLAT_CHILDREN, level: Number) -> Unit
open class drawRealRect (
    @JsonNotNull
    open var x: Number,
    @JsonNotNull
    open var y: Number,
    @JsonNotNull
    open var width: Number,
    @JsonNotNull
    open var height: Number,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return drawRealRectReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class drawRealRectReactiveObject : drawRealRect, IUTSReactive<drawRealRect> {
    override var __v_raw: drawRealRect
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: drawRealRect, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(x = __v_raw.x, y = __v_raw.y, width = __v_raw.width, height = __v_raw.height) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): drawRealRectReactiveObject {
        return drawRealRectReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var x: Number
        get() {
            return _tRG(__v_raw, "x", __v_raw.x, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("x")) {
                return
            }
            val oldValue = __v_raw.x
            __v_raw.x = value
            _tRS(__v_raw, "x", oldValue, value)
        }
    override var y: Number
        get() {
            return _tRG(__v_raw, "y", __v_raw.y, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("y")) {
                return
            }
            val oldValue = __v_raw.y
            __v_raw.y = value
            _tRS(__v_raw, "y", oldValue, value)
        }
    override var width: Number
        get() {
            return _tRG(__v_raw, "width", __v_raw.width, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("width")) {
                return
            }
            val oldValue = __v_raw.width
            __v_raw.width = value
            _tRS(__v_raw, "width", oldValue, value)
        }
    override var height: Number
        get() {
            return _tRG(__v_raw, "height", __v_raw.height, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("height")) {
                return
            }
            val oldValue = __v_raw.height
            __v_raw.height = value
            _tRS(__v_raw, "height", oldValue, value)
        }
}
open class OrgChartRenderer {
    private var ctx: CanvasRenderingContext2D
    private var nodes = _uA<XTREE_NODES_FLAT>()
    private var offsetX: Number = 0
    private var offsetY: Number = 0
    private var config: XTREEFLAT_CONFIG_REAL
    private var pixelRatio: Number = 1
    private var levelMaxWidth = _uO()
    private var data = _uA<XTREEFLAT_CHILDREN>()
    open var scaleXY: Number = 1.0
    private var nowSelectedNodes = null as XTREEFLAT_CHILDREN?
    private var nodesClick = fun(item: XTREEFLAT_CHILDREN){}
    private var idToNodeIndex = Map<String, Number>()
    private var parentIdToChildIndices = Map<String, UTSArray<Number>>()
    private var rootIndices = _uA<Number>()
    private var rootOrdinalById = Map<String, Number>()
    private var cachedNodeSize = Map<String, calculateNodeSize_return>()
    private var cachedSubtreeH = Map<String, Number>()
    private var cachedSubtreeW = Map<String, Number>()
    private fun nodeIdKey(id: Any): String {
        return id.toString()
    }
    private fun clearSubtreeLayoutCache() {
        this.cachedSubtreeH.clear()
        this.cachedSubtreeW.clear()
    }
    private fun clearNodeSizeCache() {
        this.cachedNodeSize.clear()
    }
    private fun lineIsCurve(): Boolean {
        return this.config.lineType == "curve"
    }
    private fun curveTensionX(gutter: Number): Number {
        val g = if (gutter > 0) {
            gutter
        } else {
            30
        }
        return Math.max(g * 0.42, 10)
    }
    private fun curveTensionY(gutter: Number): Number {
        val g = if (gutter > 0) {
            gutter
        } else {
            30
        }
        return Math.max(g * 0.42, 10)
    }
    private fun rebuildDrawLookups() {
        this.idToNodeIndex.clear()
        this.parentIdToChildIndices.clear()
        this.rootOrdinalById.clear()
        this.rootIndices = _uA<Number>()
        val n = this.nodes.length
        run {
            var i: Number = 0
            while(i < n){
                val m = this.nodes[i]
                val idKey = this.nodeIdKey(m.node.id)
                this.idToNodeIndex.set(idKey, i)
                if (m.level == 0) {
                    this.rootOrdinalById.set(idKey, this.rootIndices.length)
                    this.rootIndices.push(i)
                }
                if (m.parent != null) {
                    val pid = this.nodeIdKey(m.parent!!.id)
                    var bucket = this.parentIdToChildIndices.get(pid)
                    if (bucket == null) {
                        bucket = _uA<Number>()
                        this.parentIdToChildIndices.set(pid, bucket)
                    }
                    bucket.push(i)
                }
                i++
            }
        }
    }
    constructor(xconfig: XTREEFLAT_CONFIG){
        this.config = XTREEFLAT_CONFIG_REAL(width = xconfig?.width ?: 1000, height = xconfig?.height ?: 1000, bgColor = xconfig?.bgColor ?: "rgba(0,0,0,0)", fontColor = xconfig?.fontColor ?: "#2f2943", lineColor = xconfig?.lineColor ?: "rgb(220, 215, 255)", nodeBgColor = xconfig?.nodeBgColor ?: "rgb(220, 215, 255)", padding = xconfig?.padding ?: 10, gutter = xconfig?.gutter ?: 12, nodeRadius = xconfig?.nodeRadius ?: 8, parentLineGutter = xconfig?.parentLineGutter ?: 30, enbleOpenChildren = xconfig?.enbleOpenChildren ?: true, lineWidth = xconfig?.lineWidth ?: 1.5, canvas = xconfig.canvas, nodeInfo = xconfig.nodeInfo, fontSize = xconfig?.fontSize ?: 13, layout = (xconfig?.layout ?: "horizontal") as XTREEFLAT_LAYOUT, lineType = (xconfig?.lineType ?: "straight") as XTREEFLAT_LINE_TYPE)
        val canvasContext = this.config.canvas.getContext("2d")!!
        val canvas = canvasContext.canvas
        val dpr = uni_getWindowInfo().pixelRatio
        canvas.width = canvas.offsetWidth * dpr
        canvas.height = canvas.offsetHeight * dpr
        canvasContext.scale(dpr, dpr)
        this.ctx = canvasContext
        this.pixelRatio = dpr
    }
    public open fun getDrawBounds(): drawRealRect {
        if (this.nodes.length === 0) {
            return drawRealRect(x = 0, y = 0, width = 0, height = 0)
        }
        var minX = Infinity
        var minY = Infinity
        var maxX = -Infinity
        var maxY = -Infinity
        this.nodes.forEach(fun(ref__1){
            var x = ref__1.x
            var y = ref__1.y
            var width = ref__1.width
            var height = ref__1.height
            minX = Math.min(minX.toDouble(), x.toDouble()).toDouble()
            minY = Math.min(minY.toDouble(), y.toDouble()).toDouble()
            maxX = Math.max(maxX.toDouble(), (x + width).toDouble()).toDouble()
            maxY = Math.max(maxY.toDouble(), (y + height).toDouble()).toDouble()
        }
        )
        return drawRealRect(x = minX + this.offsetX, y = minY + this.offsetY, width = maxX - minX, height = maxY - minY)
    }
    private fun wrapText(text: String, fontSize: Number): UTSArray<String> {
        this.ctx.font = "" + fontSize + "px Arial"
        val words = text.split("")
        val lines: UTSArray<String> = _uA()
        var currentLine = ""
        val maxCharsPerLine: Number = 8
        run {
            var i: Number = 0
            while(i < words.length){
                if (currentLine.length >= maxCharsPerLine) {
                    lines.push(currentLine)
                    currentLine = ""
                }
                currentLine += words[i]
                i++
            }
        }
        if (currentLine != "") {
            lines.push(currentLine)
        }
        return lines
    }
    private fun calcMeasureText(text: String, fontSize: Number): Number {
        var totalWidth: Number = 0
        return totalWidth
    }
    private fun calculateNodeSize(node: XTREEFLAT_CHILDREN): calculateNodeSize_return {
        val key = this.nodeIdKey(node.id)
        val hit = this.cachedNodeSize.get(key)
        if (hit != null) {
            return hit
        }
        val lines = this.wrapText(node.title, node.fontSize)
        this.ctx.font = "" + node.fontSize + "px Arial"
        var linesWidths: UTSArray<Number> = lines.map(fun(line): Number {
            var w = this.ctx.measureText(line).width
            return w
        }
        )
        val maxWidth = Math.max(*linesWidths.toTypedArray())
        val lineHeight = node.fontSize * 1.2
        val textHeight = lineHeight * lines.length
        val out = calculateNodeSize_return(width = maxWidth + node.padding * 2, height = textHeight + node.padding * 2)
        this.cachedNodeSize.set(key, out)
        return out
    }
    private fun calculateSubtreeHeight(node: XTREEFLAT_CHILDREN): Number {
        val key = this.nodeIdKey(node.id)
        val memo = this.cachedSubtreeH.get(key)
        if (memo != null) {
            return memo
        }
        val nodeSize = this.calculateNodeSize(node)
        var out = nodeSize.height
        if (node.opened && node.children.length > 0) {
            val childrenHeight = node.children.reduce(fun(total, child, index): Number {
                val childHeight = this.calculateSubtreeHeight(child)
                return total + childHeight + (if (index < node.children.length - 1) {
                    node.gutter
                } else {
                    0
                }
                )
            }
            , 0)
            out = Math.max(nodeSize.height, childrenHeight)
        }
        this.cachedSubtreeH.set(key, out)
        return out
    }
    private fun collectLevelMaxWidth() {
        this.levelMaxWidth = _uO()
        var traverse = null as traverseFun?
        traverse = fun(node: XTREEFLAT_CHILDREN, level: Number){
            val size = this.calculateNodeSize(node)
            val currentWidth = size.width
            if (this.levelMaxWidth.get(level.toString(10)) == null) {
                this.levelMaxWidth.set(level.toString(10), currentWidth)
            }
            var maxwidth = this.levelMaxWidth.get(level.toString(10))!! as Number
            if (currentWidth > maxwidth) {
                this.levelMaxWidth.set(level.toString(10), currentWidth)
            }
            if (node.opened && node.children.length > 0) {
                node.children.forEach(fun(child){
                    return traverse!!(child, level + 1)
                }
                )
            }
        }
        this.data.forEach(fun(root){
            return traverse!!(root, 0)
        }
        )
    }
    private fun layoutNode(node: XTREEFLAT_CHILDREN, parentX: Number, parentY: Number, level: Number, parent: XTREEFLAT_CHILDREN? = null) {
        val size = this.calculateNodeSize(node)
        val nodeWidth = this.levelMaxWidth.getNumber(level.toString(10))!!
        val subtreeHeight = this.calculateSubtreeHeight(node)
        this.nodes.push(XTREE_NODES_FLAT(node = node, x = parentX, y = parentY - size.height / 2, width = nodeWidth, height = size.height, level = level, parent = parent))
        if (node.opened && node.children.length > 0) {
            val totalChildrenHeight = node.children.reduce(fun(total, child): Number {
                return total + this.calculateSubtreeHeight(child)
            }
            , 0)
            val totalGutterHeight = (node.children.length - 1) * node.gutter
            val totalHeight = totalChildrenHeight + totalGutterHeight
            var childY = parentY - totalHeight / 2
            node.children.forEach(fun(child, index){
                val childSubtreeHeight = this.calculateSubtreeHeight(child)
                this.layoutNode(child, (parentX + nodeWidth + node.parentLineGutter), (childY + childSubtreeHeight / 2), level + 1, node)
                childY += childSubtreeHeight + node.gutter
            }
            )
        }
    }
    private fun calculateSubtreeWidth(node: XTREEFLAT_CHILDREN): Number {
        val key = this.nodeIdKey(node.id)
        val memo = this.cachedSubtreeW.get(key)
        if (memo != null) {
            return memo
        }
        val nodeSize = this.calculateNodeSize(node)
        var out = nodeSize.width
        if (node.opened && node.children.length > 0) {
            val childrenWidth = node.children.reduce(fun(total, child, index): Number {
                val childWidth = this.calculateSubtreeWidth(child)
                return total + childWidth + (if (index < node.children.length - 1) {
                    node.gutter
                } else {
                    0
                }
                )
            }
            , 0)
            out = Math.max(nodeSize.width, childrenWidth)
        }
        this.cachedSubtreeW.set(key, out)
        return out
    }
    private fun layoutNodeVertical(node: XTREEFLAT_CHILDREN, parentCenterX: Number, parentTopY: Number, level: Number, parent: XTREEFLAT_CHILDREN? = null) {
        val size = this.calculateNodeSize(node)
        val nodeLeftX = parentCenterX - size.width / 2
        this.nodes.push(XTREE_NODES_FLAT(node = node, x = nodeLeftX, y = parentTopY, width = size.width, height = size.height, level = level, parent = parent))
        if (node.opened && node.children.length > 0) {
            val totalChildrenWidth = node.children.reduce(fun(total, child): Number {
                return total + this.calculateSubtreeWidth(child)
            }
            , 0)
            val totalGutterWidth = (node.children.length - 1) * node.gutter
            val totalWidth = totalChildrenWidth + totalGutterWidth
            var childLeft = parentCenterX - totalWidth / 2
            node.children.forEach(fun(child){
                val childSubtreeWidth = this.calculateSubtreeWidth(child)
                val childCenterX = childLeft + childSubtreeWidth / 2
                this.layoutNodeVertical(child, childCenterX, parentTopY + size.height + node.parentLineGutter, level + 1, node)
                childLeft += childSubtreeWidth + node.gutter
            }
            )
        }
    }
    private fun calculateLayout() {
        this.clearSubtreeLayoutCache()
        this.nodes = _uA()
        if (this.config.layout == "horizontal") {
            this.collectLevelMaxWidth()
            val totalHeight = this.data.reduce(fun(total, root, index): Number {
                val subtreeHeight = this.calculateSubtreeHeight(root)
                return total + subtreeHeight + (if (index < this.data.length - 1) {
                    root.gutter
                } else {
                    0
                })
            }, 0)
            var startY = -totalHeight / 2
            this.data.forEach(fun(root){
                val subtreeHeight = this.calculateSubtreeHeight(root)
                this.layoutNode(root, 0, startY + subtreeHeight / 2, 0, null)
                startY += subtreeHeight + root.gutter
            })
        } else {
            val totalWidth = this.data.reduce(fun(total, root, index): Number {
                val subtreeWidth = this.calculateSubtreeWidth(root)
                return total + subtreeWidth + (if (index < this.data.length - 1) {
                    root.gutter
                } else {
                    0
                }
                )
            }
            , 0)
            var startX = -totalWidth / 2
            this.data.forEach(fun(root){
                val subtreeWidth = this.calculateSubtreeWidth(root)
                val rootCenterX = startX + subtreeWidth / 2
                this.layoutNodeVertical(root, rootCenterX, 0, 0, null)
                startX += subtreeWidth + root.gutter
            }
            )
        }
        var minX = Infinity
        var minY = Infinity
        var maxX = -Infinity
        var maxY = -Infinity
        this.nodes.forEach(fun(ref__1){
            var x = ref__1.x
            var y = ref__1.y
            var width = ref__1.width
            var height = ref__1.height
            minX = Math.min(minX.toDouble(), x.toDouble()).toDouble()
            minY = Math.min(minY.toDouble(), y.toDouble()).toDouble()
            maxX = Math.max(maxX.toDouble(), (x + width).toDouble()).toDouble()
            maxY = Math.max(maxY.toDouble(), (y + height).toDouble()).toDouble()
        }
        )
        this.offsetX = (this.config.width - (maxX - minX)) / 2 - minX
        this.offsetY = (this.config.height - (maxY - minY)) / 2 - minY
        this.rebuildDrawLookups()
    }
    private fun drawHorizontalCurveParentToChildren(meta: XTREE_NODES_FLAT, cidxs: UTSArray<Number>) {
        val parentRight = meta.x + meta.width
        val parentCy = meta.y + meta.height / 2
        run {
            var ci: Number = 0
            while(ci < cidxs.length){
                val child = this.nodes[cidxs[ci]]
                val childLeft = child.x
                val childCy = child.y + child.height / 2
                val gap = childLeft - parentRight
                val dx = gap / 2
                this.ctx.beginPath()
                this.ctx.moveTo(parentRight, parentCy)
                if (Math.abs(parentCy - childCy) < 2) {
                    val arc = -Math.min(gap * 0.35, 25)
                    val midX = (parentRight + childLeft) / 2
                    this.ctx.bezierCurveTo(midX, parentCy + arc, midX, childCy + arc, childLeft, childCy)
                } else {
                    this.ctx.bezierCurveTo(parentRight + dx, parentCy, childLeft - dx, childCy, childLeft, childCy)
                }
                this.ctx.stroke()
                ci++
            }
        }
    }
    private fun drawVerticalCurveParentToChildren(meta: XTREE_NODES_FLAT, cidxs: UTSArray<Number>) {
        val parentCx = meta.x + meta.width / 2
        val parentBottom = meta.y + meta.height
        run {
            var ci: Number = 0
            while(ci < cidxs.length){
                val child = this.nodes[cidxs[ci]]
                val childCx = child.x + child.width / 2
                val childTop = child.y
                val gap = childTop - parentBottom
                val dy = gap / 2
                this.ctx.beginPath()
                this.ctx.moveTo(parentCx, parentBottom)
                if (Math.abs(parentCx - childCx) < 2) {
                    val arc = -Math.min(gap * 0.35, 25)
                    val midY = (parentBottom + childTop) / 2
                    this.ctx.bezierCurveTo(parentCx + arc, midY, childCx + arc, midY, childCx, childTop)
                } else {
                    this.ctx.bezierCurveTo(parentCx, parentBottom + dy, childCx, childTop - dy, childCx, childTop)
                }
                this.ctx.stroke()
                ci++
            }
        }
    }
    private fun drawConnections(nodeMeta: XTREE_NODES_FLAT) {
        val node = nodeMeta.node
        val x = nodeMeta.x
        val y = nodeMeta.y
        val width = nodeMeta.width
        val height = nodeMeta.height
        val level = nodeMeta.level
        val parent = nodeMeta.parent
        this.ctx.strokeStyle = nodeMeta.node.bgColor
        this.ctx.lineWidth = this.config.lineWidth
        if (parent != null && this.config.layout == "horizontal" && !this.lineIsCurve()) {
            val pidx = this.idToNodeIndex.get(this.nodeIdKey(parent.id))
            if (pidx != null) {
                val parentMeta = this.nodes[pidx]
                val startX = x
                val startY = y + height / 2
                val endX = parentMeta.x + parentMeta.width
                val endY = parentMeta.y + parentMeta.height / 2
                this.ctx.beginPath()
                this.ctx.moveTo(startX, startY)
                this.ctx.lineTo(startX - node.parentLineGutter / 2, startY)
                this.ctx.lineTo(startX - node.parentLineGutter / 2, endY)
                this.ctx.lineTo(endX, endY)
                this.ctx.stroke()
            }
        }
        if (this.config.layout == "horizontal" && level == 0) {
            val ord = this.rootOrdinalById.get(this.nodeIdKey(node.id))
            if (ord != null && ord > 0 && this.rootIndices.length > 1) {
                val prevNode = this.nodes[this.rootIndices[ord - 1]]
                val midY = (prevNode.y + prevNode.height / 2 + y + height / 2) / 2
                val p1x = prevNode.x + prevNode.width / 2
                val p1y = prevNode.y + prevNode.height / 2
                val p2x = x + width / 2
                val p2y = y + height / 2
                this.ctx.beginPath()
                this.ctx.moveTo(p1x, p1y)
                if (this.lineIsCurve()) {
                    val dy = p2y - p1y
                    val arcX = -Math.min(Math.abs(dy) * 0.25, 30)
                    this.ctx.bezierCurveTo(p1x + arcX, p1y + dy * 0.4, p2x + arcX, p2y - dy * 0.4, p2x, p2y)
                } else {
                    this.ctx.lineTo(p1x, midY)
                    this.ctx.lineTo(p2x, midY)
                    this.ctx.lineTo(p2x, p2y)
                }
                this.ctx.stroke()
            }
        }
        if (this.config.layout == "vertical" && level == 0) {
            val ord = this.rootOrdinalById.get(this.nodeIdKey(node.id))
            if (ord != null && ord > 0 && this.rootIndices.length > 1) {
                val prevNode = this.nodes[this.rootIndices[ord - 1]]
                val midX = (prevNode.x + prevNode.width / 2 + x + width / 2) / 2
                val p1x = prevNode.x + prevNode.width / 2
                val p1y = prevNode.y + prevNode.height / 2
                val p2x = x + width / 2
                val p2y = y + height / 2
                this.ctx.beginPath()
                this.ctx.moveTo(p1x, p1y)
                if (this.lineIsCurve()) {
                    val dx = p2x - p1x
                    val arcY = -Math.min(Math.abs(dx) * 0.25, 30)
                    this.ctx.bezierCurveTo(p1x + dx * 0.4, p1y + arcY, p2x - dx * 0.4, p2y + arcY, p2x, p2y)
                } else {
                    this.ctx.lineTo(midX, p1y)
                    this.ctx.lineTo(midX, p2y)
                    this.ctx.lineTo(p2x, p2y)
                }
                this.ctx.stroke()
            }
        }
        if (node.opened && node.children.length > 0 && this.config.layout == "horizontal") {
            val cidxs = this.parentIdToChildIndices.get(this.nodeIdKey(node.id))
            if (cidxs != null && cidxs.length > 0) {
                if (this.lineIsCurve()) {
                    this.drawHorizontalCurveParentToChildren(nodeMeta, cidxs)
                } else {
                    val firstChild = this.nodes[cidxs[0]]
                    val lastChild = this.nodes[cidxs[cidxs.length - 1]]
                    val lineX = x + width + node.parentLineGutter / 2
                    this.ctx.beginPath()
                    this.ctx.moveTo(lineX, firstChild.y + firstChild.height / 2)
                    this.ctx.lineTo(lineX, lastChild.y + lastChild.height / 2)
                    this.ctx.stroke()
                    run {
                        var ci: Number = 0
                        while(ci < cidxs.length){
                            val child = this.nodes[cidxs[ci]]
                            val cy = child.y + child.height / 2
                            this.ctx.beginPath()
                            this.ctx.moveTo(lineX, cy)
                            this.ctx.lineTo(child.x, cy)
                            this.ctx.stroke()
                            ci++
                        }
                    }
                }
            }
        }
        if (node.opened && node.children.length > 0 && this.config.layout == "vertical") {
            val cidxs = this.parentIdToChildIndices.get(this.nodeIdKey(node.id))
            if (cidxs != null && cidxs.length > 0) {
                if (this.lineIsCurve()) {
                    this.drawVerticalCurveParentToChildren(nodeMeta, cidxs)
                } else {
                    val firstChild = this.nodes[cidxs[0]]
                    val lastChild = this.nodes[cidxs[cidxs.length - 1]]
                    val midY = y + height + node.parentLineGutter / 2
                    val parentCenterX = x + width / 2
                    this.ctx.beginPath()
                    this.ctx.moveTo(parentCenterX, y + height)
                    this.ctx.lineTo(parentCenterX, midY)
                    this.ctx.stroke()
                    this.ctx.beginPath()
                    this.ctx.moveTo(firstChild.x + firstChild.width / 2, midY)
                    this.ctx.lineTo(lastChild.x + lastChild.width / 2, midY)
                    this.ctx.stroke()
                    run {
                        var ci: Number = 0
                        while(ci < cidxs.length){
                            val child = this.nodes[cidxs[ci]]
                            val childCenterX = child.x + child.width / 2
                            this.ctx.beginPath()
                            this.ctx.moveTo(childCenterX, midY)
                            this.ctx.lineTo(childCenterX, child.y)
                            this.ctx.stroke()
                            ci++
                        }
                    }
                }
            }
        }
    }
    open fun drawRoundedRect(x: Number, y: Number, width: Number, height: Number, radius: Number) {
        val ctx = this.ctx
        ctx.beginPath()
        ctx.moveTo(x + radius, y)
        ctx.arcTo(x + width, y, x + width, y + height, radius)
        ctx.arcTo(x + width, y + height, x, y + height, radius)
        ctx.arcTo(x, y + height, x, y, radius)
        ctx.arcTo(x, y, x + width, y, radius)
        ctx.closePath()
        ctx.fill()
    }
    private fun draw() {
        this.ctx.clearRect(0, 0, this.config.width, this.config.height)
        this.ctx.fillStyle = this.config.bgColor
        this.ctx.fillRect(0, 0, this.config.width, this.config.height)
        this.ctx.save()
        this.ctx.translate(this.offsetX, this.offsetY)
        this.nodes.forEach(fun(nodeMeta){
            return this.drawConnections(nodeMeta)
        }
        )
        this.nodes.forEach(fun(nodeMeta){
            val node = nodeMeta.node
            val x = nodeMeta.x
            val y = nodeMeta.y
            val width = nodeMeta.width
            val height = nodeMeta.height
            if (node.selected) {
                this.ctx.fillStyle = node.lineColor
                this.drawRoundedRect(x - 5, y - 5, width + 10, height + 10, this.config.nodeRadius)
            }
            this.ctx.fillStyle = node.bgColor
            this.drawRoundedRect(x, y, width, height, this.config.nodeRadius)
            val lines = this.wrapText(node.title, node.fontSize)
            this.ctx.fillStyle = node.fontColor
            this.ctx.font = "" + node.fontSize + "px Arial"
            this.ctx.textBaseline = "middle"
            val lineHeight = node.fontSize * 1.2
            val totalTextHeight = lineHeight * lines.length
            val textStartY = y + (height - totalTextHeight) / 2
            lines.forEach(fun(line, index){
                val lineY = textStartY + lineHeight * index + lineHeight / 2
                var textWidth = this.ctx.measureText(line).width
                val textX = x + (width - textWidth) / 2
                this.ctx.fillText(line, textX, lineY)
            }
            )
        }
        )
        this.ctx.restore()
    }
    private fun updateData(list: UTSArray<XTREEFLAT_NODES>) {
        var calcListData = null as xCalcListDataFun?
        var _this = this
        calcListData = fun(datas: UTSArray<XTREEFLAT_NODES>): UTSArray<XTREEFLAT_CHILDREN> {
            if (datas.length == 0) {
                return _uA<XTREEFLAT_CHILDREN>()
            }
            var tem = _uA<XTREEFLAT_CHILDREN>()
            var calcfun = calcListData!!
            run {
                var i: Number = 0
                while(i < datas.length){
                    var item = datas[i]
                    var children = item?.children ?: (_uA<XTREEFLAT_NODES>())
                    var bgcolor = item?.bgColor ?: _this.config.nodeBgColor
                    var rgba = hexToRgb(bgcolor)
                    var lineColor = "rgba(" + rgba.getNumber("r") + "," + rgba.getNumber("g") + "," + rgba.getNumber("b") + ",0.4)"
                    tem.push(XTREEFLAT_CHILDREN(title = item.title, id = item?.id ?: ("xTreeFlatNodes-" + Math.random().toString(16).substring(4, 20)), fontColor = item?.fontColor ?: _this.config.fontColor, bgColor = bgcolor, lineColor = lineColor, padding = item?.padding ?: _this.config.padding, gutter = item?.gutter ?: _this.config.gutter, parentLineGutter = item?.parentLineGutter ?: _this.config.parentLineGutter, opened = item?.opened ?: true, disabled = item?.disabled ?: _this.config.enbleOpenChildren, selected = item?.selected ?: false, fontSize = item?.fontSize ?: _this.config.fontSize, children = calcfun(children)))
                    i++
                }
            }
            return tem
        }
        var calcfun = calcListData!!
        this.clearNodeSizeCache()
        this.data = calcfun(list)
    }
    private fun calculateAutoScale(): Number {
        val bounds = this.getDrawBounds()
        if (bounds.width === 0 || bounds.height === 0) {
            return 1.0
        }
        val padding: Number = 0.1
        val containerWidth = this.config.nodeInfo.width!! * (1 - padding)
        val containerHeight = this.config.nodeInfo.height!! * (1 - padding)
        val scaleX = containerWidth / bounds.width
        val scaleY = containerHeight / bounds.height
        return Math.min(scaleX, scaleY)
    }
    public open fun setScale(scale: Number? = null) {
        this.scaleXY = if (scale == null) {
            this.calculateAutoScale()
        } else {
            scale!!
        }
        this.draw()
    }
    public open fun addEventClick(e: UniPointerEvent, scrollTop: Number, scrollLeft: Number) {
        if (this.nodes.length == 0) {
            return
        }
        var wintop = uni_getWindowInfo().windowTop
        val containerX = e.clientX - (this.config.nodeInfo.left ?: 0)
        val containerY = e.clientY - (this.config.nodeInfo.top ?: 0) - wintop
        val canvasX = containerX + scrollLeft - this.offsetX
        val canvasY = containerY + scrollTop - this.offsetY
        var isHit = false
        run {
            var i: Number = 0
            while(i < this.nodes.length){
                val meta = this.nodes[i]
                if (canvasX >= meta.x && canvasX <= meta.x + meta.width && canvasY >= meta.y && canvasY <= meta.y + meta.height) {
                    if (!meta.node.disabled) {
                        meta.node.opened = !meta.node.opened
                        this.calculateLayout()
                    }
                    val selId = meta.node.id
                    run {
                        var j: Number = 0
                        while(j < this.nodes.length){
                            this.nodes[j].node.selected = (this.nodes[j].node.id == selId)
                            j++
                        }
                    }
                    this.draw()
                    isHit = true
                    this.nowSelectedNodes = meta.node
                    this.nodesClick(meta.node)
                    break
                }
                i++
            }
        }
        if (this.nowSelectedNodes != null && !isHit) {
            run {
                var j: Number = 0
                while(j < this.nodes.length){
                    this.nodes[j].node.selected = false
                    j++
                }
            }
            this.draw()
        }
        if (!isHit) {
            this.nowSelectedNodes = null
        }
    }
    public open fun onListen(call: (item: XTREEFLAT_CHILDREN) -> Unit) {
        this.nodesClick = call
    }
    public open fun mergeOpts(opts: XTreeFlatOpts?) {
        if (opts == null) {
            return
        }
        val o = opts
        if (o.bgColor != null) {
            this.config.bgColor = o.bgColor as String
        }
        if (o.nodeBgColor != null) {
            this.config.nodeBgColor = o.nodeBgColor as String
        }
        if (o.fontColor != null) {
            this.config.fontColor = o.fontColor as String
        }
        if (o.fontSize != null) {
            this.config.fontSize = o.fontSize as Number
        }
        if (o.lineColor != null) {
            this.config.lineColor = o.lineColor as String
        }
        if (o.lineWidth != null) {
            this.config.lineWidth = o.lineWidth as Number
        }
        if (o.padding != null) {
            this.config.padding = o.padding as Number
        }
        if (o.gutter != null) {
            this.config.gutter = o.gutter as Number
        }
        if (o.parentLineGutter != null) {
            this.config.parentLineGutter = o.parentLineGutter as Number
        }
        if (o.enbleOpenChildren != null) {
            this.config.enbleOpenChildren = o.enbleOpenChildren as Boolean
        }
        if (o.nodeRadius != null) {
            this.config.nodeRadius = o.nodeRadius as Number
        }
        if (o.layout != null) {
            this.config.layout = o.layout as XTREEFLAT_LAYOUT
        }
        if (o.lineType != null) {
            this.config.lineType = o.lineType as XTREEFLAT_LINE_TYPE
        }
    }
    public open fun relayoutFromCurrentData() {
        this.clearNodeSizeCache()
        this.calculateLayout()
        this.draw()
    }
    public open fun setData(newData: UTSArray<XTREEFLAT_NODES>) {
        this.updateData(newData)
        this.calculateLayout()
        this.draw()
    }
}
val GenUniModulesTmxUiComponentsTmxTreeFlatTmxTreeFlatClass = CreateVueComponent(GenUniModulesTmxUiComponentsTmxTreeFlatTmxTreeFlat::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesTmxUiComponentsTmxTreeFlatTmxTreeFlat.name, inheritAttrs = GenUniModulesTmxUiComponentsTmxTreeFlatTmxTreeFlat.inheritAttrs, inject = GenUniModulesTmxUiComponentsTmxTreeFlatTmxTreeFlat.inject, props = GenUniModulesTmxUiComponentsTmxTreeFlatTmxTreeFlat.props, propsNeedCastKeys = GenUniModulesTmxUiComponentsTmxTreeFlatTmxTreeFlat.propsNeedCastKeys, emits = GenUniModulesTmxUiComponentsTmxTreeFlatTmxTreeFlat.emits, components = GenUniModulesTmxUiComponentsTmxTreeFlatTmxTreeFlat.components, styles = GenUniModulesTmxUiComponentsTmxTreeFlatTmxTreeFlat.styles, setup = fun(props: ComponentPublicInstance, ctx: SetupContext): Any? {
        return GenUniModulesTmxUiComponentsTmxTreeFlatTmxTreeFlat.setup(props as GenUniModulesTmxUiComponentsTmxTreeFlatTmxTreeFlat, ctx)
    }
    )
}
, fun(instance, renderer): GenUniModulesTmxUiComponentsTmxTreeFlatTmxTreeFlat {
    return GenUniModulesTmxUiComponentsTmxTreeFlatTmxTreeFlat(instance)
}
)
val GenUniModulesTmxUiComponentsTmxMarkdownTmxMarkdownClass = CreateVueComponent(GenUniModulesTmxUiComponentsTmxMarkdownTmxMarkdown::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenUniModulesTmxUiComponentsTmxMarkdownTmxMarkdown.inheritAttrs, inject = GenUniModulesTmxUiComponentsTmxMarkdownTmxMarkdown.inject, props = GenUniModulesTmxUiComponentsTmxMarkdownTmxMarkdown.props, propsNeedCastKeys = GenUniModulesTmxUiComponentsTmxMarkdownTmxMarkdown.propsNeedCastKeys, emits = GenUniModulesTmxUiComponentsTmxMarkdownTmxMarkdown.emits, components = GenUniModulesTmxUiComponentsTmxMarkdownTmxMarkdown.components, styles = GenUniModulesTmxUiComponentsTmxMarkdownTmxMarkdown.styles)
}
, fun(instance, renderer): GenUniModulesTmxUiComponentsTmxMarkdownTmxMarkdown {
    return GenUniModulesTmxUiComponentsTmxMarkdownTmxMarkdown(instance)
}
)
val GenUniModulesFirstuiUvueComponentsFuiDialogFuiDialogClass = CreateVueComponent(GenUniModulesFirstuiUvueComponentsFuiDialogFuiDialog::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesFirstuiUvueComponentsFuiDialogFuiDialog.name, inheritAttrs = GenUniModulesFirstuiUvueComponentsFuiDialogFuiDialog.inheritAttrs, inject = GenUniModulesFirstuiUvueComponentsFuiDialogFuiDialog.inject, props = GenUniModulesFirstuiUvueComponentsFuiDialogFuiDialog.props, propsNeedCastKeys = GenUniModulesFirstuiUvueComponentsFuiDialogFuiDialog.propsNeedCastKeys, emits = GenUniModulesFirstuiUvueComponentsFuiDialogFuiDialog.emits, components = GenUniModulesFirstuiUvueComponentsFuiDialogFuiDialog.components, styles = GenUniModulesFirstuiUvueComponentsFuiDialogFuiDialog.styles)
}
, fun(instance, renderer): GenUniModulesFirstuiUvueComponentsFuiDialogFuiDialog {
    return GenUniModulesFirstuiUvueComponentsFuiDialogFuiDialog(instance)
}
)
val GenPagesTestComponentsClass = CreateVueComponent(GenPagesTestComponents::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesTestComponents.inheritAttrs, inject = GenPagesTestComponents.inject, props = GenPagesTestComponents.props, propsNeedCastKeys = GenPagesTestComponents.propsNeedCastKeys, emits = GenPagesTestComponents.emits, components = GenPagesTestComponents.components, styles = GenPagesTestComponents.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesTestComponents.setup(props as GenPagesTestComponents)
    }
    )
}
, fun(instance, renderer): GenPagesTestComponents {
    return GenPagesTestComponents(instance, renderer)
}
)
val GenPagesTestProgramClass = CreateVueComponent(GenPagesTestProgram::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesTestProgram.inheritAttrs, inject = GenPagesTestProgram.inject, props = GenPagesTestProgram.props, propsNeedCastKeys = GenPagesTestProgram.propsNeedCastKeys, emits = GenPagesTestProgram.emits, components = GenPagesTestProgram.components, styles = GenPagesTestProgram.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesTestProgram.setup(props as GenPagesTestProgram)
    }
    )
}
, fun(instance, renderer): GenPagesTestProgram {
    return GenPagesTestProgram(instance, renderer)
}
)
val GenPagesTestPaycodeClass = CreateVueComponent(GenPagesTestPaycode::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesTestPaycode.inheritAttrs, inject = GenPagesTestPaycode.inject, props = GenPagesTestPaycode.props, propsNeedCastKeys = GenPagesTestPaycode.propsNeedCastKeys, emits = GenPagesTestPaycode.emits, components = GenPagesTestPaycode.components, styles = GenPagesTestPaycode.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesTestPaycode.setup(props as GenPagesTestPaycode)
    }
    )
}
, fun(instance, renderer): GenPagesTestPaycode {
    return GenPagesTestPaycode(instance, renderer)
}
)
val GenUniModulesTmxUiComponentsTmxBadgeTmxBadgeClass = CreateVueComponent(GenUniModulesTmxUiComponentsTmxBadgeTmxBadge::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesTmxUiComponentsTmxBadgeTmxBadge.name, inheritAttrs = GenUniModulesTmxUiComponentsTmxBadgeTmxBadge.inheritAttrs, inject = GenUniModulesTmxUiComponentsTmxBadgeTmxBadge.inject, props = GenUniModulesTmxUiComponentsTmxBadgeTmxBadge.props, propsNeedCastKeys = GenUniModulesTmxUiComponentsTmxBadgeTmxBadge.propsNeedCastKeys, emits = GenUniModulesTmxUiComponentsTmxBadgeTmxBadge.emits, components = GenUniModulesTmxUiComponentsTmxBadgeTmxBadge.components, styles = GenUniModulesTmxUiComponentsTmxBadgeTmxBadge.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesTmxUiComponentsTmxBadgeTmxBadge.setup(props as GenUniModulesTmxUiComponentsTmxBadgeTmxBadge)
    }
    )
}
, fun(instance, renderer): GenUniModulesTmxUiComponentsTmxBadgeTmxBadge {
    return GenUniModulesTmxUiComponentsTmxBadgeTmxBadge(instance)
}
)
val GenUniModulesTmxUiComponentsTmxTabsTabsItemClass = CreateVueComponent(GenUniModulesTmxUiComponentsTmxTabsTabsItem::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesTmxUiComponentsTmxTabsTabsItem.name, inheritAttrs = GenUniModulesTmxUiComponentsTmxTabsTabsItem.inheritAttrs, inject = GenUniModulesTmxUiComponentsTmxTabsTabsItem.inject, props = GenUniModulesTmxUiComponentsTmxTabsTabsItem.props, propsNeedCastKeys = GenUniModulesTmxUiComponentsTmxTabsTabsItem.propsNeedCastKeys, emits = GenUniModulesTmxUiComponentsTmxTabsTabsItem.emits, components = GenUniModulesTmxUiComponentsTmxTabsTabsItem.components, styles = GenUniModulesTmxUiComponentsTmxTabsTabsItem.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesTmxUiComponentsTmxTabsTabsItem.setup(props as GenUniModulesTmxUiComponentsTmxTabsTabsItem)
    }
    )
}
, fun(instance, renderer): GenUniModulesTmxUiComponentsTmxTabsTabsItem {
    return GenUniModulesTmxUiComponentsTmxTabsTabsItem(instance)
}
)
open class GenUniModulesTmxUiComponentsTmxTabsTmxTabsSlotDataDefault (
    @JsonNotNull
    open var active: Boolean = false,
    @JsonNotNull
    open var item: TABS_ITEM,
) : SlotData()
val GenUniModulesTmxUiComponentsTmxTabsTmxTabsClass = CreateVueComponent(GenUniModulesTmxUiComponentsTmxTabsTmxTabs::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesTmxUiComponentsTmxTabsTmxTabs.name, inheritAttrs = GenUniModulesTmxUiComponentsTmxTabsTmxTabs.inheritAttrs, inject = GenUniModulesTmxUiComponentsTmxTabsTmxTabs.inject, props = GenUniModulesTmxUiComponentsTmxTabsTmxTabs.props, propsNeedCastKeys = GenUniModulesTmxUiComponentsTmxTabsTmxTabs.propsNeedCastKeys, emits = GenUniModulesTmxUiComponentsTmxTabsTmxTabs.emits, components = GenUniModulesTmxUiComponentsTmxTabsTmxTabs.components, styles = GenUniModulesTmxUiComponentsTmxTabsTmxTabs.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesTmxUiComponentsTmxTabsTmxTabs.setup(props as GenUniModulesTmxUiComponentsTmxTabsTmxTabs)
    }
    )
}
, fun(instance, renderer): GenUniModulesTmxUiComponentsTmxTabsTmxTabs {
    return GenUniModulesTmxUiComponentsTmxTabsTmxTabs(instance)
}
)
val GenComponentsXViewTitleActionClass = CreateVueComponent(GenComponentsXViewTitleAction::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsXViewTitleAction.inheritAttrs, inject = GenComponentsXViewTitleAction.inject, props = GenComponentsXViewTitleAction.props, propsNeedCastKeys = GenComponentsXViewTitleAction.propsNeedCastKeys, emits = GenComponentsXViewTitleAction.emits, components = GenComponentsXViewTitleAction.components, styles = GenComponentsXViewTitleAction.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsXViewTitleAction.setup(props as GenComponentsXViewTitleAction)
    }
    )
}
, fun(instance, renderer): GenComponentsXViewTitleAction {
    return GenComponentsXViewTitleAction(instance)
}
)
val GenPagesGoodsViewClass = CreateVueComponent(GenPagesGoodsView::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesGoodsView.inheritAttrs, inject = GenPagesGoodsView.inject, props = GenPagesGoodsView.props, propsNeedCastKeys = GenPagesGoodsView.propsNeedCastKeys, emits = GenPagesGoodsView.emits, components = GenPagesGoodsView.components, styles = GenPagesGoodsView.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesGoodsView.setup(props as GenPagesGoodsView)
    }
    )
}
, fun(instance, renderer): GenPagesGoodsView {
    return GenPagesGoodsView(instance, renderer)
}
)
val GenPagesTestWebviewClass = CreateVueComponent(GenPagesTestWebview::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesTestWebview.inheritAttrs, inject = GenPagesTestWebview.inject, props = GenPagesTestWebview.props, propsNeedCastKeys = GenPagesTestWebview.propsNeedCastKeys, emits = GenPagesTestWebview.emits, components = GenPagesTestWebview.components, styles = GenPagesTestWebview.styles)
}
, fun(instance, renderer): GenPagesTestWebview {
    return GenPagesTestWebview(instance, renderer)
}
)
open class Point (
    @JsonNotNull
    open var x: Number,
    @JsonNotNull
    open var y: Number,
) : UTSObject()
val GenUniModulesIboxsDocscanPagesDocscanClass = CreateVueComponent(GenUniModulesIboxsDocscanPagesDocscan::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenUniModulesIboxsDocscanPagesDocscan.inheritAttrs, inject = GenUniModulesIboxsDocscanPagesDocscan.inject, props = GenUniModulesIboxsDocscanPagesDocscan.props, propsNeedCastKeys = GenUniModulesIboxsDocscanPagesDocscan.propsNeedCastKeys, emits = GenUniModulesIboxsDocscanPagesDocscan.emits, components = GenUniModulesIboxsDocscanPagesDocscan.components, styles = GenUniModulesIboxsDocscanPagesDocscan.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesIboxsDocscanPagesDocscan.setup(props as GenUniModulesIboxsDocscanPagesDocscan)
    }
    )
}
, fun(instance, renderer): GenUniModulesIboxsDocscanPagesDocscan {
    return GenUniModulesIboxsDocscanPagesDocscan(instance, renderer)
}
)
val GenPagesTestOcrttsClass = CreateVueComponent(GenPagesTestOcrtts::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesTestOcrtts.inheritAttrs, inject = GenPagesTestOcrtts.inject, props = GenPagesTestOcrtts.props, propsNeedCastKeys = GenPagesTestOcrtts.propsNeedCastKeys, emits = GenPagesTestOcrtts.emits, components = GenPagesTestOcrtts.components, styles = GenPagesTestOcrtts.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesTestOcrtts.setup(props as GenPagesTestOcrtts)
    }
    )
}
, fun(instance, renderer): GenPagesTestOcrtts {
    return GenPagesTestOcrtts(instance, renderer)
}
)
val messages__1: UTSJSONObject = _uO("en" to UTSJSONObject.assign(_uO(), `default`, _uO("hellow" to "Hi~")), "zh-Hans" to UTSJSONObject.assign(_uO(), default__1, _uO("hellow" to "哈喽")), "zh-Hant" to default__2, "ko" to default__3, "ja" to default__4)
fun createApp(): UTSJSONObject {
    val app = createSSRApp(GenAppClass)
    app.use(tmxui, Tmui4xOptions(i18nOptions = I18nOptionsOrNull(locale = "zh-Hans", messages = messages__1)))
    return _uO("app" to app)
}
fun main(app: IApp) {
    definePageRoutes()
    defineAppConfig()
    (createApp()["app"] as VueApp).mount(app, GenUniApp())
}
open class UniAppConfig : io.dcloud.uniapp.appframe.AppConfig {
    override var name: String = "超市管理"
    override var appid: String = "__UNI__2971F61"
    override var versionName: String = "1.0.0"
    override var versionCode: String = "1"
    override var uniCompilerVersion: String = "5.07"
    constructor() : super() {}
}
fun definePageRoutes() {
    __uniRoutes.push(UniPageRoute(path = "pages/splash", component = GenPagesSplashClass, meta = UniPageMeta(isQuit = true), style = _uM("navigationStyle" to "custom", "hideBottomNavigationIndicator" to true, "hideStatusBar" to true)))
    __uniRoutes.push(UniPageRoute(path = "pages/index/index", component = GenPagesIndexIndexClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "首页", "navigationStyle" to "custom", "navigationBarTextStyle" to "white")))
    __uniRoutes.push(UniPageRoute(path = "pages/index/login", component = GenPagesIndexLoginClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "超市管理终端", "navigationBarTextStyle" to "black", "navigationStyle" to "custom")))
    __uniRoutes.push(UniPageRoute(path = "pages/index/tool", component = GenPagesIndexToolClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "工具", "navigationBarTextStyle" to "black", "navigationStyle" to "custom")))
    __uniRoutes.push(UniPageRoute(path = "pages/index/order", component = GenPagesIndexOrderClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "订单列表", "navigationBarTextStyle" to "white", "navigationStyle" to "custom")))
    __uniRoutes.push(UniPageRoute(path = "pages/index/staticpage", component = GenPagesIndexStaticpageClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "统计中心", "navigationBarTextStyle" to "white", "navigationBarBackgroundColor" to "#0080FF")))
    __uniRoutes.push(UniPageRoute(path = "pages/index/mine", component = GenPagesIndexMineClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "我的", "navigationBarTextStyle" to "white", "navigationStyle" to "custom")))
    __uniRoutes.push(UniPageRoute(path = "pages/casher/receive", component = GenPagesCasherReceiveClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "直接收款", "navigationBarTextStyle" to "white", "navigationStyle" to "custom")))
    __uniRoutes.push(UniPageRoute(path = "pages/casher/online_receive", component = GenPagesCasherOnlineReceiveClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "在线收款", "navigationBarTextStyle" to "white", "navigationStyle" to "custom")))
    __uniRoutes.push(UniPageRoute(path = "pages/common/choosemember", component = GenPagesCommonChoosememberClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "选择会员", "navigationStyle" to "custom", "navigationBarTextStyle" to "white")))
    __uniRoutes.push(UniPageRoute(path = "pages/common/choosedepart", component = GenPagesCommonChoosedepartClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "选择门店/仓库", "navigationStyle" to "custom", "navigationBarTextStyle" to "white")))
    __uniRoutes.push(UniPageRoute(path = "pages/member/view", component = GenPagesMemberViewClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "会员详情", "navigationStyle" to "custom", "navigationBarTextStyle" to "white")))
    __uniRoutes.push(UniPageRoute(path = "pages/goods/query", component = GenPagesGoodsQueryClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "商品查询", "navigationStyle" to "custom", "navigationBarTextStyle" to "black")))
    __uniRoutes.push(UniPageRoute(path = "pages/warehouse/instorage/addinstorage", component = GenPagesWarehouseInstorageAddinstorageClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "商品入库", "navigationStyle" to "custom", "navigationBarTextStyle" to "white")))
    __uniRoutes.push(UniPageRoute(path = "pages/common/choosecity", component = GenPagesCommonChoosecityClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "选择城市", "navigationStyle" to "custom", "navigationBarTextStyle" to "black")))
    __uniRoutes.push(UniPageRoute(path = "pages/common/choosepurchaseorder", component = GenPagesCommonChoosepurchaseorderClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "选择进货单", "navigationStyle" to "custom", "navigationBarTextStyle" to "white")))
    __uniRoutes.push(UniPageRoute(path = "pages/common/choosearea", component = GenPagesCommonChooseareaClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "选择地区", "navigationStyle" to "custom", "navigationBarTextStyle" to "white")))
    __uniRoutes.push(UniPageRoute(path = "pages/warehouse/purchase/purchase", component = GenPagesWarehousePurchasePurchaseClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "进货单", "navigationStyle" to "custom", "navigationBarTextStyle" to "white")))
    __uniRoutes.push(UniPageRoute(path = "pages/warehouse/purchase/editpurchase", component = GenPagesWarehousePurchaseEditpurchaseClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "创建进货单", "navigationStyle" to "custom", "navigationBarTextStyle" to "white")))
    __uniRoutes.push(UniPageRoute(path = "pages/common/choosegoods", component = GenPagesCommonChoosegoodsClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "选择商品", "navigationStyle" to "custom", "navigationBarTextStyle" to "white")))
    __uniRoutes.push(UniPageRoute(path = "uni_modules/iboxs-choosemedia/pages/choose", component = GenUniModulesIboxsChoosemediaPagesChooseClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "选择图片", "navigationStyle" to "custom", "navigationBarTextStyle" to "white", "backgroundColorContent" to "#484848")))
    __uniRoutes.push(UniPageRoute(path = "uni_modules/iboxs-choosemedia/pages/preview", component = GenUniModulesIboxsChoosemediaPagesPreviewClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "预览图片", "navigationStyle" to "custom", "navigationBarTextStyle" to "white", "hideStatusBar" to true, "backgroundColorContent" to "#000")))
    __uniRoutes.push(UniPageRoute(path = "pages/common/browser", component = GenPagesCommonBrowserClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "内置浏览器", "navigationBarTextStyle" to "white", "navigationBarBackgroundColor" to "#0080FF")))
    __uniRoutes.push(UniPageRoute(path = "pages/common/scangoods", component = GenPagesCommonScangoodsClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "商品批量扫码识别添加", "navigationBarTextStyle" to "white", "navigationBarBackgroundColor" to "#0080FF", "navigationStyle" to "custom")))
    __uniRoutes.push(UniPageRoute(path = "pages/common/documentprintview", component = GenPagesCommonDocumentprintviewClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "单据打印预览", "navigationStyle" to "custom", "navigationBarTextStyle" to "white", "navigationBarBackgroundColor" to "#F8F8F8")))
    __uniRoutes.push(UniPageRoute(path = "pages/warehouse/purchase/purchaseview", component = GenPagesWarehousePurchasePurchaseviewClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "进货单详情", "navigationStyle" to "custom", "navigationBarTextStyle" to "white")))
    __uniRoutes.push(UniPageRoute(path = "pages/warehouse/stocktasking/stocktask", component = GenPagesWarehouseStocktaskingStocktaskClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "库存盘点", "navigationStyle" to "custom", "navigationBarTextStyle" to "white")))
    __uniRoutes.push(UniPageRoute(path = "pages/warehouse/stocktasking/addstocktask", component = GenPagesWarehouseStocktaskingAddstocktaskClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "添加任务", "navigationStyle" to "custom", "navigationBarTextStyle" to "white")))
    __uniRoutes.push(UniPageRoute(path = "pages/common/chooseadmin", component = GenPagesCommonChooseadminClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "选择员工", "navigationStyle" to "custom", "navigationBarTextStyle" to "white")))
    __uniRoutes.push(UniPageRoute(path = "pages/warehouse/stocktasking/stocktaskview", component = GenPagesWarehouseStocktaskingStocktaskviewClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "任务详情", "navigationStyle" to "custom", "navigationBarTextStyle" to "white")))
    __uniRoutes.push(UniPageRoute(path = "pages/warehouse/stocktasking/runstocktask", component = GenPagesWarehouseStocktaskingRunstocktaskClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "盘点中", "navigationStyle" to "custom", "navigationBarTextStyle" to "white")))
    __uniRoutes.push(UniPageRoute(path = "pages/warehouse/stocktasking/viewstocktaskdata", component = GenPagesWarehouseStocktaskingViewstocktaskdataClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "预览核对数据", "navigationStyle" to "custom", "navigationBarTextStyle" to "white")))
    __uniRoutes.push(UniPageRoute(path = "pages/warehouse/stocktasking/showstocktaskdata", component = GenPagesWarehouseStocktaskingShowstocktaskdataClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "查看盘点结果", "navigationStyle" to "custom", "navigationBarTextStyle" to "white")))
    __uniRoutes.push(UniPageRoute(path = "pages/warehouse/requiregoods/list", component = GenPagesWarehouseRequiregoodsListClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "要货单", "navigationStyle" to "custom", "navigationBarTextStyle" to "white")))
    __uniRoutes.push(UniPageRoute(path = "pages/warehouse/requiregoods/addrequiregoods", component = GenPagesWarehouseRequiregoodsAddrequiregoodsClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "创建要货单", "navigationStyle" to "custom", "navigationBarTextStyle" to "white")))
    __uniRoutes.push(UniPageRoute(path = "pages/warehouse/requiregoods/view", component = GenPagesWarehouseRequiregoodsViewClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "要货单详情", "navigationStyle" to "custom", "navigationBarTextStyle" to "white")))
    __uniRoutes.push(UniPageRoute(path = "uni_modules/iboxs-amap/pages/chooselocation", component = GenUniModulesIboxsAmapPagesChooselocationClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "选择地址", "navigationStyle" to "custom", "navigationBarTextStyle" to "black")))
    __uniRoutes.push(UniPageRoute(path = "uni_modules/iboxs-amap/pages/showlocation", component = GenUniModulesIboxsAmapPagesShowlocationClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "查看地址", "navigationStyle" to "custom", "navigationBarTextStyle" to "black")))
    __uniRoutes.push(UniPageRoute(path = "pages/warehouse/allocate/allocate", component = GenPagesWarehouseAllocateAllocateClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "调拨单", "navigationStyle" to "custom", "navigationBarTextStyle" to "white")))
    __uniRoutes.push(UniPageRoute(path = "pages/warehouse/allocate/addorder", component = GenPagesWarehouseAllocateAddorderClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "创建调拨单", "navigationStyle" to "custom", "navigationBarTextStyle" to "white")))
    __uniRoutes.push(UniPageRoute(path = "pages/common/chooserequireorder", component = GenPagesCommonChooserequireorderClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "选择要货单", "navigationStyle" to "custom", "navigationBarTextStyle" to "white")))
    __uniRoutes.push(UniPageRoute(path = "pages/warehouse/allocate/view", component = GenPagesWarehouseAllocateViewClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "调拨单详情", "navigationStyle" to "custom", "navigationBarTextStyle" to "white")))
    __uniRoutes.push(UniPageRoute(path = "pages/common/chooseallocateorder", component = GenPagesCommonChooseallocateorderClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "选择调拨单", "navigationStyle" to "custom", "navigationBarTextStyle" to "white")))
    __uniRoutes.push(UniPageRoute(path = "pages/common/browserAction", component = GenPagesCommonBrowserActionClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "带操作的浏览器", "navigationStyle" to "custom", "navigationBarTextStyle" to "black")))
    __uniRoutes.push(UniPageRoute(path = "pages/common/choosesupplier", component = GenPagesCommonChoosesupplierClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "选择供应商", "navigationStyle" to "custom", "navigationBarTextStyle" to "white")))
    __uniRoutes.push(UniPageRoute(path = "pages/warehouse/instorage/view", component = GenPagesWarehouseInstorageViewClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "入库单详情", "navigationStyle" to "custom", "navigationBarTextStyle" to "white")))
    __uniRoutes.push(UniPageRoute(path = "pages/warehouse/instorage/instorage", component = GenPagesWarehouseInstorageInstorageClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "入库单", "navigationStyle" to "custom", "navigationBarTextStyle" to "white")))
    __uniRoutes.push(UniPageRoute(path = "pages/user/message/msgbox", component = GenPagesUserMessageMsgboxClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "消息盒子", "navigationStyle" to "custom", "navigationBarTextStyle" to "white")))
    __uniRoutes.push(UniPageRoute(path = "pages/user/message/systemmsg", component = GenPagesUserMessageSystemmsgClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "系统消息", "navigationStyle" to "custom", "navigationBarTextStyle" to "white")))
    __uniRoutes.push(UniPageRoute(path = "pages/user/message/chatmsg", component = GenPagesUserMessageChatmsgClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "聊天消息", "navigationStyle" to "custom", "navigationBarTextStyle" to "white", "backgroundColor" to "#EDEDED", "backgroundColorContent" to "#EDEDED")))
    __uniRoutes.push(UniPageRoute(path = "pages/analysis/todayanalysis", component = GenPagesAnalysisTodayanalysisClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "今日统计", "navigationStyle" to "custom", "navigationBarTextStyle" to "white", "backgroundColor" to "#F5F5F5", "backgroundColorContent" to "#F5F5F5")))
    __uniRoutes.push(UniPageRoute(path = "pages/warehouse/outstorage/addoutstorage", component = GenPagesWarehouseOutstorageAddoutstorageClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "创建出库单", "navigationStyle" to "custom", "navigationBarTextStyle" to "white")))
    __uniRoutes.push(UniPageRoute(path = "pages/warehouse/outstorage/outstorage", component = GenPagesWarehouseOutstorageOutstorageClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "出库单列表", "navigationStyle" to "custom", "navigationBarTextStyle" to "white")))
    __uniRoutes.push(UniPageRoute(path = "pages/warehouse/outstorage/view", component = GenPagesWarehouseOutstorageViewClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "出库单详情", "navigationStyle" to "custom", "navigationBarTextStyle" to "white")))
    __uniRoutes.push(UniPageRoute(path = "pages/goods/index", component = GenPagesGoodsIndexClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "商品列表", "navigationStyle" to "custom", "navigationBarTextStyle" to "white")))
    __uniRoutes.push(UniPageRoute(path = "pages/test/pdf", component = GenPagesTestPdfClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "PDF显示测试", "backgroundColorContent" to "#f5f5f5")))
    __uniRoutes.push(UniPageRoute(path = "pages/test/map", component = GenPagesTestMapClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "地图显示", "backgroundColorContent" to "#f5f5f5")))
    __uniRoutes.push(UniPageRoute(path = "pages/test/components", component = GenPagesTestComponentsClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "组件", "backgroundColorContent" to "#f5f5f5")))
    __uniRoutes.push(UniPageRoute(path = "pages/test/program", component = GenPagesTestProgramClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "功能测试", "backgroundColorContent" to "#f5f5f5")))
    __uniRoutes.push(UniPageRoute(path = "pages/test/paycode", component = GenPagesTestPaycodeClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "支付码测试", "backgroundColorContent" to "#f5f5f5")))
    __uniRoutes.push(UniPageRoute(path = "pages/goods/view", component = GenPagesGoodsViewClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "商品详情", "navigationStyle" to "custom", "navigationBarTextStyle" to "white", "backgroundColor" to "#F5F5F5", "backgroundColorContent" to "#F5F5F5")))
    __uniRoutes.push(UniPageRoute(path = "pages/test/webview", component = GenPagesTestWebviewClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "")))
    __uniRoutes.push(UniPageRoute(path = "uni_modules/iboxs-docscan/pages/docscan", component = GenUniModulesIboxsDocscanPagesDocscanClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "扫描文档", "navigationStyle" to "custom", "hideStatusBar" to true)))
    __uniRoutes.push(UniPageRoute(path = "pages/test/ocrtts", component = GenPagesTestOcrttsClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "")))
}
val __uniTabBar: Map<String, Any?>? = _uM("color" to "#8C8C8C", "selectedColor" to "#0080FF", "height" to "60px", "list" to _uA(
    _uM("pagePath" to "pages/index/index", "iconPath" to "/static/tabbar/index.png", "selectedIconPath" to "/static/tabbar/index-active.png", "text" to "首页"),
    _uM("pagePath" to "pages/index/tool", "iconPath" to "/static/tabbar/tool.png", "selectedIconPath" to "/static/tabbar/tool-active.png", "text" to "工具"),
    _uM("pagePath" to "pages/index/order", "iconPath" to "/static/tabbar/order.png", "selectedIconPath" to "/static/tabbar/order-active.png", "text" to "订单列表"),
    _uM("pagePath" to "pages/index/staticpage", "iconPath" to "/static/tabbar/static.png", "selectedIconPath" to "/static/tabbar/static-active.png", "text" to "统计中心"),
    _uM("pagePath" to "pages/index/mine", "iconPath" to "/static/tabbar/wode.png", "selectedIconPath" to "/static/tabbar/wode-active.png", "text" to "我的")
))
val __uniLaunchPage: Map<String, Any?> = _uM("url" to "pages/splash", "style" to _uM("navigationStyle" to "custom", "hideBottomNavigationIndicator" to true, "hideStatusBar" to true))
fun defineAppConfig() {
    __uniConfig.entryPagePath = "/pages/splash"
    __uniConfig.globalStyle = _uM("navigationBarTextStyle" to "black", "navigationBarTitleText" to "超市管理", "navigationBarBackgroundColor" to "#f5f5f5", "backgroundColor" to "#f5f5f5", "backgroundColorContent" to "#f5f5f5")
    __uniConfig.getTabBarConfig = fun(): Map<String, Any>? {
        return _uM("color" to "#8C8C8C", "selectedColor" to "#0080FF", "height" to "60px", "list" to _uA(
            _uM("pagePath" to "pages/index/index", "iconPath" to "/static/tabbar/index.png", "selectedIconPath" to "/static/tabbar/index-active.png", "text" to "首页"),
            _uM("pagePath" to "pages/index/tool", "iconPath" to "/static/tabbar/tool.png", "selectedIconPath" to "/static/tabbar/tool-active.png", "text" to "工具"),
            _uM("pagePath" to "pages/index/order", "iconPath" to "/static/tabbar/order.png", "selectedIconPath" to "/static/tabbar/order-active.png", "text" to "订单列表"),
            _uM("pagePath" to "pages/index/staticpage", "iconPath" to "/static/tabbar/static.png", "selectedIconPath" to "/static/tabbar/static-active.png", "text" to "统计中心"),
            _uM("pagePath" to "pages/index/mine", "iconPath" to "/static/tabbar/wode.png", "selectedIconPath" to "/static/tabbar/wode-active.png", "text" to "我的")
        ))
    }
    __uniConfig.tabBar = __uniConfig.getTabBarConfig()
    __uniConfig.conditionUrl = ""
    __uniConfig.uniIdRouter = _uM()
    __uniConfig.ready = true
}
var `___$i18n` = xConfig.i18n
var VueComponent.`$i18n`
    get() = `___$i18n`
    set(value) {
        `___$i18n` = value
    }
open class GenUniApp : UniAppImpl() {
    open val vm: GenApp?
        get() {
            return getAppVm() as GenApp?
        }
    open val `$vm`: GenApp?
        get() {
            return getAppVm() as GenApp?
        }
    open var globalData = GenGlobalData()
}
fun getApp(): GenUniApp {
    return getUniApp() as GenUniApp
}
