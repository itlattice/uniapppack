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
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
import io.dcloud.uniapp.extapi.showToast as uni_showToast
import io.dcloud.uniapp.extapi.startPullDownRefresh as uni_startPullDownRefresh
import io.dcloud.uniapp.extapi.stopPullDownRefresh as uni_stopPullDownRefresh
open class GenPagesAPIGetCurrentPagesGetCurrentPages : BasePage {
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
    open var data: DataType__51
        get() {
            return unref(this.`$exposed`["data"]) as DataType__51
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var _getCurrentPages: () -> Unit
        get() {
            return unref(this.`$exposed`["_getCurrentPages"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "_getCurrentPages", value)
        }
    open var getPageStyle: () -> UTSJSONObject
        get() {
            return unref(this.`$exposed`["getPageStyle"]) as () -> UTSJSONObject
        }
        set(value) {
            setRefValue(this.`$exposed`, "getPageStyle", value)
        }
    open var setPageStyle: (style: UTSJSONObject) -> Unit
        get() {
            return unref(this.`$exposed`["setPageStyle"]) as (style: UTSJSONObject) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setPageStyle", value)
        }
    open var startPullDownRefresh: () -> Unit
        get() {
            return unref(this.`$exposed`["startPullDownRefresh"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "startPullDownRefresh", value)
        }
    open var `check$page`: () -> Boolean
        get() {
            return unref(this.`$exposed`["check\$page"]) as () -> Boolean
        }
        set(value) {
            setRefValue(this.`$exposed`, "check\$page", value)
        }
    open var `componentCheck$page`: () -> Boolean
        get() {
            return unref(this.`$exposed`["componentCheck\$page"]) as () -> Boolean
        }
        set(value) {
            setRefValue(this.`$exposed`, "componentCheck\$page", value)
        }
    open var checkGetParentPage: () -> Boolean
        get() {
            return unref(this.`$exposed`["checkGetParentPage"]) as () -> Boolean
        }
        set(value) {
            setRefValue(this.`$exposed`, "checkGetParentPage", value)
        }
    open var checkGetDialogPages: () -> Boolean
        get() {
            return unref(this.`$exposed`["checkGetDialogPages"]) as () -> Boolean
        }
        set(value) {
            setRefValue(this.`$exposed`, "checkGetDialogPages", value)
        }
    open var checkGetElementById: () -> Boolean
        get() {
            return unref(this.`$exposed`["checkGetElementById"]) as () -> Boolean
        }
        set(value) {
            setRefValue(this.`$exposed`, "checkGetElementById", value)
        }
    open var checkGetAndroidView: () -> Boolean
        get() {
            return unref(this.`$exposed`["checkGetAndroidView"]) as () -> Boolean
        }
        set(value) {
            setRefValue(this.`$exposed`, "checkGetAndroidView", value)
        }
    open var checkGetIOSView: () -> Boolean
        get() {
            return unref(this.`$exposed`["checkGetIOSView"]) as () -> Boolean
        }
        set(value) {
            setRefValue(this.`$exposed`, "checkGetIOSView", value)
        }
    open var checkGetHTMLElement: () -> Boolean
        get() {
            return unref(this.`$exposed`["checkGetHTMLElement"]) as () -> Boolean
        }
        set(value) {
            setRefValue(this.`$exposed`, "checkGetHTMLElement", value)
        }
    open var checkQuerySelector: () -> Boolean
        get() {
            return unref(this.`$exposed`["checkQuerySelector"]) as () -> Boolean
        }
        set(value) {
            setRefValue(this.`$exposed`, "checkQuerySelector", value)
        }
    open var checkQuerySelectorAll: () -> Boolean
        get() {
            return unref(this.`$exposed`["checkQuerySelectorAll"]) as () -> Boolean
        }
        set(value) {
            setRefValue(this.`$exposed`, "checkQuerySelectorAll", value)
        }
    open var checkGetAndroidActivity: () -> Boolean
        get() {
            return unref(this.`$exposed`["checkGetAndroidActivity"]) as () -> Boolean
        }
        set(value) {
            setRefValue(this.`$exposed`, "checkGetAndroidActivity", value)
        }
    open var checkTakeSnapshot: () -> Unit
        get() {
            return unref(this.`$exposed`["checkTakeSnapshot"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "checkTakeSnapshot", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIGetCurrentPagesGetCurrentPages, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIGetCurrentPagesGetCurrentPages
            val _cache = __ins.renderCache
            val currentInstance = getCurrentInstance()
            val componentCheckPage = ref<ComponentPublicInstance?>(null)
            val data = reactive(DataType__51(checked = false, pages = _uA<String>(), PageStyleArray = PageStyleArray, currentPageStyle = _uO(), testing = false, checkSnapshotResult = false))
            val pageStyleText = computed(fun(): String {
                return JSON.stringify(data.currentPageStyle)
            }
            )
            val getPageStyle = fun(): UTSJSONObject {
                val pages: UTSArray<UniPage> = getCurrentPages()
                val currentPage = pages[pages.length - 1]
                data.currentPageStyle = currentPage.getPageStyle()
                console.log(data.currentPageStyle)
                return data.currentPageStyle
            }
            val setPageStyle = fun(style: UTSJSONObject){
                console.log("setPageStyle:", style)
                val pages = getCurrentPages()
                val currentPage = pages[pages.length - 1]
                currentPage.setPageStyle(style)
            }
            onLoad(fun(_options){
                getPageStyle()
            }
            )
            onReady(fun(){
                setPageStyle(_uO("androidThreeButtonNavigationBackgroundColor" to "transparent", "androidThreeButtonNavigationStyle" to "black"))
                getPageStyle()
            }
            )
            onPullDownRefresh(fun(){
                setTimeout(fun(){
                    uni_stopPullDownRefresh()
                }
                , 2000)
            }
            )
            val startPullDownRefresh = fun(){
                uni_startPullDownRefresh(null)
            }
            val _getCurrentPages = fun(){
                data.pages.length = 0
                val pages = getCurrentPages()
                data.pages.push(pages[0].route)
                if (data.pages[0].includes("/tabBar/") || data.pages[0] == "/") {
                    data.checked = true
                }
                run {
                    var i: Number = 1
                    while(i < pages.length){
                        data.pages.push(pages[i].route)
                        if (pages[i].route.includes("/tabBar/")) {
                            data.checked = false
                        }
                        i++
                    }
                }
            }
            val setStyleValue = fun(key: String, value: Any){
                val style: UTSJSONObject = _uO()
                style[key] = value
                setPageStyle(style)
                getPageStyle()
            }
            val radioChange = fun(key: String, e: RadioGroupChangeEvent){
                setStyleValue(key, e.detail.value)
            }
            val sliderChange = fun(key: String, e: UniSliderChangeEvent){
                setStyleValue(key, e.detail.value)
            }
            val switchChange = fun(key: String, e: UniSwitchChangeEvent){
                setStyleValue(key, e.detail.value)
            }
            val goSetDisablePullDownRefresh = fun(){
                uni_navigateTo(NavigateToOptions(url = "/pages/API/get-current-pages/set-page-style-disable-pull-down-refresh"))
            }
            val getCurrentPage = fun(): UniPage {
                val pages = getCurrentPages()
                return pages[pages.length - 1]
            }
            val `check$page` = fun(): Boolean {
                val page = getCurrentPage()
                val `$page` = currentInstance?.proxy?.`$page`
                var res = `$page` === page
                if (data.testing && res) {
                    res = page.options["test"] == "123"
                    if (res) {
                        res = page.route == "pages/API/get-current-pages/get-current-pages"
                    }
                }
                console.log("check \$page", res)
                uni_showToast(if (res) {
                    ShowToastOptions(title = "check success")
                } else {
                    ShowToastOptions(title = "check fail", icon = "error")
                }
                )
                return res
            }
            val `componentCheck$page` = fun(): Boolean {
                val res = componentCheckPage.value?.`$callMethod`("check\$page") as Boolean
                console.log("component check \$page", res)
                return res
            }
            val checkGetParentPage = fun(): Boolean {
                val page = getCurrentPage()
                val parentPage = page.getParentPage()
                val res = parentPage == null
                console.log("check getParentPage", res)
                uni_showToast(if (res) {
                    ShowToastOptions(title = "check success")
                } else {
                    ShowToastOptions(title = "check fail", icon = "error")
                }
                )
                return res
            }
            val checkGetDialogPages = fun(): Boolean {
                val page = getCurrentPage()
                val dialogPages = page.getDialogPages()
                val res = UTSArray.isArray(dialogPages) && dialogPages.length == 0
                uni_showToast(if (res) {
                    ShowToastOptions(title = "check success")
                } else {
                    ShowToastOptions(title = "check fail", icon = "error")
                }
                )
                console.log("check getDialogPages", res)
                return res
            }
            val checkGetElementById = fun(): Boolean {
                val page = getCurrentPage()
                val element = page.getElementById("check-get-element-by-id-btn")
                var res = element != null
                console.log("check getElementById", res)
                uni_showToast(if (res) {
                    ShowToastOptions(title = "check success")
                } else {
                    ShowToastOptions(title = "check fail", icon = "error")
                }
                )
                return res
            }
            val checkGetAndroidView = fun(): Boolean {
                val page = getCurrentPage()
                val androidView = page.getAndroidView<android.view.View>()
                val res = androidView != null
                console.log("check getAndroidView", res)
                uni_showToast(if (res) {
                    ShowToastOptions(title = "check success")
                } else {
                    ShowToastOptions(title = "check fail", icon = "error")
                }
                )
                return res
            }
            val checkGetIOSView = fun(): Boolean {
                val page = getCurrentPage()
                val IOSView = page.getIOSView()
                val res = IOSView != null
                console.log("check getIOSView", res)
                uni_showToast(if (res) {
                    ShowToastOptions(title = "check success")
                } else {
                    ShowToastOptions(title = "仅 IOS uts 插件环境支持", icon = "error")
                }
                )
                return res
            }
            val checkGetHTMLElement = fun(): Boolean {
                val page = getCurrentPage()
                val HTMLView = page.getHTMLElement()
                val res = HTMLView != null
                console.log("check getHTMLElement", res)
                uni_showToast(if (res) {
                    ShowToastOptions(title = "check success")
                } else {
                    ShowToastOptions(title = "check fail", icon = "error")
                }
                )
                return res
            }
            val checkGetAndroidActivity = fun(): Boolean {
                val page = getCurrentPage()
                val activity = page.getAndroidActivity()
                val res = activity != null
                console.log("check getAndroidActivity", res)
                uni_showToast(if (res) {
                    ShowToastOptions(title = "check success")
                } else {
                    ShowToastOptions(title = "check fail", icon = "error")
                }
                )
                return res
            }
            val checkQuerySelector = fun(): Boolean {
                val page = getCurrentPage()
                val container = page.querySelector("#container")
                val doesNotExist = page.querySelector("#does-not-exist")
                val res = (container != null) && (doesNotExist == null)
                console.log("check checkQuerySelector", res)
                uni_showToast(if (res) {
                    ShowToastOptions(title = "check success")
                } else {
                    ShowToastOptions(title = "check fail", icon = "error")
                }
                )
                return res
            }
            val checkQuerySelectorAll = fun(): Boolean {
                val page = getCurrentPage()
                val btnList = page.querySelectorAll(".uni-common-mt")
                val doesNotExistList = page.querySelectorAll(".does-not-exist")
                val res = (btnList.length > 1) && (doesNotExistList.length == 0)
                console.log("check checkQuerySelectorAll", res)
                uni_showToast(if (res) {
                    ShowToastOptions(title = "check success")
                } else {
                    ShowToastOptions(title = "check fail", icon = "error")
                }
                )
                return res
            }
            val checkTakeSnapshot = fun(){
                val page = getCurrentPage()
                var callBackNum: Number = 0
                page.takeSnapshot(TakeSnapshotOptions(success = fun(res){
                    console.log("check takeSnapshot success", res)
                    uni_showToast(ShowToastOptions(title = "check success"))
                    callBackNum++
                    if (callBackNum == 2) {
                        data.checkSnapshotResult = true
                    }
                }
                , fail = fun(err){
                    console.log("check takeSnapshot fail", err)
                    uni_showToast(ShowToastOptions(title = "check fail", icon = "error"))
                    callBackNum--
                }
                , complete = fun(info){
                    console.log("check takeSnapshot complete", info)
                    callBackNum++
                    if (callBackNum == 2) {
                        data.checkSnapshotResult = true
                    }
                }
                ))
            }
            __expose(_uM("data" to data, "pageStyleText" to pageStyleText, "_getCurrentPages" to _getCurrentPages, "getPageStyle" to getPageStyle, "setPageStyle" to setPageStyle, "startPullDownRefresh" to startPullDownRefresh, "check\$page" to `check$page`, "componentCheck\$page" to `componentCheck$page`, "checkGetParentPage" to checkGetParentPage, "checkGetDialogPages" to checkGetDialogPages, "checkGetElementById" to checkGetElementById, "checkGetAndroidView" to checkGetAndroidView, "checkGetIOSView" to checkGetIOSView, "checkGetHTMLElement" to checkGetHTMLElement, "checkQuerySelector" to checkQuerySelector, "checkQuerySelectorAll" to checkQuerySelectorAll, "checkGetAndroidActivity" to checkGetAndroidActivity, "checkTakeSnapshot" to checkTakeSnapshot))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                val _component_switch = resolveComponent("switch")
                val _component_slider = resolveComponent("slider")
                val _component_radio = resolveComponent("radio")
                val _component_radio_group = resolveComponent("radio-group")
                return _cE("scroll-view", _uM("class" to "page-scroll-view"), _uA(
                    _cE("view", _uM("id" to "container"), _uA(
                        _cV(_component_page_head, _uM("title" to "getCurrentPages")),
                        _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                            _cE("button", _uM("onClick" to _getCurrentPages), "getCurrentPages"),
                            if (isTrue(unref(data).pages.length)) {
                                _cE("view", _uM("key" to 0, "style" to _nS(_uM("padding" to "15px 0px"))), _uA(
                                    _cE("text", null, "当前页面栈中 " + _tD(unref(data).pages.length) + " 个页面，列表如下：", 1),
                                    _cE(Fragment, null, RenderHelpers.renderList(unref(data).pages, fun(page, index, __index, _cached): Any {
                                        return _cE("text", _uM("key" to page, "style" to _nS(_uM("margin-top" to "5px"))), "index: " + _tD(index) + ", route: " + _tD(page), 5)
                                    }), 128)
                                ), 4)
                            } else {
                                _cC("v-if", true)
                            }
                            ,
                            _cE("button", _uM("class" to "uni-common-mt", "onClick" to `check$page`), "page check \$page"),
                            _cE("button", _uM("class" to "uni-common-mt", "onClick" to checkGetParentPage), " check getParentPage "),
                            _cE("button", _uM("class" to "uni-common-mt", "onClick" to checkGetDialogPages), " check getDialogPages "),
                            _cE("button", _uM("id" to "check-get-element-by-id-btn", "class" to "uni-common-mt", "onClick" to checkGetElementById), " check getElementById "),
                            _cE("button", _uM("class" to "uni-common-mt", "onClick" to checkGetAndroidView), " check getAndroidView "),
                            _cE("button", _uM("class" to "uni-common-mt", "onClick" to checkGetIOSView), " check getIOSView "),
                            _cE("button", _uM("class" to "uni-common-mt", "onClick" to checkGetHTMLElement), " check getHTMLElement "),
                            _cE("button", _uM("class" to "uni-common-mt", "onClick" to checkQuerySelector), " check querySelector "),
                            _cE("button", _uM("class" to "uni-common-mt", "onClick" to checkQuerySelectorAll), " check querySelectorAll "),
                            _cE("button", _uM("class" to "uni-common-mt", "onClick" to checkGetAndroidActivity), " check getAndroidActivity "),
                            _cE("button", _uM("class" to "uni-common-mt", "onClick" to checkTakeSnapshot), " check takeSnapshot ")
                        )),
                        _cV(_component_page_head, _uM("title" to "currentPageStyle")),
                        _cE(Fragment, null, RenderHelpers.renderList(unref(data).PageStyleArray, fun(item, index, __index, _cached): Any {
                            return _cE(Fragment, null, _uA(
                                if (unref(data).currentPageStyle[item.key] != null) {
                                    _cE("view", _uM("class" to "page-style-item", "key" to index), _uA(
                                        _cE("view", _uM("class" to "item-text"), _uA(
                                            _cE("text", _uM("class" to "item-text-key"), _tD(item.key) + ":", 1),
                                            _cE("text", _uM("class" to "item-text-value"), _tD(unref(data).currentPageStyle[item.key]), 1)
                                        )),
                                        if (item.type == "boolean") {
                                            _cE("view", _uM("key" to 0, "class" to "set-value"), _uA(
                                                _cV(_component_switch, _uM("checked" to unref(data).currentPageStyle.getBoolean(item.key), "onChange" to fun(`$event`: Any){
                                                    switchChange(item.key, `$event` as UniSwitchChangeEvent)
                                                }), null, 8, _uA(
                                                    "checked",
                                                    "onChange"
                                                ))
                                            ))
                                        } else {
                                            if (item.type == "number") {
                                                _cE("view", _uM("key" to 1, "class" to "set-value"), _uA(
                                                    _cV(_component_slider, _uM("value" to unref(data).currentPageStyle.getNumber(item.key), "show-value" to true, "onChange" to fun(`$event`: Any){
                                                        sliderChange(item.key, `$event` as UniSliderChangeEvent)
                                                    }), null, 8, _uA(
                                                        "value",
                                                        "onChange"
                                                    ))
                                                ))
                                            } else {
                                                if (item.type == "string") {
                                                    _cE("view", _uM("key" to 2, "class" to "set-value"), _uA(
                                                        _cV(_component_radio_group, _uM("class" to "radio-set-value", "onChange" to fun(`$event`: Any){
                                                            radioChange(item.key, `$event` as RadioGroupChangeEvent)
                                                        }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                            return _uA(
                                                                _cE(Fragment, null, RenderHelpers.renderList(item.value, fun(item2, index2, __index, _cached): Any {
                                                                    return _cV(_component_radio, _uM("class" to "radio-value", "key" to index2, "value" to item2), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                        return _uA(
                                                                            _tD(item2)
                                                                        )
                                                                    }), "_" to 2), 1032, _uA(
                                                                        "value"
                                                                    ))
                                                                }), 128)
                                                            )
                                                        }), "_" to 2), 1032, _uA(
                                                            "onChange"
                                                        ))
                                                    ))
                                                } else {
                                                    _cC("v-if", true)
                                                }
                                            }
                                        }
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                            ), 64)
                        }
                        ), 256),
                        _cE("button", _uM("style" to _nS(_uM("margin" to "10px")), "onClick" to goSetDisablePullDownRefresh), " go set disable pullDownRefresh ", 4),
                        _cV(unref(GenPagesAPIGetCurrentPagesComponentCheckPageClass), _uM("ref_key" to "componentCheckPage", "ref" to componentCheckPage), null, 512)
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
                return _uM("page" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10)), "page-style" to _pS(_uM("marginTop" to 15)), "page-style-item" to _pS(_uM("paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "marginTop" to 10, "backgroundColor" to "#ffffff", "borderTopLeftRadius" to 5, "borderTopRightRadius" to 5, "borderBottomRightRadius" to 5, "borderBottomLeftRadius" to 5)), "item-text" to _pS(_uM("flexDirection" to "row")), "item-text-key" to _pS(_uM("fontWeight" to "bold")), "item-text-value" to _pS(_uM("marginLeft" to 5)), "set-value" to _pS(_uM("marginTop" to 10)), "radio-set-value" to _pS(_uM("flexDirection" to "row")), "radio-value" to _pS(_uM("marginLeft" to 10)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
