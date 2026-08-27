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
open class GenPagesAPIGetFileSystemManagerTestStatic : BasePage {
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
    open var data: DataType__111
        get() {
            return unref(this.`$exposed`["data"]) as DataType__111
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var testAccessFile: () -> Unit
        get() {
            return unref(this.`$exposed`["testAccessFile"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "testAccessFile", value)
        }
    open var testAccessDir: () -> Unit
        get() {
            return unref(this.`$exposed`["testAccessDir"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "testAccessDir", value)
        }
    open var testCopyFile: () -> Unit
        get() {
            return unref(this.`$exposed`["testCopyFile"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "testCopyFile", value)
        }
    open var testReadFile: () -> Unit
        get() {
            return unref(this.`$exposed`["testReadFile"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "testReadFile", value)
        }
    open var testReadDir: () -> Unit
        get() {
            return unref(this.`$exposed`["testReadDir"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "testReadDir", value)
        }
    open var testFstatFile: () -> Unit
        get() {
            return unref(this.`$exposed`["testFstatFile"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "testFstatFile", value)
        }
    open var testReadZipEntry: () -> Unit
        get() {
            return unref(this.`$exposed`["testReadZipEntry"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "testReadZipEntry", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIGetFileSystemManagerTestStatic, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIGetFileSystemManagerTestStatic
            val _cache = __ins.renderCache
            val log = ref("")
            val staticPath = ref("/static/filemanager/to.zip")
            val data = reactive(DataType__111(logAble = true, isSuccess = false))
            fun gen_openFileSyncTest_fn(param: String): String {
                val fileManager = uni_getFileSystemManager()
                var fd = fileManager.openSync(OpenFileSyncOptions(filePath = staticPath.value, flag = param))
                return fd
            }
            val openFileSyncTest = ::gen_openFileSyncTest_fn
            fun gen_testReadZipEntry_fn() {
                val fileManager = uni_getFileSystemManager()
                fileManager.readZipEntry(ReadZipEntryOptions(filePath = staticPath.value, encoding = "utf-8", success = fun(res: EntriesResult){
                    if (data.logAble) {
                        log.value += "testReadZipEntry success\n\n"
                    }
                    console.log("testReadZipEntry success", res)
                    data.isSuccess = true
                }
                , fail = fun(res: IUniError){
                    if (data.logAble) {
                        log.value += "testReadZipEntry fail:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("testReadZipEntry fail", res)
                    data.isSuccess = false
                }
                ))
            }
            val testReadZipEntry = ::gen_testReadZipEntry_fn
            fun gen_testFstatFile_fn() {
                val fileManager = uni_getFileSystemManager()
                fileManager.fstat(FStatOptions(fd = openFileSyncTest("r"), success = fun(res: FStatSuccessResult){
                    if (data.logAble) {
                        log.value += "testFstatFile success:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("testFstatFile success", res)
                    data.isSuccess = true
                }
                , fail = fun(res: IUniError){
                    if (data.logAble) {
                        log.value += "testFstatFile fail:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("testFstatFile fail", res)
                    data.isSuccess = false
                }
                ))
            }
            val testFstatFile = ::gen_testFstatFile_fn
            fun gen_testAccessFile_fn() {
                val fileManager = uni_getFileSystemManager()
                fileManager.access(AccessOptions(path = staticPath.value, success = fun(res: FileManagerSuccessResult){
                    if (data.logAble) {
                        log.value += "testAccessFile success:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("success", res)
                    data.isSuccess = true
                }
                , fail = fun(res: IUniError){
                    if (data.logAble) {
                        log.value += "testAccessFile fail:" + JSON.stringify(res) + "\n\n"
                    }
                    data.isSuccess = false
                }
                ))
            }
            val testAccessFile = ::gen_testAccessFile_fn
            fun gen_testAccessDir_fn() {
                val fileManager = uni_getFileSystemManager()
                fileManager.access(AccessOptions(path = "/static/filemanager", success = fun(res: FileManagerSuccessResult){
                    if (data.logAble) {
                        log.value += "testAccessDir success:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("success", res)
                    data.isSuccess = true
                }
                , fail = fun(res: IUniError){
                    if (data.logAble) {
                        log.value += "testAccessDir fail:" + JSON.stringify(res) + "\n\n"
                    }
                    data.isSuccess = false
                }
                ))
            }
            val testAccessDir = ::gen_testAccessDir_fn
            fun gen_testReadFile_fn() {
                var fileManager = uni_getFileSystemManager()
                fileManager.readFile(ReadFileOptions(filePath = staticPath.value, encoding = "utf-8", success = fun(res: ReadFileSuccessResult){
                    if (data.logAble) {
                        log.value += "testReadFile success:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("testReadFile success", res)
                    data.isSuccess = true
                }
                , fail = fun(res: IUniError){
                    if (data.logAble) {
                        log.value += "testReadFile fail:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("testReadFile", res)
                    data.isSuccess = false
                }
                ))
            }
            val testReadFile = ::gen_testReadFile_fn
            fun gen_testReadDir_fn() {
                var fileManager = uni_getFileSystemManager()
                fileManager.readdir(ReadDirOptions(dirPath = "/static/filemanager", success = fun(res: ReadDirSuccessResult){
                    if (data.logAble) {
                        log.value += "testReadDir success:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("testReadDir success", res)
                    data.isSuccess = true
                }
                , fail = fun(res: IUniError){
                    if (data.logAble) {
                        log.value += "testReadDir fail:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("testReadDir", res)
                    data.isSuccess = false
                }
                ))
            }
            val testReadDir = ::gen_testReadDir_fn
            fun gen_testCopyFile_fn() {
                var fileManager = uni_getFileSystemManager()
                fileManager.copyFile(CopyFileOptions(srcPath = staticPath.value, destPath = "" + uni_env.USER_DATA_PATH + "/filemanager/to.zip", success = fun(res: FileManagerSuccessResult){
                    if (data.logAble) {
                        log.value += "testCopyFile success:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("testCopyFile success", res)
                    data.isSuccess = true
                }
                , fail = fun(res: IFileSystemManagerFail){
                    if (data.logAble) {
                        log.value += "testCopyFile fail:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("testCopyFile", res)
                    data.isSuccess = false
                }
                ))
            }
            val testCopyFile = ::gen_testCopyFile_fn
            __expose(_uM("data" to data, "testAccessFile" to testAccessFile, "testAccessDir" to testAccessDir, "testCopyFile" to testCopyFile, "testReadFile" to testReadFile, "testReadDir" to testReadDir, "testFstatFile" to testFstatFile, "testReadZipEntry" to testReadZipEntry))
            return fun(): Any? {
                return _cE(Fragment, null, _uA(
                    _cE("text", null, "查看通过uni.getFileSystemManager()直接处理Static目录的操作日志"),
                    _cE("button", _uM("size" to "mini", "onClick" to fun(){
                        log.value = ""
                    }
                    ), "清空日志", 8, _uA(
                        "onClick"
                    )),
                    _cE("scroll-view", _uM("style" to _nS(_uM("max-height" to "300px"))), _uA(
                        _cE("text", _uM("style" to _nS(_uM("margin" to "2px", "padding" to "2px", "border" to "1px solid #000000"))), _tD(unref(log)), 5)
                    ), 4),
                    _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to testAccessFile, "id" to "testAccessFile"), "判断Static中的文件是否存在"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to testAccessDir, "id" to "testAccessDir"), "判断Static中的目录是否存在"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to testCopyFile, "id" to "testCopyFile"), "复制Static中的文件"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to testReadFile, "id" to "testReadFile"), "读取Static中的文件"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to testReadDir, "id" to "testReadDir"), "读取Static中filemanager目录内文件列表"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to testFstatFile, "id" to "testFstatFile"), "获取Static中的文件状态信息"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to testReadZipEntry, "id" to "testReadZipEntry"), "获取Static中压缩包内的文件")
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
