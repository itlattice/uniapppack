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
open class GenPagesCommonChoosearea : BasePage {
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
        var setup: (__props: GenPagesCommonChoosearea) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCommonChoosearea
            val _cache = __ins.renderCache
            val keywords = ref("")
            val pageHeight = ref(0)
            val marginTop = ref(0)
            val provinces = ref(_uA<UTSJSONObject>())
            val citys = ref(_uA<UTSJSONObject>())
            val areas = ref(_uA<UTSJSONObject>())
            val selActive = ref(_uA<Number>())
            val pIndex = ref(0)
            val cIndex = ref(0)
            val aIndex = ref(0)
            val value = ref(0)
            val timeout = ref(0)
            val searchReady = ref(false)
            val searchList = ref(_uA<UTSJSONObject>())
            val back = fun(){
                uni__off("/pages/common/choosearea", null)
                common.back()
            }
            val clearKeywords = fun(){
                keywords.value = ""
            }
            val submit = fun(data: UTSJSONObject){
                uni__emit("/pages/common/choosearea", data)
            }
            val selectSearch = fun(e: UTSJSONObject){
                submit(e)
            }
            val selectItem = fun(index: Number){
                selActive.value[2] = index
                var result: UTSJSONObject = _uO("code" to areas.value[selActive.value[2]]["id"] as String, "name" to areas.value[selActive.value[2]]["name"] as String)
                submit(result)
            }
            val searchCity = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        var res = await(request.callapi("address/searchaddress", _uO("keywords" to keywords.value), AppConfig.postHost))
                        searchList.value = res.data as UTSArray<UTSJSONObject>
                        searchReady.value = true
                })
            }
            val bindsearchInput = fun(e: UniInputEvent){
                keywords.value = e.detail.value
                searchReady.value = false
                clearTimeout(timeout.value)
                timeout.value = setTimeout(fun(){
                    if (keywords.value === "") {
                        return
                    }
                    searchCity()
                }
                , 300)
            }
            val bindChange = fun(e: UniPickerViewChangeEvent){
                citys.value = _uA(
                    _uO("id" to provinces.value[e.detail.value[0]]["id"], "name" to "全省")
                )
                citys.value = citys.value.concat(provinces.value[e.detail.value[0]]["child"] as UTSArray<UTSJSONObject>)
                selActive.value = e.detail.value
                console.log(selActive.value)
                pIndex.value = selActive.value[0]
                if (selActive.value[0] !== pIndex.value || selActive.value[1] !== cIndex.value) {
                    areas.value = _uA(
                        _uO("id" to citys.value[selActive.value[1]]["id"], "name" to "全市")
                    )
                    if (e.detail.value[1] - 1 >= 0) {
                        areas.value = areas.value.concat(citys.value[selActive.value[1]]["child"] as UTSArray<UTSJSONObject>)
                    }
                }
                if (pIndex.value !== selActive.value[0]) {
                    selActive.value[1] = 0
                    selActive.value[2] = 0
                }
                if (cIndex.value !== selActive.value[1]) {
                    selActive.value[2] = 0
                }
                pIndex.value = selActive.value[0]
                cIndex.value = selActive.value[1]
                aIndex.value = selActive.value[2]
                value.value = 0
            }
            onLoad(fun(options: OnLoadOptions){
                var res = common.getStorage("district") as UTSJSONObject
                provinces.value = res["data"] as UTSArray<UTSJSONObject>
                var c = provinces.value[0]["child"] as UTSArray<UTSJSONObject>
                var pCode = provinces.value[0]["id"] as String
                if ((options["more"] ?: "") != "") {
                    citys.value = (_uA<UTSJSONObject>(_uO("id" to pCode, "name" to "全省"))).concat(provinces.value[0]["child"] as UTSArray<UTSJSONObject>)
                    areas.value = _uA<UTSJSONObject>(_uO("id" to c[0]["id"] as String, "name" to "全市"))
                } else {
                    citys.value = provinces.value[0]["child"] as UTSArray<UTSJSONObject>
                    areas.value = c[0]["child"] as UTSArray<UTSJSONObject>
                }
                selActive.value = _uA(
                    0,
                    0,
                    0
                )
            }
            )
            onReady(fun(){
                pageHeight.value = (uni_getWindowInfo().safeArea.height - 105) * 2
                marginTop.value = -(pageHeight.value / 2) + 24
                console.log(pageHeight.value, marginTop.value)
            }
            )
            onUnload(fun(){
                uni__off("/pages/common/choosearea", null)
            }
            )
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_picker_view_column = resolveComponent("picker-view-column")
                val _component_picker_view = resolveComponent("picker-view")
                return _cE("view", null, _uA(
                    _cE("view", _uM("class" to "native padding-stauts-bar background-main"), _uA(
                        _cE("view", _uM("class" to "nativetitle space-between"), _uA(
                            _cE("text", _uM("class" to "text color-white"), "选择地区"),
                            _cE("view", _uM("class" to "close-btn display-flex", "onClick" to back), _uA(
                                _cV(_component_x_iconfont, _uM("class" to "icon", "name" to "guanbi", "size" to "14", "color" to "white")),
                                _cE("text", _uM("class" to "text color-white"), "关闭")
                            ))
                        ))
                    )),
                    _cE("view", _uM("class" to "searchbox"), _uA(
                        _cE("view", _uM("class" to "searchinput display-flex background-white"), _uA(
                            _cV(_component_x_iconfont, _uM("class" to "icon", "name" to "sousuo", "size" to "16", "color" to "#ccc")),
                            _cE("input", _uM("type" to "text", "modelValue" to unref(keywords), "onInput" to _uA<Any?>(fun(`$event`: UniInputEvent){
                                trySetRefValue(keywords, `$event`.detail.value)
                            }
                            , bindsearchInput), "placeholder" to "搜索地区", "class" to "input", "confirm-type" to "search"), null, 40, _uA(
                                "modelValue"
                            )),
                            _cE("view", _uM("class" to "empty"), _uA(
                                if (unref(keywords).length > 0) {
                                    _cV(_component_x_iconfont, _uM("key" to 0, "onClick" to clearKeywords, "name" to "chacha", "size" to "16", "color" to "#C4C4C4"))
                                } else {
                                    _cC("v-if", true)
                                }
                            ))
                        ))
                    )),
                    if (unref(keywords).length < 1) {
                        _cE("view", _uM("key" to 0, "style" to _nS(_uM("height" to (unref(pageHeight) + "px")))), _uA(
                            _cV(_component_picker_view, _uM("indicator-class" to "pickview", "mask-class" to "pickviewclass", "class" to "picker-view", "value" to unref(selActive), "style" to _nS(_uM("height" to (unref(pageHeight) + "px"), "marginTop" to (unref(marginTop) + "px"))), "onChange" to bindChange), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_picker_view_column, _uM("class" to "picker-view-column province"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cE(Fragment, null, RenderHelpers.renderList(unref(provinces), fun(province, province_index, __index, _cached): Any {
                                                return _cE("view", _uM("key" to province_index, "class" to "item"), _uA(
                                                    _cE("text", _uM("class" to _nC(_uA(
                                                        if (unref(selActive)[0] == province_index) {
                                                            "active"
                                                        } else {
                                                            ""
                                                        },
                                                        "align-center text"
                                                    ))), _tD(province["name"]), 3)
                                                ))
                                            }), 128)
                                        )
                                    }), "_" to 1)),
                                    _cV(_component_picker_view_column, _uM("class" to "picker-view-column cityinfo"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cE(Fragment, null, RenderHelpers.renderList(unref(citys), fun(city, city_index, __index, _cached): Any {
                                                return _cE("view", _uM("key" to city_index, "class" to "item"), _uA(
                                                    _cE("text", _uM("class" to _nC(_uA(
                                                        if (unref(selActive)[1] == city_index) {
                                                            "active"
                                                        } else {
                                                            ""
                                                        },
                                                        "align-center text"
                                                    ))), _tD(city["name"]), 3)
                                                ))
                                            }), 128)
                                        )
                                    }), "_" to 1)),
                                    _cV(_component_picker_view_column, _uM("class" to "picker-view-column cityinfo"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cE(Fragment, null, RenderHelpers.renderList(unref(areas), fun(area, area_index, __index, _cached): Any {
                                                return _cE("view", _uM("key" to area_index, "class" to "item"), _uA(
                                                    _cE("text", _uM("onClick" to fun(){
                                                        selectItem(area_index)
                                                    }, "class" to _nC(_uA(
                                                        if (unref(selActive)[2] == area_index) {
                                                            "active"
                                                        } else {
                                                            ""
                                                        },
                                                        "align-center text"
                                                    ))), _tD(area["name"]), 11, _uA(
                                                        "onClick"
                                                    ))
                                                ))
                                            }), 128)
                                        )
                                    }), "_" to 1))
                                )
                            }), "_" to 1), 8, _uA(
                                "value",
                                "style"
                            ))
                        ), 4)
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    if (unref(keywords).length > 0) {
                        _cE("view", _uM("key" to 1, "class" to "searchkeywords"), _uA(
                            if (isTrue(!unref(searchReady))) {
                                _cE("text", _uM("key" to 0, "class" to "tips"), "识别中...")
                            } else {
                                _cE("view", _uM("key" to 1, "class" to "searchlist"), _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(unref(searchList), fun(item, __key, __index, _cached): Any {
                                        return _cE("text", _uM("class" to "item disflex", "key" to item["id"], "onClick" to fun(){
                                            selectSearch(item)
                                        }), _tD(item["name"]), 9, _uA(
                                            "onClick"
                                        ))
                                    }), 128)
                                ))
                            }
                        ))
                    } else {
                        _cC("v-if", true)
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
                return _uM("native" to _pS(_uM("paddingLeft" to "10rpx", "paddingRight" to "20rpx")), "icon" to _uM(".native .close-btn " to _uM("paddingTop" to 10), ".searchbox .searchinput " to _uM("paddingTop" to 6, "paddingRight" to 6, "paddingBottom" to 6, "paddingLeft" to 6)), "picker-view-column" to _pS(_uM("borderRightWidth" to 1, "borderRightStyle" to "solid", "borderRightColor" to "#ececec")), "item" to _uM(".picker-view-column " to _uM("height" to 34), ".internal .searchlist " to _uM("display" to "flex"), ".searchlist " to _uM("height" to 30, "lineHeight" to "30px", "fontSize" to 14, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#ececec", "color" to "#3f3f3f")), "province" to _pS(_uM("backgroundColor" to "#ececec")), "cityinfo" to _pS(_uM("backgroundColor" to "#FFFFFF")), "active" to _pS(_uM("color" to "#1e79eb")), "internal" to _pS(_uM("marginTop" to "160rpx")), "internaltag" to _uM(".internal .searchlist .item " to _uM("marginTop" to 10)), "tipsinfo" to _uM(".internal " to _uM("fontSize" to 10, "textAlign" to "center", "color" to "#878787")), "pickview" to _pS(_uM("backgroundColor" to "rgba(0,0,0,0)", "color" to "#1e79eb", "fontWeight" to "bold", "textAlign" to "center", "width" to "0%")), "text" to _pS(_uM("fontSize" to 16, "lineHeight" to "34px")), "pickviewclass" to _pS(_uM("color" to "#FFFFFF", "backgroundColor" to "rgba(0,0,0,0)", "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#000000")), "picker-view" to _pS(_uM("zIndex" to 998)), "searchbox" to _pS(_uM("backgroundImage" to "none", "backgroundColor" to "#eaeaea", "height" to 40)), "searchinput" to _uM(".searchbox " to _uM("width" to "720rpx", "marginLeft" to "15rpx", "marginTop" to 5, "height" to 30, "borderTopLeftRadius" to 4, "borderTopRightRadius" to 4, "borderBottomRightRadius" to 4, "borderBottomLeftRadius" to 4)), "input" to _uM(".searchbox .searchinput " to _uM("marginLeft" to "10rpx", "fontSize" to 14, "width" to "6050rpx")), "empty" to _uM(".searchbox .searchinput " to _uM("width" to "40rpx", "paddingTop" to 7)), "tips" to _uM(".searchkeywords " to _uM("fontSize" to 12, "textAlign" to "center", "paddingTop" to 10, "color" to "#878787")), "searchlist" to _pS(_uM("paddingTop" to 6, "paddingRight" to 6, "paddingBottom" to 6, "paddingLeft" to 14)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
