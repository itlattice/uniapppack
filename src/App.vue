<template>
  <router-view></router-view>
</template>

<script setup>
import { onBeforeMount, onMounted } from 'vue'

onBeforeMount(async () => {

})

onMounted(async () => {

})
</script>

<style lang="less">
html,
body,
#app {
  width: 100%;
  height: 100%;
  margin: 0;
}

body {
  background-color: #f5f8fb;
  font-family: 'syht';
  margin: 0;
  font-style: normal;
  font-weight: 400;
}
@import 'styles/common.less';
@import 'styles/iconfont.css';
</style>
