# EasyPackX Core

`src/easypackx` 是 EasyPackX 的本地 Android 离线打包核心，供 HBuilderX 插件入口调用。

## 运行方式

插件会从表单中读取项目路径、Android SDK、JDK、签名和模块配置，然后调用 `src/pack.js` 执行本地构建。

命令行调试可以在本目录执行：

```shell
npm install
npm run doctor
npm run start
```

## 配置说明

`.env.template` 仅用于命令行调试。HBuilderX 插件运行时优先使用插件表单和 `easypackx.*` 配置项。

```dotenv
UNIAPP_NAME=demo-app
SDK_DOWNLOAD_URL=https://web-ext-storage.dcloud.net.cn/uni-app-x/sdk/Android/Android-uni-app-x-SDK@14694-5.07.zip
LOCAL_PACK=true
STORE_PASSWORD=adminadmindebug
KEY_ALIAS=androiddebugkey
KEY_PASSWORD=adminadmindebug
```

## 发布注意

不要提交 `node_modules`、SDK 缓存、生成的原生工程和日志文件。核心源码、模板和基础原生工程需要随仓库发布。
