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
import uts.sdk.modules.iboxsPerformance.initPerformance
import uts.sdk.modules.iboxsPerformance.startCrashMonitoring
import uts.sdk.modules.iboxsPerformance.CrashData
import uts.sdk.modules.iboxsPerformance.startRuntimeErrorMonitoring
import uts.sdk.modules.iboxsPerformance.RuntimeErrorData
import uts.sdk.modules.iboxsPerformance.ANRData
import uts.sdk.modules.iboxsPerformance.BlockData
import uts.sdk.modules.iboxsPerformance.startBlockMonitoring
import uts.sdk.modules.iboxsPerformance.startANRMonitoring
import uts.sdk.modules.iboxsAmap.setAmapAndriodKey
open class GenPagesSplash : BasePage {
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
        var setup: (__props: GenPagesSplash) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesSplash
            val _cache = __ins.renderCache
            val loadFont = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                })
            }
            val getCityListIndex = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        var res = await(request.callapi("address/citylistindex", _uO(), AppConfig.postHost))
                        common.setStorage("citylistindex", res)
                })
            }
            val getDistrictList = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        var res = await(request.callapi("address/district", _uO(), AppConfig.postHost))
                        common.setStorage("district", res)
                })
            }
            val loadData = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        initPerformance(getApp().getAndroidApplication())
                        var per = performance()
                        per.start()
                        console.log("App Launch")
                        userObject.checkLogin()
                        setAmapAndriodKey("a0f10fe17a3ab794bb1115e6fa44dda5")
                        getCityListIndex()
                        getDistrictList()
                        var slt = sqlite()
                        loadFont()
                })
            }
            onReady(fun(){
                loadData()
                common.getMetaInfo()
            }
            )
            return fun(): Any? {
                return _cE("view", _uM("class" to "full"), _uA(
                    _cE("image", _uM("class" to "full", "src" to "/static/images/outline.9.png"))
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
                return _uM("full" to _pS(_uM("width" to "750rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
