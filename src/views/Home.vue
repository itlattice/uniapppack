<template>
  <div class="home">
    <div class="header background-main justify-space-between drag-region unselectable">
      <div class="title color-white">懒猿UNIAPP(X)打包机</div>
      <div class="actions display-flex color-white no-drag pointer">
        <div class="icon iconfont icon-shezhi no-drag" @click="Config"></div>
        <div class="icon iconfont icon-chacha1 no-drag" @click="Close"></div>
      </div>
      <div class="pagetabs display-flex position-fixed no-drag pointer">
        <div class="tab no-drag" :class="pageTab=='uniappx'?'active':''" style="padding-left: 10px" @click="pageTab='uniappx'">Uniappx</div>
        <div class="tab no-drag" :class="pageTab=='uniapp'?'active':''" style="padding-right: 10px;" @click="pageTab='uniapp'">Uniapp</div>
      </div>
    </div>
    <div class="page" v-if="pageTab=='uniappx'">
      <el-tabs type="border-card">
        <el-tab-pane label="Android">
          <div class="packpage background-white content-scroll position-relative">
            <div class="formitem display-flex" style="height: 50px;">
              <div class="label unselectable">项目地址</div>
              <div class="input">
                <input type="text" readonly placeholder="选择项目所在位置" class="cash-input inputbox" v-model="subjectPath" />
                <div class="tips">请先进行本地打包，打包机将基于本地打包文件进行整合</div>
              </div>
              <button class="cash-btn selectbtn" @click="chooseSubjectPath">选择文件夹</button>
              <div style="height: 32px">
                <el-radio-group v-model="packType" :options="packTypeOptions" :props="props" />
              </div>
            </div>
            <div class="formdata">
              <div class="form-line display-flex">
                <div class="formitem display-flex">
                  <div class="label">包名</div>
                  <div class="packinput" style="width: 300px">
                    <input type="text" placeholder="安卓包名" v-model="androidPackName" style="width: 300px" class="cash-input inputbox" />
                  </div>
                </div>
                <div class="formitem display-flex">
                  <div class="label">证书类型</div>
                  <div class="packinput" style="margin-top: -4px;">
                    <el-radio-group v-model="keyType" :options="keyTypeOptions" :props="props" />
                  </div>
                </div>
              </div>
              <div class="form-line display-flex">
                <div class="formitem display-flex">
                  <div class="label">证书文件</div>
                  <div class="packinput" style="width: 230px">
                    <input type="text" v-model="androidKeystore" readonly style="width: 220px" placeholder="证书文件" class="cash-input inputbox" />
                  </div>
                  <button class="cash-btn selectbtn" @click="chooseSubjectAndroidKeystore">选择文件</button>
                </div>
                <div class="formitem display-flex">
                  <div class="label">证书别名</div>
                  <div class="packinput">
                    <input type="text" v-model="androidKeyAlias" placeholder="证书别名" class="cash-input inputbox" />
                  </div>
                </div>
              </div>
              <div class="form-line display-flex">
                <div class="formitem display-flex">
                  <div class="label">证书库密码</div>
                  <div class="packinput"  style="width: 300px">
                    <input type="text" v-model="androidKeyPassword" style="width: 300px" placeholder="证书库密码" class="cash-input inputbox" />
                  </div>
                </div>
                <div class="formitem display-flex">
                  <div class="label">证书密码</div>
                  <div class="packinput">
                    <input type="text" v-model="androidKeyPwd" placeholder="证书密码" class="cash-input inputbox" />
                  </div>
                </div>
              </div>
              <div class="form-line display-flex">
                <div class="formitem display-flex" style="width: 100%; align-items: flex-start;">
                  <div class="label">原生库冲突处理</div>
                  <div class="packinput" style="width: 580px">
                    <input
                      type="text"
                      v-model="androidNativeLibPickFirsts"
                      style="width: 580px"
                      placeholder="按英文逗号分隔，例如 lib/*/libc++_shared.so"
                      class="cash-input inputbox"
                    />
                    <div class="tips">留空表示不启用；仅在当前项目存在 so 合并冲突时填写</div>
                  </div>
                </div>
              </div>
              <button class="cash-btn packbtn" @click="androidPackStart">打包</button>
            </div>
          </div>
        </el-tab-pane>
        <el-tab-pane label="iOS">
          <div class="packpage background-white content-scroll position-relative">
            <div class="formitem display-flex" style="height: 50px;">
              <div class="label unselectable">项目地址</div>
              <div class="input">
                <input type="text" readonly placeholder="选择项目所在位置" class="cash-input inputbox" v-model="subjectPath" />
                <div class="tips">请先在 HBuilderX 生成 iOS 本地打包资源，打包机将基于 app-ios 资源生成原生工程</div>
              </div>
              <button class="cash-btn selectbtn" @click="chooseSubjectPath">选择文件夹</button>
              <div style="height: 32px">
                <el-radio-group v-model="packType" :options="packTypeOptions" :props="props" />
              </div>
            </div>
            <div class="formdata">
              <div class="form-line display-flex">
                <div class="formitem display-flex">
                  <div class="label">Bundle ID</div>
                  <div class="packinput" style="width: 300px">
                    <input type="text" placeholder="iOS Bundle ID" v-model="iosBundleId" style="width: 300px" class="cash-input inputbox" />
                  </div>
                </div>
                <div class="formitem display-flex">
                  <div class="label">渠道</div>
                  <div class="packinput">
                    <input type="text" v-model="iosChannel" placeholder="默认 appstore" class="cash-input inputbox" />
                  </div>
                </div>
              </div>
              <div class="form-line display-flex">
                <div class="formitem display-flex">
                  <div class="label">广告联盟ID</div>
                  <div class="packinput" style="width: 300px">
                    <input type="text" v-model="iosUnionid" style="width: 300px" placeholder="可选，不开通 uniad 可留空" class="cash-input inputbox" />
                  </div>
                </div>
                <div class="formitem display-flex">
                  <div class="label">隐私弹窗</div>
                  <div class="packinput" style="margin-top: -4px;">
                    <el-radio-group v-model="iosInitPrivacyAuthorization" :options="iosPrivacyOptions" :props="props" />
                  </div>
                </div>
              </div>
              <div class="form-line display-flex">
                <div class="formitem display-flex" style="width: 100%; align-items: flex-start;">
                  <div class="label">说明</div>
                  <div class="packinput" style="width: 580px">
                    <div class="tips" style="position: static; color: #666; line-height: 22px;">
                      当前版本仅生成 iOS 原生工程并打开目录，不执行 Xcode 编译、签名和 IPA 导出。
                    </div>
                  </div>
                </div>
              </div>
              <button class="cash-btn packbtn" @click="iosPackStart">生成工程</button>
            </div>
          </div>
        </el-tab-pane>
      </el-tabs>
    </div>
    <div class="page" v-if="pageTab=='uniapp'">
      <el-tabs type="border-card">
        <el-tab-pane label="Android">
          <div class="packpage background-white content-scroll position-relative">
            <div class="formitem display-flex" style="height: 50px;">
              <div class="label unselectable">项目地址</div>
              <div class="input">
                <input type="text" readonly placeholder="选择项目所在位置" class="cash-input inputbox" v-model="subjectPath" />
                <div class="tips">请先进行本地打包，打包机将基于本地打包文件进行整合</div>
              </div>
              <button class="cash-btn selectbtn" @click="chooseSubjectPath">选择文件夹</button>
              <div style="height: 32px">
                <el-radio-group v-model="packType" :options="packTypeOptions" :props="props" />
              </div>
            </div>
            <div class="formdata">
              <div class="form-line display-flex">
                <div class="formitem display-flex">
                  <div class="label">包名</div>
                  <div class="packinput" style="width: 300px">
                    <input type="text" placeholder="安卓包名" v-model="androidPackName" style="width: 300px" class="cash-input inputbox" />
                  </div>
                </div>
                <div class="formitem display-flex">
                  <div class="label">证书类型</div>
                  <div class="packinput" style="margin-top: -4px;">
                    <el-radio-group v-model="keyType" :options="keyTypeOptions" :props="props" />
                  </div>
                </div>
              </div>
              <div class="form-line display-flex">
                <div class="formitem display-flex">
                  <div class="label">证书文件</div>
                  <div class="packinput" style="width: 230px">
                    <input type="text" v-model="androidKeystore" readonly style="width: 220px" placeholder="证书文件" class="cash-input inputbox" />
                  </div>
                  <button class="cash-btn selectbtn" @click="chooseSubjectAndroidKeystore">选择文件</button>
                </div>
                <div class="formitem display-flex">
                  <div class="label">证书别名</div>
                  <div class="packinput">
                    <input type="text" v-model="androidKeyAlias" placeholder="证书别名" class="cash-input inputbox" />
                  </div>
                </div>
              </div>
              <div class="form-line display-flex">
                <div class="formitem display-flex">
                  <div class="label">证书库密码</div>
                  <div class="packinput"  style="width: 300px">
                    <input type="text" v-model="androidKeyPassword" style="width: 300px" placeholder="证书库密码" class="cash-input inputbox" />
                  </div>
                </div>
                <div class="formitem display-flex">
                  <div class="label">证书密码</div>
                  <div class="packinput">
                    <input type="text" v-model="androidKeyPwd" placeholder="证书密码" class="cash-input inputbox" />
                  </div>
                </div>
              </div>
              <button class="cash-btn packbtn" @click="androidPackStartUniapp">打包</button>
            </div>
          </div>
        </el-tab-pane>
        <el-tab-pane label="iOS">
          <div class="packpage background-white content-scroll position-relative">
            <div class="formitem display-flex" style="height: 50px;">
              <div class="label unselectable">项目地址</div>
              <div class="input">
                <input type="text" readonly placeholder="选择项目所在位置" class="cash-input inputbox" v-model="subjectPath" />
                <div class="tips">请先在 HBuilderX 生成 iOS 本地打包资源</div>
              </div>
              <button class="cash-btn selectbtn" @click="chooseSubjectPath">选择文件夹</button>
              <div style="height: 32px">
                <el-radio-group v-model="packType" :options="packTypeOptions" :props="props" />
              </div>
            </div>
            <div class="formdata">
              <div class="form-line display-flex">
                <div class="formitem display-flex">
                  <div class="label">Bundle ID</div>
                  <div class="packinput" style="width: 300px">
                    <input type="text" placeholder="iOS Bundle ID" v-model="iosBundleId" style="width: 300px" class="cash-input inputbox" />
                  </div>
                </div>
              </div>
              <div class="form-line display-flex">
                <div class="formitem display-flex" style="width: 100%; align-items: flex-start;">
                  <div class="label">说明</div>
                  <div class="packinput" style="width: 580px">
                    <div class="tips" style="position: static; color: #666; line-height: 22px;">
                      传统 uni-app 仅生成 iOS 原生工程并打开目录，不执行 Xcode 编译、签名和 IPA 导出。
                    </div>
                  </div>
                </div>
              </div>
              <button class="cash-btn packbtn" @click="iosPackStartUniapp">生成工程</button>
            </div>
          </div>
        </el-tab-pane>
      </el-tabs>
    </div>
    <div class="status justify-space-between unselectable" style="cursor: default" @click="handleClick">
      <div class="status-item">版本号:V1.0.0 (最高支持HbuildX5.14)</div>
      <div class="status-item"></div>
    </div>
    <pack ref="packRef" v-model:show="showPackWindow" :config="subjectBasicData"></pack>
    <configWindow v-model:show="showConfigWindow"></configWindow>
  </div>
