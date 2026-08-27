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
open class GenPagesComponentViewIssue20486 : BasePage {
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
    open var getTestViewY: () -> Number
        get() {
            return unref(this.`$exposed`["getTestViewY"]) as () -> Number
        }
        set(value) {
            setRefValue(this.`$exposed`, "getTestViewY", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentViewIssue20486, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentViewIssue20486
            val _cache = __ins.renderCache
            val instance = getCurrentInstance()!!.proxy!!
            val currentPage = instance.`$page`
            val isDarkMode = ref(false)
            val testViewY = ref(0)
            onReady(fun(){
                var ele = uni_getElementById("testView") as UniElement
                testViewY.value = ele.getBoundingClientRect().y + currentPage.statusBarHeight + 44
                console.log(testViewY.value)
            }
            )
            val toggleTheme = fun(){
                isDarkMode.value = !isDarkMode.value
            }
            fun gen_getTestViewY_fn(): Number {
                return testViewY.value
            }
            val getTestViewY = ::gen_getTestViewY_fn
            __expose(_uM("getTestViewY" to getTestViewY))
            return fun(): Any? {
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1")), "class" to _nC(if (unref(isDarkMode)) {
                    "dark"
                } else {
                    "light"
                }
                )), _uA(
                    _cE("view", _uM("class" to "box"), _uA(
                        _cE("text", _uM("class" to _nC(if (unref(isDarkMode)) {
                            "darkText"
                        } else {
                            "lightText"
                        }
                        )), "当前模式：" + _tD(if (unref(isDarkMode)) {
                            "dark"
                        } else {
                            "light"
                        }
                        ), 3)
                    )),
                    _cE("view", _uM("id" to "testView", "hover-class" to "btn-hover", "class" to "btn", "onClick" to toggleTheme), _uA(
                        _cE("text", null, "切换:" + _tD(if (unref(isDarkMode)) {
                            "dark"
                        } else {
                            "light"
                        }
                        ) + " (应该无背景色)", 1)
                    ))
                ), 6)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("dark" to _pS(_uM("--l-box-bg-color" to "#000")), "lightText" to _pS(_uM("color" to "#000000")), "darkText" to _pS(_uM("color" to "#FFFFFF")), "btn" to _pS(_uM("height" to 50, "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10)), "btn-hover" to _pS(_uM("backgroundColor" to "var(--l-btn-hover-color, red)")), "box" to _pS(_uM("width" to 140, "height" to 140, "backgroundColor" to "var(--l-box-bg-color, #f5f5f5)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
