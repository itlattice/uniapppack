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
open class GenPagesComponentWebViewWebViewScroll : BasePage {
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
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentWebViewWebViewScroll) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentWebViewWebViewScroll
            val _cache = __ins.renderCache
            val types = _uA(
                ItemType(value = 0, name = "all"),
                ItemType(value = 1, name = "vertical"),
                ItemType(value = 2, name = "horizontal"),
                ItemType(value = 3, name = "none")
            ) as UTSArray<ItemType>
            val type = ref("all")
            val onTypeChange = fun(value: Number){
                type.value = types[value].name
            }
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_web_view = resolveComponent("web-view")
                return _cE(Fragment, null, _uA(
                    _cV(_component_enum_data, _uM("title" to "android-nested-scroll（默认值为all）", "items" to types, "onChange" to onTypeChange)),
                    _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                        _cE(Fragment, null, RenderHelpers.renderList(5, fun(item, __key, __index, _cached): Any {
                            return _cE("view", _uM("class" to "scroll-item"), _uA(
                                _cE("text", _uM("class" to "scroll-item-title"), "item" + _tD(item), 1)
                            ))
                        }
                        ), 64),
                        _cV(_component_web_view, _uM("class" to "web-view", "src" to "/hybrid/html/local.html", "android-nested-scroll" to unref(type)), null, 8, _uA(
                            "android-nested-scroll"
                        )),
                        _cE(Fragment, null, RenderHelpers.renderList(5, fun(item, __key, __index, _cached): Any {
                            return _cE("view", _uM("class" to "scroll-item"), _uA(
                                _cE("text", _uM("class" to "scroll-item-title"), "item" + _tD(item), 1)
                            ))
                        }
                        ), 64),
                        _cV(_component_web_view, _uM("class" to "web-view", "src" to "/hybrid/html/simple.html", "android-nested-scroll" to unref(type)), null, 8, _uA(
                            "android-nested-scroll"
                        )),
                        _cE(Fragment, null, RenderHelpers.renderList(5, fun(item, __key, __index, _cached): Any {
                            return _cE("view", _uM("class" to "scroll-item"), _uA(
                                _cE("text", _uM("class" to "scroll-item-title"), "item" + _tD(item), 1)
                            ))
                        }
                        ), 64),
                        _cE("text", _uM("style" to _nS(_uM("color" to "coral", "text-align" to "center", "margin-top" to "6px"))), "下面是测试嵌套横向滚动scroll-view的场景", 4),
                        _cE("scroll-view", _uM("style" to _nS(_uM("flex-direction" to "row")), "direction" to "horizontal"), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(5, fun(item, __key, __index, _cached): Any {
                                return _cE("view", _uM("class" to "scroll-item2"), _uA(
                                    _cE("text", _uM("class" to "scroll-item-title2"), "item" + _tD(item), 1)
                                ))
                            }
                            ), 64),
                            _cV(_component_web_view, _uM("class" to "web-view", "src" to "/hybrid/html/local.html", "android-nested-scroll" to unref(type)), null, 8, _uA(
                                "android-nested-scroll"
                            )),
                            _cE(Fragment, null, RenderHelpers.renderList(5, fun(item, __key, __index, _cached): Any {
                                return _cE("view", _uM("class" to "scroll-item2"), _uA(
                                    _cE("text", _uM("class" to "scroll-item-title2"), "item" + _tD(item), 1)
                                ))
                            }
                            ), 64),
                            _cV(_component_web_view, _uM("class" to "web-view", "src" to "/hybrid/html/simple.html", "android-nested-scroll" to unref(type)), null, 8, _uA(
                                "android-nested-scroll"
                            )),
                            _cE(Fragment, null, RenderHelpers.renderList(5, fun(item, __key, __index, _cached): Any {
                                return _cE("view", _uM("class" to "scroll-item2"), _uA(
                                    _cE("text", _uM("class" to "scroll-item-title2"), "item" + _tD(item), 1)
                                ))
                            }
                            ), 64)
                        ), 4),
                        _cE(Fragment, null, RenderHelpers.renderList(5, fun(item, __key, __index, _cached): Any {
                            return _cE("view", _uM("class" to "scroll-item"), _uA(
                                _cE("text", _uM("class" to "scroll-item-title"), "item" + _tD(item), 1)
                            ))
                        }
                        ), 64)
                    ), 4)
                ), 64)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("web-view" to _pS(_uM("width" to 300, "height" to 300, "marginLeft" to 6, "marginRight" to 6, "marginTop" to 6, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#000000", "borderRightColor" to "#000000", "borderBottomColor" to "#000000", "borderLeftColor" to "#000000", "alignSelf" to "center")), "scroll-item" to _pS(_uM("marginLeft" to 6, "marginRight" to 6, "marginTop" to 6, "backgroundColor" to "#ffffff")), "scroll-item2" to _pS(_uM("width" to 80, "justifyContent" to "center", "marginLeft" to 6, "marginRight" to 6, "marginTop" to 6, "backgroundColor" to "#ffffff")), "scroll-item-title" to _pS(_uM("lineHeight" to "60px", "textAlign" to "center", "color" to "#555555")), "scroll-item-title2" to _pS(_uM("textAlign" to "center", "color" to "#555555")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
