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
import io.dcloud.uniapp.extapi.createCanvasContextAsync as uni_createCanvasContextAsync
import io.dcloud.uniapp.extapi.createSelectorQuery as uni_createSelectorQuery
open class GenUniModulesTmxUiComponentsTmxTreeFlatTmxTreeFlat : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var canvasWidth: Number by `$props`
    open var canvasHeight: Number by `$props`
    open var width: String by `$props`
    open var height: String by `$props`
    open var list: UTSArray<XTREEFLAT_NODES> by `$props`
    open var opts: XTreeFlatOpts by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    open var setData: (list: UTSArray<XTREEFLAT_NODES>) -> Unit
        get() {
            return unref(this.`$exposed`["setData"]) as (list: UTSArray<XTREEFLAT_NODES>) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setData", value)
        }
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesTmxUiComponentsTmxTreeFlatTmxTreeFlat, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesTmxUiComponentsTmxTreeFlatTmxTreeFlat
            val _cache = __ins.renderCache
            val xTreeFlatBox = ref<UniElement?>(null)
            val id = "xTreeFlat-" + Math.random().toString(16).substring(4, 20)
            val proxy = getCurrentInstance()?.proxy ?: null
            val scrollLeft = ref(0)
            val scrollTop = ref(0)
            val scrollLeft_onlyRead = ref(0)
            val scrollTop_onlyRead = ref(0)
            val boxNodeinfo = ref<NodeInfo?>(null)
            var tid: Number = 23
            val props = __props
            val _width = computed(fun(): String {
                return checkIsCssUnit(props.width, xConfig.unit)
            }
            )
            val _height = computed(fun(): String {
                return checkIsCssUnit(props.height, xConfig.unit)
            }
            )
            val render = ref<OrgChartRenderer?>(null)
            val canvasWidth = ref(props.canvasWidth)
            val canvasHeight = ref(props.canvasHeight)
            val keyids = ref(23)
            fun emits(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val setScrollPosition = fun(){}
            val setData = fun(list: UTSArray<XTREEFLAT_NODES>){
                if (render == null || boxNodeinfo.value == null) {
                    console.error("render未初始化")
                    return
                }
                render.value!!.setData(list)
                var dboxwidth = render.value!!.getDrawBounds()
                scrollTop_onlyRead.value = scrollTop.value
                scrollLeft_onlyRead.value = scrollLeft.value
                scrollTop.value = dboxwidth.y - (boxNodeinfo.value!!.height!! - dboxwidth.height) / 2
                scrollLeft.value = dboxwidth.x - (boxNodeinfo.value!!.width!! - dboxwidth.width) / 2
                setScrollPosition()
            }
            val onScrollTop = fun(evt: UniScrollEvent){
                scrollTop_onlyRead.value = evt.detail.scrollTop
            }
            val onScrollLeft = fun(evt: UniScrollEvent){
                scrollLeft_onlyRead.value = evt.detail.scrollLeft
            }
            val onclickCanvas = fun(evt: UniPointerEvent){
                if (render.value == null || boxNodeinfo.value == null) {
                    return
                }
                render.value!!.addEventClick(evt, scrollTop_onlyRead.value, scrollLeft_onlyRead.value)
            }
            val onRenderClick = fun(item: XTREEFLAT_CHILDREN){
                emits("click", item)
            }
            val onInit = fun(): UTSPromise<Any> {
                return UTSPromise(fun(_resolve, _reject){
                    uni_createSelectorQuery().`in`(proxy).select(".xTreeFlatBox").boundingClientRect().exec(fun(result){
                        if (result.length == 0) {
                            return
                        }
                        var node = result[0]!! as NodeInfo
                        canvasWidth.value = Math.max(props.canvasWidth, node.width!!)
                        canvasHeight.value = Math.max(props.canvasHeight, node.height!!)
                        keyids.value += 10
                        nextTick(fun(){
                            uni_createCanvasContextAsync(CreateCanvasContextAsyncOptions(id = id, component = proxy, success = fun(context: CanvasContext){
                                var opts = XTreeFlatOpts()
                                if (props.opts != null) {
                                    opts = props.opts!! as XTreeFlatOpts
                                }
                                render.value = OrgChartRenderer(XTREEFLAT_CONFIG(width = canvasWidth.value, height = canvasHeight.value, canvas = context, nodeInfo = node, bgColor = opts?.bgColor, nodeBgColor = opts?.nodeBgColor, fontColor = opts?.fontColor, fontSize = opts?.fontSize, lineColor = opts?.lineColor, lineWidth = opts?.lineWidth, padding = opts?.padding, gutter = opts?.gutter, parentLineGutter = opts?.parentLineGutter, enbleOpenChildren = opts?.enbleOpenChildren, nodeRadius = opts?.nodeRadius, layout = opts?.layout, lineType = opts?.lineType))
                                boxNodeinfo.value = node
                                render.value!!.onListen(onRenderClick)
                                if (props.list.length > 0) {
                                    setData(props.list)
                                }
                                emits("init")
                            }
                            ))
                        }
                        )
                    }
                    )
                }
                )
            }
            watch(fun(): XTreeFlatOpts? {
                return props.opts
            }
            , fun(){
                if (render.value == null) {
                    onInit()
                    return
                }
                render.value!!.mergeOpts(props.opts ?: null)
                if (props.list.length > 0) {
                    setData(props.list)
                } else {
                    render.value!!.relayoutFromCurrentData()
                }
            }
            , WatchOptions(deep = true))
            onMounted(fun(){
                clearTimeout(tid)
                tid = setTimeout(fun() {
                    onInit()
                }
                , 50)
            }
            )
            onBeforeUnmount(fun(){
                clearTimeout(tid)
            }
            )
            __expose(_uM("setData" to setData))
            return fun(): Any? {
                return _cE("scroll-view", _uM("onScroll" to onScrollTop, "class" to "xTreeFlatBox", "scroll-top" to scrollTop.value, "scroll-y" to true, "direction" to "vertical", "style" to _nS(_uM("width" to _width.value, "height" to _height.value))), _uA(
                    _cE("scroll-view", _uM("onScroll" to onScrollLeft, "scroll-left" to scrollLeft.value, "scroll-x" to true, "direction" to "horizontal", "style" to _nS(_uM("width" to _width.value, "height" to (canvasHeight.value + "px")))), _uA(
                        _cE("canvas", _uM("key" to keyids.value, "onClick" to onclickCanvas, "id" to id, "ref" to "canvas", "style" to _nS(_uM("width" to (canvasWidth.value + "px"), "height" to (canvasHeight.value + "px")))), null, 4)
                    ), 44, _uA(
                        "scroll-left"
                    ))
                ), 44, _uA(
                    "scroll-top"
                ))
            }
        }
        var name = "xTreeFlat"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("xTreeFlatBox" to _pS(_uM("position" to "relative")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("init" to null, "change" to null, "click" to null)
        var props = _nP(_uM("canvasWidth" to _uM("type" to "Number", "required" to true, "default" to 800), "canvasHeight" to _uM("type" to "Number", "required" to true, "default" to 800), "width" to _uM("type" to "String", "required" to true, "default" to "100%"), "height" to _uM("type" to "String", "required" to true, "default" to "600"), "list" to _uM("type" to "Array", "required" to true, "default" to _uA<XTREEFLAT_NODES>()), "opts" to _uM("type" to "XTreeFlatOpts", "required" to false, "default" to null as XTreeFlatOpts?)))
        var propsNeedCastKeys = _uA(
            "canvasWidth",
            "canvasHeight",
            "width",
            "height",
            "list",
            "opts"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