</template>

<script setup>
import {onMounted, ref} from 'vue'
import {$chooseFile, $choosePath} from "@/common/file";
import {$checkAndroidConfig, $checkIosConfig, $checkSubjectPath, $setSubjectConfig} from "@/common/packConfig";
import {$hideLoading, $showLoading, $toastError,$showConfirm} from "@/common/common";
import {handleClick} from '@/common/Home'

import {$packAndroidAppUniappx} from "@/common/pack";
import Pack from "@/components/pack.vue";
import {$closeApp} from "@/common/window";
import {$getStorage, $setStorage} from "@/common/storage";
const packType = ref(2)
const props = { value: 'id', label: 'name' }
const pageTab=ref('uniappx')
const packRef=ref(null);
const packTypeOptions = [
  {
    id: 1,
    name: '自定义基座',
  },
  {
    id: 2,
    name: '正式打包',
  }
]
const iosPrivacyOptions = [
  {
    id: true,
    name: '默认同意',
  },
  {
    id: false,
    name: '不默认同意',
  }
]
const showPackWindow=ref(false)
const showConfigWindow=ref(false)

const keyType=ref(1);
const keyTypeOptions = [
  {
    id: 1,
    name:'自选证书'
  }
]
const subjectBasicData=ref({})


const subjectPath=ref('')  //项目位置
const androidPackName=ref('');  //安卓包名
const androidKeystore=ref('');  //安卓证书文件
const androidKeyAlias=ref('');  //安卓证书别名
const androidKeyPassword=ref('');  //安卓证书库密码
const androidKeyPwd=ref(''); //安卓证书密码
const androidNativeLibPickFirsts=ref('');
const iosBundleId=ref('');
const iosChannel=ref('appstore');
const iosUnionid=ref('');
const iosInitPrivacyAuthorization=ref(true);

