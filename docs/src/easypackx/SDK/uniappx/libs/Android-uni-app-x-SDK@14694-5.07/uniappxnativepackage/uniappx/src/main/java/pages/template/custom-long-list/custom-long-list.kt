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
open class GenPagesTemplateCustomLongListCustomLongList : BasePage {
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
        var setup: (__props: GenPagesTemplateCustomLongListCustomLongList) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesTemplateCustomLongListCustomLongList
            val _cache = __ins.renderCache
            val title = ref("自定义复用滚动列表")
            val list = reactive<UTSArray<Item__12>>(_uA<Item__12>())
            val refresherEnabled = ref(true)
            val refresherTriggered = ref(false)
            val hasMore = ref(true)
            val minCode: Number = 0x4E00
            val maxCode: Number = 0x9FFF
            val codeRange = maxCode - minCode
            fun generateChineseString(index: Number, length: Number = 4): String {
                var result = ""
                run {
                    var i: Number = 0
                    while(i < length){
                        val code = (index * length + i) % codeRange + minCode
                        result += String.fromCharCode(code)
                        i++
                    }
                }
                return result
            }
            fun gen_loadData_fn() {
                run {
                    var i: Number = 0
                    while(i < 200){
                        val index = list.length
                        val tags: UTSArray<String> = _uA()
                        val tagCount: Number = 4
                        run {
                            var i: Number = 0
                            while(i < tagCount){
                                tags.push(generateChineseString(index * tagCount + i, 4))
                                i++
                            }
                        }
                        list.push(Item__12(img = "https://web-ext-storage.dcloud.net.cn/hello-uni-app-x/drop-card-" + (index % 3 + 1) + ".jpg", name = "Name_" + index, info = "Info_" + index, tags = tags))
                        i++
                    }
                }
            }
            val loadData = ::gen_loadData_fn
            onMounted(fun(){
                loadData()
            }
            )
            fun gen_onRefresherRefresh_fn() {
                refresherTriggered.value = true
                setTimeout(fun(){
                    list.splice(0, list.length)
                    loadData()
                    refresherTriggered.value = false
                }
                , 1000)
            }
            val onRefresherRefresh = ::gen_onRefresherRefresh_fn
            fun gen_onScrollToLower_fn() {
                if (list.length >= 5000) {
                    hasMore.value = false
                } else {
                    loadData()
                }
            }
            val onScrollToLower = ::gen_onScrollToLower_fn
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                val _component_navigator = resolveComponent("navigator")
                val _component_custom_recycle_view_buttons = resolveEasyComponent("custom-recycle-view-buttons", GenComponentsCustomRecycleViewButtonsCustomRecycleViewButtonsClass)
                val _component_uni_recycle_item = resolveEasyComponent("uni-recycle-item", GenUniModulesUniRecycleViewComponentsUniRecycleItemUniRecycleItemClass)
                val _component_uni_recycle_view = resolveEasyComponent("uni-recycle-view", GenUniModulesUniRecycleViewComponentsUniRecycleViewUniRecycleViewClass)
                return _cE("view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cV(_component_page_head, _uM("title" to unref(title)), null, 8, _uA(
                        "title"
                    )),
                    _cE("view", _uM("class" to "tips"), "滚动期间对子组件回收复用。此示例限制列表子项固定高度。注意回收复用引发的副作用，详情参考custom-recycle-view-buttons组件内的错误用法。"),
                    _cV(_component_uni_recycle_view, _uM("itemHeight" to 140, "list" to unref(list), "style" to _nS(_uM("flex" to "1")), "onScrolltolower" to onScrollToLower, "onRefresherrefresh" to onRefresherRefresh, "refresher-enabled" to unref(refresherEnabled), "refresher-triggered" to unref(refresherTriggered)), _uM("default" to withScopedSlotCtx(fun(slotProps: Record<String, Any?>): UTSArray<Any> {
                        val layoutItems = slotProps["layoutItems"]
                        val items = slotProps["items"]
                        return _uA(
                            _cE(Fragment, null, RenderHelpers.renderList((items as UTSArray<Item__12>), fun(item, index, __index, _cached): Any {
                                return _cV(_component_uni_recycle_item, _uM("key" to (layoutItems as UTSArray<LayoutItem>)[index].id, "offset" to (layoutItems as UTSArray<LayoutItem>)[index].offset), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cE("view", _uM("class" to "item-wrapper"), _uA(
                                            _cV(_component_navigator, _uM("hover-stay-time" to 0, "url" to ("/pages/template/custom-long-list/detail?name=" + item.name)), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("view", _uM("class" to "item-content"), _uA(
                                                        _cE("image", _uM("class" to "item-image", "src" to item.img, "mode" to "aspectFill"), null, 8, _uA(
                                                            "src"
                                                        )),
                                                        _cE("view", _uM("class" to "item-text"), _uA(
                                                            _cE("view", null, _uA(
                                                                _cE("text", _uM("class" to "item-name"), _tD(item.name), 1)
                                                            )),
                                                            _cE("view", null, _uA(
                                                                _cE("text", _uM("class" to "item-info"), _tD(if (item.name.length % 2 == 0) {
                                                                    "name长度为偶数"
                                                                } else {
                                                                    "name长度为奇数"
                                                                }
                                                                ), 1)
                                                            )),
                                                            _cE("view", null, _uA(
                                                                _cE("text", _uM("class" to "item-info"), _tD(item.info), 1)
                                                            )),
                                                            _cE("view", null, _uA(
                                                                _cE("text", _uM("class" to "item-info"), _tD(if (item.info.length % 2 == 0) {
                                                                    "info长度为偶数"
                                                                } else {
                                                                    "info长度为奇数"
                                                                }
                                                                ), 1)
                                                            )),
                                                            _cE("view", null, _uA(
                                                                _cE("text", _uM("class" to "item-info"), _tD(if ((item.info.length + item.name.length) % 2 == 0) {
                                                                    "name+info长度为偶数"
                                                                } else {
                                                                    "name+info长度为奇数"
                                                                }
                                                                ), 1)
                                                            )),
                                                            if (item.tags.length > 0) {
                                                                _cE("view", _uM("key" to 0, "class" to "item-tags"), _uA(
                                                                    _cE("text", _uM("class" to "item-info"), "随机tag："),
                                                                    _cE(Fragment, null, RenderHelpers.renderList(item.tags, fun(tag, index, __index, _cached): Any {
                                                                        return _cE("text", _uM("class" to "item-tag", "key" to index), _tD(tag), 1)
                                                                    }), 128)
                                                                ))
                                                            } else {
                                                                _cC("v-if", true)
                                                            }
                                                        ))
                                                    ))
                                                )
                                            }
                                            ), "_" to 2), 1032, _uA(
                                                "url"
                                            )),
                                            _cV(_component_custom_recycle_view_buttons, _uM("name" to item.name), null, 8, _uA(
                                                "name"
                                            ))
                                        ))
                                    )
                                }
                                ), "_" to 2), 1032, _uA(
                                    "offset"
                                ))
                            }
                            ), 128)
                        )
                    }
                    ), "load-more" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to "load-more"), _uA(
                                _cE("text", _uM("class" to "load-more-text"), _tD(if (unref(hasMore)) {
                                    "加载中..."
                                } else {
                                    "没有更多"
                                }
                                ), 1)
                            ))
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "list",
                        "style",
                        "refresher-enabled",
                        "refresher-triggered"
                    ))
                ), 4)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("tips" to _pS(_uM("marginTop" to 10, "marginRight" to 10, "marginBottom" to 10, "marginLeft" to 10, "borderTopLeftRadius" to 5, "borderTopRightRadius" to 5, "borderBottomRightRadius" to 5, "borderBottomLeftRadius" to 5, "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "backgroundColor" to "#FFFFFF")), "item-wrapper" to _pS(_uM("height" to 140, "justifyContent" to "center", "boxSizing" to "border-box", "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#cccccc", "paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 15)), "item-content" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "flex-start")), "item-image" to _pS(_uM("width" to 80, "height" to 80)), "item-text" to _pS(_uM("flexDirection" to "column", "marginLeft" to 5)), "item-name" to _pS(_uM("fontSize" to 14)), "item-info" to _pS(_uM("fontSize" to 12, "color" to "#999999")), "item-tags" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center")), "item-tag" to _pS(_uM("backgroundColor" to "#F0F8FF", "color" to "#999999", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#999999", "borderRightColor" to "#999999", "borderBottomColor" to "#999999", "borderLeftColor" to "#999999", "borderTopLeftRadius" to 3, "borderTopRightRadius" to 3, "borderBottomRightRadius" to 3, "borderBottomLeftRadius" to 3, "paddingTop" to 0, "paddingRight" to 2, "paddingBottom" to 0, "paddingLeft" to 2, "fontSize" to 12, "lineHeight" to "16px", "marginRight" to 2)), "load-more-text" to _pS(_uM("color" to "#cccccc", "fontSize" to 12, "textAlign" to "center", "lineHeight" to "50px")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
