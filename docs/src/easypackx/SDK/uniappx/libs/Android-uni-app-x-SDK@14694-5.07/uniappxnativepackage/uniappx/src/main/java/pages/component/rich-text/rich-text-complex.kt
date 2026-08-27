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
import io.dcloud.uniapp.extapi.showModal as uni_showModal
open class GenPagesComponentRichTextRichTextComplex : BasePage {
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
    open var data: DataType__20
        get() {
            return unref(this.`$exposed`["data"]) as DataType__20
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentRichTextRichTextComplex, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentRichTextRichTextComplex
            val _cache = __ins.renderCache
            val htmlString = ref("<p><a href=\"https://www.dcloud.io/hbuilderx.html\">HBuilderX</a><br/><img src=\"https://qiniu-web-assets.dcloud.net.cn/unidoc/zh/uni@2x.png\"></img><h1>HBuilderX，轻巧、极速，极客编辑器</h1><p style=\"color:red;\"><small>HBuilderX，轻巧、极速，极客编辑器 </small><big>HBuilderX，轻巧、极速，极客编辑器</big><strong>HBuilderX，轻巧、极速，极客编辑器</strong><i>HBuilderX，轻巧、极速，极客编辑器 </i><u>HBuilderX，轻巧、极速，极客编辑器</u><del>HBuilderX，轻巧、极速，极客编辑器</del></p><h2>uni-app x，终极跨平台方案</h2>、<p style=\"background-color: yellow;\"><small>uni-app x，终极跨平台方案 </small><big>uni-app x，终极跨平台方案</big><strong>uni-appx，终极跨平台方案 </strong><i>uni-app x，终极跨平台方案 </i><u>uni-app x，终极跨平台方案 </u><del>uni-appx，终极跨平台方案</del></p><h3>uniCloud，js serverless云服务</h3><p style=\"text-decoration: line-through;\"><small>uniCloud，js serverless云服务 </small><big>uniCloud，jsserverless云服务</big><strong>uniCloud，js serverless云服务 </strong><i>uniCloud，js serverless云服务 </i><u>uniCloud，jsserverless云服务</u><del>uniCloud，js serverless云服务</del></p><h4>uts，大一统语言</h4><p style=\"text-align: center;\"><small>uts，大一统语言 </small><big>uts，大一统语言 </big><strong>uts，大一统语言</strong><i>uts，大一统语言</i><u>uts，大一统语言 </u><del>uts，大一统语言</del></p><h5>uniMPSdk，让你的App具备小程序能力</h5><h6>uni-admin，开源、现成的全端管理后台</h6><ul><li style=\"color: red; text-align: left;\">uni-app x，终极跨平台方案</li><li style=\"color: green; text-align: center;\">uni-app x，终极跨平台方案</li><li style=\"color: blue; text-align: right;\">uni-app x，终极跨平台方案</li></ul><a href=\"https://uniapp.dcloud.net.cn\">uni-app</a><br/><img src=\"https://qiniu-web-assets.dcloud.net.cn/unidoc/zh/uni@2x.png\"></img></p>")
            val modeItems = _uA(
                "web",
                "native"
            )
            val modeItemTypes = ref(_uA<ItemType>(ItemType(value = 0, name = "web", checked = true), ItemType(value = 1, name = "native")))
            val data = reactive(DataType__20(mode = "web", imageClicked = false, fViewClicked = false, selfClicked = false))
            fun gen_itemClick_fn(e: UniRichTextItemClickEvent) {
                console.log(JSON.stringify(e.detail))
                var clicktext = ""
                if (e.detail.src != null) {
                    clicktext = "点击了图片，src = " + e.detail.src!!
                    data.imageClicked = true
                } else if (e.detail.href != null) {
                    clicktext = "点击了链接，href = " + e.detail.href!!
                }
                uni_showModal(ShowModalOptions(content = clicktext, showCancel = false))
            }
            val itemClick = ::gen_itemClick_fn
            fun gen_fViewClick_fn(e: String) {
                console.log(e)
                data.fViewClicked = true
            }
            val fViewClick = ::gen_fViewClick_fn
            fun gen_selfClick_fn(e: String) {
                console.log(e)
                data.selfClicked = true
            }
            val selfClick = ::gen_selfClick_fn
            fun gen_onModeChange_fn(value: Number) {
                data.mode = modeItems[value]
            }
            val onModeChange = ::gen_onModeChange_fn
            __expose(_uM("data" to data))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                val _component_page_intro = resolveEasyComponent("page-intro", GenComponentsPageIntroPageIntroClass)
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_rich_text = resolveComponent("rich-text")
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", null, _uA(
                        _cV(_component_page_head, _uM("title" to "rich-text-complex")),
                        _cV(_component_page_intro, _uM("content" to "本页演示 rich-text 渲染复杂 HTML：富文本内容、selectable、itemclick 与 click 事件、父 view 与自身点击区分。")),
                        _cV(_component_enum_data, _uM("title" to "设置mode（仅Android平台支持，默认值为web）", "items" to unref(modeItemTypes), "onChange" to onModeChange), null, 8, _uA(
                            "items"
                        )),
                        _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt", "onClick" to fun(){
                            fViewClick("触发父 view click 事件")
                        }
                        ), _uA(
                            _cV(_component_rich_text, _uM("nodes" to unref(htmlString), "selectable" to true, "onItemclick" to itemClick, "onClick" to fun(){
                                selfClick("触发 richtext click 事件")
                            }
                            , "mode" to unref(data).mode), null, 8, _uA(
                                "nodes",
                                "onClick",
                                "mode"
                            ))
                        ), 8, _uA(
                            "onClick"
                        ))
                    ))
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
