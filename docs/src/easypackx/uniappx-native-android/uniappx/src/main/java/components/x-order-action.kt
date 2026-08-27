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
open class GenComponentsXOrderAction : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var btn2: String by `$props`
    open var active: Boolean by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXOrderAction) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXOrderAction
            val _cache = __ins.renderCache
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val submit = fun(){
                emit("submit")
            }
            val draft = fun(){
                emit("draft")
            }
            return fun(): Any? {
                val _component_x_button = resolveEasyComponent("x-button", GenComponentsXButtonClass)
                return _cE("view", null, _uA(
                    _cE("view", _uM("class" to "actions background-white space-between safe-bottom position-fixed"), _uA(
                        renderSlot(_ctx.`$slots`, "default", _uO(), fun(): UTSArray<Any> {
                            return _uA(
                                _cE("view")
                            )
                        }
                        ),
                        _cE("view", _uM("class" to "btns display-flex safe-bottom"), _uA(
                            _cV(_component_x_button, _uM("class" to _nC(_uA(
                                "btn action",
                                if (_ctx.active) {
                                    "activecaogao"
                                } else {
                                    ""
                                }
                            )), "onBtnClick" to draft), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    "草稿"
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "class"
                            )),
                            _cV(_component_x_button, _uM("class" to _nC(_uA(
                                "btn ruku",
                                if (_ctx.active) {
                                    "activesubmit"
                                } else {
                                    ""
                                }
                            )), "onBtnClick" to submit), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _tD(_ctx.btn2)
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "class"
                            ))
                        ))
                    )),
                    _cE("view", _uM("class" to "background-white safe-bottom-view"))
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
                return _uM("actions" to _pS(_uM("height" to 50, "width" to "750rpx", "left" to 0)), "btns" to _uM(".actions " to _uM("position" to "fixed", "right" to 0, "zIndex" to 88)), "btn" to _uM(".actions .btns " to _uM("width" to "200rpx", "height" to 50, "borderTopWidth" to 0, "borderRightWidth" to 0, "borderBottomWidth" to 0, "borderLeftWidth" to 0, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#000000", "borderRightColor" to "#000000", "borderBottomColor" to "#000000", "borderLeftColor" to "#000000", "color" to "#FFFFFF", "lineHeight" to "50px", "fontSize" to 18, "borderTopLeftRadius" to 0, "borderTopRightRadius" to 0, "borderBottomRightRadius" to 0, "borderBottomLeftRadius" to 0)), "action" to _uM(".actions .btns " to _uM("backgroundImage" to "none", "backgroundColor" to "#C2C2C2")), "ruku" to _uM(".actions .btns " to _uM("backgroundImage" to "none", "backgroundColor" to "#B0B0B0")), "activecaogao" to _uM(".actions .btns " to _uM("backgroundImage" to "none", "backgroundColor" to "#2A82E4")), "activesubmit" to _uM(".actions .btns " to _uM("backgroundImage" to "none", "backgroundColor" to "#FF5733")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("submit" to null, "draft" to null)
        var props = _nP(_uM("btn2" to _uM("type" to "String", "default" to "提交"), "active" to _uM("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = _uA(
            "btn2",
            "active"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
