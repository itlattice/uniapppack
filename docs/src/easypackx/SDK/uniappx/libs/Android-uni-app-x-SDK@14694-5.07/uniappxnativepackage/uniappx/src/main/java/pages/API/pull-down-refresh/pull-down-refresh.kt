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
import io.dcloud.uniapp.extapi.startPullDownRefresh as uni_startPullDownRefresh
import io.dcloud.uniapp.extapi.stopPullDownRefresh as uni_stopPullDownRefresh
open class GenPagesAPIPullDownRefreshPullDownRefresh : BasePage {
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
    open var data: DataType__59
        get() {
            return unref(this.`$exposed`["data"]) as DataType__59
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIPullDownRefreshPullDownRefresh, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIPullDownRefreshPullDownRefresh
            val _cache = __ins.renderCache
            val listData = ref(_uA<Number>())
            val loadMoreText = ref("加载中...")
            val showLoadMore = ref(false)
            val max = ref(0)
            val data = reactive(DataType__59(pulldownRefreshTriggered = false, startPullDownRefreshStaus = false, stopPullDownRefreshStatus = false))
            fun gen_initData_fn() {
                setTimeout(fun(){
                    max.value = 0
                    listData.value = _uA()
                    var dataArr: UTSArray<Number> = _uA()
                    max.value += 20
                    run {
                        var i: Number = max.value - 19
                        while(i < max.value + 1){
                            dataArr.push(i)
                            i++
                        }
                    }
                    listData.value = listData.value.concat(dataArr)
                    uni_stopPullDownRefresh()
                }
                , 1000)
            }
            val initData = ::gen_initData_fn
            fun gen_setListData_fn() {
                var dataArr: UTSArray<Number> = _uA()
                max.value += 10
                run {
                    var i: Number = max.value - 9
                    while(i < max.value + 1){
                        dataArr.push(i)
                        i++
                    }
                }
                listData.value = listData.value.concat(dataArr)
            }
            val setListData = ::gen_setListData_fn
            onReady(fun(){
                var status = false
                uni_startPullDownRefresh(StartPullDownRefreshOptions(success = fun(_) {
                    status = true
                }
                , fail = fun(_) {
                    status = false
                }
                , complete = fun(_){
                    data.startPullDownRefreshStaus = status
                }
                ))
                initData()
            }
            )
            onReachBottom(fun(){
                console.log("onReachBottom")
                if (max.value > 40) {
                    loadMoreText.value = "没有更多数据了!"
                    return
                }
                showLoadMore.value = true
                setTimeout(fun(){
                    setListData()
                }
                , 300)
            }
            )
            onPullDownRefresh(fun(){
                console.log("onPullDownRefresh")
                data.pulldownRefreshTriggered = true
                initData()
            }
            )
            __expose(_uM("data" to data))
            return fun(): Any? {
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("class" to "uni-padding-wrap uni-common-mt"), _uA(
                        _cE(Fragment, null, RenderHelpers.renderList(unref(listData), fun(num, index, __index, _cached): Any {
                            return _cE("text", _uM("class" to "text", "key" to index), "list - " + _tD(num), 1)
                        }
                        ), 128),
                        if (isTrue(unref(showLoadMore))) {
                            _cE("view", _uM("key" to 0), _tD(unref(loadMoreText)), 1)
                        } else {
                            _cC("v-if", true)
                        }
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
                return _uM("text" to _pS(_uM("marginTop" to 6, "marginRight" to 0, "marginBottom" to 6, "marginLeft" to 0, "width" to "100%", "backgroundColor" to "#ffffff", "height" to 52, "lineHeight" to "52px", "textAlign" to "center", "color" to "#555555", "borderTopLeftRadius" to 4, "borderTopRightRadius" to 4, "borderBottomRightRadius" to 4, "borderBottomLeftRadius" to 4)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
