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
open class GenPagesCommonChoosecity : BasePage {
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
        var setup: (__props: GenPagesCommonChoosecity) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCommonChoosecity
            val _cache = __ins.renderCache
            val keywords = ref("")
            val scrollIntoView = ref("A")
            val sectionPadding = ref(_uA<Number>(0, 0, 0, 0))
            val sectionArray = ref(_uA<citySectionData>())
            val PageHeight = ref(0)
            val startZimu = ref("")
            val startY = ref(0)
            val showView = ref(false)
            val zimuList = ref(_uA<String>())
            val back = fun(){
                uni__off("/pages/common/choosecity", null)
                common.back()
            }
            val getCityList = fun(){
                var res = common.getStorage("citylistindex") as UTSJSONObject
                var data = res["data"] as UTSArray<UTSJSONObject>
                for(item in resolveUTSKeyIterator(data)){
                    var list = item["list"] as UTSArray<UTSJSONObject>
                    var l = _uA<citySectionListItem>()
                    for(lt in resolveUTSKeyIterator(list)){
                        l.push(citySectionListItem(name = lt["name"] as String, code = lt["code"] as String, pinyin = lt["pinyin"] as String, head = lt["head"] as String, short = lt["short"] as String))
                    }
                    zimuList.value.push(item["name"] as String)
                    sectionArray.value.push(citySectionData(name = item["name"] as String, list = l))
                }
            }
            val clearKeywords = fun(){
                keywords.value = ""
            }
            val search = fun(){}
            val click = fun(item: citySectionListItem){
                var result: UTSJSONObject = _uO("city" to item.name, "code" to item.code, "short" to item.short)
                uni__emit("/pages/common/choosecity", result)
            }
            val toIndex = fun(){
                scrollIntoView.value = "G"
            }
            val touchZimu = fun(zimu: String, e: Any){
                var ev = e as UniTouchEvent
                console.log("触摸字母", zimu)
                startZimu.value = zimu
                startY.value = ev.touches[0].screenY
                scrollIntoView.value = zimu
                showView.value = true
            }
            val touchMove = fun(e: UniTouchEvent){
                var index = zimuList.value.indexOf(startZimu.value)
                var y = (e.changedTouches[0].screenY - startY.value) / 20
                var i = parseInt(index + "") + parseInt(y + "")
                if (i > zimuList.value.length - 1) {
                    i = zimuList.value.length - 1
                }
                showView.value = true
                scrollIntoView.value = zimuList.value[i]
            }
            val touchEnd = fun(){
                showView.value = false
            }
            onLoad(fun(_options){
                getCityList()
                PageHeight.value = uni_getWindowInfo().safeArea.height - 200
            }
            )
            onUnload(fun(){
                uni__off("/pages/common/choosecity", null)
            }
            )
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                return _cE("view", null, _uA(
                    _cE("view", _uM("class" to "native padding-stauts-bar"), _uA(
                        _cE("view", _uM("class" to "nativetitle space-between"), _uA(
                            _cE("text", _uM("class" to "text color-black"), "选择城市"),
                            _cE("view", _uM("class" to "close-btn display-flex", "onClick" to back), _uA(
                                _cV(_component_x_iconfont, _uM("name" to "guanbi", "size" to "14", "color" to "black")),
                                _cE("text", _uM("class" to "text color-black"), "关闭")
                            ))
                        ))
                    )),
                    _cE("view", _uM("class" to "searchbox display-flex"), _uA(
                        _cE("view", _uM("class" to "inputbox display-flex background-white"), _uA(
                            _cV(_component_x_iconfont, _uM("class" to "sousuo", "color" to "#C4C4C4", "name" to "sousuo", "size" to "15")),
                            _cE("input", _uM("onConfirm" to search, "type" to "text", "ref" to "input", "confirm-type" to "search", "class" to "input", "modelValue" to unref(keywords), "onInput" to fun(`$event`: UniInputEvent){
                                trySetRefValue(keywords, `$event`.detail.value)
                            }
                            , "placeholder" to "搜索城市"), null, 40, _uA(
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
                    _cE("view", _uM("class" to "hotcity"), _uA(
                        _cE("text", _uM("class" to "color-black font-bold title"), "热门城市"),
                        _cE("view", _uM("class" to "citylist list-items"), _uA(
                            _cE("view", _uM("class" to "litem cityitem", "onClick" to toIndex), _uA(
                                _cE("text", _uM("class" to "text align-center background-white"), "昆明")
                            )),
                            _cE("view", _uM("class" to "litem cityitem"), _uA(
                                _cE("text", _uM("class" to "text align-center background-white"), "昆明")
                            )),
                            _cE("view", _uM("class" to "litem cityitem"), _uA(
                                _cE("text", _uM("class" to "text align-center background-white"), "昆明")
                            )),
                            _cE("view", _uM("class" to "litem cityitem"), _uA(
                                _cE("text", _uM("class" to "text align-center background-white"), "昆明")
                            )),
                            _cE("view", _uM("class" to "litem cityitem"), _uA(
                                _cE("text", _uM("class" to "text align-center background-white"), "昆明")
                            )),
                            _cE("view", _uM("class" to "litem cityitem"), _uA(
                                _cE("text", _uM("class" to "text align-center background-white"), "昆明")
                            )),
                            _cE("view", _uM("class" to "litem cityitem"), _uA(
                                _cE("text", _uM("class" to "text align-center background-white"), "昆明")
                            ))
                        ))
                    )),
                    _cE("scroll-view", _uM("direction" to "vertical", "style" to _nS(_uM("height" to (unref(PageHeight) + "px")))), _uA(
                        _cE("list-view", _uM("class" to "page", "direction" to "vertical", "scroll-into-view" to unref(scrollIntoView)), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(unref(sectionArray), fun(section, __key, __index, _cached): Any {
                                return _cE("sticky-section", _uM("key" to section.name, "padding" to unref(sectionPadding), "push-pinned-header" to true), _uA(
                                    _cE("sticky-header", _uM("id" to section.name), _uA(
                                        _cE("text", _uM("class" to "sticky-header-text titleline"), _tD(section.name), 1)
                                    ), 8, _uA(
                                        "id"
                                    )),
                                    _cE(Fragment, null, RenderHelpers.renderList(section.list, fun(list, __key, __index, _cached): Any {
                                        return _cE("list-item", _uM("key" to list.code, "name" to list.name, "class" to "content-item background-white", "type" to 10, "onClick" to fun(){
                                            click(list)
                                        }
                                        ), _uA(
                                            _cE("view", _uM("class" to "city"), _uA(
                                                _cE("text", _uM("class" to "text"), _tD(list.name), 1)
                                            ))
                                        ), 8, _uA(
                                            "name",
                                            "onClick"
                                        ))
                                    }
                                    ), 128)
                                ), 8, _uA(
                                    "padding"
                                ))
                            }
                            ), 128)
                        ), 8, _uA(
                            "scroll-into-view"
                        ))
                    ), 4),
                    _cE("view", _uM("class" to "zimu position-fixed background-white"), _uA(
                        _cE(Fragment, null, RenderHelpers.renderList(unref(zimuList), fun(zi, __key, __index, _cached): Any {
                            return _cE("text", _uM("class" to "zi align-center", "key" to zi, "onTouchstart" to fun(`$event`: Any){
                                touchZimu(zi, `$event`)
                            }
                            , "onTouchmove" to touchMove, "onTouchend" to touchEnd), _tD(zi), 41, _uA(
                                "onTouchstart"
                            ))
                        }
                        ), 128)
                    )),
                    if (isTrue(unref(showView))) {
                        _cE("view", _uM("key" to 0, "class" to "zhanshi position-fixed background-main"), _uA(
                            _cE("text", _uM("class" to "text align-center color-white"), _tD(unref(scrollIntoView)), 1)
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
                return _uM("native" to _pS(_uM("backgroundImage" to "none", "backgroundColor" to "#f5f5f5")), "nativetitle" to _uM(".native " to _uM("paddingLeft" to "16rpx", "paddingRight" to "22rpx", "paddingTop" to 13, "height" to 40)), "text" to _uM(".native " to _uM("fontSize" to 14, "marginLeft" to "6rpx"), ".hotcity .citylist .cityitem " to _uM("marginLeft" to "21rpx", "lineHeight" to "28px", "fontSize" to 15), ".content-item " to _uM("lineHeight" to "34px", "fontSize" to 14, "paddingLeft" to 4), ".zhanshi " to _uM("lineHeight" to "60px", "fontSize" to 30)), "searchbox" to _pS(_uM("marginLeft" to "15rpx", "marginRight" to "15rpx", "marginTop" to 7)), "inputbox" to _uM(".searchbox " to _uM("width" to "720rpx", "height" to 30, "borderTopLeftRadius" to 4, "borderTopRightRadius" to 4, "borderBottomRightRadius" to 4, "borderBottomLeftRadius" to 4)), "sousuo" to _uM(".searchbox .inputbox " to _uM("paddingTop" to 8, "paddingLeft" to "10rpx")), "input" to _uM(".searchbox .inputbox " to _uM("marginLeft" to "10rpx", "fontSize" to 14, "width" to "530rpx")), "empty" to _uM(".searchbox .inputbox " to _uM("width" to "68rpx", "paddingTop" to 7)), "hotcity" to _pS(_uM("marginLeft" to "15rpx", "marginRight" to "15rpx", "marginTop" to 13)), "title" to _uM(".hotcity " to _uM("fontSize" to 14)), "citylist" to _uM(".hotcity " to _uM("width" to "730rpx", "marginLeft" to "-11rpx", "marginTop" to 13)), "cityitem" to _uM(".hotcity .citylist " to _uM("width" to "25%", "height" to 28, "marginBottom" to 8, "borderTopLeftRadius" to 4, "borderTopRightRadius" to 4, "borderBottomRightRadius" to 4, "borderBottomLeftRadius" to 4)), "sticky-header-text" to _pS(_uM("fontSize" to 16, "paddingTop" to 8, "paddingRight" to 8, "paddingBottom" to 8, "paddingLeft" to 8, "color" to "#959595", "backgroundColor" to "#f5f5f5")), "titleline" to _pS(_uM("borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#b3b3b3")), "content-item" to _pS(_uM("height" to 36)), "city" to _uM(".content-item " to _uM("marginRight" to 15, "marginLeft" to 15, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#E0E0E0")), "page" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "zimu" to _pS(_uM("right" to 6, "bottom" to 40, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#F7F7F7", "borderRightColor" to "#F7F7F7", "borderBottomColor" to "#F7F7F7", "borderLeftColor" to "#F7F7F7", "width" to 21)), "zi" to _uM(".zimu " to _uM("fontSize" to 14, "color" to "#808080", "lineHeight" to "21px")), "zhanshi" to _pS(_uM("borderTopLeftRadius" to 6, "borderTopRightRadius" to 6, "borderBottomRightRadius" to 6, "borderBottomLeftRadius" to 6, "width" to 60, "height" to 60, "bottom" to "45%", "right" to 60)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
