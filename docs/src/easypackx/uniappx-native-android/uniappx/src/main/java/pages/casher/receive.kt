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
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
import uts.sdk.modules.uniMemoryInfo.offMemoryInfoChange
import uts.sdk.modules.uniMemoryInfo.onMemoryInfoChange
import uts.sdk.modules.uniMemoryInfo.getMemoryInfo
open class GenPagesCasherReceive : BasePage {
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
        var setup: (__props: GenPagesCasherReceive) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCasherReceive
            val _cache = __ins.renderCache
            val titleHeight = ref(100)
            val showCalc = ref(false)
            val calcStr = ref("")
            val calcNumber = ref(0)
            val reson = ref("")
            val resonList = ref(_uA<String>())
            val menus = ref(_uA<FuiDropdownMenuOptionParam>(FuiDropdownMenuOptionParam(text = "在线收款", value = "online", checked = true), FuiDropdownMenuOptionParam(text = "现金收款", value = "cash"), FuiDropdownMenuOptionParam(text = "POS收款", value = "pos"), FuiDropdownMenuOptionParam(text = "会员卡收款", value = "vipcard")))
            val range = ref("在线收款")
            val rangeShow = ref(false)
            val receiveType = ref("online")
            val member = ref(_uO())
            val bills = ref(_uA<FuiDropdownMenuOptionParam>())
            val bill = ref("")
            val rangeBillShow = ref(false)
            val receiveBillType = ref("more")
            val ddmRange = ref<FuiDropdownMenuComponentPublicInstance?>(null)
            val billRange = ref<FuiDropdownMenuComponentPublicInstance?>(null)
            val modal = ref<UniElement?>(null)
            val calcNumberStr = computed(fun(): String {
                return calcNumber.value.toFixed(2)
            }
            )
            val back = fun(){
                common.back()
            }
            val getResonList = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        var res = await(request.callapi("data/getreceivereson", _uO()))
                        resonList.value = res.data as UTSArray<String>
                })
            }
            val getBillTypeList = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var res = await(request.callapi("data/getbilltypelist", _uO("type" to "receive_cash")))
                        console.log("获取到类型", res)
                        if (res.code < 0) {
                            common.toast(res.msg)
                            return@w1
                        }
                        var list = res.data as UTSArray<UTSJSONObject>
                        bill.value = list[0]["text"] as String
                        var mlist = _uA<FuiDropdownMenuOptionParam>()
                        for(item in resolveUTSKeyIterator(list)){
                            mlist.push(FuiDropdownMenuOptionParam(text = item["text"] as String, value = item["value"] as String, checked = item["checked"] == true))
                        }
                        bills.value = mlist as UTSArray<FuiDropdownMenuOptionParam>
                        receiveBillType.value = list[0]["value"] as String
                })
            }
            onLoad(fun(_options){
                var window = uni_getWindowInfo()
                titleHeight.value = window.statusBarHeight + 42
                getMemoryInfo()
                getResonList()
                getBillTypeList()
            }
            )
            val filterTap = fun(){
                ddmRange.value?.show()
                rangeShow.value = true
            }
            val rangeClose = fun(){
                rangeShow.value = false
            }
            val rangeItemClick = fun(e: FuiDropdownMenuOptionParam){
                console.log(e)
                range.value = e.text
                receiveType.value = e.value as String
                rangeClose()
            }
            val filterBillTap = fun(){
                billRange.value?.show()
                rangeBillShow.value = true
            }
            val rangeItemBillClick = fun(e: FuiDropdownMenuOptionParam){
                console.log(e)
                bill.value = e.text
                receiveBillType.value = e.value as String
                rangeClose()
            }
            val rangeBillClose = fun(){
                rangeBillShow.value = false
            }
            val showCalcMethod = fun(){
                showCalc.value = true
            }
            val closePop = fun(){
                showCalc.value = false
            }
            val replyStr = fun(str: String){
                calcStr.value = str
            }
            val replyResult = fun(num: Number){
                calcNumber.value = num
            }
            val startReceive = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        console.log("发起收款：" + calcNumberStr.value)
                        console.log("收款原因：" + reson.value)
                        console.log("收款方式", receiveType.value)
                        when (receiveType.value) {
                            "cash", "pos" -> 
                                {
                                    var res = await(common.showQuery(modal.value as Any, "确定已收款？"))
                                    if (!res) {
                                        return@w1
                                    }
                                    var r = await(request.callapi("payment/cashin", _uO("amount" to calcNumber.value, "reson" to reson.value, "type" to receiveType.value)))
                                    console.log(r)
                                }
                            "vipcard" -> 
                                {
                                    var r2 = await(request.callapi("payment/cashin", _uO("amount" to calcNumber.value, "reson" to reson.value, "type" to receiveType.value)))
                                    console.log(r2)
                                }
                            "online" -> 
                                common.goto("/pages/casher/online_receive?amount=" + calcNumber.value + "&reson=" + reson.value + "&member=" + member.value["id"] + "&bill=" + receiveBillType.value)
                            else -> 
                                common.toast("意外方式：" + receiveType.value)
                        }
                })
            }
            val addReson = fun(res: String){
                reson.value += res + ";"
            }
            val chooseMember = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        var result = await(common.navigatoEvent("/pages/common/choosemember"))
                        console.log("响应", result)
                        if (result["id"] == null) {
                            return@w1
                        }
                        member.value = result
                })
            }
            return fun(): Any? {
                val _component_x_iconfont = resolveEasyComponent("x-iconfont", GenComponentsXIconfontClass)
                val _component_fui_dropdown_menu = resolveEasyComponent("fui-dropdown-menu", GenUniModulesFirstuiUvueComponentsFuiDropdownMenuFuiDropdownMenuClass)
                val _component_x_button = resolveEasyComponent("x-button", GenComponentsXButtonClass)
                val _component_x_calculator = resolveEasyComponent("x-calculator", GenComponentsXCalculatorClass)
                val _component_x_model = resolveEasyComponent("x-model", GenComponentsXModelClass)
                val _component_x_loading = resolveEasyComponent("x-loading", GenComponentsXLoadingClass)
                return _cE("view", null, _uA(
                    _cE("view", _uM("class" to "native padding-stauts-bar background-main display-flex", "style" to _nS(_uM("height" to (unref(titleHeight) + "px")))), _uA(
                        _cE("view", _uM("class" to "fanhui", "onClick" to back), _uA(
                            _cV(_component_x_iconfont, _uM("name" to "fanhui", "color" to "white", "size" to "18"))
                        )),
                        _cE("view", _uM("class" to "display-flex"), _uA(
                            _cV(_component_fui_dropdown_menu, _uM("maxHeight" to 324, "size" to 15, "selectedColor" to "#465CFF", "menus" to unref(menus), "onOnclick" to rangeItemClick, "onClose" to rangeClose, "ref_key" to "ddmRange", "ref" to ddmRange, "isCheckbox" to false), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "fui-filter__item display-flex", "onClick" to filterTap), _uA(
                                        _cE("text", _uM("class" to "fui-text name color-white"), _tD(unref(range)), 1),
                                        _cE("view", _uM("class" to _nC(_uA(
                                            "fui-filter__icon",
                                            _uM("fui-icon__ani" to unref(rangeShow))
                                        ))), _uA(
                                            _cV(_component_x_iconfont, _uM("class" to "xiaicon", "name" to "xiangxia1", "size" to "14", "color" to "white"))
                                        ), 2)
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "menus"
                            ))
                        ))
                    ), 4),
                    _cE("scroll-view", _uM("scroll-y" to true), _uA(
                        _cE("view", null, _uA(
                            if (unref(showCalc) == false) {
                                _cE("view", _uM("key" to 0, "class" to "basicinfo background-white display-flex"), _uA(
                                    _cE("view", _uM("class" to "leftaction info", "onClick" to chooseMember), _uA(
                                        _cE("text", _uM("class" to "title align-center"), "会员"),
                                        _cE("text", _uM("class" to "name align-center"), _tD(if (unref(member)["id"] == null) {
                                            "无会员"
                                        } else {
                                            unref(member)["nick"]
                                        }), 1)
                                    )),
                                    _cE("view", _uM("class" to "rightaction info", "onClick" to filterBillTap), _uA(
                                        _cE("text", _uM("class" to "title align-center"), "账目类型"),
                                        _cV(_component_fui_dropdown_menu, _uM("ref_key" to "billRange", "ref" to billRange, "maxHeight" to 324, "size" to 15, "selectedColor" to "#465CFF", "menus" to unref(bills), "onOnclick" to rangeItemBillClick, "onClose" to rangeBillClose, "isCheckbox" to false), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _cE("view", _uM("class" to "fui-filter__item display-flex"), _uA(
                                                    _cE("text", _uM("class" to "fui-text name color-white align-center"), _tD(unref(bill)), 1)
                                                ))
                                            )
                                        }), "_" to 1), 8, _uA(
                                            "menus"
                                        ))
                                    ))
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                            ,
                            _cE("view", _uM("class" to _nC(_uA(
                                "amount",
                                if (unref(calcNumber) > 0) {
                                    "amount-active"
                                } else {
                                    ""
                                }
                            )), "onClick" to showCalcMethod), _uA(
                                _cE("text", _uM("class" to "margin-center data"), _uA(
                                    _cE("text", _uM("class" to "fuhao color-white"), "￥"),
                                    _cE("text", _uM("class" to "number color-white font-bold"), _tD(unref(calcNumberStr)), 1)
                                ))
                            ), 2),
                            _cE("view", _uM("class" to "inputcontent background-white"), _uA(
                                _cE("text", _uM("class" to "inputbox align-right"), _tD(unref(calcStr)), 1)
                            )),
                            _cE("view", _uM("class" to "remarkbox background-white"), _uA(
                                _cE("textarea", _uM("placeholder" to "请输入备注", "class" to "textarea", "modelValue" to unref(reson), "onInput" to fun(`$event`: UniInputEvent){
                                    trySetRefValue(reson, `$event`.detail.value)
                                }
                                ), null, 40, _uA(
                                    "modelValue"
                                )),
                                _cE("view", _uM("class" to "feetype display-flex"), _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(unref(resonList), fun(item, index, __index, _cached): Any {
                                        return _cE("view", _uM("class" to "feetag", "key" to index, "onClick" to fun(){
                                            addReson(item)
                                        }
                                        ), _uA(
                                            _cE("text", _uM("class" to "text align-center"), _tD(item), 1)
                                        ), 8, _uA(
                                            "onClick"
                                        ))
                                    }
                                    ), 128),
                                    _cV(_component_x_iconfont, _uM("class" to "tagicon", "name" to "androidgengduo", "size" to "20", "color" to "#919191"))
                                ))
                            )),
                            if (isTrue(!unref(showCalc) && unref(calcNumber) > 0)) {
                                _cE("view", _uM("key" to 1, "class" to "startcash", "onClick" to startReceive), _uA(
                                    _cV(_component_x_button, _uM("class" to "casherbtn startbtn"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            "发起收款"
                                        )
                                    }), "_" to 1))
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                            ,
                            _cV(_component_x_calculator, _uM("isShow" to unref(showCalc), "onClose" to closePop, "onConfirm" to startReceive, "onStr" to replyStr, "onResult" to replyResult), null, 8, _uA(
                                "isShow"
                            )),
                            _cV(_component_x_model, _uM("ref_key" to "modal", "ref" to modal), null, 512),
                            _cV(_component_x_loading, _uM("ref" to "formloading"), null, 512)
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
                return _uM("fanhui" to _uM(".native " to _uM("paddingLeft" to "30rpx", "height" to 42, "paddingTop" to 13)), "name" to _uM(".native " to _uM("paddingLeft" to "12rpx", "paddingTop" to 11), ".basicinfo .info " to _uM("paddingTop" to 8, "fontSize" to 16, "color" to "#000000")), "text" to _uM(".native .name " to _uM("fontSize" to 16), ".remarkbox .feetype .feetag " to _uM("lineHeight" to "24px", "fontSize" to 14, "color" to "#616161")), "xiaicon" to _uM(".native " to _uM("paddingTop" to 15, "paddingLeft" to "8rpx")), "basicinfo" to _pS(_uM("marginTop" to 5, "height" to 65, "width" to "750rpx")), "leftaction" to _uM(".basicinfo " to _uM("paddingLeft" to "100rpx", "marginRight" to "auto")), "centeraction" to _uM(".basicinfo " to _uM("marginTop" to 0, "marginRight" to "auto", "marginBottom" to 0, "marginLeft" to "auto")), "rightaction" to _uM(".basicinfo " to _uM("marginLeft" to "auto", "marginRight" to "100rpx")), "title" to _uM(".basicinfo .info " to _uM("paddingTop" to 8, "fontSize" to 14, "color" to "#737373")), "amount" to _pS(_uM("width" to "750rpx", "height" to 163, "backgroundImage" to "none", "backgroundColor" to "#CCCCCC", "marginTop" to 8)), "fuhao" to _uM(".amount " to _uM("fontSize" to 30)), "number" to _uM(".amount " to _uM("fontSize" to 65)), "data" to _uM(".amount " to _uM("paddingTop" to 68)), "amount-active" to _pS(_uM("backgroundImage" to "none", "backgroundColor" to "#FFB400")), "startcash" to _pS(_uM("position" to "fixed", "bottom" to "var(--uni-safe-area-inset-bottom)", "marginBottom" to 20, "left" to "20rpx", "width" to "710rpx")), "inputcontent" to _pS(_uM("width" to "750rpx", "height" to 62, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#CCCCCC", "paddingLeft" to "10rpx", "paddingBottom" to "5rpx", "paddingRight" to "10rpx")), "remarkbox" to _pS(_uM("width" to "750rpx", "height" to 121, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#DEDEDE", "marginTop" to 7, "position" to "relative")), "textarea" to _uM(".remarkbox " to _uM("height" to 86, "paddingTop" to "10rpx", "paddingRight" to "10rpx", "paddingBottom" to "10rpx", "paddingLeft" to "10rpx", "fontSize" to 14)), "feetype" to _uM(".remarkbox " to _uM("position" to "absolute", "right" to "10rpx", "bottom" to "10rpx")), "feetag" to _uM(".remarkbox .feetype " to _uM("width" to 63, "height" to 26, "borderTopLeftRadius" to 13, "borderTopRightRadius" to 13, "borderBottomRightRadius" to 13, "borderBottomLeftRadius" to 13, "marginLeft" to 6, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#C2C2C2", "borderRightColor" to "#C2C2C2", "borderBottomColor" to "#C2C2C2", "borderLeftColor" to "#C2C2C2")), "tagicon" to _uM(".remarkbox .feetype " to _uM("marginLeft" to 10, "paddingTop" to 2.5)), "fui-filter__icon" to _pS(_uM("transitionProperty" to "transform", "transitionDuration" to "0.15s", "transitionTimingFunction" to "linear", "transform" to "rotate(0deg)")), "fui-icon__ani" to _pS(_uM("transform" to "rotate(180deg)")), "@TRANSITION" to _uM("fui-filter__icon" to _uM("property" to "transform", "duration" to "0.15s", "timingFunction" to "linear")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
