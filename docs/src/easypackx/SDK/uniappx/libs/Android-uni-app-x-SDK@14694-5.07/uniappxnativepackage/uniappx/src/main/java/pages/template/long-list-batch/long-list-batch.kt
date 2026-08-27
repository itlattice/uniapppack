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
open class GenPagesTemplateLongListBatchLongListBatch : BasePage {
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
        var setup: (__props: GenPagesTemplateLongListBatchLongListBatch) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesTemplateLongListBatchLongListBatch
            val _cache = __ins.renderCache
            open class Jobs {
                private var jobs: UTSArray<(() -> UTSPromise<Unit>)> = _uA()
                open var paused: Boolean = true
                constructor(){}
                open fun add(job: () -> UTSPromise<Unit>) {
                    this.jobs.push(job)
                }
                open fun pause() {
                    this.paused = true
                }
                private fun execute() {
                    if (this.paused) {
                        return
                    }
                    if (this.jobs.length == 0) {
                        this.paused = true
                        return
                    }
                    val job = this.jobs.shift()
                    if (job != null) {
                        job().then(fun(){
                            this.execute()
                        }
                        )
                    }
                }
                open fun resume() {
                    if (!this.paused) {
                        return
                    }
                    this.paused = false
                    setTimeout(fun(){
                        this.execute()
                    }
                    , 0)
                }
                open fun reset() {
                    this.jobs = _uA()
                    this.paused = true
                }
                open val done: Boolean
                    get(): Boolean {
                        return this.jobs.length == 0
                    }
            }
            fun gen_delay_fn(time: Number): UTSPromise<Unit> {
                return UTSPromise(fun(resolve, _reject){
                    setTimeout(fun(){
                        resolve(Unit)
                    }
                    , time)
                }
                )
            }
            val delay = ::gen_delay_fn
            val bigList = ref(_uA<Item__13>())
            val list = ref(_uA<Item__13>())
            val jobs = ref<Jobs>(Jobs())
            val batchSize = ref<Number>(100)
            var scrolling = false
            val refresherTriggered = ref<Boolean>(false)
            var scrollendTimeout: Number = -1
            var pulling = false
            fun init(autoResumeJobs: Boolean = true) {
                val batchCount = Math.ceil(bigList.value.length / batchSize.value)
                run {
                    var i: Number = 0
                    while(i < batchCount){
                        val start = i * batchSize.value
                        val end = Math.min(start + batchSize.value, bigList.value.length)
                        jobs.value.add(fun(): UTSPromise<Unit> {
                            return wrapUTSPromise(suspend {
                                    list.value.push(*bigList.value.slice(start, end).toTypedArray())
                                    await(nextTick())
                                    await(delay(100))
                            })
                        }
                        )
                        i++
                    }
                }
                if (autoResumeJobs) {
                    jobs.value.resume()
                }
            }
            val onScrollEnd = fun(){
                scrolling = false
                jobs.value.resume()
            }
            val onScroll = fun(){
                clearTimeout(scrollendTimeout)
                scrollendTimeout = setTimeout(fun(){
                    onScrollEnd()
                }
                , 100)
                if (scrolling) {
                    return
                }
                scrolling = true
                jobs.value.pause()
            }
            val onScrollToLower = fun(){
                if (!jobs.value.done) {
                    return
                }
            }
            val onRefresh = fun(){
                jobs.value.reset()
                refresherTriggered.value = true
                setTimeout(fun(){
                    refresherTriggered.value = false
                    list.value.splice(0, list.value.length)
                    init(false)
                }
                , 500)
            }
            val onRefresherPulling = fun(){
                if (pulling) {
                    return
                }
                pulling = true
                jobs.value.pause()
            }
            val onRefresherRestore = fun(){
                pulling = false
                jobs.value.resume()
            }
            run {
                var i: Number = 0
                while(i < 2000){
                    bigList.value.push(Item__13(id = i, name = "Wifi_" + i, info = "信号强度: -" + (Math.floor(Math.random() * 60) + 40) + " db, 安全性: WPA/WPA2/WPA3-Personal"))
                    i++
                }
            }
            onReady(fun(){
                init()
            }
            )
            return fun(): Any? {
                return _cE("view", _uM("style" to _nS(_uM("flex" to "1", "background-color" to "aliceblue"))), _uA(
                    _cE("view", _uM("class" to "tips"), "list-view组件虽然在渲染层有recycle机制，但长列表的vnode/Element太多也会造成初始化卡顿。 本示例有2000条数据，通过分批创建列表项，减少初始化卡顿。并通过闲时创建机制避免影响列表滚动等UI操作"),
                    _cE("list-view", _uM("style" to _nS(_uM("flex" to "1")), "refresher-enabled" to true, "refresher-triggered" to unref(refresherTriggered), "onScroll" to onScroll, "onScrolltolower" to onScrollToLower, "onRefresherrefresh" to onRefresh, "onRefresherpulling" to onRefresherPulling, "onRefresherrestore" to onRefresherRestore), _uA(
                        _cE(Fragment, null, RenderHelpers.renderList(unref(list), fun(item, index, __index, _cached): Any {
                            return _cE("list-item", _uM("class" to "item", "key" to (index + "_" + item.id)), _uA(
                                _cE("view", null, _uA(
                                    _cE("text", null, _tD(item.name), 1)
                                )),
                                _cE("view", null, _uA(
                                    _cE("text", _uM("style" to _nS(_uM("font-size" to "12px", "color" to "#999999"))), _tD(item.info), 5)
                                ))
                            ))
                        }
                        ), 128)
                    ), 44, _uA(
                        "refresher-triggered"
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
                return _uM("tips" to _pS(_uM("marginTop" to 10, "marginRight" to 10, "marginBottom" to 10, "marginLeft" to 10, "borderTopLeftRadius" to 5, "borderTopRightRadius" to 5, "borderBottomRightRadius" to 5, "borderBottomLeftRadius" to 5, "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "backgroundColor" to "#FFFFFF")), "item" to _pS(_uM("marginTop" to 5, "marginRight" to 10, "marginBottom" to 5, "marginLeft" to 10, "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "borderTopLeftRadius" to 5, "borderTopRightRadius" to 5, "borderBottomRightRadius" to 5, "borderBottomLeftRadius" to 5, "backgroundColor" to "#FFFFFF")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
