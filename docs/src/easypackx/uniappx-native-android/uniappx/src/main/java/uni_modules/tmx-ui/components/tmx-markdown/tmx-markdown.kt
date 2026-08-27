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
import io.dcloud.uniapp.extapi.createWebviewContext as uni_createWebviewContext
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenUniModulesTmxUiComponentsTmxMarkdownTmxMarkdown : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            var t = this
            t.isLoaded = true
            this.tid = setTimeout(fun() {
                t.webviewContext = uni_createWebviewContext(t.id, t)
            }
            , 50)
            this.onAddlisentMesage()
        }
        , __ins)
        onBeforeMount(fun() {
            clearTimeout(this.tid)
        }
        , __ins)
        onBeforeUnmount(fun() {}, __ins)
        this.`$watch`(fun(): Any? {
            return this.value
        }
        , fun() {
            this.drawer()
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        val _component_tmx_icon = resolveEasyComponent("tmx-icon", GenUniModulesTmxUiComponentsTmxIconTmxIconClass)
        val _component_web_view = resolveComponent("web-view")
        return _cE("view", _uM("style" to _nS(_uM("width" to _ctx._width, "height" to if (_ctx.boxHeight == 0 || _ctx.isMp) {
            _ctx._height
        } else {
            (_ctx.boxHeight + "px")
        }
        ))), _uA(
            if (isTrue(!_ctx.isLoaded)) {
                _cE("view", _uM("key" to 0, "style" to _nS(_uM("width" to "100%", "min-height" to "36px", "display" to "flex", "justify-content" to "center", "align-items" to "center", "flex-direction" to "row"))), _uA(
                    _cV(_component_tmx_icon, _uM("color" to "primary", "spin" to true, "name" to "loader-4-line"))
                ), 4)
            } else {
                _cC("v-if", true)
            }
            ,
            if (isTrue(_ctx.isLoaded)) {
                _cV(_component_web_view, _uM("key" to 1, "horizontalScrollBarAccess" to true, "verticalScrollBarAccess" to false, "class" to "xMarkdownNoevents", "onLoad" to _ctx.appWebViewLoaded, "id" to _ctx.id, "src" to "/hybrid/html/preview.html", "style" to _nS(_uM("width" to "100%", "height" to "100%", "opacity" to if (_ctx.isLoaded) {
                    1
                } else {
                    0
                })), "onMessage" to _ctx.onMessage), null, 8, _uA(
                    "onLoad",
                    "id",
                    "style",
                    "onMessage"
                ))
            } else {
                _cC("v-if", true)
            }
        ), 4)
    }
    open var width: String by `$props`
    open var height: String by `$props`
    open var value: String by `$props`
    open var isHtml: Boolean by `$props`
    open var nodeStyle: String by `$props`
    open var nodeDarkStyle: String by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    open var id: String by `$data`
    open var webviewContext: WebviewContext? by `$data`
    open var isLoaded: Boolean by `$data`
    open var boxWidth: Number by `$data`
    open var boxHeight: Number by `$data`
    open var tid: Number by `$data`
    open var tid2: Number by `$data`
    open var realLoaded: Boolean by `$data`
    open var isMp: Boolean by `$data`
    open var _width: String by `$data`
    open var _height: String by `$data`
    open var _value: String by `$data`
    open var _nodeStyle: String by `$data`
    open var _isDark: Boolean by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml, "id" to ("xEchart-" + getUid()) as String, "webviewContext" to null as WebviewContext?, "isLoaded" to false, "boxWidth" to 10, "boxHeight" to 0, "tid" to 0, "tid2" to 0, "realLoaded" to false, "isMp" to false, "_width" to computed<String>(fun(): String {
            return checkIsCssUnit(this.width, xConfig.unit)
        }
        ), "_height" to computed<String>(fun(): String {
            return checkIsCssUnit(this.height, xConfig.unit)
        }
        ), "_value" to computed<String>(fun(): String {
            return this.value
        }
        ), "_nodeStyle" to computed<String>(fun(): String {
            return if (xConfig.dark == "dark") {
                this.nodeDarkStyle
            } else {
                this.nodeStyle
            }
        }
        ), "_isDark" to computed<Boolean>(fun(): Boolean {
            return xConfig.dark == "dark"
        }
        ))
    }
    open var onAddlisentMesage = ::gen_onAddlisentMesage_fn
    open fun gen_onAddlisentMesage_fn() {}
    open var onMessage = ::gen_onMessage_fn
    open fun gen_onMessage_fn(event: WebViewMessageEvent) {
        var t = this
        var msgdatas = event.detail.data
        if (msgdatas.length == 0) {
            return
        }
        if (msgdatas.length > 0) {
            var dataStr = JSON.stringify(event.detail)
            var dataJson = JSON.parseObject(dataStr)!!
            var msgeAr = dataJson.getArray<UTSJSONObject>("data")!!
            var msg = msgeAr[0]!!
            var ac = msg["action"] as String
            if (ac == "offsetHeight") {
                val h = msg["data"]!! as Number
                t.boxHeight = h + 25
            } else if (ac == "toValue") {
                t.`$emit`("getValue", msg["data"]!! as String)
            } else if (ac == "click") {
                t.`$emit`("tagClick", msg["data"]!! as UTSJSONObject)
            }
        }
    }
    open var drawer = ::gen_drawer_fn
    open fun gen_drawer_fn() {
        if (!this.realLoaded) {
            uni_showToast(ShowToastOptions(title = "未初始化完成", icon = "none"))
            return
        }
        this.eventJsCall("markdown", JSON.stringify(_uO("value" to if (this.isHtml) {
            btoa(encodeURIComponent(this._value)!!)
        } else {
            this._value
        }
        , "render" to if (this.isHtml) {
            "android"
        } else {
            ""
        }
        )))
    }
    open var eventJsCall = ::gen_eventJsCall_fn
    open fun gen_eventJsCall_fn(callfun: String, str: String) {
        this.webviewContext?.evalJS("" + callfun + "(" + str + "," + this.isHtml + "," + (xConfig.dark == "dark") + ")")
    }
    open var getHtml = ::gen_getHtml_fn
    open fun gen_getHtml_fn() {
        this.webviewContext?.evalJS("getHtml()")
    }
    open var appWebViewLoaded = ::gen_appWebViewLoaded_fn
    open fun gen_appWebViewLoaded_fn() {
        this.realLoaded = true
        this.drawer()
        this.`$emit`("init")
        this.eventJsCall("setBodyStyle", "'" + this._nodeStyle + "'")
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("xMarkdownAndrod" to _pS(_uM("position" to "absolute", "left" to 0, "top" to 0, "width" to "100%", "height" to "100%", "zIndex" to 10)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("tagClick" to null, "init" to null, "getValue" to null)
        var props = _nP(_uM("width" to _uM("type" to "String", "default" to "auto"), "height" to _uM("type" to "String", "default" to "auto"), "value" to _uM("type" to "String", "default" to ""), "isHtml" to _uM("type" to "Boolean", "default" to false), "nodeStyle" to _uM("type" to "String", "default" to "line-height:1.6;color:#000"), "nodeDarkStyle" to _uM("type" to "String", "default" to "line-height:1.6;color:#fff")))
        var propsNeedCastKeys = _uA(
            "width",
            "height",
            "value",
            "isHtml",
            "nodeStyle",
            "nodeDarkStyle"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
