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
import io.dcloud.uniapp.extapi.createLivePlayerContext as uni_createLivePlayerContext
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesComponentLivePlayerLivePlayer : BasePage {
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
        var setup: (__props: GenPagesComponentLivePlayerLivePlayer) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentLivePlayerLivePlayer
            val _cache = __ins.renderCache
            val context = ref(null as LivePlayerContext?)
            val src = ref("")
            val autoplay = ref(false)
            val muted = ref(false)
            val objectFit = ref("contain")
            val backgroundMute = ref(false)
            val soundMode = ref("speaker")
            val orientation = ref("vertical")
            val initState = ref(true)
            val playState = ref(false)
            val stopState = ref(false)
            onReady(fun(){
                context.value = uni_createLivePlayerContext("live-player", getCurrentInstance()!!.proxy)
            }
            )
            val statechange = fun(e: UniLivePlayerStatechangeEvent){
                console.log("statechange", e)
                when (e.detail.code) {
                    10004 -> 
                        {
                            initState.value = false
                            playState.value = true
                            stopState.value = false
                        }
                    10009 -> 
                        {
                            stopState.value = true
                            playState.value = false
                        }
                    10006, 10007, 10010, 10011 -> 
                        playState.value = false
                }
            }
            val fullscreenchange = fun(e: UniLivePlayerFullscreenchangeEvent){
                console.log("fullscreenchange", e)
            }
            val error = fun(e: UniLivePlayerErrorEvent){
                console.log("error", e)
            }
            val isSrcValid = fun(): Boolean {
                val length = src.value.length
                if (length <= 0) {
                    uni_showToast(ShowToastOptions(title = "请输入播放地址", icon = "none"))
                }
                return length > 0
            }
            val play = fun(){
                if (!isSrcValid()) {
                    return
                }
                context.value?.play(LivePlayerOptions(success = fun(res){
                    console.log("play", JSON.stringify(res))
                }
                , fail = fun(err){
                    console.log("play", JSON.stringify(err))
                }
                , complete = fun(res){
                    console.log("play", JSON.stringify(res))
                }
                ))
            }
            val pause = fun(){
                if (!isSrcValid()) {
                    return
                }
                context.value?.pause(LivePlayerOptions(success = fun(res){
                    console.log("pause", JSON.stringify(res))
                }
                , fail = fun(err){
                    console.log("pause", JSON.stringify(err))
                }
                , complete = fun(res){
                    console.log("pause", JSON.stringify(res))
                }
                ))
            }
            val resume = fun(){
                if (!isSrcValid()) {
                    return
                }
                context.value?.resume(LivePlayerOptions(success = fun(res){
                    console.log("resume", JSON.stringify(res))
                }
                , fail = fun(err){
                    console.log("resume", JSON.stringify(err))
                }
                , complete = fun(res){
                    console.log("resume", JSON.stringify(res))
                }
                ))
            }
            val stop = fun(){
                if (!isSrcValid()) {
                    return
                }
                context.value?.stop(LivePlayerOptions(success = fun(res){
                    console.log("stop", JSON.stringify(res))
                }
                , fail = fun(err){
                    console.log("stop", JSON.stringify(err))
                }
                , complete = fun(res){
                    console.log("stop", JSON.stringify(res))
                }
                ))
            }
            val mute = fun(){
                if (!isSrcValid()) {
                    return
                }
                context.value?.mute(LivePlayerOptions(success = fun(res){
                    console.log("mute", JSON.stringify(res))
                }
                , fail = fun(err){
                    console.log("mute", JSON.stringify(err))
                }
                , complete = fun(res){
                    console.log("mute", JSON.stringify(res))
                }
                ))
            }
            val requestFullScreen = fun(){
                if (!isSrcValid()) {
                    return
                }
                context.value?.requestFullScreen(LivePlayerOptions(success = fun(res){
                    console.log("requestFullScreen", JSON.stringify(res))
                }
                , fail = fun(err){
                    console.log("requestFullScreen", JSON.stringify(err))
                }
                , complete = fun(res){
                    console.log("requestFullScreen", JSON.stringify(res))
                }
                ))
            }
            val exitFullScreen = fun(){
                if (!isSrcValid()) {
                    return
                }
                context.value?.exitFullScreen(LivePlayerOptions(success = fun(res){
                    console.log("exitFullScreen", JSON.stringify(res))
                }
                , fail = fun(err){
                    console.log("exitFullScreen", JSON.stringify(err))
                }
                , complete = fun(res){
                    console.log("exitFullScreen", JSON.stringify(res))
                }
                ))
            }
            val objectFitItemTypes = _uA<ItemType>(ItemType(value = 0, name = "contain"), ItemType(value = 1, name = "fillCrop"))
            val objectFitItems = _uA(
                "contain",
                "fillCrop"
            )
            val soundModeItemTypes = _uA<ItemType>(ItemType(value = 0, name = "speaker"), ItemType(value = 1, name = "ear"))
            val soundModeItems = _uA(
                "speaker",
                "ear"
            )
            val orientationItemTypes = _uA<ItemType>(ItemType(value = 0, name = "vertical"), ItemType(value = 1, name = "horizontal"))
            val orientationItems = _uA(
                "vertical",
                "horizontal"
            )
            val onSrcComfirm = fun(event: UniInputConfirmEvent){
                var value = event.detail.value
                if (value == "") {
                    return
                }
                src.value = value
                console.log("src ->", value)
            }
            val onAutoplayChange = fun(value: Boolean){
                autoplay.value = value
                console.log("autoplay ->", autoplay.value)
            }
            val onMutedChange = fun(value: Boolean){
                muted.value = value
                console.log("muted ->", muted.value)
            }
            val onBackgroundMuteChange = fun(value: Boolean){
                backgroundMute.value = value
                console.log("background-mute ->", backgroundMute.value)
            }
            val onObjectFitChange = fun(value: Number){
                objectFit.value = objectFitItems[value]
                console.log("object-fit ->", objectFit.value)
            }
            val onSoundModeChange = fun(value: Number){
                soundMode.value = soundModeItems[value]
                console.log("sound-mode ->", soundMode.value)
            }
            val onOrientationChange = fun(value: Number){
                orientation.value = orientationItems[value]
                console.log("orientation ->", orientation.value)
            }
            return fun(): Any? {
                val _component_live_player = resolveComponent("live-player")
                val _component_boolean_data = resolveEasyComponent("boolean-data", GenComponentsBooleanDataBooleanDataClass)
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                return _cE("view", _uM("class" to "uni-flex-item"), _uA(
                    _cV(_component_live_player, _uM("id" to "live-player", "class" to "live-player", "src" to unref(src), "autoplay" to unref(autoplay), "muted" to unref(muted), "object-fit" to unref(objectFit), "background-mute" to unref(backgroundMute), "sound-mode" to unref(soundMode), "orientation" to unref(orientation), "onStatechange" to statechange, "onFullscreenchange" to fullscreenchange, "onError" to error), null, 8, _uA(
                        "src",
                        "autoplay",
                        "muted",
                        "object-fit",
                        "background-mute",
                        "sound-mode",
                        "orientation"
                    )),
                    _cE("scroll-view", _uM("class" to "uni-padding-wrap uni-common-mt uni-flex-item"), _uA(
                        _cE("view", _uM("class" to "uni-title"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "API示例")
                        )),
                        _cE("view", _uM("class" to "uni-btn-v"), _uA(
                            _cE("button", _uM("type" to "primary", "onClick" to play, "disabled" to unref(playState)), "播放", 8, _uA(
                                "disabled"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-btn-v"), _uA(
                            _cE("button", _uM("type" to "primary", "onClick" to pause, "disabled" to !unref(playState)), "暂停", 8, _uA(
                                "disabled"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-btn-v"), _uA(
                            _cE("button", _uM("type" to "primary", "onClick" to resume, "disabled" to (unref(initState) || unref(playState) || unref(stopState))), "恢复", 8, _uA(
                                "disabled"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-btn-v"), _uA(
                            _cE("button", _uM("type" to "primary", "onClick" to stop, "disabled" to !unref(playState)), "停止", 8, _uA(
                                "disabled"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-btn-v"), _uA(
                            _cE("button", _uM("type" to "primary", "onClick" to mute, "disabled" to !unref(playState)), "静音", 8, _uA(
                                "disabled"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-btn-v"), _uA(
                            _cE("button", _uM("type" to "primary", "onClick" to requestFullScreen, "disabled" to !unref(playState)), "进入全屏", 8, _uA(
                                "disabled"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-btn-v"), _uA(
                            _cE("button", _uM("type" to "primary", "onClick" to exitFullScreen, "disabled" to !unref(playState)), "退出全屏", 8, _uA(
                                "disabled"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-title"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "属性示例")
                        )),
                        _cE("input", _uM("class" to "input margin-10", "type" to "string", "placeholder" to "设置播放地址", "onConfirm" to onSrcComfirm), null, 32),
                        _cV(_component_boolean_data, _uM("title" to "设置是否自动播放", "defaultValue" to unref(autoplay), "onChange" to onAutoplayChange), null, 8, _uA(
                            "defaultValue"
                        )),
                        _cV(_component_boolean_data, _uM("title" to "设置是否静音", "defaultValue" to unref(muted), "onChange" to onMutedChange), null, 8, _uA(
                            "defaultValue"
                        )),
                        _cV(_component_boolean_data, _uM("title" to "设置进入后台时是否静音", "defaultValue" to unref(backgroundMute), "onChange" to onBackgroundMuteChange), null, 8, _uA(
                            "defaultValue"
                        )),
                        _cV(_component_enum_data, _uM("title" to "设置填充模式", "items" to objectFitItemTypes, "onChange" to onObjectFitChange)),
                        _cV(_component_enum_data, _uM("title" to "设置声音输出方式", "items" to soundModeItemTypes, "onChange" to onSoundModeChange)),
                        _cV(_component_enum_data, _uM("title" to "设置画面方向", "items" to orientationItemTypes, "onChange" to onOrientationChange))
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
                return _uM("live-player" to _pS(_uM("width" to "100%", "height" to "40%")), "input" to _pS(_uM("height" to 40, "backgroundImage" to "none", "backgroundColor" to "#FFFFFF", "paddingTop" to 8, "paddingRight" to 13, "paddingBottom" to 8, "paddingLeft" to 13)), "margin-10" to _pS(_uM("marginTop" to 10, "marginRight" to 10, "marginBottom" to 10, "marginLeft" to 10)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
