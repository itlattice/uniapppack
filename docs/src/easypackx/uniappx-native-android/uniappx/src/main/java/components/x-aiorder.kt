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
open class GenComponentsXAiorder : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var show: Boolean by `$props`
    open var title: String by `$props`
    open var tools: UTSArray<UTSJSONObject>? by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXAiorder) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXAiorder
            val _cache = __ins.renderCache
            val props = __props
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val innerShow = ref(props.show)
            watch(fun(): Boolean {
                return props.show
            }
            , fun(newVal: Boolean){
                innerShow.value = newVal
            }
            )
            watch(innerShow, fun(newVal: Boolean){
                emit("update:show", newVal)
            }
            )
            val click = fun(key: String){
                emit("toolClick", key)
            }
            val clickItem = fun(item: UTSJSONObject){
                click(item["key"] as String)
            }
            val close = fun(){
                emit("update:show", false)
            }
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_tmx_modal = resolveEasyComponent("tmx-modal", GenUniModulesTmxUiComponentsTmxModalTmxModalClass)
                return _cV(_component_tmx_modal, _uM("modelValue" to unref(innerShow), "onUpdate:modelValue" to fun(`$event`: Boolean){
                    trySetRefValue(innerShow, `$event`)
                }
                , "contentPadding" to "0", "showFooter" to false, "showTitle" to false, "width" to "590rpx", "height" to "556rpx", "onClose" to close), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "aiorders"), _uA(
                            _cE("text", _uM("class" to "title"), _tD(_ctx.title), 1),
                            _cE("view", _uM("class" to "guanbiicon"), _uA(
                                _cV(_component_x_iconfont, _uM("name" to "guanbi", "color" to "#ccc", "size" to "18", "class" to "", "onClick" to close))
                            )),
                            _cE("view", _uM("class" to "aiwindow"), _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(_ctx.tools, fun(item, index, __index, _cached): Any {
                                    return _cE("view", _uM("key" to index), _uA(
                                        _cE("view", _uM("class" to "aiitems display-flex", "onClick" to fun(){
                                            clickItem(item)
                                        }
                                        ), _uA(
                                            _cV(_component_x_iconfont, _uM("name" to item["icon"], "height" to 62, "color" to "#1678fd", "size" to "23", "class" to "toolicon"), null, 8, _uA(
                                                "name"
                                            )),
                                            _cE("view", _uM("class" to "toolinfo"), _uA(
                                                _cE("text", _uM("class" to "tool-title"), _tD(item["name"]), 1),
                                                _cE("text", _uM("class" to "tool-content"), _tD(item["content"]), 1)
                                            ))
                                        ), 8, _uA(
                                            "onClick"
                                        ))
                                    ))
                                }
                                ), 128)
                            ))
                        ))
                    )
                }
                ), "_" to 1), 8, _uA(
                    "modelValue"
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
                return _uM("aiorders" to _pS(_uM("position" to "relative", "width" to "590rpx", "height" to "auto")), "title" to _uM(".aiorders " to _uM("paddingTop" to 12, "paddingBottom" to 12, "textAlign" to "center", "fontSize" to 15, "color" to "#000000")), "guanbiicon" to _uM(".aiorders " to _uM("position" to "absolute", "right" to 10, "top" to 10)), "aiitems" to _uM(".aiorders .aiwindow " to _uM("width" to "514rpx", "height" to 62, "borderTopLeftRadius" to 4, "borderTopRightRadius" to 4, "borderBottomRightRadius" to 4, "borderBottomLeftRadius" to 4, "backgroundColor" to "#F0F6FF", "marginTop" to 0, "marginRight" to "auto", "marginBottom" to 8, "marginLeft" to "auto", "paddingLeft" to 12)), "toolinfo" to _uM(".aiorders .aiwindow .aiitems " to _uM("marginLeft" to 10)), "tool-title" to _uM(".aiorders .aiwindow .aiitems .toolinfo " to _uM("paddingTop" to 12, "paddingBottom" to 4, "color" to "#474747", "fontSize" to 15)), "tool-content" to _uM(".aiorders .aiwindow .aiitems .toolinfo " to _uM("color" to "#9E9E9E", "fontSize" to 12)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("update:show" to null, "toolClick" to null)
        var props = _nP(_uM("show" to _uM("type" to "Boolean", "default" to false), "title" to _uM("type" to "String", "default" to "选择入库方式"), "tools" to _uM("type" to "Object", "default" to fun(): UTSArray<Any?> {
            return _uA()
        }
        )))
        var propsNeedCastKeys = _uA(
            "show",
            "title"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
