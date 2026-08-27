# 懒猿 UniAPP 打包机

一款基于 Electron + Vue 3 构建的 **uni-app x** 和传统 **uni-app** 离线打包工具，提供可视化的 Android/iOS 原生工程生成和打包功能。

## ✨ 功能特性

- 🚀 **uni-app x 支持**

  - Android: 完整的 Gradle 构建流程（生成原生工程 → 构建 APK）
  - iOS: 生成 Xcode 原生工程（需在 macOS 环境手动编译）
- 📦 **传统 uni-app 支持**

  - Android: 离线打包生成 APK
  - iOS: 生成原生工程目录
- 🎯 **便捷特性**

  - 可视化配置界面，无需手动修改配置文件
  - 项目配置自动保存，支持多项目快速切换
  - 实时日志输出，打包过程透明可控
  - 自定义基座和正式包双模式支持

## 📋 环境要求

### 基础要求

- **Node.js**: `^20.19.0 || >=22.12.0`（推荐 `20.20.2`）
- **操作系统**: Windows（主要支持）/ macOS（iOS 打包功能需要）

### Android 打包环境

- **HBuilderX**: 包含 uni-app x 离线 SDK
- **Android SDK**: 包含构建工具和平台工具
- **JDK**: 推荐 JDK 17
- **Gradle**: 用于 Android 项目构建
- **Android Studio**: （可选）用于调试和进一步开发

### iOS 打包环境（仅 macOS）

- **HBuilderX**: 包含 uni-app x 离线 iOS SDK
- **Xcode**: （可选）用于后续编译和签名

## 🚀 快速开始

### 1. 安装依赖

```bash
npm install
```

### 2. 开发模式

```bash
npm run electron:dev
```

### 3. 构建安装包

```bash
npm run electron:build
```

构建产物位于 `dist_electron/` 目录。

## 📖 使用指南

详细的使用文档请参考：[docs/使用文档.md](docs/使用文档.md)

### 快速配置流程

1. **首次使用配置环境**

   - 点击右上角设置按钮
   - 配置 HBuilderX 路径、临时文件目录
   - 配置 Android/iOS 离线 SDK 及相关工具路径
2. **准备项目**

   - 在 HBuilderX 中对 uni-app x 项目执行"发行 → 本地打包"
   - 确保生成了 `unpackage/resources/app-android` 或 `app-ios` 资源
3. **开始打包**

   - 选择项目目录
   - 填写包名/Bundle ID、证书信息
   - 点击"打包"或"生成工程"按钮

## 🛠 开发说明

### 项目结构

```
uniapppack/
├── src/                          # 渲染进程（Vue）
│   ├── views/                    # 页面组件
│   ├── components/               # UI 组件
│   ├── common/                   # 工具函数
│   ├── pack/                     # 打包核心模块
│   │   └── uniappx/
│   │       └── core/             # 打包核心逻辑
│   │           └── src/
│   │               ├── pack.js       # Android 打包入口
│   │               └── pack-ios.js   # iOS 打包入口
│   └── store/                    # Pinia 状态管理
├── electron/                     # 主进程
│   ├── main.js                   # Electron 入口
│   ├── ipc/                      # IPC 通信模块
│   │   ├── uniappxPack.js        # 打包桥接层（核心）
│   │   ├── basic.js              # 基础 IPC
│   │   └── config.js             # 配置管理
│   └── utils/                    # 工具模块
│       └── sqlite.js             # 项目配置数据库
├── public/                       # 静态资源
├── build/                        # 构建资源（图标等）
└── docs/                         # 文档和参考资料
```

### 架构说明

本项目采用 **分层架构**，严格区分渲染层和主进程职责：

- **渲染层** (`src/`): 仅负责 UI 交互和表单校验
- **IPC 桥接** (`electron/ipc/uniappxPack.js`): 拼装配置、调度核心模块、回传日志
- **核心模块** (`src/pack/uniappx/core/`): 执行实际的工程生成和构建任务

> **重要**: 渲染层代码禁止直接调用 Node.js 文件系统 API 或执行打包逻辑，所有操作需通过 IPC 与主进程通信。

### 可用命令

```bash
# 开发
npm run electron:dev          # 启动开发模式（Vite + Electron）
npm run dev                   # 同上（仅启动 Vite）

# 构建
npm run build                 # 仅构建前端到 dist/
npm run electron:build        # 完整打包（前端 + Electron 安装包）

# 工具
npm run format                # 格式化 src/ 代码
npm run electron:generate-icons  # 从 public/icon.png 生成多尺寸图标
```

## 📝 注意事项

1. **项目必须先在 HBuilderX 本地发行**打包机依赖 `unpackage/resources/app-android` 或 `app-ios` 资源，请确保在 HBuilderX 中完成本地发行操作。
2. **iOS 打包限制**当前版本仅生成 iOS 原生工程，不执行 Xcode 编译、签名和 IPA 导出，需手动在 macOS 上使用 Xcode 完成后续步骤。
3. **证书和密钥管理**Android 证书文件和密码会保存在本地 SQLite 数据库中（userData 目录），请妥善保管配置文件。
4. **兼容性说明**

   - 最高支持 HBuilderX 5.14 版本
   - 主要在 Windows 11 上测试，macOS 支持待进一步验证

## 🤝 贡献

欢迎提交 Issue 和 Pull Request！

## 📄 许可证

本项目遵循项目内部协议，请勿用于商业用途。

## 👨‍💻 作者

**itlattice** - IT格子 （itlattice@gmail.com）

---

**版本**: v1.0.0
**更新日期**: 2026-08-27
