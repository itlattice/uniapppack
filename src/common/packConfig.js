import {$fileExists, $readFile,$pathExists} from "@/common/file";
import JSON5 from 'json5';
import {$readConfig, $toastError} from "@/common/common";
import {$insertDB, $queryDB, $runSql} from "@/utils/sqlitecommon";

export async function $checkSubjectPath(path){
    /**
     * 检测 APPID、读取本地发行资源，并加载缓存的项目配置。
     * 现同时支持 Android / iOS 资源探测，避免把 app-android 作为唯一前置条件。
     */
    var manifestJsonFile=path+'/manifest.json';
    if(!(await $fileExists(manifestJsonFile))){
        $toastError('manifest.json文件不存在，请检查路径是否正确');
        return false;
    }
    var manifestJson=await $readFile(manifestJsonFile);
    var manifest=JSON5.parse(manifestJson);
    console.log(manifest);
    var androidPath=path+'/unpackage\\resources\\app-android';
    var iosPath=path+'/unpackage\\resources\\app-ios';
    var hasAndroidResources=await $pathExists(androidPath);
    var hasIosResources=await $pathExists(iosPath);
    if(!hasAndroidResources&&!hasIosResources){
        $toastError("请先在HBuilderX生成本地打包资源");
        return  false;
    }
    var result={
        name:manifest.name,
        appid:manifest.appid,
        description:manifest.description,
        versionName:manifest.versionName,
        versionCode:manifest.versionCode,
        resources:{
            android:hasAndroidResources,
            ios:hasIosResources
        }
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
    configData.resources={
        android:hasAndroidResources,
        ios:hasIosResources
    }
    if(configData.android&&configData.android.androidKeystore){
        var keystoreFile=configData.android.androidKeystore;
        if(!(await $fileExists(keystoreFile))){
            delete configData.android.androidKeystore;
        }
    }
    return {
        ...result,
        ...configData,
        resources:configData.resources
    };
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
      config.packPath==undefined||config.packPath==''||
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

export async function $checkIosConfig(){
    var config=await $readConfig();
    console.log(config);
    if(config.hbuildPath==undefined||config.hbuildPath==''||
      config.packPath==undefined||config.packPath==''||
      config.uniIosSDK==undefined||config.uniIosSDK==''||
      config.uniIosSDKVersion==undefined||config.uniIosSDKVersion==''
    ){
        return false;
    }

    return config;
}

export default {
    $checkSubjectPath,
    $checkAndroidConfig,
    $checkIosConfig,
    $setSubjectConfig
}