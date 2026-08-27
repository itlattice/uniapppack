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
open class GenPagesAPIElementGetBoundingClientRectAsyncElementGetBoundingClientRectAsync : BasePage {
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
    open var data: DataType__84
        get() {
            return unref(this.`$exposed`["data"]) as DataType__84
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var syncData: SyncDataType
        get() {
            return unref(this.`$exposed`["syncData"]) as SyncDataType
        }
        set(value) {
            setRefValue(this.`$exposed`, "syncData", value)
        }
    open var getBoundingClientRectAsync: () -> Unit
        get() {
            return unref(this.`$exposed`["getBoundingClientRectAsync"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "getBoundingClientRectAsync", value)
        }
    open var getViewRect: () -> Unit
        get() {
            return unref(this.`$exposed`["getViewRect"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "getViewRect", value)
        }
    open var getTextRect: () -> Unit
        get() {
            return unref(this.`$exposed`["getTextRect"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "getTextRect", value)
        }
    open var getImageRect: () -> Unit
        get() {
            return unref(this.`$exposed`["getImageRect"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "getImageRect", value)
        }
    open var getViewRectFlat: () -> Unit
        get() {
            return unref(this.`$exposed`["getViewRectFlat"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "getViewRectFlat", value)
        }
    open var getTextRectFlat: () -> Unit
        get() {
            return unref(this.`$exposed`["getTextRectFlat"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "getTextRectFlat", value)
        }
    open var getImageRectFlat: () -> Unit
        get() {
            return unref(this.`$exposed`["getImageRectFlat"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "getImageRectFlat", value)
        }
    open var getScrollViewRect: () -> Unit
        get() {
            return unref(this.`$exposed`["getScrollViewRect"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "getScrollViewRect", value)
        }
    open var getCustomComponentRect: () -> Unit
        get() {
            return unref(this.`$exposed`["getCustomComponentRect"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "getCustomComponentRect", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIElementGetBoundingClientRectAsyncElementGetBoundingClientRectAsync, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIElementGetBoundingClientRectAsyncElementGetBoundingClientRectAsync
            val _cache = __ins.renderCache
            val title = ref("getBoundingClientRectAsync")
            val rectTest = ref<UniElement?>(null)
            val data = reactive(DataType__84(rectInfo = DomRectType(x = 0, y = 0, width = 0, height = 0, left = 0, top = 0, right = 0, bottom = 0)))
            val syncData = reactive(SyncDataType(viewRectInfo = null, textRectInfo = null, imageRectInfo = null, viewRectInfoFlat = null, textRectInfoFlat = null, imageRectInfoFlat = null, scrollViewRectInfo = null, customComponentRectInfo = null))
            fun gen_getBoundingClientRectAsync_fn() {
                if (rectTest.value != null) {
                    rectTest.value!!.getBoundingClientRectAsync()!!.then(fun(rect: DOMRect){
                        data.rectInfo = DomRectType(x = rect.x, y = rect.y, width = rect.width, height = rect.height, left = rect.left, top = rect.top, right = rect.right, bottom = rect.bottom)
                    }
                    )
                }
            }
            val getBoundingClientRectAsync = ::gen_getBoundingClientRectAsync_fn
            fun gen_getRectInfo_fn(elementId: String, dataKey: String) {
                val element = uni_getElementById(elementId)!!
                val rect = element.getBoundingClientRect()
                syncData[dataKey] = DomRectType(x = rect.x, y = rect.y, width = rect.width, height = rect.height, left = rect.left, top = rect.top, right = rect.right, bottom = rect.bottom)
            }
            val getRectInfo = ::gen_getRectInfo_fn
            fun gen_getViewRect_fn() {
                getRectInfo("rect-test-view", "viewRectInfo")
            }
            val getViewRect = ::gen_getViewRect_fn
            fun gen_getTextRect_fn() {
                getRectInfo("rect-test-text", "textRectInfo")
            }
            val getTextRect = ::gen_getTextRect_fn
            fun gen_getImageRect_fn() {
                getRectInfo("rect-test-image", "imageRectInfo")
            }
            val getImageRect = ::gen_getImageRect_fn
            fun gen_getViewRectFlat_fn() {
                getRectInfo("rect-test-view-flat", "viewRectInfoFlat")
            }
            val getViewRectFlat = ::gen_getViewRectFlat_fn
            fun gen_getTextRectFlat_fn() {
                getRectInfo("rect-test-text-flat", "textRectInfoFlat")
            }
            val getTextRectFlat = ::gen_getTextRectFlat_fn
            fun gen_getImageRectFlat_fn() {
                getRectInfo("rect-test-image-flat", "imageRectInfoFlat")
            }
            val getImageRectFlat = ::gen_getImageRectFlat_fn
            fun gen_getScrollViewRect_fn() {
                getRectInfo("rect-test-scrollview", "scrollViewRectInfo")
            }
            val getScrollViewRect = ::gen_getScrollViewRect_fn
            fun gen_getCustomComponentRect_fn() {
                getRectInfo("rect-test-component", "customComponentRectInfo")
            }
            val getCustomComponentRect = ::gen_getCustomComponentRect_fn
            __expose(_uM("data" to data, "syncData" to syncData, "getBoundingClientRectAsync" to getBoundingClientRectAsync, "getViewRect" to getViewRect, "getTextRect" to getTextRect, "getImageRect" to getImageRect, "getViewRectFlat" to getViewRectFlat, "getTextRectFlat" to getTextRectFlat, "getImageRectFlat" to getImageRectFlat, "getScrollViewRect" to getScrollViewRect, "getCustomComponentRect" to getCustomComponentRect))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                val _component_page_intro = resolveEasyComponent("page-intro", GenComponentsPageIntroPageIntroClass)
                return _cE("scroll-view", _uM("class" to "page-scroll-view"), _uA(
                    _cE("view", _uM("class" to "page", "id" to "page"), _uA(
                        _cV(_component_page_head, _uM("title" to unref(title)), null, 8, _uA(
                            "title"
                        )),
                        _cV(_component_page_intro, _uM("content" to "本页演示元素获取布局矩形：getBoundingClientRectAsync 异步接口与 getBoundingClientRect 同步方法，返回 x、y、width、height、left、top、right、bottom；对 view、text、image、scroll-view 等组件分别测试，并含拍平（flatten）对比。")),
                        _cE("button", _uM("class" to "uni-common-mt", "onClick" to getBoundingClientRectAsync), "getBoundingClientRectAsync"),
                        _cE("view", _uM("id" to "rect-test", "ref_key" to "rectTest", "ref" to rectTest, "class" to "rect-test"), null, 512),
                        if (unref(data).rectInfo != null) {
                            _cE("view", _uM("key" to 0, "class" to "rect-info"), _uA(
                                _cE("view", _uM("class" to "node-info-item"), _uA(
                                    _cE("text", _uM("class" to "node-info-item-k"), "x: "),
                                    _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(data).rectInfo!!.x), 1)
                                )),
                                _cE("view", _uM("class" to "node-info-item"), _uA(
                                    _cE("text", _uM("class" to "node-info-item-k"), "y: "),
                                    _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(data).rectInfo!!.y), 1)
                                )),
                                _cE("view", _uM("class" to "node-info-item"), _uA(
                                    _cE("text", _uM("class" to "node-info-item-k"), "width: "),
                                    _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(data).rectInfo!!.width), 1)
                                )),
                                _cE("view", _uM("class" to "node-info-item"), _uA(
                                    _cE("text", _uM("class" to "node-info-item-k"), "height: "),
                                    _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(data).rectInfo!!.height), 1)
                                )),
                                _cE("view", _uM("class" to "node-info-item"), _uA(
                                    _cE("text", _uM("class" to "node-info-item-k"), "left: "),
                                    _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(data).rectInfo!!.left), 1)
                                )),
                                _cE("view", _uM("class" to "node-info-item"), _uA(
                                    _cE("text", _uM("class" to "node-info-item-k"), "top: "),
                                    _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(data).rectInfo!!.top), 1)
                                )),
                                _cE("view", _uM("class" to "node-info-item"), _uA(
                                    _cE("text", _uM("class" to "node-info-item-k"), "right: "),
                                    _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(data).rectInfo!!.right), 1)
                                )),
                                _cE("view", _uM("class" to "node-info-item"), _uA(
                                    _cE("text", _uM("class" to "node-info-item-k"), "bottom: "),
                                    _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(data).rectInfo!!.bottom), 1)
                                ))
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        _cE("view", _uM("class" to "section-divider")),
                        _cE("text", _uM("class" to "section-title"), "getBoundingClientRect 方法测试"),
                        _cE("view", _uM("class" to "test-group"), _uA(
                            _cE("view", _uM("class" to "test-buttons"), _uA(
                                _cE("button", _uM("class" to "btn-small", "type" to "default", "onClick" to getViewRect), "View"),
                                _cE("button", _uM("class" to "btn-small", "onClick" to getViewRectFlat), "View(拍平测试)")
                            )),
                            _cE("view", _uM("class" to "test-elements"), _uA(
                                _cE("view", _uM("id" to "rect-test-view", "class" to "rect-test-small")),
                                _cE("view", _uM("id" to "rect-test-view-flat", "class" to "rect-test-small", "flatten" to ""))
                            ))
                        )),
                        if (isTrue(unref(syncData).viewRectInfo != null || unref(syncData).viewRectInfoFlat != null)) {
                            _cE("view", _uM("key" to 1, "class" to "rect-row"), _uA(
                                if (unref(syncData).viewRectInfo != null) {
                                    _cE("view", _uM("key" to 0, "class" to "rect-data-col"), _uA(
                                        _cE("text", _uM("class" to "rect-data-item"), "x: " + _tD(unref(syncData).viewRectInfo!!.x), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "y: " + _tD(unref(syncData).viewRectInfo!!.y), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "width: " + _tD(unref(syncData).viewRectInfo!!.width), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "height: " + _tD(unref(syncData).viewRectInfo!!.height), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "left: " + _tD(unref(syncData).viewRectInfo!!.left), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "top: " + _tD(unref(syncData).viewRectInfo!!.top), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "right: " + _tD(unref(syncData).viewRectInfo!!.right), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "bottom: " + _tD(unref(syncData).viewRectInfo!!.bottom), 1)
                                    ))
                                } else {
                                    _cC("v-if", true)
                                },
                                if (unref(syncData).viewRectInfoFlat != null) {
                                    _cE("view", _uM("key" to 1, "class" to "rect-data-col"), _uA(
                                        _cE("text", _uM("class" to "rect-data-item"), "x: " + _tD(unref(syncData).viewRectInfoFlat!!.x), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "y: " + _tD(unref(syncData).viewRectInfoFlat!!.y), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "width: " + _tD(unref(syncData).viewRectInfoFlat!!.width), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "height: " + _tD(unref(syncData).viewRectInfoFlat!!.height), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "left: " + _tD(unref(syncData).viewRectInfoFlat!!.left), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "top: " + _tD(unref(syncData).viewRectInfoFlat!!.top), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "right: " + _tD(unref(syncData).viewRectInfoFlat!!.right), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "bottom: " + _tD(unref(syncData).viewRectInfoFlat!!.bottom), 1)
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        _cE("view", _uM("class" to "test-group"), _uA(
                            _cE("view", _uM("class" to "test-buttons"), _uA(
                                _cE("button", _uM("class" to "btn-small", "onClick" to getTextRect), "Text"),
                                _cE("button", _uM("class" to "btn-small", "onClick" to getTextRectFlat), "Text(拍平测试)")
                            )),
                            _cE("view", _uM("class" to "test-elements"), _uA(
                                _cE("text", _uM("id" to "rect-test-text", "class" to "rect-test-text-small"), "测试文本"),
                                _cE("text", _uM("id" to "rect-test-text-flat", "class" to "rect-test-text-small", "flatten" to ""), "测试文本拍平")
                            ))
                        )),
                        if (isTrue(unref(syncData).textRectInfo != null || unref(syncData).textRectInfoFlat != null)) {
                            _cE("view", _uM("key" to 2, "class" to "rect-row"), _uA(
                                if (unref(syncData).textRectInfo != null) {
                                    _cE("view", _uM("key" to 0, "class" to "rect-data-col"), _uA(
                                        _cE("text", _uM("class" to "rect-data-item"), "x: " + _tD(unref(syncData).textRectInfo!!.x), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "y: " + _tD(unref(syncData).textRectInfo!!.y), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "width: " + _tD(unref(syncData).textRectInfo!!.width), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "height: " + _tD(unref(syncData).textRectInfo!!.height), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "left: " + _tD(unref(syncData).textRectInfo!!.left), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "top: " + _tD(unref(syncData).textRectInfo!!.top), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "right: " + _tD(unref(syncData).textRectInfo!!.right), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "bottom: " + _tD(unref(syncData).textRectInfo!!.bottom), 1)
                                    ))
                                } else {
                                    _cC("v-if", true)
                                },
                                if (unref(syncData).textRectInfoFlat != null) {
                                    _cE("view", _uM("key" to 1, "class" to "rect-data-col"), _uA(
                                        _cE("text", _uM("class" to "rect-data-item"), "x: " + _tD(unref(syncData).textRectInfoFlat!!.x), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "y: " + _tD(unref(syncData).textRectInfoFlat!!.y), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "width: " + _tD(unref(syncData).textRectInfoFlat!!.width), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "height: " + _tD(unref(syncData).textRectInfoFlat!!.height), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "left: " + _tD(unref(syncData).textRectInfoFlat!!.left), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "top: " + _tD(unref(syncData).textRectInfoFlat!!.top), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "right: " + _tD(unref(syncData).textRectInfoFlat!!.right), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "bottom: " + _tD(unref(syncData).textRectInfoFlat!!.bottom), 1)
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        _cE("view", _uM("class" to "test-group"), _uA(
                            _cE("view", _uM("class" to "test-buttons"), _uA(
                                _cE("button", _uM("class" to "btn-small", "onClick" to getImageRect), "Image"),
                                _cE("button", _uM("class" to "btn-small", "onClick" to getImageRectFlat), "Image(拍平测试)")
                            )),
                            _cE("view", _uM("class" to "test-elements"), _uA(
                                _cE("image", _uM("id" to "rect-test-image", "class" to "rect-test-image-small", "src" to "/static/test-image/logo.png", "mode" to "aspectFit")),
                                _cE("image", _uM("id" to "rect-test-image-flat", "class" to "rect-test-image-small", "src" to "/static/test-image/logo.png", "mode" to "aspectFit", "flatten" to ""))
                            ))
                        )),
                        if (isTrue(unref(syncData).imageRectInfo != null || unref(syncData).imageRectInfoFlat != null)) {
                            _cE("view", _uM("key" to 3, "class" to "rect-row"), _uA(
                                if (unref(syncData).imageRectInfo != null) {
                                    _cE("view", _uM("key" to 0, "class" to "rect-data-col"), _uA(
                                        _cE("text", _uM("class" to "rect-data-item"), "x: " + _tD(unref(syncData).imageRectInfo!!.x), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "y: " + _tD(unref(syncData).imageRectInfo!!.y), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "width: " + _tD(unref(syncData).imageRectInfo!!.width), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "height: " + _tD(unref(syncData).imageRectInfo!!.height), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "left: " + _tD(unref(syncData).imageRectInfo!!.left), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "top: " + _tD(unref(syncData).imageRectInfo!!.top), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "right: " + _tD(unref(syncData).imageRectInfo!!.right), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "bottom: " + _tD(unref(syncData).imageRectInfo!!.bottom), 1)
                                    ))
                                } else {
                                    _cC("v-if", true)
                                },
                                if (unref(syncData).imageRectInfoFlat != null) {
                                    _cE("view", _uM("key" to 1, "class" to "rect-data-col"), _uA(
                                        _cE("text", _uM("class" to "rect-data-item"), "x: " + _tD(unref(syncData).imageRectInfoFlat!!.x), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "y: " + _tD(unref(syncData).imageRectInfoFlat!!.y), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "width: " + _tD(unref(syncData).imageRectInfoFlat!!.width), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "height: " + _tD(unref(syncData).imageRectInfoFlat!!.height), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "left: " + _tD(unref(syncData).imageRectInfoFlat!!.left), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "top: " + _tD(unref(syncData).imageRectInfoFlat!!.top), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "right: " + _tD(unref(syncData).imageRectInfoFlat!!.right), 1),
                                        _cE("text", _uM("class" to "rect-data-item"), "bottom: " + _tD(unref(syncData).imageRectInfoFlat!!.bottom), 1)
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        _cE("button", _uM("class" to "uni-common-mt", "onClick" to getScrollViewRect), "getBoundingClientRect - ScrollView"),
                        _cE("scroll-view", _uM("id" to "rect-test-scrollview", "class" to "rect-test-scrollview"), _uA(
                            _cE("view", _uM("class" to "scroll-content"), _uA(
                                _cE("text", _uM("class" to "scroll-text"), "滚动区域内容1")
                            )),
                            _cE("view", _uM("class" to "scroll-content"), _uA(
                                _cE("text", _uM("class" to "scroll-text"), "滚动区域内容2")
                            )),
                            _cE("view", _uM("class" to "scroll-content"), _uA(
                                _cE("text", _uM("class" to "scroll-text"), "滚动区域内容2")
                            ))
                        )),
                        if (unref(syncData).scrollViewRectInfo != null) {
                            _cE("view", _uM("key" to 4, "class" to "rect-info"), _uA(
                                _cE("view", _uM("class" to "node-info-item"), _uA(
                                    _cE("text", _uM("class" to "node-info-item-k"), "x: "),
                                    _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(syncData).scrollViewRectInfo!!.x), 1)
                                )),
                                _cE("view", _uM("class" to "node-info-item"), _uA(
                                    _cE("text", _uM("class" to "node-info-item-k"), "y: "),
                                    _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(syncData).scrollViewRectInfo!!.y), 1)
                                )),
                                _cE("view", _uM("class" to "node-info-item"), _uA(
                                    _cE("text", _uM("class" to "node-info-item-k"), "width: "),
                                    _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(syncData).scrollViewRectInfo!!.width), 1)
                                )),
                                _cE("view", _uM("class" to "node-info-item"), _uA(
                                    _cE("text", _uM("class" to "node-info-item-k"), "height: "),
                                    _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(syncData).scrollViewRectInfo!!.height), 1)
                                )),
                                _cE("view", _uM("class" to "node-info-item"), _uA(
                                    _cE("text", _uM("class" to "node-info-item-k"), "left: "),
                                    _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(syncData).scrollViewRectInfo!!.left), 1)
                                )),
                                _cE("view", _uM("class" to "node-info-item"), _uA(
                                    _cE("text", _uM("class" to "node-info-item-k"), "top: "),
                                    _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(syncData).scrollViewRectInfo!!.top), 1)
                                )),
                                _cE("view", _uM("class" to "node-info-item"), _uA(
                                    _cE("text", _uM("class" to "node-info-item-k"), "right: "),
                                    _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(syncData).scrollViewRectInfo!!.right), 1)
                                )),
                                _cE("view", _uM("class" to "node-info-item"), _uA(
                                    _cE("text", _uM("class" to "node-info-item-k"), "bottom: "),
                                    _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(syncData).scrollViewRectInfo!!.bottom), 1)
                                ))
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        _cE("button", _uM("class" to "uni-common-mt", "onClick" to getCustomComponentRect), "getBoundingClientRect - 自定义组件"),
                        _cV(unref(GenPagesAPIElementGetBoundingClientRectAsyncChildClass), _uM("id" to "rect-test-component", "class" to "uni-common-mt")),
                        if (unref(syncData).customComponentRectInfo != null) {
                            _cE("view", _uM("key" to 5, "class" to "rect-info"), _uA(
                                _cE("view", _uM("class" to "node-info-item"), _uA(
                                    _cE("text", _uM("class" to "node-info-item-k"), "x: "),
                                    _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(syncData).customComponentRectInfo!!.x), 1)
                                )),
                                _cE("view", _uM("class" to "node-info-item"), _uA(
                                    _cE("text", _uM("class" to "node-info-item-k"), "y: "),
                                    _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(syncData).customComponentRectInfo!!.y), 1)
                                )),
                                _cE("view", _uM("class" to "node-info-item"), _uA(
                                    _cE("text", _uM("class" to "node-info-item-k"), "width: "),
                                    _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(syncData).customComponentRectInfo!!.width), 1)
                                )),
                                _cE("view", _uM("class" to "node-info-item"), _uA(
                                    _cE("text", _uM("class" to "node-info-item-k"), "height: "),
                                    _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(syncData).customComponentRectInfo!!.height), 1)
                                )),
                                _cE("view", _uM("class" to "node-info-item"), _uA(
                                    _cE("text", _uM("class" to "node-info-item-k"), "left: "),
                                    _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(syncData).customComponentRectInfo!!.left), 1)
                                )),
                                _cE("view", _uM("class" to "node-info-item"), _uA(
                                    _cE("text", _uM("class" to "node-info-item-k"), "top: "),
                                    _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(syncData).customComponentRectInfo!!.top), 1)
                                )),
                                _cE("view", _uM("class" to "node-info-item"), _uA(
                                    _cE("text", _uM("class" to "node-info-item-k"), "right: "),
                                    _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(syncData).customComponentRectInfo!!.right), 1)
                                )),
                                _cE("view", _uM("class" to "node-info-item"), _uA(
                                    _cE("text", _uM("class" to "node-info-item-k"), "bottom: "),
                                    _cE("text", _uM("class" to "node-info-item-v"), _tD(unref(syncData).customComponentRectInfo!!.bottom), 1)
                                ))
                            ))
                        } else {
                            _cC("v-if", true)
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
                return _uM("page" to _pS(_uM("paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15)), "rect-test" to _pS(_uM("marginTop" to 15, "height" to 100, "backgroundColor" to "#1E90FF")), "rect-info" to _pS(_uM("marginTop" to 15, "flexDirection" to "column")), "node-info-item" to _pS(_uM("flexDirection" to "row")), "node-info-item-k" to _pS(_uM("width" to 72, "lineHeight" to 2)), "node-info-item-v" to _pS(_uM("fontWeight" to "bold", "lineHeight" to 2)), "section-divider" to _pS(_uM("marginTop" to 30, "height" to 1, "backgroundColor" to "#e0e0e0")), "section-title" to _pS(_uM("marginTop" to 15, "fontSize" to 16, "fontWeight" to "bold", "color" to "#333333")), "test-group" to _pS(_uM("marginTop" to 20, "flexDirection" to "column")), "test-buttons" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-around", "marginBottom" to 10)), "btn-small" to _pS(_uM("paddingTop" to 5, "paddingRight" to 15, "paddingBottom" to 5, "paddingLeft" to 15, "fontSize" to 13, "borderTopLeftRadius" to 4, "borderTopRightRadius" to 4, "borderBottomRightRadius" to 4, "borderBottomLeftRadius" to 4, "flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 5, "marginBottom" to 0, "marginLeft" to 5)), "test-elements" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-around", "alignItems" to "center", "marginBottom" to 10)), "rect-test-small" to _pS(_uM("width" to "45%", "height" to 60, "backgroundColor" to "#1E90FF")), "rect-test-text-small" to _pS(_uM("width" to "45%", "paddingTop" to 8, "paddingRight" to 8, "paddingBottom" to 8, "paddingLeft" to 8, "fontSize" to 14, "color" to "#ffffff", "backgroundColor" to "#ff6b6b")), "rect-test-image-small" to _pS(_uM("width" to "45%", "height" to 60, "backgroundColor" to "#f0f0f0")), "rect-row" to _pS(_uM("flexDirection" to "row", "marginBottom" to 15, "paddingBottom" to 15, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#e4e7ed")), "rect-data-col" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "flexDirection" to "column", "marginTop" to 0, "marginRight" to 5, "marginBottom" to 0, "marginLeft" to 5)), "rect-data-item" to _pS(_uM("fontSize" to 12, "lineHeight" to 1.8, "color" to "#606266")), "rect-test-scrollview" to _pS(_uM("marginTop" to 15, "height" to 120, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#dcdfe6", "borderRightColor" to "#dcdfe6", "borderBottomColor" to "#dcdfe6", "borderLeftColor" to "#dcdfe6", "backgroundColor" to "#f5f7fa")), "scroll-content" to _pS(_uM("height" to 120, "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#37b4ea", "borderRightColor" to "#37b4ea", "borderBottomColor" to "#37b4ea", "borderLeftColor" to "#37b4ea", "justifyContent" to "center", "alignItems" to "center")), "scroll-text" to _pS(_uM("lineHeight" to "30px", "fontSize" to 14, "color" to "#606266")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
