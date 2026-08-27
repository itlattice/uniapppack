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
open class GenPagesComponentSwiperSwiperListView : BasePage {
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
    open var data: DataType__44
        get() {
            return unref(this.`$exposed`["data"]) as DataType__44
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentSwiperSwiperListView, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentSwiperSwiperListView
            val _cache = __ins.renderCache
            val data = reactive(DataType__44(swiperCurrentIndex = 0, currentVal = 0, scrollTop = 0, refresherTriggeredArray = _uA<Boolean>(false, false, false)))
            fun gen_swiperChange_fn(e: SwiperChangeEvent) {
                data.swiperCurrentIndex = e.detail.current
            }
            val swiperChange = ::gen_swiperChange_fn
            fun gen_onRefresherrefresh_fn() {
                data.refresherTriggeredArray[data.swiperCurrentIndex] = true
                setTimeout(fun(){
                    data.refresherTriggeredArray[data.swiperCurrentIndex] = false
                }
                , 100)
            }
            val onRefresherrefresh = ::gen_onRefresherrefresh_fn
            __expose(_uM("data" to data))
            return fun(): Any? {
                return _cE("view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("class" to "content-item"), _uA(
                        _cE("text", _uM("class" to "text"), "左右滑动页面，体验swiper嵌套list-view效果。")
                    )),
                    _cE("swiper", _uM("style" to _nS(_uM("flex" to "1")), "current" to unref(data).currentVal, "onChange" to swiperChange), _uA(
                        _cE(Fragment, null, RenderHelpers.renderList(3, fun(index, __key, __index, _cached): Any {
                            return _cE("swiper-item", null, _uA(
                                _cE("list-view", _uM("id" to ("list" + index), "style" to _nS(_uM("flex" to "1", "border" to "3px solid lime")), "refresher-enabled" to "true", "onRefresherrefresh" to onRefresherrefresh, "refresher-triggered" to unref(data).refresherTriggeredArray[index - 1], "scroll-top" to unref(data).scrollTop), _uA(
                                    _cE("sticky-header", null, _uA(
                                        _cE("text", _uM("class" to "header"), "上下滑动体验吸顶效果 swiper-item" + _tD(index), 1)
                                    )),
                                    _cE(Fragment, null, RenderHelpers.renderList(40, fun(itemIndex, __key, __index, _cached): Any {
                                        return _cE("list-item", _uM("key" to itemIndex, "class" to "item"), _uA(
                                            _cE("text", null, "item----------" + _tD(itemIndex), 1)
                                        ))
                                    }
                                    ), 64)
                                ), 44, _uA(
                                    "id",
                                    "refresher-triggered",
                                    "scroll-top"
                                ))
                            ))
                        }
                        ), 64)
                    ), 44, _uA(
                        "current"
                    ))
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
                return _uM("item" to _pS(_uM("paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15, "marginTop" to 0, "marginRight" to 0, "marginBottom" to 5, "marginLeft" to 0, "backgroundColor" to "#ffffff", "borderTopLeftRadius" to 5, "borderTopRightRadius" to 5, "borderBottomRightRadius" to 5, "borderBottomLeftRadius" to 5)), "text" to _pS(_uM("fontSize" to 14, "color" to "#666666", "lineHeight" to "20px")), "content-item" to _pS(_uM("paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15, "marginBottom" to 10, "backgroundColor" to "#ffffff")), "header" to _pS(_uM("backgroundColor" to "#ffaa00", "paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15, "textAlign" to "center", "color" to "#ffffff")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
