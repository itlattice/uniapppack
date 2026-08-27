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
open class GenPagesCSSBorderIssues23230 : BasePage {
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
        var setup: (__props: GenPagesCSSBorderIssues23230) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSBorderIssues23230
            val _cache = __ins.renderCache
            val info = ref<UTSArray<String>?>(null)
            onMounted(fun(){
                setTimeout(fun(){
                    val arr = UTSArray<String>()
                    run {
                        var i: Number = 0
                        while(i < 15){
                            arr.push(i.toString(10))
                            i++
                        }
                    }
                    info.value = arr
                }
                , 500)
            }
            )
            return fun(): Any? {
                return _cE("scroll-view", _uM("class" to "content"), _uA(
                    if (unref(info) == null) {
                        _cE("text", _uM("key" to 0), "正在加载数据")
                    } else {
                        _cE("view", _uM("key" to 1, "class" to "vipView"), _uA(
                            _cE("scroll-view", _uM("class" to "functionVip", "direction" to "horizontal", "show-scrollbar" to false), _uA(
                                _cE("view", _uM("style" to _nS(_uM("height" to "2rpx", "width" to "36rpx"))), null, 4),
                                _cE(Fragment, null, RenderHelpers.renderList(unref(info), fun(index, __key, __index, _cached): Any {
                                    return _cE("view", _uM("class" to "item"), _uA(
                                        _cE("image", _uM("src" to "/static/test-image/logo.png", "mode" to "aspectFill", "class" to "icon")),
                                        _cE("text", _uM("class" to "text ell"), "按钮" + _tD(index + 1), 1)
                                    ))
                                }
                                ), 256),
                                _cE("view", _uM("style" to _nS(_uM("height" to "2rpx", "width" to "20rpx"))), null, 4)
                            )),
                            _cE("view", _uM("class" to "borderBtn"), _uA(
                                _cE("text", _uM("class" to "text borderBtn-text"), "有圆角及边框")
                            ))
                        ))
                    }
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
                return _uM("content" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "paddingTop" to 0, "paddingRight" to "30rpx", "paddingBottom" to 0, "paddingLeft" to "30rpx", "backgroundImage" to "none", "backgroundColor" to "#FFFFFF")), "vipView" to _pS(_uM("backgroundImage" to "none", "backgroundColor" to "#f6f7f9", "paddingTop" to "20rpx", "paddingRight" to 0, "paddingBottom" to "36rpx", "paddingLeft" to 0, "borderTopLeftRadius" to "20rpx", "borderTopRightRadius" to "20rpx", "borderBottomRightRadius" to "20rpx", "borderBottomLeftRadius" to "20rpx", "marginBottom" to "22rpx")), "head" to _pS(_uM("flexDirection" to "row", "alignItems" to "center", "height" to "60rpx", "paddingTop" to 0, "paddingRight" to "36rpx", "paddingBottom" to 0, "paddingLeft" to "36rpx")), "functionVip" to _pS(_uM("flexDirection" to "row", "marginTop" to "10rpx")), "item" to _pS(_uM("flexDirection" to "column", "alignItems" to "center", "justifyContent" to "center", "position" to "relative", "width" to "180rpx", "backgroundImage" to "none", "backgroundColor" to "#FFFFFF", "paddingTop" to "34rpx", "paddingRight" to "10rpx", "paddingBottom" to "34rpx", "paddingLeft" to "10rpx", "borderTopLeftRadius" to "20rpx", "borderTopRightRadius" to "20rpx", "borderBottomRightRadius" to "20rpx", "borderBottomLeftRadius" to "20rpx", "marginRight" to "16rpx", "overflow" to "hidden")), "icon" to _pS(_uM("width" to "70rpx", "height" to "70rpx", "borderTopLeftRadius" to "70rpx", "borderTopRightRadius" to "70rpx", "borderBottomRightRadius" to "70rpx", "borderBottomLeftRadius" to "70rpx")), "btn" to _pS(_uM("flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "borderTopLeftRadius" to "100rpx", "borderTopRightRadius" to "100rpx", "borderBottomRightRadius" to "100rpx", "borderBottomLeftRadius" to "100rpx", "backgroundImage" to "none", "backgroundColor" to "#1770d6", "marginTop" to "30rpx", "marginRight" to "36rpx", "marginBottom" to 0, "marginLeft" to "36rpx", "height" to "84rpx")), "borderBtn" to _pS(_uM("flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "borderTopWidth" to "4rpx", "borderRightWidth" to "4rpx", "borderBottomWidth" to "4rpx", "borderLeftWidth" to "4rpx", "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#0000FF", "borderRightColor" to "#0000FF", "borderBottomColor" to "#0000FF", "borderLeftColor" to "#0000FF", "borderTopLeftRadius" to "100rpx", "borderTopRightRadius" to "100rpx", "borderBottomRightRadius" to "100rpx", "borderBottomLeftRadius" to "100rpx", "backgroundImage" to "none", "backgroundColor" to "#FFFFFF", "marginTop" to "30rpx", "marginRight" to "36rpx", "marginBottom" to 0, "marginLeft" to "36rpx", "height" to "84rpx")), "text" to _pS(_uM("fontSize" to "22rpx", "width" to "100%", "textAlign" to "center", "lineHeight" to 1.1, "marginTop" to "15rpx", "color" to "#7a90a8")), "borderBtn-text" to _pS(_uM("color" to "#1770d6", "fontSize" to "28rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
