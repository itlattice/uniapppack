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
import io.dcloud.uniapp.extapi.getAppAuthorizeSetting as uni_getAppAuthorizeSetting
open class GenPagesAPIGetAppAuthorizeSettingGetAppAuthorizeSetting : BasePage {
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
        var setup: (__props: GenPagesAPIGetAppAuthorizeSettingGetAppAuthorizeSetting) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIGetAppAuthorizeSettingGetAppAuthorizeSetting
            val _cache = __ins.renderCache
            val title = ref("getAppAuthorizeSetting")
            val data = reactive(DataType__87(cameraAuthorized = "", albumAuthorized = "", locationAuthorized = "", locationAccuracy = "", microphoneAuthorized = "", bluetoothAuthorized = "", notificationAuthorized = "", notificationAlertAuthorized = "", notificationBadgeAuthorized = "", notificationSoundAuthorized = ""))
            val getAppAuthorizeSetting = fun(){
                val res = uni_getAppAuthorizeSetting()
                data.albumAuthorized = res.albumAuthorized
                data.bluetoothAuthorized = res.bluetoothAuthorized
                data.cameraAuthorized = res.cameraAuthorized
                data.locationAuthorized = res.locationAuthorized
                data.locationAccuracy = res.locationAccuracy ?: "unsupported"
                data.microphoneAuthorized = res.microphoneAuthorized
                data.notificationAuthorized = res.notificationAuthorized
            }
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE(Fragment, null, _uA(
                    _cV(_component_page_head, _uM("title" to unref(title)), null, 8, _uA(
                        "title"
                    )),
                    _cE("view", _uM("class" to "uni-common-mt"), _uA(
                        _cE("view", _uM("class" to "uni-list"), _uA(
                            _cE("view", _uM("class" to "uni-list-cell"), _uA(
                                _cE("view", _uM("class" to "uni-pd"), _uA(
                                    _cE("view", _uM("class" to "uni-label", "style" to _nS(_uM("width" to "180px"))), "是否授权使用相册", 4)
                                )),
                                _cE("view", _uM("class" to "uni-list-cell-db"), _uA(
                                    _cE("input", _uM("type" to "text", "disabled" to true, "placeholder" to "未获取", "value" to unref(data).albumAuthorized), null, 8, _uA(
                                        "value"
                                    ))
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-list-cell"), _uA(
                                _cE("view", _uM("class" to "uni-pd"), _uA(
                                    _cE("view", _uM("class" to "uni-label", "style" to _nS(_uM("width" to "180px"))), "是否授权使用蓝牙", 4)
                                )),
                                _cE("view", _uM("class" to "uni-list-cell-db"), _uA(
                                    _cE("input", _uM("type" to "text", "disabled" to true, "placeholder" to "未获取", "value" to unref(data).bluetoothAuthorized), null, 8, _uA(
                                        "value"
                                    ))
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-list-cell"), _uA(
                                _cE("view", _uM("class" to "uni-pd"), _uA(
                                    _cE("view", _uM("class" to "uni-label", "style" to _nS(_uM("width" to "180px"))), "是否授权使用摄像头", 4)
                                )),
                                _cE("view", _uM("class" to "uni-list-cell-db"), _uA(
                                    _cE("input", _uM("type" to "text", "disabled" to true, "placeholder" to "未获取", "value" to unref(data).cameraAuthorized), null, 8, _uA(
                                        "value"
                                    ))
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-list-cell"), _uA(
                                _cE("view", _uM("class" to "uni-pd"), _uA(
                                    _cE("view", _uM("class" to "uni-label", "style" to _nS(_uM("width" to "180px"))), "是否授权使用定位", 4)
                                )),
                                _cE("view", _uM("class" to "uni-list-cell-db"), _uA(
                                    _cE("input", _uM("type" to "text", "disabled" to true, "placeholder" to "未获取", "value" to unref(data).locationAuthorized), null, 8, _uA(
                                        "value"
                                    ))
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-list-cell"), _uA(
                                _cE("view", _uM("class" to "uni-pd"), _uA(
                                    _cE("view", _uM("class" to "uni-label", "style" to _nS(_uM("width" to "180px"))), "定位准确度", 4)
                                )),
                                _cE("view", _uM("class" to "uni-list-cell-db"), _uA(
                                    _cE("input", _uM("type" to "text", "disabled" to true, "placeholder" to "未获取", "value" to unref(data).locationAccuracy), null, 8, _uA(
                                        "value"
                                    ))
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-list-cell"), _uA(
                                _cE("view", _uM("class" to "uni-pd"), _uA(
                                    _cE("view", _uM("class" to "uni-label", "style" to _nS(_uM("width" to "180px"))), "是否授权使用麦克风", 4)
                                )),
                                _cE("view", _uM("class" to "uni-list-cell-db"), _uA(
                                    _cE("input", _uM("type" to "text", "disabled" to true, "placeholder" to "未获取", "value" to unref(data).microphoneAuthorized), null, 8, _uA(
                                        "value"
                                    ))
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-list-cell"), _uA(
                                _cE("view", _uM("class" to "uni-pd"), _uA(
                                    _cE("view", _uM("class" to "uni-label", "style" to _nS(_uM("width" to "180px"))), "是否授权通知", 4)
                                )),
                                _cE("view", _uM("class" to "uni-list-cell-db"), _uA(
                                    _cE("input", _uM("type" to "text", "disabled" to true, "placeholder" to "未获取", "value" to unref(data).notificationAuthorized), null, 8, _uA(
                                        "value"
                                    ))
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                            _cE("view", _uM("class" to "uni-btn-v"), _uA(
                                _cE("button", _uM("type" to "primary", "onClick" to getAppAuthorizeSetting), "获取App授权设置")
                            ))
                        ))
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
                return _uM("uni-pd" to _pS(_uM("paddingLeft" to 15)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
