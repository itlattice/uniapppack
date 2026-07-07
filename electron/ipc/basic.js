'use strict'
import { ipcMain, dialog, BrowserWindow, app, shell } from 'electron'
import fs from 'fs'
const fsPro = require('fs').promises // 使用promise版本的fs，支持async/await
const fsSync = require('fs') // 同步版fs，用于判断文件/文件夹类型
const path = require('path')
const sound = require('sound-play')

// 外部依赖的变量/方法
let mainWindow = null

// 初始化方法（接收所有依赖）
export function initIpcBasicHandlers({ mainWin }) {
  mainWindow = mainWin
  console.log('开始注册所有 IPC handler...')
  initBasicIpcHandlers()
  console.log('所有 IPC handler 注册完成')
}

function initBasicIpcHandlers() {
  // ========== window:close ==========
  ipcMain.handle('window:close', () => {
    console.log('触发 window:close handler')
    if (mainWindow) {
      mainWindow.hide()
    }
  })
  // ========== open-file-dialog ==========
  ipcMain.handle('open-file-dialog', async (event, options = {}) => {
    const defaultOptions = {
      title: '选择文件',
      defaultPath: app.getPath('documents'),
      properties: ['openFile'],
      filters: [],
    }
    const finalOptions = { ...defaultOptions, ...options }
    const result = await dialog.showOpenDialog(mainWindow, finalOptions)
    return {
      canceled: result.canceled,
      filePaths: result.filePaths,
    }
  })

  ipcMain.handle('get-resource-path', (event) => {
    var p = require('path')
    if (app == undefined) {
      return p.join(p.resolve(), '/public/resources')
    }
    return !app.isPackaged
      ? p.join(p.resolve(), '/public/resources')
      : p.join(p.resolve(), '/resources')
  })

  ipcMain.handle('open-url', async (event, url) => {
    shell.openExternal(url)
  })

  // ========== get-default-path ==========
  ipcMain.handle('get-default-path', (event, name) => {
    const downloadPath = app.getPath(name)
    return {
      path: downloadPath,
      platform: process.platform,
    }
  })

  // ========== check-and-create-folder ==========
  ipcMain.handle('check-and-create-folder', (event, folderPath) => {
    try {
      if (!fs.existsSync(folderPath)) {
        fs.mkdirSync(folderPath, { recursive: true })
        console.log(`文件夹创建成功：${folderPath}`)
      } else {
        console.log(`文件夹已存在：${folderPath}`)
      }
      return true
    } catch (error) {
      console.error('创建文件夹失败：', error)
      return false
    }
  })

  // ========== check-file-exists ==========
  ipcMain.handle('check-file-exists', (event, filePath) => {
    try {
      const stats = fs.statSync(filePath)
      return stats.isFile()
    } catch (error) {
      if (error.code === 'ENOENT') {
        return false
      }
      throw error
    }
  })
  // ========== read-local-file ==========
  ipcMain.handle('read-local-file', async (event, filePath, encoding = 'utf8') => {
    console.log('触发 read-local-file handler，文件路径：', filePath)
    try {
      const content = fs.readFileSync(filePath, encoding)
      console.log('读取文件成功，内容长度：', content.length)
      return content
    } catch (error) {
      console.error('读取文件失败：', error)
      return false
    }
  })
  ipcMain.handle('putConsole', async (event, content) => {
    console.log(content)
  })
  ipcMain.handle('push-pack-log', async (event, content) => {
    const logFile = path.join(app.getPath('userData'), 'packlog.log');
    fs.appendFileSync(logFile, content, 'utf8');
  })
  ipcMain.handle('appPath',async (event)=>{
    const appDir = path.dirname(app.getPath('exe'));
    return appDir;
  })
  //选择指定扩展名的文件
  ipcMain.handle('chooseFile',async (event,ext) => {
    const res=await dialog.showOpenDialog(mainWindow,{
      title: '选择文件',
      defaultPath: app.getPath('documents'),
      properties: ['openFile'],
      filters: [
        { name: `${ext} 文件`, extensions: [ext] }
      ]
    })
    if (res.canceled) {
      return null
    } else {
      return res.filePaths[0]
    }
  })
  ipcMain.handle('read-app-file', async (event, filePath, encoding = 'utf8') => {
    const resourcesPath = !app.isPackaged
      ? path.join(path.resolve(), '/public/resources')
      : path.join(path.resolve(), '/resources')
    filePath = path.join(resourcesPath, filePath)
    console.log('触发 read-local-file handler，文件路径：', filePath)
    try {
      const content = fs.readFileSync(filePath, encoding)
      console.log('读取文件成功，内容长度：', content.length)
      return content
    } catch (error) {
      console.error('读取文件失败：', error)
      return false
    }
  })
  //删除所有尺寸为0且扩展名为aria2的文件
  ipcMain.handle('deleteTargetFiles', async (event, folderPath) => {
    // 存储删除成功的文件路径和错误信息
    const deletedFiles = []
    const errors = []

    try {
      // 检查目标文件夹是否存在
      if (!fsSync.existsSync(folderPath)) {
        console.error('文件夹不存在')
        return null
      }
      // 开始处理目标文件夹
      await processDirectory(folderPath)
    } catch (err) {
      errors.push(`主处理流程错误: ${err.message}`)
      console.error(err)
    }

    return { deletedFiles, errors }
  })
  //删除整个文件夹
  ipcMain.handle('deletePath', async (event, folderPath) => {
    return await deleteFolderRecursively(folderPath)
  })
  //选择文件夹
  ipcMain.handle('choosePath', async (event, folderPath) => {
    const result = await dialog.showOpenDialog(mainWindow, {
      title: '选择文件夹',
      defaultPath: folderPath || app.getPath('documents'),
      properties: ['openDirectory'],
    })
    if (result.canceled) {
      return null
    } else {
      return result.filePaths[0]
    }
  })
  //判断文件夹是否存在
  ipcMain.handle('pathExists', async (event, folderPath) => {
    if (!fsSync.existsSync(folderPath)) {
      return false;
    }
    return true;
  })

  ipcMain.handle('send-email', (event, emailOptions) => {
    try {
      // 解构邮件参数
      const { to } = emailOptions

      // 拼接 mailto 链接（遵循 RFC 6068 标准）
      const mailtoUrl = `mailto:${to}`

      // 调用系统默认邮件客户端
      shell.openExternal(mailtoUrl)
      return { success: true, message: '已唤起邮件客户端' }
    } catch (error) {
      console.error('发送邮件失败:', error)
      return { success: false, message: '唤起邮件客户端失败：' + error.message }
    }
  })

  ipcMain.handle('playAndio', async (event, filePath) => {
    try {
      // 1. 判断是否是网络链接（http/https）
      const isNetworkUrl = filePath.startsWith('http://') || filePath.startsWith('https://')

      let playPath
      if (isNetworkUrl) {
        // 网络音频：直接使用
        playPath = filePath
      } else {
        // 本地音频：转为**绝对路径**（最稳，不会找不到文件）
        // 你传过来的 filePath 可以是相对项目根目录的路径，例如 "assets/notify.mp3"
        playPath = path.isAbsolute(filePath) ? filePath : path.join(__dirname, filePath)
      }
      // 2. 播放音频
      sound.play(playPath)
      return { success: true, message: '播放成功' }
    } catch (error) {
      console.error('播放失败：', error.message)
      return { success: false, message: error.message }
    }
  })

  ipcMain.handle('getsysteminfo', async (event) => {
    const os = require('os')
    const platform = process.platform
    // 系统内核版本
    const kernelVersion = os.release()
    // 系统架构
    const arch = os.arch()

    // 格式化系统名称和版本
    let osName = ''
    let osVersion = ''

    switch (platform) {
      case 'win32':
        osName = 'Windows'
        // Windows 版本解析（如 10.0.22621 → Windows 11/10）
        var winVersion = parseFloat(kernelVersion.split('.')[0] + '.' + kernelVersion.split('.')[1])
        if (winVersion >= 10.0) {
          osVersion = winVersion >= 10.0 && kernelVersion.includes('22') ? '11' : '10'
        } else if (winVersion === 6.3) {
          osVersion = '8.1'
        } else if (winVersion === 6.2) {
          osVersion = '8'
        } else if (winVersion === 6.1) {
          osVersion = '7'
        }
        break
      case 'darwin':
        osName = 'macOS'
        // macOS 版本转换（如 23.1.0 → Ventura 14.1）
        var macVersion = os.version()
        osVersion = macVersion.replace(
          /Darwin Kernel Version (\d+)\.(\d+)\.\d+: .+/,
          (_, major, minor) => {
            const macVersions = {
              23: 'Sonoma 14',
              22: 'Ventura 13',
              21: 'Monterey 12',
              20: 'Big Sur 11',
              19: 'Catalina 10.15',
            }
            return macVersions[major] || `macOS ${parseInt(major) - 9}.${minor}`
          },
        )
        break
      case 'linux':
        osName = 'Linux'
        osVersion = kernelVersion
        break
      default:
        osName = platform
        osVersion = kernelVersion
    }

    return {
      platform: platform, // 原始标识：win32/darwin/linux
      osName: osName, // 易读名称：Windows/macOS/Linux
      osVersion: osVersion, // 系统版本：10/11/Sonoma 14
      kernelVersion: kernelVersion, // 内核版本：如 10.0.22621
      arch: arch, // 系统架构：x64/arm64 等
    }
  })
}

