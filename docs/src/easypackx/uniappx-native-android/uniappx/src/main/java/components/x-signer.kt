@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNI2971F61
import android.content.Context
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
import uts.sdk.modules.iboxsZimfacade.faceVerify
import uts.sdk.modules.iboxsZimfacade.getMetaInfo
import uts.sdk.modules.iboxsZimfacade.initZimfacafe
import uts.sdk.modules.iboxsZimfacade.setUI
import uts.sdk.modules.iboxsScancode.taskPhoto
open class GenComponentsXSigner : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var i18n: Tmui4xI18nTml by `$data`
    open var open: () -> Unit
        get() {
            return unref(this.`$exposed`["open"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "open", value)
        }
    open var close: () -> Unit
        get() {
            return unref(this.`$exposed`["close"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "close", value)
        }
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXSigner, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXSigner
            val _cache = __ins.renderCache
            val visible = ref(false)
            val penColor = ref("black")
            val penSize = ref(3)
            val openSmooth = ref(true)
            val time = ref(false)
            val signImgUrl = ref("")
            val signID = ref(0)
            val signatureRef = ref<LSignatureComponentPublicInstance?>(null)
            val loading = ref<UniElement?>(null)
            val resetSignerState = fun(){
                time.value = false
                signImgUrl.value = ""
                signID.value = 0
            }
            watch(visible, fun(newVal: Boolean){
                if (!newVal) {
                    return
                }
                if (signatureRef.value == null) {
                    return
                }
                signatureRef.value!!.clear()
            }
            )
            val close = fun(){
                if (signatureRef.value != null) {
                    signatureRef.value!!.clear()
                }
                resetSignerState()
                visible.value = false
            }
            val closePopup = fun(){
                if (signatureRef.value == null) {
                    visible.value = false
                    uni__emit("signer", _uO("code" to -10, "data" to null))
                    return
                }
                uni__emit("signer", _uO("code" to -10, "data" to null))
                close()
            }
            val open = fun(){
                resetSignerState()
                visible.value = true
            }
            val cancel = fun(){
                closePopup()
            }
            val useTopTime = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        common.loading(loading.value)
                        var res = await(request.callapi("user/getsigner", _uO()))
                        common.hideLoading(loading.value)
                        if (res.code < 0) {
                            common.toast(res.msg)
                            return@w1
                        }
                        time.value = true
                        var result = res.data as UTSJSONObject
                        signImgUrl.value = result["url"] as String
                        signID.value = result["id"] as Number
                })
            }
            val faceAuthInfo = fun(key: String): UTSPromise<Number> {
                return wrapUTSPromise(suspend w1@{
                        var info = await(authinfo.startFaceVerify())
                        if (!info.result) {
                            common.toast(info.reson as String)
                            closePopup()
                            return@w1 0
                        }
                        var certifyId = info.certifyId
                        if (certifyId == null) {
                            common.toast("数据异常")
                            closePopup()
                            return@w1 0
                        }
                        var signRes = await(request.callapi("user/setsigner", _uO("key" to key, "method" to "face", "certify" to certifyId, "meta" to common.getMetaInfo())))
                        if (signRes.code < 0) {
                            common.toast(signRes.msg)
                            closePopup()
                            return@w1 0
                        }
                        val signerId = (signRes.data as UTSJSONObject)["id"] as Number
                        return@w1 signerId
                })
            }
            val getFaceImg = fun(): UTSPromise<String?> {
                return wrapUTSPromise(suspend w1@{
                        var permissionNeed = _uA(
                            "android.permission.CAMERA",
                            "android.permission.WRITE_EXTERNAL_STORAGE"
                        )
                        var res = await(UTSPromise(fun(resolve, reject){
                            UTSAndroid.requestSystemPermission(UTSAndroid.getUniActivity()!!, permissionNeed, fun(allRight: Boolean, grantedList: UTSArray<String>){
                                if (!allRight) {
                                    common.toast("无权限")
                                    resolve(null)
                                    return
                                }
                                taskPhoto(fun(url: String){
                                    common.loading(loading.value)
                                    request.cosUpload("image", "jpeg", url, "signer_face", "private").then(fun(key: Any){
                                        console.log("签名照片", key)
                                        common.hideLoading(loading.value)
                                        common.deleteAppFile(url)
                                        resolve(key.toString())
                                    }
                                    )
                                }
                                , fun(err: String?){
                                    console.error("拍照失败" + err)
                                    resolve(null)
                                }
                                )
                            }
                            , fun(doNotAskAgain: Boolean, grantedList: UTSArray<String>){
                                common.toast("无权限")
                                resolve(null)
                            }
                            )
                        }
                        ))
                        return@w1 res as String?
                })
            }
            val getSignImg = fun(): UTSPromise<String?> {
                return wrapUTSPromise(suspend w1@{
                        if (signatureRef.value == null) {
                            return@w1 null
                        }
                        var res = await(UTSPromise(fun(resolve, reject){
                            signatureRef.value?.canvasToTempFilePath(LimeSignatureToTempFilePathOptions(success = fun(res: LimeSignatureToFileSuccess){
                                console.log(res.isEmpty)
                                if (res.isEmpty) {
                                    resolve(null)
                                    return
                                }
                                var url = res.tempFilePath
                                resolve(url)
                            }
                            ))
                        }
                        ))
                        return@w1 res as String?
                })
            }
            val uploadSigner = fun(url: String): UTSPromise<String?> {
                return wrapUTSPromise(suspend w1@{
                        var key = await(request.cosUpload("image", "png", url, "signer", "private"))
                        common.deleteAppFile(url)
                        return@w1 key
                })
            }
            val confirm = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        if (time.value) {
                            uni__emit("signer", _uO("code" to 0, "data" to signID.value))
                            return@w1
                        }
                        var imgFile = await(getSignImg())
                        if (imgFile == null) {
                            common.toast("无签名信息")
                            return@w1
                        }
                        var key = await(uploadSigner("file://" + imgFile))
                        if (key == null) {
                            common.toast("签名上传失败")
                            closePopup()
                            return@w1
                        }
                        var metainfo = common.getMetaInfo()
                        var faceRes = await(request.callapi("user/getsignersign", _uO("meta" to JSON.parseObject(metainfo))))
                        if (faceRes.code < 0) {
                            common.toast(faceRes.msg)
                            closePopup()
                            return@w1
                        }
                        var signerId: Number = 0
                        if (faceRes.code == 1) {
                            signerId = await(faceAuthInfo(key as String)) as Number
                            if (signerId <= 0) {
                                common.toast("数据校验失败")
                                closePopup()
                                return@w1
                            }
                        } else {
                            var faceImg = await(getFaceImg())
                            if (faceImg == null) {
                                closePopup()
                                return@w1
                            }
                            var signRes = await(request.callapi("user/setsigner", _uO("key" to key, "method" to "camera", "face" to faceImg, "meta" to metainfo)))
                            if (signRes.code < 0) {
                                common.toast(signRes.msg)
                                closePopup()
                                return@w1
                            }
                            signerId = (signRes.data as UTSJSONObject)["id"] as Number
                        }
                        uni__emit("signer", _uO("code" to 0, "data" to signerId))
                })
            }
            __expose(_uM("open" to open, "close" to close))
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_l_signature = resolveEasyComponent("l-signature", GenUniModulesLimeSignatureComponentsLSignatureLSignatureClass)
                val _component_x_loading = resolveEasyComponent("x-loading", GenComponentsXLoadingClass)
                val _component_fui_bottom_popup = resolveEasyComponent("fui-bottom-popup", GenUniModulesFirstuiUvueComponentsFuiBottomPopupFuiBottomPopupClass)
                return _cV(_component_fui_bottom_popup, _uM("visible" to unref(visible), "onClose" to closePopup, "zIndex" to 9999998), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "signer padding-safe-bottom"), _uA(
                            _cE("text", _uM("class" to "title"), "请签字确认"),
                            _cE("view", _uM("class" to "closebtn", "onClick" to cancel), _uA(
                                _cV(_component_x_iconfont, _uM("name" to "guanbi", "color" to "#ccc", "size" to "18"))
                            )),
                            if (unref(time) == false) {
                                _cE("view", _uM("key" to 0, "class" to "signerconsole"), _uA(
                                    _cV(_component_l_signature, _uM("ref_key" to "signatureRef", "ref" to signatureRef, "disableScroll" to "", "penColor" to unref(penColor), "penSize" to unref(penSize), "openSmooth" to unref(openSmooth)), null, 8, _uA(
                                        "penColor",
                                        "penSize",
                                        "openSmooth"
                                    ))
                                ))
                            } else {
                                _cE("view", _uM("key" to 1, "class" to "signerconsole"), _uA(
                                    _cE("image", _uM("src" to unref(signImgUrl), "class" to "full"), null, 8, _uA(
                                        "src"
                                    ))
                                ))
                            }
                            ,
                            _cE("view", _uM("class" to "actions"), _uA(
                                _cE("button", _uM("hover-class" to "none", "onClick" to useTopTime, "class" to "btn cancel"), "使用上次"),
                                _cE("button", _uM("hover-class" to "none", "onClick" to confirm, "class" to "btn confirm"), "确认")
                            ))
                        )),
                        _cV(_component_x_loading, _uM("ref_key" to "loading", "ref" to loading), null, 512)
                    )
                }
                ), "_" to 1), 8, _uA(
                    "visible"
                ))
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("signer" to _pS(_uM("width" to "750rpx", "height" to "490rpx", "position" to "relative")), "closebtn" to _uM(".signer " to _uM("position" to "absolute", "right" to "20rpx", "top" to 10)), "title" to _uM(".signer " to _uM("fontSize" to 16, "textAlign" to "center", "lineHeight" to "30px")), "signerconsole" to _uM(".signer " to _uM("width" to "750rpx", "height" to "420rpx")), "actions" to _uM(".signer " to _uM("position" to "absolute", "bottom" to "var(--uni-safe-area-inset-bottom)", "display" to "flex", "flexDirection" to "row", "height" to 50)), "btn" to _uM(".signer .actions " to _uM("width" to "375rpx", "lineHeight" to "50px", "borderTopLeftRadius" to 0, "borderTopRightRadius" to 0, "borderBottomRightRadius" to 0, "borderBottomLeftRadius" to 0, "borderTopWidth" to 0, "borderRightWidth" to 0, "borderBottomWidth" to 0, "borderLeftWidth" to 0, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#000000", "borderRightColor" to "#000000", "borderBottomColor" to "#000000", "borderLeftColor" to "#000000")), "cancel" to _uM(".signer .actions " to _uM("backgroundImage" to "none", "backgroundColor" to "#e8e8e8")), "confirm" to _uM(".signer .actions " to _uM("backgroundImage" to "none", "backgroundColor" to "#1678fd", "color" to "#FFFFFF")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
