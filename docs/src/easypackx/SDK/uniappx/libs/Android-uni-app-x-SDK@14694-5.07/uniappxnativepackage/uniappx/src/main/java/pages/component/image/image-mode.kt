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
open class GenPagesComponentImageImageMode : BasePage {
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
        var setup: (__props: GenPagesComponentImageImageMode) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentImageImageMode
            val _cache = __ins.renderCache
            val title = ref("image-mode")
            val data = ref(_uA<ImageMode>(ImageMode(mode = "scaleToFill", description = "不保持纵横比缩放图片，使图片的宽高完全拉伸至填满 image 元素"), ImageMode(mode = "aspectFit", description = "保持纵横比缩放图片，使图片的长边能完全显示出来。也就是说，可以完整地将图片显示出来"), ImageMode(mode = "aspectFill", description = "保持纵横比缩放图片，只保证图片的短边能完全显示出来。也就是说，图片通常只在水平或垂直方向是完整的，另一个方向将会发生截取"), ImageMode(mode = "top", description = "不缩放图片，只显示图片的顶部区域"), ImageMode(mode = "bottom", description = "不缩放图片，只显示图片的底部区域"), ImageMode(mode = "center", description = "不缩放图片，只显示图片的中间区域"), ImageMode(mode = "left", description = "不缩放图片，只显示图片的左边区域"), ImageMode(mode = "right", description = "不缩放图片，只显示图片的右边区域"), ImageMode(mode = "top left", description = "不缩放图片，只显示图片的左上边区域"), ImageMode(mode = "top right", description = "不缩放图片，只显示图片的右上边区域"), ImageMode(mode = "bottom left", description = "不缩放图片，只显示图片的左下边区域"), ImageMode(mode = "bottom right", description = "不缩放图片，只显示图片的右下边区域"), ImageMode(mode = "widthFix", description = "宽度不变，高度自动变化，保持原图宽高比不变"), ImageMode(mode = "heightFix", description = "高度不变，宽度自动变化，保持原图宽高比不变")))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cV(_component_page_head, _uM("title" to unref(title)), null, 8, _uA(
                        "title"
                    )),
                    _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt"), _uA(
                        _cE("view", _uM("class" to "uni-title"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "支持的图片缩放模式示例")
                        )),
                        _cE(Fragment, null, RenderHelpers.renderList(unref(data), fun(item, index, __index, _cached): Any {
                            return _cE("view", _uM("key" to index), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), _tD(item.mode) + ": " + _tD(item.description), 1),
                                _cE("text", _uM("class" to "uni-subtitle-text"), "右边为拍平测试"),
                                _cE("view", _uM("class" to "uni-center image-bg"), _uA(
                                    _cE("image", _uM("class" to "image", "mode" to item.mode, "src" to "/static/shuijiao.jpg"), null, 8, _uA(
                                        "mode"
                                    )),
                                    _cE("image", _uM("class" to "image", "mode" to item.mode, "src" to "/static/shuijiao.jpg", "flatten" to ""), null, 8, _uA(
                                        "mode"
                                    ))
                                ))
                            ))
                        }
                        ), 128),
                        _cE("view", _uM("class" to "uni-title"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "其他示例")
                        )),
                        _cE("view", null, _uA(
                            _cE("text", _uM("class" to "uni-subtitle-text"), "同时设置mode和圆角（右边为拍平测试）"),
                            _cE("view", _uM("class" to "uni-center image-bg"), _uA(
                                _cE("image", _uM("class" to "image radius", "mode" to "heightFix", "src" to "/static/shuijiao.jpg")),
                                _cE("image", _uM("class" to "image radius", "mode" to "heightFix", "src" to "/static/shuijiao.jpg", "flatten" to ""))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", _uM("class" to "uni-subtitle-text"), "设置图片width='100%'与mode='widthFix'（右边为拍平测试）"),
                            _cE("view", _uM("class" to "uni-center image-bg"), _uA(
                                _cE("view", _uM("class" to "uni-center", "style" to _nS(_uM("background-color" to "red", "width" to "150px", "margin" to "20px"))), _uA(
                                    _cE("image", _uM("style" to _nS(_uM("width" to "100%")), "mode" to "widthFix", "src" to "/static/shuijiao.jpg"), null, 4)
                                ), 4),
                                _cE("view", _uM("class" to "uni-center", "style" to _nS(_uM("background-color" to "red", "width" to "150px", "margin" to "20px"))), _uA(
                                    _cE("image", _uM("style" to _nS(_uM("width" to "100%")), "mode" to "widthFix", "src" to "/static/shuijiao.jpg", "flatten" to ""), null, 4)
                                ), 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", _uM("class" to "uni-subtitle-text"), "image默认mode（右边为拍平测试）"),
                            _cE("view", _uM("class" to "uni-center image-bg"), _uA(
                                _cE("view", _uM("class" to "uni-center", "style" to _nS(_uM("margin" to "20px"))), _uA(
                                    _cE("image", _uM("style" to _nS(_uM("width" to "100px", "height" to "100px", "margin-right" to "20px")), "src" to "/static/test-image/logo.png"), null, 4),
                                    _cE("image", _uM("style" to _nS(_uM("width" to "100px", "height" to "100px")), "src" to "/static/test-image/logo.png", "flatten" to ""), null, 4)
                                ), 4)
                            ))
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
                return _uM("image" to _pS(_uM("marginTop" to 20, "marginRight" to "auto", "marginBottom" to 20, "marginLeft" to "auto", "width" to 100, "height" to 100, "backgroundColor" to "#eeeeee")), "radius" to _pS(_uM("borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "borderBottomRightRadius" to 10, "borderBottomLeftRadius" to 10)), "image-bg" to _pS(_uM("backgroundImage" to "none", "backgroundColor" to "#FFFFFF")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
