import { ref, onUnmounted } from 'vue'
import {$toast} from "@/common/common";
import {ElMessage} from "element-plus";

const { ipcRenderer } = window.require('electron')
// --- 状态 ---
const clickCount = ref(0)
const isTriggered = ref(false)
let timer = null

// --- 触发功能（替换成你的逻辑） ---
const triggerAction = async () => {
    console.log('✅ 连击5次触发！执行自定义功能')
    // 在这里写你的业务逻辑
    // 例如：弹窗、API请求、路由跳转等
    // dev-tools
    ipcRenderer.send('openDevTools')
}

// --- 核心点击处理 ---
export const handleClick = () => {
    // 已触发则忽略
    if (isTriggered.value) return

    // 清除之前的定时器
    if (timer) {
        clearTimeout(timer)
        timer = null
    }

    // 增加计数
    clickCount.value++
    if(clickCount.value>2){
        ElMessage({
            message: '再点击'+(5-clickCount.value)+'次打开开发者工具',
            type:'primary',
            placement:'bottom-right',
        })
    }


    // 达到5次触发功能
    if (clickCount.value >= 5) {
        triggerAction()
        isTriggered.value = true
        clickCount.value = 5
        setTimeout(() => {
            isTriggered.value = false
            clickCount.value = 0
        },700)
        return
    }

    // 设置超时重置（700ms无操作归零）
    timer = setTimeout(() => {
        if (!isTriggered.value && clickCount.value > 0) {
            clickCount.value = 0
        }
        timer = null
    }, 700)
}

// --- 重置 ---
const resetCombo = () => {
    if (timer) {
        clearTimeout(timer)
        timer = null
    }
    clickCount.value = 0
    isTriggered.value = false
}

// 组件卸载时清理定时器
onUnmounted(() => {
    if (timer) {
        clearTimeout(timer)
        timer = null
    }
})