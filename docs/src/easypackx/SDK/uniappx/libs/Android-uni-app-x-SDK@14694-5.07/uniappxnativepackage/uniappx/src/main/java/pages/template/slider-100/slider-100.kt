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
open class GenPagesTemplateSlider100Slider100 : BasePage {
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
    open var updateSliderValueTest: (value: Number) -> Unit
        get() {
            return unref(this.`$exposed`["updateSliderValueTest"]) as (value: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "updateSliderValueTest", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesTemplateSlider100Slider100, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesTemplateSlider100Slider100
            val _cache = __ins.renderCache
            val title = ref("sliderx100通信性能测试(小程序卡为正常)")
            val sliderValue = ref(50)
            val sliderRef = ref(_uA<UniSliderElement>())
            fun gen_updateSliderValue_fn(value: Number) {
                sliderRef.value.forEach(fun(item){
                    item.value = value
                }
                )
            }
            val updateSliderValue = ::gen_updateSliderValue_fn
            fun gen_sliderChange_fn(e: UniSliderChangeEvent) {
                updateSliderValue(e.detail.value)
            }
            val sliderChange = ::gen_sliderChange_fn
            fun gen_sliderChanging_fn(e: UniSliderChangeEvent) {
                updateSliderValue(e.detail.value)
            }
            val sliderChanging = ::gen_sliderChanging_fn
            val updateSliderValueTest = fun(value: Number){
                sliderValue.value = value
            }
            __expose(_uM("updateSliderValueTest" to updateSliderValueTest))
            return fun(): Any? {
                val _component_fps = resolveEasyComponent("fps", GenComponentsFpsFpsClass)
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                val _component_slider = resolveComponent("slider")
                return _cE("scroll-view", _uM("class" to "page"), _uA(
                    _cV(_component_fps),
                    _cV(_component_page_head, _uM("title" to unref(title)), null, 8, _uA(
                        "title"
                    )),
                    _cE("view", _uM("class" to "grid-view"), _uA(
                        _cE(Fragment, null, RenderHelpers.renderList(100, fun(_, index, __index, _cached): Any {
                            return _cV(_component_slider, _uM("ref_for" to true, "ref_key" to "sliderRef", "ref" to sliderRef, "class" to "slider", "key" to index, "onChanging" to sliderChanging, "onChange" to sliderChange, "value" to unref(sliderValue), "block-size" to 20, "thumb-class" to "thumbclass"), null, 8, _uA(
                                "value"
                            ))
                        }
                        ), 64)
                    ))
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
                return _uM("page" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginBottom" to "var(--uni-safe-area-inset-bottom)")), "grid-view" to _pS(_uM("flexDirection" to "row", "flexWrap" to "wrap")), "slider" to _pS(_uM("width" to "25%", "marginTop" to 1, "marginRight" to 0, "marginBottom" to 1, "marginLeft" to 0)), "thumbclass" to _pS(_uM("width" to 16, "height" to 16, "borderTopLeftRadius" to 8, "borderTopRightRadius" to 8, "borderBottomRightRadius" to 8, "borderBottomLeftRadius" to 8)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
