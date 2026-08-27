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
open class GenPagesCSSDisplayFlexIssue26331 : BasePage {
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
        var setup: (__props: GenPagesCSSDisplayFlexIssue26331) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSDisplayFlexIssue26331
            val _cache = __ins.renderCache
            val containerShow = ref<Boolean>(false)
            val contentStyle = ref<String>("")
            val showDialogDemo = fun(){
                contentStyle.value = "width: 600rpx;"
                containerShow.value = true
            }
            val showComprehensiveDemo = fun(){
                contentStyle.value = "width: 300rpx;"
                containerShow.value = true
            }
            val closeContainer = fun(){
                containerShow.value = false
            }
            return fun(): Any? {
                return _cE(Fragment, null, _uA(
                    _cE("button", _uM("id" to "openContainer", "onClick" to showDialogDemo, "size" to "mini"), "打开对话框"),
                    _cE("button", _uM("id" to "openContainerSmall", "onClick" to showComprehensiveDemo, "size" to "mini"), "打开综合演示"),
                    _cE("view", _uM("style" to _nS(_uM("display" to if (unref(containerShow)) {
                        "flex"
                    } else {
                        "none"
                    }
                    ))), _uA(
                        _cE("view", _uM("style" to _nS(unref(contentStyle))), _uA(
                            _cE("button", _uM("onClick" to closeContainer, "size" to "mini", "id" to "closeContainer"), "关闭容器")
                        ), 4)
                    ), 4)
                ), 64)
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
