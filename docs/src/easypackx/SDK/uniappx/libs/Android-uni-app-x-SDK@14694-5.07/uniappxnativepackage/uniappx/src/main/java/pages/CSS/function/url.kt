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
open class GenPagesCSSFunctionUrl : BasePage {
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
        return _cE("view", _uM("class" to "container"), _uA(
            _cE("text", _uM("class" to "intro-text"), "url() 函数用于加载图片、字体等资源，支持 /static 目录下的本地文件和网络链接。"),
            _cE("view", _uM("class" to "section"), _uA(
                _cE("text", _uM("class" to "section-title"), "字体示例"),
                _cE("view", _uM("class" to "font-grid"), _uA(
                    _cE("view", _uM("class" to "font-item"), _uA(
                        _cE("text", _uM("class" to "pacifico-font"), "Pacifico Font Example"),
                        _cE("text", _uM("class" to "font-value"), "@font-face { font-family: 'Pacifico'; src: url('/static/font/Pacifico-Regular.ttf') }")
                    )),
                    _cE("view", _uM("class" to "font-item"), _uA(
                        _cE("text", _uM("class" to "web-font"), "网络字体"),
                        _cE("text", _uM("class" to "font-value"), "@font-face { font-family: 'AlimamaDaoLiTiTTF'; src: url('https://qiniu-web-assets.dcloud.net.cn/uni-app-x/static/font/AlimamaDaoLiTi.ttf') }")
                    ))
                ))
            ))
        ))
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("container" to _pS(_uM("paddingTop" to 20, "paddingRight" to 20, "paddingBottom" to 20, "paddingLeft" to 20)), "intro-text" to _pS(_uM("fontSize" to 14, "color" to "#333333", "marginBottom" to 30, "lineHeight" to 1.6, "paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15, "backgroundColor" to "#f8f9fa", "borderTopLeftRadius" to 8, "borderTopRightRadius" to 8, "borderBottomRightRadius" to 8, "borderBottomLeftRadius" to 8)), "section" to _pS(_uM("marginBottom" to 30)), "section-title" to _pS(_uM("fontSize" to 18, "fontWeight" to "bold", "marginBottom" to 15)), "font-grid" to _pS(_uM("flexDirection" to "row", "flexWrap" to "wrap")), "font-item" to _pS(_uM("width" to "100%", "marginBottom" to 20)), "custom-font" to _pS(_uM("fontSize" to 20, "marginBottom" to 8, "fontFamily" to "AlimamaDaoLiTi")), "pacifico-font" to _pS(_uM("fontSize" to 20, "marginBottom" to 8, "fontFamily" to "Pacifico")), "web-font" to _pS(_uM("fontSize" to 20, "marginBottom" to 8, "fontFamily" to "AlimamaDaoLiTiTTF")), "font-value" to _pS(_uM("fontSize" to 12, "color" to "#999999")), "@FONT-FACE" to _uM("0" to _uM("fontFamily" to "AlimamaDaoLiTi", "src" to "url('/static/app-ios/AlimamaDaoLiTi.woff2'),\n\t\t\t url('/static/app-ios/AlimamaDaoLiTi.woff'),\n\t\t\t url('/static/font/AlimamaDaoLiTi.otf')"), "1" to _uM("fontFamily" to "Pacifico", "src" to "url('/static/font/Pacifico-Regular.ttf')"), "2" to _uM("fontFamily" to "AlimamaDaoLiTiTTF", "src" to "url('https://qiniu-web-assets.dcloud.net.cn/uni-app-x/static/font/AlimamaDaoLiTi.ttf')")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