// 递归处理文件夹
async function processDirectory(currentDir) {
  const deletedFiles = []
  const errors = []
  try {
    // 读取当前目录下的所有文件/文件夹
    const entries = await fsPro.readdir(currentDir, { withFileTypes: true })

    for (const entry of entries) {
      const fullPath = path.join(currentDir, entry.name)

      // 如果是子文件夹，递归处理
      if (entry.isDirectory()) {
        await processDirectory(fullPath)
      }
      // 如果是文件，判断是否需要删除
      else if (entry.isFile()) {
        try {
          // 获取文件信息（大小、扩展名等）
          const stats = await fsPro.stat(fullPath)
          const fileExt = path.extname(entry.name).toLowerCase()

          // 判断条件：大小<10字节 或 扩展名为.aria2
          const shouldDelete = stats.size < 10 || fileExt === '.aria2'

          if (shouldDelete) {
            // 删除文件
            await fsPro.unlink(fullPath)
            deletedFiles.push(fullPath)
            console.log(`已删除文件: ${fullPath}`)
          }
        } catch (err) {
          const errorMsg = `处理文件失败 ${fullPath}: ${err.message}`
          errors.push(errorMsg)
          console.error(errorMsg)
        }
      }
    }
  } catch (err) {
    const errorMsg = `读取目录失败 ${currentDir}: ${err.message}`
    errors.push(errorMsg)
    console.error(errorMsg)
  }
}

