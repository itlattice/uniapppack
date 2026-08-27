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
import io.dcloud.uniapp.extapi.createInnerAudioContext as uni_createInnerAudioContext
import io.dcloud.uniapp.extapi.getBackgroundAudioManager as uni_getBackgroundAudioManager
import io.dcloud.uniapp.extapi.setInnerAudioOption as uni_setInnerAudioOption
open class GenPagesAPISetInnerAudioOptionSetInnerAudioOption : BasePage {
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
    open var data: DataType__107
        get() {
            return unref(this.`$exposed`["data"]) as DataType__107
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var playBackgroundMusic: () -> Unit
        get() {
            return unref(this.`$exposed`["playBackgroundMusic"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "playBackgroundMusic", value)
        }
    open var testInnerAudioOption: () -> Unit
        get() {
            return unref(this.`$exposed`["testInnerAudioOption"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "testInnerAudioOption", value)
        }
    open var playInnerMusic: () -> Unit
        get() {
            return unref(this.`$exposed`["playInnerMusic"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "playInnerMusic", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPISetInnerAudioOptionSetInnerAudioOption, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPISetInnerAudioOptionSetInnerAudioOption
            val _cache = __ins.renderCache
            val data = reactive(DataType__107(isBackgroundAudioPaused = false, mixWithOther = true, speakerOn = true, obeyMuteSwitch = true))
            val backgroundManager = ref<BackgroundAudioManager?>(null)
            val innerAudio = ref<InnerAudioContext?>(null)
            onUnload(fun(){
                backgroundManager.value?.stop()
                innerAudio.value?.stop()
                innerAudio.value?.destroy()
            }
            )
            fun gen_playBackgroundMusic_fn() {
                if (backgroundManager.value == null) {
                    backgroundManager.value = uni_getBackgroundAudioManager()
                    backgroundManager.value!!.onPause(fun(_result){
                        data.isBackgroundAudioPaused = true
                    })
                } else {
                    backgroundManager.value!!.stop()
                }
                backgroundManager.value!!.src = "https://web-ext-storage.dcloud.net.cn/uni-app/ForElise.mp3"
                backgroundManager.value!!.coverImgUrl = "https://qiniu-web-assets.dcloud.net.cn/unidoc/zh/music-a.png"
                backgroundManager.value!!.play()
            }
            val playBackgroundMusic = ::gen_playBackgroundMusic_fn
            fun gen_pauseBackgroundMusic_fn() {
                backgroundManager.value?.pause()
            }
            val pauseBackgroundMusic = ::gen_pauseBackgroundMusic_fn
            fun gen_stopBackgroundMusic_fn() {
                backgroundManager.value?.stop()
            }
            val stopBackgroundMusic = ::gen_stopBackgroundMusic_fn
            fun gen_playInnerMusic_fn() {
                if (innerAudio.value == null) {
                    innerAudio.value = uni_createInnerAudioContext()
                } else {
                    innerAudio.value!!.stop()
                }
                innerAudio.value!!.src = "https://web-ext-storage.dcloud.net.cn/uni-app/ForElise.mp3"
                innerAudio.value!!.play()
            }
            val playInnerMusic = ::gen_playInnerMusic_fn
            fun gen_pauseInnerMusic_fn() {
                innerAudio.value?.pause()
            }
            val pauseInnerMusic = ::gen_pauseInnerMusic_fn
            fun gen_stopInnerMusic_fn() {
                innerAudio.value?.stop()
            }
            val stopInnerMusic = ::gen_stopInnerMusic_fn
            fun gen_handleRadioChange_fn(event: UniRadioGroupChangeEvent, propertyName: String) {
                val value = event.detail.value == "1"
                when (propertyName) {
                    "mixWithOther" -> 
                        data.mixWithOther = value
                    "speakerOn" -> 
                        data.speakerOn = value
                    "obeyMuteSwitch" -> 
                        data.obeyMuteSwitch = value
                }
                uni_setInnerAudioOption(SetInnerAudioOptionOptions(mixWithOther = data.mixWithOther, speakerOn = data.speakerOn, obeyMuteSwitch = data.obeyMuteSwitch))
            }
            val handleRadioChange = ::gen_handleRadioChange_fn
            fun gen_testInnerAudioOption_fn() {
                uni_setInnerAudioOption(SetInnerAudioOptionOptions(mixWithOther = false))
            }
            val testInnerAudioOption = ::gen_testInnerAudioOption_fn
            __expose(_uM("data" to data, "playBackgroundMusic" to playBackgroundMusic, "testInnerAudioOption" to testInnerAudioOption, "playInnerMusic" to playInnerMusic))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                val _component_radio = resolveComponent("radio")
                val _component_radio_group = resolveComponent("radio-group")
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cV(_component_page_head, _uM("title" to "setInnerAudioOption")),
                    _cE("text", _uM("class" to "labelText"), "是否允许与其他音频同时播放"),
                    _cV(_component_radio_group, _uM("class" to "uni-flex radioGroup", "onChange" to fun(event: UniRadioGroupChangeEvent){
                        return handleRadioChange(event, "mixWithOther")
                    }
                    ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cV(_component_radio, _uM("value" to "1", "checked" to true), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    "是"
                                )
                            }
                            ), "_" to 1)),
                            _cV(_component_radio, _uM("value" to "0", "class" to "radioItem"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    "否"
                                )
                            }
                            ), "_" to 1))
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "onChange"
                    )),
                    _cE("text", _uM("class" to "labelText"), "是否允许扬声器播放"),
                    _cV(_component_radio_group, _uM("class" to "uni-flex radioGroup", "onChange" to fun(event: UniRadioGroupChangeEvent){
                        return handleRadioChange(event, "speakerOn")
                    }
                    ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cV(_component_radio, _uM("value" to "1", "checked" to true), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    "是"
                                )
                            }
                            ), "_" to 1)),
                            _cV(_component_radio, _uM("value" to "0", "class" to "radioItem"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    "否"
                                )
                            }
                            ), "_" to 1))
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "onChange"
                    )),
                    _cE("view", _uM("class" to "buttonContainer"), _uA(
                        _cE("button", _uM("onClick" to playBackgroundMusic, "type" to "primary", "class" to "radioGroup"), "播放背景音频"),
                        _cE("button", _uM("onClick" to pauseBackgroundMusic, "type" to "primary", "class" to "radioGroup"), "暂停背景音频"),
                        _cE("button", _uM("onClick" to stopBackgroundMusic, "type" to "primary", "class" to "radioGroup"), "停止背景音频"),
                        _cE("button", _uM("onClick" to playInnerMusic, "type" to "primary", "class" to "radioGroup"), "播放音频"),
                        _cE("button", _uM("onClick" to pauseInnerMusic, "type" to "primary", "class" to "radioGroup"), "暂停音频"),
                        _cE("button", _uM("onClick" to stopInnerMusic, "type" to "primary", "class" to "radioGroup"), "停止音频")
                    )),
                    _cE("view", _uM("style" to _nS(_uM("padding" to "16px 8px"))), _uA(
                        _cE("text", null, "1. uni.setInnerAudioOption需要与uni.createInnerAudioContext搭配才会生效 \n "),
                        _cE("text", null, "2. 设置mixWithOther为true时，会暂停其他App的音频和背景音频 \n"),
                        _cE("text", null, "3. speakerOn参数：Android不支持在播放音频的过程中切换为扬声器播放，iOS支持播放状态时动态切换 \n"),
                        _cE("text", null, "4. obeyMuteSwitch参数：仅支持iOS")
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
                return _uM("labelText" to _pS(_uM("marginLeft" to 8)), "radioGroup" to _pS(_uM("marginTop" to 8, "marginRight" to 8, "marginBottom" to 8, "marginLeft" to 8)), "radioItem" to _pS(_uM("marginLeft" to 16)), "buttonContainer" to _pS(_uM("paddingTop" to 8, "paddingRight" to 8, "paddingBottom" to 8, "paddingLeft" to 8)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
