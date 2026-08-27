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
import io.dcloud.uniapp.extapi.chooseFile as uni_chooseFile
import io.dcloud.uniapp.extapi.chooseImage as uni_chooseImage
import io.dcloud.uniapp.extapi.env as uni_env
import io.dcloud.uniapp.extapi.getFileSystemManager as uni_getFileSystemManager
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
open class GenPagesAPIGetFileSystemManagerGetFileSystemManager : BasePage {
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
    open var data: DataType__110
        get() {
            return unref(this.`$exposed`["data"]) as DataType__110
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    open var testOpenFlagWrite: () -> Unit
        get() {
            return unref(this.`$exposed`["testOpenFlagWrite"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "testOpenFlagWrite", value)
        }
    open var testWriteLongString: () -> Unit
        get() {
            return unref(this.`$exposed`["testWriteLongString"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "testWriteLongString", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesAPIGetFileSystemManagerGetFileSystemManager, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesAPIGetFileSystemManagerGetFileSystemManager
            val _cache = __ins.renderCache
            val data = reactive(DataType__110(log = "", logAble = true, fileListSuccess = _uA<String>(), fileListComplete = _uA<String>(), accessFileRet = "", lastFailError = UniError("uni-file-manager", 1300000, "mock error"), lastCompleteError = UniError("uni-file-manager", 1300000, "mock error"), readDir = "a", readFileRet = "", writeFileContent = "中文 en.\r\n\t换行", appendFileContent = "append content", getFileInfoAlgorithm = "md5", getFileInfoSize = -1, getFileInfoDigest = "", unlinkFile = "a/1.txt", accessFile = "a/1.txt", writeFile = "a/1.txt", writeData = "insert data哈哈哈", brFile = "a/1.txt.br", temFile = "a/1.txt", copyFromFile = "a/1.txt", copyToFile = "a/2.txt", renameFromFile = "a/2.txt", renameToFile = "a/3.txt", getFileInfoFile = "a/1.txt", statFile = "", rmDirFile = "a", mkdirFile = "a", readFile = "a/1.txt", recursiveVal = true, done = false, writeFileEncoding = "utf-8", readFileEncoding = "utf-8", statsRet = _uA<FileStats>(), unzipFile = "zip/1.zip", targetZip = "unzip", renameFileRet = "", saveFileRet = "", removeSavedFileRet = "", fd = "", closeFileRet = "", bytesWritten = 0, fstat = null as Stats?, fstatSize = 0, ftruncateRet = "", readZipFile = "to.zip", getSavedFileListRet = "", arrayBufferRes = 0, testOpenFlataplusWrite = false, basePath = uni_env.USER_DATA_PATH, copyToBasePath = uni_env.USER_DATA_PATH, globalTempPath = uni_env.CACHE_PATH, globalRootPath = uni_env.SANDBOX_PATH, globalUserDataPath = uni_env.USER_DATA_PATH))
            val statFileInfoTest = fun(_: Any){
                val fileManager = uni_getFileSystemManager()
                fileManager.stat(StatOptions(path = "" + data.basePath + data.statFile, recursive = data.recursiveVal, success = fun(res: StatSuccessResult){
                    if (data.logAble) {
                        data.log += "statFileInfoTest success:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("statFileInfoTest success", res)
                    data.statsRet = res.stats
                    console.log("data.statsRet", data.statsRet)
                }
                , fail = fun(res: IUniError){
                    if (data.logAble) {
                        data.log += "statFileInfoTest fail:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("statFileInfoTest fail", res)
                    data.lastFailError = UniError(res.errSubject, res.errCode, res.errMsg)
                }
                , complete = fun(res: Any){
                    console.log("statFileInfoTest complete", res)
                    data.done = true
                    if (res is UniError) {
                        data.lastCompleteError = res as UniError
                    }
                }
                ))
            }
            val getFileInfoTest = fun(){
                val fileManager = uni_getFileSystemManager()
                fileManager.getFileInfo(GetFileInfoOptions(filePath = "" + data.basePath + data.getFileInfoFile, digestAlgorithm = data.getFileInfoAlgorithm, success = fun(res: GetFileInfoSuccessResult){
                    if (data.logAble) {
                        data.log += "getFileInfoTest success:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("success", res)
                    data.getFileInfoSize = res.size
                    data.getFileInfoDigest = res.digest
                }
                , fail = fun(res: IUniError){
                    if (data.logAble) {
                        data.log += "getFileInfoTest fail:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("fail", res)
                    data.lastFailError = UniError(res.errSubject, res.errCode, res.errMsg)
                }
                , complete = fun(res: Any){
                    console.log("complete", res)
                    data.done = true
                    if (res is UniError) {
                        data.lastCompleteError = res as UniError
                    }
                }
                ))
            }
            val copyFileTest = fun(){
                val fileManager = uni_getFileSystemManager()
                fileManager.copyFile(CopyFileOptions(srcPath = "" + data.basePath + data.copyFromFile, destPath = "" + data.copyToBasePath + data.copyToFile, success = fun(res: FileManagerSuccessResult){
                    if (data.logAble) {
                        data.log += "copyFileTest success:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("success", res)
                }
                , fail = fun(res: IUniError){
                    if (data.logAble) {
                        data.log += "copyFileTest fail:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("fail", res)
                    data.lastFailError = UniError(res.errSubject, res.errCode, res.errMsg)
                }
                , complete = fun(res: Any){
                    console.log("complete", res)
                    data.done = true
                    if (res is UniError) {
                        data.lastCompleteError = res as UniError
                    }
                }
                ))
            }
            val renameFileTest = fun(){
                val fileManager = uni_getFileSystemManager()
                fileManager.rename(RenameOptions(oldPath = "" + data.basePath + data.renameFromFile, newPath = "" + data.basePath + data.renameToFile, success = fun(res){
                    if (data.logAble) {
                        data.log += "renameFileTest success:" + JSON.stringify(res) + "\n\n"
                    }
                    data.renameFileRet = "rename:ok"
                    console.log("success", res)
                }
                , fail = fun(res: IUniError){
                    if (data.logAble) {
                        data.log += "renameFileTest fail:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("fail", res)
                    data.lastFailError = UniError(res.errSubject, res.errCode, res.errMsg)
                }
                , complete = fun(res: Any){
                    data.done = true
                    console.log("complete", res)
                    if (res is UniError) {
                        data.lastCompleteError = res as UniError
                    }
                }
                ))
            }
            val readDirTest = fun(){
                val fileManager = uni_getFileSystemManager()
                fileManager.readdir(ReadDirOptions(dirPath = "" + data.basePath + data.readDir, success = fun(res: ReadDirSuccessResult){
                    if (data.logAble) {
                        data.log += "readDirTest success:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("success", res)
                    data.fileListSuccess = res.files
                }
                , fail = fun(res: IUniError){
                    if (data.logAble) {
                        data.log += "readDirTest fail:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("fail", res)
                    data.lastFailError = UniError(res.errSubject, res.errCode, res.errMsg)
                }
                , complete = fun(res: Any){
                    console.log("complete", res)
                    data.done = true
                    if (res is UniError) {
                        data.lastCompleteError = res as UniError
                    } else {
                        data.fileListComplete = (res as ReadDirSuccessResult).files
                    }
                }
                ))
            }
            val writeFileTest = fun(_: Any){
                val fileManager = uni_getFileSystemManager()
                fileManager.writeFile(WriteFileOptions(filePath = "" + data.basePath + data.writeFile, data = data.writeFileContent, encoding = data.writeFileEncoding, success = fun(res){
                    if (data.logAble) {
                        data.log += "writeFileTest success:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("success", res)
                }
                , fail = fun(res: IUniError){
                    if (data.logAble) {
                        data.log += "writeFileTest fail:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("fail")
                    data.lastFailError = UniError(res.errSubject, res.errCode, res.errMsg)
                }
                , complete = fun(res: Any){
                    data.done = true
                    console.log("complete")
                    if (res is UniError) {
                        data.lastCompleteError = res as UniError
                    }
                }
                ))
            }
            val readFileTest = fun(){
                val fileManager = uni_getFileSystemManager()
                fileManager.readFile(ReadFileOptions(filePath = "" + data.basePath + data.readFile, encoding = data.readFileEncoding, success = fun(res: ReadFileSuccessResult){
                    if (data.logAble) {
                        data.log += "readFileTest success:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("success", res)
                    data.readFileRet = res.data.toString()
                }
                , fail = fun(res: IUniError){
                    if (data.logAble) {
                        data.log += "readFileTest fail:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("fail", res)
                    data.lastFailError = UniError(res.errSubject, res.errCode, res.errMsg)
                }
                , complete = fun(res: Any){
                    console.log("complete", res)
                    data.done = true
                    if (res is UniError) {
                        data.lastCompleteError = res as UniError
                    }
                }
                ))
            }
            val rmdirTest = fun(){
                val fileManager = uni_getFileSystemManager()
                fileManager.rmdir(RmDirOptions(dirPath = "" + data.basePath + data.rmDirFile, recursive = data.recursiveVal, success = fun(res: FileManagerSuccessResult){
                    if (data.logAble) {
                        data.log += "rmdirTest success:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("success", res)
                }
                , fail = fun(res: IUniError){
                    if (data.logAble) {
                        data.log += "rmdirTest fail:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("fail", res)
                    data.lastFailError = UniError(res.errSubject, res.errCode, res.errMsg)
                }
                , complete = fun(res: Any){
                    console.log("complete", res)
                    data.done = true
                    if (res is UniError) {
                        data.lastCompleteError = res as UniError
                    }
                }
                ))
            }
            val mkdirTest = fun(){
                val fileManager = uni_getFileSystemManager()
                fileManager.mkdir(MkDirOptions(dirPath = "" + data.basePath + data.mkdirFile, recursive = data.recursiveVal, success = fun(res: FileManagerSuccessResult){
                    if (data.logAble) {
                        data.log += "mkdirTest success:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("success", res)
                }
                , fail = fun(res: IUniError){
                    if (data.logAble) {
                        data.log += "mkdirTest fail:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("fail", res)
                    data.lastFailError = UniError(res.errSubject, res.errCode, res.errMsg)
                }
                , complete = fun(res: Any){
                    if (res is UniError) {
                        data.lastCompleteError = res as UniError
                    }
                    data.done = true
                    console.log("complete", res)
                }
                ))
            }
            val accessFileTest = fun(){
                data.accessFileRet = ""
                val fileManager = uni_getFileSystemManager()
                fileManager.access(AccessOptions(path = "" + data.basePath + data.accessFile, success = fun(res: FileManagerSuccessResult){
                    if (data.logAble) {
                        data.log += "accessFileTest success:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("success", res)
                    data.accessFileRet = res.errMsg
                }
                , fail = fun(res: IUniError){
                    if (data.logAble) {
                        data.log += "accessFileTest fail:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("fail", res)
                    data.lastFailError = UniError(res.errSubject, res.errCode, res.errMsg)
                }
                , complete = fun(res: Any){
                    if (res is UniError) {
                        data.lastCompleteError = res as UniError
                    }
                    console.log("complete", res)
                    data.done = true
                }
                ))
            }
            val unlinkTest = fun(){
                val fileManager = uni_getFileSystemManager()
                fileManager.unlink(UnLinkOptions(filePath = "" + data.basePath + data.unlinkFile, success = fun(res: FileManagerSuccessResult){
                    if (data.logAble) {
                        data.log += "unlinkTest success:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("success", res)
                }
                , fail = fun(res: IUniError){
                    if (data.logAble) {
                        data.log += "unlinkTest fail:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("fail", res)
                    data.lastFailError = UniError(res.errSubject, res.errCode, res.errMsg)
                }
                , complete = fun(res: Any){
                    if (res is UniError) {
                        data.lastCompleteError = res as UniError
                    }
                    console.log("complete", res)
                    data.done = true
                }
                ))
            }
            val unlinkAllFileTest = fun(){
                val fileManager = uni_getFileSystemManager()
                fileManager.readdir(ReadDirOptions(dirPath = "" + data.basePath + data.rmDirFile, success = fun(res: ReadDirSuccessResult){
                    console.log("success to readdir", res)
                    res.files.forEach(fun(element){
                        console.log(element)
                        var filePath: String
                        if (data.rmDirFile.length <= 0) {
                            filePath = "" + data.basePath + element
                        } else {
                            filePath = "" + data.basePath + data.rmDirFile + "/" + element
                        }
                        fileManager.unlink(UnLinkOptions(filePath = filePath, success = fun(res: FileManagerSuccessResult){
                            if (data.logAble) {
                                data.log += "unlinkAllFileTest success:" + JSON.stringify(res) + "\n\n"
                            }
                            console.log("success unlink", res)
                        }
                        , fail = fun(res: IUniError){
                            if (data.logAble) {
                                data.log += "unlinkAllFileTest fail:" + JSON.stringify(res) + "\n\n"
                            }
                            console.log("fail unlink", res)
                            data.lastFailError = UniError(res.errSubject, res.errCode, res.errMsg)
                        }
                        , complete = fun(res: Any){
                            if (res is UniError) {
                                data.lastCompleteError = res as UniError
                            }
                            console.log("complete unlink", res)
                            data.done = true
                        }
                        ))
                    }
                    )
                }
                , fail = fun(res: IUniError){
                    if (data.logAble) {
                        data.log += "unlinkAllFileTest fail:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("fail to readdir", res)
                    data.lastFailError = UniError(res.errSubject, res.errCode, res.errMsg)
                }
                , complete = fun(res: Any){
                    console.log("complete readdir", res)
                    data.done = true
                    if (res is UniError) {
                        data.lastCompleteError = res as UniError
                    } else {
                        data.fileListComplete = (res as ReadDirSuccessResult).files
                    }
                }
                ))
            }
            val copyStaticToFilesTest = fun(){
                val fileManager = uni_getFileSystemManager()
                fileManager.copyFile(CopyFileOptions(srcPath = "/static/list-mock/mock.json", destPath = "" + data.copyToBasePath + "/a/mock.json", success = fun(res: FileManagerSuccessResult){
                    if (data.logAble) {
                        data.log += "copyFileTest success:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("success", res)
                }
                , fail = fun(res: IUniError){
                    if (data.logAble) {
                        data.log += "copyFileTest fail:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("fail", res)
                    data.lastFailError = UniError(res.errSubject, res.errCode, res.errMsg)
                }
                , complete = fun(res: Any){
                    console.log("complete", res)
                    data.done = true
                    if (res is UniError) {
                        data.lastCompleteError = res as UniError
                    }
                }
                ))
            }
            val appendFileTest = fun(_: Any){
                val fileManager = uni_getFileSystemManager()
                fileManager.appendFile(AppendFileOptions(filePath = "" + data.basePath + data.writeFile, data = data.appendFileContent, encoding = data.writeFileEncoding, success = fun(res: FileManagerSuccessResult){
                    if (data.logAble) {
                        data.log += "appendFileTest success:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("success", res)
                }
                , fail = fun(res: IUniError){
                    if (data.logAble) {
                        data.log += "appendFileTest fail:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("fail")
                    data.lastFailError = UniError(res.errSubject, res.errCode, res.errMsg)
                }
                , complete = fun(res: Any){
                    data.done = true
                    console.log("complete")
                    if (res is UniError) {
                        data.lastCompleteError = res as UniError
                    }
                }
                ))
            }
            val writeFileSyncTest = fun(_: Any){
                try {
                    val fileManager = uni_getFileSystemManager()
                    fileManager.writeFileSync("" + data.basePath + data.writeFile, data.writeFileContent, data.writeFileEncoding)
                    if (data.logAble) {
                        data.log += "writeFileSyncTest success:\n\n"
                    }
                    data.done = true
                }
                 catch (e: Throwable) {
                    if (data.logAble) {
                        data.log += "writeFileSyncTest fail:" + e + "\n\n"
                    }
                    data.done = true
                }
            }
            val readFileSyncTest = fun(){
                try {
                    val fileManager = uni_getFileSystemManager()
                    var result = fileManager.readFileSync("" + data.basePath + data.readFile, data.readFileEncoding)
                    if (data.logAble) {
                        data.log += "readFileSyncTest result:" + result + "\n\n"
                    }
                    data.done = true
                    data.readFileRet = result.toString()
                }
                 catch (e: Throwable) {
                    if (data.logAble) {
                        data.log += "readFileSyncTest fail:" + e + "\n\n"
                    }
                    data.done = true
                }
            }
            val unlinkSyncTest = fun(){
                try {
                    val fileManager = uni_getFileSystemManager()
                    fileManager.unlinkSync("" + data.basePath + data.unlinkFile)
                    data.done = true
                }
                 catch (e: Throwable) {
                    if (data.logAble) {
                        data.log += "unlinkSyncTest fail:" + e + "\n\n"
                    }
                    data.done = true
                }
            }
            val mkdirSyncTest = fun(){
                try {
                    val fileManager = uni_getFileSystemManager()
                    fileManager.mkdirSync("" + data.basePath + data.mkdirFile, data.recursiveVal)
                    data.done = true
                }
                 catch (e: Throwable) {
                    data.done = true
                    if (data.logAble) {
                        data.log += "mkdirSyncTest fail:" + e + "\n\n"
                    }
                }
            }
            val rmdirSyncTest = fun(){
                try {
                    val fileManager = uni_getFileSystemManager()
                    fileManager.rmdirSync("" + data.basePath + data.rmDirFile, data.recursiveVal)
                    data.done = true
                }
                 catch (e: Throwable) {
                    if (data.logAble) {
                        data.log += "rmdirSyncTest fail:" + e + "\n\n"
                    }
                    data.done = true
                }
            }
            val readDirSyncTest = fun(){
                try {
                    val fileManager = uni_getFileSystemManager()
                    var res = fileManager.readdirSync("" + data.basePath + data.readDir)
                    if (data.logAble) {
                        data.log += "readDirTest success:" + JSON.stringify(res) + "\n\n"
                    }
                    if (res != null) {
                        data.fileListSuccess = res
                    }
                    data.done = true
                }
                 catch (e: Throwable) {
                    if (data.logAble) {
                        data.log += "rmdirSyncTest fail:" + e + "\n\n"
                    }
                    data.done = true
                }
            }
            val accessFileSyncTest = fun(){
                data.accessFileRet = ""
                val fileManager = uni_getFileSystemManager()
                try {
                    fileManager.accessSync("" + data.basePath + data.accessFile)
                    data.done = true
                    data.accessFileRet = "access:ok"
                }
                 catch (e: Throwable) {
                    if (data.logAble) {
                        data.log += "rmdirSyncTest fail:" + e + "\n\n"
                    }
                    data.done = true
                }
            }
            val renameFileSync = fun(){
                val fileManager = uni_getFileSystemManager()
                try {
                    fileManager.renameSync("" + data.basePath + data.renameFromFile, "" + data.basePath + data.renameToFile)
                    data.done = true
                    data.renameFileRet = "rename:ok"
                }
                 catch (e: Throwable) {
                    if (data.logAble) {
                        data.log += "rmdirSyncTest fail:" + e + "\n\n"
                    }
                    console.log("renameSync:" + e)
                    data.done = true
                }
            }
            val copyFileSyncTest = fun(){
                val fileManager = uni_getFileSystemManager()
                try {
                    fileManager.copyFileSync("" + data.basePath + data.copyFromFile, "" + data.copyToBasePath + data.copyToFile)
                    data.done = true
                }
                 catch (e: Throwable) {
                    if (data.logAble) {
                        data.log += "rmdirSyncTest fail:" + e + "\n\n"
                    }
                    data.done = true
                }
            }
            val appendFileSyncTest = fun(_: Any){
                val fileManager = uni_getFileSystemManager()
                try {
                    fileManager.appendFileSync("" + data.basePath + data.writeFile, data.appendFileContent, data.writeFileEncoding)
                    data.done = true
                }
                 catch (e: Throwable) {
                    if (data.logAble) {
                        data.log += "rmdirSyncTest fail:" + e + "\n\n"
                    }
                    data.done = true
                }
            }
            val saveFileTest = fun(_: Any){
                val fileManager = uni_getFileSystemManager()
                writeFileSyncTest("")
                fileManager.saveFile(SaveFileOptions(tempFilePath = "" + data.basePath + data.temFile, success = fun(res: SaveFileSuccessResult){
                    if (data.logAble) {
                        data.log += "saveFileTest success:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("success", res)
                    data.saveFileRet = res.savedFilePath
                    data.done = true
                }
                , fail = fun(res: IUniError){
                    if (data.logAble) {
                        data.log += "saveFileTest fail:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("saveFileTest fail", res)
                    data.lastFailError = UniError(res.errSubject, res.errCode, res.errMsg)
                    data.done = true
                }
                , complete = fun(_){
                    data.done = true
                }
                ))
            }
            val saveFileAndReadFileTest = fun(_: Any){
                val fileManager = uni_getFileSystemManager()
                writeFileSyncTest("")
                fileManager.saveFile(SaveFileOptions(tempFilePath = "" + data.basePath + data.temFile, success = fun(res: SaveFileSuccessResult){
                    if (data.logAble) {
                        data.log += "saveFileTest success:" + JSON.stringify(res) + "\n\n"
                    }
                    fileManager.readFile(ReadFileOptions(encoding = "utf-8", filePath = res.savedFilePath, success = fun(res){
                        data.log += "saveFileAndReadFileTest 成功:" + JSON.stringify(res.data) + "\n\n"
                        console.log("success", res)
                        data.readFileRet = "saveFileAndReadFileTest:ok"
                        data.done = true
                    }
                    , fail = fun(err){
                        data.log += "saveFileAndReadFileTest 失败:" + JSON.stringify(err.errMsg) + "\n\n"
                        data.done = true
                    }
                    ))
                }
                , fail = fun(res: IUniError){
                    if (data.logAble) {
                        data.log += "saveFileTest fail:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("saveFileTest fail", res)
                    data.lastFailError = UniError(res.errSubject, res.errCode, res.errMsg)
                    data.done = true
                }
                , complete = fun(_){
                    data.done = true
                }
                ))
            }
            val saveFileTest1 = fun(_: Any){
                val fileManager = uni_getFileSystemManager()
                writeFileSyncTest("")
                fileManager.access(AccessOptions(path = "" + data.basePath + "local", success = fun(_res){
                    if (fileManager.fstatSync(FStatSyncOptions(fd = fileManager.openSync(OpenFileSyncOptions(filePath = "" + data.basePath + "local", flag = "r")))).isDirectory()) {
                        fileManager.rmdirSync("" + data.basePath + "local", true)
                    } else {
                        fileManager.unlinkSync("" + data.basePath + "local")
                    }
                    fileManager.saveFile(SaveFileOptions(tempFilePath = "" + data.basePath + data.temFile, filePath = "" + data.basePath + "local/1.txt", success = fun(res: SaveFileSuccessResult){
                        if (data.logAble) {
                            data.log += "saveFileTest success:" + JSON.stringify(res) + "\n\n"
                        }
                        console.log("success", res)
                        data.saveFileRet = res.savedFilePath
                        data.done = true
                    }
                    , fail = fun(res: IUniError){
                        if (data.logAble) {
                            data.log += "saveFileTest fail:" + JSON.stringify(res) + "\n\n"
                        }
                        console.log("saveFileTest fail", res)
                        data.lastFailError = UniError(res.errSubject, res.errCode, res.errMsg)
                        data.done = true
                    }
                    , complete = fun(_){
                        data.done = true
                    }
                    ))
                }
                , fail = fun(_res){
                    fileManager.saveFile(SaveFileOptions(tempFilePath = "" + data.basePath + data.temFile, filePath = "" + data.basePath + "local/1.txt", success = fun(res: SaveFileSuccessResult){
                        if (data.logAble) {
                            data.log += "saveFileTest success:" + JSON.stringify(res) + "\n\n"
                        }
                        console.log("success", res)
                        data.saveFileRet = res.savedFilePath
                        data.done = true
                    }
                    , fail = fun(res: IUniError){
                        if (data.logAble) {
                            data.log += "saveFileTest fail:" + JSON.stringify(res) + "\n\n"
                        }
                        console.log("saveFileTest fail", res)
                        data.lastFailError = UniError(res.errSubject, res.errCode, res.errMsg)
                        data.done = true
                    }
                    , complete = fun(_){
                        data.done = true
                    }
                    ))
                }
                ))
            }
            val saveFileTest2 = fun(_: Any){
                val fileManager = uni_getFileSystemManager()
                writeFileSyncTest("")
                fileManager.access(AccessOptions(path = "" + data.basePath + "local", success = fun(_res){
                    if (fileManager.fstatSync(FStatSyncOptions(fd = fileManager.openSync(OpenFileSyncOptions(filePath = "" + data.basePath + "local", flag = "r")))).isDirectory()) {
                        fileManager.rmdirSync("" + data.basePath + "local", true)
                    } else {
                        fileManager.unlinkSync("" + data.basePath + "local")
                    }
                    fileManager.saveFile(SaveFileOptions(tempFilePath = "" + data.basePath + data.temFile, filePath = "" + data.basePath + "local", success = fun(res: SaveFileSuccessResult){
                        if (data.logAble) {
                            data.log += "saveFileTest success:" + JSON.stringify(res) + "\n\n"
                        }
                        console.log("success", res)
                        data.saveFileRet = res.savedFilePath
                        data.done = true
                    }
                    , fail = fun(res: IUniError){
                        if (data.logAble) {
                            data.log += "saveFileTest fail:" + JSON.stringify(res) + "\n\n"
                        }
                        console.log("saveFileTest fail", res)
                        data.lastFailError = UniError(res.errSubject, res.errCode, res.errMsg)
                        data.done = true
                    }
                    , complete = fun(_){
                        data.done = true
                    }
                    ))
                }
                ))
            }
            val saveFileTest3 = fun(_: Any){
                val fileManager = uni_getFileSystemManager()
                writeFileSyncTest("")
                fileManager.access(AccessOptions(path = "" + data.basePath + "local", success = fun(_res){
                    if (fileManager.fstatSync(FStatSyncOptions(fd = fileManager.openSync(OpenFileSyncOptions(filePath = "" + data.basePath + "local", flag = "r")))).isDirectory()) {
                        fileManager.rmdirSync("" + data.basePath + "local", true)
                    } else {
                        fileManager.unlinkSync("" + data.basePath + "local")
                    }
                    fileManager.saveFile(SaveFileOptions(tempFilePath = "" + data.basePath + data.temFile, filePath = "" + data.basePath + "local/", success = fun(res: SaveFileSuccessResult){
                        if (data.logAble) {
                            data.log += "saveFileTest success:" + JSON.stringify(res) + "\n\n"
                        }
                        console.log("success", res)
                        data.saveFileRet = res.savedFilePath
                        data.done = true
                    }
                    , fail = fun(res: IUniError){
                        if (data.logAble) {
                            data.log += "saveFileTest fail:" + JSON.stringify(res) + "\n\n"
                        }
                        console.log("saveFileTest fail", res)
                        data.lastFailError = UniError(res.errSubject, res.errCode, res.errMsg)
                        data.done = true
                    }
                    , complete = fun(_){
                        data.done = true
                    }
                    ))
                }
                ))
            }
            val saveFileSyncTest = fun(_: Any){
                val fileManager = uni_getFileSystemManager()
                writeFileSyncTest("")
                try {
                    fileManager.saveFileSync("" + data.basePath + data.temFile, null)
                    data.done = true
                }
                 catch (e: Throwable) {
                    console.log("saveFileSyncTest:" + e)
                    data.done = true
                }
            }
            val unzipFileTest = fun(_: Any){
                val fileManager = uni_getFileSystemManager()
                try {
                    fileManager.mkdirSync("" + data.basePath + data.targetZip, true)
                }
                 catch (e: Throwable) {
                    console.error(e)
                }
                fileManager.unzip(UnzipFileOptions(zipFilePath = "/static/filemanager/to.zip", targetPath = "" + data.basePath + data.targetZip, success = fun(res: FileManagerSuccessResult){
                    if (data.logAble) {
                        data.log += "unzipFileTest success:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("success", res)
                }
                , fail = fun(res: IUniError){
                    if (data.logAble) {
                        data.log += "unzipFileTest fail:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("fail", res)
                    data.lastFailError = UniError(res.errSubject, res.errCode, res.errMsg)
                }
                , complete = fun(_){
                    data.done = true
                }
                ))
            }
            val getSavedFileListTest = fun(){
                val fileManager = uni_getFileSystemManager()
                fileManager.getSavedFileList(GetSavedFileListOptions(success = fun(res: GetSavedFileListResult){
                    if (data.logAble) {
                        data.log += "getSavedFileListTest success:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("getSavedFileListTest success", res)
                    data.fileListSuccess = res.fileList
                    data.getSavedFileListRet = "getSavedFileList:ok"
                }
                , fail = fun(res: IUniError){
                    if (data.logAble) {
                        data.log += "getSavedFileListTest fail:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("getSavedFileListTest fail", res)
                    data.lastFailError = UniError(res.errSubject, res.errCode, res.errMsg)
                    data.getSavedFileListRet = JSON.stringify(res)
                }
                , complete = fun(res: Any){
                    console.log("complete", res)
                    data.done = true
                    if (res is UniError) {
                        data.lastCompleteError = res as UniError
                    } else {
                        data.fileListComplete = (res as GetSavedFileListResult).fileList
                    }
                }
                ))
            }
            val truncateFileTest = fun(){
                val fileManager = uni_getFileSystemManager()
                fileManager.truncate(TruncateFileOptions(filePath = "" + data.basePath + data.writeFile, length = 6, success = fun(res: FileManagerSuccessResult){
                    if (data.logAble) {
                        data.log += "truncateFileTest success:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("success", res)
                }
                , fail = fun(res: IUniError){
                    if (data.logAble) {
                        data.log += "truncateFileTest fail:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("fail", res)
                    data.lastFailError = UniError(res.errSubject, res.errCode, res.errMsg)
                }
                , complete = fun(res: Any){
                    console.log("complete", res)
                    data.done = true
                    if (res is UniError) {
                        data.lastCompleteError = res as UniError
                    }
                }
                ))
            }
            val truncateFileSyncTest = fun(){
                val fileManager = uni_getFileSystemManager()
                try {
                    fileManager.truncateSync("" + data.basePath + data.writeFile, 3)
                    data.done = true
                }
                 catch (e: Throwable) {
                    console.log(e)
                    data.done = true
                }
            }
            val readCompressedFileTest = fun(){
                val fileManager = uni_getFileSystemManager()
                fileManager.readCompressedFile(ReadCompressedFileOptions(filePath = "/static/filemanager/1.txt.br", compressionAlgorithm = "br", success = fun(res: ReadCompressedFileResult){
                    if (data.logAble) {
                        data.log += "readCompressedFileTest success:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("success", res)
                }
                , fail = fun(res: IUniError){
                    if (data.logAble) {
                        data.log += "readCompressedFileTest fail:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("fail", res)
                    data.lastFailError = UniError(res.errSubject, res.errCode, res.errMsg)
                }
                , complete = fun(_){
                    data.done = true
                }
                ))
            }
            val readCompressedFileSyncTest = fun(){
                console.log("readCompressedFileSyncTest")
                val fileManager = uni_getFileSystemManager()
                try {
                    var result = fileManager.readCompressedFileSync("/static/filemanager/1.txt.br", "br")
                    if (data.logAble) {
                        data.log += result
                    }
                    data.done = true
                }
                 catch (e: Throwable) {
                    if (data.logAble) {
                        data.log += "readCompressedFileSyncTest fail:" + e + "\n\n"
                    }
                    data.done = true
                }
            }
            val removeSavedFileTest = fun(){
                console.log("removeSavedFileTest enter")
                val fileManager = uni_getFileSystemManager()
                fileManager.removeSavedFile(RemoveSavedFileOptions(filePath = "" + data.basePath + data.writeFile, success = fun(res: FileManagerSuccessResult){
                    if (data.logAble) {
                        data.log += "removeSavedFileTest success:" + JSON.stringify(res) + "\n\n"
                    }
                    data.removeSavedFileRet = res.errMsg
                    console.log("removeSavedFileTest success", res)
                }
                , fail = fun(res: IUniError){
                    if (data.logAble) {
                        data.log += "removeSavedFileTest fail:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("removeSavedFileTest fail", res)
                }
                , complete = fun(_){
                    data.done = true
                }
                ))
            }
            val statFileInfoSyncTest = fun(_: Any){
                val fileManager = uni_getFileSystemManager()
                try {
                    var res = fileManager.statSync("" + data.globalTempPath + data.statFile, data.recursiveVal)
                    if (data.logAble) {
                        data.log += "statFileInfoSyncTest success:" + JSON.stringify(res) + "\n\n"
                    }
                    data.statsRet = res
                    data.done = true
                }
                 catch (e: Throwable) {
                    if (data.logAble) {
                        data.log += "statFileInfoSyncTest fail:" + e + "\n\n"
                    }
                    data.done = true
                }
            }
            val openFileTest = fun(){
                val fileManager = uni_getFileSystemManager()
                fileManager.open(OpenFileOptions(filePath = "" + data.basePath + data.readFile, flag = "a", success = fun(res: OpenFileSuccessResult){
                    if (data.logAble) {
                        data.log += "openFileTest success:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("success", res)
                    data.fd = res.fd
                }
                , fail = fun(res: IUniError){
                    if (data.logAble) {
                        data.log += "openFileTest fail:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("fail", res)
                    data.lastFailError = UniError(res.errSubject, res.errCode, res.errMsg)
                }
                , complete = fun(_){
                    data.done = true
                }
                ))
            }
            val openFileSyncTest = fun(param: String, isTest: Boolean): String {
                val fileManager = uni_getFileSystemManager()
                try {
                    var fd = fileManager.openSync(OpenFileSyncOptions(filePath = "" + data.basePath + data.readFile, flag = param))
                    if (data.logAble && isTest) {
                        data.log += "openFileSyncTest success:" + fd + "\n\n"
                    }
                    if (isTest) {
                        data.done = true
                    }
                    data.fd = fd
                    return fd
                }
                 catch (e: Throwable) {
                    if (data.logAble) {
                        data.log += "openFileSyncTest fail:" + JSON.stringify(e) + "\n\n"
                    }
                    console.log("fail", e)
                    data.done = true
                }
                return ""
            }
            val closeSyncTest = fun(){
                console.log("closeSyncTest")
                val fileManager = uni_getFileSystemManager()
                try {
                    console.log("closeSync")
                    fileManager.closeSync(CloseSyncOptions(fd = openFileSyncTest("r", false)))
                    if (data.logAble) {
                        data.log += "closeSyncTest success:\n\n"
                    }
                    data.done = true
                    data.closeFileRet = "close:ok"
                }
                 catch (e: Throwable) {
                    if (data.logAble) {
                        data.log += "closeSyncTest fail:" + JSON.stringify(e) + "\n\n"
                    }
                    console.log("fail", e)
                    data.done = true
                }
            }
            val closeTest = fun(){
                val fileManager = uni_getFileSystemManager()
                fileManager.close(CloseOptions(fd = openFileSyncTest("r", false), success = fun(res: FileManagerSuccessResult){
                    if (data.logAble) {
                        data.log += "closeTest success:" + JSON.stringify(res) + "\n\n"
                    }
                    data.closeFileRet = res.errMsg
                    console.log("success", res)
                }
                , fail = fun(res: IUniError){
                    if (data.logAble) {
                        data.log += "closeTest fail:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("fail", res)
                    data.lastFailError = UniError(res.errSubject, res.errCode, res.errMsg)
                }
                , complete = fun(_){
                    data.done = true
                }
                ))
            }
            val writeTest = fun(){
                val fileManager = uni_getFileSystemManager()
                try {
                    fileManager.mkdirSync("" + data.basePath + data.mkdirFile, true)
                }
                 catch (e: Throwable) {
                    console.error(e)
                }
                fileManager.write(WriteOptions(fd = openFileSyncTest("w+", false), data = data.writeData, encoding = "utf-8", success = fun(res: WriteResult){
                    if (data.logAble) {
                        data.log += "writeTest success:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("success", res)
                    data.bytesWritten = res.bytesWritten
                    data.lastFailError = UniError("uni-fileSystemManager", 0, "writeTest success:" + JSON.stringify(res))
                }
                , fail = fun(res: IUniError){
                    if (data.logAble) {
                        data.log += "writeTest fail:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("fail", res)
                    data.lastFailError = UniError(res.errSubject, res.errCode, "writeTest:" + res.errMsg)
                }
                , complete = fun(_){
                    data.done = true
                }
                ))
            }
            val writeSyncTest = fun(){
                val fileManager = uni_getFileSystemManager()
                try {
                    fileManager.mkdirSync("" + data.basePath + data.mkdirFile, true)
                }
                 catch (e: Throwable) {
                    console.error(e)
                }
                fileManager.open(OpenFileOptions(filePath = "" + data.basePath + data.readFile, flag = "r+", success = fun(res: OpenFileSuccessResult){
                    console.log("success", res)
                    if (res.fd.length <= 0) {
                        data.done = true
                        return
                    }
                    try {
                        var ret = fileManager.writeSync(WriteSyncOptions(fd = res.fd, data = data.writeData, encoding = "utf-8"))
                        if (data.logAble) {
                            data.log += "writeSyncTest success:" + JSON.stringify(ret) + "\n\n"
                        }
                        console.log("success", ret)
                        data.done = true
                        data.bytesWritten = ret.bytesWritten
                    }
                     catch (e: Throwable) {
                        if (data.logAble) {
                            data.log += "writeSyncTest fail:" + JSON.stringify(e) + "\n\n"
                        }
                        console.log("fail", e)
                        data.done = true
                    }
                }
                , fail = fun(res: IUniError){
                    if (data.logAble) {
                        data.log += "openFileTest fail:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("fail", res)
                    data.lastFailError = UniError(res.errSubject, res.errCode, res.errMsg)
                    data.done = true
                }
                ))
            }
            val fstatTest = fun(){
                val fileManager = uni_getFileSystemManager()
                fileManager.fstat(FStatOptions(fd = openFileSyncTest("r", false), success = fun(res: FStatSuccessResult){
                    if (data.logAble) {
                        data.log += "fstatTest success:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("success", res)
                    data.fstat = res.stats
                    data.fstatSize = res.stats.size
                }
                , fail = fun(res: IUniError){
                    if (data.logAble) {
                        data.log += "fstatTest fail:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("fail", res)
                    data.lastFailError = UniError(res.errSubject, res.errCode, res.errMsg)
                }
                , complete = fun(_){
                    data.done = true
                }
                ))
            }
            val fstatSyncTest = fun(){
                val fileManager = uni_getFileSystemManager()
                try {
                    var stat = fileManager.fstatSync(FStatSyncOptions(fd = openFileSyncTest("r", false)))
                    if (data.logAble) {
                        data.log += "fstatSyncTest success:" + JSON.stringify(stat) + "\n\n"
                    }
                    data.done = true
                    data.fstat = stat
                    data.fstatSize = stat.size
                }
                 catch (e: Throwable) {
                    if (data.logAble) {
                        data.log += "fstatSyncTest fail:" + JSON.stringify(e) + "\n\n"
                    }
                    data.done = true
                }
            }
            val ftruncateFileTest = fun(){
                val fileManager = uni_getFileSystemManager()
                fileManager.ftruncate(FTruncateFileOptions(fd = openFileSyncTest("r+", false), length = 6, success = fun(res: FileManagerSuccessResult){
                    if (data.logAble) {
                        data.log += "ftruncateFileTest success:" + JSON.stringify(res) + "\n\n"
                    }
                    data.ftruncateRet = res.errMsg
                }
                , fail = fun(res: IUniError){
                    if (data.logAble) {
                        data.log += "ftruncateFileTest fail:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("fail", res)
                    data.lastFailError = UniError(res.errSubject, res.errCode, res.errMsg)
                }
                , complete = fun(res: Any){
                    console.log("complete", res)
                    data.done = true
                    if (res is UniError) {
                        data.lastCompleteError = res as UniError
                    }
                }
                ))
            }
            val ftruncateFileSyncTest = fun(){
                val fileManager = uni_getFileSystemManager()
                try {
                    fileManager.ftruncateSync(FTruncateFileSyncOptions(fd = openFileSyncTest("r+", false), length = 4))
                    if (data.logAble) {
                        data.log += "ftruncateFileSyncTest success:\n\n"
                    }
                    data.done = true
                    data.ftruncateRet = "ftruncate:ok"
                }
                 catch (e: Throwable) {
                    if (data.logAble) {
                        data.log += "ftruncateFileSyncTest fail:" + JSON.stringify(e) + "\n\n"
                    }
                    data.done = true
                }
            }
            val readZipEntry = fun(){
                val fileManager = uni_getFileSystemManager()
                fileManager.readZipEntry(ReadZipEntryOptions(filePath = "/static/filemanager/to.zip", encoding = "utf-8", success = fun(res: EntriesResult){
                    if (data.logAble) {
                        data.log += "readZipEntry success:size=" + res.result + "\n\n"
                    }
                    console.log("success", res)
                }
                , fail = fun(res: IUniError){
                    if (data.logAble) {
                        data.log += "readZipEntry fail:" + JSON.stringify(res) + "\n\n"
                    }
                    console.log("fail", res)
                    data.lastFailError = UniError(res.errSubject, res.errCode, res.errMsg)
                }
                ))
            }
            val testReadFileBuffer = fun(){
                val fs = uni_getFileSystemManager()
                fs.readFile(ReadFileOptions(filePath = "" + uni_env.USER_DATA_PATH + "/hello.txt", success = fun(res){
                    console.log(res)
                    var float64 = Float64Array(res.data as ArrayBuffer)
                    if (data.logAble) {
                        run {
                            var i: Number = 0
                            while(i < float64.length){
                                if (data.logAble) {
                                    data.log += "testReadFileBuffer success ：" + ("Byte " + i + ": " + float64[i]) + "\n\n"
                                }
                                i++
                            }
                        }
                    }
                    data.arrayBufferRes = float64[1]
                    console.log(data.arrayBufferRes)
                }
                , fail = fun(res){
                    if (data.logAble) {
                        data.log += "testReadFileBuffer fail:" + JSON.stringify(res) + "\n\n"
                    }
                    data.lastFailError = UniError(res.errSubject, res.errCode, res.errMsg)
                    console.error(res)
                }
                , complete = fun(res: Any){
                    console.log("complete", res)
                    data.done = true
                    if (res is UniError) {
                        data.lastCompleteError = res as UniError
                    }
                }
                ))
            }
            val testWriteReadFileBuffer = fun(){
                val fs = uni_getFileSystemManager()
                var buffer = ArrayBuffer(16)
                var float64 = Float64Array(buffer)
                float64[1] = 1.2222222
                fs.writeFile(WriteFileOptions(filePath = "" + uni_env.USER_DATA_PATH + "/hello.txt", data = buffer, success = fun(res){
                    if (data.logAble) {
                        data.log += "testWriteReadFileBuffer ：" + res.errMsg + "\n\n"
                    }
                    console.log(res)
                    testReadFileBuffer()
                }
                , fail = fun(res){
                    if (data.logAble) {
                        data.log += "testWriteReadFileBuffer fail:" + JSON.stringify(res) + "\n\n"
                    }
                    data.lastFailError = UniError(res.errSubject, res.errCode, res.errMsg)
                    console.error(res)
                    data.done = true
                }
                , complete = fun(_: Any){}))
            }
            val testReadFileSyncBuffer = fun(){
                try {
                    val fs = uni_getFileSystemManager()
                    var res = fs.readFileSync("" + uni_env.USER_DATA_PATH + "/hello.txt", null)
                    console.log(res)
                    var float64 = Float64Array(res as ArrayBuffer)
                    run {
                        var i: Number = 0
                        while(i < float64.length){
                            if (data.logAble) {
                                data.log += "testReadFileSyncBuffer success:" + ("Byte " + i + ": " + float64[i]) + "\n\n"
                            }
                            console.log("Byte " + i + ": " + float64[i])
                            i++
                        }
                    }
                    data.arrayBufferRes = float64[1]
                    console.log(data.arrayBufferRes)
                }
                 catch (e: Throwable) {
                    if (data.logAble) {
                        data.log += "testReadFileSyncBuffer fail:" + JSON.stringify(e) + "\n\n"
                    }
                    data.done = true
                }
            }
            val testWriteReadFileSyncBuffer = fun(){
                try {
                    val fs = uni_getFileSystemManager()
                    var buffer = ArrayBuffer(16)
                    var float64 = Float64Array(buffer)
                    float64[1] = 1.333
                    fs.writeFileSync("" + uni_env.USER_DATA_PATH + "/hello.txt", buffer, "utf-8")
                    if (data.logAble) {
                        data.log += "testWriteReadFileSyncBuffer success\n\n"
                    }
                    testReadFileSyncBuffer()
                    data.done = true
                }
                 catch (e: Throwable) {
                    if (data.logAble) {
                        data.log += "testWriteReadFileSyncBuffer fail:" + JSON.stringify(e) + "\n\n"
                    }
                    data.done = true
                }
            }
            val testWriteReadBuffer = fun(){
                val fileManager = uni_getFileSystemManager()
                try {
                    fileManager.mkdirSync("" + data.basePath + data.mkdirFile, true)
                }
                 catch (e: Throwable) {
                    console.error(e)
                }
                var buffer = ArrayBuffer(24)
                var float64 = Float64Array(buffer)
                float64[1] = 1.24
                float64[2] = 1.33
                fileManager.write(WriteOptions(fd = openFileSyncTest("w+", false), length = 16, offset = 8, data = buffer, position = 10, success = fun(res: WriteResult){
                    console.log("success", res)
                    val ab = ArrayBuffer(24)
                    fileManager.read(ReadOption(arrayBuffer = ab, fd = openFileSyncTest("a+", false), length = 8, position = 10, success = fun(res: ReadSuccessCallbackResult){
                        console.log(res)
                        var value = Float64Array(res.arrayBuffer)
                        run {
                            var i: Number = 0
                            while(i < value.length){
                                console.log("Byte " + i + ": " + value[i])
                                if (data.logAble) {
                                    data.log += "testWriteReadBuffer success:" + ("Byte " + i + ": " + value[i]) + "\n\n"
                                }
                                i++
                            }
                        }
                        data.arrayBufferRes = value[0]
                        console.log(data.arrayBufferRes)
                    }
                    , fail = fun(res){
                        console.log(res)
                        data.done = true
                        if (res is UniError) {
                            data.lastCompleteError = res
                        }
                    }
                    , complete = fun(res: Any){
                        console.log("complete", res)
                        data.done = true
                        if (res is UniError) {
                            data.lastCompleteError = res as UniError
                        }
                    }
                    ))
                }
                , fail = fun(res: IUniError){
                    data.done = true
                    if (res is UniError) {
                        data.lastCompleteError = res
                    }
                }
                , complete = fun(_){}))
            }
            val testWriteReadSyncBuffer = fun(){
                val fileManager = uni_getFileSystemManager()
                try {
                    fileManager.mkdirSync("" + data.basePath + data.mkdirFile, true)
                }
                 catch (e: Throwable) {}
                try {
                    var buffer = ArrayBuffer(24)
                    var float64 = Float64Array(buffer)
                    float64[1] = 1.11
                    float64[2] = 1.33
                    var ret = fileManager.writeSync(WriteSyncOptions(fd = openFileSyncTest("w+", false), data = buffer, length = 16, offset = 8, position = 10, encoding = "utf-8"))
                    console.log("success", ret)
                    val ab = ArrayBuffer(24)
                    var res = fileManager.readSync(ReadSyncOption(arrayBuffer = ab, fd = openFileSyncTest("a+", false), length = 8, offset = 8, position = 10))
                    console.log(res)
                    var value = Float64Array(res.arrayBuffer)
                    run {
                        var i: Number = 0
                        while(i < value.length){
                            if (data.logAble) {
                                data.log += "testWriteReadSyncBuffer success ：" + ("Byte " + i + ": " + value[i]) + "\n\n"
                            }
                            i++
                        }
                    }
                    data.done = true
                    data.arrayBufferRes = float64[1]
                    console.log(data.arrayBufferRes)
                }
                 catch (e: Throwable) {
                    data.done = true
                    console.error(e)
                }
            }
            val testAppendFileBufferSync = fun(){
                val fs = uni_getFileSystemManager()
                try {
                    var buffer = ArrayBuffer(24)
                    var float64 = Float64Array(buffer)
                    float64[1] = 1.2222222
                    float64[2] = 1.33
                    var ret = fs.writeSync(WriteSyncOptions(fd = fs.openSync(OpenFileSyncOptions(filePath = "" + uni_env.USER_DATA_PATH + "/hello.txt", flag = "w+")), data = buffer, length = 16, offset = 8, position = 10))
                    console.log(ret)
                    buffer = ArrayBuffer(16)
                    float64 = Float64Array(buffer)
                    float64[0] = 20
                    fs.appendFileSync("" + uni_env.USER_DATA_PATH + "/hello.txt", buffer, null)
                    val ab = ArrayBuffer(32)
                    var readResult = fs.readSync(ReadSyncOption(fd = fs.openSync(OpenFileSyncOptions(filePath = "" + uni_env.USER_DATA_PATH + "/hello.txt", flag = "a+")), arrayBuffer = ab, length = 24, position = 10, offset = 8))
                    console.log(readResult)
                    float64 = Float64Array(readResult.arrayBuffer)
                    run {
                        var i: Number = 0
                        while(i < float64.length){
                            if (data.logAble) {
                                data.log += "testAppendFileBufferSync success ：" + ("Byte " + i + ": " + float64[i]) + "\n\n"
                            }
                            console.log("Byte " + i + ": " + float64[i])
                            i++
                        }
                    }
                    data.arrayBufferRes = float64[3]
                    console.log(data.arrayBufferRes)
                    data.done = true
                }
                 catch (e: Throwable) {
                    data.done = true
                    if (data.logAble) {
                        data.log += "testAppendFileBufferSync fail:" + JSON.stringify(e) + "\n\n"
                    }
                    console.error(e)
                }
            }
            val testAppendFileBuffer = fun(){
                val fs = uni_getFileSystemManager()
                try {
                    var buffer = ArrayBuffer(24)
                    var float64 = Float64Array(buffer)
                    float64[1] = 1.2222222
                    float64[2] = 1.33
                    var ret = fs.writeSync(WriteSyncOptions(fd = fs.openSync(OpenFileSyncOptions(filePath = "" + uni_env.USER_DATA_PATH + "/hello.txt", flag = "w+")), data = buffer, length = 16, offset = 8, position = 10))
                    console.log(ret)
                    buffer = ArrayBuffer(16)
                    float64 = Float64Array(buffer)
                    float64[0] = 21
                    fs.appendFile(AppendFileOptions(filePath = "" + uni_env.USER_DATA_PATH + "/hello.txt", data = buffer, success = fun(res){
                        console.log(res)
                        val ab = ArrayBuffer(32)
                        var readResult = fs.readSync(ReadSyncOption(fd = fs.openSync(OpenFileSyncOptions(filePath = "" + uni_env.USER_DATA_PATH + "/hello.txt", flag = "a+")), arrayBuffer = ab, length = 24, position = 10, offset = 8))
                        console.log(readResult)
                        float64 = Float64Array(readResult.arrayBuffer)
                        run {
                            var i: Number = 0
                            while(i < float64.length){
                                console.log("Byte " + i + ": " + float64[i])
                                if (data.logAble) {
                                    data.log += "testAppendFileBuffer success ：" + ("Byte " + i + ": " + float64[i]) + "\n\n"
                                }
                                i++
                            }
                        }
                        data.arrayBufferRes = float64[3]
                        console.log(data.arrayBufferRes)
                    }
                    , fail = fun(res){
                        console.log(res)
                    }
                    , complete = fun(_){
                        data.done = true
                    }
                    ))
                }
                 catch (e: Throwable) {
                    data.done = true
                    if (data.logAble) {
                        data.log += "testAppendFileBufferSync fail:" + JSON.stringify(e) + "\n\n"
                    }
                    console.error(e)
                }
            }
            val testReadFileEncoding = fun(encoding: String){
                console.log("testEncoding", encoding)
                uni_chooseImage(ChooseImageOptions(count = 1, albumMode = "system", sizeType = _uA(
                    "original"
                ), sourceType = _uA(
                    "album"
                ), success = fun(e){
                    console.log(e.tempFilePaths[0])
                    uni_getFileSystemManager().readFile(ReadFileOptions(filePath = e.tempFilePaths[0], encoding = encoding, success = fun(res){
                        console.log("success:", (res.data as String).length)
                    }
                    ))
                }
                ))
            }
            val testReadFileArrayBuffer = fun(){
                uni_chooseImage(ChooseImageOptions(count = 1, albumMode = "system", sizeType = _uA(
                    "original"
                ), sourceType = _uA(
                    "album"
                ), success = fun(e){
                    console.log(e.tempFilePaths[0])
                    uni_getFileSystemManager().readFile(ReadFileOptions(filePath = e.tempFilePaths[0], success = fun(res){
                        console.log("success:", (res.data as ArrayBuffer).byteLength)
                    }
                    ))
                }
                ))
            }
            val testReadFileSyncEncoding = fun(encoding: String){
                console.log("testEncoding", encoding)
                uni_chooseImage(ChooseImageOptions(count = 1, albumMode = "system", sizeType = _uA(
                    "original"
                ), sourceType = _uA(
                    "album"
                ), success = fun(e){
                    console.log(e.tempFilePaths[0])
                    try {
                        var res = uni_getFileSystemManager().readFileSync(e.tempFilePaths[0], encoding)
                        console.log("success:", (res as String).length)
                    }
                     catch (e: Throwable) {
                        console.log(e)
                    }
                }
                ))
            }
            val testReadFileSyncArrayBuffer = fun(){
                uni_chooseImage(ChooseImageOptions(count = 1, albumMode = "system", sizeType = _uA(
                    "original"
                ), sourceType = _uA(
                    "album"
                ), success = fun(e){
                    console.log(e.tempFilePaths[0])
                    try {
                        var res = uni_getFileSystemManager().readFileSync(e.tempFilePaths[0], null)
                        console.log("success:", (res as ArrayBuffer).byteLength)
                    }
                     catch (e: Throwable) {
                        console.log(e)
                    }
                }
                ))
            }
            val copyFileByContent = fun(){
                uni_chooseImage(ChooseImageOptions(count = 1, albumMode = "system", sizeType = _uA(
                    "original"
                ), sourceType = _uA(
                    "album"
                ), success = fun(e){
                    console.log(e.tempFilePaths[0])
                    uni_getFileSystemManager().copyFile(CopyFileOptions(srcPath = e.tempFilePaths[0], destPath = uni_env.CACHE_PATH + "copyFileByContent.jpg", complete = fun(res){
                        console.log("success:", res)
                    }
                    ))
                }
                ))
            }
            val copyFileSyncByContent = fun(){
                uni_chooseImage(ChooseImageOptions(count = 1, albumMode = "system", sizeType = _uA(
                    "original"
                ), sourceType = _uA(
                    "album"
                ), success = fun(e){
                    console.log(e.tempFilePaths[0])
                    try {
                        var res = uni_getFileSystemManager().copyFileSync(e.tempFilePaths[0], uni_env.CACHE_PATH + "copyFileSyncByContent.jpg")
                        console.log("success:", res)
                    }
                     catch (e: Throwable) {
                        console.log(e)
                    }
                }
                ))
            }
            val gotoExplore = fun(){
                uni_navigateTo(NavigateToOptions(url = "/pages/API/get-file-system-manager/filemanage"))
            }
            val gotoTestStatic = fun(){
                uni_navigateTo(NavigateToOptions(url = "/pages/API/get-file-system-manager/testStatic"))
            }
            val gotoIssue26433 = fun(){
                uni_navigateTo(NavigateToOptions(url = "/pages/API/get-file-system-manager/rename-issue-26433"))
            }
            val getFileInfoByContent = fun(event: UniPointerEvent){
                uni_chooseFile(ChooseFileOptions(count = 1, success = fun(e) {
                    console.log(JSON.stringify(e.tempFiles[0].path))
                    uni_getFileSystemManager().getFileInfo(GetFileInfoOptions(filePath = e.tempFiles[0].path, success = fun(e2) {
                        console.log("success:", e2)
                    }
                    ))
                }
                ))
            }
            val testOpenFlagWrite = fun(){
                try {
                    uni_getFileSystemManager().mkdirSync("" + data.basePath + "b/", true)
                    uni_getFileSystemManager().writeFileSync("" + data.basePath + "b/t.txt", "aaa", "utf-8")
                }
                 catch (e: UTSError) {}
                uni_getFileSystemManager().open(OpenFileOptions(filePath = "" + data.basePath + "b/t.txt", flag = "a+", success = fun(res: OpenFileSuccessResult){
                    uni_getFileSystemManager().write(WriteOptions(fd = res.fd, data = "appended", position = 10, success = fun(e){
                        data.testOpenFlataplusWrite = true
                    }
                    , fail = fun(e){
                        data.testOpenFlataplusWrite = false
                    }
                    ))
                }
                , fail = fun(e) {}))
            }
            val testWriteLongString = fun(){
                try {
                    uni_getFileSystemManager().mkdirSync("" + data.basePath + "b/", true)
                    uni_getFileSystemManager().writeFileSync("" + data.basePath + "b/t.txt", "aaa", "utf-8")
                }
                 catch (e: UTSError) {}
                uni_getFileSystemManager().open(OpenFileOptions(filePath = "" + data.basePath + "b/t.txt", flag = "a+", success = fun(res: OpenFileSuccessResult){
                    uni_getFileSystemManager().write(WriteOptions(fd = res.fd, data = "appended long strings.appended long strings.appended long strings.appended long strings.appended long strings.", position = 10, success = fun(e){
                        data.testOpenFlataplusWrite = true
                    }
                    , fail = fun(e){
                        data.testOpenFlataplusWrite = false
                    }
                    ))
                }
                , fail = fun(e) {}))
            }
            __expose(_uM("data" to data, "testOpenFlagWrite" to testOpenFlagWrite, "testWriteLongString" to testWriteLongString))
            return fun(): Any? {
                val _component_page_intro = resolveEasyComponent("page-intro", GenComponentsPageIntroPageIntroClass)
                return _cE(Fragment, null, _uA(
                    _cV(_component_page_intro, _uM("content" to "本页演示文件系统 API：递归获取目录、创建文件夹、读写/复制/重命名/删除文件、同步与异步接口等，操作结果在日志区展示。")),
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
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to statFileInfoTest, "id" to "btn-stat-file"), "递归获取目录files的Stats对象" + _tD(unref(data).statFile), 1),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to mkdirTest, "id" to "btn-mkdir"), "创建文件夹" + _tD(unref(data).mkdirFile), 1),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to writeFileTest, "id" to "btn-write-file"), "覆盖写入文件" + _tD(unref(data).writeFile), 1),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to readDirTest, "id" to "btn-read-dir"), "读取文件夹" + _tD(unref(data).readDir), 1),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to readFileTest, "id" to "btn-read-file"), "读取文件" + _tD(unref(data).readFile), 1),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to copyFileTest, "id" to "btn-copy-file"), "复制文件" + _tD(unref(data).copyFromFile) + "到" + _tD(unref(data).copyToFile), 1),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to renameFileTest, "id" to "btn-rename-file"), "重命名文件" + _tD(unref(data).renameFromFile) + "到" + _tD(unref(data).renameToFile), 1),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to accessFileTest, "id" to "btn-access-file"), "判断文件" + _tD(unref(data).accessFile) + "是否存在", 1),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to getFileInfoTest, "id" to "btn-get-file-info"), "获取文件信息" + _tD(unref(data).getFileInfoFile), 1),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to unlinkTest, "id" to "btn-unlink-file"), "删除文件" + _tD(unref(data).unlinkFile), 1),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to unlinkAllFileTest, "id" to "btn-clear-file"), "删除文件夹" + _tD(unref(data).rmDirFile) + "下的所有文件", 1),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to rmdirTest, "id" to "btn-remove-dir"), "删除文件夹" + _tD(unref(data).rmDirFile), 1),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to statFileInfoSyncTest, "id" to "btn-stat-file-sync"), "同步递归获取目录files的Stats对象" + _tD(unref(data).statFile), 1),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to appendFileTest, "id" to "btn-append-file"), "在文件" + _tD(unref(data).readFile) + "结尾追加内容", 1),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to appendFileSyncTest, "id" to "btn-append-file-sync"), "同步在文件" + _tD(unref(data).readFile) + "结尾追加内容", 1),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to writeFileSyncTest, "id" to "btn-write-file-sync"), "同步覆盖写入文件" + _tD(unref(data).writeFile), 1),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to readFileSyncTest, "id" to "btn-read-file-sync"), "同步读取文件" + _tD(unref(data).readFile), 1),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to unlinkSyncTest, "id" to "btn-unlink-file-sync"), "同步删除文件" + _tD(unref(data).unlinkFile), 1),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to mkdirSyncTest, "id" to "btn-mkdir-sync"), "同步创建文件夹" + _tD(unref(data).mkdirFile), 1),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to rmdirSyncTest, "id" to "btn-remove-dir-sync"), "同步删除文件夹" + _tD(unref(data).rmDirFile), 1),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to readDirSyncTest, "id" to "btn-read-dir-sync"), "同步读取文件夹" + _tD(unref(data).readDir), 1),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to accessFileSyncTest, "id" to "btn-access-file-sync"), "同步判断文件" + _tD(unref(data).accessFile) + "是否存在", 1),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to renameFileSync, "id" to "btn-rename-file-sync"), "同步重命名文件" + _tD(unref(data).renameFromFile) + "到" + _tD(unref(data).renameToFile), 1),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to copyFileSyncTest, "id" to "btn-copy-file-sync"), "同步复制文件" + _tD(unref(data).copyFromFile) + "到" + _tD(unref(data).copyToFile), 1),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to removeSavedFileTest, "id" to "btn-remove-saved-file"), "删除已保存的本地文件"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to getSavedFileListTest, "id" to "btn-getsaved-filelist"), "获取该已保存的本地缓存文件列表"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to truncateFileTest, "id" to "btn-truncate-file"), "对文件" + _tD(unref(data).writeFile) + "内容进行截断操作", 1),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to openFileTest, "id" to "btn-open-file"), "打开文件" + _tD(unref(data).readFile) + "，返回描述符", 1),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to fun(){
                            openFileSyncTest("r", true)
                        }
                        , "id" to "btn-open-file-sync"), "同步打开文件" + _tD(unref(data).readFile) + "，返回描述符", 9, _uA(
                            "onClick"
                        )),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to closeTest, "id" to "btn-close-file"), "通过文件描述符关闭文件" + _tD(unref(data).readFile), 1),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to closeSyncTest, "id" to "btn-close-file-sync"), "通过文件描述符同步关闭文件" + _tD(unref(data).readFile), 1),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to writeTest, "id" to "btn-write"), "通过文件描述符写入文件" + _tD(unref(data).readFile), 1),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to writeSyncTest, "id" to "btn-write-sync"), "同步通过文件描述符写入文件" + _tD(unref(data).readFile), 1),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to fstatTest, "id" to "btn-fstat-file"), "通过文件描述符获取" + _tD(unref(data).statFile) + "的状态信息", 1),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to fstatSyncTest, "id" to "btn-fstat-file-sync"), "同步通过文件描述符获取" + _tD(unref(data).statFile) + "的状态信息", 1),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to ftruncateFileTest, "id" to "btn-ftruncate-file"), "通过文件描述符对文件" + _tD(unref(data).writeFile) + "内容进行截断", 1),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to ftruncateFileSyncTest, "id" to "btn-ftruncate-file-sync"), "同步通过文件描述符对文件" + _tD(unref(data).writeFile) + "内容进行截断", 1),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to testWriteReadFileBuffer, "id" to "btn-writereadfile-buffer"), "写入/读取 ArrayBuffer"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to testWriteReadBuffer, "id" to "btn-writeread-buffer"), "通过文件描述符写入/读取 ArrayBuffer"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to testWriteReadSyncBuffer, "id" to "btn-writereadsync-buffer"), "通过文件描述符同步写入/读取 ArrayBuffer"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to testAppendFileBuffer, "id" to "btn-appendfile-buffer"), "在文件末尾追加 ArrayBuffer"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to testAppendFileBufferSync, "id" to "btn-appendfilesync-buffer"), "同步在文件末尾追加 ArrayBuffer"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to copyStaticToFilesTest, "id" to "btn-copyStatic-file"), "从static目录复制文件到a目录"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to saveFileTest, "id" to "btn-save-file"), "保存临时文件到本地, filePath=null"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to saveFileTest1, "id" to "btn-save-file1"), "保存临时文件到本地, filePath=xxx/path.txt"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to saveFileTest2, "id" to "btn-save-file2"), "保存临时文件到本地, filePath=xxx/path"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to saveFileTest3, "id" to "btn-save-file3"), "保存临时文件到本地, filePath=xxx/path/"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to saveFileAndReadFileTest, "id" to "btn-save-file-read-file"), "saveFile成功后验证是否可以readFile"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to saveFileSyncTest, "id" to "btn-save-file-sync"), "同步保存临时文件到本地"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to unzipFileTest, "id" to "btn-unzip-file-sync"), "解压文件"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to truncateFileSyncTest, "id" to "btn-truncate-file-sync"), "同步对文件" + _tD(unref(data).writeFile) + "内容进行截断操作", 1),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to readCompressedFileTest, "id" to "btn-compressed-file"), "读取指定压缩类型的本地文件内容"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to readCompressedFileSyncTest, "id" to "btn-compressed-file-sync"), "同步读取指定压缩类型的本地文件内容"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to readZipEntry, "id" to "btn-readzip-entry"), "读取压缩包内的文件"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to testWriteReadFileSyncBuffer, "id" to "btn-writereadfilesync-buffer"), "同步写入/读取 ArrayBuffer"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to fun(){
                            testReadFileEncoding("base64")
                        }
                        ), "readFile(content://base64)", 8, _uA(
                            "onClick"
                        )),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to fun(){
                            testReadFileEncoding("utf-8")
                        }
                        ), "readFile(content://utf-8)", 8, _uA(
                            "onClick"
                        )),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to fun(){
                            testReadFileEncoding("ascii")
                        }
                        ), "readFile(content://ascii)", 8, _uA(
                            "onClick"
                        )),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to fun(){
                            testReadFileArrayBuffer()
                        }
                        ), "readFile(content://arraybuffer)", 8, _uA(
                            "onClick"
                        )),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to fun(){
                            testReadFileSyncEncoding("base64")
                        }
                        ), "readFileSync(content://base64)", 8, _uA(
                            "onClick"
                        )),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to fun(){
                            testReadFileSyncEncoding("utf-8")
                        }
                        ), "readFileSync(content://utf-8)", 8, _uA(
                            "onClick"
                        )),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to fun(){
                            testReadFileSyncEncoding("ascii")
                        }
                        ), "readFileSync(content://ascii)", 8, _uA(
                            "onClick"
                        )),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to fun(){
                            testReadFileSyncArrayBuffer()
                        }
                        ), "readFileSync(content://arraybuffer)", 8, _uA(
                            "onClick"
                        )),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to fun(){
                            copyFileByContent()
                        }
                        ), "copyFile(content://)", 8, _uA(
                            "onClick"
                        )),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to fun(){
                            copyFileSyncByContent()
                        }
                        ), "copyFileSync(content://)", 8, _uA(
                            "onClick"
                        )),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to getFileInfoByContent), "getFileInfo(content://)"),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to fun(){
                            gotoExplore()
                        }
                        ), "前往沙盒文件管理器", 8, _uA(
                            "onClick"
                        )),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to fun(){
                            gotoTestStatic()
                        }
                        ), "前往Static文件测试", 8, _uA(
                            "onClick"
                        )),
                        _cE("button", _uM("class" to "btnstyle", "type" to "primary", "onClick" to fun(){
                            gotoIssue26433()
                        }
                        ), "test issue-26433", 8, _uA(
                            "onClick"
                        )),
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
