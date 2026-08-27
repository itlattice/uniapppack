<template>
  <div class="configWindow position-fixed no-drag" v-if="show">
    <div class="mask" @click="closeWindow"></div>
    <div class="window">
      <div class="header justify-space-between">
        <div class="title unselectable">配置</div>
        <div class="action pointer">
          <div class="close icon iconfont icon-chacha1" @click="closeWindow"></div>
        </div>
      </div>
      <el-tabs type="border-card" style="margin-top: 10px">
        <el-tab-pane label="基础配置">
          <div class="formdata">
            <div class="formitem display-flex">
              <div class="label unselectable">HbuildX地址</div>
              <div class="inputbox">
                <input type="text" readonly v-model="hbuildPath" placeholder="HbuildX地址" class="cash-input input" />
              </div>
              <button class="cash-btn selectbtn" @click="chooseHbuildPath">选择位置</button>
            </div>
            <div class="formitem display-flex" style="margin-top:10px">
              <div class="label unselectable">打包临时文件</div>
              <div class="inputbox">
                <input type="text" readonly v-model="packPath" placeholder="打包临时文件" class="cash-input input" />
              </div>
              <button class="cash-btn selectbtn" @click="choosePackPath">选择位置</button>
            </div>
          </div>
        </el-tab-pane>
        <el-tab-pane label="Android配置">
          <div class="formdata">
            <div class="formline display-flex" style="height: 50px;margin-top: 10px;">
              <div class="formitem display-flex">
                <div class="label unselectable">安卓离线SDK地址</div>
                <div class="inputbox">
                  <input type="text" v-model="uniAndroidSDK" readonly placeholder="离线SDK地址" class="cash-input input" />
                  <div class="tips">下载完毕后解压后把解压后的文件夹放置于此，<a href="https://doc.dcloud.net.cn/uni-app-x/native/download/android.html" target="_blank">下载地址</a></div>
                </div>
                <button class="cash-btn selectbtn" @click="chooseUniAndroidSDK">选择位置</button>
              </div>
              <div class="formitem display-flex">
                <div class="label unselectable" style="width: 50px">版本号</div>
                <div class="inputbox" style="width: 100px;">
                  <input type="text" placeholder="SDK版本号" v-model="uniAndroidSDKVersion" style="width: 100px;" class="cash-input input" />
                </div>
              </div>
            </div>
            <div class="formline display-flex">
              <div class="formitem display-flex">
                <div class="label unselectable">安卓SDK地址</div>
                <div class="inputbox">
                  <input type="text" v-model="AndroidSDK" readonly placeholder="安卓SDK" class="cash-input input" />
                </div>
                <button class="cash-btn selectbtn" @click="chooseAndroidSDK">选择位置</button>
              </div>
            </div>
            <div class="formline display-flex">
              <div class="formitem display-flex">
                <div class="label unselectable">JDK地址</div>
                <div class="inputbox">
                  <input type="text" readonly v-model="JDKPath" placeholder="JDK地址" class="cash-input input" />
                </div>
                <button class="cash-btn selectbtn" @click="chooseJDKPath">选择位置</button>
              </div>
            </div>
            <div class="formitem display-flex">
              <div class="label unselectable">Gradle路径</div>
              <div class="inputbox">
                <input type="text" readonly v-model="GradlePath" placeholder="Gradle路径" class="cash-input input" />
              </div>
              <button class="cash-btn selectbtn" @click="chooseGradle">选择位置</button>
            </div>
            <div class="formitem display-flex" style="margin-top: 10px;">
              <div class="label unselectable">AndroidStudio路径</div>
              <div class="inputbox">
                <input type="text" readonly v-model="AndroidStudio" placeholder="AndroidStudio安装位置" class="cash-input input" />
              </div>
              <button class="cash-btn selectbtn" @click="chooseAndroidStudio">选择位置</button>
            </div>
          </div>
        </el-tab-pane>
        <el-tab-pane label="iOS配置">
          <div class="formdata">
            <div class="formline display-flex" style="height: 50px;margin-top: 10px;">
              <div class="formitem display-flex">
                <div class="label unselectable">iOS离线SDK地址</div>
                <div class="inputbox">
                  <input type="text" v-model="uniIosSDK" readonly placeholder="离线SDK地址" class="cash-input input" />
                  <div class="tips">下载完毕后解压后把解压后的文件夹放置于此，<a href="https://doc.dcloud.net.cn/uni-app-x/native/download/ios.html" target="_blank">下载地址</a></div>
                </div>
                <button class="cash-btn selectbtn" @click="chooseUniIosSDK">选择位置</button>
              </div>
              <div class="formitem display-flex">
                <div class="label unselectable" style="width: 50px">版本号</div>
                <div class="inputbox" style="width: 100px;">
                  <input type="text" placeholder="SDK版本号" v-model="uniIosSDKVersion" style="width: 100px;" class="cash-input input" />
                </div>
              </div>
            </div>
            <div class="formline display-flex">
              <div class="formitem display-flex">
                <div class="label unselectable">Xcode路径</div>
                <div class="inputbox">
                  <input type="text" v-model="XcodePath" readonly placeholder="Xcode路径（可选）" class="cash-input input" />
                </div>
                <button class="cash-btn selectbtn" @click="chooseXcodePath">选择位置</button>
              </div>
            </div>
          </div>
        </el-tab-pane>
      </el-tabs>
      <button class="cash-btn confirmbtn position-absolute" @click="confirmConfig">确认</button>
    </div>
  </div>
