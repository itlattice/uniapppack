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
open class GenPagesCSSBorderDynamicBorder : BasePage {
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
    open var changeIndex: (index: Number) -> Unit
        get() {
            return unref(this.`$exposed`["changeIndex"]) as (index: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "changeIndex", value)
        }
    open var setBorderBlank: () -> Unit
        get() {
            return unref(this.`$exposed`["setBorderBlank"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "setBorderBlank", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesCSSBorderDynamicBorder, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSBorderDynamicBorder
            val _cache = __ins.renderCache
            val defaultStyle = "border:2px solid black;background :#57BE6A;"
            val currentIndex = ref(0)
            val style = ref("" as String)
            val isSelect = computed(fun(): Boolean {
                return style.value == defaultStyle
            }
            )
            val changeIndex = fun(index: Number){
                currentIndex.value = index
            }
            val setBorderBlank = fun(){
                style.value = if (style.value == "") {
                    defaultStyle
                } else {
                    ""
                }
            }
            __expose(_uM("changeIndex" to changeIndex, "setBorderBlank" to setBorderBlank))
            return fun(): Any? {
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("style" to _nS(_uM("margin" to "15px", "border-radius" to "10px", "background-color" to "white"))), _uA(
                        _cE(Fragment, null, RenderHelpers.renderList(_uA(
                            0,
                            1,
                            2,
                            3,
                            4,
                            5,
                            6,
                            7,
                            8,
                            9
                        ), fun(index, __key, __index, _cached): Any {
                            return _cE("view", _uM("key" to index, "class" to _nC((if (index < 9) {
                                "bb1"
                            } else {
                                ""
                            }
                            ) + " " + (if (unref(currentIndex) == 0) {
                                "btlr10 btrr10"
                            } else {
                                if (unref(currentIndex) == 9) {
                                    "bblr10 bbrr10"
                                } else {
                                    ""
                                }
                            }
                            )), "style" to _nS(_uA(
                                _uM("flex-direction" to "row", "align-items" to "center", "padding" to "15px"),
                                if (index == unref(currentIndex)) {
                                    "background-color :#57BE6A;"
                                } else {
                                    ""
                                }
                            )), "onClick" to fun(){
                                changeIndex(index)
                            }
                            ), _uA(
                                _cE("view", null, _uA(
                                    _cE("text", _uM("style" to _nS(_uA(
                                        _uM("font-size" to "14px"),
                                        if (index == unref(currentIndex)) {
                                            "color: #FFFFFF;"
                                        } else {
                                            ""
                                        }
                                    ))), _tD(index), 5)
                                ))
                            ), 14, _uA(
                                "onClick"
                            ))
                        }
                        ), 64)
                    ), 4),
                    _cE("view", _uM("style" to _nS(_uM("margin" to "15px", "margin-top" to "20px"))), _uA(
                        _cE("text", null, "动态切换 border 为空值"),
                        _cE("text", _uM("onClick" to setBorderBlank, "class" to "common", "style" to _nS(unref(style))), _tD(if (unref(isSelect)) {
                            "选中"
                        } else {
                            "未选中"
                        }
                        ), 5)
                    ), 4)
                ), 4)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("common" to _pS(_uM("paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15, "borderTopLeftRadius" to 4, "borderTopRightRadius" to 4, "borderBottomRightRadius" to 4, "borderBottomLeftRadius" to 4, "width" to 120, "textAlign" to "center", "marginTop" to 10)), "bb1" to _pS(_uM("borderBottomWidth" to "1rpx", "borderBottomStyle" to "solid", "borderBottomColor" to "#EEEEEE")), "btlr10" to _pS(_uM("borderTopLeftRadius" to "10rpx")), "btrr10" to _pS(_uM("borderTopRightRadius" to "10rpx")), "bblr10" to _pS(_uM("borderBottomLeftRadius" to "10rpx")), "bbrr10" to _pS(_uM("borderBottomRightRadius" to "10rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
