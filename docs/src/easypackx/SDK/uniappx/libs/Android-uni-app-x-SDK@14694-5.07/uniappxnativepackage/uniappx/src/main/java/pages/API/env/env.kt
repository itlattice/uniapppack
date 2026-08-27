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
import io.dcloud.uniapp.extapi.env as uni_env
import io.dcloud.uniapp.extapi.getFileSystemManager as uni_getFileSystemManager
open class GenPagesAPIEnvEnv : BasePage {
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
        var setup: (__props: GenPagesAPIEnvEnv) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIEnvEnv
            val _cache = __ins.renderCache
            val data = reactive(DataType__61(result = "", error = "", list = _uA(), recursive = false, cachePath = uni_env.CACHE_PATH, sandboxPath = uni_env.SANDBOX_PATH, androidInternalSandboxPath = uni_env.ANDROID_INTERNAL_SANDBOX_PATH))
            val switchRecursive = fun(){
                data.recursive = !data.recursive
            }
            val getDirInfo = fun(dirPath: String){
                val fm = uni_getFileSystemManager()
                data.list = _uA()
                fm.stat(StatOptions(path = dirPath, recursive = data.recursive, success = fun(res: StatSuccessResult){
                    data.result = "获取 \"" + dirPath + "\" 成功(success)"
                    console.log(data.result)
                    res.stats.forEach(fun(item){
                        data.list.push(StatInfo(path = item.path, size = "" + item.stats.size + " Bytes"))
                    }
                    )
                }
                , fail = fun(err){
                    data.result = "获取 \"" + dirPath + "\" 失败(fail)"
                    console.log(data.result)
                    data.error = JSON.stringify(err)
                    console.log(data.error)
                }
                ))
            }
            return fun(): Any? {
                val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass)
                val _component_page_intro = resolveEasyComponent("page-intro", GenComponentsPageIntroPageIntroClass)
                val _component_boolean_data = resolveEasyComponent("boolean-data", GenComponentsBooleanDataBooleanDataClass)
                return _cE(Fragment, null, _uA(
                    _cE("view", _uM("style" to _nS(_uM("margin" to "12px"))), _uA(
                        _cV(_component_page_head, _uM("title" to "环境变量 - 文件系统")),
                        _cV(_component_page_intro, _uM("content" to "本页演示 uni.env 文件系统路径：点击按钮查看 USER_DATA_PATH、CACHE_PATH、SANDBOX_PATH 等目录信息，可开关递归获取。")),
                        _cE("button", _uM("class" to "button", "type" to "primary", "onClick" to fun(){
                            getDirInfo(uni_env.USER_DATA_PATH)
                        }
                        ), "USER_DATA_PATH", 8, _uA(
                            "onClick"
                        )),
                        _cE("button", _uM("class" to "button", "type" to "primary", "onClick" to fun(){
                            getDirInfo(unref(data).cachePath)
                        }
                        ), "CACHE_PATH", 8, _uA(
                            "onClick"
                        )),
                        _cE("button", _uM("class" to "button", "type" to "primary", "onClick" to fun(){
                            getDirInfo(unref(data).sandboxPath)
                        }
                        ), "SANDBOX_PATH", 8, _uA(
                            "onClick"
                        )),
                        _cE("button", _uM("class" to "button", "type" to "primary", "onClick" to fun(){
                            getDirInfo(unref(data).androidInternalSandboxPath)
                        }
                        ), "ANDROID_INTERNAL_SANDBOX_PATH", 8, _uA(
                            "onClick"
                        )),
                        _cV(_component_boolean_data, _uM("defaultValue" to false, "title" to "是否递归获取", "onChange" to switchRecursive))
                    ), 4),
                    _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1", "padding" to "16px 0px"))), _uA(
                        _cE("text", _uM("class" to "result"), _tD(unref(data).result), 1),
                        _cE("text", _uM("class" to "error"), _tD(unref(data).error), 1),
                        _cE(Fragment, null, RenderHelpers.renderList(unref(data).list, fun(stat, index, __index, _cached): Any {
                            return _cE("view", _uM("class" to "stat", "key" to index), _uA(
                                _cE("text", _uM("class" to "path"), _tD(stat.path), 1),
                                _cE("text", _uM("class" to "size"), _tD(stat.size), 1)
                            ))
                        }
                        ), 128)
                    ), 4)
                ), 64)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("button" to _pS(_uM("marginBottom" to 4, "whiteSpace" to "nowrap", "textOverflow" to "ellipsis")), "result" to _pS(_uM("fontSize" to 18, "fontWeight" to "bold", "textAlign" to "center", "width" to "100%")), "error" to _pS(_uM("color" to "#B22222")), "stat" to _pS(_uM("paddingTop" to 8, "paddingRight" to 16, "paddingBottom" to 8, "paddingLeft" to 16)), "path" to _pS(_uM("color" to "#A9A9A9")), "size" to _pS(_uM("color" to "#A9A9A9")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
