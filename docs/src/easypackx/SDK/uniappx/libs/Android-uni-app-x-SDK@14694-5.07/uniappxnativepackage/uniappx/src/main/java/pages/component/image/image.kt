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
open class GenPagesComponentImageImage : BasePage {
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
    open var data: DataType__32
        get() {
            return unref(this.`$exposed`["data"]) as DataType__32
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var error: (event: ImageErrorEvent) -> Unit
        get() {
            return unref(this.`$exposed`["error"]) as (event: ImageErrorEvent) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "error", value)
        }
    open var load: (event: ImageLoadEvent) -> Unit
        get() {
            return unref(this.`$exposed`["load"]) as (event: ImageLoadEvent) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "load", value)
        }
    open var imageFormat: () -> Unit
        get() {
            return unref(this.`$exposed`["imageFormat"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "imageFormat", value)
        }
    open var imageMode: () -> Unit
        get() {
            return unref(this.`$exposed`["imageMode"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "imageMode", value)
        }
    open var imagePath: () -> Unit
        get() {
            return unref(this.`$exposed`["imagePath"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "imagePath", value)
        }
    open var imageLarge: () -> Unit
        get() {
            return unref(this.`$exposed`["imageLarge"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "imageLarge", value)
        }
    open var imageLong: () -> Unit
        get() {
            return unref(this.`$exposed`["imageLong"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "imageLong", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentImageImage, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentImageImage
            val _cache = __ins.renderCache
            val data = reactive(DataType__32(title = "image", imageSrc = "/static/test-image/logo.png", loadError = false, autoTest = false, setCookieImage = "", verifyCookieImage = "", eventLoad = null, eventError = null))
            val error = fun(event: ImageErrorEvent){
                data.loadError = true
                console.log(event.type, event.detail)
                if (data.autoTest) {
                    data.eventError = _uO("tagName" to event.target?.tagName, "type" to event.type)
                }
            }
            val load = fun(event: ImageLoadEvent){
                console.log(event.type, event.detail)
                if (data.autoTest) {
                    data.eventLoad = _uO("tagName" to event.target?.tagName, "type" to event.type, "width" to event.detail.width, "height" to event.detail.height)
                }
            }
            val imageFormat = fun(){
                uni_navigateTo(NavigateToOptions(url = "/pages/component/image/image-format"))
            }
            val imageMode = fun(){
                uni_navigateTo(NavigateToOptions(url = "/pages/component/image/image-mode"))
            }
            val imagePath = fun(){
                uni_navigateTo(NavigateToOptions(url = "/pages/component/image/image-path"))
            }
            val imageLarge = fun(){
                uni_navigateTo(NavigateToOptions(url = "/pages/component/image/image-large"))
            }
            val imageLong = fun(){
                uni_navigateTo(NavigateToOptions(url = "/pages/component/image/image-long"))
            }
            val imageOrientation = fun(){
                uni_navigateTo(NavigateToOptions(url = "/pages/component/image/image-orientation"))
            }
            __expose(_uM("data" to data, "error" to error, "load" to load, "imageFormat" to imageFormat, "imageMode" to imageMode, "imagePath" to imagePath, "imageLarge" to imageLarge, "imageLong" to imageLong))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE("view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cV(_component_page_head, _uM("title" to unref(data).title), null, 8, _uA(
                        "title"
                    )),
                    _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                        _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "image样式大合集"),
                            _cE("text", _uM("class" to "uni-subtitle-text uni-common-mb"), "右边为拍平"),
                            _cE("view", _uM("class" to "styled-image-row"), _uA(
                                _cE("image", _uM("class" to "styled-image", "mode" to "aspectFill", "src" to unref(data).imageSrc), null, 8, _uA(
                                    "src"
                                )),
                                _cE("image", _uM("class" to "styled-image", "mode" to "aspectFill", "src" to unref(data).imageSrc, "flatten" to ""), null, 8, _uA(
                                    "src"
                                ))
                            )),
                            _cE("text", _uM("class" to "uni-title-text"), "自定义组件：右边拍平"),
                            _cE("view", _uM("class" to "styled-image-row"), _uA(
                                _cV(unref(GenPagesComponentImageChildClass)),
                                _cV(unref(GenPagesComponentImageChildClass), _uM("flatten" to ""))
                            )),
                            _cE("text", _uM("class" to "uni-title-text uni-common-mt"), "基础（右边为拍平）"),
                            _cE("view", _uM("class" to "uni-center image-bg"), _uA(
                                _cE("image", _uM("class" to "image", "fade-show" to true, "mode" to "widthFix", "src" to unref(data).imageSrc, "onError" to error, "onLoad" to load), null, 40, _uA(
                                    "src"
                                )),
                                _cE("image", _uM("class" to "image", "fade-show" to true, "mode" to "widthFix", "src" to unref(data).imageSrc, "onError" to error, "onLoad" to load, "flatten" to ""), null, 40, _uA(
                                    "src"
                                ))
                            )),
                            _cE("button", _uM("class" to "uni-btn", "onClick" to imageFormat), "图片格式示例"),
                            _cE("button", _uM("class" to "uni-btn", "onClick" to imageMode), "图片缩放模式示例"),
                            _cE("button", _uM("class" to "uni-btn", "onClick" to imagePath), "图片路径示例"),
                            _cE("button", _uM("class" to "uni-btn", "onClick" to imageLarge), "大图示例"),
                            _cE("button", _uM("class" to "uni-btn", "onClick" to imageLong), "长图示例"),
                            _cE("button", _uM("class" to "uni-btn", "onClick" to imageOrientation), "图片方向修正示例")
                        ))
                    ), 4),
                    if (isTrue(unref(data).autoTest)) {
                        _cE("view", _uM("key" to 0), _uA(
                            _cE("image", _uM("src" to unref(data).setCookieImage), null, 8, _uA(
                                "src"
                            )),
                            _cE("image", _uM("src" to unref(data).verifyCookieImage, "onError" to error), null, 40, _uA(
                                "src"
                            ))
                        ))
                    } else {
                        _cC("v-if", true)
                    }
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
                return _uM("styled-image-row" to _pS(_uM("flexDirection" to "row", "backgroundImage" to "none", "backgroundColor" to "#ffffff", "justifyContent" to "space-around", "height" to 120, "alignItems" to "center")), "styled-image" to _pS(_uM("width" to 80, "height" to 80, "marginTop" to 5, "marginRight" to 5, "marginBottom" to 5, "marginLeft" to 5, "paddingTop" to 5, "paddingRight" to 5, "paddingBottom" to 5, "paddingLeft" to 5, "borderTopWidth" to 2, "borderRightWidth" to 2, "borderBottomWidth" to 2, "borderLeftWidth" to 2, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#ff6b6b", "borderRightColor" to "#ff6b6b", "borderBottomColor" to "#ff6b6b", "borderLeftColor" to "#ff6b6b", "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "borderBottomRightRadius" to 10, "borderBottomLeftRadius" to 10, "backgroundColor" to "#ffe0e0", "boxShadow" to "0 3px 6px rgba(255, 107, 107, 0.3)", "opacity" to 0.98, "transform" to "rotate(45deg)")), "image" to _pS(_uM("marginTop" to 20, "marginRight" to "auto", "marginBottom" to 20, "marginLeft" to "auto", "width" to 100)), "image-bg" to _pS(_uM("backgroundImage" to "none", "backgroundColor" to "#FFFFFF")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
