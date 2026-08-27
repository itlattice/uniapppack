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
import io.dcloud.uniapp.extapi.`$off` as uni__off
import io.dcloud.uniapp.extapi.`$on` as uni__on
import io.dcloud.uniapp.extapi.createSelectorQuery as uni_createSelectorQuery
open class GenPagesAPICreateSelectorQueryCreateSelectorQuery : BasePage {
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
    open var data: DataType__101
        get() {
            return unref(this.`$exposed`["data"]) as DataType__101
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var getRootNodeInfo: (selector: String) -> Unit
        get() {
            return unref(this.`$exposed`["getRootNodeInfo"]) as (selector: String) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "getRootNodeInfo", value)
        }
    open var getTextNodeInfo: () -> Unit
        get() {
            return unref(this.`$exposed`["getTextNodeInfo"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "getTextNodeInfo", value)
        }
    open var getImageNodeInfo: () -> Unit
        get() {
            return unref(this.`$exposed`["getImageNodeInfo"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "getImageNodeInfo", value)
        }
    open var getScrollViewNodeInfo: () -> Unit
        get() {
            return unref(this.`$exposed`["getScrollViewNodeInfo"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "getScrollViewNodeInfo", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPICreateSelectorQueryCreateSelectorQuery, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPICreateSelectorQueryCreateSelectorQuery
            val _cache = __ins.renderCache
            val data = reactive(DataType__101(title = "createSelectorQuery", nodeInfoList = _uA(), rootNodeInfo = null, selectCount = 0, selectAllCount = 0, fieldsResultContainNode = false, nodeResultContainNode = false, textNodeInfo = null, imageNodeInfo = null, scrollViewNodeInfo = null))
            val multiChildRef = ref<ComponentPublicInstance?>(null)
            val onChildReady = fun(count: Number, allCount: Number){
                data.selectCount = count
                data.selectAllCount = allCount
            }
            val getRootNodeInfo = fun(selector: String){
                uni_createSelectorQuery().select(selector).boundingClientRect().exec(fun(ret){
                    if (ret.length == 1) {
                        val nodeInfo = ret[0] as NodeInfo
                        val nodeType = NodeInfoType(left = nodeInfo.left, top = nodeInfo.top, right = nodeInfo.right, bottom = nodeInfo.bottom, width = nodeInfo.width, height = nodeInfo.height)
                        data.rootNodeInfo = nodeType
                    }
                }
                )
            }
            val getNodeInfo = fun(){
                uni_createSelectorQuery().select(".rect1").boundingClientRect().exec(fun(ret){
                    data.nodeInfoList.length = 0
                    val i = ret[0] as NodeInfo
                    data.nodeInfoList.push(NodeInfoType(left = i.left, top = i.top, right = i.right, bottom = i.bottom, width = i.width, height = i.height))
                }
                )
            }
            val getAllNodeInfo = fun(){
                uni_createSelectorQuery().selectAll(".rect").boundingClientRect().exec(fun(ret){
                    data.nodeInfoList.length = 0
                    val array = ret[0] as UTSArray<NodeInfo>
                    array.forEach(fun(i){
                        data.nodeInfoList.push(NodeInfoType(left = i.left, top = i.top, right = i.right, bottom = i.bottom, width = i.width, height = i.height))
                    }
                    )
                }
                )
            }
            val testFields = fun(){
                uni_createSelectorQuery().select(".rect1").fields(NodeField(node = true), fun(ret){
                    val isElement = (ret as NodeInfo).node is UniElement
                    if (isElement) {
                        data.fieldsResultContainNode = true
                    } else {
                        data.fieldsResultContainNode = false
                    }
                }
                ).exec()
            }
            val testNode = fun(){
                uni_createSelectorQuery().select("#canvas1").node(fun(ret){
                    val isElement = (ret as NodeInfo).node is UniElement
                    val isCanvasElement = ((ret as NodeInfo).node as UniCanvasElement).tagName == "CANVAS"
                    if (isElement && isCanvasElement) {
                        data.nodeResultContainNode = true
                    } else {
                        data.nodeResultContainNode = false
                    }
                }
                ).exec()
            }
            val getTextNodeInfo = fun(){
                uni_createSelectorQuery().select("#test-text").boundingClientRect().exec(fun(ret){
                    if (ret.length > 0) {
                        val i = ret[0] as NodeInfo
                        data.textNodeInfo = NodeInfoType(left = i.left, top = i.top, right = i.right, bottom = i.bottom, width = i.width, height = i.height)
                    }
                }
                )
            }
            val getImageNodeInfo = fun(){
                uni_createSelectorQuery().select("#test-image").boundingClientRect().exec(fun(ret){
                    if (ret.length > 0) {
                        val i = ret[0] as NodeInfo
                        data.imageNodeInfo = NodeInfoType(left = i.left, top = i.top, right = i.right, bottom = i.bottom, width = i.width, height = i.height)
                    }
                }
                )
            }
            val getScrollViewNodeInfo = fun(){
                uni_createSelectorQuery().select("#test-scroll-view").boundingClientRect().exec(fun(ret){
                    if (ret.length > 0) {
                        val i = ret[0] as NodeInfo
                        data.scrollViewNodeInfo = NodeInfoType(left = i.left, top = i.top, right = i.right, bottom = i.bottom, width = i.width, height = i.height)
                    }
                }
                )
            }
            onLoad(fun(_options){
                uni__on("childDataReady", onChildReady)
            }
            )
            onUnload(fun(){
                uni__off("childDataReady", onChildReady)
            }
            )
            onReady(fun(){
                testFields()
                testNode()
            }
            )
            onResize(fun(_options){})
            __expose(_uM("data" to data, "getRootNodeInfo" to getRootNodeInfo, "getTextNodeInfo" to getTextNodeInfo, "getImageNodeInfo" to getImageNodeInfo, "getScrollViewNodeInfo" to getScrollViewNodeInfo))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                val _component_page_intro = resolveEasyComponent("page-intro", GenComponentsPageIntroPageIntroClass)
                val _component_navigator = resolveComponent("navigator")
                return _cE("scroll-view", _uM("class" to "page-scroll-view", "style" to _nS(_uM("padding-bottom" to "var(--uni-safe-area-inset-bottom)"))), _uA(
                    _cE("view", _uM("class" to "page uni-list-cell-db-text", "id" to "page"), _uA(
                        _cV(_component_page_head, _uM("title" to unref(data).title), null, 8, _uA(
                            "title"
                        )),
                        _cV(_component_page_intro, _uM("content" to "本页演示 uni.createSelectorQuery：通过 select/selectAll 与 boundingClientRect 获取节点布局信息（left、top、right、bottom、width、height）；含 view、text、image、scroll-view 及子组件多根节点等查询示例，可测试 .fields/.node 结果；底部可跳转「滚动容器中的 createSelectorQuery」子页。")),
                        _cE("button", _uM("class" to "btn btn-get-node-info", "onClick" to getNodeInfo), "getNodeInfo"),
                        _cE("button", _uM("class" to "btn btn-get-all-node-info", "onClick" to getAllNodeInfo), "getAllNodeInfo"),
                        _cE("view", _uM("id" to "rect-1-2", "class" to "rect-1-2"), _uA(
                            _cE("view", _uM("class" to "rect rect1")),
                            _cE("view", _uM("class" to "rect rect2"))
                        )),
                        _cE("view", _uM("class" to "rect-info-1-2"), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(unref(data).nodeInfoList, fun(nodeInfo, index, __index, _cached): Any {
                                return _cE("view", _uM("class" to "rect-info", "key" to index), _uA(
                                    _cE("view", _uM("class" to "node-info-item"), _uA(
                                        _cE("text", _uM("class" to "node-info-item-k"), "left: "),
                                        _cE("text", _uM("class" to "node-info-item-v"), _tD(nodeInfo.left), 1)
                                    )),
                                    _cE("view", _uM("class" to "node-info-item"), _uA(
                                        _cE("text", _uM("class" to "node-info-item-k"), "top: "),
                                        _cE("text", _uM("class" to "node-info-item-v"), _tD(nodeInfo.top), 1)
                                    )),
                                    _cE("view", _uM("class" to "node-info-item"), _uA(
                                        _cE("text", _uM("class" to "node-info-item-k"), "right: "),
                                        _cE("text", _uM("class" to "node-info-item-v"), _tD(nodeInfo.right), 1)
                                    )),
                                    _cE("view", _uM("class" to "node-info-item"), _uA(
                                        _cE("text", _uM("class" to "node-info-item-k"), "bottom: "),
                                        _cE("text", _uM("class" to "node-info-item-v"), _tD(nodeInfo.bottom), 1)
                                    )),
                                    _cE("view", _uM("class" to "node-info-item"), _uA(
                                        _cE("text", _uM("class" to "node-info-item-k"), "width: "),
                                        _cE("text", _uM("class" to "node-info-item-v"), _tD(nodeInfo.width), 1)
                                    )),
                                    _cE("view", _uM("class" to "node-info-item"), _uA(
                                        _cE("text", _uM("class" to "node-info-item-k"), "height: "),
                                        _cE("text", _uM("class" to "node-info-item-v"), _tD(nodeInfo.height), 1)
                                    ))
                                ))
                            }
                            ), 128)
                        )),
                        _cV(unref(GenPagesAPICreateSelectorQueryNodesInfoChildClass), _uM("class" to "node-child")),
                        _cE("text", null, "子组件多根节点"),
                        _cV(unref(GenPagesAPICreateSelectorQuerySelectorQueryChildMultiClass), _uM("ref_key" to "multiChildRef", "ref" to multiChildRef, "id" to "multi-child"), null, 512),
                        _cE("text", null, "子组件多根节点(仅测试，用于验证查询是否超出范围)"),
                        _cV(unref(GenPagesAPICreateSelectorQuerySelectorQueryChildMultiClass), _uM("id" to "multi-child-2")),
                        _cE("view", null, _uA(
                            _cE("text", null, "测试.fields"),
                            _cE("text", null, _tD(unref(data).fieldsResultContainNode), 1)
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "测试.node"),
                            _cE("text", null, _tD(unref(data).nodeResultContainNode), 1)
                        )),
                        _cE("canvas", _uM("id" to "canvas1")),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "Text 组件查询示例"),
                            _cE("text", _uM("id" to "test-text", "class" to "test-text"), "这是一个测试文本元素"),
                            _cE("button", _uM("class" to "btn", "onClick" to getTextNodeInfo), "查询 Text 节点信息"),
                            if (isTrue(unref(data).textNodeInfo)) {
                                _cE("view", _uM("key" to 0, "class" to "rect-info"), _uA(
                                    _cE("view", _uM("class" to "node-info-item"), _uA(
                                        _cE("text", _uM("class" to "node-info-item-k"), "left: "),
                                        _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(data).textNodeInfo!!.left), 1)
                                    )),
                                    _cE("view", _uM("class" to "node-info-item"), _uA(
                                        _cE("text", _uM("class" to "node-info-item-k"), "right: "),
                                        _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(data).textNodeInfo!!.right), 1)
                                    )),
                                    _cE("view", _uM("class" to "node-info-item"), _uA(
                                        _cE("text", _uM("class" to "node-info-item-k"), "top: "),
                                        _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(data).textNodeInfo!!.top), 1)
                                    )),
                                    _cE("view", _uM("class" to "node-info-item"), _uA(
                                        _cE("text", _uM("class" to "node-info-item-k"), "bottom: "),
                                        _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(data).textNodeInfo!!.bottom), 1)
                                    )),
                                    _cE("view", _uM("class" to "node-info-item"), _uA(
                                        _cE("text", _uM("class" to "node-info-item-k"), "width: "),
                                        _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(data).textNodeInfo!!.width), 1)
                                    )),
                                    _cE("view", _uM("class" to "node-info-item"), _uA(
                                        _cE("text", _uM("class" to "node-info-item-k"), "height: "),
                                        _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(data).textNodeInfo!!.height), 1)
                                    ))
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "Image 组件查询示例"),
                            _cE("image", _uM("id" to "test-image", "class" to "test-image", "src" to "/static/test-image/logo.png", "mode" to "aspectFit")),
                            _cE("button", _uM("class" to "btn", "onClick" to getImageNodeInfo), "查询 Image 节点信息"),
                            if (isTrue(unref(data).imageNodeInfo)) {
                                _cE("view", _uM("key" to 0, "class" to "rect-info"), _uA(
                                    _cE("view", _uM("class" to "node-info-item"), _uA(
                                        _cE("text", _uM("class" to "node-info-item-k"), "left: "),
                                        _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(data).imageNodeInfo!!.left), 1)
                                    )),
                                    _cE("view", _uM("class" to "node-info-item"), _uA(
                                        _cE("text", _uM("class" to "node-info-item-k"), "right: "),
                                        _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(data).imageNodeInfo!!.right), 1)
                                    )),
                                    _cE("view", _uM("class" to "node-info-item"), _uA(
                                        _cE("text", _uM("class" to "node-info-item-k"), "top: "),
                                        _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(data).imageNodeInfo!!.top), 1)
                                    )),
                                    _cE("view", _uM("class" to "node-info-item"), _uA(
                                        _cE("text", _uM("class" to "node-info-item-k"), "bottom: "),
                                        _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(data).imageNodeInfo!!.bottom), 1)
                                    )),
                                    _cE("view", _uM("class" to "node-info-item"), _uA(
                                        _cE("text", _uM("class" to "node-info-item-k"), "width: "),
                                        _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(data).imageNodeInfo!!.width), 1)
                                    )),
                                    _cE("view", _uM("class" to "node-info-item"), _uA(
                                        _cE("text", _uM("class" to "node-info-item-k"), "height: "),
                                        _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(data).imageNodeInfo!!.height), 1)
                                    ))
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "Scroll-view 组件查询示例"),
                            _cE("scroll-view", _uM("id" to "test-scroll-view", "class" to "test-scroll-view"), _uA(
                                _cE("view", _uM("style" to _nS(_uM("padding" to "10px"))), _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(10, fun(i, __key, __index, _cached): Any {
                                        return _cE("text", _uM("key" to i), "Scroll-view 第 " + _tD(i) + " 行", 1)
                                    }
                                    ), 64)
                                ), 4)
                            )),
                            _cE("button", _uM("class" to "btn", "onClick" to getScrollViewNodeInfo), "查询 Scroll-view 节点信息"),
                            if (isTrue(unref(data).scrollViewNodeInfo)) {
                                _cE("view", _uM("key" to 0, "class" to "rect-info"), _uA(
                                    _cE("view", _uM("class" to "node-info-item"), _uA(
                                        _cE("text", _uM("class" to "node-info-item-k"), "left: "),
                                        _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(data).scrollViewNodeInfo!!.left), 1)
                                    )),
                                    _cE("view", _uM("class" to "node-info-item"), _uA(
                                        _cE("text", _uM("class" to "node-info-item-k"), "right: "),
                                        _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(data).scrollViewNodeInfo!!.right), 1)
                                    )),
                                    _cE("view", _uM("class" to "node-info-item"), _uA(
                                        _cE("text", _uM("class" to "node-info-item-k"), "top: "),
                                        _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(data).scrollViewNodeInfo!!.top), 1)
                                    )),
                                    _cE("view", _uM("class" to "node-info-item"), _uA(
                                        _cE("text", _uM("class" to "node-info-item-k"), "bottom: "),
                                        _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(data).scrollViewNodeInfo!!.bottom), 1)
                                    )),
                                    _cE("view", _uM("class" to "node-info-item"), _uA(
                                        _cE("text", _uM("class" to "node-info-item-k"), "width: "),
                                        _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(data).scrollViewNodeInfo!!.width), 1)
                                    )),
                                    _cE("view", _uM("class" to "node-info-item"), _uA(
                                        _cE("text", _uM("class" to "node-info-item-k"), "height: "),
                                        _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(data).scrollViewNodeInfo!!.height), 1)
                                    ))
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                        ))
                    )),
                    _cV(_component_navigator, _uM("url" to "/pages/API/create-selector-query/create-selector-query-onScroll"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("button", null, "滚动容器中的createSelectorQuery")
                        )
                    }
                    ), "_" to 1))
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
                return _uM("page" to _pS(_uM("paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15)), "btn" to _pS(_uM("marginTop" to 15)), "rect-1-2" to _pS(_uM("flexDirection" to "row", "marginTop" to 15)), "rect" to _pS(_uM("width" to 150, "height" to 100)), "rect1" to _pS(_uM("backgroundColor" to "#1E90FF")), "rect2" to _pS(_uM("marginLeft" to "auto", "backgroundColor" to "#2E8B57")), "rect-info-1-2" to _pS(_uM("flexDirection" to "row", "marginTop" to 15)), "rect-info" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "flexDirection" to "column")), "node-info-item" to _pS(_uM("flexDirection" to "row")), "node-info-item-k" to _pS(_uM("width" to 72, "lineHeight" to 2)), "node-info-item-v" to _pS(_uM("fontWeight" to "bold", "lineHeight" to 2)), "test-text" to _pS(_uM("paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "backgroundColor" to "#d6d6d6", "marginTop" to 10, "marginRight" to 0, "marginBottom" to 10, "marginLeft" to 0, "fontSize" to 16, "color" to "#333333")), "test-image" to _pS(_uM("marginTop" to 10, "marginRight" to 0, "marginBottom" to 10, "marginLeft" to 0, "width" to 100, "height" to 100)), "test-scroll-view" to _pS(_uM("marginTop" to 10, "marginRight" to 0, "marginBottom" to 10, "marginLeft" to 0, "width" to 300, "height" to 100, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#cccccc", "borderRightColor" to "#cccccc", "borderBottomColor" to "#cccccc", "borderLeftColor" to "#cccccc")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
