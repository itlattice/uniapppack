@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNIHelloUniAppX
import io.dcloud.uniapp.*
import io.dcloud.uniapp.extapi.*
import io.dcloud.uniapp.framework.*
import io.dcloud.uniapp.runtime.*
import io.dcloud.uniapp.vue.*
import io.dcloud.uniapp.vue.shared.*
import io.dcloud.unicloud.*
import io.dcloud.uts.*
import io.dcloud.uts.Map
import io.dcloud.uts.Set
import io.dcloud.uts.UTSAndroid
import kotlin.properties.Delegates
import io.dcloud.uniapp.extapi.createRequestPermissionListener as uni_createRequestPermissionListener
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesAPICreateRequestPermissionListenerCreateRequestPermissionListener : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onLoad(fun(_: OnLoadOptions) {
            stat_instance.onLoad(this)
        }
        , __ins)
        onPageShow(fun() {
            stat_instance.onShow(this)
        }
        , __ins)
        onPageHide(fun() {
            stat_instance.onHide(this)
        }
        , __ins)
        onUnload(fun() {
            stat_instance.onUnload(this)
        }
        , __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPICreateRequestPermissionListenerCreateRequestPermissionListener) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPICreateRequestPermissionListenerCreateRequestPermissionListener
            val _cache = __ins.renderCache
            val isPermissionAlertShow = ref(false)
            val permissionAlert = ref(null as UniElement?)
            val timeoutId = ref(-1)
            val permissionListener = ref(null as RequestPermissionListener?)
            onUnload(fun(){
                permissionListener.value?.stop()
                permissionListener.value = null
                clearTimeout(timeoutId.value)
            }
            )
            val watchPermissionRRequest = fun(){
                permissionListener.value = uni_createRequestPermissionListener()
                permissionListener.value!!.onConfirm(fun(_){
                    timeoutId.value = setTimeout(fun(){
                        isPermissionAlertShow.value = true
                    }
                    , 100)
                }
                )
                permissionListener.value!!.onComplete(fun(_){
                    clearTimeout(timeoutId.value)
                    isPermissionAlertShow.value = false
                }
                )
            }
            val requestPermission = fun(){
                if (UTSAndroid.checkSystemPermissionGranted(UTSAndroid.getUniActivity()!!, _uA(
                    "android.permission.READ_CALENDAR"
                ))) {
                    uni_showToast(ShowToastOptions(title = "权限已经同意了，不需要再申请", position = "bottom"))
                    return
                }
                UTSAndroid.requestSystemPermission(UTSAndroid.getUniActivity()!!, _uA(
                    "android.permission.READ_CALENDAR"
                ), fun(_: Boolean, p: UTSArray<String>){
                    console.log(p)
                }
                , fun(_: Boolean, p: UTSArray<String>){
                    uni_showToast(ShowToastOptions(title = "权限被拒绝了", position = "bottom"))
                    console.log(p)
                }
                )
            }
            onReady(fun(){
                watchPermissionRRequest()
            }
            )
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cV(_component_page_head, _uM("title" to "权限申请监听")),
                    _cE("view", _uM("class" to "permission-alert", "id" to "permission-alert", "style" to _nS(_uM("transform" to if (unref(isPermissionAlertShow)) {
                        "translateY(0)"
                    } else {
                        "translateY(-110px)"
                    }
                    ))), _uA(
                        _cE("text", _uM("style" to _nS(_uM("font-size" to "20px", "margin-bottom" to "10px", "margin-top" to "5px"))), "访问日历权限申请说明：", 4),
                        _cE("text", _uM("style" to _nS(_uM("color" to "darkgray"))), "uni-app x正在申请访问日历权限用于演示，允许或拒绝均不会获取任何隐私信息。", 4)
                    ), 4),
                    _cE("button", _uM("type" to "primary", "style" to _nS(_uM("margin" to "10px")), "onClick" to requestPermission), "点击申请日历权限", 4)
                ), 4)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("permission-alert" to _pS(_uM("width" to "90%", "height" to 100, "marginTop" to 10, "marginRight" to "5%", "marginBottom" to 10, "marginLeft" to "5%", "position" to "absolute", "top" to 0, "zIndex" to 3, "borderTopLeftRadius" to 5, "borderTopRightRadius" to 5, "borderBottomRightRadius" to 5, "borderBottomLeftRadius" to 5, "transitionProperty" to "transform", "transitionDuration" to "200ms", "backgroundColor" to "#FFFFFF", "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10)), "@TRANSITION" to _uM("permission-alert" to _uM("property" to "transform", "duration" to "200ms")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
