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
import io.dcloud.uniapp.extapi.`$off` as uni__off
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
open class GenPagesCommonChoosemember : BasePage {
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
        var setup: (__props: GenPagesCommonChoosemember) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCommonChoosemember
            val _cache = __ins.renderCache
            val keywords = ref("")
            val member = ref(_uO())
            val showView = ref(false)
            val pageHeight = ref(0)
            val paging = ref<ComponentPublicInstance?>(null)
            val formloading = ref<UniElement?>(null)
            val clearKeywords = fun(){
                keywords.value = ""
            }
            val search = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        if (keywords.value.length < 1) {
                            common.toast("请输入手机号")
                            return@w1
                        }
                        common.loading(formloading.value as Any)
                        var res = await(request.callapi("member/searchmember", _uO("keywords" to keywords.value, "type" to "choosemember")))
                        common.hideLoading(formloading.value as Any)
                        if (res.code < 0) {
                            common.toast(res.msg)
                            return@w1
                        }
                        console.log(res)
                        member.value = res.data as UTSJSONObject
                })
            }
            val refresh = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        await(search())
                        (paging.value as ComponentPublicInstance).`$callMethod`("closeRefresh")
                })
            }
            val closePage = fun(){
                uni__emit("/pages/common/choosemember", _uO())
            }
            val chooseMember = fun(memberVal: UTSJSONObject){
                if (showView.value) {
                    return
                }
                console.log("选中会员", memberVal)
                uni__emit("/pages/common/choosemember", memberVal)
            }
            val showMemberView = fun(id: Any?){
                showView.value = true
                setTimeout(fun(){
                    showView.value = false
                }
                , 10)
                console.log("显示详情")
                common.goto("/pages/member/view?id=" + (id as Number))
            }
            onLoad(fun(_options){
                pageHeight.value = uni_getWindowInfo().windowHeight - 50
            }
            )
            onUnload(fun(){
                uni__off("/pages/common/choosemember", null)
            }
            )
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_x_paging = resolveEasyComponent("x-paging", GenComponentsXPagingClass)
                val _component_x_loading = resolveEasyComponent("x-loading", GenComponentsXLoadingClass)
                return _cE("view", null, _uA(
                    _cE("view", _uM("class" to "navigat padding-stauts-bar background-main"), _uA(
                        _cE("view", _uM("class" to "navititle space-between"), _uA(
                            _cE("view", _uM("class" to "adddata display-flex"), _uA(
                                _cV(_component_x_iconfont, _uM("name" to "jiahao", "size" to "12", "color" to "white")),
                                _cE("text", _uM("class" to "text color-white"), "新增")
                            )),
                            _cE("view", _uM("class" to "closebtn display-flex", "onClick" to closePage), _uA(
                                _cV(_component_x_iconfont, _uM("name" to "guanbi", "size" to "14", "color" to "white")),
                                _cE("text", _uM("class" to "text color-white"), "关闭")
                            ))
                        ))
                    )),
                    _cE("view", _uM("class" to "searchbox display-flex background-white"), _uA(
                        _cE("view", _uM("class" to "inputbox display-flex"), _uA(
                            _cV(_component_x_iconfont, _uM("class" to "sousuo", "color" to "#C4C4C4", "name" to "sousuo", "size" to "15")),
                            _cE("input", _uM("onConfirm" to search, "type" to "tel", "ref" to "input", "confirm-type" to "search", "auto-focus" to true, "class" to "input", "modelValue" to unref(keywords), "onInput" to fun(`$event`: UniInputEvent){
                                trySetRefValue(keywords, `$event`.detail.value)
                            }
                            , "placeholder" to "名称/手机号"), null, 40, _uA(
                                "modelValue"
                            )),
                            _cE("view", _uM("class" to "empty"), _uA(
                                if (unref(keywords).length > 0) {
                                    _cV(_component_x_iconfont, _uM("key" to 0, "onClick" to clearKeywords, "name" to "chacha", "size" to "16", "color" to "#C4C4C4"))
                                } else {
                                    _cC("v-if", true)
                                }
                            ))
                        )),
                        _cV(_component_x_iconfont, _uM("name" to "saoyisao", "class" to "saoyisao", "size" to "24", "color" to "#1776FC"))
                    )),
                    _cV(_component_x_paging, _uM("ref_key" to "paging", "ref" to paging, "height" to unref(pageHeight), "onRefresh" to refresh), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", null, _uA(
                                if (unref(member)["id"] == null) {
                                    _cE("view", _uM("key" to 0, "class" to "nomember margin-center"), _uA(
                                        _cV(_component_x_iconfont, _uM("size" to "100", "class" to "icon margin-center", "color" to "#D9D9D9", "name" to "chazhaoyonghu")),
                                        _cE("text", _uM("class" to "text align-center"), "请输入检索条件")
                                    ))
                                } else {
                                    _cE("view", _uM("key" to 1, "class" to "memberinfo background-white space-between", "onClick" to fun(){
                                        chooseMember(unref(member))
                                    }
                                    ), _uA(
                                        _cE("view", _uM("class" to "userinfo display-flex"), _uA(
                                            _cE("view", _uM("class" to "avatar"), _uA(
                                                _cE("image", _uM("class" to "avaimg", "src" to unref(member)["headico"]), null, 8, _uA(
                                                    "src"
                                                ))
                                            )),
                                            _cE("view", _uM("class" to "textinfo"), _uA(
                                                _cE("text", _uM("class" to "nick"), _tD(unref(member)["nick"]), 1),
                                                _cE("text", _uM("class" to "phone"), "手机号:" + _tD(unref(member)["phone"]), 1)
                                            ))
                                        )),
                                        _cE("view", _uM("class" to "viewbtn display-flex", "onClick" to fun(){
                                            showMemberView(unref(member)["id"])
                                        }
                                        ), _uA(
                                            _cV(_component_x_iconfont, _uM("name" to "gengduo", "size" to "16", "color" to "#636363")),
                                            _cE("text", _uM("class" to "content"), "详情")
                                        ), 8, _uA(
                                            "onClick"
                                        ))
                                    ), 8, _uA(
                                        "onClick"
                                    ))
                                }
                            ))
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "height"
                    )),
                    _cV(_component_x_loading, _uM("ref_key" to "formloading", "ref" to formloading), null, 512)
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
                return _uM("navititle" to _uM(".navigat " to _uM("paddingLeft" to "16rpx", "paddingRight" to "22rpx", "paddingTop" to 13, "height" to 40)), "text" to _uM(".navigat .navititle " to _uM("fontSize" to 14, "marginLeft" to "6rpx"), ".nomember " to _uM("color" to "#d9d9d9", "marginTop" to 10, "fontSize" to 18)), "searchbox" to _pS(_uM("height" to 45, "borderBottomWidth" to 0.5, "borderBottomStyle" to "solid", "borderBottomColor" to "#cccccc")), "inputbox" to _uM(".searchbox " to _uM("marginTop" to 7, "marginLeft" to "20rpx", "height" to 31, "width" to "638rpx", "backgroundColor" to "#f5f5f5", "borderTopLeftRadius" to 4, "borderTopRightRadius" to 4, "borderBottomRightRadius" to 4, "borderBottomLeftRadius" to 4)), "sousuo" to _uM(".searchbox .inputbox " to _uM("paddingTop" to 8, "paddingLeft" to "10rpx")), "input" to _uM(".searchbox .inputbox " to _uM("marginLeft" to "10rpx", "fontSize" to 14, "width" to "530rpx")), "empty" to _uM(".searchbox .inputbox " to _uM("width" to "68rpx", "paddingTop" to 7)), "saoyisao" to _uM(".searchbox " to _uM("marginLeft" to "20rpx", "marginTop" to 8)), "nomember" to _pS(_uM("marginTop" to "50%")), "memberinfo" to _pS(_uM("paddingBottom" to 9, "borderBottomWidth" to 0.5, "borderBottomStyle" to "solid", "borderBottomColor" to "#CCCCCC")), "userinfo" to _uM(".memberinfo " to _uM("paddingLeft" to "16rpx", "marginTop" to 9)), "avatar" to _uM(".memberinfo .userinfo " to _uM("width" to 38, "height" to 38)), "avaimg" to _uM(".memberinfo .userinfo .avatar " to _uM("width" to 38, "height" to 38, "borderTopLeftRadius" to 4, "borderTopRightRadius" to 4, "borderBottomRightRadius" to 4, "borderBottomLeftRadius" to 4)), "textinfo" to _uM(".memberinfo .userinfo " to _uM("marginLeft" to "8rpx")), "nick" to _uM(".memberinfo .userinfo .textinfo " to _uM("fontSize" to 16, "color" to "#000000")), "phone" to _uM(".memberinfo .userinfo .textinfo " to _uM("fontSize" to 12, "color" to "#808080", "marginTop" to 4)), "viewbtn" to _uM(".memberinfo " to _uM("paddingTop" to 8, "paddingRight" to "19rpx")), "content" to _uM(".memberinfo .viewbtn " to _uM("paddingLeft" to "4rpx", "fontSize" to 14, "color" to "#000000")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
