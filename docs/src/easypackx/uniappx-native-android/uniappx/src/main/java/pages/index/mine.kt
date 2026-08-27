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
import io.dcloud.uniapp.extapi.`$emit` as uni__emit
import io.dcloud.uniapp.extapi.redirectTo as uni_redirectTo
open class GenPagesIndexMine : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            xProvitae.scrollTop = e.scrollTop
            val pages = getCurrentPages()
            if (pages.length == 0) {
                return
            }
            val page = pages[pages.length - 1].route
            uni__emit("onPageScroll", _uO("top" to e.scrollTop, "page" to page))
        }
        , __ins)
        onResize(fun(_: OnResizeOptions) {
            uni__emit("onResize", fun() {})
        }
        , __ins)
        onLoad(fun(query: OnLoadOptions) {
            xProvitae.onLoadOpts = JSON.parseObject(JSON.stringify(query)!!) ?: _uO()
            uni__emit("onLoad", fun() {})
        }
        , __ins)
        onPageHide(fun() {
            uni__emit("onHide", fun() {})
        }
        , __ins)
        onReady(fun() {
            uni__emit("onReady", fun() {})
            xProvitae.pageReady = true
        }
        , __ins)
        onPageShow(fun() {
            uni__emit("onShow", fun() {})
        }
        , __ins)
    }
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesIndexMine) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesIndexMine
            val _cache = __ins.renderCache
            val modal = ref<UniElement?>(null)
            val appVer = AppConfig.app_version()
            val userInfo = ref<userInfoType>(userInfoType(name = "", no = "", head = ""))
            val showPosition = computed(fun(): positionInfo {
                if (userInfo.value.position == null) {
                    return positionInfo(position_name = "无岗位", department_name = "无部门")
                }
                if (userInfo.value.position?.length == 0) {
                    return positionInfo(position_name = "无岗位0", department_name = "无部门")
                }
                return userInfo.value.position!![0] as positionInfo
            }
            )
            val giveWork = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var r = await(common.showQuery(modal.value as Any, "确定交班？"))
                        if (!r) {
                            return@w1
                        }
                        common.rmStorage("usertoken")
                        setUser(userInfoType())
                        uni_redirectTo(RedirectToOptions(url = "/pages/index/login"))
                })
            }
            val getUserInfo = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        var res = await(request.getUserInfo())
                        userInfo.value = getUser() as userInfoType
                        console.log(userInfo.value)
                })
            }
            onShow(fun(){
                common.navigationBar("#EDF4FA", "#000000")
            }
            )
            onLoad(fun(_options){
                getUserInfo()
            }
            )
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_x_mine_action = resolveEasyComponent("x-mine-action", GenComponentsXMineActionClass)
                val _component_l_svg = resolveEasyComponent("l-svg", GenUniModulesLimeSvgComponentsLSvgLSvgClass)
                val _component_x_button = resolveEasyComponent("x-button", GenComponentsXButtonClass)
                val _component_x_ver = resolveEasyComponent("x-ver", GenComponentsXVerClass)
                val _component_x_model = resolveEasyComponent("x-model", GenComponentsXModelClass)
                return _cE("view", null, _uA(
                    _cE("view", _uM("class" to "navigat padding-stauts-bar"), _uA(
                        _cE("view", _uM("class" to "userinfo space-between"), _uA(
                            _cE("view", _uM("class" to "user display-flex"), _uA(
                                _cE("view", _uM("class" to "avatar"), _uA(
                                    _cE("image", _uM("class" to "full", "src" to unref(userInfo).head), null, 8, _uA(
                                        "src"
                                    ))
                                )),
                                _cE("view", _uM("class" to "info"), _uA(
                                    _cE("text", _uM("class" to "nick"), _tD(unref(userInfo).name), 1),
                                    _cE("text", _uM("class" to "no"), "工号：" + _tD(unref(userInfo).no), 1)
                                ))
                            )),
                            _cE("view", _uM("class" to "action display-flex"), _uA(
                                _cV(_component_x_iconfont, _uM("class" to "icon", "name" to "shezhi", "color" to "#919191", "size" to "24")),
                                _cV(_component_x_iconfont, _uM("class" to "icon", "name" to "more", "color" to "#919191", "size" to "24"))
                            ))
                        ))
                    )),
                    _cE("view", _uM("class" to "hanndleaction background-white"), _uA(
                        _cE("view", _uM("class" to "actions list-items"), _uA(
                            _cE("view", _uM("class" to "litem actionitem"), _uA(
                                _cV(_component_x_mine_action, _uM("name" to "物流设置", "icon" to "wuliushezhi", "color" to "#1776FC"))
                            )),
                            _cE("view", _uM("class" to "litem actionitem"), _uA(
                                _cV(_component_x_mine_action, _uM("name" to "员工管理", "icon" to "yuangong", "color" to "#FF5733"))
                            )),
                            _cE("view", _uM("class" to "litem actionitem"), _uA(
                                _cV(_component_x_mine_action, _uM("name" to "角色权限", "icon" to "quanxian", "color" to "#D43030"))
                            )),
                            _cE("view", _uM("class" to "litem actionitem"), _uA(
                                _cV(_component_x_mine_action, _uM("name" to "打印设置", "icon" to "printer", "color" to "#7948EA"))
                            )),
                            _cE("view", _uM("class" to "litem actionitem"), _uA(
                                _cV(_component_x_mine_action, _uM("name" to "AI辅助", "icon" to "robot", "color" to "#2A82E4"))
                            )),
                            _cE("view", _uM("class" to "litem actionitem"), _uA(
                                _cV(_component_x_mine_action, _uM("name" to "个人信息", "icon" to "gerenxinxi", "color" to "#43CF7C"))
                            )),
                            _cE("view", _uM("class" to "litem actionitem"), _uA(
                                _cV(_component_x_mine_action)
                            ))
                        ))
                    )),
                    _cE("view", _uM("class" to "numbercard background-main margin-status-bar"), _uA(
                        _cE("view", _uM("class" to "basic space-between"), _uA(
                            _cE("view", _uM("class" to "zhiwu display-flex"), _uA(
                                _cE("text", _uM("class" to "color-white shopname"), _tD(unref(showPosition).department_name), 1),
                                _cE("text", _uM("class" to "color-white zhi"), _tD(unref(showPosition).position_name), 1)
                            )),
                            _cE("view", _uM("class" to "xinngxing display-flex"), _uA(
                                _cV(_component_l_svg, _uM("src" to "/static/images/xingxing.svg", "class" to "img")),
                                _cV(_component_l_svg, _uM("src" to "/static/images/xingxing.svg", "class" to "img")),
                                _cV(_component_l_svg, _uM("src" to "/static/images/xingxing.svg", "class" to "img"))
                            ))
                        )),
                        _cE("view", _uM("class" to "numberinfo display-flex list-items"), _uA(
                            _cE("view", _uM("class" to "infoitem litem"), _uA(
                                _cE("text", _uM("class" to "title align-center color-white"), "本月出勤"),
                                _cE("view", _uM("class" to "data display-flex"), _uA(
                                    _cE("view", _uM("class" to "num"), _uA(
                                        _cE("text", _uM("class" to "text font-bold color-white"), "20")
                                    )),
                                    _cE("view", _uM("class" to "tnum"), _uA(
                                        _cE("text", _uM("class" to "text color-white"), "/20")
                                    ))
                                ))
                            )),
                            _cE("view", _uM("class" to "infoitem litem"), _uA(
                                _cE("text", _uM("class" to "title align-center color-white"), "仓库/门店"),
                                _cE("view", _uM("class" to "data display-flex"), _uA(
                                    _cE("view", _uM("class" to "num"), _uA(
                                        _cE("text", _uM("class" to "text font-bold color-white"), "1")
                                    ))
                                ))
                            )),
                            _cE("view", _uM("class" to "infoitem litem"), _uA(
                                _cE("text", _uM("class" to "title align-center color-white"), "综合绩效分"),
                                _cE("view", _uM("class" to "data display-flex"), _uA(
                                    _cE("view", _uM("class" to "num"), _uA(
                                        _cE("text", _uM("class" to "text font-bold color-white"), "60.79")
                                    ))
                                ))
                            ))
                        ))
                    )),
                    _cE("view", _uM("class" to "action-btn"), _uA(
                        _cV(_component_x_button, _uM("class" to "casherbtn btn", "onClick" to giveWork), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                "交班/下班"
                            )
                        }
                        ), "_" to 1))
                    )),
                    _cV(_component_x_ver, _uM("ver" to unref(appVer)), null, 8, _uA(
                        "ver"
                    )),
                    _cV(_component_x_model, _uM("ref_key" to "modal", "ref" to modal), null, 512)
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
                return _uM("navigat" to _pS(_uM("height" to 158, "backgroundImage" to "none", "backgroundColor" to "#edf4fa")), "user" to _uM(".navigat .userinfo " to _uM("marginTop" to "17rpx", "marginLeft" to "35rpx")), "avatar" to _uM(".navigat .userinfo .user " to _uM("width" to 50, "height" to 50)), "full" to _uM(".navigat .userinfo .user .avatar " to _uM("borderTopLeftRadius" to 25, "borderTopRightRadius" to 25, "borderBottomRightRadius" to 25, "borderBottomLeftRadius" to 25, "width" to 50, "height" to 50)), "info" to _uM(".navigat .userinfo .user " to _uM("marginLeft" to "12rpx", "paddingTop" to 5)), "nick" to _uM(".navigat .userinfo .user .info " to _uM("fontSize" to 18, "color" to "#000000")), "no" to _uM(".navigat .userinfo .user .info " to _uM("marginTop" to 3, "fontSize" to 13, "color" to "#878787")), "action" to _uM(".navigat .userinfo " to _uM("marginRight" to "35rpx", "marginTop" to 25)), "icon" to _uM(".navigat .userinfo .action " to _uM("marginLeft" to "40rpx")), "hanndleaction" to _pS(_uM("marginTop" to -3, "borderTopLeftRadius" to "28rpx", "borderTopRightRadius" to "28rpx", "height" to 257)), "actions" to _uM(".hanndleaction " to _uM("width" to "100%", "paddingTop" to 68)), "actionitem" to _uM(".hanndleaction .actions " to _uM("width" to "25%", "paddingLeft" to "30rpx", "paddingRight" to "30rpx", "marginTop" to 30)), "numbercard" to _pS(_uM("position" to "absolute", "top" to 80, "left" to "22rpx", "height" to 130, "width" to "706rpx", "zIndex" to 99, "borderTopLeftRadius" to "10rpx", "borderTopRightRadius" to "10rpx", "borderBottomRightRadius" to "10rpx", "borderBottomLeftRadius" to "10rpx")), "basic" to _uM(".numbercard " to _uM("height" to 48, "paddingTop" to 16, "paddingLeft" to "28rpx", "paddingRight" to "23rpx", "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#4592FF", "paddingBottom" to 7)), "shopname" to _uM(".numbercard .basic .zhiwu " to _uM("fontSize" to 20)), "zhi" to _uM(".numbercard .basic .zhiwu " to _uM("paddingLeft" to "24rpx", "fontSize" to 16, "paddingTop" to 5)), "xinngxing" to _uM(".numbercard .basic " to _uM("paddingTop" to "5rpx")), "img" to _uM(".numbercard .basic .xinngxing " to _uM("width" to "32rpx", "height" to "32rpx", "marginLeft" to "16rpx")), "numberinfo" to _uM(".numbercard " to _uM("width" to "100%", "height" to 182)), "infoitem" to _uM(".numbercard .numberinfo " to _uM("width" to "33.33%", "paddingTop" to 12)), "title" to _uM(".numbercard .numberinfo .infoitem " to _uM("fontSize" to 16)), "data" to _uM(".numbercard .numberinfo .infoitem " to _uM("marginTop" to 0, "marginRight" to "auto", "marginBottom" to 0, "marginLeft" to "auto", "paddingTop" to 5)), "text" to _uM(".numbercard .numberinfo .infoitem .data .num " to _uM("fontSize" to 30), ".numbercard .numberinfo .infoitem .data .tnum " to _uM("fontSize" to 20)), "tnum" to _uM(".numbercard .numberinfo .infoitem .data " to _uM("paddingTop" to 10)), "action-btn" to _pS(_uM("marginLeft" to "40rpx", "marginTop" to "19rpx")), "btn" to _uM(".action-btn " to _uM("width" to "670rpx", "height" to "78rpx", "lineHeight" to "78rpx", "borderTopLeftRadius" to "39rpx", "borderTopRightRadius" to "39rpx", "borderBottomRightRadius" to "39rpx", "borderBottomLeftRadius" to "39rpx", "fontSize" to "31rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
