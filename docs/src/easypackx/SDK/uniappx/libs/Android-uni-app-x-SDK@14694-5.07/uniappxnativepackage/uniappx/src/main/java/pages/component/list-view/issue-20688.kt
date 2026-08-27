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
open class GenPagesComponentListViewIssue20688 : BasePage {
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
        return _cE("view", _uM("style" to _nS(_uM("width" to "100%", "flex" to "1"))), _uA(
            _cE("list-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                _cE("list-item", _uM("style" to _nS(_uM("background-color" to "black", "flex-direction" to "column"))), _uA(
                    _cE("image", _uM("mode" to "widthFix", "src" to "/static/test-image/logo.png")),
                    _cE("view", _uM("style" to _nS(_uM("width" to "100%", "height" to "100px", "background-color" to "rgba(170, 170, 255, 0.5)"))), null, 4)
                ), 4)
            ), 4),
            _cE("view", _uM("style" to _nS(_uM("flex" to "1", "background-color" to "red", "flex-direction" to "column"))), _uA(
                _cE("image", _uM("mode" to "widthFix", "src" to "/static/test-image/logo.png")),
                _cE("view", _uM("style" to _nS(_uM("width" to "100%", "height" to "100px", "background-color" to "rgba(170, 170, 255, 0.5)"))), null, 4)
            ), 4)
        ), 4)
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
