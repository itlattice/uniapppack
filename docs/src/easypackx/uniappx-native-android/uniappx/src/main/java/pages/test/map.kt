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
import uts.sdk.modules.iboxsAmap.IboxsAmapComponent
import uts.sdk.modules.iboxsAmap.singleLocation
import uts.sdk.modules.iboxsAmap.LocationError
import uts.sdk.modules.iboxsAmap.LatLng
import uts.sdk.modules.iboxsAmap.openLocation
import uts.sdk.modules.iboxsAmap.chooseLocation
open class GenPagesTestMap : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            xProvitae.scrollTop = e.scrollTop
            val pages = getCurrentPages()
            if (pages.length == 0) {
                return
            }
            val page = pages[pages.length - 1].route
            uni__emit("onPageScroll", _uO("top" to e.scrollTop, "page" to page))
        }
        , __ins)
        onResize(fun(_: OnResizeOptions) {
            uni__emit("onResize", fun() {})
        }
        , __ins)
        onLoad(fun(query: OnLoadOptions) {
            xProvitae.onLoadOpts = JSON.parseObject(JSON.stringify(query)!!) ?: _uO()
            uni__emit("onLoad", fun() {})
        }
        , __ins)
        onPageHide(fun() {
            uni__emit("onHide", fun() {})
        }
        , __ins)
        onReady(fun() {
            uni__emit("onReady", fun() {})
            xProvitae.pageReady = true
        }
        , __ins)
        onPageShow(fun() {
            uni__emit("onShow", fun() {})
        }
        , __ins)
    }
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesTestMap) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesTestMap
            val _cache = __ins.renderCache
            val amap = ref<UniElement?>(null)
            val chooseLocation = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        var location = await(common.`$chooseLocation`())
                        console.log(location)
                })
            }
            return fun(): Any? {
                return _cE("view", null, _uA(
                    _cE("view", _uM("style" to _nS(_uM("width" to "750rpx", "height" to "500px"))), _uA(
                        _cE(IboxsAmapComponent.name, _uM("ref_key" to "amap", "ref" to amap, "id" to "amap", "style" to _nS(_uM("height" to "500px"))), null, 4)
                    ), 4),
                    _cE("button", _uM("onClick" to chooseLocation), "选择地址")
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
