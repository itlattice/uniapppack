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
import io.dcloud.uniapp.extapi.saveVideoToPhotosAlbum as uni_saveVideoToPhotosAlbum
import io.dcloud.uniapp.extapi.showModal as uni_showModal
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesAPISaveVideoToPhotosAlbumSaveVideoToPhotosAlbum : BasePage {
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
    open var testState: TestStateType__4
        get() {
            return unref(this.`$exposed`["testState"]) as TestStateType__4
        }
        set(value) {
            setRefValue(this.`$exposed`, "testState", value)
        }
    open var saveVideo: () -> Unit
        get() {
            return unref(this.`$exposed`["saveVideo"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "saveVideo", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPISaveVideoToPhotosAlbumSaveVideoToPhotosAlbum, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPISaveVideoToPhotosAlbumSaveVideoToPhotosAlbum
            val _cache = __ins.renderCache
            val title = ref("saveVideoToPhotosAlbum")
            val src = ref("/static/test-video/10second-demo.mp4")
            val testState = reactive(TestStateType__4(success = false))
            val saveVideo = fun(){
                uni_saveVideoToPhotosAlbum(SaveVideoToPhotosAlbumOptions(filePath = src.value, success = fun(_){
                    console.log("saveVideoToPhotosAlbum success")
                    uni_showToast(ShowToastOptions(position = "center", icon = "none", title = "视频保存成功，请到手机相册查看"))
                    testState.success = true
                }
                , fail = fun(err){
                    uni_showModal(ShowModalOptions(title = "保存视频到相册失败", content = JSON.stringify(err), showCancel = false))
                    testState.success = false
                }
                ))
            }
            __expose(_uM("testState" to testState, "saveVideo" to saveVideo))
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cV(_component_page_head, _uM("title" to unref(title)), null, 8, _uA(
                        "title"
                    )),
                    _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                        _cE("video", _uM("class" to "video", "src" to unref(src), "controls" to true), null, 8, _uA(
                            "src"
                        )),
                        _cE("button", _uM("type" to "primary", "class" to "margin-top-10", "onClick" to saveVideo), "将视频保存到手机相册")
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
                return _uM("video" to _pS(_uM("alignSelf" to "center")), "margin-top-10" to _pS(_uM("marginTop" to 10)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
