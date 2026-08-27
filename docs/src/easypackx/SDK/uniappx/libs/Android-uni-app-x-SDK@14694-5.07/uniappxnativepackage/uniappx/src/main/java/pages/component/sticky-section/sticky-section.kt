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
import io.dcloud.uniapp.extapi.getElementById as uni_getElementById
open class GenPagesComponentStickySectionStickySection : BasePage {
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
    open var pageData: DataType__15
        get() {
            return unref(this.`$exposed`["pageData"]) as DataType__15
        }
        set(value) {
            setRefValue(this.`$exposed`, "pageData", value)
        }
    open var deleteSection: () -> Unit
        get() {
            return unref(this.`$exposed`["deleteSection"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "deleteSection", value)
        }
    open var listViewScrollByY: (y: Number) -> Unit
        get() {
            return unref(this.`$exposed`["listViewScrollByY"]) as (y: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "listViewScrollByY", value)
        }
    open var toTop: () -> Unit
        get() {
            return unref(this.`$exposed`["toTop"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "toTop", value)
        }
    open var gotoStickyHeader: (id: String) -> Unit
        get() {
            return unref(this.`$exposed`["gotoStickyHeader"]) as (id: String) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "gotoStickyHeader", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentStickySectionStickySection, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentStickySectionStickySection
            val _cache = __ins.renderCache
            val pageData = reactive(DataType__15(data = _uA(
                "A",
                "B",
                "C",
                "D",
                "E",
                "F",
                "G",
                "H",
                "I",
                "J",
                "K",
                "L",
                "M",
                "N"
            ), sectionPadding = _uA(
                0,
                10,
                0,
                10
            ), scrollIntoView = "", scrolling = false, sectionArray = _uA(), appendId = 0, refresherTriggered = false, isReady = false))
            val listViewRef = ref<UniElement?>(null)
            val initSectionArray = fun(){
                pageData.sectionArray = _uA()
                console.log("initSectionArray start", pageData.sectionArray.length)
                pageData.data.forEach(fun(key){
                    val list = _uA<sectionListItem>()
                    run {
                        var i: Number = 1
                        while(i < 11){
                            val item = sectionListItem(text = key + "--item--content----" + i)
                            list.push(item)
                            i++
                        }
                    }
                    val sectionDataItem = sectionData(name = key, list = list)
                    pageData.sectionArray.push(sectionDataItem)
                }
                )
                console.log("initSectionArray end", pageData.sectionArray[0].name)
            }
            onReady(fun(){
                initSectionArray()
                pageData.isReady = true
            }
            )
            val toTop = fun(){
                pageData.scrollIntoView = ""
                uni_getElementById("list-view")!!.scrollTop = 0
            }
            val listViewScrollByY = fun(y: Number){
                val listview = listViewRef.value as UniElement
                listview.scrollTop = y
            }
            val gotoStickyHeader = fun(id: String){
                pageData.scrollIntoView = id
            }
            val onScroll = fun(){
                pageData.scrolling = true
            }
            val onScrollEnd = fun(){
                pageData.scrolling = false
                if (pageData.scrollIntoView != "") {
                    pageData.scrollIntoView = ""
                }
            }
            val appendSectionItem = fun(index: Number){
                val sectionDataItem = pageData.sectionArray[index]
                pageData.appendId++
                val list = _uA<sectionListItem>(sectionListItem(text = sectionDataItem.name + "--item--content----new1--" + pageData.appendId), sectionListItem(text = sectionDataItem.name + "--item--content----new2--" + pageData.appendId), sectionListItem(text = sectionDataItem.name + "--item--content----new3--" + pageData.appendId), sectionListItem(text = sectionDataItem.name + "--item--content----new4--" + pageData.appendId), sectionListItem(text = sectionDataItem.name + "--item--content----new5--" + pageData.appendId))
                sectionDataItem.list.unshift(*list.toTypedArray())
            }
            val deleteSection = fun(){
                pageData.sectionArray.shift()
            }
            val onRefresherrefresh = fun(_: UniRefresherEvent){
                pageData.refresherTriggered = true
                setTimeout(fun(){
                    initSectionArray()
                    pageData.refresherTriggered = false
                }
                , 1000)
            }
            __expose(_uM("pageData" to pageData, "deleteSection" to deleteSection, "listViewScrollByY" to listViewScrollByY, "toTop" to toTop, "gotoStickyHeader" to gotoStickyHeader))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE(Fragment, null, _uA(
                    _cV(_component_page_head, _uM("title" to "sticky-section")),
                    _cE("list-view", _uM("id" to "list-view", "ref_key" to "listViewRef", "ref" to listViewRef, "show-scrollbar" to "false", "class" to "page", "scroll-into-view" to unref(pageData).scrollIntoView, "onScroll" to onScroll, "onScrollend" to onScrollEnd, "bounces" to "false", "refresher-enabled" to "true", "refresher-triggered" to unref(pageData).refresherTriggered, "onRefresherrefresh" to onRefresherrefresh), _uA(
                        _cE("list-item", _uM("style" to _nS(_uM("padding" to "10px", "margin" to "5px 0", "align-items" to "center")), "type" to 20), _uA(
                            _cE("button", _uM("onClick" to fun(){
                                gotoStickyHeader("C")
                            }
                            , "size" to "mini"), "跳转到id为C的sticky-header位置上", 8, _uA(
                                "onClick"
                            ))
                        ), 4),
                        _cE("list-item", _uM("style" to _nS(_uM("padding" to "10px", "margin" to "5px 0", "align-items" to "center")), "type" to 20), _uA(
                            _cE("button", _uM("onClick" to fun(){
                                appendSectionItem(0)
                            }
                            , "size" to "mini"), "第一组 section 新增5条内容", 8, _uA(
                                "onClick"
                            ))
                        ), 4),
                        _cE("list-item", _uM("style" to _nS(_uM("padding" to "10px", "margin" to "5px 0", "align-items" to "center")), "type" to 20), _uA(
                            _cE("button", _uM("onClick" to fun(){
                                deleteSection()
                            }
                            , "size" to "mini"), "删除第一组 section", 8, _uA(
                                "onClick"
                            ))
                        ), 4),
                        _cE(Fragment, null, RenderHelpers.renderList(unref(pageData).sectionArray, fun(section, __key, __index, _cached): Any {
                            return _cE("sticky-section", _uM("key" to section.name, "padding" to unref(pageData).sectionPadding, "push-pinned-header" to true), _uA(
                                _cE("sticky-header", _uM("id" to section.name), _uA(
                                    _cE("text", _uM("class" to "sticky-header-text"), _tD(section.name), 1)
                                ), 8, _uA(
                                    "id"
                                )),
                                _cE(Fragment, null, RenderHelpers.renderList(section.list, fun(list, __key, __index, _cached): Any {
                                    return _cE("list-item", _uM("key" to list.text, "name" to list.text, "class" to "content-item", "type" to 10), _uA(
                                        _cE("text", _uM("class" to "text"), _tD(list.text), 1)
                                    ), 8, _uA(
                                        "name"
                                    ))
                                }
                                ), 128)
                            ), 8, _uA(
                                "padding"
                            ))
                        }
                        ), 128),
                        if (unref(pageData).sectionArray.length > 0) {
                            _cE("list-item", _uM("key" to 0, "style" to _nS(_uM("padding" to "10px", "margin" to "5px 0", "align-items" to "center")), "type" to 30), _uA(
                                _cE("button", _uM("onClick" to toTop, "size" to "mini"), "回到顶部")
                            ), 4)
                        } else {
                            _cC("v-if", true)
                        }
                    ), 40, _uA(
                        "scroll-into-view",
                        "refresher-triggered"
                    ))
                ), 64)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("page" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "backgroundColor" to "#f5f5f5")), "sticky-header-text" to _pS(_uM("fontSize" to 16, "paddingTop" to 8, "paddingRight" to 8, "paddingBottom" to 8, "paddingLeft" to 8, "color" to "#959595", "backgroundColor" to "#f5f5f5")), "content-item" to _pS(_uM("paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15, "marginBottom" to 10, "backgroundColor" to "#ffffff")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