/**
 * 递归删除整个文件夹（包括所有文件和子文件夹）
 * @param {string} folderPath - 要删除的文件夹路径
 * @returns {Promise<{success: boolean, message: string, errors: string[]}>} 删除结果
 */
async function deleteFolderRecursively(folderPath) {
  const fs = require('fs').promises;
  const errors = [];

  try {
    // 1. 检查路径是否存在
    try {
      await fs.access(folderPath);
    } catch (err) {
      return {
        success: false,
        message: `文件夹不存在: ${folderPath}`,
        errors: [`文件夹不存在: ${folderPath}`],
      };
    }

    // 2. 检查是否是文件夹
    try {
      const stats = await fs.stat(folderPath);
      if (!stats.isDirectory()) {
        return {
          success: false,
          message: `指定路径不是文件夹: ${folderPath}`,
          errors: [`指定路径不是文件夹: ${folderPath}`],
        };
      }
    } catch (err) {
      return {
        success: false,
        message: `获取路径信息失败: ${err.message}`,
        errors: [`获取路径信息失败: ${err.message}`],
      };
    }

    // 3. 使用 rm 递归删除（Node.js 14+）
    await fs.rm(folderPath, {
      recursive: true,
      force: true,
      maxRetries: 3,
      retryDelay: 100
    });

    console.log(`已完全删除文件夹: ${folderPath}`);

    return {
      success: true,
      message: `文件夹已完全删除: ${folderPath}`,
      errors: [],
    };

  } catch (err) {
    const errorMsg = `删除文件夹失败: ${err.message}`;
    errors.push(errorMsg);
    console.error(`删除失败: ${folderPath}`, err);

    return {
      success: false,
      message: errorMsg,
      errors,
    };
  }
}

async function deleteDirContent(currentDir) {
  const errors = []

  try {
    const entries = await fs.readdir(currentDir, { withFileTypes: true })

    for (const entry of entries) {
      const fullPath = path.join(currentDir, entry.name)

      if (entry.isDirectory()) {
        // 先删除子文件夹的内容，再删除子文件夹本身
        await deleteDirContent(fullPath)
        try {
          await fs.rmdir(fullPath)
          console.log(`已删除空文件夹: ${fullPath}`)
        } catch (err) {
          const errorMsg = `删除文件夹失败 ${fullPath}: ${err.message}`
          errors.push(errorMsg)
          console.error(errorMsg)
        }
      } else if (entry.isFile()) {
        // 删除文件
        try {
          await fs.unlink(fullPath)
          console.log(`已删除文件: ${fullPath}`)
        } catch (err) {
          const errorMsg = `删除文件失败 ${fullPath}: ${err.message}`
          errors.push(errorMsg)
          console.error(errorMsg)
        }
      }
    }
  } catch (err) {
    const errorMsg = `读取目录内容失败 ${currentDir}: ${err.message}`
    errors.push(errorMsg)
    console.error(errorMsg)
  }
}
