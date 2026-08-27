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
open class GenPagesComponentRichTextRichTextTags : BasePage {
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
    open var modeData: ModeDataType
        get() {
            return unref(this.`$exposed`["modeData"]) as ModeDataType
        }
        set(value) {
            setRefValue(this.`$exposed`, "modeData", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentRichTextRichTextTags, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentRichTextRichTextTags
            val _cache = __ins.renderCache
            val data = ref<UTSArray<TagInfo>>(_uA<TagInfo>(TagInfo(name = "<br/>", html = _uA<UTSJSONObject>(_uO("name" to "br"), _uO("type" to "text", "text" to "hello uni-app x"), _uO("name" to "br"), _uO("type" to "text", "text" to "hello uni-app x"))), TagInfo(name = "<p/>", html = _uA<UTSJSONObject>(_uO("name" to "p", "attrs" to _uO("style" to "text-align: center; text-decoration: line-through;"), "children" to _uA(
                _uO("type" to "text", "text" to "hello uni-app x")
            )), _uO("name" to "p", "attrs" to _uO("style" to "background-color: green; color: red;"), "children" to _uA(
                _uO("type" to "text", "text" to "hello uni-app x")
            )))), TagInfo(name = "<ul/> <li/>", html = _uA<UTSJSONObject>(_uO("name" to "ul", "children" to _uA(
                _uO("name" to "li", "attrs" to _uO("style" to "text-decoration: line-through; text-align: center;"), "children" to _uA(
                    _uO("type" to "text", "text" to "hello uni-app x")
                )),
                _uO("name" to "li", "attrs" to _uO("style" to "color: red; background-color: green; text-align: center;"), "children" to _uA(
                    _uO("type" to "text", "text" to "hello uni-app x")
                ))
            )))), TagInfo(name = "<span/>", html = _uA<UTSJSONObject>(_uO("name" to "span", "attrs" to _uO("style" to "color: red; background-color: green; text-decoration: line-through;"), "children" to _uA(
                _uO("type" to "text", "text" to "hello uni-app x")
            )))), TagInfo(name = "<strong/>", html = _uA<UTSJSONObject>(_uO("name" to "strong", "children" to _uA(
                _uO("type" to "text", "text" to "hello uni-app x")
            )))), TagInfo(name = "<i/>", html = _uA<UTSJSONObject>(_uO("name" to "i", "children" to _uA(
                _uO("type" to "text", "text" to "hello uni-app x")
            )))), TagInfo(name = "<big/>", html = _uA<UTSJSONObject>(_uO("name" to "big", "children" to _uA(
                _uO("type" to "text", "text" to "hello uni-app x")
            )))), TagInfo(name = "<small/>", html = _uA<UTSJSONObject>(_uO("name" to "small", "children" to _uA(
                _uO("type" to "text", "text" to "hello uni-app x")
            )))), TagInfo(name = "<a/>", html = _uA<UTSJSONObject>(_uO("name" to "a", "attrs" to _uO("href" to "https://www.baidu.com"), "children" to _uA(
                _uO("type" to "text", "text" to "百度")
            )))), TagInfo(name = "<u/>", html = _uA<UTSJSONObject>(_uO("name" to "u", "children" to _uA(
                _uO("type" to "text", "text" to "hello uni-app x")
            )))), TagInfo(name = "<del/>", html = _uA<UTSJSONObject>(_uO("name" to "del", "children" to _uA(
                _uO("type" to "text", "text" to "hello uni-app x")
            )))), TagInfo(name = "<h1/> <h2/> <h3/> <h4/> <h5/> <h6/>", html = _uA<UTSJSONObject>(_uO("name" to "h1", "children" to _uA(
                _uO("type" to "text", "text" to "hello uni-app x")
            )), _uO("name" to "h2", "children" to _uA(
                _uO("type" to "text", "text" to "hello uni-app x")
            )), _uO("name" to "h3", "children" to _uA(
                _uO("type" to "text", "text" to "hello uni-app x")
            )), _uO("name" to "h4", "children" to _uA(
                _uO("type" to "text", "text" to "hello uni-app x")
            )), _uO("name" to "h5", "children" to _uA(
                _uO("type" to "text", "text" to "hello uni-app x")
            )), _uO("name" to "h6", "children" to _uA(
                _uO("type" to "text", "text" to "hello uni-app x")
            )))), TagInfo(name = "带 # 内容", html = _uA<UTSJSONObject>(_uO("name" to "span", "attrs" to _uO("style" to "color: #42b983;"), "children" to _uA(
                _uO("type" to "text", "text" to "span 标签 style 中使用 16 进制颜色 # 正常显示")
            )))), TagInfo(name = "<img/>", html = _uA<UTSJSONObject>(_uO("name" to "img", "attrs" to _uO("src" to "https://qiniu-web-assets.dcloud.net.cn/unidoc/zh/uni@2x.png", "width" to "100", "height" to "100")))), TagInfo(name = "超长链接是否换行测试，rich-text组件应该适当位置换行", html = _uA<UTSJSONObject>(_uO("name" to "p", "attrs" to _uO("style" to "font-family: PingFang-SC, PingFang-SC; font-weight: 500; font-size: 28rpx; color: #333333; line-height: 40rpx; letter-spacing: 1px; margin-bottom: 16rpx;"), "children" to _uA(
                _uO("name" to "span", "attrs" to _uO("style" to "font-size:16px"), "children" to _uA(
                    _uO("text" to "uni-app x超长链接换行测试：https://doc.dcloud.net.cn/uni-app-x/testlonglonglonglonglonglonglonglongltlonglonglonglonglonglonglonglonglononglink.com")
                ))
            ))))))
            val modeData = reactive(ModeDataType(mode = "web"))
            val modeItems = ref(_uA(
                "web",
                "native"
            ))
            val modeItemTypes = ref<UTSArray<ItemType>>(_uA<ItemType>(ItemType(value = 0, name = "web", checked = true), ItemType(value = 1, name = "native")))
            fun gen_itemClick_fn(e: UniRichTextItemClickEvent) {
                console.log(JSON.stringify(e.detail))
                var clicktext = ""
                if (e.detail.src != null) {
                    clicktext = "点击了图片，src = " + e.detail.src!!
                } else if (e.detail.href != null) {
                    clicktext = "点击了链接，href = " + e.detail.href!!
                }
                uni_showModal(ShowModalOptions(content = clicktext, showCancel = false))
            }
            val itemClick = ::gen_itemClick_fn
            fun gen_onModeChange_fn(value: Number) {
                modeData.mode = modeItems.value[value]
            }
            val onModeChange = ::gen_onModeChange_fn
            __expose(_uM("modeData" to modeData))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_rich_text = resolveComponent("rich-text")
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cV(_component_page_head, _uM("title" to "单tag测试（web模式时页面中有较多web-view）")),
                    _cV(_component_enum_data, _uM("title" to "设置mode（仅Android和鸿蒙蒸汽模式支持，默认值为web）", "items" to unref(modeItemTypes), "onChange" to onModeChange), null, 8, _uA(
                        "items"
                    )),
                    _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt"), _uA(
                        _cE("view", _uM("class" to "uni-title"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "支持的HTML标签")
                        )),
                        _cE(Fragment, null, RenderHelpers.renderList(unref(data), fun(item, index, __index, _cached): Any {
                            return _cE("view", _uM("class" to "uni-common-mt", "key" to index), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), _tD(item.name), 1),
                                _cE("view", _uM("style" to _nS(_uM("background" to "#FFFFFF"))), _uA(
                                    _cV(_component_rich_text, _uM("nodes" to item.html, "onItemclick" to itemClick, "mode" to unref(modeData).mode), null, 8, _uA(
                                        "nodes",
                                        "mode"
                                    ))
                                ), 4)
                            ))
                        }
                        ), 128)
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
