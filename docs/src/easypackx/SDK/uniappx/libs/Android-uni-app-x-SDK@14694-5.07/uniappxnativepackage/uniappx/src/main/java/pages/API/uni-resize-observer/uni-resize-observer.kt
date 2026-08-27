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
open class GenPagesAPIUniResizeObserverUniResizeObserver : BasePage {
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
    open var data: DataType__103
        get() {
            return unref(this.`$exposed`["data"]) as DataType__103
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var setOutBoxMarginLeft: (value: String) -> Unit
        get() {
            return unref(this.`$exposed`["setOutBoxMarginLeft"]) as (value: String) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setOutBoxMarginLeft", value)
        }
    open var changeTextSize: () -> Unit
        get() {
            return unref(this.`$exposed`["changeTextSize"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "changeTextSize", value)
        }
    open var changeImageSize: () -> Unit
        get() {
            return unref(this.`$exposed`["changeImageSize"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "changeImageSize", value)
        }
    open var changeScrollViewSize: () -> Unit
        get() {
            return unref(this.`$exposed`["changeScrollViewSize"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "changeScrollViewSize", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIUniResizeObserverUniResizeObserver, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIUniResizeObserverUniResizeObserver
            val _cache = __ins.renderCache
            val outBoxSizeInfo = ref("")
            val innerBoxSizeInfo = ref("")
            val offset = ref(2)
            val boxDisplay = ref(false)
            var outBoxElement: UniElement? = null
            var innerBoxElement: UniElement? = null
            var resizeObserver: UniResizeObserver? = null
            val textFontSize = ref(16)
            var textElement: UniElement? = null
            val imageWidth = ref(100)
            val imageHeight = ref(100)
            var imageElement: UniElement? = null
            val scrollViewWidth = ref(300)
            var scrollViewElement: UniElement? = null
            val textImageScrollViewDisplay = ref(false)
            val data = reactive(DataType__103(outBoxElementOnResize = false, textSizeInfo = "", imageSizeInfo = "", scrollViewSizeInfo = "", textSizeInfoObj = null, imageSizeInfoObj = null, scrollViewSizeInfoObj = null))
            fun gen_innerBoxClick_fn() {
                if (innerBoxElement != null) {
                    innerBoxElement!!.style.setProperty("width", innerBoxElement!!.offsetWidth + offset.value + "px")
                    innerBoxElement!!.style.setProperty("height", innerBoxElement!!.offsetWidth + offset.value + "px")
                }
            }
            val innerBoxClick = ::gen_innerBoxClick_fn
            fun gen_outBoxClick_fn() {
                if (outBoxElement != null) {
                    outBoxElement!!.style.setProperty("width", outBoxElement!!.offsetWidth + offset.value + "px")
                    outBoxElement!!.style.setProperty("height", outBoxElement!!.offsetWidth + offset.value + "px")
                }
            }
            val outBoxClick = ::gen_outBoxClick_fn
            fun gen_revertBoxSize_fn() {
                if (outBoxElement != null) {
                    outBoxElement!!.style.setProperty("width", "140px")
                    outBoxElement!!.style.setProperty("height", "140px")
                }
                if (innerBoxElement != null) {
                    innerBoxElement!!.style.setProperty("width", "80px")
                    innerBoxElement!!.style.setProperty("height", "80px")
                }
            }
            val revertBoxSize = ::gen_revertBoxSize_fn
            fun gen_setOutBoxMarginLeft_fn(value: String) {
                if (outBoxElement != null) {
                    data.outBoxElementOnResize = false
                    outBoxElement!!.style.setProperty("margin-left", value)
                }
            }
            val setOutBoxMarginLeft = ::gen_setOutBoxMarginLeft_fn
            fun gen_toggleDisplay_fn() {
                boxDisplay.value = !boxDisplay.value
            }
            val toggleDisplay = ::gen_toggleDisplay_fn
            fun gen_analysisResizeObserverEntry_fn(entry: UniResizeObserverEntry): String {
                val contentBoxSize = entry.contentBoxSize[0]
                val borderBoxSize = entry.borderBoxSize[0]
                val devicePixelContentBoxSize = entry.devicePixelContentBoxSize[0]
                return "borderBoxSize: \n{blockSize:" + borderBoxSize.blockSize + ", inlineSize:" + borderBoxSize.inlineSize + "}\n" + "contentBoxSize: \n{blockSize:" + contentBoxSize.blockSize + ", inlineSize:" + contentBoxSize.inlineSize + "}\n" + "devicePixelContentBoxSize: \n{blockSize:" + devicePixelContentBoxSize.blockSize + ", inlineSize:" + devicePixelContentBoxSize.inlineSize + "}\n" + "contentRect: \n{x:" + entry.contentRect.x + ", y:" + entry.contentRect.y + ", width:" + entry.contentRect.width + ", height:" + entry.contentRect.height + "}"
            }
            val analysisResizeObserverEntry = ::gen_analysisResizeObserverEntry_fn
            fun gen_convertResizeEntryToInfo_fn(entry: UniResizeObserverEntry): ResizeInfoType {
                val contentBoxSize = entry.contentBoxSize[0]
                val borderBoxSize = entry.borderBoxSize[0]
                val devicePixelContentBoxSize = entry.devicePixelContentBoxSize[0]
                return ResizeInfoType(contentRect = ContentRectType(x = entry.contentRect.x, y = entry.contentRect.y, width = entry.contentRect.width, height = entry.contentRect.height), borderBoxSize = BoxSizeType(blockSize = borderBoxSize.blockSize, inlineSize = borderBoxSize.inlineSize), contentBoxSize = BoxSizeType(blockSize = contentBoxSize.blockSize, inlineSize = contentBoxSize.inlineSize), devicePixelContentBoxSize = BoxSizeType(blockSize = devicePixelContentBoxSize.blockSize, inlineSize = devicePixelContentBoxSize.inlineSize))
            }
            val convertResizeEntryToInfo = ::gen_convertResizeEntryToInfo_fn
            fun gen_cancelListen_fn() {
                resizeObserver!!.unobserve(outBoxElement!!)
                resizeObserver!!.unobserve(innerBoxElement!!)
            }
            val cancelListen = ::gen_cancelListen_fn
            fun gen_goOnListen_fn() {
                resizeObserver!!.observe(outBoxElement!!)
                resizeObserver!!.observe(innerBoxElement!!)
            }
            val goOnListen = ::gen_goOnListen_fn
            fun gen_changeTextSize_fn() {
                textFontSize.value = textFontSize.value + 2
            }
            val changeTextSize = ::gen_changeTextSize_fn
            fun gen_changeImageSize_fn() {
                imageWidth.value = imageWidth.value + 10
                imageHeight.value = imageHeight.value + 10
            }
            val changeImageSize = ::gen_changeImageSize_fn
            fun gen_changeScrollViewSize_fn() {
                scrollViewWidth.value = scrollViewWidth.value + 20
            }
            val changeScrollViewSize = ::gen_changeScrollViewSize_fn
            onBackPress(fun(_options): Boolean {
                if (resizeObserver != null) {
                    resizeObserver!!.disconnect()
                }
                return false
            }
            )
            onReady(fun(){
                if (resizeObserver == null) {
                    resizeObserver = UniResizeObserver(fun(entries: UTSArray<UniResizeObserverEntry>){
                        entries.forEach(fun(entry){
                            if (entry.target == outBoxElement) {
                                outBoxSizeInfo.value = analysisResizeObserverEntry(entry)
                                data.outBoxElementOnResize = true
                            } else if (entry.target == innerBoxElement) {
                                innerBoxSizeInfo.value = analysisResizeObserverEntry(entry)
                            } else if (entry.target == textElement) {
                                data.textSizeInfo = analysisResizeObserverEntry(entry)
                                data.textSizeInfoObj = convertResizeEntryToInfo(entry)
                            } else if (entry.target == imageElement) {
                                data.imageSizeInfo = analysisResizeObserverEntry(entry)
                                data.imageSizeInfoObj = convertResizeEntryToInfo(entry)
                            } else if (entry.target == scrollViewElement) {
                                data.scrollViewSizeInfo = analysisResizeObserverEntry(entry)
                                data.scrollViewSizeInfoObj = convertResizeEntryToInfo(entry)
                            }
                        }
                        )
                    }
                    )
                    outBoxElement = uni_getElementById("outBox")
                    if (outBoxElement != null) {
                        resizeObserver!!.observe(outBoxElement!!)
                    }
                    innerBoxElement = uni_getElementById("innerBox")
                    if (innerBoxElement != null) {
                        resizeObserver!!.observe(innerBoxElement!!)
                    }
                    textElement = uni_getElementById("testText")
                    if (textElement != null) {
                        resizeObserver!!.observe(textElement!!)
                    }
                    imageElement = uni_getElementById("testImage")
                    if (imageElement != null) {
                        resizeObserver!!.observe(imageElement!!)
                    }
                    scrollViewElement = uni_getElementById("testScrollView")
                    if (scrollViewElement != null) {
                        resizeObserver!!.observe(scrollViewElement!!)
                    }
                    boxDisplay.value = true
                    textImageScrollViewDisplay.value = true
                }
            }
            )
            __expose(_uM("data" to data, "setOutBoxMarginLeft" to setOutBoxMarginLeft, "changeTextSize" to changeTextSize, "changeImageSize" to changeImageSize, "changeScrollViewSize" to changeScrollViewSize))
            return fun(): Any? {
                val _component_page_intro = resolveEasyComponent("page-intro", GenComponentsPageIntroPageIntroClass)
                return _cE("scroll-view", _uM("class" to "page-scroll-view", "style" to _nS(_uM("padding-bottom" to "var(--uni-safe-area-inset-bottom)"))), _uA(
                    _cE("view", null, _uA(
                        _cV(_component_page_intro, _uM("content" to "本页演示 uni.createResizeObserver：监听元素尺寸变化，回调中可获取 contentRect（x、y、width、height）。含 view 嵌套、text、image、scroll-view 等组件的监听示例；可点击方块改宽高、改变字体/图片/scroll-view 尺寸，支持停止/恢复监听、隐藏/显示元素。")),
                        _cE("text", null, "点击蓝色或红色方块区域会修改元素宽高"),
                        withDirectives(_cE("view", _uM("style" to _nS(_uM("align-items" to "center", "justify-content" to "center", "margin" to "10px"))), _uA(
                            _cE("view", _uM("style" to _nS(_uM("width" to "140px", "height" to "140px", "background-color" to "blue", "align-items" to "center", "justify-content" to "center", "padding" to "5px")), "id" to "outBox", "onClick" to outBoxClick), _uA(
                                _cE("view", _uM("style" to _nS(_uM("width" to "80px", "height" to "80px", "background-color" to "red", "padding" to "5px")), "id" to "innerBox", "onClick" to innerBoxClick), null, 4)
                            ), 4)
                        ), 4), _uA(
                            _uA(
                                vShow,
                                unref(boxDisplay)
                            )
                        )),
                        _cE("button", _uM("onClick" to revertBoxSize), "还原修改前元素宽高"),
                        _cE("button", _uM("onClick" to toggleDisplay), _tD(if (unref(boxDisplay)) {
                            "隐藏元素"
                        } else {
                            "显示元素"
                        }
                        ), 1),
                        _cE("button", _uM("onClick" to cancelListen), "停止监听"),
                        _cE("button", _uM("onClick" to goOnListen), "恢复监听"),
                        _cE("view", null, _uA(
                            _cE("text", _uM("class" to "info-text"), "蓝色方块元素:"),
                            _cE("view", _uM("class" to "info-item"), _uA(
                                _cE("text", _uM("class" to "info-text"), _tD(unref(outBoxSizeInfo)), 1)
                            )),
                            _cE("text", _uM("class" to "info-text", "style" to _nS(_uM("margin-top" to "20px"))), "红色方块元素:", 4),
                            _cE("view", _uM("class" to "info-item"), _uA(
                                _cE("text", _uM("class" to "info-text"), _tD(unref(innerBoxSizeInfo)), 1)
                            ))
                        )),
                        withDirectives(_cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "Text 组件示例:"),
                            _cE("text", _uM("id" to "testText", "style" to _nS(_uM("fontSize" to (unref(textFontSize) + "px"), "color" to "#333"))), "这是一个可以改变字体大小的文本", 4),
                            _cE("button", _uM("onClick" to changeTextSize), "改变文本字体大小"),
                            _cE("view", _uM("class" to "info-item"), _uA(
                                _cE("text", _uM("class" to "info-text"), _tD(unref(data).textSizeInfo), 1)
                            ))
                        ), 512), _uA(
                            _uA(
                                vShow,
                                unref(textImageScrollViewDisplay)
                            )
                        )),
                        withDirectives(_cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "Image 组件示例:"),
                            _cE("image", _uM("id" to "testImage", "style" to _nS(_uM("width" to (unref(imageWidth) + "px"), "height" to (unref(imageHeight) + "px"))), "src" to "/static/test-image/logo.png", "mode" to "aspectFit"), null, 4),
                            _cE("button", _uM("onClick" to changeImageSize), "改变图片尺寸"),
                            _cE("view", _uM("class" to "info-item"), _uA(
                                _cE("text", _uM("class" to "info-text"), _tD(unref(data).imageSizeInfo), 1)
                            ))
                        ), 512), _uA(
                            _uA(
                                vShow,
                                unref(textImageScrollViewDisplay)
                            )
                        )),
                        withDirectives(_cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "Scroll-view 组件示例:"),
                            _cE("scroll-view", _uM("id" to "testScrollView", "style" to _nS(_uM("width" to (unref(scrollViewWidth) + "px"), "height" to "100px", "border" to "1px solid #ccc"))), _uA(
                                _cE("view", _uM("style" to _nS(_uM("padding" to "10px"))), _uA(
                                    _cE("text", null, "这是 scroll-view 内的内容"),
                                    _cE(Fragment, null, RenderHelpers.renderList(10, fun(i, __key, __index, _cached): Any {
                                        return _cE("text", _uM("key" to i), "第 " + _tD(i) + " 行内容", 1)
                                    }
                                    ), 64)
                                ), 4)
                            ), 4),
                            _cE("button", _uM("onClick" to changeScrollViewSize), "改变 scroll-view 宽度"),
                            _cE("view", _uM("class" to "info-item"), _uA(
                                _cE("text", _uM("class" to "info-text"), _tD(unref(data).scrollViewSizeInfo), 1)
                            ))
                        ), 512), _uA(
                            _uA(
                                vShow,
                                unref(textImageScrollViewDisplay)
                            )
                        ))
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
                return _uM("info-item" to _pS(_uM("flexDirection" to "row")), "info-text" to _pS(_uM("fontSize" to 14)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
