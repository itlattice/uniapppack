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
import io.dcloud.uniapp.extapi.createVideoContext as uni_createVideoContext
open class GenPagesComponentAdVideoAd : BasePage {
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
        var setup: (__props: GenPagesComponentAdVideoAd) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentAdVideoAd
            val _cache = __ins.renderCache
            val src = ref("https://qiniu-web-assets.dcloud.net.cn/video/sample/2minute-demo.mp4")
            var showAd: Boolean = false
            val adVisible = ref(false)
            fun gen_onVideoPlay_fn() {
                if (!showAd) {
                    showAd = true
                    adVisible.value = true
                    val videoContext = uni_createVideoContext("myVideo", null)
                    videoContext!!.stop()
                }
            }
            val onVideoPlay = ::gen_onVideoPlay_fn
            fun gen_closeAd_fn() {
                console.log("执行了关闭")
                adVisible.value = false
                val videoContext = uni_createVideoContext("myVideo", null)
                videoContext!!.play()
            }
            val closeAd = ::gen_closeAd_fn
            fun gen_loadFun_fn() {
                console.log("加载成功")
            }
            val loadFun = ::gen_loadFun_fn
            fun gen_errorFun_fn(e: UniAdErrorEvent) {
                console.log(e.detail)
            }
            val errorFun = ::gen_errorFun_fn
            onLoad(fun(_options){})
            return fun(): Any? {
                return _cE("view", _uM("class" to "container"), _uA(
                    _cE("video", _uM("id" to "myVideo", "src" to unref(src), "controls" to true, "autoplay" to "false", "class" to "video", "onPlay" to onVideoPlay), null, 40, _uA(
                        "src"
                    )),
                    if (isTrue(unref(adVisible))) {
                        _cE("view", _uM("key" to 0, "class" to "ad-container"), _uA(
                            _cE("ad", _uM("adpid" to "1597617406", "style" to _nS(_uM("width" to "100%", "height" to "420rpx")), "onLoad" to loadFun, "onError" to errorFun, "onClose" to closeAd), null, 36)
                        ))
                    } else {
                        _cC("v-if", true)
                    }
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
                return _uM("container" to _pS(_uM("position" to "relative", "width" to "100%", "height" to "100%", "display" to "flex", "flexDirection" to "column", "alignItems" to "center")), "video" to _pS(_uM("width" to "100%", "height" to "420rpx")), "ad-container" to _pS(_uM("position" to "absolute", "top" to 0, "left" to 0, "width" to "100%", "height" to "420rpx", "backgroundColor" to "rgba(0,0,0,0.7)", "display" to "flex", "alignItems" to "center", "justifyContent" to "center", "zIndex" to 999)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
