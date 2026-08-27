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
open class GenPagesComponentListViewListViewRefresh : BasePage {
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
    open var data: DataType__11
        get() {
            return unref(this.`$exposed`["data"]) as DataType__11
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesComponentListViewListViewRefresh, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesComponentListViewListViewRefresh
            val _cache = __ins.renderCache
            val item_count = ref(20)
            val list_show = ref(false)
            val data = reactive(DataType__11(refresherTriggered = true, refresherrefreshTest = "", onRefresherabortTest = "", onRefresherrestoreTest = "", onRefresherpullingTest = ""))
            fun gen_checkEventTest_fn(e: RefresherEventTest__1, eventName: String) {
                val isPass = e.type === eventName && e.target is UniElement && e.currentTarget is UniElement && e.dy > 0
                val result = if (isPass) {
                    "" + eventName + ":Success"
                } else {
                    "" + eventName + ":Fail"
                }
                when (eventName) {
                    "refresherrefresh" -> 
                        data.refresherrefreshTest = result
                    "refresherpulling" -> 
                        data.onRefresherpullingTest = result
                    "refresherrestore" -> 
                        data.onRefresherrestoreTest = result
                    "refresherabort" -> 
                        data.onRefresherabortTest = result
                    else -> 
                        {}
                }
            }
            val checkEventTest = ::gen_checkEventTest_fn
            fun gen_onRefresherrefresh_fn(e: UniRefresherEvent) {
                console.log("refresherrefresh-----下拉刷新被触发", e.detail.dy)
                data.refresherTriggered = true
                checkEventTest(RefresherEventTest__1(type = e.type, target = e.target, currentTarget = e.currentTarget, dy = e.detail.dy), "refresherrefresh")
                setTimeout(fun(){
                    data.refresherTriggered = false
                }
                , 1000)
            }
            val onRefresherrefresh = ::gen_onRefresherrefresh_fn
            fun gen_onRefresherabort_fn(e: UniRefresherEvent) {
                console.log("onRefresherabort------下拉刷新被中止", e.detail)
                checkEventTest(RefresherEventTest__1(type = e.type, target = e.target, currentTarget = e.currentTarget, dy = e.detail.dy), "refresherabort")
            }
            val onRefresherabort = ::gen_onRefresherabort_fn
            fun gen_onRefresherrestore_fn(e: UniRefresherEvent) {
                console.log("onRefresherrestore------下拉刷新被复位", e.detail.dy)
                checkEventTest(RefresherEventTest__1(type = e.type, target = e.target, currentTarget = e.currentTarget, dy = e.detail.dy), "refresherrestore")
            }
            val onRefresherrestore = ::gen_onRefresherrestore_fn
            fun gen_onRefresherpulling_fn(e: UniRefresherEvent) {
                console.log("onRefresherpulling------拉刷新控件被下拉-dy=" + e.detail.dy)
                checkEventTest(RefresherEventTest__1(type = e.type, target = e.target, currentTarget = e.currentTarget, dy = e.detail.dy), "refresherpulling")
            }
            val onRefresherpulling = ::gen_onRefresherpulling_fn
            onLoad(fun(_options){
                setTimeout(fun(){
                    list_show.value = true
                }
                , 500)
            }
            )
            __expose(_uM("data" to data))
            return fun(): Any? {
                return if (isTrue(unref(list_show))) {
                    _cE("list-view", _uM("key" to 0, "id" to "listview", "style" to _nS(_uM("flex" to "1")), "show-scrollbar" to "false", "refresher-enabled" to true, "refresher-triggered" to unref(data).refresherTriggered, "onRefresherrefresh" to onRefresherrefresh, "onRefresherabort" to onRefresherabort, "onRefresherrestore" to onRefresherrestore, "onRefresherpulling" to onRefresherpulling), _uA(
                        _cE("list-item", _uM("class" to "item"), _uA(
                            _cE("text", null, "向下滑动触发下拉刷新")
                        )),
                        _cE(Fragment, null, RenderHelpers.renderList(unref(item_count), fun(index, __key, __index, _cached): Any {
                            return _cE("list-item", _uM("key" to index, "class" to "item"), _uA(
                                _cE("text", null, "item-------" + _tD(index), 1)
                            ))
                        }), 128)
                    ), 44, _uA(
                        "refresher-triggered"
                    ))
                } else {
                    _cC("v-if", true)
                }
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("item" to _pS(_uM("paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15, "marginTop" to 0, "marginRight" to 0, "marginBottom" to 5, "marginLeft" to 0, "backgroundColor" to "#ffffff", "borderTopLeftRadius" to 5, "borderTopRightRadius" to 5, "borderBottomRightRadius" to 5, "borderBottomLeftRadius" to 5)), "button_item" to _pS(_uM("width" to 200)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
