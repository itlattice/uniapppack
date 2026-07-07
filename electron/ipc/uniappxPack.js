import { app, ipcMain } from 'electron'
import fs from 'fs'
import path from 'path'
import fsExtra from 'fs-extra'
import { spawn } from 'child_process'

// 这个文件是渲染层与本地 Android 打包核心之间的“唯一桥接层”。
// 设计目标：
// 1. 渲染层不直接接触 fs/path/模板渲染等 Node 能力。
// 2. 所有项目配置统一在主进程收口，再传给 core。
// 3. 输出目录统一规范为：配置的 packPath/appid/uniappx-native-android。

const projectRoot = path.resolve(process.cwd())
const localCoreRoot = path.join(projectRoot, 'src', 'pack', 'uniappx', 'core')
const localPackEntry = path.join(localCoreRoot, 'src', 'pack.js')

function getProjectRoot() {
  return projectRoot
}

function getAppConfigPath() {
  return path.join(app.getPath('userData'), 'config.json')
}

function readAppConfig() {
  const configPath = getAppConfigPath()
  if (!fs.existsSync(configPath)) {
    return {}
  }
  try {
    return JSON.parse(fs.readFileSync(configPath, 'utf-8'))
  } catch (error) {
    return {}
  }
}

function normalizePackType(packType) {
  // UI 里 packType 是 number，但经过 IPC 后可能是 string。
  // 这里统一成 core 里使用的 '1' / '2' 约定。
  if (packType === 2 || packType === '2') {
    return '2'
  }
  return '1'
}

function normalizeLogMessage(message) {
  // core 里既可能直接输出字符串，也可能输出 { line, nocolor } 这类对象。
  // 渲染层日志窗口只吃纯文本，因此在主进程先做一次统一归一化。
  if (message instanceof Error) {
    return message.stack || message.message
  }
  if (typeof message === 'string') {
    return message
  }
  if (message && typeof message === 'object') {
    if (typeof message.line === 'string') {
      return message.line
    }
    try {
      return JSON.stringify(message)
    } catch (error) {
      return String(message)
    }
  }
  return String(message ?? '')
}

function createConsoleLog(event) {
  // 将 core 的日志回传到渲染层弹窗。
  return (message, color) => {
    event.sender.send('uniappx:pack-log', {
      message: normalizeLogMessage(message),
      color,
    })
  }
}

function emitPackLog(event, message, color = 'white') {
  event.sender.send('uniappx:pack-log', {
    message: normalizeLogMessage(message),
    color,
  })
}

function getPackStart() {
  const packModule = require(localPackEntry)
  if (typeof packModule.start !== 'function') {
    throw new Error(`打包入口无效：${localPackEntry}`)
  }
  return packModule.start
}

function buildPackOptions(options, appConfig, event) {
  // 这里把“配置窗口里的环境设置”和“当前项目的打包参数”拼成 core 能直接消费的 options。
  // 关键约束：输出根目录必须是 packPath/appid，而不是单独的 packPath。
  const packPath = appConfig.packPath
  if (!packPath) {
    throw new Error('缺少打包输出目录，请先在配置中设置 packPath')
  }
  const appid = options.appid
  if (!appid) {
    throw new Error('缺少当前项目的 appid')
  }

  const uniappProjectPath = options.android?.path || options.uniappProjectPath
  if (!uniappProjectPath) {
    throw new Error('缺少 uni-app x 项目路径')
  }

  const androidLocalSdk = appConfig.uniAndroidSDK || appConfig.uniAndroidSdkPath
  if (!androidLocalSdk) {
    throw new Error('缺少 uni-app x Android 离线 SDK 路径')
  }

  const androidSdk = appConfig.AndroidSDK || appConfig.androidSdk || ''
  if (!androidSdk) {
    throw new Error('缺少 Android SDK 路径，请先在配置中设置 AndroidSDK')
  }

  return {
    root: localCoreRoot,
    baseProjectRoot: path.join(projectRoot, 'docs', 'src', 'easypackx'),
    sdkWorkspaceRoot: localCoreRoot,
    uniappxNativeAndroid: path.join(packPath, appid),
    uniappProjectPath,
    appid,
    androidLocalSdk,
    androidSdk,
    javaHome: appConfig.JDKPath || appConfig.javaHome || '',
    androidPackageName: options.android?.androidPackName || options.androidPackageName || '',
    storePath: options.android?.androidKeystore || options.storePath || '',
    storePassword: options.android?.androidKeyPassword || options.storePassword || '',
    keyAlias: options.android?.androidKeyAlias || options.keyAlias || '',
    keyPassword: options.android?.androidKeyPwd || options.keyPassword || '',
    nativeLibPickFirsts: options.android?.nativeLibPickFirsts || options.nativeLibPickFirsts || [],
    packType: normalizePackType(options.android?.packType || options.packType),
    customConsoleLog: createConsoleLog(event),
  }
}

