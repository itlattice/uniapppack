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
open class GenPagesTemplateSwiperVerticalVideoCommentPanel : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var show: Boolean by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesTemplateSwiperVerticalVideoCommentPanel) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesTemplateSwiperVerticalVideoCommentPanel
            val _cache = __ins.renderCache
            val props = __props
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val commentList = ref(_uA<CommentItem>())
            val commentInput = ref("" as String)
            val keyboardHeight = ref(0 as Number)
            var panelMove = false
            var panelStartY: Number = 0
            var panelOffset: Number = 0
            var panelHeight: Number = 0
            var lastTouchY: Number = 0
            var lastTouchY2: Number = 0
            var bAnimating = false
            val commentPanelRef = ref<UniElement?>(null)
            val commentScrollRef = ref<UniScrollViewElement?>(null)
            val scrollDirection = ref("vertical")
            val canSend = computed(fun(): Boolean {
                return commentInput.value.trim().length > 0
            }
            )
            fun gen_initComments_fn() {
                commentList.value = _uA(
                    CommentItem(user = "用户A", content = "这个视频太棒了！", time = "2分钟前"),
                    CommentItem(user = "用户B", content = "学到了很多，感谢分享", time = "5分钟前"),
                    CommentItem(user = "用户C", content = "期待更多精彩内容", time = "10分钟前"),
                    CommentItem(user = "用户D", content = "点赞支持！", time = "15分钟前"),
                    CommentItem(user = "用户E", content = "很有用的教程", time = "20分钟前"),
                    CommentItem(user = "用户F", content = "很有用的教程", time = "20分钟前"),
                    CommentItem(user = "用户G", content = "很有用的教程", time = "20分钟前"),
                    CommentItem(user = "用户H", content = "很有用的教程", time = "20分钟前"),
                    CommentItem(user = "用户I", content = "很有用的教程", time = "20分钟前"),
                    CommentItem(user = "用户J", content = "很有用的教程", time = "20分钟前")
                )
                emit("countChange", commentList.value.length)
            }
            val initComments = ::gen_initComments_fn
            fun gen_handleClose_fn() {
                keyboardHeight.value = 0
                panelMove = false
                panelStartY = 0
                panelOffset = 0
                commentScrollRef.value?.setAttribute("direction", "vertical")
                commentPanelRef.value?.style?.setProperty("transform", "")
                commentPanelRef.value?.style?.setProperty("transition-property", "none")
                emit("close")
            }
            val handleClose = ::gen_handleClose_fn
            fun gen_measurePanelHeight_fn() {
                commentPanelRef.value?.getBoundingClientRectAsync()?.then(fun(rect: DOMRect){
                    panelHeight = rect.height
                }
                )
            }
            val measurePanelHeight = ::gen_measurePanelHeight_fn
            fun gen_onPanelTouchStart_fn(_event: TouchEvent) {
                commentPanelRef.value?.style?.setProperty("transition-duration", "0")
            }
            val onPanelTouchStart = ::gen_onPanelTouchStart_fn
            fun gen_onPanelTouchMove_fn(e: TouchEvent) {
                if (bAnimating) {
                    return
                }
                var top: Number = commentScrollRef.value?.scrollTop ?: 0
                var p = e.touches[0]
                lastTouchY2 = lastTouchY
                lastTouchY = p.screenY
                if (top <= 0.01 || panelMove) {
                    if (panelStartY == 0) {
                        panelStartY = p.screenY
                    }
                    var offset = p.screenY - panelStartY
                    if (offset > 0) {
                        panelMove = true
                        commentScrollRef.value?.setAttribute("direction", "none")
                        commentPanelRef.value?.style?.setProperty("transform", "translateY(" + offset.toFixed(2) + "px)")
                        panelOffset = offset
                    } else if (panelOffset > 0) {
                        offset = panelStartY - p.screenY
                        if (offset > panelOffset) {
                            offset = 0
                            panelMove = false
                        }
                        commentScrollRef.value?.setAttribute("direction", "vertical")
                        commentPanelRef.value?.style?.setProperty("transform", "translateY(" + offset.toFixed(2) + "px)")
                        panelOffset = offset
                    }
                }
            }
            val onPanelTouchMove = ::gen_onPanelTouchMove_fn
            fun gen_resumePanel_fn() {
                val time: Number = 300
                commentPanelRef.value?.style?.setProperty("transition-duration", time.toString(10) + "ms")
                commentPanelRef.value?.style?.setProperty("transition-timing-function", "ease-in-out")
                commentPanelRef.value?.style?.setProperty("transition-property", "transform")
                commentPanelRef.value?.style?.setProperty("transform", "translateY(0px)")
                panelMove = false
                commentScrollRef.value?.setAttribute("direction", "vertical")
                panelStartY = 0
                panelOffset = 0
                setTimeout(fun(){
                    bAnimating = false
                    commentPanelRef.value?.style?.setProperty("transition-property", "none")
                }
                , time)
                bAnimating = true
            }
            val resumePanel = ::gen_resumePanel_fn
            fun gen_onPanelTouchEnd_fn(_event: TouchEvent) {
                panelStartY = 0
                if (bAnimating) {
                    return
                }
                var top: Number = commentScrollRef.value?.scrollTop ?: 0
                var bHide = panelHeight > 0 && (panelHeight - panelOffset) < panelHeight / 4
                if (bHide) {
                    bHide = lastTouchY2 > 0 && lastTouchY2 <= lastTouchY
                } else if (top <= 0.01) {
                    bHide = (lastTouchY - lastTouchY2) > 3
                }
                if (bHide) {
                    handleClose()
                } else if (panelOffset > 0) {
                    resumePanel()
                }
            }
            val onPanelTouchEnd = ::gen_onPanelTouchEnd_fn
            fun gen_onMaskClick_fn() {
                handleClose()
            }
            val onMaskClick = ::gen_onMaskClick_fn
            fun gen_onKeyboardHeightChange_fn(event: UniInputKeyboardHeightChangeEvent) {
                keyboardHeight.value = event.detail.height
            }
            val onKeyboardHeightChange = ::gen_onKeyboardHeightChange_fn
            fun gen_submitComment_fn() {
                if (commentInput.value.trim() == "") {
                    return
                }
                val timeStr = "刚刚"
                val newComment = CommentItem(user = "我", content = commentInput.value, time = timeStr)
                commentList.value.unshift(newComment)
                commentInput.value = ""
                emit("countChange", commentList.value.length)
            }
            val submitComment = ::gen_submitComment_fn
            watch(fun(): Boolean {
                return props.show
            }
            , fun(kVal: Boolean){
                if (kVal) {
                    nextTick(fun(){
                        measurePanelHeight()
                    }
                    )
                }
            }
            )
            initComments()
            return fun(): Any? {
                return if (isTrue(_ctx.show)) {
                    _cE("view", _uM("key" to 0, "class" to "popup-box", "onClick" to onMaskClick), _uA(
                        _cE("view", _uM("class" to "popup-mask")),
                        _cE("view", _uM("ref_key" to "commentPanelRef", "ref" to commentPanelRef, "class" to "comment-panel", "onClick" to withModifiers(fun(){}, _uA(
                            "stop"
                        )), "onTouchstart" to onPanelTouchStart, "onTouchmove" to onPanelTouchMove, "onTouchend" to onPanelTouchEnd), _uA(
                            _cE("view", _uM("class" to "comment-panel-header"), _uA(
                                _cE("text", _uM("class" to "comment-panel-title"), "评论 " + _tD(unref(commentList).length), 1),
                                _cE("view", _uM("class" to "comment-panel-close", "onClick" to handleClose), _uA(
                                    _cE("text", _uM("class" to "close-text"), "✕")
                                ))
                            )),
                            _cE("scroll-view", _uM("ref_key" to "commentScrollRef", "ref" to commentScrollRef, "class" to "comment-scroll", "direction" to unref(scrollDirection), "bounces" to "true"), _uA(
                                _cE("view", _uM("class" to "comment-list"), _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(unref(commentList), fun(comment, index, __index, _cached): Any {
                                        return _cE("view", _uM("class" to "comment-item", "key" to index), _uA(
                                            _cE("view", _uM("class" to "comment-avatar"), _uA(
                                                _cE("text", _uM("class" to "avatar-text"), _tD(comment.user.charAt(0)), 1)
                                            )),
                                            _cE("view", _uM("class" to "comment-content"), _uA(
                                                _cE("text", _uM("class" to "comment-user"), _tD(comment.user), 1),
                                                _cE("text", _uM("class" to "comment-text"), _tD(comment.content), 1),
                                                _cE("text", _uM("class" to "comment-time"), _tD(comment.time), 1)
                                            ))
                                        ))
                                    }), 128)
                                ))
                            ), 8, _uA(
                                "direction"
                            )),
                            _cE("view", _uM("class" to "comment-input-box", "style" to _nS("transform: translateY(-" + unref(keyboardHeight) + "px);")), _uA(
                                _cE("input", _uM("class" to "comment-input", "modelValue" to unref(commentInput), "onInput" to fun(`$event`: UniInputEvent){
                                    trySetRefValue(commentInput, `$event`.detail.value)
                                }, "placeholder" to "说点什么...", "onConfirm" to submitComment, "adjust-position" to false, "onKeyboardheightchange" to onKeyboardHeightChange), null, 40, _uA(
                                    "modelValue"
                                )),
                                _cE("view", _uM("class" to _nC(_uA(
                                    "comment-send-btn",
                                    _uM("disabled" to !unref(canSend))
                                )), "onClick" to submitComment), _uA(
                                    _cE("text", _uM("class" to "send-text"), "发送")
                                ), 2)
                            ), 4)
                        ), 40, _uA(
                            "onClick"
                        ))
                    ))
                } else {
                    _cC("v-if", true)
                }
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("popup-box" to _pS(_uM("position" to "absolute", "top" to 0, "left" to 0, "right" to 0, "bottom" to 0, "zIndex" to 999)), "popup-mask" to _pS(_uM("position" to "absolute", "top" to 0, "left" to 0, "right" to 0, "bottom" to 0, "backgroundColor" to "rgba(0,0,0,0.7)")), "comment-panel" to _pS(_uM("position" to "absolute", "top" to 200, "bottom" to 0, "left" to 0, "right" to 0, "width" to "100%", "backgroundColor" to "#1a1a1a", "borderTopLeftRadius" to 20, "borderTopRightRadius" to 20, "flexDirection" to "column")), "comment-panel-header" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "paddingTop" to 15, "paddingRight" to 20, "paddingBottom" to 15, "paddingLeft" to 20, "borderBottomWidth" to 1, "borderBottomColor" to "#333333")), "comment-panel-title" to _pS(_uM("fontSize" to 16, "fontWeight" to "bold", "color" to "#ffffff")), "comment-panel-close" to _pS(_uM("width" to 30, "height" to 30, "justifyContent" to "center", "alignItems" to "center")), "close-text" to _pS(_uM("fontSize" to 20, "color" to "#999999")), "comment-scroll" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "comment-list" to _pS(_uM("paddingTop" to 10, "paddingRight" to 20, "paddingBottom" to 10, "paddingLeft" to 20)), "comment-item" to _pS(_uM("flexDirection" to "row", "marginBottom" to 15)), "comment-avatar" to _pS(_uM("width" to 36, "height" to 36, "borderTopLeftRadius" to 18, "borderTopRightRadius" to 18, "borderBottomRightRadius" to 18, "borderBottomLeftRadius" to 18, "backgroundColor" to "#007aff", "justifyContent" to "center", "alignItems" to "center", "marginRight" to 10)), "avatar-text" to _pS(_uM("color" to "#ffffff", "fontSize" to 14, "fontWeight" to "bold")), "comment-content" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "flexDirection" to "column")), "comment-user" to _pS(_uM("fontSize" to 14, "fontWeight" to "bold", "color" to "#ffffff", "marginBottom" to 5)), "comment-text" to _pS(_uM("fontSize" to 14, "color" to "#e0e0e0", "lineHeight" to "20px", "marginBottom" to 5)), "comment-time" to _pS(_uM("fontSize" to 12, "color" to "#888888")), "comment-input-box" to _pS(_uM("flexDirection" to "row", "alignItems" to "center", "paddingTop" to 10, "paddingRight" to 15, "paddingBottom" to 10, "paddingLeft" to 15, "borderTopWidth" to 1, "borderTopColor" to "#333333", "backgroundColor" to "#1a1a1a", "transitionProperty" to "transform", "transitionDuration" to "0.1s", "transitionTimingFunction" to "ease-out")), "comment-input" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "height" to 36, "paddingTop" to 0, "paddingRight" to 10, "paddingBottom" to 0, "paddingLeft" to 10, "backgroundColor" to "#2c2c2c", "color" to "#ffffff", "borderTopLeftRadius" to 18, "borderTopRightRadius" to 18, "borderBottomRightRadius" to 18, "borderBottomLeftRadius" to 18, "fontSize" to 14, "marginRight" to 10)), "comment-send-btn" to _uM("" to _uM("paddingTop" to 8, "paddingRight" to 20, "paddingBottom" to 8, "paddingLeft" to 20, "backgroundColor" to "#007aff", "borderTopLeftRadius" to 18, "borderTopRightRadius" to 18, "borderBottomRightRadius" to 18, "borderBottomLeftRadius" to 18), ".disabled" to _uM("backgroundColor" to "#444444", "opacity" to 0.6)), "send-text" to _pS(_uM("color" to "#ffffff", "fontSize" to 14)), "@TRANSITION" to _uM("comment-input-box" to _uM("property" to "transform", "duration" to "0.1s", "timingFunction" to "ease-out")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("close" to null, "countChange" to null)
        var props = _nP(_uM("show" to _uM("type" to "Boolean", "required" to true)))
        var propsNeedCastKeys = _uA(
            "show"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
