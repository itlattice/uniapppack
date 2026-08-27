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
open class GenPagesComponentListViewIssue17030 : BasePage {
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
    open var addData: () -> Unit
        get() {
            return unref(this.`$exposed`["addData"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "addData", value)
        }
    open var getScrollHeight: () -> Number
        get() {
            return unref(this.`$exposed`["getScrollHeight"]) as () -> Number
        }
        set(value) {
            setRefValue(this.`$exposed`, "getScrollHeight", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentListViewIssue17030, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentListViewIssue17030
            val _cache = __ins.renderCache
            val arr = ref(_uA<Number>(1, 2, 3, 4, 5))
            val addData = fun(){
                arr.value.push(arr.value.length + 1)
            }
            val getScrollHeight = fun(): Number {
                val listViewElement = uni_getElementById("listView") as UniElement
                val scrollHeight = listViewElement.scrollHeight
                console.log(scrollHeight)
                return scrollHeight
            }
            __expose(_uM("addData" to addData, "getScrollHeight" to getScrollHeight))
            return fun(): Any? {
                return _cE("view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("list-view", _uM("id" to "listView", "style" to _nS(_uM("width" to "100%", "background-color" to "red"))), _uA(
                        _cE(Fragment, null, RenderHelpers.renderList(unref(arr), fun(item, index, __index, _cached): Any {
                            return _cE("list-item", _uM("key" to index), _uA(
                                _cE("text", _uM("class" to "title"), _tD(item), 1)
                            ))
                        }
                        ), 128)
                    ), 4)
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
                return _uM("title" to _pS(_uM("height" to 30, "fontSize" to 18, "color" to "#000000", "textAlign" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
