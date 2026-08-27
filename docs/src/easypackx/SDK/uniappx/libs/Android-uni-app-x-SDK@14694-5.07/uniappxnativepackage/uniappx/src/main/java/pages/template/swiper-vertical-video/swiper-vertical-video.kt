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
import io.dcloud.uniapp.extapi.createVideoContext as uni_createVideoContext
open class GenPagesTemplateSwiperVerticalVideoSwiperVerticalVideo : BasePage {
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
        var setup: (__props: GenPagesTemplateSwiperVerticalVideoSwiperVerticalVideo) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesTemplateSwiperVerticalVideoSwiperVerticalVideo
            val _cache = __ins.renderCache
            var page: Number = 0
            var currentPageIsShow: Boolean = true
            val `$videoContextMap` = Map<String, VideoContext>()
            val list = ref(_uA<ListItem__1>())
            val visibleList = ref(_uA<ListItem__1>())
            val current = ref(0 as Number)
            val index = ref(0)
            val stateList = ref(_uA<String>("pause", "unPlay", "unPlay"))
            val showDebugInfo = ref(false as Boolean)
            val showCommentPanel = ref(false as Boolean)
            val commentCount = ref(0 as Number)
            fun gen_openCommentPanel_fn() {
                showCommentPanel.value = true
            }
            val openCommentPanel = ::gen_openCommentPanel_fn
            fun gen_closeCommentPanel_fn() {
                showCommentPanel.value = false
            }
            val closeCommentPanel = ::gen_closeCommentPanel_fn
            fun gen_onCommentCountChange_fn(count: Number) {
                commentCount.value = count
            }
            val onCommentCountChange = ::gen_onCommentCountChange_fn
            fun gen_getVideoContext_fn(idx: Number): VideoContext {
                var videoContext: VideoContext? = `$videoContextMap`.get("video-" + idx)
                if (videoContext == null) {
                    videoContext = uni_createVideoContext("video-" + idx, null) as VideoContext
                    `$videoContextMap`.set("video-" + idx, videoContext)
                }
                return videoContext
            }
            val getVideoContext = ::gen_getVideoContext_fn
            fun gen_doPlay_fn(idx: Number) {
                console.log("doPlay  video" + idx)
                getVideoContext(idx).play()
            }
            val doPlay = ::gen_doPlay_fn
            fun gen_doStop_fn(idx: Number) {
                console.log("doStop  video-" + idx)
                getVideoContext(idx).stop()
                setTimeout(fun(){
                    stateList.value[idx] = "unPlay"
                }
                , 1000)
            }
            val doStop = ::gen_doStop_fn
            fun gen_doPause_fn(idx: Number) {
                getVideoContext(idx).pause()
                console.log("doPause  video-" + idx)
            }
            val doPause = ::gen_doPause_fn
            fun gen_changeState_fn(idx: Number) {
                if (stateList.value[idx] === "play") {
                    doPause(idx)
                } else {
                    doPlay(current.value)
                }
            }
            val changeState = ::gen_changeState_fn
            fun gen_onLoadstart_fn(idx: Number) {
                console.error("onLoadstart  video" + idx)
            }
            val onLoadstart = ::gen_onLoadstart_fn
            fun gen_onPause_fn(idx: Number) {
                stateList.value[idx] = "pause"
                console.log("onPause", idx)
            }
            val onPause = ::gen_onPause_fn
            fun gen_onPlay_fn(idx: Number) {
                if (current.value != idx || !currentPageIsShow) {
                    onPause(idx)
                } else {
                    stateList.value[idx] = "play"
                    console.log("onPlay", idx)
                }
            }
            val onPlay = ::gen_onPlay_fn
            fun gen_getData_fn(): UTSArray<ListItem__1> {
                var videoUrlList = if (state.netless) {
                    _uA(
                        "/static/test-video/10second-demo.mp4",
                        "/static/test-video/10second-demo.mp4",
                        "/static/test-video/10second-demo.mp4"
                    )
                } else {
                    _uA<String>("https://web-ext-storage.dcloud.net.cn/uni-app-x/video/uts-5-16.mp4", "https://web-ext-storage.dcloud.net.cn/uni-app-x/video/uni-ai-5-16.mp4", "https://web-ext-storage.dcloud.net.cn/uni-app-x/video/uni-verify-5-16.mp4")
                }
                var posterSrcList = if (state.netless) {
                    _uA(
                        "/static/shuijiao.jpg",
                        "/static/logo.jpg",
                        "/static/shuijiao.jpg"
                    )
                } else {
                    _uA<String>("https://web-ext-storage.dcloud.net.cn/uni-app-x/dark-uni-uts-01.png", "https://web-ext-storage.dcloud.net.cn/uni-app-x/dark-uni-ai-01.png", "https://web-ext-storage.dcloud.net.cn/uni-app-x/dark-uni-verify-01.jpg")
                }
                var listData = _uA<ListItem__1>()
                run {
                    var i: Number = 0
                    while(i < 6){
                        var idx = list.value.length + i
                        var listItem = ListItem__1(_id = "a00" + idx, content = "这是第" + idx + "条数据，url地址" + videoUrlList[i % 3], src = videoUrlList[i % 3], poster_src = posterSrcList[i % 3])
                        listData.push(listItem)
                        i++
                    }
                }
                return listData
            }
            val getData = ::gen_getData_fn
            fun gen_onSwiperChange_fn(e: SwiperChangeEvent) {
                current.value = e.detail.current
            }
            val onSwiperChange = ::gen_onSwiperChange_fn
            fun gen_onTransition_fn() {}
            val onTransition = ::gen_onTransition_fn
            watch(current, fun(curr: Number, oldCurrent: Number){
                var changeNumber = curr - oldCurrent
                if (changeNumber == 1 || changeNumber == -2) {
                    index.value++
                } else {
                    index.value--
                }
                if (Math.abs(changeNumber) == 2) {
                    page = Math.floor(index.value / 3)
                    if (list.value.length < 3 * page + 3) {
                        var listData: UTSArray<ListItem__1> = getData()
                        list.value.push(*listData.toTypedArray())
                    }
                    var visible = list.value.slice(3 * page, 3 * page + 3)
                    visibleList.value = visible
                }
                stateList.value.forEach(fun(_: String, idx: Number){
                    if (idx === curr) {
                        doPlay(curr)
                    } else {
                        doStop(idx)
                        console.log("index:" + idx + "已被执行停止")
                    }
                }
                )
            }
            )
            list.value = getData()
            visibleList.value = list.value.slice(0, 3)
            nextTick(fun(){
                setTimeout(fun(){
                    return doPlay(0)
                }
                , 30)
            }
            )
            onPageShow(fun(){
                currentPageIsShow = true
            }
            )
            onHide(fun(){
                currentPageIsShow = false
                console.log("pages-onHide")
                doPause(current.value)
            }
            )
            onBackPress(fun(_options): Boolean {
                if (showCommentPanel.value) {
                    closeCommentPanel()
                    return true
                }
                return false
            }
            )
            onUnload(fun(){
                doPause(current.value)
            }
            )
            return fun(): Any? {
                val _component_uni_back_arrow_circle = resolveEasyComponent("uni-back-arrow-circle", GenComponentsUniBackArrowCircleUniBackArrowCircleClass)
                return _cE("view", _uM("class" to "page"), _uA(
                    _cV(_component_uni_back_arrow_circle, _uM("class" to "back", "arrow-class" to "arrow")),
                    _cE("swiper", _uM("class" to "swiper", "current" to unref(current), "circular" to (unref(index) != 0), "vertical" to true, "onChange" to onSwiperChange, "onTransition" to onTransition), _uA(
                        _cE(Fragment, null, RenderHelpers.renderList(unref(visibleList), fun(item, i, __index, _cached): Any {
                            return _cE("swiper-item", _uM("class" to "swiper-item", "key" to i), _uA(
                                _cE("video", _uM("onClick" to fun(){
                                    changeState(i)
                                }
                                , "ref_for" to true, "ref" to "video", "class" to "video-box", "id" to ("video-" + i), "onLoadstart" to fun(){
                                    onLoadstart(i)
                                }
                                , "src" to item.src, "poster" to item.poster_src, "autoplay" to false, "show-progress" to false, "show-fullscreen-btn" to false, "show-play-btn" to false, "show-center-play-btn" to false, "loop" to true, "onPlay" to fun(){
                                    onPlay(i)
                                }
                                , "onPause" to fun(){
                                    onPause(i)
                                }
                                , "http-cache" to "true"), null, 40, _uA(
                                    "onClick",
                                    "id",
                                    "onLoadstart",
                                    "src",
                                    "poster",
                                    "onPlay",
                                    "onPause"
                                )),
                                _cE("view", _uM("class" to "video-cover", "onClick" to fun(){
                                    changeState(i)
                                }
                                ), _uA(
                                    if (unref(stateList)[i] === "pause") {
                                        _cE("image", _uM("key" to 0, "class" to "play-btn", "src" to "/static/template/swiper-vertical-video/play.png", "mode" to "widthFix"))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                ), 8, _uA(
                                    "onClick"
                                )),
                                if (isTrue(unref(showDebugInfo))) {
                                    _cE("view", _uM("key" to 0, "class" to "video-info"), _uA(
                                        _cE("text", _uM("class" to "video-info-text"), "容器：第 " + _tD(i) + " 个", 1),
                                        _cE("text", _uM("class" to "video-info-text"), "内容：" + _tD(item.content), 1)
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                                ,
                                _cE("view", _uM("class" to "comment-btn", "onClick" to openCommentPanel), _uA(
                                    _cE("view", _uM("class" to "comment-icon"), _uA(
                                        _cE("text", _uM("class" to "comment-icon-text"), "💬")
                                    )),
                                    _cE("text", _uM("class" to "comment-count"), _tD(unref(commentCount)), 1)
                                ))
                            ))
                        }
                        ), 128)
                    ), 40, _uA(
                        "current",
                        "circular"
                    )),
                    if (isTrue(unref(showDebugInfo))) {
                        _cE("view", _uM("key" to 0, "class" to "debug-info"), _uA(
                            _cE("text", _uM("class" to "status-text"), "debug-info 播放状态:"),
                            _cE(Fragment, null, RenderHelpers.renderList(unref(stateList), fun(value, index, __index, _cached): Any {
                                return _cE("text", _uM("class" to "status-text"), "第" + _tD(index + 1) + "个:" + _tD(value), 1)
                            }), 256)
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    _cV(unref(GenPagesTemplateSwiperVerticalVideoCommentPanelClass), _uM("show" to unref(showCommentPanel), "onClose" to closeCommentPanel, "onCountChange" to onCommentCountChange), null, 8, _uA(
                        "show"
                    ))
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
                return _uM("page" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "swiper" to _pS(_uM("width" to "100%", "height" to "100%")), "swiper-item" to _pS(_uM("width" to "100%", "height" to "100%")), "video-box" to _pS(_uM("width" to "100%", "height" to "100%")), "video-cover" to _pS(_uM("width" to "100%", "height" to "100%", "position" to "absolute", "justifyContent" to "center", "alignItems" to "center", "alignContent" to "center")), "play-btn" to _pS(_uM("width" to 40, "height" to 40)), "video-info" to _pS(_uM("position" to "absolute", "bottom" to 0, "paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15)), "video-info-text" to _pS(_uM("fontSize" to 14, "color" to "#FF0000", "lineHeight" to "20px")), "debug-info" to _pS(_uM("position" to "fixed", "top" to 15, "width" to "100%", "backgroundColor" to "rgba(255,255,255,0.3)")), "status-text" to _pS(_uM("color" to "#FF0000", "paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15)), "back" to _pS(_uM("position" to "absolute", "top" to CSS_VAR_STATUS_BAR_HEIGHT, "zIndex" to 10)), "arrow" to _pS(_uM("!borderLeftColor" to "#FFFFFF", "!borderBottomColor" to "#FFFFFF")), "comment-btn" to _pS(_uM("position" to "absolute", "right" to 15, "bottom" to 80, "flexDirection" to "column", "alignItems" to "center", "zIndex" to 10)), "comment-icon" to _pS(_uM("width" to 40, "height" to 40, "borderTopLeftRadius" to 20, "borderTopRightRadius" to 20, "borderBottomRightRadius" to 20, "borderBottomLeftRadius" to 20, "backgroundColor" to "rgba(0,0,0,0.3)", "justifyContent" to "center", "alignItems" to "center")), "comment-icon-text" to _pS(_uM("fontSize" to 20)), "comment-count" to _pS(_uM("fontSize" to 12, "color" to "#ffffff", "textAlign" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
