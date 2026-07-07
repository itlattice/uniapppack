import { app, BrowserWindow, Menu, protocol, Tray } from 'electron'
const isPackaged = app.isPackaged
import { initConfig } from './ipc/config.js'
import path from 'path'
import { initIpcHandlers } from './ipc/ipcHandlers.js'
import { connectDB } from './utils/sqlite.js' // SQLite 连接方法

let dirname = path.resolve()

const isDevelopment = !isPackaged

import { ipcMain, screen, dialog } from 'electron'

// ========== 全局变量 ==========
let mainWindow = null
let tray = null
let db = null // SQLite 数据库实例

// ========== 协议注册 ==========
protocol.registerSchemesAsPrivileged([
  { scheme: 'app', privileges: { secure: true, standard: true } },
])

// ========== 单实例锁 ==========
const gotTheLock = app.requestSingleInstanceLock()
if (!gotTheLock) {
  app.quit()
}

// 创建主窗口
function createWindow() {
  if (mainWindow) {
    mainWindow.show()
    return mainWindow
  }
  Menu.setApplicationMenu(null)
  mainWindow = new BrowserWindow({
    width: 900,
    height: 600,
    useContentSize: true,
    // 结束调试
    fullscreenable: false,
    fullscreen: false,
    frame: false,
    simpleFullscreen: true,
    resizable: false,
    webPreferences: {
      nodeIntegration: true,
      contextIsolation: false,
      enableRemoteModule: true,
      webSecurity: false,
    },
    icon: path.join(
      isDevelopment ? path.join(dirname, '/public/resources') : path.join(dirname, '/resources'),
      'icon/icon.ico',
    ),
  })

  // ========== 初始化 IPC 处理器（传递所有依赖） ==========
  try {
    initIpcHandlers({
      mainWin: mainWindow,
    })
    console.log('IPC handler 初始化成功')
  } catch (err) {
    console.error('IPC handler 初始化失败：', err)
  }

  // 窗口关闭逻辑
  mainWindow.on('close', (e) => {
    if (!app.isQuiting) {
      e.preventDefault()
      mainWindow.hide()
    }
  })

  // 开发环境：加载 Vite 服务
  if (isDevelopment) {
    mainWindow.loadURL('http://localhost:5173/')
    mainWindow.webContents.openDevTools()
  } else {
    const indexPath = path.join(app.getAppPath(), 'dist/index.html')
    console.log('正确路径：', indexPath)
    mainWindow.loadFile(indexPath).catch((err) => {
      console.error('错误：', err)
    })
    // mainWindow.webContents.openDevTools()
  }
}

// ========== 保留的 ipcMain.on 逻辑（非 handle 类型） ==========
ipcMain.on('dev-tools', () => {
  console.log('打开开发者工具')
  mainWindow.webContents.openDevTools()
})

ipcMain.on('show-context-menu', (event, data = []) => {
  const { x, y, elementId, menuItems } = data
  const menuTemplate = menuItems.map((item) => {
    if (item.role) return item
    if (item.action) {
      return {
        ...item,
        click: () => {
          console.log('点击菜单', item)
          event.sender.send('menu-item-click', {
            action: item.action,
            elementId,
            x,
            y,
            msg: `点击了【${item.label}】`,
          })
        },
      }
    }
    return item
  })
  console.log(menuTemplate)

  const menu = Menu.buildFromTemplate(menuTemplate)
  menu.popup({
    window: BrowserWindow.fromWebContents(event.sender),
    x,
    y,
    positioningItem: process.platform === 'darwin' ? 0 : -1,
  })
})

ipcMain.on('close', (e) => {
  if (process.platform === 'win32' && !app.isQuiting) {
    e.preventDefault()
    mainWindow.hide()
    return false
  }
  return true
})

ipcMain.on('restart', () => {
  app.relaunch()
  app.quit()
})

// ========== 应用生命周期 ==========
app.commandLine.appendSwitch('ignore-certificate-errors')
// 禁用 GPU 硬件加速（解决 AMD 显卡报错）
app.disableHardwareAcceleration()
// 初始化
app.whenReady().then(createWindow)

// 关闭窗口时退出（排除 macOS）
app.on('window-all-closed', () => {
  if (process.platform !== 'darwin') {
    if (!app.isQuiting) {
      return
    }
    app.quit()
  }
})

// macOS 激活应用
app.on('activate', () => {
  if (BrowserWindow.getAllWindows().length === 0) createWindow()
})

app.on('before-quit', () => {
  app.isQuiting = true
})

app.on('quit', () => {})

ipcMain.handle('quit-app', (event, folderPath) => {
  console.log('收到 quit-app 请求')
  app.isQuiting = true
  tray.destroy()
  app.quit()
})

// ========== 应用就绪初始化 ==========
app.on('ready', async () => {
  await createWindow()
  // createOtherWin();
  createTray()
  initConfig()
  db = await connectDB()
  // let s=await startListening();
  // console.log('监听启动结果',s);
  // setTimeout(async function (){
  //   s=await stopListening()
  //   console.log('关闭结果',s)
  // },5000)
})

// ========== 托盘逻辑 ==========
function createTray() {
  const resourcesPath = isDevelopment
    ? path.join(dirname, '/public/resources')
    : path.join(dirname, '/resources')
  console.log('资源路径:', resourcesPath)
  const trayIcon = path.join(resourcesPath, 'icon/icon.ico')
  tray = new Tray(trayIcon)

  const trayMenuTemplate = [
    {
      label: '显示窗口',
      click: () => {
        if (mainWindow.isDestroyed()) {
          createWindow()
        } else {
          mainWindow.show()
        }
      },
    },
    {
      label: '退出应用',
      click: () => {
        app.isQuiting = true
        tray.destroy()
        app.quit()
      },
    },
  ]
  const contextMenu = Menu.buildFromTemplate(trayMenuTemplate)
  tray.setContextMenu(contextMenu)
  tray.setToolTip('懒猿UniAPP打包机')

  tray.on('click', () => {
    if (mainWindow.isDestroyed()) {
      createWindow()
    } else {
      mainWindow.isVisible() ? mainWindow.hide() : mainWindow.show()
    }
  })
}
