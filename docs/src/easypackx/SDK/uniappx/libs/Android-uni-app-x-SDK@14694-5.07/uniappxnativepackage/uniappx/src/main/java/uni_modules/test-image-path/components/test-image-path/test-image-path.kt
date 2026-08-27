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
open class GenUniModulesTestImagePathComponentsTestImagePathTestImagePath : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _cache = this.`$`.renderCache
        return _cE("view", null, _uA(
            _cE("view", null, _uA(
                _cE("text", _uM("class" to "uni-subtitle-text"), "uni_modules的组件模板相对路径静态引入插件内static目录图片"),
                _cE("view", _uM("class" to "uni-center", "style" to _nS(_uM("background" to "#FFFFFF"))), _uA(
                    _cE("image", _uM("class" to "image", "mode" to "widthFix", "src" to default__2))
                ), 4)
            )),
            _cE("view", null, _uA(
                _cE("text", _uM("class" to "uni-subtitle-text"), "uni_modules的组件模板绝对路径静态引入插件内static目录图片"),
                _cE("view", _uM("class" to "uni-center", "style" to _nS(_uM("background" to "#FFFFFF"))), _uA(
                    _cE("image", _uM("class" to "image", "mode" to "widthFix", "src" to "/uni_modules/test-image-path/static/test-image-path.png"))
                ), 4)
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
                return _uM("image" to _pS(_uM("marginTop" to 20, "marginRight" to "auto", "marginBottom" to 20, "marginLeft" to "auto", "width" to 100)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
