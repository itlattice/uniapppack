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
open class GenUniModulesFirstuiUvueComponentsFuiLoadingFuiLoading : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            this.`$nextTick`(fun(){
                setTimeout(fun(){
                    this.startSpin()
                }
                , 150)
            }
            )
        }
        , __ins)
        onBeforeUnmount(fun() {
            this.isSpin = false
            this.element = null
        }
        , __ins)
        this.`$watch`(fun(): Any? {
            return this.text
        }
        , fun(kVal: String) {
            if (kVal == "") {
                this.getLoadingText(fuiLang.locale)
            } else {
                this.loadingText = kVal
            }
        }
        , WatchOptions(immediate = true))
        this.`$watch`(fun(): Any? {
            return this.locale
        }
        , fun(kVal: String) {
            if (this.text == "") {
                this.getLoadingText(kVal)
            }
        }
        , WatchOptions(immediate = true))
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        return _cE("view", _uM("class" to _nC(_uM("fui-loading__mask" to (_ctx.isMask && _ctx.isFixed))), "style" to _nS(_uM("background" to if (_ctx.isFixed) {
            _ctx.maskBgColor
        } else {
            "transparent"
        }
        , "zIndex" to (_ctx.zIndex - 2)))), _uA(
            if (_ctx.type == "col") {
                _cE("view", _uM("key" to 0, "class" to _nC(_uA(
                    "fui-loading fui-loading__wrap",
                    _uM("fui-loading__fixed" to _ctx.isFixed)
                )), "style" to _nS(_uM("background" to _ctx.backgroundColor, "position" to if (_ctx.isFixed) {
                    "fixed"
                } else {
                    "static"
                }, "zIndex" to _ctx.zIndex))), _uA(
                    _cE("image", _uM("class" to "fui-loading__ani", "src" to _ctx.srcCol, "ref" to _ctx.refId, "onTransitionend" to _ctx.onEnd), null, 40, _uA(
                        "src",
                        "onTransitionend"
                    )),
                    _cE("text", _uM("class" to "fui-loading__text", "style" to _nS(_uM("color" to _ctx.colColor, "fontSize" to ("" + _ctx.size + "rpx"), "line-height" to ("" + _ctx.size + "rpx")))), _tD(_ctx.loadingText), 5)
                ), 6)
            } else {
                _cE("view", _uM("key" to 1, "class" to _nC(_uA(
                    "fui-loading fui-loading__row",
                    _uM("fui-loading__fixed" to _ctx.isFixed)
                )), "style" to _nS(_uM("position" to if (_ctx.isFixed) {
                    "fixed"
                } else {
                    "static"
                }
                , "zIndex" to _ctx.zIndex))), _uA(
                    _cE("image", _uM("class" to "fui-loading-row__ani", "src" to _ctx.srcRow, "ref" to _ctx.refId, "onTransitionend" to _ctx.onEnd), null, 40, _uA(
                        "src",
                        "onTransitionend"
                    )),
                    _cE("text", _uM("class" to "fui-loading__text", "style" to _nS(_uM("color" to _ctx.rowColor, "fontSize" to ("" + _ctx.size + "rpx"), "line-height" to ("" + _ctx.size + "rpx")))), _tD(_ctx.loadingText), 5)
                ), 6)
            }
        ), 6)
    }
    open var type: String by `$props`
    open var text: String by `$props`
    open var colColor: String by `$props`
    open var rowColor: String by `$props`
    open var size: Number by `$props`
    open var backgroundColor: String by `$props`
    open var srcCol: String by `$props`
    open var srcRow: String by `$props`
    open var isFixed: Boolean by `$props`
    open var isMask: Boolean by `$props`
    open var maskBgColor: String by `$props`
    open var zIndex: Number by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    open var refId: Any? by `$data`
    open var times: Number by `$data`
    open var isSpin: Boolean by `$data`
    open var element: UniElement? by `$data`
    open var loadingText: String by `$data`
    open var locale: String by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        val refId = "fui_loading_" + parseInt(Math.ceil(Math.random() * 10e5).toString(10), 36)
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml, "refId" to refId, "times" to 0, "isSpin" to false, "element" to null as UniElement?, "loadingText" to "", "locale" to computed<String>(fun(): String {
            return fuiLang.locale
        }
        ))
    }
    open var getLoadingText = ::gen_getLoadingText_fn
    open fun gen_getLoadingText_fn(kVal: String) {
        val lang = getFuiLocaleLang(kVal)
        val loadingR = lang["loading"] as UTSJSONObject
        this.loadingText = loadingR.getString("text") as String
    }
    open var startSpin = ::gen_startSpin_fn
    open fun gen_startSpin_fn() {
        if (this.element != null && this.isSpin) {
            return
        }
        if (this.element == null && this.`$refs`[this.refId] != null) {
            this.element = this.`$refs`[this.refId] as UniElement
        }
        if (this.element == null) {
            return
        }
        this.times = this.times + 1
        this.element!!.style.setProperty("transform", "rotate(" + this.times * 360 + "deg)")
        this.element!!.style.setProperty("transition-duration", "800ms")
        this.isSpin = true
    }
    open var onEnd = ::gen_onEnd_fn
    open fun gen_onEnd_fn() {
        if (this.isSpin) {
            this.times = this.times + 1
            this.element!!.style.setProperty("transform", "rotate(" + this.times * 360 + "deg)")
        }
    }
    companion object {
        var name = "fui-loading"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("fui-loading" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "overflow" to "visible")), "fui-loading__fixed" to _pS(_uM("top" to "50%", "left" to "50%", "transform" to "translate(-50%, -50%)")), "fui-loading__wrap" to _pS(_uM("width" to "208rpx", "height" to "208rpx", "flexDirection" to "column", "borderTopLeftRadius" to "12rpx", "borderTopRightRadius" to "12rpx", "borderBottomRightRadius" to "12rpx", "borderBottomLeftRadius" to "12rpx")), "fui-loading__ani" to _pS(_uM("width" to "64rpx", "height" to "64rpx", "marginTop" to 0, "marginRight" to 6, "marginBottom" to "30rpx", "marginLeft" to 6, "transform" to "rotate(0deg)", "transitionDuration" to "600ms", "transitionProperty" to "transform", "transitionTimingFunction" to "linear")), "fui-loading__row" to _pS(_uM("width" to "100%", "height" to "36rpx")), "fui-loading-row__ani" to _pS(_uM("width" to "36rpx", "height" to "36rpx", "borderTopLeftRadius" to "36rpx", "borderTopRightRadius" to "36rpx", "borderBottomRightRadius" to "36rpx", "borderBottomLeftRadius" to "36rpx", "marginRight" to "20rpx", "transform" to "rotate(0deg)", "transitionDuration" to "600ms", "transitionProperty" to "transform", "transitionTimingFunction" to "linear")), "fui-loading__text" to _pS(_uM("textAlign" to "center")), "fui-loading__mask" to _pS(_uM("position" to "fixed", "left" to 0, "top" to 0, "right" to 0, "bottom" to 0)), "@TRANSITION" to _uM("fui-loading__ani" to _uM("duration" to "600ms", "property" to "transform", "timingFunction" to "linear"), "fui-loading-row__ani" to _uM("duration" to "600ms", "property" to "transform", "timingFunction" to "linear")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("type" to _uM("type" to "String", "default" to "col"), "text" to _uM("type" to "String", "default" to ""), "colColor" to _uM("type" to "String", "default" to "#FFFFFF"), "rowColor" to _uM("type" to "String", "default" to "#7F7F7F"), "size" to _uM("type" to "Number", "default" to 26), "backgroundColor" to _uM("type" to "String", "default" to "rgba(0, 0, 0, 0.6)"), "srcCol" to _uM("type" to "String", "default" to "data:image/png;base64,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"), "srcRow" to _uM("type" to "String", "default" to "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFoAAABaCAMAAAAPdrEwAAAAM1BMVEUAAACPj4+IiIiIiIiIiIiIiIiKioqHh4eHh4eHh4eHh4eIiIiIiIiJiYmIiIiJiYmIiIi8awvKAAAAEHRSTlMAEEDw4NAwwKAgYICQULBwL0wVnQAAAmpJREFUWMPtmOmO4yAQhLlvMO//tDuyjfAaCEcj7UqTT5o/iafSVLcLY/TldyHID8fPH94oir2TLD6QyugdxVoeazAnYPUaFtsws+yNVjR+htolcWz/luHyhL7F55XNQ0Narx+L8TY8bSGTXsiYUB5V8A+zHJ4rud+p3GI+PiwqCXv0Ec+T42awf3L8+iMtzwwp36UEPHR1SIYPKueS+xxJe1CZiYkooNmTvjLHUzHDR7TVgnI2UXR9k/OhQHslieKCcb87reRnB5fCzMeTVp5cUbeY8O6arEYknYs60CJXK21zOvot7DSK4lrR51eA7dQ1y1bFF9MT2Chb358DsLHeLJeKhpZdDgkDFp1jQtRGXiEYOtZU1PLdUt7OFT84gnJUHNE5XOCO2PLnCALDzl21HD2Yam4ZRU9kER8Qs/V7IQ7BIWVqp10TTCFN0gdgwvumJmkcwWDFgigsQtv4Sv8baZ2lt5Pn+n+Wfm+CMsUsHFIJQ7VH+l2hSXsaHFUbEb1l2GRt5zFb/FC1nSfskGam+lSP4cqmks10jyOc1fditiGMXD1G4DekTH5sf14gkTeD1QOdbrRLXodGAKb1hC7gh5nmvzvgI0NoHyswA1niP7WKQE4dmtYHDH4MwzxS3T2MmCWje5OL2aK26j9EC7qkrVIk97XtrM+RYzSoHSZmUCTlLoLNvTs+aFLug+XEu2Mt59boRl9+4vk7gbD79fXnii2dsS6Xc4lb3fx5lX1bfKfPD1HJInetS64lJQnxhkrryV2+INbxeCHXN1PtaGxClUYgvGJ1XY82IA7Fn7IyFO7DIDcYfflN/AFNdjdeDj7M+wAAAABJRU5ErkJggg=="), "isFixed" to _uM("type" to "Boolean", "default" to true), "isMask" to _uM("type" to "Boolean", "default" to false), "maskBgColor" to _uM("type" to "String", "default" to "transparent"), "zIndex" to _uM("type" to "Number", "default" to 996)))
        var propsNeedCastKeys = _uA(
            "type",
            "text",
            "colColor",
            "rowColor",
            "size",
            "backgroundColor",
            "srcCol",
            "srcRow",
            "isFixed",
            "isMask",
            "maskBgColor",
            "zIndex"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
