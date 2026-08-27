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
open class GenPagesComponentVideoVideoFormat : BasePage {
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
    open var isError: UTSJSONObject
        get() {
            return unref(this.`$exposed`["isError"]) as UTSJSONObject
        }
        set(value) {
            setRefValue(this.`$exposed`, "isError", value)
        }
    open var autoTestData: UTSJSONObject
        get() {
            return unref(this.`$exposed`["autoTestData"]) as UTSJSONObject
        }
        set(value) {
            setRefValue(this.`$exposed`, "autoTestData", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentVideoVideoFormat, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentVideoVideoFormat
            val _cache = __ins.renderCache
            var supportFormats = ref(_uA<VideoFormat>(VideoFormat(format = "mp4", src = "https://web-ext-storage.dcloud.net.cn/video/sample/2minute-demo.mp4"), VideoFormat(format = "m4v", src = "https://qiniu-web-assets.dcloud.net.cn/video/sample/2minute-demo.m4v"), VideoFormat(format = "mov", src = "https://qiniu-web-assets.dcloud.net.cn/video/sample/2minute-demo.mov"), VideoFormat(format = "webm（iOS、Safari、鸿蒙不支持）", src = "https://qiniu-web-assets.dcloud.net.cn/video/sample/2minute-demo.webm"), VideoFormat(format = "3gp", src = "https://qiniu-web-assets.dcloud.net.cn/video/sample/2minute-demo.3gp"), VideoFormat(format = "flv", src = "https://qiniu-web-assets.dcloud.net.cn/video/sample/2minute-demo.flv"), VideoFormat(format = "m3u8", src = "https://qiniu-web-assets.dcloud.net.cn/video/sample/2minute-demo.m3u8"), VideoFormat(format = "本地m3u8", src = "/static/test-video/2minute-demo.m3u8"), VideoFormat(format = "错误路径", src = "https://www.dcloud.net.cn/errorpath.mp4")))
            var notSupportFormats = ref(_uA<VideoFormat>(VideoFormat(format = "ogg", src = "https://qiniu-web-assets.dcloud.net.cn/video/sample/2minute-demo.ogg"), VideoFormat(format = "avi", src = "https://qiniu-web-assets.dcloud.net.cn/video/sample/2minute-demo.avi")))
            val autoTestData = reactive(_uO("autoTest" to false))
            val isError = reactive(_uO("value" to false))
            val onError__1 = fun(format: String, e: UniVideoErrorEvent){
                console.log(format + ":" + JSON.stringify(e))
                if (format != "错误路径") {
                    isError["value"] = true
                }
            }
            onReady(fun(){})
            __expose(_uM("isError" to isError, "autoTestData" to autoTestData))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE("scroll-view", _uM("class" to "page-scroll-view"), _uA(
                    _cV(_component_page_head, _uM("title" to "video-format")),
                    if (isTrue(unref(autoTestData)["autoTest"])) {
                        _cE("image", _uM("key" to 0, "src" to "/static/logo_square.jpeg", "style" to _nS(_uM("width" to "50px", "height" to "50px"))), null, 4)
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt"), _uA(
                        _cE("view", _uM("class" to "uni-title"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "支持的视频格式示例")
                        )),
                        _cE(Fragment, null, RenderHelpers.renderList(unref(supportFormats), fun(item, index, __index, _cached): Any {
                            return _cE("view", _uM("key" to index), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), _tD(item.format), 1),
                                _cE("video", _uM("id" to ("video-" + item.format), "class" to "video", "src" to item.src, "controls" to true, "direction" to -90, "onError" to fun(`$event`: Any){
                                    onError__1(item.format, `$event` as UniVideoErrorEvent)
                                }
                                ), null, 40, _uA(
                                    "id",
                                    "src",
                                    "onError"
                                ))
                            ))
                        }
                        ), 128),
                        _cE("view", _uM("class" to "uni-title"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "暂不支持的格式")
                        )),
                        _cE(Fragment, null, RenderHelpers.renderList(unref(notSupportFormats), fun(item, index, __index, _cached): Any {
                            return _cE("view", _uM("key" to index), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), _tD(item.format), 1),
                                _cE("video", _uM("id" to ("video-" + item.format), "ref_for" to true, "ref" to ("videoRef-" + item.format), "class" to "video", "src" to item.src, "controls" to true, "direction" to -90), null, 8, _uA(
                                    "id",
                                    "src"
                                ))
                            ))
                        }
                        ), 128)
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
                return _uM("video" to _pS(_uM("height" to 200)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
