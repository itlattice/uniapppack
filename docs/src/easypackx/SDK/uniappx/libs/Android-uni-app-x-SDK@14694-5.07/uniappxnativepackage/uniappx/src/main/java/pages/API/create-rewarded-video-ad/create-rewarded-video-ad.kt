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
import io.dcloud.uniapp.extapi.createRewardedVideoAd as uni_createRewardedVideoAd
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesAPICreateRewardedVideoAdCreateRewardedVideoAd : BasePage {
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
        var setup: (__props: GenPagesAPICreateRewardedVideoAdCreateRewardedVideoAd) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPICreateRewardedVideoAdCreateRewardedVideoAd
            val _cache = __ins.renderCache
            val errorDetails = ref(_uA<String>())
            val btnText = ref("")
            val btnType = ref("primary")
            val btnDisable = ref(false)
            val rewardAd = ref(null as RewardedVideoAd?)
            val isAdLoadSuccess = ref(false)
            var loadAd: LoadAdType = fun(){}
            loadAd = fun(){
                if (btnDisable.value) {
                    return
                }
                btnDisable.value = true
                btnText.value = "正在加载广告"
                btnType.value = "primary"
                if (rewardAd.value == null) {
                    rewardAd.value = uni_createRewardedVideoAd(CreateRewardedVideoAdOptions(adpid = "1507000689"))
                    rewardAd.value!!.onError(fun(res){
                        errorDetails.value.length = 0
                        btnType.value = "warn"
                        btnDisable.value = false
                        btnText.value = res.errMsg
                        val errors = (res.cause as UniAggregateError?)?.errors
                        if (errors != null && errors.length > 0) {
                            run {
                                var a: Number = 0
                                while(a < errors.length){
                                    var msg = JSON.stringify(errors[a])
                                    errorDetails.value.push(msg)
                                    a++
                                }
                            }
                        }
                    }
                    )
                    rewardAd.value!!.onLoad(fun(_){
                        errorDetails.value.length = 0
                        btnType.value = "primary"
                        btnText.value = "广告加载成功，点击观看"
                        btnDisable.value = false
                        isAdLoadSuccess.value = true
                    }
                    )
                    rewardAd.value!!.onClose(fun(e){
                        isAdLoadSuccess.value = false
                        uni_showToast(ShowToastOptions(title = "激励视频" + (if (e.isEnded) {
                            ""
                        } else {
                            "未"
                        }
                        ) + "播放完毕", position = "bottom"))
                        loadAd()
                    }
                    )
                }
                rewardAd.value!!.load().`catch`(fun(){})
            }
            val showAd = fun(){
                if (isAdLoadSuccess.value) {
                    rewardAd.value!!.show().`catch`(fun(){})
                } else {
                    loadAd()
                }
            }
            onReady(fun(){
                loadAd()
            }
            )
            onPageHide(fun(){
                console.log("Page Hide")
            }
            )
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE(Fragment, null, _uA(
                    _cV(_component_page_head, _uM("title" to "激励视频广告")),
                    _cE("button", _uM("type" to unref(btnType), "style" to _nS(_uM("margin" to "10px")), "disabled" to unref(btnDisable), "onClick" to fun(){
                        showAd()
                    }
                    ), _tD(unref(btnText)), 13, _uA(
                        "type",
                        "disabled",
                        "onClick"
                    )),
                    _cE(Fragment, null, RenderHelpers.renderList(unref(errorDetails), fun(item, index, __index, _cached): Any {
                        return _cE("view", null, _tD(item), 1)
                    }
                    ), 256)
                ), 64)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
