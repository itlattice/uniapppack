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
import io.dcloud.uniapp.extapi.setClipboardData as uni_setClipboardData
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesTemplateAiChatRichTextMsg : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var nodes: UTSArray<RichNode> by `$props`
    open var inlineClassName: String? by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesTemplateAiChatRichTextMsg) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesTemplateAiChatRichTextMsg
            val _cache = __ins.renderCache
            val props = __props
            val nodes = computed(fun(): UTSArray<RichNode> {
                return props.nodes ?: _uA()
            }
            )
            val inlineClassName = computed(fun(): String {
                return props.inlineClassName ?: ""
            }
            )
            fun isTextNodeType(node: Any): Boolean {
                if (UTSAndroid.`typeof`(node) === "string") {
                    return false
                }
                try {
                    val tn = node as TextNode
                    return tn.type == "text" && (tn.text != null)
                }
                 catch (e: Throwable) {
                    return false
                }
            }
            fun isElementNodeType(node: Any): Boolean {
                if (UTSAndroid.`typeof`(node) === "string") {
                    return false
                }
                try {
                    val en = node as ElementNode
                    return en.name != null
                }
                 catch (e: Throwable) {
                    return false
                }
            }
            fun isTextNode(node: Any): Boolean {
                if (UTSAndroid.`typeof`(node) === "string") {
                    return true
                }
                return isTextNodeType(node)
            }
            fun getText(node: Any): String {
                if (UTSAndroid.`typeof`(node) === "string") {
                    return node as String
                }
                if (isTextNodeType(node)) {
                    val tn = node as TextNode
                    return tn.text ?: ""
                }
                return ""
            }
            fun isBr(node: Any): Boolean {
                if (UTSAndroid.`typeof`(node) === "string") {
                    return false
                }
                if (isElementNodeType(node)) {
                    val en = node as ElementNode
                    return en.name == "br"
                }
                return false
            }
            fun getName(node: Any): String {
                if (UTSAndroid.`typeof`(node) === "string") {
                    return ""
                }
                if (isTextNodeType(node)) {
                    return ""
                }
                if (isElementNodeType(node)) {
                    val en = node as ElementNode
                    return en.name ?: ""
                }
                return ""
            }
            fun isUl(node: Any): Boolean {
                return getName(node) == "ul"
            }
            fun isOl(node: Any): Boolean {
                return getName(node) == "ol"
            }
            fun isLink(node: Any): Boolean {
                return getName(node) == "a"
            }
            fun isCode(node: Any): Boolean {
                return getName(node) == "code"
            }
            fun getInlineTagClass(node: Any): String {
                val name = getName(node)
                if (name == "strong" || name == "b") {
                    return "rt-strong"
                }
                if (name == "i" || name == "em") {
                    return "rt-italic"
                }
                if (name == "u") {
                    return "rt-underline"
                }
                if (name == "del" || name == "s" || name == "strike") {
                    return "rt-line-through"
                }
                return ""
            }
            fun getHref(node: Any): String {
                if (UTSAndroid.`typeof`(node) === "string") {
                    return ""
                }
                if (isElementNodeType(node)) {
                    val en = node as ElementNode
                    val attrs = en.attrs
                    if (attrs == null) {
                        return ""
                    }
                    return attrs.get("href") ?: ""
                }
                return ""
            }
            fun onLinkClick(node: Any) {
                val href = getHref(node)
                if (href.length == 0) {
                    return
                }
                uni_setClipboardData(SetClipboardDataOptions(data = href, success = fun(_){
                    uni_showToast(ShowToastOptions(title = "复制成功", icon = "none"))
                }
                , fail = fun(_){
                    uni_showToast(ShowToastOptions(title = "复制失败", icon = "none"))
                }
                ))
            }
            val blockTags = _uA(
                "p",
                "div",
                "h1",
                "h2",
                "h3",
                "h4",
                "h5",
                "h6",
                "li",
                "blockquote",
                "pre"
            )
            fun getBlockTagClass(node: Any): String {
                val name = getName(node)
                if (name == "h1") {
                    return "rt-h1"
                }
                if (name == "h2") {
                    return "rt-h2"
                }
                if (name == "h3") {
                    return "rt-h3"
                }
                if (name == "h4") {
                    return "rt-h4"
                }
                if (name == "h5") {
                    return "rt-h5"
                }
                if (name == "h6") {
                    return "rt-h6"
                }
                if (name == "blockquote") {
                    return "rt-blockquote"
                }
                return ""
            }
            fun getBlockInlineClass(node: Any): String {
                val name = getName(node)
                if (name == "h1") {
                    return "rt-h1-inline"
                }
                if (name == "h2") {
                    return "rt-h2-inline"
                }
                if (name == "h3") {
                    return "rt-h3-inline"
                }
                if (name == "h4") {
                    return "rt-h4-inline"
                }
                if (name == "h5") {
                    return "rt-h5-inline"
                }
                if (name == "h6") {
                    return "rt-h6-inline"
                }
                if (name == "blockquote") {
                    return "rt-blockquote-inline"
                }
                return ""
            }
            fun getInlineWrapInlineClass(node: Any): String {
                val name = getName(node)
                if (name == "strong" || name == "b") {
                    return "rt-strong-inline"
                }
                if (name == "i" || name == "em") {
                    return "rt-italic-inline"
                }
                if (name == "u") {
                    return "rt-underline-inline"
                }
                if (name == "del" || name == "s" || name == "strike") {
                    return "rt-line-through-inline"
                }
                return ""
            }
            fun isBlockTag(node: Any): Boolean {
                val name = getName(node)
                return blockTags.indexOf(name) >= 0
            }
            fun getNodeStyle(node: Any): String {
                if (UTSAndroid.`typeof`(node) === "string") {
                    return ""
                }
                if (isElementNodeType(node)) {
                    val en = node as ElementNode
                    val attrs = en.attrs
                    if (attrs == null) {
                        return ""
                    }
                    return attrs.get("style") ?: ""
                }
                return ""
            }
            fun hasChildren(node: Any): Boolean {
                if (UTSAndroid.`typeof`(node) === "string") {
                    return false
                }
                if (isElementNodeType(node)) {
                    val en = node as ElementNode
                    val children = en.children
                    if (children == null) {
                        return false
                    }
                    return children.length > 0
                }
                return false
            }
            fun getChildren(node: Any): RichNodes {
                val empty: UTSArray<RichNode> = _uA<RichNode>()
                if (UTSAndroid.`typeof`(node) === "string") {
                    return empty
                }
                if (isElementNodeType(node)) {
                    val en = node as ElementNode
                    val children = en.children
                    return children ?: empty
                }
                return empty
            }
            return fun(): Any? {
                val _component_rich_text_msg = resolveComponent("rich-text-msg", true)
                return _cE("view", _uM("class" to "rich-text-msg-root"), _uA(
                    _cE(Fragment, null, RenderHelpers.renderList(unref(nodes), fun(node, i, __index, _cached): Any {
                        return _cE(Fragment, _uM("key" to i), _uA(
                            if (isTrue(isTextNode(node))) {
                                _cE("text", _uM("key" to 0, "class" to _nC("rich-text-inline" + (if (unref(inlineClassName).length > 0) {
                                    " " + unref(inlineClassName)
                                } else {
                                    ""
                                }))), _tD(getText(node)), 3)
                            } else {
                                if (isTrue(isBr(node))) {
                                    _cE("view", _uM("key" to 1, "class" to "rich-text-br"))
                                } else {
                                    if (isTrue(isUl(node))) {
                                        _cE("view", _uM("key" to 2, "style" to _nS(getNodeStyle(node)), "class" to "rich-text-ul"), _uA(
                                            _cE(Fragment, null, RenderHelpers.renderList(getChildren(node), fun(li, liIdx, __index, _cached): Any {
                                                return _cE("view", _uM("key" to liIdx, "class" to "rich-text-li"), _uA(
                                                    _cE("text", _uM("class" to "rich-text-li-marker"), "• "),
                                                    _cV(_component_rich_text_msg, _uM("nodes" to getChildren(li), "inline-class-name" to unref(inlineClassName)), null, 8, _uA(
                                                        "nodes",
                                                        "inline-class-name"
                                                    ))
                                                ))
                                            }), 128)
                                        ), 4)
                                    } else {
                                        if (isTrue(isOl(node))) {
                                            _cE("view", _uM("key" to 3, "style" to _nS(getNodeStyle(node)), "class" to "rich-text-ol"), _uA(
                                                _cE(Fragment, null, RenderHelpers.renderList(getChildren(node), fun(li, liIdx, __index, _cached): Any {
                                                    return _cE("view", _uM("key" to liIdx, "class" to "rich-text-li"), _uA(
                                                        _cE("text", _uM("class" to "rich-text-li-marker"), _tD(liIdx + 1) + ". ", 1),
                                                        _cV(_component_rich_text_msg, _uM("nodes" to getChildren(li), "inline-class-name" to unref(inlineClassName)), null, 8, _uA(
                                                            "nodes",
                                                            "inline-class-name"
                                                        ))
                                                    ))
                                                }), 128)
                                            ), 4)
                                        } else {
                                            if (isTrue(isBlockTag(node))) {
                                                _cE("view", _uM("key" to 4, "style" to _nS(getNodeStyle(node)), "class" to _nC(_uA(
                                                    "rich-text-block",
                                                    getBlockTagClass(node)
                                                ))), _uA(
                                                    if (isTrue(hasChildren(node))) {
                                                        _cV(_component_rich_text_msg, _uM("key" to 0, "nodes" to getChildren(node), "inline-class-name" to getBlockInlineClass(node)), null, 8, _uA(
                                                            "nodes",
                                                            "inline-class-name"
                                                        ))
                                                    } else {
                                                        _cC("v-if", true)
                                                    }
                                                ), 6)
                                            } else {
                                                if (isTrue(isLink(node))) {
                                                    _cE("view", _uM("key" to 5, "style" to _nS(getNodeStyle(node)), "class" to "rich-text-inline-wrap rich-text-link", "onClick" to withModifiers(fun(){
                                                        onLinkClick(node)
                                                    }, _uA(
                                                        "stop"
                                                    ))), _uA(
                                                        if (isTrue(hasChildren(node))) {
                                                            _cV(_component_rich_text_msg, _uM("key" to 0, "nodes" to getChildren(node), "inline-class-name" to "rich-text-link-inline"), null, 8, _uA(
                                                                "nodes"
                                                            ))
                                                        } else {
                                                            _cC("v-if", true)
                                                        }
                                                    ), 12, _uA(
                                                        "onClick"
                                                    ))
                                                } else {
                                                    if (isTrue(isCode(node))) {
                                                        _cE("view", _uM("key" to 6, "style" to _nS(getNodeStyle(node)), "class" to "rich-text-inline-wrap rich-text-code"), _uA(
                                                            if (isTrue(hasChildren(node))) {
                                                                _cV(_component_rich_text_msg, _uM("key" to 0, "nodes" to getChildren(node), "inline-class-name" to "rich-text-code-inline"), null, 8, _uA(
                                                                    "nodes"
                                                                ))
                                                            } else {
                                                                _cC("v-if", true)
                                                            }
                                                        ), 4)
                                                    } else {
                                                        _cE("view", _uM("key" to 7, "style" to _nS(getNodeStyle(node)), "class" to _nC(_uA(
                                                            "rich-text-inline-wrap",
                                                            getInlineTagClass(node)
                                                        ))), _uA(
                                                            if (isTrue(hasChildren(node))) {
                                                                _cV(_component_rich_text_msg, _uM("key" to 0, "nodes" to getChildren(node), "inline-class-name" to getInlineWrapInlineClass(node)), null, 8, _uA(
                                                                    "nodes",
                                                                    "inline-class-name"
                                                                ))
                                                            } else {
                                                                _cC("v-if", true)
                                                            }
                                                        ), 6)
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        ), 64)
                    }
                    ), 128)
                ))
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("rich-text-msg-root" to _pS(_uM("flexDirection" to "row", "flexWrap" to "wrap", "alignItems" to "flex-start", "maxWidth" to "540rpx", "minWidth" to 0, "overflow" to "hidden")), "rich-text-inline" to _pS(_uM("fontSize" to 13, "color" to "#666666", "maxWidth" to "540rpx", "flexShrink" to 1)), "rich-text-br" to _pS(_uM("width" to "100%", "height" to 6)), "rich-text-block" to _pS(_uM("flexDirection" to "column", "width" to "100%")), "rt-h1-inline" to _pS(_uM("fontSize" to 18, "fontWeight" to "bold", "color" to "#333333")), "rt-h2-inline" to _pS(_uM("fontSize" to 16, "fontWeight" to "bold", "color" to "#333333")), "rt-h3-inline" to _pS(_uM("fontSize" to 15, "fontWeight" to "bold", "color" to "#444444")), "rt-h4-inline" to _pS(_uM("fontSize" to 14, "fontWeight" to "bold", "color" to "#444444")), "rt-h5-inline" to _pS(_uM("fontSize" to 13, "fontWeight" to "bold", "color" to "#555555")), "rt-h6-inline" to _pS(_uM("fontSize" to 12, "fontWeight" to "bold", "color" to "#555555")), "rt-blockquote" to _pS(_uM("borderLeftWidth" to 4, "borderLeftStyle" to "solid", "borderLeftColor" to "#cccccc", "paddingLeft" to 8, "marginTop" to 4, "marginRight" to 0, "marginBottom" to 4, "marginLeft" to 0)), "rt-blockquote-inline" to _pS(_uM("color" to "#555555", "fontStyle" to "italic")), "rich-text-ul" to _pS(_uM("flexDirection" to "column", "width" to "100%", "paddingLeft" to 8)), "rich-text-ol" to _pS(_uM("flexDirection" to "column", "width" to "100%", "paddingLeft" to 8)), "rich-text-li" to _pS(_uM("flexDirection" to "row", "flexWrap" to "wrap", "marginBottom" to 2)), "rich-text-li-marker" to _pS(_uM("fontSize" to 13, "lineHeight" to "20px", "marginRight" to 4, "color" to "#999999")), "rich-text-inline-wrap" to _pS(_uM("flexDirection" to "row", "flexWrap" to "wrap", "flexShrink" to 1, "maxWidth" to "540rpx", "minWidth" to 0)), "rich-text-link-inline" to _pS(_uM("color" to "#007aff")), "rt-strong-inline" to _pS(_uM("fontWeight" to "bold")), "rt-italic-inline" to _pS(_uM("fontStyle" to "italic")), "rich-text-code" to _pS(_uM("backgroundColor" to "#333333", "paddingTop" to 2, "paddingRight" to 6, "paddingBottom" to 2, "paddingLeft" to 6, "borderTopLeftRadius" to 4, "borderTopRightRadius" to 4, "borderBottomRightRadius" to 4, "borderBottomLeftRadius" to 4, "flexShrink" to 1, "marginLeft" to 4)), "rich-text-code-inline" to _pS(_uM("color" to "#e0e0e0")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("nodes" to _uM("type" to "Array", "required" to true), "inlineClassName" to _uM("type" to "String", "required" to false)))
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
