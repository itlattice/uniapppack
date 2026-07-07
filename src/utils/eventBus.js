// src/utils/eventBus.js
import TinyEmitter from 'tiny-emitter'

// 1: 创建事件总线实例
const bus = new TinyEmitter()

// 2: 导出给组件外使用
export default bus