const parseNativeLibPickFirsts = (value) => {
  return String(value || '')
    .split(',')
    .map((item) => item.trim())
    .filter(Boolean)
}

const readSubjectConfig=async (path)=>{
  let subject=await $checkSubjectPath(path);
  if(!subject){
    return false;
  }
  console.log(subject);
  subjectBasicData.value=subject;
  if(!subject.android){
    androidPackName.value='';
    androidKeystore.value='';
    androidKeyAlias.value='';
    androidKeyPassword.value='';
    androidKeyPwd.value='';
    androidNativeLibPickFirsts.value='';
  } else {
    androidPackName.value=subject.android.androidPackName;
    androidKeystore.value=subject.android.androidKeystore;
    androidKeyAlias.value=subject.android.androidKeyAlias;
    androidKeyPassword.value=subject.android.androidKeyPassword;
    androidKeyPwd.value=subject.android.androidKeyPwd;
    androidNativeLibPickFirsts.value=(subject.android.nativeLibPickFirsts || []).join(', ');
  }
  if(!subject.ios){
    iosBundleId.value='';
    iosChannel.value='appstore';
    iosUnionid.value='';
    iosInitPrivacyAuthorization.value=true;
    return true;
  }
  iosBundleId.value=subject.ios.iosBundleId || '';
  iosChannel.value=subject.ios.iosChannel || 'appstore';
  iosUnionid.value=subject.ios.iosUnionid || '';
  iosInitPrivacyAuthorization.value=subject.ios.initPrivacyAuthorization !== false;
  return true;
}