function getGradleTask(packType) {
  return packType === '2' ? ':app:assembleRelease' : ':app:assembleDebug'
}

function getExpectedApkPath(projectDir, packType) {
  const outputDir = packType === '2'
    ? path.join(projectDir, 'app', 'build', 'outputs', 'apk', 'release')
    : path.join(projectDir, 'app', 'build', 'outputs', 'apk', 'debug')
  const fileName = packType === '2' ? 'app-release.apk' : 'app-debug.apk'
  return path.join(outputDir, fileName)
}

function getPackOutputPath(packPath, appid, packType, sourceApkPath) {
  if (packType === '2') {
    return path.join(packPath, `_${appid}.apk`)
  }
  return path.join(path.join(packPath, `_${appid}`), path.basename(sourceApkPath))
}

async function copyPackArtifacts({ appConfig, options, packOptions, projectDir, packType, event }) {
  const sourceApkPath = getExpectedApkPath(projectDir, packType)
  if (!fs.existsSync(sourceApkPath)) {
    throw new Error(`未找到构建产物：${sourceApkPath}`)
  }

  const appid = options.appid
  const targetApkPath = getPackOutputPath(appConfig.packPath, appid, packType, sourceApkPath)
  await fsExtra.ensureDir(path.dirname(targetApkPath))
  await fsExtra.copy(sourceApkPath, targetApkPath, { overwrite: true })
  emitPackLog(event, `APK 已复制到临时目录：${targetApkPath}`, '#67c23a')

  let debugProjectApkPath = ''
  if (packType === '1') {
    const debugOutputDir = path.join(packOptions.uniappProjectPath, 'unpackage', 'debug')
    await fsExtra.ensureDir(debugOutputDir)
    debugProjectApkPath = path.join(debugOutputDir, 'android_debug.apk')
    await fsExtra.copy(sourceApkPath, debugProjectApkPath, { overwrite: true })
    emitPackLog(event, `调试基座 APK 已复制到项目目录：${debugProjectApkPath}`, '#67c23a')
  }

  return {
    sourceApkPath,
    targetApkPath,
    debugProjectApkPath,
  }
}

async function runGradleBuild({ projectDir, packType, javaHome, event }) {
  const gradleTask = getGradleTask(packType)
  const gradlew = process.platform === 'win32' ? 'gradlew.bat' : './gradlew'
  emitPackLog(event, `开始执行构建：${gradlew} ${gradleTask}`, '#e6a23c')

  await new Promise((resolve, reject) => {
    const child = spawn(gradlew, [gradleTask, '--console=plain'], {
      cwd: projectDir,
      env: {
        ...process.env,
        ...(javaHome ? { JAVA_HOME: javaHome } : {}),
      },
      shell: process.platform === 'win32',
    })

    child.stdout.on('data', (data) => {
      const text = data.toString()
      text.split(/\r?\n/).filter(Boolean).forEach((line) => emitPackLog(event, line))
    })

    child.stderr.on('data', (data) => {
      const text = data.toString()
      text.split(/\r?\n/).filter(Boolean).forEach((line) => emitPackLog(event, line, '#f56c6c'))
    })

    child.on('error', (error) => {
      reject(error)
    })

    child.on('close', (code) => {
      if (code === 0) {
        resolve()
        return
      }
      reject(new Error(`Gradle 构建失败，退出码：${code}`))
    })
  })
}

async function generateAndroidGradleProject(event, options) {
  const appConfig = readAppConfig()
  const start = getPackStart()
  const packOptions = buildPackOptions(options, appConfig, event)
  event.sender.send('uniappx:pack-log', {
    message: `使用核心打包入口：${localPackEntry}`,
    color: 'white',
  })
  const projectDir = await start(packOptions)
  if (!projectDir) {
    throw new Error('原生工程生成失败，未拿到输出目录')
  }
  await runGradleBuild({
    projectDir,
    packType: packOptions.packType,
    javaHome: packOptions.javaHome,
    event,
  })
  const artifacts = await copyPackArtifacts({
    appConfig,
    options,
    packOptions,
    projectDir,
    packType: packOptions.packType,
    event,
  })
  return {
    projectDir,
    gradleTask: getGradleTask(packOptions.packType),
    ...artifacts,
  }
}

export function initUniappxPackHandlers() {
  // 渲染层只需要 invoke 这个 channel，不需要知道 core 的真实路径或参数结构。
  ipcMain.handle('uniappx:generate-android-gradle', async (event, options) => {
    return await generateAndroidGradleProject(event, options)
  })
}
