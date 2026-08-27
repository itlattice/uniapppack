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
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesComponentAdAd : BasePage {
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
        var setup: (__props: GenPagesComponentAdAd) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentAdAd
            val _cache = __ins.renderCache
            val tips = ref(false)
            val pushList = fun(){
                uni_navigateTo(NavigateToOptions(url = "/pages/component/ad/list-view-ad"))
            }
            val pushVideoAd = fun(){
                uni_navigateTo(NavigateToOptions(url = "/pages/component/ad/video-ad"))
            }
            val pushVideoAdL = fun(){
                uni_navigateTo(NavigateToOptions(url = "/pages/component/ad/landscape-video-ad"))
            }
            val pushVideoAdP = fun(){
                uni_navigateTo(NavigateToOptions(url = "/pages/component/ad/portrait-video-ad"))
            }
            val loadFun = fun(){
                uni_showToast(ShowToastOptions(position = "bottom", title = "信息流广告加载成功"))
            }
            val errorFun = fun(){
                tips.value = true
            }
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE("view", null, _uA(
                    _cV(_component_page_head, _uM("title" to "信息流广告")),
                    _cE("ad", _uM("adpid" to "1111111111", "style" to _nS(_uM("width" to "100%")), "onLoad" to loadFun, "onError" to errorFun), null, 36),
                    if (isTrue(unref(tips))) {
                        _cE("view", _uM("key" to 0, "class" to "uni-center"), "信息流广告加载失败，请退出当前页面重试。")
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    _cE("button", _uM("onClick" to pushList), "列表-信息流"),
                    _cE("button", _uM("onClick" to pushVideoAd), "视频贴片-非全屏"),
                    _cE("button", _uM("onClick" to pushVideoAdL), "视频贴片-横向全屏"),
                    _cE("button", _uM("onClick" to pushVideoAdP), "视频贴片-竖向全屏")
                ))
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
