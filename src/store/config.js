import { defineStore, mapState } from 'pinia'
import { loadBasicConfig } from '@/common/api'

// 第一个参数是唯一 id（类似 Vuex 模块名）
export const useConfigStore = defineStore('config', {
  // 对应 Vuex state
  state: () => ({
    login_background: '',
    login_logo: '',
    shop_name: '',
    shop_logo: '',
  }),
  getters: {},
  // 对应 Vuex actions + mutations（Pinia 合并了，直接改 state）
  actions: {
    async newConfig() {
      let config = await loadBasicConfig()
      //把config全部参数赋值到state
      this.$state = { ...this.$state, ...config }
    },
  },
})
