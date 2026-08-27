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
import io.dcloud.uniapp.extapi.saveImageToPhotosAlbum as uni_saveImageToPhotosAlbum
import io.dcloud.uniapp.extapi.showActionSheet as uni_showActionSheet
import io.dcloud.uniapp.extapi.showModal as uni_showModal
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesAPIElementTakesnapshotElementTakesnapshot : BasePage {
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
    open var data: DataType__86
        get() {
            return unref(this.`$exposed`["data"]) as DataType__86
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var snapshotData: SnapshotDataType
        get() {
            return unref(this.`$exposed`["snapshotData"]) as SnapshotDataType
        }
        set(value) {
            setRefValue(this.`$exposed`, "snapshotData", value)
        }
    open var takeSnapshotClick: () -> Unit
        get() {
            return unref(this.`$exposed`["takeSnapshotClick"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "takeSnapshotClick", value)
        }
    open var takeViewSnapshot: () -> Unit
        get() {
            return unref(this.`$exposed`["takeViewSnapshot"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "takeViewSnapshot", value)
        }
    open var takeTextSnapshot: () -> Unit
        get() {
            return unref(this.`$exposed`["takeTextSnapshot"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "takeTextSnapshot", value)
        }
    open var takeImageSnapshot: () -> Unit
        get() {
            return unref(this.`$exposed`["takeImageSnapshot"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "takeImageSnapshot", value)
        }
    open var takeScrollViewSnapshot: () -> Unit
        get() {
            return unref(this.`$exposed`["takeScrollViewSnapshot"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "takeScrollViewSnapshot", value)
        }
    open var takeCustomComponentSnapshot: () -> Unit
        get() {
            return unref(this.`$exposed`["takeCustomComponentSnapshot"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "takeCustomComponentSnapshot", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIElementTakesnapshotElementTakesnapshot, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIElementTakesnapshotElementTakesnapshot
            val _cache = __ins.renderCache
            val mode = ref("center")
            val data = reactive(DataType__86(snapImage = "/static/test-image/logo.png", completeTriggered = false))
            val snapshotData = reactive(SnapshotDataType(viewSnapshot = "", textSnapshot = "", imageSnapshot = "", scrollViewSnapshot = "", customComponentSnapshot = ""))
            fun gen_takeSnapshotClick_fn() {
                val view = uni_getElementById("snapshot-content")!!
                view.takeSnapshot(TakeSnapshotOptions(success = fun(res){
                    console.log("takeSnapshot success", res.tempFilePath)
                    data.snapImage = res.tempFilePath
                    mode.value = "widthFix"
                    uni_showToast(ShowToastOptions(title = "截图成功，路径：" + res.tempFilePath, icon = "none"))
                }
                , fail = fun(res){
                    console.log("takeSnapshot fail", res)
                    uni_showToast(ShowToastOptions(icon = "error", title = "截图失败"))
                }
                , complete = fun(res){
                    data.completeTriggered = true
                    console.log("takeSnapshot complete", res)
                }
                ))
            }
            val takeSnapshotClick = ::gen_takeSnapshotClick_fn
            fun gen_saveToAlbum_fn(e: TouchEvent) {
                var filePath: String = e.currentTarget!!.getAttribute("src") as String
                uni_showActionSheet(ShowActionSheetOptions(itemList = _uA(
                    "保存"
                ), success = fun(res){
                    if (res.tapIndex == 0) {
                        uni_saveImageToPhotosAlbum(SaveImageToPhotosAlbumOptions(filePath = filePath, success = fun(_) {
                            uni_showToast(ShowToastOptions(position = "center", icon = "none", title = "图片保存成功，请到手机相册查看"))
                        }
                        , fail = fun(e) {
                            uni_showModal(ShowModalOptions(content = "保存相册失败，errCode：" + e.errCode + "，errMsg：" + e.errMsg + "，errSubject：" + e.errSubject, showCancel = false))
                        }
                        ))
                    }
                }
                , fail = fun(_){}, complete = fun(_){}))
            }
            val saveToAlbum = ::gen_saveToAlbum_fn
            fun gen_takeSnapshotForElement_fn(elementId: String, dataKey: String) {
                val element = uni_getElementById(elementId)!!
                element.takeSnapshot(TakeSnapshotOptions(success = fun(res){
                    snapshotData[dataKey] = res.tempFilePath
                    uni_showToast(ShowToastOptions(title = "截图成功", icon = "success"))
                }
                , fail = fun(res){
                    uni_showToast(ShowToastOptions(icon = "error", title = "截图失败"))
                }
                ))
            }
            val takeSnapshotForElement = ::gen_takeSnapshotForElement_fn
            fun gen_takeViewSnapshot_fn() {
                takeSnapshotForElement("snapshot-test-view", "viewSnapshot")
            }
            val takeViewSnapshot = ::gen_takeViewSnapshot_fn
            fun gen_takeTextSnapshot_fn() {
                takeSnapshotForElement("snapshot-test-text", "textSnapshot")
            }
            val takeTextSnapshot = ::gen_takeTextSnapshot_fn
            fun gen_takeImageSnapshot_fn() {
                takeSnapshotForElement("snapshot-test-image", "imageSnapshot")
            }
            val takeImageSnapshot = ::gen_takeImageSnapshot_fn
            fun gen_takeScrollViewSnapshot_fn() {
                takeSnapshotForElement("snapshot-test-scrollview", "scrollViewSnapshot")
            }
            val takeScrollViewSnapshot = ::gen_takeScrollViewSnapshot_fn
            fun gen_takeCustomComponentSnapshot_fn() {
                takeSnapshotForElement("snapshot-test-component", "customComponentSnapshot")
            }
            val takeCustomComponentSnapshot = ::gen_takeCustomComponentSnapshot_fn
            __expose(_uM("data" to data, "snapshotData" to snapshotData, "takeSnapshotClick" to takeSnapshotClick, "takeViewSnapshot" to takeViewSnapshot, "takeTextSnapshot" to takeTextSnapshot, "takeImageSnapshot" to takeImageSnapshot, "takeScrollViewSnapshot" to takeScrollViewSnapshot, "takeCustomComponentSnapshot" to takeCustomComponentSnapshot))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE("scroll-view", _uM("class" to "page-scroll-view"), _uA(
                    _cE("view", _uM("id" to "snapshot-content"), _uA(
                        _cV(_component_page_head, _uM("title" to "对本页面根view截图")),
                        _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                            _cE("text", null, "this is text")
                        )),
                        _cE("button", _uM("class" to "uni-btn btn-TakeSnapshot", "type" to "primary", "onClick" to takeSnapshotClick), " 点击截图并替换显示下方图片 "),
                        _cE("image", _uM("class" to "snapshot-original-image", "src" to unref(data).snapImage, "mode" to unref(mode), "onLongpress" to saveToAlbum), null, 40, _uA(
                            "src",
                            "mode"
                        )),
                        _cE("view", _uM("class" to "section-divider")),
                        _cE("text", _uM("class" to "section-title"), "takeSnapshot 测试"),
                        _cE("view", _uM("class" to "test-group"), _uA(
                            _cE("view", _uM("class" to "test-buttons"), _uA(
                                _cE("button", _uM("class" to "btn-small", "onClick" to takeViewSnapshot), "View")
                            )),
                            _cE("view", _uM("class" to "test-elements"), _uA(
                                _cE("view", _uM("id" to "snapshot-test-view", "class" to "snapshot-test-small"))
                            ))
                        )),
                        if (unref(snapshotData).viewSnapshot != null) {
                            _cE("view", _uM("key" to 0, "class" to "snapshot-row"), _uA(
                                _cE("view", _uM("class" to "snapshot-data-col"), _uA(
                                    _cE("text", _uM("class" to "snapshot-data-subtitle"), "截图结果"),
                                    _cE("image", _uM("class" to "snapshot-preview", "src" to unref(snapshotData).viewSnapshot, "mode" to "aspectFit", "onLongpress" to saveToAlbum), null, 40, _uA(
                                        "src"
                                    ))
                                ))
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        _cE("view", _uM("class" to "test-group"), _uA(
                            _cE("view", _uM("class" to "test-buttons"), _uA(
                                _cE("button", _uM("class" to "btn-small", "onClick" to takeTextSnapshot), "Text")
                            )),
                            _cE("view", _uM("class" to "test-elements"), _uA(
                                _cE("text", _uM("id" to "snapshot-test-text", "class" to "snapshot-test-text-small"), "测试文本")
                            ))
                        )),
                        if (unref(snapshotData).textSnapshot != null) {
                            _cE("view", _uM("key" to 1, "class" to "snapshot-row"), _uA(
                                _cE("view", _uM("class" to "snapshot-data-col"), _uA(
                                    _cE("text", _uM("class" to "snapshot-data-subtitle"), "截图结果"),
                                    _cE("image", _uM("class" to "snapshot-preview", "src" to unref(snapshotData).textSnapshot, "mode" to "aspectFit", "onLongpress" to saveToAlbum), null, 40, _uA(
                                        "src"
                                    ))
                                ))
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        _cE("view", _uM("class" to "test-group"), _uA(
                            _cE("view", _uM("class" to "test-buttons"), _uA(
                                _cE("button", _uM("class" to "btn-small", "onClick" to takeImageSnapshot), "Image")
                            )),
                            _cE("view", _uM("class" to "test-elements"), _uA(
                                _cE("image", _uM("id" to "snapshot-test-image", "class" to "snapshot-test-image-small", "src" to "/static/test-image/logo.png", "mode" to "aspectFit"))
                            ))
                        )),
                        if (unref(snapshotData).imageSnapshot != null) {
                            _cE("view", _uM("key" to 2, "class" to "snapshot-row"), _uA(
                                _cE("view", _uM("class" to "snapshot-data-col"), _uA(
                                    _cE("text", _uM("class" to "snapshot-data-subtitle"), "截图结果"),
                                    _cE("image", _uM("class" to "snapshot-preview", "src" to unref(snapshotData).imageSnapshot, "mode" to "aspectFit", "onLongpress" to saveToAlbum), null, 40, _uA(
                                        "src"
                                    ))
                                ))
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        _cE("button", _uM("class" to "btn uni-common-mt", "type" to "default", "onClick" to takeScrollViewSnapshot), "takeSnapshot - ScrollView"),
                        _cE("scroll-view", _uM("id" to "snapshot-test-scrollview", "class" to "snapshot-test-scrollview"), _uA(
                            _cE("view", _uM("class" to "scroll-content"), _uA(
                                _cE("text", _uM("class" to "scroll-text"), "滚动区域内容1")
                            )),
                            _cE("view", _uM("class" to "scroll-content"), _uA(
                                _cE("text", _uM("class" to "scroll-text"), "滚动区域内容2")
                            )),
                            _cE("view", _uM("class" to "scroll-content"), _uA(
                                _cE("text", _uM("class" to "scroll-text"), "滚动区域内容3")
                            ))
                        )),
                        if (isTrue(unref(snapshotData).scrollViewSnapshot)) {
                            _cE("image", _uM("key" to 3, "class" to "snapshot-result-image", "src" to unref(snapshotData).scrollViewSnapshot, "mode" to "widthFix", "onLongpress" to saveToAlbum), null, 40, _uA(
                                "src"
                            ))
                        } else {
                            _cE("text", _uM("key" to 4, "class" to "snapshot-placeholder-center"), "暂无截图")
                        }
                        ,
                        _cE("button", _uM("class" to "btn uni-common-mt", "type" to "default", "onClick" to takeCustomComponentSnapshot), "takeSnapshot - 自定义组件"),
                        _cV(unref(GenPagesAPIElementTakesnapshotChildClass), _uM("id" to "snapshot-test-component", "class" to "snapshot-test-component")),
                        if (isTrue(unref(snapshotData).customComponentSnapshot)) {
                            _cE("image", _uM("key" to 5, "class" to "snapshot-result-image uni-common-mb", "src" to unref(snapshotData).customComponentSnapshot, "mode" to "widthFix", "onLongpress" to saveToAlbum), null, 40, _uA(
                                "src"
                            ))
                        } else {
                            _cE("text", _uM("key" to 6, "class" to "snapshot-placeholder-center"), "暂无截图")
                        }
                    ))
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
                return _uM("section-divider" to _pS(_uM("marginTop" to 30, "height" to 1, "backgroundColor" to "#e0e0e0")), "section-title" to _pS(_uM("marginTop" to 15, "fontSize" to 16, "fontWeight" to "bold", "color" to "#333333")), "test-group" to _pS(_uM("marginTop" to 20, "marginRight" to 20, "marginBottom" to 20, "marginLeft" to 20, "flexDirection" to "column")), "test-buttons" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-around", "marginBottom" to 10)), "btn-small" to _pS(_uM("paddingTop" to 5, "paddingRight" to 15, "paddingBottom" to 5, "paddingLeft" to 15, "fontSize" to 13, "borderTopLeftRadius" to 4, "borderTopRightRadius" to 4, "borderBottomRightRadius" to 4, "borderBottomLeftRadius" to 4, "flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 5, "marginBottom" to 0, "marginLeft" to 5)), "test-elements" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-around", "alignItems" to "center", "marginTop" to 20, "marginRight" to 20, "marginBottom" to 20, "marginLeft" to 20)), "snapshot-test-small" to _pS(_uM("width" to "80%", "height" to 60, "backgroundColor" to "#1E90FF")), "snapshot-test-text-small" to _pS(_uM("width" to "80%", "paddingTop" to 8, "paddingRight" to 8, "paddingBottom" to 8, "paddingLeft" to 8, "fontSize" to 14, "color" to "#ffffff", "backgroundColor" to "#ff6b6b")), "snapshot-test-image-small" to _pS(_uM("width" to "80%", "height" to 60, "backgroundColor" to "#f0f0f0")), "snapshot-row" to _pS(_uM("flexDirection" to "row", "marginTop" to 10, "backgroundColor" to "#f5f7fa", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#dcdfe6", "borderRightColor" to "#dcdfe6", "borderBottomColor" to "#dcdfe6", "borderLeftColor" to "#dcdfe6", "borderTopLeftRadius" to 4, "borderTopRightRadius" to 4, "borderBottomRightRadius" to 4, "borderBottomLeftRadius" to 4, "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10)), "snapshot-data-col" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "flexDirection" to "column", "marginTop" to 0, "marginRight" to 5, "marginBottom" to 0, "marginLeft" to 5, "alignItems" to "center")), "snapshot-data-subtitle" to _pS(_uM("fontSize" to 13, "fontWeight" to "bold", "color" to "#409eff", "marginBottom" to 5)), "snapshot-preview" to _pS(_uM("width" to "100%", "height" to 120, "backgroundColor" to "#ffffff", "borderTopLeftRadius" to 4, "borderTopRightRadius" to 4, "borderBottomRightRadius" to 4, "borderBottomLeftRadius" to 4)), "snapshot-placeholder" to _pS(_uM("fontSize" to 12, "color" to "#909399", "paddingTop" to 20, "paddingRight" to 0, "paddingBottom" to 20, "paddingLeft" to 0)), "snapshot-original-image" to _pS(_uM("marginLeft" to "auto", "marginRight" to "auto", "marginTop" to 20, "width" to "90%")), "snapshot-result-image" to _pS(_uM("marginLeft" to "auto", "marginRight" to "auto", "marginTop" to 10, "width" to "90%")), "snapshot-placeholder-center" to _pS(_uM("fontSize" to 12, "color" to "#909399", "textAlign" to "center", "marginTop" to 10)), "snapshot-test-scrollview" to _pS(_uM("marginTop" to 15, "height" to 120, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#dcdfe6", "borderRightColor" to "#dcdfe6", "borderBottomColor" to "#dcdfe6", "borderLeftColor" to "#dcdfe6", "backgroundColor" to "#f5f7fa")), "scroll-content" to _pS(_uM("height" to 120, "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#37b4ea", "borderRightColor" to "#37b4ea", "borderBottomColor" to "#37b4ea", "borderLeftColor" to "#37b4ea", "justifyContent" to "center", "alignItems" to "center")), "scroll-text" to _pS(_uM("lineHeight" to "30px", "fontSize" to 14, "color" to "#606266")), "snapshot-test-component" to _pS(_uM("marginTop" to 15)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
