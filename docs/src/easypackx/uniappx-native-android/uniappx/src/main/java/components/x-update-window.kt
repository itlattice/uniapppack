@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNI2971F61
import android.content.Context
import io.dcloud.uniapp.*
import io.dcloud.uniapp.extapi.*
import io.dcloud.uniapp.framework.*
import io.dcloud.uniapp.runtime.*
import io.dcloud.uniapp.vue.*
import io.dcloud.uniapp.vue.shared.*
import io.dcloud.uts.*
import io.dcloud.uts.Map
import io.dcloud.uts.Set
import io.dcloud.uts.UTSAndroid
import kotlin.properties.Delegates
import uts.sdk.modules.iboxsChooseMedia.MediaScanner
import io.dcloud.uniapp.extapi.downloadFile as uni_downloadFile
import io.dcloud.uniapp.extapi.installApk as uni_installApk
open class GenComponentsXUpdateWindow : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var info: UTSJSONObject by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    open var show: () -> Unit
        get() {
            return unref(this.`$exposed`["show"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "show", value)
        }
    open var close: () -> Unit
        get() {
            return unref(this.`$exposed`["close"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "close", value)
        }
    open var startUpdateClick: () -> Unit
        get() {
            return unref(this.`$exposed`["startUpdateClick"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "startUpdateClick", value)
        }
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXUpdateWindow, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXUpdateWindow
            val _cache = __ins.renderCache
            val props = __props
            val showWindow = ref(false)
            val startUpdate = ref(false)
            val process = ref(0)
            val show = fun(){
                showWindow.value = true
            }
            val close = fun(){
                showWindow.value = false
            }
            val startUpdateClick = fun(){
                var url = props.info["url"] as String
                var task = uni_downloadFile(DownloadFileOptions(url = url, success = fun(suc: DownloadFileSuccess){
                    process.value = 100
                    var file = suc.tempFilePath
                    uni_installApk(InstallApkOptions(filePath = file))
                    showWindow.value = false
                }
                ))
                task.onProgressUpdate(fun(r: OnProgressDownloadResult){
                    process.value = r.progress
                }
                )
                startUpdate.value = true
            }
            __expose(_uM("show" to show, "close" to close, "startUpdateClick" to startUpdateClick))
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_tmx_progress = resolveEasyComponent("tmx-progress", GenUniModulesTmxUiComponentsTmxProgressTmxProgressClass)
                val _component_tmx_drawer = resolveEasyComponent("tmx-drawer", GenUniModulesTmxUiComponentsTmxDrawerTmxDrawerClass)
                return _cV(_component_tmx_drawer, _uM("size" to "auto", "showTitle" to false, "showClose" to false, "show" to unref(showWindow), "position" to "bottom"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "position-relative updatewindow"), _uA(
                            _cE("view", _uM("class" to "close", "onClick" to close), _uA(
                                _cV(_component_x_iconfont, _uM("name" to "guanbiyemian", "color" to "#666", "size" to "18"))
                            )),
                            _cE("text", _uM("class" to "content"), "APP有更新"),
                            if (unref(startUpdate) == false) {
                                _cE("view", _uM("key" to 0, "class" to "showcontent"), _uA(
                                    _cE("text", _uM("class" to "viewcontent"), "最新版本" + _tD(_ctx.info["version"]) + "，请尽快更新", 1),
                                    _cE("button", _uM("class" to "startupdate", "hover-class" to "none", "onClick" to startUpdateClick), "启动更新")
                                ))
                            } else {
                                _cE("view", _uM("key" to 1, "class" to "startdownload"), _uA(
                                    _cV(_component_tmx_progress, _uM("class" to "progress", "modelValue" to unref(process), "onUpdate:modelValue" to fun(`$event`: Number){
                                        trySetRefValue(process, `$event`)
                                    }
                                    , "size" to "18", "show-label" to true), null, 8, _uA(
                                        "modelValue"
                                    ))
                                ))
                            }
                        ))
                    )
                }
                ), "_" to 1), 8, _uA(
                    "show"
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
                return _uM("updatewindow" to _pS(_uM("height" to 160, "width" to "750rpx", "position" to "relative")), "close" to _uM(".updatewindow " to _uM("position" to "absolute", "right" to 40, "top" to 10)), "content" to _uM(".updatewindow " to _uM("paddingTop" to 10, "textAlign" to "center", "fontSize" to 15)), "viewcontent" to _uM(".updatewindow .showcontent " to _uM("textAlign" to "center", "fontSize" to 16, "color" to "#ff0000", "paddingTop" to 30)), "startupdate" to _uM(".updatewindow .showcontent " to _uM("marginTop" to 30, "width" to "690rpx", "height" to 40, "backgroundColor" to "#fe548b", "color" to "#FFFFFF", "borderTopLeftRadius" to 20, "borderTopRightRadius" to 20, "borderBottomRightRadius" to 20, "borderBottomLeftRadius" to 20)), "startdownload" to _uM(".updatewindow " to _uM("width" to "680rpx", "paddingTop" to 30)), "progress" to _uM(".updatewindow .startdownload " to _uM("width" to "680rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("info" to _uM("type" to "UTSJSONObject", "default" to _uO())))
        var propsNeedCastKeys = _uA(
            "info"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
