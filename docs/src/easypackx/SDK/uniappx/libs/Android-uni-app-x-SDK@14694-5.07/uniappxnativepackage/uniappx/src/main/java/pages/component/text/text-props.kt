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
import io.dcloud.uniapp.extapi.showModal as uni_showModal
open class GenPagesComponentTextTextProps : BasePage {
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
    open var data: DataType__18
        get() {
            return unref(this.`$exposed`["data"]) as DataType__18
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var setNestedText: () -> Unit
        get() {
            return unref(this.`$exposed`["setNestedText"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setNestedText", value)
        }
    open var setEmptyText: () -> Unit
        get() {
            return unref(this.`$exposed`["setEmptyText"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setEmptyText", value)
        }
    open var setHeightText: () -> Unit
        get() {
            return unref(this.`$exposed`["setHeightText"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setHeightText", value)
        }
    open var getBoundingClientRectForTest: () -> DOMRect?
        get() {
            return unref(this.`$exposed`["getBoundingClientRectForTest"]) as () -> DOMRect?
        }
        set(value) {
            setRefValue(this.`$exposed`, "getBoundingClientRectForTest", value)
        }
    open var nestedText1TapForTest: () -> Unit
        get() {
            return unref(this.`$exposed`["nestedText1TapForTest"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "nestedText1TapForTest", value)
        }
    open var nestedText2TapForTest: () -> Unit
        get() {
            return unref(this.`$exposed`["nestedText2TapForTest"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "nestedText2TapForTest", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentTextTextProps, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentTextTextProps
            val _cache = __ins.renderCache
            val decodeStr = ref("&lt; &gt; &amp; &apos;")
            val title = ref("text-props")
            val multiLineText = ref("HBuilderX，轻巧、极速，极客编辑器；uni-app x，终极跨平台方案；uts，大一统语言；HBuilderX，轻巧、极速，极客编辑器；uni-app x，终极跨平台方案；uts，大一统语言")
            val singleLineText = ref("uni-app x，终极跨平台方案")
            val textArr = ref(_uA(
                "嵌套 text 1 ",
                "嵌套 text 2 ",
                "嵌套 text 3 "
            ))
            val data = reactive(DataType__18(autoTest = false, nestedText = "三级节点文本", emptyText = "空文本", heightText = "设置高度文本", isNestedText1TapTriggered = false, isNestedText2TapTriggered = false))
            fun gen_nestedText1Tap_fn() {
                uni_showModal(ShowModalOptions(title = "点击了", content = "一级节点黑色", showCancel = false))
            }
            val nestedText1Tap = ::gen_nestedText1Tap_fn
            fun gen_nestedText2Tap_fn(e: UniPointerEvent) {
                e.stopPropagation()
                uni_showModal(ShowModalOptions(title = "点击了", content = "二级节点红色且背景色黄色", showCancel = false))
            }
            val nestedText2Tap = ::gen_nestedText2Tap_fn
            fun gen_nestedText3Tap_fn(e: UniPointerEvent) {
                e.stopPropagation()
                uni_showModal(ShowModalOptions(title = "点击了", content = "App三级节点不继承二级的颜色", showCancel = false))
            }
            val nestedText3Tap = ::gen_nestedText3Tap_fn
            fun gen_iconTap_fn() {
                uni_showModal(ShowModalOptions(title = "点击了", content = "字体图标1", showCancel = false))
            }
            val iconTap = ::gen_iconTap_fn
            fun gen_iconTap2_fn() {
                uni_showModal(ShowModalOptions(title = "点击了", content = "字体图标2", showCancel = false))
            }
            val iconTap2 = ::gen_iconTap2_fn
            fun gen_setNestedText_fn() {
                data.nestedText = "修改三级节点文本"
            }
            val setNestedText = ::gen_setNestedText_fn
            fun gen_setEmptyText_fn() {
                data.emptyText = ""
            }
            val setEmptyText = ::gen_setEmptyText_fn
            fun gen_setHeightText_fn() {
                data.heightText = "修改设置高度文本"
            }
            val setHeightText = ::gen_setHeightText_fn
            fun gen_getBoundingClientRectForTest_fn(): DOMRect? {
                return uni_getElementById("nested-text2")?.getBoundingClientRect()
            }
            val getBoundingClientRectForTest = ::gen_getBoundingClientRectForTest_fn
            fun gen_nestedText1TapForTest_fn() {
                data.isNestedText1TapTriggered = true
            }
            val nestedText1TapForTest = ::gen_nestedText1TapForTest_fn
            fun gen_nestedText2TapForTest_fn() {
                data.isNestedText2TapTriggered = true
            }
            val nestedText2TapForTest = ::gen_nestedText2TapForTest_fn
            __expose(_uM("data" to data, "setNestedText" to setNestedText, "setEmptyText" to setEmptyText, "setHeightText" to setHeightText, "getBoundingClientRectForTest" to getBoundingClientRectForTest, "nestedText1TapForTest" to nestedText1TapForTest, "nestedText2TapForTest" to nestedText2TapForTest))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("style" to _nS(_uM("background-color" to "#EEE"))), _uA(
                        _cV(_component_page_head, _uM("title" to unref(title)), null, 8, _uA(
                            "title"
                        )),
                        _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt"), _uA(
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-title-text"), "text相关属性示例")
                            )),
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "根据宽度自动折行")
                            )),
                            _cE("view", _uM("class" to "text-box"), _uA(
                                _cE("text", null, _tD(unref(multiLineText)), 1)
                            )),
                            _cE("text", _uM("class" to "uni-subtitle-text"), "根据宽度自动折行，拍平测试"),
                            _cE("view", _uM("class" to "text-box"), _uA(
                                _cE("text", _uM("flatten" to ""), _tD(unref(multiLineText)), 1)
                            )),
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "\\n换行")
                            )),
                            _cE("view", _uM("class" to "text-box"), _uA(
                                _cE("text", null, "\n 换行"),
                                _cE("text", null, "\\n 换行"),
                                _cE("text", null, "\\\n 换行"),
                                _cE("text", null, "\n 换行 \\n 换行 \\\n 换行 \\\\n 换行 \\\\\n 换行"),
                                _cE("text", null, "\n\n连续换行\n\n连续换行\n\n连续换行")
                            )),
                            _cE("text", _uM("class" to "uni-subtitle-text"), "\\n换行，拍平测试"),
                            _cE("view", _uM("class" to "text-box"), _uA(
                                _cE("text", _uM("flatten" to ""), "\n 换行"),
                                _cE("text", _uM("flatten" to ""), "\\n 换行"),
                                _cE("text", _uM("flatten" to ""), "\\\n 换行"),
                                _cE("text", _uM("flatten" to ""), "\n 换行 \\n 换行 \\\n 换行 \\\\n 换行 \\\\\n 换行"),
                                _cE("text", _uM("flatten" to ""), "\n\n连续换行\n\n连续换行\n\n连续换行")
                            )),
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "selectable属性（鸿蒙蒸汽暂不支持）")
                            )),
                            _cE("view", _uM("class" to "text-box"), _uA(
                                _cE("text", _uM("selectable" to true), _tD(unref(singleLineText)), 1)
                            )),
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "space属性（鸿蒙蒸汽不支持，推荐改用css white-space）"),
                                _cE("text", _uM("class" to "uni-subtitle-text"), "依次为nbsp ensp emsp效果")
                            )),
                            _cE("view", _uM("class" to "text-box"), _uA(
                                _cE("text", _uM("space" to "nbsp"), _tD(unref(singleLineText)), 1),
                                _cE("text", _uM("space" to "ensp"), _tD(unref(singleLineText)), 1),
                                _cE("text", _uM("space" to "emsp"), _tD(unref(singleLineText)), 1)
                            )),
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "decode属性（鸿蒙蒸汽暂不支持）"),
                                _cE("text", _uM("class" to "uni-subtitle-text"), "依次为lt gt amp apos nbsp ensp emsp效果")
                            )),
                            _cE("view", _uM("class" to "text-box"), _uA(
                                _cE("text", _uM("decode" to true), _tD(unref(decodeStr)), 1),
                                _cE("text", _uM("decode" to true), "uni-app x，终极跨平台方案"),
                                _cE("text", _uM("decode" to true), "uni-app x，终极跨平台方案"),
                                _cE("text", _uM("decode" to true), "uni-app x，终极跨平台方案")
                            )),
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "嵌套1")
                            )),
                            _cE("view", _uM("class" to "text-box"), _uA(
                                _cE("text", _uM("onClick" to nestedText1Tap), _uA(
                                    "一级节点黑色 ",
                                    _cE("text", _uM("style" to _nS(_uM("color" to "red", "background-color" to "yellow")), "onClick" to nestedText2Tap), _uA(
                                        "二级节点红色且背景色黄色 ",
                                        _cE("text", _uM("style" to _nS(_uM("text-decoration-line" to "underline", "color" to "blue")), "onClick" to nestedText3Tap), "App三级节点不继承二级的颜色", 4)
                                    ), 4),
                                    _cE("text", _uM("style" to _nS(_uM("font-size" to "50px"))), "二级节点大字体", 4)
                                ))
                            )),
                            _cE("text", _uM("class" to "uni-subtitle-text"), "嵌套1，拍平测试"),
                            _cE("view", _uM("class" to "text-box"), _uA(
                                _cE("text", _uM("flatten" to "", "onClick" to nestedText1Tap), _uA(
                                    "一级节点黑色 ",
                                    _cE("text", _uM("style" to _nS(_uM("color" to "red", "background-color" to "yellow")), "onClick" to nestedText2Tap), _uA(
                                        "二级节点红色且背景色黄色 ",
                                        _cE("text", _uM("style" to _nS(_uM("text-decoration-line" to "underline", "color" to "blue")), "onClick" to nestedText3Tap), "App三级节点不继承二级的颜色", 4)
                                    ), 4),
                                    _cE("text", _uM("style" to _nS(_uM("font-size" to "50px"))), "二级节点大字体", 4)
                                ))
                            )),
                            _cE("text", _uM("class" to "uni-subtitle-text"), "动态text嵌套"),
                            _cE("text", null, _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(unref(textArr), fun(n, __key, __index, _cached): Any {
                                    return _cE("text", _uM("key" to n), _tD(n), 1)
                                }
                                ), 128)
                            )),
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "空嵌套测试")
                            )),
                            _cE("view", _uM("class" to "text-box"), _uA(
                                _cE("text", null, _uA(
                                    _cE("text", null, _uA(
                                        " 文字应居中显示",
                                        _cE("text")
                                    ))
                                ))
                            )),
                            _cE("text", _uM("class" to "uni-subtitle-text"), "空嵌套测试（根拍平）"),
                            _cE("view", _uM("class" to "text-box"), _uA(
                                _cE("text", _uM("flatten" to ""), _uA(
                                    _cE("text", null, _uA(
                                        " 文字应居中显示",
                                        _cE("text")
                                    ))
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "含换行符的多行文本(3行)，但不自动换行，可横向滚动")
                            )),
                            _cE("scroll-view", _uM("class" to "text-container", "direction" to "horizontal"), _uA(
                                _cE("text", _uM("style" to _nS(_uM("white-space" to "nowrap", "align-self" to "flex-start"))), "HBuilderX，轻巧、极速，极客编辑器；\nuni-app x，是下一代 uni-app，是一个跨平台应用开发引擎。uni-app x 是一个庞大的工程，它包括uts语言、uvue渲染引擎、uni的组件和API、以及扩展机制。\nuts是一门类ts的、跨平台的、新语言。", 4)
                            )),
                            _cE("text", _uM("class" to "uni-subtitle-text"), "含换行符的多行文本(3行)，但不自动换行，可横向滚动【拍平测试】"),
                            _cE("scroll-view", _uM("class" to "text-container", "direction" to "horizontal"), _uA(
                                _cE("text", _uM("flatten" to "", "style" to _nS(_uM("white-space" to "nowrap", "align-self" to "flex-start"))), "HBuilderX，轻巧、极速，极客编辑器；\nuni-app x，是下一代 uni-app，是一个跨平台应用开发引擎。uni-app x 是一个庞大的工程，它包括uts语言、uvue渲染引擎、uni的组件和API、以及扩展机制。\nuts是一门类ts的、跨平台的、新语言。", 4)
                            )),
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "点击事件测试")
                            )),
                            _cE("view", _uM("class" to "text-box", "style" to _nS(_uM("flex-direction" to "row"))), _uA(
                                _cE("text", _uM("class" to "text-icon", "style" to _nS(_uM("background-color" to "aqua")), "onClick" to iconTap), _tD(String.fromCharCode(parseInt("E650", 16))), 5),
                                _cE("text", _uM("class" to "text-icon", "style" to _nS(_uM("background-color" to "yellow")), "onClick" to iconTap2), _tD(String.fromCharCode(parseInt("EA08", 16))), 5)
                            ), 4),
                            if (isTrue(unref(data).autoTest)) {
                                _cE("view", _uM("key" to 0), _uA(
                                    _cE("view", _uM("class" to "uni-row"), _uA(
                                        _cE("text", _uM("id" to "empty-text"))
                                    )),
                                    _cE("view", _uM("class" to "uni-row"), _uA(
                                        _cE("text", _uM("id" to "empty-text2"), _tD(unref(data).emptyText), 1)
                                    )),
                                    _cE("view", _uM("class" to "uni-row"), _uA(
                                        _cE("text", _uM("id" to "empty-text3", "style" to _nS(_uM("width" to "100px", "height" to "100px"))), _tD(unref(data).emptyText), 5)
                                    )),
                                    _cE("text", null, _uA(
                                        "一级节点文本 ",
                                        _cE("text", null, _uA(
                                            "二级节点文本 ",
                                            _cE("text", _uM("id" to "nested-text"), _tD(unref(data).nestedText), 1)
                                        ))
                                    )),
                                    _cE("text", _uM("id" to "height-text", "style" to _nS(_uM("height" to "50px"))), _tD(unref(data).heightText), 5),
                                    _cE("text", _uM("style" to _nS(_uM("position" to "fixed")), "id" to "nested-text2", "onClick" to nestedText1TapForTest), _uA(
                                        "1 ",
                                        _cE("text", _uM("onClick" to nestedText2TapForTest), _uA(
                                            "2 ",
                                            _cE("text", null, "3")
                                        ))
                                    ), 4)
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                        ))
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
                return _uM("text-box" to _pS(_uM("marginBottom" to 20, "paddingTop" to 20, "paddingRight" to 0, "paddingBottom" to 20, "paddingLeft" to 0, "backgroundColor" to "#ffffff", "justifyContent" to "center", "alignItems" to "center")), "text-container" to _pS(_uM("width" to "100%", "backgroundColor" to "#ffffff", "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10)), "text" to _pS(_uM("fontSize" to 15, "color" to "#353535", "lineHeight" to "27px", "textAlign" to "center")), "text-icon" to _pS(_uM("fontFamily" to "uni-icon", "fontSize" to 100)), "text-hover-main" to _pS(_uM("paddingTop" to 5, "paddingRight" to 0, "paddingBottom" to 5, "paddingLeft" to 0, "flexDirection" to "row", "justifyContent" to "center", "backgroundColor" to "#ffffff")), "is-parent-hover" to _pS(_uM("backgroundColor" to "#aa0000")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
