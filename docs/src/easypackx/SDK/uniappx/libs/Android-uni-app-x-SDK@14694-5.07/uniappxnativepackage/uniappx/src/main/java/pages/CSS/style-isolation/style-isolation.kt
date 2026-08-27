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
import io.dcloud.uniapp.extapi.getSystemInfoSync as uni_getSystemInfoSync
open class GenPagesCSSStyleIsolationStyleIsolation : BasePage {
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
    open var data: DataType__118
        get() {
            return unref(this.`$exposed`["data"]) as DataType__118
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesCSSStyleIsolationStyleIsolation, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSStyleIsolationStyleIsolation
            val _cache = __ins.renderCache
            val data = reactive(DataType__118(stay_time = 1000, childViewRect = null, childView = null))
            onReady(fun(){
                data.childView = uni_getElementById("view-hover")
                data.childViewRect = data.childView?.getBoundingClientRect() ?: null
                if (data.childViewRect != null) {
                    data.childViewRect!!.y += uni_getSystemInfoSync().safeArea.top + 44
                }
            }
            )
            __expose(_uM("data" to data))
            return fun(): Any? {
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("style" to _nS(_uM("padding" to "15px"))), _uA(
                        _cE("text", _uM("class" to "page-title"), "样式隔离"),
                        _cE("view", _uM("class" to "section"), _uA(
                            _cE("text", _uM("class" to "section-title"), "1. 全局样式 "),
                            _cE("text", _uM("class" to "section-desc"), "App.uvue中定义的全局样式是否会影响页面元素"),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "label"), "使用全局class \"global-text\"："),
                                _cE("text", _uM("class" to "global-text"), "这段文字应用了全局样式，文字应为：蓝色")
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "label"), "使用全局class \"global-box\"："),
                                _cE("view", _uM("class" to "global-box"), _uA(
                                    _cE("text", null, "这是应用了全局box样式的容器，背景色应为：蓝色")
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "section"), _uA(
                            _cE("text", _uM("class" to "section-title"), "2. 自定义组件hover-class透传"),
                            _cE("text", _uM("class" to "section-desc"), "单根节点为view的自定义组件，可以直接透传hover-class相关属性"),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cV(unref(GenPagesCSSStyleIsolationChildHoverClassClass), _uM("id" to "view-hover", "class" to "view-class", "hover-class" to "hover-class", "hover-stay-time" to unref(data).stay_time), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cE("text", _uM("class" to "text"), "抬起 1000 ms 后背景恢复")
                                    )
                                }
                                ), "_" to 1), 8, _uA(
                                    "hover-stay-time"
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "section"), _uA(
                            _cE("text", _uM("class" to "section-title"), "3. 单根节点组件 "),
                            _cE("text", _uM("class" to "section-desc"), "组件为单根节点时，外部使用的class和style会覆盖在组件的根节点上"),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "label"), "默认样式的组件："),
                                _cV(unref(GenPagesCSSStyleIsolationChildClass), _uM("text" to "默认样式")),
                                _cE("text", _uM("class" to "section-desc"), "预期：组件内部有内联style的元素（黄色背景，3px边框），外部class无法覆盖内联style")
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "label"), "外部添加class覆盖（绿色）："),
                                _cV(unref(GenPagesCSSStyleIsolationChildClass), _uM("text" to "外部class覆盖", "class" to "custom-style-green"))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "label"), "外部添加style覆盖（绿色）："),
                                _cV(unref(GenPagesCSSStyleIsolationChildClass), _uM("text" to "外部style覆盖", "style" to _nS(_uM("background-color" to "#E8F5E9", "border-color" to "#4CAF50"))), null, 8, _uA(
                                    "style"
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "label"), "外部class和style同时覆盖（绿色+border-width为5px）："),
                                _cV(unref(GenPagesCSSStyleIsolationChildClass), _uM("text" to "class+style覆盖", "class" to "custom-style-green", "style" to _nS(_uM("border-width" to "5px"))), null, 8, _uA(
                                    "style"
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "section"), _uA(
                            _cE("text", _uM("class" to "section-title"), "4. externalClasses配置 "),
                            _cE("text", _uM("class" to "section-desc"), "通过externalClasses暴露特定class（类似微信小程序），允许外部精确控制组件内部样式"),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "label"), "默认样式（橙色）："),
                                _cV(unref(GenPagesCSSStyleIsolationChildExternalClassesClass), _uM("text" to "默认样式：紫色背景和描边"))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "label"), "通过child-class自定义样式（蓝色）："),
                                _cV(unref(GenPagesCSSStyleIsolationChildExternalClassesClass), _uM("text" to "蓝色样式：黄色背景蓝色描边", "child-class" to "external-class", "box-class" to "external-custom-box"))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "label"), "全局样式使用!important覆盖组件样式："),
                                _cV(unref(GenPagesCSSStyleIsolationChildExternalClassesClass), _uM("text" to "全局蓝色样式：黄色背景描边", "child-class" to "global-important-class", "box-class" to "global-important-box")),
                                _cE("text", _uM("class" to "section-desc"), "预期：全局样式中的!important可以覆盖组件内部样式")
                            ))
                        )),
                        _cE("view", _uM("class" to "section"), _uA(
                            _cE("text", _uM("class" to "section-title"), "4.5. external-style配置 "),
                            _cE("text", _uM("class" to "section-desc"), "通过external-style暴露style属性，允许外部通过style字符串控制组件内部样式（不受样式隔离策略影响）"),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "label"), "默认样式（橙色）："),
                                _cV(unref(GenPagesCSSStyleIsolationChildExternalStyleClass), _uM("text" to "默认样式：紫色背景和描边"))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "label"), "通过box-style自定义外层样式（蓝色）："),
                                _cV(unref(GenPagesCSSStyleIsolationChildExternalStyleClass), _uM("text" to "组件根节点：蓝色背景样式", "box-style" to "background-color: #8fd3ff; border-color: #00aaff;"))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "label"), "通过inner-box-style自定义内层样式（绿色）："),
                                _cV(unref(GenPagesCSSStyleIsolationChildExternalStyleClass), _uM("text" to "组件内层：绿色背景样式", "inner-box-style" to "background-color: #E8F5E9; border-color: #4CAF50;"))
                            ))
                        )),
                        _cE("view", _uM("class" to "section"), _uA(
                            _cE("text", _uM("class" to "section-title"), "5. 多根节点组件 "),
                            _cE("text", _uM("class" to "section-desc"), "多根节点继承 \$attrs.style 和 \$attrs.class，允许外部精确控制组件内部样式"),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "label"), "默认样式："),
                                _cV(unref(GenPagesCSSStyleIsolationChildMultiTagClass), _uM("text" to "默认样式"))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "label"), "通过\$attrs.class自定义组件内部样式（紫色）："),
                                _cV(unref(GenPagesCSSStyleIsolationChildMultiTagClass), _uM("class" to "child-multi-class", "text" to "class样式"))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "label"), "通过\$attrs.style自定义组件内部样式（蓝色）："),
                                _cV(unref(GenPagesCSSStyleIsolationChildMultiTagClass), _uM("text" to "蓝色样式", "style" to _nS(_uM("background-color" to "#8fd3ff", "border-color" to "#00aaff"))), null, 8, _uA(
                                    "style"
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "section"), _uA(
                            _cE("text", _uM("class" to "section-title"), "6. 组件的根节点为二级组件时 样式传递"),
                            _cE("text", _uM("class" to "section-desc"), "页面使用组件level，组件level使用二级组件level-child"),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "label"), "默认样式："),
                                _cV(unref(GenPagesCSSStyleIsolationLevelClass))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "label"), "外部添加class覆盖（蓝色）："),
                                _cV(unref(GenPagesCSSStyleIsolationLevelClass), _uM("class" to "level-child-class"))
                            ))
                        )),
                        _cE("view", _uM("class" to "section"), _uA(
                            _cE("text", _uM("class" to "section-title"), "7. 父组件不影响子组件 "),
                            _cE("text", _uM("class" to "section-desc"), "默认策略下，父组件的样式不会影响子组件（子组件样式隔离）"),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "label"), "父组件包含子组件："),
                                _cV(unref(GenPagesCSSStyleIsolationParentClass)),
                                _cE("text", _uM("class" to "section-desc"), "预期：父组件有橙色背景，子组件有蓝色背景。父组件中定义的.child-box样式（黄色）不会影响子组件，子组件保持自己的蓝色背景")
                            ))
                        )),
                        _cE("view", _uM("class" to "section"), _uA(
                            _cE("text", _uM("class" to "section-title"), "8. styleIsolation配置"),
                            _cE("text", _uM("class" to "section-desc"), "isolated、app、app-and-page三种样式隔离模式的优先级关系"),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "label"), "8.1 isolated模式 - 全隔离"),
                                _cE("text", _uM("class" to "section-desc"), "只受组件自身样式影响（除externalClasses、组件根节点、v-deep以外），不受全局样式和页面样式影响"),
                                _cV(unref(GenPagesCSSStyleIsolationCompIsolatedClass), _uM("class" to "global-box comp-isolated")),
                                _cE("text", _uM("class" to "section-desc"), "预期：.global-box不会应用全局样式（蓝色），.page-box不会应用页面样式（绿色），只显示组件自身样式（紫色）")
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "label"), "8.2 app模式 - 受全局样式影响"),
                                _cE("text", _uM("class" to "section-desc"), "优先级：全局样式 < 自身样式"),
                                _cV(unref(GenPagesCSSStyleIsolationCompAppClass), _uM("class" to "comp-app")),
                                _cE("text", _uM("class" to "section-desc"), "预期：.global-box会应用全局样式（蓝色），.page-box不会应用页面样式（绿色），组件自身样式优先级最高（紫色）")
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "label"), "8.3 app-and-page模式 - 受全局和页面样式影响"),
                                _cE("text", _uM("class" to "section-desc"), "优先级：全局样式 < 组件自身样式 < 页面样式"),
                                _cV(unref(GenPagesCSSStyleIsolationCompAppAndPageClass), _uM("class" to "comp-app-and-page", "text" to "应该显示页面样式（背景绿色）")),
                                _cE("text", _uM("class" to "section-desc"), "预期：.global-box会应用全局样式（蓝色），.page-box会应用页面样式（绿色）优先级最高，组件自身样式（紫色）")
                            ))
                        ))
                    ), 4)
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
                return _uM("page-title" to _pS(_uM("fontSize" to 24, "fontWeight" to "bold", "color" to "#333333", "textAlign" to "center", "marginBottom" to 20)), "section" to _pS(_uM("marginBottom" to 30, "borderTopLeftRadius" to 8, "borderTopRightRadius" to 8, "borderBottomRightRadius" to 8, "borderBottomLeftRadius" to 8)), "section-title" to _pS(_uM("fontSize" to 18, "fontWeight" to "bold", "color" to "#333333", "marginBottom" to 10)), "section-desc" to _pS(_uM("fontSize" to 13, "color" to "#999999", "marginTop" to 10, "marginRight" to 10, "marginBottom" to 10, "marginLeft" to 10)), "test-item" to _pS(_uM("marginBottom" to 15, "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "backgroundColor" to "#FFFFFF", "borderTopLeftRadius" to 6, "borderTopRightRadius" to 6, "borderBottomRightRadius" to 6, "borderBottomLeftRadius" to 6)), "label" to _pS(_uM("fontSize" to 15, "color" to "#555555", "marginBottom" to 8)), "custom-style-green" to _pS(_uM("!backgroundColor" to "#cbf1db", "!borderTopColor" to "#8bc399", "!borderRightColor" to "#8bc399", "!borderBottomColor" to "#8bc399", "!borderLeftColor" to "#8bc399")), "external-class" to _pS(_uM("!backgroundColor" to "#9ad6fa", "!borderTopColor" to "#00aaff", "!borderRightColor" to "#00aaff", "!borderBottomColor" to "#00aaff", "!borderLeftColor" to "#00aaff")), "external-custom-box" to _pS(_uM("!backgroundColor" to "#FFFF00", "!borderTopWidth" to 2, "!borderRightWidth" to 2, "!borderBottomWidth" to 2, "!borderLeftWidth" to 2, "!borderTopStyle" to "solid", "!borderRightStyle" to "solid", "!borderBottomStyle" to "solid", "!borderLeftStyle" to "solid", "!borderTopColor" to "#0000FF", "!borderRightColor" to "#0000FF", "!borderBottomColor" to "#0000FF", "!borderLeftColor" to "#0000FF")), "child-multi-class" to _pS(_uM("!backgroundColor" to "#d9daff", "!borderTopColor" to "#aaaaff", "!borderRightColor" to "#aaaaff", "!borderBottomColor" to "#aaaaff", "!borderLeftColor" to "#aaaaff")), "level-child-class" to _pS(_uM("!backgroundColor" to "#00aaff")), "page-box" to _pS(_uM("backgroundColor" to "#e8f5e9", "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "marginTop" to 10, "marginRight" to 10, "marginBottom" to 10, "marginLeft" to 10, "borderTopLeftRadius" to 8, "borderTopRightRadius" to 8, "borderBottomRightRadius" to 8, "borderBottomLeftRadius" to 8, "borderTopWidth" to 2, "borderRightWidth" to 2, "borderBottomWidth" to 2, "borderLeftWidth" to 2, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#4caf50", "borderRightColor" to "#4caf50", "borderBottomColor" to "#4caf50", "borderLeftColor" to "#4caf50")), "page-text" to _pS(_uM("color" to "#FF0000", "fontSize" to 14)), "view-class" to _pS(_uM("paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "marginTop" to 10, "marginRight" to 10, "marginBottom" to 10, "marginLeft" to 10, "borderTopLeftRadius" to 8, "borderTopRightRadius" to 8, "borderBottomRightRadius" to 8, "borderBottomLeftRadius" to 8, "borderTopWidth" to 2, "borderRightWidth" to 2, "borderBottomWidth" to 2, "borderLeftWidth" to 2, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#4caf50", "borderRightColor" to "#4caf50", "borderBottomColor" to "#4caf50", "borderLeftColor" to "#4caf50", "backgroundColor" to "#e8f5e9", "justifyContent" to "center", "alignItems" to "center")), "hover-class" to _pS(_uM("backgroundColor" to "#00aaff")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