const chooseSubjectAndroidKeystore=async ()=>{
  let file=await $chooseFile('keystore');
  console.log(file);
  if(!file){
    return false;
  }
  androidKeystore.value=file;
}

const chooseSubjectPath=async ()=>{
  let path=await $choosePath()
  if(!path){
    return;
  }
  subjectPath.value=path
  readSubjectConfig(path)
  $setStorage('subjectpath',path);
}

const androidPackStart=async ()=>{
  subjectBasicData.value.packPlatform='android'
  subjectBasicData.value.android={
    path:subjectPath.value,
    packType:packType.value,
    androidPackName:androidPackName.value,
    androidKeystore:androidKeystore.value,
    androidKeyAlias:androidKeyAlias.value,
    androidKeyPassword:androidKeyPassword.value,
    androidKeyPwd:androidKeyPwd.value,
    nativeLibPickFirsts:parseNativeLibPickFirsts(androidNativeLibPickFirsts.value)
  }
  if(subjectPath.value==''){
    $toastError('请选择项目位置');
    return false;
  }
  if(androidPackName.value==''){
    $toastError('请输入安卓包名');
    return false;
  }
  if(androidKeystore.value==''||androidKeyAlias.value==''||androidKeyPassword.value==''||androidKeyPwd.value==''){
    $toastError('请完善安卓证书信息');
    return false;
  }
  var loading=$showLoading('打包中，请稍等');
  $setSubjectConfig(subjectPath.value,subjectBasicData.value);
  console.log(subjectBasicData.value);
  var check=await $checkAndroidConfig();
  if(!check){
    $toastError("请先完成Android打包环境配置")
    $hideLoading(loading)
    return false;
  }
  showPackWindow.value=true;
  $hideLoading(loading);
  packRef.value?.startPack();
}
const iosPackStart=async ()=>{
  if(subjectPath.value==''){
    $toastError('请选择项目位置');
    return false;
  }
  if(iosBundleId.value==''){
    $toastError('请输入 iOS Bundle ID');
    return false;
  }
  if(subjectBasicData.value.resources && subjectBasicData.value.resources.ios===false){
    $toastError('当前项目缺少 iOS 本地打包资源，请先在 HBuilderX 生成 app-ios 资源');
    return false;
  }
  subjectBasicData.value.packPlatform='ios'
  subjectBasicData.value.ios={
    path:subjectPath.value,
    packType:packType.value,
    iosBundleId:iosBundleId.value,
    iosChannel:iosChannel.value||'appstore',
    iosUnionid:iosUnionid.value,
    initPrivacyAuthorization:iosInitPrivacyAuthorization.value
  }
  var loading=$showLoading('生成 iOS 工程中，请稍等');
  $setSubjectConfig(subjectPath.value,subjectBasicData.value);
  console.log(subjectBasicData.value);
  var check=await $checkIosConfig();
  if(!check){
    $toastError("请先完成 iOS 打包环境配置")
    $hideLoading(loading)
    return false;
  }
  showPackWindow.value=true;
  $hideLoading(loading);
  packRef.value?.startPack();
}

