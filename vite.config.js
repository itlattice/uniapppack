import { fileURLToPath } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import electron from 'vite-plugin-electron'
import electronRenderer from 'vite-plugin-electron-renderer'

const electronMainExternals = ['electron-edge-js', 'sqlite3', 'bindings', 'node-gyp-build']

// https://vite.dev/config/
export default defineConfig({
  base: './',
  plugins: [
    vue(),
    electronRenderer(),
    electron({
      entry: 'electron/main.js',
      vite: {
        optimizeDeps: {
          exclude: electronMainExternals,
        },
        build: {
          rollupOptions: {
            external: electronMainExternals,
          },
        },
      },
    }),
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url)),
    },
  },
  build: {
    // 打包时不清空目录（避免 Electron 构建产物被删）
    emptyOutDir: false,
  },
})
