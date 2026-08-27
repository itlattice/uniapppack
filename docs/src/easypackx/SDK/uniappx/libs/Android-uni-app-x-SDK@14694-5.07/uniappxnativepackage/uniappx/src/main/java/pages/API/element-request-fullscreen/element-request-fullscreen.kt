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
import io.dcloud.uniapp.extapi.getElementById as uni_getElementById
open class GenPagesAPIElementRequestFullscreenElementRequestFullscreen : BasePage {
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
    open var data: DataType__94
        get() {
            return unref(this.`$exposed`["data"]) as DataType__94
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var fullscreen: () -> Unit
        get() {
            return unref(this.`$exposed`["fullscreen"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "fullscreen", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIElementRequestFullscreenElementRequestFullscreen, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIElementRequestFullscreenElementRequestFullscreen
            val _cache = __ins.renderCache
            val orientation_enum = ref(_uA<ItemType>(ItemType(value = 0, name = "auto"), ItemType(value = 1, name = "landscape"), ItemType(value = 2, name = "landscape-primary"), ItemType(value = 3, name = "landscape-secondary"), ItemType(value = 4, name = "portrait")))
            val navigationUI_enum = ref(_uA<ItemType>(ItemType(value = 0, name = "auto"), ItemType(value = 1, name = "hide"), ItemType(value = 2, name = "show")))
            val text = ref("点击进入全屏")
            var fullscreenElement: UniElement? = null
            var isFullscreen = false
            val orientation = ref("landscape")
            val navigationUI = ref("hide")
            val data = reactive(DataType__94(fullscreenchangeCount = 0, requestFullscreenCallbackStatus = false, exitFullscreenCallbackStatus = false))
            fun gen_getCurrentPage_fn(): UniPage {
                val pages = getCurrentPages()
                return pages[pages.length - 1]
            }
            val getCurrentPage = ::gen_getCurrentPage_fn
            fun gen_fullscreen_fn() {
                if (isFullscreen) {
                    var status1 = false
                    val page = getCurrentPage()
                    page.exitFullscreen(ExitFullscreenOptions(success = fun(){
                        text.value = "点击进入全屏"
                        status1 = true
                    }, fail = fun(err){
                        console.log("fail", err)
                        status1 = false
                    }, complete = fun(_result){
                        console.log("complete")
                        data.exitFullscreenCallbackStatus = status1
                    }))
                } else {
                    var status1 = false
                    fullscreenElement?.requestFullscreen(RequestFullscreenOptions(navigationUI = navigationUI.value, orientation = orientation.value, success = fun(){
                        text.value = "点击退出全屏"
                        status1 = true
                    }
                    , fail = fun(err){
                        console.log("fail", err)
                        status1 = false
                    }
                    , complete = fun(_result){
                        console.log("complete")
                        data.requestFullscreenCallbackStatus = status1
                    }
                    ))
                }
                isFullscreen = !isFullscreen
            }
            val fullscreen = ::gen_fullscreen_fn
            fun gen_fullscreenchange_fn(e: UniEvent) {
                console.log(e.type)
                data.fullscreenchangeCount++
                console.log(data.fullscreenchangeCount)
            }
            val fullscreenchange = ::gen_fullscreenchange_fn
            fun gen_fullscreenerror_fn(e: UniEvent) {
                console.log(e.type)
            }
            val fullscreenerror = ::gen_fullscreenerror_fn
            fun gen_radio_change_orientation_fn(checked: Number) {
                console.log(checked)
                orientation.value = orientation_enum.value[checked]["name"] as String
            }
            val radio_change_orientation = ::gen_radio_change_orientation_fn
            fun gen_radio_change_ui_fn(checked: Number) {
                console.log(checked)
                navigationUI.value = navigationUI_enum.value[checked]["name"] as String
            }
            val radio_change_ui = ::gen_radio_change_ui_fn
            onReady(fun(){
                fullscreenElement = uni_getElementById("fullscreen") as UniElement
            }
            )
            __expose(_uM("data" to data, "fullscreen" to fullscreen))
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                return _cE("scroll-view", _uM("class" to "content", "direction" to "vertical"), _uA(
                    _cE("view", _uM("id" to "fullscreen", "class" to "view1", "onClick" to fullscreen, "onFullscreenchange" to fullscreenchange, "onFullscreenerror" to fullscreenerror), _uA(
                        _cE("text", _uM("style" to _nS(_uM("color" to "white"))), _tD(unref(text)), 5)
                    ), 32),
                    _cV(_component_enum_data, _uM("items" to unref(orientation_enum), "title" to "orientation", "onChange" to radio_change_orientation), null, 8, _uA(
                        "items"
                    )),
                    _cV(_component_enum_data, _uM("items" to unref(navigationUI_enum), "title" to "navigationUI", "onChange" to radio_change_ui), null, 8, _uA(
                        "items"
                    ))
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
                return _uM("content" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "backgroundColor" to "#f0f0f0")), "view1" to _pS(_uM("width" to "100%", "height" to 150, "alignItems" to "center", "justifyContent" to "center", "backgroundColor" to "#000000")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
