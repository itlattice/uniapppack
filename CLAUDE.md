# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## 项目概述

`uniapppack`（懒猿 UniAPP 打包机）是一个 **Electron + Vue 3** 桌面应用，用于对已本地发行的 **uni-app x** 工程做离线打包。

- **Android**：完整打包流程（生成原生工程 → Gradle 构建 → 输出 APK）
- **iOS**：生成原生工程并打开目录（不含 Xcode 编译/签名/IPA 导出），**仅支持 macOS**
- **传统 uni-app**：Tab 仍为占位

Node 要求：`^20.19.0 || >=22.12.0`（README 记录本机常用 `20.20.2`）。Windows 为主目标平台（iOS 功能需 macOS）。

## 常用命令

```bash
npm install

# 开发（Vite + Electron 主进程；脚本含 chcp 65001）
npm run electron:dev
# 等价于：npm run dev（同样会启动 Vite；electron:dev 额外设置 NODE_ENV=development）

# 仅构建前端产物到 dist/（不清空 outDir，避免误删 Electron 产物）
npm run build

# 打包安装包（vite build + electron-builder → dist_electron/）
npm run electron:build

# 从 public/icon.png 生成 build/icons
npm run electron:generate-icons

# 格式化 src/
npm run format
```

仓库内有 `.eslintrc.js` / Prettier / Husky + lint-staged，但 **没有独立的 `lint` / `test` npm script**，也没有可用的单元测试目录。不要假设存在 `npm test`。

CI 参考：`gitlab-ci.yml`（Node 20 + `electron:build`）；其中产物命名仍残留旧项目 `casher` 痕迹，改 CI 时注意核对。

## 架构总览

```
渲染进程 (Vue)                    主进程 (Electron)                        打包核心
src/views/Home.vue          →   electron/ipc/uniappxPack.js         →   src/pack/uniappx/core/src/pack.js (Android)
src/common/pack.js              (唯一桥接层)                             src/pack/uniappx/core/src/pack-ios.js (iOS)
src/components/pack.vue         拼装 options、回传日志                   Handlebars 模板 + 资源合并
                                Android: 执行 gradlew、复制 APK
                                iOS: shell.openPath 打开生成目录
```

### 分层约定（改打包逻辑时必须遵守）

1. **渲染层不直接做 fs / Gradle / 模板渲染。** `src/pack/uniappx/Android.js` 已刻意抛错，防止把 Node 打包逻辑写回渲染进程。
2. **渲染层入口**：`src/common/pack.js`
   - Android: `ipcRenderer.invoke('uniappx:generate-android-gradle', plainConfig)`
   - iOS: `ipcRenderer.invoke('uniappx:generate-ios-project', plainConfig)`
   - 监听 `uniappx:pack-log` 接收实时日志
3. **主进程桥接**：`electron/ipc/uniappxPack.js`
   - 读取 `%APPDATA%/.../config.json`（`app.getPath('userData')`）
   - 拼装 core 所需 `options`（`packPath`、SDK 路径、证书信息等）
   - Android: `require(pack.js).start(...)` → 执行 `gradlew :app:assembleDebug|Release` → 复制 APK
   - iOS: `require(pack-ios.js).start(...)` → 生成工程 → `shell.openPath()` 打开目录
4. **核心**：`src/pack/uniappx/core/src/`
   - `pack.js`：Android Gradle 工程生成、模块合并、SDK 合并（自 HBuilderX 离线打包插件思路迁入）
   - `pack-ios.js`：iOS Xcode 工程生成、Info.plist patch、启动入口修改（参考 `docs/wj-easypackx`，但裁剪掉 SDK 下载、UTS 插件构建、编译签名）

输出目录约定：
- Android: `packPath/<appid>/uniappx-native-android`；正式包 APK → `packPath/_<appid>.apk`，自定义基座 → 项目 `unpackage/debug/android_debug.apk`
- iOS: `packPath/<appid>/uniappx-native-ios`（含 `UniAppXDemo.xcworkspace` 或 `.xcodeproj`）

### UI / 状态

