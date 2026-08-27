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
import io.dcloud.uniapp.extapi.chooseImage as uni_chooseImage
import io.dcloud.uniapp.extapi.getImageInfo as uni_getImageInfo
import io.dcloud.uniapp.extapi.showModal as uni_showModal
open class GenPagesAPIGetImageInfoGetImageInfo : BasePage {
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
    open var testState: TestStateType
        get() {
            return unref(this.`$exposed`["testState"]) as TestStateType
        }
        set(value) {
            setRefValue(this.`$exposed`, "testState", value)
        }
    open var chooseImage: () -> Unit
        get() {
            return unref(this.`$exposed`["chooseImage"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "chooseImage", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIGetImageInfoGetImageInfo, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIGetImageInfoGetImageInfo
            val _cache = __ins.renderCache
            val title = ref("getImageInfo")
            val relativeImagePath = ref("/static/test-image/logo.png")
            val relativeImageInfo = ref("")
            val absoluteImagePath = ref("")
            val absoluteImageInfo = ref("")
            val remoteImagePath = ref("https://request.dcloud.net.cn/api/http/contentType/image/png")
            val remoteImageInfo = ref("")
            val testState = reactive(TestStateType(imageInfoForTest = null as UTSJSONObject?))
            val chooseImage = fun(){
                uni_chooseImage(ChooseImageOptions(count = 1, success = fun(res){
                    absoluteImagePath.value = res.tempFilePaths[0]
                    uni_getImageInfo(GetImageInfoOptions(src = res.tempFilePaths[0], success = fun(_res){
                        console.log("getImageInfo success", JSON.stringify(_res))
                        relativeImageInfo.value = "图片宽度: " + _res.width + "\n图片高度: " + _res.height + "\n图片路径: " + _res.path + "\n图片方向: " + _res.orientation + "\n图片格式: " + _res.type
                    }
                    , fail = fun(err){
                        uni_showModal(ShowModalOptions(title = "获取图片信息失败", content = JSON.stringify(err), showCancel = false))
                    }
                    ))
                }
                ))
            }
            onReady(fun(){
                uni_getImageInfo(GetImageInfoOptions(src = relativeImagePath.value, success = fun(res){
                    console.log("getImageInfo success", JSON.stringify(res))
                    absoluteImageInfo.value = "图片宽度: " + res.width + "\n图片高度: " + res.height + "\n图片路径: " + res.path + "\n图片方向: " + res.orientation + "\n图片格式: " + res.type
                    testState.imageInfoForTest = _uO("width" to res.width, "height" to res.height, "path" to res.path.slice(res.path.indexOf("static/") + 7), "orientation" to res.orientation, "type" to res.type)
                }
                , fail = fun(err){
                    uni_showModal(ShowModalOptions(title = "获取图片信息失败", content = JSON.stringify(err), showCancel = false))
                    testState.imageInfoForTest = null
                }
                ))
                uni_getImageInfo(GetImageInfoOptions(src = remoteImagePath.value, success = fun(res){
                    console.log("getImageInfo success", JSON.stringify(res))
                    remoteImageInfo.value = "图片宽度: " + res.width + "\n图片高度: " + res.height + "\n图片路径: " + res.path + "\n图片方向: " + res.orientation + "\n图片格式: " + res.type
                }
                , fail = fun(err){
                    uni_showModal(ShowModalOptions(title = "获取图片信息失败", content = JSON.stringify(err), showCancel = false))
                }
                ))
            }
            )
            __expose(_uM("testState" to testState, "chooseImage" to chooseImage))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cV(_component_page_head, _uM("title" to unref(title)), null, 8, _uA(
                        "title"
                    )),
                    _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                        _cE("view", _uM("class" to "uni-title"), _uA(
                            _cE("text", _uM("class" to "uni-subtitle-text"), "获取本地相对路径图片信息")
                        )),
                        _cE("image", _uM("class" to "image", "src" to unref(relativeImagePath), "mode" to "aspectFit"), null, 8, _uA(
                            "src"
                        )),
                        _cE("text", _uM("class" to "margin-top-10"), _tD(unref(absoluteImageInfo)), 1),
                        _cE("view", _uM("class" to "uni-title"), _uA(
                            _cE("text", _uM("class" to "uni-subtitle-text"), "获取网络路径图片信息")
                        )),
                        _cE("image", _uM("class" to "image", "src" to unref(remoteImagePath), "mode" to "aspectFit"), null, 8, _uA(
                            "src"
                        )),
                        _cE("text", _uM("class" to "margin-top-10"), _tD(unref(remoteImageInfo)), 1),
                        _cE("view", _uM("class" to "uni-title"), _uA(
                            _cE("text", _uM("class" to "uni-subtitle-text"), "获取本地绝对路径图片信息")
                        )),
                        _cE("image", _uM("class" to "image", "src" to unref(absoluteImagePath), "mode" to "aspectFit"), null, 8, _uA(
                            "src"
                        )),
                        _cE("text", _uM("class" to "margin-top-10"), _tD(unref(relativeImageInfo)), 1),
                        _cE("view", _uM("class" to "uni-btn-v"), _uA(
                            _cE("button", _uM("type" to "primary", "onClick" to chooseImage), "拍摄照片或从相册中选择照片")
                        ))
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
                return _uM("image" to _pS(_uM("alignSelf" to "center")), "margin-top-10" to _pS(_uM("marginTop" to 10)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
