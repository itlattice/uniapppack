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
open class GenPagesComponentNestedScrollHeaderNestedScrollHeader : BasePage {
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
        var setup: (__props: GenPagesComponentNestedScrollHeaderNestedScrollHeader) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentNestedScrollHeaderNestedScrollHeader
            val _cache = __ins.renderCache
            val scrollData = ref(_uA<String>())
            val num = ref(0)
            val headerRef = ref<UniSwiperElement?>(null)
            onLoad(fun(_options){
                var lists: UTSArray<String> = _uA()
                run {
                    var i: Number = 0
                    while(i < 30){
                        lists.push("item---" + i)
                        i++
                    }
                }
                scrollData.value = lists
            }
            )
            onReady(fun(){
                num.value = 3
            }
            )
            return fun(): Any? {
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1")), "type" to "nested", "direction" to "vertical"), _uA(
                    _cE("nested-scroll-header", null, _uA(
                        _cE("view", _uM("class" to "scroll-header-tiem1"), _uA(
                            _cE("text", null, "会渲染的nested-scroll-header")
                        ))
                    )),
                    _cE("nested-scroll-header", null, _uA(
                        _cE("swiper", _uM("ref_key" to "headerRef", "ref" to headerRef, "indicator-dots" to "true", "circular" to "true"), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(unref(num), fun(i, __key, __index, _cached): Any {
                                return _cE("swiper-item", _uM("item-id" to i), _uA(
                                    _cE("view", _uM("class" to "scroll-header-tiem2"), _uA(
                                        _cE("text", null, "如果存在多个头部节点，那么就使用多个 nested-scroll-header 来将其包裹")
                                    ))
                                ), 8, _uA(
                                    "item-id"
                                ))
                            }
                            ), 256)
                        ), 512)
                    )),
                    _cE("nested-scroll-body", null, _uA(
                        _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1")), "associative-container" to "nested-scroll-view"), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(unref(scrollData), fun(key, __key, __index, _cached): Any {
                                return _cE("view", null, _uA(
                                    _cE("view", _uM("class" to "scroll-item"), _uA(
                                        _cE("text", _uM("class" to "scroll-item-title"), _tD(key), 1)
                                    ))
                                ))
                            }
                            ), 256)
                        ), 4)
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
                return _uM("scroll-item" to _pS(_uM("marginLeft" to 6, "marginRight" to 6, "marginTop" to 6, "backgroundColor" to "#ffffff", "borderTopLeftRadius" to 4, "borderTopRightRadius" to 4, "borderBottomRightRadius" to 4, "borderBottomLeftRadius" to 4)), "scroll-item-title" to _pS(_uM("width" to "100%", "height" to 60, "lineHeight" to "60px", "textAlign" to "center", "color" to "#555555")), "scroll-header-tiem1" to _pS(_uM("height" to 200, "backgroundColor" to "#66ccff", "alignItems" to "center", "justifyContent" to "center")), "scroll-header-tiem2" to _pS(_uM("height" to 100, "backgroundColor" to "#89ff8d", "alignItems" to "center", "justifyContent" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