| 区域 | 作用 |
| --- | --- |
| `src/views/Home.vue` | 主界面：选项目、Android/iOS 双 Tab、证书/Bundle ID 表单、触发打包 |
| `src/components/configWindow.vue` | 全局环境配置（HBuilderX、离线 SDK、Android SDK、iOS SDK、JDK、Gradle、Studio、Xcode、临时目录） |
| `src/components/pack.vue` | 打包日志弹窗，按 `packPlatform` 分发到 Android/iOS 打包入口 |
| `src/common/packConfig.js` | 校验 `manifest.json` + `unpackage/resources/app-android|ios`；项目配置读写 SQLite；`$checkAndroidConfig()` / `$checkIosConfig()` 环境校验 |
| `src/common/pack.js` | 渲染层打包入口：`$packAndroidAppUniappx()` / `$packIosAppUniappx()`，包含平台专属 SDK/资源校验 |
| `src/common/*` | 渲染层 IPC 封装（`$` 前缀工具函数） |
| `src/store/config.js` | Pinia store（偏旧收银 UI 配置，打包主路径几乎不依赖） |

路径别名：`@` → `src/`（`vite.config.js` / `jsconfig.json`）。

组件：`src/main.js` 用 `import.meta.glob('./components/**/*.vue')` **全局自动注册**，组件名 = 文件名。

路由：仅 Hash 路由 `/` → `Home`（`src/router/index.js`）。

### Electron 主进程

- 入口：`electron/main.js`（`package.json` `main` → 构建后的 `dist-electron/main.js`）
- IPC 聚合：`electron/ipc/ipcHandlers.js` → `basic.js` / `config.js` / `uniappxPack.js`
- 无边框窗口、`nodeIntegration: true` + `contextIsolation: false`（渲染进程可直接 `window.require('electron')`）
- 单实例锁、托盘、关闭时隐藏而非退出
- SQLite：`electron/utils/sqlite.js`，库文件在 userData；表 `subject(path, config)` 缓存各项目证书等配置
- 应用配置：`electron/ipc/config.js` 读写 userData 下 `config.json`

`vite.config.js` 通过 `vite-plugin-electron` 打包主进程，并将 `electron-edge-js` / `sqlite3` / `bindings` / `node-gyp-build` 设为 external。

### docs/ 参考插件

`docs/` 下放了两个 HBuilderX 参考插件源码（见 `docs/参考组件.md`）：

- `docs/kux-easy-pack-hxp`
- `docs/wj-easypackx`（核心多在 `src/easypackx`）

`.gitignore` 含 `docs/*`，本地参考用；**产品路径应改 `src/pack/uniappx/core`，不要把运行时依赖绑死在 docs。**  
注意：`uniappxPack.js` 里仍有 `baseProjectRoot: .../docs/src/easypackx`，与当前 docs 目录布局不一致，改 base 工程路径时先核对实际磁盘结构。

## 打包前置条件（业务约束）

1. 用户须先在 HBuilderX 对目标 uni-app x 项目做**本地发行**：
   - Android: 存在 `项目/unpackage/resources/app-android`
   - iOS: 存在 `项目/unpackage/resources/app-ios`
2. 配置窗口必须填齐对应平台环境：
   - **Android**: `hbuildPath`、`packPath`、`uniAndroidSDK`（含 `SDK/libs`、`plugins`）、`uniAndroidSDKVersion`、`AndroidSDK`、`JDKPath`（建议 JDK 17）、`GradlePath`、`AndroidStudio`
   - **iOS**: `hbuildPath`、`packPath`、`uniIosSDK`（含 `UniAppXDemo`、`SDK`、`TemporarySampleFramework`）、`uniIosSDKVersion`；`XcodePath` 可选
3. `packType`：`1` = 自定义基座（debug），`2` = 正式包（release）。IPC 层会把 number/string 归一成 `'1'|'2'`。
4. 传给主进程的配置必须先 `JSON.parse(JSON.stringify(...))` 去掉 Vue 响应式，否则结构化克隆会失败（见 `src/common/pack.js`）。
5. **平台校验独立**：Android 打包只校验 Android SDK/资源，iOS 打包只校验 iOS SDK/资源，不交叉验证。

## 改动提示

- 改 Android Gradle 生成 / 模块合并 / SDK 合并：优先 `src/pack/uniappx/core/src/pack.js` + `*.hbs` + `utils/` + `parse/gradle-to-js.js`。
- 改 iOS 工程生成 / Info.plist patch / 启动入口：优先 `src/pack/uniappx/core/src/pack-ios.js`。
- 改参数拼装、日志回传、平台分发：只动 `electron/ipc/uniappxPack.js`。
- 改表单、校验、平台切换：`Home.vue` + `packConfig.js` + `configWindow.vue` + `pack.vue`。
- 原生依赖（sqlite3 等）走主进程 external；勿把 native 模块打进渲染 bundle。
- **新增平台功能时**：确保在 IPC 桥接层、core 模块、UI 校验链路均保持平台隔离，参考现有 Android/iOS 双轨实现。
