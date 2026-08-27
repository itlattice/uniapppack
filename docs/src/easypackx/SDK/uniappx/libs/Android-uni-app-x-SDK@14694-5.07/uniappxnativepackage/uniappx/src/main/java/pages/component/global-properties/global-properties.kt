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
open class GenPagesComponentGlobalPropertiesGlobalProperties : BasePage {
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
        var setup: (__props: GenPagesComponentGlobalPropertiesGlobalProperties) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentGlobalPropertiesGlobalProperties
            val _cache = __ins.renderCache
            val generalId = ref("general-id")
            val generalClass = ref("general-class")
            val generalData = ref("general-data")
            val generalStyle = ref("background-color: aqua")
            val validateGeneralAttrText = ref("验证基础属性")
            val hoverClass = ref("hover-class")
            val validateViewAttrText = ref("验证 view 属性")
            val changeHeightByRefText = ref("通过 ref 修改高度")
            val generalTargetRef = ref<UniElement?>(null)
            val viewTargetRef = ref<UniElement?>(null)
            val validateGeneralAttributes = fun(){
                val generalTargetElement = generalTargetRef.value as UniElement
                val generalIdValue = generalTargetElement.getAttribute("id")
                if (generalIdValue != generalId.value) {
                    validateGeneralAttrText.value = "基础属性 id 验证失败"
                    return
                }
                if (!generalTargetElement.classList.includes("general-class")) {
                    validateGeneralAttrText.value = "基础属性 class 验证失败"
                    return
                }
                val generalDataValue = generalTargetElement.getAttribute("data-test")
                if (generalDataValue != generalData.value) {
                    validateGeneralAttrText.value = "基础属性 data-test 验证失败"
                    return
                }
                validateGeneralAttrText.value = "基础属性验证成功"
            }
            val changeHeight = fun(){
                val generalTargetElement = generalTargetRef.value as UniElement
                changeHeightByRefText.value = "已通过 ref 修改高度"
                generalTargetElement.style.setProperty("height", "200px")
            }
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                val _component_page_intro = resolveEasyComponent("page-intro", GenComponentsPageIntroPageIntroClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", null, _uA(
                        _cV(_component_page_head, _uM("title" to "global-properties")),
                        _cV(_component_page_intro, _uM("content" to "本页演示组件通用属性：id、class、data、style 的绑定与校验，以及 ref、hover-class、hover-start-time、hover-stay-time 等点击态效果。")),
                        _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                            _cE("view", _uM("id" to unref(generalId), "class" to _nC(unref(generalClass)), "data-test" to unref(generalData), "style" to _nS(unref(generalStyle)), "ref_key" to "generalTargetRef", "ref" to generalTargetRef), _uA(
                                _cE("text", null, "id: " + _tD(unref(generalId)), 1),
                                _cE("text", null, "class: " + _tD(unref(generalClass)), 1),
                                _cE("text", null, "data-test: " + _tD(unref(generalData)), 1),
                                _cE("text", null, "style: " + _tD(unref(generalStyle)), 1)
                            ), 14, _uA(
                                "id",
                                "data-test"
                            )),
                            _cE("view", _uM("class" to "btn btn-style uni-common-mt", "onClick" to validateGeneralAttributes), _uA(
                                _cE("text", _uM("class" to "btn-inner"), _tD(unref(validateGeneralAttrText)), 1)
                            )),
                            _cE("view", _uM("class" to "btn btn-ref uni-common-mt", "onClick" to changeHeight), _uA(
                                _cE("text", _uM("class" to "btn-inner"), _tD(unref(changeHeightByRefText)), 1)
                            )),
                            _cE("view", _uM("class" to "view-class", "hover-class" to unref(hoverClass), "ref_key" to "viewTargetRef", "ref" to viewTargetRef), _uA(
                                _cE("text", _uM("class" to "text"), "按下 50 ms 后背景变红"),
                                _cE("text", _uM("class" to "text"), "抬起 400 ms 后背景恢复")
                            ), 8, _uA(
                                "hover-class"
                            )),
                            _cE("view", _uM("class" to "view-class", "hover-class" to unref(hoverClass), "hover-start-time" to 1000, "hover-stay-time" to 1000, "ref_key" to "viewTargetRef", "ref" to viewTargetRef), _uA(
                                _cE("text", _uM("class" to "text"), "按下 1000 ms 后背景变红"),
                                _cE("text", _uM("class" to "text"), "抬起 1000 ms 后背景恢复")
                            ), 8, _uA(
                                "hover-class"
                            ))
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
                return _uM("btn" to _pS(_uM("height" to 50, "display" to "flex", "alignItems" to "center", "justifyContent" to "center", "backgroundColor" to "#409eff", "borderTopLeftRadius" to 5, "borderTopRightRadius" to 5, "borderBottomRightRadius" to 5, "borderBottomLeftRadius" to 5)), "btn-inner" to _pS(_uM("color" to "#ffffff")), "general-class" to _pS(_uM("marginLeft" to 40, "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "width" to 260, "height" to 160, "backgroundColor" to "#FAEBD7")), "view-class" to _pS(_uM("marginTop" to 20, "marginRight" to 0, "marginBottom" to 0, "marginLeft" to 50, "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "width" to 240, "height" to 100, "backgroundColor" to "#FAEBD7")), "text" to _pS(_uM("marginTop" to 5, "textAlign" to "center")), "hover-class" to _pS(_uM("backgroundColor" to "#FF0000")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
