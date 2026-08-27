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
open class GenPagesComponentListViewListViewMultiplexVideo : BasePage {
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
    open var data: DataType__14
        get() {
            return unref(this.`$exposed`["data"]) as DataType__14
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentListViewListViewMultiplexVideo, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentListViewListViewMultiplexVideo
            val _cache = __ins.renderCache
            val data = reactive(DataType__14(item_count = 10, src = "https://qiniu-web-assets.dcloud.net.cn/video/sample/2minute-demo.mp4", isTesting = false))
            fun gen_onPlay_fn(e: UniEvent) {
                console.log("onPlay", JSON.stringify(e.timeStamp))
            }
            val onPlay = ::gen_onPlay_fn
            fun gen_onPause_fn(e: UniEvent) {
                console.log("onPause", JSON.stringify(e.timeStamp))
            }
            val onPause = ::gen_onPause_fn
            fun gen_onScrollTolower_fn(event: ScrollToLowerEvent) {
                setTimeout(fun(){
                    if (data.isTesting && data.item_count >= 10) {
                        return
                    }
                    data.item_count += 10
                }
                , 300)
            }
            val onScrollTolower = ::gen_onScrollTolower_fn
            __expose(_uM("data" to data))
            return fun(): Any? {
                return _cE("list-view", _uM("class" to "list", "onScrolltolower" to onScrollTolower), _uA(
                    _cE(Fragment, null, RenderHelpers.renderList(unref(data).item_count, fun(_, index, __index, _cached): Any {
                        return _cE("list-item", _uM("class" to "list-item", "key" to index), _uA(
                            _cE("text", null, "第" + _tD(index + 1) + "个视频", 1),
                            _cE("video", _uM("class" to "video", "src" to unref(data).src, "controls" to true, "onPlay" to onPlay, "onPause" to onPause), null, 40, _uA(
                                "src"
                            ))
                        ))
                    }
                    ), 128)
                ), 32)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("list" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "list-item" to _pS(_uM("backgroundColor" to "#FFFFFF", "marginBottom" to 30)), "video" to _pS(_uM("width" to "100%", "height" to 200)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
