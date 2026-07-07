import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import { createPinia } from 'pinia'
import bus from './utils/eventBus'
import 'element-plus/dist/index.css'
import ElementPlus from 'element-plus'

const app = createApp(App)

// ======================================
// 全局自动注册 components 下所有 .vue 组件
// ======================================
const components = import.meta.glob('./components/**/*.vue', { eager: true })

for (const [path, component] of Object.entries(components)) {
  // 自动截取文件名作为组件名（不需要组件里写 name）
  const componentName = path.split('/').pop().replace('.vue', '')

  // 全局注册
  app.component(componentName, component.default)
  console.log('✅ 全局注册组件：', componentName)
}
app.config.globalProperties.$bus = bus
app.use(createPinia())
app.use(router)
app.use(ElementPlus)
app.mount('#app')
