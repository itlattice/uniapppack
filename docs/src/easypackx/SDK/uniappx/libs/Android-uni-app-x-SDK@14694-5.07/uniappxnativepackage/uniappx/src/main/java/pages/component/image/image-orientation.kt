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
open class GenPagesComponentImageImageOrientation : BasePage {
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
        var setup: (__props: GenPagesComponentImageImageOrientation) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentImageImageOrientation
            val _cache = __ins.renderCache
            val src1 = ref("/static/test-image/orientation-90.jpg")
            val src2 = ref("/static/test-image/orientation-90.heic")
            fun gen_error1_fn() {
                src1.value = "/static/dislike.png"
            }
            val error1 = ::gen_error1_fn
            fun gen_error2_fn() {
                src2.value = "/static/dislike.png"
            }
            val error2 = ::gen_error2_fn
            return fun(): Any? {
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("style" to _nS(_uM("align-items" to "center"))), _uA(
                        _cE("text", null, "原图是横向且orientation=90°的jpg图片，预期显示为竖向"),
                        _cE("image", _uM("style" to _nS(_uM("width" to "100px", "height" to "200px")), "src" to unref(src1), "onError" to error1), null, 44, _uA(
                            "src"
                        )),
                        _cE("text", null, "原图是横向且orientation=90°的heic图片（需要支持heic的平台方有效），预期显示为竖向"),
                        _cE("image", _uM("style" to _nS(_uM("width" to "100px", "height" to "200px")), "src" to unref(src2), "onError" to error2), null, 44, _uA(
                            "src"
                        ))
                    ), 4)
                ), 4)
            }
        }
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
