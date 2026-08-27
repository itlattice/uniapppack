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
open class GenPagesComponentImageImageFormat : BasePage {
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
        var setup: (__props: GenPagesComponentImageImageFormat) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentImageImageFormat
            val _cache = __ins.renderCache
            val title = ref("image-format")
            val supportFormats = ref(_uA<ImageFormat>(ImageFormat(format = "bmp", src = "/static/test-image/logo.bmp"), ImageFormat(format = "gif", src = "/static/test-image/logo.gif"), ImageFormat(format = "gif 动画", src = "/static/test-image/animated.gif"), ImageFormat(format = "ico", src = "/static/test-image/logo.ico"), ImageFormat(format = "jpg", src = "/static/test-image/logo.jpg"), ImageFormat(format = "png", src = "/static/test-image/logo.png"), ImageFormat(format = "webp", src = "/static/test-image/logo.webp"), ImageFormat(format = "webp 动画", src = "/static/test-image/animated.webp"), ImageFormat(format = "heic（Android10+）", src = "/static/test-image/logo.heic"), ImageFormat(format = "avif（iOS16+）", src = "/static/test-image/logo.avif"), ImageFormat(format = "tif（Android不支持）", src = "/static/test-image/logo.tif"), ImageFormat(format = "svg本地路径（iOS13+）", src = "/static/test-image/logo.svg"), ImageFormat(format = "svg网络路径（iOS13+）", src = "https://dev.w3.org/SVG/tools/svgweb/samples/svg-files/w3c.svg")))
            fun gen_imageErrorEvent_fn(index: Number, e: ImageErrorEvent) {
                console.log("图片加载错误", e.detail)
                supportFormats.value[index].errorImage = "/static/dislike.png"
            }
            val imageErrorEvent = ::gen_imageErrorEvent_fn
            fun gen_imageErrorEventFlatten_fn(index: Number, e: ImageErrorEvent) {
                console.log("拍平图片加载错误", e.detail)
                supportFormats.value[index].errorImageFlatten = "/static/dislike.png"
            }
            val imageErrorEventFlatten = ::gen_imageErrorEventFlatten_fn
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cV(_component_page_head, _uM("title" to unref(title)), null, 8, _uA(
                        "title"
                    )),
                    _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt"), _uA(
                        _cE(Fragment, null, RenderHelpers.renderList(unref(supportFormats), fun(item, index, __index, _cached): Any {
                            return _cE("view", _uM("key" to index), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), _tD(item.format) + "，右边为拍平测试", 1),
                                _cE("view", _uM("class" to "uni-center", "style" to _nS(_uM("background" to "#FFFFFF"))), _uA(
                                    _cE("image", _uM("class" to "image", "mode" to "widthFix", "src" to if (item.errorImage == null) {
                                        item.src
                                    } else {
                                        item.errorImage
                                    }
                                    , "onError" to fun(`$event`: Any){
                                        imageErrorEvent(index, `$event` as ImageErrorEvent)
                                    }
                                    ), null, 40, _uA(
                                        "src",
                                        "onError"
                                    )),
                                    _cE("image", _uM("class" to "image", "mode" to "widthFix", "src" to if (item.errorImageFlatten == null) {
                                        item.src
                                    } else {
                                        item.errorImageFlatten
                                    }
                                    , "onError" to fun(`$event`: Any){
                                        imageErrorEventFlatten(index, `$event` as ImageErrorEvent)
                                    }
                                    , "flatten" to ""), null, 40, _uA(
                                        "src",
                                        "onError"
                                    ))
                                ), 4)
                            ))
                        }
                        ), 128)
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
                return _uM("image" to _pS(_uM("marginTop" to 40, "marginRight" to "auto", "marginBottom" to 40, "marginLeft" to "auto", "width" to 100)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
