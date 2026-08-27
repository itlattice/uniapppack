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
open class GenComponentsXVer : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var ver: String by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXVer) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXVer
            val _cache = __ins.renderCache
            return fun(): Any? {
                return _cE("view", _uM("class" to "xver"), _uA(
                    if (isTrue(_ctx.ver)) {
                        _cE("view", _uM("key" to 0, "class" to "ver"), _uA(
                            _cE("text", _uM("class" to "text"), "V " + _tD(_ctx.ver), 1)
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    _cE("view", _uM("class" to "companyname"), _uA(
                        _cE("text", _uM("class" to "text"), "昆明懒猿鲜生科技有限公司 版权所有")
                    )),
                    _cE("view", _uM("class" to "copyright"), _uA(
                        _cE("text", _uM("class" to "text"), "Copyright © 2017-2025 LYXS.All Rights Reserved.")
                    ))
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
                return _uM("xver" to _pS(_uM("width" to "750rpx", "marginTop" to "40rpx", "bottom" to "10rpx")), "text" to _uM(".xver " to _uM("width" to "100%", "textAlign" to "center", "color" to "#a1a1a1", "fontSize" to "16rpx"), ".xver .ver " to _uM("fontSize" to "22rpx")), "ver" to _uM(".xver " to _uM("width" to "100%")), "agreement" to _uM(".xver " to _uM("color" to "#1e79eb")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("ver" to _uM("type" to "String", "default" to "1.0.0")))
        var propsNeedCastKeys = _uA(
            "ver"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
