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
import uts.sdk.modules.limeSvg.NativeImage
import io.dcloud.uniapp.extapi.downloadFile as uni_downloadFile
open class GenUniModulesLimeSvgComponentsLSvgLSvg : VueComponent, LSvpProps {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    override var src: String by `$props`
    override var color: String by `$props`
    override var web: Boolean by `$props`
    override var inherit: Boolean by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesLimeSvgComponentsLSvgLSvg) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesLimeSvgComponentsLSvgLSvg
            val _cache = __ins.renderCache
            var nativeImage: NativeImage? = null
            val props = __props
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val path = ref(props.src)
            val svgRef = ref<UniElement?>(null)
            val imageURL = ref("")
            val formatUrl = fun(url: String, action: String): String {
                if (url.indexOf("'") > 0) {
                    return "" + action + "(\"" + url + "\")"
                }
                return "" + action + "('" + url + "')"
            }
            val styles = computed(fun(): Map<String, String> {
                val style = Map<String, String>()
                if (props.color != "") {
                    style.set("color", props.color)
                }
                return style
            }
            )
            val errorDetaill = UniImageErrorEventDetail("加载失败")
            val errorEvent = UniImageErrorEvent("error", errorDetaill)
            val onError = fun(){
                emit("error", errorEvent)
            }
            val onLoad__1 = fun(e: UniNativeViewEvent){
                val detail = ImageLoadEventDetail(512, 512)
                val loadEvent = UniImageLoadEvent("load", detail)
                emit("load", loadEvent)
            }
            val webRef = ref<UniWebViewElement?>(null)
            val setSvgSrc = fun(){
                if (path.value != "") {
                    webRef.value?.evalJS(formatUrl(path.value, "setSrc"))
                }
            }
            val setSvgColor = fun(){
                if (props.color != "" && path.value != "") {
                    webRef.value?.evalJS("setStyle({\"--color\": \"" + props.color + "\"})")
                }
            }
            val error = fun(_: UniWebViewErrorEvent){
                emit("error", errorEvent)
            }
            val loaded = fun(_: UniWebViewLoadEvent){
                watchEffect(fun(){
                    if (props.src == "" || !props.web) {
                        return
                    }
                    if (props.src.startsWith("<svg")) {
                        path.value = svgToDataUrl(props.src)
                        setSvgSrc()
                        setSvgColor()
                    } else if (props.src.startsWith("/static")) {
                        pathToDataUrl(props.src).then(fun(res){
                            path.value = res
                            setSvgSrc()
                            setSvgColor()
                        }).`catch`(fun(err){
                            emit("error", errorEvent)
                            console.warn("[lime-svg]" + props.src + JSON.stringify(err))
                        })
                    } else {
                        path.value = props.src
                        setSvgSrc()
                        setSvgColor()
                    }
                }
                )
            }
            val message = fun(event: UniWebViewMessageEvent){
                val data = UTSJSONObject.assign(_uO(), event.detail.data[0] as UTSJSONObject)
                val type = data.getString("event")
                val detail = data.getJSON("data")?.getJSON("detail")
                if (type == "click") {
                    emit("click")
                } else if (type == "load") {
                    val width = detail?.getNumber("width") ?: 512
                    val height = detail?.getNumber("height") ?: 512
                    val loadDetail = ImageLoadEventDetail(width, height)
                    val loadEvent = UniImageLoadEvent("load", loadDetail)
                    emit(type, loadEvent)
                } else if (type == "error") {
                    emit(type, errorEvent)
                }
            }
            fun gen_onviewinit_fn(e: UniNativeViewInitEvent) {
                nativeImage = NativeImage(e.detail.element)
                nativeImage?.updateSrc(path.value)
                nativeImage?.updateColor(props.color)
            }
            val onviewinit = ::gen_onviewinit_fn
            val map = Map<String, String>()
            watchEffect(fun(){
                if (!props.web && props.src.startsWith("http")) {
                    if (map.has(props.src)) {
                        nativeImage?.updateSrc(map.get(props.src)!!)
                        return
                    }
                    uni_downloadFile(DownloadFileOptions(url = props.src, success = fun(res) {
                        path.value = res.tempFilePath
                        map.set(props.src, res.tempFilePath)
                        nativeImage?.updateSrc(res.tempFilePath)
                    }, fail = fun(err) {}))
                } else {
                    path.value = props.src
                    nativeImage?.updateSrc(props.src)
                }
            }
            )
            watchEffect(fun(){
                if (props.color == "") {
                    return
                }
                nativeImage?.updateColor(props.color)
            }
            )
            return fun(): Any? {
                val _component_web_view = resolveComponent("web-view")
                return if (isTrue(_ctx.web)) {
                    _cV(_component_web_view, _uM("key" to 0, "class" to "l-svg", "ref_key" to "webRef", "ref" to webRef, "onError" to error, "onLoad" to loaded, "onMessage" to message, "src" to "/uni_modules/lime-svg/hybrid/html/index.html?v=21"), null, 512)
                } else {
                    _cE("native-view", mergeProps(_uM("key" to 1, "class" to "l-svg"), _ctx.`$attrs`, _uM("onInit" to onviewinit, "onError" to onError, "onLoad" to onLoad__1)), null, 16)
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
                return _uM("l-svg" to _pS(_uM("width" to 24, "height" to 24)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("load" to null, "error" to null)
        var props = _nP(_uM("src" to _uM("type" to "String", "required" to true, "default" to ""), "color" to _uM("type" to "String", "required" to true, "default" to ""), "web" to _uM("type" to "Boolean", "required" to true, "default" to false), "inherit" to _uM("type" to "Boolean", "required" to true, "default" to false)))
        var propsNeedCastKeys = _uA(
            "src",
            "color",
            "web",
            "inherit"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
