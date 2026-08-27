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
import io.dcloud.uniapp.extapi.getSystemSetting as uni_getSystemSetting
open class GenPagesAPIGetSystemSettingGetSystemSetting : BasePage {
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
        var setup: (__props: GenPagesAPIGetSystemSettingGetSystemSetting) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIGetSystemSettingGetSystemSetting
            val _cache = __ins.renderCache
            val title = ref("getSystemSetting")
            val data = reactive(DataType__83(bluetoothEnabled = "", locationEnabled = "", wifiEnabled = "", deviceOrientation = ""))
            val getSystemSetting = fun(){
                val res = uni_getSystemSetting()
                data.bluetoothEnabled = if ((res.bluetoothEnabled ?: false)) {
                    "开启"
                } else {
                    "关闭"
                }
                data.locationEnabled = if (res.locationEnabled) {
                    "开启"
                } else {
                    "关闭"
                }
                data.wifiEnabled = if ((res.wifiEnabled ?: false)) {
                    "开启"
                } else {
                    "关闭"
                }
                data.deviceOrientation = res.deviceOrientation
                if (res.bluetoothError != null) {
                    data.bluetoothEnabled = "无蓝牙权限"
                }
                if (res.wifiError != null) {
                    data.wifiEnabled = "无WiFi权限"
                }
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
                                    _cE("view", _uM("class" to "uni-label", "style" to _nS(_uM("width" to "180px"))), "蓝牙的系统开关", 4)
                                )),
                                _cE("view", _uM("class" to "uni-list-cell-db"), _uA(
                                    _cE("input", _uM("type" to "text", "disabled" to true, "placeholder" to "未获取", "value" to unref(data).bluetoothEnabled), null, 8, _uA(
                                        "value"
                                    ))
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-list-cell"), _uA(
                                _cE("view", _uM("class" to "uni-pd"), _uA(
                                    _cE("view", _uM("class" to "uni-label", "style" to _nS(_uM("width" to "180px"))), "地理位置的系统开关", 4)
                                )),
                                _cE("view", _uM("class" to "uni-list-cell-db"), _uA(
                                    _cE("input", _uM("type" to "text", "disabled" to true, "placeholder" to "未获取", "value" to unref(data).locationEnabled), null, 8, _uA(
                                        "value"
                                    ))
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-list-cell"), _uA(
                                _cE("view", _uM("class" to "uni-pd"), _uA(
                                    _cE("view", _uM("class" to "uni-label", "style" to _nS(_uM("width" to "180px"))), "Wi-Fi 的系统开关", 4)
                                )),
                                _cE("view", _uM("class" to "uni-list-cell-db"), _uA(
                                    _cE("input", _uM("type" to "text", "disabled" to true, "placeholder" to "未获取", "value" to unref(data).wifiEnabled), null, 8, _uA(
                                        "value"
                                    ))
                                ))
                            )),
                            _cE("view", _uM("class" to "uni-list-cell"), _uA(
                                _cE("view", _uM("class" to "uni-pd"), _uA(
                                    _cE("view", _uM("class" to "uni-label", "style" to _nS(_uM("width" to "180px"))), "设备方向", 4)
                                )),
                                _cE("view", _uM("class" to "uni-list-cell-db"), _uA(
                                    _cE("input", _uM("type" to "text", "disabled" to true, "placeholder" to "未获取", "value" to unref(data).deviceOrientation), null, 8, _uA(
                                        "value"
                                    ))
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                            _cE("view", _uM("class" to "uni-btn-v"), _uA(
                                _cE("button", _uM("type" to "primary", "onClick" to getSystemSetting), "获取系统设置")
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
