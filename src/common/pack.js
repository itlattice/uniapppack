import {$readConfig} from "@/common/common";
import {$pathExists} from "@/common/file";

const { ipcRenderer } = window.require('electron')

var callLog=()=>{}

function toPlainPackConfig(config) {
    // 这里必须把 Vue 响应式对象转换成普通 JSON，
    // 否则 Electron 的 ipcRenderer.invoke 在结构化克隆阶段会直接报错。
    return JSON.parse(JSON.stringify(config || {}))
}

async function checkSDK(){
    var config=await $readConfig();
    if(!(await $pathExists(config.uniAndroidSDK))){
        callLog("错误：Uniapp离线AndroidSDK包不存在，请检查");
        return false;
    }
    var sdkPath=config.uniAndroidSDK+"/SDK/libs";
    var pluginPath=config.uniAndroidSDK+"/plugins";
    if(!(await $pathExists(sdkPath))){
        callLog("错误：Uniapp离线AndroidSDK包不完整，请检查");
        return false;
    }
    if(!(await $pathExists(pluginPath))) {
        callLog("错误：Uniapp离线AndroidSDK插件包不存在，请检查");
        return false;
    }
    return true;
}

/**
 * 安卓打包Uniappx
 * @param config
 * @param pushLog
 */
export async function $packAndroidAppUniappx(config,pushLog){
    callLog=pushLog;
    const plainConfig = toPlainPackConfig(config)
    let check=await checkSDK(); //检查离线SDK情况
    if(!check){
        return false;
    }
    var appPath=plainConfig.android.path+"\\unpackage\\resources\\app-android";
    if(!(await $pathExists(appPath))){
        callLog("错误：Uniapp离线Android应用包不存在，请检查");
        return false;
    }
    const onLog = (event, payload = {}) => {
        callLog(payload.message || '', payload.color || 'white')
    }
    ipcRenderer.on('uniappx:pack-log', onLog)
    try {
        // 当前渲染层只负责发起请求和显示日志；
        // 真正的工程生成、文件复制、gradle 模板渲染都在主进程处理。
        return await ipcRenderer.invoke('uniappx:generate-android-gradle', plainConfig);
    } finally {
        ipcRenderer.removeListener('uniappx:pack-log', onLog)
    }
}

export default {
    $packAndroidAppUniappx
}