</template>

<script setup>
import {watch, defineProps, ref} from "vue";
import {$choosePath} from "@/common/file";
import {$readConfig, $toastSuccess, $writeConfig} from "@/common/common";

const props = defineProps({
  show:{
    type: Boolean,
    default: false
  }
})

const hbuildPath=ref('')
const packPath=ref('')
const uniAndroidSDK=ref('')
const uniAndroidSDKVersion=ref('');
const AndroidSDK=ref('')
const JDKPath=ref('')
const GradlePath=ref('')
const AndroidStudio=ref('')
const uniIosSDK=ref('')
const uniIosSDKVersion=ref('')
const XcodePath=ref('')

const emit=defineEmits(['update:show','close'])

const showWindow= async ()=>{
  var config=await $readConfig();
  console.log(config);
  if(config.hbuildPath==undefined){
    return;
  }
  hbuildPath.value=config.hbuildPath||'';
  packPath.value=config.packPath||'';
  uniAndroidSDK.value=config.uniAndroidSDK||'';
  uniAndroidSDKVersion.value=config.uniAndroidSDKVersion||'';
  AndroidSDK.value=config.AndroidSDK||'';
  JDKPath.value=config.JDKPath||'';
  GradlePath.value=config.GradlePath||'';
  AndroidStudio.value=config.AndroidStudio||'';
  uniIosSDK.value=config.uniIosSDK||'';
  uniIosSDKVersion.value=config.uniIosSDKVersion||'';
  XcodePath.value=config.XcodePath||'';
}

const hideWindow=()=>{
  hbuildPath.value=""
  packPath.value=""
  uniAndroidSDK.value=""
  uniAndroidSDKVersion.value=""
  AndroidSDK.value=""
  JDKPath.value=""
  GradlePath.value=""
  AndroidStudio.value=""
  uniIosSDK.value=""
  uniIosSDKVersion.value=""
  XcodePath.value=""
}

const closeWindow=()=>{
  emit('update:show',false)
  emit('close')
}

watch(()=>props.show,()=> {
  if (props.show) {
    showWindow()
  } else {
    hideWindow()
  }
});

const chooseHbuildPath=async ()=>{
  let path=await $choosePath();
  if(path) hbuildPath.value=path;
}

