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
open class GenUniModulesFirstuiUvueComponentsFuiDialogFuiDialog : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            this.`$nextTick`(fun(){
                setTimeout(fun(){
                    if (!this.isShow) {
                        this.close()
                    }
                }
                , 50)
            }
            )
        }
        , __ins)
        this.`$watch`(fun(): Any? {
            return this.visible
        }
        , fun(newVal: Boolean) {
            if (newVal) {
                this.open()
            } else {
                if (this.isShow) {
                    this.close()
                }
            }
        }
        , WatchOptions(immediate = true))
        this.`$watch`(fun(): Any? {
            return this.locale
        }
        , fun(kVal: String) {
            val lang = getFuiLocaleLang(kVal)
            val dialog = lang["dialog"] as UTSJSONObject
            this.d_title = if (this.title == "fui_def") {
                (dialog.getString("title") as String)
            } else {
                this.title
            }
            val btns = JSON.parse<UTSArray<FuiDialogButtonsParam>>(JSON.stringify(this.buttons))
            if (btns == null || btns.length == 0) {
                val param = _uA<FuiDialogButtonsParam>(FuiDialogButtonsParam(text = dialog.getString("cancel") as String), FuiDialogButtonsParam(text = dialog.getString("confirm") as String, primary = true))
                this.getButtons(param)
            } else {
                this.getButtons(btns)
            }
        }
        , WatchOptions(immediate = true))
        this.`$watch`(fun(): Any? {
            return this.buttons
        }
        , fun(vals: UTSArray<FuiDialogButtonsParam>) {
            this.getButtons(vals)
        }
        )
        this.`$watch`(fun(): Any? {
            return this.title
        }
        , fun(kVal: String) {
            if (kVal != "fui_def") {
                this.d_title = this.title
            }
        }
        )
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        return _cE("view", _uM("ref" to _ctx.refId, "class" to _nC(_uA(
            "fui-dialog__wrap",
            _uM("fui-dialog__mask-bg" to (_ctx.maskBackground == ""))
        )), "style" to _nS(_uM("background" to _ctx.maskBackground, "zIndex" to _ctx.zIndex)), "onClick" to _ctx.maskClose), _uA(
            _cE("view", _uM("class" to _nC(_uA(
                "fui-dialog__inner",
                _uM("fui-dialog__bg" to (_ctx.background == ""))
            )), "style" to _nS(_uM("background" to _ctx.background, "borderRadius" to ("" + _ctx.radius + "rpx")))), _uA(
                if (_ctx.title != "") {
                    _cE("text", _uM("key" to 0, "class" to _nC(_uA(
                        "fui-dialog__title",
                        _uM("fui-dialog__title-color" to (_ctx.color == ""))
                    )), "style" to _nS(_ctx.getTitleStyl)), _tD(_ctx.d_title), 7)
                } else {
                    _cC("v-if", true)
                }
                ,
                _cE("view", _uM("class" to _nC(_uA(
                    "fui-dialog__body",
                    _uM("fui-dialog__mtop" to (_ctx.title == ""))
                ))), _uA(
                    if (_ctx.content != "") {
                        _cE("text", _uM("key" to 0, "class" to _nC(_uA(
                            "fui-dialog__descr",
                            _uM("fui-dialog__descr-color" to (_ctx.contentColor == ""))
                        )), "style" to _nS(_ctx.getContentStyl)), _tD(_ctx.content), 7)
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    renderSlot(_ctx.`$slots`, "default")
                ), 2),
                _cE("view", _uM("class" to "fui-dialog__footer"), _uA(
                    _cE(Fragment, null, RenderHelpers.renderList(_ctx.btns, fun(item, index, __index, _cached): Any {
                        return _cE("text", _uM("key" to index, "style" to _nS(_ctx.getBtnStyl(item.color)), "class" to _nC(_uA(
                            "fui-dialog__btn",
                            _uM("fui-dialog__btn-active" to (index == _ctx.current), "fui-dialog__btn-first" to (index == 0), "fui-dialog__btn-color" to ((item.color == null || item.color == "") && (item.primary == null || item.primary == false)), "fui-dialog__color-primary" to ((item.color == null || item.color == "") && item.primary == true))
                        )), "onClick" to fun(){
                            _ctx.handleClick(index)
                        }
                        , "onTouchstart" to fun(){
                            _ctx.onTouchstart(index)
                        }
                        , "onTouchend" to _ctx.onEnd, "onTouchcancel" to _ctx.onEnd), _tD(item.text), 47, _uA(
                            "onClick",
                            "onTouchstart",
                            "onTouchend",
                            "onTouchcancel"
                        ))
                    }
                    ), 128)
                ))
            ), 6)
        ), 14, _uA(
            "onClick"
        ))
    }
    open var visible: Boolean by `$props`
    open var title: String by `$props`
    open var color: String by `$props`
    open var content: String by `$props`
    open var contentColor: String by `$props`
    open var buttons: UTSArray<FuiDialogButtonsParam> by `$props`
    open var background: String by `$props`
    open var radius: Number by `$props`
    open var maskBackground: String by `$props`
    open var maskClosable: Boolean by `$props`
    open var zIndex: Number by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    open var refId: Any? by `$data`
    open var isShow: Boolean by `$data`
    open var element: UniElement? by `$data`
    open var current: Number by `$data`
    open var btns: UTSArray<FuiDialogButtonsParam> by `$data`
    open var d_title: String by `$data`
    open var closeItem: FuiDialogButtonsParam by `$data`
    open var locale: String by `$data`
    open var getTitleStyl: Any by `$data`
    open var getContentStyl: Any by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        val refId = "fui_dialog_" + parseInt(Math.ceil(Math.random() * 10e5).toString(10), 36)
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml, "refId" to refId, "isShow" to false, "element" to null as UniElement?, "current" to -1, "btns" to _uA<FuiDialogButtonsParam>(), "d_title" to "", "closeItem" to FuiDialogButtonsParam(text = ""), "locale" to computed<String>(fun(): String {
            return fuiLang.locale
        }
        ), "getTitleStyl" to computed<Any>(fun(): Any {
            val mp: Map<String, String> = Map()
            if (this.color != "") {
                mp.set("color", this.color)
            }
            return mp
        }
        ), "getContentStyl" to computed<Any>(fun(): Any {
            val mp: Map<String, String> = Map()
            if (this.contentColor != "") {
                mp.set("color", this.contentColor)
            }
            return mp
        }
        ))
    }
    open var getBtnStyl = ::gen_getBtnStyl_fn
    open fun gen_getBtnStyl_fn(color: String?): Any {
        val mp: Map<String, String> = Map()
        if (color != "" && color != null) {
            mp.set("color", color)
        }
        return mp
    }
    open var getClickItem = ::gen_getClickItem_fn
    open fun gen_getClickItem_fn(): FuiDialogButtonsParam {
        return this.closeItem as FuiDialogButtonsParam
    }
    open var getButtons = ::gen_getButtons_fn
    open fun gen_getButtons_fn(vals: UTSArray<FuiDialogButtonsParam>) {
        this.btns = _uA<FuiDialogButtonsParam>()
        this.`$nextTick`(fun(){
            this.btns = vals
        }
        )
    }
    open var handleClick = ::gen_handleClick_fn
    open fun gen_handleClick_fn(index: Number) {
        val item = this.btns[index]
        item.index = index
        this.closeItem = item
        this.`$emit`("onclick", item)
    }
    open var maskClose = ::gen_maskClose_fn
    open fun gen_maskClose_fn() {
        if (!this.maskClosable) {
            return
        }
        this.`$emit`("close")
        this.`$emit`("update:visible", false)
    }
    open var open = ::gen_open_fn
    open fun gen_open_fn() {
        this.isShow = true
        this.`$nextTick`(fun(){
            setTimeout(fun(){
                this._animation(true)
            }
            , 50)
        }
        )
    }
    open var close = ::gen_close_fn
    open fun gen_close_fn() {
        this.isShow = false
        this._animation(false)
    }
    open var _animation = ::gen__animation_fn
    open fun gen__animation_fn(visible: Boolean) {
        if (this.element == null) {
            this.element = this.`$refs`[this.refId] as UniElement
        }
        this.element!!.style.setProperty("opacity", if (visible) {
            "1"
        } else {
            "0"
        }
        )
        if (visible) {
            this.element!!.style.setProperty("visibility", "visible")
        } else {
            setTimeout(fun(){
                this.element!!.style.setProperty("visibility", "hidden")
            }
            , 250)
        }
    }
    open var onTouchstart = ::gen_onTouchstart_fn
    open fun gen_onTouchstart_fn(index: Number) {
        this.current = index
    }
    open var onEnd = ::gen_onEnd_fn
    open fun gen_onEnd_fn() {
        this.current = -1
    }
    companion object {
        var name = "fui-dialog"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("fui-dialog__wrap" to _pS(_uM("position" to "fixed", "width" to "100%", "height" to "100%", "top" to 0, "right" to 0, "left" to 0, "bottom" to 0, "transitionTimingFunction" to "ease-in", "transitionProperty" to "visibility,opacity", "transitionDuration" to "0.25s", "display" to "flex", "alignItems" to "center", "justifyContent" to "center", "visibility" to "hidden", "opacity" to 0)), "fui-dialog__inner" to _pS(_uM("width" to "680rpx", "display" to "flex", "flexDirection" to "column", "overflow" to "hidden")), "fui-dialog__title" to _pS(_uM("paddingTop" to "64rpx", "paddingRight" to "48rpx", "paddingBottom" to 0, "paddingLeft" to "48rpx", "fontWeight" to "700", "fontSize" to 16, "textAlign" to "center")), "fui-dialog__body" to _pS(_uM("paddingTop" to "32rpx", "paddingRight" to "48rpx", "paddingBottom" to "32rpx", "paddingLeft" to "48rpx", "marginBottom" to "32rpx")), "fui-dialog__descr" to _pS(_uM("fontSize" to 16, "fontWeight" to "normal", "textAlign" to "center")), "fui-dialog__mtop" to _pS(_uM("marginTop" to "32rpx")), "fui-dialog__footer" to _pS(_uM("display" to "flex", "flexDirection" to "row", "position" to "relative", "height" to "112rpx", "borderTopWidth" to 0.5, "borderTopStyle" to "solid", "borderTopColor" to "#EEEEEE")), "fui-dialog__btn" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "height" to "112rpx", "lineHeight" to "112rpx", "fontWeight" to "700", "position" to "relative", "fontSize" to 18, "borderLeftWidth" to 0.5, "borderLeftStyle" to "solid", "borderLeftColor" to "#EEEEEE", "textAlign" to "center")), "fui-dialog__btn-active" to _pS(_uM("backgroundImage" to "none", "backgroundColor" to "rgba(0,0,0,0.2)")), "fui-dialog__btn-first" to _pS(_uM("!borderLeftWidth" to 0)), "fui-dialog__mask-bg" to _pS(_uM("!backgroundImage" to "none", "!backgroundColor" to "rgba(0,0,0,0.6)")), "fui-dialog__title-color" to _pS(_uM("!color" to "#333333")), "fui-dialog__descr-color" to _pS(_uM("!color" to "#7F7F7F")), "fui-dialog__bg" to _pS(_uM("!backgroundImage" to "none", "!backgroundColor" to "#FFFFFF")), "fui-dialog__btn-color" to _pS(_uM("!color" to "#333333")), "fui-dialog__color-primary" to _pS(_uM("!color" to "#465CFF")), "@TRANSITION" to _uM("fui-dialog__wrap" to _uM("timingFunction" to "ease-in", "property" to "visibility,opacity", "duration" to "0.25s")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("onclick" to null, "close" to null, "update:visible" to null)
        var props = _nP(_uM("visible" to _uM("type" to "Boolean", "default" to false), "title" to _uM("type" to "String", "default" to "fui_def"), "color" to _uM("type" to "String", "default" to ""), "content" to _uM("type" to "String", "default" to ""), "contentColor" to _uM("type" to "String", "default" to ""), "buttons" to _uM("type" to "Array", "default" to fun(): UTSArray<FuiDialogButtonsParam> {
            return _uA<FuiDialogButtonsParam>()
        }
        ), "background" to _uM("type" to "String", "default" to ""), "radius" to _uM("type" to "Number", "default" to 24), "maskBackground" to _uM("type" to "String", "default" to ""), "maskClosable" to _uM("type" to "Boolean", "default" to true), "zIndex" to _uM("type" to "Number", "default" to 996)))
        var propsNeedCastKeys = _uA(
            "visible",
            "title",
            "color",
            "content",
            "contentColor",
            "buttons",
            "background",
            "radius",
            "maskBackground",
            "maskClosable",
            "zIndex"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
