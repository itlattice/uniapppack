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
open class GenComponentsXAddgoods : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var selected: UTSJSONObject by `$props`
    open var departID: Any? by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXAddgoods) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXAddgoods
            val _cache = __ins.renderCache
            val props = __props
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val formloading = ref<UniElement?>(null)
            val handAdd = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var str = JSON.stringify(props.selected)
                        console.log(str)
                        var res = await(common.navigatoEvent("/pages/common/choosegoods?str=" + str + "&depart=" + props.departID))
                        console.log(res, "选择商品")
                        if (res["data"] == null) {
                            return@w1
                        }
                        var list = res["data"] as UTSArray<selectedListType>
                        common.loading(formloading.value as Any)
                        emit("addGoods", list)
                        common.hideLoading(formloading.value as Any)
                })
            }
            val scanAdd = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var str = JSON.stringify(props.selected)
                        var res = await(common.navigatoEvent("/pages/common/scangoods?str=" + str + "&depart=" + props.departID))
                        console.log(res, "选择商品")
                        if (res["data"] == null) {
                            return@w1
                        }
                        var list = res["data"] as UTSArray<selectedListType>
                        common.loading(formloading.value as Any)
                        emit("addGoods", list)
                        common.hideLoading(formloading.value as Any)
                })
            }
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_x_loading = resolveEasyComponent("x-loading", GenComponentsXLoadingClass)
                return _cE("view", _uM("class" to "addgoods actionicon display-flex"), _uA(
                    _cE("view", _uM("class" to "action", "onClick" to scanAdd), _uA(
                        _cV(_component_x_iconfont, _uM("class" to "icon align-center", "name" to "saoyisao", "color" to "#1776FC", "size" to "40")),
                        _cE("text", _uM("class" to "align-center content"), "扫一扫")
                    )),
                    _cE("view", _uM("class" to "action", "onClick" to handAdd), _uA(
                        _cV(_component_x_iconfont, _uM("class" to "icon align-center", "name" to "jiahao", "color" to "#1776FC", "size" to "40")),
                        _cE("text", _uM("class" to "align-center content"), "手动添加")
                    )),
                    _cV(_component_x_loading, _uM("ref_key" to "formloading", "ref" to formloading), null, 512)
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
                return _uM("actionicon" to _pS(_uM("paddingTop" to 12, "paddingBottom" to 12)), "action" to _uM(".actionicon " to _uM("width" to "50%")), "content" to _uM(".actionicon .action " to _uM("fontSize" to 13, "color" to "#4f4f4f", "paddingTop" to 9)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("addGoods" to null)
        var props = _nP(_uM("selected" to _uM("type" to "UTSJSONObject", "default" to _uO()), "departID" to _uM("default" to 0)))
        var propsNeedCastKeys = _uA(
            "selected",
            "departID"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
