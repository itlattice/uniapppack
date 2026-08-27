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
open class GenPagesComponentNestedScrollBodyNestedScrollBody : BasePage {
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
    open var data: DataType__43
        get() {
            return unref(this.`$exposed`["data"]) as DataType__43
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var testBodyScrollBy: (y: Number) -> Unit
        get() {
            return unref(this.`$exposed`["testBodyScrollBy"]) as (y: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "testBodyScrollBy", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentNestedScrollBodyNestedScrollBody, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentNestedScrollBodyNestedScrollBody
            val _cache = __ins.renderCache
            val data = reactive(DataType__43(scrollData = _uA<String>(), swiperList = _uA<UTSJSONObject>(), scrollTop = 0, refresherTriggered = false, pullingDistance = 0, resetting = false, testScrollTop = 0))
            val state = computed(fun(): Number {
                if (data.resetting) {
                    return 3
                }
                if (data.refresherTriggered) {
                    return 2
                }
                if (data.pullingDistance > 45) {
                    return 1
                } else {
                    return 0
                }
            }
            )
            val onRefresherpulling = fun(e: RefresherEvent){
                data.pullingDistance = e.detail.dy
            }
            val onRefresherrefresh = fun(){
                data.refresherTriggered = true
                setTimeout(fun(){
                    data.refresherTriggered = false
                    data.resetting = true
                }
                , 1500)
            }
            val onRefreshrestore = fun(){
                data.pullingDistance = 0
                data.resetting = false
            }
            val testBodyScrollBy = fun(y: Number){
                data.scrollTop = y
            }
            val scrollEnd = fun(e: UniScrollEvent){
                data.testScrollTop = e.detail.scrollTop
                console.log("testScrollTop:", data.testScrollTop)
            }
            onLoad(fun(_options){
                setTimeout(fun(){
                    data.swiperList = _uA(
                        _uO("type" to "list1"),
                        _uO("type" to "list2"),
                        _uO("type" to "list3")
                    )
                    var lists: UTSArray<String> = _uA()
                    run {
                        var i: Number = 0
                        while(i < 30){
                            lists.push("item---" + i)
                            i++
                        }
                    }
                    data.scrollData = lists
                }
                , 500)
            }
            )
            __expose(_uM("data" to data, "testBodyScrollBy" to testBodyScrollBy))
            return fun(): Any? {
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1")), "type" to "nested", "direction" to "vertical", "refresher-enabled" to "true", "refresher-default-style" to "none", "bounces" to "false", "refresher-triggered" to unref(data).refresherTriggered, "onRefresherpulling" to onRefresherpulling, "onRefresherrefresh" to onRefresherrefresh, "onRefresherrestore" to onRefreshrestore, "onScrollend" to scrollEnd), _uA(
                    _cE("nested-scroll-header", null, _uA(
                        _cE("swiper", _uM("ref" to "header", "indicator-dots" to "true", "circular" to "true"), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(3, fun(i, __key, __index, _cached): Any {
                                return _cE("swiper-item", _uM("item-id" to i), _uA(
                                    _cE("image", _uM("src" to "/static/shuijiao.jpg", "style" to _nS(_uM("width" to "100%", "height" to "240px"))), null, 4)
                                ), 8, _uA(
                                    "item-id"
                                ))
                            }
                            ), 64)
                        ), 512)
                    )),
                    _cE("nested-scroll-body", null, _uA(
                        _cE("view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                            _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row"))), _uA(
                                _cE("text", _uM("style" to _nS(_uM("padding" to "12px 15px"))), "nested-scroll-body", 4)
                            ), 4),
                            _cE("swiper", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(unref(data).swiperList, fun(item, __key, __index, _cached): Any {
                                    return _cE("swiper-item", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                                        _cE("list-view", _uM("bounces" to "false", "id" to "body-list", "scroll-top" to unref(data).scrollTop, "style" to _nS(_uM("flex" to "1")), "key" to item["type"], "associative-container" to "nested-scroll-view", "refresher-enabled" to false), _uA(
                                            _cE(Fragment, null, RenderHelpers.renderList(unref(data).scrollData, fun(key, __key, __index, _cached): Any {
                                                return _cE("list-item", _uM("key" to key), _uA(
                                                    _cE("view", _uM("class" to "scroll-item"), _uA(
                                                        _cE("text", _uM("class" to "scroll-item-title"), _tD(key), 1)
                                                    ))
                                                ))
                                            }
                                            ), 128)
                                        ), 12, _uA(
                                            "scroll-top"
                                        ))
                                    ), 4)
                                }
                                ), 256)
                            ), 4)
                        ), 4)
                    )),
                    _cV(unref(GenPagesTemplateCustomRefresherRefreshBoxRefreshBoxClass), _uM("slot" to "refresher", "state" to unref(state)), null, 8, _uA(
                        "state"
                    ))
                ), 44, _uA(
                    "refresher-triggered"
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
                return _uM("scroll-item" to _pS(_uM("marginLeft" to 6, "marginRight" to 6, "marginTop" to 6, "backgroundColor" to "#ffffff", "borderTopLeftRadius" to 4, "borderTopRightRadius" to 4, "borderBottomRightRadius" to 4, "borderBottomLeftRadius" to 4)), "scroll-item-title" to _pS(_uM("width" to "100%", "height" to 60, "lineHeight" to "60px", "textAlign" to "center", "color" to "#555555")), "scroll-header-tiem" to _pS(_uM("height" to 200, "backgroundColor" to "#66ccff", "alignItems" to "center", "justifyContent" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
