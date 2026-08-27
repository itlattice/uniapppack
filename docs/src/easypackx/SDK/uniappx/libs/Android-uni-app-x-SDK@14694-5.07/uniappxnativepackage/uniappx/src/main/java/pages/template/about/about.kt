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
import io.dcloud.uniapp.extapi.getAppBaseInfo as uni_getAppBaseInfo
import uts.sdk.modules.utsOpenSchema.openSchema
open class GenPagesTemplateAboutAbout : BasePage {
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
        var setup: (__props: GenPagesTemplateAboutAbout) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesTemplateAboutAbout
            val _cache = __ins.renderCache
            val version = ref("")
            val arrowRightIcon = "/static/icons/arrow-right.png"
            val isDarkMode = computed(fun(): Boolean {
                return state.isDarkMode
            }
            )
            fun gen_openUrl_fn(url: String) {
                openSchema(url)
            }
            val openUrl = ::gen_openUrl_fn
            onLoad(fun(_options){
                version.value = uni_getAppBaseInfo(null).appVersion ?: ""
            }
            )
            return fun(): Any? {
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1")), "class" to _nC(if (unref(isDarkMode)) {
                    "theme-dark"
                } else {
                    "theme-light"
                }
                )), _uA(
                    _cE("view", _uM("class" to "content"), _uA(
                        _cE("image", _uM("class" to "qrcode", "src" to "https://web-ext-storage.dcloud.net.cn/uni-app-x/hello-uniappx-qrcode.png")),
                        _cE("text", _uM("class" to "tip"), "扫码体验 uni-app x"),
                        _cE("text", _uM("class" to "desc"), _uA(
                            _cE("text", _uM("class" to "code"), "uni-app x "),
                            _cE("text", _uM("class" to "desc"), "是下一代uni-app，基于uts的、兼容vue语法的跨平台开发框架。")
                        )),
                        _cE("text", _uM("class" to "source desc"), "本应用源码获取方式："),
                        _cE("view", _uM("class" to "sourcelist"), _uA(
                            _cE("text", _uM("class" to "desc"), "1. "),
                            _cE("text", _uM("class" to "desc"), _uA(
                                _cE("text", _uM("class" to "desc"), "在 HBuilderX 中新建 uni-app 项目时选择 "),
                                _cE("text", _uM("class" to "code"), "Hello uni-app x"),
                                _cE("text", _uM("class" to "desc"), " 模板")
                            ))
                        )),
                        _cE("view", _uM("class" to "sourcelist"), _uA(
                            _cE("text", _uM("class" to "desc"), "2. "),
                            _cE("text", _uM("class" to "desc link", "onClick" to fun(){
                                openUrl("https://gitcode.com/dcloud/hello-uni-app-x")
                            }
                            ), "https://gitcode.com/dcloud/hello-uni-app-x", 8, _uA(
                                "onClick"
                            ))
                        ))
                    )),
                    _cE("view", _uM("class" to "panel"), _uA(
                        _cE("text", _uM("class" to "uni-panel-text title"), "服务协议"),
                        _cE("view", _uM("class" to "item"), _uA(
                            _cE("view", _uM("style" to _nS(_uM("padding-left" to "18px", "border-top-style" to "none")), "class" to "uni-navigate-item", "hover-class" to "is--active", "onClick" to fun(){
                                openUrl("https://dcloud.io/license/DCloud.html")
                            }
                            ), _uA(
                                _cE("text", _uM("class" to "uni-navigate-text"), "用户协议"),
                                _cE("image", _uM("src" to arrowRightIcon, "class" to "uni-icon-size"))
                            ), 12, _uA(
                                "onClick"
                            )),
                            _cE("view", _uM("style" to _nS(_uM("padding-left" to "18px")), "class" to "uni-navigate-item", "hover-class" to "is--active", "onClick" to fun(){
                                openUrl("https://dcloud.io/license/hello-uni-app-x.html")
                            }
                            ), _uA(
                                _cE("text", _uM("class" to "uni-navigate-text"), "隐私政策"),
                                _cE("image", _uM("src" to arrowRightIcon, "class" to "uni-icon-size"))
                            ), 12, _uA(
                                "onClick"
                            ))
                        ))
                    )),
                    _cE("text", _uM("class" to "version"), "当前版本：" + _tD(unref(version)), 1)
                ), 6)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("content" to _pS(_uM("width" to "100%", "paddingTop" to 16, "paddingRight" to 16, "paddingBottom" to 16, "paddingLeft" to 16, "alignItems" to "center")), "qrcode" to _pS(_uM("width" to 160, "height" to 160)), "tip" to _pS(_uM("marginTop" to 12, "marginRight" to 12, "marginBottom" to 12, "marginLeft" to 12, "fontSize" to 14, "color" to "var(--text-color)")), "desc" to _pS(_uM("fontSize" to 14, "lineHeight" to "18px", "color" to "var(--text-color)")), "code" to _pS(_uM("fontSize" to 14, "color" to "#e96900")), "source" to _pS(_uM("alignSelf" to "flex-start", "marginTop" to 18, "color" to "var(--text-color)")), "sourcelist" to _pS(_uM("flexDirection" to "row", "alignSelf" to "flex-start", "alignContent" to "flex-start")), "link" to _pS(_uM("color" to "#007AFF", "textDecorationLine" to "underline")), "version" to _pS(_uM("width" to "100%", "marginTop" to 18, "marginRight" to 0, "marginBottom" to 18, "marginLeft" to 0, "fontSize" to 14, "lineHeight" to "18px", "textAlign" to "center", "color" to "#cccccc")), "panel" to _pS(_uM("marginTop" to 18, "marginRight" to 18, "marginBottom" to 18, "marginLeft" to 18)), "title" to _pS(_uM("marginTop" to 8, "marginRight" to 8, "marginBottom" to 8, "marginLeft" to 8, "fontSize" to 14)), "item" to _pS(_uM("borderTopLeftRadius" to 6, "borderTopRightRadius" to 6, "borderBottomRightRadius" to 6, "borderBottomLeftRadius" to 6)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
