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
open class GenPagesComponentShareElementShareElement : BasePage {
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
    open var transitionOnGesture: Boolean
        get() {
            return unref(this.`$exposed`["transitionOnGesture"]) as Boolean
        }
        set(value) {
            setRefValue(this.`$exposed`, "transitionOnGesture", value)
        }
    open var shuttleOnPopType: ShuttleOnType
        get() {
            return unref(this.`$exposed`["shuttleOnPopType"]) as ShuttleOnType
        }
        set(value) {
            setRefValue(this.`$exposed`, "shuttleOnPopType", value)
        }
    open var shuttleOnPushType: ShuttleOnType
        get() {
            return unref(this.`$exposed`["shuttleOnPushType"]) as ShuttleOnType
        }
        set(value) {
            setRefValue(this.`$exposed`, "shuttleOnPushType", value)
        }
    open var shuttleOnTypeList: UTSArray<String>
        get() {
            return unref(this.`$exposed`["shuttleOnTypeList"]) as UTSArray<String>
        }
        set(value) {
            setRefValue(this.`$exposed`, "shuttleOnTypeList", value)
        }
    open var openAnimationType: ShareElementOpenAnimationType
        get() {
            return unref(this.`$exposed`["openAnimationType"]) as ShareElementOpenAnimationType
        }
        set(value) {
            setRefValue(this.`$exposed`, "openAnimationType", value)
        }
    open var openAnimationTypeList: UTSArray<String>
        get() {
            return unref(this.`$exposed`["openAnimationTypeList"]) as UTSArray<String>
        }
        set(value) {
            setRefValue(this.`$exposed`, "openAnimationTypeList", value)
        }
    open var easingFunctionType: ShareElementEasingFunctionType
        get() {
            return unref(this.`$exposed`["easingFunctionType"]) as ShareElementEasingFunctionType
        }
        set(value) {
            setRefValue(this.`$exposed`, "easingFunctionType", value)
        }
    open var easingFunctionTypeList: UTSArray<String>
        get() {
            return unref(this.`$exposed`["easingFunctionTypeList"]) as UTSArray<String>
        }
        set(value) {
            setRefValue(this.`$exposed`, "easingFunctionTypeList", value)
        }
    open var openPage: () -> Unit
        get() {
            return unref(this.`$exposed`["openPage"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "openPage", value)
        }
    open var gotoShareElementWithSwiper: () -> Unit
        get() {
            return unref(this.`$exposed`["gotoShareElementWithSwiper"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "gotoShareElementWithSwiper", value)
        }
    open var changeTransitionOnGesture: (checked: Boolean) -> Unit
        get() {
            return unref(this.`$exposed`["changeTransitionOnGesture"]) as (checked: Boolean) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "changeTransitionOnGesture", value)
        }
    open var handleOpenAnimationType: (e: RadioGroupChangeEvent) -> Unit
        get() {
            return unref(this.`$exposed`["handleOpenAnimationType"]) as (e: RadioGroupChangeEvent) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "handleOpenAnimationType", value)
        }
    open var handleEasingFunction: (e: RadioGroupChangeEvent) -> Unit
        get() {
            return unref(this.`$exposed`["handleEasingFunction"]) as (e: RadioGroupChangeEvent) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "handleEasingFunction", value)
        }
    open var handleShuttleOnPopType: (e: RadioGroupChangeEvent) -> Unit
        get() {
            return unref(this.`$exposed`["handleShuttleOnPopType"]) as (e: RadioGroupChangeEvent) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "handleShuttleOnPopType", value)
        }
    open var handleShuttleOnPushType: (e: RadioGroupChangeEvent) -> Unit
        get() {
            return unref(this.`$exposed`["handleShuttleOnPushType"]) as (e: RadioGroupChangeEvent) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "handleShuttleOnPushType", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentShareElementShareElement, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentShareElementShareElement
            val _cache = __ins.renderCache
            val transitionOnGesture = ref(true)
            val shuttleOnPopType = ref("to" as ShuttleOnType)
            val shuttleOnPushType = ref("to" as ShuttleOnType)
            val shuttleOnTypeList = _uA(
                "from",
                "to"
            )
            val openAnimationType = ref("slide-in-right" as ShareElementOpenAnimationType)
            val openAnimationTypeList = _uA(
                "auto",
                "none",
                "slide-in-right",
                "slide-in-left",
                "slide-in-top",
                "slide-in-bottom",
                "fade-in",
                "pop-in",
                "zoom-out",
                "zoom-fade-out"
            )
            val easingFunctionType = ref("ease" as ShareElementEasingFunctionType)
            val easingFunctionTypeList = _uA(
                "ease",
                "ease-in",
                "ease-out",
                "ease-in-out",
                "linear"
            )
            val openPage = fun(){
                uni_navigateTo(NavigateToOptions(animationType = openAnimationType.value, url = "/pages/component/share-element/share-element-to?shuttleOnPush=" + shuttleOnPushType.value + "&transitionOnGesture=" + transitionOnGesture.value))
            }
            val gotoShareElementWithSwiper = fun(){
                uni_navigateTo(NavigateToOptions(url = "/pages/component/share-element/share-element-with-swiper"))
            }
            val changeTransitionOnGesture = fun(checked: Boolean){
                console.log("changeTransitionOnGesture:" + checked)
                transitionOnGesture.value = checked
            }
            val handleOpenAnimationType = fun(e: RadioGroupChangeEvent){
                openAnimationType.value = e.detail.value as ShareElementOpenAnimationType
            }
            val handleEasingFunction = fun(e: RadioGroupChangeEvent){
                easingFunctionType.value = e.detail.value as ShareElementEasingFunctionType
            }
            val handleShuttleOnPopType = fun(e: RadioGroupChangeEvent){
                shuttleOnPopType.value = e.detail.value as ShuttleOnType
            }
            val handleShuttleOnPushType = fun(e: RadioGroupChangeEvent){
                shuttleOnPushType.value = e.detail.value as ShuttleOnType
            }
            __expose(_uM("transitionOnGesture" to transitionOnGesture, "shuttleOnPopType" to shuttleOnPopType, "shuttleOnPushType" to shuttleOnPushType, "shuttleOnTypeList" to shuttleOnTypeList, "openAnimationType" to openAnimationType, "openAnimationTypeList" to openAnimationTypeList, "easingFunctionType" to easingFunctionType, "easingFunctionTypeList" to easingFunctionTypeList, "openPage" to openPage, "gotoShareElementWithSwiper" to gotoShareElementWithSwiper, "changeTransitionOnGesture" to changeTransitionOnGesture, "handleOpenAnimationType" to handleOpenAnimationType, "handleEasingFunction" to handleEasingFunction, "handleShuttleOnPopType" to handleShuttleOnPopType, "handleShuttleOnPushType" to handleShuttleOnPushType))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                val _component_page_intro = resolveEasyComponent("page-intro", GenComponentsPageIntroPageIntroClass)
                val _component_boolean_data = resolveEasyComponent("boolean-data", GenComponentsBooleanDataBooleanDataClass)
                val _component_radio = resolveComponent("radio")
                val _component_radio_group = resolveComponent("radio-group")
                return _cE(Fragment, null, _uA(
                    _cV(_component_page_head, _uM("title" to "share-element")),
                    _cV(_component_page_intro, _uM("content" to "本页演示 share-element 共享元素组件：点击图片打开详情页时的转场共享效果；下方可配置过渡手势、easing、shuttle-on-push/pop 等。")),
                    _cE("view", _uM("class" to "main"), _uA(
                        _cE("share-element", _uM("class" to "share-element", "share-key" to "left", "shuttle-on-pop" to unref(shuttleOnPopType), "transition-on-gesture" to unref(transitionOnGesture), "shuttle-on-push" to unref(shuttleOnPushType), "easing-function" to unref(easingFunctionType), "onClick" to fun(){
                            openPage()
                        }
                        ), _uA(
                            _cE("image", _uM("style" to _nS(_uM("width" to "100px", "height" to "150px")), "src" to "https://web-ext-storage.dcloud.net.cn/hello-uni-app-x/drop-card-1.jpg"), null, 4)
                        ), 8, _uA(
                            "shuttle-on-pop",
                            "transition-on-gesture",
                            "shuttle-on-push",
                            "easing-function",
                            "onClick"
                        ))
                    )),
                    _cE("button", _uM("type" to "primary", "onClick" to openPage, "class" to "button"), " 打开share-element页面 "),
                    _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                        _cE("view", _uM("class" to "content"), _uA(
                            _cV(_component_boolean_data, _uM("defaultValue" to unref(transitionOnGesture), "title" to "transition-on-gesture= true(仅iOS生效)", "onChange" to changeTransitionOnGesture), null, 8, _uA(
                                "defaultValue"
                            )),
                            _cE("text", _uM("class" to "uni-common-mt choose-property-title"), "easing-function:"),
                            _cV(_component_radio_group, _uM("class" to "choose-property-type-radio-group", "onChange" to handleEasingFunction), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(easingFunctionTypeList, fun(item, __key, __index, _cached): Any {
                                        return _cV(_component_radio, _uM("class" to "ml-10 uni-common-mt", "key" to item, "value" to item, "checked" to (unref(easingFunctionType) == item)), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(item)
                                            )
                                        }
                                        ), "_" to 2), 1032, _uA(
                                            "value",
                                            "checked"
                                        ))
                                    }
                                    ), 64)
                                )
                            }
                            ), "_" to 1)),
                            _cE("text", _uM("class" to "uni-common-mt choose-property-title"), "shuttle-on-push(仅iOS生效):"),
                            _cV(_component_radio_group, _uM("class" to "choose-property-type-radio-group", "onChange" to handleShuttleOnPushType), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(shuttleOnTypeList, fun(item, __key, __index, _cached): Any {
                                        return _cV(_component_radio, _uM("class" to "ml-10 uni-common-mt", "key" to item, "value" to item, "checked" to (unref(shuttleOnPushType) == item)), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(item)
                                            )
                                        }
                                        ), "_" to 2), 1032, _uA(
                                            "value",
                                            "checked"
                                        ))
                                    }
                                    ), 64)
                                )
                            }
                            ), "_" to 1)),
                            _cE("text", _uM("class" to "uni-common-mt choose-property-title"), "shuttle-on-pop(仅iOS生效):"),
                            _cV(_component_radio_group, _uM("class" to "choose-property-type-radio-group", "onChange" to handleShuttleOnPopType), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(shuttleOnTypeList, fun(item, __key, __index, _cached): Any {
                                        return _cV(_component_radio, _uM("class" to "ml-10 uni-common-mt", "key" to item, "value" to item, "checked" to (unref(shuttleOnPopType) == item)), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(item)
                                            )
                                        }
                                        ), "_" to 2), 1032, _uA(
                                            "value",
                                            "checked"
                                        ))
                                    }
                                    ), 64)
                                )
                            }
                            ), "_" to 1)),
                            _cE("text", _uM("class" to "uni-common-mt choose-property-title"), "animationType(页面动画降级):"),
                            _cV(_component_radio_group, _uM("class" to "choose-property-type-radio-group", "onChange" to handleOpenAnimationType), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(openAnimationTypeList, fun(item, __key, __index, _cached): Any {
                                        return _cV(_component_radio, _uM("class" to "ml-10 uni-common-mt", "key" to item, "value" to item, "checked" to (unref(openAnimationType) == item)), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(item)
                                            )
                                        }
                                        ), "_" to 2), 1032, _uA(
                                            "value",
                                            "checked"
                                        ))
                                    }
                                    ), 64)
                                )
                            }
                            ), "_" to 1))
                        ))
                    ), 4),
                    _cE("button", _uM("onClick" to gotoShareElementWithSwiper, "class" to "button"), " 打开share-element-with-swiper页面 "),
                    _cE("view", _uM("style" to _nS(_uM("height" to "80px"))), null, 4),
                    _cE("share-element", _uM("class" to "bottomWrap", "share-key" to "bottom", "onClick" to fun(){
                        openPage()
                    }
                    , "transitionOnGesture" to "true"), _uA(
                        _cE("view", _uM("class" to "bottom"), _uA(
                            _cE("text", _uM("style" to _nS(_uM("color" to "white"))), "share-element(底部固定)", 4)
                        ))
                    ), 8, _uA(
                        "onClick"
                    ))
                ), 64)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("ml-10" to _pS(_uM("marginLeft" to 10)), "choose-property-title" to _pS(_uM("fontWeight" to "bold")), "choose-property-type-radio-group" to _pS(_uM("flexDirection" to "row", "flexWrap" to "wrap")), "bottomWrap" to _pS(_uM("width" to "100%", "bottom" to 0, "height" to 80, "position" to "fixed")), "bottom" to _pS(_uM("width" to "100%", "height" to "100%", "alignItems" to "center", "justifyContent" to "center", "backgroundColor" to "#007aff")), "main" to _pS(_uM("paddingTop" to 5, "paddingRight" to 0, "paddingBottom" to 5, "paddingLeft" to 0, "alignItems" to "center", "justifyContent" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
