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
open class GenPagesComponentSwiperSwiperAnim : BasePage {
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
    open var data: DataType__9
        get() {
            return unref(this.`$exposed`["data"]) as DataType__9
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var jest_getWindowInfo: () -> GetWindowInfoResult
        get() {
            return unref(this.`$exposed`["jest_getWindowInfo"]) as () -> GetWindowInfoResult
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_getWindowInfo", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentSwiperSwiperAnim, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentSwiperSwiperAnim
            val _cache = __ins.renderCache
            val data = reactive(DataType__9(list = _uA<ListType>(ListType(id = 1, content = "第一个"), ListType(id = 2, content = "第二个"))))
            val current = computed(fun(): Number {
                return 1
            }
            )
            fun gen_jest_getWindowInfo_fn(): GetWindowInfoResult {
                return uni_getWindowInfo()
            }
            val jest_getWindowInfo = ::gen_jest_getWindowInfo_fn
            __expose(_uM("data" to data, "jest_getWindowInfo" to jest_getWindowInfo))
            return fun(): Any? {
                return _cE("view", null, _uA(
                    _cE("text", null, "computed属性在设置duration=0的测试:"),
                    _cE("swiper", _uM("current" to unref(current), "vertical" to true, "duration" to "0", "style" to _nS(_uM("height" to "100px", "width" to "100%"))), _uA(
                        _cE(Fragment, null, RenderHelpers.renderList(unref(data).list, fun(item, index, __index, _cached): Any {
                            return _cE("swiper-item", _uM("key" to item.id), _uA(
                                _cE("view", null, " 当前实际渲染的值:" + _tD(index) + ",指定current的值：" + _tD(unref(current)), 1)
                            ))
                        }
                        ), 128)
                    ), 12, _uA(
                        "current"
                    )),
                    _cE("text", null, "同时设置autoplay / circular / duration的测试:"),
                    _cE("swiper", _uM("id" to "swiper-view", "autoplay" to true, "interval" to 3000, "circular" to true, "duration" to 3000, "current" to 0, "style" to _nS(_uM("height" to "100px", "width" to "100%"))), _uA(
                        _cE("swiper-item", null, _uA(
                            _cE("text", null, "0000000000000000000")
                        )),
                        _cE("swiper-item", null, _uA(
                            _cE("text", null, "111111111111111111")
                        ))
                    ), 4)
                ))
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
