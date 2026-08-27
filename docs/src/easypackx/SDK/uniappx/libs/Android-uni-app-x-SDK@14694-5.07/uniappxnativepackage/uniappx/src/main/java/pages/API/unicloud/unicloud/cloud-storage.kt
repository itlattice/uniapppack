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
import io.dcloud.uniapp.extapi.hideLoading as uni_hideLoading
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading
import io.dcloud.uniapp.extapi.showModal as uni_showModal
open class GenPagesAPIUnicloudUnicloudCloudStorage : BasePage {
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
        var setup: (__props: GenPagesAPIUnicloudUnicloudCloudStorage) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIUnicloudUnicloudCloudStorage
            val _cache = __ins.renderCache
            val title = ref("云存储")
            fun gen_uploadFile_fn() {
                uni_chooseImage(ChooseImageOptions(count = 1, success = fun(res): Unit {
                    uni_showLoading(ShowLoadingOptions(title = "上传中..."))
                    val tempFilePath = res.tempFilePaths[0]
                    uniCloud.uploadFile(UniCloudUploadFileOptions(filePath = tempFilePath, cloudPath = "test.jpg")).then(fun(res) {
                        uni_hideLoading(null)
                        console.log(res)
                        uni_showModal(ShowModalOptions(content = "上传成功", showCancel = false))
                    }
                    ).`catch`(fun(err: Any?) {
                        uni_hideLoading(null)
                        val error = err as UniCloudError
                        uni_showModal(ShowModalOptions(content = "上传失败，" + error.errMsg, showCancel = false))
                    }
                    )
                }
                , fail = fun(err): Unit {
                    console.error("chooseImage fail: ", err)
                }
                ))
            }
            val uploadFile = ::gen_uploadFile_fn
            fun gen_chooseAndUploadFile_fn() {
                uniCloud.chooseAndUploadFile(UniCloudChooseAndUploadFileOptions(type = "image")).then(fun(res) {
                    uni_hideLoading(null)
                    console.log(res)
                    uni_showModal(ShowModalOptions(content = "上传成功", showCancel = false))
                }
                ).`catch`(fun(err: Any?) {
                    uni_hideLoading(null)
                    val error = err as UniCloudError
                    uni_showModal(ShowModalOptions(content = "上传失败，" + error.errMsg, showCancel = false))
                }
                )
            }
            val chooseAndUploadFile = ::gen_chooseAndUploadFile_fn
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE("scroll-view", _uM("class" to "page-scroll-view"), _uA(
                    _cE("view", null, _uA(
                        _cV(_component_page_head, _uM("title" to unref(title)), null, 8, _uA(
                            "title"
                        )),
                        _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt"), _uA(
                            _cE("view", _uM("class" to "uni-btn-v uni-common-mt"), _uA(
                                _cE("button", _uM("type" to "primary", "onClick" to uploadFile), "选择文件上传"),
                                _cE("button", _uM("type" to "primary", "onClick" to chooseAndUploadFile), "一个接口选择文件并上传")
                            ))
                        ))
                    ))
                ))
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
