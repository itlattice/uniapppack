<template>
<div class="packwindow position-fixed" v-if="show">
  <div class="mask" @click="closeWindow"></div>
  <div class="window" ref="containerRef">
    <div class="line" v-for="(item,index) in messages" :key="`${index}-${item.content}`" :style="{color:item.color||'white'}">{{item.content}}</div>
  </div>

</div>
</template>
<script setup>
import { ref, watch, nextTick, onMounted,defineProps } from 'vue'
import {$getCurrentTime} from "@/common/common";
import {$packAndroidAppUniappx} from "@/common/pack";
import {$pushPackLog} from "@/common/file";

const containerRef = ref(null)

const props=defineProps({
  show:{
    type:Boolean,
    default:false
  },
  config:{
    type:Object,
    default:()=>({})
  }
})

const emit=defineEmits(['update:show','close'])

const messages=ref([])

const closeWindow=()=>{
  emit('update:show',false)
  emit('close')
}

const scrollToBottom = () => {
  if (containerRef.value) {
    containerRef.value.scrollTop = containerRef.value.scrollHeight
  }
}

// 监听消息变化，自动滚动到底部
watch(messages, async () => {
  await nextTick()
  scrollToBottom()
}, { deep: true })

let messageIndex=0;
watch(()=>props.show,()=>{
  if(props.show){
    scrollToBottom()
    // var index=0;
    // messageIndex=setInterval(()=>{
    //   messages.value.push('aaaa'+index);
    //   index++;
    //   console.log(props.config)
    // },1000)
  } else{
    messages.value=[];
    clearInterval(messageIndex)
  }
})

const pushLog=(log,color='white')=>{
  var time=$getCurrentTime();
  var contennt=time+" "+log;
  messages.value.push({content:contennt,color:color})
  $pushPackLog(contennt)
}

const startPack=async ()=>{
  console.log('开始打包',props.config)
  pushLog("开始打包"+ JSON.stringify(props.config))
  pushLog("检查配置中...")
  try {
    const result = await $packAndroidAppUniappx(props.config,pushLog);
    if (result?.projectDir) {
      pushLog(`原生工程目录：${result.projectDir}`,'#67c23a')
    }
    if (result?.targetApkPath) {
      pushLog(`临时目录 APK：${result.targetApkPath}`,'#67c23a')
    }
    if (result?.debugProjectApkPath) {
      pushLog(`项目调试 APK：${result.debugProjectApkPath}`,'#67c23a')
    }
    pushLog("打包完成，即将关闭",'#67c23a')
  } catch (error) {
    pushLog(error?.message || '打包失败','#f56c6c')
    return
  }
  setTimeout(()=>{
    closeWindow();
  },5000)
}

defineExpose({
  startPack
})

</script>

<style scoped lang="less">
.packwindow {
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
    background: black;
    color: #e8e8e8;
    padding: 10px;
    position: fixed;
    overflow-x: hidden;
    overflow-y: scroll;
    scrollbar-width: none; /* Firefox */
    -ms-overflow-style: none; /* IE/Edge */
    width: 500px;
    height: 300px;
    left: 200px;
    top: 130px;
    border-radius: 10px;
    box-shadow: 1px 2px 9px #353535;
  }
  .window::-webkit-scrollbar {
    display: none;
  }
}
</style>