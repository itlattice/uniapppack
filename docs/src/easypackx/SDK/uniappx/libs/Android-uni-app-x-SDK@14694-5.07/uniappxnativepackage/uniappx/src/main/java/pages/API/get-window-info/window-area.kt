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
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
open class GenPagesAPIGetWindowInfoWindowArea : BasePage {
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
        var setup: (__props: GenPagesAPIGetWindowInfoWindowArea) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIGetWindowInfoWindowArea
            val _cache = __ins.renderCache
            val statusBarArea = ref(StatusBarArea(width = 0, height = 0))
            val cutoutArea = ref(_uA<CutoutArea>())
            val safeArea = ref(SafeArea__1(top = 0, left = 0, width = 0, height = 0))
            val bottomNavigationIndicatorArea = ref(BottomNavigationIndicatorArea(width = 0, height = 0))
            val isStatusBarShow = ref(false)
            val isBottomNavigationIndicatorShow = ref(false)
            val getWindowInfo = fun(){
                val info = uni_getWindowInfo()
                statusBarArea.value.width = info.windowWidth
                statusBarArea.value.height = info.safeAreaInsets.top
                cutoutArea.value.length = 0
                (info.cutoutArea ?: _uA()).forEach(fun(item){
                    cutoutArea.value.push(CutoutArea(top = item.top, left = item.left, width = item.right - item.left, height = item.bottom - item.top))
                }
                )
                safeArea.value.top = info.safeArea.top
                safeArea.value.left = info.safeArea.left
                safeArea.value.width = info.safeArea.width
                safeArea.value.height = info.safeArea.height
                bottomNavigationIndicatorArea.value.width = info.windowWidth
                bottomNavigationIndicatorArea.value.height = info.safeAreaInsets.bottom
            }
            onReady(fun(){
                val pages = getCurrentPages()
                isStatusBarShow.value = !(pages[pages.length - 1].getPageStyle()["hideStatusBar"] as Boolean)
                isBottomNavigationIndicatorShow.value = !(pages[pages.length - 1].getPageStyle()["hideBottomNavigationIndicator"] as Boolean)
                getWindowInfo()
            }
            )
            onResize(fun(_: OnResizeOptions){
                getWindowInfo()
            }
            )
            return fun(): Any? {
                return _cE("view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    if (isTrue(unref(statusBarArea).width > 0 && unref(statusBarArea).height > 0)) {
                        _cE("view", _uM("key" to 0, "id" to "statusBar", "class" to "statusBar", "style" to _nS(_uM("width" to unref(statusBarArea).width, "height" to unref(statusBarArea).height))), null, 4)
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    if (unref(cutoutArea).length > 0) {
                        _cE(Fragment, _uM("key" to 1), RenderHelpers.renderList(unref(cutoutArea), fun(item, _, __index, _cached): Any {
                            return _cE("view", _uM("id" to "cutoutArea", "class" to "cutoutArea", "style" to _nS(_uM("top" to item.top, "left" to item.left, "width" to item.width, "height" to item.height))), null, 4)
                        }), 256)
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    _cE("view", _uM("id" to "safeArea", "class" to "safeArea", "style" to _nS(_uM("top" to unref(safeArea).top, "left" to unref(safeArea).left, "width" to unref(safeArea).width, "height" to unref(safeArea).height))), null, 4),
                    if (isTrue(unref(bottomNavigationIndicatorArea).width > 0 && unref(bottomNavigationIndicatorArea).height > 0)) {
                        _cE("view", _uM("key" to 2, "id" to "bottomNavigationIndicator", "class" to "bottomNavigationIndicator", "style" to _nS(_uM("width" to unref(bottomNavigationIndicatorArea).width, "height" to unref(bottomNavigationIndicatorArea).height))), null, 4)
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    _cE("view", _uM("style" to _nS(_uM("flex" to "1", "justify-content" to "center", "align-items" to "center"))), _uA(
                        if (isTrue(unref(statusBarArea).width > 0 && unref(statusBarArea).height > 0)) {
                            _cE("view", _uM("key" to 0, "style" to _nS(_uM("margin" to "5px 0"))), _uA(
                                _cE("text", _uM("style" to _nS(_uM("color" to "red"))), "系统状态栏区域", 4)
                            ), 4)
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        if (unref(cutoutArea).length > 0) {
                            _cE("view", _uM("key" to 1, "style" to _nS(_uM("margin" to "5px 0"))), _uA(
                                _cE("text", _uM("style" to _nS(_uM("color" to "orange"))), "摄像头区域", 4)
                            ), 4)
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        _cE("view", _uM("style" to _nS(_uM("margin" to "5px 0"))), _uA(
                            _cE("text", _uM("style" to _nS(_uM("color" to "green"))), "安全区域", 4)
                        ), 4),
                        if (isTrue(unref(bottomNavigationIndicatorArea).width > 0 && unref(bottomNavigationIndicatorArea).height > 0)) {
                            _cE("view", _uM("key" to 2, "style" to _nS(_uM("margin" to "5px 0"))), _uA(
                                _cE("text", _uM("style" to _nS(_uM("color" to "blue"))), "系统导航栏区域", 4)
                            ), 4)
                        } else {
                            _cC("v-if", true)
                        }
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
                return _uM("statusBar" to _pS(_uM("position" to "absolute", "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#FF0000", "borderRightColor" to "#FF0000", "borderBottomColor" to "#FF0000", "borderLeftColor" to "#FF0000", "borderTopWidth" to 4, "borderRightWidth" to 4, "borderBottomWidth" to 4, "borderLeftWidth" to 4)), "cutoutArea" to _pS(_uM("position" to "absolute", "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#FFA500", "borderRightColor" to "#FFA500", "borderBottomColor" to "#FFA500", "borderLeftColor" to "#FFA500", "borderTopWidth" to 4, "borderRightWidth" to 4, "borderBottomWidth" to 4, "borderLeftWidth" to 4)), "safeArea" to _pS(_uM("position" to "absolute", "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#008000", "borderRightColor" to "#008000", "borderBottomColor" to "#008000", "borderLeftColor" to "#008000", "borderTopWidth" to 4, "borderRightWidth" to 4, "borderBottomWidth" to 4, "borderLeftWidth" to 4)), "bottomNavigationIndicator" to _pS(_uM("position" to "absolute", "bottom" to 0, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#0000FF", "borderRightColor" to "#0000FF", "borderBottomColor" to "#0000FF", "borderLeftColor" to "#0000FF", "borderTopWidth" to 4, "borderRightWidth" to 4, "borderBottomWidth" to 4, "borderLeftWidth" to 4)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
