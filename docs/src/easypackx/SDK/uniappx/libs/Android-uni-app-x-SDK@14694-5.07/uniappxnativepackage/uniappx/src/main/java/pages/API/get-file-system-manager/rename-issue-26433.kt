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
open class GenPagesAPIGetFileSystemManagerRenameIssue26433 : BasePage {
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
    open var data: DataType__112
        get() {
            return unref(this.`$exposed`["data"]) as DataType__112
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIGetFileSystemManagerRenameIssue26433, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIGetFileSystemManagerRenameIssue26433
            val _cache = __ins.renderCache
            val data = reactive(DataType__112(log = "", logAble = true, renamePath = "", basePath = uni_env.USER_DATA_PATH))
            fun gen_renameDir_fn() {
                val fileManager = uni_getFileSystemManager()
                val oldPath = "" + data.basePath + "uni-store"
                val newPath = "" + data.basePath + "uni-store2"
                try {
                    fileManager.mkdirSync(oldPath, true)
                    if (data.logAble) {
                        data.log += "mkdir uni-store success\n\n"
                    }
                }
                 catch (e: Throwable) {
                    if (data.logAble) {
                        data.log += "mkdir uni-store: " + JSON.stringify(e) + "\n\n"
                    }
                }
                fileManager.rename(RenameOptions(oldPath = oldPath, newPath = newPath, success = fun(res){
                    console.log(res)
                    data.renamePath = newPath
                    if (data.logAble) {
                        data.log += "renameDir success:" + newPath + "\n\n"
                    }
                }
                , fail = fun(err){
                    console.log(err)
                    if (data.logAble) {
                        data.log += "renameDir fail:" + JSON.stringify(err) + "\n\n"
                    }
                }
                ))
            }
            val renameDir = ::gen_renameDir_fn
            fun gen_renameFile_fn() {
                val fileManager = uni_getFileSystemManager()
                val dirPath = "" + data.basePath + "uni-store"
                val oldFilePath = "" + dirPath + "/1.txt"
                val newFilePath = "" + dirPath + "/2.txt"
                try {
                    fileManager.mkdirSync(dirPath, true)
                    if (data.logAble) {
                        data.log += "mkdir uni-store success\n\n"
                    }
                }
                 catch (e: Throwable) {
                    if (data.logAble) {
                        data.log += "mkdir uni-store: " + JSON.stringify(e) + "\n\n"
                    }
                }
                try {
                    fileManager.writeFileSync(oldFilePath, "test content", "utf-8")
                    if (data.logAble) {
                        data.log += "create 1.txt success\n\n"
                    }
                }
                 catch (e: Throwable) {
                    if (data.logAble) {
                        data.log += "create 1.txt: " + JSON.stringify(e) + "\n\n"
                    }
                }
                fileManager.rename(RenameOptions(oldPath = oldFilePath, newPath = newFilePath, success = fun(res){
                    console.log(res)
                    data.renamePath = newFilePath
                    if (data.logAble) {
                        data.log += "renameFile success:" + newFilePath + "\n\n"
                    }
                }
                , fail = fun(err){
                    console.log(err)
                    if (data.logAble) {
                        data.log += "renameFile fail:" + JSON.stringify(err) + "\n\n"
                    }
                }
                ))
            }
            val renameFile = ::gen_renameFile_fn
            __expose(_uM("data" to data))
            return fun(): Any? {
                return _cE(Fragment, null, _uA(
                    _cE("text", null, "显示简易操作日志(可滚动查看),详细日志需真机运行查看"),
                    _cE("button", _uM("size" to "mini", "onClick" to fun(){
                        unref(data).log = ""
                    }
                    ), "清空日志", 8, _uA(
                        "onClick"
                    )),
                    _cE("scroll-view", _uM("style" to _nS(_uM("max-height" to "300px"))), _uA(
                        _cE("text", _uM("style" to _nS(_uM("margin" to "2px", "padding" to "2px", "border" to "1px solid #000000"))), _tD(unref(data).log), 5)
                    ), 4),
                    _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to renameDir, "id" to "renameDir"), "renameDir"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to renameFile, "id" to "renameFile"), "renameFile"),
                        _cE("view", _uM("style" to _nS(_uM("height" to "4px"))), null, 4)
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
                return _uM("btnstyle" to _pS(_uM("marginTop" to 4, "marginRight" to 4, "marginBottom" to 4, "marginLeft" to 4)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
