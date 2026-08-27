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
open class GenPagesCSSOverflowOverflow : BasePage {
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
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _cache = this.`$`.renderCache
        val _component_page_intro = resolveEasyComponent("page-intro", GenComponentsPageIntroPageIntroClass)
        return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
            _cV(_component_page_intro, _uM("content" to "本页演示 overflow 样式：overflow:hidden 与 overflow:visible 下子元素超出时的裁剪与显示；子元素为 view（border 圆角/边框）、text、image 等，每组均提供拍平（flatten）版本对比。")),
            _cE("text", _uM("style" to _nS(_uM("font-size" to "15px"))), "overflow=hidden效果子元素是view border圆角", 4),
            _cE("view", _uM("class" to "backgroundview"), _uA(
                _cE("view", _uM("class" to "box-hidden-border-radius"), _uA(
                    _cE("view", _uM("style" to _nS(_uM("width" to "50px", "height" to "150px", "background-color" to "greenyellow"))), null, 4)
                ))
            )),
            _cE("text", null, "拍平"),
            _cE("view", _uM("class" to "backgroundview"), _uA(
                _cE("view", _uM("class" to "box-hidden-border-radius", "flatten" to ""), _uA(
                    _cE("view", _uM("style" to _nS(_uM("width" to "50px", "height" to "150px", "background-color" to "greenyellow")), "flatten" to ""), null, 4)
                ))
            )),
            _cE("text", _uM("style" to _nS(_uM("font-size" to "15px"))), "overflow=hidden效果 子元素是view border边框", 4),
            _cE("view", _uM("class" to "backgroundview"), _uA(
                _cE("view", _uM("class" to "box-hidden-border-width"), _uA(
                    _cE("view", _uM("style" to _nS(_uM("width" to "50px", "height" to "150px", "background-color" to "greenyellow"))), null, 4)
                ))
            )),
            _cE("text", null, "拍平"),
            _cE("view", _uM("class" to "backgroundview"), _uA(
                _cE("view", _uM("class" to "box-hidden-border-width", "flatten" to ""), _uA(
                    _cE("view", _uM("style" to _nS(_uM("width" to "50px", "height" to "150px", "background-color" to "greenyellow")), "flatten" to ""), null, 4)
                ))
            )),
            _cE("text", _uM("style" to _nS(_uM("font-size" to "15px"))), "overflow=visible效果 子元素是view border圆角", 4),
            _cE("view", _uM("class" to "backgroundview"), _uA(
                _cE("view", _uM("class" to "box-visible-border-radius"), _uA(
                    _cE("view", _uM("style" to _nS(_uM("width" to "50px", "height" to "150px", "background-color" to "greenyellow"))), null, 4)
                ))
            )),
            _cE("text", null, "拍平"),
            _cE("view", _uM("class" to "backgroundview"), _uA(
                _cE("view", _uM("class" to "box-visible-border-radius", "flatten" to ""), _uA(
                    _cE("view", _uM("style" to _nS(_uM("width" to "50px", "height" to "150px", "background-color" to "greenyellow")), "flatten" to ""), null, 4)
                ))
            )),
            _cE("text", _uM("style" to _nS(_uM("font-size" to "15px"))), "overflow=visible效果 子元素是view border边框", 4),
            _cE("view", _uM("class" to "backgroundview"), _uA(
                _cE("view", _uM("class" to "box-visible-border-width"), _uA(
                    _cE("view", _uM("style" to _nS(_uM("width" to "50px", "height" to "150px", "background-color" to "greenyellow"))), null, 4)
                ))
            )),
            _cE("text", null, "拍平"),
            _cE("view", _uM("class" to "backgroundview"), _uA(
                _cE("view", _uM("class" to "box-visible-border-width", "flatten" to ""), _uA(
                    _cE("view", _uM("style" to _nS(_uM("width" to "50px", "height" to "150px", "background-color" to "greenyellow")), "flatten" to ""), null, 4)
                ))
            )),
            _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1"))), _uA(
                _cE("text", _uM("style" to _nS(_uM("font-size" to "15px"))), "overflow=hidden效果 子元素是text", 4),
                _cE("view", _uM("class" to "backgroundview"), _uA(
                    _cE("view", _uM("class" to "box-hidden-border-radius"), _uA(
                        _cE("text", _uM("class" to "text1"), "ABCDEFG")
                    ))
                )),
                _cE("text", null, "拍平"),
                _cE("view", _uM("class" to "backgroundview"), _uA(
                    _cE("view", _uM("class" to "box-hidden-border-radius", "flatten" to ""), _uA(
                        _cE("text", _uM("class" to "text1", "flatten" to ""), "ABCDEFG")
                    ))
                )),
                _cE("text", _uM("style" to _nS(_uM("font-size" to "15px"))), "overflow=visible效果 子元素是text", 4),
                _cE("view", _uM("class" to "backgroundview"), _uA(
                    _cE("view", _uM("class" to "box-visible-border-radius"), _uA(
                        _cE("text", _uM("class" to "text1"), "ABCDEFG")
                    ))
                )),
                _cE("text", null, "拍平"),
                _cE("view", _uM("class" to "backgroundview"), _uA(
                    _cE("view", _uM("class" to "box-visible-border-radius", "flatten" to ""), _uA(
                        _cE("text", _uM("class" to "text1", "flatten" to ""), "ABCDEFG")
                    ))
                )),
                _cE("text", _uM("style" to _nS(_uM("font-size" to "15px"))), "overflow=hidden效果 子元素是image", 4),
                _cE("view", _uM("class" to "backgroundview"), _uA(
                    _cE("view", _uM("class" to "box-hidden-border-radius"), _uA(
                        _cE("image", _uM("style" to _nS(_uM("width" to "150px", "height" to "150px")), "src" to "/static/test-image/logo.png"), null, 4)
                    ))
                )),
                _cE("text", null, "拍平"),
                _cE("view", _uM("class" to "backgroundview"), _uA(
                    _cE("view", _uM("class" to "box-hidden-border-radius", "flatten" to ""), _uA(
                        _cE("image", _uM("style" to _nS(_uM("width" to "150px", "height" to "150px")), "src" to "/static/test-image/logo.png", "flatten" to ""), null, 4)
                    ))
                )),
                _cE("text", _uM("style" to _nS(_uM("font-size" to "15px"))), "overflow=visible效果 子元素是image", 4),
                _cE("view", _uM("class" to "backgroundview"), _uA(
                    _cE("view", _uM("class" to "box-visible-border-radius"), _uA(
                        _cE("image", _uM("style" to _nS(_uM("width" to "150px", "height" to "150px")), "src" to "/static/test-image/logo.png"), null, 4)
                    ))
                )),
                _cE("text", null, "拍平"),
                _cE("view", _uM("class" to "backgroundview"), _uA(
                    _cE("view", _uM("class" to "box-visible-border-radius", "flatten" to ""), _uA(
                        _cE("image", _uM("style" to _nS(_uM("width" to "150px", "height" to "150px")), "src" to "/static/test-image/logo.png", "flatten" to ""), null, 4)
                    ))
                )),
                _cE("text", _uM("style" to _nS(_uM("font-size" to "15px"))), "overflow=visible效果 子元素是view 父是scroll-view", 4),
                _cE("scroll-view", _uM("class" to "backgroundview"), _uA(
                    _cE("view", _uM("class" to "box-visible-border-radius"), _uA(
                        _cE("view", _uM("style" to _nS(_uM("width" to "50px", "height" to "150px", "background-color" to "greenyellow"))), null, 4)
                    ))
                )),
                _cE("text", null, "拍平"),
                _cE("scroll-view", _uM("class" to "backgroundview"), _uA(
                    _cE("view", _uM("class" to "box-visible-border-radius", "flatten" to ""), _uA(
                        _cE("view", _uM("style" to _nS(_uM("width" to "50px", "height" to "150px", "background-color" to "greenyellow")), "flatten" to ""), null, 4)
                    ))
                )),
                _cE("text", _uM("style" to _nS(_uM("font-size" to "15px"))), "overflow=visible 设置阴影显示文字", 4),
                _cE("view", _uM("class" to "backgroundview"), _uA(
                    _cE("view", _uM("class" to "", "style" to _nS(_uM("overflow" to "visible", "width" to "100px", "height" to "100px", "background-color" to "green", "box-shadow" to "10px 10px #000", "margin-top" to "10px"))), _uA(
                        _cE("text", _uM("style" to _nS(_uM("width" to "170px", "background-color" to "greenyellow"))), "文字文字文字文字文字", 4)
                    ), 4)
                )),
                _cE("text", null, "拍平"),
                _cE("view", _uM("class" to "backgroundview"), _uA(
                    _cE("view", _uM("class" to "", "style" to _nS(_uM("overflow" to "visible", "width" to "100px", "height" to "100px", "background-color" to "green", "box-shadow" to "10px 10px #000", "margin-top" to "10px")), "flatten" to ""), _uA(
                        _cE("text", _uM("style" to _nS(_uM("width" to "170px", "background-color" to "greenyellow")), "flatten" to ""), "文字文字文字文字文字", 4)
                    ), 4)
                )),
                _cE("text", _uM("style" to _nS(_uM("font-size" to "15px"))), "overflow=visible 子view完全超出范围", 4),
                _cE("view", _uM("class" to "backgroundview"), _uA(
                    _cE("view", _uM("class" to "box-visible-border-width"), _uA(
                        _cE("view", _uM("style" to _nS(_uM("width" to "50px", "height" to "50px", "background-color" to "greenyellow", "right" to "-70px", "position" to "absolute"))), null, 4)
                    ))
                )),
                _cE("text", null, "拍平"),
                _cE("view", _uM("class" to "backgroundview"), _uA(
                    _cE("view", _uM("class" to "box-visible-border-width", "flatten" to ""), _uA(
                        _cE("view", _uM("style" to _nS(_uM("width" to "50px", "height" to "50px", "background-color" to "greenyellow", "right" to "-70px", "position" to "absolute")), "flatten" to ""), null, 4)
                    ))
                ))
            ), 4)
        ), 4)
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("backgroundview" to _pS(_uM("width" to 300, "height" to 200, "backgroundColor" to "#FFFFFF", "justifyContent" to "center", "alignItems" to "center")), "box-hidden-border-radius" to _pS(_uM("width" to 100, "height" to 100, "borderTopLeftRadius" to 20, "borderTopRightRadius" to 20, "borderBottomRightRadius" to 20, "borderBottomLeftRadius" to 20, "overflow" to "hidden", "backgroundColor" to "#008000")), "box-hidden-border-width" to _pS(_uM("width" to 100, "height" to 100, "borderTopWidth" to 2, "borderRightWidth" to 2, "borderBottomWidth" to 2, "borderLeftWidth" to 2, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "backgroundColor" to "#008000")), "box-visible-border-radius" to _pS(_uM("width" to 100, "height" to 100, "borderTopLeftRadius" to 20, "borderTopRightRadius" to 20, "borderBottomRightRadius" to 20, "borderBottomLeftRadius" to 20, "overflow" to "visible", "backgroundColor" to "#008000")), "box-visible-border-width" to _pS(_uM("width" to 100, "height" to 100, "borderTopWidth" to 2, "borderRightWidth" to 2, "borderBottomWidth" to 2, "borderLeftWidth" to 2, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "overflow" to "visible", "backgroundColor" to "#008000")), "text1" to _pS(_uM("fontSize" to 50, "lines" to 1)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
