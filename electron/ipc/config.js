import fs from 'fs-extra'
import path from 'path'
const { app, ipcMain } = require('electron')
const configPath = path.join(app.getPath('userData'), 'config.json')

// 外部依赖的变量/方法
let mainWindow = null
// 初始化方法（接收所有依赖）
export function initIpcConfigHandlers({ mainWin }) {
  mainWindow = mainWin
  console.log('开始注册所有 IPC handler...')
  regConfigIpc()
  console.log('所有 IPC handler 注册完成')
}

function regConfigIpc() {
  ipcMain.handle('initConfig', async (event) => {
    return await initConfig()
  })
  ipcMain.handle('readConfig', async (event) => {
    return await readConfig()
  })
  ipcMain.handle('writeConfig', async (event, config) => {
    console.log(config)
    return await writeConfig(config)
  })

  ipcMain.on('openDevTools', () => {
    console.log('打开开发者工具')
    mainWindow.webContents.openDevTools()
  })

}

// 初始化配置文件（如果不存在则创建）
export async function initConfig() {
  try {
    const exists = await fs.pathExists(configPath)
    if (!exists) {
      // 默认配置
      const defaultConfig = {

      }
      await fs.writeJson(configPath, defaultConfig, { spaces: 2 })
    }
  } catch (error) {
    console.error('初始化配置文件失败:', error)
  }
}

// 读取配置文件
async function readConfig() {
  try {
    await initConfig() // 确保配置文件存在
    const config = await fs.readJson(configPath)
    return config
  } catch (error) {
    console.error('读取配置文件失败:', error)
    return null
  }
}

// 写入配置文件
async function writeConfig(newConfig) {
  try {
    await initConfig() // 确保配置文件存在
    // 先读取原有配置，再合并新配置（避免覆盖全部）
    console.log('configPath',configPath)
    await fs.writeJson(configPath, newConfig, { spaces: 2 })
    return true
  } catch (error) {
    console.error('写入配置文件失败:', error)
    return false
  }
}