const chooseUniAndroidSDK=async ()=>{
  let path=await $choosePath();
  if(!path) return ;
  uniAndroidSDK.value=path;
  const versionMatch = path.match(/(\d+\.\d+)/);
  if (versionMatch) {
    console.log('识别的版本号:', versionMatch[1]); // 输出: 5.07
    uniAndroidSDKVersion.value=versionMatch[1];
  }
}
const choosePackPath=async ()=>{
  let path=await $choosePath();
  if(!path) return ;
  packPath.value=path;
}

const chooseAndroidSDK=async ()=>{
  let path=await $choosePath();
  if(!path) return ;
  AndroidSDK.value=path;
}

const chooseJDKPath=async ()=>{
  let path=await $choosePath();
  if(!path) return ;
  JDKPath.value=path;
}

const chooseGradle=async ()=>{
  let path=await $choosePath();
  if(!path) return ;
  GradlePath.value=path;
}

const chooseAndroidStudio=async ()=>{
  let path=await $choosePath();
  if(!path) return ;
  AndroidStudio.value=path;
}

const chooseUniIosSDK=async ()=>{
  let path=await $choosePath();
  if(!path) return ;
  uniIosSDK.value=path;
  const versionMatch = path.match(/(\d+\.\d+)/);
  if (versionMatch) {
    console.log('识别的iOS SDK版本号:', versionMatch[1]);
    uniIosSDKVersion.value=versionMatch[1];
  }
}

const chooseXcodePath=async ()=>{
  let path=await $choosePath();
  if(!path) return ;
  XcodePath.value=path;
}

const confirmConfig=async ()=>{
  var config={
    hbuildPath:hbuildPath.value,
    packPath:packPath.value,
    uniAndroidSDK:uniAndroidSDK.value,
    uniAndroidSDKVersion:uniAndroidSDKVersion.value,
    JDKPath:JDKPath.value,
    AndroidSDK:AndroidSDK.value,
    GradlePath:GradlePath.value,
    AndroidStudio:AndroidStudio.value,
    uniIosSDK:uniIosSDK.value,
    uniIosSDKVersion:uniIosSDKVersion.value,
    XcodePath:XcodePath.value
  }
  console.log(config);
  var configFile=await $writeConfig(config);
  $toastSuccess('配置成功');
  closeWindow()
}

</script>

<style scoped lang="less">
.configWindow {
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 999;
  .mask{
    position: absolute;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    background: #00000099;
  }
  .window{
    background: white;
    position: fixed;
    overflow-x: hidden;
    overflow-y: scroll;
    scrollbar-width: none; /* Firefox */
    -ms-overflow-style: none; /* IE/Edge */
    width: 700px;
    height: 500px;
    left: 100px;
    top: 50px;
    border-radius: 10px;
    box-shadow: 1px 2px 9px #353535;
    .header{
      font-size: 14px;
      padding-left: 10px;
      .title{
        padding-top: 10px;

      }
      .action{
        height: 30px;
        width: 30px;
        .close{
          text-align: center;
          line-height: 30px;
        }
      }
      .action:hover{
        background: red;
        color: white;
      }
    }
    .formdata{
      padding-top: 10px;
      border: 1px solid #ececec;
      width: 670px;
      margin-top: 8px;
      height: 300px;
      border-radius: 8px;
      .formline{
        gap: 20px;
        margin-bottom: 10px;
      }
      .label{
        line-height: 28px;
        font-size: 14px;
        color: #353535;
        width: 140px;
        margin-right: 10px;
        text-align: right;
      }
      .inputbox{
        height: 28px;
        width: 200px;
        .input{
          border: 1px solid #ececec;
          height: 28px;
          line-height: 28px;
          font-size: 13px;
          width: 200px;
        }
        .tips{
          font-size: 10px;
          position: absolute;
          color: #ff3c3c;
          a{
            color: #880000;
          }
        }
      }
      .selectbtn{
        height: 28px;
        line-height: 28px;
        width: 80px;
        font-size: 13px;
        margin-left: 10px;
      }
    }
    .confirmbtn{
      left: 300px;
      bottom: 10px;
      height: 40px;
      width: 80px;
    }
  }
  .window::-webkit-scrollbar {
    display: none;
  }
}
</style>