const androidPackStartUniapp=async ()=>{
  subjectBasicData.value.packPlatform='android'
  subjectBasicData.value.appType='uniapp'
  subjectBasicData.value.android={
    path:subjectPath.value,
    packType:packType.value,
    androidPackName:androidPackName.value,
    androidKeystore:androidKeystore.value,
    androidKeyAlias:androidKeyAlias.value,
    androidKeyPassword:androidKeyPassword.value,
    androidKeyPwd:androidKeyPwd.value
  }
  if(subjectPath.value==''){
    $toastError('请选择项目位置');
    return false;
  }
  if(androidPackName.value==''){
    $toastError('请输入安卓包名');
    return false;
  }
  if(androidKeystore.value==''||androidKeyAlias.value==''||androidKeyPassword.value==''||androidKeyPwd.value==''){
    $toastError('请完善安卓证书信息');
    return false;
  }
  var loading=$showLoading('打包中，请稍等');
  $setSubjectConfig(subjectPath.value,subjectBasicData.value);
  console.log(subjectBasicData.value);
  var check=await $checkAndroidConfig();
  if(!check){
    $toastError("请先完成Android打包环境配置")
    $hideLoading(loading)
    return false;
  }
  showPackWindow.value=true;
  $hideLoading(loading);
  packRef.value?.startPack();
}

const iosPackStartUniapp=async ()=>{
  if(subjectPath.value==''){
    $toastError('请选择项目位置');
    return false;
  }
  if(iosBundleId.value==''){
    $toastError('请输入 iOS Bundle ID');
    return false;
  }
  if(subjectBasicData.value.resources && subjectBasicData.value.resources.ios===false){
    $toastError('当前项目缺少 iOS 本地打包资源，请先在 HBuilderX 生成资源');
    return false;
  }
  subjectBasicData.value.packPlatform='ios'
  subjectBasicData.value.appType='uniapp'
  subjectBasicData.value.ios={
    path:subjectPath.value,
    packType:packType.value,
    iosBundleId:iosBundleId.value
  }
  var loading=$showLoading('生成 iOS 工程中，请稍等');
  $setSubjectConfig(subjectPath.value,subjectBasicData.value);
  console.log(subjectBasicData.value);
  var check=await $checkIosConfig();
  if(!check){
    $toastError("请先完成 iOS 打包环境配置")
    $hideLoading(loading)
    return false;
  }
  showPackWindow.value=true;
  $hideLoading(loading);
  packRef.value?.startPack();
}

