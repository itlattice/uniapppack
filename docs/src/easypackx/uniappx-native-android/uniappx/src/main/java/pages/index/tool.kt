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
import io.dcloud.uniapp.extapi.downloadFile as uni_downloadFile
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
import io.dcloud.uniapp.extapi.setNavigationBarColor as uni_setNavigationBarColor
open class GenPagesIndexTool : BasePage {
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
        var setup: (__props: GenPagesIndexTool) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesIndexTool
            val _cache = __ins.renderCache
            val tools = ref(_uA<UTSJSONObject>())
            val pageHeight = ref(0)
            val toolTabKey = ref("")
            val loading = ref<UniElement?>(null)
            val toolTab = computed(fun(): UTSArray<FuiTabsItemParam> {
                if (tools.value.length < 1) {
                    return _uA()
                }
                var list = _uA<FuiTabsItemParam>()
                for(item in resolveUTSValueIterator(tools.value)){
                    list.push(FuiTabsItemParam(name = item["name"] as String, key = "tool-" + item["id"].toString()))
                }
                if (toolTabKey.value == "" && list.length > 0) {
                    toolTabKey.value = list[0].key as String
                }
                return list
            }
            )
            val toolList = computed(fun(): UTSJSONObject {
                var ret: UTSJSONObject = _uO()
                for(item in resolveUTSValueIterator(tools.value)){
                    var toolItems = _uA<UTSJSONObject>()
                    for(t in resolveUTSValueIterator((item["tools"] as UTSArray<UTSJSONObject>))){
                        var openType = t["open_type"] as String
                        var it: UTSJSONObject = _uO()
                        if (openType == "mp") {
                            var mpConfig = t["mp_config"] as UTSJSONObject
                            it = _uO("iconfont" to t["icon"], "name" to t["name"], "mpAppid" to mpConfig["mp_appid"], "mpIcon" to mpConfig["mp_icon"], "mpUrl" to mpConfig["mp_url"], "mpVersionID" to mpConfig["mp_version"])
                            if (t["page"] != null && t["page"] != "") {
                                it.set("page", t["page"])
                            }
                        } else {
                            it = _uO("iconfont" to t["icon"], "name" to t["name"], "page" to t["page"])
                        }
                        toolItems.push(it)
                    }
                    ret.set("tool-" + item["id"].toString(), toolItems)
                }
                return ret
            }
            )
            val toolHeight = computed(fun(): Number {
                return 1900
            }
            )
            val loadTool = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var res = await(request.callapi("common/gettoollist", _uO()))
                        if (res.code < 0) {
                            common.toast(res.msg)
                            return@w1
                        }
                        var data = res.data as UTSArray<UTSJSONObject>
                        tools.value = data
                })
            }
            val toolTabChange = fun(e: FuiTabsItemParam){
                var key = e.key
                toolTabKey.value = key as String
            }
            val openMP = fun(appid: String, icon: String, name: String): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        var mp = mpContext()
                        mp.setMenus(MenuOptions(items = _uA(
                            ActionItem(id = "1", title = "测试菜单")
                        )), fun(openAppid: String, id: String){
                            console.log("点击了菜单", openAppid, id)
                        }
                        )
                        mp.open(OpenMPOptions(appid = appid, icon = icon), fun(openAppid: String, event: String, data: Any?){
                            console.log("小程序事件", openAppid, event, data, name)
                        }
                        )
                })
            }
            val toPage = fun(menu: UTSJSONObject): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        if (menu["mpAppid"] != null) {
                            var mp = mpContext()
                            var appid = menu["mpAppid"] as String
                            var icon = menu["mpIcon"] as String
                            var url = menu["mpUrl"] as String
                            var version = menu["mpVersionID"] as Number
                            var ver = await(mp.getVersion(appid))
                            console.log(ver)
                            common.loading(loading.value)
                            if (ver == null) {
                                var r = await(mp.install(appid, url))
                                if (r == false) {
                                    common.hideLoading(loading.value)
                                    common.toast("小程序安装失败")
                                    return@w1
                                }
                                uni_downloadFile(DownloadFileOptions(url = icon, success = fun(downRes){
                                    openMP(appid, downRes.tempFilePath, menu["name"] as String)
                                    common.hideLoading(loading.value)
                                }))
                            } else {
                                if (version > ver.code) {
                                    var r = await(mp.install(appid, url))
                                    if (r == false) {
                                        common.hideLoading(loading.value)
                                        common.toast("小程序安装失败")
                                        return@w1
                                    }
                                    uni_downloadFile(DownloadFileOptions(url = icon, success = fun(downRes){
                                        openMP(appid, downRes.tempFilePath, menu["name"] as String)
                                        common.hideLoading(loading.value)
                                    }))
                                } else {
                                    uni_downloadFile(DownloadFileOptions(url = icon, success = fun(downRes){
                                        openMP(appid, downRes.tempFilePath, menu["name"] as String)
                                        common.hideLoading(loading.value)
                                    }))
                                }
                            }
                        } else {
                            common.goto(menu["page"] as String)
                        }
                })
            }
            onLoad(fun(_options){
                pageHeight.value = uni_getWindowInfo().windowHeight - 150
                loadTool()
            }
            )
            onShow(fun(){
                uni_setNavigationBarColor(SetNavigationBarColorOptions(frontColor = "#000000", backgroundColor = "#ffffff"))
            }
            )
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_fui_tabs = resolveEasyComponent("fui-tabs", GenUniModulesFirstuiUvueComponentsFuiTabsFuiTabsClass)
                val _component_x_tool_action = resolveEasyComponent("x-tool-action", GenComponentsXToolActionClass)
                val _component_x_loading = resolveEasyComponent("x-loading", GenComponentsXLoadingClass)
                return _cE("view", _uM("class" to "tool"), _uA(
                    _cE("view", _uM("class" to "searchbox padding-stauts-bar background-white"), _uA(
                        _cE("view", _uM("class" to "searchinput display-flex"), _uA(
                            _cV(_component_x_iconfont, _uM("class" to "sousuoicon", "size" to "15", "color" to "#C4C4C4", "name" to "sousuo")),
                            _cE("view", _uM("class" to "sinput"), _uA(
                                _cE("input", _uM("class" to "inp", "placeholder" to "请输入关键词查询"))
                            )),
                            _cE("text", _uM("class" to "searchbtn color-main text"), "搜索")
                        ))
                    )),
                    _cE("view", _uM("class" to "toolpage background-white"), _uA(
                        _cE("view", _uM("class" to "tabbar"), _uA(
                            _cV(_component_fui_tabs, _uM("tabs" to unref(toolTab), "isDot" to true, "scroll" to true, "size" to 28, "selectedSize" to 30, "height" to 55, "color" to "#696969", "selectedColor" to "#000000", "sliderBackground" to "#1776FC", "selectedFontWeight" to "normal", "scale" to 1.1, "center" to true, "onChange" to toolTabChange), null, 8, _uA(
                                "tabs"
                            ))
                        )),
                        _cE(Fragment, null, RenderHelpers.renderList(unref(toolList), fun(item, index, __index, _cached): Any {
                            return _cE("view", _uM("key" to index), _uA(
                                if (unref(toolTabKey) == index) {
                                    _cE("view", _uM("key" to 0, "class" to "toolpageitem", "data-tooltab" to index), _uA(
                                        _cE("scroll-view", _uM("scroll-y" to true, "class" to "pageheight", "style" to _nS(_uM("height" to unref(pageHeight)))), _uA(
                                            _cE("view", _uM("class" to "actions list-items", "style" to _nS(_uM("height" to (unref(toolHeight) + "rpx")))), _uA(
                                                _cE(Fragment, null, RenderHelpers.renderList((item as UTSArray<UTSJSONObject>), fun(tool, ind, __index, _cached): Any {
                                                    return _cE("view", _uM("class" to "action-item litem", "key" to ind, "onClick" to fun(){
                                                        toPage(tool)
                                                    }), _uA(
                                                        _cV(_component_x_tool_action, _uM("icon" to tool["iconfont"], "name" to tool["name"]), null, 8, _uA(
                                                            "icon",
                                                            "name"
                                                        ))
                                                    ), 8, _uA(
                                                        "onClick"
                                                    ))
                                                }), 128)
                                            ), 4)
                                        ), 4)
                                    ), 8, _uA(
                                        "data-tooltab"
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                            ))
                        }
                        ), 128)
                    )),
                    _cV(_component_x_loading, _uM("ref_key" to "loading", "ref" to loading), null, 512)
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
                return _uM("searchbox" to _uM(".tool " to _uM("paddingBottom" to "23rpx")), "searchinput" to _uM(".tool .searchbox " to _uM("marginTop" to "20rpx", "width" to "700rpx", "marginLeft" to "25rpx", "height" to 30, "borderTopLeftRadius" to "25rpx", "borderTopRightRadius" to "25rpx", "borderBottomRightRadius" to "25rpx", "borderBottomLeftRadius" to "25rpx", "borderTopWidth" to "1rpx", "borderRightWidth" to "1rpx", "borderBottomWidth" to "1rpx", "borderLeftWidth" to "1rpx", "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#BFBFBF", "borderRightColor" to "#BFBFBF", "borderBottomColor" to "#BFBFBF", "borderLeftColor" to "#BFBFBF")), "sousuoicon" to _uM(".tool .searchbox .searchinput " to _uM("paddingLeft" to "12rpx", "paddingTop" to 5)), "sinput" to _uM(".tool .searchbox .searchinput " to _uM("width" to "550rpx", "height" to 55, "paddingLeft" to "10rpx")), "inp" to _uM(".tool .searchbox .searchinput .sinput " to _uM("height" to 30, "width" to "550rpx", "fontSize" to 14)), "searchbtn" to _uM(".tool .searchbox .searchinput " to _uM("width" to "75rpx", "height" to 18, "borderLeftWidth" to 1, "borderLeftStyle" to "solid", "borderLeftColor" to "#1678fd", "marginTop" to 6, "paddingLeft" to "10rpx", "textAlign" to "center", "fontSize" to 14, "paddingTop" to 1)), "toolpage" to _uM(".tool " to _uM("marginTop" to "13rpx", "paddingTop" to "6rpx", "paddingBottom" to "10rpx")), "toolpageitem" to _uM(".tool .toolpage " to _uM("paddingTop" to "30rpx", "marginLeft" to "21rpx", "marginRight" to "21rpx", "paddingBottom" to "20rpx")), "actions" to _uM(".tool .toolpage .toolpageitem " to _uM("width" to "100%", "marginLeft" to "-11rpx", "marginTop" to "-10rpx")), "action-item" to _uM(".tool .toolpage .toolpageitem .actions " to _uM("flexBasis" to "25%", "marginTop" to "32rpx", "height" to "130rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
