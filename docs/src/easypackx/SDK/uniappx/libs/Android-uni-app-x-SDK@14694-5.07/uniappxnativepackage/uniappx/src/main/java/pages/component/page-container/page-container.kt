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
import io.dcloud.uniapp.extapi.navigateBack as uni_navigateBack
open class GenPagesComponentPageContainerPageContainer : BasePage {
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
    open var data: Data
        get() {
            return unref(this.`$exposed`["data"]) as Data
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var showContainer: (position: String, text: String) -> Unit
        get() {
            return unref(this.`$exposed`["showContainer"]) as (position: String, text: String) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "showContainer", value)
        }
    open var navigateBack: () -> Unit
        get() {
            return unref(this.`$exposed`["navigateBack"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "navigateBack", value)
        }
    open var closeContainer: () -> Unit
        get() {
            return unref(this.`$exposed`["closeContainer"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "closeContainer", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentPageContainerPageContainer, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentPageContainerPageContainer
            val _cache = __ins.renderCache
            val containerShow = ref<Boolean>(false)
            val containerRound = ref<Boolean>(false)
            val containerPosition = ref<String>("bottom")
            val containerOverlay = ref<Boolean>(true)
            val containerTitle = ref<String>("Page-Container")
            val containerOverlayStyle = ref<String>("")
            val containerContent = ref<String>("这是一个 page-container 容器")
            val containerCloseOnSlideDown = ref<Boolean>(false)
            val enableScrollThrough = ref<Boolean>(false)
            val showStackedPop1 = ref<Boolean>(false)
            val showStackedPop2 = ref<Boolean>(false)
            val showStackedPop3 = ref<Boolean>(false)
            val data = reactive<Data>(Data(onAfterLeaveCallCount = 0))
            fun gen_resetConfig_fn() {
                containerRound.value = false
                containerPosition.value = "bottom"
                containerOverlay.value = true
                containerCloseOnSlideDown.value = false
                containerOverlayStyle.value = ""
                enableScrollThrough.value = false
            }
            val resetConfig = ::gen_resetConfig_fn
            fun gen_showContainer_fn(position: String, text: String) {
                resetConfig()
                containerPosition.value = position
                containerShow.value = true
                containerTitle.value = "Position: " + position
                containerContent.value = "容器从 " + text + " 弹出"
            }
            val showContainer = ::gen_showContainer_fn
            fun gen_showRound_fn() {
                resetConfig()
                containerRound.value = true
                containerShow.value = true
                containerTitle.value = "Round: true"
                containerContent.value = "弹窗圆角: true"
            }
            val showRound = ::gen_showRound_fn
            fun gen_showOverlay_fn(overlay: Boolean) {
                resetConfig()
                containerOverlay.value = overlay
                containerShow.value = true
                containerTitle.value = "Overlay: " + overlay
                containerContent.value = "遮罩层: " + overlay
            }
            val showOverlay = ::gen_showOverlay_fn
            fun gen_showTransparentOverlay_fn() {
                resetConfig()
                containerOverlay.value = true
                containerOverlayStyle.value = "background-color: rgba(0, 0, 0, 0);"
                containerTitle.value = "透明蒙层"
                containerContent.value = "蒙层开启但完全透明，可以点击蒙层区域关闭"
                containerShow.value = true
            }
            val showTransparentOverlay = ::gen_showTransparentOverlay_fn
            fun gen_showGreenTransparentOverlay_fn() {
                resetConfig()
                containerOverlay.value = true
                containerPosition.value = "center"
                containerOverlayStyle.value = "background-color: rgba(76, 175, 80, 0.3);"
                containerTitle.value = "绿色半透明蒙层"
                containerContent.value = "蒙层开启但为绿色半透明，可以点击蒙层区域关闭"
                containerShow.value = true
            }
            val showGreenTransparentOverlay = ::gen_showGreenTransparentOverlay_fn
            fun gen_showSlideDown_fn() {
                resetConfig()
                containerCloseOnSlideDown.value = true
                containerShow.value = true
                containerPosition.value = "bottom"
                containerTitle.value = "Close-on-slide-down: true"
                containerContent.value = "下滑关闭: true"
            }
            val showSlideDown = ::gen_showSlideDown_fn
            fun gen_autoClose_fn() {
                resetConfig()
                containerShow.value = true
                containerPosition.value = "bottom"
                containerTitle.value = "Page-container"
                containerContent.value = "容器会在 2s 后自动关闭"
                setTimeout(fun(){
                    containerShow.value = false
                }
                , 2000)
            }
            val autoClose = ::gen_autoClose_fn
            fun gen_showScrollThrough_fn() {
                resetConfig()
                enableScrollThrough.value = true
                containerShow.value = true
                containerPosition.value = "bottom"
                containerTitle.value = "Page-container"
                containerContent.value = "这是一个可滚动的内容区域。\n\n请向上或向下滚动此区域。\n\n当滚动到顶部或底部边界时\n\n测试主页面是否会跟随滚动(滚动穿透问题)\n\n理想情况下,当弹层内的scroll-view滚动到边界时,不应该触发主页面的滚动。\n\n已到达底部,现在可以测试向上滚动到顶部的情况。"
            }
            val showScrollThrough = ::gen_showScrollThrough_fn
            fun gen_onAfterLeave_fn() {
                containerShow.value = false
                data.onAfterLeaveCallCount += 1
            }
            val onAfterLeave = ::gen_onAfterLeave_fn
            fun gen_closeContainer_fn() {
                containerShow.value = false
            }
            val closeContainer = ::gen_closeContainer_fn
            fun gen_navigateBack_fn() {
                uni_navigateBack(null)
            }
            val navigateBack = ::gen_navigateBack_fn
            fun gen_showStackedLayer1_fn() {
                showStackedPop1.value = true
            }
            val showStackedLayer1 = ::gen_showStackedLayer1_fn
            fun gen_showStackedLayer2_fn() {
                showStackedPop2.value = true
            }
            val showStackedLayer2 = ::gen_showStackedLayer2_fn
            fun gen_showStackedLayer3_fn() {
                showStackedPop3.value = true
            }
            val showStackedLayer3 = ::gen_showStackedLayer3_fn
            fun gen_closeStackedLayer1_fn() {
                showStackedPop1.value = false
            }
            val closeStackedLayer1 = ::gen_closeStackedLayer1_fn
            fun gen_closeStackedLayer2_fn() {
                showStackedPop2.value = false
            }
            val closeStackedLayer2 = ::gen_closeStackedLayer2_fn
            fun gen_closeStackedLayer3_fn() {
                showStackedPop3.value = false
            }
            val closeStackedLayer3 = ::gen_closeStackedLayer3_fn
            __expose(_uM("data" to data, "showContainer" to showContainer, "navigateBack" to navigateBack, "closeContainer" to closeContainer))
            return fun(): Any? {
                val _component_page_intro = resolveEasyComponent("page-intro", GenComponentsPageIntroPageIntroClass)
                val _component_page_container = resolveComponent("page-container")
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cV(_component_page_intro, _uM("content" to "本页演示 page-container 页面容器，用于在页面内创建弹出层效果，支持拦截返回操作：顶部/底部/左侧/右侧/居中弹出、圆角、遮罩与透明蒙层、下滑关闭等能力，通过按钮触发不同展示。")),
                    _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt"), _uA(
                        _cE("view", _uM("class" to "uni-title uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), " 弹出位置 ")
                        )),
                        _cE("view", null, _uA(
                            _cE("button", _uM("onClick" to fun(){
                                showContainer("top", "顶部")
                            }
                            ), "顶部弹出", 8, _uA(
                                "onClick"
                            )),
                            _cE("button", _uM("class" to "mt-5", "onClick" to fun(){
                                showContainer("bottom", "底部")
                            }
                            ), "底部弹出", 8, _uA(
                                "onClick"
                            )),
                            _cE("button", _uM("id" to "right-button", "class" to "mt-5", "onClick" to fun(){
                                showContainer("right", "右侧")
                            }
                            ), "右侧弹出", 8, _uA(
                                "onClick"
                            )),
                            _cE("button", _uM("class" to "mt-5", "onClick" to fun(){
                                showContainer("left", "左侧")
                            }
                            ), "左侧弹出", 8, _uA(
                                "onClick"
                            )),
                            _cE("button", _uM("class" to "mt-5", "onClick" to fun(){
                                showContainer("center", "居中")
                            }
                            ), "居中弹出", 8, _uA(
                                "onClick"
                            ))
                        ))
                    )),
                    _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt"), _uA(
                        _cE("view", _uM("class" to "uni-title uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), " 弹窗圆角 ")
                        )),
                        _cE("view", null, _uA(
                            _cE("button", _uM("onClick" to showRound), "圆角")
                        ))
                    )),
                    _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt"), _uA(
                        _cE("view", _uM("class" to "uni-title uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), " 遮罩层 ")
                        )),
                        _cE("view", null, _uA(
                            _cE("button", _uM("onClick" to fun(){
                                showOverlay(false)
                            }
                            ), "不显示蒙层", 8, _uA(
                                "onClick"
                            )),
                            _cE("button", _uM("class" to "mt-5", "onClick" to fun(){
                                showOverlay(true)
                            }
                            ), "显示蒙层", 8, _uA(
                                "onClick"
                            )),
                            _cE("button", _uM("class" to "mt-5", "onClick" to showTransparentOverlay), "透明蒙层"),
                            _cE("button", _uM("class" to "mt-5", "onClick" to showGreenTransparentOverlay), "绿色半透明蒙层")
                        ))
                    )),
                    _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt"), _uA(
                        _cE("view", _uM("class" to "uni-title uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), " 自动隐藏 ")
                        )),
                        _cE("view", null, _uA(
                            _cE("button", _uM("onClick" to autoClose), "2秒后自动关闭")
                        ))
                    )),
                    _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt"), _uA(
                        _cE("view", _uM("class" to "uni-title uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), " 滚动穿透 ")
                        )),
                        _cE("view", null, _uA(
                            _cE("button", _uM("onClick" to showScrollThrough), "打开滚动穿透测试弹层"),
                            _cE("text", _uM("class" to "slider-down-info"), "测试弹层内滚动到顶部或底部时是否会影响主页面滚动")
                        ))
                    )),
                    _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt"), _uA(
                        _cE("view", _uM("class" to "uni-title uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), " 下滑关闭 ")
                        )),
                        _cE("view", null, _uA(
                            _cE("button", _uM("onClick" to showSlideDown), "支持下滑关闭"),
                            _cE("text", _uM("class" to "slider-down-info"), "提示: 当 close-on-slide-down=true 时，可下滑关闭容器")
                        ))
                    )),
                    _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt", "style" to _nS(_uM("margin-bottom" to "30px"))), _uA(
                        _cE("view", _uM("class" to "uni-title uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), " 多层堆叠测试 ")
                        )),
                        _cE("view", null, _uA(
                            _cE("button", _uM("onClick" to showStackedLayer1), "打开第1层弹层")
                        ))
                    ), 4),
                    _cV(_component_page_container, _uM("show" to unref(containerShow), "position" to unref(containerPosition), "round" to unref(containerRound), "overlay" to unref(containerOverlay), "overlay-style" to unref(containerOverlayStyle), "close-on-slide-down" to unref(containerCloseOnSlideDown), "onAfterleave" to onAfterLeave), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to "container"), _uA(
                                _cE("text", _uM("class" to "container-title"), _tD(unref(containerTitle)), 1),
                                if (isTrue(unref(enableScrollThrough))) {
                                    _cE("scroll-view", _uM("key" to 0, "style" to _nS(_uM("height" to "200px", "margin-bottom" to "15px", "padding" to "10px"))), _uA(
                                        _cE("text", _uM("class" to "container-content"), _tD(unref(containerContent)), 1)
                                    ), 4)
                                } else {
                                    _cE("text", _uM("key" to 1, "class" to "container-content"), _tD(unref(containerContent)), 1)
                                }
                                ,
                                _cE("button", _uM("onClick" to closeContainer, "type" to "primary"), "关闭容器"),
                                _cE("button", _uM("class" to "mt-5", "onClick" to navigateBack), "后退页面")
                            ))
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "show",
                        "position",
                        "round",
                        "overlay",
                        "overlay-style",
                        "close-on-slide-down"
                    )),
                    _cV(_component_page_container, _uM("show" to unref(showStackedPop1), "position" to "center", "onAfterleave" to closeStackedLayer1), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to "stacked-container", "style" to _nS(_uM("background-color" to "#fff", "width" to "360px"))), _uA(
                                _cE("text", _uM("class" to "container-title"), "第1层弹层"),
                                _cE("text", _uM("class" to "container-content"), "这是第1层弹层,点击下方按钮可以打开第2层"),
                                _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row", "justify-content" to "space-around"))), _uA(
                                    _cE("button", _uM("onClick" to showStackedLayer2, "size" to "default", "type" to "primary"), "打开第2层"),
                                    _cE("button", _uM("onClick" to closeStackedLayer1, "size" to "default"), "关闭本层")
                                ), 4)
                            ), 4)
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "show"
                    )),
                    _cV(_component_page_container, _uM("show" to unref(showStackedPop2), "position" to "center", "onAfterleave" to closeStackedLayer2), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to "stacked-container", "style" to _nS(_uM("background-color" to "#f0f0f0", "width" to "340px"))), _uA(
                                _cE("text", _uM("class" to "container-title"), "第2层弹层"),
                                _cE("text", _uM("class" to "container-content"), "这是第2层弹层,点击下方按钮可以打开第3层"),
                                _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row", "justify-content" to "space-around"))), _uA(
                                    _cE("button", _uM("onClick" to showStackedLayer3, "size" to "default", "type" to "primary"), "打开第3层"),
                                    _cE("button", _uM("onClick" to closeStackedLayer2, "size" to "default"), "关闭本层")
                                ), 4)
                            ), 4)
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "show"
                    )),
                    _cV(_component_page_container, _uM("show" to unref(showStackedPop3), "position" to "center", "onAfterleave" to closeStackedLayer3), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to "stacked-container", "style" to _nS(_uM("background-color" to "#e0e0e0", "width" to "300px"))), _uA(
                                _cE("text", _uM("class" to "container-title"), "第3层弹层"),
                                _cE("text", _uM("class" to "container-content"), "这是第3层弹层,最顶层的弹层"),
                                _cE("button", _uM("onClick" to closeStackedLayer3, "size" to "default"), "关闭本层")
                            ), 4)
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "show"
                    ))
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
                return _uM("container" to _pS(_uM("paddingTop" to 20, "paddingRight" to 20, "paddingBottom" to 20, "paddingLeft" to 20, "backgroundColor" to "#ffffff", "minHeight" to 300, "minWidth" to 300)), "container-title" to _pS(_uM("fontSize" to 18, "fontWeight" to "bold", "color" to "#333333", "marginBottom" to 10)), "container-content" to _pS(_uM("fontSize" to 14, "color" to "#666666", "marginBottom" to 15)), "mt-5" to _pS(_uM("marginTop" to 5)), "slider-down-info" to _pS(_uM("fontSize" to 12, "color" to "#999999", "marginTop" to 5, "marginBottom" to 20)), "stacked-container" to _pS(_uM("paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "borderTopLeftRadius" to 8, "borderTopRightRadius" to 8, "borderBottomRightRadius" to 8, "borderBottomLeftRadius" to 8, "minHeight" to 150)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
