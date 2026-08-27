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
open class GenPagesComponentRichTextRichText : BasePage {
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
    open var data: DataType__19
        get() {
            return unref(this.`$exposed`["data"]) as DataType__19
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var changeText: () -> Unit
        get() {
            return unref(this.`$exposed`["changeText"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "changeText", value)
        }
    open var changeFontSize: () -> Unit
        get() {
            return unref(this.`$exposed`["changeFontSize"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "changeFontSize", value)
        }
    open var changeLineHeight: () -> Unit
        get() {
            return unref(this.`$exposed`["changeLineHeight"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "changeLineHeight", value)
        }
    open var changeFontFamily: () -> Unit
        get() {
            return unref(this.`$exposed`["changeFontFamily"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "changeFontFamily", value)
        }
    open var getBoundingClientRectForTest: () -> DOMRect
        get() {
            return unref(this.`$exposed`["getBoundingClientRectForTest"]) as () -> DOMRect
        }
        set(value) {
            setRefValue(this.`$exposed`, "getBoundingClientRectForTest", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentRichTextRichText, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentRichTextRichText
            val _cache = __ins.renderCache
            val fontSizeList = _uA(
                "默认",
                "12px",
                "16px",
                "20px",
                "24px",
                "32px"
            ) as UTSArray<String>
            val lineHeightList = _uA(
                "默认",
                "1",
                "1.5",
                "2",
                "2.5",
                "3"
            ) as UTSArray<String>
            val fontFamilyList = _uA(
                "默认",
                "serif",
                "sans-serif",
                "monospace",
                "cursive"
            ) as UTSArray<String>
            val data = reactive(DataType__19(text = "<span>hello uni-app x!</span><br/><span>uni-app x，终极跨平台方案</span>", richTextHeight = 0, richTextElement = null, autoTest = false, testNodes = "<img src=\"https://qiniu-web-assets.dcloud.net.cn/unidoc/zh/uni@2x.png\"></img>", isItemClickTrigger = false, richTextStr = false, richTextStyle = "border: 1px; border-style: solid; border-color: red;", currentFontSize = "默认", currentLineHeight = "默认", currentFontFamily = "默认", fontSizeIndex = 0, lineHeightIndex = 0, fontFamilyIndex = 0))
            val updateRichTextHeight = fun(){
                if (data.richTextElement != null) {
                    data.richTextElement!!.getBoundingClientRectAsync()!!.then(fun(elRect: DOMRect){
                        data.richTextHeight = elRect.height
                        console.log("richTextHeight:", data.richTextHeight)
                    }
                    )
                }
            }
            onReady(fun(){
                data.richTextElement = uni_getElementById("rich-text") as UniElement
                console.log("onReady  加载完成，richTextElement= ", data.richTextElement?.tagName)
                setTimeout(fun(){
                    updateRichTextHeight()
                }
                , 2500)
            }
            )
            val changeText = fun(){
                if (data.text === "<span>hello uni-app x!</span><br/><span>uni-app x，终极跨平台方案</span>") {
                    data.text = "<h1>hello uni-app x!</h1><br/><h2>uni-app x，终极跨平台方案</h2>"
                } else {
                    data.text = "<span>hello uni-app x!</span><br/><span>uni-app x，终极跨平台方案</span>"
                }
                nextTick(fun(){
                    setTimeout(fun(){
                        console.log("修改文本内容: ", data.text)
                        updateRichTextHeight()
                    }
                    , 1000)
                }
                )
            }
            val updateRichTextStyle = fun(){
                var style = "border: 1px; border-style: solid; border-color: red;"
                if (data.currentFontSize != "默认") {
                    style += " font-size: " + data.currentFontSize + ";"
                }
                if (data.currentLineHeight != "默认") {
                    style += " line-height: " + data.currentLineHeight + ";"
                }
                if (data.currentFontFamily != "默认") {
                    style += " font-family: " + data.currentFontFamily + ";"
                }
                data.richTextStyle = style
                console.log("更新样式:", data.richTextStyle)
            }
            val changeFontSize = fun(){
                data.fontSizeIndex = (data.fontSizeIndex + 1) % fontSizeList.length
                data.currentFontSize = fontSizeList[data.fontSizeIndex]
                console.log("切换 font-size:", data.currentFontSize)
                updateRichTextStyle()
            }
            val changeLineHeight = fun(){
                data.lineHeightIndex = (data.lineHeightIndex + 1) % lineHeightList.length
                data.currentLineHeight = lineHeightList[data.lineHeightIndex]
                console.log("切换 line-height:", data.currentLineHeight)
                updateRichTextStyle()
            }
            val changeFontFamily = fun(){
                data.fontFamilyIndex = (data.fontFamilyIndex + 1) % fontFamilyList.length
                data.currentFontFamily = fontFamilyList[data.fontFamilyIndex]
                console.log("切换 font-family:", data.currentFontFamily)
                updateRichTextStyle()
            }
            val itemClickForTest = fun(_: UniRichTextItemClickEvent){
                data.isItemClickTrigger = true
            }
            val getBoundingClientRectForTest = fun(): DOMRect {
                return uni_getElementById("test-rich-text")?.getBoundingClientRect()!!
            }
            val richTextParentClick = fun(){
                data.richTextStr = true
            }
            __expose(_uM("data" to data, "changeText" to changeText, "changeFontSize" to changeFontSize, "changeLineHeight" to changeLineHeight, "changeFontFamily" to changeFontFamily, "getBoundingClientRectForTest" to getBoundingClientRectForTest))
            return fun(): Any? {
                val _component_navigator = resolveComponent("navigator")
                val _component_rich_text = resolveComponent("rich-text")
                return _cE(Fragment, null, _uA(
                    _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                        _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt"), _uA(
                            _cV(_component_navigator, _uM("url" to "/pages/component/rich-text/rich-text-tags", "class" to "uni-btn-v"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("button", null, "rich-text渲染单个HTML标签示例")
                                )
                            }
                            ), "_" to 1)),
                            _cV(_component_navigator, _uM("url" to "/pages/component/rich-text/rich-text-complex", "class" to "uni-btn-v"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("button", null, "rich-text渲染复杂HTML示例")
                                )
                            }
                            ), "_" to 1)),
                            _cV(_component_navigator, _uM("url" to "/pages/template/long-rich-text/long-rich-text", "class" to "uni-btn-v"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("button", _uM("class" to "uni-btn"), "组件性能测试")
                                )
                            }
                            ), "_" to 1)),
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("button", _uM("type" to "default", "onClick" to changeText), "修改文本内容")
                            )),
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("button", _uM("type" to "default", "onClick" to changeFontSize), "切换 font-size (" + _tD(unref(data).currentFontSize) + ")", 1)
                            )),
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("button", _uM("type" to "default", "onClick" to changeLineHeight), "切换 line-height (" + _tD(unref(data).currentLineHeight) + ")", 1)
                            )),
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("button", _uM("type" to "default", "onClick" to changeFontFamily), "切换 font-family (" + _tD(unref(data).currentFontFamily) + ")", 1)
                            )),
                            _cE("view", _uM("class" to "text-box", "id" to "rich-text-parent", "onClick" to richTextParentClick), _uA(
                                _cV(_component_rich_text, _uM("id" to "rich-text", "style" to _nS(unref(data).richTextStyle), "nodes" to unref(data).text, "mode" to "native"), null, 8, _uA(
                                    "style",
                                    "nodes"
                                )),
                                _cE("view", null, _uA(
                                    _cE("text", null, "rich-text-parent"),
                                    _cE("text", _uM("id" to "rich-text-str"), _tD(unref(data).richTextStr), 1)
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-title"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "selectable")
                            )),
                            _cE("view", _uM("class" to "text-box2"), _uA(
                                _cV(_component_rich_text, _uM("style" to _nS(_uM("height" to "80px")), "selectable" to true, "nodes" to unref(data).text), null, 8, _uA(
                                    "style",
                                    "nodes"
                                ))
                            ))
                        ))
                    ), 4),
                    if (isTrue(unref(data).autoTest)) {
                        _cV(_component_rich_text, _uM("key" to 0, "id" to "test-rich-text", "nodes" to unref(data).testNodes, "selectable" to true, "onItemclick" to itemClickForTest, "style" to _nS(_uM("position" to "fixed", "width" to "100px", "height" to "100px"))), null, 8, _uA(
                            "nodes",
                            "style"
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                ), 64)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("text-box" to _pS(_uM("paddingTop" to 20, "paddingRight" to 0, "paddingBottom" to 20, "paddingLeft" to 0, "backgroundColor" to "#FFFFFF")), "text-box2" to _pS(_uM("top" to 20, "backgroundColor" to "#FFFFFF")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
