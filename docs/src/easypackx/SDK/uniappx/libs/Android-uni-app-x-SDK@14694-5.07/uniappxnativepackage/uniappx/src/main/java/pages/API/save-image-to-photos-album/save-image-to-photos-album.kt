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
import io.dcloud.uniapp.extapi.saveImageToPhotosAlbum as uni_saveImageToPhotosAlbum
import io.dcloud.uniapp.extapi.showModal as uni_showModal
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesAPISaveImageToPhotosAlbumSaveImageToPhotosAlbum : BasePage {
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
    open var testState: TestStateType__3
        get() {
            return unref(this.`$exposed`["testState"]) as TestStateType__3
        }
        set(value) {
            setRefValue(this.`$exposed`, "testState", value)
        }
    open var saveImage: () -> Unit
        get() {
            return unref(this.`$exposed`["saveImage"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "saveImage", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPISaveImageToPhotosAlbumSaveImageToPhotosAlbum, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPISaveImageToPhotosAlbumSaveImageToPhotosAlbum
            val _cache = __ins.renderCache
            val title = ref("saveImageToPhotosAlbum")
            val testState = reactive(TestStateType__3(success = false))
            val saveImage = fun(){
                uni_saveImageToPhotosAlbum(SaveImageToPhotosAlbumOptions(filePath = "/static/test-image/logo.png", success = fun(res){
                    console.log("saveImageToPhotosAlbum success", JSON.stringify(res))
                    uni_showToast(ShowToastOptions(position = "center", icon = "none", title = "图片保存成功，请到手机相册查看"))
                    testState.success = true
                }
                , fail = fun(err){
                    uni_showModal(ShowModalOptions(title = "保存图片到相册失败", content = JSON.stringify(err), showCancel = false))
                    testState.success = false
                }
                ))
            }
            __expose(_uM("testState" to testState, "saveImage" to saveImage))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cV(_component_page_head, _uM("title" to unref(title)), null, 8, _uA(
                        "title"
                    )),
                    _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                        _cE("image", _uM("class" to "image", "src" to "/static/test-image/logo.png")),
                        _cE("button", _uM("class" to "margin-top-10", "type" to "primary", "onClick" to saveImage), "将图片保存到手机相册")
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
                return _uM("margin-top-10" to _pS(_uM("marginTop" to 10)), "image" to _pS(_uM("width" to 196, "height" to 196, "alignSelf" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
