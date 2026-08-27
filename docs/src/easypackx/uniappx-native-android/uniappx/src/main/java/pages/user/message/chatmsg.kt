@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNI2971F61
import android.content.Context
import io.dcloud.uniapp.*
import io.dcloud.uniapp.extapi.*
import io.dcloud.uniapp.framework.*
import io.dcloud.uniapp.runtime.*
import io.dcloud.uniapp.vue.*
import io.dcloud.uniapp.vue.shared.*
import io.dcloud.uts.*
import io.dcloud.uts.Map
import io.dcloud.uts.Set
import io.dcloud.uts.UTSAndroid
import kotlin.properties.Delegates
import uts.sdk.modules.iboxsChooseMedia.MediaScanner
import io.dcloud.uniapp.extapi.`$emit` as uni__emit
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
open class GenPagesUserMessageChatmsg : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            xProvitae.scrollTop = e.scrollTop
            val pages = getCurrentPages()
            if (pages.length == 0) {
                return
            }
            val page = pages[pages.length - 1].route
            uni__emit("onPageScroll", _uO("top" to e.scrollTop, "page" to page))
        }
        , __ins)
        onResize(fun(_: OnResizeOptions) {
            uni__emit("onResize", fun() {})
        }
        , __ins)
        onLoad(fun(query: OnLoadOptions) {
            xProvitae.onLoadOpts = JSON.parseObject(JSON.stringify(query)!!) ?: _uO()
            uni__emit("onLoad", fun() {})
        }
        , __ins)
        onPageHide(fun() {
            uni__emit("onHide", fun() {})
        }
        , __ins)
        onReady(fun() {
            uni__emit("onReady", fun() {})
            xProvitae.pageReady = true
        }
        , __ins)
        onPageShow(fun() {
            uni__emit("onShow", fun() {})
        }
        , __ins)
    }
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesUserMessageChatmsg) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesUserMessageChatmsg
            val _cache = __ins.renderCache
            val message = ref("")
            val PageHeight = ref(0)
            val messages = ref(_uA<Message>(Message(type = "text", content = "你好！有什么可以帮助你的吗？", time = "14:31", isMe = false), Message(type = "text", content = "你好，我想咨询一下你们的产品", time = "14:32", isMe = true), Message(type = "text", content = "当然可以，请问你想了解哪方面的信息呢？", time = "14:33", isMe = false), Message(type = "text", content = "我对你们的手机型号和价格比较感兴趣", time = "14:34", isMe = true), Message(type = "text", content = "我们有几款不同的型号可供选择，价格从1999元到5999元不等。你有预算范围吗？", time = "14:35", isMe = false), Message(type = "image", content = "https://cdn.itgz8.com/logo.png", time = "14:31", isMe = false), Message(type = "file", content = "", filename = "wjianmc.doc", size = "100MB", time = "14:31", isMe = false, thumb = "https://cdn.itgz8.com/logo.png")))
            onReady(fun(){
                PageHeight.value = uni_getWindowInfo().safeArea.height - 40
            }
            )
            return fun(): Any? {
                val _component_x_viewtitle = resolveEasyComponent("x-viewtitle", GenComponentsXViewtitleClass)
                val _component_i = resolveComponent("i")
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_x_button = resolveEasyComponent("x-button", GenComponentsXButtonClass)
                return _cE("view", null, _uA(
                    _cV(_component_x_viewtitle, _uM("title" to "张三")),
                    _cE("scroll-view", _uM("style" to _nS(_uM("height" to (unref(PageHeight) + "px"))), "scroll-into-view" to "msgb", "direction" to "vertical", "show-scrollbar" to false), _uA(
                        _cE("view", _uM("class" to "msgheight", "style" to _nS(_uM("height" to ((unref(PageHeight) - 54) + "px")))), _uA(
                            _cE("scroll-view", _uM("scroll-into-view" to "bottoim", "show-scrollbar" to false, "style" to _nS(_uA(
                                _uM("height" to ((unref(PageHeight) - 54) + "px")),
                                _uM("padding-top" to "10px")
                            )), "direction" to "vertical"), _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(unref(messages), fun(message, index, __index, _cached): Any {
                                    return _cE("view", _uM("key" to index, "class" to "message-item"), _uA(
                                        if (isTrue(message.isMe)) {
                                            _cE("view", _uM("key" to 0, "class" to "message-right display-flex"), _uA(
                                                _cE("view", _uM("class" to "message-content"), _uA(
                                                    if (message.type === "text") {
                                                        _cE("text", _uM("key" to 0, "class" to "text-message right-message color-white"), _tD(message.content), 1)
                                                    } else {
                                                        if (message.type === "image") {
                                                            _cE("view", _uM("key" to 1, "class" to "image-message"), _uA(
                                                                _cE("image", _uM("mode" to "aspectFit", "src" to message.content, "class" to "message-image"), null, 8, _uA(
                                                                    "src"
                                                                ))
                                                            ))
                                                        } else {
                                                            if (message.type === "file") {
                                                                _cE("view", _uM("key" to 2, "class" to "file-message right-message"), _uA(
                                                                    _cV(_component_i, _uM("class" to "fa fa-file-o mr-2")),
                                                                    _cE("view", _uM("class" to "flex-1"), _uA(
                                                                        _cE("text", _uM("class" to "filename truncate"), _tD(message.filename), 1),
                                                                        _cE("text", _uM("class" to "filesize"), _tD(message.size), 1)
                                                                    )),
                                                                    _cE("button", _uM("class" to "download-btn"), _uA(
                                                                        _cV(_component_i, _uM("class" to "fa fa-download"))
                                                                    ))
                                                                ))
                                                            } else {
                                                                _cC("v-if", true)
                                                            }
                                                        }
                                                    },
                                                    _cE("text", _uM("class" to "message-time"), _tD(message.time), 1)
                                                )),
                                                _cE("image", _uM("src" to "https://picsum.photos/200/200?random=2", "class" to "avatar"), null, 8, _uA(
                                                    "src"
                                                ))
                                            ))
                                        } else {
                                            _cE("view", _uM("key" to 1, "class" to "message-left display-flex"), _uA(
                                                _cE("image", _uM("src" to "https://picsum.photos/200/200?random=1", "class" to "avatar"), null, 8, _uA(
                                                    "src"
                                                )),
                                                _cE("view", _uM("class" to "message-content"), _uA(
                                                    if (message.type === "text") {
                                                        _cE("text", _uM("key" to 0, "class" to "text-message left-message color-white"), _tD(message.content), 1)
                                                    } else {
                                                        if (message.type === "image") {
                                                            _cE("view", _uM("key" to 1, "class" to "image-message"), _uA(
                                                                _cE("image", _uM("src" to message.content, "class" to "message-image"), null, 8, _uA(
                                                                    "src"
                                                                ))
                                                            ))
                                                        } else {
                                                            if (message.type === "file") {
                                                                _cE("view", _uM("key" to 2, "class" to "file-message left-message"), _uA(
                                                                    _cE("image", _uM("src" to message.thumb, "class" to "thumb-image"), null, 8, _uA(
                                                                        "src"
                                                                    )),
                                                                    _cE("view", _uM("class" to "flex-1"), _uA(
                                                                        _cE("text", _uM("class" to "filename truncate"), _tD(message.filename), 1),
                                                                        _cE("text", _uM("class" to "filesize"), _tD(message.size), 1)
                                                                    )),
                                                                    _cV(_component_x_iconfont, _uM("name" to "xiazai"))
                                                                ))
                                                            } else {
                                                                _cC("v-if", true)
                                                            }
                                                        }
                                                    }
                                                    ,
                                                    _cE("text", _uM("class" to "message-time"), _tD(message.time), 1)
                                                ))
                                            ))
                                        }
                                    ))
                                }
                                ), 128),
                                _cE("view", _uM("id" to "bottoim"))
                            ), 4)
                        ), 4),
                        _cE("view", _uM("class" to "chatinput"), _uA(
                            _cE("view", _uM("class" to "chatinp display-flex"), _uA(
                                _cE("view", _uM("class" to "chatp background-white"), _uA(
                                    _cE("input", _uM("type" to "text", "modelValue" to unref(message), "onInput" to fun(`$event`: UniInputEvent){
                                        trySetRefValue(message, `$event`.detail.value)
                                    }
                                    , "class" to "inp"), null, 40, _uA(
                                        "modelValue"
                                    ))
                                )),
                                if (unref(message) == "") {
                                    _cE("view", _uM("key" to 0, "class" to "chattool display-flex"), _uA(
                                        _cV(_component_x_iconfont, _uM("class" to "biaoqing", "color" to "#808080", "size" to "30", "height" to 54, "name" to "biaoqing")),
                                        _cV(_component_x_iconfont, _uM("class" to "biaoqing", "color" to "#808080", "size" to "30", "height" to 54, "name" to "tianjia"))
                                    ))
                                } else {
                                    _cE("view", _uM("key" to 1, "class" to "chatbtn"), _uA(
                                        _cV(_component_x_button, _uM("class" to "sendbtn"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                "发送"
                                            )
                                        }
                                        ), "_" to 1))
                                    ))
                                }
                            )),
                            _cE("view", _uM("class" to "chataction"))
                        ))
                    ), 4)
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
                return _uM("native" to _pS(_uM("width" to "750rpx")), "nativetitle" to _uM(".native " to _uM("paddingLeft" to "16rpx", "paddingRight" to "22rpx", "paddingTop" to 13, "height" to 40)), "text" to _uM(".native " to _uM("fontSize" to 15, "marginLeft" to "6rpx")), "chatinput" to _pS(_uM("width" to "750rpx")), "chatinp" to _uM(".chatinput " to _uM("height" to 54, "backgroundImage" to "none", "backgroundColor" to "#F7F7F7FF", "borderTopWidth" to 1, "borderRightWidth" to 0, "borderBottomWidth" to 1, "borderLeftWidth" to 0, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#E6E6E6FF", "borderRightColor" to "#E6E6E6FF", "borderBottomColor" to "#E6E6E6FF", "borderLeftColor" to "#E6E6E6FF")), "chatp" to _uM(".chatinput .chatinp " to _uM("marginLeft" to "24rpx", "marginTop" to 9, "width" to "570rpx", "height" to 34, "borderTopLeftRadius" to 4, "borderTopRightRadius" to 4, "borderBottomRightRadius" to 4, "borderBottomLeftRadius" to 4)), "inp" to _uM(".chatinput .chatinp .chatp " to _uM("width" to "570rpx", "height" to 34, "fontSize" to 15, "paddingLeft" to 3)), "chattool" to _uM(".chatinput .chatinp " to _uM("width" to "156rpx")), "biaoqing" to _uM(".chatinput .chatinp .chattool " to _uM("width" to "78rpx", "textAlign" to "center")), "chat-messages" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "paddingTop" to 16, "paddingRight" to 16, "paddingBottom" to 16, "paddingLeft" to 16, "boxSizing" to "border-box")), "message-item" to _pS(_uM("marginBottom" to 16, "overflow" to "hidden")), "message-right" to _pS(_uM("display" to "flex", "alignItems" to "flex-start", "justifyContent" to "flex-end", "flexDirection" to "row-reverse")), "avatar" to _uM(".message-right " to _uM("width" to 36, "height" to 36, "borderTopLeftRadius" to 18, "borderTopRightRadius" to 18, "borderBottomRightRadius" to 18, "borderBottomLeftRadius" to 18, "marginLeft" to 10, "flexShrink" to 0), ".message-left " to _uM("width" to 36, "height" to 36, "borderTopLeftRadius" to 18, "borderTopRightRadius" to 18, "borderBottomRightRadius" to 18, "borderBottomLeftRadius" to 18, "marginRight" to 10, "flexShrink" to 0)), "message-content" to _uM(".message-right " to _uM("maxWidth" to "560rpx", "display" to "flex", "flexDirection" to "column"), ".message-left " to _uM("maxWidth" to "560rpx", "display" to "flex", "flexDirection" to "column")), "text-message" to _uM(".message-right .message-content " to _uM("backgroundColor" to "#e5e5ea", "color" to "#000000", "paddingTop" to 8, "paddingRight" to 12, "paddingBottom" to 8, "paddingLeft" to 12, "borderTopLeftRadius" to 6, "borderTopRightRadius" to 0, "borderBottomRightRadius" to 6, "borderBottomLeftRadius" to 6, "fontSize" to 16), ".message-left .message-content " to _uM("backgroundColor" to "#4cd964", "color" to "#ffffff", "paddingTop" to 8, "paddingRight" to 12, "paddingBottom" to 8, "paddingLeft" to 12, "borderTopLeftRadius" to 0, "borderTopRightRadius" to 6, "borderBottomRightRadius" to 6, "borderBottomLeftRadius" to 6, "fontSize" to 16)), "message-left" to _pS(_uM("display" to "flex", "alignItems" to "flex-start")), "message-image" to _pS(_uM("maxWidth" to "560rpx", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#bfbfbf", "borderRightColor" to "#bfbfbf", "borderBottomColor" to "#bfbfbf", "borderLeftColor" to "#bfbfbf", "borderTopLeftRadius" to 6, "borderTopRightRadius" to 6, "borderBottomRightRadius" to 6, "borderBottomLeftRadius" to 6)), "message-time" to _pS(_uM("fontSize" to 13, "color" to "#9a9a9a", "marginTop" to 4)), "msgheight" to _pS(_uM("paddingLeft" to 10, "paddingRight" to 10)), "file-message" to _uM(".right-message" to _uM("backgroundColor" to "#4cd964"), ".left-message" to _uM("backgroundColor" to "#e5e5ea")), "filename" to _uM(".file-message.right-message " to _uM("color" to "#ffffff"), ".file-message.left-message " to _uM("color" to "#333333")), "filesize" to _uM(".file-message.right-message " to _uM("color" to "rgba(255,255,255,0.9)"), ".file-message.left-message " to _uM("color" to "#666666")), "download-btn" to _uM(".file-message.right-message " to _uM("color" to "#ffffff"), ".file-message.left-message " to _uM("color" to "#007aff")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
