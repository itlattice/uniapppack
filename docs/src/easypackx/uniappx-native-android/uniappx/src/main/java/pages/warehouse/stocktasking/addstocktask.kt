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
import io.dcloud.uniapp.extapi.`$emit` as uni__emit
open class GenPagesWarehouseStocktaskingAddstocktask : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            xProvitae.scrollTop = e.scrollTop
            val pages = getCurrentPages()
            if (pages.length == 0) {
                return
            }
            val page = pages[pages.length - 1].route
            uni__emit("onPageScroll", _uO("top" to e.scrollTop, "page" to page))
        }
        , __ins)
        onResize(fun(_: OnResizeOptions) {
            uni__emit("onResize", fun() {})
        }
        , __ins)
        onLoad(fun(query: OnLoadOptions) {
            xProvitae.onLoadOpts = JSON.parseObject(JSON.stringify(query)!!) ?: _uO()
            uni__emit("onLoad", fun() {})
        }
        , __ins)
        onPageHide(fun() {
            uni__emit("onHide", fun() {})
        }
        , __ins)
        onReady(fun() {
            uni__emit("onReady", fun() {})
            xProvitae.pageReady = true
        }
        , __ins)
        onPageShow(fun() {
            uni__emit("onShow", fun() {})
        }
        , __ins)
    }
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesWarehouseStocktaskingAddstocktask) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesWarehouseStocktaskingAddstocktask
            val _cache = __ins.renderCache
            val taskname = ref("")
            val depart = ref(_uO())
            val admin = ref(_uO())
            val haveCache = ref(false)
            val orderremark = ref<UniElement?>(null)
            val signer = ref<UniElement?>(null)
            val modal = ref<UniElement?>(null)
            val loading = ref<UniElement?>(null)
            val loadCache = fun(){
                var cache = common.getStorage("addstocktask")
                if (cache == "") {
                    return
                }
                cache = cache as UTSJSONObject
                taskname.value = cache["taskname"] as String
                depart.value = cache["depart"] as UTSJSONObject
                admin.value = cache["admin"] as UTSJSONObject
                uni__emit("setremarkbox", _uO("remark" to cache["remark"] as String, "thumb" to cache["thumb"] as UTSArray<UTSJSONObject>))
                haveCache.value = true
                common.rmStorage("addstocktask")
            }
            val getUserShop = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var res = await(request.callapi("user/getshopinfo", _uO()))
                        if (res.code < 0) {
                            common.toast("错误:" + res.msg)
                            return@w1
                        }
                        depart.value = res.data as UTSJSONObject
                })
            }
            val chooseDepart = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var departData = await(common.navigatoEvent("/pages/common/choosedepart"))
                        if (departData["name"] == null) {
                            return@w1
                        }
                        depart.value = departData
                })
            }
            val chooseAdmin = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var res = await(common.navigatoEvent("/pages/common/chooseadmin?depart=" + depart.value["id"]))
                        console.log(res)
                        if (res["id"] == null) {
                            return@w1
                        }
                        admin.value = res
                })
            }
            val getData = fun(): UTSPromise<UTSJSONObject?> {
                return wrapUTSPromise(suspend w1@{
                        console.log("submit")
                        var remarkbox = await(common.lisenInfo("xremarkbox", orderremark.value as Any))
                        console.log("remark", remarkbox)
                        if (remarkbox["remark"] == null) {
                            console.log("null")
                            return@w1 null
                        }
                        var data: UTSJSONObject = _uO("taskname" to taskname.value, "depart" to depart.value, "admin" to admin.value, "remark" to remarkbox["remark"] as String, "thumb" to remarkbox["file"] as UTSArray<UTSJSONObject>)
                        return@w1 data
                })
            }
            val saveCaogao = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var data = await(getData())
                        if (data == null) {
                            return@w1
                        }
                        console.log("草稿信息", data)
                        common.setStorage("addstocktask", data)
                        common.toast("保存草稿成功")
                        setTimeout(fun(){
                            common.back()
                        }
                        , 1500)
                })
            }
            val submitTaking = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var data = await(getData())
                        if (data == null) {
                            return@w1
                        }
                        if ((data["taskname"] as String) == "") {
                            common.toast("请输入任务名称")
                            return@w1
                        }
                        if (depart.value["id"] == null) {
                            common.toast("请输入要盘点的店仓")
                            return@w1
                        }
                        if (admin.value["id"] == null) {
                            common.toast("请选择负责人")
                            return@w1
                        }
                        var submitData: UTSJSONObject = _uO("name" to taskname.value, "admin" to admin.value["id"] as Number, "depart" to depart.value["id"] as Number, "remark" to data["remark"] as String, "thumb" to data["thumb"] as UTSArray<UTSJSONObject>)
                        console.log("提交信息", submitData)
                        var sign = await(common.signer(signer.value as Any))
                        console.log("签字信息", sign)
                        if (sign == null) {
                            return@w1
                        }
                        submitData["signer"] = sign
                        common.loading(loading.value)
                        var res = await(request.callapi("warehouse/addstocktask", submitData))
                        common.hideLoading(loading.value)
                        common.toast(res.msg)
                        if (res.code < 0) {
                            return@w1
                        }
                        var rdata = res.data as UTSJSONObject
                        var id = rdata["id"].toString()
                        common.timeToPage("/pages/warehouse/stocktasking/stocktaskview?id=" + id, true)
                })
            }
            onLoad(fun(_options){
                getUserShop()
            }
            )
            onReady(fun(){
                loadCache()
            }
            )
            return fun(): Any? {
                val _component_x_viewtitle = resolveEasyComponent("x-viewtitle", GenComponentsXViewtitleClass)
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_x_triangleinput = resolveEasyComponent("x-triangleinput", GenComponentsXTriangleinputClass)
                val _component_x_remarkbox = resolveEasyComponent("x-remarkbox", GenComponentsXRemarkboxClass)
                val _component_x_signer = resolveEasyComponent("x-signer", GenComponentsXSignerClass)
                val _component_x_model = resolveEasyComponent("x-model", GenComponentsXModelClass)
                val _component_x_loading = resolveEasyComponent("x-loading", GenComponentsXLoadingClass)
                return _cE("view", null, _uA(
                    _cV(_component_x_viewtitle, _uM("title" to "添加任务")),
                    _cE("view", _uM("class" to "tasklist background-white width-full"), _uA(
                        _cE("view", _uM("class" to "lineitem"), _uA(
                            _cV(_component_x_triangleinput, _uM("height" to 35, "width" to 710), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "linebox display-flex"), _uA(
                                        _cE("text", _uM("class" to "title"), "任务名称"),
                                        _cE("view", _uM("class" to "changbox display-flex"), _uA(
                                            _cE("input", _uM("type" to "text", "modelValue" to unref(taskname), "onInput" to fun(`$event`: UniInputEvent){
                                                trySetRefValue(taskname, `$event`.detail.value)
                                            }
                                            , "class" to "nameinput", "placeholder" to "请输入任务名称"), null, 40, _uA(
                                                "modelValue"
                                            )),
                                            if (unref(taskname).length > 0) {
                                                _cV(_component_x_iconfont, _uM("key" to 0, "class" to "nameicon", "onClick" to fun(){
                                                    taskname.value = ""
                                                }, "name" to "chacha", "size" to "16", "height" to 40, "color" to "#c7c7c7"), null, 8, _uA(
                                                    "onClick"
                                                ))
                                            } else {
                                                _cC("v-if", true)
                                            }
                                        ))
                                    ))
                                )
                            }
                            ), "_" to 1))
                        )),
                        _cE("view", _uM("class" to "lineitem"), _uA(
                            _cV(_component_x_triangleinput, _uM("height" to 35, "width" to 710), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "linebox display-flex"), _uA(
                                        _cE("text", _uM("class" to "title"), "盘点店仓"),
                                        _cE("view", _uM("class" to "changbox", "onClick" to chooseDepart), _uA(
                                            if (isTrue(unref(depart)["name"])) {
                                                _cE("text", _uM("key" to 0, "class" to "text"), _tD(unref(depart)["name"]), 1)
                                            } else {
                                                _cE("text", _uM("key" to 1, "class" to "text placeholder"), "请选择要盘点的店/仓")
                                            }
                                        ))
                                    ))
                                )
                            }
                            ), "_" to 1))
                        )),
                        _cE("view", _uM("class" to "lineitem"), _uA(
                            _cV(_component_x_triangleinput, _uM("height" to 35, "width" to 710), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "linebox display-flex"), _uA(
                                        _cE("text", _uM("class" to "title"), "负责人"),
                                        _cE("view", _uM("class" to "changbox", "onClick" to chooseAdmin), _uA(
                                            if (isTrue(unref(admin)["name"])) {
                                                _cE("text", _uM("key" to 0, "class" to "text"), _tD(unref(admin)["name"]), 1)
                                            } else {
                                                _cE("text", _uM("key" to 1, "class" to "text placeholder"), "请选择负责人")
                                            }
                                        ))
                                    ))
                                )
                            }
                            ), "_" to 1))
                        ))
                    )),
                    _cV(_component_x_remarkbox, _uM("ref_key" to "orderremark", "ref" to orderremark), null, 512),
                    _cV(_component_x_signer, _uM("ref_key" to "signer", "ref" to signer), null, 512),
                    _cV(_component_x_model, _uM("ref_key" to "modal", "ref" to modal), null, 512),
                    _cV(_component_x_loading, _uM("ref_key" to "loading", "ref" to loading), null, 512),
                    _cE("view", _uM("class" to "bottomaction padding-safe-bottom"), _uA(
                        _cE("view", _uM("class" to "display-flex actions"), _uA(
                            _cE("view", _uM("class" to "action caogao", "onClick" to saveCaogao), _uA(
                                _cE("text", _uM("class" to "actioncontent align-center color-white"), "草稿")
                            )),
                            _cE("view", _uM("class" to "action submit", "onClick" to submitTaking), _uA(
                                _cE("text", _uM("class" to "actioncontent align-center color-white"), "提交")
                            ))
                        ))
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
                return _uM("tasklist" to _pS(_uM("paddingTop" to 3, "paddingLeft" to "20rpx", "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#e8e8e8")), "lineitem" to _uM(".tasklist " to _uM("height" to 35)), "title" to _uM(".tasklist .lineitem .linebox " to _uM("lineHeight" to "35px", "width" to "140rpx", "fontSize" to 14, "textAlign" to "right", "color" to "#ABABAB")), "changbox" to _uM(".tasklist .lineitem .linebox " to _uM("marginLeft" to "60rpx", "width" to "480rpx", "height" to 35)), "nameinput" to _uM(".tasklist .lineitem .linebox .changbox " to _uM("fontSize" to 14, "width" to "430rpx")), "text" to _uM(".tasklist .lineitem .linebox .changbox " to _uM("lineHeight" to "35px", "fontSize" to 14, "textAlign" to "left")), "placeholder" to _uM(".tasklist .lineitem .linebox .changbox " to _uM("color" to "#9c9c9c")), "icon" to _uM(".tasklist .lineitem .linebox .changbox " to _uM("paddingTop" to 10)), "bottomaction" to _pS(_uM("position" to "fixed", "bottom" to 0, "left" to 0, "width" to "750rpx")), "actions" to _uM(".bottomaction " to _uM("height" to 50, "width" to "750rpx")), "caogao" to _uM(".bottomaction .actions " to _uM("width" to "350rpx", "backgroundColor" to "#59CDFF")), "submit" to _uM(".bottomaction .actions " to _uM("width" to "400rpx", "backgroundColor" to "#FF5029")), "actioncontent" to _uM(".bottomaction .actions .action " to _uM("lineHeight" to "50px", "fontSize" to 18)), "total" to _pS(_uM("paddingLeft" to "12rpx")), "heji" to _uM(".total " to _uM("lineHeight" to "50px", "fontSize" to 13, "color" to "#000000", "width" to "150rpx")), "amount" to _uM(".total " to _uM("lineHeight" to "50px", "paddingLeft" to "16rpx", "color" to "#ff8f1a", "fontSize" to 18)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
