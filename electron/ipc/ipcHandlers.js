import { initIpcBasicHandlers } from './basic'
import { initIpcConfigHandlers } from './config'
import { initUniappxPackHandlers } from './uniappxPack'
import {shell} from "electron";

// 外部依赖的变量/方法
let mainWindow = null

// 初始化方法（接收所有依赖）
export function initIpcHandlers({ mainWin }) {
  mainWindow = mainWin
  console.log('开始注册所有 IPC handler...')
  registerAllHandlers()
  console.log('所有 IPC handler 注册完成')
  mainWindow.webContents.setWindowOpenHandler(({ url }) => {
    // 当页面尝试打开新窗口时
    if (url.includes('doc.dcloud.net.cn')) {
      shell.openExternal(url);
      return { action: 'deny' }; // 阻止 Electron 创建新窗口
    }
    // 对于其他链接，可以允许在 Electron 内打开，或同样使用外部浏览器
    return { action: 'allow' };
  });
}

// 注册所有 IPC 处理器（包含错误捕获）
function registerAllHandlers() {
  try {
    //===========基础函数注册============
    initIpcBasicHandlers({
      mainWin: mainWindow,
    })
    //==========配置文件相关==================
    initIpcConfigHandlers({
      mainWin: mainWindow,
    })
    initUniappxPackHandlers()
  } catch (e) {
    console.error(e)
  }
}
