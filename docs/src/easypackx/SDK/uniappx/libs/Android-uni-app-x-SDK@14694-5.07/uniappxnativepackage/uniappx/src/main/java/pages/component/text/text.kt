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
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
open class GenPagesComponentTextText : BasePage {
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
        var setup: (__props: GenPagesComponentTextText) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentTextText
            val _cache = __ins.renderCache
            val title = ref("text")
            val singleLineText = ref("单行文本：16px字体、500粗细、斜体、下划线、1px字间距、1.8行高、文本阴影、居中对齐、不换行溢出省略、带边框圆角、内外边距、背景色")
            val multiLineText = ref("多行文本：字体(16px/500粗细/斜体)、装饰(下划线/阴影)、间距(1px字间距/1.8行高)、对齐(左对齐)、盒模型(边框/圆角/内外边距/背景色)。\n 第二行：展示自动换行效果及所有CSS样式的渲染表现。")
            val texts = _uA(
                "HBuilderX，轻巧、极速，极客编辑器",
                "uni-app x，终极跨平台方案",
                "uniCloud，js serverless云服务",
                "uts，大一统语言",
                "uniMPSdk，让你的App具备小程序能力",
                "uni-admin，开源、现成的全端管理后台",
                "uni-id，开源、全端的账户中心",
                "uni-pay，开源、云端一体、全平台的支付",
                "uni-ai，聚合ai能力",
                "uni-cms，开源、云端一体、全平台的内容管理平台",
                "uni-im，开源、云端一体、全平台的im即时消息",
                "uni统计，开源、完善、全平台的统计报表",
                "......"
            ) as UTSArray<String>
            val text = ref("")
            val canAdd = ref(true)
            val canRemove = ref(false)
            var extraLine: UTSArray<String> = _uA()
            val add = fun(){
                extraLine.push(texts[extraLine.length % 12])
                text.value = extraLine.join("\n")
                canAdd.value = extraLine.length < 12
                canRemove.value = extraLine.length > 0
            }
            val remove = fun(){
                if (extraLine.length > 0) {
                    extraLine.pop()
                    text.value = extraLine.join("\n")
                    canAdd.value = extraLine.length < 12
                    canRemove.value = extraLine.length > 0
                }
            }
            val textProps = fun(){
                uni_navigateTo(NavigateToOptions(url = "/pages/component/text/text-props"))
            }
            val textLayout = fun(){
                uni_navigateTo(NavigateToOptions(url = "/pages/component/text/text-layout"))
            }
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cV(_component_page_head, _uM("title" to unref(title)), null, 8, _uA(
                        "title"
                    )),
                    _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt"), _uA(
                        _cE("text", _uM("class" to "uni-title-text"), "单行文本"),
                        _cE("view", _uM("class" to "text-box"), _uA(
                            _cE("text", _uM("class" to "styled-text single-line"), _tD(unref(singleLineText)), 1)
                        )),
                        _cE("text", _uM("class" to "uni-subtitle-text"), "单行文本 - 拍平"),
                        _cE("view", _uM("class" to "text-box", "flatten" to ""), _uA(
                            _cE("text", _uM("class" to "styled-text single-line", "flatten" to ""), _tD(unref(singleLineText)), 1)
                        )),
                        _cE("text", _uM("class" to "uni-title-text"), "多行文本"),
                        _cE("view", _uM("class" to "text-box"), _uA(
                            _cE("text", _uM("class" to "styled-text"), _tD(unref(multiLineText)), 1)
                        )),
                        _cE("text", _uM("class" to "uni-subtitle-text"), "多行文本 - 拍平"),
                        _cE("view", _uM("class" to "text-box", "flatten" to ""), _uA(
                            _cE("text", _uM("class" to "styled-text", "flatten" to ""), _tD(unref(multiLineText)), 1)
                        )),
                        _cE("text", _uM("class" to "uni-title-text"), "嵌套的text样式合集"),
                        _cE("text", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "styled-text"), "text嵌套text的内容："),
                            _cE("text", _uM("class" to "styled-text"), _tD(unref(multiLineText)), 1)
                        )),
                        _cE("text", _uM("class" to "uni-title-text"), "自定义组件：右边拍平"),
                        _cE("view", _uM("class" to "view-row"), _uA(
                            _cV(unref(GenPagesComponentTextChildClass)),
                            _cV(unref(GenPagesComponentTextChildClass), _uM("flatten" to ""))
                        )),
                        _cE("text", _uM("class" to "uni-title-text"), "动态文本"),
                        _cE("view", _uM("class" to "dynamic-text-box"), _uA(
                            _cE("text", _uM("class" to "text"), _tD(unref(text)), 1)
                        )),
                        _cE("text", _uM("class" to "uni-subtitle-text"), "动态文本 - 拍平"),
                        _cE("view", _uM("class" to "dynamic-text-box", "flatten" to ""), _uA(
                            _cE("text", _uM("class" to "text", "flatten" to ""), _tD(unref(text)), 1)
                        )),
                        _cE("view", _uM("class" to "uni-btn-v"), _uA(
                            _cE("button", _uM("class" to "uni-btn", "type" to "primary", "disabled" to !unref(canAdd), "onClick" to add), " add line ", 8, _uA(
                                "disabled"
                            )),
                            _cE("button", _uM("class" to "uni-btn", "type" to "warn", "disabled" to !unref(canRemove), "onClick" to remove), " remove line ", 8, _uA(
                                "disabled"
                            )),
                            _cE("button", _uM("class" to "uni-btn", "type" to "primary", "onClick" to textProps), " 更多属性示例 "),
                            _cE("button", _uM("class" to "uni-btn", "type" to "primary", "onClick" to textLayout), " 文本测量 ")
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
                return _uM("view-row" to _pS(_uM("flexDirection" to "row", "backgroundImage" to "none", "backgroundColor" to "#ffffff", "justifyContent" to "space-around")), "text-box" to _pS(_uM("marginBottom" to 15, "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "display" to "flex", "minHeight" to 60, "backgroundColor" to "#ffffff", "justifyContent" to "center", "alignItems" to "center")), "styled-text" to _pS(_uM("fontSize" to 16, "fontWeight" to "500", "fontStyle" to "italic", "color" to "#1a1a1a", "lineHeight" to 1.8, "letterSpacing" to 1, "textAlign" to "left", "textDecorationLine" to "underline", "textShadow" to "2px 2px 4px rgba(0, 0, 0, 0.3)", "width" to "100%", "marginTop" to 5, "marginRight" to 0, "marginBottom" to 5, "marginLeft" to 0, "paddingTop" to 8, "paddingRight" to 12, "paddingBottom" to 8, "paddingLeft" to 12, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#e0e0e0", "borderRightColor" to "#e0e0e0", "borderBottomColor" to "#e0e0e0", "borderLeftColor" to "#e0e0e0", "borderTopLeftRadius" to 4, "borderTopRightRadius" to 4, "borderBottomRightRadius" to 4, "borderBottomLeftRadius" to 4, "backgroundColor" to "#f9f9f9")), "single-line" to _pS(_uM("whiteSpace" to "nowrap", "textOverflow" to "ellipsis", "textAlign" to "center")), "dynamic-text-box" to _pS(_uM("marginBottom" to 15, "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "display" to "flex", "minHeight" to 50, "backgroundColor" to "#ffffff", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#dddddd", "borderRightColor" to "#dddddd", "borderBottomColor" to "#dddddd", "borderLeftColor" to "#dddddd", "borderTopLeftRadius" to 5, "borderTopRightRadius" to 5, "borderBottomRightRadius" to 5, "borderBottomLeftRadius" to 5, "justifyContent" to "center", "alignItems" to "center")), "text" to _pS(_uM("fontSize" to 14, "color" to "#353535", "lineHeight" to "22px", "textAlign" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
