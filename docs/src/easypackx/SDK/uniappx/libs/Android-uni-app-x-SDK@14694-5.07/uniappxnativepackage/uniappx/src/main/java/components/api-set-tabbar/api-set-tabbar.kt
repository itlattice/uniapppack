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
import io.dcloud.uniapp.extapi.hideTabBar as uni_hideTabBar
import io.dcloud.uniapp.extapi.hideTabBarRedDot as uni_hideTabBarRedDot
import io.dcloud.uniapp.extapi.removeTabBarBadge as uni_removeTabBarBadge
import io.dcloud.uniapp.extapi.setTabBarBadge as uni_setTabBarBadge
import io.dcloud.uniapp.extapi.setTabBarItem as uni_setTabBarItem
import io.dcloud.uniapp.extapi.setTabBarStyle as uni_setTabBarStyle
import io.dcloud.uniapp.extapi.showTabBar as uni_showTabBar
import io.dcloud.uniapp.extapi.showTabBarRedDot as uni_showTabBarRedDot
open class GenComponentsApiSetTabbarApiSetTabbar : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsApiSetTabbarApiSetTabbar) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsApiSetTabbarApiSetTabbar
            val _cache = __ins.renderCache
            val title = ref("tababr")
            val hasSetTabBarBadge = ref(false)
            val hasShownTabBarRedDot = ref(false)
            val hasCustomedStyle = ref(false)
            val hasCustomedItem = ref(false)
            val hasHiddenTabBar = ref(false)
            val hasHiddenTabBarItem = ref(false)
            val hasSetLongTitle = ref(false)
            onUnmounted(fun(){
                if (hasSetTabBarBadge.value) {
                    uni_removeTabBarBadge(RemoveTabBarBadgeOptions(index = 1))
                }
                if (hasShownTabBarRedDot.value) {
                    uni_hideTabBarRedDot(HideTabBarRedDotOptions(index = 1))
                }
                if (hasHiddenTabBar.value) {
                    uni_showTabBar(null)
                }
                if (hasCustomedStyle.value) {
                    uni_setTabBarStyle(SetTabBarStyleOptions(color = "#7A7E83", selectedColor = "#007AFF", backgroundColor = "#F8F8F8", borderStyle = "black"))
                }
                if (hasCustomedItem.value) {
                    var tabBarOptions = SetTabBarItemOptions(index = 1, text = "接口", iconPath = "/static/api.png", selectedIconPath = "/static/apiHL.png")
                    uni_setTabBarItem(tabBarOptions)
                }
                if (hasHiddenTabBarItem.value || hasSetLongTitle.value) {
                    var tabBarOptions = SetTabBarItemOptions(visible = true, index = 1, text = "接口", iconPath = "/static/api.png", selectedIconPath = "/static/apiHL.png")
                    uni_setTabBarItem(tabBarOptions)
                }
            }
            )
            val setTabBarTitle = fun(){
                var tabBarOptions = SetTabBarItemOptions(visible = true, index = 1, text = "接口", iconPath = "/static/api.png", selectedIconPath = "/static/apiHL.png")
                if (!hasSetLongTitle.value) {
                    tabBarOptions.text = "超长标题内容超长标题内容超长标题内容超长标题测试"
                    tabBarOptions.iconPath = ""
                    tabBarOptions.selectedIconPath = ""
                } else {
                    tabBarOptions.text = "接口"
                    tabBarOptions.iconPath = "/static/api.png"
                    tabBarOptions.selectedIconPath = "/static/apiHL.png"
                }
                uni_setTabBarItem(tabBarOptions)
                hasSetLongTitle.value = !hasSetLongTitle.value
            }
            val hideTabBarItem = fun(){
                var tabBarOptions = SetTabBarItemOptions(visible = true, index = 1, text = "接口", iconPath = "/static/api.png", selectedIconPath = "/static/apiHL.png")
                if (!hasHiddenTabBarItem.value) {
                    tabBarOptions.visible = false
                } else {
                    tabBarOptions.visible = true
                }
                uni_setTabBarItem(tabBarOptions)
                hasHiddenTabBarItem.value = !hasHiddenTabBarItem.value
            }
            val setTabBarBadge = fun(){
                if (hasShownTabBarRedDot.value) {
                    uni_hideTabBarRedDot(HideTabBarRedDotOptions(index = 1))
                    hasShownTabBarRedDot.value = !hasShownTabBarRedDot.value
                }
                if (!hasSetTabBarBadge.value) {
                    uni_setTabBarBadge(SetTabBarBadgeOptions(index = 1, text = "1"))
                } else {
                    uni_removeTabBarBadge(RemoveTabBarBadgeOptions(index = 1))
                }
                hasSetTabBarBadge.value = !hasSetTabBarBadge.value
            }
            val showTabBarRedDot = fun(){
                if (hasSetTabBarBadge.value) {
                    uni_removeTabBarBadge(RemoveTabBarBadgeOptions(index = 1))
                    hasSetTabBarBadge.value = !hasSetTabBarBadge.value
                }
                if (!hasShownTabBarRedDot.value) {
                    uni_showTabBarRedDot(ShowTabBarRedDotOptions(index = 1))
                } else {
                    uni_hideTabBarRedDot(HideTabBarRedDotOptions(index = 1))
                }
                hasShownTabBarRedDot.value = !hasShownTabBarRedDot.value
            }
            val hideTabBar = fun(){
                if (!hasHiddenTabBar.value) {
                    uni_hideTabBar(null)
                } else {
                    uni_showTabBar(null)
                }
                hasHiddenTabBar.value = !hasHiddenTabBar.value
            }
            val customStyle = fun(){
                if (hasCustomedStyle.value) {
                    uni_setTabBarStyle(SetTabBarStyleOptions(color = "#7A7E83", selectedColor = "#007AFF", backgroundColor = "#F8F8F8", borderStyle = "black"))
                } else {
                    uni_setTabBarStyle(SetTabBarStyleOptions(color = "#FFF", selectedColor = "#007AFF", backgroundColor = "#000000", borderStyle = "black"))
                }
                hasCustomedStyle.value = !hasCustomedStyle.value
            }
            val customItem = fun(){
                var tabBarOptions = SetTabBarItemOptions(index = 1, text = "接口", iconPath = "/static/api.png", selectedIconPath = "/static/apiHL.png")
                if (hasCustomedItem.value) {
                    uni_setTabBarItem(tabBarOptions)
                } else {
                    tabBarOptions.text = "API"
                    uni_setTabBarItem(tabBarOptions)
                }
                hasCustomedItem.value = !hasCustomedItem.value
            }
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                return _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                    _cV(_component_page_head, _uM("title" to unref(title)), null, 8, _uA(
                        "title"
                    )),
                    _cE("button", _uM("class" to "button", "onClick" to setTabBarBadge), _tD(if (!unref(hasSetTabBarBadge)) {
                        "设置tab徽标"
                    } else {
                        "移除tab徽标"
                    }
                    ), 1),
                    _cE("button", _uM("class" to "button", "onClick" to showTabBarRedDot), _tD(if (!unref(hasShownTabBarRedDot)) {
                        "显示红点"
                    } else {
                        "移除红点"
                    }
                    ), 1),
                    _cE("button", _uM("class" to "button", "onClick" to customStyle), _tD(if (!unref(hasCustomedStyle)) {
                        "自定义Tab样式"
                    } else {
                        "移除自定义样式"
                    }
                    ), 1),
                    _cE("button", _uM("class" to "button", "onClick" to customItem), _tD(if (!unref(hasCustomedItem)) {
                        "自定义Tab信息"
                    } else {
                        "移除自定义信息"
                    }
                    ), 1),
                    _cE("button", _uM("class" to "button", "onClick" to hideTabBar), _tD(if (!unref(hasHiddenTabBar)) {
                        "隐藏TabBar"
                    } else {
                        "显示TabBar"
                    }
                    ), 1),
                    _cE("button", _uM("class" to "button", "onClick" to hideTabBarItem), _tD(if (!unref(hasHiddenTabBarItem)) {
                        "隐藏接口Item"
                    } else {
                        "显示接口Item"
                    }
                    ), 1),
                    _cE("button", _uM("class" to "button", "onClick" to setTabBarTitle), _tD(if (!unref(hasSetLongTitle)) {
                        "自定义超长标题"
                    } else {
                        "移除自定义信息"
                    }
                    ), 1),
                    _cE("view", _uM("class" to "btn-area"))
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
                return _uM("button" to _pS(_uM("marginTop" to 15, "marginLeft" to 0, "marginRight" to 0)), "btn-area" to _pS(_uM("paddingTop" to 15)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("unmount" to null)
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