const Config=()=>{
  showConfigWindow.value=true;
}

const Close=async ()=>{
  let res=await $showConfirm('确定退出吗？');
  console.log(res);
  if(!res) return;
  $closeApp();
}

onMounted(()=>{
  var path=$getStorage('subjectpath');
  console.log(path);
  if(path==''||path==null){
    return;
  }
  subjectPath.value=path
  readSubjectConfig(path)
})

</script>

<style scoped lang="less">
@import "@/styles/theme";
.home{
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  overflow: hidden;
  border-radius: 10px;
  .header{
    flex: 0 0 50px;
    height: 50px;
    line-height: 50px;
    .title{
      padding-left: 20px;
    }
    .actions{
      gap: 0px;
      padding-right: 0px;
      .icon{
        font-size: 24px;
        width: 50px;
        text-align: center;
      }
      .icon:hover{
        background: rgb(255 0 0 / 0.7);
      }
    }
  }
  .pagetabs{
    left: 339px;
    width: 200px;
    z-index: 999;
    background: #FFFFFF99;
    height: 32px;
    top: 9px;
    border-radius: 16px;
    color: white;
    overflow: hidden;
    .tab{
      width: 100px;
      text-align: center;
      line-height: 32px;
      font-size: 18px;
    }
    .active{
      background: white;
      color: @main-color;
    }
  }
  .packpage{
    height: 100%;
    overflow: hidden;
    box-sizing: border-box;
    .formdata{
      width: 100%;
      max-width: 840px;
      min-height: 360px;
      margin-bottom: -10px;
      border: 1px solid #e1e1e1;
      border-radius: 6px;
      margin-top: 10px;
      position: relative;
      .packbtn{
        position: absolute;
        right: 30px;
        font-size: 20px;
        bottom: 20px;
        height:60px;
        width: 120px;
      }
    }
    .formitem{
      .label{
        line-height: 32px;
        font-size: 16px;
        /* 核心属性：禁止用户选择文本 */
        user-select: none;
        /* 兼容旧版浏览器/内核的前缀（可选，Electron基于Chrome，新版可省略） */
        -webkit-user-select: none; /* Webkit内核（Chrome/Safari/Electron） */
        -moz-user-select: none; /* Firefox */
        -ms-user-select: none; /* IE/Edge */
      }
    }
  }
  .cash-input{
    border: 1px solid #e1e1e1;
    border-radius: 4px;
  }
  .tips{
    font-size: 13px;
    color: red;
  }
  .input{
    height: 32px;
    margin-left: 10px;
    width: 400px;
    margin-right: 15px;
    .inputbox{
      width: 400px;
      height: 32px;
      line-height: 32px;
    }
  }
  .selectbtn{
    height: 32px;
    line-height: 32px;
    padding: 0 10px;
    margin-right: 30px;
  }
}
.page{
  flex: 1;
  min-height: 0;
  overflow: hidden;
}
.status{
  flex: 0 0 25px;
  padding-left: 16px;
  padding-right: 16px;
  font-size: 12px;
  line-height: 25px;
  .status-item{
    color: #717171;
  }
}
.formdata{
  padding: 10px;
  font-size: 14px;
  .form-line{
    margin-bottom: 16px;
    gap: 40px;
    .formitem{
      .label{
        line-height: 24px;
        height: 24px;
        font-size: 14px;
        margin-right: 10px;
        width: 80px;
        text-align: right;
      }
      .packinput{
        line-height: 24px;
        height: 26px;
      }
      .selectbtn{
        height: 26px;
        line-height: 26px;
      }
    }
  }
}
</style>
