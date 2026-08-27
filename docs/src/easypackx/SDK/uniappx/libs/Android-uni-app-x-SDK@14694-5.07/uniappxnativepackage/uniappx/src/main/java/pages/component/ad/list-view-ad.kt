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
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesComponentAdListViewAd : BasePage {
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
        var setup: (__props: GenPagesComponentAdListViewAd) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentAdListViewAd
            val _cache = __ins.renderCache
            val listcount = ref(10)
            fun gen_onScrollTolower_fn(event: ScrollToLowerEvent) {
                setTimeout(fun(){
                    listcount.value = listcount.value + 10
                }
                , 300)
            }
            val onScrollTolower = ::gen_onScrollTolower_fn
            fun gen_onAdLoad_fn() {
                console.log("广告加载成功")
                uni_showToast(ShowToastOptions(position = "center", title = "广告加载成功"))
            }
            val onAdLoad = ::gen_onAdLoad_fn
            fun gen_onAdError_fn(e: UniAdErrorEvent) {
                console.log("广告加载失败" + e.detail)
            }
            val onAdError = ::gen_onAdError_fn
            fun gen_onAdClose_fn() {
                console.log("广告关闭了")
            }
            val onAdClose = ::gen_onAdClose_fn
            return fun(): Any? {
                return _cE("list-view", _uM("onScrolltolower" to onScrollTolower, "style" to _nS(_uM("flex" to "1")), "show-scrollbar" to "false"), _uA(
                    _cE(Fragment, null, RenderHelpers.renderList(unref(listcount), fun(index, __key, __index, _cached): Any {
                        return _cE("list-item", _uM("key" to index, "type" to if ((index != 0 && index % 10 == 6)) {
                            0
                        } else {
                            1
                        }
                        ), _uA(
                            if (isTrue(index != 0 && index % 10 == 6)) {
                                _cE("ad", _uM("key" to 0, "adpid" to "1111111111", "onLoad" to onAdLoad, "onError" to onAdError, "onClose" to onAdClose), null, 32)
                            } else {
                                _cC("v-if", true)
                            }
                            ,
                            if (isTrue(index == 0 || index % 10 != 6)) {
                                _cE("text", _uM("key" to 1, "style" to _nS(_uM("width" to "100%", "height" to "200px", "background-color" to "aquamarine", "margin-top" to "10px"))), "这是一条占位的信息" + _tD(index), 5)
                            } else {
                                _cC("v-if", true)
                            }
                        ), 8, _uA(
                            "type"
                        ))
                    }
                    ), 128)
                ), 36)
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
