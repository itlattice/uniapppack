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
open class GenPagesAPICreateInnerAudioContextInnerAudioMult : BasePage {
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
        var setup: (__props: GenPagesAPICreateInnerAudioContextInnerAudioMult) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPICreateInnerAudioContextInnerAudioMult
            val _cache = __ins.renderCache
            val title = ref("多音频同时播放")
            val _audioContext1 = ref<InnerAudioContext?>(null)
            val src = ref("https://web-ext-storage.dcloud.net.cn/uni-app/ForElise.mp3")
            val _audioContext2 = ref<InnerAudioContext?>(null)
            val playing1 = ref(false)
            val playing2 = ref(false)
            val currentTime1 = ref(0)
            val currentTime2 = ref(0)
            fun gen_play1_fn() {
                if (_audioContext1.value != null) {
                    currentTime1.value = 0
                    if (playing1.value) {
                        _audioContext1.value!!.stop()
                    } else {
                        _audioContext1.value!!.play()
                    }
                }
                playing1.value = !playing1.value
            }
            val play1 = ::gen_play1_fn
            fun gen_play2_fn() {
                if (_audioContext2.value != null) {
                    currentTime2.value = 0
                    if (playing2.value) {
                        _audioContext2.value!!.stop()
                    } else {
                        _audioContext2.value!!.play()
                    }
                }
                playing2.value = !playing2.value
            }
            val play2 = ::gen_play2_fn
            onReady(fun(){
                _audioContext1.value = uni_createInnerAudioContext()
                _audioContext1.value!!.src = src.value
                _audioContext1.value!!.onTimeUpdate(fun(res){
                    currentTime1.value = _audioContext1.value!!.currentTime
                }
                )
                _audioContext2.value = uni_createInnerAudioContext()
                _audioContext2.value!!.src = src.value
                _audioContext2.value!!.onTimeUpdate(fun(res){
                    currentTime2.value = _audioContext2.value!!.currentTime
                }
                )
            }
            )
            onUnload(fun(){
                if (_audioContext1.value != null) {
                    _audioContext1.value!!.stop()
                    _audioContext1.value!!.destroy()
                }
                if (_audioContext2.value != null) {
                    _audioContext2.value!!.stop()
                    _audioContext2.value!!.destroy()
                }
            }
            )
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE(Fragment, null, _uA(
                    _cV(_component_page_head, _uM("title" to unref(title)), null, 8, _uA(
                        "title"
                    )),
                    _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt"), _uA(
                        _cE("view", _uM("class" to "uni-title"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "多音频同时播放")
                        )),
                        _cE("button", _uM("type" to "primary", "onClick" to fun(){
                            play1()
                        }
                        , "class" to "uni-btn"), " 播放/停止(进度：" + _tD(unref(currentTime1)) + ")", 9, _uA(
                            "onClick"
                        )),
                        _cE("button", _uM("type" to "primary", "onClick" to fun(){
                            play2()
                        }
                        , "class" to "uni-btn"), " 播放/停止(进度：" + _tD(unref(currentTime2)) + ")", 9, _uA(
                            "onClick"
                        ))
                    ))
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
                return _uM("formats" to _pS(_uM("alignItems" to "center")), "icon-play" to _pS(_uM("width" to 60, "height" to 60, "marginTop" to 10, "marginRight" to 10, "marginBottom" to 10, "marginLeft" to 10)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
