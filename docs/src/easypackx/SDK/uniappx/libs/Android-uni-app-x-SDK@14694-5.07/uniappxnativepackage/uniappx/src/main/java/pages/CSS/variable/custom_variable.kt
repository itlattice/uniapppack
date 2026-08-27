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
open class GenPagesCSSVariableCustomVariable : BasePage {
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
        var setup: (__props: GenPagesCSSVariableCustomVariable) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSVariableCustomVariable
            val _cache = __ins.renderCache
            val var_bind = ref("var_1_bind_1")
            val var_v_if = ref(false)
            val text_style_var_def = ref("text_style_var_1")
            val text_style_var_1_on = ref(true)
            val do_change_var = fun(){
                val view_container = uni_getElementById("view_container")
                if (text_style_var_1_on.value) {
                    text_style_var_def.value = "text_style_var_2"
                    text_style_var_1_on.value = false
                    view_container?.style?.setProperty("--var_flex_direction", "row")
                    view_container?.style?.setProperty("--var_justify_content", "flex-end")
                    view_container?.style?.setProperty("--var_margin", "")
                    view_container?.style?.setProperty("background-color", "var(--background-color)")
                } else {
                    text_style_var_def.value = "text_style_var_1"
                    text_style_var_1_on.value = true
                    view_container?.style?.setProperty("--var_margin", "10px")
                    view_container?.style?.setProperty("--var_flex_direction", "column")
                    view_container?.style?.setProperty("--var_justify_content", "center")
                    view_container?.style?.setProperty("background-color", "#FFF")
                }
                var_bind.value = if ((var_bind.value == "var_1_bind_2")) {
                    "var_1_bind_1"
                } else {
                    "var_1_bind_2"
                }
            }
            val do_vif = fun(){
                var_v_if.value = !var_v_if.value
            }
            return fun(): Any? {
                return _cE("view", _uM("id" to "var_1", "style" to _nS(_uM("flex" to "1", "--var_margin" to "2px")), "class" to _nC(_uA(
                    "var_1",
                    unref(var_bind)
                ))), _uA(
                    _cE("view", null, _uA(
                        _cE("view", _uM("class" to "var_1_1_1"), _uA(
                            _cE("text", _uM("class" to "firstParagraph"), "此段落应有蓝色背景和绿色文本。")
                        )),
                        _cE("text", _uM("class" to "secondParagraph"), "此段落应有黑色半透明背景和黄色文本。")
                    )),
                    _cE("text", _uM("style" to _nS(_uM("width" to "var(--var_width_invalid, 375rpx)", "background-color" to "yellowgreen"))), "无效值width应为375rpx", 4),
                    _cE("view", _uM("id" to "chanageVarBox", "class" to _nC(unref(text_style_var_def))), _uA(
                        if (isTrue(unref(text_style_var_1_on))) {
                            _cE("text", _uM("key" to 0, "class" to "text_style"), "font-size:26px;style:normal;color:#ccc;background-color:#488cff")
                        } else {
                            _cE("text", _uM("key" to 1, "class" to "text_style"), "font-size:16px;style:italic;color:#803390;background-color:#48ff32")
                        }
                    ), 2),
                    _cE("view", _uM("class" to "view_layout_style_container", "id" to "view_container"), _uA(
                        _cE("view", _uM("class" to "view_layout_style")),
                        _cE("view", _uM("class" to "view_layout_style", "style" to _nS(_uM("background-color" to "blue", "--var_align_self" to "flex-start"))), null, 4)
                    )),
                    _cE("button", _uM("id" to "changeVarButton", "onClick" to fun(){
                        do_change_var()
                    }
                    ), "修改自定义变量", 8, _uA(
                        "onClick"
                    )),
                    _cE("view", _uM("class" to "test-v-if"), _uA(
                        if (isTrue(unref(var_v_if))) {
                            _cE("view", _uM("key" to 0, "style" to _nS(_uM("height" to "var(--var_height)", "background-color" to "var(--var_backgroundColor)"))), null, 4)
                        } else {
                            _cC("v-if", true)
                        }
                    )),
                    _cE("button", _uM("class" to "test-v-if-button", "onClick" to fun(){
                        do_vif()
                    }
                    ), "v-if测试", 8, _uA(
                        "onClick"
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
                return _uM("var_1" to _pS(_uM("paddingLeft" to "env(safe-area-inset-left)", "paddingRight" to "env(safe-area-inset-right)", "--font-color" to "#00ff00", "--var_width" to "375rpx", "--var_backgroundColor" to "rgba(0, 0, 0, .5)")), "var_1_bind_1" to _pS(_uM("--var_height" to "30px")), "var_1_bind_2" to _pS(_uM("--var_height" to "60px")), "var_1_1_1" to _pS(_uM("--var_backgroundColor" to "#0000ff")), "content" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "firstParagraph" to _pS(_uM("backgroundColor" to "var(--var_backgroundColor)", "color" to "var(--font-color)")), "secondParagraph" to _pS(_uM("--font-color" to "yellow", "backgroundColor" to "var(--var_backgroundColor)", "color" to "var(--font-color)")), "text_style_var_1" to _pS(_uM("--text-font-size" to "26px", "--text-font-style" to "normal", "--text-color" to "#ccc", "--text-background-color" to "#488cff")), "text_style_var_2" to _pS(_uM("--text-font-size" to "16px", "--text-font-style" to "italic", "--text-color" to "#803390", "--text-background-color" to "#48ff32")), "text_style" to _pS(_uM("fontFamily" to "var(--swiper-item-font-family)", "fontSize" to "var(--text-font-size)", "fontStyle" to "var(--text-font-style)", "color" to "var(--text-color)", "backgroundColor" to "var(--text-background-color)")), "view_layout_style_container" to _pS(_uM("--var_flex_direction" to "column", "--var_align_self" to "center", "--var_justify_content" to "center", "--var_border" to "2px red solid", "--var_border2" to "2px green solid", "--background-color" to "#CCC", "--var_height" to "110px", "--var_margin" to "10px", "height" to "var(--var_height)", "flexDirection" to "var(--var_flex_direction)", "justifyContent" to "var(--var_justify_content)", "marginTop" to "var(--var_margin)", "marginRight" to "var(--var_margin)", "marginBottom" to "var(--var_margin)", "marginLeft" to "var(--var_margin)")), "view_layout_style" to _pS(_uM("width" to 50, "height" to 50, "backgroundColor" to "#A52A2A", "alignSelf" to "var(--var_align_self)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
