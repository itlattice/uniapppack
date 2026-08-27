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
open class GenComponentsXNumberwindow : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var activeGoods: UTSJSONObject by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    open var open: () -> Unit
        get() {
            return unref(this.`$exposed`["open"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "open", value)
        }
    open var close: () -> Unit
        get() {
            return unref(this.`$exposed`["close"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "close", value)
        }
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXNumberwindow, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXNumberwindow
            val _cache = __ins.renderCache
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val numberWindow = ref<UniElement?>(null)
            val num = ref(1)
            val addGoods = fun(){
                emit("addGoods", num.value)
            }
            val closeWindow = fun(){
                emit("closeWindow")
            }
            val bindNumberInput = fun(e: UniInputEvent){
                num.value = parseFloat(e.detail.value)
            }
            val open = fun(){
                num.value = 1
                (numberWindow.value as ComponentPublicInstance).`$callMethod`("open")
            }
            val close = fun(){
                common.callMethod(numberWindow.value as Any, "close")
            }
            __expose(_uM("open" to open, "close" to close))
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_x_triangleinput = resolveEasyComponent("x-triangleinput", GenComponentsXTriangleinputClass)
                val _component_wx_popup = resolveEasyComponent("wx-popup", GenUniModulesWxUiComponentsWxPopupWxPopupClass)
                return _cV(_component_wx_popup, _uM("ref_key" to "numberWindow", "ref" to numberWindow, "mode" to "center", "round" to 12), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("style" to _nS(_uM("width" to "300px", "height" to "260px")), "class" to "position-relative background-white addnumberwindow"), _uA(
                            _cE("view", _uM("class" to "titlebox"), _uA(
                                _cE("text", _uM("class" to "title align-center"), "商品数量"),
                                _cV(_component_x_iconfont, _uM("onClick" to closeWindow, "class" to "guanbi", "name" to "guanbi", "color" to "#A1A1A1", "size" to "20"))
                            )),
                            _cE("view", _uM("class" to "goodsinfo display-flex"), _uA(
                                _cE("image", _uM("class" to "img", "src" to _ctx.activeGoods["image"]), null, 8, _uA(
                                    "src"
                                )),
                                _cE("view", _uM("class" to "info"), _uA(
                                    _cE("text", _uM("class" to "name overline2"), _tD(_ctx.activeGoods["name"]), 1),
                                    _cE("text", _uM("class" to "code"), _tD(_ctx.activeGoods["code"]), 1)
                                ))
                            )),
                            _cE("text", _uM("class" to "numbertitle align-center"), "本次计入数量"),
                            _cE("view", _uM("class" to "numberinput"), _uA(
                                _cV(_component_x_triangleinput, _uM("height" to 28, "class" to "margin-center", "width" to 250), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cE("input", _uM("selection-start" to -1, "selection-end" to 100, "auto-focus" to "true", "confirm-type" to "done", "value" to unref(num), "onInput" to bindNumberInput, "type" to "digit", "class" to "align-center color-red font-bold number"), null, 40, _uA(
                                            "value"
                                        ))
                                    )
                                }
                                ), "_" to 1))
                            )),
                            _cE("view", _uM("class" to "action position-absolute background-main", "onClick" to addGoods), _uA(
                                _cE("text", _uM("class" to "align-center color-white content"), "计入")
                            ))
                        ), 4)
                    )
                }
                ), "_" to 1), 512)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("addnumberwindow" to _pS(_uM("paddingTop" to 5, "paddingLeft" to 8, "paddingRight" to 8)), "titlebox" to _uM(".addnumberwindow " to _uM("height" to 31, "paddingBottom" to 2, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#cccccc")), "title" to _uM(".addnumberwindow .titlebox " to _uM("fontSize" to 15, "color" to "#303030", "lineHeight" to "31px")), "guanbi" to _uM(".addnumberwindow .titlebox " to _uM("position" to "absolute", "top" to 8, "right" to 13)), "goodsinfo" to _uM(".addnumberwindow " to _uM("paddingTop" to 11, "position" to "relative")), "img" to _uM(".addnumberwindow .goodsinfo " to _uM("width" to 50, "height" to 50, "borderTopLeftRadius" to 3, "borderTopRightRadius" to 3, "borderBottomRightRadius" to 3, "borderBottomLeftRadius" to 3)), "info" to _uM(".addnumberwindow .goodsinfo " to _uM("marginLeft" to 8)), "name" to _uM(".addnumberwindow .goodsinfo .info " to _uM("fontSize" to 14, "width" to 200)), "code" to _uM(".addnumberwindow .goodsinfo .info " to _uM("fontSize" to 12, "color" to "#828282", "position" to "absolute", "bottom" to 0, "left" to 0)), "numbertitle" to _uM(".addnumberwindow " to _uM("fontSize" to 15, "marginTop" to 13)), "numberinput" to _uM(".addnumberwindow " to _uM("marginTop" to 10)), "number" to _uM(".addnumberwindow .numberinput " to _uM("fontSize" to 22)), "action" to _uM(".addnumberwindow " to _uM("bottom" to 0, "width" to 300, "overflow" to "hidden", "left" to 0, "height" to 40)), "content" to _uM(".addnumberwindow .action " to _uM("lineHeight" to "40px")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("addGoods" to null, "closeWindow" to null)
        var props = _nP(_uM("activeGoods" to _uM("type" to "UTSJSONObject", "default" to _uO())))
        var propsNeedCastKeys = _uA(
            "activeGoods"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
