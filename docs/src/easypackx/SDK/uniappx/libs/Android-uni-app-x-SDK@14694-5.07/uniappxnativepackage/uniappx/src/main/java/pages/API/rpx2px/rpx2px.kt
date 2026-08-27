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
import io.dcloud.uniapp.extapi.rpx2px as uni_rpx2px
open class GenPagesAPIRpx2pxRpx2px : BasePage {
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
    open var data: DataType__95
        get() {
            return unref(this.`$exposed`["data"]) as DataType__95
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIRpx2pxRpx2px, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIRpx2pxRpx2px
            val _cache = __ins.renderCache
            val data = reactive(DataType__95(title = "rpx2px", rpxValue = 750, pxValue = 0, result = false))
            val rpx2px = fun(){
                data.pxValue = uni_rpx2px(data.rpxValue)
                val windowInfo = uni_getWindowInfo()
                if (windowInfo.windowWidth == data.pxValue) {
                    data.result = true
                }
            }
            __expose(_uM("data" to data))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE("scroll-view", _uM("class" to "page-scroll-view"), _uA(
                    _cE("view", _uM("class" to "page"), _uA(
                        _cV(_component_page_head, _uM("title" to unref(data).title), null, 8, _uA(
                            "title"
                        )),
                        _cE("view", null, _uA(
                            _cE("view", _uM("class" to "item"), _uA(
                                _cE("text", _uM("class" to "item-k"), "输入:"),
                                _cE("text", _uM("class" to "item-v"), _tD(unref(data).rpxValue) + "rpx", 1)
                            )),
                            _cE("view", _uM("class" to "item"), _uA(
                                _cE("text", _uM("class" to "item-k"), "返回:"),
                                _cE("text", _uM("class" to "item-v"), _tD(unref(data).pxValue) + "px", 1)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("button", _uM("id" to "convert", "onClick" to rpx2px), "转换")
                        ))
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
                return _uM("page" to _pS(_uM("paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15)), "item" to _pS(_uM("flexDirection" to "row")), "item-k" to _pS(_uM("width" to 72, "lineHeight" to 2)), "item-v" to _pS(_uM("fontWeight" to "bold", "lineHeight" to 2)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
