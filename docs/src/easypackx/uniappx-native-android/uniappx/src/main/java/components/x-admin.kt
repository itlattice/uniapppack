@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNI2971F61
import android.content.Context
import io.dcloud.uniapp.*
import io.dcloud.uniapp.extapi.*
import io.dcloud.uniapp.framework.*
import io.dcloud.uniapp.runtime.*
import io.dcloud.uniapp.vue.*
import io.dcloud.uniapp.vue.shared.*
import io.dcloud.uts.*
import io.dcloud.uts.Map
import io.dcloud.uts.Set
import io.dcloud.uts.UTSAndroid
import kotlin.properties.Delegates
import uts.sdk.modules.iboxsChooseMedia.MediaScanner
open class GenComponentsXAdmin : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var user: UTSJSONObject by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXAdmin) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXAdmin
            val _cache = __ins.renderCache
            val props = __props
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val user = computed(fun(): UTSJSONObject {
                return props.user
            }
            )
            val callPhone = fun(){
                var phone = props.user["phone"] as String
                if (phone != "") {
                    common.callPhone(phone)
                }
            }
            val chooseUser = fun(){
                emit("clk", props.user)
            }
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_fui_swipe_action = resolveEasyComponent("fui-swipe-action", GenUniModulesFirstuiUvueComponentsFuiSwipeActionFuiSwipeActionClass)
                return _cV(_component_fui_swipe_action, _uM("class" to "xadmin background-white"), _uM("buttons" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "fui-menu__box display-flex"), _uA(
                            _cE("view", _uM("class" to "fui-menu__btn background-main"), _uA(
                                _cV(_component_x_iconfont, _uM("class" to "icon", "name" to "fasongyoujian", "color" to "white", "size" to "24"))
                            )),
                            _cE("view", _uM("class" to "fui-menu__btn", "onClick" to callPhone, "style" to _nS(_uM("background-color" to "#FFC300"))), _uA(
                                _cV(_component_x_iconfont, _uM("class" to "icon", "name" to "dadianhua", "color" to "white", "size" to "24"))
                            ), 4)
                        ))
                    )
                }
                ), "default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "userinfo", "onClick" to chooseUser), _uA(
                            _cE("view", _uM("class" to "basicinfo display-flex"), _uA(
                                _cE("text", _uM("class" to "zhiwutag color-white", "style" to _nS(_uM("background-color" to "#FFC300"))), "店长", 4),
                                _cE("text", _uM("class" to "name"), _tD(unref(user)["name"]), 1),
                                _cE("text", _uM("class" to "no"), _uA(
                                    "工号：",
                                    _cE("text", _uM("class" to "redno"), _tD(unref(user)["no"]), 1)
                                ))
                            )),
                            _cE("view", _uM("class" to "lineinfo"), _uA(
                                _cE("text", _uM("class" to "content", "style" to _nS(_uM("font-size" to "15px"))), "职务：店长", 4),
                                _cE("text", _uM("class" to "content"), "最后登录时间：" + _tD(unref(user)["login_time"]), 1)
                            ))
                        ))
                    )
                }
                ), "_" to 1))
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("fui-menu__box" to _pS(_uM("width" to 160, "display" to "flex", "height" to 80, "alignItems" to "center", "justifyContent" to "center")), "fui-menu__btn" to _pS(_uM("width" to 80, "height" to 80, "paddingLeft" to 30, "justifyContent" to "center")), "xadmin" to _pS(_uM("height" to 80, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#E6E6E6")), "userinfo" to _uM(".xadmin " to _uM("paddingLeft" to "18rpx", "paddingTop" to 10)), "zhiwutag" to _uM(".xadmin .userinfo .basicinfo " to _uM("width" to 32, "height" to 16, "borderTopLeftRadius" to 4, "borderTopRightRadius" to 4, "borderBottomRightRadius" to 4, "borderBottomLeftRadius" to 4, "backgroundImage" to "none", "backgroundColor" to "#FFC300", "textAlign" to "center", "fontSize" to 12, "lineHeight" to "16px")), "name" to _uM(".xadmin .userinfo .basicinfo " to _uM("marginLeft" to "20rpx", "fontSize" to 16)), "no" to _uM(".xadmin .userinfo .basicinfo " to _uM("marginLeft" to "30rpx", "fontSize" to 12, "color" to "#787878", "lineHeight" to "16px")), "redno" to _uM(".xadmin .userinfo .basicinfo .no " to _uM("lineHeight" to "16px", "fontSize" to 12, "color" to "#FF5733")), "lineinfo" to _uM(".xadmin .userinfo " to _uM("marginTop" to 6)), "content" to _uM(".xadmin .userinfo .lineinfo " to _uM("fontSize" to 13, "color" to "#9E9E9E", "lineHeight" to "18px")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("clk" to null)
        var props = _nP(_uM("user" to _uM("type" to "UTSJSONObject", "default" to _uO())))
        var propsNeedCastKeys = _uA(
            "user"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
