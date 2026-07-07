import {$fileExists, $readFile,$pathExists} from "@/common/file";
import JSON5 from 'json5';
import {$readConfig, $toastError} from "@/common/common";
import {$insertDB, $queryDB, $runSql} from "@/utils/sqlitecommon";

export async function $checkSubjectPath(path){
    /**
     * 检测APPID以获取数据位置包
     * 检测是否有离线本地包可用
     * 根据本地目录地址加载缓存的配置数据
     *  无配置数据的，检测根目录是否有keystore文件
     */
    var manifestJsonFile=path+'/manifest.json';
    if(!(await $fileExists(manifestJsonFile))){
        $toastError('manifest.json文件不存在，请检查路径是否正确');
        return false;
    }
    var manifestJson=await $readFile(manifestJsonFile);
    var manifest=JSON5.parse(manifestJson);
    console.log(manifest);
    var result={
        name:manifest.name,
        appid:manifest.appid,
        description:manifest.description,
        versionName:manifest.versionName,
        versionCode:manifest.versionCode,
    }
    // G:\market\pdaapp\unpackage\resources\app-android
    var androidPath=path+'/unpackage\\resources\\app-android';
    if(!(await $pathExists(androidPath))){
        $toastError("请先进行本地打包");
        return  false;
    }
    var config=await $queryDB("select * from subject where path='"+path+"'");
    console.log(config);
    if(config.length<1){
        return result;
    }
    config=config[0].config;
    if(!config){
        return result;
    }
    var configData=JSON5.parse(config);
    if(configData===undefined||configData==null){
        return result;
    }
    if(configData.android==undefined||configData.android.androidKeystore==undefined){
        return result;
    }
    var keystoreFile=configData.android.androidKeystore;
    if(!(await $fileExists(keystoreFile))){
        return result;
    }
    return configData;
}

export async function $setSubjectConfig(path,config){
    var json=JSON.stringify(config);
    var countSql="select count(*) as count from subject where path='"+path+"'";
    var countData=await $queryDB(countSql);
    console.log(countData);
    if(countData===undefined||countData==null||countData[0]['count']<1){
        await $insertDB('subject',{
            path:path,
            config:json
        })
        return true;
    }
    var sql="update subject set config='"+json+"' where path='"+path+"'";
    $runSql(sql);
    return true;
}

export async function $checkAndroidConfig(){
    var config=await $readConfig();
    console.log(config);
    if(config.hbuildPath==undefined||config.hbuildPath==''||
      config.uniAndroidSDK==undefined||config.uniAndroidSDK==''||
      config.uniAndroidSDKVersion==undefined||config.uniAndroidSDKVersion==''||
      config.JDKPath==undefined||config.JDKPath==''||
      config.AndroidSDK==undefined||config.AndroidSDK==''||
      config.GradlePath==undefined||config.GradlePath==''||
      config.AndroidStudio==undefined||config.AndroidStudio==''
    ){
        return false;
    }

    return config;
}

export default {
    $checkSubjectPath,
    $checkAndroidConfig,
    $setSubjectConfig
}