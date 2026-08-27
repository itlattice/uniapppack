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
import io.dcloud.uniapp.extapi.getSystemInfoSync as uni_getSystemInfoSync
import io.dcloud.uniapp.extapi.hideKeyboard as uni_hideKeyboard
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesTemplateAiChatAiChat : BasePage {
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
    open var autoTest: AutoTest
        get() {
            return unref(this.`$exposed`["autoTest"]) as AutoTest
        }
        set(value) {
            setRefValue(this.`$exposed`, "autoTest", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesTemplateAiChatAiChat, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesTemplateAiChatAiChat
            val _cache = __ins.renderCache
            val messageView = ref<UniElement?>(null)
            val bottom = ref<UniElement?>(null)
            val avatarWidth = ref(38)
            val message = ref("")
            val showBottom = ref(false)
            val load = ref(false)
            val messageList = ref(_uA<MessageItem>())
            val maxKeyboardHeight = ref(0)
            val keyboardIsShow = ref(false)
            val isAndroid = ref(uni_getSystemInfoSync().platform == "android")
            val isUserScrolling = ref(false)
            var scrollEndTimer: Number = -1
            var autoTest = reactive<AutoTest>(AutoTest(done = false, waitNode1 = false, waitNode2 = false, waitNode3 = false, waitNode4 = false, waitNode5 = false))
            val screenWidth = computed(fun(): Number {
                return 1080
            }
            )
            val clearData = fun(){
                if (messageList.value.length >= 40) {
                    messageList.value.splice(39, messageList.value.length - 1)
                }
            }
            val listItemLongPress = fun(index: Number){
                uni_showToast(ShowToastOptions(title = "触发长按:" + index, position = "bottom"))
            }
            val loadData = fun(){
                load.value = true
                setTimeout(fun(){
                    load.value = false
                    var length = messageList.value.length
                    run {
                        var i: Number = 0
                        while(i < 20){
                            var item = MessageItem(id = length + i, avatar = "/static/test-image/logo.png", type = "text", self = true, content = "这是一些占位消息", height = 0)
                            messageList.value.push(item)
                            i++
                        }
                    }
                }
                , 800)
            }
            val getMessage = fun(){
                var idList: UTSArray<Number> = _uA()
                run {
                    var index: Number = 0
                    while(index < 20){
                        var item = MessageItem(id = index, avatar = "/static/test-image/logo.png", type = "text", self = false, content = "这是一条消息" + index, height = 0)
                        messageList.value.push(item)
                        idList.push(item.id)
                        index++
                    }
                }
            }
            fun gen_hideKeyboard_fn() {
                uni_hideKeyboard(null)
                keyboardIsShow.value = false
            }
            val hideKeyboard = ::gen_hideKeyboard_fn
            fun gen_sleep_fn(ms: Number): UTSPromise<Unit> {
                return UTSPromise(fun(resolve, _reject){
                    setTimeout(fun(){
                        return resolve(Unit)
                    }
                    , ms)
                }
                )
            }
            val sleep = ::gen_sleep_fn
            fun gen_onUserScroll_fn() {
                isUserScrolling.value = true
                if (scrollEndTimer >= 0) {
                    clearTimeout(scrollEndTimer)
                    scrollEndTimer = -1
                }
            }
            val onUserScroll = ::gen_onUserScroll_fn
            fun gen_onUserScrollEnd_fn() {
                if (scrollEndTimer >= 0) {
                    clearTimeout(scrollEndTimer)
                }
                scrollEndTimer = setTimeout(fun(){
                    isUserScrolling.value = false
                    scrollEndTimer = -1
                }
                , 600) as Number
            }
            val onUserScrollEnd = ::gen_onUserScrollEnd_fn
            fun gen_waitUntilNotScrolling_fn(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        while(isUserScrolling.value){
                            await(sleep(80))
                        }
                })
            }
            val waitUntilNotScrolling = ::gen_waitUntilNotScrolling_fn
            fun gen_mockSendSuccess_fn(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        await(sleep(250))
                })
            }
            val mockSendSuccess = ::gen_mockSendSuccess_fn
            fun gen_demoStreamRichText_fn(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        var rootTail: UTSArray<RichNode> = _uA<RichNode>()
                        var content: Nodes = rootTail
                        var item = MessageItem(id = Date.now(), avatar = "/static/test-image/logo.png", self = false, type = "rich-text", content = content, height = 0)
                        messageList.value.unshift(item)
                        item = messageList.value[0]
                        await(mockSendSuccess())
                        fun rebuildAndFlush() {
                            content = rootTail.slice() as Nodes
                            item.content = content
                            messageList.value = messageList.value.slice() as UTSArray<MessageItem>
                        }
                        fun typeBlock(tagName: String, text: String, charDelay: Number = 60): UTSPromise<Unit> {
                            return wrapUTSPromise(suspend {
                                    rootTail = rootTail.concat(_uA(
                                        ElementNode(name = tagName, children = _uA(
                                            TextNode(type = "text", text = "")
                                        ) as Nodes)
                                    )) as Nodes
                                    rebuildAndFlush()
                                    run {
                                        var i: Number = 0
                                        while(i < text.length){
                                            await(waitUntilNotScrolling())
                                            val buf = text.substring(0, i + 1)
                                            rootTail = rootTail.slice(0, -1).concat(_uA(
                                                ElementNode(name = tagName, children = _uA(
                                                    TextNode(type = "text", text = buf)
                                                ) as Nodes)
                                            )) as Nodes
                                            rebuildAndFlush()
                                            await(sleep(charDelay))
                                            i++
                                        }
                                    }
                            })
                        }
                        open class SegmentInput (
                            @JsonNotNull
                            open var text: String,
                            open var bold: Boolean? = null,
                            open var i: Boolean? = null,
                            open var code: Boolean? = null,
                            open var href: String? = null,
                        ) : UTSObject()
                        fun typeBlockMixed(tagName: String, segments: UTSArray<SegmentInput>, charDelay: Number = 60): UTSPromise<Unit> {
                            return wrapUTSPromise(suspend {
                                    val emptyNodes: UTSArray<RichNode> = _uA<RichNode>()
                                    rootTail = rootTail.concat(_uA(
                                        ElementNode(name = tagName, children = emptyNodes)
                                    )) as Nodes
                                    rebuildAndFlush()
                                    var children: UTSArray<RichNode> = _uA<RichNode>()
                                    run {
                                        var s: Number = 0
                                        while(s < segments.length){
                                            val seg = segments[s]
                                            run {
                                                var c: Number = 0
                                                while(c < seg.text.length){
                                                    await(waitUntilNotScrolling())
                                                    val buf = seg.text.substring(0, c + 1)
                                                    val tn = TextNode(type = "text", text = buf)
                                                    val inner: Nodes = _uA(
                                                        tn
                                                    ) as Nodes
                                                    var node: UTSUnionTypeObject = tn
                                                    if (seg.href != null) {
                                                        val attrs = Map<String, String>()
                                                        attrs.set("href", seg.href!!)
                                                        node = ElementNode(name = "a", attrs = attrs, children = inner)
                                                    } else if (seg.bold == true) {
                                                        node = ElementNode(name = "strong", children = inner)
                                                    } else if (seg.i == true) {
                                                        node = ElementNode(name = "i", children = inner)
                                                    } else if (seg.code == true) {
                                                        node = ElementNode(name = "code", children = inner)
                                                    }
                                                    val segNodes: Nodes = _uA(
                                                        node
                                                    ) as Nodes
                                                    rootTail = rootTail.slice(0, -1).concat(_uA(
                                                        ElementNode(name = tagName, children = children.concat(segNodes) as Nodes)
                                                    )) as Nodes
                                                    rebuildAndFlush()
                                                    await(sleep(charDelay))
                                                    c++
                                                }
                                            }
                                            val fullTn = TextNode(type = "text", text = seg.text)
                                            val fullInner: Nodes = _uA(
                                                fullTn
                                            ) as Nodes
                                            var fullNode: RichNode = fullTn
                                            if (seg.href != null) {
                                                val attrs = Map<String, String>()
                                                attrs.set("href", seg.href!!)
                                                fullNode = ElementNode(name = "a", attrs = attrs, children = fullInner)
                                            } else if (seg.bold == true) {
                                                fullNode = ElementNode(name = "strong", children = fullInner)
                                            } else if (seg.i == true) {
                                                fullNode = ElementNode(name = "i", children = fullInner)
                                            } else if (seg.code == true) {
                                                fullNode = ElementNode(name = "code", children = fullInner)
                                            }
                                            children = children.concat(_uA(
                                                fullNode
                                            )) as Nodes
                                            rootTail = rootTail.slice(0, -1).concat(_uA(
                                                ElementNode(name = tagName, children = children)
                                            )) as Nodes
                                            rebuildAndFlush()
                                            s++
                                        }
                                    }
                            })
                        }
                        fun typeList(listName: String, items: UTSArray<ListItemInput>, charDelay: Number = 60, itemDelay: Number = 160): UTSPromise<Unit> {
                            return wrapUTSPromise(suspend {
                                    val listIndex = rootTail.length
                                    var listChildren: UTSArray<RichNode> = _uA<RichNode>()
                                    rootTail = rootTail.concat(_uA(
                                        ElementNode(name = listName, children = listChildren)
                                    )) as Nodes
                                    rebuildAndFlush()
                                    run {
                                        var i: Number = 0
                                        while(i < items.length){
                                            await(waitUntilNotScrolling())
                                            val it = items[i]
                                            val emptyChildren: UTSArray<RichNode> = _uA<RichNode>()
                                            var liNode = ElementNode(name = "li", children = emptyChildren)
                                            listChildren = listChildren.concat(_uA(
                                                liNode
                                            )) as Nodes
                                            rootTail = rootTail.slice(0, listIndex).concat(_uA(
                                                ElementNode(name = listName, children = listChildren)
                                            ), rootTail.slice(listIndex + 1)) as Nodes
                                            rebuildAndFlush()
                                            var buf = ""
                                            run {
                                                var c: Number = 0
                                                while(c < it.text.length){
                                                    await(waitUntilNotScrolling())
                                                    buf = buf + it.text.substring(c, c + 1)
                                                    val inner: Nodes = if (it.bold == true) {
                                                        _uA(
                                                            ElementNode(name = "strong", children = _uA(
                                                                TextNode(type = "text", text = buf)
                                                            ) as Nodes)
                                                        ) as Nodes
                                                    } else {
                                                        _uA(
                                                            TextNode(type = "text", text = buf)
                                                        ) as Nodes
                                                    }
                                                    liNode = ElementNode(name = "li", children = inner)
                                                    listChildren = listChildren.slice(0, listChildren.length - 1).concat(_uA(
                                                        liNode
                                                    )) as Nodes
                                                    rootTail = rootTail.slice(0, listIndex).concat(_uA(
                                                        ElementNode(name = listName, children = listChildren)
                                                    ), rootTail.slice(listIndex + 1)) as Nodes
                                                    rebuildAndFlush()
                                                    await(sleep(charDelay))
                                                    c++
                                                }
                                            }
                                            await(sleep(itemDelay))
                                            i++
                                        }
                                    }
                            })
                        }
                        await(typeBlockMixed("p", _uA<SegmentInput>(SegmentInput(text = "完整项目样例请参考 uni-ai x，地址：")), 60))
                        autoTest.waitNode1 = true
                        rootTail = rootTail.concat(_uA(
                            ElementNode(name = "br")
                        )) as Nodes
                        rebuildAndFlush()
                        await(sleep(180))
                        await(typeBlockMixed("p", _uA<SegmentInput>(SegmentInput(text = "https://ext.dcloud.net.cn/plugin?id=23902", href = "https://ext.dcloud.net.cn/plugin?id=23902")), 60))
                        rootTail = rootTail.concat(_uA(
                            ElementNode(name = "br")
                        )) as Nodes
                        rebuildAndFlush()
                        await(sleep(180))
                        await(typeBlock("h1", "大标题", 60))
                        rootTail = rootTail.concat(_uA(
                            ElementNode(name = "br")
                        )) as Nodes
                        rebuildAndFlush()
                        await(sleep(180))
                        autoTest.waitNode2 = true
                        await(typeBlock("h2", "中标题", 60))
                        rootTail = rootTail.concat(_uA(
                            ElementNode(name = "br")
                        )) as Nodes
                        rebuildAndFlush()
                        await(sleep(180))
                        await(typeBlock("h3", "小标题", 60))
                        rebuildAndFlush()
                        await(sleep(220))
                        rootTail = rootTail.concat(_uA(
                            ElementNode(name = "br")
                        )) as Nodes
                        rebuildAndFlush()
                        await(sleep(180))
                        await(typeBlock("p", "这是段落文字。", 60))
                        autoTest.waitNode3 = true
                        await(sleep(220))
                        rootTail = rootTail.concat(_uA(
                            ElementNode(name = "br")
                        )) as Nodes
                        rebuildAndFlush()
                        await(sleep(180))
                        await(typeBlockMixed("p", _uA<SegmentInput>(SegmentInput(text = "这是 "), SegmentInput(text = "加粗", bold = true), SegmentInput(text = " 和 "), SegmentInput(text = "斜体", i = true), SegmentInput(text = " 的示例。")), 60))
                        autoTest.waitNode4 = true
                        await(sleep(220))
                        rootTail = rootTail.concat(_uA(
                            ElementNode(name = "br")
                        )) as Nodes
                        rebuildAndFlush()
                        await(sleep(180))
                        await(typeBlock("p", "无序列表：", 60))
                        await(sleep(180))
                        await(typeList("ul", _uA<ListItemInput>(ListItemInput(text = "苹果"), ListItemInput(text = "香蕉（加粗）", bold = true), ListItemInput(text = "橙子")), 70, 180))
                        autoTest.waitNode5 = true
                        await(sleep(220))
                        rootTail = rootTail.concat(_uA(
                            ElementNode(name = "br")
                        )) as Nodes
                        rebuildAndFlush()
                        await(sleep(180))
                        await(typeBlock("p", "有序列表：", 60))
                        await(sleep(180))
                        await(typeList("ol", _uA<ListItemInput>(ListItemInput(text = "第一步"), ListItemInput(text = "第二步（加粗）", bold = true), ListItemInput(text = "第三步")), 70, 180))
                        await(sleep(220))
                        rootTail = rootTail.concat(_uA(
                            ElementNode(name = "br")
                        )) as Nodes
                        rebuildAndFlush()
                        await(sleep(180))
                        await(typeBlockMixed("p", _uA<SegmentInput>(SegmentInput(text = "链接："), SegmentInput(text = "uni-app 官网", href = "https://uniapp.dcloud.net.cn")), 60))
                        await(sleep(180))
                        await(typeBlockMixed("p", _uA<SegmentInput>(SegmentInput(text = "行内代码 "), SegmentInput(text = "const x = 1", code = true), SegmentInput(text = "。")), 60))
                        await(sleep(180))
                        await(typeBlock("blockquote", "这是一段引用。", 60))
                        autoTest.done = true
                })
            }
            val demoStreamRichText = ::gen_demoStreamRichText_fn
            fun gen_send_fn() {
                val content = message.value.trim()
                if (content.length == 0) {
                    return
                }
                var id = messageList.value.length
                var item = MessageItem(id = id, avatar = "/static/test-image/logo.png", self = true, type = "text", content = content, height = 0)
                messageList.value.unshift(item)
                message.value = ""
                setTimeout(fun(){
                    demoStreamRichText()
                }
                , 1000)
            }
            val send = ::gen_send_fn
            fun gen_onKeyboardheightchange_fn(e: UniInputKeyboardHeightChangeEvent) {
                if (e.detail.height > maxKeyboardHeight.value) {
                    maxKeyboardHeight.value = e.detail.height
                }
                keyboardIsShow.value = e.detail.height > 0
            }
            val onKeyboardheightchange = ::gen_onKeyboardheightchange_fn
            onReady(fun(){
                getMessage()
            }
            )
            __expose(_uM("autoTest" to autoTest))
            return fun(): Any? {
                val _component_loading = resolveComponent("loading")
                return _cE("view", _uM("style" to _nS(_uM("flex" to "1", "background-color" to "#f5f5f5"))), _uA(
                    _cE("scroll-view", _uM("onClick" to hideKeyboard, "onTouchmove" to onUserScroll, "onTouchend" to onUserScrollEnd, "show-scrollbar" to false, "scroll-with-animation" to true, "style" to _nS(_uM("flex" to "1", "padding-bottom" to "10px")), "bounces" to false), _uA(
                        _cE("list-view", _uM("ref_key" to "messageView", "ref" to messageView, "onScrolltoupper" to clearData, "onScrolltolower" to loadData, "scroll-with-animation" to true, "show-scrollbar" to false, "style" to _nS(_uM("flex" to "1", "transform" to "scale(1, -1)"))), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(unref(messageList), fun(item, index, __index, _cached): Any {
                                return _cE("list-item", _uM("onLongpress" to fun(){
                                    listItemLongPress(index)
                                }
                                , "key" to ("listItem" + index), "id" to ("listItem" + item.id), "style" to _nS(_uM("transform" to "scale(1, -1)", "padding" to "10px 12px")), "type" to "0"), _uA(
                                    _cE("view", _uM("class" to _nC(_uA(
                                        "item",
                                        _uM("self" to item.self)
                                    ))), _uA(
                                        _cE("image", _uM("fade-show" to true, "src" to item.avatar, "style" to _nS(_uM("width" to (unref(avatarWidth) + "px"), "height" to (unref(avatarWidth) + "px"), "borderRadius" to (unref(avatarWidth) + "px")))), null, 12, _uA(
                                            "src"
                                        )),
                                        _cE("view", _uM("id" to ("listItemContent" + item.id), "class" to _nC(_uA(
                                            "flex-row content",
                                            _uM("self-content" to item.self)
                                        ))), _uA(
                                            if (item.type == "rich-text") {
                                                _cE("view", _uM("key" to 0, "class" to "content-rich-wrap"), _uA(
                                                    _cV(unref(GenPagesTemplateAiChatRichTextMsgClass), _uM("nodes" to item.content), null, 8, _uA(
                                                        "nodes"
                                                    ))
                                                ))
                                            } else {
                                                _cE("text", _uM("key" to 1, "class" to _nC(_uA(
                                                    "content-text",
                                                    _uM("self-content-text" to item.self)
                                                ))), _tD(item.content), 3)
                                            }
                                        ), 10, _uA(
                                            "id"
                                        )),
                                        _cE("view", _uM("style" to _nS(_uM("flex" to "1"))), null, 4)
                                    ), 2)
                                ), 44, _uA(
                                    "onLongpress",
                                    "id"
                                ))
                            }
                            ), 128),
                            _cE("list-item", _uM("class" to "loading"), _uA(
                                if (isTrue(unref(load))) {
                                    _cV(_component_loading, _uM("key" to 0, "style" to _nS(_uM("border-color" to "#999"))), null, 8, _uA(
                                        "style"
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                            ))
                        ), 36)
                    ), 36),
                    _cE("view", _uM("class" to "input-box"), _uA(
                        _cE("textarea", _uM("class" to "input-el", "modelValue" to unref(message), "onInput" to fun(`$event`: UniInputEvent){
                            trySetRefValue(message, `$event`.detail.value)
                        }
                        , "placeholder" to "发消息体验流式回复", "adjust-position" to false, "hold-keyboard" to true, "auto-height" to true, "onKeyboardheightchange" to onKeyboardheightchange), null, 40, _uA(
                            "modelValue"
                        )),
                        _cE("text", _uM("class" to _nC(_uA(
                            "send-msg",
                            _uM("active" to (unref(message).length > 0))
                        )), "onClick" to send), "发送", 2),
                        _cE("view", _uM("class" to "placeholder-box"), _uA(
                            if (isTrue(unref(keyboardIsShow))) {
                                _cE("view", _uM("key" to 0, "style" to _nS(_uM("height" to unref(maxKeyboardHeight)))), null, 4)
                            } else {
                                _cC("v-if", true)
                            }
                            ,
                            if (isTrue(!unref(keyboardIsShow) || unref(isAndroid))) {
                                _cE("view", _uM("key" to 1, "class" to "safe-area-inset-bottom"))
                            } else {
                                _cC("v-if", true)
                            }
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
                return _uM("flex-row" to _pS(_uM("display" to "flex", "flexDirection" to "row")), "item" to _pS(_uM("flexDirection" to "row")), "self" to _pS(_uM("flexDirection" to "row-reverse")), "self-content" to _pS(_uM("backgroundColor" to "#3c99ff")), "self-content-text" to _pS(_uM("color" to "#ffffff")), "content" to _pS(_uM("marginTop" to 0, "marginRight" to 8, "marginBottom" to 0, "marginLeft" to 8, "maxWidth" to "562rpx", "minWidth" to 0, "flexShrink" to 1, "overflow" to "hidden", "borderTopLeftRadius" to 7, "borderTopRightRadius" to 7, "borderBottomRightRadius" to 7, "borderBottomLeftRadius" to 7, "paddingTop" to 9, "paddingRight" to 11, "paddingBottom" to 9, "paddingLeft" to 11, "alignItems" to "center", "backgroundColor" to "#ffffff")), "content-rich-wrap" to _pS(_uM("maxWidth" to "540rpx", "minWidth" to 0, "overflow" to "hidden")), "content-text" to _pS(_uM("display" to "flex", "fontSize" to 13, "lineHeight" to "20px", "color" to "#666666")), "loading" to _pS(_uM("height" to 30, "justifyContent" to "center", "alignItems" to "center", "transform" to "scale(1, -1)")), "input-box" to _pS(_uM("flexDirection" to "row", "flexWrap" to "wrap", "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 5, "paddingLeft" to 10, "borderTopWidth" to 1, "borderTopStyle" to "solid", "borderTopColor" to "#e5e5e5", "width" to "100%")), "placeholder-box" to _pS(_uM("width" to "100%")), "safe-area-inset-bottom" to _pS(_uM("height" to "env(safe-area-inset-bottom)")), "input-el" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "height" to 30, "paddingTop" to 5, "paddingRight" to 10, "paddingBottom" to 5, "paddingLeft" to 10, "backgroundColor" to "#EEEEEE", "color" to "#333333")), "send-msg" to _pS(_uM("marginLeft" to 10, "fontSize" to 12, "borderTopLeftRadius" to 4, "borderTopRightRadius" to 4, "borderBottomRightRadius" to 4, "borderBottomLeftRadius" to 4, "color" to "#999999", "marginTop" to 2, "paddingTop" to 0, "paddingRight" to 10, "paddingBottom" to 0, "paddingLeft" to 10, "height" to 26, "lineHeight" to "26px", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#eeeeee", "borderRightColor" to "#eeeeee", "borderBottomColor" to "#eeeeee", "borderLeftColor" to "#eeeeee")), "active" to _pS(_uM("color" to "#ffffff", "backgroundColor" to "#3c99ff", "borderTopColor" to "#3c99ff", "borderRightColor" to "#3c99ff", "borderBottomColor" to "#3c99ff", "borderLeftColor" to "#3c99ff")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
